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
public class MerchantEntity extends AbstractEntity {

	public MerchantEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var CashReceiptsOneMany = new EntityReference();
			CashReceiptsOneMany.entityName = "CashReceipt";
			CashReceiptsOneMany.oppositeName = "Merchant";
			CashReceiptsOneMany.name = "CashReceipts";
			CashReceiptsOneMany.optional = true;
			CashReceiptsOneMany.type = "One";
			CashReceiptsOneMany.oppositeType = "Many";

		References.add(CashReceiptsOneMany);

		var MerchantSurchargeAndFeesOneMany = new EntityReference();
			MerchantSurchargeAndFeesOneMany.entityName = "MerchantSurchargeAndFee";
			MerchantSurchargeAndFeesOneMany.oppositeName = "Merchant";
			MerchantSurchargeAndFeesOneMany.name = "MerchantSurchargeAndFees";
			MerchantSurchargeAndFeesOneMany.optional = true;
			MerchantSurchargeAndFeesOneMany.type = "One";
			MerchantSurchargeAndFeesOneMany.oppositeType = "Many";

		References.add(MerchantSurchargeAndFeesOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Merchant Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Merchant Name here] end
	private String merchantName;

	// % protected region % [Modify attribute annotation for Merchant Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Merchant Number here] end
	private String merchantNumber;

	// % protected region % [Modify attribute annotation for Bank Account here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Bank Account here] end
	private String bankAccount;

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

	private Set<CashReceiptEntity> cashReceipts = new HashSet<>();

	private Set<MerchantSurchargeAndFeeEntity> merchantSurchargeAndFees = new HashSet<>();

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
	 * Similar to {@link this#addCashReceipts(CashReceiptEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashReceiptEntity to be added to this entity
	 */
	public void addCashReceipts(@NonNull CashReceiptEntity entity) {
		addCashReceipts(entity, true);
	}

	/**
	 * Add a new CashReceiptEntity to cashReceipts in this entity.
	 *
	 * @param entity the given CashReceiptEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCashReceipts(@NonNull CashReceiptEntity entity, boolean reverseAdd) {
		if (!this.cashReceipts.contains(entity)) {
			cashReceipts.add(entity);
			if (reverseAdd) {
				entity.setMerchant(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCashReceipts(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CashReceiptEntity to be added to this entity
	 */
	public void addCashReceipts(@NonNull Collection<CashReceiptEntity> entities) {
		addCashReceipts(entities, true);
	}

	/**
	 * Add a new collection of CashReceiptEntity to Cash Receipts in this entity.
	 *
	 * @param entities the given collection of CashReceiptEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCashReceipts(@NonNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCashReceipts(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCashReceipts(CashReceiptEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashReceiptEntity to be set to this entity
	 */
	public void removeCashReceipts(@NonNull CashReceiptEntity entity) {
		this.removeCashReceipts(entity, true);
	}

	/**
	 * Remove the given CashReceiptEntity from this entity.
	 *
	 * @param entity the given CashReceiptEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCashReceipts(@NonNull CashReceiptEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMerchant(false);
		}
		this.cashReceipts.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCashReceipts(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CashReceiptEntity to be removed to this entity
	 */
	public void removeCashReceipts(@NonNull Collection<CashReceiptEntity> entities) {
		this.removeCashReceipts(entities, true);
	}

	/**
	 * Remove the given collection of CashReceiptEntity from  to this entity.
	 *
	 * @param entities the given collection of CashReceiptEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCashReceipts(@NonNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCashReceipts(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCashReceipts(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CashReceiptEntity to be set to this entity
	 */
	public void setCashReceipts(@NonNull Collection<CashReceiptEntity> entities) {
		setCashReceipts(entities, true);
	}

	/**
	 * Replace the current entities in Cash Receipts with the given ones.
	 *
	 * @param entities the given collection of CashReceiptEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCashReceipts(@NonNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {

		this.unsetCashReceipts();
		this.cashReceipts = new HashSet<>(entities);
		if (reverseAdd) {
			this.cashReceipts.forEach(cashReceiptsEntity -> cashReceiptsEntity.setMerchant(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCashReceipts(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCashReceipts() {
		this.unsetCashReceipts(true);
	}

	/**
	 * Remove all the entities in Cash Receipts from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCashReceipts(boolean doReverse) {
		if (doReverse) {
			this.cashReceipts.forEach(cashReceiptsEntity -> cashReceiptsEntity.unsetMerchant(false));
		}
		this.cashReceipts.clear();
	}

/**
	 * Similar to {@link this#addMerchantSurchargeAndFees(MerchantSurchargeAndFeeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MerchantSurchargeAndFeeEntity to be added to this entity
	 */
	public void addMerchantSurchargeAndFees(@NonNull MerchantSurchargeAndFeeEntity entity) {
		addMerchantSurchargeAndFees(entity, true);
	}

	/**
	 * Add a new MerchantSurchargeAndFeeEntity to merchantSurchargeAndFees in this entity.
	 *
	 * @param entity the given MerchantSurchargeAndFeeEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMerchantSurchargeAndFees(@NonNull MerchantSurchargeAndFeeEntity entity, boolean reverseAdd) {
		if (!this.merchantSurchargeAndFees.contains(entity)) {
			merchantSurchargeAndFees.add(entity);
			if (reverseAdd) {
				entity.setMerchant(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMerchantSurchargeAndFees(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MerchantSurchargeAndFeeEntity to be added to this entity
	 */
	public void addMerchantSurchargeAndFees(@NonNull Collection<MerchantSurchargeAndFeeEntity> entities) {
		addMerchantSurchargeAndFees(entities, true);
	}

	/**
	 * Add a new collection of MerchantSurchargeAndFeeEntity to Merchant Surcharge and Fees in this entity.
	 *
	 * @param entities the given collection of MerchantSurchargeAndFeeEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMerchantSurchargeAndFees(@NonNull Collection<MerchantSurchargeAndFeeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMerchantSurchargeAndFees(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMerchantSurchargeAndFees(MerchantSurchargeAndFeeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MerchantSurchargeAndFeeEntity to be set to this entity
	 */
	public void removeMerchantSurchargeAndFees(@NonNull MerchantSurchargeAndFeeEntity entity) {
		this.removeMerchantSurchargeAndFees(entity, true);
	}

	/**
	 * Remove the given MerchantSurchargeAndFeeEntity from this entity.
	 *
	 * @param entity the given MerchantSurchargeAndFeeEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMerchantSurchargeAndFees(@NonNull MerchantSurchargeAndFeeEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMerchant(false);
		}
		this.merchantSurchargeAndFees.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMerchantSurchargeAndFees(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MerchantSurchargeAndFeeEntity to be removed to this entity
	 */
	public void removeMerchantSurchargeAndFees(@NonNull Collection<MerchantSurchargeAndFeeEntity> entities) {
		this.removeMerchantSurchargeAndFees(entities, true);
	}

	/**
	 * Remove the given collection of MerchantSurchargeAndFeeEntity from  to this entity.
	 *
	 * @param entities the given collection of MerchantSurchargeAndFeeEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMerchantSurchargeAndFees(@NonNull Collection<MerchantSurchargeAndFeeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMerchantSurchargeAndFees(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMerchantSurchargeAndFees(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MerchantSurchargeAndFeeEntity to be set to this entity
	 */
	public void setMerchantSurchargeAndFees(@NonNull Collection<MerchantSurchargeAndFeeEntity> entities) {
		setMerchantSurchargeAndFees(entities, true);
	}

	/**
	 * Replace the current entities in Merchant Surcharge and Fees with the given ones.
	 *
	 * @param entities the given collection of MerchantSurchargeAndFeeEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMerchantSurchargeAndFees(@NonNull Collection<MerchantSurchargeAndFeeEntity> entities, boolean reverseAdd) {

		this.unsetMerchantSurchargeAndFees();
		this.merchantSurchargeAndFees = new HashSet<>(entities);
		if (reverseAdd) {
			this.merchantSurchargeAndFees.forEach(merchantSurchargeAndFeesEntity -> merchantSurchargeAndFeesEntity.setMerchant(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMerchantSurchargeAndFees(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMerchantSurchargeAndFees() {
		this.unsetMerchantSurchargeAndFees(true);
	}

	/**
	 * Remove all the entities in Merchant Surcharge and Fees from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMerchantSurchargeAndFees(boolean doReverse) {
		if (doReverse) {
			this.merchantSurchargeAndFees.forEach(merchantSurchargeAndFeesEntity -> merchantSurchargeAndFeesEntity.unsetMerchant(false));
		}
		this.merchantSurchargeAndFees.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
