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
import kmsweb.repositories.PurchaseOrderRepository;
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
import kmsweb.entities.GoodsReceiveNoteEntity;
import kmsweb.repositories.GoodsReceiveNoteRepository;
import kmsweb.entities.PurchaseOrderStockDetailEntity;
import kmsweb.repositories.PurchaseOrderStockDetailRepository;
import kmsweb.entities.PurchaseRequisitionEntity;
import kmsweb.repositories.PurchaseRequisitionRepository;
import kmsweb.entities.ReturnSupplierEntity;
import kmsweb.repositories.ReturnSupplierRepository;
import kmsweb.entities.SupplierEntity;
import kmsweb.repositories.SupplierRepository;
import kmsweb.entities.WarehouseEntity;
import kmsweb.repositories.WarehouseRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class PurchaseOrderService extends AbstractService<PurchaseOrderEntity, PurchaseOrderRepository, PurchaseOrderEntityAudit> {

	private final String[] referenceNamesInPurchaseOrderEntity = {
		"purchaseOrderStockDetails",
		"purchaseRequisitions",
		"returnSuppliers",
		"goodsReceiveNote",
		"supplier",
		"warehouse",
	};

	private final GoodsReceiveNoteRepository goodsReceiveNoteRepository;

	private final PurchaseOrderStockDetailRepository purchaseOrderStockDetailRepository;

	private final PurchaseRequisitionRepository purchaseRequisitionRepository;

	private final ReturnSupplierRepository returnSupplierRepository;

	private final SupplierRepository supplierRepository;

	private final WarehouseRepository warehouseRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PurchaseOrderService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		GoodsReceiveNoteRepository goodsReceiveNoteRepository,
		PurchaseOrderStockDetailRepository purchaseOrderStockDetailRepository,
		PurchaseRequisitionRepository purchaseRequisitionRepository,
		ReturnSupplierRepository returnSupplierRepository,
		SupplierRepository supplierRepository,
		WarehouseRepository warehouseRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		PurchaseOrderRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.goodsReceiveNoteRepository = goodsReceiveNoteRepository;

		this.purchaseOrderStockDetailRepository = purchaseOrderStockDetailRepository;

		this.purchaseRequisitionRepository = purchaseRequisitionRepository;

		this.returnSupplierRepository = returnSupplierRepository;

		this.supplierRepository = supplierRepository;

		this.warehouseRepository = warehouseRepository;

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
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
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
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Purchase Order Type.
	 *
	 * @param purchaseOrderType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purchase Order Type
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByPurchaseOrderType(String purchaseOrderType)
	// % protected region % [Add any throwables, implementations, or extensions for findByPurchaseOrderType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPurchaseOrderType here] end
	{
		// % protected region % [Add any additional logic for findByPurchaseOrderType before the main body here] off begin
		// % protected region % [Add any additional logic for findByPurchaseOrderType before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByPurchaseOrderType(purchaseOrderType));

		// % protected region % [Add any additional logic for findByPurchaseOrderType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPurchaseOrderType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Purchase Order Number.
	 *
	 * @param purchaseOrderNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purchase Order Number
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByPurchaseOrderNumber(String purchaseOrderNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByPurchaseOrderNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPurchaseOrderNumber here] end
	{
		// % protected region % [Add any additional logic for findByPurchaseOrderNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByPurchaseOrderNumber before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByPurchaseOrderNumber(purchaseOrderNumber));

		// % protected region % [Add any additional logic for findByPurchaseOrderNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPurchaseOrderNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute status.
	 *
	 * @param status the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute status
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByStatus(String status)
	// % protected region % [Add any throwables, implementations, or extensions for findByStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStatus here] end
	{
		// % protected region % [Add any additional logic for findByStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByStatus before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByStatus(status));

		// % protected region % [Add any additional logic for findByStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Supply Stock Group.
	 *
	 * @param supplyStockGroup the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supply Stock Group
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findBySupplyStockGroup(String supplyStockGroup)
	// % protected region % [Add any throwables, implementations, or extensions for findBySupplyStockGroup here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySupplyStockGroup here] end
	{
		// % protected region % [Add any additional logic for findBySupplyStockGroup before the main body here] off begin
		// % protected region % [Add any additional logic for findBySupplyStockGroup before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findBySupplyStockGroup(supplyStockGroup));

		// % protected region % [Add any additional logic for findBySupplyStockGroup before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySupplyStockGroup before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Order Date.
	 *
	 * @param orderDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Order Date
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByOrderDate(OffsetDateTime orderDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByOrderDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOrderDate here] end
	{
		// % protected region % [Add any additional logic for findByOrderDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByOrderDate before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByOrderDate(orderDate));

		// % protected region % [Add any additional logic for findByOrderDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOrderDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Expected Date.
	 *
	 * @param expectedDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Expected Date
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByExpectedDate(OffsetDateTime expectedDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByExpectedDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExpectedDate here] end
	{
		// % protected region % [Add any additional logic for findByExpectedDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByExpectedDate before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByExpectedDate(expectedDate));

		// % protected region % [Add any additional logic for findByExpectedDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExpectedDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Price VAT Included.
	 *
	 * @param priceVATIncluded the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Price VAT Included
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByPriceVATIncluded(Boolean priceVATIncluded)
	// % protected region % [Add any throwables, implementations, or extensions for findByPriceVATIncluded here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPriceVATIncluded here] end
	{
		// % protected region % [Add any additional logic for findByPriceVATIncluded before the main body here] off begin
		// % protected region % [Add any additional logic for findByPriceVATIncluded before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByPriceVATIncluded(priceVATIncluded));

		// % protected region % [Add any additional logic for findByPriceVATIncluded before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPriceVATIncluded before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inventory VAT Included.
	 *
	 * @param inventoryVATIncluded the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory VAT Included
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByInventoryVATIncluded(Boolean inventoryVATIncluded)
	// % protected region % [Add any throwables, implementations, or extensions for findByInventoryVATIncluded here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInventoryVATIncluded here] end
	{
		// % protected region % [Add any additional logic for findByInventoryVATIncluded before the main body here] off begin
		// % protected region % [Add any additional logic for findByInventoryVATIncluded before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByInventoryVATIncluded(inventoryVATIncluded));

		// % protected region % [Add any additional logic for findByInventoryVATIncluded before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInventoryVATIncluded before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Reference Document.
	 *
	 * @param referenceDocument the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Reference Document
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByReferenceDocument(String referenceDocument)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferenceDocument here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferenceDocument here] end
	{
		// % protected region % [Add any additional logic for findByReferenceDocument before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferenceDocument before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByReferenceDocument(referenceDocument));

		// % protected region % [Add any additional logic for findByReferenceDocument before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferenceDocument before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Supplier Reference Document.
	 *
	 * @param supplierReferenceDocument the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supplier Reference Document
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findBySupplierReferenceDocument(String supplierReferenceDocument)
	// % protected region % [Add any throwables, implementations, or extensions for findBySupplierReferenceDocument here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySupplierReferenceDocument here] end
	{
		// % protected region % [Add any additional logic for findBySupplierReferenceDocument before the main body here] off begin
		// % protected region % [Add any additional logic for findBySupplierReferenceDocument before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findBySupplierReferenceDocument(supplierReferenceDocument));

		// % protected region % [Add any additional logic for findBySupplierReferenceDocument before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySupplierReferenceDocument before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Payment Terms.
	 *
	 * @param paymentTerms the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Payment Terms
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByPaymentTerms(String paymentTerms)
	// % protected region % [Add any throwables, implementations, or extensions for findByPaymentTerms here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPaymentTerms here] end
	{
		// % protected region % [Add any additional logic for findByPaymentTerms before the main body here] off begin
		// % protected region % [Add any additional logic for findByPaymentTerms before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByPaymentTerms(paymentTerms));

		// % protected region % [Add any additional logic for findByPaymentTerms before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPaymentTerms before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Shipping Method.
	 *
	 * @param shippingMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Shipping Method
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByShippingMethod(String shippingMethod)
	// % protected region % [Add any throwables, implementations, or extensions for findByShippingMethod here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByShippingMethod here] end
	{
		// % protected region % [Add any additional logic for findByShippingMethod before the main body here] off begin
		// % protected region % [Add any additional logic for findByShippingMethod before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByShippingMethod(shippingMethod));

		// % protected region % [Add any additional logic for findByShippingMethod before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByShippingMethod before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sub Total.
	 *
	 * @param subTotal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sub Total
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findBySubTotal(Double subTotal)
	// % protected region % [Add any throwables, implementations, or extensions for findBySubTotal here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySubTotal here] end
	{
		// % protected region % [Add any additional logic for findBySubTotal before the main body here] off begin
		// % protected region % [Add any additional logic for findBySubTotal before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findBySubTotal(subTotal));

		// % protected region % [Add any additional logic for findBySubTotal before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySubTotal before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Extra Discount In Percent.
	 *
	 * @param extraDiscountInPercent the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Extra Discount In Percent
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByExtraDiscountInPercent(Boolean extraDiscountInPercent)
	// % protected region % [Add any throwables, implementations, or extensions for findByExtraDiscountInPercent here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExtraDiscountInPercent here] end
	{
		// % protected region % [Add any additional logic for findByExtraDiscountInPercent before the main body here] off begin
		// % protected region % [Add any additional logic for findByExtraDiscountInPercent before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByExtraDiscountInPercent(extraDiscountInPercent));

		// % protected region % [Add any additional logic for findByExtraDiscountInPercent before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExtraDiscountInPercent before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Extra Discount Include Tax.
	 *
	 * @param extraDiscountIncludeTax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Extra Discount Include Tax
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByExtraDiscountIncludeTax(Boolean extraDiscountIncludeTax)
	// % protected region % [Add any throwables, implementations, or extensions for findByExtraDiscountIncludeTax here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExtraDiscountIncludeTax here] end
	{
		// % protected region % [Add any additional logic for findByExtraDiscountIncludeTax before the main body here] off begin
		// % protected region % [Add any additional logic for findByExtraDiscountIncludeTax before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByExtraDiscountIncludeTax(extraDiscountIncludeTax));

		// % protected region % [Add any additional logic for findByExtraDiscountIncludeTax before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExtraDiscountIncludeTax before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Extra Discount Value.
	 *
	 * @param extraDiscountValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Extra Discount Value
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByExtraDiscountValue(Double extraDiscountValue)
	// % protected region % [Add any throwables, implementations, or extensions for findByExtraDiscountValue here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExtraDiscountValue here] end
	{
		// % protected region % [Add any additional logic for findByExtraDiscountValue before the main body here] off begin
		// % protected region % [Add any additional logic for findByExtraDiscountValue before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByExtraDiscountValue(extraDiscountValue));

		// % protected region % [Add any additional logic for findByExtraDiscountValue before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExtraDiscountValue before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Freight Fee Include Tax.
	 *
	 * @param freightFeeIncludeTax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Freight Fee Include Tax
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByFreightFeeIncludeTax(Boolean freightFeeIncludeTax)
	// % protected region % [Add any throwables, implementations, or extensions for findByFreightFeeIncludeTax here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFreightFeeIncludeTax here] end
	{
		// % protected region % [Add any additional logic for findByFreightFeeIncludeTax before the main body here] off begin
		// % protected region % [Add any additional logic for findByFreightFeeIncludeTax before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByFreightFeeIncludeTax(freightFeeIncludeTax));

		// % protected region % [Add any additional logic for findByFreightFeeIncludeTax before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFreightFeeIncludeTax before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Freight Fee Value.
	 *
	 * @param freightFeeValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Freight Fee Value
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByFreightFeeValue(Double freightFeeValue)
	// % protected region % [Add any throwables, implementations, or extensions for findByFreightFeeValue here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFreightFeeValue here] end
	{
		// % protected region % [Add any additional logic for findByFreightFeeValue before the main body here] off begin
		// % protected region % [Add any additional logic for findByFreightFeeValue before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByFreightFeeValue(freightFeeValue));

		// % protected region % [Add any additional logic for findByFreightFeeValue before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFreightFeeValue before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Other Fee Include Tax.
	 *
	 * @param otherFeeIncludeTax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Fee Include Tax
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByOtherFeeIncludeTax(Boolean otherFeeIncludeTax)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherFeeIncludeTax here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherFeeIncludeTax here] end
	{
		// % protected region % [Add any additional logic for findByOtherFeeIncludeTax before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtherFeeIncludeTax before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByOtherFeeIncludeTax(otherFeeIncludeTax));

		// % protected region % [Add any additional logic for findByOtherFeeIncludeTax before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtherFeeIncludeTax before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Other Fee Value.
	 *
	 * @param otherFeeValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Fee Value
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByOtherFeeValue(Double otherFeeValue)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherFeeValue here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherFeeValue here] end
	{
		// % protected region % [Add any additional logic for findByOtherFeeValue before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtherFeeValue before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByOtherFeeValue(otherFeeValue));

		// % protected region % [Add any additional logic for findByOtherFeeValue before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtherFeeValue before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tax Base.
	 *
	 * @param taxBase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax Base
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByTaxBase(Double taxBase)
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxBase here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxBase here] end
	{
		// % protected region % [Add any additional logic for findByTaxBase before the main body here] off begin
		// % protected region % [Add any additional logic for findByTaxBase before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByTaxBase(taxBase));

		// % protected region % [Add any additional logic for findByTaxBase before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTaxBase before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tax Amount.
	 *
	 * @param taxAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax Amount
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByTaxAmount(Double taxAmount)
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxAmount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxAmount here] end
	{
		// % protected region % [Add any additional logic for findByTaxAmount before the main body here] off begin
		// % protected region % [Add any additional logic for findByTaxAmount before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByTaxAmount(taxAmount));

		// % protected region % [Add any additional logic for findByTaxAmount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTaxAmount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Amount.
	 *
	 * @param totalAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Amount
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findByTotalAmount(Double totalAmount)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalAmount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalAmount here] end
	{
		// % protected region % [Add any additional logic for findByTotalAmount before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalAmount before the main body here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findByTotalAmount(totalAmount));

		// % protected region % [Add any additional logic for findByTotalAmount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalAmount before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PurchaseOrderEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<PurchaseOrderEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<PurchaseOrderEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<PurchaseOrderEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'create')")
	public PurchaseOrderEntity create(PurchaseOrderEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		PurchaseOrderEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'create')")
	public PurchaseOrderEntity create(PurchaseOrderEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		PurchaseOrderEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		PurchaseOrderEntity newEntity;

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
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'create')")
	public List<PurchaseOrderEntity> createAll(Iterable<PurchaseOrderEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<PurchaseOrderEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<PurchaseOrderEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'update')")
	public PurchaseOrderEntity update(PurchaseOrderEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		PurchaseOrderEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'update')")
	public PurchaseOrderEntity update(PurchaseOrderEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		PurchaseOrderEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		PurchaseOrderEntity newEntity;

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
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'update')")
	public List<PurchaseOrderEntity> updateAll(Iterable<PurchaseOrderEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<PurchaseOrderEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<PurchaseOrderEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'create') or hasPermission('PurchaseOrderEntity', 'update')")
	public PurchaseOrderEntity save(PurchaseOrderEntity entity) throws ConstraintViolationException
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

		PurchaseOrderEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'create') or hasPermission('PurchaseOrderEntity', 'update')")
	public List<PurchaseOrderEntity> saveAll(Iterable<PurchaseOrderEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<PurchaseOrderEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	public List<PurchaseOrderEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	public List<PurchaseOrderEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(PurchaseOrderEntity.class);

		// % protected region % [Add any additional processing before converting to a list of PurchaseOrderEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of PurchaseOrderEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PurchaseOrderEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of PurchaseOrderEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of PurchaseOrderEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(PurchaseOrderEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of PurchaseOrderEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of PurchaseOrderEntityAudits
	 */
	private List<PurchaseOrderEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<PurchaseOrderEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param purchaseOrder purchaseOrder to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private PurchaseOrderEntity updateAuditData(PurchaseOrderEntity purchaseOrder)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return purchaseOrder;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private PurchaseOrderEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		PurchaseOrderEntity entityAtRevision = updateAuditData((PurchaseOrderEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new PurchaseOrderEntityAudit(
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

		QPurchaseOrderEntity entity = QPurchaseOrderEntity.purchaseOrderEntity;

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
			case "goodsReceiveNoteId":
				// % protected region % [Add any additional logic before the query parameters of relation from Goods Receive Note to Purchase Orders here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Goods Receive Note to Purchase Orders here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.goodsReceiveNote.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Goods Receive Note to Purchase Orders here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Goods Receive Note to Purchase Orders here] end

				break;
			case "supplierId":
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Purchase Orders here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Purchase Orders here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.supplier.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Purchase Orders here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Purchase Orders here] end

				break;
			case "warehouseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Purchase Orders here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Purchase Orders here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.warehouse.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Purchase Orders here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Purchase Orders here] end

				break;
			case "purchaseOrderStockDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Order to Purchase Order Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Order to Purchase Order Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseOrderStockDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Order to Purchase Order Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Order to Purchase Order Stock Details here] end

				break;
			case "purchaseRequisitionsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Order to Purchase Requisitions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Order to Purchase Requisitions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseRequisitions.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Order to Purchase Requisitions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Order to Purchase Requisitions here] end

				break;
			case "returnSuppliersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Order to Return Suppliers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Order to Return Suppliers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.returnSuppliers.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Order to Return Suppliers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Order to Return Suppliers here] end

				break;
			case "purchaseOrderType":
				// % protected region % [Add any additional logic before the query parameters of purchaseOrderType here] off begin
				// % protected region % [Add any additional logic before the query parameters of purchaseOrderType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseOrderType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of purchaseOrderType here] off begin
				// % protected region % [Add any additional logic after the query parameters of purchaseOrderType here] end

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
	public PurchaseOrderEntity updateOldData(PurchaseOrderEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public PurchaseOrderEntity updateOldData(PurchaseOrderEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		PurchaseOrderEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInPurchaseOrderEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getPriceVATIncluded() == null) {
			entityToUpdate.setPriceVATIncluded(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getInventoryVATIncluded() == null) {
			entityToUpdate.setInventoryVATIncluded(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getExtraDiscountInPercent() == null) {
			entityToUpdate.setExtraDiscountInPercent(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getExtraDiscountIncludeTax() == null) {
			entityToUpdate.setExtraDiscountIncludeTax(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getFreightFeeIncludeTax() == null) {
			entityToUpdate.setFreightFeeIncludeTax(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOtherFeeIncludeTax() == null) {
			entityToUpdate.setOtherFeeIncludeTax(false);
		}

		// Incoming One to Many reference
		if (entity.getGoodsReceiveNote() == null && entity.getGoodsReceiveNoteId() == null) {
			entityToUpdate.unsetGoodsReceiveNote();
		} else if (entity.getGoodsReceiveNoteId() != null && entity.getGoodsReceiveNote() == null) {
			Optional<GoodsReceiveNoteEntity> goodsReceiveNoteEntity = this.goodsReceiveNoteRepository.findById(entity.getGoodsReceiveNoteId());
			entityToUpdate.setGoodsReceiveNote(goodsReceiveNoteEntity.orElseThrow());
		}
		if (persistRelations && entity.getGoodsReceiveNote() != null) {
			entityToUpdate.setGoodsReceiveNote(entity.getGoodsReceiveNote(), false);
			if (entityToUpdate.getGoodsReceiveNoteId() != null) {
				this.goodsReceiveNoteRepository.save(entityToUpdate.getGoodsReceiveNote());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getGoodsReceiveNote().unsetPurchaseOrders();
			}
		}

		// Incoming One to Many reference
		if (entity.getSupplier() == null && entity.getSupplierId() == null) {
			entityToUpdate.unsetSupplier();
		} else if (entity.getSupplierId() != null && entity.getSupplier() == null) {
			Optional<SupplierEntity> supplierEntity = this.supplierRepository.findById(entity.getSupplierId());
			entityToUpdate.setSupplier(supplierEntity.orElseThrow());
		}
		if (persistRelations && entity.getSupplier() != null) {
			entityToUpdate.setSupplier(entity.getSupplier(), false);
			if (entityToUpdate.getSupplierId() != null) {
				this.supplierRepository.save(entityToUpdate.getSupplier());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getSupplier().unsetPurchaseOrders();
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
				entityToUpdate.getWarehouse().unsetPurchaseOrders();
			}
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
	public void validateEntity(PurchaseOrderEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<PurchaseOrderEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
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
	 * Get the sort as given by the sort by for the PurchaseOrderEntity.
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

	public Set<String> validateEntityRelations(PurchaseOrderEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getGoodsReceiveNoteId() != null && this.goodsReceiveNoteRepository.findById(entity.getGoodsReceiveNoteId()).isEmpty()) {
			errors.add("The UUID " + entity.getGoodsReceiveNoteId() + " is not associated with a Goods Receive Note Entity");
		}

		if (entity.getSupplierId() != null && this.supplierRepository.findById(entity.getSupplierId()).isEmpty()) {
			errors.add("The UUID " + entity.getSupplierId() + " is not associated with a Supplier Entity");
		}

		if (entity.getWarehouseId() != null && this.warehouseRepository.findById(entity.getWarehouseId()).isEmpty()) {
			errors.add("The UUID " + entity.getWarehouseId() + " is not associated with a Warehouse Entity");
		}

		for (UUID id : entity.getPurchaseOrderStockDetailsIds()) {
			if (this.purchaseOrderStockDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Purchase Order Stock Detail Entity");
			}
		}

		for (UUID id : entity.getPurchaseRequisitionsIds()) {
			if (this.purchaseRequisitionRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Purchase Requisition Entity");
			}
		}

		for (UUID id : entity.getReturnSuppliersIds()) {
			if (this.returnSupplierRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Return Supplier Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
