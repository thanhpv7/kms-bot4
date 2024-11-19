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
import kmsweb.entities.NewbornDetailEntity;
import kmsweb.services.NewbornDetailService;
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
import kmsweb.services.VitalSignsService;
import kmsweb.entities.VitalSignsEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class NewbornDetailMutationResolver implements GraphQLMutationResolver {

	private final NewbornDetailService newbornDetailService;

	private final DeliveryMedicalExaminationRecordService deliveryMedicalExaminationRecordService;

	private final StaffService staffService;

	private final VitalSignsService vitalSignsService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public NewbornDetailMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			DeliveryMedicalExaminationRecordService deliveryMedicalExaminationRecordService,
			StaffService staffService,
			VitalSignsService vitalSignsService,
			NewbornDetailService newbornDetailService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.newbornDetailService = newbornDetailService;

		this.deliveryMedicalExaminationRecordService = deliveryMedicalExaminationRecordService;

		this.staffService = staffService;

		this.vitalSignsService = vitalSignsService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'create')")
	public NewbornDetailEntity createNewbornDetail(@NonNull NewbornDetailEntity rawEntity, Boolean persistRelations) {
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

		Set<VitalSignsEntity> vitalSigns = new HashSet<>();
		rawEntity.getVitalSigns().forEach(entity -> {
			vitalSigns.add(vitalSignsService.updateOldData(entity));
		});
		rawEntity.setVitalSigns(vitalSigns);

		NewbornDetailEntity newEntity = newbornDetailService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link NewbornDetailMutationResolver#createNewbornDetail(NewbornDetailEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'create')")
	public List<NewbornDetailEntity> createAllNewbornDetail(@NonNull List<NewbornDetailEntity> rawEntities) {
		List<NewbornDetailEntity> newEntities = Lists.newArrayList(newbornDetailService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'update')")
	public NewbornDetailEntity updateNewbornDetail(@NonNull NewbornDetailEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDeliveryMedicalExaminationRecord() != null) {
			rawEntity.setDeliveryMedicalExaminationRecord(deliveryMedicalExaminationRecordService.updateOldData(rawEntity.getDeliveryMedicalExaminationRecord()));
		}

		if (rawEntity.getStaff() != null) {
			rawEntity.setStaff(staffService.updateOldData(rawEntity.getStaff()));
		}

		Set<VitalSignsEntity> vitalSigns = new HashSet<>();
		rawEntity.getVitalSigns().forEach(entity -> {
			vitalSigns.add(vitalSignsService.updateOldData(entity));
		});
		rawEntity.setVitalSigns(vitalSigns);

		NewbornDetailEntity entityFromDb = newbornDetailService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		NewbornDetailEntity newEntity = newbornDetailService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link NewbornDetailMutationResolver#updateNewbornDetail(NewbornDetailEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'update')")
	public List<NewbornDetailEntity> updateAllNewbornDetail(@NonNull List<NewbornDetailEntity> rawEntities) {
		List<NewbornDetailEntity> newEntities = Lists.newArrayList(newbornDetailService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'delete')")
	public String deleteNewbornDetailById(@NonNull String id) {
		newbornDetailService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link NewbornDetailMutationResolver#deleteNewbornDetailById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'delete')")
	public List<String> deleteAllNewbornDetailByIds(@NonNull List<String> ids) {
		newbornDetailService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('NewbornDetailEntity', 'delete')")
	public List<String> deleteNewbornDetailExcludingIds(@NonNull List<String> ids) {
		newbornDetailService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
