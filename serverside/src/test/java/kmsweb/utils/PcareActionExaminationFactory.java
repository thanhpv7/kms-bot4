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
import kmsweb.entities.PcareActionExaminationEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PcareActionExaminationFactory implements FactoryBean<PcareActionExaminationEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PcareActionExaminationEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PcareActionExaminationEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PcareActionExaminationEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for pcareActionExaminationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareActionExaminationWithNoRef before the main body here] end

		PcareActionExaminationEntity newEntity = new PcareActionExaminationEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Action Code here] off begin
		String randomStringForActionCode = mockNeat
				.strings()
				.get();
		newEntity.setActionCode(randomStringForActionCode);
		// % protected region % [Add customisation for Action Code here] end
		// % protected region % [Add customisation for Fee here] off begin
		newEntity.setFee(mockNeat.doubles().get());
		// % protected region % [Add customisation for Fee here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for kdTindakanSK here] off begin
		String randomStringForKdtindakansk = mockNeat
				.strings()
				.get();
		newEntity.setKdtindakansk(randomStringForKdtindakansk);
		// % protected region % [Add customisation for kdTindakanSK here] end
		// % protected region % [Add customisation for hasil here] off begin
		newEntity.setHasil(mockNeat.ints().get());
		// % protected region % [Add customisation for hasil here] end

		// % protected region % [Apply any additional logic for pcareActionExaminationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareActionExaminationWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPCare Examination here] off begin
			var pcareExaminationFactory = new PcareExaminationFactory();
			newEntity.setPcareExamination(pcareExaminationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPCare Examination here] end

		}

		// % protected region % [Apply any additional logic for pcareActionExamination with ref here] off begin
		// % protected region % [Apply any additional logic for pcareActionExamination with ref here] end

		return newEntity;
	}

	@Override
	public Class<PcareActionExaminationEntity> getObjectType() {
		return PcareActionExaminationEntity.class;
	}
}