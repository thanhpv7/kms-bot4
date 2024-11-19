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
import kmsweb.entities.TariffPackageItemEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class TariffPackageItemFactory implements FactoryBean<TariffPackageItemEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public TariffPackageItemEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public TariffPackageItemEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public TariffPackageItemEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for tariffPackageItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageItemWithNoRef before the main body here] end

		TariffPackageItemEntity newEntity = new TariffPackageItemEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Tariff Type here] off begin
		newEntity.setTariffType(TariffTypeEnum.ROOM);
		// % protected region % [Add customisation for Tariff Type here] end
		// % protected region % [Add customisation for Tariff  Code here] off begin
		String randomStringForTariffCode = mockNeat
				.strings()
				.get();
		newEntity.setTariffCode(randomStringForTariffCode);
		// % protected region % [Add customisation for Tariff  Code here] end
		// % protected region % [Add customisation for Tariff  Name here] off begin
		String randomStringForTariffName = mockNeat
				.strings()
				.get();
		newEntity.setTariffName(randomStringForTariffName);
		// % protected region % [Add customisation for Tariff  Name here] end
		// % protected region % [Add customisation for Quantity here] off begin
		newEntity.setQuantity(mockNeat.doubles().get());
		// % protected region % [Add customisation for Quantity here] end
		// % protected region % [Add customisation for Unit here] off begin
		String randomStringForUnit = mockNeat
				.strings()
				.get();
		newEntity.setUnit(randomStringForUnit);
		// % protected region % [Add customisation for Unit here] end
		// % protected region % [Add customisation for Modifiable here] off begin
		newEntity.setModifiable(mockNeat.bools().get());
		// % protected region % [Add customisation for Modifiable here] end

		// % protected region % [Apply any additional logic for tariffPackageItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageItemWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyTariff Package here] off begin
			var tariffPackageFactory = new TariffPackageFactory();
			newEntity.setTariffPackage(tariffPackageFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyTariff Package here] end

		}

		// % protected region % [Apply any additional logic for tariffPackageItem with ref here] off begin
		// % protected region % [Apply any additional logic for tariffPackageItem with ref here] end

		return newEntity;
	}

	@Override
	public Class<TariffPackageItemEntity> getObjectType() {
		return TariffPackageItemEntity.class;
	}
}