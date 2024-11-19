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
import kmsweb.dtos.PatientEmploymentDetailEntityDto;
import kmsweb.entities.listeners.PatientEmploymentDetailEntityListener;
import kmsweb.serializers.PatientEmploymentDetailSerializer;
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
@EntityListeners({PatientEmploymentDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientEmploymentDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PatientEmploymentDetailEntity extends AbstractEntity {

	/**
	 * Takes a PatientEmploymentDetailEntityDto and converts it into a PatientEmploymentDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientEmploymentDetailEntityDto
	 */
	public PatientEmploymentDetailEntity(PatientEmploymentDetailEntityDto patientEmploymentDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientEmploymentDetailEntityDto.getId() != null) {
			this.setId(patientEmploymentDetailEntityDto.getId());
		}

		if (patientEmploymentDetailEntityDto.getEmployeeID() != null) {
			this.setEmployeeID(patientEmploymentDetailEntityDto.getEmployeeID());
		}

		if (patientEmploymentDetailEntityDto.getUniversalID() != null) {
			this.setUniversalID(patientEmploymentDetailEntityDto.getUniversalID());
		}

		if (patientEmploymentDetailEntityDto.getEmployeeType() != null) {
			this.setEmployeeType(patientEmploymentDetailEntityDto.getEmployeeType());
		}

		if (patientEmploymentDetailEntityDto.getOnsiteStatus() != null) {
			this.setOnsiteStatus(patientEmploymentDetailEntityDto.getOnsiteStatus());
		}

		if (patientEmploymentDetailEntityDto.getOccupationalType() != null) {
			this.setOccupationalType(patientEmploymentDetailEntityDto.getOccupationalType());
		}

		if (patientEmploymentDetailEntityDto.getDependantID() != null) {
			this.setDependantID(patientEmploymentDetailEntityDto.getDependantID());
		}

		if (patientEmploymentDetailEntityDto.getDependantType() != null) {
			this.setDependantType(patientEmploymentDetailEntityDto.getDependantType());
		}

		if (patientEmploymentDetailEntityDto.getSponsor() != null) {
			this.setSponsor(patientEmploymentDetailEntityDto.getSponsor());
		}

		if (patientEmploymentDetailEntityDto.getRelationship() != null) {
			this.setRelationship(patientEmploymentDetailEntityDto.getRelationship());
		}

		if (patientEmploymentDetailEntityDto.getCompany() != null) {
			this.setCompany(patientEmploymentDetailEntityDto.getCompany());
		}

		if (patientEmploymentDetailEntityDto.getMedicalStaffCode() != null) {
			this.setMedicalStaffCode(patientEmploymentDetailEntityDto.getMedicalStaffCode());
		}

		if (patientEmploymentDetailEntityDto.getDepartment() != null) {
			this.setDepartment(patientEmploymentDetailEntityDto.getDepartment());
		}

		if (patientEmploymentDetailEntityDto.getPosition() != null) {
			this.setPosition(patientEmploymentDetailEntityDto.getPosition());
		}

		if (patientEmploymentDetailEntityDto.getCostCenter() != null) {
			this.setCostCenter(patientEmploymentDetailEntityDto.getCostCenter());
		}

		if (patientEmploymentDetailEntityDto.getDistrict() != null) {
			this.setDistrict(patientEmploymentDetailEntityDto.getDistrict());
		}

		if (patientEmploymentDetailEntityDto.getDesignatedWorkPlace() != null) {
			this.setDesignatedWorkPlace(patientEmploymentDetailEntityDto.getDesignatedWorkPlace());
		}

		if (patientEmploymentDetailEntityDto.getBureauNo() != null) {
			this.setBureauNo(patientEmploymentDetailEntityDto.getBureauNo());
		}

		if (patientEmploymentDetailEntityDto.getIndustryNo() != null) {
			this.setIndustryNo(patientEmploymentDetailEntityDto.getIndustryNo());
		}

		if (patientEmploymentDetailEntityDto.getEmploymentStartDate() != null) {
			this.setEmploymentStartDate(patientEmploymentDetailEntityDto.getEmploymentStartDate());
		}

		if (patientEmploymentDetailEntityDto.getPassportNo() != null) {
			this.setPassportNo(patientEmploymentDetailEntityDto.getPassportNo());
		}

		if (patientEmploymentDetailEntityDto.getName() != null) {
			this.setName(patientEmploymentDetailEntityDto.getName());
		}

		if (patientEmploymentDetailEntityDto.getPassportCountry() != null) {
			this.setPassportCountry(patientEmploymentDetailEntityDto.getPassportCountry());
		}

		if (patientEmploymentDetailEntityDto.getPostalAddress() != null) {
			this.setPostalAddress(patientEmploymentDetailEntityDto.getPostalAddress());
		}

		if (patientEmploymentDetailEntityDto.getForwardingAddress() != null) {
			this.setForwardingAddress(patientEmploymentDetailEntityDto.getForwardingAddress());
		}

		if (patientEmploymentDetailEntityDto.getLegalDIsability() != null) {
			this.setLegalDIsability(patientEmploymentDetailEntityDto.getLegalDIsability());
		}

		if (patientEmploymentDetailEntityDto.getLegalDisabilityNotes() != null) {
			this.setLegalDisabilityNotes(patientEmploymentDetailEntityDto.getLegalDisabilityNotes());
		}

		if (patientEmploymentDetailEntityDto.getWorkerInsurance() != null) {
			this.setWorkerInsurance(patientEmploymentDetailEntityDto.getWorkerInsurance());
		}

		if (patientEmploymentDetailEntityDto.getWorkerInsuranceNo() != null) {
			this.setWorkerInsuranceNo(patientEmploymentDetailEntityDto.getWorkerInsuranceNo());
		}

		if (patientEmploymentDetailEntityDto.getPatientGeneralInfo() != null) {
			this.setPatientGeneralInfo(patientEmploymentDetailEntityDto.getPatientGeneralInfo());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Employee ID here] off begin
	@CsvBindByName(column = "EMPLOYEE_ID", required = false)
	@Nullable
	@Column(name = "employee_id")
	@Schema(description = "The Employee ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Employee ID here] end
	private String employeeID;

	// % protected region % [Modify attribute annotation for Universal ID here] off begin
	@CsvBindByName(column = "UNIVERSAL_ID", required = false)
	@Nullable
	@Column(name = "universal_id")
	@Schema(description = "The Universal ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Universal ID here] end
	private String universalID;

	// % protected region % [Modify attribute annotation for Employee Type here] off begin
	@CsvBindByName(column = "EMPLOYEE_TYPE", required = false)
	@Nullable
	@Column(name = "employee_type")
	@Schema(description = "The Employee Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Employee Type here] end
	private String employeeType;

	// % protected region % [Modify attribute annotation for Onsite Status here] off begin
	@CsvBindByName(column = "ONSITE_STATUS", required = false)
	@Nullable
	@Column(name = "onsite_status")
	@Schema(description = "The Onsite Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Onsite Status here] end
	private String onsiteStatus;

	// % protected region % [Modify attribute annotation for Occupational Type here] off begin
	@CsvBindByName(column = "OCCUPATIONAL_TYPE", required = false)
	@Nullable
	@Column(name = "occupational_type")
	@Schema(description = "The Occupational Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Occupational Type here] end
	private String occupationalType;

	// % protected region % [Modify attribute annotation for Dependant ID here] off begin
	@CsvBindByName(column = "DEPENDANT_ID", required = false)
	@Nullable
	@Column(name = "dependant_id")
	@Schema(description = "The Dependant ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dependant ID here] end
	private String dependantID;

	// % protected region % [Modify attribute annotation for Dependant Type here] off begin
	@CsvBindByName(column = "DEPENDANT_TYPE", required = false)
	@Nullable
	@Column(name = "dependant_type")
	@Schema(description = "The Dependant Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dependant Type here] end
	private String dependantType;

	// % protected region % [Modify attribute annotation for Sponsor here] off begin
	@CsvBindByName(column = "SPONSOR", required = false)
	@Nullable
	@Column(name = "sponsor")
	@Schema(description = "The Sponsor of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sponsor here] end
	private String sponsor;

	// % protected region % [Modify attribute annotation for Relationship here] off begin
	@CsvBindByName(column = "RELATIONSHIP", required = false)
	@Nullable
	@Column(name = "relationship")
	@Schema(description = "The Relationship of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Relationship here] end
	private String relationship;

	// % protected region % [Modify attribute annotation for Company here] off begin
	@CsvBindByName(column = "COMPANY", required = false)
	@Nullable
	@Column(name = "company")
	@Schema(description = "The Company of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Company here] end
	private String company;

	// % protected region % [Modify attribute annotation for Medical Staff Code here] off begin
	@CsvBindByName(column = "MEDICAL_STAFF_CODE", required = false)
	@Nullable
	@Column(name = "medical_staff_code")
	@Schema(description = "The Medical Staff Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Medical Staff Code here] end
	private String medicalStaffCode;

	// % protected region % [Modify attribute annotation for Department here] off begin
	@CsvBindByName(column = "DEPARTMENT", required = false)
	@Nullable
	@Column(name = "department")
	@Schema(description = "The Department of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Department here] end
	private String department;

	// % protected region % [Modify attribute annotation for Position here] off begin
	@CsvBindByName(column = "POSITION", required = false)
	@Nullable
	@Column(name = "position")
	@Schema(description = "The Position of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Position here] end
	private String position;

	// % protected region % [Modify attribute annotation for Cost Center here] off begin
	@CsvBindByName(column = "COST_CENTER", required = false)
	@Nullable
	@Column(name = "cost_center")
	@Schema(description = "The Cost Center of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Cost Center here] end
	private String costCenter;

	// % protected region % [Modify attribute annotation for District here] off begin
	@CsvBindByName(column = "DISTRICT", required = false)
	@Nullable
	@Column(name = "district")
	@Schema(description = "The District of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for District here] end
	private String district;

	// % protected region % [Modify attribute annotation for Designated Work Place here] off begin
	@CsvBindByName(column = "DESIGNATED_WORK_PLACE", required = false)
	@Nullable
	@Column(name = "designated_work_place")
	@Schema(description = "The Designated Work Place of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Designated Work Place here] end
	private String designatedWorkPlace;

	// % protected region % [Modify attribute annotation for Bureau No here] off begin
	@CsvBindByName(column = "BUREAU_NO", required = false)
	@Nullable
	@Column(name = "bureau_no")
	@Schema(description = "The Bureau No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Bureau No here] end
	private String bureauNo;

	// % protected region % [Modify attribute annotation for Industry No here] off begin
	@CsvBindByName(column = "INDUSTRY_NO", required = false)
	@Nullable
	@Column(name = "industry_no")
	@Schema(description = "The Industry No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Industry No here] end
	private String industryNo;

	// % protected region % [Modify attribute annotation for Employment Start Date here] off begin
	@CsvCustomBindByName(column = "EMPLOYMENT_START_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "employment_start_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Employment Start Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Employment Start Date here] end
	private OffsetDateTime employmentStartDate;

	// % protected region % [Modify attribute annotation for Passport No here] off begin
	@CsvBindByName(column = "PASSPORT_NO", required = false)
	@Nullable
	@Column(name = "passport_no")
	@Schema(description = "The Passport No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Passport No here] end
	private String passportNo;

	// % protected region % [Modify attribute annotation for Name here] off begin
	@CsvBindByName(column = "NAME", required = false)
	@Nullable
	@Column(name = "name")
	@Schema(description = "The Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Name here] end
	private String name;

	// % protected region % [Modify attribute annotation for Passport Country here] off begin
	@CsvBindByName(column = "PASSPORT_COUNTRY", required = false)
	@Nullable
	@Column(name = "passport_country")
	@Schema(description = "The Passport Country of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Passport Country here] end
	private String passportCountry;

	// % protected region % [Modify attribute annotation for Postal Address here] off begin
	@CsvBindByName(column = "POSTAL_ADDRESS", required = false)
	@Nullable
	@Column(name = "postal_address")
	@Schema(description = "The Postal Address of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Postal Address here] end
	private String postalAddress;

	// % protected region % [Modify attribute annotation for Forwarding Address here] off begin
	@CsvBindByName(column = "FORWARDING_ADDRESS", required = false)
	@Nullable
	@Column(name = "forwarding_address")
	@Schema(description = "The Forwarding Address of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Forwarding Address here] end
	private String forwardingAddress;

	// % protected region % [Modify attribute annotation for Legal DIsability here] off begin
	@CsvBindByName(column = "LEGAL_DISABILITY", required = false)
	@Nullable
	@Column(name = "legal_disability")
	@Schema(description = "The Legal DIsability of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Legal DIsability here] end
	private String legalDIsability;

	// % protected region % [Modify attribute annotation for Legal Disability Notes here] off begin
	@CsvBindByName(column = "LEGAL_DISABILITY_NOTES", required = false)
	@Nullable
	@Column(name = "legal_disability_notes")
	@Schema(description = "The Legal Disability Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Legal Disability Notes here] end
	private String legalDisabilityNotes;

	// % protected region % [Modify attribute annotation for Worker Insurance here] off begin
	@CsvBindByName(column = "WORKER_INSURANCE", required = false)
	@Nullable
	@Column(name = "worker_insurance")
	@Schema(description = "The Worker Insurance of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Worker Insurance here] end
	private String workerInsurance;

	// % protected region % [Modify attribute annotation for Worker Insurance No here] off begin
	@CsvBindByName(column = "WORKER_INSURANCE_NO", required = false)
	@Nullable
	@Column(name = "worker_insurance_no")
	@Schema(description = "The Worker Insurance No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Worker Insurance No here] end
	private String workerInsuranceNo;

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

	// % protected region % [Update the annotation for Patient General Info here] off begin
	@Schema(description = "The Patient General Info entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient General Info here] end
	private PatientGeneralInfoEntity patientGeneralInfo;

	// % protected region % [Update the annotation for patientGeneralInfoId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_GENERAL_INFO_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientGeneralInfoId here] end
	private UUID patientGeneralInfoId;

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
	 * Similar to {@link this#setPatientGeneralInfo(PatientGeneralInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientGeneralInfo(PatientGeneralInfoEntity entity) {
		setPatientGeneralInfo(entity, true);
	}

	/**
	 * Set or update the patientGeneralInfo in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInfo
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInfo(PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInfo here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInfo here] end

		if (sameAsFormer(this.patientGeneralInfo, entity)) {
			return;
		}

		if (this.patientGeneralInfo != null) {
			this.patientGeneralInfo.unsetPatientEmploymentDetail(false);
		}

		this.patientGeneralInfo = entity;
		if (reverseAdd) {
			this.patientGeneralInfo.setPatientEmploymentDetail(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInfo incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInfo incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientGeneralInfo(boolean)} but default to true.
	 */
	public void unsetPatientGeneralInfo() {
		this.unsetPatientGeneralInfo(true);
	}

	/**
	 * Remove the PatientGeneralInfoEntity of patientGeneralInfo from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientGeneralInfo(boolean reverse) {
		if (reverse && this.patientGeneralInfo != null) {
			this.patientGeneralInfo.unsetPatientEmploymentDetail();
		}
		this.patientGeneralInfo = null;
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
		return "EMPLOYEE_ID,UNIVERSAL_ID,EMPLOYEE_TYPE,ONSITE_STATUS,OCCUPATIONAL_TYPE,DEPENDANT_ID,DEPENDANT_TYPE,SPONSOR,RELATIONSHIP,COMPANY,MEDICAL_STAFF_CODE,DEPARTMENT,POSITION,COST_CENTER,DISTRICT,DESIGNATED_WORK_PLACE,BUREAU_NO,INDUSTRY_NO,EMPLOYMENT_START_DATE,PASSPORT_NO,NAME,PASSPORT_COUNTRY,POSTAL_ADDRESS,FORWARDING_ADDRESS,LEGAL_DISABILITY,LEGAL_DISABILITY_NOTES,WORKER_INSURANCE,WORKER_INSURANCE_NO,PATIENT_GENERAL_INFO_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<PatientGeneralInfoEntity> patientGeneralInfoRelation = Optional.ofNullable(this.patientGeneralInfo);
		patientGeneralInfoRelation.ifPresent(entity -> this.patientGeneralInfoId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object patientEmploymentDetail) {
		if (this == patientEmploymentDetail) {
			return true;
		}
		if (patientEmploymentDetail == null || this.getClass() != patientEmploymentDetail.getClass()) {
			return false;
		}
		if (!super.equals(patientEmploymentDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientEmploymentDetailEntity that = (PatientEmploymentDetailEntity) patientEmploymentDetail;
		return
			Objects.equals(this.employeeID, that.employeeID) &&
			Objects.equals(this.universalID, that.universalID) &&
			Objects.equals(this.employeeType, that.employeeType) &&
			Objects.equals(this.onsiteStatus, that.onsiteStatus) &&
			Objects.equals(this.occupationalType, that.occupationalType) &&
			Objects.equals(this.dependantID, that.dependantID) &&
			Objects.equals(this.dependantType, that.dependantType) &&
			Objects.equals(this.sponsor, that.sponsor) &&
			Objects.equals(this.relationship, that.relationship) &&
			Objects.equals(this.company, that.company) &&
			Objects.equals(this.medicalStaffCode, that.medicalStaffCode) &&
			Objects.equals(this.department, that.department) &&
			Objects.equals(this.position, that.position) &&
			Objects.equals(this.costCenter, that.costCenter) &&
			Objects.equals(this.district, that.district) &&
			Objects.equals(this.designatedWorkPlace, that.designatedWorkPlace) &&
			Objects.equals(this.bureauNo, that.bureauNo) &&
			Objects.equals(this.industryNo, that.industryNo) &&
			Objects.equals(
			     this.employmentStartDate != null ? this.employmentStartDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.employmentStartDate != null ? that.employmentStartDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.passportNo, that.passportNo) &&
			Objects.equals(this.name, that.name) &&
			Objects.equals(this.passportCountry, that.passportCountry) &&
			Objects.equals(this.postalAddress, that.postalAddress) &&
			Objects.equals(this.forwardingAddress, that.forwardingAddress) &&
			Objects.equals(this.legalDIsability, that.legalDIsability) &&
			Objects.equals(this.legalDisabilityNotes, that.legalDisabilityNotes) &&
			Objects.equals(this.workerInsurance, that.workerInsurance) &&
			Objects.equals(this.workerInsuranceNo, that.workerInsuranceNo) &&
			Objects.equals(this.patientGeneralInfoId, that.patientGeneralInfoId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
