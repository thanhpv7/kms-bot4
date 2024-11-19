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
import kmsweb.entities.NhisGDRGEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class NhisGDRGFactory implements FactoryBean<NhisGDRGEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public NhisGDRGEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public NhisGDRGEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public NhisGDRGEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for nhisGDRGWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisGDRGWithNoRef before the main body here] end

		NhisGDRGEntity newEntity = new NhisGDRGEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Core GDRG Code here] off begin
		String randomStringForCoreGDRGCode = mockNeat
				.strings()
				.get();
		newEntity.setCoreGDRGCode(randomStringForCoreGDRGCode);
		// % protected region % [Add customisation for Core GDRG Code here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringForDescription = mockNeat
				.strings()
				.get();
		newEntity.setDescription(randomStringForDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Category here] off begin
		String randomStringForCategory = mockNeat
				.strings()
				.get();
		newEntity.setCategory(randomStringForCategory);
		// % protected region % [Add customisation for Category here] end
		// % protected region % [Add customisation for Level of Healthcare here] off begin
		String randomStringForLevelOfHealthcare = mockNeat
				.strings()
				.get();
		newEntity.setLevelOfHealthcare(randomStringForLevelOfHealthcare);
		// % protected region % [Add customisation for Level of Healthcare here] end
		// % protected region % [Add customisation for Investigation Code here] off begin
		String randomStringForInvestigationCode = mockNeat
				.strings()
				.get();
		newEntity.setInvestigationCode(randomStringForInvestigationCode);
		// % protected region % [Add customisation for Investigation Code here] end
		// % protected region % [Add customisation for icd10s here] off begin
		String randomStringForIcd10s = mockNeat
				.strings()
				.get();
		newEntity.setIcd10s(randomStringForIcd10s);
		// % protected region % [Add customisation for icd10s here] end

		// % protected region % [Apply any additional logic for nhisGDRGWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisGDRGWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<NhisGDRGEntity> getObjectType() {
		return NhisGDRGEntity.class;
	}
}