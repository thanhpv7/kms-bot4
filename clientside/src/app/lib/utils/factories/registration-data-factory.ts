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
import {RegistrationModel} from '../../../models/registration/registration.model';
import * as faker from 'faker';

export class RegistrationDataFactory extends AbstractDataFactory<RegistrationModel> {

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

	create(): RegistrationModel {
		let newModel = new RegistrationModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): RegistrationModel[] {
		let newModels: RegistrationModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Registration, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: RegistrationModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.registrationNumber = faker.random.words();
		model.scheduledDate = new Date();
		model.actualInDate = new Date();
		model.dismissalDate = new Date();
		model.dismissalType = faker.random.words();
		model.queueNo = faker.random.number();
		model.duration = faker.random.number();
		model.treatmentClass = faker.random.words();
		model.bookedTreatmentClass = faker.random.words();
		model.shift = faker.random.words();
		model.cito = faker.random.boolean();
		model.oneDayCare = faker.random.boolean();
		model.referral = faker.random.boolean();
		model.registrationStatus = faker.random.words();
		model.referralType = faker.random.words();
		model.purpose = faker.random.words();
		model.referralNotes = faker.random.words();
		model.admissionDiagnosis = faker.random.words();
		model.uploadedDateTime = new Date();
		model.visitStatus = faker.random.words();
		model.instruction = faker.random.words();
		model.isAnAppointment = faker.random.boolean();
		model.referralNumber = faker.random.words();
		model.notes = faker.random.words();
		model.kodepoli = faker.random.words();
		model.deathCertificateNo = faker.random.words();
		model.timeOfDeath = new Date();
		model.dismissalReferral = faker.random.boolean();
		model.dismissalReferralDetail = faker.random.words();
		model.dismissalReferralType = faker.random.words();
		model.dismissalReferringNotes = faker.random.words();
		model.patientIsReferredBack = faker.random.boolean();
		model.mcuPackage = faker.random.words();
		model.parentRegistrationNumber = faker.random.words();
		model.isUnknownPatient = faker.random.boolean();
		model.otherReferredFacility = faker.random.words();
		model.otherReferredStaff = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
