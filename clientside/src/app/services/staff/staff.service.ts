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
import {StaffModel} from '../../models/staff/staff.model';
import {StaffModelAudit} from '../../models/staff/staff.model.state';
import {AuthenticationService} from '../../lib/services/authentication/authentication.service';
import {QueryParams, PassableStateConfig} from '../../lib/services/http/interfaces';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import {AdministrationUserModel} from 'src/app/models/administrationUser/administration_user.model';
import {AdministratorModel} from 'src/app/models/administrator/administrator.model';
import {AmendmentDetailModel} from 'src/app/models/amendmentDetail/amendment_detail.model';
import {BpjsDoctorMappingModel} from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model';
import {CashReceiptModel} from 'src/app/models/cashReceipt/cash_receipt.model';
import {CashierUserModel} from 'src/app/models/cashierUser/cashier_user.model';
import {ClaimUserModel} from 'src/app/models/claimUser/claim_user.model';
import {CoTreatingDoctorModel} from 'src/app/models/coTreatingDoctor/co_treating_doctor.model';
import {DailyCareCPPTModel} from 'src/app/models/dailyCareCPPT/daily_care_cppt.model';
import {DeliveryMedicalExaminationRecordModel} from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model';
import {DeliveryProgressModel} from 'src/app/models/deliveryProgress/delivery_progress.model';
import {DiagnosticStaffExaminationSummaryModel} from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model';
import {DiagnosticSupportUserModel} from 'src/app/models/diagnosticSupportUser/diagnostic_support_user.model';
import {DoctorScheduleModel} from 'src/app/models/doctorSchedule/doctor_schedule.model';
import {DoctorUserModel} from 'src/app/models/doctorUser/doctor_user.model';
import {FacilityUserModel} from 'src/app/models/facilityUser/facility_user.model';
import {FluidBalanceDetailModel} from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model';
import {HemodialysisMonitoringModel} from 'src/app/models/hemodialysisMonitoring/hemodialysis_monitoring.model';
import {HospitalBranchInformationModel} from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model';
import {InformedConsentModel} from 'src/app/models/informedConsent/informed_consent.model';
import {InvoiceModel} from 'src/app/models/invoice/invoice.model';
import {McuPackageItemModel} from 'src/app/models/mcuPackageItem/mcu_package_item.model';
import {ManagementUserModel} from 'src/app/models/managementUser/management_user.model';
import {MedicalCertificateDischargeResumeModel} from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model';
import {MedicalCertificateBirthModel} from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model';
import {MedicalCertificateHospitalizationModel} from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model';
import {MedicalCertificateMedicalAttendanceModel} from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model';
import {MedicalCertificateMentalHealthModel} from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model';
import {MedicalCertificatePhysicalHealthModel} from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model';
import {MedicalCertificateRestrictedWorkModel} from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model';
import {MedicalCertificateSickLeaveModel} from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model';
import {MedicalExaminationRecordModel} from 'src/app/models/medicalExaminationRecord/medical_examination_record.model';
import {MedicalExaminationRecordDischargeSummaryModel} from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model';
import {MedicalRecordUserModel} from 'src/app/models/medicalRecordUser/medical_record_user.model';
import {MedicalTranscriberUserModel} from 'src/app/models/medicalTranscriberUser/medical_transcriber_user.model';
import {MedicationAdministeredHistoryModel} from 'src/app/models/medicationAdministeredHistory/medication_administered_history.model';
import {MedicationHeaderModel} from 'src/app/models/medicationHeader/medication_header.model';
import {NewbornDetailModel} from 'src/app/models/newbornDetail/newborn_detail.model';
import {NurseUserModel} from 'src/app/models/nurseUser/nurse_user.model';
import {OperatingTheaterMedicalExaminationRecordModel} from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import {PcareDokterModel} from 'src/app/models/pcareDokter/pcare_dokter.model';
import {PatientConsentModel} from 'src/app/models/patientConsent/patient_consent.model';
import {PatientVitalInformationModel} from 'src/app/models/patientVitalInformation/patient_vital_information.model';
import {PharmacyUserModel} from 'src/app/models/pharmacyUser/pharmacy_user.model';
import {PreoperativeRecordsModel} from 'src/app/models/preoperativeRecords/preoperative_records.model';
import {PrescriptionHeaderModel} from 'src/app/models/prescriptionHeader/prescription_header.model';
import {ProcessWorkflowModel} from 'src/app/models/processWorkflow/process_workflow.model';
import {PurchasingUserModel} from 'src/app/models/purchasingUser/purchasing_user.model';
import {RegistrationModel} from 'src/app/models/registration/registration.model';
import {RegistrationUserModel} from 'src/app/models/registrationUser/registration_user.model';
import {RoomTransferModel} from 'src/app/models/roomTransfer/room_transfer.model';
import {SampleCollectionItemsModel} from 'src/app/models/sampleCollectionItems/sample_collection_items.model';
import {ServiceModel} from 'src/app/models/service/service.model';
import {SystemAdminUserModel} from 'src/app/models/systemAdminUser/system_admin_user.model';
import {TransferOrderStockDetailModel} from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model';
import {VaccinationOrderModel} from 'src/app/models/vaccinationOrder/vaccination_order.model';
import {WarehouseUserModel} from 'src/app/models/warehouseUser/warehouse_user.model';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Staff service used to handle all CRUD operations against this entity.
 */
@Injectable({
	providedIn: 'root'
})
export class StaffService extends AbstractHttpService<StaffModel, StaffModelAudit> {
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
			# % protected region % [Modify the StaffProperties classFragment here] off begin
			fragment StaffProperties on Staff {
				...StaffBaseProperties
				staffNumber
				firstName
				lastName
				dateOfBirth
				staffType
				specialization
				staffPicture {
					id
					created
					modified
					name
					size
					content
					url
				}
				education
				licenseNo
				letterOfReg
				gender
				employeeID
				title
				defaultServiceNumber
				placeOfBirth
				religion
				bloodType
				rhesus
				address
				country
				state
				regency
				district
				homePhoneNo
				village
				postcode
				officePhoneNumber
				taxIdentificationNo
				mobilePhoneNo
				otherNotes
				training
				nationality
				certification
				extNo
				maritalStatus
				email
			}
			# % protected region % [Modify the StaffProperties classFragment here] end
			${super.fragments('Staff').properties}
		`,
		// % protected region % [Add any additional fragments here] off begin
		// % protected region % [Add any additional fragments here] end
	};

	/**
	 * @inheritDoc
	 */
	count(): Observable<PassableStateConfig<StaffModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for count here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for count here] end

		return  this.apollo.query<PassableStateConfig<StaffModel>>(
			{
				query: gql`
					query Count {
						totalCount: countStaffs

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
	getAll(): Observable<PassableStateConfig<StaffModel>> {
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
	get(id: string, queryParams?: QueryParams): Observable<PassableStateConfig<StaffModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for get here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for get here] end

		const expands = queryParams && queryParams.expands ? queryParams.expands : [];

		return this.apollo.query<PassableStateConfig<StaffModel>>(
			{
				query: gql`
					query Get($id: ID!) {
						StaffById: staffById(id: $id) {
							...StaffProperties
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
					targetModel: result.data.StaffById as StaffModel,
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
	getWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<StaffModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] end

		return this.apollo.query<PassableStateConfig<StaffModel>>(
			{
				query: gql`
					query GetWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!], $where: [[Where!]!]) {
						staffs: staffs(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy, where: $where) {
							...StaffProperties
							${this.getExpands(queryParams.expands)}
						}

						totalCount: countStaffs(where: $where)

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
					targetModels: result.data.staffs as StaffModel[],
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
	getLastWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<StaffModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] end

		return this.apollo.query<PassableStateConfig<StaffModel>>(
			{
				query: gql`
					query GetLastWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!]!) {
						staffs: lastStaffs(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy) {
							...StaffProperties
						}

						totalCount: countStaffs

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
					targetModels: result.data.staffs as StaffModel[],
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
	create(entity: StaffModel, queryParams?: QueryParams): Observable<PassableStateConfig<StaffModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for create here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for create here] end

		// % protected region % [Customise the success message for create here] off begin
		const successMessage = 'Created Staff entity successfully';
		// % protected region % [Customise the success message for create here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Create($staff: StaffInput!, $persistRelations: Boolean) {
						staff: createStaff(staff: $staff, persistRelations: $persistRelations) {
							...StaffProperties,
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
					staff: {
						...entity.toJSON(),
						administrationUser: entity.administrationUser ? new AdministrationUserModel(entity.administrationUser).toJSON() : undefined,
						cashierUser: entity.cashierUser ? new CashierUserModel(entity.cashierUser).toJSON() : undefined,
						claimUser: entity.claimUser ? new ClaimUserModel(entity.claimUser).toJSON() : undefined,
						diagnosticSupportUser: entity.diagnosticSupportUser ? new DiagnosticSupportUserModel(entity.diagnosticSupportUser).toJSON() : undefined,
						doctorUser: entity.doctorUser ? new DoctorUserModel(entity.doctorUser).toJSON() : undefined,
						facilityUser: entity.facilityUser ? new FacilityUserModel(entity.facilityUser).toJSON() : undefined,
						managementUser: entity.managementUser ? new ManagementUserModel(entity.managementUser).toJSON() : undefined,
						medicalRecordUser: entity.medicalRecordUser ? new MedicalRecordUserModel(entity.medicalRecordUser).toJSON() : undefined,
						medicalTranscriberUser: entity.medicalTranscriberUser ? new MedicalTranscriberUserModel(entity.medicalTranscriberUser).toJSON() : undefined,
						nurseUser: entity.nurseUser ? new NurseUserModel(entity.nurseUser).toJSON() : undefined,
						pharmacyUser: entity.pharmacyUser ? new PharmacyUserModel(entity.pharmacyUser).toJSON() : undefined,
						purchasingUser: entity.purchasingUser ? new PurchasingUserModel(entity.purchasingUser).toJSON() : undefined,
						registrationUser: entity.registrationUser ? new RegistrationUserModel(entity.registrationUser).toJSON() : undefined,
						systemAdminUser: entity.systemAdminUser ? new SystemAdminUserModel(entity.systemAdminUser).toJSON() : undefined,
						warehouseUser: entity.warehouseUser ? new WarehouseUserModel(entity.warehouseUser).toJSON() : undefined,
						administrator: entity.administrator ? new AdministratorModel(entity.administrator).toJSON() : undefined,
						bpjsDoctorMapping: entity.bpjsDoctorMapping ? new BpjsDoctorMappingModel(entity.bpjsDoctorMapping).toJSON() : undefined,
						pcareDokter: entity.pcareDokter ? new PcareDokterModel(entity.pcareDokter).toJSON() : undefined,
						service: entity.service ? new ServiceModel(entity.service).toJSON() : undefined,
						accompanyingConsents: entity.accompanyingConsents ? entity.accompanyingConsents?.map((model: InformedConsentModel) => new InformedConsentModel(model).toJSON()) : [],
						amendmentDetails: entity.amendmentDetails ? entity.amendmentDetails?.map((model: AmendmentDetailModel) => new AmendmentDetailModel(model).toJSON()) : [],
						anesthesiaMedicalTranscriber: entity.anesthesiaMedicalTranscriber ? entity.anesthesiaMedicalTranscriber?.map((model: PreoperativeRecordsModel) => new PreoperativeRecordsModel(model).toJSON()) : [],
						anesthesiologist: entity.anesthesiologist ? entity.anesthesiologist?.map((model: PreoperativeRecordsModel) => new PreoperativeRecordsModel(model).toJSON()) : [],
						anesthesiologyNurse: entity.anesthesiologyNurse ? entity.anesthesiologyNurse?.map((model: PreoperativeRecordsModel) => new PreoperativeRecordsModel(model).toJSON()) : [],
						cashierStaff: entity.cashierStaff ? entity.cashierStaff?.map((model: CashReceiptModel) => new CashReceiptModel(model).toJSON()) : [],
						coTreatingDoctors: entity.coTreatingDoctors ? entity.coTreatingDoctors?.map((model: CoTreatingDoctorModel) => new CoTreatingDoctorModel(model).toJSON()) : [],
						dailyCareCPPTsCreatedByStaff: entity.dailyCareCPPTsCreatedByStaff ? entity.dailyCareCPPTsCreatedByStaff?.map((model: DailyCareCPPTModel) => new DailyCareCPPTModel(model).toJSON()) : [],
						dailyCareCPPTsDoctorInCharge: entity.dailyCareCPPTsDoctorInCharge ? entity.dailyCareCPPTsDoctorInCharge?.map((model: DailyCareCPPTModel) => new DailyCareCPPTModel(model).toJSON()) : [],
						dailyCareCPPTsMedicalTranscriber: entity.dailyCareCPPTsMedicalTranscriber ? entity.dailyCareCPPTsMedicalTranscriber?.map((model: DailyCareCPPTModel) => new DailyCareCPPTModel(model).toJSON()) : [],
						deliveryProgresses: entity.deliveryProgresses ? entity.deliveryProgresses?.map((model: DeliveryProgressModel) => new DeliveryProgressModel(model).toJSON()) : [],
						diagnosticStaffExaminationSummaries: entity.diagnosticStaffExaminationSummaries ? entity.diagnosticStaffExaminationSummaries?.map((model: DiagnosticStaffExaminationSummaryModel) => new DiagnosticStaffExaminationSummaryModel(model).toJSON()) : [],
						dismissalReferringStaff: entity.dismissalReferringStaff ? entity.dismissalReferringStaff?.map((model: RegistrationModel) => new RegistrationModel(model).toJSON()) : [],
						doctorSchedules: entity.doctorSchedules ? entity.doctorSchedules?.map((model: DoctorScheduleModel) => new DoctorScheduleModel(model).toJSON()) : [],
						doctorOnExamination: entity.doctorOnExamination ? entity.doctorOnExamination?.map((model: MedicalExaminationRecordModel) => new MedicalExaminationRecordModel(model).toJSON()) : [],
						fluidBalanceDetails: entity.fluidBalanceDetails ? entity.fluidBalanceDetails?.map((model: FluidBalanceDetailModel) => new FluidBalanceDetailModel(model).toJSON()) : [],
						hemodialysisMonitorings: entity.hemodialysisMonitorings ? entity.hemodialysisMonitorings?.map((model: HemodialysisMonitoringModel) => new HemodialysisMonitoringModel(model).toJSON()) : [],
						hospitalBranchInformations: entity.hospitalBranchInformations ? entity.hospitalBranchInformations?.map((model: HospitalBranchInformationModel) => new HospitalBranchInformationModel(model).toJSON()) : [],
						informingConsents: entity.informingConsents ? entity.informingConsents?.map((model: InformedConsentModel) => new InformedConsentModel(model).toJSON()) : [],
						invoices: entity.invoices ? entity.invoices?.map((model: InvoiceModel) => new InvoiceModel(model).toJSON()) : [],
						mcuPackageItems: entity.mcuPackageItems ? entity.mcuPackageItems?.map((model: McuPackageItemModel) => new McuPackageItemModel(model).toJSON()) : [],
						medicalCertificateDischargeResumes: entity.medicalCertificateDischargeResumes ? entity.medicalCertificateDischargeResumes?.map((model: MedicalCertificateDischargeResumeModel) => new MedicalCertificateDischargeResumeModel(model).toJSON()) : [],
						medicalCertificateBirths: entity.medicalCertificateBirths ? entity.medicalCertificateBirths?.map((model: MedicalCertificateBirthModel) => new MedicalCertificateBirthModel(model).toJSON()) : [],
						medicalCertificateHospitalizations: entity.medicalCertificateHospitalizations ? entity.medicalCertificateHospitalizations?.map((model: MedicalCertificateHospitalizationModel) => new MedicalCertificateHospitalizationModel(model).toJSON()) : [],
						medicalExaminationRecordDischargeSummarys: entity.medicalExaminationRecordDischargeSummarys ? entity.medicalExaminationRecordDischargeSummarys?.map((model: MedicalExaminationRecordDischargeSummaryModel) => new MedicalExaminationRecordDischargeSummaryModel(model).toJSON()) : [],
						medicalRecordTranscriber: entity.medicalRecordTranscriber ? entity.medicalRecordTranscriber?.map((model: MedicalExaminationRecordModel) => new MedicalExaminationRecordModel(model).toJSON()) : [],
						medicalStaffOfMedicalAttendancesCertificate: entity.medicalStaffOfMedicalAttendancesCertificate ? entity.medicalStaffOfMedicalAttendancesCertificate?.map((model: MedicalCertificateMedicalAttendanceModel) => new MedicalCertificateMedicalAttendanceModel(model).toJSON()) : [],
						medicalStaffOfMentalHealths: entity.medicalStaffOfMentalHealths ? entity.medicalStaffOfMentalHealths?.map((model: MedicalCertificateMentalHealthModel) => new MedicalCertificateMentalHealthModel(model).toJSON()) : [],
						medicalStaffOfPhysicalHealths: entity.medicalStaffOfPhysicalHealths ? entity.medicalStaffOfPhysicalHealths?.map((model: MedicalCertificatePhysicalHealthModel) => new MedicalCertificatePhysicalHealthModel(model).toJSON()) : [],
						medicalStaffOfRestrictedWorksCertificate: entity.medicalStaffOfRestrictedWorksCertificate ? entity.medicalStaffOfRestrictedWorksCertificate?.map((model: MedicalCertificateRestrictedWorkModel) => new MedicalCertificateRestrictedWorkModel(model).toJSON()) : [],
						medicalStaffOfSickLeavesCertificate: entity.medicalStaffOfSickLeavesCertificate ? entity.medicalStaffOfSickLeavesCertificate?.map((model: MedicalCertificateSickLeaveModel) => new MedicalCertificateSickLeaveModel(model).toJSON()) : [],
						medicationAdministeredHisotries: entity.medicationAdministeredHisotries ? entity.medicationAdministeredHisotries?.map((model: MedicationAdministeredHistoryModel) => new MedicationAdministeredHistoryModel(model).toJSON()) : [],
						medicationHeaders: entity.medicationHeaders ? entity.medicationHeaders?.map((model: MedicationHeaderModel) => new MedicationHeaderModel(model).toJSON()) : [],
						midwives: entity.midwives ? entity.midwives?.map((model: DeliveryMedicalExaminationRecordModel) => new DeliveryMedicalExaminationRecordModel(model).toJSON()) : [],
						nurse: entity.nurse ? entity.nurse?.map((model: MedicalExaminationRecordModel) => new MedicalExaminationRecordModel(model).toJSON()) : [],
						nursingDetailSurgicalNursing: entity.nursingDetailSurgicalNursing ? entity.nursingDetailSurgicalNursing?.map((model: OperatingTheaterMedicalExaminationRecordModel) => new OperatingTheaterMedicalExaminationRecordModel(model).toJSON()) : [],
						nursingDetailsAnesthesiaNursing: entity.nursingDetailsAnesthesiaNursing ? entity.nursingDetailsAnesthesiaNursing?.map((model: OperatingTheaterMedicalExaminationRecordModel) => new OperatingTheaterMedicalExaminationRecordModel(model).toJSON()) : [],
						patientConsents: entity.patientConsents ? entity.patientConsents?.map((model: PatientConsentModel) => new PatientConsentModel(model).toJSON()) : [],
						patientVitalInformations: entity.patientVitalInformations ? entity.patientVitalInformations?.map((model: PatientVitalInformationModel) => new PatientVitalInformationModel(model).toJSON()) : [],
						pediatricianInCharge: entity.pediatricianInCharge ? entity.pediatricianInCharge?.map((model: NewbornDetailModel) => new NewbornDetailModel(model).toJSON()) : [],
						prescriptionHeaders: entity.prescriptionHeaders ? entity.prescriptionHeaders?.map((model: PrescriptionHeaderModel) => new PrescriptionHeaderModel(model).toJSON()) : [],
						processWorkflowLogs: entity.processWorkflowLogs ? entity.processWorkflowLogs?.map((model: ProcessWorkflowModel) => new ProcessWorkflowModel(model).toJSON()) : [],
						registrations: entity.registrations ? entity.registrations?.map((model: RegistrationModel) => new RegistrationModel(model).toJSON()) : [],
						requestedBy: entity.requestedBy ? entity.requestedBy?.map((model: RegistrationModel) => new RegistrationModel(model).toJSON()) : [],
						roomTransfers: entity.roomTransfers ? entity.roomTransfers?.map((model: RoomTransferModel) => new RoomTransferModel(model).toJSON()) : [],
						sampleCollectionStaffs: entity.sampleCollectionStaffs ? entity.sampleCollectionStaffs?.map((model: SampleCollectionItemsModel) => new SampleCollectionItemsModel(model).toJSON()) : [],
						sampleDeliveryStaffs: entity.sampleDeliveryStaffs ? entity.sampleDeliveryStaffs?.map((model: SampleCollectionItemsModel) => new SampleCollectionItemsModel(model).toJSON()) : [],
						sampleProcessingStaffs: entity.sampleProcessingStaffs ? entity.sampleProcessingStaffs?.map((model: SampleCollectionItemsModel) => new SampleCollectionItemsModel(model).toJSON()) : [],
						surgeon: entity.surgeon ? entity.surgeon?.map((model: PreoperativeRecordsModel) => new PreoperativeRecordsModel(model).toJSON()) : [],
						surgicalMedicalTranscriber: entity.surgicalMedicalTranscriber ? entity.surgicalMedicalTranscriber?.map((model: PreoperativeRecordsModel) => new PreoperativeRecordsModel(model).toJSON()) : [],
						surgicalNurse: entity.surgicalNurse ? entity.surgicalNurse?.map((model: PreoperativeRecordsModel) => new PreoperativeRecordsModel(model).toJSON()) : [],
						transferOrderStockDetails: entity.transferOrderStockDetails ? entity.transferOrderStockDetails?.map((model: TransferOrderStockDetailModel) => new TransferOrderStockDetailModel(model).toJSON()) : [],
						vaccinationOrders: entity.vaccinationOrders ? entity.vaccinationOrders?.map((model: VaccinationOrderModel) => new VaccinationOrderModel(model).toJSON()) : [],
						services: entity.services ? entity.services?.map((model: ServiceModel) => new ServiceModel(model).toJSON()) : [],
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
					targetModel: result.data.staff as StaffModel,
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
	createAll(entities: StaffModel[], queryParams?: QueryParams): Observable<PassableStateConfig<StaffModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] end

		// % protected region % [Customise the success message for createAll here] off begin
		const successMessage = 'Created Multiple Staff entities successfully';
		// % protected region % [Customise the success message for createAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation createAll($staffs: [StaffInput!]!) {
						staff: createAllStaff(staffs: $staffs) {
							...StaffProperties,
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
					staffs: entities.map(entity => entity.toJSON()),
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
					targetModels: result.data.staff as StaffModel[],
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
	update(entity: StaffModel, queryParams?: QueryParams): Observable<PassableStateConfig<StaffModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for update here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for update here] end

		// % protected region % [Customise the success message for update here] off begin
		const successMessage = 'Updated Staff entity successfully';
		// % protected region % [Customise the success message for update here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Update($staff: StaffInput!, $persistRelations: Boolean) {
						staff: updateStaff(staff: $staff, persistRelations: $persistRelations) {
							...StaffProperties,
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
					staff: {
						...entity.toJSON(),
						administrationUser: entity.administrationUser ? new AdministrationUserModel(entity.administrationUser).toJSON() : undefined,
						cashierUser: entity.cashierUser ? new CashierUserModel(entity.cashierUser).toJSON() : undefined,
						claimUser: entity.claimUser ? new ClaimUserModel(entity.claimUser).toJSON() : undefined,
						diagnosticSupportUser: entity.diagnosticSupportUser ? new DiagnosticSupportUserModel(entity.diagnosticSupportUser).toJSON() : undefined,
						doctorUser: entity.doctorUser ? new DoctorUserModel(entity.doctorUser).toJSON() : undefined,
						facilityUser: entity.facilityUser ? new FacilityUserModel(entity.facilityUser).toJSON() : undefined,
						managementUser: entity.managementUser ? new ManagementUserModel(entity.managementUser).toJSON() : undefined,
						medicalRecordUser: entity.medicalRecordUser ? new MedicalRecordUserModel(entity.medicalRecordUser).toJSON() : undefined,
						medicalTranscriberUser: entity.medicalTranscriberUser ? new MedicalTranscriberUserModel(entity.medicalTranscriberUser).toJSON() : undefined,
						nurseUser: entity.nurseUser ? new NurseUserModel(entity.nurseUser).toJSON() : undefined,
						pharmacyUser: entity.pharmacyUser ? new PharmacyUserModel(entity.pharmacyUser).toJSON() : undefined,
						purchasingUser: entity.purchasingUser ? new PurchasingUserModel(entity.purchasingUser).toJSON() : undefined,
						registrationUser: entity.registrationUser ? new RegistrationUserModel(entity.registrationUser).toJSON() : undefined,
						systemAdminUser: entity.systemAdminUser ? new SystemAdminUserModel(entity.systemAdminUser).toJSON() : undefined,
						warehouseUser: entity.warehouseUser ? new WarehouseUserModel(entity.warehouseUser).toJSON() : undefined,
						administrator: entity.administrator ? new AdministratorModel(entity.administrator).toJSON() : undefined,
						bpjsDoctorMapping: entity.bpjsDoctorMapping ? new BpjsDoctorMappingModel(entity.bpjsDoctorMapping).toJSON() : undefined,
						pcareDokter: entity.pcareDokter ? new PcareDokterModel(entity.pcareDokter).toJSON() : undefined,
						service: entity.service ? new ServiceModel(entity.service).toJSON() : undefined,
						accompanyingConsents: entity.accompanyingConsents ? entity.accompanyingConsents?.map((model: InformedConsentModel) => new InformedConsentModel(model).toJSON()) : [],
						amendmentDetails: entity.amendmentDetails ? entity.amendmentDetails?.map((model: AmendmentDetailModel) => new AmendmentDetailModel(model).toJSON()) : [],
						anesthesiaMedicalTranscriber: entity.anesthesiaMedicalTranscriber ? entity.anesthesiaMedicalTranscriber?.map((model: PreoperativeRecordsModel) => new PreoperativeRecordsModel(model).toJSON()) : [],
						anesthesiologist: entity.anesthesiologist ? entity.anesthesiologist?.map((model: PreoperativeRecordsModel) => new PreoperativeRecordsModel(model).toJSON()) : [],
						anesthesiologyNurse: entity.anesthesiologyNurse ? entity.anesthesiologyNurse?.map((model: PreoperativeRecordsModel) => new PreoperativeRecordsModel(model).toJSON()) : [],
						cashierStaff: entity.cashierStaff ? entity.cashierStaff?.map((model: CashReceiptModel) => new CashReceiptModel(model).toJSON()) : [],
						coTreatingDoctors: entity.coTreatingDoctors ? entity.coTreatingDoctors?.map((model: CoTreatingDoctorModel) => new CoTreatingDoctorModel(model).toJSON()) : [],
						dailyCareCPPTsCreatedByStaff: entity.dailyCareCPPTsCreatedByStaff ? entity.dailyCareCPPTsCreatedByStaff?.map((model: DailyCareCPPTModel) => new DailyCareCPPTModel(model).toJSON()) : [],
						dailyCareCPPTsDoctorInCharge: entity.dailyCareCPPTsDoctorInCharge ? entity.dailyCareCPPTsDoctorInCharge?.map((model: DailyCareCPPTModel) => new DailyCareCPPTModel(model).toJSON()) : [],
						dailyCareCPPTsMedicalTranscriber: entity.dailyCareCPPTsMedicalTranscriber ? entity.dailyCareCPPTsMedicalTranscriber?.map((model: DailyCareCPPTModel) => new DailyCareCPPTModel(model).toJSON()) : [],
						deliveryProgresses: entity.deliveryProgresses ? entity.deliveryProgresses?.map((model: DeliveryProgressModel) => new DeliveryProgressModel(model).toJSON()) : [],
						diagnosticStaffExaminationSummaries: entity.diagnosticStaffExaminationSummaries ? entity.diagnosticStaffExaminationSummaries?.map((model: DiagnosticStaffExaminationSummaryModel) => new DiagnosticStaffExaminationSummaryModel(model).toJSON()) : [],
						dismissalReferringStaff: entity.dismissalReferringStaff ? entity.dismissalReferringStaff?.map((model: RegistrationModel) => new RegistrationModel(model).toJSON()) : [],
						doctorSchedules: entity.doctorSchedules ? entity.doctorSchedules?.map((model: DoctorScheduleModel) => new DoctorScheduleModel(model).toJSON()) : [],
						doctorOnExamination: entity.doctorOnExamination ? entity.doctorOnExamination?.map((model: MedicalExaminationRecordModel) => new MedicalExaminationRecordModel(model).toJSON()) : [],
						fluidBalanceDetails: entity.fluidBalanceDetails ? entity.fluidBalanceDetails?.map((model: FluidBalanceDetailModel) => new FluidBalanceDetailModel(model).toJSON()) : [],
						hemodialysisMonitorings: entity.hemodialysisMonitorings ? entity.hemodialysisMonitorings?.map((model: HemodialysisMonitoringModel) => new HemodialysisMonitoringModel(model).toJSON()) : [],
						hospitalBranchInformations: entity.hospitalBranchInformations ? entity.hospitalBranchInformations?.map((model: HospitalBranchInformationModel) => new HospitalBranchInformationModel(model).toJSON()) : [],
						informingConsents: entity.informingConsents ? entity.informingConsents?.map((model: InformedConsentModel) => new InformedConsentModel(model).toJSON()) : [],
						invoices: entity.invoices ? entity.invoices?.map((model: InvoiceModel) => new InvoiceModel(model).toJSON()) : [],
						mcuPackageItems: entity.mcuPackageItems ? entity.mcuPackageItems?.map((model: McuPackageItemModel) => new McuPackageItemModel(model).toJSON()) : [],
						medicalCertificateDischargeResumes: entity.medicalCertificateDischargeResumes ? entity.medicalCertificateDischargeResumes?.map((model: MedicalCertificateDischargeResumeModel) => new MedicalCertificateDischargeResumeModel(model).toJSON()) : [],
						medicalCertificateBirths: entity.medicalCertificateBirths ? entity.medicalCertificateBirths?.map((model: MedicalCertificateBirthModel) => new MedicalCertificateBirthModel(model).toJSON()) : [],
						medicalCertificateHospitalizations: entity.medicalCertificateHospitalizations ? entity.medicalCertificateHospitalizations?.map((model: MedicalCertificateHospitalizationModel) => new MedicalCertificateHospitalizationModel(model).toJSON()) : [],
						medicalExaminationRecordDischargeSummarys: entity.medicalExaminationRecordDischargeSummarys ? entity.medicalExaminationRecordDischargeSummarys?.map((model: MedicalExaminationRecordDischargeSummaryModel) => new MedicalExaminationRecordDischargeSummaryModel(model).toJSON()) : [],
						medicalRecordTranscriber: entity.medicalRecordTranscriber ? entity.medicalRecordTranscriber?.map((model: MedicalExaminationRecordModel) => new MedicalExaminationRecordModel(model).toJSON()) : [],
						medicalStaffOfMedicalAttendancesCertificate: entity.medicalStaffOfMedicalAttendancesCertificate ? entity.medicalStaffOfMedicalAttendancesCertificate?.map((model: MedicalCertificateMedicalAttendanceModel) => new MedicalCertificateMedicalAttendanceModel(model).toJSON()) : [],
						medicalStaffOfMentalHealths: entity.medicalStaffOfMentalHealths ? entity.medicalStaffOfMentalHealths?.map((model: MedicalCertificateMentalHealthModel) => new MedicalCertificateMentalHealthModel(model).toJSON()) : [],
						medicalStaffOfPhysicalHealths: entity.medicalStaffOfPhysicalHealths ? entity.medicalStaffOfPhysicalHealths?.map((model: MedicalCertificatePhysicalHealthModel) => new MedicalCertificatePhysicalHealthModel(model).toJSON()) : [],
						medicalStaffOfRestrictedWorksCertificate: entity.medicalStaffOfRestrictedWorksCertificate ? entity.medicalStaffOfRestrictedWorksCertificate?.map((model: MedicalCertificateRestrictedWorkModel) => new MedicalCertificateRestrictedWorkModel(model).toJSON()) : [],
						medicalStaffOfSickLeavesCertificate: entity.medicalStaffOfSickLeavesCertificate ? entity.medicalStaffOfSickLeavesCertificate?.map((model: MedicalCertificateSickLeaveModel) => new MedicalCertificateSickLeaveModel(model).toJSON()) : [],
						medicationAdministeredHisotries: entity.medicationAdministeredHisotries ? entity.medicationAdministeredHisotries?.map((model: MedicationAdministeredHistoryModel) => new MedicationAdministeredHistoryModel(model).toJSON()) : [],
						medicationHeaders: entity.medicationHeaders ? entity.medicationHeaders?.map((model: MedicationHeaderModel) => new MedicationHeaderModel(model).toJSON()) : [],
						midwives: entity.midwives ? entity.midwives?.map((model: DeliveryMedicalExaminationRecordModel) => new DeliveryMedicalExaminationRecordModel(model).toJSON()) : [],
						nurse: entity.nurse ? entity.nurse?.map((model: MedicalExaminationRecordModel) => new MedicalExaminationRecordModel(model).toJSON()) : [],
						nursingDetailSurgicalNursing: entity.nursingDetailSurgicalNursing ? entity.nursingDetailSurgicalNursing?.map((model: OperatingTheaterMedicalExaminationRecordModel) => new OperatingTheaterMedicalExaminationRecordModel(model).toJSON()) : [],
						nursingDetailsAnesthesiaNursing: entity.nursingDetailsAnesthesiaNursing ? entity.nursingDetailsAnesthesiaNursing?.map((model: OperatingTheaterMedicalExaminationRecordModel) => new OperatingTheaterMedicalExaminationRecordModel(model).toJSON()) : [],
						patientConsents: entity.patientConsents ? entity.patientConsents?.map((model: PatientConsentModel) => new PatientConsentModel(model).toJSON()) : [],
						patientVitalInformations: entity.patientVitalInformations ? entity.patientVitalInformations?.map((model: PatientVitalInformationModel) => new PatientVitalInformationModel(model).toJSON()) : [],
						pediatricianInCharge: entity.pediatricianInCharge ? entity.pediatricianInCharge?.map((model: NewbornDetailModel) => new NewbornDetailModel(model).toJSON()) : [],
						prescriptionHeaders: entity.prescriptionHeaders ? entity.prescriptionHeaders?.map((model: PrescriptionHeaderModel) => new PrescriptionHeaderModel(model).toJSON()) : [],
						processWorkflowLogs: entity.processWorkflowLogs ? entity.processWorkflowLogs?.map((model: ProcessWorkflowModel) => new ProcessWorkflowModel(model).toJSON()) : [],
						registrations: entity.registrations ? entity.registrations?.map((model: RegistrationModel) => new RegistrationModel(model).toJSON()) : [],
						requestedBy: entity.requestedBy ? entity.requestedBy?.map((model: RegistrationModel) => new RegistrationModel(model).toJSON()) : [],
						roomTransfers: entity.roomTransfers ? entity.roomTransfers?.map((model: RoomTransferModel) => new RoomTransferModel(model).toJSON()) : [],
						sampleCollectionStaffs: entity.sampleCollectionStaffs ? entity.sampleCollectionStaffs?.map((model: SampleCollectionItemsModel) => new SampleCollectionItemsModel(model).toJSON()) : [],
						sampleDeliveryStaffs: entity.sampleDeliveryStaffs ? entity.sampleDeliveryStaffs?.map((model: SampleCollectionItemsModel) => new SampleCollectionItemsModel(model).toJSON()) : [],
						sampleProcessingStaffs: entity.sampleProcessingStaffs ? entity.sampleProcessingStaffs?.map((model: SampleCollectionItemsModel) => new SampleCollectionItemsModel(model).toJSON()) : [],
						surgeon: entity.surgeon ? entity.surgeon?.map((model: PreoperativeRecordsModel) => new PreoperativeRecordsModel(model).toJSON()) : [],
						surgicalMedicalTranscriber: entity.surgicalMedicalTranscriber ? entity.surgicalMedicalTranscriber?.map((model: PreoperativeRecordsModel) => new PreoperativeRecordsModel(model).toJSON()) : [],
						surgicalNurse: entity.surgicalNurse ? entity.surgicalNurse?.map((model: PreoperativeRecordsModel) => new PreoperativeRecordsModel(model).toJSON()) : [],
						transferOrderStockDetails: entity.transferOrderStockDetails ? entity.transferOrderStockDetails?.map((model: TransferOrderStockDetailModel) => new TransferOrderStockDetailModel(model).toJSON()) : [],
						vaccinationOrders: entity.vaccinationOrders ? entity.vaccinationOrders?.map((model: VaccinationOrderModel) => new VaccinationOrderModel(model).toJSON()) : [],
						services: entity.services ? entity.services?.map((model: ServiceModel) => new ServiceModel(model).toJSON()) : [],
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
					targetModel: result.data.staff as StaffModel,
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
	updateAll(entities: StaffModel[], queryParams?: QueryParams): Observable<PassableStateConfig<StaffModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] end

		// % protected region % [Customise the success message for updateAll here] off begin
		const successMessage = 'Update Multiple Staff entities successfully';
		// % protected region % [Customise the success message for updateAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation updateAll($staffs: [StaffInput!]!) {
						staff: updateAllStaff(staffs: $staffs) {
							...StaffProperties,
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
					staffs: entities.map(entity => entity.toJSON()),
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
					targetModels: result.data.staff as StaffModel[],
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
	delete(id: string): Observable<PassableStateConfig<StaffModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete here] end

		// % protected region % [Customise the success message for delete here] off begin
		const successMessage = 'Deleted Staff entity successfully';
		// % protected region % [Customise the success message for delete here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Delete($staffId: ID!) {
						staffId: deleteStaffById(staffId: $staffId)

						# % protected region % [Add any additional mutations for delete here] off begin
						# % protected region % [Add any additional mutations for delete here] end
					}

					# % protected region % [Add any additional GraphQL info for delete here] off begin
					# % protected region % [Add any additional GraphQL info for delete here] end
				`,
				variables: {
					staffId: id,
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
					targetModelId: result.data.staffId as string,
					// % protected region % [Add any additional info to be passed up for delete here] off begin
					// % protected region % [Add any additional info to be passed up for delete here] end
				};
			}),
			// % protected region % [Add any additional piping logic for delete here] off begin
			// % protected region % [Add any additional piping logic for delete here] end
		);
	}

	deleteExcludingIds(ids: string[]): Observable<PassableStateConfig<StaffModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] end

		// % protected region % [Customise the success message for delete excluding here] off begin
		const successMessage = 'Deleted selected Staff entities successfully';
		// % protected region % [Customise the success message for delete excluding here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation deleteAll($staffIds: [ID!]!){
						deleteStaffExcludingIds(staffIds: $staffIds)

						# % protected region % [Add any additional mutations for delete excluding here] off begin
						# % protected region % [Add any additional mutations for delete excluding here] end
					}

					# % protected region % [Add any additional GraphQL info for delete excluding here] off begin
					# % protected region % [Add any additional GraphQL info for delete excluding here] end
				`,
				variables: {
					staffIds: ids,
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
					targetModelIds: result.data.staffIds as string[],
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
	deleteAll(ids: string[]): Observable<PassableStateConfig<StaffModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] end

		// % protected region % [Customise the success message for deleteAll here] off begin
		const successMessage = 'Deleted selected Staff entities successfully';
		// % protected region % [Customise the success message for deleteAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation DeleteAll($staffIds: [ID!]!) {
						staffIds: deleteAllStaffByIds(staffIds: $staffIds)

						# % protected region % [Add any additional mutations for deleteAll here] off begin
						# % protected region % [Add any additional mutations for deleteAll here] end
					}

					# % protected region % [Add any additional GraphQL info for deleteAll here] off begin
					# % protected region % [Add any additional GraphQL info for deleteAll here] end
				`,
				variables: {
					staffIds: ids,
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
					targetModelIds: result.data.staffIds as string[],
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
	getAudits(): Observable<StaffModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] end

		return this.apollo.query<PassableStateConfig<StaffModel>>(
			{
				query: gql`
					query GetAudits {
						audits: staffAudits {
							entity {
								...StaffProperties
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
				let audits: StaffModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new StaffModel(audit.entity),
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
	getAuditsByEntityId(id: string): Observable<StaffModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] end

		return this.apollo.query<PassableStateConfig<StaffModel>>(
			{
				query: gql`
					query GetAuditsByEntityId($staffId: ID!) {
						audits: staffAuditsByEntityId(staffId: $staffId) {
							entity {
								...StaffProperties
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
					staffId: id,
					// % protected region % [Add any additional variables for getAuditsByEntityId here] off begin
					// % protected region % [Add any additional variables for getAuditsByEntityId here] end
				}
			}
		).pipe(
			map(result => {
				let audits: StaffModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new StaffModel(audit.entity),
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
	export(id: string): Observable<PassableStateConfig<StaffModel>> {
		const url = environment.API_URL + '/api/staff/export';
		const idParams = '?id=' + id;

		window.open(url + idParams);
		return of({
			targetModelId: id
		});
	}

	/**
	 * @inheritdoc
	 */
	exportAll(ids: string[]): Observable<PassableStateConfig<StaffModel>> {
		const url = environment.API_URL + '/api/staff/export';
		const idParams = '?ids=' + ids.join();

		window.open(url + idParams);

		return of({
			targetModelIds: ids
		});
	}

	exportModelsExcludingIds(ids: string[]): Observable<PassableStateConfig<StaffModel>> {
		let apiUrl = environment.API_URL + '/api/staff/export-excluding?ids=';

		if (ids.length > 0) {
			const idParams = ids.join();
			apiUrl = apiUrl.concat(idParams);
		}

		window.open(apiUrl);
		return of({
			targetModelIds: ids
		});
	}

	importModels(file: File): Observable<PassableStateConfig<StaffModel>> {
		const requestData: FormData = new FormData();
		requestData.append('file', file);

		let apiUrl = environment.API_URL + '/api/staff/import-csv';

		// % protected region % [Overwrite the url of the import api here] off begin
		// % protected region % [Overwrite the url of the import api here] end

		return this.http.post(apiUrl, requestData, {withCredentials: true, responseType: 'text'}).pipe(
			tap(result => this.toastrService.success('Successfully Imported ' + result.split(',').length + ' Staff entities')),

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
