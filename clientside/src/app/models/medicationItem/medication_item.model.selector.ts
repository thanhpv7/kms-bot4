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
import {MedicationItemCollectionState, MedicationItemModelState} from './medication_item.model.state';
import {MedicationItemModel} from './medication_item.model';
import {ModelState} from '../model.state';
import {sortAndFilterByQueryParams} from '../../lib/models/model-utils';
import {QueryParams} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Given the current model state, select models that are of type Medication Item.
 */
export const getMedicationItemModelState = createSelector(
	getModelState,
	(modelState: ModelState) => modelState.MedicationItemModel
);

/**
 * Given the current model state, select the total count of the models.
 */
export const getCountMedicationItemModels = createSelector(
	getMedicationItemModelState,
	(modelState: MedicationItemModelState) => modelState.totalCount
);

/**
 * Given the current model state, select the audits of all the entities.
 */
export const getMedicationItemModelAudits = createSelector(
	getMedicationItemModelState,
	(modelState: MedicationItemModelState) => modelState.audits
);

/**
 * Given the current model state, select the audits of this entity by entity id.
 */
export const getMedicationItemModelAuditsByEntityId = createSelector(
	getMedicationItemModelState,
	(modelState: MedicationItemModelState, entityId: string) => modelState.audits.filter(audit => audit.Entity.id === entityId)
);

/**
 * Given an ID, return the entity with the same ID in the central store.
 */
export const getMedicationItemModelWithId = createSelector(
	getMedicationItemModelState,
	(modelState: MedicationItemModelState, id: string) => modelState.data[id]
);

/**
 * Given the current model state, select data of the model that are of type Medication Item by name.
 */
export const getMedicationItemModels = createSelector(
	getMedicationItemModelState,
	(modelState: MedicationItemModelState) => Object.values(modelState.data)
);

/**
 * Given the current model state, select data of the model and filter by the query.
 */
export const getMedicationItemModelDataWithQuery = createSelector(
	getMedicationItemModels,
	(modelData: MedicationItemModel[], queryParams: QueryParams) => sortAndFilterByQueryParams(modelData, queryParams)
);

/**
 * Given the current model state, select the state of specific collection by collection id
 * The collection id needs to be unique to avoid use the wrong collection
 */
export const getMedicationItemCollectionState = createSelector(
	getModelState,
	(modelState: ModelState, collectionId: string) => modelState.MedicationItemModel.collectionState[collectionId]
);

/**
 * Given the current model state, select the actual data of specific collection by ID
 */
export const getMedicationItemCollectionModels = createSelector(
	getMedicationItemModelState,
	getMedicationItemCollectionState,
	(modelState: MedicationItemModelState, collectionState: MedicationItemCollectionState) => collectionState.ids.map(id => modelState.data[id])
);

/**
 * Given the current model state, select the number of models of specific collection by ID
 */
export const getMedicationItemCollectionCount = createSelector(
	getMedicationItemCollectionState,
	(collectionState: MedicationItemCollectionState) => collectionState.collectionCount
);


// % protected region % [Add any additional selectors here] off begin
// % protected region % [Add any additional selectors here] end
