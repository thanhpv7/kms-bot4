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
import * as modelAction from 'src/app/models/invoice/invoice.model.action';
import {InvoiceModelState, InvoiceModelAudit} from 'src/app/models/invoice/invoice.model.state';
import {InvoiceTypeEnum, invoiceTypeEnumArray} from 'src/app/enums/invoice-type.enum';
import {InvoiceModel} from 'src/app/models/invoice/invoice.model';
import {
	getInvoiceModelAuditsByEntityId,
	getInvoiceModelWithId,
	getCountInvoiceModels,
} from 'src/app/models/invoice/invoice.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {BedFacilityModel} from 'src/app/models/bedFacility/bed_facility.model';
import * as bedFacilityModelAction from 'src/app/models/bedFacility/bed_facility.model.action';
import {
	getBedFacilityCollectionModels, getBedFacilityModelWithId,
} from 'src/app/models/bedFacility/bed_facility.model.selector';
import {DiagnosesAndProceduresModel} from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import * as diagnosesAndProceduresModelAction from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.action';
import {
	getDiagnosesAndProceduresCollectionModels, getDiagnosesAndProceduresModelWithId,
} from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import {InvoiceItemModel} from 'src/app/models/invoiceItem/invoice_item.model';
import * as invoiceItemModelAction from 'src/app/models/invoiceItem/invoice_item.model.action';
import {
	getInvoiceItemCollectionModels, getInvoiceItemModelWithId,
} from 'src/app/models/invoiceItem/invoice_item.model.selector';
import {InvoicePaymentInsuranceModel} from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model';
import * as invoicePaymentInsuranceModelAction from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model.action';
import {
	getInvoicePaymentInsuranceCollectionModels, getInvoicePaymentInsuranceModelWithId,
} from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model.selector';
import {InvoicePaymentOtherModel} from 'src/app/models/invoicePaymentOther/invoice_payment_other.model';
import * as invoicePaymentOtherModelAction from 'src/app/models/invoicePaymentOther/invoice_payment_other.model.action';
import {
	getInvoicePaymentOtherCollectionModels, getInvoicePaymentOtherModelWithId,
} from 'src/app/models/invoicePaymentOther/invoice_payment_other.model.selector';
import {InvoicePaymentSelfPayingModel} from 'src/app/models/invoicePaymentSelfPaying/invoice_payment_self_paying.model';
import * as invoicePaymentSelfPayingModelAction from 'src/app/models/invoicePaymentSelfPaying/invoice_payment_self_paying.model.action';
import {
	getInvoicePaymentSelfPayingCollectionModels, getInvoicePaymentSelfPayingModelWithId,
} from 'src/app/models/invoicePaymentSelfPaying/invoice_payment_self_paying.model.selector';
import {InvoiceSummaryModel} from 'src/app/models/invoiceSummary/invoice_summary.model';
import * as invoiceSummaryModelAction from 'src/app/models/invoiceSummary/invoice_summary.model.action';
import {
	getInvoiceSummaryCollectionModels, getInvoiceSummaryModelWithId,
} from 'src/app/models/invoiceSummary/invoice_summary.model.selector';
import {MedicationHeaderModel} from 'src/app/models/medicationHeader/medication_header.model';
import * as medicationHeaderModelAction from 'src/app/models/medicationHeader/medication_header.model.action';
import {
	getMedicationHeaderCollectionModels, getMedicationHeaderModelWithId,
} from 'src/app/models/medicationHeader/medication_header.model.selector';
import {PatientVisitModel} from 'src/app/models/patientVisit/patient_visit.model';
import * as patientVisitModelAction from 'src/app/models/patientVisit/patient_visit.model.action';
import {
	getPatientVisitCollectionModels, getPatientVisitModelWithId,
} from 'src/app/models/patientVisit/patient_visit.model.selector';
import {PrescriptionHeaderModel} from 'src/app/models/prescriptionHeader/prescription_header.model';
import * as prescriptionHeaderModelAction from 'src/app/models/prescriptionHeader/prescription_header.model.action';
import {
	getPrescriptionHeaderCollectionModels, getPrescriptionHeaderModelWithId,
} from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import {StaffModel} from 'src/app/models/staff/staff.model';
import * as staffModelAction from 'src/app/models/staff/staff.model.action';
import {
	getStaffCollectionModels, getStaffModelWithId,
} from 'src/app/models/staff/staff.model.selector';
import {TariffSchemaModel} from 'src/app/models/tariffSchema/tariff_schema.model';
import * as tariffSchemaModelAction from 'src/app/models/tariffSchema/tariff_schema.model.action';
import {
	getTariffSchemaCollectionModels, getTariffSchemaModelWithId,
} from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../invoice-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-invoice-crud-edit',
	templateUrl: './invoice-crud-edit.component.html',
	styleUrls: [
		'./invoice-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class InvoiceCrudEditComponent
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
	collectionId: string = 'cedb5f60-22ec-4a5a-9f4b-2610799812b2';
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
	invoiceAudits$: Observable<InvoiceModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Invoice and Invoice Payment Other here] off begin
	invoicePaymentOtherMultiCrudActive: boolean = false;
	invoicePaymentOtherDisplayName = 'Invoice Payment Other';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Invoice and Invoice Payment Other here] end
	invoicePaymentOtherOppositeRelation = 'invoice';
	invoicePaymentOtherRelations: ModelRelation[] = this.invoicePaymentOtherMultiCrudActive ? InvoicePaymentOtherModel.getRelations()
		.map(relation => {
			if (relation.id === this.invoicePaymentOtherOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Invoice and Invoice Payment Self Paying here] off begin
	invoicePaymentSelfPayingMultiCrudActive: boolean = false;
	invoicePaymentSelfPayingDisplayName = 'Invoice Payment Self Paying';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Invoice and Invoice Payment Self Paying here] end
	invoicePaymentSelfPayingOppositeRelation = 'invoice';
	invoicePaymentSelfPayingRelations: ModelRelation[] = this.invoicePaymentSelfPayingMultiCrudActive ? InvoicePaymentSelfPayingModel.getRelations()
		.map(relation => {
			if (relation.id === this.invoicePaymentSelfPayingOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Invoice and Invoice Summary here] off begin
	invoiceSummaryMultiCrudActive: boolean = false;
	invoiceSummaryDisplayName = 'Invoice Summary';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Invoice and Invoice Summary here] end
	invoiceSummaryOppositeRelation = 'invoice';
	invoiceSummaryRelations: ModelRelation[] = this.invoiceSummaryMultiCrudActive ? InvoiceSummaryModel.getRelations()
		.map(relation => {
			if (relation.id === this.invoiceSummaryOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Invoice and Prescription Header here] off begin
	prescriptionHeaderMultiCrudActive: boolean = false;
	prescriptionHeaderDisplayName = 'Prescription Header';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Invoice and Prescription Header here] end
	prescriptionHeaderOppositeRelation = 'invoice';
	prescriptionHeaderRelations: ModelRelation[] = this.prescriptionHeaderMultiCrudActive ? PrescriptionHeaderModel.getRelations()
		.map(relation => {
			if (relation.id === this.prescriptionHeaderOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medication Header and Invoice here] off begin
	medicationHeaderMultiCrudActive: boolean = false;
	medicationHeaderDisplayName = 'Medication Header';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medication Header and Invoice here] end
	medicationHeaderOppositeRelation = 'invoice';
	medicationHeaderRelations: ModelRelation[] = this.medicationHeaderMultiCrudActive ? MedicationHeaderModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicationHeaderOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between ICD 10 and Invoices ICD 10 here] off begin
	icd10MultiCrudActive: boolean = false;
	icd10DisplayName = 'ICD 10';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between ICD 10 and Invoices ICD 10 here] end
	icd10OppositeRelation = 'invoicesICD10';
	icd10Relations: ModelRelation[] = this.icd10MultiCrudActive ? DiagnosesAndProceduresModel.getRelations()
		.map(relation => {
			if (relation.id === this.icd10OppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between ICD 9 CM and Invoices ICD 9 CM here] off begin
	icd9CMMultiCrudActive: boolean = false;
	icd9CMDisplayName = 'ICD 9 CM';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between ICD 9 CM and Invoices ICD 9 CM here] end
	icd9CMOppositeRelation = 'invoicesICD9CM';
	icd9CMRelations: ModelRelation[] = this.icd9CMMultiCrudActive ? DiagnosesAndProceduresModel.getRelations()
		.map(relation => {
			if (relation.id === this.icd9CMOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Bed Facility and Invoices here] off begin
	bedFacilityMultiCrudActive: boolean = false;
	bedFacilityDisplayName = 'Bed Facility';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Bed Facility and Invoices here] end
	bedFacilityOppositeRelation = 'invoices';
	bedFacilityRelations: ModelRelation[] = this.bedFacilityMultiCrudActive ? BedFacilityModel.getRelations()
		.map(relation => {
			if (relation.id === this.bedFacilityOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and Invoices here] off begin
	patientVisitMultiCrudActive: boolean = false;
	patientVisitDisplayName = 'Patient Visit';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and Invoices here] end
	patientVisitOppositeRelation = 'invoices';
	patientVisitRelations: ModelRelation[] = this.patientVisitMultiCrudActive ? PatientVisitModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientVisitOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Tariff Schema and Invoices here] off begin
	tariffSchemaMultiCrudActive: boolean = false;
	tariffSchemaDisplayName = 'Tariff Schema';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Tariff Schema and Invoices here] end
	tariffSchemaOppositeRelation = 'invoices';
	tariffSchemaRelations: ModelRelation[] = this.tariffSchemaMultiCrudActive ? TariffSchemaModel.getRelations()
		.map(relation => {
			if (relation.id === this.tariffSchemaOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Verified By and Invoices here] off begin
	verifiedByMultiCrudActive: boolean = false;
	verifiedByDisplayName = 'Verified By';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Verified By and Invoices here] end
	verifiedByOppositeRelation = 'invoices';
	verifiedByRelations: ModelRelation[] = this.verifiedByMultiCrudActive ? StaffModel.getRelations()
		.map(relation => {
			if (relation.id === this.verifiedByOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Invoice and Invoice Items here] off begin
	invoiceItemsMultiCrudActive: boolean = false;
	invoiceItemsDisplayName = 'Invoice Items';
	invoiceItemsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Invoice and Invoice Items here] end
	invoiceItemsOppositeRelation = 'invoice';
	invoiceItemsRelations: ModelRelation[] = this.invoiceItemsMultiCrudActive ? InvoiceItemModel.getRelations()
		.map(relation => {
			if (relation.id === this.invoiceItemsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Invoice and Invoice Payment Insurances here] off begin
	invoicePaymentInsurancesMultiCrudActive: boolean = false;
	invoicePaymentInsurancesDisplayName = 'Invoice Payment Insurances';
	invoicePaymentInsurancesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Invoice and Invoice Payment Insurances here] end
	invoicePaymentInsurancesOppositeRelation = 'invoice';
	invoicePaymentInsurancesRelations: ModelRelation[] = this.invoicePaymentInsurancesMultiCrudActive ? InvoicePaymentInsuranceModel.getRelations()
		.map(relation => {
			if (relation.id === this.invoicePaymentInsurancesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = InvoiceModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = InvoiceModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = InvoiceModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'invoicePaymentOther' && this.invoicePaymentOtherMultiCrudActive) {
					exp.fields = InvoicePaymentOtherModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'invoicePaymentSelfPaying' && this.invoicePaymentSelfPayingMultiCrudActive) {
					exp.fields = InvoicePaymentSelfPayingModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'invoiceSummary' && this.invoiceSummaryMultiCrudActive) {
					exp.fields = InvoiceSummaryModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'prescriptionHeader' && this.prescriptionHeaderMultiCrudActive) {
					exp.fields = PrescriptionHeaderModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicationHeader' && this.medicationHeaderMultiCrudActive) {
					exp.fields = MedicationHeaderModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'icd10' && this.icd10MultiCrudActive) {
					exp.fields = DiagnosesAndProceduresModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'icd9CM' && this.icd9CMMultiCrudActive) {
					exp.fields = DiagnosesAndProceduresModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bedFacility' && this.bedFacilityMultiCrudActive) {
					exp.fields = BedFacilityModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientVisit' && this.patientVisitMultiCrudActive) {
					exp.fields = PatientVisitModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'tariffSchema' && this.tariffSchemaMultiCrudActive) {
					exp.fields = TariffSchemaModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'verifiedBy' && this.verifiedByMultiCrudActive) {
					exp.fields = StaffModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'invoiceItems' && this.invoiceItemsMultiCrudActive) {
					exp.fields = InvoiceItemModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'invoicePaymentInsurances' && this.invoicePaymentInsurancesMultiCrudActive) {
					exp.fields = InvoicePaymentInsuranceModel.getProps().map(prop => {
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
	targetModel: InvoiceModel;

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
		private readonly store: Store<{ model: InvoiceModelState }>,
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
		this.creationNavigationSubscription$.add(this.store.select(getCountInvoiceModels).subscribe(count => {
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

			this.targetModel = new InvoiceModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.invoiceAudits$ = this.store.select(getInvoiceModelAuditsByEntityId, this.targetModelId);
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
		const stateConfig: PassableStateConfig<InvoiceModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.InvoiceAction(
			modelAction.InvoiceModelActionTypes.FETCH_INVOICE,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getInvoiceModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new InvoiceModel(model);
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
				commands.push('invoice');
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

		this.store.dispatch(new modelAction.InvoiceAction(
			modelAction.InvoiceModelActionTypes.FETCH_INVOICE_AUDITS_BY_ENTITY_ID,
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
			let stateConfig: PassableStateConfig<InvoiceModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.medicationHeaderMultiCrudActive || this.invoicePaymentOtherMultiCrudActive || this.invoicePaymentSelfPayingMultiCrudActive || this.invoiceSummaryMultiCrudActive || this.prescriptionHeaderMultiCrudActive || this.icd10MultiCrudActive || this.icd9CMMultiCrudActive || this.bedFacilityMultiCrudActive || this.patientVisitMultiCrudActive || this.tariffSchemaMultiCrudActive || this.verifiedByMultiCrudActive || this.invoiceItemsMultiCrudActive || this.invoicePaymentInsurancesMultiCrudActive,
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
					new modelAction.InvoiceAction(
						modelAction.InvoiceModelActionTypes.COUNT_INVOICES,
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

			this.store.dispatch(new modelAction.InvoiceAction(
				modelAction.InvoiceModelActionTypes.CREATE_INVOICE,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<InvoiceModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.medicationHeaderMultiCrudActive || this.invoicePaymentOtherMultiCrudActive || this.invoicePaymentSelfPayingMultiCrudActive || this.invoiceSummaryMultiCrudActive || this.prescriptionHeaderMultiCrudActive || this.icd10MultiCrudActive || this.icd9CMMultiCrudActive || this.bedFacilityMultiCrudActive || this.patientVisitMultiCrudActive || this.tariffSchemaMultiCrudActive || this.verifiedByMultiCrudActive || this.invoiceItemsMultiCrudActive || this.invoicePaymentInsurancesMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.InvoiceAction(
					modelAction.InvoiceModelActionTypes.FETCH_INVOICE,
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

			this.store.dispatch(new modelAction.InvoiceAction(
				modelAction.InvoiceModelActionTypes.UPDATE_INVOICE,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: InvoiceModel = new InvoiceModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getInvoiceModelWithId, this.targetModelId).subscribe(model => {
					let differences = new InvoiceModel(model).difference(updatedModel);

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
			if (event.entityName === this.medicationHeaderDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicationHeaderModel.getProps(), this.medicationHeaderRelations, this.isViewOnly),
					new MedicationHeaderModel(),
					MedicationHeaderModel,
					this.medicationHeaderDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicationHeaderRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.invoicePaymentOtherDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InvoicePaymentOtherModel.getProps(), this.invoicePaymentOtherRelations, this.isViewOnly),
					new InvoicePaymentOtherModel(),
					InvoicePaymentOtherModel,
					this.invoicePaymentOtherDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.invoicePaymentOtherRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.invoicePaymentSelfPayingDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InvoicePaymentSelfPayingModel.getProps(), this.invoicePaymentSelfPayingRelations, this.isViewOnly),
					new InvoicePaymentSelfPayingModel(),
					InvoicePaymentSelfPayingModel,
					this.invoicePaymentSelfPayingDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.invoicePaymentSelfPayingRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.invoiceSummaryDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InvoiceSummaryModel.getProps(), this.invoiceSummaryRelations, this.isViewOnly),
					new InvoiceSummaryModel(),
					InvoiceSummaryModel,
					this.invoiceSummaryDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.invoiceSummaryRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.prescriptionHeaderDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PrescriptionHeaderModel.getProps(), this.prescriptionHeaderRelations, this.isViewOnly),
					new PrescriptionHeaderModel(),
					PrescriptionHeaderModel,
					this.prescriptionHeaderDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.prescriptionHeaderRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.icd10DisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosesAndProceduresModel.getProps(), this.icd10Relations, this.isViewOnly),
					new DiagnosesAndProceduresModel(),
					DiagnosesAndProceduresModel,
					this.icd10DisplayName,
					this.modelProperties,
					this.modelRelations,
					this.icd10Relations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.icd9CMDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosesAndProceduresModel.getProps(), this.icd9CMRelations, this.isViewOnly),
					new DiagnosesAndProceduresModel(),
					DiagnosesAndProceduresModel,
					this.icd9CMDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.icd9CMRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bedFacilityDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BedFacilityModel.getProps(), this.bedFacilityRelations, this.isViewOnly),
					new BedFacilityModel(),
					BedFacilityModel,
					this.bedFacilityDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bedFacilityRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientVisitDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientVisitModel.getProps(), this.patientVisitRelations, this.isViewOnly),
					new PatientVisitModel(),
					PatientVisitModel,
					this.patientVisitDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientVisitRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.tariffSchemaDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(TariffSchemaModel.getProps(), this.tariffSchemaRelations, this.isViewOnly),
					new TariffSchemaModel(),
					TariffSchemaModel,
					this.tariffSchemaDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.tariffSchemaRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.verifiedByDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.verifiedByRelations, this.isViewOnly),
					new StaffModel(),
					StaffModel,
					this.verifiedByDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.verifiedByRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.invoiceItemsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InvoiceItemModel.getProps(), this.invoiceItemsRelations, this.isViewOnly),
					new InvoiceItemModel(),
					InvoiceItemModel,
					this.invoiceItemsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.invoiceItemsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.invoicePaymentInsurancesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InvoicePaymentInsuranceModel.getProps(), this.invoicePaymentInsurancesRelations, this.isViewOnly),
					new InvoicePaymentInsuranceModel(),
					InvoicePaymentInsuranceModel,
					this.invoicePaymentInsurancesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.invoicePaymentInsurancesRelations,
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
		this.modelProperties = InvoiceModel.getProps();
		this.modelRelations = InvoiceModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'medicationHeader';
		}).hideElement = this.medicationHeaderMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicationHeader').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'invoicePaymentOther';
		}).hideElement = this.invoicePaymentOtherMultiCrudActive || this.modelRelations.find(rel => rel.id === 'invoicePaymentOther').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'invoicePaymentSelfPaying';
		}).hideElement = this.invoicePaymentSelfPayingMultiCrudActive || this.modelRelations.find(rel => rel.id === 'invoicePaymentSelfPaying').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'invoiceSummary';
		}).hideElement = this.invoiceSummaryMultiCrudActive || this.modelRelations.find(rel => rel.id === 'invoiceSummary').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'prescriptionHeader';
		}).hideElement = this.prescriptionHeaderMultiCrudActive || this.modelRelations.find(rel => rel.id === 'prescriptionHeader').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'icd10';
		}).hideElement = this.icd10MultiCrudActive || this.modelRelations.find(rel => rel.id === 'icd10').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'icd9CM';
		}).hideElement = this.icd9CMMultiCrudActive || this.modelRelations.find(rel => rel.id === 'icd9CM').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bedFacility';
		}).hideElement = this.bedFacilityMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bedFacility').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientVisit';
		}).hideElement = this.patientVisitMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientVisit').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'tariffSchema';
		}).hideElement = this.tariffSchemaMultiCrudActive || this.modelRelations.find(rel => rel.id === 'tariffSchema').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'verifiedBy';
		}).hideElement = this.verifiedByMultiCrudActive || this.modelRelations.find(rel => rel.id === 'verifiedBy').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'invoiceItems';
		}).hideElement = this.invoiceItemsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'invoiceItems').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'invoicePaymentInsurances';
		}).hideElement = this.invoicePaymentInsurancesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'invoicePaymentInsurances').hideElement;

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
		if (this.medicationHeaderMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicationHeaderDisplayName, many: false});
		}

		if (this.invoicePaymentOtherMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.invoicePaymentOtherDisplayName, many: false});
		}

		if (this.invoicePaymentSelfPayingMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.invoicePaymentSelfPayingDisplayName, many: false});
		}

		if (this.invoiceSummaryMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.invoiceSummaryDisplayName, many: false});
		}

		if (this.prescriptionHeaderMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.prescriptionHeaderDisplayName, many: false});
		}

		if (this.icd10MultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.icd10DisplayName, many: false});
		}

		if (this.icd9CMMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.icd9CMDisplayName, many: false});
		}

		if (this.bedFacilityMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bedFacilityDisplayName, many: false});
		}

		if (this.patientVisitMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientVisitDisplayName, many: false});
		}

		if (this.tariffSchemaMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.tariffSchemaDisplayName, many: false});
		}

		if (this.verifiedByMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.verifiedByDisplayName, many: false});
		}

		if (this.invoiceItemsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.invoiceItemsDisplayName, many: true});
			this.store.dispatch(new invoiceItemModelAction.InvoiceItemAction(
				invoiceItemModelAction.InvoiceItemModelActionTypes.INITIALISE_INVOICE_ITEM_COLLECTION_STATE,
				{
					collectionId: this.invoiceItemsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInvoiceItemCollectionModels, this.invoiceItemsCollectionId).subscribe(models => {
				models.forEach(invoiceItems => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InvoiceItemModel.getProps(), this.invoiceItemsRelations, this.isViewOnly),
						invoiceItems,
						InvoiceItemModel,
						this.invoiceItemsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.invoiceItemsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.invoicePaymentInsurancesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.invoicePaymentInsurancesDisplayName, many: true});
			this.store.dispatch(new invoicePaymentInsuranceModelAction.InvoicePaymentInsuranceAction(
				invoicePaymentInsuranceModelAction.InvoicePaymentInsuranceModelActionTypes.INITIALISE_INVOICE_PAYMENT_INSURANCE_COLLECTION_STATE,
				{
					collectionId: this.invoicePaymentInsurancesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInvoicePaymentInsuranceCollectionModels, this.invoicePaymentInsurancesCollectionId).subscribe(models => {
				models.forEach(invoicePaymentInsurances => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InvoicePaymentInsuranceModel.getProps(), this.invoicePaymentInsurancesRelations, this.isViewOnly),
						invoicePaymentInsurances,
						InvoicePaymentInsuranceModel,
						this.invoicePaymentInsurancesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.invoicePaymentInsurancesRelations,
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
		if (this.targetModel.invoicePaymentOther && this.targetModel.invoicePaymentOther.id && this.invoicePaymentOtherMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InvoicePaymentOtherModel,
				this.invoicePaymentOtherOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.invoicePaymentOther.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getInvoicePaymentOtherModelWithId, this.targetModel.invoicePaymentOtherId).subscribe(invoicePaymentOther => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InvoicePaymentOtherModel.getProps(), this.invoicePaymentOtherRelations, this.isViewOnly),
					invoicePaymentOther,
					InvoicePaymentOtherModel,
					this.invoicePaymentOtherDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.invoicePaymentOtherRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.invoicePaymentSelfPaying && this.targetModel.invoicePaymentSelfPaying.id && this.invoicePaymentSelfPayingMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InvoicePaymentSelfPayingModel,
				this.invoicePaymentSelfPayingOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.invoicePaymentSelfPaying.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getInvoicePaymentSelfPayingModelWithId, this.targetModel.invoicePaymentSelfPayingId).subscribe(invoicePaymentSelfPaying => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InvoicePaymentSelfPayingModel.getProps(), this.invoicePaymentSelfPayingRelations, this.isViewOnly),
					invoicePaymentSelfPaying,
					InvoicePaymentSelfPayingModel,
					this.invoicePaymentSelfPayingDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.invoicePaymentSelfPayingRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.invoiceSummary && this.targetModel.invoiceSummary.id && this.invoiceSummaryMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InvoiceSummaryModel,
				this.invoiceSummaryOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.invoiceSummary.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getInvoiceSummaryModelWithId, this.targetModel.invoiceSummaryId).subscribe(invoiceSummary => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InvoiceSummaryModel.getProps(), this.invoiceSummaryRelations, this.isViewOnly),
					invoiceSummary,
					InvoiceSummaryModel,
					this.invoiceSummaryDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.invoiceSummaryRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.prescriptionHeader && this.targetModel.prescriptionHeader.id && this.prescriptionHeaderMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PrescriptionHeaderModel,
				this.prescriptionHeaderOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.prescriptionHeader.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPrescriptionHeaderModelWithId, this.targetModel.prescriptionHeaderId).subscribe(prescriptionHeader => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PrescriptionHeaderModel.getProps(), this.prescriptionHeaderRelations, this.isViewOnly),
					prescriptionHeader,
					PrescriptionHeaderModel,
					this.prescriptionHeaderDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.prescriptionHeaderRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.medicationHeader && this.targetModel.medicationHeader.id && this.medicationHeaderMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicationHeaderModel,
				this.medicationHeaderOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.medicationHeader.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicationHeaderModelWithId, this.targetModel.medicationHeaderId).subscribe(medicationHeader => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicationHeaderModel.getProps(), this.medicationHeaderRelations, this.isViewOnly),
					medicationHeader,
					MedicationHeaderModel,
					this.medicationHeaderDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicationHeaderRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.icd10 && this.targetModel.icd10.id && this.icd10MultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DiagnosesAndProceduresModel,
				this.icd10OppositeRelation,
				this.collectionId,
				1,
				this.targetModel.icd10.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getDiagnosesAndProceduresModelWithId, this.targetModel.icd10Id).subscribe(icd10 => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosesAndProceduresModel.getProps(), this.icd10Relations, this.isViewOnly),
					icd10,
					DiagnosesAndProceduresModel,
					this.icd10DisplayName,
					this.modelProperties,
					this.modelRelations,
					this.icd10Relations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.icd9CM && this.targetModel.icd9CM.id && this.icd9CMMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DiagnosesAndProceduresModel,
				this.icd9CMOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.icd9CM.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getDiagnosesAndProceduresModelWithId, this.targetModel.icd9CMId).subscribe(icd9CM => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosesAndProceduresModel.getProps(), this.icd9CMRelations, this.isViewOnly),
					icd9CM,
					DiagnosesAndProceduresModel,
					this.icd9CMDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.icd9CMRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bedFacility && this.targetModel.bedFacility.id && this.bedFacilityMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BedFacilityModel,
				this.bedFacilityOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bedFacility.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBedFacilityModelWithId, this.targetModel.bedFacilityId).subscribe(bedFacility => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BedFacilityModel.getProps(), this.bedFacilityRelations, this.isViewOnly),
					bedFacility,
					BedFacilityModel,
					this.bedFacilityDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bedFacilityRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.patientVisit && this.targetModel.patientVisit.id && this.patientVisitMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientVisitModel,
				this.patientVisitOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientVisit.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientVisitModelWithId, this.targetModel.patientVisitId).subscribe(patientVisit => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientVisitModel.getProps(), this.patientVisitRelations, this.isViewOnly),
					patientVisit,
					PatientVisitModel,
					this.patientVisitDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientVisitRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.tariffSchema && this.targetModel.tariffSchema.id && this.tariffSchemaMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				TariffSchemaModel,
				this.tariffSchemaOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.tariffSchema.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getTariffSchemaModelWithId, this.targetModel.tariffSchemaId).subscribe(tariffSchema => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(TariffSchemaModel.getProps(), this.tariffSchemaRelations, this.isViewOnly),
					tariffSchema,
					TariffSchemaModel,
					this.tariffSchemaDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.tariffSchemaRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.verifiedBy && this.targetModel.verifiedBy.id && this.verifiedByMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StaffModel,
				this.verifiedByOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.verifiedBy.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getStaffModelWithId, this.targetModel.verifiedById).subscribe(verifiedBy => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.verifiedByRelations, this.isViewOnly),
					verifiedBy,
					StaffModel,
					this.verifiedByDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.verifiedByRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.invoiceItemsIds && this.targetModel.invoiceItemsIds.length > 0 && this.invoiceItemsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InvoiceItemModel,
				this.invoiceItemsOppositeRelation,
				this.invoiceItemsCollectionId,
				this.targetModel.invoiceItemsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.invoicePaymentInsurancesIds && this.targetModel.invoicePaymentInsurancesIds.length > 0 && this.invoicePaymentInsurancesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InvoicePaymentInsuranceModel,
				this.invoicePaymentInsurancesOppositeRelation,
				this.invoicePaymentInsurancesCollectionId,
				this.targetModel.invoicePaymentInsurancesIds.length,
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
	addAdditionalEntitiesToModel(model: InvoiceModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): InvoiceModel {
		let updatedModel: InvoiceModel = new InvoiceModel(model);

		if (this.medicationHeaderMultiCrudActive) {
			updatedModel.medicationHeader = event.additionalEntities.medicationHeader ? event.additionalEntities.medicationHeader : undefined;

			if (!updatedModel.medicationHeader && event.payload) {
				event.payload.medicationHeaderId = null;
			}
		} else if (event.payload?.medicationHeaderId !== undefined) {
			event.payload.medicationHeader = null;
			updatedModel.medicationHeader = null;
		}

		if (this.invoicePaymentOtherMultiCrudActive) {
			updatedModel.invoicePaymentOther = event.additionalEntities.invoicePaymentOther ? event.additionalEntities.invoicePaymentOther : undefined;

			if (!updatedModel.invoicePaymentOther && event.payload) {
				event.payload.invoicePaymentOtherId = null;
			}
		} else if (event.payload?.invoicePaymentOtherId !== undefined) {
			event.payload.invoicePaymentOther = null;
			updatedModel.invoicePaymentOther = null;
		}

		if (this.invoicePaymentSelfPayingMultiCrudActive) {
			updatedModel.invoicePaymentSelfPaying = event.additionalEntities.invoicePaymentSelfPaying ? event.additionalEntities.invoicePaymentSelfPaying : undefined;

			if (!updatedModel.invoicePaymentSelfPaying && event.payload) {
				event.payload.invoicePaymentSelfPayingId = null;
			}
		} else if (event.payload?.invoicePaymentSelfPayingId !== undefined) {
			event.payload.invoicePaymentSelfPaying = null;
			updatedModel.invoicePaymentSelfPaying = null;
		}

		if (this.invoiceSummaryMultiCrudActive) {
			updatedModel.invoiceSummary = event.additionalEntities.invoiceSummary ? event.additionalEntities.invoiceSummary : undefined;

			if (!updatedModel.invoiceSummary && event.payload) {
				event.payload.invoiceSummaryId = null;
			}
		} else if (event.payload?.invoiceSummaryId !== undefined) {
			event.payload.invoiceSummary = null;
			updatedModel.invoiceSummary = null;
		}

		if (this.prescriptionHeaderMultiCrudActive) {
			updatedModel.prescriptionHeader = event.additionalEntities.prescriptionHeader ? event.additionalEntities.prescriptionHeader : undefined;

			if (!updatedModel.prescriptionHeader && event.payload) {
				event.payload.prescriptionHeaderId = null;
			}
		} else if (event.payload?.prescriptionHeaderId !== undefined) {
			event.payload.prescriptionHeader = null;
			updatedModel.prescriptionHeader = null;
		}

		if (this.icd10MultiCrudActive) {
			updatedModel.icd10 = event.additionalEntities.icd10 ? event.additionalEntities.icd10 : undefined;

			if (!updatedModel.icd10 && event.payload) {
				event.payload.icd10Id = null;
			}
		} else if (event.payload?.icd10Id !== undefined) {
			event.payload.icd10 = null;
			updatedModel.icd10 = null;
		}

		if (this.icd9CMMultiCrudActive) {
			updatedModel.icd9CM = event.additionalEntities.icd9CM ? event.additionalEntities.icd9CM : undefined;

			if (!updatedModel.icd9CM && event.payload) {
				event.payload.icd9CMId = null;
			}
		} else if (event.payload?.icd9CMId !== undefined) {
			event.payload.icd9CM = null;
			updatedModel.icd9CM = null;
		}

		if (this.bedFacilityMultiCrudActive) {
			updatedModel.bedFacility = event.additionalEntities.bedFacility ? event.additionalEntities.bedFacility : undefined;

			if (!updatedModel.bedFacility && event.payload) {
				event.payload.bedFacilityId = null;
			}
		} else if (event.payload?.bedFacilityId !== undefined) {
			event.payload.bedFacility = null;
			updatedModel.bedFacility = null;
		}

		if (this.patientVisitMultiCrudActive) {
			updatedModel.patientVisit = event.additionalEntities.patientVisit ? event.additionalEntities.patientVisit : undefined;

			if (!updatedModel.patientVisit && event.payload) {
				event.payload.patientVisitId = null;
			}
		} else if (event.payload?.patientVisitId !== undefined) {
			event.payload.patientVisit = null;
			updatedModel.patientVisit = null;
		}

		if (this.tariffSchemaMultiCrudActive) {
			updatedModel.tariffSchema = event.additionalEntities.tariffSchema ? event.additionalEntities.tariffSchema : undefined;

			if (!updatedModel.tariffSchema && event.payload) {
				event.payload.tariffSchemaId = null;
			}
		} else if (event.payload?.tariffSchemaId !== undefined) {
			event.payload.tariffSchema = null;
			updatedModel.tariffSchema = null;
		}

		if (this.verifiedByMultiCrudActive) {
			updatedModel.verifiedBy = event.additionalEntities.verifiedBy ? event.additionalEntities.verifiedBy : undefined;

			if (!updatedModel.verifiedBy && event.payload) {
				event.payload.verifiedById = null;
			}
		} else if (event.payload?.verifiedById !== undefined) {
			event.payload.verifiedBy = null;
			updatedModel.verifiedBy = null;
		}

		updatedModel.invoiceItems = [];
		if (this.invoiceItemsMultiCrudActive) {
			if (event.additionalEntities.invoiceItems) {
				event.additionalEntities.invoiceItems.forEach(entity => {
					updatedModel.invoiceItems.push(entity);
				});
			}

			if (!updatedModel.invoiceItems.length) {
				updatedModel.invoiceItemsIds = [];
			}
		}
		updatedModel.invoicePaymentInsurances = [];
		if (this.invoicePaymentInsurancesMultiCrudActive) {
			if (event.additionalEntities.invoicePaymentInsurances) {
				event.additionalEntities.invoicePaymentInsurances.forEach(entity => {
					updatedModel.invoicePaymentInsurances.push(entity);
				});
			}

			if (!updatedModel.invoicePaymentInsurances.length) {
				updatedModel.invoicePaymentInsurancesIds = [];
			}
		}
		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
