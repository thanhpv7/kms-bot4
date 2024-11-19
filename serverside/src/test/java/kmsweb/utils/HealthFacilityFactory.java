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
import kmsweb.entities.HealthFacilityEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class HealthFacilityFactory implements FactoryBean<HealthFacilityEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public HealthFacilityEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public HealthFacilityEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public HealthFacilityEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for healthFacilityWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for healthFacilityWithNoRef before the main body here] end

		HealthFacilityEntity newEntity = new HealthFacilityEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Health Facility ID here] off begin
		String randomStringForHealthFacilityID = mockNeat
				.strings()
				.get();
		newEntity.setHealthFacilityID(randomStringForHealthFacilityID);
		// % protected region % [Add customisation for Health Facility ID here] end
		// % protected region % [Add customisation for Health Facility Name here] off begin
		String randomStringForHealthFacilityName = mockNeat
				.strings()
				.get();
		newEntity.setHealthFacilityName(randomStringForHealthFacilityName);
		// % protected region % [Add customisation for Health Facility Name here] end
		// % protected region % [Add customisation for Address here] off begin
		String randomStringForAddress = mockNeat
				.strings()
				.get();
		newEntity.setAddress(randomStringForAddress);
		// % protected region % [Add customisation for Address here] end
		// % protected region % [Add customisation for City here] off begin
		String randomStringForCity = mockNeat
				.strings()
				.get();
		newEntity.setCity(randomStringForCity);
		// % protected region % [Add customisation for City here] end
		// % protected region % [Add customisation for Post Code here] off begin
		String randomStringForPostCode = mockNeat
				.strings()
				.get();
		newEntity.setPostCode(randomStringForPostCode);
		// % protected region % [Add customisation for Post Code here] end
		// % protected region % [Add customisation for Province here] off begin
		String randomStringForProvince = mockNeat
				.strings()
				.get();
		newEntity.setProvince(randomStringForProvince);
		// % protected region % [Add customisation for Province here] end
		// % protected region % [Add customisation for Country here] off begin
		String randomStringForCountry = mockNeat
				.strings()
				.get();
		newEntity.setCountry(randomStringForCountry);
		// % protected region % [Add customisation for Country here] end
		// % protected region % [Add customisation for Phone Number here] off begin
		String randomStringForPhoneNumber = mockNeat
				.strings()
				.get();
		newEntity.setPhoneNumber(randomStringForPhoneNumber);
		// % protected region % [Add customisation for Phone Number here] end
		// % protected region % [Add customisation for Mobile Phone Number here] off begin
		String randomStringForMobilePhoneNumber = mockNeat
				.strings()
				.get();
		newEntity.setMobilePhoneNumber(randomStringForMobilePhoneNumber);
		// % protected region % [Add customisation for Mobile Phone Number here] end
		// % protected region % [Add customisation for website here] off begin
		String randomStringForWebsite = mockNeat
				.strings()
				.get();
		newEntity.setWebsite(randomStringForWebsite);
		// % protected region % [Add customisation for website here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringForEmail = mockNeat
				.strings()
				.get();
		newEntity.setEmail(randomStringForEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for Salutation here] off begin
		String randomStringForSalutation = mockNeat
				.strings()
				.get();
		newEntity.setSalutation(randomStringForSalutation);
		// % protected region % [Add customisation for Salutation here] end
		// % protected region % [Add customisation for First Name here] off begin
		String randomStringForFirstName = mockNeat
				.strings()
				.get();
		newEntity.setFirstName(randomStringForFirstName);
		// % protected region % [Add customisation for First Name here] end
		// % protected region % [Add customisation for Last Name here] off begin
		String randomStringForLastName = mockNeat
				.strings()
				.get();
		newEntity.setLastName(randomStringForLastName);
		// % protected region % [Add customisation for Last Name here] end
		// % protected region % [Add customisation for Phone Number POC here] off begin
		String randomStringForPhoneNumberPOC = mockNeat
				.strings()
				.get();
		newEntity.setPhoneNumberPOC(randomStringForPhoneNumberPOC);
		// % protected region % [Add customisation for Phone Number POC here] end
		// % protected region % [Add customisation for Mobile Phone Number POC here] off begin
		String randomStringForMobilePhoneNumberPOC = mockNeat
				.strings()
				.get();
		newEntity.setMobilePhoneNumberPOC(randomStringForMobilePhoneNumberPOC);
		// % protected region % [Add customisation for Mobile Phone Number POC here] end
		// % protected region % [Add customisation for Email POC here] off begin
		String randomStringForEmailPOC = mockNeat
				.strings()
				.get();
		newEntity.setEmailPOC(randomStringForEmailPOC);
		// % protected region % [Add customisation for Email POC here] end
		// % protected region % [Add customisation for Health Facility Type here] off begin
		String randomStringForHealthFacilityType = mockNeat
				.strings()
				.get();
		newEntity.setHealthFacilityType(randomStringForHealthFacilityType);
		// % protected region % [Add customisation for Health Facility Type here] end

		// % protected region % [Apply any additional logic for healthFacilityWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for healthFacilityWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusion for outgoingOneToMany Dismissal Referring Facility here] off begin
			// Outgoing one to many reference
			var dismissalReferringFacilityFactory = new RegistrationFactory();
			newEntity.setDismissalReferringFacility(Collections.singletonList(dismissalReferringFacilityFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Dismissal Referring Facility here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Referring facility here] off begin
			// Outgoing one to many reference
			var referringFacilityFactory = new RegistrationFactory();
			newEntity.setReferringFacility(Collections.singletonList(referringFacilityFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Referring facility here] end

		}

		// % protected region % [Apply any additional logic for healthFacility with ref here] off begin
		// % protected region % [Apply any additional logic for healthFacility with ref here] end

		return newEntity;
	}

	@Override
	public Class<HealthFacilityEntity> getObjectType() {
		return HealthFacilityEntity.class;
	}
}