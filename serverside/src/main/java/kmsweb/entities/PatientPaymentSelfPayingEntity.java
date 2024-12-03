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
import kmsweb.dtos.PatientPaymentSelfPayingEntityDto;
import kmsweb.entities.listeners.PatientPaymentSelfPayingEntityListener;
import kmsweb.serializers.PatientPaymentSelfPayingSerializer;
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
@EntityListeners({PatientPaymentSelfPayingEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientPaymentSelfPayingSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PatientPaymentSelfPayingEntity extends AbstractEntity {

	/**
	 * Takes a PatientPaymentSelfPayingEntityDto and converts it into a PatientPaymentSelfPayingEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientPaymentSelfPayingEntityDto
	 */
	public PatientPaymentSelfPayingEntity(PatientPaymentSelfPayingEntityDto patientPaymentSelfPayingEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientPaymentSelfPayingEntityDto.getId() != null) {
			this.setId(patientPaymentSelfPayingEntityDto.getId());
		}

		if (patientPaymentSelfPayingEntityDto.getSponsorName() != null) {
			this.setSponsorName(patientPaymentSelfPayingEntityDto.getSponsorName());
		}

		if (patientPaymentSelfPayingEntityDto.getSponsorAddress() != null) {
			this.setSponsorAddress(patientPaymentSelfPayingEntityDto.getSponsorAddress());
		}

		if (patientPaymentSelfPayingEntityDto.getSponsorPhoneNo() != null) {
			this.setSponsorPhoneNo(patientPaymentSelfPayingEntityDto.getSponsorPhoneNo());
		}

		if (patientPaymentSelfPayingEntityDto.getSponsorship() != null) {
			this.setSponsorship(patientPaymentSelfPayingEntityDto.getSponsorship());
		}

		if (patientPaymentSelfPayingEntityDto.getPatientGeneralInformation() != null) {
			this.setPatientGeneralInformation(patientPaymentSelfPayingEntityDto.getPatientGeneralInformation());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Sponsor Name here] off begin
	@CsvBindByName(column = "SPONSOR_NAME", required = false)
	@Nullable
	@Column(name = "sponsor_name")
	@Schema(description = "The Sponsor Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sponsor Name here] end
	private String sponsorName;

	// % protected region % [Modify attribute annotation for Sponsor Address here] off begin
	@CsvBindByName(column = "SPONSOR_ADDRESS", required = false)
	@Nullable
	@Column(name = "sponsor_address")
	@Schema(description = "The Sponsor Address of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sponsor Address here] end
	private String sponsorAddress;

	// % protected region % [Modify attribute annotation for Sponsor Phone No here] off begin
	@CsvBindByName(column = "SPONSOR_PHONE_NO", required = false)
	@Nullable
	@Column(name = "sponsor_phone_no")
	@Schema(description = "The Sponsor Phone No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sponsor Phone No here] end
	private String sponsorPhoneNo;

	// % protected region % [Modify attribute annotation for Sponsorship here] off begin
	@CsvBindByName(column = "SPONSORSHIP", required = false)
	@Nullable
	@Column(name = "sponsorship")
	@Schema(description = "The Sponsorship of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sponsorship here] end
	private String sponsorship;

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
			this.patientGeneralInformation.unsetPatientSelfPaying(false);
		}

		this.patientGeneralInformation = entity;
		if (reverseAdd) {
			this.patientGeneralInformation.setPatientSelfPaying(this, false);
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
			this.patientGeneralInformation.unsetPatientSelfPaying();
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
		return "SPONSOR_NAME,SPONSOR_ADDRESS,SPONSOR_PHONE_NO,SPONSORSHIP,PATIENT_GENERAL_INFORMATION_ID,ID";
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
	public boolean equals(Object patientPaymentSelfPaying) {
		if (this == patientPaymentSelfPaying) {
			return true;
		}
		if (patientPaymentSelfPaying == null || this.getClass() != patientPaymentSelfPaying.getClass()) {
			return false;
		}
		if (!super.equals(patientPaymentSelfPaying)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientPaymentSelfPayingEntity that = (PatientPaymentSelfPayingEntity) patientPaymentSelfPaying;
		return
			Objects.equals(this.sponsorName, that.sponsorName) &&
			Objects.equals(this.sponsorAddress, that.sponsorAddress) &&
			Objects.equals(this.sponsorPhoneNo, that.sponsorPhoneNo) &&
			Objects.equals(this.sponsorship, that.sponsorship) &&
			Objects.equals(this.patientGeneralInformationId, that.patientGeneralInformationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
