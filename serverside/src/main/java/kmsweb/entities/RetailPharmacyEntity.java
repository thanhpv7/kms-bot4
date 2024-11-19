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

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.dtos.RetailPharmacyEntityDto;
import kmsweb.entities.listeners.RetailPharmacyEntityListener;
import kmsweb.serializers.RetailPharmacySerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
// % protected region % [Override the auditing annotation or add additional annotations here] off begin
@Audited
// % protected region % [Override the auditing annotation or add additional annotations here] end
@ExcludeSuperclassListeners
@EntityListeners({RetailPharmacyEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = RetailPharmacySerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class RetailPharmacyEntity extends AbstractEntity {

	/**
	 * Takes a RetailPharmacyEntityDto and converts it into a RetailPharmacyEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param retailPharmacyEntityDto
	 */
	public RetailPharmacyEntity(RetailPharmacyEntityDto retailPharmacyEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (retailPharmacyEntityDto.getId() != null) {
			this.setId(retailPharmacyEntityDto.getId());
		}

		if (retailPharmacyEntityDto.getCustomerType() != null) {
			this.setCustomerType(retailPharmacyEntityDto.getCustomerType());
		}

		if (retailPharmacyEntityDto.getRetailNumber() != null) {
			this.setRetailNumber(retailPharmacyEntityDto.getRetailNumber());
		}

		if (retailPharmacyEntityDto.getStatus() != null) {
			this.setStatus(retailPharmacyEntityDto.getStatus());
		}

		if (retailPharmacyEntityDto.getCustomerName() != null) {
			this.setCustomerName(retailPharmacyEntityDto.getCustomerName());
		}

		if (retailPharmacyEntityDto.getAddress() != null) {
			this.setAddress(retailPharmacyEntityDto.getAddress());
		}

		if (retailPharmacyEntityDto.getPhoneNumber() != null) {
			this.setPhoneNumber(retailPharmacyEntityDto.getPhoneNumber());
		}

		if (retailPharmacyEntityDto.getNotes() != null) {
			this.setNotes(retailPharmacyEntityDto.getNotes());
		}

		if (retailPharmacyEntityDto.getPaymentStatus() != null) {
			this.setPaymentStatus(retailPharmacyEntityDto.getPaymentStatus());
		}

		if (retailPharmacyEntityDto.getTotalPrice() != null) {
			this.setTotalPrice(retailPharmacyEntityDto.getTotalPrice());
		}

		if (retailPharmacyEntityDto.getRetailPharmacyInvoices() != null) {
			this.setRetailPharmacyInvoices(retailPharmacyEntityDto.getRetailPharmacyInvoices());
		}

		if (retailPharmacyEntityDto.getRetailPharmacyStockDetails() != null) {
			this.setRetailPharmacyStockDetails(retailPharmacyEntityDto.getRetailPharmacyStockDetails());
		}

		if (retailPharmacyEntityDto.getPatientGeneralInfo() != null) {
			this.setPatientGeneralInfo(retailPharmacyEntityDto.getPatientGeneralInfo());
		}

		if (retailPharmacyEntityDto.getWarehouse() != null) {
			this.setWarehouse(retailPharmacyEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Customer Type here] off begin
	@CsvBindByName(column = "CUSTOMER_TYPE", required = false)
	@Nullable
	@Column(name = "customer_type")
	@Schema(description = "The Customer Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Customer Type here] end
	private String customerType;

	// % protected region % [Modify attribute annotation for Retail Number here] off begin
	@CsvBindByName(column = "RETAIL_NUMBER", required = false)
	@Nullable
	@Column(name = "retail_number")
	@Schema(description = "The Retail Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Retail Number here] end
	private String retailNumber;

	// % protected region % [Modify attribute annotation for Status here] off begin
	@CsvBindByName(column = "STATUS", required = false)
	@Nullable
	@Column(name = "status")
	@Schema(description = "The Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Status here] end
	private String status;

	// % protected region % [Modify attribute annotation for Customer Name here] off begin
	@CsvBindByName(column = "CUSTOMER_NAME", required = false)
	@Nullable
	@Column(name = "customer_name")
	@Schema(description = "The Customer Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Customer Name here] end
	private String customerName;

	// % protected region % [Modify attribute annotation for Address here] off begin
	@CsvBindByName(column = "ADDRESS", required = false)
	@Nullable
	@Column(name = "address")
	@Schema(description = "The Address of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Address here] end
	private String address;

	// % protected region % [Modify attribute annotation for Phone Number here] off begin
	@CsvBindByName(column = "PHONE_NUMBER", required = false)
	@Nullable
	@Column(name = "phone_number")
	@Schema(description = "The Phone Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Phone Number here] end
	private String phoneNumber;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Payment Status here] off begin
	@CsvBindByName(column = "PAYMENT_STATUS", required = false)
	@Nullable
	@Column(name = "payment_status")
	@Schema(description = "The Payment Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Payment Status here] end
	private String paymentStatus;

	// % protected region % [Modify attribute annotation for Total Price here] off begin
	@CsvBindByName(column = "TOTAL_PRICE", required = false)
	@Nullable
	@Column(name = "total_price")
	@Schema(description = "The Total Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Price here] end
	private Double totalPrice;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Retail Pharmacy Invoices here] off begin
	@Schema(description = "The Retail Pharmacy Invoice entities that are related to this entity.")
	@OneToMany(mappedBy = "retailPharmacy", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Retail Pharmacy Invoices here] end
	private Set<RetailPharmacyInvoiceEntity> retailPharmacyInvoices = new HashSet<>();

	// % protected region % [Update the annotation for retailPharmacyInvoicesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "RETAIL_PHARMACY_INVOICES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for retailPharmacyInvoicesIds here] end
	private Set<UUID> retailPharmacyInvoicesIds = new HashSet<>();

	// % protected region % [Update the annotation for Retail Pharmacy Stock Details here] off begin
	@Schema(description = "The Retail Pharmacy Stock Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "retailPharmacy", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Retail Pharmacy Stock Details here] end
	private Set<RetailPharmacyStockDetailEntity> retailPharmacyStockDetails = new HashSet<>();

	// % protected region % [Update the annotation for retailPharmacyStockDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "RETAIL_PHARMACY_STOCK_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for retailPharmacyStockDetailsIds here] end
	private Set<UUID> retailPharmacyStockDetailsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Patient General Info here] off begin
	@Schema(description = "The Patient General Info entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient General Info here] end
	private PatientGeneralInfoEntity patientGeneralInfo;

	// % protected region % [Update the annotation for patientGeneralInfoId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_GENERAL_INFO_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientGeneralInfoId here] end
	private UUID patientGeneralInfoId;

	// % protected region % [Update the annotation for Warehouse here] off begin
	@Schema(description = "The Warehouse entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Warehouse here] end
	private WarehouseEntity warehouse;

	// % protected region % [Update the annotation for warehouseId here] off begin
	@Transient
	@CsvCustomBindByName(column = "WAREHOUSE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for warehouseId here] end
	private UUID warehouseId;

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
	public void addRetailPharmacyInvoices(@NotNull RetailPharmacyInvoiceEntity entity) {
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
	public void addRetailPharmacyInvoices(@NotNull Collection<RetailPharmacyInvoiceEntity> entities) {
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
	public void removeRetailPharmacyInvoices(@NotNull RetailPharmacyInvoiceEntity entity) {
		this.removeRetailPharmacyInvoices(entity, true);
	}

	/**
	 * Remove the given RetailPharmacyInvoiceEntity from this entity.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRetailPharmacyInvoices(@NotNull RetailPharmacyInvoiceEntity entity, boolean reverse) {
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
	public void removeRetailPharmacyInvoices(@NotNull Collection<RetailPharmacyInvoiceEntity> entities) {
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
	public void setRetailPharmacyInvoices(@NotNull Collection<RetailPharmacyInvoiceEntity> entities) {
		setRetailPharmacyInvoices(entities, true);
	}

	/**
	 * Replace the current entities in Retail Pharmacy Invoices with the given ones.
	 *
	 * @param entities the given collection of RetailPharmacyInvoiceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRetailPharmacyInvoices(@NotNull Collection<RetailPharmacyInvoiceEntity> entities, boolean reverseAdd) {

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
	public void addRetailPharmacyStockDetails(@NotNull RetailPharmacyStockDetailEntity entity) {
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
	public void addRetailPharmacyStockDetails(@NotNull Collection<RetailPharmacyStockDetailEntity> entities) {
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
	public void removeRetailPharmacyStockDetails(@NotNull RetailPharmacyStockDetailEntity entity) {
		this.removeRetailPharmacyStockDetails(entity, true);
	}

	/**
	 * Remove the given RetailPharmacyStockDetailEntity from this entity.
	 *
	 * @param entity the given RetailPharmacyStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRetailPharmacyStockDetails(@NotNull RetailPharmacyStockDetailEntity entity, boolean reverse) {
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
	public void removeRetailPharmacyStockDetails(@NotNull Collection<RetailPharmacyStockDetailEntity> entities) {
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
	public void setRetailPharmacyStockDetails(@NotNull Collection<RetailPharmacyStockDetailEntity> entities) {
		setRetailPharmacyStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Retail Pharmacy Stock Details with the given ones.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRetailPharmacyStockDetails(@NotNull Collection<RetailPharmacyStockDetailEntity> entities, boolean reverseAdd) {

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
	public void setPatientGeneralInfo(@NotNull PatientGeneralInfoEntity entity) {
		setPatientGeneralInfo(entity, true);
	}

	/**
	 * Set or update the patientGeneralInfo in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInfo
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInfo(@NotNull PatientGeneralInfoEntity entity, boolean reverseAdd) {
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
	public void setWarehouse(@NotNull WarehouseEntity entity) {
		setWarehouse(entity, true);
	}

	/**
	 * Set or update the warehouse in this entity with single WarehouseEntity.
	 *
	 * @param entity the given WarehouseEntity to be set or updated to warehouse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setWarehouse(@NotNull WarehouseEntity entity, boolean reverseAdd) {
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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "CUSTOMER_TYPE,RETAIL_NUMBER,STATUS,CUSTOMER_NAME,ADDRESS,PHONE_NUMBER,NOTES,PAYMENT_STATUS,TOTAL_PRICE,PATIENT_GENERAL_INFO_ID,WAREHOUSE_ID,RETAIL_PHARMACY_INVOICES_IDS,RETAIL_PHARMACY_STOCK_DETAILS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<PatientGeneralInfoEntity> patientGeneralInfoRelation = Optional.ofNullable(this.patientGeneralInfo);
		patientGeneralInfoRelation.ifPresent(entity -> this.patientGeneralInfoId = entity.getId());

		Optional<WarehouseEntity> warehouseRelation = Optional.ofNullable(this.warehouse);
		warehouseRelation.ifPresent(entity -> this.warehouseId = entity.getId());

		this.retailPharmacyInvoicesIds = new HashSet<>();
		for (RetailPharmacyInvoiceEntity retailPharmacyInvoices: this.retailPharmacyInvoices) {
			this.retailPharmacyInvoicesIds.add(retailPharmacyInvoices.getId());
		}

		this.retailPharmacyStockDetailsIds = new HashSet<>();
		for (RetailPharmacyStockDetailEntity retailPharmacyStockDetails: this.retailPharmacyStockDetails) {
			this.retailPharmacyStockDetailsIds.add(retailPharmacyStockDetails.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object retailPharmacy) {
		if (this == retailPharmacy) {
			return true;
		}
		if (retailPharmacy == null || this.getClass() != retailPharmacy.getClass()) {
			return false;
		}
		if (!super.equals(retailPharmacy)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		RetailPharmacyEntity that = (RetailPharmacyEntity) retailPharmacy;
		return
			Objects.equals(this.customerType, that.customerType) &&
			Objects.equals(this.retailNumber, that.retailNumber) &&
			Objects.equals(this.status, that.status) &&
			Objects.equals(this.customerName, that.customerName) &&
			Objects.equals(this.address, that.address) &&
			Objects.equals(this.phoneNumber, that.phoneNumber) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.paymentStatus, that.paymentStatus) &&
			Objects.equals(this.totalPrice, that.totalPrice) &&
			Objects.equals(this.retailPharmacyInvoicesIds, that.retailPharmacyInvoicesIds) &&
			Objects.equals(this.retailPharmacyStockDetailsIds, that.retailPharmacyStockDetailsIds) &&
			Objects.equals(this.patientGeneralInfoId, that.patientGeneralInfoId) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
