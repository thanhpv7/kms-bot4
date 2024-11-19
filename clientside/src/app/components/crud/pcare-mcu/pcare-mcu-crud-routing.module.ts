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

import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PcareMCUCrudListComponent} from './list/pcare-mcu-crud-list.component';
import {PcareMCUCrudEditComponent} from './edit/pcare-mcu-crud-edit.component';
import {PcareMCUCrudComponent} from './pcare-mcu-crud.component';
import {RoleGuard} from 'src/app/lib/guards/role.guard';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end


const rolesAllowedToRead = [
	'NURSE_USER',
	'SYSTEM_ADMIN_USER',
	'PURCHASING_USER',
	'MEDICAL_RECORD_USER',
	'ADMINISTRATOR',
	'CASHIER_USER',
	'PHARMACY_USER',
	'DIAGNOSTIC_SUPPORT_USER',
	'ADMINISTRATION_USER',
	'WAREHOUSE_USER',
	'MANAGEMENT_USER',
	'FACILITY_USER',
	'MEDICAL_TRANSCRIBER_USER',
	'CLAIM_USER',
	'DOCTOR_USER',
	'REGISTRATION_USER',
	// % protected region % [Add any additional roles allowed to read here] off begin
	// % protected region % [Add any additional roles allowed to read here] end
];

const rolesAllowedToEdit = [
	'NURSE_USER',
	'SYSTEM_ADMIN_USER',
	'PURCHASING_USER',
	'MEDICAL_RECORD_USER',
	'ADMINISTRATOR',
	'PHARMACY_USER',
	'ADMINISTRATION_USER',
	'WAREHOUSE_USER',
	'MANAGEMENT_USER',
	'FACILITY_USER',
	'MEDICAL_TRANSCRIBER_USER',
	'DOCTOR_USER',
	'REGISTRATION_USER',
	// % protected region % [Add any additional roles allowed to edit here] off begin
	// % protected region % [Add any additional roles allowed to edit here] end
];

const rolesAllowedToCreate = [
	'NURSE_USER',
	'SYSTEM_ADMIN_USER',
	'PURCHASING_USER',
	'MEDICAL_RECORD_USER',
	'ADMINISTRATOR',
	'PHARMACY_USER',
	'ADMINISTRATION_USER',
	'WAREHOUSE_USER',
	'MANAGEMENT_USER',
	'FACILITY_USER',
	'MEDICAL_TRANSCRIBER_USER',
	'DOCTOR_USER',
	'REGISTRATION_USER',
	// % protected region % [Add any additional roles allowed to create here] off begin
	// % protected region % [Add any additional roles allowed to create here] end
];

const appRoutes: Routes = [
	// % protected region % [Configure routing for crud component here] off begin
	{
		path: '',
		component: PcareMCUCrudComponent,
		children: [
			{
				path: '',
				pathMatch: 'full',
				component: PcareMCUCrudListComponent,
				canActivate: [
					RoleGuard,
				],
				data: {
					expectedRoles: rolesAllowedToRead
				},
			},
			{
				path: 'pcare-mcu/view/:id',
				component: PcareMCUCrudEditComponent,
				canActivate: [
					RoleGuard,
				],
				data: {
					expectedRoles: rolesAllowedToRead
				},
			},
			{
				path: 'pcare-mcu/create',
				component: PcareMCUCrudEditComponent,
				canActivate: [
					RoleGuard,
				],
				data: {
					expectedRoles: rolesAllowedToEdit
				},
			},
			{
				path: 'pcare-mcu/edit/:id',
				component: PcareMCUCrudEditComponent,
				canActivate: [
					RoleGuard,
				],
				data: {
					expectedRoles: rolesAllowedToCreate
				},
			},
		],

	},
	// % protected region % [Configure routing for crud component here] end
];

@NgModule({
	declarations: [
		// % protected region % [Add any additional declaration here] off begin
		// % protected region % [Add any additional declaration here] end
	],
	imports: [
		RouterModule.forChild(appRoutes),
		// % protected region % [Add any additional module imports here] off begin
		// % protected region % [Add any additional module imports here] end
	],
	exports: [
		RouterModule,
		// % protected region % [Add any additional module exports here] off begin
		// % protected region % [Add any additional module exports here] end
	],
	providers: [
		// % protected region % [Add any additional providers here] off begin
		// % protected region % [Add any additional providers here] end
	],
	// % protected region % [Add any additional module configurations here] off begin
	// % protected region % [Add any additional module configurations here] end
})
export class PcareMCUCrudRoutingModule {
}
