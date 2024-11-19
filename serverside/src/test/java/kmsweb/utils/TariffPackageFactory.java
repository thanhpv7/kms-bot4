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
import kmsweb.entities.TariffPackageEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class TariffPackageFactory implements FactoryBean<TariffPackageEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public TariffPackageEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public TariffPackageEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public TariffPackageEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for tariffPackageWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageWithNoRef before the main body here] end

		TariffPackageEntity newEntity = new TariffPackageEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Tariff Package Code here] off begin
		String randomStringForTariffPackageCode = mockNeat
				.strings()
				.get();
		newEntity.setTariffPackageCode(randomStringForTariffPackageCode);
		// % protected region % [Add customisation for Tariff Package Code here] end
		// % protected region % [Add customisation for Tariff Package Name here] off begin
		String randomStringForTariffPackageName = mockNeat
				.strings()
				.get();
		newEntity.setTariffPackageName(randomStringForTariffPackageName);
		// % protected region % [Add customisation for Tariff Package Name here] end
		// % protected region % [Add customisation for Tariff Package Classification here] off begin
		String randomStringForTariffPackageClassification = mockNeat
				.strings()
				.get();
		newEntity.setTariffPackageClassification(randomStringForTariffPackageClassification);
		// % protected region % [Add customisation for Tariff Package Classification here] end
		// % protected region % [Add customisation for COA Sell here] off begin
		String randomStringForCoaSell = mockNeat
				.strings()
				.get();
		newEntity.setCoaSell(randomStringForCoaSell);
		// % protected region % [Add customisation for COA Sell here] end
		// % protected region % [Add customisation for Tariff Package Description here] off begin
		String randomStringForTariffPackageDescription = mockNeat
				.strings()
				.get();
		newEntity.setTariffPackageDescription(randomStringForTariffPackageDescription);
		// % protected region % [Add customisation for Tariff Package Description here] end
		// % protected region % [Add customisation for Apply To All Services here] off begin
		newEntity.setApplyToAllServices(mockNeat.bools().get());
		// % protected region % [Add customisation for Apply To All Services here] end

		// % protected region % [Apply any additional logic for tariffPackageWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusion for outgoingOneToMany Service Item Assignments here] off begin
			// Outgoing one to many reference
			var serviceItemAssignmentsFactory = new ServiceItemAssignmentFactory();
			newEntity.setServiceItemAssignments(Collections.singletonList(serviceItemAssignmentsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Service Item Assignments here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Tariff Package Items here] off begin
			// Outgoing one to many reference
			var tariffPackageItemsFactory = new TariffPackageItemFactory();
			newEntity.setTariffPackageItems(Collections.singletonList(tariffPackageItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Tariff Package Items here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Tariff Package Service Assignments here] off begin
			// Outgoing one to many reference
			var tariffPackageServiceAssignmentsFactory = new TariffPackageServiceAssignmentFactory();
			newEntity.setTariffPackageServiceAssignments(Collections.singletonList(tariffPackageServiceAssignmentsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Tariff Package Service Assignments here] end

		}

		// % protected region % [Apply any additional logic for tariffPackage with ref here] off begin
		// % protected region % [Apply any additional logic for tariffPackage with ref here] end

		return newEntity;
	}

	@Override
	public Class<TariffPackageEntity> getObjectType() {
		return TariffPackageEntity.class;
	}
}