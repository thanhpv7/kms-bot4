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
import {DiagnosesAndProceduresModel} from '../../models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import {DiagnosesAndProceduresModelAudit} from '../../models/diagnosesAndProcedures/diagnoses_and_procedures.model.state';
import {AuthenticationService} from '../../lib/services/authentication/authentication.service';
import {QueryParams, PassableStateConfig} from '../../lib/services/http/interfaces';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import {BpjsDiagnoseModel} from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model';
import {BpjsDiagnosePRBModel} from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model';
import {DailyCareCPPTModel} from 'src/app/models/dailyCareCPPT/daily_care_cppt.model';
import {DiagnosisExaminationRecordModel} from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model';
import {DiagnosisNandaModel} from 'src/app/models/diagnosisNanda/diagnosis_nanda.model';
import {Icd10Model} from 'src/app/models/icd10/icd_10.model';
import {Icd9CMModel} from 'src/app/models/icd9CM/icd_9_cm.model';
import {InvoiceModel} from 'src/app/models/invoice/invoice.model';
import {MedicalCertificateDischargeResumeModel} from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model';
import {PostOperativeDetailsModel} from 'src/app/models/postOperativeDetails/post_operative_details.model';
import {PreoperativeRecordsModel} from 'src/app/models/preoperativeRecords/preoperative_records.model';
import {RegistrationModel} from 'src/app/models/registration/registration.model';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Diagnoses and Procedures service used to handle all CRUD operations against this entity.
 */
@Injectable({
	providedIn: 'root'
})
export class DiagnosesAndProceduresService extends AbstractHttpService<DiagnosesAndProceduresModel, DiagnosesAndProceduresModelAudit> {
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
			# % protected region % [Modify the DiagnosesAndProceduresProperties classFragment here] off begin
			fragment DiagnosesAndProceduresProperties on DiagnosesAndProcedures {
				...DiagnosesAndProceduresBaseProperties
				itemType
				itemCode
				description
				notes
			}
			# % protected region % [Modify the DiagnosesAndProceduresProperties classFragment here] end
			${super.fragments('DiagnosesAndProcedures').properties}
		`,
		// % protected region % [Add any additional fragments here] off begin
		// % protected region % [Add any additional fragments here] end
	};

	/**
	 * @inheritDoc
	 */
	count(): Observable<PassableStateConfig<DiagnosesAndProceduresModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for count here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for count here] end

		return  this.apollo.query<PassableStateConfig<DiagnosesAndProceduresModel>>(
			{
				query: gql`
					query Count {
						totalCount: countDiagnosesAndProceduress

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
	getAll(): Observable<PassableStateConfig<DiagnosesAndProceduresModel>> {
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
	get(id: string, queryParams?: QueryParams): Observable<PassableStateConfig<DiagnosesAndProceduresModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for get here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for get here] end

		const expands = queryParams && queryParams.expands ? queryParams.expands : [];

		return this.apollo.query<PassableStateConfig<DiagnosesAndProceduresModel>>(
			{
				query: gql`
					query Get($id: ID!) {
						DiagnosesAndProceduresById: diagnosesAndProceduresById(id: $id) {
							...DiagnosesAndProceduresProperties
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
					targetModel: result.data.DiagnosesAndProceduresById as DiagnosesAndProceduresModel,
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
	getWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<DiagnosesAndProceduresModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] end

		return this.apollo.query<PassableStateConfig<DiagnosesAndProceduresModel>>(
			{
				query: gql`
					query GetWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!], $where: [[Where!]!]) {
						diagnosesAndProceduress: diagnosesAndProceduress(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy, where: $where) {
							...DiagnosesAndProceduresProperties
							${this.getExpands(queryParams.expands)}
						}

						totalCount: countDiagnosesAndProceduress(where: $where)

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
					targetModels: result.data.diagnosesAndProceduress as DiagnosesAndProceduresModel[],
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
	getLastWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<DiagnosesAndProceduresModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] end

		return this.apollo.query<PassableStateConfig<DiagnosesAndProceduresModel>>(
			{
				query: gql`
					query GetLastWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!]!) {
						diagnosesAndProceduress: lastDiagnosesAndProceduress(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy) {
							...DiagnosesAndProceduresProperties
						}

						totalCount: countDiagnosesAndProceduress

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
					targetModels: result.data.diagnosesAndProceduress as DiagnosesAndProceduresModel[],
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
	create(entity: DiagnosesAndProceduresModel, queryParams?: QueryParams): Observable<PassableStateConfig<DiagnosesAndProceduresModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for create here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for create here] end

		// % protected region % [Customise the success message for create here] off begin
		const successMessage = 'Created Diagnoses and Procedures entity successfully';
		// % protected region % [Customise the success message for create here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Create($diagnosesAndProcedures: DiagnosesAndProceduresInput!, $persistRelations: Boolean) {
						diagnosesAndProcedures: createDiagnosesAndProcedures(diagnosesAndProcedures: $diagnosesAndProcedures, persistRelations: $persistRelations) {
							...DiagnosesAndProceduresProperties,
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
					diagnosesAndProcedures: {
						...entity.toJSON(),
						bpjsDiagnose: entity.bpjsDiagnose ? new BpjsDiagnoseModel(entity.bpjsDiagnose).toJSON() : undefined,
						bpjsDiagnosePRB: entity.bpjsDiagnosePRB ? new BpjsDiagnosePRBModel(entity.bpjsDiagnosePRB).toJSON() : undefined,
						masterICD10: entity.masterICD10 ? new Icd10Model(entity.masterICD10).toJSON() : undefined,
						masterICD9CM: entity.masterICD9CM ? new Icd9CMModel(entity.masterICD9CM).toJSON() : undefined,
						admissionICD10: entity.admissionICD10 ? entity.admissionICD10?.map((model: RegistrationModel) => new RegistrationModel(model).toJSON()) : [],
						admissionICD9CM: entity.admissionICD9CM ? entity.admissionICD9CM?.map((model: RegistrationModel) => new RegistrationModel(model).toJSON()) : [],
						cpptICD10: entity.cpptICD10 ? entity.cpptICD10?.map((model: DailyCareCPPTModel) => new DailyCareCPPTModel(model).toJSON()) : [],
						cpptICD9CM: entity.cpptICD9CM ? entity.cpptICD9CM?.map((model: DailyCareCPPTModel) => new DailyCareCPPTModel(model).toJSON()) : [],
						dischargeICD10: entity.dischargeICD10 ? entity.dischargeICD10?.map((model: MedicalCertificateDischargeResumeModel) => new MedicalCertificateDischargeResumeModel(model).toJSON()) : [],
						dischargeICD9CM: entity.dischargeICD9CM ? entity.dischargeICD9CM?.map((model: MedicalCertificateDischargeResumeModel) => new MedicalCertificateDischargeResumeModel(model).toJSON()) : [],
						icd10: entity.icd10 ? entity.icd10?.map((model: DiagnosisExaminationRecordModel) => new DiagnosisExaminationRecordModel(model).toJSON()) : [],
						icd9CM: entity.icd9CM ? entity.icd9CM?.map((model: DiagnosisExaminationRecordModel) => new DiagnosisExaminationRecordModel(model).toJSON()) : [],
						invoicesICD10: entity.invoicesICD10 ? entity.invoicesICD10?.map((model: InvoiceModel) => new InvoiceModel(model).toJSON()) : [],
						invoicesICD9CM: entity.invoicesICD9CM ? entity.invoicesICD9CM?.map((model: InvoiceModel) => new InvoiceModel(model).toJSON()) : [],
						postOperativeICD10: entity.postOperativeICD10 ? entity.postOperativeICD10?.map((model: PostOperativeDetailsModel) => new PostOperativeDetailsModel(model).toJSON()) : [],
						postOperativeICD9CM: entity.postOperativeICD9CM ? entity.postOperativeICD9CM?.map((model: PostOperativeDetailsModel) => new PostOperativeDetailsModel(model).toJSON()) : [],
						preSurgeryICD10: entity.preSurgeryICD10 ? entity.preSurgeryICD10?.map((model: PreoperativeRecordsModel) => new PreoperativeRecordsModel(model).toJSON()) : [],
						preSurgeryICD9CM: entity.preSurgeryICD9CM ? entity.preSurgeryICD9CM?.map((model: PreoperativeRecordsModel) => new PreoperativeRecordsModel(model).toJSON()) : [],
						diagnosisNandas: entity.diagnosisNandas ? entity.diagnosisNandas?.map((model: DiagnosisNandaModel) => new DiagnosisNandaModel(model).toJSON()) : [],
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
					targetModel: result.data.diagnosesAndProcedures as DiagnosesAndProceduresModel,
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
	createAll(entities: DiagnosesAndProceduresModel[], queryParams?: QueryParams): Observable<PassableStateConfig<DiagnosesAndProceduresModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] end

		// % protected region % [Customise the success message for createAll here] off begin
		const successMessage = 'Created Multiple Diagnoses and Procedures entities successfully';
		// % protected region % [Customise the success message for createAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation createAll($diagnosesAndProceduress: [DiagnosesAndProceduresInput!]!) {
						diagnosesAndProcedures: createAllDiagnosesAndProcedures(diagnosesAndProceduress: $diagnosesAndProceduress) {
							...DiagnosesAndProceduresProperties,
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
					diagnosesAndProceduress: entities.map(entity => entity.toJSON()),
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
					targetModels: result.data.diagnosesAndProcedures as DiagnosesAndProceduresModel[],
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
	update(entity: DiagnosesAndProceduresModel, queryParams?: QueryParams): Observable<PassableStateConfig<DiagnosesAndProceduresModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for update here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for update here] end

		// % protected region % [Customise the success message for update here] off begin
		const successMessage = 'Updated Diagnoses and Procedures entity successfully';
		// % protected region % [Customise the success message for update here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Update($diagnosesAndProcedures: DiagnosesAndProceduresInput!, $persistRelations: Boolean) {
						diagnosesAndProcedures: updateDiagnosesAndProcedures(diagnosesAndProcedures: $diagnosesAndProcedures, persistRelations: $persistRelations) {
							...DiagnosesAndProceduresProperties,
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
					diagnosesAndProcedures: {
						...entity.toJSON(),
						bpjsDiagnose: entity.bpjsDiagnose ? new BpjsDiagnoseModel(entity.bpjsDiagnose).toJSON() : undefined,
						bpjsDiagnosePRB: entity.bpjsDiagnosePRB ? new BpjsDiagnosePRBModel(entity.bpjsDiagnosePRB).toJSON() : undefined,
						masterICD10: entity.masterICD10 ? new Icd10Model(entity.masterICD10).toJSON() : undefined,
						masterICD9CM: entity.masterICD9CM ? new Icd9CMModel(entity.masterICD9CM).toJSON() : undefined,
						admissionICD10: entity.admissionICD10 ? entity.admissionICD10?.map((model: RegistrationModel) => new RegistrationModel(model).toJSON()) : [],
						admissionICD9CM: entity.admissionICD9CM ? entity.admissionICD9CM?.map((model: RegistrationModel) => new RegistrationModel(model).toJSON()) : [],
						cpptICD10: entity.cpptICD10 ? entity.cpptICD10?.map((model: DailyCareCPPTModel) => new DailyCareCPPTModel(model).toJSON()) : [],
						cpptICD9CM: entity.cpptICD9CM ? entity.cpptICD9CM?.map((model: DailyCareCPPTModel) => new DailyCareCPPTModel(model).toJSON()) : [],
						dischargeICD10: entity.dischargeICD10 ? entity.dischargeICD10?.map((model: MedicalCertificateDischargeResumeModel) => new MedicalCertificateDischargeResumeModel(model).toJSON()) : [],
						dischargeICD9CM: entity.dischargeICD9CM ? entity.dischargeICD9CM?.map((model: MedicalCertificateDischargeResumeModel) => new MedicalCertificateDischargeResumeModel(model).toJSON()) : [],
						icd10: entity.icd10 ? entity.icd10?.map((model: DiagnosisExaminationRecordModel) => new DiagnosisExaminationRecordModel(model).toJSON()) : [],
						icd9CM: entity.icd9CM ? entity.icd9CM?.map((model: DiagnosisExaminationRecordModel) => new DiagnosisExaminationRecordModel(model).toJSON()) : [],
						invoicesICD10: entity.invoicesICD10 ? entity.invoicesICD10?.map((model: InvoiceModel) => new InvoiceModel(model).toJSON()) : [],
						invoicesICD9CM: entity.invoicesICD9CM ? entity.invoicesICD9CM?.map((model: InvoiceModel) => new InvoiceModel(model).toJSON()) : [],
						postOperativeICD10: entity.postOperativeICD10 ? entity.postOperativeICD10?.map((model: PostOperativeDetailsModel) => new PostOperativeDetailsModel(model).toJSON()) : [],
						postOperativeICD9CM: entity.postOperativeICD9CM ? entity.postOperativeICD9CM?.map((model: PostOperativeDetailsModel) => new PostOperativeDetailsModel(model).toJSON()) : [],
						preSurgeryICD10: entity.preSurgeryICD10 ? entity.preSurgeryICD10?.map((model: PreoperativeRecordsModel) => new PreoperativeRecordsModel(model).toJSON()) : [],
						preSurgeryICD9CM: entity.preSurgeryICD9CM ? entity.preSurgeryICD9CM?.map((model: PreoperativeRecordsModel) => new PreoperativeRecordsModel(model).toJSON()) : [],
						diagnosisNandas: entity.diagnosisNandas ? entity.diagnosisNandas?.map((model: DiagnosisNandaModel) => new DiagnosisNandaModel(model).toJSON()) : [],
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
					targetModel: result.data.diagnosesAndProcedures as DiagnosesAndProceduresModel,
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
	updateAll(entities: DiagnosesAndProceduresModel[], queryParams?: QueryParams): Observable<PassableStateConfig<DiagnosesAndProceduresModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] end

		// % protected region % [Customise the success message for updateAll here] off begin
		const successMessage = 'Update Multiple Diagnoses and Procedures entities successfully';
		// % protected region % [Customise the success message for updateAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation updateAll($diagnosesAndProceduress: [DiagnosesAndProceduresInput!]!) {
						diagnosesAndProcedures: updateAllDiagnosesAndProcedures(diagnosesAndProceduress: $diagnosesAndProceduress) {
							...DiagnosesAndProceduresProperties,
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
					diagnosesAndProceduress: entities.map(entity => entity.toJSON()),
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
					targetModels: result.data.diagnosesAndProcedures as DiagnosesAndProceduresModel[],
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
	delete(id: string): Observable<PassableStateConfig<DiagnosesAndProceduresModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete here] end

		// % protected region % [Customise the success message for delete here] off begin
		const successMessage = 'Deleted Diagnoses and Procedures entity successfully';
		// % protected region % [Customise the success message for delete here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Delete($diagnosesAndProceduresId: ID!) {
						diagnosesAndProceduresId: deleteDiagnosesAndProceduresById(diagnosesAndProceduresId: $diagnosesAndProceduresId)

						# % protected region % [Add any additional mutations for delete here] off begin
						# % protected region % [Add any additional mutations for delete here] end
					}

					# % protected region % [Add any additional GraphQL info for delete here] off begin
					# % protected region % [Add any additional GraphQL info for delete here] end
				`,
				variables: {
					diagnosesAndProceduresId: id,
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
					targetModelId: result.data.diagnosesAndProceduresId as string,
					// % protected region % [Add any additional info to be passed up for delete here] off begin
					// % protected region % [Add any additional info to be passed up for delete here] end
				};
			}),
			// % protected region % [Add any additional piping logic for delete here] off begin
			// % protected region % [Add any additional piping logic for delete here] end
		);
	}

	deleteExcludingIds(ids: string[]): Observable<PassableStateConfig<DiagnosesAndProceduresModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] end

		// % protected region % [Customise the success message for delete excluding here] off begin
		const successMessage = 'Deleted selected Diagnoses and Procedures entities successfully';
		// % protected region % [Customise the success message for delete excluding here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation deleteAll($diagnosesAndProceduresIds: [ID!]!){
						deleteDiagnosesAndProceduresExcludingIds(diagnosesAndProceduresIds: $diagnosesAndProceduresIds)

						# % protected region % [Add any additional mutations for delete excluding here] off begin
						# % protected region % [Add any additional mutations for delete excluding here] end
					}

					# % protected region % [Add any additional GraphQL info for delete excluding here] off begin
					# % protected region % [Add any additional GraphQL info for delete excluding here] end
				`,
				variables: {
					diagnosesAndProceduresIds: ids,
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
					targetModelIds: result.data.diagnosesAndProceduresIds as string[],
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
	deleteAll(ids: string[]): Observable<PassableStateConfig<DiagnosesAndProceduresModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] end

		// % protected region % [Customise the success message for deleteAll here] off begin
		const successMessage = 'Deleted selected Diagnoses and Procedures entities successfully';
		// % protected region % [Customise the success message for deleteAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation DeleteAll($diagnosesAndProceduresIds: [ID!]!) {
						diagnosesAndProceduresIds: deleteAllDiagnosesAndProceduresByIds(diagnosesAndProceduresIds: $diagnosesAndProceduresIds)

						# % protected region % [Add any additional mutations for deleteAll here] off begin
						# % protected region % [Add any additional mutations for deleteAll here] end
					}

					# % protected region % [Add any additional GraphQL info for deleteAll here] off begin
					# % protected region % [Add any additional GraphQL info for deleteAll here] end
				`,
				variables: {
					diagnosesAndProceduresIds: ids,
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
					targetModelIds: result.data.diagnosesAndProceduresIds as string[],
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
	getAudits(): Observable<DiagnosesAndProceduresModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] end

		return this.apollo.query<PassableStateConfig<DiagnosesAndProceduresModel>>(
			{
				query: gql`
					query GetAudits {
						audits: diagnosesAndProceduresAudits {
							entity {
								...DiagnosesAndProceduresProperties
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
				let audits: DiagnosesAndProceduresModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new DiagnosesAndProceduresModel(audit.entity),
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
	getAuditsByEntityId(id: string): Observable<DiagnosesAndProceduresModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] end

		return this.apollo.query<PassableStateConfig<DiagnosesAndProceduresModel>>(
			{
				query: gql`
					query GetAuditsByEntityId($diagnosesAndProceduresId: ID!) {
						audits: diagnosesAndProceduresAuditsByEntityId(diagnosesAndProceduresId: $diagnosesAndProceduresId) {
							entity {
								...DiagnosesAndProceduresProperties
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
					diagnosesAndProceduresId: id,
					// % protected region % [Add any additional variables for getAuditsByEntityId here] off begin
					// % protected region % [Add any additional variables for getAuditsByEntityId here] end
				}
			}
		).pipe(
			map(result => {
				let audits: DiagnosesAndProceduresModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new DiagnosesAndProceduresModel(audit.entity),
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
	export(id: string): Observable<PassableStateConfig<DiagnosesAndProceduresModel>> {
		const url = environment.API_URL + '/api/diagnosesandprocedures/export';
		const idParams = '?id=' + id;

		window.open(url + idParams);
		return of({
			targetModelId: id
		});
	}

	/**
	 * @inheritdoc
	 */
	exportAll(ids: string[]): Observable<PassableStateConfig<DiagnosesAndProceduresModel>> {
		const url = environment.API_URL + '/api/diagnosesandprocedures/export';
		const idParams = '?ids=' + ids.join();

		window.open(url + idParams);

		return of({
			targetModelIds: ids
		});
	}

	exportModelsExcludingIds(ids: string[]): Observable<PassableStateConfig<DiagnosesAndProceduresModel>> {
		let apiUrl = environment.API_URL + '/api/diagnosesandprocedures/export-excluding?ids=';

		if (ids.length > 0) {
			const idParams = ids.join();
			apiUrl = apiUrl.concat(idParams);
		}

		window.open(apiUrl);
		return of({
			targetModelIds: ids
		});
	}

	importModels(file: File): Observable<PassableStateConfig<DiagnosesAndProceduresModel>> {
		const requestData: FormData = new FormData();
		requestData.append('file', file);

		let apiUrl = environment.API_URL + '/api/diagnosesandprocedures/import-csv';

		// % protected region % [Overwrite the url of the import api here] off begin
		// % protected region % [Overwrite the url of the import api here] end

		return this.http.post(apiUrl, requestData, {withCredentials: true, responseType: 'text'}).pipe(
			tap(result => this.toastrService.success('Successfully Imported ' + result.split(',').length + ' Diagnoses and Procedures entities')),

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
