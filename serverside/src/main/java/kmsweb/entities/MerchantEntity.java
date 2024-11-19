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
import kmsweb.dtos.MerchantEntityDto;
import kmsweb.entities.listeners.MerchantEntityListener;
import kmsweb.serializers.MerchantSerializer;
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
@EntityListeners({MerchantEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = MerchantSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"merchant_number"}, name = "merchant_number"),
	}
)
public class MerchantEntity extends AbstractEntity {

	/**
	 * Takes a MerchantEntityDto and converts it into a MerchantEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param merchantEntityDto
	 */
	public MerchantEntity(MerchantEntityDto merchantEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (merchantEntityDto.getId() != null) {
			this.setId(merchantEntityDto.getId());
		}

		if (merchantEntityDto.getMerchantName() != null) {
			this.setMerchantName(merchantEntityDto.getMerchantName());
		}

		if (merchantEntityDto.getMerchantNumber() != null) {
			this.setMerchantNumber(merchantEntityDto.getMerchantNumber());
		}

		if (merchantEntityDto.getBankAccount() != null) {
			this.setBankAccount(merchantEntityDto.getBankAccount());
		}

		if (merchantEntityDto.getCashReceipts() != null) {
			this.setCashReceipts(merchantEntityDto.getCashReceipts());
		}

		if (merchantEntityDto.getMerchantSurchargeAndFees() != null) {
			this.setMerchantSurchargeAndFees(merchantEntityDto.getMerchantSurchargeAndFees());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Merchant Name here] off begin
	@CsvBindByName(column = "MERCHANT_NAME", required = true)
	@NotNull(message = "Merchant Name must not be empty")
	@Column(name = "merchant_name")
	@Schema(description = "The Merchant Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Merchant Name here] end
	private String merchantName;

	// % protected region % [Modify attribute annotation for Merchant Number here] off begin
	@CsvBindByName(column = "MERCHANT_NUMBER", required = true)
	@NotNull(message = "Merchant Number must not be empty")
	@Column(name = "merchant_number")
	@Schema(description = "The Merchant Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Merchant Number here] end
	private String merchantNumber;

	// % protected region % [Modify attribute annotation for Bank Account here] off begin
	@CsvBindByName(column = "BANK_ACCOUNT", required = true)
	@NotNull(message = "Bank Account must not be empty")
	@Column(name = "bank_account")
	@Schema(description = "The Bank Account of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Bank Account here] end
	private String bankAccount;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Cash Receipts here] off begin
	@Schema(description = "The Cash Receipt entities that are related to this entity.")
	@OneToMany(mappedBy = "merchant", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Cash Receipts here] end
	private Set<CashReceiptEntity> cashReceipts = new HashSet<>();

	// % protected region % [Update the annotation for cashReceiptsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "CASH_RECEIPTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for cashReceiptsIds here] end
	private Set<UUID> cashReceiptsIds = new HashSet<>();

	// % protected region % [Update the annotation for Merchant Surcharge and Fees here] off begin
	@Schema(description = "The Merchant Surcharge and Fee entities that are related to this entity.")
	@OneToMany(mappedBy = "merchant", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Merchant Surcharge and Fees here] end
	private Set<MerchantSurchargeAndFeeEntity> merchantSurchargeAndFees = new HashSet<>();

	// % protected region % [Update the annotation for merchantSurchargeAndFeesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MERCHANT_SURCHARGE_AND_FEES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for merchantSurchargeAndFeesIds here] end
	private Set<UUID> merchantSurchargeAndFeesIds = new HashSet<>();

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
	 * Similar to {@link this#addCashReceipts(CashReceiptEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashReceiptEntity to be added to this entity
	 */
	public void addCashReceipts(@NotNull CashReceiptEntity entity) {
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
	public void addCashReceipts(@NotNull Collection<CashReceiptEntity> entities) {
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
	public void removeCashReceipts(@NotNull CashReceiptEntity entity) {
		this.removeCashReceipts(entity, true);
	}

	/**
	 * Remove the given CashReceiptEntity from this entity.
	 *
	 * @param entity the given CashReceiptEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCashReceipts(@NotNull CashReceiptEntity entity, boolean reverse) {
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
	public void removeCashReceipts(@NotNull Collection<CashReceiptEntity> entities) {
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
	public void setCashReceipts(@NotNull Collection<CashReceiptEntity> entities) {
		setCashReceipts(entities, true);
	}

	/**
	 * Replace the current entities in Cash Receipts with the given ones.
	 *
	 * @param entities the given collection of CashReceiptEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCashReceipts(@NotNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {

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
	public void addMerchantSurchargeAndFees(@NotNull MerchantSurchargeAndFeeEntity entity) {
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
	public void addMerchantSurchargeAndFees(@NotNull Collection<MerchantSurchargeAndFeeEntity> entities) {
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
	public void removeMerchantSurchargeAndFees(@NotNull MerchantSurchargeAndFeeEntity entity) {
		this.removeMerchantSurchargeAndFees(entity, true);
	}

	/**
	 * Remove the given MerchantSurchargeAndFeeEntity from this entity.
	 *
	 * @param entity the given MerchantSurchargeAndFeeEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMerchantSurchargeAndFees(@NotNull MerchantSurchargeAndFeeEntity entity, boolean reverse) {
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
	public void removeMerchantSurchargeAndFees(@NotNull Collection<MerchantSurchargeAndFeeEntity> entities) {
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
	public void setMerchantSurchargeAndFees(@NotNull Collection<MerchantSurchargeAndFeeEntity> entities) {
		setMerchantSurchargeAndFees(entities, true);
	}

	/**
	 * Replace the current entities in Merchant Surcharge and Fees with the given ones.
	 *
	 * @param entities the given collection of MerchantSurchargeAndFeeEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMerchantSurchargeAndFees(@NotNull Collection<MerchantSurchargeAndFeeEntity> entities, boolean reverseAdd) {

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



	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "MERCHANT_NAME,MERCHANT_NUMBER,BANK_ACCOUNT,CASH_RECEIPTS_IDS,MERCHANT_SURCHARGE_AND_FEES_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		this.cashReceiptsIds = new HashSet<>();
		for (CashReceiptEntity cashReceipts: this.cashReceipts) {
			this.cashReceiptsIds.add(cashReceipts.getId());
		}

		this.merchantSurchargeAndFeesIds = new HashSet<>();
		for (MerchantSurchargeAndFeeEntity merchantSurchargeAndFees: this.merchantSurchargeAndFees) {
			this.merchantSurchargeAndFeesIds.add(merchantSurchargeAndFees.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object merchant) {
		if (this == merchant) {
			return true;
		}
		if (merchant == null || this.getClass() != merchant.getClass()) {
			return false;
		}
		if (!super.equals(merchant)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		MerchantEntity that = (MerchantEntity) merchant;
		return
			Objects.equals(this.merchantName, that.merchantName) &&
			Objects.equals(this.merchantNumber, that.merchantNumber) &&
			Objects.equals(this.bankAccount, that.bankAccount) &&
			Objects.equals(this.cashReceiptsIds, that.cashReceiptsIds) &&
			Objects.equals(this.merchantSurchargeAndFeesIds, that.merchantSurchargeAndFeesIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
