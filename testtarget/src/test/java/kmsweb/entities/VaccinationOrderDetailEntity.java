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
package kmsweb.entities;

import lombok.*;
import javax.validation.constraints.NotNull;

import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class VaccinationOrderDetailEntity extends AbstractEntity {

	public VaccinationOrderDetailEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var StockCatalogueOneMany = new EntityReference();
			StockCatalogueOneMany.entityName = "StockCatalogue";
			StockCatalogueOneMany.oppositeName = "StockCatalogue";
			StockCatalogueOneMany.name = "VaccinationOrderDetails";
			StockCatalogueOneMany.optional = true;
			StockCatalogueOneMany.type = "One";
			StockCatalogueOneMany.oppositeType = "Many";

		References.add(StockCatalogueOneMany);

		var VaccinationOrderOneMany = new EntityReference();
			VaccinationOrderOneMany.entityName = "VaccinationOrder";
			VaccinationOrderOneMany.oppositeName = "VaccinationOrder";
			VaccinationOrderOneMany.name = "VaccinationOrderDetails";
			VaccinationOrderOneMany.optional = true;
			VaccinationOrderOneMany.type = "One";
			VaccinationOrderOneMany.oppositeType = "Many";

		References.add(VaccinationOrderOneMany);

		var WarehouseOneMany = new EntityReference();
			WarehouseOneMany.entityName = "Warehouse";
			WarehouseOneMany.oppositeName = "Warehouse";
			WarehouseOneMany.name = "VaccinationOrderDetails";
			WarehouseOneMany.optional = true;
			WarehouseOneMany.type = "One";
			WarehouseOneMany.oppositeType = "Many";

		References.add(WarehouseOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Vaccination Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Vaccination Date here] end
	private OffsetDateTime vaccinationDate;

	// % protected region % [Modify attribute annotation for Vaccination Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Vaccination Type here] end
	private String vaccinationType;

	// % protected region % [Modify attribute annotation for Vaccination Detail here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Vaccination Detail here] end
	private String vaccinationDetail;

	// % protected region % [Modify attribute annotation for Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity here] end
	private Integer quantity;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private StockCatalogueEntity stockCatalogue;

	private VaccinationOrderEntity vaccinationOrder;

	private WarehouseEntity warehouse;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setStockCatalogue(StockCatalogueEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockCatalogueEntity to be set to this entity
	 */
	public void setStockCatalogue(@NonNull StockCatalogueEntity entity) {
		setStockCatalogue(entity, true);
	}

	/**
	 * Set or update the stockCatalogue in this entity with single StockCatalogueEntity.
	 *
	 * @param entity the given StockCatalogueEntity to be set or updated to stockCatalogue
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogue(@NonNull StockCatalogueEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] end

		if (sameAsFormer(this.stockCatalogue, entity)) {
			return;
		}

		if (this.stockCatalogue != null) {
			this.stockCatalogue.removeVaccinationOrderDetails(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addVaccinationOrderDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStockCatalogue incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStockCatalogue incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStockCatalogue(boolean)} but default to true.
	 */
	public void unsetStockCatalogue() {
		this.unsetStockCatalogue(true);
	}

	/**
	 * Remove Stock Catalogue in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStockCatalogue(boolean reverse) {
		if (reverse && this.stockCatalogue != null) {
			this.stockCatalogue.removeVaccinationOrderDetails(this, false);
		}
		this.stockCatalogue = null;
	}
	/**
	 * Similar to {@link this#setVaccinationOrder(VaccinationOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VaccinationOrderEntity to be set to this entity
	 */
	public void setVaccinationOrder(@NonNull VaccinationOrderEntity entity) {
		setVaccinationOrder(entity, true);
	}

	/**
	 * Set or update the vaccinationOrder in this entity with single VaccinationOrderEntity.
	 *
	 * @param entity the given VaccinationOrderEntity to be set or updated to vaccinationOrder
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setVaccinationOrder(@NonNull VaccinationOrderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setVaccinationOrder here] off begin
		// % protected region % [Add any additional logic here before the main logic for setVaccinationOrder here] end

		if (sameAsFormer(this.vaccinationOrder, entity)) {
			return;
		}

		if (this.vaccinationOrder != null) {
			this.vaccinationOrder.removeVaccinationOrderDetails(this, false);
		}
		this.vaccinationOrder = entity;
		if (reverseAdd) {
			this.vaccinationOrder.addVaccinationOrderDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setVaccinationOrder incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setVaccinationOrder incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetVaccinationOrder(boolean)} but default to true.
	 */
	public void unsetVaccinationOrder() {
		this.unsetVaccinationOrder(true);
	}

	/**
	 * Remove Vaccination Order in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetVaccinationOrder(boolean reverse) {
		if (reverse && this.vaccinationOrder != null) {
			this.vaccinationOrder.removeVaccinationOrderDetails(this, false);
		}
		this.vaccinationOrder = null;
	}
	/**
	 * Similar to {@link this#setWarehouse(WarehouseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseEntity to be set to this entity
	 */
	public void setWarehouse(@NonNull WarehouseEntity entity) {
		setWarehouse(entity, true);
	}

	/**
	 * Set or update the warehouse in this entity with single WarehouseEntity.
	 *
	 * @param entity the given WarehouseEntity to be set or updated to warehouse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setWarehouse(@NonNull WarehouseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setWarehouse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setWarehouse here] end

		if (sameAsFormer(this.warehouse, entity)) {
			return;
		}

		if (this.warehouse != null) {
			this.warehouse.removeVaccinationOrderDetails(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addVaccinationOrderDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setWarehouse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setWarehouse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetWarehouse(boolean)} but default to true.
	 */
	public void unsetWarehouse() {
		this.unsetWarehouse(true);
	}

	/**
	 * Remove Warehouse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetWarehouse(boolean reverse) {
		if (reverse && this.warehouse != null) {
			this.warehouse.removeVaccinationOrderDetails(this, false);
		}
		this.warehouse = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
