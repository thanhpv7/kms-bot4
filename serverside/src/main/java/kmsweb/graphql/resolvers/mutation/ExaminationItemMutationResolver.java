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
import kmsweb.entities.ExaminationItemEntity;
import kmsweb.services.ExaminationItemService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.DiagnosticExaminationResultsService;
import kmsweb.entities.DiagnosticExaminationResultsEntity;
import kmsweb.services.ExaminationGroupService;
import kmsweb.entities.ExaminationGroupEntity;
import kmsweb.services.ExaminationItemDetailService;
import kmsweb.entities.ExaminationItemDetailEntity;
import kmsweb.services.McuPackageItemService;
import kmsweb.entities.McuPackageItemEntity;
import kmsweb.services.RegistrationService;
import kmsweb.entities.RegistrationEntity;
import kmsweb.services.ServiceItemService;
import kmsweb.entities.ServiceItemEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class ExaminationItemMutationResolver implements GraphQLMutationResolver {

	private final ExaminationItemService examinationItemService;

	private final DiagnosticExaminationResultsService diagnosticExaminationResultsService;

	private final ExaminationGroupService examinationGroupService;

	private final ExaminationItemDetailService examinationItemDetailService;

	private final McuPackageItemService mcuPackageItemService;

	private final RegistrationService registrationService;

	private final ServiceItemService serviceItemService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public ExaminationItemMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			DiagnosticExaminationResultsService diagnosticExaminationResultsService,
			ExaminationGroupService examinationGroupService,
			ExaminationItemDetailService examinationItemDetailService,
			McuPackageItemService mcuPackageItemService,
			RegistrationService registrationService,
			ServiceItemService serviceItemService,
			ExaminationItemService examinationItemService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.examinationItemService = examinationItemService;

		this.diagnosticExaminationResultsService = diagnosticExaminationResultsService;

		this.examinationGroupService = examinationGroupService;

		this.examinationItemDetailService = examinationItemDetailService;

		this.mcuPackageItemService = mcuPackageItemService;

		this.registrationService = registrationService;

		this.serviceItemService = serviceItemService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'create')")
	public ExaminationItemEntity createExaminationItem(@NonNull ExaminationItemEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getExaminationGroup() != null) {
			rawEntity.setExaminationGroup(examinationGroupService.updateOldData(rawEntity.getExaminationGroup()));
		}

		if (rawEntity.getServiceItem() != null) {
			rawEntity.setServiceItem(serviceItemService.updateOldData(rawEntity.getServiceItem()));
		}

		Set<DiagnosticExaminationResultsEntity> diagnosticExaminationResults = new HashSet<>();
		rawEntity.getDiagnosticExaminationResults().forEach(entity -> {
			diagnosticExaminationResults.add(diagnosticExaminationResultsService.updateOldData(entity));
		});
		rawEntity.setDiagnosticExaminationResults(diagnosticExaminationResults);

		Set<ExaminationItemDetailEntity> examinationItemDetails = new HashSet<>();
		rawEntity.getExaminationItemDetails().forEach(entity -> {
			examinationItemDetails.add(examinationItemDetailService.updateOldData(entity));
		});
		rawEntity.setExaminationItemDetails(examinationItemDetails);

		Set<McuPackageItemEntity> examinationItemOfMCUItem = new HashSet<>();
		rawEntity.getExaminationItemOfMCUItem().forEach(entity -> {
			examinationItemOfMCUItem.add(mcuPackageItemService.updateOldData(entity));
		});
		rawEntity.setExaminationItemOfMCUItem(examinationItemOfMCUItem);

		Set<RegistrationEntity> registrations = new HashSet<>();
		rawEntity.getRegistrations().forEach(entity -> {
			registrations.add(registrationService.updateOldData(entity));
		});
		rawEntity.setRegistrations(registrations);

		ExaminationItemEntity newEntity = examinationItemService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link ExaminationItemMutationResolver#createExaminationItem(ExaminationItemEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'create')")
	public List<ExaminationItemEntity> createAllExaminationItem(@NonNull List<ExaminationItemEntity> rawEntities) {
		List<ExaminationItemEntity> newEntities = Lists.newArrayList(examinationItemService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'update')")
	public ExaminationItemEntity updateExaminationItem(@NonNull ExaminationItemEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getExaminationGroup() != null) {
			rawEntity.setExaminationGroup(examinationGroupService.updateOldData(rawEntity.getExaminationGroup()));
		}

		if (rawEntity.getServiceItem() != null) {
			rawEntity.setServiceItem(serviceItemService.updateOldData(rawEntity.getServiceItem()));
		}

		Set<DiagnosticExaminationResultsEntity> diagnosticExaminationResults = new HashSet<>();
		rawEntity.getDiagnosticExaminationResults().forEach(entity -> {
			diagnosticExaminationResults.add(diagnosticExaminationResultsService.updateOldData(entity));
		});
		rawEntity.setDiagnosticExaminationResults(diagnosticExaminationResults);

		Set<ExaminationItemDetailEntity> examinationItemDetails = new HashSet<>();
		rawEntity.getExaminationItemDetails().forEach(entity -> {
			examinationItemDetails.add(examinationItemDetailService.updateOldData(entity));
		});
		rawEntity.setExaminationItemDetails(examinationItemDetails);

		Set<McuPackageItemEntity> examinationItemOfMCUItem = new HashSet<>();
		rawEntity.getExaminationItemOfMCUItem().forEach(entity -> {
			examinationItemOfMCUItem.add(mcuPackageItemService.updateOldData(entity));
		});
		rawEntity.setExaminationItemOfMCUItem(examinationItemOfMCUItem);

		Set<RegistrationEntity> registrations = new HashSet<>();
		rawEntity.getRegistrations().forEach(entity -> {
			registrations.add(registrationService.updateOldData(entity));
		});
		rawEntity.setRegistrations(registrations);

		ExaminationItemEntity entityFromDb = examinationItemService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		ExaminationItemEntity newEntity = examinationItemService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link ExaminationItemMutationResolver#updateExaminationItem(ExaminationItemEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'update')")
	public List<ExaminationItemEntity> updateAllExaminationItem(@NonNull List<ExaminationItemEntity> rawEntities) {
		List<ExaminationItemEntity> newEntities = Lists.newArrayList(examinationItemService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'delete')")
	public String deleteExaminationItemById(@NonNull String id) {
		examinationItemService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link ExaminationItemMutationResolver#deleteExaminationItemById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'delete')")
	public List<String> deleteAllExaminationItemByIds(@NonNull List<String> ids) {
		examinationItemService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('ExaminationItemEntity', 'delete')")
	public List<String> deleteExaminationItemExcludingIds(@NonNull List<String> ids) {
		examinationItemService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
