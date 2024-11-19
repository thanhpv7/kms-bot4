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
import {RegistrationModel} from '../../models/registration/registration.model';
import {RegistrationModelAudit} from '../../models/registration/registration.model.state';
import {AuthenticationService} from '../../lib/services/authentication/authentication.service';
import {QueryParams, PassableStateConfig} from '../../lib/services/http/interfaces';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import {BpjsPRBDetailModel} from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model';
import {BpjsPcareRegistrationsModel} from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model';
import {BpjsSEPModel} from 'src/app/models/bpjsSEP/bpjs_sep.model';
import {BedFacilityModel} from 'src/app/models/bedFacility/bed_facility.model';
import {BedReserveModel} from 'src/app/models/bedReserve/bed_reserve.model';
import {DiagnosesAndProceduresModel} from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import {DiagnosticExaminationResultsModel} from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model';
import {DiagnosticStaffExaminationSummaryModel} from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model';
import {ExaminationItemModel} from 'src/app/models/examinationItem/examination_item.model';
import {FluidBalanceDetailModel} from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model';
import {HealthFacilityModel} from 'src/app/models/healthFacility/health_facility.model';
import {InformedConsentModel} from 'src/app/models/informedConsent/informed_consent.model';
import {InvoiceItemModel} from 'src/app/models/invoiceItem/invoice_item.model';
import {MedicalCertificateDischargeResumeModel} from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model';
import {MedicalCertificateBirthModel} from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model';
import {MedicalCertificateHospitalizationModel} from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model';
import {MedicalCertificateMedicalAttendanceModel} from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model';
import {MedicalCertificateMentalHealthModel} from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model';
import {MedicalCertificatePhysicalHealthModel} from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model';
import {MedicalCertificateRestrictedWorkModel} from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model';
import {MedicalCertificateSickLeaveModel} from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model';
import {MedicalExaminationRecordModel} from 'src/app/models/medicalExaminationRecord/medical_examination_record.model';
import {MedicalFeeModel} from 'src/app/models/medicalFee/medical_fee.model';
import {MedicationHeaderModel} from 'src/app/models/medicationHeader/medication_header.model';
import {PcareExaminationModel} from 'src/app/models/pcareExamination/pcare_examination.model';
import {PatientVisitModel} from 'src/app/models/patientVisit/patient_visit.model';
import {PatientVitalInformationModel} from 'src/app/models/patientVitalInformation/patient_vital_information.model';
import {PrescriptionHeaderModel} from 'src/app/models/prescriptionHeader/prescription_header.model';
import {SepModel} from 'src/app/models/sep/sep.model';
import {SampleCollectionInformationModel} from 'src/app/models/sampleCollectionInformation/sample_collection_information.model';
import {ServiceModel} from 'src/app/models/service/service.model';
import {StaffModel} from 'src/app/models/staff/staff.model';
import {VaccinationOrderModel} from 'src/app/models/vaccinationOrder/vaccination_order.model';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Registration service used to handle all CRUD operations against this entity.
 */
@Injectable({
	providedIn: 'root'
})
export class RegistrationService extends AbstractHttpService<RegistrationModel, RegistrationModelAudit> {
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
			# % protected region % [Modify the RegistrationProperties classFragment here] off begin
			fragment RegistrationProperties on Registration {
				...RegistrationBaseProperties
				registrationNumber
				scheduledDate
				actualInDate
				dismissalDate
				dismissalType
				queueNo
				duration
				treatmentClass
				bookedTreatmentClass
				shift
				cito
				oneDayCare
				referral
				registrationStatus
				referralType
				purpose
				referralNotes
				supportingDocument {
					id
					created
					modified
					name
					size
					content
					url
				}
				admissionDiagnosis
				printWristband {
					id
					created
					modified
					name
					size
					content
					url
				}
				printLabel {
					id
					created
					modified
					name
					size
					content
					url
				}
				uploadedDateTime
				visitStatus
				instruction
				isAnAppointment
				referralNumber
				notes
				kodepoli
				deathCertificateNo
				timeOfDeath
				dismissalReferral
				dismissalReferralDetail
				dismissalReferralType
				dismissalReferringNotes
				patientIsReferredBack
				mcuPackage
				parentRegistrationNumber
				isUnknownPatient
				otherReferredFacility
				otherReferredStaff
			}
			# % protected region % [Modify the RegistrationProperties classFragment here] end
			${super.fragments('Registration').properties}
		`,
		// % protected region % [Add any additional fragments here] off begin
		// % protected region % [Add any additional fragments here] end
	};

	/**
	 * @inheritDoc
	 */
	count(): Observable<PassableStateConfig<RegistrationModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for count here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for count here] end

		return  this.apollo.query<PassableStateConfig<RegistrationModel>>(
			{
				query: gql`
					query Count {
						totalCount: countRegistrations

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
	getAll(): Observable<PassableStateConfig<RegistrationModel>> {
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
	get(id: string, queryParams?: QueryParams): Observable<PassableStateConfig<RegistrationModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for get here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for get here] end

		const expands = queryParams && queryParams.expands ? queryParams.expands : [];

		return this.apollo.query<PassableStateConfig<RegistrationModel>>(
			{
				query: gql`
					query Get($id: ID!) {
						RegistrationById: registrationById(id: $id) {
							...RegistrationProperties
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
					targetModel: result.data.RegistrationById as RegistrationModel,
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
	getWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<RegistrationModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] end

		return this.apollo.query<PassableStateConfig<RegistrationModel>>(
			{
				query: gql`
					query GetWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!], $where: [[Where!]!]) {
						registrations: registrations(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy, where: $where) {
							...RegistrationProperties
							${this.getExpands(queryParams.expands)}
						}

						totalCount: countRegistrations(where: $where)

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
					targetModels: result.data.registrations as RegistrationModel[],
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
	getLastWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<RegistrationModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] end

		return this.apollo.query<PassableStateConfig<RegistrationModel>>(
			{
				query: gql`
					query GetLastWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!]!) {
						registrations: lastRegistrations(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy) {
							...RegistrationProperties
						}

						totalCount: countRegistrations

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
					targetModels: result.data.registrations as RegistrationModel[],
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
	create(entity: RegistrationModel, queryParams?: QueryParams): Observable<PassableStateConfig<RegistrationModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for create here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for create here] end

		// % protected region % [Customise the success message for create here] off begin
		const successMessage = 'Created Registration entity successfully';
		// % protected region % [Customise the success message for create here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Create($registration: RegistrationInput!, $persistRelations: Boolean) {
						registration: createRegistration(registration: $registration, persistRelations: $persistRelations) {
							...RegistrationProperties,
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
					registration: {
						...entity.toJSON(),
						diagnosticStaffExaminationSummary: entity.diagnosticStaffExaminationSummary ? new DiagnosticStaffExaminationSummaryModel(entity.diagnosticStaffExaminationSummary).toJSON() : undefined,
						bpjsPRBDetail: entity.bpjsPRBDetail ? new BpjsPRBDetailModel(entity.bpjsPRBDetail).toJSON() : undefined,
						bpjsPcareRegistrations: entity.bpjsPcareRegistrations ? new BpjsPcareRegistrationsModel(entity.bpjsPcareRegistrations).toJSON() : undefined,
						bpjsSEP: entity.bpjsSEP ? new BpjsSEPModel(entity.bpjsSEP).toJSON() : undefined,
						medicalCertificateDischargeResume: entity.medicalCertificateDischargeResume ? new MedicalCertificateDischargeResumeModel(entity.medicalCertificateDischargeResume).toJSON() : undefined,
						medicalCertificateBirth: entity.medicalCertificateBirth ? new MedicalCertificateBirthModel(entity.medicalCertificateBirth).toJSON() : undefined,
						medicalCertificateHospitalization: entity.medicalCertificateHospitalization ? new MedicalCertificateHospitalizationModel(entity.medicalCertificateHospitalization).toJSON() : undefined,
						medicalCertificateMedicalAttendance: entity.medicalCertificateMedicalAttendance ? new MedicalCertificateMedicalAttendanceModel(entity.medicalCertificateMedicalAttendance).toJSON() : undefined,
						medicalCertificateMentalHealth: entity.medicalCertificateMentalHealth ? new MedicalCertificateMentalHealthModel(entity.medicalCertificateMentalHealth).toJSON() : undefined,
						medicalCertificatePhysicalHealth: entity.medicalCertificatePhysicalHealth ? new MedicalCertificatePhysicalHealthModel(entity.medicalCertificatePhysicalHealth).toJSON() : undefined,
						medicalCertificateRestrictedWork: entity.medicalCertificateRestrictedWork ? new MedicalCertificateRestrictedWorkModel(entity.medicalCertificateRestrictedWork).toJSON() : undefined,
						medicalCertificateSickLeave: entity.medicalCertificateSickLeave ? new MedicalCertificateSickLeaveModel(entity.medicalCertificateSickLeave).toJSON() : undefined,
						medicalExaminationRecord: entity.medicalExaminationRecord ? new MedicalExaminationRecordModel(entity.medicalExaminationRecord).toJSON() : undefined,
						pcareExamination: entity.pcareExamination ? new PcareExaminationModel(entity.pcareExamination).toJSON() : undefined,
						sep: entity.sep ? new SepModel(entity.sep).toJSON() : undefined,
						admissionICD10: entity.admissionICD10 ? new DiagnosesAndProceduresModel(entity.admissionICD10).toJSON() : undefined,
						admissionICD9CM: entity.admissionICD9CM ? new DiagnosesAndProceduresModel(entity.admissionICD9CM).toJSON() : undefined,
						dismissalReferringFacility: entity.dismissalReferringFacility ? new HealthFacilityModel(entity.dismissalReferringFacility).toJSON() : undefined,
						dismissalReferringStaff: entity.dismissalReferringStaff ? new StaffModel(entity.dismissalReferringStaff).toJSON() : undefined,
						referringUnit: entity.referringUnit ? new ServiceModel(entity.referringUnit).toJSON() : undefined,
						referringFacility: entity.referringFacility ? new HealthFacilityModel(entity.referringFacility).toJSON() : undefined,
						bedFacility: entity.bedFacility ? new BedFacilityModel(entity.bedFacility).toJSON() : undefined,
						patientVisit: entity.patientVisit ? new PatientVisitModel(entity.patientVisit).toJSON() : undefined,
						service: entity.service ? new ServiceModel(entity.service).toJSON() : undefined,
						staff: entity.staff ? new StaffModel(entity.staff).toJSON() : undefined,
						requestedBy: entity.requestedBy ? new StaffModel(entity.requestedBy).toJSON() : undefined,
						bedReserves: entity.bedReserves ? entity.bedReserves?.map((model: BedReserveModel) => new BedReserveModel(model).toJSON()) : [],
						diagnosticExaminationResults: entity.diagnosticExaminationResults ? entity.diagnosticExaminationResults?.map((model: DiagnosticExaminationResultsModel) => new DiagnosticExaminationResultsModel(model).toJSON()) : [],
						fluidBalanceDetails: entity.fluidBalanceDetails ? entity.fluidBalanceDetails?.map((model: FluidBalanceDetailModel) => new FluidBalanceDetailModel(model).toJSON()) : [],
						informedConsents: entity.informedConsents ? entity.informedConsents?.map((model: InformedConsentModel) => new InformedConsentModel(model).toJSON()) : [],
						invoiceItems: entity.invoiceItems ? entity.invoiceItems?.map((model: InvoiceItemModel) => new InvoiceItemModel(model).toJSON()) : [],
						medicalFees: entity.medicalFees ? entity.medicalFees?.map((model: MedicalFeeModel) => new MedicalFeeModel(model).toJSON()) : [],
						medicationHeaders: entity.medicationHeaders ? entity.medicationHeaders?.map((model: MedicationHeaderModel) => new MedicationHeaderModel(model).toJSON()) : [],
						patientVitalInformations: entity.patientVitalInformations ? entity.patientVitalInformations?.map((model: PatientVitalInformationModel) => new PatientVitalInformationModel(model).toJSON()) : [],
						prescriptionHeaders: entity.prescriptionHeaders ? entity.prescriptionHeaders?.map((model: PrescriptionHeaderModel) => new PrescriptionHeaderModel(model).toJSON()) : [],
						sampleCollectionInformations: entity.sampleCollectionInformations ? entity.sampleCollectionInformations?.map((model: SampleCollectionInformationModel) => new SampleCollectionInformationModel(model).toJSON()) : [],
						vaccinationOrders: entity.vaccinationOrders ? entity.vaccinationOrders?.map((model: VaccinationOrderModel) => new VaccinationOrderModel(model).toJSON()) : [],
						examinationItems: entity.examinationItems ? entity.examinationItems?.map((model: ExaminationItemModel) => new ExaminationItemModel(model).toJSON()) : [],
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
					targetModel: result.data.registration as RegistrationModel,
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
	createAll(entities: RegistrationModel[], queryParams?: QueryParams): Observable<PassableStateConfig<RegistrationModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] end

		// % protected region % [Customise the success message for createAll here] off begin
		const successMessage = 'Created Multiple Registration entities successfully';
		// % protected region % [Customise the success message for createAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation createAll($registrations: [RegistrationInput!]!) {
						registration: createAllRegistration(registrations: $registrations) {
							...RegistrationProperties,
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
					registrations: entities.map(entity => entity.toJSON()),
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
					targetModels: result.data.registration as RegistrationModel[],
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
	update(entity: RegistrationModel, queryParams?: QueryParams): Observable<PassableStateConfig<RegistrationModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for update here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for update here] end

		// % protected region % [Customise the success message for update here] off begin
		const successMessage = 'Updated Registration entity successfully';
		// % protected region % [Customise the success message for update here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Update($registration: RegistrationInput!, $persistRelations: Boolean) {
						registration: updateRegistration(registration: $registration, persistRelations: $persistRelations) {
							...RegistrationProperties,
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
					registration: {
						...entity.toJSON(),
						diagnosticStaffExaminationSummary: entity.diagnosticStaffExaminationSummary ? new DiagnosticStaffExaminationSummaryModel(entity.diagnosticStaffExaminationSummary).toJSON() : undefined,
						bpjsPRBDetail: entity.bpjsPRBDetail ? new BpjsPRBDetailModel(entity.bpjsPRBDetail).toJSON() : undefined,
						bpjsPcareRegistrations: entity.bpjsPcareRegistrations ? new BpjsPcareRegistrationsModel(entity.bpjsPcareRegistrations).toJSON() : undefined,
						bpjsSEP: entity.bpjsSEP ? new BpjsSEPModel(entity.bpjsSEP).toJSON() : undefined,
						medicalCertificateDischargeResume: entity.medicalCertificateDischargeResume ? new MedicalCertificateDischargeResumeModel(entity.medicalCertificateDischargeResume).toJSON() : undefined,
						medicalCertificateBirth: entity.medicalCertificateBirth ? new MedicalCertificateBirthModel(entity.medicalCertificateBirth).toJSON() : undefined,
						medicalCertificateHospitalization: entity.medicalCertificateHospitalization ? new MedicalCertificateHospitalizationModel(entity.medicalCertificateHospitalization).toJSON() : undefined,
						medicalCertificateMedicalAttendance: entity.medicalCertificateMedicalAttendance ? new MedicalCertificateMedicalAttendanceModel(entity.medicalCertificateMedicalAttendance).toJSON() : undefined,
						medicalCertificateMentalHealth: entity.medicalCertificateMentalHealth ? new MedicalCertificateMentalHealthModel(entity.medicalCertificateMentalHealth).toJSON() : undefined,
						medicalCertificatePhysicalHealth: entity.medicalCertificatePhysicalHealth ? new MedicalCertificatePhysicalHealthModel(entity.medicalCertificatePhysicalHealth).toJSON() : undefined,
						medicalCertificateRestrictedWork: entity.medicalCertificateRestrictedWork ? new MedicalCertificateRestrictedWorkModel(entity.medicalCertificateRestrictedWork).toJSON() : undefined,
						medicalCertificateSickLeave: entity.medicalCertificateSickLeave ? new MedicalCertificateSickLeaveModel(entity.medicalCertificateSickLeave).toJSON() : undefined,
						medicalExaminationRecord: entity.medicalExaminationRecord ? new MedicalExaminationRecordModel(entity.medicalExaminationRecord).toJSON() : undefined,
						pcareExamination: entity.pcareExamination ? new PcareExaminationModel(entity.pcareExamination).toJSON() : undefined,
						sep: entity.sep ? new SepModel(entity.sep).toJSON() : undefined,
						admissionICD10: entity.admissionICD10 ? new DiagnosesAndProceduresModel(entity.admissionICD10).toJSON() : undefined,
						admissionICD9CM: entity.admissionICD9CM ? new DiagnosesAndProceduresModel(entity.admissionICD9CM).toJSON() : undefined,
						dismissalReferringFacility: entity.dismissalReferringFacility ? new HealthFacilityModel(entity.dismissalReferringFacility).toJSON() : undefined,
						dismissalReferringStaff: entity.dismissalReferringStaff ? new StaffModel(entity.dismissalReferringStaff).toJSON() : undefined,
						referringUnit: entity.referringUnit ? new ServiceModel(entity.referringUnit).toJSON() : undefined,
						referringFacility: entity.referringFacility ? new HealthFacilityModel(entity.referringFacility).toJSON() : undefined,
						bedFacility: entity.bedFacility ? new BedFacilityModel(entity.bedFacility).toJSON() : undefined,
						patientVisit: entity.patientVisit ? new PatientVisitModel(entity.patientVisit).toJSON() : undefined,
						service: entity.service ? new ServiceModel(entity.service).toJSON() : undefined,
						staff: entity.staff ? new StaffModel(entity.staff).toJSON() : undefined,
						requestedBy: entity.requestedBy ? new StaffModel(entity.requestedBy).toJSON() : undefined,
						bedReserves: entity.bedReserves ? entity.bedReserves?.map((model: BedReserveModel) => new BedReserveModel(model).toJSON()) : [],
						diagnosticExaminationResults: entity.diagnosticExaminationResults ? entity.diagnosticExaminationResults?.map((model: DiagnosticExaminationResultsModel) => new DiagnosticExaminationResultsModel(model).toJSON()) : [],
						fluidBalanceDetails: entity.fluidBalanceDetails ? entity.fluidBalanceDetails?.map((model: FluidBalanceDetailModel) => new FluidBalanceDetailModel(model).toJSON()) : [],
						informedConsents: entity.informedConsents ? entity.informedConsents?.map((model: InformedConsentModel) => new InformedConsentModel(model).toJSON()) : [],
						invoiceItems: entity.invoiceItems ? entity.invoiceItems?.map((model: InvoiceItemModel) => new InvoiceItemModel(model).toJSON()) : [],
						medicalFees: entity.medicalFees ? entity.medicalFees?.map((model: MedicalFeeModel) => new MedicalFeeModel(model).toJSON()) : [],
						medicationHeaders: entity.medicationHeaders ? entity.medicationHeaders?.map((model: MedicationHeaderModel) => new MedicationHeaderModel(model).toJSON()) : [],
						patientVitalInformations: entity.patientVitalInformations ? entity.patientVitalInformations?.map((model: PatientVitalInformationModel) => new PatientVitalInformationModel(model).toJSON()) : [],
						prescriptionHeaders: entity.prescriptionHeaders ? entity.prescriptionHeaders?.map((model: PrescriptionHeaderModel) => new PrescriptionHeaderModel(model).toJSON()) : [],
						sampleCollectionInformations: entity.sampleCollectionInformations ? entity.sampleCollectionInformations?.map((model: SampleCollectionInformationModel) => new SampleCollectionInformationModel(model).toJSON()) : [],
						vaccinationOrders: entity.vaccinationOrders ? entity.vaccinationOrders?.map((model: VaccinationOrderModel) => new VaccinationOrderModel(model).toJSON()) : [],
						examinationItems: entity.examinationItems ? entity.examinationItems?.map((model: ExaminationItemModel) => new ExaminationItemModel(model).toJSON()) : [],
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
					targetModel: result.data.registration as RegistrationModel,
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
	updateAll(entities: RegistrationModel[], queryParams?: QueryParams): Observable<PassableStateConfig<RegistrationModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] end

		// % protected region % [Customise the success message for updateAll here] off begin
		const successMessage = 'Update Multiple Registration entities successfully';
		// % protected region % [Customise the success message for updateAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation updateAll($registrations: [RegistrationInput!]!) {
						registration: updateAllRegistration(registrations: $registrations) {
							...RegistrationProperties,
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
					registrations: entities.map(entity => entity.toJSON()),
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
					targetModels: result.data.registration as RegistrationModel[],
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
	delete(id: string): Observable<PassableStateConfig<RegistrationModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete here] end

		// % protected region % [Customise the success message for delete here] off begin
		const successMessage = 'Deleted Registration entity successfully';
		// % protected region % [Customise the success message for delete here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Delete($registrationId: ID!) {
						registrationId: deleteRegistrationById(registrationId: $registrationId)

						# % protected region % [Add any additional mutations for delete here] off begin
						# % protected region % [Add any additional mutations for delete here] end
					}

					# % protected region % [Add any additional GraphQL info for delete here] off begin
					# % protected region % [Add any additional GraphQL info for delete here] end
				`,
				variables: {
					registrationId: id,
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
					targetModelId: result.data.registrationId as string,
					// % protected region % [Add any additional info to be passed up for delete here] off begin
					// % protected region % [Add any additional info to be passed up for delete here] end
				};
			}),
			// % protected region % [Add any additional piping logic for delete here] off begin
			// % protected region % [Add any additional piping logic for delete here] end
		);
	}

	deleteExcludingIds(ids: string[]): Observable<PassableStateConfig<RegistrationModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] end

		// % protected region % [Customise the success message for delete excluding here] off begin
		const successMessage = 'Deleted selected Registration entities successfully';
		// % protected region % [Customise the success message for delete excluding here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation deleteAll($registrationIds: [ID!]!){
						deleteRegistrationExcludingIds(registrationIds: $registrationIds)

						# % protected region % [Add any additional mutations for delete excluding here] off begin
						# % protected region % [Add any additional mutations for delete excluding here] end
					}

					# % protected region % [Add any additional GraphQL info for delete excluding here] off begin
					# % protected region % [Add any additional GraphQL info for delete excluding here] end
				`,
				variables: {
					registrationIds: ids,
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
					targetModelIds: result.data.registrationIds as string[],
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
	deleteAll(ids: string[]): Observable<PassableStateConfig<RegistrationModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] end

		// % protected region % [Customise the success message for deleteAll here] off begin
		const successMessage = 'Deleted selected Registration entities successfully';
		// % protected region % [Customise the success message for deleteAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation DeleteAll($registrationIds: [ID!]!) {
						registrationIds: deleteAllRegistrationByIds(registrationIds: $registrationIds)

						# % protected region % [Add any additional mutations for deleteAll here] off begin
						# % protected region % [Add any additional mutations for deleteAll here] end
					}

					# % protected region % [Add any additional GraphQL info for deleteAll here] off begin
					# % protected region % [Add any additional GraphQL info for deleteAll here] end
				`,
				variables: {
					registrationIds: ids,
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
					targetModelIds: result.data.registrationIds as string[],
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
	getAudits(): Observable<RegistrationModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] end

		return this.apollo.query<PassableStateConfig<RegistrationModel>>(
			{
				query: gql`
					query GetAudits {
						audits: registrationAudits {
							entity {
								...RegistrationProperties
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
				let audits: RegistrationModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new RegistrationModel(audit.entity),
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
	getAuditsByEntityId(id: string): Observable<RegistrationModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] end

		return this.apollo.query<PassableStateConfig<RegistrationModel>>(
			{
				query: gql`
					query GetAuditsByEntityId($registrationId: ID!) {
						audits: registrationAuditsByEntityId(registrationId: $registrationId) {
							entity {
								...RegistrationProperties
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
					registrationId: id,
					// % protected region % [Add any additional variables for getAuditsByEntityId here] off begin
					// % protected region % [Add any additional variables for getAuditsByEntityId here] end
				}
			}
		).pipe(
			map(result => {
				let audits: RegistrationModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new RegistrationModel(audit.entity),
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
	export(id: string): Observable<PassableStateConfig<RegistrationModel>> {
		const url = environment.API_URL + '/api/registration/export';
		const idParams = '?id=' + id;

		window.open(url + idParams);
		return of({
			targetModelId: id
		});
	}

	/**
	 * @inheritdoc
	 */
	exportAll(ids: string[]): Observable<PassableStateConfig<RegistrationModel>> {
		const url = environment.API_URL + '/api/registration/export';
		const idParams = '?ids=' + ids.join();

		window.open(url + idParams);

		return of({
			targetModelIds: ids
		});
	}

	exportModelsExcludingIds(ids: string[]): Observable<PassableStateConfig<RegistrationModel>> {
		let apiUrl = environment.API_URL + '/api/registration/export-excluding?ids=';

		if (ids.length > 0) {
			const idParams = ids.join();
			apiUrl = apiUrl.concat(idParams);
		}

		window.open(apiUrl);
		return of({
			targetModelIds: ids
		});
	}

	importModels(file: File): Observable<PassableStateConfig<RegistrationModel>> {
		const requestData: FormData = new FormData();
		requestData.append('file', file);

		let apiUrl = environment.API_URL + '/api/registration/import-csv';

		// % protected region % [Overwrite the url of the import api here] off begin
		// % protected region % [Overwrite the url of the import api here] end

		return this.http.post(apiUrl, requestData, {withCredentials: true, responseType: 'text'}).pipe(
			tap(result => this.toastrService.success('Successfully Imported ' + result.split(',').length + ' Registration entities')),

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
