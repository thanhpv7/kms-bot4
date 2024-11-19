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
package kmsweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import kmsweb.entities.UserEntity;
import kmsweb.entities.AbstractEntityAudit;
import kmsweb.entities.RoleEntity;
import kmsweb.lib.validators.SimpleConstraintViolationImpl;
import kmsweb.repositories.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Optional;
import java.util.List;
import java.util.Set;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

public abstract class UserService<E extends UserEntity, R extends UserRepository<E>, T extends AbstractEntityAudit<E>> extends AbstractService<E, R, T> {
	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Given that a user can exist in the system without being part of one of the child user classes, validation on the abstract user service
	 * must be performed against the top level user repository.
	 */
	@Autowired
	private kmsweb.configs.security.repositories.UserRepository userRepository;

	public UserService(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			R repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Name.
	 *
	 * @param name the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name
	 */
	@PreAuthorize("hasPermission('UserEntity', 'read')")
	public Optional<E> findByName(String name)
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] end
	{
		// % protected region % [Add any additional logic for findByName here] off begin
		// % protected region % [Add any additional logic for findByName here] end

		return repository.findByName(name);
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Username.
	 *
	 * @param username the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Username
	 */
	@PreAuthorize("hasPermission('UserEntity', 'read')")
	public Optional<E> findByUsername(String username)
	// % protected region % [Add any throwables, implementations, or extensions for findByUsername here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUsername here] end
	{
		// % protected region % [Add any additional logic for findByUsername here] off begin
		// % protected region % [Add any additional logic for findByUsername here] end

		return repository.findByUsername(username);
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Password.
	 *
	 * @param password the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Password
	 */
	@PreAuthorize("hasPermission('UserEntity', 'read')")
	public List<E> findByPassword(String password)
	// % protected region % [Add any throwables, implementations, or extensions for findByPassword here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPassword here] end
	{
		// % protected region % [Add any additional logic for findByPassword here] off begin
		// % protected region % [Add any additional logic for findByPassword here] end

		return Lists.newArrayList(repository.findByPassword(password));
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Email Confirmed confirmed.
	 *
	 * @param emailConfirmedConfirmed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email Confirmed confirmed
	 */
	@PreAuthorize("hasPermission('UserEntity', 'read')")
	public List<E> findByEmailConfirmedConfirmed(Boolean emailConfirmedConfirmed)
	// % protected region % [Add any throwables, implementations, or extensions for findByEmailConfirmedConfirmed here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEmailConfirmedConfirmed here] end
	{
		// % protected region % [Add any additional logic for findByEmailConfirmedConfirmed here] off begin
		// % protected region % [Add any additional logic for findByEmailConfirmedConfirmed here] end

		return Lists.newArrayList(repository.findByEmailConfirmedConfirmed(emailConfirmedConfirmed));
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email
	 */
	@PreAuthorize("hasPermission('UserEntity', 'read')")
	public Optional<E> findByEmail(String email)
	// % protected region % [Add any throwables, implementations, or extensions for findByEmail here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEmail here] end
	{
		// % protected region % [Add any additional logic for findByEmail here] off begin
		// % protected region % [Add any additional logic for findByEmail here] end

		return repository.findByEmail(email);
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Is Archived.
	 *
	 * @param isArchived the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Archived
	 */
	@PreAuthorize("hasPermission('UserEntity', 'read')")
	public List<E> findByIsArchived(Boolean isArchived)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsArchived here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsArchived here] end
	{
		// % protected region % [Add any additional logic for findByIsArchived here] off begin
		// % protected region % [Add any additional logic for findByIsArchived here] end

		return Lists.newArrayList(repository.findByIsArchived(isArchived));
	}

	/**
	 * Return the default roles for this user entity type.
	 *
	 * @return the default roles for this user entity type
	 */
	abstract public List<RoleEntity> getDefaultRoles()
	// % protected region % [Add any throwables, implementations, or extensions for getDefaultRoles here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getDefaultRoles here] end
	;

	/**
	 * All user entities have some key attributes that need to be validated.
	 * For example, email and username.
	 *
	 * Unlike similar methods found in each specific user service, this method does not throw any exceptions with the
	 * handling of the results being left up to the client.
	 *
	 * @param entity The entity to validate
	 * @return Set of constraint violation errors if any exist, otherwise an empty set
	 */
	protected Set<ConstraintViolation<E>> validateEntity(E entity, Set<ConstraintViolation<E>> errors) {
		if (errors == null || errors.isEmpty()) {
			errors = new HashSet<>();
		}

		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		if (entity.getId() == null) {
			var entityByNameOpt = this.findByName(entity.getName());
			if (entityByNameOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<E>(
						"Name",
						entity.getName(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"Name"
				);
				errors.add(uniquenessViolation);
			}
			var entityByUsernameOpt = this.findByUsername(entity.getUsername());
			if (entityByUsernameOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<E>(
						"Username",
						entity.getUsername(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"Username"
				);
				errors.add(uniquenessViolation);
			}
			var entityByEmailOpt = this.findByEmail(entity.getEmail());
			if (entityByEmailOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<E>(
						"Email",
						entity.getEmail(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"Email"
				);
				errors.add(uniquenessViolation);
			}
		}
		// % protected region % [Add additional constraints here] off begin
		// % protected region % [Add additional constraints here] end

		return errors;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}