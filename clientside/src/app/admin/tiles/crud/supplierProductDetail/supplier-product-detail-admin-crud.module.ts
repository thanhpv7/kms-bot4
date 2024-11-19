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
import {SupplierProductDetailService} from 'src/app/services/supplierProductDetail/supplier_product_detail.service';
import {AdminSupplierProductDetailCrudListComponent} from './list/supplier-product-detail-admin-crud-list.component';
import {AdminSupplierProductDetailCrudEditComponent} from './edit/supplier-product-detail-admin-crud-edit.component';
import {AdminSupplierProductDetailCrudComponent} from './supplier-product-detail-admin-crud.component';
import {AdminSupplierProductDetailCrudRoutingModule} from './supplier-product-detail-admin-crud-routing.module';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@NgModule({
	declarations: [
		AdminSupplierProductDetailCrudListComponent,
		AdminSupplierProductDetailCrudEditComponent,
		AdminSupplierProductDetailCrudComponent,
		// % protected region % [Add any additional declaration here] off begin
		// % protected region % [Add any additional declaration here] end
	],
	imports: [
		CommonModule,
		CommonComponentModule,
		CommonPipeModule,
		AdminSupplierProductDetailCrudRoutingModule,
		// % protected region % [Add any additional module imports here] off begin
		// % protected region % [Add any additional module imports here] end
	],
	exports: [
		AdminSupplierProductDetailCrudListComponent,
		AdminSupplierProductDetailCrudEditComponent,
		AdminSupplierProductDetailCrudComponent,
		// % protected region % [Add any additional module exports here] off begin
		// % protected region % [Add any additional module exports here] end
	],
	providers: [
		SupplierProductDetailService,
		// % protected region % [Add any additional providers here] off begin
		// % protected region % [Add any additional providers here] end
	],
	// % protected region % [Add any additional module configurations here] off begin
	// % protected region % [Add any additional module configurations here] end
})
export class AdminSupplierProductDetailCrudModule {
}
