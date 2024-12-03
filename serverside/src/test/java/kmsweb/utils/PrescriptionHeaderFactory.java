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
import kmsweb.entities.PrescriptionHeaderEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PrescriptionHeaderFactory implements FactoryBean<PrescriptionHeaderEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PrescriptionHeaderEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PrescriptionHeaderEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PrescriptionHeaderEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for prescriptionHeaderWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionHeaderWithNoRef before the main body here] end

		PrescriptionHeaderEntity newEntity = new PrescriptionHeaderEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Prescription Number here] off begin
		String randomStringForPrescriptionNumber = mockNeat
				.strings()
				.get();
		newEntity.setPrescriptionNumber(randomStringForPrescriptionNumber);
		// % protected region % [Add customisation for Prescription Number here] end
		// % protected region % [Add customisation for Prescription Type here] off begin
		String randomStringForPrescriptionType = mockNeat
				.strings()
				.get();
		newEntity.setPrescriptionType(randomStringForPrescriptionType);
		// % protected region % [Add customisation for Prescription Type here] end
		// % protected region % [Add customisation for Queue No here] off begin
		String randomStringForQueueNo = mockNeat
				.strings()
				.get();
		newEntity.setQueueNo(randomStringForQueueNo);
		// % protected region % [Add customisation for Queue No here] end
		// % protected region % [Add customisation for Original Prescription Number here] off begin
		String randomStringForOriginalPrescriptionNumber = mockNeat
				.strings()
				.get();
		newEntity.setOriginalPrescriptionNumber(randomStringForOriginalPrescriptionNumber);
		// % protected region % [Add customisation for Original Prescription Number here] end
		// % protected region % [Add customisation for Prescription Date here] off begin
		newEntity.setPrescriptionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Prescription Date here] end
		// % protected region % [Add customisation for Is Compound here] off begin
		newEntity.setIsCompound(mockNeat.bools().get());
		// % protected region % [Add customisation for Is Compound here] end
		// % protected region % [Add customisation for Is Iteration here] off begin
		newEntity.setIsIteration(mockNeat.bools().get());
		// % protected region % [Add customisation for Is Iteration here] end
		// % protected region % [Add customisation for Status here] off begin
		String randomStringForStatus = mockNeat
				.strings()
				.get();
		newEntity.setStatus(randomStringForStatus);
		// % protected region % [Add customisation for Status here] end
		// % protected region % [Add customisation for Is Urgent here] off begin
		newEntity.setIsUrgent(mockNeat.bools().get());
		// % protected region % [Add customisation for Is Urgent here] end
		// % protected region % [Add customisation for Restricted here] off begin
		newEntity.setRestricted(mockNeat.bools().get());
		// % protected region % [Add customisation for Restricted here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Revision No here] off begin
		newEntity.setRevisionNo(mockNeat.ints().get());
		// % protected region % [Add customisation for Revision No here] end
		// % protected region % [Add customisation for Copy No here] off begin
		newEntity.setCopyNo(mockNeat.ints().get());
		// % protected region % [Add customisation for Copy No here] end
		// % protected region % [Add customisation for Is Invoiced here] off begin
		newEntity.setIsInvoiced(mockNeat.bools().get());
		// % protected region % [Add customisation for Is Invoiced here] end
		// % protected region % [Add customisation for External Warehouse here] off begin
		newEntity.setExternalWarehouse(mockNeat.bools().get());
		// % protected region % [Add customisation for External Warehouse here] end

		// % protected region % [Apply any additional logic for prescriptionHeaderWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionHeaderWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Invoice here] off begin
			// Incoming One to One reference
			var invoiceFactory = new InvoiceFactory();
			newEntity.setInvoice(invoiceFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Invoice here] end
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyRegistration here] off begin
			var registrationFactory = new RegistrationFactory();
			newEntity.setRegistration(registrationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyRegistration here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyRequested By here] off begin
			var requestedByFactory = new StaffFactory();
			newEntity.setRequestedBy(requestedByFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyRequested By here] end

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

			// % protected region % [Override the reference inclusion for outgoingOneToMany Prescription Compounds here] off begin
			// Outgoing one to many reference
			var prescriptionCompoundsFactory = new PrescriptionCompoundFactory();
			newEntity.setPrescriptionCompounds(Collections.singletonList(prescriptionCompoundsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Prescription Compounds here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Prescription Items here] off begin
			// Outgoing one to many reference
			var prescriptionItemsFactory = new PrescriptionItemFactory();
			newEntity.setPrescriptionItems(Collections.singletonList(prescriptionItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Prescription Items here] end

		}

		// % protected region % [Apply any additional logic for prescriptionHeader with ref here] off begin
		// % protected region % [Apply any additional logic for prescriptionHeader with ref here] end

		return newEntity;
	}

	@Override
	public Class<PrescriptionHeaderEntity> getObjectType() {
		return PrescriptionHeaderEntity.class;
	}
}