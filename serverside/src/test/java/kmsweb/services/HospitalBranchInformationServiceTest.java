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
import kmsweb.entities.HospitalBranchInformationEntity;
import kmsweb.lib.validators.SimpleConstraintViolationImpl;
import kmsweb.repositories.HospitalBranchInformationRepository;
import kmsweb.repositories.auditing.AuditingRepository;
import kmsweb.repositories.HospitalBranchInformationRepository;
import kmsweb.services.HospitalBranchInformationService;
import kmsweb.repositories.HospitalGroupInformationRepository;
import kmsweb.repositories.StaffRepository;
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
public class HospitalBranchInformationServiceTest {
	// % protected region % [Override the file service mock here] off begin
	@Mock
	private S3FileService s3FileService;
	// % protected region % [Override the file service mock here] end


	@Mock
	private HospitalGroupInformationRepository hospitalGroupInformationRepository;


	@Mock
	private StaffRepository staffRepository;

	@Mock
	private Validator validator;

	@Mock
	private AuditingRepository auditingRepository;

	@Mock
	private HospitalBranchInformationRepository hospitalBranchInformationRepository;

	private HospitalBranchInformationService hospitalBranchInformationService;

	private static MockNeat mockNeat;

	// % protected region % [Add additional method fields here] off begin
	// % protected region % [Add additional method fields here] end

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockNeat = MockNeat.threadLocal();

		hospitalBranchInformationService = new HospitalBranchInformationService(
			// % protected region % [Add any additional constructor parameters here] off begin
			s3FileService,
			// % protected region % [Add any additional constructor parameters here] end
			hospitalGroupInformationRepository,
			staffRepository,
			validator,
			auditingRepository,
			hospitalBranchInformationRepository
		);

		// % protected region % [Add additional setup logic here] off begin
		// % protected region % [Add additional setup logic here] end
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private HospitalBranchInformationEntity setupConstrainViolationMock() {
		// % protected region % [Customise entity mock setup here] off begin
		var entity = new HospitalBranchInformationEntity();

		entity.setHospitalCode(mockNeat.strings().get());
		when(hospitalBranchInformationRepository.findByHospitalCode(entity.getHospitalCode()))
			.thenReturn(Optional.of(entity));

		entity.setTaxIdentification(mockNeat.strings().get());
		when(hospitalBranchInformationRepository.findByTaxIdentification(entity.getTaxIdentification()))
			.thenReturn(Optional.of(entity));

		// % protected region % [Customise entity mock setup here] end

		return entity;
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private HospitalBranchInformationEntity setupConstrainHonouredMock() {
		// % protected region % [Customise valid entity mock setup here] off begin
		var entity = new HospitalBranchInformationEntity();

		entity.setHospitalCode(mockNeat.strings().get());
		when(hospitalBranchInformationRepository.findByHospitalCode(entity.getHospitalCode()))
			.thenReturn(Optional.empty());

		entity.setTaxIdentification(mockNeat.strings().get());
		when(hospitalBranchInformationRepository.findByTaxIdentification(entity.getTaxIdentification()))
			.thenReturn(Optional.empty());

		// % protected region % [Customise valid entity mock setup here] end

		return entity;
	}


	// % protected region % [Override test method here testUniquenessConstraintViolatedOnHospitalCodeAttribute] off begin
	@Test
	public void testUniquenessConstraintViolatedOnHospitalCodeAttribute() {
		var entity = setupConstrainViolationMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<HospitalBranchInformationEntity>(
				"Hospital Code",
				entity.getHospitalCode(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"HospitalCode"
		);

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
			hospitalBranchInformationService.validateEntity(entity);
		});

		// We only care about the constraint violation we are looking for here
		assertTrue(exception.getConstraintViolations().contains(nameConstraintViolation));
	}
	// % protected region % [Override test method here testUniquenessConstraintViolatedOnHospitalCodeAttribute] end

	// % protected region % [Override test method here testUniquenessConstraintHonouredOnHospitalCodeAttribute] off begin
	@Test
	public void testUniquenessConstraintHonouredOnHospitalCodeAttribute() {
		var entity = setupConstrainHonouredMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<HospitalBranchInformationEntity>(
				"Hospital Code",
				entity.getHospitalCode(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"HospitalCode"
		);

		// In the case of a failure an exception will be thrown here of type ConstraintViolationException
		hospitalBranchInformationService.validateEntity(entity);
	}
	// % protected region % [Override test method here testUniquenessConstraintHonouredOnHospitalCodeAttribute] end

	// % protected region % [Override test method here testUniquenessConstraintViolatedOnTaxIdentificationAttribute] off begin
	@Test
	public void testUniquenessConstraintViolatedOnTaxIdentificationAttribute() {
		var entity = setupConstrainViolationMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<HospitalBranchInformationEntity>(
				"Tax Identification",
				entity.getTaxIdentification(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"TaxIdentification"
		);

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
			hospitalBranchInformationService.validateEntity(entity);
		});

		// We only care about the constraint violation we are looking for here
		assertTrue(exception.getConstraintViolations().contains(nameConstraintViolation));
	}
	// % protected region % [Override test method here testUniquenessConstraintViolatedOnTaxIdentificationAttribute] end

	// % protected region % [Override test method here testUniquenessConstraintHonouredOnTaxIdentificationAttribute] off begin
	@Test
	public void testUniquenessConstraintHonouredOnTaxIdentificationAttribute() {
		var entity = setupConstrainHonouredMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<HospitalBranchInformationEntity>(
				"Tax Identification",
				entity.getTaxIdentification(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"TaxIdentification"
		);

		// In the case of a failure an exception will be thrown here of type ConstraintViolationException
		hospitalBranchInformationService.validateEntity(entity);
	}
	// % protected region % [Override test method here testUniquenessConstraintHonouredOnTaxIdentificationAttribute] end

	// % protected region % [Add additional test methods here] off begin
	// % protected region % [Add additional test methods here] end
}