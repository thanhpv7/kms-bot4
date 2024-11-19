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

export interface ErrorMessage {
	title: string;
	body: string;
}

// % protected region % [Customise the error messages here] off begin
export const NotAuthenticatedErrorMessage: ErrorMessage = {
	title: 'Please login!',
	body: 'You are not authenticated'
};

export const TokenExpiredErrorMessage: ErrorMessage = {
	title: 'Please login again!',
	body: 'Your session has expired.'
};
// % protected region % [Customise the error messages here] end

// % protected region % [Add custom error interfaces here] off begin
// % protected region % [Add custom error interfaces here] end
