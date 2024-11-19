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
import {HospitalBranchInformationModel} from '../../../models/hospitalBranchInformation/hospital_branch_information.model';
import * as faker from 'faker';

export class HospitalBranchInformationDataFactory extends AbstractDataFactory<HospitalBranchInformationModel> {

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

	create(): HospitalBranchInformationModel {
		let newModel = new HospitalBranchInformationModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): HospitalBranchInformationModel[] {
		let newModels: HospitalBranchInformationModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Hospital Branch Information, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: HospitalBranchInformationModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.hospitalCode = faker.random.words();
		model.hospitalName = faker.random.words();
		model.hospitalType = faker.random.words();
		model.hospitalClass = faker.random.words();
		model.hospitalDirectorName = faker.random.words();
		model.dateOfRegistration = new Date();
		model.hospitalCorporationName = faker.random.words();
		model.isBPJSFacility = faker.random.boolean();
		model.address = faker.random.words();
		model.city = faker.random.words();
		model.postcode = faker.random.words();
		model.phoneNumber = faker.random.words();
		model.fax = faker.random.words();
		model.email = faker.random.words();
		model.website = faker.random.words();
		model.contactPerson = faker.random.words();
		model.contactPersonPhoneNumber = faker.random.words();
		model.contactPersonEmail = faker.random.words();
		model.landSize = faker.random.words();
		model.buildingSize = faker.random.words();
		model.permitNumber = faker.random.words();
		model.permitDate = new Date();
		model.authorizedBy = faker.random.words();
		model.permitType = faker.random.words();
		model.validUntil = new Date();
		model.hospitalBranchCorporationName = faker.random.words();
		model.hospitalBranchCorporationStatus = faker.random.words();
		model.accreditationType = faker.random.words();
		model.accreditationLevel = faker.random.words();
		model.accreditationDate = new Date();
		model.bedPerinatology = faker.random.words();
		model.suiteClass = faker.random.words();
		model.vvipClass = faker.random.words();
		model.vipAClass = faker.random.words();
		model.vipBClass = faker.random.words();
		model.vipCClass = faker.random.words();
		model.mainClass = faker.random.words();
		model.classI = faker.random.words();
		model.iiClass = faker.random.words();
		model.iiiAClass = faker.random.words();
		model.iiiBClass = faker.random.words();
		model.specialClass = faker.random.words();
		model.icu = faker.random.words();
		model.picu = faker.random.words();
		model.nicu = faker.random.words();
		model.hcu = faker.random.words();
		model.iccu = faker.random.words();
		model.isolationRoom = faker.random.words();
		model.emergencyRoom = faker.random.words();
		model.maternityRoom = faker.random.words();
		model.operatingRoom = faker.random.words();
		model.doctorSpA = faker.random.words();
		model.doctorSpOG = faker.random.words();
		model.doctorSpPD = faker.random.words();
		model.doctorSpB = faker.random.words();
		model.doctorSpRad = faker.random.words();
		model.doctorSpRm = faker.random.words();
		model.doctorSpAn = faker.random.words();
		model.doctorSpJp = faker.random.words();
		model.doctorSpM = faker.random.words();
		model.doctorSpTHT = faker.random.words();
		model.doctorSpKj = faker.random.words();
		model.doctorSpP = faker.random.words();
		model.doctorSpPK = faker.random.words();
		model.doctorSpS = faker.random.words();
		model.subSpecialistDoctor = faker.random.words();
		model.otherSpecialistDoctor = faker.random.words();
		model.generalPractice = faker.random.words();
		model.dentist = faker.random.words();
		model.specialistDentist = faker.random.words();
		model.nurse = faker.random.words();
		model.midwife = faker.random.words();
		model.pharmacist = faker.random.words();
		model.otherMedicalStaff = faker.random.words();
		model.nonMedicalStaff = faker.random.words();
		model.timezone = faker.random.words();
		model.healthFacilityLevel = faker.random.words();
		model.satuSehatIntegration = faker.random.boolean();
		model.taxIdentification = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
