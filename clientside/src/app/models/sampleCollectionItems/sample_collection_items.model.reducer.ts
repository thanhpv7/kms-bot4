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

import {Action} from '@ngrx/store';
import produce from 'immer';
import * as _ from 'lodash';
import * as modelAction from './sample_collection_items.model.action';
import {ModelState} from '../model.state';
import {initialSampleCollectionItemsCollectionState} from './sample_collection_items.model.state';
import {SampleCollectionItemsModel} from './sample_collection_items.model';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Reducer used to handle actions related to model. This reducer is the only place in the entire application where the
 * state of the model can change.
 *
 * By default it returns a new state given the current state and an action. The new state is produced by Immer, and
 * thus will be frozen after returned. Any attempts to modify the state outside of the drafting stage will result in
 * errors.
 */
export function modelReducer(currentState: ModelState, action: Action): ModelState {

	// % protected region % [Add any additional reducer logic here] off begin
	// % protected region % [Add any additional reducer logic here] end

	const className = (action as modelAction.BaseSampleCollectionItemsAction).className;

	return produce(currentState, draft => {

		// % protected region % [Add any additional logic before handling the action here] off begin
		// % protected region % [Add any additional logic before handling the action here] end

		switch (action.type) {
			case modelAction.SampleCollectionItemsModelActionTypes.CREATE_SAMPLE_COLLECTION_ITEMS_OK:
				const createdModel = (action as modelAction.SampleCollectionItemsActionOK ).stateConfig.targetModel;

				// % protected region % [Add any additional CreateModelOK logic before main logic here] off begin
				// % protected region % [Add any additional CreateModelOK logic before main logic here] end

				SampleCollectionItemsModel.deepParse(createdModel).forEach(model => {
					draft[model.className].data[model.id] = _.assignWith(draft[model.className].data[model.id], model,
					(objValue, srcValue) => _.isUndefined(srcValue) ? objValue : srcValue);
				});

				// % protected region % [Add any additional logic before ending CreateModelOK action here] off begin
				// % protected region % [Add any additional logic before ending CreateModelOK action here] end

				break;
			case modelAction.SampleCollectionItemsModelActionTypes.CREATE_SAMPLE_COLLECTION_ITEMS_FAIL:
				// TODO: Add handling of failure
				break;
			case modelAction.SampleCollectionItemsModelActionTypes.CREATE_ALL_SAMPLE_COLLECTION_ITEMS_OK:
				const createdModels = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.targetModels;
				const collectionIdAfterCreateAll = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.collectionId;

				// % protected region % [Add any additional CreateAllModelsOK logic before main logic here] off begin
				// % protected region % [Add any additional CreateAllModelsOK logic before main logic here] end

				createdModels.forEach((m) => {
					SampleCollectionItemsModel.deepParse(m).forEach(model => {
						draft[model.className].data[model.id] = _.assignWith(draft[model.className].data[model.id], model,
						(objValue, srcValue) => _.isUndefined(srcValue) ? objValue : srcValue);
					});
				});

				// % protected region % [Add any additional CreateAllModelsOK logic before collection logic here] off begin
				// % protected region % [Add any additional CreateAllModelsOK logic before collection logic here] end

				// Add Created Models to Collection if collection id is given
				if (collectionIdAfterCreateAll) {
					draft[className].collectionState[collectionIdAfterCreateAll].ids = _.union(
						draft[className].collectionState[collectionIdAfterCreateAll].ids,
						createdModels.map(model => model.id)
					);
				}

				// % protected region % [Add any additional logic before ending CreateAllModelsOK action here] off begin
				// % protected region % [Add any additional logic before ending CreateAllModelsOK action here] end

				break;
			case modelAction.SampleCollectionItemsModelActionTypes.CREATE_ALL_SAMPLE_COLLECTION_ITEMS_FAIL:
				// TODO: Add handling of failure
				break;
			case modelAction.SampleCollectionItemsModelActionTypes.DELETE_SAMPLE_COLLECTION_ITEMS_OK:
				const deletedModelId = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.targetModelId;
				const collectionIdAfterDelete = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.collectionId;

				// % protected region % [Add any additional DeleteModelOK logic before main logic here] off begin
				// % protected region % [Add any additional DeleteModelOK logic before main logic here] end

				delete draft[className].data[deletedModelId];

				// % protected region % [Add any additional DeleteModelOK logic before collection logic here] off begin
				// % protected region % [Add any additional DeleteModelOK logic before collection logic here] end

				// Loop to delete all collections and delete id
				Object.keys(draft[className].collectionState).forEach((collectionId) => {
					const ids = draft[className].collectionState[collectionId].ids;
					ids.splice(ids.indexOf(deletedModelId), 1);
					draft[className].collectionState[collectionId].ids = ids;
				});

				// % protected region % [Add any additional logic before ending DeleteModelOK action here] off begin
				// % protected region % [Add any additional logic before ending DeleteModelOK action here] end

				break;
			case modelAction.SampleCollectionItemsModelActionTypes.DELETE_ALL_SAMPLE_COLLECTION_ITEMS_OK:
				const deletedModelIds = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.targetModelIds;
				const collectionIdAfterDeleteAll = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.collectionId;

				// % protected region % [Add any additional DeleteModelAllOK logic before main logic here] off begin
				// % protected region % [Add any additional DeleteModelAllOK logic before main logic here] end

				deletedModelIds.forEach(id => delete draft[className].data[id]);

				// % protected region % [Add any additional DeleteModelAllOK logic before collection logic here] off begin
				// % protected region % [Add any additional DeleteModelAllOK logic before collection logic here] end

				if (collectionIdAfterDeleteAll) {
					const ids = draft[className].collectionState[collectionIdAfterDeleteAll].ids;
					deletedModelIds.forEach(id => ids.splice(ids.indexOf(id), 1));
				}

				// % protected region % [Add any additional logic before ending DeleteModelAllOK action here] off begin
				// % protected region % [Add any additional logic before ending DeleteModelAllOK action here] end

				break;
			case modelAction.SampleCollectionItemsModelActionTypes.DELETE_SAMPLE_COLLECTION_ITEMS_FAIL:
				// TODO: Add handling of failure
				break;
			case modelAction.SampleCollectionItemsModelActionTypes.UPDATE_SAMPLE_COLLECTION_ITEMS_OK:
				const updatedModel = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.targetModel;

				// % protected region % [Add any additional UpdateModelOK logic before main logic here] off begin
				// % protected region % [Add any additional UpdateModelOK logic before main logic here] end

				SampleCollectionItemsModel.deepParse(updatedModel).forEach(model => {
					draft[model.className].data[model.id] = _.assignWith(draft[model.className].data[model.id], model,
					(objValue, srcValue) => _.isUndefined(srcValue) ? objValue : srcValue);
				});

				// % protected region % [Add any additional logic before ending UpdateModelOK action here] off begin
				// % protected region % [Add any additional logic before ending UpdateModelOK action here] end

				break;
			case modelAction.SampleCollectionItemsModelActionTypes.UPDATE_SAMPLE_COLLECTION_ITEMS_FAIL:
				// TODO: Add handling of failure
				break;

			case modelAction.SampleCollectionItemsModelActionTypes.UPDATE_ALL_SAMPLE_COLLECTION_ITEMS_OK:
				const updatedModels = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.targetModels;
				const collectionIdAfterUpdateAll = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.collectionId;

				// % protected region % [Add any additional UpdateAllModelsOK logic before main logic here] off begin
				// % protected region % [Add any additional UpdateAllModelsOK logic before main logic here] end

				updatedModels.forEach((m) => {
					SampleCollectionItemsModel.deepParse(m).forEach(model => {
						draft[model.className].data[model.id] = _.assignWith(draft[model.className].data[model.id], model,
						(objValue, srcValue) => _.isUndefined(srcValue) ? objValue : srcValue);
					});
				});

				// % protected region % [Add any additional UpdateAllModelOK logic before collection logic here] off begin
				// % protected region % [Add any additional UpdateAllModelOK logic before collection logic here] end

				// Add Update Models to Collection if collection id is given
				if (collectionIdAfterUpdateAll) {
					draft[className].collectionState[collectionIdAfterUpdateAll].ids = _.union(
						draft[className].collectionState[collectionIdAfterUpdateAll].ids,
						updatedModels.map(model => model.id)
					);
				}

				// % protected region % [Add any additional logic before ending UpdateAllModelsOK action here] off begin
				// % protected region % [Add any additional logic before ending UpdateAllModelsOK action here] end

				break;
			case modelAction.SampleCollectionItemsModelActionTypes.UPDATE_ALL_SAMPLE_COLLECTION_ITEMS_FAIL:
				// TODO: Add handling of failure
				break;
			case modelAction.SampleCollectionItemsModelActionTypes.FETCH_SAMPLE_COLLECTION_ITEMS_OK:
				let fetchedModel = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.targetModel;

				// % protected region % [Add any additional FetchModelOK logic before main logic here] off begin
				// % protected region % [Add any additional FetchModelOK logic before main logic here] end

				SampleCollectionItemsModel.deepParse(fetchedModel).forEach(model => {
					draft[model.className].data[model.id] = _.assignWith(draft[model.className].data[model.id], model,
					(objValue, srcValue) => _.isUndefined(srcValue) ? objValue : srcValue);
				});

				// % protected region % [Add any additional logic before ending FetchModelOK action here] off begin
				// % protected region % [Add any additional logic before ending FetchModelOK action here] end

				break;
			case modelAction.SampleCollectionItemsModelActionTypes.FETCH_ALL_SAMPLE_COLLECTION_ITEMS_OK:
				const totalCountAfterFetchAll = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.collectionCount;
				const fetchedModelsAfterFetchAll = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.targetModels;
				const collectionIdAfterFetchAll = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.collectionId;
				const queryParamsAfterFetchAll = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.queryParams;

				// % protected region % [Add any additional FetchAllModelsOK logic before main logic here] off begin
				// % protected region % [Add any additional FetchAllModelsOK logic before main logic here] end

				_.flatten(fetchedModelsAfterFetchAll.map(model => SampleCollectionItemsModel.deepParse(model))).forEach(model => {
					draft[model.className].data[model.id] = _.assignWith(draft[model.className].data[model.id], model,
					(objValue, srcValue) => _.isUndefined(srcValue) ? objValue : srcValue);
				});

				// Need to check the collectionIdAfterFetchAll for fetch
				// Because we need to handle the use case, some code want to force update the data in the store
				// But they might not have matched component
				if (collectionIdAfterFetchAll) {
					// When select all, try to fetch all the data from the store
					draft[className].collectionState[collectionIdAfterFetchAll].ids = Object.keys(draft[className].data);
					draft[className].collectionState[collectionIdAfterFetchAll].queryParams = queryParamsAfterFetchAll;
					draft[className].collectionState[collectionIdAfterFetchAll].collectionCount = totalCountAfterFetchAll;
				}

				// % protected region % [Add any additional logic before ending FetchAllModelsOK action here] off begin
				// % protected region % [Add any additional logic before ending FetchAllModelsOK action here] end

				break;
			case modelAction.SampleCollectionItemsModelActionTypes.FETCH_SAMPLE_COLLECTION_ITEMS_AUDIT_OK:
				const audits = (action as modelAction.SampleCollectionItemsActionOK).audits;

				// % protected region % [Add any additional FetchModelAuditOK logic before main logic here] off begin
				// % protected region % [Add any additional FetchModelAuditOK logic before main logic here] end

				draft[className].audits = audits;

				// % protected region % [Add any additional logic before ending FetchModelAuditOK action here] off begin
				// % protected region % [Add any additional logic before ending FetchModelAuditOK action here] end

				break;
			case modelAction.SampleCollectionItemsModelActionTypes.FETCH_SAMPLE_COLLECTION_ITEMS_AUDITS_BY_ENTITY_ID_OK:
				const auditsByEntityId = (action as modelAction.SampleCollectionItemsActionOK).audits;

				// % protected region % [Add any additional FetchModelAuditsByEntityIdOK logic before main logic here] off begin
				// % protected region % [Add any additional FetchModelAuditsByEntityIdOK logic before main logic here] end

				draft[className].audits = auditsByEntityId;

				// % protected region % [Add any additional logic before ending FetchModelAuditsByEntityIdOK action here] off begin
				// % protected region % [Add any additional logic before ending FetchModelAuditsByEntityIdOK action here] end

				break;
			case modelAction.SampleCollectionItemsModelActionTypes.FETCH_SAMPLE_COLLECTION_ITEMS_WITH_QUERY_OK:
				const totalCountAfterFetchWithQuery = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.collectionCount;
				const fetchedModelsAfterFetchWithQuery = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.targetModels;
				const collectionIdAfterFetchWithQuery = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.collectionId;
				const queryParamsAfterFetchWithQuery = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.queryParams;

				// % protected region % [Add any additional FetchModelsWithQueryOK logic before main logic here] off begin
				// % protected region % [Add any additional FetchModelsWithQueryOK logic before main logic here] end

				_.flatten(fetchedModelsAfterFetchWithQuery.map(model => SampleCollectionItemsModel.deepParse(model))).forEach(model => {
					draft[model.className].data[model.id] = _.assignWith(draft[model.className].data[model.id], model,
					(objValue, srcValue) => _.isUndefined(srcValue) ? objValue : srcValue);
				});

				if (collectionIdAfterFetchWithQuery) {
					draft[className].collectionState[collectionIdAfterFetchWithQuery].ids = fetchedModelsAfterFetchWithQuery.map(model => model.id);
					draft[className].collectionState[collectionIdAfterFetchWithQuery].queryParams = queryParamsAfterFetchWithQuery;
					draft[className].collectionState[collectionIdAfterFetchWithQuery].collectionCount = totalCountAfterFetchWithQuery;
				}

				// % protected region % [Add any additional FetchModelsWithQueryOK logic after main logic here] off begin
				// % protected region % [Add any additional FetchModelsWithQueryOK logic after main logic here] end

				break;
			case modelAction.SampleCollectionItemsModelActionTypes.FETCH_LAST_SAMPLE_COLLECTION_ITEMS_WITH_QUERY_OK:
				const totalCountAfterFetchLastWithQuery = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.collectionCount;
				const fetchedModelsAfterFetchLastWithQuery = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.targetModels;
				const collectionIdAfterFetchLastWithQuery = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.collectionId;
				const queryParamsAfterFetchLastWithQuery = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.queryParams;

				// % protected region % [Add any additional FetchLastModelsWithQueryOK logic before main logic here] off begin
				// % protected region % [Add any additional FetchLastModelsWithQueryOK logic before main logic here] end

				_.flatten(fetchedModelsAfterFetchLastWithQuery.map(model => SampleCollectionItemsModel.deepParse(model))).forEach(model => {
					draft[model.className].data[model.id] = _.assignWith(draft[model.className].data[model.id], model,
					(objValue, srcValue) => _.isUndefined(srcValue) ? objValue : srcValue);
				});

				draft[className].collectionState[collectionIdAfterFetchLastWithQuery].ids = fetchedModelsAfterFetchLastWithQuery.map(model => model.id);
				draft[className].collectionState[collectionIdAfterFetchLastWithQuery].queryParams = queryParamsAfterFetchLastWithQuery;
				draft[className].collectionState[collectionIdAfterFetchLastWithQuery].collectionCount = totalCountAfterFetchLastWithQuery;

				// % protected region % [Add any additional FetchLastModelWithQueryOK logic after main logic here] off begin
				// % protected region % [Add any additional FetchLastModelWithQueryOK logic after main logic here] end

				break;
			case modelAction.SampleCollectionItemsModelActionTypes.COUNT_SAMPLE_COLLECTION_ITEMSS_OK:
				const totalCountAfterCount = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.totalCount;

				// % protected region % [Add any additional CountModelsOK logic before main logic here] off begin
				// % protected region % [Add any additional CountModelsOK logic before main logic here] end

				draft[className].totalCount = totalCountAfterCount;

				// % protected region % [Add any additional CountModelsOK logic after main logic here] off begin
				// % protected region % [Add any additional CountModelsOK logic after main logic here] end

				break;
			case modelAction.SampleCollectionItemsModelActionTypes.INITIALISE_SAMPLE_COLLECTION_ITEMS_COLLECTION_STATE:
				const collectionIdToInitialise =  (action as modelAction.SampleCollectionItemsActionOK).stateConfig.collectionId;
				const queryParamsToInitialise = (action as modelAction.SampleCollectionItemsActionOK).stateConfig.queryParams;

				// % protected region % [Add any additional InitialiseCollection logic before main logic here] off begin
				// % protected region % [Add any additional InitialiseCollection logic before main logic here] end

				if (!draft[className].collectionState[collectionIdToInitialise]) {
					draft[className].collectionState[collectionIdToInitialise] = {
						...initialSampleCollectionItemsCollectionState
					};
				}

				draft[className].collectionState[collectionIdToInitialise].queryParams = queryParamsToInitialise;

				// % protected region % [Add any additional InitializeCollection logic after main logic here] off begin
				// % protected region % [Add any additional InitializeCollection logic after main logic here] end

				break;
		}

		// % protected region % [Add any additional logic before ending the drafting stage here] off begin
		// % protected region % [Add any additional logic before ending the drafting stage here] end
	});
}

// % protected region % [Add any additional stuffs here] off begin
// % protected region % [Add any additional stuffs here] end
