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
import kmsweb.entities.BpjsSEPINACBGIntegrationEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsSEPINACBGIntegrationFactory implements FactoryBean<BpjsSEPINACBGIntegrationEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsSEPINACBGIntegrationEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsSEPINACBGIntegrationEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsSEPINACBGIntegrationEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationWithNoRef before the main body here] end

		BpjsSEPINACBGIntegrationEntity newEntity = new BpjsSEPINACBGIntegrationEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for SEP No here] off begin
		String randomStringForSepNo = mockNeat
				.strings()
				.get();
		newEntity.setSepNo(randomStringForSepNo);
		// % protected region % [Add customisation for SEP No here] end
		// % protected region % [Add customisation for Patient ID here] off begin
		String randomStringForPatientID = mockNeat
				.strings()
				.get();
		newEntity.setPatientID(randomStringForPatientID);
		// % protected region % [Add customisation for Patient ID here] end
		// % protected region % [Add customisation for Patient Name here] off begin
		String randomStringForPatientName = mockNeat
				.strings()
				.get();
		newEntity.setPatientName(randomStringForPatientName);
		// % protected region % [Add customisation for Patient Name here] end
		// % protected region % [Add customisation for Gender here] off begin
		String randomStringForGender = mockNeat
				.strings()
				.get();
		newEntity.setGender(randomStringForGender);
		// % protected region % [Add customisation for Gender here] end
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringForBpjsCardNo = mockNeat
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringForBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringForTreatmentClass = mockNeat
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringForTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Referral No here] off begin
		String randomStringForReferralNo = mockNeat
				.strings()
				.get();
		newEntity.setReferralNo(randomStringForReferralNo);
		// % protected region % [Add customisation for Referral No here] end
		// % protected region % [Add customisation for Date of Birth here] off begin
		String randomStringForDateOfBirth = mockNeat
				.strings()
				.get();
		newEntity.setDateOfBirth(randomStringForDateOfBirth);
		// % protected region % [Add customisation for Date of Birth here] end
		// % protected region % [Add customisation for Visit Date here] off begin
		String randomStringForVisitDate = mockNeat
				.strings()
				.get();
		newEntity.setVisitDate(randomStringForVisitDate);
		// % protected region % [Add customisation for Visit Date here] end
		// % protected region % [Add customisation for Health Facility Level here] off begin
		String randomStringForHealthFacilityLevel = mockNeat
				.strings()
				.get();
		newEntity.setHealthFacilityLevel(randomStringForHealthFacilityLevel);
		// % protected region % [Add customisation for Health Facility Level here] end

		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<BpjsSEPINACBGIntegrationEntity> getObjectType() {
		return BpjsSEPINACBGIntegrationEntity.class;
	}
}