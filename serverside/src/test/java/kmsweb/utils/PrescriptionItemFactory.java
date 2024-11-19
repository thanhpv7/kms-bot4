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
import kmsweb.entities.PrescriptionItemEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PrescriptionItemFactory implements FactoryBean<PrescriptionItemEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PrescriptionItemEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PrescriptionItemEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PrescriptionItemEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for prescriptionItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionItemWithNoRef before the main body here] end

		PrescriptionItemEntity newEntity = new PrescriptionItemEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Iteration Start here] off begin
		newEntity.setIterationStart(mockNeat.ints().get());
		// % protected region % [Add customisation for Iteration Start here] end
		// % protected region % [Add customisation for Iteration End here] off begin
		newEntity.setIterationEnd(mockNeat.ints().get());
		// % protected region % [Add customisation for Iteration End here] end
		// % protected region % [Add customisation for Requested Quantity here] off begin
		newEntity.setRequestedQuantity(mockNeat.doubles().get());
		// % protected region % [Add customisation for Requested Quantity here] end
		// % protected region % [Add customisation for Allocated Quantity here] off begin
		newEntity.setAllocatedQuantity(mockNeat.doubles().get());
		// % protected region % [Add customisation for Allocated Quantity here] end
		// % protected region % [Add customisation for Issued Quantity here] off begin
		newEntity.setIssuedQuantity(mockNeat.doubles().get());
		// % protected region % [Add customisation for Issued Quantity here] end
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
		// % protected region % [Add customisation for Dosage Times here] off begin
		newEntity.setDosageTimes(mockNeat.ints().get());
		// % protected region % [Add customisation for Dosage Times here] end
		// % protected region % [Add customisation for Dosage Days here] off begin
		newEntity.setDosageDays(mockNeat.doubles().get());
		// % protected region % [Add customisation for Dosage Days here] end
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
		// % protected region % [Add customisation for Dose here] off begin
		newEntity.setDose(mockNeat.ints().get());
		// % protected region % [Add customisation for Dose here] end
		// % protected region % [Add customisation for External Stock Name here] off begin
		String randomStringForExternalStockName = mockNeat
				.strings()
				.get();
		newEntity.setExternalStockName(randomStringForExternalStockName);
		// % protected region % [Add customisation for External Stock Name here] end
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

		// % protected region % [Apply any additional logic for prescriptionItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionItemWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyCompound here] off begin
			var compoundFactory = new PrescriptionCompoundFactory();
			newEntity.setCompound(compoundFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyCompound here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue Id here] off begin
			var stockCatalogueIdFactory = new StockCatalogueFactory();
			newEntity.setStockCatalogueId(stockCatalogueIdFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue Id here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPrescription here] off begin
			var prescriptionFactory = new PrescriptionHeaderFactory();
			newEntity.setPrescription(prescriptionFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPrescription here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyUnit here] off begin
			var unitFactory = new UnitOfMeasurementFactory();
			newEntity.setUnit(unitFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyUnit here] end

		}

		// % protected region % [Apply any additional logic for prescriptionItem with ref here] off begin
		// % protected region % [Apply any additional logic for prescriptionItem with ref here] end

		return newEntity;
	}

	@Override
	public Class<PrescriptionItemEntity> getObjectType() {
		return PrescriptionItemEntity.class;
	}
}