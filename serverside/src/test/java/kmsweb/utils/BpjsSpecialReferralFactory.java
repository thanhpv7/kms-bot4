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
import kmsweb.entities.BpjsSpecialReferralEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsSpecialReferralFactory implements FactoryBean<BpjsSpecialReferralEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsSpecialReferralEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsSpecialReferralEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsSpecialReferralEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsSpecialReferralWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSpecialReferralWithNoRef before the main body here] end

		BpjsSpecialReferralEntity newEntity = new BpjsSpecialReferralEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Referral ID here] off begin
		String randomStringForReferralID = mockNeat
				.strings()
				.get();
		newEntity.setReferralID(randomStringForReferralID);
		// % protected region % [Add customisation for Referral ID here] end
		// % protected region % [Add customisation for Referral No here] off begin
		String randomStringForReferralNo = mockNeat
				.strings()
				.get();
		newEntity.setReferralNo(randomStringForReferralNo);
		// % protected region % [Add customisation for Referral No here] end
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
		// % protected region % [Add customisation for PPK Diagnose here] off begin
		String randomStringForPpkDiagnose = mockNeat
				.strings()
				.get();
		newEntity.setPpkDiagnose(randomStringForPpkDiagnose);
		// % protected region % [Add customisation for PPK Diagnose here] end
		// % protected region % [Add customisation for Referral Start Date here] off begin
		String randomStringForReferralStartDate = mockNeat
				.strings()
				.get();
		newEntity.setReferralStartDate(randomStringForReferralStartDate);
		// % protected region % [Add customisation for Referral Start Date here] end
		// % protected region % [Add customisation for Referral End Date here] off begin
		String randomStringForReferralEndDate = mockNeat
				.strings()
				.get();
		newEntity.setReferralEndDate(randomStringForReferralEndDate);
		// % protected region % [Add customisation for Referral End Date here] end

		// % protected region % [Apply any additional logic for bpjsSpecialReferralWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSpecialReferralWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyAdditional Diagnose here] off begin
			var additionalDiagnoseFactory = new BpjsDiagnoseFactory();
			newEntity.setAdditionalDiagnose(additionalDiagnoseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyAdditional Diagnose here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyAdditional Procedure here] off begin
			var additionalProcedureFactory = new BpjsProcedureFactory();
			newEntity.setAdditionalProcedure(additionalProcedureFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyAdditional Procedure here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPrimary Diagnose here] off begin
			var primaryDiagnoseFactory = new BpjsDiagnoseFactory();
			newEntity.setPrimaryDiagnose(primaryDiagnoseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPrimary Diagnose here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPrimary Procedure here] off begin
			var primaryProcedureFactory = new BpjsProcedureFactory();
			newEntity.setPrimaryProcedure(primaryProcedureFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPrimary Procedure here] end

		}

		// % protected region % [Apply any additional logic for bpjsSpecialReferral with ref here] off begin
		// % protected region % [Apply any additional logic for bpjsSpecialReferral with ref here] end

		return newEntity;
	}

	@Override
	public Class<BpjsSpecialReferralEntity> getObjectType() {
		return BpjsSpecialReferralEntity.class;
	}
}