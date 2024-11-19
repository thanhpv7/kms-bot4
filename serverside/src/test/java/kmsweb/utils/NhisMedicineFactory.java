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
import kmsweb.entities.NhisMedicineEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class NhisMedicineFactory implements FactoryBean<NhisMedicineEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public NhisMedicineEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public NhisMedicineEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public NhisMedicineEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for nhisMedicineWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisMedicineWithNoRef before the main body here] end

		NhisMedicineEntity newEntity = new NhisMedicineEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Medicine Code here] off begin
		String randomStringForMedicineCode = mockNeat
				.strings()
				.get();
		newEntity.setMedicineCode(randomStringForMedicineCode);
		// % protected region % [Add customisation for Medicine Code here] end
		// % protected region % [Add customisation for Medicine Name here] off begin
		String randomStringForMedicineName = mockNeat
				.strings()
				.get();
		newEntity.setMedicineName(randomStringForMedicineName);
		// % protected region % [Add customisation for Medicine Name here] end
		// % protected region % [Add customisation for Dose here] off begin
		newEntity.setDose(mockNeat.doubles().get());
		// % protected region % [Add customisation for Dose here] end
		// % protected region % [Add customisation for UOI here] off begin
		String randomStringForUoi = mockNeat
				.strings()
				.get();
		newEntity.setUoi(randomStringForUoi);
		// % protected region % [Add customisation for UOI here] end
		// % protected region % [Add customisation for Frequency here] off begin
		String randomStringForFrequency = mockNeat
				.strings()
				.get();
		newEntity.setFrequency(randomStringForFrequency);
		// % protected region % [Add customisation for Frequency here] end
		// % protected region % [Add customisation for Duration here] off begin
		newEntity.setDuration(mockNeat.doubles().get());
		// % protected region % [Add customisation for Duration here] end
		// % protected region % [Add customisation for Unit Price here] off begin
		newEntity.setUnitPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Unit Price here] end
		// % protected region % [Add customisation for Dispensed Qty here] off begin
		newEntity.setDispensedQty(mockNeat.doubles().get());
		// % protected region % [Add customisation for Dispensed Qty here] end
		// % protected region % [Add customisation for Total Cost here] off begin
		newEntity.setTotalCost(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Cost here] end
		// % protected region % [Add customisation for Service Date here] off begin
		newEntity.setServiceDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Service Date here] end

		// % protected region % [Apply any additional logic for nhisMedicineWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisMedicineWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<NhisMedicineEntity> getObjectType() {
		return NhisMedicineEntity.class;
	}
}