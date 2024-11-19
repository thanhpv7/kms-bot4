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
public class IntraoperativeRecordsEntity extends AbstractEntity {

	public IntraoperativeRecordsEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BedFacilitiesOneMany = new EntityReference();
			BedFacilitiesOneMany.entityName = "BedFacility";
			BedFacilitiesOneMany.oppositeName = "IntraoperativeRecords";
			BedFacilitiesOneMany.name = "BedFacilities";
			BedFacilitiesOneMany.optional = true;
			BedFacilitiesOneMany.type = "One";
			BedFacilitiesOneMany.oppositeType = "Many";

		References.add(BedFacilitiesOneMany);

		var OperatingTheaterMedicalExaminationRecordOneOne = new EntityReference();
			OperatingTheaterMedicalExaminationRecordOneOne.entityName = "OperatingTheaterMedicalExaminationRecord";
			OperatingTheaterMedicalExaminationRecordOneOne.oppositeName = "OperatingTheaterMedicalExaminationRecord";
			OperatingTheaterMedicalExaminationRecordOneOne.name = "IntraoperativeRecords";
			OperatingTheaterMedicalExaminationRecordOneOne.optional = true;
			OperatingTheaterMedicalExaminationRecordOneOne.type = "One";
			OperatingTheaterMedicalExaminationRecordOneOne.oppositeType = "One";

		References.add(OperatingTheaterMedicalExaminationRecordOneOne);

		var OperatingRoomOneMany = new EntityReference();
			OperatingRoomOneMany.entityName = "RoomFacility";
			OperatingRoomOneMany.oppositeName = "OperatingRoom";
			OperatingRoomOneMany.name = "OperatingRoom";
			OperatingRoomOneMany.optional = true;
			OperatingRoomOneMany.type = "One";
			OperatingRoomOneMany.oppositeType = "Many";

		References.add(OperatingRoomOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Start Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Start Date Time here] end
	private OffsetDateTime startDateTime;

	// % protected region % [Modify attribute annotation for End Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for End Date Time here] end
	private OffsetDateTime endDateTime;

	// % protected region % [Modify attribute annotation for Surgery Start Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Surgery Start Date Time here] end
	private OffsetDateTime surgeryStartDateTime;

	// % protected region % [Modify attribute annotation for Surgery End Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Surgery End Date Time here] end
	private OffsetDateTime surgeryEndDateTime;

	// % protected region % [Modify attribute annotation for Surgery Details here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Surgery Details here] end
	private String surgeryDetails;

	// % protected region % [Modify attribute annotation for Blood Transfusion here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Blood Transfusion here] end
	private String bloodTransfusion;

	// % protected region % [Modify attribute annotation for Instruments Used here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Instruments Used here] end
	private String instrumentsUsed;

	// % protected region % [Modify attribute annotation for Anesthesia Start Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Anesthesia Start Date Time here] end
	private OffsetDateTime anesthesiaStartDateTime;

	// % protected region % [Modify attribute annotation for Anesthesia Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Anesthesia Type here] end
	private String anesthesiaType;

	// % protected region % [Modify attribute annotation for Anesthesia Method here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Anesthesia Method here] end
	private String anesthesiaMethod;

	// % protected region % [Modify attribute annotation for Anesthesia Agents here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Anesthesia Agents here] end
	private String anesthesiaAgents;

	// % protected region % [Modify attribute annotation for Anesthesia Observations here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Anesthesia Observations here] end
	private String anesthesiaObservations;

	// % protected region % [Modify attribute annotation for Anesthesia Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Anesthesia Notes here] end
	private String anesthesiaNotes;

	// % protected region % [Modify attribute annotation for Anesthesia End Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Anesthesia End Date Time here] end
	private OffsetDateTime anesthesiaEndDateTime;

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

	private RoomFacilityEntity operatingRoom;

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
	public void setOperatingRoom(@NonNull RoomFacilityEntity entity) {
		setOperatingRoom(entity, true);
	}

	/**
	 * Set or update the operatingRoom in this entity with single RoomFacilityEntity.
	 *
	 * @param entity the given RoomFacilityEntity to be set or updated to operatingRoom
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setOperatingRoom(@NonNull RoomFacilityEntity entity, boolean reverseAdd) {
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

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
