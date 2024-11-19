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

import * as faker from 'faker';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

export class ValidatorInputUtils {

	static lengthString(length: number): string {
		return faker.random.alphaNumeric(length);
	}

	static alphanumeric(valid: boolean, length: number): string {
		let retString;
		retString = faker.random.alphaNumeric(length);

		if (!valid) {
			retString = '@' + retString;
		}

		return retString.substr(0, length);
	}

	static uuid(valid: boolean): string {
		if (valid) {
			return faker.random.uuid();
		}

		return faker.random.words();
	}

	static email(valid: boolean): string {
		if (valid) {
			return faker.random.alphaNumeric() + '@example.com';
		}

		return faker.random.word();
	}

	static numeric(valid: boolean, length: number) {
		if (valid) {
			return '1'.repeat(length);
		}

		return faker.random.words(length).substr(length);
	}

	static url(valid: boolean) {
		if (valid) {
			return 'http://' + faker.random.alphaNumeric();
		}

		// String is an invalid url, as the http:// is not correct
		return 'htt://' + faker.random.alphaNumeric();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
