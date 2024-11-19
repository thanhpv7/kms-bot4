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
import {CommonModule} from '@angular/common';
import {CommonPipeModule} from 'src/app/lib/pipes/common.pipe.module';
import {CommonComponentModule} from 'src/app/lib/components/common.component.module';
import {MedicalRecordInitialChecklistService} from 'src/app/services/medicalRecordInitialChecklist/medical_record_initial_checklist.service';
import {AdminMedicalRecordInitialChecklistCrudListComponent} from './list/medical-record-initial-checklist-admin-crud-list.component';
import {AdminMedicalRecordInitialChecklistCrudEditComponent} from './edit/medical-record-initial-checklist-admin-crud-edit.component';
import {AdminMedicalRecordInitialChecklistCrudComponent} from './medical-record-initial-checklist-admin-crud.component';
import {AdminMedicalRecordInitialChecklistCrudRoutingModule} from './medical-record-initial-checklist-admin-crud-routing.module';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@NgModule({
	declarations: [
		AdminMedicalRecordInitialChecklistCrudListComponent,
		AdminMedicalRecordInitialChecklistCrudEditComponent,
		AdminMedicalRecordInitialChecklistCrudComponent,
		// % protected region % [Add any additional declaration here] off begin
		// % protected region % [Add any additional declaration here] end
	],
	imports: [
		CommonModule,
		CommonComponentModule,
		CommonPipeModule,
		AdminMedicalRecordInitialChecklistCrudRoutingModule,
		// % protected region % [Add any additional module imports here] off begin
		// % protected region % [Add any additional module imports here] end
	],
	exports: [
		AdminMedicalRecordInitialChecklistCrudListComponent,
		AdminMedicalRecordInitialChecklistCrudEditComponent,
		AdminMedicalRecordInitialChecklistCrudComponent,
		// % protected region % [Add any additional module exports here] off begin
		// % protected region % [Add any additional module exports here] end
	],
	providers: [
		MedicalRecordInitialChecklistService,
		// % protected region % [Add any additional providers here] off begin
		// % protected region % [Add any additional providers here] end
	],
	// % protected region % [Add any additional module configurations here] off begin
	// % protected region % [Add any additional module configurations here] end
})
export class AdminMedicalRecordInitialChecklistCrudModule {
}
