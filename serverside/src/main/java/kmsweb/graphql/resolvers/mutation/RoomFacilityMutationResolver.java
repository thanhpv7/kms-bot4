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

package kmsweb.graphql.resolvers.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import kmsweb.entities.RoomFacilityEntity;
import kmsweb.services.RoomFacilityService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BedFacilityService;
import kmsweb.entities.BedFacilityEntity;
import kmsweb.services.IntraoperativeRecordsService;
import kmsweb.entities.IntraoperativeRecordsEntity;
import kmsweb.services.PostOperativeDetailsService;
import kmsweb.entities.PostOperativeDetailsEntity;
import kmsweb.services.PreoperativeRecordsService;
import kmsweb.entities.PreoperativeRecordsEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class RoomFacilityMutationResolver implements GraphQLMutationResolver {

	private final RoomFacilityService roomFacilityService;

	private final BedFacilityService bedFacilityService;

	private final IntraoperativeRecordsService intraoperativeRecordsService;

	private final PostOperativeDetailsService postOperativeDetailsService;

	private final PreoperativeRecordsService preoperativeRecordsService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public RoomFacilityMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BedFacilityService bedFacilityService,
			IntraoperativeRecordsService intraoperativeRecordsService,
			PostOperativeDetailsService postOperativeDetailsService,
			PreoperativeRecordsService preoperativeRecordsService,
			RoomFacilityService roomFacilityService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.roomFacilityService = roomFacilityService;

		this.bedFacilityService = bedFacilityService;

		this.intraoperativeRecordsService = intraoperativeRecordsService;

		this.postOperativeDetailsService = postOperativeDetailsService;

		this.preoperativeRecordsService = preoperativeRecordsService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'create')")
	public RoomFacilityEntity createRoomFacility(@NonNull RoomFacilityEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		Set<BedFacilityEntity> bedFacilities = new HashSet<>();
		rawEntity.getBedFacilities().forEach(entity -> {
			bedFacilities.add(bedFacilityService.updateOldData(entity));
		});
		rawEntity.setBedFacilities(bedFacilities);

		Set<IntraoperativeRecordsEntity> operatingRoom = new HashSet<>();
		rawEntity.getOperatingRoom().forEach(entity -> {
			operatingRoom.add(intraoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setOperatingRoom(operatingRoom);

		Set<PreoperativeRecordsEntity> preoperativeRooms = new HashSet<>();
		rawEntity.getPreoperativeRooms().forEach(entity -> {
			preoperativeRooms.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setPreoperativeRooms(preoperativeRooms);

		Set<PostOperativeDetailsEntity> recoveryRooms = new HashSet<>();
		rawEntity.getRecoveryRooms().forEach(entity -> {
			recoveryRooms.add(postOperativeDetailsService.updateOldData(entity));
		});
		rawEntity.setRecoveryRooms(recoveryRooms);

		RoomFacilityEntity newEntity = roomFacilityService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link RoomFacilityMutationResolver#createRoomFacility(RoomFacilityEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'create')")
	public List<RoomFacilityEntity> createAllRoomFacility(@NonNull List<RoomFacilityEntity> rawEntities) {
		List<RoomFacilityEntity> newEntities = Lists.newArrayList(roomFacilityService.createAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the created entities here] off begin
		// % protected region % [Add any additional logic for update before returning the created entities here] end

		return newEntities;
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'update')")
	public RoomFacilityEntity updateRoomFacility(@NonNull RoomFacilityEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		Set<BedFacilityEntity> bedFacilities = new HashSet<>();
		rawEntity.getBedFacilities().forEach(entity -> {
			bedFacilities.add(bedFacilityService.updateOldData(entity));
		});
		rawEntity.setBedFacilities(bedFacilities);

		Set<IntraoperativeRecordsEntity> operatingRoom = new HashSet<>();
		rawEntity.getOperatingRoom().forEach(entity -> {
			operatingRoom.add(intraoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setOperatingRoom(operatingRoom);

		Set<PreoperativeRecordsEntity> preoperativeRooms = new HashSet<>();
		rawEntity.getPreoperativeRooms().forEach(entity -> {
			preoperativeRooms.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setPreoperativeRooms(preoperativeRooms);

		Set<PostOperativeDetailsEntity> recoveryRooms = new HashSet<>();
		rawEntity.getRecoveryRooms().forEach(entity -> {
			recoveryRooms.add(postOperativeDetailsService.updateOldData(entity));
		});
		rawEntity.setRecoveryRooms(recoveryRooms);

		RoomFacilityEntity entityFromDb = roomFacilityService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		RoomFacilityEntity newEntity = roomFacilityService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link RoomFacilityMutationResolver#updateRoomFacility(RoomFacilityEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'update')")
	public List<RoomFacilityEntity> updateAllRoomFacility(@NonNull List<RoomFacilityEntity> rawEntities) {
		List<RoomFacilityEntity> newEntities = Lists.newArrayList(roomFacilityService.updateAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the updated entities here] off begin
		// % protected region % [Add any additional logic for update before returning the updated entities here] end

		return newEntities;
	}

	/**
	 * Delete the entity with the ID from the database.
	 *
	 * @param id the ID of the entity to be deleted
	 * @return the ID of the deleted entity
	 */
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'delete')")
	public String deleteRoomFacilityById(@NonNull String id) {
		roomFacilityService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link RoomFacilityMutationResolver#deleteRoomFacilityById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'delete')")
	public List<String> deleteAllRoomFacilityByIds(@NonNull List<String> ids) {
		roomFacilityService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('RoomFacilityEntity', 'delete')")
	public List<String> deleteRoomFacilityExcludingIds(@NonNull List<String> ids) {
		roomFacilityService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
