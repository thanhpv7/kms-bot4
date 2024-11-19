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
	getInsuranceProviderCollectionModels,
	getCountInsuranceProviderModels,
	getInsuranceProviderModelWithId
} from 'src/app/models/insuranceProvider/insurance_provider.model.selector';
import { InsuranceProviderCrudModule } from '../insurance-provider-crud.module';
import { InsuranceProviderCrudEditComponent } from './insurance-provider-crud-edit.component';
import {
	InsuranceProviderModelState,
	initialState as initialInsuranceProviderModelState
} from 'src/app/models/insuranceProvider/insurance_provider.model.state';
import { InsuranceProviderDataFactory } from 'src/app/lib/utils/factories/insurance-provider-data-factory';
import { InsuranceProviderModel } from 'src/app/models/insuranceProvider/insurance_provider.model';
import { CrudTileMode } from '../insurance-provider-crud.component';
import { getInsuranceBenefitPlanModelWithId } from 'src/app/models/insuranceBenefitPlan/insurance_benefit_plan.model.selector';
import { getInsuranceBenefitPlanCollectionModels } from 'src/app/models/insuranceBenefitPlan/insurance_benefit_plan.model.selector';
import { InsuranceBenefitPlanModel } from 'src/app/models/insuranceBenefitPlan/insurance_benefit_plan.model';
import { InsuranceBenefitPlanDataFactory } from 'src/app/lib/utils/factories/insurance-benefit-plan-data-factory';
import { getInvoicePaymentInsuranceModelWithId } from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model.selector';
import { getInvoicePaymentInsuranceCollectionModels } from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model.selector';
import { InvoicePaymentInsuranceModel } from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model';
import { InvoicePaymentInsuranceDataFactory } from 'src/app/lib/utils/factories/invoice-payment-insurance-data-factory';
import { getPatientPaymentInsuranceModelWithId } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model.selector';
import { getPatientPaymentInsuranceCollectionModels } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model.selector';
import { PatientPaymentInsuranceModel } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model';
import { PatientPaymentInsuranceDataFactory } from 'src/app/lib/utils/factories/patient-payment-insurance-data-factory';
import { getPatientVisitPatientPaymentInsuranceModelWithId } from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.selector';
import { getPatientVisitPatientPaymentInsuranceCollectionModels } from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.selector';
import { PatientVisitPatientPaymentInsuranceModel } from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model';
import { PatientVisitPatientPaymentInsuranceDataFactory } from 'src/app/lib/utils/factories/patient-visit-patient-payment-insurance-data-factory';

describe('Insurance Provider CRUD Edit component tests', () => {
	let fixture: ComponentFixture<InsuranceProviderCrudEditComponent>
	let component: InsuranceProviderCrudEditComponent;

	let insuranceProviderModelState: InsuranceProviderModelState;

	let store: MockStore<{ model: InsuranceProviderModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let insuranceProviderCountBehaviorSubject: BehaviorSubject<number>;
	let insuranceProviderModelsBehaviorSubject: BehaviorSubject<InsuranceProviderModel[]>;
	let insuranceBenefitPlanModelsBehaviorSubject: BehaviorSubject<InsuranceBenefitPlanModel[]>;
	let invoicePaymentInsuranceModelsBehaviorSubject: BehaviorSubject<InvoicePaymentInsuranceModel[]>;
	let patientPaymentInsuranceModelsBehaviorSubject: BehaviorSubject<PatientPaymentInsuranceModel[]>;
	let patientVisitPatientPaymentInsuranceModelsBehaviorSubject: BehaviorSubject<PatientVisitPatientPaymentInsuranceModel[]>;

	const insuranceProviderFactory: InsuranceProviderDataFactory = new InsuranceProviderDataFactory();
	const defaultInsuranceProviderCount: number = 10;
	const defaultInsuranceProviderEntities: InsuranceProviderModel[] = insuranceProviderFactory.createAll(defaultInsuranceProviderCount);

	const insuranceBenefitPlanFactory: InsuranceBenefitPlanDataFactory = new InsuranceBenefitPlanDataFactory();
	const defaultInsuranceBenefitPlanCount: number = 10;
	const defaultInsuranceBenefitPlanEntities: InsuranceBenefitPlanModel[] = insuranceBenefitPlanFactory.createAll(defaultInsuranceBenefitPlanCount);

	const invoicePaymentInsuranceFactory: InvoicePaymentInsuranceDataFactory = new InvoicePaymentInsuranceDataFactory();
	const defaultInvoicePaymentInsuranceCount: number = 10;
	const defaultInvoicePaymentInsuranceEntities: InvoicePaymentInsuranceModel[] = invoicePaymentInsuranceFactory.createAll(defaultInvoicePaymentInsuranceCount);

	const patientPaymentInsuranceFactory: PatientPaymentInsuranceDataFactory = new PatientPaymentInsuranceDataFactory();
	const defaultPatientPaymentInsuranceCount: number = 10;
	const defaultPatientPaymentInsuranceEntities: PatientPaymentInsuranceModel[] = patientPaymentInsuranceFactory.createAll(defaultPatientPaymentInsuranceCount);

	const patientVisitPatientPaymentInsuranceFactory: PatientVisitPatientPaymentInsuranceDataFactory = new PatientVisitPatientPaymentInsuranceDataFactory();
	const defaultPatientVisitPatientPaymentInsuranceCount: number = 10;
	const defaultPatientVisitPatientPaymentInsuranceEntities: PatientVisitPatientPaymentInsuranceModel[] = patientVisitPatientPaymentInsuranceFactory.createAll(defaultPatientVisitPatientPaymentInsuranceCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let insuranceProviderWithId: InsuranceProviderModel = defaultInsuranceProviderEntities[0];
	let insuranceProviderModelWithIdBehaviorSubject: BehaviorSubject<InsuranceProviderModel>;

	insuranceProviderWithId.insuranceBenefitPlans = defaultInsuranceBenefitPlanEntities;
	insuranceProviderWithId.insuranceBenefitPlansIds = insuranceProviderWithId.insuranceBenefitPlans.map(insuranceBenefitPlans => insuranceBenefitPlans.id);


	const routerState: RouterState = {
		url: 'insurance-provider-crud',
		urls: ['insurance-provider-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: InsuranceProviderModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		insuranceProviderModelState = initialInsuranceProviderModelState;
		store.setState({model: insuranceProviderModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		insuranceProviderCountBehaviorSubject = new BehaviorSubject(defaultInsuranceProviderCount);

		// selectors for all references
		insuranceProviderModelsBehaviorSubject = new BehaviorSubject(defaultInsuranceProviderEntities);
		insuranceBenefitPlanModelsBehaviorSubject = new BehaviorSubject(defaultInsuranceBenefitPlanEntities);
		invoicePaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentInsuranceEntities);
		patientPaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentInsuranceEntities);
		patientVisitPatientPaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitPatientPaymentInsuranceEntities);

		// selectors for target entity and its related entity
		insuranceProviderModelWithIdBehaviorSubject = new BehaviorSubject(insuranceProviderWithId);

		spyOn(store, 'select')
			.withArgs(getCountInsuranceProviderModels).and.returnValue(insuranceProviderCountBehaviorSubject)
			.withArgs(getInsuranceProviderModelWithId, insuranceProviderWithId.id).and.returnValue(insuranceProviderModelWithIdBehaviorSubject)
			.withArgs(getInsuranceProviderCollectionModels, jasmine.any(String)).and.returnValue(insuranceProviderModelsBehaviorSubject)
			.withArgs(getInsuranceBenefitPlanCollectionModels, jasmine.any(String)).and.returnValue(insuranceBenefitPlanModelsBehaviorSubject)
			.withArgs(getInvoicePaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentInsuranceModelsBehaviorSubject)
			.withArgs(getPatientPaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentInsuranceModelsBehaviorSubject)
			.withArgs(getPatientVisitPatientPaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(patientVisitPatientPaymentInsuranceModelsBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				InsuranceProviderCrudModule,
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

			fixture = TestBed.createComponent(InsuranceProviderCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new InsuranceProviderModel();
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
	it ('Renders the Insurance Provider CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Insurance Benefit Plans relation.
	*
	* The button should only exist if insuranceBenefitPlansMultiCrudActive is true
	*/
	it ('Renders Insurance Benefit Plans Add Entity button in create mode', fakeAsync(() => {
		const insuranceBenefitPlansButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.insuranceBenefitPlansDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!insuranceBenefitPlansButton).toEqual(component.insuranceBenefitPlansMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Insurance Benefit Plans', fakeAsync(() => {
		const insuranceBenefitPlansButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.insuranceBenefitPlansDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!insuranceBenefitPlansButton).toEqual(component.insuranceBenefitPlansMultiCrudActive);

		if (component.insuranceBenefitPlansMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInsuranceBenefitPlansRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.insuranceBenefitPlansDisplayName + ' from Model')).length;

			insuranceBenefitPlansButton.nativeElement.click();
			fixture.detectChanges();

			const actualInsuranceBenefitPlansRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.insuranceBenefitPlansDisplayName + ' from Model')).length;

			expect(actualInsuranceBenefitPlansRemoveButtonCount).toEqual(initialInsuranceBenefitPlansRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Insurance Benefit Plans button', () => {
		const insuranceBenefitPlansButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.insuranceBenefitPlansDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!insuranceBenefitPlansButton).toEqual(component.insuranceBenefitPlansMultiCrudActive);

		if (component.insuranceBenefitPlansMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			insuranceBenefitPlansButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInsuranceBenefitPlansRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.insuranceBenefitPlansDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInsuranceBenefitPlansRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInsuranceBenefitPlansRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.insuranceBenefitPlansDisplayName + ' from Model'));

			expect(actualInsuranceBenefitPlansRemoveButtons.length).toEqual(initialInsuranceBenefitPlansRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Insurance Benefit Plans button when one has already been added', () => {

		const insuranceBenefitPlansButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.insuranceBenefitPlansDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!insuranceBenefitPlansButton).toEqual(component.insuranceBenefitPlansMultiCrudActive);

		if (component.insuranceBenefitPlansMultiCrudActive) {
			insuranceBenefitPlansButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinsuranceBenefitPlansButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.insuranceBenefitPlansDisplayName + ' to Model'));

			expect(updatedinsuranceBenefitPlansButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Insurance Benefit Plans entities from model when loading in edit mode', () => {
		component.targetModel = insuranceProviderWithId;
		component.targetModelId = insuranceProviderWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.insuranceBenefitPlansMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const insuranceBenefitPlansRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.insuranceBenefitPlansDisplayName + ' from Model')).length;

			expect(insuranceBenefitPlansRemoveButtonCount).toEqual(insuranceProviderWithId.insuranceBenefitPlans.length);
		}
	});

});
