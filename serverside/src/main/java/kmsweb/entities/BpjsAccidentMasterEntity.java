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
import kmsweb.dtos.BpjsAccidentMasterEntityDto;
import kmsweb.entities.listeners.BpjsAccidentMasterEntityListener;
import kmsweb.serializers.BpjsAccidentMasterSerializer;
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
@EntityListeners({BpjsAccidentMasterEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsAccidentMasterSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsAccidentMasterEntity extends AbstractEntity {

	/**
	 * Takes a BpjsAccidentMasterEntityDto and converts it into a BpjsAccidentMasterEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsAccidentMasterEntityDto
	 */
	public BpjsAccidentMasterEntity(BpjsAccidentMasterEntityDto bpjsAccidentMasterEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsAccidentMasterEntityDto.getId() != null) {
			this.setId(bpjsAccidentMasterEntityDto.getId());
		}

		if (bpjsAccidentMasterEntityDto.getNosep() != null) {
			this.setNosep(bpjsAccidentMasterEntityDto.getNosep());
		}

		if (bpjsAccidentMasterEntityDto.getTglkejadian() != null) {
			this.setTglkejadian(bpjsAccidentMasterEntityDto.getTglkejadian());
		}

		if (bpjsAccidentMasterEntityDto.getPpkpelsep() != null) {
			this.setPpkpelsep(bpjsAccidentMasterEntityDto.getPpkpelsep());
		}

		if (bpjsAccidentMasterEntityDto.getKdprop() != null) {
			this.setKdprop(bpjsAccidentMasterEntityDto.getKdprop());
		}

		if (bpjsAccidentMasterEntityDto.getKdkab() != null) {
			this.setKdkab(bpjsAccidentMasterEntityDto.getKdkab());
		}

		if (bpjsAccidentMasterEntityDto.getKdkec() != null) {
			this.setKdkec(bpjsAccidentMasterEntityDto.getKdkec());
		}

		if (bpjsAccidentMasterEntityDto.getKetkejadian() != null) {
			this.setKetkejadian(bpjsAccidentMasterEntityDto.getKetkejadian());
		}

		if (bpjsAccidentMasterEntityDto.getNosepsuplesi() != null) {
			this.setNosepsuplesi(bpjsAccidentMasterEntityDto.getNosepsuplesi());
		}

		if (bpjsAccidentMasterEntityDto.getPatientPaymentBPJS() != null) {
			this.setPatientPaymentBPJS(bpjsAccidentMasterEntityDto.getPatientPaymentBPJS());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for noSEP here] off begin
	@CsvBindByName(column = "NOSEP", required = false)
	@Nullable
	@Column(name = "nosep")
	@Schema(description = "The noSEP of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for noSEP here] end
	private String nosep;

	// % protected region % [Modify attribute annotation for tglKejadian here] off begin
	@CsvBindByName(column = "TGLKEJADIAN", required = false)
	@Nullable
	@Column(name = "tglkejadian")
	@Schema(description = "The tglKejadian of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tglKejadian here] end
	private String tglkejadian;

	// % protected region % [Modify attribute annotation for ppkPelSEP here] off begin
	@CsvBindByName(column = "PPKPELSEP", required = false)
	@Nullable
	@Column(name = "ppkpelsep")
	@Schema(description = "The ppkPelSEP of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ppkPelSEP here] end
	private String ppkpelsep;

	// % protected region % [Modify attribute annotation for kdProp here] off begin
	@CsvBindByName(column = "KDPROP", required = false)
	@Nullable
	@Column(name = "kdprop")
	@Schema(description = "The kdProp of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdProp here] end
	private String kdprop;

	// % protected region % [Modify attribute annotation for kdKab here] off begin
	@CsvBindByName(column = "KDKAB", required = false)
	@Nullable
	@Column(name = "kdkab")
	@Schema(description = "The kdKab of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdKab here] end
	private String kdkab;

	// % protected region % [Modify attribute annotation for kdKec here] off begin
	@CsvBindByName(column = "KDKEC", required = false)
	@Nullable
	@Column(name = "kdkec")
	@Schema(description = "The kdKec of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdKec here] end
	private String kdkec;

	// % protected region % [Modify attribute annotation for ketKejadian here] off begin
	@CsvBindByName(column = "KETKEJADIAN", required = false)
	@Nullable
	@Column(name = "ketkejadian")
	@Schema(description = "The ketKejadian of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ketKejadian here] end
	private String ketkejadian;

	// % protected region % [Modify attribute annotation for noSEPSuplesi here] off begin
	@CsvBindByName(column = "NOSEPSUPLESI", required = false)
	@Nullable
	@Column(name = "nosepsuplesi")
	@Schema(description = "The noSEPSuplesi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for noSEPSuplesi here] end
	private String nosepsuplesi;

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
			this.patientPaymentBPJS.removeBpjsAccidentMasters(this, false);
		}
		this.patientPaymentBPJS = entity;
		if (reverseAdd) {
			this.patientPaymentBPJS.addBpjsAccidentMasters(this, false);
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
			this.patientPaymentBPJS.removeBpjsAccidentMasters(this, false);
		}
		this.patientPaymentBPJS = null;
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
		return "NOSEP,TGLKEJADIAN,PPKPELSEP,KDPROP,KDKAB,KDKEC,KETKEJADIAN,NOSEPSUPLESI,PATIENT_PAYMENT_BPJS_ID,ID";
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

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsAccidentMaster) {
		if (this == bpjsAccidentMaster) {
			return true;
		}
		if (bpjsAccidentMaster == null || this.getClass() != bpjsAccidentMaster.getClass()) {
			return false;
		}
		if (!super.equals(bpjsAccidentMaster)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsAccidentMasterEntity that = (BpjsAccidentMasterEntity) bpjsAccidentMaster;
		return
			Objects.equals(this.nosep, that.nosep) &&
			Objects.equals(this.tglkejadian, that.tglkejadian) &&
			Objects.equals(this.ppkpelsep, that.ppkpelsep) &&
			Objects.equals(this.kdprop, that.kdprop) &&
			Objects.equals(this.kdkab, that.kdkab) &&
			Objects.equals(this.kdkec, that.kdkec) &&
			Objects.equals(this.ketkejadian, that.ketkejadian) &&
			Objects.equals(this.nosepsuplesi, that.nosepsuplesi) &&
			Objects.equals(this.patientPaymentBPJSId, that.patientPaymentBPJSId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
