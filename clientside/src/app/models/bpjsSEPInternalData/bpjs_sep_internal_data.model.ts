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
export class BpjsSEPInternalDataModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'referredPolyclinic',
		'referringPolyclinic',
		'internalReferralDate',
		'sepNo',
		'refSEPNo',
		'sepHealthFacility',
		'bpjsCardNo',
		'sepDate',
		'letterNo',
		'isInternal',
		'referringPolyclinicCode',
		'diagnosticSupport',
		'referringDiagnose',
		'doctor',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'referredPolyclinic',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsSEPInternalDataModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsSEPInternalDataModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	referredPolyclinic: string;

	/**
	 * .
	 */
	referringPolyclinic: string;

	/**
	 * .
	 */
	internalReferralDate: string;

	/**
	 * .
	 */
	sepNo: string;

	/**
	 * .
	 */
	refSEPNo: string;

	/**
	 * .
	 */
	sepHealthFacility: string;

	/**
	 * .
	 */
	bpjsCardNo: string;

	/**
	 * .
	 */
	sepDate: string;

	/**
	 * .
	 */
	letterNo: string;

	/**
	 * .
	 */
	isInternal: string;

	/**
	 * .
	 */
	referringPolyclinicCode: string;

	/**
	 * .
	 */
	diagnosticSupport: string;

	/**
	 * .
	 */
	referringDiagnose: string;

	/**
	 * .
	 */
	doctor: string;



	modelPropGroups: { [s: string]: Group } = BpjsSEPInternalDataModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'referredPolyclinic',
				// % protected region % [Set displayName for Referred Polyclinic here] off begin
				displayName: 'Referred Polyclinic',
				// % protected region % [Set displayName for Referred Polyclinic here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referred Polyclinic here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referred Polyclinic here] end
				// % protected region % [Set isSensitive for Referred Polyclinic here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referred Polyclinic here] end
				// % protected region % [Set readonly for Referred Polyclinic here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referred Polyclinic here] end
				validators: [
					// % protected region % [Add other validators for Referred Polyclinic here] off begin
					// % protected region % [Add other validators for Referred Polyclinic here] end
				],
				// % protected region % [Add any additional model attribute properties for Referred Polyclinic here] off begin
				// % protected region % [Add any additional model attribute properties for Referred Polyclinic here] end
			},
			{
				name: 'referringPolyclinic',
				// % protected region % [Set displayName for Referring Polyclinic here] off begin
				displayName: 'Referring Polyclinic',
				// % protected region % [Set displayName for Referring Polyclinic here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referring Polyclinic here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referring Polyclinic here] end
				// % protected region % [Set isSensitive for Referring Polyclinic here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referring Polyclinic here] end
				// % protected region % [Set readonly for Referring Polyclinic here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referring Polyclinic here] end
				validators: [
					// % protected region % [Add other validators for Referring Polyclinic here] off begin
					// % protected region % [Add other validators for Referring Polyclinic here] end
				],
				// % protected region % [Add any additional model attribute properties for Referring Polyclinic here] off begin
				// % protected region % [Add any additional model attribute properties for Referring Polyclinic here] end
			},
			{
				name: 'internalReferralDate',
				// % protected region % [Set displayName for Internal Referral Date here] off begin
				displayName: 'Internal Referral Date',
				// % protected region % [Set displayName for Internal Referral Date here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Internal Referral Date here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Internal Referral Date here] end
				// % protected region % [Set isSensitive for Internal Referral Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Internal Referral Date here] end
				// % protected region % [Set readonly for Internal Referral Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Internal Referral Date here] end
				validators: [
					// % protected region % [Add other validators for Internal Referral Date here] off begin
					// % protected region % [Add other validators for Internal Referral Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Internal Referral Date here] off begin
				// % protected region % [Add any additional model attribute properties for Internal Referral Date here] end
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
				name: 'refSEPNo',
				// % protected region % [Set displayName for Ref SEP No here] off begin
				displayName: 'Ref SEP No',
				// % protected region % [Set displayName for Ref SEP No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Ref SEP No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Ref SEP No here] end
				// % protected region % [Set isSensitive for Ref SEP No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Ref SEP No here] end
				// % protected region % [Set readonly for Ref SEP No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Ref SEP No here] end
				validators: [
					// % protected region % [Add other validators for Ref SEP No here] off begin
					// % protected region % [Add other validators for Ref SEP No here] end
				],
				// % protected region % [Add any additional model attribute properties for Ref SEP No here] off begin
				// % protected region % [Add any additional model attribute properties for Ref SEP No here] end
			},
			{
				name: 'sepHealthFacility',
				// % protected region % [Set displayName for SEP Health Facility here] off begin
				displayName: 'SEP Health Facility',
				// % protected region % [Set displayName for SEP Health Facility here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for SEP Health Facility here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for SEP Health Facility here] end
				// % protected region % [Set isSensitive for SEP Health Facility here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for SEP Health Facility here] end
				// % protected region % [Set readonly for SEP Health Facility here] off begin
				readOnly: false,
				// % protected region % [Set readonly for SEP Health Facility here] end
				validators: [
					// % protected region % [Add other validators for SEP Health Facility here] off begin
					// % protected region % [Add other validators for SEP Health Facility here] end
				],
				// % protected region % [Add any additional model attribute properties for SEP Health Facility here] off begin
				// % protected region % [Add any additional model attribute properties for SEP Health Facility here] end
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
				name: 'letterNo',
				// % protected region % [Set displayName for Letter No here] off begin
				displayName: 'Letter No',
				// % protected region % [Set displayName for Letter No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Letter No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Letter No here] end
				// % protected region % [Set isSensitive for Letter No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Letter No here] end
				// % protected region % [Set readonly for Letter No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Letter No here] end
				validators: [
					// % protected region % [Add other validators for Letter No here] off begin
					// % protected region % [Add other validators for Letter No here] end
				],
				// % protected region % [Add any additional model attribute properties for Letter No here] off begin
				// % protected region % [Add any additional model attribute properties for Letter No here] end
			},
			{
				name: 'isInternal',
				// % protected region % [Set displayName for Is Internal here] off begin
				displayName: 'Is Internal',
				// % protected region % [Set displayName for Is Internal here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Is Internal here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Is Internal here] end
				// % protected region % [Set isSensitive for Is Internal here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Is Internal here] end
				// % protected region % [Set readonly for Is Internal here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Is Internal here] end
				validators: [
					// % protected region % [Add other validators for Is Internal here] off begin
					// % protected region % [Add other validators for Is Internal here] end
				],
				// % protected region % [Add any additional model attribute properties for Is Internal here] off begin
				// % protected region % [Add any additional model attribute properties for Is Internal here] end
			},
			{
				name: 'referringPolyclinicCode',
				// % protected region % [Set displayName for Referring Polyclinic Code here] off begin
				displayName: 'Referring Polyclinic Code',
				// % protected region % [Set displayName for Referring Polyclinic Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referring Polyclinic Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referring Polyclinic Code here] end
				// % protected region % [Set isSensitive for Referring Polyclinic Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referring Polyclinic Code here] end
				// % protected region % [Set readonly for Referring Polyclinic Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referring Polyclinic Code here] end
				validators: [
					// % protected region % [Add other validators for Referring Polyclinic Code here] off begin
					// % protected region % [Add other validators for Referring Polyclinic Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Referring Polyclinic Code here] off begin
				// % protected region % [Add any additional model attribute properties for Referring Polyclinic Code here] end
			},
			{
				name: 'diagnosticSupport',
				// % protected region % [Set displayName for Diagnostic Support here] off begin
				displayName: 'Diagnostic Support',
				// % protected region % [Set displayName for Diagnostic Support here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Diagnostic Support here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Diagnostic Support here] end
				// % protected region % [Set isSensitive for Diagnostic Support here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Diagnostic Support here] end
				// % protected region % [Set readonly for Diagnostic Support here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Diagnostic Support here] end
				validators: [
					// % protected region % [Add other validators for Diagnostic Support here] off begin
					// % protected region % [Add other validators for Diagnostic Support here] end
				],
				// % protected region % [Add any additional model attribute properties for Diagnostic Support here] off begin
				// % protected region % [Add any additional model attribute properties for Diagnostic Support here] end
			},
			{
				name: 'referringDiagnose',
				// % protected region % [Set displayName for Referring Diagnose here] off begin
				displayName: 'Referring Diagnose',
				// % protected region % [Set displayName for Referring Diagnose here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referring Diagnose here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referring Diagnose here] end
				// % protected region % [Set isSensitive for Referring Diagnose here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referring Diagnose here] end
				// % protected region % [Set readonly for Referring Diagnose here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referring Diagnose here] end
				validators: [
					// % protected region % [Add other validators for Referring Diagnose here] off begin
					// % protected region % [Add other validators for Referring Diagnose here] end
				],
				// % protected region % [Add any additional model attribute properties for Referring Diagnose here] off begin
				// % protected region % [Add any additional model attribute properties for Referring Diagnose here] end
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
				case 'referredPolyclinic':
					break;
				case 'referringPolyclinic':
					break;
				case 'internalReferralDate':
					break;
				case 'sepNo':
					break;
				case 'refSEPNo':
					break;
				case 'sepHealthFacility':
					break;
				case 'bpjsCardNo':
					break;
				case 'sepDate':
					break;
				case 'letterNo':
					break;
				case 'isInternal':
					break;
				case 'referringPolyclinicCode':
					break;
				case 'diagnosticSupport':
					break;
				case 'referringDiagnose':
					break;
				case 'doctor':
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
	static deepParse(data: string | { [K in keyof BpjsSEPInternalDataModel]?: BpjsSEPInternalDataModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsSEPInternalDataModel(data);
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
	 * `let bpjsSEPInternalDataModel = new BpjsSEPInternalDataModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsSEPInternalDataModel,
	 *    it is expected as a JSON string or as a nullable BpjsSEPInternalDataModel.
	 */
	constructor(data?: string | Partial<BpjsSEPInternalDataModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsSEPInternalDataModel>
				: data;

			this.referredPolyclinic = json.referredPolyclinic;
			this.referringPolyclinic = json.referringPolyclinic;
			this.internalReferralDate = json.internalReferralDate;
			this.sepNo = json.sepNo;
			this.refSEPNo = json.refSEPNo;
			this.sepHealthFacility = json.sepHealthFacility;
			this.bpjsCardNo = json.bpjsCardNo;
			this.sepDate = json.sepDate;
			this.letterNo = json.letterNo;
			this.isInternal = json.isInternal;
			this.referringPolyclinicCode = json.referringPolyclinicCode;
			this.diagnosticSupport = json.diagnosticSupport;
			this.referringDiagnose = json.referringDiagnose;
			this.doctor = json.doctor;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			referredPolyclinic: this.referredPolyclinic,
			referringPolyclinic: this.referringPolyclinic,
			internalReferralDate: this.internalReferralDate,
			sepNo: this.sepNo,
			refSEPNo: this.refSEPNo,
			sepHealthFacility: this.sepHealthFacility,
			bpjsCardNo: this.bpjsCardNo,
			sepDate: this.sepDate,
			letterNo: this.letterNo,
			isInternal: this.isInternal,
			referringPolyclinicCode: this.referringPolyclinicCode,
			diagnosticSupport: this.diagnosticSupport,
			referringDiagnose: this.referringDiagnose,
			doctor: this.doctor,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsSEPInternalDataModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsSEPInternalDataModel {
		let newModelJson = this.toJSON();

		if (updates.referredPolyclinic) {
			newModelJson.referredPolyclinic = updates.referredPolyclinic;
		}

		if (updates.referringPolyclinic) {
			newModelJson.referringPolyclinic = updates.referringPolyclinic;
		}

		if (updates.internalReferralDate) {
			newModelJson.internalReferralDate = updates.internalReferralDate;
		}

		if (updates.sepNo) {
			newModelJson.sepNo = updates.sepNo;
		}

		if (updates.refSEPNo) {
			newModelJson.refSEPNo = updates.refSEPNo;
		}

		if (updates.sepHealthFacility) {
			newModelJson.sepHealthFacility = updates.sepHealthFacility;
		}

		if (updates.bpjsCardNo) {
			newModelJson.bpjsCardNo = updates.bpjsCardNo;
		}

		if (updates.sepDate) {
			newModelJson.sepDate = updates.sepDate;
		}

		if (updates.letterNo) {
			newModelJson.letterNo = updates.letterNo;
		}

		if (updates.isInternal) {
			newModelJson.isInternal = updates.isInternal;
		}

		if (updates.referringPolyclinicCode) {
			newModelJson.referringPolyclinicCode = updates.referringPolyclinicCode;
		}

		if (updates.diagnosticSupport) {
			newModelJson.diagnosticSupport = updates.diagnosticSupport;
		}

		if (updates.referringDiagnose) {
			newModelJson.referringDiagnose = updates.referringDiagnose;
		}

		if (updates.doctor) {
			newModelJson.doctor = updates.doctor;
		}

		return new BpjsSEPInternalDataModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsSEPInternalDataModel)) {
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
