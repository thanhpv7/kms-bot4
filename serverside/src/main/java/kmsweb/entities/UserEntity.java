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
import kmsweb.dtos.UserEntityDto;
import kmsweb.services.utils.converters.*;
import kmsweb.configs.security.authorities.CustomGrantedAuthority;
import kmsweb.configs.security.helpers.AnonymousHelper;
import kmsweb.lib.token.models.TokenEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvBindByName;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.lang.Nullable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;
import java.util.stream.Collectors;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@Audited
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"name"}, name = "name"),
		@UniqueConstraint(columnNames = {"username"}, name = "username"),
		@UniqueConstraint(columnNames = {"email"}, name = "email"),
	}
)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity extends AbstractEntity implements UserDetails {

	/**
	 * Takes a UserEntityDto and converts it into a UserEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param userEntityDto
	 */
	public UserEntity(UserEntityDto userEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (userEntityDto.getId() != null) {
			this.setId(userEntityDto.getId());
		}

		if (userEntityDto.getName() != null) {
			this.setName(userEntityDto.getName());
		}

		if (userEntityDto.getUsername() != null) {
			this.setUsername(userEntityDto.getUsername());
		}

		if (userEntityDto.getPassword() != null) {
			this.setPassword(userEntityDto.getPassword());
		}

		if (userEntityDto.getEmailConfirmedConfirmed() != null) {
			this.setEmailConfirmedConfirmed(userEntityDto.getEmailConfirmedConfirmed());
		}

		if (userEntityDto.getEmail() != null) {
			this.setEmail(userEntityDto.getEmail());
		}

		if (userEntityDto.getIsArchived() != null) {
			this.setIsArchived(userEntityDto.getIsArchived());
		}

		if (userEntityDto.getRoles() != null) {
			this.setRoles(userEntityDto.getRoles());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Name here] off begin
	@Nullable
	@Column(name = "name")
	@Schema(description = "The Name of this entity.")
	@CsvBindByName(column = "NAME", required = true)
	@ToString.Include
	// % protected region % [Modify attribute annotation for Name here] end
	private String name;

	// % protected region % [Modify attribute annotation for Username here] off begin
	@Email
	@Column(name = "username")
	@Schema(description = "The Username of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Username here] end
	private String username;

	// % protected region % [Modify attribute annotation for Password here] off begin
	@Nullable
	@Column(name = "password")
	@JsonProperty(access = Access.WRITE_ONLY)
	@CsvIgnore
	@ToString.Include
	// % protected region % [Modify attribute annotation for Password here] end
	private String password;

	// % protected region % [Modify attribute annotation for Email Confirmed confirmed here] off begin
	@Nullable
	@Column(name = "email_confirmed_confirmed")
	@JsonProperty(access = Access.WRITE_ONLY)
	@ToString.Include
	// % protected region % [Modify attribute annotation for Email Confirmed confirmed here] end
	private Boolean emailConfirmedConfirmed;

	// % protected region % [Modify attribute annotation for Email here] off begin
	@Nullable
	@Column(name = "email")
	@Schema(description = "The Email of this entity.")
	@CsvBindByName(column = "EMAIL", required = true)
	@ToString.Include
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

	// % protected region % [Modify attribute annotation for Is Archived here] off begin
	@NotNull(message = "Is Archived must not be empty")
	@Column(name = "is_archived")
	@Schema(description = "The Is Archived of this entity.")
	@CsvBindByName(column = "IS_ARCHIVED")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Archived here] end
	private Boolean isArchived = false;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for roles here] off begin
	@Schema(description = "The Role entities that are related to this entity.")
	@ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for roles here] end
	private Set<RoleEntity> roles = new HashSet<>();

	// % protected region % [Update the annotation for rolesIds here] off begin
	@Transient
	@CsvIgnore
	// % protected region % [Update the annotation for rolesIds here] end
	private Set<UUID> rolesIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@OneToMany()
	@JoinTable(name = "user_entity_reset_password_token")
	private Set<TokenEntity> resetPasswordToken = new HashSet<>();

	/**
	 * @inheritDoc
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// % protected region % [Configure authorities here] off begin
		return AnonymousHelper.runAnonymouslyAndReturnValue(() -> roles.stream()
				.flatMap(roleEntity -> roleEntity.getPrivileges().stream())
				.map(privilege -> new CustomGrantedAuthority(
						privilege.getName(),
						privilege.getTargetEntity(),
						privilege.getAllowCreate(),
						privilege.getAllowRead(),
						privilege.getAllowUpdate(),
						privilege.getAllowDelete()
				))
				.collect(Collectors.toList()));
		// % protected region % [Configure authorities here] end
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public String getUsername() {
		// % protected region % [Configure username here] off begin
		return email;
		// % protected region % [Configure username here] end
	}

	/**
	 * Set the email and username to be the same as for now they are treated as the same thing
	 * The existence of the username allows for separation in the future
	 *
	 * @param email The email/username to set.
	 */
	public void setEmail(String email) {
		// % protected region % [Configure set email here] off begin
		this.email = email;
		this.username = email;
		// % protected region % [Configure set email here] end
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public boolean isAccountNonExpired() {
		// % protected region % [Configure account expiry here] off begin
		return true;
		// % protected region % [Configure account expiry here] end
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public boolean isAccountNonLocked() {
		// % protected region % [Configure account lockdown here] off begin
		return true;
		// % protected region % [Configure account lockdown here] end
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// % protected region % [Configure credential expiry here] off begin
		return true;
		// % protected region % [Configure credential expiry here] end
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public boolean isEnabled() {
		// % protected region % [Configure account disable here] off begin
		return !isArchived;
		// % protected region % [Configure account disable here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#addRoles(RoleEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoleEntity to be added to this entity
	 */
	public void addRoles(@NotNull RoleEntity entity) {
		addRoles(entity, true);
	}

	/**
	 * Add a new RoleEntity to roles in this entity.
	 *
	 * @param entity the given RoleEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRoles(@NonNull RoleEntity entity, boolean reverseAdd) {
		if (!this.roles.contains(entity)) {
			this.roles.add(entity);
			if (reverseAdd) {
				entity.addUsers(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRoles(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given entities to be added to this entity
	 */
	public void addRoles(@NotNull Collection<RoleEntity> entities) {
		addRoles(entities, true);
	}

	/**
	 * Add new collection of RoleEntity to roles in this entity.
	 *
	 * @param entities the given entities to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRoles(@NonNull Collection<RoleEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRoles(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRoles(RoleEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoleEntity to be set to this entity
	 */
	public void removeRoles(@NotNull RoleEntity entity) {
		this.removeRoles(entity, true);
	}

	/**
	 * Remove the given RoleEntity from this entity.
	 *
	 * @param entity the give RoleEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRoles(@NotNull RoleEntity entity, boolean reverse) {
		if (reverse) {
			entity.removeUsers(this, false);
		}
		this.roles.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRoles(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given entities to be removed to this entity
	 */
	public void removeRoles(@NotNull Collection<RoleEntity> entities) {
		this.removeRoles(entities, true);
	}

	/**
	 * Remove the given collection of RoleEntity in roles from  to this entity.
	 *
	 * @param entities the given entities to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRoles(@NonNull Collection<RoleEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRoles(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRoles(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given entities to be set to this entity
	 */
	public void setRoles(@NotNull Collection<RoleEntity> entities) {
		this.setRoles(entities, true);
	}

	/**
	 * Replace the current entities in roles with the given ones.
	 *
	 * @param entities the given entities to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRoles(@NotNull Collection<RoleEntity> entities, boolean reverseAdd) {
		this.unsetRoles();
		this.roles = new HashSet<>(entities);
		if (reverseAdd) {
			this.roles.forEach(entity -> entity.addUsers(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRoles(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRoles() {
		this.unsetRoles(true);
	}

	/**
	 * Remove all entities in roles from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRoles(boolean doReverse) {
		if (doReverse) {
			this.roles.forEach(entity -> entity.removeUsers(this, false));
		}
		this.roles.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}