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
import kmsweb.dtos.PriceComponentEntityDto;
import kmsweb.entities.listeners.PriceComponentEntityListener;
import kmsweb.serializers.PriceComponentSerializer;
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

import java.util.*;
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
@EntityListeners({PriceComponentEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PriceComponentSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"component_code"}, name = "component_code"),
	}
)
public class PriceComponentEntity extends AbstractEntity {

	/**
	 * Takes a PriceComponentEntityDto and converts it into a PriceComponentEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param priceComponentEntityDto
	 */
	public PriceComponentEntity(PriceComponentEntityDto priceComponentEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (priceComponentEntityDto.getId() != null) {
			this.setId(priceComponentEntityDto.getId());
		}

		if (priceComponentEntityDto.getComponentCode() != null) {
			this.setComponentCode(priceComponentEntityDto.getComponentCode());
		}

		if (priceComponentEntityDto.getComponentName() != null) {
			this.setComponentName(priceComponentEntityDto.getComponentName());
		}

		if (priceComponentEntityDto.getCoaCOGS() != null) {
			this.setCoaCOGS(priceComponentEntityDto.getCoaCOGS());
		}

		if (priceComponentEntityDto.getCoaSell() != null) {
			this.setCoaSell(priceComponentEntityDto.getCoaSell());
		}

		if (priceComponentEntityDto.getCoaInventory() != null) {
			this.setCoaInventory(priceComponentEntityDto.getCoaInventory());
		}

		if (priceComponentEntityDto.getInvoiceItemComponents() != null) {
			this.setInvoiceItemComponents(priceComponentEntityDto.getInvoiceItemComponents());
		}

		if (priceComponentEntityDto.getMedicalFeeItemComponents() != null) {
			this.setMedicalFeeItemComponents(priceComponentEntityDto.getMedicalFeeItemComponents());
		}

		if (priceComponentEntityDto.getTariffDefinitionOtherComponents() != null) {
			this.setTariffDefinitionOtherComponents(priceComponentEntityDto.getTariffDefinitionOtherComponents());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Component Code here] off begin
	@CsvBindByName(column = "COMPONENT_CODE", required = true)
	@NotNull(message = "Component Code must not be empty")
	@Column(name = "component_code")
	@Schema(description = "The Component Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Component Code here] end
	private String componentCode;

	// % protected region % [Modify attribute annotation for Component Name here] off begin
	@CsvBindByName(column = "COMPONENT_NAME", required = true)
	@NotNull(message = "Component Name must not be empty")
	@Column(name = "component_name")
	@Schema(description = "The Component Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Component Name here] end
	private String componentName;

	// % protected region % [Modify attribute annotation for COA COGS here] off begin
	@CsvBindByName(column = "COA_COGS", required = false)
	@Nullable
	@Column(name = "coa_cogs")
	@Schema(description = "The COA COGS of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for COA COGS here] end
	private String coaCOGS;

	// % protected region % [Modify attribute annotation for COA Sell here] off begin
	@CsvBindByName(column = "COA_SELL", required = false)
	@Nullable
	@Column(name = "coa_sell")
	@Schema(description = "The COA Sell of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for COA Sell here] end
	private String coaSell;

	// % protected region % [Modify attribute annotation for COA Inventory here] off begin
	@CsvBindByName(column = "COA_INVENTORY", required = false)
	@Nullable
	@Column(name = "coa_inventory")
	@Schema(description = "The COA Inventory of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for COA Inventory here] end
	private String coaInventory;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Invoice Item Components here] off begin
	@Schema(description = "The Invoice Item Component entities that are related to this entity.")
	@OneToMany(mappedBy = "priceComponent", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice Item Components here] end
	private Set<InvoiceItemComponentEntity> invoiceItemComponents = new HashSet<>();

	// % protected region % [Update the annotation for invoiceItemComponentsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_ITEM_COMPONENTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for invoiceItemComponentsIds here] end
	private Set<UUID> invoiceItemComponentsIds = new HashSet<>();

	// % protected region % [Update the annotation for Medical Fee Item Components here] off begin
	@Schema(description = "The Medical Fee Item Component entities that are related to this entity.")
	@OneToMany(mappedBy = "priceComponent", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Fee Item Components here] end
	private Set<MedicalFeeItemComponentEntity> medicalFeeItemComponents = new HashSet<>();

	// % protected region % [Update the annotation for medicalFeeItemComponentsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_FEE_ITEM_COMPONENTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicalFeeItemComponentsIds here] end
	private Set<UUID> medicalFeeItemComponentsIds = new HashSet<>();

	// % protected region % [Update the annotation for Tariff Definition Other Components here] off begin
	@Schema(description = "The Tariff Definition Other Component entities that are related to this entity.")
	@OneToMany(mappedBy = "priceComponent", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Tariff Definition Other Components here] end
	private Set<TariffDefinitionOtherComponentEntity> tariffDefinitionOtherComponents = new HashSet<>();

	// % protected region % [Update the annotation for tariffDefinitionOtherComponentsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "TARIFF_DEFINITION_OTHER_COMPONENTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for tariffDefinitionOtherComponentsIds here] end
	private Set<UUID> tariffDefinitionOtherComponentsIds = new HashSet<>();

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

/**
	 * Similar to {@link this#addInvoiceItemComponents(InvoiceItemComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemComponentEntity to be added to this entity
	 */
	public void addInvoiceItemComponents(@NotNull InvoiceItemComponentEntity entity) {
		addInvoiceItemComponents(entity, true);
	}

	/**
	 * Add a new InvoiceItemComponentEntity to invoiceItemComponents in this entity.
	 *
	 * @param entity the given InvoiceItemComponentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoiceItemComponents(@NonNull InvoiceItemComponentEntity entity, boolean reverseAdd) {
		if (!this.invoiceItemComponents.contains(entity)) {
			invoiceItemComponents.add(entity);
			if (reverseAdd) {
				entity.setPriceComponent(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoiceItemComponents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to be added to this entity
	 */
	public void addInvoiceItemComponents(@NotNull Collection<InvoiceItemComponentEntity> entities) {
		addInvoiceItemComponents(entities, true);
	}

	/**
	 * Add a new collection of InvoiceItemComponentEntity to Invoice Item Components in this entity.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoiceItemComponents(@NonNull Collection<InvoiceItemComponentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoiceItemComponents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoiceItemComponents(InvoiceItemComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemComponentEntity to be set to this entity
	 */
	public void removeInvoiceItemComponents(@NotNull InvoiceItemComponentEntity entity) {
		this.removeInvoiceItemComponents(entity, true);
	}

	/**
	 * Remove the given InvoiceItemComponentEntity from this entity.
	 *
	 * @param entity the given InvoiceItemComponentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoiceItemComponents(@NotNull InvoiceItemComponentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPriceComponent(false);
		}
		this.invoiceItemComponents.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoiceItemComponents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to be removed to this entity
	 */
	public void removeInvoiceItemComponents(@NotNull Collection<InvoiceItemComponentEntity> entities) {
		this.removeInvoiceItemComponents(entities, true);
	}

	/**
	 * Remove the given collection of InvoiceItemComponentEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoiceItemComponents(@NonNull Collection<InvoiceItemComponentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoiceItemComponents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoiceItemComponents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to be set to this entity
	 */
	public void setInvoiceItemComponents(@NotNull Collection<InvoiceItemComponentEntity> entities) {
		setInvoiceItemComponents(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Item Components with the given ones.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoiceItemComponents(@NotNull Collection<InvoiceItemComponentEntity> entities, boolean reverseAdd) {

		this.unsetInvoiceItemComponents();
		this.invoiceItemComponents = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoiceItemComponents.forEach(invoiceItemComponentsEntity -> invoiceItemComponentsEntity.setPriceComponent(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoiceItemComponents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoiceItemComponents() {
		this.unsetInvoiceItemComponents(true);
	}

	/**
	 * Remove all the entities in Invoice Item Components from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoiceItemComponents(boolean doReverse) {
		if (doReverse) {
			this.invoiceItemComponents.forEach(invoiceItemComponentsEntity -> invoiceItemComponentsEntity.unsetPriceComponent(false));
		}
		this.invoiceItemComponents.clear();
	}

/**
	 * Similar to {@link this#addMedicalFeeItemComponents(MedicalFeeItemComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalFeeItemComponentEntity to be added to this entity
	 */
	public void addMedicalFeeItemComponents(@NotNull MedicalFeeItemComponentEntity entity) {
		addMedicalFeeItemComponents(entity, true);
	}

	/**
	 * Add a new MedicalFeeItemComponentEntity to medicalFeeItemComponents in this entity.
	 *
	 * @param entity the given MedicalFeeItemComponentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalFeeItemComponents(@NonNull MedicalFeeItemComponentEntity entity, boolean reverseAdd) {
		if (!this.medicalFeeItemComponents.contains(entity)) {
			medicalFeeItemComponents.add(entity);
			if (reverseAdd) {
				entity.setPriceComponent(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalFeeItemComponents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalFeeItemComponentEntity to be added to this entity
	 */
	public void addMedicalFeeItemComponents(@NotNull Collection<MedicalFeeItemComponentEntity> entities) {
		addMedicalFeeItemComponents(entities, true);
	}

	/**
	 * Add a new collection of MedicalFeeItemComponentEntity to Medical Fee Item Components in this entity.
	 *
	 * @param entities the given collection of MedicalFeeItemComponentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalFeeItemComponents(@NonNull Collection<MedicalFeeItemComponentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalFeeItemComponents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalFeeItemComponents(MedicalFeeItemComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalFeeItemComponentEntity to be set to this entity
	 */
	public void removeMedicalFeeItemComponents(@NotNull MedicalFeeItemComponentEntity entity) {
		this.removeMedicalFeeItemComponents(entity, true);
	}

	/**
	 * Remove the given MedicalFeeItemComponentEntity from this entity.
	 *
	 * @param entity the given MedicalFeeItemComponentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalFeeItemComponents(@NotNull MedicalFeeItemComponentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPriceComponent(false);
		}
		this.medicalFeeItemComponents.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalFeeItemComponents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalFeeItemComponentEntity to be removed to this entity
	 */
	public void removeMedicalFeeItemComponents(@NotNull Collection<MedicalFeeItemComponentEntity> entities) {
		this.removeMedicalFeeItemComponents(entities, true);
	}

	/**
	 * Remove the given collection of MedicalFeeItemComponentEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalFeeItemComponentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalFeeItemComponents(@NonNull Collection<MedicalFeeItemComponentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalFeeItemComponents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalFeeItemComponents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalFeeItemComponentEntity to be set to this entity
	 */
	public void setMedicalFeeItemComponents(@NotNull Collection<MedicalFeeItemComponentEntity> entities) {
		setMedicalFeeItemComponents(entities, true);
	}

	/**
	 * Replace the current entities in Medical Fee Item Components with the given ones.
	 *
	 * @param entities the given collection of MedicalFeeItemComponentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalFeeItemComponents(@NotNull Collection<MedicalFeeItemComponentEntity> entities, boolean reverseAdd) {

		this.unsetMedicalFeeItemComponents();
		this.medicalFeeItemComponents = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalFeeItemComponents.forEach(medicalFeeItemComponentsEntity -> medicalFeeItemComponentsEntity.setPriceComponent(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalFeeItemComponents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalFeeItemComponents() {
		this.unsetMedicalFeeItemComponents(true);
	}

	/**
	 * Remove all the entities in Medical Fee Item Components from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalFeeItemComponents(boolean doReverse) {
		if (doReverse) {
			this.medicalFeeItemComponents.forEach(medicalFeeItemComponentsEntity -> medicalFeeItemComponentsEntity.unsetPriceComponent(false));
		}
		this.medicalFeeItemComponents.clear();
	}

/**
	 * Similar to {@link this#addTariffDefinitionOtherComponents(TariffDefinitionOtherComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffDefinitionOtherComponentEntity to be added to this entity
	 */
	public void addTariffDefinitionOtherComponents(@NotNull TariffDefinitionOtherComponentEntity entity) {
		addTariffDefinitionOtherComponents(entity, true);
	}

	/**
	 * Add a new TariffDefinitionOtherComponentEntity to tariffDefinitionOtherComponents in this entity.
	 *
	 * @param entity the given TariffDefinitionOtherComponentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addTariffDefinitionOtherComponents(@NonNull TariffDefinitionOtherComponentEntity entity, boolean reverseAdd) {
		if (!this.tariffDefinitionOtherComponents.contains(entity)) {
			tariffDefinitionOtherComponents.add(entity);
			if (reverseAdd) {
				entity.setPriceComponent(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addTariffDefinitionOtherComponents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffDefinitionOtherComponentEntity to be added to this entity
	 */
	public void addTariffDefinitionOtherComponents(@NotNull Collection<TariffDefinitionOtherComponentEntity> entities) {
		addTariffDefinitionOtherComponents(entities, true);
	}

	/**
	 * Add a new collection of TariffDefinitionOtherComponentEntity to Tariff Definition Other Components in this entity.
	 *
	 * @param entities the given collection of TariffDefinitionOtherComponentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addTariffDefinitionOtherComponents(@NonNull Collection<TariffDefinitionOtherComponentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addTariffDefinitionOtherComponents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeTariffDefinitionOtherComponents(TariffDefinitionOtherComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffDefinitionOtherComponentEntity to be set to this entity
	 */
	public void removeTariffDefinitionOtherComponents(@NotNull TariffDefinitionOtherComponentEntity entity) {
		this.removeTariffDefinitionOtherComponents(entity, true);
	}

	/**
	 * Remove the given TariffDefinitionOtherComponentEntity from this entity.
	 *
	 * @param entity the given TariffDefinitionOtherComponentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTariffDefinitionOtherComponents(@NotNull TariffDefinitionOtherComponentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPriceComponent(false);
		}
		this.tariffDefinitionOtherComponents.remove(entity);
	}

	/**
	 * Similar to {@link this#removeTariffDefinitionOtherComponents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TariffDefinitionOtherComponentEntity to be removed to this entity
	 */
	public void removeTariffDefinitionOtherComponents(@NotNull Collection<TariffDefinitionOtherComponentEntity> entities) {
		this.removeTariffDefinitionOtherComponents(entities, true);
	}

	/**
	 * Remove the given collection of TariffDefinitionOtherComponentEntity from  to this entity.
	 *
	 * @param entities the given collection of TariffDefinitionOtherComponentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeTariffDefinitionOtherComponents(@NonNull Collection<TariffDefinitionOtherComponentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeTariffDefinitionOtherComponents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setTariffDefinitionOtherComponents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffDefinitionOtherComponentEntity to be set to this entity
	 */
	public void setTariffDefinitionOtherComponents(@NotNull Collection<TariffDefinitionOtherComponentEntity> entities) {
		setTariffDefinitionOtherComponents(entities, true);
	}

	/**
	 * Replace the current entities in Tariff Definition Other Components with the given ones.
	 *
	 * @param entities the given collection of TariffDefinitionOtherComponentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTariffDefinitionOtherComponents(@NotNull Collection<TariffDefinitionOtherComponentEntity> entities, boolean reverseAdd) {

		this.unsetTariffDefinitionOtherComponents();
		this.tariffDefinitionOtherComponents = new HashSet<>(entities);
		if (reverseAdd) {
			this.tariffDefinitionOtherComponents.forEach(tariffDefinitionOtherComponentsEntity -> tariffDefinitionOtherComponentsEntity.setPriceComponent(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetTariffDefinitionOtherComponents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetTariffDefinitionOtherComponents() {
		this.unsetTariffDefinitionOtherComponents(true);
	}

	/**
	 * Remove all the entities in Tariff Definition Other Components from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetTariffDefinitionOtherComponents(boolean doReverse) {
		if (doReverse) {
			this.tariffDefinitionOtherComponents.forEach(tariffDefinitionOtherComponentsEntity -> tariffDefinitionOtherComponentsEntity.unsetPriceComponent(false));
		}
		this.tariffDefinitionOtherComponents.clear();
	}
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
		return "COMPONENT_CODE,COMPONENT_NAME,COA_COGS,COA_SELL,COA_INVENTORY,INVOICE_ITEM_COMPONENTS_IDS,MEDICAL_FEE_ITEM_COMPONENTS_IDS,TARIFF_DEFINITION_OTHER_COMPONENTS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		this.invoiceItemComponentsIds = new HashSet<>();
		for (InvoiceItemComponentEntity invoiceItemComponents: this.invoiceItemComponents) {
			this.invoiceItemComponentsIds.add(invoiceItemComponents.getId());
		}

		this.medicalFeeItemComponentsIds = new HashSet<>();
		for (MedicalFeeItemComponentEntity medicalFeeItemComponents: this.medicalFeeItemComponents) {
			this.medicalFeeItemComponentsIds.add(medicalFeeItemComponents.getId());
		}

		this.tariffDefinitionOtherComponentsIds = new HashSet<>();
		for (TariffDefinitionOtherComponentEntity tariffDefinitionOtherComponents: this.tariffDefinitionOtherComponents) {
			this.tariffDefinitionOtherComponentsIds.add(tariffDefinitionOtherComponents.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object priceComponent) {
		if (this == priceComponent) {
			return true;
		}
		if (priceComponent == null || this.getClass() != priceComponent.getClass()) {
			return false;
		}
		if (!super.equals(priceComponent)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PriceComponentEntity that = (PriceComponentEntity) priceComponent;
		return
			Objects.equals(this.componentCode, that.componentCode) &&
			Objects.equals(this.componentName, that.componentName) &&
			Objects.equals(this.coaCOGS, that.coaCOGS) &&
			Objects.equals(this.coaSell, that.coaSell) &&
			Objects.equals(this.coaInventory, that.coaInventory) &&
			Objects.equals(this.invoiceItemComponentsIds, that.invoiceItemComponentsIds) &&
			Objects.equals(this.medicalFeeItemComponentsIds, that.medicalFeeItemComponentsIds) &&
			Objects.equals(this.tariffDefinitionOtherComponentsIds, that.tariffDefinitionOtherComponentsIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
