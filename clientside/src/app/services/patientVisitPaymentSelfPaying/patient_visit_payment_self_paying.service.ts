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
import {Router} from '@angular/router';
import {Observable, of} from 'rxjs';
import {map, tap} from 'rxjs/operators';
import {Apollo, gql} from 'apollo-angular';
import {ToastrService} from 'ngx-toastr';
import {AbstractHttpService} from '../../lib/services/http/abstract-http.service';
import {PatientVisitPaymentSelfPayingModel} from '../../models/patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model';
import {PatientVisitPaymentSelfPayingModelAudit} from '../../models/patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model.state';
import {AuthenticationService} from '../../lib/services/authentication/authentication.service';
import {QueryParams, PassableStateConfig} from '../../lib/services/http/interfaces';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import {PatientVisitModel} from 'src/app/models/patientVisit/patient_visit.model';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Patient Visit Payment Self Paying service used to handle all CRUD operations against this entity.
 */
@Injectable({
	providedIn: 'root'
})
export class PatientVisitPaymentSelfPayingService extends AbstractHttpService<PatientVisitPaymentSelfPayingModel, PatientVisitPaymentSelfPayingModelAudit> {
	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		apollo: Apollo,
		router: Router,
		authService: AuthenticationService,
		toastrService: ToastrService,
		http: HttpClient,
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
	) {
		super(
			apollo,
			router,
			authService,
			toastrService,
			http,
			// % protected region % [Add any additional constructor arguments here] off begin
			// % protected region % [Add any additional constructor arguments here] end
		);
		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * @inheritDoc
	 */
	protected readonly classFragments = {
		properties: gql`
			# % protected region % [Modify the PatientVisitPaymentSelfPayingProperties classFragment here] off begin
			fragment PatientVisitPaymentSelfPayingProperties on PatientVisitPaymentSelfPaying {
				...PatientVisitPaymentSelfPayingBaseProperties
				sponsorName
				sponsorAddress
				sponsorPhoneNo
				sponsorship
			}
			# % protected region % [Modify the PatientVisitPaymentSelfPayingProperties classFragment here] end
			${super.fragments('PatientVisitPaymentSelfPaying').properties}
		`,
		// % protected region % [Add any additional fragments here] off begin
		// % protected region % [Add any additional fragments here] end
	};

	/**
	 * @inheritDoc
	 */
	count(): Observable<PassableStateConfig<PatientVisitPaymentSelfPayingModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for count here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for count here] end

		return  this.apollo.query<PassableStateConfig<PatientVisitPaymentSelfPayingModel>>(
			{
				query: gql`
					query Count {
						totalCount: countPatientVisitPaymentSelfPayings

						# % protected region % [Add any additional queries for count here] off begin
						# % protected region % [Add any additional queries for count here] end
					}

					# % protected region % [Add any additional GraphQL info for count here] off begin
					# % protected region % [Add any additional GraphQL info for count here] end
				`,
				variables: {
					// % protected region % [Add any additional variables for count here] off begin
					// % protected region % [Add any additional variables for count here] end
				}
			}
		).pipe(
			map(result => {
				// % protected region % [Add any additional processing of the result for count here] off begin
				// % protected region % [Add any additional processing of the result for count here] end

				return {
					totalCount: result.data.totalCount as number,
					// % protected region % [Add any additional info to be passed up for count here] off begin
					// % protected region % [Add any additional info to be passed up for count here] end
				};
			}),
			// % protected region % [Add any additional piping logic for count here] off begin
			// % protected region % [Add any additional piping logic for count here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	getAll(): Observable<PassableStateConfig<PatientVisitPaymentSelfPayingModel>> {
		return this.getWithQuery({
			pageIndex: 0,
			pageSize: 10,
			orderBy: [
				{
					path: 'created',
					descending: true
				},
				// % protected region % [Add any additional orders here] off begin
				// % protected region % [Add any additional orders here] end
			]
		}).pipe(
			// % protected region % [Add any additional piping logic for getAll here] off begin
			// % protected region % [Add any additional piping logic for getAll here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	get(id: string, queryParams?: QueryParams): Observable<PassableStateConfig<PatientVisitPaymentSelfPayingModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for get here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for get here] end

		const expands = queryParams && queryParams.expands ? queryParams.expands : [];

		return this.apollo.query<PassableStateConfig<PatientVisitPaymentSelfPayingModel>>(
			{
				query: gql`
					query Get($id: ID!) {
						PatientVisitPaymentSelfPayingById: patientVisitPaymentSelfPayingById(id: $id) {
							...PatientVisitPaymentSelfPayingProperties
							${this.getExpands(expands)}
						}

						# % protected region % [Add any additional queries for get here] off begin
						# % protected region % [Add any additional queries for get here] end
					}

					# % protected region % [Add any additional GraphQL info for get here] off begin
					# % protected region % [Add any additional GraphQL info for get here] end

					${this.classFragments.properties}
				`,
				variables: {
					id: id,
					// % protected region % [Add any additional variables for get here] off begin
					// % protected region % [Add any additional variables for get here] end
				}
			}
		).pipe(
			map(result => {
				// % protected region % [Add any additional processing of the result for get here] off begin
				// % protected region % [Add any additional processing of the result for get here] end

				return {
					targetModelId: id,
					targetModel: result.data.PatientVisitPaymentSelfPayingById as PatientVisitPaymentSelfPayingModel,
					// % protected region % [Add any additional info to be passed up for get here] off begin
					// % protected region % [Add any additional info to be passed up for get here] end
				};
			}),
			// % protected region % [Add any additional piping logic for get here] off begin
			// % protected region % [Add any additional piping logic for get here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	getWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<PatientVisitPaymentSelfPayingModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] end

		return this.apollo.query<PassableStateConfig<PatientVisitPaymentSelfPayingModel>>(
			{
				query: gql`
					query GetWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!], $where: [[Where!]!]) {
						patientVisitPaymentSelfPayings: patientVisitPaymentSelfPayings(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy, where: $where) {
							...PatientVisitPaymentSelfPayingProperties
							${this.getExpands(queryParams.expands)}
						}

						totalCount: countPatientVisitPaymentSelfPayings(where: $where)

						# % protected region % [Add any additional queries for getWithQuery here] off begin
						# % protected region % [Add any additional queries for getWithQuery here] end
					}

					# % protected region % [Add any additional GraphQL info for getWithQuery here] off begin
					# % protected region % [Add any additional GraphQL info for getWithQuery here] end

					${this.classFragments.properties}
				`,
				variables: {
					pageIndex: queryParams.pageIndex,
					pageSize: queryParams.pageSize,
					orderBy: queryParams.orderBy || [],
					where: queryParams.where || [],
					// % protected region % [Add any additional variables for getWithQuery here] off begin
					// % protected region % [Add any additional variables for getWithQuery here] end
				}
			}
		).pipe(
			map(result => {
				// % protected region % [Add any additional processing of the result for getWithQuery here] off begin
				// % protected region % [Add any additional processing of the result for getWithQuery here] end

				return {
					collectionCount: result.data.totalCount,
					targetModels: result.data.patientVisitPaymentSelfPayings as PatientVisitPaymentSelfPayingModel[],
					queryParams: queryParams,
					// % protected region % [Add any additional info to be passed up for getWithQuery here] off begin
					// % protected region % [Add any additional info to be passed up for getWithQuery here] end
				};
			}),
			// % protected region % [Add any additional piping logic for getWithQuery here] off begin
			// % protected region % [Add any additional piping logic for getWithQuery here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	getLastWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<PatientVisitPaymentSelfPayingModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] end

		return this.apollo.query<PassableStateConfig<PatientVisitPaymentSelfPayingModel>>(
			{
				query: gql`
					query GetLastWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!]!) {
						patientVisitPaymentSelfPayings: lastPatientVisitPaymentSelfPayings(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy) {
							...PatientVisitPaymentSelfPayingProperties
						}

						totalCount: countPatientVisitPaymentSelfPayings

						# % protected region % [Add any additional queries for getLastWithQuery here] off begin
						# % protected region % [Add any additional queries for getLastWithQuery here] end
					}

					# % protected region % [Add any additional GraphQL info for getLastWithQuery here] off begin
					# % protected region % [Add any additional GraphQL info for getLastWithQuery here] end

					${this.classFragments.properties}
				`,
				variables: {
					pageIndex: queryParams.pageIndex,
					pageSize: queryParams.pageSize,
					orderBy: queryParams.orderBy || [],
					where: queryParams.where || [],
					// % protected region % [Add any additional variables for getLastWithQuery here] off begin
					// % protected region % [Add any additional variables for getLastWithQuery here] end
				}
			}
		).pipe(
			map(result => {
				// % protected region % [Add any additional processing of the result for getLastWithQuery here] off begin
				// % protected region % [Add any additional processing of the result for getLastWithQuery here] end

				return {
					totalCount: result.data.totalCount,
					targetModels: result.data.patientVisitPaymentSelfPayings as PatientVisitPaymentSelfPayingModel[],
					queryParams: queryParams,
					// % protected region % [Add any additional info to be passed up for getLastWithQuery here] off begin
					// % protected region % [Add any additional info to be passed up for getLastWithQuery here] end
				};
			}),
			// % protected region % [Add any additional piping logic for getLastWithQuery here] off begin
			// % protected region % [Add any additional piping logic for getLastWithQuery here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	create(entity: PatientVisitPaymentSelfPayingModel, queryParams?: QueryParams): Observable<PassableStateConfig<PatientVisitPaymentSelfPayingModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for create here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for create here] end

		// % protected region % [Customise the success message for create here] off begin
		const successMessage = 'Created Patient Visit Payment Self Paying entity successfully';
		// % protected region % [Customise the success message for create here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Create($patientVisitPaymentSelfPaying: PatientVisitPaymentSelfPayingInput!, $persistRelations: Boolean) {
						patientVisitPaymentSelfPaying: createPatientVisitPaymentSelfPaying(patientVisitPaymentSelfPaying: $patientVisitPaymentSelfPaying, persistRelations: $persistRelations) {
							...PatientVisitPaymentSelfPayingProperties,
							${this.getExpands(queryParams ? queryParams.expands : [])}
						}

						# % protected region % [Add any additional mutations for create here] off begin
						# % protected region % [Add any additional mutations for create here] end
				}

					# % protected region % [Add any additional GraphQL info for create here] off begin
					# % protected region % [Add any additional GraphQL info for create here] end

					${this.classFragments.properties}
				`,
				variables: {
					patientVisitPaymentSelfPaying: {
						...entity.toJSON(),
						patientVisit: entity.patientVisit ? new PatientVisitModel(entity.patientVisit).toJSON() : undefined,
					},
					persistRelations: queryParams ? queryParams.persistRelations : false,
					// % protected region % [Add any additional variables for create here] off begin
					// % protected region % [Add any additional variables for create here] end
				}
			},
		).pipe(
			tap(() => this.toastrService.success(successMessage)),
			map(result => {
				// % protected region % [Add any additional processing of the result for create here] off begin
				// % protected region % [Add any additional processing of the result for create here] end

				return {
					targetModel: result.data.patientVisitPaymentSelfPaying as PatientVisitPaymentSelfPayingModel,
					// % protected region % [Add any additional info to be passed up for create here] off begin
					// % protected region % [Add any additional info to be passed up for create here] end
				};
			}),
			// % protected region % [Add any additional piping logic for create here] off begin
			// % protected region % [Add any additional piping logic for create here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	createAll(entities: PatientVisitPaymentSelfPayingModel[], queryParams?: QueryParams): Observable<PassableStateConfig<PatientVisitPaymentSelfPayingModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] end

		// % protected region % [Customise the success message for createAll here] off begin
		const successMessage = 'Created Multiple Patient Visit Payment Self Paying entities successfully';
		// % protected region % [Customise the success message for createAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation createAll($patientVisitPaymentSelfPayings: [PatientVisitPaymentSelfPayingInput!]!) {
						patientVisitPaymentSelfPaying: createAllPatientVisitPaymentSelfPaying(patientVisitPaymentSelfPayings: $patientVisitPaymentSelfPayings) {
							...PatientVisitPaymentSelfPayingProperties,
							${this.getExpands(queryParams ? queryParams.expands : [])}
						}

						# % protected region % [Add any additional mutations for createAll here] off begin
						# % protected region % [Add any additional mutations for createAll here] end
					}

					# % protected region % [Add any additional GraphQL info for createAll here] off begin
					# % protected region % [Add any additional GraphQL info for createAll here] end

					${this.classFragments.properties}
				`,
				variables: {
					patientVisitPaymentSelfPayings: entities.map(entity => entity.toJSON()),
					// % protected region % [Add any additional variables for createAll here] off begin
					// % protected region % [Add any additional variables for createAll here] end
				}
			},
		).pipe(
			tap(() => this.toastrService.success(successMessage)),
			map(result => {
				// % protected region % [Add any additional processing of the result for createAll here] off begin
				// % protected region % [Add any additional processing of the result for createAll here] end

				return {
					targetModels: result.data.patientVisitPaymentSelfPaying as PatientVisitPaymentSelfPayingModel[],
					// % protected region % [Add any additional info to be passed up for createAll here] off begin
					// % protected region % [Add any additional info to be passed up for createAll here] end
				};
			}),
			// % protected region % [Add any additional piping logic for createAll here] off begin
			// % protected region % [Add any additional piping logic for createAll here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	update(entity: PatientVisitPaymentSelfPayingModel, queryParams?: QueryParams): Observable<PassableStateConfig<PatientVisitPaymentSelfPayingModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for update here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for update here] end

		// % protected region % [Customise the success message for update here] off begin
		const successMessage = 'Updated Patient Visit Payment Self Paying entity successfully';
		// % protected region % [Customise the success message for update here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Update($patientVisitPaymentSelfPaying: PatientVisitPaymentSelfPayingInput!, $persistRelations: Boolean) {
						patientVisitPaymentSelfPaying: updatePatientVisitPaymentSelfPaying(patientVisitPaymentSelfPaying: $patientVisitPaymentSelfPaying, persistRelations: $persistRelations) {
							...PatientVisitPaymentSelfPayingProperties,
							${this.getExpands(queryParams ? queryParams.expands : [])}
						}

						# % protected region % [Add any additional mutations for update here] off begin
						# % protected region % [Add any additional mutations for update here] end
					}

					# % protected region % [Add any additional GraphQL info for update here] off begin
					# % protected region % [Add any additional GraphQL info for update here] end

					${this.classFragments.properties}
				`,
				variables: {
					patientVisitPaymentSelfPaying: {
						...entity.toJSON(),
						patientVisit: entity.patientVisit ? new PatientVisitModel(entity.patientVisit).toJSON() : undefined,
					},
					persistRelations: queryParams ? queryParams.persistRelations : false,
					// % protected region % [Add any additional variables for update here] off begin
					// % protected region % [Add any additional variables for update here] end
				}
			}
		).pipe(
			tap(() => this.toastrService.success(successMessage)),
			map(result => {
				// % protected region % [Add any additional processing of the result for update here] off begin
				// % protected region % [Add any additional processing of the result for update here] end

				return {
					targetModel: result.data.patientVisitPaymentSelfPaying as PatientVisitPaymentSelfPayingModel,
					// % protected region % [Add any additional info to be passed up for update here] off begin
					// % protected region % [Add any additional info to be passed up for update here] end
				};
			}),
			// % protected region % [Add any additional piping logic for update here] off begin
			// % protected region % [Add any additional piping logic for update here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	updateAll(entities: PatientVisitPaymentSelfPayingModel[], queryParams?: QueryParams): Observable<PassableStateConfig<PatientVisitPaymentSelfPayingModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] end

		// % protected region % [Customise the success message for updateAll here] off begin
		const successMessage = 'Update Multiple Patient Visit Payment Self Paying entities successfully';
		// % protected region % [Customise the success message for updateAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation updateAll($patientVisitPaymentSelfPayings: [PatientVisitPaymentSelfPayingInput!]!) {
						patientVisitPaymentSelfPaying: updateAllPatientVisitPaymentSelfPaying(patientVisitPaymentSelfPayings: $patientVisitPaymentSelfPayings) {
							...PatientVisitPaymentSelfPayingProperties,
							${this.getExpands(queryParams ? queryParams.expands : [])}
						}

						# % protected region % [Add any additional mutations for updateAll here] off begin
						# % protected region % [Add any additional mutations for updateAll here] end
					}

					# % protected region % [Add any additional GraphQL info for updateAll here] off begin
					# % protected region % [Add any additional GraphQL info for updateAll here] end

					${this.classFragments.properties}
				`,
				variables: {
					patientVisitPaymentSelfPayings: entities.map(entity => entity.toJSON()),
					// % protected region % [Add any additional variables for updateAll here] off begin
					// % protected region % [Add any additional variables for updateAll here] end
				}
			},
		).pipe(
			tap(() => this.toastrService.success(successMessage)),
			map(result => {
				// % protected region % [Add any additional processing of the result for updateAll here] off begin
				// % protected region % [Add any additional processing of the result for updateAll here] end

				return {
					targetModels: result.data.patientVisitPaymentSelfPaying as PatientVisitPaymentSelfPayingModel[],
					// % protected region % [Add any additional info to be passed up for updateAll here] off begin
					// % protected region % [Add any additional info to be passed up for updateAll here] end
				};
			}),
			// % protected region % [Add any additional piping logic for updateAll here] off begin
			// % protected region % [Add any additional piping logic for updateAll here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	delete(id: string): Observable<PassableStateConfig<PatientVisitPaymentSelfPayingModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete here] end

		// % protected region % [Customise the success message for delete here] off begin
		const successMessage = 'Deleted Patient Visit Payment Self Paying entity successfully';
		// % protected region % [Customise the success message for delete here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Delete($patientVisitPaymentSelfPayingId: ID!) {
						patientVisitPaymentSelfPayingId: deletePatientVisitPaymentSelfPayingById(patientVisitPaymentSelfPayingId: $patientVisitPaymentSelfPayingId)

						# % protected region % [Add any additional mutations for delete here] off begin
						# % protected region % [Add any additional mutations for delete here] end
					}

					# % protected region % [Add any additional GraphQL info for delete here] off begin
					# % protected region % [Add any additional GraphQL info for delete here] end
				`,
				variables: {
					patientVisitPaymentSelfPayingId: id,
					// % protected region % [Add any additional variables for delete here] off begin
					// % protected region % [Add any additional variables for delete here] end
				}
			}
		).pipe(
			tap(() => this.toastrService.success(successMessage)),
			map(result => {
				// % protected region % [Add any additional processing of the result for delete here] off begin
				// % protected region % [Add any additional processing of the result for delete here] end

				return {
					targetModelId: result.data.patientVisitPaymentSelfPayingId as string,
					// % protected region % [Add any additional info to be passed up for delete here] off begin
					// % protected region % [Add any additional info to be passed up for delete here] end
				};
			}),
			// % protected region % [Add any additional piping logic for delete here] off begin
			// % protected region % [Add any additional piping logic for delete here] end
		);
	}

	deleteExcludingIds(ids: string[]): Observable<PassableStateConfig<PatientVisitPaymentSelfPayingModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] end

		// % protected region % [Customise the success message for delete excluding here] off begin
		const successMessage = 'Deleted selected Patient Visit Payment Self Paying entities successfully';
		// % protected region % [Customise the success message for delete excluding here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation deleteAll($patientVisitPaymentSelfPayingIds: [ID!]!){
						deletePatientVisitPaymentSelfPayingExcludingIds(patientVisitPaymentSelfPayingIds: $patientVisitPaymentSelfPayingIds)

						# % protected region % [Add any additional mutations for delete excluding here] off begin
						# % protected region % [Add any additional mutations for delete excluding here] end
					}

					# % protected region % [Add any additional GraphQL info for delete excluding here] off begin
					# % protected region % [Add any additional GraphQL info for delete excluding here] end
				`,
				variables: {
					patientVisitPaymentSelfPayingIds: ids,
					// % protected region % [Add any additional variables for delete excluding here] off begin
					// % protected region % [Add any additional variables for delete excluding here] end
				}
			}
		).pipe(
			tap(() => this.toastrService.success(successMessage)),
			map(result => {
				// % protected region % [Add any additionsl processing of the result for delete excluding here] off begin
				// % protected region % [Add any additionsl processing of the result for delete excluding here] end
				return {
					targetModelIds: result.data.patientVisitPaymentSelfPayingIds as string[],
					// % protected region % [Add any additional info to be passed up for delete excluding here] off begin
					// % protected region % [Add any additional info to be passed up for delete excluding here] end
				};
			}),
			// % protected region % [Add any additional piping logic for delete excluding here] off begin
			// % protected region % [Add any additional piping logic for delete excluding here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	deleteAll(ids: string[]): Observable<PassableStateConfig<PatientVisitPaymentSelfPayingModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] end

		// % protected region % [Customise the success message for deleteAll here] off begin
		const successMessage = 'Deleted selected Patient Visit Payment Self Paying entities successfully';
		// % protected region % [Customise the success message for deleteAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation DeleteAll($patientVisitPaymentSelfPayingIds: [ID!]!) {
						patientVisitPaymentSelfPayingIds: deleteAllPatientVisitPaymentSelfPayingByIds(patientVisitPaymentSelfPayingIds: $patientVisitPaymentSelfPayingIds)

						# % protected region % [Add any additional mutations for deleteAll here] off begin
						# % protected region % [Add any additional mutations for deleteAll here] end
					}

					# % protected region % [Add any additional GraphQL info for deleteAll here] off begin
					# % protected region % [Add any additional GraphQL info for deleteAll here] end
				`,
				variables: {
					patientVisitPaymentSelfPayingIds: ids,
					// % protected region % [Add any additional variables for deleteAll here] off begin
					// % protected region % [Add any additional variables for deleteAll here] end
				}
			}
		).pipe(
			tap(() => this.toastrService.success(successMessage)),
			map(result => {
				// % protected region % [Add any additional processing of the result for deleteAll here] off begin
				// % protected region % [Add any additional processing of the result for deleteAll here] end

				return {
					targetModelIds: result.data.patientVisitPaymentSelfPayingIds as string[],
					// % protected region % [Add any additional info to be passed up for deleteAll here] off begin
					// % protected region % [Add any additional info to be passed up for deleteAll here] end
				};
			}),
			// % protected region % [Add any additional piping logic for deleteAll here] off begin
			// % protected region % [Add any additional piping logic for deleteAll here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	getAudits(): Observable<PatientVisitPaymentSelfPayingModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] end

		return this.apollo.query<PassableStateConfig<PatientVisitPaymentSelfPayingModel>>(
			{
				query: gql`
					query GetAudits {
						audits: patientVisitPaymentSelfPayingAudits {
							entity {
								...PatientVisitPaymentSelfPayingProperties
							}
							timestamp
							type
							authorId
							authorFirstName
							authorLastName
						}

						# % protected region % [Add any additional queries for getAudits here] off begin
						# % protected region % [Add any additional queries for getAudits here] end
					}

					# % protected region % [Add any additional GraphQL info for getAudits here] off begin
					# % protected region % [Add any additional GraphQL info for getAudits here] end

					${this.classFragments.properties}
				`,
				// % protected region % [Add any query configuration for getAudits here] off begin
				// % protected region % [Add any query configuration for getAudits here] end
			}
		).pipe(
			map(result => {
				let audits: PatientVisitPaymentSelfPayingModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new PatientVisitPaymentSelfPayingModel(audit.entity),
						timestamp: audit.timestamp,
						type: audit.type,
						authorId: audit.authorId,
						authorFirstName: audit.authorFirstName,
						authorLastName: audit.authorLastName
					};
				});

				// % protected region % [Add any additional processing of the audits here] off begin
				// % protected region % [Add any additional processing of the audits here] end

				return audits;
			}),
			// % protected region % [Add any additional piping logic for getAudits here] off begin
			// % protected region % [Add any additional piping logic for getAudits here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	getAuditsByEntityId(id: string): Observable<PatientVisitPaymentSelfPayingModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] end

		return this.apollo.query<PassableStateConfig<PatientVisitPaymentSelfPayingModel>>(
			{
				query: gql`
					query GetAuditsByEntityId($patientVisitPaymentSelfPayingId: ID!) {
						audits: patientVisitPaymentSelfPayingAuditsByEntityId(patientVisitPaymentSelfPayingId: $patientVisitPaymentSelfPayingId) {
							entity {
								...PatientVisitPaymentSelfPayingProperties
							}
							timestamp
							type
							authorId
							authorFirstName
							authorLastName
						}

						# % protected region % [Add any additional queries for getAuditsByEntityId here] off begin
						# % protected region % [Add any additional queries for getAuditsByEntityId here] end
					},

					# % protected region % [Add any additional GraphQL info for getAuditsByEntityId here] off begin
					# % protected region % [Add any additional GraphQL info for getAuditsByEntityId here] end

					${this.classFragments.properties},

				`,
				// % protected region % [Add any query configuration for getAuditsByEntityId here] off begin
				// % protected region % [Add any query configuration for getAuditsByEntityId here] end
				variables: {
					patientVisitPaymentSelfPayingId: id,
					// % protected region % [Add any additional variables for getAuditsByEntityId here] off begin
					// % protected region % [Add any additional variables for getAuditsByEntityId here] end
				}
			}
		).pipe(
			map(result => {
				let audits: PatientVisitPaymentSelfPayingModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new PatientVisitPaymentSelfPayingModel(audit.entity),
						timestamp: audit.timestamp,
						type: audit.type,
						authorId: audit.authorId,
						authorFirstName: audit.authorFirstName,
						authorLastName: audit.authorLastName
					};
				});

				// % protected region % [Add any additional processing of the audits of entity here] off begin
				// % protected region % [Add any additional processing of the audits of entity here] end

				return audits;
			}),
			// % protected region % [Add any additional piping logic for getAuditsByEntityId here] off begin
			// % protected region % [Add any additional piping logic for getAuditsByEntityId here] end
		);
	}

	/**
	 * @inheritdoc
	 */
	export(id: string): Observable<PassableStateConfig<PatientVisitPaymentSelfPayingModel>> {
		const url = environment.API_URL + '/api/patientvisitpaymentselfpaying/export';
		const idParams = '?id=' + id;

		window.open(url + idParams);
		return of({
			targetModelId: id
		});
	}

	/**
	 * @inheritdoc
	 */
	exportAll(ids: string[]): Observable<PassableStateConfig<PatientVisitPaymentSelfPayingModel>> {
		const url = environment.API_URL + '/api/patientvisitpaymentselfpaying/export';
		const idParams = '?ids=' + ids.join();

		window.open(url + idParams);

		return of({
			targetModelIds: ids
		});
	}

	exportModelsExcludingIds(ids: string[]): Observable<PassableStateConfig<PatientVisitPaymentSelfPayingModel>> {
		let apiUrl = environment.API_URL + '/api/patientvisitpaymentselfpaying/export-excluding?ids=';

		if (ids.length > 0) {
			const idParams = ids.join();
			apiUrl = apiUrl.concat(idParams);
		}

		window.open(apiUrl);
		return of({
			targetModelIds: ids
		});
	}

	importModels(file: File): Observable<PassableStateConfig<PatientVisitPaymentSelfPayingModel>> {
		const requestData: FormData = new FormData();
		requestData.append('file', file);

		let apiUrl = environment.API_URL + '/api/patientvisitpaymentselfpaying/import-csv';

		// % protected region % [Overwrite the url of the import api here] off begin
		// % protected region % [Overwrite the url of the import api here] end

		return this.http.post(apiUrl, requestData, {withCredentials: true, responseType: 'text'}).pipe(
			tap(result => this.toastrService.success('Successfully Imported ' + result.split(',').length + ' Patient Visit Payment Self Paying entities')),

			map(result => {
				return of({
					targetModelIds: result.split(',')
				});
			}),
		);
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}