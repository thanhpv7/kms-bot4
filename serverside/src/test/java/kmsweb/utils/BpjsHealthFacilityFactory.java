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
import kmsweb.entities.BpjsHealthFacilityEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsHealthFacilityFactory implements FactoryBean<BpjsHealthFacilityEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsHealthFacilityEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsHealthFacilityEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsHealthFacilityEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsHealthFacilityWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHealthFacilityWithNoRef before the main body here] end

		BpjsHealthFacilityEntity newEntity = new BpjsHealthFacilityEntity();
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

		// % protected region % [Apply any additional logic for bpjsHealthFacilityWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHealthFacilityWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Claim Submissions here] off begin
			// Outgoing one to many reference
			var bpjsClaimSubmissionsFactory = new BpjsClaimSubmissionFactory();
			newEntity.setBpjsClaimSubmissions(Collections.singletonList(bpjsClaimSubmissionsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Claim Submissions here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Facility Lists here] off begin
			// Outgoing one to many reference
			var bpjsFacilityListsFactory = new BpjsFacilityListFactory();
			newEntity.setBpjsFacilityLists(Collections.singletonList(bpjsFacilityListsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Facility Lists here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Patient Referrals here] off begin
			// Outgoing one to many reference
			var bpjsPatientReferralsFactory = new BpjsPatientReferralFactory();
			newEntity.setBpjsPatientReferrals(Collections.singletonList(bpjsPatientReferralsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Patient Referrals here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Referral Specialists here] off begin
			// Outgoing one to many reference
			var bpjsReferralSpecialistsFactory = new BpjsReferralSpecialistFactory();
			newEntity.setBpjsReferralSpecialists(Collections.singletonList(bpjsReferralSpecialistsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Referral Specialists here] end

		}

		// % protected region % [Apply any additional logic for bpjsHealthFacility with ref here] off begin
		// % protected region % [Apply any additional logic for bpjsHealthFacility with ref here] end

		return newEntity;
	}

	@Override
	public Class<BpjsHealthFacilityEntity> getObjectType() {
		return BpjsHealthFacilityEntity.class;
	}
}