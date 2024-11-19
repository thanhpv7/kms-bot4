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
import kmsweb.dtos.TariffPackageItemEntityDto;
import kmsweb.entities.enums.*;
import kmsweb.services.utils.converters.enums.*;
import kmsweb.entities.listeners.TariffPackageItemEntityListener;
import kmsweb.serializers.TariffPackageItemSerializer;
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
@EntityListeners({TariffPackageItemEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = TariffPackageItemSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class TariffPackageItemEntity extends AbstractEntity {

	/**
	 * Takes a TariffPackageItemEntityDto and converts it into a TariffPackageItemEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param tariffPackageItemEntityDto
	 */
	public TariffPackageItemEntity(TariffPackageItemEntityDto tariffPackageItemEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (tariffPackageItemEntityDto.getId() != null) {
			this.setId(tariffPackageItemEntityDto.getId());
		}

		if (tariffPackageItemEntityDto.getTariffType() != null) {
			this.setTariffType(tariffPackageItemEntityDto.getTariffType());
		}

		if (tariffPackageItemEntityDto.getTariffCode() != null) {
			this.setTariffCode(tariffPackageItemEntityDto.getTariffCode());
		}

		if (tariffPackageItemEntityDto.getTariffName() != null) {
			this.setTariffName(tariffPackageItemEntityDto.getTariffName());
		}

		if (tariffPackageItemEntityDto.getQuantity() != null) {
			this.setQuantity(tariffPackageItemEntityDto.getQuantity());
		}

		if (tariffPackageItemEntityDto.getUnit() != null) {
			this.setUnit(tariffPackageItemEntityDto.getUnit());
		}

		if (tariffPackageItemEntityDto.getModifiable() != null) {
			this.setModifiable(tariffPackageItemEntityDto.getModifiable());
		}

		if (tariffPackageItemEntityDto.getTariffPackage() != null) {
			this.setTariffPackage(tariffPackageItemEntityDto.getTariffPackage());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Tariff Type here] off begin
	@CsvCustomBindByName(column = "TARIFF_TYPE", required = false, converter = TariffTypeEnumConverter.class)
	@Nullable
	@Column(name = "tariff_type")
	@Schema(description = "The Tariff Type of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Tariff Type here] end
	private TariffTypeEnum tariffType;

	// % protected region % [Modify attribute annotation for Tariff  Code here] off begin
	@CsvBindByName(column = "TARIFF_CODE", required = false)
	@Nullable
	@Column(name = "tariff_code")
	@Schema(description = "The Tariff  Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tariff  Code here] end
	private String tariffCode;

	// % protected region % [Modify attribute annotation for Tariff  Name here] off begin
	@CsvBindByName(column = "TARIFF_NAME", required = false)
	@Nullable
	@Column(name = "tariff_name")
	@Schema(description = "The Tariff  Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tariff  Name here] end
	private String tariffName;

	// % protected region % [Modify attribute annotation for Quantity here] off begin
	@CsvBindByName(column = "QUANTITY", required = false)
	@Nullable
	@Column(name = "quantity")
	@Schema(description = "The Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Quantity here] end
	private Double quantity;

	// % protected region % [Modify attribute annotation for Unit here] off begin
	@CsvBindByName(column = "UNIT", required = false)
	@Nullable
	@Column(name = "unit")
	@Schema(description = "The Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Unit here] end
	private String unit;

	// % protected region % [Modify attribute annotation for Modifiable here] off begin
	@CsvBindByName(column = "MODIFIABLE", required = false)
	@Nullable
	@Column(name = "modifiable")
	@Schema(description = "The Modifiable of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Modifiable here] end
	private Boolean modifiable = false ;

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

	// % protected region % [Update the annotation for Tariff Package here] off begin
	@Schema(description = "The Tariff Package entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Tariff Package here] end
	private TariffPackageEntity tariffPackage;

	// % protected region % [Update the annotation for tariffPackageId here] off begin
	@Transient
	@CsvCustomBindByName(column = "TARIFF_PACKAGE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for tariffPackageId here] end
	private UUID tariffPackageId;

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
	 * Similar to {@link this#setTariffPackage(TariffPackageEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffPackageEntity to be set to this entity
	 */
	public void setTariffPackage(@NotNull TariffPackageEntity entity) {
		setTariffPackage(entity, true);
	}

	/**
	 * Set or update the tariffPackage in this entity with single TariffPackageEntity.
	 *
	 * @param entity the given TariffPackageEntity to be set or updated to tariffPackage
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setTariffPackage(@NotNull TariffPackageEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setTariffPackage here] off begin
		// % protected region % [Add any additional logic here before the main logic for setTariffPackage here] end

		if (sameAsFormer(this.tariffPackage, entity)) {
			return;
		}

		if (this.tariffPackage != null) {
			this.tariffPackage.removeTariffPackageItems(this, false);
		}
		this.tariffPackage = entity;
		if (reverseAdd) {
			this.tariffPackage.addTariffPackageItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setTariffPackage incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setTariffPackage incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetTariffPackage(boolean)} but default to true.
	 */
	public void unsetTariffPackage() {
		this.unsetTariffPackage(true);
	}

	/**
	 * Remove Tariff Package in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetTariffPackage(boolean reverse) {
		if (reverse && this.tariffPackage != null) {
			this.tariffPackage.removeTariffPackageItems(this, false);
		}
		this.tariffPackage = null;
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
		return "TARIFF_TYPE,TARIFF_CODE,TARIFF_NAME,QUANTITY,UNIT,MODIFIABLE,TARIFF_PACKAGE_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<TariffPackageEntity> tariffPackageRelation = Optional.ofNullable(this.tariffPackage);
		tariffPackageRelation.ifPresent(entity -> this.tariffPackageId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object tariffPackageItem) {
		if (this == tariffPackageItem) {
			return true;
		}
		if (tariffPackageItem == null || this.getClass() != tariffPackageItem.getClass()) {
			return false;
		}
		if (!super.equals(tariffPackageItem)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		TariffPackageItemEntity that = (TariffPackageItemEntity) tariffPackageItem;
		return
			Objects.equals(this.tariffType, that.tariffType) &&
			Objects.equals(this.tariffCode, that.tariffCode) &&
			Objects.equals(this.tariffName, that.tariffName) &&
			Objects.equals(this.quantity, that.quantity) &&
			Objects.equals(this.unit, that.unit) &&
			Objects.equals(this.modifiable, that.modifiable) &&
			Objects.equals(this.tariffPackageId, that.tariffPackageId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
