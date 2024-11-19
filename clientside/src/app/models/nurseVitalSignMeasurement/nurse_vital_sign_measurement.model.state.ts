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

import {NurseVitalSignMeasurementModel} from './nurse_vital_sign_measurement.model';
import {CollectionState, AbstractModelAudit} from '../model.state';
import {OrderBy, Where} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Default page index used to initialise every model state in the application. Also used for pagination.
 */
export const defaultPageIndex = 0;

/**
 * Default page size used to initialise every model state in the application. Also used for pagination.
 */
export const defaultPageSize = 10;

/**
 * Default ordering used to initialise every model state in the application. Also used for pagination.
 */
export const defaultOrders: OrderBy[] = [
	// % protected region % [Change default ordering here] off begin
	{
		path: 'created',
		descending: true
	}
	// % protected region % [Change default ordering here] end
];

/**
 * Default conditions used to initialise every model state in the application. Also used for pagination.
 */
export const defaultWheres: Where[][] = [
	// % protected region % [Add any default wheres here] off begin
	// % protected region % [Add any default wheres here] end
];

/**
 * NurseVitalSignMeasurementCollectionState would store the state of a collection of NurseVitalSignMeasurement
 */
export interface NurseVitalSignMeasurementCollectionState extends CollectionState {
	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end
}

/**
 * Interface used to store information about auditing against this entity.
 */
export interface NurseVitalSignMeasurementModelAudit extends AbstractModelAudit<NurseVitalSignMeasurementModel> {
	// % protected region % [Add any audit properties here] off begin
	// % protected region % [Add any audit properties here] end
}

/**
 * NurseVitalSignMeasurementModelState would store the state of the model
 */
export interface NurseVitalSignMeasurementModelState {
	collectionState: {
		[key: string]: NurseVitalSignMeasurementCollectionState;
	};
	data: {
		[id: string]: NurseVitalSignMeasurementModel;
	};
	totalCount: number;
	audits: NurseVitalSignMeasurementModelAudit[];
	// % protected region % [Add any model state fields here] off begin
	// % protected region % [Add any model state fields here] end
}

/**
 * The initial state of a collection of models.
 */
export const initialNurseVitalSignMeasurementCollectionState: NurseVitalSignMeasurementCollectionState = {
	// % protected region % [Change initial state here] off begin
	queryParams: {
		pageIndex: defaultPageIndex,
		pageSize: defaultPageSize,
		orderBy: defaultOrders,
		where: defaultWheres
	},
	ids: [],
	collectionCount: 0,
	// % protected region % [Change initial state here] end
};

/**
 * The initial state of NurseVitalSignMeasurementModelState
 */
export const initialState: NurseVitalSignMeasurementModelState = {
	collectionState: {
		// % protected region % [Add any additional collection states here] off begin
		// % protected region % [Add any additional collection states here] end
	},
	data: {
		// % protected region % [Add any additional model data here] off begin
		// % protected region % [Add any additional model data here] end
	},
	totalCount: 0,
	audits: [],
	// % protected region % [Add any additional states here] off begin
	// % protected region % [Add any additional states here] end
};

// % protected region % [Add any additional interfaces here] off begin
// % protected region % [Add any additional interfaces here] end
