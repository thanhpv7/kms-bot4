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
import kmsweb.entities.InformedConsentEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class InformedConsentFactory implements FactoryBean<InformedConsentEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public InformedConsentEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public InformedConsentEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public InformedConsentEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for informedConsentWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for informedConsentWithNoRef before the main body here] end

		InformedConsentEntity newEntity = new InformedConsentEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Patient Family Guardian Name here] off begin
		String randomStringForPatientFamilyGuardianName = mockNeat
				.strings()
				.get();
		newEntity.setPatientFamilyGuardianName(randomStringForPatientFamilyGuardianName);
		// % protected region % [Add customisation for Patient Family Guardian Name here] end
		// % protected region % [Add customisation for Patient Family Guardian Relationship here] off begin
		String randomStringForPatientFamilyGuardianRelationship = mockNeat
				.strings()
				.get();
		newEntity.setPatientFamilyGuardianRelationship(randomStringForPatientFamilyGuardianRelationship);
		// % protected region % [Add customisation for Patient Family Guardian Relationship here] end
		// % protected region % [Add customisation for Procedure To Be Performed here] off begin
		String randomStringForProcedureToBePerformed = mockNeat
				.strings()
				.get();
		newEntity.setProcedureToBePerformed(randomStringForProcedureToBePerformed);
		// % protected region % [Add customisation for Procedure To Be Performed here] end
		// % protected region % [Add customisation for Consequence Of Procedure here] off begin
		String randomStringForConsequenceOfProcedure = mockNeat
				.strings()
				.get();
		newEntity.setConsequenceOfProcedure(randomStringForConsequenceOfProcedure);
		// % protected region % [Add customisation for Consequence Of Procedure here] end
		// % protected region % [Add customisation for Consent On Procedure here] off begin
		String randomStringForConsentOnProcedure = mockNeat
				.strings()
				.get();
		newEntity.setConsentOnProcedure(randomStringForConsentOnProcedure);
		// % protected region % [Add customisation for Consent On Procedure here] end
		// % protected region % [Add customisation for Consent Date Time here] off begin
		newEntity.setConsentDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Consent Date Time here] end
		// % protected region % [Add customisation for Informing Staff Signature here] off begin
		String randomStringForInformingStaffSignature = mockNeat
				.strings()
				.get();
		newEntity.setInformingStaffSignature(randomStringForInformingStaffSignature);
		// % protected region % [Add customisation for Informing Staff Signature here] end
		// % protected region % [Add customisation for Consenting Party Signature here] off begin
		String randomStringForConsentingPartySignature = mockNeat
				.strings()
				.get();
		newEntity.setConsentingPartySignature(randomStringForConsentingPartySignature);
		// % protected region % [Add customisation for Consenting Party Signature here] end
		// % protected region % [Add customisation for Consenting Party Type here] off begin
		String randomStringForConsentingPartyType = mockNeat
				.strings()
				.get();
		newEntity.setConsentingPartyType(randomStringForConsentingPartyType);
		// % protected region % [Add customisation for Consenting Party Type here] end
		// % protected region % [Add customisation for Consenting Party Name here] off begin
		String randomStringForConsentingPartyName = mockNeat
				.strings()
				.get();
		newEntity.setConsentingPartyName(randomStringForConsentingPartyName);
		// % protected region % [Add customisation for Consenting Party Name here] end
		// % protected region % [Add customisation for Witness Signature 1 here] off begin
		String randomStringForWitnessSignature1 = mockNeat
				.strings()
				.get();
		newEntity.setWitnessSignature1(randomStringForWitnessSignature1);
		// % protected region % [Add customisation for Witness Signature 1 here] end
		// % protected region % [Add customisation for Witness Name 1 here] off begin
		String randomStringForWitnessName1 = mockNeat
				.strings()
				.get();
		newEntity.setWitnessName1(randomStringForWitnessName1);
		// % protected region % [Add customisation for Witness Name 1 here] end
		// % protected region % [Add customisation for Witness Signature 2 here] off begin
		String randomStringForWitnessSignature2 = mockNeat
				.strings()
				.get();
		newEntity.setWitnessSignature2(randomStringForWitnessSignature2);
		// % protected region % [Add customisation for Witness Signature 2 here] end
		// % protected region % [Add customisation for Witness Name 2 here] off begin
		String randomStringForWitnessName2 = mockNeat
				.strings()
				.get();
		newEntity.setWitnessName2(randomStringForWitnessName2);
		// % protected region % [Add customisation for Witness Name 2 here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for informedConsentWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for informedConsentWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyAccompanying Staff here] off begin
			var accompanyingStaffFactory = new StaffFactory();
			newEntity.setAccompanyingStaff(accompanyingStaffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyAccompanying Staff here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient General Info here] off begin
			var patientGeneralInfoFactory = new PatientGeneralInfoFactory();
			newEntity.setPatientGeneralInfo(patientGeneralInfoFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient General Info here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyRegistration here] off begin
			var registrationFactory = new RegistrationFactory();
			newEntity.setRegistration(registrationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyRegistration here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyInforming Staff here] off begin
			var informingStaffFactory = new StaffFactory();
			newEntity.setInformingStaff(informingStaffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyInforming Staff here] end

		}

		// % protected region % [Apply any additional logic for informedConsent with ref here] off begin
		// % protected region % [Apply any additional logic for informedConsent with ref here] end

		return newEntity;
	}

	@Override
	public Class<InformedConsentEntity> getObjectType() {
		return InformedConsentEntity.class;
	}
}