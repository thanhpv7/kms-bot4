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
import {BpjsListTaskCollectionState, BpjsListTaskModelState} from './bpjs_list_task.model.state';
import {BpjsListTaskModel} from './bpjs_list_task.model';
import {ModelState} from '../model.state';
import {sortAndFilterByQueryParams} from '../../lib/models/model-utils';
import {QueryParams} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Given the current model state, select models that are of type BPJS List Task.
 */
export const getBpjsListTaskModelState = createSelector(
	getModelState,
	(modelState: ModelState) => modelState.BpjsListTaskModel
);

/**
 * Given the current model state, select the total count of the models.
 */
export const getCountBpjsListTaskModels = createSelector(
	getBpjsListTaskModelState,
	(modelState: BpjsListTaskModelState) => modelState.totalCount
);

/**
 * Given the current model state, select the audits of all the entities.
 */
export const getBpjsListTaskModelAudits = createSelector(
	getBpjsListTaskModelState,
	(modelState: BpjsListTaskModelState) => modelState.audits
);

/**
 * Given the current model state, select the audits of this entity by entity id.
 */
export const getBpjsListTaskModelAuditsByEntityId = createSelector(
	getBpjsListTaskModelState,
	(modelState: BpjsListTaskModelState, entityId: string) => modelState.audits.filter(audit => audit.Entity.id === entityId)
);

/**
 * Given an ID, return the entity with the same ID in the central store.
 */
export const getBpjsListTaskModelWithId = createSelector(
	getBpjsListTaskModelState,
	(modelState: BpjsListTaskModelState, id: string) => modelState.data[id]
);

/**
 * Given the current model state, select data of the model that are of type BPJS List Task by name.
 */
export const getBpjsListTaskModels = createSelector(
	getBpjsListTaskModelState,
	(modelState: BpjsListTaskModelState) => Object.values(modelState.data)
);

/**
 * Given the current model state, select data of the model and filter by the query.
 */
export const getBpjsListTaskModelDataWithQuery = createSelector(
	getBpjsListTaskModels,
	(modelData: BpjsListTaskModel[], queryParams: QueryParams) => sortAndFilterByQueryParams(modelData, queryParams)
);

/**
 * Given the current model state, select the state of specific collection by collection id
 * The collection id needs to be unique to avoid use the wrong collection
 */
export const getBpjsListTaskCollectionState = createSelector(
	getModelState,
	(modelState: ModelState, collectionId: string) => modelState.BpjsListTaskModel.collectionState[collectionId]
);

/**
 * Given the current model state, select the actual data of specific collection by ID
 */
export const getBpjsListTaskCollectionModels = createSelector(
	getBpjsListTaskModelState,
	getBpjsListTaskCollectionState,
	(modelState: BpjsListTaskModelState, collectionState: BpjsListTaskCollectionState) => collectionState.ids.map(id => modelState.data[id])
);

/**
 * Given the current model state, select the number of models of specific collection by ID
 */
export const getBpjsListTaskCollectionCount = createSelector(
	getBpjsListTaskCollectionState,
	(collectionState: BpjsListTaskCollectionState) => collectionState.collectionCount
);


// % protected region % [Add any additional selectors here] off begin
// % protected region % [Add any additional selectors here] end
