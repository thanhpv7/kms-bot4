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
import kmsweb.entities.PriceComponentEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PriceComponentFactory implements FactoryBean<PriceComponentEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PriceComponentEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PriceComponentEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PriceComponentEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for priceComponentWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for priceComponentWithNoRef before the main body here] end

		PriceComponentEntity newEntity = new PriceComponentEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Component Code here] off begin
		String randomStringForComponentCode = mockNeat
				.strings()
				.get();
		newEntity.setComponentCode(randomStringForComponentCode);
		// % protected region % [Add customisation for Component Code here] end
		// % protected region % [Add customisation for Component Name here] off begin
		String randomStringForComponentName = mockNeat
				.strings()
				.get();
		newEntity.setComponentName(randomStringForComponentName);
		// % protected region % [Add customisation for Component Name here] end
		// % protected region % [Add customisation for COA COGS here] off begin
		String randomStringForCoaCOGS = mockNeat
				.strings()
				.get();
		newEntity.setCoaCOGS(randomStringForCoaCOGS);
		// % protected region % [Add customisation for COA COGS here] end
		// % protected region % [Add customisation for COA Sell here] off begin
		String randomStringForCoaSell = mockNeat
				.strings()
				.get();
		newEntity.setCoaSell(randomStringForCoaSell);
		// % protected region % [Add customisation for COA Sell here] end
		// % protected region % [Add customisation for COA Inventory here] off begin
		String randomStringForCoaInventory = mockNeat
				.strings()
				.get();
		newEntity.setCoaInventory(randomStringForCoaInventory);
		// % protected region % [Add customisation for COA Inventory here] end

		// % protected region % [Apply any additional logic for priceComponentWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for priceComponentWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Item Components here] off begin
			// Outgoing one to many reference
			var invoiceItemComponentsFactory = new InvoiceItemComponentFactory();
			newEntity.setInvoiceItemComponents(Collections.singletonList(invoiceItemComponentsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Item Components here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Fee Item Components here] off begin
			// Outgoing one to many reference
			var medicalFeeItemComponentsFactory = new MedicalFeeItemComponentFactory();
			newEntity.setMedicalFeeItemComponents(Collections.singletonList(medicalFeeItemComponentsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Fee Item Components here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Tariff Definition Other Components here] off begin
			// Outgoing one to many reference
			var tariffDefinitionOtherComponentsFactory = new TariffDefinitionOtherComponentFactory();
			newEntity.setTariffDefinitionOtherComponents(Collections.singletonList(tariffDefinitionOtherComponentsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Tariff Definition Other Components here] end

		}

		// % protected region % [Apply any additional logic for priceComponent with ref here] off begin
		// % protected region % [Apply any additional logic for priceComponent with ref here] end

		return newEntity;
	}

	@Override
	public Class<PriceComponentEntity> getObjectType() {
		return PriceComponentEntity.class;
	}
}