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
import {BpjsTreatmentClassMappingService} from 'src/app/services/bpjsTreatmentClassMapping/bpjs_treatment_class_mapping.service';
import {BpjsTreatmentClassMappingCrudListComponent} from './list/bpjs-treatment-class-mapping-crud-list.component';
import {BpjsTreatmentClassMappingCrudEditComponent} from './edit/bpjs-treatment-class-mapping-crud-edit.component';
import {BpjsTreatmentClassMappingCrudComponent} from './bpjs-treatment-class-mapping-crud.component';
import {BpjsTreatmentClassMappingCrudRoutingModule} from './bpjs-treatment-class-mapping-crud-routing.module';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@NgModule({
	declarations: [
		BpjsTreatmentClassMappingCrudListComponent,
		BpjsTreatmentClassMappingCrudEditComponent,
		BpjsTreatmentClassMappingCrudComponent,
		// % protected region % [Add any additional declaration here] off begin
		// % protected region % [Add any additional declaration here] end
	],
	imports: [
		CommonModule,
		CommonComponentModule,
		CommonPipeModule,
		BpjsTreatmentClassMappingCrudRoutingModule,
		// % protected region % [Add any additional module imports here] off begin
		// % protected region % [Add any additional module imports here] end
	],
	exports: [
		BpjsTreatmentClassMappingCrudListComponent,
		BpjsTreatmentClassMappingCrudEditComponent,
		BpjsTreatmentClassMappingCrudComponent,
		// % protected region % [Add any additional module exports here] off begin
		// % protected region % [Add any additional module exports here] end
	],
	providers: [
		BpjsTreatmentClassMappingService,
		// % protected region % [Add any additional providers here] off begin
		// % protected region % [Add any additional providers here] end
	],
	// % protected region % [Add any additional module configurations here] off begin
	// % protected region % [Add any additional module configurations here] end
})
export class BpjsTreatmentClassMappingCrudModule {
}
