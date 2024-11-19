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
import {PatientGeneralInfoModel} from '../../models/patientGeneralInfo/patient_general_info.model';
import {PatientGeneralInfoModelAudit} from '../../models/patientGeneralInfo/patient_general_info.model.state';
import {AuthenticationService} from '../../lib/services/authentication/authentication.service';
import {QueryParams, PassableStateConfig} from '../../lib/services/http/interfaces';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import {BpjsClaimSubmissionModel} from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import {CashReceiptModel} from 'src/app/models/cashReceipt/cash_receipt.model';
import {CashRefundModel} from 'src/app/models/cashRefund/cash_refund.model';
import {InformedConsentModel} from 'src/app/models/informedConsent/informed_consent.model';
import {PatientCaseHistoryModel} from 'src/app/models/patientCaseHistory/patient_case_history.model';
import {PatientConsentModel} from 'src/app/models/patientConsent/patient_consent.model';
import {PatientContactInfoModel} from 'src/app/models/patientContactInfo/patient_contact_info.model';
import {PatientDetailModel} from 'src/app/models/patientDetail/patient_detail.model';
import {PatientDetailAddressModel} from 'src/app/models/patientDetailAddress/patient_detail_address.model';
import {PatientEmergencyContactDetailModel} from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model';
import {PatientEmploymentDetailModel} from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model';
import {PatientPaymentSelfPayingModel} from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model';
import {PatientPaymentBPJSModel} from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model';
import {PatientPaymentInsuranceModel} from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model';
import {PatientPaymentOthersModel} from 'src/app/models/patientPaymentOthers/patient_payment_others.model';
import {PatientPersonalInfoModel} from 'src/app/models/patientPersonalInfo/patient_personal_info.model';
import {PatientSupportingDocumentModel} from 'src/app/models/patientSupportingDocument/patient_supporting_document.model';
import {PatientVisitModel} from 'src/app/models/patientVisit/patient_visit.model';
import {RetailPharmacyModel} from 'src/app/models/retailPharmacy/retail_pharmacy.model';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Patient General Info service used to handle all CRUD operations against this entity.
 */
@Injectable({
	providedIn: 'root'
})
export class PatientGeneralInfoService extends AbstractHttpService<PatientGeneralInfoModel, PatientGeneralInfoModelAudit> {
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
			# % protected region % [Modify the PatientGeneralInfoProperties classFragment here] off begin
			fragment PatientGeneralInfoProperties on PatientGeneralInfo {
				...PatientGeneralInfoBaseProperties
				patientID
				title
				givenName
				lastName
				placeOfBirth
				dateOfBirth
				gender
				address
				patientPaymentType
				importantNotes
				patientPicture {
					id
					created
					modified
					name
					size
					content
					url
				}
				hasOutstandingPayment
			}
			# % protected region % [Modify the PatientGeneralInfoProperties classFragment here] end
			${super.fragments('PatientGeneralInfo').properties}
		`,
		// % protected region % [Add any additional fragments here] off begin
		// % protected region % [Add any additional fragments here] end
	};

	/**
	 * @inheritDoc
	 */
	count(): Observable<PassableStateConfig<PatientGeneralInfoModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for count here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for count here] end

		return  this.apollo.query<PassableStateConfig<PatientGeneralInfoModel>>(
			{
				query: gql`
					query Count {
						totalCount: countPatientGeneralInfos

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
	getAll(): Observable<PassableStateConfig<PatientGeneralInfoModel>> {
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
	get(id: string, queryParams?: QueryParams): Observable<PassableStateConfig<PatientGeneralInfoModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for get here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for get here] end

		const expands = queryParams && queryParams.expands ? queryParams.expands : [];

		return this.apollo.query<PassableStateConfig<PatientGeneralInfoModel>>(
			{
				query: gql`
					query Get($id: ID!) {
						PatientGeneralInfoById: patientGeneralInfoById(id: $id) {
							...PatientGeneralInfoProperties
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
					targetModel: result.data.PatientGeneralInfoById as PatientGeneralInfoModel,
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
	getWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<PatientGeneralInfoModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] end

		return this.apollo.query<PassableStateConfig<PatientGeneralInfoModel>>(
			{
				query: gql`
					query GetWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!], $where: [[Where!]!]) {
						patientGeneralInfos: patientGeneralInfos(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy, where: $where) {
							...PatientGeneralInfoProperties
							${this.getExpands(queryParams.expands)}
						}

						totalCount: countPatientGeneralInfos(where: $where)

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
					targetModels: result.data.patientGeneralInfos as PatientGeneralInfoModel[],
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
	getLastWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<PatientGeneralInfoModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] end

		return this.apollo.query<PassableStateConfig<PatientGeneralInfoModel>>(
			{
				query: gql`
					query GetLastWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!]!) {
						patientGeneralInfos: lastPatientGeneralInfos(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy) {
							...PatientGeneralInfoProperties
						}

						totalCount: countPatientGeneralInfos

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
					targetModels: result.data.patientGeneralInfos as PatientGeneralInfoModel[],
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
	create(entity: PatientGeneralInfoModel, queryParams?: QueryParams): Observable<PassableStateConfig<PatientGeneralInfoModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for create here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for create here] end

		// % protected region % [Customise the success message for create here] off begin
		const successMessage = 'Created Patient General Info entity successfully';
		// % protected region % [Customise the success message for create here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Create($patientGeneralInfo: PatientGeneralInfoInput!, $persistRelations: Boolean) {
						patientGeneralInfo: createPatientGeneralInfo(patientGeneralInfo: $patientGeneralInfo, persistRelations: $persistRelations) {
							...PatientGeneralInfoProperties,
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
					patientGeneralInfo: {
						...entity.toJSON(),
						patientContactInformation: entity.patientContactInformation ? new PatientContactInfoModel(entity.patientContactInformation).toJSON() : undefined,
						patientDetailAddress: entity.patientDetailAddress ? new PatientDetailAddressModel(entity.patientDetailAddress).toJSON() : undefined,
						patientDetail: entity.patientDetail ? new PatientDetailModel(entity.patientDetail).toJSON() : undefined,
						patientEmergencyContactDetail: entity.patientEmergencyContactDetail ? new PatientEmergencyContactDetailModel(entity.patientEmergencyContactDetail).toJSON() : undefined,
						patientEmploymentDetail: entity.patientEmploymentDetail ? new PatientEmploymentDetailModel(entity.patientEmploymentDetail).toJSON() : undefined,
						patientPaymentBPJS: entity.patientPaymentBPJS ? new PatientPaymentBPJSModel(entity.patientPaymentBPJS).toJSON() : undefined,
						patientPaymentTypeInsurance: entity.patientPaymentTypeInsurance ? new PatientPaymentInsuranceModel(entity.patientPaymentTypeInsurance).toJSON() : undefined,
						patientPaymentTypeOthers: entity.patientPaymentTypeOthers ? new PatientPaymentOthersModel(entity.patientPaymentTypeOthers).toJSON() : undefined,
						patientPersonalInformation: entity.patientPersonalInformation ? new PatientPersonalInfoModel(entity.patientPersonalInformation).toJSON() : undefined,
						patientSelfPaying: entity.patientSelfPaying ? new PatientPaymentSelfPayingModel(entity.patientSelfPaying).toJSON() : undefined,
						bpjsClaimSubmissions: entity.bpjsClaimSubmissions ? entity.bpjsClaimSubmissions?.map((model: BpjsClaimSubmissionModel) => new BpjsClaimSubmissionModel(model).toJSON()) : [],
						cashRefunds: entity.cashRefunds ? entity.cashRefunds?.map((model: CashRefundModel) => new CashRefundModel(model).toJSON()) : [],
						informedConsents: entity.informedConsents ? entity.informedConsents?.map((model: InformedConsentModel) => new InformedConsentModel(model).toJSON()) : [],
						invoiceReceipts: entity.invoiceReceipts ? entity.invoiceReceipts?.map((model: CashReceiptModel) => new CashReceiptModel(model).toJSON()) : [],
						patientCaseHistories: entity.patientCaseHistories ? entity.patientCaseHistories?.map((model: PatientCaseHistoryModel) => new PatientCaseHistoryModel(model).toJSON()) : [],
						patientConsents: entity.patientConsents ? entity.patientConsents?.map((model: PatientConsentModel) => new PatientConsentModel(model).toJSON()) : [],
						patientFinalizeProfiles: entity.patientFinalizeProfiles ? entity.patientFinalizeProfiles?.map((model: PatientSupportingDocumentModel) => new PatientSupportingDocumentModel(model).toJSON()) : [],
						retailPharmacies: entity.retailPharmacies ? entity.retailPharmacies?.map((model: RetailPharmacyModel) => new RetailPharmacyModel(model).toJSON()) : [],
						visits: entity.visits ? entity.visits?.map((model: PatientVisitModel) => new PatientVisitModel(model).toJSON()) : [],
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
					targetModel: result.data.patientGeneralInfo as PatientGeneralInfoModel,
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
	createAll(entities: PatientGeneralInfoModel[], queryParams?: QueryParams): Observable<PassableStateConfig<PatientGeneralInfoModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] end

		// % protected region % [Customise the success message for createAll here] off begin
		const successMessage = 'Created Multiple Patient General Info entities successfully';
		// % protected region % [Customise the success message for createAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation createAll($patientGeneralInfos: [PatientGeneralInfoInput!]!) {
						patientGeneralInfo: createAllPatientGeneralInfo(patientGeneralInfos: $patientGeneralInfos) {
							...PatientGeneralInfoProperties,
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
					patientGeneralInfos: entities.map(entity => entity.toJSON()),
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
					targetModels: result.data.patientGeneralInfo as PatientGeneralInfoModel[],
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
	update(entity: PatientGeneralInfoModel, queryParams?: QueryParams): Observable<PassableStateConfig<PatientGeneralInfoModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for update here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for update here] end

		// % protected region % [Customise the success message for update here] off begin
		const successMessage = 'Updated Patient General Info entity successfully';
		// % protected region % [Customise the success message for update here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Update($patientGeneralInfo: PatientGeneralInfoInput!, $persistRelations: Boolean) {
						patientGeneralInfo: updatePatientGeneralInfo(patientGeneralInfo: $patientGeneralInfo, persistRelations: $persistRelations) {
							...PatientGeneralInfoProperties,
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
					patientGeneralInfo: {
						...entity.toJSON(),
						patientContactInformation: entity.patientContactInformation ? new PatientContactInfoModel(entity.patientContactInformation).toJSON() : undefined,
						patientDetailAddress: entity.patientDetailAddress ? new PatientDetailAddressModel(entity.patientDetailAddress).toJSON() : undefined,
						patientDetail: entity.patientDetail ? new PatientDetailModel(entity.patientDetail).toJSON() : undefined,
						patientEmergencyContactDetail: entity.patientEmergencyContactDetail ? new PatientEmergencyContactDetailModel(entity.patientEmergencyContactDetail).toJSON() : undefined,
						patientEmploymentDetail: entity.patientEmploymentDetail ? new PatientEmploymentDetailModel(entity.patientEmploymentDetail).toJSON() : undefined,
						patientPaymentBPJS: entity.patientPaymentBPJS ? new PatientPaymentBPJSModel(entity.patientPaymentBPJS).toJSON() : undefined,
						patientPaymentTypeInsurance: entity.patientPaymentTypeInsurance ? new PatientPaymentInsuranceModel(entity.patientPaymentTypeInsurance).toJSON() : undefined,
						patientPaymentTypeOthers: entity.patientPaymentTypeOthers ? new PatientPaymentOthersModel(entity.patientPaymentTypeOthers).toJSON() : undefined,
						patientPersonalInformation: entity.patientPersonalInformation ? new PatientPersonalInfoModel(entity.patientPersonalInformation).toJSON() : undefined,
						patientSelfPaying: entity.patientSelfPaying ? new PatientPaymentSelfPayingModel(entity.patientSelfPaying).toJSON() : undefined,
						bpjsClaimSubmissions: entity.bpjsClaimSubmissions ? entity.bpjsClaimSubmissions?.map((model: BpjsClaimSubmissionModel) => new BpjsClaimSubmissionModel(model).toJSON()) : [],
						cashRefunds: entity.cashRefunds ? entity.cashRefunds?.map((model: CashRefundModel) => new CashRefundModel(model).toJSON()) : [],
						informedConsents: entity.informedConsents ? entity.informedConsents?.map((model: InformedConsentModel) => new InformedConsentModel(model).toJSON()) : [],
						invoiceReceipts: entity.invoiceReceipts ? entity.invoiceReceipts?.map((model: CashReceiptModel) => new CashReceiptModel(model).toJSON()) : [],
						patientCaseHistories: entity.patientCaseHistories ? entity.patientCaseHistories?.map((model: PatientCaseHistoryModel) => new PatientCaseHistoryModel(model).toJSON()) : [],
						patientConsents: entity.patientConsents ? entity.patientConsents?.map((model: PatientConsentModel) => new PatientConsentModel(model).toJSON()) : [],
						patientFinalizeProfiles: entity.patientFinalizeProfiles ? entity.patientFinalizeProfiles?.map((model: PatientSupportingDocumentModel) => new PatientSupportingDocumentModel(model).toJSON()) : [],
						retailPharmacies: entity.retailPharmacies ? entity.retailPharmacies?.map((model: RetailPharmacyModel) => new RetailPharmacyModel(model).toJSON()) : [],
						visits: entity.visits ? entity.visits?.map((model: PatientVisitModel) => new PatientVisitModel(model).toJSON()) : [],
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
					targetModel: result.data.patientGeneralInfo as PatientGeneralInfoModel,
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
	updateAll(entities: PatientGeneralInfoModel[], queryParams?: QueryParams): Observable<PassableStateConfig<PatientGeneralInfoModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] end

		// % protected region % [Customise the success message for updateAll here] off begin
		const successMessage = 'Update Multiple Patient General Info entities successfully';
		// % protected region % [Customise the success message for updateAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation updateAll($patientGeneralInfos: [PatientGeneralInfoInput!]!) {
						patientGeneralInfo: updateAllPatientGeneralInfo(patientGeneralInfos: $patientGeneralInfos) {
							...PatientGeneralInfoProperties,
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
					patientGeneralInfos: entities.map(entity => entity.toJSON()),
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
					targetModels: result.data.patientGeneralInfo as PatientGeneralInfoModel[],
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
	delete(id: string): Observable<PassableStateConfig<PatientGeneralInfoModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete here] end

		// % protected region % [Customise the success message for delete here] off begin
		const successMessage = 'Deleted Patient General Info entity successfully';
		// % protected region % [Customise the success message for delete here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Delete($patientGeneralInfoId: ID!) {
						patientGeneralInfoId: deletePatientGeneralInfoById(patientGeneralInfoId: $patientGeneralInfoId)

						# % protected region % [Add any additional mutations for delete here] off begin
						# % protected region % [Add any additional mutations for delete here] end
					}

					# % protected region % [Add any additional GraphQL info for delete here] off begin
					# % protected region % [Add any additional GraphQL info for delete here] end
				`,
				variables: {
					patientGeneralInfoId: id,
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
					targetModelId: result.data.patientGeneralInfoId as string,
					// % protected region % [Add any additional info to be passed up for delete here] off begin
					// % protected region % [Add any additional info to be passed up for delete here] end
				};
			}),
			// % protected region % [Add any additional piping logic for delete here] off begin
			// % protected region % [Add any additional piping logic for delete here] end
		);
	}

	deleteExcludingIds(ids: string[]): Observable<PassableStateConfig<PatientGeneralInfoModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] end

		// % protected region % [Customise the success message for delete excluding here] off begin
		const successMessage = 'Deleted selected Patient General Info entities successfully';
		// % protected region % [Customise the success message for delete excluding here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation deleteAll($patientGeneralInfoIds: [ID!]!){
						deletePatientGeneralInfoExcludingIds(patientGeneralInfoIds: $patientGeneralInfoIds)

						# % protected region % [Add any additional mutations for delete excluding here] off begin
						# % protected region % [Add any additional mutations for delete excluding here] end
					}

					# % protected region % [Add any additional GraphQL info for delete excluding here] off begin
					# % protected region % [Add any additional GraphQL info for delete excluding here] end
				`,
				variables: {
					patientGeneralInfoIds: ids,
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
					targetModelIds: result.data.patientGeneralInfoIds as string[],
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
	deleteAll(ids: string[]): Observable<PassableStateConfig<PatientGeneralInfoModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] end

		// % protected region % [Customise the success message for deleteAll here] off begin
		const successMessage = 'Deleted selected Patient General Info entities successfully';
		// % protected region % [Customise the success message for deleteAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation DeleteAll($patientGeneralInfoIds: [ID!]!) {
						patientGeneralInfoIds: deleteAllPatientGeneralInfoByIds(patientGeneralInfoIds: $patientGeneralInfoIds)

						# % protected region % [Add any additional mutations for deleteAll here] off begin
						# % protected region % [Add any additional mutations for deleteAll here] end
					}

					# % protected region % [Add any additional GraphQL info for deleteAll here] off begin
					# % protected region % [Add any additional GraphQL info for deleteAll here] end
				`,
				variables: {
					patientGeneralInfoIds: ids,
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
					targetModelIds: result.data.patientGeneralInfoIds as string[],
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
	getAudits(): Observable<PatientGeneralInfoModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] end

		return this.apollo.query<PassableStateConfig<PatientGeneralInfoModel>>(
			{
				query: gql`
					query GetAudits {
						audits: patientGeneralInfoAudits {
							entity {
								...PatientGeneralInfoProperties
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
				let audits: PatientGeneralInfoModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new PatientGeneralInfoModel(audit.entity),
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
	getAuditsByEntityId(id: string): Observable<PatientGeneralInfoModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] end

		return this.apollo.query<PassableStateConfig<PatientGeneralInfoModel>>(
			{
				query: gql`
					query GetAuditsByEntityId($patientGeneralInfoId: ID!) {
						audits: patientGeneralInfoAuditsByEntityId(patientGeneralInfoId: $patientGeneralInfoId) {
							entity {
								...PatientGeneralInfoProperties
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
					patientGeneralInfoId: id,
					// % protected region % [Add any additional variables for getAuditsByEntityId here] off begin
					// % protected region % [Add any additional variables for getAuditsByEntityId here] end
				}
			}
		).pipe(
			map(result => {
				let audits: PatientGeneralInfoModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new PatientGeneralInfoModel(audit.entity),
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
	export(id: string): Observable<PassableStateConfig<PatientGeneralInfoModel>> {
		const url = environment.API_URL + '/api/patientgeneralinfo/export';
		const idParams = '?id=' + id;

		window.open(url + idParams);
		return of({
			targetModelId: id
		});
	}

	/**
	 * @inheritdoc
	 */
	exportAll(ids: string[]): Observable<PassableStateConfig<PatientGeneralInfoModel>> {
		const url = environment.API_URL + '/api/patientgeneralinfo/export';
		const idParams = '?ids=' + ids.join();

		window.open(url + idParams);

		return of({
			targetModelIds: ids
		});
	}

	exportModelsExcludingIds(ids: string[]): Observable<PassableStateConfig<PatientGeneralInfoModel>> {
		let apiUrl = environment.API_URL + '/api/patientgeneralinfo/export-excluding?ids=';

		if (ids.length > 0) {
			const idParams = ids.join();
			apiUrl = apiUrl.concat(idParams);
		}

		window.open(apiUrl);
		return of({
			targetModelIds: ids
		});
	}

	importModels(file: File): Observable<PassableStateConfig<PatientGeneralInfoModel>> {
		const requestData: FormData = new FormData();
		requestData.append('file', file);

		let apiUrl = environment.API_URL + '/api/patientgeneralinfo/import-csv';

		// % protected region % [Overwrite the url of the import api here] off begin
		// % protected region % [Overwrite the url of the import api here] end

		return this.http.post(apiUrl, requestData, {withCredentials: true, responseType: 'text'}).pipe(
			tap(result => this.toastrService.success('Successfully Imported ' + result.split(',').length + ' Patient General Info entities')),

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
