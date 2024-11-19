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
import kmsweb.dtos.BpjsSEPINACBGIntegrationEntityDto;
import kmsweb.entities.listeners.BpjsSEPINACBGIntegrationEntityListener;
import kmsweb.serializers.BpjsSEPINACBGIntegrationSerializer;
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
@EntityListeners({BpjsSEPINACBGIntegrationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsSEPINACBGIntegrationSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsSEPINACBGIntegrationEntity extends AbstractEntity {

	/**
	 * Takes a BpjsSEPINACBGIntegrationEntityDto and converts it into a BpjsSEPINACBGIntegrationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsSEPINACBGIntegrationEntityDto
	 */
	public BpjsSEPINACBGIntegrationEntity(BpjsSEPINACBGIntegrationEntityDto bpjsSEPINACBGIntegrationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsSEPINACBGIntegrationEntityDto.getId() != null) {
			this.setId(bpjsSEPINACBGIntegrationEntityDto.getId());
		}

		if (bpjsSEPINACBGIntegrationEntityDto.getSepNo() != null) {
			this.setSepNo(bpjsSEPINACBGIntegrationEntityDto.getSepNo());
		}

		if (bpjsSEPINACBGIntegrationEntityDto.getPatientID() != null) {
			this.setPatientID(bpjsSEPINACBGIntegrationEntityDto.getPatientID());
		}

		if (bpjsSEPINACBGIntegrationEntityDto.getPatientName() != null) {
			this.setPatientName(bpjsSEPINACBGIntegrationEntityDto.getPatientName());
		}

		if (bpjsSEPINACBGIntegrationEntityDto.getGender() != null) {
			this.setGender(bpjsSEPINACBGIntegrationEntityDto.getGender());
		}

		if (bpjsSEPINACBGIntegrationEntityDto.getBpjsCardNo() != null) {
			this.setBpjsCardNo(bpjsSEPINACBGIntegrationEntityDto.getBpjsCardNo());
		}

		if (bpjsSEPINACBGIntegrationEntityDto.getTreatmentClass() != null) {
			this.setTreatmentClass(bpjsSEPINACBGIntegrationEntityDto.getTreatmentClass());
		}

		if (bpjsSEPINACBGIntegrationEntityDto.getReferralNo() != null) {
			this.setReferralNo(bpjsSEPINACBGIntegrationEntityDto.getReferralNo());
		}

		if (bpjsSEPINACBGIntegrationEntityDto.getDateOfBirth() != null) {
			this.setDateOfBirth(bpjsSEPINACBGIntegrationEntityDto.getDateOfBirth());
		}

		if (bpjsSEPINACBGIntegrationEntityDto.getVisitDate() != null) {
			this.setVisitDate(bpjsSEPINACBGIntegrationEntityDto.getVisitDate());
		}

		if (bpjsSEPINACBGIntegrationEntityDto.getHealthFacilityLevel() != null) {
			this.setHealthFacilityLevel(bpjsSEPINACBGIntegrationEntityDto.getHealthFacilityLevel());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for SEP No here] off begin
	@CsvBindByName(column = "SEP_NO", required = false)
	@Nullable
	@Column(name = "sep_no")
	@Schema(description = "The SEP No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SEP No here] end
	private String sepNo;

	// % protected region % [Modify attribute annotation for Patient ID here] off begin
	@CsvBindByName(column = "PATIENT_ID", required = false)
	@Nullable
	@Column(name = "patient_id")
	@Schema(description = "The Patient ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient ID here] end
	private String patientID;

	// % protected region % [Modify attribute annotation for Patient Name here] off begin
	@CsvBindByName(column = "PATIENT_NAME", required = false)
	@Nullable
	@Column(name = "patient_name")
	@Schema(description = "The Patient Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient Name here] end
	private String patientName;

	// % protected region % [Modify attribute annotation for Gender here] off begin
	@CsvBindByName(column = "GENDER", required = false)
	@Nullable
	@Column(name = "gender")
	@Schema(description = "The Gender of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gender here] end
	private String gender;

	// % protected region % [Modify attribute annotation for BPJS Card No here] off begin
	@CsvBindByName(column = "BPJS_CARD_NO", required = false)
	@Nullable
	@Column(name = "bpjs_card_no")
	@Schema(description = "The BPJS Card No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BPJS Card No here] end
	private String bpjsCardNo;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@CsvBindByName(column = "TREATMENT_CLASS", required = false)
	@Nullable
	@Column(name = "treatment_class")
	@Schema(description = "The Treatment Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for Referral No here] off begin
	@CsvBindByName(column = "REFERRAL_NO", required = false)
	@Nullable
	@Column(name = "referral_no")
	@Schema(description = "The Referral No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral No here] end
	private String referralNo;

	// % protected region % [Modify attribute annotation for Date of Birth here] off begin
	@CsvBindByName(column = "DATE_OF_BIRTH", required = false)
	@Nullable
	@Column(name = "date_of_birth")
	@Schema(description = "The Date of Birth of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Date of Birth here] end
	private String dateOfBirth;

	// % protected region % [Modify attribute annotation for Visit Date here] off begin
	@CsvBindByName(column = "VISIT_DATE", required = false)
	@Nullable
	@Column(name = "visit_date")
	@Schema(description = "The Visit Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Visit Date here] end
	private String visitDate;

	// % protected region % [Modify attribute annotation for Health Facility Level here] off begin
	@CsvBindByName(column = "HEALTH_FACILITY_LEVEL", required = false)
	@Nullable
	@Column(name = "health_facility_level")
	@Schema(description = "The Health Facility Level of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Health Facility Level here] end
	private String healthFacilityLevel;

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
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "SEP_NO,PATIENT_ID,PATIENT_NAME,GENDER,BPJS_CARD_NO,TREATMENT_CLASS,REFERRAL_NO,DATE_OF_BIRTH,VISIT_DATE,HEALTH_FACILITY_LEVEL,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsSEPINACBGIntegration) {
		if (this == bpjsSEPINACBGIntegration) {
			return true;
		}
		if (bpjsSEPINACBGIntegration == null || this.getClass() != bpjsSEPINACBGIntegration.getClass()) {
			return false;
		}
		if (!super.equals(bpjsSEPINACBGIntegration)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsSEPINACBGIntegrationEntity that = (BpjsSEPINACBGIntegrationEntity) bpjsSEPINACBGIntegration;
		return
			Objects.equals(this.sepNo, that.sepNo) &&
			Objects.equals(this.patientID, that.patientID) &&
			Objects.equals(this.patientName, that.patientName) &&
			Objects.equals(this.gender, that.gender) &&
			Objects.equals(this.bpjsCardNo, that.bpjsCardNo) &&
			Objects.equals(this.treatmentClass, that.treatmentClass) &&
			Objects.equals(this.referralNo, that.referralNo) &&
			Objects.equals(this.dateOfBirth, that.dateOfBirth) &&
			Objects.equals(this.visitDate, that.visitDate) &&
			Objects.equals(this.healthFacilityLevel, that.healthFacilityLevel);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
