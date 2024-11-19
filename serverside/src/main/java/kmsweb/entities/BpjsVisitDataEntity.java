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
import kmsweb.dtos.BpjsVisitDataEntityDto;
import kmsweb.entities.listeners.BpjsVisitDataEntityListener;
import kmsweb.serializers.BpjsVisitDataSerializer;
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
@EntityListeners({BpjsVisitDataEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsVisitDataSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsVisitDataEntity extends AbstractEntity {

	/**
	 * Takes a BpjsVisitDataEntityDto and converts it into a BpjsVisitDataEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsVisitDataEntityDto
	 */
	public BpjsVisitDataEntity(BpjsVisitDataEntityDto bpjsVisitDataEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsVisitDataEntityDto.getId() != null) {
			this.setId(bpjsVisitDataEntityDto.getId());
		}

		if (bpjsVisitDataEntityDto.getDiagnose() != null) {
			this.setDiagnose(bpjsVisitDataEntityDto.getDiagnose());
		}

		if (bpjsVisitDataEntityDto.getTreatmentType() != null) {
			this.setTreatmentType(bpjsVisitDataEntityDto.getTreatmentType());
		}

		if (bpjsVisitDataEntityDto.getTreatmentClass() != null) {
			this.setTreatmentClass(bpjsVisitDataEntityDto.getTreatmentClass());
		}

		if (bpjsVisitDataEntityDto.getName() != null) {
			this.setName(bpjsVisitDataEntityDto.getName());
		}

		if (bpjsVisitDataEntityDto.getBpjsCardNo() != null) {
			this.setBpjsCardNo(bpjsVisitDataEntityDto.getBpjsCardNo());
		}

		if (bpjsVisitDataEntityDto.getSepNo() != null) {
			this.setSepNo(bpjsVisitDataEntityDto.getSepNo());
		}

		if (bpjsVisitDataEntityDto.getReferralNo() != null) {
			this.setReferralNo(bpjsVisitDataEntityDto.getReferralNo());
		}

		if (bpjsVisitDataEntityDto.getPolyclinic() != null) {
			this.setPolyclinic(bpjsVisitDataEntityDto.getPolyclinic());
		}

		if (bpjsVisitDataEntityDto.getSepDate() != null) {
			this.setSepDate(bpjsVisitDataEntityDto.getSepDate());
		}

		if (bpjsVisitDataEntityDto.getSepDismissalDate() != null) {
			this.setSepDismissalDate(bpjsVisitDataEntityDto.getSepDismissalDate());
		}

		if (bpjsVisitDataEntityDto.getJsonInsert() != null) {
			this.setJsonInsert(bpjsVisitDataEntityDto.getJsonInsert());
		}

		if (bpjsVisitDataEntityDto.getJsonUpdate() != null) {
			this.setJsonUpdate(bpjsVisitDataEntityDto.getJsonUpdate());
		}

		if (bpjsVisitDataEntityDto.getPatientVisit() != null) {
			this.setPatientVisit(bpjsVisitDataEntityDto.getPatientVisit());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Diagnose here] off begin
	@CsvBindByName(column = "DIAGNOSE", required = false)
	@Nullable
	@Column(name = "diagnose")
	@Schema(description = "The Diagnose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diagnose here] end
	private String diagnose;

	// % protected region % [Modify attribute annotation for Treatment Type here] off begin
	@CsvBindByName(column = "TREATMENT_TYPE", required = false)
	@Nullable
	@Column(name = "treatment_type")
	@Schema(description = "The Treatment Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Type here] end
	private String treatmentType;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@CsvBindByName(column = "TREATMENT_CLASS", required = false)
	@Nullable
	@Column(name = "treatment_class")
	@Schema(description = "The Treatment Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for Name here] off begin
	@CsvBindByName(column = "NAME", required = false)
	@Nullable
	@Column(name = "name")
	@Schema(description = "The Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Name here] end
	private String name;

	// % protected region % [Modify attribute annotation for BPJS Card No here] off begin
	@CsvBindByName(column = "BPJS_CARD_NO", required = false)
	@Nullable
	@Column(name = "bpjs_card_no")
	@Schema(description = "The BPJS Card No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BPJS Card No here] end
	private String bpjsCardNo;

	// % protected region % [Modify attribute annotation for SEP No here] off begin
	@CsvBindByName(column = "SEP_NO", required = false)
	@Nullable
	@Column(name = "sep_no")
	@Schema(description = "The SEP No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SEP No here] end
	private String sepNo;

	// % protected region % [Modify attribute annotation for Referral No here] off begin
	@CsvBindByName(column = "REFERRAL_NO", required = false)
	@Nullable
	@Column(name = "referral_no")
	@Schema(description = "The Referral No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral No here] end
	private String referralNo;

	// % protected region % [Modify attribute annotation for Polyclinic here] off begin
	@CsvBindByName(column = "POLYCLINIC", required = false)
	@Nullable
	@Column(name = "polyclinic")
	@Schema(description = "The Polyclinic of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Polyclinic here] end
	private String polyclinic;

	// % protected region % [Modify attribute annotation for SEP Date here] off begin
	@CsvBindByName(column = "SEP_DATE", required = false)
	@Nullable
	@Column(name = "sep_date")
	@Schema(description = "The SEP Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SEP Date here] end
	private String sepDate;

	// % protected region % [Modify attribute annotation for SEP Dismissal Date here] off begin
	@CsvBindByName(column = "SEP_DISMISSAL_DATE", required = false)
	@Nullable
	@Column(name = "sep_dismissal_date")
	@Schema(description = "The SEP Dismissal Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SEP Dismissal Date here] end
	private String sepDismissalDate;

	// % protected region % [Modify attribute annotation for Json Insert here] off begin
	@CsvBindByName(column = "JSON_INSERT", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "json_insert")
	@Schema(description = "The Json Insert of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Json Insert here] end
	private String jsonInsert;

	// % protected region % [Modify attribute annotation for Json Update here] off begin
	@CsvBindByName(column = "JSON_UPDATE", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "json_update")
	@Schema(description = "The Json Update of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Json Update here] end
	private String jsonUpdate;

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
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
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
	public void setPatientVisit(@NotNull PatientVisitEntity entity) {
		setPatientVisit(entity, true);
	}

	/**
	 * Set or update the patientVisit in this entity with single PatientVisitEntity.
	 *
	 * @param entity the given PatientVisitEntity to be set or updated to patientVisit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisit(@NotNull PatientVisitEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] end

		if (sameAsFormer(this.patientVisit, entity)) {
			return;
		}

		if (this.patientVisit != null) {
			this.patientVisit.removeBpjsVisitDatas(this, false);
		}
		this.patientVisit = entity;
		if (reverseAdd) {
			this.patientVisit.addBpjsVisitDatas(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientVisit(boolean)} but default to true.
	 */
	public void unsetPatientVisit() {
		this.unsetPatientVisit(true);
	}

	/**
	 * Remove Patient Visit in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientVisit(boolean reverse) {
		if (reverse && this.patientVisit != null) {
			this.patientVisit.removeBpjsVisitDatas(this, false);
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
		return "DIAGNOSE,TREATMENT_TYPE,TREATMENT_CLASS,NAME,BPJS_CARD_NO,SEP_NO,REFERRAL_NO,POLYCLINIC,SEP_DATE,SEP_DISMISSAL_DATE,JSON_INSERT,JSON_UPDATE,PATIENT_VISIT_ID,ID";
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
	public boolean equals(Object bpjsVisitData) {
		if (this == bpjsVisitData) {
			return true;
		}
		if (bpjsVisitData == null || this.getClass() != bpjsVisitData.getClass()) {
			return false;
		}
		if (!super.equals(bpjsVisitData)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsVisitDataEntity that = (BpjsVisitDataEntity) bpjsVisitData;
		return
			Objects.equals(this.diagnose, that.diagnose) &&
			Objects.equals(this.treatmentType, that.treatmentType) &&
			Objects.equals(this.treatmentClass, that.treatmentClass) &&
			Objects.equals(this.name, that.name) &&
			Objects.equals(this.bpjsCardNo, that.bpjsCardNo) &&
			Objects.equals(this.sepNo, that.sepNo) &&
			Objects.equals(this.referralNo, that.referralNo) &&
			Objects.equals(this.polyclinic, that.polyclinic) &&
			Objects.equals(this.sepDate, that.sepDate) &&
			Objects.equals(this.sepDismissalDate, that.sepDismissalDate) &&
			Objects.equals(this.jsonInsert, that.jsonInsert) &&
			Objects.equals(this.jsonUpdate, that.jsonUpdate) &&
			Objects.equals(this.patientVisitId, that.patientVisitId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
