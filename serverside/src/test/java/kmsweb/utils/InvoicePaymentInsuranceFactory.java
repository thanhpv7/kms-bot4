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
import kmsweb.entities.InvoicePaymentInsuranceEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class InvoicePaymentInsuranceFactory implements FactoryBean<InvoicePaymentInsuranceEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public InvoicePaymentInsuranceEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public InvoicePaymentInsuranceEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public InvoicePaymentInsuranceEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for invoicePaymentInsuranceWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentInsuranceWithNoRef before the main body here] end

		InvoicePaymentInsuranceEntity newEntity = new InvoicePaymentInsuranceEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Member No here] off begin
		String randomStringForMemberNo = mockNeat
				.strings()
				.get();
		newEntity.setMemberNo(randomStringForMemberNo);
		// % protected region % [Add customisation for Member No here] end
		// % protected region % [Add customisation for Policy Holder No here] off begin
		String randomStringForPolicyHolderNo = mockNeat
				.strings()
				.get();
		newEntity.setPolicyHolderNo(randomStringForPolicyHolderNo);
		// % protected region % [Add customisation for Policy Holder No here] end
		// % protected region % [Add customisation for Eligility Verification here] off begin
		String randomStringForEligilityVerification = mockNeat
				.strings()
				.get();
		newEntity.setEligilityVerification(randomStringForEligilityVerification);
		// % protected region % [Add customisation for Eligility Verification here] end
		// % protected region % [Add customisation for Verification Date here] off begin
		newEntity.setVerificationDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Verification Date here] end
		// % protected region % [Add customisation for Guarantee Letter No here] off begin
		String randomStringForGuaranteeLetterNo = mockNeat
				.strings()
				.get();
		newEntity.setGuaranteeLetterNo(randomStringForGuaranteeLetterNo);
		// % protected region % [Add customisation for Guarantee Letter No here] end
		// % protected region % [Add customisation for Coverage Balance here] off begin
		newEntity.setCoverageBalance(mockNeat.doubles().get());
		// % protected region % [Add customisation for Coverage Balance here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Main Insurance here] off begin
		newEntity.setMainInsurance(mockNeat.bools().get());
		// % protected region % [Add customisation for Main Insurance here] end

		// % protected region % [Apply any additional logic for invoicePaymentInsuranceWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentInsuranceWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyInsurance Benefit Plan here] off begin
			var insuranceBenefitPlanFactory = new InsuranceBenefitPlanFactory();
			newEntity.setInsuranceBenefitPlan(insuranceBenefitPlanFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyInsurance Benefit Plan here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyInvoice here] off begin
			var invoiceFactory = new InvoiceFactory();
			newEntity.setInvoice(invoiceFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyInvoice here] end

		}

		// % protected region % [Apply any additional logic for invoicePaymentInsurance with ref here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentInsurance with ref here] end

		return newEntity;
	}

	@Override
	public Class<InvoicePaymentInsuranceEntity> getObjectType() {
		return InvoicePaymentInsuranceEntity.class;
	}
}