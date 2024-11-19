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
import kmsweb.dtos.BpjsHospitalizationPlanEntityDto;
import kmsweb.entities.listeners.BpjsHospitalizationPlanEntityListener;
import kmsweb.serializers.BpjsHospitalizationPlanSerializer;
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
@EntityListeners({BpjsHospitalizationPlanEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsHospitalizationPlanSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsHospitalizationPlanEntity extends AbstractEntity {

	/**
	 * Takes a BpjsHospitalizationPlanEntityDto and converts it into a BpjsHospitalizationPlanEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsHospitalizationPlanEntityDto
	 */
	public BpjsHospitalizationPlanEntity(BpjsHospitalizationPlanEntityDto bpjsHospitalizationPlanEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsHospitalizationPlanEntityDto.getId() != null) {
			this.setId(bpjsHospitalizationPlanEntityDto.getId());
		}

		if (bpjsHospitalizationPlanEntityDto.getNokartu() != null) {
			this.setNokartu(bpjsHospitalizationPlanEntityDto.getNokartu());
		}

		if (bpjsHospitalizationPlanEntityDto.getTglrencanakontrol() != null) {
			this.setTglrencanakontrol(bpjsHospitalizationPlanEntityDto.getTglrencanakontrol());
		}

		if (bpjsHospitalizationPlanEntityDto.getNospri() != null) {
			this.setNospri(bpjsHospitalizationPlanEntityDto.getNospri());
		}

		if (bpjsHospitalizationPlanEntityDto.getDiagnosa() != null) {
			this.setDiagnosa(bpjsHospitalizationPlanEntityDto.getDiagnosa());
		}

		if (bpjsHospitalizationPlanEntityDto.getPatientPaymentBPJS() != null) {
			this.setPatientPaymentBPJS(bpjsHospitalizationPlanEntityDto.getPatientPaymentBPJS());
		}

		if (bpjsHospitalizationPlanEntityDto.getBpjsDoctorMapping() != null) {
			this.setBpjsDoctorMapping(bpjsHospitalizationPlanEntityDto.getBpjsDoctorMapping());
		}

		if (bpjsHospitalizationPlanEntityDto.getBpjsServiceMapping() != null) {
			this.setBpjsServiceMapping(bpjsHospitalizationPlanEntityDto.getBpjsServiceMapping());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for noKartu here] off begin
	@CsvBindByName(column = "NOKARTU", required = false)
	@Nullable
	@Column(name = "nokartu")
	@Schema(description = "The noKartu of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for noKartu here] end
	private String nokartu;

	// % protected region % [Modify attribute annotation for tglRencanaKontrol here] off begin
	@CsvCustomBindByName(column = "TGLRENCANAKONTROL", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "tglrencanakontrol")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The tglRencanaKontrol of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tglRencanaKontrol here] end
	private OffsetDateTime tglrencanakontrol;

	// % protected region % [Modify attribute annotation for noSPRI here] off begin
	@CsvBindByName(column = "NOSPRI", required = false)
	@Nullable
	@Column(name = "nospri")
	@Schema(description = "The noSPRI of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for noSPRI here] end
	private String nospri;

	// % protected region % [Modify attribute annotation for diagnosa here] off begin
	@CsvBindByName(column = "DIAGNOSA", required = false)
	@Nullable
	@Column(name = "diagnosa")
	@Schema(description = "The diagnosa of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for diagnosa here] end
	private String diagnosa;

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

	// % protected region % [Update the annotation for Patient Payment BPJS here] off begin
	@Schema(description = "The Patient Payment BPJS entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Payment BPJS here] end
	private PatientPaymentBPJSEntity patientPaymentBPJS;

	// % protected region % [Update the annotation for patientPaymentBPJSId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_PAYMENT_BPJS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientPaymentBPJSId here] end
	private UUID patientPaymentBPJSId;

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
	 * Similar to {@link this#setPatientPaymentBPJS(PatientPaymentBPJSEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientPaymentBPJSEntity to be set to this entity
	 */
	public void setPatientPaymentBPJS(@NotNull PatientPaymentBPJSEntity entity) {
		setPatientPaymentBPJS(entity, true);
	}

	/**
	 * Set or update the patientPaymentBPJS in this entity with single PatientPaymentBPJSEntity.
	 *
	 * @param entity the given PatientPaymentBPJSEntity to be set or updated to patientPaymentBPJS
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientPaymentBPJS(@NotNull PatientPaymentBPJSEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentBPJS here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentBPJS here] end

		if (sameAsFormer(this.patientPaymentBPJS, entity)) {
			return;
		}

		if (this.patientPaymentBPJS != null) {
			this.patientPaymentBPJS.removeBpjsHospitalizationPlans(this, false);
		}
		this.patientPaymentBPJS = entity;
		if (reverseAdd) {
			this.patientPaymentBPJS.addBpjsHospitalizationPlans(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentBPJS incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentBPJS incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientPaymentBPJS(boolean)} but default to true.
	 */
	public void unsetPatientPaymentBPJS() {
		this.unsetPatientPaymentBPJS(true);
	}

	/**
	 * Remove Patient Payment BPJS in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientPaymentBPJS(boolean reverse) {
		if (reverse && this.patientPaymentBPJS != null) {
			this.patientPaymentBPJS.removeBpjsHospitalizationPlans(this, false);
		}
		this.patientPaymentBPJS = null;
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
			this.bpjsDoctorMapping.removeKodedokter(this, false);
		}
		this.bpjsDoctorMapping = entity;
		if (reverseAdd) {
			this.bpjsDoctorMapping.addKodedokter(this, false);
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
			this.bpjsDoctorMapping.removeKodedokter(this, false);
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
			this.bpjsServiceMapping.removePolikontrol(this, false);
		}
		this.bpjsServiceMapping = entity;
		if (reverseAdd) {
			this.bpjsServiceMapping.addPolikontrol(this, false);
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
			this.bpjsServiceMapping.removePolikontrol(this, false);
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
		return "NOKARTU,TGLRENCANAKONTROL,NOSPRI,DIAGNOSA,PATIENT_PAYMENT_BPJS_ID,BPJS_DOCTOR_MAPPING_ID,BPJS_SERVICE_MAPPING_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<PatientPaymentBPJSEntity> patientPaymentBPJSRelation = Optional.ofNullable(this.patientPaymentBPJS);
		patientPaymentBPJSRelation.ifPresent(entity -> this.patientPaymentBPJSId = entity.getId());

		Optional<BpjsDoctorMappingEntity> bpjsDoctorMappingRelation = Optional.ofNullable(this.bpjsDoctorMapping);
		bpjsDoctorMappingRelation.ifPresent(entity -> this.bpjsDoctorMappingId = entity.getId());

		Optional<BpjsServiceMappingEntity> bpjsServiceMappingRelation = Optional.ofNullable(this.bpjsServiceMapping);
		bpjsServiceMappingRelation.ifPresent(entity -> this.bpjsServiceMappingId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsHospitalizationPlan) {
		if (this == bpjsHospitalizationPlan) {
			return true;
		}
		if (bpjsHospitalizationPlan == null || this.getClass() != bpjsHospitalizationPlan.getClass()) {
			return false;
		}
		if (!super.equals(bpjsHospitalizationPlan)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsHospitalizationPlanEntity that = (BpjsHospitalizationPlanEntity) bpjsHospitalizationPlan;
		return
			Objects.equals(this.nokartu, that.nokartu) &&
			Objects.equals(
			     this.tglrencanakontrol != null ? this.tglrencanakontrol.truncatedTo(ChronoUnit.DAYS) : null,
			     that.tglrencanakontrol != null ? that.tglrencanakontrol.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.nospri, that.nospri) &&
			Objects.equals(this.diagnosa, that.diagnosa) &&
			Objects.equals(this.patientPaymentBPJSId, that.patientPaymentBPJSId) &&
			Objects.equals(this.bpjsDoctorMappingId, that.bpjsDoctorMappingId) &&
			Objects.equals(this.bpjsServiceMappingId, that.bpjsServiceMappingId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
