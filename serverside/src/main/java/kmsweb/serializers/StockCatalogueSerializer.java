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
package kmsweb.serializers;

import kmsweb.entities.StockCatalogueEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class StockCatalogueSerializer extends AbstractSerializer<StockCatalogueEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public StockCatalogueSerializer() {
		super(StockCatalogueEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(StockCatalogueEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeBooleanField(gen, "trackable", value.getTrackable());
		writeStringField(gen, "stockCode", value.getStockCode());
		writeStringField(gen, "stockName", value.getStockName());
		writeStringField(gen, "description", value.getDescription());
		writeDoubleField(gen, "weight", value.getWeight());
		writeStringField(gen, "weightUnit", value.getWeightUnit());
		writeDoubleField(gen, "volume", value.getVolume());
		writeStringField(gen, "volumeUnit", value.getVolumeUnit());
		writeStringField(gen, "stockGroup", value.getStockGroup());
		writeStringField(gen, "stockCategory", value.getStockCategory());
		writeStringField(gen, "approvalStatus", value.getApprovalStatus());
		writeStringField(gen, "approvedBy", value.getApprovedBy());
		writeOffsetDateTimeField(gen, "approvalDate", value.getApprovalDate());
		writeStringField(gen, "approvalNotes", value.getApprovalNotes());
		writeIntegerField(gen, "quantityPerPack", value.getQuantityPerPack());
		writeStringField(gen, "uoi", value.getUoi());
		writeStringField(gen, "lastBuyingPriceVATExcludeCurrency", value.getLastBuyingPriceVATExcludeCurrency());
		writeDoubleField(gen, "lastBuyingPriceVATExcludePrice", value.getLastBuyingPriceVATExcludePrice());
		writeStringField(gen, "lastBuyingPriceVATIncludeCurrency", value.getLastBuyingPriceVATIncludeCurrency());
		writeDoubleField(gen, "lastBuyingPriceVATIncludePrice", value.getLastBuyingPriceVATIncludePrice());
		writeBooleanField(gen, "medicalType", value.getMedicalType());
		writeStringField(gen, "stockCategoryVATExcluded", value.getStockCategoryVATExcluded());
		writeStringField(gen, "stockCategoryVATIncluded", value.getStockCategoryVATIncluded());
		writeDoubleField(gen, "onHandQty", value.getOnHandQty());
		writeDoubleField(gen, "averageCost", value.getAverageCost());
		writeDoubleField(gen, "totalCost", value.getTotalCost());
		writeStringField(gen, "salesAccount", value.getSalesAccount());
		writeStringField(gen, "inventoryAccount", value.getInventoryAccount());
		writeStringField(gen, "purchaseAccount", value.getPurchaseAccount());
		writeStringField(gen, "lupSupplierName", value.getLupSupplierName());
		writeDoubleField(gen, "lupUnitPrice", value.getLupUnitPrice());
		writeDoubleField(gen, "lupDiscount", value.getLupDiscount());
		writeDoubleField(gen, "lupItemPrice", value.getLupItemPrice());
		writeOffsetDateTimeField(gen, "lupLastPurchaseDate", value.getLupLastPurchaseDate());
		writeStringField(gen, "lppSupplierName", value.getLppSupplierName());
		writeDoubleField(gen, "lppUnitPrice", value.getLppUnitPrice());
		writeDoubleField(gen, "lppDiscount", value.getLppDiscount());
		writeDoubleField(gen, "lppItemPrice", value.getLppItemPrice());
		writeOffsetDateTimeField(gen, "lppLastPurchaseDate", value.getLppLastPurchaseDate());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}