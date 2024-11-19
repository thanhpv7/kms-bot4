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
import kmsweb.entities.ServiceEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class ServiceFactory implements FactoryBean<ServiceEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public ServiceEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public ServiceEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public ServiceEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for serviceWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceWithNoRef before the main body here] end

		ServiceEntity newEntity = new ServiceEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Service Number here] off begin
		String randomStringForServiceNumber = mockNeat
				.strings()
				.get();
		newEntity.setServiceNumber(randomStringForServiceNumber);
		// % protected region % [Add customisation for Service Number here] end
		// % protected region % [Add customisation for Service Name here] off begin
		String randomStringForServiceName = mockNeat
				.strings()
				.get();
		newEntity.setServiceName(randomStringForServiceName);
		// % protected region % [Add customisation for Service Name here] end
		// % protected region % [Add customisation for Section Code here] off begin
		String randomStringForSectionCode = mockNeat
				.strings()
				.get();
		newEntity.setSectionCode(randomStringForSectionCode);
		// % protected region % [Add customisation for Section Code here] end
		// % protected region % [Add customisation for By pass Doctor Assignment here] off begin
		newEntity.setByPassDoctorAssignment(mockNeat.bools().get());
		// % protected region % [Add customisation for By pass Doctor Assignment here] end
		// % protected region % [Add customisation for Has Examination Item here] off begin
		newEntity.setHasExaminationItem(mockNeat.bools().get());
		// % protected region % [Add customisation for Has Examination Item here] end
		// % protected region % [Add customisation for Revenue Center here] off begin
		String randomStringForRevenueCenter = mockNeat
				.strings()
				.get();
		newEntity.setRevenueCenter(randomStringForRevenueCenter);
		// % protected region % [Add customisation for Revenue Center here] end
		// % protected region % [Add customisation for Service Code here] off begin
		String randomStringForServiceCode = mockNeat
				.strings()
				.get();
		newEntity.setServiceCode(randomStringForServiceCode);
		// % protected region % [Add customisation for Service Code here] end

		// % protected region % [Apply any additional logic for serviceWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Default Medical Staff here] off begin
			// Incoming One to One reference
			var defaultMedicalStaffFactory = new StaffFactory();
			newEntity.setDefaultMedicalStaff(defaultMedicalStaffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Default Medical Staff here] end
			// % protected region % [Override the reference inclusions for outgoingOneToOne BPJS Pcare Poli] off begin
			// Outgoing one to one reference
			var bpjsPcarePoliFactory = new BpjsPcarePoliFactory();
			newEntity.setBpjsPcarePoli(bpjsPcarePoliFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne BPJS Pcare Poli] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne BPJS Service Mapping] off begin
			// Outgoing one to one reference
			var bpjsServiceMappingFactory = new BpjsServiceMappingFactory();
			newEntity.setBpjsServiceMapping(bpjsServiceMappingFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne BPJS Service Mapping] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Doctor Schedules here] off begin
			// Outgoing one to many reference
			var doctorSchedulesFactory = new DoctorScheduleFactory();
			newEntity.setDoctorSchedules(Collections.singletonList(doctorSchedulesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Doctor Schedules here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Examination Groups here] off begin
			// Outgoing one to many reference
			var examinationGroupsFactory = new ExaminationGroupFactory();
			newEntity.setExaminationGroups(Collections.singletonList(examinationGroupsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Examination Groups here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany MCU Package Items here] off begin
			// Outgoing one to many reference
			var mcuPackageItemsFactory = new McuPackageItemFactory();
			newEntity.setMcuPackageItems(Collections.singletonList(mcuPackageItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany MCU Package Items here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Referring Unit here] off begin
			// Outgoing one to many reference
			var referringUnitFactory = new RegistrationFactory();
			newEntity.setReferringUnit(Collections.singletonList(referringUnitFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Referring Unit here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Registrations here] off begin
			// Outgoing one to many reference
			var registrationsFactory = new RegistrationFactory();
			newEntity.setRegistrations(Collections.singletonList(registrationsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Registrations here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Service Facility Categories here] off begin
			// Outgoing one to many reference
			var serviceFacilityCategoriesFactory = new ServiceFacilityCategoryFactory();
			newEntity.setServiceFacilityCategories(Collections.singletonList(serviceFacilityCategoriesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Service Facility Categories here] end

			// % protected region % [Override the reference inclusion for outgoingManyToMany Service Items here] off begin
			// Outgoing many to many reference
			var serviceItemsFactory = new ServiceItemFactory();
			newEntity.setServiceItems(Collections.singletonList(serviceItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingManyToMany Service Items here] end

			// % protected region % [Override the reference inclusions for incomingManyToMany Assigned Medical Staff] off begin
			// Incoming many to many reference
			var assignedMedicalStaffFactory = new StaffFactory();
			newEntity.setAssignedMedicalStaff(Collections.singletonList(assignedMedicalStaffFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusions for incomingManyToMany Assigned Medical Staff] end

		}

		// % protected region % [Apply any additional logic for service with ref here] off begin
		// % protected region % [Apply any additional logic for service with ref here] end

		return newEntity;
	}

	@Override
	public Class<ServiceEntity> getObjectType() {
		return ServiceEntity.class;
	}
}