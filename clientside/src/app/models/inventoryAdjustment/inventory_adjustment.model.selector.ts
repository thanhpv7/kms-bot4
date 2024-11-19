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

import {createSelector} from '@ngrx/store';
import {getModelState} from '../model.selector';
import {InventoryAdjustmentCollectionState, InventoryAdjustmentModelState} from './inventory_adjustment.model.state';
import {InventoryAdjustmentModel} from './inventory_adjustment.model';
import {ModelState} from '../model.state';
import {sortAndFilterByQueryParams} from '../../lib/models/model-utils';
import {QueryParams} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Given the current model state, select models that are of type Inventory Adjustment.
 */
export const getInventoryAdjustmentModelState = createSelector(
	getModelState,
	(modelState: ModelState) => modelState.InventoryAdjustmentModel
);

/**
 * Given the current model state, select the total count of the models.
 */
export const getCountInventoryAdjustmentModels = createSelector(
	getInventoryAdjustmentModelState,
	(modelState: InventoryAdjustmentModelState) => modelState.totalCount
);

/**
 * Given the current model state, select the audits of all the entities.
 */
export const getInventoryAdjustmentModelAudits = createSelector(
	getInventoryAdjustmentModelState,
	(modelState: InventoryAdjustmentModelState) => modelState.audits
);

/**
 * Given the current model state, select the audits of this entity by entity id.
 */
export const getInventoryAdjustmentModelAuditsByEntityId = createSelector(
	getInventoryAdjustmentModelState,
	(modelState: InventoryAdjustmentModelState, entityId: string) => modelState.audits.filter(audit => audit.Entity.id === entityId)
);

/**
 * Given an ID, return the entity with the same ID in the central store.
 */
export const getInventoryAdjustmentModelWithId = createSelector(
	getInventoryAdjustmentModelState,
	(modelState: InventoryAdjustmentModelState, id: string) => modelState.data[id]
);

/**
 * Given the current model state, select data of the model that are of type Inventory Adjustment by name.
 */
export const getInventoryAdjustmentModels = createSelector(
	getInventoryAdjustmentModelState,
	(modelState: InventoryAdjustmentModelState) => Object.values(modelState.data)
);

/**
 * Given the current model state, select data of the model and filter by the query.
 */
export const getInventoryAdjustmentModelDataWithQuery = createSelector(
	getInventoryAdjustmentModels,
	(modelData: InventoryAdjustmentModel[], queryParams: QueryParams) => sortAndFilterByQueryParams(modelData, queryParams)
);

/**
 * Given the current model state, select the state of specific collection by collection id
 * The collection id needs to be unique to avoid use the wrong collection
 */
export const getInventoryAdjustmentCollectionState = createSelector(
	getModelState,
	(modelState: ModelState, collectionId: string) => modelState.InventoryAdjustmentModel.collectionState[collectionId]
);

/**
 * Given the current model state, select the actual data of specific collection by ID
 */
export const getInventoryAdjustmentCollectionModels = createSelector(
	getInventoryAdjustmentModelState,
	getInventoryAdjustmentCollectionState,
	(modelState: InventoryAdjustmentModelState, collectionState: InventoryAdjustmentCollectionState) => collectionState.ids.map(id => modelState.data[id])
);

/**
 * Given the current model state, select the number of models of specific collection by ID
 */
export const getInventoryAdjustmentCollectionCount = createSelector(
	getInventoryAdjustmentCollectionState,
	(collectionState: InventoryAdjustmentCollectionState) => collectionState.collectionCount
);


// % protected region % [Add any additional selectors here] off begin
// % protected region % [Add any additional selectors here] end
