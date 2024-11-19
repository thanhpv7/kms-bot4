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
import kmsweb.entities.PatientEmergencyContactDetailEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PatientEmergencyContactDetailFactory implements FactoryBean<PatientEmergencyContactDetailEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PatientEmergencyContactDetailEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PatientEmergencyContactDetailEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PatientEmergencyContactDetailEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for patientEmergencyContactDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmergencyContactDetailWithNoRef before the main body here] end

		PatientEmergencyContactDetailEntity newEntity = new PatientEmergencyContactDetailEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Title here] off begin
		String randomStringForTitle = mockNeat
				.strings()
				.get();
		newEntity.setTitle(randomStringForTitle);
		// % protected region % [Add customisation for Title here] end
		// % protected region % [Add customisation for Given Name here] off begin
		String randomStringForGivenName = mockNeat
				.strings()
				.get();
		newEntity.setGivenName(randomStringForGivenName);
		// % protected region % [Add customisation for Given Name here] end
		// % protected region % [Add customisation for Last Name here] off begin
		String randomStringForLastName = mockNeat
				.strings()
				.get();
		newEntity.setLastName(randomStringForLastName);
		// % protected region % [Add customisation for Last Name here] end
		// % protected region % [Add customisation for Relationship here] off begin
		String randomStringForRelationship = mockNeat
				.strings()
				.get();
		newEntity.setRelationship(randomStringForRelationship);
		// % protected region % [Add customisation for Relationship here] end
		// % protected region % [Add customisation for Date Of Birth here] off begin
		newEntity.setDateOfBirth(OffsetDateTime.now());
		// % protected region % [Add customisation for Date Of Birth here] end
		// % protected region % [Add customisation for Address here] off begin
		String randomStringForAddress = mockNeat
				.strings()
				.get();
		newEntity.setAddress(randomStringForAddress);
		// % protected region % [Add customisation for Address here] end
		// % protected region % [Add customisation for Home Phone No here] off begin
		String randomStringForHomePhoneNo = mockNeat
				.strings()
				.get();
		newEntity.setHomePhoneNo(randomStringForHomePhoneNo);
		// % protected region % [Add customisation for Home Phone No here] end
		// % protected region % [Add customisation for Mobile Phone No here] off begin
		String randomStringForMobilePhoneNo = mockNeat
				.strings()
				.get();
		newEntity.setMobilePhoneNo(randomStringForMobilePhoneNo);
		// % protected region % [Add customisation for Mobile Phone No here] end
		// % protected region % [Add customisation for Office Phone No here] off begin
		String randomStringForOfficePhoneNo = mockNeat
				.strings()
				.get();
		newEntity.setOfficePhoneNo(randomStringForOfficePhoneNo);
		// % protected region % [Add customisation for Office Phone No here] end
		// % protected region % [Add customisation for Extension No here] off begin
		String randomStringForExtensionNo = mockNeat
				.strings()
				.get();
		newEntity.setExtensionNo(randomStringForExtensionNo);
		// % protected region % [Add customisation for Extension No here] end
		// % protected region % [Add customisation for Email Address here] off begin
		String randomStringForEmailAddress = mockNeat
				.strings()
				.get();
		newEntity.setEmailAddress(randomStringForEmailAddress);
		// % protected region % [Add customisation for Email Address here] end
		// % protected region % [Add customisation for ID Card here] off begin
		String randomStringForIdCard = mockNeat
				.strings()
				.get();
		newEntity.setIdCard(randomStringForIdCard);
		// % protected region % [Add customisation for ID Card here] end

		// % protected region % [Apply any additional logic for patientEmergencyContactDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmergencyContactDetailWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Patient General Information here] off begin
			// Incoming One to One reference
			var patientGeneralInformationFactory = new PatientGeneralInfoFactory();
			newEntity.setPatientGeneralInformation(patientGeneralInformationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Patient General Information here] end
		}

		// % protected region % [Apply any additional logic for patientEmergencyContactDetail with ref here] off begin
		// % protected region % [Apply any additional logic for patientEmergencyContactDetail with ref here] end

		return newEntity;
	}

	@Override
	public Class<PatientEmergencyContactDetailEntity> getObjectType() {
		return PatientEmergencyContactDetailEntity.class;
	}
}