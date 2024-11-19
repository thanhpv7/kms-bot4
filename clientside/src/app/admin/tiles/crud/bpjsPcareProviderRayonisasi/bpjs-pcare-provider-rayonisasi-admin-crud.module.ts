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
import {BpjsPcareProviderRayonisasiService} from 'src/app/services/bpjsPcareProviderRayonisasi/bpjs_pcare_provider_rayonisasi.service';
import {AdminBpjsPcareProviderRayonisasiCrudListComponent} from './list/bpjs-pcare-provider-rayonisasi-admin-crud-list.component';
import {AdminBpjsPcareProviderRayonisasiCrudEditComponent} from './edit/bpjs-pcare-provider-rayonisasi-admin-crud-edit.component';
import {AdminBpjsPcareProviderRayonisasiCrudComponent} from './bpjs-pcare-provider-rayonisasi-admin-crud.component';
import {AdminBpjsPcareProviderRayonisasiCrudRoutingModule} from './bpjs-pcare-provider-rayonisasi-admin-crud-routing.module';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@NgModule({
	declarations: [
		AdminBpjsPcareProviderRayonisasiCrudListComponent,
		AdminBpjsPcareProviderRayonisasiCrudEditComponent,
		AdminBpjsPcareProviderRayonisasiCrudComponent,
		// % protected region % [Add any additional declaration here] off begin
		// % protected region % [Add any additional declaration here] end
	],
	imports: [
		CommonModule,
		CommonComponentModule,
		CommonPipeModule,
		AdminBpjsPcareProviderRayonisasiCrudRoutingModule,
		// % protected region % [Add any additional module imports here] off begin
		// % protected region % [Add any additional module imports here] end
	],
	exports: [
		AdminBpjsPcareProviderRayonisasiCrudListComponent,
		AdminBpjsPcareProviderRayonisasiCrudEditComponent,
		AdminBpjsPcareProviderRayonisasiCrudComponent,
		// % protected region % [Add any additional module exports here] off begin
		// % protected region % [Add any additional module exports here] end
	],
	providers: [
		BpjsPcareProviderRayonisasiService,
		// % protected region % [Add any additional providers here] off begin
		// % protected region % [Add any additional providers here] end
	],
	// % protected region % [Add any additional module configurations here] off begin
	// % protected region % [Add any additional module configurations here] end
})
export class AdminBpjsPcareProviderRayonisasiCrudModule {
}
