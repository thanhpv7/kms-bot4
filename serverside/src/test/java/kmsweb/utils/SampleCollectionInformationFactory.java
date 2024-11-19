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
import kmsweb.entities.SampleCollectionInformationEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class SampleCollectionInformationFactory implements FactoryBean<SampleCollectionInformationEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public SampleCollectionInformationEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public SampleCollectionInformationEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public SampleCollectionInformationEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for sampleCollectionInformationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for sampleCollectionInformationWithNoRef before the main body here] end

		SampleCollectionInformationEntity newEntity = new SampleCollectionInformationEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Patient Informed here] off begin
		newEntity.setPatientInformed(mockNeat.bools().get());
		// % protected region % [Add customisation for Patient Informed here] end
		// % protected region % [Add customisation for Patient Consented here] off begin
		newEntity.setPatientConsented(mockNeat.bools().get());
		// % protected region % [Add customisation for Patient Consented here] end
		// % protected region % [Add customisation for Patient Fasted Enough here] off begin
		newEntity.setPatientFastedEnough(mockNeat.bools().get());
		// % protected region % [Add customisation for Patient Fasted Enough here] end
		// % protected region % [Add customisation for Medication Taken In 24 Hours here] off begin
		newEntity.setMedicationTakenIn24Hours(mockNeat.bools().get());
		// % protected region % [Add customisation for Medication Taken In 24 Hours here] end
		// % protected region % [Add customisation for Medication Taken In 72 Hours here] off begin
		newEntity.setMedicationTakenIn72Hours(mockNeat.bools().get());
		// % protected region % [Add customisation for Medication Taken In 72 Hours here] end

		// % protected region % [Apply any additional logic for sampleCollectionInformationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for sampleCollectionInformationWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Diagnosis Examination Record here] off begin
			// Incoming One to One reference
			var diagnosisExaminationRecordFactory = new DiagnosisExaminationRecordFactory();
			newEntity.setDiagnosisExaminationRecord(diagnosisExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Diagnosis Examination Record here] end
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyRegistration here] off begin
			var registrationFactory = new RegistrationFactory();
			newEntity.setRegistration(registrationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyRegistration here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Sample Collection Items here] off begin
			// Outgoing one to many reference
			var sampleCollectionItemsFactory = new SampleCollectionItemsFactory();
			newEntity.setSampleCollectionItems(Collections.singletonList(sampleCollectionItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Sample Collection Items here] end

		}

		// % protected region % [Apply any additional logic for sampleCollectionInformation with ref here] off begin
		// % protected region % [Apply any additional logic for sampleCollectionInformation with ref here] end

		return newEntity;
	}

	@Override
	public Class<SampleCollectionInformationEntity> getObjectType() {
		return SampleCollectionInformationEntity.class;
	}
}