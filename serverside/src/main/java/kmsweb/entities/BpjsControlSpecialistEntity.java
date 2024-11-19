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
import kmsweb.dtos.BpjsControlSpecialistEntityDto;
import kmsweb.entities.listeners.BpjsControlSpecialistEntityListener;
import kmsweb.serializers.BpjsControlSpecialistSerializer;
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
@EntityListeners({BpjsControlSpecialistEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsControlSpecialistSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsControlSpecialistEntity extends AbstractEntity {

	/**
	 * Takes a BpjsControlSpecialistEntityDto and converts it into a BpjsControlSpecialistEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsControlSpecialistEntityDto
	 */
	public BpjsControlSpecialistEntity(BpjsControlSpecialistEntityDto bpjsControlSpecialistEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsControlSpecialistEntityDto.getId() != null) {
			this.setId(bpjsControlSpecialistEntityDto.getId());
		}

		if (bpjsControlSpecialistEntityDto.getSpecialistCode() != null) {
			this.setSpecialistCode(bpjsControlSpecialistEntityDto.getSpecialistCode());
		}

		if (bpjsControlSpecialistEntityDto.getSpecialistName() != null) {
			this.setSpecialistName(bpjsControlSpecialistEntityDto.getSpecialistName());
		}

		if (bpjsControlSpecialistEntityDto.getCapacity() != null) {
			this.setCapacity(bpjsControlSpecialistEntityDto.getCapacity());
		}

		if (bpjsControlSpecialistEntityDto.getTotalControlPlanReferral() != null) {
			this.setTotalControlPlanReferral(bpjsControlSpecialistEntityDto.getTotalControlPlanReferral());
		}

		if (bpjsControlSpecialistEntityDto.getPercentage() != null) {
			this.setPercentage(bpjsControlSpecialistEntityDto.getPercentage());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Specialist Code here] off begin
	@CsvBindByName(column = "SPECIALIST_CODE", required = false)
	@Nullable
	@Column(name = "specialist_code")
	@Schema(description = "The Specialist Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Specialist Code here] end
	private String specialistCode;

	// % protected region % [Modify attribute annotation for Specialist Name here] off begin
	@CsvBindByName(column = "SPECIALIST_NAME", required = false)
	@Nullable
	@Column(name = "specialist_name")
	@Schema(description = "The Specialist Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Specialist Name here] end
	private String specialistName;

	// % protected region % [Modify attribute annotation for Capacity here] off begin
	@CsvBindByName(column = "CAPACITY", required = false)
	@Nullable
	@Column(name = "capacity")
	@Schema(description = "The Capacity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Capacity here] end
	private String capacity;

	// % protected region % [Modify attribute annotation for Total Control Plan Referral here] off begin
	@CsvBindByName(column = "TOTAL_CONTROL_PLAN_REFERRAL", required = false)
	@Nullable
	@Column(name = "total_control_plan_referral")
	@Schema(description = "The Total Control Plan Referral of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Control Plan Referral here] end
	private String totalControlPlanReferral;

	// % protected region % [Modify attribute annotation for Percentage here] off begin
	@CsvBindByName(column = "PERCENTAGE", required = false)
	@Nullable
	@Column(name = "percentage")
	@Schema(description = "The Percentage of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Percentage here] end
	private String percentage;

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
		return "SPECIALIST_CODE,SPECIALIST_NAME,CAPACITY,TOTAL_CONTROL_PLAN_REFERRAL,PERCENTAGE,ID";
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
	public boolean equals(Object bpjsControlSpecialist) {
		if (this == bpjsControlSpecialist) {
			return true;
		}
		if (bpjsControlSpecialist == null || this.getClass() != bpjsControlSpecialist.getClass()) {
			return false;
		}
		if (!super.equals(bpjsControlSpecialist)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsControlSpecialistEntity that = (BpjsControlSpecialistEntity) bpjsControlSpecialist;
		return
			Objects.equals(this.specialistCode, that.specialistCode) &&
			Objects.equals(this.specialistName, that.specialistName) &&
			Objects.equals(this.capacity, that.capacity) &&
			Objects.equals(this.totalControlPlanReferral, that.totalControlPlanReferral) &&
			Objects.equals(this.percentage, that.percentage);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
