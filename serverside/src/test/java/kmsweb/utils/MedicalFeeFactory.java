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
import kmsweb.entities.MedicalFeeEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class MedicalFeeFactory implements FactoryBean<MedicalFeeEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public MedicalFeeEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public MedicalFeeEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public MedicalFeeEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for medicalFeeWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeWithNoRef before the main body here] end

		MedicalFeeEntity newEntity = new MedicalFeeEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Tariff Type here] off begin
		newEntity.setTariffType(TariffTypeEnum.ROOM);
		// % protected region % [Add customisation for Tariff Type here] end
		// % protected region % [Add customisation for Tariff Code here] off begin
		String randomStringForTariffCode = mockNeat
				.strings()
				.get();
		newEntity.setTariffCode(randomStringForTariffCode);
		// % protected region % [Add customisation for Tariff Code here] end
		// % protected region % [Add customisation for Name here] off begin
		String randomStringForName = mockNeat
				.strings()
				.get();
		newEntity.setName(randomStringForName);
		// % protected region % [Add customisation for Name here] end
		// % protected region % [Add customisation for Pharmacy Transaction Type here] off begin
		newEntity.setPharmacyTransactionType(PharmacyTypeEnum.MEDICATION);
		// % protected region % [Add customisation for Pharmacy Transaction Type here] end
		// % protected region % [Add customisation for Pharmacy Transaction Number here] off begin
		String randomStringForPharmacyTransactionNumber = mockNeat
				.strings()
				.get();
		newEntity.setPharmacyTransactionNumber(randomStringForPharmacyTransactionNumber);
		// % protected region % [Add customisation for Pharmacy Transaction Number here] end
		// % protected region % [Add customisation for Medication Transaction Number here] off begin
		String randomStringForMedicationTransactionNumber = mockNeat
				.strings()
				.get();
		newEntity.setMedicationTransactionNumber(randomStringForMedicationTransactionNumber);
		// % protected region % [Add customisation for Medication Transaction Number here] end
		// % protected region % [Add customisation for Transaction Date here] off begin
		newEntity.setTransactionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Transaction Date here] end
		// % protected region % [Add customisation for Quantity here] off begin
		newEntity.setQuantity(mockNeat.doubles().get());
		// % protected region % [Add customisation for Quantity here] end
		// % protected region % [Add customisation for Unit here] off begin
		String randomStringForUnit = mockNeat
				.strings()
				.get();
		newEntity.setUnit(randomStringForUnit);
		// % protected region % [Add customisation for Unit here] end
		// % protected region % [Add customisation for Unit Price here] off begin
		newEntity.setUnitPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Unit Price here] end
		// % protected region % [Add customisation for Hospital Price here] off begin
		newEntity.setHospitalPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Hospital Price here] end
		// % protected region % [Add customisation for Other Component Price here] off begin
		newEntity.setOtherComponentPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Other Component Price here] end
		// % protected region % [Add customisation for Medical Staff Code here] off begin
		String randomStringForMedicalStaffCode = mockNeat
				.strings()
				.get();
		newEntity.setMedicalStaffCode(randomStringForMedicalStaffCode);
		// % protected region % [Add customisation for Medical Staff Code here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringForTreatmentClass = mockNeat
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringForTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for medical fee status here] off begin
		newEntity.setMedicalFeeStatus(MedicalFeeStatusEnum.OPEN);
		// % protected region % [Add customisation for medical fee status here] end
		// % protected region % [Add customisation for Inventory Rounding Value here] off begin
		newEntity.setInventoryRoundingValue(mockNeat.doubles().get());
		// % protected region % [Add customisation for Inventory Rounding Value here] end

		// % protected region % [Apply any additional logic for medicalFeeWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyRegistration here] off begin
			var registrationFactory = new RegistrationFactory();
			newEntity.setRegistration(registrationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyRegistration here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyWarehouse here] off begin
			var warehouseFactory = new WarehouseFactory();
			newEntity.setWarehouse(warehouseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyWarehouse here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Items here] off begin
			// Outgoing one to many reference
			var invoiceItemsFactory = new InvoiceItemFactory();
			newEntity.setInvoiceItems(Collections.singletonList(invoiceItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Items here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Fee Item Components here] off begin
			// Outgoing one to many reference
			var medicalFeeItemComponentsFactory = new MedicalFeeItemComponentFactory();
			newEntity.setMedicalFeeItemComponents(Collections.singletonList(medicalFeeItemComponentsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Fee Item Components here] end

		}

		// % protected region % [Apply any additional logic for medicalFee with ref here] off begin
		// % protected region % [Apply any additional logic for medicalFee with ref here] end

		return newEntity;
	}

	@Override
	public Class<MedicalFeeEntity> getObjectType() {
		return MedicalFeeEntity.class;
	}
}