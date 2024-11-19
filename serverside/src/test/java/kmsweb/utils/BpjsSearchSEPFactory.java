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
import kmsweb.entities.BpjsSearchSEPEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsSearchSEPFactory implements FactoryBean<BpjsSearchSEPEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsSearchSEPEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsSearchSEPEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsSearchSEPEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsSearchSEPWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchSEPWithNoRef before the main body here] end

		BpjsSearchSEPEntity newEntity = new BpjsSearchSEPEntity();
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
		// % protected region % [Add customisation for SEP Date here] off begin
		String randomStringForSepDate = mockNeat
				.strings()
				.get();
		newEntity.setSepDate(randomStringForSepDate);
		// % protected region % [Add customisation for SEP Date here] end
		// % protected region % [Add customisation for Treatment Type here] off begin
		String randomStringForTreatmentType = mockNeat
				.strings()
				.get();
		newEntity.setTreatmentType(randomStringForTreatmentType);
		// % protected region % [Add customisation for Treatment Type here] end
		// % protected region % [Add customisation for Polyclinic here] off begin
		String randomStringForPolyclinic = mockNeat
				.strings()
				.get();
		newEntity.setPolyclinic(randomStringForPolyclinic);
		// % protected region % [Add customisation for Polyclinic here] end
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringForBpjsCardNo = mockNeat
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringForBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for Name here] off begin
		String randomStringForName = mockNeat
				.strings()
				.get();
		newEntity.setName(randomStringForName);
		// % protected region % [Add customisation for Name here] end
		// % protected region % [Add customisation for Gender here] off begin
		String randomStringForGender = mockNeat
				.strings()
				.get();
		newEntity.setGender(randomStringForGender);
		// % protected region % [Add customisation for Gender here] end
		// % protected region % [Add customisation for Date of Birth here] off begin
		String randomStringForDateOfBirth = mockNeat
				.strings()
				.get();
		newEntity.setDateOfBirth(randomStringForDateOfBirth);
		// % protected region % [Add customisation for Date of Birth here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringForTreatmentClass = mockNeat
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringForTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Provider here] off begin
		String randomStringForProvider = mockNeat
				.strings()
				.get();
		newEntity.setProvider(randomStringForProvider);
		// % protected region % [Add customisation for Provider here] end
		// % protected region % [Add customisation for Referral Provider here] off begin
		String randomStringForReferralProvider = mockNeat
				.strings()
				.get();
		newEntity.setReferralProvider(randomStringForReferralProvider);
		// % protected region % [Add customisation for Referral Provider here] end
		// % protected region % [Add customisation for Referral Source here] off begin
		String randomStringForReferralSource = mockNeat
				.strings()
				.get();
		newEntity.setReferralSource(randomStringForReferralSource);
		// % protected region % [Add customisation for Referral Source here] end
		// % protected region % [Add customisation for Referral No here] off begin
		String randomStringForReferralNo = mockNeat
				.strings()
				.get();
		newEntity.setReferralNo(randomStringForReferralNo);
		// % protected region % [Add customisation for Referral No here] end
		// % protected region % [Add customisation for Referral Date here] off begin
		String randomStringForReferralDate = mockNeat
				.strings()
				.get();
		newEntity.setReferralDate(randomStringForReferralDate);
		// % protected region % [Add customisation for Referral Date here] end
		// % protected region % [Add customisation for Diagnose here] off begin
		String randomStringForDiagnose = mockNeat
				.strings()
				.get();
		newEntity.setDiagnose(randomStringForDiagnose);
		// % protected region % [Add customisation for Diagnose here] end

		// % protected region % [Apply any additional logic for bpjsSearchSEPWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchSEPWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<BpjsSearchSEPEntity> getObjectType() {
		return BpjsSearchSEPEntity.class;
	}
}