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
import kmsweb.dtos.PatientVisitPatientPaymentOthersEntityDto;
import kmsweb.entities.listeners.PatientVisitPatientPaymentOthersEntityListener;
import kmsweb.serializers.PatientVisitPatientPaymentOthersSerializer;
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
@EntityListeners({PatientVisitPatientPaymentOthersEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientVisitPatientPaymentOthersSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PatientVisitPatientPaymentOthersEntity extends AbstractEntity {

	/**
	 * Takes a PatientVisitPatientPaymentOthersEntityDto and converts it into a PatientVisitPatientPaymentOthersEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientVisitPatientPaymentOthersEntityDto
	 */
	public PatientVisitPatientPaymentOthersEntity(PatientVisitPatientPaymentOthersEntityDto patientVisitPatientPaymentOthersEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientVisitPatientPaymentOthersEntityDto.getId() != null) {
			this.setId(patientVisitPatientPaymentOthersEntityDto.getId());
		}

		if (patientVisitPatientPaymentOthersEntityDto.getNotes() != null) {
			this.setNotes(patientVisitPatientPaymentOthersEntityDto.getNotes());
		}

		if (patientVisitPatientPaymentOthersEntityDto.getPatientVisit() != null) {
			this.setPatientVisit(patientVisitPatientPaymentOthersEntityDto.getPatientVisit());
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

	// % protected region % [Update the annotation for Patient Visit here] off begin
	@Schema(description = "The Patient Visit entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Visit here] end
	private PatientVisitEntity patientVisit;

	// % protected region % [Update the annotation for patientVisitId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_VISIT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientVisitId here] end
	private UUID patientVisitId;

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
	 * Similar to {@link this#setPatientVisit(PatientVisitEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setPatientVisit(PatientVisitEntity entity) {
		setPatientVisit(entity, true);
	}

	/**
	 * Set or update the patientVisit in this entity with single PatientVisitEntity.
	 *
	 * @param entity the given PatientVisitEntity to be set or updated to patientVisit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisit(PatientVisitEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] end

		if (sameAsFormer(this.patientVisit, entity)) {
			return;
		}

		if (this.patientVisit != null) {
			this.patientVisit.unsetPatientVisitPatientPaymentOthers(false);
		}

		this.patientVisit = entity;
		if (reverseAdd) {
			this.patientVisit.setPatientVisitPatientPaymentOthers(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientVisit(boolean)} but default to true.
	 */
	public void unsetPatientVisit() {
		this.unsetPatientVisit(true);
	}

	/**
	 * Remove the PatientVisitEntity of patientVisit from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientVisit(boolean reverse) {
		if (reverse && this.patientVisit != null) {
			this.patientVisit.unsetPatientVisitPatientPaymentOthers();
		}
		this.patientVisit = null;
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
		return "NOTES,PATIENT_VISIT_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<PatientVisitEntity> patientVisitRelation = Optional.ofNullable(this.patientVisit);
		patientVisitRelation.ifPresent(entity -> this.patientVisitId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object patientVisitPatientPaymentOthers) {
		if (this == patientVisitPatientPaymentOthers) {
			return true;
		}
		if (patientVisitPatientPaymentOthers == null || this.getClass() != patientVisitPatientPaymentOthers.getClass()) {
			return false;
		}
		if (!super.equals(patientVisitPatientPaymentOthers)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientVisitPatientPaymentOthersEntity that = (PatientVisitPatientPaymentOthersEntity) patientVisitPatientPaymentOthers;
		return
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.patientVisitId, that.patientVisitId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
