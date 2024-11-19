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
import kmsweb.dtos.BedFacilityEntityDto;
import kmsweb.entities.listeners.BedFacilityEntityListener;
import kmsweb.serializers.BedFacilitySerializer;
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
@EntityListeners({BedFacilityEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BedFacilitySerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"bed_number"}, name = "bed_number"),
	}
)
public class BedFacilityEntity extends AbstractEntity {

	/**
	 * Takes a BedFacilityEntityDto and converts it into a BedFacilityEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bedFacilityEntityDto
	 */
	public BedFacilityEntity(BedFacilityEntityDto bedFacilityEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bedFacilityEntityDto.getId() != null) {
			this.setId(bedFacilityEntityDto.getId());
		}

		if (bedFacilityEntityDto.getBedNumber() != null) {
			this.setBedNumber(bedFacilityEntityDto.getBedNumber());
		}

		if (bedFacilityEntityDto.getBedName() != null) {
			this.setBedName(bedFacilityEntityDto.getBedName());
		}

		if (bedFacilityEntityDto.getTreatmentClass() != null) {
			this.setTreatmentClass(bedFacilityEntityDto.getTreatmentClass());
		}

		if (bedFacilityEntityDto.getAvailability() != null) {
			this.setAvailability(bedFacilityEntityDto.getAvailability());
		}

		if (bedFacilityEntityDto.getNotes() != null) {
			this.setNotes(bedFacilityEntityDto.getNotes());
		}

		if (bedFacilityEntityDto.getCoaCOGS() != null) {
			this.setCoaCOGS(bedFacilityEntityDto.getCoaCOGS());
		}

		if (bedFacilityEntityDto.getCoaSell() != null) {
			this.setCoaSell(bedFacilityEntityDto.getCoaSell());
		}

		if (bedFacilityEntityDto.getCoaInventory() != null) {
			this.setCoaInventory(bedFacilityEntityDto.getCoaInventory());
		}

		if (bedFacilityEntityDto.getBedReserves() != null) {
			this.setBedReserves(bedFacilityEntityDto.getBedReserves());
		}

		if (bedFacilityEntityDto.getInpatientMedicalExaminationRecords() != null) {
			this.setInpatientMedicalExaminationRecords(bedFacilityEntityDto.getInpatientMedicalExaminationRecords());
		}

		if (bedFacilityEntityDto.getInvoices() != null) {
			this.setInvoices(bedFacilityEntityDto.getInvoices());
		}

		if (bedFacilityEntityDto.getRegistrations() != null) {
			this.setRegistrations(bedFacilityEntityDto.getRegistrations());
		}

		if (bedFacilityEntityDto.getRoomTransfers() != null) {
			this.setRoomTransfers(bedFacilityEntityDto.getRoomTransfers());
		}

		if (bedFacilityEntityDto.getIntraoperativeRecords() != null) {
			this.setIntraoperativeRecords(bedFacilityEntityDto.getIntraoperativeRecords());
		}

		if (bedFacilityEntityDto.getPostOperativeDetails() != null) {
			this.setPostOperativeDetails(bedFacilityEntityDto.getPostOperativeDetails());
		}

		if (bedFacilityEntityDto.getPreoperativeRecords() != null) {
			this.setPreoperativeRecords(bedFacilityEntityDto.getPreoperativeRecords());
		}

		if (bedFacilityEntityDto.getRoomFacility() != null) {
			this.setRoomFacility(bedFacilityEntityDto.getRoomFacility());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Bed Number here] off begin
	@CsvBindByName(column = "BED_NUMBER", required = true)
	@NotNull(message = "Bed Number must not be empty")
	@Column(name = "bed_number")
	@Schema(description = "The Bed Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Bed Number here] end
	private String bedNumber;

	// % protected region % [Modify attribute annotation for Bed Name here] off begin
	@CsvBindByName(column = "BED_NAME", required = true)
	@NotNull(message = "Bed Name must not be empty")
	@Column(name = "bed_name")
	@Schema(description = "The Bed Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Bed Name here] end
	private String bedName;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@CsvBindByName(column = "TREATMENT_CLASS", required = true)
	@NotNull(message = "Treatment Class must not be empty")
	@Column(name = "treatment_class")
	@Schema(description = "The Treatment Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for Availability here] off begin
	@CsvBindByName(column = "AVAILABILITY", required = true)
	@NotNull(message = "Availability must not be empty")
	@Column(name = "availability")
	@Schema(description = "The Availability of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Availability here] end
	private String availability;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for COA COGS here] off begin
	@CsvBindByName(column = "COA_COGS", required = false)
	@Nullable
	@Column(name = "coa_cogs")
	@Schema(description = "The COA COGS of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for COA COGS here] end
	private String coaCOGS;

	// % protected region % [Modify attribute annotation for COA Sell here] off begin
	@CsvBindByName(column = "COA_SELL", required = false)
	@Nullable
	@Column(name = "coa_sell")
	@Schema(description = "The COA Sell of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for COA Sell here] end
	private String coaSell;

	// % protected region % [Modify attribute annotation for COA Inventory here] off begin
	@CsvBindByName(column = "COA_INVENTORY", required = false)
	@Nullable
	@Column(name = "coa_inventory")
	@Schema(description = "The COA Inventory of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for COA Inventory here] end
	private String coaInventory;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Bed Reserves here] off begin
	@Schema(description = "The Bed Reserve entities that are related to this entity.")
	@OneToMany(mappedBy = "bedFacility", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Bed Reserves here] end
	private Set<BedReserveEntity> bedReserves = new HashSet<>();

	// % protected region % [Update the annotation for bedReservesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BED_RESERVES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bedReservesIds here] end
	private Set<UUID> bedReservesIds = new HashSet<>();

	// % protected region % [Update the annotation for Inpatient Medical Examination Records here] off begin
	@Schema(description = "The Inpatient Medical Examination Record entities that are related to this entity.")
	@OneToMany(mappedBy = "bedFacility", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Inpatient Medical Examination Records here] end
	private Set<InpatientMedicalExaminationRecordEntity> inpatientMedicalExaminationRecords = new HashSet<>();

	// % protected region % [Update the annotation for inpatientMedicalExaminationRecordsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INPATIENT_MEDICAL_EXAMINATION_RECORDS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for inpatientMedicalExaminationRecordsIds here] end
	private Set<UUID> inpatientMedicalExaminationRecordsIds = new HashSet<>();

	// % protected region % [Update the annotation for Invoices here] off begin
	@Schema(description = "The Invoice entities that are related to this entity.")
	@OneToMany(mappedBy = "bedFacility", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoices here] end
	private Set<InvoiceEntity> invoices = new HashSet<>();

	// % protected region % [Update the annotation for invoicesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for invoicesIds here] end
	private Set<UUID> invoicesIds = new HashSet<>();

	// % protected region % [Update the annotation for Registrations here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@OneToMany(mappedBy = "bedFacility", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Registrations here] end
	private Set<RegistrationEntity> registrations = new HashSet<>();

	// % protected region % [Update the annotation for registrationsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "REGISTRATIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for registrationsIds here] end
	private Set<UUID> registrationsIds = new HashSet<>();

	// % protected region % [Update the annotation for Room Transfers here] off begin
	@Schema(description = "The Room Transfer entities that are related to this entity.")
	@OneToMany(mappedBy = "bedFacility", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Room Transfers here] end
	private Set<RoomTransferEntity> roomTransfers = new HashSet<>();

	// % protected region % [Update the annotation for roomTransfersIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "ROOM_TRANSFERS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for roomTransfersIds here] end
	private Set<UUID> roomTransfersIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Intraoperative Records here] off begin
	@Schema(description = "The Intraoperative Records entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Intraoperative Records here] end
	private IntraoperativeRecordsEntity intraoperativeRecords;

	// % protected region % [Update the annotation for intraoperativeRecordsId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INTRAOPERATIVE_RECORDS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for intraoperativeRecordsId here] end
	private UUID intraoperativeRecordsId;

	// % protected region % [Update the annotation for Post Operative Details here] off begin
	@Schema(description = "The Post Operative Details entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Post Operative Details here] end
	private PostOperativeDetailsEntity postOperativeDetails;

	// % protected region % [Update the annotation for postOperativeDetailsId here] off begin
	@Transient
	@CsvCustomBindByName(column = "POST_OPERATIVE_DETAILS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for postOperativeDetailsId here] end
	private UUID postOperativeDetailsId;

	// % protected region % [Update the annotation for Preoperative Records here] off begin
	@Schema(description = "The Preoperative Records entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Preoperative Records here] end
	private PreoperativeRecordsEntity preoperativeRecords;

	// % protected region % [Update the annotation for preoperativeRecordsId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PREOPERATIVE_RECORDS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for preoperativeRecordsId here] end
	private UUID preoperativeRecordsId;

	// % protected region % [Update the annotation for Room Facility here] off begin
	@Schema(description = "The Room Facility entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Room Facility here] end
	private RoomFacilityEntity roomFacility;

	// % protected region % [Update the annotation for roomFacilityId here] off begin
	@Transient
	@CsvCustomBindByName(column = "ROOM_FACILITY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for roomFacilityId here] end
	private UUID roomFacilityId;

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
	public void addBedReserves(@NotNull BedReserveEntity entity) {
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
	public void addBedReserves(@NotNull Collection<BedReserveEntity> entities) {
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
	public void removeBedReserves(@NotNull BedReserveEntity entity) {
		this.removeBedReserves(entity, true);
	}

	/**
	 * Remove the given BedReserveEntity from this entity.
	 *
	 * @param entity the given BedReserveEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBedReserves(@NotNull BedReserveEntity entity, boolean reverse) {
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
	public void removeBedReserves(@NotNull Collection<BedReserveEntity> entities) {
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
	public void setBedReserves(@NotNull Collection<BedReserveEntity> entities) {
		setBedReserves(entities, true);
	}

	/**
	 * Replace the current entities in Bed Reserves with the given ones.
	 *
	 * @param entities the given collection of BedReserveEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBedReserves(@NotNull Collection<BedReserveEntity> entities, boolean reverseAdd) {

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
	public void addInpatientMedicalExaminationRecords(@NotNull InpatientMedicalExaminationRecordEntity entity) {
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
	public void addInpatientMedicalExaminationRecords(@NotNull Collection<InpatientMedicalExaminationRecordEntity> entities) {
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
	public void removeInpatientMedicalExaminationRecords(@NotNull InpatientMedicalExaminationRecordEntity entity) {
		this.removeInpatientMedicalExaminationRecords(entity, true);
	}

	/**
	 * Remove the given InpatientMedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given InpatientMedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInpatientMedicalExaminationRecords(@NotNull InpatientMedicalExaminationRecordEntity entity, boolean reverse) {
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
	public void removeInpatientMedicalExaminationRecords(@NotNull Collection<InpatientMedicalExaminationRecordEntity> entities) {
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
	public void setInpatientMedicalExaminationRecords(@NotNull Collection<InpatientMedicalExaminationRecordEntity> entities) {
		setInpatientMedicalExaminationRecords(entities, true);
	}

	/**
	 * Replace the current entities in Inpatient Medical Examination Records with the given ones.
	 *
	 * @param entities the given collection of InpatientMedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInpatientMedicalExaminationRecords(@NotNull Collection<InpatientMedicalExaminationRecordEntity> entities, boolean reverseAdd) {

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
	public void addInvoices(@NotNull InvoiceEntity entity) {
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
	public void addInvoices(@NotNull Collection<InvoiceEntity> entities) {
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
	public void removeInvoices(@NotNull InvoiceEntity entity) {
		this.removeInvoices(entity, true);
	}

	/**
	 * Remove the given InvoiceEntity from this entity.
	 *
	 * @param entity the given InvoiceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoices(@NotNull InvoiceEntity entity, boolean reverse) {
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
	public void removeInvoices(@NotNull Collection<InvoiceEntity> entities) {
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
	public void setInvoices(@NotNull Collection<InvoiceEntity> entities) {
		setInvoices(entities, true);
	}

	/**
	 * Replace the current entities in Invoices with the given ones.
	 *
	 * @param entities the given collection of InvoiceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoices(@NotNull Collection<InvoiceEntity> entities, boolean reverseAdd) {

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
	public void addRegistrations(@NotNull RegistrationEntity entity) {
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
	public void addRegistrations(@NotNull Collection<RegistrationEntity> entities) {
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
	public void removeRegistrations(@NotNull RegistrationEntity entity) {
		this.removeRegistrations(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRegistrations(@NotNull RegistrationEntity entity, boolean reverse) {
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
	public void removeRegistrations(@NotNull Collection<RegistrationEntity> entities) {
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
	public void setRegistrations(@NotNull Collection<RegistrationEntity> entities) {
		setRegistrations(entities, true);
	}

	/**
	 * Replace the current entities in Registrations with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRegistrations(@NotNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

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
	public void addRoomTransfers(@NotNull RoomTransferEntity entity) {
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
	public void addRoomTransfers(@NotNull Collection<RoomTransferEntity> entities) {
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
	public void removeRoomTransfers(@NotNull RoomTransferEntity entity) {
		this.removeRoomTransfers(entity, true);
	}

	/**
	 * Remove the given RoomTransferEntity from this entity.
	 *
	 * @param entity the given RoomTransferEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRoomTransfers(@NotNull RoomTransferEntity entity, boolean reverse) {
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
	public void removeRoomTransfers(@NotNull Collection<RoomTransferEntity> entities) {
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
	public void setRoomTransfers(@NotNull Collection<RoomTransferEntity> entities) {
		setRoomTransfers(entities, true);
	}

	/**
	 * Replace the current entities in Room Transfers with the given ones.
	 *
	 * @param entities the given collection of RoomTransferEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRoomTransfers(@NotNull Collection<RoomTransferEntity> entities, boolean reverseAdd) {

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
	public void setIntraoperativeRecords(@NotNull IntraoperativeRecordsEntity entity) {
		setIntraoperativeRecords(entity, true);
	}

	/**
	 * Set or update the intraoperativeRecords in this entity with single IntraoperativeRecordsEntity.
	 *
	 * @param entity the given IntraoperativeRecordsEntity to be set or updated to intraoperativeRecords
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setIntraoperativeRecords(@NotNull IntraoperativeRecordsEntity entity, boolean reverseAdd) {
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
	public void setPostOperativeDetails(@NotNull PostOperativeDetailsEntity entity) {
		setPostOperativeDetails(entity, true);
	}

	/**
	 * Set or update the postOperativeDetails in this entity with single PostOperativeDetailsEntity.
	 *
	 * @param entity the given PostOperativeDetailsEntity to be set or updated to postOperativeDetails
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPostOperativeDetails(@NotNull PostOperativeDetailsEntity entity, boolean reverseAdd) {
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
	public void setPreoperativeRecords(@NotNull PreoperativeRecordsEntity entity) {
		setPreoperativeRecords(entity, true);
	}

	/**
	 * Set or update the preoperativeRecords in this entity with single PreoperativeRecordsEntity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set or updated to preoperativeRecords
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPreoperativeRecords(@NotNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
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
	public void setRoomFacility(@NotNull RoomFacilityEntity entity) {
		setRoomFacility(entity, true);
	}

	/**
	 * Set or update the roomFacility in this entity with single RoomFacilityEntity.
	 *
	 * @param entity the given RoomFacilityEntity to be set or updated to roomFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRoomFacility(@NotNull RoomFacilityEntity entity, boolean reverseAdd) {
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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "BED_NUMBER,BED_NAME,TREATMENT_CLASS,AVAILABILITY,NOTES,COA_COGS,COA_SELL,COA_INVENTORY,INTRAOPERATIVE_RECORDS_ID,POST_OPERATIVE_DETAILS_ID,PREOPERATIVE_RECORDS_ID,ROOM_FACILITY_ID,BED_RESERVES_IDS,INPATIENT_MEDICAL_EXAMINATION_RECORDS_IDS,INVOICES_IDS,REGISTRATIONS_IDS,ROOM_TRANSFERS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<IntraoperativeRecordsEntity> intraoperativeRecordsRelation = Optional.ofNullable(this.intraoperativeRecords);
		intraoperativeRecordsRelation.ifPresent(entity -> this.intraoperativeRecordsId = entity.getId());

		Optional<PostOperativeDetailsEntity> postOperativeDetailsRelation = Optional.ofNullable(this.postOperativeDetails);
		postOperativeDetailsRelation.ifPresent(entity -> this.postOperativeDetailsId = entity.getId());

		Optional<PreoperativeRecordsEntity> preoperativeRecordsRelation = Optional.ofNullable(this.preoperativeRecords);
		preoperativeRecordsRelation.ifPresent(entity -> this.preoperativeRecordsId = entity.getId());

		Optional<RoomFacilityEntity> roomFacilityRelation = Optional.ofNullable(this.roomFacility);
		roomFacilityRelation.ifPresent(entity -> this.roomFacilityId = entity.getId());

		this.bedReservesIds = new HashSet<>();
		for (BedReserveEntity bedReserves: this.bedReserves) {
			this.bedReservesIds.add(bedReserves.getId());
		}

		this.inpatientMedicalExaminationRecordsIds = new HashSet<>();
		for (InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecords: this.inpatientMedicalExaminationRecords) {
			this.inpatientMedicalExaminationRecordsIds.add(inpatientMedicalExaminationRecords.getId());
		}

		this.invoicesIds = new HashSet<>();
		for (InvoiceEntity invoices: this.invoices) {
			this.invoicesIds.add(invoices.getId());
		}

		this.registrationsIds = new HashSet<>();
		for (RegistrationEntity registrations: this.registrations) {
			this.registrationsIds.add(registrations.getId());
		}

		this.roomTransfersIds = new HashSet<>();
		for (RoomTransferEntity roomTransfers: this.roomTransfers) {
			this.roomTransfersIds.add(roomTransfers.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bedFacility) {
		if (this == bedFacility) {
			return true;
		}
		if (bedFacility == null || this.getClass() != bedFacility.getClass()) {
			return false;
		}
		if (!super.equals(bedFacility)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BedFacilityEntity that = (BedFacilityEntity) bedFacility;
		return
			Objects.equals(this.bedNumber, that.bedNumber) &&
			Objects.equals(this.bedName, that.bedName) &&
			Objects.equals(this.treatmentClass, that.treatmentClass) &&
			Objects.equals(this.availability, that.availability) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.coaCOGS, that.coaCOGS) &&
			Objects.equals(this.coaSell, that.coaSell) &&
			Objects.equals(this.coaInventory, that.coaInventory) &&
			Objects.equals(this.bedReservesIds, that.bedReservesIds) &&
			Objects.equals(this.inpatientMedicalExaminationRecordsIds, that.inpatientMedicalExaminationRecordsIds) &&
			Objects.equals(this.invoicesIds, that.invoicesIds) &&
			Objects.equals(this.registrationsIds, that.registrationsIds) &&
			Objects.equals(this.roomTransfersIds, that.roomTransfersIds) &&
			Objects.equals(this.intraoperativeRecordsId, that.intraoperativeRecordsId) &&
			Objects.equals(this.postOperativeDetailsId, that.postOperativeDetailsId) &&
			Objects.equals(this.preoperativeRecordsId, that.preoperativeRecordsId) &&
			Objects.equals(this.roomFacilityId, that.roomFacilityId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
