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
import kmsweb.entities.PcareCompoundDrugEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PcareCompoundDrugFactory implements FactoryBean<PcareCompoundDrugEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PcareCompoundDrugEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PcareCompoundDrugEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PcareCompoundDrugEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for pcareCompoundDrugWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugWithNoRef before the main body here] end

		PcareCompoundDrugEntity newEntity = new PcareCompoundDrugEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Compound Name here] off begin
		String randomStringForCompoundName = mockNeat
				.strings()
				.get();
		newEntity.setCompoundName(randomStringForCompoundName);
		// % protected region % [Add customisation for Compound Name here] end
		// % protected region % [Add customisation for Signa Days here] off begin
		newEntity.setSignaDays(mockNeat.doubles().get());
		// % protected region % [Add customisation for Signa Days here] end
		// % protected region % [Add customisation for Signa Times here] off begin
		newEntity.setSignaTimes(mockNeat.ints().get());
		// % protected region % [Add customisation for Signa Times here] end
		// % protected region % [Add customisation for Package Qty here] off begin
		newEntity.setPackageQty(mockNeat.doubles().get());
		// % protected region % [Add customisation for Package Qty here] end
		// % protected region % [Add customisation for Day here] off begin
		newEntity.setDay(mockNeat.doubles().get());
		// % protected region % [Add customisation for Day here] end
		// % protected region % [Add customisation for Request Qty here] off begin
		newEntity.setRequestQty(mockNeat.ints().get());
		// % protected region % [Add customisation for Request Qty here] end
		// % protected region % [Add customisation for Kd Obat SK here] off begin
		String randomStringForKdObatSK = mockNeat
				.strings()
				.get();
		newEntity.setKdObatSK(randomStringForKdObatSK);
		// % protected region % [Add customisation for Kd Obat SK here] end
		// % protected region % [Add customisation for Racikan here] off begin
		newEntity.setRacikan(mockNeat.bools().get());
		// % protected region % [Add customisation for Racikan here] end
		// % protected region % [Add customisation for Kd Racikan here] off begin
		String randomStringForKdRacikan = mockNeat
				.strings()
				.get();
		newEntity.setKdRacikan(randomStringForKdRacikan);
		// % protected region % [Add customisation for Kd Racikan here] end
		// % protected region % [Add customisation for Nama Obat Non DPHO here] off begin
		String randomStringForNamaObatNonDPHO = mockNeat
				.strings()
				.get();
		newEntity.setNamaObatNonDPHO(randomStringForNamaObatNonDPHO);
		// % protected region % [Add customisation for Nama Obat Non DPHO here] end
		// % protected region % [Add customisation for Drug Qty here] off begin
		newEntity.setDrugQty(mockNeat.doubles().get());
		// % protected region % [Add customisation for Drug Qty here] end

		// % protected region % [Apply any additional logic for pcareCompoundDrugWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPCare Examination here] off begin
			var pcareExaminationFactory = new PcareExaminationFactory();
			newEntity.setPcareExamination(pcareExaminationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPCare Examination here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany PCare Compound Drug Items here] off begin
			// Outgoing one to many reference
			var pcareCompoundDrugItemsFactory = new PcareCompoundDrugItemFactory();
			newEntity.setPcareCompoundDrugItems(Collections.singletonList(pcareCompoundDrugItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany PCare Compound Drug Items here] end

		}

		// % protected region % [Apply any additional logic for pcareCompoundDrug with ref here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrug with ref here] end

		return newEntity;
	}

	@Override
	public Class<PcareCompoundDrugEntity> getObjectType() {
		return PcareCompoundDrugEntity.class;
	}
}