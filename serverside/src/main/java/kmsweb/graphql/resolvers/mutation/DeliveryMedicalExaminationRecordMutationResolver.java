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
import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;
import kmsweb.services.DeliveryMedicalExaminationRecordService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.CoTreatingDoctorService;
import kmsweb.entities.CoTreatingDoctorEntity;
import kmsweb.services.DeliveryProgressService;
import kmsweb.entities.DeliveryProgressEntity;
import kmsweb.services.MedicalExaminationRecordService;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.services.NewbornDetailService;
import kmsweb.entities.NewbornDetailEntity;
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
public class DeliveryMedicalExaminationRecordMutationResolver implements GraphQLMutationResolver {

	private final DeliveryMedicalExaminationRecordService deliveryMedicalExaminationRecordService;

	private final CoTreatingDoctorService coTreatingDoctorService;

	private final DeliveryProgressService deliveryProgressService;

	private final MedicalExaminationRecordService medicalExaminationRecordService;

	private final NewbornDetailService newbornDetailService;

	private final StaffService staffService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public DeliveryMedicalExaminationRecordMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			CoTreatingDoctorService coTreatingDoctorService,
			DeliveryProgressService deliveryProgressService,
			MedicalExaminationRecordService medicalExaminationRecordService,
			NewbornDetailService newbornDetailService,
			StaffService staffService,
			DeliveryMedicalExaminationRecordService deliveryMedicalExaminationRecordService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.deliveryMedicalExaminationRecordService = deliveryMedicalExaminationRecordService;

		this.coTreatingDoctorService = coTreatingDoctorService;

		this.deliveryProgressService = deliveryProgressService;

		this.medicalExaminationRecordService = medicalExaminationRecordService;

		this.newbornDetailService = newbornDetailService;

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
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'create')")
	public DeliveryMedicalExaminationRecordEntity createDeliveryMedicalExaminationRecord(@NonNull DeliveryMedicalExaminationRecordEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getMedicalExaminationRecord() != null) {
			rawEntity.setMedicalExaminationRecord(medicalExaminationRecordService.updateOldData(rawEntity.getMedicalExaminationRecord()));
		}

		if (rawEntity.getMidwife() != null) {
			rawEntity.setMidwife(staffService.updateOldData(rawEntity.getMidwife()));
		}

		Set<CoTreatingDoctorEntity> additionalMidwives = new HashSet<>();
		rawEntity.getAdditionalMidwives().forEach(entity -> {
			additionalMidwives.add(coTreatingDoctorService.updateOldData(entity));
		});
		rawEntity.setAdditionalMidwives(additionalMidwives);

		Set<DeliveryProgressEntity> deliveryProgresses = new HashSet<>();
		rawEntity.getDeliveryProgresses().forEach(entity -> {
			deliveryProgresses.add(deliveryProgressService.updateOldData(entity));
		});
		rawEntity.setDeliveryProgresses(deliveryProgresses);

		Set<NewbornDetailEntity> newbornDetails = new HashSet<>();
		rawEntity.getNewbornDetails().forEach(entity -> {
			newbornDetails.add(newbornDetailService.updateOldData(entity));
		});
		rawEntity.setNewbornDetails(newbornDetails);

		DeliveryMedicalExaminationRecordEntity newEntity = deliveryMedicalExaminationRecordService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link DeliveryMedicalExaminationRecordMutationResolver#createDeliveryMedicalExaminationRecord(DeliveryMedicalExaminationRecordEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'create')")
	public List<DeliveryMedicalExaminationRecordEntity> createAllDeliveryMedicalExaminationRecord(@NonNull List<DeliveryMedicalExaminationRecordEntity> rawEntities) {
		List<DeliveryMedicalExaminationRecordEntity> newEntities = Lists.newArrayList(deliveryMedicalExaminationRecordService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'update')")
	public DeliveryMedicalExaminationRecordEntity updateDeliveryMedicalExaminationRecord(@NonNull DeliveryMedicalExaminationRecordEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getMedicalExaminationRecord() != null) {
			rawEntity.setMedicalExaminationRecord(medicalExaminationRecordService.updateOldData(rawEntity.getMedicalExaminationRecord()));
		}

		if (rawEntity.getMidwife() != null) {
			rawEntity.setMidwife(staffService.updateOldData(rawEntity.getMidwife()));
		}

		Set<CoTreatingDoctorEntity> additionalMidwives = new HashSet<>();
		rawEntity.getAdditionalMidwives().forEach(entity -> {
			additionalMidwives.add(coTreatingDoctorService.updateOldData(entity));
		});
		rawEntity.setAdditionalMidwives(additionalMidwives);

		Set<DeliveryProgressEntity> deliveryProgresses = new HashSet<>();
		rawEntity.getDeliveryProgresses().forEach(entity -> {
			deliveryProgresses.add(deliveryProgressService.updateOldData(entity));
		});
		rawEntity.setDeliveryProgresses(deliveryProgresses);

		Set<NewbornDetailEntity> newbornDetails = new HashSet<>();
		rawEntity.getNewbornDetails().forEach(entity -> {
			newbornDetails.add(newbornDetailService.updateOldData(entity));
		});
		rawEntity.setNewbornDetails(newbornDetails);

		DeliveryMedicalExaminationRecordEntity entityFromDb = deliveryMedicalExaminationRecordService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		DeliveryMedicalExaminationRecordEntity newEntity = deliveryMedicalExaminationRecordService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link DeliveryMedicalExaminationRecordMutationResolver#updateDeliveryMedicalExaminationRecord(DeliveryMedicalExaminationRecordEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'update')")
	public List<DeliveryMedicalExaminationRecordEntity> updateAllDeliveryMedicalExaminationRecord(@NonNull List<DeliveryMedicalExaminationRecordEntity> rawEntities) {
		List<DeliveryMedicalExaminationRecordEntity> newEntities = Lists.newArrayList(deliveryMedicalExaminationRecordService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'delete')")
	public String deleteDeliveryMedicalExaminationRecordById(@NonNull String id) {
		deliveryMedicalExaminationRecordService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link DeliveryMedicalExaminationRecordMutationResolver#deleteDeliveryMedicalExaminationRecordById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'delete')")
	public List<String> deleteAllDeliveryMedicalExaminationRecordByIds(@NonNull List<String> ids) {
		deliveryMedicalExaminationRecordService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'delete')")
	public List<String> deleteDeliveryMedicalExaminationRecordExcludingIds(@NonNull List<String> ids) {
		deliveryMedicalExaminationRecordService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
