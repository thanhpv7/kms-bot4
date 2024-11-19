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
import {OperatingTheaterMedicalExaminationRecordModel} from '../../models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import {OperatingTheaterMedicalExaminationRecordModelAudit} from '../../models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.state';
import {AuthenticationService} from '../../lib/services/authentication/authentication.service';
import {QueryParams, PassableStateConfig} from '../../lib/services/http/interfaces';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import {DiagnosisNandaModel} from 'src/app/models/diagnosisNanda/diagnosis_nanda.model';
import {IntraoperativeRecordsModel} from 'src/app/models/intraoperativeRecords/intraoperative_records.model';
import {MedicalExaminationRecordModel} from 'src/app/models/medicalExaminationRecord/medical_examination_record.model';
import {PostOperativeDetailsModel} from 'src/app/models/postOperativeDetails/post_operative_details.model';
import {PreoperativeRecordsModel} from 'src/app/models/preoperativeRecords/preoperative_records.model';
import {StaffModel} from 'src/app/models/staff/staff.model';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Operating Theater Medical Examination Record service used to handle all CRUD operations against this entity.
 */
@Injectable({
	providedIn: 'root'
})
export class OperatingTheaterMedicalExaminationRecordService extends AbstractHttpService<OperatingTheaterMedicalExaminationRecordModel, OperatingTheaterMedicalExaminationRecordModelAudit> {
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
			# % protected region % [Modify the OperatingTheaterMedicalExaminationRecordProperties classFragment here] off begin
			fragment OperatingTheaterMedicalExaminationRecordProperties on OperatingTheaterMedicalExaminationRecord {
				...OperatingTheaterMedicalExaminationRecordBaseProperties
				hasConfirmedIdentity
				anesthesiaSafetyCheckCompleted
				pulseOxymeterFunctioning
				siteMarked
				hasKnownAllergy
				hasDifficultAirwayRisk
				hasRiskOfBloodLoss
				teamMemberIntroduced
				professionalConfirmedPatient
				antibioticProphylaxisGiven
				essentialImagingDisplayed
				whareAreCriticalSteps
				howLongCaseTake
				whatIsAnticipatedBloodLoss
				anyPatientSpecificConcerns
				sterlityBeenConfirmed
				equipmentIssuesAnyConcern
				nameOfProcedure
				instrumentsNeedCountCorrect
				specimenIsLabeled
				equipmentProblemsAddressed
				keyConcernsForRecovery
			}
			# % protected region % [Modify the OperatingTheaterMedicalExaminationRecordProperties classFragment here] end
			${super.fragments('OperatingTheaterMedicalExaminationRecord').properties}
		`,
		// % protected region % [Add any additional fragments here] off begin
		// % protected region % [Add any additional fragments here] end
	};

	/**
	 * @inheritDoc
	 */
	count(): Observable<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for count here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for count here] end

		return  this.apollo.query<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>>(
			{
				query: gql`
					query Count {
						totalCount: countOperatingTheaterMedicalExaminationRecords

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
	getAll(): Observable<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>> {
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
	get(id: string, queryParams?: QueryParams): Observable<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for get here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for get here] end

		const expands = queryParams && queryParams.expands ? queryParams.expands : [];

		return this.apollo.query<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>>(
			{
				query: gql`
					query Get($id: ID!) {
						OperatingTheaterMedicalExaminationRecordById: operatingTheaterMedicalExaminationRecordById(id: $id) {
							...OperatingTheaterMedicalExaminationRecordProperties
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
					targetModel: result.data.OperatingTheaterMedicalExaminationRecordById as OperatingTheaterMedicalExaminationRecordModel,
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
	getWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] end

		return this.apollo.query<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>>(
			{
				query: gql`
					query GetWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!], $where: [[Where!]!]) {
						operatingTheaterMedicalExaminationRecords: operatingTheaterMedicalExaminationRecords(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy, where: $where) {
							...OperatingTheaterMedicalExaminationRecordProperties
							${this.getExpands(queryParams.expands)}
						}

						totalCount: countOperatingTheaterMedicalExaminationRecords(where: $where)

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
					targetModels: result.data.operatingTheaterMedicalExaminationRecords as OperatingTheaterMedicalExaminationRecordModel[],
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
	getLastWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] end

		return this.apollo.query<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>>(
			{
				query: gql`
					query GetLastWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!]!) {
						operatingTheaterMedicalExaminationRecords: lastOperatingTheaterMedicalExaminationRecords(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy) {
							...OperatingTheaterMedicalExaminationRecordProperties
						}

						totalCount: countOperatingTheaterMedicalExaminationRecords

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
					targetModels: result.data.operatingTheaterMedicalExaminationRecords as OperatingTheaterMedicalExaminationRecordModel[],
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
	create(entity: OperatingTheaterMedicalExaminationRecordModel, queryParams?: QueryParams): Observable<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for create here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for create here] end

		// % protected region % [Customise the success message for create here] off begin
		const successMessage = 'Created Operating Theater Medical Examination Record entity successfully';
		// % protected region % [Customise the success message for create here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Create($operatingTheaterMedicalExaminationRecord: OperatingTheaterMedicalExaminationRecordInput!, $persistRelations: Boolean) {
						operatingTheaterMedicalExaminationRecord: createOperatingTheaterMedicalExaminationRecord(operatingTheaterMedicalExaminationRecord: $operatingTheaterMedicalExaminationRecord, persistRelations: $persistRelations) {
							...OperatingTheaterMedicalExaminationRecordProperties,
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
					operatingTheaterMedicalExaminationRecord: {
						...entity.toJSON(),
						medicalExaminationRecord: entity.medicalExaminationRecord ? new MedicalExaminationRecordModel(entity.medicalExaminationRecord).toJSON() : undefined,
						intraoperativeRecords: entity.intraoperativeRecords ? new IntraoperativeRecordsModel(entity.intraoperativeRecords).toJSON() : undefined,
						postOperativeDetails: entity.postOperativeDetails ? new PostOperativeDetailsModel(entity.postOperativeDetails).toJSON() : undefined,
						preoperativeRecords: entity.preoperativeRecords ? new PreoperativeRecordsModel(entity.preoperativeRecords).toJSON() : undefined,
						nursingAnesthesiaDetail: entity.nursingAnesthesiaDetail ? new DiagnosisNandaModel(entity.nursingAnesthesiaDetail).toJSON() : undefined,
						nursingDetailSurgicalNursings: entity.nursingDetailSurgicalNursings ? new StaffModel(entity.nursingDetailSurgicalNursings).toJSON() : undefined,
						nursingDetailsAnesthesiaNursings: entity.nursingDetailsAnesthesiaNursings ? new StaffModel(entity.nursingDetailsAnesthesiaNursings).toJSON() : undefined,
						nursingSurgicalDetail: entity.nursingSurgicalDetail ? new DiagnosisNandaModel(entity.nursingSurgicalDetail).toJSON() : undefined,
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
					targetModel: result.data.operatingTheaterMedicalExaminationRecord as OperatingTheaterMedicalExaminationRecordModel,
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
	createAll(entities: OperatingTheaterMedicalExaminationRecordModel[], queryParams?: QueryParams): Observable<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] end

		// % protected region % [Customise the success message for createAll here] off begin
		const successMessage = 'Created Multiple Operating Theater Medical Examination Record entities successfully';
		// % protected region % [Customise the success message for createAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation createAll($operatingTheaterMedicalExaminationRecords: [OperatingTheaterMedicalExaminationRecordInput!]!) {
						operatingTheaterMedicalExaminationRecord: createAllOperatingTheaterMedicalExaminationRecord(operatingTheaterMedicalExaminationRecords: $operatingTheaterMedicalExaminationRecords) {
							...OperatingTheaterMedicalExaminationRecordProperties,
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
					operatingTheaterMedicalExaminationRecords: entities.map(entity => entity.toJSON()),
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
					targetModels: result.data.operatingTheaterMedicalExaminationRecord as OperatingTheaterMedicalExaminationRecordModel[],
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
	update(entity: OperatingTheaterMedicalExaminationRecordModel, queryParams?: QueryParams): Observable<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for update here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for update here] end

		// % protected region % [Customise the success message for update here] off begin
		const successMessage = 'Updated Operating Theater Medical Examination Record entity successfully';
		// % protected region % [Customise the success message for update here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Update($operatingTheaterMedicalExaminationRecord: OperatingTheaterMedicalExaminationRecordInput!, $persistRelations: Boolean) {
						operatingTheaterMedicalExaminationRecord: updateOperatingTheaterMedicalExaminationRecord(operatingTheaterMedicalExaminationRecord: $operatingTheaterMedicalExaminationRecord, persistRelations: $persistRelations) {
							...OperatingTheaterMedicalExaminationRecordProperties,
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
					operatingTheaterMedicalExaminationRecord: {
						...entity.toJSON(),
						medicalExaminationRecord: entity.medicalExaminationRecord ? new MedicalExaminationRecordModel(entity.medicalExaminationRecord).toJSON() : undefined,
						intraoperativeRecords: entity.intraoperativeRecords ? new IntraoperativeRecordsModel(entity.intraoperativeRecords).toJSON() : undefined,
						postOperativeDetails: entity.postOperativeDetails ? new PostOperativeDetailsModel(entity.postOperativeDetails).toJSON() : undefined,
						preoperativeRecords: entity.preoperativeRecords ? new PreoperativeRecordsModel(entity.preoperativeRecords).toJSON() : undefined,
						nursingAnesthesiaDetail: entity.nursingAnesthesiaDetail ? new DiagnosisNandaModel(entity.nursingAnesthesiaDetail).toJSON() : undefined,
						nursingDetailSurgicalNursings: entity.nursingDetailSurgicalNursings ? new StaffModel(entity.nursingDetailSurgicalNursings).toJSON() : undefined,
						nursingDetailsAnesthesiaNursings: entity.nursingDetailsAnesthesiaNursings ? new StaffModel(entity.nursingDetailsAnesthesiaNursings).toJSON() : undefined,
						nursingSurgicalDetail: entity.nursingSurgicalDetail ? new DiagnosisNandaModel(entity.nursingSurgicalDetail).toJSON() : undefined,
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
					targetModel: result.data.operatingTheaterMedicalExaminationRecord as OperatingTheaterMedicalExaminationRecordModel,
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
	updateAll(entities: OperatingTheaterMedicalExaminationRecordModel[], queryParams?: QueryParams): Observable<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] end

		// % protected region % [Customise the success message for updateAll here] off begin
		const successMessage = 'Update Multiple Operating Theater Medical Examination Record entities successfully';
		// % protected region % [Customise the success message for updateAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation updateAll($operatingTheaterMedicalExaminationRecords: [OperatingTheaterMedicalExaminationRecordInput!]!) {
						operatingTheaterMedicalExaminationRecord: updateAllOperatingTheaterMedicalExaminationRecord(operatingTheaterMedicalExaminationRecords: $operatingTheaterMedicalExaminationRecords) {
							...OperatingTheaterMedicalExaminationRecordProperties,
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
					operatingTheaterMedicalExaminationRecords: entities.map(entity => entity.toJSON()),
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
					targetModels: result.data.operatingTheaterMedicalExaminationRecord as OperatingTheaterMedicalExaminationRecordModel[],
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
	delete(id: string): Observable<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete here] end

		// % protected region % [Customise the success message for delete here] off begin
		const successMessage = 'Deleted Operating Theater Medical Examination Record entity successfully';
		// % protected region % [Customise the success message for delete here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Delete($operatingTheaterMedicalExaminationRecordId: ID!) {
						operatingTheaterMedicalExaminationRecordId: deleteOperatingTheaterMedicalExaminationRecordById(operatingTheaterMedicalExaminationRecordId: $operatingTheaterMedicalExaminationRecordId)

						# % protected region % [Add any additional mutations for delete here] off begin
						# % protected region % [Add any additional mutations for delete here] end
					}

					# % protected region % [Add any additional GraphQL info for delete here] off begin
					# % protected region % [Add any additional GraphQL info for delete here] end
				`,
				variables: {
					operatingTheaterMedicalExaminationRecordId: id,
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
					targetModelId: result.data.operatingTheaterMedicalExaminationRecordId as string,
					// % protected region % [Add any additional info to be passed up for delete here] off begin
					// % protected region % [Add any additional info to be passed up for delete here] end
				};
			}),
			// % protected region % [Add any additional piping logic for delete here] off begin
			// % protected region % [Add any additional piping logic for delete here] end
		);
	}

	deleteExcludingIds(ids: string[]): Observable<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] end

		// % protected region % [Customise the success message for delete excluding here] off begin
		const successMessage = 'Deleted selected Operating Theater Medical Examination Record entities successfully';
		// % protected region % [Customise the success message for delete excluding here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation deleteAll($operatingTheaterMedicalExaminationRecordIds: [ID!]!){
						deleteOperatingTheaterMedicalExaminationRecordExcludingIds(operatingTheaterMedicalExaminationRecordIds: $operatingTheaterMedicalExaminationRecordIds)

						# % protected region % [Add any additional mutations for delete excluding here] off begin
						# % protected region % [Add any additional mutations for delete excluding here] end
					}

					# % protected region % [Add any additional GraphQL info for delete excluding here] off begin
					# % protected region % [Add any additional GraphQL info for delete excluding here] end
				`,
				variables: {
					operatingTheaterMedicalExaminationRecordIds: ids,
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
					targetModelIds: result.data.operatingTheaterMedicalExaminationRecordIds as string[],
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
	deleteAll(ids: string[]): Observable<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] end

		// % protected region % [Customise the success message for deleteAll here] off begin
		const successMessage = 'Deleted selected Operating Theater Medical Examination Record entities successfully';
		// % protected region % [Customise the success message for deleteAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation DeleteAll($operatingTheaterMedicalExaminationRecordIds: [ID!]!) {
						operatingTheaterMedicalExaminationRecordIds: deleteAllOperatingTheaterMedicalExaminationRecordByIds(operatingTheaterMedicalExaminationRecordIds: $operatingTheaterMedicalExaminationRecordIds)

						# % protected region % [Add any additional mutations for deleteAll here] off begin
						# % protected region % [Add any additional mutations for deleteAll here] end
					}

					# % protected region % [Add any additional GraphQL info for deleteAll here] off begin
					# % protected region % [Add any additional GraphQL info for deleteAll here] end
				`,
				variables: {
					operatingTheaterMedicalExaminationRecordIds: ids,
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
					targetModelIds: result.data.operatingTheaterMedicalExaminationRecordIds as string[],
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
	getAudits(): Observable<OperatingTheaterMedicalExaminationRecordModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] end

		return this.apollo.query<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>>(
			{
				query: gql`
					query GetAudits {
						audits: operatingTheaterMedicalExaminationRecordAudits {
							entity {
								...OperatingTheaterMedicalExaminationRecordProperties
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
				let audits: OperatingTheaterMedicalExaminationRecordModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new OperatingTheaterMedicalExaminationRecordModel(audit.entity),
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
	getAuditsByEntityId(id: string): Observable<OperatingTheaterMedicalExaminationRecordModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] end

		return this.apollo.query<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>>(
			{
				query: gql`
					query GetAuditsByEntityId($operatingTheaterMedicalExaminationRecordId: ID!) {
						audits: operatingTheaterMedicalExaminationRecordAuditsByEntityId(operatingTheaterMedicalExaminationRecordId: $operatingTheaterMedicalExaminationRecordId) {
							entity {
								...OperatingTheaterMedicalExaminationRecordProperties
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
					operatingTheaterMedicalExaminationRecordId: id,
					// % protected region % [Add any additional variables for getAuditsByEntityId here] off begin
					// % protected region % [Add any additional variables for getAuditsByEntityId here] end
				}
			}
		).pipe(
			map(result => {
				let audits: OperatingTheaterMedicalExaminationRecordModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new OperatingTheaterMedicalExaminationRecordModel(audit.entity),
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
	export(id: string): Observable<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>> {
		const url = environment.API_URL + '/api/operatingtheatermedicalexaminationrecord/export';
		const idParams = '?id=' + id;

		window.open(url + idParams);
		return of({
			targetModelId: id
		});
	}

	/**
	 * @inheritdoc
	 */
	exportAll(ids: string[]): Observable<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>> {
		const url = environment.API_URL + '/api/operatingtheatermedicalexaminationrecord/export';
		const idParams = '?ids=' + ids.join();

		window.open(url + idParams);

		return of({
			targetModelIds: ids
		});
	}

	exportModelsExcludingIds(ids: string[]): Observable<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>> {
		let apiUrl = environment.API_URL + '/api/operatingtheatermedicalexaminationrecord/export-excluding?ids=';

		if (ids.length > 0) {
			const idParams = ids.join();
			apiUrl = apiUrl.concat(idParams);
		}

		window.open(apiUrl);
		return of({
			targetModelIds: ids
		});
	}

	importModels(file: File): Observable<PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>> {
		const requestData: FormData = new FormData();
		requestData.append('file', file);

		let apiUrl = environment.API_URL + '/api/operatingtheatermedicalexaminationrecord/import-csv';

		// % protected region % [Overwrite the url of the import api here] off begin
		// % protected region % [Overwrite the url of the import api here] end

		return this.http.post(apiUrl, requestData, {withCredentials: true, responseType: 'text'}).pipe(
			tap(result => this.toastrService.success('Successfully Imported ' + result.split(',').length + ' Operating Theater Medical Examination Record entities')),

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
