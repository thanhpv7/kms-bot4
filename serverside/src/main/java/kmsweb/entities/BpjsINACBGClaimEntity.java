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
import kmsweb.dtos.BpjsINACBGClaimEntityDto;
import kmsweb.entities.listeners.BpjsINACBGClaimEntityListener;
import kmsweb.serializers.BpjsINACBGClaimSerializer;
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
@EntityListeners({BpjsINACBGClaimEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsINACBGClaimSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"claim_no"}, name = "claim_no"),
	}
)
public class BpjsINACBGClaimEntity extends AbstractEntity {

	/**
	 * Takes a BpjsINACBGClaimEntityDto and converts it into a BpjsINACBGClaimEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsINACBGClaimEntityDto
	 */
	public BpjsINACBGClaimEntity(BpjsINACBGClaimEntityDto bpjsINACBGClaimEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsINACBGClaimEntityDto.getId() != null) {
			this.setId(bpjsINACBGClaimEntityDto.getId());
		}

		if (bpjsINACBGClaimEntityDto.getClaimNo() != null) {
			this.setClaimNo(bpjsINACBGClaimEntityDto.getClaimNo());
		}

		if (bpjsINACBGClaimEntityDto.getPatientID() != null) {
			this.setPatientID(bpjsINACBGClaimEntityDto.getPatientID());
		}

		if (bpjsINACBGClaimEntityDto.getInvoiceNumber() != null) {
			this.setInvoiceNumber(bpjsINACBGClaimEntityDto.getInvoiceNumber());
		}

		if (bpjsINACBGClaimEntityDto.getBpjsCardNo() != null) {
			this.setBpjsCardNo(bpjsINACBGClaimEntityDto.getBpjsCardNo());
		}

		if (bpjsINACBGClaimEntityDto.getSepNo() != null) {
			this.setSepNo(bpjsINACBGClaimEntityDto.getSepNo());
		}

		if (bpjsINACBGClaimEntityDto.getTreatmentType() != null) {
			this.setTreatmentType(bpjsINACBGClaimEntityDto.getTreatmentType());
		}

		if (bpjsINACBGClaimEntityDto.getTreatmentClass() != null) {
			this.setTreatmentClass(bpjsINACBGClaimEntityDto.getTreatmentClass());
		}

		if (bpjsINACBGClaimEntityDto.getAdmissionDate() != null) {
			this.setAdmissionDate(bpjsINACBGClaimEntityDto.getAdmissionDate());
		}

		if (bpjsINACBGClaimEntityDto.getDismissalDate() != null) {
			this.setDismissalDate(bpjsINACBGClaimEntityDto.getDismissalDate());
		}

		if (bpjsINACBGClaimEntityDto.getLos() != null) {
			this.setLos(bpjsINACBGClaimEntityDto.getLos());
		}

		if (bpjsINACBGClaimEntityDto.getDismissal() != null) {
			this.setDismissal(bpjsINACBGClaimEntityDto.getDismissal());
		}

		if (bpjsINACBGClaimEntityDto.getResponsibleDoctor() != null) {
			this.setResponsibleDoctor(bpjsINACBGClaimEntityDto.getResponsibleDoctor());
		}

		if (bpjsINACBGClaimEntityDto.getWeight() != null) {
			this.setWeight(bpjsINACBGClaimEntityDto.getWeight());
		}

		if (bpjsINACBGClaimEntityDto.getAdl() != null) {
			this.setAdl(bpjsINACBGClaimEntityDto.getAdl());
		}

		if (bpjsINACBGClaimEntityDto.getClaimStatus() != null) {
			this.setClaimStatus(bpjsINACBGClaimEntityDto.getClaimStatus());
		}

		if (bpjsINACBGClaimEntityDto.getSepStatus() != null) {
			this.setSepStatus(bpjsINACBGClaimEntityDto.getSepStatus());
		}

		if (bpjsINACBGClaimEntityDto.getHospitalTariff() != null) {
			this.setHospitalTariff(bpjsINACBGClaimEntityDto.getHospitalTariff());
		}

		if (bpjsINACBGClaimEntityDto.getReferralLetter() != null) {
			this.setReferralLetter(bpjsINACBGClaimEntityDto.getReferralLetter());
		}

		if (bpjsINACBGClaimEntityDto.getThirdSelLevel() != null) {
			this.setThirdSelLevel(bpjsINACBGClaimEntityDto.getThirdSelLevel());
		}

		if (bpjsINACBGClaimEntityDto.getStaffName() != null) {
			this.setStaffName(bpjsINACBGClaimEntityDto.getStaffName());
		}

		if (bpjsINACBGClaimEntityDto.getDateGrouping() != null) {
			this.setDateGrouping(bpjsINACBGClaimEntityDto.getDateGrouping());
		}

		if (bpjsINACBGClaimEntityDto.getInacbgTariff() != null) {
			this.setInacbgTariff(bpjsINACBGClaimEntityDto.getInacbgTariff());
		}

		if (bpjsINACBGClaimEntityDto.getDescription() != null) {
			this.setDescription(bpjsINACBGClaimEntityDto.getDescription());
		}

		if (bpjsINACBGClaimEntityDto.getCbgType() != null) {
			this.setCbgType(bpjsINACBGClaimEntityDto.getCbgType());
		}

		if (bpjsINACBGClaimEntityDto.getTariff() != null) {
			this.setTariff(bpjsINACBGClaimEntityDto.getTariff());
		}

		if (bpjsINACBGClaimEntityDto.getSubAcute() != null) {
			this.setSubAcute(bpjsINACBGClaimEntityDto.getSubAcute());
		}

		if (bpjsINACBGClaimEntityDto.getSubAcuteCode() != null) {
			this.setSubAcuteCode(bpjsINACBGClaimEntityDto.getSubAcuteCode());
		}

		if (bpjsINACBGClaimEntityDto.getSubAcuteTariff() != null) {
			this.setSubAcuteTariff(bpjsINACBGClaimEntityDto.getSubAcuteTariff());
		}

		if (bpjsINACBGClaimEntityDto.getChronic() != null) {
			this.setChronic(bpjsINACBGClaimEntityDto.getChronic());
		}

		if (bpjsINACBGClaimEntityDto.getChronicCode() != null) {
			this.setChronicCode(bpjsINACBGClaimEntityDto.getChronicCode());
		}

		if (bpjsINACBGClaimEntityDto.getChronicTariff() != null) {
			this.setChronicTariff(bpjsINACBGClaimEntityDto.getChronicTariff());
		}

		if (bpjsINACBGClaimEntityDto.getResultSpecProcedure() != null) {
			this.setResultSpecProcedure(bpjsINACBGClaimEntityDto.getResultSpecProcedure());
		}

		if (bpjsINACBGClaimEntityDto.getResultSpecDrug() != null) {
			this.setResultSpecDrug(bpjsINACBGClaimEntityDto.getResultSpecDrug());
		}

		if (bpjsINACBGClaimEntityDto.getResultSpecInvestigation() != null) {
			this.setResultSpecInvestigation(bpjsINACBGClaimEntityDto.getResultSpecInvestigation());
		}

		if (bpjsINACBGClaimEntityDto.getResultSpecProsthesis() != null) {
			this.setResultSpecProsthesis(bpjsINACBGClaimEntityDto.getResultSpecProsthesis());
		}

		if (bpjsINACBGClaimEntityDto.getHospitalClass() != null) {
			this.setHospitalClass(bpjsINACBGClaimEntityDto.getHospitalClass());
		}

		if (bpjsINACBGClaimEntityDto.getTariffType() != null) {
			this.setTariffType(bpjsINACBGClaimEntityDto.getTariffType());
		}

		if (bpjsINACBGClaimEntityDto.getTotalTariff() != null) {
			this.setTotalTariff(bpjsINACBGClaimEntityDto.getTotalTariff());
		}

		if (bpjsINACBGClaimEntityDto.getVisitDate() != null) {
			this.setVisitDate(bpjsINACBGClaimEntityDto.getVisitDate());
		}

		if (bpjsINACBGClaimEntityDto.getSpecProcedureTariff() != null) {
			this.setSpecProcedureTariff(bpjsINACBGClaimEntityDto.getSpecProcedureTariff());
		}

		if (bpjsINACBGClaimEntityDto.getSpecDrugTariff() != null) {
			this.setSpecDrugTariff(bpjsINACBGClaimEntityDto.getSpecDrugTariff());
		}

		if (bpjsINACBGClaimEntityDto.getSpecInvestigationTariff() != null) {
			this.setSpecInvestigationTariff(bpjsINACBGClaimEntityDto.getSpecInvestigationTariff());
		}

		if (bpjsINACBGClaimEntityDto.getSpecProsthesisTariff() != null) {
			this.setSpecProsthesisTariff(bpjsINACBGClaimEntityDto.getSpecProsthesisTariff());
		}

		if (bpjsINACBGClaimEntityDto.getUpgradeFlag() != null) {
			this.setUpgradeFlag(bpjsINACBGClaimEntityDto.getUpgradeFlag());
		}

		if (bpjsINACBGClaimEntityDto.getHcuFlag() != null) {
			this.setHcuFlag(bpjsINACBGClaimEntityDto.getHcuFlag());
		}

		if (bpjsINACBGClaimEntityDto.getGrouperFlag() != null) {
			this.setGrouperFlag(bpjsINACBGClaimEntityDto.getGrouperFlag());
		}

		if (bpjsINACBGClaimEntityDto.getNonSurgeryProcedure() != null) {
			this.setNonSurgeryProcedure(bpjsINACBGClaimEntityDto.getNonSurgeryProcedure());
		}

		if (bpjsINACBGClaimEntityDto.getSurgeryProcedure() != null) {
			this.setSurgeryProcedure(bpjsINACBGClaimEntityDto.getSurgeryProcedure());
		}

		if (bpjsINACBGClaimEntityDto.getConsultation() != null) {
			this.setConsultation(bpjsINACBGClaimEntityDto.getConsultation());
		}

		if (bpjsINACBGClaimEntityDto.getSpecialist() != null) {
			this.setSpecialist(bpjsINACBGClaimEntityDto.getSpecialist());
		}

		if (bpjsINACBGClaimEntityDto.getNursing() != null) {
			this.setNursing(bpjsINACBGClaimEntityDto.getNursing());
		}

		if (bpjsINACBGClaimEntityDto.getDiagnostic() != null) {
			this.setDiagnostic(bpjsINACBGClaimEntityDto.getDiagnostic());
		}

		if (bpjsINACBGClaimEntityDto.getRadiology() != null) {
			this.setRadiology(bpjsINACBGClaimEntityDto.getRadiology());
		}

		if (bpjsINACBGClaimEntityDto.getLaboratory() != null) {
			this.setLaboratory(bpjsINACBGClaimEntityDto.getLaboratory());
		}

		if (bpjsINACBGClaimEntityDto.getBloodService() != null) {
			this.setBloodService(bpjsINACBGClaimEntityDto.getBloodService());
		}

		if (bpjsINACBGClaimEntityDto.getRehabilitation() != null) {
			this.setRehabilitation(bpjsINACBGClaimEntityDto.getRehabilitation());
		}

		if (bpjsINACBGClaimEntityDto.getBedAccomodation() != null) {
			this.setBedAccomodation(bpjsINACBGClaimEntityDto.getBedAccomodation());
		}

		if (bpjsINACBGClaimEntityDto.getIntensiveCare() != null) {
			this.setIntensiveCare(bpjsINACBGClaimEntityDto.getIntensiveCare());
		}

		if (bpjsINACBGClaimEntityDto.getDrugs() != null) {
			this.setDrugs(bpjsINACBGClaimEntityDto.getDrugs());
		}

		if (bpjsINACBGClaimEntityDto.getMedicalEquipment() != null) {
			this.setMedicalEquipment(bpjsINACBGClaimEntityDto.getMedicalEquipment());
		}

		if (bpjsINACBGClaimEntityDto.getDispensedDisposable() != null) {
			this.setDispensedDisposable(bpjsINACBGClaimEntityDto.getDispensedDisposable());
		}

		if (bpjsINACBGClaimEntityDto.getEquipmentRental() != null) {
			this.setEquipmentRental(bpjsINACBGClaimEntityDto.getEquipmentRental());
		}

		if (bpjsINACBGClaimEntityDto.getIcd10Code() != null) {
			this.setIcd10Code(bpjsINACBGClaimEntityDto.getIcd10Code());
		}

		if (bpjsINACBGClaimEntityDto.getIcd10Desc() != null) {
			this.setIcd10Desc(bpjsINACBGClaimEntityDto.getIcd10Desc());
		}

		if (bpjsINACBGClaimEntityDto.getIcd10Tariff() != null) {
			this.setIcd10Tariff(bpjsINACBGClaimEntityDto.getIcd10Tariff());
		}

		if (bpjsINACBGClaimEntityDto.getIcd9cmCode() != null) {
			this.setIcd9cmCode(bpjsINACBGClaimEntityDto.getIcd9cmCode());
		}

		if (bpjsINACBGClaimEntityDto.getIcd9cmDesc() != null) {
			this.setIcd9cmDesc(bpjsINACBGClaimEntityDto.getIcd9cmDesc());
		}

		if (bpjsINACBGClaimEntityDto.getIcd9cmTariff() != null) {
			this.setIcd9cmTariff(bpjsINACBGClaimEntityDto.getIcd9cmTariff());
		}

		if (bpjsINACBGClaimEntityDto.getChronicDrugs() != null) {
			this.setChronicDrugs(bpjsINACBGClaimEntityDto.getChronicDrugs());
		}

		if (bpjsINACBGClaimEntityDto.getChemotherapyDrugs() != null) {
			this.setChemotherapyDrugs(bpjsINACBGClaimEntityDto.getChemotherapyDrugs());
		}

		if (bpjsINACBGClaimEntityDto.getClassUpgrade() != null) {
			this.setClassUpgrade(bpjsINACBGClaimEntityDto.getClassUpgrade());
		}

		if (bpjsINACBGClaimEntityDto.getHighCareUnit() != null) {
			this.setHighCareUnit(bpjsINACBGClaimEntityDto.getHighCareUnit());
		}

		if (bpjsINACBGClaimEntityDto.getInacbgClaimCreated() != null) {
			this.setInacbgClaimCreated(bpjsINACBGClaimEntityDto.getInacbgClaimCreated());
		}

		if (bpjsINACBGClaimEntityDto.getInacbgResponse() != null) {
			this.setInacbgResponse(bpjsINACBGClaimEntityDto.getInacbgResponse());
		}

		if (bpjsINACBGClaimEntityDto.getTotalInvoice() != null) {
			this.setTotalInvoice(bpjsINACBGClaimEntityDto.getTotalInvoice());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Claim No here] off begin
	@CsvBindByName(column = "CLAIM_NO", required = false)
	@Nullable
	@Column(name = "claim_no")
	@Schema(description = "The Claim No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Claim No here] end
	private String claimNo;

	// % protected region % [Modify attribute annotation for Patient ID here] off begin
	@CsvBindByName(column = "PATIENT_ID", required = false)
	@Nullable
	@Column(name = "patient_id")
	@Schema(description = "The Patient ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient ID here] end
	private String patientID;

	// % protected region % [Modify attribute annotation for Invoice Number here] off begin
	@CsvBindByName(column = "INVOICE_NUMBER", required = false)
	@Nullable
	@Column(name = "invoice_number")
	@Schema(description = "The Invoice Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Invoice Number here] end
	private String invoiceNumber;

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

	// % protected region % [Modify attribute annotation for Admission Date here] off begin
	@CsvCustomBindByName(column = "ADMISSION_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "admission_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Admission Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Admission Date here] end
	private OffsetDateTime admissionDate;

	// % protected region % [Modify attribute annotation for Dismissal Date here] off begin
	@CsvCustomBindByName(column = "DISMISSAL_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "dismissal_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Dismissal Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dismissal Date here] end
	private OffsetDateTime dismissalDate;

	// % protected region % [Modify attribute annotation for LOS here] off begin
	@CsvBindByName(column = "LOS", required = false)
	@Nullable
	@Column(name = "los")
	@Schema(description = "The LOS of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for LOS here] end
	private String los;

	// % protected region % [Modify attribute annotation for Dismissal here] off begin
	@CsvBindByName(column = "DISMISSAL", required = false)
	@Nullable
	@Column(name = "dismissal")
	@Schema(description = "The Dismissal of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dismissal here] end
	private String dismissal;

	// % protected region % [Modify attribute annotation for Responsible Doctor here] off begin
	@CsvBindByName(column = "RESPONSIBLE_DOCTOR", required = false)
	@Nullable
	@Column(name = "responsible_doctor")
	@Schema(description = "The Responsible Doctor of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Responsible Doctor here] end
	private String responsibleDoctor;

	// % protected region % [Modify attribute annotation for Weight here] off begin
	@CsvBindByName(column = "WEIGHT", required = false)
	@Nullable
	@Column(name = "weight")
	@Schema(description = "The Weight of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight here] end
	private Double weight;

	// % protected region % [Modify attribute annotation for ADL here] off begin
	@CsvBindByName(column = "ADL", required = false)
	@Nullable
	@Column(name = "adl")
	@Schema(description = "The ADL of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ADL here] end
	private Integer adl;

	// % protected region % [Modify attribute annotation for Claim Status here] off begin
	@CsvBindByName(column = "CLAIM_STATUS", required = false)
	@Nullable
	@Column(name = "claim_status")
	@Schema(description = "The Claim Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Claim Status here] end
	private String claimStatus;

	// % protected region % [Modify attribute annotation for SEP Status here] off begin
	@CsvBindByName(column = "SEP_STATUS", required = false)
	@Nullable
	@Column(name = "sep_status")
	@Schema(description = "The SEP Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SEP Status here] end
	private String sepStatus;

	// % protected region % [Modify attribute annotation for Hospital Tariff here] off begin
	@CsvBindByName(column = "HOSPITAL_TARIFF", required = false)
	@Nullable
	@Column(name = "hospital_tariff")
	@Schema(description = "The Hospital Tariff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Tariff here] end
	private Double hospitalTariff;

	// % protected region % [Modify attribute annotation for Referral Letter here] off begin
	@CsvBindByName(column = "REFERRAL_LETTER", required = false)
	@Nullable
	@Column(name = "referral_letter")
	@Schema(description = "The Referral Letter of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral Letter here] end
	private String referralLetter;

	// % protected region % [Modify attribute annotation for Third Sel Level here] off begin
	@CsvBindByName(column = "THIRD_SEL_LEVEL", required = false)
	@Nullable
	@Column(name = "third_sel_level")
	@Schema(description = "The Third Sel Level of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Third Sel Level here] end
	private String thirdSelLevel;

	// % protected region % [Modify attribute annotation for Staff Name here] off begin
	@CsvBindByName(column = "STAFF_NAME", required = false)
	@Nullable
	@Column(name = "staff_name")
	@Schema(description = "The Staff Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Staff Name here] end
	private String staffName;

	// % protected region % [Modify attribute annotation for Date Grouping here] off begin
	@CsvCustomBindByName(column = "DATE_GROUPING", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "date_grouping")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Date Grouping of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Date Grouping here] end
	private OffsetDateTime dateGrouping;

	// % protected region % [Modify attribute annotation for INACBG Tariff here] off begin
	@CsvBindByName(column = "INACBG_TARIFF", required = false)
	@Nullable
	@Column(name = "inacbg_tariff")
	@Schema(description = "The INACBG Tariff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for INACBG Tariff here] end
	private String inacbgTariff;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@CsvBindByName(column = "DESCRIPTION", required = false)
	@Nullable
	@Column(name = "description")
	@Schema(description = "The Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for CBG Type here] off begin
	@CsvBindByName(column = "CBG_TYPE", required = false)
	@Nullable
	@Column(name = "cbg_type")
	@Schema(description = "The CBG Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for CBG Type here] end
	private String cbgType;

	// % protected region % [Modify attribute annotation for Tariff here] off begin
	@CsvBindByName(column = "TARIFF", required = false)
	@Nullable
	@Column(name = "tariff")
	@Schema(description = "The Tariff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tariff here] end
	private Double tariff;

	// % protected region % [Modify attribute annotation for Sub Acute here] off begin
	@CsvBindByName(column = "SUB_ACUTE", required = false)
	@Nullable
	@Column(name = "sub_acute")
	@Schema(description = "The Sub Acute of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sub Acute here] end
	private String subAcute;

	// % protected region % [Modify attribute annotation for Sub Acute Code here] off begin
	@CsvBindByName(column = "SUB_ACUTE_CODE", required = false)
	@Nullable
	@Column(name = "sub_acute_code")
	@Schema(description = "The Sub Acute Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sub Acute Code here] end
	private String subAcuteCode;

	// % protected region % [Modify attribute annotation for Sub Acute Tariff here] off begin
	@CsvBindByName(column = "SUB_ACUTE_TARIFF", required = false)
	@Nullable
	@Column(name = "sub_acute_tariff")
	@Schema(description = "The Sub Acute Tariff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sub Acute Tariff here] end
	private Double subAcuteTariff;

	// % protected region % [Modify attribute annotation for Chronic here] off begin
	@CsvBindByName(column = "CHRONIC", required = false)
	@Nullable
	@Column(name = "chronic")
	@Schema(description = "The Chronic of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Chronic here] end
	private String chronic;

	// % protected region % [Modify attribute annotation for Chronic Code here] off begin
	@CsvBindByName(column = "CHRONIC_CODE", required = false)
	@Nullable
	@Column(name = "chronic_code")
	@Schema(description = "The Chronic Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Chronic Code here] end
	private String chronicCode;

	// % protected region % [Modify attribute annotation for Chronic Tariff here] off begin
	@CsvBindByName(column = "CHRONIC_TARIFF", required = false)
	@Nullable
	@Column(name = "chronic_tariff")
	@Schema(description = "The Chronic Tariff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Chronic Tariff here] end
	private Double chronicTariff;

	// % protected region % [Modify attribute annotation for Result Spec Procedure here] off begin
	@CsvBindByName(column = "RESULT_SPEC_PROCEDURE", required = false)
	@Nullable
	@Column(name = "result_spec_procedure")
	@Schema(description = "The Result Spec Procedure of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Result Spec Procedure here] end
	private String resultSpecProcedure;

	// % protected region % [Modify attribute annotation for Result Spec Drug here] off begin
	@CsvBindByName(column = "RESULT_SPEC_DRUG", required = false)
	@Nullable
	@Column(name = "result_spec_drug")
	@Schema(description = "The Result Spec Drug of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Result Spec Drug here] end
	private String resultSpecDrug;

	// % protected region % [Modify attribute annotation for Result Spec Investigation here] off begin
	@CsvBindByName(column = "RESULT_SPEC_INVESTIGATION", required = false)
	@Nullable
	@Column(name = "result_spec_investigation")
	@Schema(description = "The Result Spec Investigation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Result Spec Investigation here] end
	private String resultSpecInvestigation;

	// % protected region % [Modify attribute annotation for Result Spec Prosthesis here] off begin
	@CsvBindByName(column = "RESULT_SPEC_PROSTHESIS", required = false)
	@Nullable
	@Column(name = "result_spec_prosthesis")
	@Schema(description = "The Result Spec Prosthesis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Result Spec Prosthesis here] end
	private String resultSpecProsthesis;

	// % protected region % [Modify attribute annotation for Hospital Class here] off begin
	@CsvBindByName(column = "HOSPITAL_CLASS", required = false)
	@Nullable
	@Column(name = "hospital_class")
	@Schema(description = "The Hospital Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Class here] end
	private String hospitalClass;

	// % protected region % [Modify attribute annotation for Tariff Type here] off begin
	@CsvBindByName(column = "TARIFF_TYPE", required = false)
	@Nullable
	@Column(name = "tariff_type")
	@Schema(description = "The Tariff Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tariff Type here] end
	private String tariffType;

	// % protected region % [Modify attribute annotation for Total Tariff here] off begin
	@CsvBindByName(column = "TOTAL_TARIFF", required = false)
	@Nullable
	@Column(name = "total_tariff")
	@Schema(description = "The Total Tariff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Tariff here] end
	private Double totalTariff;

	// % protected region % [Modify attribute annotation for Visit Date here] off begin
	@CsvCustomBindByName(column = "VISIT_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "visit_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Visit Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Visit Date here] end
	private OffsetDateTime visitDate;

	// % protected region % [Modify attribute annotation for Spec Procedure Tariff here] off begin
	@CsvBindByName(column = "SPEC_PROCEDURE_TARIFF", required = false)
	@Nullable
	@Column(name = "spec_procedure_tariff")
	@Schema(description = "The Spec Procedure Tariff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Spec Procedure Tariff here] end
	private Double specProcedureTariff;

	// % protected region % [Modify attribute annotation for Spec Drug Tariff here] off begin
	@CsvBindByName(column = "SPEC_DRUG_TARIFF", required = false)
	@Nullable
	@Column(name = "spec_drug_tariff")
	@Schema(description = "The Spec Drug Tariff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Spec Drug Tariff here] end
	private Double specDrugTariff;

	// % protected region % [Modify attribute annotation for Spec Investigation Tariff here] off begin
	@CsvBindByName(column = "SPEC_INVESTIGATION_TARIFF", required = false)
	@Nullable
	@Column(name = "spec_investigation_tariff")
	@Schema(description = "The Spec Investigation Tariff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Spec Investigation Tariff here] end
	private Double specInvestigationTariff;

	// % protected region % [Modify attribute annotation for Spec Prosthesis Tariff here] off begin
	@CsvBindByName(column = "SPEC_PROSTHESIS_TARIFF", required = false)
	@Nullable
	@Column(name = "spec_prosthesis_tariff")
	@Schema(description = "The Spec Prosthesis Tariff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Spec Prosthesis Tariff here] end
	private Double specProsthesisTariff;

	// % protected region % [Modify attribute annotation for Upgrade Flag here] off begin
	@CsvBindByName(column = "UPGRADE_FLAG", required = false)
	@Nullable
	@Column(name = "upgrade_flag")
	@Schema(description = "The Upgrade Flag of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Upgrade Flag here] end
	private Boolean upgradeFlag = false ;

	// % protected region % [Modify attribute annotation for HCU Flag here] off begin
	@CsvBindByName(column = "HCU_FLAG", required = false)
	@Nullable
	@Column(name = "hcu_flag")
	@Schema(description = "The HCU Flag of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for HCU Flag here] end
	private Boolean hcuFlag = false ;

	// % protected region % [Modify attribute annotation for Grouper Flag here] off begin
	@CsvBindByName(column = "GROUPER_FLAG", required = false)
	@Nullable
	@Column(name = "grouper_flag")
	@Schema(description = "The Grouper Flag of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Grouper Flag here] end
	private Boolean grouperFlag = false ;

	// % protected region % [Modify attribute annotation for Non Surgery Procedure here] off begin
	@CsvBindByName(column = "NON_SURGERY_PROCEDURE", required = false)
	@Nullable
	@Column(name = "non_surgery_procedure")
	@Schema(description = "The Non Surgery Procedure of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Non Surgery Procedure here] end
	private Double nonSurgeryProcedure;

	// % protected region % [Modify attribute annotation for Surgery Procedure here] off begin
	@CsvBindByName(column = "SURGERY_PROCEDURE", required = false)
	@Nullable
	@Column(name = "surgery_procedure")
	@Schema(description = "The Surgery Procedure of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Surgery Procedure here] end
	private Double surgeryProcedure;

	// % protected region % [Modify attribute annotation for Consultation here] off begin
	@CsvBindByName(column = "CONSULTATION", required = false)
	@Nullable
	@Column(name = "consultation")
	@Schema(description = "The Consultation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consultation here] end
	private Double consultation;

	// % protected region % [Modify attribute annotation for Specialist here] off begin
	@CsvBindByName(column = "SPECIALIST", required = false)
	@Nullable
	@Column(name = "specialist")
	@Schema(description = "The Specialist of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Specialist here] end
	private Double specialist;

	// % protected region % [Modify attribute annotation for Nursing here] off begin
	@CsvBindByName(column = "NURSING", required = false)
	@Nullable
	@Column(name = "nursing")
	@Schema(description = "The Nursing of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nursing here] end
	private Double nursing;

	// % protected region % [Modify attribute annotation for Diagnostic here] off begin
	@CsvBindByName(column = "DIAGNOSTIC", required = false)
	@Nullable
	@Column(name = "diagnostic")
	@Schema(description = "The Diagnostic of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diagnostic here] end
	private Double diagnostic;

	// % protected region % [Modify attribute annotation for Radiology here] off begin
	@CsvBindByName(column = "RADIOLOGY", required = false)
	@Nullable
	@Column(name = "radiology")
	@Schema(description = "The Radiology of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Radiology here] end
	private Double radiology;

	// % protected region % [Modify attribute annotation for Laboratory here] off begin
	@CsvBindByName(column = "LABORATORY", required = false)
	@Nullable
	@Column(name = "laboratory")
	@Schema(description = "The Laboratory of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Laboratory here] end
	private Double laboratory;

	// % protected region % [Modify attribute annotation for Blood Service here] off begin
	@CsvBindByName(column = "BLOOD_SERVICE", required = false)
	@Nullable
	@Column(name = "blood_service")
	@Schema(description = "The Blood Service of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Blood Service here] end
	private Double bloodService;

	// % protected region % [Modify attribute annotation for Rehabilitation here] off begin
	@CsvBindByName(column = "REHABILITATION", required = false)
	@Nullable
	@Column(name = "rehabilitation")
	@Schema(description = "The Rehabilitation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Rehabilitation here] end
	private Double rehabilitation;

	// % protected region % [Modify attribute annotation for Bed Accomodation here] off begin
	@CsvBindByName(column = "BED_ACCOMODATION", required = false)
	@Nullable
	@Column(name = "bed_accomodation")
	@Schema(description = "The Bed Accomodation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Bed Accomodation here] end
	private Double bedAccomodation;

	// % protected region % [Modify attribute annotation for Intensive Care here] off begin
	@CsvBindByName(column = "INTENSIVE_CARE", required = false)
	@Nullable
	@Column(name = "intensive_care")
	@Schema(description = "The Intensive Care of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Intensive Care here] end
	private Double intensiveCare;

	// % protected region % [Modify attribute annotation for Drugs here] off begin
	@CsvBindByName(column = "DRUGS", required = false)
	@Nullable
	@Column(name = "drugs")
	@Schema(description = "The Drugs of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Drugs here] end
	private Double drugs;

	// % protected region % [Modify attribute annotation for Medical Equipment here] off begin
	@CsvBindByName(column = "MEDICAL_EQUIPMENT", required = false)
	@Nullable
	@Column(name = "medical_equipment")
	@Schema(description = "The Medical Equipment of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Medical Equipment here] end
	private Double medicalEquipment;

	// % protected region % [Modify attribute annotation for Dispensed Disposable here] off begin
	@CsvBindByName(column = "DISPENSED_DISPOSABLE", required = false)
	@Nullable
	@Column(name = "dispensed_disposable")
	@Schema(description = "The Dispensed Disposable of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dispensed Disposable here] end
	private Double dispensedDisposable;

	// % protected region % [Modify attribute annotation for Equipment Rental here] off begin
	@CsvBindByName(column = "EQUIPMENT_RENTAL", required = false)
	@Nullable
	@Column(name = "equipment_rental")
	@Schema(description = "The Equipment Rental of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Equipment Rental here] end
	private Double equipmentRental;

	// % protected region % [Modify attribute annotation for ICD10 Code here] off begin
	@CsvBindByName(column = "ICD10_CODE", required = false)
	@Nullable
	@Column(name = "icd10_code")
	@Schema(description = "The ICD10 Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ICD10 Code here] end
	private String icd10Code;

	// % protected region % [Modify attribute annotation for ICD10 Desc here] off begin
	@CsvBindByName(column = "ICD10_DESC", required = false)
	@Nullable
	@Column(name = "icd10_desc")
	@Schema(description = "The ICD10 Desc of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ICD10 Desc here] end
	private String icd10Desc;

	// % protected region % [Modify attribute annotation for ICD10 Tariff here] off begin
	@CsvBindByName(column = "ICD10_TARIFF", required = false)
	@Nullable
	@Column(name = "icd10_tariff")
	@Schema(description = "The ICD10 Tariff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ICD10 Tariff here] end
	private Double icd10Tariff;

	// % protected region % [Modify attribute annotation for ICD9CM Code here] off begin
	@CsvBindByName(column = "ICD9CM_CODE", required = false)
	@Nullable
	@Column(name = "icd9cm_code")
	@Schema(description = "The ICD9CM Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ICD9CM Code here] end
	private String icd9cmCode;

	// % protected region % [Modify attribute annotation for ICD9CM Desc here] off begin
	@CsvBindByName(column = "ICD9CM_DESC", required = false)
	@Nullable
	@Column(name = "icd9cm_desc")
	@Schema(description = "The ICD9CM Desc of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ICD9CM Desc here] end
	private String icd9cmDesc;

	// % protected region % [Modify attribute annotation for ICD9CM Tariff here] off begin
	@CsvBindByName(column = "ICD9CM_TARIFF", required = false)
	@Nullable
	@Column(name = "icd9cm_tariff")
	@Schema(description = "The ICD9CM Tariff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ICD9CM Tariff here] end
	private Double icd9cmTariff;

	// % protected region % [Modify attribute annotation for Chronic Drugs here] off begin
	@CsvBindByName(column = "CHRONIC_DRUGS", required = false)
	@Nullable
	@Column(name = "chronic_drugs")
	@Schema(description = "The Chronic Drugs of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Chronic Drugs here] end
	private Double chronicDrugs;

	// % protected region % [Modify attribute annotation for Chemotherapy Drugs here] off begin
	@CsvBindByName(column = "CHEMOTHERAPY_DRUGS", required = false)
	@Nullable
	@Column(name = "chemotherapy_drugs")
	@Schema(description = "The Chemotherapy Drugs of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Chemotherapy Drugs here] end
	private Double chemotherapyDrugs;

	// % protected region % [Modify attribute annotation for Class Upgrade here] off begin
	@CsvBindByName(column = "CLASS_UPGRADE", required = false)
	@Nullable
	@Column(name = "class_upgrade")
	@Schema(description = "The Class Upgrade of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Class Upgrade here] end
	private String classUpgrade;

	// % protected region % [Modify attribute annotation for High Care Unit here] off begin
	@CsvBindByName(column = "HIGH_CARE_UNIT", required = false)
	@Nullable
	@Column(name = "high_care_unit")
	@Schema(description = "The High Care Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for High Care Unit here] end
	private String highCareUnit;

	// % protected region % [Modify attribute annotation for Inacbg Claim Created here] off begin
	@CsvBindByName(column = "INACBG_CLAIM_CREATED", required = false)
	@Nullable
	@Column(name = "inacbg_claim_created")
	@Schema(description = "The Inacbg Claim Created of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inacbg Claim Created here] end
	private Boolean inacbgClaimCreated = false ;

	// % protected region % [Modify attribute annotation for Inacbg Response here] off begin
	@CsvBindByName(column = "INACBG_RESPONSE", required = false)
	@Nullable
	@Lob
	@Column(name = "inacbg_response")
	@Schema(description = "The Inacbg Response of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inacbg Response here] end
	private String inacbgResponse;

	// % protected region % [Modify attribute annotation for Total Invoice here] off begin
	@CsvBindByName(column = "TOTAL_INVOICE", required = false)
	@Nullable
	@Column(name = "total_invoice")
	@Schema(description = "The Total Invoice of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Invoice here] end
	private Double totalInvoice;

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
		return "CLAIM_NO,PATIENT_ID,INVOICE_NUMBER,BPJS_CARD_NO,SEP_NO,TREATMENT_TYPE,TREATMENT_CLASS,ADMISSION_DATE,DISMISSAL_DATE,LOS,DISMISSAL,RESPONSIBLE_DOCTOR,WEIGHT,ADL,CLAIM_STATUS,SEP_STATUS,HOSPITAL_TARIFF,REFERRAL_LETTER,THIRD_SEL_LEVEL,STAFF_NAME,DATE_GROUPING,INACBG_TARIFF,DESCRIPTION,CBG_TYPE,TARIFF,SUB_ACUTE,SUB_ACUTE_CODE,SUB_ACUTE_TARIFF,CHRONIC,CHRONIC_CODE,CHRONIC_TARIFF,RESULT_SPEC_PROCEDURE,RESULT_SPEC_DRUG,RESULT_SPEC_INVESTIGATION,RESULT_SPEC_PROSTHESIS,HOSPITAL_CLASS,TARIFF_TYPE,TOTAL_TARIFF,VISIT_DATE,SPEC_PROCEDURE_TARIFF,SPEC_DRUG_TARIFF,SPEC_INVESTIGATION_TARIFF,SPEC_PROSTHESIS_TARIFF,UPGRADE_FLAG,HCU_FLAG,GROUPER_FLAG,NON_SURGERY_PROCEDURE,SURGERY_PROCEDURE,CONSULTATION,SPECIALIST,NURSING,DIAGNOSTIC,RADIOLOGY,LABORATORY,BLOOD_SERVICE,REHABILITATION,BED_ACCOMODATION,INTENSIVE_CARE,DRUGS,MEDICAL_EQUIPMENT,DISPENSED_DISPOSABLE,EQUIPMENT_RENTAL,ICD10_CODE,ICD10_DESC,ICD10_TARIFF,ICD9CM_CODE,ICD9CM_DESC,ICD9CM_TARIFF,CHRONIC_DRUGS,CHEMOTHERAPY_DRUGS,CLASS_UPGRADE,HIGH_CARE_UNIT,INACBG_CLAIM_CREATED,INACBG_RESPONSE,TOTAL_INVOICE,ID";
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
	public boolean equals(Object bpjsINACBGClaim) {
		if (this == bpjsINACBGClaim) {
			return true;
		}
		if (bpjsINACBGClaim == null || this.getClass() != bpjsINACBGClaim.getClass()) {
			return false;
		}
		if (!super.equals(bpjsINACBGClaim)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsINACBGClaimEntity that = (BpjsINACBGClaimEntity) bpjsINACBGClaim;
		return
			Objects.equals(this.claimNo, that.claimNo) &&
			Objects.equals(this.patientID, that.patientID) &&
			Objects.equals(this.invoiceNumber, that.invoiceNumber) &&
			Objects.equals(this.bpjsCardNo, that.bpjsCardNo) &&
			Objects.equals(this.sepNo, that.sepNo) &&
			Objects.equals(this.treatmentType, that.treatmentType) &&
			Objects.equals(this.treatmentClass, that.treatmentClass) &&
			Objects.equals(
			     this.admissionDate != null ? this.admissionDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.admissionDate != null ? that.admissionDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.dismissalDate != null ? this.dismissalDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.dismissalDate != null ? that.dismissalDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.los, that.los) &&
			Objects.equals(this.dismissal, that.dismissal) &&
			Objects.equals(this.responsibleDoctor, that.responsibleDoctor) &&
			Objects.equals(this.weight, that.weight) &&
			Objects.equals(this.adl, that.adl) &&
			Objects.equals(this.claimStatus, that.claimStatus) &&
			Objects.equals(this.sepStatus, that.sepStatus) &&
			Objects.equals(this.hospitalTariff, that.hospitalTariff) &&
			Objects.equals(this.referralLetter, that.referralLetter) &&
			Objects.equals(this.thirdSelLevel, that.thirdSelLevel) &&
			Objects.equals(this.staffName, that.staffName) &&
			Objects.equals(
			     this.dateGrouping != null ? this.dateGrouping.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.dateGrouping != null ? that.dateGrouping.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.inacbgTariff, that.inacbgTariff) &&
			Objects.equals(this.description, that.description) &&
			Objects.equals(this.cbgType, that.cbgType) &&
			Objects.equals(this.tariff, that.tariff) &&
			Objects.equals(this.subAcute, that.subAcute) &&
			Objects.equals(this.subAcuteCode, that.subAcuteCode) &&
			Objects.equals(this.subAcuteTariff, that.subAcuteTariff) &&
			Objects.equals(this.chronic, that.chronic) &&
			Objects.equals(this.chronicCode, that.chronicCode) &&
			Objects.equals(this.chronicTariff, that.chronicTariff) &&
			Objects.equals(this.resultSpecProcedure, that.resultSpecProcedure) &&
			Objects.equals(this.resultSpecDrug, that.resultSpecDrug) &&
			Objects.equals(this.resultSpecInvestigation, that.resultSpecInvestigation) &&
			Objects.equals(this.resultSpecProsthesis, that.resultSpecProsthesis) &&
			Objects.equals(this.hospitalClass, that.hospitalClass) &&
			Objects.equals(this.tariffType, that.tariffType) &&
			Objects.equals(this.totalTariff, that.totalTariff) &&
			Objects.equals(
			     this.visitDate != null ? this.visitDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.visitDate != null ? that.visitDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.specProcedureTariff, that.specProcedureTariff) &&
			Objects.equals(this.specDrugTariff, that.specDrugTariff) &&
			Objects.equals(this.specInvestigationTariff, that.specInvestigationTariff) &&
			Objects.equals(this.specProsthesisTariff, that.specProsthesisTariff) &&
			Objects.equals(this.upgradeFlag, that.upgradeFlag) &&
			Objects.equals(this.hcuFlag, that.hcuFlag) &&
			Objects.equals(this.grouperFlag, that.grouperFlag) &&
			Objects.equals(this.nonSurgeryProcedure, that.nonSurgeryProcedure) &&
			Objects.equals(this.surgeryProcedure, that.surgeryProcedure) &&
			Objects.equals(this.consultation, that.consultation) &&
			Objects.equals(this.specialist, that.specialist) &&
			Objects.equals(this.nursing, that.nursing) &&
			Objects.equals(this.diagnostic, that.diagnostic) &&
			Objects.equals(this.radiology, that.radiology) &&
			Objects.equals(this.laboratory, that.laboratory) &&
			Objects.equals(this.bloodService, that.bloodService) &&
			Objects.equals(this.rehabilitation, that.rehabilitation) &&
			Objects.equals(this.bedAccomodation, that.bedAccomodation) &&
			Objects.equals(this.intensiveCare, that.intensiveCare) &&
			Objects.equals(this.drugs, that.drugs) &&
			Objects.equals(this.medicalEquipment, that.medicalEquipment) &&
			Objects.equals(this.dispensedDisposable, that.dispensedDisposable) &&
			Objects.equals(this.equipmentRental, that.equipmentRental) &&
			Objects.equals(this.icd10Code, that.icd10Code) &&
			Objects.equals(this.icd10Desc, that.icd10Desc) &&
			Objects.equals(this.icd10Tariff, that.icd10Tariff) &&
			Objects.equals(this.icd9cmCode, that.icd9cmCode) &&
			Objects.equals(this.icd9cmDesc, that.icd9cmDesc) &&
			Objects.equals(this.icd9cmTariff, that.icd9cmTariff) &&
			Objects.equals(this.chronicDrugs, that.chronicDrugs) &&
			Objects.equals(this.chemotherapyDrugs, that.chemotherapyDrugs) &&
			Objects.equals(this.classUpgrade, that.classUpgrade) &&
			Objects.equals(this.highCareUnit, that.highCareUnit) &&
			Objects.equals(this.inacbgClaimCreated, that.inacbgClaimCreated) &&
			Objects.equals(this.inacbgResponse, that.inacbgResponse) &&
			Objects.equals(this.totalInvoice, that.totalInvoice);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
