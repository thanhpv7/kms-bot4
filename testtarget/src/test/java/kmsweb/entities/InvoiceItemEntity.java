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

import kmsweb.entities.enums.*;
import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class InvoiceItemEntity extends AbstractEntity {

	public InvoiceItemEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InvoiceItemComponentsOneMany = new EntityReference();
			InvoiceItemComponentsOneMany.entityName = "InvoiceItemComponent";
			InvoiceItemComponentsOneMany.oppositeName = "InvoiceItem";
			InvoiceItemComponentsOneMany.name = "InvoiceItemComponents";
			InvoiceItemComponentsOneMany.optional = true;
			InvoiceItemComponentsOneMany.type = "One";
			InvoiceItemComponentsOneMany.oppositeType = "Many";

		References.add(InvoiceItemComponentsOneMany);

		var InvoiceOneMany = new EntityReference();
			InvoiceOneMany.entityName = "Invoice";
			InvoiceOneMany.oppositeName = "Invoice";
			InvoiceOneMany.name = "InvoiceItems";
			InvoiceOneMany.optional = true;
			InvoiceOneMany.type = "One";
			InvoiceOneMany.oppositeType = "Many";

		References.add(InvoiceOneMany);

		var MedicalFeeOneMany = new EntityReference();
			MedicalFeeOneMany.entityName = "MedicalFee";
			MedicalFeeOneMany.oppositeName = "MedicalFee";
			MedicalFeeOneMany.name = "InvoiceItems";
			MedicalFeeOneMany.optional = true;
			MedicalFeeOneMany.type = "One";
			MedicalFeeOneMany.oppositeType = "Many";

		References.add(MedicalFeeOneMany);

		var MedicationHeaderOneMany = new EntityReference();
			MedicationHeaderOneMany.entityName = "MedicationHeader";
			MedicationHeaderOneMany.oppositeName = "MedicationHeader";
			MedicationHeaderOneMany.name = "InvoiceItems";
			MedicationHeaderOneMany.optional = true;
			MedicationHeaderOneMany.type = "One";
			MedicationHeaderOneMany.oppositeType = "Many";

		References.add(MedicationHeaderOneMany);

		var PrescriptionOneMany = new EntityReference();
			PrescriptionOneMany.entityName = "PrescriptionHeader";
			PrescriptionOneMany.oppositeName = "Prescription";
			PrescriptionOneMany.name = "InvoiceItems";
			PrescriptionOneMany.optional = true;
			PrescriptionOneMany.type = "One";
			PrescriptionOneMany.oppositeType = "Many";

		References.add(PrescriptionOneMany);

		var RetailPharmacyInvoiceOneMany = new EntityReference();
			RetailPharmacyInvoiceOneMany.entityName = "RetailPharmacyInvoice";
			RetailPharmacyInvoiceOneMany.oppositeName = "RetailPharmacyInvoice";
			RetailPharmacyInvoiceOneMany.name = "InvoiceItems";
			RetailPharmacyInvoiceOneMany.optional = true;
			RetailPharmacyInvoiceOneMany.type = "One";
			RetailPharmacyInvoiceOneMany.oppositeType = "Many";

		References.add(RetailPharmacyInvoiceOneMany);

		var ServiceNumberOneMany = new EntityReference();
			ServiceNumberOneMany.entityName = "Registration";
			ServiceNumberOneMany.oppositeName = "ServiceNumber";
			ServiceNumberOneMany.name = "InvoiceItems";
			ServiceNumberOneMany.optional = true;
			ServiceNumberOneMany.type = "One";
			ServiceNumberOneMany.oppositeType = "Many";

		References.add(ServiceNumberOneMany);

		var TariffSchemaOneMany = new EntityReference();
			TariffSchemaOneMany.entityName = "TariffSchema";
			TariffSchemaOneMany.oppositeName = "TariffSchema";
			TariffSchemaOneMany.name = "InvoiceItems";
			TariffSchemaOneMany.optional = true;
			TariffSchemaOneMany.type = "One";
			TariffSchemaOneMany.oppositeType = "Many";

		References.add(TariffSchemaOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Transaction Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Transaction Date here] end
	private OffsetDateTime transactionDate;

	// % protected region % [Modify attribute annotation for Tariff Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tariff Code here] end
	private String tariffCode;

	// % protected region % [Modify attribute annotation for Tariff Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tariff Type here] end
	private TariffTypeEnum tariffType;

	// % protected region % [Modify attribute annotation for Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Name here] end
	private String name;

	// % protected region % [Modify attribute annotation for Medical Staff Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Medical Staff Code here] end
	private String medicalStaffCode;

	// % protected region % [Modify attribute annotation for Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Price here] end
	private Double price;

	// % protected region % [Modify attribute annotation for Hospital Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Price here] end
	private Double hospitalPrice;

	// % protected region % [Modify attribute annotation for Total Other Component Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Other Component Price here] end
	private Double totalOtherComponentPrice;

	// % protected region % [Modify attribute annotation for Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity here] end
	private Double quantity;

	// % protected region % [Modify attribute annotation for Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Unit here] end
	private String unit;

	// % protected region % [Modify attribute annotation for Discount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Discount here] end
	private Double discount;

	// % protected region % [Modify attribute annotation for Tax here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax here] end
	private Boolean tax;

	// % protected region % [Modify attribute annotation for Item Total here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Total here] end
	private Double itemTotal;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

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

	private Set<InvoiceItemComponentEntity> invoiceItemComponents = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private InvoiceEntity invoice;

	private MedicalFeeEntity medicalFee;

	private MedicationHeaderEntity medicationHeader;

	private PrescriptionHeaderEntity prescription;

	private RetailPharmacyInvoiceEntity retailPharmacyInvoice;

	private RegistrationEntity serviceNumber;

	private TariffSchemaEntity tariffSchema;

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
	 * Similar to {@link this#addInvoiceItemComponents(InvoiceItemComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemComponentEntity to be added to this entity
	 */
	public void addInvoiceItemComponents(@NonNull InvoiceItemComponentEntity entity) {
		addInvoiceItemComponents(entity, true);
	}

	/**
	 * Add a new InvoiceItemComponentEntity to invoiceItemComponents in this entity.
	 *
	 * @param entity the given InvoiceItemComponentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoiceItemComponents(@NonNull InvoiceItemComponentEntity entity, boolean reverseAdd) {
		if (!this.invoiceItemComponents.contains(entity)) {
			invoiceItemComponents.add(entity);
			if (reverseAdd) {
				entity.setInvoiceItem(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoiceItemComponents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to be added to this entity
	 */
	public void addInvoiceItemComponents(@NonNull Collection<InvoiceItemComponentEntity> entities) {
		addInvoiceItemComponents(entities, true);
	}

	/**
	 * Add a new collection of InvoiceItemComponentEntity to Invoice Item Components in this entity.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoiceItemComponents(@NonNull Collection<InvoiceItemComponentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoiceItemComponents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoiceItemComponents(InvoiceItemComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemComponentEntity to be set to this entity
	 */
	public void removeInvoiceItemComponents(@NonNull InvoiceItemComponentEntity entity) {
		this.removeInvoiceItemComponents(entity, true);
	}

	/**
	 * Remove the given InvoiceItemComponentEntity from this entity.
	 *
	 * @param entity the given InvoiceItemComponentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoiceItemComponents(@NonNull InvoiceItemComponentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInvoiceItem(false);
		}
		this.invoiceItemComponents.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoiceItemComponents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to be removed to this entity
	 */
	public void removeInvoiceItemComponents(@NonNull Collection<InvoiceItemComponentEntity> entities) {
		this.removeInvoiceItemComponents(entities, true);
	}

	/**
	 * Remove the given collection of InvoiceItemComponentEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoiceItemComponents(@NonNull Collection<InvoiceItemComponentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoiceItemComponents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoiceItemComponents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to be set to this entity
	 */
	public void setInvoiceItemComponents(@NonNull Collection<InvoiceItemComponentEntity> entities) {
		setInvoiceItemComponents(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Item Components with the given ones.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoiceItemComponents(@NonNull Collection<InvoiceItemComponentEntity> entities, boolean reverseAdd) {

		this.unsetInvoiceItemComponents();
		this.invoiceItemComponents = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoiceItemComponents.forEach(invoiceItemComponentsEntity -> invoiceItemComponentsEntity.setInvoiceItem(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoiceItemComponents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoiceItemComponents() {
		this.unsetInvoiceItemComponents(true);
	}

	/**
	 * Remove all the entities in Invoice Item Components from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoiceItemComponents(boolean doReverse) {
		if (doReverse) {
			this.invoiceItemComponents.forEach(invoiceItemComponentsEntity -> invoiceItemComponentsEntity.unsetInvoiceItem(false));
		}
		this.invoiceItemComponents.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setInvoice(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void setInvoice(@NonNull InvoiceEntity entity) {
		setInvoice(entity, true);
	}

	/**
	 * Set or update the invoice in this entity with single InvoiceEntity.
	 *
	 * @param entity the given InvoiceEntity to be set or updated to invoice
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoice(@NonNull InvoiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInvoice here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInvoice here] end

		if (sameAsFormer(this.invoice, entity)) {
			return;
		}

		if (this.invoice != null) {
			this.invoice.removeInvoiceItems(this, false);
		}
		this.invoice = entity;
		if (reverseAdd) {
			this.invoice.addInvoiceItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInvoice incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInvoice incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInvoice(boolean)} but default to true.
	 */
	public void unsetInvoice() {
		this.unsetInvoice(true);
	}

	/**
	 * Remove Invoice in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInvoice(boolean reverse) {
		if (reverse && this.invoice != null) {
			this.invoice.removeInvoiceItems(this, false);
		}
		this.invoice = null;
	}
	/**
	 * Similar to {@link this#setMedicalFee(MedicalFeeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalFeeEntity to be set to this entity
	 */
	public void setMedicalFee(@NonNull MedicalFeeEntity entity) {
		setMedicalFee(entity, true);
	}

	/**
	 * Set or update the medicalFee in this entity with single MedicalFeeEntity.
	 *
	 * @param entity the given MedicalFeeEntity to be set or updated to medicalFee
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalFee(@NonNull MedicalFeeEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalFee here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalFee here] end

		if (sameAsFormer(this.medicalFee, entity)) {
			return;
		}

		if (this.medicalFee != null) {
			this.medicalFee.removeInvoiceItems(this, false);
		}
		this.medicalFee = entity;
		if (reverseAdd) {
			this.medicalFee.addInvoiceItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalFee incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalFee incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalFee(boolean)} but default to true.
	 */
	public void unsetMedicalFee() {
		this.unsetMedicalFee(true);
	}

	/**
	 * Remove Medical Fee in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalFee(boolean reverse) {
		if (reverse && this.medicalFee != null) {
			this.medicalFee.removeInvoiceItems(this, false);
		}
		this.medicalFee = null;
	}
	/**
	 * Similar to {@link this#setMedicationHeader(MedicationHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationHeaderEntity to be set to this entity
	 */
	public void setMedicationHeader(@NonNull MedicationHeaderEntity entity) {
		setMedicationHeader(entity, true);
	}

	/**
	 * Set or update the medicationHeader in this entity with single MedicationHeaderEntity.
	 *
	 * @param entity the given MedicationHeaderEntity to be set or updated to medicationHeader
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicationHeader(@NonNull MedicationHeaderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicationHeader here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicationHeader here] end

		if (sameAsFormer(this.medicationHeader, entity)) {
			return;
		}

		if (this.medicationHeader != null) {
			this.medicationHeader.removeInvoiceItems(this, false);
		}
		this.medicationHeader = entity;
		if (reverseAdd) {
			this.medicationHeader.addInvoiceItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicationHeader incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicationHeader incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicationHeader(boolean)} but default to true.
	 */
	public void unsetMedicationHeader() {
		this.unsetMedicationHeader(true);
	}

	/**
	 * Remove Medication Header in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicationHeader(boolean reverse) {
		if (reverse && this.medicationHeader != null) {
			this.medicationHeader.removeInvoiceItems(this, false);
		}
		this.medicationHeader = null;
	}
	/**
	 * Similar to {@link this#setPrescription(PrescriptionHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be set to this entity
	 */
	public void setPrescription(@NonNull PrescriptionHeaderEntity entity) {
		setPrescription(entity, true);
	}

	/**
	 * Set or update the prescription in this entity with single PrescriptionHeaderEntity.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be set or updated to prescription
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPrescription(@NonNull PrescriptionHeaderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPrescription here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPrescription here] end

		if (sameAsFormer(this.prescription, entity)) {
			return;
		}

		if (this.prescription != null) {
			this.prescription.removeInvoiceItems(this, false);
		}
		this.prescription = entity;
		if (reverseAdd) {
			this.prescription.addInvoiceItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPrescription incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPrescription incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPrescription(boolean)} but default to true.
	 */
	public void unsetPrescription() {
		this.unsetPrescription(true);
	}

	/**
	 * Remove Prescription in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPrescription(boolean reverse) {
		if (reverse && this.prescription != null) {
			this.prescription.removeInvoiceItems(this, false);
		}
		this.prescription = null;
	}
	/**
	 * Similar to {@link this#setRetailPharmacyInvoice(RetailPharmacyInvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity to be set to this entity
	 */
	public void setRetailPharmacyInvoice(@NonNull RetailPharmacyInvoiceEntity entity) {
		setRetailPharmacyInvoice(entity, true);
	}

	/**
	 * Set or update the retailPharmacyInvoice in this entity with single RetailPharmacyInvoiceEntity.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity to be set or updated to retailPharmacyInvoice
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRetailPharmacyInvoice(@NonNull RetailPharmacyInvoiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRetailPharmacyInvoice here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRetailPharmacyInvoice here] end

		if (sameAsFormer(this.retailPharmacyInvoice, entity)) {
			return;
		}

		if (this.retailPharmacyInvoice != null) {
			this.retailPharmacyInvoice.removeInvoiceItems(this, false);
		}
		this.retailPharmacyInvoice = entity;
		if (reverseAdd) {
			this.retailPharmacyInvoice.addInvoiceItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRetailPharmacyInvoice incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRetailPharmacyInvoice incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRetailPharmacyInvoice(boolean)} but default to true.
	 */
	public void unsetRetailPharmacyInvoice() {
		this.unsetRetailPharmacyInvoice(true);
	}

	/**
	 * Remove Retail Pharmacy Invoice in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRetailPharmacyInvoice(boolean reverse) {
		if (reverse && this.retailPharmacyInvoice != null) {
			this.retailPharmacyInvoice.removeInvoiceItems(this, false);
		}
		this.retailPharmacyInvoice = null;
	}
	/**
	 * Similar to {@link this#setServiceNumber(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setServiceNumber(@NonNull RegistrationEntity entity) {
		setServiceNumber(entity, true);
	}

	/**
	 * Set or update the serviceNumber in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to serviceNumber
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setServiceNumber(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setServiceNumber here] off begin
		// % protected region % [Add any additional logic here before the main logic for setServiceNumber here] end

		if (sameAsFormer(this.serviceNumber, entity)) {
			return;
		}

		if (this.serviceNumber != null) {
			this.serviceNumber.removeInvoiceItems(this, false);
		}
		this.serviceNumber = entity;
		if (reverseAdd) {
			this.serviceNumber.addInvoiceItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setServiceNumber incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setServiceNumber incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetServiceNumber(boolean)} but default to true.
	 */
	public void unsetServiceNumber() {
		this.unsetServiceNumber(true);
	}

	/**
	 * Remove Service Number in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetServiceNumber(boolean reverse) {
		if (reverse && this.serviceNumber != null) {
			this.serviceNumber.removeInvoiceItems(this, false);
		}
		this.serviceNumber = null;
	}
	/**
	 * Similar to {@link this#setTariffSchema(TariffSchemaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffSchemaEntity to be set to this entity
	 */
	public void setTariffSchema(@NonNull TariffSchemaEntity entity) {
		setTariffSchema(entity, true);
	}

	/**
	 * Set or update the tariffSchema in this entity with single TariffSchemaEntity.
	 *
	 * @param entity the given TariffSchemaEntity to be set or updated to tariffSchema
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setTariffSchema(@NonNull TariffSchemaEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setTariffSchema here] off begin
		// % protected region % [Add any additional logic here before the main logic for setTariffSchema here] end

		if (sameAsFormer(this.tariffSchema, entity)) {
			return;
		}

		if (this.tariffSchema != null) {
			this.tariffSchema.removeInvoiceItems(this, false);
		}
		this.tariffSchema = entity;
		if (reverseAdd) {
			this.tariffSchema.addInvoiceItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setTariffSchema incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setTariffSchema incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetTariffSchema(boolean)} but default to true.
	 */
	public void unsetTariffSchema() {
		this.unsetTariffSchema(true);
	}

	/**
	 * Remove Tariff Schema in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetTariffSchema(boolean reverse) {
		if (reverse && this.tariffSchema != null) {
			this.tariffSchema.removeInvoiceItems(this, false);
		}
		this.tariffSchema = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
