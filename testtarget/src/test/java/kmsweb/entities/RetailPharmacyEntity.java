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

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class RetailPharmacyEntity extends AbstractEntity {

	public RetailPharmacyEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PatientGeneralInfoOneMany = new EntityReference();
			PatientGeneralInfoOneMany.entityName = "PatientGeneralInfo";
			PatientGeneralInfoOneMany.oppositeName = "PatientGeneralInfo";
			PatientGeneralInfoOneMany.name = "RetailPharmacies";
			PatientGeneralInfoOneMany.optional = true;
			PatientGeneralInfoOneMany.type = "One";
			PatientGeneralInfoOneMany.oppositeType = "Many";

		References.add(PatientGeneralInfoOneMany);

		var WarehouseOneMany = new EntityReference();
			WarehouseOneMany.entityName = "Warehouse";
			WarehouseOneMany.oppositeName = "Warehouse";
			WarehouseOneMany.name = "RetailPharmacies";
			WarehouseOneMany.optional = true;
			WarehouseOneMany.type = "One";
			WarehouseOneMany.oppositeType = "Many";

		References.add(WarehouseOneMany);

		var RetailPharmacyInvoicesOneMany = new EntityReference();
			RetailPharmacyInvoicesOneMany.entityName = "RetailPharmacyInvoice";
			RetailPharmacyInvoicesOneMany.oppositeName = "RetailPharmacy";
			RetailPharmacyInvoicesOneMany.name = "RetailPharmacyInvoices";
			RetailPharmacyInvoicesOneMany.optional = true;
			RetailPharmacyInvoicesOneMany.type = "One";
			RetailPharmacyInvoicesOneMany.oppositeType = "Many";

		References.add(RetailPharmacyInvoicesOneMany);

		var RetailPharmacyStockDetailsOneMany = new EntityReference();
			RetailPharmacyStockDetailsOneMany.entityName = "RetailPharmacyStockDetail";
			RetailPharmacyStockDetailsOneMany.oppositeName = "RetailPharmacy";
			RetailPharmacyStockDetailsOneMany.name = "RetailPharmacyStockDetails";
			RetailPharmacyStockDetailsOneMany.optional = true;
			RetailPharmacyStockDetailsOneMany.type = "One";
			RetailPharmacyStockDetailsOneMany.oppositeType = "Many";

		References.add(RetailPharmacyStockDetailsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Customer Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Customer Type here] end
	private String customerType;

	// % protected region % [Modify attribute annotation for Retail Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Retail Number here] end
	private String retailNumber;

	// % protected region % [Modify attribute annotation for Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Status here] end
	private String status;

	// % protected region % [Modify attribute annotation for Customer Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Customer Name here] end
	private String customerName;

	// % protected region % [Modify attribute annotation for Address here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Address here] end
	private String address;

	// % protected region % [Modify attribute annotation for Phone Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Phone Number here] end
	private String phoneNumber;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Payment Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Payment Status here] end
	private String paymentStatus;

	// % protected region % [Modify attribute annotation for Total Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Price here] end
	private Double totalPrice;

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

	private Set<RetailPharmacyInvoiceEntity> retailPharmacyInvoices = new HashSet<>();

	private Set<RetailPharmacyStockDetailEntity> retailPharmacyStockDetails = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private PatientGeneralInfoEntity patientGeneralInfo;

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

/**
	 * Similar to {@link this#addRetailPharmacyInvoices(RetailPharmacyInvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity to be added to this entity
	 */
	public void addRetailPharmacyInvoices(@NonNull RetailPharmacyInvoiceEntity entity) {
		addRetailPharmacyInvoices(entity, true);
	}

	/**
	 * Add a new RetailPharmacyInvoiceEntity to retailPharmacyInvoices in this entity.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRetailPharmacyInvoices(@NonNull RetailPharmacyInvoiceEntity entity, boolean reverseAdd) {
		if (!this.retailPharmacyInvoices.contains(entity)) {
			retailPharmacyInvoices.add(entity);
			if (reverseAdd) {
				entity.setRetailPharmacy(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRetailPharmacyInvoices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RetailPharmacyInvoiceEntity to be added to this entity
	 */
	public void addRetailPharmacyInvoices(@NonNull Collection<RetailPharmacyInvoiceEntity> entities) {
		addRetailPharmacyInvoices(entities, true);
	}

	/**
	 * Add a new collection of RetailPharmacyInvoiceEntity to Retail Pharmacy Invoices in this entity.
	 *
	 * @param entities the given collection of RetailPharmacyInvoiceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRetailPharmacyInvoices(@NonNull Collection<RetailPharmacyInvoiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRetailPharmacyInvoices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRetailPharmacyInvoices(RetailPharmacyInvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity to be set to this entity
	 */
	public void removeRetailPharmacyInvoices(@NonNull RetailPharmacyInvoiceEntity entity) {
		this.removeRetailPharmacyInvoices(entity, true);
	}

	/**
	 * Remove the given RetailPharmacyInvoiceEntity from this entity.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRetailPharmacyInvoices(@NonNull RetailPharmacyInvoiceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetRetailPharmacy(false);
		}
		this.retailPharmacyInvoices.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRetailPharmacyInvoices(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RetailPharmacyInvoiceEntity to be removed to this entity
	 */
	public void removeRetailPharmacyInvoices(@NonNull Collection<RetailPharmacyInvoiceEntity> entities) {
		this.removeRetailPharmacyInvoices(entities, true);
	}

	/**
	 * Remove the given collection of RetailPharmacyInvoiceEntity from  to this entity.
	 *
	 * @param entities the given collection of RetailPharmacyInvoiceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRetailPharmacyInvoices(@NonNull Collection<RetailPharmacyInvoiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRetailPharmacyInvoices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRetailPharmacyInvoices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RetailPharmacyInvoiceEntity to be set to this entity
	 */
	public void setRetailPharmacyInvoices(@NonNull Collection<RetailPharmacyInvoiceEntity> entities) {
		setRetailPharmacyInvoices(entities, true);
	}

	/**
	 * Replace the current entities in Retail Pharmacy Invoices with the given ones.
	 *
	 * @param entities the given collection of RetailPharmacyInvoiceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRetailPharmacyInvoices(@NonNull Collection<RetailPharmacyInvoiceEntity> entities, boolean reverseAdd) {

		this.unsetRetailPharmacyInvoices();
		this.retailPharmacyInvoices = new HashSet<>(entities);
		if (reverseAdd) {
			this.retailPharmacyInvoices.forEach(retailPharmacyInvoicesEntity -> retailPharmacyInvoicesEntity.setRetailPharmacy(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRetailPharmacyInvoices(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRetailPharmacyInvoices() {
		this.unsetRetailPharmacyInvoices(true);
	}

	/**
	 * Remove all the entities in Retail Pharmacy Invoices from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRetailPharmacyInvoices(boolean doReverse) {
		if (doReverse) {
			this.retailPharmacyInvoices.forEach(retailPharmacyInvoicesEntity -> retailPharmacyInvoicesEntity.unsetRetailPharmacy(false));
		}
		this.retailPharmacyInvoices.clear();
	}

/**
	 * Similar to {@link this#addRetailPharmacyStockDetails(RetailPharmacyStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyStockDetailEntity to be added to this entity
	 */
	public void addRetailPharmacyStockDetails(@NonNull RetailPharmacyStockDetailEntity entity) {
		addRetailPharmacyStockDetails(entity, true);
	}

	/**
	 * Add a new RetailPharmacyStockDetailEntity to retailPharmacyStockDetails in this entity.
	 *
	 * @param entity the given RetailPharmacyStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRetailPharmacyStockDetails(@NonNull RetailPharmacyStockDetailEntity entity, boolean reverseAdd) {
		if (!this.retailPharmacyStockDetails.contains(entity)) {
			retailPharmacyStockDetails.add(entity);
			if (reverseAdd) {
				entity.setRetailPharmacy(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRetailPharmacyStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to be added to this entity
	 */
	public void addRetailPharmacyStockDetails(@NonNull Collection<RetailPharmacyStockDetailEntity> entities) {
		addRetailPharmacyStockDetails(entities, true);
	}

	/**
	 * Add a new collection of RetailPharmacyStockDetailEntity to Retail Pharmacy Stock Details in this entity.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRetailPharmacyStockDetails(@NonNull Collection<RetailPharmacyStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRetailPharmacyStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRetailPharmacyStockDetails(RetailPharmacyStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyStockDetailEntity to be set to this entity
	 */
	public void removeRetailPharmacyStockDetails(@NonNull RetailPharmacyStockDetailEntity entity) {
		this.removeRetailPharmacyStockDetails(entity, true);
	}

	/**
	 * Remove the given RetailPharmacyStockDetailEntity from this entity.
	 *
	 * @param entity the given RetailPharmacyStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRetailPharmacyStockDetails(@NonNull RetailPharmacyStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetRetailPharmacy(false);
		}
		this.retailPharmacyStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRetailPharmacyStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to be removed to this entity
	 */
	public void removeRetailPharmacyStockDetails(@NonNull Collection<RetailPharmacyStockDetailEntity> entities) {
		this.removeRetailPharmacyStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of RetailPharmacyStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRetailPharmacyStockDetails(@NonNull Collection<RetailPharmacyStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRetailPharmacyStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRetailPharmacyStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to be set to this entity
	 */
	public void setRetailPharmacyStockDetails(@NonNull Collection<RetailPharmacyStockDetailEntity> entities) {
		setRetailPharmacyStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Retail Pharmacy Stock Details with the given ones.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRetailPharmacyStockDetails(@NonNull Collection<RetailPharmacyStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetRetailPharmacyStockDetails();
		this.retailPharmacyStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.retailPharmacyStockDetails.forEach(retailPharmacyStockDetailsEntity -> retailPharmacyStockDetailsEntity.setRetailPharmacy(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRetailPharmacyStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRetailPharmacyStockDetails() {
		this.unsetRetailPharmacyStockDetails(true);
	}

	/**
	 * Remove all the entities in Retail Pharmacy Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRetailPharmacyStockDetails(boolean doReverse) {
		if (doReverse) {
			this.retailPharmacyStockDetails.forEach(retailPharmacyStockDetailsEntity -> retailPharmacyStockDetailsEntity.unsetRetailPharmacy(false));
		}
		this.retailPharmacyStockDetails.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setPatientGeneralInfo(PatientGeneralInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientGeneralInfo(@NonNull PatientGeneralInfoEntity entity) {
		setPatientGeneralInfo(entity, true);
	}

	/**
	 * Set or update the patientGeneralInfo in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInfo
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInfo(@NonNull PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInfo here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInfo here] end

		if (sameAsFormer(this.patientGeneralInfo, entity)) {
			return;
		}

		if (this.patientGeneralInfo != null) {
			this.patientGeneralInfo.removeRetailPharmacies(this, false);
		}
		this.patientGeneralInfo = entity;
		if (reverseAdd) {
			this.patientGeneralInfo.addRetailPharmacies(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInfo incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInfo incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientGeneralInfo(boolean)} but default to true.
	 */
	public void unsetPatientGeneralInfo() {
		this.unsetPatientGeneralInfo(true);
	}

	/**
	 * Remove Patient General Info in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientGeneralInfo(boolean reverse) {
		if (reverse && this.patientGeneralInfo != null) {
			this.patientGeneralInfo.removeRetailPharmacies(this, false);
		}
		this.patientGeneralInfo = null;
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
			this.warehouse.removeRetailPharmacies(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addRetailPharmacies(this, false);
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
			this.warehouse.removeRetailPharmacies(this, false);
		}
		this.warehouse = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
