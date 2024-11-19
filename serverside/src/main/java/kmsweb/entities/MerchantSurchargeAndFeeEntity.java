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
import kmsweb.dtos.MerchantSurchargeAndFeeEntityDto;
import kmsweb.entities.listeners.MerchantSurchargeAndFeeEntityListener;
import kmsweb.serializers.MerchantSurchargeAndFeeSerializer;
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
@EntityListeners({MerchantSurchargeAndFeeEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = MerchantSurchargeAndFeeSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class MerchantSurchargeAndFeeEntity extends AbstractEntity {

	/**
	 * Takes a MerchantSurchargeAndFeeEntityDto and converts it into a MerchantSurchargeAndFeeEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param merchantSurchargeAndFeeEntityDto
	 */
	public MerchantSurchargeAndFeeEntity(MerchantSurchargeAndFeeEntityDto merchantSurchargeAndFeeEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (merchantSurchargeAndFeeEntityDto.getId() != null) {
			this.setId(merchantSurchargeAndFeeEntityDto.getId());
		}

		if (merchantSurchargeAndFeeEntityDto.getBankName() != null) {
			this.setBankName(merchantSurchargeAndFeeEntityDto.getBankName());
		}

		if (merchantSurchargeAndFeeEntityDto.getCardType() != null) {
			this.setCardType(merchantSurchargeAndFeeEntityDto.getCardType());
		}

		if (merchantSurchargeAndFeeEntityDto.getSurcharge() != null) {
			this.setSurcharge(merchantSurchargeAndFeeEntityDto.getSurcharge());
		}

		if (merchantSurchargeAndFeeEntityDto.getFee() != null) {
			this.setFee(merchantSurchargeAndFeeEntityDto.getFee());
		}

		if (merchantSurchargeAndFeeEntityDto.getMerchant() != null) {
			this.setMerchant(merchantSurchargeAndFeeEntityDto.getMerchant());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Bank Name here] off begin
	@CsvBindByName(column = "BANK_NAME", required = true)
	@NotNull(message = "Bank Name must not be empty")
	@Column(name = "bank_name")
	@Schema(description = "The Bank Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Bank Name here] end
	private String bankName;

	// % protected region % [Modify attribute annotation for Card Type here] off begin
	@CsvBindByName(column = "CARD_TYPE", required = true)
	@NotNull(message = "Card Type must not be empty")
	@Column(name = "card_type")
	@Schema(description = "The Card Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Card Type here] end
	private String cardType;

	// % protected region % [Modify attribute annotation for Surcharge here] off begin
	@CsvBindByName(column = "SURCHARGE", required = true)
	@NotNull(message = "Surcharge must not be empty")
	@Column(name = "surcharge")
	@Schema(description = "The Surcharge of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Surcharge here] end
	private Double surcharge;

	// % protected region % [Modify attribute annotation for Fee here] off begin
	@CsvBindByName(column = "FEE", required = true)
	@NotNull(message = "Fee must not be empty")
	@Column(name = "fee")
	@Schema(description = "The Fee of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Fee here] end
	private String fee;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Merchant here] off begin
	@Schema(description = "The Merchant entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Merchant here] end
	private MerchantEntity merchant;

	// % protected region % [Update the annotation for merchantId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MERCHANT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for merchantId here] end
	private UUID merchantId;

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
	public void setMerchant(@NotNull MerchantEntity entity) {
		setMerchant(entity, true);
	}

	/**
	 * Set or update the merchant in this entity with single MerchantEntity.
	 *
	 * @param entity the given MerchantEntity to be set or updated to merchant
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMerchant(@NotNull MerchantEntity entity, boolean reverseAdd) {
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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "BANK_NAME,CARD_TYPE,SURCHARGE,FEE,MERCHANT_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<MerchantEntity> merchantRelation = Optional.ofNullable(this.merchant);
		merchantRelation.ifPresent(entity -> this.merchantId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object merchantSurchargeAndFee) {
		if (this == merchantSurchargeAndFee) {
			return true;
		}
		if (merchantSurchargeAndFee == null || this.getClass() != merchantSurchargeAndFee.getClass()) {
			return false;
		}
		if (!super.equals(merchantSurchargeAndFee)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		MerchantSurchargeAndFeeEntity that = (MerchantSurchargeAndFeeEntity) merchantSurchargeAndFee;
		return
			Objects.equals(this.bankName, that.bankName) &&
			Objects.equals(this.cardType, that.cardType) &&
			Objects.equals(this.surcharge, that.surcharge) &&
			Objects.equals(this.fee, that.fee) &&
			Objects.equals(this.merchantId, that.merchantId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
