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
import {InvoicePaymentSelfPayingService} from 'src/app/services/invoicePaymentSelfPaying/invoice_payment_self_paying.service';
import {AdminInvoicePaymentSelfPayingCrudListComponent} from './list/invoice-payment-self-paying-admin-crud-list.component';
import {AdminInvoicePaymentSelfPayingCrudEditComponent} from './edit/invoice-payment-self-paying-admin-crud-edit.component';
import {AdminInvoicePaymentSelfPayingCrudComponent} from './invoice-payment-self-paying-admin-crud.component';
import {AdminInvoicePaymentSelfPayingCrudRoutingModule} from './invoice-payment-self-paying-admin-crud-routing.module';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@NgModule({
	declarations: [
		AdminInvoicePaymentSelfPayingCrudListComponent,
		AdminInvoicePaymentSelfPayingCrudEditComponent,
		AdminInvoicePaymentSelfPayingCrudComponent,
		// % protected region % [Add any additional declaration here] off begin
		// % protected region % [Add any additional declaration here] end
	],
	imports: [
		CommonModule,
		CommonComponentModule,
		CommonPipeModule,
		AdminInvoicePaymentSelfPayingCrudRoutingModule,
		// % protected region % [Add any additional module imports here] off begin
		// % protected region % [Add any additional module imports here] end
	],
	exports: [
		AdminInvoicePaymentSelfPayingCrudListComponent,
		AdminInvoicePaymentSelfPayingCrudEditComponent,
		AdminInvoicePaymentSelfPayingCrudComponent,
		// % protected region % [Add any additional module exports here] off begin
		// % protected region % [Add any additional module exports here] end
	],
	providers: [
		InvoicePaymentSelfPayingService,
		// % protected region % [Add any additional providers here] off begin
		// % protected region % [Add any additional providers here] end
	],
	// % protected region % [Add any additional module configurations here] off begin
	// % protected region % [Add any additional module configurations here] end
})
export class AdminInvoicePaymentSelfPayingCrudModule {
}
