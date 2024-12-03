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
import kmsweb.dtos.CashRefundEntityDto;
import kmsweb.entities.listeners.CashRefundEntityListener;
import kmsweb.serializers.CashRefundSerializer;
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
@EntityListeners({CashRefundEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = CashRefundSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class CashRefundEntity extends AbstractEntity {

	/**
	 * Takes a CashRefundEntityDto and converts it into a CashRefundEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param cashRefundEntityDto
	 */
	public CashRefundEntity(CashRefundEntityDto cashRefundEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (cashRefundEntityDto.getId() != null) {
			this.setId(cashRefundEntityDto.getId());
		}

		if (cashRefundEntityDto.getRefundNumber() != null) {
			this.setRefundNumber(cashRefundEntityDto.getRefundNumber());
		}

		if (cashRefundEntityDto.getRefundDate() != null) {
			this.setRefundDate(cashRefundEntityDto.getRefundDate());
		}

		if (cashRefundEntityDto.getDescription() != null) {
			this.setDescription(cashRefundEntityDto.getDescription());
		}

		if (cashRefundEntityDto.getCashierLocation() != null) {
			this.setCashierLocation(cashRefundEntityDto.getCashierLocation());
		}

		if (cashRefundEntityDto.getIsvoid() != null) {
			this.setIsvoid(cashRefundEntityDto.getIsvoid());
		}

		if (cashRefundEntityDto.getVoidDateTime() != null) {
			this.setVoidDateTime(cashRefundEntityDto.getVoidDateTime());
		}

		if (cashRefundEntityDto.getPaymentType() != null) {
			this.setPaymentType(cashRefundEntityDto.getPaymentType());
		}

		if (cashRefundEntityDto.getRefundAmount() != null) {
			this.setRefundAmount(cashRefundEntityDto.getRefundAmount());
		}

		if (cashRefundEntityDto.getHospitalBankAccount() != null) {
			this.setHospitalBankAccount(cashRefundEntityDto.getHospitalBankAccount());
		}

		if (cashRefundEntityDto.getReferenceNumber() != null) {
			this.setReferenceNumber(cashRefundEntityDto.getReferenceNumber());
		}

		if (cashRefundEntityDto.getPatientGeneralInfo() != null) {
			this.setPatientGeneralInfo(cashRefundEntityDto.getPatientGeneralInfo());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Refund Number here] off begin
	@CsvBindByName(column = "REFUND_NUMBER", required = false)
	@Nullable
	@Column(name = "refund_number")
	@Schema(description = "The Refund Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Refund Number here] end
	private String refundNumber;

	// % protected region % [Modify attribute annotation for Refund Date here] off begin

	@CsvCustomBindByName(column = "REFUND_DATE", converter = DateTimeConverter.class, required = true)
	@NotNull(message = "Refund Date must not be empty")
	@Column(name = "refund_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Refund Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Refund Date here] end
	private OffsetDateTime refundDate;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@CsvBindByName(column = "DESCRIPTION", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "description")
	@Schema(description = "The Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for Cashier Location here] off begin
	@CsvBindByName(column = "CASHIER_LOCATION", required = true)
	@NotNull(message = "Cashier Location must not be empty")
	@Column(name = "cashier_location")
	@Schema(description = "The Cashier Location of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Cashier Location here] end
	private String cashierLocation;

	// % protected region % [Modify attribute annotation for IsVoid here] off begin
	@CsvBindByName(column = "ISVOID", required = false)
	@Nullable
	@Column(name = "isvoid")
	@Schema(description = "The IsVoid of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for IsVoid here] end
	private Boolean isvoid = false ;

	// % protected region % [Modify attribute annotation for Void Date Time here] off begin

	@CsvCustomBindByName(column = "VOID_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "void_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Void Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Void Date Time here] end
	private OffsetDateTime voidDateTime;

	// % protected region % [Modify attribute annotation for Payment Type here] off begin
	@CsvBindByName(column = "PAYMENT_TYPE", required = false)
	@Nullable
	@Column(name = "payment_type")
	@Schema(description = "The Payment Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Payment Type here] end
	private String paymentType;

	// % protected region % [Modify attribute annotation for Refund Amount here] off begin
	@CsvBindByName(column = "REFUND_AMOUNT", required = false)
	@Nullable
	@Column(name = "refund_amount")
	@Schema(description = "The Refund Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Refund Amount here] end
	private Double refundAmount;

	// % protected region % [Modify attribute annotation for Hospital Bank Account here] off begin
	@CsvBindByName(column = "HOSPITAL_BANK_ACCOUNT", required = false)
	@Nullable
	@Column(name = "hospital_bank_account")
	@Schema(description = "The Hospital Bank Account of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Bank Account here] end
	private String hospitalBankAccount;

	// % protected region % [Modify attribute annotation for Reference Number here] off begin
	@CsvBindByName(column = "REFERENCE_NUMBER", required = false)
	@Nullable
	@Column(name = "reference_number")
	@Schema(description = "The Reference Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Reference Number here] end
	private String referenceNumber;

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
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@NotNull(message = "Reference Patient General Info is required")
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
	public void setPatientGeneralInfo(@NotNull PatientGeneralInfoEntity entity) {
		setPatientGeneralInfo(entity, true);
	}

	/**
	 * Set or update the patientGeneralInfo in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInfo
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInfo(@NotNull PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInfo here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInfo here] end

		if (sameAsFormer(this.patientGeneralInfo, entity)) {
			return;
		}

		if (this.patientGeneralInfo != null) {
			this.patientGeneralInfo.removeCashRefunds(this, false);
		}
		this.patientGeneralInfo = entity;
		if (reverseAdd) {
			this.patientGeneralInfo.addCashRefunds(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInfo incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInfo incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientGeneralInfo(boolean)} but default to true.
	 */
	public void unsetPatientGeneralInfo() {
		this.unsetPatientGeneralInfo(true);
	}

	/**
	 * Remove Patient General Info in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientGeneralInfo(boolean reverse) {
		if (reverse && this.patientGeneralInfo != null) {
			this.patientGeneralInfo.removeCashRefunds(this, false);
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
		return "REFUND_NUMBER,REFUND_DATE,DESCRIPTION,CASHIER_LOCATION,ISVOID,VOID_DATE_TIME,PAYMENT_TYPE,REFUND_AMOUNT,HOSPITAL_BANK_ACCOUNT,REFERENCE_NUMBER,PATIENT_GENERAL_INFO_ID,ID";
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
	public boolean equals(Object cashRefund) {
		if (this == cashRefund) {
			return true;
		}
		if (cashRefund == null || this.getClass() != cashRefund.getClass()) {
			return false;
		}
		if (!super.equals(cashRefund)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		CashRefundEntity that = (CashRefundEntity) cashRefund;
		return
			Objects.equals(this.refundNumber, that.refundNumber) &&
			Objects.equals(
			     this.refundDate != null ? this.refundDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.refundDate != null ? that.refundDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.description, that.description) &&
			Objects.equals(this.cashierLocation, that.cashierLocation) &&
			Objects.equals(this.isvoid, that.isvoid) &&
			Objects.equals(
			     this.voidDateTime != null ? this.voidDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.voidDateTime != null ? that.voidDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.paymentType, that.paymentType) &&
			Objects.equals(this.refundAmount, that.refundAmount) &&
			Objects.equals(this.hospitalBankAccount, that.hospitalBankAccount) &&
			Objects.equals(this.referenceNumber, that.referenceNumber) &&
			Objects.equals(this.patientGeneralInfoId, that.patientGeneralInfoId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
