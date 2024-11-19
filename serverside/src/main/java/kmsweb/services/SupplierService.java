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
import kmsweb.repositories.SupplierRepository;
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
import kmsweb.entities.PurchaseOrderEntity;
import kmsweb.repositories.PurchaseOrderRepository;
import kmsweb.entities.PurchaseRequisitionEntity;
import kmsweb.repositories.PurchaseRequisitionRepository;
import kmsweb.entities.ReturnSupplierEntity;
import kmsweb.repositories.ReturnSupplierRepository;
import kmsweb.entities.SupplierBankAccountEntity;
import kmsweb.repositories.SupplierBankAccountRepository;
import kmsweb.entities.SupplierContactDetailEntity;
import kmsweb.repositories.SupplierContactDetailRepository;
import kmsweb.entities.SupplierProductDetailEntity;
import kmsweb.repositories.SupplierProductDetailRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class SupplierService extends AbstractService<SupplierEntity, SupplierRepository, SupplierEntityAudit> {

	private final String[] referenceNamesInSupplierEntity = {
		"goodsReceiveNotes",
		"purchaseOrders",
		"purchaseRequisitions",
		"returnSuppliers",
		"suplierContactDetails",
		"supplierBankAccounts",
		"supplierProductDetails",
	};

	private final GoodsReceiveNoteRepository goodsReceiveNoteRepository;

	private final PurchaseOrderRepository purchaseOrderRepository;

	private final PurchaseRequisitionRepository purchaseRequisitionRepository;

	private final ReturnSupplierRepository returnSupplierRepository;

	private final SupplierBankAccountRepository supplierBankAccountRepository;

	private final SupplierContactDetailRepository supplierContactDetailRepository;

	private final SupplierProductDetailRepository supplierProductDetailRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public SupplierService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		GoodsReceiveNoteRepository goodsReceiveNoteRepository,
		PurchaseOrderRepository purchaseOrderRepository,
		PurchaseRequisitionRepository purchaseRequisitionRepository,
		ReturnSupplierRepository returnSupplierRepository,
		SupplierBankAccountRepository supplierBankAccountRepository,
		SupplierContactDetailRepository supplierContactDetailRepository,
		SupplierProductDetailRepository supplierProductDetailRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		SupplierRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.goodsReceiveNoteRepository = goodsReceiveNoteRepository;

		this.purchaseOrderRepository = purchaseOrderRepository;

		this.purchaseRequisitionRepository = purchaseRequisitionRepository;

		this.returnSupplierRepository = returnSupplierRepository;

		this.supplierBankAccountRepository = supplierBankAccountRepository;

		this.supplierContactDetailRepository = supplierContactDetailRepository;

		this.supplierProductDetailRepository = supplierProductDetailRepository;

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
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
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
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Supplier Number.
	 *
	 * @param supplierNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supplier Number
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<SupplierEntity> findBySupplierNumber(String supplierNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findBySupplierNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySupplierNumber here] end
	{
		// % protected region % [Add any additional logic for findBySupplierNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findBySupplierNumber before the main body here] end

		Optional<SupplierEntity> entity = repository.findBySupplierNumber(supplierNumber);

		// % protected region % [Add any additional logic for findBySupplierNumber before returning the entity here] off begin
		// % protected region % [Add any additional logic for findBySupplierNumber before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Supplier Name.
	 *
	 * @param supplierName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supplier Name
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findBySupplierName(String supplierName)
	// % protected region % [Add any throwables, implementations, or extensions for findBySupplierName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySupplierName here] end
	{
		// % protected region % [Add any additional logic for findBySupplierName before the main body here] off begin
		// % protected region % [Add any additional logic for findBySupplierName before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findBySupplierName(supplierName));

		// % protected region % [Add any additional logic for findBySupplierName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySupplierName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tax ID.
	 *
	 * @param taxID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax ID
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByTaxID(String taxID)
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxID here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxID here] end
	{
		// % protected region % [Add any additional logic for findByTaxID before the main body here] off begin
		// % protected region % [Add any additional logic for findByTaxID before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByTaxID(taxID));

		// % protected region % [Add any additional logic for findByTaxID before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTaxID before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Supply Stock Group.
	 *
	 * @param supplyStockGroup the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supply Stock Group
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findBySupplyStockGroup(String supplyStockGroup)
	// % protected region % [Add any throwables, implementations, or extensions for findBySupplyStockGroup here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySupplyStockGroup here] end
	{
		// % protected region % [Add any additional logic for findBySupplyStockGroup before the main body here] off begin
		// % protected region % [Add any additional logic for findBySupplyStockGroup before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findBySupplyStockGroup(supplyStockGroup));

		// % protected region % [Add any additional logic for findBySupplyStockGroup before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySupplyStockGroup before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Adress.
	 *
	 * @param adress the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Adress
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByAdress(String adress)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdress here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdress here] end
	{
		// % protected region % [Add any additional logic for findByAdress before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdress before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByAdress(adress));

		// % protected region % [Add any additional logic for findByAdress before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdress before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Country.
	 *
	 * @param country the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Country
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByCountry(String country)
	// % protected region % [Add any throwables, implementations, or extensions for findByCountry here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCountry here] end
	{
		// % protected region % [Add any additional logic for findByCountry before the main body here] off begin
		// % protected region % [Add any additional logic for findByCountry before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByCountry(country));

		// % protected region % [Add any additional logic for findByCountry before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCountry before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute State Province.
	 *
	 * @param stateProvince the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute State Province
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByStateProvince(String stateProvince)
	// % protected region % [Add any throwables, implementations, or extensions for findByStateProvince here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStateProvince here] end
	{
		// % protected region % [Add any additional logic for findByStateProvince before the main body here] off begin
		// % protected region % [Add any additional logic for findByStateProvince before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByStateProvince(stateProvince));

		// % protected region % [Add any additional logic for findByStateProvince before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStateProvince before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute City.
	 *
	 * @param city the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute City
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByCity(String city)
	// % protected region % [Add any throwables, implementations, or extensions for findByCity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCity here] end
	{
		// % protected region % [Add any additional logic for findByCity before the main body here] off begin
		// % protected region % [Add any additional logic for findByCity before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByCity(city));

		// % protected region % [Add any additional logic for findByCity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Postal Code.
	 *
	 * @param postalCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Postal Code
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByPostalCode(String postalCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByPostalCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPostalCode here] end
	{
		// % protected region % [Add any additional logic for findByPostalCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByPostalCode before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByPostalCode(postalCode));

		// % protected region % [Add any additional logic for findByPostalCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPostalCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Phone Number.
	 *
	 * @param phoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Phone Number
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByPhoneNumber(String phoneNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByPhoneNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPhoneNumber here] end
	{
		// % protected region % [Add any additional logic for findByPhoneNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByPhoneNumber before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByPhoneNumber(phoneNumber));

		// % protected region % [Add any additional logic for findByPhoneNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPhoneNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Other Phone Number.
	 *
	 * @param otherPhoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Phone Number
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByOtherPhoneNumber(String otherPhoneNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherPhoneNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherPhoneNumber here] end
	{
		// % protected region % [Add any additional logic for findByOtherPhoneNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtherPhoneNumber before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByOtherPhoneNumber(otherPhoneNumber));

		// % protected region % [Add any additional logic for findByOtherPhoneNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtherPhoneNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Fax.
	 *
	 * @param fax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Fax
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByFax(String fax)
	// % protected region % [Add any throwables, implementations, or extensions for findByFax here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFax here] end
	{
		// % protected region % [Add any additional logic for findByFax before the main body here] off begin
		// % protected region % [Add any additional logic for findByFax before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByFax(fax));

		// % protected region % [Add any additional logic for findByFax before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFax before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByEmail(String email)
	// % protected region % [Add any throwables, implementations, or extensions for findByEmail here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEmail here] end
	{
		// % protected region % [Add any additional logic for findByEmail before the main body here] off begin
		// % protected region % [Add any additional logic for findByEmail before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByEmail(email));

		// % protected region % [Add any additional logic for findByEmail before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEmail before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Website.
	 *
	 * @param website the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Website
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByWebsite(String website)
	// % protected region % [Add any throwables, implementations, or extensions for findByWebsite here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWebsite here] end
	{
		// % protected region % [Add any additional logic for findByWebsite before the main body here] off begin
		// % protected region % [Add any additional logic for findByWebsite before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByWebsite(website));

		// % protected region % [Add any additional logic for findByWebsite before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWebsite before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Purchase Order Hold.
	 *
	 * @param purchaseOrderHold the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purchase Order Hold
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByPurchaseOrderHold(Boolean purchaseOrderHold)
	// % protected region % [Add any throwables, implementations, or extensions for findByPurchaseOrderHold here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPurchaseOrderHold here] end
	{
		// % protected region % [Add any additional logic for findByPurchaseOrderHold before the main body here] off begin
		// % protected region % [Add any additional logic for findByPurchaseOrderHold before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByPurchaseOrderHold(purchaseOrderHold));

		// % protected region % [Add any additional logic for findByPurchaseOrderHold before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPurchaseOrderHold before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Purchase Order Hold Reason.
	 *
	 * @param purchaseOrderHoldReason the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purchase Order Hold Reason
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByPurchaseOrderHoldReason(String purchaseOrderHoldReason)
	// % protected region % [Add any throwables, implementations, or extensions for findByPurchaseOrderHoldReason here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPurchaseOrderHoldReason here] end
	{
		// % protected region % [Add any additional logic for findByPurchaseOrderHoldReason before the main body here] off begin
		// % protected region % [Add any additional logic for findByPurchaseOrderHoldReason before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByPurchaseOrderHoldReason(purchaseOrderHoldReason));

		// % protected region % [Add any additional logic for findByPurchaseOrderHoldReason before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPurchaseOrderHoldReason before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute VAT Included.
	 *
	 * @param vatIncluded the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute VAT Included
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByVatIncluded(Boolean vatIncluded)
	// % protected region % [Add any throwables, implementations, or extensions for findByVatIncluded here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVatIncluded here] end
	{
		// % protected region % [Add any additional logic for findByVatIncluded before the main body here] off begin
		// % protected region % [Add any additional logic for findByVatIncluded before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByVatIncluded(vatIncluded));

		// % protected region % [Add any additional logic for findByVatIncluded before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVatIncluded before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Shipping Method.
	 *
	 * @param shippingMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Shipping Method
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByShippingMethod(String shippingMethod)
	// % protected region % [Add any throwables, implementations, or extensions for findByShippingMethod here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByShippingMethod here] end
	{
		// % protected region % [Add any additional logic for findByShippingMethod before the main body here] off begin
		// % protected region % [Add any additional logic for findByShippingMethod before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByShippingMethod(shippingMethod));

		// % protected region % [Add any additional logic for findByShippingMethod before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByShippingMethod before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Lead Time Minimum.
	 *
	 * @param leadTimeMinimum the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lead Time Minimum
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByLeadTimeMinimum(Double leadTimeMinimum)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeadTimeMinimum here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeadTimeMinimum here] end
	{
		// % protected region % [Add any additional logic for findByLeadTimeMinimum before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeadTimeMinimum before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByLeadTimeMinimum(leadTimeMinimum));

		// % protected region % [Add any additional logic for findByLeadTimeMinimum before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeadTimeMinimum before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Lead Time Maximum.
	 *
	 * @param leadTimeMaximum the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lead Time Maximum
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByLeadTimeMaximum(Double leadTimeMaximum)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeadTimeMaximum here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeadTimeMaximum here] end
	{
		// % protected region % [Add any additional logic for findByLeadTimeMaximum before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeadTimeMaximum before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByLeadTimeMaximum(leadTimeMaximum));

		// % protected region % [Add any additional logic for findByLeadTimeMaximum before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeadTimeMaximum before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Last Purchase Date.
	 *
	 * @param lastPurchaseDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Purchase Date
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByLastPurchaseDate(OffsetDateTime lastPurchaseDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByLastPurchaseDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLastPurchaseDate here] end
	{
		// % protected region % [Add any additional logic for findByLastPurchaseDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByLastPurchaseDate before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByLastPurchaseDate(lastPurchaseDate));

		// % protected region % [Add any additional logic for findByLastPurchaseDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLastPurchaseDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Last Purchase Order Number.
	 *
	 * @param lastPurchaseOrderNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Purchase Order Number
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByLastPurchaseOrderNumber(String lastPurchaseOrderNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByLastPurchaseOrderNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLastPurchaseOrderNumber here] end
	{
		// % protected region % [Add any additional logic for findByLastPurchaseOrderNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByLastPurchaseOrderNumber before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByLastPurchaseOrderNumber(lastPurchaseOrderNumber));

		// % protected region % [Add any additional logic for findByLastPurchaseOrderNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLastPurchaseOrderNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Lead Time Measurement.
	 *
	 * @param leadTimeMeasurement the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lead Time Measurement
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findByLeadTimeMeasurement(String leadTimeMeasurement)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeadTimeMeasurement here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeadTimeMeasurement here] end
	{
		// % protected region % [Add any additional logic for findByLeadTimeMeasurement before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeadTimeMeasurement before the main body here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findByLeadTimeMeasurement(leadTimeMeasurement));

		// % protected region % [Add any additional logic for findByLeadTimeMeasurement before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeadTimeMeasurement before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<SupplierEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<SupplierEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<SupplierEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SupplierEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<SupplierEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('SupplierEntity', 'create')")
	public SupplierEntity create(SupplierEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		SupplierEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('SupplierEntity', 'create')")
	public SupplierEntity create(SupplierEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		SupplierEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		SupplierEntity newEntity;

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
	@PreAuthorize("hasPermission('SupplierEntity', 'create')")
	public List<SupplierEntity> createAll(Iterable<SupplierEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<SupplierEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<SupplierEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('SupplierEntity', 'update')")
	public SupplierEntity update(SupplierEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		SupplierEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('SupplierEntity', 'update')")
	public SupplierEntity update(SupplierEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		SupplierEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		SupplierEntity newEntity;

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
	@PreAuthorize("hasPermission('SupplierEntity', 'update')")
	public List<SupplierEntity> updateAll(Iterable<SupplierEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<SupplierEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<SupplierEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('SupplierEntity', 'create') or hasPermission('SupplierEntity', 'update')")
	public SupplierEntity save(SupplierEntity entity) throws ConstraintViolationException
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

		SupplierEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('SupplierEntity', 'create') or hasPermission('SupplierEntity', 'update')")
	public List<SupplierEntity> saveAll(Iterable<SupplierEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<SupplierEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('SupplierEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('SupplierEntity', 'delete')")
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
	@PreAuthorize("hasPermission('SupplierEntity', 'delete')")
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
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	public List<SupplierEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	public List<SupplierEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<SupplierEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(SupplierEntity.class);

		// % protected region % [Add any additional processing before converting to a list of SupplierEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of SupplierEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('SupplierEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<SupplierEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of SupplierEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of SupplierEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(SupplierEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of SupplierEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of SupplierEntityAudits
	 */
	private List<SupplierEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<SupplierEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param supplier supplier to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private SupplierEntity updateAuditData(SupplierEntity supplier)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return supplier;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private SupplierEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		SupplierEntity entityAtRevision = updateAuditData((SupplierEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new SupplierEntityAudit(
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

		QSupplierEntity entity = QSupplierEntity.supplierEntity;

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
			case "goodsReceiveNotesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Goods Receive Notes here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Goods Receive Notes here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.goodsReceiveNotes.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Goods Receive Notes here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Goods Receive Notes here] end

				break;
			case "purchaseOrdersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Purchase Orders here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Purchase Orders here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseOrders.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Purchase Orders here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Purchase Orders here] end

				break;
			case "purchaseRequisitionsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Purchase Requisitions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Purchase Requisitions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseRequisitions.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Purchase Requisitions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Purchase Requisitions here] end

				break;
			case "returnSuppliersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Return Suppliers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Return Suppliers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.returnSuppliers.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Return Suppliers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Return Suppliers here] end

				break;
			case "suplierContactDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Suplier Contact Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Suplier Contact Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.suplierContactDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Suplier Contact Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Suplier Contact Details here] end

				break;
			case "supplierBankAccountsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Supplier Bank Accounts here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Supplier Bank Accounts here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.supplierBankAccounts.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Supplier Bank Accounts here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Supplier Bank Accounts here] end

				break;
			case "supplierProductDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Supplier Product Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Supplier Product Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.supplierProductDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Supplier Product Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Supplier Product Details here] end

				break;
			case "supplierNumber":
				// % protected region % [Add any additional logic before the query parameters of supplierNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of supplierNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.supplierNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of supplierNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of supplierNumber here] end

				break;
			case "supplierName":
				// % protected region % [Add any additional logic before the query parameters of supplierName here] off begin
				// % protected region % [Add any additional logic before the query parameters of supplierName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.supplierName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of supplierName here] off begin
				// % protected region % [Add any additional logic after the query parameters of supplierName here] end

				break;
			case "purchaseOrderHold":
				// % protected region % [Add any additional logic before the query parameters of purchaseOrderHold here] off begin
				// % protected region % [Add any additional logic before the query parameters of purchaseOrderHold here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseOrderHold, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of purchaseOrderHold here] off begin
				// % protected region % [Add any additional logic after the query parameters of purchaseOrderHold here] end

				break;
			case "leadTimeMaximum":
				// % protected region % [Add any additional logic before the query parameters of leadTimeMaximum here] off begin
				// % protected region % [Add any additional logic before the query parameters of leadTimeMaximum here] end


				// % protected region % [Add any additional logic after the query parameters of leadTimeMaximum here] off begin
				// % protected region % [Add any additional logic after the query parameters of leadTimeMaximum here] end

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
	public SupplierEntity updateOldData(SupplierEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public SupplierEntity updateOldData(SupplierEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		SupplierEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInSupplierEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getPurchaseOrderHold() == null) {
			entityToUpdate.setPurchaseOrderHold(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getVatIncluded() == null) {
			entityToUpdate.setVatIncluded(false);
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
		if (entity.getSuplierContactDetailsIds().isEmpty() && entity.getSuplierContactDetails().isEmpty()) {
			entityToUpdate.setSuplierContactDetails(new HashSet<>());
		} else if (!entity.getSuplierContactDetailsIds().isEmpty() && entity.getSuplierContactDetails().isEmpty()) {
			Iterable<SupplierContactDetailEntity> suplierContactDetailsEntities =
					this.supplierContactDetailRepository.findAllById(entity.getSuplierContactDetailsIds());
			entityToUpdate.setSuplierContactDetails(Sets.newHashSet(suplierContactDetailsEntities));
		}
		if (persistRelations && !entity.getSuplierContactDetails().isEmpty()) {
			Set<SupplierContactDetailEntity> updatedEntities = new HashSet<>();
			entity.getSuplierContactDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.supplierContactDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setSuplierContactDetails(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getSupplierBankAccountsIds().isEmpty() && entity.getSupplierBankAccounts().isEmpty()) {
			entityToUpdate.setSupplierBankAccounts(new HashSet<>());
		} else if (!entity.getSupplierBankAccountsIds().isEmpty() && entity.getSupplierBankAccounts().isEmpty()) {
			Iterable<SupplierBankAccountEntity> supplierBankAccountsEntities =
					this.supplierBankAccountRepository.findAllById(entity.getSupplierBankAccountsIds());
			entityToUpdate.setSupplierBankAccounts(Sets.newHashSet(supplierBankAccountsEntities));
		}
		if (persistRelations && !entity.getSupplierBankAccounts().isEmpty()) {
			Set<SupplierBankAccountEntity> updatedEntities = new HashSet<>();
			entity.getSupplierBankAccounts().forEach(model -> {
				if (model.getId() != null) {
					model = this.supplierBankAccountRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setSupplierBankAccounts(updatedEntities);
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
	public void validateEntity(SupplierEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<SupplierEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityBySupplierNumberOpt = this.findBySupplierNumber(entity.getSupplierNumber());
			if (entityBySupplierNumberOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<SupplierEntity>(
						"Supplier Number",
						entity.getSupplierNumber(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"SupplierNumber"
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
	 * Get the sort as given by the sort by for the SupplierEntity.
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

	public Set<String> validateEntityRelations(SupplierEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		for (UUID id : entity.getGoodsReceiveNotesIds()) {
			if (this.goodsReceiveNoteRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Goods Receive Note Entity");
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

		for (UUID id : entity.getReturnSuppliersIds()) {
			if (this.returnSupplierRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Return Supplier Entity");
			}
		}

		for (UUID id : entity.getSuplierContactDetailsIds()) {
			if (this.supplierContactDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Supplier Contact Detail Entity");
			}
		}

		for (UUID id : entity.getSupplierBankAccountsIds()) {
			if (this.supplierBankAccountRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Supplier Bank Account Entity");
			}
		}

		for (UUID id : entity.getSupplierProductDetailsIds()) {
			if (this.supplierProductDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Supplier Product Detail Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
