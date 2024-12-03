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
import kmsweb.dtos.Icd10EntityDto;
import kmsweb.entities.listeners.Icd10EntityListener;
import kmsweb.serializers.Icd10Serializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.deserializers.DateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import java.time.*;
import java.time.temporal.ChronoUnit;
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
@EntityListeners({Icd10EntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = Icd10Serializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class Icd10Entity extends AbstractEntity {

	/**
	 * Takes a Icd10EntityDto and converts it into a Icd10Entity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param icd10EntityDto
	 */
	public Icd10Entity(Icd10EntityDto icd10EntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (icd10EntityDto.getId() != null) {
			this.setId(icd10EntityDto.getId());
		}

		if (icd10EntityDto.getClassificationDisease() != null) {
			this.setClassificationDisease(icd10EntityDto.getClassificationDisease());
		}

		if (icd10EntityDto.getClassificationInfectious() != null) {
			this.setClassificationInfectious(icd10EntityDto.getClassificationInfectious());
		}

		if (icd10EntityDto.getClassificationChronic() != null) {
			this.setClassificationChronic(icd10EntityDto.getClassificationChronic());
		}

		if (icd10EntityDto.getClassificationTopDisease() != null) {
			this.setClassificationTopDisease(icd10EntityDto.getClassificationTopDisease());
		}

		if (icd10EntityDto.getClassificationRestrictedCase() != null) {
			this.setClassificationRestrictedCase(icd10EntityDto.getClassificationRestrictedCase());
		}

		if (icd10EntityDto.getClassificationReportableCase() != null) {
			this.setClassificationReportableCase(icd10EntityDto.getClassificationReportableCase());
		}

		if (icd10EntityDto.getClassificationAcute() != null) {
			this.setClassificationAcute(icd10EntityDto.getClassificationAcute());
		}

		if (icd10EntityDto.getDismissalDate() != null) {
			this.setDismissalDate(icd10EntityDto.getDismissalDate());
		}

		if (icd10EntityDto.getDiagnosesAndProcedures() != null) {
			this.setDiagnosesAndProcedures(icd10EntityDto.getDiagnosesAndProcedures());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Classification Disease here] off begin
	@CsvBindByName(column = "CLASSIFICATION_DISEASE", required = false)
	@Nullable
	@Column(name = "classification_disease")
	@Schema(description = "The Classification Disease of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Classification Disease here] end
	private Boolean classificationDisease = false ;

	// % protected region % [Modify attribute annotation for Classification Infectious here] off begin
	@CsvBindByName(column = "CLASSIFICATION_INFECTIOUS", required = false)
	@Nullable
	@Column(name = "classification_infectious")
	@Schema(description = "The Classification Infectious of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Classification Infectious here] end
	private Boolean classificationInfectious = false ;

	// % protected region % [Modify attribute annotation for Classification Chronic here] off begin
	@CsvBindByName(column = "CLASSIFICATION_CHRONIC", required = false)
	@Nullable
	@Column(name = "classification_chronic")
	@Schema(description = "The Classification Chronic of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Classification Chronic here] end
	private Boolean classificationChronic = false ;

	// % protected region % [Modify attribute annotation for Classification Top Disease here] off begin
	@CsvBindByName(column = "CLASSIFICATION_TOP_DISEASE", required = false)
	@Nullable
	@Column(name = "classification_top_disease")
	@Schema(description = "The Classification Top Disease of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Classification Top Disease here] end
	private Boolean classificationTopDisease = false ;

	// % protected region % [Modify attribute annotation for Classification Restricted Case here] off begin
	@CsvBindByName(column = "CLASSIFICATION_RESTRICTED_CASE", required = false)
	@Nullable
	@Column(name = "classification_restricted_case")
	@Schema(description = "The Classification Restricted Case of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Classification Restricted Case here] end
	private Boolean classificationRestrictedCase = false ;

	// % protected region % [Modify attribute annotation for Classification Reportable Case here] off begin
	@CsvBindByName(column = "CLASSIFICATION_REPORTABLE_CASE", required = false)
	@Nullable
	@Column(name = "classification_reportable_case")
	@Schema(description = "The Classification Reportable Case of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Classification Reportable Case here] end
	private Boolean classificationReportableCase = false ;

	// % protected region % [Modify attribute annotation for Classification Acute here] off begin
	@CsvBindByName(column = "CLASSIFICATION_ACUTE", required = false)
	@Nullable
	@Column(name = "classification_acute")
	@Schema(description = "The Classification Acute of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Classification Acute here] end
	private Boolean classificationAcute = false ;

	// % protected region % [Modify attribute annotation for Dismissal Date here] off begin

	@CsvCustomBindByName(column = "DISMISSAL_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "dismissal_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Dismissal Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dismissal Date here] end
	private OffsetDateTime dismissalDate;

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

	// % protected region % [Update the annotation for Diagnoses and Procedures here] off begin
	@Schema(description = "The Diagnoses and Procedures entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Diagnoses and Procedures here] end
	private DiagnosesAndProceduresEntity diagnosesAndProcedures;

	// % protected region % [Update the annotation for diagnosesAndProceduresId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DIAGNOSES_AND_PROCEDURES_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for diagnosesAndProceduresId here] end
	private UUID diagnosesAndProceduresId;

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
	 * Similar to {@link this#setDiagnosesAndProcedures(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setDiagnosesAndProcedures(DiagnosesAndProceduresEntity entity) {
		setDiagnosesAndProcedures(entity, true);
	}

	/**
	 * Set or update the diagnosesAndProcedures in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to diagnosesAndProcedures
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDiagnosesAndProcedures(DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDiagnosesAndProcedures here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDiagnosesAndProcedures here] end

		if (sameAsFormer(this.diagnosesAndProcedures, entity)) {
			return;
		}

		if (this.diagnosesAndProcedures != null) {
			this.diagnosesAndProcedures.unsetMasterICD10(false);
		}

		this.diagnosesAndProcedures = entity;
		if (reverseAdd) {
			this.diagnosesAndProcedures.setMasterICD10(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDiagnosesAndProcedures incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDiagnosesAndProcedures incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDiagnosesAndProcedures(boolean)} but default to true.
	 */
	public void unsetDiagnosesAndProcedures() {
		this.unsetDiagnosesAndProcedures(true);
	}

	/**
	 * Remove the DiagnosesAndProceduresEntity of diagnosesAndProcedures from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDiagnosesAndProcedures(boolean reverse) {
		if (reverse && this.diagnosesAndProcedures != null) {
			this.diagnosesAndProcedures.unsetMasterICD10();
		}
		this.diagnosesAndProcedures = null;
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
		return "CLASSIFICATION_DISEASE,CLASSIFICATION_INFECTIOUS,CLASSIFICATION_CHRONIC,CLASSIFICATION_TOP_DISEASE,CLASSIFICATION_RESTRICTED_CASE,CLASSIFICATION_REPORTABLE_CASE,CLASSIFICATION_ACUTE,DISMISSAL_DATE,DIAGNOSES_AND_PROCEDURES_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<DiagnosesAndProceduresEntity> diagnosesAndProceduresRelation = Optional.ofNullable(this.diagnosesAndProcedures);
		diagnosesAndProceduresRelation.ifPresent(entity -> this.diagnosesAndProceduresId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object icd10) {
		if (this == icd10) {
			return true;
		}
		if (icd10 == null || this.getClass() != icd10.getClass()) {
			return false;
		}
		if (!super.equals(icd10)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		Icd10Entity that = (Icd10Entity) icd10;
		return
			Objects.equals(this.classificationDisease, that.classificationDisease) &&
			Objects.equals(this.classificationInfectious, that.classificationInfectious) &&
			Objects.equals(this.classificationChronic, that.classificationChronic) &&
			Objects.equals(this.classificationTopDisease, that.classificationTopDisease) &&
			Objects.equals(this.classificationRestrictedCase, that.classificationRestrictedCase) &&
			Objects.equals(this.classificationReportableCase, that.classificationReportableCase) &&
			Objects.equals(this.classificationAcute, that.classificationAcute) &&
			Objects.equals(
			     this.dismissalDate != null ? this.dismissalDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.dismissalDate != null ? that.dismissalDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.diagnosesAndProceduresId, that.diagnosesAndProceduresId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
