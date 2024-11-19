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
import kmsweb.entities.InvoiceItemEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class InvoiceItemFactory implements FactoryBean<InvoiceItemEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public InvoiceItemEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public InvoiceItemEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public InvoiceItemEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for invoiceItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemWithNoRef before the main body here] end

		InvoiceItemEntity newEntity = new InvoiceItemEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Transaction Date here] off begin
		newEntity.setTransactionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Transaction Date here] end
		// % protected region % [Add customisation for Tariff Code here] off begin
		String randomStringForTariffCode = mockNeat
				.strings()
				.get();
		newEntity.setTariffCode(randomStringForTariffCode);
		// % protected region % [Add customisation for Tariff Code here] end
		// % protected region % [Add customisation for Tariff Type here] off begin
		newEntity.setTariffType(TariffTypeEnum.ROOM);
		// % protected region % [Add customisation for Tariff Type here] end
		// % protected region % [Add customisation for Name here] off begin
		String randomStringForName = mockNeat
				.strings()
				.get();
		newEntity.setName(randomStringForName);
		// % protected region % [Add customisation for Name here] end
		// % protected region % [Add customisation for Medical Staff Code here] off begin
		String randomStringForMedicalStaffCode = mockNeat
				.strings()
				.get();
		newEntity.setMedicalStaffCode(randomStringForMedicalStaffCode);
		// % protected region % [Add customisation for Medical Staff Code here] end
		// % protected region % [Add customisation for Price here] off begin
		newEntity.setPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Price here] end
		// % protected region % [Add customisation for Hospital Price here] off begin
		newEntity.setHospitalPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Hospital Price here] end
		// % protected region % [Add customisation for Total Other Component Price here] off begin
		newEntity.setTotalOtherComponentPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Other Component Price here] end
		// % protected region % [Add customisation for Quantity here] off begin
		newEntity.setQuantity(mockNeat.doubles().get());
		// % protected region % [Add customisation for Quantity here] end
		// % protected region % [Add customisation for Unit here] off begin
		String randomStringForUnit = mockNeat
				.strings()
				.get();
		newEntity.setUnit(randomStringForUnit);
		// % protected region % [Add customisation for Unit here] end
		// % protected region % [Add customisation for Discount here] off begin
		newEntity.setDiscount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Discount here] end
		// % protected region % [Add customisation for Tax here] off begin
		newEntity.setTax(mockNeat.bools().get());
		// % protected region % [Add customisation for Tax here] end
		// % protected region % [Add customisation for Item Total here] off begin
		newEntity.setItemTotal(mockNeat.doubles().get());
		// % protected region % [Add customisation for Item Total here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringForTreatmentClass = mockNeat
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringForTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.size(500)
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for invoiceItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyInvoice here] off begin
			var invoiceFactory = new InvoiceFactory();
			newEntity.setInvoice(invoiceFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyInvoice here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Fee here] off begin
			var medicalFeeFactory = new MedicalFeeFactory();
			newEntity.setMedicalFee(medicalFeeFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Fee here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyMedication Header here] off begin
			var medicationHeaderFactory = new MedicationHeaderFactory();
			newEntity.setMedicationHeader(medicationHeaderFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyMedication Header here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPrescription here] off begin
			var prescriptionFactory = new PrescriptionHeaderFactory();
			newEntity.setPrescription(prescriptionFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPrescription here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyRetail Pharmacy Invoice here] off begin
			var retailPharmacyInvoiceFactory = new RetailPharmacyInvoiceFactory();
			newEntity.setRetailPharmacyInvoice(retailPharmacyInvoiceFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyRetail Pharmacy Invoice here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyService Number here] off begin
			var serviceNumberFactory = new RegistrationFactory();
			newEntity.setServiceNumber(serviceNumberFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyService Number here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyTariff Schema here] off begin
			var tariffSchemaFactory = new TariffSchemaFactory();
			newEntity.setTariffSchema(tariffSchemaFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyTariff Schema here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Item Components here] off begin
			// Outgoing one to many reference
			var invoiceItemComponentsFactory = new InvoiceItemComponentFactory();
			newEntity.setInvoiceItemComponents(Collections.singletonList(invoiceItemComponentsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Item Components here] end

		}

		// % protected region % [Apply any additional logic for invoiceItem with ref here] off begin
		// % protected region % [Apply any additional logic for invoiceItem with ref here] end

		return newEntity;
	}

	@Override
	public Class<InvoiceItemEntity> getObjectType() {
		return InvoiceItemEntity.class;
	}
}