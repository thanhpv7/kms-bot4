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
import {FormGroup, Validators} from '@angular/forms';
import {Group, AbstractModel, ModelProperty, ModelPropertyType, ModelRelation, ModelRelationType} from '../../lib/models/abstract.model';
import {CoTreatingDoctorModel} from '../coTreatingDoctor/co_treating_doctor.model';
import {DeliveryProgressModel} from '../deliveryProgress/delivery_progress.model';
import {MedicalExaminationRecordModel} from '../medicalExaminationRecord/medical_examination_record.model';
import {NewbornDetailModel} from '../newbornDetail/newborn_detail.model';
import {StaffModel} from '../staff/staff.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class DeliveryMedicalExaminationRecordModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'pregnancyHistoryGravida',
		'pregnancyHistoryPartum',
		'pregnancyHistoryNotes',
		'lnmpStartDate',
		'lnmpEndDate',
		'approximateBirthDate',
		'gestationAgeWeeks',
		'gestationAgeDays',
		'tetanusVaccine1',
		'tetanusVaccine2',
		'deliveryType',
		'complicationsInPregnancy',
		'riskFactor',
		'fetalPresentation',
		'abdomenExamination',
		'fundalHeight',
		'fhrPerMinute',
		'estimatedFetalWeight',
		'leopold1',
		'leopold2',
		'leopold3',
		'leopold4',
		'geniteliaExterna',
		'geniteliaInterna',
		'vaginalExamination',
		'deliveryComplication',
		'deliveryNote',
		'normalDeliveryCase',
		'stage1Hour',
		'stage3Hour',
		'stage4Hour',
		'stage1Minute',
		'stage2Minute',
		'stage3Minute',
		'stage4Minute',
		'placenta',
		'perineum',
		'bleeding',
		'postpartumComplication',
		'newbornDelivered',
		'perineumInfection',
		'earlyBreastfeedingIntiation',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'pregnancyHistoryGravida',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'DeliveryMedicalExaminationRecordModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return DeliveryMedicalExaminationRecordModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	pregnancyHistoryGravida: string;

	/**
	 * .
	 */
	pregnancyHistoryPartum: string;

	/**
	 * .
	 */
	pregnancyHistoryAbortum: string;

	/**
	 * .
	 */
	pregnancyHistoryNotes: string;

	/**
	 * .
	 */
	lnmpStartDate: Date;

	/**
	 * .
	 */
	lnmpEndDate: Date;

	/**
	 * .
	 */
	approximateBirthDate: Date;

	/**
	 * .
	 */
	gestationAgeWeeks: number;

	/**
	 * .
	 */
	gestationAgeDays: number;

	/**
	 * .
	 */
	tetanusVaccine1: boolean = false;

	/**
	 * .
	 */
	tetanusVaccine2: boolean = false;

	/**
	 * .
	 */
	deliveryType: string;

	/**
	 * .
	 */
	complicationsInPregnancy: string;

	/**
	 * .
	 */
	riskFactor: string;

	/**
	 * .
	 */
	fetalPresentation: string;

	/**
	 * .
	 */
	abdomenExamination: string;

	/**
	 * .
	 */
	fundalHeight: string;

	/**
	 * .
	 */
	fhrPerMinute: string;

	/**
	 * .
	 */
	estimatedFetalWeight: string;

	/**
	 * .
	 */
	leopold1: string;

	/**
	 * .
	 */
	leopold2: string;

	/**
	 * .
	 */
	leopold3: string;

	/**
	 * .
	 */
	leopold4: string;

	/**
	 * .
	 */
	geniteliaExterna: string;

	/**
	 * .
	 */
	geniteliaInterna: string;

	/**
	 * .
	 */
	vaginalExamination: string;

	/**
	 * .
	 */
	deliveryComplication: string;

	/**
	 * .
	 */
	deliveryNote: string;

	/**
	 * .
	 */
	normalDeliveryCase: boolean = false;

	/**
	 * .
	 */
	stage1Hour: number;

	/**
	 * .
	 */
	unnamedInteger1: number;

	/**
	 * .
	 */
	stage3Hour: number;

	/**
	 * .
	 */
	stage4Hour: number;

	/**
	 * .
	 */
	stage1Minute: number;

	/**
	 * .
	 */
	stage2Minute: number;

	/**
	 * .
	 */
	stage3Minute: number;

	/**
	 * .
	 */
	stage4Minute: number;

	/**
	 * .
	 */
	placenta: string;

	/**
	 * .
	 */
	perineum: string;

	/**
	 * .
	 */
	bleeding: string;

	/**
	 * .
	 */
	postpartumComplication: string;

	/**
	 * .
	 */
	newbornDelivered: number;

	/**
	 * .
	 */
	perineumInfection: boolean = false;

	/**
	 * .
	 */
	earlyBreastfeedingIntiation: boolean = false;

	medicalExaminationRecordId: string;

	medicalExaminationRecord: MedicalExaminationRecordModel;

	midwifeId: string;

	midwife: StaffModel;

	additionalMidwivesIds: string[] = [];

	additionalMidwives: CoTreatingDoctorModel[];

	deliveryProgressesIds: string[] = [];

	deliveryProgresses: DeliveryProgressModel[];

	newbornDetailsIds: string[] = [];

	newbornDetails: NewbornDetailModel[];

	modelPropGroups: { [s: string]: Group } = DeliveryMedicalExaminationRecordModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'pregnancyHistoryGravida',
				// % protected region % [Set displayName for Pregnancy History Gravida here] off begin
				displayName: 'Pregnancy History Gravida',
				// % protected region % [Set displayName for Pregnancy History Gravida here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pregnancy History Gravida here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pregnancy History Gravida here] end
				// % protected region % [Set isSensitive for Pregnancy History Gravida here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pregnancy History Gravida here] end
				// % protected region % [Set readonly for Pregnancy History Gravida here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pregnancy History Gravida here] end
				validators: [
					// % protected region % [Add other validators for Pregnancy History Gravida here] off begin
					// % protected region % [Add other validators for Pregnancy History Gravida here] end
				],
				// % protected region % [Add any additional model attribute properties for Pregnancy History Gravida here] off begin
				// % protected region % [Add any additional model attribute properties for Pregnancy History Gravida here] end
			},
			{
				name: 'pregnancyHistoryPartum',
				// % protected region % [Set displayName for Pregnancy History Partum  here] off begin
				displayName: 'Pregnancy History Partum ',
				// % protected region % [Set displayName for Pregnancy History Partum  here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pregnancy History Partum  here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pregnancy History Partum  here] end
				// % protected region % [Set isSensitive for Pregnancy History Partum  here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pregnancy History Partum  here] end
				// % protected region % [Set readonly for Pregnancy History Partum  here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pregnancy History Partum  here] end
				validators: [
					// % protected region % [Add other validators for Pregnancy History Partum  here] off begin
					// % protected region % [Add other validators for Pregnancy History Partum  here] end
				],
				// % protected region % [Add any additional model attribute properties for Pregnancy History Partum  here] off begin
				// % protected region % [Add any additional model attribute properties for Pregnancy History Partum  here] end
			},
			{
				name: 'pregnancyHistoryAbortum',
				// % protected region % [Set displayName for Pregnancy History Abortum  here] off begin
				displayName: 'Pregnancy History Abortum ',
				// % protected region % [Set displayName for Pregnancy History Abortum  here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pregnancy History Abortum  here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pregnancy History Abortum  here] end
				// % protected region % [Set isSensitive for Pregnancy History Abortum  here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pregnancy History Abortum  here] end
				// % protected region % [Set readonly for Pregnancy History Abortum  here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pregnancy History Abortum  here] end
				validators: [
					// % protected region % [Add other validators for Pregnancy History Abortum  here] off begin
					// % protected region % [Add other validators for Pregnancy History Abortum  here] end
				],
				// % protected region % [Add any additional model attribute properties for Pregnancy History Abortum  here] off begin
				// % protected region % [Add any additional model attribute properties for Pregnancy History Abortum  here] end
			},
			{
				name: 'pregnancyHistoryNotes',
				// % protected region % [Set displayName for Pregnancy History Notes here] off begin
				displayName: 'Pregnancy History Notes',
				// % protected region % [Set displayName for Pregnancy History Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pregnancy History Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pregnancy History Notes here] end
				// % protected region % [Set isSensitive for Pregnancy History Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pregnancy History Notes here] end
				// % protected region % [Set readonly for Pregnancy History Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pregnancy History Notes here] end
				validators: [
					// % protected region % [Add other validators for Pregnancy History Notes here] off begin
					// % protected region % [Add other validators for Pregnancy History Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Pregnancy History Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Pregnancy History Notes here] end
			},
			{
				name: 'lnmpStartDate',
				// % protected region % [Set displayName for LNMP Start Date here] off begin
				displayName: 'LNMP Start Date',
				// % protected region % [Set displayName for LNMP Start Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for LNMP Start Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for LNMP Start Date here] end
				// % protected region % [Set isSensitive for LNMP Start Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for LNMP Start Date here] end
				// % protected region % [Set readonly for LNMP Start Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for LNMP Start Date here] end
				validators: [
					// % protected region % [Add other validators for LNMP Start Date here] off begin
					// % protected region % [Add other validators for LNMP Start Date here] end
				],
				// % protected region % [Add any additional model attribute properties for LNMP Start Date here] off begin
				// % protected region % [Add any additional model attribute properties for LNMP Start Date here] end
			},
			{
				name: 'lnmpEndDate',
				// % protected region % [Set displayName for LNMP End Date here] off begin
				displayName: 'LNMP End Date',
				// % protected region % [Set displayName for LNMP End Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for LNMP End Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for LNMP End Date here] end
				// % protected region % [Set isSensitive for LNMP End Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for LNMP End Date here] end
				// % protected region % [Set readonly for LNMP End Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for LNMP End Date here] end
				validators: [
					// % protected region % [Add other validators for LNMP End Date here] off begin
					// % protected region % [Add other validators for LNMP End Date here] end
				],
				// % protected region % [Add any additional model attribute properties for LNMP End Date here] off begin
				// % protected region % [Add any additional model attribute properties for LNMP End Date here] end
			},
			{
				name: 'approximateBirthDate',
				// % protected region % [Set displayName for Approximate Birth Date here] off begin
				displayName: 'Approximate Birth Date',
				// % protected region % [Set displayName for Approximate Birth Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Approximate Birth Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Approximate Birth Date here] end
				// % protected region % [Set isSensitive for Approximate Birth Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Approximate Birth Date here] end
				// % protected region % [Set readonly for Approximate Birth Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Approximate Birth Date here] end
				validators: [
					// % protected region % [Add other validators for Approximate Birth Date here] off begin
					// % protected region % [Add other validators for Approximate Birth Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Approximate Birth Date here] off begin
				// % protected region % [Add any additional model attribute properties for Approximate Birth Date here] end
			},
			{
				name: 'gestationAgeWeeks',
				// % protected region % [Set displayName for Gestation Age Weeks here] off begin
				displayName: 'Gestation Age Weeks',
				// % protected region % [Set displayName for Gestation Age Weeks here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Gestation Age Weeks here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Gestation Age Weeks here] end
				// % protected region % [Set isSensitive for Gestation Age Weeks here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gestation Age Weeks here] end
				// % protected region % [Set readonly for Gestation Age Weeks here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gestation Age Weeks here] end
				validators: [
					// % protected region % [Add other validators for Gestation Age Weeks here] off begin
					// % protected region % [Add other validators for Gestation Age Weeks here] end
				],
				// % protected region % [Add any additional model attribute properties for Gestation Age Weeks here] off begin
				// % protected region % [Add any additional model attribute properties for Gestation Age Weeks here] end
			},
			{
				name: 'gestationAgeDays',
				// % protected region % [Set displayName for Gestation Age Days here] off begin
				displayName: 'Gestation Age Days',
				// % protected region % [Set displayName for Gestation Age Days here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Gestation Age Days here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Gestation Age Days here] end
				// % protected region % [Set isSensitive for Gestation Age Days here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gestation Age Days here] end
				// % protected region % [Set readonly for Gestation Age Days here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gestation Age Days here] end
				validators: [
					// % protected region % [Add other validators for Gestation Age Days here] off begin
					// % protected region % [Add other validators for Gestation Age Days here] end
				],
				// % protected region % [Add any additional model attribute properties for Gestation Age Days here] off begin
				// % protected region % [Add any additional model attribute properties for Gestation Age Days here] end
			},
			{
				name: 'tetanusVaccine1',
				// % protected region % [Set displayName for Tetanus Vaccine 1 here] off begin
				displayName: 'Tetanus Vaccine 1',
				// % protected region % [Set displayName for Tetanus Vaccine 1 here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Tetanus Vaccine 1 here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Tetanus Vaccine 1 here] end
				// % protected region % [Set isSensitive for Tetanus Vaccine 1 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tetanus Vaccine 1 here] end
				// % protected region % [Set readonly for Tetanus Vaccine 1 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tetanus Vaccine 1 here] end
				validators: [
					// % protected region % [Add other validators for Tetanus Vaccine 1 here] off begin
					// % protected region % [Add other validators for Tetanus Vaccine 1 here] end
				],
				// % protected region % [Add any additional model attribute properties for Tetanus Vaccine 1 here] off begin
				// % protected region % [Add any additional model attribute properties for Tetanus Vaccine 1 here] end
			},
			{
				name: 'tetanusVaccine2',
				// % protected region % [Set displayName for Tetanus Vaccine 2 here] off begin
				displayName: 'Tetanus Vaccine 2',
				// % protected region % [Set displayName for Tetanus Vaccine 2 here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Tetanus Vaccine 2 here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Tetanus Vaccine 2 here] end
				// % protected region % [Set isSensitive for Tetanus Vaccine 2 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tetanus Vaccine 2 here] end
				// % protected region % [Set readonly for Tetanus Vaccine 2 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tetanus Vaccine 2 here] end
				validators: [
					// % protected region % [Add other validators for Tetanus Vaccine 2 here] off begin
					// % protected region % [Add other validators for Tetanus Vaccine 2 here] end
				],
				// % protected region % [Add any additional model attribute properties for Tetanus Vaccine 2 here] off begin
				// % protected region % [Add any additional model attribute properties for Tetanus Vaccine 2 here] end
			},
			{
				name: 'deliveryType',
				// % protected region % [Set displayName for Delivery Type here] off begin
				displayName: 'Delivery Type',
				// % protected region % [Set displayName for Delivery Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Delivery Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Delivery Type here] end
				// % protected region % [Set isSensitive for Delivery Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Delivery Type here] end
				// % protected region % [Set readonly for Delivery Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Delivery Type here] end
				validators: [
					// % protected region % [Add other validators for Delivery Type here] off begin
					// % protected region % [Add other validators for Delivery Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Delivery Type here] off begin
				// % protected region % [Add any additional model attribute properties for Delivery Type here] end
			},
			{
				name: 'complicationsInPregnancy',
				// % protected region % [Set displayName for Complications In Pregnancy here] off begin
				displayName: 'Complications In Pregnancy',
				// % protected region % [Set displayName for Complications In Pregnancy here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Complications In Pregnancy here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Complications In Pregnancy here] end
				// % protected region % [Set isSensitive for Complications In Pregnancy here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Complications In Pregnancy here] end
				// % protected region % [Set readonly for Complications In Pregnancy here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Complications In Pregnancy here] end
				validators: [
					// % protected region % [Add other validators for Complications In Pregnancy here] off begin
					// % protected region % [Add other validators for Complications In Pregnancy here] end
				],
				// % protected region % [Add any additional model attribute properties for Complications In Pregnancy here] off begin
				// % protected region % [Add any additional model attribute properties for Complications In Pregnancy here] end
			},
			{
				name: 'riskFactor',
				// % protected region % [Set displayName for Risk Factor here] off begin
				displayName: 'Risk Factor',
				// % protected region % [Set displayName for Risk Factor here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Risk Factor here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Risk Factor here] end
				// % protected region % [Set isSensitive for Risk Factor here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Risk Factor here] end
				// % protected region % [Set readonly for Risk Factor here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Risk Factor here] end
				validators: [
					// % protected region % [Add other validators for Risk Factor here] off begin
					// % protected region % [Add other validators for Risk Factor here] end
				],
				// % protected region % [Add any additional model attribute properties for Risk Factor here] off begin
				// % protected region % [Add any additional model attribute properties for Risk Factor here] end
			},
			{
				name: 'fetalPresentation',
				// % protected region % [Set displayName for Fetal Presentation here] off begin
				displayName: 'Fetal Presentation',
				// % protected region % [Set displayName for Fetal Presentation here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Fetal Presentation here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Fetal Presentation here] end
				// % protected region % [Set isSensitive for Fetal Presentation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Fetal Presentation here] end
				// % protected region % [Set readonly for Fetal Presentation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Fetal Presentation here] end
				validators: [
					// % protected region % [Add other validators for Fetal Presentation here] off begin
					// % protected region % [Add other validators for Fetal Presentation here] end
				],
				// % protected region % [Add any additional model attribute properties for Fetal Presentation here] off begin
				// % protected region % [Add any additional model attribute properties for Fetal Presentation here] end
			},
			{
				name: 'abdomenExamination',
				// % protected region % [Set displayName for Abdomen Examination here] off begin
				displayName: 'Abdomen Examination',
				// % protected region % [Set displayName for Abdomen Examination here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Abdomen Examination here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Abdomen Examination here] end
				// % protected region % [Set isSensitive for Abdomen Examination here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Abdomen Examination here] end
				// % protected region % [Set readonly for Abdomen Examination here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Abdomen Examination here] end
				validators: [
					// % protected region % [Add other validators for Abdomen Examination here] off begin
					// % protected region % [Add other validators for Abdomen Examination here] end
				],
				// % protected region % [Add any additional model attribute properties for Abdomen Examination here] off begin
				// % protected region % [Add any additional model attribute properties for Abdomen Examination here] end
			},
			{
				name: 'fundalHeight',
				// % protected region % [Set displayName for Fundal Height here] off begin
				displayName: 'Fundal Height',
				// % protected region % [Set displayName for Fundal Height here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Fundal Height here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Fundal Height here] end
				// % protected region % [Set isSensitive for Fundal Height here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Fundal Height here] end
				// % protected region % [Set readonly for Fundal Height here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Fundal Height here] end
				validators: [
					// % protected region % [Add other validators for Fundal Height here] off begin
					// % protected region % [Add other validators for Fundal Height here] end
				],
				// % protected region % [Add any additional model attribute properties for Fundal Height here] off begin
				// % protected region % [Add any additional model attribute properties for Fundal Height here] end
			},
			{
				name: 'fhrPerMinute',
				// % protected region % [Set displayName for FHR Per Minute here] off begin
				displayName: 'FHR Per Minute',
				// % protected region % [Set displayName for FHR Per Minute here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for FHR Per Minute here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for FHR Per Minute here] end
				// % protected region % [Set isSensitive for FHR Per Minute here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for FHR Per Minute here] end
				// % protected region % [Set readonly for FHR Per Minute here] off begin
				readOnly: false,
				// % protected region % [Set readonly for FHR Per Minute here] end
				validators: [
					// % protected region % [Add other validators for FHR Per Minute here] off begin
					// % protected region % [Add other validators for FHR Per Minute here] end
				],
				// % protected region % [Add any additional model attribute properties for FHR Per Minute here] off begin
				// % protected region % [Add any additional model attribute properties for FHR Per Minute here] end
			},
			{
				name: 'estimatedFetalWeight',
				// % protected region % [Set displayName for Estimated Fetal Weight here] off begin
				displayName: 'Estimated Fetal Weight',
				// % protected region % [Set displayName for Estimated Fetal Weight here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Estimated Fetal Weight here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Estimated Fetal Weight here] end
				// % protected region % [Set isSensitive for Estimated Fetal Weight here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Estimated Fetal Weight here] end
				// % protected region % [Set readonly for Estimated Fetal Weight here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Estimated Fetal Weight here] end
				validators: [
					// % protected region % [Add other validators for Estimated Fetal Weight here] off begin
					// % protected region % [Add other validators for Estimated Fetal Weight here] end
				],
				// % protected region % [Add any additional model attribute properties for Estimated Fetal Weight here] off begin
				// % protected region % [Add any additional model attribute properties for Estimated Fetal Weight here] end
			},
			{
				name: 'leopold1',
				// % protected region % [Set displayName for Leopold 1 here] off begin
				displayName: 'Leopold 1',
				// % protected region % [Set displayName for Leopold 1 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Leopold 1 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Leopold 1 here] end
				// % protected region % [Set isSensitive for Leopold 1 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Leopold 1 here] end
				// % protected region % [Set readonly for Leopold 1 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Leopold 1 here] end
				validators: [
					// % protected region % [Add other validators for Leopold 1 here] off begin
					// % protected region % [Add other validators for Leopold 1 here] end
				],
				// % protected region % [Add any additional model attribute properties for Leopold 1 here] off begin
				// % protected region % [Add any additional model attribute properties for Leopold 1 here] end
			},
			{
				name: 'leopold2',
				// % protected region % [Set displayName for Leopold 2 here] off begin
				displayName: 'Leopold 2',
				// % protected region % [Set displayName for Leopold 2 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Leopold 2 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Leopold 2 here] end
				// % protected region % [Set isSensitive for Leopold 2 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Leopold 2 here] end
				// % protected region % [Set readonly for Leopold 2 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Leopold 2 here] end
				validators: [
					// % protected region % [Add other validators for Leopold 2 here] off begin
					// % protected region % [Add other validators for Leopold 2 here] end
				],
				// % protected region % [Add any additional model attribute properties for Leopold 2 here] off begin
				// % protected region % [Add any additional model attribute properties for Leopold 2 here] end
			},
			{
				name: 'leopold3',
				// % protected region % [Set displayName for Leopold 3 here] off begin
				displayName: 'Leopold 3',
				// % protected region % [Set displayName for Leopold 3 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Leopold 3 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Leopold 3 here] end
				// % protected region % [Set isSensitive for Leopold 3 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Leopold 3 here] end
				// % protected region % [Set readonly for Leopold 3 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Leopold 3 here] end
				validators: [
					// % protected region % [Add other validators for Leopold 3 here] off begin
					// % protected region % [Add other validators for Leopold 3 here] end
				],
				// % protected region % [Add any additional model attribute properties for Leopold 3 here] off begin
				// % protected region % [Add any additional model attribute properties for Leopold 3 here] end
			},
			{
				name: 'leopold4',
				// % protected region % [Set displayName for Leopold 4 here] off begin
				displayName: 'Leopold 4',
				// % protected region % [Set displayName for Leopold 4 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Leopold 4 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Leopold 4 here] end
				// % protected region % [Set isSensitive for Leopold 4 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Leopold 4 here] end
				// % protected region % [Set readonly for Leopold 4 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Leopold 4 here] end
				validators: [
					// % protected region % [Add other validators for Leopold 4 here] off begin
					// % protected region % [Add other validators for Leopold 4 here] end
				],
				// % protected region % [Add any additional model attribute properties for Leopold 4 here] off begin
				// % protected region % [Add any additional model attribute properties for Leopold 4 here] end
			},
			{
				name: 'geniteliaExterna',
				// % protected region % [Set displayName for Genitelia Externa here] off begin
				displayName: 'Genitelia Externa',
				// % protected region % [Set displayName for Genitelia Externa here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Genitelia Externa here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Genitelia Externa here] end
				// % protected region % [Set isSensitive for Genitelia Externa here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Genitelia Externa here] end
				// % protected region % [Set readonly for Genitelia Externa here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Genitelia Externa here] end
				validators: [
					// % protected region % [Add other validators for Genitelia Externa here] off begin
					// % protected region % [Add other validators for Genitelia Externa here] end
				],
				// % protected region % [Add any additional model attribute properties for Genitelia Externa here] off begin
				// % protected region % [Add any additional model attribute properties for Genitelia Externa here] end
			},
			{
				name: 'geniteliaInterna',
				// % protected region % [Set displayName for Genitelia Interna here] off begin
				displayName: 'Genitelia Interna',
				// % protected region % [Set displayName for Genitelia Interna here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Genitelia Interna here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Genitelia Interna here] end
				// % protected region % [Set isSensitive for Genitelia Interna here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Genitelia Interna here] end
				// % protected region % [Set readonly for Genitelia Interna here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Genitelia Interna here] end
				validators: [
					// % protected region % [Add other validators for Genitelia Interna here] off begin
					// % protected region % [Add other validators for Genitelia Interna here] end
				],
				// % protected region % [Add any additional model attribute properties for Genitelia Interna here] off begin
				// % protected region % [Add any additional model attribute properties for Genitelia Interna here] end
			},
			{
				name: 'vaginalExamination',
				// % protected region % [Set displayName for Vaginal Examination here] off begin
				displayName: 'Vaginal Examination',
				// % protected region % [Set displayName for Vaginal Examination here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Vaginal Examination here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Vaginal Examination here] end
				// % protected region % [Set isSensitive for Vaginal Examination here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Vaginal Examination here] end
				// % protected region % [Set readonly for Vaginal Examination here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Vaginal Examination here] end
				validators: [
					// % protected region % [Add other validators for Vaginal Examination here] off begin
					// % protected region % [Add other validators for Vaginal Examination here] end
				],
				// % protected region % [Add any additional model attribute properties for Vaginal Examination here] off begin
				// % protected region % [Add any additional model attribute properties for Vaginal Examination here] end
			},
			{
				name: 'deliveryComplication',
				// % protected region % [Set displayName for Delivery Complication here] off begin
				displayName: 'Delivery Complication',
				// % protected region % [Set displayName for Delivery Complication here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Delivery Complication here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Delivery Complication here] end
				// % protected region % [Set isSensitive for Delivery Complication here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Delivery Complication here] end
				// % protected region % [Set readonly for Delivery Complication here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Delivery Complication here] end
				validators: [
					// % protected region % [Add other validators for Delivery Complication here] off begin
					// % protected region % [Add other validators for Delivery Complication here] end
				],
				// % protected region % [Add any additional model attribute properties for Delivery Complication here] off begin
				// % protected region % [Add any additional model attribute properties for Delivery Complication here] end
			},
			{
				name: 'deliveryNote',
				// % protected region % [Set displayName for Delivery Note here] off begin
				displayName: 'Delivery Note',
				// % protected region % [Set displayName for Delivery Note here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Delivery Note here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Delivery Note here] end
				// % protected region % [Set isSensitive for Delivery Note here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Delivery Note here] end
				// % protected region % [Set readonly for Delivery Note here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Delivery Note here] end
				validators: [
					// % protected region % [Add other validators for Delivery Note here] off begin
					// % protected region % [Add other validators for Delivery Note here] end
				],
				// % protected region % [Add any additional model attribute properties for Delivery Note here] off begin
				// % protected region % [Add any additional model attribute properties for Delivery Note here] end
			},
			{
				name: 'normalDeliveryCase',
				// % protected region % [Set displayName for Normal Delivery Case here] off begin
				displayName: 'Normal Delivery Case',
				// % protected region % [Set displayName for Normal Delivery Case here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Normal Delivery Case here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Normal Delivery Case here] end
				// % protected region % [Set isSensitive for Normal Delivery Case here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Normal Delivery Case here] end
				// % protected region % [Set readonly for Normal Delivery Case here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Normal Delivery Case here] end
				validators: [
					// % protected region % [Add other validators for Normal Delivery Case here] off begin
					// % protected region % [Add other validators for Normal Delivery Case here] end
				],
				// % protected region % [Add any additional model attribute properties for Normal Delivery Case here] off begin
				// % protected region % [Add any additional model attribute properties for Normal Delivery Case here] end
			},
			{
				name: 'stage1Hour',
				// % protected region % [Set displayName for Stage 1 Hour here] off begin
				displayName: 'Stage 1 Hour',
				// % protected region % [Set displayName for Stage 1 Hour here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Stage 1 Hour here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Stage 1 Hour here] end
				// % protected region % [Set isSensitive for Stage 1 Hour here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Stage 1 Hour here] end
				// % protected region % [Set readonly for Stage 1 Hour here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Stage 1 Hour here] end
				validators: [
					// % protected region % [Add other validators for Stage 1 Hour here] off begin
					// % protected region % [Add other validators for Stage 1 Hour here] end
				],
				// % protected region % [Add any additional model attribute properties for Stage 1 Hour here] off begin
				// % protected region % [Add any additional model attribute properties for Stage 1 Hour here] end
			},
			{
				name: 'unnamedInteger1',
				// % protected region % [Set displayName for Unnamed Integer 1 here] off begin
				displayName: 'Unnamed Integer 1',
				// % protected region % [Set displayName for Unnamed Integer 1 here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Unnamed Integer 1 here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Unnamed Integer 1 here] end
				// % protected region % [Set isSensitive for Unnamed Integer 1 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Unnamed Integer 1 here] end
				// % protected region % [Set readonly for Unnamed Integer 1 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Unnamed Integer 1 here] end
				validators: [
					// % protected region % [Add other validators for Unnamed Integer 1 here] off begin
					// % protected region % [Add other validators for Unnamed Integer 1 here] end
				],
				// % protected region % [Add any additional model attribute properties for Unnamed Integer 1 here] off begin
				// % protected region % [Add any additional model attribute properties for Unnamed Integer 1 here] end
			},
			{
				name: 'stage3Hour',
				// % protected region % [Set displayName for Stage 3 Hour here] off begin
				displayName: 'Stage 3 Hour',
				// % protected region % [Set displayName for Stage 3 Hour here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Stage 3 Hour here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Stage 3 Hour here] end
				// % protected region % [Set isSensitive for Stage 3 Hour here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Stage 3 Hour here] end
				// % protected region % [Set readonly for Stage 3 Hour here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Stage 3 Hour here] end
				validators: [
					// % protected region % [Add other validators for Stage 3 Hour here] off begin
					// % protected region % [Add other validators for Stage 3 Hour here] end
				],
				// % protected region % [Add any additional model attribute properties for Stage 3 Hour here] off begin
				// % protected region % [Add any additional model attribute properties for Stage 3 Hour here] end
			},
			{
				name: 'stage4Hour',
				// % protected region % [Set displayName for Stage 4 Hour here] off begin
				displayName: 'Stage 4 Hour',
				// % protected region % [Set displayName for Stage 4 Hour here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Stage 4 Hour here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Stage 4 Hour here] end
				// % protected region % [Set isSensitive for Stage 4 Hour here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Stage 4 Hour here] end
				// % protected region % [Set readonly for Stage 4 Hour here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Stage 4 Hour here] end
				validators: [
					// % protected region % [Add other validators for Stage 4 Hour here] off begin
					// % protected region % [Add other validators for Stage 4 Hour here] end
				],
				// % protected region % [Add any additional model attribute properties for Stage 4 Hour here] off begin
				// % protected region % [Add any additional model attribute properties for Stage 4 Hour here] end
			},
			{
				name: 'stage1Minute',
				// % protected region % [Set displayName for Stage 1 Minute here] off begin
				displayName: 'Stage 1 Minute',
				// % protected region % [Set displayName for Stage 1 Minute here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Stage 1 Minute here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Stage 1 Minute here] end
				// % protected region % [Set isSensitive for Stage 1 Minute here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Stage 1 Minute here] end
				// % protected region % [Set readonly for Stage 1 Minute here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Stage 1 Minute here] end
				validators: [
					// % protected region % [Add other validators for Stage 1 Minute here] off begin
					// % protected region % [Add other validators for Stage 1 Minute here] end
				],
				// % protected region % [Add any additional model attribute properties for Stage 1 Minute here] off begin
				// % protected region % [Add any additional model attribute properties for Stage 1 Minute here] end
			},
			{
				name: 'stage2Minute',
				// % protected region % [Set displayName for Stage 2 Minute here] off begin
				displayName: 'Stage 2 Minute',
				// % protected region % [Set displayName for Stage 2 Minute here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Stage 2 Minute here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Stage 2 Minute here] end
				// % protected region % [Set isSensitive for Stage 2 Minute here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Stage 2 Minute here] end
				// % protected region % [Set readonly for Stage 2 Minute here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Stage 2 Minute here] end
				validators: [
					// % protected region % [Add other validators for Stage 2 Minute here] off begin
					// % protected region % [Add other validators for Stage 2 Minute here] end
				],
				// % protected region % [Add any additional model attribute properties for Stage 2 Minute here] off begin
				// % protected region % [Add any additional model attribute properties for Stage 2 Minute here] end
			},
			{
				name: 'stage3Minute',
				// % protected region % [Set displayName for Stage 3 Minute here] off begin
				displayName: 'Stage 3 Minute',
				// % protected region % [Set displayName for Stage 3 Minute here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Stage 3 Minute here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Stage 3 Minute here] end
				// % protected region % [Set isSensitive for Stage 3 Minute here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Stage 3 Minute here] end
				// % protected region % [Set readonly for Stage 3 Minute here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Stage 3 Minute here] end
				validators: [
					// % protected region % [Add other validators for Stage 3 Minute here] off begin
					// % protected region % [Add other validators for Stage 3 Minute here] end
				],
				// % protected region % [Add any additional model attribute properties for Stage 3 Minute here] off begin
				// % protected region % [Add any additional model attribute properties for Stage 3 Minute here] end
			},
			{
				name: 'stage4Minute',
				// % protected region % [Set displayName for Stage 4 Minute here] off begin
				displayName: 'Stage 4 Minute',
				// % protected region % [Set displayName for Stage 4 Minute here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Stage 4 Minute here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Stage 4 Minute here] end
				// % protected region % [Set isSensitive for Stage 4 Minute here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Stage 4 Minute here] end
				// % protected region % [Set readonly for Stage 4 Minute here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Stage 4 Minute here] end
				validators: [
					// % protected region % [Add other validators for Stage 4 Minute here] off begin
					// % protected region % [Add other validators for Stage 4 Minute here] end
				],
				// % protected region % [Add any additional model attribute properties for Stage 4 Minute here] off begin
				// % protected region % [Add any additional model attribute properties for Stage 4 Minute here] end
			},
			{
				name: 'placenta',
				// % protected region % [Set displayName for Placenta here] off begin
				displayName: 'Placenta',
				// % protected region % [Set displayName for Placenta here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Placenta here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Placenta here] end
				// % protected region % [Set isSensitive for Placenta here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Placenta here] end
				// % protected region % [Set readonly for Placenta here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Placenta here] end
				validators: [
					// % protected region % [Add other validators for Placenta here] off begin
					// % protected region % [Add other validators for Placenta here] end
				],
				// % protected region % [Add any additional model attribute properties for Placenta here] off begin
				// % protected region % [Add any additional model attribute properties for Placenta here] end
			},
			{
				name: 'perineum',
				// % protected region % [Set displayName for Perineum here] off begin
				displayName: 'Perineum',
				// % protected region % [Set displayName for Perineum here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Perineum here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Perineum here] end
				// % protected region % [Set isSensitive for Perineum here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Perineum here] end
				// % protected region % [Set readonly for Perineum here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Perineum here] end
				validators: [
					// % protected region % [Add other validators for Perineum here] off begin
					// % protected region % [Add other validators for Perineum here] end
				],
				// % protected region % [Add any additional model attribute properties for Perineum here] off begin
				// % protected region % [Add any additional model attribute properties for Perineum here] end
			},
			{
				name: 'bleeding',
				// % protected region % [Set displayName for Bleeding here] off begin
				displayName: 'Bleeding',
				// % protected region % [Set displayName for Bleeding here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Bleeding here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Bleeding here] end
				// % protected region % [Set isSensitive for Bleeding here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Bleeding here] end
				// % protected region % [Set readonly for Bleeding here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Bleeding here] end
				validators: [
					// % protected region % [Add other validators for Bleeding here] off begin
					// % protected region % [Add other validators for Bleeding here] end
				],
				// % protected region % [Add any additional model attribute properties for Bleeding here] off begin
				// % protected region % [Add any additional model attribute properties for Bleeding here] end
			},
			{
				name: 'postpartumComplication',
				// % protected region % [Set displayName for Postpartum Complication here] off begin
				displayName: 'Postpartum Complication',
				// % protected region % [Set displayName for Postpartum Complication here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Postpartum Complication here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Postpartum Complication here] end
				// % protected region % [Set isSensitive for Postpartum Complication here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Postpartum Complication here] end
				// % protected region % [Set readonly for Postpartum Complication here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Postpartum Complication here] end
				validators: [
					// % protected region % [Add other validators for Postpartum Complication here] off begin
					// % protected region % [Add other validators for Postpartum Complication here] end
				],
				// % protected region % [Add any additional model attribute properties for Postpartum Complication here] off begin
				// % protected region % [Add any additional model attribute properties for Postpartum Complication here] end
			},
			{
				name: 'newbornDelivered',
				// % protected region % [Set displayName for Newborn Delivered here] off begin
				displayName: 'Newborn Delivered',
				// % protected region % [Set displayName for Newborn Delivered here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Newborn Delivered here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Newborn Delivered here] end
				// % protected region % [Set isSensitive for Newborn Delivered here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Newborn Delivered here] end
				// % protected region % [Set readonly for Newborn Delivered here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Newborn Delivered here] end
				validators: [
					// % protected region % [Add other validators for Newborn Delivered here] off begin
					// % protected region % [Add other validators for Newborn Delivered here] end
				],
				// % protected region % [Add any additional model attribute properties for Newborn Delivered here] off begin
				// % protected region % [Add any additional model attribute properties for Newborn Delivered here] end
			},
			{
				name: 'perineumInfection',
				// % protected region % [Set displayName for Perineum Infection here] off begin
				displayName: 'Perineum Infection',
				// % protected region % [Set displayName for Perineum Infection here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Perineum Infection here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Perineum Infection here] end
				// % protected region % [Set isSensitive for Perineum Infection here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Perineum Infection here] end
				// % protected region % [Set readonly for Perineum Infection here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Perineum Infection here] end
				validators: [
					// % protected region % [Add other validators for Perineum Infection here] off begin
					// % protected region % [Add other validators for Perineum Infection here] end
				],
				// % protected region % [Add any additional model attribute properties for Perineum Infection here] off begin
				// % protected region % [Add any additional model attribute properties for Perineum Infection here] end
			},
			{
				name: 'earlyBreastfeedingIntiation',
				// % protected region % [Set displayName for Early Breastfeeding Intiation here] off begin
				displayName: 'Early Breastfeeding Intiation',
				// % protected region % [Set displayName for Early Breastfeeding Intiation here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Early Breastfeeding Intiation here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Early Breastfeeding Intiation here] end
				// % protected region % [Set isSensitive for Early Breastfeeding Intiation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Early Breastfeeding Intiation here] end
				// % protected region % [Set readonly for Early Breastfeeding Intiation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Early Breastfeeding Intiation here] end
				validators: [
					// % protected region % [Add other validators for Early Breastfeeding Intiation here] off begin
					// % protected region % [Add other validators for Early Breastfeeding Intiation here] end
				],
				// % protected region % [Add any additional model attribute properties for Early Breastfeeding Intiation here] off begin
				// % protected region % [Add any additional model attribute properties for Early Breastfeeding Intiation here] end
			},
			// % protected region % [Add any additional class field names here] off begin
			// % protected region % [Add any additional class field names here] end
		]);
	}

	/**
	 * The relations of the entity
	 */
	static getRelations(): ModelRelation[] {
		return super.getRelations().concat([
			{
				id: 'additionalMidwives',
				type: ModelRelationType.MANY,
				name: 'additionalMidwivesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Additional Midwives here] off begin
				label: 'Additional Midwives',
				// % protected region % [Customise your 1-1 or 1-M label for Additional Midwives here] end
				entityName: 'CoTreatingDoctorModel',
				// % protected region % [Customise your display name for Additional Midwives here] off begin
				displayName: 'doctorNotes',
				// % protected region % [Customise your display name for Additional Midwives here] end
				validators: [
					// % protected region % [Add other validators for Additional Midwives here] off begin
					// % protected region % [Add other validators for Additional Midwives here] end
				],
				// % protected region % [Add any additional field for relation Additional Midwives here] off begin
				// % protected region % [Add any additional field for relation Additional Midwives here] end
			},
			{
				id: 'deliveryProgresses',
				type: ModelRelationType.MANY,
				name: 'deliveryProgressesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Delivery Progresses here] off begin
				label: 'Delivery Progresses',
				// % protected region % [Customise your 1-1 or 1-M label for Delivery Progresses here] end
				entityName: 'DeliveryProgressModel',
				// % protected region % [Customise your display name for Delivery Progresses here] off begin
				displayName: 'progressDateTime',
				// % protected region % [Customise your display name for Delivery Progresses here] end
				validators: [
					// % protected region % [Add other validators for Delivery Progresses here] off begin
					// % protected region % [Add other validators for Delivery Progresses here] end
				],
				// % protected region % [Add any additional field for relation Delivery Progresses here] off begin
				// % protected region % [Add any additional field for relation Delivery Progresses here] end
			},
			{
				id: 'newbornDetails',
				type: ModelRelationType.MANY,
				name: 'newbornDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Newborn Details here] off begin
				label: 'Newborn Details',
				// % protected region % [Customise your 1-1 or 1-M label for Newborn Details here] end
				entityName: 'NewbornDetailModel',
				// % protected region % [Customise your display name for Newborn Details here] off begin
				displayName: 'newbornFirstName',
				// % protected region % [Customise your display name for Newborn Details here] end
				validators: [
					// % protected region % [Add other validators for Newborn Details here] off begin
					// % protected region % [Add other validators for Newborn Details here] end
				],
				// % protected region % [Add any additional field for relation Newborn Details here] off begin
				// % protected region % [Add any additional field for relation Newborn Details here] end
			},
			{
				id: 'medicalExaminationRecord',
				type: ModelRelationType.ONE,
				name: 'medicalExaminationRecordId',
				// % protected region % [Customise your label for Medical Examination Record here] off begin
				label: 'Medical Examination Record',
				// % protected region % [Customise your label for Medical Examination Record here] end
				entityName: 'MedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Medical Examination Record here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'diastole',
				// % protected region % [Customise your display name for Medical Examination Record here] end
				validators: [
					// % protected region % [Add other validators for Medical Examination Record here] off begin
					// % protected region % [Add other validators for Medical Examination Record here] end
				],
				// % protected region % [Add any additional field for relation Medical Examination Record here] off begin
				// % protected region % [Add any additional field for relation Medical Examination Record here] end
			},
			{
				id: 'midwife',
				type: ModelRelationType.ONE,
				name: 'midwifeId',
				// % protected region % [Customise your label for Midwife here] off begin
				label: 'Midwife',
				// % protected region % [Customise your label for Midwife here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Midwife here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Midwife here] end
				validators: [
					// % protected region % [Add other validators for Midwife here] off begin
					// % protected region % [Add other validators for Midwife here] end
				],
				// % protected region % [Add any additional field for relation Midwife here] off begin
				// % protected region % [Add any additional field for relation Midwife here] end
			},
		]);
	}

	/**
	 * Convert the form group to the query conditions
	 */
	static convertFilterToCondition(formGroup: FormGroup): Where[][] {
		let conditions: Where[][] = [];

		// % protected region % [Overide the default convertFilterToCondition here] off begin
		Object.keys(formGroup.value).forEach((key) => {
			switch (key) {
				case 'pregnancyHistoryGravida':
					break;
				case 'pregnancyHistoryPartum':
					break;
				case 'pregnancyHistoryNotes':
					break;
				case 'lnmpStartDate':
					break;
				case 'lnmpEndDate':
					break;
				case 'approximateBirthDate':
					break;
				case 'gestationAgeWeeks':
					break;
				case 'gestationAgeDays':
					break;
				case 'tetanusVaccine1':
					break;
				case 'tetanusVaccine2':
					break;
				case 'deliveryType':
					break;
				case 'complicationsInPregnancy':
					break;
				case 'riskFactor':
					break;
				case 'fetalPresentation':
					break;
				case 'abdomenExamination':
					break;
				case 'fundalHeight':
					break;
				case 'fhrPerMinute':
					break;
				case 'estimatedFetalWeight':
					break;
				case 'leopold1':
					break;
				case 'leopold2':
					break;
				case 'leopold3':
					break;
				case 'leopold4':
					break;
				case 'geniteliaExterna':
					break;
				case 'geniteliaInterna':
					break;
				case 'vaginalExamination':
					break;
				case 'deliveryComplication':
					break;
				case 'deliveryNote':
					break;
				case 'normalDeliveryCase':
					break;
				case 'stage1Hour':
					break;
				case 'stage3Hour':
					break;
				case 'stage4Hour':
					break;
				case 'stage1Minute':
					break;
				case 'stage2Minute':
					break;
				case 'stage3Minute':
					break;
				case 'stage4Minute':
					break;
				case 'placenta':
					break;
				case 'perineum':
					break;
				case 'bleeding':
					break;
				case 'postpartumComplication':
					break;
				case 'newbornDelivered':
					break;
				case 'perineumInfection':
					break;
				case 'earlyBreastfeedingIntiation':
					break;
				case 'created':
					const created = formGroup.value[key];
					// is the range of date
					if (created instanceof Array) {
						conditions.push([
							{
								path: key,
								operation: QueryOperation.GREATER_THAN_OR_EQUAL,
								value: created[0]
							}
						]);
						conditions.push([
							{
								path: key,
								operation: QueryOperation.LESS_THAN_OR_EQUAL,
								value: created[1]
							}
						]);
					}
			}
		});
		// % protected region % [Overide the default convertFilterToCondition here] end


		return conditions;
	}

	/**
	 * Convert a nested JSON object into an array of flatten objects.
	 */
	static deepParse(data: string | { [K in keyof DeliveryMedicalExaminationRecordModel]?: DeliveryMedicalExaminationRecordModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new DeliveryMedicalExaminationRecordModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.medicalExaminationRecord) {
			currentModel.medicalExaminationRecordId = json.medicalExaminationRecord.id;
			returned = _.union(returned, MedicalExaminationRecordModel.deepParse(json.medicalExaminationRecord));
		}

		// Incoming one to many
		if (json.midwife) {
			currentModel.midwifeId = json.midwife.id;
			returned = _.union(returned, StaffModel.deepParse(json.midwife));
		}

		// Outgoing one to many
		if (json.additionalMidwives) {
			currentModel.additionalMidwivesIds = json.additionalMidwives.map(model => model.id);
			returned = _.union(returned, _.flatten(json.additionalMidwives.map(model => CoTreatingDoctorModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.deliveryProgresses) {
			currentModel.deliveryProgressesIds = json.deliveryProgresses.map(model => model.id);
			returned = _.union(returned, _.flatten(json.deliveryProgresses.map(model => DeliveryProgressModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.newbornDetails) {
			currentModel.newbornDetailsIds = json.newbornDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.newbornDetails.map(model => NewbornDetailModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let deliveryMedicalExaminationRecordModel = new DeliveryMedicalExaminationRecordModel(data);`
	 *
	 * @param data The input data to be initialised as the DeliveryMedicalExaminationRecordModel,
	 *    it is expected as a JSON string or as a nullable DeliveryMedicalExaminationRecordModel.
	 */
	constructor(data?: string | Partial<DeliveryMedicalExaminationRecordModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<DeliveryMedicalExaminationRecordModel>
				: data;

			this.pregnancyHistoryGravida = json.pregnancyHistoryGravida;
			this.pregnancyHistoryPartum = json.pregnancyHistoryPartum;
			this.pregnancyHistoryAbortum = json.pregnancyHistoryAbortum;
			this.pregnancyHistoryNotes = json.pregnancyHistoryNotes;
			if (json.lnmpStartDate) {
				this.lnmpStartDate = new Date(json.lnmpStartDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.lnmpStartDate = json.lnmpStartDate;
			}
			if (json.lnmpEndDate) {
				this.lnmpEndDate = new Date(json.lnmpEndDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.lnmpEndDate = json.lnmpEndDate;
			}
			if (json.approximateBirthDate) {
				this.approximateBirthDate = new Date(json.approximateBirthDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.approximateBirthDate = json.approximateBirthDate;
			}
			this.gestationAgeWeeks = json.gestationAgeWeeks;
			this.gestationAgeDays = json.gestationAgeDays;
			this.tetanusVaccine1 = json.tetanusVaccine1;
			this.tetanusVaccine2 = json.tetanusVaccine2;
			this.deliveryType = json.deliveryType;
			this.complicationsInPregnancy = json.complicationsInPregnancy;
			this.riskFactor = json.riskFactor;
			this.fetalPresentation = json.fetalPresentation;
			this.abdomenExamination = json.abdomenExamination;
			this.fundalHeight = json.fundalHeight;
			this.fhrPerMinute = json.fhrPerMinute;
			this.estimatedFetalWeight = json.estimatedFetalWeight;
			this.leopold1 = json.leopold1;
			this.leopold2 = json.leopold2;
			this.leopold3 = json.leopold3;
			this.leopold4 = json.leopold4;
			this.geniteliaExterna = json.geniteliaExterna;
			this.geniteliaInterna = json.geniteliaInterna;
			this.vaginalExamination = json.vaginalExamination;
			this.deliveryComplication = json.deliveryComplication;
			this.deliveryNote = json.deliveryNote;
			this.normalDeliveryCase = json.normalDeliveryCase;
			this.stage1Hour = json.stage1Hour;
			this.unnamedInteger1 = json.unnamedInteger1;
			this.stage3Hour = json.stage3Hour;
			this.stage4Hour = json.stage4Hour;
			this.stage1Minute = json.stage1Minute;
			this.stage2Minute = json.stage2Minute;
			this.stage3Minute = json.stage3Minute;
			this.stage4Minute = json.stage4Minute;
			this.placenta = json.placenta;
			this.perineum = json.perineum;
			this.bleeding = json.bleeding;
			this.postpartumComplication = json.postpartumComplication;
			this.newbornDelivered = json.newbornDelivered;
			this.perineumInfection = json.perineumInfection;
			this.earlyBreastfeedingIntiation = json.earlyBreastfeedingIntiation;
			this.medicalExaminationRecordId = json.medicalExaminationRecordId;
			this.medicalExaminationRecord = json.medicalExaminationRecord;
			this.midwifeId = json.midwifeId;
			this.midwife = json.midwife;
			this.additionalMidwivesIds = json.additionalMidwivesIds;
			this.additionalMidwives = json.additionalMidwives;
			this.deliveryProgressesIds = json.deliveryProgressesIds;
			this.deliveryProgresses = json.deliveryProgresses;
			this.newbornDetailsIds = json.newbornDetailsIds;
			this.newbornDetails = json.newbornDetails;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			pregnancyHistoryGravida: this.pregnancyHistoryGravida,
			pregnancyHistoryPartum: this.pregnancyHistoryPartum,
			pregnancyHistoryAbortum: this.pregnancyHistoryAbortum,
			pregnancyHistoryNotes: this.pregnancyHistoryNotes,
			lnmpStartDate: this.lnmpStartDate,
			lnmpEndDate: this.lnmpEndDate,
			approximateBirthDate: this.approximateBirthDate,
			gestationAgeWeeks: this.gestationAgeWeeks,
			gestationAgeDays: this.gestationAgeDays,
			tetanusVaccine1: this.tetanusVaccine1,
			tetanusVaccine2: this.tetanusVaccine2,
			deliveryType: this.deliveryType,
			complicationsInPregnancy: this.complicationsInPregnancy,
			riskFactor: this.riskFactor,
			fetalPresentation: this.fetalPresentation,
			abdomenExamination: this.abdomenExamination,
			fundalHeight: this.fundalHeight,
			fhrPerMinute: this.fhrPerMinute,
			estimatedFetalWeight: this.estimatedFetalWeight,
			leopold1: this.leopold1,
			leopold2: this.leopold2,
			leopold3: this.leopold3,
			leopold4: this.leopold4,
			geniteliaExterna: this.geniteliaExterna,
			geniteliaInterna: this.geniteliaInterna,
			vaginalExamination: this.vaginalExamination,
			deliveryComplication: this.deliveryComplication,
			deliveryNote: this.deliveryNote,
			normalDeliveryCase: this.normalDeliveryCase,
			stage1Hour: this.stage1Hour,
			unnamedInteger1: this.unnamedInteger1,
			stage3Hour: this.stage3Hour,
			stage4Hour: this.stage4Hour,
			stage1Minute: this.stage1Minute,
			stage2Minute: this.stage2Minute,
			stage3Minute: this.stage3Minute,
			stage4Minute: this.stage4Minute,
			placenta: this.placenta,
			perineum: this.perineum,
			bleeding: this.bleeding,
			postpartumComplication: this.postpartumComplication,
			newbornDelivered: this.newbornDelivered,
			perineumInfection: this.perineumInfection,
			earlyBreastfeedingIntiation: this.earlyBreastfeedingIntiation,
			medicalExaminationRecordId: this.medicalExaminationRecordId,
			midwifeId: this.midwifeId,
			additionalMidwivesIds: this.additionalMidwivesIds,
			deliveryProgressesIds: this.deliveryProgressesIds,
			newbornDetailsIds: this.newbornDetailsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		DeliveryMedicalExaminationRecordModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): DeliveryMedicalExaminationRecordModel {
		let newModelJson = this.toJSON();

		if (updates.pregnancyHistoryGravida) {
			newModelJson.pregnancyHistoryGravida = updates.pregnancyHistoryGravida;
		}

		if (updates.pregnancyHistoryPartum) {
			newModelJson.pregnancyHistoryPartum = updates.pregnancyHistoryPartum;
		}

		if (updates.pregnancyHistoryAbortum) {
			newModelJson.pregnancyHistoryAbortum = updates.pregnancyHistoryAbortum;
		}

		if (updates.pregnancyHistoryNotes) {
			newModelJson.pregnancyHistoryNotes = updates.pregnancyHistoryNotes;
		}

		if (updates.lnmpStartDate) {
			newModelJson.lnmpStartDate = updates.lnmpStartDate;
		}

		if (updates.lnmpEndDate) {
			newModelJson.lnmpEndDate = updates.lnmpEndDate;
		}

		if (updates.approximateBirthDate) {
			newModelJson.approximateBirthDate = updates.approximateBirthDate;
		}

		if (updates.gestationAgeWeeks) {
			newModelJson.gestationAgeWeeks = updates.gestationAgeWeeks;
		}

		if (updates.gestationAgeDays) {
			newModelJson.gestationAgeDays = updates.gestationAgeDays;
		}

		if (updates.tetanusVaccine1) {
			newModelJson.tetanusVaccine1 = updates.tetanusVaccine1;
		}

		if (updates.tetanusVaccine2) {
			newModelJson.tetanusVaccine2 = updates.tetanusVaccine2;
		}

		if (updates.deliveryType) {
			newModelJson.deliveryType = updates.deliveryType;
		}

		if (updates.complicationsInPregnancy) {
			newModelJson.complicationsInPregnancy = updates.complicationsInPregnancy;
		}

		if (updates.riskFactor) {
			newModelJson.riskFactor = updates.riskFactor;
		}

		if (updates.fetalPresentation) {
			newModelJson.fetalPresentation = updates.fetalPresentation;
		}

		if (updates.abdomenExamination) {
			newModelJson.abdomenExamination = updates.abdomenExamination;
		}

		if (updates.fundalHeight) {
			newModelJson.fundalHeight = updates.fundalHeight;
		}

		if (updates.fhrPerMinute) {
			newModelJson.fhrPerMinute = updates.fhrPerMinute;
		}

		if (updates.estimatedFetalWeight) {
			newModelJson.estimatedFetalWeight = updates.estimatedFetalWeight;
		}

		if (updates.leopold1) {
			newModelJson.leopold1 = updates.leopold1;
		}

		if (updates.leopold2) {
			newModelJson.leopold2 = updates.leopold2;
		}

		if (updates.leopold3) {
			newModelJson.leopold3 = updates.leopold3;
		}

		if (updates.leopold4) {
			newModelJson.leopold4 = updates.leopold4;
		}

		if (updates.geniteliaExterna) {
			newModelJson.geniteliaExterna = updates.geniteliaExterna;
		}

		if (updates.geniteliaInterna) {
			newModelJson.geniteliaInterna = updates.geniteliaInterna;
		}

		if (updates.vaginalExamination) {
			newModelJson.vaginalExamination = updates.vaginalExamination;
		}

		if (updates.deliveryComplication) {
			newModelJson.deliveryComplication = updates.deliveryComplication;
		}

		if (updates.deliveryNote) {
			newModelJson.deliveryNote = updates.deliveryNote;
		}

		if (updates.normalDeliveryCase) {
			newModelJson.normalDeliveryCase = updates.normalDeliveryCase;
		}

		if (updates.stage1Hour) {
			newModelJson.stage1Hour = updates.stage1Hour;
		}

		if (updates.unnamedInteger1) {
			newModelJson.unnamedInteger1 = updates.unnamedInteger1;
		}

		if (updates.stage3Hour) {
			newModelJson.stage3Hour = updates.stage3Hour;
		}

		if (updates.stage4Hour) {
			newModelJson.stage4Hour = updates.stage4Hour;
		}

		if (updates.stage1Minute) {
			newModelJson.stage1Minute = updates.stage1Minute;
		}

		if (updates.stage2Minute) {
			newModelJson.stage2Minute = updates.stage2Minute;
		}

		if (updates.stage3Minute) {
			newModelJson.stage3Minute = updates.stage3Minute;
		}

		if (updates.stage4Minute) {
			newModelJson.stage4Minute = updates.stage4Minute;
		}

		if (updates.placenta) {
			newModelJson.placenta = updates.placenta;
		}

		if (updates.perineum) {
			newModelJson.perineum = updates.perineum;
		}

		if (updates.bleeding) {
			newModelJson.bleeding = updates.bleeding;
		}

		if (updates.postpartumComplication) {
			newModelJson.postpartumComplication = updates.postpartumComplication;
		}

		if (updates.newbornDelivered) {
			newModelJson.newbornDelivered = updates.newbornDelivered;
		}

		if (updates.perineumInfection) {
			newModelJson.perineumInfection = updates.perineumInfection;
		}

		if (updates.earlyBreastfeedingIntiation) {
			newModelJson.earlyBreastfeedingIntiation = updates.earlyBreastfeedingIntiation;
		}

		if (updates.medicalExaminationRecordId) {
			newModelJson.medicalExaminationRecordId = updates.medicalExaminationRecordId;
		}

		if (updates.midwifeId) {
			newModelJson.midwifeId = updates.midwifeId;
		}

		if (updates.additionalMidwivesIds) {
			newModelJson.additionalMidwivesIds = updates.additionalMidwivesIds;
		}

		if (updates.deliveryProgressesIds) {
			newModelJson.deliveryProgressesIds = updates.deliveryProgressesIds;
		}

		if (updates.newbornDetailsIds) {
			newModelJson.newbornDetailsIds = updates.newbornDetailsIds;
		}

		return new DeliveryMedicalExaminationRecordModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof DeliveryMedicalExaminationRecordModel)) {
			return {};
		}

		const diff = {};

		for (const key of _.keys(this)) {
			const thisValue = this[key];
			const otherValue = other[key];

			// Handle dates differently
			if (thisValue instanceof Date) {
				let thisDate = (thisValue) ? thisValue.getTime() : null;
				let otherDate = (otherValue) ? otherValue.getTime() : null;

				if (thisDate !== otherDate) {
					diff[key] = thisValue;
				}
			} else if (thisValue !== otherValue) {
				diff[key] = thisValue;
			}
		}

		return _.omit(diff, [
			'created',
			'modified',
			'medicalExaminationRecordId',
			'medicalExaminationRecord',
			'midwifeId',
			'midwife',
			'additionalMidwivesIds',
			'additionalMidwives',
			'deliveryProgressesIds',
			'deliveryProgresses',
			'newbornDetailsIds',
			'newbornDetails',
			// % protected region % [Add any other fields to omit here] off begin
			// % protected region % [Add any other fields to omit here] end
		]);
	}

	/**
	 * Sets the relation ID parameters to be based on the ID's of the associated entities.
	 * 
	 * Fetching entities is based on the object, but updating relations is based on the id, so we need to
	 * make sure that they match
	 */
	syncRelations() {
		if (!this.medicalExaminationRecord) {
			this.medicalExaminationRecordId = null;
		} else {
			this.medicalExaminationRecordId = this.medicalExaminationRecord.id;
		}

		if (!this.midwife) {
			this.midwifeId = null;
		} else {
			this.midwifeId = this.midwife.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
