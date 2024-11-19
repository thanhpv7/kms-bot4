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
import kmsweb.entities.BedFacilityEntity;
import kmsweb.lib.validators.SimpleConstraintViolationImpl;
import kmsweb.repositories.BedFacilityRepository;
import kmsweb.repositories.auditing.AuditingRepository;
import kmsweb.repositories.BedFacilityRepository;
import kmsweb.services.BedFacilityService;
import kmsweb.repositories.BedReserveRepository;
import kmsweb.repositories.InpatientMedicalExaminationRecordRepository;
import kmsweb.repositories.IntraoperativeRecordsRepository;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.repositories.PostOperativeDetailsRepository;
import kmsweb.repositories.PreoperativeRecordsRepository;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.repositories.RoomFacilityRepository;
import kmsweb.repositories.RoomTransferRepository;

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
public class BedFacilityServiceTest {


	@Mock
	private BedReserveRepository bedReserveRepository;


	@Mock
	private InpatientMedicalExaminationRecordRepository inpatientMedicalExaminationRecordRepository;


	@Mock
	private IntraoperativeRecordsRepository intraoperativeRecordsRepository;


	@Mock
	private InvoiceRepository invoiceRepository;


	@Mock
	private PostOperativeDetailsRepository postOperativeDetailsRepository;


	@Mock
	private PreoperativeRecordsRepository preoperativeRecordsRepository;


	@Mock
	private RegistrationRepository registrationRepository;


	@Mock
	private RoomFacilityRepository roomFacilityRepository;


	@Mock
	private RoomTransferRepository roomTransferRepository;

	@Mock
	private BedReserveService bedReserveService;

	@Mock
	private InpatientMedicalExaminationRecordService inpatientMedicalExaminationRecordService;

	@Mock
	private InvoiceService invoiceService;

	@Mock
	private RegistrationService registrationService;

	@Mock
	private RoomTransferService roomTransferService;

	@Mock
	private Validator validator;

	@Mock
	private AuditingRepository auditingRepository;

	@Mock
	private BedFacilityRepository bedFacilityRepository;

	private BedFacilityService bedFacilityService;

	private static MockNeat mockNeat;

	// % protected region % [Add additional method fields here] off begin
	// % protected region % [Add additional method fields here] end

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockNeat = MockNeat.threadLocal();

		bedFacilityService = new BedFacilityService(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			bedReserveRepository,
			inpatientMedicalExaminationRecordRepository,
			intraoperativeRecordsRepository,
			invoiceRepository,
			postOperativeDetailsRepository,
			preoperativeRecordsRepository,
			registrationRepository,
			roomFacilityRepository,
			roomTransferRepository,
			validator,
			auditingRepository,
			bedFacilityRepository
		);

		// % protected region % [Add additional setup logic here] off begin
		// % protected region % [Add additional setup logic here] end
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private BedFacilityEntity setupConstrainViolationMock() {
		// % protected region % [Customise entity mock setup here] off begin
		var entity = new BedFacilityEntity();

		entity.setBedNumber(mockNeat.strings().get());
		when(bedFacilityRepository.findByBedNumber(entity.getBedNumber()))
			.thenReturn(Optional.of(entity));

		// % protected region % [Customise entity mock setup here] end

		return entity;
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private BedFacilityEntity setupConstrainHonouredMock() {
		// % protected region % [Customise valid entity mock setup here] off begin
		var entity = new BedFacilityEntity();

		entity.setBedNumber(mockNeat.strings().get());
		when(bedFacilityRepository.findByBedNumber(entity.getBedNumber()))
			.thenReturn(Optional.empty());

		// % protected region % [Customise valid entity mock setup here] end

		return entity;
	}


	// % protected region % [Override test method here testUniquenessConstraintViolatedOnBedNumberAttribute] off begin
	@Test
	public void testUniquenessConstraintViolatedOnBedNumberAttribute() {
		var entity = setupConstrainViolationMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<BedFacilityEntity>(
				"Bed Number",
				entity.getBedNumber(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"BedNumber"
		);

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
			bedFacilityService.validateEntity(entity);
		});

		// We only care about the constraint violation we are looking for here
		assertTrue(exception.getConstraintViolations().contains(nameConstraintViolation));
	}
	// % protected region % [Override test method here testUniquenessConstraintViolatedOnBedNumberAttribute] end

	// % protected region % [Override test method here testUniquenessConstraintHonouredOnBedNumberAttribute] off begin
	@Test
	public void testUniquenessConstraintHonouredOnBedNumberAttribute() {
		var entity = setupConstrainHonouredMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<BedFacilityEntity>(
				"Bed Number",
				entity.getBedNumber(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"BedNumber"
		);

		// In the case of a failure an exception will be thrown here of type ConstraintViolationException
		bedFacilityService.validateEntity(entity);
	}
	// % protected region % [Override test method here testUniquenessConstraintHonouredOnBedNumberAttribute] end

	// % protected region % [Add additional test methods here] off begin
	// % protected region % [Add additional test methods here] end
}