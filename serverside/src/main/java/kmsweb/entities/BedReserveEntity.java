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
import kmsweb.dtos.BedReserveEntityDto;
import kmsweb.entities.listeners.BedReserveEntityListener;
import kmsweb.serializers.BedReserveSerializer;
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
@EntityListeners({BedReserveEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BedReserveSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BedReserveEntity extends AbstractEntity {

	/**
	 * Takes a BedReserveEntityDto and converts it into a BedReserveEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bedReserveEntityDto
	 */
	public BedReserveEntity(BedReserveEntityDto bedReserveEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bedReserveEntityDto.getId() != null) {
			this.setId(bedReserveEntityDto.getId());
		}

		if (bedReserveEntityDto.getNotes() != null) {
			this.setNotes(bedReserveEntityDto.getNotes());
		}

		if (bedReserveEntityDto.getBedFacility() != null) {
			this.setBedFacility(bedReserveEntityDto.getBedFacility());
		}

		if (bedReserveEntityDto.getRegistration() != null) {
			this.setRegistration(bedReserveEntityDto.getRegistration());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

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

	// % protected region % [Update the annotation for Bed Facility here] off begin
	@Schema(description = "The Bed Facility entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Bed Facility here] end
	private BedFacilityEntity bedFacility;

	// % protected region % [Update the annotation for bedFacilityId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BED_FACILITY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bedFacilityId here] end
	private UUID bedFacilityId;

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
	 * Similar to {@link this#setBedFacility(BedFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedFacilityEntity to be set to this entity
	 */
	public void setBedFacility(@NotNull BedFacilityEntity entity) {
		setBedFacility(entity, true);
	}

	/**
	 * Set or update the bedFacility in this entity with single BedFacilityEntity.
	 *
	 * @param entity the given BedFacilityEntity to be set or updated to bedFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBedFacility(@NotNull BedFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBedFacility here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBedFacility here] end

		if (sameAsFormer(this.bedFacility, entity)) {
			return;
		}

		if (this.bedFacility != null) {
			this.bedFacility.removeBedReserves(this, false);
		}
		this.bedFacility = entity;
		if (reverseAdd) {
			this.bedFacility.addBedReserves(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBedFacility incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBedFacility incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBedFacility(boolean)} but default to true.
	 */
	public void unsetBedFacility() {
		this.unsetBedFacility(true);
	}

	/**
	 * Remove Bed Facility in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBedFacility(boolean reverse) {
		if (reverse && this.bedFacility != null) {
			this.bedFacility.removeBedReserves(this, false);
		}
		this.bedFacility = null;
	}
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
			this.registration.removeBedReserves(this, false);
		}
		this.registration = entity;
		if (reverseAdd) {
			this.registration.addBedReserves(this, false);
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
			this.registration.removeBedReserves(this, false);
		}
		this.registration = null;
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
		return "NOTES,BED_FACILITY_ID,REGISTRATION_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<BedFacilityEntity> bedFacilityRelation = Optional.ofNullable(this.bedFacility);
		bedFacilityRelation.ifPresent(entity -> this.bedFacilityId = entity.getId());

		Optional<RegistrationEntity> registrationRelation = Optional.ofNullable(this.registration);
		registrationRelation.ifPresent(entity -> this.registrationId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bedReserve) {
		if (this == bedReserve) {
			return true;
		}
		if (bedReserve == null || this.getClass() != bedReserve.getClass()) {
			return false;
		}
		if (!super.equals(bedReserve)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BedReserveEntity that = (BedReserveEntity) bedReserve;
		return
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.bedFacilityId, that.bedFacilityId) &&
			Objects.equals(this.registrationId, that.registrationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
