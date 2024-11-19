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
import kmsweb.dtos.NhisClaimInvestigationDetailEntityDto;
import kmsweb.entities.listeners.NhisClaimInvestigationDetailEntityListener;
import kmsweb.serializers.NhisClaimInvestigationDetailSerializer;
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
@EntityListeners({NhisClaimInvestigationDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = NhisClaimInvestigationDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class NhisClaimInvestigationDetailEntity extends AbstractEntity {

	/**
	 * Takes a NhisClaimInvestigationDetailEntityDto and converts it into a NhisClaimInvestigationDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param nhisClaimInvestigationDetailEntityDto
	 */
	public NhisClaimInvestigationDetailEntity(NhisClaimInvestigationDetailEntityDto nhisClaimInvestigationDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (nhisClaimInvestigationDetailEntityDto.getId() != null) {
			this.setId(nhisClaimInvestigationDetailEntityDto.getId());
		}

		if (nhisClaimInvestigationDetailEntityDto.getDate() != null) {
			this.setDate(nhisClaimInvestigationDetailEntityDto.getDate());
		}

		if (nhisClaimInvestigationDetailEntityDto.getDescription() != null) {
			this.setDescription(nhisClaimInvestigationDetailEntityDto.getDescription());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Date here] off begin

	@CsvCustomBindByName(column = "DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Date here] end
	private OffsetDateTime date;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@CsvBindByName(column = "DESCRIPTION", required = false)
	@Nullable
	@Column(name = "description")
	@Schema(description = "The Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

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
		return "DATE,DESCRIPTION,ID";
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
	public boolean equals(Object nhisClaimInvestigationDetail) {
		if (this == nhisClaimInvestigationDetail) {
			return true;
		}
		if (nhisClaimInvestigationDetail == null || this.getClass() != nhisClaimInvestigationDetail.getClass()) {
			return false;
		}
		if (!super.equals(nhisClaimInvestigationDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		NhisClaimInvestigationDetailEntity that = (NhisClaimInvestigationDetailEntity) nhisClaimInvestigationDetail;
		return
			Objects.equals(
			     this.date != null ? this.date.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.date != null ? that.date.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.description, that.description);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
