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
import kmsweb.dtos.DoctorScheduleEntityDto;
import kmsweb.entities.listeners.DoctorScheduleEntityListener;
import kmsweb.serializers.DoctorScheduleSerializer;
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
@EntityListeners({DoctorScheduleEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = DoctorScheduleSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class DoctorScheduleEntity extends AbstractEntity {

	/**
	 * Takes a DoctorScheduleEntityDto and converts it into a DoctorScheduleEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param doctorScheduleEntityDto
	 */
	public DoctorScheduleEntity(DoctorScheduleEntityDto doctorScheduleEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (doctorScheduleEntityDto.getId() != null) {
			this.setId(doctorScheduleEntityDto.getId());
		}

		if (doctorScheduleEntityDto.getStartDateTime() != null) {
			this.setStartDateTime(doctorScheduleEntityDto.getStartDateTime());
		}

		if (doctorScheduleEntityDto.getEndDateTime() != null) {
			this.setEndDateTime(doctorScheduleEntityDto.getEndDateTime());
		}

		if (doctorScheduleEntityDto.getIntervalInMinutes() != null) {
			this.setIntervalInMinutes(doctorScheduleEntityDto.getIntervalInMinutes());
		}

		if (doctorScheduleEntityDto.getLocation() != null) {
			this.setLocation(doctorScheduleEntityDto.getLocation());
		}

		if (doctorScheduleEntityDto.getSchedulerType() != null) {
			this.setSchedulerType(doctorScheduleEntityDto.getSchedulerType());
		}

		if (doctorScheduleEntityDto.getMonday() != null) {
			this.setMonday(doctorScheduleEntityDto.getMonday());
		}

		if (doctorScheduleEntityDto.getTuesday() != null) {
			this.setTuesday(doctorScheduleEntityDto.getTuesday());
		}

		if (doctorScheduleEntityDto.getWednesday() != null) {
			this.setWednesday(doctorScheduleEntityDto.getWednesday());
		}

		if (doctorScheduleEntityDto.getThursday() != null) {
			this.setThursday(doctorScheduleEntityDto.getThursday());
		}

		if (doctorScheduleEntityDto.getFriday() != null) {
			this.setFriday(doctorScheduleEntityDto.getFriday());
		}

		if (doctorScheduleEntityDto.getSaturday() != null) {
			this.setSaturday(doctorScheduleEntityDto.getSaturday());
		}

		if (doctorScheduleEntityDto.getSunday() != null) {
			this.setSunday(doctorScheduleEntityDto.getSunday());
		}

		if (doctorScheduleEntityDto.getEmail() != null) {
			this.setEmail(doctorScheduleEntityDto.getEmail());
		}

		if (doctorScheduleEntityDto.getTraining() != null) {
			this.setTraining(doctorScheduleEntityDto.getTraining());
		}

		if (doctorScheduleEntityDto.getDismissalDate() != null) {
			this.setDismissalDate(doctorScheduleEntityDto.getDismissalDate());
		}

		if (doctorScheduleEntityDto.getShift() != null) {
			this.setShift(doctorScheduleEntityDto.getShift());
		}

		if (doctorScheduleEntityDto.getIntervals() != null) {
			this.setIntervals(doctorScheduleEntityDto.getIntervals());
		}

		if (doctorScheduleEntityDto.getRepetition() != null) {
			this.setRepetition(doctorScheduleEntityDto.getRepetition());
		}

		if (doctorScheduleEntityDto.getNumberOfRepetition() != null) {
			this.setNumberOfRepetition(doctorScheduleEntityDto.getNumberOfRepetition());
		}

		if (doctorScheduleEntityDto.getFinalSchedule() != null) {
			this.setFinalSchedule(doctorScheduleEntityDto.getFinalSchedule());
		}

		if (doctorScheduleEntityDto.getService() != null) {
			this.setService(doctorScheduleEntityDto.getService());
		}

		if (doctorScheduleEntityDto.getStaff() != null) {
			this.setStaff(doctorScheduleEntityDto.getStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Start Date Time here] off begin

	@CsvCustomBindByName(column = "START_DATE_TIME", converter = DateTimeConverter.class, required = true)
	@NotNull(message = "Start Date Time must not be empty")
	@Column(name = "start_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Start Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Start Date Time here] end
	private OffsetDateTime startDateTime;

	// % protected region % [Modify attribute annotation for End Date Time here] off begin

	@CsvCustomBindByName(column = "END_DATE_TIME", converter = DateTimeConverter.class, required = true)
	@NotNull(message = "End Date Time must not be empty")
	@Column(name = "end_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The End Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for End Date Time here] end
	private OffsetDateTime endDateTime;

	// % protected region % [Modify attribute annotation for Interval in minutes here] off begin
	@CsvBindByName(column = "INTERVAL_IN_MINUTES", required = false)
	@Nullable
	@Column(name = "interval_in_minutes")
	@Schema(description = "The Interval in minutes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Interval in minutes here] end
	private Integer intervalInMinutes;

	// % protected region % [Modify attribute annotation for Location here] off begin
	@CsvBindByName(column = "LOCATION", required = false)
	@Nullable
	@Column(name = "location")
	@Schema(description = "The Location of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Location here] end
	private String location;

	// % protected region % [Modify attribute annotation for Scheduler Type here] off begin
	@CsvBindByName(column = "SCHEDULER_TYPE", required = true)
	@NotNull(message = "Scheduler Type must not be empty")
	@Column(name = "scheduler_type")
	@Schema(description = "The Scheduler Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Scheduler Type here] end
	private String schedulerType;

	// % protected region % [Modify attribute annotation for Monday here] off begin
	@CsvBindByName(column = "MONDAY", required = false)
	@Nullable
	@Column(name = "monday")
	@Schema(description = "The Monday of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Monday here] end
	private Boolean monday = false ;

	// % protected region % [Modify attribute annotation for Tuesday here] off begin
	@CsvBindByName(column = "TUESDAY", required = false)
	@Nullable
	@Column(name = "tuesday")
	@Schema(description = "The Tuesday of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tuesday here] end
	private Boolean tuesday = false ;

	// % protected region % [Modify attribute annotation for Wednesday here] off begin
	@CsvBindByName(column = "WEDNESDAY", required = false)
	@Nullable
	@Column(name = "wednesday")
	@Schema(description = "The Wednesday of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Wednesday here] end
	private Boolean wednesday = false ;

	// % protected region % [Modify attribute annotation for Thursday here] off begin
	@CsvBindByName(column = "THURSDAY", required = false)
	@Nullable
	@Column(name = "thursday")
	@Schema(description = "The Thursday of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Thursday here] end
	private Boolean thursday = false ;

	// % protected region % [Modify attribute annotation for Friday here] off begin
	@CsvBindByName(column = "FRIDAY", required = false)
	@Nullable
	@Column(name = "friday")
	@Schema(description = "The Friday of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Friday here] end
	private Boolean friday = false ;

	// % protected region % [Modify attribute annotation for Saturday here] off begin
	@CsvBindByName(column = "SATURDAY", required = false)
	@Nullable
	@Column(name = "saturday")
	@Schema(description = "The Saturday of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Saturday here] end
	private Boolean saturday = false ;

	// % protected region % [Modify attribute annotation for Sunday here] off begin
	@CsvBindByName(column = "SUNDAY", required = false)
	@Nullable
	@Column(name = "sunday")
	@Schema(description = "The Sunday of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sunday here] end
	private Boolean sunday = false ;

	// % protected region % [Modify attribute annotation for Email here] off begin
	@CsvBindByName(column = "EMAIL", required = false)
	@Nullable
	@Column(name = "email")
	@Schema(description = "The Email of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

	// % protected region % [Modify attribute annotation for Training here] off begin
	@CsvBindByName(column = "TRAINING", required = false)
	@Nullable
	@Column(name = "training")
	@Schema(description = "The Training of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Training here] end
	private String training;

	// % protected region % [Modify attribute annotation for Dismissal Date here] off begin

	@CsvCustomBindByName(column = "DISMISSAL_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "dismissal_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Dismissal Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dismissal Date here] end
	private OffsetDateTime dismissalDate;

	// % protected region % [Modify attribute annotation for Shift here] off begin
	@CsvBindByName(column = "SHIFT", required = false)
	@Nullable
	@Column(name = "shift")
	@Schema(description = "The Shift of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Shift here] end
	private String shift;

	// % protected region % [Modify attribute annotation for Intervals here] off begin
	@CsvBindByName(column = "INTERVALS", required = false)
	@Nullable
	@Column(name = "intervals")
	@Schema(description = "The Intervals of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Intervals here] end
	private Integer intervals;

	// % protected region % [Modify attribute annotation for Repetition here] off begin
	@CsvBindByName(column = "REPETITION", required = false)
	@Nullable
	@Column(name = "repetition")
	@Schema(description = "The Repetition of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Repetition here] end
	private Boolean repetition = false ;

	// % protected region % [Modify attribute annotation for Number Of Repetition here] off begin
	@CsvBindByName(column = "NUMBER_OF_REPETITION", required = false)
	@Nullable
	@Column(name = "number_of_repetition")
	@Schema(description = "The Number Of Repetition of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Number Of Repetition here] end
	private Integer numberOfRepetition;

	// % protected region % [Modify attribute annotation for Final Schedule here] off begin

	@CsvCustomBindByName(column = "FINAL_SCHEDULE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "final_schedule")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Final Schedule of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Final Schedule here] end
	private OffsetDateTime finalSchedule;

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

	// % protected region % [Update the annotation for Service here] off begin
	@Schema(description = "The Service entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Service here] end
	private ServiceEntity service;

	// % protected region % [Update the annotation for serviceId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SERVICE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for serviceId here] end
	private UUID serviceId;

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
	 * Similar to {@link this#setService(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be set to this entity
	 */
	public void setService(@NotNull ServiceEntity entity) {
		setService(entity, true);
	}

	/**
	 * Set or update the service in this entity with single ServiceEntity.
	 *
	 * @param entity the given ServiceEntity to be set or updated to service
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setService(@NotNull ServiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setService here] off begin
		// % protected region % [Add any additional logic here before the main logic for setService here] end

		if (sameAsFormer(this.service, entity)) {
			return;
		}

		if (this.service != null) {
			this.service.removeDoctorSchedules(this, false);
		}
		this.service = entity;
		if (reverseAdd) {
			this.service.addDoctorSchedules(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setService incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setService incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetService(boolean)} but default to true.
	 */
	public void unsetService() {
		this.unsetService(true);
	}

	/**
	 * Remove Service in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetService(boolean reverse) {
		if (reverse && this.service != null) {
			this.service.removeDoctorSchedules(this, false);
		}
		this.service = null;
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
			this.staff.removeDoctorSchedules(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addDoctorSchedules(this, false);
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
			this.staff.removeDoctorSchedules(this, false);
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
		return "START_DATE_TIME,END_DATE_TIME,INTERVAL_IN_MINUTES,LOCATION,SCHEDULER_TYPE,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY,EMAIL,TRAINING,DISMISSAL_DATE,SHIFT,INTERVALS,REPETITION,NUMBER_OF_REPETITION,FINAL_SCHEDULE,SERVICE_ID,STAFF_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<ServiceEntity> serviceRelation = Optional.ofNullable(this.service);
		serviceRelation.ifPresent(entity -> this.serviceId = entity.getId());

		Optional<StaffEntity> staffRelation = Optional.ofNullable(this.staff);
		staffRelation.ifPresent(entity -> this.staffId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object doctorSchedule) {
		if (this == doctorSchedule) {
			return true;
		}
		if (doctorSchedule == null || this.getClass() != doctorSchedule.getClass()) {
			return false;
		}
		if (!super.equals(doctorSchedule)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		DoctorScheduleEntity that = (DoctorScheduleEntity) doctorSchedule;
		return
			Objects.equals(
			     this.startDateTime != null ? this.startDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.startDateTime != null ? that.startDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.endDateTime != null ? this.endDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.endDateTime != null ? that.endDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.intervalInMinutes, that.intervalInMinutes) &&
			Objects.equals(this.location, that.location) &&
			Objects.equals(this.schedulerType, that.schedulerType) &&
			Objects.equals(this.monday, that.monday) &&
			Objects.equals(this.tuesday, that.tuesday) &&
			Objects.equals(this.wednesday, that.wednesday) &&
			Objects.equals(this.thursday, that.thursday) &&
			Objects.equals(this.friday, that.friday) &&
			Objects.equals(this.saturday, that.saturday) &&
			Objects.equals(this.sunday, that.sunday) &&
			Objects.equals(this.email, that.email) &&
			Objects.equals(this.training, that.training) &&
			Objects.equals(
			     this.dismissalDate != null ? this.dismissalDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.dismissalDate != null ? that.dismissalDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.shift, that.shift) &&
			Objects.equals(this.intervals, that.intervals) &&
			Objects.equals(this.repetition, that.repetition) &&
			Objects.equals(this.numberOfRepetition, that.numberOfRepetition) &&
			Objects.equals(
			     this.finalSchedule != null ? this.finalSchedule.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.finalSchedule != null ? that.finalSchedule.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.serviceId, that.serviceId) &&
			Objects.equals(this.staffId, that.staffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
