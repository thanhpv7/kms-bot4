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
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsSearchControlLetterModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'controlLetterNo',
		'controlPlanDate',
		'date',
		'controlType',
		'polyclinic',
		'doctor',
		'sepNo',
		'bpjsCardNo',
		'polyclinicDestination',
		'doctorDestination',
		'polyclinicSource',
		'doctorSource',
		'sepDate',
		'treatmentType',
		'treatmentClass',
		'name',
		'gender',
		'dateOfBirth',
		'provider',
		'referralProvider',
		'referralSource',
		'referralNo',
		'referralDate',
		'diagnose',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'controlLetterNo',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsSearchControlLetterModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsSearchControlLetterModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	controlLetterNo: string;

	/**
	 * .
	 */
	controlPlanDate: string;

	/**
	 * .
	 */
	date: string;

	/**
	 * .
	 */
	controlType: string;

	/**
	 * .
	 */
	polyclinic: string;

	/**
	 * .
	 */
	doctor: string;

	/**
	 * .
	 */
	sepNo: string;

	/**
	 * .
	 */
	bpjsCardNo: string;

	/**
	 * .
	 */
	polyclinicDestination: string;

	/**
	 * .
	 */
	doctorDestination: string;

	/**
	 * .
	 */
	polyclinicSource: string;

	/**
	 * .
	 */
	doctorSource: string;

	/**
	 * .
	 */
	sepDate: string;

	/**
	 * .
	 */
	treatmentType: string;

	/**
	 * .
	 */
	treatmentClass: string;

	/**
	 * .
	 */
	name: string;

	/**
	 * .
	 */
	gender: string;

	/**
	 * .
	 */
	dateOfBirth: string;

	/**
	 * .
	 */
	provider: string;

	/**
	 * .
	 */
	referralProvider: string;

	/**
	 * .
	 */
	referralSource: string;

	/**
	 * .
	 */
	referralNo: string;

	/**
	 * .
	 */
	referralDate: string;

	/**
	 * .
	 */
	diagnose: string;



	modelPropGroups: { [s: string]: Group } = BpjsSearchControlLetterModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'controlLetterNo',
				// % protected region % [Set displayName for Control Letter No here] off begin
				displayName: 'Control Letter No',
				// % protected region % [Set displayName for Control Letter No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Control Letter No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Control Letter No here] end
				// % protected region % [Set isSensitive for Control Letter No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Control Letter No here] end
				// % protected region % [Set readonly for Control Letter No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Control Letter No here] end
				validators: [
					// % protected region % [Add other validators for Control Letter No here] off begin
					// % protected region % [Add other validators for Control Letter No here] end
				],
				// % protected region % [Add any additional model attribute properties for Control Letter No here] off begin
				// % protected region % [Add any additional model attribute properties for Control Letter No here] end
			},
			{
				name: 'controlPlanDate',
				// % protected region % [Set displayName for Control Plan Date here] off begin
				displayName: 'Control Plan Date',
				// % protected region % [Set displayName for Control Plan Date here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Control Plan Date here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Control Plan Date here] end
				// % protected region % [Set isSensitive for Control Plan Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Control Plan Date here] end
				// % protected region % [Set readonly for Control Plan Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Control Plan Date here] end
				validators: [
					// % protected region % [Add other validators for Control Plan Date here] off begin
					// % protected region % [Add other validators for Control Plan Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Control Plan Date here] off begin
				// % protected region % [Add any additional model attribute properties for Control Plan Date here] end
			},
			{
				name: 'date',
				// % protected region % [Set displayName for Date here] off begin
				displayName: 'Date',
				// % protected region % [Set displayName for Date here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Date here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Date here] end
				// % protected region % [Set isSensitive for Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Date here] end
				// % protected region % [Set readonly for Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Date here] end
				validators: [
					// % protected region % [Add other validators for Date here] off begin
					// % protected region % [Add other validators for Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Date here] off begin
				// % protected region % [Add any additional model attribute properties for Date here] end
			},
			{
				name: 'controlType',
				// % protected region % [Set displayName for Control Type here] off begin
				displayName: 'Control Type',
				// % protected region % [Set displayName for Control Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Control Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Control Type here] end
				// % protected region % [Set isSensitive for Control Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Control Type here] end
				// % protected region % [Set readonly for Control Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Control Type here] end
				validators: [
					// % protected region % [Add other validators for Control Type here] off begin
					// % protected region % [Add other validators for Control Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Control Type here] off begin
				// % protected region % [Add any additional model attribute properties for Control Type here] end
			},
			{
				name: 'polyclinic',
				// % protected region % [Set displayName for Polyclinic here] off begin
				displayName: 'Polyclinic',
				// % protected region % [Set displayName for Polyclinic here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Polyclinic here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Polyclinic here] end
				// % protected region % [Set isSensitive for Polyclinic here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Polyclinic here] end
				// % protected region % [Set readonly for Polyclinic here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Polyclinic here] end
				validators: [
					// % protected region % [Add other validators for Polyclinic here] off begin
					// % protected region % [Add other validators for Polyclinic here] end
				],
				// % protected region % [Add any additional model attribute properties for Polyclinic here] off begin
				// % protected region % [Add any additional model attribute properties for Polyclinic here] end
			},
			{
				name: 'doctor',
				// % protected region % [Set displayName for Doctor here] off begin
				displayName: 'Doctor',
				// % protected region % [Set displayName for Doctor here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor here] end
				// % protected region % [Set isSensitive for Doctor here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor here] end
				// % protected region % [Set readonly for Doctor here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor here] end
				validators: [
					// % protected region % [Add other validators for Doctor here] off begin
					// % protected region % [Add other validators for Doctor here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor here] end
			},
			{
				name: 'sepNo',
				// % protected region % [Set displayName for SEP No here] off begin
				displayName: 'SEP No',
				// % protected region % [Set displayName for SEP No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for SEP No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for SEP No here] end
				// % protected region % [Set isSensitive for SEP No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for SEP No here] end
				// % protected region % [Set readonly for SEP No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for SEP No here] end
				validators: [
					// % protected region % [Add other validators for SEP No here] off begin
					// % protected region % [Add other validators for SEP No here] end
				],
				// % protected region % [Add any additional model attribute properties for SEP No here] off begin
				// % protected region % [Add any additional model attribute properties for SEP No here] end
			},
			{
				name: 'bpjsCardNo',
				// % protected region % [Set displayName for BPJS Card No here] off begin
				displayName: 'BPJS Card No',
				// % protected region % [Set displayName for BPJS Card No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BPJS Card No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BPJS Card No here] end
				// % protected region % [Set isSensitive for BPJS Card No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BPJS Card No here] end
				// % protected region % [Set readonly for BPJS Card No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BPJS Card No here] end
				validators: [
					// % protected region % [Add other validators for BPJS Card No here] off begin
					// % protected region % [Add other validators for BPJS Card No here] end
				],
				// % protected region % [Add any additional model attribute properties for BPJS Card No here] off begin
				// % protected region % [Add any additional model attribute properties for BPJS Card No here] end
			},
			{
				name: 'polyclinicDestination',
				// % protected region % [Set displayName for Polyclinic Destination here] off begin
				displayName: 'Polyclinic Destination',
				// % protected region % [Set displayName for Polyclinic Destination here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Polyclinic Destination here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Polyclinic Destination here] end
				// % protected region % [Set isSensitive for Polyclinic Destination here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Polyclinic Destination here] end
				// % protected region % [Set readonly for Polyclinic Destination here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Polyclinic Destination here] end
				validators: [
					// % protected region % [Add other validators for Polyclinic Destination here] off begin
					// % protected region % [Add other validators for Polyclinic Destination here] end
				],
				// % protected region % [Add any additional model attribute properties for Polyclinic Destination here] off begin
				// % protected region % [Add any additional model attribute properties for Polyclinic Destination here] end
			},
			{
				name: 'doctorDestination',
				// % protected region % [Set displayName for Doctor Destination here] off begin
				displayName: 'Doctor Destination',
				// % protected region % [Set displayName for Doctor Destination here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor Destination here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor Destination here] end
				// % protected region % [Set isSensitive for Doctor Destination here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor Destination here] end
				// % protected region % [Set readonly for Doctor Destination here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor Destination here] end
				validators: [
					// % protected region % [Add other validators for Doctor Destination here] off begin
					// % protected region % [Add other validators for Doctor Destination here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor Destination here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor Destination here] end
			},
			{
				name: 'polyclinicSource',
				// % protected region % [Set displayName for Polyclinic Source here] off begin
				displayName: 'Polyclinic Source',
				// % protected region % [Set displayName for Polyclinic Source here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Polyclinic Source here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Polyclinic Source here] end
				// % protected region % [Set isSensitive for Polyclinic Source here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Polyclinic Source here] end
				// % protected region % [Set readonly for Polyclinic Source here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Polyclinic Source here] end
				validators: [
					// % protected region % [Add other validators for Polyclinic Source here] off begin
					// % protected region % [Add other validators for Polyclinic Source here] end
				],
				// % protected region % [Add any additional model attribute properties for Polyclinic Source here] off begin
				// % protected region % [Add any additional model attribute properties for Polyclinic Source here] end
			},
			{
				name: 'doctorSource',
				// % protected region % [Set displayName for Doctor Source here] off begin
				displayName: 'Doctor Source',
				// % protected region % [Set displayName for Doctor Source here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor Source here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor Source here] end
				// % protected region % [Set isSensitive for Doctor Source here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor Source here] end
				// % protected region % [Set readonly for Doctor Source here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor Source here] end
				validators: [
					// % protected region % [Add other validators for Doctor Source here] off begin
					// % protected region % [Add other validators for Doctor Source here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor Source here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor Source here] end
			},
			{
				name: 'sepDate',
				// % protected region % [Set displayName for SEP Date here] off begin
				displayName: 'SEP Date',
				// % protected region % [Set displayName for SEP Date here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for SEP Date here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for SEP Date here] end
				// % protected region % [Set isSensitive for SEP Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for SEP Date here] end
				// % protected region % [Set readonly for SEP Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for SEP Date here] end
				validators: [
					// % protected region % [Add other validators for SEP Date here] off begin
					// % protected region % [Add other validators for SEP Date here] end
				],
				// % protected region % [Add any additional model attribute properties for SEP Date here] off begin
				// % protected region % [Add any additional model attribute properties for SEP Date here] end
			},
			{
				name: 'treatmentType',
				// % protected region % [Set displayName for Treatment Type here] off begin
				displayName: 'Treatment Type',
				// % protected region % [Set displayName for Treatment Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Treatment Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Treatment Type here] end
				// % protected region % [Set isSensitive for Treatment Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Treatment Type here] end
				// % protected region % [Set readonly for Treatment Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Treatment Type here] end
				validators: [
					// % protected region % [Add other validators for Treatment Type here] off begin
					// % protected region % [Add other validators for Treatment Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Treatment Type here] off begin
				// % protected region % [Add any additional model attribute properties for Treatment Type here] end
			},
			{
				name: 'treatmentClass',
				// % protected region % [Set displayName for Treatment Class here] off begin
				displayName: 'Treatment Class',
				// % protected region % [Set displayName for Treatment Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Treatment Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Treatment Class here] end
				// % protected region % [Set isSensitive for Treatment Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Treatment Class here] end
				// % protected region % [Set readonly for Treatment Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Treatment Class here] end
				validators: [
					// % protected region % [Add other validators for Treatment Class here] off begin
					// % protected region % [Add other validators for Treatment Class here] end
				],
				// % protected region % [Add any additional model attribute properties for Treatment Class here] off begin
				// % protected region % [Add any additional model attribute properties for Treatment Class here] end
			},
			{
				name: 'name',
				// % protected region % [Set displayName for Name here] off begin
				displayName: 'Name',
				// % protected region % [Set displayName for Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Name here] end
				// % protected region % [Set isSensitive for Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Name here] end
				// % protected region % [Set readonly for Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Name here] end
				validators: [
					// % protected region % [Add other validators for Name here] off begin
					// % protected region % [Add other validators for Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Name here] off begin
				// % protected region % [Add any additional model attribute properties for Name here] end
			},
			{
				name: 'gender',
				// % protected region % [Set displayName for Gender here] off begin
				displayName: 'Gender',
				// % protected region % [Set displayName for Gender here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Gender here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Gender here] end
				// % protected region % [Set isSensitive for Gender here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gender here] end
				// % protected region % [Set readonly for Gender here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gender here] end
				validators: [
					// % protected region % [Add other validators for Gender here] off begin
					// % protected region % [Add other validators for Gender here] end
				],
				// % protected region % [Add any additional model attribute properties for Gender here] off begin
				// % protected region % [Add any additional model attribute properties for Gender here] end
			},
			{
				name: 'dateOfBirth',
				// % protected region % [Set displayName for Date of Birth here] off begin
				displayName: 'Date of Birth',
				// % protected region % [Set displayName for Date of Birth here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Date of Birth here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Date of Birth here] end
				// % protected region % [Set isSensitive for Date of Birth here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Date of Birth here] end
				// % protected region % [Set readonly for Date of Birth here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Date of Birth here] end
				validators: [
					// % protected region % [Add other validators for Date of Birth here] off begin
					// % protected region % [Add other validators for Date of Birth here] end
				],
				// % protected region % [Add any additional model attribute properties for Date of Birth here] off begin
				// % protected region % [Add any additional model attribute properties for Date of Birth here] end
			},
			{
				name: 'provider',
				// % protected region % [Set displayName for Provider here] off begin
				displayName: 'Provider',
				// % protected region % [Set displayName for Provider here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Provider here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Provider here] end
				// % protected region % [Set isSensitive for Provider here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Provider here] end
				// % protected region % [Set readonly for Provider here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Provider here] end
				validators: [
					// % protected region % [Add other validators for Provider here] off begin
					// % protected region % [Add other validators for Provider here] end
				],
				// % protected region % [Add any additional model attribute properties for Provider here] off begin
				// % protected region % [Add any additional model attribute properties for Provider here] end
			},
			{
				name: 'referralProvider',
				// % protected region % [Set displayName for Referral Provider here] off begin
				displayName: 'Referral Provider',
				// % protected region % [Set displayName for Referral Provider here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referral Provider here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referral Provider here] end
				// % protected region % [Set isSensitive for Referral Provider here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referral Provider here] end
				// % protected region % [Set readonly for Referral Provider here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referral Provider here] end
				validators: [
					// % protected region % [Add other validators for Referral Provider here] off begin
					// % protected region % [Add other validators for Referral Provider here] end
				],
				// % protected region % [Add any additional model attribute properties for Referral Provider here] off begin
				// % protected region % [Add any additional model attribute properties for Referral Provider here] end
			},
			{
				name: 'referralSource',
				// % protected region % [Set displayName for Referral Source here] off begin
				displayName: 'Referral Source',
				// % protected region % [Set displayName for Referral Source here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referral Source here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referral Source here] end
				// % protected region % [Set isSensitive for Referral Source here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referral Source here] end
				// % protected region % [Set readonly for Referral Source here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referral Source here] end
				validators: [
					// % protected region % [Add other validators for Referral Source here] off begin
					// % protected region % [Add other validators for Referral Source here] end
				],
				// % protected region % [Add any additional model attribute properties for Referral Source here] off begin
				// % protected region % [Add any additional model attribute properties for Referral Source here] end
			},
			{
				name: 'referralNo',
				// % protected region % [Set displayName for Referral No here] off begin
				displayName: 'Referral No',
				// % protected region % [Set displayName for Referral No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referral No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referral No here] end
				// % protected region % [Set isSensitive for Referral No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referral No here] end
				// % protected region % [Set readonly for Referral No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referral No here] end
				validators: [
					// % protected region % [Add other validators for Referral No here] off begin
					// % protected region % [Add other validators for Referral No here] end
				],
				// % protected region % [Add any additional model attribute properties for Referral No here] off begin
				// % protected region % [Add any additional model attribute properties for Referral No here] end
			},
			{
				name: 'referralDate',
				// % protected region % [Set displayName for Referral Date here] off begin
				displayName: 'Referral Date',
				// % protected region % [Set displayName for Referral Date here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referral Date here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referral Date here] end
				// % protected region % [Set isSensitive for Referral Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referral Date here] end
				// % protected region % [Set readonly for Referral Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referral Date here] end
				validators: [
					// % protected region % [Add other validators for Referral Date here] off begin
					// % protected region % [Add other validators for Referral Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Referral Date here] off begin
				// % protected region % [Add any additional model attribute properties for Referral Date here] end
			},
			{
				name: 'diagnose',
				// % protected region % [Set displayName for Diagnose here] off begin
				displayName: 'Diagnose',
				// % protected region % [Set displayName for Diagnose here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Diagnose here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Diagnose here] end
				// % protected region % [Set isSensitive for Diagnose here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Diagnose here] end
				// % protected region % [Set readonly for Diagnose here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Diagnose here] end
				validators: [
					// % protected region % [Add other validators for Diagnose here] off begin
					// % protected region % [Add other validators for Diagnose here] end
				],
				// % protected region % [Add any additional model attribute properties for Diagnose here] off begin
				// % protected region % [Add any additional model attribute properties for Diagnose here] end
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
				case 'controlLetterNo':
					break;
				case 'controlPlanDate':
					break;
				case 'date':
					break;
				case 'controlType':
					break;
				case 'polyclinic':
					break;
				case 'doctor':
					break;
				case 'sepNo':
					break;
				case 'bpjsCardNo':
					break;
				case 'polyclinicDestination':
					break;
				case 'doctorDestination':
					break;
				case 'polyclinicSource':
					break;
				case 'doctorSource':
					break;
				case 'sepDate':
					break;
				case 'treatmentType':
					break;
				case 'treatmentClass':
					break;
				case 'name':
					break;
				case 'gender':
					break;
				case 'dateOfBirth':
					break;
				case 'provider':
					break;
				case 'referralProvider':
					break;
				case 'referralSource':
					break;
				case 'referralNo':
					break;
				case 'referralDate':
					break;
				case 'diagnose':
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
	static deepParse(data: string | { [K in keyof BpjsSearchControlLetterModel]?: BpjsSearchControlLetterModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsSearchControlLetterModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsSearchControlLetterModel = new BpjsSearchControlLetterModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsSearchControlLetterModel,
	 *    it is expected as a JSON string or as a nullable BpjsSearchControlLetterModel.
	 */
	constructor(data?: string | Partial<BpjsSearchControlLetterModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsSearchControlLetterModel>
				: data;

			this.controlLetterNo = json.controlLetterNo;
			this.controlPlanDate = json.controlPlanDate;
			this.date = json.date;
			this.controlType = json.controlType;
			this.polyclinic = json.polyclinic;
			this.doctor = json.doctor;
			this.sepNo = json.sepNo;
			this.bpjsCardNo = json.bpjsCardNo;
			this.polyclinicDestination = json.polyclinicDestination;
			this.doctorDestination = json.doctorDestination;
			this.polyclinicSource = json.polyclinicSource;
			this.doctorSource = json.doctorSource;
			this.sepDate = json.sepDate;
			this.treatmentType = json.treatmentType;
			this.treatmentClass = json.treatmentClass;
			this.name = json.name;
			this.gender = json.gender;
			this.dateOfBirth = json.dateOfBirth;
			this.provider = json.provider;
			this.referralProvider = json.referralProvider;
			this.referralSource = json.referralSource;
			this.referralNo = json.referralNo;
			this.referralDate = json.referralDate;
			this.diagnose = json.diagnose;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			controlLetterNo: this.controlLetterNo,
			controlPlanDate: this.controlPlanDate,
			date: this.date,
			controlType: this.controlType,
			polyclinic: this.polyclinic,
			doctor: this.doctor,
			sepNo: this.sepNo,
			bpjsCardNo: this.bpjsCardNo,
			polyclinicDestination: this.polyclinicDestination,
			doctorDestination: this.doctorDestination,
			polyclinicSource: this.polyclinicSource,
			doctorSource: this.doctorSource,
			sepDate: this.sepDate,
			treatmentType: this.treatmentType,
			treatmentClass: this.treatmentClass,
			name: this.name,
			gender: this.gender,
			dateOfBirth: this.dateOfBirth,
			provider: this.provider,
			referralProvider: this.referralProvider,
			referralSource: this.referralSource,
			referralNo: this.referralNo,
			referralDate: this.referralDate,
			diagnose: this.diagnose,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsSearchControlLetterModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsSearchControlLetterModel {
		let newModelJson = this.toJSON();

		if (updates.controlLetterNo) {
			newModelJson.controlLetterNo = updates.controlLetterNo;
		}

		if (updates.controlPlanDate) {
			newModelJson.controlPlanDate = updates.controlPlanDate;
		}

		if (updates.date) {
			newModelJson.date = updates.date;
		}

		if (updates.controlType) {
			newModelJson.controlType = updates.controlType;
		}

		if (updates.polyclinic) {
			newModelJson.polyclinic = updates.polyclinic;
		}

		if (updates.doctor) {
			newModelJson.doctor = updates.doctor;
		}

		if (updates.sepNo) {
			newModelJson.sepNo = updates.sepNo;
		}

		if (updates.bpjsCardNo) {
			newModelJson.bpjsCardNo = updates.bpjsCardNo;
		}

		if (updates.polyclinicDestination) {
			newModelJson.polyclinicDestination = updates.polyclinicDestination;
		}

		if (updates.doctorDestination) {
			newModelJson.doctorDestination = updates.doctorDestination;
		}

		if (updates.polyclinicSource) {
			newModelJson.polyclinicSource = updates.polyclinicSource;
		}

		if (updates.doctorSource) {
			newModelJson.doctorSource = updates.doctorSource;
		}

		if (updates.sepDate) {
			newModelJson.sepDate = updates.sepDate;
		}

		if (updates.treatmentType) {
			newModelJson.treatmentType = updates.treatmentType;
		}

		if (updates.treatmentClass) {
			newModelJson.treatmentClass = updates.treatmentClass;
		}

		if (updates.name) {
			newModelJson.name = updates.name;
		}

		if (updates.gender) {
			newModelJson.gender = updates.gender;
		}

		if (updates.dateOfBirth) {
			newModelJson.dateOfBirth = updates.dateOfBirth;
		}

		if (updates.provider) {
			newModelJson.provider = updates.provider;
		}

		if (updates.referralProvider) {
			newModelJson.referralProvider = updates.referralProvider;
		}

		if (updates.referralSource) {
			newModelJson.referralSource = updates.referralSource;
		}

		if (updates.referralNo) {
			newModelJson.referralNo = updates.referralNo;
		}

		if (updates.referralDate) {
			newModelJson.referralDate = updates.referralDate;
		}

		if (updates.diagnose) {
			newModelJson.diagnose = updates.diagnose;
		}

		return new BpjsSearchControlLetterModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsSearchControlLetterModel)) {
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
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
