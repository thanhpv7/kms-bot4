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
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class PatientVisitEntity extends AbstractEntity {

	public PatientVisitEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BpjsPcareRegistrationsOneOne = new EntityReference();
			BpjsPcareRegistrationsOneOne.entityName = "BpjsPcareRegistrations";
			BpjsPcareRegistrationsOneOne.oppositeName = "PatientVisit";
			BpjsPcareRegistrationsOneOne.name = "BpjsPcareRegistrations";
			BpjsPcareRegistrationsOneOne.optional = true;
			BpjsPcareRegistrationsOneOne.type = "One";
			BpjsPcareRegistrationsOneOne.oppositeType = "One";

		References.add(BpjsPcareRegistrationsOneOne);

		var BpjsVisitDatasOneMany = new EntityReference();
			BpjsVisitDatasOneMany.entityName = "BpjsVisitData";
			BpjsVisitDatasOneMany.oppositeName = "PatientVisit";
			BpjsVisitDatasOneMany.name = "BpjsVisitDatas";
			BpjsVisitDatasOneMany.optional = true;
			BpjsVisitDatasOneMany.type = "One";
			BpjsVisitDatasOneMany.oppositeType = "Many";

		References.add(BpjsVisitDatasOneMany);

		var BpjsPcarePendaftaransOneMany = new EntityReference();
			BpjsPcarePendaftaransOneMany.entityName = "BpjsPcarePendaftaran";
			BpjsPcarePendaftaransOneMany.oppositeName = "PatientVisit";
			BpjsPcarePendaftaransOneMany.name = "BpjsPcarePendaftarans";
			BpjsPcarePendaftaransOneMany.optional = true;
			BpjsPcarePendaftaransOneMany.type = "One";
			BpjsPcarePendaftaransOneMany.oppositeType = "Many";

		References.add(BpjsPcarePendaftaransOneMany);

		var InvoicesOneMany = new EntityReference();
			InvoicesOneMany.entityName = "Invoice";
			InvoicesOneMany.oppositeName = "PatientVisit";
			InvoicesOneMany.name = "Invoices";
			InvoicesOneMany.optional = true;
			InvoicesOneMany.type = "One";
			InvoicesOneMany.oppositeType = "Many";

		References.add(InvoicesOneMany);

		var PatientVisitPatientPaymentInsuranceOneOne = new EntityReference();
			PatientVisitPatientPaymentInsuranceOneOne.entityName = "PatientVisitPatientPaymentInsurance";
			PatientVisitPatientPaymentInsuranceOneOne.oppositeName = "PatientVisit";
			PatientVisitPatientPaymentInsuranceOneOne.name = "PatientVisitPatientPaymentInsurance";
			PatientVisitPatientPaymentInsuranceOneOne.optional = true;
			PatientVisitPatientPaymentInsuranceOneOne.type = "One";
			PatientVisitPatientPaymentInsuranceOneOne.oppositeType = "One";

		References.add(PatientVisitPatientPaymentInsuranceOneOne);

		var PatientVisitPatientPaymentOthersOneOne = new EntityReference();
			PatientVisitPatientPaymentOthersOneOne.entityName = "PatientVisitPatientPaymentOthers";
			PatientVisitPatientPaymentOthersOneOne.oppositeName = "PatientVisit";
			PatientVisitPatientPaymentOthersOneOne.name = "PatientVisitPatientPaymentOthers";
			PatientVisitPatientPaymentOthersOneOne.optional = true;
			PatientVisitPatientPaymentOthersOneOne.type = "One";
			PatientVisitPatientPaymentOthersOneOne.oppositeType = "One";

		References.add(PatientVisitPatientPaymentOthersOneOne);

		var PatientVisitPaymentSelfPayingOneOne = new EntityReference();
			PatientVisitPaymentSelfPayingOneOne.entityName = "PatientVisitPaymentSelfPaying";
			PatientVisitPaymentSelfPayingOneOne.oppositeName = "PatientVisit";
			PatientVisitPaymentSelfPayingOneOne.name = "PatientVisitPaymentSelfPaying";
			PatientVisitPaymentSelfPayingOneOne.optional = true;
			PatientVisitPaymentSelfPayingOneOne.type = "One";
			PatientVisitPaymentSelfPayingOneOne.oppositeType = "One";

		References.add(PatientVisitPaymentSelfPayingOneOne);

		var RegistrationsOneMany = new EntityReference();
			RegistrationsOneMany.entityName = "Registration";
			RegistrationsOneMany.oppositeName = "PatientVisit";
			RegistrationsOneMany.name = "Registrations";
			RegistrationsOneMany.optional = true;
			RegistrationsOneMany.type = "One";
			RegistrationsOneMany.oppositeType = "Many";

		References.add(RegistrationsOneMany);

		var PatientOneMany = new EntityReference();
			PatientOneMany.entityName = "PatientGeneralInfo";
			PatientOneMany.oppositeName = "Patient";
			PatientOneMany.name = "Visits";
			PatientOneMany.optional = true;
			PatientOneMany.type = "One";
			PatientOneMany.oppositeType = "Many";

		References.add(PatientOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Visit Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Visit Number here] end
	private String visitNumber;

	// % protected region % [Modify attribute annotation for Registration Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Registration Type here] end
	private String registrationType;

	// % protected region % [Modify attribute annotation for Visit Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Visit Date here] end
	private OffsetDateTime visitDate;

	// % protected region % [Modify attribute annotation for Registration Location here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Registration Location here] end
	private String registrationLocation;

	// % protected region % [Modify attribute annotation for Patient Payment Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient Payment Type here] end
	private String patientPaymentType;

	// % protected region % [Modify attribute annotation for Visit Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Visit Type here] end
	private String visitType;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private BpjsPcareRegistrationsEntity bpjsPcareRegistrations;

	private PatientVisitPatientPaymentInsuranceEntity patientVisitPatientPaymentInsurance;

	private PatientVisitPatientPaymentOthersEntity patientVisitPatientPaymentOthers;

	private PatientVisitPaymentSelfPayingEntity patientVisitPaymentSelfPaying;

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

	private Set<BpjsVisitDataEntity> bpjsVisitDatas = new HashSet<>();

	private Set<BpjsPcarePendaftaranEntity> bpjsPcarePendaftarans = new HashSet<>();

	private Set<InvoiceEntity> invoices = new HashSet<>();

	private Set<RegistrationEntity> registrations = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private PatientGeneralInfoEntity patient;

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
	 * Similar to {@link this#setBpjsPcareRegistrations(BpjsPcareRegistrationsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setBpjsPcareRegistrations(@NonNull BpjsPcareRegistrationsEntity entity) {
		setBpjsPcareRegistrations(entity, true);
	}

	/**
	 * Set or update bpjsPcareRegistrations with the given BpjsPcareRegistrationsEntity.
	 *
	 * @param entity the PatientVisitEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsPcareRegistrations(@NonNull BpjsPcareRegistrationsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsPcareRegistrations here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsPcareRegistrations here] end

		if (sameAsFormer(this.bpjsPcareRegistrations, entity)) {
			return;
		}

		if (this.bpjsPcareRegistrations != null) {
			this.bpjsPcareRegistrations.unsetPatientVisit();
		}

		this.bpjsPcareRegistrations = entity;

		if (reverseAdd) {
			this.bpjsPcareRegistrations.setPatientVisit(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsPcareRegistrations outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsPcareRegistrations outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsPcareRegistrations(boolean)} but default to true.
	 */
	public void unsetBpjsPcareRegistrations() {
		this.unsetBpjsPcareRegistrations(true);
	}

	/**
	 * Remove the BpjsPcareRegistrationsEntity in BPJS Pcare Registrations from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsPcareRegistrations(boolean reverse) {
		if (reverse && this.bpjsPcareRegistrations != null) {
			this.bpjsPcareRegistrations.unsetPatientVisit(false);
		}
		this.bpjsPcareRegistrations = null;
	}

/**
	 * Similar to {@link this#addBpjsVisitDatas(BpjsVisitDataEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsVisitDataEntity to be added to this entity
	 */
	public void addBpjsVisitDatas(@NonNull BpjsVisitDataEntity entity) {
		addBpjsVisitDatas(entity, true);
	}

	/**
	 * Add a new BpjsVisitDataEntity to bpjsVisitDatas in this entity.
	 *
	 * @param entity the given BpjsVisitDataEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsVisitDatas(@NonNull BpjsVisitDataEntity entity, boolean reverseAdd) {
		if (!this.bpjsVisitDatas.contains(entity)) {
			bpjsVisitDatas.add(entity);
			if (reverseAdd) {
				entity.setPatientVisit(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsVisitDatas(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsVisitDataEntity to be added to this entity
	 */
	public void addBpjsVisitDatas(@NonNull Collection<BpjsVisitDataEntity> entities) {
		addBpjsVisitDatas(entities, true);
	}

	/**
	 * Add a new collection of BpjsVisitDataEntity to BPJS Visit Datas in this entity.
	 *
	 * @param entities the given collection of BpjsVisitDataEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsVisitDatas(@NonNull Collection<BpjsVisitDataEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsVisitDatas(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsVisitDatas(BpjsVisitDataEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsVisitDataEntity to be set to this entity
	 */
	public void removeBpjsVisitDatas(@NonNull BpjsVisitDataEntity entity) {
		this.removeBpjsVisitDatas(entity, true);
	}

	/**
	 * Remove the given BpjsVisitDataEntity from this entity.
	 *
	 * @param entity the given BpjsVisitDataEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsVisitDatas(@NonNull BpjsVisitDataEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientVisit(false);
		}
		this.bpjsVisitDatas.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsVisitDatas(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsVisitDataEntity to be removed to this entity
	 */
	public void removeBpjsVisitDatas(@NonNull Collection<BpjsVisitDataEntity> entities) {
		this.removeBpjsVisitDatas(entities, true);
	}

	/**
	 * Remove the given collection of BpjsVisitDataEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsVisitDataEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsVisitDatas(@NonNull Collection<BpjsVisitDataEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsVisitDatas(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsVisitDatas(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsVisitDataEntity to be set to this entity
	 */
	public void setBpjsVisitDatas(@NonNull Collection<BpjsVisitDataEntity> entities) {
		setBpjsVisitDatas(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Visit Datas with the given ones.
	 *
	 * @param entities the given collection of BpjsVisitDataEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsVisitDatas(@NonNull Collection<BpjsVisitDataEntity> entities, boolean reverseAdd) {

		this.unsetBpjsVisitDatas();
		this.bpjsVisitDatas = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsVisitDatas.forEach(bpjsVisitDatasEntity -> bpjsVisitDatasEntity.setPatientVisit(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsVisitDatas(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsVisitDatas() {
		this.unsetBpjsVisitDatas(true);
	}

	/**
	 * Remove all the entities in BPJS Visit Datas from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsVisitDatas(boolean doReverse) {
		if (doReverse) {
			this.bpjsVisitDatas.forEach(bpjsVisitDatasEntity -> bpjsVisitDatasEntity.unsetPatientVisit(false));
		}
		this.bpjsVisitDatas.clear();
	}

/**
	 * Similar to {@link this#addBpjsPcarePendaftarans(BpjsPcarePendaftaranEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPcarePendaftaranEntity to be added to this entity
	 */
	public void addBpjsPcarePendaftarans(@NonNull BpjsPcarePendaftaranEntity entity) {
		addBpjsPcarePendaftarans(entity, true);
	}

	/**
	 * Add a new BpjsPcarePendaftaranEntity to bpjsPcarePendaftarans in this entity.
	 *
	 * @param entity the given BpjsPcarePendaftaranEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsPcarePendaftarans(@NonNull BpjsPcarePendaftaranEntity entity, boolean reverseAdd) {
		if (!this.bpjsPcarePendaftarans.contains(entity)) {
			bpjsPcarePendaftarans.add(entity);
			if (reverseAdd) {
				entity.setPatientVisit(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsPcarePendaftarans(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPcarePendaftaranEntity to be added to this entity
	 */
	public void addBpjsPcarePendaftarans(@NonNull Collection<BpjsPcarePendaftaranEntity> entities) {
		addBpjsPcarePendaftarans(entities, true);
	}

	/**
	 * Add a new collection of BpjsPcarePendaftaranEntity to Bpjs Pcare Pendaftarans in this entity.
	 *
	 * @param entities the given collection of BpjsPcarePendaftaranEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsPcarePendaftarans(@NonNull Collection<BpjsPcarePendaftaranEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsPcarePendaftarans(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsPcarePendaftarans(BpjsPcarePendaftaranEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPcarePendaftaranEntity to be set to this entity
	 */
	public void removeBpjsPcarePendaftarans(@NonNull BpjsPcarePendaftaranEntity entity) {
		this.removeBpjsPcarePendaftarans(entity, true);
	}

	/**
	 * Remove the given BpjsPcarePendaftaranEntity from this entity.
	 *
	 * @param entity the given BpjsPcarePendaftaranEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsPcarePendaftarans(@NonNull BpjsPcarePendaftaranEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientVisit(false);
		}
		this.bpjsPcarePendaftarans.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsPcarePendaftarans(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsPcarePendaftaranEntity to be removed to this entity
	 */
	public void removeBpjsPcarePendaftarans(@NonNull Collection<BpjsPcarePendaftaranEntity> entities) {
		this.removeBpjsPcarePendaftarans(entities, true);
	}

	/**
	 * Remove the given collection of BpjsPcarePendaftaranEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsPcarePendaftaranEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsPcarePendaftarans(@NonNull Collection<BpjsPcarePendaftaranEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsPcarePendaftarans(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsPcarePendaftarans(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPcarePendaftaranEntity to be set to this entity
	 */
	public void setBpjsPcarePendaftarans(@NonNull Collection<BpjsPcarePendaftaranEntity> entities) {
		setBpjsPcarePendaftarans(entities, true);
	}

	/**
	 * Replace the current entities in Bpjs Pcare Pendaftarans with the given ones.
	 *
	 * @param entities the given collection of BpjsPcarePendaftaranEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsPcarePendaftarans(@NonNull Collection<BpjsPcarePendaftaranEntity> entities, boolean reverseAdd) {

		this.unsetBpjsPcarePendaftarans();
		this.bpjsPcarePendaftarans = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsPcarePendaftarans.forEach(bpjsPcarePendaftaransEntity -> bpjsPcarePendaftaransEntity.setPatientVisit(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsPcarePendaftarans(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsPcarePendaftarans() {
		this.unsetBpjsPcarePendaftarans(true);
	}

	/**
	 * Remove all the entities in Bpjs Pcare Pendaftarans from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsPcarePendaftarans(boolean doReverse) {
		if (doReverse) {
			this.bpjsPcarePendaftarans.forEach(bpjsPcarePendaftaransEntity -> bpjsPcarePendaftaransEntity.unsetPatientVisit(false));
		}
		this.bpjsPcarePendaftarans.clear();
	}

/**
	 * Similar to {@link this#addInvoices(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be added to this entity
	 */
	public void addInvoices(@NonNull InvoiceEntity entity) {
		addInvoices(entity, true);
	}

	/**
	 * Add a new InvoiceEntity to invoices in this entity.
	 *
	 * @param entity the given InvoiceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoices(@NonNull InvoiceEntity entity, boolean reverseAdd) {
		if (!this.invoices.contains(entity)) {
			invoices.add(entity);
			if (reverseAdd) {
				entity.setPatientVisit(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceEntity to be added to this entity
	 */
	public void addInvoices(@NonNull Collection<InvoiceEntity> entities) {
		addInvoices(entities, true);
	}

	/**
	 * Add a new collection of InvoiceEntity to Invoices in this entity.
	 *
	 * @param entities the given collection of InvoiceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoices(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoices(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void removeInvoices(@NonNull InvoiceEntity entity) {
		this.removeInvoices(entity, true);
	}

	/**
	 * Remove the given InvoiceEntity from this entity.
	 *
	 * @param entity the given InvoiceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoices(@NonNull InvoiceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientVisit(false);
		}
		this.invoices.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoices(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoiceEntity to be removed to this entity
	 */
	public void removeInvoices(@NonNull Collection<InvoiceEntity> entities) {
		this.removeInvoices(entities, true);
	}

	/**
	 * Remove the given collection of InvoiceEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoiceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoices(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceEntity to be set to this entity
	 */
	public void setInvoices(@NonNull Collection<InvoiceEntity> entities) {
		setInvoices(entities, true);
	}

	/**
	 * Replace the current entities in Invoices with the given ones.
	 *
	 * @param entities the given collection of InvoiceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoices(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {

		this.unsetInvoices();
		this.invoices = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoices.forEach(invoicesEntity -> invoicesEntity.setPatientVisit(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoices(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoices() {
		this.unsetInvoices(true);
	}

	/**
	 * Remove all the entities in Invoices from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoices(boolean doReverse) {
		if (doReverse) {
			this.invoices.forEach(invoicesEntity -> invoicesEntity.unsetPatientVisit(false));
		}
		this.invoices.clear();
	}

	/**
	 * Similar to {@link this#setPatientVisitPatientPaymentInsurance(PatientVisitPatientPaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setPatientVisitPatientPaymentInsurance(@NonNull PatientVisitPatientPaymentInsuranceEntity entity) {
		setPatientVisitPatientPaymentInsurance(entity, true);
	}

	/**
	 * Set or update patientVisitPatientPaymentInsurance with the given PatientVisitPatientPaymentInsuranceEntity.
	 *
	 * @param entity the PatientVisitEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisitPatientPaymentInsurance(@NonNull PatientVisitPatientPaymentInsuranceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientVisitPatientPaymentInsurance here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientVisitPatientPaymentInsurance here] end

		if (sameAsFormer(this.patientVisitPatientPaymentInsurance, entity)) {
			return;
		}

		if (this.patientVisitPatientPaymentInsurance != null) {
			this.patientVisitPatientPaymentInsurance.unsetPatientVisit();
		}

		this.patientVisitPatientPaymentInsurance = entity;

		if (reverseAdd) {
			this.patientVisitPatientPaymentInsurance.setPatientVisit(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientVisitPatientPaymentInsurance outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientVisitPatientPaymentInsurance outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientVisitPatientPaymentInsurance(boolean)} but default to true.
	 */
	public void unsetPatientVisitPatientPaymentInsurance() {
		this.unsetPatientVisitPatientPaymentInsurance(true);
	}

	/**
	 * Remove the PatientVisitPatientPaymentInsuranceEntity in Patient Visit Patient Payment Insurance from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientVisitPatientPaymentInsurance(boolean reverse) {
		if (reverse && this.patientVisitPatientPaymentInsurance != null) {
			this.patientVisitPatientPaymentInsurance.unsetPatientVisit(false);
		}
		this.patientVisitPatientPaymentInsurance = null;
	}

	/**
	 * Similar to {@link this#setPatientVisitPatientPaymentOthers(PatientVisitPatientPaymentOthersEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setPatientVisitPatientPaymentOthers(@NonNull PatientVisitPatientPaymentOthersEntity entity) {
		setPatientVisitPatientPaymentOthers(entity, true);
	}

	/**
	 * Set or update patientVisitPatientPaymentOthers with the given PatientVisitPatientPaymentOthersEntity.
	 *
	 * @param entity the PatientVisitEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisitPatientPaymentOthers(@NonNull PatientVisitPatientPaymentOthersEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientVisitPatientPaymentOthers here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientVisitPatientPaymentOthers here] end

		if (sameAsFormer(this.patientVisitPatientPaymentOthers, entity)) {
			return;
		}

		if (this.patientVisitPatientPaymentOthers != null) {
			this.patientVisitPatientPaymentOthers.unsetPatientVisit();
		}

		this.patientVisitPatientPaymentOthers = entity;

		if (reverseAdd) {
			this.patientVisitPatientPaymentOthers.setPatientVisit(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientVisitPatientPaymentOthers outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientVisitPatientPaymentOthers outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientVisitPatientPaymentOthers(boolean)} but default to true.
	 */
	public void unsetPatientVisitPatientPaymentOthers() {
		this.unsetPatientVisitPatientPaymentOthers(true);
	}

	/**
	 * Remove the PatientVisitPatientPaymentOthersEntity in Patient Visit Patient Payment Others from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientVisitPatientPaymentOthers(boolean reverse) {
		if (reverse && this.patientVisitPatientPaymentOthers != null) {
			this.patientVisitPatientPaymentOthers.unsetPatientVisit(false);
		}
		this.patientVisitPatientPaymentOthers = null;
	}

	/**
	 * Similar to {@link this#setPatientVisitPaymentSelfPaying(PatientVisitPaymentSelfPayingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setPatientVisitPaymentSelfPaying(@NonNull PatientVisitPaymentSelfPayingEntity entity) {
		setPatientVisitPaymentSelfPaying(entity, true);
	}

	/**
	 * Set or update patientVisitPaymentSelfPaying with the given PatientVisitPaymentSelfPayingEntity.
	 *
	 * @param entity the PatientVisitEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisitPaymentSelfPaying(@NonNull PatientVisitPaymentSelfPayingEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientVisitPaymentSelfPaying here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientVisitPaymentSelfPaying here] end

		if (sameAsFormer(this.patientVisitPaymentSelfPaying, entity)) {
			return;
		}

		if (this.patientVisitPaymentSelfPaying != null) {
			this.patientVisitPaymentSelfPaying.unsetPatientVisit();
		}

		this.patientVisitPaymentSelfPaying = entity;

		if (reverseAdd) {
			this.patientVisitPaymentSelfPaying.setPatientVisit(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientVisitPaymentSelfPaying outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientVisitPaymentSelfPaying outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientVisitPaymentSelfPaying(boolean)} but default to true.
	 */
	public void unsetPatientVisitPaymentSelfPaying() {
		this.unsetPatientVisitPaymentSelfPaying(true);
	}

	/**
	 * Remove the PatientVisitPaymentSelfPayingEntity in Patient Visit Payment Self Paying from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientVisitPaymentSelfPaying(boolean reverse) {
		if (reverse && this.patientVisitPaymentSelfPaying != null) {
			this.patientVisitPaymentSelfPaying.unsetPatientVisit(false);
		}
		this.patientVisitPaymentSelfPaying = null;
	}

/**
	 * Similar to {@link this#addRegistrations(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 */
	public void addRegistrations(@NonNull RegistrationEntity entity) {
		addRegistrations(entity, true);
	}

	/**
	 * Add a new RegistrationEntity to registrations in this entity.
	 *
	 * @param entity the given RegistrationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRegistrations(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.registrations.contains(entity)) {
			registrations.add(entity);
			if (reverseAdd) {
				entity.setPatientVisit(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRegistrations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 */
	public void addRegistrations(@NonNull Collection<RegistrationEntity> entities) {
		addRegistrations(entities, true);
	}

	/**
	 * Add a new collection of RegistrationEntity to Registrations in this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRegistrations(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRegistrations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRegistrations(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void removeRegistrations(@NonNull RegistrationEntity entity) {
		this.removeRegistrations(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRegistrations(@NonNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientVisit(false);
		}
		this.registrations.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRegistrations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 */
	public void removeRegistrations(@NonNull Collection<RegistrationEntity> entities) {
		this.removeRegistrations(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity from  to this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRegistrations(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRegistrations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRegistrations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be set to this entity
	 */
	public void setRegistrations(@NonNull Collection<RegistrationEntity> entities) {
		setRegistrations(entities, true);
	}

	/**
	 * Replace the current entities in Registrations with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRegistrations(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

		this.unsetRegistrations();
		this.registrations = new HashSet<>(entities);
		if (reverseAdd) {
			this.registrations.forEach(registrationsEntity -> registrationsEntity.setPatientVisit(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRegistrations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRegistrations() {
		this.unsetRegistrations(true);
	}

	/**
	 * Remove all the entities in Registrations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRegistrations(boolean doReverse) {
		if (doReverse) {
			this.registrations.forEach(registrationsEntity -> registrationsEntity.unsetPatientVisit(false));
		}
		this.registrations.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setPatient(PatientGeneralInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatient(@NonNull PatientGeneralInfoEntity entity) {
		setPatient(entity, true);
	}

	/**
	 * Set or update the patient in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patient
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatient(@NonNull PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatient here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatient here] end

		if (sameAsFormer(this.patient, entity)) {
			return;
		}

		if (this.patient != null) {
			this.patient.removeVisits(this, false);
		}
		this.patient = entity;
		if (reverseAdd) {
			this.patient.addVisits(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatient incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatient incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatient(boolean)} but default to true.
	 */
	public void unsetPatient() {
		this.unsetPatient(true);
	}

	/**
	 * Remove Patient in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatient(boolean reverse) {
		if (reverse && this.patient != null) {
			this.patient.removeVisits(this, false);
		}
		this.patient = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
