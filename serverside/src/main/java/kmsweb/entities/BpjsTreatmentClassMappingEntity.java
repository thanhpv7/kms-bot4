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
import kmsweb.dtos.BpjsTreatmentClassMappingEntityDto;
import kmsweb.entities.listeners.BpjsTreatmentClassMappingEntityListener;
import kmsweb.serializers.BpjsTreatmentClassMappingSerializer;
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
@EntityListeners({BpjsTreatmentClassMappingEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsTreatmentClassMappingSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"ref_code"}, name = "ref_code"),
	}
)
public class BpjsTreatmentClassMappingEntity extends AbstractEntity {

	/**
	 * Takes a BpjsTreatmentClassMappingEntityDto and converts it into a BpjsTreatmentClassMappingEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsTreatmentClassMappingEntityDto
	 */
	public BpjsTreatmentClassMappingEntity(BpjsTreatmentClassMappingEntityDto bpjsTreatmentClassMappingEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsTreatmentClassMappingEntityDto.getId() != null) {
			this.setId(bpjsTreatmentClassMappingEntityDto.getId());
		}

		if (bpjsTreatmentClassMappingEntityDto.getRefCode() != null) {
			this.setRefCode(bpjsTreatmentClassMappingEntityDto.getRefCode());
		}

		if (bpjsTreatmentClassMappingEntityDto.getRefName() != null) {
			this.setRefName(bpjsTreatmentClassMappingEntityDto.getRefName());
		}

		if (bpjsTreatmentClassMappingEntityDto.getInternalTreatmentClass() != null) {
			this.setInternalTreatmentClass(bpjsTreatmentClassMappingEntityDto.getInternalTreatmentClass());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Ref Code here] off begin
	@CsvBindByName(column = "REF_CODE", required = true)
	@NotNull(message = "Ref Code must not be empty")
	@Length(message = "Length must be less than or equal to 25", max = 25)
	@Column(name = "ref_code")
	@Schema(description = "The Ref Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ref Code here] end
	private String refCode;

	// % protected region % [Modify attribute annotation for Ref Name here] off begin
	@CsvBindByName(column = "REF_NAME", required = true)
	@NotNull(message = "Ref Name must not be empty")
	@Length(message = "Length must be less than or equal to 50", max = 50)
	@Column(name = "ref_name")
	@Schema(description = "The Ref Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ref Name here] end
	private String refName;

	// % protected region % [Modify attribute annotation for Internal Treatment Class here] off begin
	@CsvBindByName(column = "INTERNAL_TREATMENT_CLASS", required = true)
	@NotNull(message = "Internal Treatment Class must not be empty")
	@Column(name = "internal_treatment_class")
	@Schema(description = "The Internal Treatment Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Internal Treatment Class here] end
	private String internalTreatmentClass;

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
		return "REF_CODE,REF_NAME,INTERNAL_TREATMENT_CLASS,ID";
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
	public boolean equals(Object bpjsTreatmentClassMapping) {
		if (this == bpjsTreatmentClassMapping) {
			return true;
		}
		if (bpjsTreatmentClassMapping == null || this.getClass() != bpjsTreatmentClassMapping.getClass()) {
			return false;
		}
		if (!super.equals(bpjsTreatmentClassMapping)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsTreatmentClassMappingEntity that = (BpjsTreatmentClassMappingEntity) bpjsTreatmentClassMapping;
		return
			Objects.equals(this.refCode, that.refCode) &&
			Objects.equals(this.refName, that.refName) &&
			Objects.equals(this.internalTreatmentClass, that.internalTreatmentClass);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
