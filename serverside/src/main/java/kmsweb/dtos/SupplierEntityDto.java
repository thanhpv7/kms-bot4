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

package kmsweb.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.entities.*;
import lombok.*;
import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for SupplierEntity")
@EqualsAndHashCode(callSuper = false)
public class SupplierEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String supplierNumber;

	private String supplierName;

	private String taxID;

	private String supplyStockGroup;

	private String adress;

	private String country;

	private String stateProvince;

	private String city;

	private String postalCode;

	private String phoneNumber;

	private String otherPhoneNumber;

	private String fax;

	private String email;

	private String website;

	private String notes;

	private Boolean purchaseOrderHold;

	private String purchaseOrderHoldReason;

	private Boolean vatIncluded;

	private String shippingMethod;

	private Double leadTimeMinimum;

	private Double leadTimeMaximum;

	private OffsetDateTime lastPurchaseDate;

	private String lastPurchaseOrderNumber;

	private String leadTimeMeasurement;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<GoodsReceiveNoteEntity> goodsReceiveNotes = new HashSet<>();

	private Set<PurchaseOrderEntity> purchaseOrders = new HashSet<>();

	private Set<PurchaseRequisitionEntity> purchaseRequisitions = new HashSet<>();

	private Set<ReturnSupplierEntity> returnSuppliers = new HashSet<>();

	private Set<SupplierContactDetailEntity> suplierContactDetails = new HashSet<>();

	private Set<SupplierBankAccountEntity> supplierBankAccounts = new HashSet<>();

	private Set<SupplierProductDetailEntity> supplierProductDetails = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
