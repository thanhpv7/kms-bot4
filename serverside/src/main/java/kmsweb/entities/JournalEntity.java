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
import kmsweb.dtos.JournalEntityDto;
import kmsweb.entities.listeners.JournalEntityListener;
import kmsweb.serializers.JournalSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.deserializers.DateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import java.time.*;
import java.time.temporal.ChronoUnit;
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
@EntityListeners({JournalEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = JournalSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class JournalEntity extends AbstractEntity {

	/**
	 * Takes a JournalEntityDto and converts it into a JournalEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param journalEntityDto
	 */
	public JournalEntity(JournalEntityDto journalEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (journalEntityDto.getId() != null) {
			this.setId(journalEntityDto.getId());
		}

		if (journalEntityDto.getJournalNumber() != null) {
			this.setJournalNumber(journalEntityDto.getJournalNumber());
		}

		if (journalEntityDto.getTransactionDate() != null) {
			this.setTransactionDate(journalEntityDto.getTransactionDate());
		}

		if (journalEntityDto.getReferenceNumber() != null) {
			this.setReferenceNumber(journalEntityDto.getReferenceNumber());
		}

		if (journalEntityDto.getTransactionType() != null) {
			this.setTransactionType(journalEntityDto.getTransactionType());
		}

		if (journalEntityDto.getTransactionDetailType() != null) {
			this.setTransactionDetailType(journalEntityDto.getTransactionDetailType());
		}

		if (journalEntityDto.getAccountNumber() != null) {
			this.setAccountNumber(journalEntityDto.getAccountNumber());
		}

		if (journalEntityDto.getDebit() != null) {
			this.setDebit(journalEntityDto.getDebit());
		}

		if (journalEntityDto.getCredit() != null) {
			this.setCredit(journalEntityDto.getCredit());
		}

		if (journalEntityDto.getPostingStatus() != null) {
			this.setPostingStatus(journalEntityDto.getPostingStatus());
		}

		if (journalEntityDto.getPostingDateTime() != null) {
			this.setPostingDateTime(journalEntityDto.getPostingDateTime());
		}

		if (journalEntityDto.getSupplierNumber() != null) {
			this.setSupplierNumber(journalEntityDto.getSupplierNumber());
		}

		if (journalEntityDto.getSupplierName() != null) {
			this.setSupplierName(journalEntityDto.getSupplierName());
		}

		if (journalEntityDto.getCustomerNumber() != null) {
			this.setCustomerNumber(journalEntityDto.getCustomerNumber());
		}

		if (journalEntityDto.getCustomerName() != null) {
			this.setCustomerName(journalEntityDto.getCustomerName());
		}

		if (journalEntityDto.getRevenueCenter() != null) {
			this.setRevenueCenter(journalEntityDto.getRevenueCenter());
		}

		if (journalEntityDto.getDescription() != null) {
			this.setDescription(journalEntityDto.getDescription());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Journal Number here] off begin
	@CsvBindByName(column = "JOURNAL_NUMBER", required = false)
	@Nullable
	@Column(name = "journal_number")
	@Schema(description = "The Journal Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Journal Number here] end
	private String journalNumber;

	// % protected region % [Modify attribute annotation for Transaction Date here] off begin
	@CsvCustomBindByName(column = "TRANSACTION_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "transaction_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Transaction Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Date here] end
	private OffsetDateTime transactionDate;

	// % protected region % [Modify attribute annotation for Reference Number here] off begin
	@CsvBindByName(column = "REFERENCE_NUMBER", required = false)
	@Nullable
	@Column(name = "reference_number")
	@Schema(description = "The Reference Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Reference Number here] end
	private String referenceNumber;

	// % protected region % [Modify attribute annotation for Transaction Type here] off begin
	@CsvBindByName(column = "TRANSACTION_TYPE", required = false)
	@Nullable
	@Column(name = "transaction_type")
	@Schema(description = "The Transaction Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Type here] end
	private String transactionType;

	// % protected region % [Modify attribute annotation for Transaction Detail Type here] off begin
	@CsvBindByName(column = "TRANSACTION_DETAIL_TYPE", required = false)
	@Nullable
	@Column(name = "transaction_detail_type")
	@Schema(description = "The Transaction Detail Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Detail Type here] end
	private String transactionDetailType;

	// % protected region % [Modify attribute annotation for Account Number here] off begin
	@CsvBindByName(column = "ACCOUNT_NUMBER", required = false)
	@Nullable
	@Column(name = "account_number")
	@Schema(description = "The Account Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Account Number here] end
	private String accountNumber;

	// % protected region % [Modify attribute annotation for Debit here] off begin
	@CsvBindByName(column = "DEBIT", required = false)
	@Nullable
	@Column(name = "debit")
	@Schema(description = "The Debit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Debit here] end
	private Double debit;

	// % protected region % [Modify attribute annotation for Credit here] off begin
	@CsvBindByName(column = "CREDIT", required = false)
	@Nullable
	@Column(name = "credit")
	@Schema(description = "The Credit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Credit here] end
	private Double credit;

	// % protected region % [Modify attribute annotation for Posting Status here] off begin
	@CsvBindByName(column = "POSTING_STATUS", required = false)
	@Nullable
	@Column(name = "posting_status")
	@Schema(description = "The Posting Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Posting Status here] end
	private String postingStatus;

	// % protected region % [Modify attribute annotation for Posting Date Time here] off begin
	@CsvCustomBindByName(column = "POSTING_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "posting_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Posting Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Posting Date Time here] end
	private OffsetDateTime postingDateTime;

	// % protected region % [Modify attribute annotation for Supplier Number here] off begin
	@CsvBindByName(column = "SUPPLIER_NUMBER", required = false)
	@Nullable
	@Column(name = "supplier_number")
	@Schema(description = "The Supplier Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Supplier Number here] end
	private String supplierNumber;

	// % protected region % [Modify attribute annotation for Supplier Name here] off begin
	@CsvBindByName(column = "SUPPLIER_NAME", required = false)
	@Nullable
	@Column(name = "supplier_name")
	@Schema(description = "The Supplier Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Supplier Name here] end
	private String supplierName;

	// % protected region % [Modify attribute annotation for Customer Number here] off begin
	@CsvBindByName(column = "CUSTOMER_NUMBER", required = false)
	@Nullable
	@Column(name = "customer_number")
	@Schema(description = "The Customer Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Customer Number here] end
	private String customerNumber;

	// % protected region % [Modify attribute annotation for Customer Name here] off begin
	@CsvBindByName(column = "CUSTOMER_NAME", required = false)
	@Nullable
	@Column(name = "customer_name")
	@Schema(description = "The Customer Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Customer Name here] end
	private String customerName;

	// % protected region % [Modify attribute annotation for Revenue Center here] off begin
	@CsvBindByName(column = "REVENUE_CENTER", required = false)
	@Nullable
	@Column(name = "revenue_center")
	@Schema(description = "The Revenue Center of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Revenue Center here] end
	private String revenueCenter;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@CsvBindByName(column = "DESCRIPTION", required = false)
	@Nullable
	@Column(name = "description")
	@Schema(description = "The Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

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
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "JOURNAL_NUMBER,TRANSACTION_DATE,REFERENCE_NUMBER,TRANSACTION_TYPE,TRANSACTION_DETAIL_TYPE,ACCOUNT_NUMBER,DEBIT,CREDIT,POSTING_STATUS,POSTING_DATE_TIME,SUPPLIER_NUMBER,SUPPLIER_NAME,CUSTOMER_NUMBER,CUSTOMER_NAME,REVENUE_CENTER,DESCRIPTION,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object journal) {
		if (this == journal) {
			return true;
		}
		if (journal == null || this.getClass() != journal.getClass()) {
			return false;
		}
		if (!super.equals(journal)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		JournalEntity that = (JournalEntity) journal;
		return
			Objects.equals(this.journalNumber, that.journalNumber) &&
			Objects.equals(
			     this.transactionDate != null ? this.transactionDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.transactionDate != null ? that.transactionDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.referenceNumber, that.referenceNumber) &&
			Objects.equals(this.transactionType, that.transactionType) &&
			Objects.equals(this.transactionDetailType, that.transactionDetailType) &&
			Objects.equals(this.accountNumber, that.accountNumber) &&
			Objects.equals(this.debit, that.debit) &&
			Objects.equals(this.credit, that.credit) &&
			Objects.equals(this.postingStatus, that.postingStatus) &&
			Objects.equals(
			     this.postingDateTime != null ? this.postingDateTime.truncatedTo(ChronoUnit.DAYS) : null,
			     that.postingDateTime != null ? that.postingDateTime.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.supplierNumber, that.supplierNumber) &&
			Objects.equals(this.supplierName, that.supplierName) &&
			Objects.equals(this.customerNumber, that.customerNumber) &&
			Objects.equals(this.customerName, that.customerName) &&
			Objects.equals(this.revenueCenter, that.revenueCenter) &&
			Objects.equals(this.description, that.description);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
