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
import kmsweb.dtos.BpjsINACBGVariableEntityDto;
import kmsweb.entities.listeners.BpjsINACBGVariableEntityListener;
import kmsweb.serializers.BpjsINACBGVariableSerializer;
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
@EntityListeners({BpjsINACBGVariableEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsINACBGVariableSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"variable_code"}, name = "variable_code"),
	}
)
public class BpjsINACBGVariableEntity extends AbstractEntity {

	/**
	 * Takes a BpjsINACBGVariableEntityDto and converts it into a BpjsINACBGVariableEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsINACBGVariableEntityDto
	 */
	public BpjsINACBGVariableEntity(BpjsINACBGVariableEntityDto bpjsINACBGVariableEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsINACBGVariableEntityDto.getId() != null) {
			this.setId(bpjsINACBGVariableEntityDto.getId());
		}

		if (bpjsINACBGVariableEntityDto.getVariableCode() != null) {
			this.setVariableCode(bpjsINACBGVariableEntityDto.getVariableCode());
		}

		if (bpjsINACBGVariableEntityDto.getEnglish() != null) {
			this.setEnglish(bpjsINACBGVariableEntityDto.getEnglish());
		}

		if (bpjsINACBGVariableEntityDto.getIndonesian() != null) {
			this.setIndonesian(bpjsINACBGVariableEntityDto.getIndonesian());
		}

		if (bpjsINACBGVariableEntityDto.getNotes() != null) {
			this.setNotes(bpjsINACBGVariableEntityDto.getNotes());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Variable Code here] off begin
	@CsvBindByName(column = "VARIABLE_CODE", required = true)
	@NotNull(message = "Variable Code must not be empty")
	@Column(name = "variable_code")
	@Schema(description = "The Variable Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Variable Code here] end
	private String variableCode;

	// % protected region % [Modify attribute annotation for English here] off begin
	@CsvBindByName(column = "ENGLISH", required = true)
	@NotNull(message = "English must not be empty")
	@Column(name = "english")
	@Schema(description = "The English of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for English here] end
	private String english;

	// % protected region % [Modify attribute annotation for Indonesian here] off begin
	@CsvBindByName(column = "INDONESIAN", required = true)
	@NotNull(message = "Indonesian must not be empty")
	@Column(name = "indonesian")
	@Schema(description = "The Indonesian of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Indonesian here] end
	private String indonesian;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = true)
	@NotNull(message = "Notes must not be empty")
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

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
		return "VARIABLE_CODE,ENGLISH,INDONESIAN,NOTES,ID";
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
	public boolean equals(Object bpjsINACBGVariable) {
		if (this == bpjsINACBGVariable) {
			return true;
		}
		if (bpjsINACBGVariable == null || this.getClass() != bpjsINACBGVariable.getClass()) {
			return false;
		}
		if (!super.equals(bpjsINACBGVariable)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsINACBGVariableEntity that = (BpjsINACBGVariableEntity) bpjsINACBGVariable;
		return
			Objects.equals(this.variableCode, that.variableCode) &&
			Objects.equals(this.english, that.english) &&
			Objects.equals(this.indonesian, that.indonesian) &&
			Objects.equals(this.notes, that.notes);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
