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
import * as modelAction from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.action';
import {PatientPaymentBPJSModelState, PatientPaymentBPJSModelAudit} from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.state';
import {PatientPaymentBPJSModel} from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model';
import {
	getPatientPaymentBPJSModelAuditsByEntityId,
	getPatientPaymentBPJSModelWithId,
	getCountPatientPaymentBPJSModels,
} from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {BpjsAccidentMasterModel} from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model';
import * as bpjsAccidentMasterModelAction from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model.action';
import {
	getBpjsAccidentMasterCollectionModels, getBpjsAccidentMasterModelWithId,
} from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model.selector';
import {BpjsClaimSubmissionModel} from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import * as bpjsClaimSubmissionModelAction from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.action';
import {
	getBpjsClaimSubmissionCollectionModels, getBpjsClaimSubmissionModelWithId,
} from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import {BpjsHospitalizationPlanModel} from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model';
import * as bpjsHospitalizationPlanModelAction from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.action';
import {
	getBpjsHospitalizationPlanCollectionModels, getBpjsHospitalizationPlanModelWithId,
} from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.selector';
import {BpjsJasaRaharjaModel} from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model';
import * as bpjsJasaRaharjaModelAction from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model.action';
import {
	getBpjsJasaRaharjaCollectionModels, getBpjsJasaRaharjaModelWithId,
} from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model.selector';
import {BpjsPatientReferralModel} from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model';
import * as bpjsPatientReferralModelAction from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.action';
import {
	getBpjsPatientReferralCollectionModels, getBpjsPatientReferralModelWithId,
} from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import {BpjsSEPModel} from 'src/app/models/bpjsSEP/bpjs_sep.model';
import * as bpjsSEPModelAction from 'src/app/models/bpjsSEP/bpjs_sep.model.action';
import {
	getBpjsSEPCollectionModels, getBpjsSEPModelWithId,
} from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import {BpjsSEPSubmissionModel} from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model';
import * as bpjsSEPSubmissionModelAction from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model.action';
import {
	getBpjsSEPSubmissionCollectionModels, getBpjsSEPSubmissionModelWithId,
} from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model.selector';
import {PatientGeneralInfoModel} from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import * as patientGeneralInfoModelAction from 'src/app/models/patientGeneralInfo/patient_general_info.model.action';
import {
	getPatientGeneralInfoCollectionModels, getPatientGeneralInfoModelWithId,
} from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../patient-payment-bpjs-admin-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-patient-payment-bpjs-admin-crud-edit',
	templateUrl: './patient-payment-bpjs-admin-crud-edit.component.html',
	styleUrls: [
		'./patient-payment-bpjs-admin-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class AdminPatientPaymentBPJSCrudEditComponent
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
	collectionId: string = '3ac85a2a-8093-4511-a347-5c45dc670335';
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
	patientPaymentBPJSAudits$: Observable<PatientPaymentBPJSModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and Patient Payment BPJS here] off begin
	patientGeneralInfoMultiCrudActive: boolean = false;
	patientGeneralInfoDisplayName = 'Patient General Info';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and Patient Payment BPJS here] end
	patientGeneralInfoOppositeRelation = 'patientPaymentBPJS';
	patientGeneralInfoRelations: ModelRelation[] = this.patientGeneralInfoMultiCrudActive ? PatientGeneralInfoModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientGeneralInfoOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Payment BPJS and BPJS Accident Masters here] off begin
	bpjsAccidentMastersMultiCrudActive: boolean = false;
	bpjsAccidentMastersDisplayName = 'BPJS Accident Masters';
	bpjsAccidentMastersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Payment BPJS and BPJS Accident Masters here] end
	bpjsAccidentMastersOppositeRelation = 'patientPaymentBPJS';
	bpjsAccidentMastersRelations: ModelRelation[] = this.bpjsAccidentMastersMultiCrudActive ? BpjsAccidentMasterModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsAccidentMastersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Payment BPJS and BPJS Claim Submissions here] off begin
	bpjsClaimSubmissionsMultiCrudActive: boolean = false;
	bpjsClaimSubmissionsDisplayName = 'BPJS Claim Submissions';
	bpjsClaimSubmissionsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Payment BPJS and BPJS Claim Submissions here] end
	bpjsClaimSubmissionsOppositeRelation = 'patientPaymentBPJS';
	bpjsClaimSubmissionsRelations: ModelRelation[] = this.bpjsClaimSubmissionsMultiCrudActive ? BpjsClaimSubmissionModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsClaimSubmissionsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Payment BPJS and BPJS Hospitalization Plans here] off begin
	bpjsHospitalizationPlansMultiCrudActive: boolean = false;
	bpjsHospitalizationPlansDisplayName = 'BPJS Hospitalization Plans';
	bpjsHospitalizationPlansCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Payment BPJS and BPJS Hospitalization Plans here] end
	bpjsHospitalizationPlansOppositeRelation = 'patientPaymentBPJS';
	bpjsHospitalizationPlansRelations: ModelRelation[] = this.bpjsHospitalizationPlansMultiCrudActive ? BpjsHospitalizationPlanModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsHospitalizationPlansOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Payment BPJS and BPJS Jasa Raharjas here] off begin
	bpjsJasaRaharjasMultiCrudActive: boolean = false;
	bpjsJasaRaharjasDisplayName = 'BPJS Jasa Raharjas';
	bpjsJasaRaharjasCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Payment BPJS and BPJS Jasa Raharjas here] end
	bpjsJasaRaharjasOppositeRelation = 'patientPaymentBPJS';
	bpjsJasaRaharjasRelations: ModelRelation[] = this.bpjsJasaRaharjasMultiCrudActive ? BpjsJasaRaharjaModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsJasaRaharjasOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Payment BPJS and BPJS Patient Referrals here] off begin
	bpjsPatientReferralsMultiCrudActive: boolean = false;
	bpjsPatientReferralsDisplayName = 'BPJS Patient Referrals';
	bpjsPatientReferralsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Payment BPJS and BPJS Patient Referrals here] end
	bpjsPatientReferralsOppositeRelation = 'patientPaymentBPJS';
	bpjsPatientReferralsRelations: ModelRelation[] = this.bpjsPatientReferralsMultiCrudActive ? BpjsPatientReferralModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsPatientReferralsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Payment BPJS and BPJS SEP Submissions here] off begin
	bpjsSEPSubmissionsMultiCrudActive: boolean = false;
	bpjsSEPSubmissionsDisplayName = 'BPJS SEP Submissions';
	bpjsSEPSubmissionsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Payment BPJS and BPJS SEP Submissions here] end
	bpjsSEPSubmissionsOppositeRelation = 'patientPaymentBPJS';
	bpjsSEPSubmissionsRelations: ModelRelation[] = this.bpjsSEPSubmissionsMultiCrudActive ? BpjsSEPSubmissionModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsSEPSubmissionsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Payment BPJS and BPJS SEPs here] off begin
	bpjsSEPsMultiCrudActive: boolean = false;
	bpjsSEPsDisplayName = 'BPJS SEPs';
	bpjsSEPsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Payment BPJS and BPJS SEPs here] end
	bpjsSEPsOppositeRelation = 'patientPaymentBPJS';
	bpjsSEPsRelations: ModelRelation[] = this.bpjsSEPsMultiCrudActive ? BpjsSEPModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsSEPsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = PatientPaymentBPJSModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = PatientPaymentBPJSModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = PatientPaymentBPJSModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'patientGeneralInfo' && this.patientGeneralInfoMultiCrudActive) {
					exp.fields = PatientGeneralInfoModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsAccidentMasters' && this.bpjsAccidentMastersMultiCrudActive) {
					exp.fields = BpjsAccidentMasterModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsClaimSubmissions' && this.bpjsClaimSubmissionsMultiCrudActive) {
					exp.fields = BpjsClaimSubmissionModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsHospitalizationPlans' && this.bpjsHospitalizationPlansMultiCrudActive) {
					exp.fields = BpjsHospitalizationPlanModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsJasaRaharjas' && this.bpjsJasaRaharjasMultiCrudActive) {
					exp.fields = BpjsJasaRaharjaModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsPatientReferrals' && this.bpjsPatientReferralsMultiCrudActive) {
					exp.fields = BpjsPatientReferralModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsSEPSubmissions' && this.bpjsSEPSubmissionsMultiCrudActive) {
					exp.fields = BpjsSEPSubmissionModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsSEPs' && this.bpjsSEPsMultiCrudActive) {
					exp.fields = BpjsSEPModel.getProps().map(prop => {
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
	targetModel: PatientPaymentBPJSModel;

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
		private readonly store: Store<{ model: PatientPaymentBPJSModelState }>,
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
		this.creationNavigationSubscription$.add(this.store.select(getCountPatientPaymentBPJSModels).subscribe(count => {
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

			this.targetModel = new PatientPaymentBPJSModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.patientPaymentBPJSAudits$ = this.store.select(getPatientPaymentBPJSModelAuditsByEntityId, this.targetModelId);
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
		const stateConfig: PassableStateConfig<PatientPaymentBPJSModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.PatientPaymentBPJSAction(
			modelAction.PatientPaymentBPJSModelActionTypes.FETCH_PATIENT_PAYMENT_BPJS,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getPatientPaymentBPJSModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new PatientPaymentBPJSModel(model);
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

			if (this.routerState.queryParams.listPage) {
				extras.queryParams = {listPage: this.routerState.queryParams.listPage};
			}

			const commands = [];

			commands.push('admin');
			commands.push('entities');
			commands.push('patient-payment-bpjs');

			if (tileMode !== CrudTileMode.List) {
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

		this.store.dispatch(new modelAction.PatientPaymentBPJSAction(
			modelAction.PatientPaymentBPJSModelActionTypes.FETCH_PATIENT_PAYMENT_BPJS_AUDITS_BY_ENTITY_ID,
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
			let stateConfig: PassableStateConfig<PatientPaymentBPJSModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.patientGeneralInfoMultiCrudActive || this.bpjsAccidentMastersMultiCrudActive || this.bpjsClaimSubmissionsMultiCrudActive || this.bpjsHospitalizationPlansMultiCrudActive || this.bpjsJasaRaharjasMultiCrudActive || this.bpjsPatientReferralsMultiCrudActive || this.bpjsSEPSubmissionsMultiCrudActive || this.bpjsSEPsMultiCrudActive,
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
					new modelAction.PatientPaymentBPJSAction(
						modelAction.PatientPaymentBPJSModelActionTypes.COUNT_PATIENT_PAYMENT_BPJSS,
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

			this.store.dispatch(new modelAction.PatientPaymentBPJSAction(
				modelAction.PatientPaymentBPJSModelActionTypes.CREATE_PATIENT_PAYMENT_BPJS,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<PatientPaymentBPJSModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.patientGeneralInfoMultiCrudActive || this.bpjsAccidentMastersMultiCrudActive || this.bpjsClaimSubmissionsMultiCrudActive || this.bpjsHospitalizationPlansMultiCrudActive || this.bpjsJasaRaharjasMultiCrudActive || this.bpjsPatientReferralsMultiCrudActive || this.bpjsSEPSubmissionsMultiCrudActive || this.bpjsSEPsMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.PatientPaymentBPJSAction(
					modelAction.PatientPaymentBPJSModelActionTypes.FETCH_PATIENT_PAYMENT_BPJS,
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

			this.store.dispatch(new modelAction.PatientPaymentBPJSAction(
				modelAction.PatientPaymentBPJSModelActionTypes.UPDATE_PATIENT_PAYMENT_BPJS,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: PatientPaymentBPJSModel = new PatientPaymentBPJSModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getPatientPaymentBPJSModelWithId, this.targetModelId).subscribe(model => {
					let differences = new PatientPaymentBPJSModel(model).difference(updatedModel);

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
			if (event.entityName === this.patientGeneralInfoDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientGeneralInfoModel.getProps(), this.patientGeneralInfoRelations, this.isViewOnly),
					new PatientGeneralInfoModel(),
					PatientGeneralInfoModel,
					this.patientGeneralInfoDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientGeneralInfoRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsAccidentMastersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsAccidentMasterModel.getProps(), this.bpjsAccidentMastersRelations, this.isViewOnly),
					new BpjsAccidentMasterModel(),
					BpjsAccidentMasterModel,
					this.bpjsAccidentMastersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsAccidentMastersRelations,
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

			if (event.entityName === this.bpjsHospitalizationPlansDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsHospitalizationPlanModel.getProps(), this.bpjsHospitalizationPlansRelations, this.isViewOnly),
					new BpjsHospitalizationPlanModel(),
					BpjsHospitalizationPlanModel,
					this.bpjsHospitalizationPlansDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsHospitalizationPlansRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsJasaRaharjasDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsJasaRaharjaModel.getProps(), this.bpjsJasaRaharjasRelations, this.isViewOnly),
					new BpjsJasaRaharjaModel(),
					BpjsJasaRaharjaModel,
					this.bpjsJasaRaharjasDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsJasaRaharjasRelations,
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

			if (event.entityName === this.bpjsSEPSubmissionsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsSEPSubmissionModel.getProps(), this.bpjsSEPSubmissionsRelations, this.isViewOnly),
					new BpjsSEPSubmissionModel(),
					BpjsSEPSubmissionModel,
					this.bpjsSEPSubmissionsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsSEPSubmissionsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsSEPsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsSEPModel.getProps(), this.bpjsSEPsRelations, this.isViewOnly),
					new BpjsSEPModel(),
					BpjsSEPModel,
					this.bpjsSEPsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsSEPsRelations,
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
		this.modelProperties = PatientPaymentBPJSModel.getProps();
		this.modelRelations = PatientPaymentBPJSModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'patientGeneralInfo';
		}).hideElement = this.patientGeneralInfoMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientGeneralInfo').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsAccidentMasters';
		}).hideElement = this.bpjsAccidentMastersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsAccidentMasters').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsClaimSubmissions';
		}).hideElement = this.bpjsClaimSubmissionsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsClaimSubmissions').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsHospitalizationPlans';
		}).hideElement = this.bpjsHospitalizationPlansMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsHospitalizationPlans').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsJasaRaharjas';
		}).hideElement = this.bpjsJasaRaharjasMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsJasaRaharjas').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsPatientReferrals';
		}).hideElement = this.bpjsPatientReferralsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsPatientReferrals').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsSEPSubmissions';
		}).hideElement = this.bpjsSEPSubmissionsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsSEPSubmissions').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsSEPs';
		}).hideElement = this.bpjsSEPsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsSEPs').hideElement;

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
		if (this.patientGeneralInfoMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientGeneralInfoDisplayName, many: false});
		}

		if (this.bpjsAccidentMastersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsAccidentMastersDisplayName, many: true});
			this.store.dispatch(new bpjsAccidentMasterModelAction.BpjsAccidentMasterAction(
				bpjsAccidentMasterModelAction.BpjsAccidentMasterModelActionTypes.INITIALISE_BPJS_ACCIDENT_MASTER_COLLECTION_STATE,
				{
					collectionId: this.bpjsAccidentMastersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsAccidentMasterCollectionModels, this.bpjsAccidentMastersCollectionId).subscribe(models => {
				models.forEach(bpjsAccidentMasters => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsAccidentMasterModel.getProps(), this.bpjsAccidentMastersRelations, this.isViewOnly),
						bpjsAccidentMasters,
						BpjsAccidentMasterModel,
						this.bpjsAccidentMastersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bpjsAccidentMastersRelations,
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

		if (this.bpjsHospitalizationPlansMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsHospitalizationPlansDisplayName, many: true});
			this.store.dispatch(new bpjsHospitalizationPlanModelAction.BpjsHospitalizationPlanAction(
				bpjsHospitalizationPlanModelAction.BpjsHospitalizationPlanModelActionTypes.INITIALISE_BPJS_HOSPITALIZATION_PLAN_COLLECTION_STATE,
				{
					collectionId: this.bpjsHospitalizationPlansCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsHospitalizationPlanCollectionModels, this.bpjsHospitalizationPlansCollectionId).subscribe(models => {
				models.forEach(bpjsHospitalizationPlans => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsHospitalizationPlanModel.getProps(), this.bpjsHospitalizationPlansRelations, this.isViewOnly),
						bpjsHospitalizationPlans,
						BpjsHospitalizationPlanModel,
						this.bpjsHospitalizationPlansDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bpjsHospitalizationPlansRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.bpjsJasaRaharjasMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsJasaRaharjasDisplayName, many: true});
			this.store.dispatch(new bpjsJasaRaharjaModelAction.BpjsJasaRaharjaAction(
				bpjsJasaRaharjaModelAction.BpjsJasaRaharjaModelActionTypes.INITIALISE_BPJS_JASA_RAHARJA_COLLECTION_STATE,
				{
					collectionId: this.bpjsJasaRaharjasCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsJasaRaharjaCollectionModels, this.bpjsJasaRaharjasCollectionId).subscribe(models => {
				models.forEach(bpjsJasaRaharjas => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsJasaRaharjaModel.getProps(), this.bpjsJasaRaharjasRelations, this.isViewOnly),
						bpjsJasaRaharjas,
						BpjsJasaRaharjaModel,
						this.bpjsJasaRaharjasDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bpjsJasaRaharjasRelations,
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

		if (this.bpjsSEPSubmissionsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsSEPSubmissionsDisplayName, many: true});
			this.store.dispatch(new bpjsSEPSubmissionModelAction.BpjsSEPSubmissionAction(
				bpjsSEPSubmissionModelAction.BpjsSEPSubmissionModelActionTypes.INITIALISE_BPJS_SEP_SUBMISSION_COLLECTION_STATE,
				{
					collectionId: this.bpjsSEPSubmissionsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsSEPSubmissionCollectionModels, this.bpjsSEPSubmissionsCollectionId).subscribe(models => {
				models.forEach(bpjsSEPSubmissions => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsSEPSubmissionModel.getProps(), this.bpjsSEPSubmissionsRelations, this.isViewOnly),
						bpjsSEPSubmissions,
						BpjsSEPSubmissionModel,
						this.bpjsSEPSubmissionsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bpjsSEPSubmissionsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.bpjsSEPsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsSEPsDisplayName, many: true});
			this.store.dispatch(new bpjsSEPModelAction.BpjsSEPAction(
				bpjsSEPModelAction.BpjsSEPModelActionTypes.INITIALISE_BPJS_SEP_COLLECTION_STATE,
				{
					collectionId: this.bpjsSEPsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsSEPCollectionModels, this.bpjsSEPsCollectionId).subscribe(models => {
				models.forEach(bpjsSEPs => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsSEPModel.getProps(), this.bpjsSEPsRelations, this.isViewOnly),
						bpjsSEPs,
						BpjsSEPModel,
						this.bpjsSEPsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bpjsSEPsRelations,
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
		if (this.targetModel.patientGeneralInfo && this.targetModel.patientGeneralInfo.id && this.patientGeneralInfoMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientGeneralInfoModel,
				this.patientGeneralInfoOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientGeneralInfo.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientGeneralInfoModelWithId, this.targetModel.patientGeneralInfoId).subscribe(patientGeneralInfo => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientGeneralInfoModel.getProps(), this.patientGeneralInfoRelations, this.isViewOnly),
					patientGeneralInfo,
					PatientGeneralInfoModel,
					this.patientGeneralInfoDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientGeneralInfoRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bpjsAccidentMastersIds && this.targetModel.bpjsAccidentMastersIds.length > 0 && this.bpjsAccidentMastersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsAccidentMasterModel,
				this.bpjsAccidentMastersOppositeRelation,
				this.bpjsAccidentMastersCollectionId,
				this.targetModel.bpjsAccidentMastersIds.length,
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

		if (this.targetModel.bpjsHospitalizationPlansIds && this.targetModel.bpjsHospitalizationPlansIds.length > 0 && this.bpjsHospitalizationPlansMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsHospitalizationPlanModel,
				this.bpjsHospitalizationPlansOppositeRelation,
				this.bpjsHospitalizationPlansCollectionId,
				this.targetModel.bpjsHospitalizationPlansIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.bpjsJasaRaharjasIds && this.targetModel.bpjsJasaRaharjasIds.length > 0 && this.bpjsJasaRaharjasMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsJasaRaharjaModel,
				this.bpjsJasaRaharjasOppositeRelation,
				this.bpjsJasaRaharjasCollectionId,
				this.targetModel.bpjsJasaRaharjasIds.length,
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

		if (this.targetModel.bpjsSEPSubmissionsIds && this.targetModel.bpjsSEPSubmissionsIds.length > 0 && this.bpjsSEPSubmissionsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsSEPSubmissionModel,
				this.bpjsSEPSubmissionsOppositeRelation,
				this.bpjsSEPSubmissionsCollectionId,
				this.targetModel.bpjsSEPSubmissionsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.bpjsSEPsIds && this.targetModel.bpjsSEPsIds.length > 0 && this.bpjsSEPsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsSEPModel,
				this.bpjsSEPsOppositeRelation,
				this.bpjsSEPsCollectionId,
				this.targetModel.bpjsSEPsIds.length,
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
	addAdditionalEntitiesToModel(model: PatientPaymentBPJSModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): PatientPaymentBPJSModel {
		let updatedModel: PatientPaymentBPJSModel = new PatientPaymentBPJSModel(model);

		if (this.patientGeneralInfoMultiCrudActive) {
			updatedModel.patientGeneralInfo = event.additionalEntities.patientGeneralInfo ? event.additionalEntities.patientGeneralInfo : undefined;

			if (!updatedModel.patientGeneralInfo && event.payload) {
				event.payload.patientGeneralInfoId = null;
			}
		} else if (event.payload?.patientGeneralInfoId !== undefined) {
			event.payload.patientGeneralInfo = null;
			updatedModel.patientGeneralInfo = null;
		}

		updatedModel.bpjsAccidentMasters = [];
		if (this.bpjsAccidentMastersMultiCrudActive) {
			if (event.additionalEntities.bpjsAccidentMasters) {
				event.additionalEntities.bpjsAccidentMasters.forEach(entity => {
					updatedModel.bpjsAccidentMasters.push(entity);
				});
			}

			if (!updatedModel.bpjsAccidentMasters.length) {
				updatedModel.bpjsAccidentMastersIds = [];
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
		updatedModel.bpjsHospitalizationPlans = [];
		if (this.bpjsHospitalizationPlansMultiCrudActive) {
			if (event.additionalEntities.bpjsHospitalizationPlans) {
				event.additionalEntities.bpjsHospitalizationPlans.forEach(entity => {
					updatedModel.bpjsHospitalizationPlans.push(entity);
				});
			}

			if (!updatedModel.bpjsHospitalizationPlans.length) {
				updatedModel.bpjsHospitalizationPlansIds = [];
			}
		}
		updatedModel.bpjsJasaRaharjas = [];
		if (this.bpjsJasaRaharjasMultiCrudActive) {
			if (event.additionalEntities.bpjsJasaRaharjas) {
				event.additionalEntities.bpjsJasaRaharjas.forEach(entity => {
					updatedModel.bpjsJasaRaharjas.push(entity);
				});
			}

			if (!updatedModel.bpjsJasaRaharjas.length) {
				updatedModel.bpjsJasaRaharjasIds = [];
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
		updatedModel.bpjsSEPSubmissions = [];
		if (this.bpjsSEPSubmissionsMultiCrudActive) {
			if (event.additionalEntities.bpjsSEPSubmissions) {
				event.additionalEntities.bpjsSEPSubmissions.forEach(entity => {
					updatedModel.bpjsSEPSubmissions.push(entity);
				});
			}

			if (!updatedModel.bpjsSEPSubmissions.length) {
				updatedModel.bpjsSEPSubmissionsIds = [];
			}
		}
		updatedModel.bpjsSEPs = [];
		if (this.bpjsSEPsMultiCrudActive) {
			if (event.additionalEntities.bpjsSEPs) {
				event.additionalEntities.bpjsSEPs.forEach(entity => {
					updatedModel.bpjsSEPs.push(entity);
				});
			}

			if (!updatedModel.bpjsSEPs.length) {
				updatedModel.bpjsSEPsIds = [];
			}
		}
		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}