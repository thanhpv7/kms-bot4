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
import * as modelAction from 'src/app/models/preoperativeRecords/preoperative_records.model.action';
import {PreoperativeRecordsModelState, PreoperativeRecordsModelAudit} from 'src/app/models/preoperativeRecords/preoperative_records.model.state';
import {PreoperativeRecordsModel} from 'src/app/models/preoperativeRecords/preoperative_records.model';
import {
	getPreoperativeRecordsModelAuditsByEntityId,
	getPreoperativeRecordsModelWithId,
	getCountPreoperativeRecordsModels,
} from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {BedFacilityModel} from 'src/app/models/bedFacility/bed_facility.model';
import * as bedFacilityModelAction from 'src/app/models/bedFacility/bed_facility.model.action';
import {
	getBedFacilityCollectionModels, getBedFacilityModelWithId,
} from 'src/app/models/bedFacility/bed_facility.model.selector';
import {CoTreatingDoctorModel} from 'src/app/models/coTreatingDoctor/co_treating_doctor.model';
import * as coTreatingDoctorModelAction from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.action';
import {
	getCoTreatingDoctorCollectionModels, getCoTreatingDoctorModelWithId,
} from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.selector';
import {DiagnosesAndProceduresModel} from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import * as diagnosesAndProceduresModelAction from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.action';
import {
	getDiagnosesAndProceduresCollectionModels, getDiagnosesAndProceduresModelWithId,
} from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import {OperatingTheaterMedicalExaminationRecordModel} from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import * as operatingTheaterMedicalExaminationRecordModelAction from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.action';
import {
	getOperatingTheaterMedicalExaminationRecordCollectionModels, getOperatingTheaterMedicalExaminationRecordModelWithId,
} from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import {RoomFacilityModel} from 'src/app/models/roomFacility/room_facility.model';
import * as roomFacilityModelAction from 'src/app/models/roomFacility/room_facility.model.action';
import {
	getRoomFacilityCollectionModels, getRoomFacilityModelWithId,
} from 'src/app/models/roomFacility/room_facility.model.selector';
import {StaffModel} from 'src/app/models/staff/staff.model';
import * as staffModelAction from 'src/app/models/staff/staff.model.action';
import {
	getStaffCollectionModels, getStaffModelWithId,
} from 'src/app/models/staff/staff.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../preoperative-records-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-preoperative-records-crud-edit',
	templateUrl: './preoperative-records-crud-edit.component.html',
	styleUrls: [
		'./preoperative-records-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class PreoperativeRecordsCrudEditComponent
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
	collectionId: string = 'b791353d-6836-47b9-9ef5-9d4417e722c8';
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
	preoperativeRecordsAudits$: Observable<PreoperativeRecordsModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Operating Theater Medical Examination Record and Preoperative Records here] off begin
	operatingTheaterMedicalExaminationRecordMultiCrudActive: boolean = false;
	operatingTheaterMedicalExaminationRecordDisplayName = 'Operating Theater Medical Examination Record';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Operating Theater Medical Examination Record and Preoperative Records here] end
	operatingTheaterMedicalExaminationRecordOppositeRelation = 'preoperativeRecords';
	operatingTheaterMedicalExaminationRecordRelations: ModelRelation[] = this.operatingTheaterMedicalExaminationRecordMultiCrudActive ? OperatingTheaterMedicalExaminationRecordModel.getRelations()
		.map(relation => {
			if (relation.id === this.operatingTheaterMedicalExaminationRecordOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Anesthesia Medical Transcriber and Anesthesia Medical Transcriber here] off begin
	anesthesiaMedicalTranscriberMultiCrudActive: boolean = false;
	anesthesiaMedicalTranscriberDisplayName = 'Anesthesia Medical Transcriber';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Anesthesia Medical Transcriber and Anesthesia Medical Transcriber here] end
	anesthesiaMedicalTranscriberOppositeRelation = 'anesthesiaMedicalTranscriber';
	anesthesiaMedicalTranscriberRelations: ModelRelation[] = this.anesthesiaMedicalTranscriberMultiCrudActive ? StaffModel.getRelations()
		.map(relation => {
			if (relation.id === this.anesthesiaMedicalTranscriberOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Anesthesiologist and Anesthesiologist here] off begin
	anesthesiologistMultiCrudActive: boolean = false;
	anesthesiologistDisplayName = 'Anesthesiologist';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Anesthesiologist and Anesthesiologist here] end
	anesthesiologistOppositeRelation = 'anesthesiologist';
	anesthesiologistRelations: ModelRelation[] = this.anesthesiologistMultiCrudActive ? StaffModel.getRelations()
		.map(relation => {
			if (relation.id === this.anesthesiologistOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Anesthesiology Nurse and Anesthesiology Nurse here] off begin
	anesthesiologyNurseMultiCrudActive: boolean = false;
	anesthesiologyNurseDisplayName = 'Anesthesiology Nurse';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Anesthesiology Nurse and Anesthesiology Nurse here] end
	anesthesiologyNurseOppositeRelation = 'anesthesiologyNurse';
	anesthesiologyNurseRelations: ModelRelation[] = this.anesthesiologyNurseMultiCrudActive ? StaffModel.getRelations()
		.map(relation => {
			if (relation.id === this.anesthesiologyNurseOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Pre Surgery ICD 10 and Pre Surgery ICD 10 here] off begin
	preSurgeryICD10MultiCrudActive: boolean = false;
	preSurgeryICD10DisplayName = 'Pre Surgery ICD 10';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Pre Surgery ICD 10 and Pre Surgery ICD 10 here] end
	preSurgeryICD10OppositeRelation = 'preSurgeryICD10';
	preSurgeryICD10Relations: ModelRelation[] = this.preSurgeryICD10MultiCrudActive ? DiagnosesAndProceduresModel.getRelations()
		.map(relation => {
			if (relation.id === this.preSurgeryICD10OppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Pre Surgery ICD 9 CM and Pre Surgery ICD 9 CM here] off begin
	preSurgeryICD9CMMultiCrudActive: boolean = false;
	preSurgeryICD9CMDisplayName = 'Pre Surgery ICD 9 CM';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Pre Surgery ICD 9 CM and Pre Surgery ICD 9 CM here] end
	preSurgeryICD9CMOppositeRelation = 'preSurgeryICD9CM';
	preSurgeryICD9CMRelations: ModelRelation[] = this.preSurgeryICD9CMMultiCrudActive ? DiagnosesAndProceduresModel.getRelations()
		.map(relation => {
			if (relation.id === this.preSurgeryICD9CMOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Preoperative Rooms and Preoperative Rooms here] off begin
	preoperativeRoomsMultiCrudActive: boolean = false;
	preoperativeRoomsDisplayName = 'Preoperative Rooms';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Preoperative Rooms and Preoperative Rooms here] end
	preoperativeRoomsOppositeRelation = 'preoperativeRooms';
	preoperativeRoomsRelations: ModelRelation[] = this.preoperativeRoomsMultiCrudActive ? RoomFacilityModel.getRelations()
		.map(relation => {
			if (relation.id === this.preoperativeRoomsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Surgeon and Surgeon here] off begin
	surgeonMultiCrudActive: boolean = false;
	surgeonDisplayName = 'Surgeon';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Surgeon and Surgeon here] end
	surgeonOppositeRelation = 'surgeon';
	surgeonRelations: ModelRelation[] = this.surgeonMultiCrudActive ? StaffModel.getRelations()
		.map(relation => {
			if (relation.id === this.surgeonOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Surgical Medical Transcriber and Surgical Medical Transcriber here] off begin
	surgicalMedicalTranscriberMultiCrudActive: boolean = false;
	surgicalMedicalTranscriberDisplayName = 'Surgical Medical Transcriber';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Surgical Medical Transcriber and Surgical Medical Transcriber here] end
	surgicalMedicalTranscriberOppositeRelation = 'surgicalMedicalTranscriber';
	surgicalMedicalTranscriberRelations: ModelRelation[] = this.surgicalMedicalTranscriberMultiCrudActive ? StaffModel.getRelations()
		.map(relation => {
			if (relation.id === this.surgicalMedicalTranscriberOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Surgical Nurse and Surgical Nurse here] off begin
	surgicalNurseMultiCrudActive: boolean = false;
	surgicalNurseDisplayName = 'Surgical Nurse';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Surgical Nurse and Surgical Nurse here] end
	surgicalNurseOppositeRelation = 'surgicalNurse';
	surgicalNurseRelations: ModelRelation[] = this.surgicalNurseMultiCrudActive ? StaffModel.getRelations()
		.map(relation => {
			if (relation.id === this.surgicalNurseOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Additional Anesthesiologist and Additional Anesthesiologists here] off begin
	additionalAnesthesiologistsMultiCrudActive: boolean = false;
	additionalAnesthesiologistsDisplayName = 'Additional Anesthesiologists';
	additionalAnesthesiologistsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Additional Anesthesiologist and Additional Anesthesiologists here] end
	additionalAnesthesiologistsOppositeRelation = 'additionalAnesthesiologist';
	additionalAnesthesiologistsRelations: ModelRelation[] = this.additionalAnesthesiologistsMultiCrudActive ? CoTreatingDoctorModel.getRelations()
		.map(relation => {
			if (relation.id === this.additionalAnesthesiologistsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Additional Surgery Nurse and Additional Surgery Nurses here] off begin
	additionalSurgeryNursesMultiCrudActive: boolean = false;
	additionalSurgeryNursesDisplayName = 'Additional Surgery Nurses';
	additionalSurgeryNursesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Additional Surgery Nurse and Additional Surgery Nurses here] end
	additionalSurgeryNursesOppositeRelation = 'additionalSurgeryNurse';
	additionalSurgeryNursesRelations: ModelRelation[] = this.additionalSurgeryNursesMultiCrudActive ? CoTreatingDoctorModel.getRelations()
		.map(relation => {
			if (relation.id === this.additionalSurgeryNursesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Preoperative Records and Bed Facilities here] off begin
	bedFacilitiesMultiCrudActive: boolean = false;
	bedFacilitiesDisplayName = 'Bed Facilities';
	bedFacilitiesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Preoperative Records and Bed Facilities here] end
	bedFacilitiesOppositeRelation = 'preoperativeRecords';
	bedFacilitiesRelations: ModelRelation[] = this.bedFacilitiesMultiCrudActive ? BedFacilityModel.getRelations()
		.map(relation => {
			if (relation.id === this.bedFacilitiesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Co Treating Anesthesiologist and Co Treating Anesthesiologists here] off begin
	coTreatingAnesthesiologistsMultiCrudActive: boolean = false;
	coTreatingAnesthesiologistsDisplayName = 'Co Treating Anesthesiologists';
	coTreatingAnesthesiologistsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Co Treating Anesthesiologist and Co Treating Anesthesiologists here] end
	coTreatingAnesthesiologistsOppositeRelation = 'coTreatingAnesthesiologist';
	coTreatingAnesthesiologistsRelations: ModelRelation[] = this.coTreatingAnesthesiologistsMultiCrudActive ? CoTreatingDoctorModel.getRelations()
		.map(relation => {
			if (relation.id === this.coTreatingAnesthesiologistsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Co Treating Surgeon and Co Treating Surgeons here] off begin
	coTreatingSurgeonsMultiCrudActive: boolean = false;
	coTreatingSurgeonsDisplayName = 'Co Treating Surgeons';
	coTreatingSurgeonsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Co Treating Surgeon and Co Treating Surgeons here] end
	coTreatingSurgeonsOppositeRelation = 'coTreatingSurgeon';
	coTreatingSurgeonsRelations: ModelRelation[] = this.coTreatingSurgeonsMultiCrudActive ? CoTreatingDoctorModel.getRelations()
		.map(relation => {
			if (relation.id === this.coTreatingSurgeonsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = PreoperativeRecordsModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = PreoperativeRecordsModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = PreoperativeRecordsModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'operatingTheaterMedicalExaminationRecord' && this.operatingTheaterMedicalExaminationRecordMultiCrudActive) {
					exp.fields = OperatingTheaterMedicalExaminationRecordModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'anesthesiaMedicalTranscriber' && this.anesthesiaMedicalTranscriberMultiCrudActive) {
					exp.fields = StaffModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'anesthesiologist' && this.anesthesiologistMultiCrudActive) {
					exp.fields = StaffModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'anesthesiologyNurse' && this.anesthesiologyNurseMultiCrudActive) {
					exp.fields = StaffModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'preSurgeryICD10' && this.preSurgeryICD10MultiCrudActive) {
					exp.fields = DiagnosesAndProceduresModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'preSurgeryICD9CM' && this.preSurgeryICD9CMMultiCrudActive) {
					exp.fields = DiagnosesAndProceduresModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'preoperativeRooms' && this.preoperativeRoomsMultiCrudActive) {
					exp.fields = RoomFacilityModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'surgeon' && this.surgeonMultiCrudActive) {
					exp.fields = StaffModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'surgicalMedicalTranscriber' && this.surgicalMedicalTranscriberMultiCrudActive) {
					exp.fields = StaffModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'surgicalNurse' && this.surgicalNurseMultiCrudActive) {
					exp.fields = StaffModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'additionalAnesthesiologists' && this.additionalAnesthesiologistsMultiCrudActive) {
					exp.fields = CoTreatingDoctorModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'additionalSurgeryNurses' && this.additionalSurgeryNursesMultiCrudActive) {
					exp.fields = CoTreatingDoctorModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bedFacilities' && this.bedFacilitiesMultiCrudActive) {
					exp.fields = BedFacilityModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'coTreatingAnesthesiologists' && this.coTreatingAnesthesiologistsMultiCrudActive) {
					exp.fields = CoTreatingDoctorModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'coTreatingSurgeons' && this.coTreatingSurgeonsMultiCrudActive) {
					exp.fields = CoTreatingDoctorModel.getProps().map(prop => {
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
	targetModel: PreoperativeRecordsModel;

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
		private readonly store: Store<{ model: PreoperativeRecordsModelState }>,
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
		this.creationNavigationSubscription$.add(this.store.select(getCountPreoperativeRecordsModels).subscribe(count => {
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

			this.targetModel = new PreoperativeRecordsModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.preoperativeRecordsAudits$ = this.store.select(getPreoperativeRecordsModelAuditsByEntityId, this.targetModelId);
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
		const stateConfig: PassableStateConfig<PreoperativeRecordsModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.PreoperativeRecordsAction(
			modelAction.PreoperativeRecordsModelActionTypes.FETCH_PREOPERATIVE_RECORDS,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getPreoperativeRecordsModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new PreoperativeRecordsModel(model);
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
				commands.push('preoperative-records');
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

		this.store.dispatch(new modelAction.PreoperativeRecordsAction(
			modelAction.PreoperativeRecordsModelActionTypes.FETCH_PREOPERATIVE_RECORDS_AUDITS_BY_ENTITY_ID,
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
			let stateConfig: PassableStateConfig<PreoperativeRecordsModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.operatingTheaterMedicalExaminationRecordMultiCrudActive || this.anesthesiaMedicalTranscriberMultiCrudActive || this.anesthesiologistMultiCrudActive || this.anesthesiologyNurseMultiCrudActive || this.preSurgeryICD10MultiCrudActive || this.preSurgeryICD9CMMultiCrudActive || this.preoperativeRoomsMultiCrudActive || this.surgeonMultiCrudActive || this.surgicalMedicalTranscriberMultiCrudActive || this.surgicalNurseMultiCrudActive || this.additionalAnesthesiologistsMultiCrudActive || this.additionalSurgeryNursesMultiCrudActive || this.bedFacilitiesMultiCrudActive || this.coTreatingAnesthesiologistsMultiCrudActive || this.coTreatingSurgeonsMultiCrudActive,
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
					new modelAction.PreoperativeRecordsAction(
						modelAction.PreoperativeRecordsModelActionTypes.COUNT_PREOPERATIVE_RECORDSS,
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

			this.store.dispatch(new modelAction.PreoperativeRecordsAction(
				modelAction.PreoperativeRecordsModelActionTypes.CREATE_PREOPERATIVE_RECORDS,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<PreoperativeRecordsModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.operatingTheaterMedicalExaminationRecordMultiCrudActive || this.anesthesiaMedicalTranscriberMultiCrudActive || this.anesthesiologistMultiCrudActive || this.anesthesiologyNurseMultiCrudActive || this.preSurgeryICD10MultiCrudActive || this.preSurgeryICD9CMMultiCrudActive || this.preoperativeRoomsMultiCrudActive || this.surgeonMultiCrudActive || this.surgicalMedicalTranscriberMultiCrudActive || this.surgicalNurseMultiCrudActive || this.additionalAnesthesiologistsMultiCrudActive || this.additionalSurgeryNursesMultiCrudActive || this.bedFacilitiesMultiCrudActive || this.coTreatingAnesthesiologistsMultiCrudActive || this.coTreatingSurgeonsMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.PreoperativeRecordsAction(
					modelAction.PreoperativeRecordsModelActionTypes.FETCH_PREOPERATIVE_RECORDS,
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

			this.store.dispatch(new modelAction.PreoperativeRecordsAction(
				modelAction.PreoperativeRecordsModelActionTypes.UPDATE_PREOPERATIVE_RECORDS,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: PreoperativeRecordsModel = new PreoperativeRecordsModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getPreoperativeRecordsModelWithId, this.targetModelId).subscribe(model => {
					let differences = new PreoperativeRecordsModel(model).difference(updatedModel);

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
			if (event.entityName === this.operatingTheaterMedicalExaminationRecordDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(OperatingTheaterMedicalExaminationRecordModel.getProps(), this.operatingTheaterMedicalExaminationRecordRelations, this.isViewOnly),
					new OperatingTheaterMedicalExaminationRecordModel(),
					OperatingTheaterMedicalExaminationRecordModel,
					this.operatingTheaterMedicalExaminationRecordDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.operatingTheaterMedicalExaminationRecordRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.anesthesiaMedicalTranscriberDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.anesthesiaMedicalTranscriberRelations, this.isViewOnly),
					new StaffModel(),
					StaffModel,
					this.anesthesiaMedicalTranscriberDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.anesthesiaMedicalTranscriberRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.anesthesiologistDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.anesthesiologistRelations, this.isViewOnly),
					new StaffModel(),
					StaffModel,
					this.anesthesiologistDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.anesthesiologistRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.anesthesiologyNurseDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.anesthesiologyNurseRelations, this.isViewOnly),
					new StaffModel(),
					StaffModel,
					this.anesthesiologyNurseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.anesthesiologyNurseRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.preSurgeryICD10DisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosesAndProceduresModel.getProps(), this.preSurgeryICD10Relations, this.isViewOnly),
					new DiagnosesAndProceduresModel(),
					DiagnosesAndProceduresModel,
					this.preSurgeryICD10DisplayName,
					this.modelProperties,
					this.modelRelations,
					this.preSurgeryICD10Relations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.preSurgeryICD9CMDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosesAndProceduresModel.getProps(), this.preSurgeryICD9CMRelations, this.isViewOnly),
					new DiagnosesAndProceduresModel(),
					DiagnosesAndProceduresModel,
					this.preSurgeryICD9CMDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.preSurgeryICD9CMRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.preoperativeRoomsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RoomFacilityModel.getProps(), this.preoperativeRoomsRelations, this.isViewOnly),
					new RoomFacilityModel(),
					RoomFacilityModel,
					this.preoperativeRoomsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.preoperativeRoomsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.surgeonDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.surgeonRelations, this.isViewOnly),
					new StaffModel(),
					StaffModel,
					this.surgeonDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.surgeonRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.surgicalMedicalTranscriberDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.surgicalMedicalTranscriberRelations, this.isViewOnly),
					new StaffModel(),
					StaffModel,
					this.surgicalMedicalTranscriberDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.surgicalMedicalTranscriberRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.surgicalNurseDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.surgicalNurseRelations, this.isViewOnly),
					new StaffModel(),
					StaffModel,
					this.surgicalNurseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.surgicalNurseRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.additionalAnesthesiologistsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CoTreatingDoctorModel.getProps(), this.additionalAnesthesiologistsRelations, this.isViewOnly),
					new CoTreatingDoctorModel(),
					CoTreatingDoctorModel,
					this.additionalAnesthesiologistsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.additionalAnesthesiologistsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.additionalSurgeryNursesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CoTreatingDoctorModel.getProps(), this.additionalSurgeryNursesRelations, this.isViewOnly),
					new CoTreatingDoctorModel(),
					CoTreatingDoctorModel,
					this.additionalSurgeryNursesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.additionalSurgeryNursesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bedFacilitiesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BedFacilityModel.getProps(), this.bedFacilitiesRelations, this.isViewOnly),
					new BedFacilityModel(),
					BedFacilityModel,
					this.bedFacilitiesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bedFacilitiesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.coTreatingAnesthesiologistsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CoTreatingDoctorModel.getProps(), this.coTreatingAnesthesiologistsRelations, this.isViewOnly),
					new CoTreatingDoctorModel(),
					CoTreatingDoctorModel,
					this.coTreatingAnesthesiologistsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.coTreatingAnesthesiologistsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.coTreatingSurgeonsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CoTreatingDoctorModel.getProps(), this.coTreatingSurgeonsRelations, this.isViewOnly),
					new CoTreatingDoctorModel(),
					CoTreatingDoctorModel,
					this.coTreatingSurgeonsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.coTreatingSurgeonsRelations,
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
		this.modelProperties = PreoperativeRecordsModel.getProps();
		this.modelRelations = PreoperativeRecordsModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'operatingTheaterMedicalExaminationRecord';
		}).hideElement = this.operatingTheaterMedicalExaminationRecordMultiCrudActive || this.modelRelations.find(rel => rel.id === 'operatingTheaterMedicalExaminationRecord').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'anesthesiaMedicalTranscriber';
		}).hideElement = this.anesthesiaMedicalTranscriberMultiCrudActive || this.modelRelations.find(rel => rel.id === 'anesthesiaMedicalTranscriber').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'anesthesiologist';
		}).hideElement = this.anesthesiologistMultiCrudActive || this.modelRelations.find(rel => rel.id === 'anesthesiologist').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'anesthesiologyNurse';
		}).hideElement = this.anesthesiologyNurseMultiCrudActive || this.modelRelations.find(rel => rel.id === 'anesthesiologyNurse').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'preSurgeryICD10';
		}).hideElement = this.preSurgeryICD10MultiCrudActive || this.modelRelations.find(rel => rel.id === 'preSurgeryICD10').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'preSurgeryICD9CM';
		}).hideElement = this.preSurgeryICD9CMMultiCrudActive || this.modelRelations.find(rel => rel.id === 'preSurgeryICD9CM').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'preoperativeRooms';
		}).hideElement = this.preoperativeRoomsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'preoperativeRooms').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'surgeon';
		}).hideElement = this.surgeonMultiCrudActive || this.modelRelations.find(rel => rel.id === 'surgeon').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'surgicalMedicalTranscriber';
		}).hideElement = this.surgicalMedicalTranscriberMultiCrudActive || this.modelRelations.find(rel => rel.id === 'surgicalMedicalTranscriber').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'surgicalNurse';
		}).hideElement = this.surgicalNurseMultiCrudActive || this.modelRelations.find(rel => rel.id === 'surgicalNurse').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'additionalAnesthesiologists';
		}).hideElement = this.additionalAnesthesiologistsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'additionalAnesthesiologists').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'additionalSurgeryNurses';
		}).hideElement = this.additionalSurgeryNursesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'additionalSurgeryNurses').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bedFacilities';
		}).hideElement = this.bedFacilitiesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bedFacilities').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'coTreatingAnesthesiologists';
		}).hideElement = this.coTreatingAnesthesiologistsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'coTreatingAnesthesiologists').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'coTreatingSurgeons';
		}).hideElement = this.coTreatingSurgeonsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'coTreatingSurgeons').hideElement;

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
		if (this.operatingTheaterMedicalExaminationRecordMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.operatingTheaterMedicalExaminationRecordDisplayName, many: false});
		}

		if (this.anesthesiaMedicalTranscriberMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.anesthesiaMedicalTranscriberDisplayName, many: false});
		}

		if (this.anesthesiologistMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.anesthesiologistDisplayName, many: false});
		}

		if (this.anesthesiologyNurseMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.anesthesiologyNurseDisplayName, many: false});
		}

		if (this.preSurgeryICD10MultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.preSurgeryICD10DisplayName, many: false});
		}

		if (this.preSurgeryICD9CMMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.preSurgeryICD9CMDisplayName, many: false});
		}

		if (this.preoperativeRoomsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.preoperativeRoomsDisplayName, many: false});
		}

		if (this.surgeonMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.surgeonDisplayName, many: false});
		}

		if (this.surgicalMedicalTranscriberMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.surgicalMedicalTranscriberDisplayName, many: false});
		}

		if (this.surgicalNurseMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.surgicalNurseDisplayName, many: false});
		}

		if (this.additionalAnesthesiologistsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.additionalAnesthesiologistsDisplayName, many: true});
			this.store.dispatch(new coTreatingDoctorModelAction.CoTreatingDoctorAction(
				coTreatingDoctorModelAction.CoTreatingDoctorModelActionTypes.INITIALISE_CO_TREATING_DOCTOR_COLLECTION_STATE,
				{
					collectionId: this.additionalAnesthesiologistsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getCoTreatingDoctorCollectionModels, this.additionalAnesthesiologistsCollectionId).subscribe(models => {
				models.forEach(additionalAnesthesiologists => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(CoTreatingDoctorModel.getProps(), this.additionalAnesthesiologistsRelations, this.isViewOnly),
						additionalAnesthesiologists,
						CoTreatingDoctorModel,
						this.additionalAnesthesiologistsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.additionalAnesthesiologistsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.additionalSurgeryNursesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.additionalSurgeryNursesDisplayName, many: true});
			this.store.dispatch(new coTreatingDoctorModelAction.CoTreatingDoctorAction(
				coTreatingDoctorModelAction.CoTreatingDoctorModelActionTypes.INITIALISE_CO_TREATING_DOCTOR_COLLECTION_STATE,
				{
					collectionId: this.additionalSurgeryNursesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getCoTreatingDoctorCollectionModels, this.additionalSurgeryNursesCollectionId).subscribe(models => {
				models.forEach(additionalSurgeryNurses => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(CoTreatingDoctorModel.getProps(), this.additionalSurgeryNursesRelations, this.isViewOnly),
						additionalSurgeryNurses,
						CoTreatingDoctorModel,
						this.additionalSurgeryNursesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.additionalSurgeryNursesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.bedFacilitiesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bedFacilitiesDisplayName, many: true});
			this.store.dispatch(new bedFacilityModelAction.BedFacilityAction(
				bedFacilityModelAction.BedFacilityModelActionTypes.INITIALISE_BED_FACILITY_COLLECTION_STATE,
				{
					collectionId: this.bedFacilitiesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBedFacilityCollectionModels, this.bedFacilitiesCollectionId).subscribe(models => {
				models.forEach(bedFacilities => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BedFacilityModel.getProps(), this.bedFacilitiesRelations, this.isViewOnly),
						bedFacilities,
						BedFacilityModel,
						this.bedFacilitiesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bedFacilitiesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.coTreatingAnesthesiologistsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.coTreatingAnesthesiologistsDisplayName, many: true});
			this.store.dispatch(new coTreatingDoctorModelAction.CoTreatingDoctorAction(
				coTreatingDoctorModelAction.CoTreatingDoctorModelActionTypes.INITIALISE_CO_TREATING_DOCTOR_COLLECTION_STATE,
				{
					collectionId: this.coTreatingAnesthesiologistsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getCoTreatingDoctorCollectionModels, this.coTreatingAnesthesiologistsCollectionId).subscribe(models => {
				models.forEach(coTreatingAnesthesiologists => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(CoTreatingDoctorModel.getProps(), this.coTreatingAnesthesiologistsRelations, this.isViewOnly),
						coTreatingAnesthesiologists,
						CoTreatingDoctorModel,
						this.coTreatingAnesthesiologistsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.coTreatingAnesthesiologistsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.coTreatingSurgeonsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.coTreatingSurgeonsDisplayName, many: true});
			this.store.dispatch(new coTreatingDoctorModelAction.CoTreatingDoctorAction(
				coTreatingDoctorModelAction.CoTreatingDoctorModelActionTypes.INITIALISE_CO_TREATING_DOCTOR_COLLECTION_STATE,
				{
					collectionId: this.coTreatingSurgeonsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getCoTreatingDoctorCollectionModels, this.coTreatingSurgeonsCollectionId).subscribe(models => {
				models.forEach(coTreatingSurgeons => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(CoTreatingDoctorModel.getProps(), this.coTreatingSurgeonsRelations, this.isViewOnly),
						coTreatingSurgeons,
						CoTreatingDoctorModel,
						this.coTreatingSurgeonsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.coTreatingSurgeonsRelations,
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
		if (this.targetModel.operatingTheaterMedicalExaminationRecord && this.targetModel.operatingTheaterMedicalExaminationRecord.id && this.operatingTheaterMedicalExaminationRecordMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				OperatingTheaterMedicalExaminationRecordModel,
				this.operatingTheaterMedicalExaminationRecordOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.operatingTheaterMedicalExaminationRecord.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getOperatingTheaterMedicalExaminationRecordModelWithId, this.targetModel.operatingTheaterMedicalExaminationRecordId).subscribe(operatingTheaterMedicalExaminationRecord => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(OperatingTheaterMedicalExaminationRecordModel.getProps(), this.operatingTheaterMedicalExaminationRecordRelations, this.isViewOnly),
					operatingTheaterMedicalExaminationRecord,
					OperatingTheaterMedicalExaminationRecordModel,
					this.operatingTheaterMedicalExaminationRecordDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.operatingTheaterMedicalExaminationRecordRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.anesthesiaMedicalTranscriber && this.targetModel.anesthesiaMedicalTranscriber.id && this.anesthesiaMedicalTranscriberMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StaffModel,
				this.anesthesiaMedicalTranscriberOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.anesthesiaMedicalTranscriber.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getStaffModelWithId, this.targetModel.anesthesiaMedicalTranscriberId).subscribe(anesthesiaMedicalTranscriber => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.anesthesiaMedicalTranscriberRelations, this.isViewOnly),
					anesthesiaMedicalTranscriber,
					StaffModel,
					this.anesthesiaMedicalTranscriberDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.anesthesiaMedicalTranscriberRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.anesthesiologist && this.targetModel.anesthesiologist.id && this.anesthesiologistMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StaffModel,
				this.anesthesiologistOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.anesthesiologist.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getStaffModelWithId, this.targetModel.anesthesiologistId).subscribe(anesthesiologist => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.anesthesiologistRelations, this.isViewOnly),
					anesthesiologist,
					StaffModel,
					this.anesthesiologistDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.anesthesiologistRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.anesthesiologyNurse && this.targetModel.anesthesiologyNurse.id && this.anesthesiologyNurseMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StaffModel,
				this.anesthesiologyNurseOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.anesthesiologyNurse.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getStaffModelWithId, this.targetModel.anesthesiologyNurseId).subscribe(anesthesiologyNurse => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.anesthesiologyNurseRelations, this.isViewOnly),
					anesthesiologyNurse,
					StaffModel,
					this.anesthesiologyNurseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.anesthesiologyNurseRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.preSurgeryICD10 && this.targetModel.preSurgeryICD10.id && this.preSurgeryICD10MultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DiagnosesAndProceduresModel,
				this.preSurgeryICD10OppositeRelation,
				this.collectionId,
				1,
				this.targetModel.preSurgeryICD10.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getDiagnosesAndProceduresModelWithId, this.targetModel.preSurgeryICD10Id).subscribe(preSurgeryICD10 => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosesAndProceduresModel.getProps(), this.preSurgeryICD10Relations, this.isViewOnly),
					preSurgeryICD10,
					DiagnosesAndProceduresModel,
					this.preSurgeryICD10DisplayName,
					this.modelProperties,
					this.modelRelations,
					this.preSurgeryICD10Relations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.preSurgeryICD9CM && this.targetModel.preSurgeryICD9CM.id && this.preSurgeryICD9CMMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DiagnosesAndProceduresModel,
				this.preSurgeryICD9CMOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.preSurgeryICD9CM.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getDiagnosesAndProceduresModelWithId, this.targetModel.preSurgeryICD9CMId).subscribe(preSurgeryICD9CM => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosesAndProceduresModel.getProps(), this.preSurgeryICD9CMRelations, this.isViewOnly),
					preSurgeryICD9CM,
					DiagnosesAndProceduresModel,
					this.preSurgeryICD9CMDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.preSurgeryICD9CMRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.preoperativeRooms && this.targetModel.preoperativeRooms.id && this.preoperativeRoomsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RoomFacilityModel,
				this.preoperativeRoomsOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.preoperativeRooms.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getRoomFacilityModelWithId, this.targetModel.preoperativeRoomsId).subscribe(preoperativeRooms => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RoomFacilityModel.getProps(), this.preoperativeRoomsRelations, this.isViewOnly),
					preoperativeRooms,
					RoomFacilityModel,
					this.preoperativeRoomsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.preoperativeRoomsRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.surgeon && this.targetModel.surgeon.id && this.surgeonMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StaffModel,
				this.surgeonOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.surgeon.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getStaffModelWithId, this.targetModel.surgeonId).subscribe(surgeon => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.surgeonRelations, this.isViewOnly),
					surgeon,
					StaffModel,
					this.surgeonDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.surgeonRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.surgicalMedicalTranscriber && this.targetModel.surgicalMedicalTranscriber.id && this.surgicalMedicalTranscriberMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StaffModel,
				this.surgicalMedicalTranscriberOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.surgicalMedicalTranscriber.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getStaffModelWithId, this.targetModel.surgicalMedicalTranscriberId).subscribe(surgicalMedicalTranscriber => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.surgicalMedicalTranscriberRelations, this.isViewOnly),
					surgicalMedicalTranscriber,
					StaffModel,
					this.surgicalMedicalTranscriberDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.surgicalMedicalTranscriberRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.surgicalNurse && this.targetModel.surgicalNurse.id && this.surgicalNurseMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StaffModel,
				this.surgicalNurseOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.surgicalNurse.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getStaffModelWithId, this.targetModel.surgicalNurseId).subscribe(surgicalNurse => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.surgicalNurseRelations, this.isViewOnly),
					surgicalNurse,
					StaffModel,
					this.surgicalNurseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.surgicalNurseRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.additionalAnesthesiologistsIds && this.targetModel.additionalAnesthesiologistsIds.length > 0 && this.additionalAnesthesiologistsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				CoTreatingDoctorModel,
				this.additionalAnesthesiologistsOppositeRelation,
				this.additionalAnesthesiologistsCollectionId,
				this.targetModel.additionalAnesthesiologistsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.additionalSurgeryNursesIds && this.targetModel.additionalSurgeryNursesIds.length > 0 && this.additionalSurgeryNursesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				CoTreatingDoctorModel,
				this.additionalSurgeryNursesOppositeRelation,
				this.additionalSurgeryNursesCollectionId,
				this.targetModel.additionalSurgeryNursesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.bedFacilitiesIds && this.targetModel.bedFacilitiesIds.length > 0 && this.bedFacilitiesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BedFacilityModel,
				this.bedFacilitiesOppositeRelation,
				this.bedFacilitiesCollectionId,
				this.targetModel.bedFacilitiesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.coTreatingAnesthesiologistsIds && this.targetModel.coTreatingAnesthesiologistsIds.length > 0 && this.coTreatingAnesthesiologistsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				CoTreatingDoctorModel,
				this.coTreatingAnesthesiologistsOppositeRelation,
				this.coTreatingAnesthesiologistsCollectionId,
				this.targetModel.coTreatingAnesthesiologistsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.coTreatingSurgeonsIds && this.targetModel.coTreatingSurgeonsIds.length > 0 && this.coTreatingSurgeonsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				CoTreatingDoctorModel,
				this.coTreatingSurgeonsOppositeRelation,
				this.coTreatingSurgeonsCollectionId,
				this.targetModel.coTreatingSurgeonsIds.length,
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
	addAdditionalEntitiesToModel(model: PreoperativeRecordsModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): PreoperativeRecordsModel {
		let updatedModel: PreoperativeRecordsModel = new PreoperativeRecordsModel(model);

		if (this.operatingTheaterMedicalExaminationRecordMultiCrudActive) {
			updatedModel.operatingTheaterMedicalExaminationRecord = event.additionalEntities.operatingTheaterMedicalExaminationRecord ? event.additionalEntities.operatingTheaterMedicalExaminationRecord : undefined;

			if (!updatedModel.operatingTheaterMedicalExaminationRecord && event.payload) {
				event.payload.operatingTheaterMedicalExaminationRecordId = null;
			}
		} else if (event.payload?.operatingTheaterMedicalExaminationRecordId !== undefined) {
			event.payload.operatingTheaterMedicalExaminationRecord = null;
			updatedModel.operatingTheaterMedicalExaminationRecord = null;
		}

		if (this.anesthesiaMedicalTranscriberMultiCrudActive) {
			updatedModel.anesthesiaMedicalTranscriber = event.additionalEntities.anesthesiaMedicalTranscriber ? event.additionalEntities.anesthesiaMedicalTranscriber : undefined;

			if (!updatedModel.anesthesiaMedicalTranscriber && event.payload) {
				event.payload.anesthesiaMedicalTranscriberId = null;
			}
		} else if (event.payload?.anesthesiaMedicalTranscriberId !== undefined) {
			event.payload.anesthesiaMedicalTranscriber = null;
			updatedModel.anesthesiaMedicalTranscriber = null;
		}

		if (this.anesthesiologistMultiCrudActive) {
			updatedModel.anesthesiologist = event.additionalEntities.anesthesiologist ? event.additionalEntities.anesthesiologist : undefined;

			if (!updatedModel.anesthesiologist && event.payload) {
				event.payload.anesthesiologistId = null;
			}
		} else if (event.payload?.anesthesiologistId !== undefined) {
			event.payload.anesthesiologist = null;
			updatedModel.anesthesiologist = null;
		}

		if (this.anesthesiologyNurseMultiCrudActive) {
			updatedModel.anesthesiologyNurse = event.additionalEntities.anesthesiologyNurse ? event.additionalEntities.anesthesiologyNurse : undefined;

			if (!updatedModel.anesthesiologyNurse && event.payload) {
				event.payload.anesthesiologyNurseId = null;
			}
		} else if (event.payload?.anesthesiologyNurseId !== undefined) {
			event.payload.anesthesiologyNurse = null;
			updatedModel.anesthesiologyNurse = null;
		}

		if (this.preSurgeryICD10MultiCrudActive) {
			updatedModel.preSurgeryICD10 = event.additionalEntities.preSurgeryICD10 ? event.additionalEntities.preSurgeryICD10 : undefined;

			if (!updatedModel.preSurgeryICD10 && event.payload) {
				event.payload.preSurgeryICD10Id = null;
			}
		} else if (event.payload?.preSurgeryICD10Id !== undefined) {
			event.payload.preSurgeryICD10 = null;
			updatedModel.preSurgeryICD10 = null;
		}

		if (this.preSurgeryICD9CMMultiCrudActive) {
			updatedModel.preSurgeryICD9CM = event.additionalEntities.preSurgeryICD9CM ? event.additionalEntities.preSurgeryICD9CM : undefined;

			if (!updatedModel.preSurgeryICD9CM && event.payload) {
				event.payload.preSurgeryICD9CMId = null;
			}
		} else if (event.payload?.preSurgeryICD9CMId !== undefined) {
			event.payload.preSurgeryICD9CM = null;
			updatedModel.preSurgeryICD9CM = null;
		}

		if (this.preoperativeRoomsMultiCrudActive) {
			updatedModel.preoperativeRooms = event.additionalEntities.preoperativeRooms ? event.additionalEntities.preoperativeRooms : undefined;

			if (!updatedModel.preoperativeRooms && event.payload) {
				event.payload.preoperativeRoomsId = null;
			}
		} else if (event.payload?.preoperativeRoomsId !== undefined) {
			event.payload.preoperativeRooms = null;
			updatedModel.preoperativeRooms = null;
		}

		if (this.surgeonMultiCrudActive) {
			updatedModel.surgeon = event.additionalEntities.surgeon ? event.additionalEntities.surgeon : undefined;

			if (!updatedModel.surgeon && event.payload) {
				event.payload.surgeonId = null;
			}
		} else if (event.payload?.surgeonId !== undefined) {
			event.payload.surgeon = null;
			updatedModel.surgeon = null;
		}

		if (this.surgicalMedicalTranscriberMultiCrudActive) {
			updatedModel.surgicalMedicalTranscriber = event.additionalEntities.surgicalMedicalTranscriber ? event.additionalEntities.surgicalMedicalTranscriber : undefined;

			if (!updatedModel.surgicalMedicalTranscriber && event.payload) {
				event.payload.surgicalMedicalTranscriberId = null;
			}
		} else if (event.payload?.surgicalMedicalTranscriberId !== undefined) {
			event.payload.surgicalMedicalTranscriber = null;
			updatedModel.surgicalMedicalTranscriber = null;
		}

		if (this.surgicalNurseMultiCrudActive) {
			updatedModel.surgicalNurse = event.additionalEntities.surgicalNurse ? event.additionalEntities.surgicalNurse : undefined;

			if (!updatedModel.surgicalNurse && event.payload) {
				event.payload.surgicalNurseId = null;
			}
		} else if (event.payload?.surgicalNurseId !== undefined) {
			event.payload.surgicalNurse = null;
			updatedModel.surgicalNurse = null;
		}

		updatedModel.additionalAnesthesiologists = [];
		if (this.additionalAnesthesiologistsMultiCrudActive) {
			if (event.additionalEntities.additionalAnesthesiologists) {
				event.additionalEntities.additionalAnesthesiologists.forEach(entity => {
					updatedModel.additionalAnesthesiologists.push(entity);
				});
			}

			if (!updatedModel.additionalAnesthesiologists.length) {
				updatedModel.additionalAnesthesiologistsIds = [];
			}
		}
		updatedModel.additionalSurgeryNurses = [];
		if (this.additionalSurgeryNursesMultiCrudActive) {
			if (event.additionalEntities.additionalSurgeryNurses) {
				event.additionalEntities.additionalSurgeryNurses.forEach(entity => {
					updatedModel.additionalSurgeryNurses.push(entity);
				});
			}

			if (!updatedModel.additionalSurgeryNurses.length) {
				updatedModel.additionalSurgeryNursesIds = [];
			}
		}
		updatedModel.bedFacilities = [];
		if (this.bedFacilitiesMultiCrudActive) {
			if (event.additionalEntities.bedFacilities) {
				event.additionalEntities.bedFacilities.forEach(entity => {
					updatedModel.bedFacilities.push(entity);
				});
			}

			if (!updatedModel.bedFacilities.length) {
				updatedModel.bedFacilitiesIds = [];
			}
		}
		updatedModel.coTreatingAnesthesiologists = [];
		if (this.coTreatingAnesthesiologistsMultiCrudActive) {
			if (event.additionalEntities.coTreatingAnesthesiologists) {
				event.additionalEntities.coTreatingAnesthesiologists.forEach(entity => {
					updatedModel.coTreatingAnesthesiologists.push(entity);
				});
			}

			if (!updatedModel.coTreatingAnesthesiologists.length) {
				updatedModel.coTreatingAnesthesiologistsIds = [];
			}
		}
		updatedModel.coTreatingSurgeons = [];
		if (this.coTreatingSurgeonsMultiCrudActive) {
			if (event.additionalEntities.coTreatingSurgeons) {
				event.additionalEntities.coTreatingSurgeons.forEach(entity => {
					updatedModel.coTreatingSurgeons.push(entity);
				});
			}

			if (!updatedModel.coTreatingSurgeons.length) {
				updatedModel.coTreatingSurgeonsIds = [];
			}
		}
		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
