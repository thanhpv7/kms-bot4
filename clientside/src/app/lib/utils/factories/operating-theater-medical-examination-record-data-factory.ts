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
import {OperatingTheaterMedicalExaminationRecordModel} from '../../../models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import * as faker from 'faker';

export class OperatingTheaterMedicalExaminationRecordDataFactory extends AbstractDataFactory<OperatingTheaterMedicalExaminationRecordModel> {

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

	create(): OperatingTheaterMedicalExaminationRecordModel {
		let newModel = new OperatingTheaterMedicalExaminationRecordModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): OperatingTheaterMedicalExaminationRecordModel[] {
		let newModels: OperatingTheaterMedicalExaminationRecordModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Operating Theater Medical Examination Record, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: OperatingTheaterMedicalExaminationRecordModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.hasConfirmedIdentity = faker.random.boolean();
		model.anesthesiaSafetyCheckCompleted = faker.random.boolean();
		model.pulseOxymeterFunctioning = faker.random.boolean();
		model.siteMarked = faker.random.words();
		model.hasKnownAllergy = faker.random.words();
		model.hasDifficultAirwayRisk = faker.random.words();
		model.hasRiskOfBloodLoss = faker.random.words();
		model.teamMemberIntroduced = faker.random.boolean();
		model.professionalConfirmedPatient = faker.random.boolean();
		model.antibioticProphylaxisGiven = faker.random.words();
		model.essentialImagingDisplayed = faker.random.words();
		model.whareAreCriticalSteps = faker.random.boolean();
		model.howLongCaseTake = faker.random.boolean();
		model.whatIsAnticipatedBloodLoss = faker.random.boolean();
		model.anyPatientSpecificConcerns = faker.random.boolean();
		model.sterlityBeenConfirmed = faker.random.boolean();
		model.equipmentIssuesAnyConcern = faker.random.boolean();
		model.nameOfProcedure = faker.random.boolean();
		model.instrumentsNeedCountCorrect = faker.random.boolean();
		model.specimenIsLabeled = faker.random.boolean();
		model.equipmentProblemsAddressed = faker.random.boolean();
		model.keyConcernsForRecovery = faker.random.boolean();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
