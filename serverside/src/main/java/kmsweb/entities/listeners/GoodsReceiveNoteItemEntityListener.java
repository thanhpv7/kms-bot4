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
package kmsweb.entities.listeners;

import kmsweb.configs.properties.*;
import kmsweb.configs.security.auditing.services.GoodsReceiveNoteItemEntityReadAuditService;
import kmsweb.entities.GoodsReceiveNoteItemEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.persistence.*;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Listener class used to tap into life cycle hooks when processing GoodsReceiveNoteItemEntity.
 */
@Slf4j
@Component
public class GoodsReceiveNoteItemEntityListener {

	private static PermissionEvaluator permissionEvaluator;
	private static GoodsReceiveNoteItemEntityReadAuditService auditService;
	private static SecurityProperties securityProperties;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public void init(
		PermissionEvaluator permissionEvaluator,
		GoodsReceiveNoteItemEntityReadAuditService auditService,
		SecurityProperties securityProperties
	) {
		GoodsReceiveNoteItemEntityListener.permissionEvaluator = permissionEvaluator;
		GoodsReceiveNoteItemEntityListener.auditService = auditService;
		GoodsReceiveNoteItemEntityListener.securityProperties = securityProperties;
	}

	@PrePersist
	public void beforePersist(GoodsReceiveNoteItemEntity entity) {
		checkPermission(entity.getClass().getSimpleName(), "create");

		// % protected region % [Add any custom logic to be executed before the entity is persisted here] off begin
		// % protected region % [Add any custom logic to be executed before the entity is persisted here] end
	}

	@PostPersist
	public void afterPersist(GoodsReceiveNoteItemEntity entity) {
		// % protected region % [Add any custom logic to be executed after the entity has been persisted here] off begin
		// % protected region % [Add any custom logic to be executed after the entity has been persisted here] end
	}

	@PreRemove
	public void beforeRemove(GoodsReceiveNoteItemEntity entity) {
		checkPermission(entity.getClass().getSimpleName(), "delete");
		removeAllReferences(entity);

		// % protected region % [Add any custom logic to be executed before the entity is removed here] off begin
		// % protected region % [Add any custom logic to be executed before the entity is removed here] end
	}

	@PostRemove
	public void afterRemove(GoodsReceiveNoteItemEntity entity) {
		// % protected region % [Add any custom logic to be executed after the entity has been removed here] off begin
		// % protected region % [Add any custom logic to be executed after the entity has been removed here] end
	}

	@PreUpdate
	public void beforeUpdate(GoodsReceiveNoteItemEntity entity) {
		checkPermission(entity.getClass().getSimpleName(), "update");

		// % protected region % [Add any custom logic to be executed before the entity is updated here] off begin
		// % protected region % [Add any custom logic to be executed before the entity is updated here] end
	}

	@PostUpdate
	public void afterUpdate(GoodsReceiveNoteItemEntity entity) {
		// % protected region % [Add any custom logic to be executed after the entity has been updated here] off begin
		// % protected region % [Add any custom logic to be executed after the entity has been updated here] end
	}

	@PostLoad
	public void afterLoad(GoodsReceiveNoteItemEntity entity) throws JsonProcessingException {
		checkPermission(entity.getClass().getSimpleName(), "read");

		// % protected region % [Override the global configuration for read audits for the GoodsReceiveNoteItemEntity here] off begin
		if (securityProperties.isReadAuditEnabled()) {
			// Create a new read record against this entity.
			auditService.createWith(entity);
		}
		// % protected region % [Override the global configuration for read audits for the GoodsReceiveNoteItemEntity here] end

		// % protected region % [Add any custom logic to be executed before the entity has been loaded here] off begin
		// % protected region % [Add any custom logic to be executed before the entity has been loaded here] end
	}

	/**
	 * Given an entity name and a permission, check if the currently logged-in user has such permission against the
	 * the entity.
	 */
	private void checkPermission(@NonNull String entityName, @NonNull String permission) {
		if (!permissionEvaluator.hasPermission(SecurityContextHolder.getContext().getAuthentication(), entityName, permission)) {
			log.error("Access to {} with permission {} is denied.", entityName, permission);
			throw new AccessDeniedException("Access to Goods Receive Note Item is not permitted.");
		}
	}

	/**
	 * Remove all references
	 * This is to avoid inconsistency of the data after delete.
	 *
	 * @param entity The entity to clean
	 */
	protected void removeAllReferences(GoodsReceiveNoteItemEntity entity) {
		entity.unsetGoodsReceiveNote();
		entity.unsetPurchaseOrderStockDetail();
		entity.unsetStockCatalogue();
		entity.unsetGoodsReceiveNoteBatchs();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}