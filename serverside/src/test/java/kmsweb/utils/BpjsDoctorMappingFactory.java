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
import kmsweb.entities.BpjsDoctorMappingEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsDoctorMappingFactory implements FactoryBean<BpjsDoctorMappingEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsDoctorMappingEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsDoctorMappingEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsDoctorMappingEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsDoctorMappingWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorMappingWithNoRef before the main body here] end

		BpjsDoctorMappingEntity newEntity = new BpjsDoctorMappingEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Ref Code here] off begin
		String randomStringForRefCode = mockNeat
				.strings()
				.size(25)
				.get();
		newEntity.setRefCode(randomStringForRefCode);
		// % protected region % [Add customisation for Ref Code here] end
		// % protected region % [Add customisation for BPJS Medical Staff here] off begin
		String randomStringForBpjsMedicalStaff = mockNeat
				.strings()
				.get();
		newEntity.setBpjsMedicalStaff(randomStringForBpjsMedicalStaff);
		// % protected region % [Add customisation for BPJS Medical Staff here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.size(1000)
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Ref Code Service here] off begin
		String randomStringForRefCodeService = mockNeat
				.strings()
				.get();
		newEntity.setRefCodeService(randomStringForRefCodeService);
		// % protected region % [Add customisation for Ref Code Service here] end

		// % protected region % [Apply any additional logic for bpjsDoctorMappingWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorMappingWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Staff here] off begin
			// Incoming One to One reference
			var staffFactory = new StaffFactory();
			newEntity.setStaff(staffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Staff here] end
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Claim Submissions here] off begin
			// Outgoing one to many reference
			var bpjsClaimSubmissionsFactory = new BpjsClaimSubmissionFactory();
			newEntity.setBpjsClaimSubmissions(Collections.singletonList(bpjsClaimSubmissionsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Claim Submissions here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Control Plans here] off begin
			// Outgoing one to many reference
			var bpjsControlPlansFactory = new BpjsControlPlanFactory();
			newEntity.setBpjsControlPlans(Collections.singletonList(bpjsControlPlansFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Control Plans here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS PRBs here] off begin
			// Outgoing one to many reference
			var bpjsPRBsFactory = new BpjsPRBFactory();
			newEntity.setBpjsPRBs(Collections.singletonList(bpjsPRBsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS PRBs here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany kodeDokter here] off begin
			// Outgoing one to many reference
			var kodedokterFactory = new BpjsHospitalizationPlanFactory();
			newEntity.setKodedokter(Collections.singletonList(kodedokterFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany kodeDokter here] end

		}

		// % protected region % [Apply any additional logic for bpjsDoctorMapping with ref here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorMapping with ref here] end

		return newEntity;
	}

	@Override
	public Class<BpjsDoctorMappingEntity> getObjectType() {
		return BpjsDoctorMappingEntity.class;
	}
}