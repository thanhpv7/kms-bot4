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
import kmsweb.dtos.DiagnosticExaminationResultsEntityDto;
import kmsweb.entities.listeners.DiagnosticExaminationResultsEntityListener;
import kmsweb.serializers.DiagnosticExaminationResultsSerializer;
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
@EntityListeners({DiagnosticExaminationResultsEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = DiagnosticExaminationResultsSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class DiagnosticExaminationResultsEntity extends AbstractEntity {

	/**
	 * Takes a DiagnosticExaminationResultsEntityDto and converts it into a DiagnosticExaminationResultsEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param diagnosticExaminationResultsEntityDto
	 */
	public DiagnosticExaminationResultsEntity(DiagnosticExaminationResultsEntityDto diagnosticExaminationResultsEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (diagnosticExaminationResultsEntityDto.getId() != null) {
			this.setId(diagnosticExaminationResultsEntityDto.getId());
		}

		if (diagnosticExaminationResultsEntityDto.getResult() != null) {
			this.setResult(diagnosticExaminationResultsEntityDto.getResult());
		}

		if (diagnosticExaminationResultsEntityDto.getOutsideRange() != null) {
			this.setOutsideRange(diagnosticExaminationResultsEntityDto.getOutsideRange());
		}

		if (diagnosticExaminationResultsEntityDto.getLow() != null) {
			this.setLow(diagnosticExaminationResultsEntityDto.getLow());
		}

		if (diagnosticExaminationResultsEntityDto.getHigh() != null) {
			this.setHigh(diagnosticExaminationResultsEntityDto.getHigh());
		}

		if (diagnosticExaminationResultsEntityDto.getUnit() != null) {
			this.setUnit(diagnosticExaminationResultsEntityDto.getUnit());
		}

		if (diagnosticExaminationResultsEntityDto.getSampleNo() != null) {
			this.setSampleNo(diagnosticExaminationResultsEntityDto.getSampleNo());
		}

		if (diagnosticExaminationResultsEntityDto.getSampleType() != null) {
			this.setSampleType(diagnosticExaminationResultsEntityDto.getSampleType());
		}

		if (diagnosticExaminationResultsEntityDto.getRepeated() != null) {
			this.setRepeated(diagnosticExaminationResultsEntityDto.getRepeated());
		}

		if (diagnosticExaminationResultsEntityDto.getStatus() != null) {
			this.setStatus(diagnosticExaminationResultsEntityDto.getStatus());
		}

		if (diagnosticExaminationResultsEntityDto.getExaminationItem() != null) {
			this.setExaminationItem(diagnosticExaminationResultsEntityDto.getExaminationItem());
		}

		if (diagnosticExaminationResultsEntityDto.getRegistration() != null) {
			this.setRegistration(diagnosticExaminationResultsEntityDto.getRegistration());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Result here] off begin
	@CsvBindByName(column = "RESULT", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 1000", max = 1000)
	@Column(name = "result")
	@Schema(description = "The Result of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Result here] end
	private String result;

	// % protected region % [Modify attribute annotation for Outside Range here] off begin
	@CsvBindByName(column = "OUTSIDE_RANGE", required = false)
	@Nullable
	@Column(name = "outside_range")
	@Schema(description = "The Outside Range of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Outside Range here] end
	private Boolean outsideRange = false ;

	// % protected region % [Modify attribute annotation for Low here] off begin
	@CsvBindByName(column = "LOW", required = false)
	@Nullable
	@Column(name = "low")
	@Schema(description = "The Low of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Low here] end
	private Double low;

	// % protected region % [Modify attribute annotation for High here] off begin
	@CsvBindByName(column = "HIGH", required = false)
	@Nullable
	@Column(name = "high")
	@Schema(description = "The High of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for High here] end
	private Double high;

	// % protected region % [Modify attribute annotation for Unit here] off begin
	@CsvBindByName(column = "UNIT", required = false)
	@Nullable
	@Column(name = "unit")
	@Schema(description = "The Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Unit here] end
	private String unit;

	// % protected region % [Modify attribute annotation for Sample No here] off begin
	@CsvBindByName(column = "SAMPLE_NO", required = false)
	@Nullable
	@Column(name = "sample_no")
	@Schema(description = "The Sample No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sample No here] end
	private String sampleNo;

	// % protected region % [Modify attribute annotation for Sample Type here] off begin
	@CsvBindByName(column = "SAMPLE_TYPE", required = false)
	@Nullable
	@Column(name = "sample_type")
	@Schema(description = "The Sample Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sample Type here] end
	private String sampleType;

	// % protected region % [Modify attribute annotation for repeated here] off begin
	@CsvBindByName(column = "REPEATED", required = false)
	@Nullable
	@Column(name = "repeated")
	@Schema(description = "The repeated of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for repeated here] end
	private Boolean repeated = false ;

	// % protected region % [Modify attribute annotation for status here] off begin
	@CsvBindByName(column = "STATUS", required = false)
	@Nullable
	@Column(name = "status")
	@Schema(description = "The status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for status here] end
	private String status;

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

	// % protected region % [Update the annotation for Examination Item here] off begin
	@Schema(description = "The Examination Item entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Examination Item here] end
	private ExaminationItemEntity examinationItem;

	// % protected region % [Update the annotation for examinationItemId here] off begin
	@Transient
	@CsvCustomBindByName(column = "EXAMINATION_ITEM_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for examinationItemId here] end
	private UUID examinationItemId;

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
	 * Similar to {@link this#setExaminationItem(ExaminationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationItemEntity to be set to this entity
	 */
	public void setExaminationItem(@NotNull ExaminationItemEntity entity) {
		setExaminationItem(entity, true);
	}

	/**
	 * Set or update the examinationItem in this entity with single ExaminationItemEntity.
	 *
	 * @param entity the given ExaminationItemEntity to be set or updated to examinationItem
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setExaminationItem(@NotNull ExaminationItemEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setExaminationItem here] off begin
		// % protected region % [Add any additional logic here before the main logic for setExaminationItem here] end

		if (sameAsFormer(this.examinationItem, entity)) {
			return;
		}

		if (this.examinationItem != null) {
			this.examinationItem.removeDiagnosticExaminationResults(this, false);
		}
		this.examinationItem = entity;
		if (reverseAdd) {
			this.examinationItem.addDiagnosticExaminationResults(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setExaminationItem incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setExaminationItem incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetExaminationItem(boolean)} but default to true.
	 */
	public void unsetExaminationItem() {
		this.unsetExaminationItem(true);
	}

	/**
	 * Remove Examination Item in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetExaminationItem(boolean reverse) {
		if (reverse && this.examinationItem != null) {
			this.examinationItem.removeDiagnosticExaminationResults(this, false);
		}
		this.examinationItem = null;
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
			this.registration.removeDiagnosticExaminationResults(this, false);
		}
		this.registration = entity;
		if (reverseAdd) {
			this.registration.addDiagnosticExaminationResults(this, false);
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
			this.registration.removeDiagnosticExaminationResults(this, false);
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
		return "RESULT,OUTSIDE_RANGE,LOW,HIGH,UNIT,SAMPLE_NO,SAMPLE_TYPE,REPEATED,STATUS,EXAMINATION_ITEM_ID,REGISTRATION_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<ExaminationItemEntity> examinationItemRelation = Optional.ofNullable(this.examinationItem);
		examinationItemRelation.ifPresent(entity -> this.examinationItemId = entity.getId());

		Optional<RegistrationEntity> registrationRelation = Optional.ofNullable(this.registration);
		registrationRelation.ifPresent(entity -> this.registrationId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object diagnosticExaminationResults) {
		if (this == diagnosticExaminationResults) {
			return true;
		}
		if (diagnosticExaminationResults == null || this.getClass() != diagnosticExaminationResults.getClass()) {
			return false;
		}
		if (!super.equals(diagnosticExaminationResults)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		DiagnosticExaminationResultsEntity that = (DiagnosticExaminationResultsEntity) diagnosticExaminationResults;
		return
			Objects.equals(this.result, that.result) &&
			Objects.equals(this.outsideRange, that.outsideRange) &&
			Objects.equals(this.low, that.low) &&
			Objects.equals(this.high, that.high) &&
			Objects.equals(this.unit, that.unit) &&
			Objects.equals(this.sampleNo, that.sampleNo) &&
			Objects.equals(this.sampleType, that.sampleType) &&
			Objects.equals(this.repeated, that.repeated) &&
			Objects.equals(this.status, that.status) &&
			Objects.equals(this.examinationItemId, that.examinationItemId) &&
			Objects.equals(this.registrationId, that.registrationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
