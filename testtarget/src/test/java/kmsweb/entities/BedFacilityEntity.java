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
public class BedFacilityEntity extends AbstractEntity {

	public BedFacilityEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var IntraoperativeRecordsOneMany = new EntityReference();
			IntraoperativeRecordsOneMany.entityName = "IntraoperativeRecords";
			IntraoperativeRecordsOneMany.oppositeName = "IntraoperativeRecords";
			IntraoperativeRecordsOneMany.name = "BedFacilities";
			IntraoperativeRecordsOneMany.optional = true;
			IntraoperativeRecordsOneMany.type = "One";
			IntraoperativeRecordsOneMany.oppositeType = "Many";

		References.add(IntraoperativeRecordsOneMany);

		var PostOperativeDetailsOneMany = new EntityReference();
			PostOperativeDetailsOneMany.entityName = "PostOperativeDetails";
			PostOperativeDetailsOneMany.oppositeName = "PostOperativeDetails";
			PostOperativeDetailsOneMany.name = "BedFacilities";
			PostOperativeDetailsOneMany.optional = true;
			PostOperativeDetailsOneMany.type = "One";
			PostOperativeDetailsOneMany.oppositeType = "Many";

		References.add(PostOperativeDetailsOneMany);

		var PreoperativeRecordsOneMany = new EntityReference();
			PreoperativeRecordsOneMany.entityName = "PreoperativeRecords";
			PreoperativeRecordsOneMany.oppositeName = "PreoperativeRecords";
			PreoperativeRecordsOneMany.name = "BedFacilities";
			PreoperativeRecordsOneMany.optional = true;
			PreoperativeRecordsOneMany.type = "One";
			PreoperativeRecordsOneMany.oppositeType = "Many";

		References.add(PreoperativeRecordsOneMany);

		var RoomFacilityOneMany = new EntityReference();
			RoomFacilityOneMany.entityName = "RoomFacility";
			RoomFacilityOneMany.oppositeName = "RoomFacility";
			RoomFacilityOneMany.name = "BedFacilities";
			RoomFacilityOneMany.optional = true;
			RoomFacilityOneMany.type = "One";
			RoomFacilityOneMany.oppositeType = "Many";

		References.add(RoomFacilityOneMany);

		var BedReservesOneMany = new EntityReference();
			BedReservesOneMany.entityName = "BedReserve";
			BedReservesOneMany.oppositeName = "BedFacility";
			BedReservesOneMany.name = "BedReserves";
			BedReservesOneMany.optional = true;
			BedReservesOneMany.type = "One";
			BedReservesOneMany.oppositeType = "Many";

		References.add(BedReservesOneMany);

		var InpatientMedicalExaminationRecordsOneMany = new EntityReference();
			InpatientMedicalExaminationRecordsOneMany.entityName = "InpatientMedicalExaminationRecord";
			InpatientMedicalExaminationRecordsOneMany.oppositeName = "BedFacility";
			InpatientMedicalExaminationRecordsOneMany.name = "InpatientMedicalExaminationRecords";
			InpatientMedicalExaminationRecordsOneMany.optional = true;
			InpatientMedicalExaminationRecordsOneMany.type = "One";
			InpatientMedicalExaminationRecordsOneMany.oppositeType = "Many";

		References.add(InpatientMedicalExaminationRecordsOneMany);

		var InvoicesOneMany = new EntityReference();
			InvoicesOneMany.entityName = "Invoice";
			InvoicesOneMany.oppositeName = "BedFacility";
			InvoicesOneMany.name = "Invoices";
			InvoicesOneMany.optional = true;
			InvoicesOneMany.type = "One";
			InvoicesOneMany.oppositeType = "Many";

		References.add(InvoicesOneMany);

		var RegistrationsOneMany = new EntityReference();
			RegistrationsOneMany.entityName = "Registration";
			RegistrationsOneMany.oppositeName = "BedFacility";
			RegistrationsOneMany.name = "Registrations";
			RegistrationsOneMany.optional = true;
			RegistrationsOneMany.type = "One";
			RegistrationsOneMany.oppositeType = "Many";

		References.add(RegistrationsOneMany);

		var RoomTransfersOneMany = new EntityReference();
			RoomTransfersOneMany.entityName = "RoomTransfer";
			RoomTransfersOneMany.oppositeName = "BedFacility";
			RoomTransfersOneMany.name = "RoomTransfers";
			RoomTransfersOneMany.optional = true;
			RoomTransfersOneMany.type = "One";
			RoomTransfersOneMany.oppositeType = "Many";

		References.add(RoomTransfersOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Bed Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Bed Number here] end
	private String bedNumber;

	// % protected region % [Modify attribute annotation for Bed Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Bed Name here] end
	private String bedName;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for Availability here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Availability here] end
	private String availability;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for COA COGS here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for COA COGS here] end
	private String coaCOGS;

	// % protected region % [Modify attribute annotation for COA Sell here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for COA Sell here] end
	private String coaSell;

	// % protected region % [Modify attribute annotation for COA Inventory here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for COA Inventory here] end
	private String coaInventory;

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

	private Set<BedReserveEntity> bedReserves = new HashSet<>();

	private Set<InpatientMedicalExaminationRecordEntity> inpatientMedicalExaminationRecords = new HashSet<>();

	private Set<InvoiceEntity> invoices = new HashSet<>();

	private Set<RegistrationEntity> registrations = new HashSet<>();

	private Set<RoomTransferEntity> roomTransfers = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private IntraoperativeRecordsEntity intraoperativeRecords;

	private PostOperativeDetailsEntity postOperativeDetails;

	private PreoperativeRecordsEntity preoperativeRecords;

	private RoomFacilityEntity roomFacility;

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
	 * Similar to {@link this#addBedReserves(BedReserveEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedReserveEntity to be added to this entity
	 */
	public void addBedReserves(@NonNull BedReserveEntity entity) {
		addBedReserves(entity, true);
	}

	/**
	 * Add a new BedReserveEntity to bedReserves in this entity.
	 *
	 * @param entity the given BedReserveEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBedReserves(@NonNull BedReserveEntity entity, boolean reverseAdd) {
		if (!this.bedReserves.contains(entity)) {
			bedReserves.add(entity);
			if (reverseAdd) {
				entity.setBedFacility(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBedReserves(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BedReserveEntity to be added to this entity
	 */
	public void addBedReserves(@NonNull Collection<BedReserveEntity> entities) {
		addBedReserves(entities, true);
	}

	/**
	 * Add a new collection of BedReserveEntity to Bed Reserves in this entity.
	 *
	 * @param entities the given collection of BedReserveEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBedReserves(@NonNull Collection<BedReserveEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBedReserves(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBedReserves(BedReserveEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedReserveEntity to be set to this entity
	 */
	public void removeBedReserves(@NonNull BedReserveEntity entity) {
		this.removeBedReserves(entity, true);
	}

	/**
	 * Remove the given BedReserveEntity from this entity.
	 *
	 * @param entity the given BedReserveEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBedReserves(@NonNull BedReserveEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBedFacility(false);
		}
		this.bedReserves.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBedReserves(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BedReserveEntity to be removed to this entity
	 */
	public void removeBedReserves(@NonNull Collection<BedReserveEntity> entities) {
		this.removeBedReserves(entities, true);
	}

	/**
	 * Remove the given collection of BedReserveEntity from  to this entity.
	 *
	 * @param entities the given collection of BedReserveEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBedReserves(@NonNull Collection<BedReserveEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBedReserves(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBedReserves(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BedReserveEntity to be set to this entity
	 */
	public void setBedReserves(@NonNull Collection<BedReserveEntity> entities) {
		setBedReserves(entities, true);
	}

	/**
	 * Replace the current entities in Bed Reserves with the given ones.
	 *
	 * @param entities the given collection of BedReserveEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBedReserves(@NonNull Collection<BedReserveEntity> entities, boolean reverseAdd) {

		this.unsetBedReserves();
		this.bedReserves = new HashSet<>(entities);
		if (reverseAdd) {
			this.bedReserves.forEach(bedReservesEntity -> bedReservesEntity.setBedFacility(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBedReserves(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBedReserves() {
		this.unsetBedReserves(true);
	}

	/**
	 * Remove all the entities in Bed Reserves from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBedReserves(boolean doReverse) {
		if (doReverse) {
			this.bedReserves.forEach(bedReservesEntity -> bedReservesEntity.unsetBedFacility(false));
		}
		this.bedReserves.clear();
	}

/**
	 * Similar to {@link this#addInpatientMedicalExaminationRecords(InpatientMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InpatientMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addInpatientMedicalExaminationRecords(@NonNull InpatientMedicalExaminationRecordEntity entity) {
		addInpatientMedicalExaminationRecords(entity, true);
	}

	/**
	 * Add a new InpatientMedicalExaminationRecordEntity to inpatientMedicalExaminationRecords in this entity.
	 *
	 * @param entity the given InpatientMedicalExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInpatientMedicalExaminationRecords(@NonNull InpatientMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.inpatientMedicalExaminationRecords.contains(entity)) {
			inpatientMedicalExaminationRecords.add(entity);
			if (reverseAdd) {
				entity.setBedFacility(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInpatientMedicalExaminationRecords(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InpatientMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addInpatientMedicalExaminationRecords(@NonNull Collection<InpatientMedicalExaminationRecordEntity> entities) {
		addInpatientMedicalExaminationRecords(entities, true);
	}

	/**
	 * Add a new collection of InpatientMedicalExaminationRecordEntity to Inpatient Medical Examination Records in this entity.
	 *
	 * @param entities the given collection of InpatientMedicalExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInpatientMedicalExaminationRecords(@NonNull Collection<InpatientMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInpatientMedicalExaminationRecords(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInpatientMedicalExaminationRecords(InpatientMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InpatientMedicalExaminationRecordEntity to be set to this entity
	 */
	public void removeInpatientMedicalExaminationRecords(@NonNull InpatientMedicalExaminationRecordEntity entity) {
		this.removeInpatientMedicalExaminationRecords(entity, true);
	}

	/**
	 * Remove the given InpatientMedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given InpatientMedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInpatientMedicalExaminationRecords(@NonNull InpatientMedicalExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBedFacility(false);
		}
		this.inpatientMedicalExaminationRecords.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInpatientMedicalExaminationRecords(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InpatientMedicalExaminationRecordEntity to be removed to this entity
	 */
	public void removeInpatientMedicalExaminationRecords(@NonNull Collection<InpatientMedicalExaminationRecordEntity> entities) {
		this.removeInpatientMedicalExaminationRecords(entities, true);
	}

	/**
	 * Remove the given collection of InpatientMedicalExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of InpatientMedicalExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInpatientMedicalExaminationRecords(@NonNull Collection<InpatientMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInpatientMedicalExaminationRecords(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInpatientMedicalExaminationRecords(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InpatientMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setInpatientMedicalExaminationRecords(@NonNull Collection<InpatientMedicalExaminationRecordEntity> entities) {
		setInpatientMedicalExaminationRecords(entities, true);
	}

	/**
	 * Replace the current entities in Inpatient Medical Examination Records with the given ones.
	 *
	 * @param entities the given collection of InpatientMedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInpatientMedicalExaminationRecords(@NonNull Collection<InpatientMedicalExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetInpatientMedicalExaminationRecords();
		this.inpatientMedicalExaminationRecords = new HashSet<>(entities);
		if (reverseAdd) {
			this.inpatientMedicalExaminationRecords.forEach(inpatientMedicalExaminationRecordsEntity -> inpatientMedicalExaminationRecordsEntity.setBedFacility(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInpatientMedicalExaminationRecords(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInpatientMedicalExaminationRecords() {
		this.unsetInpatientMedicalExaminationRecords(true);
	}

	/**
	 * Remove all the entities in Inpatient Medical Examination Records from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInpatientMedicalExaminationRecords(boolean doReverse) {
		if (doReverse) {
			this.inpatientMedicalExaminationRecords.forEach(inpatientMedicalExaminationRecordsEntity -> inpatientMedicalExaminationRecordsEntity.unsetBedFacility(false));
		}
		this.inpatientMedicalExaminationRecords.clear();
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
				entity.setBedFacility(this, false);
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
			entity.unsetBedFacility(false);
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
			this.invoices.forEach(invoicesEntity -> invoicesEntity.setBedFacility(this, false));
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
			this.invoices.forEach(invoicesEntity -> invoicesEntity.unsetBedFacility(false));
		}
		this.invoices.clear();
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
				entity.setBedFacility(this, false);
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
			entity.unsetBedFacility(false);
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
			this.registrations.forEach(registrationsEntity -> registrationsEntity.setBedFacility(this, false));
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
			this.registrations.forEach(registrationsEntity -> registrationsEntity.unsetBedFacility(false));
		}
		this.registrations.clear();
	}

/**
	 * Similar to {@link this#addRoomTransfers(RoomTransferEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoomTransferEntity to be added to this entity
	 */
	public void addRoomTransfers(@NonNull RoomTransferEntity entity) {
		addRoomTransfers(entity, true);
	}

	/**
	 * Add a new RoomTransferEntity to roomTransfers in this entity.
	 *
	 * @param entity the given RoomTransferEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRoomTransfers(@NonNull RoomTransferEntity entity, boolean reverseAdd) {
		if (!this.roomTransfers.contains(entity)) {
			roomTransfers.add(entity);
			if (reverseAdd) {
				entity.setBedFacility(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRoomTransfers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RoomTransferEntity to be added to this entity
	 */
	public void addRoomTransfers(@NonNull Collection<RoomTransferEntity> entities) {
		addRoomTransfers(entities, true);
	}

	/**
	 * Add a new collection of RoomTransferEntity to Room Transfers in this entity.
	 *
	 * @param entities the given collection of RoomTransferEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRoomTransfers(@NonNull Collection<RoomTransferEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRoomTransfers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRoomTransfers(RoomTransferEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoomTransferEntity to be set to this entity
	 */
	public void removeRoomTransfers(@NonNull RoomTransferEntity entity) {
		this.removeRoomTransfers(entity, true);
	}

	/**
	 * Remove the given RoomTransferEntity from this entity.
	 *
	 * @param entity the given RoomTransferEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRoomTransfers(@NonNull RoomTransferEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBedFacility(false);
		}
		this.roomTransfers.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRoomTransfers(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RoomTransferEntity to be removed to this entity
	 */
	public void removeRoomTransfers(@NonNull Collection<RoomTransferEntity> entities) {
		this.removeRoomTransfers(entities, true);
	}

	/**
	 * Remove the given collection of RoomTransferEntity from  to this entity.
	 *
	 * @param entities the given collection of RoomTransferEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRoomTransfers(@NonNull Collection<RoomTransferEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRoomTransfers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRoomTransfers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RoomTransferEntity to be set to this entity
	 */
	public void setRoomTransfers(@NonNull Collection<RoomTransferEntity> entities) {
		setRoomTransfers(entities, true);
	}

	/**
	 * Replace the current entities in Room Transfers with the given ones.
	 *
	 * @param entities the given collection of RoomTransferEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRoomTransfers(@NonNull Collection<RoomTransferEntity> entities, boolean reverseAdd) {

		this.unsetRoomTransfers();
		this.roomTransfers = new HashSet<>(entities);
		if (reverseAdd) {
			this.roomTransfers.forEach(roomTransfersEntity -> roomTransfersEntity.setBedFacility(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRoomTransfers(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRoomTransfers() {
		this.unsetRoomTransfers(true);
	}

	/**
	 * Remove all the entities in Room Transfers from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRoomTransfers(boolean doReverse) {
		if (doReverse) {
			this.roomTransfers.forEach(roomTransfersEntity -> roomTransfersEntity.unsetBedFacility(false));
		}
		this.roomTransfers.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setIntraoperativeRecords(IntraoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given IntraoperativeRecordsEntity to be set to this entity
	 */
	public void setIntraoperativeRecords(@NonNull IntraoperativeRecordsEntity entity) {
		setIntraoperativeRecords(entity, true);
	}

	/**
	 * Set or update the intraoperativeRecords in this entity with single IntraoperativeRecordsEntity.
	 *
	 * @param entity the given IntraoperativeRecordsEntity to be set or updated to intraoperativeRecords
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setIntraoperativeRecords(@NonNull IntraoperativeRecordsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setIntraoperativeRecords here] off begin
		// % protected region % [Add any additional logic here before the main logic for setIntraoperativeRecords here] end

		if (sameAsFormer(this.intraoperativeRecords, entity)) {
			return;
		}

		if (this.intraoperativeRecords != null) {
			this.intraoperativeRecords.removeBedFacilities(this, false);
		}
		this.intraoperativeRecords = entity;
		if (reverseAdd) {
			this.intraoperativeRecords.addBedFacilities(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setIntraoperativeRecords incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setIntraoperativeRecords incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetIntraoperativeRecords(boolean)} but default to true.
	 */
	public void unsetIntraoperativeRecords() {
		this.unsetIntraoperativeRecords(true);
	}

	/**
	 * Remove Intraoperative Records in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetIntraoperativeRecords(boolean reverse) {
		if (reverse && this.intraoperativeRecords != null) {
			this.intraoperativeRecords.removeBedFacilities(this, false);
		}
		this.intraoperativeRecords = null;
	}
	/**
	 * Similar to {@link this#setPostOperativeDetails(PostOperativeDetailsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PostOperativeDetailsEntity to be set to this entity
	 */
	public void setPostOperativeDetails(@NonNull PostOperativeDetailsEntity entity) {
		setPostOperativeDetails(entity, true);
	}

	/**
	 * Set or update the postOperativeDetails in this entity with single PostOperativeDetailsEntity.
	 *
	 * @param entity the given PostOperativeDetailsEntity to be set or updated to postOperativeDetails
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPostOperativeDetails(@NonNull PostOperativeDetailsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPostOperativeDetails here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPostOperativeDetails here] end

		if (sameAsFormer(this.postOperativeDetails, entity)) {
			return;
		}

		if (this.postOperativeDetails != null) {
			this.postOperativeDetails.removeBedFacilities(this, false);
		}
		this.postOperativeDetails = entity;
		if (reverseAdd) {
			this.postOperativeDetails.addBedFacilities(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPostOperativeDetails incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPostOperativeDetails incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPostOperativeDetails(boolean)} but default to true.
	 */
	public void unsetPostOperativeDetails() {
		this.unsetPostOperativeDetails(true);
	}

	/**
	 * Remove Post Operative Details in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPostOperativeDetails(boolean reverse) {
		if (reverse && this.postOperativeDetails != null) {
			this.postOperativeDetails.removeBedFacilities(this, false);
		}
		this.postOperativeDetails = null;
	}
	/**
	 * Similar to {@link this#setPreoperativeRecords(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void setPreoperativeRecords(@NonNull PreoperativeRecordsEntity entity) {
		setPreoperativeRecords(entity, true);
	}

	/**
	 * Set or update the preoperativeRecords in this entity with single PreoperativeRecordsEntity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set or updated to preoperativeRecords
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPreoperativeRecords(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPreoperativeRecords here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPreoperativeRecords here] end

		if (sameAsFormer(this.preoperativeRecords, entity)) {
			return;
		}

		if (this.preoperativeRecords != null) {
			this.preoperativeRecords.removeBedFacilities(this, false);
		}
		this.preoperativeRecords = entity;
		if (reverseAdd) {
			this.preoperativeRecords.addBedFacilities(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPreoperativeRecords incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPreoperativeRecords incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPreoperativeRecords(boolean)} but default to true.
	 */
	public void unsetPreoperativeRecords() {
		this.unsetPreoperativeRecords(true);
	}

	/**
	 * Remove Preoperative Records in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPreoperativeRecords(boolean reverse) {
		if (reverse && this.preoperativeRecords != null) {
			this.preoperativeRecords.removeBedFacilities(this, false);
		}
		this.preoperativeRecords = null;
	}
	/**
	 * Similar to {@link this#setRoomFacility(RoomFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoomFacilityEntity to be set to this entity
	 */
	public void setRoomFacility(@NonNull RoomFacilityEntity entity) {
		setRoomFacility(entity, true);
	}

	/**
	 * Set or update the roomFacility in this entity with single RoomFacilityEntity.
	 *
	 * @param entity the given RoomFacilityEntity to be set or updated to roomFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRoomFacility(@NonNull RoomFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRoomFacility here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRoomFacility here] end

		if (sameAsFormer(this.roomFacility, entity)) {
			return;
		}

		if (this.roomFacility != null) {
			this.roomFacility.removeBedFacilities(this, false);
		}
		this.roomFacility = entity;
		if (reverseAdd) {
			this.roomFacility.addBedFacilities(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRoomFacility incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRoomFacility incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRoomFacility(boolean)} but default to true.
	 */
	public void unsetRoomFacility() {
		this.unsetRoomFacility(true);
	}

	/**
	 * Remove Room Facility in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRoomFacility(boolean reverse) {
		if (reverse && this.roomFacility != null) {
			this.roomFacility.removeBedFacilities(this, false);
		}
		this.roomFacility = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
