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

import {HostBinding, Component, OnInit, ViewChild} from '@angular/core';
import {Store} from '@ngrx/store';
import {ToastContainerDirective, ToastrService} from 'ngx-toastr';
import {RouterState} from '../models/model.state';
import {Link, LinkList, NavigationPosition} from '../lib/enums/navigation';
import {AuthenticationService} from '../lib/services/authentication/authentication.service';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Component({
	selector: 'app-frontend',
	templateUrl: './frontend.component.html',
	styleUrls: [
		'./frontend.component.scss',
		// % protected region % [Add any additional SCSS here] off begin
		// % protected region % [Add any additional SCSS here] end
	],
	// % protected region % [Add any additional component options here] off begin
	// % protected region % [Add any additional component options here] end
})
export class FrontendComponent implements OnInit {
	@ViewChild(ToastContainerDirective, { static: true })
	toastContainer: ToastContainerDirective;

	@HostBinding('class')
	className = 'frontend';

	// % protected region % [Customise or remove the default navigation bar variables] off begin
	/**
	 * Contains list of links or link groups to be in the nav bar
	 */
	navBarLinks: LinkList[] = [];

	/**
	 * Choose between a vertical or horizontal navigation bar
	 */
	navPos: NavigationPosition = NavigationPosition.VERTICAL;
	// % protected region % [Customise or remove the default navigation bar variables] end

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		private readonly authenticationService: AuthenticationService,
		private readonly store: Store<{ model: RouterState }>,
		private readonly toastrService: ToastrService,
		// % protected region % [Add any additional constructor parameters] off begin
		// % protected region % [Add any additional constructor parameters] end
	) {
		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	ngOnInit() {
		this.toastrService.overlayContainer = this.toastContainer;

		// % protected region % [Add any initial logic here] off begin
		// % protected region % [Add any initial logic here] end

		// % protected region % [Customise or remove the default navigation bar links for entities] off begin
		const entityLinks = [
				new Link('Accident and Emergency', [], 'icon-book', '/accident-and-emergency'),
				new Link('Account Configuration', [], 'icon-book', '/account-configuration'),
				new Link('Amendment Detail', [], 'icon-book', '/amendment-detail'),
				new Link('Analytics', [], 'icon-book', '/analytics'),
				new Link('Application Logo', [], 'icon-book', '/application-logo'),
				new Link('BPJS  Total Referral SEP', [], 'icon-book', '/bpjs-total-referral-sep'),
				new Link('BPJS Accident Master Data', [], 'icon-book', '/bpjs-accident-master-data'),
				new Link('BPJS Bed Availability', [], 'icon-book', '/bpjs-bed-availability'),
				new Link('BPJS Claim Data', [], 'icon-book', '/bpjs-claim-data'),
				new Link('BPJS Claim Submission', [], 'icon-book', '/bpjs-claim-submission'),
				new Link('BPJS Configuration', [], 'icon-book', '/bpjs-configuration'),
				new Link('BPJS Control Plan', [], 'icon-book', '/bpjs-control-plan'),
				new Link('BPJS Control Plan Wrapper', [], 'icon-book', '/bpjs-control-plan-wrapper'),
				new Link('BPJS Control Specialist', [], 'icon-book', '/bpjs-control-specialist'),
				new Link('BPJS Diagnose', [], 'icon-book', '/bpjs-diagnose'),
				new Link('BPJS Diagnose PRB', [], 'icon-book', '/bpjs-diagnose-prb'),
				new Link('BPJS Dismisal', [], 'icon-book', '/bpjs-dismisal'),
				new Link('BPJS Dismissal Mapping', [], 'icon-book', '/bpjs-dismissal-mapping'),
				new Link('BPJS Doctor Mapping', [], 'icon-book', '/bpjs-doctor-mapping'),
				new Link('BPJS Doctor Schedule', [], 'icon-book', '/bpjs-doctor-schedule'),
				new Link('BPJS Drug Generic PRB', [], 'icon-book', '/bpjs-drug-generic-prb'),
				new Link('BPJS Facility List', [], 'icon-book', '/bpjs-facility-list'),
				new Link('BPJS Finger Print', [], 'icon-book', '/bpjs-finger-print'),
				new Link('BPJS General', [], 'icon-book', '/bpjs-general'),
				new Link('BPJS Get Finger Print', [], 'icon-book', '/bpjs-get-finger-print'),
				new Link('BPJS Health Facility', [], 'icon-book', '/bpjs-health-facility'),
				new Link('BPJS Hospitalization Plan', [], 'icon-book', '/bpjs-hospitalization-plan'),
				new Link('BPJS INACBG', [], 'icon-book', '/bpjs-inacbg'),
				new Link('BPJS INACBG Variables', [], 'icon-book', '/bpjs-inacbg-variables'),
				new Link('BPJS Jasa Raharja', [], 'icon-book', '/bpjs-jasa-raharja'),
				new Link('BPJS Jasa Raharja Claim', [], 'icon-book', '/bpjs-jasa-raharja-claim'),
				new Link('BPJS Jasa Raharja Detail', [], 'icon-book', '/bpjs-jasa-raharja-detail'),
				new Link('BPJS List Finger Print', [], 'icon-book', '/bpjs-list-finger-print'),
				new Link('BPJS Monitoring', [], 'icon-book', '/bpjs-monitoring'),
				new Link('BPJS Outside Facility Referral', [], 'icon-book', '/bpjs-outside-facility-referral'),
				new Link('BPJS Patient Referral', [], 'icon-book', '/bpjs-patient-referral'),
				new Link('BPJS Patient Referral Detail', [], 'icon-book', '/bpjs-patient-referral-detail'),
				new Link('BPJS Procedure', [], 'icon-book', '/bpjs-procedure'),
				new Link('BPJS Referral Specialist', [], 'icon-book', '/bpjs-referral-specialist'),
				new Link('BPJS Referred Back', [], 'icon-book', '/bpjs-referred-back'),
				new Link('BPJS Referred Back Detail', [], 'icon-book', '/bpjs-referred-back-detail'),
				new Link('BPJS Referred Back Wrapper', [], 'icon-book', '/bpjs-referred-back-wrapper'),
				new Link('BPJS SEP', [], 'icon-book', '/bpjs-sep'),
				new Link('BPJS SEP Internal', [], 'icon-book', '/bpjs-sep-internal'),
				new Link('BPJS SEP and INACBG Integration', [], 'icon-book', '/bpjs-sep-and-inacbg-integration'),
				new Link('BPJS Search Control Letter', [], 'icon-book', '/bpjs-search-control-letter'),
				new Link('BPJS Search SEP', [], 'icon-book', '/bpjs-search-sep'),
				new Link('BPJS Sep Submission', [], 'icon-book', '/bpjs-sep-submission'),
				new Link('BPJS Service Mapping', [], 'icon-book', '/bpjs-service-mapping'),
				new Link('BPJS Special Referral', [], 'icon-book', '/bpjs-special-referral'),
				new Link('BPJS Task History', [], 'icon-book', '/bpjs-task-history'),
				new Link('BPJS Treatment Class Mapping', [], 'icon-book', '/bpjs-treatment-class-mapping'),
				new Link('BPJS Treatment History', [], 'icon-book', '/bpjs-treatment-history'),
				new Link('BPJS Treatment Room', [], 'icon-book', '/bpjs-treatment-room'),
				new Link('BPJS Update Dismissal Date', [], 'icon-book', '/bpjs-update-dismissal-date'),
				new Link('BPJS Update Dismissal Date Wrapper', [], 'icon-book', '/bpjs-update-dismissal-date-wrapper'),
				new Link('BPJS Visit Data', [], 'icon-book', '/bpjs-visit-data'),
				new Link('Batch Correction', [], 'icon-book', '/batch-correction'),
				new Link('Bed', [], 'icon-book', '/bed'),
				new Link('Bed Availability', [], 'icon-book', '/bed-availability'),
				new Link('Bed Management', [], 'icon-book', '/bed-management'),
				new Link('Benefit Plan', [], 'icon-book', '/benefit-plan'),
				new Link('Birth History', [], 'icon-book', '/birth-history'),
				new Link('Bpjs', [], 'icon-book', '/bpjs'),
				new Link('Bpjs Health Facility Bed Availability', [], 'icon-book', '/bpjs-health-facility-bed-availability'),
				new Link('Bpjs Sep Claim Wrapper', [], 'icon-book', '/bpjs-sep-claim-wrapper'),
				new Link('Bpjs Sep Submission Wrapper', [], 'icon-book', '/bpjs-sep-submission-wrapper'),
				new Link('Cash Report', [], 'icon-book', '/cash-report'),
				new Link('Catalogue', [], 'icon-book', '/catalogue'),
				new Link('Chart of Account', [], 'icon-book', '/chart-of-account'),
				new Link('Chart of Account Mapping', [], 'icon-book', '/chart-of-account-mapping'),
				new Link('Claim Report', [], 'icon-book', '/claim-report'),
				new Link('Claims', [], 'icon-book', '/claims'),
				new Link('Clinical Exam', [], 'icon-book', '/clinical-exam'),
				new Link('Clinical Exam Amendment History', [], 'icon-book', '/clinical-exam-amendment-history'),
				new Link('Clinical Exam Dashboard', [], 'icon-book', '/clinical-exam-dashboard'),
				new Link('Clinical Exam Diagnostic Staff', [], 'icon-book', '/clinical-exam-diagnostic-staff'),
				new Link('Clinical Exam Doctor', [], 'icon-book', '/clinical-exam-doctor'),
				new Link('Clinical Exam Nurse', [], 'icon-book', '/clinical-exam-nurse'),
				new Link('Clinical Exam Patient Demographic', [], 'icon-book', '/clinical-exam-patient-demographic'),
				new Link('Clinical Exam Patient Medical History', [], 'icon-book', '/clinical-exam-patient-medical-history'),
				new Link('Compound Prescription', [], 'icon-book', '/compound-prescription'),
				new Link('Compound Prescription Detail', [], 'icon-book', '/compound-prescription-detail'),
				new Link('Critical Care', [], 'icon-book', '/critical-care'),
				new Link('Daily Care CPPT', [], 'icon-book', '/daily-care-cppt'),
				new Link('Dashboard', [], 'icon-book', '/dashboard'),
				new Link('Delivery Medical Examination Record', [], 'icon-book', '/delivery-medical-examination-record'),
				new Link('Delivery Room', [], 'icon-book', '/delivery-room'),
				new Link('Dental Oral Service Activity Report', [], 'icon-book', '/dental-oral-service-activity-report'),
				new Link('Diag and Proc', [], 'icon-book', '/diag-and-proc'),
				new Link('Diagnoses and Procedures', [], 'icon-book', '/diagnoses-and-procedures'),
				new Link('Diagnostic Configuration', [], 'icon-book', '/diagnostic-configuration'),
				new Link('Diagnostic Support', [], 'icon-book', '/diagnostic-support'),
				new Link('Diagnostic Support Configuration', [], 'icon-book', '/diagnostic-support-configuration'),
				new Link('Diagnostic Support General Configuration', [], 'icon-book', '/diagnostic-support-general-configuration'),
				new Link('Drug Procurement Service Report', [], 'icon-book', '/drug-procurement-service-report'),
				new Link('Emergency Medical Examination Record', [], 'icon-book', '/emergency-medical-examination-record'),
				new Link('Emergency Service Activity Report', [], 'icon-book', '/emergency-service-activity-report'),
				new Link('Examination Group', [], 'icon-book', '/examination-group'),
				new Link('Examination Item', [], 'icon-book', '/examination-item'),
				new Link('Examination Item Detail', [], 'icon-book', '/examination-item-detail'),
				new Link('Family Planning Service Activity Report', [], 'icon-book', '/family-planning-service-activity-report'),
				new Link('Fluid Balance Detail', [], 'icon-book', '/fluid-balance-detail'),
				new Link('General Config', [], 'icon-book', '/general-config'),
				new Link('General Report', [], 'icon-book', '/general-report'),
				new Link('Goods Receive Note Items Report', [], 'icon-book', '/goods-receive-note-items-report'),
				new Link('Goods Received Note', [], 'icon-book', '/goods-received-note'),
				new Link('Goods Received Note Detail', [], 'icon-book', '/goods-received-note-detail'),
				new Link('Goods Received Note Item', [], 'icon-book', '/goods-received-note-item'),
				new Link('Health Fac', [], 'icon-book', '/health-fac'),
				new Link('Health Insurance', [], 'icon-book', '/health-insurance'),
				new Link('Hospital Bed Information Report', [], 'icon-book', '/hospital-bed-information-report'),
				new Link('Hospital Branch Information Config', [], 'icon-book', '/hospital-branch-information-config'),
				new Link('Hospital Group Information Config', [], 'icon-book', '/hospital-group-information-config'),
				new Link('Hospital Information Report', [], 'icon-book', '/hospital-information-report'),
				new Link('Hospital Performance Indicators Report', [], 'icon-book', '/hospital-performance-indicators-report'),
				new Link('Hospital Staff Information Report', [], 'icon-book', '/hospital-staff-information-report'),
				new Link('Hospital Visitor Report', [], 'icon-book', '/hospital-visitor-report'),
				new Link('ICD10', [], 'icon-book', '/icd10'),
				new Link('ICD9', [], 'icon-book', '/icd9'),
				new Link('Income Report', [], 'icon-book', '/income-report'),
				new Link('Inpatient', [], 'icon-book', '/inpatient'),
				new Link('Inpatient Admission', [], 'icon-book', '/inpatient-admission'),
				new Link('Inpatient Disease Report', [], 'icon-book', '/inpatient-disease-report'),
				new Link('Inpatient Examination', [], 'icon-book', '/inpatient-examination'),
				new Link('Inpatient Examination Detail', [], 'icon-book', '/inpatient-examination-detail'),
				new Link('Inpatient Morbidity Data 4A2 Report', [], 'icon-book', '/inpatient-morbidity-data-4a2-report'),
				new Link('Inpatient Morbidity Data Report', [], 'icon-book', '/inpatient-morbidity-data-report'),
				new Link('Inpatient Order', [], 'icon-book', '/inpatient-order'),
				new Link('Inpatient Service Activity Report', [], 'icon-book', '/inpatient-service-activity-report'),
				new Link('Internal Order', [], 'icon-book', '/internal-order'),
				new Link('Internal Order Stock Detail', [], 'icon-book', '/internal-order-stock-detail'),
				new Link('Intraoperative Records', [], 'icon-book', '/intraoperative-records'),
				new Link('Inventory', [], 'icon-book', '/inventory'),
				new Link('Inventory Adjusment Wrapper', [], 'icon-book', '/inventory-adjusment-wrapper'),
				new Link('Inventory Adjustment', [], 'icon-book', '/inventory-adjustment'),
				new Link('Inventory Enquiry', [], 'icon-book', '/inventory-enquiry'),
				new Link('Inventory Enquiry Inventory Transaction', [], 'icon-book', '/inventory-enquiry-inventory-transaction'),
				new Link('Inventory Enquiry Stock Expiration Balance', [], 'icon-book', '/inventory-enquiry-stock-expiration-balance'),
				new Link('Inventory Enquiry Stock Expiration Detail', [], 'icon-book', '/inventory-enquiry-stock-expiration-detail'),
				new Link('Inventory Enquiry Stock Expiration History', [], 'icon-book', '/inventory-enquiry-stock-expiration-history'),
				new Link('Inventory Enquiry Stock Mutation', [], 'icon-book', '/inventory-enquiry-stock-mutation'),
				new Link('Inventory Enquiry Stock Summary', [], 'icon-book', '/inventory-enquiry-stock-summary'),
				new Link('Inventory Enquiry Stock Transaction Detail', [], 'icon-book', '/inventory-enquiry-stock-transaction-detail'),
				new Link('Invoice Component Report', [], 'icon-book', '/invoice-component-report'),
				new Link('Invoice Item Report', [], 'icon-book', '/invoice-item-report'),
				new Link('Invoice Report', [], 'icon-book', '/invoice-report'),
				new Link('Journal', [], 'icon-book', '/journal'),
				new Link('Laboratory Service Activity Report', [], 'icon-book', '/laboratory-service-activity-report'),
				new Link('MCU Package', [], 'icon-book', '/mcu-package'),
				new Link('MCU Package Detail', [], 'icon-book', '/mcu-package-detail'),
				new Link('MCU Package Item', [], 'icon-book', '/mcu-package-item'),
				new Link('Master Catalogue Report', [], 'icon-book', '/master-catalogue-report'),
				new Link('Master Patient Report', [], 'icon-book', '/master-patient-report'),
				new Link('Medical Examination Record', [], 'icon-book', '/medical-examination-record'),
				new Link('Medical Fee', [], 'icon-book', '/medical-fee'),
				new Link('Medical Record Checklist', [], 'icon-book', '/medical-record-checklist'),
				new Link('Medical Record Report', [], 'icon-book', '/medical-record-report'),
				new Link('Medical Rehabilitation Service Activity Report', [], 'icon-book', '/medical-rehabilitation-service-activity-report'),
				new Link('Medication Administered History', [], 'icon-book', '/medication-administered-history'),
				new Link('Medication Compound', [], 'icon-book', '/medication-compound'),
				new Link('Medication Detail', [], 'icon-book', '/medication-detail'),
				new Link('Medication Dispensing', [], 'icon-book', '/medication-dispensing'),
				new Link('Medication Item', [], 'icon-book', '/medication-item'),
				new Link('Merchant Bank', [], 'icon-book', '/merchant-bank'),
				new Link('Merchant Surcharge Fee', [], 'icon-book', '/merchant-surcharge-fee'),
				new Link('Newborn Detail', [], 'icon-book', '/newborn-detail'),
				new Link('Non Compound Drug', [], 'icon-book', '/non-compound-drug'),
				new Link('Numbering Setup', [], 'icon-book', '/numbering-setup'),
				new Link('Nurse Vital Sign Measurement', [], 'icon-book', '/nurse-vital-sign-measurement'),
				new Link('Obstetric And Gynecology History', [], 'icon-book', '/obstetric-and-gynecology-history'),
				new Link('Obstetric Service Activity Report', [], 'icon-book', '/obstetric-service-activity-report'),
				new Link('Operating Theater Medical Examination Record', [], 'icon-book', '/operating-theater-medical-examination-record'),
				new Link('Operating Theater Service Activity Report', [], 'icon-book', '/operating-theater-service-activity-report'),
				new Link('Operating Theatre', [], 'icon-book', '/operating-theatre'),
				new Link('Operational Dashboard', [], 'icon-book', '/operational-dashboard'),
				new Link('Outpatient', [], 'icon-book', '/outpatient'),
				new Link('Outpatient Disease Report', [], 'icon-book', '/outpatient-disease-report'),
				new Link('Outpatient Examination', [], 'icon-book', '/outpatient-examination'),
				new Link('Outpatient Examination Detail', [], 'icon-book', '/outpatient-examination-detail'),
				new Link('Outpatient Morbidity Data 4B Report', [], 'icon-book', '/outpatient-morbidity-data-4b-report'),
				new Link('Outpatient Morbidity Data 4B2 Report', [], 'icon-book', '/outpatient-morbidity-data-4b2-report'),
				new Link('Outpatient Visit Report', [], 'icon-book', '/outpatient-visit-report'),
				new Link('Outpatient Visitor Information Report', [], 'icon-book', '/outpatient-visitor-information-report'),
				new Link('PCare', [], 'icon-book', '/pcare'),
				new Link('PCare Club Prolanis', [], 'icon-book', '/pcare-club-prolanis'),
				new Link('PCare Configuration', [], 'icon-book', '/pcare-configuration'),
				new Link('PCare Daftar Pendaftaran', [], 'icon-book', '/pcare-daftar-pendaftaran'),
				new Link('PCare Daftar Riwayat Kunjungan', [], 'icon-book', '/pcare-daftar-riwayat-kunjungan'),
				new Link('PCare Daftar Rujukan', [], 'icon-book', '/pcare-daftar-rujukan'),
				new Link('PCare Data Kegiatan', [], 'icon-book', '/pcare-data-kegiatan'),
				new Link('PCare Diagnosa', [], 'icon-book', '/pcare-diagnosa'),
				new Link('PCare Dokter', [], 'icon-book', '/pcare-dokter'),
				new Link('PCare Kegiatan Kelompok', [], 'icon-book', '/pcare-kegiatan-kelompok'),
				new Link('PCare Kegiatan Kelompok Wrapper', [], 'icon-book', '/pcare-kegiatan-kelompok-wrapper'),
				new Link('PCare Kesadaran', [], 'icon-book', '/pcare-kesadaran'),
				new Link('PCare Kunjungan Wrapper', [], 'icon-book', '/pcare-kunjungan-wrapper'),
				new Link('PCare MCU', [], 'icon-book', '/pcare-mcu'),
				new Link('PCare MCU Wrapper', [], 'icon-book', '/pcare-mcu-wrapper'),
				new Link('PCare Peserta Kegiatan Kelompok', [], 'icon-book', '/pcare-peserta-kegiatan-kelompok'),
				new Link('PCare Provider Rayonisasi', [], 'icon-book', '/pcare-provider-rayonisasi'),
				new Link('PCare Status Pulang', [], 'icon-book', '/pcare-status-pulang'),
				new Link('PCare Tindakan', [], 'icon-book', '/pcare-tindakan'),
				new Link('PCare Tindakan Kunjungan', [], 'icon-book', '/pcare-tindakan-kunjungan'),
				new Link('PCare Umum', [], 'icon-book', '/pcare-umum'),
				new Link('Patient Billing', [], 'icon-book', '/patient-billing'),
				new Link('Patient Configuration', [], 'icon-book', '/patient-configuration'),
				new Link('Patient Detail', [], 'icon-book', '/patient-detail'),
				new Link('Patient Invoice', [], 'icon-book', '/patient-invoice'),
				new Link('Patient Invoice Detail', [], 'icon-book', '/patient-invoice-detail'),
				new Link('Patient Invoice Item Detail', [], 'icon-book', '/patient-invoice-item-detail'),
				new Link('Patient Profile', [], 'icon-book', '/patient-profile'),
				new Link('Patient Receipt', [], 'icon-book', '/patient-receipt'),
				new Link('Patient Receipt Detail', [], 'icon-book', '/patient-receipt-detail'),
				new Link('Patient Receipt Setup', [], 'icon-book', '/patient-receipt-setup'),
				new Link('Patient Refund', [], 'icon-book', '/patient-refund'),
				new Link('Patient Refund Setup', [], 'icon-book', '/patient-refund-setup'),
				new Link('Patient Vital Information', [], 'icon-book', '/patient-vital-information'),
				new Link('Payment Method Report', [], 'icon-book', '/payment-method-report'),
				new Link('Pcare Obat', [], 'icon-book', '/pcare-obat'),
				new Link('Pcare Poli', [], 'icon-book', '/pcare-poli'),
				new Link('Pcare Referensi Sarana', [], 'icon-book', '/pcare-referensi-sarana'),
				new Link('Perinatology Service Activity Report', [], 'icon-book', '/perinatology-service-activity-report'),
				new Link('Personalization', [], 'icon-book', '/personalization'),
				new Link('Pharmacy', [], 'icon-book', '/pharmacy'),
				new Link('Pharmacy Configuration', [], 'icon-book', '/pharmacy-configuration'),
				new Link('Pharmacy Item Detail Report', [], 'icon-book', '/pharmacy-item-detail-report'),
				new Link('Pharmacy Report', [], 'icon-book', '/pharmacy-report'),
				new Link('Postoperative Details', [], 'icon-book', '/postoperative-details'),
				new Link('Preoperative Records', [], 'icon-book', '/preoperative-records'),
				new Link('Prescription Detail', [], 'icon-book', '/prescription-detail'),
				new Link('Prescription Dispensing', [], 'icon-book', '/prescription-dispensing'),
				new Link('Price Component', [], 'icon-book', '/price-component'),
				new Link('Process Workflow', [], 'icon-book', '/process-workflow'),
				new Link('Psychiatry Service Activity Report', [], 'icon-book', '/psychiatry-service-activity-report'),
				new Link('Purchase Order', [], 'icon-book', '/purchase-order'),
				new Link('Purchase Order Stock Detail', [], 'icon-book', '/purchase-order-stock-detail'),
				new Link('Purchase Requisition', [], 'icon-book', '/purchase-requisition'),
				new Link('Purchase Requisition Stock Detail', [], 'icon-book', '/purchase-requisition-stock-detail'),
				new Link('Purchasing', [], 'icon-book', '/purchasing'),
				new Link('Radiology Service Activity Report', [], 'icon-book', '/radiology-service-activity-report'),
				new Link('Reference', [], 'icon-book', '/reference'),
				new Link('Reference Data', [], 'icon-book', '/reference-data'),
				new Link('Reference Data Detail', [], 'icon-book', '/reference-data-detail'),
				new Link('Reference Header', [], 'icon-book', '/reference-header'),
				new Link('Reference Header Detail', [], 'icon-book', '/reference-header-detail'),
				new Link('Referral Activity Report', [], 'icon-book', '/referral-activity-report'),
				new Link('Refund Detail Report', [], 'icon-book', '/refund-detail-report'),
				new Link('Registration', [], 'icon-book', '/registration'),
				new Link('Registration Configuration', [], 'icon-book', '/registration-configuration'),
				new Link('Registration Report', [], 'icon-book', '/registration-report'),
				new Link('Report Logo', [], 'icon-book', '/report-logo'),
				new Link('Request Order', [], 'icon-book', '/request-order'),
				new Link('Retail Pharmacy', [], 'icon-book', '/retail-pharmacy'),
				new Link('Retail Pharmacy Invoice', [], 'icon-book', '/retail-pharmacy-invoice'),
				new Link('Retail Pharmacy Stock Detail', [], 'icon-book', '/retail-pharmacy-stock-detail'),
				new Link('Return Supplier', [], 'icon-book', '/return-supplier'),
				new Link('Return Supplier Stock Detail', [], 'icon-book', '/return-supplier-stock-detail'),
				new Link('Room', [], 'icon-book', '/room'),
				new Link('Sample Collection Information', [], 'icon-book', '/sample-collection-information'),
				new Link('Sample Collection Items', [], 'icon-book', '/sample-collection-items'),
				new Link('Satu Sehat', [], 'icon-book', '/satu-sehat'),
				new Link('Satu Sehat Configuration', [], 'icon-book', '/satu-sehat-configuration'),
				new Link('Satu Sehat General', [], 'icon-book', '/satu-sehat-general'),
				new Link('Service', [], 'icon-book', '/service'),
				new Link('Service Detail', [], 'icon-book', '/service-detail'),
				new Link('Service Facility Category', [], 'icon-book', '/service-facility-category'),
				new Link('Service Item', [], 'icon-book', '/service-item'),
				new Link('Service Item Assignment', [], 'icon-book', '/service-item-assignment'),
				new Link('Service Item Wrapper', [], 'icon-book', '/service-item-wrapper'),
				new Link('Settlement Report', [], 'icon-book', '/settlement-report'),
				new Link('Special Service Activity Report', [], 'icon-book', '/special-service-activity-report'),
				new Link('Staff Schedule', [], 'icon-book', '/staff-schedule'),
				new Link('Staff and User', [], 'icon-book', '/staff-and-user'),
				new Link('Stock Expiration Balance Report', [], 'icon-book', '/stock-expiration-balance-report'),
				new Link('Stock Expiration Transaction Detail Report', [], 'icon-book', '/stock-expiration-transaction-detail-report'),
				new Link('Stock Mutation Report', [], 'icon-book', '/stock-mutation-report'),
				new Link('Stock Summary Report', [], 'icon-book', '/stock-summary-report'),
				new Link('Stock Transaction Detail Report', [], 'icon-book', '/stock-transaction-detail-report'),
				new Link('Supplier', [], 'icon-book', '/supplier'),
				new Link('Supplier Product Detail', [], 'icon-book', '/supplier-product-detail'),
				new Link('Supplier Wrapper', [], 'icon-book', '/supplier-wrapper'),
				new Link('System Configuration', [], 'icon-book', '/system-configuration'),
				new Link('Tariff Billing Configuration', [], 'icon-book', '/tariff-billing-configuration'),
				new Link('Tariff Definition', [], 'icon-book', '/tariff-definition'),
				new Link('Tariff Formula', [], 'icon-book', '/tariff-formula'),
				new Link('Tariff Management', [], 'icon-book', '/tariff-management'),
				new Link('Tariff Scheme', [], 'icon-book', '/tariff-scheme'),
				new Link('Task Dashboard', [], 'icon-book', '/task-dashboard'),
				new Link('Top Disease Report', [], 'icon-book', '/top-disease-report'),
				new Link('Transaction Detail Type', [], 'icon-book', '/transaction-detail-type'),
				new Link('Transfer Order', [], 'icon-book', '/transfer-order'),
				new Link('Transfer Order Stock Detail', [], 'icon-book', '/transfer-order-stock-detail'),
				new Link('Vaccination Order', [], 'icon-book', '/vaccination-order'),
				new Link('Vaccination Order Detail', [], 'icon-book', '/vaccination-order-detail'),
				new Link('Vital Signs', [], 'icon-book', '/vital-signs'),
				new Link('Warehouse', [], 'icon-book', '/warehouse'),
				new Link('Warehouse Inventory', [], 'icon-book', '/warehouse-inventory'),
		];
		// % protected region % [Customise or remove the default navigation bar links for entities] end
		// % protected region % [Customise or remove the default navigation bar links] off begin
		this.navBarLinks.push(
			new LinkList([
				new Link('KMS Home', [], 'icon-home', ''),
			]),
			new LinkList(entityLinks),
			new LinkList([
				new Link('Logout', [], 'icon-room', '/logout')
			])
		);
		// % protected region % [Customise or remove the default navigation bar links] end

		// % protected region % [Add any additional initialize logic here] off begin
		// % protected region % [Add any additional initialize logic here] end
	}

	isLoggedIn(): boolean {
		return this.authenticationService.isLoggedIn;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end

}
