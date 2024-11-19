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
import kmsweb.entities.DeliveryProgressEntity;
import kmsweb.services.DeliveryProgressService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.DeliveryMedicalExaminationRecordService;
import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;
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
public class DeliveryProgressMutationResolver implements GraphQLMutationResolver {

	private final DeliveryProgressService deliveryProgressService;

	private final DeliveryMedicalExaminationRecordService deliveryMedicalExaminationRecordService;

	private final StaffService staffService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public DeliveryProgressMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			DeliveryMedicalExaminationRecordService deliveryMedicalExaminationRecordService,
			StaffService staffService,
			DeliveryProgressService deliveryProgressService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.deliveryProgressService = deliveryProgressService;

		this.deliveryMedicalExaminationRecordService = deliveryMedicalExaminationRecordService;

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
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'create')")
	public DeliveryProgressEntity createDeliveryProgress(@NonNull DeliveryProgressEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDeliveryMedicalExaminationRecord() != null) {
			rawEntity.setDeliveryMedicalExaminationRecord(deliveryMedicalExaminationRecordService.updateOldData(rawEntity.getDeliveryMedicalExaminationRecord()));
		}

		if (rawEntity.getStaff() != null) {
			rawEntity.setStaff(staffService.updateOldData(rawEntity.getStaff()));
		}

		DeliveryProgressEntity newEntity = deliveryProgressService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link DeliveryProgressMutationResolver#createDeliveryProgress(DeliveryProgressEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'create')")
	public List<DeliveryProgressEntity> createAllDeliveryProgress(@NonNull List<DeliveryProgressEntity> rawEntities) {
		List<DeliveryProgressEntity> newEntities = Lists.newArrayList(deliveryProgressService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'update')")
	public DeliveryProgressEntity updateDeliveryProgress(@NonNull DeliveryProgressEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDeliveryMedicalExaminationRecord() != null) {
			rawEntity.setDeliveryMedicalExaminationRecord(deliveryMedicalExaminationRecordService.updateOldData(rawEntity.getDeliveryMedicalExaminationRecord()));
		}

		if (rawEntity.getStaff() != null) {
			rawEntity.setStaff(staffService.updateOldData(rawEntity.getStaff()));
		}

		DeliveryProgressEntity entityFromDb = deliveryProgressService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		DeliveryProgressEntity newEntity = deliveryProgressService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link DeliveryProgressMutationResolver#updateDeliveryProgress(DeliveryProgressEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'update')")
	public List<DeliveryProgressEntity> updateAllDeliveryProgress(@NonNull List<DeliveryProgressEntity> rawEntities) {
		List<DeliveryProgressEntity> newEntities = Lists.newArrayList(deliveryProgressService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'delete')")
	public String deleteDeliveryProgressById(@NonNull String id) {
		deliveryProgressService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link DeliveryProgressMutationResolver#deleteDeliveryProgressById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'delete')")
	public List<String> deleteAllDeliveryProgressByIds(@NonNull List<String> ids) {
		deliveryProgressService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'delete')")
	public List<String> deleteDeliveryProgressExcludingIds(@NonNull List<String> ids) {
		deliveryProgressService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
