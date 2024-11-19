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
import kmsweb.entities.MedicationItemEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class MedicationItemFactory implements FactoryBean<MedicationItemEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public MedicationItemEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public MedicationItemEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public MedicationItemEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for medicationItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationItemWithNoRef before the main body here] end

		MedicationItemEntity newEntity = new MedicationItemEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Requested Qty here] off begin
		newEntity.setRequestedQty(mockNeat.doubles().get());
		// % protected region % [Add customisation for Requested Qty here] end
		// % protected region % [Add customisation for Outstanding Qty here] off begin
		newEntity.setOutstandingQty(mockNeat.doubles().get());
		// % protected region % [Add customisation for Outstanding Qty here] end
		// % protected region % [Add customisation for Returned Qty here] off begin
		newEntity.setReturnedQty(mockNeat.doubles().get());
		// % protected region % [Add customisation for Returned Qty here] end
		// % protected region % [Add customisation for Issued Qty here] off begin
		newEntity.setIssuedQty(mockNeat.doubles().get());
		// % protected region % [Add customisation for Issued Qty here] end
		// % protected region % [Add customisation for Administered Qty here] off begin
		newEntity.setAdministeredQty(mockNeat.doubles().get());
		// % protected region % [Add customisation for Administered Qty here] end
		// % protected region % [Add customisation for Taken Home Qty here] off begin
		newEntity.setTakenHomeQty(mockNeat.doubles().get());
		// % protected region % [Add customisation for Taken Home Qty here] end
		// % protected region % [Add customisation for Dosage Frequency here] off begin
		newEntity.setDosageFrequency(mockNeat.doubles().get());
		// % protected region % [Add customisation for Dosage Frequency here] end
		// % protected region % [Add customisation for Dosage Qty here] off begin
		newEntity.setDosageQty(mockNeat.doubles().get());
		// % protected region % [Add customisation for Dosage Qty here] end
		// % protected region % [Add customisation for Dose here] off begin
		newEntity.setDose(mockNeat.doubles().get());
		// % protected region % [Add customisation for Dose here] end
		// % protected region % [Add customisation for Frequency here] off begin
		String randomStringForFrequency = mockNeat
				.strings()
				.get();
		newEntity.setFrequency(randomStringForFrequency);
		// % protected region % [Add customisation for Frequency here] end
		// % protected region % [Add customisation for Consumption Method here] off begin
		String randomStringForConsumptionMethod = mockNeat
				.strings()
				.get();
		newEntity.setConsumptionMethod(randomStringForConsumptionMethod);
		// % protected region % [Add customisation for Consumption Method here] end
		// % protected region % [Add customisation for Instruction here] off begin
		String randomStringForInstruction = mockNeat
				.strings()
				.get();
		newEntity.setInstruction(randomStringForInstruction);
		// % protected region % [Add customisation for Instruction here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Unit Price here] off begin
		newEntity.setUnitPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Unit Price here] end
		// % protected region % [Add customisation for Total Price here] off begin
		newEntity.setTotalPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Price here] end
		// % protected region % [Add customisation for Is dtd here] off begin
		newEntity.setIsDtd(mockNeat.bools().get());
		// % protected region % [Add customisation for Is dtd here] end
		// % protected region % [Add customisation for Total Issued Quantity here] off begin
		newEntity.setTotalIssuedQuantity(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Issued Quantity here] end
		// % protected region % [Add customisation for Total Administered Quantity here] off begin
		newEntity.setTotalAdministeredQuantity(mockNeat.ints().get());
		// % protected region % [Add customisation for Total Administered Quantity here] end
		// % protected region % [Add customisation for Total Taken Home Quantity here] off begin
		newEntity.setTotalTakenHomeQuantity(mockNeat.ints().get());
		// % protected region % [Add customisation for Total Taken Home Quantity here] end
		// % protected region % [Add customisation for Total Returned Quantity here] off begin
		newEntity.setTotalReturnedQuantity(mockNeat.ints().get());
		// % protected region % [Add customisation for Total Returned Quantity here] end
		// % protected region % [Add customisation for External Medication Name here] off begin
		String randomStringForExternalMedicationName = mockNeat
				.strings()
				.get();
		newEntity.setExternalMedicationName(randomStringForExternalMedicationName);
		// % protected region % [Add customisation for External Medication Name here] end
		// % protected region % [Add customisation for Approval Status here] off begin
		String randomStringForApprovalStatus = mockNeat
				.strings()
				.get();
		newEntity.setApprovalStatus(randomStringForApprovalStatus);
		// % protected region % [Add customisation for Approval Status here] end
		// % protected region % [Add customisation for Inventory Rounding Value here] off begin
		newEntity.setInventoryRoundingValue(mockNeat.doubles().get());
		// % protected region % [Add customisation for Inventory Rounding Value here] end
		// % protected region % [Add customisation for DTD Quantity here] off begin
		newEntity.setDtdQuantity(mockNeat.doubles().get());
		// % protected region % [Add customisation for DTD Quantity here] end

		// % protected region % [Apply any additional logic for medicationItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationItemWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyMedication Compound here] off begin
			var medicationCompoundFactory = new MedicationCompoundFactory();
			newEntity.setMedicationCompound(medicationCompoundFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyMedication Compound here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyMedication Header here] off begin
			var medicationHeaderFactory = new MedicationHeaderFactory();
			newEntity.setMedicationHeader(medicationHeaderFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyMedication Header here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] off begin
			var stockCatalogueFactory = new StockCatalogueFactory();
			newEntity.setStockCatalogue(stockCatalogueFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyUnit Of Measurement here] off begin
			var unitOfMeasurementFactory = new UnitOfMeasurementFactory();
			newEntity.setUnitOfMeasurement(unitOfMeasurementFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyUnit Of Measurement here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medication Administered Hisotries here] off begin
			// Outgoing one to many reference
			var medicationAdministeredHisotriesFactory = new MedicationAdministeredHistoryFactory();
			newEntity.setMedicationAdministeredHisotries(Collections.singletonList(medicationAdministeredHisotriesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medication Administered Hisotries here] end

		}

		// % protected region % [Apply any additional logic for medicationItem with ref here] off begin
		// % protected region % [Apply any additional logic for medicationItem with ref here] end

		return newEntity;
	}

	@Override
	public Class<MedicationItemEntity> getObjectType() {
		return MedicationItemEntity.class;
	}
}