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
import kmsweb.dtos.RoomFacilityEntityDto;
import kmsweb.entities.listeners.RoomFacilityEntityListener;
import kmsweb.serializers.RoomFacilitySerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.lib.file.models.FileEntity;
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
@EntityListeners({RoomFacilityEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = RoomFacilitySerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"room_number"}, name = "room_number"),
	}
)
public class RoomFacilityEntity extends AbstractEntity {

	/**
	 * Takes a RoomFacilityEntityDto and converts it into a RoomFacilityEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param roomFacilityEntityDto
	 */
	public RoomFacilityEntity(RoomFacilityEntityDto roomFacilityEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (roomFacilityEntityDto.getId() != null) {
			this.setId(roomFacilityEntityDto.getId());
		}

		if (roomFacilityEntityDto.getRoomNumber() != null) {
			this.setRoomNumber(roomFacilityEntityDto.getRoomNumber());
		}

		if (roomFacilityEntityDto.getRoomName() != null) {
			this.setRoomName(roomFacilityEntityDto.getRoomName());
		}

		if (roomFacilityEntityDto.getDepartment() != null) {
			this.setDepartment(roomFacilityEntityDto.getDepartment());
		}

		if (roomFacilityEntityDto.getGenderAllocation() != null) {
			this.setGenderAllocation(roomFacilityEntityDto.getGenderAllocation());
		}

		if (roomFacilityEntityDto.getLocation() != null) {
			this.setLocation(roomFacilityEntityDto.getLocation());
		}

		if (roomFacilityEntityDto.getNotes() != null) {
			this.setNotes(roomFacilityEntityDto.getNotes());
		}

		if (roomFacilityEntityDto.getCategory() != null) {
			this.setCategory(roomFacilityEntityDto.getCategory());
		}

		if (roomFacilityEntityDto.getTreatmentClass() != null) {
			this.setTreatmentClass(roomFacilityEntityDto.getTreatmentClass());
		}

		if (roomFacilityEntityDto.getBedFacilities() != null) {
			this.setBedFacilities(roomFacilityEntityDto.getBedFacilities());
		}

		if (roomFacilityEntityDto.getOperatingRoom() != null) {
			this.setOperatingRoom(roomFacilityEntityDto.getOperatingRoom());
		}

		if (roomFacilityEntityDto.getPreoperativeRooms() != null) {
			this.setPreoperativeRooms(roomFacilityEntityDto.getPreoperativeRooms());
		}

		if (roomFacilityEntityDto.getRecoveryRooms() != null) {
			this.setRecoveryRooms(roomFacilityEntityDto.getRecoveryRooms());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Room Number here] off begin
	@CsvBindByName(column = "ROOM_NUMBER", required = true)
	@NotNull(message = "Room Number must not be empty")
	@Column(name = "room_number")
	@Schema(description = "The Room Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Room Number here] end
	private String roomNumber;

	// % protected region % [Modify attribute annotation for Room Name here] off begin
	@CsvBindByName(column = "ROOM_NAME", required = true)
	@NotNull(message = "Room Name must not be empty")
	@Column(name = "room_name")
	@Schema(description = "The Room Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Room Name here] end
	private String roomName;

	// % protected region % [Modify attribute annotation for Department here] off begin
	@CsvBindByName(column = "DEPARTMENT", required = true)
	@NotNull(message = "Department must not be empty")
	@Column(name = "department")
	@Schema(description = "The Department of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Department here] end
	private String department;

	// % protected region % [Modify attribute annotation for Gender Allocation here] off begin
	@CsvBindByName(column = "GENDER_ALLOCATION", required = true)
	@NotNull(message = "Gender Allocation must not be empty")
	@Column(name = "gender_allocation")
	@Schema(description = "The Gender Allocation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gender Allocation here] end
	private String genderAllocation;

	// % protected region % [Modify attribute annotation for Location here] off begin
	@CsvBindByName(column = "LOCATION", required = true)
	@NotNull(message = "Location must not be empty")
	@Column(name = "location")
	@Schema(description = "The Location of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Location here] end
	private String location;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Category here] off begin
	@CsvBindByName(column = "CATEGORY", required = false)
	@Nullable
	@Column(name = "category")
	@Schema(description = "The Category of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Category here] end
	private String category;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@CsvBindByName(column = "TREATMENT_CLASS", required = true)
	@NotNull(message = "Treatment Class must not be empty")
	@Column(name = "treatment_class")
	@Schema(description = "The Treatment Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	@CsvIgnore
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	private Set<FileEntity> roomFacilityPicture = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Bed Facilities here] off begin
	@Schema(description = "The Bed Facility entities that are related to this entity.")
	@OneToMany(mappedBy = "roomFacility", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Bed Facilities here] end
	private Set<BedFacilityEntity> bedFacilities = new HashSet<>();

	// % protected region % [Update the annotation for bedFacilitiesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BED_FACILITIES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bedFacilitiesIds here] end
	private Set<UUID> bedFacilitiesIds = new HashSet<>();

	// % protected region % [Update the annotation for Operating Room here] off begin
	@Schema(description = "The Intraoperative Records entities that are related to this entity.")
	@OneToMany(mappedBy = "operatingRoom", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Operating Room here] end
	private Set<IntraoperativeRecordsEntity> operatingRoom = new HashSet<>();

	// % protected region % [Update the annotation for operatingRoomIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "OPERATING_ROOM_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for operatingRoomIds here] end
	private Set<UUID> operatingRoomIds = new HashSet<>();

	// % protected region % [Update the annotation for Preoperative Rooms here] off begin
	@Schema(description = "The Preoperative Records entities that are related to this entity.")
	@OneToMany(mappedBy = "preoperativeRooms", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Preoperative Rooms here] end
	private Set<PreoperativeRecordsEntity> preoperativeRooms = new HashSet<>();

	// % protected region % [Update the annotation for preoperativeRoomsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PREOPERATIVE_ROOMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for preoperativeRoomsIds here] end
	private Set<UUID> preoperativeRoomsIds = new HashSet<>();

	// % protected region % [Update the annotation for Recovery Rooms here] off begin
	@Schema(description = "The Post Operative Details entities that are related to this entity.")
	@OneToMany(mappedBy = "recoveryRooms", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Recovery Rooms here] end
	private Set<PostOperativeDetailsEntity> recoveryRooms = new HashSet<>();

	// % protected region % [Update the annotation for recoveryRoomsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "RECOVERY_ROOMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for recoveryRoomsIds here] end
	private Set<UUID> recoveryRoomsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
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
	public void addOperatingRoom(@NotNull IntraoperativeRecordsEntity entity) {
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
	public void addOperatingRoom(@NotNull Collection<IntraoperativeRecordsEntity> entities) {
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
	public void removeOperatingRoom(@NotNull IntraoperativeRecordsEntity entity) {
		this.removeOperatingRoom(entity, true);
	}

	/**
	 * Remove the given IntraoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given IntraoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeOperatingRoom(@NotNull IntraoperativeRecordsEntity entity, boolean reverse) {
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
	public void removeOperatingRoom(@NotNull Collection<IntraoperativeRecordsEntity> entities) {
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
	public void setOperatingRoom(@NotNull Collection<IntraoperativeRecordsEntity> entities) {
		setOperatingRoom(entities, true);
	}

	/**
	 * Replace the current entities in Operating Room with the given ones.
	 *
	 * @param entities the given collection of IntraoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setOperatingRoom(@NotNull Collection<IntraoperativeRecordsEntity> entities, boolean reverseAdd) {

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
	public void addPreoperativeRooms(@NotNull PreoperativeRecordsEntity entity) {
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
	public void addPreoperativeRooms(@NotNull Collection<PreoperativeRecordsEntity> entities) {
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
	public void removePreoperativeRooms(@NotNull PreoperativeRecordsEntity entity) {
		this.removePreoperativeRooms(entity, true);
	}

	/**
	 * Remove the given PreoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePreoperativeRooms(@NotNull PreoperativeRecordsEntity entity, boolean reverse) {
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
	public void removePreoperativeRooms(@NotNull Collection<PreoperativeRecordsEntity> entities) {
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
	public void setPreoperativeRooms(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		setPreoperativeRooms(entities, true);
	}

	/**
	 * Replace the current entities in Preoperative Rooms with the given ones.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPreoperativeRooms(@NotNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {

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
	public void addRecoveryRooms(@NotNull PostOperativeDetailsEntity entity) {
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
	public void addRecoveryRooms(@NotNull Collection<PostOperativeDetailsEntity> entities) {
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
	public void removeRecoveryRooms(@NotNull PostOperativeDetailsEntity entity) {
		this.removeRecoveryRooms(entity, true);
	}

	/**
	 * Remove the given PostOperativeDetailsEntity from this entity.
	 *
	 * @param entity the given PostOperativeDetailsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRecoveryRooms(@NotNull PostOperativeDetailsEntity entity, boolean reverse) {
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
	public void removeRecoveryRooms(@NotNull Collection<PostOperativeDetailsEntity> entities) {
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
	public void setRecoveryRooms(@NotNull Collection<PostOperativeDetailsEntity> entities) {
		setRecoveryRooms(entities, true);
	}

	/**
	 * Replace the current entities in Recovery Rooms with the given ones.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRecoveryRooms(@NotNull Collection<PostOperativeDetailsEntity> entities, boolean reverseAdd) {

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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "ROOM_NUMBER,ROOM_NAME,DEPARTMENT,GENDER_ALLOCATION,LOCATION,NOTES,CATEGORY,TREATMENT_CLASS,BED_FACILITIES_IDS,OPERATING_ROOM_IDS,PREOPERATIVE_ROOMS_IDS,RECOVERY_ROOMS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		this.bedFacilitiesIds = new HashSet<>();
		for (BedFacilityEntity bedFacilities: this.bedFacilities) {
			this.bedFacilitiesIds.add(bedFacilities.getId());
		}

		this.operatingRoomIds = new HashSet<>();
		for (IntraoperativeRecordsEntity operatingRoom: this.operatingRoom) {
			this.operatingRoomIds.add(operatingRoom.getId());
		}

		this.preoperativeRoomsIds = new HashSet<>();
		for (PreoperativeRecordsEntity preoperativeRooms: this.preoperativeRooms) {
			this.preoperativeRoomsIds.add(preoperativeRooms.getId());
		}

		this.recoveryRoomsIds = new HashSet<>();
		for (PostOperativeDetailsEntity recoveryRooms: this.recoveryRooms) {
			this.recoveryRoomsIds.add(recoveryRooms.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object roomFacility) {
		if (this == roomFacility) {
			return true;
		}
		if (roomFacility == null || this.getClass() != roomFacility.getClass()) {
			return false;
		}
		if (!super.equals(roomFacility)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		RoomFacilityEntity that = (RoomFacilityEntity) roomFacility;
		return
			Objects.equals(this.roomNumber, that.roomNumber) &&
			Objects.equals(this.roomName, that.roomName) &&
			Objects.equals(this.department, that.department) &&
			Objects.equals(this.genderAllocation, that.genderAllocation) &&
			Objects.equals(this.location, that.location) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.category, that.category) &&
			Objects.equals(this.treatmentClass, that.treatmentClass) &&
			Objects.equals(this.bedFacilitiesIds, that.bedFacilitiesIds) &&
			Objects.equals(this.operatingRoomIds, that.operatingRoomIds) &&
			Objects.equals(this.preoperativeRoomsIds, that.preoperativeRoomsIds) &&
			Objects.equals(this.recoveryRoomsIds, that.recoveryRoomsIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
