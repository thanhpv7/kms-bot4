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

import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {RoleGuard} from '../../lib/guards/role.guard';
import { BpjsDoctorSchedulePageComponent } from './bpjs-doctor-schedule.page.component';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * A list of routes that spans across the application.
 */
export const appRoutes: Routes = [
	{
		path: '',
		children: [
			// % protected region % [Add any child components to this route here] off begin
			// % protected region % [Add any child components to this route here] end
		],
		component: BpjsDoctorSchedulePageComponent,
	},
	// % protected region % [Add any additional routes here] off begin
	// % protected region % [Add any additional routes here] end
];

@NgModule({
	imports: [
		RouterModule.forChild(appRoutes)
	],
	exports: [
		RouterModule
	]
})
export class BpjsDoctorSchedulePageRoutingModule { }
