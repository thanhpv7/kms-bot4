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
package kmsweb.inject.modules.entities;

import kmsweb.entities.*;
import kmsweb.entities.enums.*;
import kmsweb.inject.factories.*;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.UUID;

// % protected region % [Apply any additional imports here] off begin
// % protected region % [Apply any additional imports here] end

/**
 * Guice module for Medical Record Initial Checklist used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicalRecordInitialChecklistModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicalRecordInitialChecklistModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicalRecordInitialChecklistModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicalRecordInitialChecklistEntityFactory medicalRecordInitialChecklistEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicalRecordInitialChecklistEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicalRecordInitialChecklistEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicalRecordInitialChecklistEntityFactory");

		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistEntityFactory before the main body here] end

		MedicalRecordInitialChecklistEntityFactory entityFactory = new MedicalRecordInitialChecklistEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicalRecordInitialChecklistEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicalRecordInitialChecklistEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistEntityFactory after the main body here] end

		log.trace("Created MedicalRecordInitialChecklistEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medical Record Initial Checklist entity with no references set.
	 */
	@Provides
	@Named("medicalRecordInitialChecklistEntityWithNoRef")
	public MedicalRecordInitialChecklistEntity medicalRecordInitialChecklistEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicalRecordInitialChecklistEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalRecordInitialChecklistEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicalRecordInitialChecklistEntity with no reference");

		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistWithNoRef before the main body here] end

		MedicalRecordInitialChecklistEntity newEntity = new MedicalRecordInitialChecklistEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Out Vital Sign here] off begin
		newEntity.setOutVitalSign(mock.bools().get());
		// % protected region % [Add customisation for Out Vital Sign here] end
		// % protected region % [Add customisation for Out Anamnesis here] off begin
		newEntity.setOutAnamnesis(mock.bools().get());
		// % protected region % [Add customisation for Out Anamnesis here] end
		// % protected region % [Add customisation for Out Physical Examination here] off begin
		newEntity.setOutPhysicalExamination(mock.bools().get());
		// % protected region % [Add customisation for Out Physical Examination here] end
		// % protected region % [Add customisation for Out Diagnosis here] off begin
		newEntity.setOutDiagnosis(mock.bools().get());
		// % protected region % [Add customisation for Out Diagnosis here] end
		// % protected region % [Add customisation for Out Dismissal Type here] off begin
		newEntity.setOutDismissalType(mock.bools().get());
		// % protected region % [Add customisation for Out Dismissal Type here] end
		// % protected region % [Add customisation for Out Dismissal Date and Time here] off begin
		newEntity.setOutDismissalDateAndTime(mock.bools().get());
		// % protected region % [Add customisation for Out Dismissal Date and Time here] end
		// % protected region % [Add customisation for Inp Vital Sign here] off begin
		newEntity.setInpVitalSign(mock.bools().get());
		// % protected region % [Add customisation for Inp Vital Sign here] end
		// % protected region % [Add customisation for Inp Daily Care Doctor Notes here] off begin
		newEntity.setInpDailyCareDoctorNotes(mock.bools().get());
		// % protected region % [Add customisation for Inp Daily Care Doctor Notes here] end
		// % protected region % [Add customisation for Inp Daily Care Doctor Notes NA here] off begin
		newEntity.setInpDailyCareDoctorNotesNA(mock.bools().get());
		// % protected region % [Add customisation for Inp Daily Care Doctor Notes NA here] end
		// % protected region % [Add customisation for Inp Daily Care Nursing Notes here] off begin
		newEntity.setInpDailyCareNursingNotes(mock.bools().get());
		// % protected region % [Add customisation for Inp Daily Care Nursing Notes here] end
		// % protected region % [Add customisation for Inp Daily Care Nursing Notes NA here] off begin
		newEntity.setInpDailyCareNursingNotesNA(mock.bools().get());
		// % protected region % [Add customisation for Inp Daily Care Nursing Notes NA here] end
		// % protected region % [Add customisation for Inp Daily Care Progress Notes here] off begin
		newEntity.setInpDailyCareProgressNotes(mock.bools().get());
		// % protected region % [Add customisation for Inp Daily Care Progress Notes here] end
		// % protected region % [Add customisation for Inp Daily Care Progress Notes NA here] off begin
		newEntity.setInpDailyCareProgressNotesNA(mock.bools().get());
		// % protected region % [Add customisation for Inp Daily Care Progress Notes NA here] end
		// % protected region % [Add customisation for Inp Dismissal Diagnosis here] off begin
		newEntity.setInpDismissalDiagnosis(mock.bools().get());
		// % protected region % [Add customisation for Inp Dismissal Diagnosis here] end
		// % protected region % [Add customisation for Inp Dismissal Type here] off begin
		newEntity.setInpDismissalType(mock.bools().get());
		// % protected region % [Add customisation for Inp Dismissal Type here] end
		// % protected region % [Add customisation for Inp Dismissal Date and Time here] off begin
		newEntity.setInpDismissalDateAndTime(mock.bools().get());
		// % protected region % [Add customisation for Inp Dismissal Date and Time here] end
		// % protected region % [Add customisation for Inp Dismissal Condition here] off begin
		newEntity.setInpDismissalCondition(mock.bools().get());
		// % protected region % [Add customisation for Inp Dismissal Condition here] end
		// % protected region % [Add customisation for DR Admission Diagnosis here] off begin
		newEntity.setDrAdmissionDiagnosis(mock.bools().get());
		// % protected region % [Add customisation for DR Admission Diagnosis here] end
		// % protected region % [Add customisation for DR Observation Doctor Notes here] off begin
		newEntity.setDrObservationDoctorNotes(mock.bools().get());
		// % protected region % [Add customisation for DR Observation Doctor Notes here] end
		// % protected region % [Add customisation for DR Observation Doctor Notes NA here] off begin
		newEntity.setDrObservationDoctorNotesNA(mock.bools().get());
		// % protected region % [Add customisation for DR Observation Doctor Notes NA here] end
		// % protected region % [Add customisation for DR Observation Nursing Notes here] off begin
		newEntity.setDrObservationNursingNotes(mock.bools().get());
		// % protected region % [Add customisation for DR Observation Nursing Notes here] end
		// % protected region % [Add customisation for DR Observation Nursing Notes NA here] off begin
		newEntity.setDrObservationNursingNotesNA(mock.bools().get());
		// % protected region % [Add customisation for DR Observation Nursing Notes NA here] end
		// % protected region % [Add customisation for DR Observation Progress Notes here] off begin
		newEntity.setDrObservationProgressNotes(mock.bools().get());
		// % protected region % [Add customisation for DR Observation Progress Notes here] end
		// % protected region % [Add customisation for DR Observation Progress Notes NA here] off begin
		newEntity.setDrObservationProgressNotesNA(mock.bools().get());
		// % protected region % [Add customisation for DR Observation Progress Notes NA here] end
		// % protected region % [Add customisation for DR Dismissal Diagnosis here] off begin
		newEntity.setDrDismissalDiagnosis(mock.bools().get());
		// % protected region % [Add customisation for DR Dismissal Diagnosis here] end
		// % protected region % [Add customisation for DR Dismissal Type here] off begin
		newEntity.setDrDismissalType(mock.bools().get());
		// % protected region % [Add customisation for DR Dismissal Type here] end
		// % protected region % [Add customisation for DR Dismissal Date and Time here] off begin
		newEntity.setDrDismissalDateAndTime(mock.bools().get());
		// % protected region % [Add customisation for DR Dismissal Date and Time here] end
		// % protected region % [Add customisation for OT Pre Operative Diagnosis here] off begin
		newEntity.setOtPreOperativeDiagnosis(mock.bools().get());
		// % protected region % [Add customisation for OT Pre Operative Diagnosis here] end
		// % protected region % [Add customisation for OT Pre Operative Notes Surgery here] off begin
		newEntity.setOtPreOperativeNotesSurgery(mock.bools().get());
		// % protected region % [Add customisation for OT Pre Operative Notes Surgery here] end
		// % protected region % [Add customisation for OT Pre Operative Notes Anaesthesiology here] off begin
		newEntity.setOtPreOperativeNotesAnaesthesiology(mock.bools().get());
		// % protected region % [Add customisation for OT Pre Operative Notes Anaesthesiology here] end
		// % protected region % [Add customisation for OT Intra Operative Notes Surgery here] off begin
		newEntity.setOtIntraOperativeNotesSurgery(mock.bools().get());
		// % protected region % [Add customisation for OT Intra Operative Notes Surgery here] end
		// % protected region % [Add customisation for OT Intra Operative Notes Anaesthesiology here] off begin
		newEntity.setOtIntraOperativeNotesAnaesthesiology(mock.bools().get());
		// % protected region % [Add customisation for OT Intra Operative Notes Anaesthesiology here] end
		// % protected region % [Add customisation for OT Post Operative Notes Surgery here] off begin
		newEntity.setOtPostOperativeNotesSurgery(mock.bools().get());
		// % protected region % [Add customisation for OT Post Operative Notes Surgery here] end
		// % protected region % [Add customisation for OT Post Operative Notes Anaesthesiology here] off begin
		newEntity.setOtPostOperativeNotesAnaesthesiology(mock.bools().get());
		// % protected region % [Add customisation for OT Post Operative Notes Anaesthesiology here] end
		// % protected region % [Add customisation for OT Post Operative Diagnosis here] off begin
		newEntity.setOtPostOperativeDiagnosis(mock.bools().get());
		// % protected region % [Add customisation for OT Post Operative Diagnosis here] end
		// % protected region % [Add customisation for OT Dismissal Type here] off begin
		newEntity.setOtDismissalType(mock.bools().get());
		// % protected region % [Add customisation for OT Dismissal Type here] end
		// % protected region % [Add customisation for OT Dismissal Date and Time here] off begin
		newEntity.setOtDismissalDateAndTime(mock.bools().get());
		// % protected region % [Add customisation for OT Dismissal Date and Time here] end
		// % protected region % [Add customisation for DS Responsible Staff here] off begin
		newEntity.setDsResponsibleStaff(mock.bools().get());
		// % protected region % [Add customisation for DS Responsible Staff here] end
		// % protected region % [Add customisation for DS Interpretation here] off begin
		newEntity.setDsInterpretation(mock.bools().get());
		// % protected region % [Add customisation for DS Interpretation here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistWithNoRef after the main body here] end

		log.trace("Created entity of type MedicalRecordInitialChecklistEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medical Record Initial Checklist entities with no reference at all.
	 */
	@Provides
	@Named("medicalRecordInitialChecklistEntitiesWithNoRef")
	public Collection<MedicalRecordInitialChecklistEntity> medicalRecordInitialChecklistEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicalRecordInitialChecklistEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalRecordInitialChecklistEntitiesWithNoRef here] end
		MedicalRecordInitialChecklistEntityFactory medicalRecordInitialChecklistEntityFactory
	) {
		log.trace("Creating entities of type MedicalRecordInitialChecklistEntity with no reference");

		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistEntitiesWithNoRef before the main body here] end

		Collection<MedicalRecordInitialChecklistEntity> newEntities = medicalRecordInitialChecklistEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicalRecordInitialChecklistEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medical Record Initial Checklist entity with all references set.
	 */
	@Provides
	@Named("medicalRecordInitialChecklistEntityWithRefs")
	public MedicalRecordInitialChecklistEntity medicalRecordInitialChecklistEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicalRecordInitialChecklistEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalRecordInitialChecklistEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicalRecordInitialChecklistEntity with references");

		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistEntityWithRefs before the main body here] end

		MedicalRecordInitialChecklistEntity medicalRecordInitialChecklistEntity = injector.getInstance(Key.get(MedicalRecordInitialChecklistEntity.class, Names.named("medicalRecordInitialChecklistEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicalRecordInitialChecklistEntity with references");

		return medicalRecordInitialChecklistEntity;
	}

	/**
	 * Return a collection of Medical Record Initial Checklist entities with all references set.
	 */
	@Provides
	@Named("medicalRecordInitialChecklistEntitiesWithRefs")
	public Collection<MedicalRecordInitialChecklistEntity> medicalRecordInitialChecklistEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicalRecordInitialChecklistEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalRecordInitialChecklistEntitiesWithRefs here] end
		MedicalRecordInitialChecklistEntityFactory medicalRecordInitialChecklistEntityFactory
	) {
		log.trace("Creating entities of type MedicalRecordInitialChecklistEntity with references");

		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistEntitiesWithRefs before the main body here] end

		Collection<MedicalRecordInitialChecklistEntity> newEntities = medicalRecordInitialChecklistEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicalRecordInitialChecklistEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
