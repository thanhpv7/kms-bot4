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
export class EntExaminationModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'rightExternalEarSubjective',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'EntExaminationModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return EntExaminationModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	rightExternalEarSubjective: string;

	/**
	 * .
	 */
	rightExternalEarObjective: string;

	/**
	 * .
	 */
	rightConchaSubjective: string;

	/**
	 * .
	 */
	rightConchaObjective: string;

	/**
	 * .
	 */
	rightEarlobeSubjective: string;

	/**
	 * .
	 */
	rightEarlobeObjective: string;

	/**
	 * .
	 */
	rightEarCanalSubjective: string;

	/**
	 * .
	 */
	rightEarCanalObjective: string;

	/**
	 * .
	 */
	rightEardrumSubjective: string;

	/**
	 * .
	 */
	rightEardrumObjective: string;

	/**
	 * .
	 */
	leftExternalEarSubjective: string;

	/**
	 * .
	 */
	leftExternalEarObjective: string;

	/**
	 * .
	 */
	leftConchaSubjective: string;

	/**
	 * .
	 */
	leftConchaObjective: string;

	/**
	 * .
	 */
	leftEarlobeSubjective: string;

	/**
	 * .
	 */
	leftEarlobeObjective: string;

	/**
	 * .
	 */
	leftEarCanalSubjective: string;

	/**
	 * .
	 */
	leftEarCanalObjective: string;

	/**
	 * .
	 */
	leftEardrumSubjective: string;

	/**
	 * .
	 */
	leftEardrumObjective: string;

	/**
	 * .
	 */
	nasalBoneSubjective: string;

	/**
	 * .
	 */
	nasalBoneObjective: string;

	/**
	 * .
	 */
	rightFrontalSinusSubjective: string;

	/**
	 * .
	 */
	rightFrontalSinusObjective: string;

	/**
	 * .
	 */
	rightEthmoidSinusSubjective: string;

	/**
	 * .
	 */
	rightEthmoidSinusObjective: string;

	/**
	 * .
	 */
	rightSuperiorTurbinateSubjective: string;

	/**
	 * .
	 */
	rightSuperiorTurbinateObjective: string;

	/**
	 * .
	 */
	rightMiddleTurbinateSubjective: string;

	/**
	 * .
	 */
	rightMiddleTurbinateObjective: string;

	/**
	 * .
	 */
	rightMaxillarySinusSubjective: string;

	/**
	 * .
	 */
	rightMaxillarySinusObjective: string;

	/**
	 * .
	 */
	rightNasalCavitySubjective: string;

	/**
	 * .
	 */
	rightNasalCavityObjective: string;

	/**
	 * .
	 */
	rightInferiorTurbinateSubjective: string;

	/**
	 * .
	 */
	rightInferiorTurbinateObjective: string;

	/**
	 * .
	 */
	leftFrontalSinusSubjective: string;

	/**
	 * .
	 */
	leftFrontalSinusObjective: string;

	/**
	 * .
	 */
	leftEthmoidSinusSubjective: string;

	/**
	 * .
	 */
	leftEthmoidSinusObjective: string;

	/**
	 * .
	 */
	leftSuperiorTurbinateSubjective: string;

	/**
	 * .
	 */
	leftSuperiorTurbinateObjective: string;

	/**
	 * .
	 */
	leftMiddleTurbinateSubjective: string;

	/**
	 * .
	 */
	leftMiddleTurbinateObjective: string;

	/**
	 * .
	 */
	leftMaxillarySinusSubjective: string;

	/**
	 * .
	 */
	leftMaxillarySinusObjective: string;

	/**
	 * .
	 */
	leftNasalCavitySubjective: string;

	/**
	 * .
	 */
	leftNasalCavityObjective: string;

	/**
	 * .
	 */
	leftInferiorTurbinateSubjective: string;

	/**
	 * .
	 */
	leftInferiorTurbinateObjective: string;

	/**
	 * .
	 */
	lingualTonsilSubjective: string;

	/**
	 * .
	 */
	lingualTonsilObjective: string;

	/**
	 * .
	 */
	epiglottisSubjective: string;

	/**
	 * .
	 */
	epiglottisObjective: string;

	/**
	 * .
	 */
	rightVocalFoldSubjective: string;

	/**
	 * .
	 */
	rightVocalFoldObjective: string;

	/**
	 * .
	 */
	rightVentricularFoldSubjective: string;

	/**
	 * .
	 */
	rightVentricularFoldObjective: string;

	/**
	 * .
	 */
	glottisSubjective: string;

	/**
	 * .
	 */
	glottisObjective: string;

	/**
	 * .
	 */
	rightCuneiformCartilageSubjective: string;

	/**
	 * .
	 */
	rightCuneiformCartilageObjective: string;

	/**
	 * .
	 */
	rightCorniculateCartilageSubjective: string;

	/**
	 * .
	 */
	rightCorniculateCartilageObjective: string;

	/**
	 * .
	 */
	tracheaSubjective: string;

	/**
	 * .
	 */
	tracheaObjective: string;

	/**
	 * .
	 */
	leftVocalFoldSubjective: string;

	/**
	 * .
	 */
	leftVocalFoldObjective: string;

	/**
	 * .
	 */
	leftVentricularFoldSubjective: string;

	/**
	 * .
	 */
	leftVentricularFoldObjective: string;

	/**
	 * .
	 */
	leftCuneiformCartilageSubjective: string;

	/**
	 * .
	 */
	leftCuneiformCartilageObjective: string;

	/**
	 * .
	 */
	leftCorniculateCartilageSubjective: string;

	/**
	 * .
	 */
	leftCorniculateCartilageObjective: string;

	/**
	 * .
	 */
	softPalateSubjective: string;

	/**
	 * .
	 */
	softPalateObjective: string;

	/**
	 * .
	 */
	rightAnteriorPillarSubjective: string;

	/**
	 * .
	 */
	rightAnteriorPillarObjective: string;

	/**
	 * .
	 */
	uvulaSubjective: string;

	/**
	 * .
	 */
	uvulaObjective: string;

	/**
	 * .
	 */
	rightPosteriorPillarSubjective: string;

	/**
	 * .
	 */
	rightPosteriorPillarObjective: string;

	/**
	 * .
	 */
	rightTonsilSubjective: string;

	/**
	 * .
	 */
	rightTonsilObjective: string;

	/**
	 * .
	 */
	rightPosteriorSubjective: string;

	/**
	 * .
	 */
	rightPosteriorObjective: string;

	/**
	 * .
	 */
	upperTongueSubjective: string;

	/**
	 * .
	 */
	upperTongueObjective: string;

	/**
	 * .
	 */
	leftAnteriorPillarSubjective: string;

	/**
	 * .
	 */
	leftAnteriorPillarObjective: string;

	/**
	 * .
	 */
	leftPosteriorPillarSubjective: string;

	/**
	 * .
	 */
	leftPosteriorPillarObjective: string;

	/**
	 * .
	 */
	leftTonsilSubjective: string;

	/**
	 * .
	 */
	leftTonsilObjective: string;

	/**
	 * .
	 */
	leftPosteriorWallSubjective: string;

	/**
	 * .
	 */
	leftPosteriorWallObjective: string;

	medicalExaminationRecordId: string;

	medicalExaminationRecord: MedicalExaminationRecordModel;

	modelPropGroups: { [s: string]: Group } = EntExaminationModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'rightExternalEarSubjective',
				// % protected region % [Set displayName for Right External Ear Subjective here] off begin
				displayName: 'Right External Ear Subjective',
				// % protected region % [Set displayName for Right External Ear Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right External Ear Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right External Ear Subjective here] end
				// % protected region % [Set isSensitive for Right External Ear Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right External Ear Subjective here] end
				// % protected region % [Set readonly for Right External Ear Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right External Ear Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right External Ear Subjective here] off begin
					// % protected region % [Add other validators for Right External Ear Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right External Ear Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right External Ear Subjective here] end
			},
			{
				name: 'rightExternalEarObjective',
				// % protected region % [Set displayName for Right External Ear Objective here] off begin
				displayName: 'Right External Ear Objective',
				// % protected region % [Set displayName for Right External Ear Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right External Ear Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right External Ear Objective here] end
				// % protected region % [Set isSensitive for Right External Ear Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right External Ear Objective here] end
				// % protected region % [Set readonly for Right External Ear Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right External Ear Objective here] end
				validators: [
					// % protected region % [Add other validators for Right External Ear Objective here] off begin
					// % protected region % [Add other validators for Right External Ear Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right External Ear Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right External Ear Objective here] end
			},
			{
				name: 'rightConchaSubjective',
				// % protected region % [Set displayName for Right Concha Subjective here] off begin
				displayName: 'Right Concha Subjective',
				// % protected region % [Set displayName for Right Concha Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Concha Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Concha Subjective here] end
				// % protected region % [Set isSensitive for Right Concha Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Concha Subjective here] end
				// % protected region % [Set readonly for Right Concha Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Concha Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Concha Subjective here] off begin
					// % protected region % [Add other validators for Right Concha Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Concha Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Concha Subjective here] end
			},
			{
				name: 'rightConchaObjective',
				// % protected region % [Set displayName for Right Concha Objective here] off begin
				displayName: 'Right Concha Objective',
				// % protected region % [Set displayName for Right Concha Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Concha Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Concha Objective here] end
				// % protected region % [Set isSensitive for Right Concha Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Concha Objective here] end
				// % protected region % [Set readonly for Right Concha Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Concha Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Concha Objective here] off begin
					// % protected region % [Add other validators for Right Concha Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Concha Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Concha Objective here] end
			},
			{
				name: 'rightEarlobeSubjective',
				// % protected region % [Set displayName for Right Earlobe Subjective here] off begin
				displayName: 'Right Earlobe Subjective',
				// % protected region % [Set displayName for Right Earlobe Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Earlobe Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Earlobe Subjective here] end
				// % protected region % [Set isSensitive for Right Earlobe Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Earlobe Subjective here] end
				// % protected region % [Set readonly for Right Earlobe Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Earlobe Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Earlobe Subjective here] off begin
					// % protected region % [Add other validators for Right Earlobe Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Earlobe Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Earlobe Subjective here] end
			},
			{
				name: 'rightEarlobeObjective',
				// % protected region % [Set displayName for Right Earlobe Objective here] off begin
				displayName: 'Right Earlobe Objective',
				// % protected region % [Set displayName for Right Earlobe Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Earlobe Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Earlobe Objective here] end
				// % protected region % [Set isSensitive for Right Earlobe Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Earlobe Objective here] end
				// % protected region % [Set readonly for Right Earlobe Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Earlobe Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Earlobe Objective here] off begin
					// % protected region % [Add other validators for Right Earlobe Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Earlobe Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Earlobe Objective here] end
			},
			{
				name: 'rightEarCanalSubjective',
				// % protected region % [Set displayName for Right Ear Canal Subjective here] off begin
				displayName: 'Right Ear Canal Subjective',
				// % protected region % [Set displayName for Right Ear Canal Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Ear Canal Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Ear Canal Subjective here] end
				// % protected region % [Set isSensitive for Right Ear Canal Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Ear Canal Subjective here] end
				// % protected region % [Set readonly for Right Ear Canal Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Ear Canal Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Ear Canal Subjective here] off begin
					// % protected region % [Add other validators for Right Ear Canal Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Ear Canal Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Ear Canal Subjective here] end
			},
			{
				name: 'rightEarCanalObjective',
				// % protected region % [Set displayName for Right Ear Canal Objective here] off begin
				displayName: 'Right Ear Canal Objective',
				// % protected region % [Set displayName for Right Ear Canal Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Ear Canal Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Ear Canal Objective here] end
				// % protected region % [Set isSensitive for Right Ear Canal Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Ear Canal Objective here] end
				// % protected region % [Set readonly for Right Ear Canal Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Ear Canal Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Ear Canal Objective here] off begin
					// % protected region % [Add other validators for Right Ear Canal Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Ear Canal Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Ear Canal Objective here] end
			},
			{
				name: 'rightEardrumSubjective',
				// % protected region % [Set displayName for Right Eardrum Subjective here] off begin
				displayName: 'Right Eardrum Subjective',
				// % protected region % [Set displayName for Right Eardrum Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Eardrum Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Eardrum Subjective here] end
				// % protected region % [Set isSensitive for Right Eardrum Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Eardrum Subjective here] end
				// % protected region % [Set readonly for Right Eardrum Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Eardrum Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Eardrum Subjective here] off begin
					// % protected region % [Add other validators for Right Eardrum Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Eardrum Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Eardrum Subjective here] end
			},
			{
				name: 'rightEardrumObjective',
				// % protected region % [Set displayName for Right Eardrum Objective here] off begin
				displayName: 'Right Eardrum Objective',
				// % protected region % [Set displayName for Right Eardrum Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Eardrum Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Eardrum Objective here] end
				// % protected region % [Set isSensitive for Right Eardrum Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Eardrum Objective here] end
				// % protected region % [Set readonly for Right Eardrum Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Eardrum Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Eardrum Objective here] off begin
					// % protected region % [Add other validators for Right Eardrum Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Eardrum Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Eardrum Objective here] end
			},
			{
				name: 'leftExternalEarSubjective',
				// % protected region % [Set displayName for Left External Ear Subjective here] off begin
				displayName: 'Left External Ear Subjective',
				// % protected region % [Set displayName for Left External Ear Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left External Ear Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left External Ear Subjective here] end
				// % protected region % [Set isSensitive for Left External Ear Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left External Ear Subjective here] end
				// % protected region % [Set readonly for Left External Ear Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left External Ear Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left External Ear Subjective here] off begin
					// % protected region % [Add other validators for Left External Ear Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left External Ear Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left External Ear Subjective here] end
			},
			{
				name: 'leftExternalEarObjective',
				// % protected region % [Set displayName for Left External Ear Objective here] off begin
				displayName: 'Left External Ear Objective',
				// % protected region % [Set displayName for Left External Ear Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left External Ear Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left External Ear Objective here] end
				// % protected region % [Set isSensitive for Left External Ear Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left External Ear Objective here] end
				// % protected region % [Set readonly for Left External Ear Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left External Ear Objective here] end
				validators: [
					// % protected region % [Add other validators for Left External Ear Objective here] off begin
					// % protected region % [Add other validators for Left External Ear Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left External Ear Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left External Ear Objective here] end
			},
			{
				name: 'leftConchaSubjective',
				// % protected region % [Set displayName for Left Concha Subjective here] off begin
				displayName: 'Left Concha Subjective',
				// % protected region % [Set displayName for Left Concha Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Concha Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Concha Subjective here] end
				// % protected region % [Set isSensitive for Left Concha Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Concha Subjective here] end
				// % protected region % [Set readonly for Left Concha Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Concha Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Concha Subjective here] off begin
					// % protected region % [Add other validators for Left Concha Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Concha Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Concha Subjective here] end
			},
			{
				name: 'leftConchaObjective',
				// % protected region % [Set displayName for Left Concha Objective here] off begin
				displayName: 'Left Concha Objective',
				// % protected region % [Set displayName for Left Concha Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Concha Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Concha Objective here] end
				// % protected region % [Set isSensitive for Left Concha Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Concha Objective here] end
				// % protected region % [Set readonly for Left Concha Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Concha Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Concha Objective here] off begin
					// % protected region % [Add other validators for Left Concha Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Concha Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Concha Objective here] end
			},
			{
				name: 'leftEarlobeSubjective',
				// % protected region % [Set displayName for Left Earlobe Subjective here] off begin
				displayName: 'Left Earlobe Subjective',
				// % protected region % [Set displayName for Left Earlobe Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Earlobe Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Earlobe Subjective here] end
				// % protected region % [Set isSensitive for Left Earlobe Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Earlobe Subjective here] end
				// % protected region % [Set readonly for Left Earlobe Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Earlobe Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Earlobe Subjective here] off begin
					// % protected region % [Add other validators for Left Earlobe Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Earlobe Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Earlobe Subjective here] end
			},
			{
				name: 'leftEarlobeObjective',
				// % protected region % [Set displayName for Left Earlobe Objective here] off begin
				displayName: 'Left Earlobe Objective',
				// % protected region % [Set displayName for Left Earlobe Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Earlobe Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Earlobe Objective here] end
				// % protected region % [Set isSensitive for Left Earlobe Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Earlobe Objective here] end
				// % protected region % [Set readonly for Left Earlobe Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Earlobe Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Earlobe Objective here] off begin
					// % protected region % [Add other validators for Left Earlobe Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Earlobe Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Earlobe Objective here] end
			},
			{
				name: 'leftEarCanalSubjective',
				// % protected region % [Set displayName for Left Ear Canal Subjective here] off begin
				displayName: 'Left Ear Canal Subjective',
				// % protected region % [Set displayName for Left Ear Canal Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Ear Canal Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Ear Canal Subjective here] end
				// % protected region % [Set isSensitive for Left Ear Canal Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Ear Canal Subjective here] end
				// % protected region % [Set readonly for Left Ear Canal Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Ear Canal Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Ear Canal Subjective here] off begin
					// % protected region % [Add other validators for Left Ear Canal Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Ear Canal Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Ear Canal Subjective here] end
			},
			{
				name: 'leftEarCanalObjective',
				// % protected region % [Set displayName for Left Ear Canal Objective here] off begin
				displayName: 'Left Ear Canal Objective',
				// % protected region % [Set displayName for Left Ear Canal Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Ear Canal Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Ear Canal Objective here] end
				// % protected region % [Set isSensitive for Left Ear Canal Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Ear Canal Objective here] end
				// % protected region % [Set readonly for Left Ear Canal Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Ear Canal Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Ear Canal Objective here] off begin
					// % protected region % [Add other validators for Left Ear Canal Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Ear Canal Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Ear Canal Objective here] end
			},
			{
				name: 'leftEardrumSubjective',
				// % protected region % [Set displayName for Left Eardrum Subjective here] off begin
				displayName: 'Left Eardrum Subjective',
				// % protected region % [Set displayName for Left Eardrum Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Eardrum Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Eardrum Subjective here] end
				// % protected region % [Set isSensitive for Left Eardrum Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Eardrum Subjective here] end
				// % protected region % [Set readonly for Left Eardrum Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Eardrum Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Eardrum Subjective here] off begin
					// % protected region % [Add other validators for Left Eardrum Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Eardrum Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Eardrum Subjective here] end
			},
			{
				name: 'leftEardrumObjective',
				// % protected region % [Set displayName for Left Eardrum Objective here] off begin
				displayName: 'Left Eardrum Objective',
				// % protected region % [Set displayName for Left Eardrum Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Eardrum Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Eardrum Objective here] end
				// % protected region % [Set isSensitive for Left Eardrum Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Eardrum Objective here] end
				// % protected region % [Set readonly for Left Eardrum Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Eardrum Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Eardrum Objective here] off begin
					// % protected region % [Add other validators for Left Eardrum Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Eardrum Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Eardrum Objective here] end
			},
			{
				name: 'nasalBoneSubjective',
				// % protected region % [Set displayName for Nasal Bone Subjective here] off begin
				displayName: 'Nasal Bone Subjective',
				// % protected region % [Set displayName for Nasal Bone Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Nasal Bone Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Nasal Bone Subjective here] end
				// % protected region % [Set isSensitive for Nasal Bone Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nasal Bone Subjective here] end
				// % protected region % [Set readonly for Nasal Bone Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nasal Bone Subjective here] end
				validators: [
					// % protected region % [Add other validators for Nasal Bone Subjective here] off begin
					// % protected region % [Add other validators for Nasal Bone Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Nasal Bone Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Nasal Bone Subjective here] end
			},
			{
				name: 'nasalBoneObjective',
				// % protected region % [Set displayName for Nasal Bone Objective here] off begin
				displayName: 'Nasal Bone Objective',
				// % protected region % [Set displayName for Nasal Bone Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Nasal Bone Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Nasal Bone Objective here] end
				// % protected region % [Set isSensitive for Nasal Bone Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nasal Bone Objective here] end
				// % protected region % [Set readonly for Nasal Bone Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nasal Bone Objective here] end
				validators: [
					// % protected region % [Add other validators for Nasal Bone Objective here] off begin
					// % protected region % [Add other validators for Nasal Bone Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Nasal Bone Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Nasal Bone Objective here] end
			},
			{
				name: 'rightFrontalSinusSubjective',
				// % protected region % [Set displayName for Right Frontal Sinus Subjective here] off begin
				displayName: 'Right Frontal Sinus Subjective',
				// % protected region % [Set displayName for Right Frontal Sinus Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Frontal Sinus Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Frontal Sinus Subjective here] end
				// % protected region % [Set isSensitive for Right Frontal Sinus Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Frontal Sinus Subjective here] end
				// % protected region % [Set readonly for Right Frontal Sinus Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Frontal Sinus Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Frontal Sinus Subjective here] off begin
					// % protected region % [Add other validators for Right Frontal Sinus Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Frontal Sinus Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Frontal Sinus Subjective here] end
			},
			{
				name: 'rightFrontalSinusObjective',
				// % protected region % [Set displayName for Right Frontal Sinus Objective here] off begin
				displayName: 'Right Frontal Sinus Objective',
				// % protected region % [Set displayName for Right Frontal Sinus Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Frontal Sinus Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Frontal Sinus Objective here] end
				// % protected region % [Set isSensitive for Right Frontal Sinus Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Frontal Sinus Objective here] end
				// % protected region % [Set readonly for Right Frontal Sinus Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Frontal Sinus Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Frontal Sinus Objective here] off begin
					// % protected region % [Add other validators for Right Frontal Sinus Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Frontal Sinus Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Frontal Sinus Objective here] end
			},
			{
				name: 'rightEthmoidSinusSubjective',
				// % protected region % [Set displayName for Right Ethmoid Sinus Subjective here] off begin
				displayName: 'Right Ethmoid Sinus Subjective',
				// % protected region % [Set displayName for Right Ethmoid Sinus Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Ethmoid Sinus Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Ethmoid Sinus Subjective here] end
				// % protected region % [Set isSensitive for Right Ethmoid Sinus Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Ethmoid Sinus Subjective here] end
				// % protected region % [Set readonly for Right Ethmoid Sinus Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Ethmoid Sinus Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Ethmoid Sinus Subjective here] off begin
					// % protected region % [Add other validators for Right Ethmoid Sinus Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Ethmoid Sinus Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Ethmoid Sinus Subjective here] end
			},
			{
				name: 'rightEthmoidSinusObjective',
				// % protected region % [Set displayName for Right Ethmoid Sinus Objective here] off begin
				displayName: 'Right Ethmoid Sinus Objective',
				// % protected region % [Set displayName for Right Ethmoid Sinus Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Ethmoid Sinus Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Ethmoid Sinus Objective here] end
				// % protected region % [Set isSensitive for Right Ethmoid Sinus Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Ethmoid Sinus Objective here] end
				// % protected region % [Set readonly for Right Ethmoid Sinus Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Ethmoid Sinus Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Ethmoid Sinus Objective here] off begin
					// % protected region % [Add other validators for Right Ethmoid Sinus Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Ethmoid Sinus Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Ethmoid Sinus Objective here] end
			},
			{
				name: 'rightSuperiorTurbinateSubjective',
				// % protected region % [Set displayName for Right Superior Turbinate Subjective here] off begin
				displayName: 'Right Superior Turbinate Subjective',
				// % protected region % [Set displayName for Right Superior Turbinate Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Superior Turbinate Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Superior Turbinate Subjective here] end
				// % protected region % [Set isSensitive for Right Superior Turbinate Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Superior Turbinate Subjective here] end
				// % protected region % [Set readonly for Right Superior Turbinate Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Superior Turbinate Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Superior Turbinate Subjective here] off begin
					// % protected region % [Add other validators for Right Superior Turbinate Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Superior Turbinate Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Superior Turbinate Subjective here] end
			},
			{
				name: 'rightSuperiorTurbinateObjective',
				// % protected region % [Set displayName for Right Superior Turbinate Objective here] off begin
				displayName: 'Right Superior Turbinate Objective',
				// % protected region % [Set displayName for Right Superior Turbinate Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Superior Turbinate Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Superior Turbinate Objective here] end
				// % protected region % [Set isSensitive for Right Superior Turbinate Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Superior Turbinate Objective here] end
				// % protected region % [Set readonly for Right Superior Turbinate Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Superior Turbinate Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Superior Turbinate Objective here] off begin
					// % protected region % [Add other validators for Right Superior Turbinate Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Superior Turbinate Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Superior Turbinate Objective here] end
			},
			{
				name: 'rightMiddleTurbinateSubjective',
				// % protected region % [Set displayName for Right Middle Turbinate Subjective here] off begin
				displayName: 'Right Middle Turbinate Subjective',
				// % protected region % [Set displayName for Right Middle Turbinate Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Middle Turbinate Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Middle Turbinate Subjective here] end
				// % protected region % [Set isSensitive for Right Middle Turbinate Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Middle Turbinate Subjective here] end
				// % protected region % [Set readonly for Right Middle Turbinate Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Middle Turbinate Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Middle Turbinate Subjective here] off begin
					// % protected region % [Add other validators for Right Middle Turbinate Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Middle Turbinate Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Middle Turbinate Subjective here] end
			},
			{
				name: 'rightMiddleTurbinateObjective',
				// % protected region % [Set displayName for Right Middle Turbinate Objective here] off begin
				displayName: 'Right Middle Turbinate Objective',
				// % protected region % [Set displayName for Right Middle Turbinate Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Middle Turbinate Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Middle Turbinate Objective here] end
				// % protected region % [Set isSensitive for Right Middle Turbinate Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Middle Turbinate Objective here] end
				// % protected region % [Set readonly for Right Middle Turbinate Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Middle Turbinate Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Middle Turbinate Objective here] off begin
					// % protected region % [Add other validators for Right Middle Turbinate Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Middle Turbinate Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Middle Turbinate Objective here] end
			},
			{
				name: 'rightMaxillarySinusSubjective',
				// % protected region % [Set displayName for Right Maxillary Sinus Subjective here] off begin
				displayName: 'Right Maxillary Sinus Subjective',
				// % protected region % [Set displayName for Right Maxillary Sinus Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Maxillary Sinus Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Maxillary Sinus Subjective here] end
				// % protected region % [Set isSensitive for Right Maxillary Sinus Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Maxillary Sinus Subjective here] end
				// % protected region % [Set readonly for Right Maxillary Sinus Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Maxillary Sinus Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Maxillary Sinus Subjective here] off begin
					// % protected region % [Add other validators for Right Maxillary Sinus Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Maxillary Sinus Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Maxillary Sinus Subjective here] end
			},
			{
				name: 'rightMaxillarySinusObjective',
				// % protected region % [Set displayName for Right Maxillary Sinus Objective here] off begin
				displayName: 'Right Maxillary Sinus Objective',
				// % protected region % [Set displayName for Right Maxillary Sinus Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Maxillary Sinus Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Maxillary Sinus Objective here] end
				// % protected region % [Set isSensitive for Right Maxillary Sinus Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Maxillary Sinus Objective here] end
				// % protected region % [Set readonly for Right Maxillary Sinus Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Maxillary Sinus Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Maxillary Sinus Objective here] off begin
					// % protected region % [Add other validators for Right Maxillary Sinus Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Maxillary Sinus Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Maxillary Sinus Objective here] end
			},
			{
				name: 'rightNasalCavitySubjective',
				// % protected region % [Set displayName for Right Nasal Cavity Subjective here] off begin
				displayName: 'Right Nasal Cavity Subjective',
				// % protected region % [Set displayName for Right Nasal Cavity Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Nasal Cavity Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Nasal Cavity Subjective here] end
				// % protected region % [Set isSensitive for Right Nasal Cavity Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Nasal Cavity Subjective here] end
				// % protected region % [Set readonly for Right Nasal Cavity Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Nasal Cavity Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Nasal Cavity Subjective here] off begin
					// % protected region % [Add other validators for Right Nasal Cavity Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Nasal Cavity Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Nasal Cavity Subjective here] end
			},
			{
				name: 'rightNasalCavityObjective',
				// % protected region % [Set displayName for Right Nasal Cavity Objective here] off begin
				displayName: 'Right Nasal Cavity Objective',
				// % protected region % [Set displayName for Right Nasal Cavity Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Nasal Cavity Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Nasal Cavity Objective here] end
				// % protected region % [Set isSensitive for Right Nasal Cavity Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Nasal Cavity Objective here] end
				// % protected region % [Set readonly for Right Nasal Cavity Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Nasal Cavity Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Nasal Cavity Objective here] off begin
					// % protected region % [Add other validators for Right Nasal Cavity Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Nasal Cavity Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Nasal Cavity Objective here] end
			},
			{
				name: 'rightInferiorTurbinateSubjective',
				// % protected region % [Set displayName for Right Inferior Turbinate Subjective here] off begin
				displayName: 'Right Inferior Turbinate Subjective',
				// % protected region % [Set displayName for Right Inferior Turbinate Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Inferior Turbinate Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Inferior Turbinate Subjective here] end
				// % protected region % [Set isSensitive for Right Inferior Turbinate Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Inferior Turbinate Subjective here] end
				// % protected region % [Set readonly for Right Inferior Turbinate Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Inferior Turbinate Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Inferior Turbinate Subjective here] off begin
					// % protected region % [Add other validators for Right Inferior Turbinate Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Inferior Turbinate Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Inferior Turbinate Subjective here] end
			},
			{
				name: 'rightInferiorTurbinateObjective',
				// % protected region % [Set displayName for Right Inferior Turbinate Objective here] off begin
				displayName: 'Right Inferior Turbinate Objective',
				// % protected region % [Set displayName for Right Inferior Turbinate Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Inferior Turbinate Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Inferior Turbinate Objective here] end
				// % protected region % [Set isSensitive for Right Inferior Turbinate Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Inferior Turbinate Objective here] end
				// % protected region % [Set readonly for Right Inferior Turbinate Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Inferior Turbinate Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Inferior Turbinate Objective here] off begin
					// % protected region % [Add other validators for Right Inferior Turbinate Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Inferior Turbinate Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Inferior Turbinate Objective here] end
			},
			{
				name: 'leftFrontalSinusSubjective',
				// % protected region % [Set displayName for Left Frontal Sinus Subjective here] off begin
				displayName: 'Left Frontal Sinus Subjective',
				// % protected region % [Set displayName for Left Frontal Sinus Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Frontal Sinus Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Frontal Sinus Subjective here] end
				// % protected region % [Set isSensitive for Left Frontal Sinus Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Frontal Sinus Subjective here] end
				// % protected region % [Set readonly for Left Frontal Sinus Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Frontal Sinus Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Frontal Sinus Subjective here] off begin
					// % protected region % [Add other validators for Left Frontal Sinus Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Frontal Sinus Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Frontal Sinus Subjective here] end
			},
			{
				name: 'leftFrontalSinusObjective',
				// % protected region % [Set displayName for Left Frontal Sinus Objective here] off begin
				displayName: 'Left Frontal Sinus Objective',
				// % protected region % [Set displayName for Left Frontal Sinus Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Frontal Sinus Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Frontal Sinus Objective here] end
				// % protected region % [Set isSensitive for Left Frontal Sinus Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Frontal Sinus Objective here] end
				// % protected region % [Set readonly for Left Frontal Sinus Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Frontal Sinus Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Frontal Sinus Objective here] off begin
					// % protected region % [Add other validators for Left Frontal Sinus Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Frontal Sinus Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Frontal Sinus Objective here] end
			},
			{
				name: 'leftEthmoidSinusSubjective',
				// % protected region % [Set displayName for Left Ethmoid Sinus Subjective here] off begin
				displayName: 'Left Ethmoid Sinus Subjective',
				// % protected region % [Set displayName for Left Ethmoid Sinus Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Ethmoid Sinus Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Ethmoid Sinus Subjective here] end
				// % protected region % [Set isSensitive for Left Ethmoid Sinus Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Ethmoid Sinus Subjective here] end
				// % protected region % [Set readonly for Left Ethmoid Sinus Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Ethmoid Sinus Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Ethmoid Sinus Subjective here] off begin
					// % protected region % [Add other validators for Left Ethmoid Sinus Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Ethmoid Sinus Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Ethmoid Sinus Subjective here] end
			},
			{
				name: 'leftEthmoidSinusObjective',
				// % protected region % [Set displayName for Left Ethmoid Sinus Objective here] off begin
				displayName: 'Left Ethmoid Sinus Objective',
				// % protected region % [Set displayName for Left Ethmoid Sinus Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Ethmoid Sinus Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Ethmoid Sinus Objective here] end
				// % protected region % [Set isSensitive for Left Ethmoid Sinus Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Ethmoid Sinus Objective here] end
				// % protected region % [Set readonly for Left Ethmoid Sinus Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Ethmoid Sinus Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Ethmoid Sinus Objective here] off begin
					// % protected region % [Add other validators for Left Ethmoid Sinus Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Ethmoid Sinus Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Ethmoid Sinus Objective here] end
			},
			{
				name: 'leftSuperiorTurbinateSubjective',
				// % protected region % [Set displayName for Left Superior Turbinate Subjective here] off begin
				displayName: 'Left Superior Turbinate Subjective',
				// % protected region % [Set displayName for Left Superior Turbinate Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Superior Turbinate Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Superior Turbinate Subjective here] end
				// % protected region % [Set isSensitive for Left Superior Turbinate Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Superior Turbinate Subjective here] end
				// % protected region % [Set readonly for Left Superior Turbinate Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Superior Turbinate Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Superior Turbinate Subjective here] off begin
					// % protected region % [Add other validators for Left Superior Turbinate Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Superior Turbinate Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Superior Turbinate Subjective here] end
			},
			{
				name: 'leftSuperiorTurbinateObjective',
				// % protected region % [Set displayName for Left Superior Turbinate Objective here] off begin
				displayName: 'Left Superior Turbinate Objective',
				// % protected region % [Set displayName for Left Superior Turbinate Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Superior Turbinate Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Superior Turbinate Objective here] end
				// % protected region % [Set isSensitive for Left Superior Turbinate Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Superior Turbinate Objective here] end
				// % protected region % [Set readonly for Left Superior Turbinate Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Superior Turbinate Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Superior Turbinate Objective here] off begin
					// % protected region % [Add other validators for Left Superior Turbinate Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Superior Turbinate Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Superior Turbinate Objective here] end
			},
			{
				name: 'leftMiddleTurbinateSubjective',
				// % protected region % [Set displayName for Left Middle Turbinate Subjective here] off begin
				displayName: 'Left Middle Turbinate Subjective',
				// % protected region % [Set displayName for Left Middle Turbinate Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Middle Turbinate Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Middle Turbinate Subjective here] end
				// % protected region % [Set isSensitive for Left Middle Turbinate Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Middle Turbinate Subjective here] end
				// % protected region % [Set readonly for Left Middle Turbinate Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Middle Turbinate Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Middle Turbinate Subjective here] off begin
					// % protected region % [Add other validators for Left Middle Turbinate Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Middle Turbinate Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Middle Turbinate Subjective here] end
			},
			{
				name: 'leftMiddleTurbinateObjective',
				// % protected region % [Set displayName for Left Middle Turbinate Objective here] off begin
				displayName: 'Left Middle Turbinate Objective',
				// % protected region % [Set displayName for Left Middle Turbinate Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Middle Turbinate Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Middle Turbinate Objective here] end
				// % protected region % [Set isSensitive for Left Middle Turbinate Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Middle Turbinate Objective here] end
				// % protected region % [Set readonly for Left Middle Turbinate Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Middle Turbinate Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Middle Turbinate Objective here] off begin
					// % protected region % [Add other validators for Left Middle Turbinate Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Middle Turbinate Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Middle Turbinate Objective here] end
			},
			{
				name: 'leftMaxillarySinusSubjective',
				// % protected region % [Set displayName for Left Maxillary Sinus Subjective here] off begin
				displayName: 'Left Maxillary Sinus Subjective',
				// % protected region % [Set displayName for Left Maxillary Sinus Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Maxillary Sinus Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Maxillary Sinus Subjective here] end
				// % protected region % [Set isSensitive for Left Maxillary Sinus Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Maxillary Sinus Subjective here] end
				// % protected region % [Set readonly for Left Maxillary Sinus Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Maxillary Sinus Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Maxillary Sinus Subjective here] off begin
					// % protected region % [Add other validators for Left Maxillary Sinus Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Maxillary Sinus Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Maxillary Sinus Subjective here] end
			},
			{
				name: 'leftMaxillarySinusObjective',
				// % protected region % [Set displayName for Left Maxillary Sinus Objective here] off begin
				displayName: 'Left Maxillary Sinus Objective',
				// % protected region % [Set displayName for Left Maxillary Sinus Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Maxillary Sinus Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Maxillary Sinus Objective here] end
				// % protected region % [Set isSensitive for Left Maxillary Sinus Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Maxillary Sinus Objective here] end
				// % protected region % [Set readonly for Left Maxillary Sinus Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Maxillary Sinus Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Maxillary Sinus Objective here] off begin
					// % protected region % [Add other validators for Left Maxillary Sinus Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Maxillary Sinus Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Maxillary Sinus Objective here] end
			},
			{
				name: 'leftNasalCavitySubjective',
				// % protected region % [Set displayName for Left Nasal Cavity Subjective here] off begin
				displayName: 'Left Nasal Cavity Subjective',
				// % protected region % [Set displayName for Left Nasal Cavity Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Nasal Cavity Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Nasal Cavity Subjective here] end
				// % protected region % [Set isSensitive for Left Nasal Cavity Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Nasal Cavity Subjective here] end
				// % protected region % [Set readonly for Left Nasal Cavity Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Nasal Cavity Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Nasal Cavity Subjective here] off begin
					// % protected region % [Add other validators for Left Nasal Cavity Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Nasal Cavity Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Nasal Cavity Subjective here] end
			},
			{
				name: 'leftNasalCavityObjective',
				// % protected region % [Set displayName for Left Nasal Cavity Objective here] off begin
				displayName: 'Left Nasal Cavity Objective',
				// % protected region % [Set displayName for Left Nasal Cavity Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Nasal Cavity Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Nasal Cavity Objective here] end
				// % protected region % [Set isSensitive for Left Nasal Cavity Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Nasal Cavity Objective here] end
				// % protected region % [Set readonly for Left Nasal Cavity Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Nasal Cavity Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Nasal Cavity Objective here] off begin
					// % protected region % [Add other validators for Left Nasal Cavity Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Nasal Cavity Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Nasal Cavity Objective here] end
			},
			{
				name: 'leftInferiorTurbinateSubjective',
				// % protected region % [Set displayName for Left Inferior Turbinate Subjective here] off begin
				displayName: 'Left Inferior Turbinate Subjective',
				// % protected region % [Set displayName for Left Inferior Turbinate Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Inferior Turbinate Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Inferior Turbinate Subjective here] end
				// % protected region % [Set isSensitive for Left Inferior Turbinate Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Inferior Turbinate Subjective here] end
				// % protected region % [Set readonly for Left Inferior Turbinate Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Inferior Turbinate Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Inferior Turbinate Subjective here] off begin
					// % protected region % [Add other validators for Left Inferior Turbinate Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Inferior Turbinate Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Inferior Turbinate Subjective here] end
			},
			{
				name: 'leftInferiorTurbinateObjective',
				// % protected region % [Set displayName for Left Inferior Turbinate Objective here] off begin
				displayName: 'Left Inferior Turbinate Objective',
				// % protected region % [Set displayName for Left Inferior Turbinate Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Inferior Turbinate Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Inferior Turbinate Objective here] end
				// % protected region % [Set isSensitive for Left Inferior Turbinate Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Inferior Turbinate Objective here] end
				// % protected region % [Set readonly for Left Inferior Turbinate Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Inferior Turbinate Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Inferior Turbinate Objective here] off begin
					// % protected region % [Add other validators for Left Inferior Turbinate Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Inferior Turbinate Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Inferior Turbinate Objective here] end
			},
			{
				name: 'lingualTonsilSubjective',
				// % protected region % [Set displayName for Lingual Tonsil Subjective here] off begin
				displayName: 'Lingual Tonsil Subjective',
				// % protected region % [Set displayName for Lingual Tonsil Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Lingual Tonsil Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Lingual Tonsil Subjective here] end
				// % protected region % [Set isSensitive for Lingual Tonsil Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Lingual Tonsil Subjective here] end
				// % protected region % [Set readonly for Lingual Tonsil Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Lingual Tonsil Subjective here] end
				validators: [
					// % protected region % [Add other validators for Lingual Tonsil Subjective here] off begin
					// % protected region % [Add other validators for Lingual Tonsil Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Lingual Tonsil Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Lingual Tonsil Subjective here] end
			},
			{
				name: 'lingualTonsilObjective',
				// % protected region % [Set displayName for Lingual Tonsil Objective here] off begin
				displayName: 'Lingual Tonsil Objective',
				// % protected region % [Set displayName for Lingual Tonsil Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Lingual Tonsil Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Lingual Tonsil Objective here] end
				// % protected region % [Set isSensitive for Lingual Tonsil Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Lingual Tonsil Objective here] end
				// % protected region % [Set readonly for Lingual Tonsil Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Lingual Tonsil Objective here] end
				validators: [
					// % protected region % [Add other validators for Lingual Tonsil Objective here] off begin
					// % protected region % [Add other validators for Lingual Tonsil Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Lingual Tonsil Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Lingual Tonsil Objective here] end
			},
			{
				name: 'epiglottisSubjective',
				// % protected region % [Set displayName for Epiglottis Subjective here] off begin
				displayName: 'Epiglottis Subjective',
				// % protected region % [Set displayName for Epiglottis Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Epiglottis Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Epiglottis Subjective here] end
				// % protected region % [Set isSensitive for Epiglottis Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Epiglottis Subjective here] end
				// % protected region % [Set readonly for Epiglottis Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Epiglottis Subjective here] end
				validators: [
					// % protected region % [Add other validators for Epiglottis Subjective here] off begin
					// % protected region % [Add other validators for Epiglottis Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Epiglottis Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Epiglottis Subjective here] end
			},
			{
				name: 'epiglottisObjective',
				// % protected region % [Set displayName for Epiglottis Objective here] off begin
				displayName: 'Epiglottis Objective',
				// % protected region % [Set displayName for Epiglottis Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Epiglottis Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Epiglottis Objective here] end
				// % protected region % [Set isSensitive for Epiglottis Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Epiglottis Objective here] end
				// % protected region % [Set readonly for Epiglottis Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Epiglottis Objective here] end
				validators: [
					// % protected region % [Add other validators for Epiglottis Objective here] off begin
					// % protected region % [Add other validators for Epiglottis Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Epiglottis Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Epiglottis Objective here] end
			},
			{
				name: 'rightVocalFoldSubjective',
				// % protected region % [Set displayName for Right Vocal Fold Subjective here] off begin
				displayName: 'Right Vocal Fold Subjective',
				// % protected region % [Set displayName for Right Vocal Fold Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Vocal Fold Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Vocal Fold Subjective here] end
				// % protected region % [Set isSensitive for Right Vocal Fold Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Vocal Fold Subjective here] end
				// % protected region % [Set readonly for Right Vocal Fold Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Vocal Fold Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Vocal Fold Subjective here] off begin
					// % protected region % [Add other validators for Right Vocal Fold Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Vocal Fold Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Vocal Fold Subjective here] end
			},
			{
				name: 'rightVocalFoldObjective',
				// % protected region % [Set displayName for Right Vocal Fold Objective here] off begin
				displayName: 'Right Vocal Fold Objective',
				// % protected region % [Set displayName for Right Vocal Fold Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Vocal Fold Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Vocal Fold Objective here] end
				// % protected region % [Set isSensitive for Right Vocal Fold Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Vocal Fold Objective here] end
				// % protected region % [Set readonly for Right Vocal Fold Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Vocal Fold Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Vocal Fold Objective here] off begin
					// % protected region % [Add other validators for Right Vocal Fold Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Vocal Fold Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Vocal Fold Objective here] end
			},
			{
				name: 'rightVentricularFoldSubjective',
				// % protected region % [Set displayName for Right Ventricular Fold Subjective here] off begin
				displayName: 'Right Ventricular Fold Subjective',
				// % protected region % [Set displayName for Right Ventricular Fold Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Ventricular Fold Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Ventricular Fold Subjective here] end
				// % protected region % [Set isSensitive for Right Ventricular Fold Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Ventricular Fold Subjective here] end
				// % protected region % [Set readonly for Right Ventricular Fold Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Ventricular Fold Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Ventricular Fold Subjective here] off begin
					// % protected region % [Add other validators for Right Ventricular Fold Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Ventricular Fold Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Ventricular Fold Subjective here] end
			},
			{
				name: 'rightVentricularFoldObjective',
				// % protected region % [Set displayName for Right Ventricular Fold Objective here] off begin
				displayName: 'Right Ventricular Fold Objective',
				// % protected region % [Set displayName for Right Ventricular Fold Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Ventricular Fold Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Ventricular Fold Objective here] end
				// % protected region % [Set isSensitive for Right Ventricular Fold Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Ventricular Fold Objective here] end
				// % protected region % [Set readonly for Right Ventricular Fold Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Ventricular Fold Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Ventricular Fold Objective here] off begin
					// % protected region % [Add other validators for Right Ventricular Fold Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Ventricular Fold Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Ventricular Fold Objective here] end
			},
			{
				name: 'glottisSubjective',
				// % protected region % [Set displayName for Glottis Subjective here] off begin
				displayName: 'Glottis Subjective',
				// % protected region % [Set displayName for Glottis Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Glottis Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Glottis Subjective here] end
				// % protected region % [Set isSensitive for Glottis Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Glottis Subjective here] end
				// % protected region % [Set readonly for Glottis Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Glottis Subjective here] end
				validators: [
					// % protected region % [Add other validators for Glottis Subjective here] off begin
					// % protected region % [Add other validators for Glottis Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Glottis Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Glottis Subjective here] end
			},
			{
				name: 'glottisObjective',
				// % protected region % [Set displayName for Glottis Objective here] off begin
				displayName: 'Glottis Objective',
				// % protected region % [Set displayName for Glottis Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Glottis Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Glottis Objective here] end
				// % protected region % [Set isSensitive for Glottis Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Glottis Objective here] end
				// % protected region % [Set readonly for Glottis Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Glottis Objective here] end
				validators: [
					// % protected region % [Add other validators for Glottis Objective here] off begin
					// % protected region % [Add other validators for Glottis Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Glottis Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Glottis Objective here] end
			},
			{
				name: 'rightCuneiformCartilageSubjective',
				// % protected region % [Set displayName for Right Cuneiform Cartilage Subjective here] off begin
				displayName: 'Right Cuneiform Cartilage Subjective',
				// % protected region % [Set displayName for Right Cuneiform Cartilage Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Cuneiform Cartilage Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Cuneiform Cartilage Subjective here] end
				// % protected region % [Set isSensitive for Right Cuneiform Cartilage Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Cuneiform Cartilage Subjective here] end
				// % protected region % [Set readonly for Right Cuneiform Cartilage Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Cuneiform Cartilage Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Cuneiform Cartilage Subjective here] off begin
					// % protected region % [Add other validators for Right Cuneiform Cartilage Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Cuneiform Cartilage Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Cuneiform Cartilage Subjective here] end
			},
			{
				name: 'rightCuneiformCartilageObjective',
				// % protected region % [Set displayName for Right Cuneiform Cartilage Objective here] off begin
				displayName: 'Right Cuneiform Cartilage Objective',
				// % protected region % [Set displayName for Right Cuneiform Cartilage Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Cuneiform Cartilage Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Cuneiform Cartilage Objective here] end
				// % protected region % [Set isSensitive for Right Cuneiform Cartilage Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Cuneiform Cartilage Objective here] end
				// % protected region % [Set readonly for Right Cuneiform Cartilage Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Cuneiform Cartilage Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Cuneiform Cartilage Objective here] off begin
					// % protected region % [Add other validators for Right Cuneiform Cartilage Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Cuneiform Cartilage Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Cuneiform Cartilage Objective here] end
			},
			{
				name: 'rightCorniculateCartilageSubjective',
				// % protected region % [Set displayName for Right Corniculate Cartilage Subjective here] off begin
				displayName: 'Right Corniculate Cartilage Subjective',
				// % protected region % [Set displayName for Right Corniculate Cartilage Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Corniculate Cartilage Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Corniculate Cartilage Subjective here] end
				// % protected region % [Set isSensitive for Right Corniculate Cartilage Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Corniculate Cartilage Subjective here] end
				// % protected region % [Set readonly for Right Corniculate Cartilage Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Corniculate Cartilage Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Corniculate Cartilage Subjective here] off begin
					// % protected region % [Add other validators for Right Corniculate Cartilage Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Corniculate Cartilage Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Corniculate Cartilage Subjective here] end
			},
			{
				name: 'rightCorniculateCartilageObjective',
				// % protected region % [Set displayName for Right Corniculate Cartilage Objective here] off begin
				displayName: 'Right Corniculate Cartilage Objective',
				// % protected region % [Set displayName for Right Corniculate Cartilage Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Corniculate Cartilage Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Corniculate Cartilage Objective here] end
				// % protected region % [Set isSensitive for Right Corniculate Cartilage Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Corniculate Cartilage Objective here] end
				// % protected region % [Set readonly for Right Corniculate Cartilage Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Corniculate Cartilage Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Corniculate Cartilage Objective here] off begin
					// % protected region % [Add other validators for Right Corniculate Cartilage Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Corniculate Cartilage Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Corniculate Cartilage Objective here] end
			},
			{
				name: 'tracheaSubjective',
				// % protected region % [Set displayName for Trachea Subjective here] off begin
				displayName: 'Trachea Subjective',
				// % protected region % [Set displayName for Trachea Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Trachea Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Trachea Subjective here] end
				// % protected region % [Set isSensitive for Trachea Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Trachea Subjective here] end
				// % protected region % [Set readonly for Trachea Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Trachea Subjective here] end
				validators: [
					// % protected region % [Add other validators for Trachea Subjective here] off begin
					// % protected region % [Add other validators for Trachea Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Trachea Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Trachea Subjective here] end
			},
			{
				name: 'tracheaObjective',
				// % protected region % [Set displayName for Trachea Objective here] off begin
				displayName: 'Trachea Objective',
				// % protected region % [Set displayName for Trachea Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Trachea Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Trachea Objective here] end
				// % protected region % [Set isSensitive for Trachea Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Trachea Objective here] end
				// % protected region % [Set readonly for Trachea Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Trachea Objective here] end
				validators: [
					// % protected region % [Add other validators for Trachea Objective here] off begin
					// % protected region % [Add other validators for Trachea Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Trachea Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Trachea Objective here] end
			},
			{
				name: 'leftVocalFoldSubjective',
				// % protected region % [Set displayName for Left Vocal Fold Subjective here] off begin
				displayName: 'Left Vocal Fold Subjective',
				// % protected region % [Set displayName for Left Vocal Fold Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Vocal Fold Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Vocal Fold Subjective here] end
				// % protected region % [Set isSensitive for Left Vocal Fold Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Vocal Fold Subjective here] end
				// % protected region % [Set readonly for Left Vocal Fold Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Vocal Fold Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Vocal Fold Subjective here] off begin
					// % protected region % [Add other validators for Left Vocal Fold Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Vocal Fold Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Vocal Fold Subjective here] end
			},
			{
				name: 'leftVocalFoldObjective',
				// % protected region % [Set displayName for Left Vocal Fold Objective here] off begin
				displayName: 'Left Vocal Fold Objective',
				// % protected region % [Set displayName for Left Vocal Fold Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Vocal Fold Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Vocal Fold Objective here] end
				// % protected region % [Set isSensitive for Left Vocal Fold Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Vocal Fold Objective here] end
				// % protected region % [Set readonly for Left Vocal Fold Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Vocal Fold Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Vocal Fold Objective here] off begin
					// % protected region % [Add other validators for Left Vocal Fold Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Vocal Fold Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Vocal Fold Objective here] end
			},
			{
				name: 'leftVentricularFoldSubjective',
				// % protected region % [Set displayName for Left Ventricular Fold Subjective here] off begin
				displayName: 'Left Ventricular Fold Subjective',
				// % protected region % [Set displayName for Left Ventricular Fold Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Ventricular Fold Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Ventricular Fold Subjective here] end
				// % protected region % [Set isSensitive for Left Ventricular Fold Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Ventricular Fold Subjective here] end
				// % protected region % [Set readonly for Left Ventricular Fold Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Ventricular Fold Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Ventricular Fold Subjective here] off begin
					// % protected region % [Add other validators for Left Ventricular Fold Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Ventricular Fold Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Ventricular Fold Subjective here] end
			},
			{
				name: 'leftVentricularFoldObjective',
				// % protected region % [Set displayName for Left Ventricular Fold Objective here] off begin
				displayName: 'Left Ventricular Fold Objective',
				// % protected region % [Set displayName for Left Ventricular Fold Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Ventricular Fold Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Ventricular Fold Objective here] end
				// % protected region % [Set isSensitive for Left Ventricular Fold Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Ventricular Fold Objective here] end
				// % protected region % [Set readonly for Left Ventricular Fold Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Ventricular Fold Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Ventricular Fold Objective here] off begin
					// % protected region % [Add other validators for Left Ventricular Fold Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Ventricular Fold Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Ventricular Fold Objective here] end
			},
			{
				name: 'leftCuneiformCartilageSubjective',
				// % protected region % [Set displayName for Left Cuneiform Cartilage Subjective here] off begin
				displayName: 'Left Cuneiform Cartilage Subjective',
				// % protected region % [Set displayName for Left Cuneiform Cartilage Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Cuneiform Cartilage Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Cuneiform Cartilage Subjective here] end
				// % protected region % [Set isSensitive for Left Cuneiform Cartilage Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Cuneiform Cartilage Subjective here] end
				// % protected region % [Set readonly for Left Cuneiform Cartilage Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Cuneiform Cartilage Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Cuneiform Cartilage Subjective here] off begin
					// % protected region % [Add other validators for Left Cuneiform Cartilage Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Cuneiform Cartilage Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Cuneiform Cartilage Subjective here] end
			},
			{
				name: 'leftCuneiformCartilageObjective',
				// % protected region % [Set displayName for Left Cuneiform Cartilage Objective here] off begin
				displayName: 'Left Cuneiform Cartilage Objective',
				// % protected region % [Set displayName for Left Cuneiform Cartilage Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Cuneiform Cartilage Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Cuneiform Cartilage Objective here] end
				// % protected region % [Set isSensitive for Left Cuneiform Cartilage Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Cuneiform Cartilage Objective here] end
				// % protected region % [Set readonly for Left Cuneiform Cartilage Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Cuneiform Cartilage Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Cuneiform Cartilage Objective here] off begin
					// % protected region % [Add other validators for Left Cuneiform Cartilage Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Cuneiform Cartilage Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Cuneiform Cartilage Objective here] end
			},
			{
				name: 'leftCorniculateCartilageSubjective',
				// % protected region % [Set displayName for Left Corniculate Cartilage Subjective here] off begin
				displayName: 'Left Corniculate Cartilage Subjective',
				// % protected region % [Set displayName for Left Corniculate Cartilage Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Corniculate Cartilage Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Corniculate Cartilage Subjective here] end
				// % protected region % [Set isSensitive for Left Corniculate Cartilage Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Corniculate Cartilage Subjective here] end
				// % protected region % [Set readonly for Left Corniculate Cartilage Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Corniculate Cartilage Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Corniculate Cartilage Subjective here] off begin
					// % protected region % [Add other validators for Left Corniculate Cartilage Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Corniculate Cartilage Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Corniculate Cartilage Subjective here] end
			},
			{
				name: 'leftCorniculateCartilageObjective',
				// % protected region % [Set displayName for Left Corniculate Cartilage Objective here] off begin
				displayName: 'Left Corniculate Cartilage Objective',
				// % protected region % [Set displayName for Left Corniculate Cartilage Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Corniculate Cartilage Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Corniculate Cartilage Objective here] end
				// % protected region % [Set isSensitive for Left Corniculate Cartilage Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Corniculate Cartilage Objective here] end
				// % protected region % [Set readonly for Left Corniculate Cartilage Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Corniculate Cartilage Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Corniculate Cartilage Objective here] off begin
					// % protected region % [Add other validators for Left Corniculate Cartilage Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Corniculate Cartilage Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Corniculate Cartilage Objective here] end
			},
			{
				name: 'softPalateSubjective',
				// % protected region % [Set displayName for Soft Palate Subjective here] off begin
				displayName: 'Soft Palate Subjective',
				// % protected region % [Set displayName for Soft Palate Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Soft Palate Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Soft Palate Subjective here] end
				// % protected region % [Set isSensitive for Soft Palate Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Soft Palate Subjective here] end
				// % protected region % [Set readonly for Soft Palate Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Soft Palate Subjective here] end
				validators: [
					// % protected region % [Add other validators for Soft Palate Subjective here] off begin
					// % protected region % [Add other validators for Soft Palate Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Soft Palate Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Soft Palate Subjective here] end
			},
			{
				name: 'softPalateObjective',
				// % protected region % [Set displayName for Soft Palate Objective here] off begin
				displayName: 'Soft Palate Objective',
				// % protected region % [Set displayName for Soft Palate Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Soft Palate Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Soft Palate Objective here] end
				// % protected region % [Set isSensitive for Soft Palate Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Soft Palate Objective here] end
				// % protected region % [Set readonly for Soft Palate Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Soft Palate Objective here] end
				validators: [
					// % protected region % [Add other validators for Soft Palate Objective here] off begin
					// % protected region % [Add other validators for Soft Palate Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Soft Palate Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Soft Palate Objective here] end
			},
			{
				name: 'rightAnteriorPillarSubjective',
				// % protected region % [Set displayName for Right Anterior Pillar Subjective here] off begin
				displayName: 'Right Anterior Pillar Subjective',
				// % protected region % [Set displayName for Right Anterior Pillar Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Anterior Pillar Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Anterior Pillar Subjective here] end
				// % protected region % [Set isSensitive for Right Anterior Pillar Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Anterior Pillar Subjective here] end
				// % protected region % [Set readonly for Right Anterior Pillar Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Anterior Pillar Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Anterior Pillar Subjective here] off begin
					// % protected region % [Add other validators for Right Anterior Pillar Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Anterior Pillar Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Anterior Pillar Subjective here] end
			},
			{
				name: 'rightAnteriorPillarObjective',
				// % protected region % [Set displayName for Right Anterior Pillar Objective here] off begin
				displayName: 'Right Anterior Pillar Objective',
				// % protected region % [Set displayName for Right Anterior Pillar Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Anterior Pillar Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Anterior Pillar Objective here] end
				// % protected region % [Set isSensitive for Right Anterior Pillar Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Anterior Pillar Objective here] end
				// % protected region % [Set readonly for Right Anterior Pillar Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Anterior Pillar Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Anterior Pillar Objective here] off begin
					// % protected region % [Add other validators for Right Anterior Pillar Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Anterior Pillar Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Anterior Pillar Objective here] end
			},
			{
				name: 'uvulaSubjective',
				// % protected region % [Set displayName for Uvula Subjective here] off begin
				displayName: 'Uvula Subjective',
				// % protected region % [Set displayName for Uvula Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Uvula Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Uvula Subjective here] end
				// % protected region % [Set isSensitive for Uvula Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Uvula Subjective here] end
				// % protected region % [Set readonly for Uvula Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Uvula Subjective here] end
				validators: [
					// % protected region % [Add other validators for Uvula Subjective here] off begin
					// % protected region % [Add other validators for Uvula Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Uvula Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Uvula Subjective here] end
			},
			{
				name: 'uvulaObjective',
				// % protected region % [Set displayName for Uvula Objective here] off begin
				displayName: 'Uvula Objective',
				// % protected region % [Set displayName for Uvula Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Uvula Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Uvula Objective here] end
				// % protected region % [Set isSensitive for Uvula Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Uvula Objective here] end
				// % protected region % [Set readonly for Uvula Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Uvula Objective here] end
				validators: [
					// % protected region % [Add other validators for Uvula Objective here] off begin
					// % protected region % [Add other validators for Uvula Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Uvula Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Uvula Objective here] end
			},
			{
				name: 'rightPosteriorPillarSubjective',
				// % protected region % [Set displayName for Right Posterior Pillar Subjective here] off begin
				displayName: 'Right Posterior Pillar Subjective',
				// % protected region % [Set displayName for Right Posterior Pillar Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Posterior Pillar Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Posterior Pillar Subjective here] end
				// % protected region % [Set isSensitive for Right Posterior Pillar Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Posterior Pillar Subjective here] end
				// % protected region % [Set readonly for Right Posterior Pillar Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Posterior Pillar Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Posterior Pillar Subjective here] off begin
					// % protected region % [Add other validators for Right Posterior Pillar Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Posterior Pillar Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Posterior Pillar Subjective here] end
			},
			{
				name: 'rightPosteriorPillarObjective',
				// % protected region % [Set displayName for Right Posterior Pillar Objective here] off begin
				displayName: 'Right Posterior Pillar Objective',
				// % protected region % [Set displayName for Right Posterior Pillar Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Posterior Pillar Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Posterior Pillar Objective here] end
				// % protected region % [Set isSensitive for Right Posterior Pillar Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Posterior Pillar Objective here] end
				// % protected region % [Set readonly for Right Posterior Pillar Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Posterior Pillar Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Posterior Pillar Objective here] off begin
					// % protected region % [Add other validators for Right Posterior Pillar Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Posterior Pillar Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Posterior Pillar Objective here] end
			},
			{
				name: 'rightTonsilSubjective',
				// % protected region % [Set displayName for Right Tonsil Subjective here] off begin
				displayName: 'Right Tonsil Subjective',
				// % protected region % [Set displayName for Right Tonsil Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Tonsil Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Tonsil Subjective here] end
				// % protected region % [Set isSensitive for Right Tonsil Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Tonsil Subjective here] end
				// % protected region % [Set readonly for Right Tonsil Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Tonsil Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Tonsil Subjective here] off begin
					// % protected region % [Add other validators for Right Tonsil Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Tonsil Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Tonsil Subjective here] end
			},
			{
				name: 'rightTonsilObjective',
				// % protected region % [Set displayName for Right Tonsil Objective here] off begin
				displayName: 'Right Tonsil Objective',
				// % protected region % [Set displayName for Right Tonsil Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Tonsil Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Tonsil Objective here] end
				// % protected region % [Set isSensitive for Right Tonsil Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Tonsil Objective here] end
				// % protected region % [Set readonly for Right Tonsil Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Tonsil Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Tonsil Objective here] off begin
					// % protected region % [Add other validators for Right Tonsil Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Tonsil Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Tonsil Objective here] end
			},
			{
				name: 'rightPosteriorSubjective',
				// % protected region % [Set displayName for Right Posterior Subjective here] off begin
				displayName: 'Right Posterior Subjective',
				// % protected region % [Set displayName for Right Posterior Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Posterior Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Posterior Subjective here] end
				// % protected region % [Set isSensitive for Right Posterior Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Posterior Subjective here] end
				// % protected region % [Set readonly for Right Posterior Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Posterior Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Posterior Subjective here] off begin
					// % protected region % [Add other validators for Right Posterior Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Posterior Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Posterior Subjective here] end
			},
			{
				name: 'rightPosteriorObjective',
				// % protected region % [Set displayName for Right Posterior Objective here] off begin
				displayName: 'Right Posterior Objective',
				// % protected region % [Set displayName for Right Posterior Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Posterior Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Posterior Objective here] end
				// % protected region % [Set isSensitive for Right Posterior Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Posterior Objective here] end
				// % protected region % [Set readonly for Right Posterior Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Posterior Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Posterior Objective here] off begin
					// % protected region % [Add other validators for Right Posterior Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Posterior Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Posterior Objective here] end
			},
			{
				name: 'upperTongueSubjective',
				// % protected region % [Set displayName for Upper Tongue Subjective here] off begin
				displayName: 'Upper Tongue Subjective',
				// % protected region % [Set displayName for Upper Tongue Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Upper Tongue Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Upper Tongue Subjective here] end
				// % protected region % [Set isSensitive for Upper Tongue Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Upper Tongue Subjective here] end
				// % protected region % [Set readonly for Upper Tongue Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Upper Tongue Subjective here] end
				validators: [
					// % protected region % [Add other validators for Upper Tongue Subjective here] off begin
					// % protected region % [Add other validators for Upper Tongue Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Upper Tongue Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Upper Tongue Subjective here] end
			},
			{
				name: 'upperTongueObjective',
				// % protected region % [Set displayName for Upper Tongue Objective here] off begin
				displayName: 'Upper Tongue Objective',
				// % protected region % [Set displayName for Upper Tongue Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Upper Tongue Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Upper Tongue Objective here] end
				// % protected region % [Set isSensitive for Upper Tongue Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Upper Tongue Objective here] end
				// % protected region % [Set readonly for Upper Tongue Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Upper Tongue Objective here] end
				validators: [
					// % protected region % [Add other validators for Upper Tongue Objective here] off begin
					// % protected region % [Add other validators for Upper Tongue Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Upper Tongue Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Upper Tongue Objective here] end
			},
			{
				name: 'leftAnteriorPillarSubjective',
				// % protected region % [Set displayName for Left Anterior Pillar Subjective here] off begin
				displayName: 'Left Anterior Pillar Subjective',
				// % protected region % [Set displayName for Left Anterior Pillar Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Anterior Pillar Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Anterior Pillar Subjective here] end
				// % protected region % [Set isSensitive for Left Anterior Pillar Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Anterior Pillar Subjective here] end
				// % protected region % [Set readonly for Left Anterior Pillar Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Anterior Pillar Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Anterior Pillar Subjective here] off begin
					// % protected region % [Add other validators for Left Anterior Pillar Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Anterior Pillar Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Anterior Pillar Subjective here] end
			},
			{
				name: 'leftAnteriorPillarObjective',
				// % protected region % [Set displayName for Left Anterior Pillar Objective here] off begin
				displayName: 'Left Anterior Pillar Objective',
				// % protected region % [Set displayName for Left Anterior Pillar Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Anterior Pillar Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Anterior Pillar Objective here] end
				// % protected region % [Set isSensitive for Left Anterior Pillar Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Anterior Pillar Objective here] end
				// % protected region % [Set readonly for Left Anterior Pillar Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Anterior Pillar Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Anterior Pillar Objective here] off begin
					// % protected region % [Add other validators for Left Anterior Pillar Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Anterior Pillar Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Anterior Pillar Objective here] end
			},
			{
				name: 'leftPosteriorPillarSubjective',
				// % protected region % [Set displayName for Left Posterior Pillar Subjective here] off begin
				displayName: 'Left Posterior Pillar Subjective',
				// % protected region % [Set displayName for Left Posterior Pillar Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Posterior Pillar Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Posterior Pillar Subjective here] end
				// % protected region % [Set isSensitive for Left Posterior Pillar Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Posterior Pillar Subjective here] end
				// % protected region % [Set readonly for Left Posterior Pillar Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Posterior Pillar Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Posterior Pillar Subjective here] off begin
					// % protected region % [Add other validators for Left Posterior Pillar Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Posterior Pillar Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Posterior Pillar Subjective here] end
			},
			{
				name: 'leftPosteriorPillarObjective',
				// % protected region % [Set displayName for Left Posterior Pillar Objective here] off begin
				displayName: 'Left Posterior Pillar Objective',
				// % protected region % [Set displayName for Left Posterior Pillar Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Posterior Pillar Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Posterior Pillar Objective here] end
				// % protected region % [Set isSensitive for Left Posterior Pillar Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Posterior Pillar Objective here] end
				// % protected region % [Set readonly for Left Posterior Pillar Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Posterior Pillar Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Posterior Pillar Objective here] off begin
					// % protected region % [Add other validators for Left Posterior Pillar Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Posterior Pillar Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Posterior Pillar Objective here] end
			},
			{
				name: 'leftTonsilSubjective',
				// % protected region % [Set displayName for Left Tonsil Subjective here] off begin
				displayName: 'Left Tonsil Subjective',
				// % protected region % [Set displayName for Left Tonsil Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Tonsil Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Tonsil Subjective here] end
				// % protected region % [Set isSensitive for Left Tonsil Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Tonsil Subjective here] end
				// % protected region % [Set readonly for Left Tonsil Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Tonsil Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Tonsil Subjective here] off begin
					// % protected region % [Add other validators for Left Tonsil Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Tonsil Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Tonsil Subjective here] end
			},
			{
				name: 'leftTonsilObjective',
				// % protected region % [Set displayName for Left Tonsil Objective here] off begin
				displayName: 'Left Tonsil Objective',
				// % protected region % [Set displayName for Left Tonsil Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Tonsil Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Tonsil Objective here] end
				// % protected region % [Set isSensitive for Left Tonsil Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Tonsil Objective here] end
				// % protected region % [Set readonly for Left Tonsil Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Tonsil Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Tonsil Objective here] off begin
					// % protected region % [Add other validators for Left Tonsil Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Tonsil Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Tonsil Objective here] end
			},
			{
				name: 'leftPosteriorWallSubjective',
				// % protected region % [Set displayName for Left Posterior Wall Subjective here] off begin
				displayName: 'Left Posterior Wall Subjective',
				// % protected region % [Set displayName for Left Posterior Wall Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Posterior Wall Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Posterior Wall Subjective here] end
				// % protected region % [Set isSensitive for Left Posterior Wall Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Posterior Wall Subjective here] end
				// % protected region % [Set readonly for Left Posterior Wall Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Posterior Wall Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Posterior Wall Subjective here] off begin
					// % protected region % [Add other validators for Left Posterior Wall Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Posterior Wall Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Posterior Wall Subjective here] end
			},
			{
				name: 'leftPosteriorWallObjective',
				// % protected region % [Set displayName for Left Posterior Wall Objective here] off begin
				displayName: 'Left Posterior Wall Objective',
				// % protected region % [Set displayName for Left Posterior Wall Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Posterior Wall Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Posterior Wall Objective here] end
				// % protected region % [Set isSensitive for Left Posterior Wall Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Posterior Wall Objective here] end
				// % protected region % [Set readonly for Left Posterior Wall Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Posterior Wall Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Posterior Wall Objective here] off begin
					// % protected region % [Add other validators for Left Posterior Wall Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Posterior Wall Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Posterior Wall Objective here] end
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
	static deepParse(data: string | { [K in keyof EntExaminationModel]?: EntExaminationModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new EntExaminationModel(data);
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
	 * `let entExaminationModel = new EntExaminationModel(data);`
	 *
	 * @param data The input data to be initialised as the EntExaminationModel,
	 *    it is expected as a JSON string or as a nullable EntExaminationModel.
	 */
	constructor(data?: string | Partial<EntExaminationModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<EntExaminationModel>
				: data;

			this.rightExternalEarSubjective = json.rightExternalEarSubjective;
			this.rightExternalEarObjective = json.rightExternalEarObjective;
			this.rightConchaSubjective = json.rightConchaSubjective;
			this.rightConchaObjective = json.rightConchaObjective;
			this.rightEarlobeSubjective = json.rightEarlobeSubjective;
			this.rightEarlobeObjective = json.rightEarlobeObjective;
			this.rightEarCanalSubjective = json.rightEarCanalSubjective;
			this.rightEarCanalObjective = json.rightEarCanalObjective;
			this.rightEardrumSubjective = json.rightEardrumSubjective;
			this.rightEardrumObjective = json.rightEardrumObjective;
			this.leftExternalEarSubjective = json.leftExternalEarSubjective;
			this.leftExternalEarObjective = json.leftExternalEarObjective;
			this.leftConchaSubjective = json.leftConchaSubjective;
			this.leftConchaObjective = json.leftConchaObjective;
			this.leftEarlobeSubjective = json.leftEarlobeSubjective;
			this.leftEarlobeObjective = json.leftEarlobeObjective;
			this.leftEarCanalSubjective = json.leftEarCanalSubjective;
			this.leftEarCanalObjective = json.leftEarCanalObjective;
			this.leftEardrumSubjective = json.leftEardrumSubjective;
			this.leftEardrumObjective = json.leftEardrumObjective;
			this.nasalBoneSubjective = json.nasalBoneSubjective;
			this.nasalBoneObjective = json.nasalBoneObjective;
			this.rightFrontalSinusSubjective = json.rightFrontalSinusSubjective;
			this.rightFrontalSinusObjective = json.rightFrontalSinusObjective;
			this.rightEthmoidSinusSubjective = json.rightEthmoidSinusSubjective;
			this.rightEthmoidSinusObjective = json.rightEthmoidSinusObjective;
			this.rightSuperiorTurbinateSubjective = json.rightSuperiorTurbinateSubjective;
			this.rightSuperiorTurbinateObjective = json.rightSuperiorTurbinateObjective;
			this.rightMiddleTurbinateSubjective = json.rightMiddleTurbinateSubjective;
			this.rightMiddleTurbinateObjective = json.rightMiddleTurbinateObjective;
			this.rightMaxillarySinusSubjective = json.rightMaxillarySinusSubjective;
			this.rightMaxillarySinusObjective = json.rightMaxillarySinusObjective;
			this.rightNasalCavitySubjective = json.rightNasalCavitySubjective;
			this.rightNasalCavityObjective = json.rightNasalCavityObjective;
			this.rightInferiorTurbinateSubjective = json.rightInferiorTurbinateSubjective;
			this.rightInferiorTurbinateObjective = json.rightInferiorTurbinateObjective;
			this.leftFrontalSinusSubjective = json.leftFrontalSinusSubjective;
			this.leftFrontalSinusObjective = json.leftFrontalSinusObjective;
			this.leftEthmoidSinusSubjective = json.leftEthmoidSinusSubjective;
			this.leftEthmoidSinusObjective = json.leftEthmoidSinusObjective;
			this.leftSuperiorTurbinateSubjective = json.leftSuperiorTurbinateSubjective;
			this.leftSuperiorTurbinateObjective = json.leftSuperiorTurbinateObjective;
			this.leftMiddleTurbinateSubjective = json.leftMiddleTurbinateSubjective;
			this.leftMiddleTurbinateObjective = json.leftMiddleTurbinateObjective;
			this.leftMaxillarySinusSubjective = json.leftMaxillarySinusSubjective;
			this.leftMaxillarySinusObjective = json.leftMaxillarySinusObjective;
			this.leftNasalCavitySubjective = json.leftNasalCavitySubjective;
			this.leftNasalCavityObjective = json.leftNasalCavityObjective;
			this.leftInferiorTurbinateSubjective = json.leftInferiorTurbinateSubjective;
			this.leftInferiorTurbinateObjective = json.leftInferiorTurbinateObjective;
			this.lingualTonsilSubjective = json.lingualTonsilSubjective;
			this.lingualTonsilObjective = json.lingualTonsilObjective;
			this.epiglottisSubjective = json.epiglottisSubjective;
			this.epiglottisObjective = json.epiglottisObjective;
			this.rightVocalFoldSubjective = json.rightVocalFoldSubjective;
			this.rightVocalFoldObjective = json.rightVocalFoldObjective;
			this.rightVentricularFoldSubjective = json.rightVentricularFoldSubjective;
			this.rightVentricularFoldObjective = json.rightVentricularFoldObjective;
			this.glottisSubjective = json.glottisSubjective;
			this.glottisObjective = json.glottisObjective;
			this.rightCuneiformCartilageSubjective = json.rightCuneiformCartilageSubjective;
			this.rightCuneiformCartilageObjective = json.rightCuneiformCartilageObjective;
			this.rightCorniculateCartilageSubjective = json.rightCorniculateCartilageSubjective;
			this.rightCorniculateCartilageObjective = json.rightCorniculateCartilageObjective;
			this.tracheaSubjective = json.tracheaSubjective;
			this.tracheaObjective = json.tracheaObjective;
			this.leftVocalFoldSubjective = json.leftVocalFoldSubjective;
			this.leftVocalFoldObjective = json.leftVocalFoldObjective;
			this.leftVentricularFoldSubjective = json.leftVentricularFoldSubjective;
			this.leftVentricularFoldObjective = json.leftVentricularFoldObjective;
			this.leftCuneiformCartilageSubjective = json.leftCuneiformCartilageSubjective;
			this.leftCuneiformCartilageObjective = json.leftCuneiformCartilageObjective;
			this.leftCorniculateCartilageSubjective = json.leftCorniculateCartilageSubjective;
			this.leftCorniculateCartilageObjective = json.leftCorniculateCartilageObjective;
			this.softPalateSubjective = json.softPalateSubjective;
			this.softPalateObjective = json.softPalateObjective;
			this.rightAnteriorPillarSubjective = json.rightAnteriorPillarSubjective;
			this.rightAnteriorPillarObjective = json.rightAnteriorPillarObjective;
			this.uvulaSubjective = json.uvulaSubjective;
			this.uvulaObjective = json.uvulaObjective;
			this.rightPosteriorPillarSubjective = json.rightPosteriorPillarSubjective;
			this.rightPosteriorPillarObjective = json.rightPosteriorPillarObjective;
			this.rightTonsilSubjective = json.rightTonsilSubjective;
			this.rightTonsilObjective = json.rightTonsilObjective;
			this.rightPosteriorSubjective = json.rightPosteriorSubjective;
			this.rightPosteriorObjective = json.rightPosteriorObjective;
			this.upperTongueSubjective = json.upperTongueSubjective;
			this.upperTongueObjective = json.upperTongueObjective;
			this.leftAnteriorPillarSubjective = json.leftAnteriorPillarSubjective;
			this.leftAnteriorPillarObjective = json.leftAnteriorPillarObjective;
			this.leftPosteriorPillarSubjective = json.leftPosteriorPillarSubjective;
			this.leftPosteriorPillarObjective = json.leftPosteriorPillarObjective;
			this.leftTonsilSubjective = json.leftTonsilSubjective;
			this.leftTonsilObjective = json.leftTonsilObjective;
			this.leftPosteriorWallSubjective = json.leftPosteriorWallSubjective;
			this.leftPosteriorWallObjective = json.leftPosteriorWallObjective;
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
			rightExternalEarSubjective: this.rightExternalEarSubjective,
			rightExternalEarObjective: this.rightExternalEarObjective,
			rightConchaSubjective: this.rightConchaSubjective,
			rightConchaObjective: this.rightConchaObjective,
			rightEarlobeSubjective: this.rightEarlobeSubjective,
			rightEarlobeObjective: this.rightEarlobeObjective,
			rightEarCanalSubjective: this.rightEarCanalSubjective,
			rightEarCanalObjective: this.rightEarCanalObjective,
			rightEardrumSubjective: this.rightEardrumSubjective,
			rightEardrumObjective: this.rightEardrumObjective,
			leftExternalEarSubjective: this.leftExternalEarSubjective,
			leftExternalEarObjective: this.leftExternalEarObjective,
			leftConchaSubjective: this.leftConchaSubjective,
			leftConchaObjective: this.leftConchaObjective,
			leftEarlobeSubjective: this.leftEarlobeSubjective,
			leftEarlobeObjective: this.leftEarlobeObjective,
			leftEarCanalSubjective: this.leftEarCanalSubjective,
			leftEarCanalObjective: this.leftEarCanalObjective,
			leftEardrumSubjective: this.leftEardrumSubjective,
			leftEardrumObjective: this.leftEardrumObjective,
			nasalBoneSubjective: this.nasalBoneSubjective,
			nasalBoneObjective: this.nasalBoneObjective,
			rightFrontalSinusSubjective: this.rightFrontalSinusSubjective,
			rightFrontalSinusObjective: this.rightFrontalSinusObjective,
			rightEthmoidSinusSubjective: this.rightEthmoidSinusSubjective,
			rightEthmoidSinusObjective: this.rightEthmoidSinusObjective,
			rightSuperiorTurbinateSubjective: this.rightSuperiorTurbinateSubjective,
			rightSuperiorTurbinateObjective: this.rightSuperiorTurbinateObjective,
			rightMiddleTurbinateSubjective: this.rightMiddleTurbinateSubjective,
			rightMiddleTurbinateObjective: this.rightMiddleTurbinateObjective,
			rightMaxillarySinusSubjective: this.rightMaxillarySinusSubjective,
			rightMaxillarySinusObjective: this.rightMaxillarySinusObjective,
			rightNasalCavitySubjective: this.rightNasalCavitySubjective,
			rightNasalCavityObjective: this.rightNasalCavityObjective,
			rightInferiorTurbinateSubjective: this.rightInferiorTurbinateSubjective,
			rightInferiorTurbinateObjective: this.rightInferiorTurbinateObjective,
			leftFrontalSinusSubjective: this.leftFrontalSinusSubjective,
			leftFrontalSinusObjective: this.leftFrontalSinusObjective,
			leftEthmoidSinusSubjective: this.leftEthmoidSinusSubjective,
			leftEthmoidSinusObjective: this.leftEthmoidSinusObjective,
			leftSuperiorTurbinateSubjective: this.leftSuperiorTurbinateSubjective,
			leftSuperiorTurbinateObjective: this.leftSuperiorTurbinateObjective,
			leftMiddleTurbinateSubjective: this.leftMiddleTurbinateSubjective,
			leftMiddleTurbinateObjective: this.leftMiddleTurbinateObjective,
			leftMaxillarySinusSubjective: this.leftMaxillarySinusSubjective,
			leftMaxillarySinusObjective: this.leftMaxillarySinusObjective,
			leftNasalCavitySubjective: this.leftNasalCavitySubjective,
			leftNasalCavityObjective: this.leftNasalCavityObjective,
			leftInferiorTurbinateSubjective: this.leftInferiorTurbinateSubjective,
			leftInferiorTurbinateObjective: this.leftInferiorTurbinateObjective,
			lingualTonsilSubjective: this.lingualTonsilSubjective,
			lingualTonsilObjective: this.lingualTonsilObjective,
			epiglottisSubjective: this.epiglottisSubjective,
			epiglottisObjective: this.epiglottisObjective,
			rightVocalFoldSubjective: this.rightVocalFoldSubjective,
			rightVocalFoldObjective: this.rightVocalFoldObjective,
			rightVentricularFoldSubjective: this.rightVentricularFoldSubjective,
			rightVentricularFoldObjective: this.rightVentricularFoldObjective,
			glottisSubjective: this.glottisSubjective,
			glottisObjective: this.glottisObjective,
			rightCuneiformCartilageSubjective: this.rightCuneiformCartilageSubjective,
			rightCuneiformCartilageObjective: this.rightCuneiformCartilageObjective,
			rightCorniculateCartilageSubjective: this.rightCorniculateCartilageSubjective,
			rightCorniculateCartilageObjective: this.rightCorniculateCartilageObjective,
			tracheaSubjective: this.tracheaSubjective,
			tracheaObjective: this.tracheaObjective,
			leftVocalFoldSubjective: this.leftVocalFoldSubjective,
			leftVocalFoldObjective: this.leftVocalFoldObjective,
			leftVentricularFoldSubjective: this.leftVentricularFoldSubjective,
			leftVentricularFoldObjective: this.leftVentricularFoldObjective,
			leftCuneiformCartilageSubjective: this.leftCuneiformCartilageSubjective,
			leftCuneiformCartilageObjective: this.leftCuneiformCartilageObjective,
			leftCorniculateCartilageSubjective: this.leftCorniculateCartilageSubjective,
			leftCorniculateCartilageObjective: this.leftCorniculateCartilageObjective,
			softPalateSubjective: this.softPalateSubjective,
			softPalateObjective: this.softPalateObjective,
			rightAnteriorPillarSubjective: this.rightAnteriorPillarSubjective,
			rightAnteriorPillarObjective: this.rightAnteriorPillarObjective,
			uvulaSubjective: this.uvulaSubjective,
			uvulaObjective: this.uvulaObjective,
			rightPosteriorPillarSubjective: this.rightPosteriorPillarSubjective,
			rightPosteriorPillarObjective: this.rightPosteriorPillarObjective,
			rightTonsilSubjective: this.rightTonsilSubjective,
			rightTonsilObjective: this.rightTonsilObjective,
			rightPosteriorSubjective: this.rightPosteriorSubjective,
			rightPosteriorObjective: this.rightPosteriorObjective,
			upperTongueSubjective: this.upperTongueSubjective,
			upperTongueObjective: this.upperTongueObjective,
			leftAnteriorPillarSubjective: this.leftAnteriorPillarSubjective,
			leftAnteriorPillarObjective: this.leftAnteriorPillarObjective,
			leftPosteriorPillarSubjective: this.leftPosteriorPillarSubjective,
			leftPosteriorPillarObjective: this.leftPosteriorPillarObjective,
			leftTonsilSubjective: this.leftTonsilSubjective,
			leftTonsilObjective: this.leftTonsilObjective,
			leftPosteriorWallSubjective: this.leftPosteriorWallSubjective,
			leftPosteriorWallObjective: this.leftPosteriorWallObjective,
			medicalExaminationRecordId: this.medicalExaminationRecordId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		EntExaminationModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): EntExaminationModel {
		let newModelJson = this.toJSON();

		if (updates.rightExternalEarSubjective) {
			newModelJson.rightExternalEarSubjective = updates.rightExternalEarSubjective;
		}

		if (updates.rightExternalEarObjective) {
			newModelJson.rightExternalEarObjective = updates.rightExternalEarObjective;
		}

		if (updates.rightConchaSubjective) {
			newModelJson.rightConchaSubjective = updates.rightConchaSubjective;
		}

		if (updates.rightConchaObjective) {
			newModelJson.rightConchaObjective = updates.rightConchaObjective;
		}

		if (updates.rightEarlobeSubjective) {
			newModelJson.rightEarlobeSubjective = updates.rightEarlobeSubjective;
		}

		if (updates.rightEarlobeObjective) {
			newModelJson.rightEarlobeObjective = updates.rightEarlobeObjective;
		}

		if (updates.rightEarCanalSubjective) {
			newModelJson.rightEarCanalSubjective = updates.rightEarCanalSubjective;
		}

		if (updates.rightEarCanalObjective) {
			newModelJson.rightEarCanalObjective = updates.rightEarCanalObjective;
		}

		if (updates.rightEardrumSubjective) {
			newModelJson.rightEardrumSubjective = updates.rightEardrumSubjective;
		}

		if (updates.rightEardrumObjective) {
			newModelJson.rightEardrumObjective = updates.rightEardrumObjective;
		}

		if (updates.leftExternalEarSubjective) {
			newModelJson.leftExternalEarSubjective = updates.leftExternalEarSubjective;
		}

		if (updates.leftExternalEarObjective) {
			newModelJson.leftExternalEarObjective = updates.leftExternalEarObjective;
		}

		if (updates.leftConchaSubjective) {
			newModelJson.leftConchaSubjective = updates.leftConchaSubjective;
		}

		if (updates.leftConchaObjective) {
			newModelJson.leftConchaObjective = updates.leftConchaObjective;
		}

		if (updates.leftEarlobeSubjective) {
			newModelJson.leftEarlobeSubjective = updates.leftEarlobeSubjective;
		}

		if (updates.leftEarlobeObjective) {
			newModelJson.leftEarlobeObjective = updates.leftEarlobeObjective;
		}

		if (updates.leftEarCanalSubjective) {
			newModelJson.leftEarCanalSubjective = updates.leftEarCanalSubjective;
		}

		if (updates.leftEarCanalObjective) {
			newModelJson.leftEarCanalObjective = updates.leftEarCanalObjective;
		}

		if (updates.leftEardrumSubjective) {
			newModelJson.leftEardrumSubjective = updates.leftEardrumSubjective;
		}

		if (updates.leftEardrumObjective) {
			newModelJson.leftEardrumObjective = updates.leftEardrumObjective;
		}

		if (updates.nasalBoneSubjective) {
			newModelJson.nasalBoneSubjective = updates.nasalBoneSubjective;
		}

		if (updates.nasalBoneObjective) {
			newModelJson.nasalBoneObjective = updates.nasalBoneObjective;
		}

		if (updates.rightFrontalSinusSubjective) {
			newModelJson.rightFrontalSinusSubjective = updates.rightFrontalSinusSubjective;
		}

		if (updates.rightFrontalSinusObjective) {
			newModelJson.rightFrontalSinusObjective = updates.rightFrontalSinusObjective;
		}

		if (updates.rightEthmoidSinusSubjective) {
			newModelJson.rightEthmoidSinusSubjective = updates.rightEthmoidSinusSubjective;
		}

		if (updates.rightEthmoidSinusObjective) {
			newModelJson.rightEthmoidSinusObjective = updates.rightEthmoidSinusObjective;
		}

		if (updates.rightSuperiorTurbinateSubjective) {
			newModelJson.rightSuperiorTurbinateSubjective = updates.rightSuperiorTurbinateSubjective;
		}

		if (updates.rightSuperiorTurbinateObjective) {
			newModelJson.rightSuperiorTurbinateObjective = updates.rightSuperiorTurbinateObjective;
		}

		if (updates.rightMiddleTurbinateSubjective) {
			newModelJson.rightMiddleTurbinateSubjective = updates.rightMiddleTurbinateSubjective;
		}

		if (updates.rightMiddleTurbinateObjective) {
			newModelJson.rightMiddleTurbinateObjective = updates.rightMiddleTurbinateObjective;
		}

		if (updates.rightMaxillarySinusSubjective) {
			newModelJson.rightMaxillarySinusSubjective = updates.rightMaxillarySinusSubjective;
		}

		if (updates.rightMaxillarySinusObjective) {
			newModelJson.rightMaxillarySinusObjective = updates.rightMaxillarySinusObjective;
		}

		if (updates.rightNasalCavitySubjective) {
			newModelJson.rightNasalCavitySubjective = updates.rightNasalCavitySubjective;
		}

		if (updates.rightNasalCavityObjective) {
			newModelJson.rightNasalCavityObjective = updates.rightNasalCavityObjective;
		}

		if (updates.rightInferiorTurbinateSubjective) {
			newModelJson.rightInferiorTurbinateSubjective = updates.rightInferiorTurbinateSubjective;
		}

		if (updates.rightInferiorTurbinateObjective) {
			newModelJson.rightInferiorTurbinateObjective = updates.rightInferiorTurbinateObjective;
		}

		if (updates.leftFrontalSinusSubjective) {
			newModelJson.leftFrontalSinusSubjective = updates.leftFrontalSinusSubjective;
		}

		if (updates.leftFrontalSinusObjective) {
			newModelJson.leftFrontalSinusObjective = updates.leftFrontalSinusObjective;
		}

		if (updates.leftEthmoidSinusSubjective) {
			newModelJson.leftEthmoidSinusSubjective = updates.leftEthmoidSinusSubjective;
		}

		if (updates.leftEthmoidSinusObjective) {
			newModelJson.leftEthmoidSinusObjective = updates.leftEthmoidSinusObjective;
		}

		if (updates.leftSuperiorTurbinateSubjective) {
			newModelJson.leftSuperiorTurbinateSubjective = updates.leftSuperiorTurbinateSubjective;
		}

		if (updates.leftSuperiorTurbinateObjective) {
			newModelJson.leftSuperiorTurbinateObjective = updates.leftSuperiorTurbinateObjective;
		}

		if (updates.leftMiddleTurbinateSubjective) {
			newModelJson.leftMiddleTurbinateSubjective = updates.leftMiddleTurbinateSubjective;
		}

		if (updates.leftMiddleTurbinateObjective) {
			newModelJson.leftMiddleTurbinateObjective = updates.leftMiddleTurbinateObjective;
		}

		if (updates.leftMaxillarySinusSubjective) {
			newModelJson.leftMaxillarySinusSubjective = updates.leftMaxillarySinusSubjective;
		}

		if (updates.leftMaxillarySinusObjective) {
			newModelJson.leftMaxillarySinusObjective = updates.leftMaxillarySinusObjective;
		}

		if (updates.leftNasalCavitySubjective) {
			newModelJson.leftNasalCavitySubjective = updates.leftNasalCavitySubjective;
		}

		if (updates.leftNasalCavityObjective) {
			newModelJson.leftNasalCavityObjective = updates.leftNasalCavityObjective;
		}

		if (updates.leftInferiorTurbinateSubjective) {
			newModelJson.leftInferiorTurbinateSubjective = updates.leftInferiorTurbinateSubjective;
		}

		if (updates.leftInferiorTurbinateObjective) {
			newModelJson.leftInferiorTurbinateObjective = updates.leftInferiorTurbinateObjective;
		}

		if (updates.lingualTonsilSubjective) {
			newModelJson.lingualTonsilSubjective = updates.lingualTonsilSubjective;
		}

		if (updates.lingualTonsilObjective) {
			newModelJson.lingualTonsilObjective = updates.lingualTonsilObjective;
		}

		if (updates.epiglottisSubjective) {
			newModelJson.epiglottisSubjective = updates.epiglottisSubjective;
		}

		if (updates.epiglottisObjective) {
			newModelJson.epiglottisObjective = updates.epiglottisObjective;
		}

		if (updates.rightVocalFoldSubjective) {
			newModelJson.rightVocalFoldSubjective = updates.rightVocalFoldSubjective;
		}

		if (updates.rightVocalFoldObjective) {
			newModelJson.rightVocalFoldObjective = updates.rightVocalFoldObjective;
		}

		if (updates.rightVentricularFoldSubjective) {
			newModelJson.rightVentricularFoldSubjective = updates.rightVentricularFoldSubjective;
		}

		if (updates.rightVentricularFoldObjective) {
			newModelJson.rightVentricularFoldObjective = updates.rightVentricularFoldObjective;
		}

		if (updates.glottisSubjective) {
			newModelJson.glottisSubjective = updates.glottisSubjective;
		}

		if (updates.glottisObjective) {
			newModelJson.glottisObjective = updates.glottisObjective;
		}

		if (updates.rightCuneiformCartilageSubjective) {
			newModelJson.rightCuneiformCartilageSubjective = updates.rightCuneiformCartilageSubjective;
		}

		if (updates.rightCuneiformCartilageObjective) {
			newModelJson.rightCuneiformCartilageObjective = updates.rightCuneiformCartilageObjective;
		}

		if (updates.rightCorniculateCartilageSubjective) {
			newModelJson.rightCorniculateCartilageSubjective = updates.rightCorniculateCartilageSubjective;
		}

		if (updates.rightCorniculateCartilageObjective) {
			newModelJson.rightCorniculateCartilageObjective = updates.rightCorniculateCartilageObjective;
		}

		if (updates.tracheaSubjective) {
			newModelJson.tracheaSubjective = updates.tracheaSubjective;
		}

		if (updates.tracheaObjective) {
			newModelJson.tracheaObjective = updates.tracheaObjective;
		}

		if (updates.leftVocalFoldSubjective) {
			newModelJson.leftVocalFoldSubjective = updates.leftVocalFoldSubjective;
		}

		if (updates.leftVocalFoldObjective) {
			newModelJson.leftVocalFoldObjective = updates.leftVocalFoldObjective;
		}

		if (updates.leftVentricularFoldSubjective) {
			newModelJson.leftVentricularFoldSubjective = updates.leftVentricularFoldSubjective;
		}

		if (updates.leftVentricularFoldObjective) {
			newModelJson.leftVentricularFoldObjective = updates.leftVentricularFoldObjective;
		}

		if (updates.leftCuneiformCartilageSubjective) {
			newModelJson.leftCuneiformCartilageSubjective = updates.leftCuneiformCartilageSubjective;
		}

		if (updates.leftCuneiformCartilageObjective) {
			newModelJson.leftCuneiformCartilageObjective = updates.leftCuneiformCartilageObjective;
		}

		if (updates.leftCorniculateCartilageSubjective) {
			newModelJson.leftCorniculateCartilageSubjective = updates.leftCorniculateCartilageSubjective;
		}

		if (updates.leftCorniculateCartilageObjective) {
			newModelJson.leftCorniculateCartilageObjective = updates.leftCorniculateCartilageObjective;
		}

		if (updates.softPalateSubjective) {
			newModelJson.softPalateSubjective = updates.softPalateSubjective;
		}

		if (updates.softPalateObjective) {
			newModelJson.softPalateObjective = updates.softPalateObjective;
		}

		if (updates.rightAnteriorPillarSubjective) {
			newModelJson.rightAnteriorPillarSubjective = updates.rightAnteriorPillarSubjective;
		}

		if (updates.rightAnteriorPillarObjective) {
			newModelJson.rightAnteriorPillarObjective = updates.rightAnteriorPillarObjective;
		}

		if (updates.uvulaSubjective) {
			newModelJson.uvulaSubjective = updates.uvulaSubjective;
		}

		if (updates.uvulaObjective) {
			newModelJson.uvulaObjective = updates.uvulaObjective;
		}

		if (updates.rightPosteriorPillarSubjective) {
			newModelJson.rightPosteriorPillarSubjective = updates.rightPosteriorPillarSubjective;
		}

		if (updates.rightPosteriorPillarObjective) {
			newModelJson.rightPosteriorPillarObjective = updates.rightPosteriorPillarObjective;
		}

		if (updates.rightTonsilSubjective) {
			newModelJson.rightTonsilSubjective = updates.rightTonsilSubjective;
		}

		if (updates.rightTonsilObjective) {
			newModelJson.rightTonsilObjective = updates.rightTonsilObjective;
		}

		if (updates.rightPosteriorSubjective) {
			newModelJson.rightPosteriorSubjective = updates.rightPosteriorSubjective;
		}

		if (updates.rightPosteriorObjective) {
			newModelJson.rightPosteriorObjective = updates.rightPosteriorObjective;
		}

		if (updates.upperTongueSubjective) {
			newModelJson.upperTongueSubjective = updates.upperTongueSubjective;
		}

		if (updates.upperTongueObjective) {
			newModelJson.upperTongueObjective = updates.upperTongueObjective;
		}

		if (updates.leftAnteriorPillarSubjective) {
			newModelJson.leftAnteriorPillarSubjective = updates.leftAnteriorPillarSubjective;
		}

		if (updates.leftAnteriorPillarObjective) {
			newModelJson.leftAnteriorPillarObjective = updates.leftAnteriorPillarObjective;
		}

		if (updates.leftPosteriorPillarSubjective) {
			newModelJson.leftPosteriorPillarSubjective = updates.leftPosteriorPillarSubjective;
		}

		if (updates.leftPosteriorPillarObjective) {
			newModelJson.leftPosteriorPillarObjective = updates.leftPosteriorPillarObjective;
		}

		if (updates.leftTonsilSubjective) {
			newModelJson.leftTonsilSubjective = updates.leftTonsilSubjective;
		}

		if (updates.leftTonsilObjective) {
			newModelJson.leftTonsilObjective = updates.leftTonsilObjective;
		}

		if (updates.leftPosteriorWallSubjective) {
			newModelJson.leftPosteriorWallSubjective = updates.leftPosteriorWallSubjective;
		}

		if (updates.leftPosteriorWallObjective) {
			newModelJson.leftPosteriorWallObjective = updates.leftPosteriorWallObjective;
		}

		if (updates.medicalExaminationRecordId) {
			newModelJson.medicalExaminationRecordId = updates.medicalExaminationRecordId;
		}

		return new EntExaminationModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof EntExaminationModel)) {
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
