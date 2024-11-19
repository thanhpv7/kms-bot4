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
import kmsweb.entities.BpjsControlPlanEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsControlPlanFactory implements FactoryBean<BpjsControlPlanEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsControlPlanEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsControlPlanEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsControlPlanEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsControlPlanWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlPlanWithNoRef before the main body here] end

		BpjsControlPlanEntity newEntity = new BpjsControlPlanEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for No SEP here] off begin
		String randomStringForNoSEP = mockNeat
				.strings()
				.get();
		newEntity.setNoSEP(randomStringForNoSEP);
		// % protected region % [Add customisation for No SEP here] end
		// % protected region % [Add customisation for Control Letter No here] off begin
		String randomStringForControlLetterNo = mockNeat
				.strings()
				.get();
		newEntity.setControlLetterNo(randomStringForControlLetterNo);
		// % protected region % [Add customisation for Control Letter No here] end
		// % protected region % [Add customisation for Control Plan Date here] off begin
		String randomStringForControlPlanDate = mockNeat
				.strings()
				.get();
		newEntity.setControlPlanDate(randomStringForControlPlanDate);
		// % protected region % [Add customisation for Control Plan Date here] end
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringForBpjsCardNo = mockNeat
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringForBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for Name here] off begin
		String randomStringForName = mockNeat
				.strings()
				.get();
		newEntity.setName(randomStringForName);
		// % protected region % [Add customisation for Name here] end
		// % protected region % [Add customisation for Gender here] off begin
		String randomStringForGender = mockNeat
				.strings()
				.get();
		newEntity.setGender(randomStringForGender);
		// % protected region % [Add customisation for Gender here] end
		// % protected region % [Add customisation for Date Of Birth here] off begin
		String randomStringForDateOfBirth = mockNeat
				.strings()
				.get();
		newEntity.setDateOfBirth(randomStringForDateOfBirth);
		// % protected region % [Add customisation for Date Of Birth here] end
		// % protected region % [Add customisation for Doctor Code here] off begin
		String randomStringForDoctorCode = mockNeat
				.strings()
				.get();
		newEntity.setDoctorCode(randomStringForDoctorCode);
		// % protected region % [Add customisation for Doctor Code here] end
		// % protected region % [Add customisation for Polyclinic Code here] off begin
		String randomStringForPolyclinicCode = mockNeat
				.strings()
				.get();
		newEntity.setPolyclinicCode(randomStringForPolyclinicCode);
		// % protected region % [Add customisation for Polyclinic Code here] end

		// % protected region % [Apply any additional logic for bpjsControlPlanWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlPlanWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Doctor Mapping here] off begin
			var bpjsDoctorMappingFactory = new BpjsDoctorMappingFactory();
			newEntity.setBpjsDoctorMapping(bpjsDoctorMappingFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Doctor Mapping here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Service Mapping here] off begin
			var bpjsServiceMappingFactory = new BpjsServiceMappingFactory();
			newEntity.setBpjsServiceMapping(bpjsServiceMappingFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Service Mapping here] end

		}

		// % protected region % [Apply any additional logic for bpjsControlPlan with ref here] off begin
		// % protected region % [Apply any additional logic for bpjsControlPlan with ref here] end

		return newEntity;
	}

	@Override
	public Class<BpjsControlPlanEntity> getObjectType() {
		return BpjsControlPlanEntity.class;
	}
}