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
import kmsweb.dtos.BpjsPRBEntityDto;
import kmsweb.entities.listeners.BpjsPRBEntityListener;
import kmsweb.serializers.BpjsPRBSerializer;
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
@EntityListeners({BpjsPRBEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsPRBSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsPRBEntity extends AbstractEntity {

	/**
	 * Takes a BpjsPRBEntityDto and converts it into a BpjsPRBEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsPRBEntityDto
	 */
	public BpjsPRBEntity(BpjsPRBEntityDto bpjsPRBEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsPRBEntityDto.getId() != null) {
			this.setId(bpjsPRBEntityDto.getId());
		}

		if (bpjsPRBEntityDto.getSrbNo() != null) {
			this.setSrbNo(bpjsPRBEntityDto.getSrbNo());
		}

		if (bpjsPRBEntityDto.getSepNo() != null) {
			this.setSepNo(bpjsPRBEntityDto.getSepNo());
		}

		if (bpjsPRBEntityDto.getBpjsCardNo() != null) {
			this.setBpjsCardNo(bpjsPRBEntityDto.getBpjsCardNo());
		}

		if (bpjsPRBEntityDto.getAddress() != null) {
			this.setAddress(bpjsPRBEntityDto.getAddress());
		}

		if (bpjsPRBEntityDto.getEmail() != null) {
			this.setEmail(bpjsPRBEntityDto.getEmail());
		}

		if (bpjsPRBEntityDto.getPrbProgramCode() != null) {
			this.setPrbProgramCode(bpjsPRBEntityDto.getPrbProgramCode());
		}

		if (bpjsPRBEntityDto.getPrbProgramName() != null) {
			this.setPrbProgramName(bpjsPRBEntityDto.getPrbProgramName());
		}

		if (bpjsPRBEntityDto.getDoctorCode() != null) {
			this.setDoctorCode(bpjsPRBEntityDto.getDoctorCode());
		}

		if (bpjsPRBEntityDto.getDoctorName() != null) {
			this.setDoctorName(bpjsPRBEntityDto.getDoctorName());
		}

		if (bpjsPRBEntityDto.getNotes() != null) {
			this.setNotes(bpjsPRBEntityDto.getNotes());
		}

		if (bpjsPRBEntityDto.getRecommendation() != null) {
			this.setRecommendation(bpjsPRBEntityDto.getRecommendation());
		}

		if (bpjsPRBEntityDto.getBpjsDiagnosePRB() != null) {
			this.setBpjsDiagnosePRB(bpjsPRBEntityDto.getBpjsDiagnosePRB());
		}

		if (bpjsPRBEntityDto.getBpjsDoctorMapping() != null) {
			this.setBpjsDoctorMapping(bpjsPRBEntityDto.getBpjsDoctorMapping());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for SRB No here] off begin
	@CsvBindByName(column = "SRB_NO", required = false)
	@Nullable
	@Column(name = "srb_no")
	@Schema(description = "The SRB No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SRB No here] end
	private String srbNo;

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

	// % protected region % [Modify attribute annotation for Address here] off begin
	@CsvBindByName(column = "ADDRESS", required = false)
	@Nullable
	@Column(name = "address")
	@Schema(description = "The Address of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Address here] end
	private String address;

	// % protected region % [Modify attribute annotation for Email here] off begin
	@CsvBindByName(column = "EMAIL", required = false)
	@Nullable
	@Column(name = "email")
	@Schema(description = "The Email of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

	// % protected region % [Modify attribute annotation for PRB Program Code here] off begin
	@CsvBindByName(column = "PRB_PROGRAM_CODE", required = false)
	@Nullable
	@Column(name = "prb_program_code")
	@Schema(description = "The PRB Program Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for PRB Program Code here] end
	private String prbProgramCode;

	// % protected region % [Modify attribute annotation for PRB Program Name here] off begin
	@CsvBindByName(column = "PRB_PROGRAM_NAME", required = false)
	@Nullable
	@Column(name = "prb_program_name")
	@Schema(description = "The PRB Program Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for PRB Program Name here] end
	private String prbProgramName;

	// % protected region % [Modify attribute annotation for Doctor Code here] off begin
	@CsvBindByName(column = "DOCTOR_CODE", required = false)
	@Nullable
	@Column(name = "doctor_code")
	@Schema(description = "The Doctor Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor Code here] end
	private String doctorCode;

	// % protected region % [Modify attribute annotation for Doctor Name here] off begin
	@CsvBindByName(column = "DOCTOR_NAME", required = false)
	@Nullable
	@Column(name = "doctor_name")
	@Schema(description = "The Doctor Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor Name here] end
	private String doctorName;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Recommendation here] off begin
	@CsvBindByName(column = "RECOMMENDATION", required = false)
	@Nullable
	@Column(name = "recommendation")
	@Schema(description = "The Recommendation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Recommendation here] end
	private String recommendation;

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

	// % protected region % [Update the annotation for BPJS Diagnose PRB here] off begin
	@Schema(description = "The BPJS Diagnose PRB entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Diagnose PRB here] end
	private BpjsDiagnosePRBEntity bpjsDiagnosePRB;

	// % protected region % [Update the annotation for bpjsDiagnosePRBId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_DIAGNOSE_PRB_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsDiagnosePRBId here] end
	private UUID bpjsDiagnosePRBId;

	// % protected region % [Update the annotation for BPJS Doctor Mapping here] off begin
	@Schema(description = "The BPJS Doctor Mapping entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Doctor Mapping here] end
	private BpjsDoctorMappingEntity bpjsDoctorMapping;

	// % protected region % [Update the annotation for bpjsDoctorMappingId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_DOCTOR_MAPPING_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsDoctorMappingId here] end
	private UUID bpjsDoctorMappingId;

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
	 * Similar to {@link this#setBpjsDiagnosePRB(BpjsDiagnosePRBEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDiagnosePRBEntity to be set to this entity
	 */
	public void setBpjsDiagnosePRB(@NotNull BpjsDiagnosePRBEntity entity) {
		setBpjsDiagnosePRB(entity, true);
	}

	/**
	 * Set or update the bpjsDiagnosePRB in this entity with single BpjsDiagnosePRBEntity.
	 *
	 * @param entity the given BpjsDiagnosePRBEntity to be set or updated to bpjsDiagnosePRB
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsDiagnosePRB(@NotNull BpjsDiagnosePRBEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsDiagnosePRB here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsDiagnosePRB here] end

		if (sameAsFormer(this.bpjsDiagnosePRB, entity)) {
			return;
		}

		if (this.bpjsDiagnosePRB != null) {
			this.bpjsDiagnosePRB.removeBpjsPRBs(this, false);
		}
		this.bpjsDiagnosePRB = entity;
		if (reverseAdd) {
			this.bpjsDiagnosePRB.addBpjsPRBs(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsDiagnosePRB incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsDiagnosePRB incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsDiagnosePRB(boolean)} but default to true.
	 */
	public void unsetBpjsDiagnosePRB() {
		this.unsetBpjsDiagnosePRB(true);
	}

	/**
	 * Remove BPJS Diagnose PRB in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsDiagnosePRB(boolean reverse) {
		if (reverse && this.bpjsDiagnosePRB != null) {
			this.bpjsDiagnosePRB.removeBpjsPRBs(this, false);
		}
		this.bpjsDiagnosePRB = null;
	}
	/**
	 * Similar to {@link this#setBpjsDoctorMapping(BpjsDoctorMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDoctorMappingEntity to be set to this entity
	 */
	public void setBpjsDoctorMapping(@NotNull BpjsDoctorMappingEntity entity) {
		setBpjsDoctorMapping(entity, true);
	}

	/**
	 * Set or update the bpjsDoctorMapping in this entity with single BpjsDoctorMappingEntity.
	 *
	 * @param entity the given BpjsDoctorMappingEntity to be set or updated to bpjsDoctorMapping
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsDoctorMapping(@NotNull BpjsDoctorMappingEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsDoctorMapping here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsDoctorMapping here] end

		if (sameAsFormer(this.bpjsDoctorMapping, entity)) {
			return;
		}

		if (this.bpjsDoctorMapping != null) {
			this.bpjsDoctorMapping.removeBpjsPRBs(this, false);
		}
		this.bpjsDoctorMapping = entity;
		if (reverseAdd) {
			this.bpjsDoctorMapping.addBpjsPRBs(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsDoctorMapping incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsDoctorMapping incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsDoctorMapping(boolean)} but default to true.
	 */
	public void unsetBpjsDoctorMapping() {
		this.unsetBpjsDoctorMapping(true);
	}

	/**
	 * Remove BPJS Doctor Mapping in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsDoctorMapping(boolean reverse) {
		if (reverse && this.bpjsDoctorMapping != null) {
			this.bpjsDoctorMapping.removeBpjsPRBs(this, false);
		}
		this.bpjsDoctorMapping = null;
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
		return "SRB_NO,SEP_NO,BPJS_CARD_NO,ADDRESS,EMAIL,PRB_PROGRAM_CODE,PRB_PROGRAM_NAME,DOCTOR_CODE,DOCTOR_NAME,NOTES,RECOMMENDATION,BPJS_DIAGNOSE_PRB_ID,BPJS_DOCTOR_MAPPING_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<BpjsDiagnosePRBEntity> bpjsDiagnosePRBRelation = Optional.ofNullable(this.bpjsDiagnosePRB);
		bpjsDiagnosePRBRelation.ifPresent(entity -> this.bpjsDiagnosePRBId = entity.getId());

		Optional<BpjsDoctorMappingEntity> bpjsDoctorMappingRelation = Optional.ofNullable(this.bpjsDoctorMapping);
		bpjsDoctorMappingRelation.ifPresent(entity -> this.bpjsDoctorMappingId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsPRB) {
		if (this == bpjsPRB) {
			return true;
		}
		if (bpjsPRB == null || this.getClass() != bpjsPRB.getClass()) {
			return false;
		}
		if (!super.equals(bpjsPRB)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsPRBEntity that = (BpjsPRBEntity) bpjsPRB;
		return
			Objects.equals(this.srbNo, that.srbNo) &&
			Objects.equals(this.sepNo, that.sepNo) &&
			Objects.equals(this.bpjsCardNo, that.bpjsCardNo) &&
			Objects.equals(this.address, that.address) &&
			Objects.equals(this.email, that.email) &&
			Objects.equals(this.prbProgramCode, that.prbProgramCode) &&
			Objects.equals(this.prbProgramName, that.prbProgramName) &&
			Objects.equals(this.doctorCode, that.doctorCode) &&
			Objects.equals(this.doctorName, that.doctorName) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.recommendation, that.recommendation) &&
			Objects.equals(this.bpjsDiagnosePRBId, that.bpjsDiagnosePRBId) &&
			Objects.equals(this.bpjsDoctorMappingId, that.bpjsDoctorMappingId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
