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
import kmsweb.dtos.ProcessWorkflowEntityDto;
import kmsweb.entities.enums.*;
import kmsweb.services.utils.converters.enums.*;
import kmsweb.entities.listeners.ProcessWorkflowEntityListener;
import kmsweb.serializers.ProcessWorkflowSerializer;
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
@EntityListeners({ProcessWorkflowEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = ProcessWorkflowSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class ProcessWorkflowEntity extends AbstractEntity {

	/**
	 * Takes a ProcessWorkflowEntityDto and converts it into a ProcessWorkflowEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param processWorkflowEntityDto
	 */
	public ProcessWorkflowEntity(ProcessWorkflowEntityDto processWorkflowEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (processWorkflowEntityDto.getId() != null) {
			this.setId(processWorkflowEntityDto.getId());
		}

		if (processWorkflowEntityDto.getStepNumber() != null) {
			this.setStepNumber(processWorkflowEntityDto.getStepNumber());
		}

		if (processWorkflowEntityDto.getModuleName() != null) {
			this.setModuleName(processWorkflowEntityDto.getModuleName());
		}

		if (processWorkflowEntityDto.getProcessName() != null) {
			this.setProcessName(processWorkflowEntityDto.getProcessName());
		}

		if (processWorkflowEntityDto.getReferenceID() != null) {
			this.setReferenceID(processWorkflowEntityDto.getReferenceID());
		}

		if (processWorkflowEntityDto.getProcessDateTime() != null) {
			this.setProcessDateTime(processWorkflowEntityDto.getProcessDateTime());
		}

		if (processWorkflowEntityDto.getStaff() != null) {
			this.setStaff(processWorkflowEntityDto.getStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Step Number here] off begin
	@CsvBindByName(column = "STEP_NUMBER", required = false)
	@Nullable
	@Column(name = "step_number")
	@Schema(description = "The Step Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Step Number here] end
	private Integer stepNumber;

	// % protected region % [Modify attribute annotation for Module Name here] off begin
	@CsvCustomBindByName(column = "MODULE_NAME", required = false, converter = ModuleNameEnumConverter.class)
	@Nullable
	@Column(name = "module_name")
	@Schema(description = "The Module Name of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Module Name here] end
	private ModuleNameEnum moduleName;

	// % protected region % [Modify attribute annotation for Process Name here] off begin
	@CsvBindByName(column = "PROCESS_NAME", required = false)
	@Nullable
	@Column(name = "process_name")
	@Schema(description = "The Process Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Process Name here] end
	private String processName;

	// % protected region % [Modify attribute annotation for Reference ID here] off begin
	@CsvBindByName(column = "REFERENCE_ID", required = false)
	@Nullable
	@Column(name = "reference_id")
	@Schema(description = "The Reference ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Reference ID here] end
	private String referenceID;

	// % protected region % [Modify attribute annotation for Process Date Time here] off begin

	@CsvCustomBindByName(column = "PROCESS_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "process_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Process Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Process Date Time here] end
	private OffsetDateTime processDateTime;

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

	// % protected region % [Update the annotation for Staff here] off begin
	@Schema(description = "The Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Staff here] end
	private StaffEntity staff;

	// % protected region % [Update the annotation for staffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for staffId here] end
	private UUID staffId;

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
	 * Similar to {@link this#setStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setStaff(@NotNull StaffEntity entity) {
		setStaff(entity, true);
	}

	/**
	 * Set or update the staff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to staff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStaff here] end

		if (sameAsFormer(this.staff, entity)) {
			return;
		}

		if (this.staff != null) {
			this.staff.removeProcessWorkflowLogs(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addProcessWorkflowLogs(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStaff(boolean)} but default to true.
	 */
	public void unsetStaff() {
		this.unsetStaff(true);
	}

	/**
	 * Remove Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStaff(boolean reverse) {
		if (reverse && this.staff != null) {
			this.staff.removeProcessWorkflowLogs(this, false);
		}
		this.staff = null;
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
		return "STEP_NUMBER,MODULE_NAME,PROCESS_NAME,REFERENCE_ID,PROCESS_DATE_TIME,STAFF_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<StaffEntity> staffRelation = Optional.ofNullable(this.staff);
		staffRelation.ifPresent(entity -> this.staffId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object processWorkflow) {
		if (this == processWorkflow) {
			return true;
		}
		if (processWorkflow == null || this.getClass() != processWorkflow.getClass()) {
			return false;
		}
		if (!super.equals(processWorkflow)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		ProcessWorkflowEntity that = (ProcessWorkflowEntity) processWorkflow;
		return
			Objects.equals(this.stepNumber, that.stepNumber) &&
			Objects.equals(this.moduleName, that.moduleName) &&
			Objects.equals(this.processName, that.processName) &&
			Objects.equals(this.referenceID, that.referenceID) &&
			Objects.equals(
			     this.processDateTime != null ? this.processDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.processDateTime != null ? that.processDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.staffId, that.staffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
