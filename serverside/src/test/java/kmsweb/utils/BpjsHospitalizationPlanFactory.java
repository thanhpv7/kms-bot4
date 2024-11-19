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
import kmsweb.entities.BpjsHospitalizationPlanEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsHospitalizationPlanFactory implements FactoryBean<BpjsHospitalizationPlanEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsHospitalizationPlanEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsHospitalizationPlanEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsHospitalizationPlanEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanWithNoRef before the main body here] end

		BpjsHospitalizationPlanEntity newEntity = new BpjsHospitalizationPlanEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for noKartu here] off begin
		String randomStringForNokartu = mockNeat
				.strings()
				.get();
		newEntity.setNokartu(randomStringForNokartu);
		// % protected region % [Add customisation for noKartu here] end
		// % protected region % [Add customisation for tglRencanaKontrol here] off begin
		newEntity.setTglrencanakontrol(OffsetDateTime.now());
		// % protected region % [Add customisation for tglRencanaKontrol here] end
		// % protected region % [Add customisation for noSPRI here] off begin
		String randomStringForNospri = mockNeat
				.strings()
				.get();
		newEntity.setNospri(randomStringForNospri);
		// % protected region % [Add customisation for noSPRI here] end
		// % protected region % [Add customisation for diagnosa here] off begin
		String randomStringForDiagnosa = mockNeat
				.strings()
				.get();
		newEntity.setDiagnosa(randomStringForDiagnosa);
		// % protected region % [Add customisation for diagnosa here] end

		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient Payment BPJS here] off begin
			var patientPaymentBPJSFactory = new PatientPaymentBPJSFactory();
			newEntity.setPatientPaymentBPJS(patientPaymentBPJSFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient Payment BPJS here] end

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

		// % protected region % [Apply any additional logic for bpjsHospitalizationPlan with ref here] off begin
		// % protected region % [Apply any additional logic for bpjsHospitalizationPlan with ref here] end

		return newEntity;
	}

	@Override
	public Class<BpjsHospitalizationPlanEntity> getObjectType() {
		return BpjsHospitalizationPlanEntity.class;
	}
}