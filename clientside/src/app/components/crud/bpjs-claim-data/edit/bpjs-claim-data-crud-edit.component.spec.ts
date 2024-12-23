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
	getBpjsClaimDataCollectionModels,
	getCountBpjsClaimDataModels,
	getBpjsClaimDataModelWithId
} from 'src/app/models/bpjsClaimData/bpjs_claim_data.model.selector';
import { BpjsClaimDataCrudModule } from '../bpjs-claim-data-crud.module';
import { BpjsClaimDataCrudEditComponent } from './bpjs-claim-data-crud-edit.component';
import {
	BpjsClaimDataModelState,
	initialState as initialBpjsClaimDataModelState
} from 'src/app/models/bpjsClaimData/bpjs_claim_data.model.state';
import { BpjsClaimDataDataFactory } from 'src/app/lib/utils/factories/bpjs-claim-data-data-factory';
import { BpjsClaimDataModel } from 'src/app/models/bpjsClaimData/bpjs_claim_data.model';
import { CrudTileMode } from '../bpjs-claim-data-crud.component';

describe('BPJS Claim Data CRUD Edit component tests', () => {
	let fixture: ComponentFixture<BpjsClaimDataCrudEditComponent>
	let component: BpjsClaimDataCrudEditComponent;

	let bpjsClaimDataModelState: BpjsClaimDataModelState;

	let store: MockStore<{ model: BpjsClaimDataModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let bpjsClaimDataCountBehaviorSubject: BehaviorSubject<number>;
	let bpjsClaimDataModelsBehaviorSubject: BehaviorSubject<BpjsClaimDataModel[]>;

	const bpjsClaimDataFactory: BpjsClaimDataDataFactory = new BpjsClaimDataDataFactory();
	const defaultBpjsClaimDataCount: number = 10;
	const defaultBpjsClaimDataEntities: BpjsClaimDataModel[] = bpjsClaimDataFactory.createAll(defaultBpjsClaimDataCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let bpjsClaimDataWithId: BpjsClaimDataModel = defaultBpjsClaimDataEntities[0];
	let bpjsClaimDataModelWithIdBehaviorSubject: BehaviorSubject<BpjsClaimDataModel>;


	const routerState: RouterState = {
		url: 'bpjs-claim-data-crud',
		urls: ['bpjs-claim-data-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: BpjsClaimDataModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		bpjsClaimDataModelState = initialBpjsClaimDataModelState;
		store.setState({model: bpjsClaimDataModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		bpjsClaimDataCountBehaviorSubject = new BehaviorSubject(defaultBpjsClaimDataCount);

		// selectors for all references
		bpjsClaimDataModelsBehaviorSubject = new BehaviorSubject(defaultBpjsClaimDataEntities);

		// selectors for target entity and its related entity
		bpjsClaimDataModelWithIdBehaviorSubject = new BehaviorSubject(bpjsClaimDataWithId);

		spyOn(store, 'select')
			.withArgs(getCountBpjsClaimDataModels).and.returnValue(bpjsClaimDataCountBehaviorSubject)
			.withArgs(getBpjsClaimDataModelWithId, bpjsClaimDataWithId.id).and.returnValue(bpjsClaimDataModelWithIdBehaviorSubject)
			.withArgs(getBpjsClaimDataCollectionModels, jasmine.any(String)).and.returnValue(bpjsClaimDataModelsBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				BpjsClaimDataCrudModule,
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

			fixture = TestBed.createComponent(BpjsClaimDataCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new BpjsClaimDataModel();
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
	it ('Renders the BPJS Claim Data CRUD Edit Component', () => {
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

});
