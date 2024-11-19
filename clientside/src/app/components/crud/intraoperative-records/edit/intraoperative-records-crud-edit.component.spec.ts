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

import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { By } from '@angular/platform-browser';
import { ComponentFixture, TestBed, waitForAsync, fakeAsync } from '@angular/core/testing';
import { CookieService } from 'ngx-cookie-service';
import { DebugElement } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { Store } from '@ngrx/store';
import { MockStore, provideMockStore } from '@ngrx/store/testing';
import { ModalDialogService, ModalDialogInstanceService } from '@preeco-privacy/ngx-modal-dialog';
import { ActivatedRouteStub } from 'src/testing/helpers/activated-route-stub';
import { CommonComponentModule } from 'src/app/lib/components/common.component.module';
import { getRouterState } from 'src/app/models/model.selector';
import { RouterState } from 'src/app/models/model.state';
import { 
	getIntraoperativeRecordsCollectionModels,
	getCountIntraoperativeRecordsModels,
	getIntraoperativeRecordsModelWithId
} from 'src/app/models/intraoperativeRecords/intraoperative_records.model.selector';
import { IntraoperativeRecordsCrudModule } from '../intraoperative-records-crud.module';
import { IntraoperativeRecordsCrudEditComponent } from './intraoperative-records-crud-edit.component';
import {
	IntraoperativeRecordsModelState,
	initialState as initialIntraoperativeRecordsModelState
} from 'src/app/models/intraoperativeRecords/intraoperative_records.model.state';
import { IntraoperativeRecordsDataFactory } from 'src/app/lib/utils/factories/intraoperative-records-data-factory';
import { IntraoperativeRecordsModel } from 'src/app/models/intraoperativeRecords/intraoperative_records.model';
import { CrudTileMode } from '../intraoperative-records-crud.component';
import { getBedFacilityModelWithId } from 'src/app/models/bedFacility/bed_facility.model.selector';
import { getBedFacilityCollectionModels } from 'src/app/models/bedFacility/bed_facility.model.selector';
import { BedFacilityModel } from 'src/app/models/bedFacility/bed_facility.model';
import { BedFacilityDataFactory } from 'src/app/lib/utils/factories/bed-facility-data-factory';
import { getBedReserveModelWithId } from 'src/app/models/bedReserve/bed_reserve.model.selector';
import { getBedReserveCollectionModels } from 'src/app/models/bedReserve/bed_reserve.model.selector';
import { BedReserveModel } from 'src/app/models/bedReserve/bed_reserve.model';
import { BedReserveDataFactory } from 'src/app/lib/utils/factories/bed-reserve-data-factory';
import { getDiagnosisNandaModelWithId } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model.selector';
import { getDiagnosisNandaCollectionModels } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model.selector';
import { DiagnosisNandaModel } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model';
import { DiagnosisNandaDataFactory } from 'src/app/lib/utils/factories/diagnosis-nanda-data-factory';
import { getInpatientMedicalExaminationRecordModelWithId } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.selector';
import { getInpatientMedicalExaminationRecordCollectionModels } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.selector';
import { InpatientMedicalExaminationRecordModel } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model';
import { InpatientMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/inpatient-medical-examination-record-data-factory';
import { getInvoiceModelWithId } from 'src/app/models/invoice/invoice.model.selector';
import { getInvoiceCollectionModels } from 'src/app/models/invoice/invoice.model.selector';
import { InvoiceModel } from 'src/app/models/invoice/invoice.model';
import { InvoiceDataFactory } from 'src/app/lib/utils/factories/invoice-data-factory';
import { getMedicalExaminationRecordModelWithId } from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.selector';
import { getMedicalExaminationRecordCollectionModels } from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.selector';
import { MedicalExaminationRecordModel } from 'src/app/models/medicalExaminationRecord/medical_examination_record.model';
import { MedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/medical-examination-record-data-factory';
import { getOperatingTheaterMedicalExaminationRecordModelWithId } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import { getOperatingTheaterMedicalExaminationRecordCollectionModels } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import { OperatingTheaterMedicalExaminationRecordModel } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import { OperatingTheaterMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/operating-theater-medical-examination-record-data-factory';
import { getPostOperativeDetailsModelWithId } from 'src/app/models/postOperativeDetails/post_operative_details.model.selector';
import { getPostOperativeDetailsCollectionModels } from 'src/app/models/postOperativeDetails/post_operative_details.model.selector';
import { PostOperativeDetailsModel } from 'src/app/models/postOperativeDetails/post_operative_details.model';
import { PostOperativeDetailsDataFactory } from 'src/app/lib/utils/factories/post-operative-details-data-factory';
import { getPreoperativeRecordsModelWithId } from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import { getPreoperativeRecordsCollectionModels } from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import { PreoperativeRecordsModel } from 'src/app/models/preoperativeRecords/preoperative_records.model';
import { PreoperativeRecordsDataFactory } from 'src/app/lib/utils/factories/preoperative-records-data-factory';
import { getRegistrationModelWithId } from 'src/app/models/registration/registration.model.selector';
import { getRegistrationCollectionModels } from 'src/app/models/registration/registration.model.selector';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { RegistrationDataFactory } from 'src/app/lib/utils/factories/registration-data-factory';
import { getRoomFacilityModelWithId } from 'src/app/models/roomFacility/room_facility.model.selector';
import { getRoomFacilityCollectionModels } from 'src/app/models/roomFacility/room_facility.model.selector';
import { RoomFacilityModel } from 'src/app/models/roomFacility/room_facility.model';
import { RoomFacilityDataFactory } from 'src/app/lib/utils/factories/room-facility-data-factory';
import { getRoomTransferModelWithId } from 'src/app/models/roomTransfer/room_transfer.model.selector';
import { getRoomTransferCollectionModels } from 'src/app/models/roomTransfer/room_transfer.model.selector';
import { RoomTransferModel } from 'src/app/models/roomTransfer/room_transfer.model';
import { RoomTransferDataFactory } from 'src/app/lib/utils/factories/room-transfer-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';

describe('Intraoperative Records CRUD Edit component tests', () => {
	let fixture: ComponentFixture<IntraoperativeRecordsCrudEditComponent>
	let component: IntraoperativeRecordsCrudEditComponent;

	let intraoperativeRecordsModelState: IntraoperativeRecordsModelState;

	let store: MockStore<{ model: IntraoperativeRecordsModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let intraoperativeRecordsCountBehaviorSubject: BehaviorSubject<number>;
	let intraoperativeRecordsModelsBehaviorSubject: BehaviorSubject<IntraoperativeRecordsModel[]>;
	let bedFacilityModelsBehaviorSubject: BehaviorSubject<BedFacilityModel[]>;
	let bedReserveModelsBehaviorSubject: BehaviorSubject<BedReserveModel[]>;
	let diagnosisNandaModelsBehaviorSubject: BehaviorSubject<DiagnosisNandaModel[]>;
	let inpatientMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<InpatientMedicalExaminationRecordModel[]>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let medicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<MedicalExaminationRecordModel[]>;
	let operatingTheaterMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<OperatingTheaterMedicalExaminationRecordModel[]>;
	let postOperativeDetailsModelsBehaviorSubject: BehaviorSubject<PostOperativeDetailsModel[]>;
	let preoperativeRecordsModelsBehaviorSubject: BehaviorSubject<PreoperativeRecordsModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let roomFacilityModelsBehaviorSubject: BehaviorSubject<RoomFacilityModel[]>;
	let roomTransferModelsBehaviorSubject: BehaviorSubject<RoomTransferModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;

	const intraoperativeRecordsFactory: IntraoperativeRecordsDataFactory = new IntraoperativeRecordsDataFactory();
	const defaultIntraoperativeRecordsCount: number = 10;
	const defaultIntraoperativeRecordsEntities: IntraoperativeRecordsModel[] = intraoperativeRecordsFactory.createAll(defaultIntraoperativeRecordsCount);

	const bedFacilityFactory: BedFacilityDataFactory = new BedFacilityDataFactory();
	const defaultBedFacilityCount: number = 10;
	const defaultBedFacilityEntities: BedFacilityModel[] = bedFacilityFactory.createAll(defaultBedFacilityCount);

	const bedReserveFactory: BedReserveDataFactory = new BedReserveDataFactory();
	const defaultBedReserveCount: number = 10;
	const defaultBedReserveEntities: BedReserveModel[] = bedReserveFactory.createAll(defaultBedReserveCount);

	const diagnosisNandaFactory: DiagnosisNandaDataFactory = new DiagnosisNandaDataFactory();
	const defaultDiagnosisNandaCount: number = 10;
	const defaultDiagnosisNandaEntities: DiagnosisNandaModel[] = diagnosisNandaFactory.createAll(defaultDiagnosisNandaCount);

	const inpatientMedicalExaminationRecordFactory: InpatientMedicalExaminationRecordDataFactory = new InpatientMedicalExaminationRecordDataFactory();
	const defaultInpatientMedicalExaminationRecordCount: number = 10;
	const defaultInpatientMedicalExaminationRecordEntities: InpatientMedicalExaminationRecordModel[] = inpatientMedicalExaminationRecordFactory.createAll(defaultInpatientMedicalExaminationRecordCount);

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

	const medicalExaminationRecordFactory: MedicalExaminationRecordDataFactory = new MedicalExaminationRecordDataFactory();
	const defaultMedicalExaminationRecordCount: number = 10;
	const defaultMedicalExaminationRecordEntities: MedicalExaminationRecordModel[] = medicalExaminationRecordFactory.createAll(defaultMedicalExaminationRecordCount);

	const operatingTheaterMedicalExaminationRecordFactory: OperatingTheaterMedicalExaminationRecordDataFactory = new OperatingTheaterMedicalExaminationRecordDataFactory();
	const defaultOperatingTheaterMedicalExaminationRecordCount: number = 10;
	const defaultOperatingTheaterMedicalExaminationRecordEntities: OperatingTheaterMedicalExaminationRecordModel[] = operatingTheaterMedicalExaminationRecordFactory.createAll(defaultOperatingTheaterMedicalExaminationRecordCount);

	const postOperativeDetailsFactory: PostOperativeDetailsDataFactory = new PostOperativeDetailsDataFactory();
	const defaultPostOperativeDetailsCount: number = 10;
	const defaultPostOperativeDetailsEntities: PostOperativeDetailsModel[] = postOperativeDetailsFactory.createAll(defaultPostOperativeDetailsCount);

	const preoperativeRecordsFactory: PreoperativeRecordsDataFactory = new PreoperativeRecordsDataFactory();
	const defaultPreoperativeRecordsCount: number = 10;
	const defaultPreoperativeRecordsEntities: PreoperativeRecordsModel[] = preoperativeRecordsFactory.createAll(defaultPreoperativeRecordsCount);

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);

	const roomFacilityFactory: RoomFacilityDataFactory = new RoomFacilityDataFactory();
	const defaultRoomFacilityCount: number = 10;
	const defaultRoomFacilityEntities: RoomFacilityModel[] = roomFacilityFactory.createAll(defaultRoomFacilityCount);

	const roomTransferFactory: RoomTransferDataFactory = new RoomTransferDataFactory();
	const defaultRoomTransferCount: number = 10;
	const defaultRoomTransferEntities: RoomTransferModel[] = roomTransferFactory.createAll(defaultRoomTransferCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let intraoperativeRecordsWithId: IntraoperativeRecordsModel = defaultIntraoperativeRecordsEntities[0];
	let intraoperativeRecordsModelWithIdBehaviorSubject: BehaviorSubject<IntraoperativeRecordsModel>;

	intraoperativeRecordsWithId.operatingTheaterMedicalExaminationRecord = defaultOperatingTheaterMedicalExaminationRecordEntities[0];
	intraoperativeRecordsWithId.operatingTheaterMedicalExaminationRecordId = intraoperativeRecordsWithId.operatingTheaterMedicalExaminationRecord.id;
	let operatingTheaterMedicalExaminationRecordWithIdBehaviorSubject: BehaviorSubject<OperatingTheaterMedicalExaminationRecordModel>;

	intraoperativeRecordsWithId.operatingRoom = defaultRoomFacilityEntities[0];
	intraoperativeRecordsWithId.operatingRoomId = intraoperativeRecordsWithId.operatingRoom.id;
	let operatingRoomWithIdBehaviorSubject: BehaviorSubject<RoomFacilityModel>;

	intraoperativeRecordsWithId.bedFacilities = defaultBedFacilityEntities;
	intraoperativeRecordsWithId.bedFacilitiesIds = intraoperativeRecordsWithId.bedFacilities.map(bedFacilities => bedFacilities.id);


	const routerState: RouterState = {
		url: 'intraoperative-records-crud',
		urls: ['intraoperative-records-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: IntraoperativeRecordsModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		intraoperativeRecordsModelState = initialIntraoperativeRecordsModelState;
		store.setState({model: intraoperativeRecordsModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		intraoperativeRecordsCountBehaviorSubject = new BehaviorSubject(defaultIntraoperativeRecordsCount);

		// selectors for all references
		intraoperativeRecordsModelsBehaviorSubject = new BehaviorSubject(defaultIntraoperativeRecordsEntities);
		bedFacilityModelsBehaviorSubject = new BehaviorSubject(defaultBedFacilityEntities);
		bedReserveModelsBehaviorSubject = new BehaviorSubject(defaultBedReserveEntities);
		diagnosisNandaModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosisNandaEntities);
		inpatientMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultInpatientMedicalExaminationRecordEntities);
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		medicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultMedicalExaminationRecordEntities);
		operatingTheaterMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultOperatingTheaterMedicalExaminationRecordEntities);
		postOperativeDetailsModelsBehaviorSubject = new BehaviorSubject(defaultPostOperativeDetailsEntities);
		preoperativeRecordsModelsBehaviorSubject = new BehaviorSubject(defaultPreoperativeRecordsEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		roomFacilityModelsBehaviorSubject = new BehaviorSubject(defaultRoomFacilityEntities);
		roomTransferModelsBehaviorSubject = new BehaviorSubject(defaultRoomTransferEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);

		// selectors for target entity and its related entity
		intraoperativeRecordsModelWithIdBehaviorSubject = new BehaviorSubject(intraoperativeRecordsWithId);
		operatingTheaterMedicalExaminationRecordWithIdBehaviorSubject = new BehaviorSubject(intraoperativeRecordsWithId.operatingTheaterMedicalExaminationRecord);
		operatingRoomWithIdBehaviorSubject = new BehaviorSubject(intraoperativeRecordsWithId.operatingRoom);

		spyOn(store, 'select')
			.withArgs(getCountIntraoperativeRecordsModels).and.returnValue(intraoperativeRecordsCountBehaviorSubject)
			.withArgs(getIntraoperativeRecordsModelWithId, intraoperativeRecordsWithId.id).and.returnValue(intraoperativeRecordsModelWithIdBehaviorSubject)
			.withArgs(getIntraoperativeRecordsCollectionModels, jasmine.any(String)).and.returnValue(intraoperativeRecordsModelsBehaviorSubject)
			.withArgs(getBedFacilityCollectionModels, jasmine.any(String)).and.returnValue(bedFacilityModelsBehaviorSubject)
			.withArgs(getBedReserveCollectionModels, jasmine.any(String)).and.returnValue(bedReserveModelsBehaviorSubject)
			.withArgs(getDiagnosisNandaCollectionModels, jasmine.any(String)).and.returnValue(diagnosisNandaModelsBehaviorSubject)
			.withArgs(getInpatientMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(inpatientMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(medicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getOperatingTheaterMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(operatingTheaterMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getPostOperativeDetailsCollectionModels, jasmine.any(String)).and.returnValue(postOperativeDetailsModelsBehaviorSubject)
			.withArgs(getPreoperativeRecordsCollectionModels, jasmine.any(String)).and.returnValue(preoperativeRecordsModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getRoomFacilityCollectionModels, jasmine.any(String)).and.returnValue(roomFacilityModelsBehaviorSubject)
			.withArgs(getRoomTransferCollectionModels, jasmine.any(String)).and.returnValue(roomTransferModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getOperatingTheaterMedicalExaminationRecordModelWithId, intraoperativeRecordsWithId.operatingTheaterMedicalExaminationRecordId).and.returnValue(operatingTheaterMedicalExaminationRecordWithIdBehaviorSubject)
			.withArgs(getRoomFacilityModelWithId, intraoperativeRecordsWithId.operatingRoomId).and.returnValue(operatingRoomWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				IntraoperativeRecordsCrudModule,
				CommonComponentModule,
				FormsModule,
				ReactiveFormsModule,
			],
			providers: [
				provideMockStore(),
				{
					provide: ActivatedRoute,
					useValue: activatedRouteStub,
				},
				CookieService,
				ModalDialogService,
				ModalDialogInstanceService,
			]
		}).compileComponents().then(() => {

			spySelectorsInStore();

			fixture = TestBed.createComponent(IntraoperativeRecordsCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new IntraoperativeRecordsModel();
			component.createReactiveForm();
			fixture.detectChanges();


		});
	}));

	afterEach(() => {
		// Need to do this since for some reason the last component queried from the fixture will be rendered on the
		// browser
		if (fixture.nativeElement instanceof HTMLElement) {
			(fixture.nativeElement as HTMLElement).remove();
		}
		component.ngOnDestroy();
	});

	/**
	 * Checks that the component is created by the test initialisation
	 */
	it ('Renders the Intraoperative Records CRUD Edit Component', () => {
		expect(component).toBeTruthy();
	});

	/**
	 * Checks that there are no add additional model buttons present in the component when in view mode.
	 *
	 * This test does not require checking whether multi crud is active for a given relation, as the expected outcome
	 * is identical for components with multi entity crud active and for components without it
	 */
	it ('Does not render any add entity buttons when in view mode', fakeAsync(() => {
		component.tileMode = CrudTileMode.View;
		fixture.detectChanges();

		const addEntityButtons: DebugElement[] = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'));

		expect(addEntityButtons.length).toEqual(0);
	}));

	/**
	* Checks that the status of the add model button matches the multi entity status for the Operating Theater Medical Examination Record relation.
	*
	* The button should only exist if operatingTheaterMedicalExaminationRecordMultiCrudActive is true
	*/
	it ('Renders Operating Theater Medical Examination Record Add Entity button in create mode', fakeAsync(() => {
		const operatingTheaterMedicalExaminationRecordButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.operatingTheaterMedicalExaminationRecordDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!operatingTheaterMedicalExaminationRecordButton).toEqual(component.operatingTheaterMedicalExaminationRecordMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Operating Theater Medical Examination Record', fakeAsync(() => {
		const operatingTheaterMedicalExaminationRecordButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.operatingTheaterMedicalExaminationRecordDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!operatingTheaterMedicalExaminationRecordButton).toEqual(component.operatingTheaterMedicalExaminationRecordMultiCrudActive);

		if (component.operatingTheaterMedicalExaminationRecordMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialOperatingTheaterMedicalExaminationRecordRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.operatingTheaterMedicalExaminationRecordDisplayName + ' from Model')).length;

			operatingTheaterMedicalExaminationRecordButton.nativeElement.click();
			fixture.detectChanges();

			const actualOperatingTheaterMedicalExaminationRecordRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.operatingTheaterMedicalExaminationRecordDisplayName + ' from Model')).length;

			expect(actualOperatingTheaterMedicalExaminationRecordRemoveButtonCount).toEqual(initialOperatingTheaterMedicalExaminationRecordRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Operating Theater Medical Examination Record button', () => {
		const operatingTheaterMedicalExaminationRecordButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.operatingTheaterMedicalExaminationRecordDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!operatingTheaterMedicalExaminationRecordButton).toEqual(component.operatingTheaterMedicalExaminationRecordMultiCrudActive);

		if (component.operatingTheaterMedicalExaminationRecordMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			operatingTheaterMedicalExaminationRecordButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialOperatingTheaterMedicalExaminationRecordRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.operatingTheaterMedicalExaminationRecordDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialOperatingTheaterMedicalExaminationRecordRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualOperatingTheaterMedicalExaminationRecordRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.operatingTheaterMedicalExaminationRecordDisplayName + ' from Model'));

			expect(actualOperatingTheaterMedicalExaminationRecordRemoveButtons.length).toEqual(initialOperatingTheaterMedicalExaminationRecordRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Operating Theater Medical Examination Record button when one has already been added', () => {

		const operatingTheaterMedicalExaminationRecordButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.operatingTheaterMedicalExaminationRecordDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!operatingTheaterMedicalExaminationRecordButton).toEqual(component.operatingTheaterMedicalExaminationRecordMultiCrudActive);

		if (component.operatingTheaterMedicalExaminationRecordMultiCrudActive) {
			operatingTheaterMedicalExaminationRecordButton.nativeElement.click();
			fixture.detectChanges();

			const updatedoperatingTheaterMedicalExaminationRecordButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.operatingTheaterMedicalExaminationRecordDisplayName + ' to Model'));

			expect(updatedoperatingTheaterMedicalExaminationRecordButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Operating Theater Medical Examination Record entities from model when loading in edit mode', () => {
		component.targetModel = intraoperativeRecordsWithId;
		component.targetModelId = intraoperativeRecordsWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.operatingTheaterMedicalExaminationRecordMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const operatingTheaterMedicalExaminationRecordRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.operatingTheaterMedicalExaminationRecordDisplayName + ' from Model')).length;

			expect(operatingTheaterMedicalExaminationRecordRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Operating Room relation.
	*
	* The button should only exist if operatingRoomMultiCrudActive is true
	*/
	it ('Renders Operating Room Add Entity button in create mode', fakeAsync(() => {
		const operatingRoomButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.operatingRoomDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!operatingRoomButton).toEqual(component.operatingRoomMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Operating Room', fakeAsync(() => {
		const operatingRoomButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.operatingRoomDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!operatingRoomButton).toEqual(component.operatingRoomMultiCrudActive);

		if (component.operatingRoomMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialOperatingRoomRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.operatingRoomDisplayName + ' from Model')).length;

			operatingRoomButton.nativeElement.click();
			fixture.detectChanges();

			const actualOperatingRoomRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.operatingRoomDisplayName + ' from Model')).length;

			expect(actualOperatingRoomRemoveButtonCount).toEqual(initialOperatingRoomRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Operating Room button', () => {
		const operatingRoomButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.operatingRoomDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!operatingRoomButton).toEqual(component.operatingRoomMultiCrudActive);

		if (component.operatingRoomMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			operatingRoomButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialOperatingRoomRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.operatingRoomDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialOperatingRoomRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualOperatingRoomRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.operatingRoomDisplayName + ' from Model'));

			expect(actualOperatingRoomRemoveButtons.length).toEqual(initialOperatingRoomRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Operating Room button when one has already been added', () => {

		const operatingRoomButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.operatingRoomDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!operatingRoomButton).toEqual(component.operatingRoomMultiCrudActive);

		if (component.operatingRoomMultiCrudActive) {
			operatingRoomButton.nativeElement.click();
			fixture.detectChanges();

			const updatedoperatingRoomButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.operatingRoomDisplayName + ' to Model'));

			expect(updatedoperatingRoomButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Operating Room entities from model when loading in edit mode', () => {
		component.targetModel = intraoperativeRecordsWithId;
		component.targetModelId = intraoperativeRecordsWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.operatingRoomMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const operatingRoomRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.operatingRoomDisplayName + ' from Model')).length;

			expect(operatingRoomRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Bed Facilities relation.
	*
	* The button should only exist if bedFacilitiesMultiCrudActive is true
	*/
	it ('Renders Bed Facilities Add Entity button in create mode', fakeAsync(() => {
		const bedFacilitiesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedFacilitiesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bedFacilitiesButton).toEqual(component.bedFacilitiesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Bed Facilities', fakeAsync(() => {
		const bedFacilitiesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedFacilitiesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bedFacilitiesButton).toEqual(component.bedFacilitiesMultiCrudActive);

		if (component.bedFacilitiesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBedFacilitiesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedFacilitiesDisplayName + ' from Model')).length;

			bedFacilitiesButton.nativeElement.click();
			fixture.detectChanges();

			const actualBedFacilitiesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedFacilitiesDisplayName + ' from Model')).length;

			expect(actualBedFacilitiesRemoveButtonCount).toEqual(initialBedFacilitiesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Bed Facilities button', () => {
		const bedFacilitiesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedFacilitiesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bedFacilitiesButton).toEqual(component.bedFacilitiesMultiCrudActive);

		if (component.bedFacilitiesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bedFacilitiesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBedFacilitiesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedFacilitiesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBedFacilitiesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBedFacilitiesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedFacilitiesDisplayName + ' from Model'));

			expect(actualBedFacilitiesRemoveButtons.length).toEqual(initialBedFacilitiesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Bed Facilities button when one has already been added', () => {

		const bedFacilitiesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedFacilitiesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bedFacilitiesButton).toEqual(component.bedFacilitiesMultiCrudActive);

		if (component.bedFacilitiesMultiCrudActive) {
			bedFacilitiesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbedFacilitiesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedFacilitiesDisplayName + ' to Model'));

			expect(updatedbedFacilitiesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Bed Facilities entities from model when loading in edit mode', () => {
		component.targetModel = intraoperativeRecordsWithId;
		component.targetModelId = intraoperativeRecordsWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bedFacilitiesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bedFacilitiesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedFacilitiesDisplayName + ' from Model')).length;

			expect(bedFacilitiesRemoveButtonCount).toEqual(intraoperativeRecordsWithId.bedFacilities.length);
		}
	});

});
