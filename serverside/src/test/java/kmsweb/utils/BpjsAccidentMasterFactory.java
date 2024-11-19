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
import kmsweb.entities.BpjsAccidentMasterEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsAccidentMasterFactory implements FactoryBean<BpjsAccidentMasterEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsAccidentMasterEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsAccidentMasterEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsAccidentMasterEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsAccidentMasterWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsAccidentMasterWithNoRef before the main body here] end

		BpjsAccidentMasterEntity newEntity = new BpjsAccidentMasterEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for noSEP here] off begin
		String randomStringForNosep = mockNeat
				.strings()
				.get();
		newEntity.setNosep(randomStringForNosep);
		// % protected region % [Add customisation for noSEP here] end
		// % protected region % [Add customisation for tglKejadian here] off begin
		String randomStringForTglkejadian = mockNeat
				.strings()
				.get();
		newEntity.setTglkejadian(randomStringForTglkejadian);
		// % protected region % [Add customisation for tglKejadian here] end
		// % protected region % [Add customisation for ppkPelSEP here] off begin
		String randomStringForPpkpelsep = mockNeat
				.strings()
				.get();
		newEntity.setPpkpelsep(randomStringForPpkpelsep);
		// % protected region % [Add customisation for ppkPelSEP here] end
		// % protected region % [Add customisation for kdProp here] off begin
		String randomStringForKdprop = mockNeat
				.strings()
				.get();
		newEntity.setKdprop(randomStringForKdprop);
		// % protected region % [Add customisation for kdProp here] end
		// % protected region % [Add customisation for kdKab here] off begin
		String randomStringForKdkab = mockNeat
				.strings()
				.get();
		newEntity.setKdkab(randomStringForKdkab);
		// % protected region % [Add customisation for kdKab here] end
		// % protected region % [Add customisation for kdKec here] off begin
		String randomStringForKdkec = mockNeat
				.strings()
				.get();
		newEntity.setKdkec(randomStringForKdkec);
		// % protected region % [Add customisation for kdKec here] end
		// % protected region % [Add customisation for ketKejadian here] off begin
		String randomStringForKetkejadian = mockNeat
				.strings()
				.get();
		newEntity.setKetkejadian(randomStringForKetkejadian);
		// % protected region % [Add customisation for ketKejadian here] end
		// % protected region % [Add customisation for noSEPSuplesi here] off begin
		String randomStringForNosepsuplesi = mockNeat
				.strings()
				.get();
		newEntity.setNosepsuplesi(randomStringForNosepsuplesi);
		// % protected region % [Add customisation for noSEPSuplesi here] end

		// % protected region % [Apply any additional logic for bpjsAccidentMasterWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsAccidentMasterWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient Payment BPJS here] off begin
			var patientPaymentBPJSFactory = new PatientPaymentBPJSFactory();
			newEntity.setPatientPaymentBPJS(patientPaymentBPJSFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient Payment BPJS here] end

		}

		// % protected region % [Apply any additional logic for bpjsAccidentMaster with ref here] off begin
		// % protected region % [Apply any additional logic for bpjsAccidentMaster with ref here] end

		return newEntity;
	}

	@Override
	public Class<BpjsAccidentMasterEntity> getObjectType() {
		return BpjsAccidentMasterEntity.class;
	}
}