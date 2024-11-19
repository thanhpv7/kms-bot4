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

import {AbstractModel, ModelProperty} from './abstract.model';
import * as _ from 'lodash';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * The model that represent the file that is used by the {@link FileUploadComponent}.
 */
export class FileModel extends AbstractModel {

	/**
	 * The name of the file including the file extension.
	 */
	name: string;

	/**
	 * The size of the file.
	 */
	size: number;

	/**
	 * The contents of the file, this can be nullable.
	 */
	content: string;

	/**
	 * Property to indicate if the file should be deleted, this is utilised on save/update.
	 */
	doDelete: boolean = false;

	// % protected region % [Add custom FileModel attributes here] off begin
	// % protected region % [Add custom FileModel attributes here] end

	/**
	 * @example
	 *
	 * `let file = new FileModel(data);`
	 *
	 * @param data The input data to be initialised as the FileModel,
	 *    it is expected as a JSON string or as a nullable FileModel
	 */
	constructor(data?: string | Partial<FileModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<FileModel>
				: data;

			this.name = json.name;
			this.size = json.size;
			this.content = json.content;
			this.doDelete = json.doDelete ? json.doDelete : this.doDelete;

			// % protected region % [Initialise custom FileModel attributes here] off begin
			// % protected region % [Initialise custom FileModel attributes here] end
		}
	}

	static create(file: File): Observable<FileModel> {
		// % protected region % [Overwrite the logic of create() here] off begin
		return FileModel.readFileContent(file).pipe(
			map(fileContent => {
				const newModel = new FileModel();
				newModel.name = file.name;
				newModel.modified = new Date(file.lastModified);
				newModel.size = file.size;
				newModel.content = fileContent;
				return newModel;
			})
		);
		// % protected region % [Overwrite the logic of create() here] end
	}

	private static readFileContent(file: File): Observable<string> {
		return new Observable(observer => {
			const fileReader = new FileReader();
			fileReader.onload = () => {
				observer.next(fileReader.result as string);
				observer.complete();
			};
			fileReader.onerror = (err) => observer.error(err);
			fileReader.readAsDataURL(file);
		});
	}

	difference(other: AbstractModel): any {
		if (!(other instanceof FileModel)) {
			return {};
		}

		const diff = {};

		for (const key of _.keys(this)) {
			const thisValue = this[key];
			const otherValue = other[key];
			if (thisValue !== otherValue) {
				diff[key] = thisValue;
			}
		}

		return _.omit(diff, [
			'created',
			'modified',
		]);
	}

	getPropDisplayNames(): { [p: string]: ModelProperty } {
		return {};
	}

	toJSON() {
		// % protected region % [Overwrite the logic of toJSON() here] off begin
		return {
			...super.toJSON(),
			name: this.name,
			size: this.size,
			content: this.content,
			doDelete: this.doDelete
		};
		// % protected region % [Overwrite the logic of toJSON() here] end
	}

	// % protected region % [Add custom FileModel methods here] off begin
	// % protected region % [Add custom FileModel methods here] end
}
