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
	getBpjsListTaskCollectionModels,
	getCountBpjsListTaskModels,
	getBpjsListTaskModelWithId
} from 'src/app/models/bpjsListTask/bpjs_list_task.model.selector';
import { BpjsListTaskCrudModule } from '../bpjs-list-task-crud.module';
import { BpjsListTaskCrudEditComponent } from './bpjs-list-task-crud-edit.component';
import {
	BpjsListTaskModelState,
	initialState as initialBpjsListTaskModelState
} from 'src/app/models/bpjsListTask/bpjs_list_task.model.state';
import { BpjsListTaskDataFactory } from 'src/app/lib/utils/factories/bpjs-list-task-data-factory';
import { BpjsListTaskModel } from 'src/app/models/bpjsListTask/bpjs_list_task.model';
import { CrudTileMode } from '../bpjs-list-task-crud.component';

describe('BPJS List Task CRUD Edit component tests', () => {
	let fixture: ComponentFixture<BpjsListTaskCrudEditComponent>
	let component: BpjsListTaskCrudEditComponent;

	let bpjsListTaskModelState: BpjsListTaskModelState;

	let store: MockStore<{ model: BpjsListTaskModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let bpjsListTaskCountBehaviorSubject: BehaviorSubject<number>;
	let bpjsListTaskModelsBehaviorSubject: BehaviorSubject<BpjsListTaskModel[]>;

	const bpjsListTaskFactory: BpjsListTaskDataFactory = new BpjsListTaskDataFactory();
	const defaultBpjsListTaskCount: number = 10;
	const defaultBpjsListTaskEntities: BpjsListTaskModel[] = bpjsListTaskFactory.createAll(defaultBpjsListTaskCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let bpjsListTaskWithId: BpjsListTaskModel = defaultBpjsListTaskEntities[0];
	let bpjsListTaskModelWithIdBehaviorSubject: BehaviorSubject<BpjsListTaskModel>;


	const routerState: RouterState = {
		url: 'bpjs-list-task-crud',
		urls: ['bpjs-list-task-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: BpjsListTaskModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		bpjsListTaskModelState = initialBpjsListTaskModelState;
		store.setState({model: bpjsListTaskModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		bpjsListTaskCountBehaviorSubject = new BehaviorSubject(defaultBpjsListTaskCount);

		// selectors for all references
		bpjsListTaskModelsBehaviorSubject = new BehaviorSubject(defaultBpjsListTaskEntities);

		// selectors for target entity and its related entity
		bpjsListTaskModelWithIdBehaviorSubject = new BehaviorSubject(bpjsListTaskWithId);

		spyOn(store, 'select')
			.withArgs(getCountBpjsListTaskModels).and.returnValue(bpjsListTaskCountBehaviorSubject)
			.withArgs(getBpjsListTaskModelWithId, bpjsListTaskWithId.id).and.returnValue(bpjsListTaskModelWithIdBehaviorSubject)
			.withArgs(getBpjsListTaskCollectionModels, jasmine.any(String)).and.returnValue(bpjsListTaskModelsBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				BpjsListTaskCrudModule,
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

			fixture = TestBed.createComponent(BpjsListTaskCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new BpjsListTaskModel();
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
	it ('Renders the BPJS List Task CRUD Edit Component', () => {
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