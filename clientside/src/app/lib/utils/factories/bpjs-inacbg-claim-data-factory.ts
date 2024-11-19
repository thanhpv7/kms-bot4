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
import {BpjsINACBGClaimModel} from '../../../models/bpjsINACBGClaim/bpjs_inacbg_claim.model';
import * as faker from 'faker';

export class BpjsINACBGClaimDataFactory extends AbstractDataFactory<BpjsINACBGClaimModel> {

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

	create(): BpjsINACBGClaimModel {
		let newModel = new BpjsINACBGClaimModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): BpjsINACBGClaimModel[] {
		let newModels: BpjsINACBGClaimModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type BPJS INACBG Claim, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: BpjsINACBGClaimModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.claimNo = faker.random.words();
		model.patientID = faker.random.words();
		model.invoiceNumber = faker.random.words();
		model.bpjsCardNo = faker.random.words();
		model.sepNo = faker.random.words();
		model.treatmentType = faker.random.words();
		model.treatmentClass = faker.random.words();
		model.admissionDate = new Date();
		model.dismissalDate = new Date();
		model.los = faker.random.words();
		model.dismissal = faker.random.words();
		model.responsibleDoctor = faker.random.words();
		model.weight = faker.random.number();
		model.adl = faker.random.number();
		model.claimStatus = faker.random.words();
		model.sepStatus = faker.random.words();
		model.hospitalTariff = faker.random.number();
		model.referralLetter = faker.random.words();
		model.thirdSelLevel = faker.random.words();
		model.staffName = faker.random.words();
		model.dateGrouping = new Date();
		model.inacbgTariff = faker.random.words();
		model.description = faker.random.words();
		model.cbgType = faker.random.words();
		model.tariff = faker.random.number();
		model.subAcute = faker.random.words();
		model.subAcuteCode = faker.random.words();
		model.subAcuteTariff = faker.random.number();
		model.chronic = faker.random.words();
		model.chronicCode = faker.random.words();
		model.chronicTariff = faker.random.number();
		model.resultSpecProcedure = faker.random.words();
		model.resultSpecDrug = faker.random.words();
		model.resultSpecInvestigation = faker.random.words();
		model.resultSpecProsthesis = faker.random.words();
		model.hospitalClass = faker.random.words();
		model.tariffType = faker.random.words();
		model.totalTariff = faker.random.number();
		model.visitDate = new Date();
		model.specProcedureTariff = faker.random.number();
		model.specDrugTariff = faker.random.number();
		model.specInvestigationTariff = faker.random.number();
		model.specProsthesisTariff = faker.random.number();
		model.upgradeFlag = faker.random.boolean();
		model.hcuFlag = faker.random.boolean();
		model.grouperFlag = faker.random.boolean();
		model.nonSurgeryProcedure = faker.random.number();
		model.surgeryProcedure = faker.random.number();
		model.consultation = faker.random.number();
		model.specialist = faker.random.number();
		model.nursing = faker.random.number();
		model.diagnostic = faker.random.number();
		model.radiology = faker.random.number();
		model.laboratory = faker.random.number();
		model.bloodService = faker.random.number();
		model.rehabilitation = faker.random.number();
		model.bedAccomodation = faker.random.number();
		model.intensiveCare = faker.random.number();
		model.drugs = faker.random.number();
		model.medicalEquipment = faker.random.number();
		model.dispensedDisposable = faker.random.number();
		model.equipmentRental = faker.random.number();
		model.icd10Code = faker.random.words();
		model.icd10Desc = faker.random.words();
		model.icd10Tariff = faker.random.number();
		model.icd9cmCode = faker.random.words();
		model.icd9cmDesc = faker.random.words();
		model.icd9cmTariff = faker.random.number();
		model.chronicDrugs = faker.random.number();
		model.chemotherapyDrugs = faker.random.number();
		model.classUpgrade = faker.random.words();
		model.highCareUnit = faker.random.words();
		model.inacbgClaimCreated = faker.random.boolean();
		model.inacbgResponse = faker.random.words();
		model.totalInvoice = faker.random.number();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
