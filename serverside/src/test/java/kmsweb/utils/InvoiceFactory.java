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
import kmsweb.entities.InvoiceEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class InvoiceFactory implements FactoryBean<InvoiceEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public InvoiceEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public InvoiceEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public InvoiceEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for invoiceWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceWithNoRef before the main body here] end

		InvoiceEntity newEntity = new InvoiceEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Invoice Number here] off begin
		String randomStringForInvoiceNumber = mockNeat
				.strings()
				.get();
		newEntity.setInvoiceNumber(randomStringForInvoiceNumber);
		// % protected region % [Add customisation for Invoice Number here] end
		// % protected region % [Add customisation for Revision Number here] off begin
		newEntity.setRevisionNumber(mockNeat.ints().get());
		// % protected region % [Add customisation for Revision Number here] end
		// % protected region % [Add customisation for Invoice Status here] off begin
		String randomStringForInvoiceStatus = mockNeat
				.strings()
				.get();
		newEntity.setInvoiceStatus(randomStringForInvoiceStatus);
		// % protected region % [Add customisation for Invoice Status here] end
		// % protected region % [Add customisation for Invoice Type here] off begin
		newEntity.setInvoiceType(InvoiceTypeEnum.OUTPATIENT);
		// % protected region % [Add customisation for Invoice Type here] end
		// % protected region % [Add customisation for Invoice Date here] off begin
		newEntity.setInvoiceDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Invoice Date here] end
		// % protected region % [Add customisation for Cancel Date here] off begin
		newEntity.setCancelDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Cancel Date here] end
		// % protected region % [Add customisation for Billing Location here] off begin
		String randomStringForBillingLocation = mockNeat
				.strings()
				.size(20)
				.get();
		newEntity.setBillingLocation(randomStringForBillingLocation);
		// % protected region % [Add customisation for Billing Location here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.size(500)
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Patient Payment Type here] off begin
		String randomStringForPatientPaymentType = mockNeat
				.strings()
				.get();
		newEntity.setPatientPaymentType(randomStringForPatientPaymentType);
		// % protected region % [Add customisation for Patient Payment Type here] end
		// % protected region % [Add customisation for Verification Date here] off begin
		newEntity.setVerificationDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Verification Date here] end
		// % protected region % [Add customisation for Display Doctor on Print here] off begin
		newEntity.setDisplayDoctorOnPrint(mockNeat.bools().get());
		// % protected region % [Add customisation for Display Doctor on Print here] end
		// % protected region % [Add customisation for Display ICD 10 on Print here] off begin
		newEntity.setDisplayICD10OnPrint(mockNeat.bools().get());
		// % protected region % [Add customisation for Display ICD 10 on Print here] end
		// % protected region % [Add customisation for Display ICD 9 CM on Print here] off begin
		newEntity.setDisplayICD9CMOnPrint(mockNeat.bools().get());
		// % protected region % [Add customisation for Display ICD 9 CM on Print here] end
		// % protected region % [Add customisation for Doctor Code here] off begin
		String randomStringForDoctorCode = mockNeat
				.strings()
				.get();
		newEntity.setDoctorCode(randomStringForDoctorCode);
		// % protected region % [Add customisation for Doctor Code here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringForTreatmentClass = mockNeat
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringForTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Admission Date here] off begin
		newEntity.setAdmissionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Admission Date here] end
		// % protected region % [Add customisation for Discharged Date here] off begin
		newEntity.setDischargedDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Discharged Date here] end
		// % protected region % [Add customisation for Claim No here] off begin
		String randomStringForClaimNo = mockNeat
				.strings()
				.get();
		newEntity.setClaimNo(randomStringForClaimNo);
		// % protected region % [Add customisation for Claim No here] end

		// % protected region % [Apply any additional logic for invoiceWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Medication Header here] off begin
			// Incoming One to One reference
			var medicationHeaderFactory = new MedicationHeaderFactory();
			newEntity.setMedicationHeader(medicationHeaderFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Medication Header here] end
			// % protected region % [Override the reference inclusions for outgoingOneToOne Invoice Payment Other] off begin
			// Outgoing one to one reference
			var invoicePaymentOtherFactory = new InvoicePaymentOtherFactory();
			newEntity.setInvoicePaymentOther(invoicePaymentOtherFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Invoice Payment Other] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Invoice Payment Self Paying] off begin
			// Outgoing one to one reference
			var invoicePaymentSelfPayingFactory = new InvoicePaymentSelfPayingFactory();
			newEntity.setInvoicePaymentSelfPaying(invoicePaymentSelfPayingFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Invoice Payment Self Paying] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Invoice Summary] off begin
			// Outgoing one to one reference
			var invoiceSummaryFactory = new InvoiceSummaryFactory();
			newEntity.setInvoiceSummary(invoiceSummaryFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Invoice Summary] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Prescription Header] off begin
			// Outgoing one to one reference
			var prescriptionHeaderFactory = new PrescriptionHeaderFactory();
			newEntity.setPrescriptionHeader(prescriptionHeaderFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Prescription Header] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyICD 10 here] off begin
			var icd10Factory = new DiagnosesAndProceduresFactory();
			newEntity.setIcd10(icd10Factory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyICD 10 here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyICD 9 CM here] off begin
			var icd9CMFactory = new DiagnosesAndProceduresFactory();
			newEntity.setIcd9CM(icd9CMFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyICD 9 CM here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyBed Facility here] off begin
			var bedFacilityFactory = new BedFacilityFactory();
			newEntity.setBedFacility(bedFacilityFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyBed Facility here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient Visit here] off begin
			var patientVisitFactory = new PatientVisitFactory();
			newEntity.setPatientVisit(patientVisitFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient Visit here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyTariff Schema here] off begin
			var tariffSchemaFactory = new TariffSchemaFactory();
			newEntity.setTariffSchema(tariffSchemaFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyTariff Schema here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyVerified By here] off begin
			var verifiedByFactory = new StaffFactory();
			newEntity.setVerifiedBy(verifiedByFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyVerified By here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Items here] off begin
			// Outgoing one to many reference
			var invoiceItemsFactory = new InvoiceItemFactory();
			newEntity.setInvoiceItems(Collections.singletonList(invoiceItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Items here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Payment Insurances here] off begin
			// Outgoing one to many reference
			var invoicePaymentInsurancesFactory = new InvoicePaymentInsuranceFactory();
			newEntity.setInvoicePaymentInsurances(Collections.singletonList(invoicePaymentInsurancesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Payment Insurances here] end

		}

		// % protected region % [Apply any additional logic for invoice with ref here] off begin
		// % protected region % [Apply any additional logic for invoice with ref here] end

		return newEntity;
	}

	@Override
	public Class<InvoiceEntity> getObjectType() {
		return InvoiceEntity.class;
	}
}