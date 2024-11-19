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
export class BpjsClaimDataModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'inacbgCode',
		'inacbgName',
		'submittedTariff',
		'approval',
		'grouperTariff',
		'hospitalTariff',
		'topUp',
		'treatmentClass',
		'name',
		'bpjsCardNo',
		'patientID',
		'status',
		'dismissalDate',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'inacbgCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsClaimDataModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsClaimDataModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	inacbgCode: string;

	/**
	 * .
	 */
	inacbgName: string;

	/**
	 * .
	 */
	submittedTariff: string;

	/**
	 * .
	 */
	approval: string;

	/**
	 * .
	 */
	grouperTariff: string;

	/**
	 * .
	 */
	hospitalTariff: string;

	/**
	 * .
	 */
	topUp: string;

	/**
	 * .
	 */
	treatmentClass: string;

	/**
	 * .
	 */
	fpkNo: string;

	/**
	 * .
	 */
	sepNo: string;

	/**
	 * .
	 */
	name: string;

	/**
	 * .
	 */
	bpjsCardNo: string;

	/**
	 * .
	 */
	patientID: string;

	/**
	 * .
	 */
	polyclinic: string;

	/**
	 * .
	 */
	status: string;

	/**
	 * .
	 */
	dismissalDate: Date;

	/**
	 * .
	 */
	sepDate: Date;



	modelPropGroups: { [s: string]: Group } = BpjsClaimDataModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'inacbgCode',
				// % protected region % [Set displayName for INACBG Code here] off begin
				displayName: 'INACBG Code',
				// % protected region % [Set displayName for INACBG Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for INACBG Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for INACBG Code here] end
				// % protected region % [Set isSensitive for INACBG Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for INACBG Code here] end
				// % protected region % [Set readonly for INACBG Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for INACBG Code here] end
				validators: [
					// % protected region % [Add other validators for INACBG Code here] off begin
					// % protected region % [Add other validators for INACBG Code here] end
				],
				// % protected region % [Add any additional model attribute properties for INACBG Code here] off begin
				// % protected region % [Add any additional model attribute properties for INACBG Code here] end
			},
			{
				name: 'inacbgName',
				// % protected region % [Set displayName for INACBG Name here] off begin
				displayName: 'INACBG Name',
				// % protected region % [Set displayName for INACBG Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for INACBG Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for INACBG Name here] end
				// % protected region % [Set isSensitive for INACBG Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for INACBG Name here] end
				// % protected region % [Set readonly for INACBG Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for INACBG Name here] end
				validators: [
					// % protected region % [Add other validators for INACBG Name here] off begin
					// % protected region % [Add other validators for INACBG Name here] end
				],
				// % protected region % [Add any additional model attribute properties for INACBG Name here] off begin
				// % protected region % [Add any additional model attribute properties for INACBG Name here] end
			},
			{
				name: 'submittedTariff',
				// % protected region % [Set displayName for Submitted Tariff here] off begin
				displayName: 'Submitted Tariff',
				// % protected region % [Set displayName for Submitted Tariff here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Submitted Tariff here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Submitted Tariff here] end
				// % protected region % [Set isSensitive for Submitted Tariff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Submitted Tariff here] end
				// % protected region % [Set readonly for Submitted Tariff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Submitted Tariff here] end
				validators: [
					// % protected region % [Add other validators for Submitted Tariff here] off begin
					// % protected region % [Add other validators for Submitted Tariff here] end
				],
				// % protected region % [Add any additional model attribute properties for Submitted Tariff here] off begin
				// % protected region % [Add any additional model attribute properties for Submitted Tariff here] end
			},
			{
				name: 'approval',
				// % protected region % [Set displayName for Approval here] off begin
				displayName: 'Approval',
				// % protected region % [Set displayName for Approval here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Approval here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Approval here] end
				// % protected region % [Set isSensitive for Approval here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Approval here] end
				// % protected region % [Set readonly for Approval here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Approval here] end
				validators: [
					// % protected region % [Add other validators for Approval here] off begin
					// % protected region % [Add other validators for Approval here] end
				],
				// % protected region % [Add any additional model attribute properties for Approval here] off begin
				// % protected region % [Add any additional model attribute properties for Approval here] end
			},
			{
				name: 'grouperTariff',
				// % protected region % [Set displayName for Grouper Tariff here] off begin
				displayName: 'Grouper Tariff',
				// % protected region % [Set displayName for Grouper Tariff here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Grouper Tariff here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Grouper Tariff here] end
				// % protected region % [Set isSensitive for Grouper Tariff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Grouper Tariff here] end
				// % protected region % [Set readonly for Grouper Tariff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Grouper Tariff here] end
				validators: [
					// % protected region % [Add other validators for Grouper Tariff here] off begin
					// % protected region % [Add other validators for Grouper Tariff here] end
				],
				// % protected region % [Add any additional model attribute properties for Grouper Tariff here] off begin
				// % protected region % [Add any additional model attribute properties for Grouper Tariff here] end
			},
			{
				name: 'hospitalTariff',
				// % protected region % [Set displayName for Hospital Tariff here] off begin
				displayName: 'Hospital Tariff',
				// % protected region % [Set displayName for Hospital Tariff here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Tariff here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Tariff here] end
				// % protected region % [Set isSensitive for Hospital Tariff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Tariff here] end
				// % protected region % [Set readonly for Hospital Tariff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Tariff here] end
				validators: [
					// % protected region % [Add other validators for Hospital Tariff here] off begin
					// % protected region % [Add other validators for Hospital Tariff here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Tariff here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Tariff here] end
			},
			{
				name: 'topUp',
				// % protected region % [Set displayName for Top Up here] off begin
				displayName: 'Top Up',
				// % protected region % [Set displayName for Top Up here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Top Up here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Top Up here] end
				// % protected region % [Set isSensitive for Top Up here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Top Up here] end
				// % protected region % [Set readonly for Top Up here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Top Up here] end
				validators: [
					// % protected region % [Add other validators for Top Up here] off begin
					// % protected region % [Add other validators for Top Up here] end
				],
				// % protected region % [Add any additional model attribute properties for Top Up here] off begin
				// % protected region % [Add any additional model attribute properties for Top Up here] end
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
				name: 'fpkNo',
				// % protected region % [Set displayName for FPK No here] off begin
				displayName: 'FPK No',
				// % protected region % [Set displayName for FPK No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for FPK No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for FPK No here] end
				// % protected region % [Set isSensitive for FPK No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for FPK No here] end
				// % protected region % [Set readonly for FPK No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for FPK No here] end
				validators: [
					// % protected region % [Add other validators for FPK No here] off begin
					// % protected region % [Add other validators for FPK No here] end
				],
				// % protected region % [Add any additional model attribute properties for FPK No here] off begin
				// % protected region % [Add any additional model attribute properties for FPK No here] end
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
				name: 'patientID',
				// % protected region % [Set displayName for Patient ID here] off begin
				displayName: 'Patient ID',
				// % protected region % [Set displayName for Patient ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Patient ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Patient ID here] end
				// % protected region % [Set isSensitive for Patient ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient ID here] end
				// % protected region % [Set readonly for Patient ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient ID here] end
				validators: [
					// % protected region % [Add other validators for Patient ID here] off begin
					// % protected region % [Add other validators for Patient ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient ID here] off begin
				// % protected region % [Add any additional model attribute properties for Patient ID here] end
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
				name: 'status',
				// % protected region % [Set displayName for Status here] off begin
				displayName: 'Status',
				// % protected region % [Set displayName for Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Status here] end
				// % protected region % [Set isSensitive for Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Status here] end
				// % protected region % [Set readonly for Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Status here] end
				validators: [
					// % protected region % [Add other validators for Status here] off begin
					// % protected region % [Add other validators for Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Status here] off begin
				// % protected region % [Add any additional model attribute properties for Status here] end
			},
			{
				name: 'dismissalDate',
				// % protected region % [Set displayName for Dismissal Date here] off begin
				displayName: 'Dismissal Date',
				// % protected region % [Set displayName for Dismissal Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Dismissal Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Dismissal Date here] end
				// % protected region % [Set isSensitive for Dismissal Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dismissal Date here] end
				// % protected region % [Set readonly for Dismissal Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dismissal Date here] end
				validators: [
					// % protected region % [Add other validators for Dismissal Date here] off begin
					// % protected region % [Add other validators for Dismissal Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Dismissal Date here] off begin
				// % protected region % [Add any additional model attribute properties for Dismissal Date here] end
			},
			{
				name: 'sepDate',
				// % protected region % [Set displayName for SEP Date here] off begin
				displayName: 'SEP Date',
				// % protected region % [Set displayName for SEP Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for SEP Date here] off begin
				elementType: ElementType.DATE,
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
				case 'inacbgCode':
					break;
				case 'inacbgName':
					break;
				case 'submittedTariff':
					break;
				case 'approval':
					break;
				case 'grouperTariff':
					break;
				case 'hospitalTariff':
					break;
				case 'topUp':
					break;
				case 'treatmentClass':
					break;
				case 'name':
					break;
				case 'bpjsCardNo':
					break;
				case 'patientID':
					break;
				case 'status':
					break;
				case 'dismissalDate':
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
	static deepParse(data: string | { [K in keyof BpjsClaimDataModel]?: BpjsClaimDataModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsClaimDataModel(data);
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
	 * `let bpjsClaimDataModel = new BpjsClaimDataModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsClaimDataModel,
	 *    it is expected as a JSON string or as a nullable BpjsClaimDataModel.
	 */
	constructor(data?: string | Partial<BpjsClaimDataModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsClaimDataModel>
				: data;

			this.inacbgCode = json.inacbgCode;
			this.inacbgName = json.inacbgName;
			this.submittedTariff = json.submittedTariff;
			this.approval = json.approval;
			this.grouperTariff = json.grouperTariff;
			this.hospitalTariff = json.hospitalTariff;
			this.topUp = json.topUp;
			this.treatmentClass = json.treatmentClass;
			this.fpkNo = json.fpkNo;
			this.sepNo = json.sepNo;
			this.name = json.name;
			this.bpjsCardNo = json.bpjsCardNo;
			this.patientID = json.patientID;
			this.polyclinic = json.polyclinic;
			this.status = json.status;
			if (json.dismissalDate) {
				this.dismissalDate = new Date(json.dismissalDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.dismissalDate = json.dismissalDate;
			}
			if (json.sepDate) {
				this.sepDate = new Date(json.sepDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.sepDate = json.sepDate;
			}
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			inacbgCode: this.inacbgCode,
			inacbgName: this.inacbgName,
			submittedTariff: this.submittedTariff,
			approval: this.approval,
			grouperTariff: this.grouperTariff,
			hospitalTariff: this.hospitalTariff,
			topUp: this.topUp,
			treatmentClass: this.treatmentClass,
			fpkNo: this.fpkNo,
			sepNo: this.sepNo,
			name: this.name,
			bpjsCardNo: this.bpjsCardNo,
			patientID: this.patientID,
			polyclinic: this.polyclinic,
			status: this.status,
			dismissalDate: this.dismissalDate,
			sepDate: this.sepDate,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsClaimDataModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsClaimDataModel {
		let newModelJson = this.toJSON();

		if (updates.inacbgCode) {
			newModelJson.inacbgCode = updates.inacbgCode;
		}

		if (updates.inacbgName) {
			newModelJson.inacbgName = updates.inacbgName;
		}

		if (updates.submittedTariff) {
			newModelJson.submittedTariff = updates.submittedTariff;
		}

		if (updates.approval) {
			newModelJson.approval = updates.approval;
		}

		if (updates.grouperTariff) {
			newModelJson.grouperTariff = updates.grouperTariff;
		}

		if (updates.hospitalTariff) {
			newModelJson.hospitalTariff = updates.hospitalTariff;
		}

		if (updates.topUp) {
			newModelJson.topUp = updates.topUp;
		}

		if (updates.treatmentClass) {
			newModelJson.treatmentClass = updates.treatmentClass;
		}

		if (updates.fpkNo) {
			newModelJson.fpkNo = updates.fpkNo;
		}

		if (updates.sepNo) {
			newModelJson.sepNo = updates.sepNo;
		}

		if (updates.name) {
			newModelJson.name = updates.name;
		}

		if (updates.bpjsCardNo) {
			newModelJson.bpjsCardNo = updates.bpjsCardNo;
		}

		if (updates.patientID) {
			newModelJson.patientID = updates.patientID;
		}

		if (updates.polyclinic) {
			newModelJson.polyclinic = updates.polyclinic;
		}

		if (updates.status) {
			newModelJson.status = updates.status;
		}

		if (updates.dismissalDate) {
			newModelJson.dismissalDate = updates.dismissalDate;
		}

		if (updates.sepDate) {
			newModelJson.sepDate = updates.sepDate;
		}

		return new BpjsClaimDataModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsClaimDataModel)) {
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
