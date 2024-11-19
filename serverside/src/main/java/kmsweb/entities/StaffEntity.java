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
import kmsweb.dtos.StaffEntityDto;
import kmsweb.entities.enums.*;
import kmsweb.services.utils.converters.enums.*;
import kmsweb.entities.listeners.StaffEntityListener;
import kmsweb.serializers.StaffSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.deserializers.DateTimeDeserializer;
import kmsweb.lib.file.models.FileEntity;
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

import java.util.*;
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
@EntityListeners({StaffEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = StaffSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"staff_number"}, name = "staff_number"),
	}
)
public class StaffEntity extends AbstractEntity {

	/**
	 * Takes a StaffEntityDto and converts it into a StaffEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param staffEntityDto
	 */
	public StaffEntity(StaffEntityDto staffEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (staffEntityDto.getId() != null) {
			this.setId(staffEntityDto.getId());
		}

		if (staffEntityDto.getStaffNumber() != null) {
			this.setStaffNumber(staffEntityDto.getStaffNumber());
		}

		if (staffEntityDto.getFirstName() != null) {
			this.setFirstName(staffEntityDto.getFirstName());
		}

		if (staffEntityDto.getLastName() != null) {
			this.setLastName(staffEntityDto.getLastName());
		}

		if (staffEntityDto.getDateOfBirth() != null) {
			this.setDateOfBirth(staffEntityDto.getDateOfBirth());
		}

		if (staffEntityDto.getStaffType() != null) {
			this.setStaffType(staffEntityDto.getStaffType());
		}

		if (staffEntityDto.getSpecialization() != null) {
			this.setSpecialization(staffEntityDto.getSpecialization());
		}

		if (staffEntityDto.getEducation() != null) {
			this.setEducation(staffEntityDto.getEducation());
		}

		if (staffEntityDto.getLicenseNo() != null) {
			this.setLicenseNo(staffEntityDto.getLicenseNo());
		}

		if (staffEntityDto.getLetterOfReg() != null) {
			this.setLetterOfReg(staffEntityDto.getLetterOfReg());
		}

		if (staffEntityDto.getGender() != null) {
			this.setGender(staffEntityDto.getGender());
		}

		if (staffEntityDto.getEmployeeID() != null) {
			this.setEmployeeID(staffEntityDto.getEmployeeID());
		}

		if (staffEntityDto.getTitle() != null) {
			this.setTitle(staffEntityDto.getTitle());
		}

		if (staffEntityDto.getDefaultServiceNumber() != null) {
			this.setDefaultServiceNumber(staffEntityDto.getDefaultServiceNumber());
		}

		if (staffEntityDto.getPlaceOfBirth() != null) {
			this.setPlaceOfBirth(staffEntityDto.getPlaceOfBirth());
		}

		if (staffEntityDto.getReligion() != null) {
			this.setReligion(staffEntityDto.getReligion());
		}

		if (staffEntityDto.getBloodType() != null) {
			this.setBloodType(staffEntityDto.getBloodType());
		}

		if (staffEntityDto.getRhesus() != null) {
			this.setRhesus(staffEntityDto.getRhesus());
		}

		if (staffEntityDto.getAddress() != null) {
			this.setAddress(staffEntityDto.getAddress());
		}

		if (staffEntityDto.getCountry() != null) {
			this.setCountry(staffEntityDto.getCountry());
		}

		if (staffEntityDto.getState() != null) {
			this.setState(staffEntityDto.getState());
		}

		if (staffEntityDto.getRegency() != null) {
			this.setRegency(staffEntityDto.getRegency());
		}

		if (staffEntityDto.getDistrict() != null) {
			this.setDistrict(staffEntityDto.getDistrict());
		}

		if (staffEntityDto.getHomePhoneNo() != null) {
			this.setHomePhoneNo(staffEntityDto.getHomePhoneNo());
		}

		if (staffEntityDto.getVillage() != null) {
			this.setVillage(staffEntityDto.getVillage());
		}

		if (staffEntityDto.getPostcode() != null) {
			this.setPostcode(staffEntityDto.getPostcode());
		}

		if (staffEntityDto.getOfficePhoneNumber() != null) {
			this.setOfficePhoneNumber(staffEntityDto.getOfficePhoneNumber());
		}

		if (staffEntityDto.getTaxIdentificationNo() != null) {
			this.setTaxIdentificationNo(staffEntityDto.getTaxIdentificationNo());
		}

		if (staffEntityDto.getMobilePhoneNo() != null) {
			this.setMobilePhoneNo(staffEntityDto.getMobilePhoneNo());
		}

		if (staffEntityDto.getOtherNotes() != null) {
			this.setOtherNotes(staffEntityDto.getOtherNotes());
		}

		if (staffEntityDto.getTraining() != null) {
			this.setTraining(staffEntityDto.getTraining());
		}

		if (staffEntityDto.getNationality() != null) {
			this.setNationality(staffEntityDto.getNationality());
		}

		if (staffEntityDto.getCertification() != null) {
			this.setCertification(staffEntityDto.getCertification());
		}

		if (staffEntityDto.getExtNo() != null) {
			this.setExtNo(staffEntityDto.getExtNo());
		}

		if (staffEntityDto.getMaritalStatus() != null) {
			this.setMaritalStatus(staffEntityDto.getMaritalStatus());
		}

		if (staffEntityDto.getEmail() != null) {
			this.setEmail(staffEntityDto.getEmail());
		}

		if (staffEntityDto.getAccompanyingConsents() != null) {
			this.setAccompanyingConsents(staffEntityDto.getAccompanyingConsents());
		}

		if (staffEntityDto.getAdministrator() != null) {
			this.setAdministrator(staffEntityDto.getAdministrator());
		}

		if (staffEntityDto.getAmendmentDetails() != null) {
			this.setAmendmentDetails(staffEntityDto.getAmendmentDetails());
		}

		if (staffEntityDto.getAnesthesiaMedicalTranscriber() != null) {
			this.setAnesthesiaMedicalTranscriber(staffEntityDto.getAnesthesiaMedicalTranscriber());
		}

		if (staffEntityDto.getAnesthesiologist() != null) {
			this.setAnesthesiologist(staffEntityDto.getAnesthesiologist());
		}

		if (staffEntityDto.getAnesthesiologyNurse() != null) {
			this.setAnesthesiologyNurse(staffEntityDto.getAnesthesiologyNurse());
		}

		if (staffEntityDto.getBpjsDoctorMapping() != null) {
			this.setBpjsDoctorMapping(staffEntityDto.getBpjsDoctorMapping());
		}

		if (staffEntityDto.getCashierStaff() != null) {
			this.setCashierStaff(staffEntityDto.getCashierStaff());
		}

		if (staffEntityDto.getCoTreatingDoctors() != null) {
			this.setCoTreatingDoctors(staffEntityDto.getCoTreatingDoctors());
		}

		if (staffEntityDto.getDailyCareCPPTsCreatedByStaff() != null) {
			this.setDailyCareCPPTsCreatedByStaff(staffEntityDto.getDailyCareCPPTsCreatedByStaff());
		}

		if (staffEntityDto.getDailyCareCPPTsDoctorInCharge() != null) {
			this.setDailyCareCPPTsDoctorInCharge(staffEntityDto.getDailyCareCPPTsDoctorInCharge());
		}

		if (staffEntityDto.getDailyCareCPPTsMedicalTranscriber() != null) {
			this.setDailyCareCPPTsMedicalTranscriber(staffEntityDto.getDailyCareCPPTsMedicalTranscriber());
		}

		if (staffEntityDto.getDeliveryProgresses() != null) {
			this.setDeliveryProgresses(staffEntityDto.getDeliveryProgresses());
		}

		if (staffEntityDto.getDiagnosticStaffExaminationSummaries() != null) {
			this.setDiagnosticStaffExaminationSummaries(staffEntityDto.getDiagnosticStaffExaminationSummaries());
		}

		if (staffEntityDto.getDismissalReferringStaff() != null) {
			this.setDismissalReferringStaff(staffEntityDto.getDismissalReferringStaff());
		}

		if (staffEntityDto.getDoctorSchedules() != null) {
			this.setDoctorSchedules(staffEntityDto.getDoctorSchedules());
		}

		if (staffEntityDto.getDoctorOnExamination() != null) {
			this.setDoctorOnExamination(staffEntityDto.getDoctorOnExamination());
		}

		if (staffEntityDto.getFluidBalanceDetails() != null) {
			this.setFluidBalanceDetails(staffEntityDto.getFluidBalanceDetails());
		}

		if (staffEntityDto.getHemodialysisMonitorings() != null) {
			this.setHemodialysisMonitorings(staffEntityDto.getHemodialysisMonitorings());
		}

		if (staffEntityDto.getHospitalBranchInformations() != null) {
			this.setHospitalBranchInformations(staffEntityDto.getHospitalBranchInformations());
		}

		if (staffEntityDto.getInformingConsents() != null) {
			this.setInformingConsents(staffEntityDto.getInformingConsents());
		}

		if (staffEntityDto.getInvoices() != null) {
			this.setInvoices(staffEntityDto.getInvoices());
		}

		if (staffEntityDto.getMcuPackageItems() != null) {
			this.setMcuPackageItems(staffEntityDto.getMcuPackageItems());
		}

		if (staffEntityDto.getMedicalCertificateDischargeResumes() != null) {
			this.setMedicalCertificateDischargeResumes(staffEntityDto.getMedicalCertificateDischargeResumes());
		}

		if (staffEntityDto.getMedicalCertificateBirths() != null) {
			this.setMedicalCertificateBirths(staffEntityDto.getMedicalCertificateBirths());
		}

		if (staffEntityDto.getMedicalCertificateHospitalizations() != null) {
			this.setMedicalCertificateHospitalizations(staffEntityDto.getMedicalCertificateHospitalizations());
		}

		if (staffEntityDto.getMedicalExaminationRecordDischargeSummarys() != null) {
			this.setMedicalExaminationRecordDischargeSummarys(staffEntityDto.getMedicalExaminationRecordDischargeSummarys());
		}

		if (staffEntityDto.getMedicalRecordTranscriber() != null) {
			this.setMedicalRecordTranscriber(staffEntityDto.getMedicalRecordTranscriber());
		}

		if (staffEntityDto.getMedicalStaffOfMedicalAttendancesCertificate() != null) {
			this.setMedicalStaffOfMedicalAttendancesCertificate(staffEntityDto.getMedicalStaffOfMedicalAttendancesCertificate());
		}

		if (staffEntityDto.getMedicalStaffOfMentalHealths() != null) {
			this.setMedicalStaffOfMentalHealths(staffEntityDto.getMedicalStaffOfMentalHealths());
		}

		if (staffEntityDto.getMedicalStaffOfPhysicalHealths() != null) {
			this.setMedicalStaffOfPhysicalHealths(staffEntityDto.getMedicalStaffOfPhysicalHealths());
		}

		if (staffEntityDto.getMedicalStaffOfRestrictedWorksCertificate() != null) {
			this.setMedicalStaffOfRestrictedWorksCertificate(staffEntityDto.getMedicalStaffOfRestrictedWorksCertificate());
		}

		if (staffEntityDto.getMedicalStaffOfSickLeavesCertificate() != null) {
			this.setMedicalStaffOfSickLeavesCertificate(staffEntityDto.getMedicalStaffOfSickLeavesCertificate());
		}

		if (staffEntityDto.getMedicationAdministeredHisotries() != null) {
			this.setMedicationAdministeredHisotries(staffEntityDto.getMedicationAdministeredHisotries());
		}

		if (staffEntityDto.getMedicationHeaders() != null) {
			this.setMedicationHeaders(staffEntityDto.getMedicationHeaders());
		}

		if (staffEntityDto.getMidwives() != null) {
			this.setMidwives(staffEntityDto.getMidwives());
		}

		if (staffEntityDto.getNurse() != null) {
			this.setNurse(staffEntityDto.getNurse());
		}

		if (staffEntityDto.getNursingDetailSurgicalNursing() != null) {
			this.setNursingDetailSurgicalNursing(staffEntityDto.getNursingDetailSurgicalNursing());
		}

		if (staffEntityDto.getNursingDetailsAnesthesiaNursing() != null) {
			this.setNursingDetailsAnesthesiaNursing(staffEntityDto.getNursingDetailsAnesthesiaNursing());
		}

		if (staffEntityDto.getPcareDokter() != null) {
			this.setPcareDokter(staffEntityDto.getPcareDokter());
		}

		if (staffEntityDto.getPatientConsents() != null) {
			this.setPatientConsents(staffEntityDto.getPatientConsents());
		}

		if (staffEntityDto.getPatientVitalInformations() != null) {
			this.setPatientVitalInformations(staffEntityDto.getPatientVitalInformations());
		}

		if (staffEntityDto.getPediatricianInCharge() != null) {
			this.setPediatricianInCharge(staffEntityDto.getPediatricianInCharge());
		}

		if (staffEntityDto.getPrescriptionHeaders() != null) {
			this.setPrescriptionHeaders(staffEntityDto.getPrescriptionHeaders());
		}

		if (staffEntityDto.getProcessWorkflowLogs() != null) {
			this.setProcessWorkflowLogs(staffEntityDto.getProcessWorkflowLogs());
		}

		if (staffEntityDto.getRegistrations() != null) {
			this.setRegistrations(staffEntityDto.getRegistrations());
		}

		if (staffEntityDto.getRequestedBy() != null) {
			this.setRequestedBy(staffEntityDto.getRequestedBy());
		}

		if (staffEntityDto.getRoomTransfers() != null) {
			this.setRoomTransfers(staffEntityDto.getRoomTransfers());
		}

		if (staffEntityDto.getSampleCollectionStaffs() != null) {
			this.setSampleCollectionStaffs(staffEntityDto.getSampleCollectionStaffs());
		}

		if (staffEntityDto.getSampleDeliveryStaffs() != null) {
			this.setSampleDeliveryStaffs(staffEntityDto.getSampleDeliveryStaffs());
		}

		if (staffEntityDto.getSampleProcessingStaffs() != null) {
			this.setSampleProcessingStaffs(staffEntityDto.getSampleProcessingStaffs());
		}

		if (staffEntityDto.getService() != null) {
			this.setService(staffEntityDto.getService());
		}

		if (staffEntityDto.getServices() != null) {
			this.setServices(staffEntityDto.getServices());
		}

		if (staffEntityDto.getSurgeon() != null) {
			this.setSurgeon(staffEntityDto.getSurgeon());
		}

		if (staffEntityDto.getSurgicalMedicalTranscriber() != null) {
			this.setSurgicalMedicalTranscriber(staffEntityDto.getSurgicalMedicalTranscriber());
		}

		if (staffEntityDto.getSurgicalNurse() != null) {
			this.setSurgicalNurse(staffEntityDto.getSurgicalNurse());
		}

		if (staffEntityDto.getTransferOrderStockDetails() != null) {
			this.setTransferOrderStockDetails(staffEntityDto.getTransferOrderStockDetails());
		}

		if (staffEntityDto.getVaccinationOrders() != null) {
			this.setVaccinationOrders(staffEntityDto.getVaccinationOrders());
		}

		if (staffEntityDto.getAdministrationUser() != null) {
			this.setAdministrationUser(staffEntityDto.getAdministrationUser());
		}

		if (staffEntityDto.getCashierUser() != null) {
			this.setCashierUser(staffEntityDto.getCashierUser());
		}

		if (staffEntityDto.getClaimUser() != null) {
			this.setClaimUser(staffEntityDto.getClaimUser());
		}

		if (staffEntityDto.getDiagnosticSupportUser() != null) {
			this.setDiagnosticSupportUser(staffEntityDto.getDiagnosticSupportUser());
		}

		if (staffEntityDto.getDoctorUser() != null) {
			this.setDoctorUser(staffEntityDto.getDoctorUser());
		}

		if (staffEntityDto.getFacilityUser() != null) {
			this.setFacilityUser(staffEntityDto.getFacilityUser());
		}

		if (staffEntityDto.getManagementUser() != null) {
			this.setManagementUser(staffEntityDto.getManagementUser());
		}

		if (staffEntityDto.getMedicalRecordUser() != null) {
			this.setMedicalRecordUser(staffEntityDto.getMedicalRecordUser());
		}

		if (staffEntityDto.getMedicalTranscriberUser() != null) {
			this.setMedicalTranscriberUser(staffEntityDto.getMedicalTranscriberUser());
		}

		if (staffEntityDto.getNurseUser() != null) {
			this.setNurseUser(staffEntityDto.getNurseUser());
		}

		if (staffEntityDto.getPharmacyUser() != null) {
			this.setPharmacyUser(staffEntityDto.getPharmacyUser());
		}

		if (staffEntityDto.getPurchasingUser() != null) {
			this.setPurchasingUser(staffEntityDto.getPurchasingUser());
		}

		if (staffEntityDto.getRegistrationUser() != null) {
			this.setRegistrationUser(staffEntityDto.getRegistrationUser());
		}

		if (staffEntityDto.getSystemAdminUser() != null) {
			this.setSystemAdminUser(staffEntityDto.getSystemAdminUser());
		}

		if (staffEntityDto.getWarehouseUser() != null) {
			this.setWarehouseUser(staffEntityDto.getWarehouseUser());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Staff Number here] off begin
	@CsvBindByName(column = "STAFF_NUMBER", required = false)
	@Nullable
	@Column(name = "staff_number")
	@Schema(description = "The Staff Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Staff Number here] end
	private String staffNumber;

	// % protected region % [Modify attribute annotation for First Name here] off begin
	@CsvBindByName(column = "FIRST_NAME", required = true)
	@NotNull(message = "First Name must not be empty")
	@Column(name = "first_name")
	@Schema(description = "The First Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for First Name here] end
	private String firstName;

	// % protected region % [Modify attribute annotation for Last Name here] off begin
	@CsvBindByName(column = "LAST_NAME", required = true)
	@NotNull(message = "Last Name must not be empty")
	@Column(name = "last_name")
	@Schema(description = "The Last Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Last Name here] end
	private String lastName;

	// % protected region % [Modify attribute annotation for Date of Birth here] off begin
	@CsvCustomBindByName(column = "DATE_OF_BIRTH", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "date_of_birth")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Date of Birth of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Date of Birth here] end
	private OffsetDateTime dateOfBirth;

	// % protected region % [Modify attribute annotation for Staff Type here] off begin
	@CsvBindByName(column = "STAFF_TYPE", required = false)
	@Nullable
	@Column(name = "staff_type")
	@Schema(description = "The Staff Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Staff Type here] end
	private String staffType;

	// % protected region % [Modify attribute annotation for Specialization here] off begin
	@CsvBindByName(column = "SPECIALIZATION", required = false)
	@Nullable
	@Column(name = "specialization")
	@Schema(description = "The Specialization of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Specialization here] end
	private String specialization;

	// % protected region % [Modify attribute annotation for Education here] off begin
	@CsvBindByName(column = "EDUCATION", required = false)
	@Nullable
	@Column(name = "education")
	@Schema(description = "The Education of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Education here] end
	private String education;

	// % protected region % [Modify attribute annotation for License No here] off begin
	@CsvBindByName(column = "LICENSE_NO", required = false)
	@Nullable
	@Column(name = "license_no")
	@Schema(description = "The License No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for License No here] end
	private String licenseNo;

	// % protected region % [Modify attribute annotation for Letter of Reg here] off begin
	@CsvBindByName(column = "LETTER_OF_REG", required = false)
	@Nullable
	@Column(name = "letter_of_reg")
	@Schema(description = "The Letter of Reg of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Letter of Reg here] end
	private String letterOfReg;

	// % protected region % [Modify attribute annotation for Gender here] off begin
	@CsvBindByName(column = "GENDER", required = false)
	@Nullable
	@Column(name = "gender")
	@Schema(description = "The Gender of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gender here] end
	private String gender;

	// % protected region % [Modify attribute annotation for Employee ID here] off begin
	@CsvBindByName(column = "EMPLOYEE_ID", required = false)
	@Nullable
	@Column(name = "employee_id")
	@Schema(description = "The Employee ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Employee ID here] end
	private String employeeID;

	// % protected region % [Modify attribute annotation for Title here] off begin
	@CsvBindByName(column = "TITLE", required = false)
	@Nullable
	@Column(name = "title")
	@Schema(description = "The Title of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Title here] end
	private String title;

	// % protected region % [Modify attribute annotation for Default Service Number here] off begin
	@CsvBindByName(column = "DEFAULT_SERVICE_NUMBER", required = false)
	@Nullable
	@Column(name = "default_service_number")
	@Schema(description = "The Default Service Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Default Service Number here] end
	private String defaultServiceNumber;

	// % protected region % [Modify attribute annotation for Place of birth here] off begin
	@CsvBindByName(column = "PLACE_OF_BIRTH", required = false)
	@Nullable
	@Column(name = "place_of_birth")
	@Schema(description = "The Place of birth of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Place of birth here] end
	private String placeOfBirth;

	// % protected region % [Modify attribute annotation for Religion here] off begin
	@CsvBindByName(column = "RELIGION", required = false)
	@Nullable
	@Column(name = "religion")
	@Schema(description = "The Religion of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Religion here] end
	private String religion;

	// % protected region % [Modify attribute annotation for Blood Type here] off begin
	@CsvCustomBindByName(column = "BLOOD_TYPE", required = false, converter = BloodTypeEnumConverter.class)
	@Nullable
	@Column(name = "blood_type")
	@Schema(description = "The Blood Type of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Blood Type here] end
	private BloodTypeEnum bloodType;

	// % protected region % [Modify attribute annotation for Rhesus here] off begin
	@CsvCustomBindByName(column = "RHESUS", required = false, converter = RhesusEnumConverter.class)
	@Nullable
	@Column(name = "rhesus")
	@Schema(description = "The Rhesus of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Rhesus here] end
	private RhesusEnum rhesus;

	// % protected region % [Modify attribute annotation for address here] off begin
	@CsvBindByName(column = "ADDRESS", required = false)
	@Nullable
	@Column(name = "address")
	@Schema(description = "The address of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for address here] end
	private String address;

	// % protected region % [Modify attribute annotation for Country here] off begin
	@CsvBindByName(column = "COUNTRY", required = false)
	@Nullable
	@Column(name = "country")
	@Schema(description = "The Country of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Country here] end
	private String country;

	// % protected region % [Modify attribute annotation for State here] off begin
	@CsvBindByName(column = "STATE", required = false)
	@Nullable
	@Column(name = "state")
	@Schema(description = "The State of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for State here] end
	private String state;

	// % protected region % [Modify attribute annotation for Regency here] off begin
	@CsvBindByName(column = "REGENCY", required = false)
	@Nullable
	@Column(name = "regency")
	@Schema(description = "The Regency of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Regency here] end
	private String regency;

	// % protected region % [Modify attribute annotation for District here] off begin
	@CsvBindByName(column = "DISTRICT", required = false)
	@Nullable
	@Column(name = "district")
	@Schema(description = "The District of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for District here] end
	private String district;

	// % protected region % [Modify attribute annotation for Home phone no here] off begin
	@CsvBindByName(column = "HOME_PHONE_NO", required = false)
	@Nullable
	@Column(name = "home_phone_no")
	@Schema(description = "The Home phone no of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Home phone no here] end
	private String homePhoneNo;

	// % protected region % [Modify attribute annotation for Village here] off begin
	@CsvBindByName(column = "VILLAGE", required = false)
	@Nullable
	@Column(name = "village")
	@Schema(description = "The Village of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Village here] end
	private String village;

	// % protected region % [Modify attribute annotation for Postcode here] off begin
	@CsvBindByName(column = "POSTCODE", required = false)
	@Nullable
	@Column(name = "postcode")
	@Schema(description = "The Postcode of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Postcode here] end
	private String postcode;

	// % protected region % [Modify attribute annotation for Office Phone Number here] off begin
	@CsvBindByName(column = "OFFICE_PHONE_NUMBER", required = false)
	@Nullable
	@Column(name = "office_phone_number")
	@Schema(description = "The Office Phone Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Office Phone Number here] end
	private String officePhoneNumber;

	// % protected region % [Modify attribute annotation for Tax Identification No here] off begin
	@CsvBindByName(column = "TAX_IDENTIFICATION_NO", required = false)
	@Nullable
	@Column(name = "tax_identification_no")
	@Schema(description = "The Tax Identification No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tax Identification No here] end
	private String taxIdentificationNo;

	// % protected region % [Modify attribute annotation for Mobile Phone No here] off begin
	@CsvBindByName(column = "MOBILE_PHONE_NO", required = false)
	@Nullable
	@Column(name = "mobile_phone_no")
	@Schema(description = "The Mobile Phone No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Mobile Phone No here] end
	private String mobilePhoneNo;

	// % protected region % [Modify attribute annotation for Other Notes here] off begin
	@CsvBindByName(column = "OTHER_NOTES", required = false)
	@Nullable
	@Column(name = "other_notes")
	@Schema(description = "The Other Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Other Notes here] end
	private String otherNotes;

	// % protected region % [Modify attribute annotation for Training here] off begin
	@CsvBindByName(column = "TRAINING", required = false)
	@Nullable
	@Column(name = "training")
	@Schema(description = "The Training of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Training here] end
	private String training;

	// % protected region % [Modify attribute annotation for Nationality here] off begin
	@CsvBindByName(column = "NATIONALITY", required = false)
	@Nullable
	@Column(name = "nationality")
	@Schema(description = "The Nationality of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nationality here] end
	private String nationality;

	// % protected region % [Modify attribute annotation for Certification here] off begin
	@CsvBindByName(column = "CERTIFICATION", required = false)
	@Nullable
	@Column(name = "certification")
	@Schema(description = "The Certification of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Certification here] end
	private String certification;

	// % protected region % [Modify attribute annotation for Ext No here] off begin
	@CsvBindByName(column = "EXT_NO", required = false)
	@Nullable
	@Column(name = "ext_no")
	@Schema(description = "The Ext No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ext No here] end
	private String extNo;

	// % protected region % [Modify attribute annotation for Marital Status here] off begin
	@CsvBindByName(column = "MARITAL_STATUS", required = false)
	@Nullable
	@Column(name = "marital_status")
	@Schema(description = "The Marital Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Marital Status here] end
	private String maritalStatus;

	// % protected region % [Modify attribute annotation for email here] off begin
	@CsvBindByName(column = "EMAIL", required = false)
	@Nullable
	@Column(name = "email")
	@Schema(description = "The email of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for email here] end
	private String email;

	@CsvIgnore
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	private Set<FileEntity> staffPicture = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Accompanying Consents here] off begin
	@Schema(description = "The Informed Consent entities that are related to this entity.")
	@OneToMany(mappedBy = "accompanyingStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Accompanying Consents here] end
	private Set<InformedConsentEntity> accompanyingConsents = new HashSet<>();

	// % protected region % [Update the annotation for accompanyingConsentsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "ACCOMPANYING_CONSENTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for accompanyingConsentsIds here] end
	private Set<UUID> accompanyingConsentsIds = new HashSet<>();

	// % protected region % [Update the annotation for Administrator here] off begin
	@Schema(description = "The Administrator entities that are related to this entity.")
	@OneToOne(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Administrator here] end
	private AdministratorEntity administrator;

	// % protected region % [Update the annotation for administratorId here] off begin
	@Transient
	@CsvCustomBindByName(column = "ADMINISTRATOR_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for administratorId here] end
	private UUID administratorId;

	// % protected region % [Update the annotation for Amendment Details here] off begin
	@Schema(description = "The Amendment Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Amendment Details here] end
	private Set<AmendmentDetailEntity> amendmentDetails = new HashSet<>();

	// % protected region % [Update the annotation for amendmentDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "AMENDMENT_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for amendmentDetailsIds here] end
	private Set<UUID> amendmentDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Anesthesia Medical Transcriber here] off begin
	@Schema(description = "The Preoperative Records entities that are related to this entity.")
	@OneToMany(mappedBy = "anesthesiaMedicalTranscriber", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Anesthesia Medical Transcriber here] end
	private Set<PreoperativeRecordsEntity> anesthesiaMedicalTranscriber = new HashSet<>();

	// % protected region % [Update the annotation for anesthesiaMedicalTranscriberIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "ANESTHESIA_MEDICAL_TRANSCRIBER_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for anesthesiaMedicalTranscriberIds here] end
	private Set<UUID> anesthesiaMedicalTranscriberIds = new HashSet<>();

	// % protected region % [Update the annotation for Anesthesiologist here] off begin
	@Schema(description = "The Preoperative Records entities that are related to this entity.")
	@OneToMany(mappedBy = "anesthesiologist", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Anesthesiologist here] end
	private Set<PreoperativeRecordsEntity> anesthesiologist = new HashSet<>();

	// % protected region % [Update the annotation for anesthesiologistIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "ANESTHESIOLOGIST_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for anesthesiologistIds here] end
	private Set<UUID> anesthesiologistIds = new HashSet<>();

	// % protected region % [Update the annotation for Anesthesiology Nurse here] off begin
	@Schema(description = "The Preoperative Records entities that are related to this entity.")
	@OneToMany(mappedBy = "anesthesiologyNurse", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Anesthesiology Nurse here] end
	private Set<PreoperativeRecordsEntity> anesthesiologyNurse = new HashSet<>();

	// % protected region % [Update the annotation for anesthesiologyNurseIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "ANESTHESIOLOGY_NURSE_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for anesthesiologyNurseIds here] end
	private Set<UUID> anesthesiologyNurseIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS Doctor Mapping here] off begin
	@Schema(description = "The BPJS Doctor Mapping entities that are related to this entity.")
	@OneToOne(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Doctor Mapping here] end
	private BpjsDoctorMappingEntity bpjsDoctorMapping;

	// % protected region % [Update the annotation for bpjsDoctorMappingId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_DOCTOR_MAPPING_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsDoctorMappingId here] end
	private UUID bpjsDoctorMappingId;

	// % protected region % [Update the annotation for Cashier Staff here] off begin
	@Schema(description = "The Cash Receipt entities that are related to this entity.")
	@OneToMany(mappedBy = "cashierStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Cashier Staff here] end
	private Set<CashReceiptEntity> cashierStaff = new HashSet<>();

	// % protected region % [Update the annotation for cashierStaffIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "CASHIER_STAFF_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for cashierStaffIds here] end
	private Set<UUID> cashierStaffIds = new HashSet<>();

	// % protected region % [Update the annotation for Co Treating Doctors here] off begin
	@Schema(description = "The Co Treating Doctor entities that are related to this entity.")
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Co Treating Doctors here] end
	private Set<CoTreatingDoctorEntity> coTreatingDoctors = new HashSet<>();

	// % protected region % [Update the annotation for coTreatingDoctorsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "CO_TREATING_DOCTORS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for coTreatingDoctorsIds here] end
	private Set<UUID> coTreatingDoctorsIds = new HashSet<>();

	// % protected region % [Update the annotation for Daily Care CPPTs Created By Staff here] off begin
	@Schema(description = "The Daily Care CPPT entities that are related to this entity.")
	@OneToMany(mappedBy = "createdByStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Daily Care CPPTs Created By Staff here] end
	private Set<DailyCareCPPTEntity> dailyCareCPPTsCreatedByStaff = new HashSet<>();

	// % protected region % [Update the annotation for dailyCareCPPTsCreatedByStaffIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DAILY_CARE_CPPTS_CREATED_BY_STAFF_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for dailyCareCPPTsCreatedByStaffIds here] end
	private Set<UUID> dailyCareCPPTsCreatedByStaffIds = new HashSet<>();

	// % protected region % [Update the annotation for Daily Care CPPTs Doctor in Charge here] off begin
	@Schema(description = "The Daily Care CPPT entities that are related to this entity.")
	@OneToMany(mappedBy = "doctorInCharge", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Daily Care CPPTs Doctor in Charge here] end
	private Set<DailyCareCPPTEntity> dailyCareCPPTsDoctorInCharge = new HashSet<>();

	// % protected region % [Update the annotation for dailyCareCPPTsDoctorInChargeIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DAILY_CARE_CPPTS_DOCTOR_IN_CHARGE_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for dailyCareCPPTsDoctorInChargeIds here] end
	private Set<UUID> dailyCareCPPTsDoctorInChargeIds = new HashSet<>();

	// % protected region % [Update the annotation for Daily Care CPPTs Medical Transcriber here] off begin
	@Schema(description = "The Daily Care CPPT entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalTranscriber", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Daily Care CPPTs Medical Transcriber here] end
	private Set<DailyCareCPPTEntity> dailyCareCPPTsMedicalTranscriber = new HashSet<>();

	// % protected region % [Update the annotation for dailyCareCPPTsMedicalTranscriberIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DAILY_CARE_CPPTS_MEDICAL_TRANSCRIBER_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for dailyCareCPPTsMedicalTranscriberIds here] end
	private Set<UUID> dailyCareCPPTsMedicalTranscriberIds = new HashSet<>();

	// % protected region % [Update the annotation for Delivery Progresses here] off begin
	@Schema(description = "The Delivery Progress entities that are related to this entity.")
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Delivery Progresses here] end
	private Set<DeliveryProgressEntity> deliveryProgresses = new HashSet<>();

	// % protected region % [Update the annotation for deliveryProgressesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DELIVERY_PROGRESSES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for deliveryProgressesIds here] end
	private Set<UUID> deliveryProgressesIds = new HashSet<>();

	// % protected region % [Update the annotation for Diagnostic Staff Examination Summaries here] off begin
	@Schema(description = "The Diagnostic Staff Examination Summary entities that are related to this entity.")
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Diagnostic Staff Examination Summaries here] end
	private Set<DiagnosticStaffExaminationSummaryEntity> diagnosticStaffExaminationSummaries = new HashSet<>();

	// % protected region % [Update the annotation for diagnosticStaffExaminationSummariesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DIAGNOSTIC_STAFF_EXAMINATION_SUMMARIES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for diagnosticStaffExaminationSummariesIds here] end
	private Set<UUID> diagnosticStaffExaminationSummariesIds = new HashSet<>();

	// % protected region % [Update the annotation for Dismissal Referring Staff here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@OneToMany(mappedBy = "dismissalReferringStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Dismissal Referring Staff here] end
	private Set<RegistrationEntity> dismissalReferringStaff = new HashSet<>();

	// % protected region % [Update the annotation for dismissalReferringStaffIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DISMISSAL_REFERRING_STAFF_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for dismissalReferringStaffIds here] end
	private Set<UUID> dismissalReferringStaffIds = new HashSet<>();

	// % protected region % [Update the annotation for Doctor Schedules here] off begin
	@Schema(description = "The Doctor Schedule entities that are related to this entity.")
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Doctor Schedules here] end
	private Set<DoctorScheduleEntity> doctorSchedules = new HashSet<>();

	// % protected region % [Update the annotation for doctorSchedulesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DOCTOR_SCHEDULES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for doctorSchedulesIds here] end
	private Set<UUID> doctorSchedulesIds = new HashSet<>();

	// % protected region % [Update the annotation for Doctor on examination here] off begin
	@Schema(description = "The Medical Examination Record entities that are related to this entity.")
	@OneToMany(mappedBy = "doctor", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Doctor on examination here] end
	private Set<MedicalExaminationRecordEntity> doctorOnExamination = new HashSet<>();

	// % protected region % [Update the annotation for doctorOnExaminationIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DOCTOR_ON_EXAMINATION_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for doctorOnExaminationIds here] end
	private Set<UUID> doctorOnExaminationIds = new HashSet<>();

	// % protected region % [Update the annotation for Fluid Balance Details here] off begin
	@Schema(description = "The Fluid Balance Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Fluid Balance Details here] end
	private Set<FluidBalanceDetailEntity> fluidBalanceDetails = new HashSet<>();

	// % protected region % [Update the annotation for fluidBalanceDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "FLUID_BALANCE_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for fluidBalanceDetailsIds here] end
	private Set<UUID> fluidBalanceDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Hemodialysis Monitorings here] off begin
	@Schema(description = "The Hemodialysis Monitoring entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Hemodialysis Monitorings here] end
	private Set<HemodialysisMonitoringEntity> hemodialysisMonitorings = new HashSet<>();

	// % protected region % [Update the annotation for hemodialysisMonitoringsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "HEMODIALYSIS_MONITORINGS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for hemodialysisMonitoringsIds here] end
	private Set<UUID> hemodialysisMonitoringsIds = new HashSet<>();

	// % protected region % [Update the annotation for Hospital Branch Informations here] off begin
	@Schema(description = "The Hospital Branch Information entities that are related to this entity.")
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Hospital Branch Informations here] end
	private Set<HospitalBranchInformationEntity> hospitalBranchInformations = new HashSet<>();

	// % protected region % [Update the annotation for hospitalBranchInformationsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "HOSPITAL_BRANCH_INFORMATIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for hospitalBranchInformationsIds here] end
	private Set<UUID> hospitalBranchInformationsIds = new HashSet<>();

	// % protected region % [Update the annotation for Informing Consents here] off begin
	@Schema(description = "The Informed Consent entities that are related to this entity.")
	@OneToMany(mappedBy = "informingStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Informing Consents here] end
	private Set<InformedConsentEntity> informingConsents = new HashSet<>();

	// % protected region % [Update the annotation for informingConsentsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INFORMING_CONSENTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for informingConsentsIds here] end
	private Set<UUID> informingConsentsIds = new HashSet<>();

	// % protected region % [Update the annotation for Invoices here] off begin
	@Schema(description = "The Invoice entities that are related to this entity.")
	@OneToMany(mappedBy = "verifiedBy", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoices here] end
	private Set<InvoiceEntity> invoices = new HashSet<>();

	// % protected region % [Update the annotation for invoicesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for invoicesIds here] end
	private Set<UUID> invoicesIds = new HashSet<>();

	// % protected region % [Update the annotation for MCU Package Items here] off begin
	@Schema(description = "The MCU Package Item entities that are related to this entity.")
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for MCU Package Items here] end
	private Set<McuPackageItemEntity> mcuPackageItems = new HashSet<>();

	// % protected region % [Update the annotation for mcuPackageItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MCU_PACKAGE_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for mcuPackageItemsIds here] end
	private Set<UUID> mcuPackageItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Medical Certificate  Discharge Resumes here] off begin
	@Schema(description = "The Medical Certificate  Discharge Resume entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Certificate  Discharge Resumes here] end
	private Set<MedicalCertificateDischargeResumeEntity> medicalCertificateDischargeResumes = new HashSet<>();

	// % protected region % [Update the annotation for medicalCertificateDischargeResumesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_CERTIFICATE_DISCHARGE_RESUMES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicalCertificateDischargeResumesIds here] end
	private Set<UUID> medicalCertificateDischargeResumesIds = new HashSet<>();

	// % protected region % [Update the annotation for Medical Certificate Births here] off begin
	@Schema(description = "The Medical Certificate Birth entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Certificate Births here] end
	private Set<MedicalCertificateBirthEntity> medicalCertificateBirths = new HashSet<>();

	// % protected region % [Update the annotation for medicalCertificateBirthsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_CERTIFICATE_BIRTHS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicalCertificateBirthsIds here] end
	private Set<UUID> medicalCertificateBirthsIds = new HashSet<>();

	// % protected region % [Update the annotation for Medical Certificate Hospitalizations here] off begin
	@Schema(description = "The Medical Certificate Hospitalization entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Certificate Hospitalizations here] end
	private Set<MedicalCertificateHospitalizationEntity> medicalCertificateHospitalizations = new HashSet<>();

	// % protected region % [Update the annotation for medicalCertificateHospitalizationsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_CERTIFICATE_HOSPITALIZATIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicalCertificateHospitalizationsIds here] end
	private Set<UUID> medicalCertificateHospitalizationsIds = new HashSet<>();

	// % protected region % [Update the annotation for Medical Examination Record Discharge Summarys here] off begin
	@Schema(description = "The Medical Examination Record Discharge Summary entities that are related to this entity.")
	@OneToMany(mappedBy = "dischargingDoctor", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Examination Record Discharge Summarys here] end
	private Set<MedicalExaminationRecordDischargeSummaryEntity> medicalExaminationRecordDischargeSummarys = new HashSet<>();

	// % protected region % [Update the annotation for medicalExaminationRecordDischargeSummarysIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARYS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicalExaminationRecordDischargeSummarysIds here] end
	private Set<UUID> medicalExaminationRecordDischargeSummarysIds = new HashSet<>();

	// % protected region % [Update the annotation for Medical Record Transcriber here] off begin
	@Schema(description = "The Medical Examination Record entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalTranscriber", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Record Transcriber here] end
	private Set<MedicalExaminationRecordEntity> medicalRecordTranscriber = new HashSet<>();

	// % protected region % [Update the annotation for medicalRecordTranscriberIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_RECORD_TRANSCRIBER_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicalRecordTranscriberIds here] end
	private Set<UUID> medicalRecordTranscriberIds = new HashSet<>();

	// % protected region % [Update the annotation for Medical Staff of Medical Attendances certificate here] off begin
	@Schema(description = "The Medical Certificate Medical Attendance entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Staff of Medical Attendances certificate here] end
	private Set<MedicalCertificateMedicalAttendanceEntity> medicalStaffOfMedicalAttendancesCertificate = new HashSet<>();

	// % protected region % [Update the annotation for medicalStaffOfMedicalAttendancesCertificateIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_STAFF_OF_MEDICAL_ATTENDANCES_CERTIFICATE_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicalStaffOfMedicalAttendancesCertificateIds here] end
	private Set<UUID> medicalStaffOfMedicalAttendancesCertificateIds = new HashSet<>();

	// % protected region % [Update the annotation for Medical Staff of Mental Healths here] off begin
	@Schema(description = "The Medical Certificate Mental Health entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Staff of Mental Healths here] end
	private Set<MedicalCertificateMentalHealthEntity> medicalStaffOfMentalHealths = new HashSet<>();

	// % protected region % [Update the annotation for medicalStaffOfMentalHealthsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_STAFF_OF_MENTAL_HEALTHS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicalStaffOfMentalHealthsIds here] end
	private Set<UUID> medicalStaffOfMentalHealthsIds = new HashSet<>();

	// % protected region % [Update the annotation for Medical Staff of Physical Healths here] off begin
	@Schema(description = "The Medical Certificate Physical Health entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Staff of Physical Healths here] end
	private Set<MedicalCertificatePhysicalHealthEntity> medicalStaffOfPhysicalHealths = new HashSet<>();

	// % protected region % [Update the annotation for medicalStaffOfPhysicalHealthsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_STAFF_OF_PHYSICAL_HEALTHS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicalStaffOfPhysicalHealthsIds here] end
	private Set<UUID> medicalStaffOfPhysicalHealthsIds = new HashSet<>();

	// % protected region % [Update the annotation for Medical Staff of Restricted Works certificate here] off begin
	@Schema(description = "The Medical Certificate Restricted Work entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Staff of Restricted Works certificate here] end
	private Set<MedicalCertificateRestrictedWorkEntity> medicalStaffOfRestrictedWorksCertificate = new HashSet<>();

	// % protected region % [Update the annotation for medicalStaffOfRestrictedWorksCertificateIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_STAFF_OF_RESTRICTED_WORKS_CERTIFICATE_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicalStaffOfRestrictedWorksCertificateIds here] end
	private Set<UUID> medicalStaffOfRestrictedWorksCertificateIds = new HashSet<>();

	// % protected region % [Update the annotation for Medical Staff of Sick Leaves certificate here] off begin
	@Schema(description = "The Medical Certificate Sick Leave entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Staff of Sick Leaves certificate here] end
	private Set<MedicalCertificateSickLeaveEntity> medicalStaffOfSickLeavesCertificate = new HashSet<>();

	// % protected region % [Update the annotation for medicalStaffOfSickLeavesCertificateIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_STAFF_OF_SICK_LEAVES_CERTIFICATE_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicalStaffOfSickLeavesCertificateIds here] end
	private Set<UUID> medicalStaffOfSickLeavesCertificateIds = new HashSet<>();

	// % protected region % [Update the annotation for Medication Administered Hisotries here] off begin
	@Schema(description = "The Medication Administered History entities that are related to this entity.")
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Administered Hisotries here] end
	private Set<MedicationAdministeredHistoryEntity> medicationAdministeredHisotries = new HashSet<>();

	// % protected region % [Update the annotation for medicationAdministeredHisotriesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_ADMINISTERED_HISOTRIES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicationAdministeredHisotriesIds here] end
	private Set<UUID> medicationAdministeredHisotriesIds = new HashSet<>();

	// % protected region % [Update the annotation for Medication Headers here] off begin
	@Schema(description = "The Medication Header entities that are related to this entity.")
	@OneToMany(mappedBy = "requestedBy", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Headers here] end
	private Set<MedicationHeaderEntity> medicationHeaders = new HashSet<>();

	// % protected region % [Update the annotation for medicationHeadersIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_HEADERS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicationHeadersIds here] end
	private Set<UUID> medicationHeadersIds = new HashSet<>();

	// % protected region % [Update the annotation for Midwives here] off begin
	@Schema(description = "The Delivery Medical Examination Record entities that are related to this entity.")
	@OneToMany(mappedBy = "midwife", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Midwives here] end
	private Set<DeliveryMedicalExaminationRecordEntity> midwives = new HashSet<>();

	// % protected region % [Update the annotation for midwivesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MIDWIVES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for midwivesIds here] end
	private Set<UUID> midwivesIds = new HashSet<>();

	// % protected region % [Update the annotation for Nurse here] off begin
	@Schema(description = "The Medical Examination Record entities that are related to this entity.")
	@OneToMany(mappedBy = "nurse", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Nurse here] end
	private Set<MedicalExaminationRecordEntity> nurse = new HashSet<>();

	// % protected region % [Update the annotation for nurseIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "NURSE_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for nurseIds here] end
	private Set<UUID> nurseIds = new HashSet<>();

	// % protected region % [Update the annotation for Nursing Detail Surgical Nursing here] off begin
	@Schema(description = "The Operating Theater Medical Examination Record entities that are related to this entity.")
	@OneToMany(mappedBy = "nursingDetailSurgicalNursings", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Nursing Detail Surgical Nursing here] end
	private Set<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailSurgicalNursing = new HashSet<>();

	// % protected region % [Update the annotation for nursingDetailSurgicalNursingIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "NURSING_DETAIL_SURGICAL_NURSING_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for nursingDetailSurgicalNursingIds here] end
	private Set<UUID> nursingDetailSurgicalNursingIds = new HashSet<>();

	// % protected region % [Update the annotation for Nursing Details Anesthesia Nursing here] off begin
	@Schema(description = "The Operating Theater Medical Examination Record entities that are related to this entity.")
	@OneToMany(mappedBy = "nursingDetailsAnesthesiaNursings", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Nursing Details Anesthesia Nursing here] end
	private Set<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailsAnesthesiaNursing = new HashSet<>();

	// % protected region % [Update the annotation for nursingDetailsAnesthesiaNursingIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "NURSING_DETAILS_ANESTHESIA_NURSING_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for nursingDetailsAnesthesiaNursingIds here] end
	private Set<UUID> nursingDetailsAnesthesiaNursingIds = new HashSet<>();

	// % protected region % [Update the annotation for PCare Dokter here] off begin
	@Schema(description = "The PCare Dokter entities that are related to this entity.")
	@OneToOne(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for PCare Dokter here] end
	private PcareDokterEntity pcareDokter;

	// % protected region % [Update the annotation for pcareDokterId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PCARE_DOKTER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for pcareDokterId here] end
	private UUID pcareDokterId;

	// % protected region % [Update the annotation for Patient Consents here] off begin
	@Schema(description = "The Patient Consent entities that are related to this entity.")
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Consents here] end
	private Set<PatientConsentEntity> patientConsents = new HashSet<>();

	// % protected region % [Update the annotation for patientConsentsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_CONSENTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for patientConsentsIds here] end
	private Set<UUID> patientConsentsIds = new HashSet<>();

	// % protected region % [Update the annotation for Patient Vital Informations here] off begin
	@Schema(description = "The Patient Vital Information entities that are related to this entity.")
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Vital Informations here] end
	private Set<PatientVitalInformationEntity> patientVitalInformations = new HashSet<>();

	// % protected region % [Update the annotation for patientVitalInformationsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_VITAL_INFORMATIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for patientVitalInformationsIds here] end
	private Set<UUID> patientVitalInformationsIds = new HashSet<>();

	// % protected region % [Update the annotation for Pediatrician In Charge here] off begin
	@Schema(description = "The Newborn Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Pediatrician In Charge here] end
	private Set<NewbornDetailEntity> pediatricianInCharge = new HashSet<>();

	// % protected region % [Update the annotation for pediatricianInChargeIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PEDIATRICIAN_IN_CHARGE_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for pediatricianInChargeIds here] end
	private Set<UUID> pediatricianInChargeIds = new HashSet<>();

	// % protected region % [Update the annotation for Prescription Headers here] off begin
	@Schema(description = "The Prescription Header entities that are related to this entity.")
	@OneToMany(mappedBy = "requestedBy", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Prescription Headers here] end
	private Set<PrescriptionHeaderEntity> prescriptionHeaders = new HashSet<>();

	// % protected region % [Update the annotation for prescriptionHeadersIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRESCRIPTION_HEADERS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for prescriptionHeadersIds here] end
	private Set<UUID> prescriptionHeadersIds = new HashSet<>();

	// % protected region % [Update the annotation for Process Workflow Logs here] off begin
	@Schema(description = "The Process Workflow entities that are related to this entity.")
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Process Workflow Logs here] end
	private Set<ProcessWorkflowEntity> processWorkflowLogs = new HashSet<>();

	// % protected region % [Update the annotation for processWorkflowLogsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PROCESS_WORKFLOW_LOGS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for processWorkflowLogsIds here] end
	private Set<UUID> processWorkflowLogsIds = new HashSet<>();

	// % protected region % [Update the annotation for Registrations here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Registrations here] end
	private Set<RegistrationEntity> registrations = new HashSet<>();

	// % protected region % [Update the annotation for registrationsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "REGISTRATIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for registrationsIds here] end
	private Set<UUID> registrationsIds = new HashSet<>();

	// % protected region % [Update the annotation for Requested By here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@OneToMany(mappedBy = "requestedBy", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Requested By here] end
	private Set<RegistrationEntity> requestedBy = new HashSet<>();

	// % protected region % [Update the annotation for requestedByIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "REQUESTED_BY_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for requestedByIds here] end
	private Set<UUID> requestedByIds = new HashSet<>();

	// % protected region % [Update the annotation for Room Transfers here] off begin
	@Schema(description = "The Room Transfer entities that are related to this entity.")
	@OneToMany(mappedBy = "transferringStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Room Transfers here] end
	private Set<RoomTransferEntity> roomTransfers = new HashSet<>();

	// % protected region % [Update the annotation for roomTransfersIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "ROOM_TRANSFERS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for roomTransfersIds here] end
	private Set<UUID> roomTransfersIds = new HashSet<>();

	// % protected region % [Update the annotation for Sample Collection Staffs here] off begin
	@Schema(description = "The Sample Collection Items entities that are related to this entity.")
	@OneToMany(mappedBy = "sampleCollectionStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Sample Collection Staffs here] end
	private Set<SampleCollectionItemsEntity> sampleCollectionStaffs = new HashSet<>();

	// % protected region % [Update the annotation for sampleCollectionStaffsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SAMPLE_COLLECTION_STAFFS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for sampleCollectionStaffsIds here] end
	private Set<UUID> sampleCollectionStaffsIds = new HashSet<>();

	// % protected region % [Update the annotation for Sample Delivery Staffs here] off begin
	@Schema(description = "The Sample Collection Items entities that are related to this entity.")
	@OneToMany(mappedBy = "sampleDeliveryStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Sample Delivery Staffs here] end
	private Set<SampleCollectionItemsEntity> sampleDeliveryStaffs = new HashSet<>();

	// % protected region % [Update the annotation for sampleDeliveryStaffsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SAMPLE_DELIVERY_STAFFS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for sampleDeliveryStaffsIds here] end
	private Set<UUID> sampleDeliveryStaffsIds = new HashSet<>();

	// % protected region % [Update the annotation for Sample Processing Staffs here] off begin
	@Schema(description = "The Sample Collection Items entities that are related to this entity.")
	@OneToMany(mappedBy = "sampleProcessingStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Sample Processing Staffs here] end
	private Set<SampleCollectionItemsEntity> sampleProcessingStaffs = new HashSet<>();

	// % protected region % [Update the annotation for sampleProcessingStaffsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SAMPLE_PROCESSING_STAFFS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for sampleProcessingStaffsIds here] end
	private Set<UUID> sampleProcessingStaffsIds = new HashSet<>();

	// % protected region % [Update the annotation for Service here] off begin
	@Schema(description = "The Service entities that are related to this entity.")
	@OneToOne(mappedBy = "defaultMedicalStaff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Service here] end
	private ServiceEntity service;

	// % protected region % [Update the annotation for serviceId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SERVICE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for serviceId here] end
	private UUID serviceId;

	// % protected region % [Update the annotation for Services here] off begin
	@Schema(description = "The Service entities that are related to this entity.")
	@ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Services here] end
	private Set<ServiceEntity> services = new HashSet<>();

	// % protected region % [Update the annotation for servicesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SERVICES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for servicesIds here] end
	private Set<UUID> servicesIds = new HashSet<>();

	// % protected region % [Update the annotation for Surgeon here] off begin
	@Schema(description = "The Preoperative Records entities that are related to this entity.")
	@OneToMany(mappedBy = "surgeon", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Surgeon here] end
	private Set<PreoperativeRecordsEntity> surgeon = new HashSet<>();

	// % protected region % [Update the annotation for surgeonIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SURGEON_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for surgeonIds here] end
	private Set<UUID> surgeonIds = new HashSet<>();

	// % protected region % [Update the annotation for Surgical Medical Transcriber here] off begin
	@Schema(description = "The Preoperative Records entities that are related to this entity.")
	@OneToMany(mappedBy = "surgicalMedicalTranscriber", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Surgical Medical Transcriber here] end
	private Set<PreoperativeRecordsEntity> surgicalMedicalTranscriber = new HashSet<>();

	// % protected region % [Update the annotation for surgicalMedicalTranscriberIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SURGICAL_MEDICAL_TRANSCRIBER_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for surgicalMedicalTranscriberIds here] end
	private Set<UUID> surgicalMedicalTranscriberIds = new HashSet<>();

	// % protected region % [Update the annotation for Surgical Nurse here] off begin
	@Schema(description = "The Preoperative Records entities that are related to this entity.")
	@OneToMany(mappedBy = "surgicalNurse", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Surgical Nurse here] end
	private Set<PreoperativeRecordsEntity> surgicalNurse = new HashSet<>();

	// % protected region % [Update the annotation for surgicalNurseIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SURGICAL_NURSE_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for surgicalNurseIds here] end
	private Set<UUID> surgicalNurseIds = new HashSet<>();

	// % protected region % [Update the annotation for Transfer Order Stock Details here] off begin
	@Schema(description = "The Transfer Order Stock Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Transfer Order Stock Details here] end
	private Set<TransferOrderStockDetailEntity> transferOrderStockDetails = new HashSet<>();

	// % protected region % [Update the annotation for transferOrderStockDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "TRANSFER_ORDER_STOCK_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for transferOrderStockDetailsIds here] end
	private Set<UUID> transferOrderStockDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Vaccination Orders here] off begin
	@Schema(description = "The Vaccination Order entities that are related to this entity.")
	@OneToMany(mappedBy = "staff", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Vaccination Orders here] end
	private Set<VaccinationOrderEntity> vaccinationOrders = new HashSet<>();

	// % protected region % [Update the annotation for vaccinationOrdersIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "VACCINATION_ORDERS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for vaccinationOrdersIds here] end
	private Set<UUID> vaccinationOrdersIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Administration User here] off begin
	@Schema(description = "The Administration User entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Administration User here] end
	private AdministrationUserEntity administrationUser;

	// % protected region % [Update the annotation for administrationUserId here] off begin
	@Transient
	@CsvCustomBindByName(column = "ADMINISTRATION_USER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for administrationUserId here] end
	private UUID administrationUserId;

	// % protected region % [Update the annotation for Cashier User here] off begin
	@Schema(description = "The Cashier User entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Cashier User here] end
	private CashierUserEntity cashierUser;

	// % protected region % [Update the annotation for cashierUserId here] off begin
	@Transient
	@CsvCustomBindByName(column = "CASHIER_USER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for cashierUserId here] end
	private UUID cashierUserId;

	// % protected region % [Update the annotation for Claim User here] off begin
	@Schema(description = "The Claim User entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Claim User here] end
	private ClaimUserEntity claimUser;

	// % protected region % [Update the annotation for claimUserId here] off begin
	@Transient
	@CsvCustomBindByName(column = "CLAIM_USER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for claimUserId here] end
	private UUID claimUserId;

	// % protected region % [Update the annotation for Diagnostic Support User here] off begin
	@Schema(description = "The Diagnostic Support User entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Diagnostic Support User here] end
	private DiagnosticSupportUserEntity diagnosticSupportUser;

	// % protected region % [Update the annotation for diagnosticSupportUserId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DIAGNOSTIC_SUPPORT_USER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for diagnosticSupportUserId here] end
	private UUID diagnosticSupportUserId;

	// % protected region % [Update the annotation for Doctor User here] off begin
	@Schema(description = "The Doctor User entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Doctor User here] end
	private DoctorUserEntity doctorUser;

	// % protected region % [Update the annotation for doctorUserId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DOCTOR_USER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for doctorUserId here] end
	private UUID doctorUserId;

	// % protected region % [Update the annotation for Facility User here] off begin
	@Schema(description = "The Facility User entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Facility User here] end
	private FacilityUserEntity facilityUser;

	// % protected region % [Update the annotation for facilityUserId here] off begin
	@Transient
	@CsvCustomBindByName(column = "FACILITY_USER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for facilityUserId here] end
	private UUID facilityUserId;

	// % protected region % [Update the annotation for Management User here] off begin
	@Schema(description = "The Management User entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Management User here] end
	private ManagementUserEntity managementUser;

	// % protected region % [Update the annotation for managementUserId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MANAGEMENT_USER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for managementUserId here] end
	private UUID managementUserId;

	// % protected region % [Update the annotation for Medical Record user here] off begin
	@Schema(description = "The Medical Record user entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Record user here] end
	private MedicalRecordUserEntity medicalRecordUser;

	// % protected region % [Update the annotation for medicalRecordUserId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_RECORD_USER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalRecordUserId here] end
	private UUID medicalRecordUserId;

	// % protected region % [Update the annotation for Medical Transcriber User here] off begin
	@Schema(description = "The Medical Transcriber User entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Transcriber User here] end
	private MedicalTranscriberUserEntity medicalTranscriberUser;

	// % protected region % [Update the annotation for medicalTranscriberUserId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_TRANSCRIBER_USER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalTranscriberUserId here] end
	private UUID medicalTranscriberUserId;

	// % protected region % [Update the annotation for Nurse User here] off begin
	@Schema(description = "The Nurse User entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Nurse User here] end
	private NurseUserEntity nurseUser;

	// % protected region % [Update the annotation for nurseUserId here] off begin
	@Transient
	@CsvCustomBindByName(column = "NURSE_USER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for nurseUserId here] end
	private UUID nurseUserId;

	// % protected region % [Update the annotation for Pharmacy User here] off begin
	@Schema(description = "The Pharmacy User entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Pharmacy User here] end
	private PharmacyUserEntity pharmacyUser;

	// % protected region % [Update the annotation for pharmacyUserId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PHARMACY_USER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for pharmacyUserId here] end
	private UUID pharmacyUserId;

	// % protected region % [Update the annotation for Purchasing User here] off begin
	@Schema(description = "The Purchasing User entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Purchasing User here] end
	private PurchasingUserEntity purchasingUser;

	// % protected region % [Update the annotation for purchasingUserId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PURCHASING_USER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for purchasingUserId here] end
	private UUID purchasingUserId;

	// % protected region % [Update the annotation for Registration User here] off begin
	@Schema(description = "The Registration User entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Registration User here] end
	private RegistrationUserEntity registrationUser;

	// % protected region % [Update the annotation for registrationUserId here] off begin
	@Transient
	@CsvCustomBindByName(column = "REGISTRATION_USER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for registrationUserId here] end
	private UUID registrationUserId;

	// % protected region % [Update the annotation for System Admin User here] off begin
	@Schema(description = "The System Admin User entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for System Admin User here] end
	private SystemAdminUserEntity systemAdminUser;

	// % protected region % [Update the annotation for systemAdminUserId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SYSTEM_ADMIN_USER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for systemAdminUserId here] end
	private UUID systemAdminUserId;

	// % protected region % [Update the annotation for Warehouse User here] off begin
	@Schema(description = "The Warehouse User entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Warehouse User here] end
	private WarehouseUserEntity warehouseUser;

	// % protected region % [Update the annotation for warehouseUserId here] off begin
	@Transient
	@CsvCustomBindByName(column = "WAREHOUSE_USER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for warehouseUserId here] end
	private UUID warehouseUserId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addAccompanyingConsents(InformedConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InformedConsentEntity to be added to this entity
	 */
	public void addAccompanyingConsents(@NotNull InformedConsentEntity entity) {
		addAccompanyingConsents(entity, true);
	}

	/**
	 * Add a new InformedConsentEntity to accompanyingConsents in this entity.
	 *
	 * @param entity the given InformedConsentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAccompanyingConsents(@NonNull InformedConsentEntity entity, boolean reverseAdd) {
		if (!this.accompanyingConsents.contains(entity)) {
			accompanyingConsents.add(entity);
			if (reverseAdd) {
				entity.setAccompanyingStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAccompanyingConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InformedConsentEntity to be added to this entity
	 */
	public void addAccompanyingConsents(@NotNull Collection<InformedConsentEntity> entities) {
		addAccompanyingConsents(entities, true);
	}

	/**
	 * Add a new collection of InformedConsentEntity to Accompanying Consents in this entity.
	 *
	 * @param entities the given collection of InformedConsentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAccompanyingConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAccompanyingConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAccompanyingConsents(InformedConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InformedConsentEntity to be set to this entity
	 */
	public void removeAccompanyingConsents(@NotNull InformedConsentEntity entity) {
		this.removeAccompanyingConsents(entity, true);
	}

	/**
	 * Remove the given InformedConsentEntity from this entity.
	 *
	 * @param entity the given InformedConsentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAccompanyingConsents(@NotNull InformedConsentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAccompanyingStaff(false);
		}
		this.accompanyingConsents.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAccompanyingConsents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InformedConsentEntity to be removed to this entity
	 */
	public void removeAccompanyingConsents(@NotNull Collection<InformedConsentEntity> entities) {
		this.removeAccompanyingConsents(entities, true);
	}

	/**
	 * Remove the given collection of InformedConsentEntity from  to this entity.
	 *
	 * @param entities the given collection of InformedConsentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAccompanyingConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAccompanyingConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAccompanyingConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InformedConsentEntity to be set to this entity
	 */
	public void setAccompanyingConsents(@NotNull Collection<InformedConsentEntity> entities) {
		setAccompanyingConsents(entities, true);
	}

	/**
	 * Replace the current entities in Accompanying Consents with the given ones.
	 *
	 * @param entities the given collection of InformedConsentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAccompanyingConsents(@NotNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {

		this.unsetAccompanyingConsents();
		this.accompanyingConsents = new HashSet<>(entities);
		if (reverseAdd) {
			this.accompanyingConsents.forEach(accompanyingConsentsEntity -> accompanyingConsentsEntity.setAccompanyingStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAccompanyingConsents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAccompanyingConsents() {
		this.unsetAccompanyingConsents(true);
	}

	/**
	 * Remove all the entities in Accompanying Consents from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAccompanyingConsents(boolean doReverse) {
		if (doReverse) {
			this.accompanyingConsents.forEach(accompanyingConsentsEntity -> accompanyingConsentsEntity.unsetAccompanyingStaff(false));
		}
		this.accompanyingConsents.clear();
	}

	/**
	 * Similar to {@link this#setAdministrator(AdministratorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setAdministrator(@NotNull AdministratorEntity entity) {
		setAdministrator(entity, true);
	}

	/**
	 * Set or update administrator with the given AdministratorEntity.
	 *
	 * @param entity the StaffEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdministrator(@NotNull AdministratorEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAdministrator here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAdministrator here] end

		if (sameAsFormer(this.administrator, entity)) {
			return;
		}

		if (this.administrator != null) {
			this.administrator.unsetStaff();
		}

		this.administrator = entity;

		if (reverseAdd) {
			this.administrator.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAdministrator outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAdministrator outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetAdministrator(boolean)} but default to true.
	 */
	public void unsetAdministrator() {
		this.unsetAdministrator(true);
	}

	/**
	 * Remove the AdministratorEntity in Administrator from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAdministrator(boolean reverse) {
		if (reverse && this.administrator != null) {
			this.administrator.unsetStaff(false);
		}
		this.administrator = null;
	}

/**
	 * Similar to {@link this#addAmendmentDetails(AmendmentDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given AmendmentDetailEntity to be added to this entity
	 */
	public void addAmendmentDetails(@NotNull AmendmentDetailEntity entity) {
		addAmendmentDetails(entity, true);
	}

	/**
	 * Add a new AmendmentDetailEntity to amendmentDetails in this entity.
	 *
	 * @param entity the given AmendmentDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAmendmentDetails(@NonNull AmendmentDetailEntity entity, boolean reverseAdd) {
		if (!this.amendmentDetails.contains(entity)) {
			amendmentDetails.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAmendmentDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be added to this entity
	 */
	public void addAmendmentDetails(@NotNull Collection<AmendmentDetailEntity> entities) {
		addAmendmentDetails(entities, true);
	}

	/**
	 * Add a new collection of AmendmentDetailEntity to Amendment Details in this entity.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAmendmentDetails(@NonNull Collection<AmendmentDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAmendmentDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAmendmentDetails(AmendmentDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given AmendmentDetailEntity to be set to this entity
	 */
	public void removeAmendmentDetails(@NotNull AmendmentDetailEntity entity) {
		this.removeAmendmentDetails(entity, true);
	}

	/**
	 * Remove the given AmendmentDetailEntity from this entity.
	 *
	 * @param entity the given AmendmentDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAmendmentDetails(@NotNull AmendmentDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.amendmentDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAmendmentDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be removed to this entity
	 */
	public void removeAmendmentDetails(@NotNull Collection<AmendmentDetailEntity> entities) {
		this.removeAmendmentDetails(entities, true);
	}

	/**
	 * Remove the given collection of AmendmentDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAmendmentDetails(@NonNull Collection<AmendmentDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAmendmentDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAmendmentDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be set to this entity
	 */
	public void setAmendmentDetails(@NotNull Collection<AmendmentDetailEntity> entities) {
		setAmendmentDetails(entities, true);
	}

	/**
	 * Replace the current entities in Amendment Details with the given ones.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAmendmentDetails(@NotNull Collection<AmendmentDetailEntity> entities, boolean reverseAdd) {

		this.unsetAmendmentDetails();
		this.amendmentDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.amendmentDetails.forEach(amendmentDetailsEntity -> amendmentDetailsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAmendmentDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAmendmentDetails() {
		this.unsetAmendmentDetails(true);
	}

	/**
	 * Remove all the entities in Amendment Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAmendmentDetails(boolean doReverse) {
		if (doReverse) {
			this.amendmentDetails.forEach(amendmentDetailsEntity -> amendmentDetailsEntity.unsetStaff(false));
		}
		this.amendmentDetails.clear();
	}

/**
	 * Similar to {@link this#addAnesthesiaMedicalTranscriber(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be added to this entity
	 */
	public void addAnesthesiaMedicalTranscriber(@NotNull PreoperativeRecordsEntity entity) {
		addAnesthesiaMedicalTranscriber(entity, true);
	}

	/**
	 * Add a new PreoperativeRecordsEntity to anesthesiaMedicalTranscriber in this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAnesthesiaMedicalTranscriber(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		if (!this.anesthesiaMedicalTranscriber.contains(entity)) {
			anesthesiaMedicalTranscriber.add(entity);
			if (reverseAdd) {
				entity.setAnesthesiaMedicalTranscriber(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAnesthesiaMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 */
	public void addAnesthesiaMedicalTranscriber(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		addAnesthesiaMedicalTranscriber(entities, true);
	}

	/**
	 * Add a new collection of PreoperativeRecordsEntity to Anesthesia Medical Transcriber in this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAnesthesiaMedicalTranscriber(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAnesthesiaMedicalTranscriber(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAnesthesiaMedicalTranscriber(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void removeAnesthesiaMedicalTranscriber(@NotNull PreoperativeRecordsEntity entity) {
		this.removeAnesthesiaMedicalTranscriber(entity, true);
	}

	/**
	 * Remove the given PreoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAnesthesiaMedicalTranscriber(@NotNull PreoperativeRecordsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAnesthesiaMedicalTranscriber(false);
		}
		this.anesthesiaMedicalTranscriber.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAnesthesiaMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 */
	public void removeAnesthesiaMedicalTranscriber(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		this.removeAnesthesiaMedicalTranscriber(entities, true);
	}

	/**
	 * Remove the given collection of PreoperativeRecordsEntity from  to this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAnesthesiaMedicalTranscriber(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAnesthesiaMedicalTranscriber(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAnesthesiaMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be set to this entity
	 */
	public void setAnesthesiaMedicalTranscriber(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		setAnesthesiaMedicalTranscriber(entities, true);
	}

	/**
	 * Replace the current entities in Anesthesia Medical Transcriber with the given ones.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAnesthesiaMedicalTranscriber(@NotNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {

		this.unsetAnesthesiaMedicalTranscriber();
		this.anesthesiaMedicalTranscriber = new HashSet<>(entities);
		if (reverseAdd) {
			this.anesthesiaMedicalTranscriber.forEach(anesthesiaMedicalTranscriberEntity -> anesthesiaMedicalTranscriberEntity.setAnesthesiaMedicalTranscriber(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAnesthesiaMedicalTranscriber(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAnesthesiaMedicalTranscriber() {
		this.unsetAnesthesiaMedicalTranscriber(true);
	}

	/**
	 * Remove all the entities in Anesthesia Medical Transcriber from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAnesthesiaMedicalTranscriber(boolean doReverse) {
		if (doReverse) {
			this.anesthesiaMedicalTranscriber.forEach(anesthesiaMedicalTranscriberEntity -> anesthesiaMedicalTranscriberEntity.unsetAnesthesiaMedicalTranscriber(false));
		}
		this.anesthesiaMedicalTranscriber.clear();
	}

/**
	 * Similar to {@link this#addAnesthesiologist(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be added to this entity
	 */
	public void addAnesthesiologist(@NotNull PreoperativeRecordsEntity entity) {
		addAnesthesiologist(entity, true);
	}

	/**
	 * Add a new PreoperativeRecordsEntity to anesthesiologist in this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAnesthesiologist(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		if (!this.anesthesiologist.contains(entity)) {
			anesthesiologist.add(entity);
			if (reverseAdd) {
				entity.setAnesthesiologist(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAnesthesiologist(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 */
	public void addAnesthesiologist(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		addAnesthesiologist(entities, true);
	}

	/**
	 * Add a new collection of PreoperativeRecordsEntity to Anesthesiologist in this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAnesthesiologist(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAnesthesiologist(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAnesthesiologist(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void removeAnesthesiologist(@NotNull PreoperativeRecordsEntity entity) {
		this.removeAnesthesiologist(entity, true);
	}

	/**
	 * Remove the given PreoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAnesthesiologist(@NotNull PreoperativeRecordsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAnesthesiologist(false);
		}
		this.anesthesiologist.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAnesthesiologist(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 */
	public void removeAnesthesiologist(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		this.removeAnesthesiologist(entities, true);
	}

	/**
	 * Remove the given collection of PreoperativeRecordsEntity from  to this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAnesthesiologist(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAnesthesiologist(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAnesthesiologist(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be set to this entity
	 */
	public void setAnesthesiologist(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		setAnesthesiologist(entities, true);
	}

	/**
	 * Replace the current entities in Anesthesiologist with the given ones.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAnesthesiologist(@NotNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {

		this.unsetAnesthesiologist();
		this.anesthesiologist = new HashSet<>(entities);
		if (reverseAdd) {
			this.anesthesiologist.forEach(anesthesiologistEntity -> anesthesiologistEntity.setAnesthesiologist(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAnesthesiologist(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAnesthesiologist() {
		this.unsetAnesthesiologist(true);
	}

	/**
	 * Remove all the entities in Anesthesiologist from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAnesthesiologist(boolean doReverse) {
		if (doReverse) {
			this.anesthesiologist.forEach(anesthesiologistEntity -> anesthesiologistEntity.unsetAnesthesiologist(false));
		}
		this.anesthesiologist.clear();
	}

/**
	 * Similar to {@link this#addAnesthesiologyNurse(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be added to this entity
	 */
	public void addAnesthesiologyNurse(@NotNull PreoperativeRecordsEntity entity) {
		addAnesthesiologyNurse(entity, true);
	}

	/**
	 * Add a new PreoperativeRecordsEntity to anesthesiologyNurse in this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAnesthesiologyNurse(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		if (!this.anesthesiologyNurse.contains(entity)) {
			anesthesiologyNurse.add(entity);
			if (reverseAdd) {
				entity.setAnesthesiologyNurse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAnesthesiologyNurse(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 */
	public void addAnesthesiologyNurse(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		addAnesthesiologyNurse(entities, true);
	}

	/**
	 * Add a new collection of PreoperativeRecordsEntity to Anesthesiology Nurse in this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAnesthesiologyNurse(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAnesthesiologyNurse(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAnesthesiologyNurse(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void removeAnesthesiologyNurse(@NotNull PreoperativeRecordsEntity entity) {
		this.removeAnesthesiologyNurse(entity, true);
	}

	/**
	 * Remove the given PreoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAnesthesiologyNurse(@NotNull PreoperativeRecordsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAnesthesiologyNurse(false);
		}
		this.anesthesiologyNurse.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAnesthesiologyNurse(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 */
	public void removeAnesthesiologyNurse(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		this.removeAnesthesiologyNurse(entities, true);
	}

	/**
	 * Remove the given collection of PreoperativeRecordsEntity from  to this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAnesthesiologyNurse(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAnesthesiologyNurse(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAnesthesiologyNurse(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be set to this entity
	 */
	public void setAnesthesiologyNurse(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		setAnesthesiologyNurse(entities, true);
	}

	/**
	 * Replace the current entities in Anesthesiology Nurse with the given ones.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAnesthesiologyNurse(@NotNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {

		this.unsetAnesthesiologyNurse();
		this.anesthesiologyNurse = new HashSet<>(entities);
		if (reverseAdd) {
			this.anesthesiologyNurse.forEach(anesthesiologyNurseEntity -> anesthesiologyNurseEntity.setAnesthesiologyNurse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAnesthesiologyNurse(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAnesthesiologyNurse() {
		this.unsetAnesthesiologyNurse(true);
	}

	/**
	 * Remove all the entities in Anesthesiology Nurse from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAnesthesiologyNurse(boolean doReverse) {
		if (doReverse) {
			this.anesthesiologyNurse.forEach(anesthesiologyNurseEntity -> anesthesiologyNurseEntity.unsetAnesthesiologyNurse(false));
		}
		this.anesthesiologyNurse.clear();
	}

	/**
	 * Similar to {@link this#setBpjsDoctorMapping(BpjsDoctorMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setBpjsDoctorMapping(@NotNull BpjsDoctorMappingEntity entity) {
		setBpjsDoctorMapping(entity, true);
	}

	/**
	 * Set or update bpjsDoctorMapping with the given BpjsDoctorMappingEntity.
	 *
	 * @param entity the StaffEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsDoctorMapping(@NotNull BpjsDoctorMappingEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsDoctorMapping here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsDoctorMapping here] end

		if (sameAsFormer(this.bpjsDoctorMapping, entity)) {
			return;
		}

		if (this.bpjsDoctorMapping != null) {
			this.bpjsDoctorMapping.unsetStaff();
		}

		this.bpjsDoctorMapping = entity;

		if (reverseAdd) {
			this.bpjsDoctorMapping.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsDoctorMapping outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsDoctorMapping outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsDoctorMapping(boolean)} but default to true.
	 */
	public void unsetBpjsDoctorMapping() {
		this.unsetBpjsDoctorMapping(true);
	}

	/**
	 * Remove the BpjsDoctorMappingEntity in BPJS Doctor Mapping from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsDoctorMapping(boolean reverse) {
		if (reverse && this.bpjsDoctorMapping != null) {
			this.bpjsDoctorMapping.unsetStaff(false);
		}
		this.bpjsDoctorMapping = null;
	}

/**
	 * Similar to {@link this#addCashierStaff(CashReceiptEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashReceiptEntity to be added to this entity
	 */
	public void addCashierStaff(@NotNull CashReceiptEntity entity) {
		addCashierStaff(entity, true);
	}

	/**
	 * Add a new CashReceiptEntity to cashierStaff in this entity.
	 *
	 * @param entity the given CashReceiptEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCashierStaff(@NonNull CashReceiptEntity entity, boolean reverseAdd) {
		if (!this.cashierStaff.contains(entity)) {
			cashierStaff.add(entity);
			if (reverseAdd) {
				entity.setCashierStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCashierStaff(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CashReceiptEntity to be added to this entity
	 */
	public void addCashierStaff(@NotNull Collection<CashReceiptEntity> entities) {
		addCashierStaff(entities, true);
	}

	/**
	 * Add a new collection of CashReceiptEntity to Cashier Staff in this entity.
	 *
	 * @param entities the given collection of CashReceiptEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCashierStaff(@NonNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCashierStaff(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCashierStaff(CashReceiptEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashReceiptEntity to be set to this entity
	 */
	public void removeCashierStaff(@NotNull CashReceiptEntity entity) {
		this.removeCashierStaff(entity, true);
	}

	/**
	 * Remove the given CashReceiptEntity from this entity.
	 *
	 * @param entity the given CashReceiptEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCashierStaff(@NotNull CashReceiptEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetCashierStaff(false);
		}
		this.cashierStaff.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCashierStaff(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CashReceiptEntity to be removed to this entity
	 */
	public void removeCashierStaff(@NotNull Collection<CashReceiptEntity> entities) {
		this.removeCashierStaff(entities, true);
	}

	/**
	 * Remove the given collection of CashReceiptEntity from  to this entity.
	 *
	 * @param entities the given collection of CashReceiptEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCashierStaff(@NonNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCashierStaff(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCashierStaff(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CashReceiptEntity to be set to this entity
	 */
	public void setCashierStaff(@NotNull Collection<CashReceiptEntity> entities) {
		setCashierStaff(entities, true);
	}

	/**
	 * Replace the current entities in Cashier Staff with the given ones.
	 *
	 * @param entities the given collection of CashReceiptEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCashierStaff(@NotNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {

		this.unsetCashierStaff();
		this.cashierStaff = new HashSet<>(entities);
		if (reverseAdd) {
			this.cashierStaff.forEach(cashierStaffEntity -> cashierStaffEntity.setCashierStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCashierStaff(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCashierStaff() {
		this.unsetCashierStaff(true);
	}

	/**
	 * Remove all the entities in Cashier Staff from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCashierStaff(boolean doReverse) {
		if (doReverse) {
			this.cashierStaff.forEach(cashierStaffEntity -> cashierStaffEntity.unsetCashierStaff(false));
		}
		this.cashierStaff.clear();
	}

/**
	 * Similar to {@link this#addCoTreatingDoctors(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be added to this entity
	 */
	public void addCoTreatingDoctors(@NotNull CoTreatingDoctorEntity entity) {
		addCoTreatingDoctors(entity, true);
	}

	/**
	 * Add a new CoTreatingDoctorEntity to coTreatingDoctors in this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCoTreatingDoctors(@NonNull CoTreatingDoctorEntity entity, boolean reverseAdd) {
		if (!this.coTreatingDoctors.contains(entity)) {
			coTreatingDoctors.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCoTreatingDoctors(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 */
	public void addCoTreatingDoctors(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		addCoTreatingDoctors(entities, true);
	}

	/**
	 * Add a new collection of CoTreatingDoctorEntity to Co Treating Doctors in this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCoTreatingDoctors(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCoTreatingDoctors(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCoTreatingDoctors(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be set to this entity
	 */
	public void removeCoTreatingDoctors(@NotNull CoTreatingDoctorEntity entity) {
		this.removeCoTreatingDoctors(entity, true);
	}

	/**
	 * Remove the given CoTreatingDoctorEntity from this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCoTreatingDoctors(@NotNull CoTreatingDoctorEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.coTreatingDoctors.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCoTreatingDoctors(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 */
	public void removeCoTreatingDoctors(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		this.removeCoTreatingDoctors(entities, true);
	}

	/**
	 * Remove the given collection of CoTreatingDoctorEntity from  to this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCoTreatingDoctors(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCoTreatingDoctors(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCoTreatingDoctors(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be set to this entity
	 */
	public void setCoTreatingDoctors(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		setCoTreatingDoctors(entities, true);
	}

	/**
	 * Replace the current entities in Co Treating Doctors with the given ones.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCoTreatingDoctors(@NotNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {

		this.unsetCoTreatingDoctors();
		this.coTreatingDoctors = new HashSet<>(entities);
		if (reverseAdd) {
			this.coTreatingDoctors.forEach(coTreatingDoctorsEntity -> coTreatingDoctorsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCoTreatingDoctors(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCoTreatingDoctors() {
		this.unsetCoTreatingDoctors(true);
	}

	/**
	 * Remove all the entities in Co Treating Doctors from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCoTreatingDoctors(boolean doReverse) {
		if (doReverse) {
			this.coTreatingDoctors.forEach(coTreatingDoctorsEntity -> coTreatingDoctorsEntity.unsetStaff(false));
		}
		this.coTreatingDoctors.clear();
	}

/**
	 * Similar to {@link this#addDailyCareCPPTsCreatedByStaff(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be added to this entity
	 */
	public void addDailyCareCPPTsCreatedByStaff(@NotNull DailyCareCPPTEntity entity) {
		addDailyCareCPPTsCreatedByStaff(entity, true);
	}

	/**
	 * Add a new DailyCareCPPTEntity to dailyCareCPPTsCreatedByStaff in this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDailyCareCPPTsCreatedByStaff(@NonNull DailyCareCPPTEntity entity, boolean reverseAdd) {
		if (!this.dailyCareCPPTsCreatedByStaff.contains(entity)) {
			dailyCareCPPTsCreatedByStaff.add(entity);
			if (reverseAdd) {
				entity.setCreatedByStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDailyCareCPPTsCreatedByStaff(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 */
	public void addDailyCareCPPTsCreatedByStaff(@NotNull Collection<DailyCareCPPTEntity> entities) {
		addDailyCareCPPTsCreatedByStaff(entities, true);
	}

	/**
	 * Add a new collection of DailyCareCPPTEntity to Daily Care CPPTs Created By Staff in this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDailyCareCPPTsCreatedByStaff(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDailyCareCPPTsCreatedByStaff(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDailyCareCPPTsCreatedByStaff(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be set to this entity
	 */
	public void removeDailyCareCPPTsCreatedByStaff(@NotNull DailyCareCPPTEntity entity) {
		this.removeDailyCareCPPTsCreatedByStaff(entity, true);
	}

	/**
	 * Remove the given DailyCareCPPTEntity from this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDailyCareCPPTsCreatedByStaff(@NotNull DailyCareCPPTEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetCreatedByStaff(false);
		}
		this.dailyCareCPPTsCreatedByStaff.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDailyCareCPPTsCreatedByStaff(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 */
	public void removeDailyCareCPPTsCreatedByStaff(@NotNull Collection<DailyCareCPPTEntity> entities) {
		this.removeDailyCareCPPTsCreatedByStaff(entities, true);
	}

	/**
	 * Remove the given collection of DailyCareCPPTEntity from  to this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDailyCareCPPTsCreatedByStaff(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDailyCareCPPTsCreatedByStaff(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDailyCareCPPTsCreatedByStaff(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be set to this entity
	 */
	public void setDailyCareCPPTsCreatedByStaff(@NotNull Collection<DailyCareCPPTEntity> entities) {
		setDailyCareCPPTsCreatedByStaff(entities, true);
	}

	/**
	 * Replace the current entities in Daily Care CPPTs Created By Staff with the given ones.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDailyCareCPPTsCreatedByStaff(@NotNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {

		this.unsetDailyCareCPPTsCreatedByStaff();
		this.dailyCareCPPTsCreatedByStaff = new HashSet<>(entities);
		if (reverseAdd) {
			this.dailyCareCPPTsCreatedByStaff.forEach(dailyCareCPPTsCreatedByStaffEntity -> dailyCareCPPTsCreatedByStaffEntity.setCreatedByStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDailyCareCPPTsCreatedByStaff(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDailyCareCPPTsCreatedByStaff() {
		this.unsetDailyCareCPPTsCreatedByStaff(true);
	}

	/**
	 * Remove all the entities in Daily Care CPPTs Created By Staff from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDailyCareCPPTsCreatedByStaff(boolean doReverse) {
		if (doReverse) {
			this.dailyCareCPPTsCreatedByStaff.forEach(dailyCareCPPTsCreatedByStaffEntity -> dailyCareCPPTsCreatedByStaffEntity.unsetCreatedByStaff(false));
		}
		this.dailyCareCPPTsCreatedByStaff.clear();
	}

/**
	 * Similar to {@link this#addDailyCareCPPTsDoctorInCharge(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be added to this entity
	 */
	public void addDailyCareCPPTsDoctorInCharge(@NotNull DailyCareCPPTEntity entity) {
		addDailyCareCPPTsDoctorInCharge(entity, true);
	}

	/**
	 * Add a new DailyCareCPPTEntity to dailyCareCPPTsDoctorInCharge in this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDailyCareCPPTsDoctorInCharge(@NonNull DailyCareCPPTEntity entity, boolean reverseAdd) {
		if (!this.dailyCareCPPTsDoctorInCharge.contains(entity)) {
			dailyCareCPPTsDoctorInCharge.add(entity);
			if (reverseAdd) {
				entity.setDoctorInCharge(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDailyCareCPPTsDoctorInCharge(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 */
	public void addDailyCareCPPTsDoctorInCharge(@NotNull Collection<DailyCareCPPTEntity> entities) {
		addDailyCareCPPTsDoctorInCharge(entities, true);
	}

	/**
	 * Add a new collection of DailyCareCPPTEntity to Daily Care CPPTs Doctor in Charge in this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDailyCareCPPTsDoctorInCharge(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDailyCareCPPTsDoctorInCharge(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDailyCareCPPTsDoctorInCharge(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be set to this entity
	 */
	public void removeDailyCareCPPTsDoctorInCharge(@NotNull DailyCareCPPTEntity entity) {
		this.removeDailyCareCPPTsDoctorInCharge(entity, true);
	}

	/**
	 * Remove the given DailyCareCPPTEntity from this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDailyCareCPPTsDoctorInCharge(@NotNull DailyCareCPPTEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDoctorInCharge(false);
		}
		this.dailyCareCPPTsDoctorInCharge.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDailyCareCPPTsDoctorInCharge(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 */
	public void removeDailyCareCPPTsDoctorInCharge(@NotNull Collection<DailyCareCPPTEntity> entities) {
		this.removeDailyCareCPPTsDoctorInCharge(entities, true);
	}

	/**
	 * Remove the given collection of DailyCareCPPTEntity from  to this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDailyCareCPPTsDoctorInCharge(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDailyCareCPPTsDoctorInCharge(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDailyCareCPPTsDoctorInCharge(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be set to this entity
	 */
	public void setDailyCareCPPTsDoctorInCharge(@NotNull Collection<DailyCareCPPTEntity> entities) {
		setDailyCareCPPTsDoctorInCharge(entities, true);
	}

	/**
	 * Replace the current entities in Daily Care CPPTs Doctor in Charge with the given ones.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDailyCareCPPTsDoctorInCharge(@NotNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {

		this.unsetDailyCareCPPTsDoctorInCharge();
		this.dailyCareCPPTsDoctorInCharge = new HashSet<>(entities);
		if (reverseAdd) {
			this.dailyCareCPPTsDoctorInCharge.forEach(dailyCareCPPTsDoctorInChargeEntity -> dailyCareCPPTsDoctorInChargeEntity.setDoctorInCharge(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDailyCareCPPTsDoctorInCharge(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDailyCareCPPTsDoctorInCharge() {
		this.unsetDailyCareCPPTsDoctorInCharge(true);
	}

	/**
	 * Remove all the entities in Daily Care CPPTs Doctor in Charge from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDailyCareCPPTsDoctorInCharge(boolean doReverse) {
		if (doReverse) {
			this.dailyCareCPPTsDoctorInCharge.forEach(dailyCareCPPTsDoctorInChargeEntity -> dailyCareCPPTsDoctorInChargeEntity.unsetDoctorInCharge(false));
		}
		this.dailyCareCPPTsDoctorInCharge.clear();
	}

/**
	 * Similar to {@link this#addDailyCareCPPTsMedicalTranscriber(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be added to this entity
	 */
	public void addDailyCareCPPTsMedicalTranscriber(@NotNull DailyCareCPPTEntity entity) {
		addDailyCareCPPTsMedicalTranscriber(entity, true);
	}

	/**
	 * Add a new DailyCareCPPTEntity to dailyCareCPPTsMedicalTranscriber in this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDailyCareCPPTsMedicalTranscriber(@NonNull DailyCareCPPTEntity entity, boolean reverseAdd) {
		if (!this.dailyCareCPPTsMedicalTranscriber.contains(entity)) {
			dailyCareCPPTsMedicalTranscriber.add(entity);
			if (reverseAdd) {
				entity.setMedicalTranscriber(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDailyCareCPPTsMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 */
	public void addDailyCareCPPTsMedicalTranscriber(@NotNull Collection<DailyCareCPPTEntity> entities) {
		addDailyCareCPPTsMedicalTranscriber(entities, true);
	}

	/**
	 * Add a new collection of DailyCareCPPTEntity to Daily Care CPPTs Medical Transcriber in this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDailyCareCPPTsMedicalTranscriber(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDailyCareCPPTsMedicalTranscriber(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDailyCareCPPTsMedicalTranscriber(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be set to this entity
	 */
	public void removeDailyCareCPPTsMedicalTranscriber(@NotNull DailyCareCPPTEntity entity) {
		this.removeDailyCareCPPTsMedicalTranscriber(entity, true);
	}

	/**
	 * Remove the given DailyCareCPPTEntity from this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDailyCareCPPTsMedicalTranscriber(@NotNull DailyCareCPPTEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalTranscriber(false);
		}
		this.dailyCareCPPTsMedicalTranscriber.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDailyCareCPPTsMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 */
	public void removeDailyCareCPPTsMedicalTranscriber(@NotNull Collection<DailyCareCPPTEntity> entities) {
		this.removeDailyCareCPPTsMedicalTranscriber(entities, true);
	}

	/**
	 * Remove the given collection of DailyCareCPPTEntity from  to this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDailyCareCPPTsMedicalTranscriber(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDailyCareCPPTsMedicalTranscriber(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDailyCareCPPTsMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be set to this entity
	 */
	public void setDailyCareCPPTsMedicalTranscriber(@NotNull Collection<DailyCareCPPTEntity> entities) {
		setDailyCareCPPTsMedicalTranscriber(entities, true);
	}

	/**
	 * Replace the current entities in Daily Care CPPTs Medical Transcriber with the given ones.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDailyCareCPPTsMedicalTranscriber(@NotNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {

		this.unsetDailyCareCPPTsMedicalTranscriber();
		this.dailyCareCPPTsMedicalTranscriber = new HashSet<>(entities);
		if (reverseAdd) {
			this.dailyCareCPPTsMedicalTranscriber.forEach(dailyCareCPPTsMedicalTranscriberEntity -> dailyCareCPPTsMedicalTranscriberEntity.setMedicalTranscriber(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDailyCareCPPTsMedicalTranscriber(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDailyCareCPPTsMedicalTranscriber() {
		this.unsetDailyCareCPPTsMedicalTranscriber(true);
	}

	/**
	 * Remove all the entities in Daily Care CPPTs Medical Transcriber from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDailyCareCPPTsMedicalTranscriber(boolean doReverse) {
		if (doReverse) {
			this.dailyCareCPPTsMedicalTranscriber.forEach(dailyCareCPPTsMedicalTranscriberEntity -> dailyCareCPPTsMedicalTranscriberEntity.unsetMedicalTranscriber(false));
		}
		this.dailyCareCPPTsMedicalTranscriber.clear();
	}

/**
	 * Similar to {@link this#addDeliveryProgresses(DeliveryProgressEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryProgressEntity to be added to this entity
	 */
	public void addDeliveryProgresses(@NotNull DeliveryProgressEntity entity) {
		addDeliveryProgresses(entity, true);
	}

	/**
	 * Add a new DeliveryProgressEntity to deliveryProgresses in this entity.
	 *
	 * @param entity the given DeliveryProgressEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDeliveryProgresses(@NonNull DeliveryProgressEntity entity, boolean reverseAdd) {
		if (!this.deliveryProgresses.contains(entity)) {
			deliveryProgresses.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDeliveryProgresses(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be added to this entity
	 */
	public void addDeliveryProgresses(@NotNull Collection<DeliveryProgressEntity> entities) {
		addDeliveryProgresses(entities, true);
	}

	/**
	 * Add a new collection of DeliveryProgressEntity to Delivery Progresses in this entity.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDeliveryProgresses(@NonNull Collection<DeliveryProgressEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDeliveryProgresses(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDeliveryProgresses(DeliveryProgressEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryProgressEntity to be set to this entity
	 */
	public void removeDeliveryProgresses(@NotNull DeliveryProgressEntity entity) {
		this.removeDeliveryProgresses(entity, true);
	}

	/**
	 * Remove the given DeliveryProgressEntity from this entity.
	 *
	 * @param entity the given DeliveryProgressEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDeliveryProgresses(@NotNull DeliveryProgressEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.deliveryProgresses.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDeliveryProgresses(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be removed to this entity
	 */
	public void removeDeliveryProgresses(@NotNull Collection<DeliveryProgressEntity> entities) {
		this.removeDeliveryProgresses(entities, true);
	}

	/**
	 * Remove the given collection of DeliveryProgressEntity from  to this entity.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDeliveryProgresses(@NonNull Collection<DeliveryProgressEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDeliveryProgresses(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDeliveryProgresses(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be set to this entity
	 */
	public void setDeliveryProgresses(@NotNull Collection<DeliveryProgressEntity> entities) {
		setDeliveryProgresses(entities, true);
	}

	/**
	 * Replace the current entities in Delivery Progresses with the given ones.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDeliveryProgresses(@NotNull Collection<DeliveryProgressEntity> entities, boolean reverseAdd) {

		this.unsetDeliveryProgresses();
		this.deliveryProgresses = new HashSet<>(entities);
		if (reverseAdd) {
			this.deliveryProgresses.forEach(deliveryProgressesEntity -> deliveryProgressesEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDeliveryProgresses(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDeliveryProgresses() {
		this.unsetDeliveryProgresses(true);
	}

	/**
	 * Remove all the entities in Delivery Progresses from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDeliveryProgresses(boolean doReverse) {
		if (doReverse) {
			this.deliveryProgresses.forEach(deliveryProgressesEntity -> deliveryProgressesEntity.unsetStaff(false));
		}
		this.deliveryProgresses.clear();
	}

/**
	 * Similar to {@link this#addDiagnosticStaffExaminationSummaries(DiagnosticStaffExaminationSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosticStaffExaminationSummaryEntity to be added to this entity
	 */
	public void addDiagnosticStaffExaminationSummaries(@NotNull DiagnosticStaffExaminationSummaryEntity entity) {
		addDiagnosticStaffExaminationSummaries(entity, true);
	}

	/**
	 * Add a new DiagnosticStaffExaminationSummaryEntity to diagnosticStaffExaminationSummaries in this entity.
	 *
	 * @param entity the given DiagnosticStaffExaminationSummaryEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDiagnosticStaffExaminationSummaries(@NonNull DiagnosticStaffExaminationSummaryEntity entity, boolean reverseAdd) {
		if (!this.diagnosticStaffExaminationSummaries.contains(entity)) {
			diagnosticStaffExaminationSummaries.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDiagnosticStaffExaminationSummaries(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosticStaffExaminationSummaryEntity to be added to this entity
	 */
	public void addDiagnosticStaffExaminationSummaries(@NotNull Collection<DiagnosticStaffExaminationSummaryEntity> entities) {
		addDiagnosticStaffExaminationSummaries(entities, true);
	}

	/**
	 * Add a new collection of DiagnosticStaffExaminationSummaryEntity to Diagnostic Staff Examination Summaries in this entity.
	 *
	 * @param entities the given collection of DiagnosticStaffExaminationSummaryEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDiagnosticStaffExaminationSummaries(@NonNull Collection<DiagnosticStaffExaminationSummaryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDiagnosticStaffExaminationSummaries(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDiagnosticStaffExaminationSummaries(DiagnosticStaffExaminationSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosticStaffExaminationSummaryEntity to be set to this entity
	 */
	public void removeDiagnosticStaffExaminationSummaries(@NotNull DiagnosticStaffExaminationSummaryEntity entity) {
		this.removeDiagnosticStaffExaminationSummaries(entity, true);
	}

	/**
	 * Remove the given DiagnosticStaffExaminationSummaryEntity from this entity.
	 *
	 * @param entity the given DiagnosticStaffExaminationSummaryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDiagnosticStaffExaminationSummaries(@NotNull DiagnosticStaffExaminationSummaryEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.diagnosticStaffExaminationSummaries.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDiagnosticStaffExaminationSummaries(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DiagnosticStaffExaminationSummaryEntity to be removed to this entity
	 */
	public void removeDiagnosticStaffExaminationSummaries(@NotNull Collection<DiagnosticStaffExaminationSummaryEntity> entities) {
		this.removeDiagnosticStaffExaminationSummaries(entities, true);
	}

	/**
	 * Remove the given collection of DiagnosticStaffExaminationSummaryEntity from  to this entity.
	 *
	 * @param entities the given collection of DiagnosticStaffExaminationSummaryEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDiagnosticStaffExaminationSummaries(@NonNull Collection<DiagnosticStaffExaminationSummaryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDiagnosticStaffExaminationSummaries(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDiagnosticStaffExaminationSummaries(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosticStaffExaminationSummaryEntity to be set to this entity
	 */
	public void setDiagnosticStaffExaminationSummaries(@NotNull Collection<DiagnosticStaffExaminationSummaryEntity> entities) {
		setDiagnosticStaffExaminationSummaries(entities, true);
	}

	/**
	 * Replace the current entities in Diagnostic Staff Examination Summaries with the given ones.
	 *
	 * @param entities the given collection of DiagnosticStaffExaminationSummaryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDiagnosticStaffExaminationSummaries(@NotNull Collection<DiagnosticStaffExaminationSummaryEntity> entities, boolean reverseAdd) {

		this.unsetDiagnosticStaffExaminationSummaries();
		this.diagnosticStaffExaminationSummaries = new HashSet<>(entities);
		if (reverseAdd) {
			this.diagnosticStaffExaminationSummaries.forEach(diagnosticStaffExaminationSummariesEntity -> diagnosticStaffExaminationSummariesEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDiagnosticStaffExaminationSummaries(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDiagnosticStaffExaminationSummaries() {
		this.unsetDiagnosticStaffExaminationSummaries(true);
	}

	/**
	 * Remove all the entities in Diagnostic Staff Examination Summaries from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDiagnosticStaffExaminationSummaries(boolean doReverse) {
		if (doReverse) {
			this.diagnosticStaffExaminationSummaries.forEach(diagnosticStaffExaminationSummariesEntity -> diagnosticStaffExaminationSummariesEntity.unsetStaff(false));
		}
		this.diagnosticStaffExaminationSummaries.clear();
	}

/**
	 * Similar to {@link this#addDismissalReferringStaff(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 */
	public void addDismissalReferringStaff(@NotNull RegistrationEntity entity) {
		addDismissalReferringStaff(entity, true);
	}

	/**
	 * Add a new RegistrationEntity to dismissalReferringStaff in this entity.
	 *
	 * @param entity the given RegistrationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDismissalReferringStaff(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.dismissalReferringStaff.contains(entity)) {
			dismissalReferringStaff.add(entity);
			if (reverseAdd) {
				entity.setDismissalReferringStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDismissalReferringStaff(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 */
	public void addDismissalReferringStaff(@NotNull Collection<RegistrationEntity> entities) {
		addDismissalReferringStaff(entities, true);
	}

	/**
	 * Add a new collection of RegistrationEntity to Dismissal Referring Staff in this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDismissalReferringStaff(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDismissalReferringStaff(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDismissalReferringStaff(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void removeDismissalReferringStaff(@NotNull RegistrationEntity entity) {
		this.removeDismissalReferringStaff(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDismissalReferringStaff(@NotNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDismissalReferringStaff(false);
		}
		this.dismissalReferringStaff.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDismissalReferringStaff(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 */
	public void removeDismissalReferringStaff(@NotNull Collection<RegistrationEntity> entities) {
		this.removeDismissalReferringStaff(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity from  to this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDismissalReferringStaff(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDismissalReferringStaff(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDismissalReferringStaff(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be set to this entity
	 */
	public void setDismissalReferringStaff(@NotNull Collection<RegistrationEntity> entities) {
		setDismissalReferringStaff(entities, true);
	}

	/**
	 * Replace the current entities in Dismissal Referring Staff with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDismissalReferringStaff(@NotNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

		this.unsetDismissalReferringStaff();
		this.dismissalReferringStaff = new HashSet<>(entities);
		if (reverseAdd) {
			this.dismissalReferringStaff.forEach(dismissalReferringStaffEntity -> dismissalReferringStaffEntity.setDismissalReferringStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDismissalReferringStaff(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDismissalReferringStaff() {
		this.unsetDismissalReferringStaff(true);
	}

	/**
	 * Remove all the entities in Dismissal Referring Staff from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDismissalReferringStaff(boolean doReverse) {
		if (doReverse) {
			this.dismissalReferringStaff.forEach(dismissalReferringStaffEntity -> dismissalReferringStaffEntity.unsetDismissalReferringStaff(false));
		}
		this.dismissalReferringStaff.clear();
	}

/**
	 * Similar to {@link this#addDoctorSchedules(DoctorScheduleEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DoctorScheduleEntity to be added to this entity
	 */
	public void addDoctorSchedules(@NotNull DoctorScheduleEntity entity) {
		addDoctorSchedules(entity, true);
	}

	/**
	 * Add a new DoctorScheduleEntity to doctorSchedules in this entity.
	 *
	 * @param entity the given DoctorScheduleEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDoctorSchedules(@NonNull DoctorScheduleEntity entity, boolean reverseAdd) {
		if (!this.doctorSchedules.contains(entity)) {
			doctorSchedules.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDoctorSchedules(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to be added to this entity
	 */
	public void addDoctorSchedules(@NotNull Collection<DoctorScheduleEntity> entities) {
		addDoctorSchedules(entities, true);
	}

	/**
	 * Add a new collection of DoctorScheduleEntity to Doctor Schedules in this entity.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDoctorSchedules(@NonNull Collection<DoctorScheduleEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDoctorSchedules(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDoctorSchedules(DoctorScheduleEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DoctorScheduleEntity to be set to this entity
	 */
	public void removeDoctorSchedules(@NotNull DoctorScheduleEntity entity) {
		this.removeDoctorSchedules(entity, true);
	}

	/**
	 * Remove the given DoctorScheduleEntity from this entity.
	 *
	 * @param entity the given DoctorScheduleEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDoctorSchedules(@NotNull DoctorScheduleEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.doctorSchedules.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDoctorSchedules(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to be removed to this entity
	 */
	public void removeDoctorSchedules(@NotNull Collection<DoctorScheduleEntity> entities) {
		this.removeDoctorSchedules(entities, true);
	}

	/**
	 * Remove the given collection of DoctorScheduleEntity from  to this entity.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDoctorSchedules(@NonNull Collection<DoctorScheduleEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDoctorSchedules(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDoctorSchedules(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to be set to this entity
	 */
	public void setDoctorSchedules(@NotNull Collection<DoctorScheduleEntity> entities) {
		setDoctorSchedules(entities, true);
	}

	/**
	 * Replace the current entities in Doctor Schedules with the given ones.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDoctorSchedules(@NotNull Collection<DoctorScheduleEntity> entities, boolean reverseAdd) {

		this.unsetDoctorSchedules();
		this.doctorSchedules = new HashSet<>(entities);
		if (reverseAdd) {
			this.doctorSchedules.forEach(doctorSchedulesEntity -> doctorSchedulesEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDoctorSchedules(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDoctorSchedules() {
		this.unsetDoctorSchedules(true);
	}

	/**
	 * Remove all the entities in Doctor Schedules from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDoctorSchedules(boolean doReverse) {
		if (doReverse) {
			this.doctorSchedules.forEach(doctorSchedulesEntity -> doctorSchedulesEntity.unsetStaff(false));
		}
		this.doctorSchedules.clear();
	}

/**
	 * Similar to {@link this#addDoctorOnExamination(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be added to this entity
	 */
	public void addDoctorOnExamination(@NotNull MedicalExaminationRecordEntity entity) {
		addDoctorOnExamination(entity, true);
	}

	/**
	 * Add a new MedicalExaminationRecordEntity to doctorOnExamination in this entity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDoctorOnExamination(@NonNull MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.doctorOnExamination.contains(entity)) {
			doctorOnExamination.add(entity);
			if (reverseAdd) {
				entity.setDoctor(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDoctorOnExamination(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be added to this entity
	 */
	public void addDoctorOnExamination(@NotNull Collection<MedicalExaminationRecordEntity> entities) {
		addDoctorOnExamination(entities, true);
	}

	/**
	 * Add a new collection of MedicalExaminationRecordEntity to Doctor on examination in this entity.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDoctorOnExamination(@NonNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDoctorOnExamination(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDoctorOnExamination(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void removeDoctorOnExamination(@NotNull MedicalExaminationRecordEntity entity) {
		this.removeDoctorOnExamination(entity, true);
	}

	/**
	 * Remove the given MedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDoctorOnExamination(@NotNull MedicalExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDoctor(false);
		}
		this.doctorOnExamination.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDoctorOnExamination(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be removed to this entity
	 */
	public void removeDoctorOnExamination(@NotNull Collection<MedicalExaminationRecordEntity> entities) {
		this.removeDoctorOnExamination(entities, true);
	}

	/**
	 * Remove the given collection of MedicalExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDoctorOnExamination(@NonNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDoctorOnExamination(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDoctorOnExamination(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setDoctorOnExamination(@NotNull Collection<MedicalExaminationRecordEntity> entities) {
		setDoctorOnExamination(entities, true);
	}

	/**
	 * Replace the current entities in Doctor on examination with the given ones.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDoctorOnExamination(@NotNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetDoctorOnExamination();
		this.doctorOnExamination = new HashSet<>(entities);
		if (reverseAdd) {
			this.doctorOnExamination.forEach(doctorOnExaminationEntity -> doctorOnExaminationEntity.setDoctor(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDoctorOnExamination(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDoctorOnExamination() {
		this.unsetDoctorOnExamination(true);
	}

	/**
	 * Remove all the entities in Doctor on examination from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDoctorOnExamination(boolean doReverse) {
		if (doReverse) {
			this.doctorOnExamination.forEach(doctorOnExaminationEntity -> doctorOnExaminationEntity.unsetDoctor(false));
		}
		this.doctorOnExamination.clear();
	}

/**
	 * Similar to {@link this#addFluidBalanceDetails(FluidBalanceDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given FluidBalanceDetailEntity to be added to this entity
	 */
	public void addFluidBalanceDetails(@NotNull FluidBalanceDetailEntity entity) {
		addFluidBalanceDetails(entity, true);
	}

	/**
	 * Add a new FluidBalanceDetailEntity to fluidBalanceDetails in this entity.
	 *
	 * @param entity the given FluidBalanceDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addFluidBalanceDetails(@NonNull FluidBalanceDetailEntity entity, boolean reverseAdd) {
		if (!this.fluidBalanceDetails.contains(entity)) {
			fluidBalanceDetails.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addFluidBalanceDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of FluidBalanceDetailEntity to be added to this entity
	 */
	public void addFluidBalanceDetails(@NotNull Collection<FluidBalanceDetailEntity> entities) {
		addFluidBalanceDetails(entities, true);
	}

	/**
	 * Add a new collection of FluidBalanceDetailEntity to Fluid Balance Details in this entity.
	 *
	 * @param entities the given collection of FluidBalanceDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addFluidBalanceDetails(@NonNull Collection<FluidBalanceDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addFluidBalanceDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeFluidBalanceDetails(FluidBalanceDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given FluidBalanceDetailEntity to be set to this entity
	 */
	public void removeFluidBalanceDetails(@NotNull FluidBalanceDetailEntity entity) {
		this.removeFluidBalanceDetails(entity, true);
	}

	/**
	 * Remove the given FluidBalanceDetailEntity from this entity.
	 *
	 * @param entity the given FluidBalanceDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeFluidBalanceDetails(@NotNull FluidBalanceDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.fluidBalanceDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeFluidBalanceDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of FluidBalanceDetailEntity to be removed to this entity
	 */
	public void removeFluidBalanceDetails(@NotNull Collection<FluidBalanceDetailEntity> entities) {
		this.removeFluidBalanceDetails(entities, true);
	}

	/**
	 * Remove the given collection of FluidBalanceDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of FluidBalanceDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeFluidBalanceDetails(@NonNull Collection<FluidBalanceDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeFluidBalanceDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setFluidBalanceDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of FluidBalanceDetailEntity to be set to this entity
	 */
	public void setFluidBalanceDetails(@NotNull Collection<FluidBalanceDetailEntity> entities) {
		setFluidBalanceDetails(entities, true);
	}

	/**
	 * Replace the current entities in Fluid Balance Details with the given ones.
	 *
	 * @param entities the given collection of FluidBalanceDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setFluidBalanceDetails(@NotNull Collection<FluidBalanceDetailEntity> entities, boolean reverseAdd) {

		this.unsetFluidBalanceDetails();
		this.fluidBalanceDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.fluidBalanceDetails.forEach(fluidBalanceDetailsEntity -> fluidBalanceDetailsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetFluidBalanceDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetFluidBalanceDetails() {
		this.unsetFluidBalanceDetails(true);
	}

	/**
	 * Remove all the entities in Fluid Balance Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetFluidBalanceDetails(boolean doReverse) {
		if (doReverse) {
			this.fluidBalanceDetails.forEach(fluidBalanceDetailsEntity -> fluidBalanceDetailsEntity.unsetStaff(false));
		}
		this.fluidBalanceDetails.clear();
	}

/**
	 * Similar to {@link this#addHemodialysisMonitorings(HemodialysisMonitoringEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HemodialysisMonitoringEntity to be added to this entity
	 */
	public void addHemodialysisMonitorings(@NotNull HemodialysisMonitoringEntity entity) {
		addHemodialysisMonitorings(entity, true);
	}

	/**
	 * Add a new HemodialysisMonitoringEntity to hemodialysisMonitorings in this entity.
	 *
	 * @param entity the given HemodialysisMonitoringEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addHemodialysisMonitorings(@NonNull HemodialysisMonitoringEntity entity, boolean reverseAdd) {
		if (!this.hemodialysisMonitorings.contains(entity)) {
			hemodialysisMonitorings.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addHemodialysisMonitorings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be added to this entity
	 */
	public void addHemodialysisMonitorings(@NotNull Collection<HemodialysisMonitoringEntity> entities) {
		addHemodialysisMonitorings(entities, true);
	}

	/**
	 * Add a new collection of HemodialysisMonitoringEntity to Hemodialysis Monitorings in this entity.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addHemodialysisMonitorings(@NonNull Collection<HemodialysisMonitoringEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addHemodialysisMonitorings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeHemodialysisMonitorings(HemodialysisMonitoringEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HemodialysisMonitoringEntity to be set to this entity
	 */
	public void removeHemodialysisMonitorings(@NotNull HemodialysisMonitoringEntity entity) {
		this.removeHemodialysisMonitorings(entity, true);
	}

	/**
	 * Remove the given HemodialysisMonitoringEntity from this entity.
	 *
	 * @param entity the given HemodialysisMonitoringEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeHemodialysisMonitorings(@NotNull HemodialysisMonitoringEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.hemodialysisMonitorings.remove(entity);
	}

	/**
	 * Similar to {@link this#removeHemodialysisMonitorings(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be removed to this entity
	 */
	public void removeHemodialysisMonitorings(@NotNull Collection<HemodialysisMonitoringEntity> entities) {
		this.removeHemodialysisMonitorings(entities, true);
	}

	/**
	 * Remove the given collection of HemodialysisMonitoringEntity from  to this entity.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeHemodialysisMonitorings(@NonNull Collection<HemodialysisMonitoringEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeHemodialysisMonitorings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setHemodialysisMonitorings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be set to this entity
	 */
	public void setHemodialysisMonitorings(@NotNull Collection<HemodialysisMonitoringEntity> entities) {
		setHemodialysisMonitorings(entities, true);
	}

	/**
	 * Replace the current entities in Hemodialysis Monitorings with the given ones.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setHemodialysisMonitorings(@NotNull Collection<HemodialysisMonitoringEntity> entities, boolean reverseAdd) {

		this.unsetHemodialysisMonitorings();
		this.hemodialysisMonitorings = new HashSet<>(entities);
		if (reverseAdd) {
			this.hemodialysisMonitorings.forEach(hemodialysisMonitoringsEntity -> hemodialysisMonitoringsEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetHemodialysisMonitorings(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetHemodialysisMonitorings() {
		this.unsetHemodialysisMonitorings(true);
	}

	/**
	 * Remove all the entities in Hemodialysis Monitorings from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetHemodialysisMonitorings(boolean doReverse) {
		if (doReverse) {
			this.hemodialysisMonitorings.forEach(hemodialysisMonitoringsEntity -> hemodialysisMonitoringsEntity.unsetMedicalStaff(false));
		}
		this.hemodialysisMonitorings.clear();
	}

/**
	 * Similar to {@link this#addHospitalBranchInformations(HospitalBranchInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HospitalBranchInformationEntity to be added to this entity
	 */
	public void addHospitalBranchInformations(@NotNull HospitalBranchInformationEntity entity) {
		addHospitalBranchInformations(entity, true);
	}

	/**
	 * Add a new HospitalBranchInformationEntity to hospitalBranchInformations in this entity.
	 *
	 * @param entity the given HospitalBranchInformationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addHospitalBranchInformations(@NonNull HospitalBranchInformationEntity entity, boolean reverseAdd) {
		if (!this.hospitalBranchInformations.contains(entity)) {
			hospitalBranchInformations.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addHospitalBranchInformations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be added to this entity
	 */
	public void addHospitalBranchInformations(@NotNull Collection<HospitalBranchInformationEntity> entities) {
		addHospitalBranchInformations(entities, true);
	}

	/**
	 * Add a new collection of HospitalBranchInformationEntity to Hospital Branch Informations in this entity.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addHospitalBranchInformations(@NonNull Collection<HospitalBranchInformationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addHospitalBranchInformations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeHospitalBranchInformations(HospitalBranchInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HospitalBranchInformationEntity to be set to this entity
	 */
	public void removeHospitalBranchInformations(@NotNull HospitalBranchInformationEntity entity) {
		this.removeHospitalBranchInformations(entity, true);
	}

	/**
	 * Remove the given HospitalBranchInformationEntity from this entity.
	 *
	 * @param entity the given HospitalBranchInformationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeHospitalBranchInformations(@NotNull HospitalBranchInformationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.hospitalBranchInformations.remove(entity);
	}

	/**
	 * Similar to {@link this#removeHospitalBranchInformations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be removed to this entity
	 */
	public void removeHospitalBranchInformations(@NotNull Collection<HospitalBranchInformationEntity> entities) {
		this.removeHospitalBranchInformations(entities, true);
	}

	/**
	 * Remove the given collection of HospitalBranchInformationEntity from  to this entity.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeHospitalBranchInformations(@NonNull Collection<HospitalBranchInformationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeHospitalBranchInformations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setHospitalBranchInformations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be set to this entity
	 */
	public void setHospitalBranchInformations(@NotNull Collection<HospitalBranchInformationEntity> entities) {
		setHospitalBranchInformations(entities, true);
	}

	/**
	 * Replace the current entities in Hospital Branch Informations with the given ones.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setHospitalBranchInformations(@NotNull Collection<HospitalBranchInformationEntity> entities, boolean reverseAdd) {

		this.unsetHospitalBranchInformations();
		this.hospitalBranchInformations = new HashSet<>(entities);
		if (reverseAdd) {
			this.hospitalBranchInformations.forEach(hospitalBranchInformationsEntity -> hospitalBranchInformationsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetHospitalBranchInformations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetHospitalBranchInformations() {
		this.unsetHospitalBranchInformations(true);
	}

	/**
	 * Remove all the entities in Hospital Branch Informations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetHospitalBranchInformations(boolean doReverse) {
		if (doReverse) {
			this.hospitalBranchInformations.forEach(hospitalBranchInformationsEntity -> hospitalBranchInformationsEntity.unsetStaff(false));
		}
		this.hospitalBranchInformations.clear();
	}

/**
	 * Similar to {@link this#addInformingConsents(InformedConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InformedConsentEntity to be added to this entity
	 */
	public void addInformingConsents(@NotNull InformedConsentEntity entity) {
		addInformingConsents(entity, true);
	}

	/**
	 * Add a new InformedConsentEntity to informingConsents in this entity.
	 *
	 * @param entity the given InformedConsentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInformingConsents(@NonNull InformedConsentEntity entity, boolean reverseAdd) {
		if (!this.informingConsents.contains(entity)) {
			informingConsents.add(entity);
			if (reverseAdd) {
				entity.setInformingStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInformingConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InformedConsentEntity to be added to this entity
	 */
	public void addInformingConsents(@NotNull Collection<InformedConsentEntity> entities) {
		addInformingConsents(entities, true);
	}

	/**
	 * Add a new collection of InformedConsentEntity to Informing Consents in this entity.
	 *
	 * @param entities the given collection of InformedConsentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInformingConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInformingConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInformingConsents(InformedConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InformedConsentEntity to be set to this entity
	 */
	public void removeInformingConsents(@NotNull InformedConsentEntity entity) {
		this.removeInformingConsents(entity, true);
	}

	/**
	 * Remove the given InformedConsentEntity from this entity.
	 *
	 * @param entity the given InformedConsentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInformingConsents(@NotNull InformedConsentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInformingStaff(false);
		}
		this.informingConsents.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInformingConsents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InformedConsentEntity to be removed to this entity
	 */
	public void removeInformingConsents(@NotNull Collection<InformedConsentEntity> entities) {
		this.removeInformingConsents(entities, true);
	}

	/**
	 * Remove the given collection of InformedConsentEntity from  to this entity.
	 *
	 * @param entities the given collection of InformedConsentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInformingConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInformingConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInformingConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InformedConsentEntity to be set to this entity
	 */
	public void setInformingConsents(@NotNull Collection<InformedConsentEntity> entities) {
		setInformingConsents(entities, true);
	}

	/**
	 * Replace the current entities in Informing Consents with the given ones.
	 *
	 * @param entities the given collection of InformedConsentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInformingConsents(@NotNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {

		this.unsetInformingConsents();
		this.informingConsents = new HashSet<>(entities);
		if (reverseAdd) {
			this.informingConsents.forEach(informingConsentsEntity -> informingConsentsEntity.setInformingStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInformingConsents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInformingConsents() {
		this.unsetInformingConsents(true);
	}

	/**
	 * Remove all the entities in Informing Consents from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInformingConsents(boolean doReverse) {
		if (doReverse) {
			this.informingConsents.forEach(informingConsentsEntity -> informingConsentsEntity.unsetInformingStaff(false));
		}
		this.informingConsents.clear();
	}

/**
	 * Similar to {@link this#addInvoices(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be added to this entity
	 */
	public void addInvoices(@NotNull InvoiceEntity entity) {
		addInvoices(entity, true);
	}

	/**
	 * Add a new InvoiceEntity to invoices in this entity.
	 *
	 * @param entity the given InvoiceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoices(@NonNull InvoiceEntity entity, boolean reverseAdd) {
		if (!this.invoices.contains(entity)) {
			invoices.add(entity);
			if (reverseAdd) {
				entity.setVerifiedBy(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceEntity to be added to this entity
	 */
	public void addInvoices(@NotNull Collection<InvoiceEntity> entities) {
		addInvoices(entities, true);
	}

	/**
	 * Add a new collection of InvoiceEntity to Invoices in this entity.
	 *
	 * @param entities the given collection of InvoiceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoices(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoices(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void removeInvoices(@NotNull InvoiceEntity entity) {
		this.removeInvoices(entity, true);
	}

	/**
	 * Remove the given InvoiceEntity from this entity.
	 *
	 * @param entity the given InvoiceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoices(@NotNull InvoiceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetVerifiedBy(false);
		}
		this.invoices.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoices(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoiceEntity to be removed to this entity
	 */
	public void removeInvoices(@NotNull Collection<InvoiceEntity> entities) {
		this.removeInvoices(entities, true);
	}

	/**
	 * Remove the given collection of InvoiceEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoiceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoices(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceEntity to be set to this entity
	 */
	public void setInvoices(@NotNull Collection<InvoiceEntity> entities) {
		setInvoices(entities, true);
	}

	/**
	 * Replace the current entities in Invoices with the given ones.
	 *
	 * @param entities the given collection of InvoiceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoices(@NotNull Collection<InvoiceEntity> entities, boolean reverseAdd) {

		this.unsetInvoices();
		this.invoices = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoices.forEach(invoicesEntity -> invoicesEntity.setVerifiedBy(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoices(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoices() {
		this.unsetInvoices(true);
	}

	/**
	 * Remove all the entities in Invoices from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoices(boolean doReverse) {
		if (doReverse) {
			this.invoices.forEach(invoicesEntity -> invoicesEntity.unsetVerifiedBy(false));
		}
		this.invoices.clear();
	}

/**
	 * Similar to {@link this#addMcuPackageItems(McuPackageItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given McuPackageItemEntity to be added to this entity
	 */
	public void addMcuPackageItems(@NotNull McuPackageItemEntity entity) {
		addMcuPackageItems(entity, true);
	}

	/**
	 * Add a new McuPackageItemEntity to mcuPackageItems in this entity.
	 *
	 * @param entity the given McuPackageItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMcuPackageItems(@NonNull McuPackageItemEntity entity, boolean reverseAdd) {
		if (!this.mcuPackageItems.contains(entity)) {
			mcuPackageItems.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMcuPackageItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be added to this entity
	 */
	public void addMcuPackageItems(@NotNull Collection<McuPackageItemEntity> entities) {
		addMcuPackageItems(entities, true);
	}

	/**
	 * Add a new collection of McuPackageItemEntity to MCU Package Items in this entity.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMcuPackageItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMcuPackageItems(McuPackageItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given McuPackageItemEntity to be set to this entity
	 */
	public void removeMcuPackageItems(@NotNull McuPackageItemEntity entity) {
		this.removeMcuPackageItems(entity, true);
	}

	/**
	 * Remove the given McuPackageItemEntity from this entity.
	 *
	 * @param entity the given McuPackageItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMcuPackageItems(@NotNull McuPackageItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.mcuPackageItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMcuPackageItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be removed to this entity
	 */
	public void removeMcuPackageItems(@NotNull Collection<McuPackageItemEntity> entities) {
		this.removeMcuPackageItems(entities, true);
	}

	/**
	 * Remove the given collection of McuPackageItemEntity from  to this entity.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMcuPackageItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMcuPackageItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be set to this entity
	 */
	public void setMcuPackageItems(@NotNull Collection<McuPackageItemEntity> entities) {
		setMcuPackageItems(entities, true);
	}

	/**
	 * Replace the current entities in MCU Package Items with the given ones.
	 *
	 * @param entities the given collection of McuPackageItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMcuPackageItems(@NotNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {

		this.unsetMcuPackageItems();
		this.mcuPackageItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.mcuPackageItems.forEach(mcuPackageItemsEntity -> mcuPackageItemsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMcuPackageItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMcuPackageItems() {
		this.unsetMcuPackageItems(true);
	}

	/**
	 * Remove all the entities in MCU Package Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMcuPackageItems(boolean doReverse) {
		if (doReverse) {
			this.mcuPackageItems.forEach(mcuPackageItemsEntity -> mcuPackageItemsEntity.unsetStaff(false));
		}
		this.mcuPackageItems.clear();
	}

/**
	 * Similar to {@link this#addMedicalCertificateDischargeResumes(MedicalCertificateDischargeResumeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateDischargeResumeEntity to be added to this entity
	 */
	public void addMedicalCertificateDischargeResumes(@NotNull MedicalCertificateDischargeResumeEntity entity) {
		addMedicalCertificateDischargeResumes(entity, true);
	}

	/**
	 * Add a new MedicalCertificateDischargeResumeEntity to medicalCertificateDischargeResumes in this entity.
	 *
	 * @param entity the given MedicalCertificateDischargeResumeEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalCertificateDischargeResumes(@NonNull MedicalCertificateDischargeResumeEntity entity, boolean reverseAdd) {
		if (!this.medicalCertificateDischargeResumes.contains(entity)) {
			medicalCertificateDischargeResumes.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalCertificateDischargeResumes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be added to this entity
	 */
	public void addMedicalCertificateDischargeResumes(@NotNull Collection<MedicalCertificateDischargeResumeEntity> entities) {
		addMedicalCertificateDischargeResumes(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificateDischargeResumeEntity to Medical Certificate  Discharge Resumes in this entity.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalCertificateDischargeResumes(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalCertificateDischargeResumes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalCertificateDischargeResumes(MedicalCertificateDischargeResumeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateDischargeResumeEntity to be set to this entity
	 */
	public void removeMedicalCertificateDischargeResumes(@NotNull MedicalCertificateDischargeResumeEntity entity) {
		this.removeMedicalCertificateDischargeResumes(entity, true);
	}

	/**
	 * Remove the given MedicalCertificateDischargeResumeEntity from this entity.
	 *
	 * @param entity the given MedicalCertificateDischargeResumeEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalCertificateDischargeResumes(@NotNull MedicalCertificateDischargeResumeEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.medicalCertificateDischargeResumes.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalCertificateDischargeResumes(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be removed to this entity
	 */
	public void removeMedicalCertificateDischargeResumes(@NotNull Collection<MedicalCertificateDischargeResumeEntity> entities) {
		this.removeMedicalCertificateDischargeResumes(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificateDischargeResumeEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalCertificateDischargeResumes(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalCertificateDischargeResumes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalCertificateDischargeResumes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be set to this entity
	 */
	public void setMedicalCertificateDischargeResumes(@NotNull Collection<MedicalCertificateDischargeResumeEntity> entities) {
		setMedicalCertificateDischargeResumes(entities, true);
	}

	/**
	 * Replace the current entities in Medical Certificate  Discharge Resumes with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalCertificateDischargeResumes(@NotNull Collection<MedicalCertificateDischargeResumeEntity> entities, boolean reverseAdd) {

		this.unsetMedicalCertificateDischargeResumes();
		this.medicalCertificateDischargeResumes = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalCertificateDischargeResumes.forEach(medicalCertificateDischargeResumesEntity -> medicalCertificateDischargeResumesEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalCertificateDischargeResumes(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalCertificateDischargeResumes() {
		this.unsetMedicalCertificateDischargeResumes(true);
	}

	/**
	 * Remove all the entities in Medical Certificate  Discharge Resumes from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalCertificateDischargeResumes(boolean doReverse) {
		if (doReverse) {
			this.medicalCertificateDischargeResumes.forEach(medicalCertificateDischargeResumesEntity -> medicalCertificateDischargeResumesEntity.unsetMedicalStaff(false));
		}
		this.medicalCertificateDischargeResumes.clear();
	}

/**
	 * Similar to {@link this#addMedicalCertificateBirths(MedicalCertificateBirthEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateBirthEntity to be added to this entity
	 */
	public void addMedicalCertificateBirths(@NotNull MedicalCertificateBirthEntity entity) {
		addMedicalCertificateBirths(entity, true);
	}

	/**
	 * Add a new MedicalCertificateBirthEntity to medicalCertificateBirths in this entity.
	 *
	 * @param entity the given MedicalCertificateBirthEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalCertificateBirths(@NonNull MedicalCertificateBirthEntity entity, boolean reverseAdd) {
		if (!this.medicalCertificateBirths.contains(entity)) {
			medicalCertificateBirths.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalCertificateBirths(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateBirthEntity to be added to this entity
	 */
	public void addMedicalCertificateBirths(@NotNull Collection<MedicalCertificateBirthEntity> entities) {
		addMedicalCertificateBirths(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificateBirthEntity to Medical Certificate Births in this entity.
	 *
	 * @param entities the given collection of MedicalCertificateBirthEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalCertificateBirths(@NonNull Collection<MedicalCertificateBirthEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalCertificateBirths(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalCertificateBirths(MedicalCertificateBirthEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateBirthEntity to be set to this entity
	 */
	public void removeMedicalCertificateBirths(@NotNull MedicalCertificateBirthEntity entity) {
		this.removeMedicalCertificateBirths(entity, true);
	}

	/**
	 * Remove the given MedicalCertificateBirthEntity from this entity.
	 *
	 * @param entity the given MedicalCertificateBirthEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalCertificateBirths(@NotNull MedicalCertificateBirthEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.medicalCertificateBirths.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalCertificateBirths(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificateBirthEntity to be removed to this entity
	 */
	public void removeMedicalCertificateBirths(@NotNull Collection<MedicalCertificateBirthEntity> entities) {
		this.removeMedicalCertificateBirths(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificateBirthEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificateBirthEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalCertificateBirths(@NonNull Collection<MedicalCertificateBirthEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalCertificateBirths(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalCertificateBirths(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateBirthEntity to be set to this entity
	 */
	public void setMedicalCertificateBirths(@NotNull Collection<MedicalCertificateBirthEntity> entities) {
		setMedicalCertificateBirths(entities, true);
	}

	/**
	 * Replace the current entities in Medical Certificate Births with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificateBirthEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalCertificateBirths(@NotNull Collection<MedicalCertificateBirthEntity> entities, boolean reverseAdd) {

		this.unsetMedicalCertificateBirths();
		this.medicalCertificateBirths = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalCertificateBirths.forEach(medicalCertificateBirthsEntity -> medicalCertificateBirthsEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalCertificateBirths(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalCertificateBirths() {
		this.unsetMedicalCertificateBirths(true);
	}

	/**
	 * Remove all the entities in Medical Certificate Births from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalCertificateBirths(boolean doReverse) {
		if (doReverse) {
			this.medicalCertificateBirths.forEach(medicalCertificateBirthsEntity -> medicalCertificateBirthsEntity.unsetMedicalStaff(false));
		}
		this.medicalCertificateBirths.clear();
	}

/**
	 * Similar to {@link this#addMedicalCertificateHospitalizations(MedicalCertificateHospitalizationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateHospitalizationEntity to be added to this entity
	 */
	public void addMedicalCertificateHospitalizations(@NotNull MedicalCertificateHospitalizationEntity entity) {
		addMedicalCertificateHospitalizations(entity, true);
	}

	/**
	 * Add a new MedicalCertificateHospitalizationEntity to medicalCertificateHospitalizations in this entity.
	 *
	 * @param entity the given MedicalCertificateHospitalizationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalCertificateHospitalizations(@NonNull MedicalCertificateHospitalizationEntity entity, boolean reverseAdd) {
		if (!this.medicalCertificateHospitalizations.contains(entity)) {
			medicalCertificateHospitalizations.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalCertificateHospitalizations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateHospitalizationEntity to be added to this entity
	 */
	public void addMedicalCertificateHospitalizations(@NotNull Collection<MedicalCertificateHospitalizationEntity> entities) {
		addMedicalCertificateHospitalizations(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificateHospitalizationEntity to Medical Certificate Hospitalizations in this entity.
	 *
	 * @param entities the given collection of MedicalCertificateHospitalizationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalCertificateHospitalizations(@NonNull Collection<MedicalCertificateHospitalizationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalCertificateHospitalizations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalCertificateHospitalizations(MedicalCertificateHospitalizationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateHospitalizationEntity to be set to this entity
	 */
	public void removeMedicalCertificateHospitalizations(@NotNull MedicalCertificateHospitalizationEntity entity) {
		this.removeMedicalCertificateHospitalizations(entity, true);
	}

	/**
	 * Remove the given MedicalCertificateHospitalizationEntity from this entity.
	 *
	 * @param entity the given MedicalCertificateHospitalizationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalCertificateHospitalizations(@NotNull MedicalCertificateHospitalizationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.medicalCertificateHospitalizations.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalCertificateHospitalizations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificateHospitalizationEntity to be removed to this entity
	 */
	public void removeMedicalCertificateHospitalizations(@NotNull Collection<MedicalCertificateHospitalizationEntity> entities) {
		this.removeMedicalCertificateHospitalizations(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificateHospitalizationEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificateHospitalizationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalCertificateHospitalizations(@NonNull Collection<MedicalCertificateHospitalizationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalCertificateHospitalizations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalCertificateHospitalizations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateHospitalizationEntity to be set to this entity
	 */
	public void setMedicalCertificateHospitalizations(@NotNull Collection<MedicalCertificateHospitalizationEntity> entities) {
		setMedicalCertificateHospitalizations(entities, true);
	}

	/**
	 * Replace the current entities in Medical Certificate Hospitalizations with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificateHospitalizationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalCertificateHospitalizations(@NotNull Collection<MedicalCertificateHospitalizationEntity> entities, boolean reverseAdd) {

		this.unsetMedicalCertificateHospitalizations();
		this.medicalCertificateHospitalizations = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalCertificateHospitalizations.forEach(medicalCertificateHospitalizationsEntity -> medicalCertificateHospitalizationsEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalCertificateHospitalizations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalCertificateHospitalizations() {
		this.unsetMedicalCertificateHospitalizations(true);
	}

	/**
	 * Remove all the entities in Medical Certificate Hospitalizations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalCertificateHospitalizations(boolean doReverse) {
		if (doReverse) {
			this.medicalCertificateHospitalizations.forEach(medicalCertificateHospitalizationsEntity -> medicalCertificateHospitalizationsEntity.unsetMedicalStaff(false));
		}
		this.medicalCertificateHospitalizations.clear();
	}

/**
	 * Similar to {@link this#addMedicalExaminationRecordDischargeSummarys(MedicalExaminationRecordDischargeSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordDischargeSummaryEntity to be added to this entity
	 */
	public void addMedicalExaminationRecordDischargeSummarys(@NotNull MedicalExaminationRecordDischargeSummaryEntity entity) {
		addMedicalExaminationRecordDischargeSummarys(entity, true);
	}

	/**
	 * Add a new MedicalExaminationRecordDischargeSummaryEntity to medicalExaminationRecordDischargeSummarys in this entity.
	 *
	 * @param entity the given MedicalExaminationRecordDischargeSummaryEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalExaminationRecordDischargeSummarys(@NonNull MedicalExaminationRecordDischargeSummaryEntity entity, boolean reverseAdd) {
		if (!this.medicalExaminationRecordDischargeSummarys.contains(entity)) {
			medicalExaminationRecordDischargeSummarys.add(entity);
			if (reverseAdd) {
				entity.setDischargingDoctor(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalExaminationRecordDischargeSummarys(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalExaminationRecordDischargeSummaryEntity to be added to this entity
	 */
	public void addMedicalExaminationRecordDischargeSummarys(@NotNull Collection<MedicalExaminationRecordDischargeSummaryEntity> entities) {
		addMedicalExaminationRecordDischargeSummarys(entities, true);
	}

	/**
	 * Add a new collection of MedicalExaminationRecordDischargeSummaryEntity to Medical Examination Record Discharge Summarys in this entity.
	 *
	 * @param entities the given collection of MedicalExaminationRecordDischargeSummaryEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalExaminationRecordDischargeSummarys(@NonNull Collection<MedicalExaminationRecordDischargeSummaryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalExaminationRecordDischargeSummarys(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalExaminationRecordDischargeSummarys(MedicalExaminationRecordDischargeSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordDischargeSummaryEntity to be set to this entity
	 */
	public void removeMedicalExaminationRecordDischargeSummarys(@NotNull MedicalExaminationRecordDischargeSummaryEntity entity) {
		this.removeMedicalExaminationRecordDischargeSummarys(entity, true);
	}

	/**
	 * Remove the given MedicalExaminationRecordDischargeSummaryEntity from this entity.
	 *
	 * @param entity the given MedicalExaminationRecordDischargeSummaryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalExaminationRecordDischargeSummarys(@NotNull MedicalExaminationRecordDischargeSummaryEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDischargingDoctor(false);
		}
		this.medicalExaminationRecordDischargeSummarys.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalExaminationRecordDischargeSummarys(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalExaminationRecordDischargeSummaryEntity to be removed to this entity
	 */
	public void removeMedicalExaminationRecordDischargeSummarys(@NotNull Collection<MedicalExaminationRecordDischargeSummaryEntity> entities) {
		this.removeMedicalExaminationRecordDischargeSummarys(entities, true);
	}

	/**
	 * Remove the given collection of MedicalExaminationRecordDischargeSummaryEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalExaminationRecordDischargeSummaryEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalExaminationRecordDischargeSummarys(@NonNull Collection<MedicalExaminationRecordDischargeSummaryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalExaminationRecordDischargeSummarys(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalExaminationRecordDischargeSummarys(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalExaminationRecordDischargeSummaryEntity to be set to this entity
	 */
	public void setMedicalExaminationRecordDischargeSummarys(@NotNull Collection<MedicalExaminationRecordDischargeSummaryEntity> entities) {
		setMedicalExaminationRecordDischargeSummarys(entities, true);
	}

	/**
	 * Replace the current entities in Medical Examination Record Discharge Summarys with the given ones.
	 *
	 * @param entities the given collection of MedicalExaminationRecordDischargeSummaryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalExaminationRecordDischargeSummarys(@NotNull Collection<MedicalExaminationRecordDischargeSummaryEntity> entities, boolean reverseAdd) {

		this.unsetMedicalExaminationRecordDischargeSummarys();
		this.medicalExaminationRecordDischargeSummarys = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalExaminationRecordDischargeSummarys.forEach(medicalExaminationRecordDischargeSummarysEntity -> medicalExaminationRecordDischargeSummarysEntity.setDischargingDoctor(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecordDischargeSummarys(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalExaminationRecordDischargeSummarys() {
		this.unsetMedicalExaminationRecordDischargeSummarys(true);
	}

	/**
	 * Remove all the entities in Medical Examination Record Discharge Summarys from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalExaminationRecordDischargeSummarys(boolean doReverse) {
		if (doReverse) {
			this.medicalExaminationRecordDischargeSummarys.forEach(medicalExaminationRecordDischargeSummarysEntity -> medicalExaminationRecordDischargeSummarysEntity.unsetDischargingDoctor(false));
		}
		this.medicalExaminationRecordDischargeSummarys.clear();
	}

/**
	 * Similar to {@link this#addMedicalRecordTranscriber(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be added to this entity
	 */
	public void addMedicalRecordTranscriber(@NotNull MedicalExaminationRecordEntity entity) {
		addMedicalRecordTranscriber(entity, true);
	}

	/**
	 * Add a new MedicalExaminationRecordEntity to medicalRecordTranscriber in this entity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalRecordTranscriber(@NonNull MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.medicalRecordTranscriber.contains(entity)) {
			medicalRecordTranscriber.add(entity);
			if (reverseAdd) {
				entity.setMedicalTranscriber(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalRecordTranscriber(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be added to this entity
	 */
	public void addMedicalRecordTranscriber(@NotNull Collection<MedicalExaminationRecordEntity> entities) {
		addMedicalRecordTranscriber(entities, true);
	}

	/**
	 * Add a new collection of MedicalExaminationRecordEntity to Medical Record Transcriber in this entity.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalRecordTranscriber(@NonNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalRecordTranscriber(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalRecordTranscriber(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void removeMedicalRecordTranscriber(@NotNull MedicalExaminationRecordEntity entity) {
		this.removeMedicalRecordTranscriber(entity, true);
	}

	/**
	 * Remove the given MedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalRecordTranscriber(@NotNull MedicalExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalTranscriber(false);
		}
		this.medicalRecordTranscriber.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalRecordTranscriber(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be removed to this entity
	 */
	public void removeMedicalRecordTranscriber(@NotNull Collection<MedicalExaminationRecordEntity> entities) {
		this.removeMedicalRecordTranscriber(entities, true);
	}

	/**
	 * Remove the given collection of MedicalExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalRecordTranscriber(@NonNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalRecordTranscriber(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalRecordTranscriber(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalRecordTranscriber(@NotNull Collection<MedicalExaminationRecordEntity> entities) {
		setMedicalRecordTranscriber(entities, true);
	}

	/**
	 * Replace the current entities in Medical Record Transcriber with the given ones.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalRecordTranscriber(@NotNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetMedicalRecordTranscriber();
		this.medicalRecordTranscriber = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalRecordTranscriber.forEach(medicalRecordTranscriberEntity -> medicalRecordTranscriberEntity.setMedicalTranscriber(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalRecordTranscriber(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalRecordTranscriber() {
		this.unsetMedicalRecordTranscriber(true);
	}

	/**
	 * Remove all the entities in Medical Record Transcriber from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalRecordTranscriber(boolean doReverse) {
		if (doReverse) {
			this.medicalRecordTranscriber.forEach(medicalRecordTranscriberEntity -> medicalRecordTranscriberEntity.unsetMedicalTranscriber(false));
		}
		this.medicalRecordTranscriber.clear();
	}

/**
	 * Similar to {@link this#addMedicalStaffOfMedicalAttendancesCertificate(MedicalCertificateMedicalAttendanceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateMedicalAttendanceEntity to be added to this entity
	 */
	public void addMedicalStaffOfMedicalAttendancesCertificate(@NotNull MedicalCertificateMedicalAttendanceEntity entity) {
		addMedicalStaffOfMedicalAttendancesCertificate(entity, true);
	}

	/**
	 * Add a new MedicalCertificateMedicalAttendanceEntity to medicalStaffOfMedicalAttendancesCertificate in this entity.
	 *
	 * @param entity the given MedicalCertificateMedicalAttendanceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalStaffOfMedicalAttendancesCertificate(@NonNull MedicalCertificateMedicalAttendanceEntity entity, boolean reverseAdd) {
		if (!this.medicalStaffOfMedicalAttendancesCertificate.contains(entity)) {
			medicalStaffOfMedicalAttendancesCertificate.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalStaffOfMedicalAttendancesCertificate(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateMedicalAttendanceEntity to be added to this entity
	 */
	public void addMedicalStaffOfMedicalAttendancesCertificate(@NotNull Collection<MedicalCertificateMedicalAttendanceEntity> entities) {
		addMedicalStaffOfMedicalAttendancesCertificate(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificateMedicalAttendanceEntity to Medical Staff of Medical Attendances certificate in this entity.
	 *
	 * @param entities the given collection of MedicalCertificateMedicalAttendanceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalStaffOfMedicalAttendancesCertificate(@NonNull Collection<MedicalCertificateMedicalAttendanceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalStaffOfMedicalAttendancesCertificate(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfMedicalAttendancesCertificate(MedicalCertificateMedicalAttendanceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateMedicalAttendanceEntity to be set to this entity
	 */
	public void removeMedicalStaffOfMedicalAttendancesCertificate(@NotNull MedicalCertificateMedicalAttendanceEntity entity) {
		this.removeMedicalStaffOfMedicalAttendancesCertificate(entity, true);
	}

	/**
	 * Remove the given MedicalCertificateMedicalAttendanceEntity from this entity.
	 *
	 * @param entity the given MedicalCertificateMedicalAttendanceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalStaffOfMedicalAttendancesCertificate(@NotNull MedicalCertificateMedicalAttendanceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.medicalStaffOfMedicalAttendancesCertificate.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfMedicalAttendancesCertificate(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificateMedicalAttendanceEntity to be removed to this entity
	 */
	public void removeMedicalStaffOfMedicalAttendancesCertificate(@NotNull Collection<MedicalCertificateMedicalAttendanceEntity> entities) {
		this.removeMedicalStaffOfMedicalAttendancesCertificate(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificateMedicalAttendanceEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificateMedicalAttendanceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalStaffOfMedicalAttendancesCertificate(@NonNull Collection<MedicalCertificateMedicalAttendanceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalStaffOfMedicalAttendancesCertificate(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalStaffOfMedicalAttendancesCertificate(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateMedicalAttendanceEntity to be set to this entity
	 */
	public void setMedicalStaffOfMedicalAttendancesCertificate(@NotNull Collection<MedicalCertificateMedicalAttendanceEntity> entities) {
		setMedicalStaffOfMedicalAttendancesCertificate(entities, true);
	}

	/**
	 * Replace the current entities in Medical Staff of Medical Attendances certificate with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificateMedicalAttendanceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalStaffOfMedicalAttendancesCertificate(@NotNull Collection<MedicalCertificateMedicalAttendanceEntity> entities, boolean reverseAdd) {

		this.unsetMedicalStaffOfMedicalAttendancesCertificate();
		this.medicalStaffOfMedicalAttendancesCertificate = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalStaffOfMedicalAttendancesCertificate.forEach(medicalStaffOfMedicalAttendancesCertificateEntity -> medicalStaffOfMedicalAttendancesCertificateEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalStaffOfMedicalAttendancesCertificate(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalStaffOfMedicalAttendancesCertificate() {
		this.unsetMedicalStaffOfMedicalAttendancesCertificate(true);
	}

	/**
	 * Remove all the entities in Medical Staff of Medical Attendances certificate from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalStaffOfMedicalAttendancesCertificate(boolean doReverse) {
		if (doReverse) {
			this.medicalStaffOfMedicalAttendancesCertificate.forEach(medicalStaffOfMedicalAttendancesCertificateEntity -> medicalStaffOfMedicalAttendancesCertificateEntity.unsetMedicalStaff(false));
		}
		this.medicalStaffOfMedicalAttendancesCertificate.clear();
	}

/**
	 * Similar to {@link this#addMedicalStaffOfMentalHealths(MedicalCertificateMentalHealthEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateMentalHealthEntity to be added to this entity
	 */
	public void addMedicalStaffOfMentalHealths(@NotNull MedicalCertificateMentalHealthEntity entity) {
		addMedicalStaffOfMentalHealths(entity, true);
	}

	/**
	 * Add a new MedicalCertificateMentalHealthEntity to medicalStaffOfMentalHealths in this entity.
	 *
	 * @param entity the given MedicalCertificateMentalHealthEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalStaffOfMentalHealths(@NonNull MedicalCertificateMentalHealthEntity entity, boolean reverseAdd) {
		if (!this.medicalStaffOfMentalHealths.contains(entity)) {
			medicalStaffOfMentalHealths.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalStaffOfMentalHealths(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateMentalHealthEntity to be added to this entity
	 */
	public void addMedicalStaffOfMentalHealths(@NotNull Collection<MedicalCertificateMentalHealthEntity> entities) {
		addMedicalStaffOfMentalHealths(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificateMentalHealthEntity to Medical Staff of Mental Healths in this entity.
	 *
	 * @param entities the given collection of MedicalCertificateMentalHealthEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalStaffOfMentalHealths(@NonNull Collection<MedicalCertificateMentalHealthEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalStaffOfMentalHealths(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfMentalHealths(MedicalCertificateMentalHealthEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateMentalHealthEntity to be set to this entity
	 */
	public void removeMedicalStaffOfMentalHealths(@NotNull MedicalCertificateMentalHealthEntity entity) {
		this.removeMedicalStaffOfMentalHealths(entity, true);
	}

	/**
	 * Remove the given MedicalCertificateMentalHealthEntity from this entity.
	 *
	 * @param entity the given MedicalCertificateMentalHealthEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalStaffOfMentalHealths(@NotNull MedicalCertificateMentalHealthEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.medicalStaffOfMentalHealths.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfMentalHealths(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificateMentalHealthEntity to be removed to this entity
	 */
	public void removeMedicalStaffOfMentalHealths(@NotNull Collection<MedicalCertificateMentalHealthEntity> entities) {
		this.removeMedicalStaffOfMentalHealths(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificateMentalHealthEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificateMentalHealthEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalStaffOfMentalHealths(@NonNull Collection<MedicalCertificateMentalHealthEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalStaffOfMentalHealths(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalStaffOfMentalHealths(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateMentalHealthEntity to be set to this entity
	 */
	public void setMedicalStaffOfMentalHealths(@NotNull Collection<MedicalCertificateMentalHealthEntity> entities) {
		setMedicalStaffOfMentalHealths(entities, true);
	}

	/**
	 * Replace the current entities in Medical Staff of Mental Healths with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificateMentalHealthEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalStaffOfMentalHealths(@NotNull Collection<MedicalCertificateMentalHealthEntity> entities, boolean reverseAdd) {

		this.unsetMedicalStaffOfMentalHealths();
		this.medicalStaffOfMentalHealths = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalStaffOfMentalHealths.forEach(medicalStaffOfMentalHealthsEntity -> medicalStaffOfMentalHealthsEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalStaffOfMentalHealths(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalStaffOfMentalHealths() {
		this.unsetMedicalStaffOfMentalHealths(true);
	}

	/**
	 * Remove all the entities in Medical Staff of Mental Healths from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalStaffOfMentalHealths(boolean doReverse) {
		if (doReverse) {
			this.medicalStaffOfMentalHealths.forEach(medicalStaffOfMentalHealthsEntity -> medicalStaffOfMentalHealthsEntity.unsetMedicalStaff(false));
		}
		this.medicalStaffOfMentalHealths.clear();
	}

/**
	 * Similar to {@link this#addMedicalStaffOfPhysicalHealths(MedicalCertificatePhysicalHealthEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificatePhysicalHealthEntity to be added to this entity
	 */
	public void addMedicalStaffOfPhysicalHealths(@NotNull MedicalCertificatePhysicalHealthEntity entity) {
		addMedicalStaffOfPhysicalHealths(entity, true);
	}

	/**
	 * Add a new MedicalCertificatePhysicalHealthEntity to medicalStaffOfPhysicalHealths in this entity.
	 *
	 * @param entity the given MedicalCertificatePhysicalHealthEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalStaffOfPhysicalHealths(@NonNull MedicalCertificatePhysicalHealthEntity entity, boolean reverseAdd) {
		if (!this.medicalStaffOfPhysicalHealths.contains(entity)) {
			medicalStaffOfPhysicalHealths.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalStaffOfPhysicalHealths(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificatePhysicalHealthEntity to be added to this entity
	 */
	public void addMedicalStaffOfPhysicalHealths(@NotNull Collection<MedicalCertificatePhysicalHealthEntity> entities) {
		addMedicalStaffOfPhysicalHealths(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificatePhysicalHealthEntity to Medical Staff of Physical Healths in this entity.
	 *
	 * @param entities the given collection of MedicalCertificatePhysicalHealthEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalStaffOfPhysicalHealths(@NonNull Collection<MedicalCertificatePhysicalHealthEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalStaffOfPhysicalHealths(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfPhysicalHealths(MedicalCertificatePhysicalHealthEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificatePhysicalHealthEntity to be set to this entity
	 */
	public void removeMedicalStaffOfPhysicalHealths(@NotNull MedicalCertificatePhysicalHealthEntity entity) {
		this.removeMedicalStaffOfPhysicalHealths(entity, true);
	}

	/**
	 * Remove the given MedicalCertificatePhysicalHealthEntity from this entity.
	 *
	 * @param entity the given MedicalCertificatePhysicalHealthEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalStaffOfPhysicalHealths(@NotNull MedicalCertificatePhysicalHealthEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.medicalStaffOfPhysicalHealths.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfPhysicalHealths(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificatePhysicalHealthEntity to be removed to this entity
	 */
	public void removeMedicalStaffOfPhysicalHealths(@NotNull Collection<MedicalCertificatePhysicalHealthEntity> entities) {
		this.removeMedicalStaffOfPhysicalHealths(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificatePhysicalHealthEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificatePhysicalHealthEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalStaffOfPhysicalHealths(@NonNull Collection<MedicalCertificatePhysicalHealthEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalStaffOfPhysicalHealths(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalStaffOfPhysicalHealths(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificatePhysicalHealthEntity to be set to this entity
	 */
	public void setMedicalStaffOfPhysicalHealths(@NotNull Collection<MedicalCertificatePhysicalHealthEntity> entities) {
		setMedicalStaffOfPhysicalHealths(entities, true);
	}

	/**
	 * Replace the current entities in Medical Staff of Physical Healths with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificatePhysicalHealthEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalStaffOfPhysicalHealths(@NotNull Collection<MedicalCertificatePhysicalHealthEntity> entities, boolean reverseAdd) {

		this.unsetMedicalStaffOfPhysicalHealths();
		this.medicalStaffOfPhysicalHealths = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalStaffOfPhysicalHealths.forEach(medicalStaffOfPhysicalHealthsEntity -> medicalStaffOfPhysicalHealthsEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalStaffOfPhysicalHealths(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalStaffOfPhysicalHealths() {
		this.unsetMedicalStaffOfPhysicalHealths(true);
	}

	/**
	 * Remove all the entities in Medical Staff of Physical Healths from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalStaffOfPhysicalHealths(boolean doReverse) {
		if (doReverse) {
			this.medicalStaffOfPhysicalHealths.forEach(medicalStaffOfPhysicalHealthsEntity -> medicalStaffOfPhysicalHealthsEntity.unsetMedicalStaff(false));
		}
		this.medicalStaffOfPhysicalHealths.clear();
	}

/**
	 * Similar to {@link this#addMedicalStaffOfRestrictedWorksCertificate(MedicalCertificateRestrictedWorkEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateRestrictedWorkEntity to be added to this entity
	 */
	public void addMedicalStaffOfRestrictedWorksCertificate(@NotNull MedicalCertificateRestrictedWorkEntity entity) {
		addMedicalStaffOfRestrictedWorksCertificate(entity, true);
	}

	/**
	 * Add a new MedicalCertificateRestrictedWorkEntity to medicalStaffOfRestrictedWorksCertificate in this entity.
	 *
	 * @param entity the given MedicalCertificateRestrictedWorkEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalStaffOfRestrictedWorksCertificate(@NonNull MedicalCertificateRestrictedWorkEntity entity, boolean reverseAdd) {
		if (!this.medicalStaffOfRestrictedWorksCertificate.contains(entity)) {
			medicalStaffOfRestrictedWorksCertificate.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalStaffOfRestrictedWorksCertificate(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateRestrictedWorkEntity to be added to this entity
	 */
	public void addMedicalStaffOfRestrictedWorksCertificate(@NotNull Collection<MedicalCertificateRestrictedWorkEntity> entities) {
		addMedicalStaffOfRestrictedWorksCertificate(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificateRestrictedWorkEntity to Medical Staff of Restricted Works certificate in this entity.
	 *
	 * @param entities the given collection of MedicalCertificateRestrictedWorkEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalStaffOfRestrictedWorksCertificate(@NonNull Collection<MedicalCertificateRestrictedWorkEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalStaffOfRestrictedWorksCertificate(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfRestrictedWorksCertificate(MedicalCertificateRestrictedWorkEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateRestrictedWorkEntity to be set to this entity
	 */
	public void removeMedicalStaffOfRestrictedWorksCertificate(@NotNull MedicalCertificateRestrictedWorkEntity entity) {
		this.removeMedicalStaffOfRestrictedWorksCertificate(entity, true);
	}

	/**
	 * Remove the given MedicalCertificateRestrictedWorkEntity from this entity.
	 *
	 * @param entity the given MedicalCertificateRestrictedWorkEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalStaffOfRestrictedWorksCertificate(@NotNull MedicalCertificateRestrictedWorkEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.medicalStaffOfRestrictedWorksCertificate.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfRestrictedWorksCertificate(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificateRestrictedWorkEntity to be removed to this entity
	 */
	public void removeMedicalStaffOfRestrictedWorksCertificate(@NotNull Collection<MedicalCertificateRestrictedWorkEntity> entities) {
		this.removeMedicalStaffOfRestrictedWorksCertificate(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificateRestrictedWorkEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificateRestrictedWorkEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalStaffOfRestrictedWorksCertificate(@NonNull Collection<MedicalCertificateRestrictedWorkEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalStaffOfRestrictedWorksCertificate(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalStaffOfRestrictedWorksCertificate(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateRestrictedWorkEntity to be set to this entity
	 */
	public void setMedicalStaffOfRestrictedWorksCertificate(@NotNull Collection<MedicalCertificateRestrictedWorkEntity> entities) {
		setMedicalStaffOfRestrictedWorksCertificate(entities, true);
	}

	/**
	 * Replace the current entities in Medical Staff of Restricted Works certificate with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificateRestrictedWorkEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalStaffOfRestrictedWorksCertificate(@NotNull Collection<MedicalCertificateRestrictedWorkEntity> entities, boolean reverseAdd) {

		this.unsetMedicalStaffOfRestrictedWorksCertificate();
		this.medicalStaffOfRestrictedWorksCertificate = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalStaffOfRestrictedWorksCertificate.forEach(medicalStaffOfRestrictedWorksCertificateEntity -> medicalStaffOfRestrictedWorksCertificateEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalStaffOfRestrictedWorksCertificate(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalStaffOfRestrictedWorksCertificate() {
		this.unsetMedicalStaffOfRestrictedWorksCertificate(true);
	}

	/**
	 * Remove all the entities in Medical Staff of Restricted Works certificate from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalStaffOfRestrictedWorksCertificate(boolean doReverse) {
		if (doReverse) {
			this.medicalStaffOfRestrictedWorksCertificate.forEach(medicalStaffOfRestrictedWorksCertificateEntity -> medicalStaffOfRestrictedWorksCertificateEntity.unsetMedicalStaff(false));
		}
		this.medicalStaffOfRestrictedWorksCertificate.clear();
	}

/**
	 * Similar to {@link this#addMedicalStaffOfSickLeavesCertificate(MedicalCertificateSickLeaveEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateSickLeaveEntity to be added to this entity
	 */
	public void addMedicalStaffOfSickLeavesCertificate(@NotNull MedicalCertificateSickLeaveEntity entity) {
		addMedicalStaffOfSickLeavesCertificate(entity, true);
	}

	/**
	 * Add a new MedicalCertificateSickLeaveEntity to medicalStaffOfSickLeavesCertificate in this entity.
	 *
	 * @param entity the given MedicalCertificateSickLeaveEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalStaffOfSickLeavesCertificate(@NonNull MedicalCertificateSickLeaveEntity entity, boolean reverseAdd) {
		if (!this.medicalStaffOfSickLeavesCertificate.contains(entity)) {
			medicalStaffOfSickLeavesCertificate.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalStaffOfSickLeavesCertificate(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateSickLeaveEntity to be added to this entity
	 */
	public void addMedicalStaffOfSickLeavesCertificate(@NotNull Collection<MedicalCertificateSickLeaveEntity> entities) {
		addMedicalStaffOfSickLeavesCertificate(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificateSickLeaveEntity to Medical Staff of Sick Leaves certificate in this entity.
	 *
	 * @param entities the given collection of MedicalCertificateSickLeaveEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalStaffOfSickLeavesCertificate(@NonNull Collection<MedicalCertificateSickLeaveEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalStaffOfSickLeavesCertificate(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfSickLeavesCertificate(MedicalCertificateSickLeaveEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateSickLeaveEntity to be set to this entity
	 */
	public void removeMedicalStaffOfSickLeavesCertificate(@NotNull MedicalCertificateSickLeaveEntity entity) {
		this.removeMedicalStaffOfSickLeavesCertificate(entity, true);
	}

	/**
	 * Remove the given MedicalCertificateSickLeaveEntity from this entity.
	 *
	 * @param entity the given MedicalCertificateSickLeaveEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalStaffOfSickLeavesCertificate(@NotNull MedicalCertificateSickLeaveEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.medicalStaffOfSickLeavesCertificate.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfSickLeavesCertificate(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificateSickLeaveEntity to be removed to this entity
	 */
	public void removeMedicalStaffOfSickLeavesCertificate(@NotNull Collection<MedicalCertificateSickLeaveEntity> entities) {
		this.removeMedicalStaffOfSickLeavesCertificate(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificateSickLeaveEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificateSickLeaveEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalStaffOfSickLeavesCertificate(@NonNull Collection<MedicalCertificateSickLeaveEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalStaffOfSickLeavesCertificate(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalStaffOfSickLeavesCertificate(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateSickLeaveEntity to be set to this entity
	 */
	public void setMedicalStaffOfSickLeavesCertificate(@NotNull Collection<MedicalCertificateSickLeaveEntity> entities) {
		setMedicalStaffOfSickLeavesCertificate(entities, true);
	}

	/**
	 * Replace the current entities in Medical Staff of Sick Leaves certificate with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificateSickLeaveEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalStaffOfSickLeavesCertificate(@NotNull Collection<MedicalCertificateSickLeaveEntity> entities, boolean reverseAdd) {

		this.unsetMedicalStaffOfSickLeavesCertificate();
		this.medicalStaffOfSickLeavesCertificate = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalStaffOfSickLeavesCertificate.forEach(medicalStaffOfSickLeavesCertificateEntity -> medicalStaffOfSickLeavesCertificateEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalStaffOfSickLeavesCertificate(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalStaffOfSickLeavesCertificate() {
		this.unsetMedicalStaffOfSickLeavesCertificate(true);
	}

	/**
	 * Remove all the entities in Medical Staff of Sick Leaves certificate from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalStaffOfSickLeavesCertificate(boolean doReverse) {
		if (doReverse) {
			this.medicalStaffOfSickLeavesCertificate.forEach(medicalStaffOfSickLeavesCertificateEntity -> medicalStaffOfSickLeavesCertificateEntity.unsetMedicalStaff(false));
		}
		this.medicalStaffOfSickLeavesCertificate.clear();
	}

/**
	 * Similar to {@link this#addMedicationAdministeredHisotries(MedicationAdministeredHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity to be added to this entity
	 */
	public void addMedicationAdministeredHisotries(@NotNull MedicationAdministeredHistoryEntity entity) {
		addMedicationAdministeredHisotries(entity, true);
	}

	/**
	 * Add a new MedicationAdministeredHistoryEntity to medicationAdministeredHisotries in this entity.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicationAdministeredHisotries(@NonNull MedicationAdministeredHistoryEntity entity, boolean reverseAdd) {
		if (!this.medicationAdministeredHisotries.contains(entity)) {
			medicationAdministeredHisotries.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicationAdministeredHisotries(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be added to this entity
	 */
	public void addMedicationAdministeredHisotries(@NotNull Collection<MedicationAdministeredHistoryEntity> entities) {
		addMedicationAdministeredHisotries(entities, true);
	}

	/**
	 * Add a new collection of MedicationAdministeredHistoryEntity to Medication Administered Hisotries in this entity.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicationAdministeredHisotries(@NonNull Collection<MedicationAdministeredHistoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicationAdministeredHisotries(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicationAdministeredHisotries(MedicationAdministeredHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity to be set to this entity
	 */
	public void removeMedicationAdministeredHisotries(@NotNull MedicationAdministeredHistoryEntity entity) {
		this.removeMedicationAdministeredHisotries(entity, true);
	}

	/**
	 * Remove the given MedicationAdministeredHistoryEntity from this entity.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationAdministeredHisotries(@NotNull MedicationAdministeredHistoryEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.medicationAdministeredHisotries.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicationAdministeredHisotries(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be removed to this entity
	 */
	public void removeMedicationAdministeredHisotries(@NotNull Collection<MedicationAdministeredHistoryEntity> entities) {
		this.removeMedicationAdministeredHisotries(entities, true);
	}

	/**
	 * Remove the given collection of MedicationAdministeredHistoryEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicationAdministeredHisotries(@NonNull Collection<MedicationAdministeredHistoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicationAdministeredHisotries(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicationAdministeredHisotries(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be set to this entity
	 */
	public void setMedicationAdministeredHisotries(@NotNull Collection<MedicationAdministeredHistoryEntity> entities) {
		setMedicationAdministeredHisotries(entities, true);
	}

	/**
	 * Replace the current entities in Medication Administered Hisotries with the given ones.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationAdministeredHisotries(@NotNull Collection<MedicationAdministeredHistoryEntity> entities, boolean reverseAdd) {

		this.unsetMedicationAdministeredHisotries();
		this.medicationAdministeredHisotries = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicationAdministeredHisotries.forEach(medicationAdministeredHisotriesEntity -> medicationAdministeredHisotriesEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicationAdministeredHisotries(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicationAdministeredHisotries() {
		this.unsetMedicationAdministeredHisotries(true);
	}

	/**
	 * Remove all the entities in Medication Administered Hisotries from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicationAdministeredHisotries(boolean doReverse) {
		if (doReverse) {
			this.medicationAdministeredHisotries.forEach(medicationAdministeredHisotriesEntity -> medicationAdministeredHisotriesEntity.unsetStaff(false));
		}
		this.medicationAdministeredHisotries.clear();
	}

/**
	 * Similar to {@link this#addMedicationHeaders(MedicationHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationHeaderEntity to be added to this entity
	 */
	public void addMedicationHeaders(@NotNull MedicationHeaderEntity entity) {
		addMedicationHeaders(entity, true);
	}

	/**
	 * Add a new MedicationHeaderEntity to medicationHeaders in this entity.
	 *
	 * @param entity the given MedicationHeaderEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicationHeaders(@NonNull MedicationHeaderEntity entity, boolean reverseAdd) {
		if (!this.medicationHeaders.contains(entity)) {
			medicationHeaders.add(entity);
			if (reverseAdd) {
				entity.setRequestedBy(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicationHeaders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to be added to this entity
	 */
	public void addMedicationHeaders(@NotNull Collection<MedicationHeaderEntity> entities) {
		addMedicationHeaders(entities, true);
	}

	/**
	 * Add a new collection of MedicationHeaderEntity to Medication Headers in this entity.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicationHeaders(@NonNull Collection<MedicationHeaderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicationHeaders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicationHeaders(MedicationHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationHeaderEntity to be set to this entity
	 */
	public void removeMedicationHeaders(@NotNull MedicationHeaderEntity entity) {
		this.removeMedicationHeaders(entity, true);
	}

	/**
	 * Remove the given MedicationHeaderEntity from this entity.
	 *
	 * @param entity the given MedicationHeaderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationHeaders(@NotNull MedicationHeaderEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetRequestedBy(false);
		}
		this.medicationHeaders.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicationHeaders(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to be removed to this entity
	 */
	public void removeMedicationHeaders(@NotNull Collection<MedicationHeaderEntity> entities) {
		this.removeMedicationHeaders(entities, true);
	}

	/**
	 * Remove the given collection of MedicationHeaderEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicationHeaders(@NonNull Collection<MedicationHeaderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicationHeaders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicationHeaders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to be set to this entity
	 */
	public void setMedicationHeaders(@NotNull Collection<MedicationHeaderEntity> entities) {
		setMedicationHeaders(entities, true);
	}

	/**
	 * Replace the current entities in Medication Headers with the given ones.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationHeaders(@NotNull Collection<MedicationHeaderEntity> entities, boolean reverseAdd) {

		this.unsetMedicationHeaders();
		this.medicationHeaders = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicationHeaders.forEach(medicationHeadersEntity -> medicationHeadersEntity.setRequestedBy(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicationHeaders(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicationHeaders() {
		this.unsetMedicationHeaders(true);
	}

	/**
	 * Remove all the entities in Medication Headers from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicationHeaders(boolean doReverse) {
		if (doReverse) {
			this.medicationHeaders.forEach(medicationHeadersEntity -> medicationHeadersEntity.unsetRequestedBy(false));
		}
		this.medicationHeaders.clear();
	}

/**
	 * Similar to {@link this#addMidwives(DeliveryMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addMidwives(@NotNull DeliveryMedicalExaminationRecordEntity entity) {
		addMidwives(entity, true);
	}

	/**
	 * Add a new DeliveryMedicalExaminationRecordEntity to midwives in this entity.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMidwives(@NonNull DeliveryMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.midwives.contains(entity)) {
			midwives.add(entity);
			if (reverseAdd) {
				entity.setMidwife(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMidwives(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DeliveryMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addMidwives(@NotNull Collection<DeliveryMedicalExaminationRecordEntity> entities) {
		addMidwives(entities, true);
	}

	/**
	 * Add a new collection of DeliveryMedicalExaminationRecordEntity to Midwives in this entity.
	 *
	 * @param entities the given collection of DeliveryMedicalExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMidwives(@NonNull Collection<DeliveryMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMidwives(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMidwives(DeliveryMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity to be set to this entity
	 */
	public void removeMidwives(@NotNull DeliveryMedicalExaminationRecordEntity entity) {
		this.removeMidwives(entity, true);
	}

	/**
	 * Remove the given DeliveryMedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMidwives(@NotNull DeliveryMedicalExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMidwife(false);
		}
		this.midwives.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMidwives(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DeliveryMedicalExaminationRecordEntity to be removed to this entity
	 */
	public void removeMidwives(@NotNull Collection<DeliveryMedicalExaminationRecordEntity> entities) {
		this.removeMidwives(entities, true);
	}

	/**
	 * Remove the given collection of DeliveryMedicalExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of DeliveryMedicalExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMidwives(@NonNull Collection<DeliveryMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMidwives(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMidwives(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DeliveryMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMidwives(@NotNull Collection<DeliveryMedicalExaminationRecordEntity> entities) {
		setMidwives(entities, true);
	}

	/**
	 * Replace the current entities in Midwives with the given ones.
	 *
	 * @param entities the given collection of DeliveryMedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMidwives(@NotNull Collection<DeliveryMedicalExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetMidwives();
		this.midwives = new HashSet<>(entities);
		if (reverseAdd) {
			this.midwives.forEach(midwivesEntity -> midwivesEntity.setMidwife(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMidwives(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMidwives() {
		this.unsetMidwives(true);
	}

	/**
	 * Remove all the entities in Midwives from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMidwives(boolean doReverse) {
		if (doReverse) {
			this.midwives.forEach(midwivesEntity -> midwivesEntity.unsetMidwife(false));
		}
		this.midwives.clear();
	}

/**
	 * Similar to {@link this#addNurse(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be added to this entity
	 */
	public void addNurse(@NotNull MedicalExaminationRecordEntity entity) {
		addNurse(entity, true);
	}

	/**
	 * Add a new MedicalExaminationRecordEntity to nurse in this entity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addNurse(@NonNull MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.nurse.contains(entity)) {
			nurse.add(entity);
			if (reverseAdd) {
				entity.setNurse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addNurse(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be added to this entity
	 */
	public void addNurse(@NotNull Collection<MedicalExaminationRecordEntity> entities) {
		addNurse(entities, true);
	}

	/**
	 * Add a new collection of MedicalExaminationRecordEntity to Nurse in this entity.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addNurse(@NonNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addNurse(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeNurse(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void removeNurse(@NotNull MedicalExaminationRecordEntity entity) {
		this.removeNurse(entity, true);
	}

	/**
	 * Remove the given MedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeNurse(@NotNull MedicalExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetNurse(false);
		}
		this.nurse.remove(entity);
	}

	/**
	 * Similar to {@link this#removeNurse(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be removed to this entity
	 */
	public void removeNurse(@NotNull Collection<MedicalExaminationRecordEntity> entities) {
		this.removeNurse(entities, true);
	}

	/**
	 * Remove the given collection of MedicalExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeNurse(@NonNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeNurse(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setNurse(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setNurse(@NotNull Collection<MedicalExaminationRecordEntity> entities) {
		setNurse(entities, true);
	}

	/**
	 * Replace the current entities in Nurse with the given ones.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setNurse(@NotNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetNurse();
		this.nurse = new HashSet<>(entities);
		if (reverseAdd) {
			this.nurse.forEach(nurseEntity -> nurseEntity.setNurse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetNurse(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetNurse() {
		this.unsetNurse(true);
	}

	/**
	 * Remove all the entities in Nurse from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetNurse(boolean doReverse) {
		if (doReverse) {
			this.nurse.forEach(nurseEntity -> nurseEntity.unsetNurse(false));
		}
		this.nurse.clear();
	}

/**
	 * Similar to {@link this#addNursingDetailSurgicalNursing(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addNursingDetailSurgicalNursing(@NotNull OperatingTheaterMedicalExaminationRecordEntity entity) {
		addNursingDetailSurgicalNursing(entity, true);
	}

	/**
	 * Add a new OperatingTheaterMedicalExaminationRecordEntity to nursingDetailSurgicalNursing in this entity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addNursingDetailSurgicalNursing(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.nursingDetailSurgicalNursing.contains(entity)) {
			nursingDetailSurgicalNursing.add(entity);
			if (reverseAdd) {
				entity.setNursingDetailSurgicalNursings(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addNursingDetailSurgicalNursing(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addNursingDetailSurgicalNursing(@NotNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		addNursingDetailSurgicalNursing(entities, true);
	}

	/**
	 * Add a new collection of OperatingTheaterMedicalExaminationRecordEntity to Nursing Detail Surgical Nursing in this entity.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addNursingDetailSurgicalNursing(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addNursingDetailSurgicalNursing(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeNursingDetailSurgicalNursing(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void removeNursingDetailSurgicalNursing(@NotNull OperatingTheaterMedicalExaminationRecordEntity entity) {
		this.removeNursingDetailSurgicalNursing(entity, true);
	}

	/**
	 * Remove the given OperatingTheaterMedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeNursingDetailSurgicalNursing(@NotNull OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetNursingDetailSurgicalNursings(false);
		}
		this.nursingDetailSurgicalNursing.remove(entity);
	}

	/**
	 * Similar to {@link this#removeNursingDetailSurgicalNursing(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be removed to this entity
	 */
	public void removeNursingDetailSurgicalNursing(@NotNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		this.removeNursingDetailSurgicalNursing(entities, true);
	}

	/**
	 * Remove the given collection of OperatingTheaterMedicalExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeNursingDetailSurgicalNursing(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeNursingDetailSurgicalNursing(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setNursingDetailSurgicalNursing(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setNursingDetailSurgicalNursing(@NotNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		setNursingDetailSurgicalNursing(entities, true);
	}

	/**
	 * Replace the current entities in Nursing Detail Surgical Nursing with the given ones.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setNursingDetailSurgicalNursing(@NotNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetNursingDetailSurgicalNursing();
		this.nursingDetailSurgicalNursing = new HashSet<>(entities);
		if (reverseAdd) {
			this.nursingDetailSurgicalNursing.forEach(nursingDetailSurgicalNursingEntity -> nursingDetailSurgicalNursingEntity.setNursingDetailSurgicalNursings(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetNursingDetailSurgicalNursing(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetNursingDetailSurgicalNursing() {
		this.unsetNursingDetailSurgicalNursing(true);
	}

	/**
	 * Remove all the entities in Nursing Detail Surgical Nursing from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetNursingDetailSurgicalNursing(boolean doReverse) {
		if (doReverse) {
			this.nursingDetailSurgicalNursing.forEach(nursingDetailSurgicalNursingEntity -> nursingDetailSurgicalNursingEntity.unsetNursingDetailSurgicalNursings(false));
		}
		this.nursingDetailSurgicalNursing.clear();
	}

/**
	 * Similar to {@link this#addNursingDetailsAnesthesiaNursing(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addNursingDetailsAnesthesiaNursing(@NotNull OperatingTheaterMedicalExaminationRecordEntity entity) {
		addNursingDetailsAnesthesiaNursing(entity, true);
	}

	/**
	 * Add a new OperatingTheaterMedicalExaminationRecordEntity to nursingDetailsAnesthesiaNursing in this entity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addNursingDetailsAnesthesiaNursing(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.nursingDetailsAnesthesiaNursing.contains(entity)) {
			nursingDetailsAnesthesiaNursing.add(entity);
			if (reverseAdd) {
				entity.setNursingDetailsAnesthesiaNursings(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addNursingDetailsAnesthesiaNursing(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addNursingDetailsAnesthesiaNursing(@NotNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		addNursingDetailsAnesthesiaNursing(entities, true);
	}

	/**
	 * Add a new collection of OperatingTheaterMedicalExaminationRecordEntity to Nursing Details Anesthesia Nursing in this entity.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addNursingDetailsAnesthesiaNursing(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addNursingDetailsAnesthesiaNursing(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeNursingDetailsAnesthesiaNursing(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void removeNursingDetailsAnesthesiaNursing(@NotNull OperatingTheaterMedicalExaminationRecordEntity entity) {
		this.removeNursingDetailsAnesthesiaNursing(entity, true);
	}

	/**
	 * Remove the given OperatingTheaterMedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeNursingDetailsAnesthesiaNursing(@NotNull OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetNursingDetailsAnesthesiaNursings(false);
		}
		this.nursingDetailsAnesthesiaNursing.remove(entity);
	}

	/**
	 * Similar to {@link this#removeNursingDetailsAnesthesiaNursing(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be removed to this entity
	 */
	public void removeNursingDetailsAnesthesiaNursing(@NotNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		this.removeNursingDetailsAnesthesiaNursing(entities, true);
	}

	/**
	 * Remove the given collection of OperatingTheaterMedicalExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeNursingDetailsAnesthesiaNursing(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeNursingDetailsAnesthesiaNursing(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setNursingDetailsAnesthesiaNursing(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setNursingDetailsAnesthesiaNursing(@NotNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		setNursingDetailsAnesthesiaNursing(entities, true);
	}

	/**
	 * Replace the current entities in Nursing Details Anesthesia Nursing with the given ones.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setNursingDetailsAnesthesiaNursing(@NotNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetNursingDetailsAnesthesiaNursing();
		this.nursingDetailsAnesthesiaNursing = new HashSet<>(entities);
		if (reverseAdd) {
			this.nursingDetailsAnesthesiaNursing.forEach(nursingDetailsAnesthesiaNursingEntity -> nursingDetailsAnesthesiaNursingEntity.setNursingDetailsAnesthesiaNursings(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetNursingDetailsAnesthesiaNursing(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetNursingDetailsAnesthesiaNursing() {
		this.unsetNursingDetailsAnesthesiaNursing(true);
	}

	/**
	 * Remove all the entities in Nursing Details Anesthesia Nursing from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetNursingDetailsAnesthesiaNursing(boolean doReverse) {
		if (doReverse) {
			this.nursingDetailsAnesthesiaNursing.forEach(nursingDetailsAnesthesiaNursingEntity -> nursingDetailsAnesthesiaNursingEntity.unsetNursingDetailsAnesthesiaNursings(false));
		}
		this.nursingDetailsAnesthesiaNursing.clear();
	}

	/**
	 * Similar to {@link this#setPcareDokter(PcareDokterEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setPcareDokter(@NotNull PcareDokterEntity entity) {
		setPcareDokter(entity, true);
	}

	/**
	 * Set or update pcareDokter with the given PcareDokterEntity.
	 *
	 * @param entity the StaffEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPcareDokter(@NotNull PcareDokterEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPcareDokter here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPcareDokter here] end

		if (sameAsFormer(this.pcareDokter, entity)) {
			return;
		}

		if (this.pcareDokter != null) {
			this.pcareDokter.unsetStaff();
		}

		this.pcareDokter = entity;

		if (reverseAdd) {
			this.pcareDokter.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPcareDokter outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPcareDokter outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPcareDokter(boolean)} but default to true.
	 */
	public void unsetPcareDokter() {
		this.unsetPcareDokter(true);
	}

	/**
	 * Remove the PcareDokterEntity in PCare Dokter from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPcareDokter(boolean reverse) {
		if (reverse && this.pcareDokter != null) {
			this.pcareDokter.unsetStaff(false);
		}
		this.pcareDokter = null;
	}

/**
	 * Similar to {@link this#addPatientConsents(PatientConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientConsentEntity to be added to this entity
	 */
	public void addPatientConsents(@NotNull PatientConsentEntity entity) {
		addPatientConsents(entity, true);
	}

	/**
	 * Add a new PatientConsentEntity to patientConsents in this entity.
	 *
	 * @param entity the given PatientConsentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPatientConsents(@NonNull PatientConsentEntity entity, boolean reverseAdd) {
		if (!this.patientConsents.contains(entity)) {
			patientConsents.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPatientConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientConsentEntity to be added to this entity
	 */
	public void addPatientConsents(@NotNull Collection<PatientConsentEntity> entities) {
		addPatientConsents(entities, true);
	}

	/**
	 * Add a new collection of PatientConsentEntity to Patient Consents in this entity.
	 *
	 * @param entities the given collection of PatientConsentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPatientConsents(@NonNull Collection<PatientConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPatientConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePatientConsents(PatientConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientConsentEntity to be set to this entity
	 */
	public void removePatientConsents(@NotNull PatientConsentEntity entity) {
		this.removePatientConsents(entity, true);
	}

	/**
	 * Remove the given PatientConsentEntity from this entity.
	 *
	 * @param entity the given PatientConsentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePatientConsents(@NotNull PatientConsentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.patientConsents.remove(entity);
	}

	/**
	 * Similar to {@link this#removePatientConsents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PatientConsentEntity to be removed to this entity
	 */
	public void removePatientConsents(@NotNull Collection<PatientConsentEntity> entities) {
		this.removePatientConsents(entities, true);
	}

	/**
	 * Remove the given collection of PatientConsentEntity from  to this entity.
	 *
	 * @param entities the given collection of PatientConsentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePatientConsents(@NonNull Collection<PatientConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePatientConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPatientConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientConsentEntity to be set to this entity
	 */
	public void setPatientConsents(@NotNull Collection<PatientConsentEntity> entities) {
		setPatientConsents(entities, true);
	}

	/**
	 * Replace the current entities in Patient Consents with the given ones.
	 *
	 * @param entities the given collection of PatientConsentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPatientConsents(@NotNull Collection<PatientConsentEntity> entities, boolean reverseAdd) {

		this.unsetPatientConsents();
		this.patientConsents = new HashSet<>(entities);
		if (reverseAdd) {
			this.patientConsents.forEach(patientConsentsEntity -> patientConsentsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPatientConsents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPatientConsents() {
		this.unsetPatientConsents(true);
	}

	/**
	 * Remove all the entities in Patient Consents from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPatientConsents(boolean doReverse) {
		if (doReverse) {
			this.patientConsents.forEach(patientConsentsEntity -> patientConsentsEntity.unsetStaff(false));
		}
		this.patientConsents.clear();
	}

/**
	 * Similar to {@link this#addPatientVitalInformations(PatientVitalInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVitalInformationEntity to be added to this entity
	 */
	public void addPatientVitalInformations(@NotNull PatientVitalInformationEntity entity) {
		addPatientVitalInformations(entity, true);
	}

	/**
	 * Add a new PatientVitalInformationEntity to patientVitalInformations in this entity.
	 *
	 * @param entity the given PatientVitalInformationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPatientVitalInformations(@NonNull PatientVitalInformationEntity entity, boolean reverseAdd) {
		if (!this.patientVitalInformations.contains(entity)) {
			patientVitalInformations.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPatientVitalInformations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientVitalInformationEntity to be added to this entity
	 */
	public void addPatientVitalInformations(@NotNull Collection<PatientVitalInformationEntity> entities) {
		addPatientVitalInformations(entities, true);
	}

	/**
	 * Add a new collection of PatientVitalInformationEntity to Patient Vital Informations in this entity.
	 *
	 * @param entities the given collection of PatientVitalInformationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPatientVitalInformations(@NonNull Collection<PatientVitalInformationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPatientVitalInformations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePatientVitalInformations(PatientVitalInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVitalInformationEntity to be set to this entity
	 */
	public void removePatientVitalInformations(@NotNull PatientVitalInformationEntity entity) {
		this.removePatientVitalInformations(entity, true);
	}

	/**
	 * Remove the given PatientVitalInformationEntity from this entity.
	 *
	 * @param entity the given PatientVitalInformationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePatientVitalInformations(@NotNull PatientVitalInformationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.patientVitalInformations.remove(entity);
	}

	/**
	 * Similar to {@link this#removePatientVitalInformations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PatientVitalInformationEntity to be removed to this entity
	 */
	public void removePatientVitalInformations(@NotNull Collection<PatientVitalInformationEntity> entities) {
		this.removePatientVitalInformations(entities, true);
	}

	/**
	 * Remove the given collection of PatientVitalInformationEntity from  to this entity.
	 *
	 * @param entities the given collection of PatientVitalInformationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePatientVitalInformations(@NonNull Collection<PatientVitalInformationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePatientVitalInformations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPatientVitalInformations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientVitalInformationEntity to be set to this entity
	 */
	public void setPatientVitalInformations(@NotNull Collection<PatientVitalInformationEntity> entities) {
		setPatientVitalInformations(entities, true);
	}

	/**
	 * Replace the current entities in Patient Vital Informations with the given ones.
	 *
	 * @param entities the given collection of PatientVitalInformationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPatientVitalInformations(@NotNull Collection<PatientVitalInformationEntity> entities, boolean reverseAdd) {

		this.unsetPatientVitalInformations();
		this.patientVitalInformations = new HashSet<>(entities);
		if (reverseAdd) {
			this.patientVitalInformations.forEach(patientVitalInformationsEntity -> patientVitalInformationsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPatientVitalInformations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPatientVitalInformations() {
		this.unsetPatientVitalInformations(true);
	}

	/**
	 * Remove all the entities in Patient Vital Informations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPatientVitalInformations(boolean doReverse) {
		if (doReverse) {
			this.patientVitalInformations.forEach(patientVitalInformationsEntity -> patientVitalInformationsEntity.unsetStaff(false));
		}
		this.patientVitalInformations.clear();
	}

/**
	 * Similar to {@link this#addPediatricianInCharge(NewbornDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given NewbornDetailEntity to be added to this entity
	 */
	public void addPediatricianInCharge(@NotNull NewbornDetailEntity entity) {
		addPediatricianInCharge(entity, true);
	}

	/**
	 * Add a new NewbornDetailEntity to pediatricianInCharge in this entity.
	 *
	 * @param entity the given NewbornDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPediatricianInCharge(@NonNull NewbornDetailEntity entity, boolean reverseAdd) {
		if (!this.pediatricianInCharge.contains(entity)) {
			pediatricianInCharge.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPediatricianInCharge(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be added to this entity
	 */
	public void addPediatricianInCharge(@NotNull Collection<NewbornDetailEntity> entities) {
		addPediatricianInCharge(entities, true);
	}

	/**
	 * Add a new collection of NewbornDetailEntity to Pediatrician In Charge in this entity.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPediatricianInCharge(@NonNull Collection<NewbornDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPediatricianInCharge(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePediatricianInCharge(NewbornDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given NewbornDetailEntity to be set to this entity
	 */
	public void removePediatricianInCharge(@NotNull NewbornDetailEntity entity) {
		this.removePediatricianInCharge(entity, true);
	}

	/**
	 * Remove the given NewbornDetailEntity from this entity.
	 *
	 * @param entity the given NewbornDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePediatricianInCharge(@NotNull NewbornDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.pediatricianInCharge.remove(entity);
	}

	/**
	 * Similar to {@link this#removePediatricianInCharge(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be removed to this entity
	 */
	public void removePediatricianInCharge(@NotNull Collection<NewbornDetailEntity> entities) {
		this.removePediatricianInCharge(entities, true);
	}

	/**
	 * Remove the given collection of NewbornDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePediatricianInCharge(@NonNull Collection<NewbornDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePediatricianInCharge(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPediatricianInCharge(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be set to this entity
	 */
	public void setPediatricianInCharge(@NotNull Collection<NewbornDetailEntity> entities) {
		setPediatricianInCharge(entities, true);
	}

	/**
	 * Replace the current entities in Pediatrician In Charge with the given ones.
	 *
	 * @param entities the given collection of NewbornDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPediatricianInCharge(@NotNull Collection<NewbornDetailEntity> entities, boolean reverseAdd) {

		this.unsetPediatricianInCharge();
		this.pediatricianInCharge = new HashSet<>(entities);
		if (reverseAdd) {
			this.pediatricianInCharge.forEach(pediatricianInChargeEntity -> pediatricianInChargeEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPediatricianInCharge(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPediatricianInCharge() {
		this.unsetPediatricianInCharge(true);
	}

	/**
	 * Remove all the entities in Pediatrician In Charge from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPediatricianInCharge(boolean doReverse) {
		if (doReverse) {
			this.pediatricianInCharge.forEach(pediatricianInChargeEntity -> pediatricianInChargeEntity.unsetStaff(false));
		}
		this.pediatricianInCharge.clear();
	}

/**
	 * Similar to {@link this#addPrescriptionHeaders(PrescriptionHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be added to this entity
	 */
	public void addPrescriptionHeaders(@NotNull PrescriptionHeaderEntity entity) {
		addPrescriptionHeaders(entity, true);
	}

	/**
	 * Add a new PrescriptionHeaderEntity to prescriptionHeaders in this entity.
	 *
	 * @param entity the given PrescriptionHeaderEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPrescriptionHeaders(@NonNull PrescriptionHeaderEntity entity, boolean reverseAdd) {
		if (!this.prescriptionHeaders.contains(entity)) {
			prescriptionHeaders.add(entity);
			if (reverseAdd) {
				entity.setRequestedBy(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPrescriptionHeaders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to be added to this entity
	 */
	public void addPrescriptionHeaders(@NotNull Collection<PrescriptionHeaderEntity> entities) {
		addPrescriptionHeaders(entities, true);
	}

	/**
	 * Add a new collection of PrescriptionHeaderEntity to Prescription Headers in this entity.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPrescriptionHeaders(@NonNull Collection<PrescriptionHeaderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPrescriptionHeaders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePrescriptionHeaders(PrescriptionHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be set to this entity
	 */
	public void removePrescriptionHeaders(@NotNull PrescriptionHeaderEntity entity) {
		this.removePrescriptionHeaders(entity, true);
	}

	/**
	 * Remove the given PrescriptionHeaderEntity from this entity.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePrescriptionHeaders(@NotNull PrescriptionHeaderEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetRequestedBy(false);
		}
		this.prescriptionHeaders.remove(entity);
	}

	/**
	 * Similar to {@link this#removePrescriptionHeaders(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to be removed to this entity
	 */
	public void removePrescriptionHeaders(@NotNull Collection<PrescriptionHeaderEntity> entities) {
		this.removePrescriptionHeaders(entities, true);
	}

	/**
	 * Remove the given collection of PrescriptionHeaderEntity from  to this entity.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePrescriptionHeaders(@NonNull Collection<PrescriptionHeaderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePrescriptionHeaders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPrescriptionHeaders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to be set to this entity
	 */
	public void setPrescriptionHeaders(@NotNull Collection<PrescriptionHeaderEntity> entities) {
		setPrescriptionHeaders(entities, true);
	}

	/**
	 * Replace the current entities in Prescription Headers with the given ones.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPrescriptionHeaders(@NotNull Collection<PrescriptionHeaderEntity> entities, boolean reverseAdd) {

		this.unsetPrescriptionHeaders();
		this.prescriptionHeaders = new HashSet<>(entities);
		if (reverseAdd) {
			this.prescriptionHeaders.forEach(prescriptionHeadersEntity -> prescriptionHeadersEntity.setRequestedBy(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPrescriptionHeaders(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPrescriptionHeaders() {
		this.unsetPrescriptionHeaders(true);
	}

	/**
	 * Remove all the entities in Prescription Headers from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPrescriptionHeaders(boolean doReverse) {
		if (doReverse) {
			this.prescriptionHeaders.forEach(prescriptionHeadersEntity -> prescriptionHeadersEntity.unsetRequestedBy(false));
		}
		this.prescriptionHeaders.clear();
	}

/**
	 * Similar to {@link this#addProcessWorkflowLogs(ProcessWorkflowEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ProcessWorkflowEntity to be added to this entity
	 */
	public void addProcessWorkflowLogs(@NotNull ProcessWorkflowEntity entity) {
		addProcessWorkflowLogs(entity, true);
	}

	/**
	 * Add a new ProcessWorkflowEntity to processWorkflowLogs in this entity.
	 *
	 * @param entity the given ProcessWorkflowEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addProcessWorkflowLogs(@NonNull ProcessWorkflowEntity entity, boolean reverseAdd) {
		if (!this.processWorkflowLogs.contains(entity)) {
			processWorkflowLogs.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addProcessWorkflowLogs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ProcessWorkflowEntity to be added to this entity
	 */
	public void addProcessWorkflowLogs(@NotNull Collection<ProcessWorkflowEntity> entities) {
		addProcessWorkflowLogs(entities, true);
	}

	/**
	 * Add a new collection of ProcessWorkflowEntity to Process Workflow Logs in this entity.
	 *
	 * @param entities the given collection of ProcessWorkflowEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addProcessWorkflowLogs(@NonNull Collection<ProcessWorkflowEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addProcessWorkflowLogs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeProcessWorkflowLogs(ProcessWorkflowEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ProcessWorkflowEntity to be set to this entity
	 */
	public void removeProcessWorkflowLogs(@NotNull ProcessWorkflowEntity entity) {
		this.removeProcessWorkflowLogs(entity, true);
	}

	/**
	 * Remove the given ProcessWorkflowEntity from this entity.
	 *
	 * @param entity the given ProcessWorkflowEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeProcessWorkflowLogs(@NotNull ProcessWorkflowEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.processWorkflowLogs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeProcessWorkflowLogs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ProcessWorkflowEntity to be removed to this entity
	 */
	public void removeProcessWorkflowLogs(@NotNull Collection<ProcessWorkflowEntity> entities) {
		this.removeProcessWorkflowLogs(entities, true);
	}

	/**
	 * Remove the given collection of ProcessWorkflowEntity from  to this entity.
	 *
	 * @param entities the given collection of ProcessWorkflowEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeProcessWorkflowLogs(@NonNull Collection<ProcessWorkflowEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeProcessWorkflowLogs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setProcessWorkflowLogs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ProcessWorkflowEntity to be set to this entity
	 */
	public void setProcessWorkflowLogs(@NotNull Collection<ProcessWorkflowEntity> entities) {
		setProcessWorkflowLogs(entities, true);
	}

	/**
	 * Replace the current entities in Process Workflow Logs with the given ones.
	 *
	 * @param entities the given collection of ProcessWorkflowEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setProcessWorkflowLogs(@NotNull Collection<ProcessWorkflowEntity> entities, boolean reverseAdd) {

		this.unsetProcessWorkflowLogs();
		this.processWorkflowLogs = new HashSet<>(entities);
		if (reverseAdd) {
			this.processWorkflowLogs.forEach(processWorkflowLogsEntity -> processWorkflowLogsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetProcessWorkflowLogs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetProcessWorkflowLogs() {
		this.unsetProcessWorkflowLogs(true);
	}

	/**
	 * Remove all the entities in Process Workflow Logs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetProcessWorkflowLogs(boolean doReverse) {
		if (doReverse) {
			this.processWorkflowLogs.forEach(processWorkflowLogsEntity -> processWorkflowLogsEntity.unsetStaff(false));
		}
		this.processWorkflowLogs.clear();
	}

/**
	 * Similar to {@link this#addRegistrations(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 */
	public void addRegistrations(@NotNull RegistrationEntity entity) {
		addRegistrations(entity, true);
	}

	/**
	 * Add a new RegistrationEntity to registrations in this entity.
	 *
	 * @param entity the given RegistrationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRegistrations(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.registrations.contains(entity)) {
			registrations.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRegistrations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 */
	public void addRegistrations(@NotNull Collection<RegistrationEntity> entities) {
		addRegistrations(entities, true);
	}

	/**
	 * Add a new collection of RegistrationEntity to Registrations in this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRegistrations(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRegistrations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRegistrations(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void removeRegistrations(@NotNull RegistrationEntity entity) {
		this.removeRegistrations(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRegistrations(@NotNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.registrations.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRegistrations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 */
	public void removeRegistrations(@NotNull Collection<RegistrationEntity> entities) {
		this.removeRegistrations(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity from  to this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRegistrations(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRegistrations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRegistrations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be set to this entity
	 */
	public void setRegistrations(@NotNull Collection<RegistrationEntity> entities) {
		setRegistrations(entities, true);
	}

	/**
	 * Replace the current entities in Registrations with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRegistrations(@NotNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

		this.unsetRegistrations();
		this.registrations = new HashSet<>(entities);
		if (reverseAdd) {
			this.registrations.forEach(registrationsEntity -> registrationsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRegistrations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRegistrations() {
		this.unsetRegistrations(true);
	}

	/**
	 * Remove all the entities in Registrations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRegistrations(boolean doReverse) {
		if (doReverse) {
			this.registrations.forEach(registrationsEntity -> registrationsEntity.unsetStaff(false));
		}
		this.registrations.clear();
	}

/**
	 * Similar to {@link this#addRequestedBy(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 */
	public void addRequestedBy(@NotNull RegistrationEntity entity) {
		addRequestedBy(entity, true);
	}

	/**
	 * Add a new RegistrationEntity to requestedBy in this entity.
	 *
	 * @param entity the given RegistrationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRequestedBy(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.requestedBy.contains(entity)) {
			requestedBy.add(entity);
			if (reverseAdd) {
				entity.setRequestedBy(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRequestedBy(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 */
	public void addRequestedBy(@NotNull Collection<RegistrationEntity> entities) {
		addRequestedBy(entities, true);
	}

	/**
	 * Add a new collection of RegistrationEntity to Requested By in this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRequestedBy(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRequestedBy(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRequestedBy(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void removeRequestedBy(@NotNull RegistrationEntity entity) {
		this.removeRequestedBy(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRequestedBy(@NotNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetRequestedBy(false);
		}
		this.requestedBy.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRequestedBy(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 */
	public void removeRequestedBy(@NotNull Collection<RegistrationEntity> entities) {
		this.removeRequestedBy(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity from  to this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRequestedBy(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRequestedBy(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRequestedBy(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be set to this entity
	 */
	public void setRequestedBy(@NotNull Collection<RegistrationEntity> entities) {
		setRequestedBy(entities, true);
	}

	/**
	 * Replace the current entities in Requested By with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRequestedBy(@NotNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

		this.unsetRequestedBy();
		this.requestedBy = new HashSet<>(entities);
		if (reverseAdd) {
			this.requestedBy.forEach(requestedByEntity -> requestedByEntity.setRequestedBy(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRequestedBy(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRequestedBy() {
		this.unsetRequestedBy(true);
	}

	/**
	 * Remove all the entities in Requested By from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRequestedBy(boolean doReverse) {
		if (doReverse) {
			this.requestedBy.forEach(requestedByEntity -> requestedByEntity.unsetRequestedBy(false));
		}
		this.requestedBy.clear();
	}

/**
	 * Similar to {@link this#addRoomTransfers(RoomTransferEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoomTransferEntity to be added to this entity
	 */
	public void addRoomTransfers(@NotNull RoomTransferEntity entity) {
		addRoomTransfers(entity, true);
	}

	/**
	 * Add a new RoomTransferEntity to roomTransfers in this entity.
	 *
	 * @param entity the given RoomTransferEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRoomTransfers(@NonNull RoomTransferEntity entity, boolean reverseAdd) {
		if (!this.roomTransfers.contains(entity)) {
			roomTransfers.add(entity);
			if (reverseAdd) {
				entity.setTransferringStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRoomTransfers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RoomTransferEntity to be added to this entity
	 */
	public void addRoomTransfers(@NotNull Collection<RoomTransferEntity> entities) {
		addRoomTransfers(entities, true);
	}

	/**
	 * Add a new collection of RoomTransferEntity to Room Transfers in this entity.
	 *
	 * @param entities the given collection of RoomTransferEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRoomTransfers(@NonNull Collection<RoomTransferEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRoomTransfers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRoomTransfers(RoomTransferEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoomTransferEntity to be set to this entity
	 */
	public void removeRoomTransfers(@NotNull RoomTransferEntity entity) {
		this.removeRoomTransfers(entity, true);
	}

	/**
	 * Remove the given RoomTransferEntity from this entity.
	 *
	 * @param entity the given RoomTransferEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRoomTransfers(@NotNull RoomTransferEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTransferringStaff(false);
		}
		this.roomTransfers.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRoomTransfers(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RoomTransferEntity to be removed to this entity
	 */
	public void removeRoomTransfers(@NotNull Collection<RoomTransferEntity> entities) {
		this.removeRoomTransfers(entities, true);
	}

	/**
	 * Remove the given collection of RoomTransferEntity from  to this entity.
	 *
	 * @param entities the given collection of RoomTransferEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRoomTransfers(@NonNull Collection<RoomTransferEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRoomTransfers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRoomTransfers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RoomTransferEntity to be set to this entity
	 */
	public void setRoomTransfers(@NotNull Collection<RoomTransferEntity> entities) {
		setRoomTransfers(entities, true);
	}

	/**
	 * Replace the current entities in Room Transfers with the given ones.
	 *
	 * @param entities the given collection of RoomTransferEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRoomTransfers(@NotNull Collection<RoomTransferEntity> entities, boolean reverseAdd) {

		this.unsetRoomTransfers();
		this.roomTransfers = new HashSet<>(entities);
		if (reverseAdd) {
			this.roomTransfers.forEach(roomTransfersEntity -> roomTransfersEntity.setTransferringStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRoomTransfers(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRoomTransfers() {
		this.unsetRoomTransfers(true);
	}

	/**
	 * Remove all the entities in Room Transfers from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRoomTransfers(boolean doReverse) {
		if (doReverse) {
			this.roomTransfers.forEach(roomTransfersEntity -> roomTransfersEntity.unsetTransferringStaff(false));
		}
		this.roomTransfers.clear();
	}

/**
	 * Similar to {@link this#addSampleCollectionStaffs(SampleCollectionItemsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be added to this entity
	 */
	public void addSampleCollectionStaffs(@NotNull SampleCollectionItemsEntity entity) {
		addSampleCollectionStaffs(entity, true);
	}

	/**
	 * Add a new SampleCollectionItemsEntity to sampleCollectionStaffs in this entity.
	 *
	 * @param entity the given SampleCollectionItemsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSampleCollectionStaffs(@NonNull SampleCollectionItemsEntity entity, boolean reverseAdd) {
		if (!this.sampleCollectionStaffs.contains(entity)) {
			sampleCollectionStaffs.add(entity);
			if (reverseAdd) {
				entity.setSampleCollectionStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSampleCollectionStaffs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be added to this entity
	 */
	public void addSampleCollectionStaffs(@NotNull Collection<SampleCollectionItemsEntity> entities) {
		addSampleCollectionStaffs(entities, true);
	}

	/**
	 * Add a new collection of SampleCollectionItemsEntity to Sample Collection Staffs in this entity.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSampleCollectionStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSampleCollectionStaffs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSampleCollectionStaffs(SampleCollectionItemsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be set to this entity
	 */
	public void removeSampleCollectionStaffs(@NotNull SampleCollectionItemsEntity entity) {
		this.removeSampleCollectionStaffs(entity, true);
	}

	/**
	 * Remove the given SampleCollectionItemsEntity from this entity.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSampleCollectionStaffs(@NotNull SampleCollectionItemsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSampleCollectionStaff(false);
		}
		this.sampleCollectionStaffs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSampleCollectionStaffs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be removed to this entity
	 */
	public void removeSampleCollectionStaffs(@NotNull Collection<SampleCollectionItemsEntity> entities) {
		this.removeSampleCollectionStaffs(entities, true);
	}

	/**
	 * Remove the given collection of SampleCollectionItemsEntity from  to this entity.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSampleCollectionStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSampleCollectionStaffs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSampleCollectionStaffs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be set to this entity
	 */
	public void setSampleCollectionStaffs(@NotNull Collection<SampleCollectionItemsEntity> entities) {
		setSampleCollectionStaffs(entities, true);
	}

	/**
	 * Replace the current entities in Sample Collection Staffs with the given ones.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSampleCollectionStaffs(@NotNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {

		this.unsetSampleCollectionStaffs();
		this.sampleCollectionStaffs = new HashSet<>(entities);
		if (reverseAdd) {
			this.sampleCollectionStaffs.forEach(sampleCollectionStaffsEntity -> sampleCollectionStaffsEntity.setSampleCollectionStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSampleCollectionStaffs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSampleCollectionStaffs() {
		this.unsetSampleCollectionStaffs(true);
	}

	/**
	 * Remove all the entities in Sample Collection Staffs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSampleCollectionStaffs(boolean doReverse) {
		if (doReverse) {
			this.sampleCollectionStaffs.forEach(sampleCollectionStaffsEntity -> sampleCollectionStaffsEntity.unsetSampleCollectionStaff(false));
		}
		this.sampleCollectionStaffs.clear();
	}

/**
	 * Similar to {@link this#addSampleDeliveryStaffs(SampleCollectionItemsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be added to this entity
	 */
	public void addSampleDeliveryStaffs(@NotNull SampleCollectionItemsEntity entity) {
		addSampleDeliveryStaffs(entity, true);
	}

	/**
	 * Add a new SampleCollectionItemsEntity to sampleDeliveryStaffs in this entity.
	 *
	 * @param entity the given SampleCollectionItemsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSampleDeliveryStaffs(@NonNull SampleCollectionItemsEntity entity, boolean reverseAdd) {
		if (!this.sampleDeliveryStaffs.contains(entity)) {
			sampleDeliveryStaffs.add(entity);
			if (reverseAdd) {
				entity.setSampleDeliveryStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSampleDeliveryStaffs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be added to this entity
	 */
	public void addSampleDeliveryStaffs(@NotNull Collection<SampleCollectionItemsEntity> entities) {
		addSampleDeliveryStaffs(entities, true);
	}

	/**
	 * Add a new collection of SampleCollectionItemsEntity to Sample Delivery Staffs in this entity.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSampleDeliveryStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSampleDeliveryStaffs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSampleDeliveryStaffs(SampleCollectionItemsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be set to this entity
	 */
	public void removeSampleDeliveryStaffs(@NotNull SampleCollectionItemsEntity entity) {
		this.removeSampleDeliveryStaffs(entity, true);
	}

	/**
	 * Remove the given SampleCollectionItemsEntity from this entity.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSampleDeliveryStaffs(@NotNull SampleCollectionItemsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSampleDeliveryStaff(false);
		}
		this.sampleDeliveryStaffs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSampleDeliveryStaffs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be removed to this entity
	 */
	public void removeSampleDeliveryStaffs(@NotNull Collection<SampleCollectionItemsEntity> entities) {
		this.removeSampleDeliveryStaffs(entities, true);
	}

	/**
	 * Remove the given collection of SampleCollectionItemsEntity from  to this entity.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSampleDeliveryStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSampleDeliveryStaffs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSampleDeliveryStaffs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be set to this entity
	 */
	public void setSampleDeliveryStaffs(@NotNull Collection<SampleCollectionItemsEntity> entities) {
		setSampleDeliveryStaffs(entities, true);
	}

	/**
	 * Replace the current entities in Sample Delivery Staffs with the given ones.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSampleDeliveryStaffs(@NotNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {

		this.unsetSampleDeliveryStaffs();
		this.sampleDeliveryStaffs = new HashSet<>(entities);
		if (reverseAdd) {
			this.sampleDeliveryStaffs.forEach(sampleDeliveryStaffsEntity -> sampleDeliveryStaffsEntity.setSampleDeliveryStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSampleDeliveryStaffs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSampleDeliveryStaffs() {
		this.unsetSampleDeliveryStaffs(true);
	}

	/**
	 * Remove all the entities in Sample Delivery Staffs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSampleDeliveryStaffs(boolean doReverse) {
		if (doReverse) {
			this.sampleDeliveryStaffs.forEach(sampleDeliveryStaffsEntity -> sampleDeliveryStaffsEntity.unsetSampleDeliveryStaff(false));
		}
		this.sampleDeliveryStaffs.clear();
	}

/**
	 * Similar to {@link this#addSampleProcessingStaffs(SampleCollectionItemsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be added to this entity
	 */
	public void addSampleProcessingStaffs(@NotNull SampleCollectionItemsEntity entity) {
		addSampleProcessingStaffs(entity, true);
	}

	/**
	 * Add a new SampleCollectionItemsEntity to sampleProcessingStaffs in this entity.
	 *
	 * @param entity the given SampleCollectionItemsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSampleProcessingStaffs(@NonNull SampleCollectionItemsEntity entity, boolean reverseAdd) {
		if (!this.sampleProcessingStaffs.contains(entity)) {
			sampleProcessingStaffs.add(entity);
			if (reverseAdd) {
				entity.setSampleProcessingStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSampleProcessingStaffs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be added to this entity
	 */
	public void addSampleProcessingStaffs(@NotNull Collection<SampleCollectionItemsEntity> entities) {
		addSampleProcessingStaffs(entities, true);
	}

	/**
	 * Add a new collection of SampleCollectionItemsEntity to Sample Processing Staffs in this entity.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSampleProcessingStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSampleProcessingStaffs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSampleProcessingStaffs(SampleCollectionItemsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be set to this entity
	 */
	public void removeSampleProcessingStaffs(@NotNull SampleCollectionItemsEntity entity) {
		this.removeSampleProcessingStaffs(entity, true);
	}

	/**
	 * Remove the given SampleCollectionItemsEntity from this entity.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSampleProcessingStaffs(@NotNull SampleCollectionItemsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSampleProcessingStaff(false);
		}
		this.sampleProcessingStaffs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSampleProcessingStaffs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be removed to this entity
	 */
	public void removeSampleProcessingStaffs(@NotNull Collection<SampleCollectionItemsEntity> entities) {
		this.removeSampleProcessingStaffs(entities, true);
	}

	/**
	 * Remove the given collection of SampleCollectionItemsEntity from  to this entity.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSampleProcessingStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSampleProcessingStaffs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSampleProcessingStaffs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be set to this entity
	 */
	public void setSampleProcessingStaffs(@NotNull Collection<SampleCollectionItemsEntity> entities) {
		setSampleProcessingStaffs(entities, true);
	}

	/**
	 * Replace the current entities in Sample Processing Staffs with the given ones.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSampleProcessingStaffs(@NotNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {

		this.unsetSampleProcessingStaffs();
		this.sampleProcessingStaffs = new HashSet<>(entities);
		if (reverseAdd) {
			this.sampleProcessingStaffs.forEach(sampleProcessingStaffsEntity -> sampleProcessingStaffsEntity.setSampleProcessingStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSampleProcessingStaffs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSampleProcessingStaffs() {
		this.unsetSampleProcessingStaffs(true);
	}

	/**
	 * Remove all the entities in Sample Processing Staffs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSampleProcessingStaffs(boolean doReverse) {
		if (doReverse) {
			this.sampleProcessingStaffs.forEach(sampleProcessingStaffsEntity -> sampleProcessingStaffsEntity.unsetSampleProcessingStaff(false));
		}
		this.sampleProcessingStaffs.clear();
	}

	/**
	 * Similar to {@link this#setService(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setService(@NotNull ServiceEntity entity) {
		setService(entity, true);
	}

	/**
	 * Set or update service with the given ServiceEntity.
	 *
	 * @param entity the StaffEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setService(@NotNull ServiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setService here] off begin
		// % protected region % [Add any additional logic here before the main logic for setService here] end

		if (sameAsFormer(this.service, entity)) {
			return;
		}

		if (this.service != null) {
			this.service.unsetDefaultMedicalStaff();
		}

		this.service = entity;

		if (reverseAdd) {
			this.service.setDefaultMedicalStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setService outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setService outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetService(boolean)} but default to true.
	 */
	public void unsetService() {
		this.unsetService(true);
	}

	/**
	 * Remove the ServiceEntity in Service from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetService(boolean reverse) {
		if (reverse && this.service != null) {
			this.service.unsetDefaultMedicalStaff(false);
		}
		this.service = null;
	}

	/**
	 * Similar to {@link this#addServices(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be added to this entity
	 */
	public void addServices(@NotNull ServiceEntity entity) {
		addServices(entity, true);
	}

	/**
	 * Add a new ServiceEntity to Services in this entity.
	 *
	 * @param entity the given ServiceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addServices(@NonNull ServiceEntity entity, boolean reverseAdd) {
		if (!this.services.contains(entity)) {
			this.services.add(entity);
			if (reverseAdd) {
				entity.addAssignedMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addServices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given entities to be added to this entity
	 */
	public void addServices(@NotNull Collection<ServiceEntity> entities) {
		addServices(entities, true);
	}

	/**
	 * Add new collection of ServiceEntity to services in this entity.
	 *
	 * @param entities the given entities to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addServices(@NonNull Collection<ServiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addServices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeServices(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be set to this entity
	 */
	public void removeServices(@NotNull ServiceEntity entity) {
		this.removeServices(entity, true);
	}

	/**
	 * Remove the given ServiceEntity from this entity.
	 *
	 * @param entity the give ServiceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeServices(@NotNull ServiceEntity entity, boolean reverse) {
		if (reverse) {
			entity.removeAssignedMedicalStaff(this, false);
		}
		this.services.remove(entity);
	}

	/**
	 * Similar to {@link this#removeServices(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given entities to be removed to this entity
	 */
	public void removeServices(@NotNull Collection<ServiceEntity> entities) {
		this.removeServices(entities, true);
	}

	/**
	 * Remove the given collection of ServiceEntity in services from  to this entity.
	 *
	 * @param entities the given entities to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeServices(@NonNull Collection<ServiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeServices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setServices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given entities to be set to this entity
	 */
	public void setServices(@NotNull Collection<ServiceEntity> entities) {
		this.setServices(entities, true);
	}

	/**
	 * Replace the current entities in services with the given ones.
	 *
	 * @param entities the given entities to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setServices(@NotNull Collection<ServiceEntity> entities, boolean reverseAdd) {
		this.unsetServices();
		this.services = new HashSet<>(entities);
		if (reverseAdd) {
			this.services.forEach(entity -> entity.addAssignedMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetServices(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetServices() {
		this.unsetServices(true);
	}

	/**
	 * Remove all entities in services from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetServices(boolean doReverse) {
		if (doReverse) {
			this.services.forEach(entity -> entity.removeAssignedMedicalStaff(this, false));
		}
		this.services.clear();
	}

/**
	 * Similar to {@link this#addSurgeon(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be added to this entity
	 */
	public void addSurgeon(@NotNull PreoperativeRecordsEntity entity) {
		addSurgeon(entity, true);
	}

	/**
	 * Add a new PreoperativeRecordsEntity to surgeon in this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSurgeon(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		if (!this.surgeon.contains(entity)) {
			surgeon.add(entity);
			if (reverseAdd) {
				entity.setSurgeon(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSurgeon(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 */
	public void addSurgeon(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		addSurgeon(entities, true);
	}

	/**
	 * Add a new collection of PreoperativeRecordsEntity to Surgeon in this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSurgeon(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSurgeon(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSurgeon(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void removeSurgeon(@NotNull PreoperativeRecordsEntity entity) {
		this.removeSurgeon(entity, true);
	}

	/**
	 * Remove the given PreoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSurgeon(@NotNull PreoperativeRecordsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSurgeon(false);
		}
		this.surgeon.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSurgeon(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 */
	public void removeSurgeon(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		this.removeSurgeon(entities, true);
	}

	/**
	 * Remove the given collection of PreoperativeRecordsEntity from  to this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSurgeon(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSurgeon(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSurgeon(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be set to this entity
	 */
	public void setSurgeon(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		setSurgeon(entities, true);
	}

	/**
	 * Replace the current entities in Surgeon with the given ones.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSurgeon(@NotNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {

		this.unsetSurgeon();
		this.surgeon = new HashSet<>(entities);
		if (reverseAdd) {
			this.surgeon.forEach(surgeonEntity -> surgeonEntity.setSurgeon(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSurgeon(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSurgeon() {
		this.unsetSurgeon(true);
	}

	/**
	 * Remove all the entities in Surgeon from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSurgeon(boolean doReverse) {
		if (doReverse) {
			this.surgeon.forEach(surgeonEntity -> surgeonEntity.unsetSurgeon(false));
		}
		this.surgeon.clear();
	}

/**
	 * Similar to {@link this#addSurgicalMedicalTranscriber(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be added to this entity
	 */
	public void addSurgicalMedicalTranscriber(@NotNull PreoperativeRecordsEntity entity) {
		addSurgicalMedicalTranscriber(entity, true);
	}

	/**
	 * Add a new PreoperativeRecordsEntity to surgicalMedicalTranscriber in this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSurgicalMedicalTranscriber(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		if (!this.surgicalMedicalTranscriber.contains(entity)) {
			surgicalMedicalTranscriber.add(entity);
			if (reverseAdd) {
				entity.setSurgicalMedicalTranscriber(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSurgicalMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 */
	public void addSurgicalMedicalTranscriber(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		addSurgicalMedicalTranscriber(entities, true);
	}

	/**
	 * Add a new collection of PreoperativeRecordsEntity to Surgical Medical Transcriber in this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSurgicalMedicalTranscriber(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSurgicalMedicalTranscriber(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSurgicalMedicalTranscriber(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void removeSurgicalMedicalTranscriber(@NotNull PreoperativeRecordsEntity entity) {
		this.removeSurgicalMedicalTranscriber(entity, true);
	}

	/**
	 * Remove the given PreoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSurgicalMedicalTranscriber(@NotNull PreoperativeRecordsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSurgicalMedicalTranscriber(false);
		}
		this.surgicalMedicalTranscriber.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSurgicalMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 */
	public void removeSurgicalMedicalTranscriber(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		this.removeSurgicalMedicalTranscriber(entities, true);
	}

	/**
	 * Remove the given collection of PreoperativeRecordsEntity from  to this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSurgicalMedicalTranscriber(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSurgicalMedicalTranscriber(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSurgicalMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be set to this entity
	 */
	public void setSurgicalMedicalTranscriber(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		setSurgicalMedicalTranscriber(entities, true);
	}

	/**
	 * Replace the current entities in Surgical Medical Transcriber with the given ones.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSurgicalMedicalTranscriber(@NotNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {

		this.unsetSurgicalMedicalTranscriber();
		this.surgicalMedicalTranscriber = new HashSet<>(entities);
		if (reverseAdd) {
			this.surgicalMedicalTranscriber.forEach(surgicalMedicalTranscriberEntity -> surgicalMedicalTranscriberEntity.setSurgicalMedicalTranscriber(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSurgicalMedicalTranscriber(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSurgicalMedicalTranscriber() {
		this.unsetSurgicalMedicalTranscriber(true);
	}

	/**
	 * Remove all the entities in Surgical Medical Transcriber from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSurgicalMedicalTranscriber(boolean doReverse) {
		if (doReverse) {
			this.surgicalMedicalTranscriber.forEach(surgicalMedicalTranscriberEntity -> surgicalMedicalTranscriberEntity.unsetSurgicalMedicalTranscriber(false));
		}
		this.surgicalMedicalTranscriber.clear();
	}

/**
	 * Similar to {@link this#addSurgicalNurse(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be added to this entity
	 */
	public void addSurgicalNurse(@NotNull PreoperativeRecordsEntity entity) {
		addSurgicalNurse(entity, true);
	}

	/**
	 * Add a new PreoperativeRecordsEntity to surgicalNurse in this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSurgicalNurse(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		if (!this.surgicalNurse.contains(entity)) {
			surgicalNurse.add(entity);
			if (reverseAdd) {
				entity.setSurgicalNurse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSurgicalNurse(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 */
	public void addSurgicalNurse(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		addSurgicalNurse(entities, true);
	}

	/**
	 * Add a new collection of PreoperativeRecordsEntity to Surgical Nurse in this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSurgicalNurse(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSurgicalNurse(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSurgicalNurse(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void removeSurgicalNurse(@NotNull PreoperativeRecordsEntity entity) {
		this.removeSurgicalNurse(entity, true);
	}

	/**
	 * Remove the given PreoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSurgicalNurse(@NotNull PreoperativeRecordsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSurgicalNurse(false);
		}
		this.surgicalNurse.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSurgicalNurse(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 */
	public void removeSurgicalNurse(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		this.removeSurgicalNurse(entities, true);
	}

	/**
	 * Remove the given collection of PreoperativeRecordsEntity from  to this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSurgicalNurse(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSurgicalNurse(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSurgicalNurse(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be set to this entity
	 */
	public void setSurgicalNurse(@NotNull Collection<PreoperativeRecordsEntity> entities) {
		setSurgicalNurse(entities, true);
	}

	/**
	 * Replace the current entities in Surgical Nurse with the given ones.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSurgicalNurse(@NotNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {

		this.unsetSurgicalNurse();
		this.surgicalNurse = new HashSet<>(entities);
		if (reverseAdd) {
			this.surgicalNurse.forEach(surgicalNurseEntity -> surgicalNurseEntity.setSurgicalNurse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSurgicalNurse(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSurgicalNurse() {
		this.unsetSurgicalNurse(true);
	}

	/**
	 * Remove all the entities in Surgical Nurse from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSurgicalNurse(boolean doReverse) {
		if (doReverse) {
			this.surgicalNurse.forEach(surgicalNurseEntity -> surgicalNurseEntity.unsetSurgicalNurse(false));
		}
		this.surgicalNurse.clear();
	}

/**
	 * Similar to {@link this#addTransferOrderStockDetails(TransferOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be added to this entity
	 */
	public void addTransferOrderStockDetails(@NotNull TransferOrderStockDetailEntity entity) {
		addTransferOrderStockDetails(entity, true);
	}

	/**
	 * Add a new TransferOrderStockDetailEntity to transferOrderStockDetails in this entity.
	 *
	 * @param entity the given TransferOrderStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addTransferOrderStockDetails(@NonNull TransferOrderStockDetailEntity entity, boolean reverseAdd) {
		if (!this.transferOrderStockDetails.contains(entity)) {
			transferOrderStockDetails.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be added to this entity
	 */
	public void addTransferOrderStockDetails(@NotNull Collection<TransferOrderStockDetailEntity> entities) {
		addTransferOrderStockDetails(entities, true);
	}

	/**
	 * Add a new collection of TransferOrderStockDetailEntity to Transfer Order Stock Details in this entity.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addTransferOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeTransferOrderStockDetails(TransferOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be set to this entity
	 */
	public void removeTransferOrderStockDetails(@NotNull TransferOrderStockDetailEntity entity) {
		this.removeTransferOrderStockDetails(entity, true);
	}

	/**
	 * Remove the given TransferOrderStockDetailEntity from this entity.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTransferOrderStockDetails(@NotNull TransferOrderStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.transferOrderStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be removed to this entity
	 */
	public void removeTransferOrderStockDetails(@NotNull Collection<TransferOrderStockDetailEntity> entities) {
		this.removeTransferOrderStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of TransferOrderStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeTransferOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be set to this entity
	 */
	public void setTransferOrderStockDetails(@NotNull Collection<TransferOrderStockDetailEntity> entities) {
		setTransferOrderStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Transfer Order Stock Details with the given ones.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTransferOrderStockDetails(@NotNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetTransferOrderStockDetails();
		this.transferOrderStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.transferOrderStockDetails.forEach(transferOrderStockDetailsEntity -> transferOrderStockDetailsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetTransferOrderStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetTransferOrderStockDetails() {
		this.unsetTransferOrderStockDetails(true);
	}

	/**
	 * Remove all the entities in Transfer Order Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetTransferOrderStockDetails(boolean doReverse) {
		if (doReverse) {
			this.transferOrderStockDetails.forEach(transferOrderStockDetailsEntity -> transferOrderStockDetailsEntity.unsetStaff(false));
		}
		this.transferOrderStockDetails.clear();
	}

/**
	 * Similar to {@link this#addVaccinationOrders(VaccinationOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VaccinationOrderEntity to be added to this entity
	 */
	public void addVaccinationOrders(@NotNull VaccinationOrderEntity entity) {
		addVaccinationOrders(entity, true);
	}

	/**
	 * Add a new VaccinationOrderEntity to vaccinationOrders in this entity.
	 *
	 * @param entity the given VaccinationOrderEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addVaccinationOrders(@NonNull VaccinationOrderEntity entity, boolean reverseAdd) {
		if (!this.vaccinationOrders.contains(entity)) {
			vaccinationOrders.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addVaccinationOrders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of VaccinationOrderEntity to be added to this entity
	 */
	public void addVaccinationOrders(@NotNull Collection<VaccinationOrderEntity> entities) {
		addVaccinationOrders(entities, true);
	}

	/**
	 * Add a new collection of VaccinationOrderEntity to Vaccination Orders in this entity.
	 *
	 * @param entities the given collection of VaccinationOrderEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addVaccinationOrders(@NonNull Collection<VaccinationOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addVaccinationOrders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeVaccinationOrders(VaccinationOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VaccinationOrderEntity to be set to this entity
	 */
	public void removeVaccinationOrders(@NotNull VaccinationOrderEntity entity) {
		this.removeVaccinationOrders(entity, true);
	}

	/**
	 * Remove the given VaccinationOrderEntity from this entity.
	 *
	 * @param entity the given VaccinationOrderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeVaccinationOrders(@NotNull VaccinationOrderEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.vaccinationOrders.remove(entity);
	}

	/**
	 * Similar to {@link this#removeVaccinationOrders(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of VaccinationOrderEntity to be removed to this entity
	 */
	public void removeVaccinationOrders(@NotNull Collection<VaccinationOrderEntity> entities) {
		this.removeVaccinationOrders(entities, true);
	}

	/**
	 * Remove the given collection of VaccinationOrderEntity from  to this entity.
	 *
	 * @param entities the given collection of VaccinationOrderEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeVaccinationOrders(@NonNull Collection<VaccinationOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeVaccinationOrders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setVaccinationOrders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of VaccinationOrderEntity to be set to this entity
	 */
	public void setVaccinationOrders(@NotNull Collection<VaccinationOrderEntity> entities) {
		setVaccinationOrders(entities, true);
	}

	/**
	 * Replace the current entities in Vaccination Orders with the given ones.
	 *
	 * @param entities the given collection of VaccinationOrderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setVaccinationOrders(@NotNull Collection<VaccinationOrderEntity> entities, boolean reverseAdd) {

		this.unsetVaccinationOrders();
		this.vaccinationOrders = new HashSet<>(entities);
		if (reverseAdd) {
			this.vaccinationOrders.forEach(vaccinationOrdersEntity -> vaccinationOrdersEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetVaccinationOrders(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetVaccinationOrders() {
		this.unsetVaccinationOrders(true);
	}

	/**
	 * Remove all the entities in Vaccination Orders from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetVaccinationOrders(boolean doReverse) {
		if (doReverse) {
			this.vaccinationOrders.forEach(vaccinationOrdersEntity -> vaccinationOrdersEntity.unsetStaff(false));
		}
		this.vaccinationOrders.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setAdministrationUser(AdministrationUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given AdministrationUserEntity to be set to this entity
	 */
	public void setAdministrationUser(AdministrationUserEntity entity) {
		setAdministrationUser(entity, true);
	}

	/**
	 * Set or update the administrationUser in this entity with single AdministrationUserEntity.
	 *
	 * @param entity the given AdministrationUserEntity to be set or updated to administrationUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdministrationUser(AdministrationUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAdministrationUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAdministrationUser here] end

		if (sameAsFormer(this.administrationUser, entity)) {
			return;
		}

		if (this.administrationUser != null) {
			this.administrationUser.unsetStaff(false);
		}

		this.administrationUser = entity;
		if (reverseAdd) {
			this.administrationUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAdministrationUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAdministrationUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetAdministrationUser(boolean)} but default to true.
	 */
	public void unsetAdministrationUser() {
		this.unsetAdministrationUser(true);
	}

	/**
	 * Remove the AdministrationUserEntity of administrationUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAdministrationUser(boolean reverse) {
		if (reverse && this.administrationUser != null) {
			this.administrationUser.unsetStaff();
		}
		this.administrationUser = null;
	}
	/**
	 * Similar to {@link this#setCashierUser(CashierUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashierUserEntity to be set to this entity
	 */
	public void setCashierUser(CashierUserEntity entity) {
		setCashierUser(entity, true);
	}

	/**
	 * Set or update the cashierUser in this entity with single CashierUserEntity.
	 *
	 * @param entity the given CashierUserEntity to be set or updated to cashierUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setCashierUser(CashierUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setCashierUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setCashierUser here] end

		if (sameAsFormer(this.cashierUser, entity)) {
			return;
		}

		if (this.cashierUser != null) {
			this.cashierUser.unsetStaff(false);
		}

		this.cashierUser = entity;
		if (reverseAdd) {
			this.cashierUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setCashierUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setCashierUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetCashierUser(boolean)} but default to true.
	 */
	public void unsetCashierUser() {
		this.unsetCashierUser(true);
	}

	/**
	 * Remove the CashierUserEntity of cashierUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetCashierUser(boolean reverse) {
		if (reverse && this.cashierUser != null) {
			this.cashierUser.unsetStaff();
		}
		this.cashierUser = null;
	}
	/**
	 * Similar to {@link this#setClaimUser(ClaimUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ClaimUserEntity to be set to this entity
	 */
	public void setClaimUser(ClaimUserEntity entity) {
		setClaimUser(entity, true);
	}

	/**
	 * Set or update the claimUser in this entity with single ClaimUserEntity.
	 *
	 * @param entity the given ClaimUserEntity to be set or updated to claimUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setClaimUser(ClaimUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setClaimUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setClaimUser here] end

		if (sameAsFormer(this.claimUser, entity)) {
			return;
		}

		if (this.claimUser != null) {
			this.claimUser.unsetStaff(false);
		}

		this.claimUser = entity;
		if (reverseAdd) {
			this.claimUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setClaimUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setClaimUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetClaimUser(boolean)} but default to true.
	 */
	public void unsetClaimUser() {
		this.unsetClaimUser(true);
	}

	/**
	 * Remove the ClaimUserEntity of claimUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetClaimUser(boolean reverse) {
		if (reverse && this.claimUser != null) {
			this.claimUser.unsetStaff();
		}
		this.claimUser = null;
	}
	/**
	 * Similar to {@link this#setDiagnosticSupportUser(DiagnosticSupportUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosticSupportUserEntity to be set to this entity
	 */
	public void setDiagnosticSupportUser(DiagnosticSupportUserEntity entity) {
		setDiagnosticSupportUser(entity, true);
	}

	/**
	 * Set or update the diagnosticSupportUser in this entity with single DiagnosticSupportUserEntity.
	 *
	 * @param entity the given DiagnosticSupportUserEntity to be set or updated to diagnosticSupportUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDiagnosticSupportUser(DiagnosticSupportUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDiagnosticSupportUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDiagnosticSupportUser here] end

		if (sameAsFormer(this.diagnosticSupportUser, entity)) {
			return;
		}

		if (this.diagnosticSupportUser != null) {
			this.diagnosticSupportUser.unsetStaff(false);
		}

		this.diagnosticSupportUser = entity;
		if (reverseAdd) {
			this.diagnosticSupportUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDiagnosticSupportUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDiagnosticSupportUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDiagnosticSupportUser(boolean)} but default to true.
	 */
	public void unsetDiagnosticSupportUser() {
		this.unsetDiagnosticSupportUser(true);
	}

	/**
	 * Remove the DiagnosticSupportUserEntity of diagnosticSupportUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDiagnosticSupportUser(boolean reverse) {
		if (reverse && this.diagnosticSupportUser != null) {
			this.diagnosticSupportUser.unsetStaff();
		}
		this.diagnosticSupportUser = null;
	}
	/**
	 * Similar to {@link this#setDoctorUser(DoctorUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DoctorUserEntity to be set to this entity
	 */
	public void setDoctorUser(DoctorUserEntity entity) {
		setDoctorUser(entity, true);
	}

	/**
	 * Set or update the doctorUser in this entity with single DoctorUserEntity.
	 *
	 * @param entity the given DoctorUserEntity to be set or updated to doctorUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDoctorUser(DoctorUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDoctorUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDoctorUser here] end

		if (sameAsFormer(this.doctorUser, entity)) {
			return;
		}

		if (this.doctorUser != null) {
			this.doctorUser.unsetStaff(false);
		}

		this.doctorUser = entity;
		if (reverseAdd) {
			this.doctorUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDoctorUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDoctorUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDoctorUser(boolean)} but default to true.
	 */
	public void unsetDoctorUser() {
		this.unsetDoctorUser(true);
	}

	/**
	 * Remove the DoctorUserEntity of doctorUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDoctorUser(boolean reverse) {
		if (reverse && this.doctorUser != null) {
			this.doctorUser.unsetStaff();
		}
		this.doctorUser = null;
	}
	/**
	 * Similar to {@link this#setFacilityUser(FacilityUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given FacilityUserEntity to be set to this entity
	 */
	public void setFacilityUser(FacilityUserEntity entity) {
		setFacilityUser(entity, true);
	}

	/**
	 * Set or update the facilityUser in this entity with single FacilityUserEntity.
	 *
	 * @param entity the given FacilityUserEntity to be set or updated to facilityUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setFacilityUser(FacilityUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setFacilityUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setFacilityUser here] end

		if (sameAsFormer(this.facilityUser, entity)) {
			return;
		}

		if (this.facilityUser != null) {
			this.facilityUser.unsetStaff(false);
		}

		this.facilityUser = entity;
		if (reverseAdd) {
			this.facilityUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setFacilityUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setFacilityUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetFacilityUser(boolean)} but default to true.
	 */
	public void unsetFacilityUser() {
		this.unsetFacilityUser(true);
	}

	/**
	 * Remove the FacilityUserEntity of facilityUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetFacilityUser(boolean reverse) {
		if (reverse && this.facilityUser != null) {
			this.facilityUser.unsetStaff();
		}
		this.facilityUser = null;
	}
	/**
	 * Similar to {@link this#setManagementUser(ManagementUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ManagementUserEntity to be set to this entity
	 */
	public void setManagementUser(ManagementUserEntity entity) {
		setManagementUser(entity, true);
	}

	/**
	 * Set or update the managementUser in this entity with single ManagementUserEntity.
	 *
	 * @param entity the given ManagementUserEntity to be set or updated to managementUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setManagementUser(ManagementUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setManagementUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setManagementUser here] end

		if (sameAsFormer(this.managementUser, entity)) {
			return;
		}

		if (this.managementUser != null) {
			this.managementUser.unsetStaff(false);
		}

		this.managementUser = entity;
		if (reverseAdd) {
			this.managementUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setManagementUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setManagementUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetManagementUser(boolean)} but default to true.
	 */
	public void unsetManagementUser() {
		this.unsetManagementUser(true);
	}

	/**
	 * Remove the ManagementUserEntity of managementUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetManagementUser(boolean reverse) {
		if (reverse && this.managementUser != null) {
			this.managementUser.unsetStaff();
		}
		this.managementUser = null;
	}
	/**
	 * Similar to {@link this#setMedicalRecordUser(MedicalRecordUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalRecordUserEntity to be set to this entity
	 */
	public void setMedicalRecordUser(MedicalRecordUserEntity entity) {
		setMedicalRecordUser(entity, true);
	}

	/**
	 * Set or update the medicalRecordUser in this entity with single MedicalRecordUserEntity.
	 *
	 * @param entity the given MedicalRecordUserEntity to be set or updated to medicalRecordUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalRecordUser(MedicalRecordUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalRecordUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalRecordUser here] end

		if (sameAsFormer(this.medicalRecordUser, entity)) {
			return;
		}

		if (this.medicalRecordUser != null) {
			this.medicalRecordUser.unsetStaff(false);
		}

		this.medicalRecordUser = entity;
		if (reverseAdd) {
			this.medicalRecordUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalRecordUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalRecordUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalRecordUser(boolean)} but default to true.
	 */
	public void unsetMedicalRecordUser() {
		this.unsetMedicalRecordUser(true);
	}

	/**
	 * Remove the MedicalRecordUserEntity of medicalRecordUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalRecordUser(boolean reverse) {
		if (reverse && this.medicalRecordUser != null) {
			this.medicalRecordUser.unsetStaff();
		}
		this.medicalRecordUser = null;
	}
	/**
	 * Similar to {@link this#setMedicalTranscriberUser(MedicalTranscriberUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalTranscriberUserEntity to be set to this entity
	 */
	public void setMedicalTranscriberUser(MedicalTranscriberUserEntity entity) {
		setMedicalTranscriberUser(entity, true);
	}

	/**
	 * Set or update the medicalTranscriberUser in this entity with single MedicalTranscriberUserEntity.
	 *
	 * @param entity the given MedicalTranscriberUserEntity to be set or updated to medicalTranscriberUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalTranscriberUser(MedicalTranscriberUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalTranscriberUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalTranscriberUser here] end

		if (sameAsFormer(this.medicalTranscriberUser, entity)) {
			return;
		}

		if (this.medicalTranscriberUser != null) {
			this.medicalTranscriberUser.unsetStaff(false);
		}

		this.medicalTranscriberUser = entity;
		if (reverseAdd) {
			this.medicalTranscriberUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalTranscriberUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalTranscriberUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalTranscriberUser(boolean)} but default to true.
	 */
	public void unsetMedicalTranscriberUser() {
		this.unsetMedicalTranscriberUser(true);
	}

	/**
	 * Remove the MedicalTranscriberUserEntity of medicalTranscriberUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalTranscriberUser(boolean reverse) {
		if (reverse && this.medicalTranscriberUser != null) {
			this.medicalTranscriberUser.unsetStaff();
		}
		this.medicalTranscriberUser = null;
	}
	/**
	 * Similar to {@link this#setNurseUser(NurseUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given NurseUserEntity to be set to this entity
	 */
	public void setNurseUser(NurseUserEntity entity) {
		setNurseUser(entity, true);
	}

	/**
	 * Set or update the nurseUser in this entity with single NurseUserEntity.
	 *
	 * @param entity the given NurseUserEntity to be set or updated to nurseUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setNurseUser(NurseUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setNurseUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setNurseUser here] end

		if (sameAsFormer(this.nurseUser, entity)) {
			return;
		}

		if (this.nurseUser != null) {
			this.nurseUser.unsetStaff(false);
		}

		this.nurseUser = entity;
		if (reverseAdd) {
			this.nurseUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setNurseUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setNurseUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetNurseUser(boolean)} but default to true.
	 */
	public void unsetNurseUser() {
		this.unsetNurseUser(true);
	}

	/**
	 * Remove the NurseUserEntity of nurseUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetNurseUser(boolean reverse) {
		if (reverse && this.nurseUser != null) {
			this.nurseUser.unsetStaff();
		}
		this.nurseUser = null;
	}
	/**
	 * Similar to {@link this#setPharmacyUser(PharmacyUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PharmacyUserEntity to be set to this entity
	 */
	public void setPharmacyUser(PharmacyUserEntity entity) {
		setPharmacyUser(entity, true);
	}

	/**
	 * Set or update the pharmacyUser in this entity with single PharmacyUserEntity.
	 *
	 * @param entity the given PharmacyUserEntity to be set or updated to pharmacyUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPharmacyUser(PharmacyUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPharmacyUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPharmacyUser here] end

		if (sameAsFormer(this.pharmacyUser, entity)) {
			return;
		}

		if (this.pharmacyUser != null) {
			this.pharmacyUser.unsetStaff(false);
		}

		this.pharmacyUser = entity;
		if (reverseAdd) {
			this.pharmacyUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPharmacyUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPharmacyUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPharmacyUser(boolean)} but default to true.
	 */
	public void unsetPharmacyUser() {
		this.unsetPharmacyUser(true);
	}

	/**
	 * Remove the PharmacyUserEntity of pharmacyUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPharmacyUser(boolean reverse) {
		if (reverse && this.pharmacyUser != null) {
			this.pharmacyUser.unsetStaff();
		}
		this.pharmacyUser = null;
	}
	/**
	 * Similar to {@link this#setPurchasingUser(PurchasingUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchasingUserEntity to be set to this entity
	 */
	public void setPurchasingUser(PurchasingUserEntity entity) {
		setPurchasingUser(entity, true);
	}

	/**
	 * Set or update the purchasingUser in this entity with single PurchasingUserEntity.
	 *
	 * @param entity the given PurchasingUserEntity to be set or updated to purchasingUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPurchasingUser(PurchasingUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPurchasingUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPurchasingUser here] end

		if (sameAsFormer(this.purchasingUser, entity)) {
			return;
		}

		if (this.purchasingUser != null) {
			this.purchasingUser.unsetStaff(false);
		}

		this.purchasingUser = entity;
		if (reverseAdd) {
			this.purchasingUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPurchasingUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPurchasingUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPurchasingUser(boolean)} but default to true.
	 */
	public void unsetPurchasingUser() {
		this.unsetPurchasingUser(true);
	}

	/**
	 * Remove the PurchasingUserEntity of purchasingUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPurchasingUser(boolean reverse) {
		if (reverse && this.purchasingUser != null) {
			this.purchasingUser.unsetStaff();
		}
		this.purchasingUser = null;
	}
	/**
	 * Similar to {@link this#setRegistrationUser(RegistrationUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationUserEntity to be set to this entity
	 */
	public void setRegistrationUser(RegistrationUserEntity entity) {
		setRegistrationUser(entity, true);
	}

	/**
	 * Set or update the registrationUser in this entity with single RegistrationUserEntity.
	 *
	 * @param entity the given RegistrationUserEntity to be set or updated to registrationUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistrationUser(RegistrationUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistrationUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistrationUser here] end

		if (sameAsFormer(this.registrationUser, entity)) {
			return;
		}

		if (this.registrationUser != null) {
			this.registrationUser.unsetStaff(false);
		}

		this.registrationUser = entity;
		if (reverseAdd) {
			this.registrationUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistrationUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistrationUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetRegistrationUser(boolean)} but default to true.
	 */
	public void unsetRegistrationUser() {
		this.unsetRegistrationUser(true);
	}

	/**
	 * Remove the RegistrationUserEntity of registrationUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistrationUser(boolean reverse) {
		if (reverse && this.registrationUser != null) {
			this.registrationUser.unsetStaff();
		}
		this.registrationUser = null;
	}
	/**
	 * Similar to {@link this#setSystemAdminUser(SystemAdminUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SystemAdminUserEntity to be set to this entity
	 */
	public void setSystemAdminUser(SystemAdminUserEntity entity) {
		setSystemAdminUser(entity, true);
	}

	/**
	 * Set or update the systemAdminUser in this entity with single SystemAdminUserEntity.
	 *
	 * @param entity the given SystemAdminUserEntity to be set or updated to systemAdminUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSystemAdminUser(SystemAdminUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSystemAdminUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSystemAdminUser here] end

		if (sameAsFormer(this.systemAdminUser, entity)) {
			return;
		}

		if (this.systemAdminUser != null) {
			this.systemAdminUser.unsetStaff(false);
		}

		this.systemAdminUser = entity;
		if (reverseAdd) {
			this.systemAdminUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSystemAdminUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSystemAdminUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetSystemAdminUser(boolean)} but default to true.
	 */
	public void unsetSystemAdminUser() {
		this.unsetSystemAdminUser(true);
	}

	/**
	 * Remove the SystemAdminUserEntity of systemAdminUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSystemAdminUser(boolean reverse) {
		if (reverse && this.systemAdminUser != null) {
			this.systemAdminUser.unsetStaff();
		}
		this.systemAdminUser = null;
	}
	/**
	 * Similar to {@link this#setWarehouseUser(WarehouseUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseUserEntity to be set to this entity
	 */
	public void setWarehouseUser(WarehouseUserEntity entity) {
		setWarehouseUser(entity, true);
	}

	/**
	 * Set or update the warehouseUser in this entity with single WarehouseUserEntity.
	 *
	 * @param entity the given WarehouseUserEntity to be set or updated to warehouseUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setWarehouseUser(WarehouseUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setWarehouseUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setWarehouseUser here] end

		if (sameAsFormer(this.warehouseUser, entity)) {
			return;
		}

		if (this.warehouseUser != null) {
			this.warehouseUser.unsetStaff(false);
		}

		this.warehouseUser = entity;
		if (reverseAdd) {
			this.warehouseUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setWarehouseUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setWarehouseUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetWarehouseUser(boolean)} but default to true.
	 */
	public void unsetWarehouseUser() {
		this.unsetWarehouseUser(true);
	}

	/**
	 * Remove the WarehouseUserEntity of warehouseUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetWarehouseUser(boolean reverse) {
		if (reverse && this.warehouseUser != null) {
			this.warehouseUser.unsetStaff();
		}
		this.warehouseUser = null;
	}

	public void addStaffPicture(FileEntity newFile) {
		staffPicture.add(newFile);
	}

	public void addAllStaffPicture(Collection<FileEntity> newFiles) {
		staffPicture.addAll(newFiles);
	}

	public void removeStaffPicture(FileEntity newFile) {
		staffPicture.remove(newFile);
	}

	public boolean containsStaffPicture(FileEntity newFile) {
		return staffPicture.contains(newFile);
	}

	public void clearAllStaffPicture() {
		staffPicture.clear();
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
		return "STAFF_NUMBER,FIRST_NAME,LAST_NAME,DATE_OF_BIRTH,STAFF_TYPE,SPECIALIZATION,EDUCATION,LICENSE_NO,LETTER_OF_REG,GENDER,EMPLOYEE_ID,TITLE,DEFAULT_SERVICE_NUMBER,PLACE_OF_BIRTH,RELIGION,BLOOD_TYPE,RHESUS,ADDRESS,COUNTRY,STATE,REGENCY,DISTRICT,HOME_PHONE_NO,VILLAGE,POSTCODE,OFFICE_PHONE_NUMBER,TAX_IDENTIFICATION_NO,MOBILE_PHONE_NO,OTHER_NOTES,TRAINING,NATIONALITY,CERTIFICATION,EXT_NO,MARITAL_STATUS,EMAIL,ADMINISTRATION_USER_ID,CASHIER_USER_ID,CLAIM_USER_ID,DIAGNOSTIC_SUPPORT_USER_ID,DOCTOR_USER_ID,FACILITY_USER_ID,MANAGEMENT_USER_ID,MEDICAL_RECORD_USER_ID,MEDICAL_TRANSCRIBER_USER_ID,NURSE_USER_ID,PHARMACY_USER_ID,PURCHASING_USER_ID,REGISTRATION_USER_ID,SYSTEM_ADMIN_USER_ID,WAREHOUSE_USER_ID,ACCOMPANYING_CONSENTS_IDS,ADMINISTRATOR_ID,AMENDMENT_DETAILS_IDS,ANESTHESIA_MEDICAL_TRANSCRIBER_IDS,ANESTHESIOLOGIST_IDS,ANESTHESIOLOGY_NURSE_IDS,BPJS_DOCTOR_MAPPING_ID,CASHIER_STAFF_IDS,CO_TREATING_DOCTORS_IDS,DAILY_CARE_CPPTS_CREATED_BY_STAFF_IDS,DAILY_CARE_CPPTS_DOCTOR_IN_CHARGE_IDS,DAILY_CARE_CPPTS_MEDICAL_TRANSCRIBER_IDS,DELIVERY_PROGRESSES_IDS,DIAGNOSTIC_STAFF_EXAMINATION_SUMMARIES_IDS,DISMISSAL_REFERRING_STAFF_IDS,DOCTOR_SCHEDULES_IDS,DOCTOR_ON_EXAMINATION_IDS,FLUID_BALANCE_DETAILS_IDS,HEMODIALYSIS_MONITORINGS_IDS,HOSPITAL_BRANCH_INFORMATIONS_IDS,INFORMING_CONSENTS_IDS,INVOICES_IDS,MCU_PACKAGE_ITEMS_IDS,MEDICAL_CERTIFICATE_DISCHARGE_RESUMES_IDS,MEDICAL_CERTIFICATE_BIRTHS_IDS,MEDICAL_CERTIFICATE_HOSPITALIZATIONS_IDS,MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARYS_IDS,MEDICAL_RECORD_TRANSCRIBER_IDS,MEDICAL_STAFF_OF_MEDICAL_ATTENDANCES_CERTIFICATE_IDS,MEDICAL_STAFF_OF_MENTAL_HEALTHS_IDS,MEDICAL_STAFF_OF_PHYSICAL_HEALTHS_IDS,MEDICAL_STAFF_OF_RESTRICTED_WORKS_CERTIFICATE_IDS,MEDICAL_STAFF_OF_SICK_LEAVES_CERTIFICATE_IDS,MEDICATION_ADMINISTERED_HISOTRIES_IDS,MEDICATION_HEADERS_IDS,MIDWIVES_IDS,NURSE_IDS,NURSING_DETAIL_SURGICAL_NURSING_IDS,NURSING_DETAILS_ANESTHESIA_NURSING_IDS,PCARE_DOKTER_ID,PATIENT_CONSENTS_IDS,PATIENT_VITAL_INFORMATIONS_IDS,PEDIATRICIAN_IN_CHARGE_IDS,PRESCRIPTION_HEADERS_IDS,PROCESS_WORKFLOW_LOGS_IDS,REGISTRATIONS_IDS,REQUESTED_BY_IDS,ROOM_TRANSFERS_IDS,SAMPLE_COLLECTION_STAFFS_IDS,SAMPLE_DELIVERY_STAFFS_IDS,SAMPLE_PROCESSING_STAFFS_IDS,SERVICE_ID,SERVICES_IDS,SURGEON_IDS,SURGICAL_MEDICAL_TRANSCRIBER_IDS,SURGICAL_NURSE_IDS,TRANSFER_ORDER_STOCK_DETAILS_IDS,VACCINATION_ORDERS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<AdministrationUserEntity> administrationUserRelation = Optional.ofNullable(this.administrationUser);
		administrationUserRelation.ifPresent(entity -> this.administrationUserId = entity.getId());

		Optional<CashierUserEntity> cashierUserRelation = Optional.ofNullable(this.cashierUser);
		cashierUserRelation.ifPresent(entity -> this.cashierUserId = entity.getId());

		Optional<ClaimUserEntity> claimUserRelation = Optional.ofNullable(this.claimUser);
		claimUserRelation.ifPresent(entity -> this.claimUserId = entity.getId());

		Optional<DiagnosticSupportUserEntity> diagnosticSupportUserRelation = Optional.ofNullable(this.diagnosticSupportUser);
		diagnosticSupportUserRelation.ifPresent(entity -> this.diagnosticSupportUserId = entity.getId());

		Optional<DoctorUserEntity> doctorUserRelation = Optional.ofNullable(this.doctorUser);
		doctorUserRelation.ifPresent(entity -> this.doctorUserId = entity.getId());

		Optional<FacilityUserEntity> facilityUserRelation = Optional.ofNullable(this.facilityUser);
		facilityUserRelation.ifPresent(entity -> this.facilityUserId = entity.getId());

		Optional<ManagementUserEntity> managementUserRelation = Optional.ofNullable(this.managementUser);
		managementUserRelation.ifPresent(entity -> this.managementUserId = entity.getId());

		Optional<MedicalRecordUserEntity> medicalRecordUserRelation = Optional.ofNullable(this.medicalRecordUser);
		medicalRecordUserRelation.ifPresent(entity -> this.medicalRecordUserId = entity.getId());

		Optional<MedicalTranscriberUserEntity> medicalTranscriberUserRelation = Optional.ofNullable(this.medicalTranscriberUser);
		medicalTranscriberUserRelation.ifPresent(entity -> this.medicalTranscriberUserId = entity.getId());

		Optional<NurseUserEntity> nurseUserRelation = Optional.ofNullable(this.nurseUser);
		nurseUserRelation.ifPresent(entity -> this.nurseUserId = entity.getId());

		Optional<PharmacyUserEntity> pharmacyUserRelation = Optional.ofNullable(this.pharmacyUser);
		pharmacyUserRelation.ifPresent(entity -> this.pharmacyUserId = entity.getId());

		Optional<PurchasingUserEntity> purchasingUserRelation = Optional.ofNullable(this.purchasingUser);
		purchasingUserRelation.ifPresent(entity -> this.purchasingUserId = entity.getId());

		Optional<RegistrationUserEntity> registrationUserRelation = Optional.ofNullable(this.registrationUser);
		registrationUserRelation.ifPresent(entity -> this.registrationUserId = entity.getId());

		Optional<SystemAdminUserEntity> systemAdminUserRelation = Optional.ofNullable(this.systemAdminUser);
		systemAdminUserRelation.ifPresent(entity -> this.systemAdminUserId = entity.getId());

		Optional<WarehouseUserEntity> warehouseUserRelation = Optional.ofNullable(this.warehouseUser);
		warehouseUserRelation.ifPresent(entity -> this.warehouseUserId = entity.getId());

		this.accompanyingConsentsIds = new HashSet<>();
		for (InformedConsentEntity accompanyingConsents: this.accompanyingConsents) {
			this.accompanyingConsentsIds.add(accompanyingConsents.getId());
		}

		Optional<AdministratorEntity> administratorRelation = Optional.ofNullable(this.administrator);
		administratorRelation.ifPresent(entity -> this.administratorId = entity.getId());

		this.amendmentDetailsIds = new HashSet<>();
		for (AmendmentDetailEntity amendmentDetails: this.amendmentDetails) {
			this.amendmentDetailsIds.add(amendmentDetails.getId());
		}

		this.anesthesiaMedicalTranscriberIds = new HashSet<>();
		for (PreoperativeRecordsEntity anesthesiaMedicalTranscriber: this.anesthesiaMedicalTranscriber) {
			this.anesthesiaMedicalTranscriberIds.add(anesthesiaMedicalTranscriber.getId());
		}

		this.anesthesiologistIds = new HashSet<>();
		for (PreoperativeRecordsEntity anesthesiologist: this.anesthesiologist) {
			this.anesthesiologistIds.add(anesthesiologist.getId());
		}

		this.anesthesiologyNurseIds = new HashSet<>();
		for (PreoperativeRecordsEntity anesthesiologyNurse: this.anesthesiologyNurse) {
			this.anesthesiologyNurseIds.add(anesthesiologyNurse.getId());
		}

		Optional<BpjsDoctorMappingEntity> bpjsDoctorMappingRelation = Optional.ofNullable(this.bpjsDoctorMapping);
		bpjsDoctorMappingRelation.ifPresent(entity -> this.bpjsDoctorMappingId = entity.getId());

		this.cashierStaffIds = new HashSet<>();
		for (CashReceiptEntity cashierStaff: this.cashierStaff) {
			this.cashierStaffIds.add(cashierStaff.getId());
		}

		this.coTreatingDoctorsIds = new HashSet<>();
		for (CoTreatingDoctorEntity coTreatingDoctors: this.coTreatingDoctors) {
			this.coTreatingDoctorsIds.add(coTreatingDoctors.getId());
		}

		this.dailyCareCPPTsCreatedByStaffIds = new HashSet<>();
		for (DailyCareCPPTEntity dailyCareCPPTsCreatedByStaff: this.dailyCareCPPTsCreatedByStaff) {
			this.dailyCareCPPTsCreatedByStaffIds.add(dailyCareCPPTsCreatedByStaff.getId());
		}

		this.dailyCareCPPTsDoctorInChargeIds = new HashSet<>();
		for (DailyCareCPPTEntity dailyCareCPPTsDoctorInCharge: this.dailyCareCPPTsDoctorInCharge) {
			this.dailyCareCPPTsDoctorInChargeIds.add(dailyCareCPPTsDoctorInCharge.getId());
		}

		this.dailyCareCPPTsMedicalTranscriberIds = new HashSet<>();
		for (DailyCareCPPTEntity dailyCareCPPTsMedicalTranscriber: this.dailyCareCPPTsMedicalTranscriber) {
			this.dailyCareCPPTsMedicalTranscriberIds.add(dailyCareCPPTsMedicalTranscriber.getId());
		}

		this.deliveryProgressesIds = new HashSet<>();
		for (DeliveryProgressEntity deliveryProgresses: this.deliveryProgresses) {
			this.deliveryProgressesIds.add(deliveryProgresses.getId());
		}

		this.diagnosticStaffExaminationSummariesIds = new HashSet<>();
		for (DiagnosticStaffExaminationSummaryEntity diagnosticStaffExaminationSummaries: this.diagnosticStaffExaminationSummaries) {
			this.diagnosticStaffExaminationSummariesIds.add(diagnosticStaffExaminationSummaries.getId());
		}

		this.dismissalReferringStaffIds = new HashSet<>();
		for (RegistrationEntity dismissalReferringStaff: this.dismissalReferringStaff) {
			this.dismissalReferringStaffIds.add(dismissalReferringStaff.getId());
		}

		this.doctorSchedulesIds = new HashSet<>();
		for (DoctorScheduleEntity doctorSchedules: this.doctorSchedules) {
			this.doctorSchedulesIds.add(doctorSchedules.getId());
		}

		this.doctorOnExaminationIds = new HashSet<>();
		for (MedicalExaminationRecordEntity doctorOnExamination: this.doctorOnExamination) {
			this.doctorOnExaminationIds.add(doctorOnExamination.getId());
		}

		this.fluidBalanceDetailsIds = new HashSet<>();
		for (FluidBalanceDetailEntity fluidBalanceDetails: this.fluidBalanceDetails) {
			this.fluidBalanceDetailsIds.add(fluidBalanceDetails.getId());
		}

		this.hemodialysisMonitoringsIds = new HashSet<>();
		for (HemodialysisMonitoringEntity hemodialysisMonitorings: this.hemodialysisMonitorings) {
			this.hemodialysisMonitoringsIds.add(hemodialysisMonitorings.getId());
		}

		this.hospitalBranchInformationsIds = new HashSet<>();
		for (HospitalBranchInformationEntity hospitalBranchInformations: this.hospitalBranchInformations) {
			this.hospitalBranchInformationsIds.add(hospitalBranchInformations.getId());
		}

		this.informingConsentsIds = new HashSet<>();
		for (InformedConsentEntity informingConsents: this.informingConsents) {
			this.informingConsentsIds.add(informingConsents.getId());
		}

		this.invoicesIds = new HashSet<>();
		for (InvoiceEntity invoices: this.invoices) {
			this.invoicesIds.add(invoices.getId());
		}

		this.mcuPackageItemsIds = new HashSet<>();
		for (McuPackageItemEntity mcuPackageItems: this.mcuPackageItems) {
			this.mcuPackageItemsIds.add(mcuPackageItems.getId());
		}

		this.medicalCertificateDischargeResumesIds = new HashSet<>();
		for (MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResumes: this.medicalCertificateDischargeResumes) {
			this.medicalCertificateDischargeResumesIds.add(medicalCertificateDischargeResumes.getId());
		}

		this.medicalCertificateBirthsIds = new HashSet<>();
		for (MedicalCertificateBirthEntity medicalCertificateBirths: this.medicalCertificateBirths) {
			this.medicalCertificateBirthsIds.add(medicalCertificateBirths.getId());
		}

		this.medicalCertificateHospitalizationsIds = new HashSet<>();
		for (MedicalCertificateHospitalizationEntity medicalCertificateHospitalizations: this.medicalCertificateHospitalizations) {
			this.medicalCertificateHospitalizationsIds.add(medicalCertificateHospitalizations.getId());
		}

		this.medicalExaminationRecordDischargeSummarysIds = new HashSet<>();
		for (MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummarys: this.medicalExaminationRecordDischargeSummarys) {
			this.medicalExaminationRecordDischargeSummarysIds.add(medicalExaminationRecordDischargeSummarys.getId());
		}

		this.medicalRecordTranscriberIds = new HashSet<>();
		for (MedicalExaminationRecordEntity medicalRecordTranscriber: this.medicalRecordTranscriber) {
			this.medicalRecordTranscriberIds.add(medicalRecordTranscriber.getId());
		}

		this.medicalStaffOfMedicalAttendancesCertificateIds = new HashSet<>();
		for (MedicalCertificateMedicalAttendanceEntity medicalStaffOfMedicalAttendancesCertificate: this.medicalStaffOfMedicalAttendancesCertificate) {
			this.medicalStaffOfMedicalAttendancesCertificateIds.add(medicalStaffOfMedicalAttendancesCertificate.getId());
		}

		this.medicalStaffOfMentalHealthsIds = new HashSet<>();
		for (MedicalCertificateMentalHealthEntity medicalStaffOfMentalHealths: this.medicalStaffOfMentalHealths) {
			this.medicalStaffOfMentalHealthsIds.add(medicalStaffOfMentalHealths.getId());
		}

		this.medicalStaffOfPhysicalHealthsIds = new HashSet<>();
		for (MedicalCertificatePhysicalHealthEntity medicalStaffOfPhysicalHealths: this.medicalStaffOfPhysicalHealths) {
			this.medicalStaffOfPhysicalHealthsIds.add(medicalStaffOfPhysicalHealths.getId());
		}

		this.medicalStaffOfRestrictedWorksCertificateIds = new HashSet<>();
		for (MedicalCertificateRestrictedWorkEntity medicalStaffOfRestrictedWorksCertificate: this.medicalStaffOfRestrictedWorksCertificate) {
			this.medicalStaffOfRestrictedWorksCertificateIds.add(medicalStaffOfRestrictedWorksCertificate.getId());
		}

		this.medicalStaffOfSickLeavesCertificateIds = new HashSet<>();
		for (MedicalCertificateSickLeaveEntity medicalStaffOfSickLeavesCertificate: this.medicalStaffOfSickLeavesCertificate) {
			this.medicalStaffOfSickLeavesCertificateIds.add(medicalStaffOfSickLeavesCertificate.getId());
		}

		this.medicationAdministeredHisotriesIds = new HashSet<>();
		for (MedicationAdministeredHistoryEntity medicationAdministeredHisotries: this.medicationAdministeredHisotries) {
			this.medicationAdministeredHisotriesIds.add(medicationAdministeredHisotries.getId());
		}

		this.medicationHeadersIds = new HashSet<>();
		for (MedicationHeaderEntity medicationHeaders: this.medicationHeaders) {
			this.medicationHeadersIds.add(medicationHeaders.getId());
		}

		this.midwivesIds = new HashSet<>();
		for (DeliveryMedicalExaminationRecordEntity midwives: this.midwives) {
			this.midwivesIds.add(midwives.getId());
		}

		this.nurseIds = new HashSet<>();
		for (MedicalExaminationRecordEntity nurse: this.nurse) {
			this.nurseIds.add(nurse.getId());
		}

		this.nursingDetailSurgicalNursingIds = new HashSet<>();
		for (OperatingTheaterMedicalExaminationRecordEntity nursingDetailSurgicalNursing: this.nursingDetailSurgicalNursing) {
			this.nursingDetailSurgicalNursingIds.add(nursingDetailSurgicalNursing.getId());
		}

		this.nursingDetailsAnesthesiaNursingIds = new HashSet<>();
		for (OperatingTheaterMedicalExaminationRecordEntity nursingDetailsAnesthesiaNursing: this.nursingDetailsAnesthesiaNursing) {
			this.nursingDetailsAnesthesiaNursingIds.add(nursingDetailsAnesthesiaNursing.getId());
		}

		Optional<PcareDokterEntity> pcareDokterRelation = Optional.ofNullable(this.pcareDokter);
		pcareDokterRelation.ifPresent(entity -> this.pcareDokterId = entity.getId());

		this.patientConsentsIds = new HashSet<>();
		for (PatientConsentEntity patientConsents: this.patientConsents) {
			this.patientConsentsIds.add(patientConsents.getId());
		}

		this.patientVitalInformationsIds = new HashSet<>();
		for (PatientVitalInformationEntity patientVitalInformations: this.patientVitalInformations) {
			this.patientVitalInformationsIds.add(patientVitalInformations.getId());
		}

		this.pediatricianInChargeIds = new HashSet<>();
		for (NewbornDetailEntity pediatricianInCharge: this.pediatricianInCharge) {
			this.pediatricianInChargeIds.add(pediatricianInCharge.getId());
		}

		this.prescriptionHeadersIds = new HashSet<>();
		for (PrescriptionHeaderEntity prescriptionHeaders: this.prescriptionHeaders) {
			this.prescriptionHeadersIds.add(prescriptionHeaders.getId());
		}

		this.processWorkflowLogsIds = new HashSet<>();
		for (ProcessWorkflowEntity processWorkflowLogs: this.processWorkflowLogs) {
			this.processWorkflowLogsIds.add(processWorkflowLogs.getId());
		}

		this.registrationsIds = new HashSet<>();
		for (RegistrationEntity registrations: this.registrations) {
			this.registrationsIds.add(registrations.getId());
		}

		this.requestedByIds = new HashSet<>();
		for (RegistrationEntity requestedBy: this.requestedBy) {
			this.requestedByIds.add(requestedBy.getId());
		}

		this.roomTransfersIds = new HashSet<>();
		for (RoomTransferEntity roomTransfers: this.roomTransfers) {
			this.roomTransfersIds.add(roomTransfers.getId());
		}

		this.sampleCollectionStaffsIds = new HashSet<>();
		for (SampleCollectionItemsEntity sampleCollectionStaffs: this.sampleCollectionStaffs) {
			this.sampleCollectionStaffsIds.add(sampleCollectionStaffs.getId());
		}

		this.sampleDeliveryStaffsIds = new HashSet<>();
		for (SampleCollectionItemsEntity sampleDeliveryStaffs: this.sampleDeliveryStaffs) {
			this.sampleDeliveryStaffsIds.add(sampleDeliveryStaffs.getId());
		}

		this.sampleProcessingStaffsIds = new HashSet<>();
		for (SampleCollectionItemsEntity sampleProcessingStaffs: this.sampleProcessingStaffs) {
			this.sampleProcessingStaffsIds.add(sampleProcessingStaffs.getId());
		}

		Optional<ServiceEntity> serviceRelation = Optional.ofNullable(this.service);
		serviceRelation.ifPresent(entity -> this.serviceId = entity.getId());

		this.servicesIds = new HashSet<>();
		for (ServiceEntity services: this.services) {
			this.servicesIds.add(services.getId());
		}

		this.surgeonIds = new HashSet<>();
		for (PreoperativeRecordsEntity surgeon: this.surgeon) {
			this.surgeonIds.add(surgeon.getId());
		}

		this.surgicalMedicalTranscriberIds = new HashSet<>();
		for (PreoperativeRecordsEntity surgicalMedicalTranscriber: this.surgicalMedicalTranscriber) {
			this.surgicalMedicalTranscriberIds.add(surgicalMedicalTranscriber.getId());
		}

		this.surgicalNurseIds = new HashSet<>();
		for (PreoperativeRecordsEntity surgicalNurse: this.surgicalNurse) {
			this.surgicalNurseIds.add(surgicalNurse.getId());
		}

		this.transferOrderStockDetailsIds = new HashSet<>();
		for (TransferOrderStockDetailEntity transferOrderStockDetails: this.transferOrderStockDetails) {
			this.transferOrderStockDetailsIds.add(transferOrderStockDetails.getId());
		}

		this.vaccinationOrdersIds = new HashSet<>();
		for (VaccinationOrderEntity vaccinationOrders: this.vaccinationOrders) {
			this.vaccinationOrdersIds.add(vaccinationOrders.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object staff) {
		if (this == staff) {
			return true;
		}
		if (staff == null || this.getClass() != staff.getClass()) {
			return false;
		}
		if (!super.equals(staff)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		StaffEntity that = (StaffEntity) staff;
		return
			Objects.equals(this.staffNumber, that.staffNumber) &&
			Objects.equals(this.firstName, that.firstName) &&
			Objects.equals(this.lastName, that.lastName) &&
			Objects.equals(
			     this.dateOfBirth != null ? this.dateOfBirth.truncatedTo(ChronoUnit.DAYS) : null,
			     that.dateOfBirth != null ? that.dateOfBirth.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.staffType, that.staffType) &&
			Objects.equals(this.specialization, that.specialization) &&
			Objects.equals(this.education, that.education) &&
			Objects.equals(this.licenseNo, that.licenseNo) &&
			Objects.equals(this.letterOfReg, that.letterOfReg) &&
			Objects.equals(this.gender, that.gender) &&
			Objects.equals(this.employeeID, that.employeeID) &&
			Objects.equals(this.title, that.title) &&
			Objects.equals(this.defaultServiceNumber, that.defaultServiceNumber) &&
			Objects.equals(this.placeOfBirth, that.placeOfBirth) &&
			Objects.equals(this.religion, that.religion) &&
			Objects.equals(this.bloodType, that.bloodType) &&
			Objects.equals(this.rhesus, that.rhesus) &&
			Objects.equals(this.address, that.address) &&
			Objects.equals(this.country, that.country) &&
			Objects.equals(this.state, that.state) &&
			Objects.equals(this.regency, that.regency) &&
			Objects.equals(this.district, that.district) &&
			Objects.equals(this.homePhoneNo, that.homePhoneNo) &&
			Objects.equals(this.village, that.village) &&
			Objects.equals(this.postcode, that.postcode) &&
			Objects.equals(this.officePhoneNumber, that.officePhoneNumber) &&
			Objects.equals(this.taxIdentificationNo, that.taxIdentificationNo) &&
			Objects.equals(this.mobilePhoneNo, that.mobilePhoneNo) &&
			Objects.equals(this.otherNotes, that.otherNotes) &&
			Objects.equals(this.training, that.training) &&
			Objects.equals(this.nationality, that.nationality) &&
			Objects.equals(this.certification, that.certification) &&
			Objects.equals(this.extNo, that.extNo) &&
			Objects.equals(this.maritalStatus, that.maritalStatus) &&
			Objects.equals(this.email, that.email) &&
			Objects.equals(this.accompanyingConsentsIds, that.accompanyingConsentsIds) &&
			Objects.equals(this.administratorId, that.administratorId) &&
			Objects.equals(this.amendmentDetailsIds, that.amendmentDetailsIds) &&
			Objects.equals(this.anesthesiaMedicalTranscriberIds, that.anesthesiaMedicalTranscriberIds) &&
			Objects.equals(this.anesthesiologistIds, that.anesthesiologistIds) &&
			Objects.equals(this.anesthesiologyNurseIds, that.anesthesiologyNurseIds) &&
			Objects.equals(this.bpjsDoctorMappingId, that.bpjsDoctorMappingId) &&
			Objects.equals(this.cashierStaffIds, that.cashierStaffIds) &&
			Objects.equals(this.coTreatingDoctorsIds, that.coTreatingDoctorsIds) &&
			Objects.equals(this.dailyCareCPPTsCreatedByStaffIds, that.dailyCareCPPTsCreatedByStaffIds) &&
			Objects.equals(this.dailyCareCPPTsDoctorInChargeIds, that.dailyCareCPPTsDoctorInChargeIds) &&
			Objects.equals(this.dailyCareCPPTsMedicalTranscriberIds, that.dailyCareCPPTsMedicalTranscriberIds) &&
			Objects.equals(this.deliveryProgressesIds, that.deliveryProgressesIds) &&
			Objects.equals(this.diagnosticStaffExaminationSummariesIds, that.diagnosticStaffExaminationSummariesIds) &&
			Objects.equals(this.dismissalReferringStaffIds, that.dismissalReferringStaffIds) &&
			Objects.equals(this.doctorSchedulesIds, that.doctorSchedulesIds) &&
			Objects.equals(this.doctorOnExaminationIds, that.doctorOnExaminationIds) &&
			Objects.equals(this.fluidBalanceDetailsIds, that.fluidBalanceDetailsIds) &&
			Objects.equals(this.hemodialysisMonitoringsIds, that.hemodialysisMonitoringsIds) &&
			Objects.equals(this.hospitalBranchInformationsIds, that.hospitalBranchInformationsIds) &&
			Objects.equals(this.informingConsentsIds, that.informingConsentsIds) &&
			Objects.equals(this.invoicesIds, that.invoicesIds) &&
			Objects.equals(this.mcuPackageItemsIds, that.mcuPackageItemsIds) &&
			Objects.equals(this.medicalCertificateDischargeResumesIds, that.medicalCertificateDischargeResumesIds) &&
			Objects.equals(this.medicalCertificateBirthsIds, that.medicalCertificateBirthsIds) &&
			Objects.equals(this.medicalCertificateHospitalizationsIds, that.medicalCertificateHospitalizationsIds) &&
			Objects.equals(this.medicalExaminationRecordDischargeSummarysIds, that.medicalExaminationRecordDischargeSummarysIds) &&
			Objects.equals(this.medicalRecordTranscriberIds, that.medicalRecordTranscriberIds) &&
			Objects.equals(this.medicalStaffOfMedicalAttendancesCertificateIds, that.medicalStaffOfMedicalAttendancesCertificateIds) &&
			Objects.equals(this.medicalStaffOfMentalHealthsIds, that.medicalStaffOfMentalHealthsIds) &&
			Objects.equals(this.medicalStaffOfPhysicalHealthsIds, that.medicalStaffOfPhysicalHealthsIds) &&
			Objects.equals(this.medicalStaffOfRestrictedWorksCertificateIds, that.medicalStaffOfRestrictedWorksCertificateIds) &&
			Objects.equals(this.medicalStaffOfSickLeavesCertificateIds, that.medicalStaffOfSickLeavesCertificateIds) &&
			Objects.equals(this.medicationAdministeredHisotriesIds, that.medicationAdministeredHisotriesIds) &&
			Objects.equals(this.medicationHeadersIds, that.medicationHeadersIds) &&
			Objects.equals(this.midwivesIds, that.midwivesIds) &&
			Objects.equals(this.nurseIds, that.nurseIds) &&
			Objects.equals(this.nursingDetailSurgicalNursingIds, that.nursingDetailSurgicalNursingIds) &&
			Objects.equals(this.nursingDetailsAnesthesiaNursingIds, that.nursingDetailsAnesthesiaNursingIds) &&
			Objects.equals(this.pcareDokterId, that.pcareDokterId) &&
			Objects.equals(this.patientConsentsIds, that.patientConsentsIds) &&
			Objects.equals(this.patientVitalInformationsIds, that.patientVitalInformationsIds) &&
			Objects.equals(this.pediatricianInChargeIds, that.pediatricianInChargeIds) &&
			Objects.equals(this.prescriptionHeadersIds, that.prescriptionHeadersIds) &&
			Objects.equals(this.processWorkflowLogsIds, that.processWorkflowLogsIds) &&
			Objects.equals(this.registrationsIds, that.registrationsIds) &&
			Objects.equals(this.requestedByIds, that.requestedByIds) &&
			Objects.equals(this.roomTransfersIds, that.roomTransfersIds) &&
			Objects.equals(this.sampleCollectionStaffsIds, that.sampleCollectionStaffsIds) &&
			Objects.equals(this.sampleDeliveryStaffsIds, that.sampleDeliveryStaffsIds) &&
			Objects.equals(this.sampleProcessingStaffsIds, that.sampleProcessingStaffsIds) &&
			Objects.equals(this.serviceId, that.serviceId) &&
			Objects.equals(this.surgeonIds, that.surgeonIds) &&
			Objects.equals(this.surgicalMedicalTranscriberIds, that.surgicalMedicalTranscriberIds) &&
			Objects.equals(this.surgicalNurseIds, that.surgicalNurseIds) &&
			Objects.equals(this.transferOrderStockDetailsIds, that.transferOrderStockDetailsIds) &&
			Objects.equals(this.vaccinationOrdersIds, that.vaccinationOrdersIds) &&
			Objects.equals(this.administrationUserId, that.administrationUserId) &&
			Objects.equals(this.cashierUserId, that.cashierUserId) &&
			Objects.equals(this.claimUserId, that.claimUserId) &&
			Objects.equals(this.diagnosticSupportUserId, that.diagnosticSupportUserId) &&
			Objects.equals(this.doctorUserId, that.doctorUserId) &&
			Objects.equals(this.facilityUserId, that.facilityUserId) &&
			Objects.equals(this.managementUserId, that.managementUserId) &&
			Objects.equals(this.medicalRecordUserId, that.medicalRecordUserId) &&
			Objects.equals(this.medicalTranscriberUserId, that.medicalTranscriberUserId) &&
			Objects.equals(this.nurseUserId, that.nurseUserId) &&
			Objects.equals(this.pharmacyUserId, that.pharmacyUserId) &&
			Objects.equals(this.purchasingUserId, that.purchasingUserId) &&
			Objects.equals(this.registrationUserId, that.registrationUserId) &&
			Objects.equals(this.systemAdminUserId, that.systemAdminUserId) &&
			Objects.equals(this.warehouseUserId, that.warehouseUserId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
