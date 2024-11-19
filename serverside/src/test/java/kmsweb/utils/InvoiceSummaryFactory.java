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
import kmsweb.entities.InvoiceSummaryEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class InvoiceSummaryFactory implements FactoryBean<InvoiceSummaryEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public InvoiceSummaryEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public InvoiceSummaryEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public InvoiceSummaryEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for invoiceSummaryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceSummaryWithNoRef before the main body here] end

		InvoiceSummaryEntity newEntity = new InvoiceSummaryEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Sub Total here] off begin
		newEntity.setSubTotal(mockNeat.doubles().get());
		// % protected region % [Add customisation for Sub Total here] end
		// % protected region % [Add customisation for Tax On Other Discount here] off begin
		newEntity.setTaxOnOtherDiscount(mockNeat.bools().get());
		// % protected region % [Add customisation for Tax On Other Discount here] end
		// % protected region % [Add customisation for Other Discount here] off begin
		newEntity.setOtherDiscount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Other Discount here] end
		// % protected region % [Add customisation for Tax On Other Fee here] off begin
		newEntity.setTaxOnOtherFee(mockNeat.bools().get());
		// % protected region % [Add customisation for Tax On Other Fee here] end
		// % protected region % [Add customisation for Other Fee here] off begin
		newEntity.setOtherFee(mockNeat.doubles().get());
		// % protected region % [Add customisation for Other Fee here] end
		// % protected region % [Add customisation for Tax here] off begin
		newEntity.setTax(mockNeat.doubles().get());
		// % protected region % [Add customisation for Tax here] end
		// % protected region % [Add customisation for Total Invoice here] off begin
		newEntity.setTotalInvoice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Invoice here] end
		// % protected region % [Add customisation for Available Down Payment here] off begin
		newEntity.setAvailableDownPayment(mockNeat.doubles().get());
		// % protected region % [Add customisation for Available Down Payment here] end
		// % protected region % [Add customisation for Total Coverage here] off begin
		newEntity.setTotalCoverage(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Coverage here] end
		// % protected region % [Add customisation for Outstanding Amount here] off begin
		newEntity.setOutstandingAmount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Outstanding Amount here] end
		// % protected region % [Add customisation for BPJS Coverage here] off begin
		newEntity.setBpjsCoverage(mockNeat.doubles().get());
		// % protected region % [Add customisation for BPJS Coverage here] end

		// % protected region % [Apply any additional logic for invoiceSummaryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceSummaryWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Invoice here] off begin
			// Incoming One to One reference
			var invoiceFactory = new InvoiceFactory();
			newEntity.setInvoice(invoiceFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Invoice here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne Retail Pharmacy Invoice here] off begin
			// Incoming One to One reference
			var retailPharmacyInvoiceFactory = new RetailPharmacyInvoiceFactory();
			newEntity.setRetailPharmacyInvoice(retailPharmacyInvoiceFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Retail Pharmacy Invoice here] end
		}

		// % protected region % [Apply any additional logic for invoiceSummary with ref here] off begin
		// % protected region % [Apply any additional logic for invoiceSummary with ref here] end

		return newEntity;
	}

	@Override
	public Class<InvoiceSummaryEntity> getObjectType() {
		return InvoiceSummaryEntity.class;
	}
}