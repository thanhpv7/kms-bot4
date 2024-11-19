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
import {RoleModel} from '../role/role.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class PrivilegeModel extends AbstractModel {
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
		'name',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PrivilegeModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PrivilegeModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	name: string;

	/**
	 * .
	 */
	targetEntity: string;

	/**
	 * .
	 */
	allowCreate: boolean = false;

	/**
	 * .
	 */
	allowRead: boolean = false;

	/**
	 * .
	 */
	allowUpdate: boolean = false;

	/**
	 * .
	 */
	allowDelete: boolean = false;

	rolesIds: string[] = [];

	roles: RoleModel[];

	modelPropGroups: { [s: string]: Group } = PrivilegeModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'name',
				// % protected region % [Set displayName for name here] off begin
				displayName: 'name',
				// % protected region % [Set displayName for name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for name here] end
				// % protected region % [Set isSensitive for name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for name here] end
				// % protected region % [Set readonly for name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for name here] end
				validators: [
					// % protected region % [Add other validators for name here] off begin
					// % protected region % [Add other validators for name here] end
				],
				// % protected region % [Add any additional model attribute properties for name here] off begin
				// % protected region % [Add any additional model attribute properties for name here] end
			},
			{
				name: 'targetEntity',
				// % protected region % [Set displayName for target entity here] off begin
				displayName: 'target entity',
				// % protected region % [Set displayName for target entity here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for target entity here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for target entity here] end
				// % protected region % [Set isSensitive for target entity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for target entity here] end
				// % protected region % [Set readonly for target entity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for target entity here] end
				validators: [
					// % protected region % [Add other validators for target entity here] off begin
					// % protected region % [Add other validators for target entity here] end
				],
				// % protected region % [Add any additional model attribute properties for target entity here] off begin
				// % protected region % [Add any additional model attribute properties for target entity here] end
			},
			{
				name: 'allowCreate',
				// % protected region % [Set displayName for allow create here] off begin
				displayName: 'allow create',
				// % protected region % [Set displayName for allow create here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for allow create here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for allow create here] end
				// % protected region % [Set isSensitive for allow create here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for allow create here] end
				// % protected region % [Set readonly for allow create here] off begin
				readOnly: false,
				// % protected region % [Set readonly for allow create here] end
				validators: [
					// % protected region % [Add other validators for allow create here] off begin
					// % protected region % [Add other validators for allow create here] end
				],
				// % protected region % [Add any additional model attribute properties for allow create here] off begin
				// % protected region % [Add any additional model attribute properties for allow create here] end
			},
			{
				name: 'allowRead',
				// % protected region % [Set displayName for allow read here] off begin
				displayName: 'allow read',
				// % protected region % [Set displayName for allow read here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for allow read here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for allow read here] end
				// % protected region % [Set isSensitive for allow read here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for allow read here] end
				// % protected region % [Set readonly for allow read here] off begin
				readOnly: false,
				// % protected region % [Set readonly for allow read here] end
				validators: [
					// % protected region % [Add other validators for allow read here] off begin
					// % protected region % [Add other validators for allow read here] end
				],
				// % protected region % [Add any additional model attribute properties for allow read here] off begin
				// % protected region % [Add any additional model attribute properties for allow read here] end
			},
			{
				name: 'allowUpdate',
				// % protected region % [Set displayName for allow update here] off begin
				displayName: 'allow update',
				// % protected region % [Set displayName for allow update here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for allow update here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for allow update here] end
				// % protected region % [Set isSensitive for allow update here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for allow update here] end
				// % protected region % [Set readonly for allow update here] off begin
				readOnly: false,
				// % protected region % [Set readonly for allow update here] end
				validators: [
					// % protected region % [Add other validators for allow update here] off begin
					// % protected region % [Add other validators for allow update here] end
				],
				// % protected region % [Add any additional model attribute properties for allow update here] off begin
				// % protected region % [Add any additional model attribute properties for allow update here] end
			},
			{
				name: 'allowDelete',
				// % protected region % [Set displayName for allow delete here] off begin
				displayName: 'allow delete',
				// % protected region % [Set displayName for allow delete here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for allow delete here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for allow delete here] end
				// % protected region % [Set isSensitive for allow delete here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for allow delete here] end
				// % protected region % [Set readonly for allow delete here] off begin
				readOnly: false,
				// % protected region % [Set readonly for allow delete here] end
				validators: [
					// % protected region % [Add other validators for allow delete here] off begin
					// % protected region % [Add other validators for allow delete here] end
				],
				// % protected region % [Add any additional model attribute properties for allow delete here] off begin
				// % protected region % [Add any additional model attribute properties for allow delete here] end
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
				id: 'roles',
				type: ModelRelationType.MANY,
				name: 'rolesIds',
				// % protected region % [Customise your label for roles here] off begin
				label: 'roles',
				// % protected region % [Customise your label for roles here] end
				entityName: 'RoleModel',
				// % protected region % [Customise your display name for roles here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'name',
				// % protected region % [Customise your display name for roles here] end
				validators: [
					// % protected region % [Add other validators for roles here] off begin
					// % protected region % [Add other validators for roles here] end
				],
				// % protected region % [Add any additional field for relation roles here] off begin
				// % protected region % [Add any additional field for relation roles here] end
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
	static deepParse(data: string | { [K in keyof PrivilegeModel]?: PrivilegeModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PrivilegeModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming many to many
		if (json.roles) {
			currentModel.rolesIds = json.roles.map(model => model.id);
			returned = _.union(returned, _.flatten(json.roles.map(model => RoleModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let privilegeModel = new PrivilegeModel(data);`
	 *
	 * @param data The input data to be initialised as the PrivilegeModel,
	 *    it is expected as a JSON string or as a nullable PrivilegeModel.
	 */
	constructor(data?: string | Partial<PrivilegeModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PrivilegeModel>
				: data;

			this.name = json.name;
			this.targetEntity = json.targetEntity;
			this.allowCreate = json.allowCreate;
			this.allowRead = json.allowRead;
			this.allowUpdate = json.allowUpdate;
			this.allowDelete = json.allowDelete;
			this.rolesIds = json.rolesIds;
			this.roles = json.roles;
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
			targetEntity: this.targetEntity,
			allowCreate: this.allowCreate,
			allowRead: this.allowRead,
			allowUpdate: this.allowUpdate,
			allowDelete: this.allowDelete,
			rolesIds: this.rolesIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PrivilegeModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PrivilegeModel {
		let newModelJson = this.toJSON();

		if (updates.name) {
			newModelJson.name = updates.name;
		}

		if (updates.targetEntity) {
			newModelJson.targetEntity = updates.targetEntity;
		}

		if (updates.allowCreate) {
			newModelJson.allowCreate = updates.allowCreate;
		}

		if (updates.allowRead) {
			newModelJson.allowRead = updates.allowRead;
		}

		if (updates.allowUpdate) {
			newModelJson.allowUpdate = updates.allowUpdate;
		}

		if (updates.allowDelete) {
			newModelJson.allowDelete = updates.allowDelete;
		}

		if (updates.rolesIds) {
			newModelJson.rolesIds = updates.rolesIds;
		}

		return new PrivilegeModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PrivilegeModel)) {
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
			'rolesIds',
			'roles',
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
