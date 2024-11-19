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
import kmsweb.entities.UnitOfMeasurementEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class UnitOfMeasurementFactory implements FactoryBean<UnitOfMeasurementEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public UnitOfMeasurementEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public UnitOfMeasurementEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public UnitOfMeasurementEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for unitOfMeasurementWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for unitOfMeasurementWithNoRef before the main body here] end

		UnitOfMeasurementEntity newEntity = new UnitOfMeasurementEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Unit Name here] off begin
		String randomStringForUnitName = mockNeat
				.strings()
				.get();
		newEntity.setUnitName(randomStringForUnitName);
		// % protected region % [Add customisation for Unit Name here] end
		// % protected region % [Add customisation for Symbol here] off begin
		String randomStringForSymbol = mockNeat
				.strings()
				.get();
		newEntity.setSymbol(randomStringForSymbol);
		// % protected region % [Add customisation for Symbol here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringForDescription = mockNeat
				.strings()
				.get();
		newEntity.setDescription(randomStringForDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Unit Category here] off begin
		String randomStringForUnitCategory = mockNeat
				.strings()
				.get();
		newEntity.setUnitCategory(randomStringForUnitCategory);
		// % protected region % [Add customisation for Unit Category here] end
		// % protected region % [Add customisation for Consumption Unit here] off begin
		newEntity.setConsumptionUnit(mockNeat.bools().get());
		// % protected region % [Add customisation for Consumption Unit here] end

		// % protected region % [Apply any additional logic for unitOfMeasurementWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for unitOfMeasurementWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Catalogue UOM here] off begin
			// Incoming One to One reference
			var catalogueUOMFactory = new CatalogueUOMFactory();
			newEntity.setCatalogueUOM(catalogueUOMFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Catalogue UOM here] end
			// % protected region % [Override the reference inclusion for outgoingOneToMany Compound Prescription Details here] off begin
			// Outgoing one to many reference
			var compoundPrescriptionDetailsFactory = new CompoundPrescriptionDetailFactory();
			newEntity.setCompoundPrescriptionDetails(Collections.singletonList(compoundPrescriptionDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Compound Prescription Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Compound Prescription Items here] off begin
			// Outgoing one to many reference
			var compoundPrescriptionItemsFactory = new CompoundPrescriptionItemFactory();
			newEntity.setCompoundPrescriptionItems(Collections.singletonList(compoundPrescriptionItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Compound Prescription Items here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Compounds Unit here] off begin
			// Outgoing one to many reference
			var compoundsUnitFactory = new PrescriptionCompoundFactory();
			newEntity.setCompoundsUnit(Collections.singletonList(compoundsUnitFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Compounds Unit here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medication Compounds here] off begin
			// Outgoing one to many reference
			var medicationCompoundsFactory = new MedicationCompoundFactory();
			newEntity.setMedicationCompounds(Collections.singletonList(medicationCompoundsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medication Compounds here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medication Items here] off begin
			// Outgoing one to many reference
			var medicationItemsFactory = new MedicationItemFactory();
			newEntity.setMedicationItems(Collections.singletonList(medicationItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medication Items here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Prescription Items here] off begin
			// Outgoing one to many reference
			var prescriptionItemsFactory = new PrescriptionItemFactory();
			newEntity.setPrescriptionItems(Collections.singletonList(prescriptionItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Prescription Items here] end

		}

		// % protected region % [Apply any additional logic for unitOfMeasurement with ref here] off begin
		// % protected region % [Apply any additional logic for unitOfMeasurement with ref here] end

		return newEntity;
	}

	@Override
	public Class<UnitOfMeasurementEntity> getObjectType() {
		return UnitOfMeasurementEntity.class;
	}
}