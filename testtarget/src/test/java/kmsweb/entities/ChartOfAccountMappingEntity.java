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


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class ChartOfAccountMappingEntity extends AbstractEntity {

	public ChartOfAccountMappingEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var ChartOfAccountOneMany = new EntityReference();
			ChartOfAccountOneMany.entityName = "ChartOfAccount";
			ChartOfAccountOneMany.oppositeName = "ChartOfAccount";
			ChartOfAccountOneMany.name = "ChartOfAccountMappings";
			ChartOfAccountOneMany.optional = true;
			ChartOfAccountOneMany.type = "One";
			ChartOfAccountOneMany.oppositeType = "Many";

		References.add(ChartOfAccountOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Account Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Account Type here] end
	private String accountType;

	// % protected region % [Modify attribute annotation for Account Type Description here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Account Type Description here] end
	private String accountTypeDescription;

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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private ChartOfAccountEntity chartOfAccount;

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


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setChartOfAccount(ChartOfAccountEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ChartOfAccountEntity to be set to this entity
	 */
	public void setChartOfAccount(@NonNull ChartOfAccountEntity entity) {
		setChartOfAccount(entity, true);
	}

	/**
	 * Set or update the chartOfAccount in this entity with single ChartOfAccountEntity.
	 *
	 * @param entity the given ChartOfAccountEntity to be set or updated to chartOfAccount
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setChartOfAccount(@NonNull ChartOfAccountEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setChartOfAccount here] off begin
		// % protected region % [Add any additional logic here before the main logic for setChartOfAccount here] end

		if (sameAsFormer(this.chartOfAccount, entity)) {
			return;
		}

		if (this.chartOfAccount != null) {
			this.chartOfAccount.removeChartOfAccountMappings(this, false);
		}
		this.chartOfAccount = entity;
		if (reverseAdd) {
			this.chartOfAccount.addChartOfAccountMappings(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setChartOfAccount incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setChartOfAccount incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetChartOfAccount(boolean)} but default to true.
	 */
	public void unsetChartOfAccount() {
		this.unsetChartOfAccount(true);
	}

	/**
	 * Remove Chart of Account in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetChartOfAccount(boolean reverse) {
		if (reverse && this.chartOfAccount != null) {
			this.chartOfAccount.removeChartOfAccountMappings(this, false);
		}
		this.chartOfAccount = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
