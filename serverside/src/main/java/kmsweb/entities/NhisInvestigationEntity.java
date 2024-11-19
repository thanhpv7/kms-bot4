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
import kmsweb.dtos.NhisInvestigationEntityDto;
import kmsweb.entities.listeners.NhisInvestigationEntityListener;
import kmsweb.serializers.NhisInvestigationSerializer;
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
@EntityListeners({NhisInvestigationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = NhisInvestigationSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"gdrg_code"}, name = "gdrg_code"),
	}
)
public class NhisInvestigationEntity extends AbstractEntity {

	/**
	 * Takes a NhisInvestigationEntityDto and converts it into a NhisInvestigationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param nhisInvestigationEntityDto
	 */
	public NhisInvestigationEntity(NhisInvestigationEntityDto nhisInvestigationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (nhisInvestigationEntityDto.getId() != null) {
			this.setId(nhisInvestigationEntityDto.getId());
		}

		if (nhisInvestigationEntityDto.getGdrgCode() != null) {
			this.setGdrgCode(nhisInvestigationEntityDto.getGdrgCode());
		}

		if (nhisInvestigationEntityDto.getDescription() != null) {
			this.setDescription(nhisInvestigationEntityDto.getDescription());
		}

		if (nhisInvestigationEntityDto.getCategory() != null) {
			this.setCategory(nhisInvestigationEntityDto.getCategory());
		}

		if (nhisInvestigationEntityDto.getPrice() != null) {
			this.setPrice(nhisInvestigationEntityDto.getPrice());
		}

		if (nhisInvestigationEntityDto.getDate() != null) {
			this.setDate(nhisInvestigationEntityDto.getDate());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for GDRG Code here] off begin
	@CsvBindByName(column = "GDRG_CODE", required = false)
	@Nullable
	@Column(name = "gdrg_code")
	@Schema(description = "The GDRG Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for GDRG Code here] end
	private String gdrgCode;

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

	// % protected region % [Modify attribute annotation for Price here] off begin
	@CsvBindByName(column = "PRICE", required = false)
	@Nullable
	@Column(name = "price")
	@Schema(description = "The Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Price here] end
	private Double price;

	// % protected region % [Modify attribute annotation for Date here] off begin
	@CsvCustomBindByName(column = "DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Date here] end
	private OffsetDateTime date;

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
		return "GDRG_CODE,DESCRIPTION,CATEGORY,PRICE,DATE,ID";
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
	public boolean equals(Object nhisInvestigation) {
		if (this == nhisInvestigation) {
			return true;
		}
		if (nhisInvestigation == null || this.getClass() != nhisInvestigation.getClass()) {
			return false;
		}
		if (!super.equals(nhisInvestigation)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		NhisInvestigationEntity that = (NhisInvestigationEntity) nhisInvestigation;
		return
			Objects.equals(this.gdrgCode, that.gdrgCode) &&
			Objects.equals(this.description, that.description) &&
			Objects.equals(this.category, that.category) &&
			Objects.equals(this.price, that.price) &&
			Objects.equals(
			     this.date != null ? this.date.truncatedTo(ChronoUnit.DAYS) : null,
			     that.date != null ? that.date.truncatedTo(ChronoUnit.DAYS) : null
			     );
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
