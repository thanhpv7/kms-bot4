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

import {ValidatorFn, AbstractControl} from '@angular/forms';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

export class CustomValidators {

	public static url(): ValidatorFn {
		const urlRegEx: RegExp = /^(https:\/\/|http:\/\/)?([a-zA-Z0-9.]+)(\/.+)?$/;
		return (control: AbstractControl): {[key: string]: any} | null => {
			const invalid = (control.value && !urlRegEx.test(control.value));
			return invalid ? {url: {value: control.value}} : null;
		};
	}

	public static uuid(): ValidatorFn {
		const uuidRegEx: RegExp = /^[0-9A-Fa-f]{8}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{12}$/;
		return (control: AbstractControl): {[key: string]: any} | null => {
			const invalid = (control.value && !uuidRegEx.test(control.value));
			return invalid ? {uuid: {value: control.value}} : null;
		};
	}

	public static alphanumeric(): ValidatorFn {
		const urlRegEx: RegExp = /^[A-Za-z0-9]+$/;
		return (control: AbstractControl): {[key: string]: any} | null => {
			const invalid = (control.value && !urlRegEx.test(control.value));
			return invalid ? {alphanumeric: {value: control.value}} : null;
		};
	}

	public static numeric(): ValidatorFn {
		const urlRegEx: RegExp = /^[0-9]+$/;
		return (control: AbstractControl): {[key: string]: any} | null => {
			const invalid = (control.value && !urlRegEx.test(control.value));
			return invalid ? {numeric: {value: control.value}} : null;
		};
	}

	/**
	 * emptyString validator is added to strings, and ensures that a string of just spaces is not valid.
	 * A string of whitespace is deemed a valid attribute by both the client and the server by default, however that
	 * is not intended behaviour
	 */
	public static nonEmptyString(): ValidatorFn {
		const nonEmptyStringRegEx: RegExp = /^\W+$/;
		return (control: AbstractControl): {[key: string]: any} | null => {
			const invalid = (control.value && nonEmptyStringRegEx.test(control.value));
			return invalid ? {nonEmptyString: {value: control.value}} : null;
		};
	}

	// % protected region % [Add any additional custom validators here] off begin
	// % protected region % [Add any additional custom validators here] end
}
