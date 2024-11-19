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
import {MedicalExaminationRecordModel} from '../../models/medicalExaminationRecord/medical_examination_record.model';
import {MedicalExaminationRecordModelAudit} from '../../models/medicalExaminationRecord/medical_examination_record.model.state';
import {AuthenticationService} from '../../lib/services/authentication/authentication.service';
import {QueryParams, PassableStateConfig} from '../../lib/services/http/interfaces';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import {AmendmentDetailModel} from 'src/app/models/amendmentDetail/amendment_detail.model';
import {BirthHistoryModel} from 'src/app/models/birthHistory/birth_history.model';
import {BodyChartExaminationModel} from 'src/app/models/bodyChartExamination/body_chart_examination.model';
import {CoTreatingDoctorModel} from 'src/app/models/coTreatingDoctor/co_treating_doctor.model';
import {DailyCareCPPTModel} from 'src/app/models/dailyCareCPPT/daily_care_cppt.model';
import {DeliveryMedicalExaminationRecordModel} from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model';
import {DiagnosisExaminationRecordModel} from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model';
import {DiagnosisNandaModel} from 'src/app/models/diagnosisNanda/diagnosis_nanda.model';
import {EntExaminationModel} from 'src/app/models/entExamination/ent_examination.model';
import {EmergencyMedicalExaminationRecordModel} from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model';
import {FormulirKonselingTesHivModel} from 'src/app/models/formulirKonselingTesHiv/formulir_konseling_tes_hiv.model';
import {HemodialysisExaminationModel} from 'src/app/models/hemodialysisExamination/hemodialysis_examination.model';
import {InpatientMedicalExaminationRecordModel} from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model';
import {MedicalExaminationRecordDischargeSummaryModel} from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model';
import {MedicalRecordInitialChecklistModel} from 'src/app/models/medicalRecordInitialChecklist/medical_record_initial_checklist.model';
import {MedicalRecordNextVerificationChecklistModel} from 'src/app/models/medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model';
import {NurseVitalSignMeasurementModel} from 'src/app/models/nurseVitalSignMeasurement/nurse_vital_sign_measurement.model';
import {ObstetricAndGynecologyHistoryModel} from 'src/app/models/obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model';
import {OdontogramExaminationModel} from 'src/app/models/odontogramExamination/odontogram_examination.model';
import {OperatingTheaterMedicalExaminationRecordModel} from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import {OphthalmologyExaminationModel} from 'src/app/models/ophthalmologyExamination/ophthalmology_examination.model';
import {RegistrationModel} from 'src/app/models/registration/registration.model';
import {RoomTransferModel} from 'src/app/models/roomTransfer/room_transfer.model';
import {StaffModel} from 'src/app/models/staff/staff.model';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Medical Examination Record service used to handle all CRUD operations against this entity.
 */
@Injectable({
	providedIn: 'root'
})
export class MedicalExaminationRecordService extends AbstractHttpService<MedicalExaminationRecordModel, MedicalExaminationRecordModelAudit> {
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
			# % protected region % [Modify the MedicalExaminationRecordProperties classFragment here] off begin
			fragment MedicalExaminationRecordProperties on MedicalExaminationRecord {
				...MedicalExaminationRecordBaseProperties
				diastole
				systole
				pulse
				bpStandingSystole
				bpStandingDiastole
				pulseRegularity
				pulseStrength
				temperature
				temperatureScale
				gcsEyes
				gcsVerbal
				gcsMotor
				totalGCSScore
				consciousness
				height
				heightScale
				weight
				weightScale
				bmi
				respiratory
				oxygenSaturation
				waistCircumference
				waistCircumferenceUnit
				nutritionStatus
				painScale
				painScaleUsed
				riskFallScale
				objective
				riskFallScaleUsed
				subjective
				plan
				purpose
				examinationSubCase
				accidentalType
				serviceCase
				accidentalSubType
				additionalNotes
				dentalProcedure
				psychiatryCase
				therapy
				familyPlanning
				condition
				familyPlanningCase
				previousContraceptiveMethod
				sideEffects
				complication
				contraseptiveMethod
				visitType
				hearingTestMethod
				hearingTestNotes
				hearingLossCategory
				hearingLossNotes
				eyePositionRightEye
				eyePositionLeftEye
				muscleBalanceRightEye
				muscleBalanceLeftEye
				visualFieldRightEye
				visualFieldLeftEye
				ocularFunduscopyRightEye
				ocularFunduscopyLeftEye
				intraocularPressureRightEye
				intraocularPressureLeftEye
				colorBlindness
				visualAcuityRightEye
				visualAcuityLeftEye
				correctionRightEye
				correctionLeftEye
				additionRightEye
				additionLeftEye
				occlusion
				torusPalatinus
				torusMandibularis
				palatum
				diastema
				diastemaNotes
				toothAnomaly
				toothAnomalyNotes
				otherDentalNotes
				decayed
				missing
				filled
				totalPhotograph
				photographType
				totalRontgenPhotograph
				rontgenPhotographType
			}
			# % protected region % [Modify the MedicalExaminationRecordProperties classFragment here] end
			${super.fragments('MedicalExaminationRecord').properties}
		`,
		// % protected region % [Add any additional fragments here] off begin
		// % protected region % [Add any additional fragments here] end
	};

	/**
	 * @inheritDoc
	 */
	count(): Observable<PassableStateConfig<MedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for count here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for count here] end

		return  this.apollo.query<PassableStateConfig<MedicalExaminationRecordModel>>(
			{
				query: gql`
					query Count {
						totalCount: countMedicalExaminationRecords

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
	getAll(): Observable<PassableStateConfig<MedicalExaminationRecordModel>> {
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
	get(id: string, queryParams?: QueryParams): Observable<PassableStateConfig<MedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for get here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for get here] end

		const expands = queryParams && queryParams.expands ? queryParams.expands : [];

		return this.apollo.query<PassableStateConfig<MedicalExaminationRecordModel>>(
			{
				query: gql`
					query Get($id: ID!) {
						MedicalExaminationRecordById: medicalExaminationRecordById(id: $id) {
							...MedicalExaminationRecordProperties
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
					targetModel: result.data.MedicalExaminationRecordById as MedicalExaminationRecordModel,
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
	getWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<MedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] end

		return this.apollo.query<PassableStateConfig<MedicalExaminationRecordModel>>(
			{
				query: gql`
					query GetWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!], $where: [[Where!]!]) {
						medicalExaminationRecords: medicalExaminationRecords(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy, where: $where) {
							...MedicalExaminationRecordProperties
							${this.getExpands(queryParams.expands)}
						}

						totalCount: countMedicalExaminationRecords(where: $where)

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
					targetModels: result.data.medicalExaminationRecords as MedicalExaminationRecordModel[],
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
	getLastWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<MedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] end

		return this.apollo.query<PassableStateConfig<MedicalExaminationRecordModel>>(
			{
				query: gql`
					query GetLastWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!]!) {
						medicalExaminationRecords: lastMedicalExaminationRecords(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy) {
							...MedicalExaminationRecordProperties
						}

						totalCount: countMedicalExaminationRecords

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
					targetModels: result.data.medicalExaminationRecords as MedicalExaminationRecordModel[],
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
	create(entity: MedicalExaminationRecordModel, queryParams?: QueryParams): Observable<PassableStateConfig<MedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for create here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for create here] end

		// % protected region % [Customise the success message for create here] off begin
		const successMessage = 'Created Medical Examination Record entity successfully';
		// % protected region % [Customise the success message for create here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Create($medicalExaminationRecord: MedicalExaminationRecordInput!, $persistRelations: Boolean) {
						medicalExaminationRecord: createMedicalExaminationRecord(medicalExaminationRecord: $medicalExaminationRecord, persistRelations: $persistRelations) {
							...MedicalExaminationRecordProperties,
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
					medicalExaminationRecord: {
						...entity.toJSON(),
						inpatientMedicalExaminationRecord: entity.inpatientMedicalExaminationRecord ? new InpatientMedicalExaminationRecordModel(entity.inpatientMedicalExaminationRecord).toJSON() : undefined,
						registration: entity.registration ? new RegistrationModel(entity.registration).toJSON() : undefined,
						birthHistory: entity.birthHistory ? new BirthHistoryModel(entity.birthHistory).toJSON() : undefined,
						bodyChartExamination: entity.bodyChartExamination ? new BodyChartExaminationModel(entity.bodyChartExamination).toJSON() : undefined,
						deliveryMedicalExaminationRecord: entity.deliveryMedicalExaminationRecord ? new DeliveryMedicalExaminationRecordModel(entity.deliveryMedicalExaminationRecord).toJSON() : undefined,
						entExamination: entity.entExamination ? new EntExaminationModel(entity.entExamination).toJSON() : undefined,
						emergencyMedicationExaminationRecord: entity.emergencyMedicationExaminationRecord ? new EmergencyMedicalExaminationRecordModel(entity.emergencyMedicationExaminationRecord).toJSON() : undefined,
						formulirKonselingTesHiv: entity.formulirKonselingTesHiv ? new FormulirKonselingTesHivModel(entity.formulirKonselingTesHiv).toJSON() : undefined,
						hemodialysisExamination: entity.hemodialysisExamination ? new HemodialysisExaminationModel(entity.hemodialysisExamination).toJSON() : undefined,
						medicalExaminationRecordDischargeSummary: entity.medicalExaminationRecordDischargeSummary ? new MedicalExaminationRecordDischargeSummaryModel(entity.medicalExaminationRecordDischargeSummary).toJSON() : undefined,
						medicalRecordInitialChecklist: entity.medicalRecordInitialChecklist ? new MedicalRecordInitialChecklistModel(entity.medicalRecordInitialChecklist).toJSON() : undefined,
						medicalRecordNextVerificationChecklist: entity.medicalRecordNextVerificationChecklist ? new MedicalRecordNextVerificationChecklistModel(entity.medicalRecordNextVerificationChecklist).toJSON() : undefined,
						nurseVitalSignMeasurement: entity.nurseVitalSignMeasurement ? new NurseVitalSignMeasurementModel(entity.nurseVitalSignMeasurement).toJSON() : undefined,
						obstetricAndGynecologyHistory: entity.obstetricAndGynecologyHistory ? new ObstetricAndGynecologyHistoryModel(entity.obstetricAndGynecologyHistory).toJSON() : undefined,
						odontogramExamination: entity.odontogramExamination ? new OdontogramExaminationModel(entity.odontogramExamination).toJSON() : undefined,
						operatingTheaterMedicalExaminationRecord: entity.operatingTheaterMedicalExaminationRecord ? new OperatingTheaterMedicalExaminationRecordModel(entity.operatingTheaterMedicalExaminationRecord).toJSON() : undefined,
						ophthalmologyExamination: entity.ophthalmologyExamination ? new OphthalmologyExaminationModel(entity.ophthalmologyExamination).toJSON() : undefined,
						doctor: entity.doctor ? new StaffModel(entity.doctor).toJSON() : undefined,
						medicalTranscriber: entity.medicalTranscriber ? new StaffModel(entity.medicalTranscriber).toJSON() : undefined,
						nurse: entity.nurse ? new StaffModel(entity.nurse).toJSON() : undefined,
						amendmentDetails: entity.amendmentDetails ? entity.amendmentDetails?.map((model: AmendmentDetailModel) => new AmendmentDetailModel(model).toJSON()) : [],
						coTreatingDoctors: entity.coTreatingDoctors ? entity.coTreatingDoctors?.map((model: CoTreatingDoctorModel) => new CoTreatingDoctorModel(model).toJSON()) : [],
						dailyCareCPPTs: entity.dailyCareCPPTs ? entity.dailyCareCPPTs?.map((model: DailyCareCPPTModel) => new DailyCareCPPTModel(model).toJSON()) : [],
						diagnosisExaminationRecords: entity.diagnosisExaminationRecords ? entity.diagnosisExaminationRecords?.map((model: DiagnosisExaminationRecordModel) => new DiagnosisExaminationRecordModel(model).toJSON()) : [],
						diagnosisNandas: entity.diagnosisNandas ? entity.diagnosisNandas?.map((model: DiagnosisNandaModel) => new DiagnosisNandaModel(model).toJSON()) : [],
						roomTransfers: entity.roomTransfers ? entity.roomTransfers?.map((model: RoomTransferModel) => new RoomTransferModel(model).toJSON()) : [],
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
					targetModel: result.data.medicalExaminationRecord as MedicalExaminationRecordModel,
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
	createAll(entities: MedicalExaminationRecordModel[], queryParams?: QueryParams): Observable<PassableStateConfig<MedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] end

		// % protected region % [Customise the success message for createAll here] off begin
		const successMessage = 'Created Multiple Medical Examination Record entities successfully';
		// % protected region % [Customise the success message for createAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation createAll($medicalExaminationRecords: [MedicalExaminationRecordInput!]!) {
						medicalExaminationRecord: createAllMedicalExaminationRecord(medicalExaminationRecords: $medicalExaminationRecords) {
							...MedicalExaminationRecordProperties,
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
					medicalExaminationRecords: entities.map(entity => entity.toJSON()),
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
					targetModels: result.data.medicalExaminationRecord as MedicalExaminationRecordModel[],
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
	update(entity: MedicalExaminationRecordModel, queryParams?: QueryParams): Observable<PassableStateConfig<MedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for update here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for update here] end

		// % protected region % [Customise the success message for update here] off begin
		const successMessage = 'Updated Medical Examination Record entity successfully';
		// % protected region % [Customise the success message for update here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Update($medicalExaminationRecord: MedicalExaminationRecordInput!, $persistRelations: Boolean) {
						medicalExaminationRecord: updateMedicalExaminationRecord(medicalExaminationRecord: $medicalExaminationRecord, persistRelations: $persistRelations) {
							...MedicalExaminationRecordProperties,
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
					medicalExaminationRecord: {
						...entity.toJSON(),
						inpatientMedicalExaminationRecord: entity.inpatientMedicalExaminationRecord ? new InpatientMedicalExaminationRecordModel(entity.inpatientMedicalExaminationRecord).toJSON() : undefined,
						registration: entity.registration ? new RegistrationModel(entity.registration).toJSON() : undefined,
						birthHistory: entity.birthHistory ? new BirthHistoryModel(entity.birthHistory).toJSON() : undefined,
						bodyChartExamination: entity.bodyChartExamination ? new BodyChartExaminationModel(entity.bodyChartExamination).toJSON() : undefined,
						deliveryMedicalExaminationRecord: entity.deliveryMedicalExaminationRecord ? new DeliveryMedicalExaminationRecordModel(entity.deliveryMedicalExaminationRecord).toJSON() : undefined,
						entExamination: entity.entExamination ? new EntExaminationModel(entity.entExamination).toJSON() : undefined,
						emergencyMedicationExaminationRecord: entity.emergencyMedicationExaminationRecord ? new EmergencyMedicalExaminationRecordModel(entity.emergencyMedicationExaminationRecord).toJSON() : undefined,
						formulirKonselingTesHiv: entity.formulirKonselingTesHiv ? new FormulirKonselingTesHivModel(entity.formulirKonselingTesHiv).toJSON() : undefined,
						hemodialysisExamination: entity.hemodialysisExamination ? new HemodialysisExaminationModel(entity.hemodialysisExamination).toJSON() : undefined,
						medicalExaminationRecordDischargeSummary: entity.medicalExaminationRecordDischargeSummary ? new MedicalExaminationRecordDischargeSummaryModel(entity.medicalExaminationRecordDischargeSummary).toJSON() : undefined,
						medicalRecordInitialChecklist: entity.medicalRecordInitialChecklist ? new MedicalRecordInitialChecklistModel(entity.medicalRecordInitialChecklist).toJSON() : undefined,
						medicalRecordNextVerificationChecklist: entity.medicalRecordNextVerificationChecklist ? new MedicalRecordNextVerificationChecklistModel(entity.medicalRecordNextVerificationChecklist).toJSON() : undefined,
						nurseVitalSignMeasurement: entity.nurseVitalSignMeasurement ? new NurseVitalSignMeasurementModel(entity.nurseVitalSignMeasurement).toJSON() : undefined,
						obstetricAndGynecologyHistory: entity.obstetricAndGynecologyHistory ? new ObstetricAndGynecologyHistoryModel(entity.obstetricAndGynecologyHistory).toJSON() : undefined,
						odontogramExamination: entity.odontogramExamination ? new OdontogramExaminationModel(entity.odontogramExamination).toJSON() : undefined,
						operatingTheaterMedicalExaminationRecord: entity.operatingTheaterMedicalExaminationRecord ? new OperatingTheaterMedicalExaminationRecordModel(entity.operatingTheaterMedicalExaminationRecord).toJSON() : undefined,
						ophthalmologyExamination: entity.ophthalmologyExamination ? new OphthalmologyExaminationModel(entity.ophthalmologyExamination).toJSON() : undefined,
						doctor: entity.doctor ? new StaffModel(entity.doctor).toJSON() : undefined,
						medicalTranscriber: entity.medicalTranscriber ? new StaffModel(entity.medicalTranscriber).toJSON() : undefined,
						nurse: entity.nurse ? new StaffModel(entity.nurse).toJSON() : undefined,
						amendmentDetails: entity.amendmentDetails ? entity.amendmentDetails?.map((model: AmendmentDetailModel) => new AmendmentDetailModel(model).toJSON()) : [],
						coTreatingDoctors: entity.coTreatingDoctors ? entity.coTreatingDoctors?.map((model: CoTreatingDoctorModel) => new CoTreatingDoctorModel(model).toJSON()) : [],
						dailyCareCPPTs: entity.dailyCareCPPTs ? entity.dailyCareCPPTs?.map((model: DailyCareCPPTModel) => new DailyCareCPPTModel(model).toJSON()) : [],
						diagnosisExaminationRecords: entity.diagnosisExaminationRecords ? entity.diagnosisExaminationRecords?.map((model: DiagnosisExaminationRecordModel) => new DiagnosisExaminationRecordModel(model).toJSON()) : [],
						diagnosisNandas: entity.diagnosisNandas ? entity.diagnosisNandas?.map((model: DiagnosisNandaModel) => new DiagnosisNandaModel(model).toJSON()) : [],
						roomTransfers: entity.roomTransfers ? entity.roomTransfers?.map((model: RoomTransferModel) => new RoomTransferModel(model).toJSON()) : [],
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
					targetModel: result.data.medicalExaminationRecord as MedicalExaminationRecordModel,
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
	updateAll(entities: MedicalExaminationRecordModel[], queryParams?: QueryParams): Observable<PassableStateConfig<MedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] end

		// % protected region % [Customise the success message for updateAll here] off begin
		const successMessage = 'Update Multiple Medical Examination Record entities successfully';
		// % protected region % [Customise the success message for updateAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation updateAll($medicalExaminationRecords: [MedicalExaminationRecordInput!]!) {
						medicalExaminationRecord: updateAllMedicalExaminationRecord(medicalExaminationRecords: $medicalExaminationRecords) {
							...MedicalExaminationRecordProperties,
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
					medicalExaminationRecords: entities.map(entity => entity.toJSON()),
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
					targetModels: result.data.medicalExaminationRecord as MedicalExaminationRecordModel[],
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
	delete(id: string): Observable<PassableStateConfig<MedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete here] end

		// % protected region % [Customise the success message for delete here] off begin
		const successMessage = 'Deleted Medical Examination Record entity successfully';
		// % protected region % [Customise the success message for delete here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Delete($medicalExaminationRecordId: ID!) {
						medicalExaminationRecordId: deleteMedicalExaminationRecordById(medicalExaminationRecordId: $medicalExaminationRecordId)

						# % protected region % [Add any additional mutations for delete here] off begin
						# % protected region % [Add any additional mutations for delete here] end
					}

					# % protected region % [Add any additional GraphQL info for delete here] off begin
					# % protected region % [Add any additional GraphQL info for delete here] end
				`,
				variables: {
					medicalExaminationRecordId: id,
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
					targetModelId: result.data.medicalExaminationRecordId as string,
					// % protected region % [Add any additional info to be passed up for delete here] off begin
					// % protected region % [Add any additional info to be passed up for delete here] end
				};
			}),
			// % protected region % [Add any additional piping logic for delete here] off begin
			// % protected region % [Add any additional piping logic for delete here] end
		);
	}

	deleteExcludingIds(ids: string[]): Observable<PassableStateConfig<MedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] end

		// % protected region % [Customise the success message for delete excluding here] off begin
		const successMessage = 'Deleted selected Medical Examination Record entities successfully';
		// % protected region % [Customise the success message for delete excluding here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation deleteAll($medicalExaminationRecordIds: [ID!]!){
						deleteMedicalExaminationRecordExcludingIds(medicalExaminationRecordIds: $medicalExaminationRecordIds)

						# % protected region % [Add any additional mutations for delete excluding here] off begin
						# % protected region % [Add any additional mutations for delete excluding here] end
					}

					# % protected region % [Add any additional GraphQL info for delete excluding here] off begin
					# % protected region % [Add any additional GraphQL info for delete excluding here] end
				`,
				variables: {
					medicalExaminationRecordIds: ids,
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
					targetModelIds: result.data.medicalExaminationRecordIds as string[],
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
	deleteAll(ids: string[]): Observable<PassableStateConfig<MedicalExaminationRecordModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] end

		// % protected region % [Customise the success message for deleteAll here] off begin
		const successMessage = 'Deleted selected Medical Examination Record entities successfully';
		// % protected region % [Customise the success message for deleteAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation DeleteAll($medicalExaminationRecordIds: [ID!]!) {
						medicalExaminationRecordIds: deleteAllMedicalExaminationRecordByIds(medicalExaminationRecordIds: $medicalExaminationRecordIds)

						# % protected region % [Add any additional mutations for deleteAll here] off begin
						# % protected region % [Add any additional mutations for deleteAll here] end
					}

					# % protected region % [Add any additional GraphQL info for deleteAll here] off begin
					# % protected region % [Add any additional GraphQL info for deleteAll here] end
				`,
				variables: {
					medicalExaminationRecordIds: ids,
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
					targetModelIds: result.data.medicalExaminationRecordIds as string[],
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
	getAudits(): Observable<MedicalExaminationRecordModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] end

		return this.apollo.query<PassableStateConfig<MedicalExaminationRecordModel>>(
			{
				query: gql`
					query GetAudits {
						audits: medicalExaminationRecordAudits {
							entity {
								...MedicalExaminationRecordProperties
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
				let audits: MedicalExaminationRecordModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new MedicalExaminationRecordModel(audit.entity),
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
	getAuditsByEntityId(id: string): Observable<MedicalExaminationRecordModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] end

		return this.apollo.query<PassableStateConfig<MedicalExaminationRecordModel>>(
			{
				query: gql`
					query GetAuditsByEntityId($medicalExaminationRecordId: ID!) {
						audits: medicalExaminationRecordAuditsByEntityId(medicalExaminationRecordId: $medicalExaminationRecordId) {
							entity {
								...MedicalExaminationRecordProperties
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
					medicalExaminationRecordId: id,
					// % protected region % [Add any additional variables for getAuditsByEntityId here] off begin
					// % protected region % [Add any additional variables for getAuditsByEntityId here] end
				}
			}
		).pipe(
			map(result => {
				let audits: MedicalExaminationRecordModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new MedicalExaminationRecordModel(audit.entity),
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
	export(id: string): Observable<PassableStateConfig<MedicalExaminationRecordModel>> {
		const url = environment.API_URL + '/api/medicalexaminationrecord/export';
		const idParams = '?id=' + id;

		window.open(url + idParams);
		return of({
			targetModelId: id
		});
	}

	/**
	 * @inheritdoc
	 */
	exportAll(ids: string[]): Observable<PassableStateConfig<MedicalExaminationRecordModel>> {
		const url = environment.API_URL + '/api/medicalexaminationrecord/export';
		const idParams = '?ids=' + ids.join();

		window.open(url + idParams);

		return of({
			targetModelIds: ids
		});
	}

	exportModelsExcludingIds(ids: string[]): Observable<PassableStateConfig<MedicalExaminationRecordModel>> {
		let apiUrl = environment.API_URL + '/api/medicalexaminationrecord/export-excluding?ids=';

		if (ids.length > 0) {
			const idParams = ids.join();
			apiUrl = apiUrl.concat(idParams);
		}

		window.open(apiUrl);
		return of({
			targetModelIds: ids
		});
	}

	importModels(file: File): Observable<PassableStateConfig<MedicalExaminationRecordModel>> {
		const requestData: FormData = new FormData();
		requestData.append('file', file);

		let apiUrl = environment.API_URL + '/api/medicalexaminationrecord/import-csv';

		// % protected region % [Overwrite the url of the import api here] off begin
		// % protected region % [Overwrite the url of the import api here] end

		return this.http.post(apiUrl, requestData, {withCredentials: true, responseType: 'text'}).pipe(
			tap(result => this.toastrService.success('Successfully Imported ' + result.split(',').length + ' Medical Examination Record entities')),

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
