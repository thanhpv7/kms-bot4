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

import {Component, HostBinding, OnInit, ViewChild} from '@angular/core';
import {Store} from '@ngrx/store';
import {ToastContainerDirective, ToastrService} from 'ngx-toastr';
import {Link, LinkList, NavigationPosition} from '../lib/enums/navigation';
import {AuthenticationService} from '../lib/services/authentication/authentication.service';
import {RouterState} from '../models/model.state';
import {environment} from '../../environments/environment';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end
@Component({
	selector: 'app-admin',
	templateUrl: './admin.component.html',
	styleUrls: [
		'./admin.component.scss',
		// % protected region % [Add any additional component classes here] off begin
		// % protected region % [Add any additional component classes here] end
	],
	// % protected region % [Add any additional component options here] off begin
	// % protected region % [Add any additional component options here] end
})
export class AdminComponent
		// % protected region % [Add any additional interfaces to implement here] off begin
		implements OnInit
		// % protected region % [Add any additional interfaces to implement here] end
{

	@ViewChild(ToastContainerDirective, { static: true })
	toastContainer: ToastContainerDirective;

	@HostBinding('class')
	className = 'admin';

	// % protected region % [Customise or remove the default navigation bar variables] off begin
	navBarLinks: LinkList[] = [];

	navPos: NavigationPosition = NavigationPosition.VERTICAL;
	// % protected region % [Customise or remove the default navigation bar variables] end

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		private readonly authenticationService: AuthenticationService,
		private readonly store: Store<{ model: RouterState }>,
		private readonly toastrService: ToastrService,
		// % protected region % [Add any additional params here] off begin
		// % protected region % [Add any additional params here] end
	) {
		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	ngOnInit() {
		this.toastrService.overlayContainer = this.toastContainer;

		// % protected region % [Add any initial logic here] off begin
		// % protected region % [Add any initial logic here] end
		// % protected region % [Customise or remove the default navigation bar links for entities] off begin
		let entitySubLinks = [
				new Link('Amendment Detail', [], 'icon-book', '/admin/entities/amendment-detail'),
				new Link('BPJS Accident Master', [], 'icon-book', '/admin/entities/bpjs-accident-master'),
				new Link('BPJS Bed Availability', [], 'icon-book', '/admin/entities/bpjs-bed-availability'),
				new Link('BPJS Claim Data', [], 'icon-book', '/admin/entities/bpjs-claim-data'),
				new Link('BPJS Claim Submission', [], 'icon-book', '/admin/entities/bpjs-claim-submission'),
				new Link('BPJS Control Plan', [], 'icon-book', '/admin/entities/bpjs-control-plan'),
				new Link('BPJS Control Specialist', [], 'icon-book', '/admin/entities/bpjs-control-specialist'),
				new Link('BPJS Diagnose', [], 'icon-book', '/admin/entities/bpjs-diagnose'),
				new Link('BPJS Diagnose PRB', [], 'icon-book', '/admin/entities/bpjs-diagnose-prb'),
				new Link('BPJS Dismissal Condition', [], 'icon-book', '/admin/entities/bpjs-dismissal-condition'),
				new Link('BPJS Dismissal Mapping', [], 'icon-book', '/admin/entities/bpjs-dismissal-mapping'),
				new Link('BPJS Doctor Mapping', [], 'icon-book', '/admin/entities/bpjs-doctor-mapping'),
				new Link('BPJS Doctor Schedule', [], 'icon-book', '/admin/entities/bpjs-doctor-schedule'),
				new Link('BPJS Drug Generic PRB', [], 'icon-book', '/admin/entities/bpjs-drug-generic-prb'),
				new Link('BPJS Facility List', [], 'icon-book', '/admin/entities/bpjs-facility-list'),
				new Link('BPJS Finger Print', [], 'icon-book', '/admin/entities/bpjs-finger-print'),
				new Link('BPJS General', [], 'icon-book', '/admin/entities/bpjs-general'),
				new Link('BPJS Health Facility', [], 'icon-book', '/admin/entities/bpjs-health-facility'),
				new Link('BPJS Hospitalization Plan', [], 'icon-book', '/admin/entities/bpjs-hospitalization-plan'),
				new Link('BPJS INACBG', [], 'icon-book', '/admin/entities/bpjs-inacbg'),
				new Link('BPJS INACBG Claim', [], 'icon-book', '/admin/entities/bpjs-inacbg-claim'),
				new Link('BPJS INACBG Variable', [], 'icon-book', '/admin/entities/bpjs-inacbg-variable'),
				new Link('BPJS Jasa Raharja', [], 'icon-book', '/admin/entities/bpjs-jasa-raharja'),
				new Link('BPJS Jasa Raharja Claim', [], 'icon-book', '/admin/entities/bpjs-jasa-raharja-claim'),
				new Link('BPJS List Finger Print', [], 'icon-book', '/admin/entities/bpjs-list-finger-print'),
				new Link('BPJS List Task', [], 'icon-book', '/admin/entities/bpjs-list-task'),
				new Link('BPJS Outside Facility Referral', [], 'icon-book', '/admin/entities/bpjs-outside-facility-referral'),
				new Link('BPJS PRB', [], 'icon-book', '/admin/entities/bpjs-prb'),
				new Link('BPJS PRB Detail', [], 'icon-book', '/admin/entities/bpjs-prb-detail'),
				new Link('BPJS Patient Referral', [], 'icon-book', '/admin/entities/bpjs-patient-referral'),
				new Link('BPJS Pcare DPHO', [], 'icon-book', '/admin/entities/bpjs-pcare-dpho'),
				new Link('BPJS Pcare Kegiatan Kelompok', [], 'icon-book', '/admin/entities/bpjs-pcare-kegiatan-kelompok'),
				new Link('BPJS Pcare Kesadaran', [], 'icon-book', '/admin/entities/bpjs-pcare-kesadaran'),
				new Link('BPJS Pcare Peserta Kegiatan Kelompok', [], 'icon-book', '/admin/entities/bpjs-pcare-peserta-kegiatan-kelompok'),
				new Link('BPJS Pcare Poli', [], 'icon-book', '/admin/entities/bpjs-pcare-poli'),
				new Link('BPJS Pcare Provider Rayonisasi', [], 'icon-book', '/admin/entities/bpjs-pcare-provider-rayonisasi'),
				new Link('BPJS Pcare Registrations', [], 'icon-book', '/admin/entities/bpjs-pcare-registrations'),
				new Link('BPJS Procedure', [], 'icon-book', '/admin/entities/bpjs-procedure'),
				new Link('BPJS Referral Specialist', [], 'icon-book', '/admin/entities/bpjs-referral-specialist'),
				new Link('BPJS SEP', [], 'icon-book', '/admin/entities/bpjs-sep'),
				new Link('BPJS SEP INACBG Integration', [], 'icon-book', '/admin/entities/bpjs-sep-inacbg-integration'),
				new Link('BPJS SEP Internal Data', [], 'icon-book', '/admin/entities/bpjs-sep-internal-data'),
				new Link('BPJS SEP Submission', [], 'icon-book', '/admin/entities/bpjs-sep-submission'),
				new Link('BPJS Search Control Letter', [], 'icon-book', '/admin/entities/bpjs-search-control-letter'),
				new Link('BPJS Search SEP', [], 'icon-book', '/admin/entities/bpjs-search-sep'),
				new Link('BPJS Service Mapping', [], 'icon-book', '/admin/entities/bpjs-service-mapping'),
				new Link('BPJS Special Referral', [], 'icon-book', '/admin/entities/bpjs-special-referral'),
				new Link('BPJS Total Referral SEP', [], 'icon-book', '/admin/entities/bpjs-total-referral-sep'),
				new Link('BPJS Treatment Class Mapping', [], 'icon-book', '/admin/entities/bpjs-treatment-class-mapping'),
				new Link('BPJS Treatment History', [], 'icon-book', '/admin/entities/bpjs-treatment-history'),
				new Link('BPJS Treatment Room', [], 'icon-book', '/admin/entities/bpjs-treatment-room'),
				new Link('BPJS Update Dismissal Date', [], 'icon-book', '/admin/entities/bpjs-update-dismissal-date'),
				new Link('BPJS Visit Data', [], 'icon-book', '/admin/entities/bpjs-visit-data'),
				new Link('Batch Stock Balance', [], 'icon-book', '/admin/entities/batch-stock-balance'),
				new Link('Batch Stock Balance Per Date', [], 'icon-book', '/admin/entities/batch-stock-balance-per-date'),
				new Link('Batch Stock Transaction Detail', [], 'icon-book', '/admin/entities/batch-stock-transaction-detail'),
				new Link('Bed Facility', [], 'icon-book', '/admin/entities/bed-facility'),
				new Link('Bed Reserve', [], 'icon-book', '/admin/entities/bed-reserve'),
				new Link('Birth History', [], 'icon-book', '/admin/entities/birth-history'),
				new Link('Body Chart Examination', [], 'icon-book', '/admin/entities/body-chart-examination'),
				new Link('Bpjs Pcare Kunjungan Rujukan', [], 'icon-book', '/admin/entities/bpjs-pcare-kunjungan-rujukan'),
				new Link('Bpjs Pcare Pendaftaran', [], 'icon-book', '/admin/entities/bpjs-pcare-pendaftaran'),
				new Link('Bpjs Pcare Riwayat Kunjungan', [], 'icon-book', '/admin/entities/bpjs-pcare-riwayat-kunjungan'),
				new Link('Cash Allocation', [], 'icon-book', '/admin/entities/cash-allocation'),
				new Link('Cash Receipt', [], 'icon-book', '/admin/entities/cash-receipt'),
				new Link('Cash Refund', [], 'icon-book', '/admin/entities/cash-refund'),
				new Link('Catalogue Medical ', [], 'icon-book', '/admin/entities/catalogue-medical'),
				new Link('Catalogue Non Medical', [], 'icon-book', '/admin/entities/catalogue-non-medical'),
				new Link('Catalogue UOM', [], 'icon-book', '/admin/entities/catalogue-uom'),
				new Link('Chart of Account', [], 'icon-book', '/admin/entities/chart-of-account'),
				new Link('Chart of Account Mapping', [], 'icon-book', '/admin/entities/chart-of-account-mapping'),
				new Link('Co Treating Doctor', [], 'icon-book', '/admin/entities/co-treating-doctor'),
				new Link('Compound Prescription Detail', [], 'icon-book', '/admin/entities/compound-prescription-detail'),
				new Link('Compound Prescription Item', [], 'icon-book', '/admin/entities/compound-prescription-item'),
				new Link('Daily Care CPPT', [], 'icon-book', '/admin/entities/daily-care-cppt'),
				new Link('Delivery Medical Examination Record', [], 'icon-book', '/admin/entities/delivery-medical-examination-record'),
				new Link('Delivery Progress', [], 'icon-book', '/admin/entities/delivery-progress'),
				new Link('Diagnoses and Procedures', [], 'icon-book', '/admin/entities/diagnoses-and-procedures'),
				new Link('Diagnosis Examination Record', [], 'icon-book', '/admin/entities/diagnosis-examination-record'),
				new Link('Diagnosis Nanda', [], 'icon-book', '/admin/entities/diagnosis-nanda'),
				new Link('Diagnostic Examination Results', [], 'icon-book', '/admin/entities/diagnostic-examination-results'),
				new Link('Diagnostic Staff Examination Summary', [], 'icon-book', '/admin/entities/diagnostic-staff-examination-summary'),
				new Link('Diagnostic Support General Configuration', [], 'icon-book', '/admin/entities/diagnostic-support-general-configuration'),
				new Link('Doctor Schedule', [], 'icon-book', '/admin/entities/doctor-schedule'),
				new Link('ENT Examination', [], 'icon-book', '/admin/entities/ent-examination'),
				new Link('Emergency Medical Examination Record', [], 'icon-book', '/admin/entities/emergency-medical-examination-record'),
				new Link('Examination Group', [], 'icon-book', '/admin/entities/examination-group'),
				new Link('Examination Item', [], 'icon-book', '/admin/entities/examination-item'),
				new Link('Examination Item Detail', [], 'icon-book', '/admin/entities/examination-item-detail'),
				new Link('Facility History', [], 'icon-book', '/admin/entities/facility-history'),
				new Link('Fluid Balance Detail', [], 'icon-book', '/admin/entities/fluid-balance-detail'),
				new Link('Formulir Konseling Tes Hiv', [], 'icon-book', '/admin/entities/formulir-konseling-tes-hiv'),
				new Link('Goods Receive Note', [], 'icon-book', '/admin/entities/goods-receive-note'),
				new Link('Goods Receive Note Batch', [], 'icon-book', '/admin/entities/goods-receive-note-batch'),
				new Link('Goods Receive Note Item', [], 'icon-book', '/admin/entities/goods-receive-note-item'),
				new Link('Health Facility', [], 'icon-book', '/admin/entities/health-facility'),
				new Link('Hemodialysis Examination', [], 'icon-book', '/admin/entities/hemodialysis-examination'),
				new Link('Hemodialysis Monitoring', [], 'icon-book', '/admin/entities/hemodialysis-monitoring'),
				new Link('Hospital Branch Information', [], 'icon-book', '/admin/entities/hospital-branch-information'),
				new Link('Hospital Group Information', [], 'icon-book', '/admin/entities/hospital-group-information'),
				new Link('ICD 10', [], 'icon-book', '/admin/entities/icd-10'),
				new Link('ICD 9 CM', [], 'icon-book', '/admin/entities/icd-9-cm'),
				new Link('Informed Consent', [], 'icon-book', '/admin/entities/informed-consent'),
				new Link('Inpatient Medical Examination Record', [], 'icon-book', '/admin/entities/inpatient-medical-examination-record'),
				new Link('Insurance Benefit Plan', [], 'icon-book', '/admin/entities/insurance-benefit-plan'),
				new Link('Insurance Provider', [], 'icon-book', '/admin/entities/insurance-provider'),
				new Link('Internal Order', [], 'icon-book', '/admin/entities/internal-order'),
				new Link('Internal Order Stock Detail', [], 'icon-book', '/admin/entities/internal-order-stock-detail'),
				new Link('Intraoperative Records', [], 'icon-book', '/admin/entities/intraoperative-records'),
				new Link('Inventory Adjusment Batch', [], 'icon-book', '/admin/entities/inventory-adjusment-batch'),
				new Link('Inventory Adjustment', [], 'icon-book', '/admin/entities/inventory-adjustment'),
				new Link('Inventory Adjustment Item', [], 'icon-book', '/admin/entities/inventory-adjustment-item'),
				new Link('Inventory Batch Correction', [], 'icon-book', '/admin/entities/inventory-batch-correction'),
				new Link('Inventory Batch Correction Item', [], 'icon-book', '/admin/entities/inventory-batch-correction-item'),
				new Link('Invoice', [], 'icon-book', '/admin/entities/invoice'),
				new Link('Invoice Item', [], 'icon-book', '/admin/entities/invoice-item'),
				new Link('Invoice Item Component', [], 'icon-book', '/admin/entities/invoice-item-component'),
				new Link('Invoice Payment Insurance', [], 'icon-book', '/admin/entities/invoice-payment-insurance'),
				new Link('Invoice Payment Other', [], 'icon-book', '/admin/entities/invoice-payment-other'),
				new Link('Invoice Payment Self Paying', [], 'icon-book', '/admin/entities/invoice-payment-self-paying'),
				new Link('Invoice Summary', [], 'icon-book', '/admin/entities/invoice-summary'),
				new Link('Journal', [], 'icon-book', '/admin/entities/journal'),
				new Link('Library', [], 'icon-book', '/admin/entities/library'),
				new Link('Location', [], 'icon-book', '/admin/entities/location'),
				new Link('MCU Package', [], 'icon-book', '/admin/entities/mcu-package'),
				new Link('MCU Package Item', [], 'icon-book', '/admin/entities/mcu-package-item'),
				new Link('Medical Certificate  Discharge Resume', [], 'icon-book', '/admin/entities/medical-certificate-discharge-resume'),
				new Link('Medical Certificate Birth', [], 'icon-book', '/admin/entities/medical-certificate-birth'),
				new Link('Medical Certificate Hospitalization', [], 'icon-book', '/admin/entities/medical-certificate-hospitalization'),
				new Link('Medical Certificate Medical Attendance', [], 'icon-book', '/admin/entities/medical-certificate-medical-attendance'),
				new Link('Medical Certificate Mental Health', [], 'icon-book', '/admin/entities/medical-certificate-mental-health'),
				new Link('Medical Certificate Physical Health', [], 'icon-book', '/admin/entities/medical-certificate-physical-health'),
				new Link('Medical Certificate Restricted Work', [], 'icon-book', '/admin/entities/medical-certificate-restricted-work'),
				new Link('Medical Certificate Sick Leave', [], 'icon-book', '/admin/entities/medical-certificate-sick-leave'),
				new Link('Medical Examination Record', [], 'icon-book', '/admin/entities/medical-examination-record'),
				new Link('Medical Examination Record Discharge Summary', [], 'icon-book', '/admin/entities/medical-examination-record-discharge-summary'),
				new Link('Medical Fee', [], 'icon-book', '/admin/entities/medical-fee'),
				new Link('Medical Fee Item Component', [], 'icon-book', '/admin/entities/medical-fee-item-component'),
				new Link('Medical Record Initial Checklist', [], 'icon-book', '/admin/entities/medical-record-initial-checklist'),
				new Link('Medical Record Next Verification Checklist', [], 'icon-book', '/admin/entities/medical-record-next-verification-checklist'),
				new Link('Medication Administered History', [], 'icon-book', '/admin/entities/medication-administered-history'),
				new Link('Medication Compound', [], 'icon-book', '/admin/entities/medication-compound'),
				new Link('Medication Header', [], 'icon-book', '/admin/entities/medication-header'),
				new Link('Medication Item', [], 'icon-book', '/admin/entities/medication-item'),
				new Link('Merchant', [], 'icon-book', '/admin/entities/merchant'),
				new Link('Merchant Surcharge and Fee', [], 'icon-book', '/admin/entities/merchant-surcharge-and-fee'),
				new Link('NHIS Claim', [], 'icon-book', '/admin/entities/nhis-claim'),
				new Link('NHIS Claim GDRG Detail', [], 'icon-book', '/admin/entities/nhis-claim-gdrg-detail'),
				new Link('NHIS Claim Investigation Detail', [], 'icon-book', '/admin/entities/nhis-claim-investigation-detail'),
				new Link('NHIS GDRG', [], 'icon-book', '/admin/entities/nhis-gdrg'),
				new Link('NHIS Investigation', [], 'icon-book', '/admin/entities/nhis-investigation'),
				new Link('NHIS Medicine', [], 'icon-book', '/admin/entities/nhis-medicine'),
				new Link('NHIS Service Outcome', [], 'icon-book', '/admin/entities/nhis-service-outcome'),
				new Link('NHIS Specialty Attended', [], 'icon-book', '/admin/entities/nhis-specialty-attended'),
				new Link('NHIS Type Of Service', [], 'icon-book', '/admin/entities/nhis-type-of-service'),
				new Link('Newborn Detail', [], 'icon-book', '/admin/entities/newborn-detail'),
				new Link('Numbering Setup', [], 'icon-book', '/admin/entities/numbering-setup'),
				new Link('Nurse Vital Sign Measurement', [], 'icon-book', '/admin/entities/nurse-vital-sign-measurement'),
				new Link('Obstetric And Gynecology History', [], 'icon-book', '/admin/entities/obstetric-and-gynecology-history'),
				new Link('Odontogram Examination', [], 'icon-book', '/admin/entities/odontogram-examination'),
				new Link('Operating Theater Medical Examination Record', [], 'icon-book', '/admin/entities/operating-theater-medical-examination-record'),
				new Link('Ophthalmology Examination', [], 'icon-book', '/admin/entities/ophthalmology-examination'),
				new Link('PCare Action Examination', [], 'icon-book', '/admin/entities/pcare-action-examination'),
				new Link('PCare Club Prolanis', [], 'icon-book', '/admin/entities/pcare-club-prolanis'),
				new Link('PCare Compound Drug', [], 'icon-book', '/admin/entities/pcare-compound-drug'),
				new Link('PCare Compound Drug Item', [], 'icon-book', '/admin/entities/pcare-compound-drug-item'),
				new Link('PCare Diagnosa', [], 'icon-book', '/admin/entities/pcare-diagnosa'),
				new Link('PCare Dokter', [], 'icon-book', '/admin/entities/pcare-dokter'),
				new Link('PCare Examination', [], 'icon-book', '/admin/entities/pcare-examination'),
				new Link('PCare MCU', [], 'icon-book', '/admin/entities/pcare-mcu'),
				new Link('PCare NonCompound Drug', [], 'icon-book', '/admin/entities/pcare-noncompound-drug'),
				new Link('PCare Referensi Sarana', [], 'icon-book', '/admin/entities/pcare-referensi-sarana'),
				new Link('PCare Status Pulang', [], 'icon-book', '/admin/entities/pcare-status-pulang'),
				new Link('PCare Tindakan', [], 'icon-book', '/admin/entities/pcare-tindakan'),
				new Link('PCare Umum', [], 'icon-book', '/admin/entities/pcare-umum'),
				new Link('Patient Case History', [], 'icon-book', '/admin/entities/patient-case-history'),
				new Link('Patient Consent', [], 'icon-book', '/admin/entities/patient-consent'),
				new Link('Patient Contact Info', [], 'icon-book', '/admin/entities/patient-contact-info'),
				new Link('Patient Detail', [], 'icon-book', '/admin/entities/patient-detail'),
				new Link('Patient Detail Address', [], 'icon-book', '/admin/entities/patient-detail-address'),
				new Link('Patient Emergency Contact Detail', [], 'icon-book', '/admin/entities/patient-emergency-contact-detail'),
				new Link('Patient Employment Detail ', [], 'icon-book', '/admin/entities/patient-employment-detail'),
				new Link('Patient General Info', [], 'icon-book', '/admin/entities/patient-general-info'),
				new Link('Patient Payment  Self Paying', [], 'icon-book', '/admin/entities/patient-payment-self-paying'),
				new Link('Patient Payment BPJS', [], 'icon-book', '/admin/entities/patient-payment-bpjs'),
				new Link('Patient Payment Insurance', [], 'icon-book', '/admin/entities/patient-payment-insurance'),
				new Link('Patient Payment Others', [], 'icon-book', '/admin/entities/patient-payment-others'),
				new Link('Patient Personal Info', [], 'icon-book', '/admin/entities/patient-personal-info'),
				new Link('Patient Supporting Document', [], 'icon-book', '/admin/entities/patient-supporting-document'),
				new Link('Patient Visit', [], 'icon-book', '/admin/entities/patient-visit'),
				new Link('Patient Visit Patient Payment Insurance', [], 'icon-book', '/admin/entities/patient-visit-patient-payment-insurance'),
				new Link('Patient Visit Patient Payment Others', [], 'icon-book', '/admin/entities/patient-visit-patient-payment-others'),
				new Link('Patient Visit Payment Self Paying', [], 'icon-book', '/admin/entities/patient-visit-payment-self-paying'),
				new Link('Patient Vital Information', [], 'icon-book', '/admin/entities/patient-vital-information'),
				new Link('Pharmacy Setup', [], 'icon-book', '/admin/entities/pharmacy-setup'),
				new Link('Post Operative Details', [], 'icon-book', '/admin/entities/post-operative-details'),
				new Link('Preoperative Records', [], 'icon-book', '/admin/entities/preoperative-records'),
				new Link('Prescription Compound', [], 'icon-book', '/admin/entities/prescription-compound'),
				new Link('Prescription Header', [], 'icon-book', '/admin/entities/prescription-header'),
				new Link('Prescription Item', [], 'icon-book', '/admin/entities/prescription-item'),
				new Link('Price Component', [], 'icon-book', '/admin/entities/price-component'),
				new Link('Process Workflow', [], 'icon-book', '/admin/entities/process-workflow'),
				new Link('Purchase Order', [], 'icon-book', '/admin/entities/purchase-order'),
				new Link('Purchase Order Stock Detail', [], 'icon-book', '/admin/entities/purchase-order-stock-detail'),
				new Link('Purchase Requisition', [], 'icon-book', '/admin/entities/purchase-requisition'),
				new Link('Purchase Requisition Stock Detail', [], 'icon-book', '/admin/entities/purchase-requisition-stock-detail'),
				new Link('Reference Data', [], 'icon-book', '/admin/entities/reference-data'),
				new Link('Reference Header', [], 'icon-book', '/admin/entities/reference-header'),
				new Link('Registration', [], 'icon-book', '/admin/entities/registration'),
				new Link('Retail Pharmacy', [], 'icon-book', '/admin/entities/retail-pharmacy'),
				new Link('Retail Pharmacy Invoice', [], 'icon-book', '/admin/entities/retail-pharmacy-invoice'),
				new Link('Retail Pharmacy Stock Detail', [], 'icon-book', '/admin/entities/retail-pharmacy-stock-detail'),
				new Link('Return Supplier', [], 'icon-book', '/admin/entities/return-supplier'),
				new Link('Return Supplier Stock Detail', [], 'icon-book', '/admin/entities/return-supplier-stock-detail'),
				new Link('Room Facility', [], 'icon-book', '/admin/entities/room-facility'),
				new Link('Room Transfer', [], 'icon-book', '/admin/entities/room-transfer'),
				new Link('SEP', [], 'icon-book', '/admin/entities/sep'),
				new Link('Sample Collection Information', [], 'icon-book', '/admin/entities/sample-collection-information'),
				new Link('Sample Collection Items', [], 'icon-book', '/admin/entities/sample-collection-items'),
				new Link('Satu Sehat Configuration', [], 'icon-book', '/admin/entities/satu-sehat-configuration'),
				new Link('Service', [], 'icon-book', '/admin/entities/service'),
				new Link('Service Facility Category', [], 'icon-book', '/admin/entities/service-facility-category'),
				new Link('Service Item', [], 'icon-book', '/admin/entities/service-item'),
				new Link('Service Item Assignment', [], 'icon-book', '/admin/entities/service-item-assignment'),
				new Link('Staff', [], 'icon-book', '/admin/entities/staff'),
				new Link('Stock Catalogue', [], 'icon-book', '/admin/entities/stock-catalogue'),
				new Link('Stock Control', [], 'icon-book', '/admin/entities/stock-control'),
				new Link('Stock Transaction Detail', [], 'icon-book', '/admin/entities/stock-transaction-detail'),
				new Link('Stock Transaction Per Date', [], 'icon-book', '/admin/entities/stock-transaction-per-date'),
				new Link('Stock Transaction Per Date Type', [], 'icon-book', '/admin/entities/stock-transaction-per-date-type'),
				new Link('Supplier', [], 'icon-book', '/admin/entities/supplier'),
				new Link('Supplier Bank Account', [], 'icon-book', '/admin/entities/supplier-bank-account'),
				new Link('Supplier Contact Detail', [], 'icon-book', '/admin/entities/supplier-contact-detail'),
				new Link('Supplier Product Detail', [], 'icon-book', '/admin/entities/supplier-product-detail'),
				new Link('Tariff Definition', [], 'icon-book', '/admin/entities/tariff-definition'),
				new Link('Tariff Definition Other Component', [], 'icon-book', '/admin/entities/tariff-definition-other-component'),
				new Link('Tariff Formula', [], 'icon-book', '/admin/entities/tariff-formula'),
				new Link('Tariff Package', [], 'icon-book', '/admin/entities/tariff-package'),
				new Link('Tariff Package Item', [], 'icon-book', '/admin/entities/tariff-package-item'),
				new Link('Tariff Package Service Assignment', [], 'icon-book', '/admin/entities/tariff-package-service-assignment'),
				new Link('Tariff Schema', [], 'icon-book', '/admin/entities/tariff-schema'),
				new Link('Task Dashboard', [], 'icon-book', '/admin/entities/task-dashboard'),
				new Link('Transaction Detail Type', [], 'icon-book', '/admin/entities/transaction-detail-type'),
				new Link('Transaction Detail Type Mapping', [], 'icon-book', '/admin/entities/transaction-detail-type-mapping'),
				new Link('Transfer Order', [], 'icon-book', '/admin/entities/transfer-order'),
				new Link('Transfer Order Stock Detail', [], 'icon-book', '/admin/entities/transfer-order-stock-detail'),
				new Link('Unit Of Measurement', [], 'icon-book', '/admin/entities/unit-of-measurement'),
				new Link('Vaccination Order', [], 'icon-book', '/admin/entities/vaccination-order'),
				new Link('Vaccination Order Detail', [], 'icon-book', '/admin/entities/vaccination-order-detail'),
				new Link('Vital Signs', [], 'icon-book', '/admin/entities/vital-signs'),
				new Link('Warehouse', [], 'icon-book', '/admin/entities/warehouse'),
				new Link('Warehouse Initial Stock ', [], 'icon-book', '/admin/entities/warehouse-initial-stock'),
				new Link('Warehouse Inventory', [], 'icon-book', '/admin/entities/warehouse-inventory'),
		];

		// % protected region % [Customise or remove the default navigation bar links for entities] end
		// % protected region % [Customise or remove the default navigation bar links for users] off begin
		let userSubLinks = [
			new Link('Administration User', [], 'icon-book', '/admin/users/administration-user'),
			new Link('Administrator', [], 'icon-book', '/admin/users/administrator'),
			new Link('Cashier User', [], 'icon-book', '/admin/users/cashier-user'),
			new Link('Claim User', [], 'icon-book', '/admin/users/claim-user'),
			new Link('Diagnostic Support User', [], 'icon-book', '/admin/users/diagnostic-support-user'),
			new Link('Doctor User', [], 'icon-book', '/admin/users/doctor-user'),
			new Link('Facility User', [], 'icon-book', '/admin/users/facility-user'),
			new Link('Management User', [], 'icon-book', '/admin/users/management-user'),
			new Link('Medical Record user', [], 'icon-book', '/admin/users/medical-record-user'),
			new Link('Medical Transcriber User', [], 'icon-book', '/admin/users/medical-transcriber-user'),
			new Link('Nurse User', [], 'icon-book', '/admin/users/nurse-user'),
			new Link('Pharmacy User', [], 'icon-book', '/admin/users/pharmacy-user'),
			new Link('Purchasing User', [], 'icon-book', '/admin/users/purchasing-user'),
			new Link('Registration User', [], 'icon-book', '/admin/users/registration-user'),
			new Link('System Admin User', [], 'icon-book', '/admin/users/system-admin-user'),
			new Link('Warehouse User', [], 'icon-book', '/admin/users/warehouse-user'),
		];
		// % protected region % [Customise or remove the default navigation bar links for users] end

		// % protected region % [Customise or remove the default navigation bar links for utility] off begin
		let utilitySubLinks = [
			new Link('GraphiQL', [], '', environment.API_URL + '/graphiql', true),
			new Link('Voyager', [], '', environment.API_URL + '/voyager', true),
			new Link('OpenAPI', [], '', environment.API_URL + '/swagger-ui.html', true),
			new Link('Git', [], '', 'https://gitlab.codebots.dev', true)
		];
		// % protected region % [Customise or remove the default navigation bar links for utility] end

		// % protected region % [Customise or remove the default navigation bar links] off begin
		this.navBarLinks.push(
			new LinkList([
				new Link('Admin Dashboard', [], 'icon-home', '/admin')
			]),
			new LinkList([
				new Link('Users', userSubLinks, 'icon-person-group'),
				new Link('Entities', entitySubLinks, 'icon-list')
			]),
			new LinkList([
				new Link('Utility', utilitySubLinks, 'icon-file'),
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
