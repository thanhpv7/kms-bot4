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
import kmsweb.dtos.PostOperativeDetailsEntityDto;
import kmsweb.entities.listeners.PostOperativeDetailsEntityListener;
import kmsweb.serializers.PostOperativeDetailsSerializer;
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
@EntityListeners({PostOperativeDetailsEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PostOperativeDetailsSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PostOperativeDetailsEntity extends AbstractEntity {

	/**
	 * Takes a PostOperativeDetailsEntityDto and converts it into a PostOperativeDetailsEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param postOperativeDetailsEntityDto
	 */
	public PostOperativeDetailsEntity(PostOperativeDetailsEntityDto postOperativeDetailsEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (postOperativeDetailsEntityDto.getId() != null) {
			this.setId(postOperativeDetailsEntityDto.getId());
		}

		if (postOperativeDetailsEntityDto.getRecoveryStartDateTime() != null) {
			this.setRecoveryStartDateTime(postOperativeDetailsEntityDto.getRecoveryStartDateTime());
		}

		if (postOperativeDetailsEntityDto.getRecoveryEndDateTime() != null) {
			this.setRecoveryEndDateTime(postOperativeDetailsEntityDto.getRecoveryEndDateTime());
		}

		if (postOperativeDetailsEntityDto.getPostoperativeMainDiagnosis() != null) {
			this.setPostoperativeMainDiagnosis(postOperativeDetailsEntityDto.getPostoperativeMainDiagnosis());
		}

		if (postOperativeDetailsEntityDto.getPostoperativeAction() != null) {
			this.setPostoperativeAction(postOperativeDetailsEntityDto.getPostoperativeAction());
		}

		if (postOperativeDetailsEntityDto.getNewCase() != null) {
			this.setNewCase(postOperativeDetailsEntityDto.getNewCase());
		}

		if (postOperativeDetailsEntityDto.getPostoperativeDiagnosisSupportOrder() != null) {
			this.setPostoperativeDiagnosisSupportOrder(postOperativeDetailsEntityDto.getPostoperativeDiagnosisSupportOrder());
		}

		if (postOperativeDetailsEntityDto.getAnesthesiaPostoperativeMonitoring() != null) {
			this.setAnesthesiaPostoperativeMonitoring(postOperativeDetailsEntityDto.getAnesthesiaPostoperativeMonitoring());
		}

		if (postOperativeDetailsEntityDto.getAnesthesiaPostoperativeAction() != null) {
			this.setAnesthesiaPostoperativeAction(postOperativeDetailsEntityDto.getAnesthesiaPostoperativeAction());
		}

		if (postOperativeDetailsEntityDto.getBedFacilities() != null) {
			this.setBedFacilities(postOperativeDetailsEntityDto.getBedFacilities());
		}

		if (postOperativeDetailsEntityDto.getOperatingTheaterMedicalExaminationRecord() != null) {
			this.setOperatingTheaterMedicalExaminationRecord(postOperativeDetailsEntityDto.getOperatingTheaterMedicalExaminationRecord());
		}

		if (postOperativeDetailsEntityDto.getPostOperativeICD10() != null) {
			this.setPostOperativeICD10(postOperativeDetailsEntityDto.getPostOperativeICD10());
		}

		if (postOperativeDetailsEntityDto.getPostOperativeICD9CM() != null) {
			this.setPostOperativeICD9CM(postOperativeDetailsEntityDto.getPostOperativeICD9CM());
		}

		if (postOperativeDetailsEntityDto.getRecoveryRooms() != null) {
			this.setRecoveryRooms(postOperativeDetailsEntityDto.getRecoveryRooms());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Recovery Start Date Time here] off begin
	@CsvCustomBindByName(column = "RECOVERY_START_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "recovery_start_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Recovery Start Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Recovery Start Date Time here] end
	private OffsetDateTime recoveryStartDateTime;

	// % protected region % [Modify attribute annotation for Recovery End Date Time here] off begin
	@CsvCustomBindByName(column = "RECOVERY_END_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "recovery_end_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Recovery End Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Recovery End Date Time here] end
	private OffsetDateTime recoveryEndDateTime;

	// % protected region % [Modify attribute annotation for Postoperative Main Diagnosis here] off begin
	@CsvBindByName(column = "POSTOPERATIVE_MAIN_DIAGNOSIS", required = false)
	@Nullable
	@Column(name = "postoperative_main_diagnosis")
	@Schema(description = "The Postoperative Main Diagnosis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Postoperative Main Diagnosis here] end
	private String postoperativeMainDiagnosis;

	// % protected region % [Modify attribute annotation for Postoperative Action here] off begin
	@CsvBindByName(column = "POSTOPERATIVE_ACTION", required = false)
	@Nullable
	@Column(name = "postoperative_action")
	@Schema(description = "The Postoperative Action of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Postoperative Action here] end
	private String postoperativeAction;

	// % protected region % [Modify attribute annotation for New Case here] off begin
	@CsvBindByName(column = "NEW_CASE", required = false)
	@Nullable
	@Column(name = "new_case")
	@Schema(description = "The New Case of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for New Case here] end
	private Boolean newCase = false ;

	// % protected region % [Modify attribute annotation for Postoperative Diagnosis Support Order here] off begin
	@CsvBindByName(column = "POSTOPERATIVE_DIAGNOSIS_SUPPORT_ORDER", required = false)
	@Nullable
	@Column(name = "postoperative_diagnosis_support_order")
	@Schema(description = "The Postoperative Diagnosis Support Order of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Postoperative Diagnosis Support Order here] end
	private String postoperativeDiagnosisSupportOrder;

	// % protected region % [Modify attribute annotation for Anesthesia Postoperative Monitoring here] off begin
	@CsvBindByName(column = "ANESTHESIA_POSTOPERATIVE_MONITORING", required = false)
	@Nullable
	@Column(name = "anesthesia_postoperative_monitoring")
	@Schema(description = "The Anesthesia Postoperative Monitoring of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Anesthesia Postoperative Monitoring here] end
	private String anesthesiaPostoperativeMonitoring;

	// % protected region % [Modify attribute annotation for Anesthesia Postoperative Action here] off begin
	@CsvBindByName(column = "ANESTHESIA_POSTOPERATIVE_ACTION", required = false)
	@Nullable
	@Column(name = "anesthesia_postoperative_action")
	@Schema(description = "The Anesthesia Postoperative Action of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Anesthesia Postoperative Action here] end
	private String anesthesiaPostoperativeAction;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Bed Facilities here] off begin
	@Schema(description = "The Bed Facility entities that are related to this entity.")
	@OneToMany(mappedBy = "postOperativeDetails", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
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

	// % protected region % [Update the annotation for Post Operative ICD 10 here] off begin
	@Schema(description = "The Post Operative ICD 10 entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Post Operative ICD 10 here] end
	private DiagnosesAndProceduresEntity postOperativeICD10;

	// % protected region % [Update the annotation for postOperativeICD10Id here] off begin
	@Transient
	@CsvCustomBindByName(column = "POST_OPERATIVE_ICD_10_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for postOperativeICD10Id here] end
	private UUID postOperativeICD10Id;

	// % protected region % [Update the annotation for Post Operative ICD 9 CM here] off begin
	@Schema(description = "The Post Operative ICD 9 CM entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Post Operative ICD 9 CM here] end
	private DiagnosesAndProceduresEntity postOperativeICD9CM;

	// % protected region % [Update the annotation for postOperativeICD9CMId here] off begin
	@Transient
	@CsvCustomBindByName(column = "POST_OPERATIVE_ICD_9_CM_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for postOperativeICD9CMId here] end
	private UUID postOperativeICD9CMId;

	// % protected region % [Update the annotation for Recovery Rooms here] off begin
	@Schema(description = "The Recovery Rooms entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Recovery Rooms here] end
	private RoomFacilityEntity recoveryRooms;

	// % protected region % [Update the annotation for recoveryRoomsId here] off begin
	@Transient
	@CsvCustomBindByName(column = "RECOVERY_ROOMS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for recoveryRoomsId here] end
	private UUID recoveryRoomsId;

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
				entity.setPostOperativeDetails(this, false);
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
			entity.unsetPostOperativeDetails(false);
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
			this.bedFacilities.forEach(bedFacilitiesEntity -> bedFacilitiesEntity.setPostOperativeDetails(this, false));
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
			this.bedFacilities.forEach(bedFacilitiesEntity -> bedFacilitiesEntity.unsetPostOperativeDetails(false));
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
			this.operatingTheaterMedicalExaminationRecord.unsetPostOperativeDetails(false);
		}

		this.operatingTheaterMedicalExaminationRecord = entity;
		if (reverseAdd) {
			this.operatingTheaterMedicalExaminationRecord.setPostOperativeDetails(this, false);
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
			this.operatingTheaterMedicalExaminationRecord.unsetPostOperativeDetails();
		}
		this.operatingTheaterMedicalExaminationRecord = null;
	}
	/**
	 * Similar to {@link this#setPostOperativeICD10(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setPostOperativeICD10(@NotNull DiagnosesAndProceduresEntity entity) {
		setPostOperativeICD10(entity, true);
	}

	/**
	 * Set or update the postOperativeICD10 in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to postOperativeICD10
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPostOperativeICD10(@NotNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPostOperativeICD10 here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPostOperativeICD10 here] end

		if (sameAsFormer(this.postOperativeICD10, entity)) {
			return;
		}

		if (this.postOperativeICD10 != null) {
			this.postOperativeICD10.removePostOperativeICD10(this, false);
		}
		this.postOperativeICD10 = entity;
		if (reverseAdd) {
			this.postOperativeICD10.addPostOperativeICD10(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPostOperativeICD10 incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPostOperativeICD10 incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPostOperativeICD10(boolean)} but default to true.
	 */
	public void unsetPostOperativeICD10() {
		this.unsetPostOperativeICD10(true);
	}

	/**
	 * Remove Post Operative ICD 10 in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPostOperativeICD10(boolean reverse) {
		if (reverse && this.postOperativeICD10 != null) {
			this.postOperativeICD10.removePostOperativeICD10(this, false);
		}
		this.postOperativeICD10 = null;
	}
	/**
	 * Similar to {@link this#setPostOperativeICD9CM(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setPostOperativeICD9CM(@NotNull DiagnosesAndProceduresEntity entity) {
		setPostOperativeICD9CM(entity, true);
	}

	/**
	 * Set or update the postOperativeICD9CM in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to postOperativeICD9CM
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPostOperativeICD9CM(@NotNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPostOperativeICD9CM here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPostOperativeICD9CM here] end

		if (sameAsFormer(this.postOperativeICD9CM, entity)) {
			return;
		}

		if (this.postOperativeICD9CM != null) {
			this.postOperativeICD9CM.removePostOperativeICD9CM(this, false);
		}
		this.postOperativeICD9CM = entity;
		if (reverseAdd) {
			this.postOperativeICD9CM.addPostOperativeICD9CM(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPostOperativeICD9CM incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPostOperativeICD9CM incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPostOperativeICD9CM(boolean)} but default to true.
	 */
	public void unsetPostOperativeICD9CM() {
		this.unsetPostOperativeICD9CM(true);
	}

	/**
	 * Remove Post Operative ICD 9 CM in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPostOperativeICD9CM(boolean reverse) {
		if (reverse && this.postOperativeICD9CM != null) {
			this.postOperativeICD9CM.removePostOperativeICD9CM(this, false);
		}
		this.postOperativeICD9CM = null;
	}
	/**
	 * Similar to {@link this#setRecoveryRooms(RoomFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoomFacilityEntity to be set to this entity
	 */
	public void setRecoveryRooms(@NotNull RoomFacilityEntity entity) {
		setRecoveryRooms(entity, true);
	}

	/**
	 * Set or update the recoveryRooms in this entity with single RoomFacilityEntity.
	 *
	 * @param entity the given RoomFacilityEntity to be set or updated to recoveryRooms
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRecoveryRooms(@NotNull RoomFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRecoveryRooms here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRecoveryRooms here] end

		if (sameAsFormer(this.recoveryRooms, entity)) {
			return;
		}

		if (this.recoveryRooms != null) {
			this.recoveryRooms.removeRecoveryRooms(this, false);
		}
		this.recoveryRooms = entity;
		if (reverseAdd) {
			this.recoveryRooms.addRecoveryRooms(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRecoveryRooms incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRecoveryRooms incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRecoveryRooms(boolean)} but default to true.
	 */
	public void unsetRecoveryRooms() {
		this.unsetRecoveryRooms(true);
	}

	/**
	 * Remove Recovery Rooms in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRecoveryRooms(boolean reverse) {
		if (reverse && this.recoveryRooms != null) {
			this.recoveryRooms.removeRecoveryRooms(this, false);
		}
		this.recoveryRooms = null;
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
		return "RECOVERY_START_DATE_TIME,RECOVERY_END_DATE_TIME,POSTOPERATIVE_MAIN_DIAGNOSIS,POSTOPERATIVE_ACTION,NEW_CASE,POSTOPERATIVE_DIAGNOSIS_SUPPORT_ORDER,ANESTHESIA_POSTOPERATIVE_MONITORING,ANESTHESIA_POSTOPERATIVE_ACTION,OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ID,POST_OPERATIVE_ICD_10_ID,POST_OPERATIVE_ICD_9_CM_ID,RECOVERY_ROOMS_ID,BED_FACILITIES_IDS,ID";
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

		Optional<DiagnosesAndProceduresEntity> postOperativeICD10Relation = Optional.ofNullable(this.postOperativeICD10);
		postOperativeICD10Relation.ifPresent(entity -> this.postOperativeICD10Id = entity.getId());

		Optional<DiagnosesAndProceduresEntity> postOperativeICD9CMRelation = Optional.ofNullable(this.postOperativeICD9CM);
		postOperativeICD9CMRelation.ifPresent(entity -> this.postOperativeICD9CMId = entity.getId());

		Optional<RoomFacilityEntity> recoveryRoomsRelation = Optional.ofNullable(this.recoveryRooms);
		recoveryRoomsRelation.ifPresent(entity -> this.recoveryRoomsId = entity.getId());

		this.bedFacilitiesIds = new HashSet<>();
		for (BedFacilityEntity bedFacilities: this.bedFacilities) {
			this.bedFacilitiesIds.add(bedFacilities.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object postOperativeDetails) {
		if (this == postOperativeDetails) {
			return true;
		}
		if (postOperativeDetails == null || this.getClass() != postOperativeDetails.getClass()) {
			return false;
		}
		if (!super.equals(postOperativeDetails)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PostOperativeDetailsEntity that = (PostOperativeDetailsEntity) postOperativeDetails;
		return
			Objects.equals(
			     this.recoveryStartDateTime != null ? this.recoveryStartDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.recoveryStartDateTime != null ? that.recoveryStartDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.recoveryEndDateTime != null ? this.recoveryEndDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.recoveryEndDateTime != null ? that.recoveryEndDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.postoperativeMainDiagnosis, that.postoperativeMainDiagnosis) &&
			Objects.equals(this.postoperativeAction, that.postoperativeAction) &&
			Objects.equals(this.newCase, that.newCase) &&
			Objects.equals(this.postoperativeDiagnosisSupportOrder, that.postoperativeDiagnosisSupportOrder) &&
			Objects.equals(this.anesthesiaPostoperativeMonitoring, that.anesthesiaPostoperativeMonitoring) &&
			Objects.equals(this.anesthesiaPostoperativeAction, that.anesthesiaPostoperativeAction) &&
			Objects.equals(this.bedFacilitiesIds, that.bedFacilitiesIds) &&
			Objects.equals(this.operatingTheaterMedicalExaminationRecordId, that.operatingTheaterMedicalExaminationRecordId) &&
			Objects.equals(this.postOperativeICD10Id, that.postOperativeICD10Id) &&
			Objects.equals(this.postOperativeICD9CMId, that.postOperativeICD9CMId) &&
			Objects.equals(this.recoveryRoomsId, that.recoveryRoomsId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
