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
import kmsweb.entities.BpjsDiagnoseEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsDiagnoseFactory implements FactoryBean<BpjsDiagnoseEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsDiagnoseEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsDiagnoseEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsDiagnoseEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsDiagnoseWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnoseWithNoRef before the main body here] end

		BpjsDiagnoseEntity newEntity = new BpjsDiagnoseEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Ref Code here] off begin
		String randomStringForRefCode = mockNeat
				.strings()
				.get();
		newEntity.setRefCode(randomStringForRefCode);
		// % protected region % [Add customisation for Ref Code here] end
		// % protected region % [Add customisation for Ref Name here] off begin
		String randomStringForRefName = mockNeat
				.strings()
				.get();
		newEntity.setRefName(randomStringForRefName);
		// % protected region % [Add customisation for Ref Name here] end

		// % protected region % [Apply any additional logic for bpjsDiagnoseWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnoseWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for outgoingOneToOne Diagnoses and Procedures] off begin
			// Outgoing one to one reference
			var diagnosesAndProceduresFactory = new DiagnosesAndProceduresFactory();
			newEntity.setDiagnosesAndProcedures(diagnosesAndProceduresFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Diagnoses and Procedures] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Additional Diagnose here] off begin
			// Outgoing one to many reference
			var additionalDiagnoseFactory = new BpjsSpecialReferralFactory();
			newEntity.setAdditionalDiagnose(Collections.singletonList(additionalDiagnoseFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Additional Diagnose here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Claim Submissions here] off begin
			// Outgoing one to many reference
			var bpjsClaimSubmissionsFactory = new BpjsClaimSubmissionFactory();
			newEntity.setBpjsClaimSubmissions(Collections.singletonList(bpjsClaimSubmissionsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Claim Submissions here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Patient Referrals here] off begin
			// Outgoing one to many reference
			var bpjsPatientReferralsFactory = new BpjsPatientReferralFactory();
			newEntity.setBpjsPatientReferrals(Collections.singletonList(bpjsPatientReferralsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Patient Referrals here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Primary Diagnose here] off begin
			// Outgoing one to many reference
			var primaryDiagnoseFactory = new BpjsSpecialReferralFactory();
			newEntity.setPrimaryDiagnose(Collections.singletonList(primaryDiagnoseFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Primary Diagnose here] end

		}

		// % protected region % [Apply any additional logic for bpjsDiagnose with ref here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnose with ref here] end

		return newEntity;
	}

	@Override
	public Class<BpjsDiagnoseEntity> getObjectType() {
		return BpjsDiagnoseEntity.class;
	}
}