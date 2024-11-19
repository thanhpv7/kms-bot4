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
import kmsweb.entities.SampleCollectionInformationEntity;
import kmsweb.services.SampleCollectionInformationService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.DiagnosisExaminationRecordService;
import kmsweb.entities.DiagnosisExaminationRecordEntity;
import kmsweb.services.RegistrationService;
import kmsweb.entities.RegistrationEntity;
import kmsweb.services.SampleCollectionItemsService;
import kmsweb.entities.SampleCollectionItemsEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class SampleCollectionInformationMutationResolver implements GraphQLMutationResolver {

	private final SampleCollectionInformationService sampleCollectionInformationService;

	private final DiagnosisExaminationRecordService diagnosisExaminationRecordService;

	private final RegistrationService registrationService;

	private final SampleCollectionItemsService sampleCollectionItemsService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public SampleCollectionInformationMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			DiagnosisExaminationRecordService diagnosisExaminationRecordService,
			RegistrationService registrationService,
			SampleCollectionItemsService sampleCollectionItemsService,
			SampleCollectionInformationService sampleCollectionInformationService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.sampleCollectionInformationService = sampleCollectionInformationService;

		this.diagnosisExaminationRecordService = diagnosisExaminationRecordService;

		this.registrationService = registrationService;

		this.sampleCollectionItemsService = sampleCollectionItemsService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'create')")
	public SampleCollectionInformationEntity createSampleCollectionInformation(@NonNull SampleCollectionInformationEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDiagnosisExaminationRecord() != null) {
			rawEntity.setDiagnosisExaminationRecord(diagnosisExaminationRecordService.updateOldData(rawEntity.getDiagnosisExaminationRecord()));
		}

		if (rawEntity.getRegistration() != null) {
			rawEntity.setRegistration(registrationService.updateOldData(rawEntity.getRegistration()));
		}

		Set<SampleCollectionItemsEntity> sampleCollectionItems = new HashSet<>();
		rawEntity.getSampleCollectionItems().forEach(entity -> {
			sampleCollectionItems.add(sampleCollectionItemsService.updateOldData(entity));
		});
		rawEntity.setSampleCollectionItems(sampleCollectionItems);

		SampleCollectionInformationEntity newEntity = sampleCollectionInformationService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link SampleCollectionInformationMutationResolver#createSampleCollectionInformation(SampleCollectionInformationEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'create')")
	public List<SampleCollectionInformationEntity> createAllSampleCollectionInformation(@NonNull List<SampleCollectionInformationEntity> rawEntities) {
		List<SampleCollectionInformationEntity> newEntities = Lists.newArrayList(sampleCollectionInformationService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'update')")
	public SampleCollectionInformationEntity updateSampleCollectionInformation(@NonNull SampleCollectionInformationEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDiagnosisExaminationRecord() != null) {
			rawEntity.setDiagnosisExaminationRecord(diagnosisExaminationRecordService.updateOldData(rawEntity.getDiagnosisExaminationRecord()));
		}

		if (rawEntity.getRegistration() != null) {
			rawEntity.setRegistration(registrationService.updateOldData(rawEntity.getRegistration()));
		}

		Set<SampleCollectionItemsEntity> sampleCollectionItems = new HashSet<>();
		rawEntity.getSampleCollectionItems().forEach(entity -> {
			sampleCollectionItems.add(sampleCollectionItemsService.updateOldData(entity));
		});
		rawEntity.setSampleCollectionItems(sampleCollectionItems);

		SampleCollectionInformationEntity entityFromDb = sampleCollectionInformationService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		SampleCollectionInformationEntity newEntity = sampleCollectionInformationService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link SampleCollectionInformationMutationResolver#updateSampleCollectionInformation(SampleCollectionInformationEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'update')")
	public List<SampleCollectionInformationEntity> updateAllSampleCollectionInformation(@NonNull List<SampleCollectionInformationEntity> rawEntities) {
		List<SampleCollectionInformationEntity> newEntities = Lists.newArrayList(sampleCollectionInformationService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'delete')")
	public String deleteSampleCollectionInformationById(@NonNull String id) {
		sampleCollectionInformationService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link SampleCollectionInformationMutationResolver#deleteSampleCollectionInformationById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'delete')")
	public List<String> deleteAllSampleCollectionInformationByIds(@NonNull List<String> ids) {
		sampleCollectionInformationService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'delete')")
	public List<String> deleteSampleCollectionInformationExcludingIds(@NonNull List<String> ids) {
		sampleCollectionInformationService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
