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
import kmsweb.dtos.VitalSignsEntityDto;
import kmsweb.entities.listeners.VitalSignsEntityListener;
import kmsweb.serializers.VitalSignsSerializer;
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
@EntityListeners({VitalSignsEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = VitalSignsSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class VitalSignsEntity extends AbstractEntity {

	/**
	 * Takes a VitalSignsEntityDto and converts it into a VitalSignsEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param vitalSignsEntityDto
	 */
	public VitalSignsEntity(VitalSignsEntityDto vitalSignsEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (vitalSignsEntityDto.getId() != null) {
			this.setId(vitalSignsEntityDto.getId());
		}

		if (vitalSignsEntityDto.getTime() != null) {
			this.setTime(vitalSignsEntityDto.getTime());
		}

		if (vitalSignsEntityDto.getHr() != null) {
			this.setHr(vitalSignsEntityDto.getHr());
		}

		if (vitalSignsEntityDto.getRr() != null) {
			this.setRr(vitalSignsEntityDto.getRr());
		}

		if (vitalSignsEntityDto.getTemprature() != null) {
			this.setTemprature(vitalSignsEntityDto.getTemprature());
		}

		if (vitalSignsEntityDto.getO2Saturation() != null) {
			this.setO2Saturation(vitalSignsEntityDto.getO2Saturation());
		}

		if (vitalSignsEntityDto.getRemarks() != null) {
			this.setRemarks(vitalSignsEntityDto.getRemarks());
		}

		if (vitalSignsEntityDto.getNewbornDetail() != null) {
			this.setNewbornDetail(vitalSignsEntityDto.getNewbornDetail());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Time here] off begin
	@CsvBindByName(column = "TIME", required = false)
	@Nullable
	@Column(name = "time")
	@Schema(description = "The Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Time here] end
	private String time;

	// % protected region % [Modify attribute annotation for HR here] off begin
	@CsvBindByName(column = "HR", required = false)
	@Nullable
	@Column(name = "hr")
	@Schema(description = "The HR of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for HR here] end
	private String hr;

	// % protected region % [Modify attribute annotation for RR here] off begin
	@CsvBindByName(column = "RR", required = false)
	@Nullable
	@Column(name = "rr")
	@Schema(description = "The RR of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for RR here] end
	private String rr;

	// % protected region % [Modify attribute annotation for Temprature here] off begin
	@CsvBindByName(column = "TEMPRATURE", required = false)
	@Nullable
	@Column(name = "temprature")
	@Schema(description = "The Temprature of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Temprature here] end
	private String temprature;

	// % protected region % [Modify attribute annotation for O2 Saturation here] off begin
	@CsvBindByName(column = "O2_SATURATION", required = false)
	@Nullable
	@Column(name = "o2_saturation")
	@Schema(description = "The O2 Saturation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for O2 Saturation here] end
	private String o2Saturation;

	// % protected region % [Modify attribute annotation for Remarks here] off begin
	@CsvBindByName(column = "REMARKS", required = false)
	@Nullable
	@Column(name = "remarks")
	@Schema(description = "The Remarks of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Remarks here] end
	private String remarks;

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

	// % protected region % [Update the annotation for Newborn Detail here] off begin
	@Schema(description = "The Newborn Detail entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Newborn Detail here] end
	private NewbornDetailEntity newbornDetail;

	// % protected region % [Update the annotation for newbornDetailId here] off begin
	@Transient
	@CsvCustomBindByName(column = "NEWBORN_DETAIL_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for newbornDetailId here] end
	private UUID newbornDetailId;

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
	 * Similar to {@link this#setNewbornDetail(NewbornDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given NewbornDetailEntity to be set to this entity
	 */
	public void setNewbornDetail(@NotNull NewbornDetailEntity entity) {
		setNewbornDetail(entity, true);
	}

	/**
	 * Set or update the newbornDetail in this entity with single NewbornDetailEntity.
	 *
	 * @param entity the given NewbornDetailEntity to be set or updated to newbornDetail
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setNewbornDetail(@NotNull NewbornDetailEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setNewbornDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setNewbornDetail here] end

		if (sameAsFormer(this.newbornDetail, entity)) {
			return;
		}

		if (this.newbornDetail != null) {
			this.newbornDetail.removeVitalSigns(this, false);
		}
		this.newbornDetail = entity;
		if (reverseAdd) {
			this.newbornDetail.addVitalSigns(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setNewbornDetail incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setNewbornDetail incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetNewbornDetail(boolean)} but default to true.
	 */
	public void unsetNewbornDetail() {
		this.unsetNewbornDetail(true);
	}

	/**
	 * Remove Newborn Detail in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetNewbornDetail(boolean reverse) {
		if (reverse && this.newbornDetail != null) {
			this.newbornDetail.removeVitalSigns(this, false);
		}
		this.newbornDetail = null;
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
		return "TIME,HR,RR,TEMPRATURE,O2_SATURATION,REMARKS,NEWBORN_DETAIL_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<NewbornDetailEntity> newbornDetailRelation = Optional.ofNullable(this.newbornDetail);
		newbornDetailRelation.ifPresent(entity -> this.newbornDetailId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object vitalSigns) {
		if (this == vitalSigns) {
			return true;
		}
		if (vitalSigns == null || this.getClass() != vitalSigns.getClass()) {
			return false;
		}
		if (!super.equals(vitalSigns)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		VitalSignsEntity that = (VitalSignsEntity) vitalSigns;
		return
			Objects.equals(this.time, that.time) &&
			Objects.equals(this.hr, that.hr) &&
			Objects.equals(this.rr, that.rr) &&
			Objects.equals(this.temprature, that.temprature) &&
			Objects.equals(this.o2Saturation, that.o2Saturation) &&
			Objects.equals(this.remarks, that.remarks) &&
			Objects.equals(this.newbornDetailId, that.newbornDetailId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
