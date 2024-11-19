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
import kmsweb.entities.BpjsPRBEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsPRBFactory implements FactoryBean<BpjsPRBEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsPRBEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsPRBEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsPRBEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsPRBWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBWithNoRef before the main body here] end

		BpjsPRBEntity newEntity = new BpjsPRBEntity();
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
		// % protected region % [Add customisation for SEP No here] off begin
		String randomStringForSepNo = mockNeat
				.strings()
				.get();
		newEntity.setSepNo(randomStringForSepNo);
		// % protected region % [Add customisation for SEP No here] end
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringForBpjsCardNo = mockNeat
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringForBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for Address here] off begin
		String randomStringForAddress = mockNeat
				.strings()
				.get();
		newEntity.setAddress(randomStringForAddress);
		// % protected region % [Add customisation for Address here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringForEmail = mockNeat
				.strings()
				.get();
		newEntity.setEmail(randomStringForEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for PRB Program Code here] off begin
		String randomStringForPrbProgramCode = mockNeat
				.strings()
				.get();
		newEntity.setPrbProgramCode(randomStringForPrbProgramCode);
		// % protected region % [Add customisation for PRB Program Code here] end
		// % protected region % [Add customisation for PRB Program Name here] off begin
		String randomStringForPrbProgramName = mockNeat
				.strings()
				.get();
		newEntity.setPrbProgramName(randomStringForPrbProgramName);
		// % protected region % [Add customisation for PRB Program Name here] end
		// % protected region % [Add customisation for Doctor Code here] off begin
		String randomStringForDoctorCode = mockNeat
				.strings()
				.get();
		newEntity.setDoctorCode(randomStringForDoctorCode);
		// % protected region % [Add customisation for Doctor Code here] end
		// % protected region % [Add customisation for Doctor Name here] off begin
		String randomStringForDoctorName = mockNeat
				.strings()
				.get();
		newEntity.setDoctorName(randomStringForDoctorName);
		// % protected region % [Add customisation for Doctor Name here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Recommendation here] off begin
		String randomStringForRecommendation = mockNeat
				.strings()
				.get();
		newEntity.setRecommendation(randomStringForRecommendation);
		// % protected region % [Add customisation for Recommendation here] end

		// % protected region % [Apply any additional logic for bpjsPRBWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Diagnose PRB here] off begin
			var bpjsDiagnosePRBFactory = new BpjsDiagnosePRBFactory();
			newEntity.setBpjsDiagnosePRB(bpjsDiagnosePRBFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Diagnose PRB here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Doctor Mapping here] off begin
			var bpjsDoctorMappingFactory = new BpjsDoctorMappingFactory();
			newEntity.setBpjsDoctorMapping(bpjsDoctorMappingFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyBPJS Doctor Mapping here] end

		}

		// % protected region % [Apply any additional logic for bpjsPRB with ref here] off begin
		// % protected region % [Apply any additional logic for bpjsPRB with ref here] end

		return newEntity;
	}

	@Override
	public Class<BpjsPRBEntity> getObjectType() {
		return BpjsPRBEntity.class;
	}
}