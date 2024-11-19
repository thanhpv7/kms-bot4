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
import {SupplierModel} from '../supplier/supplier.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class SupplierContactDetailModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'name',
		'position',
		'mobilePhoneNumber',
		'ext',
		'email',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'name',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'SupplierContactDetailModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return SupplierContactDetailModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	name: string;

	/**
	 * .
	 */
	position: string;

	/**
	 * .
	 */
	phoneNumber: string;

	/**
	 * .
	 */
	mobilePhoneNumber: string;

	/**
	 * extension number.
	 */
	ext: string;

	/**
	 * .
	 */
	email: string;

	supplierId: string;

	supplier: SupplierModel;

	modelPropGroups: { [s: string]: Group } = SupplierContactDetailModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
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
				name: 'position',
				// % protected region % [Set displayName for Position here] off begin
				displayName: 'Position',
				// % protected region % [Set displayName for Position here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Position here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Position here] end
				// % protected region % [Set isSensitive for Position here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Position here] end
				// % protected region % [Set readonly for Position here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Position here] end
				validators: [
					// % protected region % [Add other validators for Position here] off begin
					// % protected region % [Add other validators for Position here] end
				],
				// % protected region % [Add any additional model attribute properties for Position here] off begin
				// % protected region % [Add any additional model attribute properties for Position here] end
			},
			{
				name: 'phoneNumber',
				// % protected region % [Set displayName for Phone Number here] off begin
				displayName: 'Phone Number',
				// % protected region % [Set displayName for Phone Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Phone Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Phone Number here] end
				// % protected region % [Set isSensitive for Phone Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Phone Number here] end
				// % protected region % [Set readonly for Phone Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Phone Number here] end
				validators: [
					CustomValidators.numeric(),
					// % protected region % [Add other validators for Phone Number here] off begin
					// % protected region % [Add other validators for Phone Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Phone Number here] off begin
				// % protected region % [Add any additional model attribute properties for Phone Number here] end
			},
			{
				name: 'mobilePhoneNumber',
				// % protected region % [Set displayName for Mobile Phone Number here] off begin
				displayName: 'Mobile Phone Number',
				// % protected region % [Set displayName for Mobile Phone Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Mobile Phone Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Mobile Phone Number here] end
				// % protected region % [Set isSensitive for Mobile Phone Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Mobile Phone Number here] end
				// % protected region % [Set readonly for Mobile Phone Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Mobile Phone Number here] end
				validators: [
					CustomValidators.numeric(),
					// % protected region % [Add other validators for Mobile Phone Number here] off begin
					// % protected region % [Add other validators for Mobile Phone Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Mobile Phone Number here] off begin
				// % protected region % [Add any additional model attribute properties for Mobile Phone Number here] end
			},
			{
				name: 'ext',
				// % protected region % [Set displayName for Ext here] off begin
				displayName: 'Ext',
				// % protected region % [Set displayName for Ext here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Ext here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Ext here] end
				// % protected region % [Set isSensitive for Ext here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Ext here] end
				// % protected region % [Set readonly for Ext here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Ext here] end
				validators: [
					CustomValidators.numeric(),
					// % protected region % [Add other validators for Ext here] off begin
					// % protected region % [Add other validators for Ext here] end
				],
				// % protected region % [Add any additional model attribute properties for Ext here] off begin
				// % protected region % [Add any additional model attribute properties for Ext here] end
			},
			{
				name: 'email',
				// % protected region % [Set displayName for Email here] off begin
				displayName: 'Email',
				// % protected region % [Set displayName for Email here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Email here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Email here] end
				// % protected region % [Set isSensitive for Email here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Email here] end
				// % protected region % [Set readonly for Email here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Email here] end
				validators: [
					Validators.email,
					// % protected region % [Add other validators for Email here] off begin
					// % protected region % [Add other validators for Email here] end
				],
				// % protected region % [Add any additional model attribute properties for Email here] off begin
				// % protected region % [Add any additional model attribute properties for Email here] end
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
				id: 'supplier',
				type: ModelRelationType.ONE,
				name: 'supplierId',
				// % protected region % [Customise your label for Supplier here] off begin
				label: 'Supplier',
				// % protected region % [Customise your label for Supplier here] end
				entityName: 'SupplierModel',
				// % protected region % [Customise your display name for Supplier here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'supplierNumber',
				// % protected region % [Customise your display name for Supplier here] end
				validators: [
					// % protected region % [Add other validators for Supplier here] off begin
					// % protected region % [Add other validators for Supplier here] end
				],
				// % protected region % [Add any additional field for relation Supplier here] off begin
				// % protected region % [Add any additional field for relation Supplier here] end
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
				case 'name':
					break;
				case 'position':
					break;
				case 'mobilePhoneNumber':
					break;
				case 'ext':
					break;
				case 'email':
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
	static deepParse(data: string | { [K in keyof SupplierContactDetailModel]?: SupplierContactDetailModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new SupplierContactDetailModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.supplier) {
			currentModel.supplierId = json.supplier.id;
			returned = _.union(returned, SupplierModel.deepParse(json.supplier));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let supplierContactDetailModel = new SupplierContactDetailModel(data);`
	 *
	 * @param data The input data to be initialised as the SupplierContactDetailModel,
	 *    it is expected as a JSON string or as a nullable SupplierContactDetailModel.
	 */
	constructor(data?: string | Partial<SupplierContactDetailModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<SupplierContactDetailModel>
				: data;

			this.name = json.name;
			this.position = json.position;
			this.phoneNumber = json.phoneNumber;
			this.mobilePhoneNumber = json.mobilePhoneNumber;
			this.ext = json.ext;
			this.email = json.email;
			this.supplierId = json.supplierId;
			this.supplier = json.supplier;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			name: this.name,
			position: this.position,
			phoneNumber: this.phoneNumber,
			mobilePhoneNumber: this.mobilePhoneNumber,
			ext: this.ext,
			email: this.email,
			supplierId: this.supplierId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		SupplierContactDetailModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): SupplierContactDetailModel {
		let newModelJson = this.toJSON();

		if (updates.name) {
			newModelJson.name = updates.name;
		}

		if (updates.position) {
			newModelJson.position = updates.position;
		}

		if (updates.phoneNumber) {
			newModelJson.phoneNumber = updates.phoneNumber;
		}

		if (updates.mobilePhoneNumber) {
			newModelJson.mobilePhoneNumber = updates.mobilePhoneNumber;
		}

		if (updates.ext) {
			newModelJson.ext = updates.ext;
		}

		if (updates.email) {
			newModelJson.email = updates.email;
		}

		if (updates.supplierId) {
			newModelJson.supplierId = updates.supplierId;
		}

		return new SupplierContactDetailModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof SupplierContactDetailModel)) {
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
			'supplierId',
			'supplier',
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
		if (!this.supplier) {
			this.supplierId = null;
		} else {
			this.supplierId = this.supplier.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
