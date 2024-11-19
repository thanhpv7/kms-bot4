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
import kmsweb.dtos.HospitalBranchInformationEntityDto;
import kmsweb.entities.listeners.HospitalBranchInformationEntityListener;
import kmsweb.serializers.HospitalBranchInformationSerializer;
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
@EntityListeners({HospitalBranchInformationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = HospitalBranchInformationSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"hospital_code"}, name = "hospital_code"),
		@UniqueConstraint(columnNames = {"tax_identification"}, name = "tax_identification"),
	}
)
public class HospitalBranchInformationEntity extends AbstractEntity {

	/**
	 * Takes a HospitalBranchInformationEntityDto and converts it into a HospitalBranchInformationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param hospitalBranchInformationEntityDto
	 */
	public HospitalBranchInformationEntity(HospitalBranchInformationEntityDto hospitalBranchInformationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (hospitalBranchInformationEntityDto.getId() != null) {
			this.setId(hospitalBranchInformationEntityDto.getId());
		}

		if (hospitalBranchInformationEntityDto.getHospitalCode() != null) {
			this.setHospitalCode(hospitalBranchInformationEntityDto.getHospitalCode());
		}

		if (hospitalBranchInformationEntityDto.getHospitalName() != null) {
			this.setHospitalName(hospitalBranchInformationEntityDto.getHospitalName());
		}

		if (hospitalBranchInformationEntityDto.getHospitalType() != null) {
			this.setHospitalType(hospitalBranchInformationEntityDto.getHospitalType());
		}

		if (hospitalBranchInformationEntityDto.getHospitalClass() != null) {
			this.setHospitalClass(hospitalBranchInformationEntityDto.getHospitalClass());
		}

		if (hospitalBranchInformationEntityDto.getHospitalDirectorName() != null) {
			this.setHospitalDirectorName(hospitalBranchInformationEntityDto.getHospitalDirectorName());
		}

		if (hospitalBranchInformationEntityDto.getDateOfRegistration() != null) {
			this.setDateOfRegistration(hospitalBranchInformationEntityDto.getDateOfRegistration());
		}

		if (hospitalBranchInformationEntityDto.getHospitalCorporationName() != null) {
			this.setHospitalCorporationName(hospitalBranchInformationEntityDto.getHospitalCorporationName());
		}

		if (hospitalBranchInformationEntityDto.getIsBPJSFacility() != null) {
			this.setIsBPJSFacility(hospitalBranchInformationEntityDto.getIsBPJSFacility());
		}

		if (hospitalBranchInformationEntityDto.getAddress() != null) {
			this.setAddress(hospitalBranchInformationEntityDto.getAddress());
		}

		if (hospitalBranchInformationEntityDto.getCity() != null) {
			this.setCity(hospitalBranchInformationEntityDto.getCity());
		}

		if (hospitalBranchInformationEntityDto.getPostcode() != null) {
			this.setPostcode(hospitalBranchInformationEntityDto.getPostcode());
		}

		if (hospitalBranchInformationEntityDto.getPhoneNumber() != null) {
			this.setPhoneNumber(hospitalBranchInformationEntityDto.getPhoneNumber());
		}

		if (hospitalBranchInformationEntityDto.getFax() != null) {
			this.setFax(hospitalBranchInformationEntityDto.getFax());
		}

		if (hospitalBranchInformationEntityDto.getEmail() != null) {
			this.setEmail(hospitalBranchInformationEntityDto.getEmail());
		}

		if (hospitalBranchInformationEntityDto.getWebsite() != null) {
			this.setWebsite(hospitalBranchInformationEntityDto.getWebsite());
		}

		if (hospitalBranchInformationEntityDto.getContactPerson() != null) {
			this.setContactPerson(hospitalBranchInformationEntityDto.getContactPerson());
		}

		if (hospitalBranchInformationEntityDto.getContactPersonPhoneNumber() != null) {
			this.setContactPersonPhoneNumber(hospitalBranchInformationEntityDto.getContactPersonPhoneNumber());
		}

		if (hospitalBranchInformationEntityDto.getContactPersonEmail() != null) {
			this.setContactPersonEmail(hospitalBranchInformationEntityDto.getContactPersonEmail());
		}

		if (hospitalBranchInformationEntityDto.getLandSize() != null) {
			this.setLandSize(hospitalBranchInformationEntityDto.getLandSize());
		}

		if (hospitalBranchInformationEntityDto.getBuildingSize() != null) {
			this.setBuildingSize(hospitalBranchInformationEntityDto.getBuildingSize());
		}

		if (hospitalBranchInformationEntityDto.getPermitNumber() != null) {
			this.setPermitNumber(hospitalBranchInformationEntityDto.getPermitNumber());
		}

		if (hospitalBranchInformationEntityDto.getPermitDate() != null) {
			this.setPermitDate(hospitalBranchInformationEntityDto.getPermitDate());
		}

		if (hospitalBranchInformationEntityDto.getAuthorizedBy() != null) {
			this.setAuthorizedBy(hospitalBranchInformationEntityDto.getAuthorizedBy());
		}

		if (hospitalBranchInformationEntityDto.getPermitType() != null) {
			this.setPermitType(hospitalBranchInformationEntityDto.getPermitType());
		}

		if (hospitalBranchInformationEntityDto.getValidUntil() != null) {
			this.setValidUntil(hospitalBranchInformationEntityDto.getValidUntil());
		}

		if (hospitalBranchInformationEntityDto.getHospitalBranchCorporationName() != null) {
			this.setHospitalBranchCorporationName(hospitalBranchInformationEntityDto.getHospitalBranchCorporationName());
		}

		if (hospitalBranchInformationEntityDto.getHospitalBranchCorporationStatus() != null) {
			this.setHospitalBranchCorporationStatus(hospitalBranchInformationEntityDto.getHospitalBranchCorporationStatus());
		}

		if (hospitalBranchInformationEntityDto.getAccreditationType() != null) {
			this.setAccreditationType(hospitalBranchInformationEntityDto.getAccreditationType());
		}

		if (hospitalBranchInformationEntityDto.getAccreditationLevel() != null) {
			this.setAccreditationLevel(hospitalBranchInformationEntityDto.getAccreditationLevel());
		}

		if (hospitalBranchInformationEntityDto.getAccreditationDate() != null) {
			this.setAccreditationDate(hospitalBranchInformationEntityDto.getAccreditationDate());
		}

		if (hospitalBranchInformationEntityDto.getBedPerinatology() != null) {
			this.setBedPerinatology(hospitalBranchInformationEntityDto.getBedPerinatology());
		}

		if (hospitalBranchInformationEntityDto.getSuiteClass() != null) {
			this.setSuiteClass(hospitalBranchInformationEntityDto.getSuiteClass());
		}

		if (hospitalBranchInformationEntityDto.getVvipClass() != null) {
			this.setVvipClass(hospitalBranchInformationEntityDto.getVvipClass());
		}

		if (hospitalBranchInformationEntityDto.getVipAClass() != null) {
			this.setVipAClass(hospitalBranchInformationEntityDto.getVipAClass());
		}

		if (hospitalBranchInformationEntityDto.getVipBClass() != null) {
			this.setVipBClass(hospitalBranchInformationEntityDto.getVipBClass());
		}

		if (hospitalBranchInformationEntityDto.getVipCClass() != null) {
			this.setVipCClass(hospitalBranchInformationEntityDto.getVipCClass());
		}

		if (hospitalBranchInformationEntityDto.getMainClass() != null) {
			this.setMainClass(hospitalBranchInformationEntityDto.getMainClass());
		}

		if (hospitalBranchInformationEntityDto.getClassI() != null) {
			this.setClassI(hospitalBranchInformationEntityDto.getClassI());
		}

		if (hospitalBranchInformationEntityDto.getIiClass() != null) {
			this.setIiClass(hospitalBranchInformationEntityDto.getIiClass());
		}

		if (hospitalBranchInformationEntityDto.getIiiAClass() != null) {
			this.setIiiAClass(hospitalBranchInformationEntityDto.getIiiAClass());
		}

		if (hospitalBranchInformationEntityDto.getIiiBClass() != null) {
			this.setIiiBClass(hospitalBranchInformationEntityDto.getIiiBClass());
		}

		if (hospitalBranchInformationEntityDto.getSpecialClass() != null) {
			this.setSpecialClass(hospitalBranchInformationEntityDto.getSpecialClass());
		}

		if (hospitalBranchInformationEntityDto.getIcu() != null) {
			this.setIcu(hospitalBranchInformationEntityDto.getIcu());
		}

		if (hospitalBranchInformationEntityDto.getPicu() != null) {
			this.setPicu(hospitalBranchInformationEntityDto.getPicu());
		}

		if (hospitalBranchInformationEntityDto.getNicu() != null) {
			this.setNicu(hospitalBranchInformationEntityDto.getNicu());
		}

		if (hospitalBranchInformationEntityDto.getHcu() != null) {
			this.setHcu(hospitalBranchInformationEntityDto.getHcu());
		}

		if (hospitalBranchInformationEntityDto.getIccu() != null) {
			this.setIccu(hospitalBranchInformationEntityDto.getIccu());
		}

		if (hospitalBranchInformationEntityDto.getIsolationRoom() != null) {
			this.setIsolationRoom(hospitalBranchInformationEntityDto.getIsolationRoom());
		}

		if (hospitalBranchInformationEntityDto.getEmergencyRoom() != null) {
			this.setEmergencyRoom(hospitalBranchInformationEntityDto.getEmergencyRoom());
		}

		if (hospitalBranchInformationEntityDto.getMaternityRoom() != null) {
			this.setMaternityRoom(hospitalBranchInformationEntityDto.getMaternityRoom());
		}

		if (hospitalBranchInformationEntityDto.getOperatingRoom() != null) {
			this.setOperatingRoom(hospitalBranchInformationEntityDto.getOperatingRoom());
		}

		if (hospitalBranchInformationEntityDto.getDoctorSpA() != null) {
			this.setDoctorSpA(hospitalBranchInformationEntityDto.getDoctorSpA());
		}

		if (hospitalBranchInformationEntityDto.getDoctorSpOG() != null) {
			this.setDoctorSpOG(hospitalBranchInformationEntityDto.getDoctorSpOG());
		}

		if (hospitalBranchInformationEntityDto.getDoctorSpPD() != null) {
			this.setDoctorSpPD(hospitalBranchInformationEntityDto.getDoctorSpPD());
		}

		if (hospitalBranchInformationEntityDto.getDoctorSpB() != null) {
			this.setDoctorSpB(hospitalBranchInformationEntityDto.getDoctorSpB());
		}

		if (hospitalBranchInformationEntityDto.getDoctorSpRad() != null) {
			this.setDoctorSpRad(hospitalBranchInformationEntityDto.getDoctorSpRad());
		}

		if (hospitalBranchInformationEntityDto.getDoctorSpRm() != null) {
			this.setDoctorSpRm(hospitalBranchInformationEntityDto.getDoctorSpRm());
		}

		if (hospitalBranchInformationEntityDto.getDoctorSpAn() != null) {
			this.setDoctorSpAn(hospitalBranchInformationEntityDto.getDoctorSpAn());
		}

		if (hospitalBranchInformationEntityDto.getDoctorSpJp() != null) {
			this.setDoctorSpJp(hospitalBranchInformationEntityDto.getDoctorSpJp());
		}

		if (hospitalBranchInformationEntityDto.getDoctorSpM() != null) {
			this.setDoctorSpM(hospitalBranchInformationEntityDto.getDoctorSpM());
		}

		if (hospitalBranchInformationEntityDto.getDoctorSpTHT() != null) {
			this.setDoctorSpTHT(hospitalBranchInformationEntityDto.getDoctorSpTHT());
		}

		if (hospitalBranchInformationEntityDto.getDoctorSpKj() != null) {
			this.setDoctorSpKj(hospitalBranchInformationEntityDto.getDoctorSpKj());
		}

		if (hospitalBranchInformationEntityDto.getDoctorSpP() != null) {
			this.setDoctorSpP(hospitalBranchInformationEntityDto.getDoctorSpP());
		}

		if (hospitalBranchInformationEntityDto.getDoctorSpPK() != null) {
			this.setDoctorSpPK(hospitalBranchInformationEntityDto.getDoctorSpPK());
		}

		if (hospitalBranchInformationEntityDto.getDoctorSpS() != null) {
			this.setDoctorSpS(hospitalBranchInformationEntityDto.getDoctorSpS());
		}

		if (hospitalBranchInformationEntityDto.getSubSpecialistDoctor() != null) {
			this.setSubSpecialistDoctor(hospitalBranchInformationEntityDto.getSubSpecialistDoctor());
		}

		if (hospitalBranchInformationEntityDto.getOtherSpecialistDoctor() != null) {
			this.setOtherSpecialistDoctor(hospitalBranchInformationEntityDto.getOtherSpecialistDoctor());
		}

		if (hospitalBranchInformationEntityDto.getGeneralPractice() != null) {
			this.setGeneralPractice(hospitalBranchInformationEntityDto.getGeneralPractice());
		}

		if (hospitalBranchInformationEntityDto.getDentist() != null) {
			this.setDentist(hospitalBranchInformationEntityDto.getDentist());
		}

		if (hospitalBranchInformationEntityDto.getSpecialistDentist() != null) {
			this.setSpecialistDentist(hospitalBranchInformationEntityDto.getSpecialistDentist());
		}

		if (hospitalBranchInformationEntityDto.getNurse() != null) {
			this.setNurse(hospitalBranchInformationEntityDto.getNurse());
		}

		if (hospitalBranchInformationEntityDto.getMidwife() != null) {
			this.setMidwife(hospitalBranchInformationEntityDto.getMidwife());
		}

		if (hospitalBranchInformationEntityDto.getPharmacist() != null) {
			this.setPharmacist(hospitalBranchInformationEntityDto.getPharmacist());
		}

		if (hospitalBranchInformationEntityDto.getOtherMedicalStaff() != null) {
			this.setOtherMedicalStaff(hospitalBranchInformationEntityDto.getOtherMedicalStaff());
		}

		if (hospitalBranchInformationEntityDto.getNonMedicalStaff() != null) {
			this.setNonMedicalStaff(hospitalBranchInformationEntityDto.getNonMedicalStaff());
		}

		if (hospitalBranchInformationEntityDto.getTimezone() != null) {
			this.setTimezone(hospitalBranchInformationEntityDto.getTimezone());
		}

		if (hospitalBranchInformationEntityDto.getHealthFacilityLevel() != null) {
			this.setHealthFacilityLevel(hospitalBranchInformationEntityDto.getHealthFacilityLevel());
		}

		if (hospitalBranchInformationEntityDto.getSatuSehatIntegration() != null) {
			this.setSatuSehatIntegration(hospitalBranchInformationEntityDto.getSatuSehatIntegration());
		}

		if (hospitalBranchInformationEntityDto.getTaxIdentification() != null) {
			this.setTaxIdentification(hospitalBranchInformationEntityDto.getTaxIdentification());
		}

		if (hospitalBranchInformationEntityDto.getHospitalGroup() != null) {
			this.setHospitalGroup(hospitalBranchInformationEntityDto.getHospitalGroup());
		}

		if (hospitalBranchInformationEntityDto.getStaff() != null) {
			this.setStaff(hospitalBranchInformationEntityDto.getStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Hospital Code here] off begin
	@CsvBindByName(column = "HOSPITAL_CODE", required = true)
	@NotNull(message = "Hospital Code must not be empty")
	@Column(name = "hospital_code")
	@Schema(description = "The Hospital Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Code here] end
	private String hospitalCode;

	// % protected region % [Modify attribute annotation for Hospital Name here] off begin
	@CsvBindByName(column = "HOSPITAL_NAME", required = true)
	@NotNull(message = "Hospital Name must not be empty")
	@Column(name = "hospital_name")
	@Schema(description = "The Hospital Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Name here] end
	private String hospitalName;

	// % protected region % [Modify attribute annotation for Hospital Type here] off begin
	@CsvBindByName(column = "HOSPITAL_TYPE", required = true)
	@NotNull(message = "Hospital Type must not be empty")
	@Column(name = "hospital_type")
	@Schema(description = "The Hospital Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Type here] end
	private String hospitalType;

	// % protected region % [Modify attribute annotation for Hospital Class here] off begin
	@CsvBindByName(column = "HOSPITAL_CLASS", required = true)
	@NotNull(message = "Hospital Class must not be empty")
	@Column(name = "hospital_class")
	@Schema(description = "The Hospital Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Class here] end
	private String hospitalClass;

	// % protected region % [Modify attribute annotation for Hospital Director Name here] off begin
	@CsvBindByName(column = "HOSPITAL_DIRECTOR_NAME", required = true)
	@NotNull(message = "Hospital Director Name must not be empty")
	@Column(name = "hospital_director_name")
	@Schema(description = "The Hospital Director Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Director Name here] end
	private String hospitalDirectorName;

	// % protected region % [Modify attribute annotation for Date of Registration here] off begin
	@CsvCustomBindByName(column = "DATE_OF_REGISTRATION", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "date_of_registration")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Date of Registration of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Date of Registration here] end
	private OffsetDateTime dateOfRegistration;

	// % protected region % [Modify attribute annotation for Hospital Corporation Name here] off begin
	@CsvBindByName(column = "HOSPITAL_CORPORATION_NAME", required = false)
	@Nullable
	@Column(name = "hospital_corporation_name")
	@Schema(description = "The Hospital Corporation Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Corporation Name here] end
	private String hospitalCorporationName;

	// % protected region % [Modify attribute annotation for Is BPJS Facility here] off begin
	@CsvBindByName(column = "IS_BPJS_FACILITY", required = false)
	@Nullable
	@Column(name = "is_bpjs_facility")
	@Schema(description = "The Is BPJS Facility of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is BPJS Facility here] end
	private Boolean isBPJSFacility = false ;

	// % protected region % [Modify attribute annotation for Address here] off begin
	@CsvBindByName(column = "ADDRESS", required = true)
	@NotNull(message = "Address must not be empty")
	@Column(name = "address")
	@Schema(description = "The Address of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Address here] end
	private String address;

	// % protected region % [Modify attribute annotation for City here] off begin
	@CsvBindByName(column = "CITY", required = true)
	@NotNull(message = "City must not be empty")
	@Column(name = "city")
	@Schema(description = "The City of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for City here] end
	private String city;

	// % protected region % [Modify attribute annotation for Postcode here] off begin
	@CsvBindByName(column = "POSTCODE", required = false)
	@Nullable
	@Column(name = "postcode")
	@Schema(description = "The Postcode of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Postcode here] end
	private String postcode;

	// % protected region % [Modify attribute annotation for Phone Number here] off begin
	@CsvBindByName(column = "PHONE_NUMBER", required = false)
	@Nullable
	@Column(name = "phone_number")
	@Schema(description = "The Phone Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Phone Number here] end
	private String phoneNumber;

	// % protected region % [Modify attribute annotation for Fax here] off begin
	@CsvBindByName(column = "FAX", required = false)
	@Nullable
	@Column(name = "fax")
	@Schema(description = "The Fax of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Fax here] end
	private String fax;

	// % protected region % [Modify attribute annotation for Email here] off begin
	@CsvBindByName(column = "EMAIL", required = false)
	@Nullable
	@Column(name = "email")
	@Schema(description = "The Email of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

	// % protected region % [Modify attribute annotation for Website here] off begin
	@CsvBindByName(column = "WEBSITE", required = false)
	@Nullable
	@Column(name = "website")
	@Schema(description = "The Website of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Website here] end
	private String website;

	// % protected region % [Modify attribute annotation for Contact Person here] off begin
	@CsvBindByName(column = "CONTACT_PERSON", required = false)
	@Nullable
	@Column(name = "contact_person")
	@Schema(description = "The Contact Person of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Contact Person here] end
	private String contactPerson;

	// % protected region % [Modify attribute annotation for Contact Person Phone Number here] off begin
	@CsvBindByName(column = "CONTACT_PERSON_PHONE_NUMBER", required = false)
	@Nullable
	@Column(name = "contact_person_phone_number")
	@Schema(description = "The Contact Person Phone Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Contact Person Phone Number here] end
	private String contactPersonPhoneNumber;

	// % protected region % [Modify attribute annotation for Contact Person Email here] off begin
	@CsvBindByName(column = "CONTACT_PERSON_EMAIL", required = false)
	@Nullable
	@Column(name = "contact_person_email")
	@Schema(description = "The Contact Person Email of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Contact Person Email here] end
	private String contactPersonEmail;

	// % protected region % [Modify attribute annotation for Land Size here] off begin
	@CsvBindByName(column = "LAND_SIZE", required = false)
	@Nullable
	@Column(name = "land_size")
	@Schema(description = "The Land Size of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Land Size here] end
	private String landSize;

	// % protected region % [Modify attribute annotation for Building Size here] off begin
	@CsvBindByName(column = "BUILDING_SIZE", required = false)
	@Nullable
	@Column(name = "building_size")
	@Schema(description = "The Building Size of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Building Size here] end
	private String buildingSize;

	// % protected region % [Modify attribute annotation for Permit Number here] off begin
	@CsvBindByName(column = "PERMIT_NUMBER", required = false)
	@Nullable
	@Column(name = "permit_number")
	@Schema(description = "The Permit Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Permit Number here] end
	private String permitNumber;

	// % protected region % [Modify attribute annotation for Permit Date here] off begin
	@CsvCustomBindByName(column = "PERMIT_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "permit_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Permit Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Permit Date here] end
	private OffsetDateTime permitDate;

	// % protected region % [Modify attribute annotation for Authorized By here] off begin
	@CsvBindByName(column = "AUTHORIZED_BY", required = false)
	@Nullable
	@Column(name = "authorized_by")
	@Schema(description = "The Authorized By of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Authorized By here] end
	private String authorizedBy;

	// % protected region % [Modify attribute annotation for Permit Type here] off begin
	@CsvBindByName(column = "PERMIT_TYPE", required = false)
	@Nullable
	@Column(name = "permit_type")
	@Schema(description = "The Permit Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Permit Type here] end
	private String permitType;

	// % protected region % [Modify attribute annotation for Valid Until here] off begin
	@CsvCustomBindByName(column = "VALID_UNTIL", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "valid_until")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Valid Until of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Valid Until here] end
	private OffsetDateTime validUntil;

	// % protected region % [Modify attribute annotation for Hospital Branch Corporation Name here] off begin
	@CsvBindByName(column = "HOSPITAL_BRANCH_CORPORATION_NAME", required = false)
	@Nullable
	@Column(name = "hospital_branch_corporation_name")
	@Schema(description = "The Hospital Branch Corporation Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Branch Corporation Name here] end
	private String hospitalBranchCorporationName;

	// % protected region % [Modify attribute annotation for Hospital Branch Corporation Status here] off begin
	@CsvBindByName(column = "HOSPITAL_BRANCH_CORPORATION_STATUS", required = false)
	@Nullable
	@Column(name = "hospital_branch_corporation_status")
	@Schema(description = "The Hospital Branch Corporation Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Branch Corporation Status here] end
	private String hospitalBranchCorporationStatus;

	// % protected region % [Modify attribute annotation for Accreditation Type here] off begin
	@CsvBindByName(column = "ACCREDITATION_TYPE", required = false)
	@Nullable
	@Column(name = "accreditation_type")
	@Schema(description = "The Accreditation Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Accreditation Type here] end
	private String accreditationType;

	// % protected region % [Modify attribute annotation for Accreditation Level here] off begin
	@CsvBindByName(column = "ACCREDITATION_LEVEL", required = false)
	@Nullable
	@Column(name = "accreditation_level")
	@Schema(description = "The Accreditation Level of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Accreditation Level here] end
	private String accreditationLevel;

	// % protected region % [Modify attribute annotation for Accreditation Date here] off begin
	@CsvCustomBindByName(column = "ACCREDITATION_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "accreditation_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Accreditation Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Accreditation Date here] end
	private OffsetDateTime accreditationDate;

	// % protected region % [Modify attribute annotation for Bed Perinatology here] off begin
	@CsvBindByName(column = "BED_PERINATOLOGY", required = false)
	@Nullable
	@Column(name = "bed_perinatology")
	@Schema(description = "The Bed Perinatology of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Bed Perinatology here] end
	private String bedPerinatology;

	// % protected region % [Modify attribute annotation for Suite Class here] off begin
	@CsvBindByName(column = "SUITE_CLASS", required = false)
	@Nullable
	@Column(name = "suite_class")
	@Schema(description = "The Suite Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Suite Class here] end
	private String suiteClass;

	// % protected region % [Modify attribute annotation for VVIP Class here] off begin
	@CsvBindByName(column = "VVIP_CLASS", required = false)
	@Nullable
	@Column(name = "vvip_class")
	@Schema(description = "The VVIP Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for VVIP Class here] end
	private String vvipClass;

	// % protected region % [Modify attribute annotation for VIP A Class here] off begin
	@CsvBindByName(column = "VIP_A_CLASS", required = false)
	@Nullable
	@Column(name = "vip_a_class")
	@Schema(description = "The VIP A Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for VIP A Class here] end
	private String vipAClass;

	// % protected region % [Modify attribute annotation for VIP B Class here] off begin
	@CsvBindByName(column = "VIP_B_CLASS", required = false)
	@Nullable
	@Column(name = "vip_b_class")
	@Schema(description = "The VIP B Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for VIP B Class here] end
	private String vipBClass;

	// % protected region % [Modify attribute annotation for VIP C Class here] off begin
	@CsvBindByName(column = "VIP_C_CLASS", required = false)
	@Nullable
	@Column(name = "vip_c_class")
	@Schema(description = "The VIP C Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for VIP C Class here] end
	private String vipCClass;

	// % protected region % [Modify attribute annotation for Main Class here] off begin
	@CsvBindByName(column = "MAIN_CLASS", required = false)
	@Nullable
	@Column(name = "main_class")
	@Schema(description = "The Main Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Main Class here] end
	private String mainClass;

	// % protected region % [Modify attribute annotation for Class I here] off begin
	@CsvBindByName(column = "CLASS_I", required = false)
	@Nullable
	@Column(name = "class_i")
	@Schema(description = "The Class I of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Class I here] end
	private String classI;

	// % protected region % [Modify attribute annotation for II Class here] off begin
	@CsvBindByName(column = "II_CLASS", required = false)
	@Nullable
	@Column(name = "ii_class")
	@Schema(description = "The II Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for II Class here] end
	private String iiClass;

	// % protected region % [Modify attribute annotation for III A Class here] off begin
	@CsvBindByName(column = "III_A_CLASS", required = false)
	@Nullable
	@Column(name = "iii_a_class")
	@Schema(description = "The III A Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for III A Class here] end
	private String iiiAClass;

	// % protected region % [Modify attribute annotation for III B Class here] off begin
	@CsvBindByName(column = "III_B_CLASS", required = false)
	@Nullable
	@Column(name = "iii_b_class")
	@Schema(description = "The III B Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for III B Class here] end
	private String iiiBClass;

	// % protected region % [Modify attribute annotation for Special Class here] off begin
	@CsvBindByName(column = "SPECIAL_CLASS", required = false)
	@Nullable
	@Column(name = "special_class")
	@Schema(description = "The Special Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Special Class here] end
	private String specialClass;

	// % protected region % [Modify attribute annotation for ICU here] off begin
	@CsvBindByName(column = "ICU", required = false)
	@Nullable
	@Column(name = "icu")
	@Schema(description = "The ICU of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ICU here] end
	private String icu;

	// % protected region % [Modify attribute annotation for PICU here] off begin
	@CsvBindByName(column = "PICU", required = false)
	@Nullable
	@Column(name = "picu")
	@Schema(description = "The PICU of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for PICU here] end
	private String picu;

	// % protected region % [Modify attribute annotation for NICU here] off begin
	@CsvBindByName(column = "NICU", required = false)
	@Nullable
	@Column(name = "nicu")
	@Schema(description = "The NICU of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for NICU here] end
	private String nicu;

	// % protected region % [Modify attribute annotation for HCU here] off begin
	@CsvBindByName(column = "HCU", required = false)
	@Nullable
	@Column(name = "hcu")
	@Schema(description = "The HCU of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for HCU here] end
	private String hcu;

	// % protected region % [Modify attribute annotation for ICCU here] off begin
	@CsvBindByName(column = "ICCU", required = false)
	@Nullable
	@Column(name = "iccu")
	@Schema(description = "The ICCU of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ICCU here] end
	private String iccu;

	// % protected region % [Modify attribute annotation for Isolation Room here] off begin
	@CsvBindByName(column = "ISOLATION_ROOM", required = false)
	@Nullable
	@Column(name = "isolation_room")
	@Schema(description = "The Isolation Room of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Isolation Room here] end
	private String isolationRoom;

	// % protected region % [Modify attribute annotation for Emergency Room here] off begin
	@CsvBindByName(column = "EMERGENCY_ROOM", required = false)
	@Nullable
	@Column(name = "emergency_room")
	@Schema(description = "The Emergency Room of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Emergency Room here] end
	private String emergencyRoom;

	// % protected region % [Modify attribute annotation for Maternity Room here] off begin
	@CsvBindByName(column = "MATERNITY_ROOM", required = false)
	@Nullable
	@Column(name = "maternity_room")
	@Schema(description = "The Maternity Room of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Maternity Room here] end
	private String maternityRoom;

	// % protected region % [Modify attribute annotation for Operating Room here] off begin
	@CsvBindByName(column = "OPERATING_ROOM", required = false)
	@Nullable
	@Column(name = "operating_room")
	@Schema(description = "The Operating Room of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Operating Room here] end
	private String operatingRoom;

	// % protected region % [Modify attribute annotation for Doctor SpA here] off begin
	@CsvBindByName(column = "DOCTOR_SPA", required = false)
	@Nullable
	@Column(name = "doctor_spa")
	@Schema(description = "The Doctor SpA of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor SpA here] end
	private String doctorSpA;

	// % protected region % [Modify attribute annotation for Doctor SpOG here] off begin
	@CsvBindByName(column = "DOCTOR_SPOG", required = false)
	@Nullable
	@Column(name = "doctor_spog")
	@Schema(description = "The Doctor SpOG of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor SpOG here] end
	private String doctorSpOG;

	// % protected region % [Modify attribute annotation for Doctor SpPD here] off begin
	@CsvBindByName(column = "DOCTOR_SPPD", required = false)
	@Nullable
	@Column(name = "doctor_sppd")
	@Schema(description = "The Doctor SpPD of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor SpPD here] end
	private String doctorSpPD;

	// % protected region % [Modify attribute annotation for Doctor SpB here] off begin
	@CsvBindByName(column = "DOCTOR_SPB", required = false)
	@Nullable
	@Column(name = "doctor_spb")
	@Schema(description = "The Doctor SpB of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor SpB here] end
	private String doctorSpB;

	// % protected region % [Modify attribute annotation for Doctor SpRad here] off begin
	@CsvBindByName(column = "DOCTOR_SPRAD", required = false)
	@Nullable
	@Column(name = "doctor_sprad")
	@Schema(description = "The Doctor SpRad of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor SpRad here] end
	private String doctorSpRad;

	// % protected region % [Modify attribute annotation for Doctor SpRm here] off begin
	@CsvBindByName(column = "DOCTOR_SPRM", required = false)
	@Nullable
	@Column(name = "doctor_sprm")
	@Schema(description = "The Doctor SpRm of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor SpRm here] end
	private String doctorSpRm;

	// % protected region % [Modify attribute annotation for Doctor SpAn here] off begin
	@CsvBindByName(column = "DOCTOR_SPAN", required = false)
	@Nullable
	@Column(name = "doctor_span")
	@Schema(description = "The Doctor SpAn of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor SpAn here] end
	private String doctorSpAn;

	// % protected region % [Modify attribute annotation for Doctor SpJp here] off begin
	@CsvBindByName(column = "DOCTOR_SPJP", required = false)
	@Nullable
	@Column(name = "doctor_spjp")
	@Schema(description = "The Doctor SpJp of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor SpJp here] end
	private String doctorSpJp;

	// % protected region % [Modify attribute annotation for Doctor SpM here] off begin
	@CsvBindByName(column = "DOCTOR_SPM", required = false)
	@Nullable
	@Column(name = "doctor_spm")
	@Schema(description = "The Doctor SpM of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor SpM here] end
	private String doctorSpM;

	// % protected region % [Modify attribute annotation for Doctor SpTHT here] off begin
	@CsvBindByName(column = "DOCTOR_SPTHT", required = false)
	@Nullable
	@Column(name = "doctor_sptht")
	@Schema(description = "The Doctor SpTHT of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor SpTHT here] end
	private String doctorSpTHT;

	// % protected region % [Modify attribute annotation for Doctor SpKj here] off begin
	@CsvBindByName(column = "DOCTOR_SPKJ", required = false)
	@Nullable
	@Column(name = "doctor_spkj")
	@Schema(description = "The Doctor SpKj of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor SpKj here] end
	private String doctorSpKj;

	// % protected region % [Modify attribute annotation for Doctor SpP here] off begin
	@CsvBindByName(column = "DOCTOR_SPP", required = false)
	@Nullable
	@Column(name = "doctor_spp")
	@Schema(description = "The Doctor SpP of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor SpP here] end
	private String doctorSpP;

	// % protected region % [Modify attribute annotation for Doctor SpPK here] off begin
	@CsvBindByName(column = "DOCTOR_SPPK", required = false)
	@Nullable
	@Column(name = "doctor_sppk")
	@Schema(description = "The Doctor SpPK of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor SpPK here] end
	private String doctorSpPK;

	// % protected region % [Modify attribute annotation for Doctor SpS here] off begin
	@CsvBindByName(column = "DOCTOR_SPS", required = false)
	@Nullable
	@Column(name = "doctor_sps")
	@Schema(description = "The Doctor SpS of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor SpS here] end
	private String doctorSpS;

	// % protected region % [Modify attribute annotation for Sub Specialist Doctor here] off begin
	@CsvBindByName(column = "SUB_SPECIALIST_DOCTOR", required = false)
	@Nullable
	@Column(name = "sub_specialist_doctor")
	@Schema(description = "The Sub Specialist Doctor of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sub Specialist Doctor here] end
	private String subSpecialistDoctor;

	// % protected region % [Modify attribute annotation for Other Specialist Doctor here] off begin
	@CsvBindByName(column = "OTHER_SPECIALIST_DOCTOR", required = false)
	@Nullable
	@Column(name = "other_specialist_doctor")
	@Schema(description = "The Other Specialist Doctor of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Other Specialist Doctor here] end
	private String otherSpecialistDoctor;

	// % protected region % [Modify attribute annotation for General Practice here] off begin
	@CsvBindByName(column = "GENERAL_PRACTICE", required = false)
	@Nullable
	@Column(name = "general_practice")
	@Schema(description = "The General Practice of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for General Practice here] end
	private String generalPractice;

	// % protected region % [Modify attribute annotation for Dentist here] off begin
	@CsvBindByName(column = "DENTIST", required = false)
	@Nullable
	@Column(name = "dentist")
	@Schema(description = "The Dentist of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dentist here] end
	private String dentist;

	// % protected region % [Modify attribute annotation for Specialist Dentist here] off begin
	@CsvBindByName(column = "SPECIALIST_DENTIST", required = false)
	@Nullable
	@Column(name = "specialist_dentist")
	@Schema(description = "The Specialist Dentist of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Specialist Dentist here] end
	private String specialistDentist;

	// % protected region % [Modify attribute annotation for Nurse here] off begin
	@CsvBindByName(column = "NURSE", required = false)
	@Nullable
	@Column(name = "nurse")
	@Schema(description = "The Nurse of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nurse here] end
	private String nurse;

	// % protected region % [Modify attribute annotation for Midwife here] off begin
	@CsvBindByName(column = "MIDWIFE", required = false)
	@Nullable
	@Column(name = "midwife")
	@Schema(description = "The Midwife of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Midwife here] end
	private String midwife;

	// % protected region % [Modify attribute annotation for Pharmacist here] off begin
	@CsvBindByName(column = "PHARMACIST", required = false)
	@Nullable
	@Column(name = "pharmacist")
	@Schema(description = "The Pharmacist of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pharmacist here] end
	private String pharmacist;

	// % protected region % [Modify attribute annotation for Other Medical Staff here] off begin
	@CsvBindByName(column = "OTHER_MEDICAL_STAFF", required = false)
	@Nullable
	@Column(name = "other_medical_staff")
	@Schema(description = "The Other Medical Staff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Other Medical Staff here] end
	private String otherMedicalStaff;

	// % protected region % [Modify attribute annotation for Non Medical Staff here] off begin
	@CsvBindByName(column = "NON_MEDICAL_STAFF", required = false)
	@Nullable
	@Column(name = "non_medical_staff")
	@Schema(description = "The Non Medical Staff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Non Medical Staff here] end
	private String nonMedicalStaff;

	// % protected region % [Modify attribute annotation for Timezone here] off begin
	@CsvBindByName(column = "TIMEZONE", required = false)
	@Nullable
	@Column(name = "timezone")
	@Schema(description = "The Timezone of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Timezone here] end
	private String timezone;

	// % protected region % [Modify attribute annotation for Health Facility Level here] off begin
	@CsvBindByName(column = "HEALTH_FACILITY_LEVEL", required = false)
	@Nullable
	@Column(name = "health_facility_level")
	@Schema(description = "The Health Facility Level of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Health Facility Level here] end
	private String healthFacilityLevel;

	// % protected region % [Modify attribute annotation for Satu Sehat Integration here] off begin
	@CsvBindByName(column = "SATU_SEHAT_INTEGRATION", required = false)
	@Nullable
	@Column(name = "satu_sehat_integration")
	@Schema(description = "The Satu Sehat Integration of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Satu Sehat Integration here] end
	private Boolean satuSehatIntegration = false ;

	// % protected region % [Modify attribute annotation for Tax Identification here] off begin
	@CsvBindByName(column = "TAX_IDENTIFICATION", required = false)
	@Nullable
	@Column(name = "tax_identification")
	@Schema(description = "The Tax Identification of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tax Identification here] end
	private String taxIdentification;

	@CsvIgnore
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	private Set<FileEntity> leftLogo = new HashSet<>();

	@CsvIgnore
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	private Set<FileEntity> rightLogo = new HashSet<>();

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

	// % protected region % [Update the annotation for Hospital Group here] off begin
	@Schema(description = "The Hospital Group entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Hospital Group here] end
	private HospitalGroupInformationEntity hospitalGroup;

	// % protected region % [Update the annotation for hospitalGroupId here] off begin
	@Transient
	@CsvCustomBindByName(column = "HOSPITAL_GROUP_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for hospitalGroupId here] end
	private UUID hospitalGroupId;

	// % protected region % [Update the annotation for Staff here] off begin
	@Schema(description = "The Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Staff here] end
	private StaffEntity staff;

	// % protected region % [Update the annotation for staffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for staffId here] end
	private UUID staffId;

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
	 * Similar to {@link this#setHospitalGroup(HospitalGroupInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HospitalGroupInformationEntity to be set to this entity
	 */
	public void setHospitalGroup(@NotNull HospitalGroupInformationEntity entity) {
		setHospitalGroup(entity, true);
	}

	/**
	 * Set or update the hospitalGroup in this entity with single HospitalGroupInformationEntity.
	 *
	 * @param entity the given HospitalGroupInformationEntity to be set or updated to hospitalGroup
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setHospitalGroup(@NotNull HospitalGroupInformationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setHospitalGroup here] off begin
		// % protected region % [Add any additional logic here before the main logic for setHospitalGroup here] end

		if (sameAsFormer(this.hospitalGroup, entity)) {
			return;
		}

		if (this.hospitalGroup != null) {
			this.hospitalGroup.removeHospitalBranchInformations(this, false);
		}
		this.hospitalGroup = entity;
		if (reverseAdd) {
			this.hospitalGroup.addHospitalBranchInformations(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setHospitalGroup incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setHospitalGroup incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetHospitalGroup(boolean)} but default to true.
	 */
	public void unsetHospitalGroup() {
		this.unsetHospitalGroup(true);
	}

	/**
	 * Remove Hospital Group in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetHospitalGroup(boolean reverse) {
		if (reverse && this.hospitalGroup != null) {
			this.hospitalGroup.removeHospitalBranchInformations(this, false);
		}
		this.hospitalGroup = null;
	}
	/**
	 * Similar to {@link this#setStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setStaff(@NotNull StaffEntity entity) {
		setStaff(entity, true);
	}

	/**
	 * Set or update the staff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to staff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStaff here] end

		if (sameAsFormer(this.staff, entity)) {
			return;
		}

		if (this.staff != null) {
			this.staff.removeHospitalBranchInformations(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addHospitalBranchInformations(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStaff(boolean)} but default to true.
	 */
	public void unsetStaff() {
		this.unsetStaff(true);
	}

	/**
	 * Remove Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStaff(boolean reverse) {
		if (reverse && this.staff != null) {
			this.staff.removeHospitalBranchInformations(this, false);
		}
		this.staff = null;
	}

	public void addLeftLogo(FileEntity newFile) {
		leftLogo.add(newFile);
	}

	public void addAllLeftLogo(Collection<FileEntity> newFiles) {
		leftLogo.addAll(newFiles);
	}

	public void removeLeftLogo(FileEntity newFile) {
		leftLogo.remove(newFile);
	}

	public boolean containsLeftLogo(FileEntity newFile) {
		return leftLogo.contains(newFile);
	}

	public void clearAllLeftLogo() {
		leftLogo.clear();
	}

	public void addRightLogo(FileEntity newFile) {
		rightLogo.add(newFile);
	}

	public void addAllRightLogo(Collection<FileEntity> newFiles) {
		rightLogo.addAll(newFiles);
	}

	public void removeRightLogo(FileEntity newFile) {
		rightLogo.remove(newFile);
	}

	public boolean containsRightLogo(FileEntity newFile) {
		return rightLogo.contains(newFile);
	}

	public void clearAllRightLogo() {
		rightLogo.clear();
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
		return "HOSPITAL_CODE,HOSPITAL_NAME,HOSPITAL_TYPE,HOSPITAL_CLASS,HOSPITAL_DIRECTOR_NAME,DATE_OF_REGISTRATION,HOSPITAL_CORPORATION_NAME,IS_BPJS_FACILITY,ADDRESS,CITY,POSTCODE,PHONE_NUMBER,FAX,EMAIL,WEBSITE,CONTACT_PERSON,CONTACT_PERSON_PHONE_NUMBER,CONTACT_PERSON_EMAIL,LAND_SIZE,BUILDING_SIZE,PERMIT_NUMBER,PERMIT_DATE,AUTHORIZED_BY,PERMIT_TYPE,VALID_UNTIL,HOSPITAL_BRANCH_CORPORATION_NAME,HOSPITAL_BRANCH_CORPORATION_STATUS,ACCREDITATION_TYPE,ACCREDITATION_LEVEL,ACCREDITATION_DATE,BED_PERINATOLOGY,SUITE_CLASS,VVIP_CLASS,VIP_A_CLASS,VIP_B_CLASS,VIP_C_CLASS,MAIN_CLASS,CLASS_I,II_CLASS,III_A_CLASS,III_B_CLASS,SPECIAL_CLASS,ICU,PICU,NICU,HCU,ICCU,ISOLATION_ROOM,EMERGENCY_ROOM,MATERNITY_ROOM,OPERATING_ROOM,DOCTOR_SPA,DOCTOR_SPOG,DOCTOR_SPPD,DOCTOR_SPB,DOCTOR_SPRAD,DOCTOR_SPRM,DOCTOR_SPAN,DOCTOR_SPJP,DOCTOR_SPM,DOCTOR_SPTHT,DOCTOR_SPKJ,DOCTOR_SPP,DOCTOR_SPPK,DOCTOR_SPS,SUB_SPECIALIST_DOCTOR,OTHER_SPECIALIST_DOCTOR,GENERAL_PRACTICE,DENTIST,SPECIALIST_DENTIST,NURSE,MIDWIFE,PHARMACIST,OTHER_MEDICAL_STAFF,NON_MEDICAL_STAFF,TIMEZONE,HEALTH_FACILITY_LEVEL,SATU_SEHAT_INTEGRATION,TAX_IDENTIFICATION,HOSPITAL_GROUP_ID,STAFF_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<HospitalGroupInformationEntity> hospitalGroupRelation = Optional.ofNullable(this.hospitalGroup);
		hospitalGroupRelation.ifPresent(entity -> this.hospitalGroupId = entity.getId());

		Optional<StaffEntity> staffRelation = Optional.ofNullable(this.staff);
		staffRelation.ifPresent(entity -> this.staffId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object hospitalBranchInformation) {
		if (this == hospitalBranchInformation) {
			return true;
		}
		if (hospitalBranchInformation == null || this.getClass() != hospitalBranchInformation.getClass()) {
			return false;
		}
		if (!super.equals(hospitalBranchInformation)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		HospitalBranchInformationEntity that = (HospitalBranchInformationEntity) hospitalBranchInformation;
		return
			Objects.equals(this.hospitalCode, that.hospitalCode) &&
			Objects.equals(this.hospitalName, that.hospitalName) &&
			Objects.equals(this.hospitalType, that.hospitalType) &&
			Objects.equals(this.hospitalClass, that.hospitalClass) &&
			Objects.equals(this.hospitalDirectorName, that.hospitalDirectorName) &&
			Objects.equals(
			     this.dateOfRegistration != null ? this.dateOfRegistration.truncatedTo(ChronoUnit.DAYS) : null,
			     that.dateOfRegistration != null ? that.dateOfRegistration.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.hospitalCorporationName, that.hospitalCorporationName) &&
			Objects.equals(this.isBPJSFacility, that.isBPJSFacility) &&
			Objects.equals(this.address, that.address) &&
			Objects.equals(this.city, that.city) &&
			Objects.equals(this.postcode, that.postcode) &&
			Objects.equals(this.phoneNumber, that.phoneNumber) &&
			Objects.equals(this.fax, that.fax) &&
			Objects.equals(this.email, that.email) &&
			Objects.equals(this.website, that.website) &&
			Objects.equals(this.contactPerson, that.contactPerson) &&
			Objects.equals(this.contactPersonPhoneNumber, that.contactPersonPhoneNumber) &&
			Objects.equals(this.contactPersonEmail, that.contactPersonEmail) &&
			Objects.equals(this.landSize, that.landSize) &&
			Objects.equals(this.buildingSize, that.buildingSize) &&
			Objects.equals(this.permitNumber, that.permitNumber) &&
			Objects.equals(
			     this.permitDate != null ? this.permitDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.permitDate != null ? that.permitDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.authorizedBy, that.authorizedBy) &&
			Objects.equals(this.permitType, that.permitType) &&
			Objects.equals(
			     this.validUntil != null ? this.validUntil.truncatedTo(ChronoUnit.DAYS) : null,
			     that.validUntil != null ? that.validUntil.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.hospitalBranchCorporationName, that.hospitalBranchCorporationName) &&
			Objects.equals(this.hospitalBranchCorporationStatus, that.hospitalBranchCorporationStatus) &&
			Objects.equals(this.accreditationType, that.accreditationType) &&
			Objects.equals(this.accreditationLevel, that.accreditationLevel) &&
			Objects.equals(
			     this.accreditationDate != null ? this.accreditationDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.accreditationDate != null ? that.accreditationDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.bedPerinatology, that.bedPerinatology) &&
			Objects.equals(this.suiteClass, that.suiteClass) &&
			Objects.equals(this.vvipClass, that.vvipClass) &&
			Objects.equals(this.vipAClass, that.vipAClass) &&
			Objects.equals(this.vipBClass, that.vipBClass) &&
			Objects.equals(this.vipCClass, that.vipCClass) &&
			Objects.equals(this.mainClass, that.mainClass) &&
			Objects.equals(this.classI, that.classI) &&
			Objects.equals(this.iiClass, that.iiClass) &&
			Objects.equals(this.iiiAClass, that.iiiAClass) &&
			Objects.equals(this.iiiBClass, that.iiiBClass) &&
			Objects.equals(this.specialClass, that.specialClass) &&
			Objects.equals(this.icu, that.icu) &&
			Objects.equals(this.picu, that.picu) &&
			Objects.equals(this.nicu, that.nicu) &&
			Objects.equals(this.hcu, that.hcu) &&
			Objects.equals(this.iccu, that.iccu) &&
			Objects.equals(this.isolationRoom, that.isolationRoom) &&
			Objects.equals(this.emergencyRoom, that.emergencyRoom) &&
			Objects.equals(this.maternityRoom, that.maternityRoom) &&
			Objects.equals(this.operatingRoom, that.operatingRoom) &&
			Objects.equals(this.doctorSpA, that.doctorSpA) &&
			Objects.equals(this.doctorSpOG, that.doctorSpOG) &&
			Objects.equals(this.doctorSpPD, that.doctorSpPD) &&
			Objects.equals(this.doctorSpB, that.doctorSpB) &&
			Objects.equals(this.doctorSpRad, that.doctorSpRad) &&
			Objects.equals(this.doctorSpRm, that.doctorSpRm) &&
			Objects.equals(this.doctorSpAn, that.doctorSpAn) &&
			Objects.equals(this.doctorSpJp, that.doctorSpJp) &&
			Objects.equals(this.doctorSpM, that.doctorSpM) &&
			Objects.equals(this.doctorSpTHT, that.doctorSpTHT) &&
			Objects.equals(this.doctorSpKj, that.doctorSpKj) &&
			Objects.equals(this.doctorSpP, that.doctorSpP) &&
			Objects.equals(this.doctorSpPK, that.doctorSpPK) &&
			Objects.equals(this.doctorSpS, that.doctorSpS) &&
			Objects.equals(this.subSpecialistDoctor, that.subSpecialistDoctor) &&
			Objects.equals(this.otherSpecialistDoctor, that.otherSpecialistDoctor) &&
			Objects.equals(this.generalPractice, that.generalPractice) &&
			Objects.equals(this.dentist, that.dentist) &&
			Objects.equals(this.specialistDentist, that.specialistDentist) &&
			Objects.equals(this.nurse, that.nurse) &&
			Objects.equals(this.midwife, that.midwife) &&
			Objects.equals(this.pharmacist, that.pharmacist) &&
			Objects.equals(this.otherMedicalStaff, that.otherMedicalStaff) &&
			Objects.equals(this.nonMedicalStaff, that.nonMedicalStaff) &&
			Objects.equals(this.timezone, that.timezone) &&
			Objects.equals(this.healthFacilityLevel, that.healthFacilityLevel) &&
			Objects.equals(this.satuSehatIntegration, that.satuSehatIntegration) &&
			Objects.equals(this.taxIdentification, that.taxIdentification) &&
			Objects.equals(this.hospitalGroupId, that.hospitalGroupId) &&
			Objects.equals(this.staffId, that.staffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
