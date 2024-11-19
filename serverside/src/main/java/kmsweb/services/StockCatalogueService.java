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
import kmsweb.repositories.StockCatalogueRepository;
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
import java.time.*;
import kmsweb.entities.BpjsDrugGenericPRBEntity;
import kmsweb.repositories.BpjsDrugGenericPRBRepository;
import kmsweb.entities.BpjsPcareDPHOEntity;
import kmsweb.repositories.BpjsPcareDPHORepository;
import kmsweb.entities.BatchStockBalanceEntity;
import kmsweb.repositories.BatchStockBalanceRepository;
import kmsweb.entities.BatchStockBalancePerDateEntity;
import kmsweb.repositories.BatchStockBalancePerDateRepository;
import kmsweb.entities.BatchStockTransactionDetailEntity;
import kmsweb.repositories.BatchStockTransactionDetailRepository;
import kmsweb.entities.CatalogueMedicalEntity;
import kmsweb.repositories.CatalogueMedicalRepository;
import kmsweb.entities.CatalogueNonMedicalEntity;
import kmsweb.repositories.CatalogueNonMedicalRepository;
import kmsweb.entities.CatalogueUOMEntity;
import kmsweb.repositories.CatalogueUOMRepository;
import kmsweb.entities.CompoundPrescriptionItemEntity;
import kmsweb.repositories.CompoundPrescriptionItemRepository;
import kmsweb.entities.GoodsReceiveNoteBatchEntity;
import kmsweb.repositories.GoodsReceiveNoteBatchRepository;
import kmsweb.entities.GoodsReceiveNoteItemEntity;
import kmsweb.repositories.GoodsReceiveNoteItemRepository;
import kmsweb.entities.InternalOrderStockDetailEntity;
import kmsweb.repositories.InternalOrderStockDetailRepository;
import kmsweb.entities.InventoryAdjusmentBatchEntity;
import kmsweb.repositories.InventoryAdjusmentBatchRepository;
import kmsweb.entities.InventoryAdjustmentItemEntity;
import kmsweb.repositories.InventoryAdjustmentItemRepository;
import kmsweb.entities.InventoryBatchCorrectionItemEntity;
import kmsweb.repositories.InventoryBatchCorrectionItemRepository;
import kmsweb.entities.MedicationItemEntity;
import kmsweb.repositories.MedicationItemRepository;
import kmsweb.entities.PrescriptionItemEntity;
import kmsweb.repositories.PrescriptionItemRepository;
import kmsweb.entities.PurchaseOrderStockDetailEntity;
import kmsweb.repositories.PurchaseOrderStockDetailRepository;
import kmsweb.entities.PurchaseRequisitionStockDetailEntity;
import kmsweb.repositories.PurchaseRequisitionStockDetailRepository;
import kmsweb.entities.RetailPharmacyStockDetailEntity;
import kmsweb.repositories.RetailPharmacyStockDetailRepository;
import kmsweb.entities.ReturnSupplierStockDetailEntity;
import kmsweb.repositories.ReturnSupplierStockDetailRepository;
import kmsweb.entities.StockControlEntity;
import kmsweb.repositories.StockControlRepository;
import kmsweb.entities.StockTransactionDetailEntity;
import kmsweb.repositories.StockTransactionDetailRepository;
import kmsweb.entities.StockTransactionPerDateEntity;
import kmsweb.repositories.StockTransactionPerDateRepository;
import kmsweb.entities.StockTransactionPerDateTypeEntity;
import kmsweb.repositories.StockTransactionPerDateTypeRepository;
import kmsweb.entities.SupplierProductDetailEntity;
import kmsweb.repositories.SupplierProductDetailRepository;
import kmsweb.entities.TransferOrderStockDetailEntity;
import kmsweb.repositories.TransferOrderStockDetailRepository;
import kmsweb.entities.VaccinationOrderDetailEntity;
import kmsweb.repositories.VaccinationOrderDetailRepository;
import kmsweb.entities.WarehouseEntity;
import kmsweb.repositories.WarehouseRepository;
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
public class StockCatalogueService extends AbstractService<StockCatalogueEntity, StockCatalogueRepository, StockCatalogueEntityAudit> {

	private final String[] referenceNamesInStockCatalogueEntity = {
		"batchStockBalancesCatalogue",
		"batchStockBalances",
		"batchStockTransactionDetails",
		"catalogueUOMs",
		"compoundPrescriptionItems",
		"goodsReceiveNoteBatchs",
		"goodsReceiveNoteItems",
		"internalOrderStockDetails",
		"inventoryAdjusmentBatchs",
		"inventoryAdjustmentItems",
		"inventoryBatchCorrectionItems",
		"medicationItems",
		"prescriptionItem",
		"purchaseOrderStockDetails",
		"purchaseRequisitionStockDetails",
		"retailPharmacyStockDetails",
		"returnSupplierStockDetails",
		"stockCatalogueMedical",
		"stockCatalogueNonMedical",
		"stockControls",
		"stockTransactionDetails",
		"stockTransactionPerDateTypes",
		"stockTransactionPerDates",
		"supplierProductDetails",
		"transferOrderStockDetails",
		"vaccinationOrderDetails",
		"warehouseInitialStockS",
		"warehouseInventories",
		"bpjsDrugGenericPRB",
		"bpjsPcareDPHO",
		"warehouse",
	};

	private final BpjsDrugGenericPRBRepository bpjsDrugGenericPRBRepository;

	private final BpjsPcareDPHORepository bpjsPcareDPHORepository;

	private final BatchStockBalanceRepository batchStockBalanceRepository;

	private final BatchStockBalancePerDateRepository batchStockBalancePerDateRepository;

	private final BatchStockTransactionDetailRepository batchStockTransactionDetailRepository;

	private final CatalogueMedicalRepository catalogueMedicalRepository;

	private final CatalogueNonMedicalRepository catalogueNonMedicalRepository;

	private final CatalogueUOMRepository catalogueUOMRepository;

	private final CompoundPrescriptionItemRepository compoundPrescriptionItemRepository;

	private final GoodsReceiveNoteBatchRepository goodsReceiveNoteBatchRepository;

	private final GoodsReceiveNoteItemRepository goodsReceiveNoteItemRepository;

	private final InternalOrderStockDetailRepository internalOrderStockDetailRepository;

	private final InventoryAdjusmentBatchRepository inventoryAdjusmentBatchRepository;

	private final InventoryAdjustmentItemRepository inventoryAdjustmentItemRepository;

	private final InventoryBatchCorrectionItemRepository inventoryBatchCorrectionItemRepository;

	private final MedicationItemRepository medicationItemRepository;

	private final PrescriptionItemRepository prescriptionItemRepository;

	private final PurchaseOrderStockDetailRepository purchaseOrderStockDetailRepository;

	private final PurchaseRequisitionStockDetailRepository purchaseRequisitionStockDetailRepository;

	private final RetailPharmacyStockDetailRepository retailPharmacyStockDetailRepository;

	private final ReturnSupplierStockDetailRepository returnSupplierStockDetailRepository;

	private final StockControlRepository stockControlRepository;

	private final StockTransactionDetailRepository stockTransactionDetailRepository;

	private final StockTransactionPerDateRepository stockTransactionPerDateRepository;

	private final StockTransactionPerDateTypeRepository stockTransactionPerDateTypeRepository;

	private final SupplierProductDetailRepository supplierProductDetailRepository;

	private final TransferOrderStockDetailRepository transferOrderStockDetailRepository;

	private final VaccinationOrderDetailRepository vaccinationOrderDetailRepository;

	private final WarehouseRepository warehouseRepository;

	private final WarehouseInitialStockRepository warehouseInitialStockRepository;

	private final WarehouseInventoryRepository warehouseInventoryRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public StockCatalogueService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		BpjsDrugGenericPRBRepository bpjsDrugGenericPRBRepository,
		BpjsPcareDPHORepository bpjsPcareDPHORepository,
		BatchStockBalanceRepository batchStockBalanceRepository,
		BatchStockBalancePerDateRepository batchStockBalancePerDateRepository,
		BatchStockTransactionDetailRepository batchStockTransactionDetailRepository,
		CatalogueMedicalRepository catalogueMedicalRepository,
		CatalogueNonMedicalRepository catalogueNonMedicalRepository,
		CatalogueUOMRepository catalogueUOMRepository,
		CompoundPrescriptionItemRepository compoundPrescriptionItemRepository,
		GoodsReceiveNoteBatchRepository goodsReceiveNoteBatchRepository,
		GoodsReceiveNoteItemRepository goodsReceiveNoteItemRepository,
		InternalOrderStockDetailRepository internalOrderStockDetailRepository,
		InventoryAdjusmentBatchRepository inventoryAdjusmentBatchRepository,
		InventoryAdjustmentItemRepository inventoryAdjustmentItemRepository,
		InventoryBatchCorrectionItemRepository inventoryBatchCorrectionItemRepository,
		MedicationItemRepository medicationItemRepository,
		PrescriptionItemRepository prescriptionItemRepository,
		PurchaseOrderStockDetailRepository purchaseOrderStockDetailRepository,
		PurchaseRequisitionStockDetailRepository purchaseRequisitionStockDetailRepository,
		RetailPharmacyStockDetailRepository retailPharmacyStockDetailRepository,
		ReturnSupplierStockDetailRepository returnSupplierStockDetailRepository,
		StockControlRepository stockControlRepository,
		StockTransactionDetailRepository stockTransactionDetailRepository,
		StockTransactionPerDateRepository stockTransactionPerDateRepository,
		StockTransactionPerDateTypeRepository stockTransactionPerDateTypeRepository,
		SupplierProductDetailRepository supplierProductDetailRepository,
		TransferOrderStockDetailRepository transferOrderStockDetailRepository,
		VaccinationOrderDetailRepository vaccinationOrderDetailRepository,
		WarehouseRepository warehouseRepository,
		WarehouseInitialStockRepository warehouseInitialStockRepository,
		WarehouseInventoryRepository warehouseInventoryRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		StockCatalogueRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.bpjsDrugGenericPRBRepository = bpjsDrugGenericPRBRepository;

		this.bpjsPcareDPHORepository = bpjsPcareDPHORepository;

		this.batchStockBalanceRepository = batchStockBalanceRepository;

		this.batchStockBalancePerDateRepository = batchStockBalancePerDateRepository;

		this.batchStockTransactionDetailRepository = batchStockTransactionDetailRepository;

		this.catalogueMedicalRepository = catalogueMedicalRepository;

		this.catalogueNonMedicalRepository = catalogueNonMedicalRepository;

		this.catalogueUOMRepository = catalogueUOMRepository;

		this.compoundPrescriptionItemRepository = compoundPrescriptionItemRepository;

		this.goodsReceiveNoteBatchRepository = goodsReceiveNoteBatchRepository;

		this.goodsReceiveNoteItemRepository = goodsReceiveNoteItemRepository;

		this.internalOrderStockDetailRepository = internalOrderStockDetailRepository;

		this.inventoryAdjusmentBatchRepository = inventoryAdjusmentBatchRepository;

		this.inventoryAdjustmentItemRepository = inventoryAdjustmentItemRepository;

		this.inventoryBatchCorrectionItemRepository = inventoryBatchCorrectionItemRepository;

		this.medicationItemRepository = medicationItemRepository;

		this.prescriptionItemRepository = prescriptionItemRepository;

		this.purchaseOrderStockDetailRepository = purchaseOrderStockDetailRepository;

		this.purchaseRequisitionStockDetailRepository = purchaseRequisitionStockDetailRepository;

		this.retailPharmacyStockDetailRepository = retailPharmacyStockDetailRepository;

		this.returnSupplierStockDetailRepository = returnSupplierStockDetailRepository;

		this.stockControlRepository = stockControlRepository;

		this.stockTransactionDetailRepository = stockTransactionDetailRepository;

		this.stockTransactionPerDateRepository = stockTransactionPerDateRepository;

		this.stockTransactionPerDateTypeRepository = stockTransactionPerDateTypeRepository;

		this.supplierProductDetailRepository = supplierProductDetailRepository;

		this.transferOrderStockDetailRepository = transferOrderStockDetailRepository;

		this.vaccinationOrderDetailRepository = vaccinationOrderDetailRepository;

		this.warehouseRepository = warehouseRepository;

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
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
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
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Trackable.
	 *
	 * @param trackable the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Trackable
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByTrackable(Boolean trackable)
	// % protected region % [Add any throwables, implementations, or extensions for findByTrackable here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTrackable here] end
	{
		// % protected region % [Add any additional logic for findByTrackable before the main body here] off begin
		// % protected region % [Add any additional logic for findByTrackable before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByTrackable(trackable));

		// % protected region % [Add any additional logic for findByTrackable before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTrackable before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Stock Code.
	 *
	 * @param stockCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stock Code
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<StockCatalogueEntity> findByStockCode(String stockCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByStockCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStockCode here] end
	{
		// % protected region % [Add any additional logic for findByStockCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByStockCode before the main body here] end

		Optional<StockCatalogueEntity> entity = repository.findByStockCode(stockCode);

		// % protected region % [Add any additional logic for findByStockCode before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByStockCode before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Stock Name.
	 *
	 * @param stockName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stock Name
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByStockName(String stockName)
	// % protected region % [Add any throwables, implementations, or extensions for findByStockName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStockName here] end
	{
		// % protected region % [Add any additional logic for findByStockName before the main body here] off begin
		// % protected region % [Add any additional logic for findByStockName before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByStockName(stockName));

		// % protected region % [Add any additional logic for findByStockName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStockName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Description.
	 *
	 * @param description the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Description
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByDescription(String description)
	// % protected region % [Add any throwables, implementations, or extensions for findByDescription here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDescription here] end
	{
		// % protected region % [Add any additional logic for findByDescription before the main body here] off begin
		// % protected region % [Add any additional logic for findByDescription before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByDescription(description));

		// % protected region % [Add any additional logic for findByDescription before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDescription before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight.
	 *
	 * @param weight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByWeight(Double weight)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeight here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeight here] end
	{
		// % protected region % [Add any additional logic for findByWeight before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeight before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByWeight(weight));

		// % protected region % [Add any additional logic for findByWeight before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeight before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight Unit.
	 *
	 * @param weightUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Unit
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByWeightUnit(String weightUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightUnit here] end
	{
		// % protected region % [Add any additional logic for findByWeightUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeightUnit before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByWeightUnit(weightUnit));

		// % protected region % [Add any additional logic for findByWeightUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeightUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Volume.
	 *
	 * @param volume the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Volume
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByVolume(Double volume)
	// % protected region % [Add any throwables, implementations, or extensions for findByVolume here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVolume here] end
	{
		// % protected region % [Add any additional logic for findByVolume before the main body here] off begin
		// % protected region % [Add any additional logic for findByVolume before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByVolume(volume));

		// % protected region % [Add any additional logic for findByVolume before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVolume before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Volume Unit.
	 *
	 * @param volumeUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Volume Unit
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByVolumeUnit(String volumeUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByVolumeUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVolumeUnit here] end
	{
		// % protected region % [Add any additional logic for findByVolumeUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByVolumeUnit before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByVolumeUnit(volumeUnit));

		// % protected region % [Add any additional logic for findByVolumeUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVolumeUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Stock Group.
	 *
	 * @param stockGroup the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stock Group
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByStockGroup(String stockGroup)
	// % protected region % [Add any throwables, implementations, or extensions for findByStockGroup here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStockGroup here] end
	{
		// % protected region % [Add any additional logic for findByStockGroup before the main body here] off begin
		// % protected region % [Add any additional logic for findByStockGroup before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByStockGroup(stockGroup));

		// % protected region % [Add any additional logic for findByStockGroup before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStockGroup before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Stock Category.
	 *
	 * @param stockCategory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stock Category
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByStockCategory(String stockCategory)
	// % protected region % [Add any throwables, implementations, or extensions for findByStockCategory here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStockCategory here] end
	{
		// % protected region % [Add any additional logic for findByStockCategory before the main body here] off begin
		// % protected region % [Add any additional logic for findByStockCategory before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByStockCategory(stockCategory));

		// % protected region % [Add any additional logic for findByStockCategory before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStockCategory before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Approval Status.
	 *
	 * @param approvalStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Status
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByApprovalStatus(String approvalStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalStatus here] end
	{
		// % protected region % [Add any additional logic for findByApprovalStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByApprovalStatus before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByApprovalStatus(approvalStatus));

		// % protected region % [Add any additional logic for findByApprovalStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApprovalStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Approved By.
	 *
	 * @param approvedBy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approved By
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByApprovedBy(String approvedBy)
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovedBy here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovedBy here] end
	{
		// % protected region % [Add any additional logic for findByApprovedBy before the main body here] off begin
		// % protected region % [Add any additional logic for findByApprovedBy before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByApprovedBy(approvedBy));

		// % protected region % [Add any additional logic for findByApprovedBy before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApprovedBy before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Approval Date.
	 *
	 * @param approvalDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Date
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByApprovalDate(OffsetDateTime approvalDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalDate here] end
	{
		// % protected region % [Add any additional logic for findByApprovalDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByApprovalDate before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByApprovalDate(approvalDate));

		// % protected region % [Add any additional logic for findByApprovalDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApprovalDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Approval Notes.
	 *
	 * @param approvalNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Notes
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByApprovalNotes(String approvalNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalNotes here] end
	{
		// % protected region % [Add any additional logic for findByApprovalNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByApprovalNotes before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByApprovalNotes(approvalNotes));

		// % protected region % [Add any additional logic for findByApprovalNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApprovalNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Per Pack.
	 *
	 * @param quantityPerPack the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Per Pack
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByQuantityPerPack(Integer quantityPerPack)
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityPerPack here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityPerPack here] end
	{
		// % protected region % [Add any additional logic for findByQuantityPerPack before the main body here] off begin
		// % protected region % [Add any additional logic for findByQuantityPerPack before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByQuantityPerPack(quantityPerPack));

		// % protected region % [Add any additional logic for findByQuantityPerPack before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQuantityPerPack before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute UOI.
	 *
	 * @param uoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UOI
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByUoi(String uoi)
	// % protected region % [Add any throwables, implementations, or extensions for findByUoi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUoi here] end
	{
		// % protected region % [Add any additional logic for findByUoi before the main body here] off begin
		// % protected region % [Add any additional logic for findByUoi before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByUoi(uoi));

		// % protected region % [Add any additional logic for findByUoi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUoi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Last Buying Price VAT exclude Currency.
	 *
	 * @param lastBuyingPriceVATExcludeCurrency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Buying Price VAT exclude Currency
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByLastBuyingPriceVATExcludeCurrency(String lastBuyingPriceVATExcludeCurrency)
	// % protected region % [Add any throwables, implementations, or extensions for findByLastBuyingPriceVATExcludeCurrency here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLastBuyingPriceVATExcludeCurrency here] end
	{
		// % protected region % [Add any additional logic for findByLastBuyingPriceVATExcludeCurrency before the main body here] off begin
		// % protected region % [Add any additional logic for findByLastBuyingPriceVATExcludeCurrency before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByLastBuyingPriceVATExcludeCurrency(lastBuyingPriceVATExcludeCurrency));

		// % protected region % [Add any additional logic for findByLastBuyingPriceVATExcludeCurrency before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLastBuyingPriceVATExcludeCurrency before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Last Buying Price VAT exclude Price.
	 *
	 * @param lastBuyingPriceVATExcludePrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Buying Price VAT exclude Price
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByLastBuyingPriceVATExcludePrice(Double lastBuyingPriceVATExcludePrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByLastBuyingPriceVATExcludePrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLastBuyingPriceVATExcludePrice here] end
	{
		// % protected region % [Add any additional logic for findByLastBuyingPriceVATExcludePrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByLastBuyingPriceVATExcludePrice before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByLastBuyingPriceVATExcludePrice(lastBuyingPriceVATExcludePrice));

		// % protected region % [Add any additional logic for findByLastBuyingPriceVATExcludePrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLastBuyingPriceVATExcludePrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Last Buying Price VAT include Currency.
	 *
	 * @param lastBuyingPriceVATIncludeCurrency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Buying Price VAT include Currency
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByLastBuyingPriceVATIncludeCurrency(String lastBuyingPriceVATIncludeCurrency)
	// % protected region % [Add any throwables, implementations, or extensions for findByLastBuyingPriceVATIncludeCurrency here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLastBuyingPriceVATIncludeCurrency here] end
	{
		// % protected region % [Add any additional logic for findByLastBuyingPriceVATIncludeCurrency before the main body here] off begin
		// % protected region % [Add any additional logic for findByLastBuyingPriceVATIncludeCurrency before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByLastBuyingPriceVATIncludeCurrency(lastBuyingPriceVATIncludeCurrency));

		// % protected region % [Add any additional logic for findByLastBuyingPriceVATIncludeCurrency before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLastBuyingPriceVATIncludeCurrency before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Last Buying Price VAT include Price.
	 *
	 * @param lastBuyingPriceVATIncludePrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Buying Price VAT include Price
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByLastBuyingPriceVATIncludePrice(Double lastBuyingPriceVATIncludePrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByLastBuyingPriceVATIncludePrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLastBuyingPriceVATIncludePrice here] end
	{
		// % protected region % [Add any additional logic for findByLastBuyingPriceVATIncludePrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByLastBuyingPriceVATIncludePrice before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByLastBuyingPriceVATIncludePrice(lastBuyingPriceVATIncludePrice));

		// % protected region % [Add any additional logic for findByLastBuyingPriceVATIncludePrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLastBuyingPriceVATIncludePrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Medical Type.
	 *
	 * @param medicalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medical Type
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByMedicalType(Boolean medicalType)
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicalType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicalType here] end
	{
		// % protected region % [Add any additional logic for findByMedicalType before the main body here] off begin
		// % protected region % [Add any additional logic for findByMedicalType before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByMedicalType(medicalType));

		// % protected region % [Add any additional logic for findByMedicalType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMedicalType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Stock Category VAT Excluded.
	 *
	 * @param stockCategoryVATExcluded the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stock Category VAT Excluded
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByStockCategoryVATExcluded(String stockCategoryVATExcluded)
	// % protected region % [Add any throwables, implementations, or extensions for findByStockCategoryVATExcluded here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStockCategoryVATExcluded here] end
	{
		// % protected region % [Add any additional logic for findByStockCategoryVATExcluded before the main body here] off begin
		// % protected region % [Add any additional logic for findByStockCategoryVATExcluded before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByStockCategoryVATExcluded(stockCategoryVATExcluded));

		// % protected region % [Add any additional logic for findByStockCategoryVATExcluded before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStockCategoryVATExcluded before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Stock Category VAT Included.
	 *
	 * @param stockCategoryVATIncluded the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stock Category VAT Included
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByStockCategoryVATIncluded(String stockCategoryVATIncluded)
	// % protected region % [Add any throwables, implementations, or extensions for findByStockCategoryVATIncluded here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStockCategoryVATIncluded here] end
	{
		// % protected region % [Add any additional logic for findByStockCategoryVATIncluded before the main body here] off begin
		// % protected region % [Add any additional logic for findByStockCategoryVATIncluded before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByStockCategoryVATIncluded(stockCategoryVATIncluded));

		// % protected region % [Add any additional logic for findByStockCategoryVATIncluded before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStockCategoryVATIncluded before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute On Hand Qty.
	 *
	 * @param onHandQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute On Hand Qty
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByOnHandQty(Double onHandQty)
	// % protected region % [Add any throwables, implementations, or extensions for findByOnHandQty here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOnHandQty here] end
	{
		// % protected region % [Add any additional logic for findByOnHandQty before the main body here] off begin
		// % protected region % [Add any additional logic for findByOnHandQty before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByOnHandQty(onHandQty));

		// % protected region % [Add any additional logic for findByOnHandQty before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOnHandQty before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Average Cost.
	 *
	 * @param averageCost the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Average Cost
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByAverageCost(Double averageCost)
	// % protected region % [Add any throwables, implementations, or extensions for findByAverageCost here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAverageCost here] end
	{
		// % protected region % [Add any additional logic for findByAverageCost before the main body here] off begin
		// % protected region % [Add any additional logic for findByAverageCost before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByAverageCost(averageCost));

		// % protected region % [Add any additional logic for findByAverageCost before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAverageCost before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Cost.
	 *
	 * @param totalCost the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Cost
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByTotalCost(Double totalCost)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalCost here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalCost here] end
	{
		// % protected region % [Add any additional logic for findByTotalCost before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalCost before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByTotalCost(totalCost));

		// % protected region % [Add any additional logic for findByTotalCost before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalCost before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sales Account.
	 *
	 * @param salesAccount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sales Account
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findBySalesAccount(String salesAccount)
	// % protected region % [Add any throwables, implementations, or extensions for findBySalesAccount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySalesAccount here] end
	{
		// % protected region % [Add any additional logic for findBySalesAccount before the main body here] off begin
		// % protected region % [Add any additional logic for findBySalesAccount before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findBySalesAccount(salesAccount));

		// % protected region % [Add any additional logic for findBySalesAccount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySalesAccount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Account.
	 *
	 * @param inventoryAccount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Account
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByInventoryAccount(String inventoryAccount)
	// % protected region % [Add any throwables, implementations, or extensions for findByInventoryAccount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInventoryAccount here] end
	{
		// % protected region % [Add any additional logic for findByInventoryAccount before the main body here] off begin
		// % protected region % [Add any additional logic for findByInventoryAccount before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByInventoryAccount(inventoryAccount));

		// % protected region % [Add any additional logic for findByInventoryAccount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInventoryAccount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Purchase Account.
	 *
	 * @param purchaseAccount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purchase Account
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByPurchaseAccount(String purchaseAccount)
	// % protected region % [Add any throwables, implementations, or extensions for findByPurchaseAccount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPurchaseAccount here] end
	{
		// % protected region % [Add any additional logic for findByPurchaseAccount before the main body here] off begin
		// % protected region % [Add any additional logic for findByPurchaseAccount before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByPurchaseAccount(purchaseAccount));

		// % protected region % [Add any additional logic for findByPurchaseAccount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPurchaseAccount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Lup Supplier Name.
	 *
	 * @param lupSupplierName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lup Supplier Name
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByLupSupplierName(String lupSupplierName)
	// % protected region % [Add any throwables, implementations, or extensions for findByLupSupplierName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLupSupplierName here] end
	{
		// % protected region % [Add any additional logic for findByLupSupplierName before the main body here] off begin
		// % protected region % [Add any additional logic for findByLupSupplierName before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByLupSupplierName(lupSupplierName));

		// % protected region % [Add any additional logic for findByLupSupplierName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLupSupplierName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Lup Unit Price.
	 *
	 * @param lupUnitPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lup Unit Price
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByLupUnitPrice(Double lupUnitPrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByLupUnitPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLupUnitPrice here] end
	{
		// % protected region % [Add any additional logic for findByLupUnitPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByLupUnitPrice before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByLupUnitPrice(lupUnitPrice));

		// % protected region % [Add any additional logic for findByLupUnitPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLupUnitPrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Lup Discount.
	 *
	 * @param lupDiscount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lup Discount
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByLupDiscount(Double lupDiscount)
	// % protected region % [Add any throwables, implementations, or extensions for findByLupDiscount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLupDiscount here] end
	{
		// % protected region % [Add any additional logic for findByLupDiscount before the main body here] off begin
		// % protected region % [Add any additional logic for findByLupDiscount before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByLupDiscount(lupDiscount));

		// % protected region % [Add any additional logic for findByLupDiscount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLupDiscount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Lup Item Price.
	 *
	 * @param lupItemPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lup Item Price
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByLupItemPrice(Double lupItemPrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByLupItemPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLupItemPrice here] end
	{
		// % protected region % [Add any additional logic for findByLupItemPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByLupItemPrice before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByLupItemPrice(lupItemPrice));

		// % protected region % [Add any additional logic for findByLupItemPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLupItemPrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Lup Last Purchase Date.
	 *
	 * @param lupLastPurchaseDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lup Last Purchase Date
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByLupLastPurchaseDate(OffsetDateTime lupLastPurchaseDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByLupLastPurchaseDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLupLastPurchaseDate here] end
	{
		// % protected region % [Add any additional logic for findByLupLastPurchaseDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByLupLastPurchaseDate before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByLupLastPurchaseDate(lupLastPurchaseDate));

		// % protected region % [Add any additional logic for findByLupLastPurchaseDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLupLastPurchaseDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Lpp Supplier Name.
	 *
	 * @param lppSupplierName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lpp Supplier Name
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByLppSupplierName(String lppSupplierName)
	// % protected region % [Add any throwables, implementations, or extensions for findByLppSupplierName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLppSupplierName here] end
	{
		// % protected region % [Add any additional logic for findByLppSupplierName before the main body here] off begin
		// % protected region % [Add any additional logic for findByLppSupplierName before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByLppSupplierName(lppSupplierName));

		// % protected region % [Add any additional logic for findByLppSupplierName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLppSupplierName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Lpp Unit Price.
	 *
	 * @param lppUnitPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lpp Unit Price
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByLppUnitPrice(Double lppUnitPrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByLppUnitPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLppUnitPrice here] end
	{
		// % protected region % [Add any additional logic for findByLppUnitPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByLppUnitPrice before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByLppUnitPrice(lppUnitPrice));

		// % protected region % [Add any additional logic for findByLppUnitPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLppUnitPrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Lpp Discount.
	 *
	 * @param lppDiscount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lpp Discount
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByLppDiscount(Double lppDiscount)
	// % protected region % [Add any throwables, implementations, or extensions for findByLppDiscount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLppDiscount here] end
	{
		// % protected region % [Add any additional logic for findByLppDiscount before the main body here] off begin
		// % protected region % [Add any additional logic for findByLppDiscount before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByLppDiscount(lppDiscount));

		// % protected region % [Add any additional logic for findByLppDiscount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLppDiscount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Lpp Item Price.
	 *
	 * @param lppItemPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lpp Item Price
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByLppItemPrice(Double lppItemPrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByLppItemPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLppItemPrice here] end
	{
		// % protected region % [Add any additional logic for findByLppItemPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByLppItemPrice before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByLppItemPrice(lppItemPrice));

		// % protected region % [Add any additional logic for findByLppItemPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLppItemPrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Lpp Last Purchase Date.
	 *
	 * @param lppLastPurchaseDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lpp Last Purchase Date
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findByLppLastPurchaseDate(OffsetDateTime lppLastPurchaseDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByLppLastPurchaseDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLppLastPurchaseDate here] end
	{
		// % protected region % [Add any additional logic for findByLppLastPurchaseDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByLppLastPurchaseDate before the main body here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findByLppLastPurchaseDate(lppLastPurchaseDate));

		// % protected region % [Add any additional logic for findByLppLastPurchaseDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLppLastPurchaseDate before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<StockCatalogueEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<StockCatalogueEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<StockCatalogueEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<StockCatalogueEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'create')")
	public StockCatalogueEntity create(StockCatalogueEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		StockCatalogueEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'create')")
	public StockCatalogueEntity create(StockCatalogueEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		StockCatalogueEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		StockCatalogueEntity newEntity;

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
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'create')")
	public List<StockCatalogueEntity> createAll(Iterable<StockCatalogueEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<StockCatalogueEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<StockCatalogueEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'update')")
	public StockCatalogueEntity update(StockCatalogueEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		StockCatalogueEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'update')")
	public StockCatalogueEntity update(StockCatalogueEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		StockCatalogueEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		StockCatalogueEntity newEntity;

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
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'update')")
	public List<StockCatalogueEntity> updateAll(Iterable<StockCatalogueEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<StockCatalogueEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<StockCatalogueEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'create') or hasPermission('StockCatalogueEntity', 'update')")
	public StockCatalogueEntity save(StockCatalogueEntity entity) throws ConstraintViolationException
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

		StockCatalogueEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'create') or hasPermission('StockCatalogueEntity', 'update')")
	public List<StockCatalogueEntity> saveAll(Iterable<StockCatalogueEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<StockCatalogueEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'delete')")
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
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'delete')")
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
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	public List<StockCatalogueEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	public List<StockCatalogueEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(StockCatalogueEntity.class);

		// % protected region % [Add any additional processing before converting to a list of StockCatalogueEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of StockCatalogueEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<StockCatalogueEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of StockCatalogueEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of StockCatalogueEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(StockCatalogueEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of StockCatalogueEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of StockCatalogueEntityAudits
	 */
	private List<StockCatalogueEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<StockCatalogueEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param stockCatalogue stockCatalogue to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private StockCatalogueEntity updateAuditData(StockCatalogueEntity stockCatalogue)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return stockCatalogue;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private StockCatalogueEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		StockCatalogueEntity entityAtRevision = updateAuditData((StockCatalogueEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new StockCatalogueEntityAudit(
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

		QStockCatalogueEntity entity = QStockCatalogueEntity.stockCatalogueEntity;

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
			case "stockCatalogueMedicalId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Stock Catalogue Medical  here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Stock Catalogue Medical  here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockCatalogueMedical.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Stock Catalogue Medical  here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Stock Catalogue Medical  here] end

				break;
			case "stockCatalogueNonMedicalId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Stock Catalogue Non Medical here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Stock Catalogue Non Medical here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockCatalogueNonMedical.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Stock Catalogue Non Medical here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Stock Catalogue Non Medical here] end

				break;
			case "bpjsDrugGenericPRBId":
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Drug Generic PRB to Stock Catalogue here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Drug Generic PRB to Stock Catalogue here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsDrugGenericPRB.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Drug Generic PRB to Stock Catalogue here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Drug Generic PRB to Stock Catalogue here] end

				break;
			case "bpjsPcareDPHOId":
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Pcare DPHO to Stock Catalogue here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Pcare DPHO to Stock Catalogue here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsPcareDPHO.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Pcare DPHO to Stock Catalogue here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Pcare DPHO to Stock Catalogue here] end

				break;
			case "warehouseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Stock Catalogues here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Stock Catalogues here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.warehouse.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Stock Catalogues here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Stock Catalogues here] end

				break;
			case "batchStockBalancesCatalogueId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Batch Stock Balances Catalogue here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Batch Stock Balances Catalogue here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.batchStockBalancesCatalogue.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Batch Stock Balances Catalogue here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Batch Stock Balances Catalogue here] end

				break;
			case "batchStockBalancesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Batch Stock Balances here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Batch Stock Balances here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.batchStockBalances.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Batch Stock Balances here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Batch Stock Balances here] end

				break;
			case "batchStockTransactionDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Batch Stock Transaction Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Batch Stock Transaction Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.batchStockTransactionDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Batch Stock Transaction Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Batch Stock Transaction Details here] end

				break;
			case "catalogueUOMsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Catalogue UOMs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Catalogue UOMs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.catalogueUOMs.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Catalogue UOMs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Catalogue UOMs here] end

				break;
			case "compoundPrescriptionItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Compound Prescription Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Compound Prescription Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.compoundPrescriptionItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Compound Prescription Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Compound Prescription Items here] end

				break;
			case "goodsReceiveNoteBatchsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Goods Receive Note Batchs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Goods Receive Note Batchs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.goodsReceiveNoteBatchs.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Goods Receive Note Batchs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Goods Receive Note Batchs here] end

				break;
			case "goodsReceiveNoteItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Goods Receive Note Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Goods Receive Note Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.goodsReceiveNoteItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Goods Receive Note Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Goods Receive Note Items here] end

				break;
			case "internalOrderStockDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Internal Order Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Internal Order Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.internalOrderStockDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Internal Order Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Internal Order Stock Details here] end

				break;
			case "inventoryAdjusmentBatchsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Inventory Adjusment Batchs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Inventory Adjusment Batchs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inventoryAdjusmentBatchs.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Inventory Adjusment Batchs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Inventory Adjusment Batchs here] end

				break;
			case "inventoryAdjustmentItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Inventory Adjustment Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Inventory Adjustment Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inventoryAdjustmentItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Inventory Adjustment Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Inventory Adjustment Items here] end

				break;
			case "inventoryBatchCorrectionItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Inventory Batch Correction Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Inventory Batch Correction Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inventoryBatchCorrectionItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Inventory Batch Correction Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Inventory Batch Correction Items here] end

				break;
			case "medicationItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Medication Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Medication Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicationItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Medication Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Medication Items here] end

				break;
			case "prescriptionItemId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue Id to Prescription Item here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue Id to Prescription Item here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.prescriptionItem.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue Id to Prescription Item here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue Id to Prescription Item here] end

				break;
			case "purchaseOrderStockDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Purchase Order Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Purchase Order Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseOrderStockDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Purchase Order Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Purchase Order Stock Details here] end

				break;
			case "purchaseRequisitionStockDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Purchase Requisition Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Purchase Requisition Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseRequisitionStockDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Purchase Requisition Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Purchase Requisition Stock Details here] end

				break;
			case "retailPharmacyStockDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Retail Pharmacy Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Retail Pharmacy Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.retailPharmacyStockDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Retail Pharmacy Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Retail Pharmacy Stock Details here] end

				break;
			case "returnSupplierStockDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Return Supplier Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Return Supplier Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.returnSupplierStockDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Return Supplier Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Return Supplier Stock Details here] end

				break;
			case "stockControlsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Stock Controls here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Stock Controls here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockControls.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Stock Controls here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Stock Controls here] end

				break;
			case "stockTransactionDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Stock Transaction Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Stock Transaction Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockTransactionDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Stock Transaction Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Stock Transaction Details here] end

				break;
			case "stockTransactionPerDateTypesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Stock Transaction Per Date Types here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Stock Transaction Per Date Types here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockTransactionPerDateTypes.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Stock Transaction Per Date Types here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Stock Transaction Per Date Types here] end

				break;
			case "stockTransactionPerDatesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Stock Transaction Per Dates here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Stock Transaction Per Dates here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockTransactionPerDates.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Stock Transaction Per Dates here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Stock Transaction Per Dates here] end

				break;
			case "supplierProductDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Supplier Product Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Supplier Product Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.supplierProductDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Supplier Product Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Supplier Product Details here] end

				break;
			case "transferOrderStockDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Transfer Order Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Transfer Order Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transferOrderStockDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Transfer Order Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Transfer Order Stock Details here] end

				break;
			case "vaccinationOrderDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Vaccination Order Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Vaccination Order Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.vaccinationOrderDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Vaccination Order Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Vaccination Order Details here] end

				break;
			case "warehouseInitialStockSId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Warehouse Initial Stock s here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Warehouse Initial Stock s here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.warehouseInitialStockS.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Warehouse Initial Stock s here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Warehouse Initial Stock s here] end

				break;
			case "warehouseInventoriesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Warehouse Inventories here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Warehouse Inventories here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.warehouseInventories.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Warehouse Inventories here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Warehouse Inventories here] end

				break;
			case "stockCode":
				// % protected region % [Add any additional logic before the query parameters of stockCode here] off begin
				// % protected region % [Add any additional logic before the query parameters of stockCode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockCode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of stockCode here] off begin
				// % protected region % [Add any additional logic after the query parameters of stockCode here] end

				break;
			case "stockName":
				// % protected region % [Add any additional logic before the query parameters of stockName here] off begin
				// % protected region % [Add any additional logic before the query parameters of stockName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of stockName here] off begin
				// % protected region % [Add any additional logic after the query parameters of stockName here] end

				break;
			case "stockGroup":
				// % protected region % [Add any additional logic before the query parameters of stockGroup here] off begin
				// % protected region % [Add any additional logic before the query parameters of stockGroup here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockGroup, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of stockGroup here] off begin
				// % protected region % [Add any additional logic after the query parameters of stockGroup here] end

				break;
			case "stockCategory":
				// % protected region % [Add any additional logic before the query parameters of stockCategory here] off begin
				// % protected region % [Add any additional logic before the query parameters of stockCategory here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockCategory, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of stockCategory here] off begin
				// % protected region % [Add any additional logic after the query parameters of stockCategory here] end

				break;
			case "approvalStatus":
				// % protected region % [Add any additional logic before the query parameters of approvalStatus here] off begin
				// % protected region % [Add any additional logic before the query parameters of approvalStatus here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.approvalStatus, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of approvalStatus here] off begin
				// % protected region % [Add any additional logic after the query parameters of approvalStatus here] end

				break;
			case "medicalType":
				// % protected region % [Add any additional logic before the query parameters of medicalType here] off begin
				// % protected region % [Add any additional logic before the query parameters of medicalType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of medicalType here] off begin
				// % protected region % [Add any additional logic after the query parameters of medicalType here] end

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
	public StockCatalogueEntity updateOldData(StockCatalogueEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public StockCatalogueEntity updateOldData(StockCatalogueEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		StockCatalogueEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInStockCatalogueEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getTrackable() == null) {
			entityToUpdate.setTrackable(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getMedicalType() == null) {
			entityToUpdate.setMedicalType(false);
		}

		// Incoming One to One reference
		if (entity.getBpjsDrugGenericPRB() == null && entity.getBpjsDrugGenericPRBId() == null) {
			entityToUpdate.unsetBpjsDrugGenericPRB();
		} else if (entity.getBpjsDrugGenericPRBId() != null && entity.getBpjsDrugGenericPRB() == null) {
			Optional<BpjsDrugGenericPRBEntity> bpjsDrugGenericPRBEntity = this.bpjsDrugGenericPRBRepository.findById(entity.getBpjsDrugGenericPRBId());
			entityToUpdate.setBpjsDrugGenericPRB(bpjsDrugGenericPRBEntity.orElseThrow());
		}
		if (persistRelations && entity.getBpjsDrugGenericPRB() != null) {
			entityToUpdate.setBpjsDrugGenericPRB(entity.getBpjsDrugGenericPRB(), false);
			if (entityToUpdate.getBpjsDrugGenericPRBId() != null) {
				this.bpjsDrugGenericPRBRepository.save(entityToUpdate.getBpjsDrugGenericPRB());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBpjsDrugGenericPRB().unsetStockCatalogue();
			}
		}

		// Incoming One to One reference
		if (entity.getBpjsPcareDPHO() == null && entity.getBpjsPcareDPHOId() == null) {
			entityToUpdate.unsetBpjsPcareDPHO();
		} else if (entity.getBpjsPcareDPHOId() != null && entity.getBpjsPcareDPHO() == null) {
			Optional<BpjsPcareDPHOEntity> bpjsPcareDPHOEntity = this.bpjsPcareDPHORepository.findById(entity.getBpjsPcareDPHOId());
			entityToUpdate.setBpjsPcareDPHO(bpjsPcareDPHOEntity.orElseThrow());
		}
		if (persistRelations && entity.getBpjsPcareDPHO() != null) {
			entityToUpdate.setBpjsPcareDPHO(entity.getBpjsPcareDPHO(), false);
			if (entityToUpdate.getBpjsPcareDPHOId() != null) {
				this.bpjsPcareDPHORepository.save(entityToUpdate.getBpjsPcareDPHO());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBpjsPcareDPHO().unsetStockCatalogue();
			}
		}

		// Outgoing one to one reference
		if (entity.getStockCatalogueMedical() == null && entity.getStockCatalogueMedicalId() == null) {
			entityToUpdate.unsetStockCatalogueMedical();
		} else if (entity.getStockCatalogueMedicalId() != null && entity.getStockCatalogueMedical() == null) {
			Optional<CatalogueMedicalEntity> stockCatalogueMedicalEntity = this.catalogueMedicalRepository.findById(entity.getStockCatalogueMedicalId());
			entityToUpdate.setStockCatalogueMedical(stockCatalogueMedicalEntity.orElseThrow());
		}
		if (persistRelations && entity.getStockCatalogueMedical() != null) {
			entityToUpdate.setStockCatalogueMedical(entity.getStockCatalogueMedical(), false);
			if (entityToUpdate.getStockCatalogueMedicalId() != null) {
				this.catalogueMedicalRepository.save(entityToUpdate.getStockCatalogueMedical());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getStockCatalogueMedical().unsetStockCatalogue();
			}
		}

		// Outgoing one to one reference
		if (entity.getStockCatalogueNonMedical() == null && entity.getStockCatalogueNonMedicalId() == null) {
			entityToUpdate.unsetStockCatalogueNonMedical();
		} else if (entity.getStockCatalogueNonMedicalId() != null && entity.getStockCatalogueNonMedical() == null) {
			Optional<CatalogueNonMedicalEntity> stockCatalogueNonMedicalEntity = this.catalogueNonMedicalRepository.findById(entity.getStockCatalogueNonMedicalId());
			entityToUpdate.setStockCatalogueNonMedical(stockCatalogueNonMedicalEntity.orElseThrow());
		}
		if (persistRelations && entity.getStockCatalogueNonMedical() != null) {
			entityToUpdate.setStockCatalogueNonMedical(entity.getStockCatalogueNonMedical(), false);
			if (entityToUpdate.getStockCatalogueNonMedicalId() != null) {
				this.catalogueNonMedicalRepository.save(entityToUpdate.getStockCatalogueNonMedical());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getStockCatalogueNonMedical().unsetStockCatalogue();
			}
		}

		// Incoming One to Many reference
		if (entity.getWarehouse() == null && entity.getWarehouseId() == null) {
			entityToUpdate.unsetWarehouse();
		} else if (entity.getWarehouseId() != null && entity.getWarehouse() == null) {
			Optional<WarehouseEntity> warehouseEntity = this.warehouseRepository.findById(entity.getWarehouseId());
			entityToUpdate.setWarehouse(warehouseEntity.orElseThrow());
		}
		if (persistRelations && entity.getWarehouse() != null) {
			entityToUpdate.setWarehouse(entity.getWarehouse(), false);
			if (entityToUpdate.getWarehouseId() != null) {
				this.warehouseRepository.save(entityToUpdate.getWarehouse());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getWarehouse().unsetStockCatalogues();
			}
		}

		// Outgoing one to many reference
		if (entity.getBatchStockBalancesCatalogueIds().isEmpty() && entity.getBatchStockBalancesCatalogue().isEmpty()) {
			entityToUpdate.setBatchStockBalancesCatalogue(new HashSet<>());
		} else if (!entity.getBatchStockBalancesCatalogueIds().isEmpty() && entity.getBatchStockBalancesCatalogue().isEmpty()) {
			Iterable<BatchStockBalanceEntity> batchStockBalancesCatalogueEntities =
					this.batchStockBalanceRepository.findAllById(entity.getBatchStockBalancesCatalogueIds());
			entityToUpdate.setBatchStockBalancesCatalogue(Sets.newHashSet(batchStockBalancesCatalogueEntities));
		}
		if (persistRelations && !entity.getBatchStockBalancesCatalogue().isEmpty()) {
			Set<BatchStockBalanceEntity> updatedEntities = new HashSet<>();
			entity.getBatchStockBalancesCatalogue().forEach(model -> {
				if (model.getId() != null) {
					model = this.batchStockBalanceRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBatchStockBalancesCatalogue(updatedEntities);
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
		if (entity.getCatalogueUOMsIds().isEmpty() && entity.getCatalogueUOMs().isEmpty()) {
			entityToUpdate.setCatalogueUOMs(new HashSet<>());
		} else if (!entity.getCatalogueUOMsIds().isEmpty() && entity.getCatalogueUOMs().isEmpty()) {
			Iterable<CatalogueUOMEntity> catalogueUOMsEntities =
					this.catalogueUOMRepository.findAllById(entity.getCatalogueUOMsIds());
			entityToUpdate.setCatalogueUOMs(Sets.newHashSet(catalogueUOMsEntities));
		}
		if (persistRelations && !entity.getCatalogueUOMs().isEmpty()) {
			Set<CatalogueUOMEntity> updatedEntities = new HashSet<>();
			entity.getCatalogueUOMs().forEach(model -> {
				if (model.getId() != null) {
					model = this.catalogueUOMRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setCatalogueUOMs(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getCompoundPrescriptionItemsIds().isEmpty() && entity.getCompoundPrescriptionItems().isEmpty()) {
			entityToUpdate.setCompoundPrescriptionItems(new HashSet<>());
		} else if (!entity.getCompoundPrescriptionItemsIds().isEmpty() && entity.getCompoundPrescriptionItems().isEmpty()) {
			Iterable<CompoundPrescriptionItemEntity> compoundPrescriptionItemsEntities =
					this.compoundPrescriptionItemRepository.findAllById(entity.getCompoundPrescriptionItemsIds());
			entityToUpdate.setCompoundPrescriptionItems(Sets.newHashSet(compoundPrescriptionItemsEntities));
		}
		if (persistRelations && !entity.getCompoundPrescriptionItems().isEmpty()) {
			Set<CompoundPrescriptionItemEntity> updatedEntities = new HashSet<>();
			entity.getCompoundPrescriptionItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.compoundPrescriptionItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setCompoundPrescriptionItems(updatedEntities);
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
		if (entity.getGoodsReceiveNoteItemsIds().isEmpty() && entity.getGoodsReceiveNoteItems().isEmpty()) {
			entityToUpdate.setGoodsReceiveNoteItems(new HashSet<>());
		} else if (!entity.getGoodsReceiveNoteItemsIds().isEmpty() && entity.getGoodsReceiveNoteItems().isEmpty()) {
			Iterable<GoodsReceiveNoteItemEntity> goodsReceiveNoteItemsEntities =
					this.goodsReceiveNoteItemRepository.findAllById(entity.getGoodsReceiveNoteItemsIds());
			entityToUpdate.setGoodsReceiveNoteItems(Sets.newHashSet(goodsReceiveNoteItemsEntities));
		}
		if (persistRelations && !entity.getGoodsReceiveNoteItems().isEmpty()) {
			Set<GoodsReceiveNoteItemEntity> updatedEntities = new HashSet<>();
			entity.getGoodsReceiveNoteItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.goodsReceiveNoteItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setGoodsReceiveNoteItems(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getInternalOrderStockDetailsIds().isEmpty() && entity.getInternalOrderStockDetails().isEmpty()) {
			entityToUpdate.setInternalOrderStockDetails(new HashSet<>());
		} else if (!entity.getInternalOrderStockDetailsIds().isEmpty() && entity.getInternalOrderStockDetails().isEmpty()) {
			Iterable<InternalOrderStockDetailEntity> internalOrderStockDetailsEntities =
					this.internalOrderStockDetailRepository.findAllById(entity.getInternalOrderStockDetailsIds());
			entityToUpdate.setInternalOrderStockDetails(Sets.newHashSet(internalOrderStockDetailsEntities));
		}
		if (persistRelations && !entity.getInternalOrderStockDetails().isEmpty()) {
			Set<InternalOrderStockDetailEntity> updatedEntities = new HashSet<>();
			entity.getInternalOrderStockDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.internalOrderStockDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInternalOrderStockDetails(updatedEntities);
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
		if (entity.getInventoryAdjustmentItemsIds().isEmpty() && entity.getInventoryAdjustmentItems().isEmpty()) {
			entityToUpdate.setInventoryAdjustmentItems(new HashSet<>());
		} else if (!entity.getInventoryAdjustmentItemsIds().isEmpty() && entity.getInventoryAdjustmentItems().isEmpty()) {
			Iterable<InventoryAdjustmentItemEntity> inventoryAdjustmentItemsEntities =
					this.inventoryAdjustmentItemRepository.findAllById(entity.getInventoryAdjustmentItemsIds());
			entityToUpdate.setInventoryAdjustmentItems(Sets.newHashSet(inventoryAdjustmentItemsEntities));
		}
		if (persistRelations && !entity.getInventoryAdjustmentItems().isEmpty()) {
			Set<InventoryAdjustmentItemEntity> updatedEntities = new HashSet<>();
			entity.getInventoryAdjustmentItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.inventoryAdjustmentItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInventoryAdjustmentItems(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getInventoryBatchCorrectionItemsIds().isEmpty() && entity.getInventoryBatchCorrectionItems().isEmpty()) {
			entityToUpdate.setInventoryBatchCorrectionItems(new HashSet<>());
		} else if (!entity.getInventoryBatchCorrectionItemsIds().isEmpty() && entity.getInventoryBatchCorrectionItems().isEmpty()) {
			Iterable<InventoryBatchCorrectionItemEntity> inventoryBatchCorrectionItemsEntities =
					this.inventoryBatchCorrectionItemRepository.findAllById(entity.getInventoryBatchCorrectionItemsIds());
			entityToUpdate.setInventoryBatchCorrectionItems(Sets.newHashSet(inventoryBatchCorrectionItemsEntities));
		}
		if (persistRelations && !entity.getInventoryBatchCorrectionItems().isEmpty()) {
			Set<InventoryBatchCorrectionItemEntity> updatedEntities = new HashSet<>();
			entity.getInventoryBatchCorrectionItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.inventoryBatchCorrectionItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInventoryBatchCorrectionItems(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicationItemsIds().isEmpty() && entity.getMedicationItems().isEmpty()) {
			entityToUpdate.setMedicationItems(new HashSet<>());
		} else if (!entity.getMedicationItemsIds().isEmpty() && entity.getMedicationItems().isEmpty()) {
			Iterable<MedicationItemEntity> medicationItemsEntities =
					this.medicationItemRepository.findAllById(entity.getMedicationItemsIds());
			entityToUpdate.setMedicationItems(Sets.newHashSet(medicationItemsEntities));
		}
		if (persistRelations && !entity.getMedicationItems().isEmpty()) {
			Set<MedicationItemEntity> updatedEntities = new HashSet<>();
			entity.getMedicationItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicationItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicationItems(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPrescriptionItemIds().isEmpty() && entity.getPrescriptionItem().isEmpty()) {
			entityToUpdate.setPrescriptionItem(new HashSet<>());
		} else if (!entity.getPrescriptionItemIds().isEmpty() && entity.getPrescriptionItem().isEmpty()) {
			Iterable<PrescriptionItemEntity> prescriptionItemEntities =
					this.prescriptionItemRepository.findAllById(entity.getPrescriptionItemIds());
			entityToUpdate.setPrescriptionItem(Sets.newHashSet(prescriptionItemEntities));
		}
		if (persistRelations && !entity.getPrescriptionItem().isEmpty()) {
			Set<PrescriptionItemEntity> updatedEntities = new HashSet<>();
			entity.getPrescriptionItem().forEach(model -> {
				if (model.getId() != null) {
					model = this.prescriptionItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPrescriptionItem(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPurchaseOrderStockDetailsIds().isEmpty() && entity.getPurchaseOrderStockDetails().isEmpty()) {
			entityToUpdate.setPurchaseOrderStockDetails(new HashSet<>());
		} else if (!entity.getPurchaseOrderStockDetailsIds().isEmpty() && entity.getPurchaseOrderStockDetails().isEmpty()) {
			Iterable<PurchaseOrderStockDetailEntity> purchaseOrderStockDetailsEntities =
					this.purchaseOrderStockDetailRepository.findAllById(entity.getPurchaseOrderStockDetailsIds());
			entityToUpdate.setPurchaseOrderStockDetails(Sets.newHashSet(purchaseOrderStockDetailsEntities));
		}
		if (persistRelations && !entity.getPurchaseOrderStockDetails().isEmpty()) {
			Set<PurchaseOrderStockDetailEntity> updatedEntities = new HashSet<>();
			entity.getPurchaseOrderStockDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.purchaseOrderStockDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPurchaseOrderStockDetails(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPurchaseRequisitionStockDetailsIds().isEmpty() && entity.getPurchaseRequisitionStockDetails().isEmpty()) {
			entityToUpdate.setPurchaseRequisitionStockDetails(new HashSet<>());
		} else if (!entity.getPurchaseRequisitionStockDetailsIds().isEmpty() && entity.getPurchaseRequisitionStockDetails().isEmpty()) {
			Iterable<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetailsEntities =
					this.purchaseRequisitionStockDetailRepository.findAllById(entity.getPurchaseRequisitionStockDetailsIds());
			entityToUpdate.setPurchaseRequisitionStockDetails(Sets.newHashSet(purchaseRequisitionStockDetailsEntities));
		}
		if (persistRelations && !entity.getPurchaseRequisitionStockDetails().isEmpty()) {
			Set<PurchaseRequisitionStockDetailEntity> updatedEntities = new HashSet<>();
			entity.getPurchaseRequisitionStockDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.purchaseRequisitionStockDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPurchaseRequisitionStockDetails(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getRetailPharmacyStockDetailsIds().isEmpty() && entity.getRetailPharmacyStockDetails().isEmpty()) {
			entityToUpdate.setRetailPharmacyStockDetails(new HashSet<>());
		} else if (!entity.getRetailPharmacyStockDetailsIds().isEmpty() && entity.getRetailPharmacyStockDetails().isEmpty()) {
			Iterable<RetailPharmacyStockDetailEntity> retailPharmacyStockDetailsEntities =
					this.retailPharmacyStockDetailRepository.findAllById(entity.getRetailPharmacyStockDetailsIds());
			entityToUpdate.setRetailPharmacyStockDetails(Sets.newHashSet(retailPharmacyStockDetailsEntities));
		}
		if (persistRelations && !entity.getRetailPharmacyStockDetails().isEmpty()) {
			Set<RetailPharmacyStockDetailEntity> updatedEntities = new HashSet<>();
			entity.getRetailPharmacyStockDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.retailPharmacyStockDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setRetailPharmacyStockDetails(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getReturnSupplierStockDetailsIds().isEmpty() && entity.getReturnSupplierStockDetails().isEmpty()) {
			entityToUpdate.setReturnSupplierStockDetails(new HashSet<>());
		} else if (!entity.getReturnSupplierStockDetailsIds().isEmpty() && entity.getReturnSupplierStockDetails().isEmpty()) {
			Iterable<ReturnSupplierStockDetailEntity> returnSupplierStockDetailsEntities =
					this.returnSupplierStockDetailRepository.findAllById(entity.getReturnSupplierStockDetailsIds());
			entityToUpdate.setReturnSupplierStockDetails(Sets.newHashSet(returnSupplierStockDetailsEntities));
		}
		if (persistRelations && !entity.getReturnSupplierStockDetails().isEmpty()) {
			Set<ReturnSupplierStockDetailEntity> updatedEntities = new HashSet<>();
			entity.getReturnSupplierStockDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.returnSupplierStockDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setReturnSupplierStockDetails(updatedEntities);
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
		if (entity.getSupplierProductDetailsIds().isEmpty() && entity.getSupplierProductDetails().isEmpty()) {
			entityToUpdate.setSupplierProductDetails(new HashSet<>());
		} else if (!entity.getSupplierProductDetailsIds().isEmpty() && entity.getSupplierProductDetails().isEmpty()) {
			Iterable<SupplierProductDetailEntity> supplierProductDetailsEntities =
					this.supplierProductDetailRepository.findAllById(entity.getSupplierProductDetailsIds());
			entityToUpdate.setSupplierProductDetails(Sets.newHashSet(supplierProductDetailsEntities));
		}
		if (persistRelations && !entity.getSupplierProductDetails().isEmpty()) {
			Set<SupplierProductDetailEntity> updatedEntities = new HashSet<>();
			entity.getSupplierProductDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.supplierProductDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setSupplierProductDetails(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getTransferOrderStockDetailsIds().isEmpty() && entity.getTransferOrderStockDetails().isEmpty()) {
			entityToUpdate.setTransferOrderStockDetails(new HashSet<>());
		} else if (!entity.getTransferOrderStockDetailsIds().isEmpty() && entity.getTransferOrderStockDetails().isEmpty()) {
			Iterable<TransferOrderStockDetailEntity> transferOrderStockDetailsEntities =
					this.transferOrderStockDetailRepository.findAllById(entity.getTransferOrderStockDetailsIds());
			entityToUpdate.setTransferOrderStockDetails(Sets.newHashSet(transferOrderStockDetailsEntities));
		}
		if (persistRelations && !entity.getTransferOrderStockDetails().isEmpty()) {
			Set<TransferOrderStockDetailEntity> updatedEntities = new HashSet<>();
			entity.getTransferOrderStockDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.transferOrderStockDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setTransferOrderStockDetails(updatedEntities);
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
	public void validateEntity(StockCatalogueEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<StockCatalogueEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByStockCodeOpt = this.findByStockCode(entity.getStockCode());
			if (entityByStockCodeOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<StockCatalogueEntity>(
						"Stock Code",
						entity.getStockCode(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"StockCode"
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
	 * Get the sort as given by the sort by for the StockCatalogueEntity.
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

	public Set<String> validateEntityRelations(StockCatalogueEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getBpjsDrugGenericPRBId() != null && this.bpjsDrugGenericPRBRepository.findById(entity.getBpjsDrugGenericPRBId()).isEmpty()) {
			errors.add("The UUID " + entity.getBpjsDrugGenericPRBId() + " is not associated with a BPJS Drug Generic PRB Entity");
		}

		if (entity.getBpjsPcareDPHOId() != null && this.bpjsPcareDPHORepository.findById(entity.getBpjsPcareDPHOId()).isEmpty()) {
			errors.add("The UUID " + entity.getBpjsPcareDPHOId() + " is not associated with a BPJS Pcare DPHO Entity");
		}

		if (entity.getWarehouseId() != null && this.warehouseRepository.findById(entity.getWarehouseId()).isEmpty()) {
			errors.add("The UUID " + entity.getWarehouseId() + " is not associated with a Warehouse Entity");
		}

		for (UUID id : entity.getBatchStockBalancesCatalogueIds()) {
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

		for (UUID id : entity.getCatalogueUOMsIds()) {
			if (this.catalogueUOMRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Catalogue UOM Entity");
			}
		}

		for (UUID id : entity.getCompoundPrescriptionItemsIds()) {
			if (this.compoundPrescriptionItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Compound Prescription Item Entity");
			}
		}

		for (UUID id : entity.getGoodsReceiveNoteBatchsIds()) {
			if (this.goodsReceiveNoteBatchRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Goods Receive Note Batch Entity");
			}
		}

		for (UUID id : entity.getGoodsReceiveNoteItemsIds()) {
			if (this.goodsReceiveNoteItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Goods Receive Note Item Entity");
			}
		}

		for (UUID id : entity.getInternalOrderStockDetailsIds()) {
			if (this.internalOrderStockDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Internal Order Stock Detail Entity");
			}
		}

		for (UUID id : entity.getInventoryAdjusmentBatchsIds()) {
			if (this.inventoryAdjusmentBatchRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Inventory Adjusment Batch Entity");
			}
		}

		for (UUID id : entity.getInventoryAdjustmentItemsIds()) {
			if (this.inventoryAdjustmentItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Inventory Adjustment Item Entity");
			}
		}

		for (UUID id : entity.getInventoryBatchCorrectionItemsIds()) {
			if (this.inventoryBatchCorrectionItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Inventory Batch Correction Item Entity");
			}
		}

		for (UUID id : entity.getMedicationItemsIds()) {
			if (this.medicationItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medication Item Entity");
			}
		}

		for (UUID id : entity.getPrescriptionItemIds()) {
			if (this.prescriptionItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Prescription Item Entity");
			}
		}

		for (UUID id : entity.getPurchaseOrderStockDetailsIds()) {
			if (this.purchaseOrderStockDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Purchase Order Stock Detail Entity");
			}
		}

		for (UUID id : entity.getPurchaseRequisitionStockDetailsIds()) {
			if (this.purchaseRequisitionStockDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Purchase Requisition Stock Detail Entity");
			}
		}

		for (UUID id : entity.getRetailPharmacyStockDetailsIds()) {
			if (this.retailPharmacyStockDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Retail Pharmacy Stock Detail Entity");
			}
		}

		for (UUID id : entity.getReturnSupplierStockDetailsIds()) {
			if (this.returnSupplierStockDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Return Supplier Stock Detail Entity");
			}
		}

		if (entity.getStockCatalogueMedicalId() != null && this.catalogueMedicalRepository.findById(entity.getStockCatalogueMedicalId()).isEmpty()) {
			errors.add("The UUID " + entity.getStockCatalogueMedicalId() + " is not associated with a Catalogue Medical  Entity");
		}

		if (entity.getStockCatalogueNonMedicalId() != null && this.catalogueNonMedicalRepository.findById(entity.getStockCatalogueNonMedicalId()).isEmpty()) {
			errors.add("The UUID " + entity.getStockCatalogueNonMedicalId() + " is not associated with a Catalogue Non Medical Entity");
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

		for (UUID id : entity.getSupplierProductDetailsIds()) {
			if (this.supplierProductDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Supplier Product Detail Entity");
			}
		}

		for (UUID id : entity.getTransferOrderStockDetailsIds()) {
			if (this.transferOrderStockDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Transfer Order Stock Detail Entity");
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
