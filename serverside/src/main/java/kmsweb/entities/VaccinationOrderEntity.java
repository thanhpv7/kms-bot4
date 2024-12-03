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
import kmsweb.dtos.VaccinationOrderEntityDto;
import kmsweb.entities.listeners.VaccinationOrderEntityListener;
import kmsweb.serializers.VaccinationOrderSerializer;
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
@EntityListeners({VaccinationOrderEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = VaccinationOrderSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class VaccinationOrderEntity extends AbstractEntity {

	/**
	 * Takes a VaccinationOrderEntityDto and converts it into a VaccinationOrderEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param vaccinationOrderEntityDto
	 */
	public VaccinationOrderEntity(VaccinationOrderEntityDto vaccinationOrderEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (vaccinationOrderEntityDto.getId() != null) {
			this.setId(vaccinationOrderEntityDto.getId());
		}

		if (vaccinationOrderEntityDto.getVaccinationLocation() != null) {
			this.setVaccinationLocation(vaccinationOrderEntityDto.getVaccinationLocation());
		}

		if (vaccinationOrderEntityDto.getVaccinationReaction() != null) {
			this.setVaccinationReaction(vaccinationOrderEntityDto.getVaccinationReaction());
		}

		if (vaccinationOrderEntityDto.getPurpose() != null) {
			this.setPurpose(vaccinationOrderEntityDto.getPurpose());
		}

		if (vaccinationOrderEntityDto.getVaccinationNotes() != null) {
			this.setVaccinationNotes(vaccinationOrderEntityDto.getVaccinationNotes());
		}

		if (vaccinationOrderEntityDto.getReactionNotes() != null) {
			this.setReactionNotes(vaccinationOrderEntityDto.getReactionNotes());
		}

		if (vaccinationOrderEntityDto.getVaccinationOrderDetails() != null) {
			this.setVaccinationOrderDetails(vaccinationOrderEntityDto.getVaccinationOrderDetails());
		}

		if (vaccinationOrderEntityDto.getRegistration() != null) {
			this.setRegistration(vaccinationOrderEntityDto.getRegistration());
		}

		if (vaccinationOrderEntityDto.getStaff() != null) {
			this.setStaff(vaccinationOrderEntityDto.getStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Vaccination Location here] off begin
	@CsvBindByName(column = "VACCINATION_LOCATION", required = false)
	@Nullable
	@Column(name = "vaccination_location")
	@Schema(description = "The Vaccination Location of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Vaccination Location here] end
	private String vaccinationLocation;

	// % protected region % [Modify attribute annotation for Vaccination Reaction here] off begin
	@CsvBindByName(column = "VACCINATION_REACTION", required = false)
	@Nullable
	@Column(name = "vaccination_reaction")
	@Schema(description = "The Vaccination Reaction of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Vaccination Reaction here] end
	private String vaccinationReaction;

	// % protected region % [Modify attribute annotation for Purpose here] off begin
	@CsvBindByName(column = "PURPOSE", required = false)
	@Nullable
	@Column(name = "purpose")
	@Schema(description = "The Purpose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Purpose here] end
	private String purpose;

	// % protected region % [Modify attribute annotation for Vaccination Notes here] off begin
	@CsvBindByName(column = "VACCINATION_NOTES", required = false)
	@Nullable
	@Column(name = "vaccination_notes")
	@Schema(description = "The Vaccination Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Vaccination Notes here] end
	private String vaccinationNotes;

	// % protected region % [Modify attribute annotation for Reaction Notes here] off begin
	@CsvBindByName(column = "REACTION_NOTES", required = false)
	@Nullable
	@Column(name = "reaction_notes")
	@Schema(description = "The Reaction Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Reaction Notes here] end
	private String reactionNotes;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Vaccination Order Details here] off begin
	@Schema(description = "The Vaccination Order Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "vaccinationOrder", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Vaccination Order Details here] end
	private Set<VaccinationOrderDetailEntity> vaccinationOrderDetails = new HashSet<>();

	// % protected region % [Update the annotation for vaccinationOrderDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "VACCINATION_ORDER_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for vaccinationOrderDetailsIds here] end
	private Set<UUID> vaccinationOrderDetailsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Registration here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Registration here] end
	private RegistrationEntity registration;

	// % protected region % [Update the annotation for registrationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "REGISTRATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for registrationId here] end
	private UUID registrationId;

	// % protected region % [Update the annotation for Staff here] off begin
	@Schema(description = "The Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Staff here] end
	private StaffEntity staff;

	// % protected region % [Update the annotation for staffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for staffId here] end
	private UUID staffId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addVaccinationOrderDetails(VaccinationOrderDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VaccinationOrderDetailEntity to be added to this entity
	 */
	public void addVaccinationOrderDetails(@NotNull VaccinationOrderDetailEntity entity) {
		addVaccinationOrderDetails(entity, true);
	}

	/**
	 * Add a new VaccinationOrderDetailEntity to vaccinationOrderDetails in this entity.
	 *
	 * @param entity the given VaccinationOrderDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addVaccinationOrderDetails(@NonNull VaccinationOrderDetailEntity entity, boolean reverseAdd) {
		if (!this.vaccinationOrderDetails.contains(entity)) {
			vaccinationOrderDetails.add(entity);
			if (reverseAdd) {
				entity.setVaccinationOrder(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addVaccinationOrderDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be added to this entity
	 */
	public void addVaccinationOrderDetails(@NotNull Collection<VaccinationOrderDetailEntity> entities) {
		addVaccinationOrderDetails(entities, true);
	}

	/**
	 * Add a new collection of VaccinationOrderDetailEntity to Vaccination Order Details in this entity.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addVaccinationOrderDetails(@NonNull Collection<VaccinationOrderDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addVaccinationOrderDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeVaccinationOrderDetails(VaccinationOrderDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VaccinationOrderDetailEntity to be set to this entity
	 */
	public void removeVaccinationOrderDetails(@NotNull VaccinationOrderDetailEntity entity) {
		this.removeVaccinationOrderDetails(entity, true);
	}

	/**
	 * Remove the given VaccinationOrderDetailEntity from this entity.
	 *
	 * @param entity the given VaccinationOrderDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeVaccinationOrderDetails(@NotNull VaccinationOrderDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetVaccinationOrder(false);
		}
		this.vaccinationOrderDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeVaccinationOrderDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be removed to this entity
	 */
	public void removeVaccinationOrderDetails(@NotNull Collection<VaccinationOrderDetailEntity> entities) {
		this.removeVaccinationOrderDetails(entities, true);
	}

	/**
	 * Remove the given collection of VaccinationOrderDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeVaccinationOrderDetails(@NonNull Collection<VaccinationOrderDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeVaccinationOrderDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setVaccinationOrderDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be set to this entity
	 */
	public void setVaccinationOrderDetails(@NotNull Collection<VaccinationOrderDetailEntity> entities) {
		setVaccinationOrderDetails(entities, true);
	}

	/**
	 * Replace the current entities in Vaccination Order Details with the given ones.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setVaccinationOrderDetails(@NotNull Collection<VaccinationOrderDetailEntity> entities, boolean reverseAdd) {

		this.unsetVaccinationOrderDetails();
		this.vaccinationOrderDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.vaccinationOrderDetails.forEach(vaccinationOrderDetailsEntity -> vaccinationOrderDetailsEntity.setVaccinationOrder(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetVaccinationOrderDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetVaccinationOrderDetails() {
		this.unsetVaccinationOrderDetails(true);
	}

	/**
	 * Remove all the entities in Vaccination Order Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetVaccinationOrderDetails(boolean doReverse) {
		if (doReverse) {
			this.vaccinationOrderDetails.forEach(vaccinationOrderDetailsEntity -> vaccinationOrderDetailsEntity.unsetVaccinationOrder(false));
		}
		this.vaccinationOrderDetails.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setRegistration(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setRegistration(@NotNull RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update the registration in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to registration
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(@NotNull RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.removeVaccinationOrders(this, false);
		}
		this.registration = entity;
		if (reverseAdd) {
			this.registration.addVaccinationOrders(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove Registration in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.removeVaccinationOrders(this, false);
		}
		this.registration = null;
	}
	/**
	 * Similar to {@link this#setStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setStaff(@NotNull StaffEntity entity) {
		setStaff(entity, true);
	}

	/**
	 * Set or update the staff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to staff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStaff here] end

		if (sameAsFormer(this.staff, entity)) {
			return;
		}

		if (this.staff != null) {
			this.staff.removeVaccinationOrders(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addVaccinationOrders(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStaff(boolean)} but default to true.
	 */
	public void unsetStaff() {
		this.unsetStaff(true);
	}

	/**
	 * Remove Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStaff(boolean reverse) {
		if (reverse && this.staff != null) {
			this.staff.removeVaccinationOrders(this, false);
		}
		this.staff = null;
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
		return "VACCINATION_LOCATION,VACCINATION_REACTION,PURPOSE,VACCINATION_NOTES,REACTION_NOTES,REGISTRATION_ID,STAFF_ID,VACCINATION_ORDER_DETAILS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<RegistrationEntity> registrationRelation = Optional.ofNullable(this.registration);
		registrationRelation.ifPresent(entity -> this.registrationId = entity.getId());

		Optional<StaffEntity> staffRelation = Optional.ofNullable(this.staff);
		staffRelation.ifPresent(entity -> this.staffId = entity.getId());

		this.vaccinationOrderDetailsIds = new HashSet<>();
		for (VaccinationOrderDetailEntity vaccinationOrderDetails: this.vaccinationOrderDetails) {
			this.vaccinationOrderDetailsIds.add(vaccinationOrderDetails.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object vaccinationOrder) {
		if (this == vaccinationOrder) {
			return true;
		}
		if (vaccinationOrder == null || this.getClass() != vaccinationOrder.getClass()) {
			return false;
		}
		if (!super.equals(vaccinationOrder)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		VaccinationOrderEntity that = (VaccinationOrderEntity) vaccinationOrder;
		return
			Objects.equals(this.vaccinationLocation, that.vaccinationLocation) &&
			Objects.equals(this.vaccinationReaction, that.vaccinationReaction) &&
			Objects.equals(this.purpose, that.purpose) &&
			Objects.equals(this.vaccinationNotes, that.vaccinationNotes) &&
			Objects.equals(this.reactionNotes, that.reactionNotes) &&
			Objects.equals(this.vaccinationOrderDetailsIds, that.vaccinationOrderDetailsIds) &&
			Objects.equals(this.registrationId, that.registrationId) &&
			Objects.equals(this.staffId, that.staffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
