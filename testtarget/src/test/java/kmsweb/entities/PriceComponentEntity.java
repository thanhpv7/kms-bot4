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

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class PriceComponentEntity extends AbstractEntity {

	public PriceComponentEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InvoiceItemComponentsOneMany = new EntityReference();
			InvoiceItemComponentsOneMany.entityName = "InvoiceItemComponent";
			InvoiceItemComponentsOneMany.oppositeName = "PriceComponent";
			InvoiceItemComponentsOneMany.name = "InvoiceItemComponents";
			InvoiceItemComponentsOneMany.optional = true;
			InvoiceItemComponentsOneMany.type = "One";
			InvoiceItemComponentsOneMany.oppositeType = "Many";

		References.add(InvoiceItemComponentsOneMany);

		var MedicalFeeItemComponentsOneMany = new EntityReference();
			MedicalFeeItemComponentsOneMany.entityName = "MedicalFeeItemComponent";
			MedicalFeeItemComponentsOneMany.oppositeName = "PriceComponent";
			MedicalFeeItemComponentsOneMany.name = "MedicalFeeItemComponents";
			MedicalFeeItemComponentsOneMany.optional = true;
			MedicalFeeItemComponentsOneMany.type = "One";
			MedicalFeeItemComponentsOneMany.oppositeType = "Many";

		References.add(MedicalFeeItemComponentsOneMany);

		var TariffDefinitionOtherComponentsOneMany = new EntityReference();
			TariffDefinitionOtherComponentsOneMany.entityName = "TariffDefinitionOtherComponent";
			TariffDefinitionOtherComponentsOneMany.oppositeName = "PriceComponent";
			TariffDefinitionOtherComponentsOneMany.name = "TariffDefinitionOtherComponents";
			TariffDefinitionOtherComponentsOneMany.optional = true;
			TariffDefinitionOtherComponentsOneMany.type = "One";
			TariffDefinitionOtherComponentsOneMany.oppositeType = "Many";

		References.add(TariffDefinitionOtherComponentsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Component Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Component Code here] end
	private String componentCode;

	// % protected region % [Modify attribute annotation for Component Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Component Name here] end
	private String componentName;

	// % protected region % [Modify attribute annotation for COA COGS here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for COA COGS here] end
	private String coaCOGS;

	// % protected region % [Modify attribute annotation for COA Sell here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for COA Sell here] end
	private String coaSell;

	// % protected region % [Modify attribute annotation for COA Inventory here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for COA Inventory here] end
	private String coaInventory;

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

	private Set<InvoiceItemComponentEntity> invoiceItemComponents = new HashSet<>();

	private Set<MedicalFeeItemComponentEntity> medicalFeeItemComponents = new HashSet<>();

	private Set<TariffDefinitionOtherComponentEntity> tariffDefinitionOtherComponents = new HashSet<>();

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
	 * Similar to {@link this#addInvoiceItemComponents(InvoiceItemComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemComponentEntity to be added to this entity
	 */
	public void addInvoiceItemComponents(@NonNull InvoiceItemComponentEntity entity) {
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
	public void addInvoiceItemComponents(@NonNull Collection<InvoiceItemComponentEntity> entities) {
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
	public void removeInvoiceItemComponents(@NonNull InvoiceItemComponentEntity entity) {
		this.removeInvoiceItemComponents(entity, true);
	}

	/**
	 * Remove the given InvoiceItemComponentEntity from this entity.
	 *
	 * @param entity the given InvoiceItemComponentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoiceItemComponents(@NonNull InvoiceItemComponentEntity entity, boolean reverse) {
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
	public void removeInvoiceItemComponents(@NonNull Collection<InvoiceItemComponentEntity> entities) {
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
	public void setInvoiceItemComponents(@NonNull Collection<InvoiceItemComponentEntity> entities) {
		setInvoiceItemComponents(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Item Components with the given ones.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoiceItemComponents(@NonNull Collection<InvoiceItemComponentEntity> entities, boolean reverseAdd) {

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
	public void addMedicalFeeItemComponents(@NonNull MedicalFeeItemComponentEntity entity) {
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
	public void addMedicalFeeItemComponents(@NonNull Collection<MedicalFeeItemComponentEntity> entities) {
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
	public void removeMedicalFeeItemComponents(@NonNull MedicalFeeItemComponentEntity entity) {
		this.removeMedicalFeeItemComponents(entity, true);
	}

	/**
	 * Remove the given MedicalFeeItemComponentEntity from this entity.
	 *
	 * @param entity the given MedicalFeeItemComponentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalFeeItemComponents(@NonNull MedicalFeeItemComponentEntity entity, boolean reverse) {
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
	public void removeMedicalFeeItemComponents(@NonNull Collection<MedicalFeeItemComponentEntity> entities) {
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
	public void setMedicalFeeItemComponents(@NonNull Collection<MedicalFeeItemComponentEntity> entities) {
		setMedicalFeeItemComponents(entities, true);
	}

	/**
	 * Replace the current entities in Medical Fee Item Components with the given ones.
	 *
	 * @param entities the given collection of MedicalFeeItemComponentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalFeeItemComponents(@NonNull Collection<MedicalFeeItemComponentEntity> entities, boolean reverseAdd) {

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
	public void addTariffDefinitionOtherComponents(@NonNull TariffDefinitionOtherComponentEntity entity) {
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
	public void addTariffDefinitionOtherComponents(@NonNull Collection<TariffDefinitionOtherComponentEntity> entities) {
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
	public void removeTariffDefinitionOtherComponents(@NonNull TariffDefinitionOtherComponentEntity entity) {
		this.removeTariffDefinitionOtherComponents(entity, true);
	}

	/**
	 * Remove the given TariffDefinitionOtherComponentEntity from this entity.
	 *
	 * @param entity the given TariffDefinitionOtherComponentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTariffDefinitionOtherComponents(@NonNull TariffDefinitionOtherComponentEntity entity, boolean reverse) {
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
	public void removeTariffDefinitionOtherComponents(@NonNull Collection<TariffDefinitionOtherComponentEntity> entities) {
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
	public void setTariffDefinitionOtherComponents(@NonNull Collection<TariffDefinitionOtherComponentEntity> entities) {
		setTariffDefinitionOtherComponents(entities, true);
	}

	/**
	 * Replace the current entities in Tariff Definition Other Components with the given ones.
	 *
	 * @param entities the given collection of TariffDefinitionOtherComponentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTariffDefinitionOtherComponents(@NonNull Collection<TariffDefinitionOtherComponentEntity> entities, boolean reverseAdd) {

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



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
