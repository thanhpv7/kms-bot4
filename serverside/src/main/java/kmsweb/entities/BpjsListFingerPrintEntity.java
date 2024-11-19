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
import kmsweb.dtos.BpjsListFingerPrintEntityDto;
import kmsweb.entities.listeners.BpjsListFingerPrintEntityListener;
import kmsweb.serializers.BpjsListFingerPrintSerializer;
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
@EntityListeners({BpjsListFingerPrintEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsListFingerPrintSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsListFingerPrintEntity extends AbstractEntity {

	/**
	 * Takes a BpjsListFingerPrintEntityDto and converts it into a BpjsListFingerPrintEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsListFingerPrintEntityDto
	 */
	public BpjsListFingerPrintEntity(BpjsListFingerPrintEntityDto bpjsListFingerPrintEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsListFingerPrintEntityDto.getId() != null) {
			this.setId(bpjsListFingerPrintEntityDto.getId());
		}

		if (bpjsListFingerPrintEntityDto.getBpjsCardNo() != null) {
			this.setBpjsCardNo(bpjsListFingerPrintEntityDto.getBpjsCardNo());
		}

		if (bpjsListFingerPrintEntityDto.getVisitDate() != null) {
			this.setVisitDate(bpjsListFingerPrintEntityDto.getVisitDate());
		}

		if (bpjsListFingerPrintEntityDto.getSepNo() != null) {
			this.setSepNo(bpjsListFingerPrintEntityDto.getSepNo());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Bpjs Card No here] off begin
	@CsvBindByName(column = "BPJS_CARD_NO", required = false)
	@Nullable
	@Column(name = "bpjs_card_no")
	@Schema(description = "The Bpjs Card No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Bpjs Card No here] end
	private String bpjsCardNo;

	// % protected region % [Modify attribute annotation for Visit Date here] off begin
	@CsvCustomBindByName(column = "VISIT_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "visit_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Visit Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Visit Date here] end
	private OffsetDateTime visitDate;

	// % protected region % [Modify attribute annotation for Sep No here] off begin
	@CsvBindByName(column = "SEP_NO", required = false)
	@Nullable
	@Column(name = "sep_no")
	@Schema(description = "The Sep No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sep No here] end
	private String sepNo;

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
		return "BPJS_CARD_NO,VISIT_DATE,SEP_NO,ID";
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
	public boolean equals(Object bpjsListFingerPrint) {
		if (this == bpjsListFingerPrint) {
			return true;
		}
		if (bpjsListFingerPrint == null || this.getClass() != bpjsListFingerPrint.getClass()) {
			return false;
		}
		if (!super.equals(bpjsListFingerPrint)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsListFingerPrintEntity that = (BpjsListFingerPrintEntity) bpjsListFingerPrint;
		return
			Objects.equals(this.bpjsCardNo, that.bpjsCardNo) &&
			Objects.equals(
			     this.visitDate != null ? this.visitDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.visitDate != null ? that.visitDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.sepNo, that.sepNo);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
