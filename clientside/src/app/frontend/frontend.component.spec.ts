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
import {By} from '@angular/platform-browser';
import {FrontendComponent} from './frontend.component';
import {AuthenticationService} from '../lib/services/authentication/authentication.service';
import {FrontendModule} from './frontend.module';
import {provideMockStore} from '@ngrx/store/testing';
import {ToastContainerModule, ToastrModule} from 'ngx-toastr';
import {AlertComponent} from '../lib/components/alert/alert.component';
import {CommonComponentModule} from '../lib/components/common.component.module';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

class MockAuthenticationService {
	get isLoggedIn() {
		return true;
	}

	// % protected region % [Add any additional fields for MockAuthenticationService here] off begin
	// % protected region % [Add any additional fields for MockAuthenticationService here] end
}

describe('Testing Frontend Component for logged in user', () => {

	let fixture: ComponentFixture<FrontendComponent>;
	let frontendComponent: FrontendComponent;

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
					// % protected region % [Add custom routes to the module for logged in user testing] off begin
					// % protected region % [Add custom routes to the module for logged in user testing] end
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
				// % protected region % [Add custom imports to the module for logged in user testing] off begin
				// % protected region % [Add custom imports to the module for logged in user testing] end
			],
			declarations: [
				FrontendComponent,
				// % protected region % [Add custom declarations to the module for logged in user testing] off begin
				// % protected region % [Add custom declarations to the module for logged in user testing] end
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
			// % protected region % [Add custom fields to the module for logged user testing here] off begin
			// % protected region % [Add custom fields to the module for logged user testing here] end
		}).compileComponents().then(() => {

			authenticationService = TestBed.inject(AuthenticationService);
			spyOnProperty(authenticationService, 'isLoggedIn').and.returnValue(true);

			// % protected region % [Add custom logic before creating the component for logged user here] off begin
			// % protected region % [Add custom logic before creating the component for logged user here] end

			fixture = TestBed.createComponent(FrontendComponent);
			frontendComponent = fixture.debugElement.componentInstance;

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

	it('Should display logout button in side bar in frontend page for login user', () => {

		// Stimulate User logged in

		fixture.detectChanges();

		const logoutButton = fixture.debugElement.query(By.css('a.icon-room'));
		expect(logoutButton.nativeElement.attributes.href.value).toBe('/logout');

		// % protected region % [Add custom logic for Should display logout button in side bar in frontend page for login user] off begin
		// % protected region % [Add custom logic for Should display logout button in side bar in frontend page for login user] end

	});

	it('Should not display home page link in page sub links', () => {
		// % protected region % [Add custom logic before main process of Should not display home page link in page sub links for login user] off begin
		// % protected region % [Add custom logic before main process of Should not display home page link in page sub links for login user] end

		fixture.detectChanges();

		const homePageLinks = fixture.debugElement.queryAll(By.css('a[href$="/kms-home"]'));

		// The route of the page marked as home should be '/' not the fully qualified route '/kms-home'
		expect(homePageLinks.length).toBe(0);

		// % protected region % [Add custom logic for Should not display home page link in page sub links for login user] off begin
		// % protected region % [Add custom logic for Should not display home page link in page sub links for login user] end
	});

	it('Frontend page should have button to logout in side bar', () => {
		fixture.detectChanges();

		const logoutButton = fixture.debugElement.query(By.css('a.icon-room'));
		expect(logoutButton.nativeElement.attributes.href.value).toBe('/logout');
	});

	// % protected region % [Add any additional testings for not loggedin user here] off begin
	// % protected region % [Add any additional testings for not loggedin user here] end

});

describe('Testing Frontend Component for anonymous users', () => {

	let fixture: ComponentFixture<FrontendComponent>;
	let frontendComponent: FrontendComponent;

	let authenticationService: AuthenticationService;

	// % protected region % [Add any additional logic before main process of beforeEach for anonymous user here] off begin
	// % protected region % [Add any additional logic before main process of beforeEach for anonymous user here] end

	beforeEach(waitForAsync (() => {

		TestBed.configureTestingModule({
			imports: [
				CommonModule,
				CommonComponentModule,
				ToastContainerModule,
				RouterTestingModule.withRoutes([
					// % protected region % [Add custom routes to the module for anonymous user] off begin
					// % protected region % [Add custom routes to the module for anonymous user] end
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
				// % protected region % [Add custom imports to the module for anonymous user] off begin
				// % protected region % [Add custom imports to the module for anonymous user] end

			],
			declarations: [
				FrontendComponent,
				// % protected region % [Add custom declarations to the module for anonymous user] off begin
				// % protected region % [Add custom declarations to the module for anonymous user] end
			],
			providers: [
				{
					provide: AuthenticationService,
					useClass: MockAuthenticationService
				},
				provideMockStore(),
				// % protected region % [Add custom providers to the module for anonymous user] off begin
				// % protected region % [Add custom providers to the module for anonymous user] end
			],
			// % protected region % [Add custom fields to the module for anonymous user testing here] off begin
			// % protected region % [Add custom fields to the module for anonymous user testing here] end
		}).compileComponents().then(() => {

			// % protected region % [Add any additional logic before creating component for anonymous user here] off begin
			// % protected region % [Add any additional logic before creating component for anonymous user here] end

			authenticationService = TestBed.inject(AuthenticationService);
			spyOnProperty(authenticationService, 'isLoggedIn', 'get').and.returnValue(false);

			fixture = TestBed.createComponent(FrontendComponent);
			frontendComponent = fixture.debugElement.componentInstance;

			// % protected region % [Add any additional logic after creating component for anonymous user here] off begin
			// % protected region % [Add any additional logic after creating component for anonymous user here] end
		});
	}));

	afterEach(() => {
		// Need to do this since for some reason the last component queried from the fixture will be rendered on the
		// browser
		if (fixture.nativeElement instanceof HTMLElement) {
			(fixture.nativeElement as HTMLElement).remove();
		}

		// % protected region % [Add any additional logic after removing component for anonymous user here] off begin
		// % protected region % [Add any additional logic after removing component for anonymous user here] end
	});

	// TODO Discuss a standard behavior to display navigation bar.
	it('Should not display logout button in side bar in frontend page for anonymous user', () => {

		fixture.detectChanges();

		const logoutButton = fixture.debugElement.query(By.css('a.icon-room'));
		expect(logoutButton).toBeNull();

		// % protected region % [Add any additional logic for Should not display logout button in side bar in frontend page for anonymous user] off begin
		// % protected region % [Add any additional logic for Should not display logout button in side bar in frontend page for anonymous user] end
	});

	// % protected region % [Add any additional testings for not anonymous user here] off begin
	// % protected region % [Add any additional testings for not anonymous user here] end
});
