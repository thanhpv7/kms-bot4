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
import kmsweb.entities.PatientConsentEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PatientConsentFactory implements FactoryBean<PatientConsentEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PatientConsentEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PatientConsentEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PatientConsentEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for patientConsentWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientConsentWithNoRef before the main body here] end

		PatientConsentEntity newEntity = new PatientConsentEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Consent Date Time here] off begin
		newEntity.setConsentDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Consent Date Time here] end
		// % protected region % [Add customisation for Consent On Payment Terms here] off begin
		String randomStringForConsentOnPaymentTerms = mockNeat
				.strings()
				.get();
		newEntity.setConsentOnPaymentTerms(randomStringForConsentOnPaymentTerms);
		// % protected region % [Add customisation for Consent On Payment Terms here] end
		// % protected region % [Add customisation for Consent On Rights And Obligations here] off begin
		String randomStringForConsentOnRightsAndObligations = mockNeat
				.strings()
				.get();
		newEntity.setConsentOnRightsAndObligations(randomStringForConsentOnRightsAndObligations);
		// % protected region % [Add customisation for Consent On Rights And Obligations here] end
		// % protected region % [Add customisation for Consent On Hospital Regulations here] off begin
		String randomStringForConsentOnHospitalRegulations = mockNeat
				.strings()
				.get();
		newEntity.setConsentOnHospitalRegulations(randomStringForConsentOnHospitalRegulations);
		// % protected region % [Add customisation for Consent On Hospital Regulations here] end
		// % protected region % [Add customisation for Need Interpreter here] off begin
		String randomStringForNeedInterpreter = mockNeat
				.strings()
				.get();
		newEntity.setNeedInterpreter(randomStringForNeedInterpreter);
		// % protected region % [Add customisation for Need Interpreter here] end
		// % protected region % [Add customisation for Need Religious Counselor here] off begin
		String randomStringForNeedReligiousCounselor = mockNeat
				.strings()
				.get();
		newEntity.setNeedReligiousCounselor(randomStringForNeedReligiousCounselor);
		// % protected region % [Add customisation for Need Religious Counselor here] end
		// % protected region % [Add customisation for Dgs Results Released To Insurer here] off begin
		String randomStringForDgsResultsReleasedToInsurer = mockNeat
				.strings()
				.get();
		newEntity.setDgsResultsReleasedToInsurer(randomStringForDgsResultsReleasedToInsurer);
		// % protected region % [Add customisation for Dgs Results Released To Insurer here] end
		// % protected region % [Add customisation for Dgs Results Released To Students here] off begin
		String randomStringForDgsResultsReleasedToStudents = mockNeat
				.strings()
				.get();
		newEntity.setDgsResultsReleasedToStudents(randomStringForDgsResultsReleasedToStudents);
		// % protected region % [Add customisation for Dgs Results Released To Students here] end
		// % protected region % [Add customisation for Record Released To Family Member here] off begin
		String randomStringForRecordReleasedToFamilyMember = mockNeat
				.strings()
				.get();
		newEntity.setRecordReleasedToFamilyMember(randomStringForRecordReleasedToFamilyMember);
		// % protected region % [Add customisation for Record Released To Family Member here] end
		// % protected region % [Add customisation for Record Released To Certain Health Facilities here] off begin
		String randomStringForRecordReleasedToCertainHealthFacilities = mockNeat
				.strings()
				.get();
		newEntity.setRecordReleasedToCertainHealthFacilities(randomStringForRecordReleasedToCertainHealthFacilities);
		// % protected region % [Add customisation for Record Released To Certain Health Facilities here] end
		// % protected region % [Add customisation for Staff Signature here] off begin
		String randomStringForStaffSignature = mockNeat
				.strings()
				.get();
		newEntity.setStaffSignature(randomStringForStaffSignature);
		// % protected region % [Add customisation for Staff Signature here] end
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
		// % protected region % [Add customisation for Read And Sign Satusehat here] off begin
		newEntity.setReadAndSignSatusehat(mockNeat.bools().get());
		// % protected region % [Add customisation for Read And Sign Satusehat here] end
		// % protected region % [Add customisation for Information Released To Satusehat here] off begin
		String randomStringForInformationReleasedToSatusehat = mockNeat
				.strings()
				.get();
		newEntity.setInformationReleasedToSatusehat(randomStringForInformationReleasedToSatusehat);
		// % protected region % [Add customisation for Information Released To Satusehat here] end
		// % protected region % [Add customisation for Emr Released To Satusehat here] off begin
		String randomStringForEmrReleasedToSatusehat = mockNeat
				.strings()
				.get();
		newEntity.setEmrReleasedToSatusehat(randomStringForEmrReleasedToSatusehat);
		// % protected region % [Add customisation for Emr Released To Satusehat here] end

		// % protected region % [Apply any additional logic for patientConsentWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientConsentWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient General Info here] off begin
			var patientGeneralInfoFactory = new PatientGeneralInfoFactory();
			newEntity.setPatientGeneralInfo(patientGeneralInfoFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient General Info here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] off begin
			var staffFactory = new StaffFactory();
			newEntity.setStaff(staffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] end

		}

		// % protected region % [Apply any additional logic for patientConsent with ref here] off begin
		// % protected region % [Apply any additional logic for patientConsent with ref here] end

		return newEntity;
	}

	@Override
	public Class<PatientConsentEntity> getObjectType() {
		return PatientConsentEntity.class;
	}
}