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
import {BpjsPcareRiwayatKunjunganService} from 'src/app/services/bpjsPcareRiwayatKunjungan/bpjs_pcare_riwayat_kunjungan.service';
import {BpjsPcareRiwayatKunjunganCrudListComponent} from './list/bpjs-pcare-riwayat-kunjungan-crud-list.component';
import {BpjsPcareRiwayatKunjunganCrudEditComponent} from './edit/bpjs-pcare-riwayat-kunjungan-crud-edit.component';
import {BpjsPcareRiwayatKunjunganCrudComponent} from './bpjs-pcare-riwayat-kunjungan-crud.component';
import {BpjsPcareRiwayatKunjunganCrudRoutingModule} from './bpjs-pcare-riwayat-kunjungan-crud-routing.module';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@NgModule({
	declarations: [
		BpjsPcareRiwayatKunjunganCrudListComponent,
		BpjsPcareRiwayatKunjunganCrudEditComponent,
		BpjsPcareRiwayatKunjunganCrudComponent,
		// % protected region % [Add any additional declaration here] off begin
		// % protected region % [Add any additional declaration here] end
	],
	imports: [
		CommonModule,
		CommonComponentModule,
		CommonPipeModule,
		BpjsPcareRiwayatKunjunganCrudRoutingModule,
		// % protected region % [Add any additional module imports here] off begin
		// % protected region % [Add any additional module imports here] end
	],
	exports: [
		BpjsPcareRiwayatKunjunganCrudListComponent,
		BpjsPcareRiwayatKunjunganCrudEditComponent,
		BpjsPcareRiwayatKunjunganCrudComponent,
		// % protected region % [Add any additional module exports here] off begin
		// % protected region % [Add any additional module exports here] end
	],
	providers: [
		BpjsPcareRiwayatKunjunganService,
		// % protected region % [Add any additional providers here] off begin
		// % protected region % [Add any additional providers here] end
	],
	// % protected region % [Add any additional module configurations here] off begin
	// % protected region % [Add any additional module configurations here] end
})
export class BpjsPcareRiwayatKunjunganCrudModule {
}
