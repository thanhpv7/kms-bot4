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
import {MedicalCertificateMentalHealthCollectionState, MedicalCertificateMentalHealthModelState} from './medical_certificate_mental_health.model.state';
import {MedicalCertificateMentalHealthModel} from './medical_certificate_mental_health.model';
import {ModelState} from '../model.state';
import {sortAndFilterByQueryParams} from '../../lib/models/model-utils';
import {QueryParams} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Given the current model state, select models that are of type Medical Certificate Mental Health.
 */
export const getMedicalCertificateMentalHealthModelState = createSelector(
	getModelState,
	(modelState: ModelState) => modelState.MedicalCertificateMentalHealthModel
);

/**
 * Given the current model state, select the total count of the models.
 */
export const getCountMedicalCertificateMentalHealthModels = createSelector(
	getMedicalCertificateMentalHealthModelState,
	(modelState: MedicalCertificateMentalHealthModelState) => modelState.totalCount
);

/**
 * Given the current model state, select the audits of all the entities.
 */
export const getMedicalCertificateMentalHealthModelAudits = createSelector(
	getMedicalCertificateMentalHealthModelState,
	(modelState: MedicalCertificateMentalHealthModelState) => modelState.audits
);

/**
 * Given the current model state, select the audits of this entity by entity id.
 */
export const getMedicalCertificateMentalHealthModelAuditsByEntityId = createSelector(
	getMedicalCertificateMentalHealthModelState,
	(modelState: MedicalCertificateMentalHealthModelState, entityId: string) => modelState.audits.filter(audit => audit.Entity.id === entityId)
);

/**
 * Given an ID, return the entity with the same ID in the central store.
 */
export const getMedicalCertificateMentalHealthModelWithId = createSelector(
	getMedicalCertificateMentalHealthModelState,
	(modelState: MedicalCertificateMentalHealthModelState, id: string) => modelState.data[id]
);

/**
 * Given the current model state, select data of the model that are of type Medical Certificate Mental Health by name.
 */
export const getMedicalCertificateMentalHealthModels = createSelector(
	getMedicalCertificateMentalHealthModelState,
	(modelState: MedicalCertificateMentalHealthModelState) => Object.values(modelState.data)
);

/**
 * Given the current model state, select data of the model and filter by the query.
 */
export const getMedicalCertificateMentalHealthModelDataWithQuery = createSelector(
	getMedicalCertificateMentalHealthModels,
	(modelData: MedicalCertificateMentalHealthModel[], queryParams: QueryParams) => sortAndFilterByQueryParams(modelData, queryParams)
);

/**
 * Given the current model state, select the state of specific collection by collection id
 * The collection id needs to be unique to avoid use the wrong collection
 */
export const getMedicalCertificateMentalHealthCollectionState = createSelector(
	getModelState,
	(modelState: ModelState, collectionId: string) => modelState.MedicalCertificateMentalHealthModel.collectionState[collectionId]
);

/**
 * Given the current model state, select the actual data of specific collection by ID
 */
export const getMedicalCertificateMentalHealthCollectionModels = createSelector(
	getMedicalCertificateMentalHealthModelState,
	getMedicalCertificateMentalHealthCollectionState,
	(modelState: MedicalCertificateMentalHealthModelState, collectionState: MedicalCertificateMentalHealthCollectionState) => collectionState.ids.map(id => modelState.data[id])
);

/**
 * Given the current model state, select the number of models of specific collection by ID
 */
export const getMedicalCertificateMentalHealthCollectionCount = createSelector(
	getMedicalCertificateMentalHealthCollectionState,
	(collectionState: MedicalCertificateMentalHealthCollectionState) => collectionState.collectionCount
);


// % protected region % [Add any additional selectors here] off begin
// % protected region % [Add any additional selectors here] end
