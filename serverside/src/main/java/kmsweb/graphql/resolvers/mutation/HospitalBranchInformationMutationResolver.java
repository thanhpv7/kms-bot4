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
import kmsweb.entities.HospitalBranchInformationEntity;
import kmsweb.services.HospitalBranchInformationService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.HospitalGroupInformationService;
import kmsweb.entities.HospitalGroupInformationEntity;
import kmsweb.services.StaffService;
import kmsweb.entities.StaffEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class HospitalBranchInformationMutationResolver implements GraphQLMutationResolver {

	private final HospitalBranchInformationService hospitalBranchInformationService;

	private final HospitalGroupInformationService hospitalGroupInformationService;

	private final StaffService staffService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public HospitalBranchInformationMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			HospitalGroupInformationService hospitalGroupInformationService,
			StaffService staffService,
			HospitalBranchInformationService hospitalBranchInformationService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.hospitalBranchInformationService = hospitalBranchInformationService;

		this.hospitalGroupInformationService = hospitalGroupInformationService;

		this.staffService = staffService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'create')")
	public HospitalBranchInformationEntity createHospitalBranchInformation(@NonNull HospitalBranchInformationEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getHospitalGroup() != null) {
			rawEntity.setHospitalGroup(hospitalGroupInformationService.updateOldData(rawEntity.getHospitalGroup()));
		}

		if (rawEntity.getStaff() != null) {
			rawEntity.setStaff(staffService.updateOldData(rawEntity.getStaff()));
		}

		HospitalBranchInformationEntity newEntity = hospitalBranchInformationService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link HospitalBranchInformationMutationResolver#createHospitalBranchInformation(HospitalBranchInformationEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'create')")
	public List<HospitalBranchInformationEntity> createAllHospitalBranchInformation(@NonNull List<HospitalBranchInformationEntity> rawEntities) {
		List<HospitalBranchInformationEntity> newEntities = Lists.newArrayList(hospitalBranchInformationService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'update')")
	public HospitalBranchInformationEntity updateHospitalBranchInformation(@NonNull HospitalBranchInformationEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getHospitalGroup() != null) {
			rawEntity.setHospitalGroup(hospitalGroupInformationService.updateOldData(rawEntity.getHospitalGroup()));
		}

		if (rawEntity.getStaff() != null) {
			rawEntity.setStaff(staffService.updateOldData(rawEntity.getStaff()));
		}

		HospitalBranchInformationEntity entityFromDb = hospitalBranchInformationService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		HospitalBranchInformationEntity newEntity = hospitalBranchInformationService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link HospitalBranchInformationMutationResolver#updateHospitalBranchInformation(HospitalBranchInformationEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'update')")
	public List<HospitalBranchInformationEntity> updateAllHospitalBranchInformation(@NonNull List<HospitalBranchInformationEntity> rawEntities) {
		List<HospitalBranchInformationEntity> newEntities = Lists.newArrayList(hospitalBranchInformationService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'delete')")
	public String deleteHospitalBranchInformationById(@NonNull String id) {
		hospitalBranchInformationService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link HospitalBranchInformationMutationResolver#deleteHospitalBranchInformationById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'delete')")
	public List<String> deleteAllHospitalBranchInformationByIds(@NonNull List<String> ids) {
		hospitalBranchInformationService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'delete')")
	public List<String> deleteHospitalBranchInformationExcludingIds(@NonNull List<String> ids) {
		hospitalBranchInformationService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
