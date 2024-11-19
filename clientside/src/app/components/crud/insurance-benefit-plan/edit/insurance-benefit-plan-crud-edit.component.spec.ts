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
	getInsuranceBenefitPlanCollectionModels,
	getCountInsuranceBenefitPlanModels,
	getInsuranceBenefitPlanModelWithId
} from 'src/app/models/insuranceBenefitPlan/insurance_benefit_plan.model.selector';
import { InsuranceBenefitPlanCrudModule } from '../insurance-benefit-plan-crud.module';
import { InsuranceBenefitPlanCrudEditComponent } from './insurance-benefit-plan-crud-edit.component';
import {
	InsuranceBenefitPlanModelState,
	initialState as initialInsuranceBenefitPlanModelState
} from 'src/app/models/insuranceBenefitPlan/insurance_benefit_plan.model.state';
import { InsuranceBenefitPlanDataFactory } from 'src/app/lib/utils/factories/insurance-benefit-plan-data-factory';
import { InsuranceBenefitPlanModel } from 'src/app/models/insuranceBenefitPlan/insurance_benefit_plan.model';
import { CrudTileMode } from '../insurance-benefit-plan-crud.component';
import { getInsuranceProviderModelWithId } from 'src/app/models/insuranceProvider/insurance_provider.model.selector';
import { getInsuranceProviderCollectionModels } from 'src/app/models/insuranceProvider/insurance_provider.model.selector';
import { InsuranceProviderModel } from 'src/app/models/insuranceProvider/insurance_provider.model';
import { InsuranceProviderDataFactory } from 'src/app/lib/utils/factories/insurance-provider-data-factory';
import { getInvoiceModelWithId } from 'src/app/models/invoice/invoice.model.selector';
import { getInvoiceCollectionModels } from 'src/app/models/invoice/invoice.model.selector';
import { InvoiceModel } from 'src/app/models/invoice/invoice.model';
import { InvoiceDataFactory } from 'src/app/lib/utils/factories/invoice-data-factory';
import { getInvoicePaymentInsuranceModelWithId } from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model.selector';
import { getInvoicePaymentInsuranceCollectionModels } from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model.selector';
import { InvoicePaymentInsuranceModel } from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model';
import { InvoicePaymentInsuranceDataFactory } from 'src/app/lib/utils/factories/invoice-payment-insurance-data-factory';
import { getPatientGeneralInfoModelWithId } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { getPatientGeneralInfoCollectionModels } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { PatientGeneralInfoModel } from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import { PatientGeneralInfoDataFactory } from 'src/app/lib/utils/factories/patient-general-info-data-factory';
import { getPatientPaymentInsuranceModelWithId } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model.selector';
import { getPatientPaymentInsuranceCollectionModels } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model.selector';
import { PatientPaymentInsuranceModel } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model';
import { PatientPaymentInsuranceDataFactory } from 'src/app/lib/utils/factories/patient-payment-insurance-data-factory';
import { getPatientVisitModelWithId } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { getPatientVisitCollectionModels } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { PatientVisitModel } from 'src/app/models/patientVisit/patient_visit.model';
import { PatientVisitDataFactory } from 'src/app/lib/utils/factories/patient-visit-data-factory';
import { getPatientVisitPatientPaymentInsuranceModelWithId } from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.selector';
import { getPatientVisitPatientPaymentInsuranceCollectionModels } from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.selector';
import { PatientVisitPatientPaymentInsuranceModel } from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model';
import { PatientVisitPatientPaymentInsuranceDataFactory } from 'src/app/lib/utils/factories/patient-visit-patient-payment-insurance-data-factory';

describe('Insurance Benefit Plan CRUD Edit component tests', () => {
	let fixture: ComponentFixture<InsuranceBenefitPlanCrudEditComponent>
	let component: InsuranceBenefitPlanCrudEditComponent;

	let insuranceBenefitPlanModelState: InsuranceBenefitPlanModelState;

	let store: MockStore<{ model: InsuranceBenefitPlanModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let insuranceBenefitPlanCountBehaviorSubject: BehaviorSubject<number>;
	let insuranceBenefitPlanModelsBehaviorSubject: BehaviorSubject<InsuranceBenefitPlanModel[]>;
	let insuranceProviderModelsBehaviorSubject: BehaviorSubject<InsuranceProviderModel[]>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let invoicePaymentInsuranceModelsBehaviorSubject: BehaviorSubject<InvoicePaymentInsuranceModel[]>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let patientPaymentInsuranceModelsBehaviorSubject: BehaviorSubject<PatientPaymentInsuranceModel[]>;
	let patientVisitModelsBehaviorSubject: BehaviorSubject<PatientVisitModel[]>;
	let patientVisitPatientPaymentInsuranceModelsBehaviorSubject: BehaviorSubject<PatientVisitPatientPaymentInsuranceModel[]>;

	const insuranceBenefitPlanFactory: InsuranceBenefitPlanDataFactory = new InsuranceBenefitPlanDataFactory();
	const defaultInsuranceBenefitPlanCount: number = 10;
	const defaultInsuranceBenefitPlanEntities: InsuranceBenefitPlanModel[] = insuranceBenefitPlanFactory.createAll(defaultInsuranceBenefitPlanCount);

	const insuranceProviderFactory: InsuranceProviderDataFactory = new InsuranceProviderDataFactory();
	const defaultInsuranceProviderCount: number = 10;
	const defaultInsuranceProviderEntities: InsuranceProviderModel[] = insuranceProviderFactory.createAll(defaultInsuranceProviderCount);

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

	const invoicePaymentInsuranceFactory: InvoicePaymentInsuranceDataFactory = new InvoicePaymentInsuranceDataFactory();
	const defaultInvoicePaymentInsuranceCount: number = 10;
	const defaultInvoicePaymentInsuranceEntities: InvoicePaymentInsuranceModel[] = invoicePaymentInsuranceFactory.createAll(defaultInvoicePaymentInsuranceCount);

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

	const patientPaymentInsuranceFactory: PatientPaymentInsuranceDataFactory = new PatientPaymentInsuranceDataFactory();
	const defaultPatientPaymentInsuranceCount: number = 10;
	const defaultPatientPaymentInsuranceEntities: PatientPaymentInsuranceModel[] = patientPaymentInsuranceFactory.createAll(defaultPatientPaymentInsuranceCount);

	const patientVisitFactory: PatientVisitDataFactory = new PatientVisitDataFactory();
	const defaultPatientVisitCount: number = 10;
	const defaultPatientVisitEntities: PatientVisitModel[] = patientVisitFactory.createAll(defaultPatientVisitCount);

	const patientVisitPatientPaymentInsuranceFactory: PatientVisitPatientPaymentInsuranceDataFactory = new PatientVisitPatientPaymentInsuranceDataFactory();
	const defaultPatientVisitPatientPaymentInsuranceCount: number = 10;
	const defaultPatientVisitPatientPaymentInsuranceEntities: PatientVisitPatientPaymentInsuranceModel[] = patientVisitPatientPaymentInsuranceFactory.createAll(defaultPatientVisitPatientPaymentInsuranceCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let insuranceBenefitPlanWithId: InsuranceBenefitPlanModel = defaultInsuranceBenefitPlanEntities[0];
	let insuranceBenefitPlanModelWithIdBehaviorSubject: BehaviorSubject<InsuranceBenefitPlanModel>;

	insuranceBenefitPlanWithId.insuranceProvider = defaultInsuranceProviderEntities[0];
	insuranceBenefitPlanWithId.insuranceProviderId = insuranceBenefitPlanWithId.insuranceProvider.id;
	let insuranceProviderWithIdBehaviorSubject: BehaviorSubject<InsuranceProviderModel>;

	insuranceBenefitPlanWithId.invoicePaymentInsurances = defaultInvoicePaymentInsuranceEntities;
	insuranceBenefitPlanWithId.invoicePaymentInsurancesIds = insuranceBenefitPlanWithId.invoicePaymentInsurances.map(invoicePaymentInsurances => invoicePaymentInsurances.id);

	insuranceBenefitPlanWithId.patientPaymentInsurances = defaultPatientPaymentInsuranceEntities;
	insuranceBenefitPlanWithId.patientPaymentInsurancesIds = insuranceBenefitPlanWithId.patientPaymentInsurances.map(patientPaymentInsurances => patientPaymentInsurances.id);

	insuranceBenefitPlanWithId.patientVisitPatientPaymentInsurances = defaultPatientVisitPatientPaymentInsuranceEntities;
	insuranceBenefitPlanWithId.patientVisitPatientPaymentInsurancesIds = insuranceBenefitPlanWithId.patientVisitPatientPaymentInsurances.map(patientVisitPatientPaymentInsurances => patientVisitPatientPaymentInsurances.id);


	const routerState: RouterState = {
		url: 'insurance-benefit-plan-crud',
		urls: ['insurance-benefit-plan-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: InsuranceBenefitPlanModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		insuranceBenefitPlanModelState = initialInsuranceBenefitPlanModelState;
		store.setState({model: insuranceBenefitPlanModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		insuranceBenefitPlanCountBehaviorSubject = new BehaviorSubject(defaultInsuranceBenefitPlanCount);

		// selectors for all references
		insuranceBenefitPlanModelsBehaviorSubject = new BehaviorSubject(defaultInsuranceBenefitPlanEntities);
		insuranceProviderModelsBehaviorSubject = new BehaviorSubject(defaultInsuranceProviderEntities);
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		invoicePaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentInsuranceEntities);
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		patientPaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentInsuranceEntities);
		patientVisitModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitEntities);
		patientVisitPatientPaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitPatientPaymentInsuranceEntities);

		// selectors for target entity and its related entity
		insuranceBenefitPlanModelWithIdBehaviorSubject = new BehaviorSubject(insuranceBenefitPlanWithId);
		insuranceProviderWithIdBehaviorSubject = new BehaviorSubject(insuranceBenefitPlanWithId.insuranceProvider);

		spyOn(store, 'select')
			.withArgs(getCountInsuranceBenefitPlanModels).and.returnValue(insuranceBenefitPlanCountBehaviorSubject)
			.withArgs(getInsuranceBenefitPlanModelWithId, insuranceBenefitPlanWithId.id).and.returnValue(insuranceBenefitPlanModelWithIdBehaviorSubject)
			.withArgs(getInsuranceBenefitPlanCollectionModels, jasmine.any(String)).and.returnValue(insuranceBenefitPlanModelsBehaviorSubject)
			.withArgs(getInsuranceProviderCollectionModels, jasmine.any(String)).and.returnValue(insuranceProviderModelsBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getInvoicePaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentInsuranceModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getPatientPaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentInsuranceModelsBehaviorSubject)
			.withArgs(getPatientVisitCollectionModels, jasmine.any(String)).and.returnValue(patientVisitModelsBehaviorSubject)
			.withArgs(getPatientVisitPatientPaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(patientVisitPatientPaymentInsuranceModelsBehaviorSubject)
			.withArgs(getInsuranceProviderModelWithId, insuranceBenefitPlanWithId.insuranceProviderId).and.returnValue(insuranceProviderWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				InsuranceBenefitPlanCrudModule,
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

			fixture = TestBed.createComponent(InsuranceBenefitPlanCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new InsuranceBenefitPlanModel();
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
	it ('Renders the Insurance Benefit Plan CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Insurance Provider relation.
	*
	* The button should only exist if insuranceProviderMultiCrudActive is true
	*/
	it ('Renders Insurance Provider Add Entity button in create mode', fakeAsync(() => {
		const insuranceProviderButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.insuranceProviderDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!insuranceProviderButton).toEqual(component.insuranceProviderMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Insurance Provider', fakeAsync(() => {
		const insuranceProviderButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.insuranceProviderDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!insuranceProviderButton).toEqual(component.insuranceProviderMultiCrudActive);

		if (component.insuranceProviderMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInsuranceProviderRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.insuranceProviderDisplayName + ' from Model')).length;

			insuranceProviderButton.nativeElement.click();
			fixture.detectChanges();

			const actualInsuranceProviderRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.insuranceProviderDisplayName + ' from Model')).length;

			expect(actualInsuranceProviderRemoveButtonCount).toEqual(initialInsuranceProviderRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Insurance Provider button', () => {
		const insuranceProviderButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.insuranceProviderDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!insuranceProviderButton).toEqual(component.insuranceProviderMultiCrudActive);

		if (component.insuranceProviderMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			insuranceProviderButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInsuranceProviderRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.insuranceProviderDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInsuranceProviderRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInsuranceProviderRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.insuranceProviderDisplayName + ' from Model'));

			expect(actualInsuranceProviderRemoveButtons.length).toEqual(initialInsuranceProviderRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Insurance Provider button when one has already been added', () => {

		const insuranceProviderButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.insuranceProviderDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!insuranceProviderButton).toEqual(component.insuranceProviderMultiCrudActive);

		if (component.insuranceProviderMultiCrudActive) {
			insuranceProviderButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinsuranceProviderButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.insuranceProviderDisplayName + ' to Model'));

			expect(updatedinsuranceProviderButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Insurance Provider entities from model when loading in edit mode', () => {
		component.targetModel = insuranceBenefitPlanWithId;
		component.targetModelId = insuranceBenefitPlanWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.insuranceProviderMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const insuranceProviderRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.insuranceProviderDisplayName + ' from Model')).length;

			expect(insuranceProviderRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Invoice Payment Insurances relation.
	*
	* The button should only exist if invoicePaymentInsurancesMultiCrudActive is true
	*/
	it ('Renders Invoice Payment Insurances Add Entity button in create mode', fakeAsync(() => {
		const invoicePaymentInsurancesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentInsurancesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!invoicePaymentInsurancesButton).toEqual(component.invoicePaymentInsurancesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Invoice Payment Insurances', fakeAsync(() => {
		const invoicePaymentInsurancesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentInsurancesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicePaymentInsurancesButton).toEqual(component.invoicePaymentInsurancesMultiCrudActive);

		if (component.invoicePaymentInsurancesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInvoicePaymentInsurancesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentInsurancesDisplayName + ' from Model')).length;

			invoicePaymentInsurancesButton.nativeElement.click();
			fixture.detectChanges();

			const actualInvoicePaymentInsurancesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentInsurancesDisplayName + ' from Model')).length;

			expect(actualInvoicePaymentInsurancesRemoveButtonCount).toEqual(initialInvoicePaymentInsurancesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Invoice Payment Insurances button', () => {
		const invoicePaymentInsurancesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentInsurancesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicePaymentInsurancesButton).toEqual(component.invoicePaymentInsurancesMultiCrudActive);

		if (component.invoicePaymentInsurancesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			invoicePaymentInsurancesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInvoicePaymentInsurancesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentInsurancesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInvoicePaymentInsurancesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInvoicePaymentInsurancesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentInsurancesDisplayName + ' from Model'));

			expect(actualInvoicePaymentInsurancesRemoveButtons.length).toEqual(initialInvoicePaymentInsurancesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Invoice Payment Insurances button when one has already been added', () => {

		const invoicePaymentInsurancesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentInsurancesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicePaymentInsurancesButton).toEqual(component.invoicePaymentInsurancesMultiCrudActive);

		if (component.invoicePaymentInsurancesMultiCrudActive) {
			invoicePaymentInsurancesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinvoicePaymentInsurancesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentInsurancesDisplayName + ' to Model'));

			expect(updatedinvoicePaymentInsurancesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Invoice Payment Insurances entities from model when loading in edit mode', () => {
		component.targetModel = insuranceBenefitPlanWithId;
		component.targetModelId = insuranceBenefitPlanWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.invoicePaymentInsurancesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const invoicePaymentInsurancesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentInsurancesDisplayName + ' from Model')).length;

			expect(invoicePaymentInsurancesRemoveButtonCount).toEqual(insuranceBenefitPlanWithId.invoicePaymentInsurances.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Payment Insurances relation.
	*
	* The button should only exist if patientPaymentInsurancesMultiCrudActive is true
	*/
	it ('Renders Patient Payment Insurances Add Entity button in create mode', fakeAsync(() => {
		const patientPaymentInsurancesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentInsurancesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientPaymentInsurancesButton).toEqual(component.patientPaymentInsurancesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Payment Insurances', fakeAsync(() => {
		const patientPaymentInsurancesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentInsurancesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentInsurancesButton).toEqual(component.patientPaymentInsurancesMultiCrudActive);

		if (component.patientPaymentInsurancesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientPaymentInsurancesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentInsurancesDisplayName + ' from Model')).length;

			patientPaymentInsurancesButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientPaymentInsurancesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentInsurancesDisplayName + ' from Model')).length;

			expect(actualPatientPaymentInsurancesRemoveButtonCount).toEqual(initialPatientPaymentInsurancesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Payment Insurances button', () => {
		const patientPaymentInsurancesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentInsurancesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentInsurancesButton).toEqual(component.patientPaymentInsurancesMultiCrudActive);

		if (component.patientPaymentInsurancesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientPaymentInsurancesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientPaymentInsurancesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentInsurancesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientPaymentInsurancesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientPaymentInsurancesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentInsurancesDisplayName + ' from Model'));

			expect(actualPatientPaymentInsurancesRemoveButtons.length).toEqual(initialPatientPaymentInsurancesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Patient Payment Insurances button when one has already been added', () => {

		const patientPaymentInsurancesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentInsurancesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentInsurancesButton).toEqual(component.patientPaymentInsurancesMultiCrudActive);

		if (component.patientPaymentInsurancesMultiCrudActive) {
			patientPaymentInsurancesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientPaymentInsurancesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentInsurancesDisplayName + ' to Model'));

			expect(updatedpatientPaymentInsurancesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Patient Payment Insurances entities from model when loading in edit mode', () => {
		component.targetModel = insuranceBenefitPlanWithId;
		component.targetModelId = insuranceBenefitPlanWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientPaymentInsurancesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientPaymentInsurancesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentInsurancesDisplayName + ' from Model')).length;

			expect(patientPaymentInsurancesRemoveButtonCount).toEqual(insuranceBenefitPlanWithId.patientPaymentInsurances.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Visit Patient Payment Insurances relation.
	*
	* The button should only exist if patientVisitPatientPaymentInsurancesMultiCrudActive is true
	*/
	it ('Renders Patient Visit Patient Payment Insurances Add Entity button in create mode', fakeAsync(() => {
		const patientVisitPatientPaymentInsurancesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVisitPatientPaymentInsurancesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientVisitPatientPaymentInsurancesButton).toEqual(component.patientVisitPatientPaymentInsurancesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Visit Patient Payment Insurances', fakeAsync(() => {
		const patientVisitPatientPaymentInsurancesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVisitPatientPaymentInsurancesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientVisitPatientPaymentInsurancesButton).toEqual(component.patientVisitPatientPaymentInsurancesMultiCrudActive);

		if (component.patientVisitPatientPaymentInsurancesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientVisitPatientPaymentInsurancesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVisitPatientPaymentInsurancesDisplayName + ' from Model')).length;

			patientVisitPatientPaymentInsurancesButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientVisitPatientPaymentInsurancesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVisitPatientPaymentInsurancesDisplayName + ' from Model')).length;

			expect(actualPatientVisitPatientPaymentInsurancesRemoveButtonCount).toEqual(initialPatientVisitPatientPaymentInsurancesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Visit Patient Payment Insurances button', () => {
		const patientVisitPatientPaymentInsurancesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVisitPatientPaymentInsurancesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientVisitPatientPaymentInsurancesButton).toEqual(component.patientVisitPatientPaymentInsurancesMultiCrudActive);

		if (component.patientVisitPatientPaymentInsurancesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientVisitPatientPaymentInsurancesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientVisitPatientPaymentInsurancesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVisitPatientPaymentInsurancesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientVisitPatientPaymentInsurancesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientVisitPatientPaymentInsurancesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVisitPatientPaymentInsurancesDisplayName + ' from Model'));

			expect(actualPatientVisitPatientPaymentInsurancesRemoveButtons.length).toEqual(initialPatientVisitPatientPaymentInsurancesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Patient Visit Patient Payment Insurances button when one has already been added', () => {

		const patientVisitPatientPaymentInsurancesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVisitPatientPaymentInsurancesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientVisitPatientPaymentInsurancesButton).toEqual(component.patientVisitPatientPaymentInsurancesMultiCrudActive);

		if (component.patientVisitPatientPaymentInsurancesMultiCrudActive) {
			patientVisitPatientPaymentInsurancesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientVisitPatientPaymentInsurancesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVisitPatientPaymentInsurancesDisplayName + ' to Model'));

			expect(updatedpatientVisitPatientPaymentInsurancesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Patient Visit Patient Payment Insurances entities from model when loading in edit mode', () => {
		component.targetModel = insuranceBenefitPlanWithId;
		component.targetModelId = insuranceBenefitPlanWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientVisitPatientPaymentInsurancesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientVisitPatientPaymentInsurancesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVisitPatientPaymentInsurancesDisplayName + ' from Model')).length;

			expect(patientVisitPatientPaymentInsurancesRemoveButtonCount).toEqual(insuranceBenefitPlanWithId.patientVisitPatientPaymentInsurances.length);
		}
	});

});
