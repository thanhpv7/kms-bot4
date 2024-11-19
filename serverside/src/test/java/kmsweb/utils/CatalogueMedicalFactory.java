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
import kmsweb.entities.CatalogueMedicalEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class CatalogueMedicalFactory implements FactoryBean<CatalogueMedicalEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public CatalogueMedicalEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public CatalogueMedicalEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public CatalogueMedicalEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for catalogueMedicalWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueMedicalWithNoRef before the main body here] end

		CatalogueMedicalEntity newEntity = new CatalogueMedicalEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Composition here] off begin
		String randomStringForComposition = mockNeat
				.strings()
				.get();
		newEntity.setComposition(randomStringForComposition);
		// % protected region % [Add customisation for Composition here] end
		// % protected region % [Add customisation for Can be prescribed here] off begin
		newEntity.setCanBePrescribed(mockNeat.bools().get());
		// % protected region % [Add customisation for Can be prescribed here] end
		// % protected region % [Add customisation for Is Hospital Formulary here] off begin
		newEntity.setIsHospitalFormulary(mockNeat.bools().get());
		// % protected region % [Add customisation for Is Hospital Formulary here] end
		// % protected region % [Add customisation for Approval Notes here] off begin
		String randomStringForApprovalNotes = mockNeat
				.strings()
				.get();
		newEntity.setApprovalNotes(randomStringForApprovalNotes);
		// % protected region % [Add customisation for Approval Notes here] end
		// % protected region % [Add customisation for Is Generic here] off begin
		newEntity.setIsGeneric(mockNeat.bools().get());
		// % protected region % [Add customisation for Is Generic here] end
		// % protected region % [Add customisation for Is Restricted here] off begin
		newEntity.setIsRestricted(mockNeat.bools().get());
		// % protected region % [Add customisation for Is Restricted here] end
		// % protected region % [Add customisation for Is Vaccine here] off begin
		newEntity.setIsVaccine(mockNeat.bools().get());
		// % protected region % [Add customisation for Is Vaccine here] end
		// % protected region % [Add customisation for Vaccine Type here] off begin
		String randomStringForVaccineType = mockNeat
				.strings()
				.get();
		newEntity.setVaccineType(randomStringForVaccineType);
		// % protected region % [Add customisation for Vaccine Type here] end
		// % protected region % [Add customisation for Consumption Method here] off begin
		String randomStringForConsumptionMethod = mockNeat
				.strings()
				.get();
		newEntity.setConsumptionMethod(randomStringForConsumptionMethod);
		// % protected region % [Add customisation for Consumption Method here] end
		// % protected region % [Add customisation for Consumption Unit here] off begin
		String randomStringForConsumptionUnit = mockNeat
				.strings()
				.get();
		newEntity.setConsumptionUnit(randomStringForConsumptionUnit);
		// % protected region % [Add customisation for Consumption Unit here] end
		// % protected region % [Add customisation for Compound Charging Rounding here] off begin
		newEntity.setCompoundChargingRounding(mockNeat.bools().get());
		// % protected region % [Add customisation for Compound Charging Rounding here] end
		// % protected region % [Add customisation for Compound Charging Rounding Amount here] off begin
		String randomStringForCompoundChargingRoundingAmount = mockNeat
				.strings()
				.get();
		newEntity.setCompoundChargingRoundingAmount(randomStringForCompoundChargingRoundingAmount);
		// % protected region % [Add customisation for Compound Charging Rounding Amount here] end
		// % protected region % [Add customisation for Inventory Rounding here] off begin
		newEntity.setInventoryRounding(mockNeat.bools().get());
		// % protected region % [Add customisation for Inventory Rounding here] end
		// % protected region % [Add customisation for Inventory Rounding Amount here] off begin
		newEntity.setInventoryRoundingAmount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Inventory Rounding Amount here] end

		// % protected region % [Apply any additional logic for catalogueMedicalWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueMedicalWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Stock Catalogue here] off begin
			// Incoming One to One reference
			var stockCatalogueFactory = new StockCatalogueFactory();
			newEntity.setStockCatalogue(stockCatalogueFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Stock Catalogue here] end
		}

		// % protected region % [Apply any additional logic for catalogueMedical with ref here] off begin
		// % protected region % [Apply any additional logic for catalogueMedical with ref here] end

		return newEntity;
	}

	@Override
	public Class<CatalogueMedicalEntity> getObjectType() {
		return CatalogueMedicalEntity.class;
	}
}