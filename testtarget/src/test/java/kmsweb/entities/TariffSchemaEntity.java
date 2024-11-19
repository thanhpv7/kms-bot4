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

import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class TariffSchemaEntity extends AbstractEntity {

	public TariffSchemaEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BaseSchemeOneMany = new EntityReference();
			BaseSchemeOneMany.entityName = "TariffFormula";
			BaseSchemeOneMany.oppositeName = "BaseSchema";
			BaseSchemeOneMany.name = "BaseScheme";
			BaseSchemeOneMany.optional = true;
			BaseSchemeOneMany.type = "One";
			BaseSchemeOneMany.oppositeType = "Many";

		References.add(BaseSchemeOneMany);

		var InvoiceItemsOneMany = new EntityReference();
			InvoiceItemsOneMany.entityName = "InvoiceItem";
			InvoiceItemsOneMany.oppositeName = "TariffSchema";
			InvoiceItemsOneMany.name = "InvoiceItems";
			InvoiceItemsOneMany.optional = true;
			InvoiceItemsOneMany.type = "One";
			InvoiceItemsOneMany.oppositeType = "Many";

		References.add(InvoiceItemsOneMany);

		var InvoicesOneMany = new EntityReference();
			InvoicesOneMany.entityName = "Invoice";
			InvoicesOneMany.oppositeName = "TariffSchema";
			InvoicesOneMany.name = "Invoices";
			InvoicesOneMany.optional = true;
			InvoicesOneMany.type = "One";
			InvoicesOneMany.oppositeType = "Many";

		References.add(InvoicesOneMany);

		var TariffDefinitionsOneMany = new EntityReference();
			TariffDefinitionsOneMany.entityName = "TariffDefinition";
			TariffDefinitionsOneMany.oppositeName = "PriceSchema";
			TariffDefinitionsOneMany.name = "TariffDefinitions";
			TariffDefinitionsOneMany.optional = true;
			TariffDefinitionsOneMany.type = "One";
			TariffDefinitionsOneMany.oppositeType = "Many";

		References.add(TariffDefinitionsOneMany);

		var TariffSchemeOneMany = new EntityReference();
			TariffSchemeOneMany.entityName = "TariffFormula";
			TariffSchemeOneMany.oppositeName = "TariffSchema";
			TariffSchemeOneMany.name = "TariffScheme";
			TariffSchemeOneMany.optional = true;
			TariffSchemeOneMany.type = "One";
			TariffSchemeOneMany.oppositeType = "Many";

		References.add(TariffSchemeOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Schema Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Schema Code here] end
	private String schemaCode;

	// % protected region % [Modify attribute annotation for Scheme Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Scheme Name here] end
	private String schemeName;

	// % protected region % [Modify attribute annotation for Start Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Start Date here] end
	private OffsetDateTime startDate;

	// % protected region % [Modify attribute annotation for End Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for End Date here] end
	private OffsetDateTime endDate;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<TariffFormulaEntity> baseScheme = new HashSet<>();

	private Set<InvoiceItemEntity> invoiceItems = new HashSet<>();

	private Set<InvoiceEntity> invoices = new HashSet<>();

	private Set<TariffDefinitionEntity> tariffDefinitions = new HashSet<>();

	private Set<TariffFormulaEntity> tariffScheme = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
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
	public void addBaseScheme(@NonNull TariffFormulaEntity entity) {
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
	public void addBaseScheme(@NonNull Collection<TariffFormulaEntity> entities) {
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
	public void removeBaseScheme(@NonNull TariffFormulaEntity entity) {
		this.removeBaseScheme(entity, true);
	}

	/**
	 * Remove the given TariffFormulaEntity from this entity.
	 *
	 * @param entity the given TariffFormulaEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBaseScheme(@NonNull TariffFormulaEntity entity, boolean reverse) {
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
	public void removeBaseScheme(@NonNull Collection<TariffFormulaEntity> entities) {
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
	public void setBaseScheme(@NonNull Collection<TariffFormulaEntity> entities) {
		setBaseScheme(entities, true);
	}

	/**
	 * Replace the current entities in Base Scheme with the given ones.
	 *
	 * @param entities the given collection of TariffFormulaEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBaseScheme(@NonNull Collection<TariffFormulaEntity> entities, boolean reverseAdd) {

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
	public void addInvoiceItems(@NonNull InvoiceItemEntity entity) {
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
	public void addInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities) {
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
	public void removeInvoiceItems(@NonNull InvoiceItemEntity entity) {
		this.removeInvoiceItems(entity, true);
	}

	/**
	 * Remove the given InvoiceItemEntity from this entity.
	 *
	 * @param entity the given InvoiceItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoiceItems(@NonNull InvoiceItemEntity entity, boolean reverse) {
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
	public void removeInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities) {
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
	public void setInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities) {
		setInvoiceItems(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Items with the given ones.
	 *
	 * @param entities the given collection of InvoiceItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {

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
	public void addInvoices(@NonNull InvoiceEntity entity) {
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
	public void addInvoices(@NonNull Collection<InvoiceEntity> entities) {
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
	public void removeInvoices(@NonNull InvoiceEntity entity) {
		this.removeInvoices(entity, true);
	}

	/**
	 * Remove the given InvoiceEntity from this entity.
	 *
	 * @param entity the given InvoiceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoices(@NonNull InvoiceEntity entity, boolean reverse) {
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
	public void removeInvoices(@NonNull Collection<InvoiceEntity> entities) {
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
	public void setInvoices(@NonNull Collection<InvoiceEntity> entities) {
		setInvoices(entities, true);
	}

	/**
	 * Replace the current entities in Invoices with the given ones.
	 *
	 * @param entities the given collection of InvoiceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoices(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {

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
	public void addTariffDefinitions(@NonNull TariffDefinitionEntity entity) {
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
	public void addTariffDefinitions(@NonNull Collection<TariffDefinitionEntity> entities) {
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
	public void removeTariffDefinitions(@NonNull TariffDefinitionEntity entity) {
		this.removeTariffDefinitions(entity, true);
	}

	/**
	 * Remove the given TariffDefinitionEntity from this entity.
	 *
	 * @param entity the given TariffDefinitionEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTariffDefinitions(@NonNull TariffDefinitionEntity entity, boolean reverse) {
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
	public void removeTariffDefinitions(@NonNull Collection<TariffDefinitionEntity> entities) {
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
	public void setTariffDefinitions(@NonNull Collection<TariffDefinitionEntity> entities) {
		setTariffDefinitions(entities, true);
	}

	/**
	 * Replace the current entities in Tariff Definitions with the given ones.
	 *
	 * @param entities the given collection of TariffDefinitionEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTariffDefinitions(@NonNull Collection<TariffDefinitionEntity> entities, boolean reverseAdd) {

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
	public void addTariffScheme(@NonNull TariffFormulaEntity entity) {
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
	public void addTariffScheme(@NonNull Collection<TariffFormulaEntity> entities) {
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
	public void removeTariffScheme(@NonNull TariffFormulaEntity entity) {
		this.removeTariffScheme(entity, true);
	}

	/**
	 * Remove the given TariffFormulaEntity from this entity.
	 *
	 * @param entity the given TariffFormulaEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTariffScheme(@NonNull TariffFormulaEntity entity, boolean reverse) {
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
	public void removeTariffScheme(@NonNull Collection<TariffFormulaEntity> entities) {
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
	public void setTariffScheme(@NonNull Collection<TariffFormulaEntity> entities) {
		setTariffScheme(entities, true);
	}

	/**
	 * Replace the current entities in Tariff Scheme with the given ones.
	 *
	 * @param entities the given collection of TariffFormulaEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTariffScheme(@NonNull Collection<TariffFormulaEntity> entities, boolean reverseAdd) {

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



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
