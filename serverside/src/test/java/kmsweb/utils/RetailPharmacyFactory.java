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
import kmsweb.entities.RetailPharmacyEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class RetailPharmacyFactory implements FactoryBean<RetailPharmacyEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public RetailPharmacyEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public RetailPharmacyEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public RetailPharmacyEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for retailPharmacyWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyWithNoRef before the main body here] end

		RetailPharmacyEntity newEntity = new RetailPharmacyEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Customer Type here] off begin
		String randomStringForCustomerType = mockNeat
				.strings()
				.get();
		newEntity.setCustomerType(randomStringForCustomerType);
		// % protected region % [Add customisation for Customer Type here] end
		// % protected region % [Add customisation for Retail Number here] off begin
		String randomStringForRetailNumber = mockNeat
				.strings()
				.get();
		newEntity.setRetailNumber(randomStringForRetailNumber);
		// % protected region % [Add customisation for Retail Number here] end
		// % protected region % [Add customisation for Status here] off begin
		String randomStringForStatus = mockNeat
				.strings()
				.get();
		newEntity.setStatus(randomStringForStatus);
		// % protected region % [Add customisation for Status here] end
		// % protected region % [Add customisation for Customer Name here] off begin
		String randomStringForCustomerName = mockNeat
				.strings()
				.get();
		newEntity.setCustomerName(randomStringForCustomerName);
		// % protected region % [Add customisation for Customer Name here] end
		// % protected region % [Add customisation for Address here] off begin
		String randomStringForAddress = mockNeat
				.strings()
				.get();
		newEntity.setAddress(randomStringForAddress);
		// % protected region % [Add customisation for Address here] end
		// % protected region % [Add customisation for Phone Number here] off begin
		String randomStringForPhoneNumber = mockNeat
				.strings()
				.get();
		newEntity.setPhoneNumber(randomStringForPhoneNumber);
		// % protected region % [Add customisation for Phone Number here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Payment Status here] off begin
		String randomStringForPaymentStatus = mockNeat
				.strings()
				.get();
		newEntity.setPaymentStatus(randomStringForPaymentStatus);
		// % protected region % [Add customisation for Payment Status here] end
		// % protected region % [Add customisation for Total Price here] off begin
		newEntity.setTotalPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Price here] end

		// % protected region % [Apply any additional logic for retailPharmacyWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient General Info here] off begin
			var patientGeneralInfoFactory = new PatientGeneralInfoFactory();
			newEntity.setPatientGeneralInfo(patientGeneralInfoFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient General Info here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyWarehouse here] off begin
			var warehouseFactory = new WarehouseFactory();
			newEntity.setWarehouse(warehouseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyWarehouse here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Retail Pharmacy Invoices here] off begin
			// Outgoing one to many reference
			var retailPharmacyInvoicesFactory = new RetailPharmacyInvoiceFactory();
			newEntity.setRetailPharmacyInvoices(Collections.singletonList(retailPharmacyInvoicesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Retail Pharmacy Invoices here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Retail Pharmacy Stock Details here] off begin
			// Outgoing one to many reference
			var retailPharmacyStockDetailsFactory = new RetailPharmacyStockDetailFactory();
			newEntity.setRetailPharmacyStockDetails(Collections.singletonList(retailPharmacyStockDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Retail Pharmacy Stock Details here] end

		}

		// % protected region % [Apply any additional logic for retailPharmacy with ref here] off begin
		// % protected region % [Apply any additional logic for retailPharmacy with ref here] end

		return newEntity;
	}

	@Override
	public Class<RetailPharmacyEntity> getObjectType() {
		return RetailPharmacyEntity.class;
	}
}