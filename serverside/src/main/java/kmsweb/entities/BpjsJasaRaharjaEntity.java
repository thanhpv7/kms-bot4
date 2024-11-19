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
import kmsweb.dtos.BpjsJasaRaharjaEntityDto;
import kmsweb.entities.listeners.BpjsJasaRaharjaEntityListener;
import kmsweb.serializers.BpjsJasaRaharjaSerializer;
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
@EntityListeners({BpjsJasaRaharjaEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsJasaRaharjaSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsJasaRaharjaEntity extends AbstractEntity {

	/**
	 * Takes a BpjsJasaRaharjaEntityDto and converts it into a BpjsJasaRaharjaEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsJasaRaharjaEntityDto
	 */
	public BpjsJasaRaharjaEntity(BpjsJasaRaharjaEntityDto bpjsJasaRaharjaEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsJasaRaharjaEntityDto.getId() != null) {
			this.setId(bpjsJasaRaharjaEntityDto.getId());
		}

		if (bpjsJasaRaharjaEntityDto.getInitialSEPNo() != null) {
			this.setInitialSEPNo(bpjsJasaRaharjaEntityDto.getInitialSEPNo());
		}

		if (bpjsJasaRaharjaEntityDto.getGuaranteeLetterNo() != null) {
			this.setGuaranteeLetterNo(bpjsJasaRaharjaEntityDto.getGuaranteeLetterNo());
		}

		if (bpjsJasaRaharjaEntityDto.getIncidentDate() != null) {
			this.setIncidentDate(bpjsJasaRaharjaEntityDto.getIncidentDate());
		}

		if (bpjsJasaRaharjaEntityDto.getRegistrationNo() != null) {
			this.setRegistrationNo(bpjsJasaRaharjaEntityDto.getRegistrationNo());
		}

		if (bpjsJasaRaharjaEntityDto.getNoSEPSuplesi() != null) {
			this.setNoSEPSuplesi(bpjsJasaRaharjaEntityDto.getNoSEPSuplesi());
		}

		if (bpjsJasaRaharjaEntityDto.getTanggalSEPSuplesi() != null) {
			this.setTanggalSEPSuplesi(bpjsJasaRaharjaEntityDto.getTanggalSEPSuplesi());
		}

		if (bpjsJasaRaharjaEntityDto.getPatientPaymentBPJS() != null) {
			this.setPatientPaymentBPJS(bpjsJasaRaharjaEntityDto.getPatientPaymentBPJS());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Initial SEP No here] off begin
	@CsvBindByName(column = "INITIAL_SEP_NO", required = false)
	@Nullable
	@Column(name = "initial_sep_no")
	@Schema(description = "The Initial SEP No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Initial SEP No here] end
	private String initialSEPNo;

	// % protected region % [Modify attribute annotation for Guarantee Letter No here] off begin
	@CsvBindByName(column = "GUARANTEE_LETTER_NO", required = false)
	@Nullable
	@Column(name = "guarantee_letter_no")
	@Schema(description = "The Guarantee Letter No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Guarantee Letter No here] end
	private String guaranteeLetterNo;

	// % protected region % [Modify attribute annotation for Incident Date here] off begin

	@CsvCustomBindByName(column = "INCIDENT_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "incident_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Incident Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Incident Date here] end
	private OffsetDateTime incidentDate;

	// % protected region % [Modify attribute annotation for Registration No here] off begin
	@CsvBindByName(column = "REGISTRATION_NO", required = false)
	@Nullable
	@Column(name = "registration_no")
	@Schema(description = "The Registration No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Registration No here] end
	private String registrationNo;

	// % protected region % [Modify attribute annotation for No SEP Suplesi here] off begin
	@CsvBindByName(column = "NO_SEP_SUPLESI", required = false)
	@Nullable
	@Column(name = "no_sep_suplesi")
	@Schema(description = "The No SEP Suplesi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for No SEP Suplesi here] end
	private String noSEPSuplesi;

	// % protected region % [Modify attribute annotation for Tanggal SEP Suplesi here] off begin

	@CsvCustomBindByName(column = "TANGGAL_SEP_SUPLESI", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "tanggal_sep_suplesi")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Tanggal SEP Suplesi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tanggal SEP Suplesi here] end
	private OffsetDateTime tanggalSEPSuplesi;

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
			this.patientPaymentBPJS.removeBpjsJasaRaharjas(this, false);
		}
		this.patientPaymentBPJS = entity;
		if (reverseAdd) {
			this.patientPaymentBPJS.addBpjsJasaRaharjas(this, false);
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
			this.patientPaymentBPJS.removeBpjsJasaRaharjas(this, false);
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
		return "INITIAL_SEP_NO,GUARANTEE_LETTER_NO,INCIDENT_DATE,REGISTRATION_NO,NO_SEP_SUPLESI,TANGGAL_SEP_SUPLESI,PATIENT_PAYMENT_BPJS_ID,ID";
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
	public boolean equals(Object bpjsJasaRaharja) {
		if (this == bpjsJasaRaharja) {
			return true;
		}
		if (bpjsJasaRaharja == null || this.getClass() != bpjsJasaRaharja.getClass()) {
			return false;
		}
		if (!super.equals(bpjsJasaRaharja)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsJasaRaharjaEntity that = (BpjsJasaRaharjaEntity) bpjsJasaRaharja;
		return
			Objects.equals(this.initialSEPNo, that.initialSEPNo) &&
			Objects.equals(this.guaranteeLetterNo, that.guaranteeLetterNo) &&
			Objects.equals(
			     this.incidentDate != null ? this.incidentDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.incidentDate != null ? that.incidentDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.registrationNo, that.registrationNo) &&
			Objects.equals(this.noSEPSuplesi, that.noSEPSuplesi) &&
			Objects.equals(
			     this.tanggalSEPSuplesi != null ? this.tanggalSEPSuplesi.truncatedTo(ChronoUnit.DAYS) : null,
			     that.tanggalSEPSuplesi != null ? that.tanggalSEPSuplesi.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.patientPaymentBPJSId, that.patientPaymentBPJSId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
