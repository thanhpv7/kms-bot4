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
import kmsweb.entities.InsuranceBenefitPlanEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class InsuranceBenefitPlanFactory implements FactoryBean<InsuranceBenefitPlanEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public InsuranceBenefitPlanEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public InsuranceBenefitPlanEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public InsuranceBenefitPlanEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for insuranceBenefitPlanWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceBenefitPlanWithNoRef before the main body here] end

		InsuranceBenefitPlanEntity newEntity = new InsuranceBenefitPlanEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Benefit Plan No here] off begin
		String randomStringForBenefitPlanNo = mockNeat
				.strings()
				.get();
		newEntity.setBenefitPlanNo(randomStringForBenefitPlanNo);
		// % protected region % [Add customisation for Benefit Plan No here] end
		// % protected region % [Add customisation for Benefit Plan Name here] off begin
		String randomStringForBenefitPlanName = mockNeat
				.strings()
				.get();
		newEntity.setBenefitPlanName(randomStringForBenefitPlanName);
		// % protected region % [Add customisation for Benefit Plan Name here] end
		// % protected region % [Add customisation for Maximum Coverage per Treatment here] off begin
		newEntity.setMaximumCoveragePerTreatment(mockNeat.doubles().get());
		// % protected region % [Add customisation for Maximum Coverage per Treatment here] end
		// % protected region % [Add customisation for Maximum Coverage per Year here] off begin
		newEntity.setMaximumCoveragePerYear(mockNeat.doubles().get());
		// % protected region % [Add customisation for Maximum Coverage per Year here] end
		// % protected region % [Add customisation for Created Date here] off begin
		newEntity.setCreatedDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Created Date here] end
		// % protected region % [Add customisation for Updated Date here] off begin
		newEntity.setUpdatedDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Updated Date here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for insuranceBenefitPlanWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceBenefitPlanWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyInsurance Provider here] off begin
			var insuranceProviderFactory = new InsuranceProviderFactory();
			newEntity.setInsuranceProvider(insuranceProviderFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyInsurance Provider here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Payment Insurances here] off begin
			// Outgoing one to many reference
			var invoicePaymentInsurancesFactory = new InvoicePaymentInsuranceFactory();
			newEntity.setInvoicePaymentInsurances(Collections.singletonList(invoicePaymentInsurancesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Payment Insurances here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Patient Payment Insurances here] off begin
			// Outgoing one to many reference
			var patientPaymentInsurancesFactory = new PatientPaymentInsuranceFactory();
			newEntity.setPatientPaymentInsurances(Collections.singletonList(patientPaymentInsurancesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Patient Payment Insurances here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Patient Visit Patient Payment Insurances here] off begin
			// Outgoing one to many reference
			var patientVisitPatientPaymentInsurancesFactory = new PatientVisitPatientPaymentInsuranceFactory();
			newEntity.setPatientVisitPatientPaymentInsurances(Collections.singletonList(patientVisitPatientPaymentInsurancesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Patient Visit Patient Payment Insurances here] end

		}

		// % protected region % [Apply any additional logic for insuranceBenefitPlan with ref here] off begin
		// % protected region % [Apply any additional logic for insuranceBenefitPlan with ref here] end

		return newEntity;
	}

	@Override
	public Class<InsuranceBenefitPlanEntity> getObjectType() {
		return InsuranceBenefitPlanEntity.class;
	}
}