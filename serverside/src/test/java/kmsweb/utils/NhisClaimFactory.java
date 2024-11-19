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
import kmsweb.entities.NhisClaimEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class NhisClaimFactory implements FactoryBean<NhisClaimEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public NhisClaimEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public NhisClaimEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public NhisClaimEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for nhisClaimWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimWithNoRef before the main body here] end

		NhisClaimEntity newEntity = new NhisClaimEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for System Claim ID here] off begin
		String randomStringForSystemClaimID = mockNeat
				.strings()
				.get();
		newEntity.setSystemClaimID(randomStringForSystemClaimID);
		// % protected region % [Add customisation for System Claim ID here] end
		// % protected region % [Add customisation for Ref Invoice No here] off begin
		String randomStringForRefInvoiceNo = mockNeat
				.strings()
				.get();
		newEntity.setRefInvoiceNo(randomStringForRefInvoiceNo);
		// % protected region % [Add customisation for Ref Invoice No here] end
		// % protected region % [Add customisation for Form No here] off begin
		String randomStringForFormNo = mockNeat
				.strings()
				.get();
		newEntity.setFormNo(randomStringForFormNo);
		// % protected region % [Add customisation for Form No here] end
		// % protected region % [Add customisation for Claim ID here] off begin
		String randomStringForClaimID = mockNeat
				.strings()
				.get();
		newEntity.setClaimID(randomStringForClaimID);
		// % protected region % [Add customisation for Claim ID here] end
		// % protected region % [Add customisation for Claim Check Code here] off begin
		String randomStringForClaimCheckCode = mockNeat
				.strings()
				.get();
		newEntity.setClaimCheckCode(randomStringForClaimCheckCode);
		// % protected region % [Add customisation for Claim Check Code here] end
		// % protected region % [Add customisation for Batch Number here] off begin
		String randomStringForBatchNumber = mockNeat
				.strings()
				.get();
		newEntity.setBatchNumber(randomStringForBatchNumber);
		// % protected region % [Add customisation for Batch Number here] end
		// % protected region % [Add customisation for Surname here] off begin
		String randomStringForSurname = mockNeat
				.strings()
				.get();
		newEntity.setSurname(randomStringForSurname);
		// % protected region % [Add customisation for Surname here] end
		// % protected region % [Add customisation for Other Names here] off begin
		String randomStringForOtherNames = mockNeat
				.strings()
				.get();
		newEntity.setOtherNames(randomStringForOtherNames);
		// % protected region % [Add customisation for Other Names here] end
		// % protected region % [Add customisation for Gender here] off begin
		String randomStringForGender = mockNeat
				.strings()
				.get();
		newEntity.setGender(randomStringForGender);
		// % protected region % [Add customisation for Gender here] end
		// % protected region % [Add customisation for Date Of Birth here] off begin
		newEntity.setDateOfBirth(OffsetDateTime.now());
		// % protected region % [Add customisation for Date Of Birth here] end
		// % protected region % [Add customisation for Member No here] off begin
		String randomStringForMemberNo = mockNeat
				.strings()
				.get();
		newEntity.setMemberNo(randomStringForMemberNo);
		// % protected region % [Add customisation for Member No here] end
		// % protected region % [Add customisation for Hospital Record No here] off begin
		String randomStringForHospitalRecordNo = mockNeat
				.strings()
				.get();
		newEntity.setHospitalRecordNo(randomStringForHospitalRecordNo);
		// % protected region % [Add customisation for Hospital Record No here] end
		// % protected region % [Add customisation for Card Serial Number here] off begin
		String randomStringForCardSerialNumber = mockNeat
				.strings()
				.get();
		newEntity.setCardSerialNumber(randomStringForCardSerialNumber);
		// % protected region % [Add customisation for Card Serial Number here] end
		// % protected region % [Add customisation for Dependant here] off begin
		newEntity.setDependant(mockNeat.bools().get());
		// % protected region % [Add customisation for Dependant here] end
		// % protected region % [Add customisation for Unbundled here] off begin
		newEntity.setUnbundled(mockNeat.bools().get());
		// % protected region % [Add customisation for Unbundled here] end
		// % protected region % [Add customisation for Includes Pharmacy here] off begin
		newEntity.setIncludesPharmacy(mockNeat.bools().get());
		// % protected region % [Add customisation for Includes Pharmacy here] end
		// % protected region % [Add customisation for Type Of Attendance here] off begin
		String randomStringForTypeOfAttendance = mockNeat
				.strings()
				.get();
		newEntity.setTypeOfAttendance(randomStringForTypeOfAttendance);
		// % protected region % [Add customisation for Type Of Attendance here] end
		// % protected region % [Add customisation for First Visit Admission here] off begin
		newEntity.setFirstVisitAdmission(OffsetDateTime.now());
		// % protected region % [Add customisation for First Visit Admission here] end
		// % protected region % [Add customisation for Second Visit Discharge here] off begin
		newEntity.setSecondVisitDischarge(OffsetDateTime.now());
		// % protected region % [Add customisation for Second Visit Discharge here] end
		// % protected region % [Add customisation for Third Visit here] off begin
		newEntity.setThirdVisit(OffsetDateTime.now());
		// % protected region % [Add customisation for Third Visit here] end
		// % protected region % [Add customisation for Fourth Visit here] off begin
		newEntity.setFourthVisit(OffsetDateTime.now());
		// % protected region % [Add customisation for Fourth Visit here] end
		// % protected region % [Add customisation for Physician Name here] off begin
		String randomStringForPhysicianName = mockNeat
				.strings()
				.get();
		newEntity.setPhysicianName(randomStringForPhysicianName);
		// % protected region % [Add customisation for Physician Name here] end
		// % protected region % [Add customisation for Physician Code here] off begin
		String randomStringForPhysicianCode = mockNeat
				.strings()
				.get();
		newEntity.setPhysicianCode(randomStringForPhysicianCode);
		// % protected region % [Add customisation for Physician Code here] end

		// % protected region % [Apply any additional logic for nhisClaimWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<NhisClaimEntity> getObjectType() {
		return NhisClaimEntity.class;
	}
}