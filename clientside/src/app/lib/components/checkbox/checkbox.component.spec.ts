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
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {By} from '@angular/platform-browser';
import {CheckboxComponent} from './checkbox.component';
import {CommonPipeModule} from '../../pipes/common.pipe.module';
import {InputComponentDisplayType} from '../abstract.input.component';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Define the tests for the checkbox component
 */
describe('Checkbox component against tests', () => {

	let fixture;
	let checkboxComponent;
	let defaultId = 'defaultId';
	let defaultLabel = 'Default Label';

	// % protected region % [Add any additional variables here] off begin
	// % protected region % [Add any additional variables here] end

	beforeEach(waitForAsync (() => {
		TestBed.configureTestingModule({
			declarations: [
				CheckboxComponent,
			],
			imports: [
				CommonModule,
				FormsModule,
				ReactiveFormsModule,
				CommonPipeModule
			]
		}).compileComponents().then(() => {
			fixture = TestBed.createComponent(CheckboxComponent);
			checkboxComponent = fixture.debugElement.componentInstance;
			checkboxComponent.id = defaultId;
			checkboxComponent.label = defaultLabel;
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

	it('should create the checkbox component', () => {
		expect(checkboxComponent).toBeTruthy();
	});

	/**
	 * Test whether the component match the standard
	 */
	it('should have label or aria-label to match the standard', () => {
		const labelValue = 'Test the label';
		const id = 'input-text-id';
		const fieldId = id + '-field';
		checkboxComponent.label = labelValue;
		checkboxComponent.id = id;
		checkboxComponent.ngOnChanges();
		fixture.detectChanges();
		const labelElement = fixture.debugElement.query(By.css('label'));
		const inputElement = fixture.debugElement.query(By.css('input'));
		// check whether the for attribute is matched
		expect(labelElement.nativeElement.getAttribute('for')).toBe(fieldId);
		expect(labelElement.nativeElement.innerText || labelElement.nativeElement.textContent).toBe(labelValue);
		expect(inputElement.nativeElement.id).toBe(fieldId);
		expect(inputElement.nativeElement.hasAttribute('aria-label')).toBeFalsy();

		// just has aria label when labelVislbe is false
		checkboxComponent.isLabelVisible = false;
		checkboxComponent.ngOnChanges();
		fixture.detectChanges();
		expect(inputElement.nativeElement.getAttribute('aria-label')).toBe(labelValue);
		expect(fixture.debugElement.query(By.css('label'))).toBeNull();

	});

	it('should have the dom structure as defined in the standard', () => {
		const standardInputClass = 'input-group';
		const standardInputClassBlock = 'input-group-block';
		const standardInputClassInline = 'input-group-inline';
		const standardInputTypeClass = 'input-group__checkbox';
		const customClass = 'custom-class';
		const labelValue = 'Test the label';
		const id = 'input-text-id';
		const fieldId = id + '-field';
		const testTooltip = 'test';
		const tooltipId = id + '-tooltip';

		checkboxComponent.label = labelValue;
		checkboxComponent.id = id;
		checkboxComponent.className = customClass;
		checkboxComponent.tooltip = testTooltip;
		checkboxComponent.ngOnChanges();
		fixture.detectChanges();

		const checkboxComponentElement = fixture.debugElement.nativeElement;
		const labelElement = fixture.debugElement.query(By.css('label')).nativeElement;
		const inputElement = fixture.debugElement.query(By.css('input')).nativeElement;
		const tooltipElement = fixture.debugElement.query(By.css('div.tooltip')).nativeElement;
		const tooltipText = fixture.debugElement.query(By.css('div.tooltip'))
																						.query(By.css('span')).nativeElement;

		expect(checkboxComponentElement.classList).toContain(standardInputClass);
		expect(checkboxComponentElement.classList).toContain(standardInputClassBlock);
		expect(checkboxComponentElement.classList).toContain(customClass);
		expect(checkboxComponentElement.classList).not.toContain(standardInputClassInline);
		expect(checkboxComponentElement.classList).toContain(standardInputTypeClass);
		// check the field id, tooltip id and check accessibility stdnard
		expect(inputElement.id).toBe(fieldId);
		expect(tooltipElement.id).toBe(tooltipId);
		expect(tooltipText.textContent).toBe(testTooltip);
		expect(labelElement.getAttribute('aria-describedby')).toBe(tooltipId);

		checkboxComponent.displayType = InputComponentDisplayType.INLINE;
		checkboxComponent.ngOnChanges();
		fixture.detectChanges();
		expect(checkboxComponentElement.classList).not.toContain(standardInputClassBlock);
		expect(checkboxComponentElement.classList).toContain(standardInputClassInline);
	});

	it('should have the dom structure defined in the standard when the required is set to false', () => {
		const standardInputClassRequired = 'input-group--is-required';

		// when the isRequired is set to false
		fixture.detectChanges();
		const checkboxComponentElement = fixture.debugElement.nativeElement;
		const inputElement = fixture.debugElement.query(By.css('input')).nativeElement;
		expect(checkboxComponentElement.classList).not.toContain(standardInputClassRequired);
		expect(inputElement.hasAttribute('required')).toBeFalsy();

		// when the isRequired is set to true
		checkboxComponent.isRequired = true;
		checkboxComponent.ngOnChanges();
		fixture.detectChanges();
		expect(inputElement.hasAttribute('required')).toBeTruthy();
		expect(checkboxComponentElement.classList).toContain(standardInputClassRequired);
	});

	it('should have the readOnly attribute when disabled is set to true', () => {
		fixture.detectChanges();
		const inputElement = fixture.debugElement.query(By.css('input')).nativeElement;
		expect(inputElement.hasAttribute('disabled')).toBeFalsy();

		checkboxComponent.isDisabled = true;
		checkboxComponent.ngOnChanges();
		fixture.detectChanges();
		expect(inputElement.hasAttribute('disabled')).toBeTruthy();
	});

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
});