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
import kmsweb.entities.NhisTypeOfServiceEntity;
import kmsweb.lib.validators.SimpleConstraintViolationImpl;
import kmsweb.repositories.NhisTypeOfServiceRepository;
import kmsweb.repositories.auditing.AuditingRepository;
import kmsweb.repositories.NhisTypeOfServiceRepository;
import kmsweb.services.NhisTypeOfServiceService;

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
public class NhisTypeOfServiceServiceTest {

	@Mock
	private Validator validator;

	@Mock
	private AuditingRepository auditingRepository;

	@Mock
	private NhisTypeOfServiceRepository nhisTypeOfServiceRepository;

	private NhisTypeOfServiceService nhisTypeOfServiceService;

	private static MockNeat mockNeat;

	// % protected region % [Add additional method fields here] off begin
	// % protected region % [Add additional method fields here] end

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockNeat = MockNeat.threadLocal();

		nhisTypeOfServiceService = new NhisTypeOfServiceService(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			validator,
			auditingRepository,
			nhisTypeOfServiceRepository
		);

		// % protected region % [Add additional setup logic here] off begin
		// % protected region % [Add additional setup logic here] end
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private NhisTypeOfServiceEntity setupConstrainViolationMock() {
		// % protected region % [Customise entity mock setup here] off begin
		var entity = new NhisTypeOfServiceEntity();

		entity.setCode(mockNeat.strings().get());
		when(nhisTypeOfServiceRepository.findByCode(entity.getCode()))
			.thenReturn(Optional.of(entity));

		// % protected region % [Customise entity mock setup here] end

		return entity;
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private NhisTypeOfServiceEntity setupConstrainHonouredMock() {
		// % protected region % [Customise valid entity mock setup here] off begin
		var entity = new NhisTypeOfServiceEntity();

		entity.setCode(mockNeat.strings().get());
		when(nhisTypeOfServiceRepository.findByCode(entity.getCode()))
			.thenReturn(Optional.empty());

		// % protected region % [Customise valid entity mock setup here] end

		return entity;
	}


	// % protected region % [Override test method here testUniquenessConstraintViolatedOnCodeAttribute] off begin
	@Test
	public void testUniquenessConstraintViolatedOnCodeAttribute() {
		var entity = setupConstrainViolationMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<NhisTypeOfServiceEntity>(
				"Code",
				entity.getCode(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"Code"
		);

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
			nhisTypeOfServiceService.validateEntity(entity);
		});

		// We only care about the constraint violation we are looking for here
		assertTrue(exception.getConstraintViolations().contains(nameConstraintViolation));
	}
	// % protected region % [Override test method here testUniquenessConstraintViolatedOnCodeAttribute] end

	// % protected region % [Override test method here testUniquenessConstraintHonouredOnCodeAttribute] off begin
	@Test
	public void testUniquenessConstraintHonouredOnCodeAttribute() {
		var entity = setupConstrainHonouredMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<NhisTypeOfServiceEntity>(
				"Code",
				entity.getCode(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"Code"
		);

		// In the case of a failure an exception will be thrown here of type ConstraintViolationException
		nhisTypeOfServiceService.validateEntity(entity);
	}
	// % protected region % [Override test method here testUniquenessConstraintHonouredOnCodeAttribute] end

	// % protected region % [Add additional test methods here] off begin
	// % protected region % [Add additional test methods here] end
}