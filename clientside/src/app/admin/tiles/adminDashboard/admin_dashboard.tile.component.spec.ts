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

import {waitForAsync, ComponentFixture, TestBed} from '@angular/core/testing';
import {CommonModule} from '@angular/common';
import {RouterTestingModule} from '@angular/router/testing';
import {AuthenticationService} from '../../../lib/services/authentication/authentication.service';
import {provideMockStore} from '@ngrx/store/testing';
import {ToastContainerModule, ToastrModule} from 'ngx-toastr';
import { AlertComponent } from '../../../lib/components/alert/alert.component';
import {By} from '@angular/platform-browser';
import {CommonComponentModule} from '../../../lib/components/common.component.module';
import { AdminDashboardTileComponent } from './admin_dashboard.tile.component';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

class MockAuthenticationService {
	get isLoggedIn() {
		return true;
	}

	// % protected region % [Add any additional fields for MockAuthenticationService here] off begin
	// % protected region % [Add any additional fields for MockAuthenticationService here] end
}

describe('Testing Admin Dashboard Component for logged in user', () => {

	let fixture: ComponentFixture<AdminDashboardTileComponent>;
	let adminDashboardTileComponent: AdminDashboardTileComponent;

	let authenticationService: AuthenticationService;

	// % protected region % [Add any additional variables for logged in user here] off begin
	// % protected region % [Add any additional variables for logged in user here] end

	beforeEach(waitForAsync (() => {

		// % protected region % [Add any additional logic before main process of beforeEach for logged user here] off begin
		// % protected region % [Add any additional logic before main process of beforeEach for logged user here] end

		TestBed.configureTestingModule({
			imports: [
				CommonModule,
				CommonComponentModule,
				ToastContainerModule,
				RouterTestingModule.withRoutes([
					// % protected region % [Add custom routes for Testing Admin Component for logged in user] off begin
					// % protected region % [Add custom routes for Testing Admin Component for logged in user] end
				]),
				ToastrModule.forRoot({
					toastComponent: AlertComponent,
					iconClasses: {
						success: 'alert__success',
						info: 'alert__info',
						warning: 'alert__warning',
						error: 'alert__danger'
					},
					toastClass: '',
					positionClass: 'alert-container',
					preventDuplicates: true,
				}),
				// % protected region % [Add custom imports to the module in Testing Admin Component for logged in user] off begin
				// % protected region % [Add custom imports to the module in Testing Admin Component for logged in user] end
			],
			declarations: [
				AdminDashboardTileComponent,
				// % protected region % [Add custom declarations to the module in Testing Admin Component for logged in user] off begin
				// % protected region % [Add custom declarations to the module in Testing Admin Component for logged in user] end
			],
			providers: [
				{
					provide: AuthenticationService,
					useClass: MockAuthenticationService
				},
				provideMockStore(),
				// % protected region % [Add custom providers to the module logged user here] off begin
				// % protected region % [Add custom providers to the module logged user here] end
			],
			// % protected region % [Add custom fields to the module logged user here] off begin
			// % protected region % [Add custom fields to the module logged user here] end
		}).compileComponents().then(() => {

			authenticationService = TestBed.inject(AuthenticationService);
			spyOnProperty(authenticationService, 'isLoggedIn').and.returnValue(true);

			// % protected region % [Add custom logic before creating the component for logged user here] off begin
			// % protected region % [Add custom logic before creating the component for logged user here] end

			fixture = TestBed.createComponent(AdminDashboardTileComponent);
			adminDashboardTileComponent = fixture.debugElement.componentInstance;
			fixture.detectChanges();

			// % protected region % [Add custom logic after creating the component for logged user here] off begin
			// % protected region % [Add custom logic after creating the component for logged user here] end
		});
	}));

	afterEach(() => {
		// % protected region % [Add custom logic before main process of afterEach for logged user here] off begin
		// % protected region % [Add custom logic before main process of afterEach for logged user here] end

		// Need to do this since for some reason the last component queried from the fixture will be rendered on the
		// browser
		if (fixture.nativeElement instanceof HTMLElement) {
			(fixture.nativeElement as HTMLElement).remove();
		}

		// % protected region % [Add custom logic after main process of afterEach for logged user here] off begin
		// % protected region % [Add custom logic after main process of afterEach for logged user here] end
	});

	// % protected region % [Customise your admin dashboard button tests here] off begin
	it ('Renders the Dashboard Component', () => {
		expect(adminDashboardTileComponent).toBeTruthy();
	});

	it ('Renders Dashboard Cards Element', () => {
		const dashboardCards = fixture.debugElement.query(By.css('div.dashboard-cards'));

		expect(dashboardCards).toBeTruthy();
	});

	/**
	 * This test checks that the correct number of cards are added, and of the correct types
	 * It will need to be updated if cards are added or removed at a future date
	 */
	it ('Renders Cards within Dashboard Cards Element', () => {
		const dashboardCardsWrap = fixture.debugElement.query(By.css('div.dashboard-cards'));

		const cardsArray = dashboardCardsWrap.queryAll(By.css('div.card.card--rounded'));

		// Current Number of cards in tile
		expect(cardsArray.length).toBe(5);
	});

	it ('Renders the Graphiql card correctly', () => {
		const dashboardCardsWrap = fixture.debugElement.query(By.css('div.dashboard-cards'));

		const card = dashboardCardsWrap.query(By.css('div.card.card--rounded#graphiql-card'));

		expect(card).toBeTruthy();

		expect(card.query(By.css('h4')).nativeElement.textContent).toBe('View GraphiQL');
		expect(card.query(By.css('div.icon.icon-globe'))).toBeTruthy();
	});

	it ('Renders the Swagger card correctly', () => {
		const dashboardCardsWrap = fixture.debugElement.query(By.css('div.dashboard-cards'));

		const card = dashboardCardsWrap.query(By.css('div.card.card--rounded#swagger-card'));

		expect(card).toBeTruthy();

		expect(card.query(By.css('h4')).nativeElement.textContent).toBe('View OpenAPI');
		expect(card.query(By.css('div.icon.icon-api'))).toBeTruthy();
	});

	it ('Renders the Git card correctly', () => {
		const dashboardCardsWrap = fixture.debugElement.query(By.css('div.dashboard-cards'));

		const card = dashboardCardsWrap.query(By.css('div.card.card--rounded#git-card'));

		expect(card).toBeTruthy();

		expect(card.query(By.css('h4')).nativeElement.textContent).toBe('View Git');
		expect(card.query(By.css('div.icon.icon-git-merge'))).toBeTruthy();
	});

	it ('Renders the Voyager card correctly', () => {
		const dashboardCardsWrap = fixture.debugElement.query(By.css('div.dashboard-cards'));

		const card = dashboardCardsWrap.query(By.css('div.card.card--rounded#voyager-card'));

		expect(card).toBeTruthy();

		expect(card.query(By.css('h4')).nativeElement.textContent).toBe('View Voyager');
		expect(card.query(By.css('div.icon.icon-satellite'))).toBeTruthy();
	});

	it ('Renders the Academy card correctly', () => {
		const dashboardCardsWrap = fixture.debugElement.query(By.css('div.dashboard-cards'));

		const card = dashboardCardsWrap.query(By.css('div.card.card--rounded#academy-card'));

		expect(card).toBeTruthy();

		expect(card.query(By.css('h4')).nativeElement.textContent).toBe('Want to learn more?');

	});
	// % protected region % [Customise your admin dashboard button tests here] end
});
