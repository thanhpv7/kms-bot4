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
import kmsweb.entities.SampleCollectionItemsEntity;
import kmsweb.services.SampleCollectionItemsService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.SampleCollectionInformationService;
import kmsweb.entities.SampleCollectionInformationEntity;
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
public class SampleCollectionItemsMutationResolver implements GraphQLMutationResolver {

	private final SampleCollectionItemsService sampleCollectionItemsService;

	private final SampleCollectionInformationService sampleCollectionInformationService;

	private final StaffService staffService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public SampleCollectionItemsMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			SampleCollectionInformationService sampleCollectionInformationService,
			StaffService staffService,
			SampleCollectionItemsService sampleCollectionItemsService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.sampleCollectionItemsService = sampleCollectionItemsService;

		this.sampleCollectionInformationService = sampleCollectionInformationService;

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
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'create')")
	public SampleCollectionItemsEntity createSampleCollectionItems(@NonNull SampleCollectionItemsEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getSampleCollectionInformation() != null) {
			rawEntity.setSampleCollectionInformation(sampleCollectionInformationService.updateOldData(rawEntity.getSampleCollectionInformation()));
		}

		if (rawEntity.getSampleCollectionStaff() != null) {
			rawEntity.setSampleCollectionStaff(staffService.updateOldData(rawEntity.getSampleCollectionStaff()));
		}

		if (rawEntity.getSampleDeliveryStaff() != null) {
			rawEntity.setSampleDeliveryStaff(staffService.updateOldData(rawEntity.getSampleDeliveryStaff()));
		}

		if (rawEntity.getSampleProcessingStaff() != null) {
			rawEntity.setSampleProcessingStaff(staffService.updateOldData(rawEntity.getSampleProcessingStaff()));
		}

		SampleCollectionItemsEntity newEntity = sampleCollectionItemsService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link SampleCollectionItemsMutationResolver#createSampleCollectionItems(SampleCollectionItemsEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'create')")
	public List<SampleCollectionItemsEntity> createAllSampleCollectionItems(@NonNull List<SampleCollectionItemsEntity> rawEntities) {
		List<SampleCollectionItemsEntity> newEntities = Lists.newArrayList(sampleCollectionItemsService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'update')")
	public SampleCollectionItemsEntity updateSampleCollectionItems(@NonNull SampleCollectionItemsEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getSampleCollectionInformation() != null) {
			rawEntity.setSampleCollectionInformation(sampleCollectionInformationService.updateOldData(rawEntity.getSampleCollectionInformation()));
		}

		if (rawEntity.getSampleCollectionStaff() != null) {
			rawEntity.setSampleCollectionStaff(staffService.updateOldData(rawEntity.getSampleCollectionStaff()));
		}

		if (rawEntity.getSampleDeliveryStaff() != null) {
			rawEntity.setSampleDeliveryStaff(staffService.updateOldData(rawEntity.getSampleDeliveryStaff()));
		}

		if (rawEntity.getSampleProcessingStaff() != null) {
			rawEntity.setSampleProcessingStaff(staffService.updateOldData(rawEntity.getSampleProcessingStaff()));
		}

		SampleCollectionItemsEntity entityFromDb = sampleCollectionItemsService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		SampleCollectionItemsEntity newEntity = sampleCollectionItemsService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link SampleCollectionItemsMutationResolver#updateSampleCollectionItems(SampleCollectionItemsEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'update')")
	public List<SampleCollectionItemsEntity> updateAllSampleCollectionItems(@NonNull List<SampleCollectionItemsEntity> rawEntities) {
		List<SampleCollectionItemsEntity> newEntities = Lists.newArrayList(sampleCollectionItemsService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'delete')")
	public String deleteSampleCollectionItemsById(@NonNull String id) {
		sampleCollectionItemsService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link SampleCollectionItemsMutationResolver#deleteSampleCollectionItemsById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'delete')")
	public List<String> deleteAllSampleCollectionItemsByIds(@NonNull List<String> ids) {
		sampleCollectionItemsService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'delete')")
	public List<String> deleteSampleCollectionItemsExcludingIds(@NonNull List<String> ids) {
		sampleCollectionItemsService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
