/*
 * @bot-written
 *
 * WARNING AND NOTICE
 * Any access, download, storage, and/or use of this source code is subject to the terms and conditions of the
 * Full Software Licence as accepted by you before being granted access to this source code and other materials,
 * the terms of which can be accessed on the Codebots website at https://codebots.com/full-software-licence. Any
 * commercial use in contravention of the terms of the Full Software Licence may be pursued by Codebots through
 * licence termination and further legal action, and be required to indemnify Codebots for any loss or damage,
 * including interest and costs. You are deemed to have accepted the terms of the Full Software Licence on any
 * access, download, storage, and/or use of this source code.
 *
 * BOT WARNING
 * This file is bot-written.
 * Any changes out side of "protected regions" will be lost next time the bot makes any changes.
 */

import {Component, EventEmitter, Input, OnChanges, OnInit, OnDestroy, Output, SimpleChanges} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {Observable, Subject, Subscription} from 'rxjs';
import { ActivatedRoute, NavigationExtras } from '@angular/router';
import {debounceTime, distinctUntilChanged, map, filter} from 'rxjs/operators';
import {Store, Action as NgRxAction} from '@ngrx/store';
import * as routingAction from 'src/app/lib/routing/routing.action';
import {Group, ModelProperty, ModelRelation} from 'src/app/lib/models/abstract.model';
import * as modelAction from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.action';
import {BpjsServiceMappingModelState, BpjsServiceMappingModelAudit} from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.state';
import {BpjsServiceMappingModel} from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model';
import {
	getBpjsServiceMappingModelAuditsByEntityId,
	getBpjsServiceMappingModelWithId,
	getCountBpjsServiceMappingModels,
} from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {BpjsClaimSubmissionModel} from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import * as bpjsClaimSubmissionModelAction from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.action';
import {
	getBpjsClaimSubmissionCollectionModels, getBpjsClaimSubmissionModelWithId,
} from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import {BpjsControlPlanModel} from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model';
import * as bpjsControlPlanModelAction from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model.action';
import {
	getBpjsControlPlanCollectionModels, getBpjsControlPlanModelWithId,
} from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model.selector';
import {BpjsHospitalizationPlanModel} from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model';
import * as bpjsHospitalizationPlanModelAction from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.action';
import {
	getBpjsHospitalizationPlanCollectionModels, getBpjsHospitalizationPlanModelWithId,
} from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.selector';
import {BpjsPatientReferralModel} from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model';
import * as bpjsPatientReferralModelAction from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.action';
import {
	getBpjsPatientReferralCollectionModels, getBpjsPatientReferralModelWithId,
} from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import {ServiceModel} from 'src/app/models/service/service.model';
import * as serviceModelAction from 'src/app/models/service/service.model.action';
import {
	getServiceCollectionModels, getServiceModelWithId,
} from 'src/app/models/service/service.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../bpjs-service-mapping-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-bpjs-service-mapping-crud-edit',
	templateUrl: './bpjs-service-mapping-crud-edit.component.html',
	styleUrls: [
		'./bpjs-service-mapping-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class BpjsServiceMappingCrudEditComponent
		// % protected region % [Add any additional interfaces to implement here] off begin
		implements OnInit, OnChanges, OnDestroy
		// % protected region % [Add any additional interfaces to implement here] end
{

	/************************************************************************
	 *	   _____             __ _         ______ _      _     _
	 *  / ____|           / _(_)       |  ____(_)    | |   | |
	 * | |     ___  _ __ | |_ _  __ _  | |__   _  ___| | __| |___
	 * | |    / _ \| '_ \|  _| |/ _` | |  __| | |/ _ \ |/ _` / __|
	 * | |___| (_) | | | | | | | (_| | | |    | |  __/ | (_| \__ \
	 *  \_____\___/|_| |_|_| |_|\__, | |_|    |_|\___|_|\__,_|___/
	 *                           __/ |
	 *                          |___/
	 ************************************************************************/
	/**
	 * Whether route component
	 */
	@Input()
	singlePageComponent = false;

	/**
	 * Whether in create/edit/view mode
	 * Only used when singlePageComponent is turned on
	 * Routing will overwrite this according to the url path
	 */
	@Input()
	tileMode: CrudTileMode = CrudTileMode.Create;

	/**
	 * Id of entity to display
	 * Only used when singlePageComponent is turned on
	 */
	@Input()
	targetModelId: string;

	/**
	 * How many items are included in this page.
	 */
	@Input()
	pageSize: number = 10;

	// % protected region % [Change your collection id if required here] off begin
	/**
	 * The collection id used in the store
	 * Default to be the uuid of the tile, you could change this to custom id you want to share in different component
	 *
	 */
	@Input()
	collectionId: string = 'd5ff13f7-d3ed-4261-8318-e7195a828b48';
	// % protected region % [Change your collection id if required here] end

	/**
	 * Event emitter when user clicking button to change mode of tile
	 */
	@Output()
	tileModeChange: EventEmitter<{tileMode: CrudTileMode, payload?: any}> = new EventEmitter();

	/**
	 * Whether componet is view only
	 */
	get isViewOnly(): boolean {
		return this.tileMode === CrudTileMode.View;
	}

	/**
	 * Entity audits to be fetched from the server.
	 */
	bpjsServiceMappingAudits$: Observable<BpjsServiceMappingModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and BPJS Service Mapping here] off begin
	serviceMultiCrudActive: boolean = false;
	serviceDisplayName = 'Service';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and BPJS Service Mapping here] end
	serviceOppositeRelation = 'bpjsServiceMapping';
	serviceRelations: ModelRelation[] = this.serviceMultiCrudActive ? ServiceModel.getRelations()
		.map(relation => {
			if (relation.id === this.serviceOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Service Mapping and BPJS Claim Submissions here] off begin
	bpjsClaimSubmissionsMultiCrudActive: boolean = false;
	bpjsClaimSubmissionsDisplayName = 'BPJS Claim Submissions';
	bpjsClaimSubmissionsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Service Mapping and BPJS Claim Submissions here] end
	bpjsClaimSubmissionsOppositeRelation = 'bpjsServiceMapping';
	bpjsClaimSubmissionsRelations: ModelRelation[] = this.bpjsClaimSubmissionsMultiCrudActive ? BpjsClaimSubmissionModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsClaimSubmissionsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Service Mapping and BPJS Control Plans here] off begin
	bpjsControlPlansMultiCrudActive: boolean = false;
	bpjsControlPlansDisplayName = 'BPJS Control Plans';
	bpjsControlPlansCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Service Mapping and BPJS Control Plans here] end
	bpjsControlPlansOppositeRelation = 'bpjsServiceMapping';
	bpjsControlPlansRelations: ModelRelation[] = this.bpjsControlPlansMultiCrudActive ? BpjsControlPlanModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsControlPlansOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Service Mapping and BPJS Patient Referrals here] off begin
	bpjsPatientReferralsMultiCrudActive: boolean = false;
	bpjsPatientReferralsDisplayName = 'BPJS Patient Referrals';
	bpjsPatientReferralsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Service Mapping and BPJS Patient Referrals here] end
	bpjsPatientReferralsOppositeRelation = 'bpjsServiceMapping';
	bpjsPatientReferralsRelations: ModelRelation[] = this.bpjsPatientReferralsMultiCrudActive ? BpjsPatientReferralModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsPatientReferralsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Service Mapping and poliKontrol here] off begin
	polikontrolMultiCrudActive: boolean = false;
	polikontrolDisplayName = 'poliKontrol';
	polikontrolCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Service Mapping and poliKontrol here] end
	polikontrolOppositeRelation = 'bpjsServiceMapping';
	polikontrolRelations: ModelRelation[] = this.polikontrolMultiCrudActive ? BpjsHospitalizationPlanModel.getRelations()
		.map(relation => {
			if (relation.id === this.polikontrolOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = BpjsServiceMappingModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = BpjsServiceMappingModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = BpjsServiceMappingModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'service' && this.serviceMultiCrudActive) {
					exp.fields = ServiceModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsClaimSubmissions' && this.bpjsClaimSubmissionsMultiCrudActive) {
					exp.fields = BpjsClaimSubmissionModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsControlPlans' && this.bpjsControlPlansMultiCrudActive) {
					exp.fields = BpjsControlPlanModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsPatientReferrals' && this.bpjsPatientReferralsMultiCrudActive) {
					exp.fields = BpjsPatientReferralModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'polikontrol' && this.polikontrolMultiCrudActive) {
					exp.fields = BpjsHospitalizationPlanModel.getProps().map(prop => {
						return prop.name;
					});
				}

				return exp;
			}
		);
		return expands;
	}
	// % protected region % [Change your default expands if required here] end

	/**
	 * The model to be created or edited depending on what the model currently is.
	 */
	targetModel: BpjsServiceMappingModel;

	/**
	 * The form group created from the target model
	 */
	modelFormGroup: FormGroup;

	/**
	 * The current router state when this page is displayed.
	 */
	routerState: RouterState;

	/**
	 * Unsubscribe from this subscription when the crud component is destroyed
	 */
	routerStateSubscription$: Subscription;

	/**
	 * The Names of the buttons to be passed to the crud edit page for adding additional entities to the multi crud view.
	 * This requires a list of strings, where each string will become a button which sends an event back to onMultiEntityAction()
	 */
	defaultMultiEntityButtons: {name: string, many: boolean}[] = [];


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		private readonly store: Store<{ model: BpjsServiceMappingModelState }>,
		private readonly routerStore: Store<{ router: RouterState }>,
		private readonly activatedRoute: ActivatedRoute,
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnChanges(changes: SimpleChanges) {
		// % protected region % [Add any additional ngOnChanges logic before the main body here] off begin
		// % protected region % [Add any additional ngOnChanges logic before the main body here] end

		// % protected region % [Customise the ngOnChanges main body here] off begin
		if (changes.hasOwnProperty('tileMode') || changes.hasOwnProperty('targetModelId')) {
			this.initializeTargetModel();
		}
		// % protected region % [Customise the ngOnChanges main body here] end

		// % protected region % [Add any additional ngOnChanges logic after the main body here] off begin
		// % protected region % [Add any additional ngOnChanges logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnInit() {
		// % protected region % [Add any additional ngOnInit logic before the main body here] off begin
		// % protected region % [Add any additional ngOnInit logic before the main body here] end

		this.initialiseMultiEntityCollections();

		this.routerStateSubscription$ = this.routerStore.select(getRouterState).subscribe(routerState => {
				this.routerState = routerState;
				this.initializeTargetModel();
			}
		);

		let firstTime = true; // ensures that the user isn't instantly navigated back to the list page
		/**
		 * Tile Mode Change will not be triggered until the creation action has been dispatched and completed
		 * Subscribing in ngOnInit ensures that a count models action can be passed as an afterwards action, so the
		 * subscribed code will not be triggered until after the creation has been completed
		 */
		this.creationNavigationSubscription$.add(this.store.select(getCountBpjsServiceMappingModels).subscribe(count => {
			if (this.singlePageComponent && !firstTime) {
				this.triggerTileModeChange(CrudTileMode.List);
			}

			firstTime = false;
		}));

		// % protected region % [Add any additional ngOnInit logic after the main body here] off begin
		// % protected region % [Add any additional ngOnInit logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnDestroy() {
		// % protected region % [Add any additional ngOnDestroy logic before the main body here] off begin
		// % protected region % [Add any additional ngOnDestroy logic before the main body here] end

		if (this.routerStateSubscription$) {
			this.routerStateSubscription$.unsubscribe();
		}

		if (this.creationNavigationSubscription$) {
			this.creationNavigationSubscription$.unsubscribe();
		}

		// % protected region % [Add any additional ngOnDestroy logic after the main body here] off begin
		// % protected region % [Add any additional ngOnDestroy logic after the main body here] end
	}

	/**
	 * Initialize target model when input fields changed or router changed
	 */
	private initializeTargetModel() {
		// % protected region % [Add any additional initializeTargetModel logic before the main body here] off begin
		// % protected region % [Add any additional initializeTargetModel logic before the main body here] end

		if (!this.singlePageComponent) {
			this.initWithRouting();
		}

		// When tile mode is not defiend, reutrn directly without fetching data
		if (this.tileMode === undefined) {
			return;
		}

		this.resetPropsAndRels();
		this.prepareReferenceCollections();
		this.createReactiveForm();

		if (this.tileMode === CrudTileMode.Edit || this.tileMode === CrudTileMode.View) {
			// % protected region % [Add additional processing for View and Edit mode before the main body here] off begin
			// % protected region % [Add additional processing for View and Edit mode before the main body here] end

			this.fetchEntity();

			// % protected region % [Add additional processing for View and Edit mode after the main body here] off begin
			// % protected region % [Add additional processing for View and Edit mode after the main body here] end
		} else if (this.tileMode === CrudTileMode.Create) {
			// % protected region % [Add additional processing for Create mode before the main body here] off begin
			// % protected region % [Add additional processing for Create mode before the main body here] end

			this.targetModel = new BpjsServiceMappingModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.bpjsServiceMappingAudits$ = this.store.select(getBpjsServiceMappingModelAuditsByEntityId, this.targetModelId);
		}

		// % protected region % [Add any additional initializeTargetModel logic after the main body here] off begin
		// % protected region % [Add any additional initializeTargetModel logic after the main body here] end
	}

	/**
	 * Function to initialize the component fields according to the routing
	 * Method only be invoked when routing is enabled
	 */
	private initWithRouting() {
		// % protected region % [Override the initWithRouting method body here] off begin
		this.targetModelId = this.routerState.params.id;
		if (this.routerState.urls.includes('view')) {
			this.tileMode = CrudTileMode.View;
		} else if (this.routerState.urls.includes('edit')) {
			this.tileMode = CrudTileMode.Edit;
		} else if (this.routerState.urls.includes('create')) {
			this.tileMode = CrudTileMode.Create;
		} else {
			this.tileMode = undefined;
		}
		// % protected region % [Override the initWithRouting method body here] end
	}

	/**
	 * Initialize and dispatch event to fetch data from serverside
	 */
	private fetchEntity() {
		const stateConfig: PassableStateConfig<BpjsServiceMappingModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.BpjsServiceMappingAction(
			modelAction.BpjsServiceMappingModelActionTypes.FETCH_BPJS_SERVICE_MAPPING,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getBpjsServiceMappingModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new BpjsServiceMappingModel(model);
			model.syncRelations();

			this.targetModel = model;
			if (this.targetModel) {
				this.modelFormGroup.patchValue(this.targetModel);
			}

			this.multiCrudFetchAdditionalEntities();

			// % protected region % [Add additional actions after setting targetModel here] off begin
			// % protected region % [Add additional actions after setting targetModel here] end
		}));
	}

	/**
	 * This method iterates through all of the relations in the relations array and performs logic to fetch all of the entities to be shown
	 * in the dropdowns. This method does not need to be modified if you add additional entities to your crud list, as it will process all
	 * relations given to it
	 */
	private prepareReferenceCollections() {
		// % protected region % [Add any additional code here before the main logic of prepareReferenceCollections] off begin
		// % protected region % [Add any additional code here before the main logic of prepareReferenceCollections] end

		let updatedRelationsArray: ModelRelation[] = [];

		this.modelRelations.forEach(relation => {
			updatedRelationsArray.push(this.prepareSingleReferenceCollection(relation));
		});

		// % protected region % [Add any additional code here after the main logic of prepareReferenceCollections] off begin
		// % protected region % [Add any additional code here after the main logic of prepareReferenceCollections] end

		this.modelRelations = updatedRelationsArray;
	}

	/**
	 * Prepare the collection for a single Model Relation.  This method is called once for each relation in the modelRelations array,
	 * although there are use cases for processing other relations individually.  Calling prepareReferenceCollections within a subscription
	 * is not recommended, as it will cause a feedback loop which will require a reload to fix.  Therefore, abstracting this logic out allows
	 * for preparing reference collections for multi entity crud for 1:M relations.
	 *
	 * @param relation The relation to prepare the collection for
	 * @returns the same relation, with some additional parameters added following the creation of the collection
	 */
	prepareSingleReferenceCollection(relation: ModelRelation, uniqueCollectionId?: string) {
		let referenceRequirements: PrepareReferenceRequirements;
		referenceRequirements = fetchPrepareReferenceRequirements(relation.entityName);
		relation.stateConfig = {
			pageIndex: 0,
			pageSize: this.pageSize,
			collectionId: uniqueCollectionId ? uniqueCollectionId : this.collectionId
		} as PassableStateConfig<any>;

		this.store.dispatch(new referenceRequirements.baseAction(
			referenceRequirements.initCollectionAction,
			relation.stateConfig
		));

		this.addSearchFunction(relation,
				referenceRequirements.collectionModelsSelector,
				referenceRequirements.baseAction,
				referenceRequirements.fetchWithQueryAction);

		this.store.dispatch(new referenceRequirements.baseAction(
			referenceRequirements.fetchAllAction,
			relation.stateConfig
		));

		return relation;
	}

	/**
	 * Add the search function for each of the relations.
	 *
	 */
	private addSearchFunction(modelRelation: ModelRelation, modelSelector: any, action: new (...args: any[]) => NgRxAction, actionType: string) {
		// % protected region % [Add any additional code before the main logic of addSearchFunction here] off begin
		// % protected region % [Add any additional code before the main logic of addSearchFunction here] end

		modelRelation.searchFunction = new Subject<string>();
		modelRelation.collection = this.store.select(modelSelector, this.collectionId);
		this.creationNavigationSubscription$.add(modelRelation.searchFunction.pipe(
			debounceTime(500),
			distinctUntilChanged(),
			filter(value => value != null)
		).subscribe(
			(term: string) => {
				modelRelation.stateConfig.queryParams = {
					pageSize: this.pageSize,
					pageIndex: 0,
					where: [
						[
							{
								path: modelRelation.displayName,
								operation: QueryOperation.CONTAINS,
								value: term
							}
						]
					]
				};

				// % protected region % [Add any additional logic to the search subscription before dispatch here] off begin
				// % protected region % [Add any additional logic to the search subscription before dispatch here] end

				this.store.dispatch(new action(
					actionType,
					modelRelation.stateConfig
				));

				// % protected region % [Add any additional logic to the search subscription after dispatch here] off begin
				// % protected region % [Add any additional logic to the search subscription after dispatch here] end
			}
		));

		// % protected region % [Add any additional code after the main logic of addSearchFunction here] off begin
		// % protected region % [Add any additional code after the main logic of addSearchFunction here] end
	}

	/**
	 * Chang tile mode based on action and whether using routing
	 */
	private triggerTileModeChange(tileMode: CrudTileMode, id?: string, other?: object) {
		if (this.singlePageComponent) {
			this.tileModeChange.emit({
				tileMode: tileMode,
				payload: {
					id: id,
					...other
				}
			});
		} else {
			let extras: NavigationExtras = {};


			const commands = [];

			commands.push(this.routerState.urls[0]);

			if (tileMode !== CrudTileMode.List) {
				commands.push('bpjs-service-mapping');
				commands.push(tileMode.toString());
			}

			if (id) {
				commands.push(id);
			}

			this.routerStore.dispatch(new routingAction.NavigateRoutingAction(commands, extras));
		}
	}

	/**
	 * Triggered when the user clicks on the "View History" button.
	 */
	onViewHistory() {
		// % protected region % [Add any additional onViewHistory logic before the main body here] off begin
		// % protected region % [Add any additional onViewHistory logic before the main body here] end

		this.store.dispatch(new modelAction.BpjsServiceMappingAction(
			modelAction.BpjsServiceMappingModelActionTypes.FETCH_BPJS_SERVICE_MAPPING_AUDITS_BY_ENTITY_ID,
			{
				targetModelId: this.targetModelId
			}
		));

		// % protected region % [Add any additional onViewHistory logic after the main body here] off begin
		// % protected region % [Add any additional onViewHistory logic after the main body here] end
	}

	/**
	 * Triggered when the `Create` or `Save` button is clicked in the child create/edit view.
	 */
	onCreateOrSaveClicked(event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }) {
		// % protected region % [Add any additional onCreateOrSaveClicked logic before the main body here] off begin
		// % protected region % [Add any additional onCreateOrSaveClicked logic before the main body here] end

		this.targetModel = this.addAdditionalEntitiesToModel(this.targetModel, event);

		if (event.isCreate) {
			let stateConfig: PassableStateConfig<BpjsServiceMappingModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.serviceMultiCrudActive || this.bpjsClaimSubmissionsMultiCrudActive || this.bpjsControlPlansMultiCrudActive || this.bpjsPatientReferralsMultiCrudActive || this.polikontrolMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the creation state config here] off begin
				// % protected region % [Add any additional attributes to the creation state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				afterwardActions = [
					// % protected region % [Add any additional afterwards actions for single page creation here] off begin
					// % protected region % [Add any additional afterwards actions for single page creation here] end
					// Count the models to trigger the tile mode change, as the count will have changed after creation
					new modelAction.BpjsServiceMappingAction(
						modelAction.BpjsServiceMappingModelActionTypes.COUNT_BPJS_SERVICE_MAPPINGS,
						null
					)
				];
			} else {
				afterwardActions = [
					// % protected region % [Add any additional afterwards actions for creation here] off begin
					// % protected region % [Add any additional afterwards actions for creation here] end
					new routingAction.BackRoutingAction()
				];
			}

			// % protected region % [Add any additional logic before creating a new model here] off begin
			// % protected region % [Add any additional logic before creating a new model here] end

			this.store.dispatch(new modelAction.BpjsServiceMappingAction(
				modelAction.BpjsServiceMappingModelActionTypes.CREATE_BPJS_SERVICE_MAPPING,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<BpjsServiceMappingModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.serviceMultiCrudActive || this.bpjsClaimSubmissionsMultiCrudActive || this.bpjsControlPlansMultiCrudActive || this.bpjsPatientReferralsMultiCrudActive || this.polikontrolMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.BpjsServiceMappingAction(
					modelAction.BpjsServiceMappingModelActionTypes.FETCH_BPJS_SERVICE_MAPPING,
					{
						targetModelId: this.targetModelId,
						queryParams: {
							expands: this.defaultExpands
						}
					}
				));
			} else {
				afterwardActions = [
					new routingAction.BackRoutingAction(),
					// % protected region % [Add any additional afterwards actions for updates here] off begin
					// % protected region % [Add any additional afterwards actions for updates here] end
				];
			}

			// % protected region % [Add any additional logic before update the current model here] off begin
			// % protected region % [Add any additional logic before update the current model here] end

			this.store.dispatch(new modelAction.BpjsServiceMappingAction(
				modelAction.BpjsServiceMappingModelActionTypes.UPDATE_BPJS_SERVICE_MAPPING,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: BpjsServiceMappingModel = new BpjsServiceMappingModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getBpjsServiceMappingModelWithId, this.targetModelId).subscribe(model => {
					let differences = new BpjsServiceMappingModel(model).difference(updatedModel);

					// Object has been updated when differences is empty.
					// Differences excludes values such as references.  As these aren't visible on the list they do not need to be checked
					// When the user naivgates to a page which displays references, they will be fetched from the database with the correct values
					if (Object.keys(differences).length === 0) {
						this.triggerTileModeChange(CrudTileMode.List);
					}
				}));
			}
		}

		// % protected region % [Add any additional onCreateOrSaveClicked logic after the main body here] off begin
		// % protected region % [Add any additional onCreateOrSaveClicked logic after the main body here] end
	}

	/**
	 * Removes form elements whose group id matches the group Id passed into the event, or adds a new
	 * group based on the entityName parameter
	 *
	 * @param event The event emitted from the base crud edit page
	 */
	onMultiEntityAction(event: { groupId: string, entityName: string, payload?: { [s: string]: any } }) {
		if (event.groupId) { // This path deletes the group with the specified id from the list
			this.modelProperties = this.modelProperties.filter(prop => {
				if (prop.group) {
					return prop.group.id !== event.groupId;
				}

				// Groupless attributes should pass through no matter what, as they are not related to the additional entities
				return true;
			});

			this.modelRelations = this.modelRelations.filter(relation => {
				if (relation.group) {
					return relation.group.id !== event.groupId;
				}

				// Groupless attributes should pass through no matter what, as they are not related to the additional entities
				return true;
			});
		} else {
			// This will add a new entity of the specified type to the list of props/relations
			if (event.entityName === this.serviceDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ServiceModel.getProps(), this.serviceRelations, this.isViewOnly),
					new ServiceModel(),
					ServiceModel,
					this.serviceDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.serviceRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsClaimSubmissionsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsClaimSubmissionModel.getProps(), this.bpjsClaimSubmissionsRelations, this.isViewOnly),
					new BpjsClaimSubmissionModel(),
					BpjsClaimSubmissionModel,
					this.bpjsClaimSubmissionsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsClaimSubmissionsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsControlPlansDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsControlPlanModel.getProps(), this.bpjsControlPlansRelations, this.isViewOnly),
					new BpjsControlPlanModel(),
					BpjsControlPlanModel,
					this.bpjsControlPlansDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsControlPlansRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsPatientReferralsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsPatientReferralModel.getProps(), this.bpjsPatientReferralsRelations, this.isViewOnly),
					new BpjsPatientReferralModel(),
					BpjsPatientReferralModel,
					this.bpjsPatientReferralsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsPatientReferralsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.polikontrolDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsHospitalizationPlanModel.getProps(), this.polikontrolRelations, this.isViewOnly),
					new BpjsHospitalizationPlanModel(),
					BpjsHospitalizationPlanModel,
					this.polikontrolDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.polikontrolRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			}
	}

	/**
	 * Triggered when the user switches from view mode to edit mode.
	 */
	onSwitchEdit() {
		// % protected region % [Add any additional onSwitchEdit logic before the main body here] off begin
		// % protected region % [Add any additional onSwitchEdit logic before the main body here] end

		this.triggerTileModeChange(CrudTileMode.Edit, this.targetModelId);

		// % protected region % [Add any additional onSwitchEdit logic after the main body here] off begin
		// % protected region % [Add any additional onSwitchEdit logic after the main body here] end
	}

	/**
	 * Triggered whenever the `Cancel` of the create/edit child component is clicked.
	 */
	onCancelClicked() {
		// % protected region % [Add any additional onCancelClicked logic before the main body here] off begin
		// % protected region % [Add any additional onCancelClicked logic before the main body here] end

		this.triggerTileModeChange(CrudTileMode.List);

		// % protected region % [Add any additional onCancelClicked logic after the main body here] off begin
		// % protected region % [Add any additional onCancelClicked logic after the main body here] end
	}

	/**
	 * Create the reactive form from the input model
	 */
	createReactiveForm() {
		// % protected region % [Add any additional createReactiveForm logic before the main body here] off begin
		// % protected region % [Add any additional createReactiveForm logic before the main body here] end

		this.modelFormGroup = createReactiveFormFromModel(this.modelProperties, this.modelRelations, this.isViewOnly);

		// % protected region % [Add any additional createReactiveForm logic after the main body here] off begin
		// % protected region % [Add any additional createReactiveForm logic after the main body here] end
	}

	/**
	 * Returns the props and relations lists back to their default state.  This is called in fetchEntity to ensure that
	 * any time the entity changes these lists remain stable.  If you are adding additional entities to your crud page the
	 * placement of this method ensures that no duplicate attributes will be added on repeat runs of fetch entity
	 */
	resetPropsAndRels() {
		this.modelProperties = BpjsServiceMappingModel.getProps();
		this.modelRelations = BpjsServiceMappingModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'service';
		}).hideElement = this.serviceMultiCrudActive || this.modelRelations.find(rel => rel.id === 'service').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsClaimSubmissions';
		}).hideElement = this.bpjsClaimSubmissionsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsClaimSubmissions').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsControlPlans';
		}).hideElement = this.bpjsControlPlansMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsControlPlans').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsPatientReferrals';
		}).hideElement = this.bpjsPatientReferralsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsPatientReferrals').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'polikontrol';
		}).hideElement = this.polikontrolMultiCrudActive || this.modelRelations.find(rel => rel.id === 'polikontrol').hideElement;

	}

	/**
	 * Initialises the collections used for fetching the entities to display in multi entity crud for many relations.
	 * The same collection used to fetch entities for the relation dropdown cannot be reused, as we need to fetch a
	 * subset for these relations, and using the same collection will result in all entities being returned instead of the
	 * subset we are looking for.
	 *
	 * This method will only be populated if this entity has a many relation (i.e. it is the target of a 1:M relation, or is part of a
	 * M:M relation)
	 */
	initialiseMultiEntityCollections() {
		if (this.serviceMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.serviceDisplayName, many: false});
		}

		if (this.bpjsClaimSubmissionsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsClaimSubmissionsDisplayName, many: true});
			this.store.dispatch(new bpjsClaimSubmissionModelAction.BpjsClaimSubmissionAction(
				bpjsClaimSubmissionModelAction.BpjsClaimSubmissionModelActionTypes.INITIALISE_BPJS_CLAIM_SUBMISSION_COLLECTION_STATE,
				{
					collectionId: this.bpjsClaimSubmissionsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsClaimSubmissionCollectionModels, this.bpjsClaimSubmissionsCollectionId).subscribe(models => {
				models.forEach(bpjsClaimSubmissions => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsClaimSubmissionModel.getProps(), this.bpjsClaimSubmissionsRelations, this.isViewOnly),
						bpjsClaimSubmissions,
						BpjsClaimSubmissionModel,
						this.bpjsClaimSubmissionsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bpjsClaimSubmissionsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.bpjsControlPlansMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsControlPlansDisplayName, many: true});
			this.store.dispatch(new bpjsControlPlanModelAction.BpjsControlPlanAction(
				bpjsControlPlanModelAction.BpjsControlPlanModelActionTypes.INITIALISE_BPJS_CONTROL_PLAN_COLLECTION_STATE,
				{
					collectionId: this.bpjsControlPlansCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsControlPlanCollectionModels, this.bpjsControlPlansCollectionId).subscribe(models => {
				models.forEach(bpjsControlPlans => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsControlPlanModel.getProps(), this.bpjsControlPlansRelations, this.isViewOnly),
						bpjsControlPlans,
						BpjsControlPlanModel,
						this.bpjsControlPlansDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bpjsControlPlansRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.bpjsPatientReferralsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsPatientReferralsDisplayName, many: true});
			this.store.dispatch(new bpjsPatientReferralModelAction.BpjsPatientReferralAction(
				bpjsPatientReferralModelAction.BpjsPatientReferralModelActionTypes.INITIALISE_BPJS_PATIENT_REFERRAL_COLLECTION_STATE,
				{
					collectionId: this.bpjsPatientReferralsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsPatientReferralCollectionModels, this.bpjsPatientReferralsCollectionId).subscribe(models => {
				models.forEach(bpjsPatientReferrals => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsPatientReferralModel.getProps(), this.bpjsPatientReferralsRelations, this.isViewOnly),
						bpjsPatientReferrals,
						BpjsPatientReferralModel,
						this.bpjsPatientReferralsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bpjsPatientReferralsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.polikontrolMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.polikontrolDisplayName, many: true});
			this.store.dispatch(new bpjsHospitalizationPlanModelAction.BpjsHospitalizationPlanAction(
				bpjsHospitalizationPlanModelAction.BpjsHospitalizationPlanModelActionTypes.INITIALISE_BPJS_HOSPITALIZATION_PLAN_COLLECTION_STATE,
				{
					collectionId: this.polikontrolCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsHospitalizationPlanCollectionModels, this.polikontrolCollectionId).subscribe(models => {
				models.forEach(polikontrol => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsHospitalizationPlanModel.getProps(), this.polikontrolRelations, this.isViewOnly),
						polikontrol,
						BpjsHospitalizationPlanModel,
						this.polikontrolDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.polikontrolRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

	}

	/**
	 * Fetches the entities for any activated multi entity crud selections, and adds groups to the form for every additional
	 * related entity.
	 *
	 * May be empty if the entity for this crud page has no related entities
	 */
	multiCrudFetchAdditionalEntities() {
		if (this.targetModel.service && this.targetModel.service.id && this.serviceMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				ServiceModel,
				this.serviceOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.service.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getServiceModelWithId, this.targetModel.serviceId).subscribe(service => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ServiceModel.getProps(), this.serviceRelations, this.isViewOnly),
					service,
					ServiceModel,
					this.serviceDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.serviceRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bpjsClaimSubmissionsIds && this.targetModel.bpjsClaimSubmissionsIds.length > 0 && this.bpjsClaimSubmissionsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsClaimSubmissionModel,
				this.bpjsClaimSubmissionsOppositeRelation,
				this.bpjsClaimSubmissionsCollectionId,
				this.targetModel.bpjsClaimSubmissionsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.bpjsControlPlansIds && this.targetModel.bpjsControlPlansIds.length > 0 && this.bpjsControlPlansMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsControlPlanModel,
				this.bpjsControlPlansOppositeRelation,
				this.bpjsControlPlansCollectionId,
				this.targetModel.bpjsControlPlansIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.bpjsPatientReferralsIds && this.targetModel.bpjsPatientReferralsIds.length > 0 && this.bpjsPatientReferralsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsPatientReferralModel,
				this.bpjsPatientReferralsOppositeRelation,
				this.bpjsPatientReferralsCollectionId,
				this.targetModel.bpjsPatientReferralsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.polikontrolIds && this.targetModel.polikontrolIds.length > 0 && this.polikontrolMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsHospitalizationPlanModel,
				this.polikontrolOppositeRelation,
				this.polikontrolCollectionId,
				this.targetModel.polikontrolIds.length,
				this.targetModel.id,
				true
			));
		}

	}

	/**
	 * The crud create edit page will handle all potential multi entity crud permutations by returning an
	 * `additionalEntities` parameter in its returned event.  This attribute will contain any entities which
	 * were added to the crud edit page for multi entity model.  Once this attribute has been returned, we need
	 * to process it, and transfer any additional entities from this attribute into the target model, so that these
	 * additional entities can be sent to the serverside for processing.
	 *
	 * @param model The model to inject the additional entities into.  This will usually be the targetModel attribute for this component
	 * @param event The event returned from the crud edit page when clicking create or save.  We only care about the additionalEntities param here
	 * @returns the model passed in as input, but with the entities from the additionalEntities attribute added to that model.
	 */
	addAdditionalEntitiesToModel(model: BpjsServiceMappingModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): BpjsServiceMappingModel {
		let updatedModel: BpjsServiceMappingModel = new BpjsServiceMappingModel(model);

		if (this.serviceMultiCrudActive) {
			updatedModel.service = event.additionalEntities.service ? event.additionalEntities.service : undefined;

			if (!updatedModel.service && event.payload) {
				event.payload.serviceId = null;
			}
		} else if (event.payload?.serviceId !== undefined) {
			event.payload.service = null;
			updatedModel.service = null;
		}

		updatedModel.bpjsClaimSubmissions = [];
		if (this.bpjsClaimSubmissionsMultiCrudActive) {
			if (event.additionalEntities.bpjsClaimSubmissions) {
				event.additionalEntities.bpjsClaimSubmissions.forEach(entity => {
					updatedModel.bpjsClaimSubmissions.push(entity);
				});
			}

			if (!updatedModel.bpjsClaimSubmissions.length) {
				updatedModel.bpjsClaimSubmissionsIds = [];
			}
		}
		updatedModel.bpjsControlPlans = [];
		if (this.bpjsControlPlansMultiCrudActive) {
			if (event.additionalEntities.bpjsControlPlans) {
				event.additionalEntities.bpjsControlPlans.forEach(entity => {
					updatedModel.bpjsControlPlans.push(entity);
				});
			}

			if (!updatedModel.bpjsControlPlans.length) {
				updatedModel.bpjsControlPlansIds = [];
			}
		}
		updatedModel.bpjsPatientReferrals = [];
		if (this.bpjsPatientReferralsMultiCrudActive) {
			if (event.additionalEntities.bpjsPatientReferrals) {
				event.additionalEntities.bpjsPatientReferrals.forEach(entity => {
					updatedModel.bpjsPatientReferrals.push(entity);
				});
			}

			if (!updatedModel.bpjsPatientReferrals.length) {
				updatedModel.bpjsPatientReferralsIds = [];
			}
		}
		updatedModel.polikontrol = [];
		if (this.polikontrolMultiCrudActive) {
			if (event.additionalEntities.polikontrol) {
				event.additionalEntities.polikontrol.forEach(entity => {
					updatedModel.polikontrol.push(entity);
				});
			}

			if (!updatedModel.polikontrol.length) {
				updatedModel.polikontrolIds = [];
			}
		}
		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}