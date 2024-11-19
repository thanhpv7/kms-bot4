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
import {PatientConsentModel} from '../../../models/patientConsent/patient_consent.model';
import * as faker from 'faker';

export class PatientConsentDataFactory extends AbstractDataFactory<PatientConsentModel> {

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

	create(): PatientConsentModel {
		let newModel = new PatientConsentModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): PatientConsentModel[] {
		let newModels: PatientConsentModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Patient Consent, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: PatientConsentModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.consentDateTime = new Date();
		model.consentOnPaymentTerms = faker.random.words();
		model.consentOnRightsAndObligations = faker.random.words();
		model.consentOnHospitalRegulations = faker.random.words();
		model.needInterpreter = faker.random.words();
		model.needReligiousCounselor = faker.random.words();
		model.dgsResultsReleasedToInsurer = faker.random.words();
		model.dgsResultsReleasedToStudents = faker.random.words();
		model.recordReleasedToFamilyMember = faker.random.words();
		model.recordReleasedToCertainHealthFacilities = faker.random.words();
		model.staffSignature = faker.random.words();
		model.consentingPartySignature = faker.random.words();
		model.consentingPartyType = faker.random.words();
		model.consentingPartyName = faker.random.words();
		model.readAndSignSatusehat = faker.random.boolean();
		model.informationReleasedToSatusehat = faker.random.words();
		model.emrReleasedToSatusehat = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
