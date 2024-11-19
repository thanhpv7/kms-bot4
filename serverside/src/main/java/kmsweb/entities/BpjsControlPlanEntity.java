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
import kmsweb.dtos.BpjsControlPlanEntityDto;
import kmsweb.entities.listeners.BpjsControlPlanEntityListener;
import kmsweb.serializers.BpjsControlPlanSerializer;
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
@EntityListeners({BpjsControlPlanEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsControlPlanSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsControlPlanEntity extends AbstractEntity {

	/**
	 * Takes a BpjsControlPlanEntityDto and converts it into a BpjsControlPlanEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsControlPlanEntityDto
	 */
	public BpjsControlPlanEntity(BpjsControlPlanEntityDto bpjsControlPlanEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsControlPlanEntityDto.getId() != null) {
			this.setId(bpjsControlPlanEntityDto.getId());
		}

		if (bpjsControlPlanEntityDto.getNoSEP() != null) {
			this.setNoSEP(bpjsControlPlanEntityDto.getNoSEP());
		}

		if (bpjsControlPlanEntityDto.getControlLetterNo() != null) {
			this.setControlLetterNo(bpjsControlPlanEntityDto.getControlLetterNo());
		}

		if (bpjsControlPlanEntityDto.getControlPlanDate() != null) {
			this.setControlPlanDate(bpjsControlPlanEntityDto.getControlPlanDate());
		}

		if (bpjsControlPlanEntityDto.getBpjsCardNo() != null) {
			this.setBpjsCardNo(bpjsControlPlanEntityDto.getBpjsCardNo());
		}

		if (bpjsControlPlanEntityDto.getName() != null) {
			this.setName(bpjsControlPlanEntityDto.getName());
		}

		if (bpjsControlPlanEntityDto.getGender() != null) {
			this.setGender(bpjsControlPlanEntityDto.getGender());
		}

		if (bpjsControlPlanEntityDto.getDateOfBirth() != null) {
			this.setDateOfBirth(bpjsControlPlanEntityDto.getDateOfBirth());
		}

		if (bpjsControlPlanEntityDto.getDoctorCode() != null) {
			this.setDoctorCode(bpjsControlPlanEntityDto.getDoctorCode());
		}

		if (bpjsControlPlanEntityDto.getPolyclinicCode() != null) {
			this.setPolyclinicCode(bpjsControlPlanEntityDto.getPolyclinicCode());
		}

		if (bpjsControlPlanEntityDto.getBpjsDoctorMapping() != null) {
			this.setBpjsDoctorMapping(bpjsControlPlanEntityDto.getBpjsDoctorMapping());
		}

		if (bpjsControlPlanEntityDto.getBpjsServiceMapping() != null) {
			this.setBpjsServiceMapping(bpjsControlPlanEntityDto.getBpjsServiceMapping());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for No SEP here] off begin
	@CsvBindByName(column = "NO_SEP", required = false)
	@Nullable
	@Column(name = "no_sep")
	@Schema(description = "The No SEP of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for No SEP here] end
	private String noSEP;

	// % protected region % [Modify attribute annotation for Control Letter No here] off begin
	@CsvBindByName(column = "CONTROL_LETTER_NO", required = false)
	@Nullable
	@Column(name = "control_letter_no")
	@Schema(description = "The Control Letter No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Control Letter No here] end
	private String controlLetterNo;

	// % protected region % [Modify attribute annotation for Control Plan Date here] off begin
	@CsvBindByName(column = "CONTROL_PLAN_DATE", required = false)
	@Nullable
	@Column(name = "control_plan_date")
	@Schema(description = "The Control Plan Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Control Plan Date here] end
	private String controlPlanDate;

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

	// % protected region % [Modify attribute annotation for Gender here] off begin
	@CsvBindByName(column = "GENDER", required = false)
	@Nullable
	@Column(name = "gender")
	@Schema(description = "The Gender of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gender here] end
	private String gender;

	// % protected region % [Modify attribute annotation for Date Of Birth here] off begin
	@CsvBindByName(column = "DATE_OF_BIRTH", required = false)
	@Nullable
	@Column(name = "date_of_birth")
	@Schema(description = "The Date Of Birth of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Date Of Birth here] end
	private String dateOfBirth;

	// % protected region % [Modify attribute annotation for Doctor Code here] off begin
	@CsvBindByName(column = "DOCTOR_CODE", required = false)
	@Nullable
	@Column(name = "doctor_code")
	@Schema(description = "The Doctor Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor Code here] end
	private String doctorCode;

	// % protected region % [Modify attribute annotation for Polyclinic Code here] off begin
	@CsvBindByName(column = "POLYCLINIC_CODE", required = false)
	@Nullable
	@Column(name = "polyclinic_code")
	@Schema(description = "The Polyclinic Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Polyclinic Code here] end
	private String polyclinicCode;

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

	// % protected region % [Update the annotation for BPJS Service Mapping here] off begin
	@Schema(description = "The BPJS Service Mapping entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Service Mapping here] end
	private BpjsServiceMappingEntity bpjsServiceMapping;

	// % protected region % [Update the annotation for bpjsServiceMappingId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_SERVICE_MAPPING_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsServiceMappingId here] end
	private UUID bpjsServiceMappingId;

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
			this.bpjsDoctorMapping.removeBpjsControlPlans(this, false);
		}
		this.bpjsDoctorMapping = entity;
		if (reverseAdd) {
			this.bpjsDoctorMapping.addBpjsControlPlans(this, false);
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
			this.bpjsDoctorMapping.removeBpjsControlPlans(this, false);
		}
		this.bpjsDoctorMapping = null;
	}
	/**
	 * Similar to {@link this#setBpjsServiceMapping(BpjsServiceMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsServiceMappingEntity to be set to this entity
	 */
	public void setBpjsServiceMapping(@NotNull BpjsServiceMappingEntity entity) {
		setBpjsServiceMapping(entity, true);
	}

	/**
	 * Set or update the bpjsServiceMapping in this entity with single BpjsServiceMappingEntity.
	 *
	 * @param entity the given BpjsServiceMappingEntity to be set or updated to bpjsServiceMapping
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsServiceMapping(@NotNull BpjsServiceMappingEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsServiceMapping here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsServiceMapping here] end

		if (sameAsFormer(this.bpjsServiceMapping, entity)) {
			return;
		}

		if (this.bpjsServiceMapping != null) {
			this.bpjsServiceMapping.removeBpjsControlPlans(this, false);
		}
		this.bpjsServiceMapping = entity;
		if (reverseAdd) {
			this.bpjsServiceMapping.addBpjsControlPlans(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsServiceMapping incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsServiceMapping incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsServiceMapping(boolean)} but default to true.
	 */
	public void unsetBpjsServiceMapping() {
		this.unsetBpjsServiceMapping(true);
	}

	/**
	 * Remove BPJS Service Mapping in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsServiceMapping(boolean reverse) {
		if (reverse && this.bpjsServiceMapping != null) {
			this.bpjsServiceMapping.removeBpjsControlPlans(this, false);
		}
		this.bpjsServiceMapping = null;
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
		return "NO_SEP,CONTROL_LETTER_NO,CONTROL_PLAN_DATE,BPJS_CARD_NO,NAME,GENDER,DATE_OF_BIRTH,DOCTOR_CODE,POLYCLINIC_CODE,BPJS_DOCTOR_MAPPING_ID,BPJS_SERVICE_MAPPING_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<BpjsDoctorMappingEntity> bpjsDoctorMappingRelation = Optional.ofNullable(this.bpjsDoctorMapping);
		bpjsDoctorMappingRelation.ifPresent(entity -> this.bpjsDoctorMappingId = entity.getId());

		Optional<BpjsServiceMappingEntity> bpjsServiceMappingRelation = Optional.ofNullable(this.bpjsServiceMapping);
		bpjsServiceMappingRelation.ifPresent(entity -> this.bpjsServiceMappingId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsControlPlan) {
		if (this == bpjsControlPlan) {
			return true;
		}
		if (bpjsControlPlan == null || this.getClass() != bpjsControlPlan.getClass()) {
			return false;
		}
		if (!super.equals(bpjsControlPlan)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsControlPlanEntity that = (BpjsControlPlanEntity) bpjsControlPlan;
		return
			Objects.equals(this.noSEP, that.noSEP) &&
			Objects.equals(this.controlLetterNo, that.controlLetterNo) &&
			Objects.equals(this.controlPlanDate, that.controlPlanDate) &&
			Objects.equals(this.bpjsCardNo, that.bpjsCardNo) &&
			Objects.equals(this.name, that.name) &&
			Objects.equals(this.gender, that.gender) &&
			Objects.equals(this.dateOfBirth, that.dateOfBirth) &&
			Objects.equals(this.doctorCode, that.doctorCode) &&
			Objects.equals(this.polyclinicCode, that.polyclinicCode) &&
			Objects.equals(this.bpjsDoctorMappingId, that.bpjsDoctorMappingId) &&
			Objects.equals(this.bpjsServiceMappingId, that.bpjsServiceMappingId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
