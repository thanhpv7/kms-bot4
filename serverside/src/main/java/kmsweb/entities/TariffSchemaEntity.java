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
import kmsweb.dtos.TariffSchemaEntityDto;
import kmsweb.entities.listeners.TariffSchemaEntityListener;
import kmsweb.serializers.TariffSchemaSerializer;
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

import java.util.*;
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
@EntityListeners({TariffSchemaEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = TariffSchemaSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class TariffSchemaEntity extends AbstractEntity {

	/**
	 * Takes a TariffSchemaEntityDto and converts it into a TariffSchemaEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param tariffSchemaEntityDto
	 */
	public TariffSchemaEntity(TariffSchemaEntityDto tariffSchemaEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (tariffSchemaEntityDto.getId() != null) {
			this.setId(tariffSchemaEntityDto.getId());
		}

		if (tariffSchemaEntityDto.getSchemaCode() != null) {
			this.setSchemaCode(tariffSchemaEntityDto.getSchemaCode());
		}

		if (tariffSchemaEntityDto.getSchemeName() != null) {
			this.setSchemeName(tariffSchemaEntityDto.getSchemeName());
		}

		if (tariffSchemaEntityDto.getStartDate() != null) {
			this.setStartDate(tariffSchemaEntityDto.getStartDate());
		}

		if (tariffSchemaEntityDto.getEndDate() != null) {
			this.setEndDate(tariffSchemaEntityDto.getEndDate());
		}

		if (tariffSchemaEntityDto.getBaseScheme() != null) {
			this.setBaseScheme(tariffSchemaEntityDto.getBaseScheme());
		}

		if (tariffSchemaEntityDto.getInvoiceItems() != null) {
			this.setInvoiceItems(tariffSchemaEntityDto.getInvoiceItems());
		}

		if (tariffSchemaEntityDto.getInvoices() != null) {
			this.setInvoices(tariffSchemaEntityDto.getInvoices());
		}

		if (tariffSchemaEntityDto.getTariffDefinitions() != null) {
			this.setTariffDefinitions(tariffSchemaEntityDto.getTariffDefinitions());
		}

		if (tariffSchemaEntityDto.getTariffScheme() != null) {
			this.setTariffScheme(tariffSchemaEntityDto.getTariffScheme());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Schema Code here] off begin
	@CsvBindByName(column = "SCHEMA_CODE", required = true)
	@NotNull(message = "Schema Code must not be empty")
	@Column(name = "schema_code")
	@Schema(description = "The Schema Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Schema Code here] end
	private String schemaCode;

	// % protected region % [Modify attribute annotation for Scheme Name here] off begin
	@CsvBindByName(column = "SCHEME_NAME", required = true)
	@NotNull(message = "Scheme Name must not be empty")
	@Column(name = "scheme_name")
	@Schema(description = "The Scheme Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Scheme Name here] end
	private String schemeName;

	// % protected region % [Modify attribute annotation for Start Date here] off begin

	@CsvCustomBindByName(column = "START_DATE", converter = DateTimeConverter.class, required = true)
	@NotNull(message = "Start Date must not be empty")
	@Column(name = "start_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Start Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Start Date here] end
	private OffsetDateTime startDate;

	// % protected region % [Modify attribute annotation for End Date here] off begin

	@CsvCustomBindByName(column = "END_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "end_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The End Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for End Date here] end
	private OffsetDateTime endDate;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Base Scheme here] off begin
	@Schema(description = "The Tariff Formula entities that are related to this entity.")
	@OneToMany(mappedBy = "baseSchema", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Base Scheme here] end
	private Set<TariffFormulaEntity> baseScheme = new HashSet<>();

	// % protected region % [Update the annotation for baseSchemeIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BASE_SCHEME_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for baseSchemeIds here] end
	private Set<UUID> baseSchemeIds = new HashSet<>();

	// % protected region % [Update the annotation for Invoice Items here] off begin
	@Schema(description = "The Invoice Item entities that are related to this entity.")
	@OneToMany(mappedBy = "tariffSchema", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice Items here] end
	private Set<InvoiceItemEntity> invoiceItems = new HashSet<>();

	// % protected region % [Update the annotation for invoiceItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for invoiceItemsIds here] end
	private Set<UUID> invoiceItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Invoices here] off begin
	@Schema(description = "The Invoice entities that are related to this entity.")
	@OneToMany(mappedBy = "tariffSchema", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoices here] end
	private Set<InvoiceEntity> invoices = new HashSet<>();

	// % protected region % [Update the annotation for invoicesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for invoicesIds here] end
	private Set<UUID> invoicesIds = new HashSet<>();

	// % protected region % [Update the annotation for Tariff Definitions here] off begin
	@Schema(description = "The Tariff Definition entities that are related to this entity.")
	@OneToMany(mappedBy = "priceSchema", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Tariff Definitions here] end
	private Set<TariffDefinitionEntity> tariffDefinitions = new HashSet<>();

	// % protected region % [Update the annotation for tariffDefinitionsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "TARIFF_DEFINITIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for tariffDefinitionsIds here] end
	private Set<UUID> tariffDefinitionsIds = new HashSet<>();

	// % protected region % [Update the annotation for Tariff Scheme here] off begin
	@Schema(description = "The Tariff Formula entities that are related to this entity.")
	@OneToMany(mappedBy = "tariffSchema", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Tariff Scheme here] end
	private Set<TariffFormulaEntity> tariffScheme = new HashSet<>();

	// % protected region % [Update the annotation for tariffSchemeIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "TARIFF_SCHEME_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for tariffSchemeIds here] end
	private Set<UUID> tariffSchemeIds = new HashSet<>();

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
	 * Similar to {@link this#addBaseScheme(TariffFormulaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffFormulaEntity to be added to this entity
	 */
	public void addBaseScheme(@NotNull TariffFormulaEntity entity) {
		addBaseScheme(entity, true);
	}

	/**
	 * Add a new TariffFormulaEntity to baseScheme in this entity.
	 *
	 * @param entity the given TariffFormulaEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBaseScheme(@NonNull TariffFormulaEntity entity, boolean reverseAdd) {
		if (!this.baseScheme.contains(entity)) {
			baseScheme.add(entity);
			if (reverseAdd) {
				entity.setBaseSchema(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBaseScheme(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffFormulaEntity to be added to this entity
	 */
	public void addBaseScheme(@NotNull Collection<TariffFormulaEntity> entities) {
		addBaseScheme(entities, true);
	}

	/**
	 * Add a new collection of TariffFormulaEntity to Base Scheme in this entity.
	 *
	 * @param entities the given collection of TariffFormulaEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBaseScheme(@NonNull Collection<TariffFormulaEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBaseScheme(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBaseScheme(TariffFormulaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffFormulaEntity to be set to this entity
	 */
	public void removeBaseScheme(@NotNull TariffFormulaEntity entity) {
		this.removeBaseScheme(entity, true);
	}

	/**
	 * Remove the given TariffFormulaEntity from this entity.
	 *
	 * @param entity the given TariffFormulaEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBaseScheme(@NotNull TariffFormulaEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBaseSchema(false);
		}
		this.baseScheme.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBaseScheme(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TariffFormulaEntity to be removed to this entity
	 */
	public void removeBaseScheme(@NotNull Collection<TariffFormulaEntity> entities) {
		this.removeBaseScheme(entities, true);
	}

	/**
	 * Remove the given collection of TariffFormulaEntity from  to this entity.
	 *
	 * @param entities the given collection of TariffFormulaEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBaseScheme(@NonNull Collection<TariffFormulaEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBaseScheme(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBaseScheme(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffFormulaEntity to be set to this entity
	 */
	public void setBaseScheme(@NotNull Collection<TariffFormulaEntity> entities) {
		setBaseScheme(entities, true);
	}

	/**
	 * Replace the current entities in Base Scheme with the given ones.
	 *
	 * @param entities the given collection of TariffFormulaEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBaseScheme(@NotNull Collection<TariffFormulaEntity> entities, boolean reverseAdd) {

		this.unsetBaseScheme();
		this.baseScheme = new HashSet<>(entities);
		if (reverseAdd) {
			this.baseScheme.forEach(baseSchemeEntity -> baseSchemeEntity.setBaseSchema(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBaseScheme(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBaseScheme() {
		this.unsetBaseScheme(true);
	}

	/**
	 * Remove all the entities in Base Scheme from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBaseScheme(boolean doReverse) {
		if (doReverse) {
			this.baseScheme.forEach(baseSchemeEntity -> baseSchemeEntity.unsetBaseSchema(false));
		}
		this.baseScheme.clear();
	}

/**
	 * Similar to {@link this#addInvoiceItems(InvoiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemEntity to be added to this entity
	 */
	public void addInvoiceItems(@NotNull InvoiceItemEntity entity) {
		addInvoiceItems(entity, true);
	}

	/**
	 * Add a new InvoiceItemEntity to invoiceItems in this entity.
	 *
	 * @param entity the given InvoiceItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoiceItems(@NonNull InvoiceItemEntity entity, boolean reverseAdd) {
		if (!this.invoiceItems.contains(entity)) {
			invoiceItems.add(entity);
			if (reverseAdd) {
				entity.setTariffSchema(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoiceItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be added to this entity
	 */
	public void addInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities) {
		addInvoiceItems(entities, true);
	}

	/**
	 * Add a new collection of InvoiceItemEntity to Invoice Items in this entity.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoiceItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoiceItems(InvoiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemEntity to be set to this entity
	 */
	public void removeInvoiceItems(@NotNull InvoiceItemEntity entity) {
		this.removeInvoiceItems(entity, true);
	}

	/**
	 * Remove the given InvoiceItemEntity from this entity.
	 *
	 * @param entity the given InvoiceItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoiceItems(@NotNull InvoiceItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTariffSchema(false);
		}
		this.invoiceItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoiceItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be removed to this entity
	 */
	public void removeInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities) {
		this.removeInvoiceItems(entities, true);
	}

	/**
	 * Remove the given collection of InvoiceItemEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoiceItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoiceItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be set to this entity
	 */
	public void setInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities) {
		setInvoiceItems(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Items with the given ones.
	 *
	 * @param entities the given collection of InvoiceItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {

		this.unsetInvoiceItems();
		this.invoiceItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoiceItems.forEach(invoiceItemsEntity -> invoiceItemsEntity.setTariffSchema(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoiceItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoiceItems() {
		this.unsetInvoiceItems(true);
	}

	/**
	 * Remove all the entities in Invoice Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoiceItems(boolean doReverse) {
		if (doReverse) {
			this.invoiceItems.forEach(invoiceItemsEntity -> invoiceItemsEntity.unsetTariffSchema(false));
		}
		this.invoiceItems.clear();
	}

/**
	 * Similar to {@link this#addInvoices(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be added to this entity
	 */
	public void addInvoices(@NotNull InvoiceEntity entity) {
		addInvoices(entity, true);
	}

	/**
	 * Add a new InvoiceEntity to invoices in this entity.
	 *
	 * @param entity the given InvoiceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoices(@NonNull InvoiceEntity entity, boolean reverseAdd) {
		if (!this.invoices.contains(entity)) {
			invoices.add(entity);
			if (reverseAdd) {
				entity.setTariffSchema(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceEntity to be added to this entity
	 */
	public void addInvoices(@NotNull Collection<InvoiceEntity> entities) {
		addInvoices(entities, true);
	}

	/**
	 * Add a new collection of InvoiceEntity to Invoices in this entity.
	 *
	 * @param entities the given collection of InvoiceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoices(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoices(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void removeInvoices(@NotNull InvoiceEntity entity) {
		this.removeInvoices(entity, true);
	}

	/**
	 * Remove the given InvoiceEntity from this entity.
	 *
	 * @param entity the given InvoiceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoices(@NotNull InvoiceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTariffSchema(false);
		}
		this.invoices.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoices(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoiceEntity to be removed to this entity
	 */
	public void removeInvoices(@NotNull Collection<InvoiceEntity> entities) {
		this.removeInvoices(entities, true);
	}

	/**
	 * Remove the given collection of InvoiceEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoiceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoices(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceEntity to be set to this entity
	 */
	public void setInvoices(@NotNull Collection<InvoiceEntity> entities) {
		setInvoices(entities, true);
	}

	/**
	 * Replace the current entities in Invoices with the given ones.
	 *
	 * @param entities the given collection of InvoiceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoices(@NotNull Collection<InvoiceEntity> entities, boolean reverseAdd) {

		this.unsetInvoices();
		this.invoices = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoices.forEach(invoicesEntity -> invoicesEntity.setTariffSchema(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoices(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoices() {
		this.unsetInvoices(true);
	}

	/**
	 * Remove all the entities in Invoices from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoices(boolean doReverse) {
		if (doReverse) {
			this.invoices.forEach(invoicesEntity -> invoicesEntity.unsetTariffSchema(false));
		}
		this.invoices.clear();
	}

/**
	 * Similar to {@link this#addTariffDefinitions(TariffDefinitionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffDefinitionEntity to be added to this entity
	 */
	public void addTariffDefinitions(@NotNull TariffDefinitionEntity entity) {
		addTariffDefinitions(entity, true);
	}

	/**
	 * Add a new TariffDefinitionEntity to tariffDefinitions in this entity.
	 *
	 * @param entity the given TariffDefinitionEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addTariffDefinitions(@NonNull TariffDefinitionEntity entity, boolean reverseAdd) {
		if (!this.tariffDefinitions.contains(entity)) {
			tariffDefinitions.add(entity);
			if (reverseAdd) {
				entity.setPriceSchema(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addTariffDefinitions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffDefinitionEntity to be added to this entity
	 */
	public void addTariffDefinitions(@NotNull Collection<TariffDefinitionEntity> entities) {
		addTariffDefinitions(entities, true);
	}

	/**
	 * Add a new collection of TariffDefinitionEntity to Tariff Definitions in this entity.
	 *
	 * @param entities the given collection of TariffDefinitionEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addTariffDefinitions(@NonNull Collection<TariffDefinitionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addTariffDefinitions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeTariffDefinitions(TariffDefinitionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffDefinitionEntity to be set to this entity
	 */
	public void removeTariffDefinitions(@NotNull TariffDefinitionEntity entity) {
		this.removeTariffDefinitions(entity, true);
	}

	/**
	 * Remove the given TariffDefinitionEntity from this entity.
	 *
	 * @param entity the given TariffDefinitionEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTariffDefinitions(@NotNull TariffDefinitionEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPriceSchema(false);
		}
		this.tariffDefinitions.remove(entity);
	}

	/**
	 * Similar to {@link this#removeTariffDefinitions(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TariffDefinitionEntity to be removed to this entity
	 */
	public void removeTariffDefinitions(@NotNull Collection<TariffDefinitionEntity> entities) {
		this.removeTariffDefinitions(entities, true);
	}

	/**
	 * Remove the given collection of TariffDefinitionEntity from  to this entity.
	 *
	 * @param entities the given collection of TariffDefinitionEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeTariffDefinitions(@NonNull Collection<TariffDefinitionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeTariffDefinitions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setTariffDefinitions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffDefinitionEntity to be set to this entity
	 */
	public void setTariffDefinitions(@NotNull Collection<TariffDefinitionEntity> entities) {
		setTariffDefinitions(entities, true);
	}

	/**
	 * Replace the current entities in Tariff Definitions with the given ones.
	 *
	 * @param entities the given collection of TariffDefinitionEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTariffDefinitions(@NotNull Collection<TariffDefinitionEntity> entities, boolean reverseAdd) {

		this.unsetTariffDefinitions();
		this.tariffDefinitions = new HashSet<>(entities);
		if (reverseAdd) {
			this.tariffDefinitions.forEach(tariffDefinitionsEntity -> tariffDefinitionsEntity.setPriceSchema(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetTariffDefinitions(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetTariffDefinitions() {
		this.unsetTariffDefinitions(true);
	}

	/**
	 * Remove all the entities in Tariff Definitions from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetTariffDefinitions(boolean doReverse) {
		if (doReverse) {
			this.tariffDefinitions.forEach(tariffDefinitionsEntity -> tariffDefinitionsEntity.unsetPriceSchema(false));
		}
		this.tariffDefinitions.clear();
	}

/**
	 * Similar to {@link this#addTariffScheme(TariffFormulaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffFormulaEntity to be added to this entity
	 */
	public void addTariffScheme(@NotNull TariffFormulaEntity entity) {
		addTariffScheme(entity, true);
	}

	/**
	 * Add a new TariffFormulaEntity to tariffScheme in this entity.
	 *
	 * @param entity the given TariffFormulaEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addTariffScheme(@NonNull TariffFormulaEntity entity, boolean reverseAdd) {
		if (!this.tariffScheme.contains(entity)) {
			tariffScheme.add(entity);
			if (reverseAdd) {
				entity.setTariffSchema(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addTariffScheme(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffFormulaEntity to be added to this entity
	 */
	public void addTariffScheme(@NotNull Collection<TariffFormulaEntity> entities) {
		addTariffScheme(entities, true);
	}

	/**
	 * Add a new collection of TariffFormulaEntity to Tariff Scheme in this entity.
	 *
	 * @param entities the given collection of TariffFormulaEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addTariffScheme(@NonNull Collection<TariffFormulaEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addTariffScheme(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeTariffScheme(TariffFormulaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffFormulaEntity to be set to this entity
	 */
	public void removeTariffScheme(@NotNull TariffFormulaEntity entity) {
		this.removeTariffScheme(entity, true);
	}

	/**
	 * Remove the given TariffFormulaEntity from this entity.
	 *
	 * @param entity the given TariffFormulaEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTariffScheme(@NotNull TariffFormulaEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTariffSchema(false);
		}
		this.tariffScheme.remove(entity);
	}

	/**
	 * Similar to {@link this#removeTariffScheme(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TariffFormulaEntity to be removed to this entity
	 */
	public void removeTariffScheme(@NotNull Collection<TariffFormulaEntity> entities) {
		this.removeTariffScheme(entities, true);
	}

	/**
	 * Remove the given collection of TariffFormulaEntity from  to this entity.
	 *
	 * @param entities the given collection of TariffFormulaEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeTariffScheme(@NonNull Collection<TariffFormulaEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeTariffScheme(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setTariffScheme(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffFormulaEntity to be set to this entity
	 */
	public void setTariffScheme(@NotNull Collection<TariffFormulaEntity> entities) {
		setTariffScheme(entities, true);
	}

	/**
	 * Replace the current entities in Tariff Scheme with the given ones.
	 *
	 * @param entities the given collection of TariffFormulaEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTariffScheme(@NotNull Collection<TariffFormulaEntity> entities, boolean reverseAdd) {

		this.unsetTariffScheme();
		this.tariffScheme = new HashSet<>(entities);
		if (reverseAdd) {
			this.tariffScheme.forEach(tariffSchemeEntity -> tariffSchemeEntity.setTariffSchema(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetTariffScheme(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetTariffScheme() {
		this.unsetTariffScheme(true);
	}

	/**
	 * Remove all the entities in Tariff Scheme from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetTariffScheme(boolean doReverse) {
		if (doReverse) {
			this.tariffScheme.forEach(tariffSchemeEntity -> tariffSchemeEntity.unsetTariffSchema(false));
		}
		this.tariffScheme.clear();
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
		return "SCHEMA_CODE,SCHEME_NAME,START_DATE,END_DATE,BASE_SCHEME_IDS,INVOICE_ITEMS_IDS,INVOICES_IDS,TARIFF_DEFINITIONS_IDS,TARIFF_SCHEME_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		this.baseSchemeIds = new HashSet<>();
		for (TariffFormulaEntity baseScheme: this.baseScheme) {
			this.baseSchemeIds.add(baseScheme.getId());
		}

		this.invoiceItemsIds = new HashSet<>();
		for (InvoiceItemEntity invoiceItems: this.invoiceItems) {
			this.invoiceItemsIds.add(invoiceItems.getId());
		}

		this.invoicesIds = new HashSet<>();
		for (InvoiceEntity invoices: this.invoices) {
			this.invoicesIds.add(invoices.getId());
		}

		this.tariffDefinitionsIds = new HashSet<>();
		for (TariffDefinitionEntity tariffDefinitions: this.tariffDefinitions) {
			this.tariffDefinitionsIds.add(tariffDefinitions.getId());
		}

		this.tariffSchemeIds = new HashSet<>();
		for (TariffFormulaEntity tariffScheme: this.tariffScheme) {
			this.tariffSchemeIds.add(tariffScheme.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object tariffSchema) {
		if (this == tariffSchema) {
			return true;
		}
		if (tariffSchema == null || this.getClass() != tariffSchema.getClass()) {
			return false;
		}
		if (!super.equals(tariffSchema)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		TariffSchemaEntity that = (TariffSchemaEntity) tariffSchema;
		return
			Objects.equals(this.schemaCode, that.schemaCode) &&
			Objects.equals(this.schemeName, that.schemeName) &&
			Objects.equals(
			     this.startDate != null ? this.startDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.startDate != null ? that.startDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.endDate != null ? this.endDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.endDate != null ? that.endDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.baseSchemeIds, that.baseSchemeIds) &&
			Objects.equals(this.invoiceItemsIds, that.invoiceItemsIds) &&
			Objects.equals(this.invoicesIds, that.invoicesIds) &&
			Objects.equals(this.tariffDefinitionsIds, that.tariffDefinitionsIds) &&
			Objects.equals(this.tariffSchemeIds, that.tariffSchemeIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
