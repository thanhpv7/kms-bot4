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
import kmsweb.dtos.BpjsSEPSubmissionEntityDto;
import kmsweb.entities.listeners.BpjsSEPSubmissionEntityListener;
import kmsweb.serializers.BpjsSEPSubmissionSerializer;
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
@EntityListeners({BpjsSEPSubmissionEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsSEPSubmissionSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsSEPSubmissionEntity extends AbstractEntity {

	/**
	 * Takes a BpjsSEPSubmissionEntityDto and converts it into a BpjsSEPSubmissionEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsSEPSubmissionEntityDto
	 */
	public BpjsSEPSubmissionEntity(BpjsSEPSubmissionEntityDto bpjsSEPSubmissionEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsSEPSubmissionEntityDto.getId() != null) {
			this.setId(bpjsSEPSubmissionEntityDto.getId());
		}

		if (bpjsSEPSubmissionEntityDto.getStatus() != null) {
			this.setStatus(bpjsSEPSubmissionEntityDto.getStatus());
		}

		if (bpjsSEPSubmissionEntityDto.getSubmissionType() != null) {
			this.setSubmissionType(bpjsSEPSubmissionEntityDto.getSubmissionType());
		}

		if (bpjsSEPSubmissionEntityDto.getSepDate() != null) {
			this.setSepDate(bpjsSEPSubmissionEntityDto.getSepDate());
		}

		if (bpjsSEPSubmissionEntityDto.getTreatmentType() != null) {
			this.setTreatmentType(bpjsSEPSubmissionEntityDto.getTreatmentType());
		}

		if (bpjsSEPSubmissionEntityDto.getNotes() != null) {
			this.setNotes(bpjsSEPSubmissionEntityDto.getNotes());
		}

		if (bpjsSEPSubmissionEntityDto.getPatientPaymentBPJS() != null) {
			this.setPatientPaymentBPJS(bpjsSEPSubmissionEntityDto.getPatientPaymentBPJS());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Status here] off begin
	@CsvBindByName(column = "STATUS", required = false)
	@Nullable
	@Column(name = "status")
	@Schema(description = "The Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Status here] end
	private String status;

	// % protected region % [Modify attribute annotation for Submission Type here] off begin
	@CsvBindByName(column = "SUBMISSION_TYPE", required = false)
	@Nullable
	@Column(name = "submission_type")
	@Schema(description = "The Submission Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Submission Type here] end
	private String submissionType;

	// % protected region % [Modify attribute annotation for SEP Date here] off begin
	@CsvBindByName(column = "SEP_DATE", required = false)
	@Nullable
	@Column(name = "sep_date")
	@Schema(description = "The SEP Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SEP Date here] end
	private String sepDate;

	// % protected region % [Modify attribute annotation for Treatment Type here] off begin
	@CsvBindByName(column = "TREATMENT_TYPE", required = false)
	@Nullable
	@Column(name = "treatment_type")
	@Schema(description = "The Treatment Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Type here] end
	private String treatmentType;

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

	// % protected region % [Update the annotation for Patient Payment BPJS here] off begin
	@Schema(description = "The Patient Payment BPJS entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Payment BPJS here] end
	private PatientPaymentBPJSEntity patientPaymentBPJS;

	// % protected region % [Update the annotation for patientPaymentBPJSId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_PAYMENT_BPJS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientPaymentBPJSId here] end
	private UUID patientPaymentBPJSId;

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
	 * Similar to {@link this#setPatientPaymentBPJS(PatientPaymentBPJSEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientPaymentBPJSEntity to be set to this entity
	 */
	public void setPatientPaymentBPJS(@NotNull PatientPaymentBPJSEntity entity) {
		setPatientPaymentBPJS(entity, true);
	}

	/**
	 * Set or update the patientPaymentBPJS in this entity with single PatientPaymentBPJSEntity.
	 *
	 * @param entity the given PatientPaymentBPJSEntity to be set or updated to patientPaymentBPJS
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientPaymentBPJS(@NotNull PatientPaymentBPJSEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentBPJS here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentBPJS here] end

		if (sameAsFormer(this.patientPaymentBPJS, entity)) {
			return;
		}

		if (this.patientPaymentBPJS != null) {
			this.patientPaymentBPJS.removeBpjsSEPSubmissions(this, false);
		}
		this.patientPaymentBPJS = entity;
		if (reverseAdd) {
			this.patientPaymentBPJS.addBpjsSEPSubmissions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentBPJS incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentBPJS incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientPaymentBPJS(boolean)} but default to true.
	 */
	public void unsetPatientPaymentBPJS() {
		this.unsetPatientPaymentBPJS(true);
	}

	/**
	 * Remove Patient Payment BPJS in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientPaymentBPJS(boolean reverse) {
		if (reverse && this.patientPaymentBPJS != null) {
			this.patientPaymentBPJS.removeBpjsSEPSubmissions(this, false);
		}
		this.patientPaymentBPJS = null;
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
		return "STATUS,SUBMISSION_TYPE,SEP_DATE,TREATMENT_TYPE,NOTES,PATIENT_PAYMENT_BPJS_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<PatientPaymentBPJSEntity> patientPaymentBPJSRelation = Optional.ofNullable(this.patientPaymentBPJS);
		patientPaymentBPJSRelation.ifPresent(entity -> this.patientPaymentBPJSId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsSEPSubmission) {
		if (this == bpjsSEPSubmission) {
			return true;
		}
		if (bpjsSEPSubmission == null || this.getClass() != bpjsSEPSubmission.getClass()) {
			return false;
		}
		if (!super.equals(bpjsSEPSubmission)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsSEPSubmissionEntity that = (BpjsSEPSubmissionEntity) bpjsSEPSubmission;
		return
			Objects.equals(this.status, that.status) &&
			Objects.equals(this.submissionType, that.submissionType) &&
			Objects.equals(this.sepDate, that.sepDate) &&
			Objects.equals(this.treatmentType, that.treatmentType) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.patientPaymentBPJSId, that.patientPaymentBPJSId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
