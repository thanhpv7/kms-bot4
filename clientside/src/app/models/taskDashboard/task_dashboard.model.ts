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
export class TaskDashboardModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'kdppk',
		'jumlahAntrean',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'kdppk',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'TaskDashboardModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return TaskDashboardModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Kode PPK.
	 */
	kdppk: string;

	/**
	 * jumlah_antrean.
	 */
	jumlahAntrean: number;

	/**
	 * Nama Poli.
	 */
	namapoli: string;

	/**
	 * Nama PPK.
	 */
	nmppk: string;

	/**
	 * Kode Poli.
	 */
	kodepoli: string;

	/**
	 * .
	 */
	insertDate: Date;

	/**
	 * .
	 */
	tanggal: Date;

	/**
	 * .
	 */
	waktuTask1: number;

	/**
	 * .
	 */
	waktuTask2: number;

	/**
	 * .
	 */
	waktuTask3: number;

	/**
	 * .
	 */
	waktuTask4: number;

	/**
	 * .
	 */
	waktuTask5: number;

	/**
	 * .
	 */
	waktuTask6: number;

	/**
	 * Average Waktu Task 1.
	 */
	avgWaktuTask1: number;

	/**
	 * .
	 */
	avgWaktuTask2: number;

	/**
	 * .
	 */
	avgWaktuTask3: number;

	/**
	 * .
	 */
	avgWaktuTask4: number;

	/**
	 * .
	 */
	avgWaktuTask5: number;

	/**
	 * .
	 */
	avgWaktuTask6: number;



	modelPropGroups: { [s: string]: Group } = TaskDashboardModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'kdppk',
				// % protected region % [Set displayName for Kdppk here] off begin
				displayName: 'Kdppk',
				// % protected region % [Set displayName for Kdppk here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Kdppk here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Kdppk here] end
				// % protected region % [Set isSensitive for Kdppk here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Kdppk here] end
				// % protected region % [Set readonly for Kdppk here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Kdppk here] end
				validators: [
					// % protected region % [Add other validators for Kdppk here] off begin
					// % protected region % [Add other validators for Kdppk here] end
				],
				// % protected region % [Add any additional model attribute properties for Kdppk here] off begin
				// % protected region % [Add any additional model attribute properties for Kdppk here] end
			},
			{
				name: 'jumlahAntrean',
				// % protected region % [Set displayName for Jumlah antrean here] off begin
				displayName: 'Jumlah antrean',
				// % protected region % [Set displayName for Jumlah antrean here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Jumlah antrean here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Jumlah antrean here] end
				// % protected region % [Set isSensitive for Jumlah antrean here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Jumlah antrean here] end
				// % protected region % [Set readonly for Jumlah antrean here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Jumlah antrean here] end
				validators: [
					// % protected region % [Add other validators for Jumlah antrean here] off begin
					// % protected region % [Add other validators for Jumlah antrean here] end
				],
				// % protected region % [Add any additional model attribute properties for Jumlah antrean here] off begin
				// % protected region % [Add any additional model attribute properties for Jumlah antrean here] end
			},
			{
				name: 'namapoli',
				// % protected region % [Set displayName for Namapoli here] off begin
				displayName: 'Namapoli',
				// % protected region % [Set displayName for Namapoli here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Namapoli here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Namapoli here] end
				// % protected region % [Set isSensitive for Namapoli here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Namapoli here] end
				// % protected region % [Set readonly for Namapoli here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Namapoli here] end
				validators: [
					// % protected region % [Add other validators for Namapoli here] off begin
					// % protected region % [Add other validators for Namapoli here] end
				],
				// % protected region % [Add any additional model attribute properties for Namapoli here] off begin
				// % protected region % [Add any additional model attribute properties for Namapoli here] end
			},
			{
				name: 'nmppk',
				// % protected region % [Set displayName for Nmppk here] off begin
				displayName: 'Nmppk',
				// % protected region % [Set displayName for Nmppk here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Nmppk here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Nmppk here] end
				// % protected region % [Set isSensitive for Nmppk here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nmppk here] end
				// % protected region % [Set readonly for Nmppk here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nmppk here] end
				validators: [
					// % protected region % [Add other validators for Nmppk here] off begin
					// % protected region % [Add other validators for Nmppk here] end
				],
				// % protected region % [Add any additional model attribute properties for Nmppk here] off begin
				// % protected region % [Add any additional model attribute properties for Nmppk here] end
			},
			{
				name: 'kodepoli',
				// % protected region % [Set displayName for Kodepoli here] off begin
				displayName: 'Kodepoli',
				// % protected region % [Set displayName for Kodepoli here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Kodepoli here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Kodepoli here] end
				// % protected region % [Set isSensitive for Kodepoli here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Kodepoli here] end
				// % protected region % [Set readonly for Kodepoli here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Kodepoli here] end
				validators: [
					// % protected region % [Add other validators for Kodepoli here] off begin
					// % protected region % [Add other validators for Kodepoli here] end
				],
				// % protected region % [Add any additional model attribute properties for Kodepoli here] off begin
				// % protected region % [Add any additional model attribute properties for Kodepoli here] end
			},
			{
				name: 'insertDate',
				// % protected region % [Set displayName for Insert Date here] off begin
				displayName: 'Insert Date',
				// % protected region % [Set displayName for Insert Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Insert Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Insert Date here] end
				// % protected region % [Set isSensitive for Insert Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Insert Date here] end
				// % protected region % [Set readonly for Insert Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Insert Date here] end
				validators: [
					// % protected region % [Add other validators for Insert Date here] off begin
					// % protected region % [Add other validators for Insert Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Insert Date here] off begin
				// % protected region % [Add any additional model attribute properties for Insert Date here] end
			},
			{
				name: 'tanggal',
				// % protected region % [Set displayName for tanggal here] off begin
				displayName: 'tanggal',
				// % protected region % [Set displayName for tanggal here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for tanggal here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for tanggal here] end
				// % protected region % [Set isSensitive for tanggal here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tanggal here] end
				// % protected region % [Set readonly for tanggal here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tanggal here] end
				validators: [
					// % protected region % [Add other validators for tanggal here] off begin
					// % protected region % [Add other validators for tanggal here] end
				],
				// % protected region % [Add any additional model attribute properties for tanggal here] off begin
				// % protected region % [Add any additional model attribute properties for tanggal here] end
			},
			{
				name: 'waktuTask1',
				// % protected region % [Set displayName for Waktu Task1 here] off begin
				displayName: 'Waktu Task1',
				// % protected region % [Set displayName for Waktu Task1 here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Waktu Task1 here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Waktu Task1 here] end
				// % protected region % [Set isSensitive for Waktu Task1 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Waktu Task1 here] end
				// % protected region % [Set readonly for Waktu Task1 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Waktu Task1 here] end
				validators: [
					// % protected region % [Add other validators for Waktu Task1 here] off begin
					// % protected region % [Add other validators for Waktu Task1 here] end
				],
				// % protected region % [Add any additional model attribute properties for Waktu Task1 here] off begin
				// % protected region % [Add any additional model attribute properties for Waktu Task1 here] end
			},
			{
				name: 'waktuTask2',
				// % protected region % [Set displayName for Waktu Task2 here] off begin
				displayName: 'Waktu Task2',
				// % protected region % [Set displayName for Waktu Task2 here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Waktu Task2 here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Waktu Task2 here] end
				// % protected region % [Set isSensitive for Waktu Task2 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Waktu Task2 here] end
				// % protected region % [Set readonly for Waktu Task2 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Waktu Task2 here] end
				validators: [
					// % protected region % [Add other validators for Waktu Task2 here] off begin
					// % protected region % [Add other validators for Waktu Task2 here] end
				],
				// % protected region % [Add any additional model attribute properties for Waktu Task2 here] off begin
				// % protected region % [Add any additional model attribute properties for Waktu Task2 here] end
			},
			{
				name: 'waktuTask3',
				// % protected region % [Set displayName for Waktu Task3 here] off begin
				displayName: 'Waktu Task3',
				// % protected region % [Set displayName for Waktu Task3 here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Waktu Task3 here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Waktu Task3 here] end
				// % protected region % [Set isSensitive for Waktu Task3 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Waktu Task3 here] end
				// % protected region % [Set readonly for Waktu Task3 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Waktu Task3 here] end
				validators: [
					// % protected region % [Add other validators for Waktu Task3 here] off begin
					// % protected region % [Add other validators for Waktu Task3 here] end
				],
				// % protected region % [Add any additional model attribute properties for Waktu Task3 here] off begin
				// % protected region % [Add any additional model attribute properties for Waktu Task3 here] end
			},
			{
				name: 'waktuTask4',
				// % protected region % [Set displayName for Waktu Task4 here] off begin
				displayName: 'Waktu Task4',
				// % protected region % [Set displayName for Waktu Task4 here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Waktu Task4 here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Waktu Task4 here] end
				// % protected region % [Set isSensitive for Waktu Task4 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Waktu Task4 here] end
				// % protected region % [Set readonly for Waktu Task4 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Waktu Task4 here] end
				validators: [
					// % protected region % [Add other validators for Waktu Task4 here] off begin
					// % protected region % [Add other validators for Waktu Task4 here] end
				],
				// % protected region % [Add any additional model attribute properties for Waktu Task4 here] off begin
				// % protected region % [Add any additional model attribute properties for Waktu Task4 here] end
			},
			{
				name: 'waktuTask5',
				// % protected region % [Set displayName for Waktu Task5 here] off begin
				displayName: 'Waktu Task5',
				// % protected region % [Set displayName for Waktu Task5 here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Waktu Task5 here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Waktu Task5 here] end
				// % protected region % [Set isSensitive for Waktu Task5 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Waktu Task5 here] end
				// % protected region % [Set readonly for Waktu Task5 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Waktu Task5 here] end
				validators: [
					// % protected region % [Add other validators for Waktu Task5 here] off begin
					// % protected region % [Add other validators for Waktu Task5 here] end
				],
				// % protected region % [Add any additional model attribute properties for Waktu Task5 here] off begin
				// % protected region % [Add any additional model attribute properties for Waktu Task5 here] end
			},
			{
				name: 'waktuTask6',
				// % protected region % [Set displayName for Waktu Task6 here] off begin
				displayName: 'Waktu Task6',
				// % protected region % [Set displayName for Waktu Task6 here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Waktu Task6 here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Waktu Task6 here] end
				// % protected region % [Set isSensitive for Waktu Task6 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Waktu Task6 here] end
				// % protected region % [Set readonly for Waktu Task6 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Waktu Task6 here] end
				validators: [
					// % protected region % [Add other validators for Waktu Task6 here] off begin
					// % protected region % [Add other validators for Waktu Task6 here] end
				],
				// % protected region % [Add any additional model attribute properties for Waktu Task6 here] off begin
				// % protected region % [Add any additional model attribute properties for Waktu Task6 here] end
			},
			{
				name: 'avgWaktuTask1',
				// % protected region % [Set displayName for avg waktu task1 here] off begin
				displayName: 'avg waktu task1',
				// % protected region % [Set displayName for avg waktu task1 here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for avg waktu task1 here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for avg waktu task1 here] end
				// % protected region % [Set isSensitive for avg waktu task1 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for avg waktu task1 here] end
				// % protected region % [Set readonly for avg waktu task1 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for avg waktu task1 here] end
				validators: [
					// % protected region % [Add other validators for avg waktu task1 here] off begin
					// % protected region % [Add other validators for avg waktu task1 here] end
				],
				// % protected region % [Add any additional model attribute properties for avg waktu task1 here] off begin
				// % protected region % [Add any additional model attribute properties for avg waktu task1 here] end
			},
			{
				name: 'avgWaktuTask2',
				// % protected region % [Set displayName for avg waktu task2 here] off begin
				displayName: 'avg waktu task2',
				// % protected region % [Set displayName for avg waktu task2 here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for avg waktu task2 here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for avg waktu task2 here] end
				// % protected region % [Set isSensitive for avg waktu task2 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for avg waktu task2 here] end
				// % protected region % [Set readonly for avg waktu task2 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for avg waktu task2 here] end
				validators: [
					// % protected region % [Add other validators for avg waktu task2 here] off begin
					// % protected region % [Add other validators for avg waktu task2 here] end
				],
				// % protected region % [Add any additional model attribute properties for avg waktu task2 here] off begin
				// % protected region % [Add any additional model attribute properties for avg waktu task2 here] end
			},
			{
				name: 'avgWaktuTask3',
				// % protected region % [Set displayName for avg waktu task3 here] off begin
				displayName: 'avg waktu task3',
				// % protected region % [Set displayName for avg waktu task3 here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for avg waktu task3 here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for avg waktu task3 here] end
				// % protected region % [Set isSensitive for avg waktu task3 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for avg waktu task3 here] end
				// % protected region % [Set readonly for avg waktu task3 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for avg waktu task3 here] end
				validators: [
					// % protected region % [Add other validators for avg waktu task3 here] off begin
					// % protected region % [Add other validators for avg waktu task3 here] end
				],
				// % protected region % [Add any additional model attribute properties for avg waktu task3 here] off begin
				// % protected region % [Add any additional model attribute properties for avg waktu task3 here] end
			},
			{
				name: 'avgWaktuTask4',
				// % protected region % [Set displayName for avg waktu task4 here] off begin
				displayName: 'avg waktu task4',
				// % protected region % [Set displayName for avg waktu task4 here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for avg waktu task4 here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for avg waktu task4 here] end
				// % protected region % [Set isSensitive for avg waktu task4 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for avg waktu task4 here] end
				// % protected region % [Set readonly for avg waktu task4 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for avg waktu task4 here] end
				validators: [
					// % protected region % [Add other validators for avg waktu task4 here] off begin
					// % protected region % [Add other validators for avg waktu task4 here] end
				],
				// % protected region % [Add any additional model attribute properties for avg waktu task4 here] off begin
				// % protected region % [Add any additional model attribute properties for avg waktu task4 here] end
			},
			{
				name: 'avgWaktuTask5',
				// % protected region % [Set displayName for avg waktu task5 here] off begin
				displayName: 'avg waktu task5',
				// % protected region % [Set displayName for avg waktu task5 here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for avg waktu task5 here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for avg waktu task5 here] end
				// % protected region % [Set isSensitive for avg waktu task5 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for avg waktu task5 here] end
				// % protected region % [Set readonly for avg waktu task5 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for avg waktu task5 here] end
				validators: [
					// % protected region % [Add other validators for avg waktu task5 here] off begin
					// % protected region % [Add other validators for avg waktu task5 here] end
				],
				// % protected region % [Add any additional model attribute properties for avg waktu task5 here] off begin
				// % protected region % [Add any additional model attribute properties for avg waktu task5 here] end
			},
			{
				name: 'avgWaktuTask6',
				// % protected region % [Set displayName for avg waktu task6 here] off begin
				displayName: 'avg waktu task6',
				// % protected region % [Set displayName for avg waktu task6 here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for avg waktu task6 here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for avg waktu task6 here] end
				// % protected region % [Set isSensitive for avg waktu task6 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for avg waktu task6 here] end
				// % protected region % [Set readonly for avg waktu task6 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for avg waktu task6 here] end
				validators: [
					// % protected region % [Add other validators for avg waktu task6 here] off begin
					// % protected region % [Add other validators for avg waktu task6 here] end
				],
				// % protected region % [Add any additional model attribute properties for avg waktu task6 here] off begin
				// % protected region % [Add any additional model attribute properties for avg waktu task6 here] end
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
				case 'kdppk':
					break;
				case 'jumlahAntrean':
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
	static deepParse(data: string | { [K in keyof TaskDashboardModel]?: TaskDashboardModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new TaskDashboardModel(data);
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
	 * `let taskDashboardModel = new TaskDashboardModel(data);`
	 *
	 * @param data The input data to be initialised as the TaskDashboardModel,
	 *    it is expected as a JSON string or as a nullable TaskDashboardModel.
	 */
	constructor(data?: string | Partial<TaskDashboardModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<TaskDashboardModel>
				: data;

			this.kdppk = json.kdppk;
			this.jumlahAntrean = json.jumlahAntrean;
			this.namapoli = json.namapoli;
			this.nmppk = json.nmppk;
			this.kodepoli = json.kodepoli;
			if (json.insertDate) {
				this.insertDate = new Date(json.insertDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.insertDate = json.insertDate;
			}
			if (json.tanggal) {
				this.tanggal = new Date(json.tanggal);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.tanggal = json.tanggal;
			}
			this.waktuTask1 = json.waktuTask1;
			this.waktuTask2 = json.waktuTask2;
			this.waktuTask3 = json.waktuTask3;
			this.waktuTask4 = json.waktuTask4;
			this.waktuTask5 = json.waktuTask5;
			this.waktuTask6 = json.waktuTask6;
			this.avgWaktuTask1 = json.avgWaktuTask1;
			this.avgWaktuTask2 = json.avgWaktuTask2;
			this.avgWaktuTask3 = json.avgWaktuTask3;
			this.avgWaktuTask4 = json.avgWaktuTask4;
			this.avgWaktuTask5 = json.avgWaktuTask5;
			this.avgWaktuTask6 = json.avgWaktuTask6;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			kdppk: this.kdppk,
			jumlahAntrean: this.jumlahAntrean,
			namapoli: this.namapoli,
			nmppk: this.nmppk,
			kodepoli: this.kodepoli,
			insertDate: this.insertDate,
			tanggal: this.tanggal,
			waktuTask1: this.waktuTask1,
			waktuTask2: this.waktuTask2,
			waktuTask3: this.waktuTask3,
			waktuTask4: this.waktuTask4,
			waktuTask5: this.waktuTask5,
			waktuTask6: this.waktuTask6,
			avgWaktuTask1: this.avgWaktuTask1,
			avgWaktuTask2: this.avgWaktuTask2,
			avgWaktuTask3: this.avgWaktuTask3,
			avgWaktuTask4: this.avgWaktuTask4,
			avgWaktuTask5: this.avgWaktuTask5,
			avgWaktuTask6: this.avgWaktuTask6,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		TaskDashboardModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): TaskDashboardModel {
		let newModelJson = this.toJSON();

		if (updates.kdppk) {
			newModelJson.kdppk = updates.kdppk;
		}

		if (updates.jumlahAntrean) {
			newModelJson.jumlahAntrean = updates.jumlahAntrean;
		}

		if (updates.namapoli) {
			newModelJson.namapoli = updates.namapoli;
		}

		if (updates.nmppk) {
			newModelJson.nmppk = updates.nmppk;
		}

		if (updates.kodepoli) {
			newModelJson.kodepoli = updates.kodepoli;
		}

		if (updates.insertDate) {
			newModelJson.insertDate = updates.insertDate;
		}

		if (updates.tanggal) {
			newModelJson.tanggal = updates.tanggal;
		}

		if (updates.waktuTask1) {
			newModelJson.waktuTask1 = updates.waktuTask1;
		}

		if (updates.waktuTask2) {
			newModelJson.waktuTask2 = updates.waktuTask2;
		}

		if (updates.waktuTask3) {
			newModelJson.waktuTask3 = updates.waktuTask3;
		}

		if (updates.waktuTask4) {
			newModelJson.waktuTask4 = updates.waktuTask4;
		}

		if (updates.waktuTask5) {
			newModelJson.waktuTask5 = updates.waktuTask5;
		}

		if (updates.waktuTask6) {
			newModelJson.waktuTask6 = updates.waktuTask6;
		}

		if (updates.avgWaktuTask1) {
			newModelJson.avgWaktuTask1 = updates.avgWaktuTask1;
		}

		if (updates.avgWaktuTask2) {
			newModelJson.avgWaktuTask2 = updates.avgWaktuTask2;
		}

		if (updates.avgWaktuTask3) {
			newModelJson.avgWaktuTask3 = updates.avgWaktuTask3;
		}

		if (updates.avgWaktuTask4) {
			newModelJson.avgWaktuTask4 = updates.avgWaktuTask4;
		}

		if (updates.avgWaktuTask5) {
			newModelJson.avgWaktuTask5 = updates.avgWaktuTask5;
		}

		if (updates.avgWaktuTask6) {
			newModelJson.avgWaktuTask6 = updates.avgWaktuTask6;
		}

		return new TaskDashboardModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof TaskDashboardModel)) {
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
