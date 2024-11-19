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
public class HospitalGroupInformationEntity extends AbstractEntity {

	public HospitalGroupInformationEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var HospitalBranchInformationsOneMany = new EntityReference();
			HospitalBranchInformationsOneMany.entityName = "HospitalBranchInformation";
			HospitalBranchInformationsOneMany.oppositeName = "HospitalGroup";
			HospitalBranchInformationsOneMany.name = "HospitalBranchInformations";
			HospitalBranchInformationsOneMany.optional = true;
			HospitalBranchInformationsOneMany.type = "One";
			HospitalBranchInformationsOneMany.oppositeType = "Many";

		References.add(HospitalBranchInformationsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Hospital Group Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Group Code here] end
	private String hospitalGroupCode;

	// % protected region % [Modify attribute annotation for Hospital Group Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Group Name here] end
	private String hospitalGroupName;

	// % protected region % [Modify attribute annotation for Hospital Group Corporation Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Group Corporation Name here] end
	private String hospitalGroupCorporationName;

	// % protected region % [Modify attribute annotation for Hospital Group Director here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Group Director here] end
	private String hospitalGroupDirector;

	// % protected region % [Modify attribute annotation for Operational License No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Operational License No here] end
	private String operationalLicenseNo;

	// % protected region % [Modify attribute annotation for Hospital Group Corporation Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Group Corporation Status here] end
	private String hospitalGroupCorporationStatus;

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

	// % protected region % [Modify attribute annotation for Postcode here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Postcode here] end
	private String postcode;

	// % protected region % [Modify attribute annotation for Phone Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Phone Number here] end
	private String phoneNumber;

	// % protected region % [Modify attribute annotation for Fax here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Fax here] end
	private String fax;

	// % protected region % [Modify attribute annotation for Email here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

	// % protected region % [Modify attribute annotation for Website here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Website here] end
	private String website;

	// % protected region % [Modify attribute annotation for Contact Person here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Contact Person here] end
	private String contactPerson;

	// % protected region % [Modify attribute annotation for Contact Person Phone Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Contact Person Phone Number here] end
	private String contactPersonPhoneNumber;

	// % protected region % [Modify attribute annotation for Contact Person Email here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Contact Person Email here] end
	private String contactPersonEmail;

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

	private Set<HospitalBranchInformationEntity> hospitalBranchInformations = new HashSet<>();

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
	 * Similar to {@link this#addHospitalBranchInformations(HospitalBranchInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HospitalBranchInformationEntity to be added to this entity
	 */
	public void addHospitalBranchInformations(@NonNull HospitalBranchInformationEntity entity) {
		addHospitalBranchInformations(entity, true);
	}

	/**
	 * Add a new HospitalBranchInformationEntity to hospitalBranchInformations in this entity.
	 *
	 * @param entity the given HospitalBranchInformationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addHospitalBranchInformations(@NonNull HospitalBranchInformationEntity entity, boolean reverseAdd) {
		if (!this.hospitalBranchInformations.contains(entity)) {
			hospitalBranchInformations.add(entity);
			if (reverseAdd) {
				entity.setHospitalGroup(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addHospitalBranchInformations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be added to this entity
	 */
	public void addHospitalBranchInformations(@NonNull Collection<HospitalBranchInformationEntity> entities) {
		addHospitalBranchInformations(entities, true);
	}

	/**
	 * Add a new collection of HospitalBranchInformationEntity to Hospital Branch Informations in this entity.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addHospitalBranchInformations(@NonNull Collection<HospitalBranchInformationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addHospitalBranchInformations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeHospitalBranchInformations(HospitalBranchInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HospitalBranchInformationEntity to be set to this entity
	 */
	public void removeHospitalBranchInformations(@NonNull HospitalBranchInformationEntity entity) {
		this.removeHospitalBranchInformations(entity, true);
	}

	/**
	 * Remove the given HospitalBranchInformationEntity from this entity.
	 *
	 * @param entity the given HospitalBranchInformationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeHospitalBranchInformations(@NonNull HospitalBranchInformationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetHospitalGroup(false);
		}
		this.hospitalBranchInformations.remove(entity);
	}

	/**
	 * Similar to {@link this#removeHospitalBranchInformations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be removed to this entity
	 */
	public void removeHospitalBranchInformations(@NonNull Collection<HospitalBranchInformationEntity> entities) {
		this.removeHospitalBranchInformations(entities, true);
	}

	/**
	 * Remove the given collection of HospitalBranchInformationEntity from  to this entity.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeHospitalBranchInformations(@NonNull Collection<HospitalBranchInformationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeHospitalBranchInformations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setHospitalBranchInformations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be set to this entity
	 */
	public void setHospitalBranchInformations(@NonNull Collection<HospitalBranchInformationEntity> entities) {
		setHospitalBranchInformations(entities, true);
	}

	/**
	 * Replace the current entities in Hospital Branch Informations with the given ones.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setHospitalBranchInformations(@NonNull Collection<HospitalBranchInformationEntity> entities, boolean reverseAdd) {

		this.unsetHospitalBranchInformations();
		this.hospitalBranchInformations = new HashSet<>(entities);
		if (reverseAdd) {
			this.hospitalBranchInformations.forEach(hospitalBranchInformationsEntity -> hospitalBranchInformationsEntity.setHospitalGroup(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetHospitalBranchInformations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetHospitalBranchInformations() {
		this.unsetHospitalBranchInformations(true);
	}

	/**
	 * Remove all the entities in Hospital Branch Informations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetHospitalBranchInformations(boolean doReverse) {
		if (doReverse) {
			this.hospitalBranchInformations.forEach(hospitalBranchInformationsEntity -> hospitalBranchInformationsEntity.unsetHospitalGroup(false));
		}
		this.hospitalBranchInformations.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
