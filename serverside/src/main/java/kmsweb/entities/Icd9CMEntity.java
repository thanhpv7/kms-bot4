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
import kmsweb.dtos.Icd9CMEntityDto;
import kmsweb.entities.listeners.Icd9CMEntityListener;
import kmsweb.serializers.Icd9CMSerializer;
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
@EntityListeners({Icd9CMEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = Icd9CMSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class Icd9CMEntity extends AbstractEntity {

	/**
	 * Takes a Icd9CMEntityDto and converts it into a Icd9CMEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param icd9CMEntityDto
	 */
	public Icd9CMEntity(Icd9CMEntityDto icd9CMEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (icd9CMEntityDto.getId() != null) {
			this.setId(icd9CMEntityDto.getId());
		}

		if (icd9CMEntityDto.getTopProcedure() != null) {
			this.setTopProcedure(icd9CMEntityDto.getTopProcedure());
		}

		if (icd9CMEntityDto.getDiagnosesAndProcedures() != null) {
			this.setDiagnosesAndProcedures(icd9CMEntityDto.getDiagnosesAndProcedures());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Top Procedure here] off begin
	@CsvBindByName(column = "TOP_PROCEDURE", required = false)
	@Nullable
	@Column(name = "top_procedure")
	@Schema(description = "The Top Procedure of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Top Procedure here] end
	private Boolean topProcedure = false ;

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

	// % protected region % [Update the annotation for Diagnoses and Procedures here] off begin
	@Schema(description = "The Diagnoses and Procedures entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Diagnoses and Procedures here] end
	private DiagnosesAndProceduresEntity diagnosesAndProcedures;

	// % protected region % [Update the annotation for diagnosesAndProceduresId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DIAGNOSES_AND_PROCEDURES_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for diagnosesAndProceduresId here] end
	private UUID diagnosesAndProceduresId;

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
	 * Similar to {@link this#setDiagnosesAndProcedures(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setDiagnosesAndProcedures(DiagnosesAndProceduresEntity entity) {
		setDiagnosesAndProcedures(entity, true);
	}

	/**
	 * Set or update the diagnosesAndProcedures in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to diagnosesAndProcedures
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDiagnosesAndProcedures(DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDiagnosesAndProcedures here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDiagnosesAndProcedures here] end

		if (sameAsFormer(this.diagnosesAndProcedures, entity)) {
			return;
		}

		if (this.diagnosesAndProcedures != null) {
			this.diagnosesAndProcedures.unsetMasterICD9CM(false);
		}

		this.diagnosesAndProcedures = entity;
		if (reverseAdd) {
			this.diagnosesAndProcedures.setMasterICD9CM(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDiagnosesAndProcedures incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDiagnosesAndProcedures incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDiagnosesAndProcedures(boolean)} but default to true.
	 */
	public void unsetDiagnosesAndProcedures() {
		this.unsetDiagnosesAndProcedures(true);
	}

	/**
	 * Remove the DiagnosesAndProceduresEntity of diagnosesAndProcedures from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDiagnosesAndProcedures(boolean reverse) {
		if (reverse && this.diagnosesAndProcedures != null) {
			this.diagnosesAndProcedures.unsetMasterICD9CM();
		}
		this.diagnosesAndProcedures = null;
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
		return "TOP_PROCEDURE,DIAGNOSES_AND_PROCEDURES_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<DiagnosesAndProceduresEntity> diagnosesAndProceduresRelation = Optional.ofNullable(this.diagnosesAndProcedures);
		diagnosesAndProceduresRelation.ifPresent(entity -> this.diagnosesAndProceduresId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object icd9CM) {
		if (this == icd9CM) {
			return true;
		}
		if (icd9CM == null || this.getClass() != icd9CM.getClass()) {
			return false;
		}
		if (!super.equals(icd9CM)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		Icd9CMEntity that = (Icd9CMEntity) icd9CM;
		return
			Objects.equals(this.topProcedure, that.topProcedure) &&
			Objects.equals(this.diagnosesAndProceduresId, that.diagnosesAndProceduresId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
