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
import {InformedConsentCollectionState, InformedConsentModelState} from './informed_consent.model.state';
import {InformedConsentModel} from './informed_consent.model';
import {ModelState} from '../model.state';
import {sortAndFilterByQueryParams} from '../../lib/models/model-utils';
import {QueryParams} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Given the current model state, select models that are of type Informed Consent.
 */
export const getInformedConsentModelState = createSelector(
	getModelState,
	(modelState: ModelState) => modelState.InformedConsentModel
);

/**
 * Given the current model state, select the total count of the models.
 */
export const getCountInformedConsentModels = createSelector(
	getInformedConsentModelState,
	(modelState: InformedConsentModelState) => modelState.totalCount
);

/**
 * Given the current model state, select the audits of all the entities.
 */
export const getInformedConsentModelAudits = createSelector(
	getInformedConsentModelState,
	(modelState: InformedConsentModelState) => modelState.audits
);

/**
 * Given the current model state, select the audits of this entity by entity id.
 */
export const getInformedConsentModelAuditsByEntityId = createSelector(
	getInformedConsentModelState,
	(modelState: InformedConsentModelState, entityId: string) => modelState.audits.filter(audit => audit.Entity.id === entityId)
);

/**
 * Given an ID, return the entity with the same ID in the central store.
 */
export const getInformedConsentModelWithId = createSelector(
	getInformedConsentModelState,
	(modelState: InformedConsentModelState, id: string) => modelState.data[id]
);

/**
 * Given the current model state, select data of the model that are of type Informed Consent by name.
 */
export const getInformedConsentModels = createSelector(
	getInformedConsentModelState,
	(modelState: InformedConsentModelState) => Object.values(modelState.data)
);

/**
 * Given the current model state, select data of the model and filter by the query.
 */
export const getInformedConsentModelDataWithQuery = createSelector(
	getInformedConsentModels,
	(modelData: InformedConsentModel[], queryParams: QueryParams) => sortAndFilterByQueryParams(modelData, queryParams)
);

/**
 * Given the current model state, select the state of specific collection by collection id
 * The collection id needs to be unique to avoid use the wrong collection
 */
export const getInformedConsentCollectionState = createSelector(
	getModelState,
	(modelState: ModelState, collectionId: string) => modelState.InformedConsentModel.collectionState[collectionId]
);

/**
 * Given the current model state, select the actual data of specific collection by ID
 */
export const getInformedConsentCollectionModels = createSelector(
	getInformedConsentModelState,
	getInformedConsentCollectionState,
	(modelState: InformedConsentModelState, collectionState: InformedConsentCollectionState) => collectionState.ids.map(id => modelState.data[id])
);

/**
 * Given the current model state, select the number of models of specific collection by ID
 */
export const getInformedConsentCollectionCount = createSelector(
	getInformedConsentCollectionState,
	(collectionState: InformedConsentCollectionState) => collectionState.collectionCount
);


// % protected region % [Add any additional selectors here] off begin
// % protected region % [Add any additional selectors here] end
