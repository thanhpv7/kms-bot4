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

import kmsweb.lib.file.models.FileEntity;
import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class RoomFacilityEntity extends AbstractEntity {

	public RoomFacilityEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BedFacilitiesOneMany = new EntityReference();
			BedFacilitiesOneMany.entityName = "BedFacility";
			BedFacilitiesOneMany.oppositeName = "RoomFacility";
			BedFacilitiesOneMany.name = "BedFacilities";
			BedFacilitiesOneMany.optional = true;
			BedFacilitiesOneMany.type = "One";
			BedFacilitiesOneMany.oppositeType = "Many";

		References.add(BedFacilitiesOneMany);

		var OperatingRoomOneMany = new EntityReference();
			OperatingRoomOneMany.entityName = "IntraoperativeRecords";
			OperatingRoomOneMany.oppositeName = "OperatingRoom";
			OperatingRoomOneMany.name = "OperatingRoom";
			OperatingRoomOneMany.optional = true;
			OperatingRoomOneMany.type = "One";
			OperatingRoomOneMany.oppositeType = "Many";

		References.add(OperatingRoomOneMany);

		var PreoperativeRoomsOneMany = new EntityReference();
			PreoperativeRoomsOneMany.entityName = "PreoperativeRecords";
			PreoperativeRoomsOneMany.oppositeName = "PreoperativeRooms";
			PreoperativeRoomsOneMany.name = "PreoperativeRooms";
			PreoperativeRoomsOneMany.optional = true;
			PreoperativeRoomsOneMany.type = "One";
			PreoperativeRoomsOneMany.oppositeType = "Many";

		References.add(PreoperativeRoomsOneMany);

		var RecoveryRoomsOneMany = new EntityReference();
			RecoveryRoomsOneMany.entityName = "PostOperativeDetails";
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

	// % protected region % [Modify attribute annotation for Room Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Room Number here] end
	private String roomNumber;

	// % protected region % [Modify attribute annotation for Room Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Room Name here] end
	private String roomName;

	// % protected region % [Modify attribute annotation for Department here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Department here] end
	private String department;

	// % protected region % [Modify attribute annotation for Gender Allocation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gender Allocation here] end
	private String genderAllocation;

	// % protected region % [Modify attribute annotation for Location here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Location here] end
	private String location;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Category here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Category here] end
	private String category;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	private Set<FileEntity> roomFacilityPicture = new HashSet<>();

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

	private Set<BedFacilityEntity> bedFacilities = new HashSet<>();

	private Set<IntraoperativeRecordsEntity> operatingRoom = new HashSet<>();

	private Set<PreoperativeRecordsEntity> preoperativeRooms = new HashSet<>();

	private Set<PostOperativeDetailsEntity> recoveryRooms = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
				entity.setRoomFacility(this, false);
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
			entity.unsetRoomFacility(false);
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
			this.bedFacilities.forEach(bedFacilitiesEntity -> bedFacilitiesEntity.setRoomFacility(this, false));
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
			this.bedFacilities.forEach(bedFacilitiesEntity -> bedFacilitiesEntity.unsetRoomFacility(false));
		}
		this.bedFacilities.clear();
	}

/**
	 * Similar to {@link this#addOperatingRoom(IntraoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given IntraoperativeRecordsEntity to be added to this entity
	 */
	public void addOperatingRoom(@NonNull IntraoperativeRecordsEntity entity) {
		addOperatingRoom(entity, true);
	}

	/**
	 * Add a new IntraoperativeRecordsEntity to operatingRoom in this entity.
	 *
	 * @param entity the given IntraoperativeRecordsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addOperatingRoom(@NonNull IntraoperativeRecordsEntity entity, boolean reverseAdd) {
		if (!this.operatingRoom.contains(entity)) {
			operatingRoom.add(entity);
			if (reverseAdd) {
				entity.setOperatingRoom(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addOperatingRoom(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of IntraoperativeRecordsEntity to be added to this entity
	 */
	public void addOperatingRoom(@NonNull Collection<IntraoperativeRecordsEntity> entities) {
		addOperatingRoom(entities, true);
	}

	/**
	 * Add a new collection of IntraoperativeRecordsEntity to Operating Room in this entity.
	 *
	 * @param entities the given collection of IntraoperativeRecordsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addOperatingRoom(@NonNull Collection<IntraoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addOperatingRoom(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeOperatingRoom(IntraoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given IntraoperativeRecordsEntity to be set to this entity
	 */
	public void removeOperatingRoom(@NonNull IntraoperativeRecordsEntity entity) {
		this.removeOperatingRoom(entity, true);
	}

	/**
	 * Remove the given IntraoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given IntraoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeOperatingRoom(@NonNull IntraoperativeRecordsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetOperatingRoom(false);
		}
		this.operatingRoom.remove(entity);
	}

	/**
	 * Similar to {@link this#removeOperatingRoom(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of IntraoperativeRecordsEntity to be removed to this entity
	 */
	public void removeOperatingRoom(@NonNull Collection<IntraoperativeRecordsEntity> entities) {
		this.removeOperatingRoom(entities, true);
	}

	/**
	 * Remove the given collection of IntraoperativeRecordsEntity from  to this entity.
	 *
	 * @param entities the given collection of IntraoperativeRecordsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeOperatingRoom(@NonNull Collection<IntraoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeOperatingRoom(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setOperatingRoom(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of IntraoperativeRecordsEntity to be set to this entity
	 */
	public void setOperatingRoom(@NonNull Collection<IntraoperativeRecordsEntity> entities) {
		setOperatingRoom(entities, true);
	}

	/**
	 * Replace the current entities in Operating Room with the given ones.
	 *
	 * @param entities the given collection of IntraoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setOperatingRoom(@NonNull Collection<IntraoperativeRecordsEntity> entities, boolean reverseAdd) {

		this.unsetOperatingRoom();
		this.operatingRoom = new HashSet<>(entities);
		if (reverseAdd) {
			this.operatingRoom.forEach(operatingRoomEntity -> operatingRoomEntity.setOperatingRoom(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetOperatingRoom(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetOperatingRoom() {
		this.unsetOperatingRoom(true);
	}

	/**
	 * Remove all the entities in Operating Room from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetOperatingRoom(boolean doReverse) {
		if (doReverse) {
			this.operatingRoom.forEach(operatingRoomEntity -> operatingRoomEntity.unsetOperatingRoom(false));
		}
		this.operatingRoom.clear();
	}

/**
	 * Similar to {@link this#addPreoperativeRooms(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be added to this entity
	 */
	public void addPreoperativeRooms(@NonNull PreoperativeRecordsEntity entity) {
		addPreoperativeRooms(entity, true);
	}

	/**
	 * Add a new PreoperativeRecordsEntity to preoperativeRooms in this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPreoperativeRooms(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		if (!this.preoperativeRooms.contains(entity)) {
			preoperativeRooms.add(entity);
			if (reverseAdd) {
				entity.setPreoperativeRooms(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPreoperativeRooms(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 */
	public void addPreoperativeRooms(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		addPreoperativeRooms(entities, true);
	}

	/**
	 * Add a new collection of PreoperativeRecordsEntity to Preoperative Rooms in this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPreoperativeRooms(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPreoperativeRooms(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePreoperativeRooms(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void removePreoperativeRooms(@NonNull PreoperativeRecordsEntity entity) {
		this.removePreoperativeRooms(entity, true);
	}

	/**
	 * Remove the given PreoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePreoperativeRooms(@NonNull PreoperativeRecordsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPreoperativeRooms(false);
		}
		this.preoperativeRooms.remove(entity);
	}

	/**
	 * Similar to {@link this#removePreoperativeRooms(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 */
	public void removePreoperativeRooms(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		this.removePreoperativeRooms(entities, true);
	}

	/**
	 * Remove the given collection of PreoperativeRecordsEntity from  to this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePreoperativeRooms(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePreoperativeRooms(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPreoperativeRooms(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be set to this entity
	 */
	public void setPreoperativeRooms(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		setPreoperativeRooms(entities, true);
	}

	/**
	 * Replace the current entities in Preoperative Rooms with the given ones.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPreoperativeRooms(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {

		this.unsetPreoperativeRooms();
		this.preoperativeRooms = new HashSet<>(entities);
		if (reverseAdd) {
			this.preoperativeRooms.forEach(preoperativeRoomsEntity -> preoperativeRoomsEntity.setPreoperativeRooms(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPreoperativeRooms(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPreoperativeRooms() {
		this.unsetPreoperativeRooms(true);
	}

	/**
	 * Remove all the entities in Preoperative Rooms from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPreoperativeRooms(boolean doReverse) {
		if (doReverse) {
			this.preoperativeRooms.forEach(preoperativeRoomsEntity -> preoperativeRoomsEntity.unsetPreoperativeRooms(false));
		}
		this.preoperativeRooms.clear();
	}

/**
	 * Similar to {@link this#addRecoveryRooms(PostOperativeDetailsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PostOperativeDetailsEntity to be added to this entity
	 */
	public void addRecoveryRooms(@NonNull PostOperativeDetailsEntity entity) {
		addRecoveryRooms(entity, true);
	}

	/**
	 * Add a new PostOperativeDetailsEntity to recoveryRooms in this entity.
	 *
	 * @param entity the given PostOperativeDetailsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRecoveryRooms(@NonNull PostOperativeDetailsEntity entity, boolean reverseAdd) {
		if (!this.recoveryRooms.contains(entity)) {
			recoveryRooms.add(entity);
			if (reverseAdd) {
				entity.setRecoveryRooms(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRecoveryRooms(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to be added to this entity
	 */
	public void addRecoveryRooms(@NonNull Collection<PostOperativeDetailsEntity> entities) {
		addRecoveryRooms(entities, true);
	}

	/**
	 * Add a new collection of PostOperativeDetailsEntity to Recovery Rooms in this entity.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRecoveryRooms(@NonNull Collection<PostOperativeDetailsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRecoveryRooms(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRecoveryRooms(PostOperativeDetailsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PostOperativeDetailsEntity to be set to this entity
	 */
	public void removeRecoveryRooms(@NonNull PostOperativeDetailsEntity entity) {
		this.removeRecoveryRooms(entity, true);
	}

	/**
	 * Remove the given PostOperativeDetailsEntity from this entity.
	 *
	 * @param entity the given PostOperativeDetailsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRecoveryRooms(@NonNull PostOperativeDetailsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetRecoveryRooms(false);
		}
		this.recoveryRooms.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRecoveryRooms(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to be removed to this entity
	 */
	public void removeRecoveryRooms(@NonNull Collection<PostOperativeDetailsEntity> entities) {
		this.removeRecoveryRooms(entities, true);
	}

	/**
	 * Remove the given collection of PostOperativeDetailsEntity from  to this entity.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRecoveryRooms(@NonNull Collection<PostOperativeDetailsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRecoveryRooms(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRecoveryRooms(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to be set to this entity
	 */
	public void setRecoveryRooms(@NonNull Collection<PostOperativeDetailsEntity> entities) {
		setRecoveryRooms(entities, true);
	}

	/**
	 * Replace the current entities in Recovery Rooms with the given ones.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRecoveryRooms(@NonNull Collection<PostOperativeDetailsEntity> entities, boolean reverseAdd) {

		this.unsetRecoveryRooms();
		this.recoveryRooms = new HashSet<>(entities);
		if (reverseAdd) {
			this.recoveryRooms.forEach(recoveryRoomsEntity -> recoveryRoomsEntity.setRecoveryRooms(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRecoveryRooms(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRecoveryRooms() {
		this.unsetRecoveryRooms(true);
	}

	/**
	 * Remove all the entities in Recovery Rooms from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRecoveryRooms(boolean doReverse) {
		if (doReverse) {
			this.recoveryRooms.forEach(recoveryRoomsEntity -> recoveryRoomsEntity.unsetRecoveryRooms(false));
		}
		this.recoveryRooms.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	public void addRoomFacilityPicture(FileEntity newFile) {
		roomFacilityPicture.add(newFile);
	}

	public void addAllRoomFacilityPicture(Collection<FileEntity> newFiles) {
		roomFacilityPicture.addAll(newFiles);
	}

	public void removeRoomFacilityPicture(FileEntity newFile) {
		roomFacilityPicture.remove(newFile);
	}

	public boolean containsRoomFacilityPicture(FileEntity newFile) {
		return roomFacilityPicture.contains(newFile);
	}

	public void clearAllRoomFacilityPicture() {
		roomFacilityPicture.clear();
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
