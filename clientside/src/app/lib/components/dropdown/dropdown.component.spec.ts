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

import {CommonModule} from '@angular/common';
import {waitForAsync, TestBed} from '@angular/core/testing';
import {By} from '@angular/platform-browser';
import {CommonComponentModule} from '../common.component.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {InputComponentDisplayType} from '../abstract.input.component';
import {DropdownComponent} from './dropdown.component';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Tests for the dropdown component
 */
describe('Dropdown component tests', () => {

	let fixture;
	let dropdownComponent: DropdownComponent;

	let defaultId = 'defaultId';
	let defaultLabel = 'default label';
	let defaultOptions: string[] = [
		'first',
		'second',
		'third',
		'fourth'
	];

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end

	beforeEach(waitForAsync (() => {
		TestBed.configureTestingModule({
			declarations: [
			],
			imports: [
				CommonModule,
				FormsModule,
				ReactiveFormsModule,
				CommonComponentModule
			]
		}).compileComponents().then(() => {
			fixture = TestBed.createComponent(DropdownComponent);
			dropdownComponent = fixture.debugElement.componentInstance;
			dropdownComponent.id = defaultId;
			dropdownComponent.label = defaultLabel;
			dropdownComponent.options = defaultOptions;
			dropdownComponent.ngOnChanges({});
			fixture.detectChanges();
		});
	}));

	afterEach(() => {
		// Need to do this since for some reason the last component queried from the fixture will be rendered on the
		// browser
		if (fixture.nativeElement instanceof HTMLElement) {
			(fixture.nativeElement as HTMLElement).remove();
		}
	});

	it('should create the dropdown component', () => {
		expect(dropdownComponent).toBeTruthy();
	});

	/**
	 * Test whether the component match the standard
	 */
	it('should have label or aria-label to match the standard', () => {
		const labelValue = 'Test the label';
		const id = 'input-text-id';
		const fieldId = id + '-field';
		dropdownComponent.label = labelValue;
		dropdownComponent.id = id;
		dropdownComponent.ngOnChanges({});
		fixture.detectChanges();
		const labelElement = fixture.debugElement.query(By.css('label'));
		const dropdownElement = fixture.debugElement.query(By.css('ng-select'));
		// check whether the for attribute is matched
		expect(labelElement.nativeElement.getAttribute('for')).toBe(fieldId);
		expect(labelElement.nativeElement.innerText || labelElement.nativeElement.textContent).toBe(labelValue);
		expect(dropdownElement.nativeElement.id).toBe(fieldId);
		expect(dropdownElement.nativeElement.hasAttribute('aria-label')).toBeFalsy();

		// just has aria label when labelVislbe is false
		dropdownComponent.isLabelVisible = false;
		dropdownComponent.ngOnChanges({});
		fixture.detectChanges();
		expect(dropdownElement.nativeElement.getAttribute('aria-label')).toBe(labelValue);
		expect(fixture.debugElement.query(By.css('label'))).toBeNull();

	});

	it('should have the dom structure as defined in the standard', () => {
		const standardInputClass = 'input-group';
		const standardInputClassBlock = 'input-group-block';
		const standardInputClassInline = 'input-group-inline';
		const standardInputType = 'input-group__dropdown';
		const customClass = 'custom-class';
		const labelValue = 'Test the label';
		const id = 'input-text-id';
		const fieldId = id + '-field';
		const testTooltip = 'test';
		const tooltipId = id + '-tooltip';

		dropdownComponent.label = labelValue;
		dropdownComponent.id = id;
		dropdownComponent.className = customClass;
		dropdownComponent.tooltip = testTooltip;
		dropdownComponent.ngOnChanges({});
		fixture.detectChanges();

		const dropdownComponentElement = fixture.debugElement.nativeElement;
		const labelElement = fixture.debugElement.query(By.css('label')).nativeElement;
		const dropdownElement = fixture.debugElement.query(By.css('ng-select')).nativeElement;
		const tooltipElement = fixture.debugElement.query(By.css('div.tooltip')).nativeElement;
		const tooltipText = fixture.debugElement.query(By.css('div.tooltip'))
			.query(By.css('span')).nativeElement;
		expect(dropdownComponentElement.classList).toContain(standardInputClass);
		expect(dropdownComponentElement.classList).toContain(standardInputClassBlock);
		expect(dropdownComponentElement.classList).toContain(customClass);
		expect(dropdownComponentElement.classList).toContain(standardInputType);
		expect(dropdownComponentElement.classList).not.toContain(standardInputClassInline);
		// check the field id, tooltip id and check accessibility stdnard
		expect(dropdownElement.id).toBe(fieldId);
		expect(tooltipElement.id).toBe(tooltipId);
		expect(tooltipText.textContent).toBe(testTooltip);
		expect(labelElement.getAttribute('aria-describedby')).toBe(tooltipId);

		dropdownComponent.displayType = InputComponentDisplayType.INLINE;
		dropdownComponent.ngOnChanges({});
		fixture.detectChanges();
		expect(dropdownComponentElement.classList).not.toContain(standardInputClassBlock);
		expect(dropdownComponentElement.classList).toContain(standardInputClassInline);
	});

	it('should have the dom structure defined in the standard when the required is set to false', () => {
		const standardInputClassRequired = 'input-group--is-required';

		// when the isRequired is set to false
		fixture.detectChanges();
		const dropdownComponentElement = fixture.debugElement.nativeElement;
		const dropdownElement = fixture.debugElement.query(By.css('ng-select')).nativeElement;
		expect(dropdownComponentElement.classList).not.toContain(standardInputClassRequired);

		// when the isRequired is set to true
		dropdownComponent.isRequired = true;
		dropdownComponent.ngOnChanges({});
		fixture.detectChanges();
		expect(dropdownComponentElement.classList).toContain(standardInputClassRequired);
	});

	it('should have the disabled attribute when isDisabled is set to true', () => {
		dropdownComponent.isComponentDisabled = false;
		dropdownComponent.ngOnChanges({});
		fixture.detectChanges();
		const inputElement = fixture.debugElement.query(By.css('input')).nativeElement;
		expect(inputElement.hasAttribute('disabled')).toBeFalsy();

		dropdownComponent.isComponentDisabled = true;
		dropdownComponent.ngOnChanges({});
		fixture.detectChanges();
		expect(inputElement.hasAttribute('disabled')).toBeTruthy();
	});

	// % protected region % [Add any additional custom test cases here] off begin
	// % protected region % [Add any additional custom test cases here] end
});
