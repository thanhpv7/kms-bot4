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
	getBpjsReferralSpecialistCollectionModels,
	getCountBpjsReferralSpecialistModels,
	getBpjsReferralSpecialistModelWithId
} from 'src/app/models/bpjsReferralSpecialist/bpjs_referral_specialist.model.selector';
import { BpjsReferralSpecialistCrudModule } from '../bpjs-referral-specialist-crud.module';
import { BpjsReferralSpecialistCrudEditComponent } from './bpjs-referral-specialist-crud-edit.component';
import {
	BpjsReferralSpecialistModelState,
	initialState as initialBpjsReferralSpecialistModelState
} from 'src/app/models/bpjsReferralSpecialist/bpjs_referral_specialist.model.state';
import { BpjsReferralSpecialistDataFactory } from 'src/app/lib/utils/factories/bpjs-referral-specialist-data-factory';
import { BpjsReferralSpecialistModel } from 'src/app/models/bpjsReferralSpecialist/bpjs_referral_specialist.model';
import { CrudTileMode } from '../bpjs-referral-specialist-crud.component';
import { getBpjsClaimSubmissionModelWithId } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { getBpjsClaimSubmissionCollectionModels } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { BpjsClaimSubmissionModel } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import { BpjsClaimSubmissionDataFactory } from 'src/app/lib/utils/factories/bpjs-claim-submission-data-factory';
import { getBpjsFacilityListModelWithId } from 'src/app/models/bpjsFacilityList/bpjs_facility_list.model.selector';
import { getBpjsFacilityListCollectionModels } from 'src/app/models/bpjsFacilityList/bpjs_facility_list.model.selector';
import { BpjsFacilityListModel } from 'src/app/models/bpjsFacilityList/bpjs_facility_list.model';
import { BpjsFacilityListDataFactory } from 'src/app/lib/utils/factories/bpjs-facility-list-data-factory';
import { getBpjsHealthFacilityModelWithId } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.selector';
import { getBpjsHealthFacilityCollectionModels } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.selector';
import { BpjsHealthFacilityModel } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model';
import { BpjsHealthFacilityDataFactory } from 'src/app/lib/utils/factories/bpjs-health-facility-data-factory';
import { getBpjsPatientReferralModelWithId } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { getBpjsPatientReferralCollectionModels } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { BpjsPatientReferralModel } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model';
import { BpjsPatientReferralDataFactory } from 'src/app/lib/utils/factories/bpjs-patient-referral-data-factory';

describe('BPJS Referral Specialist CRUD Edit component tests', () => {
	let fixture: ComponentFixture<BpjsReferralSpecialistCrudEditComponent>
	let component: BpjsReferralSpecialistCrudEditComponent;

	let bpjsReferralSpecialistModelState: BpjsReferralSpecialistModelState;

	let store: MockStore<{ model: BpjsReferralSpecialistModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let bpjsReferralSpecialistCountBehaviorSubject: BehaviorSubject<number>;
	let bpjsReferralSpecialistModelsBehaviorSubject: BehaviorSubject<BpjsReferralSpecialistModel[]>;
	let bpjsClaimSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsClaimSubmissionModel[]>;
	let bpjsFacilityListModelsBehaviorSubject: BehaviorSubject<BpjsFacilityListModel[]>;
	let bpjsHealthFacilityModelsBehaviorSubject: BehaviorSubject<BpjsHealthFacilityModel[]>;
	let bpjsPatientReferralModelsBehaviorSubject: BehaviorSubject<BpjsPatientReferralModel[]>;

	const bpjsReferralSpecialistFactory: BpjsReferralSpecialistDataFactory = new BpjsReferralSpecialistDataFactory();
	const defaultBpjsReferralSpecialistCount: number = 10;
	const defaultBpjsReferralSpecialistEntities: BpjsReferralSpecialistModel[] = bpjsReferralSpecialistFactory.createAll(defaultBpjsReferralSpecialistCount);

	const bpjsClaimSubmissionFactory: BpjsClaimSubmissionDataFactory = new BpjsClaimSubmissionDataFactory();
	const defaultBpjsClaimSubmissionCount: number = 10;
	const defaultBpjsClaimSubmissionEntities: BpjsClaimSubmissionModel[] = bpjsClaimSubmissionFactory.createAll(defaultBpjsClaimSubmissionCount);

	const bpjsFacilityListFactory: BpjsFacilityListDataFactory = new BpjsFacilityListDataFactory();
	const defaultBpjsFacilityListCount: number = 10;
	const defaultBpjsFacilityListEntities: BpjsFacilityListModel[] = bpjsFacilityListFactory.createAll(defaultBpjsFacilityListCount);

	const bpjsHealthFacilityFactory: BpjsHealthFacilityDataFactory = new BpjsHealthFacilityDataFactory();
	const defaultBpjsHealthFacilityCount: number = 10;
	const defaultBpjsHealthFacilityEntities: BpjsHealthFacilityModel[] = bpjsHealthFacilityFactory.createAll(defaultBpjsHealthFacilityCount);

	const bpjsPatientReferralFactory: BpjsPatientReferralDataFactory = new BpjsPatientReferralDataFactory();
	const defaultBpjsPatientReferralCount: number = 10;
	const defaultBpjsPatientReferralEntities: BpjsPatientReferralModel[] = bpjsPatientReferralFactory.createAll(defaultBpjsPatientReferralCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let bpjsReferralSpecialistWithId: BpjsReferralSpecialistModel = defaultBpjsReferralSpecialistEntities[0];
	let bpjsReferralSpecialistModelWithIdBehaviorSubject: BehaviorSubject<BpjsReferralSpecialistModel>;

	bpjsReferralSpecialistWithId.bpjsHealthFacility = defaultBpjsHealthFacilityEntities[0];
	bpjsReferralSpecialistWithId.bpjsHealthFacilityId = bpjsReferralSpecialistWithId.bpjsHealthFacility.id;
	let bpjsHealthFacilityWithIdBehaviorSubject: BehaviorSubject<BpjsHealthFacilityModel>;


	const routerState: RouterState = {
		url: 'bpjs-referral-specialist-crud',
		urls: ['bpjs-referral-specialist-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: BpjsReferralSpecialistModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		bpjsReferralSpecialistModelState = initialBpjsReferralSpecialistModelState;
		store.setState({model: bpjsReferralSpecialistModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		bpjsReferralSpecialistCountBehaviorSubject = new BehaviorSubject(defaultBpjsReferralSpecialistCount);

		// selectors for all references
		bpjsReferralSpecialistModelsBehaviorSubject = new BehaviorSubject(defaultBpjsReferralSpecialistEntities);
		bpjsClaimSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsClaimSubmissionEntities);
		bpjsFacilityListModelsBehaviorSubject = new BehaviorSubject(defaultBpjsFacilityListEntities);
		bpjsHealthFacilityModelsBehaviorSubject = new BehaviorSubject(defaultBpjsHealthFacilityEntities);
		bpjsPatientReferralModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPatientReferralEntities);

		// selectors for target entity and its related entity
		bpjsReferralSpecialistModelWithIdBehaviorSubject = new BehaviorSubject(bpjsReferralSpecialistWithId);
		bpjsHealthFacilityWithIdBehaviorSubject = new BehaviorSubject(bpjsReferralSpecialistWithId.bpjsHealthFacility);

		spyOn(store, 'select')
			.withArgs(getCountBpjsReferralSpecialistModels).and.returnValue(bpjsReferralSpecialistCountBehaviorSubject)
			.withArgs(getBpjsReferralSpecialistModelWithId, bpjsReferralSpecialistWithId.id).and.returnValue(bpjsReferralSpecialistModelWithIdBehaviorSubject)
			.withArgs(getBpjsReferralSpecialistCollectionModels, jasmine.any(String)).and.returnValue(bpjsReferralSpecialistModelsBehaviorSubject)
			.withArgs(getBpjsClaimSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsClaimSubmissionModelsBehaviorSubject)
			.withArgs(getBpjsFacilityListCollectionModels, jasmine.any(String)).and.returnValue(bpjsFacilityListModelsBehaviorSubject)
			.withArgs(getBpjsHealthFacilityCollectionModels, jasmine.any(String)).and.returnValue(bpjsHealthFacilityModelsBehaviorSubject)
			.withArgs(getBpjsPatientReferralCollectionModels, jasmine.any(String)).and.returnValue(bpjsPatientReferralModelsBehaviorSubject)
			.withArgs(getBpjsHealthFacilityModelWithId, bpjsReferralSpecialistWithId.bpjsHealthFacilityId).and.returnValue(bpjsHealthFacilityWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				BpjsReferralSpecialistCrudModule,
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

			fixture = TestBed.createComponent(BpjsReferralSpecialistCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new BpjsReferralSpecialistModel();
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
	it ('Renders the BPJS Referral Specialist CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the BPJS Health Facility relation.
	*
	* The button should only exist if bpjsHealthFacilityMultiCrudActive is true
	*/
	it ('Renders BPJS Health Facility Add Entity button in create mode', fakeAsync(() => {
		const bpjsHealthFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsHealthFacilityDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsHealthFacilityButton).toEqual(component.bpjsHealthFacilityMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Health Facility', fakeAsync(() => {
		const bpjsHealthFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsHealthFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsHealthFacilityButton).toEqual(component.bpjsHealthFacilityMultiCrudActive);

		if (component.bpjsHealthFacilityMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsHealthFacilityRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsHealthFacilityDisplayName + ' from Model')).length;

			bpjsHealthFacilityButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsHealthFacilityRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsHealthFacilityDisplayName + ' from Model')).length;

			expect(actualBpjsHealthFacilityRemoveButtonCount).toEqual(initialBpjsHealthFacilityRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Health Facility button', () => {
		const bpjsHealthFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsHealthFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsHealthFacilityButton).toEqual(component.bpjsHealthFacilityMultiCrudActive);

		if (component.bpjsHealthFacilityMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsHealthFacilityButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsHealthFacilityRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsHealthFacilityDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsHealthFacilityRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsHealthFacilityRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsHealthFacilityDisplayName + ' from Model'));

			expect(actualBpjsHealthFacilityRemoveButtons.length).toEqual(initialBpjsHealthFacilityRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Health Facility button when one has already been added', () => {

		const bpjsHealthFacilityButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsHealthFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsHealthFacilityButton).toEqual(component.bpjsHealthFacilityMultiCrudActive);

		if (component.bpjsHealthFacilityMultiCrudActive) {
			bpjsHealthFacilityButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsHealthFacilityButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsHealthFacilityDisplayName + ' to Model'));

			expect(updatedbpjsHealthFacilityButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Health Facility entities from model when loading in edit mode', () => {
		component.targetModel = bpjsReferralSpecialistWithId;
		component.targetModelId = bpjsReferralSpecialistWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsHealthFacilityMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsHealthFacilityRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsHealthFacilityDisplayName + ' from Model')).length;

			expect(bpjsHealthFacilityRemoveButtonCount).toEqual(1);
		}
	});

});
