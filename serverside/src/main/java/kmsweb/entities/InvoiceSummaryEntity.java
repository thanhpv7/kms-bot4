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
import kmsweb.dtos.InvoiceSummaryEntityDto;
import kmsweb.entities.listeners.InvoiceSummaryEntityListener;
import kmsweb.serializers.InvoiceSummarySerializer;
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
@EntityListeners({InvoiceSummaryEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = InvoiceSummarySerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class InvoiceSummaryEntity extends AbstractEntity {

	/**
	 * Takes a InvoiceSummaryEntityDto and converts it into a InvoiceSummaryEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param invoiceSummaryEntityDto
	 */
	public InvoiceSummaryEntity(InvoiceSummaryEntityDto invoiceSummaryEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (invoiceSummaryEntityDto.getId() != null) {
			this.setId(invoiceSummaryEntityDto.getId());
		}

		if (invoiceSummaryEntityDto.getSubTotal() != null) {
			this.setSubTotal(invoiceSummaryEntityDto.getSubTotal());
		}

		if (invoiceSummaryEntityDto.getTaxOnOtherDiscount() != null) {
			this.setTaxOnOtherDiscount(invoiceSummaryEntityDto.getTaxOnOtherDiscount());
		}

		if (invoiceSummaryEntityDto.getOtherDiscount() != null) {
			this.setOtherDiscount(invoiceSummaryEntityDto.getOtherDiscount());
		}

		if (invoiceSummaryEntityDto.getTaxOnOtherFee() != null) {
			this.setTaxOnOtherFee(invoiceSummaryEntityDto.getTaxOnOtherFee());
		}

		if (invoiceSummaryEntityDto.getOtherFee() != null) {
			this.setOtherFee(invoiceSummaryEntityDto.getOtherFee());
		}

		if (invoiceSummaryEntityDto.getTax() != null) {
			this.setTax(invoiceSummaryEntityDto.getTax());
		}

		if (invoiceSummaryEntityDto.getTotalInvoice() != null) {
			this.setTotalInvoice(invoiceSummaryEntityDto.getTotalInvoice());
		}

		if (invoiceSummaryEntityDto.getAvailableDownPayment() != null) {
			this.setAvailableDownPayment(invoiceSummaryEntityDto.getAvailableDownPayment());
		}

		if (invoiceSummaryEntityDto.getTotalCoverage() != null) {
			this.setTotalCoverage(invoiceSummaryEntityDto.getTotalCoverage());
		}

		if (invoiceSummaryEntityDto.getOutstandingAmount() != null) {
			this.setOutstandingAmount(invoiceSummaryEntityDto.getOutstandingAmount());
		}

		if (invoiceSummaryEntityDto.getBpjsCoverage() != null) {
			this.setBpjsCoverage(invoiceSummaryEntityDto.getBpjsCoverage());
		}

		if (invoiceSummaryEntityDto.getInvoice() != null) {
			this.setInvoice(invoiceSummaryEntityDto.getInvoice());
		}

		if (invoiceSummaryEntityDto.getRetailPharmacyInvoice() != null) {
			this.setRetailPharmacyInvoice(invoiceSummaryEntityDto.getRetailPharmacyInvoice());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Sub Total here] off begin
	@CsvBindByName(column = "SUB_TOTAL", required = false)
	@Nullable
	@Column(name = "sub_total")
	@Schema(description = "The Sub Total of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sub Total here] end
	private Double subTotal;

	// % protected region % [Modify attribute annotation for Tax On Other Discount here] off begin
	@CsvBindByName(column = "TAX_ON_OTHER_DISCOUNT", required = false)
	@Nullable
	@Column(name = "tax_on_other_discount")
	@Schema(description = "The Tax On Other Discount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tax On Other Discount here] end
	private Boolean taxOnOtherDiscount = false ;

	// % protected region % [Modify attribute annotation for Other Discount here] off begin
	@CsvBindByName(column = "OTHER_DISCOUNT", required = false)
	@Nullable
	@Column(name = "other_discount")
	@Schema(description = "The Other Discount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Other Discount here] end
	private Double otherDiscount;

	// % protected region % [Modify attribute annotation for Tax On Other Fee here] off begin
	@CsvBindByName(column = "TAX_ON_OTHER_FEE", required = false)
	@Nullable
	@Column(name = "tax_on_other_fee")
	@Schema(description = "The Tax On Other Fee of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tax On Other Fee here] end
	private Boolean taxOnOtherFee = false ;

	// % protected region % [Modify attribute annotation for Other Fee here] off begin
	@CsvBindByName(column = "OTHER_FEE", required = false)
	@Nullable
	@Column(name = "other_fee")
	@Schema(description = "The Other Fee of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Other Fee here] end
	private Double otherFee;

	// % protected region % [Modify attribute annotation for Tax here] off begin
	@CsvBindByName(column = "TAX", required = false)
	@Nullable
	@Column(name = "tax")
	@Schema(description = "The Tax of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tax here] end
	private Double tax;

	// % protected region % [Modify attribute annotation for Total Invoice here] off begin
	@CsvBindByName(column = "TOTAL_INVOICE", required = false)
	@Nullable
	@Column(name = "total_invoice")
	@Schema(description = "The Total Invoice of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Invoice here] end
	private Double totalInvoice;

	// % protected region % [Modify attribute annotation for Available Down Payment here] off begin
	@CsvBindByName(column = "AVAILABLE_DOWN_PAYMENT", required = false)
	@Nullable
	@Column(name = "available_down_payment")
	@Schema(description = "The Available Down Payment of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Available Down Payment here] end
	private Double availableDownPayment;

	// % protected region % [Modify attribute annotation for Total Coverage here] off begin
	@CsvBindByName(column = "TOTAL_COVERAGE", required = false)
	@Nullable
	@Column(name = "total_coverage")
	@Schema(description = "The Total Coverage of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Coverage here] end
	private Double totalCoverage;

	// % protected region % [Modify attribute annotation for Outstanding Amount here] off begin
	@CsvBindByName(column = "OUTSTANDING_AMOUNT", required = false)
	@Nullable
	@Column(name = "outstanding_amount")
	@Schema(description = "The Outstanding Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Outstanding Amount here] end
	private Double outstandingAmount;

	// % protected region % [Modify attribute annotation for BPJS Coverage here] off begin
	@CsvBindByName(column = "BPJS_COVERAGE", required = false)
	@Nullable
	@Column(name = "bpjs_coverage")
	@Schema(description = "The BPJS Coverage of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BPJS Coverage here] end
	private Double bpjsCoverage;

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

	// % protected region % [Update the annotation for Invoice here] off begin
	@Schema(description = "The Invoice entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice here] end
	private InvoiceEntity invoice;

	// % protected region % [Update the annotation for invoiceId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for invoiceId here] end
	private UUID invoiceId;

	// % protected region % [Update the annotation for Retail Pharmacy Invoice here] off begin
	@Schema(description = "The Retail Pharmacy Invoice entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Retail Pharmacy Invoice here] end
	private RetailPharmacyInvoiceEntity retailPharmacyInvoice;

	// % protected region % [Update the annotation for retailPharmacyInvoiceId here] off begin
	@Transient
	@CsvCustomBindByName(column = "RETAIL_PHARMACY_INVOICE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for retailPharmacyInvoiceId here] end
	private UUID retailPharmacyInvoiceId;

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
	 * Similar to {@link this#setInvoice(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void setInvoice(InvoiceEntity entity) {
		setInvoice(entity, true);
	}

	/**
	 * Set or update the invoice in this entity with single InvoiceEntity.
	 *
	 * @param entity the given InvoiceEntity to be set or updated to invoice
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoice(InvoiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInvoice here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInvoice here] end

		if (sameAsFormer(this.invoice, entity)) {
			return;
		}

		if (this.invoice != null) {
			this.invoice.unsetInvoiceSummary(false);
		}

		this.invoice = entity;
		if (reverseAdd) {
			this.invoice.setInvoiceSummary(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInvoice incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInvoice incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetInvoice(boolean)} but default to true.
	 */
	public void unsetInvoice() {
		this.unsetInvoice(true);
	}

	/**
	 * Remove the InvoiceEntity of invoice from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInvoice(boolean reverse) {
		if (reverse && this.invoice != null) {
			this.invoice.unsetInvoiceSummary();
		}
		this.invoice = null;
	}
	/**
	 * Similar to {@link this#setRetailPharmacyInvoice(RetailPharmacyInvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity to be set to this entity
	 */
	public void setRetailPharmacyInvoice(RetailPharmacyInvoiceEntity entity) {
		setRetailPharmacyInvoice(entity, true);
	}

	/**
	 * Set or update the retailPharmacyInvoice in this entity with single RetailPharmacyInvoiceEntity.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity to be set or updated to retailPharmacyInvoice
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRetailPharmacyInvoice(RetailPharmacyInvoiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRetailPharmacyInvoice here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRetailPharmacyInvoice here] end

		if (sameAsFormer(this.retailPharmacyInvoice, entity)) {
			return;
		}

		if (this.retailPharmacyInvoice != null) {
			this.retailPharmacyInvoice.unsetInvoiceSummary(false);
		}

		this.retailPharmacyInvoice = entity;
		if (reverseAdd) {
			this.retailPharmacyInvoice.setInvoiceSummary(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRetailPharmacyInvoice incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRetailPharmacyInvoice incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetRetailPharmacyInvoice(boolean)} but default to true.
	 */
	public void unsetRetailPharmacyInvoice() {
		this.unsetRetailPharmacyInvoice(true);
	}

	/**
	 * Remove the RetailPharmacyInvoiceEntity of retailPharmacyInvoice from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRetailPharmacyInvoice(boolean reverse) {
		if (reverse && this.retailPharmacyInvoice != null) {
			this.retailPharmacyInvoice.unsetInvoiceSummary();
		}
		this.retailPharmacyInvoice = null;
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
		return "SUB_TOTAL,TAX_ON_OTHER_DISCOUNT,OTHER_DISCOUNT,TAX_ON_OTHER_FEE,OTHER_FEE,TAX,TOTAL_INVOICE,AVAILABLE_DOWN_PAYMENT,TOTAL_COVERAGE,OUTSTANDING_AMOUNT,BPJS_COVERAGE,INVOICE_ID,RETAIL_PHARMACY_INVOICE_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<InvoiceEntity> invoiceRelation = Optional.ofNullable(this.invoice);
		invoiceRelation.ifPresent(entity -> this.invoiceId = entity.getId());

		Optional<RetailPharmacyInvoiceEntity> retailPharmacyInvoiceRelation = Optional.ofNullable(this.retailPharmacyInvoice);
		retailPharmacyInvoiceRelation.ifPresent(entity -> this.retailPharmacyInvoiceId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object invoiceSummary) {
		if (this == invoiceSummary) {
			return true;
		}
		if (invoiceSummary == null || this.getClass() != invoiceSummary.getClass()) {
			return false;
		}
		if (!super.equals(invoiceSummary)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		InvoiceSummaryEntity that = (InvoiceSummaryEntity) invoiceSummary;
		return
			Objects.equals(this.subTotal, that.subTotal) &&
			Objects.equals(this.taxOnOtherDiscount, that.taxOnOtherDiscount) &&
			Objects.equals(this.otherDiscount, that.otherDiscount) &&
			Objects.equals(this.taxOnOtherFee, that.taxOnOtherFee) &&
			Objects.equals(this.otherFee, that.otherFee) &&
			Objects.equals(this.tax, that.tax) &&
			Objects.equals(this.totalInvoice, that.totalInvoice) &&
			Objects.equals(this.availableDownPayment, that.availableDownPayment) &&
			Objects.equals(this.totalCoverage, that.totalCoverage) &&
			Objects.equals(this.outstandingAmount, that.outstandingAmount) &&
			Objects.equals(this.bpjsCoverage, that.bpjsCoverage) &&
			Objects.equals(this.invoiceId, that.invoiceId) &&
			Objects.equals(this.retailPharmacyInvoiceId, that.retailPharmacyInvoiceId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
