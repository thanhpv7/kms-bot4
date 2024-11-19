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

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.querydsl.QSort;
import kmsweb.entities.*;
import kmsweb.lib.validators.SimpleConstraintViolationImpl;
import kmsweb.repositories.WarehouseRepository;
import kmsweb.repositories.auditing.AuditingRepository;
import kmsweb.graphql.utils.Where;
import kmsweb.graphql.utils.AuditQueryType;
import kmsweb.services.utils.QuerydslUtils;
import kmsweb.configs.security.auditing.CustomRevisionEntity;
import com.google.common.collect.Lists;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import com.google.common.collect.Sets;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import kmsweb.entities.BatchStockBalanceEntity;
import kmsweb.repositories.BatchStockBalanceRepository;
import kmsweb.entities.BatchStockBalancePerDateEntity;
import kmsweb.repositories.BatchStockBalancePerDateRepository;
import kmsweb.entities.BatchStockTransactionDetailEntity;
import kmsweb.repositories.BatchStockTransactionDetailRepository;
import kmsweb.entities.GoodsReceiveNoteEntity;
import kmsweb.repositories.GoodsReceiveNoteRepository;
import kmsweb.entities.GoodsReceiveNoteBatchEntity;
import kmsweb.repositories.GoodsReceiveNoteBatchRepository;
import kmsweb.entities.InternalOrderEntity;
import kmsweb.repositories.InternalOrderRepository;
import kmsweb.entities.InventoryAdjusmentBatchEntity;
import kmsweb.repositories.InventoryAdjusmentBatchRepository;
import kmsweb.entities.InventoryAdjustmentEntity;
import kmsweb.repositories.InventoryAdjustmentRepository;
import kmsweb.entities.InventoryBatchCorrectionEntity;
import kmsweb.repositories.InventoryBatchCorrectionRepository;
import kmsweb.entities.LocationEntity;
import kmsweb.repositories.LocationRepository;
import kmsweb.entities.MedicalFeeEntity;
import kmsweb.repositories.MedicalFeeRepository;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.repositories.MedicationHeaderRepository;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.repositories.PrescriptionHeaderRepository;
import kmsweb.entities.PurchaseOrderEntity;
import kmsweb.repositories.PurchaseOrderRepository;
import kmsweb.entities.PurchaseRequisitionEntity;
import kmsweb.repositories.PurchaseRequisitionRepository;
import kmsweb.entities.RetailPharmacyEntity;
import kmsweb.repositories.RetailPharmacyRepository;
import kmsweb.entities.ReturnSupplierEntity;
import kmsweb.repositories.ReturnSupplierRepository;
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.repositories.StockCatalogueRepository;
import kmsweb.entities.StockControlEntity;
import kmsweb.repositories.StockControlRepository;
import kmsweb.entities.StockTransactionDetailEntity;
import kmsweb.repositories.StockTransactionDetailRepository;
import kmsweb.entities.StockTransactionPerDateEntity;
import kmsweb.repositories.StockTransactionPerDateRepository;
import kmsweb.entities.StockTransactionPerDateTypeEntity;
import kmsweb.repositories.StockTransactionPerDateTypeRepository;
import kmsweb.entities.TransferOrderEntity;
import kmsweb.repositories.TransferOrderRepository;
import kmsweb.entities.VaccinationOrderDetailEntity;
import kmsweb.repositories.VaccinationOrderDetailRepository;
import kmsweb.entities.WarehouseInitialStockEntity;
import kmsweb.repositories.WarehouseInitialStockRepository;
import kmsweb.entities.WarehouseInventoryEntity;
import kmsweb.repositories.WarehouseInventoryRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class WarehouseService extends AbstractService<WarehouseEntity, WarehouseRepository, WarehouseEntityAudit> {

	private final String[] referenceNamesInWarehouseEntity = {
		"batchStockBalancesWarehouse",
		"batchStockBalances",
		"batchStockTransactionDetails",
		"destinationWarehouses",
		"goodsReceiveNoteBatchs",
		"goodsReceiveNotes",
		"internalOrders",
		"inventoryAdjusmentBatchs",
		"inventoryAdjustments",
		"inventoryBatchCorrections",
		"locations",
		"medicalFees",
		"medicationHeaders",
		"prescriptionHeaders",
		"purchaseOrders",
		"purchaseRequisitions",
		"retailPharmacies",
		"returnSuppliers",
		"sourceWarehouses",
		"stockCatalogues",
		"stockControls",
		"stockTransactionDetails",
		"stockTransactionPerDateTypes",
		"stockTransactionPerDates",
		"vaccinationOrderDetails",
		"warehouseInitialStockS",
		"warehouseInventories",
	};

	private final BatchStockBalanceRepository batchStockBalanceRepository;

	private final BatchStockBalancePerDateRepository batchStockBalancePerDateRepository;

	private final BatchStockTransactionDetailRepository batchStockTransactionDetailRepository;

	private final GoodsReceiveNoteRepository goodsReceiveNoteRepository;

	private final GoodsReceiveNoteBatchRepository goodsReceiveNoteBatchRepository;

	private final InternalOrderRepository internalOrderRepository;

	private final InventoryAdjusmentBatchRepository inventoryAdjusmentBatchRepository;

	private final InventoryAdjustmentRepository inventoryAdjustmentRepository;

	private final InventoryBatchCorrectionRepository inventoryBatchCorrectionRepository;

	private final LocationRepository locationRepository;

	private final MedicalFeeRepository medicalFeeRepository;

	private final MedicationHeaderRepository medicationHeaderRepository;

	private final PrescriptionHeaderRepository prescriptionHeaderRepository;

	private final PurchaseOrderRepository purchaseOrderRepository;

	private final PurchaseRequisitionRepository purchaseRequisitionRepository;

	private final RetailPharmacyRepository retailPharmacyRepository;

	private final ReturnSupplierRepository returnSupplierRepository;

	private final StockCatalogueRepository stockCatalogueRepository;

	private final StockControlRepository stockControlRepository;

	private final StockTransactionDetailRepository stockTransactionDetailRepository;

	private final StockTransactionPerDateRepository stockTransactionPerDateRepository;

	private final StockTransactionPerDateTypeRepository stockTransactionPerDateTypeRepository;

	private final TransferOrderRepository transferOrderRepository;

	private final VaccinationOrderDetailRepository vaccinationOrderDetailRepository;

	private final WarehouseInitialStockRepository warehouseInitialStockRepository;

	private final WarehouseInventoryRepository warehouseInventoryRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public WarehouseService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		BatchStockBalanceRepository batchStockBalanceRepository,
		BatchStockBalancePerDateRepository batchStockBalancePerDateRepository,
		BatchStockTransactionDetailRepository batchStockTransactionDetailRepository,
		GoodsReceiveNoteRepository goodsReceiveNoteRepository,
		GoodsReceiveNoteBatchRepository goodsReceiveNoteBatchRepository,
		InternalOrderRepository internalOrderRepository,
		InventoryAdjusmentBatchRepository inventoryAdjusmentBatchRepository,
		InventoryAdjustmentRepository inventoryAdjustmentRepository,
		InventoryBatchCorrectionRepository inventoryBatchCorrectionRepository,
		LocationRepository locationRepository,
		MedicalFeeRepository medicalFeeRepository,
		MedicationHeaderRepository medicationHeaderRepository,
		PrescriptionHeaderRepository prescriptionHeaderRepository,
		PurchaseOrderRepository purchaseOrderRepository,
		PurchaseRequisitionRepository purchaseRequisitionRepository,
		RetailPharmacyRepository retailPharmacyRepository,
		ReturnSupplierRepository returnSupplierRepository,
		StockCatalogueRepository stockCatalogueRepository,
		StockControlRepository stockControlRepository,
		StockTransactionDetailRepository stockTransactionDetailRepository,
		StockTransactionPerDateRepository stockTransactionPerDateRepository,
		StockTransactionPerDateTypeRepository stockTransactionPerDateTypeRepository,
		TransferOrderRepository transferOrderRepository,
		VaccinationOrderDetailRepository vaccinationOrderDetailRepository,
		WarehouseInitialStockRepository warehouseInitialStockRepository,
		WarehouseInventoryRepository warehouseInventoryRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		WarehouseRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.batchStockBalanceRepository = batchStockBalanceRepository;

		this.batchStockBalancePerDateRepository = batchStockBalancePerDateRepository;

		this.batchStockTransactionDetailRepository = batchStockTransactionDetailRepository;

		this.goodsReceiveNoteRepository = goodsReceiveNoteRepository;

		this.goodsReceiveNoteBatchRepository = goodsReceiveNoteBatchRepository;

		this.internalOrderRepository = internalOrderRepository;

		this.inventoryAdjusmentBatchRepository = inventoryAdjusmentBatchRepository;

		this.inventoryAdjustmentRepository = inventoryAdjustmentRepository;

		this.inventoryBatchCorrectionRepository = inventoryBatchCorrectionRepository;

		this.locationRepository = locationRepository;

		this.medicalFeeRepository = medicalFeeRepository;

		this.medicationHeaderRepository = medicationHeaderRepository;

		this.prescriptionHeaderRepository = prescriptionHeaderRepository;

		this.purchaseOrderRepository = purchaseOrderRepository;

		this.purchaseRequisitionRepository = purchaseRequisitionRepository;

		this.retailPharmacyRepository = retailPharmacyRepository;

		this.returnSupplierRepository = returnSupplierRepository;

		this.stockCatalogueRepository = stockCatalogueRepository;

		this.stockControlRepository = stockControlRepository;

		this.stockTransactionDetailRepository = stockTransactionDetailRepository;

		this.stockTransactionPerDateRepository = stockTransactionPerDateRepository;

		this.stockTransactionPerDateTypeRepository = stockTransactionPerDateTypeRepository;

		this.transferOrderRepository = transferOrderRepository;

		this.vaccinationOrderDetailRepository = vaccinationOrderDetailRepository;

		this.warehouseInitialStockRepository = warehouseInitialStockRepository;

		this.warehouseInventoryRepository = warehouseInventoryRepository;

		this.validator = validator;

		this.auditingRepository = auditingRepository;

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * Return the number of records available in the database.
	 *
	 * @return the number of records available in the database.
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@Transactional(readOnly = true)
	public long count()
	// % protected region % [Add any throwables, implementations, or extensions for count here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for count here] end
	{
		// % protected region % [Add any additional logic for count before the main body here] off begin
		// % protected region % [Add any additional logic for count before the main body here] end

		long count = repository.count();

		// % protected region % [Add any additional logic for count before returning the count here] off begin
		// % protected region % [Add any additional logic for count before returning the count here] end

		return count;
	}

	/**
	 * Return the number of records available in the database with filters
	 *
	 * @return the number of records available in the database.
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@Transactional(readOnly = true)
	public long count(List<List<Where>> conditions)
	// % protected region % [Add any throwables, implementations, or extensions for count with filters here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for count with filters here] end
	{
		// % protected region % [Add any additional logic for count with query before the main body here] off begin
		// % protected region % [Add any additional logic for count with query before the main body here] end

		long count = (CollectionUtils.isEmpty(conditions) || CollectionUtils.isEmpty(conditions.get(0)))
				? repository.count() : repository.count(this.getQueryConditions(conditions));

		// % protected region % [Add any additional logic for count with query before returning the count here] off begin
		// % protected region % [Add any additional logic for count with query before returning the count here] end

		return count;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Warehouse Number.
	 *
	 * @param warehouseNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Warehouse Number
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<WarehouseEntity> findByWarehouseNumber(String warehouseNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByWarehouseNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWarehouseNumber here] end
	{
		// % protected region % [Add any additional logic for findByWarehouseNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByWarehouseNumber before the main body here] end

		Optional<WarehouseEntity> entity = repository.findByWarehouseNumber(warehouseNumber);

		// % protected region % [Add any additional logic for findByWarehouseNumber before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByWarehouseNumber before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Warehouse Name.
	 *
	 * @param warehouseName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Warehouse Name
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@Transactional(readOnly = true)
	public List<WarehouseEntity> findByWarehouseName(String warehouseName)
	// % protected region % [Add any throwables, implementations, or extensions for findByWarehouseName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWarehouseName here] end
	{
		// % protected region % [Add any additional logic for findByWarehouseName before the main body here] off begin
		// % protected region % [Add any additional logic for findByWarehouseName before the main body here] end

		List<WarehouseEntity> entities = Lists.newArrayList(repository.findByWarehouseName(warehouseName));

		// % protected region % [Add any additional logic for findByWarehouseName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWarehouseName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Description.
	 *
	 * @param description the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Description
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@Transactional(readOnly = true)
	public List<WarehouseEntity> findByDescription(String description)
	// % protected region % [Add any throwables, implementations, or extensions for findByDescription here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDescription here] end
	{
		// % protected region % [Add any additional logic for findByDescription before the main body here] off begin
		// % protected region % [Add any additional logic for findByDescription before the main body here] end

		List<WarehouseEntity> entities = Lists.newArrayList(repository.findByDescription(description));

		// % protected region % [Add any additional logic for findByDescription before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDescription before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Address.
	 *
	 * @param address the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Address
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@Transactional(readOnly = true)
	public List<WarehouseEntity> findByAddress(String address)
	// % protected region % [Add any throwables, implementations, or extensions for findByAddress here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAddress here] end
	{
		// % protected region % [Add any additional logic for findByAddress before the main body here] off begin
		// % protected region % [Add any additional logic for findByAddress before the main body here] end

		List<WarehouseEntity> entities = Lists.newArrayList(repository.findByAddress(address));

		// % protected region % [Add any additional logic for findByAddress before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAddress before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Contact Person.
	 *
	 * @param contactPerson the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contact Person
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@Transactional(readOnly = true)
	public List<WarehouseEntity> findByContactPerson(String contactPerson)
	// % protected region % [Add any throwables, implementations, or extensions for findByContactPerson here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByContactPerson here] end
	{
		// % protected region % [Add any additional logic for findByContactPerson before the main body here] off begin
		// % protected region % [Add any additional logic for findByContactPerson before the main body here] end

		List<WarehouseEntity> entities = Lists.newArrayList(repository.findByContactPerson(contactPerson));

		// % protected region % [Add any additional logic for findByContactPerson before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByContactPerson before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Phone Number.
	 *
	 * @param phoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Phone Number
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@Transactional(readOnly = true)
	public List<WarehouseEntity> findByPhoneNumber(String phoneNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByPhoneNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPhoneNumber here] end
	{
		// % protected region % [Add any additional logic for findByPhoneNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByPhoneNumber before the main body here] end

		List<WarehouseEntity> entities = Lists.newArrayList(repository.findByPhoneNumber(phoneNumber));

		// % protected region % [Add any additional logic for findByPhoneNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPhoneNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Ext.
	 *
	 * @param ext the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Ext
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@Transactional(readOnly = true)
	public List<WarehouseEntity> findByExt(String ext)
	// % protected region % [Add any throwables, implementations, or extensions for findByExt here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExt here] end
	{
		// % protected region % [Add any additional logic for findByExt before the main body here] off begin
		// % protected region % [Add any additional logic for findByExt before the main body here] end

		List<WarehouseEntity> entities = Lists.newArrayList(repository.findByExt(ext));

		// % protected region % [Add any additional logic for findByExt before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExt before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Mobile Phone Number.
	 *
	 * @param mobilePhoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Mobile Phone Number
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@Transactional(readOnly = true)
	public List<WarehouseEntity> findByMobilePhoneNumber(String mobilePhoneNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByMobilePhoneNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMobilePhoneNumber here] end
	{
		// % protected region % [Add any additional logic for findByMobilePhoneNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByMobilePhoneNumber before the main body here] end

		List<WarehouseEntity> entities = Lists.newArrayList(repository.findByMobilePhoneNumber(mobilePhoneNumber));

		// % protected region % [Add any additional logic for findByMobilePhoneNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMobilePhoneNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@Transactional(readOnly = true)
	public List<WarehouseEntity> findByEmail(String email)
	// % protected region % [Add any throwables, implementations, or extensions for findByEmail here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEmail here] end
	{
		// % protected region % [Add any additional logic for findByEmail before the main body here] off begin
		// % protected region % [Add any additional logic for findByEmail before the main body here] end

		List<WarehouseEntity> entities = Lists.newArrayList(repository.findByEmail(email));

		// % protected region % [Add any additional logic for findByEmail before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEmail before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Revenue Center.
	 *
	 * @param revenueCenter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Revenue Center
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@Transactional(readOnly = true)
	public List<WarehouseEntity> findByRevenueCenter(String revenueCenter)
	// % protected region % [Add any throwables, implementations, or extensions for findByRevenueCenter here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRevenueCenter here] end
	{
		// % protected region % [Add any additional logic for findByRevenueCenter before the main body here] off begin
		// % protected region % [Add any additional logic for findByRevenueCenter before the main body here] end

		List<WarehouseEntity> entities = Lists.newArrayList(repository.findByRevenueCenter(revenueCenter));

		// % protected region % [Add any additional logic for findByRevenueCenter before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRevenueCenter before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<WarehouseEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<WarehouseEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@Transactional(readOnly = true)
	public List<WarehouseEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<WarehouseEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@Transactional(readOnly = true)
	public List<WarehouseEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<WarehouseEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@Transactional(readOnly = true)
	public List<WarehouseEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<WarehouseEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('WarehouseEntity', 'create')")
	public WarehouseEntity create(WarehouseEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		WarehouseEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('WarehouseEntity', 'create')")
	public WarehouseEntity create(WarehouseEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		WarehouseEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		WarehouseEntity newEntity;

		try {
			newEntity = this.save(entityToCreate);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		// % protected region % [Add any additional logic for create before returning the entity here] off begin
		// % protected region % [Add any additional logic for create before returning the entity here] end

		return newEntity;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('WarehouseEntity', 'create')")
	public List<WarehouseEntity> createAll(Iterable<WarehouseEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<WarehouseEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<WarehouseEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('WarehouseEntity', 'update')")
	public WarehouseEntity update(WarehouseEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		WarehouseEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('WarehouseEntity', 'update')")
	public WarehouseEntity update(WarehouseEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		WarehouseEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		WarehouseEntity newEntity;

		try {
			newEntity = this.save(entityToUpdate);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		// % protected region % [Add any additional logic for update before returning the entity here] off begin
		// % protected region % [Add any additional logic for update before returning the entity here] end

		return newEntity;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('WarehouseEntity', 'update')")
	public List<WarehouseEntity> updateAll(Iterable<WarehouseEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<WarehouseEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<WarehouseEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('WarehouseEntity', 'create') or hasPermission('WarehouseEntity', 'update')")
	public WarehouseEntity save(WarehouseEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for save here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for save here] end
	{
		// % protected region % [Add any additional logic for save before the main logic here] off begin
		// % protected region % [Add any additional logic for save before the main logic here] end

		try {
			validateEntity(entity);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		// % protected region % [Add any additional logic for save before saving the entity here] off begin
		// % protected region % [Add any additional logic for save before saving the entity here] end

		WarehouseEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('WarehouseEntity', 'create') or hasPermission('WarehouseEntity', 'update')")
	public List<WarehouseEntity> saveAll(Iterable<WarehouseEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<WarehouseEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('WarehouseEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('WarehouseEntity', 'delete')")
	public void deleteAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for deleteAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteAllByIds here] end
	{
		// % protected region % [Add any additional logic for deleteAll before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteAll before the main logic here] end

		repository.deleteAllByIdIn(ids);
	}

	/**
	 * Delete all entities that do not have an id in the list of ids provided, if no ids provided, delete all.
	 *
	 * @param ids the IDs of the entities to exclude from deletion
	 */
	@Override
	@PreAuthorize("hasPermission('WarehouseEntity', 'delete')")
	public void deleteAllExcludingIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for deleteAllExcludingIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteAllExcludingIds here] end
	{
		// % protected region % [Add any additional logic for deleteAllExcludingIds before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteAllExcludingIds before the main logic here] end

		if (!ids.iterator().hasNext()) {
			repository.deleteAll();
		} else {
			repository.deleteAllByIdNotIn(ids);
		}
	}

	@Override
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	public List<WarehouseEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	public List<WarehouseEntity> findAllExcludingIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllExcludingIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllExcludingIds here] end
	{
		if (!ids.iterator().hasNext()) {
			return Lists.newArrayList(repository.findAll());
		} else {
			return Lists.newArrayList(repository.findAllByIdNotIn(ids));
		}
	}

	@Override
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<WarehouseEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(WarehouseEntity.class);

		// % protected region % [Add any additional processing before converting to a list of WarehouseEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of WarehouseEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<WarehouseEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of WarehouseEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of WarehouseEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(WarehouseEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of WarehouseEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of WarehouseEntityAudits
	 */
	private List<WarehouseEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<WarehouseEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param warehouse warehouse to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private WarehouseEntity updateAuditData(WarehouseEntity warehouse)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return warehouse;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private WarehouseEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		WarehouseEntity entityAtRevision = updateAuditData((WarehouseEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new WarehouseEntityAudit(
				entityAtRevision,
				revision.getModifiedAt(),
				auditType,

				// We don't care about what the UUID is if it is the system.
				(isSystem) ? UUID.randomUUID() : revision.getAuthor().getId(),

				// % protected region % [Customise our revision author name here] off begin
				(isSystem) ? "System" : revision.getAuthor().getName(),
				""
				// % protected region % [Customise our revision author name here] end
		);
	}

	/**
	 * Create the predicate for the querydsl based on one condition
	 *
	 * @param condition Single condition used in the query
	 * @return querydsl predicate
	 */
	protected Predicate processCondition(Where condition)
	// % protected region % [Add any throwables, implementations, or extensions for processCondition here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for processCondition here] end
	{
		// % protected region % [Add any additional logic for processCondition before the main logic here] off begin
		// % protected region % [Add any additional logic for processCondition before the main logic here] end

		Predicate predicate = null;

		QWarehouseEntity entity = QWarehouseEntity.warehouseEntity;

		switch (condition.getPath()) {
			case "created":
				// % protected region % [Add any additional logic before the query parameters of created here] off begin
				// % protected region % [Add any additional logic before the query parameters of created here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.created, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of created here] off begin
				// % protected region % [Add any additional logic after the query parameters of created here] end

				break;
			case "createdBy":
				// % protected region % [Add any additional logic before the query parameters of createdBy here] off begin
				// % protected region % [Add any additional logic before the query parameters of createdBy here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.createdBy, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of createdBy here] off begin
				// % protected region % [Add any additional logic after the query parameters of createdBy here] end

				break;
			case "modified":
				// % protected region % [Add any additional logic before the query parameters of modified here] off begin
				// % protected region % [Add any additional logic before the query parameters of modified here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.modified, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of modified here] off begin
				// % protected region % [Add any additional logic after the query parameters of modified here] end

				break;
			case "modifiedBy":
				// % protected region % [Add any additional logic before the query parameters of modifiedBy here] off begin
				// % protected region % [Add any additional logic before the query parameters of modifiedBy here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.modifiedBy, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of modifiedBy here] off begin
				// % protected region % [Add any additional logic after the query parameters of modifiedBy here] end

				break;
			case "batchStockBalancesWarehouseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Batch Stock Balances Warehouse here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Batch Stock Balances Warehouse here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.batchStockBalancesWarehouse.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Batch Stock Balances Warehouse here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Batch Stock Balances Warehouse here] end

				break;
			case "batchStockBalancesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Batch Stock Balances here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Batch Stock Balances here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.batchStockBalances.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Batch Stock Balances here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Batch Stock Balances here] end

				break;
			case "batchStockTransactionDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Batch Stock Transaction Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Batch Stock Transaction Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.batchStockTransactionDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Batch Stock Transaction Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Batch Stock Transaction Details here] end

				break;
			case "destinationWarehousesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Destination Warehouse to Destination Warehouses here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Destination Warehouse to Destination Warehouses here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.destinationWarehouses.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Destination Warehouse to Destination Warehouses here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Destination Warehouse to Destination Warehouses here] end

				break;
			case "goodsReceiveNoteBatchsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Goods Receive Note Batchs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Goods Receive Note Batchs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.goodsReceiveNoteBatchs.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Goods Receive Note Batchs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Goods Receive Note Batchs here] end

				break;
			case "goodsReceiveNotesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Goods Receive Notes here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Goods Receive Notes here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.goodsReceiveNotes.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Goods Receive Notes here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Goods Receive Notes here] end

				break;
			case "internalOrdersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Internal Orders here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Internal Orders here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.internalOrders.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Internal Orders here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Internal Orders here] end

				break;
			case "inventoryAdjusmentBatchsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Inventory Adjusment Batchs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Inventory Adjusment Batchs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inventoryAdjusmentBatchs.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Inventory Adjusment Batchs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Inventory Adjusment Batchs here] end

				break;
			case "inventoryAdjustmentsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Inventory Adjustments here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Inventory Adjustments here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inventoryAdjustments.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Inventory Adjustments here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Inventory Adjustments here] end

				break;
			case "inventoryBatchCorrectionsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Inventory Batch Corrections here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Inventory Batch Corrections here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inventoryBatchCorrections.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Inventory Batch Corrections here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Inventory Batch Corrections here] end

				break;
			case "locationsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Locations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Locations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.locations.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Locations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Locations here] end

				break;
			case "medicalFeesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Medical Fees here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Medical Fees here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalFees.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Medical Fees here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Medical Fees here] end

				break;
			case "medicationHeadersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Medication Headers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Medication Headers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicationHeaders.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Medication Headers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Medication Headers here] end

				break;
			case "prescriptionHeadersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Prescription Headers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Prescription Headers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.prescriptionHeaders.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Prescription Headers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Prescription Headers here] end

				break;
			case "purchaseOrdersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Purchase Orders here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Purchase Orders here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseOrders.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Purchase Orders here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Purchase Orders here] end

				break;
			case "purchaseRequisitionsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Purchase Requisitions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Purchase Requisitions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseRequisitions.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Purchase Requisitions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Purchase Requisitions here] end

				break;
			case "retailPharmaciesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Retail Pharmacies here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Retail Pharmacies here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.retailPharmacies.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Retail Pharmacies here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Retail Pharmacies here] end

				break;
			case "returnSuppliersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Return Suppliers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Return Suppliers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.returnSuppliers.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Return Suppliers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Return Suppliers here] end

				break;
			case "sourceWarehousesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Source Warehouse to Source Warehouses here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Source Warehouse to Source Warehouses here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sourceWarehouses.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Source Warehouse to Source Warehouses here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Source Warehouse to Source Warehouses here] end

				break;
			case "stockCataloguesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Stock Catalogues here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Stock Catalogues here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockCatalogues.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Stock Catalogues here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Stock Catalogues here] end

				break;
			case "stockControlsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Stock Controls here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Stock Controls here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockControls.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Stock Controls here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Stock Controls here] end

				break;
			case "stockTransactionDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Stock Transaction Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Stock Transaction Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockTransactionDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Stock Transaction Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Stock Transaction Details here] end

				break;
			case "stockTransactionPerDateTypesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Stock Transaction Per Date Types here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Stock Transaction Per Date Types here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockTransactionPerDateTypes.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Stock Transaction Per Date Types here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Stock Transaction Per Date Types here] end

				break;
			case "stockTransactionPerDatesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Stock Transaction Per Dates here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Stock Transaction Per Dates here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockTransactionPerDates.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Stock Transaction Per Dates here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Stock Transaction Per Dates here] end

				break;
			case "vaccinationOrderDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Vaccination Order Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Vaccination Order Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.vaccinationOrderDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Vaccination Order Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Vaccination Order Details here] end

				break;
			case "warehouseInitialStockSId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Warehouse Initial Stock s here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Warehouse Initial Stock s here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.warehouseInitialStockS.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Warehouse Initial Stock s here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Warehouse Initial Stock s here] end

				break;
			case "warehouseInventoriesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Warehouse Inventories here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Warehouse Inventories here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.warehouseInventories.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Warehouse Inventories here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Warehouse Inventories here] end

				break;
			case "warehouseNumber":
				// % protected region % [Add any additional logic before the query parameters of warehouseNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of warehouseNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.warehouseNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of warehouseNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of warehouseNumber here] end

				break;
			case "warehouseName":
				// % protected region % [Add any additional logic before the query parameters of warehouseName here] off begin
				// % protected region % [Add any additional logic before the query parameters of warehouseName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.warehouseName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of warehouseName here] off begin
				// % protected region % [Add any additional logic after the query parameters of warehouseName here] end

				break;
			// % protected region % [Add any additional cases for the custom query parameters here] off begin
			// % protected region % [Add any additional cases for the custom query parameters here] end
		}

		// % protected region % [Add any additional logic for processCondition after the main logic here] off begin
		// % protected region % [Add any additional logic for processCondition after the main logic here] end

		return predicate;
	}

	/**
	 * Create the predicate for the querydsl based on one single List of Where
	 * The List are connect with 'and' statement
	 *
	 * @param conditions Single list of where statement. The conditions are connected with "or"
	 * @return querydsl predicate
	 */
	protected Predicate processConditionList(List<Where> conditions)
	// % protected region % [Add any throwables, implementations, or extensions for processConditionList here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for processConditionList here] end
	{
		List<Predicate> predicates = conditions.stream()
				.map(this::processCondition)
				.filter(Objects::nonNull)
				.collect(Collectors.toList());

		return ExpressionUtils.anyOf(predicates);
	}

	/**
	 * Transfer a list of conditions to one querydsl predicate
	 *
	 * @param conditions A list of conditions
	 * @return a single query dsl predicate
	 */
	@Override
	protected Predicate getQueryConditions(List<List<Where>> conditions)
	// % protected region % [Add any throwables, implementations, or extensions for getQueryConditions here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getQueryConditions here] end
	{
		// % protected region % [Add any additional logic for getQueryConditions before the main logic here] off begin
		// % protected region % [Add any additional logic for getQueryConditions before the main logic here] end

		List<Predicate> predicates = conditions.stream()
				.map(this::processConditionList)
				.filter(Objects::nonNull)
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic for getQueryConditions after the main logic here] off begin
		// % protected region % [Add any additional logic for getQueryConditions after the main logic here] end
		return ExpressionUtils.allOf(predicates);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WarehouseEntity updateOldData(WarehouseEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public WarehouseEntity updateOldData(WarehouseEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		WarehouseEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInWarehouseEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Outgoing one to many reference
		if (entity.getBatchStockBalancesWarehouseIds().isEmpty() && entity.getBatchStockBalancesWarehouse().isEmpty()) {
			entityToUpdate.setBatchStockBalancesWarehouse(new HashSet<>());
		} else if (!entity.getBatchStockBalancesWarehouseIds().isEmpty() && entity.getBatchStockBalancesWarehouse().isEmpty()) {
			Iterable<BatchStockBalanceEntity> batchStockBalancesWarehouseEntities =
					this.batchStockBalanceRepository.findAllById(entity.getBatchStockBalancesWarehouseIds());
			entityToUpdate.setBatchStockBalancesWarehouse(Sets.newHashSet(batchStockBalancesWarehouseEntities));
		}
		if (persistRelations && !entity.getBatchStockBalancesWarehouse().isEmpty()) {
			Set<BatchStockBalanceEntity> updatedEntities = new HashSet<>();
			entity.getBatchStockBalancesWarehouse().forEach(model -> {
				if (model.getId() != null) {
					model = this.batchStockBalanceRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBatchStockBalancesWarehouse(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getBatchStockBalancesIds().isEmpty() && entity.getBatchStockBalances().isEmpty()) {
			entityToUpdate.setBatchStockBalances(new HashSet<>());
		} else if (!entity.getBatchStockBalancesIds().isEmpty() && entity.getBatchStockBalances().isEmpty()) {
			Iterable<BatchStockBalancePerDateEntity> batchStockBalancesEntities =
					this.batchStockBalancePerDateRepository.findAllById(entity.getBatchStockBalancesIds());
			entityToUpdate.setBatchStockBalances(Sets.newHashSet(batchStockBalancesEntities));
		}
		if (persistRelations && !entity.getBatchStockBalances().isEmpty()) {
			Set<BatchStockBalancePerDateEntity> updatedEntities = new HashSet<>();
			entity.getBatchStockBalances().forEach(model -> {
				if (model.getId() != null) {
					model = this.batchStockBalancePerDateRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBatchStockBalances(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getBatchStockTransactionDetailsIds().isEmpty() && entity.getBatchStockTransactionDetails().isEmpty()) {
			entityToUpdate.setBatchStockTransactionDetails(new HashSet<>());
		} else if (!entity.getBatchStockTransactionDetailsIds().isEmpty() && entity.getBatchStockTransactionDetails().isEmpty()) {
			Iterable<BatchStockTransactionDetailEntity> batchStockTransactionDetailsEntities =
					this.batchStockTransactionDetailRepository.findAllById(entity.getBatchStockTransactionDetailsIds());
			entityToUpdate.setBatchStockTransactionDetails(Sets.newHashSet(batchStockTransactionDetailsEntities));
		}
		if (persistRelations && !entity.getBatchStockTransactionDetails().isEmpty()) {
			Set<BatchStockTransactionDetailEntity> updatedEntities = new HashSet<>();
			entity.getBatchStockTransactionDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.batchStockTransactionDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBatchStockTransactionDetails(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getDestinationWarehousesIds().isEmpty() && entity.getDestinationWarehouses().isEmpty()) {
			entityToUpdate.setDestinationWarehouses(new HashSet<>());
		} else if (!entity.getDestinationWarehousesIds().isEmpty() && entity.getDestinationWarehouses().isEmpty()) {
			Iterable<TransferOrderEntity> destinationWarehousesEntities =
					this.transferOrderRepository.findAllById(entity.getDestinationWarehousesIds());
			entityToUpdate.setDestinationWarehouses(Sets.newHashSet(destinationWarehousesEntities));
		}
		if (persistRelations && !entity.getDestinationWarehouses().isEmpty()) {
			Set<TransferOrderEntity> updatedEntities = new HashSet<>();
			entity.getDestinationWarehouses().forEach(model -> {
				if (model.getId() != null) {
					model = this.transferOrderRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDestinationWarehouses(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getGoodsReceiveNoteBatchsIds().isEmpty() && entity.getGoodsReceiveNoteBatchs().isEmpty()) {
			entityToUpdate.setGoodsReceiveNoteBatchs(new HashSet<>());
		} else if (!entity.getGoodsReceiveNoteBatchsIds().isEmpty() && entity.getGoodsReceiveNoteBatchs().isEmpty()) {
			Iterable<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchsEntities =
					this.goodsReceiveNoteBatchRepository.findAllById(entity.getGoodsReceiveNoteBatchsIds());
			entityToUpdate.setGoodsReceiveNoteBatchs(Sets.newHashSet(goodsReceiveNoteBatchsEntities));
		}
		if (persistRelations && !entity.getGoodsReceiveNoteBatchs().isEmpty()) {
			Set<GoodsReceiveNoteBatchEntity> updatedEntities = new HashSet<>();
			entity.getGoodsReceiveNoteBatchs().forEach(model -> {
				if (model.getId() != null) {
					model = this.goodsReceiveNoteBatchRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setGoodsReceiveNoteBatchs(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getGoodsReceiveNotesIds().isEmpty() && entity.getGoodsReceiveNotes().isEmpty()) {
			entityToUpdate.setGoodsReceiveNotes(new HashSet<>());
		} else if (!entity.getGoodsReceiveNotesIds().isEmpty() && entity.getGoodsReceiveNotes().isEmpty()) {
			Iterable<GoodsReceiveNoteEntity> goodsReceiveNotesEntities =
					this.goodsReceiveNoteRepository.findAllById(entity.getGoodsReceiveNotesIds());
			entityToUpdate.setGoodsReceiveNotes(Sets.newHashSet(goodsReceiveNotesEntities));
		}
		if (persistRelations && !entity.getGoodsReceiveNotes().isEmpty()) {
			Set<GoodsReceiveNoteEntity> updatedEntities = new HashSet<>();
			entity.getGoodsReceiveNotes().forEach(model -> {
				if (model.getId() != null) {
					model = this.goodsReceiveNoteRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setGoodsReceiveNotes(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getInternalOrdersIds().isEmpty() && entity.getInternalOrders().isEmpty()) {
			entityToUpdate.setInternalOrders(new HashSet<>());
		} else if (!entity.getInternalOrdersIds().isEmpty() && entity.getInternalOrders().isEmpty()) {
			Iterable<InternalOrderEntity> internalOrdersEntities =
					this.internalOrderRepository.findAllById(entity.getInternalOrdersIds());
			entityToUpdate.setInternalOrders(Sets.newHashSet(internalOrdersEntities));
		}
		if (persistRelations && !entity.getInternalOrders().isEmpty()) {
			Set<InternalOrderEntity> updatedEntities = new HashSet<>();
			entity.getInternalOrders().forEach(model -> {
				if (model.getId() != null) {
					model = this.internalOrderRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInternalOrders(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getInventoryAdjusmentBatchsIds().isEmpty() && entity.getInventoryAdjusmentBatchs().isEmpty()) {
			entityToUpdate.setInventoryAdjusmentBatchs(new HashSet<>());
		} else if (!entity.getInventoryAdjusmentBatchsIds().isEmpty() && entity.getInventoryAdjusmentBatchs().isEmpty()) {
			Iterable<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchsEntities =
					this.inventoryAdjusmentBatchRepository.findAllById(entity.getInventoryAdjusmentBatchsIds());
			entityToUpdate.setInventoryAdjusmentBatchs(Sets.newHashSet(inventoryAdjusmentBatchsEntities));
		}
		if (persistRelations && !entity.getInventoryAdjusmentBatchs().isEmpty()) {
			Set<InventoryAdjusmentBatchEntity> updatedEntities = new HashSet<>();
			entity.getInventoryAdjusmentBatchs().forEach(model -> {
				if (model.getId() != null) {
					model = this.inventoryAdjusmentBatchRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInventoryAdjusmentBatchs(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getInventoryAdjustmentsIds().isEmpty() && entity.getInventoryAdjustments().isEmpty()) {
			entityToUpdate.setInventoryAdjustments(new HashSet<>());
		} else if (!entity.getInventoryAdjustmentsIds().isEmpty() && entity.getInventoryAdjustments().isEmpty()) {
			Iterable<InventoryAdjustmentEntity> inventoryAdjustmentsEntities =
					this.inventoryAdjustmentRepository.findAllById(entity.getInventoryAdjustmentsIds());
			entityToUpdate.setInventoryAdjustments(Sets.newHashSet(inventoryAdjustmentsEntities));
		}
		if (persistRelations && !entity.getInventoryAdjustments().isEmpty()) {
			Set<InventoryAdjustmentEntity> updatedEntities = new HashSet<>();
			entity.getInventoryAdjustments().forEach(model -> {
				if (model.getId() != null) {
					model = this.inventoryAdjustmentRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInventoryAdjustments(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getInventoryBatchCorrectionsIds().isEmpty() && entity.getInventoryBatchCorrections().isEmpty()) {
			entityToUpdate.setInventoryBatchCorrections(new HashSet<>());
		} else if (!entity.getInventoryBatchCorrectionsIds().isEmpty() && entity.getInventoryBatchCorrections().isEmpty()) {
			Iterable<InventoryBatchCorrectionEntity> inventoryBatchCorrectionsEntities =
					this.inventoryBatchCorrectionRepository.findAllById(entity.getInventoryBatchCorrectionsIds());
			entityToUpdate.setInventoryBatchCorrections(Sets.newHashSet(inventoryBatchCorrectionsEntities));
		}
		if (persistRelations && !entity.getInventoryBatchCorrections().isEmpty()) {
			Set<InventoryBatchCorrectionEntity> updatedEntities = new HashSet<>();
			entity.getInventoryBatchCorrections().forEach(model -> {
				if (model.getId() != null) {
					model = this.inventoryBatchCorrectionRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInventoryBatchCorrections(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getLocationsIds().isEmpty() && entity.getLocations().isEmpty()) {
			entityToUpdate.setLocations(new HashSet<>());
		} else if (!entity.getLocationsIds().isEmpty() && entity.getLocations().isEmpty()) {
			Iterable<LocationEntity> locationsEntities =
					this.locationRepository.findAllById(entity.getLocationsIds());
			entityToUpdate.setLocations(Sets.newHashSet(locationsEntities));
		}
		if (persistRelations && !entity.getLocations().isEmpty()) {
			Set<LocationEntity> updatedEntities = new HashSet<>();
			entity.getLocations().forEach(model -> {
				if (model.getId() != null) {
					model = this.locationRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setLocations(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicalFeesIds().isEmpty() && entity.getMedicalFees().isEmpty()) {
			entityToUpdate.setMedicalFees(new HashSet<>());
		} else if (!entity.getMedicalFeesIds().isEmpty() && entity.getMedicalFees().isEmpty()) {
			Iterable<MedicalFeeEntity> medicalFeesEntities =
					this.medicalFeeRepository.findAllById(entity.getMedicalFeesIds());
			entityToUpdate.setMedicalFees(Sets.newHashSet(medicalFeesEntities));
		}
		if (persistRelations && !entity.getMedicalFees().isEmpty()) {
			Set<MedicalFeeEntity> updatedEntities = new HashSet<>();
			entity.getMedicalFees().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicalFeeRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicalFees(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicationHeadersIds().isEmpty() && entity.getMedicationHeaders().isEmpty()) {
			entityToUpdate.setMedicationHeaders(new HashSet<>());
		} else if (!entity.getMedicationHeadersIds().isEmpty() && entity.getMedicationHeaders().isEmpty()) {
			Iterable<MedicationHeaderEntity> medicationHeadersEntities =
					this.medicationHeaderRepository.findAllById(entity.getMedicationHeadersIds());
			entityToUpdate.setMedicationHeaders(Sets.newHashSet(medicationHeadersEntities));
		}
		if (persistRelations && !entity.getMedicationHeaders().isEmpty()) {
			Set<MedicationHeaderEntity> updatedEntities = new HashSet<>();
			entity.getMedicationHeaders().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicationHeaderRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicationHeaders(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPrescriptionHeadersIds().isEmpty() && entity.getPrescriptionHeaders().isEmpty()) {
			entityToUpdate.setPrescriptionHeaders(new HashSet<>());
		} else if (!entity.getPrescriptionHeadersIds().isEmpty() && entity.getPrescriptionHeaders().isEmpty()) {
			Iterable<PrescriptionHeaderEntity> prescriptionHeadersEntities =
					this.prescriptionHeaderRepository.findAllById(entity.getPrescriptionHeadersIds());
			entityToUpdate.setPrescriptionHeaders(Sets.newHashSet(prescriptionHeadersEntities));
		}
		if (persistRelations && !entity.getPrescriptionHeaders().isEmpty()) {
			Set<PrescriptionHeaderEntity> updatedEntities = new HashSet<>();
			entity.getPrescriptionHeaders().forEach(model -> {
				if (model.getId() != null) {
					model = this.prescriptionHeaderRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPrescriptionHeaders(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPurchaseOrdersIds().isEmpty() && entity.getPurchaseOrders().isEmpty()) {
			entityToUpdate.setPurchaseOrders(new HashSet<>());
		} else if (!entity.getPurchaseOrdersIds().isEmpty() && entity.getPurchaseOrders().isEmpty()) {
			Iterable<PurchaseOrderEntity> purchaseOrdersEntities =
					this.purchaseOrderRepository.findAllById(entity.getPurchaseOrdersIds());
			entityToUpdate.setPurchaseOrders(Sets.newHashSet(purchaseOrdersEntities));
		}
		if (persistRelations && !entity.getPurchaseOrders().isEmpty()) {
			Set<PurchaseOrderEntity> updatedEntities = new HashSet<>();
			entity.getPurchaseOrders().forEach(model -> {
				if (model.getId() != null) {
					model = this.purchaseOrderRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPurchaseOrders(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPurchaseRequisitionsIds().isEmpty() && entity.getPurchaseRequisitions().isEmpty()) {
			entityToUpdate.setPurchaseRequisitions(new HashSet<>());
		} else if (!entity.getPurchaseRequisitionsIds().isEmpty() && entity.getPurchaseRequisitions().isEmpty()) {
			Iterable<PurchaseRequisitionEntity> purchaseRequisitionsEntities =
					this.purchaseRequisitionRepository.findAllById(entity.getPurchaseRequisitionsIds());
			entityToUpdate.setPurchaseRequisitions(Sets.newHashSet(purchaseRequisitionsEntities));
		}
		if (persistRelations && !entity.getPurchaseRequisitions().isEmpty()) {
			Set<PurchaseRequisitionEntity> updatedEntities = new HashSet<>();
			entity.getPurchaseRequisitions().forEach(model -> {
				if (model.getId() != null) {
					model = this.purchaseRequisitionRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPurchaseRequisitions(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getRetailPharmaciesIds().isEmpty() && entity.getRetailPharmacies().isEmpty()) {
			entityToUpdate.setRetailPharmacies(new HashSet<>());
		} else if (!entity.getRetailPharmaciesIds().isEmpty() && entity.getRetailPharmacies().isEmpty()) {
			Iterable<RetailPharmacyEntity> retailPharmaciesEntities =
					this.retailPharmacyRepository.findAllById(entity.getRetailPharmaciesIds());
			entityToUpdate.setRetailPharmacies(Sets.newHashSet(retailPharmaciesEntities));
		}
		if (persistRelations && !entity.getRetailPharmacies().isEmpty()) {
			Set<RetailPharmacyEntity> updatedEntities = new HashSet<>();
			entity.getRetailPharmacies().forEach(model -> {
				if (model.getId() != null) {
					model = this.retailPharmacyRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setRetailPharmacies(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getReturnSuppliersIds().isEmpty() && entity.getReturnSuppliers().isEmpty()) {
			entityToUpdate.setReturnSuppliers(new HashSet<>());
		} else if (!entity.getReturnSuppliersIds().isEmpty() && entity.getReturnSuppliers().isEmpty()) {
			Iterable<ReturnSupplierEntity> returnSuppliersEntities =
					this.returnSupplierRepository.findAllById(entity.getReturnSuppliersIds());
			entityToUpdate.setReturnSuppliers(Sets.newHashSet(returnSuppliersEntities));
		}
		if (persistRelations && !entity.getReturnSuppliers().isEmpty()) {
			Set<ReturnSupplierEntity> updatedEntities = new HashSet<>();
			entity.getReturnSuppliers().forEach(model -> {
				if (model.getId() != null) {
					model = this.returnSupplierRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setReturnSuppliers(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getSourceWarehousesIds().isEmpty() && entity.getSourceWarehouses().isEmpty()) {
			entityToUpdate.setSourceWarehouses(new HashSet<>());
		} else if (!entity.getSourceWarehousesIds().isEmpty() && entity.getSourceWarehouses().isEmpty()) {
			Iterable<TransferOrderEntity> sourceWarehousesEntities =
					this.transferOrderRepository.findAllById(entity.getSourceWarehousesIds());
			entityToUpdate.setSourceWarehouses(Sets.newHashSet(sourceWarehousesEntities));
		}
		if (persistRelations && !entity.getSourceWarehouses().isEmpty()) {
			Set<TransferOrderEntity> updatedEntities = new HashSet<>();
			entity.getSourceWarehouses().forEach(model -> {
				if (model.getId() != null) {
					model = this.transferOrderRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setSourceWarehouses(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getStockCataloguesIds().isEmpty() && entity.getStockCatalogues().isEmpty()) {
			entityToUpdate.setStockCatalogues(new HashSet<>());
		} else if (!entity.getStockCataloguesIds().isEmpty() && entity.getStockCatalogues().isEmpty()) {
			Iterable<StockCatalogueEntity> stockCataloguesEntities =
					this.stockCatalogueRepository.findAllById(entity.getStockCataloguesIds());
			entityToUpdate.setStockCatalogues(Sets.newHashSet(stockCataloguesEntities));
		}
		if (persistRelations && !entity.getStockCatalogues().isEmpty()) {
			Set<StockCatalogueEntity> updatedEntities = new HashSet<>();
			entity.getStockCatalogues().forEach(model -> {
				if (model.getId() != null) {
					model = this.stockCatalogueRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setStockCatalogues(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getStockControlsIds().isEmpty() && entity.getStockControls().isEmpty()) {
			entityToUpdate.setStockControls(new HashSet<>());
		} else if (!entity.getStockControlsIds().isEmpty() && entity.getStockControls().isEmpty()) {
			Iterable<StockControlEntity> stockControlsEntities =
					this.stockControlRepository.findAllById(entity.getStockControlsIds());
			entityToUpdate.setStockControls(Sets.newHashSet(stockControlsEntities));
		}
		if (persistRelations && !entity.getStockControls().isEmpty()) {
			Set<StockControlEntity> updatedEntities = new HashSet<>();
			entity.getStockControls().forEach(model -> {
				if (model.getId() != null) {
					model = this.stockControlRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setStockControls(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getStockTransactionDetailsIds().isEmpty() && entity.getStockTransactionDetails().isEmpty()) {
			entityToUpdate.setStockTransactionDetails(new HashSet<>());
		} else if (!entity.getStockTransactionDetailsIds().isEmpty() && entity.getStockTransactionDetails().isEmpty()) {
			Iterable<StockTransactionDetailEntity> stockTransactionDetailsEntities =
					this.stockTransactionDetailRepository.findAllById(entity.getStockTransactionDetailsIds());
			entityToUpdate.setStockTransactionDetails(Sets.newHashSet(stockTransactionDetailsEntities));
		}
		if (persistRelations && !entity.getStockTransactionDetails().isEmpty()) {
			Set<StockTransactionDetailEntity> updatedEntities = new HashSet<>();
			entity.getStockTransactionDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.stockTransactionDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setStockTransactionDetails(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getStockTransactionPerDateTypesIds().isEmpty() && entity.getStockTransactionPerDateTypes().isEmpty()) {
			entityToUpdate.setStockTransactionPerDateTypes(new HashSet<>());
		} else if (!entity.getStockTransactionPerDateTypesIds().isEmpty() && entity.getStockTransactionPerDateTypes().isEmpty()) {
			Iterable<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypesEntities =
					this.stockTransactionPerDateTypeRepository.findAllById(entity.getStockTransactionPerDateTypesIds());
			entityToUpdate.setStockTransactionPerDateTypes(Sets.newHashSet(stockTransactionPerDateTypesEntities));
		}
		if (persistRelations && !entity.getStockTransactionPerDateTypes().isEmpty()) {
			Set<StockTransactionPerDateTypeEntity> updatedEntities = new HashSet<>();
			entity.getStockTransactionPerDateTypes().forEach(model -> {
				if (model.getId() != null) {
					model = this.stockTransactionPerDateTypeRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setStockTransactionPerDateTypes(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getStockTransactionPerDatesIds().isEmpty() && entity.getStockTransactionPerDates().isEmpty()) {
			entityToUpdate.setStockTransactionPerDates(new HashSet<>());
		} else if (!entity.getStockTransactionPerDatesIds().isEmpty() && entity.getStockTransactionPerDates().isEmpty()) {
			Iterable<StockTransactionPerDateEntity> stockTransactionPerDatesEntities =
					this.stockTransactionPerDateRepository.findAllById(entity.getStockTransactionPerDatesIds());
			entityToUpdate.setStockTransactionPerDates(Sets.newHashSet(stockTransactionPerDatesEntities));
		}
		if (persistRelations && !entity.getStockTransactionPerDates().isEmpty()) {
			Set<StockTransactionPerDateEntity> updatedEntities = new HashSet<>();
			entity.getStockTransactionPerDates().forEach(model -> {
				if (model.getId() != null) {
					model = this.stockTransactionPerDateRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setStockTransactionPerDates(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getVaccinationOrderDetailsIds().isEmpty() && entity.getVaccinationOrderDetails().isEmpty()) {
			entityToUpdate.setVaccinationOrderDetails(new HashSet<>());
		} else if (!entity.getVaccinationOrderDetailsIds().isEmpty() && entity.getVaccinationOrderDetails().isEmpty()) {
			Iterable<VaccinationOrderDetailEntity> vaccinationOrderDetailsEntities =
					this.vaccinationOrderDetailRepository.findAllById(entity.getVaccinationOrderDetailsIds());
			entityToUpdate.setVaccinationOrderDetails(Sets.newHashSet(vaccinationOrderDetailsEntities));
		}
		if (persistRelations && !entity.getVaccinationOrderDetails().isEmpty()) {
			Set<VaccinationOrderDetailEntity> updatedEntities = new HashSet<>();
			entity.getVaccinationOrderDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.vaccinationOrderDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setVaccinationOrderDetails(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getWarehouseInitialStockSIds().isEmpty() && entity.getWarehouseInitialStockS().isEmpty()) {
			entityToUpdate.setWarehouseInitialStockS(new HashSet<>());
		} else if (!entity.getWarehouseInitialStockSIds().isEmpty() && entity.getWarehouseInitialStockS().isEmpty()) {
			Iterable<WarehouseInitialStockEntity> warehouseInitialStockSEntities =
					this.warehouseInitialStockRepository.findAllById(entity.getWarehouseInitialStockSIds());
			entityToUpdate.setWarehouseInitialStockS(Sets.newHashSet(warehouseInitialStockSEntities));
		}
		if (persistRelations && !entity.getWarehouseInitialStockS().isEmpty()) {
			Set<WarehouseInitialStockEntity> updatedEntities = new HashSet<>();
			entity.getWarehouseInitialStockS().forEach(model -> {
				if (model.getId() != null) {
					model = this.warehouseInitialStockRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setWarehouseInitialStockS(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getWarehouseInventoriesIds().isEmpty() && entity.getWarehouseInventories().isEmpty()) {
			entityToUpdate.setWarehouseInventories(new HashSet<>());
		} else if (!entity.getWarehouseInventoriesIds().isEmpty() && entity.getWarehouseInventories().isEmpty()) {
			Iterable<WarehouseInventoryEntity> warehouseInventoriesEntities =
					this.warehouseInventoryRepository.findAllById(entity.getWarehouseInventoriesIds());
			entityToUpdate.setWarehouseInventories(Sets.newHashSet(warehouseInventoriesEntities));
		}
		if (persistRelations && !entity.getWarehouseInventories().isEmpty()) {
			Set<WarehouseInventoryEntity> updatedEntities = new HashSet<>();
			entity.getWarehouseInventories().forEach(model -> {
				if (model.getId() != null) {
					model = this.warehouseInventoryRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setWarehouseInventories(updatedEntities);
		}

		// % protected region % [Add any additional logic for update references after the main logic here] off begin
		// % protected region % [Add any additional logic for update references after the main logic here] end

		return entityToUpdate;
	}

	/**
	 * Validate the entity using database constraint checks as well as input constraint checks.
	 * Has the side effect of round trip requests to the database for constraints such as uniqueness.
	 * @param entity The entity to validate
	 * @throws ConstraintViolationException Throw ConstraintViolationException when entity is invalid
	 */
	public void validateEntity(WarehouseEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<WarehouseEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByWarehouseNumberOpt = this.findByWarehouseNumber(entity.getWarehouseNumber());
			if (entityByWarehouseNumberOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<WarehouseEntity>(
						"Warehouse Number",
						entity.getWarehouseNumber(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"WarehouseNumber"
				);
				errors.add(uniquenessViolation);
			}
		}
		// % protected region % [Add custom validation errors here] off begin
		// % protected region % [Add custom validation errors here] end

		if (!errors.isEmpty()) {
			throw new ConstraintViolationException(errors);
		}

		// % protected region % [Add any additional logic for validate entity after the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity after the main logic here] end
	}


	/**
	 * Get the sort as given by the sort by for the WarehouseEntity.
	 * This allows fore more advanced sorting algorithms and methods to be compiled and returned.
	 *
	 * In the case that a custom sort is provided, only a single sort is returned.
	 *
	 * @param sortBy Submitted sort by
	 * @return sortBy if simple, for custom sort return a QSort.by(QSort Method).
	 */
	private Sort getSort (Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for getSort here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getSort here] end
	{
		Iterator it = sortBy.iterator();

		while (it.hasNext()) {
			Sort.Order currentOrder = (Sort.Order)it.next();

			// % protected region % [Customise your sort method here by returning early] off begin
			// % protected region % [Customise your sort method here by returning early] end
		}
		return sortBy;
	}

	public Set<String> validateEntityRelations(WarehouseEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		for (UUID id : entity.getBatchStockBalancesWarehouseIds()) {
			if (this.batchStockBalanceRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Batch Stock Balance Entity");
			}
		}

		for (UUID id : entity.getBatchStockBalancesIds()) {
			if (this.batchStockBalancePerDateRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Batch Stock Balance Per Date Entity");
			}
		}

		for (UUID id : entity.getBatchStockTransactionDetailsIds()) {
			if (this.batchStockTransactionDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Batch Stock Transaction Detail Entity");
			}
		}

		for (UUID id : entity.getDestinationWarehousesIds()) {
			if (this.transferOrderRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Transfer Order Entity");
			}
		}

		for (UUID id : entity.getGoodsReceiveNoteBatchsIds()) {
			if (this.goodsReceiveNoteBatchRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Goods Receive Note Batch Entity");
			}
		}

		for (UUID id : entity.getGoodsReceiveNotesIds()) {
			if (this.goodsReceiveNoteRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Goods Receive Note Entity");
			}
		}

		for (UUID id : entity.getInternalOrdersIds()) {
			if (this.internalOrderRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Internal Order Entity");
			}
		}

		for (UUID id : entity.getInventoryAdjusmentBatchsIds()) {
			if (this.inventoryAdjusmentBatchRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Inventory Adjusment Batch Entity");
			}
		}

		for (UUID id : entity.getInventoryAdjustmentsIds()) {
			if (this.inventoryAdjustmentRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Inventory Adjustment Entity");
			}
		}

		for (UUID id : entity.getInventoryBatchCorrectionsIds()) {
			if (this.inventoryBatchCorrectionRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Inventory Batch Correction Entity");
			}
		}

		for (UUID id : entity.getLocationsIds()) {
			if (this.locationRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Location Entity");
			}
		}

		for (UUID id : entity.getMedicalFeesIds()) {
			if (this.medicalFeeRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medical Fee Entity");
			}
		}

		for (UUID id : entity.getMedicationHeadersIds()) {
			if (this.medicationHeaderRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medication Header Entity");
			}
		}

		for (UUID id : entity.getPrescriptionHeadersIds()) {
			if (this.prescriptionHeaderRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Prescription Header Entity");
			}
		}

		for (UUID id : entity.getPurchaseOrdersIds()) {
			if (this.purchaseOrderRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Purchase Order Entity");
			}
		}

		for (UUID id : entity.getPurchaseRequisitionsIds()) {
			if (this.purchaseRequisitionRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Purchase Requisition Entity");
			}
		}

		for (UUID id : entity.getRetailPharmaciesIds()) {
			if (this.retailPharmacyRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Retail Pharmacy Entity");
			}
		}

		for (UUID id : entity.getReturnSuppliersIds()) {
			if (this.returnSupplierRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Return Supplier Entity");
			}
		}

		for (UUID id : entity.getSourceWarehousesIds()) {
			if (this.transferOrderRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Transfer Order Entity");
			}
		}

		for (UUID id : entity.getStockCataloguesIds()) {
			if (this.stockCatalogueRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Stock Catalogue Entity");
			}
		}

		for (UUID id : entity.getStockControlsIds()) {
			if (this.stockControlRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Stock Control Entity");
			}
		}

		for (UUID id : entity.getStockTransactionDetailsIds()) {
			if (this.stockTransactionDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Stock Transaction Detail Entity");
			}
		}

		for (UUID id : entity.getStockTransactionPerDateTypesIds()) {
			if (this.stockTransactionPerDateTypeRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Stock Transaction Per Date Type Entity");
			}
		}

		for (UUID id : entity.getStockTransactionPerDatesIds()) {
			if (this.stockTransactionPerDateRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Stock Transaction Per Date Entity");
			}
		}

		for (UUID id : entity.getVaccinationOrderDetailsIds()) {
			if (this.vaccinationOrderDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Vaccination Order Detail Entity");
			}
		}

		for (UUID id : entity.getWarehouseInitialStockSIds()) {
			if (this.warehouseInitialStockRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Warehouse Initial Stock  Entity");
			}
		}

		for (UUID id : entity.getWarehouseInventoriesIds()) {
			if (this.warehouseInventoryRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Warehouse Inventory Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
