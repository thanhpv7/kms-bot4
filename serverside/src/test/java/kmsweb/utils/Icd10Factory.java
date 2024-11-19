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
import kmsweb.entities.Icd10Entity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class Icd10Factory implements FactoryBean<Icd10Entity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public Icd10Entity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public Icd10Entity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public Icd10Entity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for icd10WithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for icd10WithNoRef before the main body here] end

		Icd10Entity newEntity = new Icd10Entity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Classification Disease here] off begin
		newEntity.setClassificationDisease(mockNeat.bools().get());
		// % protected region % [Add customisation for Classification Disease here] end
		// % protected region % [Add customisation for Classification Infectious here] off begin
		newEntity.setClassificationInfectious(mockNeat.bools().get());
		// % protected region % [Add customisation for Classification Infectious here] end
		// % protected region % [Add customisation for Classification Chronic here] off begin
		newEntity.setClassificationChronic(mockNeat.bools().get());
		// % protected region % [Add customisation for Classification Chronic here] end
		// % protected region % [Add customisation for Classification Top Disease here] off begin
		newEntity.setClassificationTopDisease(mockNeat.bools().get());
		// % protected region % [Add customisation for Classification Top Disease here] end
		// % protected region % [Add customisation for Classification Restricted Case here] off begin
		newEntity.setClassificationRestrictedCase(mockNeat.bools().get());
		// % protected region % [Add customisation for Classification Restricted Case here] end
		// % protected region % [Add customisation for Classification Reportable Case here] off begin
		newEntity.setClassificationReportableCase(mockNeat.bools().get());
		// % protected region % [Add customisation for Classification Reportable Case here] end
		// % protected region % [Add customisation for Classification Acute here] off begin
		newEntity.setClassificationAcute(mockNeat.bools().get());
		// % protected region % [Add customisation for Classification Acute here] end
		// % protected region % [Add customisation for Dismissal Date here] off begin
		newEntity.setDismissalDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Dismissal Date here] end

		// % protected region % [Apply any additional logic for icd10WithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for icd10WithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Diagnoses and Procedures here] off begin
			// Incoming One to One reference
			var diagnosesAndProceduresFactory = new DiagnosesAndProceduresFactory();
			newEntity.setDiagnosesAndProcedures(diagnosesAndProceduresFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Diagnoses and Procedures here] end
		}

		// % protected region % [Apply any additional logic for icd10 with ref here] off begin
		// % protected region % [Apply any additional logic for icd10 with ref here] end

		return newEntity;
	}

	@Override
	public Class<Icd10Entity> getObjectType() {
		return Icd10Entity.class;
	}
}