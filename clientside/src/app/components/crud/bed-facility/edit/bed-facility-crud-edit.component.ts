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
import * as modelAction from 'src/app/models/bedFacility/bed_facility.model.action';
import {BedFacilityModelState, BedFacilityModelAudit} from 'src/app/models/bedFacility/bed_facility.model.state';
import {BedFacilityModel} from 'src/app/models/bedFacility/bed_facility.model';
import {
	getBedFacilityModelAuditsByEntityId,
	getBedFacilityModelWithId,
	getCountBedFacilityModels,
} from 'src/app/models/bedFacility/bed_facility.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {BedReserveModel} from 'src/app/models/bedReserve/bed_reserve.model';
import * as bedReserveModelAction from 'src/app/models/bedReserve/bed_reserve.model.action';
import {
	getBedReserveCollectionModels, getBedReserveModelWithId,
} from 'src/app/models/bedReserve/bed_reserve.model.selector';
import {InpatientMedicalExaminationRecordModel} from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model';
import * as inpatientMedicalExaminationRecordModelAction from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.action';
import {
	getInpatientMedicalExaminationRecordCollectionModels, getInpatientMedicalExaminationRecordModelWithId,
} from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.selector';
import {IntraoperativeRecordsModel} from 'src/app/models/intraoperativeRecords/intraoperative_records.model';
import * as intraoperativeRecordsModelAction from 'src/app/models/intraoperativeRecords/intraoperative_records.model.action';
import {
	getIntraoperativeRecordsCollectionModels, getIntraoperativeRecordsModelWithId,
} from 'src/app/models/intraoperativeRecords/intraoperative_records.model.selector';
import {InvoiceModel} from 'src/app/models/invoice/invoice.model';
import * as invoiceModelAction from 'src/app/models/invoice/invoice.model.action';
import {
	getInvoiceCollectionModels, getInvoiceModelWithId,
} from 'src/app/models/invoice/invoice.model.selector';
import {PostOperativeDetailsModel} from 'src/app/models/postOperativeDetails/post_operative_details.model';
import * as postOperativeDetailsModelAction from 'src/app/models/postOperativeDetails/post_operative_details.model.action';
import {
	getPostOperativeDetailsCollectionModels, getPostOperativeDetailsModelWithId,
} from 'src/app/models/postOperativeDetails/post_operative_details.model.selector';
import {PreoperativeRecordsModel} from 'src/app/models/preoperativeRecords/preoperative_records.model';
import * as preoperativeRecordsModelAction from 'src/app/models/preoperativeRecords/preoperative_records.model.action';
import {
	getPreoperativeRecordsCollectionModels, getPreoperativeRecordsModelWithId,
} from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import {RegistrationModel} from 'src/app/models/registration/registration.model';
import * as registrationModelAction from 'src/app/models/registration/registration.model.action';
import {
	getRegistrationCollectionModels, getRegistrationModelWithId,
} from 'src/app/models/registration/registration.model.selector';
import {RoomFacilityModel} from 'src/app/models/roomFacility/room_facility.model';
import * as roomFacilityModelAction from 'src/app/models/roomFacility/room_facility.model.action';
import {
	getRoomFacilityCollectionModels, getRoomFacilityModelWithId,
} from 'src/app/models/roomFacility/room_facility.model.selector';
import {RoomTransferModel} from 'src/app/models/roomTransfer/room_transfer.model';
import * as roomTransferModelAction from 'src/app/models/roomTransfer/room_transfer.model.action';
import {
	getRoomTransferCollectionModels, getRoomTransferModelWithId,
} from 'src/app/models/roomTransfer/room_transfer.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../bed-facility-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-bed-facility-crud-edit',
	templateUrl: './bed-facility-crud-edit.component.html',
	styleUrls: [
		'./bed-facility-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class BedFacilityCrudEditComponent
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
	collectionId: string = 'd59c0366-cff0-4e29-bafd-05491f19ed36';
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
	bedFacilityAudits$: Observable<BedFacilityModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Intraoperative Records and Bed Facilities here] off begin
	intraoperativeRecordsMultiCrudActive: boolean = false;
	intraoperativeRecordsDisplayName = 'Intraoperative Records';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Intraoperative Records and Bed Facilities here] end
	intraoperativeRecordsOppositeRelation = 'bedFacilities';
	intraoperativeRecordsRelations: ModelRelation[] = this.intraoperativeRecordsMultiCrudActive ? IntraoperativeRecordsModel.getRelations()
		.map(relation => {
			if (relation.id === this.intraoperativeRecordsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Post Operative Details and Bed Facilities here] off begin
	postOperativeDetailsMultiCrudActive: boolean = false;
	postOperativeDetailsDisplayName = 'Post Operative Details';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Post Operative Details and Bed Facilities here] end
	postOperativeDetailsOppositeRelation = 'bedFacilities';
	postOperativeDetailsRelations: ModelRelation[] = this.postOperativeDetailsMultiCrudActive ? PostOperativeDetailsModel.getRelations()
		.map(relation => {
			if (relation.id === this.postOperativeDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Preoperative Records and Bed Facilities here] off begin
	preoperativeRecordsMultiCrudActive: boolean = false;
	preoperativeRecordsDisplayName = 'Preoperative Records';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Preoperative Records and Bed Facilities here] end
	preoperativeRecordsOppositeRelation = 'bedFacilities';
	preoperativeRecordsRelations: ModelRelation[] = this.preoperativeRecordsMultiCrudActive ? PreoperativeRecordsModel.getRelations()
		.map(relation => {
			if (relation.id === this.preoperativeRecordsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Room Facility and Bed Facilities here] off begin
	roomFacilityMultiCrudActive: boolean = false;
	roomFacilityDisplayName = 'Room Facility';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Room Facility and Bed Facilities here] end
	roomFacilityOppositeRelation = 'bedFacilities';
	roomFacilityRelations: ModelRelation[] = this.roomFacilityMultiCrudActive ? RoomFacilityModel.getRelations()
		.map(relation => {
			if (relation.id === this.roomFacilityOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Bed Facility and Bed Reserves here] off begin
	bedReservesMultiCrudActive: boolean = false;
	bedReservesDisplayName = 'Bed Reserves';
	bedReservesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Bed Facility and Bed Reserves here] end
	bedReservesOppositeRelation = 'bedFacility';
	bedReservesRelations: ModelRelation[] = this.bedReservesMultiCrudActive ? BedReserveModel.getRelations()
		.map(relation => {
			if (relation.id === this.bedReservesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Bed Facility and Inpatient Medical Examination Records here] off begin
	inpatientMedicalExaminationRecordsMultiCrudActive: boolean = false;
	inpatientMedicalExaminationRecordsDisplayName = 'Inpatient Medical Examination Records';
	inpatientMedicalExaminationRecordsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Bed Facility and Inpatient Medical Examination Records here] end
	inpatientMedicalExaminationRecordsOppositeRelation = 'bedFacility';
	inpatientMedicalExaminationRecordsRelations: ModelRelation[] = this.inpatientMedicalExaminationRecordsMultiCrudActive ? InpatientMedicalExaminationRecordModel.getRelations()
		.map(relation => {
			if (relation.id === this.inpatientMedicalExaminationRecordsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Bed Facility and Invoices here] off begin
	invoicesMultiCrudActive: boolean = false;
	invoicesDisplayName = 'Invoices';
	invoicesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Bed Facility and Invoices here] end
	invoicesOppositeRelation = 'bedFacility';
	invoicesRelations: ModelRelation[] = this.invoicesMultiCrudActive ? InvoiceModel.getRelations()
		.map(relation => {
			if (relation.id === this.invoicesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Bed Facility and Registrations here] off begin
	registrationsMultiCrudActive: boolean = false;
	registrationsDisplayName = 'Registrations';
	registrationsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Bed Facility and Registrations here] end
	registrationsOppositeRelation = 'bedFacility';
	registrationsRelations: ModelRelation[] = this.registrationsMultiCrudActive ? RegistrationModel.getRelations()
		.map(relation => {
			if (relation.id === this.registrationsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Bed Facility and Room Transfers here] off begin
	roomTransfersMultiCrudActive: boolean = false;
	roomTransfersDisplayName = 'Room Transfers';
	roomTransfersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Bed Facility and Room Transfers here] end
	roomTransfersOppositeRelation = 'bedFacility';
	roomTransfersRelations: ModelRelation[] = this.roomTransfersMultiCrudActive ? RoomTransferModel.getRelations()
		.map(relation => {
			if (relation.id === this.roomTransfersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = BedFacilityModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = BedFacilityModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = BedFacilityModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'intraoperativeRecords' && this.intraoperativeRecordsMultiCrudActive) {
					exp.fields = IntraoperativeRecordsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'postOperativeDetails' && this.postOperativeDetailsMultiCrudActive) {
					exp.fields = PostOperativeDetailsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'preoperativeRecords' && this.preoperativeRecordsMultiCrudActive) {
					exp.fields = PreoperativeRecordsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'roomFacility' && this.roomFacilityMultiCrudActive) {
					exp.fields = RoomFacilityModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bedReserves' && this.bedReservesMultiCrudActive) {
					exp.fields = BedReserveModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'inpatientMedicalExaminationRecords' && this.inpatientMedicalExaminationRecordsMultiCrudActive) {
					exp.fields = InpatientMedicalExaminationRecordModel.getProps().map(prop => {
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

				if (relation.id === 'roomTransfers' && this.roomTransfersMultiCrudActive) {
					exp.fields = RoomTransferModel.getProps().map(prop => {
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
	targetModel: BedFacilityModel;

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
		private readonly store: Store<{ model: BedFacilityModelState }>,
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
		this.creationNavigationSubscription$.add(this.store.select(getCountBedFacilityModels).subscribe(count => {
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

			this.targetModel = new BedFacilityModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.bedFacilityAudits$ = this.store.select(getBedFacilityModelAuditsByEntityId, this.targetModelId);
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
		const stateConfig: PassableStateConfig<BedFacilityModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.BedFacilityAction(
			modelAction.BedFacilityModelActionTypes.FETCH_BED_FACILITY,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getBedFacilityModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new BedFacilityModel(model);
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
				commands.push('bed-facility');
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

		this.store.dispatch(new modelAction.BedFacilityAction(
			modelAction.BedFacilityModelActionTypes.FETCH_BED_FACILITY_AUDITS_BY_ENTITY_ID,
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
			let stateConfig: PassableStateConfig<BedFacilityModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.intraoperativeRecordsMultiCrudActive || this.postOperativeDetailsMultiCrudActive || this.preoperativeRecordsMultiCrudActive || this.roomFacilityMultiCrudActive || this.bedReservesMultiCrudActive || this.inpatientMedicalExaminationRecordsMultiCrudActive || this.invoicesMultiCrudActive || this.registrationsMultiCrudActive || this.roomTransfersMultiCrudActive,
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
					new modelAction.BedFacilityAction(
						modelAction.BedFacilityModelActionTypes.COUNT_BED_FACILITYS,
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

			this.store.dispatch(new modelAction.BedFacilityAction(
				modelAction.BedFacilityModelActionTypes.CREATE_BED_FACILITY,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<BedFacilityModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.intraoperativeRecordsMultiCrudActive || this.postOperativeDetailsMultiCrudActive || this.preoperativeRecordsMultiCrudActive || this.roomFacilityMultiCrudActive || this.bedReservesMultiCrudActive || this.inpatientMedicalExaminationRecordsMultiCrudActive || this.invoicesMultiCrudActive || this.registrationsMultiCrudActive || this.roomTransfersMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.BedFacilityAction(
					modelAction.BedFacilityModelActionTypes.FETCH_BED_FACILITY,
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

			this.store.dispatch(new modelAction.BedFacilityAction(
				modelAction.BedFacilityModelActionTypes.UPDATE_BED_FACILITY,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: BedFacilityModel = new BedFacilityModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getBedFacilityModelWithId, this.targetModelId).subscribe(model => {
					let differences = new BedFacilityModel(model).difference(updatedModel);

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
			if (event.entityName === this.intraoperativeRecordsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(IntraoperativeRecordsModel.getProps(), this.intraoperativeRecordsRelations, this.isViewOnly),
					new IntraoperativeRecordsModel(),
					IntraoperativeRecordsModel,
					this.intraoperativeRecordsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.intraoperativeRecordsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.postOperativeDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PostOperativeDetailsModel.getProps(), this.postOperativeDetailsRelations, this.isViewOnly),
					new PostOperativeDetailsModel(),
					PostOperativeDetailsModel,
					this.postOperativeDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.postOperativeDetailsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.preoperativeRecordsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.preoperativeRecordsRelations, this.isViewOnly),
					new PreoperativeRecordsModel(),
					PreoperativeRecordsModel,
					this.preoperativeRecordsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.preoperativeRecordsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.roomFacilityDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RoomFacilityModel.getProps(), this.roomFacilityRelations, this.isViewOnly),
					new RoomFacilityModel(),
					RoomFacilityModel,
					this.roomFacilityDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.roomFacilityRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bedReservesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BedReserveModel.getProps(), this.bedReservesRelations, this.isViewOnly),
					new BedReserveModel(),
					BedReserveModel,
					this.bedReservesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bedReservesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.inpatientMedicalExaminationRecordsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InpatientMedicalExaminationRecordModel.getProps(), this.inpatientMedicalExaminationRecordsRelations, this.isViewOnly),
					new InpatientMedicalExaminationRecordModel(),
					InpatientMedicalExaminationRecordModel,
					this.inpatientMedicalExaminationRecordsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.inpatientMedicalExaminationRecordsRelations,
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

			if (event.entityName === this.roomTransfersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RoomTransferModel.getProps(), this.roomTransfersRelations, this.isViewOnly),
					new RoomTransferModel(),
					RoomTransferModel,
					this.roomTransfersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.roomTransfersRelations,
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
		this.modelProperties = BedFacilityModel.getProps();
		this.modelRelations = BedFacilityModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'intraoperativeRecords';
		}).hideElement = this.intraoperativeRecordsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'intraoperativeRecords').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'postOperativeDetails';
		}).hideElement = this.postOperativeDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'postOperativeDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'preoperativeRecords';
		}).hideElement = this.preoperativeRecordsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'preoperativeRecords').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'roomFacility';
		}).hideElement = this.roomFacilityMultiCrudActive || this.modelRelations.find(rel => rel.id === 'roomFacility').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bedReserves';
		}).hideElement = this.bedReservesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bedReserves').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'inpatientMedicalExaminationRecords';
		}).hideElement = this.inpatientMedicalExaminationRecordsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'inpatientMedicalExaminationRecords').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'invoices';
		}).hideElement = this.invoicesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'invoices').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'registrations';
		}).hideElement = this.registrationsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'registrations').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'roomTransfers';
		}).hideElement = this.roomTransfersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'roomTransfers').hideElement;

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
		if (this.intraoperativeRecordsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.intraoperativeRecordsDisplayName, many: false});
		}

		if (this.postOperativeDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.postOperativeDetailsDisplayName, many: false});
		}

		if (this.preoperativeRecordsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.preoperativeRecordsDisplayName, many: false});
		}

		if (this.roomFacilityMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.roomFacilityDisplayName, many: false});
		}

		if (this.bedReservesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bedReservesDisplayName, many: true});
			this.store.dispatch(new bedReserveModelAction.BedReserveAction(
				bedReserveModelAction.BedReserveModelActionTypes.INITIALISE_BED_RESERVE_COLLECTION_STATE,
				{
					collectionId: this.bedReservesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBedReserveCollectionModels, this.bedReservesCollectionId).subscribe(models => {
				models.forEach(bedReserves => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BedReserveModel.getProps(), this.bedReservesRelations, this.isViewOnly),
						bedReserves,
						BedReserveModel,
						this.bedReservesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bedReservesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.inpatientMedicalExaminationRecordsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.inpatientMedicalExaminationRecordsDisplayName, many: true});
			this.store.dispatch(new inpatientMedicalExaminationRecordModelAction.InpatientMedicalExaminationRecordAction(
				inpatientMedicalExaminationRecordModelAction.InpatientMedicalExaminationRecordModelActionTypes.INITIALISE_INPATIENT_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE,
				{
					collectionId: this.inpatientMedicalExaminationRecordsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInpatientMedicalExaminationRecordCollectionModels, this.inpatientMedicalExaminationRecordsCollectionId).subscribe(models => {
				models.forEach(inpatientMedicalExaminationRecords => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InpatientMedicalExaminationRecordModel.getProps(), this.inpatientMedicalExaminationRecordsRelations, this.isViewOnly),
						inpatientMedicalExaminationRecords,
						InpatientMedicalExaminationRecordModel,
						this.inpatientMedicalExaminationRecordsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.inpatientMedicalExaminationRecordsRelations,
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

		if (this.roomTransfersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.roomTransfersDisplayName, many: true});
			this.store.dispatch(new roomTransferModelAction.RoomTransferAction(
				roomTransferModelAction.RoomTransferModelActionTypes.INITIALISE_ROOM_TRANSFER_COLLECTION_STATE,
				{
					collectionId: this.roomTransfersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getRoomTransferCollectionModels, this.roomTransfersCollectionId).subscribe(models => {
				models.forEach(roomTransfers => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(RoomTransferModel.getProps(), this.roomTransfersRelations, this.isViewOnly),
						roomTransfers,
						RoomTransferModel,
						this.roomTransfersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.roomTransfersRelations,
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
		if (this.targetModel.intraoperativeRecords && this.targetModel.intraoperativeRecords.id && this.intraoperativeRecordsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				IntraoperativeRecordsModel,
				this.intraoperativeRecordsOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.intraoperativeRecords.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getIntraoperativeRecordsModelWithId, this.targetModel.intraoperativeRecordsId).subscribe(intraoperativeRecords => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(IntraoperativeRecordsModel.getProps(), this.intraoperativeRecordsRelations, this.isViewOnly),
					intraoperativeRecords,
					IntraoperativeRecordsModel,
					this.intraoperativeRecordsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.intraoperativeRecordsRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.postOperativeDetails && this.targetModel.postOperativeDetails.id && this.postOperativeDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PostOperativeDetailsModel,
				this.postOperativeDetailsOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.postOperativeDetails.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPostOperativeDetailsModelWithId, this.targetModel.postOperativeDetailsId).subscribe(postOperativeDetails => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PostOperativeDetailsModel.getProps(), this.postOperativeDetailsRelations, this.isViewOnly),
					postOperativeDetails,
					PostOperativeDetailsModel,
					this.postOperativeDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.postOperativeDetailsRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.preoperativeRecords && this.targetModel.preoperativeRecords.id && this.preoperativeRecordsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PreoperativeRecordsModel,
				this.preoperativeRecordsOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.preoperativeRecords.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPreoperativeRecordsModelWithId, this.targetModel.preoperativeRecordsId).subscribe(preoperativeRecords => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.preoperativeRecordsRelations, this.isViewOnly),
					preoperativeRecords,
					PreoperativeRecordsModel,
					this.preoperativeRecordsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.preoperativeRecordsRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.roomFacility && this.targetModel.roomFacility.id && this.roomFacilityMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RoomFacilityModel,
				this.roomFacilityOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.roomFacility.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getRoomFacilityModelWithId, this.targetModel.roomFacilityId).subscribe(roomFacility => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RoomFacilityModel.getProps(), this.roomFacilityRelations, this.isViewOnly),
					roomFacility,
					RoomFacilityModel,
					this.roomFacilityDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.roomFacilityRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bedReservesIds && this.targetModel.bedReservesIds.length > 0 && this.bedReservesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BedReserveModel,
				this.bedReservesOppositeRelation,
				this.bedReservesCollectionId,
				this.targetModel.bedReservesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.inpatientMedicalExaminationRecordsIds && this.targetModel.inpatientMedicalExaminationRecordsIds.length > 0 && this.inpatientMedicalExaminationRecordsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InpatientMedicalExaminationRecordModel,
				this.inpatientMedicalExaminationRecordsOppositeRelation,
				this.inpatientMedicalExaminationRecordsCollectionId,
				this.targetModel.inpatientMedicalExaminationRecordsIds.length,
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

		if (this.targetModel.roomTransfersIds && this.targetModel.roomTransfersIds.length > 0 && this.roomTransfersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RoomTransferModel,
				this.roomTransfersOppositeRelation,
				this.roomTransfersCollectionId,
				this.targetModel.roomTransfersIds.length,
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
	addAdditionalEntitiesToModel(model: BedFacilityModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): BedFacilityModel {
		let updatedModel: BedFacilityModel = new BedFacilityModel(model);

		if (this.intraoperativeRecordsMultiCrudActive) {
			updatedModel.intraoperativeRecords = event.additionalEntities.intraoperativeRecords ? event.additionalEntities.intraoperativeRecords : undefined;

			if (!updatedModel.intraoperativeRecords && event.payload) {
				event.payload.intraoperativeRecordsId = null;
			}
		} else if (event.payload?.intraoperativeRecordsId !== undefined) {
			event.payload.intraoperativeRecords = null;
			updatedModel.intraoperativeRecords = null;
		}

		if (this.postOperativeDetailsMultiCrudActive) {
			updatedModel.postOperativeDetails = event.additionalEntities.postOperativeDetails ? event.additionalEntities.postOperativeDetails : undefined;

			if (!updatedModel.postOperativeDetails && event.payload) {
				event.payload.postOperativeDetailsId = null;
			}
		} else if (event.payload?.postOperativeDetailsId !== undefined) {
			event.payload.postOperativeDetails = null;
			updatedModel.postOperativeDetails = null;
		}

		if (this.preoperativeRecordsMultiCrudActive) {
			updatedModel.preoperativeRecords = event.additionalEntities.preoperativeRecords ? event.additionalEntities.preoperativeRecords : undefined;

			if (!updatedModel.preoperativeRecords && event.payload) {
				event.payload.preoperativeRecordsId = null;
			}
		} else if (event.payload?.preoperativeRecordsId !== undefined) {
			event.payload.preoperativeRecords = null;
			updatedModel.preoperativeRecords = null;
		}

		if (this.roomFacilityMultiCrudActive) {
			updatedModel.roomFacility = event.additionalEntities.roomFacility ? event.additionalEntities.roomFacility : undefined;

			if (!updatedModel.roomFacility && event.payload) {
				event.payload.roomFacilityId = null;
			}
		} else if (event.payload?.roomFacilityId !== undefined) {
			event.payload.roomFacility = null;
			updatedModel.roomFacility = null;
		}

		updatedModel.bedReserves = [];
		if (this.bedReservesMultiCrudActive) {
			if (event.additionalEntities.bedReserves) {
				event.additionalEntities.bedReserves.forEach(entity => {
					updatedModel.bedReserves.push(entity);
				});
			}

			if (!updatedModel.bedReserves.length) {
				updatedModel.bedReservesIds = [];
			}
		}
		updatedModel.inpatientMedicalExaminationRecords = [];
		if (this.inpatientMedicalExaminationRecordsMultiCrudActive) {
			if (event.additionalEntities.inpatientMedicalExaminationRecords) {
				event.additionalEntities.inpatientMedicalExaminationRecords.forEach(entity => {
					updatedModel.inpatientMedicalExaminationRecords.push(entity);
				});
			}

			if (!updatedModel.inpatientMedicalExaminationRecords.length) {
				updatedModel.inpatientMedicalExaminationRecordsIds = [];
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
		updatedModel.roomTransfers = [];
		if (this.roomTransfersMultiCrudActive) {
			if (event.additionalEntities.roomTransfers) {
				event.additionalEntities.roomTransfers.forEach(entity => {
					updatedModel.roomTransfers.push(entity);
				});
			}

			if (!updatedModel.roomTransfers.length) {
				updatedModel.roomTransfersIds = [];
			}
		}
		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
