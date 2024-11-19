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
export class BpjsJasaRaharjaClaimModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'noSEP',
		'sepDate',
		'dismissalDate',
		'polyclinic',
		'bpjsCardNo',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'noSEP',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsJasaRaharjaClaimModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsJasaRaharjaClaimModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	noSEP: string;

	/**
	 * .
	 */
	sepDate: Date;

	/**
	 * .
	 */
	dismissalDate: Date;

	/**
	 * .
	 */
	patientID: string;

	/**
	 * .
	 */
	treatmentType: string;

	/**
	 * .
	 */
	polyclinic: string;

	/**
	 * .
	 */
	bpjsCardNo: string;

	/**
	 * .
	 */
	name: string;

	/**
	 * .
	 */
	incidentDate: Date;



	modelPropGroups: { [s: string]: Group } = BpjsJasaRaharjaClaimModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'noSEP',
				// % protected region % [Set displayName for No SEP here] off begin
				displayName: 'No SEP',
				// % protected region % [Set displayName for No SEP here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for No SEP here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for No SEP here] end
				// % protected region % [Set isSensitive for No SEP here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for No SEP here] end
				// % protected region % [Set readonly for No SEP here] off begin
				readOnly: false,
				// % protected region % [Set readonly for No SEP here] end
				validators: [
					// % protected region % [Add other validators for No SEP here] off begin
					// % protected region % [Add other validators for No SEP here] end
				],
				// % protected region % [Add any additional model attribute properties for No SEP here] off begin
				// % protected region % [Add any additional model attribute properties for No SEP here] end
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
				name: 'incidentDate',
				// % protected region % [Set displayName for Incident Date here] off begin
				displayName: 'Incident Date',
				// % protected region % [Set displayName for Incident Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Incident Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Incident Date here] end
				// % protected region % [Set isSensitive for Incident Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Incident Date here] end
				// % protected region % [Set readonly for Incident Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Incident Date here] end
				validators: [
					// % protected region % [Add other validators for Incident Date here] off begin
					// % protected region % [Add other validators for Incident Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Incident Date here] off begin
				// % protected region % [Add any additional model attribute properties for Incident Date here] end
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
				case 'noSEP':
					break;
				case 'sepDate':
					break;
				case 'dismissalDate':
					break;
				case 'polyclinic':
					break;
				case 'bpjsCardNo':
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
	static deepParse(data: string | { [K in keyof BpjsJasaRaharjaClaimModel]?: BpjsJasaRaharjaClaimModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsJasaRaharjaClaimModel(data);
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
	 * `let bpjsJasaRaharjaClaimModel = new BpjsJasaRaharjaClaimModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsJasaRaharjaClaimModel,
	 *    it is expected as a JSON string or as a nullable BpjsJasaRaharjaClaimModel.
	 */
	constructor(data?: string | Partial<BpjsJasaRaharjaClaimModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsJasaRaharjaClaimModel>
				: data;

			this.noSEP = json.noSEP;
			if (json.sepDate) {
				this.sepDate = new Date(json.sepDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.sepDate = json.sepDate;
			}
			if (json.dismissalDate) {
				this.dismissalDate = new Date(json.dismissalDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.dismissalDate = json.dismissalDate;
			}
			this.patientID = json.patientID;
			this.treatmentType = json.treatmentType;
			this.polyclinic = json.polyclinic;
			this.bpjsCardNo = json.bpjsCardNo;
			this.name = json.name;
			if (json.incidentDate) {
				this.incidentDate = new Date(json.incidentDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.incidentDate = json.incidentDate;
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
			noSEP: this.noSEP,
			sepDate: this.sepDate,
			dismissalDate: this.dismissalDate,
			patientID: this.patientID,
			treatmentType: this.treatmentType,
			polyclinic: this.polyclinic,
			bpjsCardNo: this.bpjsCardNo,
			name: this.name,
			incidentDate: this.incidentDate,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsJasaRaharjaClaimModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsJasaRaharjaClaimModel {
		let newModelJson = this.toJSON();

		if (updates.noSEP) {
			newModelJson.noSEP = updates.noSEP;
		}

		if (updates.sepDate) {
			newModelJson.sepDate = updates.sepDate;
		}

		if (updates.dismissalDate) {
			newModelJson.dismissalDate = updates.dismissalDate;
		}

		if (updates.patientID) {
			newModelJson.patientID = updates.patientID;
		}

		if (updates.treatmentType) {
			newModelJson.treatmentType = updates.treatmentType;
		}

		if (updates.polyclinic) {
			newModelJson.polyclinic = updates.polyclinic;
		}

		if (updates.bpjsCardNo) {
			newModelJson.bpjsCardNo = updates.bpjsCardNo;
		}

		if (updates.name) {
			newModelJson.name = updates.name;
		}

		if (updates.incidentDate) {
			newModelJson.incidentDate = updates.incidentDate;
		}

		return new BpjsJasaRaharjaClaimModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsJasaRaharjaClaimModel)) {
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
