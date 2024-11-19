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
import kmsweb.entities.PatientEmploymentDetailEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PatientEmploymentDetailFactory implements FactoryBean<PatientEmploymentDetailEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PatientEmploymentDetailEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PatientEmploymentDetailEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PatientEmploymentDetailEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for patientEmploymentDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmploymentDetailWithNoRef before the main body here] end

		PatientEmploymentDetailEntity newEntity = new PatientEmploymentDetailEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Employee ID here] off begin
		String randomStringForEmployeeID = mockNeat
				.strings()
				.get();
		newEntity.setEmployeeID(randomStringForEmployeeID);
		// % protected region % [Add customisation for Employee ID here] end
		// % protected region % [Add customisation for Universal ID here] off begin
		String randomStringForUniversalID = mockNeat
				.strings()
				.get();
		newEntity.setUniversalID(randomStringForUniversalID);
		// % protected region % [Add customisation for Universal ID here] end
		// % protected region % [Add customisation for Employee Type here] off begin
		String randomStringForEmployeeType = mockNeat
				.strings()
				.get();
		newEntity.setEmployeeType(randomStringForEmployeeType);
		// % protected region % [Add customisation for Employee Type here] end
		// % protected region % [Add customisation for Onsite Status here] off begin
		String randomStringForOnsiteStatus = mockNeat
				.strings()
				.get();
		newEntity.setOnsiteStatus(randomStringForOnsiteStatus);
		// % protected region % [Add customisation for Onsite Status here] end
		// % protected region % [Add customisation for Occupational Type here] off begin
		String randomStringForOccupationalType = mockNeat
				.strings()
				.get();
		newEntity.setOccupationalType(randomStringForOccupationalType);
		// % protected region % [Add customisation for Occupational Type here] end
		// % protected region % [Add customisation for Dependant ID here] off begin
		String randomStringForDependantID = mockNeat
				.strings()
				.get();
		newEntity.setDependantID(randomStringForDependantID);
		// % protected region % [Add customisation for Dependant ID here] end
		// % protected region % [Add customisation for Dependant Type here] off begin
		String randomStringForDependantType = mockNeat
				.strings()
				.get();
		newEntity.setDependantType(randomStringForDependantType);
		// % protected region % [Add customisation for Dependant Type here] end
		// % protected region % [Add customisation for Sponsor here] off begin
		String randomStringForSponsor = mockNeat
				.strings()
				.get();
		newEntity.setSponsor(randomStringForSponsor);
		// % protected region % [Add customisation for Sponsor here] end
		// % protected region % [Add customisation for Relationship here] off begin
		String randomStringForRelationship = mockNeat
				.strings()
				.get();
		newEntity.setRelationship(randomStringForRelationship);
		// % protected region % [Add customisation for Relationship here] end
		// % protected region % [Add customisation for Company here] off begin
		String randomStringForCompany = mockNeat
				.strings()
				.get();
		newEntity.setCompany(randomStringForCompany);
		// % protected region % [Add customisation for Company here] end
		// % protected region % [Add customisation for Medical Staff Code here] off begin
		String randomStringForMedicalStaffCode = mockNeat
				.strings()
				.get();
		newEntity.setMedicalStaffCode(randomStringForMedicalStaffCode);
		// % protected region % [Add customisation for Medical Staff Code here] end
		// % protected region % [Add customisation for Department here] off begin
		String randomStringForDepartment = mockNeat
				.strings()
				.get();
		newEntity.setDepartment(randomStringForDepartment);
		// % protected region % [Add customisation for Department here] end
		// % protected region % [Add customisation for Position here] off begin
		String randomStringForPosition = mockNeat
				.strings()
				.get();
		newEntity.setPosition(randomStringForPosition);
		// % protected region % [Add customisation for Position here] end
		// % protected region % [Add customisation for Cost Center here] off begin
		String randomStringForCostCenter = mockNeat
				.strings()
				.get();
		newEntity.setCostCenter(randomStringForCostCenter);
		// % protected region % [Add customisation for Cost Center here] end
		// % protected region % [Add customisation for District here] off begin
		String randomStringForDistrict = mockNeat
				.strings()
				.get();
		newEntity.setDistrict(randomStringForDistrict);
		// % protected region % [Add customisation for District here] end
		// % protected region % [Add customisation for Designated Work Place here] off begin
		String randomStringForDesignatedWorkPlace = mockNeat
				.strings()
				.get();
		newEntity.setDesignatedWorkPlace(randomStringForDesignatedWorkPlace);
		// % protected region % [Add customisation for Designated Work Place here] end
		// % protected region % [Add customisation for Bureau No here] off begin
		String randomStringForBureauNo = mockNeat
				.strings()
				.get();
		newEntity.setBureauNo(randomStringForBureauNo);
		// % protected region % [Add customisation for Bureau No here] end
		// % protected region % [Add customisation for Industry No here] off begin
		String randomStringForIndustryNo = mockNeat
				.strings()
				.get();
		newEntity.setIndustryNo(randomStringForIndustryNo);
		// % protected region % [Add customisation for Industry No here] end
		// % protected region % [Add customisation for Employment Start Date here] off begin
		newEntity.setEmploymentStartDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Employment Start Date here] end
		// % protected region % [Add customisation for Passport No here] off begin
		String randomStringForPassportNo = mockNeat
				.strings()
				.get();
		newEntity.setPassportNo(randomStringForPassportNo);
		// % protected region % [Add customisation for Passport No here] end
		// % protected region % [Add customisation for Name here] off begin
		String randomStringForName = mockNeat
				.strings()
				.get();
		newEntity.setName(randomStringForName);
		// % protected region % [Add customisation for Name here] end
		// % protected region % [Add customisation for Passport Country here] off begin
		String randomStringForPassportCountry = mockNeat
				.strings()
				.get();
		newEntity.setPassportCountry(randomStringForPassportCountry);
		// % protected region % [Add customisation for Passport Country here] end
		// % protected region % [Add customisation for Postal Address here] off begin
		String randomStringForPostalAddress = mockNeat
				.strings()
				.get();
		newEntity.setPostalAddress(randomStringForPostalAddress);
		// % protected region % [Add customisation for Postal Address here] end
		// % protected region % [Add customisation for Forwarding Address here] off begin
		String randomStringForForwardingAddress = mockNeat
				.strings()
				.get();
		newEntity.setForwardingAddress(randomStringForForwardingAddress);
		// % protected region % [Add customisation for Forwarding Address here] end
		// % protected region % [Add customisation for Legal DIsability here] off begin
		String randomStringForLegalDIsability = mockNeat
				.strings()
				.get();
		newEntity.setLegalDIsability(randomStringForLegalDIsability);
		// % protected region % [Add customisation for Legal DIsability here] end
		// % protected region % [Add customisation for Legal Disability Notes here] off begin
		String randomStringForLegalDisabilityNotes = mockNeat
				.strings()
				.get();
		newEntity.setLegalDisabilityNotes(randomStringForLegalDisabilityNotes);
		// % protected region % [Add customisation for Legal Disability Notes here] end
		// % protected region % [Add customisation for Worker Insurance here] off begin
		String randomStringForWorkerInsurance = mockNeat
				.strings()
				.get();
		newEntity.setWorkerInsurance(randomStringForWorkerInsurance);
		// % protected region % [Add customisation for Worker Insurance here] end
		// % protected region % [Add customisation for Worker Insurance No here] off begin
		String randomStringForWorkerInsuranceNo = mockNeat
				.strings()
				.get();
		newEntity.setWorkerInsuranceNo(randomStringForWorkerInsuranceNo);
		// % protected region % [Add customisation for Worker Insurance No here] end

		// % protected region % [Apply any additional logic for patientEmploymentDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmploymentDetailWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Patient General Info here] off begin
			// Incoming One to One reference
			var patientGeneralInfoFactory = new PatientGeneralInfoFactory();
			newEntity.setPatientGeneralInfo(patientGeneralInfoFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Patient General Info here] end
		}

		// % protected region % [Apply any additional logic for patientEmploymentDetail with ref here] off begin
		// % protected region % [Apply any additional logic for patientEmploymentDetail with ref here] end

		return newEntity;
	}

	@Override
	public Class<PatientEmploymentDetailEntity> getObjectType() {
		return PatientEmploymentDetailEntity.class;
	}
}