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
import kmsweb.dtos.BpjsFingerPrintEntityDto;
import kmsweb.entities.listeners.BpjsFingerPrintEntityListener;
import kmsweb.serializers.BpjsFingerPrintSerializer;
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
@EntityListeners({BpjsFingerPrintEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsFingerPrintSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsFingerPrintEntity extends AbstractEntity {

	/**
	 * Takes a BpjsFingerPrintEntityDto and converts it into a BpjsFingerPrintEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsFingerPrintEntityDto
	 */
	public BpjsFingerPrintEntity(BpjsFingerPrintEntityDto bpjsFingerPrintEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsFingerPrintEntityDto.getId() != null) {
			this.setId(bpjsFingerPrintEntityDto.getId());
		}

		if (bpjsFingerPrintEntityDto.getBpjsCardNo() != null) {
			this.setBpjsCardNo(bpjsFingerPrintEntityDto.getBpjsCardNo());
		}

		if (bpjsFingerPrintEntityDto.getVisitDate() != null) {
			this.setVisitDate(bpjsFingerPrintEntityDto.getVisitDate());
		}

		if (bpjsFingerPrintEntityDto.getCode() != null) {
			this.setCode(bpjsFingerPrintEntityDto.getCode());
		}

		if (bpjsFingerPrintEntityDto.getStatus() != null) {
			this.setStatus(bpjsFingerPrintEntityDto.getStatus());
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

	// % protected region % [Modify attribute annotation for Code here] off begin
	@CsvBindByName(column = "CODE", required = false)
	@Nullable
	@Column(name = "code")
	@Schema(description = "The Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Code here] end
	private String code;

	// % protected region % [Modify attribute annotation for Status here] off begin
	@CsvBindByName(column = "STATUS", required = false)
	@Nullable
	@Column(name = "status")
	@Schema(description = "The Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Status here] end
	private String status;

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
		return "BPJS_CARD_NO,VISIT_DATE,CODE,STATUS,ID";
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
	public boolean equals(Object bpjsFingerPrint) {
		if (this == bpjsFingerPrint) {
			return true;
		}
		if (bpjsFingerPrint == null || this.getClass() != bpjsFingerPrint.getClass()) {
			return false;
		}
		if (!super.equals(bpjsFingerPrint)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsFingerPrintEntity that = (BpjsFingerPrintEntity) bpjsFingerPrint;
		return
			Objects.equals(this.bpjsCardNo, that.bpjsCardNo) &&
			Objects.equals(
			     this.visitDate != null ? this.visitDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.visitDate != null ? that.visitDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.code, that.code) &&
			Objects.equals(this.status, that.status);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
