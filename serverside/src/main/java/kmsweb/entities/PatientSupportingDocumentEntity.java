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
import kmsweb.dtos.PatientSupportingDocumentEntityDto;
import kmsweb.entities.listeners.PatientSupportingDocumentEntityListener;
import kmsweb.serializers.PatientSupportingDocumentSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.lib.file.models.FileEntity;
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

import java.util.*;
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
@EntityListeners({PatientSupportingDocumentEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientSupportingDocumentSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PatientSupportingDocumentEntity extends AbstractEntity {

	/**
	 * Takes a PatientSupportingDocumentEntityDto and converts it into a PatientSupportingDocumentEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientSupportingDocumentEntityDto
	 */
	public PatientSupportingDocumentEntity(PatientSupportingDocumentEntityDto patientSupportingDocumentEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientSupportingDocumentEntityDto.getId() != null) {
			this.setId(patientSupportingDocumentEntityDto.getId());
		}

		if (patientSupportingDocumentEntityDto.getFileName() != null) {
			this.setFileName(patientSupportingDocumentEntityDto.getFileName());
		}

		if (patientSupportingDocumentEntityDto.getDescription() != null) {
			this.setDescription(patientSupportingDocumentEntityDto.getDescription());
		}

		if (patientSupportingDocumentEntityDto.getPatientGeneralInformation() != null) {
			this.setPatientGeneralInformation(patientSupportingDocumentEntityDto.getPatientGeneralInformation());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for File Name here] off begin
	@CsvBindByName(column = "FILE_NAME", required = false)
	@Nullable
	@Column(name = "file_name")
	@Schema(description = "The File Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for File Name here] end
	private String fileName;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@CsvBindByName(column = "DESCRIPTION", required = false)
	@Nullable
	@Column(name = "description")
	@Schema(description = "The Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	@CsvIgnore
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	private Set<FileEntity> supportingDocument = new HashSet<>();

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
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
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
	public void setPatientGeneralInformation(@NotNull PatientGeneralInfoEntity entity) {
		setPatientGeneralInformation(entity, true);
	}

	/**
	 * Set or update the patientGeneralInformation in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInformation
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInformation(@NotNull PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInformation here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInformation here] end

		if (sameAsFormer(this.patientGeneralInformation, entity)) {
			return;
		}

		if (this.patientGeneralInformation != null) {
			this.patientGeneralInformation.removePatientFinalizeProfiles(this, false);
		}
		this.patientGeneralInformation = entity;
		if (reverseAdd) {
			this.patientGeneralInformation.addPatientFinalizeProfiles(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInformation incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInformation incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientGeneralInformation(boolean)} but default to true.
	 */
	public void unsetPatientGeneralInformation() {
		this.unsetPatientGeneralInformation(true);
	}

	/**
	 * Remove Patient General Information in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientGeneralInformation(boolean reverse) {
		if (reverse && this.patientGeneralInformation != null) {
			this.patientGeneralInformation.removePatientFinalizeProfiles(this, false);
		}
		this.patientGeneralInformation = null;
	}

	public void addSupportingDocument(FileEntity newFile) {
		supportingDocument.add(newFile);
	}

	public void addAllSupportingDocument(Collection<FileEntity> newFiles) {
		supportingDocument.addAll(newFiles);
	}

	public void removeSupportingDocument(FileEntity newFile) {
		supportingDocument.remove(newFile);
	}

	public boolean containsSupportingDocument(FileEntity newFile) {
		return supportingDocument.contains(newFile);
	}

	public void clearAllSupportingDocument() {
		supportingDocument.clear();
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
		return "FILE_NAME,DESCRIPTION,PATIENT_GENERAL_INFORMATION_ID,ID";
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
	public boolean equals(Object patientSupportingDocument) {
		if (this == patientSupportingDocument) {
			return true;
		}
		if (patientSupportingDocument == null || this.getClass() != patientSupportingDocument.getClass()) {
			return false;
		}
		if (!super.equals(patientSupportingDocument)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientSupportingDocumentEntity that = (PatientSupportingDocumentEntity) patientSupportingDocument;
		return
			Objects.equals(this.fileName, that.fileName) &&
			Objects.equals(this.description, that.description) &&
			Objects.equals(this.patientGeneralInformationId, that.patientGeneralInformationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
