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
import kmsweb.dtos.IntraoperativeRecordsEntityDto;
import kmsweb.entities.listeners.IntraoperativeRecordsEntityListener;
import kmsweb.serializers.IntraoperativeRecordsSerializer;
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

import java.util.*;
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
@EntityListeners({IntraoperativeRecordsEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = IntraoperativeRecordsSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class IntraoperativeRecordsEntity extends AbstractEntity {

	/**
	 * Takes a IntraoperativeRecordsEntityDto and converts it into a IntraoperativeRecordsEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param intraoperativeRecordsEntityDto
	 */
	public IntraoperativeRecordsEntity(IntraoperativeRecordsEntityDto intraoperativeRecordsEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (intraoperativeRecordsEntityDto.getId() != null) {
			this.setId(intraoperativeRecordsEntityDto.getId());
		}

		if (intraoperativeRecordsEntityDto.getStartDateTime() != null) {
			this.setStartDateTime(intraoperativeRecordsEntityDto.getStartDateTime());
		}

		if (intraoperativeRecordsEntityDto.getEndDateTime() != null) {
			this.setEndDateTime(intraoperativeRecordsEntityDto.getEndDateTime());
		}

		if (intraoperativeRecordsEntityDto.getSurgeryStartDateTime() != null) {
			this.setSurgeryStartDateTime(intraoperativeRecordsEntityDto.getSurgeryStartDateTime());
		}

		if (intraoperativeRecordsEntityDto.getSurgeryEndDateTime() != null) {
			this.setSurgeryEndDateTime(intraoperativeRecordsEntityDto.getSurgeryEndDateTime());
		}

		if (intraoperativeRecordsEntityDto.getSurgeryDetails() != null) {
			this.setSurgeryDetails(intraoperativeRecordsEntityDto.getSurgeryDetails());
		}

		if (intraoperativeRecordsEntityDto.getBloodTransfusion() != null) {
			this.setBloodTransfusion(intraoperativeRecordsEntityDto.getBloodTransfusion());
		}

		if (intraoperativeRecordsEntityDto.getInstrumentsUsed() != null) {
			this.setInstrumentsUsed(intraoperativeRecordsEntityDto.getInstrumentsUsed());
		}

		if (intraoperativeRecordsEntityDto.getAnesthesiaStartDateTime() != null) {
			this.setAnesthesiaStartDateTime(intraoperativeRecordsEntityDto.getAnesthesiaStartDateTime());
		}

		if (intraoperativeRecordsEntityDto.getAnesthesiaType() != null) {
			this.setAnesthesiaType(intraoperativeRecordsEntityDto.getAnesthesiaType());
		}

		if (intraoperativeRecordsEntityDto.getAnesthesiaMethod() != null) {
			this.setAnesthesiaMethod(intraoperativeRecordsEntityDto.getAnesthesiaMethod());
		}

		if (intraoperativeRecordsEntityDto.getAnesthesiaAgents() != null) {
			this.setAnesthesiaAgents(intraoperativeRecordsEntityDto.getAnesthesiaAgents());
		}

		if (intraoperativeRecordsEntityDto.getAnesthesiaObservations() != null) {
			this.setAnesthesiaObservations(intraoperativeRecordsEntityDto.getAnesthesiaObservations());
		}

		if (intraoperativeRecordsEntityDto.getAnesthesiaNotes() != null) {
			this.setAnesthesiaNotes(intraoperativeRecordsEntityDto.getAnesthesiaNotes());
		}

		if (intraoperativeRecordsEntityDto.getAnesthesiaEndDateTime() != null) {
			this.setAnesthesiaEndDateTime(intraoperativeRecordsEntityDto.getAnesthesiaEndDateTime());
		}

		if (intraoperativeRecordsEntityDto.getBedFacilities() != null) {
			this.setBedFacilities(intraoperativeRecordsEntityDto.getBedFacilities());
		}

		if (intraoperativeRecordsEntityDto.getOperatingTheaterMedicalExaminationRecord() != null) {
			this.setOperatingTheaterMedicalExaminationRecord(intraoperativeRecordsEntityDto.getOperatingTheaterMedicalExaminationRecord());
		}

		if (intraoperativeRecordsEntityDto.getOperatingRoom() != null) {
			this.setOperatingRoom(intraoperativeRecordsEntityDto.getOperatingRoom());
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

	// % protected region % [Modify attribute annotation for Surgery Start Date Time here] off begin
	@CsvCustomBindByName(column = "SURGERY_START_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "surgery_start_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Surgery Start Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Surgery Start Date Time here] end
	private OffsetDateTime surgeryStartDateTime;

	// % protected region % [Modify attribute annotation for Surgery End Date Time here] off begin
	@CsvCustomBindByName(column = "SURGERY_END_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "surgery_end_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Surgery End Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Surgery End Date Time here] end
	private OffsetDateTime surgeryEndDateTime;

	// % protected region % [Modify attribute annotation for Surgery Details here] off begin
	@CsvBindByName(column = "SURGERY_DETAILS", required = false)
	@Nullable
	@Column(name = "surgery_details")
	@Schema(description = "The Surgery Details of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Surgery Details here] end
	private String surgeryDetails;

	// % protected region % [Modify attribute annotation for Blood Transfusion here] off begin
	@CsvBindByName(column = "BLOOD_TRANSFUSION", required = false)
	@Nullable
	@Column(name = "blood_transfusion")
	@Schema(description = "The Blood Transfusion of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Blood Transfusion here] end
	private String bloodTransfusion;

	// % protected region % [Modify attribute annotation for Instruments Used here] off begin
	@CsvBindByName(column = "INSTRUMENTS_USED", required = false)
	@Nullable
	@Column(name = "instruments_used")
	@Schema(description = "The Instruments Used of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Instruments Used here] end
	private String instrumentsUsed;

	// % protected region % [Modify attribute annotation for Anesthesia Start Date Time here] off begin
	@CsvCustomBindByName(column = "ANESTHESIA_START_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "anesthesia_start_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Anesthesia Start Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Anesthesia Start Date Time here] end
	private OffsetDateTime anesthesiaStartDateTime;

	// % protected region % [Modify attribute annotation for Anesthesia Type here] off begin
	@CsvBindByName(column = "ANESTHESIA_TYPE", required = false)
	@Nullable
	@Column(name = "anesthesia_type")
	@Schema(description = "The Anesthesia Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Anesthesia Type here] end
	private String anesthesiaType;

	// % protected region % [Modify attribute annotation for Anesthesia Method here] off begin
	@CsvBindByName(column = "ANESTHESIA_METHOD", required = false)
	@Nullable
	@Column(name = "anesthesia_method")
	@Schema(description = "The Anesthesia Method of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Anesthesia Method here] end
	private String anesthesiaMethod;

	// % protected region % [Modify attribute annotation for Anesthesia Agents here] off begin
	@CsvBindByName(column = "ANESTHESIA_AGENTS", required = false)
	@Nullable
	@Column(name = "anesthesia_agents")
	@Schema(description = "The Anesthesia Agents of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Anesthesia Agents here] end
	private String anesthesiaAgents;

	// % protected region % [Modify attribute annotation for Anesthesia Observations here] off begin
	@CsvBindByName(column = "ANESTHESIA_OBSERVATIONS", required = false)
	@Nullable
	@Column(name = "anesthesia_observations")
	@Schema(description = "The Anesthesia Observations of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Anesthesia Observations here] end
	private String anesthesiaObservations;

	// % protected region % [Modify attribute annotation for Anesthesia Notes here] off begin
	@CsvBindByName(column = "ANESTHESIA_NOTES", required = false)
	@Nullable
	@Column(name = "anesthesia_notes")
	@Schema(description = "The Anesthesia Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Anesthesia Notes here] end
	private String anesthesiaNotes;

	// % protected region % [Modify attribute annotation for Anesthesia End Date Time here] off begin
	@CsvCustomBindByName(column = "ANESTHESIA_END_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "anesthesia_end_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Anesthesia End Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Anesthesia End Date Time here] end
	private OffsetDateTime anesthesiaEndDateTime;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Bed Facilities here] off begin
	@Schema(description = "The Bed Facility entities that are related to this entity.")
	@OneToMany(mappedBy = "intraoperativeRecords", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Bed Facilities here] end
	private Set<BedFacilityEntity> bedFacilities = new HashSet<>();

	// % protected region % [Update the annotation for bedFacilitiesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BED_FACILITIES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bedFacilitiesIds here] end
	private Set<UUID> bedFacilitiesIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Operating Theater Medical Examination Record here] off begin
	@Schema(description = "The Operating Theater Medical Examination Record entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Operating Theater Medical Examination Record here] end
	private OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecord;

	// % protected region % [Update the annotation for operatingTheaterMedicalExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for operatingTheaterMedicalExaminationRecordId here] end
	private UUID operatingTheaterMedicalExaminationRecordId;

	// % protected region % [Update the annotation for Operating Room here] off begin
	@Schema(description = "The Operating Room entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Operating Room here] end
	private RoomFacilityEntity operatingRoom;

	// % protected region % [Update the annotation for operatingRoomId here] off begin
	@Transient
	@CsvCustomBindByName(column = "OPERATING_ROOM_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for operatingRoomId here] end
	private UUID operatingRoomId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addBedFacilities(BedFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedFacilityEntity to be added to this entity
	 */
	public void addBedFacilities(@NotNull BedFacilityEntity entity) {
		addBedFacilities(entity, true);
	}

	/**
	 * Add a new BedFacilityEntity to bedFacilities in this entity.
	 *
	 * @param entity the given BedFacilityEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBedFacilities(@NonNull BedFacilityEntity entity, boolean reverseAdd) {
		if (!this.bedFacilities.contains(entity)) {
			bedFacilities.add(entity);
			if (reverseAdd) {
				entity.setIntraoperativeRecords(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBedFacilities(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BedFacilityEntity to be added to this entity
	 */
	public void addBedFacilities(@NotNull Collection<BedFacilityEntity> entities) {
		addBedFacilities(entities, true);
	}

	/**
	 * Add a new collection of BedFacilityEntity to Bed Facilities in this entity.
	 *
	 * @param entities the given collection of BedFacilityEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBedFacilities(@NonNull Collection<BedFacilityEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBedFacilities(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBedFacilities(BedFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedFacilityEntity to be set to this entity
	 */
	public void removeBedFacilities(@NotNull BedFacilityEntity entity) {
		this.removeBedFacilities(entity, true);
	}

	/**
	 * Remove the given BedFacilityEntity from this entity.
	 *
	 * @param entity the given BedFacilityEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBedFacilities(@NotNull BedFacilityEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetIntraoperativeRecords(false);
		}
		this.bedFacilities.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBedFacilities(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BedFacilityEntity to be removed to this entity
	 */
	public void removeBedFacilities(@NotNull Collection<BedFacilityEntity> entities) {
		this.removeBedFacilities(entities, true);
	}

	/**
	 * Remove the given collection of BedFacilityEntity from  to this entity.
	 *
	 * @param entities the given collection of BedFacilityEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBedFacilities(@NonNull Collection<BedFacilityEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBedFacilities(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBedFacilities(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BedFacilityEntity to be set to this entity
	 */
	public void setBedFacilities(@NotNull Collection<BedFacilityEntity> entities) {
		setBedFacilities(entities, true);
	}

	/**
	 * Replace the current entities in Bed Facilities with the given ones.
	 *
	 * @param entities the given collection of BedFacilityEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBedFacilities(@NotNull Collection<BedFacilityEntity> entities, boolean reverseAdd) {

		this.unsetBedFacilities();
		this.bedFacilities = new HashSet<>(entities);
		if (reverseAdd) {
			this.bedFacilities.forEach(bedFacilitiesEntity -> bedFacilitiesEntity.setIntraoperativeRecords(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBedFacilities(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBedFacilities() {
		this.unsetBedFacilities(true);
	}

	/**
	 * Remove all the entities in Bed Facilities from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBedFacilities(boolean doReverse) {
		if (doReverse) {
			this.bedFacilities.forEach(bedFacilitiesEntity -> bedFacilitiesEntity.unsetIntraoperativeRecords(false));
		}
		this.bedFacilities.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setOperatingTheaterMedicalExaminationRecord(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setOperatingTheaterMedicalExaminationRecord(OperatingTheaterMedicalExaminationRecordEntity entity) {
		setOperatingTheaterMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the operatingTheaterMedicalExaminationRecord in this entity with single OperatingTheaterMedicalExaminationRecordEntity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set or updated to operatingTheaterMedicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setOperatingTheaterMedicalExaminationRecord(OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setOperatingTheaterMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setOperatingTheaterMedicalExaminationRecord here] end

		if (sameAsFormer(this.operatingTheaterMedicalExaminationRecord, entity)) {
			return;
		}

		if (this.operatingTheaterMedicalExaminationRecord != null) {
			this.operatingTheaterMedicalExaminationRecord.unsetIntraoperativeRecords(false);
		}

		this.operatingTheaterMedicalExaminationRecord = entity;
		if (reverseAdd) {
			this.operatingTheaterMedicalExaminationRecord.setIntraoperativeRecords(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setOperatingTheaterMedicalExaminationRecord incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setOperatingTheaterMedicalExaminationRecord incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetOperatingTheaterMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetOperatingTheaterMedicalExaminationRecord() {
		this.unsetOperatingTheaterMedicalExaminationRecord(true);
	}

	/**
	 * Remove the OperatingTheaterMedicalExaminationRecordEntity of operatingTheaterMedicalExaminationRecord from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetOperatingTheaterMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.operatingTheaterMedicalExaminationRecord != null) {
			this.operatingTheaterMedicalExaminationRecord.unsetIntraoperativeRecords();
		}
		this.operatingTheaterMedicalExaminationRecord = null;
	}
	/**
	 * Similar to {@link this#setOperatingRoom(RoomFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoomFacilityEntity to be set to this entity
	 */
	public void setOperatingRoom(@NotNull RoomFacilityEntity entity) {
		setOperatingRoom(entity, true);
	}

	/**
	 * Set or update the operatingRoom in this entity with single RoomFacilityEntity.
	 *
	 * @param entity the given RoomFacilityEntity to be set or updated to operatingRoom
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setOperatingRoom(@NotNull RoomFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setOperatingRoom here] off begin
		// % protected region % [Add any additional logic here before the main logic for setOperatingRoom here] end

		if (sameAsFormer(this.operatingRoom, entity)) {
			return;
		}

		if (this.operatingRoom != null) {
			this.operatingRoom.removeOperatingRoom(this, false);
		}
		this.operatingRoom = entity;
		if (reverseAdd) {
			this.operatingRoom.addOperatingRoom(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setOperatingRoom incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setOperatingRoom incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetOperatingRoom(boolean)} but default to true.
	 */
	public void unsetOperatingRoom() {
		this.unsetOperatingRoom(true);
	}

	/**
	 * Remove Operating Room in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetOperatingRoom(boolean reverse) {
		if (reverse && this.operatingRoom != null) {
			this.operatingRoom.removeOperatingRoom(this, false);
		}
		this.operatingRoom = null;
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
		return "START_DATE_TIME,END_DATE_TIME,SURGERY_START_DATE_TIME,SURGERY_END_DATE_TIME,SURGERY_DETAILS,BLOOD_TRANSFUSION,INSTRUMENTS_USED,ANESTHESIA_START_DATE_TIME,ANESTHESIA_TYPE,ANESTHESIA_METHOD,ANESTHESIA_AGENTS,ANESTHESIA_OBSERVATIONS,ANESTHESIA_NOTES,ANESTHESIA_END_DATE_TIME,OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ID,OPERATING_ROOM_ID,BED_FACILITIES_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<OperatingTheaterMedicalExaminationRecordEntity> operatingTheaterMedicalExaminationRecordRelation = Optional.ofNullable(this.operatingTheaterMedicalExaminationRecord);
		operatingTheaterMedicalExaminationRecordRelation.ifPresent(entity -> this.operatingTheaterMedicalExaminationRecordId = entity.getId());

		Optional<RoomFacilityEntity> operatingRoomRelation = Optional.ofNullable(this.operatingRoom);
		operatingRoomRelation.ifPresent(entity -> this.operatingRoomId = entity.getId());

		this.bedFacilitiesIds = new HashSet<>();
		for (BedFacilityEntity bedFacilities: this.bedFacilities) {
			this.bedFacilitiesIds.add(bedFacilities.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object intraoperativeRecords) {
		if (this == intraoperativeRecords) {
			return true;
		}
		if (intraoperativeRecords == null || this.getClass() != intraoperativeRecords.getClass()) {
			return false;
		}
		if (!super.equals(intraoperativeRecords)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		IntraoperativeRecordsEntity that = (IntraoperativeRecordsEntity) intraoperativeRecords;
		return
			Objects.equals(
			     this.startDateTime != null ? this.startDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.startDateTime != null ? that.startDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.endDateTime != null ? this.endDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.endDateTime != null ? that.endDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.surgeryStartDateTime != null ? this.surgeryStartDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.surgeryStartDateTime != null ? that.surgeryStartDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.surgeryEndDateTime != null ? this.surgeryEndDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.surgeryEndDateTime != null ? that.surgeryEndDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.surgeryDetails, that.surgeryDetails) &&
			Objects.equals(this.bloodTransfusion, that.bloodTransfusion) &&
			Objects.equals(this.instrumentsUsed, that.instrumentsUsed) &&
			Objects.equals(
			     this.anesthesiaStartDateTime != null ? this.anesthesiaStartDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.anesthesiaStartDateTime != null ? that.anesthesiaStartDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.anesthesiaType, that.anesthesiaType) &&
			Objects.equals(this.anesthesiaMethod, that.anesthesiaMethod) &&
			Objects.equals(this.anesthesiaAgents, that.anesthesiaAgents) &&
			Objects.equals(this.anesthesiaObservations, that.anesthesiaObservations) &&
			Objects.equals(this.anesthesiaNotes, that.anesthesiaNotes) &&
			Objects.equals(
			     this.anesthesiaEndDateTime != null ? this.anesthesiaEndDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.anesthesiaEndDateTime != null ? that.anesthesiaEndDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.bedFacilitiesIds, that.bedFacilitiesIds) &&
			Objects.equals(this.operatingTheaterMedicalExaminationRecordId, that.operatingTheaterMedicalExaminationRecordId) &&
			Objects.equals(this.operatingRoomId, that.operatingRoomId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
