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
import kmsweb.dtos.CashAllocationEntityDto;
import kmsweb.entities.enums.*;
import kmsweb.services.utils.converters.enums.*;
import kmsweb.entities.listeners.CashAllocationEntityListener;
import kmsweb.serializers.CashAllocationSerializer;
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
@EntityListeners({CashAllocationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = CashAllocationSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class CashAllocationEntity extends AbstractEntity {

	/**
	 * Takes a CashAllocationEntityDto and converts it into a CashAllocationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param cashAllocationEntityDto
	 */
	public CashAllocationEntity(CashAllocationEntityDto cashAllocationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (cashAllocationEntityDto.getId() != null) {
			this.setId(cashAllocationEntityDto.getId());
		}

		if (cashAllocationEntityDto.getCashType() != null) {
			this.setCashType(cashAllocationEntityDto.getCashType());
		}

		if (cashAllocationEntityDto.getAllocatedDate() != null) {
			this.setAllocatedDate(cashAllocationEntityDto.getAllocatedDate());
		}

		if (cashAllocationEntityDto.getSourceDate() != null) {
			this.setSourceDate(cashAllocationEntityDto.getSourceDate());
		}

		if (cashAllocationEntityDto.getCashNumber() != null) {
			this.setCashNumber(cashAllocationEntityDto.getCashNumber());
		}

		if (cashAllocationEntityDto.getSourceDocumentType() != null) {
			this.setSourceDocumentType(cashAllocationEntityDto.getSourceDocumentType());
		}

		if (cashAllocationEntityDto.getSourceNumber() != null) {
			this.setSourceNumber(cashAllocationEntityDto.getSourceNumber());
		}

		if (cashAllocationEntityDto.getSourceAmount() != null) {
			this.setSourceAmount(cashAllocationEntityDto.getSourceAmount());
		}

		if (cashAllocationEntityDto.getOutstandingAmount() != null) {
			this.setOutstandingAmount(cashAllocationEntityDto.getOutstandingAmount());
		}

		if (cashAllocationEntityDto.getAllocatedAmount() != null) {
			this.setAllocatedAmount(cashAllocationEntityDto.getAllocatedAmount());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Cash Type here] off begin
	@CsvCustomBindByName(column = "CASH_TYPE", required = false, converter = CashTypeEnumConverter.class)
	@Nullable
	@Column(name = "cash_type")
	@Schema(description = "The Cash Type of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Cash Type here] end
	private CashTypeEnum cashType;

	// % protected region % [Modify attribute annotation for Allocated Date here] off begin

	@CsvCustomBindByName(column = "ALLOCATED_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "allocated_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Allocated Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Allocated Date here] end
	private OffsetDateTime allocatedDate;

	// % protected region % [Modify attribute annotation for Source Date here] off begin

	@CsvCustomBindByName(column = "SOURCE_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "source_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Source Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Source Date here] end
	private OffsetDateTime sourceDate;

	// % protected region % [Modify attribute annotation for Cash Number here] off begin
	@CsvBindByName(column = "CASH_NUMBER", required = false)
	@Nullable
	@Column(name = "cash_number")
	@Schema(description = "The Cash Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Cash Number here] end
	private String cashNumber;

	// % protected region % [Modify attribute annotation for Source Document Type here] off begin
	@CsvCustomBindByName(column = "SOURCE_DOCUMENT_TYPE", required = false, converter = SourceDocumentTypeEnumConverter.class)
	@Nullable
	@Column(name = "source_document_type")
	@Schema(description = "The Source Document Type of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Source Document Type here] end
	private SourceDocumentTypeEnum sourceDocumentType;

	// % protected region % [Modify attribute annotation for Source Number here] off begin
	@CsvBindByName(column = "SOURCE_NUMBER", required = false)
	@Nullable
	@Column(name = "source_number")
	@Schema(description = "The Source Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Source Number here] end
	private String sourceNumber;

	// % protected region % [Modify attribute annotation for Source Amount here] off begin
	@CsvBindByName(column = "SOURCE_AMOUNT", required = false)
	@Nullable
	@Column(name = "source_amount")
	@Schema(description = "The Source Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Source Amount here] end
	private Double sourceAmount;

	// % protected region % [Modify attribute annotation for Outstanding Amount here] off begin
	@CsvBindByName(column = "OUTSTANDING_AMOUNT", required = false)
	@Nullable
	@Column(name = "outstanding_amount")
	@Schema(description = "The Outstanding Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Outstanding Amount here] end
	private Double outstandingAmount;

	// % protected region % [Modify attribute annotation for Allocated Amount here] off begin
	@CsvBindByName(column = "ALLOCATED_AMOUNT", required = false)
	@Nullable
	@Column(name = "allocated_amount")
	@Schema(description = "The Allocated Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Allocated Amount here] end
	private Double allocatedAmount;

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
		return "CASH_TYPE,ALLOCATED_DATE,SOURCE_DATE,CASH_NUMBER,SOURCE_DOCUMENT_TYPE,SOURCE_NUMBER,SOURCE_AMOUNT,OUTSTANDING_AMOUNT,ALLOCATED_AMOUNT,ID";
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
	public boolean equals(Object cashAllocation) {
		if (this == cashAllocation) {
			return true;
		}
		if (cashAllocation == null || this.getClass() != cashAllocation.getClass()) {
			return false;
		}
		if (!super.equals(cashAllocation)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		CashAllocationEntity that = (CashAllocationEntity) cashAllocation;
		return
			Objects.equals(this.cashType, that.cashType) &&
			Objects.equals(
			     this.allocatedDate != null ? this.allocatedDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.allocatedDate != null ? that.allocatedDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.sourceDate != null ? this.sourceDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.sourceDate != null ? that.sourceDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.cashNumber, that.cashNumber) &&
			Objects.equals(this.sourceDocumentType, that.sourceDocumentType) &&
			Objects.equals(this.sourceNumber, that.sourceNumber) &&
			Objects.equals(this.sourceAmount, that.sourceAmount) &&
			Objects.equals(this.outstandingAmount, that.outstandingAmount) &&
			Objects.equals(this.allocatedAmount, that.allocatedAmount);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
