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
public class BpjsDrugGenericPRBEntity extends AbstractEntity {

	public BpjsDrugGenericPRBEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BpjsPRBDetailsOneMany = new EntityReference();
			BpjsPRBDetailsOneMany.entityName = "BpjsPRBDetail";
			BpjsPRBDetailsOneMany.oppositeName = "BpjsDrugGenericPRB";
			BpjsPRBDetailsOneMany.name = "BpjsPRBDetails";
			BpjsPRBDetailsOneMany.optional = true;
			BpjsPRBDetailsOneMany.type = "One";
			BpjsPRBDetailsOneMany.oppositeType = "Many";

		References.add(BpjsPRBDetailsOneMany);

		var StockCatalogueOneOne = new EntityReference();
			StockCatalogueOneOne.entityName = "StockCatalogue";
			StockCatalogueOneOne.oppositeName = "BpjsDrugGenericPRB";
			StockCatalogueOneOne.name = "StockCatalogue";
			StockCatalogueOneOne.optional = true;
			StockCatalogueOneOne.type = "One";
			StockCatalogueOneOne.oppositeType = "One";

		References.add(StockCatalogueOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Ref Drug Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Ref Drug Code here] end
	private String refDrugCode;

	// % protected region % [Modify attribute annotation for Ref Drug Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Ref Drug Name here] end
	private String refDrugName;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private StockCatalogueEntity stockCatalogue;

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

	private Set<BpjsPRBDetailEntity> bpjsPRBDetails = new HashSet<>();

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
	 * Similar to {@link this#addBpjsPRBDetails(BpjsPRBDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPRBDetailEntity to be added to this entity
	 */
	public void addBpjsPRBDetails(@NonNull BpjsPRBDetailEntity entity) {
		addBpjsPRBDetails(entity, true);
	}

	/**
	 * Add a new BpjsPRBDetailEntity to bpjsPRBDetails in this entity.
	 *
	 * @param entity the given BpjsPRBDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsPRBDetails(@NonNull BpjsPRBDetailEntity entity, boolean reverseAdd) {
		if (!this.bpjsPRBDetails.contains(entity)) {
			bpjsPRBDetails.add(entity);
			if (reverseAdd) {
				entity.setBpjsDrugGenericPRB(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsPRBDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPRBDetailEntity to be added to this entity
	 */
	public void addBpjsPRBDetails(@NonNull Collection<BpjsPRBDetailEntity> entities) {
		addBpjsPRBDetails(entities, true);
	}

	/**
	 * Add a new collection of BpjsPRBDetailEntity to BPJS PRB Details in this entity.
	 *
	 * @param entities the given collection of BpjsPRBDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsPRBDetails(@NonNull Collection<BpjsPRBDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsPRBDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsPRBDetails(BpjsPRBDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPRBDetailEntity to be set to this entity
	 */
	public void removeBpjsPRBDetails(@NonNull BpjsPRBDetailEntity entity) {
		this.removeBpjsPRBDetails(entity, true);
	}

	/**
	 * Remove the given BpjsPRBDetailEntity from this entity.
	 *
	 * @param entity the given BpjsPRBDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsPRBDetails(@NonNull BpjsPRBDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsDrugGenericPRB(false);
		}
		this.bpjsPRBDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsPRBDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsPRBDetailEntity to be removed to this entity
	 */
	public void removeBpjsPRBDetails(@NonNull Collection<BpjsPRBDetailEntity> entities) {
		this.removeBpjsPRBDetails(entities, true);
	}

	/**
	 * Remove the given collection of BpjsPRBDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsPRBDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsPRBDetails(@NonNull Collection<BpjsPRBDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsPRBDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsPRBDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPRBDetailEntity to be set to this entity
	 */
	public void setBpjsPRBDetails(@NonNull Collection<BpjsPRBDetailEntity> entities) {
		setBpjsPRBDetails(entities, true);
	}

	/**
	 * Replace the current entities in BPJS PRB Details with the given ones.
	 *
	 * @param entities the given collection of BpjsPRBDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsPRBDetails(@NonNull Collection<BpjsPRBDetailEntity> entities, boolean reverseAdd) {

		this.unsetBpjsPRBDetails();
		this.bpjsPRBDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsPRBDetails.forEach(bpjsPRBDetailsEntity -> bpjsPRBDetailsEntity.setBpjsDrugGenericPRB(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsPRBDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsPRBDetails() {
		this.unsetBpjsPRBDetails(true);
	}

	/**
	 * Remove all the entities in BPJS PRB Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsPRBDetails(boolean doReverse) {
		if (doReverse) {
			this.bpjsPRBDetails.forEach(bpjsPRBDetailsEntity -> bpjsPRBDetailsEntity.unsetBpjsDrugGenericPRB(false));
		}
		this.bpjsPRBDetails.clear();
	}

	/**
	 * Similar to {@link this#setStockCatalogue(StockCatalogueEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDrugGenericPRBEntity to be set to this entity
	 */
	public void setStockCatalogue(@NonNull StockCatalogueEntity entity) {
		setStockCatalogue(entity, true);
	}

	/**
	 * Set or update stockCatalogue with the given StockCatalogueEntity.
	 *
	 * @param entity the BpjsDrugGenericPRBEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogue(@NonNull StockCatalogueEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] end

		if (sameAsFormer(this.stockCatalogue, entity)) {
			return;
		}

		if (this.stockCatalogue != null) {
			this.stockCatalogue.unsetBpjsDrugGenericPRB();
		}

		this.stockCatalogue = entity;

		if (reverseAdd) {
			this.stockCatalogue.setBpjsDrugGenericPRB(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStockCatalogue outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStockCatalogue outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetStockCatalogue(boolean)} but default to true.
	 */
	public void unsetStockCatalogue() {
		this.unsetStockCatalogue(true);
	}

	/**
	 * Remove the StockCatalogueEntity in Stock Catalogue from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStockCatalogue(boolean reverse) {
		if (reverse && this.stockCatalogue != null) {
			this.stockCatalogue.unsetBpjsDrugGenericPRB(false);
		}
		this.stockCatalogue = null;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
