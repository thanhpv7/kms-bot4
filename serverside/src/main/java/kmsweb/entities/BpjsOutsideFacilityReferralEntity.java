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
import kmsweb.dtos.BpjsOutsideFacilityReferralEntityDto;
import kmsweb.entities.listeners.BpjsOutsideFacilityReferralEntityListener;
import kmsweb.serializers.BpjsOutsideFacilityReferralSerializer;
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
@EntityListeners({BpjsOutsideFacilityReferralEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsOutsideFacilityReferralSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsOutsideFacilityReferralEntity extends AbstractEntity {

	/**
	 * Takes a BpjsOutsideFacilityReferralEntityDto and converts it into a BpjsOutsideFacilityReferralEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsOutsideFacilityReferralEntityDto
	 */
	public BpjsOutsideFacilityReferralEntity(BpjsOutsideFacilityReferralEntityDto bpjsOutsideFacilityReferralEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsOutsideFacilityReferralEntityDto.getId() != null) {
			this.setId(bpjsOutsideFacilityReferralEntityDto.getId());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getReferralNo() != null) {
			this.setReferralNo(bpjsOutsideFacilityReferralEntityDto.getReferralNo());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getReferralDate() != null) {
			this.setReferralDate(bpjsOutsideFacilityReferralEntityDto.getReferralDate());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getTreatmentType() != null) {
			this.setTreatmentType(bpjsOutsideFacilityReferralEntityDto.getTreatmentType());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getBpjsCardNo() != null) {
			this.setBpjsCardNo(bpjsOutsideFacilityReferralEntityDto.getBpjsCardNo());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getName() != null) {
			this.setName(bpjsOutsideFacilityReferralEntityDto.getName());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getReferredPPKCode() != null) {
			this.setReferredPPKCode(bpjsOutsideFacilityReferralEntityDto.getReferredPPKCode());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getReferredPPKName() != null) {
			this.setReferredPPKName(bpjsOutsideFacilityReferralEntityDto.getReferredPPKName());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getSepNo() != null) {
			this.setSepNo(bpjsOutsideFacilityReferralEntityDto.getSepNo());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getTreatmentClass() != null) {
			this.setTreatmentClass(bpjsOutsideFacilityReferralEntityDto.getTreatmentClass());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getSepDate() != null) {
			this.setSepDate(bpjsOutsideFacilityReferralEntityDto.getSepDate());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getVisitPlanDate() != null) {
			this.setVisitPlanDate(bpjsOutsideFacilityReferralEntityDto.getVisitPlanDate());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getDiagnose() != null) {
			this.setDiagnose(bpjsOutsideFacilityReferralEntityDto.getDiagnose());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getReferralType() != null) {
			this.setReferralType(bpjsOutsideFacilityReferralEntityDto.getReferralType());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getReferralPolyclinic() != null) {
			this.setReferralPolyclinic(bpjsOutsideFacilityReferralEntityDto.getReferralPolyclinic());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getGender() != null) {
			this.setGender(bpjsOutsideFacilityReferralEntityDto.getGender());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getDateOfBirth() != null) {
			this.setDateOfBirth(bpjsOutsideFacilityReferralEntityDto.getDateOfBirth());
		}

		if (bpjsOutsideFacilityReferralEntityDto.getNotes() != null) {
			this.setNotes(bpjsOutsideFacilityReferralEntityDto.getNotes());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

	// % protected region % [Modify attribute annotation for Treatment Type here] off begin
	@CsvBindByName(column = "TREATMENT_TYPE", required = false)
	@Nullable
	@Column(name = "treatment_type")
	@Schema(description = "The Treatment Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Type here] end
	private String treatmentType;

	// % protected region % [Modify attribute annotation for BPJS Card No here] off begin
	@CsvBindByName(column = "BPJS_CARD_NO", required = false)
	@Nullable
	@Column(name = "bpjs_card_no")
	@Schema(description = "The BPJS Card No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BPJS Card No here] end
	private String bpjsCardNo;

	// % protected region % [Modify attribute annotation for Name here] off begin
	@CsvBindByName(column = "NAME", required = false)
	@Nullable
	@Column(name = "name")
	@Schema(description = "The Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Name here] end
	private String name;

	// % protected region % [Modify attribute annotation for Referred PPK Code here] off begin
	@CsvBindByName(column = "REFERRED_PPK_CODE", required = false)
	@Nullable
	@Column(name = "referred_ppk_code")
	@Schema(description = "The Referred PPK Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referred PPK Code here] end
	private String referredPPKCode;

	// % protected region % [Modify attribute annotation for Referred PPK Name here] off begin
	@CsvBindByName(column = "REFERRED_PPK_NAME", required = false)
	@Nullable
	@Column(name = "referred_ppk_name")
	@Schema(description = "The Referred PPK Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referred PPK Name here] end
	private String referredPPKName;

	// % protected region % [Modify attribute annotation for SEP No here] off begin
	@CsvBindByName(column = "SEP_NO", required = false)
	@Nullable
	@Column(name = "sep_no")
	@Schema(description = "The SEP No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SEP No here] end
	private String sepNo;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@CsvBindByName(column = "TREATMENT_CLASS", required = false)
	@Nullable
	@Column(name = "treatment_class")
	@Schema(description = "The Treatment Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for SEP Date here] off begin
	@CsvBindByName(column = "SEP_DATE", required = false)
	@Nullable
	@Column(name = "sep_date")
	@Schema(description = "The SEP Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SEP Date here] end
	private String sepDate;

	// % protected region % [Modify attribute annotation for Visit Plan Date here] off begin
	@CsvBindByName(column = "VISIT_PLAN_DATE", required = false)
	@Nullable
	@Column(name = "visit_plan_date")
	@Schema(description = "The Visit Plan Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Visit Plan Date here] end
	private String visitPlanDate;

	// % protected region % [Modify attribute annotation for Diagnose here] off begin
	@CsvBindByName(column = "DIAGNOSE", required = false)
	@Nullable
	@Column(name = "diagnose")
	@Schema(description = "The Diagnose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diagnose here] end
	private String diagnose;

	// % protected region % [Modify attribute annotation for Referral Type here] off begin
	@CsvBindByName(column = "REFERRAL_TYPE", required = false)
	@Nullable
	@Column(name = "referral_type")
	@Schema(description = "The Referral Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral Type here] end
	private String referralType;

	// % protected region % [Modify attribute annotation for Referral Polyclinic here] off begin
	@CsvBindByName(column = "REFERRAL_POLYCLINIC", required = false)
	@Nullable
	@Column(name = "referral_polyclinic")
	@Schema(description = "The Referral Polyclinic of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral Polyclinic here] end
	private String referralPolyclinic;

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
		return "REFERRAL_NO,REFERRAL_DATE,TREATMENT_TYPE,BPJS_CARD_NO,NAME,REFERRED_PPK_CODE,REFERRED_PPK_NAME,SEP_NO,TREATMENT_CLASS,SEP_DATE,VISIT_PLAN_DATE,DIAGNOSE,REFERRAL_TYPE,REFERRAL_POLYCLINIC,GENDER,DATE_OF_BIRTH,NOTES,ID";
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
	public boolean equals(Object bpjsOutsideFacilityReferral) {
		if (this == bpjsOutsideFacilityReferral) {
			return true;
		}
		if (bpjsOutsideFacilityReferral == null || this.getClass() != bpjsOutsideFacilityReferral.getClass()) {
			return false;
		}
		if (!super.equals(bpjsOutsideFacilityReferral)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsOutsideFacilityReferralEntity that = (BpjsOutsideFacilityReferralEntity) bpjsOutsideFacilityReferral;
		return
			Objects.equals(this.referralNo, that.referralNo) &&
			Objects.equals(this.referralDate, that.referralDate) &&
			Objects.equals(this.treatmentType, that.treatmentType) &&
			Objects.equals(this.bpjsCardNo, that.bpjsCardNo) &&
			Objects.equals(this.name, that.name) &&
			Objects.equals(this.referredPPKCode, that.referredPPKCode) &&
			Objects.equals(this.referredPPKName, that.referredPPKName) &&
			Objects.equals(this.sepNo, that.sepNo) &&
			Objects.equals(this.treatmentClass, that.treatmentClass) &&
			Objects.equals(this.sepDate, that.sepDate) &&
			Objects.equals(this.visitPlanDate, that.visitPlanDate) &&
			Objects.equals(this.diagnose, that.diagnose) &&
			Objects.equals(this.referralType, that.referralType) &&
			Objects.equals(this.referralPolyclinic, that.referralPolyclinic) &&
			Objects.equals(this.gender, that.gender) &&
			Objects.equals(this.dateOfBirth, that.dateOfBirth) &&
			Objects.equals(this.notes, that.notes);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}