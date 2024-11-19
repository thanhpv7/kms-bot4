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
import kmsweb.entities.BpjsHealthFacilityEntity;
import kmsweb.lib.validators.SimpleConstraintViolationImpl;
import kmsweb.repositories.BpjsHealthFacilityRepository;
import kmsweb.repositories.auditing.AuditingRepository;
import kmsweb.repositories.BpjsHealthFacilityRepository;
import kmsweb.services.BpjsHealthFacilityService;
import kmsweb.repositories.BpjsClaimSubmissionRepository;
import kmsweb.repositories.BpjsFacilityListRepository;
import kmsweb.repositories.BpjsPatientReferralRepository;
import kmsweb.repositories.BpjsReferralSpecialistRepository;

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
public class BpjsHealthFacilityServiceTest {


	@Mock
	private BpjsClaimSubmissionRepository bpjsClaimSubmissionRepository;


	@Mock
	private BpjsFacilityListRepository bpjsFacilityListRepository;


	@Mock
	private BpjsPatientReferralRepository bpjsPatientReferralRepository;


	@Mock
	private BpjsReferralSpecialistRepository bpjsReferralSpecialistRepository;

	@Mock
	private BpjsClaimSubmissionService bpjsClaimSubmissionService;

	@Mock
	private BpjsFacilityListService bpjsFacilityListService;

	@Mock
	private BpjsPatientReferralService bpjsPatientReferralService;

	@Mock
	private BpjsReferralSpecialistService bpjsReferralSpecialistService;

	@Mock
	private Validator validator;

	@Mock
	private AuditingRepository auditingRepository;

	@Mock
	private BpjsHealthFacilityRepository bpjsHealthFacilityRepository;

	private BpjsHealthFacilityService bpjsHealthFacilityService;

	private static MockNeat mockNeat;

	// % protected region % [Add additional method fields here] off begin
	// % protected region % [Add additional method fields here] end

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockNeat = MockNeat.threadLocal();

		bpjsHealthFacilityService = new BpjsHealthFacilityService(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			bpjsClaimSubmissionRepository,
			bpjsFacilityListRepository,
			bpjsPatientReferralRepository,
			bpjsReferralSpecialistRepository,
			validator,
			auditingRepository,
			bpjsHealthFacilityRepository
		);

		// % protected region % [Add additional setup logic here] off begin
		// % protected region % [Add additional setup logic here] end
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private BpjsHealthFacilityEntity setupConstrainViolationMock() {
		// % protected region % [Customise entity mock setup here] off begin
		var entity = new BpjsHealthFacilityEntity();

		entity.setRefCode(mockNeat.strings().get());
		when(bpjsHealthFacilityRepository.findByRefCode(entity.getRefCode()))
			.thenReturn(Optional.of(entity));

		// % protected region % [Customise entity mock setup here] end

		return entity;
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private BpjsHealthFacilityEntity setupConstrainHonouredMock() {
		// % protected region % [Customise valid entity mock setup here] off begin
		var entity = new BpjsHealthFacilityEntity();

		entity.setRefCode(mockNeat.strings().get());
		when(bpjsHealthFacilityRepository.findByRefCode(entity.getRefCode()))
			.thenReturn(Optional.empty());

		// % protected region % [Customise valid entity mock setup here] end

		return entity;
	}


	// % protected region % [Override test method here testUniquenessConstraintViolatedOnRefCodeAttribute] off begin
	@Test
	public void testUniquenessConstraintViolatedOnRefCodeAttribute() {
		var entity = setupConstrainViolationMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<BpjsHealthFacilityEntity>(
				"Ref Code",
				entity.getRefCode(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"RefCode"
		);

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
			bpjsHealthFacilityService.validateEntity(entity);
		});

		// We only care about the constraint violation we are looking for here
		assertTrue(exception.getConstraintViolations().contains(nameConstraintViolation));
	}
	// % protected region % [Override test method here testUniquenessConstraintViolatedOnRefCodeAttribute] end

	// % protected region % [Override test method here testUniquenessConstraintHonouredOnRefCodeAttribute] off begin
	@Test
	public void testUniquenessConstraintHonouredOnRefCodeAttribute() {
		var entity = setupConstrainHonouredMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<BpjsHealthFacilityEntity>(
				"Ref Code",
				entity.getRefCode(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"RefCode"
		);

		// In the case of a failure an exception will be thrown here of type ConstraintViolationException
		bpjsHealthFacilityService.validateEntity(entity);
	}
	// % protected region % [Override test method here testUniquenessConstraintHonouredOnRefCodeAttribute] end

	// % protected region % [Add additional test methods here] off begin
	// % protected region % [Add additional test methods here] end
}