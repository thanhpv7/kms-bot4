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
import kmsweb.dtos.InvoicePaymentOtherEntityDto;
import kmsweb.entities.listeners.InvoicePaymentOtherEntityListener;
import kmsweb.serializers.InvoicePaymentOtherSerializer;
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
@EntityListeners({InvoicePaymentOtherEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = InvoicePaymentOtherSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class InvoicePaymentOtherEntity extends AbstractEntity {

	/**
	 * Takes a InvoicePaymentOtherEntityDto and converts it into a InvoicePaymentOtherEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param invoicePaymentOtherEntityDto
	 */
	public InvoicePaymentOtherEntity(InvoicePaymentOtherEntityDto invoicePaymentOtherEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (invoicePaymentOtherEntityDto.getId() != null) {
			this.setId(invoicePaymentOtherEntityDto.getId());
		}

		if (invoicePaymentOtherEntityDto.getNotes() != null) {
			this.setNotes(invoicePaymentOtherEntityDto.getNotes());
		}

		if (invoicePaymentOtherEntityDto.getTaxAmount() != null) {
			this.setTaxAmount(invoicePaymentOtherEntityDto.getTaxAmount());
		}

		if (invoicePaymentOtherEntityDto.getInvoice() != null) {
			this.setInvoice(invoicePaymentOtherEntityDto.getInvoice());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Tax Amount here] off begin
	@CsvBindByName(column = "TAX_AMOUNT", required = false)
	@Nullable
	@Column(name = "tax_amount")
	@Schema(description = "The Tax Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tax Amount here] end
	private Double taxAmount;

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
			this.invoice.unsetInvoicePaymentOther(false);
		}

		this.invoice = entity;
		if (reverseAdd) {
			this.invoice.setInvoicePaymentOther(this, false);
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
			this.invoice.unsetInvoicePaymentOther();
		}
		this.invoice = null;
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
		return "NOTES,TAX_AMOUNT,INVOICE_ID,ID";
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

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object invoicePaymentOther) {
		if (this == invoicePaymentOther) {
			return true;
		}
		if (invoicePaymentOther == null || this.getClass() != invoicePaymentOther.getClass()) {
			return false;
		}
		if (!super.equals(invoicePaymentOther)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		InvoicePaymentOtherEntity that = (InvoicePaymentOtherEntity) invoicePaymentOther;
		return
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.taxAmount, that.taxAmount) &&
			Objects.equals(this.invoiceId, that.invoiceId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
