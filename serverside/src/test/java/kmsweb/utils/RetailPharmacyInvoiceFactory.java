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

package kmsweb.utils;

import org.springframework.beans.factory.FactoryBean;
import kmsweb.entities.RetailPharmacyInvoiceEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class RetailPharmacyInvoiceFactory implements FactoryBean<RetailPharmacyInvoiceEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public RetailPharmacyInvoiceEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public RetailPharmacyInvoiceEntity getObjectWithReferences(boolean includeIds) throws Exception {
		return getObject(true, includeIds);
	}

	/**
	 * Create an example instance of the entity.
	 *
	 * @param includeReferences Populate at least a single instance of each reference as a materialised object.
	 * 	We don't set the ids fields as there is no guarantee that these values exist at this stage.
	 * @param includeId Should IDs be set for the base object and the references
	 * @return A sample object
	 * @throws Exception
	 */
	public RetailPharmacyInvoiceEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for retailPharmacyInvoiceWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyInvoiceWithNoRef before the main body here] end

		RetailPharmacyInvoiceEntity newEntity = new RetailPharmacyInvoiceEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Invoice Number here] off begin
		String randomStringForInvoiceNumber = mockNeat
				.strings()
				.get();
		newEntity.setInvoiceNumber(randomStringForInvoiceNumber);
		// % protected region % [Add customisation for Invoice Number here] end
		// % protected region % [Add customisation for Revision Number here] off begin
		newEntity.setRevisionNumber(mockNeat.ints().get());
		// % protected region % [Add customisation for Revision Number here] end
		// % protected region % [Add customisation for Invoice Status here] off begin
		String randomStringForInvoiceStatus = mockNeat
				.strings()
				.get();
		newEntity.setInvoiceStatus(randomStringForInvoiceStatus);
		// % protected region % [Add customisation for Invoice Status here] end
		// % protected region % [Add customisation for Invoice Date here] off begin
		newEntity.setInvoiceDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Invoice Date here] end
		// % protected region % [Add customisation for Cancel Date here] off begin
		newEntity.setCancelDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Cancel Date here] end
		// % protected region % [Add customisation for Billing Location here] off begin
		String randomStringForBillingLocation = mockNeat
				.strings()
				.get();
		newEntity.setBillingLocation(randomStringForBillingLocation);
		// % protected region % [Add customisation for Billing Location here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Patient Payment Type here] off begin
		String randomStringForPatientPaymentType = mockNeat
				.strings()
				.get();
		newEntity.setPatientPaymentType(randomStringForPatientPaymentType);
		// % protected region % [Add customisation for Patient Payment Type here] end
		// % protected region % [Add customisation for Verification Date here] off begin
		newEntity.setVerificationDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Verification Date here] end
		// % protected region % [Add customisation for Display Doctor on Print here] off begin
		newEntity.setDisplayDoctorOnPrint(mockNeat.bools().get());
		// % protected region % [Add customisation for Display Doctor on Print here] end
		// % protected region % [Add customisation for Claim No here] off begin
		String randomStringForClaimNo = mockNeat
				.strings()
				.get();
		newEntity.setClaimNo(randomStringForClaimNo);
		// % protected region % [Add customisation for Claim No here] end
		// % protected region % [Add customisation for Payment Status here] off begin
		String randomStringForPaymentStatus = mockNeat
				.strings()
				.get();
		newEntity.setPaymentStatus(randomStringForPaymentStatus);
		// % protected region % [Add customisation for Payment Status here] end
		// % protected region % [Add customisation for Invoice Amount here] off begin
		newEntity.setInvoiceAmount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Invoice Amount here] end
		// % protected region % [Add customisation for Outstanding Amount here] off begin
		newEntity.setOutstandingAmount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Outstanding Amount here] end
		// % protected region % [Add customisation for Customer Name here] off begin
		String randomStringForCustomerName = mockNeat
				.strings()
				.get();
		newEntity.setCustomerName(randomStringForCustomerName);
		// % protected region % [Add customisation for Customer Name here] end

		// % protected region % [Apply any additional logic for retailPharmacyInvoiceWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyInvoiceWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for outgoingOneToOne Invoice Summary] off begin
			// Outgoing one to one reference
			var invoiceSummaryFactory = new InvoiceSummaryFactory();
			newEntity.setInvoiceSummary(invoiceSummaryFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Invoice Summary] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyRetail Pharmacy here] off begin
			var retailPharmacyFactory = new RetailPharmacyFactory();
			newEntity.setRetailPharmacy(retailPharmacyFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyRetail Pharmacy here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Cash Receipts here] off begin
			// Outgoing one to many reference
			var cashReceiptsFactory = new CashReceiptFactory();
			newEntity.setCashReceipts(Collections.singletonList(cashReceiptsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Cash Receipts here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Items here] off begin
			// Outgoing one to many reference
			var invoiceItemsFactory = new InvoiceItemFactory();
			newEntity.setInvoiceItems(Collections.singletonList(invoiceItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Items here] end

		}

		// % protected region % [Apply any additional logic for retailPharmacyInvoice with ref here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyInvoice with ref here] end

		return newEntity;
	}

	@Override
	public Class<RetailPharmacyInvoiceEntity> getObjectType() {
		return RetailPharmacyInvoiceEntity.class;
	}
}