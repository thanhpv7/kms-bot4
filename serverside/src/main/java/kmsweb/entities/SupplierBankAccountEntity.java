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
import kmsweb.dtos.SupplierBankAccountEntityDto;
import kmsweb.entities.listeners.SupplierBankAccountEntityListener;
import kmsweb.serializers.SupplierBankAccountSerializer;
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
@EntityListeners({SupplierBankAccountEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = SupplierBankAccountSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class SupplierBankAccountEntity extends AbstractEntity {

	/**
	 * Takes a SupplierBankAccountEntityDto and converts it into a SupplierBankAccountEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param supplierBankAccountEntityDto
	 */
	public SupplierBankAccountEntity(SupplierBankAccountEntityDto supplierBankAccountEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (supplierBankAccountEntityDto.getId() != null) {
			this.setId(supplierBankAccountEntityDto.getId());
		}

		if (supplierBankAccountEntityDto.getBankName() != null) {
			this.setBankName(supplierBankAccountEntityDto.getBankName());
		}

		if (supplierBankAccountEntityDto.getAccountName() != null) {
			this.setAccountName(supplierBankAccountEntityDto.getAccountName());
		}

		if (supplierBankAccountEntityDto.getAccountNumber() != null) {
			this.setAccountNumber(supplierBankAccountEntityDto.getAccountNumber());
		}

		if (supplierBankAccountEntityDto.getCity() != null) {
			this.setCity(supplierBankAccountEntityDto.getCity());
		}

		if (supplierBankAccountEntityDto.getBranch() != null) {
			this.setBranch(supplierBankAccountEntityDto.getBranch());
		}

		if (supplierBankAccountEntityDto.getNotes() != null) {
			this.setNotes(supplierBankAccountEntityDto.getNotes());
		}

		if (supplierBankAccountEntityDto.getSupplier() != null) {
			this.setSupplier(supplierBankAccountEntityDto.getSupplier());
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

	// % protected region % [Modify attribute annotation for Account Name here] off begin
	@CsvBindByName(column = "ACCOUNT_NAME", required = true)
	@NotNull(message = "Account Name must not be empty")
	@Column(name = "account_name")
	@Schema(description = "The Account Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Account Name here] end
	private String accountName;

	// % protected region % [Modify attribute annotation for Account Number here] off begin
	@CsvBindByName(column = "ACCOUNT_NUMBER", required = true)
	@NotNull(message = "Account Number must not be empty")
	@Pattern(message = "Must match a valid numeric string",
			regexp = ValidatorPatterns.numeric)
	@Column(name = "account_number")
	@Schema(description = "The Account Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Account Number here] end
	private String accountNumber;

	// % protected region % [Modify attribute annotation for City here] off begin
	@CsvBindByName(column = "CITY", required = false)
	@Nullable
	@Column(name = "city")
	@Schema(description = "The City of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for City here] end
	private String city;

	// % protected region % [Modify attribute annotation for Branch here] off begin
	@CsvBindByName(column = "BRANCH", required = false)
	@Nullable
	@Column(name = "branch")
	@Schema(description = "The Branch of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Branch here] end
	private String branch;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Lob
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

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

	// % protected region % [Update the annotation for Supplier here] off begin
	@Schema(description = "The Supplier entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Supplier here] end
	private SupplierEntity supplier;

	// % protected region % [Update the annotation for supplierId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SUPPLIER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for supplierId here] end
	private UUID supplierId;

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
	 * Similar to {@link this#setSupplier(SupplierEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierEntity to be set to this entity
	 */
	public void setSupplier(@NotNull SupplierEntity entity) {
		setSupplier(entity, true);
	}

	/**
	 * Set or update the supplier in this entity with single SupplierEntity.
	 *
	 * @param entity the given SupplierEntity to be set or updated to supplier
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSupplier(@NotNull SupplierEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSupplier here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSupplier here] end

		if (sameAsFormer(this.supplier, entity)) {
			return;
		}

		if (this.supplier != null) {
			this.supplier.removeSupplierBankAccounts(this, false);
		}
		this.supplier = entity;
		if (reverseAdd) {
			this.supplier.addSupplierBankAccounts(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSupplier incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSupplier incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSupplier(boolean)} but default to true.
	 */
	public void unsetSupplier() {
		this.unsetSupplier(true);
	}

	/**
	 * Remove Supplier in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSupplier(boolean reverse) {
		if (reverse && this.supplier != null) {
			this.supplier.removeSupplierBankAccounts(this, false);
		}
		this.supplier = null;
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
		return "BANK_NAME,ACCOUNT_NAME,ACCOUNT_NUMBER,CITY,BRANCH,NOTES,SUPPLIER_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<SupplierEntity> supplierRelation = Optional.ofNullable(this.supplier);
		supplierRelation.ifPresent(entity -> this.supplierId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object supplierBankAccount) {
		if (this == supplierBankAccount) {
			return true;
		}
		if (supplierBankAccount == null || this.getClass() != supplierBankAccount.getClass()) {
			return false;
		}
		if (!super.equals(supplierBankAccount)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		SupplierBankAccountEntity that = (SupplierBankAccountEntity) supplierBankAccount;
		return
			Objects.equals(this.bankName, that.bankName) &&
			Objects.equals(this.accountName, that.accountName) &&
			Objects.equals(this.accountNumber, that.accountNumber) &&
			Objects.equals(this.city, that.city) &&
			Objects.equals(this.branch, that.branch) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.supplierId, that.supplierId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
