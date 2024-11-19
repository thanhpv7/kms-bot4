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
import kmsweb.entities.InvoiceItemComponentEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class InvoiceItemComponentFactory implements FactoryBean<InvoiceItemComponentEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public InvoiceItemComponentEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public InvoiceItemComponentEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public InvoiceItemComponentEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for invoiceItemComponentWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemComponentWithNoRef before the main body here] end

		InvoiceItemComponentEntity newEntity = new InvoiceItemComponentEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Price here] off begin
		newEntity.setPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Price here] end
		// % protected region % [Add customisation for Medical Staff here] off begin
		String randomStringForMedicalStaff = mockNeat
				.strings()
				.get();
		newEntity.setMedicalStaff(randomStringForMedicalStaff);
		// % protected region % [Add customisation for Medical Staff here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for invoiceItemComponentWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemComponentWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyInvoice Item here] off begin
			var invoiceItemFactory = new InvoiceItemFactory();
			newEntity.setInvoiceItem(invoiceItemFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyInvoice Item here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPrice Component here] off begin
			var priceComponentFactory = new PriceComponentFactory();
			newEntity.setPriceComponent(priceComponentFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPrice Component here] end

		}

		// % protected region % [Apply any additional logic for invoiceItemComponent with ref here] off begin
		// % protected region % [Apply any additional logic for invoiceItemComponent with ref here] end

		return newEntity;
	}

	@Override
	public Class<InvoiceItemComponentEntity> getObjectType() {
		return InvoiceItemComponentEntity.class;
	}
}