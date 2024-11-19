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
import kmsweb.dtos.BpjsSearchControlLetterEntityDto;
import kmsweb.entities.listeners.BpjsSearchControlLetterEntityListener;
import kmsweb.serializers.BpjsSearchControlLetterSerializer;
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
@EntityListeners({BpjsSearchControlLetterEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsSearchControlLetterSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsSearchControlLetterEntity extends AbstractEntity {

	/**
	 * Takes a BpjsSearchControlLetterEntityDto and converts it into a BpjsSearchControlLetterEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsSearchControlLetterEntityDto
	 */
	public BpjsSearchControlLetterEntity(BpjsSearchControlLetterEntityDto bpjsSearchControlLetterEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsSearchControlLetterEntityDto.getId() != null) {
			this.setId(bpjsSearchControlLetterEntityDto.getId());
		}

		if (bpjsSearchControlLetterEntityDto.getControlLetterNo() != null) {
			this.setControlLetterNo(bpjsSearchControlLetterEntityDto.getControlLetterNo());
		}

		if (bpjsSearchControlLetterEntityDto.getControlPlanDate() != null) {
			this.setControlPlanDate(bpjsSearchControlLetterEntityDto.getControlPlanDate());
		}

		if (bpjsSearchControlLetterEntityDto.getDate() != null) {
			this.setDate(bpjsSearchControlLetterEntityDto.getDate());
		}

		if (bpjsSearchControlLetterEntityDto.getControlType() != null) {
			this.setControlType(bpjsSearchControlLetterEntityDto.getControlType());
		}

		if (bpjsSearchControlLetterEntityDto.getPolyclinic() != null) {
			this.setPolyclinic(bpjsSearchControlLetterEntityDto.getPolyclinic());
		}

		if (bpjsSearchControlLetterEntityDto.getDoctor() != null) {
			this.setDoctor(bpjsSearchControlLetterEntityDto.getDoctor());
		}

		if (bpjsSearchControlLetterEntityDto.getSepNo() != null) {
			this.setSepNo(bpjsSearchControlLetterEntityDto.getSepNo());
		}

		if (bpjsSearchControlLetterEntityDto.getBpjsCardNo() != null) {
			this.setBpjsCardNo(bpjsSearchControlLetterEntityDto.getBpjsCardNo());
		}

		if (bpjsSearchControlLetterEntityDto.getPolyclinicDestination() != null) {
			this.setPolyclinicDestination(bpjsSearchControlLetterEntityDto.getPolyclinicDestination());
		}

		if (bpjsSearchControlLetterEntityDto.getDoctorDestination() != null) {
			this.setDoctorDestination(bpjsSearchControlLetterEntityDto.getDoctorDestination());
		}

		if (bpjsSearchControlLetterEntityDto.getPolyclinicSource() != null) {
			this.setPolyclinicSource(bpjsSearchControlLetterEntityDto.getPolyclinicSource());
		}

		if (bpjsSearchControlLetterEntityDto.getDoctorSource() != null) {
			this.setDoctorSource(bpjsSearchControlLetterEntityDto.getDoctorSource());
		}

		if (bpjsSearchControlLetterEntityDto.getSepDate() != null) {
			this.setSepDate(bpjsSearchControlLetterEntityDto.getSepDate());
		}

		if (bpjsSearchControlLetterEntityDto.getTreatmentType() != null) {
			this.setTreatmentType(bpjsSearchControlLetterEntityDto.getTreatmentType());
		}

		if (bpjsSearchControlLetterEntityDto.getTreatmentClass() != null) {
			this.setTreatmentClass(bpjsSearchControlLetterEntityDto.getTreatmentClass());
		}

		if (bpjsSearchControlLetterEntityDto.getName() != null) {
			this.setName(bpjsSearchControlLetterEntityDto.getName());
		}

		if (bpjsSearchControlLetterEntityDto.getGender() != null) {
			this.setGender(bpjsSearchControlLetterEntityDto.getGender());
		}

		if (bpjsSearchControlLetterEntityDto.getDateOfBirth() != null) {
			this.setDateOfBirth(bpjsSearchControlLetterEntityDto.getDateOfBirth());
		}

		if (bpjsSearchControlLetterEntityDto.getProvider() != null) {
			this.setProvider(bpjsSearchControlLetterEntityDto.getProvider());
		}

		if (bpjsSearchControlLetterEntityDto.getReferralProvider() != null) {
			this.setReferralProvider(bpjsSearchControlLetterEntityDto.getReferralProvider());
		}

		if (bpjsSearchControlLetterEntityDto.getReferralSource() != null) {
			this.setReferralSource(bpjsSearchControlLetterEntityDto.getReferralSource());
		}

		if (bpjsSearchControlLetterEntityDto.getReferralNo() != null) {
			this.setReferralNo(bpjsSearchControlLetterEntityDto.getReferralNo());
		}

		if (bpjsSearchControlLetterEntityDto.getReferralDate() != null) {
			this.setReferralDate(bpjsSearchControlLetterEntityDto.getReferralDate());
		}

		if (bpjsSearchControlLetterEntityDto.getDiagnose() != null) {
			this.setDiagnose(bpjsSearchControlLetterEntityDto.getDiagnose());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Control Letter No here] off begin
	@CsvBindByName(column = "CONTROL_LETTER_NO", required = false)
	@Nullable
	@Column(name = "control_letter_no")
	@Schema(description = "The Control Letter No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Control Letter No here] end
	private String controlLetterNo;

	// % protected region % [Modify attribute annotation for Control Plan Date here] off begin
	@CsvBindByName(column = "CONTROL_PLAN_DATE", required = false)
	@Nullable
	@Column(name = "control_plan_date")
	@Schema(description = "The Control Plan Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Control Plan Date here] end
	private String controlPlanDate;

	// % protected region % [Modify attribute annotation for Date here] off begin
	@CsvBindByName(column = "DATE", required = false)
	@Nullable
	@Column(name = "date")
	@Schema(description = "The Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Date here] end
	private String date;

	// % protected region % [Modify attribute annotation for Control Type here] off begin
	@CsvBindByName(column = "CONTROL_TYPE", required = false)
	@Nullable
	@Column(name = "control_type")
	@Schema(description = "The Control Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Control Type here] end
	private String controlType;

	// % protected region % [Modify attribute annotation for Polyclinic here] off begin
	@CsvBindByName(column = "POLYCLINIC", required = false)
	@Nullable
	@Column(name = "polyclinic")
	@Schema(description = "The Polyclinic of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Polyclinic here] end
	private String polyclinic;

	// % protected region % [Modify attribute annotation for Doctor here] off begin
	@CsvBindByName(column = "DOCTOR", required = false)
	@Nullable
	@Column(name = "doctor")
	@Schema(description = "The Doctor of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor here] end
	private String doctor;

	// % protected region % [Modify attribute annotation for SEP No here] off begin
	@CsvBindByName(column = "SEP_NO", required = false)
	@Nullable
	@Column(name = "sep_no")
	@Schema(description = "The SEP No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SEP No here] end
	private String sepNo;

	// % protected region % [Modify attribute annotation for BPJS Card No here] off begin
	@CsvBindByName(column = "BPJS_CARD_NO", required = false)
	@Nullable
	@Column(name = "bpjs_card_no")
	@Schema(description = "The BPJS Card No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BPJS Card No here] end
	private String bpjsCardNo;

	// % protected region % [Modify attribute annotation for Polyclinic Destination here] off begin
	@CsvBindByName(column = "POLYCLINIC_DESTINATION", required = false)
	@Nullable
	@Column(name = "polyclinic_destination")
	@Schema(description = "The Polyclinic Destination of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Polyclinic Destination here] end
	private String polyclinicDestination;

	// % protected region % [Modify attribute annotation for Doctor Destination here] off begin
	@CsvBindByName(column = "DOCTOR_DESTINATION", required = false)
	@Nullable
	@Column(name = "doctor_destination")
	@Schema(description = "The Doctor Destination of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor Destination here] end
	private String doctorDestination;

	// % protected region % [Modify attribute annotation for Polyclinic Source here] off begin
	@CsvBindByName(column = "POLYCLINIC_SOURCE", required = false)
	@Nullable
	@Column(name = "polyclinic_source")
	@Schema(description = "The Polyclinic Source of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Polyclinic Source here] end
	private String polyclinicSource;

	// % protected region % [Modify attribute annotation for Doctor Source here] off begin
	@CsvBindByName(column = "DOCTOR_SOURCE", required = false)
	@Nullable
	@Column(name = "doctor_source")
	@Schema(description = "The Doctor Source of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor Source here] end
	private String doctorSource;

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

	// % protected region % [Modify attribute annotation for Gender here] off begin
	@CsvBindByName(column = "GENDER", required = false)
	@Nullable
	@Column(name = "gender")
	@Schema(description = "The Gender of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gender here] end
	private String gender;

	// % protected region % [Modify attribute annotation for Date of Birth here] off begin
	@CsvBindByName(column = "DATE_OF_BIRTH", required = false)
	@Nullable
	@Column(name = "date_of_birth")
	@Schema(description = "The Date of Birth of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Date of Birth here] end
	private String dateOfBirth;

	// % protected region % [Modify attribute annotation for Provider here] off begin
	@CsvBindByName(column = "PROVIDER", required = false)
	@Nullable
	@Column(name = "provider")
	@Schema(description = "The Provider of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Provider here] end
	private String provider;

	// % protected region % [Modify attribute annotation for Referral Provider here] off begin
	@CsvBindByName(column = "REFERRAL_PROVIDER", required = false)
	@Nullable
	@Column(name = "referral_provider")
	@Schema(description = "The Referral Provider of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral Provider here] end
	private String referralProvider;

	// % protected region % [Modify attribute annotation for Referral Source here] off begin
	@CsvBindByName(column = "REFERRAL_SOURCE", required = false)
	@Nullable
	@Column(name = "referral_source")
	@Schema(description = "The Referral Source of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral Source here] end
	private String referralSource;

	// % protected region % [Modify attribute annotation for Referral No here] off begin
	@CsvBindByName(column = "REFERRAL_NO", required = false)
	@Nullable
	@Column(name = "referral_no")
	@Schema(description = "The Referral No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral No here] end
	private String referralNo;

	// % protected region % [Modify attribute annotation for Referral Date here] off begin
	@CsvBindByName(column = "REFERRAL_DATE", required = false)
	@Nullable
	@Column(name = "referral_date")
	@Schema(description = "The Referral Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral Date here] end
	private String referralDate;

	// % protected region % [Modify attribute annotation for Diagnose here] off begin
	@CsvBindByName(column = "DIAGNOSE", required = false)
	@Nullable
	@Column(name = "diagnose")
	@Schema(description = "The Diagnose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diagnose here] end
	private String diagnose;

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
		return "CONTROL_LETTER_NO,CONTROL_PLAN_DATE,DATE,CONTROL_TYPE,POLYCLINIC,DOCTOR,SEP_NO,BPJS_CARD_NO,POLYCLINIC_DESTINATION,DOCTOR_DESTINATION,POLYCLINIC_SOURCE,DOCTOR_SOURCE,SEP_DATE,TREATMENT_TYPE,TREATMENT_CLASS,NAME,GENDER,DATE_OF_BIRTH,PROVIDER,REFERRAL_PROVIDER,REFERRAL_SOURCE,REFERRAL_NO,REFERRAL_DATE,DIAGNOSE,ID";
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
	public boolean equals(Object bpjsSearchControlLetter) {
		if (this == bpjsSearchControlLetter) {
			return true;
		}
		if (bpjsSearchControlLetter == null || this.getClass() != bpjsSearchControlLetter.getClass()) {
			return false;
		}
		if (!super.equals(bpjsSearchControlLetter)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsSearchControlLetterEntity that = (BpjsSearchControlLetterEntity) bpjsSearchControlLetter;
		return
			Objects.equals(this.controlLetterNo, that.controlLetterNo) &&
			Objects.equals(this.controlPlanDate, that.controlPlanDate) &&
			Objects.equals(this.date, that.date) &&
			Objects.equals(this.controlType, that.controlType) &&
			Objects.equals(this.polyclinic, that.polyclinic) &&
			Objects.equals(this.doctor, that.doctor) &&
			Objects.equals(this.sepNo, that.sepNo) &&
			Objects.equals(this.bpjsCardNo, that.bpjsCardNo) &&
			Objects.equals(this.polyclinicDestination, that.polyclinicDestination) &&
			Objects.equals(this.doctorDestination, that.doctorDestination) &&
			Objects.equals(this.polyclinicSource, that.polyclinicSource) &&
			Objects.equals(this.doctorSource, that.doctorSource) &&
			Objects.equals(this.sepDate, that.sepDate) &&
			Objects.equals(this.treatmentType, that.treatmentType) &&
			Objects.equals(this.treatmentClass, that.treatmentClass) &&
			Objects.equals(this.name, that.name) &&
			Objects.equals(this.gender, that.gender) &&
			Objects.equals(this.dateOfBirth, that.dateOfBirth) &&
			Objects.equals(this.provider, that.provider) &&
			Objects.equals(this.referralProvider, that.referralProvider) &&
			Objects.equals(this.referralSource, that.referralSource) &&
			Objects.equals(this.referralNo, that.referralNo) &&
			Objects.equals(this.referralDate, that.referralDate) &&
			Objects.equals(this.diagnose, that.diagnose);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
