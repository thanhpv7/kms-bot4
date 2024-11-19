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
import kmsweb.entities.PatientVisitEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PatientVisitFactory implements FactoryBean<PatientVisitEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PatientVisitEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PatientVisitEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PatientVisitEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for patientVisitWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitWithNoRef before the main body here] end

		PatientVisitEntity newEntity = new PatientVisitEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Visit Number here] off begin
		String randomStringForVisitNumber = mockNeat
				.strings()
				.get();
		newEntity.setVisitNumber(randomStringForVisitNumber);
		// % protected region % [Add customisation for Visit Number here] end
		// % protected region % [Add customisation for Registration Type here] off begin
		String randomStringForRegistrationType = mockNeat
				.strings()
				.get();
		newEntity.setRegistrationType(randomStringForRegistrationType);
		// % protected region % [Add customisation for Registration Type here] end
		// % protected region % [Add customisation for Visit Date here] off begin
		newEntity.setVisitDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Visit Date here] end
		// % protected region % [Add customisation for Registration Location here] off begin
		String randomStringForRegistrationLocation = mockNeat
				.strings()
				.get();
		newEntity.setRegistrationLocation(randomStringForRegistrationLocation);
		// % protected region % [Add customisation for Registration Location here] end
		// % protected region % [Add customisation for Patient Payment Type here] off begin
		String randomStringForPatientPaymentType = mockNeat
				.strings()
				.get();
		newEntity.setPatientPaymentType(randomStringForPatientPaymentType);
		// % protected region % [Add customisation for Patient Payment Type here] end
		// % protected region % [Add customisation for Visit Type here] off begin
		String randomStringForVisitType = mockNeat
				.strings()
				.get();
		newEntity.setVisitType(randomStringForVisitType);
		// % protected region % [Add customisation for Visit Type here] end

		// % protected region % [Apply any additional logic for patientVisitWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for outgoingOneToOne BPJS Pcare Registrations] off begin
			// Outgoing one to one reference
			var bpjsPcareRegistrationsFactory = new BpjsPcareRegistrationsFactory();
			newEntity.setBpjsPcareRegistrations(bpjsPcareRegistrationsFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne BPJS Pcare Registrations] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Visit Patient Payment Insurance] off begin
			// Outgoing one to one reference
			var patientVisitPatientPaymentInsuranceFactory = new PatientVisitPatientPaymentInsuranceFactory();
			newEntity.setPatientVisitPatientPaymentInsurance(patientVisitPatientPaymentInsuranceFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Visit Patient Payment Insurance] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Visit Patient Payment Others] off begin
			// Outgoing one to one reference
			var patientVisitPatientPaymentOthersFactory = new PatientVisitPatientPaymentOthersFactory();
			newEntity.setPatientVisitPatientPaymentOthers(patientVisitPatientPaymentOthersFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Visit Patient Payment Others] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Visit Payment Self Paying] off begin
			// Outgoing one to one reference
			var patientVisitPaymentSelfPayingFactory = new PatientVisitPaymentSelfPayingFactory();
			newEntity.setPatientVisitPaymentSelfPaying(patientVisitPaymentSelfPayingFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Patient Visit Payment Self Paying] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient here] off begin
			var patientFactory = new PatientGeneralInfoFactory();
			newEntity.setPatient(patientFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Visit Datas here] off begin
			// Outgoing one to many reference
			var bpjsVisitDatasFactory = new BpjsVisitDataFactory();
			newEntity.setBpjsVisitDatas(Collections.singletonList(bpjsVisitDatasFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany BPJS Visit Datas here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Bpjs Pcare Pendaftarans here] off begin
			// Outgoing one to many reference
			var bpjsPcarePendaftaransFactory = new BpjsPcarePendaftaranFactory();
			newEntity.setBpjsPcarePendaftarans(Collections.singletonList(bpjsPcarePendaftaransFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Bpjs Pcare Pendaftarans here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoices here] off begin
			// Outgoing one to many reference
			var invoicesFactory = new InvoiceFactory();
			newEntity.setInvoices(Collections.singletonList(invoicesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoices here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Registrations here] off begin
			// Outgoing one to many reference
			var registrationsFactory = new RegistrationFactory();
			newEntity.setRegistrations(Collections.singletonList(registrationsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Registrations here] end

		}

		// % protected region % [Apply any additional logic for patientVisit with ref here] off begin
		// % protected region % [Apply any additional logic for patientVisit with ref here] end

		return newEntity;
	}

	@Override
	public Class<PatientVisitEntity> getObjectType() {
		return PatientVisitEntity.class;
	}
}