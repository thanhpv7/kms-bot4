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
import kmsweb.entities.PatientGeneralInfoEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PatientGeneralInfoFactory implements FactoryBean<PatientGeneralInfoEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PatientGeneralInfoEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PatientGeneralInfoEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PatientGeneralInfoEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for patientGeneralInfoWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientGeneralInfoWithNoRef before the main body here] end

		PatientGeneralInfoEntity newEntity = new PatientGeneralInfoEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Patient ID here] off begin
		String randomStringForPatientID = mockNeat
				.strings()
				.get();
		newEntity.setPatientID(randomStringForPatientID);
		// % protected region % [Add customisation for Patient ID here] end
		// % protected region % [Add customisation for Title here] off begin
		String randomStringForTitle = mockNeat
				.strings()
				.get();
		newEntity.setTitle(randomStringForTitle);
		// % protected region % [Add customisation for Title here] end
		// % protected region % [Add customisation for Given Name here] off begin
		String randomStringForGivenName = mockNeat
				.strings()
				.get();
		newEntity.setGivenName(randomStringForGivenName);
		// % protected region % [Add customisation for Given Name here] end
		// % protected region % [Add customisation for Last Name here] off begin
		String randomStringForLastName = mockNeat
				.strings()
				.get();
		newEntity.setLastName(randomStringForLastName);
		// % protected region % [Add customisation for Last Name here] end
		// % protected region % [Add customisation for Place of Birth here] off begin
		String randomStringForPlaceOfBirth = mockNeat
				.strings()
				.get();
		newEntity.setPlaceOfBirth(randomStringForPlaceOfBirth);
		// % protected region % [Add customisation for Place of Birth here] end
		// % protected region % [Add customisation for Date of Birth here] off begin
		newEntity.setDateOfBirth(OffsetDateTime.now());
		// % protected region % [Add customisation for Date of Birth here] end
		// % protected region % [Add customisation for Gender here] off begin
		String randomStringForGender = mockNeat
				.strings()
				.get();
		newEntity.setGender(randomStringForGender);
		// % protected region % [Add customisation for Gender here] end
		// % protected region % [Add customisation for Address here] off begin
		String randomStringForAddress = mockNeat
				.strings()
				.get();
		newEntity.setAddress(randomStringForAddress);
		// % protected region % [Add customisation for Address here] end
		// % protected region % [Add customisation for Patient Payment Type here] off begin
		String randomStringForPatientPaymentType = mockNeat
				.strings()
				.get();
		newEntity.setPatientPaymentType(randomStringForPatientPaymentType);
		// % protected region % [Add customisation for Patient Payment Type here] end
		// % protected region % [Add customisation for Important Notes here] off begin
		String randomStringForImportantNotes = mockNeat
				.strings()
				.get();
		newEntity.setImportantNotes(randomStringForImportantNotes);
		// % protected region % [Add customisation for Important Notes here] end
		// % protected region % [Add customisation for Patient Picture here] off begin
		// % protected region % [Add customisation for Patient Picture here] end
		// % protected region % [Add customisation for Has Outstanding Payment here] off begin
		newEntity.setHasOutstandingPayment(mockNeat.bools().get());
		// % protected region % [Add customisation for Has Outstanding Payment here] end

		// % protected region % [Apply any additional logic for patientGeneralInfoWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientGeneralInfoWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Contact Information] off begin
			// Outgoing one to one reference
			var patientContactInformationFactory = new PatientContactInfoFactory();
			newEntity.setPatientContactInformation(patientContactInformationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Contact Information] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Detail Address] off begin
			// Outgoing one to one reference
			var patientDetailAddressFactory = new PatientDetailAddressFactory();
			newEntity.setPatientDetailAddress(patientDetailAddressFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Detail Address] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Detail] off begin
			// Outgoing one to one reference
			var patientDetailFactory = new PatientDetailFactory();
			newEntity.setPatientDetail(patientDetailFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Detail] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Emergency Contact Detail] off begin
			// Outgoing one to one reference
			var patientEmergencyContactDetailFactory = new PatientEmergencyContactDetailFactory();
			newEntity.setPatientEmergencyContactDetail(patientEmergencyContactDetailFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Emergency Contact Detail] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Employment Detail ] off begin
			// Outgoing one to one reference
			var patientEmploymentDetailFactory = new PatientEmploymentDetailFactory();
			newEntity.setPatientEmploymentDetail(patientEmploymentDetailFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Employment Detail ] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Payment BPJS] off begin
			// Outgoing one to one reference
			var patientPaymentBPJSFactory = new PatientPaymentBPJSFactory();
			newEntity.setPatientPaymentBPJS(patientPaymentBPJSFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Payment BPJS] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Payment Type Insurance] off begin
			// Outgoing one to one reference
			var patientPaymentTypeInsuranceFactory = new PatientPaymentInsuranceFactory();
			newEntity.setPatientPaymentTypeInsurance(patientPaymentTypeInsuranceFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Payment Type Insurance] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Payment Type Others] off begin
			// Outgoing one to one reference
			var patientPaymentTypeOthersFactory = new PatientPaymentOthersFactory();
			newEntity.setPatientPaymentTypeOthers(patientPaymentTypeOthersFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Payment Type Others] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Personal Information] off begin
			// Outgoing one to one reference
			var patientPersonalInformationFactory = new PatientPersonalInfoFactory();
			newEntity.setPatientPersonalInformation(patientPersonalInformationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Personal Information] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Self Paying] off begin
			// Outgoing one to one reference
			var patientSelfPayingFactory = new PatientPaymentSelfPayingFactory();
			newEntity.setPatientSelfPaying(patientSelfPayingFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Self Paying] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Claim Submissions here] off begin
			// Outgoing one to many reference
			var bpjsClaimSubmissionsFactory = new BpjsClaimSubmissionFactory();
			newEntity.setBpjsClaimSubmissions(Collections.singletonList(bpjsClaimSubmissionsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Claim Submissions here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Cash Refunds here] off begin
			// Outgoing one to many reference
			var cashRefundsFactory = new CashRefundFactory();
			newEntity.setCashRefunds(Collections.singletonList(cashRefundsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Cash Refunds here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Informed Consents here] off begin
			// Outgoing one to many reference
			var informedConsentsFactory = new InformedConsentFactory();
			newEntity.setInformedConsents(Collections.singletonList(informedConsentsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Informed Consents here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Receipts here] off begin
			// Outgoing one to many reference
			var invoiceReceiptsFactory = new CashReceiptFactory();
			newEntity.setInvoiceReceipts(Collections.singletonList(invoiceReceiptsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Receipts here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Patient Case Histories here] off begin
			// Outgoing one to many reference
			var patientCaseHistoriesFactory = new PatientCaseHistoryFactory();
			newEntity.setPatientCaseHistories(Collections.singletonList(patientCaseHistoriesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Patient Case Histories here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Patient Consents here] off begin
			// Outgoing one to many reference
			var patientConsentsFactory = new PatientConsentFactory();
			newEntity.setPatientConsents(Collections.singletonList(patientConsentsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Patient Consents here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Patient Finalize Profiles here] off begin
			// Outgoing one to many reference
			var patientFinalizeProfilesFactory = new PatientSupportingDocumentFactory();
			newEntity.setPatientFinalizeProfiles(Collections.singletonList(patientFinalizeProfilesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Patient Finalize Profiles here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Retail Pharmacies here] off begin
			// Outgoing one to many reference
			var retailPharmaciesFactory = new RetailPharmacyFactory();
			newEntity.setRetailPharmacies(Collections.singletonList(retailPharmaciesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Retail Pharmacies here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Visits here] off begin
			// Outgoing one to many reference
			var visitsFactory = new PatientVisitFactory();
			newEntity.setVisits(Collections.singletonList(visitsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Visits here] end

		}

		// % protected region % [Apply any additional logic for patientGeneralInfo with ref here] off begin
		// % protected region % [Apply any additional logic for patientGeneralInfo with ref here] end

		return newEntity;
	}

	@Override
	public Class<PatientGeneralInfoEntity> getObjectType() {
		return PatientGeneralInfoEntity.class;
	}
}