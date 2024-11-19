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
import * as modelAction from 'src/app/models/patientVisit/patient_visit.model.action';
import {PatientVisitModelState, PatientVisitModelAudit} from 'src/app/models/patientVisit/patient_visit.model.state';
import {PatientVisitModel} from 'src/app/models/patientVisit/patient_visit.model';
import {
	getPatientVisitModelAuditsByEntityId,
	getPatientVisitModelWithId,
	getCountPatientVisitModels,
} from 'src/app/models/patientVisit/patient_visit.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {BpjsPcareRegistrationsModel} from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model';
import * as bpjsPcareRegistrationsModelAction from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.action';
import {
	getBpjsPcareRegistrationsCollectionModels, getBpjsPcareRegistrationsModelWithId,
} from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import {BpjsVisitDataModel} from 'src/app/models/bpjsVisitData/bpjs_visit_data.model';
import * as bpjsVisitDataModelAction from 'src/app/models/bpjsVisitData/bpjs_visit_data.model.action';
import {
	getBpjsVisitDataCollectionModels, getBpjsVisitDataModelWithId,
} from 'src/app/models/bpjsVisitData/bpjs_visit_data.model.selector';
import {BpjsPcarePendaftaranModel} from 'src/app/models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model';
import * as bpjsPcarePendaftaranModelAction from 'src/app/models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model.action';
import {
	getBpjsPcarePendaftaranCollectionModels, getBpjsPcarePendaftaranModelWithId,
} from 'src/app/models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model.selector';
import {InvoiceModel} from 'src/app/models/invoice/invoice.model';
import * as invoiceModelAction from 'src/app/models/invoice/invoice.model.action';
import {
	getInvoiceCollectionModels, getInvoiceModelWithId,
} from 'src/app/models/invoice/invoice.model.selector';
import {PatientGeneralInfoModel} from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import * as patientGeneralInfoModelAction from 'src/app/models/patientGeneralInfo/patient_general_info.model.action';
import {
	getPatientGeneralInfoCollectionModels, getPatientGeneralInfoModelWithId,
} from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import {PatientVisitPatientPaymentInsuranceModel} from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model';
import * as patientVisitPatientPaymentInsuranceModelAction from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.action';
import {
	getPatientVisitPatientPaymentInsuranceCollectionModels, getPatientVisitPatientPaymentInsuranceModelWithId,
} from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.selector';
import {PatientVisitPatientPaymentOthersModel} from 'src/app/models/patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model';
import * as patientVisitPatientPaymentOthersModelAction from 'src/app/models/patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model.action';
import {
	getPatientVisitPatientPaymentOthersCollectionModels, getPatientVisitPatientPaymentOthersModelWithId,
} from 'src/app/models/patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model.selector';
import {PatientVisitPaymentSelfPayingModel} from 'src/app/models/patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model';
import * as patientVisitPaymentSelfPayingModelAction from 'src/app/models/patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model.action';
import {
	getPatientVisitPaymentSelfPayingCollectionModels, getPatientVisitPaymentSelfPayingModelWithId,
} from 'src/app/models/patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model.selector';
import {RegistrationModel} from 'src/app/models/registration/registration.model';
import * as registrationModelAction from 'src/app/models/registration/registration.model.action';
import {
	getRegistrationCollectionModels, getRegistrationModelWithId,
} from 'src/app/models/registration/registration.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../patient-visit-admin-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-patient-visit-admin-crud-edit',
	templateUrl: './patient-visit-admin-crud-edit.component.html',
	styleUrls: [
		'./patient-visit-admin-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class AdminPatientVisitCrudEditComponent
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
	collectionId: string = '5e5c05b3-d4b7-42aa-9a65-2e116d68c670';
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
	patientVisitAudits$: Observable<PatientVisitModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and BPJS Pcare Registrations here] off begin
	bpjsPcareRegistrationsMultiCrudActive: boolean = false;
	bpjsPcareRegistrationsDisplayName = 'BPJS Pcare Registrations';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and BPJS Pcare Registrations here] end
	bpjsPcareRegistrationsOppositeRelation = 'patientVisit';
	bpjsPcareRegistrationsRelations: ModelRelation[] = this.bpjsPcareRegistrationsMultiCrudActive ? BpjsPcareRegistrationsModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsPcareRegistrationsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and Patient Visit Patient Payment Insurance here] off begin
	patientVisitPatientPaymentInsuranceMultiCrudActive: boolean = false;
	patientVisitPatientPaymentInsuranceDisplayName = 'Patient Visit Patient Payment Insurance';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and Patient Visit Patient Payment Insurance here] end
	patientVisitPatientPaymentInsuranceOppositeRelation = 'patientVisit';
	patientVisitPatientPaymentInsuranceRelations: ModelRelation[] = this.patientVisitPatientPaymentInsuranceMultiCrudActive ? PatientVisitPatientPaymentInsuranceModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientVisitPatientPaymentInsuranceOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and Patient Visit Patient Payment Others here] off begin
	patientVisitPatientPaymentOthersMultiCrudActive: boolean = false;
	patientVisitPatientPaymentOthersDisplayName = 'Patient Visit Patient Payment Others';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and Patient Visit Patient Payment Others here] end
	patientVisitPatientPaymentOthersOppositeRelation = 'patientVisit';
	patientVisitPatientPaymentOthersRelations: ModelRelation[] = this.patientVisitPatientPaymentOthersMultiCrudActive ? PatientVisitPatientPaymentOthersModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientVisitPatientPaymentOthersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and Patient Visit Payment Self Paying here] off begin
	patientVisitPaymentSelfPayingMultiCrudActive: boolean = false;
	patientVisitPaymentSelfPayingDisplayName = 'Patient Visit Payment Self Paying';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and Patient Visit Payment Self Paying here] end
	patientVisitPaymentSelfPayingOppositeRelation = 'patientVisit';
	patientVisitPaymentSelfPayingRelations: ModelRelation[] = this.patientVisitPaymentSelfPayingMultiCrudActive ? PatientVisitPaymentSelfPayingModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientVisitPaymentSelfPayingOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient and Visits here] off begin
	patientMultiCrudActive: boolean = false;
	patientDisplayName = 'Patient';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient and Visits here] end
	patientOppositeRelation = 'visits';
	patientRelations: ModelRelation[] = this.patientMultiCrudActive ? PatientGeneralInfoModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and BPJS Visit Datas here] off begin
	bpjsVisitDatasMultiCrudActive: boolean = false;
	bpjsVisitDatasDisplayName = 'BPJS Visit Datas';
	bpjsVisitDatasCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and BPJS Visit Datas here] end
	bpjsVisitDatasOppositeRelation = 'patientVisit';
	bpjsVisitDatasRelations: ModelRelation[] = this.bpjsVisitDatasMultiCrudActive ? BpjsVisitDataModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsVisitDatasOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and Bpjs Pcare Pendaftarans here] off begin
	bpjsPcarePendaftaransMultiCrudActive: boolean = false;
	bpjsPcarePendaftaransDisplayName = 'Bpjs Pcare Pendaftarans';
	bpjsPcarePendaftaransCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and Bpjs Pcare Pendaftarans here] end
	bpjsPcarePendaftaransOppositeRelation = 'patientVisit';
	bpjsPcarePendaftaransRelations: ModelRelation[] = this.bpjsPcarePendaftaransMultiCrudActive ? BpjsPcarePendaftaranModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsPcarePendaftaransOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and Invoices here] off begin
	invoicesMultiCrudActive: boolean = false;
	invoicesDisplayName = 'Invoices';
	invoicesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and Invoices here] end
	invoicesOppositeRelation = 'patientVisit';
	invoicesRelations: ModelRelation[] = this.invoicesMultiCrudActive ? InvoiceModel.getRelations()
		.map(relation => {
			if (relation.id === this.invoicesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and Registrations here] off begin
	registrationsMultiCrudActive: boolean = false;
	registrationsDisplayName = 'Registrations';
	registrationsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and Registrations here] end
	registrationsOppositeRelation = 'patientVisit';
	registrationsRelations: ModelRelation[] = this.registrationsMultiCrudActive ? RegistrationModel.getRelations()
		.map(relation => {
			if (relation.id === this.registrationsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = PatientVisitModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = PatientVisitModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = PatientVisitModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'bpjsPcareRegistrations' && this.bpjsPcareRegistrationsMultiCrudActive) {
					exp.fields = BpjsPcareRegistrationsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientVisitPatientPaymentInsurance' && this.patientVisitPatientPaymentInsuranceMultiCrudActive) {
					exp.fields = PatientVisitPatientPaymentInsuranceModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientVisitPatientPaymentOthers' && this.patientVisitPatientPaymentOthersMultiCrudActive) {
					exp.fields = PatientVisitPatientPaymentOthersModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientVisitPaymentSelfPaying' && this.patientVisitPaymentSelfPayingMultiCrudActive) {
					exp.fields = PatientVisitPaymentSelfPayingModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patient' && this.patientMultiCrudActive) {
					exp.fields = PatientGeneralInfoModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsVisitDatas' && this.bpjsVisitDatasMultiCrudActive) {
					exp.fields = BpjsVisitDataModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsPcarePendaftarans' && this.bpjsPcarePendaftaransMultiCrudActive) {
					exp.fields = BpjsPcarePendaftaranModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'invoices' && this.invoicesMultiCrudActive) {
					exp.fields = InvoiceModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'registrations' && this.registrationsMultiCrudActive) {
					exp.fields = RegistrationModel.getProps().map(prop => {
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
	targetModel: PatientVisitModel;

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
		private readonly store: Store<{ model: PatientVisitModelState }>,
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
		this.creationNavigationSubscription$.add(this.store.select(getCountPatientVisitModels).subscribe(count => {
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

			this.targetModel = new PatientVisitModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.patientVisitAudits$ = this.store.select(getPatientVisitModelAuditsByEntityId, this.targetModelId);
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
		const stateConfig: PassableStateConfig<PatientVisitModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.PatientVisitAction(
			modelAction.PatientVisitModelActionTypes.FETCH_PATIENT_VISIT,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getPatientVisitModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new PatientVisitModel(model);
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
			commands.push('patient-visit');

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

		this.store.dispatch(new modelAction.PatientVisitAction(
			modelAction.PatientVisitModelActionTypes.FETCH_PATIENT_VISIT_AUDITS_BY_ENTITY_ID,
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
			let stateConfig: PassableStateConfig<PatientVisitModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.bpjsPcareRegistrationsMultiCrudActive || this.patientVisitPatientPaymentInsuranceMultiCrudActive || this.patientVisitPatientPaymentOthersMultiCrudActive || this.patientVisitPaymentSelfPayingMultiCrudActive || this.patientMultiCrudActive || this.bpjsVisitDatasMultiCrudActive || this.bpjsPcarePendaftaransMultiCrudActive || this.invoicesMultiCrudActive || this.registrationsMultiCrudActive,
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
					new modelAction.PatientVisitAction(
						modelAction.PatientVisitModelActionTypes.COUNT_PATIENT_VISITS,
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

			this.store.dispatch(new modelAction.PatientVisitAction(
				modelAction.PatientVisitModelActionTypes.CREATE_PATIENT_VISIT,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<PatientVisitModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.bpjsPcareRegistrationsMultiCrudActive || this.patientVisitPatientPaymentInsuranceMultiCrudActive || this.patientVisitPatientPaymentOthersMultiCrudActive || this.patientVisitPaymentSelfPayingMultiCrudActive || this.patientMultiCrudActive || this.bpjsVisitDatasMultiCrudActive || this.bpjsPcarePendaftaransMultiCrudActive || this.invoicesMultiCrudActive || this.registrationsMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.PatientVisitAction(
					modelAction.PatientVisitModelActionTypes.FETCH_PATIENT_VISIT,
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

			this.store.dispatch(new modelAction.PatientVisitAction(
				modelAction.PatientVisitModelActionTypes.UPDATE_PATIENT_VISIT,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: PatientVisitModel = new PatientVisitModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getPatientVisitModelWithId, this.targetModelId).subscribe(model => {
					let differences = new PatientVisitModel(model).difference(updatedModel);

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
			if (event.entityName === this.bpjsPcareRegistrationsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsPcareRegistrationsModel.getProps(), this.bpjsPcareRegistrationsRelations, this.isViewOnly),
					new BpjsPcareRegistrationsModel(),
					BpjsPcareRegistrationsModel,
					this.bpjsPcareRegistrationsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsPcareRegistrationsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientVisitPatientPaymentInsuranceDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientVisitPatientPaymentInsuranceModel.getProps(), this.patientVisitPatientPaymentInsuranceRelations, this.isViewOnly),
					new PatientVisitPatientPaymentInsuranceModel(),
					PatientVisitPatientPaymentInsuranceModel,
					this.patientVisitPatientPaymentInsuranceDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientVisitPatientPaymentInsuranceRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientVisitPatientPaymentOthersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientVisitPatientPaymentOthersModel.getProps(), this.patientVisitPatientPaymentOthersRelations, this.isViewOnly),
					new PatientVisitPatientPaymentOthersModel(),
					PatientVisitPatientPaymentOthersModel,
					this.patientVisitPatientPaymentOthersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientVisitPatientPaymentOthersRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientVisitPaymentSelfPayingDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientVisitPaymentSelfPayingModel.getProps(), this.patientVisitPaymentSelfPayingRelations, this.isViewOnly),
					new PatientVisitPaymentSelfPayingModel(),
					PatientVisitPaymentSelfPayingModel,
					this.patientVisitPaymentSelfPayingDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientVisitPaymentSelfPayingRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientGeneralInfoModel.getProps(), this.patientRelations, this.isViewOnly),
					new PatientGeneralInfoModel(),
					PatientGeneralInfoModel,
					this.patientDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsVisitDatasDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsVisitDataModel.getProps(), this.bpjsVisitDatasRelations, this.isViewOnly),
					new BpjsVisitDataModel(),
					BpjsVisitDataModel,
					this.bpjsVisitDatasDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsVisitDatasRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsPcarePendaftaransDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsPcarePendaftaranModel.getProps(), this.bpjsPcarePendaftaransRelations, this.isViewOnly),
					new BpjsPcarePendaftaranModel(),
					BpjsPcarePendaftaranModel,
					this.bpjsPcarePendaftaransDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsPcarePendaftaransRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.invoicesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InvoiceModel.getProps(), this.invoicesRelations, this.isViewOnly),
					new InvoiceModel(),
					InvoiceModel,
					this.invoicesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.invoicesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.registrationsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RegistrationModel.getProps(), this.registrationsRelations, this.isViewOnly),
					new RegistrationModel(),
					RegistrationModel,
					this.registrationsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.registrationsRelations,
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
		this.modelProperties = PatientVisitModel.getProps();
		this.modelRelations = PatientVisitModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'bpjsPcareRegistrations';
		}).hideElement = this.bpjsPcareRegistrationsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsPcareRegistrations').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientVisitPatientPaymentInsurance';
		}).hideElement = this.patientVisitPatientPaymentInsuranceMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientVisitPatientPaymentInsurance').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientVisitPatientPaymentOthers';
		}).hideElement = this.patientVisitPatientPaymentOthersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientVisitPatientPaymentOthers').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientVisitPaymentSelfPaying';
		}).hideElement = this.patientVisitPaymentSelfPayingMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientVisitPaymentSelfPaying').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patient';
		}).hideElement = this.patientMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patient').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsVisitDatas';
		}).hideElement = this.bpjsVisitDatasMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsVisitDatas').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsPcarePendaftarans';
		}).hideElement = this.bpjsPcarePendaftaransMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsPcarePendaftarans').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'invoices';
		}).hideElement = this.invoicesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'invoices').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'registrations';
		}).hideElement = this.registrationsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'registrations').hideElement;

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
		if (this.bpjsPcareRegistrationsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsPcareRegistrationsDisplayName, many: false});
		}

		if (this.patientVisitPatientPaymentInsuranceMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientVisitPatientPaymentInsuranceDisplayName, many: false});
		}

		if (this.patientVisitPatientPaymentOthersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientVisitPatientPaymentOthersDisplayName, many: false});
		}

		if (this.patientVisitPaymentSelfPayingMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientVisitPaymentSelfPayingDisplayName, many: false});
		}

		if (this.patientMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientDisplayName, many: false});
		}

		if (this.bpjsVisitDatasMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsVisitDatasDisplayName, many: true});
			this.store.dispatch(new bpjsVisitDataModelAction.BpjsVisitDataAction(
				bpjsVisitDataModelAction.BpjsVisitDataModelActionTypes.INITIALISE_BPJS_VISIT_DATA_COLLECTION_STATE,
				{
					collectionId: this.bpjsVisitDatasCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsVisitDataCollectionModels, this.bpjsVisitDatasCollectionId).subscribe(models => {
				models.forEach(bpjsVisitDatas => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsVisitDataModel.getProps(), this.bpjsVisitDatasRelations, this.isViewOnly),
						bpjsVisitDatas,
						BpjsVisitDataModel,
						this.bpjsVisitDatasDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bpjsVisitDatasRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.bpjsPcarePendaftaransMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsPcarePendaftaransDisplayName, many: true});
			this.store.dispatch(new bpjsPcarePendaftaranModelAction.BpjsPcarePendaftaranAction(
				bpjsPcarePendaftaranModelAction.BpjsPcarePendaftaranModelActionTypes.INITIALISE_BPJS_PCARE_PENDAFTARAN_COLLECTION_STATE,
				{
					collectionId: this.bpjsPcarePendaftaransCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsPcarePendaftaranCollectionModels, this.bpjsPcarePendaftaransCollectionId).subscribe(models => {
				models.forEach(bpjsPcarePendaftarans => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsPcarePendaftaranModel.getProps(), this.bpjsPcarePendaftaransRelations, this.isViewOnly),
						bpjsPcarePendaftarans,
						BpjsPcarePendaftaranModel,
						this.bpjsPcarePendaftaransDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bpjsPcarePendaftaransRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.invoicesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.invoicesDisplayName, many: true});
			this.store.dispatch(new invoiceModelAction.InvoiceAction(
				invoiceModelAction.InvoiceModelActionTypes.INITIALISE_INVOICE_COLLECTION_STATE,
				{
					collectionId: this.invoicesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInvoiceCollectionModels, this.invoicesCollectionId).subscribe(models => {
				models.forEach(invoices => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InvoiceModel.getProps(), this.invoicesRelations, this.isViewOnly),
						invoices,
						InvoiceModel,
						this.invoicesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.invoicesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.registrationsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.registrationsDisplayName, many: true});
			this.store.dispatch(new registrationModelAction.RegistrationAction(
				registrationModelAction.RegistrationModelActionTypes.INITIALISE_REGISTRATION_COLLECTION_STATE,
				{
					collectionId: this.registrationsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getRegistrationCollectionModels, this.registrationsCollectionId).subscribe(models => {
				models.forEach(registrations => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(RegistrationModel.getProps(), this.registrationsRelations, this.isViewOnly),
						registrations,
						RegistrationModel,
						this.registrationsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.registrationsRelations,
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
		if (this.targetModel.bpjsPcareRegistrations && this.targetModel.bpjsPcareRegistrations.id && this.bpjsPcareRegistrationsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsPcareRegistrationsModel,
				this.bpjsPcareRegistrationsOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bpjsPcareRegistrations.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsPcareRegistrationsModelWithId, this.targetModel.bpjsPcareRegistrationsId).subscribe(bpjsPcareRegistrations => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsPcareRegistrationsModel.getProps(), this.bpjsPcareRegistrationsRelations, this.isViewOnly),
					bpjsPcareRegistrations,
					BpjsPcareRegistrationsModel,
					this.bpjsPcareRegistrationsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsPcareRegistrationsRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.patientVisitPatientPaymentInsurance && this.targetModel.patientVisitPatientPaymentInsurance.id && this.patientVisitPatientPaymentInsuranceMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientVisitPatientPaymentInsuranceModel,
				this.patientVisitPatientPaymentInsuranceOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientVisitPatientPaymentInsurance.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientVisitPatientPaymentInsuranceModelWithId, this.targetModel.patientVisitPatientPaymentInsuranceId).subscribe(patientVisitPatientPaymentInsurance => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientVisitPatientPaymentInsuranceModel.getProps(), this.patientVisitPatientPaymentInsuranceRelations, this.isViewOnly),
					patientVisitPatientPaymentInsurance,
					PatientVisitPatientPaymentInsuranceModel,
					this.patientVisitPatientPaymentInsuranceDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientVisitPatientPaymentInsuranceRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.patientVisitPatientPaymentOthers && this.targetModel.patientVisitPatientPaymentOthers.id && this.patientVisitPatientPaymentOthersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientVisitPatientPaymentOthersModel,
				this.patientVisitPatientPaymentOthersOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientVisitPatientPaymentOthers.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientVisitPatientPaymentOthersModelWithId, this.targetModel.patientVisitPatientPaymentOthersId).subscribe(patientVisitPatientPaymentOthers => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientVisitPatientPaymentOthersModel.getProps(), this.patientVisitPatientPaymentOthersRelations, this.isViewOnly),
					patientVisitPatientPaymentOthers,
					PatientVisitPatientPaymentOthersModel,
					this.patientVisitPatientPaymentOthersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientVisitPatientPaymentOthersRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.patientVisitPaymentSelfPaying && this.targetModel.patientVisitPaymentSelfPaying.id && this.patientVisitPaymentSelfPayingMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientVisitPaymentSelfPayingModel,
				this.patientVisitPaymentSelfPayingOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientVisitPaymentSelfPaying.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientVisitPaymentSelfPayingModelWithId, this.targetModel.patientVisitPaymentSelfPayingId).subscribe(patientVisitPaymentSelfPaying => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientVisitPaymentSelfPayingModel.getProps(), this.patientVisitPaymentSelfPayingRelations, this.isViewOnly),
					patientVisitPaymentSelfPaying,
					PatientVisitPaymentSelfPayingModel,
					this.patientVisitPaymentSelfPayingDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientVisitPaymentSelfPayingRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.patient && this.targetModel.patient.id && this.patientMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientGeneralInfoModel,
				this.patientOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patient.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientGeneralInfoModelWithId, this.targetModel.patientId).subscribe(patient => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientGeneralInfoModel.getProps(), this.patientRelations, this.isViewOnly),
					patient,
					PatientGeneralInfoModel,
					this.patientDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bpjsVisitDatasIds && this.targetModel.bpjsVisitDatasIds.length > 0 && this.bpjsVisitDatasMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsVisitDataModel,
				this.bpjsVisitDatasOppositeRelation,
				this.bpjsVisitDatasCollectionId,
				this.targetModel.bpjsVisitDatasIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.bpjsPcarePendaftaransIds && this.targetModel.bpjsPcarePendaftaransIds.length > 0 && this.bpjsPcarePendaftaransMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsPcarePendaftaranModel,
				this.bpjsPcarePendaftaransOppositeRelation,
				this.bpjsPcarePendaftaransCollectionId,
				this.targetModel.bpjsPcarePendaftaransIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.invoicesIds && this.targetModel.invoicesIds.length > 0 && this.invoicesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InvoiceModel,
				this.invoicesOppositeRelation,
				this.invoicesCollectionId,
				this.targetModel.invoicesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.registrationsIds && this.targetModel.registrationsIds.length > 0 && this.registrationsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RegistrationModel,
				this.registrationsOppositeRelation,
				this.registrationsCollectionId,
				this.targetModel.registrationsIds.length,
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
	addAdditionalEntitiesToModel(model: PatientVisitModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): PatientVisitModel {
		let updatedModel: PatientVisitModel = new PatientVisitModel(model);

		if (this.bpjsPcareRegistrationsMultiCrudActive) {
			updatedModel.bpjsPcareRegistrations = event.additionalEntities.bpjsPcareRegistrations ? event.additionalEntities.bpjsPcareRegistrations : undefined;

			if (!updatedModel.bpjsPcareRegistrations && event.payload) {
				event.payload.bpjsPcareRegistrationsId = null;
			}
		} else if (event.payload?.bpjsPcareRegistrationsId !== undefined) {
			event.payload.bpjsPcareRegistrations = null;
			updatedModel.bpjsPcareRegistrations = null;
		}

		if (this.patientVisitPatientPaymentInsuranceMultiCrudActive) {
			updatedModel.patientVisitPatientPaymentInsurance = event.additionalEntities.patientVisitPatientPaymentInsurance ? event.additionalEntities.patientVisitPatientPaymentInsurance : undefined;

			if (!updatedModel.patientVisitPatientPaymentInsurance && event.payload) {
				event.payload.patientVisitPatientPaymentInsuranceId = null;
			}
		} else if (event.payload?.patientVisitPatientPaymentInsuranceId !== undefined) {
			event.payload.patientVisitPatientPaymentInsurance = null;
			updatedModel.patientVisitPatientPaymentInsurance = null;
		}

		if (this.patientVisitPatientPaymentOthersMultiCrudActive) {
			updatedModel.patientVisitPatientPaymentOthers = event.additionalEntities.patientVisitPatientPaymentOthers ? event.additionalEntities.patientVisitPatientPaymentOthers : undefined;

			if (!updatedModel.patientVisitPatientPaymentOthers && event.payload) {
				event.payload.patientVisitPatientPaymentOthersId = null;
			}
		} else if (event.payload?.patientVisitPatientPaymentOthersId !== undefined) {
			event.payload.patientVisitPatientPaymentOthers = null;
			updatedModel.patientVisitPatientPaymentOthers = null;
		}

		if (this.patientVisitPaymentSelfPayingMultiCrudActive) {
			updatedModel.patientVisitPaymentSelfPaying = event.additionalEntities.patientVisitPaymentSelfPaying ? event.additionalEntities.patientVisitPaymentSelfPaying : undefined;

			if (!updatedModel.patientVisitPaymentSelfPaying && event.payload) {
				event.payload.patientVisitPaymentSelfPayingId = null;
			}
		} else if (event.payload?.patientVisitPaymentSelfPayingId !== undefined) {
			event.payload.patientVisitPaymentSelfPaying = null;
			updatedModel.patientVisitPaymentSelfPaying = null;
		}

		if (this.patientMultiCrudActive) {
			updatedModel.patient = event.additionalEntities.patient ? event.additionalEntities.patient : undefined;

			if (!updatedModel.patient && event.payload) {
				event.payload.patientId = null;
			}
		} else if (event.payload?.patientId !== undefined) {
			event.payload.patient = null;
			updatedModel.patient = null;
		}

		updatedModel.bpjsVisitDatas = [];
		if (this.bpjsVisitDatasMultiCrudActive) {
			if (event.additionalEntities.bpjsVisitDatas) {
				event.additionalEntities.bpjsVisitDatas.forEach(entity => {
					updatedModel.bpjsVisitDatas.push(entity);
				});
			}

			if (!updatedModel.bpjsVisitDatas.length) {
				updatedModel.bpjsVisitDatasIds = [];
			}
		}
		updatedModel.bpjsPcarePendaftarans = [];
		if (this.bpjsPcarePendaftaransMultiCrudActive) {
			if (event.additionalEntities.bpjsPcarePendaftarans) {
				event.additionalEntities.bpjsPcarePendaftarans.forEach(entity => {
					updatedModel.bpjsPcarePendaftarans.push(entity);
				});
			}

			if (!updatedModel.bpjsPcarePendaftarans.length) {
				updatedModel.bpjsPcarePendaftaransIds = [];
			}
		}
		updatedModel.invoices = [];
		if (this.invoicesMultiCrudActive) {
			if (event.additionalEntities.invoices) {
				event.additionalEntities.invoices.forEach(entity => {
					updatedModel.invoices.push(entity);
				});
			}

			if (!updatedModel.invoices.length) {
				updatedModel.invoicesIds = [];
			}
		}
		updatedModel.registrations = [];
		if (this.registrationsMultiCrudActive) {
			if (event.additionalEntities.registrations) {
				event.additionalEntities.registrations.forEach(entity => {
					updatedModel.registrations.push(entity);
				});
			}

			if (!updatedModel.registrations.length) {
				updatedModel.registrationsIds = [];
			}
		}
		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
