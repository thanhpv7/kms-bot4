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
import * as modelAction from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.action';
import {BpjsDiagnoseModelState, BpjsDiagnoseModelAudit} from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.state';
import {BpjsDiagnoseModel} from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model';
import {
	getBpjsDiagnoseModelAuditsByEntityId,
	getBpjsDiagnoseModelWithId,
	getCountBpjsDiagnoseModels,
} from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {BpjsClaimSubmissionModel} from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import * as bpjsClaimSubmissionModelAction from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.action';
import {
	getBpjsClaimSubmissionCollectionModels, getBpjsClaimSubmissionModelWithId,
} from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import {BpjsPatientReferralModel} from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model';
import * as bpjsPatientReferralModelAction from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.action';
import {
	getBpjsPatientReferralCollectionModels, getBpjsPatientReferralModelWithId,
} from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import {BpjsSpecialReferralModel} from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model';
import * as bpjsSpecialReferralModelAction from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model.action';
import {
	getBpjsSpecialReferralCollectionModels, getBpjsSpecialReferralModelWithId,
} from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model.selector';
import {DiagnosesAndProceduresModel} from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import * as diagnosesAndProceduresModelAction from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.action';
import {
	getDiagnosesAndProceduresCollectionModels, getDiagnosesAndProceduresModelWithId,
} from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../bpjs-diagnose-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-bpjs-diagnose-crud-edit',
	templateUrl: './bpjs-diagnose-crud-edit.component.html',
	styleUrls: [
		'./bpjs-diagnose-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class BpjsDiagnoseCrudEditComponent
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
	collectionId: string = '550a356f-2f4a-4faf-84d1-ce1145b01089';
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
	bpjsDiagnoseAudits$: Observable<BpjsDiagnoseModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Diagnose and Diagnoses and Procedures here] off begin
	diagnosesAndProceduresMultiCrudActive: boolean = false;
	diagnosesAndProceduresDisplayName = 'Diagnoses and Procedures';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Diagnose and Diagnoses and Procedures here] end
	diagnosesAndProceduresOppositeRelation = 'bpjsDiagnose';
	diagnosesAndProceduresRelations: ModelRelation[] = this.diagnosesAndProceduresMultiCrudActive ? DiagnosesAndProceduresModel.getRelations()
		.map(relation => {
			if (relation.id === this.diagnosesAndProceduresOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Additional Diagnose and Additional Diagnose here] off begin
	additionalDiagnoseMultiCrudActive: boolean = false;
	additionalDiagnoseDisplayName = 'Additional Diagnose';
	additionalDiagnoseCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Additional Diagnose and Additional Diagnose here] end
	additionalDiagnoseOppositeRelation = 'additionalDiagnose';
	additionalDiagnoseRelations: ModelRelation[] = this.additionalDiagnoseMultiCrudActive ? BpjsSpecialReferralModel.getRelations()
		.map(relation => {
			if (relation.id === this.additionalDiagnoseOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Diagnose and BPJS Claim Submissions here] off begin
	bpjsClaimSubmissionsMultiCrudActive: boolean = false;
	bpjsClaimSubmissionsDisplayName = 'BPJS Claim Submissions';
	bpjsClaimSubmissionsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Diagnose and BPJS Claim Submissions here] end
	bpjsClaimSubmissionsOppositeRelation = 'bpjsDiagnose';
	bpjsClaimSubmissionsRelations: ModelRelation[] = this.bpjsClaimSubmissionsMultiCrudActive ? BpjsClaimSubmissionModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsClaimSubmissionsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Diagnose and BPJS Patient Referrals here] off begin
	bpjsPatientReferralsMultiCrudActive: boolean = false;
	bpjsPatientReferralsDisplayName = 'BPJS Patient Referrals';
	bpjsPatientReferralsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Diagnose and BPJS Patient Referrals here] end
	bpjsPatientReferralsOppositeRelation = 'bpjsDiagnose';
	bpjsPatientReferralsRelations: ModelRelation[] = this.bpjsPatientReferralsMultiCrudActive ? BpjsPatientReferralModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsPatientReferralsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Primary Diagnose and Primary Diagnose here] off begin
	primaryDiagnoseMultiCrudActive: boolean = false;
	primaryDiagnoseDisplayName = 'Primary Diagnose';
	primaryDiagnoseCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Primary Diagnose and Primary Diagnose here] end
	primaryDiagnoseOppositeRelation = 'primaryDiagnose';
	primaryDiagnoseRelations: ModelRelation[] = this.primaryDiagnoseMultiCrudActive ? BpjsSpecialReferralModel.getRelations()
		.map(relation => {
			if (relation.id === this.primaryDiagnoseOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = BpjsDiagnoseModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = BpjsDiagnoseModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = BpjsDiagnoseModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'diagnosesAndProcedures' && this.diagnosesAndProceduresMultiCrudActive) {
					exp.fields = DiagnosesAndProceduresModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'additionalDiagnose' && this.additionalDiagnoseMultiCrudActive) {
					exp.fields = BpjsSpecialReferralModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsClaimSubmissions' && this.bpjsClaimSubmissionsMultiCrudActive) {
					exp.fields = BpjsClaimSubmissionModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsPatientReferrals' && this.bpjsPatientReferralsMultiCrudActive) {
					exp.fields = BpjsPatientReferralModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'primaryDiagnose' && this.primaryDiagnoseMultiCrudActive) {
					exp.fields = BpjsSpecialReferralModel.getProps().map(prop => {
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
	targetModel: BpjsDiagnoseModel;

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
		private readonly store: Store<{ model: BpjsDiagnoseModelState }>,
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
		this.creationNavigationSubscription$.add(this.store.select(getCountBpjsDiagnoseModels).subscribe(count => {
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

			this.targetModel = new BpjsDiagnoseModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.bpjsDiagnoseAudits$ = this.store.select(getBpjsDiagnoseModelAuditsByEntityId, this.targetModelId);
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
		const stateConfig: PassableStateConfig<BpjsDiagnoseModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.BpjsDiagnoseAction(
			modelAction.BpjsDiagnoseModelActionTypes.FETCH_BPJS_DIAGNOSE,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getBpjsDiagnoseModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new BpjsDiagnoseModel(model);
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
				commands.push('bpjs-diagnose');
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

		this.store.dispatch(new modelAction.BpjsDiagnoseAction(
			modelAction.BpjsDiagnoseModelActionTypes.FETCH_BPJS_DIAGNOSE_AUDITS_BY_ENTITY_ID,
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
			let stateConfig: PassableStateConfig<BpjsDiagnoseModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.diagnosesAndProceduresMultiCrudActive || this.additionalDiagnoseMultiCrudActive || this.bpjsClaimSubmissionsMultiCrudActive || this.bpjsPatientReferralsMultiCrudActive || this.primaryDiagnoseMultiCrudActive,
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
					new modelAction.BpjsDiagnoseAction(
						modelAction.BpjsDiagnoseModelActionTypes.COUNT_BPJS_DIAGNOSES,
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

			this.store.dispatch(new modelAction.BpjsDiagnoseAction(
				modelAction.BpjsDiagnoseModelActionTypes.CREATE_BPJS_DIAGNOSE,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<BpjsDiagnoseModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.diagnosesAndProceduresMultiCrudActive || this.additionalDiagnoseMultiCrudActive || this.bpjsClaimSubmissionsMultiCrudActive || this.bpjsPatientReferralsMultiCrudActive || this.primaryDiagnoseMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.BpjsDiagnoseAction(
					modelAction.BpjsDiagnoseModelActionTypes.FETCH_BPJS_DIAGNOSE,
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

			this.store.dispatch(new modelAction.BpjsDiagnoseAction(
				modelAction.BpjsDiagnoseModelActionTypes.UPDATE_BPJS_DIAGNOSE,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: BpjsDiagnoseModel = new BpjsDiagnoseModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getBpjsDiagnoseModelWithId, this.targetModelId).subscribe(model => {
					let differences = new BpjsDiagnoseModel(model).difference(updatedModel);

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
			if (event.entityName === this.diagnosesAndProceduresDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosesAndProceduresModel.getProps(), this.diagnosesAndProceduresRelations, this.isViewOnly),
					new DiagnosesAndProceduresModel(),
					DiagnosesAndProceduresModel,
					this.diagnosesAndProceduresDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.diagnosesAndProceduresRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.additionalDiagnoseDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsSpecialReferralModel.getProps(), this.additionalDiagnoseRelations, this.isViewOnly),
					new BpjsSpecialReferralModel(),
					BpjsSpecialReferralModel,
					this.additionalDiagnoseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.additionalDiagnoseRelations,
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

			if (event.entityName === this.primaryDiagnoseDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsSpecialReferralModel.getProps(), this.primaryDiagnoseRelations, this.isViewOnly),
					new BpjsSpecialReferralModel(),
					BpjsSpecialReferralModel,
					this.primaryDiagnoseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.primaryDiagnoseRelations,
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
		this.modelProperties = BpjsDiagnoseModel.getProps();
		this.modelRelations = BpjsDiagnoseModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'diagnosesAndProcedures';
		}).hideElement = this.diagnosesAndProceduresMultiCrudActive || this.modelRelations.find(rel => rel.id === 'diagnosesAndProcedures').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'additionalDiagnose';
		}).hideElement = this.additionalDiagnoseMultiCrudActive || this.modelRelations.find(rel => rel.id === 'additionalDiagnose').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsClaimSubmissions';
		}).hideElement = this.bpjsClaimSubmissionsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsClaimSubmissions').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsPatientReferrals';
		}).hideElement = this.bpjsPatientReferralsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsPatientReferrals').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'primaryDiagnose';
		}).hideElement = this.primaryDiagnoseMultiCrudActive || this.modelRelations.find(rel => rel.id === 'primaryDiagnose').hideElement;

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
		if (this.diagnosesAndProceduresMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.diagnosesAndProceduresDisplayName, many: false});
		}

		if (this.additionalDiagnoseMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.additionalDiagnoseDisplayName, many: true});
			this.store.dispatch(new bpjsSpecialReferralModelAction.BpjsSpecialReferralAction(
				bpjsSpecialReferralModelAction.BpjsSpecialReferralModelActionTypes.INITIALISE_BPJS_SPECIAL_REFERRAL_COLLECTION_STATE,
				{
					collectionId: this.additionalDiagnoseCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsSpecialReferralCollectionModels, this.additionalDiagnoseCollectionId).subscribe(models => {
				models.forEach(additionalDiagnose => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsSpecialReferralModel.getProps(), this.additionalDiagnoseRelations, this.isViewOnly),
						additionalDiagnose,
						BpjsSpecialReferralModel,
						this.additionalDiagnoseDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.additionalDiagnoseRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
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

		if (this.primaryDiagnoseMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.primaryDiagnoseDisplayName, many: true});
			this.store.dispatch(new bpjsSpecialReferralModelAction.BpjsSpecialReferralAction(
				bpjsSpecialReferralModelAction.BpjsSpecialReferralModelActionTypes.INITIALISE_BPJS_SPECIAL_REFERRAL_COLLECTION_STATE,
				{
					collectionId: this.primaryDiagnoseCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsSpecialReferralCollectionModels, this.primaryDiagnoseCollectionId).subscribe(models => {
				models.forEach(primaryDiagnose => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsSpecialReferralModel.getProps(), this.primaryDiagnoseRelations, this.isViewOnly),
						primaryDiagnose,
						BpjsSpecialReferralModel,
						this.primaryDiagnoseDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.primaryDiagnoseRelations,
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
		if (this.targetModel.diagnosesAndProcedures && this.targetModel.diagnosesAndProcedures.id && this.diagnosesAndProceduresMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DiagnosesAndProceduresModel,
				this.diagnosesAndProceduresOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.diagnosesAndProcedures.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getDiagnosesAndProceduresModelWithId, this.targetModel.diagnosesAndProceduresId).subscribe(diagnosesAndProcedures => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosesAndProceduresModel.getProps(), this.diagnosesAndProceduresRelations, this.isViewOnly),
					diagnosesAndProcedures,
					DiagnosesAndProceduresModel,
					this.diagnosesAndProceduresDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.diagnosesAndProceduresRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.additionalDiagnoseIds && this.targetModel.additionalDiagnoseIds.length > 0 && this.additionalDiagnoseMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsSpecialReferralModel,
				this.additionalDiagnoseOppositeRelation,
				this.additionalDiagnoseCollectionId,
				this.targetModel.additionalDiagnoseIds.length,
				this.targetModel.id,
				true
			));
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

		if (this.targetModel.primaryDiagnoseIds && this.targetModel.primaryDiagnoseIds.length > 0 && this.primaryDiagnoseMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsSpecialReferralModel,
				this.primaryDiagnoseOppositeRelation,
				this.primaryDiagnoseCollectionId,
				this.targetModel.primaryDiagnoseIds.length,
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
	addAdditionalEntitiesToModel(model: BpjsDiagnoseModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): BpjsDiagnoseModel {
		let updatedModel: BpjsDiagnoseModel = new BpjsDiagnoseModel(model);

		if (this.diagnosesAndProceduresMultiCrudActive) {
			updatedModel.diagnosesAndProcedures = event.additionalEntities.diagnosesAndProcedures ? event.additionalEntities.diagnosesAndProcedures : undefined;

			if (!updatedModel.diagnosesAndProcedures && event.payload) {
				event.payload.diagnosesAndProceduresId = null;
			}
		} else if (event.payload?.diagnosesAndProceduresId !== undefined) {
			event.payload.diagnosesAndProcedures = null;
			updatedModel.diagnosesAndProcedures = null;
		}

		updatedModel.additionalDiagnose = [];
		if (this.additionalDiagnoseMultiCrudActive) {
			if (event.additionalEntities.additionalDiagnose) {
				event.additionalEntities.additionalDiagnose.forEach(entity => {
					updatedModel.additionalDiagnose.push(entity);
				});
			}

			if (!updatedModel.additionalDiagnose.length) {
				updatedModel.additionalDiagnoseIds = [];
			}
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
		updatedModel.primaryDiagnose = [];
		if (this.primaryDiagnoseMultiCrudActive) {
			if (event.additionalEntities.primaryDiagnose) {
				event.additionalEntities.primaryDiagnose.forEach(entity => {
					updatedModel.primaryDiagnose.push(entity);
				});
			}

			if (!updatedModel.primaryDiagnose.length) {
				updatedModel.primaryDiagnoseIds = [];
			}
		}
		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
