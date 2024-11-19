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
import {PreoperativeRecordsModel} from '../../models/preoperativeRecords/preoperative_records.model';
import {PreoperativeRecordsModelAudit} from '../../models/preoperativeRecords/preoperative_records.model.state';
import {AuthenticationService} from '../../lib/services/authentication/authentication.service';
import {QueryParams, PassableStateConfig} from '../../lib/services/http/interfaces';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import {BedFacilityModel} from 'src/app/models/bedFacility/bed_facility.model';
import {CoTreatingDoctorModel} from 'src/app/models/coTreatingDoctor/co_treating_doctor.model';
import {DiagnosesAndProceduresModel} from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import {OperatingTheaterMedicalExaminationRecordModel} from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import {RoomFacilityModel} from 'src/app/models/roomFacility/room_facility.model';
import {StaffModel} from 'src/app/models/staff/staff.model';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Preoperative Records service used to handle all CRUD operations against this entity.
 */
@Injectable({
	providedIn: 'root'
})
export class PreoperativeRecordsService extends AbstractHttpService<PreoperativeRecordsModel, PreoperativeRecordsModelAudit> {
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
			# % protected region % [Modify the PreoperativeRecordsProperties classFragment here] off begin
			fragment PreoperativeRecordsProperties on PreoperativeRecords {
				...PreoperativeRecordsBaseProperties
				startDateTime
				endDateTime
				physicalStatusEvaluation
				surgeryRisk
				psychologicalState
				anesthesiaSurgeryRisk
				preoperativeEvaluation
				anesthesiaNotes
				surgicalSpecialty
				antibioticProphylaxisGiven
				surgeryType
				surgeryClass
				surgicalSurgeryRisk
				physicalStatusClassification
				preSurgeryDiagnosis
				preoperativeInstructions
				preoperativeSurgicalNotes
			}
			# % protected region % [Modify the PreoperativeRecordsProperties classFragment here] end
			${super.fragments('PreoperativeRecords').properties}
		`,
		// % protected region % [Add any additional fragments here] off begin
		// % protected region % [Add any additional fragments here] end
	};

	/**
	 * @inheritDoc
	 */
	count(): Observable<PassableStateConfig<PreoperativeRecordsModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for count here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for count here] end

		return  this.apollo.query<PassableStateConfig<PreoperativeRecordsModel>>(
			{
				query: gql`
					query Count {
						totalCount: countPreoperativeRecordss

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
	getAll(): Observable<PassableStateConfig<PreoperativeRecordsModel>> {
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
	get(id: string, queryParams?: QueryParams): Observable<PassableStateConfig<PreoperativeRecordsModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for get here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for get here] end

		const expands = queryParams && queryParams.expands ? queryParams.expands : [];

		return this.apollo.query<PassableStateConfig<PreoperativeRecordsModel>>(
			{
				query: gql`
					query Get($id: ID!) {
						PreoperativeRecordsById: preoperativeRecordsById(id: $id) {
							...PreoperativeRecordsProperties
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
					targetModel: result.data.PreoperativeRecordsById as PreoperativeRecordsModel,
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
	getWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<PreoperativeRecordsModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] end

		return this.apollo.query<PassableStateConfig<PreoperativeRecordsModel>>(
			{
				query: gql`
					query GetWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!], $where: [[Where!]!]) {
						preoperativeRecordss: preoperativeRecordss(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy, where: $where) {
							...PreoperativeRecordsProperties
							${this.getExpands(queryParams.expands)}
						}

						totalCount: countPreoperativeRecordss(where: $where)

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
					targetModels: result.data.preoperativeRecordss as PreoperativeRecordsModel[],
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
	getLastWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<PreoperativeRecordsModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] end

		return this.apollo.query<PassableStateConfig<PreoperativeRecordsModel>>(
			{
				query: gql`
					query GetLastWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!]!) {
						preoperativeRecordss: lastPreoperativeRecordss(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy) {
							...PreoperativeRecordsProperties
						}

						totalCount: countPreoperativeRecordss

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
					targetModels: result.data.preoperativeRecordss as PreoperativeRecordsModel[],
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
	create(entity: PreoperativeRecordsModel, queryParams?: QueryParams): Observable<PassableStateConfig<PreoperativeRecordsModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for create here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for create here] end

		// % protected region % [Customise the success message for create here] off begin
		const successMessage = 'Created Preoperative Records entity successfully';
		// % protected region % [Customise the success message for create here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Create($preoperativeRecords: PreoperativeRecordsInput!, $persistRelations: Boolean) {
						preoperativeRecords: createPreoperativeRecords(preoperativeRecords: $preoperativeRecords, persistRelations: $persistRelations) {
							...PreoperativeRecordsProperties,
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
					preoperativeRecords: {
						...entity.toJSON(),
						operatingTheaterMedicalExaminationRecord: entity.operatingTheaterMedicalExaminationRecord ? new OperatingTheaterMedicalExaminationRecordModel(entity.operatingTheaterMedicalExaminationRecord).toJSON() : undefined,
						anesthesiaMedicalTranscriber: entity.anesthesiaMedicalTranscriber ? new StaffModel(entity.anesthesiaMedicalTranscriber).toJSON() : undefined,
						anesthesiologist: entity.anesthesiologist ? new StaffModel(entity.anesthesiologist).toJSON() : undefined,
						anesthesiologyNurse: entity.anesthesiologyNurse ? new StaffModel(entity.anesthesiologyNurse).toJSON() : undefined,
						preSurgeryICD10: entity.preSurgeryICD10 ? new DiagnosesAndProceduresModel(entity.preSurgeryICD10).toJSON() : undefined,
						preSurgeryICD9CM: entity.preSurgeryICD9CM ? new DiagnosesAndProceduresModel(entity.preSurgeryICD9CM).toJSON() : undefined,
						preoperativeRooms: entity.preoperativeRooms ? new RoomFacilityModel(entity.preoperativeRooms).toJSON() : undefined,
						surgeon: entity.surgeon ? new StaffModel(entity.surgeon).toJSON() : undefined,
						surgicalMedicalTranscriber: entity.surgicalMedicalTranscriber ? new StaffModel(entity.surgicalMedicalTranscriber).toJSON() : undefined,
						surgicalNurse: entity.surgicalNurse ? new StaffModel(entity.surgicalNurse).toJSON() : undefined,
						additionalAnesthesiologists: entity.additionalAnesthesiologists ? entity.additionalAnesthesiologists?.map((model: CoTreatingDoctorModel) => new CoTreatingDoctorModel(model).toJSON()) : [],
						additionalSurgeryNurses: entity.additionalSurgeryNurses ? entity.additionalSurgeryNurses?.map((model: CoTreatingDoctorModel) => new CoTreatingDoctorModel(model).toJSON()) : [],
						bedFacilities: entity.bedFacilities ? entity.bedFacilities?.map((model: BedFacilityModel) => new BedFacilityModel(model).toJSON()) : [],
						coTreatingAnesthesiologists: entity.coTreatingAnesthesiologists ? entity.coTreatingAnesthesiologists?.map((model: CoTreatingDoctorModel) => new CoTreatingDoctorModel(model).toJSON()) : [],
						coTreatingSurgeons: entity.coTreatingSurgeons ? entity.coTreatingSurgeons?.map((model: CoTreatingDoctorModel) => new CoTreatingDoctorModel(model).toJSON()) : [],
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
					targetModel: result.data.preoperativeRecords as PreoperativeRecordsModel,
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
	createAll(entities: PreoperativeRecordsModel[], queryParams?: QueryParams): Observable<PassableStateConfig<PreoperativeRecordsModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] end

		// % protected region % [Customise the success message for createAll here] off begin
		const successMessage = 'Created Multiple Preoperative Records entities successfully';
		// % protected region % [Customise the success message for createAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation createAll($preoperativeRecordss: [PreoperativeRecordsInput!]!) {
						preoperativeRecords: createAllPreoperativeRecords(preoperativeRecordss: $preoperativeRecordss) {
							...PreoperativeRecordsProperties,
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
					preoperativeRecordss: entities.map(entity => entity.toJSON()),
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
					targetModels: result.data.preoperativeRecords as PreoperativeRecordsModel[],
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
	update(entity: PreoperativeRecordsModel, queryParams?: QueryParams): Observable<PassableStateConfig<PreoperativeRecordsModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for update here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for update here] end

		// % protected region % [Customise the success message for update here] off begin
		const successMessage = 'Updated Preoperative Records entity successfully';
		// % protected region % [Customise the success message for update here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Update($preoperativeRecords: PreoperativeRecordsInput!, $persistRelations: Boolean) {
						preoperativeRecords: updatePreoperativeRecords(preoperativeRecords: $preoperativeRecords, persistRelations: $persistRelations) {
							...PreoperativeRecordsProperties,
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
					preoperativeRecords: {
						...entity.toJSON(),
						operatingTheaterMedicalExaminationRecord: entity.operatingTheaterMedicalExaminationRecord ? new OperatingTheaterMedicalExaminationRecordModel(entity.operatingTheaterMedicalExaminationRecord).toJSON() : undefined,
						anesthesiaMedicalTranscriber: entity.anesthesiaMedicalTranscriber ? new StaffModel(entity.anesthesiaMedicalTranscriber).toJSON() : undefined,
						anesthesiologist: entity.anesthesiologist ? new StaffModel(entity.anesthesiologist).toJSON() : undefined,
						anesthesiologyNurse: entity.anesthesiologyNurse ? new StaffModel(entity.anesthesiologyNurse).toJSON() : undefined,
						preSurgeryICD10: entity.preSurgeryICD10 ? new DiagnosesAndProceduresModel(entity.preSurgeryICD10).toJSON() : undefined,
						preSurgeryICD9CM: entity.preSurgeryICD9CM ? new DiagnosesAndProceduresModel(entity.preSurgeryICD9CM).toJSON() : undefined,
						preoperativeRooms: entity.preoperativeRooms ? new RoomFacilityModel(entity.preoperativeRooms).toJSON() : undefined,
						surgeon: entity.surgeon ? new StaffModel(entity.surgeon).toJSON() : undefined,
						surgicalMedicalTranscriber: entity.surgicalMedicalTranscriber ? new StaffModel(entity.surgicalMedicalTranscriber).toJSON() : undefined,
						surgicalNurse: entity.surgicalNurse ? new StaffModel(entity.surgicalNurse).toJSON() : undefined,
						additionalAnesthesiologists: entity.additionalAnesthesiologists ? entity.additionalAnesthesiologists?.map((model: CoTreatingDoctorModel) => new CoTreatingDoctorModel(model).toJSON()) : [],
						additionalSurgeryNurses: entity.additionalSurgeryNurses ? entity.additionalSurgeryNurses?.map((model: CoTreatingDoctorModel) => new CoTreatingDoctorModel(model).toJSON()) : [],
						bedFacilities: entity.bedFacilities ? entity.bedFacilities?.map((model: BedFacilityModel) => new BedFacilityModel(model).toJSON()) : [],
						coTreatingAnesthesiologists: entity.coTreatingAnesthesiologists ? entity.coTreatingAnesthesiologists?.map((model: CoTreatingDoctorModel) => new CoTreatingDoctorModel(model).toJSON()) : [],
						coTreatingSurgeons: entity.coTreatingSurgeons ? entity.coTreatingSurgeons?.map((model: CoTreatingDoctorModel) => new CoTreatingDoctorModel(model).toJSON()) : [],
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
					targetModel: result.data.preoperativeRecords as PreoperativeRecordsModel,
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
	updateAll(entities: PreoperativeRecordsModel[], queryParams?: QueryParams): Observable<PassableStateConfig<PreoperativeRecordsModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] end

		// % protected region % [Customise the success message for updateAll here] off begin
		const successMessage = 'Update Multiple Preoperative Records entities successfully';
		// % protected region % [Customise the success message for updateAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation updateAll($preoperativeRecordss: [PreoperativeRecordsInput!]!) {
						preoperativeRecords: updateAllPreoperativeRecords(preoperativeRecordss: $preoperativeRecordss) {
							...PreoperativeRecordsProperties,
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
					preoperativeRecordss: entities.map(entity => entity.toJSON()),
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
					targetModels: result.data.preoperativeRecords as PreoperativeRecordsModel[],
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
	delete(id: string): Observable<PassableStateConfig<PreoperativeRecordsModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete here] end

		// % protected region % [Customise the success message for delete here] off begin
		const successMessage = 'Deleted Preoperative Records entity successfully';
		// % protected region % [Customise the success message for delete here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Delete($preoperativeRecordsId: ID!) {
						preoperativeRecordsId: deletePreoperativeRecordsById(preoperativeRecordsId: $preoperativeRecordsId)

						# % protected region % [Add any additional mutations for delete here] off begin
						# % protected region % [Add any additional mutations for delete here] end
					}

					# % protected region % [Add any additional GraphQL info for delete here] off begin
					# % protected region % [Add any additional GraphQL info for delete here] end
				`,
				variables: {
					preoperativeRecordsId: id,
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
					targetModelId: result.data.preoperativeRecordsId as string,
					// % protected region % [Add any additional info to be passed up for delete here] off begin
					// % protected region % [Add any additional info to be passed up for delete here] end
				};
			}),
			// % protected region % [Add any additional piping logic for delete here] off begin
			// % protected region % [Add any additional piping logic for delete here] end
		);
	}

	deleteExcludingIds(ids: string[]): Observable<PassableStateConfig<PreoperativeRecordsModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] end

		// % protected region % [Customise the success message for delete excluding here] off begin
		const successMessage = 'Deleted selected Preoperative Records entities successfully';
		// % protected region % [Customise the success message for delete excluding here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation deleteAll($preoperativeRecordsIds: [ID!]!){
						deletePreoperativeRecordsExcludingIds(preoperativeRecordsIds: $preoperativeRecordsIds)

						# % protected region % [Add any additional mutations for delete excluding here] off begin
						# % protected region % [Add any additional mutations for delete excluding here] end
					}

					# % protected region % [Add any additional GraphQL info for delete excluding here] off begin
					# % protected region % [Add any additional GraphQL info for delete excluding here] end
				`,
				variables: {
					preoperativeRecordsIds: ids,
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
					targetModelIds: result.data.preoperativeRecordsIds as string[],
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
	deleteAll(ids: string[]): Observable<PassableStateConfig<PreoperativeRecordsModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] end

		// % protected region % [Customise the success message for deleteAll here] off begin
		const successMessage = 'Deleted selected Preoperative Records entities successfully';
		// % protected region % [Customise the success message for deleteAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation DeleteAll($preoperativeRecordsIds: [ID!]!) {
						preoperativeRecordsIds: deleteAllPreoperativeRecordsByIds(preoperativeRecordsIds: $preoperativeRecordsIds)

						# % protected region % [Add any additional mutations for deleteAll here] off begin
						# % protected region % [Add any additional mutations for deleteAll here] end
					}

					# % protected region % [Add any additional GraphQL info for deleteAll here] off begin
					# % protected region % [Add any additional GraphQL info for deleteAll here] end
				`,
				variables: {
					preoperativeRecordsIds: ids,
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
					targetModelIds: result.data.preoperativeRecordsIds as string[],
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
	getAudits(): Observable<PreoperativeRecordsModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] end

		return this.apollo.query<PassableStateConfig<PreoperativeRecordsModel>>(
			{
				query: gql`
					query GetAudits {
						audits: preoperativeRecordsAudits {
							entity {
								...PreoperativeRecordsProperties
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
				let audits: PreoperativeRecordsModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new PreoperativeRecordsModel(audit.entity),
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
	getAuditsByEntityId(id: string): Observable<PreoperativeRecordsModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] end

		return this.apollo.query<PassableStateConfig<PreoperativeRecordsModel>>(
			{
				query: gql`
					query GetAuditsByEntityId($preoperativeRecordsId: ID!) {
						audits: preoperativeRecordsAuditsByEntityId(preoperativeRecordsId: $preoperativeRecordsId) {
							entity {
								...PreoperativeRecordsProperties
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
					preoperativeRecordsId: id,
					// % protected region % [Add any additional variables for getAuditsByEntityId here] off begin
					// % protected region % [Add any additional variables for getAuditsByEntityId here] end
				}
			}
		).pipe(
			map(result => {
				let audits: PreoperativeRecordsModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new PreoperativeRecordsModel(audit.entity),
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
	export(id: string): Observable<PassableStateConfig<PreoperativeRecordsModel>> {
		const url = environment.API_URL + '/api/preoperativerecords/export';
		const idParams = '?id=' + id;

		window.open(url + idParams);
		return of({
			targetModelId: id
		});
	}

	/**
	 * @inheritdoc
	 */
	exportAll(ids: string[]): Observable<PassableStateConfig<PreoperativeRecordsModel>> {
		const url = environment.API_URL + '/api/preoperativerecords/export';
		const idParams = '?ids=' + ids.join();

		window.open(url + idParams);

		return of({
			targetModelIds: ids
		});
	}

	exportModelsExcludingIds(ids: string[]): Observable<PassableStateConfig<PreoperativeRecordsModel>> {
		let apiUrl = environment.API_URL + '/api/preoperativerecords/export-excluding?ids=';

		if (ids.length > 0) {
			const idParams = ids.join();
			apiUrl = apiUrl.concat(idParams);
		}

		window.open(apiUrl);
		return of({
			targetModelIds: ids
		});
	}

	importModels(file: File): Observable<PassableStateConfig<PreoperativeRecordsModel>> {
		const requestData: FormData = new FormData();
		requestData.append('file', file);

		let apiUrl = environment.API_URL + '/api/preoperativerecords/import-csv';

		// % protected region % [Overwrite the url of the import api here] off begin
		// % protected region % [Overwrite the url of the import api here] end

		return this.http.post(apiUrl, requestData, {withCredentials: true, responseType: 'text'}).pipe(
			tap(result => this.toastrService.success('Successfully Imported ' + result.split(',').length + ' Preoperative Records entities')),

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
