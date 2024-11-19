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
import kmsweb.entities.PatientPaymentBPJSEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PatientPaymentBPJSFactory implements FactoryBean<PatientPaymentBPJSEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PatientPaymentBPJSEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PatientPaymentBPJSEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PatientPaymentBPJSEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for patientPaymentBPJSWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentBPJSWithNoRef before the main body here] end

		PatientPaymentBPJSEntity newEntity = new PatientPaymentBPJSEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringForBpjsCardNo = mockNeat
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringForBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for patientPaymentBPJSWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentBPJSWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Patient General Info here] off begin
			// Incoming One to One reference
			var patientGeneralInfoFactory = new PatientGeneralInfoFactory();
			newEntity.setPatientGeneralInfo(patientGeneralInfoFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Patient General Info here] end
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Accident Masters here] off begin
			// Outgoing one to many reference
			var bpjsAccidentMastersFactory = new BpjsAccidentMasterFactory();
			newEntity.setBpjsAccidentMasters(Collections.singletonList(bpjsAccidentMastersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Accident Masters here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Claim Submissions here] off begin
			// Outgoing one to many reference
			var bpjsClaimSubmissionsFactory = new BpjsClaimSubmissionFactory();
			newEntity.setBpjsClaimSubmissions(Collections.singletonList(bpjsClaimSubmissionsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Claim Submissions here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Hospitalization Plans here] off begin
			// Outgoing one to many reference
			var bpjsHospitalizationPlansFactory = new BpjsHospitalizationPlanFactory();
			newEntity.setBpjsHospitalizationPlans(Collections.singletonList(bpjsHospitalizationPlansFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Hospitalization Plans here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Jasa Raharjas here] off begin
			// Outgoing one to many reference
			var bpjsJasaRaharjasFactory = new BpjsJasaRaharjaFactory();
			newEntity.setBpjsJasaRaharjas(Collections.singletonList(bpjsJasaRaharjasFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Jasa Raharjas here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Patient Referrals here] off begin
			// Outgoing one to many reference
			var bpjsPatientReferralsFactory = new BpjsPatientReferralFactory();
			newEntity.setBpjsPatientReferrals(Collections.singletonList(bpjsPatientReferralsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Patient Referrals here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS SEP Submissions here] off begin
			// Outgoing one to many reference
			var bpjsSEPSubmissionsFactory = new BpjsSEPSubmissionFactory();
			newEntity.setBpjsSEPSubmissions(Collections.singletonList(bpjsSEPSubmissionsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS SEP Submissions here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS SEPs here] off begin
			// Outgoing one to many reference
			var bpjsSEPsFactory = new BpjsSEPFactory();
			newEntity.setBpjsSEPs(Collections.singletonList(bpjsSEPsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS SEPs here] end

		}

		// % protected region % [Apply any additional logic for patientPaymentBPJS with ref here] off begin
		// % protected region % [Apply any additional logic for patientPaymentBPJS with ref here] end

		return newEntity;
	}

	@Override
	public Class<PatientPaymentBPJSEntity> getObjectType() {
		return PatientPaymentBPJSEntity.class;
	}
}