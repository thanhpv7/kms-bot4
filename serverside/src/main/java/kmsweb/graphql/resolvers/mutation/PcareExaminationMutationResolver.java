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
import kmsweb.entities.PcareExaminationEntity;
import kmsweb.services.PcareExaminationService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.PcareActionExaminationService;
import kmsweb.entities.PcareActionExaminationEntity;
import kmsweb.services.PcareCompoundDrugService;
import kmsweb.entities.PcareCompoundDrugEntity;
import kmsweb.services.PcareNonCompoundDrugService;
import kmsweb.entities.PcareNonCompoundDrugEntity;
import kmsweb.services.RegistrationService;
import kmsweb.entities.RegistrationEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class PcareExaminationMutationResolver implements GraphQLMutationResolver {

	private final PcareExaminationService pcareExaminationService;

	private final PcareActionExaminationService pcareActionExaminationService;

	private final PcareCompoundDrugService pcareCompoundDrugService;

	private final PcareNonCompoundDrugService pcareNonCompoundDrugService;

	private final RegistrationService registrationService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PcareExaminationMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			PcareActionExaminationService pcareActionExaminationService,
			PcareCompoundDrugService pcareCompoundDrugService,
			PcareNonCompoundDrugService pcareNonCompoundDrugService,
			RegistrationService registrationService,
			PcareExaminationService pcareExaminationService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.pcareExaminationService = pcareExaminationService;

		this.pcareActionExaminationService = pcareActionExaminationService;

		this.pcareCompoundDrugService = pcareCompoundDrugService;

		this.pcareNonCompoundDrugService = pcareNonCompoundDrugService;

		this.registrationService = registrationService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'create')")
	public PcareExaminationEntity createPcareExamination(@NonNull PcareExaminationEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getRegistration() != null) {
			rawEntity.setRegistration(registrationService.updateOldData(rawEntity.getRegistration()));
		}

		Set<PcareActionExaminationEntity> pcareActionExaminations = new HashSet<>();
		rawEntity.getPcareActionExaminations().forEach(entity -> {
			pcareActionExaminations.add(pcareActionExaminationService.updateOldData(entity));
		});
		rawEntity.setPcareActionExaminations(pcareActionExaminations);

		Set<PcareCompoundDrugEntity> pcareCompoundDrugs = new HashSet<>();
		rawEntity.getPcareCompoundDrugs().forEach(entity -> {
			pcareCompoundDrugs.add(pcareCompoundDrugService.updateOldData(entity));
		});
		rawEntity.setPcareCompoundDrugs(pcareCompoundDrugs);

		Set<PcareNonCompoundDrugEntity> pcareNonCompoundDrugs = new HashSet<>();
		rawEntity.getPcareNonCompoundDrugs().forEach(entity -> {
			pcareNonCompoundDrugs.add(pcareNonCompoundDrugService.updateOldData(entity));
		});
		rawEntity.setPcareNonCompoundDrugs(pcareNonCompoundDrugs);

		PcareExaminationEntity newEntity = pcareExaminationService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PcareExaminationMutationResolver#createPcareExamination(PcareExaminationEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'create')")
	public List<PcareExaminationEntity> createAllPcareExamination(@NonNull List<PcareExaminationEntity> rawEntities) {
		List<PcareExaminationEntity> newEntities = Lists.newArrayList(pcareExaminationService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'update')")
	public PcareExaminationEntity updatePcareExamination(@NonNull PcareExaminationEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getRegistration() != null) {
			rawEntity.setRegistration(registrationService.updateOldData(rawEntity.getRegistration()));
		}

		Set<PcareActionExaminationEntity> pcareActionExaminations = new HashSet<>();
		rawEntity.getPcareActionExaminations().forEach(entity -> {
			pcareActionExaminations.add(pcareActionExaminationService.updateOldData(entity));
		});
		rawEntity.setPcareActionExaminations(pcareActionExaminations);

		Set<PcareCompoundDrugEntity> pcareCompoundDrugs = new HashSet<>();
		rawEntity.getPcareCompoundDrugs().forEach(entity -> {
			pcareCompoundDrugs.add(pcareCompoundDrugService.updateOldData(entity));
		});
		rawEntity.setPcareCompoundDrugs(pcareCompoundDrugs);

		Set<PcareNonCompoundDrugEntity> pcareNonCompoundDrugs = new HashSet<>();
		rawEntity.getPcareNonCompoundDrugs().forEach(entity -> {
			pcareNonCompoundDrugs.add(pcareNonCompoundDrugService.updateOldData(entity));
		});
		rawEntity.setPcareNonCompoundDrugs(pcareNonCompoundDrugs);

		PcareExaminationEntity entityFromDb = pcareExaminationService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		PcareExaminationEntity newEntity = pcareExaminationService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PcareExaminationMutationResolver#updatePcareExamination(PcareExaminationEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'update')")
	public List<PcareExaminationEntity> updateAllPcareExamination(@NonNull List<PcareExaminationEntity> rawEntities) {
		List<PcareExaminationEntity> newEntities = Lists.newArrayList(pcareExaminationService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'delete')")
	public String deletePcareExaminationById(@NonNull String id) {
		pcareExaminationService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link PcareExaminationMutationResolver#deletePcareExaminationById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'delete')")
	public List<String> deleteAllPcareExaminationByIds(@NonNull List<String> ids) {
		pcareExaminationService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('PcareExaminationEntity', 'delete')")
	public List<String> deletePcareExaminationExcludingIds(@NonNull List<String> ids) {
		pcareExaminationService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
