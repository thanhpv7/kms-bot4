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
import kmsweb.entities.BpjsClaimSubmissionEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsClaimSubmissionFactory implements FactoryBean<BpjsClaimSubmissionEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsClaimSubmissionEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsClaimSubmissionEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsClaimSubmissionEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsClaimSubmissionWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimSubmissionWithNoRef before the main body here] end

		BpjsClaimSubmissionEntity newEntity = new BpjsClaimSubmissionEntity();
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
		// % protected region % [Add customisation for Admission Date here] off begin
		newEntity.setAdmissionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Admission Date here] end
		// % protected region % [Add customisation for Dismissal Date here] off begin
		newEntity.setDismissalDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Dismissal Date here] end
		// % protected region % [Add customisation for Insurance Provider here] off begin
		String randomStringForInsuranceProvider = mockNeat
				.strings()
				.get();
		newEntity.setInsuranceProvider(randomStringForInsuranceProvider);
		// % protected region % [Add customisation for Insurance Provider here] end
		// % protected region % [Add customisation for Treatment Type here] off begin
		String randomStringForTreatmentType = mockNeat
				.strings()
				.get();
		newEntity.setTreatmentType(randomStringForTreatmentType);
		// % protected region % [Add customisation for Treatment Type here] end
		// % protected region % [Add customisation for Follow Up Plan here] off begin
		String randomStringForFollowUpPlan = mockNeat
				.strings()
				.get();
		newEntity.setFollowUpPlan(randomStringForFollowUpPlan);
		// % protected region % [Add customisation for Follow Up Plan here] end
		// % protected region % [Add customisation for Control Date here] off begin
		newEntity.setControlDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Control Date here] end
		// % protected region % [Add customisation for Additional Diagnosis here] off begin
		String randomStringForAdditionalDiagnosis = mockNeat
				.strings()
				.get();
		newEntity.setAdditionalDiagnosis(randomStringForAdditionalDiagnosis);
		// % protected region % [Add customisation for Additional Diagnosis here] end
		// % protected region % [Add customisation for Additional Procedure here] off begin
		String randomStringForAdditionalProcedure = mockNeat
				.strings()
				.get();
		newEntity.setAdditionalProcedure(randomStringForAdditionalProcedure);
		// % protected region % [Add customisation for Additional Procedure here] end
		// % protected region % [Add customisation for Kelas Rawat here] off begin
		newEntity.setKelasRawat(KelasRawatEnum.TANPA_KELAS);
		// % protected region % [Add customisation for Kelas Rawat here] end

		// % protected region % [Apply any additional logic for bpjsClaimSubmissionWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimSubmissionWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Diagnose here] off begin
			var bpjsDiagnoseFactory = new BpjsDiagnoseFactory();
			newEntity.setBpjsDiagnose(bpjsDiagnoseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Diagnose here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Doctor Mapping here] off begin
			var bpjsDoctorMappingFactory = new BpjsDoctorMappingFactory();
			newEntity.setBpjsDoctorMapping(bpjsDoctorMappingFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Doctor Mapping here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Health Facility here] off begin
			var bpjsHealthFacilityFactory = new BpjsHealthFacilityFactory();
			newEntity.setBpjsHealthFacility(bpjsHealthFacilityFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Health Facility here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Procedure here] off begin
			var bpjsProcedureFactory = new BpjsProcedureFactory();
			newEntity.setBpjsProcedure(bpjsProcedureFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Procedure here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Service Mapping here] off begin
			var bpjsServiceMappingFactory = new BpjsServiceMappingFactory();
			newEntity.setBpjsServiceMapping(bpjsServiceMappingFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Service Mapping here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient General Info here] off begin
			var patientGeneralInfoFactory = new PatientGeneralInfoFactory();
			newEntity.setPatientGeneralInfo(patientGeneralInfoFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient General Info here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient Payment BPJS here] off begin
			var patientPaymentBPJSFactory = new PatientPaymentBPJSFactory();
			newEntity.setPatientPaymentBPJS(patientPaymentBPJSFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient Payment BPJS here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Dismissal Conditions here] off begin
			// Outgoing one to many reference
			var bpjsDismissalConditionsFactory = new BpjsDismissalConditionFactory();
			newEntity.setBpjsDismissalConditions(Collections.singletonList(bpjsDismissalConditionsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Dismissal Conditions here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Dismissal Mappings here] off begin
			// Outgoing one to many reference
			var bpjsDismissalMappingsFactory = new BpjsDismissalMappingFactory();
			newEntity.setBpjsDismissalMappings(Collections.singletonList(bpjsDismissalMappingsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Dismissal Mappings here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Treatment Rooms here] off begin
			// Outgoing one to many reference
			var bpjsTreatmentRoomsFactory = new BpjsTreatmentRoomFactory();
			newEntity.setBpjsTreatmentRooms(Collections.singletonList(bpjsTreatmentRoomsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Treatment Rooms here] end

		}

		// % protected region % [Apply any additional logic for bpjsClaimSubmission with ref here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimSubmission with ref here] end

		return newEntity;
	}

	@Override
	public Class<BpjsClaimSubmissionEntity> getObjectType() {
		return BpjsClaimSubmissionEntity.class;
	}
}