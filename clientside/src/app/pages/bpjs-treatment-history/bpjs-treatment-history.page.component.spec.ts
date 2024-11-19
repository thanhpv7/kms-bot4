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

import { BpjsTreatmentHistoryPageModule } from './bpjs-treatment-history.page.module';
import { BpjsTreatmentHistoryPageComponent } from './bpjs-treatment-history.page.component';

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

describe('BPJS Treatment History Page Component tests', () => {
	let fixture: ComponentFixture<BpjsTreatmentHistoryPageComponent>;
	let componentInstance: BpjsTreatmentHistoryPageComponent;

	// % protected region % [Add any additional testing class fields here] off begin
	// % protected region % [Add any additional testing class fields here] end

	beforeEach(async () => {
		let activatedRouteStub = new ActivatedRouteStub();

		// % protected region % [Modify the testing module configuration here] off begin
		TestBed.configureTestingModule({

			imports: [
				BpjsTreatmentHistoryPageModule,
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
			fixture = TestBed.createComponent(BpjsTreatmentHistoryPageComponent);
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

	it ('renders the BPJS Treatment History Page', () => {
		fixture.detectChanges();
		expect(componentInstance).toBeTruthy();
	});

	it ('renders the BPJS Treatment History Crud Component with id b1b6debb-7f36-4b0f-8695-9d2efe9ef680 correctly', () => {
		fixture.detectChanges();
		const crudComponent: DebugElement = fixture.debugElement.query(By.css('cb-bpjs-treatment-history-crud#crud-b1b6debb-7f36-4b0f-8695-9d2efe9ef680'));

		expect(crudComponent).toBeTruthy();
		expect(crudComponent.query(By.css('section > h2')).nativeElement.textContent).toBe('BPJS Treatment History');
	});

	// % protected region % [Add any additional tests to the BPJS Treatment History page component here] off begin
	// % protected region % [Add any additional tests to the BPJS Treatment History page component here] end
});
