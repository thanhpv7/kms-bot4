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

import {AbstractDataFactory} from './abstract-data-factory';
import {MedicalRecordNextVerificationChecklistModel} from '../../../models/medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model';
import * as faker from 'faker';

export class MedicalRecordNextVerificationChecklistDataFactory extends AbstractDataFactory<MedicalRecordNextVerificationChecklistModel> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
	) {
		super(
			// % protected region % [Add any additional constructor arguments here] off begin
			// % protected region % [Add any additional constructor arguments here] end
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	create(): MedicalRecordNextVerificationChecklistModel {
		let newModel = new MedicalRecordNextVerificationChecklistModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): MedicalRecordNextVerificationChecklistModel[] {
		let newModels: MedicalRecordNextVerificationChecklistModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Medical Record Next Verification Checklist, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: MedicalRecordNextVerificationChecklistModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.outVitalSign = faker.random.boolean();
		model.outAnamnesis = faker.random.boolean();
		model.outPhysicalExamination = faker.random.boolean();
		model.outDiagnosis = faker.random.boolean();
		model.outDismissalType = faker.random.boolean();
		model.outDismissalDateAndTime = faker.random.boolean();
		model.inpVitalSign = faker.random.boolean();
		model.inpDailyCareDoctorNotes = faker.random.boolean();
		model.inpDailyCareDoctorNotesNA = faker.random.boolean();
		model.inpDailyCareNursingNotes = faker.random.boolean();
		model.inpDailyCareNursingNotesNA = faker.random.boolean();
		model.inpDailyCareProgressNotes = faker.random.boolean();
		model.inpDailyCareProgressNotesNA = faker.random.boolean();
		model.inpDismissalDiagnosis = faker.random.boolean();
		model.inpDismissalType = faker.random.boolean();
		model.inpDismissalDateAndTime = faker.random.boolean();
		model.inpDismissalCondition = faker.random.boolean();
		model.drAdmissionDiagnosis = faker.random.boolean();
		model.drObservationDoctorNotes = faker.random.boolean();
		model.drObservationDoctorNotesNA = faker.random.boolean();
		model.drObservationNursingNotes = faker.random.boolean();
		model.drObservationNursingNotesNA = faker.random.boolean();
		model.drObservationProgressNotes = faker.random.boolean();
		model.drObservationProgressNotesNA = faker.random.boolean();
		model.drDismissalDiagnosis = faker.random.boolean();
		model.drDismissalType = faker.random.boolean();
		model.drDismissalDateAndTime = faker.random.boolean();
		model.otPreOperativeDiagnosis = faker.random.boolean();
		model.otPreOperativeNotesSurgery = faker.random.boolean();
		model.otPreOperativeNotesAnaesthesiology = faker.random.boolean();
		model.otIntraOperativeNotesSurgery = faker.random.boolean();
		model.otIntraOperativeNotesAnaesthesiology = faker.random.boolean();
		model.otPostOperativeNotesSurgery = faker.random.boolean();
		model.otPostOperativeNotesAnaesthesiology = faker.random.boolean();
		model.otPostOperativeDiagnosis = faker.random.boolean();
		model.otDismissalType = faker.random.boolean();
		model.otDismissalDateAndTime = faker.random.boolean();
		model.dsResponsibleStaff = faker.random.boolean();
		model.dsInterpretation = faker.random.boolean();
		model.notes = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
