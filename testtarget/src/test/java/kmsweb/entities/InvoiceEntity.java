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
public class InvoiceEntity extends AbstractEntity {

	public InvoiceEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InvoiceItemsOneMany = new EntityReference();
			InvoiceItemsOneMany.entityName = "InvoiceItem";
			InvoiceItemsOneMany.oppositeName = "Invoice";
			InvoiceItemsOneMany.name = "InvoiceItems";
			InvoiceItemsOneMany.optional = true;
			InvoiceItemsOneMany.type = "One";
			InvoiceItemsOneMany.oppositeType = "Many";

		References.add(InvoiceItemsOneMany);

		var InvoicePaymentInsurancesOneMany = new EntityReference();
			InvoicePaymentInsurancesOneMany.entityName = "InvoicePaymentInsurance";
			InvoicePaymentInsurancesOneMany.oppositeName = "Invoice";
			InvoicePaymentInsurancesOneMany.name = "InvoicePaymentInsurances";
			InvoicePaymentInsurancesOneMany.optional = true;
			InvoicePaymentInsurancesOneMany.type = "One";
			InvoicePaymentInsurancesOneMany.oppositeType = "Many";

		References.add(InvoicePaymentInsurancesOneMany);

		var InvoicePaymentOtherOneOne = new EntityReference();
			InvoicePaymentOtherOneOne.entityName = "InvoicePaymentOther";
			InvoicePaymentOtherOneOne.oppositeName = "Invoice";
			InvoicePaymentOtherOneOne.name = "InvoicePaymentOther";
			InvoicePaymentOtherOneOne.optional = true;
			InvoicePaymentOtherOneOne.type = "One";
			InvoicePaymentOtherOneOne.oppositeType = "One";

		References.add(InvoicePaymentOtherOneOne);

		var InvoicePaymentSelfPayingOneOne = new EntityReference();
			InvoicePaymentSelfPayingOneOne.entityName = "InvoicePaymentSelfPaying";
			InvoicePaymentSelfPayingOneOne.oppositeName = "Invoice";
			InvoicePaymentSelfPayingOneOne.name = "InvoicePaymentSelfPaying";
			InvoicePaymentSelfPayingOneOne.optional = true;
			InvoicePaymentSelfPayingOneOne.type = "One";
			InvoicePaymentSelfPayingOneOne.oppositeType = "One";

		References.add(InvoicePaymentSelfPayingOneOne);

		var InvoiceSummaryOneOne = new EntityReference();
			InvoiceSummaryOneOne.entityName = "InvoiceSummary";
			InvoiceSummaryOneOne.oppositeName = "Invoice";
			InvoiceSummaryOneOne.name = "InvoiceSummary";
			InvoiceSummaryOneOne.optional = true;
			InvoiceSummaryOneOne.type = "One";
			InvoiceSummaryOneOne.oppositeType = "One";

		References.add(InvoiceSummaryOneOne);

		var MedicationHeaderOneOne = new EntityReference();
			MedicationHeaderOneOne.entityName = "MedicationHeader";
			MedicationHeaderOneOne.oppositeName = "MedicationHeader";
			MedicationHeaderOneOne.name = "Invoice";
			MedicationHeaderOneOne.optional = true;
			MedicationHeaderOneOne.type = "One";
			MedicationHeaderOneOne.oppositeType = "One";

		References.add(MedicationHeaderOneOne);

		var Icd10OneMany = new EntityReference();
			Icd10OneMany.entityName = "DiagnosesAndProcedures";
			Icd10OneMany.oppositeName = "Icd10";
			Icd10OneMany.name = "InvoicesICD10";
			Icd10OneMany.optional = true;
			Icd10OneMany.type = "One";
			Icd10OneMany.oppositeType = "Many";

		References.add(Icd10OneMany);

		var Icd9CMOneMany = new EntityReference();
			Icd9CMOneMany.entityName = "DiagnosesAndProcedures";
			Icd9CMOneMany.oppositeName = "Icd9CM";
			Icd9CMOneMany.name = "InvoicesICD9CM";
			Icd9CMOneMany.optional = true;
			Icd9CMOneMany.type = "One";
			Icd9CMOneMany.oppositeType = "Many";

		References.add(Icd9CMOneMany);

		var BedFacilityOneMany = new EntityReference();
			BedFacilityOneMany.entityName = "BedFacility";
			BedFacilityOneMany.oppositeName = "BedFacility";
			BedFacilityOneMany.name = "Invoices";
			BedFacilityOneMany.optional = true;
			BedFacilityOneMany.type = "One";
			BedFacilityOneMany.oppositeType = "Many";

		References.add(BedFacilityOneMany);

		var PatientVisitOneMany = new EntityReference();
			PatientVisitOneMany.entityName = "PatientVisit";
			PatientVisitOneMany.oppositeName = "PatientVisit";
			PatientVisitOneMany.name = "Invoices";
			PatientVisitOneMany.optional = true;
			PatientVisitOneMany.type = "One";
			PatientVisitOneMany.oppositeType = "Many";

		References.add(PatientVisitOneMany);

		var TariffSchemaOneMany = new EntityReference();
			TariffSchemaOneMany.entityName = "TariffSchema";
			TariffSchemaOneMany.oppositeName = "TariffSchema";
			TariffSchemaOneMany.name = "Invoices";
			TariffSchemaOneMany.optional = false;
			TariffSchemaOneMany.type = "One";
			TariffSchemaOneMany.oppositeType = "Many";

		References.add(TariffSchemaOneMany);

		var VerifiedByOneMany = new EntityReference();
			VerifiedByOneMany.entityName = "Staff";
			VerifiedByOneMany.oppositeName = "VerifiedBy";
			VerifiedByOneMany.name = "Invoices";
			VerifiedByOneMany.optional = true;
			VerifiedByOneMany.type = "One";
			VerifiedByOneMany.oppositeType = "Many";

		References.add(VerifiedByOneMany);

		var PrescriptionHeaderOneOne = new EntityReference();
			PrescriptionHeaderOneOne.entityName = "PrescriptionHeader";
			PrescriptionHeaderOneOne.oppositeName = "Invoice";
			PrescriptionHeaderOneOne.name = "PrescriptionHeader";
			PrescriptionHeaderOneOne.optional = true;
			PrescriptionHeaderOneOne.type = "One";
			PrescriptionHeaderOneOne.oppositeType = "One";

		References.add(PrescriptionHeaderOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Invoice Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Invoice Number here] end
	private String invoiceNumber;

	// % protected region % [Modify attribute annotation for Revision Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Revision Number here] end
	private Integer revisionNumber;

	// % protected region % [Modify attribute annotation for Invoice Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Invoice Status here] end
	private String invoiceStatus;

	// % protected region % [Modify attribute annotation for Invoice Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Invoice Type here] end
	private InvoiceTypeEnum invoiceType;

	// % protected region % [Modify attribute annotation for Invoice Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Invoice Date here] end
	private OffsetDateTime invoiceDate;

	// % protected region % [Modify attribute annotation for Cancel Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Cancel Date here] end
	private OffsetDateTime cancelDate;

	// % protected region % [Modify attribute annotation for Billing Location here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Billing Location here] end
	private String billingLocation;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Patient Payment Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient Payment Type here] end
	private String patientPaymentType;

	// % protected region % [Modify attribute annotation for Verification Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Verification Date here] end
	private OffsetDateTime verificationDate;

	// % protected region % [Modify attribute annotation for Display Doctor on Print here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Display Doctor on Print here] end
	private Boolean displayDoctorOnPrint;

	// % protected region % [Modify attribute annotation for Display ICD 10 on Print here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Display ICD 10 on Print here] end
	private Boolean displayICD10OnPrint;

	// % protected region % [Modify attribute annotation for Display ICD 9 CM on Print here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Display ICD 9 CM on Print here] end
	private Boolean displayICD9CMOnPrint;

	// % protected region % [Modify attribute annotation for Doctor Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor Code here] end
	private String doctorCode;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for Admission Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Admission Date here] end
	private OffsetDateTime admissionDate;

	// % protected region % [Modify attribute annotation for Discharged Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Discharged Date here] end
	private OffsetDateTime dischargedDate;

	// % protected region % [Modify attribute annotation for Claim No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Claim No here] end
	private String claimNo;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private InvoicePaymentOtherEntity invoicePaymentOther;

	private InvoicePaymentSelfPayingEntity invoicePaymentSelfPaying;

	private InvoiceSummaryEntity invoiceSummary;

	private PrescriptionHeaderEntity prescriptionHeader;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private MedicationHeaderEntity medicationHeader;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<InvoiceItemEntity> invoiceItems = new HashSet<>();

	private Set<InvoicePaymentInsuranceEntity> invoicePaymentInsurances = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private DiagnosesAndProceduresEntity icd10;

	private DiagnosesAndProceduresEntity icd9CM;

	private BedFacilityEntity bedFacility;

	private PatientVisitEntity patientVisit;

	private TariffSchemaEntity tariffSchema;

	private StaffEntity verifiedBy;

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
	 * Similar to {@link this#addInvoiceItems(InvoiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemEntity to be added to this entity
	 */
	public void addInvoiceItems(@NonNull InvoiceItemEntity entity) {
		addInvoiceItems(entity, true);
	}

	/**
	 * Add a new InvoiceItemEntity to invoiceItems in this entity.
	 *
	 * @param entity the given InvoiceItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoiceItems(@NonNull InvoiceItemEntity entity, boolean reverseAdd) {
		if (!this.invoiceItems.contains(entity)) {
			invoiceItems.add(entity);
			if (reverseAdd) {
				entity.setInvoice(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoiceItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be added to this entity
	 */
	public void addInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities) {
		addInvoiceItems(entities, true);
	}

	/**
	 * Add a new collection of InvoiceItemEntity to Invoice Items in this entity.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoiceItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoiceItems(InvoiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemEntity to be set to this entity
	 */
	public void removeInvoiceItems(@NonNull InvoiceItemEntity entity) {
		this.removeInvoiceItems(entity, true);
	}

	/**
	 * Remove the given InvoiceItemEntity from this entity.
	 *
	 * @param entity the given InvoiceItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoiceItems(@NonNull InvoiceItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInvoice(false);
		}
		this.invoiceItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoiceItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be removed to this entity
	 */
	public void removeInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities) {
		this.removeInvoiceItems(entities, true);
	}

	/**
	 * Remove the given collection of InvoiceItemEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoiceItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoiceItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be set to this entity
	 */
	public void setInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities) {
		setInvoiceItems(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Items with the given ones.
	 *
	 * @param entities the given collection of InvoiceItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {

		this.unsetInvoiceItems();
		this.invoiceItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoiceItems.forEach(invoiceItemsEntity -> invoiceItemsEntity.setInvoice(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoiceItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoiceItems() {
		this.unsetInvoiceItems(true);
	}

	/**
	 * Remove all the entities in Invoice Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoiceItems(boolean doReverse) {
		if (doReverse) {
			this.invoiceItems.forEach(invoiceItemsEntity -> invoiceItemsEntity.unsetInvoice(false));
		}
		this.invoiceItems.clear();
	}

/**
	 * Similar to {@link this#addInvoicePaymentInsurances(InvoicePaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoicePaymentInsuranceEntity to be added to this entity
	 */
	public void addInvoicePaymentInsurances(@NonNull InvoicePaymentInsuranceEntity entity) {
		addInvoicePaymentInsurances(entity, true);
	}

	/**
	 * Add a new InvoicePaymentInsuranceEntity to invoicePaymentInsurances in this entity.
	 *
	 * @param entity the given InvoicePaymentInsuranceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoicePaymentInsurances(@NonNull InvoicePaymentInsuranceEntity entity, boolean reverseAdd) {
		if (!this.invoicePaymentInsurances.contains(entity)) {
			invoicePaymentInsurances.add(entity);
			if (reverseAdd) {
				entity.setInvoice(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoicePaymentInsurances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to be added to this entity
	 */
	public void addInvoicePaymentInsurances(@NonNull Collection<InvoicePaymentInsuranceEntity> entities) {
		addInvoicePaymentInsurances(entities, true);
	}

	/**
	 * Add a new collection of InvoicePaymentInsuranceEntity to Invoice Payment Insurances in this entity.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoicePaymentInsurances(@NonNull Collection<InvoicePaymentInsuranceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoicePaymentInsurances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoicePaymentInsurances(InvoicePaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoicePaymentInsuranceEntity to be set to this entity
	 */
	public void removeInvoicePaymentInsurances(@NonNull InvoicePaymentInsuranceEntity entity) {
		this.removeInvoicePaymentInsurances(entity, true);
	}

	/**
	 * Remove the given InvoicePaymentInsuranceEntity from this entity.
	 *
	 * @param entity the given InvoicePaymentInsuranceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoicePaymentInsurances(@NonNull InvoicePaymentInsuranceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInvoice(false);
		}
		this.invoicePaymentInsurances.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoicePaymentInsurances(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to be removed to this entity
	 */
	public void removeInvoicePaymentInsurances(@NonNull Collection<InvoicePaymentInsuranceEntity> entities) {
		this.removeInvoicePaymentInsurances(entities, true);
	}

	/**
	 * Remove the given collection of InvoicePaymentInsuranceEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoicePaymentInsurances(@NonNull Collection<InvoicePaymentInsuranceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoicePaymentInsurances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoicePaymentInsurances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to be set to this entity
	 */
	public void setInvoicePaymentInsurances(@NonNull Collection<InvoicePaymentInsuranceEntity> entities) {
		setInvoicePaymentInsurances(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Payment Insurances with the given ones.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoicePaymentInsurances(@NonNull Collection<InvoicePaymentInsuranceEntity> entities, boolean reverseAdd) {

		this.unsetInvoicePaymentInsurances();
		this.invoicePaymentInsurances = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoicePaymentInsurances.forEach(invoicePaymentInsurancesEntity -> invoicePaymentInsurancesEntity.setInvoice(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoicePaymentInsurances(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoicePaymentInsurances() {
		this.unsetInvoicePaymentInsurances(true);
	}

	/**
	 * Remove all the entities in Invoice Payment Insurances from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoicePaymentInsurances(boolean doReverse) {
		if (doReverse) {
			this.invoicePaymentInsurances.forEach(invoicePaymentInsurancesEntity -> invoicePaymentInsurancesEntity.unsetInvoice(false));
		}
		this.invoicePaymentInsurances.clear();
	}

	/**
	 * Similar to {@link this#setInvoicePaymentOther(InvoicePaymentOtherEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void setInvoicePaymentOther(@NonNull InvoicePaymentOtherEntity entity) {
		setInvoicePaymentOther(entity, true);
	}

	/**
	 * Set or update invoicePaymentOther with the given InvoicePaymentOtherEntity.
	 *
	 * @param entity the InvoiceEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoicePaymentOther(@NonNull InvoicePaymentOtherEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInvoicePaymentOther here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInvoicePaymentOther here] end

		if (sameAsFormer(this.invoicePaymentOther, entity)) {
			return;
		}

		if (this.invoicePaymentOther != null) {
			this.invoicePaymentOther.unsetInvoice();
		}

		this.invoicePaymentOther = entity;

		if (reverseAdd) {
			this.invoicePaymentOther.setInvoice(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInvoicePaymentOther outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInvoicePaymentOther outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetInvoicePaymentOther(boolean)} but default to true.
	 */
	public void unsetInvoicePaymentOther() {
		this.unsetInvoicePaymentOther(true);
	}

	/**
	 * Remove the InvoicePaymentOtherEntity in Invoice Payment Other from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInvoicePaymentOther(boolean reverse) {
		if (reverse && this.invoicePaymentOther != null) {
			this.invoicePaymentOther.unsetInvoice(false);
		}
		this.invoicePaymentOther = null;
	}

	/**
	 * Similar to {@link this#setInvoicePaymentSelfPaying(InvoicePaymentSelfPayingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void setInvoicePaymentSelfPaying(@NonNull InvoicePaymentSelfPayingEntity entity) {
		setInvoicePaymentSelfPaying(entity, true);
	}

	/**
	 * Set or update invoicePaymentSelfPaying with the given InvoicePaymentSelfPayingEntity.
	 *
	 * @param entity the InvoiceEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoicePaymentSelfPaying(@NonNull InvoicePaymentSelfPayingEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInvoicePaymentSelfPaying here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInvoicePaymentSelfPaying here] end

		if (sameAsFormer(this.invoicePaymentSelfPaying, entity)) {
			return;
		}

		if (this.invoicePaymentSelfPaying != null) {
			this.invoicePaymentSelfPaying.unsetInvoice();
		}

		this.invoicePaymentSelfPaying = entity;

		if (reverseAdd) {
			this.invoicePaymentSelfPaying.setInvoice(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInvoicePaymentSelfPaying outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInvoicePaymentSelfPaying outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetInvoicePaymentSelfPaying(boolean)} but default to true.
	 */
	public void unsetInvoicePaymentSelfPaying() {
		this.unsetInvoicePaymentSelfPaying(true);
	}

	/**
	 * Remove the InvoicePaymentSelfPayingEntity in Invoice Payment Self Paying from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInvoicePaymentSelfPaying(boolean reverse) {
		if (reverse && this.invoicePaymentSelfPaying != null) {
			this.invoicePaymentSelfPaying.unsetInvoice(false);
		}
		this.invoicePaymentSelfPaying = null;
	}

	/**
	 * Similar to {@link this#setInvoiceSummary(InvoiceSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void setInvoiceSummary(@NonNull InvoiceSummaryEntity entity) {
		setInvoiceSummary(entity, true);
	}

	/**
	 * Set or update invoiceSummary with the given InvoiceSummaryEntity.
	 *
	 * @param entity the InvoiceEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoiceSummary(@NonNull InvoiceSummaryEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInvoiceSummary here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInvoiceSummary here] end

		if (sameAsFormer(this.invoiceSummary, entity)) {
			return;
		}

		if (this.invoiceSummary != null) {
			this.invoiceSummary.unsetInvoice();
		}

		this.invoiceSummary = entity;

		if (reverseAdd) {
			this.invoiceSummary.setInvoice(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInvoiceSummary outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInvoiceSummary outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetInvoiceSummary(boolean)} but default to true.
	 */
	public void unsetInvoiceSummary() {
		this.unsetInvoiceSummary(true);
	}

	/**
	 * Remove the InvoiceSummaryEntity in Invoice Summary from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInvoiceSummary(boolean reverse) {
		if (reverse && this.invoiceSummary != null) {
			this.invoiceSummary.unsetInvoice(false);
		}
		this.invoiceSummary = null;
	}

	/**
	 * Similar to {@link this#setPrescriptionHeader(PrescriptionHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void setPrescriptionHeader(@NonNull PrescriptionHeaderEntity entity) {
		setPrescriptionHeader(entity, true);
	}

	/**
	 * Set or update prescriptionHeader with the given PrescriptionHeaderEntity.
	 *
	 * @param entity the InvoiceEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPrescriptionHeader(@NonNull PrescriptionHeaderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPrescriptionHeader here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPrescriptionHeader here] end

		if (sameAsFormer(this.prescriptionHeader, entity)) {
			return;
		}

		if (this.prescriptionHeader != null) {
			this.prescriptionHeader.unsetInvoice();
		}

		this.prescriptionHeader = entity;

		if (reverseAdd) {
			this.prescriptionHeader.setInvoice(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPrescriptionHeader outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPrescriptionHeader outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPrescriptionHeader(boolean)} but default to true.
	 */
	public void unsetPrescriptionHeader() {
		this.unsetPrescriptionHeader(true);
	}

	/**
	 * Remove the PrescriptionHeaderEntity in Prescription Header from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPrescriptionHeader(boolean reverse) {
		if (reverse && this.prescriptionHeader != null) {
			this.prescriptionHeader.unsetInvoice(false);
		}
		this.prescriptionHeader = null;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setMedicationHeader(MedicationHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationHeaderEntity to be set to this entity
	 */
	public void setMedicationHeader(MedicationHeaderEntity entity) {
		setMedicationHeader(entity, true);
	}

	/**
	 * Set or update the medicationHeader in this entity with single MedicationHeaderEntity.
	 *
	 * @param entity the given MedicationHeaderEntity to be set or updated to medicationHeader
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicationHeader(MedicationHeaderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicationHeader here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicationHeader here] end

		if (sameAsFormer(this.medicationHeader, entity)) {
			return;
		}

		if (this.medicationHeader != null) {
			this.medicationHeader.unsetInvoice(false);
		}

		this.medicationHeader = entity;
		if (reverseAdd) {
			this.medicationHeader.setInvoice(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicationHeader incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicationHeader incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicationHeader(boolean)} but default to true.
	 */
	public void unsetMedicationHeader() {
		this.unsetMedicationHeader(true);
	}

	/**
	 * Remove the MedicationHeaderEntity of medicationHeader from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicationHeader(boolean reverse) {
		if (reverse && this.medicationHeader != null) {
			this.medicationHeader.unsetInvoice();
		}
		this.medicationHeader = null;
	}
	/**
	 * Similar to {@link this#setIcd10(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setIcd10(@NonNull DiagnosesAndProceduresEntity entity) {
		setIcd10(entity, true);
	}

	/**
	 * Set or update the icd10 in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to icd10
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setIcd10(@NonNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setIcd10 here] off begin
		// % protected region % [Add any additional logic here before the main logic for setIcd10 here] end

		if (sameAsFormer(this.icd10, entity)) {
			return;
		}

		if (this.icd10 != null) {
			this.icd10.removeInvoicesICD10(this, false);
		}
		this.icd10 = entity;
		if (reverseAdd) {
			this.icd10.addInvoicesICD10(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setIcd10 incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setIcd10 incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetIcd10(boolean)} but default to true.
	 */
	public void unsetIcd10() {
		this.unsetIcd10(true);
	}

	/**
	 * Remove ICD 10 in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetIcd10(boolean reverse) {
		if (reverse && this.icd10 != null) {
			this.icd10.removeInvoicesICD10(this, false);
		}
		this.icd10 = null;
	}
	/**
	 * Similar to {@link this#setIcd9CM(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setIcd9CM(@NonNull DiagnosesAndProceduresEntity entity) {
		setIcd9CM(entity, true);
	}

	/**
	 * Set or update the icd9CM in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to icd9CM
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setIcd9CM(@NonNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setIcd9CM here] off begin
		// % protected region % [Add any additional logic here before the main logic for setIcd9CM here] end

		if (sameAsFormer(this.icd9CM, entity)) {
			return;
		}

		if (this.icd9CM != null) {
			this.icd9CM.removeInvoicesICD9CM(this, false);
		}
		this.icd9CM = entity;
		if (reverseAdd) {
			this.icd9CM.addInvoicesICD9CM(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setIcd9CM incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setIcd9CM incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetIcd9CM(boolean)} but default to true.
	 */
	public void unsetIcd9CM() {
		this.unsetIcd9CM(true);
	}

	/**
	 * Remove ICD 9 CM in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetIcd9CM(boolean reverse) {
		if (reverse && this.icd9CM != null) {
			this.icd9CM.removeInvoicesICD9CM(this, false);
		}
		this.icd9CM = null;
	}
	/**
	 * Similar to {@link this#setBedFacility(BedFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedFacilityEntity to be set to this entity
	 */
	public void setBedFacility(@NonNull BedFacilityEntity entity) {
		setBedFacility(entity, true);
	}

	/**
	 * Set or update the bedFacility in this entity with single BedFacilityEntity.
	 *
	 * @param entity the given BedFacilityEntity to be set or updated to bedFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBedFacility(@NonNull BedFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBedFacility here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBedFacility here] end

		if (sameAsFormer(this.bedFacility, entity)) {
			return;
		}

		if (this.bedFacility != null) {
			this.bedFacility.removeInvoices(this, false);
		}
		this.bedFacility = entity;
		if (reverseAdd) {
			this.bedFacility.addInvoices(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBedFacility incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBedFacility incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBedFacility(boolean)} but default to true.
	 */
	public void unsetBedFacility() {
		this.unsetBedFacility(true);
	}

	/**
	 * Remove Bed Facility in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBedFacility(boolean reverse) {
		if (reverse && this.bedFacility != null) {
			this.bedFacility.removeInvoices(this, false);
		}
		this.bedFacility = null;
	}
	/**
	 * Similar to {@link this#setPatientVisit(PatientVisitEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setPatientVisit(@NonNull PatientVisitEntity entity) {
		setPatientVisit(entity, true);
	}

	/**
	 * Set or update the patientVisit in this entity with single PatientVisitEntity.
	 *
	 * @param entity the given PatientVisitEntity to be set or updated to patientVisit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisit(@NonNull PatientVisitEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] end

		if (sameAsFormer(this.patientVisit, entity)) {
			return;
		}

		if (this.patientVisit != null) {
			this.patientVisit.removeInvoices(this, false);
		}
		this.patientVisit = entity;
		if (reverseAdd) {
			this.patientVisit.addInvoices(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientVisit(boolean)} but default to true.
	 */
	public void unsetPatientVisit() {
		this.unsetPatientVisit(true);
	}

	/**
	 * Remove Patient Visit in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientVisit(boolean reverse) {
		if (reverse && this.patientVisit != null) {
			this.patientVisit.removeInvoices(this, false);
		}
		this.patientVisit = null;
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
			this.tariffSchema.removeInvoices(this, false);
		}
		this.tariffSchema = entity;
		if (reverseAdd) {
			this.tariffSchema.addInvoices(this, false);
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
			this.tariffSchema.removeInvoices(this, false);
		}
		this.tariffSchema = null;
	}
	/**
	 * Similar to {@link this#setVerifiedBy(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setVerifiedBy(@NonNull StaffEntity entity) {
		setVerifiedBy(entity, true);
	}

	/**
	 * Set or update the verifiedBy in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to verifiedBy
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setVerifiedBy(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setVerifiedBy here] off begin
		// % protected region % [Add any additional logic here before the main logic for setVerifiedBy here] end

		if (sameAsFormer(this.verifiedBy, entity)) {
			return;
		}

		if (this.verifiedBy != null) {
			this.verifiedBy.removeInvoices(this, false);
		}
		this.verifiedBy = entity;
		if (reverseAdd) {
			this.verifiedBy.addInvoices(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setVerifiedBy incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setVerifiedBy incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetVerifiedBy(boolean)} but default to true.
	 */
	public void unsetVerifiedBy() {
		this.unsetVerifiedBy(true);
	}

	/**
	 * Remove Verified By in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetVerifiedBy(boolean reverse) {
		if (reverse && this.verifiedBy != null) {
			this.verifiedBy.removeInvoices(this, false);
		}
		this.verifiedBy = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
