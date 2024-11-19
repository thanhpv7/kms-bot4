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

import { SatuSehatGeneralPageModule } from './satu-sehat-general.page.module';
import { SatuSehatGeneralPageComponent } from './satu-sehat-general.page.component';

import { TestBed } from '@angular/core/testing';
import { waitForAsync } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ActivatedRoute, ChildrenOutletContexts } from '@angular/router';
import { provideMockStore } from '@ngrx/store/testing';
import { ModalDialogService, ModalDialogInstanceService } from '@preeco-privacy/ngx-modal-dialog';
import { CookieService } from 'ngx-cookie-service';
import { ActivatedRouteStub } from 'src/testing/helpers/activated-route-stub';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';
import { ComponentFixture } from '@angular/core/testing';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

describe('Satu Sehat General Page Component tests', () => {
	let fixture: ComponentFixture<SatuSehatGeneralPageComponent>;
	let componentInstance: SatuSehatGeneralPageComponent;

	// % protected region % [Add any additional testing class fields here] off begin
	// % protected region % [Add any additional testing class fields here] end

	beforeEach(async () => {
		let activatedRouteStub = new ActivatedRouteStub();

		// % protected region % [Modify the testing module configuration here] off begin
		TestBed.configureTestingModule({

			imports: [
				SatuSehatGeneralPageModule,
				HttpClientTestingModule,
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
				ChildrenOutletContexts,
			]
		}).compileComponents().then(() => {
			fixture = TestBed.createComponent(SatuSehatGeneralPageComponent);
			componentInstance = fixture.debugElement.componentInstance;
		});
		// % protected region % [Modify the testing module configuration here] end
	});

	// % protected region % [Add any additional testing configuration methods here] off begin
	// % protected region % [Add any additional testing configuration methods here] end

	afterEach(() => {
		// % protected region % [Add any additional logic to AfterEach here] off begin
		// % protected region % [Add any additional logic to AfterEach here] end
		fixture.destroy();
	});

	it ('renders the Satu Sehat General Page', () => {
		fixture.detectChanges();
		expect(componentInstance).toBeTruthy();
	});

	it ('renders the Satu Sehat Configuration Crud Component with id 67985be3-932c-4766-b702-5e6c2ac6e2af correctly', () => {
		fixture.detectChanges();
		const crudComponent: DebugElement = fixture.debugElement.query(By.css('cb-satu-sehat-configuration-crud#crud-67985be3-932c-4766-b702-5e6c2ac6e2af'));

		expect(crudComponent).toBeTruthy();
		expect(crudComponent.query(By.css('section > h2')).nativeElement.textContent).toBe('Satu Sehat Configuration');
	});

	// % protected region % [Add any additional tests to the Satu Sehat General page component here] off begin
	// % protected region % [Add any additional tests to the Satu Sehat General page component here] end
});
