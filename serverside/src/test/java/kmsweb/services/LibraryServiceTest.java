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
import kmsweb.entities.LibraryEntity;
import kmsweb.lib.validators.SimpleConstraintViolationImpl;
import kmsweb.repositories.LibraryRepository;
import kmsweb.repositories.auditing.AuditingRepository;
import kmsweb.repositories.LibraryRepository;
import kmsweb.services.LibraryService;
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
public class LibraryServiceTest {
	// % protected region % [Override the file service mock here] off begin
	@Mock
	private S3FileService s3FileService;
	// % protected region % [Override the file service mock here] end

	@Mock
	private Validator validator;

	@Mock
	private AuditingRepository auditingRepository;

	@Mock
	private LibraryRepository libraryRepository;

	private LibraryService libraryService;

	private static MockNeat mockNeat;

	// % protected region % [Add additional method fields here] off begin
	// % protected region % [Add additional method fields here] end

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockNeat = MockNeat.threadLocal();

		libraryService = new LibraryService(
			// % protected region % [Add any additional constructor parameters here] off begin
			s3FileService,
			// % protected region % [Add any additional constructor parameters here] end
			validator,
			auditingRepository,
			libraryRepository
		);

		// % protected region % [Add additional setup logic here] off begin
		// % protected region % [Add additional setup logic here] end
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private LibraryEntity setupConstrainViolationMock() {
		// % protected region % [Customise entity mock setup here] off begin
		var entity = new LibraryEntity();

		entity.setLibraryItemCode(mockNeat.strings().get());
		when(libraryRepository.findByLibraryItemCode(entity.getLibraryItemCode()))
			.thenReturn(Optional.of(entity));

		// % protected region % [Customise entity mock setup here] end

		return entity;
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private LibraryEntity setupConstrainHonouredMock() {
		// % protected region % [Customise valid entity mock setup here] off begin
		var entity = new LibraryEntity();

		entity.setLibraryItemCode(mockNeat.strings().get());
		when(libraryRepository.findByLibraryItemCode(entity.getLibraryItemCode()))
			.thenReturn(Optional.empty());

		// % protected region % [Customise valid entity mock setup here] end

		return entity;
	}


	// % protected region % [Override test method here testUniquenessConstraintViolatedOnLibraryItemCodeAttribute] off begin
	@Test
	public void testUniquenessConstraintViolatedOnLibraryItemCodeAttribute() {
		var entity = setupConstrainViolationMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<LibraryEntity>(
				"Library Item Code",
				entity.getLibraryItemCode(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"LibraryItemCode"
		);

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
			libraryService.validateEntity(entity);
		});

		// We only care about the constraint violation we are looking for here
		assertTrue(exception.getConstraintViolations().contains(nameConstraintViolation));
	}
	// % protected region % [Override test method here testUniquenessConstraintViolatedOnLibraryItemCodeAttribute] end

	// % protected region % [Override test method here testUniquenessConstraintHonouredOnLibraryItemCodeAttribute] off begin
	@Test
	public void testUniquenessConstraintHonouredOnLibraryItemCodeAttribute() {
		var entity = setupConstrainHonouredMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<LibraryEntity>(
				"Library Item Code",
				entity.getLibraryItemCode(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"LibraryItemCode"
		);

		// In the case of a failure an exception will be thrown here of type ConstraintViolationException
		libraryService.validateEntity(entity);
	}
	// % protected region % [Override test method here testUniquenessConstraintHonouredOnLibraryItemCodeAttribute] end

	// % protected region % [Add additional test methods here] off begin
	// % protected region % [Add additional test methods here] end
}