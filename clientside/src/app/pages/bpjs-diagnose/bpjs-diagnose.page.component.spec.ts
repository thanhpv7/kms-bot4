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

import { BpjsDiagnosePageModule } from './bpjs-diagnose.page.module';
import { BpjsDiagnosePageComponent } from './bpjs-diagnose.page.component';

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

describe('BPJS Diagnose Page Component tests', () => {
	let fixture: ComponentFixture<BpjsDiagnosePageComponent>;
	let componentInstance: BpjsDiagnosePageComponent;

	// % protected region % [Add any additional testing class fields here] off begin
	// % protected region % [Add any additional testing class fields here] end

	beforeEach(async () => {
		let activatedRouteStub = new ActivatedRouteStub();

		// % protected region % [Modify the testing module configuration here] off begin
		TestBed.configureTestingModule({

			imports: [
				BpjsDiagnosePageModule,
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
			fixture = TestBed.createComponent(BpjsDiagnosePageComponent);
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

	it ('renders the BPJS Diagnose Page', () => {
		fixture.detectChanges();
		expect(componentInstance).toBeTruthy();
	});

	it ('renders the BPJS Diagnose Crud Component with id 45f4143b-c145-4311-abc5-bb36c1a7bf83 correctly', () => {
		fixture.detectChanges();
		const crudComponent: DebugElement = fixture.debugElement.query(By.css('cb-bpjs-diagnose-crud#crud-45f4143b-c145-4311-abc5-bb36c1a7bf83'));

		expect(crudComponent).toBeTruthy();
		expect(crudComponent.query(By.css('section > h2')).nativeElement.textContent).toBe('BPJS Diagnose');
	});

	// % protected region % [Add any additional tests to the BPJS Diagnose page component here] off begin
	// % protected region % [Add any additional tests to the BPJS Diagnose page component here] end
});
