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
import kmsweb.entities.ProcessWorkflowEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class ProcessWorkflowFactory implements FactoryBean<ProcessWorkflowEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public ProcessWorkflowEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public ProcessWorkflowEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public ProcessWorkflowEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for processWorkflowWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for processWorkflowWithNoRef before the main body here] end

		ProcessWorkflowEntity newEntity = new ProcessWorkflowEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Step Number here] off begin
		newEntity.setStepNumber(mockNeat.ints().get());
		// % protected region % [Add customisation for Step Number here] end
		// % protected region % [Add customisation for Module Name here] off begin
		newEntity.setModuleName(ModuleNameEnum.REGISTRATION);
		// % protected region % [Add customisation for Module Name here] end
		// % protected region % [Add customisation for Process Name here] off begin
		String randomStringForProcessName = mockNeat
				.strings()
				.get();
		newEntity.setProcessName(randomStringForProcessName);
		// % protected region % [Add customisation for Process Name here] end
		// % protected region % [Add customisation for Reference ID here] off begin
		String randomStringForReferenceID = mockNeat
				.strings()
				.get();
		newEntity.setReferenceID(randomStringForReferenceID);
		// % protected region % [Add customisation for Reference ID here] end
		// % protected region % [Add customisation for Process Date Time here] off begin
		newEntity.setProcessDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Process Date Time here] end

		// % protected region % [Apply any additional logic for processWorkflowWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for processWorkflowWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] off begin
			var staffFactory = new StaffFactory();
			newEntity.setStaff(staffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] end

		}

		// % protected region % [Apply any additional logic for processWorkflow with ref here] off begin
		// % protected region % [Apply any additional logic for processWorkflow with ref here] end

		return newEntity;
	}

	@Override
	public Class<ProcessWorkflowEntity> getObjectType() {
		return ProcessWorkflowEntity.class;
	}
}