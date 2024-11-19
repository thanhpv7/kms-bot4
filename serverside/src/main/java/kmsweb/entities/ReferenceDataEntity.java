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
import kmsweb.dtos.ReferenceDataEntityDto;
import kmsweb.entities.listeners.ReferenceDataEntityListener;
import kmsweb.serializers.ReferenceDataSerializer;
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
@EntityListeners({ReferenceDataEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = ReferenceDataSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class ReferenceDataEntity extends AbstractEntity {

	/**
	 * Takes a ReferenceDataEntityDto and converts it into a ReferenceDataEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param referenceDataEntityDto
	 */
	public ReferenceDataEntity(ReferenceDataEntityDto referenceDataEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (referenceDataEntityDto.getId() != null) {
			this.setId(referenceDataEntityDto.getId());
		}

		if (referenceDataEntityDto.getReferenceType() != null) {
			this.setReferenceType(referenceDataEntityDto.getReferenceType());
		}

		if (referenceDataEntityDto.getCode() != null) {
			this.setCode(referenceDataEntityDto.getCode());
		}

		if (referenceDataEntityDto.getDescription() != null) {
			this.setDescription(referenceDataEntityDto.getDescription());
		}

		if (referenceDataEntityDto.getAssociatedValues() != null) {
			this.setAssociatedValues(referenceDataEntityDto.getAssociatedValues());
		}

		if (referenceDataEntityDto.getSequence() != null) {
			this.setSequence(referenceDataEntityDto.getSequence());
		}

		if (referenceDataEntityDto.getFilter() != null) {
			this.setFilter(referenceDataEntityDto.getFilter());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Reference Type here] off begin
	@CsvBindByName(column = "REFERENCE_TYPE", required = true)
	@NotNull(message = "Reference Type must not be empty")
	@Column(name = "reference_type")
	@Schema(description = "The Reference Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Reference Type here] end
	private String referenceType;

	// % protected region % [Modify attribute annotation for Code here] off begin
	@CsvBindByName(column = "CODE", required = true)
	@NotNull(message = "Code must not be empty")
	@Column(name = "code")
	@Schema(description = "The Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Code here] end
	private String code;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@CsvBindByName(column = "DESCRIPTION", required = true)
	@NotNull(message = "Description must not be empty")
	@Lob
	@Column(name = "description")
	@Schema(description = "The Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for Associated Values here] off begin
	@CsvBindByName(column = "ASSOCIATED_VALUES", required = false)
	@Nullable
	@Lob
	@Column(name = "associated_values")
	@Schema(description = "The Associated Values of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Associated Values here] end
	private String associatedValues;

	// % protected region % [Modify attribute annotation for Sequence here] off begin
	@CsvBindByName(column = "SEQUENCE", required = true)
	@NotNull(message = "Sequence must not be empty")
	@Column(name = "sequence")
	@Schema(description = "The Sequence of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sequence here] end
	private Integer sequence;

	// % protected region % [Modify attribute annotation for Filter here] off begin
	@CsvBindByName(column = "FILTER", required = false)
	@Nullable
	@Column(name = "filter")
	@Schema(description = "The Filter of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Filter here] end
	private String filter;

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
		return "REFERENCE_TYPE,CODE,DESCRIPTION,ASSOCIATED_VALUES,SEQUENCE,FILTER,ID";
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
	public boolean equals(Object referenceData) {
		if (this == referenceData) {
			return true;
		}
		if (referenceData == null || this.getClass() != referenceData.getClass()) {
			return false;
		}
		if (!super.equals(referenceData)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		ReferenceDataEntity that = (ReferenceDataEntity) referenceData;
		return
			Objects.equals(this.referenceType, that.referenceType) &&
			Objects.equals(this.code, that.code) &&
			Objects.equals(this.description, that.description) &&
			Objects.equals(this.associatedValues, that.associatedValues) &&
			Objects.equals(this.sequence, that.sequence) &&
			Objects.equals(this.filter, that.filter);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
