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
import {InternalOrderStockDetailService} from 'src/app/services/internalOrderStockDetail/internal_order_stock_detail.service';
import {InternalOrderStockDetailCrudListComponent} from './list/internal-order-stock-detail-crud-list.component';
import {InternalOrderStockDetailCrudEditComponent} from './edit/internal-order-stock-detail-crud-edit.component';
import {InternalOrderStockDetailCrudComponent} from './internal-order-stock-detail-crud.component';
import {InternalOrderStockDetailCrudRoutingModule} from './internal-order-stock-detail-crud-routing.module';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@NgModule({
	declarations: [
		InternalOrderStockDetailCrudListComponent,
		InternalOrderStockDetailCrudEditComponent,
		InternalOrderStockDetailCrudComponent,
		// % protected region % [Add any additional declaration here] off begin
		// % protected region % [Add any additional declaration here] end
	],
	imports: [
		CommonModule,
		CommonComponentModule,
		CommonPipeModule,
		InternalOrderStockDetailCrudRoutingModule,
		// % protected region % [Add any additional module imports here] off begin
		// % protected region % [Add any additional module imports here] end
	],
	exports: [
		InternalOrderStockDetailCrudListComponent,
		InternalOrderStockDetailCrudEditComponent,
		InternalOrderStockDetailCrudComponent,
		// % protected region % [Add any additional module exports here] off begin
		// % protected region % [Add any additional module exports here] end
	],
	providers: [
		InternalOrderStockDetailService,
		// % protected region % [Add any additional providers here] off begin
		// % protected region % [Add any additional providers here] end
	],
	// % protected region % [Add any additional module configurations here] off begin
	// % protected region % [Add any additional module configurations here] end
})
export class InternalOrderStockDetailCrudModule {
}