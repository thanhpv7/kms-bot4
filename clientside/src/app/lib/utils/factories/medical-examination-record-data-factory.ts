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
import {MedicalExaminationRecordModel} from '../../../models/medicalExaminationRecord/medical_examination_record.model';
import * as faker from 'faker';

export class MedicalExaminationRecordDataFactory extends AbstractDataFactory<MedicalExaminationRecordModel> {

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

	create(): MedicalExaminationRecordModel {
		let newModel = new MedicalExaminationRecordModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): MedicalExaminationRecordModel[] {
		let newModels: MedicalExaminationRecordModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Medical Examination Record, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: MedicalExaminationRecordModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.diastole = faker.random.number();
		model.systole = faker.random.number();
		model.pulse = faker.random.number();
		model.bpStandingSystole = faker.random.number();
		model.bpStandingDiastole = faker.random.number();
		model.pulseRegularity = faker.random.words();
		model.pulseStrength = faker.random.words();
		model.temperature = faker.random.number();
		model.temperatureScale = faker.random.words();
		model.gcsEyes = faker.random.words();
		model.gcsVerbal = faker.random.words();
		model.gcsMotor = faker.random.words();
		model.totalGCSScore = faker.random.number();
		model.consciousness = faker.random.words();
		model.height = faker.random.number();
		model.heightScale = faker.random.words();
		model.weight = faker.random.number();
		model.weightScale = faker.random.words();
		model.bmi = faker.random.number();
		model.respiratory = faker.random.number();
		model.oxygenSaturation = faker.random.number();
		model.waistCircumference = faker.random.number();
		model.waistCircumferenceUnit = faker.random.words();
		model.nutritionStatus = faker.random.words();
		model.painScale = faker.random.number();
		model.painScaleUsed = faker.random.words();
		model.riskFallScale = faker.random.number();
		model.objective = faker.random.words();
		model.riskFallScaleUsed = faker.random.words();
		model.subjective = faker.random.words();
		model.plan = faker.random.words();
		model.purpose = faker.random.words();
		model.examinationSubCase = faker.random.words();
		model.accidentalType = faker.random.words();
		model.serviceCase = faker.random.words();
		model.accidentalSubType = faker.random.words();
		model.additionalNotes = faker.random.words();
		model.dentalProcedure = faker.random.words();
		model.psychiatryCase = faker.random.words();
		model.therapy = faker.random.words();
		model.familyPlanning = faker.random.boolean();
		model.condition = faker.random.words();
		model.familyPlanningCase = faker.random.words();
		model.previousContraceptiveMethod = faker.random.words();
		model.sideEffects = faker.random.words();
		model.complication = faker.random.words();
		model.contraseptiveMethod = faker.random.words();
		model.visitType = faker.random.words();
		model.hearingTestMethod = faker.random.words();
		model.hearingTestNotes = faker.random.words();
		model.hearingLossCategory = faker.random.words();
		model.hearingLossNotes = faker.random.words();
		model.eyePositionRightEye = faker.random.words();
		model.eyePositionLeftEye = faker.random.words();
		model.muscleBalanceRightEye = faker.random.words();
		model.muscleBalanceLeftEye = faker.random.words();
		model.visualFieldRightEye = faker.random.words();
		model.visualFieldLeftEye = faker.random.words();
		model.ocularFunduscopyRightEye = faker.random.words();
		model.ocularFunduscopyLeftEye = faker.random.words();
		model.intraocularPressureRightEye = faker.random.words();
		model.intraocularPressureLeftEye = faker.random.words();
		model.colorBlindness = faker.random.words();
		model.visualAcuityRightEye = faker.random.words();
		model.visualAcuityLeftEye = faker.random.words();
		model.correctionRightEye = faker.random.words();
		model.correctionLeftEye = faker.random.words();
		model.additionRightEye = faker.random.words();
		model.additionLeftEye = faker.random.words();
		model.occlusion = faker.random.words();
		model.torusPalatinus = faker.random.words();
		model.torusMandibularis = faker.random.words();
		model.palatum = faker.random.words();
		model.diastema = faker.random.boolean();
		model.diastemaNotes = faker.random.words();
		model.toothAnomaly = faker.random.boolean();
		model.toothAnomalyNotes = faker.random.words();
		model.otherDentalNotes = faker.random.words();
		model.decayed = faker.random.words();
		model.missing = faker.random.words();
		model.filled = faker.random.words();
		model.totalPhotograph = faker.random.words();
		model.photographType = faker.random.words();
		model.totalRontgenPhotograph = faker.random.words();
		model.rontgenPhotographType = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
