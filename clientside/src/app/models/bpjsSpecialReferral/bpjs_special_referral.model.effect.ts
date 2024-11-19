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

import {Injectable} from '@angular/core';
import {Actions, createEffect, ofType} from '@ngrx/effects';
import {map, concatMap, catchError} from 'rxjs/operators';
import * as modelAction from './bpjs_special_referral.model.action';
import {BpjsSpecialReferralService} from '../../services/bpjsSpecialReferral/bpjs_special_referral.service';
import {BpjsSpecialReferralModel} from './bpjs_special_referral.model';
import * as _ from 'lodash';
import { of } from 'rxjs';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Effect class used for side effects related to BPJS Special Referral model.
 */
@Injectable()
export class BpjsSpecialReferralEffect {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		protected readonly action$: Actions,
		protected readonly service: BpjsSpecialReferralService,
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
	) {
		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	countModels = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for count models here] off begin
			// % protected region % [Add any additional operations before processing the actions for count models here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.COUNT_BPJS_SPECIAL_REFERRALS),

			// % protected region % [Add any additional operations before using the service for count models here] off begin
			// % protected region % [Add any additional operations before using the service for count models here] end

			concatMap((action) => {
				// % protected region % [Add any additional logic before fetching the models for count models here] off begin
				// % protected region % [Add any additional logic before fetching the models for count models here] end

				return this.service.count().pipe(
					// % protected region % [Add any additional handling before creating the action for count models here] off begin
					// % protected region % [Add any additional handling before creating the action for count models here] end

					map(stateConfig => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.COUNT_BPJS_SPECIAL_REFERRALS_OK,
						{
							...stateConfig,
							// % protected region % [Add any additional passable state config properties for count models here] off begin
							// % protected region % [Add any additional passable state config properties for count models here] end
						},
						// % protected region % [Add any additional constructor arguments for CountModelsOK here] off begin
						// % protected region % [Add any additional constructor arguments for CountModelsOK here] end
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions CountModelsOK here] off begin
						// % protected region % [Add any mapping for afterwards actions CountModelsOK here] end
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the action for count models here] off begin
					// % protected region % [Add any additional handling before returning the action for count models here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.COUNT_BPJS_SPECIAL_REFERRALS_FAIL,
								err
							)
						];
					}),
				);
			}),

			// % protected region % [Add any additional operations before dispatching the action for count models here] off begin
			// % protected region % [Add any additional operations before dispatching the action for count models here] end
		)
	);

	fetchedModel = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for fetchedModel here] off begin
			// % protected region % [Add any additional operations before processing the actions for fetchedModel here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.FETCH_BPJS_SPECIAL_REFERRAL),

			// % protected region % [Add any additional operations before using the service for fetchedModel here] off begin
			// % protected region % [Add any additional operations before using the service for fetchedModel here] end

			concatMap((action) => {
				const modelId = action.stateConfig.targetModelId;

				const queryParams = action.stateConfig.queryParams;

				// % protected region % [Add any additional logic before fetching the models for fetchedModel here] off begin
				// % protected region % [Add any additional logic before fetching the models for fetchedModel here] end

				return this.service.get(modelId, queryParams).pipe(
					// % protected region % [Add any additional handling before creating the action for fetchedModel here] off begin
					// % protected region % [Add any additional handling before creating the action for fetchedModel here] end

					map(stateConfig => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.FETCH_BPJS_SPECIAL_REFERRAL_OK,
						{
							...action.stateConfig,
							...stateConfig,
							// % protected region % [Add any additional passable state config properties here] off begin
							// % protected region % [Add any additional passable state config properties here] end
						},
						// % protected region % [Add any additional constructor arguments for FetchModelOK here] off begin
						// % protected region % [Add any additional constructor arguments for FetchModelOK here] end
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions FetchModelOK here] off begin
						// % protected region % [Add any mapping for afterwards actions FetchModelOK here] end

					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the action for fetchedModel here] off begin
					// % protected region % [Add any additional handling before returning the action for fetchedModel here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.FETCH_BPJS_SPECIAL_REFERRAL_FAIL,
								err,
								{
									targetModelId: modelId,
								}
							)
						];
					}),
				);
			}),

			// % protected region % [Add any additional operations before dispatching the action for fetchedModel here] off begin
			// % protected region % [Add any additional operations before dispatching the action for fetchedModel here] end
		)
	);

	fetchedModels = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for fetchedModels here] off begin
			// % protected region % [Add any additional operations before processing the actions for fetchedModels here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.FETCH_ALL_BPJS_SPECIAL_REFERRAL),

			// % protected region % [Add any additional operations before using the service for fetchedModels here] off begin
			// % protected region % [Add any additional operations before using the service for fetchedModels here] end

			concatMap((action) => {
				// % protected region % [Add any additional logic before fetching the models for fetchedModels here] off begin
				// % protected region % [Add any additional logic before fetching the models for fetchedModels here] end

				return this.service.getAll().pipe(
					// % protected region % [Add any additional handling before creating the action for fetchedModels here] off begin
					// % protected region % [Add any additional handling before creating the action for fetchedModels here] end

					map(stateConfig => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.FETCH_ALL_BPJS_SPECIAL_REFERRAL_OK,
						{
							...action.stateConfig,
							...stateConfig,
							// % protected region % [Add any additional passable state config properties for fetched models here] off begin
							// % protected region % [Add any additional passable state config properties for fetched models here] end
						},
						// % protected region % [Add any additional constructor arguments for FetchModelsOK here] off begin
						// % protected region % [Add any additional constructor arguments for FetchModelsOK here] end
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions FetchModelsOK here] off begin
						// % protected region % [Add any mapping for afterwards actions FetchModelsOK here] end
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the action for fetchedModels here] off begin
					// % protected region % [Add any additional handling before returning the action for fetchedModels here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.FETCH_ALL_BPJS_SPECIAL_REFERRAL_FAIL,
								err
							)
						];
					}),
				);
			}),

			// % protected region % [Add any additional operations before dispatching the action for fetchedModels here] off begin
			// % protected region % [Add any additional operations before dispatching the action for fetchedModels here] end
		)
	);

	fetchModelWithQuery = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for get models with query params here] off begin
			// % protected region % [Add any additional operations before processing the actions for get models with query params here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.FETCH_BPJS_SPECIAL_REFERRAL_WITH_QUERY),

			// % protected region % [Add any additional operations before using the service for get models with query params here] off begin
			// % protected region % [Add any additional operations before using the service for get models with query params here] end

			concatMap((action) => {
				const queryParams = action.stateConfig.queryParams;

				// % protected region % [Add any additional logic before fetching the models for getModels with queryParams here] off begin
				// % protected region % [Add any additional logic before fetching the models for getModels with queryParams here] end

				return this.service.getWithQuery(queryParams).pipe(
					// % protected region % [Add any additional handling before creating the action for get models with query params here] off begin
					// % protected region % [Add any additional handling before creating the action for get models with query params here] end

					map(stateConfig => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.FETCH_BPJS_SPECIAL_REFERRAL_WITH_QUERY_OK,
						{
							...action.stateConfig,
							...stateConfig,
							// % protected region % [Add any additional passable state config properties for get models with query params here] off begin
							// % protected region % [Add any additional passable state config properties for get models with query params here] end
						},
						// % protected region % [Add any additional constructor arguments for FetchModelWithQueryOK here] off begin
						// % protected region % [Add any additional constructor arguments for FetchModelWithQueryOK here] end
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions FetchModelWithQueryOK here] off begin
						// % protected region % [Add any mapping for afterwards actions FetchModelWithQueryOK here] end
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the action for get models with query params here] off begin
					// % protected region % [Add any additional handling before returning the action for get models with query params here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.FETCH_BPJS_SPECIAL_REFERRAL_WITH_QUERY_FAIL,
								err
							)
						];
					}),

				);
			}),

			// % protected region % [Add any additional operations before dispatching the action for get models with query params here] off begin
			// % protected region % [Add any additional operations before dispatching the action for get models with query params here] end
		)
	);

	fetchLastModelWithQuery = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for fetch last query params here] off begin
			// % protected region % [Add any additional operations before processing the actions for fetch last query params here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.FETCH_LAST_BPJS_SPECIAL_REFERRAL_WITH_QUERY),

			// % protected region % [Add any additional operations before using the service for fetch last query params here] off begin
			// % protected region % [Add any additional operations before using the service for fetch last query params here] end

			concatMap((action) => {
				const queryParams = action.stateConfig.queryParams;
				const collectionId = action.stateConfig.collectionId;

				// % protected region % [Add any additional logic before fetching the models for fetch last query params here] off begin
				// % protected region % [Add any additional logic before fetching the models for fetch last query params here] end

				return this.service.getLastWithQuery(queryParams).pipe(
					// % protected region % [Add any additional handling before creating the action for getLastModels with queryParams here] off begin
					// % protected region % [Add any additional handling before creating the action for getLastModels with queryParams here] end

					map(stateConfig => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.FETCH_LAST_BPJS_SPECIAL_REFERRAL_WITH_QUERY_OK,
						{
							...action.stateConfig,
							...stateConfig,
							// % protected region % [Add any additional passable state config properties for fetch last query params here] off begin
							// % protected region % [Add any additional passable state config properties for fetch last query params here] end
						},
						// % protected region % [Add any additional constructor arguments for FetchLastModelWithQueryOK here] off begin
						// % protected region % [Add any additional constructor arguments for FetchLastModelWithQueryOK here] end
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions FetchLastModelWithQueryOK here] off begin
						// % protected region % [Add any mapping for afterwards actions FetchLastModelWithQueryOK here] end
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the action for getLastModels with queryParams here here] off begin
					// % protected region % [Add any additional handling before returning the action for getLastModels with queryParams here here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.FETCH_LAST_BPJS_SPECIAL_REFERRAL_WITH_QUERY_FAIL,
								err
							)
						];
					}),

				);
			}),

			// % protected region % [Add any additional operations before dispatching the action for fetch last query params here] off begin
			// % protected region % [Add any additional operations before dispatching the action for fetch last query params here] end
		)
	);

	createdModel = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for createdModel here] off begin
			// % protected region % [Add any additional operations before processing the actions for createdModel here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.CREATE_BPJS_SPECIAL_REFERRAL),

			// % protected region % [Add any additional operations before using the service for createdModel here] off begin
			// % protected region % [Add any additional operations before using the service for createdModel here] end

			concatMap((action) => {
				const modelToBeCreated = action.stateConfig.targetModel as BpjsSpecialReferralModel;
				const collectionId = action.stateConfig.collectionId;
				const queryParams = action.stateConfig.queryParams;

				// % protected region % [Add any additional logic before createdModel here] off begin
				// % protected region % [Add any additional logic before createdModel here] end

				return this.service.create(modelToBeCreated, queryParams).pipe(
					// % protected region % [Add any additional handling before creating the action for createdModel here] off begin
					// % protected region % [Add any additional handling before creating the action for createdModel here] end

					map(stateConfig => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.CREATE_BPJS_SPECIAL_REFERRAL_OK,
						{
							...action.stateConfig,
							...stateConfig,
							// % protected region % [Add any extra passable state config properties for created model here] off begin
							// % protected region % [Add any extra passable state config properties for created model here] end
						},
						// % protected region % [Add any additional constructor arguments for CreateModelOK here] off begin
						// % protected region % [Add any additional constructor arguments for CreateModelOK here] end
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions CreateModelOK here] off begin
						// % protected region % [Add any mapping for afterwards actions CreateModelOK here] end
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the action for createdModel here] off begin
					// % protected region % [Add any additional handling before returning the action for createdModel here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.CREATE_BPJS_SPECIAL_REFERRAL_FAIL,
								err,
								{
									targetModel: modelToBeCreated,
								}
							)
						];
					}),
				);
			}),

			// % protected region % [Add any additional operations before dispatching the action for createdModel here] off begin
			// % protected region % [Add any additional operations before dispatching the action for createdModel here] end
		)
	);

	createAllModels = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for createAllModels here] off begin
			// % protected region % [Add any additional operations before processing the actions for createAllModels here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.CREATE_ALL_BPJS_SPECIAL_REFERRAL),

			// % protected region % [Add any additional operations before using the service for createAllModels here] off begin
			// % protected region % [Add any additional operations before using the service for createAllModels here] end

			concatMap((action) => {
				const modelsToCreate = action.stateConfig.targetModels as BpjsSpecialReferralModel[];
				const collectionId = action.stateConfig.collectionId;
				const queryParams = action.stateConfig.queryParams;

				// % protected region % [Add any additional logic before creatAllModels here] off begin
				// % protected region % [Add any additional logic before creatAllModels here] end

				return this.service.createAll(modelsToCreate, queryParams).pipe(
					// % protected region % [Add any additional handling before creating the action for createAllModes here] off begin
					// % protected region % [Add any additional handling before creating the action for createAllModes here] end

					map(stateConfig => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.CREATE_ALL_BPJS_SPECIAL_REFERRAL_OK,
						{
							...action.stateConfig,
							...stateConfig,
							// % protected region % [Add any extra passable state config properties for created models here] off begin
							// % protected region % [Add any extra passable state config properties for created models here] end
						},
						// % protected region % [Add any additional constructor arguments for CreateAllModelOK here] off begin
						// % protected region % [Add any additional constructor arguments for CreateAllModelOK here] end
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions CreateAllModelOK here] off begin
						// % protected region % [Add any mapping for afterwards actions CreateAllModelOK here] end
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the action for createAllModels here] off begin
					// % protected region % [Add any additional handling before returning the action for createAllModels here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.CREATE_ALL_BPJS_SPECIAL_REFERRAL_FAIL,
								err,
								{
									targetModels: modelsToCreate,
								}
							)
						];
					}),
				);
			}),

			// % protected region % [Add any additional operations after dispatching the action for createAllModels here] off begin
			// % protected region % [Add any additional operations after dispatching the action for createAllModels here] end
		)
	);

	updatedModel = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for updatedModel here] off begin
			// % protected region % [Add any additional operations before processing the actions for updatedModel here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.UPDATE_BPJS_SPECIAL_REFERRAL),

			// % protected region % [Add any additional operations before using the service for updatedModel here] off begin
			// % protected region % [Add any additional operations before using the service for updatedModel here] end

			concatMap((action) => {
				const modelToBeUpdated = action.stateConfig.targetModel as BpjsSpecialReferralModel;
				const updates = action.stateConfig.updates as object;
				const collectionId = action.stateConfig.collectionId;
				const queryParams = action.stateConfig.queryParams;

				// % protected region % [Add any additional logic before update the model here] off begin
				// % protected region % [Add any additional logic before update the model here] end

				return this.service.update(new BpjsSpecialReferralModel({
					...modelToBeUpdated,
					...updates
				}), queryParams).pipe(
					// % protected region % [Add any additional handling before creating the action for updatedModel here] off begin
					// % protected region % [Add any additional handling before creating the action for updatedModel here] end

					map(stateConfig => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.UPDATE_BPJS_SPECIAL_REFERRAL_OK,
						{
							...action.stateConfig,
							...stateConfig,
							// % protected region % [Add any extra passable state config properties for updated model here] off begin
							// % protected region % [Add any extra passable state config properties for updated model here] end
						},
						// % protected region % [Add any additional constructor arguments for UpdateModelOK here] off begin
						// % protected region % [Add any additional constructor arguments for UpdateModelOK here] end
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions UpdateModelOK here] off begin
						// % protected region % [Add any mapping for afterwards actions UpdateModelOK here] end
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the action for updatedModel here] off begin
					// % protected region % [Add any additional handling before returning the action for updatedModel here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.UPDATE_BPJS_SPECIAL_REFERRAL_FAIL,
								err,
								{
									targetModel: modelToBeUpdated,
								}
							)
						];
					}),
				);
			}),

			// % protected region % [Add any additional operations before dispatching the action for updatedModel here] off begin
			// % protected region % [Add any additional operations before dispatching the action for updatedModel here] end
		)
	);

	updateAllModels = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for updateAllModels here] off begin
			// % protected region % [Add any additional operations before processing the actions for updateAllModels here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.UPDATE_ALL_BPJS_SPECIAL_REFERRAL),

			// % protected region % [Add any additional operations before using the service for updateAllModels here] off begin
			// % protected region % [Add any additional operations before using the service for updateAllModels here] end

			concatMap((action) => {
				const modelsToUpdate = action.stateConfig.targetModels as BpjsSpecialReferralModel[];
				const updates = action.stateConfig.updates as object[];
				const updatedModels = _.zipWith(modelsToUpdate, updates, (targetModel, update) => new BpjsSpecialReferralModel({
					...targetModel,
					...update
				}));
				const queryParams = action.stateConfig.queryParams;

				// % protected region % [Add any additional logic before update all models here] off begin
				// % protected region % [Add any additional logic before update all models here] end

				return this.service.updateAll(updatedModels, queryParams).pipe(
					// % protected region % [Add any additional handling before creating the action for updateAllModels here] off begin
					// % protected region % [Add any additional handling before creating the action for updateAllModels here] end

					map(stateConfig => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.UPDATE_ALL_BPJS_SPECIAL_REFERRAL_OK,
						{
							...action.stateConfig,
							...stateConfig,
							// % protected region % [Add any extra passable state config properties for updated models here] off begin
							// % protected region % [Add any extra passable state config properties for updated models here] end
						},
						// % protected region % [Add any additional constructor arguments for UpdateAllModelsOk here] off begin
						// % protected region % [Add any additional constructor arguments for UpdateAllModelsOk here] end
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions UpdateAllModelsOk here] off begin
						// % protected region % [Add any mapping for afterwards actions UpdateAllModelsOk here] end
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the action for updateAllModels here] off begin
					// % protected region % [Add any additional handling before returning the action for updateAllModels here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.UPDATE_ALL_BPJS_SPECIAL_REFERRAL_FAIL,
								err,
								{
									targetModels: modelsToUpdate,
								}
							)
						];
					}),
				);
			}),

			// % protected region % [Add any additional operations before dispatching the action for updateAllModels here] off begin
			// % protected region % [Add any additional operations before dispatching the action for updateAllModels here] end
		)
	);

	deletedModel = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for deletedModel here] off begin
			// % protected region % [Add any additional operations before processing the actions for deletedModel here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.DELETE_BPJS_SPECIAL_REFERRAL),

			// % protected region % [Add any additional operations before using the service for deletedModel here] off begin
			// % protected region % [Add any additional operations before using the service for deletedModel here] end

			concatMap((action) => {
				const modelIdToBeDeleted = action.stateConfig.targetModelId;
				const collectionId = action.stateConfig.collectionId;
				const queryParams = action.stateConfig.queryParams;

				// % protected region % [Add any additional logic before delete the model here] off begin
				// % protected region % [Add any additional logic before delete the model here] end

				return this.service.delete(modelIdToBeDeleted).pipe(
					// % protected region % [Add any additional handling before creating the action for deletedModel here] off begin
					// % protected region % [Add any additional handling before creating the action for deletedModel here] end

					map(stateConfig => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.DELETE_BPJS_SPECIAL_REFERRAL_OK,
						{
							...action.stateConfig,
							...stateConfig,
							// % protected region % [Add any extra passable state config properties for deleted model here] off begin
							// % protected region % [Add any extra passable state config properties for deleted model here] end
						},
						// % protected region % [Add any additional constructor arguments for DeleteModelOK here] off begin
						// % protected region % [Add any additional constructor arguments for DeleteModelOK here] end
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions DeleteModelOK here] off begin
						// % protected region % [Add any mapping for afterwards actions DeleteModelOK here] end
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the action for deletedModel here] off begin
					// % protected region % [Add any additional handling before returning the action for deletedModel here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.DELETE_BPJS_SPECIAL_REFERRAL_FAIL,
								err,
								{
									targetModelId: modelIdToBeDeleted,
								}
							)
						];
					}),
				);
			}),

			// % protected region % [Add any additional operations before dispatching the action for deletedModel here] off begin
			// % protected region % [Add any additional operations before dispatching the action for deletedModel here] end
		)
	);

	deletedModelExcludingIds = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for deletedModelExcludingIds here] off begin
			// % protected region % [Add any additional operations before processing the actions for deletedModelExcludingIds here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.DELETE_BPJS_SPECIAL_REFERRAL_EXCLUDING_IDS),

			// % protected region % [Add any additional operations before using the service for deletedModelExcludingIds here] off begin
			// % protected region % [Add any additional operations before using the service for deletedModelExcludingIds here] end

			concatMap((action) => {
				const modelIdsToBeExcluded = action.stateConfig.targetModelIds;
				const collectionId = action.stateConfig.collectionId;
				const queryParams = action.stateConfig.queryParams;

				// % protected region % [Add any additional logic before deleting the models for deletedModelsExcludingIds here] off begin
				// % protected region % [Add any additional logic before deleting the models for deletedModelsExcludingIds here] end

				return this.service.deleteExcludingIds(modelIdsToBeExcluded).pipe(

					map(stateConfig => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.DELETE_BPJS_SPECIAL_REFERRAL_EXCLUDING_IDS_OK,
						{
							...action.stateConfig,
							...stateConfig,
							// % protected region % [Add any extra passable state config properties for deletedModelExcludingIds here] off begin
							// % protected region % [Add any extra passable state config properties for deletedModelExcludingIds here] end
						},
						// % protected region % [Add any additional constructor arguments for DeleteModelExcludingIdsOK here] off begin
						// % protected region % [Add any additional constructor arguments for DeleteModelExcludingIdsOK here] end
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions DeleteModelExcludingIdsOK here] off begin
						// % protected region % [Add any mapping for afterwards actions DeleteModelExcludingIdsOK here] end
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the action for deletedModelsExculdingIds here] off begin
					// % protected region % [Add any additional handling before returning the action for deletedModelsExculdingIds here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.DELETE_BPJS_SPECIAL_REFERRAL_EXCLUDING_IDS_FAIL,
								err,
								{
									targetModelIds: modelIdsToBeExcluded,
								}
							)
						];
					}),
				);
			}),

			// % protected region % [Add any additional operations before dispatching the action for deletedModelExcludingIds here] off begin
			// % protected region % [Add any additional operations before dispatching the action for deletedModelExcludingIds here] end
		)
	);

	deletedModels = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for deletedModels here] off begin
			// % protected region % [Add any additional operations before processing the actions for deletedModels here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.DELETE_ALL_BPJS_SPECIAL_REFERRAL),

			// % protected region % [Add any additional operations before using the service for deletedModels here] off begin
			// % protected region % [Add any additional operations before using the service for deletedModels here] end

			concatMap((action) => {
				const modelIdsToBeDeleted = action.stateConfig.targetModelIds;
				const collectionId = action.stateConfig.collectionId;
				const queryParams = action.stateConfig.queryParams;

				// % protected region % [Add any additional logic before delete the models for deletedModels here] off begin
				// % protected region % [Add any additional logic before delete the models for deletedModels here] end

				return this.service.deleteAll(modelIdsToBeDeleted).pipe(
					// % protected region % [Add any additional handling before creating the action for deletedModels here] off begin
					// % protected region % [Add any additional handling before creating the action for deletedModels here] end

					map(stateConfig => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.DELETE_ALL_BPJS_SPECIAL_REFERRAL_OK,
						{
							...action.stateConfig,
							...stateConfig,
							// % protected region % [Add any extra passable state config properties for deletedModels here] off begin
							// % protected region % [Add any extra passable state config properties for deletedModels here] end
						},
						// % protected region % [Add any additional constructor arguments for DeleteModelsOK here] off begin
						// % protected region % [Add any additional constructor arguments for DeleteModelsOK here] end
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions DeleteModelsOK here] off begin
						// % protected region % [Add any mapping for afterwards actions DeleteModelsOK here] end
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the action for deletedModels here] off begin
					// % protected region % [Add any additional handling before returning the action for deletedModels here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.DELETE_ALL_BPJS_SPECIAL_REFERRAL_FAIL,
								err,
								{
									targetModelIds: modelIdsToBeDeleted,
								}
							)
						];
					}),
				);
			}),

			// % protected region % [Add any additional operations before dispatching the action for deletedModels here] off begin
			// % protected region % [Add any additional operations before dispatching the action for deletedModels here] end
		)
	);

	exportedModel = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for exportedModel here] off begin
			// % protected region % [Add any additional operations before processing the actions for exportedModel here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.EXPORT_BPJS_SPECIAL_REFERRAL),

			// % protected region % [Add any additional operations before using the service for exportedModel here] off begin
			// % protected region % [Add any additional operations before using the service for exportedModel here] end

			concatMap((action) => {
				const modelIdToBeExported = action.stateConfig.targetModelId;

				// % protected region % [Add any additional logic before exporting the model for exportedModel here] off begin
				// % protected region % [Add any additional logic before exporting the model for exportedModel here] end

				return this.service.export(modelIdToBeExported).pipe(
					// % protected region % [Add any additional handling before creating the action for exportedModel here] off begin
					// % protected region % [Add any additional handling before creating the action for exportedModel here] end
					map(stateConfig => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.EXPORT_BPJS_SPECIAL_REFERRAL,
						{
							...action.stateConfig,
							...stateConfig,
							// % protected region % [Add any additional passable state config properties for exportedModel here] off begin
							// % protected region % [Add any additional passable state config properties for exportedModel here] end
						},
						// % protected region % [Add any additional constructor arguments for ExportModelOK here] off begin
						// % protected region % [Add any additional constructor arguments for ExportModelOK here] end
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions ExportModelOK here] off begin
						// % protected region % [Add any mapping for afterwards actions ExportModelOK here] end
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the actions for exportedModel here] off begin
					// % protected region % [Add any additional handling before returning the actions for exportedModel here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.EXPORT_BPJS_SPECIAL_REFERRAL,
								err,
								{
									targetModelId: modelIdToBeExported
								}
							)
						];
					}),
				);
			}),

			// % protected region % [Add any additional operations before dispatching the actions for exportedModel here] off begin
			// % protected region % [Add any additional operations before dispatching the actions for exportedModel here] end
		)
	);

	exportedModels = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for exportedModels here] off begin
			// % protected region % [Add any additional operations before processing the actions for exportedModels here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.EXPORT_ALL_BPJS_SPECIAL_REFERRAL),

			// % protected region % [Add any additional operations before using the service for exportedModels here] off begin
			// % protected region % [Add any additional operations before using the service for exportedModels here] end

			concatMap((action) => {
				const modelIdsToBeExported = action.stateConfig.targetModelIds;

				// % protected region % [Add any additional logic before exporting the model for exportedModels here] off begin
				// % protected region % [Add any additional logic before exporting the model for exportedModels here] end

				return this.service.exportAll(modelIdsToBeExported).pipe(
					// % protected region % [Add any additional handling before creating the action for exportedModels here] off begin
					// % protected region % [Add any additional handling before creating the action for exportedModels here] end
					map(stateConfig => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.EXPORT_ALL_BPJS_SPECIAL_REFERRAL_OK,
						{
							...action.stateConfig,
							...stateConfig,
							// % protected region % [Add any additional passable state config properties for exportedModels here] off begin
							// % protected region % [Add any additional passable state config properties for exportedModels here] end
						},
						// % protected region % [Add any additional constructor arguments for ExportModelsOK here] off begin
						// % protected region % [Add any additional constructor arguments for ExportModelsOK here] end
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions ExportModelsOK here] off begin
						// % protected region % [Add any mapping for afterwards actions ExportModelsOK here] end
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the actions for exportedModels here] off begin
					// % protected region % [Add any additional handling before returning the actions for exportedModels here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.EXPORT_ALL_BPJS_SPECIAL_REFERRAL_FAIL,
								err,
								{
									targetModelIds: modelIdsToBeExported,
								}
							)
						];
					}),
				);
			}),

			// % protected region % [Add any additional operations before dispatching the actions for exportedModels here] off begin
			// % protected region % [Add any additional operations before dispatching the actions for exportedModels here] end
		)
	);

	exportedModelsExcludingIds = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for exportedModelsExcludingIds here] off begin
			// % protected region % [Add any additional operations before processing the actions for exportedModelsExcludingIds here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.EXPORT_BPJS_SPECIAL_REFERRAL_EXCLUDING_IDS),

			// % protected region % [Add any additional operations before using the service for exportedModelsExcludingIds here] off begin
			// % protected region % [Add any additional operations before using the service for exportedModelsExcludingIds here] end

			concatMap((action) => {
				const modelIdsToBeExported = action.stateConfig.targetModelIds;

				// % protected region % [Add any additional logic before exporting the model for exportedModelsExcludingIds here] off begin
				// % protected region % [Add any additional logic before exporting the model for exportedModelsExcludingIds here] end

				return this.service.exportModelsExcludingIds(modelIdsToBeExported).pipe(
					// % protected region % [Add any additional handling before creating the action for exportedModelsExcludingIds here] off begin
					// % protected region % [Add any additional handling before creating the action for exportedModelsExcludingIds here] end
					map(stateConfig => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.EXPORT_BPJS_SPECIAL_REFERRAL_EXCLUDING_IDS_OK,
						{
							...action.stateConfig,
							...stateConfig,
							// % protected region % [Add any additional passable state config properties for exportedModelsExcludingIds here] off begin
							// % protected region % [Add any additional passable state config properties for exportedModelsExcludingIds here] end
						},
						// % protected region % [Add any additional constructor arguments for ExportModelsExcludingIdsOK here] off begin
						// % protected region % [Add any additional constructor arguments for ExportModelsExcludingIdsOK here] end
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions ExportModelsExcludingIdsOK here] off begin
						// % protected region % [Add any mapping for afterwards actions ExportModelsExcludingIdsOK here] end
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the actions for exportedModelsExcludingIds here] off begin
					// % protected region % [Add any additional handling before returning the actions for exportedModelsExcludingIds here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.EXPORT_BPJS_SPECIAL_REFERRAL_EXCLUDING_IDS_FAIL,
								err,
								{
									targetModelIds: modelIdsToBeExported,
								}
							)
						];
					}),
				);
			}),

			// % protected region % [Add any additional operations before dispatching the actions for exportedModelsExcludingIds here] off begin
			// % protected region % [Add any additional operations before dispatching the actions for exportedModelsExcludingIds here] end
		)
	);

	importModels = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for importModels here] off begin
			// % protected region % [Add any additional operations before processing the actions for importModels here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.IMPORT_BPJS_SPECIAL_REFERRALS),

			// % protected region % [Add any additional operations before using the service for importModels here] off begin
			// % protected region % [Add any additional operations before using the service for importModels here] end

			concatMap((action) => {
				const file = action.stateConfig.file;

				// % protected region % [Add any additional logic before exporting the model for importModels here] off begin
				// % protected region % [Add any additional logic before exporting the model for importModels here] end

				return this.service.importModels(file).pipe(
					// % protected region % [Add any additional handling before creating the action for importModels here] off begin
					// % protected region % [Add any additional handling before creating the action for importModels here] end
					map(stateConfig => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.IMPORT_BPJS_SPECIAL_REFERRALS_OK,
						{
							...action.stateConfig,
							...stateConfig,
							// % protected region % [Add any additional passable state config properties for importModels here] off begin
							// % protected region % [Add any additional passable state config properties for importModels here] end
						},
						// % protected region % [Add any additional constructor arguments for importModels here] off begin
						// % protected region % [Add any additional constructor arguments for importModels here] end
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions importModels here] off begin
						// % protected region % [Add any mapping for afterwards actions importModels here] end
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the actions for importModels here] off begin
					// % protected region % [Add any additional handling before returning the actions for importModels here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.IMPORT_BPJS_SPECIAL_REFERRALS_FAIL,
								err,
								{
									targetModelIds: [],
								}
							)
						];
					}),
				);
			}),

			// % protected region % [Add any additional operations before dispatching the actions for importModels here] off begin
			// % protected region % [Add any additional operations before dispatching the actions for importModels here] end
		)
	);

	fetchedAudits = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for fetchedAudits here] off begin
			// % protected region % [Add any additional operations before processing the actions for fetchedAudits here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.FETCH_BPJS_SPECIAL_REFERRAL_AUDIT),

			// % protected region % [Add any additional operations before using the service for fetchedAudits here] off begin
			// % protected region % [Add any additional operations before using the service for fetchedAudits here] end

			concatMap((action) => {
				// % protected region % [Add any additional logic before fetching the models for fetchedAudits here] off begin
				// % protected region % [Add any additional logic before fetching the models for fetchedAudits here] end

				return this.service.getAudits().pipe(
					// % protected region % [Add any additional handling before creating the action for fetchedAudits here] off begin
					// % protected region % [Add any additional handling before creating the action for fetchedAudits here] end

					map(audits => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.FETCH_BPJS_SPECIAL_REFERRAL_AUDIT_OK,
						of({}),
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions FetchAuditsOK here] off begin
						// % protected region % [Add any mapping for afterwards actions FetchAuditsOK here] end
						,
						// % protected region % [Add any additional constructor arguments for FetchAuditsOK here] off begin
						// % protected region % [Add any additional constructor arguments for FetchAuditsOK here] end
						audits
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the action for fetchedAudits here] off begin
					// % protected region % [Add any additional handling before returning the action for fetchedAudits here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.FETCH_BPJS_SPECIAL_REFERRAL_AUDIT_FAIL,
								err
							)
						];
					}),
				);
			}),

			// % protected region % [Add any additional operations before dispatching the action for getModels here] off begin
			// % protected region % [Add any additional operations before dispatching the action for getModels here] end
		)
	);

	fetchedAuditsByEntityId = createEffect(
		() => this.action$.pipe(
			// % protected region % [Add any additional operations before processing the actions for fetchedAuditsByEntityId here] off begin
			// % protected region % [Add any additional operations before processing the actions for fetchedAuditsByEntityId here] end

			ofType<modelAction.BpjsSpecialReferralAction>(modelAction.BpjsSpecialReferralModelActionTypes.FETCH_BPJS_SPECIAL_REFERRAL_AUDITS_BY_ENTITY_ID),

			// % protected region % [Add any additional operations before using the service for fetchedAuditsByEntityId here] off begin
			// % protected region % [Add any additional operations before using the service for fetchedAuditsByEntityId here] end

			concatMap((action) => {

				const entityId = action.stateConfig.targetModelId;
				// % protected region % [Add any additional logic before fetching the models for fetchedAuditsByEntityId here] off begin
				// % protected region % [Add any additional logic before fetching the models for fetchedAuditsByEntityId here] end

				return this.service.getAuditsByEntityId(entityId).pipe(
					// % protected region % [Add any additional handling before creating the action for fetchedAuditsByEntityId here] off begin
					// % protected region % [Add any additional handling before creating the action for fetchedAuditsByEntityId here] end

					map(audits => new modelAction.BpjsSpecialReferralActionOK(
						modelAction.BpjsSpecialReferralModelActionTypes.FETCH_BPJS_SPECIAL_REFERRAL_AUDITS_BY_ENTITY_ID_OK,
						of({}),
						action.afterwardActions
						// % protected region % [Add any mapping for afterwards actions FetchAuditsByEntityIdOK here] off begin
						// % protected region % [Add any mapping for afterwards actions FetchAuditsByEntityIdOK here] end
						,
						// % protected region % [Add any additional constructor arguments for FetchAuditsByEntityIdOK here] off begin
						// % protected region % [Add any additional constructor arguments for FetchAuditsByEntityIdOK here] end
						audits
					)),

					concatMap(innerAction => [
						innerAction,
						...innerAction.afterwardActions
					]),

					// % protected region % [Add any additional handling before returning the action for fetchedAuditsByEntityId here] off begin
					// % protected region % [Add any additional handling before returning the action for fetchedAuditsByEntityId here] end

					catchError((err) => {
						return [
							new modelAction.BpjsSpecialReferralActionFail(
								modelAction.BpjsSpecialReferralModelActionTypes.FETCH_BPJS_SPECIAL_REFERRAL_AUDITS_BY_ENTITY_ID_FAIL,
								err
							)
						];
					}),
				);
			}),

			// % protected region % [Add any additional operations before dispatching the action for fetchedAuditsByEntityId here] off begin
			// % protected region % [Add any additional operations before dispatching the action for fetchedAuditsByEntityId here] end
		)
	);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
