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
import kmsweb.dtos.RoomTransferEntityDto;
import kmsweb.entities.listeners.RoomTransferEntityListener;
import kmsweb.serializers.RoomTransferSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.deserializers.DateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import java.time.*;
import java.time.temporal.ChronoUnit;
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
@EntityListeners({RoomTransferEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = RoomTransferSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class RoomTransferEntity extends AbstractEntity {

	/**
	 * Takes a RoomTransferEntityDto and converts it into a RoomTransferEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param roomTransferEntityDto
	 */
	public RoomTransferEntity(RoomTransferEntityDto roomTransferEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (roomTransferEntityDto.getId() != null) {
			this.setId(roomTransferEntityDto.getId());
		}

		if (roomTransferEntityDto.getStartDateTime() != null) {
			this.setStartDateTime(roomTransferEntityDto.getStartDateTime());
		}

		if (roomTransferEntityDto.getEndDateTime() != null) {
			this.setEndDateTime(roomTransferEntityDto.getEndDateTime());
		}

		if (roomTransferEntityDto.getTreatmentClass() != null) {
			this.setTreatmentClass(roomTransferEntityDto.getTreatmentClass());
		}

		if (roomTransferEntityDto.getTransferringStaffName() != null) {
			this.setTransferringStaffName(roomTransferEntityDto.getTransferringStaffName());
		}

		if (roomTransferEntityDto.getBedFacility() != null) {
			this.setBedFacility(roomTransferEntityDto.getBedFacility());
		}

		if (roomTransferEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(roomTransferEntityDto.getMedicalExaminationRecord());
		}

		if (roomTransferEntityDto.getTransferringStaff() != null) {
			this.setTransferringStaff(roomTransferEntityDto.getTransferringStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Start Date Time here] off begin
	@CsvCustomBindByName(column = "START_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "start_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Start Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Start Date Time here] end
	private OffsetDateTime startDateTime;

	// % protected region % [Modify attribute annotation for End Date Time here] off begin
	@CsvCustomBindByName(column = "END_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "end_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The End Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for End Date Time here] end
	private OffsetDateTime endDateTime;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@CsvBindByName(column = "TREATMENT_CLASS", required = false)
	@Nullable
	@Column(name = "treatment_class")
	@Schema(description = "The Treatment Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for Transferring Staff Name here] off begin
	@CsvBindByName(column = "TRANSFERRING_STAFF_NAME", required = false)
	@Nullable
	@Column(name = "transferring_staff_name")
	@Schema(description = "The Transferring Staff Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transferring Staff Name here] end
	private String transferringStaffName;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Bed Facility here] off begin
	@Schema(description = "The Bed Facility entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Bed Facility here] end
	private BedFacilityEntity bedFacility;

	// % protected region % [Update the annotation for bedFacilityId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BED_FACILITY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bedFacilityId here] end
	private UUID bedFacilityId;

	// % protected region % [Update the annotation for Medical Examination Record here] off begin
	@Schema(description = "The Medical Examination Record entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Examination Record here] end
	private MedicalExaminationRecordEntity medicalExaminationRecord;

	// % protected region % [Update the annotation for medicalExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalExaminationRecordId here] end
	private UUID medicalExaminationRecordId;

	// % protected region % [Update the annotation for Transferring Staff here] off begin
	@Schema(description = "The Transferring Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Transferring Staff here] end
	private StaffEntity transferringStaff;

	// % protected region % [Update the annotation for transferringStaffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "TRANSFERRING_STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for transferringStaffId here] end
	private UUID transferringStaffId;

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
	 * Similar to {@link this#setBedFacility(BedFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedFacilityEntity to be set to this entity
	 */
	public void setBedFacility(@NotNull BedFacilityEntity entity) {
		setBedFacility(entity, true);
	}

	/**
	 * Set or update the bedFacility in this entity with single BedFacilityEntity.
	 *
	 * @param entity the given BedFacilityEntity to be set or updated to bedFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBedFacility(@NotNull BedFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBedFacility here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBedFacility here] end

		if (sameAsFormer(this.bedFacility, entity)) {
			return;
		}

		if (this.bedFacility != null) {
			this.bedFacility.removeRoomTransfers(this, false);
		}
		this.bedFacility = entity;
		if (reverseAdd) {
			this.bedFacility.addRoomTransfers(this, false);
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
			this.bedFacility.removeRoomTransfers(this, false);
		}
		this.bedFacility = null;
	}
	/**
	 * Similar to {@link this#setMedicalExaminationRecord(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalExaminationRecord(@NotNull MedicalExaminationRecordEntity entity) {
		setMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the medicalExaminationRecord in this entity with single MedicalExaminationRecordEntity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set or updated to medicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecord(@NotNull MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] end

		if (sameAsFormer(this.medicalExaminationRecord, entity)) {
			return;
		}

		if (this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.removeRoomTransfers(this, false);
		}
		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.addRoomTransfers(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecord() {
		this.unsetMedicalExaminationRecord(true);
	}

	/**
	 * Remove Medical Examination Record in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.removeRoomTransfers(this, false);
		}
		this.medicalExaminationRecord = null;
	}
	/**
	 * Similar to {@link this#setTransferringStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setTransferringStaff(@NotNull StaffEntity entity) {
		setTransferringStaff(entity, true);
	}

	/**
	 * Set or update the transferringStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to transferringStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setTransferringStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setTransferringStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setTransferringStaff here] end

		if (sameAsFormer(this.transferringStaff, entity)) {
			return;
		}

		if (this.transferringStaff != null) {
			this.transferringStaff.removeRoomTransfers(this, false);
		}
		this.transferringStaff = entity;
		if (reverseAdd) {
			this.transferringStaff.addRoomTransfers(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setTransferringStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setTransferringStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetTransferringStaff(boolean)} but default to true.
	 */
	public void unsetTransferringStaff() {
		this.unsetTransferringStaff(true);
	}

	/**
	 * Remove Transferring Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetTransferringStaff(boolean reverse) {
		if (reverse && this.transferringStaff != null) {
			this.transferringStaff.removeRoomTransfers(this, false);
		}
		this.transferringStaff = null;
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
		return "START_DATE_TIME,END_DATE_TIME,TREATMENT_CLASS,TRANSFERRING_STAFF_NAME,BED_FACILITY_ID,MEDICAL_EXAMINATION_RECORD_ID,TRANSFERRING_STAFF_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<BedFacilityEntity> bedFacilityRelation = Optional.ofNullable(this.bedFacility);
		bedFacilityRelation.ifPresent(entity -> this.bedFacilityId = entity.getId());

		Optional<MedicalExaminationRecordEntity> medicalExaminationRecordRelation = Optional.ofNullable(this.medicalExaminationRecord);
		medicalExaminationRecordRelation.ifPresent(entity -> this.medicalExaminationRecordId = entity.getId());

		Optional<StaffEntity> transferringStaffRelation = Optional.ofNullable(this.transferringStaff);
		transferringStaffRelation.ifPresent(entity -> this.transferringStaffId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object roomTransfer) {
		if (this == roomTransfer) {
			return true;
		}
		if (roomTransfer == null || this.getClass() != roomTransfer.getClass()) {
			return false;
		}
		if (!super.equals(roomTransfer)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		RoomTransferEntity that = (RoomTransferEntity) roomTransfer;
		return
			Objects.equals(
			     this.startDateTime != null ? this.startDateTime.truncatedTo(ChronoUnit.DAYS) : null,
			     that.startDateTime != null ? that.startDateTime.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.endDateTime != null ? this.endDateTime.truncatedTo(ChronoUnit.DAYS) : null,
			     that.endDateTime != null ? that.endDateTime.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.treatmentClass, that.treatmentClass) &&
			Objects.equals(this.transferringStaffName, that.transferringStaffName) &&
			Objects.equals(this.bedFacilityId, that.bedFacilityId) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId) &&
			Objects.equals(this.transferringStaffId, that.transferringStaffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
