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
import {InventoryAdjusmentBatchCollectionState, InventoryAdjusmentBatchModelState} from './inventory_adjusment_batch.model.state';
import {InventoryAdjusmentBatchModel} from './inventory_adjusment_batch.model';
import {ModelState} from '../model.state';
import {sortAndFilterByQueryParams} from '../../lib/models/model-utils';
import {QueryParams} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Given the current model state, select models that are of type Inventory Adjusment Batch.
 */
export const getInventoryAdjusmentBatchModelState = createSelector(
	getModelState,
	(modelState: ModelState) => modelState.InventoryAdjusmentBatchModel
);

/**
 * Given the current model state, select the total count of the models.
 */
export const getCountInventoryAdjusmentBatchModels = createSelector(
	getInventoryAdjusmentBatchModelState,
	(modelState: InventoryAdjusmentBatchModelState) => modelState.totalCount
);

/**
 * Given the current model state, select the audits of all the entities.
 */
export const getInventoryAdjusmentBatchModelAudits = createSelector(
	getInventoryAdjusmentBatchModelState,
	(modelState: InventoryAdjusmentBatchModelState) => modelState.audits
);

/**
 * Given the current model state, select the audits of this entity by entity id.
 */
export const getInventoryAdjusmentBatchModelAuditsByEntityId = createSelector(
	getInventoryAdjusmentBatchModelState,
	(modelState: InventoryAdjusmentBatchModelState, entityId: string) => modelState.audits.filter(audit => audit.Entity.id === entityId)
);

/**
 * Given an ID, return the entity with the same ID in the central store.
 */
export const getInventoryAdjusmentBatchModelWithId = createSelector(
	getInventoryAdjusmentBatchModelState,
	(modelState: InventoryAdjusmentBatchModelState, id: string) => modelState.data[id]
);

/**
 * Given the current model state, select data of the model that are of type Inventory Adjusment Batch by name.
 */
export const getInventoryAdjusmentBatchModels = createSelector(
	getInventoryAdjusmentBatchModelState,
	(modelState: InventoryAdjusmentBatchModelState) => Object.values(modelState.data)
);

/**
 * Given the current model state, select data of the model and filter by the query.
 */
export const getInventoryAdjusmentBatchModelDataWithQuery = createSelector(
	getInventoryAdjusmentBatchModels,
	(modelData: InventoryAdjusmentBatchModel[], queryParams: QueryParams) => sortAndFilterByQueryParams(modelData, queryParams)
);

/**
 * Given the current model state, select the state of specific collection by collection id
 * The collection id needs to be unique to avoid use the wrong collection
 */
export const getInventoryAdjusmentBatchCollectionState = createSelector(
	getModelState,
	(modelState: ModelState, collectionId: string) => modelState.InventoryAdjusmentBatchModel.collectionState[collectionId]
);

/**
 * Given the current model state, select the actual data of specific collection by ID
 */
export const getInventoryAdjusmentBatchCollectionModels = createSelector(
	getInventoryAdjusmentBatchModelState,
	getInventoryAdjusmentBatchCollectionState,
	(modelState: InventoryAdjusmentBatchModelState, collectionState: InventoryAdjusmentBatchCollectionState) => collectionState.ids.map(id => modelState.data[id])
);

/**
 * Given the current model state, select the number of models of specific collection by ID
 */
export const getInventoryAdjusmentBatchCollectionCount = createSelector(
	getInventoryAdjusmentBatchCollectionState,
	(collectionState: InventoryAdjusmentBatchCollectionState) => collectionState.collectionCount
);


// % protected region % [Add any additional selectors here] off begin
// % protected region % [Add any additional selectors here] end
