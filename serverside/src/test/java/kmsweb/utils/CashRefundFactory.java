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
import kmsweb.entities.CashRefundEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class CashRefundFactory implements FactoryBean<CashRefundEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public CashRefundEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public CashRefundEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public CashRefundEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for cashRefundWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for cashRefundWithNoRef before the main body here] end

		CashRefundEntity newEntity = new CashRefundEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Refund Number here] off begin
		String randomStringForRefundNumber = mockNeat
				.strings()
				.get();
		newEntity.setRefundNumber(randomStringForRefundNumber);
		// % protected region % [Add customisation for Refund Number here] end
		// % protected region % [Add customisation for Refund Date here] off begin
		newEntity.setRefundDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Refund Date here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringForDescription = mockNeat
				.strings()
				.size(5000)
				.get();
		newEntity.setDescription(randomStringForDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Cashier Location here] off begin
		String randomStringForCashierLocation = mockNeat
				.strings()
				.get();
		newEntity.setCashierLocation(randomStringForCashierLocation);
		// % protected region % [Add customisation for Cashier Location here] end
		// % protected region % [Add customisation for IsVoid here] off begin
		newEntity.setIsvoid(mockNeat.bools().get());
		// % protected region % [Add customisation for IsVoid here] end
		// % protected region % [Add customisation for Void Date Time here] off begin
		newEntity.setVoidDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Void Date Time here] end
		// % protected region % [Add customisation for Payment Type here] off begin
		String randomStringForPaymentType = mockNeat
				.strings()
				.get();
		newEntity.setPaymentType(randomStringForPaymentType);
		// % protected region % [Add customisation for Payment Type here] end
		// % protected region % [Add customisation for Refund Amount here] off begin
		newEntity.setRefundAmount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Refund Amount here] end
		// % protected region % [Add customisation for Hospital Bank Account here] off begin
		String randomStringForHospitalBankAccount = mockNeat
				.strings()
				.get();
		newEntity.setHospitalBankAccount(randomStringForHospitalBankAccount);
		// % protected region % [Add customisation for Hospital Bank Account here] end
		// % protected region % [Add customisation for Reference Number here] off begin
		String randomStringForReferenceNumber = mockNeat
				.strings()
				.get();
		newEntity.setReferenceNumber(randomStringForReferenceNumber);
		// % protected region % [Add customisation for Reference Number here] end

		// % protected region % [Apply any additional logic for cashRefundWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for cashRefundWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient General Info here] off begin
			var patientGeneralInfoFactory = new PatientGeneralInfoFactory();
			newEntity.setPatientGeneralInfo(patientGeneralInfoFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient General Info here] end

		}

		// % protected region % [Apply any additional logic for cashRefund with ref here] off begin
		// % protected region % [Apply any additional logic for cashRefund with ref here] end

		return newEntity;
	}

	@Override
	public Class<CashRefundEntity> getObjectType() {
		return CashRefundEntity.class;
	}
}