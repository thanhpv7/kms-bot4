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
import kmsweb.entities.DiagnosesAndProceduresEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class DiagnosesAndProceduresFactory implements FactoryBean<DiagnosesAndProceduresEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public DiagnosesAndProceduresEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public DiagnosesAndProceduresEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public DiagnosesAndProceduresEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for diagnosesAndProceduresWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosesAndProceduresWithNoRef before the main body here] end

		DiagnosesAndProceduresEntity newEntity = new DiagnosesAndProceduresEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Item Type here] off begin
		String randomStringForItemType = mockNeat
				.strings()
				.get();
		newEntity.setItemType(randomStringForItemType);
		// % protected region % [Add customisation for Item Type here] end
		// % protected region % [Add customisation for Item Code here] off begin
		String randomStringForItemCode = mockNeat
				.strings()
				.get();
		newEntity.setItemCode(randomStringForItemCode);
		// % protected region % [Add customisation for Item Code here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringForDescription = mockNeat
				.strings()
				.get();
		newEntity.setDescription(randomStringForDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for diagnosesAndProceduresWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosesAndProceduresWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne BPJS Diagnose here] off begin
			// Incoming One to One reference
			var bpjsDiagnoseFactory = new BpjsDiagnoseFactory();
			newEntity.setBpjsDiagnose(bpjsDiagnoseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne BPJS Diagnose here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne BPJS Diagnose PRB here] off begin
			// Incoming One to One reference
			var bpjsDiagnosePRBFactory = new BpjsDiagnosePRBFactory();
			newEntity.setBpjsDiagnosePRB(bpjsDiagnosePRBFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne BPJS Diagnose PRB here] end
			// % protected region % [Override the reference inclusions for outgoingOneToOne Master ICD 10] off begin
			// Outgoing one to one reference
			var masterICD10Factory = new Icd10Factory();
			newEntity.setMasterICD10(masterICD10Factory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Master ICD 10] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Master ICD 9 CM] off begin
			// Outgoing one to one reference
			var masterICD9CMFactory = new Icd9CMFactory();
			newEntity.setMasterICD9CM(masterICD9CMFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Master ICD 9 CM] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Admission ICD 10 here] off begin
			// Outgoing one to many reference
			var admissionICD10Factory = new RegistrationFactory();
			newEntity.setAdmissionICD10(Collections.singletonList(admissionICD10Factory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Admission ICD 10 here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Admission ICD 9 CM here] off begin
			// Outgoing one to many reference
			var admissionICD9CMFactory = new RegistrationFactory();
			newEntity.setAdmissionICD9CM(Collections.singletonList(admissionICD9CMFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Admission ICD 9 CM here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany CPPT ICD 10 here] off begin
			// Outgoing one to many reference
			var cpptICD10Factory = new DailyCareCPPTFactory();
			newEntity.setCpptICD10(Collections.singletonList(cpptICD10Factory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany CPPT ICD 10 here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany CPPT ICD 9 CM here] off begin
			// Outgoing one to many reference
			var cpptICD9CMFactory = new DailyCareCPPTFactory();
			newEntity.setCpptICD9CM(Collections.singletonList(cpptICD9CMFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany CPPT ICD 9 CM here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Discharge ICD 10 here] off begin
			// Outgoing one to many reference
			var dischargeICD10Factory = new MedicalCertificateDischargeResumeFactory();
			newEntity.setDischargeICD10(Collections.singletonList(dischargeICD10Factory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Discharge ICD 10 here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Discharge ICD 9 CM here] off begin
			// Outgoing one to many reference
			var dischargeICD9CMFactory = new MedicalCertificateDischargeResumeFactory();
			newEntity.setDischargeICD9CM(Collections.singletonList(dischargeICD9CMFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Discharge ICD 9 CM here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany ICD 10 here] off begin
			// Outgoing one to many reference
			var icd10Factory = new DiagnosisExaminationRecordFactory();
			newEntity.setIcd10(Collections.singletonList(icd10Factory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany ICD 10 here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany ICD 9 CM here] off begin
			// Outgoing one to many reference
			var icd9CMFactory = new DiagnosisExaminationRecordFactory();
			newEntity.setIcd9CM(Collections.singletonList(icd9CMFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany ICD 9 CM here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoices ICD 10 here] off begin
			// Outgoing one to many reference
			var invoicesICD10Factory = new InvoiceFactory();
			newEntity.setInvoicesICD10(Collections.singletonList(invoicesICD10Factory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoices ICD 10 here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoices ICD 9 CM here] off begin
			// Outgoing one to many reference
			var invoicesICD9CMFactory = new InvoiceFactory();
			newEntity.setInvoicesICD9CM(Collections.singletonList(invoicesICD9CMFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoices ICD 9 CM here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Post Operative ICD 10 here] off begin
			// Outgoing one to many reference
			var postOperativeICD10Factory = new PostOperativeDetailsFactory();
			newEntity.setPostOperativeICD10(Collections.singletonList(postOperativeICD10Factory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Post Operative ICD 10 here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Post Operative ICD 9 CM here] off begin
			// Outgoing one to many reference
			var postOperativeICD9CMFactory = new PostOperativeDetailsFactory();
			newEntity.setPostOperativeICD9CM(Collections.singletonList(postOperativeICD9CMFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Post Operative ICD 9 CM here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Pre Surgery ICD 10 here] off begin
			// Outgoing one to many reference
			var preSurgeryICD10Factory = new PreoperativeRecordsFactory();
			newEntity.setPreSurgeryICD10(Collections.singletonList(preSurgeryICD10Factory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Pre Surgery ICD 10 here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Pre Surgery ICD 9 CM here] off begin
			// Outgoing one to many reference
			var preSurgeryICD9CMFactory = new PreoperativeRecordsFactory();
			newEntity.setPreSurgeryICD9CM(Collections.singletonList(preSurgeryICD9CMFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Pre Surgery ICD 9 CM here] end

			// % protected region % [Override the reference inclusion for outgoingManyToMany Diagnosis Nandas here] off begin
			// Outgoing many to many reference
			var diagnosisNandasFactory = new DiagnosisNandaFactory();
			newEntity.setDiagnosisNandas(Collections.singletonList(diagnosisNandasFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingManyToMany Diagnosis Nandas here] end

		}

		// % protected region % [Apply any additional logic for diagnosesAndProcedures with ref here] off begin
		// % protected region % [Apply any additional logic for diagnosesAndProcedures with ref here] end

		return newEntity;
	}

	@Override
	public Class<DiagnosesAndProceduresEntity> getObjectType() {
		return DiagnosesAndProceduresEntity.class;
	}
}