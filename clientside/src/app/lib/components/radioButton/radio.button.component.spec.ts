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
import {CommonPipeModule} from '../../pipes/common.pipe.module';
import {InputComponentDisplayType} from '../abstract.input.component';
import {RadioButtonComponent} from './radio.button.component';
import {CommonComponentModule} from '../common.component.module';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Define the tests for the textfield component
 */
describe('RadioButton component against tests', () => {

	let fixture;
	let radioButtonComponent;

	// Default id and label are used to ensure that errors don't occur for the component not having an id or label
	// Errors don't affect the running of the tests, but do clog up the console with unnecessary output
	// These values can be overwritten by any test which tests specific values
	let defaultId = 'default-id';
	let defaultLabel = 'default label';

	beforeEach(waitForAsync (() => {
		TestBed.configureTestingModule({
			declarations: [
			],
			imports: [
				CommonModule,
				FormsModule,
				ReactiveFormsModule,
				CommonPipeModule,
				CommonComponentModule
			]
		}).compileComponents().then(() => {
			fixture = TestBed.createComponent(RadioButtonComponent);
			radioButtonComponent = fixture.debugElement.componentInstance;
			radioButtonComponent.id = defaultId;
			radioButtonComponent.label = defaultLabel;
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

	it('should create the radiobutton component', () => {
		expect(radioButtonComponent).toBeTruthy();
	});

	/**
	 * Test whether the component match the standard
	 */
	it('should have label or aria-label to match the standard', () => {
		const labelValue = 'Test the label';
		const id = 'input-text-id';
		const fieldId = id + '-field';
		radioButtonComponent.label = labelValue;
		radioButtonComponent.id = id;
		radioButtonComponent.ngOnChanges();
		fixture.detectChanges();
		const labelElement = fixture.debugElement.query(By.css('label'));
		const inputElement = fixture.debugElement.query(By.css('input'));
		// check whether the for attribute is matched
		expect(labelElement.nativeElement.getAttribute('for')).toBe(fieldId);
		expect(labelElement.nativeElement.innerText || labelElement.nativeElement.textContent).toBe(labelValue);
		expect(inputElement.nativeElement.id).toBe(fieldId);
		expect(inputElement.nativeElement.hasAttribute('aria-label')).toBeFalsy();

		// just has aria label when labelVislbe is false
		radioButtonComponent.isLabelVisible = false;
		radioButtonComponent.ngOnChanges();
		fixture.detectChanges();
		expect(inputElement.nativeElement.getAttribute('aria-label')).toBe(labelValue);
		expect(fixture.debugElement.query(By.css('label'))).toBeNull();

	});

	it('should have the dom structure as defined in the standard', () => {
		const standardInputClass = 'input-group';
		const standardInputClassBlock = 'input-group-block';
		const standardInputClassInline = 'input-group-inline';
		const standardInputLabelClass = 'input-group__label';
		const standardInputFieldClass = 'input-group__radio';
		const customClass = 'custom-class';
		const labelValue = 'Test the label';
		const id = 'input-text-id';
		const fieldId = id + '-field';

		radioButtonComponent.label = labelValue;
		radioButtonComponent.id = id;
		radioButtonComponent.className = customClass;
		radioButtonComponent.ngOnChanges();
		fixture.detectChanges();

		const radioButtonComponentElement = fixture.debugElement.nativeElement;
		const labelElement = fixture.debugElement.query(By.css('label')).nativeElement;
		const inputElement = fixture.debugElement.query(By.css('input')).nativeElement;

		expect(radioButtonComponentElement.classList).toContain(standardInputClass);
		expect(radioButtonComponentElement.classList).toContain(standardInputClassBlock);
		expect(radioButtonComponentElement.classList).toContain(customClass);
		expect(radioButtonComponentElement.classList).not.toContain(standardInputClassInline);
		expect(labelElement.classList).toContain(standardInputLabelClass);
		expect(inputElement.classList).toContain(standardInputFieldClass);
		// check the field id and check accessibility standard
		expect(inputElement.id).toBe(fieldId);

		radioButtonComponent.displayType = InputComponentDisplayType.INLINE;
		radioButtonComponent.ngOnChanges();
		fixture.detectChanges();
		expect(radioButtonComponentElement.classList).not.toContain(standardInputClassBlock);
		expect(radioButtonComponentElement.classList).toContain(standardInputClassInline);
	});

	it('should have the dom structure defined in the standard when the required is set to false', () => {

		// when the isRequired is set to false
		fixture.detectChanges();
		const inputElement = fixture.debugElement.query(By.css('input')).nativeElement;
		expect(inputElement.hasAttribute('required')).toBeFalsy();

		// when the isRequired is set to true
		radioButtonComponent.isRequired = true;
		radioButtonComponent.ngOnChanges();
		fixture.detectChanges();
		expect(inputElement.hasAttribute('required')).toBeTruthy();
	});

	it('should have the readOnly attribute when disabled is set to true', () => {
		fixture.detectChanges();
		const inputElement = fixture.debugElement.query(By.css('input')).nativeElement;
		expect(inputElement.hasAttribute('disabled')).toBeFalsy();

		radioButtonComponent.isDisabled = true;
		radioButtonComponent.ngOnChanges();
		fixture.detectChanges();
		expect(inputElement.hasAttribute('disabled')).toBeTruthy();
	});
});
