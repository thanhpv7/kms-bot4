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
import kmsweb.entities.NumberingSetupEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class NumberingSetupFactory implements FactoryBean<NumberingSetupEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public NumberingSetupEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public NumberingSetupEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public NumberingSetupEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for numberingSetupWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for numberingSetupWithNoRef before the main body here] end

		NumberingSetupEntity newEntity = new NumberingSetupEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Numbering Type here] off begin
		newEntity.setNumberingType(NumberingTypeEnum.PRESCRIPTION_NON_COMPOUND);
		// % protected region % [Add customisation for Numbering Type here] end
		// % protected region % [Add customisation for Prefix here] off begin
		String randomStringForPrefix = mockNeat
				.strings()
				.get();
		newEntity.setPrefix(randomStringForPrefix);
		// % protected region % [Add customisation for Prefix here] end
		// % protected region % [Add customisation for Date Format here] off begin
		newEntity.setDateFormat(DateFormatEnum.YYYYMMDD);
		// % protected region % [Add customisation for Date Format here] end
		// % protected region % [Add customisation for Sufix here] off begin
		String randomStringForSufix = mockNeat
				.strings()
				.get();
		newEntity.setSufix(randomStringForSufix);
		// % protected region % [Add customisation for Sufix here] end
		// % protected region % [Add customisation for Last Counter here] off begin
		newEntity.setLastCounter(mockNeat.ints().get());
		// % protected region % [Add customisation for Last Counter here] end
		// % protected region % [Add customisation for Editable here] off begin
		newEntity.setEditable(mockNeat.bools().get());
		// % protected region % [Add customisation for Editable here] end
		// % protected region % [Add customisation for Reset per Day here] off begin
		newEntity.setResetPerDay(mockNeat.bools().get());
		// % protected region % [Add customisation for Reset per Day here] end
		// % protected region % [Add customisation for Counter Length here] off begin
		newEntity.setCounterLength(mockNeat.ints().get());
		// % protected region % [Add customisation for Counter Length here] end
		// % protected region % [Add customisation for Last Updated here] off begin
		newEntity.setLastUpdated(OffsetDateTime.now());
		// % protected region % [Add customisation for Last Updated here] end
		// % protected region % [Add customisation for Preview here] off begin
		String randomStringForPreview = mockNeat
				.strings()
				.get();
		newEntity.setPreview(randomStringForPreview);
		// % protected region % [Add customisation for Preview here] end

		// % protected region % [Apply any additional logic for numberingSetupWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for numberingSetupWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<NumberingSetupEntity> getObjectType() {
		return NumberingSetupEntity.class;
	}
}