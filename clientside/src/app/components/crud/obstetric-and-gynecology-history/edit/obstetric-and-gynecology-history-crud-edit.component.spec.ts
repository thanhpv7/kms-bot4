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

import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { By } from '@angular/platform-browser';
import { ComponentFixture, TestBed, waitForAsync, fakeAsync } from '@angular/core/testing';
import { CookieService } from 'ngx-cookie-service';
import { DebugElement } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { Store } from '@ngrx/store';
import { MockStore, provideMockStore } from '@ngrx/store/testing';
import { ModalDialogService, ModalDialogInstanceService } from '@preeco-privacy/ngx-modal-dialog';
import { ActivatedRouteStub } from 'src/testing/helpers/activated-route-stub';
import { CommonComponentModule } from 'src/app/lib/components/common.component.module';
import { getRouterState } from 'src/app/models/model.selector';
import { RouterState } from 'src/app/models/model.state';
import { 
	getObstetricAndGynecologyHistoryCollectionModels,
	getCountObstetricAndGynecologyHistoryModels,
	getObstetricAndGynecologyHistoryModelWithId
} from 'src/app/models/obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model.selector';
import { ObstetricAndGynecologyHistoryCrudModule } from '../obstetric-and-gynecology-history-crud.module';
import { ObstetricAndGynecologyHistoryCrudEditComponent } from './obstetric-and-gynecology-history-crud-edit.component';
import {
	ObstetricAndGynecologyHistoryModelState,
	initialState as initialObstetricAndGynecologyHistoryModelState
} from 'src/app/models/obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model.state';
import { ObstetricAndGynecologyHistoryDataFactory } from 'src/app/lib/utils/factories/obstetric-and-gynecology-history-data-factory';
import { ObstetricAndGynecologyHistoryModel } from 'src/app/models/obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model';
import { CrudTileMode } from '../obstetric-and-gynecology-history-crud.component';
import { getAmendmentDetailModelWithId } from 'src/app/models/amendmentDetail/amendment_detail.model.selector';
import { getAmendmentDetailCollectionModels } from 'src/app/models/amendmentDetail/amendment_detail.model.selector';
import { AmendmentDetailModel } from 'src/app/models/amendmentDetail/amendment_detail.model';
import { AmendmentDetailDataFactory } from 'src/app/lib/utils/factories/amendment-detail-data-factory';
import { getBirthHistoryModelWithId } from 'src/app/models/birthHistory/birth_history.model.selector';
import { getBirthHistoryCollectionModels } from 'src/app/models/birthHistory/birth_history.model.selector';
import { BirthHistoryModel } from 'src/app/models/birthHistory/birth_history.model';
import { BirthHistoryDataFactory } from 'src/app/lib/utils/factories/birth-history-data-factory';
import { getBodyChartExaminationModelWithId } from 'src/app/models/bodyChartExamination/body_chart_examination.model.selector';
import { getBodyChartExaminationCollectionModels } from 'src/app/models/bodyChartExamination/body_chart_examination.model.selector';
import { BodyChartExaminationModel } from 'src/app/models/bodyChartExamination/body_chart_examination.model';
import { BodyChartExaminationDataFactory } from 'src/app/lib/utils/factories/body-chart-examination-data-factory';
import { getCoTreatingDoctorModelWithId } from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.selector';
import { getCoTreatingDoctorCollectionModels } from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.selector';
import { CoTreatingDoctorModel } from 'src/app/models/coTreatingDoctor/co_treating_doctor.model';
import { CoTreatingDoctorDataFactory } from 'src/app/lib/utils/factories/co-treating-doctor-data-factory';
import { getDailyCareCPPTModelWithId } from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.selector';
import { getDailyCareCPPTCollectionModels } from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.selector';
import { DailyCareCPPTModel } from 'src/app/models/dailyCareCPPT/daily_care_cppt.model';
import { DailyCareCPPTDataFactory } from 'src/app/lib/utils/factories/daily-care-cppt-data-factory';
import { getDeliveryMedicalExaminationRecordModelWithId } from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.selector';
import { getDeliveryMedicalExaminationRecordCollectionModels } from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.selector';
import { DeliveryMedicalExaminationRecordModel } from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model';
import { DeliveryMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/delivery-medical-examination-record-data-factory';
import { getDiagnosisExaminationRecordModelWithId } from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model.selector';
import { getDiagnosisExaminationRecordCollectionModels } from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model.selector';
import { DiagnosisExaminationRecordModel } from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model';
import { DiagnosisExaminationRecordDataFactory } from 'src/app/lib/utils/factories/diagnosis-examination-record-data-factory';
import { getDiagnosisNandaModelWithId } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model.selector';
import { getDiagnosisNandaCollectionModels } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model.selector';
import { DiagnosisNandaModel } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model';
import { DiagnosisNandaDataFactory } from 'src/app/lib/utils/factories/diagnosis-nanda-data-factory';
import { getEntExaminationModelWithId } from 'src/app/models/entExamination/ent_examination.model.selector';
import { getEntExaminationCollectionModels } from 'src/app/models/entExamination/ent_examination.model.selector';
import { EntExaminationModel } from 'src/app/models/entExamination/ent_examination.model';
import { EntExaminationDataFactory } from 'src/app/lib/utils/factories/ent-examination-data-factory';
import { getEmergencyMedicalExaminationRecordModelWithId } from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model.selector';
import { getEmergencyMedicalExaminationRecordCollectionModels } from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model.selector';
import { EmergencyMedicalExaminationRecordModel } from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model';
import { EmergencyMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/emergency-medical-examination-record-data-factory';
import { getFormulirKonselingTesHivModelWithId } from 'src/app/models/formulirKonselingTesHiv/formulir_konseling_tes_hiv.model.selector';
import { getFormulirKonselingTesHivCollectionModels } from 'src/app/models/formulirKonselingTesHiv/formulir_konseling_tes_hiv.model.selector';
import { FormulirKonselingTesHivModel } from 'src/app/models/formulirKonselingTesHiv/formulir_konseling_tes_hiv.model';
import { FormulirKonselingTesHivDataFactory } from 'src/app/lib/utils/factories/formulir-konseling-tes-hiv-data-factory';
import { getHemodialysisExaminationModelWithId } from 'src/app/models/hemodialysisExamination/hemodialysis_examination.model.selector';
import { getHemodialysisExaminationCollectionModels } from 'src/app/models/hemodialysisExamination/hemodialysis_examination.model.selector';
import { HemodialysisExaminationModel } from 'src/app/models/hemodialysisExamination/hemodialysis_examination.model';
import { HemodialysisExaminationDataFactory } from 'src/app/lib/utils/factories/hemodialysis-examination-data-factory';
import { getInpatientMedicalExaminationRecordModelWithId } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.selector';
import { getInpatientMedicalExaminationRecordCollectionModels } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.selector';
import { InpatientMedicalExaminationRecordModel } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model';
import { InpatientMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/inpatient-medical-examination-record-data-factory';
import { getMedicalExaminationRecordModelWithId } from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.selector';
import { getMedicalExaminationRecordCollectionModels } from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.selector';
import { MedicalExaminationRecordModel } from 'src/app/models/medicalExaminationRecord/medical_examination_record.model';
import { MedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/medical-examination-record-data-factory';
import { getMedicalExaminationRecordDischargeSummaryModelWithId } from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model.selector';
import { getMedicalExaminationRecordDischargeSummaryCollectionModels } from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model.selector';
import { MedicalExaminationRecordDischargeSummaryModel } from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model';
import { MedicalExaminationRecordDischargeSummaryDataFactory } from 'src/app/lib/utils/factories/medical-examination-record-discharge-summary-data-factory';
import { getMedicalRecordInitialChecklistModelWithId } from 'src/app/models/medicalRecordInitialChecklist/medical_record_initial_checklist.model.selector';
import { getMedicalRecordInitialChecklistCollectionModels } from 'src/app/models/medicalRecordInitialChecklist/medical_record_initial_checklist.model.selector';
import { MedicalRecordInitialChecklistModel } from 'src/app/models/medicalRecordInitialChecklist/medical_record_initial_checklist.model';
import { MedicalRecordInitialChecklistDataFactory } from 'src/app/lib/utils/factories/medical-record-initial-checklist-data-factory';
import { getMedicalRecordNextVerificationChecklistModelWithId } from 'src/app/models/medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model.selector';
import { getMedicalRecordNextVerificationChecklistCollectionModels } from 'src/app/models/medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model.selector';
import { MedicalRecordNextVerificationChecklistModel } from 'src/app/models/medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model';
import { MedicalRecordNextVerificationChecklistDataFactory } from 'src/app/lib/utils/factories/medical-record-next-verification-checklist-data-factory';
import { getNurseVitalSignMeasurementModelWithId } from 'src/app/models/nurseVitalSignMeasurement/nurse_vital_sign_measurement.model.selector';
import { getNurseVitalSignMeasurementCollectionModels } from 'src/app/models/nurseVitalSignMeasurement/nurse_vital_sign_measurement.model.selector';
import { NurseVitalSignMeasurementModel } from 'src/app/models/nurseVitalSignMeasurement/nurse_vital_sign_measurement.model';
import { NurseVitalSignMeasurementDataFactory } from 'src/app/lib/utils/factories/nurse-vital-sign-measurement-data-factory';
import { getOdontogramExaminationModelWithId } from 'src/app/models/odontogramExamination/odontogram_examination.model.selector';
import { getOdontogramExaminationCollectionModels } from 'src/app/models/odontogramExamination/odontogram_examination.model.selector';
import { OdontogramExaminationModel } from 'src/app/models/odontogramExamination/odontogram_examination.model';
import { OdontogramExaminationDataFactory } from 'src/app/lib/utils/factories/odontogram-examination-data-factory';
import { getOperatingTheaterMedicalExaminationRecordModelWithId } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import { getOperatingTheaterMedicalExaminationRecordCollectionModels } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import { OperatingTheaterMedicalExaminationRecordModel } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import { OperatingTheaterMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/operating-theater-medical-examination-record-data-factory';
import { getOphthalmologyExaminationModelWithId } from 'src/app/models/ophthalmologyExamination/ophthalmology_examination.model.selector';
import { getOphthalmologyExaminationCollectionModels } from 'src/app/models/ophthalmologyExamination/ophthalmology_examination.model.selector';
import { OphthalmologyExaminationModel } from 'src/app/models/ophthalmologyExamination/ophthalmology_examination.model';
import { OphthalmologyExaminationDataFactory } from 'src/app/lib/utils/factories/ophthalmology-examination-data-factory';
import { getRegistrationModelWithId } from 'src/app/models/registration/registration.model.selector';
import { getRegistrationCollectionModels } from 'src/app/models/registration/registration.model.selector';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { RegistrationDataFactory } from 'src/app/lib/utils/factories/registration-data-factory';
import { getRoomTransferModelWithId } from 'src/app/models/roomTransfer/room_transfer.model.selector';
import { getRoomTransferCollectionModels } from 'src/app/models/roomTransfer/room_transfer.model.selector';
import { RoomTransferModel } from 'src/app/models/roomTransfer/room_transfer.model';
import { RoomTransferDataFactory } from 'src/app/lib/utils/factories/room-transfer-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';

describe('Obstetric And Gynecology History CRUD Edit component tests', () => {
	let fixture: ComponentFixture<ObstetricAndGynecologyHistoryCrudEditComponent>
	let component: ObstetricAndGynecologyHistoryCrudEditComponent;

	let obstetricAndGynecologyHistoryModelState: ObstetricAndGynecologyHistoryModelState;

	let store: MockStore<{ model: ObstetricAndGynecologyHistoryModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let obstetricAndGynecologyHistoryCountBehaviorSubject: BehaviorSubject<number>;
	let obstetricAndGynecologyHistoryModelsBehaviorSubject: BehaviorSubject<ObstetricAndGynecologyHistoryModel[]>;
	let amendmentDetailModelsBehaviorSubject: BehaviorSubject<AmendmentDetailModel[]>;
	let birthHistoryModelsBehaviorSubject: BehaviorSubject<BirthHistoryModel[]>;
	let bodyChartExaminationModelsBehaviorSubject: BehaviorSubject<BodyChartExaminationModel[]>;
	let coTreatingDoctorModelsBehaviorSubject: BehaviorSubject<CoTreatingDoctorModel[]>;
	let dailyCareCPPTModelsBehaviorSubject: BehaviorSubject<DailyCareCPPTModel[]>;
	let deliveryMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<DeliveryMedicalExaminationRecordModel[]>;
	let diagnosisExaminationRecordModelsBehaviorSubject: BehaviorSubject<DiagnosisExaminationRecordModel[]>;
	let diagnosisNandaModelsBehaviorSubject: BehaviorSubject<DiagnosisNandaModel[]>;
	let entExaminationModelsBehaviorSubject: BehaviorSubject<EntExaminationModel[]>;
	let emergencyMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<EmergencyMedicalExaminationRecordModel[]>;
	let formulirKonselingTesHivModelsBehaviorSubject: BehaviorSubject<FormulirKonselingTesHivModel[]>;
	let hemodialysisExaminationModelsBehaviorSubject: BehaviorSubject<HemodialysisExaminationModel[]>;
	let inpatientMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<InpatientMedicalExaminationRecordModel[]>;
	let medicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<MedicalExaminationRecordModel[]>;
	let medicalExaminationRecordDischargeSummaryModelsBehaviorSubject: BehaviorSubject<MedicalExaminationRecordDischargeSummaryModel[]>;
	let medicalRecordInitialChecklistModelsBehaviorSubject: BehaviorSubject<MedicalRecordInitialChecklistModel[]>;
	let medicalRecordNextVerificationChecklistModelsBehaviorSubject: BehaviorSubject<MedicalRecordNextVerificationChecklistModel[]>;
	let nurseVitalSignMeasurementModelsBehaviorSubject: BehaviorSubject<NurseVitalSignMeasurementModel[]>;
	let odontogramExaminationModelsBehaviorSubject: BehaviorSubject<OdontogramExaminationModel[]>;
	let operatingTheaterMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<OperatingTheaterMedicalExaminationRecordModel[]>;
	let ophthalmologyExaminationModelsBehaviorSubject: BehaviorSubject<OphthalmologyExaminationModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let roomTransferModelsBehaviorSubject: BehaviorSubject<RoomTransferModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;

	const obstetricAndGynecologyHistoryFactory: ObstetricAndGynecologyHistoryDataFactory = new ObstetricAndGynecologyHistoryDataFactory();
	const defaultObstetricAndGynecologyHistoryCount: number = 10;
	const defaultObstetricAndGynecologyHistoryEntities: ObstetricAndGynecologyHistoryModel[] = obstetricAndGynecologyHistoryFactory.createAll(defaultObstetricAndGynecologyHistoryCount);

	const amendmentDetailFactory: AmendmentDetailDataFactory = new AmendmentDetailDataFactory();
	const defaultAmendmentDetailCount: number = 10;
	const defaultAmendmentDetailEntities: AmendmentDetailModel[] = amendmentDetailFactory.createAll(defaultAmendmentDetailCount);

	const birthHistoryFactory: BirthHistoryDataFactory = new BirthHistoryDataFactory();
	const defaultBirthHistoryCount: number = 10;
	const defaultBirthHistoryEntities: BirthHistoryModel[] = birthHistoryFactory.createAll(defaultBirthHistoryCount);

	const bodyChartExaminationFactory: BodyChartExaminationDataFactory = new BodyChartExaminationDataFactory();
	const defaultBodyChartExaminationCount: number = 10;
	const defaultBodyChartExaminationEntities: BodyChartExaminationModel[] = bodyChartExaminationFactory.createAll(defaultBodyChartExaminationCount);

	const coTreatingDoctorFactory: CoTreatingDoctorDataFactory = new CoTreatingDoctorDataFactory();
	const defaultCoTreatingDoctorCount: number = 10;
	const defaultCoTreatingDoctorEntities: CoTreatingDoctorModel[] = coTreatingDoctorFactory.createAll(defaultCoTreatingDoctorCount);

	const dailyCareCPPTFactory: DailyCareCPPTDataFactory = new DailyCareCPPTDataFactory();
	const defaultDailyCareCPPTCount: number = 10;
	const defaultDailyCareCPPTEntities: DailyCareCPPTModel[] = dailyCareCPPTFactory.createAll(defaultDailyCareCPPTCount);

	const deliveryMedicalExaminationRecordFactory: DeliveryMedicalExaminationRecordDataFactory = new DeliveryMedicalExaminationRecordDataFactory();
	const defaultDeliveryMedicalExaminationRecordCount: number = 10;
	const defaultDeliveryMedicalExaminationRecordEntities: DeliveryMedicalExaminationRecordModel[] = deliveryMedicalExaminationRecordFactory.createAll(defaultDeliveryMedicalExaminationRecordCount);

	const diagnosisExaminationRecordFactory: DiagnosisExaminationRecordDataFactory = new DiagnosisExaminationRecordDataFactory();
	const defaultDiagnosisExaminationRecordCount: number = 10;
	const defaultDiagnosisExaminationRecordEntities: DiagnosisExaminationRecordModel[] = diagnosisExaminationRecordFactory.createAll(defaultDiagnosisExaminationRecordCount);

	const diagnosisNandaFactory: DiagnosisNandaDataFactory = new DiagnosisNandaDataFactory();
	const defaultDiagnosisNandaCount: number = 10;
	const defaultDiagnosisNandaEntities: DiagnosisNandaModel[] = diagnosisNandaFactory.createAll(defaultDiagnosisNandaCount);

	const entExaminationFactory: EntExaminationDataFactory = new EntExaminationDataFactory();
	const defaultEntExaminationCount: number = 10;
	const defaultEntExaminationEntities: EntExaminationModel[] = entExaminationFactory.createAll(defaultEntExaminationCount);

	const emergencyMedicalExaminationRecordFactory: EmergencyMedicalExaminationRecordDataFactory = new EmergencyMedicalExaminationRecordDataFactory();
	const defaultEmergencyMedicalExaminationRecordCount: number = 10;
	const defaultEmergencyMedicalExaminationRecordEntities: EmergencyMedicalExaminationRecordModel[] = emergencyMedicalExaminationRecordFactory.createAll(defaultEmergencyMedicalExaminationRecordCount);

	const formulirKonselingTesHivFactory: FormulirKonselingTesHivDataFactory = new FormulirKonselingTesHivDataFactory();
	const defaultFormulirKonselingTesHivCount: number = 10;
	const defaultFormulirKonselingTesHivEntities: FormulirKonselingTesHivModel[] = formulirKonselingTesHivFactory.createAll(defaultFormulirKonselingTesHivCount);

	const hemodialysisExaminationFactory: HemodialysisExaminationDataFactory = new HemodialysisExaminationDataFactory();
	const defaultHemodialysisExaminationCount: number = 10;
	const defaultHemodialysisExaminationEntities: HemodialysisExaminationModel[] = hemodialysisExaminationFactory.createAll(defaultHemodialysisExaminationCount);

	const inpatientMedicalExaminationRecordFactory: InpatientMedicalExaminationRecordDataFactory = new InpatientMedicalExaminationRecordDataFactory();
	const defaultInpatientMedicalExaminationRecordCount: number = 10;
	const defaultInpatientMedicalExaminationRecordEntities: InpatientMedicalExaminationRecordModel[] = inpatientMedicalExaminationRecordFactory.createAll(defaultInpatientMedicalExaminationRecordCount);

	const medicalExaminationRecordFactory: MedicalExaminationRecordDataFactory = new MedicalExaminationRecordDataFactory();
	const defaultMedicalExaminationRecordCount: number = 10;
	const defaultMedicalExaminationRecordEntities: MedicalExaminationRecordModel[] = medicalExaminationRecordFactory.createAll(defaultMedicalExaminationRecordCount);

	const medicalExaminationRecordDischargeSummaryFactory: MedicalExaminationRecordDischargeSummaryDataFactory = new MedicalExaminationRecordDischargeSummaryDataFactory();
	const defaultMedicalExaminationRecordDischargeSummaryCount: number = 10;
	const defaultMedicalExaminationRecordDischargeSummaryEntities: MedicalExaminationRecordDischargeSummaryModel[] = medicalExaminationRecordDischargeSummaryFactory.createAll(defaultMedicalExaminationRecordDischargeSummaryCount);

	const medicalRecordInitialChecklistFactory: MedicalRecordInitialChecklistDataFactory = new MedicalRecordInitialChecklistDataFactory();
	const defaultMedicalRecordInitialChecklistCount: number = 10;
	const defaultMedicalRecordInitialChecklistEntities: MedicalRecordInitialChecklistModel[] = medicalRecordInitialChecklistFactory.createAll(defaultMedicalRecordInitialChecklistCount);

	const medicalRecordNextVerificationChecklistFactory: MedicalRecordNextVerificationChecklistDataFactory = new MedicalRecordNextVerificationChecklistDataFactory();
	const defaultMedicalRecordNextVerificationChecklistCount: number = 10;
	const defaultMedicalRecordNextVerificationChecklistEntities: MedicalRecordNextVerificationChecklistModel[] = medicalRecordNextVerificationChecklistFactory.createAll(defaultMedicalRecordNextVerificationChecklistCount);

	const nurseVitalSignMeasurementFactory: NurseVitalSignMeasurementDataFactory = new NurseVitalSignMeasurementDataFactory();
	const defaultNurseVitalSignMeasurementCount: number = 10;
	const defaultNurseVitalSignMeasurementEntities: NurseVitalSignMeasurementModel[] = nurseVitalSignMeasurementFactory.createAll(defaultNurseVitalSignMeasurementCount);

	const odontogramExaminationFactory: OdontogramExaminationDataFactory = new OdontogramExaminationDataFactory();
	const defaultOdontogramExaminationCount: number = 10;
	const defaultOdontogramExaminationEntities: OdontogramExaminationModel[] = odontogramExaminationFactory.createAll(defaultOdontogramExaminationCount);

	const operatingTheaterMedicalExaminationRecordFactory: OperatingTheaterMedicalExaminationRecordDataFactory = new OperatingTheaterMedicalExaminationRecordDataFactory();
	const defaultOperatingTheaterMedicalExaminationRecordCount: number = 10;
	const defaultOperatingTheaterMedicalExaminationRecordEntities: OperatingTheaterMedicalExaminationRecordModel[] = operatingTheaterMedicalExaminationRecordFactory.createAll(defaultOperatingTheaterMedicalExaminationRecordCount);

	const ophthalmologyExaminationFactory: OphthalmologyExaminationDataFactory = new OphthalmologyExaminationDataFactory();
	const defaultOphthalmologyExaminationCount: number = 10;
	const defaultOphthalmologyExaminationEntities: OphthalmologyExaminationModel[] = ophthalmologyExaminationFactory.createAll(defaultOphthalmologyExaminationCount);

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);

	const roomTransferFactory: RoomTransferDataFactory = new RoomTransferDataFactory();
	const defaultRoomTransferCount: number = 10;
	const defaultRoomTransferEntities: RoomTransferModel[] = roomTransferFactory.createAll(defaultRoomTransferCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let obstetricAndGynecologyHistoryWithId: ObstetricAndGynecologyHistoryModel = defaultObstetricAndGynecologyHistoryEntities[0];
	let obstetricAndGynecologyHistoryModelWithIdBehaviorSubject: BehaviorSubject<ObstetricAndGynecologyHistoryModel>;

	obstetricAndGynecologyHistoryWithId.medicalExaminationRecord = defaultMedicalExaminationRecordEntities[0];
	obstetricAndGynecologyHistoryWithId.medicalExaminationRecordId = obstetricAndGynecologyHistoryWithId.medicalExaminationRecord.id;
	let medicalExaminationRecordWithIdBehaviorSubject: BehaviorSubject<MedicalExaminationRecordModel>;


	const routerState: RouterState = {
		url: 'obstetric-and-gynecology-history-crud',
		urls: ['obstetric-and-gynecology-history-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: ObstetricAndGynecologyHistoryModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		obstetricAndGynecologyHistoryModelState = initialObstetricAndGynecologyHistoryModelState;
		store.setState({model: obstetricAndGynecologyHistoryModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		obstetricAndGynecologyHistoryCountBehaviorSubject = new BehaviorSubject(defaultObstetricAndGynecologyHistoryCount);

		// selectors for all references
		obstetricAndGynecologyHistoryModelsBehaviorSubject = new BehaviorSubject(defaultObstetricAndGynecologyHistoryEntities);
		amendmentDetailModelsBehaviorSubject = new BehaviorSubject(defaultAmendmentDetailEntities);
		birthHistoryModelsBehaviorSubject = new BehaviorSubject(defaultBirthHistoryEntities);
		bodyChartExaminationModelsBehaviorSubject = new BehaviorSubject(defaultBodyChartExaminationEntities);
		coTreatingDoctorModelsBehaviorSubject = new BehaviorSubject(defaultCoTreatingDoctorEntities);
		dailyCareCPPTModelsBehaviorSubject = new BehaviorSubject(defaultDailyCareCPPTEntities);
		deliveryMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultDeliveryMedicalExaminationRecordEntities);
		diagnosisExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosisExaminationRecordEntities);
		diagnosisNandaModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosisNandaEntities);
		entExaminationModelsBehaviorSubject = new BehaviorSubject(defaultEntExaminationEntities);
		emergencyMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultEmergencyMedicalExaminationRecordEntities);
		formulirKonselingTesHivModelsBehaviorSubject = new BehaviorSubject(defaultFormulirKonselingTesHivEntities);
		hemodialysisExaminationModelsBehaviorSubject = new BehaviorSubject(defaultHemodialysisExaminationEntities);
		inpatientMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultInpatientMedicalExaminationRecordEntities);
		medicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultMedicalExaminationRecordEntities);
		medicalExaminationRecordDischargeSummaryModelsBehaviorSubject = new BehaviorSubject(defaultMedicalExaminationRecordDischargeSummaryEntities);
		medicalRecordInitialChecklistModelsBehaviorSubject = new BehaviorSubject(defaultMedicalRecordInitialChecklistEntities);
		medicalRecordNextVerificationChecklistModelsBehaviorSubject = new BehaviorSubject(defaultMedicalRecordNextVerificationChecklistEntities);
		nurseVitalSignMeasurementModelsBehaviorSubject = new BehaviorSubject(defaultNurseVitalSignMeasurementEntities);
		odontogramExaminationModelsBehaviorSubject = new BehaviorSubject(defaultOdontogramExaminationEntities);
		operatingTheaterMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultOperatingTheaterMedicalExaminationRecordEntities);
		ophthalmologyExaminationModelsBehaviorSubject = new BehaviorSubject(defaultOphthalmologyExaminationEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		roomTransferModelsBehaviorSubject = new BehaviorSubject(defaultRoomTransferEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);

		// selectors for target entity and its related entity
		obstetricAndGynecologyHistoryModelWithIdBehaviorSubject = new BehaviorSubject(obstetricAndGynecologyHistoryWithId);
		medicalExaminationRecordWithIdBehaviorSubject = new BehaviorSubject(obstetricAndGynecologyHistoryWithId.medicalExaminationRecord);

		spyOn(store, 'select')
			.withArgs(getCountObstetricAndGynecologyHistoryModels).and.returnValue(obstetricAndGynecologyHistoryCountBehaviorSubject)
			.withArgs(getObstetricAndGynecologyHistoryModelWithId, obstetricAndGynecologyHistoryWithId.id).and.returnValue(obstetricAndGynecologyHistoryModelWithIdBehaviorSubject)
			.withArgs(getObstetricAndGynecologyHistoryCollectionModels, jasmine.any(String)).and.returnValue(obstetricAndGynecologyHistoryModelsBehaviorSubject)
			.withArgs(getAmendmentDetailCollectionModels, jasmine.any(String)).and.returnValue(amendmentDetailModelsBehaviorSubject)
			.withArgs(getBirthHistoryCollectionModels, jasmine.any(String)).and.returnValue(birthHistoryModelsBehaviorSubject)
			.withArgs(getBodyChartExaminationCollectionModels, jasmine.any(String)).and.returnValue(bodyChartExaminationModelsBehaviorSubject)
			.withArgs(getCoTreatingDoctorCollectionModels, jasmine.any(String)).and.returnValue(coTreatingDoctorModelsBehaviorSubject)
			.withArgs(getDailyCareCPPTCollectionModels, jasmine.any(String)).and.returnValue(dailyCareCPPTModelsBehaviorSubject)
			.withArgs(getDeliveryMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(deliveryMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getDiagnosisExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(diagnosisExaminationRecordModelsBehaviorSubject)
			.withArgs(getDiagnosisNandaCollectionModels, jasmine.any(String)).and.returnValue(diagnosisNandaModelsBehaviorSubject)
			.withArgs(getEntExaminationCollectionModels, jasmine.any(String)).and.returnValue(entExaminationModelsBehaviorSubject)
			.withArgs(getEmergencyMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(emergencyMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getFormulirKonselingTesHivCollectionModels, jasmine.any(String)).and.returnValue(formulirKonselingTesHivModelsBehaviorSubject)
			.withArgs(getHemodialysisExaminationCollectionModels, jasmine.any(String)).and.returnValue(hemodialysisExaminationModelsBehaviorSubject)
			.withArgs(getInpatientMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(inpatientMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(medicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getMedicalExaminationRecordDischargeSummaryCollectionModels, jasmine.any(String)).and.returnValue(medicalExaminationRecordDischargeSummaryModelsBehaviorSubject)
			.withArgs(getMedicalRecordInitialChecklistCollectionModels, jasmine.any(String)).and.returnValue(medicalRecordInitialChecklistModelsBehaviorSubject)
			.withArgs(getMedicalRecordNextVerificationChecklistCollectionModels, jasmine.any(String)).and.returnValue(medicalRecordNextVerificationChecklistModelsBehaviorSubject)
			.withArgs(getNurseVitalSignMeasurementCollectionModels, jasmine.any(String)).and.returnValue(nurseVitalSignMeasurementModelsBehaviorSubject)
			.withArgs(getOdontogramExaminationCollectionModels, jasmine.any(String)).and.returnValue(odontogramExaminationModelsBehaviorSubject)
			.withArgs(getOperatingTheaterMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(operatingTheaterMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getOphthalmologyExaminationCollectionModels, jasmine.any(String)).and.returnValue(ophthalmologyExaminationModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getRoomTransferCollectionModels, jasmine.any(String)).and.returnValue(roomTransferModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getMedicalExaminationRecordModelWithId, obstetricAndGynecologyHistoryWithId.medicalExaminationRecordId).and.returnValue(medicalExaminationRecordWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				ObstetricAndGynecologyHistoryCrudModule,
				CommonComponentModule,
				FormsModule,
				ReactiveFormsModule,
			],
			providers: [
				provideMockStore(),
				{
					provide: ActivatedRoute,
					useValue: activatedRouteStub,
				},
				CookieService,
				ModalDialogService,
				ModalDialogInstanceService,
			]
		}).compileComponents().then(() => {

			spySelectorsInStore();

			fixture = TestBed.createComponent(ObstetricAndGynecologyHistoryCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new ObstetricAndGynecologyHistoryModel();
			component.createReactiveForm();
			fixture.detectChanges();


		});
	}));

	afterEach(() => {
		// Need to do this since for some reason the last component queried from the fixture will be rendered on the
		// browser
		if (fixture.nativeElement instanceof HTMLElement) {
			(fixture.nativeElement as HTMLElement).remove();
		}
		component.ngOnDestroy();
	});

	/**
	 * Checks that the component is created by the test initialisation
	 */
	it ('Renders the Obstetric And Gynecology History CRUD Edit Component', () => {
		expect(component).toBeTruthy();
	});

	/**
	 * Checks that there are no add additional model buttons present in the component when in view mode.
	 *
	 * This test does not require checking whether multi crud is active for a given relation, as the expected outcome
	 * is identical for components with multi entity crud active and for components without it
	 */
	it ('Does not render any add entity buttons when in view mode', fakeAsync(() => {
		component.tileMode = CrudTileMode.View;
		fixture.detectChanges();

		const addEntityButtons: DebugElement[] = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'));

		expect(addEntityButtons.length).toEqual(0);
	}));

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Examination Record relation.
	*
	* The button should only exist if medicalExaminationRecordMultiCrudActive is true
	*/
	it ('Renders Medical Examination Record Add Entity button in create mode', fakeAsync(() => {
		const medicalExaminationRecordButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalExaminationRecordDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalExaminationRecordButton).toEqual(component.medicalExaminationRecordMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Examination Record', fakeAsync(() => {
		const medicalExaminationRecordButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalExaminationRecordDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalExaminationRecordButton).toEqual(component.medicalExaminationRecordMultiCrudActive);

		if (component.medicalExaminationRecordMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalExaminationRecordRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalExaminationRecordDisplayName + ' from Model')).length;

			medicalExaminationRecordButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalExaminationRecordRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalExaminationRecordDisplayName + ' from Model')).length;

			expect(actualMedicalExaminationRecordRemoveButtonCount).toEqual(initialMedicalExaminationRecordRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Examination Record button', () => {
		const medicalExaminationRecordButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalExaminationRecordDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalExaminationRecordButton).toEqual(component.medicalExaminationRecordMultiCrudActive);

		if (component.medicalExaminationRecordMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalExaminationRecordButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalExaminationRecordRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalExaminationRecordDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalExaminationRecordRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalExaminationRecordRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalExaminationRecordDisplayName + ' from Model'));

			expect(actualMedicalExaminationRecordRemoveButtons.length).toEqual(initialMedicalExaminationRecordRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Medical Examination Record button when one has already been added', () => {

		const medicalExaminationRecordButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalExaminationRecordDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalExaminationRecordButton).toEqual(component.medicalExaminationRecordMultiCrudActive);

		if (component.medicalExaminationRecordMultiCrudActive) {
			medicalExaminationRecordButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalExaminationRecordButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalExaminationRecordDisplayName + ' to Model'));

			expect(updatedmedicalExaminationRecordButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Medical Examination Record entities from model when loading in edit mode', () => {
		component.targetModel = obstetricAndGynecologyHistoryWithId;
		component.targetModelId = obstetricAndGynecologyHistoryWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalExaminationRecordMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalExaminationRecordRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalExaminationRecordDisplayName + ' from Model')).length;

			expect(medicalExaminationRecordRemoveButtonCount).toEqual(1);
		}
	});

});
