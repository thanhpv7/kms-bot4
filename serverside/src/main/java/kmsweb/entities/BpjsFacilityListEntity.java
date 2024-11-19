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
import kmsweb.dtos.BpjsFacilityListEntityDto;
import kmsweb.entities.listeners.BpjsFacilityListEntityListener;
import kmsweb.serializers.BpjsFacilityListSerializer;
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
@EntityListeners({BpjsFacilityListEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsFacilityListSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsFacilityListEntity extends AbstractEntity {

	/**
	 * Takes a BpjsFacilityListEntityDto and converts it into a BpjsFacilityListEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsFacilityListEntityDto
	 */
	public BpjsFacilityListEntity(BpjsFacilityListEntityDto bpjsFacilityListEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsFacilityListEntityDto.getId() != null) {
			this.setId(bpjsFacilityListEntityDto.getId());
		}

		if (bpjsFacilityListEntityDto.getFacilityCode() != null) {
			this.setFacilityCode(bpjsFacilityListEntityDto.getFacilityCode());
		}

		if (bpjsFacilityListEntityDto.getFacilityName() != null) {
			this.setFacilityName(bpjsFacilityListEntityDto.getFacilityName());
		}

		if (bpjsFacilityListEntityDto.getBpjsHealthFacility() != null) {
			this.setBpjsHealthFacility(bpjsFacilityListEntityDto.getBpjsHealthFacility());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Facility Code here] off begin
	@CsvBindByName(column = "FACILITY_CODE", required = false)
	@Nullable
	@Column(name = "facility_code")
	@Schema(description = "The Facility Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Facility Code here] end
	private String facilityCode;

	// % protected region % [Modify attribute annotation for Facility Name here] off begin
	@CsvBindByName(column = "FACILITY_NAME", required = false)
	@Nullable
	@Column(name = "facility_name")
	@Schema(description = "The Facility Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Facility Name here] end
	private String facilityName;

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

	// % protected region % [Update the annotation for BPJS Health Facility here] off begin
	@Schema(description = "The BPJS Health Facility entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Health Facility here] end
	private BpjsHealthFacilityEntity bpjsHealthFacility;

	// % protected region % [Update the annotation for bpjsHealthFacilityId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_HEALTH_FACILITY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsHealthFacilityId here] end
	private UUID bpjsHealthFacilityId;

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
	 * Similar to {@link this#setBpjsHealthFacility(BpjsHealthFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsHealthFacilityEntity to be set to this entity
	 */
	public void setBpjsHealthFacility(@NotNull BpjsHealthFacilityEntity entity) {
		setBpjsHealthFacility(entity, true);
	}

	/**
	 * Set or update the bpjsHealthFacility in this entity with single BpjsHealthFacilityEntity.
	 *
	 * @param entity the given BpjsHealthFacilityEntity to be set or updated to bpjsHealthFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsHealthFacility(@NotNull BpjsHealthFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsHealthFacility here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsHealthFacility here] end

		if (sameAsFormer(this.bpjsHealthFacility, entity)) {
			return;
		}

		if (this.bpjsHealthFacility != null) {
			this.bpjsHealthFacility.removeBpjsFacilityLists(this, false);
		}
		this.bpjsHealthFacility = entity;
		if (reverseAdd) {
			this.bpjsHealthFacility.addBpjsFacilityLists(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsHealthFacility incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsHealthFacility incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsHealthFacility(boolean)} but default to true.
	 */
	public void unsetBpjsHealthFacility() {
		this.unsetBpjsHealthFacility(true);
	}

	/**
	 * Remove BPJS Health Facility in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsHealthFacility(boolean reverse) {
		if (reverse && this.bpjsHealthFacility != null) {
			this.bpjsHealthFacility.removeBpjsFacilityLists(this, false);
		}
		this.bpjsHealthFacility = null;
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
		return "FACILITY_CODE,FACILITY_NAME,BPJS_HEALTH_FACILITY_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<BpjsHealthFacilityEntity> bpjsHealthFacilityRelation = Optional.ofNullable(this.bpjsHealthFacility);
		bpjsHealthFacilityRelation.ifPresent(entity -> this.bpjsHealthFacilityId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsFacilityList) {
		if (this == bpjsFacilityList) {
			return true;
		}
		if (bpjsFacilityList == null || this.getClass() != bpjsFacilityList.getClass()) {
			return false;
		}
		if (!super.equals(bpjsFacilityList)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsFacilityListEntity that = (BpjsFacilityListEntity) bpjsFacilityList;
		return
			Objects.equals(this.facilityCode, that.facilityCode) &&
			Objects.equals(this.facilityName, that.facilityName) &&
			Objects.equals(this.bpjsHealthFacilityId, that.bpjsHealthFacilityId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
