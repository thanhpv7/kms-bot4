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
import kmsweb.dtos.TaskDashboardEntityDto;
import kmsweb.entities.listeners.TaskDashboardEntityListener;
import kmsweb.serializers.TaskDashboardSerializer;
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
@EntityListeners({TaskDashboardEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = TaskDashboardSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class TaskDashboardEntity extends AbstractEntity {

	/**
	 * Takes a TaskDashboardEntityDto and converts it into a TaskDashboardEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param taskDashboardEntityDto
	 */
	public TaskDashboardEntity(TaskDashboardEntityDto taskDashboardEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (taskDashboardEntityDto.getId() != null) {
			this.setId(taskDashboardEntityDto.getId());
		}

		if (taskDashboardEntityDto.getKdppk() != null) {
			this.setKdppk(taskDashboardEntityDto.getKdppk());
		}

		if (taskDashboardEntityDto.getJumlahAntrean() != null) {
			this.setJumlahAntrean(taskDashboardEntityDto.getJumlahAntrean());
		}

		if (taskDashboardEntityDto.getNamapoli() != null) {
			this.setNamapoli(taskDashboardEntityDto.getNamapoli());
		}

		if (taskDashboardEntityDto.getNmppk() != null) {
			this.setNmppk(taskDashboardEntityDto.getNmppk());
		}

		if (taskDashboardEntityDto.getKodepoli() != null) {
			this.setKodepoli(taskDashboardEntityDto.getKodepoli());
		}

		if (taskDashboardEntityDto.getInsertDate() != null) {
			this.setInsertDate(taskDashboardEntityDto.getInsertDate());
		}

		if (taskDashboardEntityDto.getTanggal() != null) {
			this.setTanggal(taskDashboardEntityDto.getTanggal());
		}

		if (taskDashboardEntityDto.getWaktuTask1() != null) {
			this.setWaktuTask1(taskDashboardEntityDto.getWaktuTask1());
		}

		if (taskDashboardEntityDto.getWaktuTask2() != null) {
			this.setWaktuTask2(taskDashboardEntityDto.getWaktuTask2());
		}

		if (taskDashboardEntityDto.getWaktuTask3() != null) {
			this.setWaktuTask3(taskDashboardEntityDto.getWaktuTask3());
		}

		if (taskDashboardEntityDto.getWaktuTask4() != null) {
			this.setWaktuTask4(taskDashboardEntityDto.getWaktuTask4());
		}

		if (taskDashboardEntityDto.getWaktuTask5() != null) {
			this.setWaktuTask5(taskDashboardEntityDto.getWaktuTask5());
		}

		if (taskDashboardEntityDto.getWaktuTask6() != null) {
			this.setWaktuTask6(taskDashboardEntityDto.getWaktuTask6());
		}

		if (taskDashboardEntityDto.getAvgWaktuTask1() != null) {
			this.setAvgWaktuTask1(taskDashboardEntityDto.getAvgWaktuTask1());
		}

		if (taskDashboardEntityDto.getAvgWaktuTask2() != null) {
			this.setAvgWaktuTask2(taskDashboardEntityDto.getAvgWaktuTask2());
		}

		if (taskDashboardEntityDto.getAvgWaktuTask3() != null) {
			this.setAvgWaktuTask3(taskDashboardEntityDto.getAvgWaktuTask3());
		}

		if (taskDashboardEntityDto.getAvgWaktuTask4() != null) {
			this.setAvgWaktuTask4(taskDashboardEntityDto.getAvgWaktuTask4());
		}

		if (taskDashboardEntityDto.getAvgWaktuTask5() != null) {
			this.setAvgWaktuTask5(taskDashboardEntityDto.getAvgWaktuTask5());
		}

		if (taskDashboardEntityDto.getAvgWaktuTask6() != null) {
			this.setAvgWaktuTask6(taskDashboardEntityDto.getAvgWaktuTask6());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Kdppk here] off begin
	@CsvBindByName(column = "KDPPK", required = false)
	@Nullable
	@Column(name = "kdppk")
	@Schema(description = "The Kdppk of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Kdppk here] end
	private String kdppk;

	// % protected region % [Modify attribute annotation for Jumlah antrean here] off begin
	@CsvBindByName(column = "JUMLAH_ANTREAN", required = false)
	@Nullable
	@Column(name = "jumlah_antrean")
	@Schema(description = "The Jumlah antrean of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Jumlah antrean here] end
	private Integer jumlahAntrean;

	// % protected region % [Modify attribute annotation for Namapoli here] off begin
	@CsvBindByName(column = "NAMAPOLI", required = false)
	@Nullable
	@Column(name = "namapoli")
	@Schema(description = "The Namapoli of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Namapoli here] end
	private String namapoli;

	// % protected region % [Modify attribute annotation for Nmppk here] off begin
	@CsvBindByName(column = "NMPPK", required = false)
	@Nullable
	@Column(name = "nmppk")
	@Schema(description = "The Nmppk of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nmppk here] end
	private String nmppk;

	// % protected region % [Modify attribute annotation for Kodepoli here] off begin
	@CsvBindByName(column = "KODEPOLI", required = false)
	@Nullable
	@Column(name = "kodepoli")
	@Schema(description = "The Kodepoli of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Kodepoli here] end
	private String kodepoli;

	// % protected region % [Modify attribute annotation for Insert Date here] off begin
	@CsvCustomBindByName(column = "INSERT_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "insert_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Insert Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Insert Date here] end
	private OffsetDateTime insertDate;

	// % protected region % [Modify attribute annotation for tanggal here] off begin
	@CsvCustomBindByName(column = "TANGGAL", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "tanggal")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The tanggal of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tanggal here] end
	private OffsetDateTime tanggal;

	// % protected region % [Modify attribute annotation for Waktu Task1 here] off begin
	@CsvBindByName(column = "WAKTU_TASK1", required = false)
	@Nullable
	@Column(name = "waktu_task1")
	@Schema(description = "The Waktu Task1 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Waktu Task1 here] end
	private Integer waktuTask1;

	// % protected region % [Modify attribute annotation for Waktu Task2 here] off begin
	@CsvBindByName(column = "WAKTU_TASK2", required = false)
	@Nullable
	@Column(name = "waktu_task2")
	@Schema(description = "The Waktu Task2 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Waktu Task2 here] end
	private Integer waktuTask2;

	// % protected region % [Modify attribute annotation for Waktu Task3 here] off begin
	@CsvBindByName(column = "WAKTU_TASK3", required = false)
	@Nullable
	@Column(name = "waktu_task3")
	@Schema(description = "The Waktu Task3 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Waktu Task3 here] end
	private Integer waktuTask3;

	// % protected region % [Modify attribute annotation for Waktu Task4 here] off begin
	@CsvBindByName(column = "WAKTU_TASK4", required = false)
	@Nullable
	@Column(name = "waktu_task4")
	@Schema(description = "The Waktu Task4 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Waktu Task4 here] end
	private Integer waktuTask4;

	// % protected region % [Modify attribute annotation for Waktu Task5 here] off begin
	@CsvBindByName(column = "WAKTU_TASK5", required = false)
	@Nullable
	@Column(name = "waktu_task5")
	@Schema(description = "The Waktu Task5 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Waktu Task5 here] end
	private Integer waktuTask5;

	// % protected region % [Modify attribute annotation for Waktu Task6 here] off begin
	@CsvBindByName(column = "WAKTU_TASK6", required = false)
	@Nullable
	@Column(name = "waktu_task6")
	@Schema(description = "The Waktu Task6 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Waktu Task6 here] end
	private Integer waktuTask6;

	// % protected region % [Modify attribute annotation for avg waktu task1 here] off begin
	@CsvBindByName(column = "AVG_WAKTU_TASK1", required = false)
	@Nullable
	@Column(name = "avg_waktu_task1")
	@Schema(description = "The avg waktu task1 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for avg waktu task1 here] end
	private Integer avgWaktuTask1;

	// % protected region % [Modify attribute annotation for avg waktu task2 here] off begin
	@CsvBindByName(column = "AVG_WAKTU_TASK2", required = false)
	@Nullable
	@Column(name = "avg_waktu_task2")
	@Schema(description = "The avg waktu task2 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for avg waktu task2 here] end
	private Integer avgWaktuTask2;

	// % protected region % [Modify attribute annotation for avg waktu task3 here] off begin
	@CsvBindByName(column = "AVG_WAKTU_TASK3", required = false)
	@Nullable
	@Column(name = "avg_waktu_task3")
	@Schema(description = "The avg waktu task3 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for avg waktu task3 here] end
	private Integer avgWaktuTask3;

	// % protected region % [Modify attribute annotation for avg waktu task4 here] off begin
	@CsvBindByName(column = "AVG_WAKTU_TASK4", required = false)
	@Nullable
	@Column(name = "avg_waktu_task4")
	@Schema(description = "The avg waktu task4 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for avg waktu task4 here] end
	private Integer avgWaktuTask4;

	// % protected region % [Modify attribute annotation for avg waktu task5 here] off begin
	@CsvBindByName(column = "AVG_WAKTU_TASK5", required = false)
	@Nullable
	@Column(name = "avg_waktu_task5")
	@Schema(description = "The avg waktu task5 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for avg waktu task5 here] end
	private Integer avgWaktuTask5;

	// % protected region % [Modify attribute annotation for avg waktu task6 here] off begin
	@CsvBindByName(column = "AVG_WAKTU_TASK6", required = false)
	@Nullable
	@Column(name = "avg_waktu_task6")
	@Schema(description = "The avg waktu task6 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for avg waktu task6 here] end
	private Integer avgWaktuTask6;

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
		return "KDPPK,JUMLAH_ANTREAN,NAMAPOLI,NMPPK,KODEPOLI,INSERT_DATE,TANGGAL,WAKTU_TASK1,WAKTU_TASK2,WAKTU_TASK3,WAKTU_TASK4,WAKTU_TASK5,WAKTU_TASK6,AVG_WAKTU_TASK1,AVG_WAKTU_TASK2,AVG_WAKTU_TASK3,AVG_WAKTU_TASK4,AVG_WAKTU_TASK5,AVG_WAKTU_TASK6,ID";
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
	public boolean equals(Object taskDashboard) {
		if (this == taskDashboard) {
			return true;
		}
		if (taskDashboard == null || this.getClass() != taskDashboard.getClass()) {
			return false;
		}
		if (!super.equals(taskDashboard)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		TaskDashboardEntity that = (TaskDashboardEntity) taskDashboard;
		return
			Objects.equals(this.kdppk, that.kdppk) &&
			Objects.equals(this.jumlahAntrean, that.jumlahAntrean) &&
			Objects.equals(this.namapoli, that.namapoli) &&
			Objects.equals(this.nmppk, that.nmppk) &&
			Objects.equals(this.kodepoli, that.kodepoli) &&
			Objects.equals(
			     this.insertDate != null ? this.insertDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.insertDate != null ? that.insertDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.tanggal != null ? this.tanggal.truncatedTo(ChronoUnit.DAYS) : null,
			     that.tanggal != null ? that.tanggal.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.waktuTask1, that.waktuTask1) &&
			Objects.equals(this.waktuTask2, that.waktuTask2) &&
			Objects.equals(this.waktuTask3, that.waktuTask3) &&
			Objects.equals(this.waktuTask4, that.waktuTask4) &&
			Objects.equals(this.waktuTask5, that.waktuTask5) &&
			Objects.equals(this.waktuTask6, that.waktuTask6) &&
			Objects.equals(this.avgWaktuTask1, that.avgWaktuTask1) &&
			Objects.equals(this.avgWaktuTask2, that.avgWaktuTask2) &&
			Objects.equals(this.avgWaktuTask3, that.avgWaktuTask3) &&
			Objects.equals(this.avgWaktuTask4, that.avgWaktuTask4) &&
			Objects.equals(this.avgWaktuTask5, that.avgWaktuTask5) &&
			Objects.equals(this.avgWaktuTask6, that.avgWaktuTask6);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
