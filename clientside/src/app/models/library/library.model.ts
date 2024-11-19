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
import {FileModel} from '../../lib/models/file.model';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class LibraryModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'libraryItemCode',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'libraryDocument',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'LibraryModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return LibraryModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	libraryDocument: FileModel[];

	/**
	 * .
	 */
	libraryItemCode: string;

	/**
	 * .
	 */
	libraryItemDescription: string;

	/**
	 * .
	 */
	classification: string;

	/**
	 * .
	 */
	author: string;

	/**
	 * .
	 */
	publisher: string;



	modelPropGroups: { [s: string]: Group } = LibraryModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'libraryDocument',
				// % protected region % [Set displayName for Library Document here] off begin
				displayName: 'Library Document',
				// % protected region % [Set displayName for Library Document here] end
				type: ModelPropertyType.FILE,
				// % protected region % [Set display element type for Library Document here] off begin
				elementType: ElementType.FILE,
				// % protected region % [Set display element type for Library Document here] end
				// % protected region % [Set isSensitive for Library Document here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Library Document here] end
				// % protected region % [Set readonly for Library Document here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Library Document here] end
				validators: [
					// % protected region % [Add other validators for Library Document here] off begin
					// % protected region % [Add other validators for Library Document here] end
				],
				// % protected region % [Add any additional model attribute properties for Library Document here] off begin
				// % protected region % [Add any additional model attribute properties for Library Document here] end
			},
			{
				name: 'libraryItemCode',
				// % protected region % [Set displayName for Library Item Code here] off begin
				displayName: 'Library Item Code',
				// % protected region % [Set displayName for Library Item Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Library Item Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Library Item Code here] end
				// % protected region % [Set isSensitive for Library Item Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Library Item Code here] end
				// % protected region % [Set readonly for Library Item Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Library Item Code here] end
				validators: [
					// % protected region % [Add other validators for Library Item Code here] off begin
					// % protected region % [Add other validators for Library Item Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Library Item Code here] off begin
				// % protected region % [Add any additional model attribute properties for Library Item Code here] end
			},
			{
				name: 'libraryItemDescription',
				// % protected region % [Set displayName for Library Item Description here] off begin
				displayName: 'Library Item Description',
				// % protected region % [Set displayName for Library Item Description here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Library Item Description here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Library Item Description here] end
				// % protected region % [Set isSensitive for Library Item Description here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Library Item Description here] end
				// % protected region % [Set readonly for Library Item Description here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Library Item Description here] end
				validators: [
					// % protected region % [Add other validators for Library Item Description here] off begin
					// % protected region % [Add other validators for Library Item Description here] end
				],
				// % protected region % [Add any additional model attribute properties for Library Item Description here] off begin
				// % protected region % [Add any additional model attribute properties for Library Item Description here] end
			},
			{
				name: 'classification',
				// % protected region % [Set displayName for Classification here] off begin
				displayName: 'Classification',
				// % protected region % [Set displayName for Classification here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Classification here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Classification here] end
				// % protected region % [Set isSensitive for Classification here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Classification here] end
				// % protected region % [Set readonly for Classification here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Classification here] end
				validators: [
					// % protected region % [Add other validators for Classification here] off begin
					// % protected region % [Add other validators for Classification here] end
				],
				// % protected region % [Add any additional model attribute properties for Classification here] off begin
				// % protected region % [Add any additional model attribute properties for Classification here] end
			},
			{
				name: 'author',
				// % protected region % [Set displayName for Author here] off begin
				displayName: 'Author',
				// % protected region % [Set displayName for Author here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Author here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Author here] end
				// % protected region % [Set isSensitive for Author here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Author here] end
				// % protected region % [Set readonly for Author here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Author here] end
				validators: [
					// % protected region % [Add other validators for Author here] off begin
					// % protected region % [Add other validators for Author here] end
				],
				// % protected region % [Add any additional model attribute properties for Author here] off begin
				// % protected region % [Add any additional model attribute properties for Author here] end
			},
			{
				name: 'publisher',
				// % protected region % [Set displayName for Publisher here] off begin
				displayName: 'Publisher',
				// % protected region % [Set displayName for Publisher here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Publisher here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Publisher here] end
				// % protected region % [Set isSensitive for Publisher here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Publisher here] end
				// % protected region % [Set readonly for Publisher here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Publisher here] end
				validators: [
					// % protected region % [Add other validators for Publisher here] off begin
					// % protected region % [Add other validators for Publisher here] end
				],
				// % protected region % [Add any additional model attribute properties for Publisher here] off begin
				// % protected region % [Add any additional model attribute properties for Publisher here] end
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
				case 'libraryItemCode':
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
	static deepParse(data: string | { [K in keyof LibraryModel]?: LibraryModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new LibraryModel(data);
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
	 * `let libraryModel = new LibraryModel(data);`
	 *
	 * @param data The input data to be initialised as the LibraryModel,
	 *    it is expected as a JSON string or as a nullable LibraryModel.
	 */
	constructor(data?: string | Partial<LibraryModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<LibraryModel>
				: data;

			this.libraryDocument = json.libraryDocument?.map(item => new FileModel(item));
			this.libraryItemCode = json.libraryItemCode;
			this.libraryItemDescription = json.libraryItemDescription;
			this.classification = json.classification;
			this.author = json.author;
			this.publisher = json.publisher;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			libraryDocument: this.libraryDocument,
			libraryItemCode: this.libraryItemCode,
			libraryItemDescription: this.libraryItemDescription,
			classification: this.classification,
			author: this.author,
			publisher: this.publisher,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		LibraryModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): LibraryModel {
		let newModelJson = this.toJSON();

		if (updates.libraryDocument) {
			newModelJson.libraryDocument = updates.libraryDocument;
		}

		if (updates.libraryItemCode) {
			newModelJson.libraryItemCode = updates.libraryItemCode;
		}

		if (updates.libraryItemDescription) {
			newModelJson.libraryItemDescription = updates.libraryItemDescription;
		}

		if (updates.classification) {
			newModelJson.classification = updates.classification;
		}

		if (updates.author) {
			newModelJson.author = updates.author;
		}

		if (updates.publisher) {
			newModelJson.publisher = updates.publisher;
		}

		return new LibraryModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof LibraryModel)) {
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
			} else if (['libraryDocument'].includes(key)) {;
				const thisFiles = JSON.stringify(thisValue);
				const otherFiles = JSON.stringify(otherValue);

				if (thisFiles !== otherFiles) {
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
