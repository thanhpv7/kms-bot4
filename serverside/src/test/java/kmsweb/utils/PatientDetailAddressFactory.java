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
import kmsweb.entities.PatientDetailAddressEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PatientDetailAddressFactory implements FactoryBean<PatientDetailAddressEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PatientDetailAddressEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PatientDetailAddressEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PatientDetailAddressEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for patientDetailAddressWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailAddressWithNoRef before the main body here] end

		PatientDetailAddressEntity newEntity = new PatientDetailAddressEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Country here] off begin
		String randomStringForCountry = mockNeat
				.strings()
				.get();
		newEntity.setCountry(randomStringForCountry);
		// % protected region % [Add customisation for Country here] end
		// % protected region % [Add customisation for State here] off begin
		String randomStringForState = mockNeat
				.strings()
				.get();
		newEntity.setState(randomStringForState);
		// % protected region % [Add customisation for State here] end
		// % protected region % [Add customisation for Regency here] off begin
		String randomStringForRegency = mockNeat
				.strings()
				.get();
		newEntity.setRegency(randomStringForRegency);
		// % protected region % [Add customisation for Regency here] end
		// % protected region % [Add customisation for District here] off begin
		String randomStringForDistrict = mockNeat
				.strings()
				.get();
		newEntity.setDistrict(randomStringForDistrict);
		// % protected region % [Add customisation for District here] end
		// % protected region % [Add customisation for Village here] off begin
		String randomStringForVillage = mockNeat
				.strings()
				.get();
		newEntity.setVillage(randomStringForVillage);
		// % protected region % [Add customisation for Village here] end
		// % protected region % [Add customisation for Post Code here] off begin
		String randomStringForPostCode = mockNeat
				.strings()
				.get();
		newEntity.setPostCode(randomStringForPostCode);
		// % protected region % [Add customisation for Post Code here] end
		// % protected region % [Add customisation for RT here] off begin
		String randomStringForRt = mockNeat
				.strings()
				.get();
		newEntity.setRt(randomStringForRt);
		// % protected region % [Add customisation for RT here] end
		// % protected region % [Add customisation for RW here] off begin
		String randomStringForRw = mockNeat
				.strings()
				.get();
		newEntity.setRw(randomStringForRw);
		// % protected region % [Add customisation for RW here] end

		// % protected region % [Apply any additional logic for patientDetailAddressWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailAddressWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Patient General Information here] off begin
			// Incoming One to One reference
			var patientGeneralInformationFactory = new PatientGeneralInfoFactory();
			newEntity.setPatientGeneralInformation(patientGeneralInformationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Patient General Information here] end
		}

		// % protected region % [Apply any additional logic for patientDetailAddress with ref here] off begin
		// % protected region % [Apply any additional logic for patientDetailAddress with ref here] end

		return newEntity;
	}

	@Override
	public Class<PatientDetailAddressEntity> getObjectType() {
		return PatientDetailAddressEntity.class;
	}
}