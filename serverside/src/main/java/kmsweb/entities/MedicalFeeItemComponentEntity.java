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
import kmsweb.dtos.MedicalFeeItemComponentEntityDto;
import kmsweb.entities.listeners.MedicalFeeItemComponentEntityListener;
import kmsweb.serializers.MedicalFeeItemComponentSerializer;
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
@EntityListeners({MedicalFeeItemComponentEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = MedicalFeeItemComponentSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class MedicalFeeItemComponentEntity extends AbstractEntity {

	/**
	 * Takes a MedicalFeeItemComponentEntityDto and converts it into a MedicalFeeItemComponentEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param medicalFeeItemComponentEntityDto
	 */
	public MedicalFeeItemComponentEntity(MedicalFeeItemComponentEntityDto medicalFeeItemComponentEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (medicalFeeItemComponentEntityDto.getId() != null) {
			this.setId(medicalFeeItemComponentEntityDto.getId());
		}

		if (medicalFeeItemComponentEntityDto.getPrice() != null) {
			this.setPrice(medicalFeeItemComponentEntityDto.getPrice());
		}

		if (medicalFeeItemComponentEntityDto.getMedicalStaffCode() != null) {
			this.setMedicalStaffCode(medicalFeeItemComponentEntityDto.getMedicalStaffCode());
		}

		if (medicalFeeItemComponentEntityDto.getNotes() != null) {
			this.setNotes(medicalFeeItemComponentEntityDto.getNotes());
		}

		if (medicalFeeItemComponentEntityDto.getMedicalFee() != null) {
			this.setMedicalFee(medicalFeeItemComponentEntityDto.getMedicalFee());
		}

		if (medicalFeeItemComponentEntityDto.getPriceComponent() != null) {
			this.setPriceComponent(medicalFeeItemComponentEntityDto.getPriceComponent());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Price here] off begin
	@CsvBindByName(column = "PRICE", required = false)
	@Nullable
	@Column(name = "price")
	@Schema(description = "The Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Price here] end
	private Double price;

	// % protected region % [Modify attribute annotation for Medical Staff Code here] off begin
	@CsvBindByName(column = "MEDICAL_STAFF_CODE", required = false)
	@Nullable
	@Column(name = "medical_staff_code")
	@Schema(description = "The Medical Staff Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Medical Staff Code here] end
	private String medicalStaffCode;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

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

	// % protected region % [Update the annotation for Medical Fee here] off begin
	@Schema(description = "The Medical Fee entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Fee here] end
	private MedicalFeeEntity medicalFee;

	// % protected region % [Update the annotation for medicalFeeId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_FEE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalFeeId here] end
	private UUID medicalFeeId;

	// % protected region % [Update the annotation for Price Component here] off begin
	@Schema(description = "The Price Component entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Price Component here] end
	private PriceComponentEntity priceComponent;

	// % protected region % [Update the annotation for priceComponentId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRICE_COMPONENT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for priceComponentId here] end
	private UUID priceComponentId;

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
	 * Similar to {@link this#setMedicalFee(MedicalFeeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalFeeEntity to be set to this entity
	 */
	public void setMedicalFee(@NotNull MedicalFeeEntity entity) {
		setMedicalFee(entity, true);
	}

	/**
	 * Set or update the medicalFee in this entity with single MedicalFeeEntity.
	 *
	 * @param entity the given MedicalFeeEntity to be set or updated to medicalFee
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalFee(@NotNull MedicalFeeEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalFee here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalFee here] end

		if (sameAsFormer(this.medicalFee, entity)) {
			return;
		}

		if (this.medicalFee != null) {
			this.medicalFee.removeMedicalFeeItemComponents(this, false);
		}
		this.medicalFee = entity;
		if (reverseAdd) {
			this.medicalFee.addMedicalFeeItemComponents(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalFee incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalFee incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalFee(boolean)} but default to true.
	 */
	public void unsetMedicalFee() {
		this.unsetMedicalFee(true);
	}

	/**
	 * Remove Medical Fee in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalFee(boolean reverse) {
		if (reverse && this.medicalFee != null) {
			this.medicalFee.removeMedicalFeeItemComponents(this, false);
		}
		this.medicalFee = null;
	}
	/**
	 * Similar to {@link this#setPriceComponent(PriceComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PriceComponentEntity to be set to this entity
	 */
	public void setPriceComponent(@NotNull PriceComponentEntity entity) {
		setPriceComponent(entity, true);
	}

	/**
	 * Set or update the priceComponent in this entity with single PriceComponentEntity.
	 *
	 * @param entity the given PriceComponentEntity to be set or updated to priceComponent
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPriceComponent(@NotNull PriceComponentEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPriceComponent here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPriceComponent here] end

		if (sameAsFormer(this.priceComponent, entity)) {
			return;
		}

		if (this.priceComponent != null) {
			this.priceComponent.removeMedicalFeeItemComponents(this, false);
		}
		this.priceComponent = entity;
		if (reverseAdd) {
			this.priceComponent.addMedicalFeeItemComponents(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPriceComponent incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPriceComponent incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPriceComponent(boolean)} but default to true.
	 */
	public void unsetPriceComponent() {
		this.unsetPriceComponent(true);
	}

	/**
	 * Remove Price Component in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPriceComponent(boolean reverse) {
		if (reverse && this.priceComponent != null) {
			this.priceComponent.removeMedicalFeeItemComponents(this, false);
		}
		this.priceComponent = null;
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
		return "PRICE,MEDICAL_STAFF_CODE,NOTES,MEDICAL_FEE_ID,PRICE_COMPONENT_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<MedicalFeeEntity> medicalFeeRelation = Optional.ofNullable(this.medicalFee);
		medicalFeeRelation.ifPresent(entity -> this.medicalFeeId = entity.getId());

		Optional<PriceComponentEntity> priceComponentRelation = Optional.ofNullable(this.priceComponent);
		priceComponentRelation.ifPresent(entity -> this.priceComponentId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object medicalFeeItemComponent) {
		if (this == medicalFeeItemComponent) {
			return true;
		}
		if (medicalFeeItemComponent == null || this.getClass() != medicalFeeItemComponent.getClass()) {
			return false;
		}
		if (!super.equals(medicalFeeItemComponent)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		MedicalFeeItemComponentEntity that = (MedicalFeeItemComponentEntity) medicalFeeItemComponent;
		return
			Objects.equals(this.price, that.price) &&
			Objects.equals(this.medicalStaffCode, that.medicalStaffCode) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.medicalFeeId, that.medicalFeeId) &&
			Objects.equals(this.priceComponentId, that.priceComponentId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
