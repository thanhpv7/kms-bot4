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
import kmsweb.entities.SupplierEntity;
import kmsweb.lib.validators.SimpleConstraintViolationImpl;
import kmsweb.repositories.SupplierRepository;
import kmsweb.repositories.auditing.AuditingRepository;
import kmsweb.repositories.SupplierRepository;
import kmsweb.services.SupplierService;
import kmsweb.repositories.GoodsReceiveNoteRepository;
import kmsweb.repositories.PurchaseOrderRepository;
import kmsweb.repositories.PurchaseRequisitionRepository;
import kmsweb.repositories.ReturnSupplierRepository;
import kmsweb.repositories.SupplierBankAccountRepository;
import kmsweb.repositories.SupplierContactDetailRepository;
import kmsweb.repositories.SupplierProductDetailRepository;

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
public class SupplierServiceTest {


	@Mock
	private GoodsReceiveNoteRepository goodsReceiveNoteRepository;


	@Mock
	private PurchaseOrderRepository purchaseOrderRepository;


	@Mock
	private PurchaseRequisitionRepository purchaseRequisitionRepository;


	@Mock
	private ReturnSupplierRepository returnSupplierRepository;


	@Mock
	private SupplierBankAccountRepository supplierBankAccountRepository;


	@Mock
	private SupplierContactDetailRepository supplierContactDetailRepository;


	@Mock
	private SupplierProductDetailRepository supplierProductDetailRepository;

	@Mock
	private GoodsReceiveNoteService goodsReceiveNoteService;

	@Mock
	private PurchaseOrderService purchaseOrderService;

	@Mock
	private PurchaseRequisitionService purchaseRequisitionService;

	@Mock
	private ReturnSupplierService returnSupplierService;

	@Mock
	private SupplierContactDetailService supplierContactDetailService;

	@Mock
	private SupplierBankAccountService supplierBankAccountService;

	@Mock
	private SupplierProductDetailService supplierProductDetailService;

	@Mock
	private Validator validator;

	@Mock
	private AuditingRepository auditingRepository;

	@Mock
	private SupplierRepository supplierRepository;

	private SupplierService supplierService;

	private static MockNeat mockNeat;

	// % protected region % [Add additional method fields here] off begin
	// % protected region % [Add additional method fields here] end

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockNeat = MockNeat.threadLocal();

		supplierService = new SupplierService(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			goodsReceiveNoteRepository,
			purchaseOrderRepository,
			purchaseRequisitionRepository,
			returnSupplierRepository,
			supplierBankAccountRepository,
			supplierContactDetailRepository,
			supplierProductDetailRepository,
			validator,
			auditingRepository,
			supplierRepository
		);

		// % protected region % [Add additional setup logic here] off begin
		// % protected region % [Add additional setup logic here] end
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private SupplierEntity setupConstrainViolationMock() {
		// % protected region % [Customise entity mock setup here] off begin
		var entity = new SupplierEntity();

		entity.setSupplierNumber(mockNeat.strings().get());
		when(supplierRepository.findBySupplierNumber(entity.getSupplierNumber()))
			.thenReturn(Optional.of(entity));

		// % protected region % [Customise entity mock setup here] end

		return entity;
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private SupplierEntity setupConstrainHonouredMock() {
		// % protected region % [Customise valid entity mock setup here] off begin
		var entity = new SupplierEntity();

		entity.setSupplierNumber(mockNeat.strings().get());
		when(supplierRepository.findBySupplierNumber(entity.getSupplierNumber()))
			.thenReturn(Optional.empty());

		// % protected region % [Customise valid entity mock setup here] end

		return entity;
	}


	// % protected region % [Override test method here testUniquenessConstraintViolatedOnSupplierNumberAttribute] off begin
	@Test
	public void testUniquenessConstraintViolatedOnSupplierNumberAttribute() {
		var entity = setupConstrainViolationMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<SupplierEntity>(
				"Supplier Number",
				entity.getSupplierNumber(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"SupplierNumber"
		);

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
			supplierService.validateEntity(entity);
		});

		// We only care about the constraint violation we are looking for here
		assertTrue(exception.getConstraintViolations().contains(nameConstraintViolation));
	}
	// % protected region % [Override test method here testUniquenessConstraintViolatedOnSupplierNumberAttribute] end

	// % protected region % [Override test method here testUniquenessConstraintHonouredOnSupplierNumberAttribute] off begin
	@Test
	public void testUniquenessConstraintHonouredOnSupplierNumberAttribute() {
		var entity = setupConstrainHonouredMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<SupplierEntity>(
				"Supplier Number",
				entity.getSupplierNumber(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"SupplierNumber"
		);

		// In the case of a failure an exception will be thrown here of type ConstraintViolationException
		supplierService.validateEntity(entity);
	}
	// % protected region % [Override test method here testUniquenessConstraintHonouredOnSupplierNumberAttribute] end

	// % protected region % [Add additional test methods here] off begin
	// % protected region % [Add additional test methods here] end
}