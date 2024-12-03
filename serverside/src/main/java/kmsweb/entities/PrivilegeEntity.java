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

package kmsweb.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.dtos.PrivilegeEntityDto;
import kmsweb.entities.listeners.PrivilegeEntityListener;
import kmsweb.serializers.PrivilegeSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
// % protected region % [Override the auditing annotation or add additional annotations here] off begin
@Audited
// % protected region % [Override the auditing annotation or add additional annotations here] end
@ExcludeSuperclassListeners
@EntityListeners({PrivilegeEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PrivilegeSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"name"}, name = "name"),
	}
)
public class PrivilegeEntity extends AbstractEntity {

	/**
	 * Takes a PrivilegeEntityDto and converts it into a PrivilegeEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param privilegeEntityDto
	 */
	public PrivilegeEntity(PrivilegeEntityDto privilegeEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (privilegeEntityDto.getId() != null) {
			this.setId(privilegeEntityDto.getId());
		}

		if (privilegeEntityDto.getName() != null) {
			this.setName(privilegeEntityDto.getName());
		}

		if (privilegeEntityDto.getTargetEntity() != null) {
			this.setTargetEntity(privilegeEntityDto.getTargetEntity());
		}

		if (privilegeEntityDto.getAllowCreate() != null) {
			this.setAllowCreate(privilegeEntityDto.getAllowCreate());
		}

		if (privilegeEntityDto.getAllowRead() != null) {
			this.setAllowRead(privilegeEntityDto.getAllowRead());
		}

		if (privilegeEntityDto.getAllowUpdate() != null) {
			this.setAllowUpdate(privilegeEntityDto.getAllowUpdate());
		}

		if (privilegeEntityDto.getAllowDelete() != null) {
			this.setAllowDelete(privilegeEntityDto.getAllowDelete());
		}

		if (privilegeEntityDto.getRoles() != null) {
			this.setRoles(privilegeEntityDto.getRoles());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for name here] off begin
	@CsvBindByName(column = "NAME", required = false)
	@Nullable
	@Column(name = "name")
	@Schema(description = "The name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for name here] end
	private String name;

	// % protected region % [Modify attribute annotation for target entity here] off begin
	@CsvBindByName(column = "TARGET_ENTITY", required = false)
	@Nullable
	@Column(name = "target_entity")
	@Schema(description = "The target entity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for target entity here] end
	private String targetEntity;

	// % protected region % [Modify attribute annotation for allow create here] off begin
	@CsvBindByName(column = "ALLOW_CREATE", required = false)
	@Nullable
	@Column(name = "allow_create")
	@Schema(description = "The allow create of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for allow create here] end
	private Boolean allowCreate = false ;

	// % protected region % [Modify attribute annotation for allow read here] off begin
	@CsvBindByName(column = "ALLOW_READ", required = false)
	@Nullable
	@Column(name = "allow_read")
	@Schema(description = "The allow read of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for allow read here] end
	private Boolean allowRead = false ;

	// % protected region % [Modify attribute annotation for allow update here] off begin
	@CsvBindByName(column = "ALLOW_UPDATE", required = false)
	@Nullable
	@Column(name = "allow_update")
	@Schema(description = "The allow update of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for allow update here] end
	private Boolean allowUpdate = false ;

	// % protected region % [Modify attribute annotation for allow delete here] off begin
	@CsvBindByName(column = "ALLOW_DELETE", required = false)
	@Nullable
	@Column(name = "allow_delete")
	@Schema(description = "The allow delete of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for allow delete here] end
	private Boolean allowDelete = false ;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for roles here] off begin
	@Schema(description = "The roles entities that are related to this entity.")
	@ManyToMany(mappedBy = "privileges", fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for roles here] end
	private Set<RoleEntity> roles = new HashSet<>();

	// % protected region % [Update the annotation for rolesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "ROLES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for rolesIds here] end
	private Set<UUID> rolesIds = new HashSet<>();

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#addRoles(RoleEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoleEntity to be added to roles
	 */
	public void addRoles(@NotNull RoleEntity entity) {
		this.addRoles(entity, true);
	}

	/**
	 * Add a new RoleEntity to roles in this entity.
	 *
	 * @param entity the given RoleEntity to be added to roles
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRoles(@NotNull RoleEntity entity, boolean reverseAdd) {
		if (!this.roles.contains(entity)) {
			this.roles.add(entity);
			if (reverseAdd) {
				entity.addPrivileges(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRoles(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RoleEntity to be added into roles
	 */
	public void addRoles(@NotNull Collection<RoleEntity> entities) {
		this.addRoles(entities, true);
	}

	/**
	 * Add new collection of RoleEntity to roles in this entity.
	 *
	 * @param entities the given collection of RoleEntity to be added into roles in this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRoles(@NonNull Collection<RoleEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.addRoles(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRoles(RoleEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoleEntity to be set to roles in this entity
	 */
	public void removeRoles(@NotNull RoleEntity entity) {
		this.removeRoles(entity, true);
	}

	/**
	 * Remove the given RoleEntity from roles in this entity.
	 *
	 * @param entity the given RoleEntity to be removed from roles
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRoles(@NotNull RoleEntity entity, boolean reverse) {
		if (reverse) {
			entity.removePrivileges(this, false);
		}
		this.roles.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRoles(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RoleEntity to be removed from roles in this entity
	 */
	public void removeRoles(@NotNull Collection<RoleEntity> entities) {
		this.removeRoles(entities, true);
	}

	/**
	 * Remove the given collection of RoleEntity from roles in this entity.
	 *
	 * @param entities the given collection of RoleEntity to be removed from roles
	 * @param reverseRemove whether this entity should be removed to the given entities
	 */
	public void removeRoles(@NonNull Collection<RoleEntity> entities, boolean reverseRemove) {
		entities.forEach(entity -> this.removeRoles(entity, reverseRemove));
	}

	/**
	 * Similar to {@link this#setRoles(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RoleEntity to replace the old ones in roles
	 */
	public void setRoles(@NotNull Collection<RoleEntity> entities) {
		this.setRoles(entities, true);
	}

	/**
	 * Replace the current collection of RoleEntity in roles with the given ones.
	 *
	 * @param entities the given collection of RoleEntity to replace the old ones in roles
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRoles(@NotNull Collection<RoleEntity> entities, boolean reverseAdd) {
		unsetRoles();
		this.roles = new HashSet<>(entities);
		if (reverseAdd) {
			this.roles.forEach(rolesEntity -> rolesEntity.addPrivileges(this, false));
		}
	}

	/**
	 * Remove all entities in roles from this entity.
	 */
	public void unsetRoles() {
		this.roles.forEach(entity -> entity.removePrivileges(this, false));
		this.roles.clear();
	}

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "NAME,TARGET_ENTITY,ALLOW_CREATE,ALLOW_READ,ALLOW_UPDATE,ALLOW_DELETE,ROLES_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		this.rolesIds = new HashSet<>();
		for (RoleEntity roles: this.roles) {
			this.rolesIds.add(roles.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object privilege) {
		if (this == privilege) {
			return true;
		}
		if (privilege == null || this.getClass() != privilege.getClass()) {
			return false;
		}
		if (!super.equals(privilege)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PrivilegeEntity that = (PrivilegeEntity) privilege;
		return
			Objects.equals(this.name, that.name) &&
			Objects.equals(this.targetEntity, that.targetEntity) &&
			Objects.equals(this.allowCreate, that.allowCreate) &&
			Objects.equals(this.allowRead, that.allowRead) &&
			Objects.equals(this.allowUpdate, that.allowUpdate) &&
			Objects.equals(this.allowDelete, that.allowDelete);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
