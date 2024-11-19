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
import kmsweb.entities.ExaminationGroupEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class ExaminationGroupFactory implements FactoryBean<ExaminationGroupEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public ExaminationGroupEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public ExaminationGroupEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public ExaminationGroupEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for examinationGroupWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationGroupWithNoRef before the main body here] end

		ExaminationGroupEntity newEntity = new ExaminationGroupEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Diagnostic Group Code here] off begin
		String randomStringForDiagnosticGroupCode = mockNeat
				.strings()
				.get();
		newEntity.setDiagnosticGroupCode(randomStringForDiagnosticGroupCode);
		// % protected region % [Add customisation for Diagnostic Group Code here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringForDescription = mockNeat
				.strings()
				.get();
		newEntity.setDescription(randomStringForDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Sequence here] off begin
		newEntity.setSequence(mockNeat.ints().get());
		// % protected region % [Add customisation for Sequence here] end

		// % protected region % [Apply any additional logic for examinationGroupWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationGroupWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyService here] off begin
			var serviceFactory = new ServiceFactory();
			newEntity.setService(serviceFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyService here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Examination Items here] off begin
			// Outgoing one to many reference
			var examinationItemsFactory = new ExaminationItemFactory();
			newEntity.setExaminationItems(Collections.singletonList(examinationItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Examination Items here] end

		}

		// % protected region % [Apply any additional logic for examinationGroup with ref here] off begin
		// % protected region % [Apply any additional logic for examinationGroup with ref here] end

		return newEntity;
	}

	@Override
	public Class<ExaminationGroupEntity> getObjectType() {
		return ExaminationGroupEntity.class;
	}
}