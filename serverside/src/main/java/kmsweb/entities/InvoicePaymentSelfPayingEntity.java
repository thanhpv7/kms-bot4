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
import kmsweb.dtos.InvoicePaymentSelfPayingEntityDto;
import kmsweb.entities.listeners.InvoicePaymentSelfPayingEntityListener;
import kmsweb.serializers.InvoicePaymentSelfPayingSerializer;
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
@EntityListeners({InvoicePaymentSelfPayingEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = InvoicePaymentSelfPayingSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class InvoicePaymentSelfPayingEntity extends AbstractEntity {

	/**
	 * Takes a InvoicePaymentSelfPayingEntityDto and converts it into a InvoicePaymentSelfPayingEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param invoicePaymentSelfPayingEntityDto
	 */
	public InvoicePaymentSelfPayingEntity(InvoicePaymentSelfPayingEntityDto invoicePaymentSelfPayingEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (invoicePaymentSelfPayingEntityDto.getId() != null) {
			this.setId(invoicePaymentSelfPayingEntityDto.getId());
		}

		if (invoicePaymentSelfPayingEntityDto.getSponsorName() != null) {
			this.setSponsorName(invoicePaymentSelfPayingEntityDto.getSponsorName());
		}

		if (invoicePaymentSelfPayingEntityDto.getSponsorAddress() != null) {
			this.setSponsorAddress(invoicePaymentSelfPayingEntityDto.getSponsorAddress());
		}

		if (invoicePaymentSelfPayingEntityDto.getSponsorPhoneNo() != null) {
			this.setSponsorPhoneNo(invoicePaymentSelfPayingEntityDto.getSponsorPhoneNo());
		}

		if (invoicePaymentSelfPayingEntityDto.getSponsorship() != null) {
			this.setSponsorship(invoicePaymentSelfPayingEntityDto.getSponsorship());
		}

		if (invoicePaymentSelfPayingEntityDto.getInvoice() != null) {
			this.setInvoice(invoicePaymentSelfPayingEntityDto.getInvoice());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Sponsor Name here] off begin
	@CsvBindByName(column = "SPONSOR_NAME", required = false)
	@Nullable
	@Column(name = "sponsor_name")
	@Schema(description = "The Sponsor Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sponsor Name here] end
	private String sponsorName;

	// % protected region % [Modify attribute annotation for Sponsor Address here] off begin
	@CsvBindByName(column = "SPONSOR_ADDRESS", required = false)
	@Nullable
	@Column(name = "sponsor_address")
	@Schema(description = "The Sponsor Address of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sponsor Address here] end
	private String sponsorAddress;

	// % protected region % [Modify attribute annotation for Sponsor Phone No here] off begin
	@CsvBindByName(column = "SPONSOR_PHONE_NO", required = false)
	@Nullable
	@Column(name = "sponsor_phone_no")
	@Schema(description = "The Sponsor Phone No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sponsor Phone No here] end
	private String sponsorPhoneNo;

	// % protected region % [Modify attribute annotation for Sponsorship here] off begin
	@CsvBindByName(column = "SPONSORSHIP", required = false)
	@Nullable
	@Column(name = "sponsorship")
	@Schema(description = "The Sponsorship of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sponsorship here] end
	private String sponsorship;

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
			this.invoice.unsetInvoicePaymentSelfPaying(false);
		}

		this.invoice = entity;
		if (reverseAdd) {
			this.invoice.setInvoicePaymentSelfPaying(this, false);
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
			this.invoice.unsetInvoicePaymentSelfPaying();
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
		return "SPONSOR_NAME,SPONSOR_ADDRESS,SPONSOR_PHONE_NO,SPONSORSHIP,INVOICE_ID,ID";
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
	public boolean equals(Object invoicePaymentSelfPaying) {
		if (this == invoicePaymentSelfPaying) {
			return true;
		}
		if (invoicePaymentSelfPaying == null || this.getClass() != invoicePaymentSelfPaying.getClass()) {
			return false;
		}
		if (!super.equals(invoicePaymentSelfPaying)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		InvoicePaymentSelfPayingEntity that = (InvoicePaymentSelfPayingEntity) invoicePaymentSelfPaying;
		return
			Objects.equals(this.sponsorName, that.sponsorName) &&
			Objects.equals(this.sponsorAddress, that.sponsorAddress) &&
			Objects.equals(this.sponsorPhoneNo, that.sponsorPhoneNo) &&
			Objects.equals(this.sponsorship, that.sponsorship) &&
			Objects.equals(this.invoiceId, that.invoiceId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
