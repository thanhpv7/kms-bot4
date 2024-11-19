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
import kmsweb.entities.BpjsSEPInternalDataEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsSEPInternalDataFactory implements FactoryBean<BpjsSEPInternalDataEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsSEPInternalDataEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsSEPInternalDataEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsSEPInternalDataEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsSEPInternalDataWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPInternalDataWithNoRef before the main body here] end

		BpjsSEPInternalDataEntity newEntity = new BpjsSEPInternalDataEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Referred Polyclinic here] off begin
		String randomStringForReferredPolyclinic = mockNeat
				.strings()
				.get();
		newEntity.setReferredPolyclinic(randomStringForReferredPolyclinic);
		// % protected region % [Add customisation for Referred Polyclinic here] end
		// % protected region % [Add customisation for Referring Polyclinic here] off begin
		String randomStringForReferringPolyclinic = mockNeat
				.strings()
				.get();
		newEntity.setReferringPolyclinic(randomStringForReferringPolyclinic);
		// % protected region % [Add customisation for Referring Polyclinic here] end
		// % protected region % [Add customisation for Internal Referral Date here] off begin
		String randomStringForInternalReferralDate = mockNeat
				.strings()
				.get();
		newEntity.setInternalReferralDate(randomStringForInternalReferralDate);
		// % protected region % [Add customisation for Internal Referral Date here] end
		// % protected region % [Add customisation for SEP No here] off begin
		String randomStringForSepNo = mockNeat
				.strings()
				.get();
		newEntity.setSepNo(randomStringForSepNo);
		// % protected region % [Add customisation for SEP No here] end
		// % protected region % [Add customisation for Ref SEP No here] off begin
		String randomStringForRefSEPNo = mockNeat
				.strings()
				.get();
		newEntity.setRefSEPNo(randomStringForRefSEPNo);
		// % protected region % [Add customisation for Ref SEP No here] end
		// % protected region % [Add customisation for SEP Health Facility here] off begin
		String randomStringForSepHealthFacility = mockNeat
				.strings()
				.get();
		newEntity.setSepHealthFacility(randomStringForSepHealthFacility);
		// % protected region % [Add customisation for SEP Health Facility here] end
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringForBpjsCardNo = mockNeat
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringForBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for SEP Date here] off begin
		String randomStringForSepDate = mockNeat
				.strings()
				.get();
		newEntity.setSepDate(randomStringForSepDate);
		// % protected region % [Add customisation for SEP Date here] end
		// % protected region % [Add customisation for Letter No here] off begin
		String randomStringForLetterNo = mockNeat
				.strings()
				.get();
		newEntity.setLetterNo(randomStringForLetterNo);
		// % protected region % [Add customisation for Letter No here] end
		// % protected region % [Add customisation for Is Internal here] off begin
		String randomStringForIsInternal = mockNeat
				.strings()
				.get();
		newEntity.setIsInternal(randomStringForIsInternal);
		// % protected region % [Add customisation for Is Internal here] end
		// % protected region % [Add customisation for Referring Polyclinic Code here] off begin
		String randomStringForReferringPolyclinicCode = mockNeat
				.strings()
				.get();
		newEntity.setReferringPolyclinicCode(randomStringForReferringPolyclinicCode);
		// % protected region % [Add customisation for Referring Polyclinic Code here] end
		// % protected region % [Add customisation for Diagnostic Support here] off begin
		String randomStringForDiagnosticSupport = mockNeat
				.strings()
				.get();
		newEntity.setDiagnosticSupport(randomStringForDiagnosticSupport);
		// % protected region % [Add customisation for Diagnostic Support here] end
		// % protected region % [Add customisation for Referring Diagnose here] off begin
		String randomStringForReferringDiagnose = mockNeat
				.strings()
				.get();
		newEntity.setReferringDiagnose(randomStringForReferringDiagnose);
		// % protected region % [Add customisation for Referring Diagnose here] end
		// % protected region % [Add customisation for Doctor here] off begin
		String randomStringForDoctor = mockNeat
				.strings()
				.get();
		newEntity.setDoctor(randomStringForDoctor);
		// % protected region % [Add customisation for Doctor here] end

		// % protected region % [Apply any additional logic for bpjsSEPInternalDataWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPInternalDataWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<BpjsSEPInternalDataEntity> getObjectType() {
		return BpjsSEPInternalDataEntity.class;
	}
}