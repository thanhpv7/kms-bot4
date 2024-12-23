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
	getPcareStatusPulangCollectionModels,
	getCountPcareStatusPulangModels,
	getPcareStatusPulangModelWithId
} from 'src/app/models/pcareStatusPulang/pcare_status_pulang.model.selector';
import { PcareStatusPulangCrudModule } from '../pcare-status-pulang-crud.module';
import { PcareStatusPulangCrudEditComponent } from './pcare-status-pulang-crud-edit.component';
import {
	PcareStatusPulangModelState,
	initialState as initialPcareStatusPulangModelState
} from 'src/app/models/pcareStatusPulang/pcare_status_pulang.model.state';
import { PcareStatusPulangDataFactory } from 'src/app/lib/utils/factories/pcare-status-pulang-data-factory';
import { PcareStatusPulangModel } from 'src/app/models/pcareStatusPulang/pcare_status_pulang.model';
import { CrudTileMode } from '../pcare-status-pulang-crud.component';

describe('PCare Status Pulang CRUD Edit component tests', () => {
	let fixture: ComponentFixture<PcareStatusPulangCrudEditComponent>
	let component: PcareStatusPulangCrudEditComponent;

	let pcareStatusPulangModelState: PcareStatusPulangModelState;

	let store: MockStore<{ model: PcareStatusPulangModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let pcareStatusPulangCountBehaviorSubject: BehaviorSubject<number>;
	let pcareStatusPulangModelsBehaviorSubject: BehaviorSubject<PcareStatusPulangModel[]>;

	const pcareStatusPulangFactory: PcareStatusPulangDataFactory = new PcareStatusPulangDataFactory();
	const defaultPcareStatusPulangCount: number = 10;
	const defaultPcareStatusPulangEntities: PcareStatusPulangModel[] = pcareStatusPulangFactory.createAll(defaultPcareStatusPulangCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let pcareStatusPulangWithId: PcareStatusPulangModel = defaultPcareStatusPulangEntities[0];
	let pcareStatusPulangModelWithIdBehaviorSubject: BehaviorSubject<PcareStatusPulangModel>;


	const routerState: RouterState = {
		url: 'pcare-status-pulang-crud',
		urls: ['pcare-status-pulang-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: PcareStatusPulangModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		pcareStatusPulangModelState = initialPcareStatusPulangModelState;
		store.setState({model: pcareStatusPulangModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		pcareStatusPulangCountBehaviorSubject = new BehaviorSubject(defaultPcareStatusPulangCount);

		// selectors for all references
		pcareStatusPulangModelsBehaviorSubject = new BehaviorSubject(defaultPcareStatusPulangEntities);

		// selectors for target entity and its related entity
		pcareStatusPulangModelWithIdBehaviorSubject = new BehaviorSubject(pcareStatusPulangWithId);

		spyOn(store, 'select')
			.withArgs(getCountPcareStatusPulangModels).and.returnValue(pcareStatusPulangCountBehaviorSubject)
			.withArgs(getPcareStatusPulangModelWithId, pcareStatusPulangWithId.id).and.returnValue(pcareStatusPulangModelWithIdBehaviorSubject)
			.withArgs(getPcareStatusPulangCollectionModels, jasmine.any(String)).and.returnValue(pcareStatusPulangModelsBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				PcareStatusPulangCrudModule,
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

			fixture = TestBed.createComponent(PcareStatusPulangCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new PcareStatusPulangModel();
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
	it ('Renders the PCare Status Pulang CRUD Edit Component', () => {
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
