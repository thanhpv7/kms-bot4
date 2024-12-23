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

import {Routes} from '@angular/router';
import {RegisterSelectComponent} from './register-select/register-select.component';
import {PublicGuard} from '../../guards/authentication.guard';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * A list of routes that spans across the application.
 */
export const routes: Routes = [
	{
		path: 'register',
		canActivate: [
			PublicGuard,
			// % protected region % [Add any additional guards for the register tile here] off begin
			// % protected region % [Add any additional guards for the register tile here] end
		],
		children: [
			{
				path: '',
				redirectTo: 'select',
				pathMatch: 'full'
			},
			{
				path: 'select',
				component: RegisterSelectComponent
			},
			// % protected region % [Add any additional children paths here] off begin
			// % protected region % [Add any additional children paths here] end
		]
		// % protected region % [Add any additional routes configuration here] off begin
		// % protected region % [Add any additional routes configuration here] end
	},
	// % protected region % [Add any additional routes here] off begin
	// % protected region % [Add any additional routes here] end
];
