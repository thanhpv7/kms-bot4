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
import {MedicalExaminationRecordModel} from '../medicalExaminationRecord/medical_examination_record.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BodyChartExaminationModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'bc77Objective',
		'bc78Subjective',
		'bc78Objective',
		'bc79Subjective',
		'bc79Objective',
		'bc80Subjective',
		'bc80Objective',
		'bc81Subjective',
		'bc81Objective',
		'bc82Subjective',
		'bc82Objective',
		'bc83Subjective',
		'bc83Objective',
		'bc84Subjective',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'bc01Subjective',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BodyChartExaminationModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BodyChartExaminationModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	bc01Subjective: string;

	/**
	 * .
	 */
	bc01Objective: string;

	/**
	 * .
	 */
	bc02Subjective: string;

	/**
	 * .
	 */
	bc02Objective: string;

	/**
	 * .
	 */
	bc03Subjective: string;

	/**
	 * .
	 */
	bc03Objective: string;

	/**
	 * .
	 */
	bc04Subjective: string;

	/**
	 * .
	 */
	bc04Objective: string;

	/**
	 * .
	 */
	bc05Subjective: string;

	/**
	 * .
	 */
	bc05Objective: string;

	/**
	 * .
	 */
	bc06Subjective: string;

	/**
	 * .
	 */
	bc06Objective: string;

	/**
	 * .
	 */
	bc07Subjective: string;

	/**
	 * .
	 */
	bc07Objective: string;

	/**
	 * .
	 */
	bc08Subjective: string;

	/**
	 * .
	 */
	bc08Objective: string;

	/**
	 * .
	 */
	bc09Subjective: string;

	/**
	 * .
	 */
	bc09Objective: string;

	/**
	 * .
	 */
	bc10Subjective: string;

	/**
	 * .
	 */
	bc10Objective: string;

	/**
	 * .
	 */
	bc11Subjective: string;

	/**
	 * .
	 */
	bc11Objective: string;

	/**
	 * .
	 */
	bc12Subjective: string;

	/**
	 * .
	 */
	bc12Objective: string;

	/**
	 * .
	 */
	bc13Subjective: string;

	/**
	 * .
	 */
	bc13Objective: string;

	/**
	 * .
	 */
	bc14Subjective: string;

	/**
	 * .
	 */
	bc14Objective: string;

	/**
	 * .
	 */
	bc15Subjective: string;

	/**
	 * .
	 */
	bc15Objective: string;

	/**
	 * .
	 */
	bc16Subjective: string;

	/**
	 * .
	 */
	bc16Objective: string;

	/**
	 * .
	 */
	bc17Subjective: string;

	/**
	 * .
	 */
	bc17Objective: string;

	/**
	 * .
	 */
	bc18Subjective: string;

	/**
	 * .
	 */
	bc18Objective: string;

	/**
	 * .
	 */
	bc19Subjective: string;

	/**
	 * .
	 */
	bc19Objective: string;

	/**
	 * .
	 */
	bc20Subjective: string;

	/**
	 * .
	 */
	bc20Objective: string;

	/**
	 * .
	 */
	bc21Subjective: string;

	/**
	 * .
	 */
	bc21Objective: string;

	/**
	 * .
	 */
	bc22Subjective: string;

	/**
	 * .
	 */
	bc22Objective: string;

	/**
	 * .
	 */
	bc23Subjective: string;

	/**
	 * .
	 */
	bc23Objective: string;

	/**
	 * .
	 */
	bc24Subjective: string;

	/**
	 * .
	 */
	bc24Objective: string;

	/**
	 * .
	 */
	bc25Subjective: string;

	/**
	 * .
	 */
	bc25Objective: string;

	/**
	 * .
	 */
	bc26Subjective: string;

	/**
	 * .
	 */
	bc26Objective: string;

	/**
	 * .
	 */
	bc27Subjective: string;

	/**
	 * .
	 */
	bc27Objective: string;

	/**
	 * .
	 */
	bc28Subjective: string;

	/**
	 * .
	 */
	bc28Objective: string;

	/**
	 * .
	 */
	bc29Subjective: string;

	/**
	 * .
	 */
	bc29Objective: string;

	/**
	 * .
	 */
	bc30Subjective: string;

	/**
	 * .
	 */
	bc30Objective: string;

	/**
	 * .
	 */
	bc31Subjective: string;

	/**
	 * .
	 */
	bc31Objective: string;

	/**
	 * .
	 */
	bc32Subjective: string;

	/**
	 * .
	 */
	bc32Objective: string;

	/**
	 * .
	 */
	bc33Subjective: string;

	/**
	 * .
	 */
	bc33Objective: string;

	/**
	 * .
	 */
	bc34Subjective: string;

	/**
	 * .
	 */
	bc34Objective: string;

	/**
	 * .
	 */
	bc35Subjective: string;

	/**
	 * .
	 */
	bc35Objective: string;

	/**
	 * .
	 */
	bc36Subjective: string;

	/**
	 * .
	 */
	bc36Objective: string;

	/**
	 * .
	 */
	bc37Subjective: string;

	/**
	 * .
	 */
	bc37Objective: string;

	/**
	 * .
	 */
	bc38Subjective: string;

	/**
	 * .
	 */
	bc38Objective: string;

	/**
	 * .
	 */
	bc39Subjective: string;

	/**
	 * .
	 */
	bc39Objective: string;

	/**
	 * .
	 */
	bc40Subjective: string;

	/**
	 * .
	 */
	bc40Objective: string;

	/**
	 * .
	 */
	bc41Subjective: string;

	/**
	 * .
	 */
	bc41Objective: string;

	/**
	 * .
	 */
	bc42Subjective: string;

	/**
	 * .
	 */
	bc42Objective: string;

	/**
	 * .
	 */
	bc43Subjective: string;

	/**
	 * .
	 */
	bc43Objective: string;

	/**
	 * .
	 */
	bc44Subjective: string;

	/**
	 * .
	 */
	bc44Objective: string;

	/**
	 * .
	 */
	bc45Subjective: string;

	/**
	 * .
	 */
	bc45Objective: string;

	/**
	 * .
	 */
	bc46Subjective: string;

	/**
	 * .
	 */
	bc46Objective: string;

	/**
	 * .
	 */
	bc47Subjective: string;

	/**
	 * .
	 */
	bc47Objective: string;

	/**
	 * .
	 */
	bc48Subjective: string;

	/**
	 * .
	 */
	bc48Objective: string;

	/**
	 * .
	 */
	bc49Subjective: string;

	/**
	 * .
	 */
	bc49Objective: string;

	/**
	 * .
	 */
	bc50Subjective: string;

	/**
	 * .
	 */
	bc50Objective: string;

	/**
	 * .
	 */
	bc51Subjective: string;

	/**
	 * .
	 */
	bc51Objective: string;

	/**
	 * .
	 */
	bc52Subjective: string;

	/**
	 * .
	 */
	bc52Objective: string;

	/**
	 * .
	 */
	bc53Subjective: string;

	/**
	 * .
	 */
	bc53Objective: string;

	/**
	 * .
	 */
	bc54Subjective: string;

	/**
	 * .
	 */
	bc54Objective: string;

	/**
	 * .
	 */
	bc55Subjective: string;

	/**
	 * .
	 */
	bc55Objective: string;

	/**
	 * .
	 */
	bc56Subjective: string;

	/**
	 * .
	 */
	bc56Objective: string;

	/**
	 * .
	 */
	bc57Subjective: string;

	/**
	 * .
	 */
	bc57Objective: string;

	/**
	 * .
	 */
	bc58Subjective: string;

	/**
	 * .
	 */
	bc58Objective: string;

	/**
	 * .
	 */
	bc59Subjective: string;

	/**
	 * .
	 */
	bc59Objective: string;

	/**
	 * .
	 */
	bc60Subjective: string;

	/**
	 * .
	 */
	bc60Objective: string;

	/**
	 * .
	 */
	bc61Subjective: string;

	/**
	 * .
	 */
	bc61Objective: string;

	/**
	 * .
	 */
	bc62Subjective: string;

	/**
	 * .
	 */
	bc62Objective: string;

	/**
	 * .
	 */
	bc63Subjective: string;

	/**
	 * .
	 */
	bc63Objective: string;

	/**
	 * .
	 */
	bc64Subjective: string;

	/**
	 * .
	 */
	bc64Objective: string;

	/**
	 * .
	 */
	bc65Subjective: string;

	/**
	 * .
	 */
	bc65Objective: string;

	/**
	 * .
	 */
	bc66Subjective: string;

	/**
	 * .
	 */
	bc66Objective: string;

	/**
	 * .
	 */
	bc67Subjective: string;

	/**
	 * .
	 */
	bc67Objective: string;

	/**
	 * .
	 */
	bc68Subjective: string;

	/**
	 * .
	 */
	bc68Objective: string;

	/**
	 * .
	 */
	bc69Subjective: string;

	/**
	 * .
	 */
	bc69Objective: string;

	/**
	 * .
	 */
	bc70Subjective: string;

	/**
	 * .
	 */
	bc70Objective: string;

	/**
	 * .
	 */
	bc71Subjective: string;

	/**
	 * .
	 */
	bc71Objective: string;

	/**
	 * .
	 */
	bc72Subjective: string;

	/**
	 * .
	 */
	bc72Objective: string;

	/**
	 * .
	 */
	bc73Subjective: string;

	/**
	 * .
	 */
	bc73Objective: string;

	/**
	 * .
	 */
	bc74Subjective: string;

	/**
	 * .
	 */
	bc74Objective: string;

	/**
	 * .
	 */
	bc75Subjective: string;

	/**
	 * .
	 */
	bc75Objective: string;

	/**
	 * .
	 */
	bc76Subjective: string;

	/**
	 * .
	 */
	bc76Objective: string;

	/**
	 * BC77 Subjective.
	 */
	bc77Subjective: string;

	/**
	 * BC77 Objective.
	 */
	bc77Objective: string;

	/**
	 * BC78 Subjective.
	 */
	bc78Subjective: string;

	/**
	 * BC78 Objective.
	 */
	bc78Objective: string;

	/**
	 * BC79 Subjective.
	 */
	bc79Subjective: string;

	/**
	 * BC79 Objective.
	 */
	bc79Objective: string;

	/**
	 * BC80 Subjective.
	 */
	bc80Subjective: string;

	/**
	 * BC80 Objective.
	 */
	bc80Objective: string;

	/**
	 * BC81 Subjective.
	 */
	bc81Subjective: string;

	/**
	 * BC81 Objective.
	 */
	bc81Objective: string;

	/**
	 * BC82 Subjective.
	 */
	bc82Subjective: string;

	/**
	 * BC82 Objective.
	 */
	bc82Objective: string;

	/**
	 * BC83 Subjective.
	 */
	bc83Subjective: string;

	/**
	 * BC83 Objective.
	 */
	bc83Objective: string;

	/**
	 * BC84 Subjective.
	 */
	bc84Subjective: string;

	/**
	 * BC84 Objective.
	 */
	bc84Objective: string;

	medicalExaminationRecordId: string;

	medicalExaminationRecord: MedicalExaminationRecordModel;

	modelPropGroups: { [s: string]: Group } = BodyChartExaminationModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'bc01Subjective',
				// % protected region % [Set displayName for BC01 Subjective here] off begin
				displayName: 'BC01 Subjective',
				// % protected region % [Set displayName for BC01 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC01 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC01 Subjective here] end
				// % protected region % [Set isSensitive for BC01 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC01 Subjective here] end
				// % protected region % [Set readonly for BC01 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC01 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC01 Subjective here] off begin
					// % protected region % [Add other validators for BC01 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC01 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC01 Subjective here] end
			},
			{
				name: 'bc01Objective',
				// % protected region % [Set displayName for BC01 Objective here] off begin
				displayName: 'BC01 Objective',
				// % protected region % [Set displayName for BC01 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC01 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC01 Objective here] end
				// % protected region % [Set isSensitive for BC01 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC01 Objective here] end
				// % protected region % [Set readonly for BC01 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC01 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC01 Objective here] off begin
					// % protected region % [Add other validators for BC01 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC01 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC01 Objective here] end
			},
			{
				name: 'bc02Subjective',
				// % protected region % [Set displayName for BC02 Subjective here] off begin
				displayName: 'BC02 Subjective',
				// % protected region % [Set displayName for BC02 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC02 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC02 Subjective here] end
				// % protected region % [Set isSensitive for BC02 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC02 Subjective here] end
				// % protected region % [Set readonly for BC02 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC02 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC02 Subjective here] off begin
					// % protected region % [Add other validators for BC02 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC02 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC02 Subjective here] end
			},
			{
				name: 'bc02Objective',
				// % protected region % [Set displayName for BC02 Objective here] off begin
				displayName: 'BC02 Objective',
				// % protected region % [Set displayName for BC02 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC02 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC02 Objective here] end
				// % protected region % [Set isSensitive for BC02 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC02 Objective here] end
				// % protected region % [Set readonly for BC02 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC02 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC02 Objective here] off begin
					// % protected region % [Add other validators for BC02 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC02 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC02 Objective here] end
			},
			{
				name: 'bc03Subjective',
				// % protected region % [Set displayName for BC03 Subjective here] off begin
				displayName: 'BC03 Subjective',
				// % protected region % [Set displayName for BC03 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC03 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC03 Subjective here] end
				// % protected region % [Set isSensitive for BC03 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC03 Subjective here] end
				// % protected region % [Set readonly for BC03 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC03 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC03 Subjective here] off begin
					// % protected region % [Add other validators for BC03 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC03 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC03 Subjective here] end
			},
			{
				name: 'bc03Objective',
				// % protected region % [Set displayName for BC03 Objective here] off begin
				displayName: 'BC03 Objective',
				// % protected region % [Set displayName for BC03 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC03 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC03 Objective here] end
				// % protected region % [Set isSensitive for BC03 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC03 Objective here] end
				// % protected region % [Set readonly for BC03 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC03 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC03 Objective here] off begin
					// % protected region % [Add other validators for BC03 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC03 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC03 Objective here] end
			},
			{
				name: 'bc04Subjective',
				// % protected region % [Set displayName for BC04 Subjective here] off begin
				displayName: 'BC04 Subjective',
				// % protected region % [Set displayName for BC04 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC04 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC04 Subjective here] end
				// % protected region % [Set isSensitive for BC04 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC04 Subjective here] end
				// % protected region % [Set readonly for BC04 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC04 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC04 Subjective here] off begin
					// % protected region % [Add other validators for BC04 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC04 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC04 Subjective here] end
			},
			{
				name: 'bc04Objective',
				// % protected region % [Set displayName for BC04 Objective here] off begin
				displayName: 'BC04 Objective',
				// % protected region % [Set displayName for BC04 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC04 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC04 Objective here] end
				// % protected region % [Set isSensitive for BC04 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC04 Objective here] end
				// % protected region % [Set readonly for BC04 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC04 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC04 Objective here] off begin
					// % protected region % [Add other validators for BC04 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC04 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC04 Objective here] end
			},
			{
				name: 'bc05Subjective',
				// % protected region % [Set displayName for BC05 Subjective here] off begin
				displayName: 'BC05 Subjective',
				// % protected region % [Set displayName for BC05 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC05 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC05 Subjective here] end
				// % protected region % [Set isSensitive for BC05 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC05 Subjective here] end
				// % protected region % [Set readonly for BC05 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC05 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC05 Subjective here] off begin
					// % protected region % [Add other validators for BC05 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC05 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC05 Subjective here] end
			},
			{
				name: 'bc05Objective',
				// % protected region % [Set displayName for BC05 Objective here] off begin
				displayName: 'BC05 Objective',
				// % protected region % [Set displayName for BC05 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC05 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC05 Objective here] end
				// % protected region % [Set isSensitive for BC05 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC05 Objective here] end
				// % protected region % [Set readonly for BC05 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC05 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC05 Objective here] off begin
					// % protected region % [Add other validators for BC05 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC05 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC05 Objective here] end
			},
			{
				name: 'bc06Subjective',
				// % protected region % [Set displayName for BC06 Subjective here] off begin
				displayName: 'BC06 Subjective',
				// % protected region % [Set displayName for BC06 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC06 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC06 Subjective here] end
				// % protected region % [Set isSensitive for BC06 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC06 Subjective here] end
				// % protected region % [Set readonly for BC06 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC06 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC06 Subjective here] off begin
					// % protected region % [Add other validators for BC06 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC06 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC06 Subjective here] end
			},
			{
				name: 'bc06Objective',
				// % protected region % [Set displayName for BC06 Objective here] off begin
				displayName: 'BC06 Objective',
				// % protected region % [Set displayName for BC06 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC06 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC06 Objective here] end
				// % protected region % [Set isSensitive for BC06 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC06 Objective here] end
				// % protected region % [Set readonly for BC06 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC06 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC06 Objective here] off begin
					// % protected region % [Add other validators for BC06 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC06 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC06 Objective here] end
			},
			{
				name: 'bc07Subjective',
				// % protected region % [Set displayName for BC07 Subjective here] off begin
				displayName: 'BC07 Subjective',
				// % protected region % [Set displayName for BC07 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC07 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC07 Subjective here] end
				// % protected region % [Set isSensitive for BC07 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC07 Subjective here] end
				// % protected region % [Set readonly for BC07 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC07 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC07 Subjective here] off begin
					// % protected region % [Add other validators for BC07 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC07 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC07 Subjective here] end
			},
			{
				name: 'bc07Objective',
				// % protected region % [Set displayName for BC07 Objective here] off begin
				displayName: 'BC07 Objective',
				// % protected region % [Set displayName for BC07 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC07 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC07 Objective here] end
				// % protected region % [Set isSensitive for BC07 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC07 Objective here] end
				// % protected region % [Set readonly for BC07 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC07 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC07 Objective here] off begin
					// % protected region % [Add other validators for BC07 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC07 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC07 Objective here] end
			},
			{
				name: 'bc08Subjective',
				// % protected region % [Set displayName for BC08 Subjective here] off begin
				displayName: 'BC08 Subjective',
				// % protected region % [Set displayName for BC08 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC08 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC08 Subjective here] end
				// % protected region % [Set isSensitive for BC08 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC08 Subjective here] end
				// % protected region % [Set readonly for BC08 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC08 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC08 Subjective here] off begin
					// % protected region % [Add other validators for BC08 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC08 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC08 Subjective here] end
			},
			{
				name: 'bc08Objective',
				// % protected region % [Set displayName for BC08 Objective here] off begin
				displayName: 'BC08 Objective',
				// % protected region % [Set displayName for BC08 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC08 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC08 Objective here] end
				// % protected region % [Set isSensitive for BC08 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC08 Objective here] end
				// % protected region % [Set readonly for BC08 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC08 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC08 Objective here] off begin
					// % protected region % [Add other validators for BC08 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC08 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC08 Objective here] end
			},
			{
				name: 'bc09Subjective',
				// % protected region % [Set displayName for BC09 Subjective here] off begin
				displayName: 'BC09 Subjective',
				// % protected region % [Set displayName for BC09 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC09 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC09 Subjective here] end
				// % protected region % [Set isSensitive for BC09 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC09 Subjective here] end
				// % protected region % [Set readonly for BC09 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC09 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC09 Subjective here] off begin
					// % protected region % [Add other validators for BC09 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC09 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC09 Subjective here] end
			},
			{
				name: 'bc09Objective',
				// % protected region % [Set displayName for BC09 Objective here] off begin
				displayName: 'BC09 Objective',
				// % protected region % [Set displayName for BC09 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC09 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC09 Objective here] end
				// % protected region % [Set isSensitive for BC09 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC09 Objective here] end
				// % protected region % [Set readonly for BC09 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC09 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC09 Objective here] off begin
					// % protected region % [Add other validators for BC09 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC09 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC09 Objective here] end
			},
			{
				name: 'bc10Subjective',
				// % protected region % [Set displayName for BC10 Subjective here] off begin
				displayName: 'BC10 Subjective',
				// % protected region % [Set displayName for BC10 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC10 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC10 Subjective here] end
				// % protected region % [Set isSensitive for BC10 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC10 Subjective here] end
				// % protected region % [Set readonly for BC10 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC10 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC10 Subjective here] off begin
					// % protected region % [Add other validators for BC10 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC10 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC10 Subjective here] end
			},
			{
				name: 'bc10Objective',
				// % protected region % [Set displayName for BC10 Objective here] off begin
				displayName: 'BC10 Objective',
				// % protected region % [Set displayName for BC10 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC10 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC10 Objective here] end
				// % protected region % [Set isSensitive for BC10 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC10 Objective here] end
				// % protected region % [Set readonly for BC10 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC10 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC10 Objective here] off begin
					// % protected region % [Add other validators for BC10 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC10 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC10 Objective here] end
			},
			{
				name: 'bc11Subjective',
				// % protected region % [Set displayName for BC11 Subjective here] off begin
				displayName: 'BC11 Subjective',
				// % protected region % [Set displayName for BC11 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC11 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC11 Subjective here] end
				// % protected region % [Set isSensitive for BC11 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC11 Subjective here] end
				// % protected region % [Set readonly for BC11 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC11 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC11 Subjective here] off begin
					// % protected region % [Add other validators for BC11 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC11 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC11 Subjective here] end
			},
			{
				name: 'bc11Objective',
				// % protected region % [Set displayName for BC11 Objective here] off begin
				displayName: 'BC11 Objective',
				// % protected region % [Set displayName for BC11 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC11 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC11 Objective here] end
				// % protected region % [Set isSensitive for BC11 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC11 Objective here] end
				// % protected region % [Set readonly for BC11 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC11 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC11 Objective here] off begin
					// % protected region % [Add other validators for BC11 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC11 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC11 Objective here] end
			},
			{
				name: 'bc12Subjective',
				// % protected region % [Set displayName for BC12 Subjective here] off begin
				displayName: 'BC12 Subjective',
				// % protected region % [Set displayName for BC12 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC12 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC12 Subjective here] end
				// % protected region % [Set isSensitive for BC12 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC12 Subjective here] end
				// % protected region % [Set readonly for BC12 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC12 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC12 Subjective here] off begin
					// % protected region % [Add other validators for BC12 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC12 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC12 Subjective here] end
			},
			{
				name: 'bc12Objective',
				// % protected region % [Set displayName for BC12 Objective here] off begin
				displayName: 'BC12 Objective',
				// % protected region % [Set displayName for BC12 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC12 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC12 Objective here] end
				// % protected region % [Set isSensitive for BC12 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC12 Objective here] end
				// % protected region % [Set readonly for BC12 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC12 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC12 Objective here] off begin
					// % protected region % [Add other validators for BC12 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC12 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC12 Objective here] end
			},
			{
				name: 'bc13Subjective',
				// % protected region % [Set displayName for BC13 Subjective here] off begin
				displayName: 'BC13 Subjective',
				// % protected region % [Set displayName for BC13 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC13 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC13 Subjective here] end
				// % protected region % [Set isSensitive for BC13 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC13 Subjective here] end
				// % protected region % [Set readonly for BC13 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC13 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC13 Subjective here] off begin
					// % protected region % [Add other validators for BC13 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC13 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC13 Subjective here] end
			},
			{
				name: 'bc13Objective',
				// % protected region % [Set displayName for BC13 Objective here] off begin
				displayName: 'BC13 Objective',
				// % protected region % [Set displayName for BC13 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC13 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC13 Objective here] end
				// % protected region % [Set isSensitive for BC13 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC13 Objective here] end
				// % protected region % [Set readonly for BC13 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC13 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC13 Objective here] off begin
					// % protected region % [Add other validators for BC13 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC13 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC13 Objective here] end
			},
			{
				name: 'bc14Subjective',
				// % protected region % [Set displayName for BC14 Subjective here] off begin
				displayName: 'BC14 Subjective',
				// % protected region % [Set displayName for BC14 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC14 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC14 Subjective here] end
				// % protected region % [Set isSensitive for BC14 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC14 Subjective here] end
				// % protected region % [Set readonly for BC14 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC14 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC14 Subjective here] off begin
					// % protected region % [Add other validators for BC14 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC14 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC14 Subjective here] end
			},
			{
				name: 'bc14Objective',
				// % protected region % [Set displayName for BC14 Objective here] off begin
				displayName: 'BC14 Objective',
				// % protected region % [Set displayName for BC14 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC14 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC14 Objective here] end
				// % protected region % [Set isSensitive for BC14 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC14 Objective here] end
				// % protected region % [Set readonly for BC14 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC14 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC14 Objective here] off begin
					// % protected region % [Add other validators for BC14 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC14 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC14 Objective here] end
			},
			{
				name: 'bc15Subjective',
				// % protected region % [Set displayName for BC15 Subjective here] off begin
				displayName: 'BC15 Subjective',
				// % protected region % [Set displayName for BC15 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC15 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC15 Subjective here] end
				// % protected region % [Set isSensitive for BC15 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC15 Subjective here] end
				// % protected region % [Set readonly for BC15 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC15 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC15 Subjective here] off begin
					// % protected region % [Add other validators for BC15 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC15 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC15 Subjective here] end
			},
			{
				name: 'bc15Objective',
				// % protected region % [Set displayName for BC15 Objective here] off begin
				displayName: 'BC15 Objective',
				// % protected region % [Set displayName for BC15 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC15 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC15 Objective here] end
				// % protected region % [Set isSensitive for BC15 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC15 Objective here] end
				// % protected region % [Set readonly for BC15 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC15 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC15 Objective here] off begin
					// % protected region % [Add other validators for BC15 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC15 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC15 Objective here] end
			},
			{
				name: 'bc16Subjective',
				// % protected region % [Set displayName for BC16 Subjective here] off begin
				displayName: 'BC16 Subjective',
				// % protected region % [Set displayName for BC16 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC16 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC16 Subjective here] end
				// % protected region % [Set isSensitive for BC16 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC16 Subjective here] end
				// % protected region % [Set readonly for BC16 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC16 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC16 Subjective here] off begin
					// % protected region % [Add other validators for BC16 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC16 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC16 Subjective here] end
			},
			{
				name: 'bc16Objective',
				// % protected region % [Set displayName for BC16 Objective here] off begin
				displayName: 'BC16 Objective',
				// % protected region % [Set displayName for BC16 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC16 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC16 Objective here] end
				// % protected region % [Set isSensitive for BC16 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC16 Objective here] end
				// % protected region % [Set readonly for BC16 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC16 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC16 Objective here] off begin
					// % protected region % [Add other validators for BC16 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC16 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC16 Objective here] end
			},
			{
				name: 'bc17Subjective',
				// % protected region % [Set displayName for BC17 Subjective here] off begin
				displayName: 'BC17 Subjective',
				// % protected region % [Set displayName for BC17 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC17 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC17 Subjective here] end
				// % protected region % [Set isSensitive for BC17 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC17 Subjective here] end
				// % protected region % [Set readonly for BC17 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC17 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC17 Subjective here] off begin
					// % protected region % [Add other validators for BC17 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC17 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC17 Subjective here] end
			},
			{
				name: 'bc17Objective',
				// % protected region % [Set displayName for BC17 Objective here] off begin
				displayName: 'BC17 Objective',
				// % protected region % [Set displayName for BC17 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC17 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC17 Objective here] end
				// % protected region % [Set isSensitive for BC17 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC17 Objective here] end
				// % protected region % [Set readonly for BC17 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC17 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC17 Objective here] off begin
					// % protected region % [Add other validators for BC17 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC17 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC17 Objective here] end
			},
			{
				name: 'bc18Subjective',
				// % protected region % [Set displayName for BC18 Subjective here] off begin
				displayName: 'BC18 Subjective',
				// % protected region % [Set displayName for BC18 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC18 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC18 Subjective here] end
				// % protected region % [Set isSensitive for BC18 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC18 Subjective here] end
				// % protected region % [Set readonly for BC18 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC18 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC18 Subjective here] off begin
					// % protected region % [Add other validators for BC18 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC18 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC18 Subjective here] end
			},
			{
				name: 'bc18Objective',
				// % protected region % [Set displayName for BC18 Objective here] off begin
				displayName: 'BC18 Objective',
				// % protected region % [Set displayName for BC18 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC18 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC18 Objective here] end
				// % protected region % [Set isSensitive for BC18 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC18 Objective here] end
				// % protected region % [Set readonly for BC18 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC18 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC18 Objective here] off begin
					// % protected region % [Add other validators for BC18 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC18 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC18 Objective here] end
			},
			{
				name: 'bc19Subjective',
				// % protected region % [Set displayName for BC19 Subjective here] off begin
				displayName: 'BC19 Subjective',
				// % protected region % [Set displayName for BC19 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC19 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC19 Subjective here] end
				// % protected region % [Set isSensitive for BC19 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC19 Subjective here] end
				// % protected region % [Set readonly for BC19 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC19 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC19 Subjective here] off begin
					// % protected region % [Add other validators for BC19 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC19 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC19 Subjective here] end
			},
			{
				name: 'bc19Objective',
				// % protected region % [Set displayName for BC19 Objective here] off begin
				displayName: 'BC19 Objective',
				// % protected region % [Set displayName for BC19 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC19 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC19 Objective here] end
				// % protected region % [Set isSensitive for BC19 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC19 Objective here] end
				// % protected region % [Set readonly for BC19 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC19 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC19 Objective here] off begin
					// % protected region % [Add other validators for BC19 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC19 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC19 Objective here] end
			},
			{
				name: 'bc20Subjective',
				// % protected region % [Set displayName for BC20 Subjective here] off begin
				displayName: 'BC20 Subjective',
				// % protected region % [Set displayName for BC20 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC20 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC20 Subjective here] end
				// % protected region % [Set isSensitive for BC20 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC20 Subjective here] end
				// % protected region % [Set readonly for BC20 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC20 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC20 Subjective here] off begin
					// % protected region % [Add other validators for BC20 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC20 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC20 Subjective here] end
			},
			{
				name: 'bc20Objective',
				// % protected region % [Set displayName for BC20 Objective here] off begin
				displayName: 'BC20 Objective',
				// % protected region % [Set displayName for BC20 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC20 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC20 Objective here] end
				// % protected region % [Set isSensitive for BC20 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC20 Objective here] end
				// % protected region % [Set readonly for BC20 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC20 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC20 Objective here] off begin
					// % protected region % [Add other validators for BC20 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC20 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC20 Objective here] end
			},
			{
				name: 'bc21Subjective',
				// % protected region % [Set displayName for BC21 Subjective here] off begin
				displayName: 'BC21 Subjective',
				// % protected region % [Set displayName for BC21 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC21 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC21 Subjective here] end
				// % protected region % [Set isSensitive for BC21 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC21 Subjective here] end
				// % protected region % [Set readonly for BC21 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC21 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC21 Subjective here] off begin
					// % protected region % [Add other validators for BC21 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC21 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC21 Subjective here] end
			},
			{
				name: 'bc21Objective',
				// % protected region % [Set displayName for BC21 Objective here] off begin
				displayName: 'BC21 Objective',
				// % protected region % [Set displayName for BC21 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC21 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC21 Objective here] end
				// % protected region % [Set isSensitive for BC21 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC21 Objective here] end
				// % protected region % [Set readonly for BC21 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC21 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC21 Objective here] off begin
					// % protected region % [Add other validators for BC21 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC21 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC21 Objective here] end
			},
			{
				name: 'bc22Subjective',
				// % protected region % [Set displayName for BC22 Subjective here] off begin
				displayName: 'BC22 Subjective',
				// % protected region % [Set displayName for BC22 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC22 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC22 Subjective here] end
				// % protected region % [Set isSensitive for BC22 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC22 Subjective here] end
				// % protected region % [Set readonly for BC22 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC22 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC22 Subjective here] off begin
					// % protected region % [Add other validators for BC22 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC22 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC22 Subjective here] end
			},
			{
				name: 'bc22Objective',
				// % protected region % [Set displayName for BC22 Objective here] off begin
				displayName: 'BC22 Objective',
				// % protected region % [Set displayName for BC22 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC22 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC22 Objective here] end
				// % protected region % [Set isSensitive for BC22 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC22 Objective here] end
				// % protected region % [Set readonly for BC22 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC22 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC22 Objective here] off begin
					// % protected region % [Add other validators for BC22 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC22 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC22 Objective here] end
			},
			{
				name: 'bc23Subjective',
				// % protected region % [Set displayName for BC23 Subjective here] off begin
				displayName: 'BC23 Subjective',
				// % protected region % [Set displayName for BC23 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC23 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC23 Subjective here] end
				// % protected region % [Set isSensitive for BC23 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC23 Subjective here] end
				// % protected region % [Set readonly for BC23 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC23 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC23 Subjective here] off begin
					// % protected region % [Add other validators for BC23 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC23 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC23 Subjective here] end
			},
			{
				name: 'bc23Objective',
				// % protected region % [Set displayName for BC23 Objective here] off begin
				displayName: 'BC23 Objective',
				// % protected region % [Set displayName for BC23 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC23 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC23 Objective here] end
				// % protected region % [Set isSensitive for BC23 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC23 Objective here] end
				// % protected region % [Set readonly for BC23 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC23 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC23 Objective here] off begin
					// % protected region % [Add other validators for BC23 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC23 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC23 Objective here] end
			},
			{
				name: 'bc24Subjective',
				// % protected region % [Set displayName for BC24 Subjective here] off begin
				displayName: 'BC24 Subjective',
				// % protected region % [Set displayName for BC24 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC24 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC24 Subjective here] end
				// % protected region % [Set isSensitive for BC24 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC24 Subjective here] end
				// % protected region % [Set readonly for BC24 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC24 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC24 Subjective here] off begin
					// % protected region % [Add other validators for BC24 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC24 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC24 Subjective here] end
			},
			{
				name: 'bc24Objective',
				// % protected region % [Set displayName for BC24 Objective here] off begin
				displayName: 'BC24 Objective',
				// % protected region % [Set displayName for BC24 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC24 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC24 Objective here] end
				// % protected region % [Set isSensitive for BC24 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC24 Objective here] end
				// % protected region % [Set readonly for BC24 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC24 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC24 Objective here] off begin
					// % protected region % [Add other validators for BC24 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC24 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC24 Objective here] end
			},
			{
				name: 'bc25Subjective',
				// % protected region % [Set displayName for BC25 Subjective here] off begin
				displayName: 'BC25 Subjective',
				// % protected region % [Set displayName for BC25 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC25 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC25 Subjective here] end
				// % protected region % [Set isSensitive for BC25 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC25 Subjective here] end
				// % protected region % [Set readonly for BC25 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC25 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC25 Subjective here] off begin
					// % protected region % [Add other validators for BC25 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC25 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC25 Subjective here] end
			},
			{
				name: 'bc25Objective',
				// % protected region % [Set displayName for BC25 Objective here] off begin
				displayName: 'BC25 Objective',
				// % protected region % [Set displayName for BC25 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC25 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC25 Objective here] end
				// % protected region % [Set isSensitive for BC25 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC25 Objective here] end
				// % protected region % [Set readonly for BC25 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC25 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC25 Objective here] off begin
					// % protected region % [Add other validators for BC25 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC25 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC25 Objective here] end
			},
			{
				name: 'bc26Subjective',
				// % protected region % [Set displayName for BC26 Subjective here] off begin
				displayName: 'BC26 Subjective',
				// % protected region % [Set displayName for BC26 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC26 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC26 Subjective here] end
				// % protected region % [Set isSensitive for BC26 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC26 Subjective here] end
				// % protected region % [Set readonly for BC26 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC26 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC26 Subjective here] off begin
					// % protected region % [Add other validators for BC26 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC26 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC26 Subjective here] end
			},
			{
				name: 'bc26Objective',
				// % protected region % [Set displayName for BC26 Objective here] off begin
				displayName: 'BC26 Objective',
				// % protected region % [Set displayName for BC26 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC26 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC26 Objective here] end
				// % protected region % [Set isSensitive for BC26 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC26 Objective here] end
				// % protected region % [Set readonly for BC26 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC26 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC26 Objective here] off begin
					// % protected region % [Add other validators for BC26 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC26 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC26 Objective here] end
			},
			{
				name: 'bc27Subjective',
				// % protected region % [Set displayName for BC27 Subjective here] off begin
				displayName: 'BC27 Subjective',
				// % protected region % [Set displayName for BC27 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC27 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC27 Subjective here] end
				// % protected region % [Set isSensitive for BC27 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC27 Subjective here] end
				// % protected region % [Set readonly for BC27 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC27 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC27 Subjective here] off begin
					// % protected region % [Add other validators for BC27 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC27 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC27 Subjective here] end
			},
			{
				name: 'bc27Objective',
				// % protected region % [Set displayName for BC27 Objective here] off begin
				displayName: 'BC27 Objective',
				// % protected region % [Set displayName for BC27 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC27 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC27 Objective here] end
				// % protected region % [Set isSensitive for BC27 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC27 Objective here] end
				// % protected region % [Set readonly for BC27 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC27 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC27 Objective here] off begin
					// % protected region % [Add other validators for BC27 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC27 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC27 Objective here] end
			},
			{
				name: 'bc28Subjective',
				// % protected region % [Set displayName for BC28 Subjective here] off begin
				displayName: 'BC28 Subjective',
				// % protected region % [Set displayName for BC28 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC28 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC28 Subjective here] end
				// % protected region % [Set isSensitive for BC28 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC28 Subjective here] end
				// % protected region % [Set readonly for BC28 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC28 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC28 Subjective here] off begin
					// % protected region % [Add other validators for BC28 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC28 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC28 Subjective here] end
			},
			{
				name: 'bc28Objective',
				// % protected region % [Set displayName for BC28 Objective here] off begin
				displayName: 'BC28 Objective',
				// % protected region % [Set displayName for BC28 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC28 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC28 Objective here] end
				// % protected region % [Set isSensitive for BC28 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC28 Objective here] end
				// % protected region % [Set readonly for BC28 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC28 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC28 Objective here] off begin
					// % protected region % [Add other validators for BC28 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC28 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC28 Objective here] end
			},
			{
				name: 'bc29Subjective',
				// % protected region % [Set displayName for BC29 Subjective here] off begin
				displayName: 'BC29 Subjective',
				// % protected region % [Set displayName for BC29 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC29 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC29 Subjective here] end
				// % protected region % [Set isSensitive for BC29 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC29 Subjective here] end
				// % protected region % [Set readonly for BC29 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC29 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC29 Subjective here] off begin
					// % protected region % [Add other validators for BC29 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC29 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC29 Subjective here] end
			},
			{
				name: 'bc29Objective',
				// % protected region % [Set displayName for BC29 Objective here] off begin
				displayName: 'BC29 Objective',
				// % protected region % [Set displayName for BC29 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC29 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC29 Objective here] end
				// % protected region % [Set isSensitive for BC29 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC29 Objective here] end
				// % protected region % [Set readonly for BC29 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC29 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC29 Objective here] off begin
					// % protected region % [Add other validators for BC29 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC29 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC29 Objective here] end
			},
			{
				name: 'bc30Subjective',
				// % protected region % [Set displayName for BC30 Subjective here] off begin
				displayName: 'BC30 Subjective',
				// % protected region % [Set displayName for BC30 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC30 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC30 Subjective here] end
				// % protected region % [Set isSensitive for BC30 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC30 Subjective here] end
				// % protected region % [Set readonly for BC30 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC30 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC30 Subjective here] off begin
					// % protected region % [Add other validators for BC30 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC30 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC30 Subjective here] end
			},
			{
				name: 'bc30Objective',
				// % protected region % [Set displayName for BC30 Objective here] off begin
				displayName: 'BC30 Objective',
				// % protected region % [Set displayName for BC30 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC30 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC30 Objective here] end
				// % protected region % [Set isSensitive for BC30 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC30 Objective here] end
				// % protected region % [Set readonly for BC30 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC30 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC30 Objective here] off begin
					// % protected region % [Add other validators for BC30 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC30 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC30 Objective here] end
			},
			{
				name: 'bc31Subjective',
				// % protected region % [Set displayName for BC31 Subjective here] off begin
				displayName: 'BC31 Subjective',
				// % protected region % [Set displayName for BC31 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC31 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC31 Subjective here] end
				// % protected region % [Set isSensitive for BC31 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC31 Subjective here] end
				// % protected region % [Set readonly for BC31 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC31 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC31 Subjective here] off begin
					// % protected region % [Add other validators for BC31 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC31 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC31 Subjective here] end
			},
			{
				name: 'bc31Objective',
				// % protected region % [Set displayName for BC31 Objective here] off begin
				displayName: 'BC31 Objective',
				// % protected region % [Set displayName for BC31 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC31 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC31 Objective here] end
				// % protected region % [Set isSensitive for BC31 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC31 Objective here] end
				// % protected region % [Set readonly for BC31 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC31 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC31 Objective here] off begin
					// % protected region % [Add other validators for BC31 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC31 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC31 Objective here] end
			},
			{
				name: 'bc32Subjective',
				// % protected region % [Set displayName for BC32 Subjective here] off begin
				displayName: 'BC32 Subjective',
				// % protected region % [Set displayName for BC32 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC32 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC32 Subjective here] end
				// % protected region % [Set isSensitive for BC32 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC32 Subjective here] end
				// % protected region % [Set readonly for BC32 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC32 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC32 Subjective here] off begin
					// % protected region % [Add other validators for BC32 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC32 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC32 Subjective here] end
			},
			{
				name: 'bc32Objective',
				// % protected region % [Set displayName for BC32 Objective here] off begin
				displayName: 'BC32 Objective',
				// % protected region % [Set displayName for BC32 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC32 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC32 Objective here] end
				// % protected region % [Set isSensitive for BC32 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC32 Objective here] end
				// % protected region % [Set readonly for BC32 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC32 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC32 Objective here] off begin
					// % protected region % [Add other validators for BC32 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC32 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC32 Objective here] end
			},
			{
				name: 'bc33Subjective',
				// % protected region % [Set displayName for BC33 Subjective here] off begin
				displayName: 'BC33 Subjective',
				// % protected region % [Set displayName for BC33 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC33 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC33 Subjective here] end
				// % protected region % [Set isSensitive for BC33 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC33 Subjective here] end
				// % protected region % [Set readonly for BC33 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC33 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC33 Subjective here] off begin
					// % protected region % [Add other validators for BC33 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC33 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC33 Subjective here] end
			},
			{
				name: 'bc33Objective',
				// % protected region % [Set displayName for BC33 Objective here] off begin
				displayName: 'BC33 Objective',
				// % protected region % [Set displayName for BC33 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC33 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC33 Objective here] end
				// % protected region % [Set isSensitive for BC33 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC33 Objective here] end
				// % protected region % [Set readonly for BC33 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC33 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC33 Objective here] off begin
					// % protected region % [Add other validators for BC33 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC33 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC33 Objective here] end
			},
			{
				name: 'bc34Subjective',
				// % protected region % [Set displayName for BC34 Subjective here] off begin
				displayName: 'BC34 Subjective',
				// % protected region % [Set displayName for BC34 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC34 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC34 Subjective here] end
				// % protected region % [Set isSensitive for BC34 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC34 Subjective here] end
				// % protected region % [Set readonly for BC34 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC34 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC34 Subjective here] off begin
					// % protected region % [Add other validators for BC34 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC34 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC34 Subjective here] end
			},
			{
				name: 'bc34Objective',
				// % protected region % [Set displayName for BC34 Objective here] off begin
				displayName: 'BC34 Objective',
				// % protected region % [Set displayName for BC34 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC34 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC34 Objective here] end
				// % protected region % [Set isSensitive for BC34 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC34 Objective here] end
				// % protected region % [Set readonly for BC34 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC34 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC34 Objective here] off begin
					// % protected region % [Add other validators for BC34 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC34 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC34 Objective here] end
			},
			{
				name: 'bc35Subjective',
				// % protected region % [Set displayName for BC35 Subjective here] off begin
				displayName: 'BC35 Subjective',
				// % protected region % [Set displayName for BC35 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC35 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC35 Subjective here] end
				// % protected region % [Set isSensitive for BC35 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC35 Subjective here] end
				// % protected region % [Set readonly for BC35 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC35 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC35 Subjective here] off begin
					// % protected region % [Add other validators for BC35 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC35 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC35 Subjective here] end
			},
			{
				name: 'bc35Objective',
				// % protected region % [Set displayName for BC35 Objective here] off begin
				displayName: 'BC35 Objective',
				// % protected region % [Set displayName for BC35 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC35 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC35 Objective here] end
				// % protected region % [Set isSensitive for BC35 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC35 Objective here] end
				// % protected region % [Set readonly for BC35 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC35 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC35 Objective here] off begin
					// % protected region % [Add other validators for BC35 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC35 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC35 Objective here] end
			},
			{
				name: 'bc36Subjective',
				// % protected region % [Set displayName for BC36 Subjective here] off begin
				displayName: 'BC36 Subjective',
				// % protected region % [Set displayName for BC36 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC36 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC36 Subjective here] end
				// % protected region % [Set isSensitive for BC36 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC36 Subjective here] end
				// % protected region % [Set readonly for BC36 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC36 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC36 Subjective here] off begin
					// % protected region % [Add other validators for BC36 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC36 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC36 Subjective here] end
			},
			{
				name: 'bc36Objective',
				// % protected region % [Set displayName for BC36 Objective here] off begin
				displayName: 'BC36 Objective',
				// % protected region % [Set displayName for BC36 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC36 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC36 Objective here] end
				// % protected region % [Set isSensitive for BC36 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC36 Objective here] end
				// % protected region % [Set readonly for BC36 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC36 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC36 Objective here] off begin
					// % protected region % [Add other validators for BC36 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC36 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC36 Objective here] end
			},
			{
				name: 'bc37Subjective',
				// % protected region % [Set displayName for BC37 Subjective here] off begin
				displayName: 'BC37 Subjective',
				// % protected region % [Set displayName for BC37 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC37 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC37 Subjective here] end
				// % protected region % [Set isSensitive for BC37 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC37 Subjective here] end
				// % protected region % [Set readonly for BC37 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC37 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC37 Subjective here] off begin
					// % protected region % [Add other validators for BC37 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC37 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC37 Subjective here] end
			},
			{
				name: 'bc37Objective',
				// % protected region % [Set displayName for BC37 Objective here] off begin
				displayName: 'BC37 Objective',
				// % protected region % [Set displayName for BC37 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC37 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC37 Objective here] end
				// % protected region % [Set isSensitive for BC37 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC37 Objective here] end
				// % protected region % [Set readonly for BC37 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC37 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC37 Objective here] off begin
					// % protected region % [Add other validators for BC37 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC37 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC37 Objective here] end
			},
			{
				name: 'bc38Subjective',
				// % protected region % [Set displayName for BC38 Subjective here] off begin
				displayName: 'BC38 Subjective',
				// % protected region % [Set displayName for BC38 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC38 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC38 Subjective here] end
				// % protected region % [Set isSensitive for BC38 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC38 Subjective here] end
				// % protected region % [Set readonly for BC38 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC38 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC38 Subjective here] off begin
					// % protected region % [Add other validators for BC38 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC38 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC38 Subjective here] end
			},
			{
				name: 'bc38Objective',
				// % protected region % [Set displayName for BC38 Objective here] off begin
				displayName: 'BC38 Objective',
				// % protected region % [Set displayName for BC38 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC38 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC38 Objective here] end
				// % protected region % [Set isSensitive for BC38 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC38 Objective here] end
				// % protected region % [Set readonly for BC38 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC38 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC38 Objective here] off begin
					// % protected region % [Add other validators for BC38 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC38 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC38 Objective here] end
			},
			{
				name: 'bc39Subjective',
				// % protected region % [Set displayName for BC39 Subjective here] off begin
				displayName: 'BC39 Subjective',
				// % protected region % [Set displayName for BC39 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC39 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC39 Subjective here] end
				// % protected region % [Set isSensitive for BC39 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC39 Subjective here] end
				// % protected region % [Set readonly for BC39 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC39 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC39 Subjective here] off begin
					// % protected region % [Add other validators for BC39 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC39 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC39 Subjective here] end
			},
			{
				name: 'bc39Objective',
				// % protected region % [Set displayName for BC39 Objective here] off begin
				displayName: 'BC39 Objective',
				// % protected region % [Set displayName for BC39 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC39 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC39 Objective here] end
				// % protected region % [Set isSensitive for BC39 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC39 Objective here] end
				// % protected region % [Set readonly for BC39 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC39 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC39 Objective here] off begin
					// % protected region % [Add other validators for BC39 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC39 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC39 Objective here] end
			},
			{
				name: 'bc40Subjective',
				// % protected region % [Set displayName for BC40 Subjective here] off begin
				displayName: 'BC40 Subjective',
				// % protected region % [Set displayName for BC40 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC40 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC40 Subjective here] end
				// % protected region % [Set isSensitive for BC40 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC40 Subjective here] end
				// % protected region % [Set readonly for BC40 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC40 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC40 Subjective here] off begin
					// % protected region % [Add other validators for BC40 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC40 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC40 Subjective here] end
			},
			{
				name: 'bc40Objective',
				// % protected region % [Set displayName for BC40 Objective here] off begin
				displayName: 'BC40 Objective',
				// % protected region % [Set displayName for BC40 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC40 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC40 Objective here] end
				// % protected region % [Set isSensitive for BC40 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC40 Objective here] end
				// % protected region % [Set readonly for BC40 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC40 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC40 Objective here] off begin
					// % protected region % [Add other validators for BC40 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC40 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC40 Objective here] end
			},
			{
				name: 'bc41Subjective',
				// % protected region % [Set displayName for BC41 Subjective here] off begin
				displayName: 'BC41 Subjective',
				// % protected region % [Set displayName for BC41 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC41 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC41 Subjective here] end
				// % protected region % [Set isSensitive for BC41 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC41 Subjective here] end
				// % protected region % [Set readonly for BC41 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC41 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC41 Subjective here] off begin
					// % protected region % [Add other validators for BC41 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC41 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC41 Subjective here] end
			},
			{
				name: 'bc41Objective',
				// % protected region % [Set displayName for BC41 Objective here] off begin
				displayName: 'BC41 Objective',
				// % protected region % [Set displayName for BC41 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC41 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC41 Objective here] end
				// % protected region % [Set isSensitive for BC41 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC41 Objective here] end
				// % protected region % [Set readonly for BC41 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC41 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC41 Objective here] off begin
					// % protected region % [Add other validators for BC41 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC41 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC41 Objective here] end
			},
			{
				name: 'bc42Subjective',
				// % protected region % [Set displayName for BC42 Subjective here] off begin
				displayName: 'BC42 Subjective',
				// % protected region % [Set displayName for BC42 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC42 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC42 Subjective here] end
				// % protected region % [Set isSensitive for BC42 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC42 Subjective here] end
				// % protected region % [Set readonly for BC42 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC42 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC42 Subjective here] off begin
					// % protected region % [Add other validators for BC42 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC42 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC42 Subjective here] end
			},
			{
				name: 'bc42Objective',
				// % protected region % [Set displayName for BC42 Objective here] off begin
				displayName: 'BC42 Objective',
				// % protected region % [Set displayName for BC42 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC42 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC42 Objective here] end
				// % protected region % [Set isSensitive for BC42 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC42 Objective here] end
				// % protected region % [Set readonly for BC42 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC42 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC42 Objective here] off begin
					// % protected region % [Add other validators for BC42 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC42 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC42 Objective here] end
			},
			{
				name: 'bc43Subjective',
				// % protected region % [Set displayName for BC43 Subjective here] off begin
				displayName: 'BC43 Subjective',
				// % protected region % [Set displayName for BC43 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC43 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC43 Subjective here] end
				// % protected region % [Set isSensitive for BC43 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC43 Subjective here] end
				// % protected region % [Set readonly for BC43 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC43 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC43 Subjective here] off begin
					// % protected region % [Add other validators for BC43 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC43 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC43 Subjective here] end
			},
			{
				name: 'bc43Objective',
				// % protected region % [Set displayName for BC43 Objective here] off begin
				displayName: 'BC43 Objective',
				// % protected region % [Set displayName for BC43 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC43 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC43 Objective here] end
				// % protected region % [Set isSensitive for BC43 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC43 Objective here] end
				// % protected region % [Set readonly for BC43 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC43 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC43 Objective here] off begin
					// % protected region % [Add other validators for BC43 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC43 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC43 Objective here] end
			},
			{
				name: 'bc44Subjective',
				// % protected region % [Set displayName for BC44 Subjective here] off begin
				displayName: 'BC44 Subjective',
				// % protected region % [Set displayName for BC44 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC44 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC44 Subjective here] end
				// % protected region % [Set isSensitive for BC44 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC44 Subjective here] end
				// % protected region % [Set readonly for BC44 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC44 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC44 Subjective here] off begin
					// % protected region % [Add other validators for BC44 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC44 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC44 Subjective here] end
			},
			{
				name: 'bc44Objective',
				// % protected region % [Set displayName for BC44 Objective here] off begin
				displayName: 'BC44 Objective',
				// % protected region % [Set displayName for BC44 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC44 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC44 Objective here] end
				// % protected region % [Set isSensitive for BC44 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC44 Objective here] end
				// % protected region % [Set readonly for BC44 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC44 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC44 Objective here] off begin
					// % protected region % [Add other validators for BC44 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC44 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC44 Objective here] end
			},
			{
				name: 'bc45Subjective',
				// % protected region % [Set displayName for BC45 Subjective here] off begin
				displayName: 'BC45 Subjective',
				// % protected region % [Set displayName for BC45 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC45 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC45 Subjective here] end
				// % protected region % [Set isSensitive for BC45 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC45 Subjective here] end
				// % protected region % [Set readonly for BC45 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC45 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC45 Subjective here] off begin
					// % protected region % [Add other validators for BC45 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC45 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC45 Subjective here] end
			},
			{
				name: 'bc45Objective',
				// % protected region % [Set displayName for BC45 Objective here] off begin
				displayName: 'BC45 Objective',
				// % protected region % [Set displayName for BC45 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC45 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC45 Objective here] end
				// % protected region % [Set isSensitive for BC45 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC45 Objective here] end
				// % protected region % [Set readonly for BC45 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC45 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC45 Objective here] off begin
					// % protected region % [Add other validators for BC45 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC45 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC45 Objective here] end
			},
			{
				name: 'bc46Subjective',
				// % protected region % [Set displayName for BC46 Subjective here] off begin
				displayName: 'BC46 Subjective',
				// % protected region % [Set displayName for BC46 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC46 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC46 Subjective here] end
				// % protected region % [Set isSensitive for BC46 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC46 Subjective here] end
				// % protected region % [Set readonly for BC46 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC46 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC46 Subjective here] off begin
					// % protected region % [Add other validators for BC46 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC46 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC46 Subjective here] end
			},
			{
				name: 'bc46Objective',
				// % protected region % [Set displayName for BC46 Objective here] off begin
				displayName: 'BC46 Objective',
				// % protected region % [Set displayName for BC46 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC46 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC46 Objective here] end
				// % protected region % [Set isSensitive for BC46 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC46 Objective here] end
				// % protected region % [Set readonly for BC46 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC46 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC46 Objective here] off begin
					// % protected region % [Add other validators for BC46 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC46 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC46 Objective here] end
			},
			{
				name: 'bc47Subjective',
				// % protected region % [Set displayName for BC47 Subjective here] off begin
				displayName: 'BC47 Subjective',
				// % protected region % [Set displayName for BC47 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC47 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC47 Subjective here] end
				// % protected region % [Set isSensitive for BC47 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC47 Subjective here] end
				// % protected region % [Set readonly for BC47 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC47 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC47 Subjective here] off begin
					// % protected region % [Add other validators for BC47 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC47 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC47 Subjective here] end
			},
			{
				name: 'bc47Objective',
				// % protected region % [Set displayName for BC47 Objective here] off begin
				displayName: 'BC47 Objective',
				// % protected region % [Set displayName for BC47 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC47 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC47 Objective here] end
				// % protected region % [Set isSensitive for BC47 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC47 Objective here] end
				// % protected region % [Set readonly for BC47 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC47 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC47 Objective here] off begin
					// % protected region % [Add other validators for BC47 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC47 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC47 Objective here] end
			},
			{
				name: 'bc48Subjective',
				// % protected region % [Set displayName for BC48 Subjective here] off begin
				displayName: 'BC48 Subjective',
				// % protected region % [Set displayName for BC48 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC48 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC48 Subjective here] end
				// % protected region % [Set isSensitive for BC48 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC48 Subjective here] end
				// % protected region % [Set readonly for BC48 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC48 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC48 Subjective here] off begin
					// % protected region % [Add other validators for BC48 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC48 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC48 Subjective here] end
			},
			{
				name: 'bc48Objective',
				// % protected region % [Set displayName for BC48 Objective here] off begin
				displayName: 'BC48 Objective',
				// % protected region % [Set displayName for BC48 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC48 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC48 Objective here] end
				// % protected region % [Set isSensitive for BC48 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC48 Objective here] end
				// % protected region % [Set readonly for BC48 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC48 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC48 Objective here] off begin
					// % protected region % [Add other validators for BC48 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC48 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC48 Objective here] end
			},
			{
				name: 'bc49Subjective',
				// % protected region % [Set displayName for BC49 Subjective here] off begin
				displayName: 'BC49 Subjective',
				// % protected region % [Set displayName for BC49 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC49 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC49 Subjective here] end
				// % protected region % [Set isSensitive for BC49 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC49 Subjective here] end
				// % protected region % [Set readonly for BC49 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC49 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC49 Subjective here] off begin
					// % protected region % [Add other validators for BC49 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC49 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC49 Subjective here] end
			},
			{
				name: 'bc49Objective',
				// % protected region % [Set displayName for BC49 Objective here] off begin
				displayName: 'BC49 Objective',
				// % protected region % [Set displayName for BC49 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC49 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC49 Objective here] end
				// % protected region % [Set isSensitive for BC49 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC49 Objective here] end
				// % protected region % [Set readonly for BC49 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC49 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC49 Objective here] off begin
					// % protected region % [Add other validators for BC49 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC49 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC49 Objective here] end
			},
			{
				name: 'bc50Subjective',
				// % protected region % [Set displayName for BC50 Subjective here] off begin
				displayName: 'BC50 Subjective',
				// % protected region % [Set displayName for BC50 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC50 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC50 Subjective here] end
				// % protected region % [Set isSensitive for BC50 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC50 Subjective here] end
				// % protected region % [Set readonly for BC50 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC50 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC50 Subjective here] off begin
					// % protected region % [Add other validators for BC50 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC50 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC50 Subjective here] end
			},
			{
				name: 'bc50Objective',
				// % protected region % [Set displayName for BC50 Objective here] off begin
				displayName: 'BC50 Objective',
				// % protected region % [Set displayName for BC50 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC50 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC50 Objective here] end
				// % protected region % [Set isSensitive for BC50 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC50 Objective here] end
				// % protected region % [Set readonly for BC50 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC50 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC50 Objective here] off begin
					// % protected region % [Add other validators for BC50 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC50 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC50 Objective here] end
			},
			{
				name: 'bc51Subjective',
				// % protected region % [Set displayName for BC51 Subjective here] off begin
				displayName: 'BC51 Subjective',
				// % protected region % [Set displayName for BC51 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC51 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC51 Subjective here] end
				// % protected region % [Set isSensitive for BC51 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC51 Subjective here] end
				// % protected region % [Set readonly for BC51 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC51 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC51 Subjective here] off begin
					// % protected region % [Add other validators for BC51 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC51 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC51 Subjective here] end
			},
			{
				name: 'bc51Objective',
				// % protected region % [Set displayName for BC51 Objective here] off begin
				displayName: 'BC51 Objective',
				// % protected region % [Set displayName for BC51 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC51 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC51 Objective here] end
				// % protected region % [Set isSensitive for BC51 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC51 Objective here] end
				// % protected region % [Set readonly for BC51 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC51 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC51 Objective here] off begin
					// % protected region % [Add other validators for BC51 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC51 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC51 Objective here] end
			},
			{
				name: 'bc52Subjective',
				// % protected region % [Set displayName for BC52 Subjective here] off begin
				displayName: 'BC52 Subjective',
				// % protected region % [Set displayName for BC52 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC52 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC52 Subjective here] end
				// % protected region % [Set isSensitive for BC52 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC52 Subjective here] end
				// % protected region % [Set readonly for BC52 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC52 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC52 Subjective here] off begin
					// % protected region % [Add other validators for BC52 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC52 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC52 Subjective here] end
			},
			{
				name: 'bc52Objective',
				// % protected region % [Set displayName for BC52 Objective here] off begin
				displayName: 'BC52 Objective',
				// % protected region % [Set displayName for BC52 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC52 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC52 Objective here] end
				// % protected region % [Set isSensitive for BC52 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC52 Objective here] end
				// % protected region % [Set readonly for BC52 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC52 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC52 Objective here] off begin
					// % protected region % [Add other validators for BC52 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC52 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC52 Objective here] end
			},
			{
				name: 'bc53Subjective',
				// % protected region % [Set displayName for BC53 Subjective here] off begin
				displayName: 'BC53 Subjective',
				// % protected region % [Set displayName for BC53 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC53 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC53 Subjective here] end
				// % protected region % [Set isSensitive for BC53 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC53 Subjective here] end
				// % protected region % [Set readonly for BC53 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC53 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC53 Subjective here] off begin
					// % protected region % [Add other validators for BC53 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC53 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC53 Subjective here] end
			},
			{
				name: 'bc53Objective',
				// % protected region % [Set displayName for BC53 Objective here] off begin
				displayName: 'BC53 Objective',
				// % protected region % [Set displayName for BC53 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC53 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC53 Objective here] end
				// % protected region % [Set isSensitive for BC53 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC53 Objective here] end
				// % protected region % [Set readonly for BC53 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC53 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC53 Objective here] off begin
					// % protected region % [Add other validators for BC53 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC53 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC53 Objective here] end
			},
			{
				name: 'bc54Subjective',
				// % protected region % [Set displayName for BC54 Subjective here] off begin
				displayName: 'BC54 Subjective',
				// % protected region % [Set displayName for BC54 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC54 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC54 Subjective here] end
				// % protected region % [Set isSensitive for BC54 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC54 Subjective here] end
				// % protected region % [Set readonly for BC54 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC54 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC54 Subjective here] off begin
					// % protected region % [Add other validators for BC54 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC54 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC54 Subjective here] end
			},
			{
				name: 'bc54Objective',
				// % protected region % [Set displayName for BC54 Objective here] off begin
				displayName: 'BC54 Objective',
				// % protected region % [Set displayName for BC54 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC54 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC54 Objective here] end
				// % protected region % [Set isSensitive for BC54 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC54 Objective here] end
				// % protected region % [Set readonly for BC54 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC54 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC54 Objective here] off begin
					// % protected region % [Add other validators for BC54 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC54 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC54 Objective here] end
			},
			{
				name: 'bc55Subjective',
				// % protected region % [Set displayName for BC55 Subjective here] off begin
				displayName: 'BC55 Subjective',
				// % protected region % [Set displayName for BC55 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC55 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC55 Subjective here] end
				// % protected region % [Set isSensitive for BC55 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC55 Subjective here] end
				// % protected region % [Set readonly for BC55 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC55 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC55 Subjective here] off begin
					// % protected region % [Add other validators for BC55 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC55 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC55 Subjective here] end
			},
			{
				name: 'bc55Objective',
				// % protected region % [Set displayName for BC55 Objective here] off begin
				displayName: 'BC55 Objective',
				// % protected region % [Set displayName for BC55 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC55 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC55 Objective here] end
				// % protected region % [Set isSensitive for BC55 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC55 Objective here] end
				// % protected region % [Set readonly for BC55 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC55 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC55 Objective here] off begin
					// % protected region % [Add other validators for BC55 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC55 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC55 Objective here] end
			},
			{
				name: 'bc56Subjective',
				// % protected region % [Set displayName for BC56 Subjective here] off begin
				displayName: 'BC56 Subjective',
				// % protected region % [Set displayName for BC56 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC56 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC56 Subjective here] end
				// % protected region % [Set isSensitive for BC56 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC56 Subjective here] end
				// % protected region % [Set readonly for BC56 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC56 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC56 Subjective here] off begin
					// % protected region % [Add other validators for BC56 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC56 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC56 Subjective here] end
			},
			{
				name: 'bc56Objective',
				// % protected region % [Set displayName for BC56 Objective here] off begin
				displayName: 'BC56 Objective',
				// % protected region % [Set displayName for BC56 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC56 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC56 Objective here] end
				// % protected region % [Set isSensitive for BC56 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC56 Objective here] end
				// % protected region % [Set readonly for BC56 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC56 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC56 Objective here] off begin
					// % protected region % [Add other validators for BC56 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC56 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC56 Objective here] end
			},
			{
				name: 'bc57Subjective',
				// % protected region % [Set displayName for BC57 Subjective here] off begin
				displayName: 'BC57 Subjective',
				// % protected region % [Set displayName for BC57 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC57 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC57 Subjective here] end
				// % protected region % [Set isSensitive for BC57 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC57 Subjective here] end
				// % protected region % [Set readonly for BC57 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC57 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC57 Subjective here] off begin
					// % protected region % [Add other validators for BC57 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC57 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC57 Subjective here] end
			},
			{
				name: 'bc57Objective',
				// % protected region % [Set displayName for BC57 Objective here] off begin
				displayName: 'BC57 Objective',
				// % protected region % [Set displayName for BC57 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC57 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC57 Objective here] end
				// % protected region % [Set isSensitive for BC57 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC57 Objective here] end
				// % protected region % [Set readonly for BC57 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC57 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC57 Objective here] off begin
					// % protected region % [Add other validators for BC57 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC57 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC57 Objective here] end
			},
			{
				name: 'bc58Subjective',
				// % protected region % [Set displayName for BC58 Subjective here] off begin
				displayName: 'BC58 Subjective',
				// % protected region % [Set displayName for BC58 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC58 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC58 Subjective here] end
				// % protected region % [Set isSensitive for BC58 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC58 Subjective here] end
				// % protected region % [Set readonly for BC58 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC58 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC58 Subjective here] off begin
					// % protected region % [Add other validators for BC58 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC58 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC58 Subjective here] end
			},
			{
				name: 'bc58Objective',
				// % protected region % [Set displayName for BC58 Objective here] off begin
				displayName: 'BC58 Objective',
				// % protected region % [Set displayName for BC58 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC58 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC58 Objective here] end
				// % protected region % [Set isSensitive for BC58 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC58 Objective here] end
				// % protected region % [Set readonly for BC58 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC58 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC58 Objective here] off begin
					// % protected region % [Add other validators for BC58 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC58 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC58 Objective here] end
			},
			{
				name: 'bc59Subjective',
				// % protected region % [Set displayName for BC59 Subjective here] off begin
				displayName: 'BC59 Subjective',
				// % protected region % [Set displayName for BC59 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC59 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC59 Subjective here] end
				// % protected region % [Set isSensitive for BC59 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC59 Subjective here] end
				// % protected region % [Set readonly for BC59 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC59 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC59 Subjective here] off begin
					// % protected region % [Add other validators for BC59 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC59 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC59 Subjective here] end
			},
			{
				name: 'bc59Objective',
				// % protected region % [Set displayName for BC59 Objective here] off begin
				displayName: 'BC59 Objective',
				// % protected region % [Set displayName for BC59 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC59 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC59 Objective here] end
				// % protected region % [Set isSensitive for BC59 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC59 Objective here] end
				// % protected region % [Set readonly for BC59 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC59 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC59 Objective here] off begin
					// % protected region % [Add other validators for BC59 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC59 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC59 Objective here] end
			},
			{
				name: 'bc60Subjective',
				// % protected region % [Set displayName for BC60 Subjective here] off begin
				displayName: 'BC60 Subjective',
				// % protected region % [Set displayName for BC60 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC60 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC60 Subjective here] end
				// % protected region % [Set isSensitive for BC60 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC60 Subjective here] end
				// % protected region % [Set readonly for BC60 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC60 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC60 Subjective here] off begin
					// % protected region % [Add other validators for BC60 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC60 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC60 Subjective here] end
			},
			{
				name: 'bc60Objective',
				// % protected region % [Set displayName for BC60 Objective here] off begin
				displayName: 'BC60 Objective',
				// % protected region % [Set displayName for BC60 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC60 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC60 Objective here] end
				// % protected region % [Set isSensitive for BC60 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC60 Objective here] end
				// % protected region % [Set readonly for BC60 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC60 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC60 Objective here] off begin
					// % protected region % [Add other validators for BC60 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC60 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC60 Objective here] end
			},
			{
				name: 'bc61Subjective',
				// % protected region % [Set displayName for BC61 Subjective here] off begin
				displayName: 'BC61 Subjective',
				// % protected region % [Set displayName for BC61 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC61 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC61 Subjective here] end
				// % protected region % [Set isSensitive for BC61 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC61 Subjective here] end
				// % protected region % [Set readonly for BC61 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC61 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC61 Subjective here] off begin
					// % protected region % [Add other validators for BC61 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC61 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC61 Subjective here] end
			},
			{
				name: 'bc61Objective',
				// % protected region % [Set displayName for BC61 Objective here] off begin
				displayName: 'BC61 Objective',
				// % protected region % [Set displayName for BC61 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC61 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC61 Objective here] end
				// % protected region % [Set isSensitive for BC61 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC61 Objective here] end
				// % protected region % [Set readonly for BC61 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC61 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC61 Objective here] off begin
					// % protected region % [Add other validators for BC61 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC61 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC61 Objective here] end
			},
			{
				name: 'bc62Subjective',
				// % protected region % [Set displayName for BC62 Subjective here] off begin
				displayName: 'BC62 Subjective',
				// % protected region % [Set displayName for BC62 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC62 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC62 Subjective here] end
				// % protected region % [Set isSensitive for BC62 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC62 Subjective here] end
				// % protected region % [Set readonly for BC62 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC62 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC62 Subjective here] off begin
					// % protected region % [Add other validators for BC62 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC62 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC62 Subjective here] end
			},
			{
				name: 'bc62Objective',
				// % protected region % [Set displayName for BC62 Objective here] off begin
				displayName: 'BC62 Objective',
				// % protected region % [Set displayName for BC62 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC62 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC62 Objective here] end
				// % protected region % [Set isSensitive for BC62 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC62 Objective here] end
				// % protected region % [Set readonly for BC62 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC62 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC62 Objective here] off begin
					// % protected region % [Add other validators for BC62 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC62 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC62 Objective here] end
			},
			{
				name: 'bc63Subjective',
				// % protected region % [Set displayName for BC63 Subjective here] off begin
				displayName: 'BC63 Subjective',
				// % protected region % [Set displayName for BC63 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC63 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC63 Subjective here] end
				// % protected region % [Set isSensitive for BC63 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC63 Subjective here] end
				// % protected region % [Set readonly for BC63 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC63 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC63 Subjective here] off begin
					// % protected region % [Add other validators for BC63 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC63 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC63 Subjective here] end
			},
			{
				name: 'bc63Objective',
				// % protected region % [Set displayName for BC63 Objective here] off begin
				displayName: 'BC63 Objective',
				// % protected region % [Set displayName for BC63 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC63 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC63 Objective here] end
				// % protected region % [Set isSensitive for BC63 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC63 Objective here] end
				// % protected region % [Set readonly for BC63 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC63 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC63 Objective here] off begin
					// % protected region % [Add other validators for BC63 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC63 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC63 Objective here] end
			},
			{
				name: 'bc64Subjective',
				// % protected region % [Set displayName for BC64 Subjective here] off begin
				displayName: 'BC64 Subjective',
				// % protected region % [Set displayName for BC64 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC64 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC64 Subjective here] end
				// % protected region % [Set isSensitive for BC64 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC64 Subjective here] end
				// % protected region % [Set readonly for BC64 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC64 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC64 Subjective here] off begin
					// % protected region % [Add other validators for BC64 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC64 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC64 Subjective here] end
			},
			{
				name: 'bc64Objective',
				// % protected region % [Set displayName for BC64 Objective here] off begin
				displayName: 'BC64 Objective',
				// % protected region % [Set displayName for BC64 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC64 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC64 Objective here] end
				// % protected region % [Set isSensitive for BC64 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC64 Objective here] end
				// % protected region % [Set readonly for BC64 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC64 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC64 Objective here] off begin
					// % protected region % [Add other validators for BC64 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC64 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC64 Objective here] end
			},
			{
				name: 'bc65Subjective',
				// % protected region % [Set displayName for BC65 Subjective here] off begin
				displayName: 'BC65 Subjective',
				// % protected region % [Set displayName for BC65 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC65 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC65 Subjective here] end
				// % protected region % [Set isSensitive for BC65 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC65 Subjective here] end
				// % protected region % [Set readonly for BC65 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC65 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC65 Subjective here] off begin
					// % protected region % [Add other validators for BC65 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC65 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC65 Subjective here] end
			},
			{
				name: 'bc65Objective',
				// % protected region % [Set displayName for BC65 Objective here] off begin
				displayName: 'BC65 Objective',
				// % protected region % [Set displayName for BC65 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC65 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC65 Objective here] end
				// % protected region % [Set isSensitive for BC65 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC65 Objective here] end
				// % protected region % [Set readonly for BC65 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC65 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC65 Objective here] off begin
					// % protected region % [Add other validators for BC65 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC65 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC65 Objective here] end
			},
			{
				name: 'bc66Subjective',
				// % protected region % [Set displayName for BC66 Subjective here] off begin
				displayName: 'BC66 Subjective',
				// % protected region % [Set displayName for BC66 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC66 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC66 Subjective here] end
				// % protected region % [Set isSensitive for BC66 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC66 Subjective here] end
				// % protected region % [Set readonly for BC66 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC66 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC66 Subjective here] off begin
					// % protected region % [Add other validators for BC66 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC66 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC66 Subjective here] end
			},
			{
				name: 'bc66Objective',
				// % protected region % [Set displayName for BC66 Objective here] off begin
				displayName: 'BC66 Objective',
				// % protected region % [Set displayName for BC66 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC66 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC66 Objective here] end
				// % protected region % [Set isSensitive for BC66 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC66 Objective here] end
				// % protected region % [Set readonly for BC66 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC66 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC66 Objective here] off begin
					// % protected region % [Add other validators for BC66 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC66 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC66 Objective here] end
			},
			{
				name: 'bc67Subjective',
				// % protected region % [Set displayName for BC67 Subjective here] off begin
				displayName: 'BC67 Subjective',
				// % protected region % [Set displayName for BC67 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC67 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC67 Subjective here] end
				// % protected region % [Set isSensitive for BC67 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC67 Subjective here] end
				// % protected region % [Set readonly for BC67 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC67 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC67 Subjective here] off begin
					// % protected region % [Add other validators for BC67 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC67 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC67 Subjective here] end
			},
			{
				name: 'bc67Objective',
				// % protected region % [Set displayName for BC67 Objective here] off begin
				displayName: 'BC67 Objective',
				// % protected region % [Set displayName for BC67 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC67 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC67 Objective here] end
				// % protected region % [Set isSensitive for BC67 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC67 Objective here] end
				// % protected region % [Set readonly for BC67 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC67 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC67 Objective here] off begin
					// % protected region % [Add other validators for BC67 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC67 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC67 Objective here] end
			},
			{
				name: 'bc68Subjective',
				// % protected region % [Set displayName for BC68 Subjective here] off begin
				displayName: 'BC68 Subjective',
				// % protected region % [Set displayName for BC68 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC68 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC68 Subjective here] end
				// % protected region % [Set isSensitive for BC68 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC68 Subjective here] end
				// % protected region % [Set readonly for BC68 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC68 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC68 Subjective here] off begin
					// % protected region % [Add other validators for BC68 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC68 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC68 Subjective here] end
			},
			{
				name: 'bc68Objective',
				// % protected region % [Set displayName for BC68 Objective here] off begin
				displayName: 'BC68 Objective',
				// % protected region % [Set displayName for BC68 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC68 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC68 Objective here] end
				// % protected region % [Set isSensitive for BC68 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC68 Objective here] end
				// % protected region % [Set readonly for BC68 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC68 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC68 Objective here] off begin
					// % protected region % [Add other validators for BC68 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC68 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC68 Objective here] end
			},
			{
				name: 'bc69Subjective',
				// % protected region % [Set displayName for BC69 Subjective here] off begin
				displayName: 'BC69 Subjective',
				// % protected region % [Set displayName for BC69 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC69 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC69 Subjective here] end
				// % protected region % [Set isSensitive for BC69 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC69 Subjective here] end
				// % protected region % [Set readonly for BC69 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC69 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC69 Subjective here] off begin
					// % protected region % [Add other validators for BC69 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC69 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC69 Subjective here] end
			},
			{
				name: 'bc69Objective',
				// % protected region % [Set displayName for BC69 Objective here] off begin
				displayName: 'BC69 Objective',
				// % protected region % [Set displayName for BC69 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC69 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC69 Objective here] end
				// % protected region % [Set isSensitive for BC69 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC69 Objective here] end
				// % protected region % [Set readonly for BC69 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC69 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC69 Objective here] off begin
					// % protected region % [Add other validators for BC69 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC69 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC69 Objective here] end
			},
			{
				name: 'bc70Subjective',
				// % protected region % [Set displayName for BC70 Subjective here] off begin
				displayName: 'BC70 Subjective',
				// % protected region % [Set displayName for BC70 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC70 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC70 Subjective here] end
				// % protected region % [Set isSensitive for BC70 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC70 Subjective here] end
				// % protected region % [Set readonly for BC70 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC70 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC70 Subjective here] off begin
					// % protected region % [Add other validators for BC70 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC70 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC70 Subjective here] end
			},
			{
				name: 'bc70Objective',
				// % protected region % [Set displayName for BC70 Objective here] off begin
				displayName: 'BC70 Objective',
				// % protected region % [Set displayName for BC70 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC70 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC70 Objective here] end
				// % protected region % [Set isSensitive for BC70 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC70 Objective here] end
				// % protected region % [Set readonly for BC70 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC70 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC70 Objective here] off begin
					// % protected region % [Add other validators for BC70 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC70 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC70 Objective here] end
			},
			{
				name: 'bc71Subjective',
				// % protected region % [Set displayName for BC71 Subjective here] off begin
				displayName: 'BC71 Subjective',
				// % protected region % [Set displayName for BC71 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC71 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC71 Subjective here] end
				// % protected region % [Set isSensitive for BC71 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC71 Subjective here] end
				// % protected region % [Set readonly for BC71 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC71 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC71 Subjective here] off begin
					// % protected region % [Add other validators for BC71 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC71 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC71 Subjective here] end
			},
			{
				name: 'bc71Objective',
				// % protected region % [Set displayName for BC71 Objective here] off begin
				displayName: 'BC71 Objective',
				// % protected region % [Set displayName for BC71 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC71 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC71 Objective here] end
				// % protected region % [Set isSensitive for BC71 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC71 Objective here] end
				// % protected region % [Set readonly for BC71 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC71 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC71 Objective here] off begin
					// % protected region % [Add other validators for BC71 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC71 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC71 Objective here] end
			},
			{
				name: 'bc72Subjective',
				// % protected region % [Set displayName for BC72 Subjective here] off begin
				displayName: 'BC72 Subjective',
				// % protected region % [Set displayName for BC72 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC72 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC72 Subjective here] end
				// % protected region % [Set isSensitive for BC72 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC72 Subjective here] end
				// % protected region % [Set readonly for BC72 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC72 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC72 Subjective here] off begin
					// % protected region % [Add other validators for BC72 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC72 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC72 Subjective here] end
			},
			{
				name: 'bc72Objective',
				// % protected region % [Set displayName for BC72 Objective here] off begin
				displayName: 'BC72 Objective',
				// % protected region % [Set displayName for BC72 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC72 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC72 Objective here] end
				// % protected region % [Set isSensitive for BC72 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC72 Objective here] end
				// % protected region % [Set readonly for BC72 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC72 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC72 Objective here] off begin
					// % protected region % [Add other validators for BC72 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC72 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC72 Objective here] end
			},
			{
				name: 'bc73Subjective',
				// % protected region % [Set displayName for BC73 Subjective here] off begin
				displayName: 'BC73 Subjective',
				// % protected region % [Set displayName for BC73 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC73 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC73 Subjective here] end
				// % protected region % [Set isSensitive for BC73 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC73 Subjective here] end
				// % protected region % [Set readonly for BC73 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC73 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC73 Subjective here] off begin
					// % protected region % [Add other validators for BC73 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC73 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC73 Subjective here] end
			},
			{
				name: 'bc73Objective',
				// % protected region % [Set displayName for BC73 Objective here] off begin
				displayName: 'BC73 Objective',
				// % protected region % [Set displayName for BC73 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC73 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC73 Objective here] end
				// % protected region % [Set isSensitive for BC73 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC73 Objective here] end
				// % protected region % [Set readonly for BC73 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC73 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC73 Objective here] off begin
					// % protected region % [Add other validators for BC73 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC73 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC73 Objective here] end
			},
			{
				name: 'bc74Subjective',
				// % protected region % [Set displayName for BC74 Subjective here] off begin
				displayName: 'BC74 Subjective',
				// % protected region % [Set displayName for BC74 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC74 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC74 Subjective here] end
				// % protected region % [Set isSensitive for BC74 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC74 Subjective here] end
				// % protected region % [Set readonly for BC74 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC74 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC74 Subjective here] off begin
					// % protected region % [Add other validators for BC74 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC74 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC74 Subjective here] end
			},
			{
				name: 'bc74Objective',
				// % protected region % [Set displayName for BC74 Objective here] off begin
				displayName: 'BC74 Objective',
				// % protected region % [Set displayName for BC74 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC74 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC74 Objective here] end
				// % protected region % [Set isSensitive for BC74 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC74 Objective here] end
				// % protected region % [Set readonly for BC74 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC74 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC74 Objective here] off begin
					// % protected region % [Add other validators for BC74 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC74 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC74 Objective here] end
			},
			{
				name: 'bc75Subjective',
				// % protected region % [Set displayName for BC75 Subjective here] off begin
				displayName: 'BC75 Subjective',
				// % protected region % [Set displayName for BC75 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC75 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC75 Subjective here] end
				// % protected region % [Set isSensitive for BC75 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC75 Subjective here] end
				// % protected region % [Set readonly for BC75 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC75 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC75 Subjective here] off begin
					// % protected region % [Add other validators for BC75 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC75 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC75 Subjective here] end
			},
			{
				name: 'bc75Objective',
				// % protected region % [Set displayName for BC75 Objective here] off begin
				displayName: 'BC75 Objective',
				// % protected region % [Set displayName for BC75 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC75 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC75 Objective here] end
				// % protected region % [Set isSensitive for BC75 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC75 Objective here] end
				// % protected region % [Set readonly for BC75 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC75 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC75 Objective here] off begin
					// % protected region % [Add other validators for BC75 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC75 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC75 Objective here] end
			},
			{
				name: 'bc76Subjective',
				// % protected region % [Set displayName for BC76 Subjective here] off begin
				displayName: 'BC76 Subjective',
				// % protected region % [Set displayName for BC76 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC76 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC76 Subjective here] end
				// % protected region % [Set isSensitive for BC76 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC76 Subjective here] end
				// % protected region % [Set readonly for BC76 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC76 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC76 Subjective here] off begin
					// % protected region % [Add other validators for BC76 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC76 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC76 Subjective here] end
			},
			{
				name: 'bc76Objective',
				// % protected region % [Set displayName for BC76 Objective here] off begin
				displayName: 'BC76 Objective',
				// % protected region % [Set displayName for BC76 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC76 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC76 Objective here] end
				// % protected region % [Set isSensitive for BC76 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC76 Objective here] end
				// % protected region % [Set readonly for BC76 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC76 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC76 Objective here] off begin
					// % protected region % [Add other validators for BC76 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC76 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC76 Objective here] end
			},
			{
				name: 'bc77Subjective',
				// % protected region % [Set displayName for BC77 Subjective here] off begin
				displayName: 'BC77 Subjective',
				// % protected region % [Set displayName for BC77 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC77 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC77 Subjective here] end
				// % protected region % [Set isSensitive for BC77 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC77 Subjective here] end
				// % protected region % [Set readonly for BC77 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC77 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC77 Subjective here] off begin
					// % protected region % [Add other validators for BC77 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC77 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC77 Subjective here] end
			},
			{
				name: 'bc77Objective',
				// % protected region % [Set displayName for BC77 Objective here] off begin
				displayName: 'BC77 Objective',
				// % protected region % [Set displayName for BC77 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC77 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC77 Objective here] end
				// % protected region % [Set isSensitive for BC77 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC77 Objective here] end
				// % protected region % [Set readonly for BC77 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC77 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC77 Objective here] off begin
					// % protected region % [Add other validators for BC77 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC77 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC77 Objective here] end
			},
			{
				name: 'bc78Subjective',
				// % protected region % [Set displayName for BC78 Subjective here] off begin
				displayName: 'BC78 Subjective',
				// % protected region % [Set displayName for BC78 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC78 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC78 Subjective here] end
				// % protected region % [Set isSensitive for BC78 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC78 Subjective here] end
				// % protected region % [Set readonly for BC78 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC78 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC78 Subjective here] off begin
					// % protected region % [Add other validators for BC78 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC78 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC78 Subjective here] end
			},
			{
				name: 'bc78Objective',
				// % protected region % [Set displayName for BC78 Objective here] off begin
				displayName: 'BC78 Objective',
				// % protected region % [Set displayName for BC78 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC78 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC78 Objective here] end
				// % protected region % [Set isSensitive for BC78 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC78 Objective here] end
				// % protected region % [Set readonly for BC78 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC78 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC78 Objective here] off begin
					// % protected region % [Add other validators for BC78 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC78 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC78 Objective here] end
			},
			{
				name: 'bc79Subjective',
				// % protected region % [Set displayName for BC79 Subjective here] off begin
				displayName: 'BC79 Subjective',
				// % protected region % [Set displayName for BC79 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC79 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC79 Subjective here] end
				// % protected region % [Set isSensitive for BC79 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC79 Subjective here] end
				// % protected region % [Set readonly for BC79 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC79 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC79 Subjective here] off begin
					// % protected region % [Add other validators for BC79 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC79 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC79 Subjective here] end
			},
			{
				name: 'bc79Objective',
				// % protected region % [Set displayName for BC79 Objective here] off begin
				displayName: 'BC79 Objective',
				// % protected region % [Set displayName for BC79 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC79 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC79 Objective here] end
				// % protected region % [Set isSensitive for BC79 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC79 Objective here] end
				// % protected region % [Set readonly for BC79 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC79 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC79 Objective here] off begin
					// % protected region % [Add other validators for BC79 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC79 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC79 Objective here] end
			},
			{
				name: 'bc80Subjective',
				// % protected region % [Set displayName for BC80 Subjective here] off begin
				displayName: 'BC80 Subjective',
				// % protected region % [Set displayName for BC80 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC80 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC80 Subjective here] end
				// % protected region % [Set isSensitive for BC80 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC80 Subjective here] end
				// % protected region % [Set readonly for BC80 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC80 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC80 Subjective here] off begin
					// % protected region % [Add other validators for BC80 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC80 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC80 Subjective here] end
			},
			{
				name: 'bc80Objective',
				// % protected region % [Set displayName for BC80 Objective here] off begin
				displayName: 'BC80 Objective',
				// % protected region % [Set displayName for BC80 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC80 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC80 Objective here] end
				// % protected region % [Set isSensitive for BC80 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC80 Objective here] end
				// % protected region % [Set readonly for BC80 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC80 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC80 Objective here] off begin
					// % protected region % [Add other validators for BC80 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC80 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC80 Objective here] end
			},
			{
				name: 'bc81Subjective',
				// % protected region % [Set displayName for BC81 Subjective here] off begin
				displayName: 'BC81 Subjective',
				// % protected region % [Set displayName for BC81 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC81 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC81 Subjective here] end
				// % protected region % [Set isSensitive for BC81 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC81 Subjective here] end
				// % protected region % [Set readonly for BC81 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC81 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC81 Subjective here] off begin
					// % protected region % [Add other validators for BC81 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC81 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC81 Subjective here] end
			},
			{
				name: 'bc81Objective',
				// % protected region % [Set displayName for BC81 Objective here] off begin
				displayName: 'BC81 Objective',
				// % protected region % [Set displayName for BC81 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC81 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC81 Objective here] end
				// % protected region % [Set isSensitive for BC81 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC81 Objective here] end
				// % protected region % [Set readonly for BC81 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC81 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC81 Objective here] off begin
					// % protected region % [Add other validators for BC81 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC81 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC81 Objective here] end
			},
			{
				name: 'bc82Subjective',
				// % protected region % [Set displayName for BC82 Subjective here] off begin
				displayName: 'BC82 Subjective',
				// % protected region % [Set displayName for BC82 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC82 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC82 Subjective here] end
				// % protected region % [Set isSensitive for BC82 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC82 Subjective here] end
				// % protected region % [Set readonly for BC82 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC82 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC82 Subjective here] off begin
					// % protected region % [Add other validators for BC82 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC82 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC82 Subjective here] end
			},
			{
				name: 'bc82Objective',
				// % protected region % [Set displayName for BC82 Objective here] off begin
				displayName: 'BC82 Objective',
				// % protected region % [Set displayName for BC82 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC82 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC82 Objective here] end
				// % protected region % [Set isSensitive for BC82 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC82 Objective here] end
				// % protected region % [Set readonly for BC82 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC82 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC82 Objective here] off begin
					// % protected region % [Add other validators for BC82 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC82 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC82 Objective here] end
			},
			{
				name: 'bc83Subjective',
				// % protected region % [Set displayName for BC83 Subjective here] off begin
				displayName: 'BC83 Subjective',
				// % protected region % [Set displayName for BC83 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC83 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC83 Subjective here] end
				// % protected region % [Set isSensitive for BC83 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC83 Subjective here] end
				// % protected region % [Set readonly for BC83 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC83 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC83 Subjective here] off begin
					// % protected region % [Add other validators for BC83 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC83 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC83 Subjective here] end
			},
			{
				name: 'bc83Objective',
				// % protected region % [Set displayName for BC83 Objective here] off begin
				displayName: 'BC83 Objective',
				// % protected region % [Set displayName for BC83 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC83 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC83 Objective here] end
				// % protected region % [Set isSensitive for BC83 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC83 Objective here] end
				// % protected region % [Set readonly for BC83 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC83 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC83 Objective here] off begin
					// % protected region % [Add other validators for BC83 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC83 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC83 Objective here] end
			},
			{
				name: 'bc84Subjective',
				// % protected region % [Set displayName for BC84 Subjective here] off begin
				displayName: 'BC84 Subjective',
				// % protected region % [Set displayName for BC84 Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC84 Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC84 Subjective here] end
				// % protected region % [Set isSensitive for BC84 Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC84 Subjective here] end
				// % protected region % [Set readonly for BC84 Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC84 Subjective here] end
				validators: [
					// % protected region % [Add other validators for BC84 Subjective here] off begin
					// % protected region % [Add other validators for BC84 Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC84 Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for BC84 Subjective here] end
			},
			{
				name: 'bc84Objective',
				// % protected region % [Set displayName for BC84 Objective here] off begin
				displayName: 'BC84 Objective',
				// % protected region % [Set displayName for BC84 Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BC84 Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BC84 Objective here] end
				// % protected region % [Set isSensitive for BC84 Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BC84 Objective here] end
				// % protected region % [Set readonly for BC84 Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BC84 Objective here] end
				validators: [
					// % protected region % [Add other validators for BC84 Objective here] off begin
					// % protected region % [Add other validators for BC84 Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for BC84 Objective here] off begin
				// % protected region % [Add any additional model attribute properties for BC84 Objective here] end
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
				case 'bc77Objective':
					break;
				case 'bc78Subjective':
					break;
				case 'bc78Objective':
					break;
				case 'bc79Subjective':
					break;
				case 'bc79Objective':
					break;
				case 'bc80Subjective':
					break;
				case 'bc80Objective':
					break;
				case 'bc81Subjective':
					break;
				case 'bc81Objective':
					break;
				case 'bc82Subjective':
					break;
				case 'bc82Objective':
					break;
				case 'bc83Subjective':
					break;
				case 'bc83Objective':
					break;
				case 'bc84Subjective':
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
	static deepParse(data: string | { [K in keyof BodyChartExaminationModel]?: BodyChartExaminationModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BodyChartExaminationModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.medicalExaminationRecord) {
			currentModel.medicalExaminationRecordId = json.medicalExaminationRecord.id;
			returned = _.union(returned, MedicalExaminationRecordModel.deepParse(json.medicalExaminationRecord));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bodyChartExaminationModel = new BodyChartExaminationModel(data);`
	 *
	 * @param data The input data to be initialised as the BodyChartExaminationModel,
	 *    it is expected as a JSON string or as a nullable BodyChartExaminationModel.
	 */
	constructor(data?: string | Partial<BodyChartExaminationModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BodyChartExaminationModel>
				: data;

			this.bc01Subjective = json.bc01Subjective;
			this.bc01Objective = json.bc01Objective;
			this.bc02Subjective = json.bc02Subjective;
			this.bc02Objective = json.bc02Objective;
			this.bc03Subjective = json.bc03Subjective;
			this.bc03Objective = json.bc03Objective;
			this.bc04Subjective = json.bc04Subjective;
			this.bc04Objective = json.bc04Objective;
			this.bc05Subjective = json.bc05Subjective;
			this.bc05Objective = json.bc05Objective;
			this.bc06Subjective = json.bc06Subjective;
			this.bc06Objective = json.bc06Objective;
			this.bc07Subjective = json.bc07Subjective;
			this.bc07Objective = json.bc07Objective;
			this.bc08Subjective = json.bc08Subjective;
			this.bc08Objective = json.bc08Objective;
			this.bc09Subjective = json.bc09Subjective;
			this.bc09Objective = json.bc09Objective;
			this.bc10Subjective = json.bc10Subjective;
			this.bc10Objective = json.bc10Objective;
			this.bc11Subjective = json.bc11Subjective;
			this.bc11Objective = json.bc11Objective;
			this.bc12Subjective = json.bc12Subjective;
			this.bc12Objective = json.bc12Objective;
			this.bc13Subjective = json.bc13Subjective;
			this.bc13Objective = json.bc13Objective;
			this.bc14Subjective = json.bc14Subjective;
			this.bc14Objective = json.bc14Objective;
			this.bc15Subjective = json.bc15Subjective;
			this.bc15Objective = json.bc15Objective;
			this.bc16Subjective = json.bc16Subjective;
			this.bc16Objective = json.bc16Objective;
			this.bc17Subjective = json.bc17Subjective;
			this.bc17Objective = json.bc17Objective;
			this.bc18Subjective = json.bc18Subjective;
			this.bc18Objective = json.bc18Objective;
			this.bc19Subjective = json.bc19Subjective;
			this.bc19Objective = json.bc19Objective;
			this.bc20Subjective = json.bc20Subjective;
			this.bc20Objective = json.bc20Objective;
			this.bc21Subjective = json.bc21Subjective;
			this.bc21Objective = json.bc21Objective;
			this.bc22Subjective = json.bc22Subjective;
			this.bc22Objective = json.bc22Objective;
			this.bc23Subjective = json.bc23Subjective;
			this.bc23Objective = json.bc23Objective;
			this.bc24Subjective = json.bc24Subjective;
			this.bc24Objective = json.bc24Objective;
			this.bc25Subjective = json.bc25Subjective;
			this.bc25Objective = json.bc25Objective;
			this.bc26Subjective = json.bc26Subjective;
			this.bc26Objective = json.bc26Objective;
			this.bc27Subjective = json.bc27Subjective;
			this.bc27Objective = json.bc27Objective;
			this.bc28Subjective = json.bc28Subjective;
			this.bc28Objective = json.bc28Objective;
			this.bc29Subjective = json.bc29Subjective;
			this.bc29Objective = json.bc29Objective;
			this.bc30Subjective = json.bc30Subjective;
			this.bc30Objective = json.bc30Objective;
			this.bc31Subjective = json.bc31Subjective;
			this.bc31Objective = json.bc31Objective;
			this.bc32Subjective = json.bc32Subjective;
			this.bc32Objective = json.bc32Objective;
			this.bc33Subjective = json.bc33Subjective;
			this.bc33Objective = json.bc33Objective;
			this.bc34Subjective = json.bc34Subjective;
			this.bc34Objective = json.bc34Objective;
			this.bc35Subjective = json.bc35Subjective;
			this.bc35Objective = json.bc35Objective;
			this.bc36Subjective = json.bc36Subjective;
			this.bc36Objective = json.bc36Objective;
			this.bc37Subjective = json.bc37Subjective;
			this.bc37Objective = json.bc37Objective;
			this.bc38Subjective = json.bc38Subjective;
			this.bc38Objective = json.bc38Objective;
			this.bc39Subjective = json.bc39Subjective;
			this.bc39Objective = json.bc39Objective;
			this.bc40Subjective = json.bc40Subjective;
			this.bc40Objective = json.bc40Objective;
			this.bc41Subjective = json.bc41Subjective;
			this.bc41Objective = json.bc41Objective;
			this.bc42Subjective = json.bc42Subjective;
			this.bc42Objective = json.bc42Objective;
			this.bc43Subjective = json.bc43Subjective;
			this.bc43Objective = json.bc43Objective;
			this.bc44Subjective = json.bc44Subjective;
			this.bc44Objective = json.bc44Objective;
			this.bc45Subjective = json.bc45Subjective;
			this.bc45Objective = json.bc45Objective;
			this.bc46Subjective = json.bc46Subjective;
			this.bc46Objective = json.bc46Objective;
			this.bc47Subjective = json.bc47Subjective;
			this.bc47Objective = json.bc47Objective;
			this.bc48Subjective = json.bc48Subjective;
			this.bc48Objective = json.bc48Objective;
			this.bc49Subjective = json.bc49Subjective;
			this.bc49Objective = json.bc49Objective;
			this.bc50Subjective = json.bc50Subjective;
			this.bc50Objective = json.bc50Objective;
			this.bc51Subjective = json.bc51Subjective;
			this.bc51Objective = json.bc51Objective;
			this.bc52Subjective = json.bc52Subjective;
			this.bc52Objective = json.bc52Objective;
			this.bc53Subjective = json.bc53Subjective;
			this.bc53Objective = json.bc53Objective;
			this.bc54Subjective = json.bc54Subjective;
			this.bc54Objective = json.bc54Objective;
			this.bc55Subjective = json.bc55Subjective;
			this.bc55Objective = json.bc55Objective;
			this.bc56Subjective = json.bc56Subjective;
			this.bc56Objective = json.bc56Objective;
			this.bc57Subjective = json.bc57Subjective;
			this.bc57Objective = json.bc57Objective;
			this.bc58Subjective = json.bc58Subjective;
			this.bc58Objective = json.bc58Objective;
			this.bc59Subjective = json.bc59Subjective;
			this.bc59Objective = json.bc59Objective;
			this.bc60Subjective = json.bc60Subjective;
			this.bc60Objective = json.bc60Objective;
			this.bc61Subjective = json.bc61Subjective;
			this.bc61Objective = json.bc61Objective;
			this.bc62Subjective = json.bc62Subjective;
			this.bc62Objective = json.bc62Objective;
			this.bc63Subjective = json.bc63Subjective;
			this.bc63Objective = json.bc63Objective;
			this.bc64Subjective = json.bc64Subjective;
			this.bc64Objective = json.bc64Objective;
			this.bc65Subjective = json.bc65Subjective;
			this.bc65Objective = json.bc65Objective;
			this.bc66Subjective = json.bc66Subjective;
			this.bc66Objective = json.bc66Objective;
			this.bc67Subjective = json.bc67Subjective;
			this.bc67Objective = json.bc67Objective;
			this.bc68Subjective = json.bc68Subjective;
			this.bc68Objective = json.bc68Objective;
			this.bc69Subjective = json.bc69Subjective;
			this.bc69Objective = json.bc69Objective;
			this.bc70Subjective = json.bc70Subjective;
			this.bc70Objective = json.bc70Objective;
			this.bc71Subjective = json.bc71Subjective;
			this.bc71Objective = json.bc71Objective;
			this.bc72Subjective = json.bc72Subjective;
			this.bc72Objective = json.bc72Objective;
			this.bc73Subjective = json.bc73Subjective;
			this.bc73Objective = json.bc73Objective;
			this.bc74Subjective = json.bc74Subjective;
			this.bc74Objective = json.bc74Objective;
			this.bc75Subjective = json.bc75Subjective;
			this.bc75Objective = json.bc75Objective;
			this.bc76Subjective = json.bc76Subjective;
			this.bc76Objective = json.bc76Objective;
			this.bc77Subjective = json.bc77Subjective;
			this.bc77Objective = json.bc77Objective;
			this.bc78Subjective = json.bc78Subjective;
			this.bc78Objective = json.bc78Objective;
			this.bc79Subjective = json.bc79Subjective;
			this.bc79Objective = json.bc79Objective;
			this.bc80Subjective = json.bc80Subjective;
			this.bc80Objective = json.bc80Objective;
			this.bc81Subjective = json.bc81Subjective;
			this.bc81Objective = json.bc81Objective;
			this.bc82Subjective = json.bc82Subjective;
			this.bc82Objective = json.bc82Objective;
			this.bc83Subjective = json.bc83Subjective;
			this.bc83Objective = json.bc83Objective;
			this.bc84Subjective = json.bc84Subjective;
			this.bc84Objective = json.bc84Objective;
			this.medicalExaminationRecordId = json.medicalExaminationRecordId;
			this.medicalExaminationRecord = json.medicalExaminationRecord;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			bc01Subjective: this.bc01Subjective,
			bc01Objective: this.bc01Objective,
			bc02Subjective: this.bc02Subjective,
			bc02Objective: this.bc02Objective,
			bc03Subjective: this.bc03Subjective,
			bc03Objective: this.bc03Objective,
			bc04Subjective: this.bc04Subjective,
			bc04Objective: this.bc04Objective,
			bc05Subjective: this.bc05Subjective,
			bc05Objective: this.bc05Objective,
			bc06Subjective: this.bc06Subjective,
			bc06Objective: this.bc06Objective,
			bc07Subjective: this.bc07Subjective,
			bc07Objective: this.bc07Objective,
			bc08Subjective: this.bc08Subjective,
			bc08Objective: this.bc08Objective,
			bc09Subjective: this.bc09Subjective,
			bc09Objective: this.bc09Objective,
			bc10Subjective: this.bc10Subjective,
			bc10Objective: this.bc10Objective,
			bc11Subjective: this.bc11Subjective,
			bc11Objective: this.bc11Objective,
			bc12Subjective: this.bc12Subjective,
			bc12Objective: this.bc12Objective,
			bc13Subjective: this.bc13Subjective,
			bc13Objective: this.bc13Objective,
			bc14Subjective: this.bc14Subjective,
			bc14Objective: this.bc14Objective,
			bc15Subjective: this.bc15Subjective,
			bc15Objective: this.bc15Objective,
			bc16Subjective: this.bc16Subjective,
			bc16Objective: this.bc16Objective,
			bc17Subjective: this.bc17Subjective,
			bc17Objective: this.bc17Objective,
			bc18Subjective: this.bc18Subjective,
			bc18Objective: this.bc18Objective,
			bc19Subjective: this.bc19Subjective,
			bc19Objective: this.bc19Objective,
			bc20Subjective: this.bc20Subjective,
			bc20Objective: this.bc20Objective,
			bc21Subjective: this.bc21Subjective,
			bc21Objective: this.bc21Objective,
			bc22Subjective: this.bc22Subjective,
			bc22Objective: this.bc22Objective,
			bc23Subjective: this.bc23Subjective,
			bc23Objective: this.bc23Objective,
			bc24Subjective: this.bc24Subjective,
			bc24Objective: this.bc24Objective,
			bc25Subjective: this.bc25Subjective,
			bc25Objective: this.bc25Objective,
			bc26Subjective: this.bc26Subjective,
			bc26Objective: this.bc26Objective,
			bc27Subjective: this.bc27Subjective,
			bc27Objective: this.bc27Objective,
			bc28Subjective: this.bc28Subjective,
			bc28Objective: this.bc28Objective,
			bc29Subjective: this.bc29Subjective,
			bc29Objective: this.bc29Objective,
			bc30Subjective: this.bc30Subjective,
			bc30Objective: this.bc30Objective,
			bc31Subjective: this.bc31Subjective,
			bc31Objective: this.bc31Objective,
			bc32Subjective: this.bc32Subjective,
			bc32Objective: this.bc32Objective,
			bc33Subjective: this.bc33Subjective,
			bc33Objective: this.bc33Objective,
			bc34Subjective: this.bc34Subjective,
			bc34Objective: this.bc34Objective,
			bc35Subjective: this.bc35Subjective,
			bc35Objective: this.bc35Objective,
			bc36Subjective: this.bc36Subjective,
			bc36Objective: this.bc36Objective,
			bc37Subjective: this.bc37Subjective,
			bc37Objective: this.bc37Objective,
			bc38Subjective: this.bc38Subjective,
			bc38Objective: this.bc38Objective,
			bc39Subjective: this.bc39Subjective,
			bc39Objective: this.bc39Objective,
			bc40Subjective: this.bc40Subjective,
			bc40Objective: this.bc40Objective,
			bc41Subjective: this.bc41Subjective,
			bc41Objective: this.bc41Objective,
			bc42Subjective: this.bc42Subjective,
			bc42Objective: this.bc42Objective,
			bc43Subjective: this.bc43Subjective,
			bc43Objective: this.bc43Objective,
			bc44Subjective: this.bc44Subjective,
			bc44Objective: this.bc44Objective,
			bc45Subjective: this.bc45Subjective,
			bc45Objective: this.bc45Objective,
			bc46Subjective: this.bc46Subjective,
			bc46Objective: this.bc46Objective,
			bc47Subjective: this.bc47Subjective,
			bc47Objective: this.bc47Objective,
			bc48Subjective: this.bc48Subjective,
			bc48Objective: this.bc48Objective,
			bc49Subjective: this.bc49Subjective,
			bc49Objective: this.bc49Objective,
			bc50Subjective: this.bc50Subjective,
			bc50Objective: this.bc50Objective,
			bc51Subjective: this.bc51Subjective,
			bc51Objective: this.bc51Objective,
			bc52Subjective: this.bc52Subjective,
			bc52Objective: this.bc52Objective,
			bc53Subjective: this.bc53Subjective,
			bc53Objective: this.bc53Objective,
			bc54Subjective: this.bc54Subjective,
			bc54Objective: this.bc54Objective,
			bc55Subjective: this.bc55Subjective,
			bc55Objective: this.bc55Objective,
			bc56Subjective: this.bc56Subjective,
			bc56Objective: this.bc56Objective,
			bc57Subjective: this.bc57Subjective,
			bc57Objective: this.bc57Objective,
			bc58Subjective: this.bc58Subjective,
			bc58Objective: this.bc58Objective,
			bc59Subjective: this.bc59Subjective,
			bc59Objective: this.bc59Objective,
			bc60Subjective: this.bc60Subjective,
			bc60Objective: this.bc60Objective,
			bc61Subjective: this.bc61Subjective,
			bc61Objective: this.bc61Objective,
			bc62Subjective: this.bc62Subjective,
			bc62Objective: this.bc62Objective,
			bc63Subjective: this.bc63Subjective,
			bc63Objective: this.bc63Objective,
			bc64Subjective: this.bc64Subjective,
			bc64Objective: this.bc64Objective,
			bc65Subjective: this.bc65Subjective,
			bc65Objective: this.bc65Objective,
			bc66Subjective: this.bc66Subjective,
			bc66Objective: this.bc66Objective,
			bc67Subjective: this.bc67Subjective,
			bc67Objective: this.bc67Objective,
			bc68Subjective: this.bc68Subjective,
			bc68Objective: this.bc68Objective,
			bc69Subjective: this.bc69Subjective,
			bc69Objective: this.bc69Objective,
			bc70Subjective: this.bc70Subjective,
			bc70Objective: this.bc70Objective,
			bc71Subjective: this.bc71Subjective,
			bc71Objective: this.bc71Objective,
			bc72Subjective: this.bc72Subjective,
			bc72Objective: this.bc72Objective,
			bc73Subjective: this.bc73Subjective,
			bc73Objective: this.bc73Objective,
			bc74Subjective: this.bc74Subjective,
			bc74Objective: this.bc74Objective,
			bc75Subjective: this.bc75Subjective,
			bc75Objective: this.bc75Objective,
			bc76Subjective: this.bc76Subjective,
			bc76Objective: this.bc76Objective,
			bc77Subjective: this.bc77Subjective,
			bc77Objective: this.bc77Objective,
			bc78Subjective: this.bc78Subjective,
			bc78Objective: this.bc78Objective,
			bc79Subjective: this.bc79Subjective,
			bc79Objective: this.bc79Objective,
			bc80Subjective: this.bc80Subjective,
			bc80Objective: this.bc80Objective,
			bc81Subjective: this.bc81Subjective,
			bc81Objective: this.bc81Objective,
			bc82Subjective: this.bc82Subjective,
			bc82Objective: this.bc82Objective,
			bc83Subjective: this.bc83Subjective,
			bc83Objective: this.bc83Objective,
			bc84Subjective: this.bc84Subjective,
			bc84Objective: this.bc84Objective,
			medicalExaminationRecordId: this.medicalExaminationRecordId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BodyChartExaminationModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BodyChartExaminationModel {
		let newModelJson = this.toJSON();

		if (updates.bc01Subjective) {
			newModelJson.bc01Subjective = updates.bc01Subjective;
		}

		if (updates.bc01Objective) {
			newModelJson.bc01Objective = updates.bc01Objective;
		}

		if (updates.bc02Subjective) {
			newModelJson.bc02Subjective = updates.bc02Subjective;
		}

		if (updates.bc02Objective) {
			newModelJson.bc02Objective = updates.bc02Objective;
		}

		if (updates.bc03Subjective) {
			newModelJson.bc03Subjective = updates.bc03Subjective;
		}

		if (updates.bc03Objective) {
			newModelJson.bc03Objective = updates.bc03Objective;
		}

		if (updates.bc04Subjective) {
			newModelJson.bc04Subjective = updates.bc04Subjective;
		}

		if (updates.bc04Objective) {
			newModelJson.bc04Objective = updates.bc04Objective;
		}

		if (updates.bc05Subjective) {
			newModelJson.bc05Subjective = updates.bc05Subjective;
		}

		if (updates.bc05Objective) {
			newModelJson.bc05Objective = updates.bc05Objective;
		}

		if (updates.bc06Subjective) {
			newModelJson.bc06Subjective = updates.bc06Subjective;
		}

		if (updates.bc06Objective) {
			newModelJson.bc06Objective = updates.bc06Objective;
		}

		if (updates.bc07Subjective) {
			newModelJson.bc07Subjective = updates.bc07Subjective;
		}

		if (updates.bc07Objective) {
			newModelJson.bc07Objective = updates.bc07Objective;
		}

		if (updates.bc08Subjective) {
			newModelJson.bc08Subjective = updates.bc08Subjective;
		}

		if (updates.bc08Objective) {
			newModelJson.bc08Objective = updates.bc08Objective;
		}

		if (updates.bc09Subjective) {
			newModelJson.bc09Subjective = updates.bc09Subjective;
		}

		if (updates.bc09Objective) {
			newModelJson.bc09Objective = updates.bc09Objective;
		}

		if (updates.bc10Subjective) {
			newModelJson.bc10Subjective = updates.bc10Subjective;
		}

		if (updates.bc10Objective) {
			newModelJson.bc10Objective = updates.bc10Objective;
		}

		if (updates.bc11Subjective) {
			newModelJson.bc11Subjective = updates.bc11Subjective;
		}

		if (updates.bc11Objective) {
			newModelJson.bc11Objective = updates.bc11Objective;
		}

		if (updates.bc12Subjective) {
			newModelJson.bc12Subjective = updates.bc12Subjective;
		}

		if (updates.bc12Objective) {
			newModelJson.bc12Objective = updates.bc12Objective;
		}

		if (updates.bc13Subjective) {
			newModelJson.bc13Subjective = updates.bc13Subjective;
		}

		if (updates.bc13Objective) {
			newModelJson.bc13Objective = updates.bc13Objective;
		}

		if (updates.bc14Subjective) {
			newModelJson.bc14Subjective = updates.bc14Subjective;
		}

		if (updates.bc14Objective) {
			newModelJson.bc14Objective = updates.bc14Objective;
		}

		if (updates.bc15Subjective) {
			newModelJson.bc15Subjective = updates.bc15Subjective;
		}

		if (updates.bc15Objective) {
			newModelJson.bc15Objective = updates.bc15Objective;
		}

		if (updates.bc16Subjective) {
			newModelJson.bc16Subjective = updates.bc16Subjective;
		}

		if (updates.bc16Objective) {
			newModelJson.bc16Objective = updates.bc16Objective;
		}

		if (updates.bc17Subjective) {
			newModelJson.bc17Subjective = updates.bc17Subjective;
		}

		if (updates.bc17Objective) {
			newModelJson.bc17Objective = updates.bc17Objective;
		}

		if (updates.bc18Subjective) {
			newModelJson.bc18Subjective = updates.bc18Subjective;
		}

		if (updates.bc18Objective) {
			newModelJson.bc18Objective = updates.bc18Objective;
		}

		if (updates.bc19Subjective) {
			newModelJson.bc19Subjective = updates.bc19Subjective;
		}

		if (updates.bc19Objective) {
			newModelJson.bc19Objective = updates.bc19Objective;
		}

		if (updates.bc20Subjective) {
			newModelJson.bc20Subjective = updates.bc20Subjective;
		}

		if (updates.bc20Objective) {
			newModelJson.bc20Objective = updates.bc20Objective;
		}

		if (updates.bc21Subjective) {
			newModelJson.bc21Subjective = updates.bc21Subjective;
		}

		if (updates.bc21Objective) {
			newModelJson.bc21Objective = updates.bc21Objective;
		}

		if (updates.bc22Subjective) {
			newModelJson.bc22Subjective = updates.bc22Subjective;
		}

		if (updates.bc22Objective) {
			newModelJson.bc22Objective = updates.bc22Objective;
		}

		if (updates.bc23Subjective) {
			newModelJson.bc23Subjective = updates.bc23Subjective;
		}

		if (updates.bc23Objective) {
			newModelJson.bc23Objective = updates.bc23Objective;
		}

		if (updates.bc24Subjective) {
			newModelJson.bc24Subjective = updates.bc24Subjective;
		}

		if (updates.bc24Objective) {
			newModelJson.bc24Objective = updates.bc24Objective;
		}

		if (updates.bc25Subjective) {
			newModelJson.bc25Subjective = updates.bc25Subjective;
		}

		if (updates.bc25Objective) {
			newModelJson.bc25Objective = updates.bc25Objective;
		}

		if (updates.bc26Subjective) {
			newModelJson.bc26Subjective = updates.bc26Subjective;
		}

		if (updates.bc26Objective) {
			newModelJson.bc26Objective = updates.bc26Objective;
		}

		if (updates.bc27Subjective) {
			newModelJson.bc27Subjective = updates.bc27Subjective;
		}

		if (updates.bc27Objective) {
			newModelJson.bc27Objective = updates.bc27Objective;
		}

		if (updates.bc28Subjective) {
			newModelJson.bc28Subjective = updates.bc28Subjective;
		}

		if (updates.bc28Objective) {
			newModelJson.bc28Objective = updates.bc28Objective;
		}

		if (updates.bc29Subjective) {
			newModelJson.bc29Subjective = updates.bc29Subjective;
		}

		if (updates.bc29Objective) {
			newModelJson.bc29Objective = updates.bc29Objective;
		}

		if (updates.bc30Subjective) {
			newModelJson.bc30Subjective = updates.bc30Subjective;
		}

		if (updates.bc30Objective) {
			newModelJson.bc30Objective = updates.bc30Objective;
		}

		if (updates.bc31Subjective) {
			newModelJson.bc31Subjective = updates.bc31Subjective;
		}

		if (updates.bc31Objective) {
			newModelJson.bc31Objective = updates.bc31Objective;
		}

		if (updates.bc32Subjective) {
			newModelJson.bc32Subjective = updates.bc32Subjective;
		}

		if (updates.bc32Objective) {
			newModelJson.bc32Objective = updates.bc32Objective;
		}

		if (updates.bc33Subjective) {
			newModelJson.bc33Subjective = updates.bc33Subjective;
		}

		if (updates.bc33Objective) {
			newModelJson.bc33Objective = updates.bc33Objective;
		}

		if (updates.bc34Subjective) {
			newModelJson.bc34Subjective = updates.bc34Subjective;
		}

		if (updates.bc34Objective) {
			newModelJson.bc34Objective = updates.bc34Objective;
		}

		if (updates.bc35Subjective) {
			newModelJson.bc35Subjective = updates.bc35Subjective;
		}

		if (updates.bc35Objective) {
			newModelJson.bc35Objective = updates.bc35Objective;
		}

		if (updates.bc36Subjective) {
			newModelJson.bc36Subjective = updates.bc36Subjective;
		}

		if (updates.bc36Objective) {
			newModelJson.bc36Objective = updates.bc36Objective;
		}

		if (updates.bc37Subjective) {
			newModelJson.bc37Subjective = updates.bc37Subjective;
		}

		if (updates.bc37Objective) {
			newModelJson.bc37Objective = updates.bc37Objective;
		}

		if (updates.bc38Subjective) {
			newModelJson.bc38Subjective = updates.bc38Subjective;
		}

		if (updates.bc38Objective) {
			newModelJson.bc38Objective = updates.bc38Objective;
		}

		if (updates.bc39Subjective) {
			newModelJson.bc39Subjective = updates.bc39Subjective;
		}

		if (updates.bc39Objective) {
			newModelJson.bc39Objective = updates.bc39Objective;
		}

		if (updates.bc40Subjective) {
			newModelJson.bc40Subjective = updates.bc40Subjective;
		}

		if (updates.bc40Objective) {
			newModelJson.bc40Objective = updates.bc40Objective;
		}

		if (updates.bc41Subjective) {
			newModelJson.bc41Subjective = updates.bc41Subjective;
		}

		if (updates.bc41Objective) {
			newModelJson.bc41Objective = updates.bc41Objective;
		}

		if (updates.bc42Subjective) {
			newModelJson.bc42Subjective = updates.bc42Subjective;
		}

		if (updates.bc42Objective) {
			newModelJson.bc42Objective = updates.bc42Objective;
		}

		if (updates.bc43Subjective) {
			newModelJson.bc43Subjective = updates.bc43Subjective;
		}

		if (updates.bc43Objective) {
			newModelJson.bc43Objective = updates.bc43Objective;
		}

		if (updates.bc44Subjective) {
			newModelJson.bc44Subjective = updates.bc44Subjective;
		}

		if (updates.bc44Objective) {
			newModelJson.bc44Objective = updates.bc44Objective;
		}

		if (updates.bc45Subjective) {
			newModelJson.bc45Subjective = updates.bc45Subjective;
		}

		if (updates.bc45Objective) {
			newModelJson.bc45Objective = updates.bc45Objective;
		}

		if (updates.bc46Subjective) {
			newModelJson.bc46Subjective = updates.bc46Subjective;
		}

		if (updates.bc46Objective) {
			newModelJson.bc46Objective = updates.bc46Objective;
		}

		if (updates.bc47Subjective) {
			newModelJson.bc47Subjective = updates.bc47Subjective;
		}

		if (updates.bc47Objective) {
			newModelJson.bc47Objective = updates.bc47Objective;
		}

		if (updates.bc48Subjective) {
			newModelJson.bc48Subjective = updates.bc48Subjective;
		}

		if (updates.bc48Objective) {
			newModelJson.bc48Objective = updates.bc48Objective;
		}

		if (updates.bc49Subjective) {
			newModelJson.bc49Subjective = updates.bc49Subjective;
		}

		if (updates.bc49Objective) {
			newModelJson.bc49Objective = updates.bc49Objective;
		}

		if (updates.bc50Subjective) {
			newModelJson.bc50Subjective = updates.bc50Subjective;
		}

		if (updates.bc50Objective) {
			newModelJson.bc50Objective = updates.bc50Objective;
		}

		if (updates.bc51Subjective) {
			newModelJson.bc51Subjective = updates.bc51Subjective;
		}

		if (updates.bc51Objective) {
			newModelJson.bc51Objective = updates.bc51Objective;
		}

		if (updates.bc52Subjective) {
			newModelJson.bc52Subjective = updates.bc52Subjective;
		}

		if (updates.bc52Objective) {
			newModelJson.bc52Objective = updates.bc52Objective;
		}

		if (updates.bc53Subjective) {
			newModelJson.bc53Subjective = updates.bc53Subjective;
		}

		if (updates.bc53Objective) {
			newModelJson.bc53Objective = updates.bc53Objective;
		}

		if (updates.bc54Subjective) {
			newModelJson.bc54Subjective = updates.bc54Subjective;
		}

		if (updates.bc54Objective) {
			newModelJson.bc54Objective = updates.bc54Objective;
		}

		if (updates.bc55Subjective) {
			newModelJson.bc55Subjective = updates.bc55Subjective;
		}

		if (updates.bc55Objective) {
			newModelJson.bc55Objective = updates.bc55Objective;
		}

		if (updates.bc56Subjective) {
			newModelJson.bc56Subjective = updates.bc56Subjective;
		}

		if (updates.bc56Objective) {
			newModelJson.bc56Objective = updates.bc56Objective;
		}

		if (updates.bc57Subjective) {
			newModelJson.bc57Subjective = updates.bc57Subjective;
		}

		if (updates.bc57Objective) {
			newModelJson.bc57Objective = updates.bc57Objective;
		}

		if (updates.bc58Subjective) {
			newModelJson.bc58Subjective = updates.bc58Subjective;
		}

		if (updates.bc58Objective) {
			newModelJson.bc58Objective = updates.bc58Objective;
		}

		if (updates.bc59Subjective) {
			newModelJson.bc59Subjective = updates.bc59Subjective;
		}

		if (updates.bc59Objective) {
			newModelJson.bc59Objective = updates.bc59Objective;
		}

		if (updates.bc60Subjective) {
			newModelJson.bc60Subjective = updates.bc60Subjective;
		}

		if (updates.bc60Objective) {
			newModelJson.bc60Objective = updates.bc60Objective;
		}

		if (updates.bc61Subjective) {
			newModelJson.bc61Subjective = updates.bc61Subjective;
		}

		if (updates.bc61Objective) {
			newModelJson.bc61Objective = updates.bc61Objective;
		}

		if (updates.bc62Subjective) {
			newModelJson.bc62Subjective = updates.bc62Subjective;
		}

		if (updates.bc62Objective) {
			newModelJson.bc62Objective = updates.bc62Objective;
		}

		if (updates.bc63Subjective) {
			newModelJson.bc63Subjective = updates.bc63Subjective;
		}

		if (updates.bc63Objective) {
			newModelJson.bc63Objective = updates.bc63Objective;
		}

		if (updates.bc64Subjective) {
			newModelJson.bc64Subjective = updates.bc64Subjective;
		}

		if (updates.bc64Objective) {
			newModelJson.bc64Objective = updates.bc64Objective;
		}

		if (updates.bc65Subjective) {
			newModelJson.bc65Subjective = updates.bc65Subjective;
		}

		if (updates.bc65Objective) {
			newModelJson.bc65Objective = updates.bc65Objective;
		}

		if (updates.bc66Subjective) {
			newModelJson.bc66Subjective = updates.bc66Subjective;
		}

		if (updates.bc66Objective) {
			newModelJson.bc66Objective = updates.bc66Objective;
		}

		if (updates.bc67Subjective) {
			newModelJson.bc67Subjective = updates.bc67Subjective;
		}

		if (updates.bc67Objective) {
			newModelJson.bc67Objective = updates.bc67Objective;
		}

		if (updates.bc68Subjective) {
			newModelJson.bc68Subjective = updates.bc68Subjective;
		}

		if (updates.bc68Objective) {
			newModelJson.bc68Objective = updates.bc68Objective;
		}

		if (updates.bc69Subjective) {
			newModelJson.bc69Subjective = updates.bc69Subjective;
		}

		if (updates.bc69Objective) {
			newModelJson.bc69Objective = updates.bc69Objective;
		}

		if (updates.bc70Subjective) {
			newModelJson.bc70Subjective = updates.bc70Subjective;
		}

		if (updates.bc70Objective) {
			newModelJson.bc70Objective = updates.bc70Objective;
		}

		if (updates.bc71Subjective) {
			newModelJson.bc71Subjective = updates.bc71Subjective;
		}

		if (updates.bc71Objective) {
			newModelJson.bc71Objective = updates.bc71Objective;
		}

		if (updates.bc72Subjective) {
			newModelJson.bc72Subjective = updates.bc72Subjective;
		}

		if (updates.bc72Objective) {
			newModelJson.bc72Objective = updates.bc72Objective;
		}

		if (updates.bc73Subjective) {
			newModelJson.bc73Subjective = updates.bc73Subjective;
		}

		if (updates.bc73Objective) {
			newModelJson.bc73Objective = updates.bc73Objective;
		}

		if (updates.bc74Subjective) {
			newModelJson.bc74Subjective = updates.bc74Subjective;
		}

		if (updates.bc74Objective) {
			newModelJson.bc74Objective = updates.bc74Objective;
		}

		if (updates.bc75Subjective) {
			newModelJson.bc75Subjective = updates.bc75Subjective;
		}

		if (updates.bc75Objective) {
			newModelJson.bc75Objective = updates.bc75Objective;
		}

		if (updates.bc76Subjective) {
			newModelJson.bc76Subjective = updates.bc76Subjective;
		}

		if (updates.bc76Objective) {
			newModelJson.bc76Objective = updates.bc76Objective;
		}

		if (updates.bc77Subjective) {
			newModelJson.bc77Subjective = updates.bc77Subjective;
		}

		if (updates.bc77Objective) {
			newModelJson.bc77Objective = updates.bc77Objective;
		}

		if (updates.bc78Subjective) {
			newModelJson.bc78Subjective = updates.bc78Subjective;
		}

		if (updates.bc78Objective) {
			newModelJson.bc78Objective = updates.bc78Objective;
		}

		if (updates.bc79Subjective) {
			newModelJson.bc79Subjective = updates.bc79Subjective;
		}

		if (updates.bc79Objective) {
			newModelJson.bc79Objective = updates.bc79Objective;
		}

		if (updates.bc80Subjective) {
			newModelJson.bc80Subjective = updates.bc80Subjective;
		}

		if (updates.bc80Objective) {
			newModelJson.bc80Objective = updates.bc80Objective;
		}

		if (updates.bc81Subjective) {
			newModelJson.bc81Subjective = updates.bc81Subjective;
		}

		if (updates.bc81Objective) {
			newModelJson.bc81Objective = updates.bc81Objective;
		}

		if (updates.bc82Subjective) {
			newModelJson.bc82Subjective = updates.bc82Subjective;
		}

		if (updates.bc82Objective) {
			newModelJson.bc82Objective = updates.bc82Objective;
		}

		if (updates.bc83Subjective) {
			newModelJson.bc83Subjective = updates.bc83Subjective;
		}

		if (updates.bc83Objective) {
			newModelJson.bc83Objective = updates.bc83Objective;
		}

		if (updates.bc84Subjective) {
			newModelJson.bc84Subjective = updates.bc84Subjective;
		}

		if (updates.bc84Objective) {
			newModelJson.bc84Objective = updates.bc84Objective;
		}

		if (updates.medicalExaminationRecordId) {
			newModelJson.medicalExaminationRecordId = updates.medicalExaminationRecordId;
		}

		return new BodyChartExaminationModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BodyChartExaminationModel)) {
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

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
