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
public class ChartOfAccountEntity extends AbstractEntity {

	public ChartOfAccountEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var ChartOfAccountMappingsOneMany = new EntityReference();
			ChartOfAccountMappingsOneMany.entityName = "ChartOfAccountMapping";
			ChartOfAccountMappingsOneMany.oppositeName = "ChartOfAccount";
			ChartOfAccountMappingsOneMany.name = "ChartOfAccountMappings";
			ChartOfAccountMappingsOneMany.optional = true;
			ChartOfAccountMappingsOneMany.type = "One";
			ChartOfAccountMappingsOneMany.oppositeType = "Many";

		References.add(ChartOfAccountMappingsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Account Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Account Code here] end
	private String accountCode;

	// % protected region % [Modify attribute annotation for Account Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Account Name here] end
	private String accountName;

	// % protected region % [Modify attribute annotation for Account Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Account Type here] end
	private String accountType;

	// % protected region % [Modify attribute annotation for Tax Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax Code here] end
	private String taxCode;

	// % protected region % [Modify attribute annotation for Dashboard here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dashboard here] end
	private Boolean dashboard;

	// % protected region % [Modify attribute annotation for Expense Claim here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Expense Claim here] end
	private Boolean expenseClaim;

	// % protected region % [Modify attribute annotation for Enable Payment here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Enable Payment here] end
	private Boolean enablePayment;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

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

	private Set<ChartOfAccountMappingEntity> chartOfAccountMappings = new HashSet<>();

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
	 * Similar to {@link this#addChartOfAccountMappings(ChartOfAccountMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ChartOfAccountMappingEntity to be added to this entity
	 */
	public void addChartOfAccountMappings(@NonNull ChartOfAccountMappingEntity entity) {
		addChartOfAccountMappings(entity, true);
	}

	/**
	 * Add a new ChartOfAccountMappingEntity to chartOfAccountMappings in this entity.
	 *
	 * @param entity the given ChartOfAccountMappingEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addChartOfAccountMappings(@NonNull ChartOfAccountMappingEntity entity, boolean reverseAdd) {
		if (!this.chartOfAccountMappings.contains(entity)) {
			chartOfAccountMappings.add(entity);
			if (reverseAdd) {
				entity.setChartOfAccount(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addChartOfAccountMappings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ChartOfAccountMappingEntity to be added to this entity
	 */
	public void addChartOfAccountMappings(@NonNull Collection<ChartOfAccountMappingEntity> entities) {
		addChartOfAccountMappings(entities, true);
	}

	/**
	 * Add a new collection of ChartOfAccountMappingEntity to Chart of Account Mappings in this entity.
	 *
	 * @param entities the given collection of ChartOfAccountMappingEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addChartOfAccountMappings(@NonNull Collection<ChartOfAccountMappingEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addChartOfAccountMappings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeChartOfAccountMappings(ChartOfAccountMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ChartOfAccountMappingEntity to be set to this entity
	 */
	public void removeChartOfAccountMappings(@NonNull ChartOfAccountMappingEntity entity) {
		this.removeChartOfAccountMappings(entity, true);
	}

	/**
	 * Remove the given ChartOfAccountMappingEntity from this entity.
	 *
	 * @param entity the given ChartOfAccountMappingEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeChartOfAccountMappings(@NonNull ChartOfAccountMappingEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetChartOfAccount(false);
		}
		this.chartOfAccountMappings.remove(entity);
	}

	/**
	 * Similar to {@link this#removeChartOfAccountMappings(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ChartOfAccountMappingEntity to be removed to this entity
	 */
	public void removeChartOfAccountMappings(@NonNull Collection<ChartOfAccountMappingEntity> entities) {
		this.removeChartOfAccountMappings(entities, true);
	}

	/**
	 * Remove the given collection of ChartOfAccountMappingEntity from  to this entity.
	 *
	 * @param entities the given collection of ChartOfAccountMappingEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeChartOfAccountMappings(@NonNull Collection<ChartOfAccountMappingEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeChartOfAccountMappings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setChartOfAccountMappings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ChartOfAccountMappingEntity to be set to this entity
	 */
	public void setChartOfAccountMappings(@NonNull Collection<ChartOfAccountMappingEntity> entities) {
		setChartOfAccountMappings(entities, true);
	}

	/**
	 * Replace the current entities in Chart of Account Mappings with the given ones.
	 *
	 * @param entities the given collection of ChartOfAccountMappingEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setChartOfAccountMappings(@NonNull Collection<ChartOfAccountMappingEntity> entities, boolean reverseAdd) {

		this.unsetChartOfAccountMappings();
		this.chartOfAccountMappings = new HashSet<>(entities);
		if (reverseAdd) {
			this.chartOfAccountMappings.forEach(chartOfAccountMappingsEntity -> chartOfAccountMappingsEntity.setChartOfAccount(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetChartOfAccountMappings(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetChartOfAccountMappings() {
		this.unsetChartOfAccountMappings(true);
	}

	/**
	 * Remove all the entities in Chart of Account Mappings from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetChartOfAccountMappings(boolean doReverse) {
		if (doReverse) {
			this.chartOfAccountMappings.forEach(chartOfAccountMappingsEntity -> chartOfAccountMappingsEntity.unsetChartOfAccount(false));
		}
		this.chartOfAccountMappings.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
