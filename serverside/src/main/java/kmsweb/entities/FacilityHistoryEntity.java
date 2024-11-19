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
import kmsweb.dtos.FacilityHistoryEntityDto;
import kmsweb.entities.listeners.FacilityHistoryEntityListener;
import kmsweb.serializers.FacilityHistorySerializer;
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
@EntityListeners({FacilityHistoryEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = FacilityHistorySerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class FacilityHistoryEntity extends AbstractEntity {

	/**
	 * Takes a FacilityHistoryEntityDto and converts it into a FacilityHistoryEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param facilityHistoryEntityDto
	 */
	public FacilityHistoryEntity(FacilityHistoryEntityDto facilityHistoryEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (facilityHistoryEntityDto.getId() != null) {
			this.setId(facilityHistoryEntityDto.getId());
		}

		if (facilityHistoryEntityDto.getChangeDate() != null) {
			this.setChangeDate(facilityHistoryEntityDto.getChangeDate());
		}

		if (facilityHistoryEntityDto.getFacilityNo() != null) {
			this.setFacilityNo(facilityHistoryEntityDto.getFacilityNo());
		}

		if (facilityHistoryEntityDto.getCurrentQty() != null) {
			this.setCurrentQty(facilityHistoryEntityDto.getCurrentQty());
		}

		if (facilityHistoryEntityDto.getChangedQty() != null) {
			this.setChangedQty(facilityHistoryEntityDto.getChangedQty());
		}

		if (facilityHistoryEntityDto.getFacilityStatus() != null) {
			this.setFacilityStatus(facilityHistoryEntityDto.getFacilityStatus());
		}

		if (facilityHistoryEntityDto.getFacilityClass() != null) {
			this.setFacilityClass(facilityHistoryEntityDto.getFacilityClass());
		}

		if (facilityHistoryEntityDto.getFacilityType() != null) {
			this.setFacilityType(facilityHistoryEntityDto.getFacilityType());
		}

		if (facilityHistoryEntityDto.getFacilityService() != null) {
			this.setFacilityService(facilityHistoryEntityDto.getFacilityService());
		}

		if (facilityHistoryEntityDto.getBedFacilityId() != null) {
			this.setBedFacilityId(facilityHistoryEntityDto.getBedFacilityId());
		}

		if (facilityHistoryEntityDto.getRegistrationId() != null) {
			this.setRegistrationId(facilityHistoryEntityDto.getRegistrationId());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Change Date here] off begin
	@CsvCustomBindByName(column = "CHANGE_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "change_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Change Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Change Date here] end
	private OffsetDateTime changeDate;

	// % protected region % [Modify attribute annotation for Facility No here] off begin
	@CsvBindByName(column = "FACILITY_NO", required = false)
	@Nullable
	@Column(name = "facility_no")
	@Schema(description = "The Facility No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Facility No here] end
	private String facilityNo;

	// % protected region % [Modify attribute annotation for Current Qty here] off begin
	@CsvBindByName(column = "CURRENT_QTY", required = false)
	@Nullable
	@Column(name = "current_qty")
	@Schema(description = "The Current Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Current Qty here] end
	private Integer currentQty;

	// % protected region % [Modify attribute annotation for Changed Qty here] off begin
	@CsvBindByName(column = "CHANGED_QTY", required = false)
	@Nullable
	@Column(name = "changed_qty")
	@Schema(description = "The Changed Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Changed Qty here] end
	private Integer changedQty;

	// % protected region % [Modify attribute annotation for Facility Status here] off begin
	@CsvBindByName(column = "FACILITY_STATUS", required = false)
	@Nullable
	@Column(name = "facility_status")
	@Schema(description = "The Facility Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Facility Status here] end
	private String facilityStatus;

	// % protected region % [Modify attribute annotation for Facility Class here] off begin
	@CsvBindByName(column = "FACILITY_CLASS", required = false)
	@Nullable
	@Column(name = "facility_class")
	@Schema(description = "The Facility Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Facility Class here] end
	private String facilityClass;

	// % protected region % [Modify attribute annotation for Facility Type here] off begin
	@CsvBindByName(column = "FACILITY_TYPE", required = false)
	@Nullable
	@Column(name = "facility_type")
	@Schema(description = "The Facility Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Facility Type here] end
	private String facilityType;

	// % protected region % [Modify attribute annotation for Facility Service here] off begin
	@CsvBindByName(column = "FACILITY_SERVICE", required = false)
	@Nullable
	@Column(name = "facility_service")
	@Schema(description = "The Facility Service of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Facility Service here] end
	private String facilityService;

	// % protected region % [Modify attribute annotation for Bed Facility Id here] off begin
	@CsvBindByName(column = "BED_FACILITY_ID", required = false)
	@Nullable
	@Column(name = "bed_facility_id")
	@Schema(description = "The Bed Facility Id of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Bed Facility Id here] end
	private String bedFacilityId;

	// % protected region % [Modify attribute annotation for Registration Id here] off begin
	@CsvBindByName(column = "REGISTRATION_ID", required = false)
	@Nullable
	@Column(name = "registration_id")
	@Schema(description = "The Registration Id of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Registration Id here] end
	private String registrationId;

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
		return "CHANGE_DATE,FACILITY_NO,CURRENT_QTY,CHANGED_QTY,FACILITY_STATUS,FACILITY_CLASS,FACILITY_TYPE,FACILITY_SERVICE,BED_FACILITY_ID,REGISTRATION_ID,ID";
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
	public boolean equals(Object facilityHistory) {
		if (this == facilityHistory) {
			return true;
		}
		if (facilityHistory == null || this.getClass() != facilityHistory.getClass()) {
			return false;
		}
		if (!super.equals(facilityHistory)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		FacilityHistoryEntity that = (FacilityHistoryEntity) facilityHistory;
		return
			Objects.equals(
			     this.changeDate != null ? this.changeDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.changeDate != null ? that.changeDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.facilityNo, that.facilityNo) &&
			Objects.equals(this.currentQty, that.currentQty) &&
			Objects.equals(this.changedQty, that.changedQty) &&
			Objects.equals(this.facilityStatus, that.facilityStatus) &&
			Objects.equals(this.facilityClass, that.facilityClass) &&
			Objects.equals(this.facilityType, that.facilityType) &&
			Objects.equals(this.facilityService, that.facilityService) &&
			Objects.equals(this.bedFacilityId, that.bedFacilityId) &&
			Objects.equals(this.registrationId, that.registrationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
