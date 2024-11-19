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
	getBpjsVisitDataCollectionModels,
	getCountBpjsVisitDataModels,
	getBpjsVisitDataModelWithId
} from 'src/app/models/bpjsVisitData/bpjs_visit_data.model.selector';
import { BpjsVisitDataCrudModule } from '../bpjs-visit-data-crud.module';
import { BpjsVisitDataCrudEditComponent } from './bpjs-visit-data-crud-edit.component';
import {
	BpjsVisitDataModelState,
	initialState as initialBpjsVisitDataModelState
} from 'src/app/models/bpjsVisitData/bpjs_visit_data.model.state';
import { BpjsVisitDataDataFactory } from 'src/app/lib/utils/factories/bpjs-visit-data-data-factory';
import { BpjsVisitDataModel } from 'src/app/models/bpjsVisitData/bpjs_visit_data.model';
import { CrudTileMode } from '../bpjs-visit-data-crud.component';
import { getBpjsPcareRegistrationsModelWithId } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { getBpjsPcareRegistrationsCollectionModels } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { BpjsPcareRegistrationsModel } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model';
import { BpjsPcareRegistrationsDataFactory } from 'src/app/lib/utils/factories/bpjs-pcare-registrations-data-factory';
import { getBpjsPcarePendaftaranModelWithId } from 'src/app/models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model.selector';
import { getBpjsPcarePendaftaranCollectionModels } from 'src/app/models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model.selector';
import { BpjsPcarePendaftaranModel } from 'src/app/models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model';
import { BpjsPcarePendaftaranDataFactory } from 'src/app/lib/utils/factories/bpjs-pcare-pendaftaran-data-factory';
import { getInvoiceModelWithId } from 'src/app/models/invoice/invoice.model.selector';
import { getInvoiceCollectionModels } from 'src/app/models/invoice/invoice.model.selector';
import { InvoiceModel } from 'src/app/models/invoice/invoice.model';
import { InvoiceDataFactory } from 'src/app/lib/utils/factories/invoice-data-factory';
import { getPatientGeneralInfoModelWithId } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { getPatientGeneralInfoCollectionModels } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { PatientGeneralInfoModel } from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import { PatientGeneralInfoDataFactory } from 'src/app/lib/utils/factories/patient-general-info-data-factory';
import { getPatientVisitModelWithId } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { getPatientVisitCollectionModels } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { PatientVisitModel } from 'src/app/models/patientVisit/patient_visit.model';
import { PatientVisitDataFactory } from 'src/app/lib/utils/factories/patient-visit-data-factory';
import { getPatientVisitPatientPaymentInsuranceModelWithId } from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.selector';
import { getPatientVisitPatientPaymentInsuranceCollectionModels } from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.selector';
import { PatientVisitPatientPaymentInsuranceModel } from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model';
import { PatientVisitPatientPaymentInsuranceDataFactory } from 'src/app/lib/utils/factories/patient-visit-patient-payment-insurance-data-factory';
import { getPatientVisitPatientPaymentOthersModelWithId } from 'src/app/models/patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model.selector';
import { getPatientVisitPatientPaymentOthersCollectionModels } from 'src/app/models/patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model.selector';
import { PatientVisitPatientPaymentOthersModel } from 'src/app/models/patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model';
import { PatientVisitPatientPaymentOthersDataFactory } from 'src/app/lib/utils/factories/patient-visit-patient-payment-others-data-factory';
import { getPatientVisitPaymentSelfPayingModelWithId } from 'src/app/models/patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model.selector';
import { getPatientVisitPaymentSelfPayingCollectionModels } from 'src/app/models/patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model.selector';
import { PatientVisitPaymentSelfPayingModel } from 'src/app/models/patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model';
import { PatientVisitPaymentSelfPayingDataFactory } from 'src/app/lib/utils/factories/patient-visit-payment-self-paying-data-factory';
import { getRegistrationModelWithId } from 'src/app/models/registration/registration.model.selector';
import { getRegistrationCollectionModels } from 'src/app/models/registration/registration.model.selector';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { RegistrationDataFactory } from 'src/app/lib/utils/factories/registration-data-factory';

describe('BPJS Visit Data CRUD Edit component tests', () => {
	let fixture: ComponentFixture<BpjsVisitDataCrudEditComponent>
	let component: BpjsVisitDataCrudEditComponent;

	let bpjsVisitDataModelState: BpjsVisitDataModelState;

	let store: MockStore<{ model: BpjsVisitDataModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let bpjsVisitDataCountBehaviorSubject: BehaviorSubject<number>;
	let bpjsVisitDataModelsBehaviorSubject: BehaviorSubject<BpjsVisitDataModel[]>;
	let bpjsPcareRegistrationsModelsBehaviorSubject: BehaviorSubject<BpjsPcareRegistrationsModel[]>;
	let bpjsPcarePendaftaranModelsBehaviorSubject: BehaviorSubject<BpjsPcarePendaftaranModel[]>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let patientVisitModelsBehaviorSubject: BehaviorSubject<PatientVisitModel[]>;
	let patientVisitPatientPaymentInsuranceModelsBehaviorSubject: BehaviorSubject<PatientVisitPatientPaymentInsuranceModel[]>;
	let patientVisitPatientPaymentOthersModelsBehaviorSubject: BehaviorSubject<PatientVisitPatientPaymentOthersModel[]>;
	let patientVisitPaymentSelfPayingModelsBehaviorSubject: BehaviorSubject<PatientVisitPaymentSelfPayingModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;

	const bpjsVisitDataFactory: BpjsVisitDataDataFactory = new BpjsVisitDataDataFactory();
	const defaultBpjsVisitDataCount: number = 10;
	const defaultBpjsVisitDataEntities: BpjsVisitDataModel[] = bpjsVisitDataFactory.createAll(defaultBpjsVisitDataCount);

	const bpjsPcareRegistrationsFactory: BpjsPcareRegistrationsDataFactory = new BpjsPcareRegistrationsDataFactory();
	const defaultBpjsPcareRegistrationsCount: number = 10;
	const defaultBpjsPcareRegistrationsEntities: BpjsPcareRegistrationsModel[] = bpjsPcareRegistrationsFactory.createAll(defaultBpjsPcareRegistrationsCount);

	const bpjsPcarePendaftaranFactory: BpjsPcarePendaftaranDataFactory = new BpjsPcarePendaftaranDataFactory();
	const defaultBpjsPcarePendaftaranCount: number = 10;
	const defaultBpjsPcarePendaftaranEntities: BpjsPcarePendaftaranModel[] = bpjsPcarePendaftaranFactory.createAll(defaultBpjsPcarePendaftaranCount);

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

	const patientVisitFactory: PatientVisitDataFactory = new PatientVisitDataFactory();
	const defaultPatientVisitCount: number = 10;
	const defaultPatientVisitEntities: PatientVisitModel[] = patientVisitFactory.createAll(defaultPatientVisitCount);

	const patientVisitPatientPaymentInsuranceFactory: PatientVisitPatientPaymentInsuranceDataFactory = new PatientVisitPatientPaymentInsuranceDataFactory();
	const defaultPatientVisitPatientPaymentInsuranceCount: number = 10;
	const defaultPatientVisitPatientPaymentInsuranceEntities: PatientVisitPatientPaymentInsuranceModel[] = patientVisitPatientPaymentInsuranceFactory.createAll(defaultPatientVisitPatientPaymentInsuranceCount);

	const patientVisitPatientPaymentOthersFactory: PatientVisitPatientPaymentOthersDataFactory = new PatientVisitPatientPaymentOthersDataFactory();
	const defaultPatientVisitPatientPaymentOthersCount: number = 10;
	const defaultPatientVisitPatientPaymentOthersEntities: PatientVisitPatientPaymentOthersModel[] = patientVisitPatientPaymentOthersFactory.createAll(defaultPatientVisitPatientPaymentOthersCount);

	const patientVisitPaymentSelfPayingFactory: PatientVisitPaymentSelfPayingDataFactory = new PatientVisitPaymentSelfPayingDataFactory();
	const defaultPatientVisitPaymentSelfPayingCount: number = 10;
	const defaultPatientVisitPaymentSelfPayingEntities: PatientVisitPaymentSelfPayingModel[] = patientVisitPaymentSelfPayingFactory.createAll(defaultPatientVisitPaymentSelfPayingCount);

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let bpjsVisitDataWithId: BpjsVisitDataModel = defaultBpjsVisitDataEntities[0];
	let bpjsVisitDataModelWithIdBehaviorSubject: BehaviorSubject<BpjsVisitDataModel>;

	bpjsVisitDataWithId.patientVisit = defaultPatientVisitEntities[0];
	bpjsVisitDataWithId.patientVisitId = bpjsVisitDataWithId.patientVisit.id;
	let patientVisitWithIdBehaviorSubject: BehaviorSubject<PatientVisitModel>;


	const routerState: RouterState = {
		url: 'bpjs-visit-data-crud',
		urls: ['bpjs-visit-data-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: BpjsVisitDataModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		bpjsVisitDataModelState = initialBpjsVisitDataModelState;
		store.setState({model: bpjsVisitDataModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		bpjsVisitDataCountBehaviorSubject = new BehaviorSubject(defaultBpjsVisitDataCount);

		// selectors for all references
		bpjsVisitDataModelsBehaviorSubject = new BehaviorSubject(defaultBpjsVisitDataEntities);
		bpjsPcareRegistrationsModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcareRegistrationsEntities);
		bpjsPcarePendaftaranModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcarePendaftaranEntities);
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		patientVisitModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitEntities);
		patientVisitPatientPaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitPatientPaymentInsuranceEntities);
		patientVisitPatientPaymentOthersModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitPatientPaymentOthersEntities);
		patientVisitPaymentSelfPayingModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitPaymentSelfPayingEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);

		// selectors for target entity and its related entity
		bpjsVisitDataModelWithIdBehaviorSubject = new BehaviorSubject(bpjsVisitDataWithId);
		patientVisitWithIdBehaviorSubject = new BehaviorSubject(bpjsVisitDataWithId.patientVisit);

		spyOn(store, 'select')
			.withArgs(getCountBpjsVisitDataModels).and.returnValue(bpjsVisitDataCountBehaviorSubject)
			.withArgs(getBpjsVisitDataModelWithId, bpjsVisitDataWithId.id).and.returnValue(bpjsVisitDataModelWithIdBehaviorSubject)
			.withArgs(getBpjsVisitDataCollectionModels, jasmine.any(String)).and.returnValue(bpjsVisitDataModelsBehaviorSubject)
			.withArgs(getBpjsPcareRegistrationsCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcareRegistrationsModelsBehaviorSubject)
			.withArgs(getBpjsPcarePendaftaranCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcarePendaftaranModelsBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getPatientVisitCollectionModels, jasmine.any(String)).and.returnValue(patientVisitModelsBehaviorSubject)
			.withArgs(getPatientVisitPatientPaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(patientVisitPatientPaymentInsuranceModelsBehaviorSubject)
			.withArgs(getPatientVisitPatientPaymentOthersCollectionModels, jasmine.any(String)).and.returnValue(patientVisitPatientPaymentOthersModelsBehaviorSubject)
			.withArgs(getPatientVisitPaymentSelfPayingCollectionModels, jasmine.any(String)).and.returnValue(patientVisitPaymentSelfPayingModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getPatientVisitModelWithId, bpjsVisitDataWithId.patientVisitId).and.returnValue(patientVisitWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				BpjsVisitDataCrudModule,
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

			fixture = TestBed.createComponent(BpjsVisitDataCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new BpjsVisitDataModel();
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
	it ('Renders the BPJS Visit Data CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Patient Visit relation.
	*
	* The button should only exist if patientVisitMultiCrudActive is true
	*/
	it ('Renders Patient Visit Add Entity button in create mode', fakeAsync(() => {
		const patientVisitButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVisitDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientVisitButton).toEqual(component.patientVisitMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Visit', fakeAsync(() => {
		const patientVisitButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVisitDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientVisitButton).toEqual(component.patientVisitMultiCrudActive);

		if (component.patientVisitMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientVisitRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVisitDisplayName + ' from Model')).length;

			patientVisitButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientVisitRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVisitDisplayName + ' from Model')).length;

			expect(actualPatientVisitRemoveButtonCount).toEqual(initialPatientVisitRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Visit button', () => {
		const patientVisitButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVisitDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientVisitButton).toEqual(component.patientVisitMultiCrudActive);

		if (component.patientVisitMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientVisitButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientVisitRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVisitDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientVisitRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientVisitRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVisitDisplayName + ' from Model'));

			expect(actualPatientVisitRemoveButtons.length).toEqual(initialPatientVisitRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient Visit button when one has already been added', () => {

		const patientVisitButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVisitDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientVisitButton).toEqual(component.patientVisitMultiCrudActive);

		if (component.patientVisitMultiCrudActive) {
			patientVisitButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientVisitButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVisitDisplayName + ' to Model'));

			expect(updatedpatientVisitButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient Visit entities from model when loading in edit mode', () => {
		component.targetModel = bpjsVisitDataWithId;
		component.targetModelId = bpjsVisitDataWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientVisitMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientVisitRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVisitDisplayName + ' from Model')).length;

			expect(patientVisitRemoveButtonCount).toEqual(1);
		}
	});

});
