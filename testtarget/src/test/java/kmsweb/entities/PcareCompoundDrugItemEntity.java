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
public class PcareCompoundDrugItemEntity extends AbstractEntity {

	public PcareCompoundDrugItemEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PcareCompoundDrugOneMany = new EntityReference();
			PcareCompoundDrugOneMany.entityName = "PcareCompoundDrug";
			PcareCompoundDrugOneMany.oppositeName = "PcareCompoundDrug";
			PcareCompoundDrugOneMany.name = "PcareCompoundDrugItems";
			PcareCompoundDrugOneMany.optional = true;
			PcareCompoundDrugOneMany.type = "One";
			PcareCompoundDrugOneMany.oppositeType = "Many";

		References.add(PcareCompoundDrugOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Drug Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Drug Code here] end
	private String drugCode;

	// % protected region % [Modify attribute annotation for Drug Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Drug Qty here] end
	private Double drugQty;

	// % protected region % [Modify attribute annotation for Request here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Request here] end
	private Double request;

	// % protected region % [Modify attribute annotation for Dose here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dose here] end
	private Double dose;

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

	private PcareCompoundDrugEntity pcareCompoundDrug;

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
	 * Similar to {@link this#setPcareCompoundDrug(PcareCompoundDrugEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareCompoundDrugEntity to be set to this entity
	 */
	public void setPcareCompoundDrug(@NonNull PcareCompoundDrugEntity entity) {
		setPcareCompoundDrug(entity, true);
	}

	/**
	 * Set or update the pcareCompoundDrug in this entity with single PcareCompoundDrugEntity.
	 *
	 * @param entity the given PcareCompoundDrugEntity to be set or updated to pcareCompoundDrug
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPcareCompoundDrug(@NonNull PcareCompoundDrugEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPcareCompoundDrug here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPcareCompoundDrug here] end

		if (sameAsFormer(this.pcareCompoundDrug, entity)) {
			return;
		}

		if (this.pcareCompoundDrug != null) {
			this.pcareCompoundDrug.removePcareCompoundDrugItems(this, false);
		}
		this.pcareCompoundDrug = entity;
		if (reverseAdd) {
			this.pcareCompoundDrug.addPcareCompoundDrugItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPcareCompoundDrug incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPcareCompoundDrug incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPcareCompoundDrug(boolean)} but default to true.
	 */
	public void unsetPcareCompoundDrug() {
		this.unsetPcareCompoundDrug(true);
	}

	/**
	 * Remove PCare Compound Drug in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPcareCompoundDrug(boolean reverse) {
		if (reverse && this.pcareCompoundDrug != null) {
			this.pcareCompoundDrug.removePcareCompoundDrugItems(this, false);
		}
		this.pcareCompoundDrug = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
