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
import kmsweb.repositories.CashReceiptRepository;
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
import kmsweb.entities.enums.*;
import java.time.*;
import kmsweb.entities.MerchantEntity;
import kmsweb.repositories.MerchantRepository;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.repositories.PatientGeneralInfoRepository;
import kmsweb.entities.RetailPharmacyInvoiceEntity;
import kmsweb.repositories.RetailPharmacyInvoiceRepository;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class CashReceiptService extends AbstractService<CashReceiptEntity, CashReceiptRepository, CashReceiptEntityAudit> {

	private final String[] referenceNamesInCashReceiptEntity = {
		"merchant",
		"retailPharmacyInvoice",
		"cashierStaff",
		"patient",
	};

	private final MerchantRepository merchantRepository;

	private final PatientGeneralInfoRepository patientGeneralInfoRepository;

	private final RetailPharmacyInvoiceRepository retailPharmacyInvoiceRepository;

	private final StaffRepository staffRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public CashReceiptService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		MerchantRepository merchantRepository,
		PatientGeneralInfoRepository patientGeneralInfoRepository,
		RetailPharmacyInvoiceRepository retailPharmacyInvoiceRepository,
		StaffRepository staffRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		CashReceiptRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.merchantRepository = merchantRepository;

		this.patientGeneralInfoRepository = patientGeneralInfoRepository;

		this.retailPharmacyInvoiceRepository = retailPharmacyInvoiceRepository;

		this.staffRepository = staffRepository;

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
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
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
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Receipt Type.
	 *
	 * @param receiptType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Receipt Type
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByReceiptType(ReceiptTypeEnum receiptType)
	// % protected region % [Add any throwables, implementations, or extensions for findByReceiptType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReceiptType here] end
	{
		// % protected region % [Add any additional logic for findByReceiptType before the main body here] off begin
		// % protected region % [Add any additional logic for findByReceiptType before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByReceiptType(receiptType));

		// % protected region % [Add any additional logic for findByReceiptType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReceiptType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Receipt Number.
	 *
	 * @param receiptNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Receipt Number
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByReceiptNumber(String receiptNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByReceiptNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReceiptNumber here] end
	{
		// % protected region % [Add any additional logic for findByReceiptNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByReceiptNumber before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByReceiptNumber(receiptNumber));

		// % protected region % [Add any additional logic for findByReceiptNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReceiptNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Payment Date.
	 *
	 * @param paymentDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Payment Date
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByPaymentDate(OffsetDateTime paymentDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByPaymentDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPaymentDate here] end
	{
		// % protected region % [Add any additional logic for findByPaymentDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByPaymentDate before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByPaymentDate(paymentDate));

		// % protected region % [Add any additional logic for findByPaymentDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPaymentDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Description.
	 *
	 * @param description the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Description
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByDescription(String description)
	// % protected region % [Add any throwables, implementations, or extensions for findByDescription here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDescription here] end
	{
		// % protected region % [Add any additional logic for findByDescription before the main body here] off begin
		// % protected region % [Add any additional logic for findByDescription before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByDescription(description));

		// % protected region % [Add any additional logic for findByDescription before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDescription before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Payment Type.
	 *
	 * @param paymentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Payment Type
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByPaymentType(String paymentType)
	// % protected region % [Add any throwables, implementations, or extensions for findByPaymentType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPaymentType here] end
	{
		// % protected region % [Add any additional logic for findByPaymentType before the main body here] off begin
		// % protected region % [Add any additional logic for findByPaymentType before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByPaymentType(paymentType));

		// % protected region % [Add any additional logic for findByPaymentType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPaymentType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Receive Amount.
	 *
	 * @param receiveAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Receive Amount
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByReceiveAmount(Double receiveAmount)
	// % protected region % [Add any throwables, implementations, or extensions for findByReceiveAmount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReceiveAmount here] end
	{
		// % protected region % [Add any additional logic for findByReceiveAmount before the main body here] off begin
		// % protected region % [Add any additional logic for findByReceiveAmount before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByReceiveAmount(receiveAmount));

		// % protected region % [Add any additional logic for findByReceiveAmount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReceiveAmount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute IsVoid.
	 *
	 * @param isvoid the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute IsVoid
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByIsvoid(Boolean isvoid)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsvoid here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsvoid here] end
	{
		// % protected region % [Add any additional logic for findByIsvoid before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsvoid before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByIsvoid(isvoid));

		// % protected region % [Add any additional logic for findByIsvoid before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsvoid before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Cashier Location.
	 *
	 * @param cashierLocation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cashier Location
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByCashierLocation(String cashierLocation)
	// % protected region % [Add any throwables, implementations, or extensions for findByCashierLocation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCashierLocation here] end
	{
		// % protected region % [Add any additional logic for findByCashierLocation before the main body here] off begin
		// % protected region % [Add any additional logic for findByCashierLocation before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByCashierLocation(cashierLocation));

		// % protected region % [Add any additional logic for findByCashierLocation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCashierLocation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Void Date Time.
	 *
	 * @param voidDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Void Date Time
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByVoidDateTime(OffsetDateTime voidDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByVoidDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVoidDateTime here] end
	{
		// % protected region % [Add any additional logic for findByVoidDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByVoidDateTime before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByVoidDateTime(voidDateTime));

		// % protected region % [Add any additional logic for findByVoidDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVoidDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Cash Change Type.
	 *
	 * @param cashChangeType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cash Change Type
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByCashChangeType(CashChangeTypeEnum cashChangeType)
	// % protected region % [Add any throwables, implementations, or extensions for findByCashChangeType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCashChangeType here] end
	{
		// % protected region % [Add any additional logic for findByCashChangeType before the main body here] off begin
		// % protected region % [Add any additional logic for findByCashChangeType before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByCashChangeType(cashChangeType));

		// % protected region % [Add any additional logic for findByCashChangeType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCashChangeType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Change Amount.
	 *
	 * @param changeAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Change Amount
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByChangeAmount(Double changeAmount)
	// % protected region % [Add any throwables, implementations, or extensions for findByChangeAmount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByChangeAmount here] end
	{
		// % protected region % [Add any additional logic for findByChangeAmount before the main body here] off begin
		// % protected region % [Add any additional logic for findByChangeAmount before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByChangeAmount(changeAmount));

		// % protected region % [Add any additional logic for findByChangeAmount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByChangeAmount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Allocated Amount.
	 *
	 * @param allocatedAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Allocated Amount
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByAllocatedAmount(Double allocatedAmount)
	// % protected region % [Add any throwables, implementations, or extensions for findByAllocatedAmount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAllocatedAmount here] end
	{
		// % protected region % [Add any additional logic for findByAllocatedAmount before the main body here] off begin
		// % protected region % [Add any additional logic for findByAllocatedAmount before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByAllocatedAmount(allocatedAmount));

		// % protected region % [Add any additional logic for findByAllocatedAmount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAllocatedAmount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Rounding Amount.
	 *
	 * @param roundingAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Rounding Amount
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByRoundingAmount(Double roundingAmount)
	// % protected region % [Add any throwables, implementations, or extensions for findByRoundingAmount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRoundingAmount here] end
	{
		// % protected region % [Add any additional logic for findByRoundingAmount before the main body here] off begin
		// % protected region % [Add any additional logic for findByRoundingAmount before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByRoundingAmount(roundingAmount));

		// % protected region % [Add any additional logic for findByRoundingAmount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRoundingAmount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Available Amount.
	 *
	 * @param availableAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Available Amount
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByAvailableAmount(Double availableAmount)
	// % protected region % [Add any throwables, implementations, or extensions for findByAvailableAmount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAvailableAmount here] end
	{
		// % protected region % [Add any additional logic for findByAvailableAmount before the main body here] off begin
		// % protected region % [Add any additional logic for findByAvailableAmount before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByAvailableAmount(availableAmount));

		// % protected region % [Add any additional logic for findByAvailableAmount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAvailableAmount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Bank Name.
	 *
	 * @param bankName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bank Name
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByBankName(String bankName)
	// % protected region % [Add any throwables, implementations, or extensions for findByBankName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBankName here] end
	{
		// % protected region % [Add any additional logic for findByBankName before the main body here] off begin
		// % protected region % [Add any additional logic for findByBankName before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByBankName(bankName));

		// % protected region % [Add any additional logic for findByBankName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBankName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Card Type.
	 *
	 * @param cardType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Card Type
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByCardType(String cardType)
	// % protected region % [Add any throwables, implementations, or extensions for findByCardType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCardType here] end
	{
		// % protected region % [Add any additional logic for findByCardType before the main body here] off begin
		// % protected region % [Add any additional logic for findByCardType before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByCardType(cardType));

		// % protected region % [Add any additional logic for findByCardType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCardType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Card No.
	 *
	 * @param cardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Card No
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByCardNo(String cardNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByCardNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCardNo here] end
	{
		// % protected region % [Add any additional logic for findByCardNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByCardNo before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByCardNo(cardNo));

		// % protected region % [Add any additional logic for findByCardNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCardNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Card Holder.
	 *
	 * @param cardHolder the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Card Holder
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByCardHolder(String cardHolder)
	// % protected region % [Add any throwables, implementations, or extensions for findByCardHolder here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCardHolder here] end
	{
		// % protected region % [Add any additional logic for findByCardHolder before the main body here] off begin
		// % protected region % [Add any additional logic for findByCardHolder before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByCardHolder(cardHolder));

		// % protected region % [Add any additional logic for findByCardHolder before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCardHolder before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Reference Number.
	 *
	 * @param referenceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Reference Number
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByReferenceNumber(String referenceNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferenceNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferenceNumber here] end
	{
		// % protected region % [Add any additional logic for findByReferenceNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferenceNumber before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByReferenceNumber(referenceNumber));

		// % protected region % [Add any additional logic for findByReferenceNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferenceNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Bank Account.
	 *
	 * @param hospitalBankAccount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Bank Account
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByHospitalBankAccount(String hospitalBankAccount)
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalBankAccount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalBankAccount here] end
	{
		// % protected region % [Add any additional logic for findByHospitalBankAccount before the main body here] off begin
		// % protected region % [Add any additional logic for findByHospitalBankAccount before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByHospitalBankAccount(hospitalBankAccount));

		// % protected region % [Add any additional logic for findByHospitalBankAccount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHospitalBankAccount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Surcharge Amount.
	 *
	 * @param surchargeAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surcharge Amount
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findBySurchargeAmount(Double surchargeAmount)
	// % protected region % [Add any throwables, implementations, or extensions for findBySurchargeAmount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySurchargeAmount here] end
	{
		// % protected region % [Add any additional logic for findBySurchargeAmount before the main body here] off begin
		// % protected region % [Add any additional logic for findBySurchargeAmount before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findBySurchargeAmount(surchargeAmount));

		// % protected region % [Add any additional logic for findBySurchargeAmount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySurchargeAmount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Outstanding Amount.
	 *
	 * @param outstandingAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Outstanding Amount
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByOutstandingAmount(Double outstandingAmount)
	// % protected region % [Add any throwables, implementations, or extensions for findByOutstandingAmount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOutstandingAmount here] end
	{
		// % protected region % [Add any additional logic for findByOutstandingAmount before the main body here] off begin
		// % protected region % [Add any additional logic for findByOutstandingAmount before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByOutstandingAmount(outstandingAmount));

		// % protected region % [Add any additional logic for findByOutstandingAmount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOutstandingAmount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Received From.
	 *
	 * @param receivedFrom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Received From
	 */
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findByReceivedFrom(String receivedFrom)
	// % protected region % [Add any throwables, implementations, or extensions for findByReceivedFrom here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReceivedFrom here] end
	{
		// % protected region % [Add any additional logic for findByReceivedFrom before the main body here] off begin
		// % protected region % [Add any additional logic for findByReceivedFrom before the main body here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findByReceivedFrom(receivedFrom));

		// % protected region % [Add any additional logic for findByReceivedFrom before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReceivedFrom before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<CashReceiptEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<CashReceiptEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<CashReceiptEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CashReceiptEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<CashReceiptEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('CashReceiptEntity', 'create')")
	public CashReceiptEntity create(CashReceiptEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		CashReceiptEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('CashReceiptEntity', 'create')")
	public CashReceiptEntity create(CashReceiptEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		CashReceiptEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		CashReceiptEntity newEntity;

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
	@PreAuthorize("hasPermission('CashReceiptEntity', 'create')")
	public List<CashReceiptEntity> createAll(Iterable<CashReceiptEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<CashReceiptEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<CashReceiptEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('CashReceiptEntity', 'update')")
	public CashReceiptEntity update(CashReceiptEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		CashReceiptEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('CashReceiptEntity', 'update')")
	public CashReceiptEntity update(CashReceiptEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		CashReceiptEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		CashReceiptEntity newEntity;

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
	@PreAuthorize("hasPermission('CashReceiptEntity', 'update')")
	public List<CashReceiptEntity> updateAll(Iterable<CashReceiptEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<CashReceiptEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<CashReceiptEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('CashReceiptEntity', 'create') or hasPermission('CashReceiptEntity', 'update')")
	public CashReceiptEntity save(CashReceiptEntity entity) throws ConstraintViolationException
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

		CashReceiptEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('CashReceiptEntity', 'create') or hasPermission('CashReceiptEntity', 'update')")
	public List<CashReceiptEntity> saveAll(Iterable<CashReceiptEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<CashReceiptEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('CashReceiptEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('CashReceiptEntity', 'delete')")
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
	@PreAuthorize("hasPermission('CashReceiptEntity', 'delete')")
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
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	public List<CashReceiptEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	public List<CashReceiptEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<CashReceiptEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(CashReceiptEntity.class);

		// % protected region % [Add any additional processing before converting to a list of CashReceiptEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of CashReceiptEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<CashReceiptEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of CashReceiptEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of CashReceiptEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(CashReceiptEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of CashReceiptEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of CashReceiptEntityAudits
	 */
	private List<CashReceiptEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<CashReceiptEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param cashReceipt cashReceipt to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private CashReceiptEntity updateAuditData(CashReceiptEntity cashReceipt)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return cashReceipt;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private CashReceiptEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		CashReceiptEntity entityAtRevision = updateAuditData((CashReceiptEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new CashReceiptEntityAudit(
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

		QCashReceiptEntity entity = QCashReceiptEntity.cashReceiptEntity;

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
			case "merchantId":
				// % protected region % [Add any additional logic before the query parameters of relation from Merchant to Cash Receipts here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Merchant to Cash Receipts here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.merchant.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Merchant to Cash Receipts here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Merchant to Cash Receipts here] end

				break;
			case "retailPharmacyInvoiceId":
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy Invoice to Cash Receipts here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy Invoice to Cash Receipts here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.retailPharmacyInvoice.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy Invoice to Cash Receipts here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy Invoice to Cash Receipts here] end

				break;
			case "cashierStaffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Cashier Staff to Cashier Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Cashier Staff to Cashier Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.cashierStaff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Cashier Staff to Cashier Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Cashier Staff to Cashier Staff here] end

				break;
			case "patientId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient to Invoice Receipts here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient to Invoice Receipts here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patient.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient to Invoice Receipts here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient to Invoice Receipts here] end

				break;
			case "receiptType":
				// % protected region % [Add any additional logic before the query parameters of receiptType here] off begin
				// % protected region % [Add any additional logic before the query parameters of receiptType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.receiptType, ReceiptTypeEnum.class, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of receiptType here] off begin
				// % protected region % [Add any additional logic after the query parameters of receiptType here] end

				break;
			case "receiptNumber":
				// % protected region % [Add any additional logic before the query parameters of receiptNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of receiptNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.receiptNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of receiptNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of receiptNumber here] end

				break;
			case "description":
				// % protected region % [Add any additional logic before the query parameters of description here] off begin
				// % protected region % [Add any additional logic before the query parameters of description here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.description, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of description here] off begin
				// % protected region % [Add any additional logic after the query parameters of description here] end

				break;
			case "paymentType":
				// % protected region % [Add any additional logic before the query parameters of paymentType here] off begin
				// % protected region % [Add any additional logic before the query parameters of paymentType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.paymentType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of paymentType here] off begin
				// % protected region % [Add any additional logic after the query parameters of paymentType here] end

				break;
			case "receiveAmount":
				// % protected region % [Add any additional logic before the query parameters of receiveAmount here] off begin
				// % protected region % [Add any additional logic before the query parameters of receiveAmount here] end


				// % protected region % [Add any additional logic after the query parameters of receiveAmount here] off begin
				// % protected region % [Add any additional logic after the query parameters of receiveAmount here] end

				break;
			case "isvoid":
				// % protected region % [Add any additional logic before the query parameters of isvoid here] off begin
				// % protected region % [Add any additional logic before the query parameters of isvoid here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.isvoid, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of isvoid here] off begin
				// % protected region % [Add any additional logic after the query parameters of isvoid here] end

				break;
			case "cashierLocation":
				// % protected region % [Add any additional logic before the query parameters of cashierLocation here] off begin
				// % protected region % [Add any additional logic before the query parameters of cashierLocation here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.cashierLocation, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of cashierLocation here] off begin
				// % protected region % [Add any additional logic after the query parameters of cashierLocation here] end

				break;
			case "voidDateTime":
				// % protected region % [Add any additional logic before the query parameters of voidDateTime here] off begin
				// % protected region % [Add any additional logic before the query parameters of voidDateTime here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.voidDateTime, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of voidDateTime here] off begin
				// % protected region % [Add any additional logic after the query parameters of voidDateTime here] end

				break;
			case "cashChangeType":
				// % protected region % [Add any additional logic before the query parameters of cashChangeType here] off begin
				// % protected region % [Add any additional logic before the query parameters of cashChangeType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.cashChangeType, CashChangeTypeEnum.class, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of cashChangeType here] off begin
				// % protected region % [Add any additional logic after the query parameters of cashChangeType here] end

				break;
			case "changeAmount":
				// % protected region % [Add any additional logic before the query parameters of changeAmount here] off begin
				// % protected region % [Add any additional logic before the query parameters of changeAmount here] end


				// % protected region % [Add any additional logic after the query parameters of changeAmount here] off begin
				// % protected region % [Add any additional logic after the query parameters of changeAmount here] end

				break;
			case "allocatedAmount":
				// % protected region % [Add any additional logic before the query parameters of allocatedAmount here] off begin
				// % protected region % [Add any additional logic before the query parameters of allocatedAmount here] end


				// % protected region % [Add any additional logic after the query parameters of allocatedAmount here] off begin
				// % protected region % [Add any additional logic after the query parameters of allocatedAmount here] end

				break;
			case "availableAmount":
				// % protected region % [Add any additional logic before the query parameters of availableAmount here] off begin
				// % protected region % [Add any additional logic before the query parameters of availableAmount here] end


				// % protected region % [Add any additional logic after the query parameters of availableAmount here] off begin
				// % protected region % [Add any additional logic after the query parameters of availableAmount here] end

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
	public CashReceiptEntity updateOldData(CashReceiptEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public CashReceiptEntity updateOldData(CashReceiptEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		CashReceiptEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInCashReceiptEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getIsvoid() == null) {
			entityToUpdate.setIsvoid(false);
		}

		// Incoming One to Many reference
		if (entity.getMerchant() == null && entity.getMerchantId() == null) {
			entityToUpdate.unsetMerchant();
		} else if (entity.getMerchantId() != null && entity.getMerchant() == null) {
			Optional<MerchantEntity> merchantEntity = this.merchantRepository.findById(entity.getMerchantId());
			entityToUpdate.setMerchant(merchantEntity.orElseThrow());
		}
		if (persistRelations && entity.getMerchant() != null) {
			entityToUpdate.setMerchant(entity.getMerchant(), false);
			if (entityToUpdate.getMerchantId() != null) {
				this.merchantRepository.save(entityToUpdate.getMerchant());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMerchant().unsetCashReceipts();
			}
		}

		// Incoming One to Many reference
		if (entity.getRetailPharmacyInvoice() == null && entity.getRetailPharmacyInvoiceId() == null) {
			entityToUpdate.unsetRetailPharmacyInvoice();
		} else if (entity.getRetailPharmacyInvoiceId() != null && entity.getRetailPharmacyInvoice() == null) {
			Optional<RetailPharmacyInvoiceEntity> retailPharmacyInvoiceEntity = this.retailPharmacyInvoiceRepository.findById(entity.getRetailPharmacyInvoiceId());
			entityToUpdate.setRetailPharmacyInvoice(retailPharmacyInvoiceEntity.orElseThrow());
		}
		if (persistRelations && entity.getRetailPharmacyInvoice() != null) {
			entityToUpdate.setRetailPharmacyInvoice(entity.getRetailPharmacyInvoice(), false);
			if (entityToUpdate.getRetailPharmacyInvoiceId() != null) {
				this.retailPharmacyInvoiceRepository.save(entityToUpdate.getRetailPharmacyInvoice());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getRetailPharmacyInvoice().unsetCashReceipts();
			}
		}

		// Incoming One to Many reference
		if (entity.getCashierStaff() == null && entity.getCashierStaffId() == null) {
			entityToUpdate.unsetCashierStaff();
		} else if (entity.getCashierStaffId() != null && entity.getCashierStaff() == null) {
			Optional<StaffEntity> cashierStaffEntity = this.staffRepository.findById(entity.getCashierStaffId());
			entityToUpdate.setCashierStaff(cashierStaffEntity.orElseThrow());
		}
		if (persistRelations && entity.getCashierStaff() != null) {
			entityToUpdate.setCashierStaff(entity.getCashierStaff(), false);
			if (entityToUpdate.getCashierStaffId() != null) {
				this.staffRepository.save(entityToUpdate.getCashierStaff());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getCashierStaff().unsetCashierStaff();
			}
		}

		// Incoming One to Many reference
		if (entity.getPatient() == null && entity.getPatientId() == null) {
			entityToUpdate.unsetPatient();
		} else if (entity.getPatientId() != null && entity.getPatient() == null) {
			Optional<PatientGeneralInfoEntity> patientEntity = this.patientGeneralInfoRepository.findById(entity.getPatientId());
			entityToUpdate.setPatient(patientEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatient() != null) {
			entityToUpdate.setPatient(entity.getPatient(), false);
			if (entityToUpdate.getPatientId() != null) {
				this.patientGeneralInfoRepository.save(entityToUpdate.getPatient());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatient().unsetInvoiceReceipts();
			}
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
	public void validateEntity(CashReceiptEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<CashReceiptEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the CashReceiptEntity.
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

	public Set<String> validateEntityRelations(CashReceiptEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getMerchantId() != null && this.merchantRepository.findById(entity.getMerchantId()).isEmpty()) {
			errors.add("The UUID " + entity.getMerchantId() + " is not associated with a Merchant Entity");
		}

		if (entity.getRetailPharmacyInvoiceId() != null && this.retailPharmacyInvoiceRepository.findById(entity.getRetailPharmacyInvoiceId()).isEmpty()) {
			errors.add("The UUID " + entity.getRetailPharmacyInvoiceId() + " is not associated with a Retail Pharmacy Invoice Entity");
		}

		if (entity.getCashierStaffId() != null && this.staffRepository.findById(entity.getCashierStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getCashierStaffId() + " is not associated with a Staff Entity");
		}

		if (entity.getPatientId() != null && this.patientGeneralInfoRepository.findById(entity.getPatientId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientId() + " is not associated with a Patient General Info Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
