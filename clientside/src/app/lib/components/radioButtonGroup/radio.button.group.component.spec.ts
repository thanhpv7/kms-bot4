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
import {CommonComponentModule} from '../common.component.module';
import {RadioButtonGroupComponent} from './radio.button.group.component';
import {Component, DebugElement} from '@angular/core';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Define the tests for the textfield component
 */
const defaultValue = '2';
const testValue = '3';
const options = [
	{
		name: 'test',
		value: '1'
	},
	{
		name: 'test 2',
		value: '2'
	},
	{
		name: 'test 3',
		value: '3'
	},
	{
		name: 'test 4',
		value: '4'
	},
];
const labelValue = 'Test the label';
const id = 'input-radio-group-id';
describe('Radio Button Group component tests', () => {

	let fixture;
	let radioButtonGroup;
	const domTestId = id + '-1';
	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end

	function setupOptions(): void {
		radioButtonGroup.labelField = 'name';
		radioButtonGroup.valueField = 'value';
		radioButtonGroup.name = 'test';
		radioButtonGroup.label = labelValue;
		radioButtonGroup.id = domTestId;
	}

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	beforeEach(waitForAsync (() => {
		TestBed.configureTestingModule({
			declarations: [],
			imports: [
				CommonModule,
				FormsModule,
				ReactiveFormsModule,
				CommonPipeModule,
				CommonComponentModule
			]
		}).compileComponents().then(() => {
			fixture = TestBed.createComponent(RadioButtonGroupComponent);
			radioButtonGroup = fixture.debugElement.componentInstance;
			setupOptions();
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

	it('should create the Radio Button Group component', () => {
		expect(radioButtonGroup).toBeDefined();
	});

	/**
	 * Test whether the component match the standard
	 */
	it('should have label or aria-label to match the standard', () => {
		radioButtonGroup.ngOnChanges();
		fixture.detectChanges();
		const labelElement = fixture.debugElement.query(By.css('label'));
		const buttonsElement = fixture.debugElement.query(By.css('div.radio-group__buttons'));
		expect(labelElement.nativeElement.innerText).toBe(labelValue);
		expect(buttonsElement.nativeElement.hasAttribute('aria-label')).toBeFalsy();


		// just has aria label when labelVisible is false
		radioButtonGroup.isLabelVisible = false;
		radioButtonGroup.ngOnChanges();
		fixture.detectChanges();
		expect(buttonsElement.nativeElement.getAttribute('aria-label')).toBe(labelValue);
		expect(fixture.debugElement.query(By.css('label'))).toBeNull();
	});

	it('should have the dom structure as defined in the standard', () => {
		const standardInputClass = 'input-group-wrapper';
		const standardInputClassBlock = 'input-group-wrapper-block';
		const standardInputClassInline = 'input-group-wrapper-inline';
		const standardInputClassType = 'input-group-wrapper__radio';
		const customClass = 'custom-class';
		const testTooltip = 'test';
		const tooltipId = domTestId + '-tooltip';

		radioButtonGroup.className = customClass;
		radioButtonGroup.tooltip = testTooltip;

		radioButtonGroup.ngOnChanges();
		fixture.detectChanges();

		const labelElement = fixture.debugElement.query(By.css('label')).nativeElement;
		const tooltipElement = fixture.debugElement.query(By.css('div.tooltip')).nativeElement;
		const tooltipText = fixture.debugElement.query(By.css('div.tooltip')).query(By.css('span')).nativeElement;

		expect(fixture.nativeElement).toHaveClass(standardInputClass);
		expect(fixture.nativeElement).toHaveClass(standardInputClassBlock);
		expect(fixture.nativeElement).toHaveClass(customClass);
		expect(fixture.nativeElement).toHaveClass(standardInputClassType);
		expect(fixture.nativeElement).not.toHaveClass(standardInputClassInline);
		// check the field id, tooltip id and check accessibility stdnard
		expect(tooltipElement.id).toBe(tooltipId);
		expect(tooltipText.textContent).toBe(testTooltip);
		expect(labelElement.getAttribute('aria-describedby')).toBe(tooltipId);

		radioButtonGroup.displayType = InputComponentDisplayType.INLINE;
		radioButtonGroup.ngOnChanges();
		fixture.detectChanges();
		expect(fixture.nativeElement).not.toHaveClass(standardInputClassBlock);
		expect(fixture.nativeElement).toHaveClass(standardInputClassInline);
	});

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
});
