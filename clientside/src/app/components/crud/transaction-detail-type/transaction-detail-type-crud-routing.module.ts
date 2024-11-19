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
import {TransactionDetailTypeCrudListComponent} from './list/transaction-detail-type-crud-list.component';
import {TransactionDetailTypeCrudEditComponent} from './edit/transaction-detail-type-crud-edit.component';
import {TransactionDetailTypeCrudComponent} from './transaction-detail-type-crud.component';
import {RoleGuard} from 'src/app/lib/guards/role.guard';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end


const rolesAllowedToRead = [
	'PHARMACY_USER',
	'WAREHOUSE_USER',
	'CLAIM_USER',
	'MEDICAL_TRANSCRIBER_USER',
	'SYSTEM_ADMIN_USER',
	'ADMINISTRATOR',
	'MEDICAL_RECORD_USER',
	'PURCHASING_USER',
	'ADMINISTRATION_USER',
	'REGISTRATION_USER',
	'DOCTOR_USER',
	'NURSE_USER',
	'DIAGNOSTIC_SUPPORT_USER',
	'MANAGEMENT_USER',
	'CASHIER_USER',
	'FACILITY_USER',
	// % protected region % [Add any additional roles allowed to read here] off begin
	// % protected region % [Add any additional roles allowed to read here] end
];

const rolesAllowedToEdit = [
	'PHARMACY_USER',
	'WAREHOUSE_USER',
	'SYSTEM_ADMIN_USER',
	'ADMINISTRATOR',
	'MEDICAL_RECORD_USER',
	'PURCHASING_USER',
	'ADMINISTRATION_USER',
	'REGISTRATION_USER',
	'NURSE_USER',
	'MANAGEMENT_USER',
	'FACILITY_USER',
	// % protected region % [Add any additional roles allowed to edit here] off begin
	// % protected region % [Add any additional roles allowed to edit here] end
];

const rolesAllowedToCreate = [
	'PHARMACY_USER',
	'WAREHOUSE_USER',
	'SYSTEM_ADMIN_USER',
	'ADMINISTRATOR',
	'MEDICAL_RECORD_USER',
	'PURCHASING_USER',
	'ADMINISTRATION_USER',
	'REGISTRATION_USER',
	'NURSE_USER',
	'MANAGEMENT_USER',
	'FACILITY_USER',
	// % protected region % [Add any additional roles allowed to create here] off begin
	// % protected region % [Add any additional roles allowed to create here] end
];

const appRoutes: Routes = [
	// % protected region % [Configure routing for crud component here] off begin
	{
		path: '',
		component: TransactionDetailTypeCrudComponent,
		children: [
			{
				path: '',
				pathMatch: 'full',
				component: TransactionDetailTypeCrudListComponent,
				canActivate: [
					RoleGuard,
				],
				data: {
					expectedRoles: rolesAllowedToRead
				},
			},
			{
				path: 'transaction-detail-type/view/:id',
				component: TransactionDetailTypeCrudEditComponent,
				canActivate: [
					RoleGuard,
				],
				data: {
					expectedRoles: rolesAllowedToRead
				},
			},
			{
				path: 'transaction-detail-type/create',
				component: TransactionDetailTypeCrudEditComponent,
				canActivate: [
					RoleGuard,
				],
				data: {
					expectedRoles: rolesAllowedToEdit
				},
			},
			{
				path: 'transaction-detail-type/edit/:id',
				component: TransactionDetailTypeCrudEditComponent,
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
export class TransactionDetailTypeCrudRoutingModule {
}
