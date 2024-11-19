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

package kmsweb.services;

import net.andreinc.mockneat.MockNeat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.lib.validators.SimpleConstraintViolationImpl;
import kmsweb.repositories.PatientGeneralInfoRepository;
import kmsweb.repositories.auditing.AuditingRepository;
import kmsweb.repositories.PatientGeneralInfoRepository;
import kmsweb.services.PatientGeneralInfoService;
import kmsweb.repositories.BpjsClaimSubmissionRepository;
import kmsweb.repositories.CashReceiptRepository;
import kmsweb.repositories.CashRefundRepository;
import kmsweb.repositories.InformedConsentRepository;
import kmsweb.repositories.PatientCaseHistoryRepository;
import kmsweb.repositories.PatientConsentRepository;
import kmsweb.repositories.PatientContactInfoRepository;
import kmsweb.repositories.PatientDetailRepository;
import kmsweb.repositories.PatientDetailAddressRepository;
import kmsweb.repositories.PatientEmergencyContactDetailRepository;
import kmsweb.repositories.PatientEmploymentDetailRepository;
import kmsweb.repositories.PatientPaymentSelfPayingRepository;
import kmsweb.repositories.PatientPaymentBPJSRepository;
import kmsweb.repositories.PatientPaymentInsuranceRepository;
import kmsweb.repositories.PatientPaymentOthersRepository;
import kmsweb.repositories.PatientPersonalInfoRepository;
import kmsweb.repositories.PatientSupportingDocumentRepository;
import kmsweb.repositories.PatientVisitRepository;
import kmsweb.repositories.RetailPharmacyRepository;
import kmsweb.lib.file.models.FileEntity;
import kmsweb.lib.file.services.AbstractFileService;
// % protected region % [Override your file service import here] off begin
import kmsweb.lib.file.services.S3FileService;
// % protected region % [Override your file service import here] end

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Override the default annotations here] off begin
@Tag("validation")
// % protected region % [Override the default annotations here] end
public class PatientGeneralInfoServiceTest {
	// % protected region % [Override the file service mock here] off begin
	@Mock
	private S3FileService s3FileService;
	// % protected region % [Override the file service mock here] end


	@Mock
	private BpjsClaimSubmissionRepository bpjsClaimSubmissionRepository;


	@Mock
	private CashReceiptRepository cashReceiptRepository;


	@Mock
	private CashRefundRepository cashRefundRepository;


	@Mock
	private InformedConsentRepository informedConsentRepository;


	@Mock
	private PatientCaseHistoryRepository patientCaseHistoryRepository;


	@Mock
	private PatientConsentRepository patientConsentRepository;


	@Mock
	private PatientContactInfoRepository patientContactInfoRepository;


	@Mock
	private PatientDetailRepository patientDetailRepository;


	@Mock
	private PatientDetailAddressRepository patientDetailAddressRepository;


	@Mock
	private PatientEmergencyContactDetailRepository patientEmergencyContactDetailRepository;


	@Mock
	private PatientEmploymentDetailRepository patientEmploymentDetailRepository;


	@Mock
	private PatientPaymentSelfPayingRepository patientPaymentSelfPayingRepository;


	@Mock
	private PatientPaymentBPJSRepository patientPaymentBPJSRepository;


	@Mock
	private PatientPaymentInsuranceRepository patientPaymentInsuranceRepository;


	@Mock
	private PatientPaymentOthersRepository patientPaymentOthersRepository;


	@Mock
	private PatientPersonalInfoRepository patientPersonalInfoRepository;


	@Mock
	private PatientSupportingDocumentRepository patientSupportingDocumentRepository;


	@Mock
	private PatientVisitRepository patientVisitRepository;


	@Mock
	private RetailPharmacyRepository retailPharmacyRepository;

	@Mock
	private BpjsClaimSubmissionService bpjsClaimSubmissionService;

	@Mock
	private CashRefundService cashRefundService;

	@Mock
	private InformedConsentService informedConsentService;

	@Mock
	private CashReceiptService cashReceiptService;

	@Mock
	private PatientCaseHistoryService patientCaseHistoryService;

	@Mock
	private PatientConsentService patientConsentService;

	@Mock
	private PatientContactInfoService patientContactInfoService;

	@Mock
	private PatientDetailAddressService patientDetailAddressService;

	@Mock
	private PatientDetailService patientDetailService;

	@Mock
	private PatientEmergencyContactDetailService patientEmergencyContactDetailService;

	@Mock
	private PatientEmploymentDetailService patientEmploymentDetailService;

	@Mock
	private PatientSupportingDocumentService patientSupportingDocumentService;

	@Mock
	private PatientPaymentBPJSService patientPaymentBPJSService;

	@Mock
	private PatientPaymentInsuranceService patientPaymentInsuranceService;

	@Mock
	private PatientPaymentOthersService patientPaymentOthersService;

	@Mock
	private PatientPersonalInfoService patientPersonalInfoService;

	@Mock
	private PatientPaymentSelfPayingService patientPaymentSelfPayingService;

	@Mock
	private RetailPharmacyService retailPharmacyService;

	@Mock
	private PatientVisitService patientVisitService;

	@Mock
	private Validator validator;

	@Mock
	private AuditingRepository auditingRepository;

	@Mock
	private PatientGeneralInfoRepository patientGeneralInfoRepository;

	private PatientGeneralInfoService patientGeneralInfoService;

	private static MockNeat mockNeat;

	// % protected region % [Add additional method fields here] off begin
	// % protected region % [Add additional method fields here] end

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockNeat = MockNeat.threadLocal();

		patientGeneralInfoService = new PatientGeneralInfoService(
			// % protected region % [Add any additional constructor parameters here] off begin
			s3FileService,
			// % protected region % [Add any additional constructor parameters here] end
			bpjsClaimSubmissionRepository,
			cashReceiptRepository,
			cashRefundRepository,
			informedConsentRepository,
			patientCaseHistoryRepository,
			patientConsentRepository,
			patientContactInfoRepository,
			patientDetailRepository,
			patientDetailAddressRepository,
			patientEmergencyContactDetailRepository,
			patientEmploymentDetailRepository,
			patientPaymentSelfPayingRepository,
			patientPaymentBPJSRepository,
			patientPaymentInsuranceRepository,
			patientPaymentOthersRepository,
			patientPersonalInfoRepository,
			patientSupportingDocumentRepository,
			patientVisitRepository,
			retailPharmacyRepository,
			validator,
			auditingRepository,
			patientGeneralInfoRepository
		);

		// % protected region % [Add additional setup logic here] off begin
		// % protected region % [Add additional setup logic here] end
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private PatientGeneralInfoEntity setupConstrainViolationMock() {
		// % protected region % [Customise entity mock setup here] off begin
		var entity = new PatientGeneralInfoEntity();

		entity.setPatientID(mockNeat.strings().get());
		when(patientGeneralInfoRepository.findByPatientID(entity.getPatientID()))
			.thenReturn(Optional.of(entity));

		// % protected region % [Customise entity mock setup here] end

		return entity;
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private PatientGeneralInfoEntity setupConstrainHonouredMock() {
		// % protected region % [Customise valid entity mock setup here] off begin
		var entity = new PatientGeneralInfoEntity();

		entity.setPatientID(mockNeat.strings().get());
		when(patientGeneralInfoRepository.findByPatientID(entity.getPatientID()))
			.thenReturn(Optional.empty());

		// % protected region % [Customise valid entity mock setup here] end

		return entity;
	}


	// % protected region % [Override test method here testUniquenessConstraintViolatedOnPatientIDAttribute] off begin
	@Test
	public void testUniquenessConstraintViolatedOnPatientIDAttribute() {
		var entity = setupConstrainViolationMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<PatientGeneralInfoEntity>(
				"Patient ID",
				entity.getPatientID(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"PatientID"
		);

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
			patientGeneralInfoService.validateEntity(entity);
		});

		// We only care about the constraint violation we are looking for here
		assertTrue(exception.getConstraintViolations().contains(nameConstraintViolation));
	}
	// % protected region % [Override test method here testUniquenessConstraintViolatedOnPatientIDAttribute] end

	// % protected region % [Override test method here testUniquenessConstraintHonouredOnPatientIDAttribute] off begin
	@Test
	public void testUniquenessConstraintHonouredOnPatientIDAttribute() {
		var entity = setupConstrainHonouredMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<PatientGeneralInfoEntity>(
				"Patient ID",
				entity.getPatientID(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"PatientID"
		);

		// In the case of a failure an exception will be thrown here of type ConstraintViolationException
		patientGeneralInfoService.validateEntity(entity);
	}
	// % protected region % [Override test method here testUniquenessConstraintHonouredOnPatientIDAttribute] end

	// % protected region % [Add additional test methods here] off begin
	// % protected region % [Add additional test methods here] end
}