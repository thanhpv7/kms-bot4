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
import {PostOperativeDetailsCollectionState, PostOperativeDetailsModelState} from './post_operative_details.model.state';
import {PostOperativeDetailsModel} from './post_operative_details.model';
import {ModelState} from '../model.state';
import {sortAndFilterByQueryParams} from '../../lib/models/model-utils';
import {QueryParams} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Given the current model state, select models that are of type Post Operative Details.
 */
export const getPostOperativeDetailsModelState = createSelector(
	getModelState,
	(modelState: ModelState) => modelState.PostOperativeDetailsModel
);

/**
 * Given the current model state, select the total count of the models.
 */
export const getCountPostOperativeDetailsModels = createSelector(
	getPostOperativeDetailsModelState,
	(modelState: PostOperativeDetailsModelState) => modelState.totalCount
);

/**
 * Given the current model state, select the audits of all the entities.
 */
export const getPostOperativeDetailsModelAudits = createSelector(
	getPostOperativeDetailsModelState,
	(modelState: PostOperativeDetailsModelState) => modelState.audits
);

/**
 * Given the current model state, select the audits of this entity by entity id.
 */
export const getPostOperativeDetailsModelAuditsByEntityId = createSelector(
	getPostOperativeDetailsModelState,
	(modelState: PostOperativeDetailsModelState, entityId: string) => modelState.audits.filter(audit => audit.Entity.id === entityId)
);

/**
 * Given an ID, return the entity with the same ID in the central store.
 */
export const getPostOperativeDetailsModelWithId = createSelector(
	getPostOperativeDetailsModelState,
	(modelState: PostOperativeDetailsModelState, id: string) => modelState.data[id]
);

/**
 * Given the current model state, select data of the model that are of type Post Operative Details by name.
 */
export const getPostOperativeDetailsModels = createSelector(
	getPostOperativeDetailsModelState,
	(modelState: PostOperativeDetailsModelState) => Object.values(modelState.data)
);

/**
 * Given the current model state, select data of the model and filter by the query.
 */
export const getPostOperativeDetailsModelDataWithQuery = createSelector(
	getPostOperativeDetailsModels,
	(modelData: PostOperativeDetailsModel[], queryParams: QueryParams) => sortAndFilterByQueryParams(modelData, queryParams)
);

/**
 * Given the current model state, select the state of specific collection by collection id
 * The collection id needs to be unique to avoid use the wrong collection
 */
export const getPostOperativeDetailsCollectionState = createSelector(
	getModelState,
	(modelState: ModelState, collectionId: string) => modelState.PostOperativeDetailsModel.collectionState[collectionId]
);

/**
 * Given the current model state, select the actual data of specific collection by ID
 */
export const getPostOperativeDetailsCollectionModels = createSelector(
	getPostOperativeDetailsModelState,
	getPostOperativeDetailsCollectionState,
	(modelState: PostOperativeDetailsModelState, collectionState: PostOperativeDetailsCollectionState) => collectionState.ids.map(id => modelState.data[id])
);

/**
 * Given the current model state, select the number of models of specific collection by ID
 */
export const getPostOperativeDetailsCollectionCount = createSelector(
	getPostOperativeDetailsCollectionState,
	(collectionState: PostOperativeDetailsCollectionState) => collectionState.collectionCount
);


// % protected region % [Add any additional selectors here] off begin
// % protected region % [Add any additional selectors here] end
