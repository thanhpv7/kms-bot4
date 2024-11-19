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
import kmsweb.entities.ChartOfAccountMappingEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class ChartOfAccountMappingFactory implements FactoryBean<ChartOfAccountMappingEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public ChartOfAccountMappingEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public ChartOfAccountMappingEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public ChartOfAccountMappingEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for chartOfAccountMappingWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountMappingWithNoRef before the main body here] end

		ChartOfAccountMappingEntity newEntity = new ChartOfAccountMappingEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Account Type here] off begin
		String randomStringForAccountType = mockNeat
				.strings()
				.get();
		newEntity.setAccountType(randomStringForAccountType);
		// % protected region % [Add customisation for Account Type here] end
		// % protected region % [Add customisation for Account Type Description here] off begin
		String randomStringForAccountTypeDescription = mockNeat
				.strings()
				.get();
		newEntity.setAccountTypeDescription(randomStringForAccountTypeDescription);
		// % protected region % [Add customisation for Account Type Description here] end

		// % protected region % [Apply any additional logic for chartOfAccountMappingWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountMappingWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyChart of Account here] off begin
			var chartOfAccountFactory = new ChartOfAccountFactory();
			newEntity.setChartOfAccount(chartOfAccountFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyChart of Account here] end

		}

		// % protected region % [Apply any additional logic for chartOfAccountMapping with ref here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountMapping with ref here] end

		return newEntity;
	}

	@Override
	public Class<ChartOfAccountMappingEntity> getObjectType() {
		return ChartOfAccountMappingEntity.class;
	}
}