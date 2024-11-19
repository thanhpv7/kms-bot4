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
import kmsweb.entities.BedFacilityEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BedFacilityFactory implements FactoryBean<BedFacilityEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BedFacilityEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BedFacilityEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BedFacilityEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bedFacilityWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bedFacilityWithNoRef before the main body here] end

		BedFacilityEntity newEntity = new BedFacilityEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Bed Number here] off begin
		String randomStringForBedNumber = mockNeat
				.strings()
				.get();
		newEntity.setBedNumber(randomStringForBedNumber);
		// % protected region % [Add customisation for Bed Number here] end
		// % protected region % [Add customisation for Bed Name here] off begin
		String randomStringForBedName = mockNeat
				.strings()
				.get();
		newEntity.setBedName(randomStringForBedName);
		// % protected region % [Add customisation for Bed Name here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringForTreatmentClass = mockNeat
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringForTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Availability here] off begin
		String randomStringForAvailability = mockNeat
				.strings()
				.get();
		newEntity.setAvailability(randomStringForAvailability);
		// % protected region % [Add customisation for Availability here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for COA COGS here] off begin
		String randomStringForCoaCOGS = mockNeat
				.strings()
				.get();
		newEntity.setCoaCOGS(randomStringForCoaCOGS);
		// % protected region % [Add customisation for COA COGS here] end
		// % protected region % [Add customisation for COA Sell here] off begin
		String randomStringForCoaSell = mockNeat
				.strings()
				.get();
		newEntity.setCoaSell(randomStringForCoaSell);
		// % protected region % [Add customisation for COA Sell here] end
		// % protected region % [Add customisation for COA Inventory here] off begin
		String randomStringForCoaInventory = mockNeat
				.strings()
				.get();
		newEntity.setCoaInventory(randomStringForCoaInventory);
		// % protected region % [Add customisation for COA Inventory here] end

		// % protected region % [Apply any additional logic for bedFacilityWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bedFacilityWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyIntraoperative Records here] off begin
			var intraoperativeRecordsFactory = new IntraoperativeRecordsFactory();
			newEntity.setIntraoperativeRecords(intraoperativeRecordsFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyIntraoperative Records here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPost Operative Details here] off begin
			var postOperativeDetailsFactory = new PostOperativeDetailsFactory();
			newEntity.setPostOperativeDetails(postOperativeDetailsFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPost Operative Details here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPreoperative Records here] off begin
			var preoperativeRecordsFactory = new PreoperativeRecordsFactory();
			newEntity.setPreoperativeRecords(preoperativeRecordsFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPreoperative Records here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyRoom Facility here] off begin
			var roomFacilityFactory = new RoomFacilityFactory();
			newEntity.setRoomFacility(roomFacilityFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyRoom Facility here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Bed Reserves here] off begin
			// Outgoing one to many reference
			var bedReservesFactory = new BedReserveFactory();
			newEntity.setBedReserves(Collections.singletonList(bedReservesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Bed Reserves here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Inpatient Medical Examination Records here] off begin
			// Outgoing one to many reference
			var inpatientMedicalExaminationRecordsFactory = new InpatientMedicalExaminationRecordFactory();
			newEntity.setInpatientMedicalExaminationRecords(Collections.singletonList(inpatientMedicalExaminationRecordsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Inpatient Medical Examination Records here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoices here] off begin
			// Outgoing one to many reference
			var invoicesFactory = new InvoiceFactory();
			newEntity.setInvoices(Collections.singletonList(invoicesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoices here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Registrations here] off begin
			// Outgoing one to many reference
			var registrationsFactory = new RegistrationFactory();
			newEntity.setRegistrations(Collections.singletonList(registrationsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Registrations here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Room Transfers here] off begin
			// Outgoing one to many reference
			var roomTransfersFactory = new RoomTransferFactory();
			newEntity.setRoomTransfers(Collections.singletonList(roomTransfersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Room Transfers here] end

		}

		// % protected region % [Apply any additional logic for bedFacility with ref here] off begin
		// % protected region % [Apply any additional logic for bedFacility with ref here] end

		return newEntity;
	}

	@Override
	public Class<BedFacilityEntity> getObjectType() {
		return BedFacilityEntity.class;
	}
}