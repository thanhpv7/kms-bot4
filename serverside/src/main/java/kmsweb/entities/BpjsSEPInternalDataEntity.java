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
import kmsweb.dtos.BpjsSEPInternalDataEntityDto;
import kmsweb.entities.listeners.BpjsSEPInternalDataEntityListener;
import kmsweb.serializers.BpjsSEPInternalDataSerializer;
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
@EntityListeners({BpjsSEPInternalDataEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsSEPInternalDataSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsSEPInternalDataEntity extends AbstractEntity {

	/**
	 * Takes a BpjsSEPInternalDataEntityDto and converts it into a BpjsSEPInternalDataEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsSEPInternalDataEntityDto
	 */
	public BpjsSEPInternalDataEntity(BpjsSEPInternalDataEntityDto bpjsSEPInternalDataEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsSEPInternalDataEntityDto.getId() != null) {
			this.setId(bpjsSEPInternalDataEntityDto.getId());
		}

		if (bpjsSEPInternalDataEntityDto.getReferredPolyclinic() != null) {
			this.setReferredPolyclinic(bpjsSEPInternalDataEntityDto.getReferredPolyclinic());
		}

		if (bpjsSEPInternalDataEntityDto.getReferringPolyclinic() != null) {
			this.setReferringPolyclinic(bpjsSEPInternalDataEntityDto.getReferringPolyclinic());
		}

		if (bpjsSEPInternalDataEntityDto.getInternalReferralDate() != null) {
			this.setInternalReferralDate(bpjsSEPInternalDataEntityDto.getInternalReferralDate());
		}

		if (bpjsSEPInternalDataEntityDto.getSepNo() != null) {
			this.setSepNo(bpjsSEPInternalDataEntityDto.getSepNo());
		}

		if (bpjsSEPInternalDataEntityDto.getRefSEPNo() != null) {
			this.setRefSEPNo(bpjsSEPInternalDataEntityDto.getRefSEPNo());
		}

		if (bpjsSEPInternalDataEntityDto.getSepHealthFacility() != null) {
			this.setSepHealthFacility(bpjsSEPInternalDataEntityDto.getSepHealthFacility());
		}

		if (bpjsSEPInternalDataEntityDto.getBpjsCardNo() != null) {
			this.setBpjsCardNo(bpjsSEPInternalDataEntityDto.getBpjsCardNo());
		}

		if (bpjsSEPInternalDataEntityDto.getSepDate() != null) {
			this.setSepDate(bpjsSEPInternalDataEntityDto.getSepDate());
		}

		if (bpjsSEPInternalDataEntityDto.getLetterNo() != null) {
			this.setLetterNo(bpjsSEPInternalDataEntityDto.getLetterNo());
		}

		if (bpjsSEPInternalDataEntityDto.getIsInternal() != null) {
			this.setIsInternal(bpjsSEPInternalDataEntityDto.getIsInternal());
		}

		if (bpjsSEPInternalDataEntityDto.getReferringPolyclinicCode() != null) {
			this.setReferringPolyclinicCode(bpjsSEPInternalDataEntityDto.getReferringPolyclinicCode());
		}

		if (bpjsSEPInternalDataEntityDto.getDiagnosticSupport() != null) {
			this.setDiagnosticSupport(bpjsSEPInternalDataEntityDto.getDiagnosticSupport());
		}

		if (bpjsSEPInternalDataEntityDto.getReferringDiagnose() != null) {
			this.setReferringDiagnose(bpjsSEPInternalDataEntityDto.getReferringDiagnose());
		}

		if (bpjsSEPInternalDataEntityDto.getDoctor() != null) {
			this.setDoctor(bpjsSEPInternalDataEntityDto.getDoctor());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Referred Polyclinic here] off begin
	@CsvBindByName(column = "REFERRED_POLYCLINIC", required = false)
	@Nullable
	@Column(name = "referred_polyclinic")
	@Schema(description = "The Referred Polyclinic of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referred Polyclinic here] end
	private String referredPolyclinic;

	// % protected region % [Modify attribute annotation for Referring Polyclinic here] off begin
	@CsvBindByName(column = "REFERRING_POLYCLINIC", required = false)
	@Nullable
	@Column(name = "referring_polyclinic")
	@Schema(description = "The Referring Polyclinic of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referring Polyclinic here] end
	private String referringPolyclinic;

	// % protected region % [Modify attribute annotation for Internal Referral Date here] off begin
	@CsvBindByName(column = "INTERNAL_REFERRAL_DATE", required = false)
	@Nullable
	@Column(name = "internal_referral_date")
	@Schema(description = "The Internal Referral Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Internal Referral Date here] end
	private String internalReferralDate;

	// % protected region % [Modify attribute annotation for SEP No here] off begin
	@CsvBindByName(column = "SEP_NO", required = false)
	@Nullable
	@Column(name = "sep_no")
	@Schema(description = "The SEP No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SEP No here] end
	private String sepNo;

	// % protected region % [Modify attribute annotation for Ref SEP No here] off begin
	@CsvBindByName(column = "REF_SEP_NO", required = false)
	@Nullable
	@Column(name = "ref_sep_no")
	@Schema(description = "The Ref SEP No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ref SEP No here] end
	private String refSEPNo;

	// % protected region % [Modify attribute annotation for SEP Health Facility here] off begin
	@CsvBindByName(column = "SEP_HEALTH_FACILITY", required = false)
	@Nullable
	@Column(name = "sep_health_facility")
	@Schema(description = "The SEP Health Facility of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SEP Health Facility here] end
	private String sepHealthFacility;

	// % protected region % [Modify attribute annotation for BPJS Card No here] off begin
	@CsvBindByName(column = "BPJS_CARD_NO", required = false)
	@Nullable
	@Column(name = "bpjs_card_no")
	@Schema(description = "The BPJS Card No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BPJS Card No here] end
	private String bpjsCardNo;

	// % protected region % [Modify attribute annotation for SEP Date here] off begin
	@CsvBindByName(column = "SEP_DATE", required = false)
	@Nullable
	@Column(name = "sep_date")
	@Schema(description = "The SEP Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SEP Date here] end
	private String sepDate;

	// % protected region % [Modify attribute annotation for Letter No here] off begin
	@CsvBindByName(column = "LETTER_NO", required = false)
	@Nullable
	@Column(name = "letter_no")
	@Schema(description = "The Letter No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Letter No here] end
	private String letterNo;

	// % protected region % [Modify attribute annotation for Is Internal here] off begin
	@CsvBindByName(column = "IS_INTERNAL", required = false)
	@Nullable
	@Column(name = "is_internal")
	@Schema(description = "The Is Internal of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Internal here] end
	private String isInternal;

	// % protected region % [Modify attribute annotation for Referring Polyclinic Code here] off begin
	@CsvBindByName(column = "REFERRING_POLYCLINIC_CODE", required = false)
	@Nullable
	@Column(name = "referring_polyclinic_code")
	@Schema(description = "The Referring Polyclinic Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referring Polyclinic Code here] end
	private String referringPolyclinicCode;

	// % protected region % [Modify attribute annotation for Diagnostic Support here] off begin
	@CsvBindByName(column = "DIAGNOSTIC_SUPPORT", required = false)
	@Nullable
	@Column(name = "diagnostic_support")
	@Schema(description = "The Diagnostic Support of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diagnostic Support here] end
	private String diagnosticSupport;

	// % protected region % [Modify attribute annotation for Referring Diagnose here] off begin
	@CsvBindByName(column = "REFERRING_DIAGNOSE", required = false)
	@Nullable
	@Column(name = "referring_diagnose")
	@Schema(description = "The Referring Diagnose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referring Diagnose here] end
	private String referringDiagnose;

	// % protected region % [Modify attribute annotation for Doctor here] off begin
	@CsvBindByName(column = "DOCTOR", required = false)
	@Nullable
	@Column(name = "doctor")
	@Schema(description = "The Doctor of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor here] end
	private String doctor;

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
		return "REFERRED_POLYCLINIC,REFERRING_POLYCLINIC,INTERNAL_REFERRAL_DATE,SEP_NO,REF_SEP_NO,SEP_HEALTH_FACILITY,BPJS_CARD_NO,SEP_DATE,LETTER_NO,IS_INTERNAL,REFERRING_POLYCLINIC_CODE,DIAGNOSTIC_SUPPORT,REFERRING_DIAGNOSE,DOCTOR,ID";
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
	public boolean equals(Object bpjsSEPInternalData) {
		if (this == bpjsSEPInternalData) {
			return true;
		}
		if (bpjsSEPInternalData == null || this.getClass() != bpjsSEPInternalData.getClass()) {
			return false;
		}
		if (!super.equals(bpjsSEPInternalData)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsSEPInternalDataEntity that = (BpjsSEPInternalDataEntity) bpjsSEPInternalData;
		return
			Objects.equals(this.referredPolyclinic, that.referredPolyclinic) &&
			Objects.equals(this.referringPolyclinic, that.referringPolyclinic) &&
			Objects.equals(this.internalReferralDate, that.internalReferralDate) &&
			Objects.equals(this.sepNo, that.sepNo) &&
			Objects.equals(this.refSEPNo, that.refSEPNo) &&
			Objects.equals(this.sepHealthFacility, that.sepHealthFacility) &&
			Objects.equals(this.bpjsCardNo, that.bpjsCardNo) &&
			Objects.equals(this.sepDate, that.sepDate) &&
			Objects.equals(this.letterNo, that.letterNo) &&
			Objects.equals(this.isInternal, that.isInternal) &&
			Objects.equals(this.referringPolyclinicCode, that.referringPolyclinicCode) &&
			Objects.equals(this.diagnosticSupport, that.diagnosticSupport) &&
			Objects.equals(this.referringDiagnose, that.referringDiagnose) &&
			Objects.equals(this.doctor, that.doctor);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
