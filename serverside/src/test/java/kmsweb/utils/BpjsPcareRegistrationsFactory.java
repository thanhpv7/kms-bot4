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
import kmsweb.entities.BpjsPcareRegistrationsEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsPcareRegistrationsFactory implements FactoryBean<BpjsPcareRegistrationsEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsPcareRegistrationsEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsPcareRegistrationsEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsPcareRegistrationsEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsWithNoRef before the main body here] end

		BpjsPcareRegistrationsEntity newEntity = new BpjsPcareRegistrationsEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for kdProviderPeserta here] off begin
		String randomStringForKdproviderpeserta = mockNeat
				.strings()
				.get();
		newEntity.setKdproviderpeserta(randomStringForKdproviderpeserta);
		// % protected region % [Add customisation for kdProviderPeserta here] end
		// % protected region % [Add customisation for tglDaftar here] off begin
		String randomStringForTgldaftar = mockNeat
				.strings()
				.get();
		newEntity.setTgldaftar(randomStringForTgldaftar);
		// % protected region % [Add customisation for tglDaftar here] end
		// % protected region % [Add customisation for noKartu here] off begin
		String randomStringForNokartu = mockNeat
				.strings()
				.get();
		newEntity.setNokartu(randomStringForNokartu);
		// % protected region % [Add customisation for noKartu here] end
		// % protected region % [Add customisation for kdPoli here] off begin
		String randomStringForKdpoli = mockNeat
				.strings()
				.get();
		newEntity.setKdpoli(randomStringForKdpoli);
		// % protected region % [Add customisation for kdPoli here] end
		// % protected region % [Add customisation for keluhan here] off begin
		String randomStringForKeluhan = mockNeat
				.strings()
				.get();
		newEntity.setKeluhan(randomStringForKeluhan);
		// % protected region % [Add customisation for keluhan here] end
		// % protected region % [Add customisation for kunjSakit here] off begin
		String randomStringForKunjsakit = mockNeat
				.strings()
				.get();
		newEntity.setKunjsakit(randomStringForKunjsakit);
		// % protected region % [Add customisation for kunjSakit here] end
		// % protected region % [Add customisation for sistole here] off begin
		String randomStringForSistole = mockNeat
				.strings()
				.get();
		newEntity.setSistole(randomStringForSistole);
		// % protected region % [Add customisation for sistole here] end
		// % protected region % [Add customisation for diastole here] off begin
		String randomStringForDiastole = mockNeat
				.strings()
				.get();
		newEntity.setDiastole(randomStringForDiastole);
		// % protected region % [Add customisation for diastole here] end
		// % protected region % [Add customisation for beratBadan here] off begin
		String randomStringForBeratbadan = mockNeat
				.strings()
				.get();
		newEntity.setBeratbadan(randomStringForBeratbadan);
		// % protected region % [Add customisation for beratBadan here] end
		// % protected region % [Add customisation for tinggiBadan here] off begin
		String randomStringForTinggibadan = mockNeat
				.strings()
				.get();
		newEntity.setTinggibadan(randomStringForTinggibadan);
		// % protected region % [Add customisation for tinggiBadan here] end
		// % protected region % [Add customisation for respRate here] off begin
		String randomStringForResprate = mockNeat
				.strings()
				.get();
		newEntity.setResprate(randomStringForResprate);
		// % protected region % [Add customisation for respRate here] end
		// % protected region % [Add customisation for lingkarPerut here] off begin
		String randomStringForLingkarperut = mockNeat
				.strings()
				.get();
		newEntity.setLingkarperut(randomStringForLingkarperut);
		// % protected region % [Add customisation for lingkarPerut here] end
		// % protected region % [Add customisation for rujukInternal here] off begin
		String randomStringForRujukinternal = mockNeat
				.strings()
				.get();
		newEntity.setRujukinternal(randomStringForRujukinternal);
		// % protected region % [Add customisation for rujukInternal here] end
		// % protected region % [Add customisation for heartRate here] off begin
		String randomStringForHeartrate = mockNeat
				.strings()
				.get();
		newEntity.setHeartrate(randomStringForHeartrate);
		// % protected region % [Add customisation for heartRate here] end
		// % protected region % [Add customisation for rujukBalik here] off begin
		String randomStringForRujukbalik = mockNeat
				.strings()
				.get();
		newEntity.setRujukbalik(randomStringForRujukbalik);
		// % protected region % [Add customisation for rujukBalik here] end
		// % protected region % [Add customisation for kdTkp here] off begin
		String randomStringForKdtkp = mockNeat
				.strings()
				.get();
		newEntity.setKdtkp(randomStringForKdtkp);
		// % protected region % [Add customisation for kdTkp here] end

		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Patient Visit here] off begin
			// Incoming One to One reference
			var patientVisitFactory = new PatientVisitFactory();
			newEntity.setPatientVisit(patientVisitFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Patient Visit here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne Registration here] off begin
			// Incoming One to One reference
			var registrationFactory = new RegistrationFactory();
			newEntity.setRegistration(registrationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Registration here] end
		}

		// % protected region % [Apply any additional logic for bpjsPcareRegistrations with ref here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRegistrations with ref here] end

		return newEntity;
	}

	@Override
	public Class<BpjsPcareRegistrationsEntity> getObjectType() {
		return BpjsPcareRegistrationsEntity.class;
	}
}