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
import kmsweb.entities.CashReceiptEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class CashReceiptFactory implements FactoryBean<CashReceiptEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public CashReceiptEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public CashReceiptEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public CashReceiptEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for cashReceiptWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for cashReceiptWithNoRef before the main body here] end

		CashReceiptEntity newEntity = new CashReceiptEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Receipt Type here] off begin
		newEntity.setReceiptType(ReceiptTypeEnum.PAYMENT);
		// % protected region % [Add customisation for Receipt Type here] end
		// % protected region % [Add customisation for Receipt Number here] off begin
		String randomStringForReceiptNumber = mockNeat
				.strings()
				.get();
		newEntity.setReceiptNumber(randomStringForReceiptNumber);
		// % protected region % [Add customisation for Receipt Number here] end
		// % protected region % [Add customisation for Payment Date here] off begin
		newEntity.setPaymentDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Payment Date here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringForDescription = mockNeat
				.strings()
				.size(5000)
				.get();
		newEntity.setDescription(randomStringForDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Payment Type here] off begin
		String randomStringForPaymentType = mockNeat
				.strings()
				.get();
		newEntity.setPaymentType(randomStringForPaymentType);
		// % protected region % [Add customisation for Payment Type here] end
		// % protected region % [Add customisation for Receive Amount here] off begin
		newEntity.setReceiveAmount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Receive Amount here] end
		// % protected region % [Add customisation for IsVoid here] off begin
		newEntity.setIsvoid(mockNeat.bools().get());
		// % protected region % [Add customisation for IsVoid here] end
		// % protected region % [Add customisation for Cashier Location here] off begin
		String randomStringForCashierLocation = mockNeat
				.strings()
				.get();
		newEntity.setCashierLocation(randomStringForCashierLocation);
		// % protected region % [Add customisation for Cashier Location here] end
		// % protected region % [Add customisation for Void Date Time here] off begin
		newEntity.setVoidDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Void Date Time here] end
		// % protected region % [Add customisation for Cash Change Type here] off begin
		newEntity.setCashChangeType(CashChangeTypeEnum.NO_CHANGE);
		// % protected region % [Add customisation for Cash Change Type here] end
		// % protected region % [Add customisation for Change Amount here] off begin
		newEntity.setChangeAmount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Change Amount here] end
		// % protected region % [Add customisation for Allocated Amount here] off begin
		newEntity.setAllocatedAmount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Allocated Amount here] end
		// % protected region % [Add customisation for Rounding Amount here] off begin
		newEntity.setRoundingAmount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Rounding Amount here] end
		// % protected region % [Add customisation for Available Amount here] off begin
		newEntity.setAvailableAmount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Available Amount here] end
		// % protected region % [Add customisation for Bank Name here] off begin
		String randomStringForBankName = mockNeat
				.strings()
				.get();
		newEntity.setBankName(randomStringForBankName);
		// % protected region % [Add customisation for Bank Name here] end
		// % protected region % [Add customisation for Card Type here] off begin
		String randomStringForCardType = mockNeat
				.strings()
				.get();
		newEntity.setCardType(randomStringForCardType);
		// % protected region % [Add customisation for Card Type here] end
		// % protected region % [Add customisation for Card No here] off begin
		String randomStringForCardNo = mockNeat
				.strings()
				.get();
		newEntity.setCardNo(randomStringForCardNo);
		// % protected region % [Add customisation for Card No here] end
		// % protected region % [Add customisation for Card Holder here] off begin
		String randomStringForCardHolder = mockNeat
				.strings()
				.get();
		newEntity.setCardHolder(randomStringForCardHolder);
		// % protected region % [Add customisation for Card Holder here] end
		// % protected region % [Add customisation for Reference Number here] off begin
		String randomStringForReferenceNumber = mockNeat
				.strings()
				.get();
		newEntity.setReferenceNumber(randomStringForReferenceNumber);
		// % protected region % [Add customisation for Reference Number here] end
		// % protected region % [Add customisation for Hospital Bank Account here] off begin
		String randomStringForHospitalBankAccount = mockNeat
				.strings()
				.get();
		newEntity.setHospitalBankAccount(randomStringForHospitalBankAccount);
		// % protected region % [Add customisation for Hospital Bank Account here] end
		// % protected region % [Add customisation for Surcharge Amount here] off begin
		newEntity.setSurchargeAmount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Surcharge Amount here] end
		// % protected region % [Add customisation for Outstanding Amount here] off begin
		newEntity.setOutstandingAmount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Outstanding Amount here] end
		// % protected region % [Add customisation for Received From here] off begin
		String randomStringForReceivedFrom = mockNeat
				.strings()
				.get();
		newEntity.setReceivedFrom(randomStringForReceivedFrom);
		// % protected region % [Add customisation for Received From here] end
		// % protected region % [Add customisation for Patient Or Customer Name here] off begin
		String randomStringForPatientOrCustomerName = mockNeat
				.strings()
				.get();
		newEntity.setPatientOrCustomerName(randomStringForPatientOrCustomerName);
		// % protected region % [Add customisation for Patient Or Customer Name here] end

		// % protected region % [Apply any additional logic for cashReceiptWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for cashReceiptWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyMerchant here] off begin
			var merchantFactory = new MerchantFactory();
			newEntity.setMerchant(merchantFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyMerchant here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyRetail Pharmacy Invoice here] off begin
			var retailPharmacyInvoiceFactory = new RetailPharmacyInvoiceFactory();
			newEntity.setRetailPharmacyInvoice(retailPharmacyInvoiceFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyRetail Pharmacy Invoice here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyCashier Staff here] off begin
			var cashierStaffFactory = new StaffFactory();
			newEntity.setCashierStaff(cashierStaffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyCashier Staff here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient here] off begin
			var patientFactory = new PatientGeneralInfoFactory();
			newEntity.setPatient(patientFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient here] end

		}

		// % protected region % [Apply any additional logic for cashReceipt with ref here] off begin
		// % protected region % [Apply any additional logic for cashReceipt with ref here] end

		return newEntity;
	}

	@Override
	public Class<CashReceiptEntity> getObjectType() {
		return CashReceiptEntity.class;
	}
}