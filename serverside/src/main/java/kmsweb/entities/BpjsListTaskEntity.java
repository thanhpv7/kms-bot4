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
import kmsweb.dtos.BpjsListTaskEntityDto;
import kmsweb.entities.listeners.BpjsListTaskEntityListener;
import kmsweb.serializers.BpjsListTaskSerializer;
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
@EntityListeners({BpjsListTaskEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsListTaskSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsListTaskEntity extends AbstractEntity {

	/**
	 * Takes a BpjsListTaskEntityDto and converts it into a BpjsListTaskEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsListTaskEntityDto
	 */
	public BpjsListTaskEntity(BpjsListTaskEntityDto bpjsListTaskEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsListTaskEntityDto.getId() != null) {
			this.setId(bpjsListTaskEntityDto.getId());
		}

		if (bpjsListTaskEntityDto.getKodebooking() != null) {
			this.setKodebooking(bpjsListTaskEntityDto.getKodebooking());
		}

		if (bpjsListTaskEntityDto.getTaskname() != null) {
			this.setTaskname(bpjsListTaskEntityDto.getTaskname());
		}

		if (bpjsListTaskEntityDto.getTaskid() != null) {
			this.setTaskid(bpjsListTaskEntityDto.getTaskid());
		}

		if (bpjsListTaskEntityDto.getWaktu() != null) {
			this.setWaktu(bpjsListTaskEntityDto.getWaktu());
		}

		if (bpjsListTaskEntityDto.getWakturs() != null) {
			this.setWakturs(bpjsListTaskEntityDto.getWakturs());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Kodebooking here] off begin
	@CsvBindByName(column = "KODEBOOKING", required = false)
	@Nullable
	@Column(name = "kodebooking")
	@Schema(description = "The Kodebooking of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Kodebooking here] end
	private String kodebooking;

	// % protected region % [Modify attribute annotation for Taskname here] off begin
	@CsvBindByName(column = "TASKNAME", required = false)
	@Nullable
	@Column(name = "taskname")
	@Schema(description = "The Taskname of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Taskname here] end
	private String taskname;

	// % protected region % [Modify attribute annotation for TaskId here] off begin
	@CsvBindByName(column = "TASKID", required = false)
	@Nullable
	@Column(name = "taskid")
	@Schema(description = "The TaskId of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for TaskId here] end
	private Integer taskid;

	// % protected region % [Modify attribute annotation for Waktu here] off begin
	@CsvBindByName(column = "WAKTU", required = false)
	@Nullable
	@Column(name = "waktu")
	@Schema(description = "The Waktu of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Waktu here] end
	private String waktu;

	// % protected region % [Modify attribute annotation for WaktuRS here] off begin
	@CsvBindByName(column = "WAKTURS", required = false)
	@Nullable
	@Column(name = "wakturs")
	@Schema(description = "The WaktuRS of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for WaktuRS here] end
	private String wakturs;

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
		return "KODEBOOKING,TASKNAME,TASKID,WAKTU,WAKTURS,ID";
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
	public boolean equals(Object bpjsListTask) {
		if (this == bpjsListTask) {
			return true;
		}
		if (bpjsListTask == null || this.getClass() != bpjsListTask.getClass()) {
			return false;
		}
		if (!super.equals(bpjsListTask)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsListTaskEntity that = (BpjsListTaskEntity) bpjsListTask;
		return
			Objects.equals(this.kodebooking, that.kodebooking) &&
			Objects.equals(this.taskname, that.taskname) &&
			Objects.equals(this.taskid, that.taskid) &&
			Objects.equals(this.waktu, that.waktu) &&
			Objects.equals(this.wakturs, that.wakturs);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
