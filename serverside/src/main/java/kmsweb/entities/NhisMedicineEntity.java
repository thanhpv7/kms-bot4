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
import kmsweb.dtos.NhisMedicineEntityDto;
import kmsweb.entities.listeners.NhisMedicineEntityListener;
import kmsweb.serializers.NhisMedicineSerializer;
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
@EntityListeners({NhisMedicineEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = NhisMedicineSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class NhisMedicineEntity extends AbstractEntity {

	/**
	 * Takes a NhisMedicineEntityDto and converts it into a NhisMedicineEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param nhisMedicineEntityDto
	 */
	public NhisMedicineEntity(NhisMedicineEntityDto nhisMedicineEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (nhisMedicineEntityDto.getId() != null) {
			this.setId(nhisMedicineEntityDto.getId());
		}

		if (nhisMedicineEntityDto.getMedicineCode() != null) {
			this.setMedicineCode(nhisMedicineEntityDto.getMedicineCode());
		}

		if (nhisMedicineEntityDto.getMedicineName() != null) {
			this.setMedicineName(nhisMedicineEntityDto.getMedicineName());
		}

		if (nhisMedicineEntityDto.getDose() != null) {
			this.setDose(nhisMedicineEntityDto.getDose());
		}

		if (nhisMedicineEntityDto.getUoi() != null) {
			this.setUoi(nhisMedicineEntityDto.getUoi());
		}

		if (nhisMedicineEntityDto.getFrequency() != null) {
			this.setFrequency(nhisMedicineEntityDto.getFrequency());
		}

		if (nhisMedicineEntityDto.getDuration() != null) {
			this.setDuration(nhisMedicineEntityDto.getDuration());
		}

		if (nhisMedicineEntityDto.getUnitPrice() != null) {
			this.setUnitPrice(nhisMedicineEntityDto.getUnitPrice());
		}

		if (nhisMedicineEntityDto.getDispensedQty() != null) {
			this.setDispensedQty(nhisMedicineEntityDto.getDispensedQty());
		}

		if (nhisMedicineEntityDto.getTotalCost() != null) {
			this.setTotalCost(nhisMedicineEntityDto.getTotalCost());
		}

		if (nhisMedicineEntityDto.getServiceDate() != null) {
			this.setServiceDate(nhisMedicineEntityDto.getServiceDate());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Medicine Code here] off begin
	@CsvBindByName(column = "MEDICINE_CODE", required = false)
	@Nullable
	@Column(name = "medicine_code")
	@Schema(description = "The Medicine Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Medicine Code here] end
	private String medicineCode;

	// % protected region % [Modify attribute annotation for Medicine Name here] off begin
	@CsvBindByName(column = "MEDICINE_NAME", required = false)
	@Nullable
	@Column(name = "medicine_name")
	@Schema(description = "The Medicine Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Medicine Name here] end
	private String medicineName;

	// % protected region % [Modify attribute annotation for Dose here] off begin
	@CsvBindByName(column = "DOSE", required = false)
	@Nullable
	@Column(name = "dose")
	@Schema(description = "The Dose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dose here] end
	private Double dose;

	// % protected region % [Modify attribute annotation for UOI here] off begin
	@CsvBindByName(column = "UOI", required = false)
	@Nullable
	@Column(name = "uoi")
	@Schema(description = "The UOI of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for UOI here] end
	private String uoi;

	// % protected region % [Modify attribute annotation for Frequency here] off begin
	@CsvBindByName(column = "FREQUENCY", required = false)
	@Nullable
	@Column(name = "frequency")
	@Schema(description = "The Frequency of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Frequency here] end
	private String frequency;

	// % protected region % [Modify attribute annotation for Duration here] off begin
	@CsvBindByName(column = "DURATION", required = false)
	@Nullable
	@Column(name = "duration")
	@Schema(description = "The Duration of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Duration here] end
	private Double duration;

	// % protected region % [Modify attribute annotation for Unit Price here] off begin
	@CsvBindByName(column = "UNIT_PRICE", required = false)
	@Nullable
	@Column(name = "unit_price")
	@Schema(description = "The Unit Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Unit Price here] end
	private Double unitPrice;

	// % protected region % [Modify attribute annotation for Dispensed Qty here] off begin
	@CsvBindByName(column = "DISPENSED_QTY", required = false)
	@Nullable
	@Column(name = "dispensed_qty")
	@Schema(description = "The Dispensed Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dispensed Qty here] end
	private Double dispensedQty;

	// % protected region % [Modify attribute annotation for Total Cost here] off begin
	@CsvBindByName(column = "TOTAL_COST", required = false)
	@Nullable
	@Column(name = "total_cost")
	@Schema(description = "The Total Cost of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Cost here] end
	private Double totalCost;

	// % protected region % [Modify attribute annotation for Service Date here] off begin

	@CsvCustomBindByName(column = "SERVICE_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "service_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Service Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Service Date here] end
	private OffsetDateTime serviceDate;

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
		return "MEDICINE_CODE,MEDICINE_NAME,DOSE,UOI,FREQUENCY,DURATION,UNIT_PRICE,DISPENSED_QTY,TOTAL_COST,SERVICE_DATE,ID";
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
	public boolean equals(Object nhisMedicine) {
		if (this == nhisMedicine) {
			return true;
		}
		if (nhisMedicine == null || this.getClass() != nhisMedicine.getClass()) {
			return false;
		}
		if (!super.equals(nhisMedicine)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		NhisMedicineEntity that = (NhisMedicineEntity) nhisMedicine;
		return
			Objects.equals(this.medicineCode, that.medicineCode) &&
			Objects.equals(this.medicineName, that.medicineName) &&
			Objects.equals(this.dose, that.dose) &&
			Objects.equals(this.uoi, that.uoi) &&
			Objects.equals(this.frequency, that.frequency) &&
			Objects.equals(this.duration, that.duration) &&
			Objects.equals(this.unitPrice, that.unitPrice) &&
			Objects.equals(this.dispensedQty, that.dispensedQty) &&
			Objects.equals(this.totalCost, that.totalCost) &&
			Objects.equals(
			     this.serviceDate != null ? this.serviceDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.serviceDate != null ? that.serviceDate.truncatedTo(ChronoUnit.DAYS) : null
			     );
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
