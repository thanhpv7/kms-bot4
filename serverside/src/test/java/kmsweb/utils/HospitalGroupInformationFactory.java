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
import kmsweb.entities.HospitalGroupInformationEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class HospitalGroupInformationFactory implements FactoryBean<HospitalGroupInformationEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public HospitalGroupInformationEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public HospitalGroupInformationEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public HospitalGroupInformationEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for hospitalGroupInformationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalGroupInformationWithNoRef before the main body here] end

		HospitalGroupInformationEntity newEntity = new HospitalGroupInformationEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Hospital Group Code here] off begin
		String randomStringForHospitalGroupCode = mockNeat
				.strings()
				.get();
		newEntity.setHospitalGroupCode(randomStringForHospitalGroupCode);
		// % protected region % [Add customisation for Hospital Group Code here] end
		// % protected region % [Add customisation for Hospital Group Name here] off begin
		String randomStringForHospitalGroupName = mockNeat
				.strings()
				.get();
		newEntity.setHospitalGroupName(randomStringForHospitalGroupName);
		// % protected region % [Add customisation for Hospital Group Name here] end
		// % protected region % [Add customisation for Hospital Group Corporation Name here] off begin
		String randomStringForHospitalGroupCorporationName = mockNeat
				.strings()
				.get();
		newEntity.setHospitalGroupCorporationName(randomStringForHospitalGroupCorporationName);
		// % protected region % [Add customisation for Hospital Group Corporation Name here] end
		// % protected region % [Add customisation for Hospital Group Director here] off begin
		String randomStringForHospitalGroupDirector = mockNeat
				.strings()
				.get();
		newEntity.setHospitalGroupDirector(randomStringForHospitalGroupDirector);
		// % protected region % [Add customisation for Hospital Group Director here] end
		// % protected region % [Add customisation for Operational License No here] off begin
		String randomStringForOperationalLicenseNo = mockNeat
				.strings()
				.get();
		newEntity.setOperationalLicenseNo(randomStringForOperationalLicenseNo);
		// % protected region % [Add customisation for Operational License No here] end
		// % protected region % [Add customisation for Hospital Group Corporation Status here] off begin
		String randomStringForHospitalGroupCorporationStatus = mockNeat
				.strings()
				.get();
		newEntity.setHospitalGroupCorporationStatus(randomStringForHospitalGroupCorporationStatus);
		// % protected region % [Add customisation for Hospital Group Corporation Status here] end
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
		// % protected region % [Add customisation for Postcode here] off begin
		String randomStringForPostcode = mockNeat
				.strings()
				.get();
		newEntity.setPostcode(randomStringForPostcode);
		// % protected region % [Add customisation for Postcode here] end
		// % protected region % [Add customisation for Phone Number here] off begin
		String randomStringForPhoneNumber = mockNeat
				.strings()
				.get();
		newEntity.setPhoneNumber(randomStringForPhoneNumber);
		// % protected region % [Add customisation for Phone Number here] end
		// % protected region % [Add customisation for Fax here] off begin
		String randomStringForFax = mockNeat
				.strings()
				.get();
		newEntity.setFax(randomStringForFax);
		// % protected region % [Add customisation for Fax here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringForEmail = mockNeat
				.strings()
				.get();
		newEntity.setEmail(randomStringForEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for Website here] off begin
		String randomStringForWebsite = mockNeat
				.strings()
				.get();
		newEntity.setWebsite(randomStringForWebsite);
		// % protected region % [Add customisation for Website here] end
		// % protected region % [Add customisation for Contact Person here] off begin
		String randomStringForContactPerson = mockNeat
				.strings()
				.get();
		newEntity.setContactPerson(randomStringForContactPerson);
		// % protected region % [Add customisation for Contact Person here] end
		// % protected region % [Add customisation for Contact Person Phone Number here] off begin
		String randomStringForContactPersonPhoneNumber = mockNeat
				.strings()
				.get();
		newEntity.setContactPersonPhoneNumber(randomStringForContactPersonPhoneNumber);
		// % protected region % [Add customisation for Contact Person Phone Number here] end
		// % protected region % [Add customisation for Contact Person Email here] off begin
		String randomStringForContactPersonEmail = mockNeat
				.strings()
				.get();
		newEntity.setContactPersonEmail(randomStringForContactPersonEmail);
		// % protected region % [Add customisation for Contact Person Email here] end

		// % protected region % [Apply any additional logic for hospitalGroupInformationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalGroupInformationWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusion for outgoingOneToMany Hospital Branch Informations here] off begin
			// Outgoing one to many reference
			var hospitalBranchInformationsFactory = new HospitalBranchInformationFactory();
			newEntity.setHospitalBranchInformations(Collections.singletonList(hospitalBranchInformationsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Hospital Branch Informations here] end

		}

		// % protected region % [Apply any additional logic for hospitalGroupInformation with ref here] off begin
		// % protected region % [Apply any additional logic for hospitalGroupInformation with ref here] end

		return newEntity;
	}

	@Override
	public Class<HospitalGroupInformationEntity> getObjectType() {
		return HospitalGroupInformationEntity.class;
	}
}