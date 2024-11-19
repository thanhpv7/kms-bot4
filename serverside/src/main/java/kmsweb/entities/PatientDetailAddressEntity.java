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
import kmsweb.dtos.PatientDetailAddressEntityDto;
import kmsweb.entities.listeners.PatientDetailAddressEntityListener;
import kmsweb.serializers.PatientDetailAddressSerializer;
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
@EntityListeners({PatientDetailAddressEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientDetailAddressSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PatientDetailAddressEntity extends AbstractEntity {

	/**
	 * Takes a PatientDetailAddressEntityDto and converts it into a PatientDetailAddressEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientDetailAddressEntityDto
	 */
	public PatientDetailAddressEntity(PatientDetailAddressEntityDto patientDetailAddressEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientDetailAddressEntityDto.getId() != null) {
			this.setId(patientDetailAddressEntityDto.getId());
		}

		if (patientDetailAddressEntityDto.getCountry() != null) {
			this.setCountry(patientDetailAddressEntityDto.getCountry());
		}

		if (patientDetailAddressEntityDto.getState() != null) {
			this.setState(patientDetailAddressEntityDto.getState());
		}

		if (patientDetailAddressEntityDto.getRegency() != null) {
			this.setRegency(patientDetailAddressEntityDto.getRegency());
		}

		if (patientDetailAddressEntityDto.getDistrict() != null) {
			this.setDistrict(patientDetailAddressEntityDto.getDistrict());
		}

		if (patientDetailAddressEntityDto.getVillage() != null) {
			this.setVillage(patientDetailAddressEntityDto.getVillage());
		}

		if (patientDetailAddressEntityDto.getPostCode() != null) {
			this.setPostCode(patientDetailAddressEntityDto.getPostCode());
		}

		if (patientDetailAddressEntityDto.getRt() != null) {
			this.setRt(patientDetailAddressEntityDto.getRt());
		}

		if (patientDetailAddressEntityDto.getRw() != null) {
			this.setRw(patientDetailAddressEntityDto.getRw());
		}

		if (patientDetailAddressEntityDto.getPatientGeneralInformation() != null) {
			this.setPatientGeneralInformation(patientDetailAddressEntityDto.getPatientGeneralInformation());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Country here] off begin
	@CsvBindByName(column = "COUNTRY", required = false)
	@Nullable
	@Column(name = "country")
	@Schema(description = "The Country of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Country here] end
	private String country;

	// % protected region % [Modify attribute annotation for State here] off begin
	@CsvBindByName(column = "STATE", required = false)
	@Nullable
	@Column(name = "state")
	@Schema(description = "The State of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for State here] end
	private String state;

	// % protected region % [Modify attribute annotation for Regency here] off begin
	@CsvBindByName(column = "REGENCY", required = false)
	@Nullable
	@Column(name = "regency")
	@Schema(description = "The Regency of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Regency here] end
	private String regency;

	// % protected region % [Modify attribute annotation for District here] off begin
	@CsvBindByName(column = "DISTRICT", required = false)
	@Nullable
	@Column(name = "district")
	@Schema(description = "The District of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for District here] end
	private String district;

	// % protected region % [Modify attribute annotation for Village here] off begin
	@CsvBindByName(column = "VILLAGE", required = false)
	@Nullable
	@Column(name = "village")
	@Schema(description = "The Village of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Village here] end
	private String village;

	// % protected region % [Modify attribute annotation for Post Code here] off begin
	@CsvBindByName(column = "POST_CODE", required = false)
	@Nullable
	@Column(name = "post_code")
	@Schema(description = "The Post Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Post Code here] end
	private String postCode;

	// % protected region % [Modify attribute annotation for RT here] off begin
	@CsvBindByName(column = "RT", required = false)
	@Nullable
	@Column(name = "rt")
	@Schema(description = "The RT of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for RT here] end
	private String rt;

	// % protected region % [Modify attribute annotation for RW here] off begin
	@CsvBindByName(column = "RW", required = false)
	@Nullable
	@Column(name = "rw")
	@Schema(description = "The RW of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for RW here] end
	private String rw;

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

	// % protected region % [Update the annotation for Patient General Information here] off begin
	@Schema(description = "The Patient General Information entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient General Information here] end
	private PatientGeneralInfoEntity patientGeneralInformation;

	// % protected region % [Update the annotation for patientGeneralInformationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_GENERAL_INFORMATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientGeneralInformationId here] end
	private UUID patientGeneralInformationId;

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
	 * Similar to {@link this#setPatientGeneralInformation(PatientGeneralInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientGeneralInformation(PatientGeneralInfoEntity entity) {
		setPatientGeneralInformation(entity, true);
	}

	/**
	 * Set or update the patientGeneralInformation in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInformation
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInformation(PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInformation here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInformation here] end

		if (sameAsFormer(this.patientGeneralInformation, entity)) {
			return;
		}

		if (this.patientGeneralInformation != null) {
			this.patientGeneralInformation.unsetPatientDetailAddress(false);
		}

		this.patientGeneralInformation = entity;
		if (reverseAdd) {
			this.patientGeneralInformation.setPatientDetailAddress(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInformation incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInformation incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientGeneralInformation(boolean)} but default to true.
	 */
	public void unsetPatientGeneralInformation() {
		this.unsetPatientGeneralInformation(true);
	}

	/**
	 * Remove the PatientGeneralInfoEntity of patientGeneralInformation from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientGeneralInformation(boolean reverse) {
		if (reverse && this.patientGeneralInformation != null) {
			this.patientGeneralInformation.unsetPatientDetailAddress();
		}
		this.patientGeneralInformation = null;
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
		return "COUNTRY,STATE,REGENCY,DISTRICT,VILLAGE,POST_CODE,RT,RW,PATIENT_GENERAL_INFORMATION_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<PatientGeneralInfoEntity> patientGeneralInformationRelation = Optional.ofNullable(this.patientGeneralInformation);
		patientGeneralInformationRelation.ifPresent(entity -> this.patientGeneralInformationId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object patientDetailAddress) {
		if (this == patientDetailAddress) {
			return true;
		}
		if (patientDetailAddress == null || this.getClass() != patientDetailAddress.getClass()) {
			return false;
		}
		if (!super.equals(patientDetailAddress)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientDetailAddressEntity that = (PatientDetailAddressEntity) patientDetailAddress;
		return
			Objects.equals(this.country, that.country) &&
			Objects.equals(this.state, that.state) &&
			Objects.equals(this.regency, that.regency) &&
			Objects.equals(this.district, that.district) &&
			Objects.equals(this.village, that.village) &&
			Objects.equals(this.postCode, that.postCode) &&
			Objects.equals(this.rt, that.rt) &&
			Objects.equals(this.rw, that.rw) &&
			Objects.equals(this.patientGeneralInformationId, that.patientGeneralInformationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
