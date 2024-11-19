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
import kmsweb.dtos.NumberingSetupEntityDto;
import kmsweb.entities.enums.*;
import kmsweb.services.utils.converters.enums.*;
import kmsweb.entities.listeners.NumberingSetupEntityListener;
import kmsweb.serializers.NumberingSetupSerializer;
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
@EntityListeners({NumberingSetupEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = NumberingSetupSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"prefix"}, name = "prefix"),
	}
)
public class NumberingSetupEntity extends AbstractEntity {

	/**
	 * Takes a NumberingSetupEntityDto and converts it into a NumberingSetupEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param numberingSetupEntityDto
	 */
	public NumberingSetupEntity(NumberingSetupEntityDto numberingSetupEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (numberingSetupEntityDto.getId() != null) {
			this.setId(numberingSetupEntityDto.getId());
		}

		if (numberingSetupEntityDto.getNumberingType() != null) {
			this.setNumberingType(numberingSetupEntityDto.getNumberingType());
		}

		if (numberingSetupEntityDto.getPrefix() != null) {
			this.setPrefix(numberingSetupEntityDto.getPrefix());
		}

		if (numberingSetupEntityDto.getDateFormat() != null) {
			this.setDateFormat(numberingSetupEntityDto.getDateFormat());
		}

		if (numberingSetupEntityDto.getSufix() != null) {
			this.setSufix(numberingSetupEntityDto.getSufix());
		}

		if (numberingSetupEntityDto.getLastCounter() != null) {
			this.setLastCounter(numberingSetupEntityDto.getLastCounter());
		}

		if (numberingSetupEntityDto.getEditable() != null) {
			this.setEditable(numberingSetupEntityDto.getEditable());
		}

		if (numberingSetupEntityDto.getResetPerDay() != null) {
			this.setResetPerDay(numberingSetupEntityDto.getResetPerDay());
		}

		if (numberingSetupEntityDto.getCounterLength() != null) {
			this.setCounterLength(numberingSetupEntityDto.getCounterLength());
		}

		if (numberingSetupEntityDto.getLastUpdated() != null) {
			this.setLastUpdated(numberingSetupEntityDto.getLastUpdated());
		}

		if (numberingSetupEntityDto.getPreview() != null) {
			this.setPreview(numberingSetupEntityDto.getPreview());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Numbering Type here] off begin
	@CsvCustomBindByName(column = "NUMBERING_TYPE", required = false, converter = NumberingTypeEnumConverter.class)
	@Nullable
	@Column(name = "numbering_type")
	@Schema(description = "The Numbering Type of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Numbering Type here] end
	private NumberingTypeEnum numberingType;

	// % protected region % [Modify attribute annotation for Prefix here] off begin
	@CsvBindByName(column = "PREFIX", required = false)
	@Nullable
	@Column(name = "prefix")
	@Schema(description = "The Prefix of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Prefix here] end
	private String prefix;

	// % protected region % [Modify attribute annotation for Date Format here] off begin
	@CsvCustomBindByName(column = "DATE_FORMAT", required = false, converter = DateFormatEnumConverter.class)
	@Nullable
	@Column(name = "date_format")
	@Schema(description = "The Date Format of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Date Format here] end
	private DateFormatEnum dateFormat;

	// % protected region % [Modify attribute annotation for Sufix here] off begin
	@CsvBindByName(column = "SUFIX", required = false)
	@Nullable
	@Column(name = "sufix")
	@Schema(description = "The Sufix of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sufix here] end
	private String sufix;

	// % protected region % [Modify attribute annotation for Last Counter here] off begin
	@CsvBindByName(column = "LAST_COUNTER", required = false)
	@Nullable
	@Column(name = "last_counter")
	@Schema(description = "The Last Counter of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Last Counter here] end
	private Integer lastCounter;

	// % protected region % [Modify attribute annotation for Editable here] off begin
	@CsvBindByName(column = "EDITABLE", required = false)
	@Nullable
	@Column(name = "editable")
	@Schema(description = "The Editable of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Editable here] end
	private Boolean editable = false ;

	// % protected region % [Modify attribute annotation for Reset per Day here] off begin
	@CsvBindByName(column = "RESET_PER_DAY", required = false)
	@Nullable
	@Column(name = "reset_per_day")
	@Schema(description = "The Reset per Day of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Reset per Day here] end
	private Boolean resetPerDay = false ;

	// % protected region % [Modify attribute annotation for Counter Length here] off begin
	@CsvBindByName(column = "COUNTER_LENGTH", required = false)
	@Nullable
	@Column(name = "counter_length")
	@Schema(description = "The Counter Length of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Counter Length here] end
	private Integer counterLength;

	// % protected region % [Modify attribute annotation for Last Updated here] off begin
	@CsvCustomBindByName(column = "LAST_UPDATED", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "last_updated")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Last Updated of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Last Updated here] end
	private OffsetDateTime lastUpdated;

	// % protected region % [Modify attribute annotation for Preview here] off begin
	@CsvBindByName(column = "PREVIEW", required = false)
	@Nullable
	@Column(name = "preview")
	@Schema(description = "The Preview of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Preview here] end
	private String preview;

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
		return "NUMBERING_TYPE,PREFIX,DATE_FORMAT,SUFIX,LAST_COUNTER,EDITABLE,RESET_PER_DAY,COUNTER_LENGTH,LAST_UPDATED,PREVIEW,ID";
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
	public boolean equals(Object numberingSetup) {
		if (this == numberingSetup) {
			return true;
		}
		if (numberingSetup == null || this.getClass() != numberingSetup.getClass()) {
			return false;
		}
		if (!super.equals(numberingSetup)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		NumberingSetupEntity that = (NumberingSetupEntity) numberingSetup;
		return
			Objects.equals(this.numberingType, that.numberingType) &&
			Objects.equals(this.prefix, that.prefix) &&
			Objects.equals(this.dateFormat, that.dateFormat) &&
			Objects.equals(this.sufix, that.sufix) &&
			Objects.equals(this.lastCounter, that.lastCounter) &&
			Objects.equals(this.editable, that.editable) &&
			Objects.equals(this.resetPerDay, that.resetPerDay) &&
			Objects.equals(this.counterLength, that.counterLength) &&
			Objects.equals(
			     this.lastUpdated != null ? this.lastUpdated.truncatedTo(ChronoUnit.DAYS) : null,
			     that.lastUpdated != null ? that.lastUpdated.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.preview, that.preview);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
