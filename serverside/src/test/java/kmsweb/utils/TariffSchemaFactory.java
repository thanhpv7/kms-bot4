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
import kmsweb.entities.TariffSchemaEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class TariffSchemaFactory implements FactoryBean<TariffSchemaEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public TariffSchemaEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public TariffSchemaEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public TariffSchemaEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for tariffSchemaWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffSchemaWithNoRef before the main body here] end

		TariffSchemaEntity newEntity = new TariffSchemaEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Schema Code here] off begin
		String randomStringForSchemaCode = mockNeat
				.strings()
				.get();
		newEntity.setSchemaCode(randomStringForSchemaCode);
		// % protected region % [Add customisation for Schema Code here] end
		// % protected region % [Add customisation for Scheme Name here] off begin
		String randomStringForSchemeName = mockNeat
				.strings()
				.get();
		newEntity.setSchemeName(randomStringForSchemeName);
		// % protected region % [Add customisation for Scheme Name here] end
		// % protected region % [Add customisation for Start Date here] off begin
		newEntity.setStartDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date here] end
		// % protected region % [Add customisation for End Date here] off begin
		newEntity.setEndDate(OffsetDateTime.now());
		// % protected region % [Add customisation for End Date here] end

		// % protected region % [Apply any additional logic for tariffSchemaWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffSchemaWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusion for outgoingOneToMany Base Scheme here] off begin
			// Outgoing one to many reference
			var baseSchemeFactory = new TariffFormulaFactory();
			newEntity.setBaseScheme(Collections.singletonList(baseSchemeFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Base Scheme here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Items here] off begin
			// Outgoing one to many reference
			var invoiceItemsFactory = new InvoiceItemFactory();
			newEntity.setInvoiceItems(Collections.singletonList(invoiceItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Items here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoices here] off begin
			// Outgoing one to many reference
			var invoicesFactory = new InvoiceFactory();
			newEntity.setInvoices(Collections.singletonList(invoicesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoices here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Tariff Definitions here] off begin
			// Outgoing one to many reference
			var tariffDefinitionsFactory = new TariffDefinitionFactory();
			newEntity.setTariffDefinitions(Collections.singletonList(tariffDefinitionsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Tariff Definitions here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Tariff Scheme here] off begin
			// Outgoing one to many reference
			var tariffSchemeFactory = new TariffFormulaFactory();
			newEntity.setTariffScheme(Collections.singletonList(tariffSchemeFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Tariff Scheme here] end

		}

		// % protected region % [Apply any additional logic for tariffSchema with ref here] off begin
		// % protected region % [Apply any additional logic for tariffSchema with ref here] end

		return newEntity;
	}

	@Override
	public Class<TariffSchemaEntity> getObjectType() {
		return TariffSchemaEntity.class;
	}
}