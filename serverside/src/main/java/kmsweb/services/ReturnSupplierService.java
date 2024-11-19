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
import kmsweb.repositories.ReturnSupplierRepository;
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
import kmsweb.entities.PurchaseOrderEntity;
import kmsweb.repositories.PurchaseOrderRepository;
import kmsweb.entities.ReturnSupplierStockDetailEntity;
import kmsweb.repositories.ReturnSupplierStockDetailRepository;
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
public class ReturnSupplierService extends AbstractService<ReturnSupplierEntity, ReturnSupplierRepository, ReturnSupplierEntityAudit> {

	private final String[] referenceNamesInReturnSupplierEntity = {
		"returnSupplierStockDetails",
		"purchaseOrder",
		"supplier",
		"warehouse",
	};

	private final PurchaseOrderRepository purchaseOrderRepository;

	private final ReturnSupplierStockDetailRepository returnSupplierStockDetailRepository;

	private final SupplierRepository supplierRepository;

	private final WarehouseRepository warehouseRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public ReturnSupplierService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		PurchaseOrderRepository purchaseOrderRepository,
		ReturnSupplierStockDetailRepository returnSupplierStockDetailRepository,
		SupplierRepository supplierRepository,
		WarehouseRepository warehouseRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		ReturnSupplierRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.purchaseOrderRepository = purchaseOrderRepository;

		this.returnSupplierStockDetailRepository = returnSupplierStockDetailRepository;

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
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
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
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Return Number.
	 *
	 * @param returnNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Return Number
	 */
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByReturnNumber(String returnNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByReturnNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReturnNumber here] end
	{
		// % protected region % [Add any additional logic for findByReturnNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByReturnNumber before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByReturnNumber(returnNumber));

		// % protected region % [Add any additional logic for findByReturnNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReturnNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Approval Status.
	 *
	 * @param approvalStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Status
	 */
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByApprovalStatus(String approvalStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalStatus here] end
	{
		// % protected region % [Add any additional logic for findByApprovalStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByApprovalStatus before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByApprovalStatus(approvalStatus));

		// % protected region % [Add any additional logic for findByApprovalStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApprovalStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Return Date.
	 *
	 * @param returnDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Return Date
	 */
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByReturnDate(OffsetDateTime returnDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByReturnDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReturnDate here] end
	{
		// % protected region % [Add any additional logic for findByReturnDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByReturnDate before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByReturnDate(returnDate));

		// % protected region % [Add any additional logic for findByReturnDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReturnDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Order Date.
	 *
	 * @param orderDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Order Date
	 */
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByOrderDate(OffsetDateTime orderDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByOrderDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOrderDate here] end
	{
		// % protected region % [Add any additional logic for findByOrderDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByOrderDate before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByOrderDate(orderDate));

		// % protected region % [Add any additional logic for findByOrderDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOrderDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Return Number.
	 *
	 * @param invoiceReturnNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Return Number
	 */
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByInvoiceReturnNumber(String invoiceReturnNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceReturnNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceReturnNumber here] end
	{
		// % protected region % [Add any additional logic for findByInvoiceReturnNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByInvoiceReturnNumber before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByInvoiceReturnNumber(invoiceReturnNumber));

		// % protected region % [Add any additional logic for findByInvoiceReturnNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInvoiceReturnNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tax Invoice Number.
	 *
	 * @param taxInvoiceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax Invoice Number
	 */
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByTaxInvoiceNumber(String taxInvoiceNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxInvoiceNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxInvoiceNumber here] end
	{
		// % protected region % [Add any additional logic for findByTaxInvoiceNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByTaxInvoiceNumber before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByTaxInvoiceNumber(taxInvoiceNumber));

		// % protected region % [Add any additional logic for findByTaxInvoiceNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTaxInvoiceNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Price VAT Included.
	 *
	 * @param priceVATIncluded the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Price VAT Included
	 */
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByPriceVATIncluded(Boolean priceVATIncluded)
	// % protected region % [Add any throwables, implementations, or extensions for findByPriceVATIncluded here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPriceVATIncluded here] end
	{
		// % protected region % [Add any additional logic for findByPriceVATIncluded before the main body here] off begin
		// % protected region % [Add any additional logic for findByPriceVATIncluded before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByPriceVATIncluded(priceVATIncluded));

		// % protected region % [Add any additional logic for findByPriceVATIncluded before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPriceVATIncluded before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Void Date.
	 *
	 * @param voidDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Void Date
	 */
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByVoidDate(OffsetDateTime voidDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByVoidDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVoidDate here] end
	{
		// % protected region % [Add any additional logic for findByVoidDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByVoidDate before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByVoidDate(voidDate));

		// % protected region % [Add any additional logic for findByVoidDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVoidDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Void Reason.
	 *
	 * @param voidReason the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Void Reason
	 */
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByVoidReason(String voidReason)
	// % protected region % [Add any throwables, implementations, or extensions for findByVoidReason here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVoidReason here] end
	{
		// % protected region % [Add any additional logic for findByVoidReason before the main body here] off begin
		// % protected region % [Add any additional logic for findByVoidReason before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByVoidReason(voidReason));

		// % protected region % [Add any additional logic for findByVoidReason before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVoidReason before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sub Total.
	 *
	 * @param subTotal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sub Total
	 */
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findBySubTotal(Double subTotal)
	// % protected region % [Add any throwables, implementations, or extensions for findBySubTotal here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySubTotal here] end
	{
		// % protected region % [Add any additional logic for findBySubTotal before the main body here] off begin
		// % protected region % [Add any additional logic for findBySubTotal before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findBySubTotal(subTotal));

		// % protected region % [Add any additional logic for findBySubTotal before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySubTotal before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Extra Discount In Percentage.
	 *
	 * @param extraDiscountInPercentage the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Extra Discount In Percentage
	 */
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByExtraDiscountInPercentage(Boolean extraDiscountInPercentage)
	// % protected region % [Add any throwables, implementations, or extensions for findByExtraDiscountInPercentage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExtraDiscountInPercentage here] end
	{
		// % protected region % [Add any additional logic for findByExtraDiscountInPercentage before the main body here] off begin
		// % protected region % [Add any additional logic for findByExtraDiscountInPercentage before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByExtraDiscountInPercentage(extraDiscountInPercentage));

		// % protected region % [Add any additional logic for findByExtraDiscountInPercentage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExtraDiscountInPercentage before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Extra Discount Include Tax.
	 *
	 * @param extraDiscountIncludeTax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Extra Discount Include Tax
	 */
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByExtraDiscountIncludeTax(Boolean extraDiscountIncludeTax)
	// % protected region % [Add any throwables, implementations, or extensions for findByExtraDiscountIncludeTax here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExtraDiscountIncludeTax here] end
	{
		// % protected region % [Add any additional logic for findByExtraDiscountIncludeTax before the main body here] off begin
		// % protected region % [Add any additional logic for findByExtraDiscountIncludeTax before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByExtraDiscountIncludeTax(extraDiscountIncludeTax));

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
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByExtraDiscountValue(Double extraDiscountValue)
	// % protected region % [Add any throwables, implementations, or extensions for findByExtraDiscountValue here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExtraDiscountValue here] end
	{
		// % protected region % [Add any additional logic for findByExtraDiscountValue before the main body here] off begin
		// % protected region % [Add any additional logic for findByExtraDiscountValue before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByExtraDiscountValue(extraDiscountValue));

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
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByFreightFeeIncludeTax(Boolean freightFeeIncludeTax)
	// % protected region % [Add any throwables, implementations, or extensions for findByFreightFeeIncludeTax here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFreightFeeIncludeTax here] end
	{
		// % protected region % [Add any additional logic for findByFreightFeeIncludeTax before the main body here] off begin
		// % protected region % [Add any additional logic for findByFreightFeeIncludeTax before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByFreightFeeIncludeTax(freightFeeIncludeTax));

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
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByFreightFeeValue(Double freightFeeValue)
	// % protected region % [Add any throwables, implementations, or extensions for findByFreightFeeValue here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFreightFeeValue here] end
	{
		// % protected region % [Add any additional logic for findByFreightFeeValue before the main body here] off begin
		// % protected region % [Add any additional logic for findByFreightFeeValue before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByFreightFeeValue(freightFeeValue));

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
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByOtherFeeIncludeTax(Boolean otherFeeIncludeTax)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherFeeIncludeTax here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherFeeIncludeTax here] end
	{
		// % protected region % [Add any additional logic for findByOtherFeeIncludeTax before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtherFeeIncludeTax before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByOtherFeeIncludeTax(otherFeeIncludeTax));

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
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByOtherFeeValue(Double otherFeeValue)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherFeeValue here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherFeeValue here] end
	{
		// % protected region % [Add any additional logic for findByOtherFeeValue before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtherFeeValue before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByOtherFeeValue(otherFeeValue));

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
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByTaxBase(Double taxBase)
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxBase here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxBase here] end
	{
		// % protected region % [Add any additional logic for findByTaxBase before the main body here] off begin
		// % protected region % [Add any additional logic for findByTaxBase before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByTaxBase(taxBase));

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
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByTaxAmount(Double taxAmount)
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxAmount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxAmount here] end
	{
		// % protected region % [Add any additional logic for findByTaxAmount before the main body here] off begin
		// % protected region % [Add any additional logic for findByTaxAmount before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByTaxAmount(taxAmount));

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
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findByTotalAmount(Double totalAmount)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalAmount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalAmount here] end
	{
		// % protected region % [Add any additional logic for findByTotalAmount before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalAmount before the main body here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findByTotalAmount(totalAmount));

		// % protected region % [Add any additional logic for findByTotalAmount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalAmount before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<ReturnSupplierEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<ReturnSupplierEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<ReturnSupplierEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<ReturnSupplierEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'create')")
	public ReturnSupplierEntity create(ReturnSupplierEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		ReturnSupplierEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'create')")
	public ReturnSupplierEntity create(ReturnSupplierEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		ReturnSupplierEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		ReturnSupplierEntity newEntity;

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
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'create')")
	public List<ReturnSupplierEntity> createAll(Iterable<ReturnSupplierEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<ReturnSupplierEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<ReturnSupplierEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'update')")
	public ReturnSupplierEntity update(ReturnSupplierEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		ReturnSupplierEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'update')")
	public ReturnSupplierEntity update(ReturnSupplierEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		ReturnSupplierEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		ReturnSupplierEntity newEntity;

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
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'update')")
	public List<ReturnSupplierEntity> updateAll(Iterable<ReturnSupplierEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<ReturnSupplierEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<ReturnSupplierEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'create') or hasPermission('ReturnSupplierEntity', 'update')")
	public ReturnSupplierEntity save(ReturnSupplierEntity entity) throws ConstraintViolationException
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

		ReturnSupplierEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'create') or hasPermission('ReturnSupplierEntity', 'update')")
	public List<ReturnSupplierEntity> saveAll(Iterable<ReturnSupplierEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<ReturnSupplierEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'delete')")
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
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'delete')")
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
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	public List<ReturnSupplierEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	public List<ReturnSupplierEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(ReturnSupplierEntity.class);

		// % protected region % [Add any additional processing before converting to a list of ReturnSupplierEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of ReturnSupplierEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<ReturnSupplierEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of ReturnSupplierEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of ReturnSupplierEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(ReturnSupplierEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of ReturnSupplierEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of ReturnSupplierEntityAudits
	 */
	private List<ReturnSupplierEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<ReturnSupplierEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param returnSupplier returnSupplier to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private ReturnSupplierEntity updateAuditData(ReturnSupplierEntity returnSupplier)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return returnSupplier;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private ReturnSupplierEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		ReturnSupplierEntity entityAtRevision = updateAuditData((ReturnSupplierEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new ReturnSupplierEntityAudit(
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

		QReturnSupplierEntity entity = QReturnSupplierEntity.returnSupplierEntity;

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
			case "purchaseOrderId":
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Order to Return Suppliers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Order to Return Suppliers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseOrder.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Order to Return Suppliers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Order to Return Suppliers here] end

				break;
			case "supplierId":
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Return Suppliers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Return Suppliers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.supplier.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Return Suppliers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Return Suppliers here] end

				break;
			case "warehouseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Return Suppliers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Return Suppliers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.warehouse.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Return Suppliers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Return Suppliers here] end

				break;
			case "returnSupplierStockDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Return Supplier to Return Supplier Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Return Supplier to Return Supplier Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.returnSupplierStockDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Return Supplier to Return Supplier Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Return Supplier to Return Supplier Stock Details here] end

				break;
			case "invoiceReturnNumber":
				// % protected region % [Add any additional logic before the query parameters of invoiceReturnNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of invoiceReturnNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceReturnNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of invoiceReturnNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of invoiceReturnNumber here] end

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
	public ReturnSupplierEntity updateOldData(ReturnSupplierEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public ReturnSupplierEntity updateOldData(ReturnSupplierEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		ReturnSupplierEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInReturnSupplierEntity);

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
		if (entityToUpdate.getExtraDiscountInPercentage() == null) {
			entityToUpdate.setExtraDiscountInPercentage(false);
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
		if (entity.getPurchaseOrder() == null && entity.getPurchaseOrderId() == null) {
			entityToUpdate.unsetPurchaseOrder();
		} else if (entity.getPurchaseOrderId() != null && entity.getPurchaseOrder() == null) {
			Optional<PurchaseOrderEntity> purchaseOrderEntity = this.purchaseOrderRepository.findById(entity.getPurchaseOrderId());
			entityToUpdate.setPurchaseOrder(purchaseOrderEntity.orElseThrow());
		}
		if (persistRelations && entity.getPurchaseOrder() != null) {
			entityToUpdate.setPurchaseOrder(entity.getPurchaseOrder(), false);
			if (entityToUpdate.getPurchaseOrderId() != null) {
				this.purchaseOrderRepository.save(entityToUpdate.getPurchaseOrder());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPurchaseOrder().unsetReturnSuppliers();
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
				entityToUpdate.getSupplier().unsetReturnSuppliers();
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
				entityToUpdate.getWarehouse().unsetReturnSuppliers();
			}
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
	public void validateEntity(ReturnSupplierEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<ReturnSupplierEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the ReturnSupplierEntity.
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

	public Set<String> validateEntityRelations(ReturnSupplierEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getPurchaseOrderId() != null && this.purchaseOrderRepository.findById(entity.getPurchaseOrderId()).isEmpty()) {
			errors.add("The UUID " + entity.getPurchaseOrderId() + " is not associated with a Purchase Order Entity");
		}

		if (entity.getSupplierId() != null && this.supplierRepository.findById(entity.getSupplierId()).isEmpty()) {
			errors.add("The UUID " + entity.getSupplierId() + " is not associated with a Supplier Entity");
		}

		if (entity.getWarehouseId() != null && this.warehouseRepository.findById(entity.getWarehouseId()).isEmpty()) {
			errors.add("The UUID " + entity.getWarehouseId() + " is not associated with a Warehouse Entity");
		}

		for (UUID id : entity.getReturnSupplierStockDetailsIds()) {
			if (this.returnSupplierStockDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Return Supplier Stock Detail Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
