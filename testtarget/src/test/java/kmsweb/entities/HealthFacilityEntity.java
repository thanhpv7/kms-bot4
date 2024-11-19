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

import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class HealthFacilityEntity extends AbstractEntity {

	public HealthFacilityEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var DismissalReferringFacilityOneMany = new EntityReference();
			DismissalReferringFacilityOneMany.entityName = "Registration";
			DismissalReferringFacilityOneMany.oppositeName = "DismissalReferringFacility";
			DismissalReferringFacilityOneMany.name = "DismissalReferringFacility";
			DismissalReferringFacilityOneMany.optional = true;
			DismissalReferringFacilityOneMany.type = "One";
			DismissalReferringFacilityOneMany.oppositeType = "Many";

		References.add(DismissalReferringFacilityOneMany);

		var ReferringFacilityOneMany = new EntityReference();
			ReferringFacilityOneMany.entityName = "Registration";
			ReferringFacilityOneMany.oppositeName = "ReferringFacility";
			ReferringFacilityOneMany.name = "ReferringFacility";
			ReferringFacilityOneMany.optional = true;
			ReferringFacilityOneMany.type = "One";
			ReferringFacilityOneMany.oppositeType = "Many";

		References.add(ReferringFacilityOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Health Facility ID here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Health Facility ID here] end
	private String healthFacilityID;

	// % protected region % [Modify attribute annotation for Health Facility Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Health Facility Name here] end
	private String healthFacilityName;

	// % protected region % [Modify attribute annotation for Address here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Address here] end
	private String address;

	// % protected region % [Modify attribute annotation for City here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for City here] end
	private String city;

	// % protected region % [Modify attribute annotation for Post Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Post Code here] end
	private String postCode;

	// % protected region % [Modify attribute annotation for Province here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Province here] end
	private String province;

	// % protected region % [Modify attribute annotation for Country here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Country here] end
	private String country;

	// % protected region % [Modify attribute annotation for Phone Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Phone Number here] end
	private String phoneNumber;

	// % protected region % [Modify attribute annotation for Mobile Phone Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Mobile Phone Number here] end
	private String mobilePhoneNumber;

	// % protected region % [Modify attribute annotation for website here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for website here] end
	private String website;

	// % protected region % [Modify attribute annotation for Email here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

	// % protected region % [Modify attribute annotation for Salutation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Salutation here] end
	private String salutation;

	// % protected region % [Modify attribute annotation for First Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for First Name here] end
	private String firstName;

	// % protected region % [Modify attribute annotation for Last Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Last Name here] end
	private String lastName;

	// % protected region % [Modify attribute annotation for Phone Number POC here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Phone Number POC here] end
	private String phoneNumberPOC;

	// % protected region % [Modify attribute annotation for Mobile Phone Number POC here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Mobile Phone Number POC here] end
	private String mobilePhoneNumberPOC;

	// % protected region % [Modify attribute annotation for Email POC here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Email POC here] end
	private String emailPOC;

	// % protected region % [Modify attribute annotation for Health Facility Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Health Facility Type here] end
	private String healthFacilityType;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<RegistrationEntity> dismissalReferringFacility = new HashSet<>();

	private Set<RegistrationEntity> referringFacility = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addDismissalReferringFacility(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 */
	public void addDismissalReferringFacility(@NonNull RegistrationEntity entity) {
		addDismissalReferringFacility(entity, true);
	}

	/**
	 * Add a new RegistrationEntity to dismissalReferringFacility in this entity.
	 *
	 * @param entity the given RegistrationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDismissalReferringFacility(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.dismissalReferringFacility.contains(entity)) {
			dismissalReferringFacility.add(entity);
			if (reverseAdd) {
				entity.setDismissalReferringFacility(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDismissalReferringFacility(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 */
	public void addDismissalReferringFacility(@NonNull Collection<RegistrationEntity> entities) {
		addDismissalReferringFacility(entities, true);
	}

	/**
	 * Add a new collection of RegistrationEntity to Dismissal Referring Facility in this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDismissalReferringFacility(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDismissalReferringFacility(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDismissalReferringFacility(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void removeDismissalReferringFacility(@NonNull RegistrationEntity entity) {
		this.removeDismissalReferringFacility(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDismissalReferringFacility(@NonNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDismissalReferringFacility(false);
		}
		this.dismissalReferringFacility.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDismissalReferringFacility(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 */
	public void removeDismissalReferringFacility(@NonNull Collection<RegistrationEntity> entities) {
		this.removeDismissalReferringFacility(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity from  to this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDismissalReferringFacility(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDismissalReferringFacility(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDismissalReferringFacility(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be set to this entity
	 */
	public void setDismissalReferringFacility(@NonNull Collection<RegistrationEntity> entities) {
		setDismissalReferringFacility(entities, true);
	}

	/**
	 * Replace the current entities in Dismissal Referring Facility with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDismissalReferringFacility(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

		this.unsetDismissalReferringFacility();
		this.dismissalReferringFacility = new HashSet<>(entities);
		if (reverseAdd) {
			this.dismissalReferringFacility.forEach(dismissalReferringFacilityEntity -> dismissalReferringFacilityEntity.setDismissalReferringFacility(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDismissalReferringFacility(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDismissalReferringFacility() {
		this.unsetDismissalReferringFacility(true);
	}

	/**
	 * Remove all the entities in Dismissal Referring Facility from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDismissalReferringFacility(boolean doReverse) {
		if (doReverse) {
			this.dismissalReferringFacility.forEach(dismissalReferringFacilityEntity -> dismissalReferringFacilityEntity.unsetDismissalReferringFacility(false));
		}
		this.dismissalReferringFacility.clear();
	}

/**
	 * Similar to {@link this#addReferringFacility(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 */
	public void addReferringFacility(@NonNull RegistrationEntity entity) {
		addReferringFacility(entity, true);
	}

	/**
	 * Add a new RegistrationEntity to referringFacility in this entity.
	 *
	 * @param entity the given RegistrationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addReferringFacility(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.referringFacility.contains(entity)) {
			referringFacility.add(entity);
			if (reverseAdd) {
				entity.setReferringFacility(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addReferringFacility(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 */
	public void addReferringFacility(@NonNull Collection<RegistrationEntity> entities) {
		addReferringFacility(entities, true);
	}

	/**
	 * Add a new collection of RegistrationEntity to Referring facility in this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addReferringFacility(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addReferringFacility(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeReferringFacility(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void removeReferringFacility(@NonNull RegistrationEntity entity) {
		this.removeReferringFacility(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeReferringFacility(@NonNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetReferringFacility(false);
		}
		this.referringFacility.remove(entity);
	}

	/**
	 * Similar to {@link this#removeReferringFacility(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 */
	public void removeReferringFacility(@NonNull Collection<RegistrationEntity> entities) {
		this.removeReferringFacility(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity from  to this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeReferringFacility(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeReferringFacility(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setReferringFacility(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be set to this entity
	 */
	public void setReferringFacility(@NonNull Collection<RegistrationEntity> entities) {
		setReferringFacility(entities, true);
	}

	/**
	 * Replace the current entities in Referring facility with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setReferringFacility(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

		this.unsetReferringFacility();
		this.referringFacility = new HashSet<>(entities);
		if (reverseAdd) {
			this.referringFacility.forEach(referringFacilityEntity -> referringFacilityEntity.setReferringFacility(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetReferringFacility(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetReferringFacility() {
		this.unsetReferringFacility(true);
	}

	/**
	 * Remove all the entities in Referring facility from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetReferringFacility(boolean doReverse) {
		if (doReverse) {
			this.referringFacility.forEach(referringFacilityEntity -> referringFacilityEntity.unsetReferringFacility(false));
		}
		this.referringFacility.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
