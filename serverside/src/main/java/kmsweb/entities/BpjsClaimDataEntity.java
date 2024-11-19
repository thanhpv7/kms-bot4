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
import kmsweb.dtos.BpjsClaimDataEntityDto;
import kmsweb.entities.listeners.BpjsClaimDataEntityListener;
import kmsweb.serializers.BpjsClaimDataSerializer;
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
@EntityListeners({BpjsClaimDataEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsClaimDataSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsClaimDataEntity extends AbstractEntity {

	/**
	 * Takes a BpjsClaimDataEntityDto and converts it into a BpjsClaimDataEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsClaimDataEntityDto
	 */
	public BpjsClaimDataEntity(BpjsClaimDataEntityDto bpjsClaimDataEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsClaimDataEntityDto.getId() != null) {
			this.setId(bpjsClaimDataEntityDto.getId());
		}

		if (bpjsClaimDataEntityDto.getInacbgCode() != null) {
			this.setInacbgCode(bpjsClaimDataEntityDto.getInacbgCode());
		}

		if (bpjsClaimDataEntityDto.getInacbgName() != null) {
			this.setInacbgName(bpjsClaimDataEntityDto.getInacbgName());
		}

		if (bpjsClaimDataEntityDto.getSubmittedTariff() != null) {
			this.setSubmittedTariff(bpjsClaimDataEntityDto.getSubmittedTariff());
		}

		if (bpjsClaimDataEntityDto.getApproval() != null) {
			this.setApproval(bpjsClaimDataEntityDto.getApproval());
		}

		if (bpjsClaimDataEntityDto.getGrouperTariff() != null) {
			this.setGrouperTariff(bpjsClaimDataEntityDto.getGrouperTariff());
		}

		if (bpjsClaimDataEntityDto.getHospitalTariff() != null) {
			this.setHospitalTariff(bpjsClaimDataEntityDto.getHospitalTariff());
		}

		if (bpjsClaimDataEntityDto.getTopUp() != null) {
			this.setTopUp(bpjsClaimDataEntityDto.getTopUp());
		}

		if (bpjsClaimDataEntityDto.getTreatmentClass() != null) {
			this.setTreatmentClass(bpjsClaimDataEntityDto.getTreatmentClass());
		}

		if (bpjsClaimDataEntityDto.getFpkNo() != null) {
			this.setFpkNo(bpjsClaimDataEntityDto.getFpkNo());
		}

		if (bpjsClaimDataEntityDto.getSepNo() != null) {
			this.setSepNo(bpjsClaimDataEntityDto.getSepNo());
		}

		if (bpjsClaimDataEntityDto.getName() != null) {
			this.setName(bpjsClaimDataEntityDto.getName());
		}

		if (bpjsClaimDataEntityDto.getBpjsCardNo() != null) {
			this.setBpjsCardNo(bpjsClaimDataEntityDto.getBpjsCardNo());
		}

		if (bpjsClaimDataEntityDto.getPatientID() != null) {
			this.setPatientID(bpjsClaimDataEntityDto.getPatientID());
		}

		if (bpjsClaimDataEntityDto.getPolyclinic() != null) {
			this.setPolyclinic(bpjsClaimDataEntityDto.getPolyclinic());
		}

		if (bpjsClaimDataEntityDto.getStatus() != null) {
			this.setStatus(bpjsClaimDataEntityDto.getStatus());
		}

		if (bpjsClaimDataEntityDto.getDismissalDate() != null) {
			this.setDismissalDate(bpjsClaimDataEntityDto.getDismissalDate());
		}

		if (bpjsClaimDataEntityDto.getSepDate() != null) {
			this.setSepDate(bpjsClaimDataEntityDto.getSepDate());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for INACBG Code here] off begin
	@CsvBindByName(column = "INACBG_CODE", required = false)
	@Nullable
	@Column(name = "inacbg_code")
	@Schema(description = "The INACBG Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for INACBG Code here] end
	private String inacbgCode;

	// % protected region % [Modify attribute annotation for INACBG Name here] off begin
	@CsvBindByName(column = "INACBG_NAME", required = false)
	@Nullable
	@Column(name = "inacbg_name")
	@Schema(description = "The INACBG Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for INACBG Name here] end
	private String inacbgName;

	// % protected region % [Modify attribute annotation for Submitted Tariff here] off begin
	@CsvBindByName(column = "SUBMITTED_TARIFF", required = false)
	@Nullable
	@Column(name = "submitted_tariff")
	@Schema(description = "The Submitted Tariff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Submitted Tariff here] end
	private String submittedTariff;

	// % protected region % [Modify attribute annotation for Approval here] off begin
	@CsvBindByName(column = "APPROVAL", required = false)
	@Nullable
	@Column(name = "approval")
	@Schema(description = "The Approval of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Approval here] end
	private String approval;

	// % protected region % [Modify attribute annotation for Grouper Tariff here] off begin
	@CsvBindByName(column = "GROUPER_TARIFF", required = false)
	@Nullable
	@Column(name = "grouper_tariff")
	@Schema(description = "The Grouper Tariff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Grouper Tariff here] end
	private String grouperTariff;

	// % protected region % [Modify attribute annotation for Hospital Tariff here] off begin
	@CsvBindByName(column = "HOSPITAL_TARIFF", required = false)
	@Nullable
	@Column(name = "hospital_tariff")
	@Schema(description = "The Hospital Tariff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Tariff here] end
	private String hospitalTariff;

	// % protected region % [Modify attribute annotation for Top Up here] off begin
	@CsvBindByName(column = "TOP_UP", required = false)
	@Nullable
	@Column(name = "top_up")
	@Schema(description = "The Top Up of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Top Up here] end
	private String topUp;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@CsvBindByName(column = "TREATMENT_CLASS", required = false)
	@Nullable
	@Column(name = "treatment_class")
	@Schema(description = "The Treatment Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for FPK No here] off begin
	@CsvBindByName(column = "FPK_NO", required = false)
	@Nullable
	@Column(name = "fpk_no")
	@Schema(description = "The FPK No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for FPK No here] end
	private String fpkNo;

	// % protected region % [Modify attribute annotation for SEP No here] off begin
	@CsvBindByName(column = "SEP_NO", required = false)
	@Nullable
	@Column(name = "sep_no")
	@Schema(description = "The SEP No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SEP No here] end
	private String sepNo;

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

	// % protected region % [Modify attribute annotation for Patient ID here] off begin
	@CsvBindByName(column = "PATIENT_ID", required = false)
	@Nullable
	@Column(name = "patient_id")
	@Schema(description = "The Patient ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient ID here] end
	private String patientID;

	// % protected region % [Modify attribute annotation for Polyclinic here] off begin
	@CsvBindByName(column = "POLYCLINIC", required = false)
	@Nullable
	@Column(name = "polyclinic")
	@Schema(description = "The Polyclinic of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Polyclinic here] end
	private String polyclinic;

	// % protected region % [Modify attribute annotation for Status here] off begin
	@CsvBindByName(column = "STATUS", required = false)
	@Nullable
	@Column(name = "status")
	@Schema(description = "The Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Status here] end
	private String status;

	// % protected region % [Modify attribute annotation for Dismissal Date here] off begin
	@CsvCustomBindByName(column = "DISMISSAL_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "dismissal_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Dismissal Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dismissal Date here] end
	private OffsetDateTime dismissalDate;

	// % protected region % [Modify attribute annotation for SEP Date here] off begin
	@CsvCustomBindByName(column = "SEP_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "sep_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The SEP Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SEP Date here] end
	private OffsetDateTime sepDate;

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
		return "INACBG_CODE,INACBG_NAME,SUBMITTED_TARIFF,APPROVAL,GROUPER_TARIFF,HOSPITAL_TARIFF,TOP_UP,TREATMENT_CLASS,FPK_NO,SEP_NO,NAME,BPJS_CARD_NO,PATIENT_ID,POLYCLINIC,STATUS,DISMISSAL_DATE,SEP_DATE,ID";
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
	public boolean equals(Object bpjsClaimData) {
		if (this == bpjsClaimData) {
			return true;
		}
		if (bpjsClaimData == null || this.getClass() != bpjsClaimData.getClass()) {
			return false;
		}
		if (!super.equals(bpjsClaimData)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsClaimDataEntity that = (BpjsClaimDataEntity) bpjsClaimData;
		return
			Objects.equals(this.inacbgCode, that.inacbgCode) &&
			Objects.equals(this.inacbgName, that.inacbgName) &&
			Objects.equals(this.submittedTariff, that.submittedTariff) &&
			Objects.equals(this.approval, that.approval) &&
			Objects.equals(this.grouperTariff, that.grouperTariff) &&
			Objects.equals(this.hospitalTariff, that.hospitalTariff) &&
			Objects.equals(this.topUp, that.topUp) &&
			Objects.equals(this.treatmentClass, that.treatmentClass) &&
			Objects.equals(this.fpkNo, that.fpkNo) &&
			Objects.equals(this.sepNo, that.sepNo) &&
			Objects.equals(this.name, that.name) &&
			Objects.equals(this.bpjsCardNo, that.bpjsCardNo) &&
			Objects.equals(this.patientID, that.patientID) &&
			Objects.equals(this.polyclinic, that.polyclinic) &&
			Objects.equals(this.status, that.status) &&
			Objects.equals(
			     this.dismissalDate != null ? this.dismissalDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.dismissalDate != null ? that.dismissalDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.sepDate != null ? this.sepDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.sepDate != null ? that.sepDate.truncatedTo(ChronoUnit.DAYS) : null
			     );
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
