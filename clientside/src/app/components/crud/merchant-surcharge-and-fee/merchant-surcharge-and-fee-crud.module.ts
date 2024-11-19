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
import {MerchantSurchargeAndFeeService} from 'src/app/services/merchantSurchargeAndFee/merchant_surcharge_and_fee.service';
import {MerchantSurchargeAndFeeCrudListComponent} from './list/merchant-surcharge-and-fee-crud-list.component';
import {MerchantSurchargeAndFeeCrudEditComponent} from './edit/merchant-surcharge-and-fee-crud-edit.component';
import {MerchantSurchargeAndFeeCrudComponent} from './merchant-surcharge-and-fee-crud.component';
import {MerchantSurchargeAndFeeCrudRoutingModule} from './merchant-surcharge-and-fee-crud-routing.module';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@NgModule({
	declarations: [
		MerchantSurchargeAndFeeCrudListComponent,
		MerchantSurchargeAndFeeCrudEditComponent,
		MerchantSurchargeAndFeeCrudComponent,
		// % protected region % [Add any additional declaration here] off begin
		// % protected region % [Add any additional declaration here] end
	],
	imports: [
		CommonModule,
		CommonComponentModule,
		CommonPipeModule,
		MerchantSurchargeAndFeeCrudRoutingModule,
		// % protected region % [Add any additional module imports here] off begin
		// % protected region % [Add any additional module imports here] end
	],
	exports: [
		MerchantSurchargeAndFeeCrudListComponent,
		MerchantSurchargeAndFeeCrudEditComponent,
		MerchantSurchargeAndFeeCrudComponent,
		// % protected region % [Add any additional module exports here] off begin
		// % protected region % [Add any additional module exports here] end
	],
	providers: [
		MerchantSurchargeAndFeeService,
		// % protected region % [Add any additional providers here] off begin
		// % protected region % [Add any additional providers here] end
	],
	// % protected region % [Add any additional module configurations here] off begin
	// % protected region % [Add any additional module configurations here] end
})
export class MerchantSurchargeAndFeeCrudModule {
}
