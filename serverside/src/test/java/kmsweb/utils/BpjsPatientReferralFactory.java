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
import kmsweb.entities.BpjsPatientReferralEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsPatientReferralFactory implements FactoryBean<BpjsPatientReferralEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsPatientReferralEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsPatientReferralEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsPatientReferralEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsPatientReferralWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPatientReferralWithNoRef before the main body here] end

		BpjsPatientReferralEntity newEntity = new BpjsPatientReferralEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for No SEP here] off begin
		String randomStringForNoSEP = mockNeat
				.strings()
				.get();
		newEntity.setNoSEP(randomStringForNoSEP);
		// % protected region % [Add customisation for No SEP here] end
		// % protected region % [Add customisation for Referral No here] off begin
		String randomStringForReferralNo = mockNeat
				.strings()
				.get();
		newEntity.setReferralNo(randomStringForReferralNo);
		// % protected region % [Add customisation for Referral No here] end
		// % protected region % [Add customisation for Referred Type here] off begin
		String randomStringForReferredType = mockNeat
				.strings()
				.get();
		newEntity.setReferredType(randomStringForReferredType);
		// % protected region % [Add customisation for Referred Type here] end
		// % protected region % [Add customisation for Referral Date here] off begin
		newEntity.setReferralDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Referral Date here] end
		// % protected region % [Add customisation for Referal Date Plan here] off begin
		newEntity.setReferalDatePlan(OffsetDateTime.now());
		// % protected region % [Add customisation for Referal Date Plan here] end
		// % protected region % [Add customisation for Treatment Type here] off begin
		String randomStringForTreatmentType = mockNeat
				.strings()
				.get();
		newEntity.setTreatmentType(randomStringForTreatmentType);
		// % protected region % [Add customisation for Treatment Type here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for bpjsPatientReferralWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPatientReferralWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Diagnose here] off begin
			var bpjsDiagnoseFactory = new BpjsDiagnoseFactory();
			newEntity.setBpjsDiagnose(bpjsDiagnoseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Diagnose here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Health Facility here] off begin
			var bpjsHealthFacilityFactory = new BpjsHealthFacilityFactory();
			newEntity.setBpjsHealthFacility(bpjsHealthFacilityFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Health Facility here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Service Mapping here] off begin
			var bpjsServiceMappingFactory = new BpjsServiceMappingFactory();
			newEntity.setBpjsServiceMapping(bpjsServiceMappingFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Service Mapping here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient Payment BPJS here] off begin
			var patientPaymentBPJSFactory = new PatientPaymentBPJSFactory();
			newEntity.setPatientPaymentBPJS(patientPaymentBPJSFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient Payment BPJS here] end

		}

		// % protected region % [Apply any additional logic for bpjsPatientReferral with ref here] off begin
		// % protected region % [Apply any additional logic for bpjsPatientReferral with ref here] end

		return newEntity;
	}

	@Override
	public Class<BpjsPatientReferralEntity> getObjectType() {
		return BpjsPatientReferralEntity.class;
	}
}