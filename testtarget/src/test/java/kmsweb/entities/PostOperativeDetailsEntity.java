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
public class PostOperativeDetailsEntity extends AbstractEntity {

	public PostOperativeDetailsEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BedFacilitiesOneMany = new EntityReference();
			BedFacilitiesOneMany.entityName = "BedFacility";
			BedFacilitiesOneMany.oppositeName = "PostOperativeDetails";
			BedFacilitiesOneMany.name = "BedFacilities";
			BedFacilitiesOneMany.optional = true;
			BedFacilitiesOneMany.type = "One";
			BedFacilitiesOneMany.oppositeType = "Many";

		References.add(BedFacilitiesOneMany);

		var OperatingTheaterMedicalExaminationRecordOneOne = new EntityReference();
			OperatingTheaterMedicalExaminationRecordOneOne.entityName = "OperatingTheaterMedicalExaminationRecord";
			OperatingTheaterMedicalExaminationRecordOneOne.oppositeName = "OperatingTheaterMedicalExaminationRecord";
			OperatingTheaterMedicalExaminationRecordOneOne.name = "PostOperativeDetails";
			OperatingTheaterMedicalExaminationRecordOneOne.optional = true;
			OperatingTheaterMedicalExaminationRecordOneOne.type = "One";
			OperatingTheaterMedicalExaminationRecordOneOne.oppositeType = "One";

		References.add(OperatingTheaterMedicalExaminationRecordOneOne);

		var PostOperativeICD10OneMany = new EntityReference();
			PostOperativeICD10OneMany.entityName = "DiagnosesAndProcedures";
			PostOperativeICD10OneMany.oppositeName = "PostOperativeICD10";
			PostOperativeICD10OneMany.name = "PostOperativeICD10";
			PostOperativeICD10OneMany.optional = true;
			PostOperativeICD10OneMany.type = "One";
			PostOperativeICD10OneMany.oppositeType = "Many";

		References.add(PostOperativeICD10OneMany);

		var PostOperativeICD9CMOneMany = new EntityReference();
			PostOperativeICD9CMOneMany.entityName = "DiagnosesAndProcedures";
			PostOperativeICD9CMOneMany.oppositeName = "PostOperativeICD9CM";
			PostOperativeICD9CMOneMany.name = "PostOperativeICD9CM";
			PostOperativeICD9CMOneMany.optional = true;
			PostOperativeICD9CMOneMany.type = "One";
			PostOperativeICD9CMOneMany.oppositeType = "Many";

		References.add(PostOperativeICD9CMOneMany);

		var RecoveryRoomsOneMany = new EntityReference();
			RecoveryRoomsOneMany.entityName = "RoomFacility";
			RecoveryRoomsOneMany.oppositeName = "RecoveryRooms";
			RecoveryRoomsOneMany.name = "RecoveryRooms";
			RecoveryRoomsOneMany.optional = true;
			RecoveryRoomsOneMany.type = "One";
			RecoveryRoomsOneMany.oppositeType = "Many";

		References.add(RecoveryRoomsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Recovery Start Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Recovery Start Date Time here] end
	private OffsetDateTime recoveryStartDateTime;

	// % protected region % [Modify attribute annotation for Recovery End Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Recovery End Date Time here] end
	private OffsetDateTime recoveryEndDateTime;

	// % protected region % [Modify attribute annotation for Postoperative Main Diagnosis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Postoperative Main Diagnosis here] end
	private String postoperativeMainDiagnosis;

	// % protected region % [Modify attribute annotation for Postoperative Action here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Postoperative Action here] end
	private String postoperativeAction;

	// % protected region % [Modify attribute annotation for New Case here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for New Case here] end
	private Boolean newCase;

	// % protected region % [Modify attribute annotation for Postoperative Diagnosis Support Order here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Postoperative Diagnosis Support Order here] end
	private String postoperativeDiagnosisSupportOrder;

	// % protected region % [Modify attribute annotation for Anesthesia Postoperative Monitoring here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Anesthesia Postoperative Monitoring here] end
	private String anesthesiaPostoperativeMonitoring;

	// % protected region % [Modify attribute annotation for Anesthesia Postoperative Action here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Anesthesia Postoperative Action here] end
	private String anesthesiaPostoperativeAction;

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

	private OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecord;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<BedFacilityEntity> bedFacilities = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private DiagnosesAndProceduresEntity postOperativeICD10;

	private DiagnosesAndProceduresEntity postOperativeICD9CM;

	private RoomFacilityEntity recoveryRooms;

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
	 * Similar to {@link this#addBedFacilities(BedFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedFacilityEntity to be added to this entity
	 */
	public void addBedFacilities(@NonNull BedFacilityEntity entity) {
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
	public void addBedFacilities(@NonNull Collection<BedFacilityEntity> entities) {
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
	public void removeBedFacilities(@NonNull BedFacilityEntity entity) {
		this.removeBedFacilities(entity, true);
	}

	/**
	 * Remove the given BedFacilityEntity from this entity.
	 *
	 * @param entity the given BedFacilityEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBedFacilities(@NonNull BedFacilityEntity entity, boolean reverse) {
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
	public void removeBedFacilities(@NonNull Collection<BedFacilityEntity> entities) {
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
	public void setBedFacilities(@NonNull Collection<BedFacilityEntity> entities) {
		setBedFacilities(entities, true);
	}

	/**
	 * Replace the current entities in Bed Facilities with the given ones.
	 *
	 * @param entities the given collection of BedFacilityEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBedFacilities(@NonNull Collection<BedFacilityEntity> entities, boolean reverseAdd) {

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
	public void setPostOperativeICD10(@NonNull DiagnosesAndProceduresEntity entity) {
		setPostOperativeICD10(entity, true);
	}

	/**
	 * Set or update the postOperativeICD10 in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to postOperativeICD10
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPostOperativeICD10(@NonNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
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
	public void setPostOperativeICD9CM(@NonNull DiagnosesAndProceduresEntity entity) {
		setPostOperativeICD9CM(entity, true);
	}

	/**
	 * Set or update the postOperativeICD9CM in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to postOperativeICD9CM
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPostOperativeICD9CM(@NonNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
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
	public void setRecoveryRooms(@NonNull RoomFacilityEntity entity) {
		setRecoveryRooms(entity, true);
	}

	/**
	 * Set or update the recoveryRooms in this entity with single RoomFacilityEntity.
	 *
	 * @param entity the given RoomFacilityEntity to be set or updated to recoveryRooms
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRecoveryRooms(@NonNull RoomFacilityEntity entity, boolean reverseAdd) {
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

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
