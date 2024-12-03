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
import kmsweb.dtos.NhisClaimEntityDto;
import kmsweb.entities.listeners.NhisClaimEntityListener;
import kmsweb.serializers.NhisClaimSerializer;
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
@EntityListeners({NhisClaimEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = NhisClaimSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class NhisClaimEntity extends AbstractEntity {

	/**
	 * Takes a NhisClaimEntityDto and converts it into a NhisClaimEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param nhisClaimEntityDto
	 */
	public NhisClaimEntity(NhisClaimEntityDto nhisClaimEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (nhisClaimEntityDto.getId() != null) {
			this.setId(nhisClaimEntityDto.getId());
		}

		if (nhisClaimEntityDto.getSystemClaimID() != null) {
			this.setSystemClaimID(nhisClaimEntityDto.getSystemClaimID());
		}

		if (nhisClaimEntityDto.getRefInvoiceNo() != null) {
			this.setRefInvoiceNo(nhisClaimEntityDto.getRefInvoiceNo());
		}

		if (nhisClaimEntityDto.getFormNo() != null) {
			this.setFormNo(nhisClaimEntityDto.getFormNo());
		}

		if (nhisClaimEntityDto.getClaimID() != null) {
			this.setClaimID(nhisClaimEntityDto.getClaimID());
		}

		if (nhisClaimEntityDto.getClaimCheckCode() != null) {
			this.setClaimCheckCode(nhisClaimEntityDto.getClaimCheckCode());
		}

		if (nhisClaimEntityDto.getBatchNumber() != null) {
			this.setBatchNumber(nhisClaimEntityDto.getBatchNumber());
		}

		if (nhisClaimEntityDto.getSurname() != null) {
			this.setSurname(nhisClaimEntityDto.getSurname());
		}

		if (nhisClaimEntityDto.getOtherNames() != null) {
			this.setOtherNames(nhisClaimEntityDto.getOtherNames());
		}

		if (nhisClaimEntityDto.getGender() != null) {
			this.setGender(nhisClaimEntityDto.getGender());
		}

		if (nhisClaimEntityDto.getDateOfBirth() != null) {
			this.setDateOfBirth(nhisClaimEntityDto.getDateOfBirth());
		}

		if (nhisClaimEntityDto.getMemberNo() != null) {
			this.setMemberNo(nhisClaimEntityDto.getMemberNo());
		}

		if (nhisClaimEntityDto.getHospitalRecordNo() != null) {
			this.setHospitalRecordNo(nhisClaimEntityDto.getHospitalRecordNo());
		}

		if (nhisClaimEntityDto.getCardSerialNumber() != null) {
			this.setCardSerialNumber(nhisClaimEntityDto.getCardSerialNumber());
		}

		if (nhisClaimEntityDto.getDependant() != null) {
			this.setDependant(nhisClaimEntityDto.getDependant());
		}

		if (nhisClaimEntityDto.getUnbundled() != null) {
			this.setUnbundled(nhisClaimEntityDto.getUnbundled());
		}

		if (nhisClaimEntityDto.getIncludesPharmacy() != null) {
			this.setIncludesPharmacy(nhisClaimEntityDto.getIncludesPharmacy());
		}

		if (nhisClaimEntityDto.getTypeOfAttendance() != null) {
			this.setTypeOfAttendance(nhisClaimEntityDto.getTypeOfAttendance());
		}

		if (nhisClaimEntityDto.getFirstVisitAdmission() != null) {
			this.setFirstVisitAdmission(nhisClaimEntityDto.getFirstVisitAdmission());
		}

		if (nhisClaimEntityDto.getSecondVisitDischarge() != null) {
			this.setSecondVisitDischarge(nhisClaimEntityDto.getSecondVisitDischarge());
		}

		if (nhisClaimEntityDto.getThirdVisit() != null) {
			this.setThirdVisit(nhisClaimEntityDto.getThirdVisit());
		}

		if (nhisClaimEntityDto.getFourthVisit() != null) {
			this.setFourthVisit(nhisClaimEntityDto.getFourthVisit());
		}

		if (nhisClaimEntityDto.getPhysicianName() != null) {
			this.setPhysicianName(nhisClaimEntityDto.getPhysicianName());
		}

		if (nhisClaimEntityDto.getPhysicianCode() != null) {
			this.setPhysicianCode(nhisClaimEntityDto.getPhysicianCode());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for System Claim ID here] off begin
	@CsvBindByName(column = "SYSTEM_CLAIM_ID", required = false)
	@Nullable
	@Column(name = "system_claim_id")
	@Schema(description = "The System Claim ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for System Claim ID here] end
	private String systemClaimID;

	// % protected region % [Modify attribute annotation for Ref Invoice No here] off begin
	@CsvBindByName(column = "REF_INVOICE_NO", required = false)
	@Nullable
	@Column(name = "ref_invoice_no")
	@Schema(description = "The Ref Invoice No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ref Invoice No here] end
	private String refInvoiceNo;

	// % protected region % [Modify attribute annotation for Form No here] off begin
	@CsvBindByName(column = "FORM_NO", required = false)
	@Nullable
	@Column(name = "form_no")
	@Schema(description = "The Form No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Form No here] end
	private String formNo;

	// % protected region % [Modify attribute annotation for Claim ID here] off begin
	@CsvBindByName(column = "CLAIM_ID", required = false)
	@Nullable
	@Column(name = "claim_id")
	@Schema(description = "The Claim ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Claim ID here] end
	private String claimID;

	// % protected region % [Modify attribute annotation for Claim Check Code here] off begin
	@CsvBindByName(column = "CLAIM_CHECK_CODE", required = false)
	@Nullable
	@Column(name = "claim_check_code")
	@Schema(description = "The Claim Check Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Claim Check Code here] end
	private String claimCheckCode;

	// % protected region % [Modify attribute annotation for Batch Number here] off begin
	@CsvBindByName(column = "BATCH_NUMBER", required = false)
	@Nullable
	@Column(name = "batch_number")
	@Schema(description = "The Batch Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Batch Number here] end
	private String batchNumber;

	// % protected region % [Modify attribute annotation for Surname here] off begin
	@CsvBindByName(column = "SURNAME", required = false)
	@Nullable
	@Column(name = "surname")
	@Schema(description = "The Surname of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Surname here] end
	private String surname;

	// % protected region % [Modify attribute annotation for Other Names here] off begin
	@CsvBindByName(column = "OTHER_NAMES", required = false)
	@Nullable
	@Column(name = "other_names")
	@Schema(description = "The Other Names of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Other Names here] end
	private String otherNames;

	// % protected region % [Modify attribute annotation for Gender here] off begin
	@CsvBindByName(column = "GENDER", required = false)
	@Nullable
	@Column(name = "gender")
	@Schema(description = "The Gender of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gender here] end
	private String gender;

	// % protected region % [Modify attribute annotation for Date Of Birth here] off begin

	@CsvCustomBindByName(column = "DATE_OF_BIRTH", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "date_of_birth")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Date Of Birth of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Date Of Birth here] end
	private OffsetDateTime dateOfBirth;

	// % protected region % [Modify attribute annotation for Member No here] off begin
	@CsvBindByName(column = "MEMBER_NO", required = false)
	@Nullable
	@Column(name = "member_no")
	@Schema(description = "The Member No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Member No here] end
	private String memberNo;

	// % protected region % [Modify attribute annotation for Hospital Record No here] off begin
	@CsvBindByName(column = "HOSPITAL_RECORD_NO", required = false)
	@Nullable
	@Column(name = "hospital_record_no")
	@Schema(description = "The Hospital Record No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Record No here] end
	private String hospitalRecordNo;

	// % protected region % [Modify attribute annotation for Card Serial Number here] off begin
	@CsvBindByName(column = "CARD_SERIAL_NUMBER", required = false)
	@Nullable
	@Column(name = "card_serial_number")
	@Schema(description = "The Card Serial Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Card Serial Number here] end
	private String cardSerialNumber;

	// % protected region % [Modify attribute annotation for Dependant here] off begin
	@CsvBindByName(column = "DEPENDANT", required = false)
	@Nullable
	@Column(name = "dependant")
	@Schema(description = "The Dependant of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dependant here] end
	private Boolean dependant = false ;

	// % protected region % [Modify attribute annotation for Unbundled here] off begin
	@CsvBindByName(column = "UNBUNDLED", required = false)
	@Nullable
	@Column(name = "unbundled")
	@Schema(description = "The Unbundled of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Unbundled here] end
	private Boolean unbundled = false ;

	// % protected region % [Modify attribute annotation for Includes Pharmacy here] off begin
	@CsvBindByName(column = "INCLUDES_PHARMACY", required = false)
	@Nullable
	@Column(name = "includes_pharmacy")
	@Schema(description = "The Includes Pharmacy of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Includes Pharmacy here] end
	private Boolean includesPharmacy = false ;

	// % protected region % [Modify attribute annotation for Type Of Attendance here] off begin
	@CsvBindByName(column = "TYPE_OF_ATTENDANCE", required = false)
	@Nullable
	@Column(name = "type_of_attendance")
	@Schema(description = "The Type Of Attendance of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Type Of Attendance here] end
	private String typeOfAttendance;

	// % protected region % [Modify attribute annotation for First Visit Admission here] off begin

	@CsvCustomBindByName(column = "FIRST_VISIT_ADMISSION", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "first_visit_admission")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The First Visit Admission of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for First Visit Admission here] end
	private OffsetDateTime firstVisitAdmission;

	// % protected region % [Modify attribute annotation for Second Visit Discharge here] off begin

	@CsvCustomBindByName(column = "SECOND_VISIT_DISCHARGE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "second_visit_discharge")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Second Visit Discharge of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Second Visit Discharge here] end
	private OffsetDateTime secondVisitDischarge;

	// % protected region % [Modify attribute annotation for Third Visit here] off begin

	@CsvCustomBindByName(column = "THIRD_VISIT", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "third_visit")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Third Visit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Third Visit here] end
	private OffsetDateTime thirdVisit;

	// % protected region % [Modify attribute annotation for Fourth Visit here] off begin

	@CsvCustomBindByName(column = "FOURTH_VISIT", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "fourth_visit")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Fourth Visit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Fourth Visit here] end
	private OffsetDateTime fourthVisit;

	// % protected region % [Modify attribute annotation for Physician Name here] off begin
	@CsvBindByName(column = "PHYSICIAN_NAME", required = false)
	@Nullable
	@Column(name = "physician_name")
	@Schema(description = "The Physician Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Physician Name here] end
	private String physicianName;

	// % protected region % [Modify attribute annotation for Physician Code here] off begin
	@CsvBindByName(column = "PHYSICIAN_CODE", required = false)
	@Nullable
	@Column(name = "physician_code")
	@Schema(description = "The Physician Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Physician Code here] end
	private String physicianCode;

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
		return "SYSTEM_CLAIM_ID,REF_INVOICE_NO,FORM_NO,CLAIM_ID,CLAIM_CHECK_CODE,BATCH_NUMBER,SURNAME,OTHER_NAMES,GENDER,DATE_OF_BIRTH,MEMBER_NO,HOSPITAL_RECORD_NO,CARD_SERIAL_NUMBER,DEPENDANT,UNBUNDLED,INCLUDES_PHARMACY,TYPE_OF_ATTENDANCE,FIRST_VISIT_ADMISSION,SECOND_VISIT_DISCHARGE,THIRD_VISIT,FOURTH_VISIT,PHYSICIAN_NAME,PHYSICIAN_CODE,ID";
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
	public boolean equals(Object nhisClaim) {
		if (this == nhisClaim) {
			return true;
		}
		if (nhisClaim == null || this.getClass() != nhisClaim.getClass()) {
			return false;
		}
		if (!super.equals(nhisClaim)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		NhisClaimEntity that = (NhisClaimEntity) nhisClaim;
		return
			Objects.equals(this.systemClaimID, that.systemClaimID) &&
			Objects.equals(this.refInvoiceNo, that.refInvoiceNo) &&
			Objects.equals(this.formNo, that.formNo) &&
			Objects.equals(this.claimID, that.claimID) &&
			Objects.equals(this.claimCheckCode, that.claimCheckCode) &&
			Objects.equals(this.batchNumber, that.batchNumber) &&
			Objects.equals(this.surname, that.surname) &&
			Objects.equals(this.otherNames, that.otherNames) &&
			Objects.equals(this.gender, that.gender) &&
			Objects.equals(
			     this.dateOfBirth != null ? this.dateOfBirth.truncatedTo(ChronoUnit.DAYS) : null,
			     that.dateOfBirth != null ? that.dateOfBirth.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.memberNo, that.memberNo) &&
			Objects.equals(this.hospitalRecordNo, that.hospitalRecordNo) &&
			Objects.equals(this.cardSerialNumber, that.cardSerialNumber) &&
			Objects.equals(this.dependant, that.dependant) &&
			Objects.equals(this.unbundled, that.unbundled) &&
			Objects.equals(this.includesPharmacy, that.includesPharmacy) &&
			Objects.equals(this.typeOfAttendance, that.typeOfAttendance) &&
			Objects.equals(
			     this.firstVisitAdmission != null ? this.firstVisitAdmission.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.firstVisitAdmission != null ? that.firstVisitAdmission.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.secondVisitDischarge != null ? this.secondVisitDischarge.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.secondVisitDischarge != null ? that.secondVisitDischarge.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.thirdVisit != null ? this.thirdVisit.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.thirdVisit != null ? that.thirdVisit.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.fourthVisit != null ? this.fourthVisit.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.fourthVisit != null ? that.fourthVisit.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.physicianName, that.physicianName) &&
			Objects.equals(this.physicianCode, that.physicianCode);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
