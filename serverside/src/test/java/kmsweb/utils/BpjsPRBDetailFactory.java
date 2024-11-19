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
import kmsweb.entities.BpjsPRBDetailEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsPRBDetailFactory implements FactoryBean<BpjsPRBDetailEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsPRBDetailEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsPRBDetailEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsPRBDetailEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsPRBDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBDetailWithNoRef before the main body here] end

		BpjsPRBDetailEntity newEntity = new BpjsPRBDetailEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for SRB No here] off begin
		String randomStringForSrbNo = mockNeat
				.strings()
				.get();
		newEntity.setSrbNo(randomStringForSrbNo);
		// % protected region % [Add customisation for SRB No here] end
		// % protected region % [Add customisation for Drug Code here] off begin
		String randomStringForDrugCode = mockNeat
				.strings()
				.get();
		newEntity.setDrugCode(randomStringForDrugCode);
		// % protected region % [Add customisation for Drug Code here] end
		// % protected region % [Add customisation for Drug Name here] off begin
		String randomStringForDrugName = mockNeat
				.strings()
				.get();
		newEntity.setDrugName(randomStringForDrugName);
		// % protected region % [Add customisation for Drug Name here] end
		// % protected region % [Add customisation for Signa 1 here] off begin
		String randomStringForSigna1 = mockNeat
				.strings()
				.get();
		newEntity.setSigna1(randomStringForSigna1);
		// % protected region % [Add customisation for Signa 1 here] end
		// % protected region % [Add customisation for Signa 2 here] off begin
		String randomStringForSigna2 = mockNeat
				.strings()
				.get();
		newEntity.setSigna2(randomStringForSigna2);
		// % protected region % [Add customisation for Signa 2 here] end
		// % protected region % [Add customisation for Qty here] off begin
		String randomStringForQty = mockNeat
				.strings()
				.get();
		newEntity.setQty(randomStringForQty);
		// % protected region % [Add customisation for Qty here] end

		// % protected region % [Apply any additional logic for bpjsPRBDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBDetailWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Registration here] off begin
			// Incoming One to One reference
			var registrationFactory = new RegistrationFactory();
			newEntity.setRegistration(registrationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Registration here] end
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Drug Generic PRB here] off begin
			var bpjsDrugGenericPRBFactory = new BpjsDrugGenericPRBFactory();
			newEntity.setBpjsDrugGenericPRB(bpjsDrugGenericPRBFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Drug Generic PRB here] end

		}

		// % protected region % [Apply any additional logic for bpjsPRBDetail with ref here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBDetail with ref here] end

		return newEntity;
	}

	@Override
	public Class<BpjsPRBDetailEntity> getObjectType() {
		return BpjsPRBDetailEntity.class;
	}
}