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
import kmsweb.dtos.TransactionDetailTypeMappingEntityDto;
import kmsweb.entities.listeners.TransactionDetailTypeMappingEntityListener;
import kmsweb.serializers.TransactionDetailTypeMappingSerializer;
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
@EntityListeners({TransactionDetailTypeMappingEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = TransactionDetailTypeMappingSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class TransactionDetailTypeMappingEntity extends AbstractEntity {

	/**
	 * Takes a TransactionDetailTypeMappingEntityDto and converts it into a TransactionDetailTypeMappingEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param transactionDetailTypeMappingEntityDto
	 */
	public TransactionDetailTypeMappingEntity(TransactionDetailTypeMappingEntityDto transactionDetailTypeMappingEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (transactionDetailTypeMappingEntityDto.getId() != null) {
			this.setId(transactionDetailTypeMappingEntityDto.getId());
		}

		if (transactionDetailTypeMappingEntityDto.getTransactionType() != null) {
			this.setTransactionType(transactionDetailTypeMappingEntityDto.getTransactionType());
		}

		if (transactionDetailTypeMappingEntityDto.getTransactionDetailType() != null) {
			this.setTransactionDetailType(transactionDetailTypeMappingEntityDto.getTransactionDetailType());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Transaction Type here] off begin
	@CsvBindByName(column = "TRANSACTION_TYPE", required = false)
	@Nullable
	@Column(name = "transaction_type")
	@Schema(description = "The Transaction Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Type here] end
	private String transactionType;

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

	// % protected region % [Update the annotation for Transaction Detail Type here] off begin
	@Schema(description = "The Transaction Detail Type entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Transaction Detail Type here] end
	private TransactionDetailTypeEntity transactionDetailType;

	// % protected region % [Update the annotation for transactionDetailTypeId here] off begin
	@Transient
	@CsvCustomBindByName(column = "TRANSACTION_DETAIL_TYPE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for transactionDetailTypeId here] end
	private UUID transactionDetailTypeId;

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
	 * Similar to {@link this#setTransactionDetailType(TransactionDetailTypeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransactionDetailTypeEntity to be set to this entity
	 */
	public void setTransactionDetailType(@NotNull TransactionDetailTypeEntity entity) {
		setTransactionDetailType(entity, true);
	}

	/**
	 * Set or update the transactionDetailType in this entity with single TransactionDetailTypeEntity.
	 *
	 * @param entity the given TransactionDetailTypeEntity to be set or updated to transactionDetailType
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setTransactionDetailType(@NotNull TransactionDetailTypeEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setTransactionDetailType here] off begin
		// % protected region % [Add any additional logic here before the main logic for setTransactionDetailType here] end

		if (sameAsFormer(this.transactionDetailType, entity)) {
			return;
		}

		if (this.transactionDetailType != null) {
			this.transactionDetailType.removeTransactionDetailTypeMappings(this, false);
		}
		this.transactionDetailType = entity;
		if (reverseAdd) {
			this.transactionDetailType.addTransactionDetailTypeMappings(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setTransactionDetailType incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setTransactionDetailType incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetTransactionDetailType(boolean)} but default to true.
	 */
	public void unsetTransactionDetailType() {
		this.unsetTransactionDetailType(true);
	}

	/**
	 * Remove Transaction Detail Type in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetTransactionDetailType(boolean reverse) {
		if (reverse && this.transactionDetailType != null) {
			this.transactionDetailType.removeTransactionDetailTypeMappings(this, false);
		}
		this.transactionDetailType = null;
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
		return "TRANSACTION_TYPE,TRANSACTION_DETAIL_TYPE_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<TransactionDetailTypeEntity> transactionDetailTypeRelation = Optional.ofNullable(this.transactionDetailType);
		transactionDetailTypeRelation.ifPresent(entity -> this.transactionDetailTypeId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object transactionDetailTypeMapping) {
		if (this == transactionDetailTypeMapping) {
			return true;
		}
		if (transactionDetailTypeMapping == null || this.getClass() != transactionDetailTypeMapping.getClass()) {
			return false;
		}
		if (!super.equals(transactionDetailTypeMapping)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		TransactionDetailTypeMappingEntity that = (TransactionDetailTypeMappingEntity) transactionDetailTypeMapping;
		return
			Objects.equals(this.transactionType, that.transactionType) &&
			Objects.equals(this.transactionDetailTypeId, that.transactionDetailTypeId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
