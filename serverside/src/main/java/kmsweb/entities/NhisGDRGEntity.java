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
import kmsweb.dtos.NhisGDRGEntityDto;
import kmsweb.entities.listeners.NhisGDRGEntityListener;
import kmsweb.serializers.NhisGDRGSerializer;
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
@EntityListeners({NhisGDRGEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = NhisGDRGSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"core_gdrg_code"}, name = "core_gdrg_code"),
	}
)
public class NhisGDRGEntity extends AbstractEntity {

	/**
	 * Takes a NhisGDRGEntityDto and converts it into a NhisGDRGEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param nhisGDRGEntityDto
	 */
	public NhisGDRGEntity(NhisGDRGEntityDto nhisGDRGEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (nhisGDRGEntityDto.getId() != null) {
			this.setId(nhisGDRGEntityDto.getId());
		}

		if (nhisGDRGEntityDto.getCoreGDRGCode() != null) {
			this.setCoreGDRGCode(nhisGDRGEntityDto.getCoreGDRGCode());
		}

		if (nhisGDRGEntityDto.getDescription() != null) {
			this.setDescription(nhisGDRGEntityDto.getDescription());
		}

		if (nhisGDRGEntityDto.getCategory() != null) {
			this.setCategory(nhisGDRGEntityDto.getCategory());
		}

		if (nhisGDRGEntityDto.getLevelOfHealthcare() != null) {
			this.setLevelOfHealthcare(nhisGDRGEntityDto.getLevelOfHealthcare());
		}

		if (nhisGDRGEntityDto.getInvestigationCode() != null) {
			this.setInvestigationCode(nhisGDRGEntityDto.getInvestigationCode());
		}

		if (nhisGDRGEntityDto.getIcd10s() != null) {
			this.setIcd10s(nhisGDRGEntityDto.getIcd10s());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Core GDRG Code here] off begin
	@CsvBindByName(column = "CORE_GDRG_CODE", required = false)
	@Nullable
	@Column(name = "core_gdrg_code")
	@Schema(description = "The Core GDRG Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Core GDRG Code here] end
	private String coreGDRGCode;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@CsvBindByName(column = "DESCRIPTION", required = false)
	@Nullable
	@Column(name = "description")
	@Schema(description = "The Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for Category here] off begin
	@CsvBindByName(column = "CATEGORY", required = false)
	@Nullable
	@Column(name = "category")
	@Schema(description = "The Category of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Category here] end
	private String category;

	// % protected region % [Modify attribute annotation for Level of Healthcare here] off begin
	@CsvBindByName(column = "LEVEL_OF_HEALTHCARE", required = false)
	@Nullable
	@Column(name = "level_of_healthcare")
	@Schema(description = "The Level of Healthcare of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Level of Healthcare here] end
	private String levelOfHealthcare;

	// % protected region % [Modify attribute annotation for Investigation Code here] off begin
	@CsvBindByName(column = "INVESTIGATION_CODE", required = false)
	@Nullable
	@Column(name = "investigation_code")
	@Schema(description = "The Investigation Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Investigation Code here] end
	private String investigationCode;

	// % protected region % [Modify attribute annotation for icd10s here] off begin
	@CsvBindByName(column = "ICD10S", required = false)
	@Nullable
	@Column(name = "icd10s")
	@Schema(description = "The icd10s of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for icd10s here] end
	private String icd10s;

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
		return "CORE_GDRG_CODE,DESCRIPTION,CATEGORY,LEVEL_OF_HEALTHCARE,INVESTIGATION_CODE,ICD10S,ID";
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
	public boolean equals(Object nhisGDRG) {
		if (this == nhisGDRG) {
			return true;
		}
		if (nhisGDRG == null || this.getClass() != nhisGDRG.getClass()) {
			return false;
		}
		if (!super.equals(nhisGDRG)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		NhisGDRGEntity that = (NhisGDRGEntity) nhisGDRG;
		return
			Objects.equals(this.coreGDRGCode, that.coreGDRGCode) &&
			Objects.equals(this.description, that.description) &&
			Objects.equals(this.category, that.category) &&
			Objects.equals(this.levelOfHealthcare, that.levelOfHealthcare) &&
			Objects.equals(this.investigationCode, that.investigationCode) &&
			Objects.equals(this.icd10s, that.icd10s);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
