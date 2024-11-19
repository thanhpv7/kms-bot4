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

import {Component, EventEmitter, forwardRef, HostBinding,
	SimpleChanges, Input, OnInit, OnChanges, Output, AfterViewInit, Injector} from '@angular/core';
import {AbstractInputComponent, InputClassPrefix} from '../abstract.input.component';
import {ControlValueAccessor, NG_VALUE_ACCESSOR, NgControl} from '@angular/forms';
import {FileModel} from '../../models/file.model';
import { ButtonStyle } from '../button/button.component';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * The types of the textfield
 */
export enum TextfieldType {
	EMAIL = 'email',
	TEXT = 'text',
	NUMBER = 'number',
	PASSWORD = 'password'
}

/**
 * Textfield Component
 */
@Component({
	// % protected region % [Modify the existing component configurations here] off begin
	selector: 'cb-textfield, *[cb-textfield]',
	templateUrl: './textfield.component.html',
	providers: [{
		provide: NG_VALUE_ACCESSOR,
		useExisting: forwardRef(() => TextfieldComponent),
		multi: true
	}],
	// % protected region % [Modify the existing component configurations here] end
	styleUrls: [
		'./textfield.component.scss',
		// % protected region % [Add any additional SCSS imports here] off begin
		// % protected region % [Add any additional SCSS imports here] end
	],
	// % protected region % [Add any additional component configurations here] off begin
	// % protected region % [Add any additional component configurations here] end
})
export class TextfieldComponent extends AbstractInputComponent implements OnInit, OnChanges, ControlValueAccessor {
	public readonly TextfieldType = TextfieldType;
	public readonly ButtonStyle = ButtonStyle;

	/**
	 * Whether the component is an input or an input group
	 */
	protected classPrefix = InputClassPrefix.INPUT;

	/**
	 * Parameter to decide whether the password should be shown or hidden
	 * This will determine the default value, which is then toggled by the toggleShowPassword() method
	 */
	 @Input()
	 showPassword = false;

	/**
	 * The type of the component, which would be used in the css class of the dom
	 */
	protected componentType = 'textfield';

	/**
	 * The text displayed in placeholder
	 */
	@Input()
	placeholder: any = '';

	/**
	 * Emitter to broadcast value of the textfield keyup event
	 */
	@Output()
	keyUp: EventEmitter<any> = new EventEmitter();

	/**
	 * Icon to be put at the end of the text field.
	 */
	@Input()
	iconClasses: string;

	/**
	 * Type of the input element.
	 */
	@Input('inputType')
	type: TextfieldType = TextfieldType.TEXT;

	/**
	 * The Default value for the textfield to display
	 */
	@Input()
	defaultValue = '';

	/**
	 * Whether to show password strength meter
	 * Default to be false
	 */
	@Input()
	showPasswordStrengthMeter = false;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Default constructor for the textfield
	 */
	constructor(
		protected  injector: Injector,
		// % protected region % [Add any additional DI here] off begin
		// % protected region % [Add any additional DI here] end
	) {
		// % protected region % [Add any additional constructor logic before default process here] off begin
		// % protected region % [Add any additional constructor logic before default process here] end

		super(injector);

		// % protected region % [Add any additional constructor logic after default process here] off begin
		// % protected region % [Add any additional constructor logic after default process here] end
	}

	// % protected region % [Add any additional class constructors here] off begin
	// % protected region % [Add any additional class constructors here] end

	/**
	 * @inheritDoc
	 */
	ngOnInit(): void {
		// % protected region % [Add any additional ngOnInit logic before default process here] off begin
		// % protected region % [Add any additional ngOnInit logic before default process here] end

		super.ngOnInit();

		// % protected region % [Add any additional ngOnInit logic after default process here] off begin
		// % protected region % [Add any additional ngOnInit logic after default process here] end
	}

	/**
	 * Trigger when @Input change
	 */
	ngOnChanges(changes: SimpleChanges): void {
		// % protected region % [Add any additional ngOnChange logic before default process here] off begin
		// % protected region % [Add any additional ngOnChange logic before default process here] end

		super.ngOnChanges(changes);

		// % protected region % [Add any additional ngOnChange logic after default process here] off begin
		// % protected region % [Add any additional ngOnChange logic after default process here] end
	}

	/**
	 * Triggered whenever the user releases a key.
	 */
	onKeyUp() {
		// % protected region % [Add any additional onKeyUp logic before broadcasting the event here] off begin
		// % protected region % [Add any additional onKeyUp logic before broadcasting the event here] end

		this.keyUp.emit(this.value);

		// % protected region % [Add any additional onKeyUp logic after broadcasted the event here] off begin
		// % protected region % [Add any additional onKeyUp logic after broadcasted the event here] end
	}

	/**
	 * Sets the model value. Implemented as part of ControlValueAccessor.
	 * This would be called when the value of the ngModel / formControl
	 */
	writeValue(value: any) {
		// % protected region % [Add any additional ngOnChange logic before write value] off begin
		// % protected region % [Add any additional ngOnChange logic before write value] end

		this.value = value;

		// % protected region % [Add any additional ngOnChange logic after write value] off begin
		// % protected region % [Add any additional ngOnChange logic after write value] end
	}

	/**
	 * Registers a callback to be triggered when the model value changes.
	 * Implemented as part of ControlValueAccessor.
	 * @param fn Callback to be registered.
	 */
	registerOnChange(fn: (value: any) => void) {
		// % protected region % [Add any additional logic before register on change] off begin
		// % protected region % [Add any additional logic before register on change] end

		this.controlValueAccessorChangeFn = fn;

		// % protected region % [Add any additional logic after register on change] off begin
		// % protected region % [Add any additional logic after register on change] end
	}

	/**
	 * Registers a callback to be triggered when the control is touched.
	 * Implemented as part of ControlValueAccessor.
	 * @param fn Callback to be registered.
	 */
	registerOnTouched(fn: any) {
		// % protected region % [Add any additional logic before register on touch] off begin
		// % protected region % [Add any additional logic before register on touch] end

		this.onTouched = fn;

		// % protected region % [Add any additional logic after register on touch] off begin
		// % protected region % [Add any additional logic after register on touch] end
	}

	/**
	 * Listen to the event when user type into the input
	 */
	textFieldInputChange($event) {
		// % protected region % [Add any additional logic before textfield input event] off begin
		// % protected region % [Add any additional logic before textfield input event] end

		this.value = $event.target.value;
		this.controlValueAccessorChangeFn(this.value);

		// % protected region % [Add any additional logic after textfield input event] off begin
		// % protected region % [Add any additional logic after textfield input event] end
	}

	/**
	 * Sets the 'disabled' property on the input element.
	 * This would be set with the form control
	 * @param isDisabled The disabled value
	 */
	setDisabledState(isDisabled: boolean): void {
		// % protected region % [Add any additional logic before set the disabled state] off begin
		// % protected region % [Add any additional logic before set the disabled state] end

		this.isDisabled = isDisabled;
		this.prepareFields();

		// % protected region % [Add any additional logic after set the disabled state] off begin
		// % protected region % [Add any additional logic after set the disabled state] end
	}

	/**
	 * Determines whether the value in the password field should be shown or hidden.
	 * Is only used when the textfield is in password mode
	 * 
	 * @param $event the event for clicking the toggle button. Used to stop the click from also affecting the underlying element 
	 */
	toggleShowPassword($event) {
		// % protected region % [Add any additional logic before toggling the password] off begin
		// % protected region % [Add any additional logic before toggling the password] end

		$event.stopPropagation();
		this.showPassword = !this.showPassword;

		// % protected region % [Add any additional logic after toggling the password] off begin
		// % protected region % [Add any additional logic after toggling the password] end

	}
	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
