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
package kmsweb.cucumber.pom.pages.admin.crud.view;

import com.google.inject.Inject;
import kmsweb.cucumber.utils.*;
import kmsweb.entities.AbstractEntity;
import kmsweb.entities.RegistrationEntity;

import cucumber.runtime.java.guice.ScenarioScoped;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.interactions.Actions;
import java.util.*;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * RegistrationPage is a Page POM that is associated with the admin/entities/registration url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesRegistrationCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='registrationNumber-field']")
	private WebElement registrationNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='scheduledDate-field']")
	private WebElement scheduledDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='actualInDate-field']")
	private WebElement actualInDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='dismissalDate-field']")
	private WebElement dismissalDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='dismissalType-field']")
	private WebElement dismissalTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='queueNo-field']")
	private WebElement queueNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='duration-field']")
	private WebElement durationField;
	@FindBy(how = How.XPATH, using = "//*[@id='treatmentClass-field']")
	private WebElement treatmentClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='bookedTreatmentClass-field']")
	private WebElement bookedTreatmentClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='shift-field']")
	private WebElement shiftField;
	@FindBy(how = How.XPATH, using = "//*[@id='cito-field']")
	private WebElement citoField;
	@FindBy(how = How.XPATH, using = "//*[@id='oneDayCare-field']")
	private WebElement oneDayCareField;
	@FindBy(how = How.XPATH, using = "//*[@id='referral-field']")
	private WebElement referralField;
	@FindBy(how = How.XPATH, using = "//*[@id='registrationStatus-field']")
	private WebElement registrationStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='referralType-field']")
	private WebElement referralTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='purpose-field']")
	private WebElement purposeField;
	@FindBy(how = How.XPATH, using = "//*[@id='referralNotes-field']")
	private WebElement referralNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='supportingDocument-field']")
	private WebElement supportingDocumentField;
	@FindBy(how = How.XPATH, using = "//*[@id='admissionDiagnosis-field']")
	private WebElement admissionDiagnosisField;
	@FindBy(how = How.XPATH, using = "//*[@id='printWristband-field']")
	private WebElement printWristbandField;
	@FindBy(how = How.XPATH, using = "//*[@id='printLabel-field']")
	private WebElement printLabelField;
	@FindBy(how = How.XPATH, using = "//*[@id='uploadedDateTime-field']")
	private WebElement uploadedDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='visitStatus-field']")
	private WebElement visitStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='instruction-field']")
	private WebElement instructionField;
	@FindBy(how = How.XPATH, using = "//*[@id='isAnAppointment-field']")
	private WebElement isAnAppointmentField;
	@FindBy(how = How.XPATH, using = "//*[@id='referralNumber-field']")
	private WebElement referralNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	@FindBy(how = How.XPATH, using = "//*[@id='kodepoli-field']")
	private WebElement kodepoliField;
	@FindBy(how = How.XPATH, using = "//*[@id='deathCertificateNo-field']")
	private WebElement deathCertificateNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='timeOfDeath-field']")
	private WebElement timeOfDeathField;
	@FindBy(how = How.XPATH, using = "//*[@id='dismissalReferral-field']")
	private WebElement dismissalReferralField;
	@FindBy(how = How.XPATH, using = "//*[@id='dismissalReferralDetail-field']")
	private WebElement dismissalReferralDetailField;
	@FindBy(how = How.XPATH, using = "//*[@id='dismissalReferralType-field']")
	private WebElement dismissalReferralTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='dismissalReferringNotes-field']")
	private WebElement dismissalReferringNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='patientIsReferredBack-field']")
	private WebElement patientIsReferredBackField;
	@FindBy(how = How.XPATH, using = "//*[@id='mcuPackage-field']")
	private WebElement mcuPackageField;
	@FindBy(how = How.XPATH, using = "//*[@id='parentRegistrationNumber-field']")
	private WebElement parentRegistrationNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='isUnknownPatient-field']")
	private WebElement isUnknownPatientField;
	@FindBy(how = How.XPATH, using = "//*[@id='otherReferredFacility-field']")
	private WebElement otherReferredFacilityField;
	@FindBy(how = How.XPATH, using = "//*[@id='otherReferredStaff-field']")
	private WebElement otherReferredStaffField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorScheduleDetailId-field']")
	private WebElement doctorScheduleDetailIdField;
	

	// Outgoing one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsPRBDetail-field']")
	private WebElement bpjsPRBDetailField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsPcareRegistrations-field']")
	private WebElement bpjsPcareRegistrationsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsSEP-field']")
	private WebElement bpjsSEPField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalCertificateDischargeResume-field']")
	private WebElement medicalCertificateDischargeResumeField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalCertificateBirth-field']")
	private WebElement medicalCertificateBirthField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalCertificateHospitalization-field']")
	private WebElement medicalCertificateHospitalizationField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalCertificateMedicalAttendance-field']")
	private WebElement medicalCertificateMedicalAttendanceField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalCertificateMentalHealth-field']")
	private WebElement medicalCertificateMentalHealthField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalCertificatePhysicalHealth-field']")
	private WebElement medicalCertificatePhysicalHealthField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalCertificateRestrictedWork-field']")
	private WebElement medicalCertificateRestrictedWorkField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalCertificateSickLeave-field']")
	private WebElement medicalCertificateSickLeaveField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalExaminationRecord-field']")
	private WebElement medicalExaminationRecordField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='pcareExamination-field']")
	private WebElement pcareExaminationField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='sep-field']")
	private WebElement sepField;

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='diagnosticStaffExaminationSummaryId-field']")
	private WebElement diagnosticStaffExaminationSummaryField;

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bedReservesIds-field']")
	private WebElement bedReservesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='diagnosticExaminationResultsIds-field']")
	private WebElement diagnosticExaminationResultsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='fluidBalanceDetailsIds-field']")
	private WebElement fluidBalanceDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='informedConsentsIds-field']")
	private WebElement informedConsentsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoiceItemsIds-field']")
	private WebElement invoiceItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalFeesIds-field']")
	private WebElement medicalFeesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationHeadersIds-field']")
	private WebElement medicationHeadersField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientVitalInformationsIds-field']")
	private WebElement patientVitalInformationsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='prescriptionHeadersIds-field']")
	private WebElement prescriptionHeadersField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='sampleCollectionInformationsIds-field']")
	private WebElement sampleCollectionInformationsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='vaccinationOrdersIds-field']")
	private WebElement vaccinationOrdersField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='admissionICD10Id-field']")
	private WebElement admissionICD10Field;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='admissionICD9CMId-field']")
	private WebElement admissionICD9CMField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='dismissalReferringFacilityId-field']")
	private WebElement dismissalReferringFacilityField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='dismissalReferringStaffId-field']")
	private WebElement dismissalReferringStaffField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='referringUnitId-field']")
	private WebElement referringUnitField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='referringFacilityId-field']")
	private WebElement referringFacilityField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bedFacilityId-field']")
	private WebElement bedFacilityField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientVisitId-field']")
	private WebElement patientVisitField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='serviceId-field']")
	private WebElement serviceField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='staffId-field']")
	private WebElement staffField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='requestedById-field']")
	private WebElement requestedByField;

	// Outgoing many-to-many

	// Incoming many-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='examinationItemsIds-field']")
	private WebElement examinationItemsField;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesRegistrationCrudViewPage(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			@NonNull WebDriver webDriver,
			@NonNull Properties properties
	) {
		super(
			// % protected region % [Add any additional constructor arguments here] off begin
			// % protected region % [Add any additional constructor arguments here] end
			webDriver,
			properties,
			"admin/entities/registration/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}