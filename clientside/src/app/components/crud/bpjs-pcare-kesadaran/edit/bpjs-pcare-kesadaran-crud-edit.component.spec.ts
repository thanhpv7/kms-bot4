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
	getBpjsPcareKesadaranCollectionModels,
	getCountBpjsPcareKesadaranModels,
	getBpjsPcareKesadaranModelWithId
} from 'src/app/models/bpjsPcareKesadaran/bpjs_pcare_kesadaran.model.selector';
import { BpjsPcareKesadaranCrudModule } from '../bpjs-pcare-kesadaran-crud.module';
import { BpjsPcareKesadaranCrudEditComponent } from './bpjs-pcare-kesadaran-crud-edit.component';
import {
	BpjsPcareKesadaranModelState,
	initialState as initialBpjsPcareKesadaranModelState
} from 'src/app/models/bpjsPcareKesadaran/bpjs_pcare_kesadaran.model.state';
import { BpjsPcareKesadaranDataFactory } from 'src/app/lib/utils/factories/bpjs-pcare-kesadaran-data-factory';
import { BpjsPcareKesadaranModel } from 'src/app/models/bpjsPcareKesadaran/bpjs_pcare_kesadaran.model';
import { CrudTileMode } from '../bpjs-pcare-kesadaran-crud.component';

describe('BPJS Pcare Kesadaran CRUD Edit component tests', () => {
	let fixture: ComponentFixture<BpjsPcareKesadaranCrudEditComponent>
	let component: BpjsPcareKesadaranCrudEditComponent;

	let bpjsPcareKesadaranModelState: BpjsPcareKesadaranModelState;

	let store: MockStore<{ model: BpjsPcareKesadaranModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let bpjsPcareKesadaranCountBehaviorSubject: BehaviorSubject<number>;
	let bpjsPcareKesadaranModelsBehaviorSubject: BehaviorSubject<BpjsPcareKesadaranModel[]>;

	const bpjsPcareKesadaranFactory: BpjsPcareKesadaranDataFactory = new BpjsPcareKesadaranDataFactory();
	const defaultBpjsPcareKesadaranCount: number = 10;
	const defaultBpjsPcareKesadaranEntities: BpjsPcareKesadaranModel[] = bpjsPcareKesadaranFactory.createAll(defaultBpjsPcareKesadaranCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let bpjsPcareKesadaranWithId: BpjsPcareKesadaranModel = defaultBpjsPcareKesadaranEntities[0];
	let bpjsPcareKesadaranModelWithIdBehaviorSubject: BehaviorSubject<BpjsPcareKesadaranModel>;


	const routerState: RouterState = {
		url: 'bpjs-pcare-kesadaran-crud',
		urls: ['bpjs-pcare-kesadaran-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: BpjsPcareKesadaranModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		bpjsPcareKesadaranModelState = initialBpjsPcareKesadaranModelState;
		store.setState({model: bpjsPcareKesadaranModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		bpjsPcareKesadaranCountBehaviorSubject = new BehaviorSubject(defaultBpjsPcareKesadaranCount);

		// selectors for all references
		bpjsPcareKesadaranModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcareKesadaranEntities);

		// selectors for target entity and its related entity
		bpjsPcareKesadaranModelWithIdBehaviorSubject = new BehaviorSubject(bpjsPcareKesadaranWithId);

		spyOn(store, 'select')
			.withArgs(getCountBpjsPcareKesadaranModels).and.returnValue(bpjsPcareKesadaranCountBehaviorSubject)
			.withArgs(getBpjsPcareKesadaranModelWithId, bpjsPcareKesadaranWithId.id).and.returnValue(bpjsPcareKesadaranModelWithIdBehaviorSubject)
			.withArgs(getBpjsPcareKesadaranCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcareKesadaranModelsBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				BpjsPcareKesadaranCrudModule,
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

			fixture = TestBed.createComponent(BpjsPcareKesadaranCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new BpjsPcareKesadaranModel();
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
	it ('Renders the BPJS Pcare Kesadaran CRUD Edit Component', () => {
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