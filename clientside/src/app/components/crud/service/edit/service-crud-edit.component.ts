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
import * as modelAction from 'src/app/models/service/service.model.action';
import {ServiceModelState, ServiceModelAudit} from 'src/app/models/service/service.model.state';
import {ServiceModel} from 'src/app/models/service/service.model';
import {
	getServiceModelAuditsByEntityId,
	getServiceModelWithId,
	getCountServiceModels,
} from 'src/app/models/service/service.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {BpjsPcarePoliModel} from 'src/app/models/bpjsPcarePoli/bpjs_pcare_poli.model';
import * as bpjsPcarePoliModelAction from 'src/app/models/bpjsPcarePoli/bpjs_pcare_poli.model.action';
import {
	getBpjsPcarePoliCollectionModels, getBpjsPcarePoliModelWithId,
} from 'src/app/models/bpjsPcarePoli/bpjs_pcare_poli.model.selector';
import {BpjsServiceMappingModel} from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model';
import * as bpjsServiceMappingModelAction from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.action';
import {
	getBpjsServiceMappingCollectionModels, getBpjsServiceMappingModelWithId,
} from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import {DoctorScheduleModel} from 'src/app/models/doctorSchedule/doctor_schedule.model';
import * as doctorScheduleModelAction from 'src/app/models/doctorSchedule/doctor_schedule.model.action';
import {
	getDoctorScheduleCollectionModels, getDoctorScheduleModelWithId,
} from 'src/app/models/doctorSchedule/doctor_schedule.model.selector';
import {ExaminationGroupModel} from 'src/app/models/examinationGroup/examination_group.model';
import * as examinationGroupModelAction from 'src/app/models/examinationGroup/examination_group.model.action';
import {
	getExaminationGroupCollectionModels, getExaminationGroupModelWithId,
} from 'src/app/models/examinationGroup/examination_group.model.selector';
import {McuPackageItemModel} from 'src/app/models/mcuPackageItem/mcu_package_item.model';
import * as mcuPackageItemModelAction from 'src/app/models/mcuPackageItem/mcu_package_item.model.action';
import {
	getMcuPackageItemCollectionModels, getMcuPackageItemModelWithId,
} from 'src/app/models/mcuPackageItem/mcu_package_item.model.selector';
import {RegistrationModel} from 'src/app/models/registration/registration.model';
import * as registrationModelAction from 'src/app/models/registration/registration.model.action';
import {
	getRegistrationCollectionModels, getRegistrationModelWithId,
} from 'src/app/models/registration/registration.model.selector';
import {ServiceFacilityCategoryModel} from 'src/app/models/serviceFacilityCategory/service_facility_category.model';
import * as serviceFacilityCategoryModelAction from 'src/app/models/serviceFacilityCategory/service_facility_category.model.action';
import {
	getServiceFacilityCategoryCollectionModels, getServiceFacilityCategoryModelWithId,
} from 'src/app/models/serviceFacilityCategory/service_facility_category.model.selector';
import {ServiceItemModel} from 'src/app/models/serviceItem/service_item.model';
import * as serviceItemModelAction from 'src/app/models/serviceItem/service_item.model.action';
import {
	getServiceItemCollectionModels, getServiceItemModelWithId,
} from 'src/app/models/serviceItem/service_item.model.selector';
import {StaffModel} from 'src/app/models/staff/staff.model';
import * as staffModelAction from 'src/app/models/staff/staff.model.action';
import {
	getStaffCollectionModels, getStaffModelWithId,
} from 'src/app/models/staff/staff.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../service-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-service-crud-edit',
	templateUrl: './service-crud-edit.component.html',
	styleUrls: [
		'./service-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class ServiceCrudEditComponent
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
	collectionId: string = '4c979c0a-c1e6-4d0c-9e61-577662fee27d';
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
	serviceAudits$: Observable<ServiceModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and BPJS Pcare Poli here] off begin
	bpjsPcarePoliMultiCrudActive: boolean = false;
	bpjsPcarePoliDisplayName = 'BPJS Pcare Poli';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and BPJS Pcare Poli here] end
	bpjsPcarePoliOppositeRelation = 'service';
	bpjsPcarePoliRelations: ModelRelation[] = this.bpjsPcarePoliMultiCrudActive ? BpjsPcarePoliModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsPcarePoliOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and BPJS Service Mapping here] off begin
	bpjsServiceMappingMultiCrudActive: boolean = false;
	bpjsServiceMappingDisplayName = 'BPJS Service Mapping';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and BPJS Service Mapping here] end
	bpjsServiceMappingOppositeRelation = 'service';
	bpjsServiceMappingRelations: ModelRelation[] = this.bpjsServiceMappingMultiCrudActive ? BpjsServiceMappingModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsServiceMappingOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Default Medical Staff and Service here] off begin
	defaultMedicalStaffMultiCrudActive: boolean = false;
	defaultMedicalStaffDisplayName = 'Default Medical Staff';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Default Medical Staff and Service here] end
	defaultMedicalStaffOppositeRelation = 'service';
	defaultMedicalStaffRelations: ModelRelation[] = this.defaultMedicalStaffMultiCrudActive ? StaffModel.getRelations()
		.map(relation => {
			if (relation.id === this.defaultMedicalStaffOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and Doctor Schedules here] off begin
	doctorSchedulesMultiCrudActive: boolean = false;
	doctorSchedulesDisplayName = 'Doctor Schedules';
	doctorSchedulesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and Doctor Schedules here] end
	doctorSchedulesOppositeRelation = 'service';
	doctorSchedulesRelations: ModelRelation[] = this.doctorSchedulesMultiCrudActive ? DoctorScheduleModel.getRelations()
		.map(relation => {
			if (relation.id === this.doctorSchedulesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and Examination Groups here] off begin
	examinationGroupsMultiCrudActive: boolean = false;
	examinationGroupsDisplayName = 'Examination Groups';
	examinationGroupsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and Examination Groups here] end
	examinationGroupsOppositeRelation = 'service';
	examinationGroupsRelations: ModelRelation[] = this.examinationGroupsMultiCrudActive ? ExaminationGroupModel.getRelations()
		.map(relation => {
			if (relation.id === this.examinationGroupsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and MCU Package Items here] off begin
	mcuPackageItemsMultiCrudActive: boolean = false;
	mcuPackageItemsDisplayName = 'MCU Package Items';
	mcuPackageItemsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and MCU Package Items here] end
	mcuPackageItemsOppositeRelation = 'service';
	mcuPackageItemsRelations: ModelRelation[] = this.mcuPackageItemsMultiCrudActive ? McuPackageItemModel.getRelations()
		.map(relation => {
			if (relation.id === this.mcuPackageItemsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Referring Unit and Referring Unit here] off begin
	referringUnitMultiCrudActive: boolean = false;
	referringUnitDisplayName = 'Referring Unit';
	referringUnitCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Referring Unit and Referring Unit here] end
	referringUnitOppositeRelation = 'referringUnit';
	referringUnitRelations: ModelRelation[] = this.referringUnitMultiCrudActive ? RegistrationModel.getRelations()
		.map(relation => {
			if (relation.id === this.referringUnitOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and Registrations here] off begin
	registrationsMultiCrudActive: boolean = false;
	registrationsDisplayName = 'Registrations';
	registrationsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and Registrations here] end
	registrationsOppositeRelation = 'service';
	registrationsRelations: ModelRelation[] = this.registrationsMultiCrudActive ? RegistrationModel.getRelations()
		.map(relation => {
			if (relation.id === this.registrationsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and Service Facility Categories here] off begin
	serviceFacilityCategoriesMultiCrudActive: boolean = false;
	serviceFacilityCategoriesDisplayName = 'Service Facility Categories';
	serviceFacilityCategoriesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and Service Facility Categories here] end
	serviceFacilityCategoriesOppositeRelation = 'service';
	serviceFacilityCategoriesRelations: ModelRelation[] = this.serviceFacilityCategoriesMultiCrudActive ? ServiceFacilityCategoryModel.getRelations()
		.map(relation => {
			if (relation.id === this.serviceFacilityCategoriesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Services and Service Items here] off begin
	serviceItemsMultiCrudActive: boolean = false;
	serviceItemsDisplayName = 'Service Items';
	serviceItemsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Services and Service Items here] end
	serviceItemsOppositeRelation = 'services';
	serviceItemsRelations: ModelRelation[] = this.serviceItemsMultiCrudActive ? ServiceItemModel.getRelations()
		.map(relation => {
			if (relation.id === this.serviceItemsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Assigned Medical Staff and Services here] off begin
	assignedMedicalStaffMultiCrudActive: boolean = false;
	assignedMedicalStaffDisplayName = 'Assigned Medical Staff';
	assignedMedicalStaffCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Assigned Medical Staff and Services here] end
	assignedMedicalStaffOppositeRelation = 'services';
	assignedMedicalStaffRelations: ModelRelation[] = this.assignedMedicalStaffMultiCrudActive ? StaffModel.getRelations()
		.map(relation => {
			if (relation.id === this.assignedMedicalStaffOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = ServiceModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = ServiceModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = ServiceModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'bpjsPcarePoli' && this.bpjsPcarePoliMultiCrudActive) {
					exp.fields = BpjsPcarePoliModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsServiceMapping' && this.bpjsServiceMappingMultiCrudActive) {
					exp.fields = BpjsServiceMappingModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'defaultMedicalStaff' && this.defaultMedicalStaffMultiCrudActive) {
					exp.fields = StaffModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'doctorSchedules' && this.doctorSchedulesMultiCrudActive) {
					exp.fields = DoctorScheduleModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'examinationGroups' && this.examinationGroupsMultiCrudActive) {
					exp.fields = ExaminationGroupModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'mcuPackageItems' && this.mcuPackageItemsMultiCrudActive) {
					exp.fields = McuPackageItemModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'referringUnit' && this.referringUnitMultiCrudActive) {
					exp.fields = RegistrationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'registrations' && this.registrationsMultiCrudActive) {
					exp.fields = RegistrationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'serviceFacilityCategories' && this.serviceFacilityCategoriesMultiCrudActive) {
					exp.fields = ServiceFacilityCategoryModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'serviceItems' && this.serviceItemsMultiCrudActive) {
					exp.fields = ServiceItemModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'assignedMedicalStaff' && this.assignedMedicalStaffMultiCrudActive) {
					exp.fields = StaffModel.getProps().map(prop => {
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
	targetModel: ServiceModel;

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
		private readonly store: Store<{ model: ServiceModelState }>,
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
		this.creationNavigationSubscription$.add(this.store.select(getCountServiceModels).subscribe(count => {
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

			this.targetModel = new ServiceModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.serviceAudits$ = this.store.select(getServiceModelAuditsByEntityId, this.targetModelId);
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
		const stateConfig: PassableStateConfig<ServiceModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.ServiceAction(
			modelAction.ServiceModelActionTypes.FETCH_SERVICE,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getServiceModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new ServiceModel(model);
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
				commands.push('service');
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

		this.store.dispatch(new modelAction.ServiceAction(
			modelAction.ServiceModelActionTypes.FETCH_SERVICE_AUDITS_BY_ENTITY_ID,
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
			let stateConfig: PassableStateConfig<ServiceModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.defaultMedicalStaffMultiCrudActive || this.bpjsPcarePoliMultiCrudActive || this.bpjsServiceMappingMultiCrudActive || this.doctorSchedulesMultiCrudActive || this.examinationGroupsMultiCrudActive || this.mcuPackageItemsMultiCrudActive || this.referringUnitMultiCrudActive || this.registrationsMultiCrudActive || this.serviceFacilityCategoriesMultiCrudActive || this.serviceItemsMultiCrudActive || this.assignedMedicalStaffMultiCrudActive,
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
					new modelAction.ServiceAction(
						modelAction.ServiceModelActionTypes.COUNT_SERVICES,
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

			this.store.dispatch(new modelAction.ServiceAction(
				modelAction.ServiceModelActionTypes.CREATE_SERVICE,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<ServiceModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.defaultMedicalStaffMultiCrudActive || this.bpjsPcarePoliMultiCrudActive || this.bpjsServiceMappingMultiCrudActive || this.doctorSchedulesMultiCrudActive || this.examinationGroupsMultiCrudActive || this.mcuPackageItemsMultiCrudActive || this.referringUnitMultiCrudActive || this.registrationsMultiCrudActive || this.serviceFacilityCategoriesMultiCrudActive || this.serviceItemsMultiCrudActive || this.assignedMedicalStaffMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.ServiceAction(
					modelAction.ServiceModelActionTypes.FETCH_SERVICE,
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

			this.store.dispatch(new modelAction.ServiceAction(
				modelAction.ServiceModelActionTypes.UPDATE_SERVICE,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: ServiceModel = new ServiceModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getServiceModelWithId, this.targetModelId).subscribe(model => {
					let differences = new ServiceModel(model).difference(updatedModel);

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
			if (event.entityName === this.defaultMedicalStaffDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.defaultMedicalStaffRelations, this.isViewOnly),
					new StaffModel(),
					StaffModel,
					this.defaultMedicalStaffDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.defaultMedicalStaffRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsPcarePoliDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsPcarePoliModel.getProps(), this.bpjsPcarePoliRelations, this.isViewOnly),
					new BpjsPcarePoliModel(),
					BpjsPcarePoliModel,
					this.bpjsPcarePoliDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsPcarePoliRelations,
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

			if (event.entityName === this.doctorSchedulesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DoctorScheduleModel.getProps(), this.doctorSchedulesRelations, this.isViewOnly),
					new DoctorScheduleModel(),
					DoctorScheduleModel,
					this.doctorSchedulesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.doctorSchedulesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.examinationGroupsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ExaminationGroupModel.getProps(), this.examinationGroupsRelations, this.isViewOnly),
					new ExaminationGroupModel(),
					ExaminationGroupModel,
					this.examinationGroupsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.examinationGroupsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.mcuPackageItemsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(McuPackageItemModel.getProps(), this.mcuPackageItemsRelations, this.isViewOnly),
					new McuPackageItemModel(),
					McuPackageItemModel,
					this.mcuPackageItemsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.mcuPackageItemsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.referringUnitDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RegistrationModel.getProps(), this.referringUnitRelations, this.isViewOnly),
					new RegistrationModel(),
					RegistrationModel,
					this.referringUnitDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.referringUnitRelations,
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

			if (event.entityName === this.serviceFacilityCategoriesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ServiceFacilityCategoryModel.getProps(), this.serviceFacilityCategoriesRelations, this.isViewOnly),
					new ServiceFacilityCategoryModel(),
					ServiceFacilityCategoryModel,
					this.serviceFacilityCategoriesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.serviceFacilityCategoriesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.serviceItemsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ServiceItemModel.getProps(), this.serviceItemsRelations, this.isViewOnly),
					new ServiceItemModel(),
					ServiceItemModel,
					this.serviceItemsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.serviceItemsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.assignedMedicalStaffDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.assignedMedicalStaffRelations, this.isViewOnly),
					new StaffModel(),
					StaffModel,
					this.assignedMedicalStaffDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.assignedMedicalStaffRelations,
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
		this.modelProperties = ServiceModel.getProps();
		this.modelRelations = ServiceModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'defaultMedicalStaff';
		}).hideElement = this.defaultMedicalStaffMultiCrudActive || this.modelRelations.find(rel => rel.id === 'defaultMedicalStaff').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsPcarePoli';
		}).hideElement = this.bpjsPcarePoliMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsPcarePoli').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsServiceMapping';
		}).hideElement = this.bpjsServiceMappingMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsServiceMapping').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'doctorSchedules';
		}).hideElement = this.doctorSchedulesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'doctorSchedules').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'examinationGroups';
		}).hideElement = this.examinationGroupsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'examinationGroups').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'mcuPackageItems';
		}).hideElement = this.mcuPackageItemsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'mcuPackageItems').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'referringUnit';
		}).hideElement = this.referringUnitMultiCrudActive || this.modelRelations.find(rel => rel.id === 'referringUnit').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'registrations';
		}).hideElement = this.registrationsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'registrations').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'serviceFacilityCategories';
		}).hideElement = this.serviceFacilityCategoriesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'serviceFacilityCategories').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'serviceItems';
		}).hideElement = this.serviceItemsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'serviceItems').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'assignedMedicalStaff';
		}).hideElement = this.assignedMedicalStaffMultiCrudActive || this.modelRelations.find(rel => rel.id === 'assignedMedicalStaff').hideElement;

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
		if (this.defaultMedicalStaffMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.defaultMedicalStaffDisplayName, many: false});
		}

		if (this.bpjsPcarePoliMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsPcarePoliDisplayName, many: false});
		}

		if (this.bpjsServiceMappingMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsServiceMappingDisplayName, many: false});
		}

		if (this.doctorSchedulesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.doctorSchedulesDisplayName, many: true});
			this.store.dispatch(new doctorScheduleModelAction.DoctorScheduleAction(
				doctorScheduleModelAction.DoctorScheduleModelActionTypes.INITIALISE_DOCTOR_SCHEDULE_COLLECTION_STATE,
				{
					collectionId: this.doctorSchedulesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getDoctorScheduleCollectionModels, this.doctorSchedulesCollectionId).subscribe(models => {
				models.forEach(doctorSchedules => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(DoctorScheduleModel.getProps(), this.doctorSchedulesRelations, this.isViewOnly),
						doctorSchedules,
						DoctorScheduleModel,
						this.doctorSchedulesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.doctorSchedulesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.examinationGroupsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.examinationGroupsDisplayName, many: true});
			this.store.dispatch(new examinationGroupModelAction.ExaminationGroupAction(
				examinationGroupModelAction.ExaminationGroupModelActionTypes.INITIALISE_EXAMINATION_GROUP_COLLECTION_STATE,
				{
					collectionId: this.examinationGroupsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getExaminationGroupCollectionModels, this.examinationGroupsCollectionId).subscribe(models => {
				models.forEach(examinationGroups => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(ExaminationGroupModel.getProps(), this.examinationGroupsRelations, this.isViewOnly),
						examinationGroups,
						ExaminationGroupModel,
						this.examinationGroupsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.examinationGroupsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.mcuPackageItemsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.mcuPackageItemsDisplayName, many: true});
			this.store.dispatch(new mcuPackageItemModelAction.McuPackageItemAction(
				mcuPackageItemModelAction.McuPackageItemModelActionTypes.INITIALISE_MCU_PACKAGE_ITEM_COLLECTION_STATE,
				{
					collectionId: this.mcuPackageItemsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMcuPackageItemCollectionModels, this.mcuPackageItemsCollectionId).subscribe(models => {
				models.forEach(mcuPackageItems => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(McuPackageItemModel.getProps(), this.mcuPackageItemsRelations, this.isViewOnly),
						mcuPackageItems,
						McuPackageItemModel,
						this.mcuPackageItemsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.mcuPackageItemsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.referringUnitMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.referringUnitDisplayName, many: true});
			this.store.dispatch(new registrationModelAction.RegistrationAction(
				registrationModelAction.RegistrationModelActionTypes.INITIALISE_REGISTRATION_COLLECTION_STATE,
				{
					collectionId: this.referringUnitCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getRegistrationCollectionModels, this.referringUnitCollectionId).subscribe(models => {
				models.forEach(referringUnit => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(RegistrationModel.getProps(), this.referringUnitRelations, this.isViewOnly),
						referringUnit,
						RegistrationModel,
						this.referringUnitDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.referringUnitRelations,
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

		if (this.serviceFacilityCategoriesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.serviceFacilityCategoriesDisplayName, many: true});
			this.store.dispatch(new serviceFacilityCategoryModelAction.ServiceFacilityCategoryAction(
				serviceFacilityCategoryModelAction.ServiceFacilityCategoryModelActionTypes.INITIALISE_SERVICE_FACILITY_CATEGORY_COLLECTION_STATE,
				{
					collectionId: this.serviceFacilityCategoriesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getServiceFacilityCategoryCollectionModels, this.serviceFacilityCategoriesCollectionId).subscribe(models => {
				models.forEach(serviceFacilityCategories => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(ServiceFacilityCategoryModel.getProps(), this.serviceFacilityCategoriesRelations, this.isViewOnly),
						serviceFacilityCategories,
						ServiceFacilityCategoryModel,
						this.serviceFacilityCategoriesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.serviceFacilityCategoriesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.serviceItemsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.serviceItemsDisplayName, many: true});
			this.store.dispatch(new serviceItemModelAction.ServiceItemAction(
				serviceItemModelAction.ServiceItemModelActionTypes.INITIALISE_SERVICE_ITEM_COLLECTION_STATE,
				{
					collectionId: this.serviceItemsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getServiceItemCollectionModels, this.serviceItemsCollectionId).subscribe(models => {
				models.forEach(serviceItems => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(ServiceItemModel.getProps(), this.serviceItemsRelations, this.isViewOnly),
						serviceItems,
						ServiceItemModel,
						this.serviceItemsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.serviceItemsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.assignedMedicalStaffMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.assignedMedicalStaffDisplayName, many: true});
			this.store.dispatch(new staffModelAction.StaffAction(
				staffModelAction.StaffModelActionTypes.INITIALISE_STAFF_COLLECTION_STATE,
				{
					collectionId: this.assignedMedicalStaffCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getStaffCollectionModels, this.assignedMedicalStaffCollectionId).subscribe(models => {
				models.forEach(assignedMedicalStaff => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(StaffModel.getProps(), this.assignedMedicalStaffRelations, this.isViewOnly),
						assignedMedicalStaff,
						StaffModel,
						this.assignedMedicalStaffDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.assignedMedicalStaffRelations,
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
		if (this.targetModel.bpjsPcarePoli && this.targetModel.bpjsPcarePoli.id && this.bpjsPcarePoliMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsPcarePoliModel,
				this.bpjsPcarePoliOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bpjsPcarePoli.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsPcarePoliModelWithId, this.targetModel.bpjsPcarePoliId).subscribe(bpjsPcarePoli => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsPcarePoliModel.getProps(), this.bpjsPcarePoliRelations, this.isViewOnly),
					bpjsPcarePoli,
					BpjsPcarePoliModel,
					this.bpjsPcarePoliDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsPcarePoliRelations,
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

		if (this.targetModel.defaultMedicalStaff && this.targetModel.defaultMedicalStaff.id && this.defaultMedicalStaffMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StaffModel,
				this.defaultMedicalStaffOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.defaultMedicalStaff.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getStaffModelWithId, this.targetModel.defaultMedicalStaffId).subscribe(defaultMedicalStaff => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.defaultMedicalStaffRelations, this.isViewOnly),
					defaultMedicalStaff,
					StaffModel,
					this.defaultMedicalStaffDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.defaultMedicalStaffRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.doctorSchedulesIds && this.targetModel.doctorSchedulesIds.length > 0 && this.doctorSchedulesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DoctorScheduleModel,
				this.doctorSchedulesOppositeRelation,
				this.doctorSchedulesCollectionId,
				this.targetModel.doctorSchedulesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.examinationGroupsIds && this.targetModel.examinationGroupsIds.length > 0 && this.examinationGroupsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				ExaminationGroupModel,
				this.examinationGroupsOppositeRelation,
				this.examinationGroupsCollectionId,
				this.targetModel.examinationGroupsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.mcuPackageItemsIds && this.targetModel.mcuPackageItemsIds.length > 0 && this.mcuPackageItemsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				McuPackageItemModel,
				this.mcuPackageItemsOppositeRelation,
				this.mcuPackageItemsCollectionId,
				this.targetModel.mcuPackageItemsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.referringUnitIds && this.targetModel.referringUnitIds.length > 0 && this.referringUnitMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RegistrationModel,
				this.referringUnitOppositeRelation,
				this.referringUnitCollectionId,
				this.targetModel.referringUnitIds.length,
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

		if (this.targetModel.serviceFacilityCategoriesIds && this.targetModel.serviceFacilityCategoriesIds.length > 0 && this.serviceFacilityCategoriesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				ServiceFacilityCategoryModel,
				this.serviceFacilityCategoriesOppositeRelation,
				this.serviceFacilityCategoriesCollectionId,
				this.targetModel.serviceFacilityCategoriesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.serviceItemsIds && this.targetModel.serviceItemsIds.length > 0 && this.serviceItemsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				ServiceItemModel,
				this.serviceItemsOppositeRelation,
				this.serviceItemsCollectionId,
				this.targetModel.serviceItemsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.assignedMedicalStaffIds && this.targetModel.assignedMedicalStaffIds.length > 0 && this.assignedMedicalStaffMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StaffModel,
				this.assignedMedicalStaffOppositeRelation,
				this.assignedMedicalStaffCollectionId,
				this.targetModel.assignedMedicalStaffIds.length,
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
	addAdditionalEntitiesToModel(model: ServiceModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): ServiceModel {
		let updatedModel: ServiceModel = new ServiceModel(model);

		if (this.defaultMedicalStaffMultiCrudActive) {
			updatedModel.defaultMedicalStaff = event.additionalEntities.defaultMedicalStaff ? event.additionalEntities.defaultMedicalStaff : undefined;

			if (!updatedModel.defaultMedicalStaff && event.payload) {
				event.payload.defaultMedicalStaffId = null;
			}
		} else if (event.payload?.defaultMedicalStaffId !== undefined) {
			event.payload.defaultMedicalStaff = null;
			updatedModel.defaultMedicalStaff = null;
		}

		if (this.bpjsPcarePoliMultiCrudActive) {
			updatedModel.bpjsPcarePoli = event.additionalEntities.bpjsPcarePoli ? event.additionalEntities.bpjsPcarePoli : undefined;

			if (!updatedModel.bpjsPcarePoli && event.payload) {
				event.payload.bpjsPcarePoliId = null;
			}
		} else if (event.payload?.bpjsPcarePoliId !== undefined) {
			event.payload.bpjsPcarePoli = null;
			updatedModel.bpjsPcarePoli = null;
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

		updatedModel.doctorSchedules = [];
		if (this.doctorSchedulesMultiCrudActive) {
			if (event.additionalEntities.doctorSchedules) {
				event.additionalEntities.doctorSchedules.forEach(entity => {
					updatedModel.doctorSchedules.push(entity);
				});
			}

			if (!updatedModel.doctorSchedules.length) {
				updatedModel.doctorSchedulesIds = [];
			}
		}
		updatedModel.examinationGroups = [];
		if (this.examinationGroupsMultiCrudActive) {
			if (event.additionalEntities.examinationGroups) {
				event.additionalEntities.examinationGroups.forEach(entity => {
					updatedModel.examinationGroups.push(entity);
				});
			}

			if (!updatedModel.examinationGroups.length) {
				updatedModel.examinationGroupsIds = [];
			}
		}
		updatedModel.mcuPackageItems = [];
		if (this.mcuPackageItemsMultiCrudActive) {
			if (event.additionalEntities.mcuPackageItems) {
				event.additionalEntities.mcuPackageItems.forEach(entity => {
					updatedModel.mcuPackageItems.push(entity);
				});
			}

			if (!updatedModel.mcuPackageItems.length) {
				updatedModel.mcuPackageItemsIds = [];
			}
		}
		updatedModel.referringUnit = [];
		if (this.referringUnitMultiCrudActive) {
			if (event.additionalEntities.referringUnit) {
				event.additionalEntities.referringUnit.forEach(entity => {
					updatedModel.referringUnit.push(entity);
				});
			}

			if (!updatedModel.referringUnit.length) {
				updatedModel.referringUnitIds = [];
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
		updatedModel.serviceFacilityCategories = [];
		if (this.serviceFacilityCategoriesMultiCrudActive) {
			if (event.additionalEntities.serviceFacilityCategories) {
				event.additionalEntities.serviceFacilityCategories.forEach(entity => {
					updatedModel.serviceFacilityCategories.push(entity);
				});
			}

			if (!updatedModel.serviceFacilityCategories.length) {
				updatedModel.serviceFacilityCategoriesIds = [];
			}
		}
		updatedModel.serviceItems = [];
		if (this.serviceItemsMultiCrudActive) {
			if (event.additionalEntities.serviceItems) {
				event.additionalEntities.serviceItems.forEach(entity => {
					updatedModel.serviceItems.push(entity);
				});
			}

			if (!updatedModel.serviceItems.length) {
				updatedModel.serviceItemsIds = [];
			}
		}

		updatedModel.assignedMedicalStaff = [];
		if (this.assignedMedicalStaffMultiCrudActive) {
			if (event.additionalEntities.assignedMedicalStaff) {
				event.additionalEntities.assignedMedicalStaff.forEach(entity => {
					updatedModel.assignedMedicalStaff.push(entity);
				});
			}

			if (!updatedModel.assignedMedicalStaff.length) {
				updatedModel.assignedMedicalStaffIds = [];
			}
		}

		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
