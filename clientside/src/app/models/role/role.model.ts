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
import {PrivilegeModel} from '../privilege/privilege.model';
import {UserModel} from '../user/user.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class RoleModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'name',
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

	readonly className = 'RoleModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return RoleModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Name of the role.
	 */
	name: string;

	privilegesIds: string[] = [];

	privileges: PrivilegeModel[];

	usersIds: string[] = [];

	users: UserModel[];

	modelPropGroups: { [s: string]: Group } = RoleModel.modelPropGroups;

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
				id: 'privileges',
				type: ModelRelationType.MANY,
				name: 'privilegesIds',
				// % protected region % [Customise your 1-1 or 1-M label for privileges here] off begin
				label: 'privileges',
				// % protected region % [Customise your 1-1 or 1-M label for privileges here] end
				entityName: 'PrivilegeModel',
				// % protected region % [Customise your display name for privileges here] off begin
				displayName: 'name',
				// % protected region % [Customise your display name for privileges here] end
				validators: [
					// % protected region % [Add other validators for privileges here] off begin
					// % protected region % [Add other validators for privileges here] end
				],
				// % protected region % [Add any additional field for relation privileges here] off begin
				// % protected region % [Add any additional field for relation privileges here] end
			},
			{
				id: 'users',
				type: ModelRelationType.MANY,
				name: 'usersIds',
				// % protected region % [Customise your label for users here] off begin
				label: 'users',
				// % protected region % [Customise your label for users here] end
				entityName: 'UserModel',
				// % protected region % [Customise your display name for users here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'email',
				// % protected region % [Customise your display name for users here] end
				validators: [
					// % protected region % [Add other validators for users here] off begin
					// % protected region % [Add other validators for users here] end
				],
				// % protected region % [Add any additional field for relation users here] off begin
				// % protected region % [Add any additional field for relation users here] end
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
	static deepParse(data: string | { [K in keyof RoleModel]?: RoleModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new RoleModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing many to many
		if (json.privileges) {
			currentModel.privilegesIds = json.privileges.map(model => model.id);
			returned = _.union(returned, _.flatten(json.privileges.map(model => PrivilegeModel.deepParse(model))));
		}
		// Incoming many to many
		if (json.users) {
			currentModel.usersIds = json.users.map(model => model.id);
			returned = _.union(returned, _.flatten(json.users.map(model => UserModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let roleModel = new RoleModel(data);`
	 *
	 * @param data The input data to be initialised as the RoleModel,
	 *    it is expected as a JSON string or as a nullable RoleModel.
	 */
	constructor(data?: string | Partial<RoleModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<RoleModel>
				: data;

			this.name = json.name;
			this.privilegesIds = json.privilegesIds;
			this.privileges = json.privileges;
			this.usersIds = json.usersIds;
			this.users = json.users;
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
			privilegesIds: this.privilegesIds,
			usersIds: this.usersIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		RoleModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): RoleModel {
		let newModelJson = this.toJSON();

		if (updates.name) {
			newModelJson.name = updates.name;
		}

		if (updates.privilegesIds) {
			newModelJson.privilegesIds = updates.privilegesIds;
		}

		if (updates.usersIds) {
			newModelJson.usersIds = updates.usersIds;
		}

		return new RoleModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof RoleModel)) {
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
			'usersIds',
			'users',
			'privilegesIds',
			'privileges',
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
