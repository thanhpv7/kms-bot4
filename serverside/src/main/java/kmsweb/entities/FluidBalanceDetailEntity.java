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
import kmsweb.dtos.FluidBalanceDetailEntityDto;
import kmsweb.entities.listeners.FluidBalanceDetailEntityListener;
import kmsweb.serializers.FluidBalanceDetailSerializer;
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
@EntityListeners({FluidBalanceDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = FluidBalanceDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class FluidBalanceDetailEntity extends AbstractEntity {

	/**
	 * Takes a FluidBalanceDetailEntityDto and converts it into a FluidBalanceDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param fluidBalanceDetailEntityDto
	 */
	public FluidBalanceDetailEntity(FluidBalanceDetailEntityDto fluidBalanceDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (fluidBalanceDetailEntityDto.getId() != null) {
			this.setId(fluidBalanceDetailEntityDto.getId());
		}

		if (fluidBalanceDetailEntityDto.getRecordDateTime() != null) {
			this.setRecordDateTime(fluidBalanceDetailEntityDto.getRecordDateTime());
		}

		if (fluidBalanceDetailEntityDto.getIntakeOral() != null) {
			this.setIntakeOral(fluidBalanceDetailEntityDto.getIntakeOral());
		}

		if (fluidBalanceDetailEntityDto.getIntakeNGT() != null) {
			this.setIntakeNGT(fluidBalanceDetailEntityDto.getIntakeNGT());
		}

		if (fluidBalanceDetailEntityDto.getIntakeIVLine() != null) {
			this.setIntakeIVLine(fluidBalanceDetailEntityDto.getIntakeIVLine());
		}

		if (fluidBalanceDetailEntityDto.getIntakeOthers() != null) {
			this.setIntakeOthers(fluidBalanceDetailEntityDto.getIntakeOthers());
		}

		if (fluidBalanceDetailEntityDto.getOutputUrine() != null) {
			this.setOutputUrine(fluidBalanceDetailEntityDto.getOutputUrine());
		}

		if (fluidBalanceDetailEntityDto.getOutputNGT() != null) {
			this.setOutputNGT(fluidBalanceDetailEntityDto.getOutputNGT());
		}

		if (fluidBalanceDetailEntityDto.getOutputDrain() != null) {
			this.setOutputDrain(fluidBalanceDetailEntityDto.getOutputDrain());
		}

		if (fluidBalanceDetailEntityDto.getOutputStool() != null) {
			this.setOutputStool(fluidBalanceDetailEntityDto.getOutputStool());
		}

		if (fluidBalanceDetailEntityDto.getOutputBlood() != null) {
			this.setOutputBlood(fluidBalanceDetailEntityDto.getOutputBlood());
		}

		if (fluidBalanceDetailEntityDto.getOutputIWL() != null) {
			this.setOutputIWL(fluidBalanceDetailEntityDto.getOutputIWL());
		}

		if (fluidBalanceDetailEntityDto.getOutputOthers() != null) {
			this.setOutputOthers(fluidBalanceDetailEntityDto.getOutputOthers());
		}

		if (fluidBalanceDetailEntityDto.getNotes() != null) {
			this.setNotes(fluidBalanceDetailEntityDto.getNotes());
		}

		if (fluidBalanceDetailEntityDto.getTotalInput() != null) {
			this.setTotalInput(fluidBalanceDetailEntityDto.getTotalInput());
		}

		if (fluidBalanceDetailEntityDto.getTotalOutput() != null) {
			this.setTotalOutput(fluidBalanceDetailEntityDto.getTotalOutput());
		}

		if (fluidBalanceDetailEntityDto.getTotalBalanceFluid() != null) {
			this.setTotalBalanceFluid(fluidBalanceDetailEntityDto.getTotalBalanceFluid());
		}

		if (fluidBalanceDetailEntityDto.getRegistration() != null) {
			this.setRegistration(fluidBalanceDetailEntityDto.getRegistration());
		}

		if (fluidBalanceDetailEntityDto.getStaff() != null) {
			this.setStaff(fluidBalanceDetailEntityDto.getStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Record Date Time here] off begin

	@CsvCustomBindByName(column = "RECORD_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "record_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Record Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Record Date Time here] end
	private OffsetDateTime recordDateTime;

	// % protected region % [Modify attribute annotation for Intake Oral here] off begin
	@CsvBindByName(column = "INTAKE_ORAL", required = false)
	@Nullable
	@Column(name = "intake_oral")
	@Schema(description = "The Intake Oral of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Intake Oral here] end
	private Double intakeOral;

	// % protected region % [Modify attribute annotation for Intake NGT here] off begin
	@CsvBindByName(column = "INTAKE_NGT", required = false)
	@Nullable
	@Column(name = "intake_ngt")
	@Schema(description = "The Intake NGT of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Intake NGT here] end
	private Double intakeNGT;

	// % protected region % [Modify attribute annotation for Intake IV Line here] off begin
	@CsvBindByName(column = "INTAKE_IV_LINE", required = false)
	@Nullable
	@Column(name = "intake_iv_line")
	@Schema(description = "The Intake IV Line of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Intake IV Line here] end
	private Double intakeIVLine;

	// % protected region % [Modify attribute annotation for Intake Others here] off begin
	@CsvBindByName(column = "INTAKE_OTHERS", required = false)
	@Nullable
	@Column(name = "intake_others")
	@Schema(description = "The Intake Others of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Intake Others here] end
	private Double intakeOthers;

	// % protected region % [Modify attribute annotation for Output Urine here] off begin
	@CsvBindByName(column = "OUTPUT_URINE", required = false)
	@Nullable
	@Column(name = "output_urine")
	@Schema(description = "The Output Urine of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Output Urine here] end
	private Double outputUrine;

	// % protected region % [Modify attribute annotation for Output NGT here] off begin
	@CsvBindByName(column = "OUTPUT_NGT", required = false)
	@Nullable
	@Column(name = "output_ngt")
	@Schema(description = "The Output NGT of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Output NGT here] end
	private Double outputNGT;

	// % protected region % [Modify attribute annotation for Output Drain here] off begin
	@CsvBindByName(column = "OUTPUT_DRAIN", required = false)
	@Nullable
	@Column(name = "output_drain")
	@Schema(description = "The Output Drain of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Output Drain here] end
	private Double outputDrain;

	// % protected region % [Modify attribute annotation for Output Stool here] off begin
	@CsvBindByName(column = "OUTPUT_STOOL", required = false)
	@Nullable
	@Column(name = "output_stool")
	@Schema(description = "The Output Stool of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Output Stool here] end
	private Double outputStool;

	// % protected region % [Modify attribute annotation for Output Blood here] off begin
	@CsvBindByName(column = "OUTPUT_BLOOD", required = false)
	@Nullable
	@Column(name = "output_blood")
	@Schema(description = "The Output Blood of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Output Blood here] end
	private Double outputBlood;

	// % protected region % [Modify attribute annotation for Output IWL here] off begin
	@CsvBindByName(column = "OUTPUT_IWL", required = false)
	@Nullable
	@Column(name = "output_iwl")
	@Schema(description = "The Output IWL of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Output IWL here] end
	private Double outputIWL;

	// % protected region % [Modify attribute annotation for Output Others here] off begin
	@CsvBindByName(column = "OUTPUT_OTHERS", required = false)
	@Nullable
	@Column(name = "output_others")
	@Schema(description = "The Output Others of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Output Others here] end
	private Double outputOthers;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Total Input here] off begin
	@CsvBindByName(column = "TOTAL_INPUT", required = false)
	@Nullable
	@Column(name = "total_input")
	@Schema(description = "The Total Input of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Input here] end
	private Double totalInput;

	// % protected region % [Modify attribute annotation for Total Output here] off begin
	@CsvBindByName(column = "TOTAL_OUTPUT", required = false)
	@Nullable
	@Column(name = "total_output")
	@Schema(description = "The Total Output of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Output here] end
	private Double totalOutput;

	// % protected region % [Modify attribute annotation for Total Balance Fluid here] off begin
	@CsvBindByName(column = "TOTAL_BALANCE_FLUID", required = false)
	@Nullable
	@Column(name = "total_balance_fluid")
	@Schema(description = "The Total Balance Fluid of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Balance Fluid here] end
	private Double totalBalanceFluid;

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

	// % protected region % [Update the annotation for Registration here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Registration here] end
	private RegistrationEntity registration;

	// % protected region % [Update the annotation for registrationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "REGISTRATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for registrationId here] end
	private UUID registrationId;

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
	 * Similar to {@link this#setRegistration(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setRegistration(@NotNull RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update the registration in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to registration
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(@NotNull RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.removeFluidBalanceDetails(this, false);
		}
		this.registration = entity;
		if (reverseAdd) {
			this.registration.addFluidBalanceDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove Registration in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.removeFluidBalanceDetails(this, false);
		}
		this.registration = null;
	}
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
			this.staff.removeFluidBalanceDetails(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addFluidBalanceDetails(this, false);
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
			this.staff.removeFluidBalanceDetails(this, false);
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
		return "RECORD_DATE_TIME,INTAKE_ORAL,INTAKE_NGT,INTAKE_IV_LINE,INTAKE_OTHERS,OUTPUT_URINE,OUTPUT_NGT,OUTPUT_DRAIN,OUTPUT_STOOL,OUTPUT_BLOOD,OUTPUT_IWL,OUTPUT_OTHERS,NOTES,TOTAL_INPUT,TOTAL_OUTPUT,TOTAL_BALANCE_FLUID,REGISTRATION_ID,STAFF_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<RegistrationEntity> registrationRelation = Optional.ofNullable(this.registration);
		registrationRelation.ifPresent(entity -> this.registrationId = entity.getId());

		Optional<StaffEntity> staffRelation = Optional.ofNullable(this.staff);
		staffRelation.ifPresent(entity -> this.staffId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object fluidBalanceDetail) {
		if (this == fluidBalanceDetail) {
			return true;
		}
		if (fluidBalanceDetail == null || this.getClass() != fluidBalanceDetail.getClass()) {
			return false;
		}
		if (!super.equals(fluidBalanceDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		FluidBalanceDetailEntity that = (FluidBalanceDetailEntity) fluidBalanceDetail;
		return
			Objects.equals(
			     this.recordDateTime != null ? this.recordDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.recordDateTime != null ? that.recordDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.intakeOral, that.intakeOral) &&
			Objects.equals(this.intakeNGT, that.intakeNGT) &&
			Objects.equals(this.intakeIVLine, that.intakeIVLine) &&
			Objects.equals(this.intakeOthers, that.intakeOthers) &&
			Objects.equals(this.outputUrine, that.outputUrine) &&
			Objects.equals(this.outputNGT, that.outputNGT) &&
			Objects.equals(this.outputDrain, that.outputDrain) &&
			Objects.equals(this.outputStool, that.outputStool) &&
			Objects.equals(this.outputBlood, that.outputBlood) &&
			Objects.equals(this.outputIWL, that.outputIWL) &&
			Objects.equals(this.outputOthers, that.outputOthers) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.totalInput, that.totalInput) &&
			Objects.equals(this.totalOutput, that.totalOutput) &&
			Objects.equals(this.totalBalanceFluid, that.totalBalanceFluid) &&
			Objects.equals(this.registrationId, that.registrationId) &&
			Objects.equals(this.staffId, that.staffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
