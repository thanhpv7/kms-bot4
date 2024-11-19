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
public class MerchantSurchargeAndFeeEntity extends AbstractEntity {

	public MerchantSurchargeAndFeeEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var MerchantOneMany = new EntityReference();
			MerchantOneMany.entityName = "Merchant";
			MerchantOneMany.oppositeName = "Merchant";
			MerchantOneMany.name = "MerchantSurchargeAndFees";
			MerchantOneMany.optional = true;
			MerchantOneMany.type = "One";
			MerchantOneMany.oppositeType = "Many";

		References.add(MerchantOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Bank Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Bank Name here] end
	private String bankName;

	// % protected region % [Modify attribute annotation for Card Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Card Type here] end
	private String cardType;

	// % protected region % [Modify attribute annotation for Surcharge here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Surcharge here] end
	private Double surcharge;

	// % protected region % [Modify attribute annotation for Fee here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Fee here] end
	private String fee;

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

	private MerchantEntity merchant;

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
	 * Similar to {@link this#setMerchant(MerchantEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MerchantEntity to be set to this entity
	 */
	public void setMerchant(@NonNull MerchantEntity entity) {
		setMerchant(entity, true);
	}

	/**
	 * Set or update the merchant in this entity with single MerchantEntity.
	 *
	 * @param entity the given MerchantEntity to be set or updated to merchant
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMerchant(@NonNull MerchantEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMerchant here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMerchant here] end

		if (sameAsFormer(this.merchant, entity)) {
			return;
		}

		if (this.merchant != null) {
			this.merchant.removeMerchantSurchargeAndFees(this, false);
		}
		this.merchant = entity;
		if (reverseAdd) {
			this.merchant.addMerchantSurchargeAndFees(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMerchant incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMerchant incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMerchant(boolean)} but default to true.
	 */
	public void unsetMerchant() {
		this.unsetMerchant(true);
	}

	/**
	 * Remove Merchant in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMerchant(boolean reverse) {
		if (reverse && this.merchant != null) {
			this.merchant.removeMerchantSurchargeAndFees(this, false);
		}
		this.merchant = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
