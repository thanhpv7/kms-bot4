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
import kmsweb.entities.ServiceEntity;
import kmsweb.lib.validators.SimpleConstraintViolationImpl;
import kmsweb.repositories.ServiceRepository;
import kmsweb.repositories.auditing.AuditingRepository;
import kmsweb.repositories.ServiceRepository;
import kmsweb.services.ServiceService;
import kmsweb.repositories.BpjsPcarePoliRepository;
import kmsweb.repositories.BpjsServiceMappingRepository;
import kmsweb.repositories.DoctorScheduleRepository;
import kmsweb.repositories.ExaminationGroupRepository;
import kmsweb.repositories.McuPackageItemRepository;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.repositories.ServiceFacilityCategoryRepository;
import kmsweb.repositories.ServiceItemRepository;
import kmsweb.repositories.StaffRepository;

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
public class ServiceServiceTest {


	@Mock
	private BpjsPcarePoliRepository bpjsPcarePoliRepository;


	@Mock
	private BpjsServiceMappingRepository bpjsServiceMappingRepository;


	@Mock
	private DoctorScheduleRepository doctorScheduleRepository;


	@Mock
	private ExaminationGroupRepository examinationGroupRepository;


	@Mock
	private McuPackageItemRepository mcuPackageItemRepository;


	@Mock
	private RegistrationRepository registrationRepository;


	@Mock
	private ServiceFacilityCategoryRepository serviceFacilityCategoryRepository;


	@Mock
	private ServiceItemRepository serviceItemRepository;


	@Mock
	private StaffRepository staffRepository;

	@Mock
	private BpjsPcarePoliService bpjsPcarePoliService;

	@Mock
	private BpjsServiceMappingService bpjsServiceMappingService;

	@Mock
	private DoctorScheduleService doctorScheduleService;

	@Mock
	private ExaminationGroupService examinationGroupService;

	@Mock
	private McuPackageItemService mcuPackageItemService;

	@Mock
	private RegistrationService registrationService;

	@Mock
	private RegistrationService registrationService;

	@Mock
	private ServiceFacilityCategoryService serviceFacilityCategoryService;

	@Mock
	private ServiceItemService serviceItemService;

	@Mock
	private Validator validator;

	@Mock
	private AuditingRepository auditingRepository;

	@Mock
	private ServiceRepository serviceRepository;

	private ServiceService serviceService;

	private static MockNeat mockNeat;

	// % protected region % [Add additional method fields here] off begin
	// % protected region % [Add additional method fields here] end

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockNeat = MockNeat.threadLocal();

		serviceService = new ServiceService(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			bpjsPcarePoliRepository,
			bpjsServiceMappingRepository,
			doctorScheduleRepository,
			examinationGroupRepository,
			mcuPackageItemRepository,
			registrationRepository,
			serviceFacilityCategoryRepository,
			serviceItemRepository,
			staffRepository,
			validator,
			auditingRepository,
			serviceRepository
		);

		// % protected region % [Add additional setup logic here] off begin
		// % protected region % [Add additional setup logic here] end
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private ServiceEntity setupConstrainViolationMock() {
		// % protected region % [Customise entity mock setup here] off begin
		var entity = new ServiceEntity();

		entity.setServiceNumber(mockNeat.strings().get());
		when(serviceRepository.findByServiceNumber(entity.getServiceNumber()))
			.thenReturn(Optional.of(entity));

		// % protected region % [Customise entity mock setup here] end

		return entity;
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private ServiceEntity setupConstrainHonouredMock() {
		// % protected region % [Customise valid entity mock setup here] off begin
		var entity = new ServiceEntity();

		entity.setServiceNumber(mockNeat.strings().get());
		when(serviceRepository.findByServiceNumber(entity.getServiceNumber()))
			.thenReturn(Optional.empty());

		// % protected region % [Customise valid entity mock setup here] end

		return entity;
	}


	// % protected region % [Override test method here testUniquenessConstraintViolatedOnServiceNumberAttribute] off begin
	@Test
	public void testUniquenessConstraintViolatedOnServiceNumberAttribute() {
		var entity = setupConstrainViolationMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<ServiceEntity>(
				"Service Number",
				entity.getServiceNumber(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"ServiceNumber"
		);

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
			serviceService.validateEntity(entity);
		});

		// We only care about the constraint violation we are looking for here
		assertTrue(exception.getConstraintViolations().contains(nameConstraintViolation));
	}
	// % protected region % [Override test method here testUniquenessConstraintViolatedOnServiceNumberAttribute] end

	// % protected region % [Override test method here testUniquenessConstraintHonouredOnServiceNumberAttribute] off begin
	@Test
	public void testUniquenessConstraintHonouredOnServiceNumberAttribute() {
		var entity = setupConstrainHonouredMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<ServiceEntity>(
				"Service Number",
				entity.getServiceNumber(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"ServiceNumber"
		);

		// In the case of a failure an exception will be thrown here of type ConstraintViolationException
		serviceService.validateEntity(entity);
	}
	// % protected region % [Override test method here testUniquenessConstraintHonouredOnServiceNumberAttribute] end

	// % protected region % [Add additional test methods here] off begin
	// % protected region % [Add additional test methods here] end
}