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
import kmsweb.entities.BpjsSEPSubmissionEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsSEPSubmissionFactory implements FactoryBean<BpjsSEPSubmissionEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsSEPSubmissionEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsSEPSubmissionEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsSEPSubmissionEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsSEPSubmissionWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPSubmissionWithNoRef before the main body here] end

		BpjsSEPSubmissionEntity newEntity = new BpjsSEPSubmissionEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Status here] off begin
		String randomStringForStatus = mockNeat
				.strings()
				.get();
		newEntity.setStatus(randomStringForStatus);
		// % protected region % [Add customisation for Status here] end
		// % protected region % [Add customisation for Submission Type here] off begin
		String randomStringForSubmissionType = mockNeat
				.strings()
				.get();
		newEntity.setSubmissionType(randomStringForSubmissionType);
		// % protected region % [Add customisation for Submission Type here] end
		// % protected region % [Add customisation for SEP Date here] off begin
		String randomStringForSepDate = mockNeat
				.strings()
				.get();
		newEntity.setSepDate(randomStringForSepDate);
		// % protected region % [Add customisation for SEP Date here] end
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

		// % protected region % [Apply any additional logic for bpjsSEPSubmissionWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPSubmissionWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient Payment BPJS here] off begin
			var patientPaymentBPJSFactory = new PatientPaymentBPJSFactory();
			newEntity.setPatientPaymentBPJS(patientPaymentBPJSFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient Payment BPJS here] end

		}

		// % protected region % [Apply any additional logic for bpjsSEPSubmission with ref here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPSubmission with ref here] end

		return newEntity;
	}

	@Override
	public Class<BpjsSEPSubmissionEntity> getObjectType() {
		return BpjsSEPSubmissionEntity.class;
	}
}