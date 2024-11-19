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

package kmsweb.graphql.resolvers;

import kmsweb.entities.*;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Component
public class PurchaseOrderResolver implements GraphQLResolver<PurchaseOrderEntity> {

	// % protected region % [Import any additional class fields here] off begin
	// % protected region % [Import any additional class fields here] end

	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	public Set<PurchaseOrderStockDetailEntity> purchaseOrderStockDetails(PurchaseOrderEntity purchaseOrder) {
		return purchaseOrder.getPurchaseOrderStockDetails();
	}

	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	public Set<PurchaseRequisitionEntity> purchaseRequisitions(PurchaseOrderEntity purchaseOrder) {
		return purchaseOrder.getPurchaseRequisitions();
	}

	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	public Set<ReturnSupplierEntity> returnSuppliers(PurchaseOrderEntity purchaseOrder) {
		return purchaseOrder.getReturnSuppliers();
	}

	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	public GoodsReceiveNoteEntity goodsReceiveNote(PurchaseOrderEntity purchaseOrder) {
		return purchaseOrder.getGoodsReceiveNote();
	}

	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	public SupplierEntity supplier(PurchaseOrderEntity purchaseOrder) {
		return purchaseOrder.getSupplier();
	}

	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	public WarehouseEntity warehouse(PurchaseOrderEntity purchaseOrder) {
		return purchaseOrder.getWarehouse();
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
