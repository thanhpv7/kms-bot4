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
import kmsweb.entities.ServiceItemEntity;
import kmsweb.services.ServiceItemService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.ExaminationItemService;
import kmsweb.entities.ExaminationItemEntity;
import kmsweb.services.ServiceService;
import kmsweb.entities.ServiceEntity;
import kmsweb.services.ServiceItemAssignmentService;
import kmsweb.entities.ServiceItemAssignmentEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class ServiceItemMutationResolver implements GraphQLMutationResolver {

	private final ServiceItemService serviceItemService;

	private final ExaminationItemService examinationItemService;

	private final ServiceService serviceService;

	private final ServiceItemAssignmentService serviceItemAssignmentService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public ServiceItemMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			ExaminationItemService examinationItemService,
			ServiceService serviceService,
			ServiceItemAssignmentService serviceItemAssignmentService,
			ServiceItemService serviceItemService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.serviceItemService = serviceItemService;

		this.examinationItemService = examinationItemService;

		this.serviceService = serviceService;

		this.serviceItemAssignmentService = serviceItemAssignmentService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('ServiceItemEntity', 'create')")
	public ServiceItemEntity createServiceItem(@NonNull ServiceItemEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		Set<ExaminationItemEntity> examinationItems = new HashSet<>();
		rawEntity.getExaminationItems().forEach(entity -> {
			examinationItems.add(examinationItemService.updateOldData(entity));
		});
		rawEntity.setExaminationItems(examinationItems);

		Set<ServiceItemAssignmentEntity> serviceItemAssignments = new HashSet<>();
		rawEntity.getServiceItemAssignments().forEach(entity -> {
			serviceItemAssignments.add(serviceItemAssignmentService.updateOldData(entity));
		});
		rawEntity.setServiceItemAssignments(serviceItemAssignments);

		Set<ServiceEntity> services = new HashSet<>();
		rawEntity.getServices().forEach(entity -> {
			services.add(serviceService.updateOldData(entity));
		});
		rawEntity.setServices(services);

		ServiceItemEntity newEntity = serviceItemService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link ServiceItemMutationResolver#createServiceItem(ServiceItemEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('ServiceItemEntity', 'create')")
	public List<ServiceItemEntity> createAllServiceItem(@NonNull List<ServiceItemEntity> rawEntities) {
		List<ServiceItemEntity> newEntities = Lists.newArrayList(serviceItemService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('ServiceItemEntity', 'update')")
	public ServiceItemEntity updateServiceItem(@NonNull ServiceItemEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		Set<ExaminationItemEntity> examinationItems = new HashSet<>();
		rawEntity.getExaminationItems().forEach(entity -> {
			examinationItems.add(examinationItemService.updateOldData(entity));
		});
		rawEntity.setExaminationItems(examinationItems);

		Set<ServiceItemAssignmentEntity> serviceItemAssignments = new HashSet<>();
		rawEntity.getServiceItemAssignments().forEach(entity -> {
			serviceItemAssignments.add(serviceItemAssignmentService.updateOldData(entity));
		});
		rawEntity.setServiceItemAssignments(serviceItemAssignments);

		Set<ServiceEntity> services = new HashSet<>();
		rawEntity.getServices().forEach(entity -> {
			services.add(serviceService.updateOldData(entity));
		});
		rawEntity.setServices(services);

		ServiceItemEntity entityFromDb = serviceItemService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		ServiceItemEntity newEntity = serviceItemService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link ServiceItemMutationResolver#updateServiceItem(ServiceItemEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('ServiceItemEntity', 'update')")
	public List<ServiceItemEntity> updateAllServiceItem(@NonNull List<ServiceItemEntity> rawEntities) {
		List<ServiceItemEntity> newEntities = Lists.newArrayList(serviceItemService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('ServiceItemEntity', 'delete')")
	public String deleteServiceItemById(@NonNull String id) {
		serviceItemService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link ServiceItemMutationResolver#deleteServiceItemById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('ServiceItemEntity', 'delete')")
	public List<String> deleteAllServiceItemByIds(@NonNull List<String> ids) {
		serviceItemService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('ServiceItemEntity', 'delete')")
	public List<String> deleteServiceItemExcludingIds(@NonNull List<String> ids) {
		serviceItemService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
