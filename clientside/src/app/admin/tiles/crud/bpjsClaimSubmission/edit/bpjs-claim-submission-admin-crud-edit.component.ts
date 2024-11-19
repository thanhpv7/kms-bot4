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
import * as modelAction from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.action';
import {BpjsClaimSubmissionModelState, BpjsClaimSubmissionModelAudit} from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.state';
import {BpjsClaimSubmissionModel} from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import {
	getBpjsClaimSubmissionModelAuditsByEntityId,
	getBpjsClaimSubmissionModelWithId,
	getCountBpjsClaimSubmissionModels,
} from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {BpjsDiagnoseModel} from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model';
import * as bpjsDiagnoseModelAction from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.action';
import {
	getBpjsDiagnoseCollectionModels, getBpjsDiagnoseModelWithId,
} from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import {BpjsDismissalConditionModel} from 'src/app/models/bpjsDismissalCondition/bpjs_dismissal_condition.model';
import * as bpjsDismissalConditionModelAction from 'src/app/models/bpjsDismissalCondition/bpjs_dismissal_condition.model.action';
import {
	getBpjsDismissalConditionCollectionModels, getBpjsDismissalConditionModelWithId,
} from 'src/app/models/bpjsDismissalCondition/bpjs_dismissal_condition.model.selector';
import {BpjsDismissalMappingModel} from 'src/app/models/bpjsDismissalMapping/bpjs_dismissal_mapping.model';
import * as bpjsDismissalMappingModelAction from 'src/app/models/bpjsDismissalMapping/bpjs_dismissal_mapping.model.action';
import {
	getBpjsDismissalMappingCollectionModels, getBpjsDismissalMappingModelWithId,
} from 'src/app/models/bpjsDismissalMapping/bpjs_dismissal_mapping.model.selector';
import {BpjsDoctorMappingModel} from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model';
import * as bpjsDoctorMappingModelAction from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.action';
import {
	getBpjsDoctorMappingCollectionModels, getBpjsDoctorMappingModelWithId,
} from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import {BpjsHealthFacilityModel} from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model';
import * as bpjsHealthFacilityModelAction from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.action';
import {
	getBpjsHealthFacilityCollectionModels, getBpjsHealthFacilityModelWithId,
} from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.selector';
import {BpjsProcedureModel} from 'src/app/models/bpjsProcedure/bpjs_procedure.model';
import * as bpjsProcedureModelAction from 'src/app/models/bpjsProcedure/bpjs_procedure.model.action';
import {
	getBpjsProcedureCollectionModels, getBpjsProcedureModelWithId,
} from 'src/app/models/bpjsProcedure/bpjs_procedure.model.selector';
import {BpjsServiceMappingModel} from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model';
import * as bpjsServiceMappingModelAction from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.action';
import {
	getBpjsServiceMappingCollectionModels, getBpjsServiceMappingModelWithId,
} from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import {BpjsTreatmentRoomModel} from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model';
import * as bpjsTreatmentRoomModelAction from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model.action';
import {
	getBpjsTreatmentRoomCollectionModels, getBpjsTreatmentRoomModelWithId,
} from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model.selector';
import {PatientGeneralInfoModel} from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import * as patientGeneralInfoModelAction from 'src/app/models/patientGeneralInfo/patient_general_info.model.action';
import {
	getPatientGeneralInfoCollectionModels, getPatientGeneralInfoModelWithId,
} from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import {PatientPaymentBPJSModel} from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model';
import * as patientPaymentBPJSModelAction from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.action';
import {
	getPatientPaymentBPJSCollectionModels, getPatientPaymentBPJSModelWithId,
} from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../bpjs-claim-submission-admin-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-bpjs-claim-submission-admin-crud-edit',
	templateUrl: './bpjs-claim-submission-admin-crud-edit.component.html',
	styleUrls: [
		'./bpjs-claim-submission-admin-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class AdminBpjsClaimSubmissionCrudEditComponent
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
	collectionId: string = '1ba77a86-2440-464c-9dfc-e734edb11968';
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
	bpjsClaimSubmissionAudits$: Observable<BpjsClaimSubmissionModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Diagnose and BPJS Claim Submissions here] off begin
	bpjsDiagnoseMultiCrudActive: boolean = false;
	bpjsDiagnoseDisplayName = 'BPJS Diagnose';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Diagnose and BPJS Claim Submissions here] end
	bpjsDiagnoseOppositeRelation = 'bpjsClaimSubmissions';
	bpjsDiagnoseRelations: ModelRelation[] = this.bpjsDiagnoseMultiCrudActive ? BpjsDiagnoseModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsDiagnoseOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Doctor Mapping and BPJS Claim Submissions here] off begin
	bpjsDoctorMappingMultiCrudActive: boolean = false;
	bpjsDoctorMappingDisplayName = 'BPJS Doctor Mapping';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Doctor Mapping and BPJS Claim Submissions here] end
	bpjsDoctorMappingOppositeRelation = 'bpjsClaimSubmissions';
	bpjsDoctorMappingRelations: ModelRelation[] = this.bpjsDoctorMappingMultiCrudActive ? BpjsDoctorMappingModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsDoctorMappingOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Health Facility and BPJS Claim Submissions here] off begin
	bpjsHealthFacilityMultiCrudActive: boolean = false;
	bpjsHealthFacilityDisplayName = 'BPJS Health Facility';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Health Facility and BPJS Claim Submissions here] end
	bpjsHealthFacilityOppositeRelation = 'bpjsClaimSubmissions';
	bpjsHealthFacilityRelations: ModelRelation[] = this.bpjsHealthFacilityMultiCrudActive ? BpjsHealthFacilityModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsHealthFacilityOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Procedure and BPJS Claim Submissions here] off begin
	bpjsProcedureMultiCrudActive: boolean = false;
	bpjsProcedureDisplayName = 'BPJS Procedure';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Procedure and BPJS Claim Submissions here] end
	bpjsProcedureOppositeRelation = 'bpjsClaimSubmissions';
	bpjsProcedureRelations: ModelRelation[] = this.bpjsProcedureMultiCrudActive ? BpjsProcedureModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsProcedureOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Service Mapping and BPJS Claim Submissions here] off begin
	bpjsServiceMappingMultiCrudActive: boolean = false;
	bpjsServiceMappingDisplayName = 'BPJS Service Mapping';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Service Mapping and BPJS Claim Submissions here] end
	bpjsServiceMappingOppositeRelation = 'bpjsClaimSubmissions';
	bpjsServiceMappingRelations: ModelRelation[] = this.bpjsServiceMappingMultiCrudActive ? BpjsServiceMappingModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsServiceMappingOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and BPJS Claim Submissions here] off begin
	patientGeneralInfoMultiCrudActive: boolean = false;
	patientGeneralInfoDisplayName = 'Patient General Info';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and BPJS Claim Submissions here] end
	patientGeneralInfoOppositeRelation = 'bpjsClaimSubmissions';
	patientGeneralInfoRelations: ModelRelation[] = this.patientGeneralInfoMultiCrudActive ? PatientGeneralInfoModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientGeneralInfoOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Payment BPJS and BPJS Claim Submissions here] off begin
	patientPaymentBPJSMultiCrudActive: boolean = false;
	patientPaymentBPJSDisplayName = 'Patient Payment BPJS';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Payment BPJS and BPJS Claim Submissions here] end
	patientPaymentBPJSOppositeRelation = 'bpjsClaimSubmissions';
	patientPaymentBPJSRelations: ModelRelation[] = this.patientPaymentBPJSMultiCrudActive ? PatientPaymentBPJSModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientPaymentBPJSOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Claim Submission and BPJS Dismissal Conditions here] off begin
	bpjsDismissalConditionsMultiCrudActive: boolean = false;
	bpjsDismissalConditionsDisplayName = 'BPJS Dismissal Conditions';
	bpjsDismissalConditionsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Claim Submission and BPJS Dismissal Conditions here] end
	bpjsDismissalConditionsOppositeRelation = 'bpjsClaimSubmission';
	bpjsDismissalConditionsRelations: ModelRelation[] = this.bpjsDismissalConditionsMultiCrudActive ? BpjsDismissalConditionModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsDismissalConditionsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Claim Submission and BPJS Dismissal Mappings here] off begin
	bpjsDismissalMappingsMultiCrudActive: boolean = false;
	bpjsDismissalMappingsDisplayName = 'BPJS Dismissal Mappings';
	bpjsDismissalMappingsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Claim Submission and BPJS Dismissal Mappings here] end
	bpjsDismissalMappingsOppositeRelation = 'bpjsClaimSubmission';
	bpjsDismissalMappingsRelations: ModelRelation[] = this.bpjsDismissalMappingsMultiCrudActive ? BpjsDismissalMappingModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsDismissalMappingsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Claim Submission and BPJS Treatment Rooms here] off begin
	bpjsTreatmentRoomsMultiCrudActive: boolean = false;
	bpjsTreatmentRoomsDisplayName = 'BPJS Treatment Rooms';
	bpjsTreatmentRoomsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Claim Submission and BPJS Treatment Rooms here] end
	bpjsTreatmentRoomsOppositeRelation = 'bpjsClaimSubmission';
	bpjsTreatmentRoomsRelations: ModelRelation[] = this.bpjsTreatmentRoomsMultiCrudActive ? BpjsTreatmentRoomModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsTreatmentRoomsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = BpjsClaimSubmissionModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = BpjsClaimSubmissionModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = BpjsClaimSubmissionModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'bpjsDiagnose' && this.bpjsDiagnoseMultiCrudActive) {
					exp.fields = BpjsDiagnoseModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsDoctorMapping' && this.bpjsDoctorMappingMultiCrudActive) {
					exp.fields = BpjsDoctorMappingModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsHealthFacility' && this.bpjsHealthFacilityMultiCrudActive) {
					exp.fields = BpjsHealthFacilityModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsProcedure' && this.bpjsProcedureMultiCrudActive) {
					exp.fields = BpjsProcedureModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsServiceMapping' && this.bpjsServiceMappingMultiCrudActive) {
					exp.fields = BpjsServiceMappingModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientGeneralInfo' && this.patientGeneralInfoMultiCrudActive) {
					exp.fields = PatientGeneralInfoModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientPaymentBPJS' && this.patientPaymentBPJSMultiCrudActive) {
					exp.fields = PatientPaymentBPJSModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsDismissalConditions' && this.bpjsDismissalConditionsMultiCrudActive) {
					exp.fields = BpjsDismissalConditionModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsDismissalMappings' && this.bpjsDismissalMappingsMultiCrudActive) {
					exp.fields = BpjsDismissalMappingModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsTreatmentRooms' && this.bpjsTreatmentRoomsMultiCrudActive) {
					exp.fields = BpjsTreatmentRoomModel.getProps().map(prop => {
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
	targetModel: BpjsClaimSubmissionModel;

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
		private readonly store: Store<{ model: BpjsClaimSubmissionModelState }>,
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
		this.creationNavigationSubscription$.add(this.store.select(getCountBpjsClaimSubmissionModels).subscribe(count => {
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

			this.targetModel = new BpjsClaimSubmissionModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.bpjsClaimSubmissionAudits$ = this.store.select(getBpjsClaimSubmissionModelAuditsByEntityId, this.targetModelId);
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
		const stateConfig: PassableStateConfig<BpjsClaimSubmissionModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.BpjsClaimSubmissionAction(
			modelAction.BpjsClaimSubmissionModelActionTypes.FETCH_BPJS_CLAIM_SUBMISSION,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getBpjsClaimSubmissionModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new BpjsClaimSubmissionModel(model);
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
			commands.push('bpjs-claim-submission');

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

		this.store.dispatch(new modelAction.BpjsClaimSubmissionAction(
			modelAction.BpjsClaimSubmissionModelActionTypes.FETCH_BPJS_CLAIM_SUBMISSION_AUDITS_BY_ENTITY_ID,
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
			let stateConfig: PassableStateConfig<BpjsClaimSubmissionModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.bpjsDiagnoseMultiCrudActive || this.bpjsDoctorMappingMultiCrudActive || this.bpjsHealthFacilityMultiCrudActive || this.bpjsProcedureMultiCrudActive || this.bpjsServiceMappingMultiCrudActive || this.patientGeneralInfoMultiCrudActive || this.patientPaymentBPJSMultiCrudActive || this.bpjsDismissalConditionsMultiCrudActive || this.bpjsDismissalMappingsMultiCrudActive || this.bpjsTreatmentRoomsMultiCrudActive,
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
					new modelAction.BpjsClaimSubmissionAction(
						modelAction.BpjsClaimSubmissionModelActionTypes.COUNT_BPJS_CLAIM_SUBMISSIONS,
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

			this.store.dispatch(new modelAction.BpjsClaimSubmissionAction(
				modelAction.BpjsClaimSubmissionModelActionTypes.CREATE_BPJS_CLAIM_SUBMISSION,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<BpjsClaimSubmissionModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.bpjsDiagnoseMultiCrudActive || this.bpjsDoctorMappingMultiCrudActive || this.bpjsHealthFacilityMultiCrudActive || this.bpjsProcedureMultiCrudActive || this.bpjsServiceMappingMultiCrudActive || this.patientGeneralInfoMultiCrudActive || this.patientPaymentBPJSMultiCrudActive || this.bpjsDismissalConditionsMultiCrudActive || this.bpjsDismissalMappingsMultiCrudActive || this.bpjsTreatmentRoomsMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.BpjsClaimSubmissionAction(
					modelAction.BpjsClaimSubmissionModelActionTypes.FETCH_BPJS_CLAIM_SUBMISSION,
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

			this.store.dispatch(new modelAction.BpjsClaimSubmissionAction(
				modelAction.BpjsClaimSubmissionModelActionTypes.UPDATE_BPJS_CLAIM_SUBMISSION,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: BpjsClaimSubmissionModel = new BpjsClaimSubmissionModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getBpjsClaimSubmissionModelWithId, this.targetModelId).subscribe(model => {
					let differences = new BpjsClaimSubmissionModel(model).difference(updatedModel);

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
			if (event.entityName === this.bpjsDiagnoseDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsDiagnoseModel.getProps(), this.bpjsDiagnoseRelations, this.isViewOnly),
					new BpjsDiagnoseModel(),
					BpjsDiagnoseModel,
					this.bpjsDiagnoseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsDiagnoseRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsDoctorMappingDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsDoctorMappingModel.getProps(), this.bpjsDoctorMappingRelations, this.isViewOnly),
					new BpjsDoctorMappingModel(),
					BpjsDoctorMappingModel,
					this.bpjsDoctorMappingDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsDoctorMappingRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsHealthFacilityDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsHealthFacilityModel.getProps(), this.bpjsHealthFacilityRelations, this.isViewOnly),
					new BpjsHealthFacilityModel(),
					BpjsHealthFacilityModel,
					this.bpjsHealthFacilityDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsHealthFacilityRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsProcedureDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsProcedureModel.getProps(), this.bpjsProcedureRelations, this.isViewOnly),
					new BpjsProcedureModel(),
					BpjsProcedureModel,
					this.bpjsProcedureDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsProcedureRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsServiceMappingDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsServiceMappingModel.getProps(), this.bpjsServiceMappingRelations, this.isViewOnly),
					new BpjsServiceMappingModel(),
					BpjsServiceMappingModel,
					this.bpjsServiceMappingDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsServiceMappingRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

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

			if (event.entityName === this.patientPaymentBPJSDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientPaymentBPJSModel.getProps(), this.patientPaymentBPJSRelations, this.isViewOnly),
					new PatientPaymentBPJSModel(),
					PatientPaymentBPJSModel,
					this.patientPaymentBPJSDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientPaymentBPJSRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsDismissalConditionsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsDismissalConditionModel.getProps(), this.bpjsDismissalConditionsRelations, this.isViewOnly),
					new BpjsDismissalConditionModel(),
					BpjsDismissalConditionModel,
					this.bpjsDismissalConditionsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsDismissalConditionsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsDismissalMappingsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsDismissalMappingModel.getProps(), this.bpjsDismissalMappingsRelations, this.isViewOnly),
					new BpjsDismissalMappingModel(),
					BpjsDismissalMappingModel,
					this.bpjsDismissalMappingsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsDismissalMappingsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsTreatmentRoomsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsTreatmentRoomModel.getProps(), this.bpjsTreatmentRoomsRelations, this.isViewOnly),
					new BpjsTreatmentRoomModel(),
					BpjsTreatmentRoomModel,
					this.bpjsTreatmentRoomsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsTreatmentRoomsRelations,
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
		this.modelProperties = BpjsClaimSubmissionModel.getProps();
		this.modelRelations = BpjsClaimSubmissionModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'bpjsDiagnose';
		}).hideElement = this.bpjsDiagnoseMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsDiagnose').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsDoctorMapping';
		}).hideElement = this.bpjsDoctorMappingMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsDoctorMapping').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsHealthFacility';
		}).hideElement = this.bpjsHealthFacilityMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsHealthFacility').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsProcedure';
		}).hideElement = this.bpjsProcedureMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsProcedure').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsServiceMapping';
		}).hideElement = this.bpjsServiceMappingMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsServiceMapping').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientGeneralInfo';
		}).hideElement = this.patientGeneralInfoMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientGeneralInfo').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientPaymentBPJS';
		}).hideElement = this.patientPaymentBPJSMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientPaymentBPJS').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsDismissalConditions';
		}).hideElement = this.bpjsDismissalConditionsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsDismissalConditions').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsDismissalMappings';
		}).hideElement = this.bpjsDismissalMappingsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsDismissalMappings').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsTreatmentRooms';
		}).hideElement = this.bpjsTreatmentRoomsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsTreatmentRooms').hideElement;

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
		if (this.bpjsDiagnoseMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsDiagnoseDisplayName, many: false});
		}

		if (this.bpjsDoctorMappingMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsDoctorMappingDisplayName, many: false});
		}

		if (this.bpjsHealthFacilityMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsHealthFacilityDisplayName, many: false});
		}

		if (this.bpjsProcedureMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsProcedureDisplayName, many: false});
		}

		if (this.bpjsServiceMappingMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsServiceMappingDisplayName, many: false});
		}

		if (this.patientGeneralInfoMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientGeneralInfoDisplayName, many: false});
		}

		if (this.patientPaymentBPJSMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientPaymentBPJSDisplayName, many: false});
		}

		if (this.bpjsDismissalConditionsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsDismissalConditionsDisplayName, many: true});
			this.store.dispatch(new bpjsDismissalConditionModelAction.BpjsDismissalConditionAction(
				bpjsDismissalConditionModelAction.BpjsDismissalConditionModelActionTypes.INITIALISE_BPJS_DISMISSAL_CONDITION_COLLECTION_STATE,
				{
					collectionId: this.bpjsDismissalConditionsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsDismissalConditionCollectionModels, this.bpjsDismissalConditionsCollectionId).subscribe(models => {
				models.forEach(bpjsDismissalConditions => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsDismissalConditionModel.getProps(), this.bpjsDismissalConditionsRelations, this.isViewOnly),
						bpjsDismissalConditions,
						BpjsDismissalConditionModel,
						this.bpjsDismissalConditionsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bpjsDismissalConditionsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.bpjsDismissalMappingsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsDismissalMappingsDisplayName, many: true});
			this.store.dispatch(new bpjsDismissalMappingModelAction.BpjsDismissalMappingAction(
				bpjsDismissalMappingModelAction.BpjsDismissalMappingModelActionTypes.INITIALISE_BPJS_DISMISSAL_MAPPING_COLLECTION_STATE,
				{
					collectionId: this.bpjsDismissalMappingsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsDismissalMappingCollectionModels, this.bpjsDismissalMappingsCollectionId).subscribe(models => {
				models.forEach(bpjsDismissalMappings => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsDismissalMappingModel.getProps(), this.bpjsDismissalMappingsRelations, this.isViewOnly),
						bpjsDismissalMappings,
						BpjsDismissalMappingModel,
						this.bpjsDismissalMappingsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bpjsDismissalMappingsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.bpjsTreatmentRoomsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsTreatmentRoomsDisplayName, many: true});
			this.store.dispatch(new bpjsTreatmentRoomModelAction.BpjsTreatmentRoomAction(
				bpjsTreatmentRoomModelAction.BpjsTreatmentRoomModelActionTypes.INITIALISE_BPJS_TREATMENT_ROOM_COLLECTION_STATE,
				{
					collectionId: this.bpjsTreatmentRoomsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsTreatmentRoomCollectionModels, this.bpjsTreatmentRoomsCollectionId).subscribe(models => {
				models.forEach(bpjsTreatmentRooms => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsTreatmentRoomModel.getProps(), this.bpjsTreatmentRoomsRelations, this.isViewOnly),
						bpjsTreatmentRooms,
						BpjsTreatmentRoomModel,
						this.bpjsTreatmentRoomsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bpjsTreatmentRoomsRelations,
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
		if (this.targetModel.bpjsDiagnose && this.targetModel.bpjsDiagnose.id && this.bpjsDiagnoseMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsDiagnoseModel,
				this.bpjsDiagnoseOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bpjsDiagnose.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsDiagnoseModelWithId, this.targetModel.bpjsDiagnoseId).subscribe(bpjsDiagnose => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsDiagnoseModel.getProps(), this.bpjsDiagnoseRelations, this.isViewOnly),
					bpjsDiagnose,
					BpjsDiagnoseModel,
					this.bpjsDiagnoseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsDiagnoseRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bpjsDoctorMapping && this.targetModel.bpjsDoctorMapping.id && this.bpjsDoctorMappingMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsDoctorMappingModel,
				this.bpjsDoctorMappingOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bpjsDoctorMapping.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsDoctorMappingModelWithId, this.targetModel.bpjsDoctorMappingId).subscribe(bpjsDoctorMapping => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsDoctorMappingModel.getProps(), this.bpjsDoctorMappingRelations, this.isViewOnly),
					bpjsDoctorMapping,
					BpjsDoctorMappingModel,
					this.bpjsDoctorMappingDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsDoctorMappingRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bpjsHealthFacility && this.targetModel.bpjsHealthFacility.id && this.bpjsHealthFacilityMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsHealthFacilityModel,
				this.bpjsHealthFacilityOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bpjsHealthFacility.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsHealthFacilityModelWithId, this.targetModel.bpjsHealthFacilityId).subscribe(bpjsHealthFacility => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsHealthFacilityModel.getProps(), this.bpjsHealthFacilityRelations, this.isViewOnly),
					bpjsHealthFacility,
					BpjsHealthFacilityModel,
					this.bpjsHealthFacilityDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsHealthFacilityRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bpjsProcedure && this.targetModel.bpjsProcedure.id && this.bpjsProcedureMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsProcedureModel,
				this.bpjsProcedureOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bpjsProcedure.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsProcedureModelWithId, this.targetModel.bpjsProcedureId).subscribe(bpjsProcedure => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsProcedureModel.getProps(), this.bpjsProcedureRelations, this.isViewOnly),
					bpjsProcedure,
					BpjsProcedureModel,
					this.bpjsProcedureDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsProcedureRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bpjsServiceMapping && this.targetModel.bpjsServiceMapping.id && this.bpjsServiceMappingMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsServiceMappingModel,
				this.bpjsServiceMappingOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bpjsServiceMapping.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsServiceMappingModelWithId, this.targetModel.bpjsServiceMappingId).subscribe(bpjsServiceMapping => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsServiceMappingModel.getProps(), this.bpjsServiceMappingRelations, this.isViewOnly),
					bpjsServiceMapping,
					BpjsServiceMappingModel,
					this.bpjsServiceMappingDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsServiceMappingRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

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

		if (this.targetModel.patientPaymentBPJS && this.targetModel.patientPaymentBPJS.id && this.patientPaymentBPJSMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientPaymentBPJSModel,
				this.patientPaymentBPJSOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientPaymentBPJS.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientPaymentBPJSModelWithId, this.targetModel.patientPaymentBPJSId).subscribe(patientPaymentBPJS => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientPaymentBPJSModel.getProps(), this.patientPaymentBPJSRelations, this.isViewOnly),
					patientPaymentBPJS,
					PatientPaymentBPJSModel,
					this.patientPaymentBPJSDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientPaymentBPJSRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bpjsDismissalConditionsIds && this.targetModel.bpjsDismissalConditionsIds.length > 0 && this.bpjsDismissalConditionsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsDismissalConditionModel,
				this.bpjsDismissalConditionsOppositeRelation,
				this.bpjsDismissalConditionsCollectionId,
				this.targetModel.bpjsDismissalConditionsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.bpjsDismissalMappingsIds && this.targetModel.bpjsDismissalMappingsIds.length > 0 && this.bpjsDismissalMappingsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsDismissalMappingModel,
				this.bpjsDismissalMappingsOppositeRelation,
				this.bpjsDismissalMappingsCollectionId,
				this.targetModel.bpjsDismissalMappingsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.bpjsTreatmentRoomsIds && this.targetModel.bpjsTreatmentRoomsIds.length > 0 && this.bpjsTreatmentRoomsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsTreatmentRoomModel,
				this.bpjsTreatmentRoomsOppositeRelation,
				this.bpjsTreatmentRoomsCollectionId,
				this.targetModel.bpjsTreatmentRoomsIds.length,
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
	addAdditionalEntitiesToModel(model: BpjsClaimSubmissionModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): BpjsClaimSubmissionModel {
		let updatedModel: BpjsClaimSubmissionModel = new BpjsClaimSubmissionModel(model);

		if (this.bpjsDiagnoseMultiCrudActive) {
			updatedModel.bpjsDiagnose = event.additionalEntities.bpjsDiagnose ? event.additionalEntities.bpjsDiagnose : undefined;

			if (!updatedModel.bpjsDiagnose && event.payload) {
				event.payload.bpjsDiagnoseId = null;
			}
		} else if (event.payload?.bpjsDiagnoseId !== undefined) {
			event.payload.bpjsDiagnose = null;
			updatedModel.bpjsDiagnose = null;
		}

		if (this.bpjsDoctorMappingMultiCrudActive) {
			updatedModel.bpjsDoctorMapping = event.additionalEntities.bpjsDoctorMapping ? event.additionalEntities.bpjsDoctorMapping : undefined;

			if (!updatedModel.bpjsDoctorMapping && event.payload) {
				event.payload.bpjsDoctorMappingId = null;
			}
		} else if (event.payload?.bpjsDoctorMappingId !== undefined) {
			event.payload.bpjsDoctorMapping = null;
			updatedModel.bpjsDoctorMapping = null;
		}

		if (this.bpjsHealthFacilityMultiCrudActive) {
			updatedModel.bpjsHealthFacility = event.additionalEntities.bpjsHealthFacility ? event.additionalEntities.bpjsHealthFacility : undefined;

			if (!updatedModel.bpjsHealthFacility && event.payload) {
				event.payload.bpjsHealthFacilityId = null;
			}
		} else if (event.payload?.bpjsHealthFacilityId !== undefined) {
			event.payload.bpjsHealthFacility = null;
			updatedModel.bpjsHealthFacility = null;
		}

		if (this.bpjsProcedureMultiCrudActive) {
			updatedModel.bpjsProcedure = event.additionalEntities.bpjsProcedure ? event.additionalEntities.bpjsProcedure : undefined;

			if (!updatedModel.bpjsProcedure && event.payload) {
				event.payload.bpjsProcedureId = null;
			}
		} else if (event.payload?.bpjsProcedureId !== undefined) {
			event.payload.bpjsProcedure = null;
			updatedModel.bpjsProcedure = null;
		}

		if (this.bpjsServiceMappingMultiCrudActive) {
			updatedModel.bpjsServiceMapping = event.additionalEntities.bpjsServiceMapping ? event.additionalEntities.bpjsServiceMapping : undefined;

			if (!updatedModel.bpjsServiceMapping && event.payload) {
				event.payload.bpjsServiceMappingId = null;
			}
		} else if (event.payload?.bpjsServiceMappingId !== undefined) {
			event.payload.bpjsServiceMapping = null;
			updatedModel.bpjsServiceMapping = null;
		}

		if (this.patientGeneralInfoMultiCrudActive) {
			updatedModel.patientGeneralInfo = event.additionalEntities.patientGeneralInfo ? event.additionalEntities.patientGeneralInfo : undefined;

			if (!updatedModel.patientGeneralInfo && event.payload) {
				event.payload.patientGeneralInfoId = null;
			}
		} else if (event.payload?.patientGeneralInfoId !== undefined) {
			event.payload.patientGeneralInfo = null;
			updatedModel.patientGeneralInfo = null;
		}

		if (this.patientPaymentBPJSMultiCrudActive) {
			updatedModel.patientPaymentBPJS = event.additionalEntities.patientPaymentBPJS ? event.additionalEntities.patientPaymentBPJS : undefined;

			if (!updatedModel.patientPaymentBPJS && event.payload) {
				event.payload.patientPaymentBPJSId = null;
			}
		} else if (event.payload?.patientPaymentBPJSId !== undefined) {
			event.payload.patientPaymentBPJS = null;
			updatedModel.patientPaymentBPJS = null;
		}

		updatedModel.bpjsDismissalConditions = [];
		if (this.bpjsDismissalConditionsMultiCrudActive) {
			if (event.additionalEntities.bpjsDismissalConditions) {
				event.additionalEntities.bpjsDismissalConditions.forEach(entity => {
					updatedModel.bpjsDismissalConditions.push(entity);
				});
			}

			if (!updatedModel.bpjsDismissalConditions.length) {
				updatedModel.bpjsDismissalConditionsIds = [];
			}
		}
		updatedModel.bpjsDismissalMappings = [];
		if (this.bpjsDismissalMappingsMultiCrudActive) {
			if (event.additionalEntities.bpjsDismissalMappings) {
				event.additionalEntities.bpjsDismissalMappings.forEach(entity => {
					updatedModel.bpjsDismissalMappings.push(entity);
				});
			}

			if (!updatedModel.bpjsDismissalMappings.length) {
				updatedModel.bpjsDismissalMappingsIds = [];
			}
		}
		updatedModel.bpjsTreatmentRooms = [];
		if (this.bpjsTreatmentRoomsMultiCrudActive) {
			if (event.additionalEntities.bpjsTreatmentRooms) {
				event.additionalEntities.bpjsTreatmentRooms.forEach(entity => {
					updatedModel.bpjsTreatmentRooms.push(entity);
				});
			}

			if (!updatedModel.bpjsTreatmentRooms.length) {
				updatedModel.bpjsTreatmentRoomsIds = [];
			}
		}
		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
