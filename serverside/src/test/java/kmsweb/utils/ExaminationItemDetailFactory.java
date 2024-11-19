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
import kmsweb.entities.ExaminationItemDetailEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class ExaminationItemDetailFactory implements FactoryBean<ExaminationItemDetailEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public ExaminationItemDetailEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public ExaminationItemDetailEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public ExaminationItemDetailEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for examinationItemDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemDetailWithNoRef before the main body here] end

		ExaminationItemDetailEntity newEntity = new ExaminationItemDetailEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Age Minimum here] off begin
		newEntity.setAgeMinimum(mockNeat.ints().get());
		// % protected region % [Add customisation for Age Minimum here] end
		// % protected region % [Add customisation for Age Maximum here] off begin
		newEntity.setAgeMaximum(mockNeat.ints().get());
		// % protected region % [Add customisation for Age Maximum here] end
		// % protected region % [Add customisation for Gender here] off begin
		String randomStringForGender = mockNeat
				.strings()
				.get();
		newEntity.setGender(randomStringForGender);
		// % protected region % [Add customisation for Gender here] end
		// % protected region % [Add customisation for Normal Range Low here] off begin
		newEntity.setNormalRangeLow(mockNeat.doubles().get());
		// % protected region % [Add customisation for Normal Range Low here] end
		// % protected region % [Add customisation for Normal Range High here] off begin
		newEntity.setNormalRangeHigh(mockNeat.doubles().get());
		// % protected region % [Add customisation for Normal Range High here] end
		// % protected region % [Add customisation for Unit here] off begin
		String randomStringForUnit = mockNeat
				.strings()
				.get();
		newEntity.setUnit(randomStringForUnit);
		// % protected region % [Add customisation for Unit here] end
		// % protected region % [Add customisation for Critical Value Low here] off begin
		newEntity.setCriticalValueLow(mockNeat.doubles().get());
		// % protected region % [Add customisation for Critical Value Low here] end
		// % protected region % [Add customisation for Critical Value High here] off begin
		newEntity.setCriticalValueHigh(mockNeat.doubles().get());
		// % protected region % [Add customisation for Critical Value High here] end
		// % protected region % [Add customisation for Age Min Unit here] off begin
		String randomStringForAgeMinUnit = mockNeat
				.strings()
				.get();
		newEntity.setAgeMinUnit(randomStringForAgeMinUnit);
		// % protected region % [Add customisation for Age Min Unit here] end
		// % protected region % [Add customisation for Age Max Unit here] off begin
		String randomStringForAgeMaxUnit = mockNeat
				.strings()
				.get();
		newEntity.setAgeMaxUnit(randomStringForAgeMaxUnit);
		// % protected region % [Add customisation for Age Max Unit here] end

		// % protected region % [Apply any additional logic for examinationItemDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemDetailWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyExamination Item here] off begin
			var examinationItemFactory = new ExaminationItemFactory();
			newEntity.setExaminationItem(examinationItemFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyExamination Item here] end

		}

		// % protected region % [Apply any additional logic for examinationItemDetail with ref here] off begin
		// % protected region % [Apply any additional logic for examinationItemDetail with ref here] end

		return newEntity;
	}

	@Override
	public Class<ExaminationItemDetailEntity> getObjectType() {
		return ExaminationItemDetailEntity.class;
	}
}