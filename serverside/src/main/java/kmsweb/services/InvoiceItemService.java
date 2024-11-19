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
import kmsweb.repositories.InvoiceItemRepository;
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
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.entities.InvoiceItemComponentEntity;
import kmsweb.repositories.InvoiceItemComponentRepository;
import kmsweb.entities.MedicalFeeEntity;
import kmsweb.repositories.MedicalFeeRepository;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.repositories.MedicationHeaderRepository;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.repositories.PrescriptionHeaderRepository;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.entities.RetailPharmacyInvoiceEntity;
import kmsweb.repositories.RetailPharmacyInvoiceRepository;
import kmsweb.entities.TariffSchemaEntity;
import kmsweb.repositories.TariffSchemaRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class InvoiceItemService extends AbstractService<InvoiceItemEntity, InvoiceItemRepository, InvoiceItemEntityAudit> {

	private final String[] referenceNamesInInvoiceItemEntity = {
		"invoiceItemComponents",
		"invoice",
		"medicalFee",
		"medicationHeader",
		"prescription",
		"retailPharmacyInvoice",
		"serviceNumber",
		"tariffSchema",
	};

	private final InvoiceRepository invoiceRepository;

	private final InvoiceItemComponentRepository invoiceItemComponentRepository;

	private final MedicalFeeRepository medicalFeeRepository;

	private final MedicationHeaderRepository medicationHeaderRepository;

	private final PrescriptionHeaderRepository prescriptionHeaderRepository;

	private final RegistrationRepository registrationRepository;

	private final RetailPharmacyInvoiceRepository retailPharmacyInvoiceRepository;

	private final TariffSchemaRepository tariffSchemaRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public InvoiceItemService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		InvoiceRepository invoiceRepository,
		InvoiceItemComponentRepository invoiceItemComponentRepository,
		MedicalFeeRepository medicalFeeRepository,
		MedicationHeaderRepository medicationHeaderRepository,
		PrescriptionHeaderRepository prescriptionHeaderRepository,
		RegistrationRepository registrationRepository,
		RetailPharmacyInvoiceRepository retailPharmacyInvoiceRepository,
		TariffSchemaRepository tariffSchemaRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		InvoiceItemRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.invoiceRepository = invoiceRepository;

		this.invoiceItemComponentRepository = invoiceItemComponentRepository;

		this.medicalFeeRepository = medicalFeeRepository;

		this.medicationHeaderRepository = medicationHeaderRepository;

		this.prescriptionHeaderRepository = prescriptionHeaderRepository;

		this.registrationRepository = registrationRepository;

		this.retailPharmacyInvoiceRepository = retailPharmacyInvoiceRepository;

		this.tariffSchemaRepository = tariffSchemaRepository;

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
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
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
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Transaction Date.
	 *
	 * @param transactionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Date
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findByTransactionDate(OffsetDateTime transactionDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionDate here] end
	{
		// % protected region % [Add any additional logic for findByTransactionDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByTransactionDate before the main body here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findByTransactionDate(transactionDate));

		// % protected region % [Add any additional logic for findByTransactionDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTransactionDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Code.
	 *
	 * @param tariffCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Code
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findByTariffCode(String tariffCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffCode here] end
	{
		// % protected region % [Add any additional logic for findByTariffCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByTariffCode before the main body here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findByTariffCode(tariffCode));

		// % protected region % [Add any additional logic for findByTariffCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTariffCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Type.
	 *
	 * @param tariffType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Type
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findByTariffType(TariffTypeEnum tariffType)
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffType here] end
	{
		// % protected region % [Add any additional logic for findByTariffType before the main body here] off begin
		// % protected region % [Add any additional logic for findByTariffType before the main body here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findByTariffType(tariffType));

		// % protected region % [Add any additional logic for findByTariffType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTariffType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Name.
	 *
	 * @param name the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findByName(String name)
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] end
	{
		// % protected region % [Add any additional logic for findByName before the main body here] off begin
		// % protected region % [Add any additional logic for findByName before the main body here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findByName(name));

		// % protected region % [Add any additional logic for findByName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Medical Staff Code.
	 *
	 * @param medicalStaffCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medical Staff Code
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findByMedicalStaffCode(String medicalStaffCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicalStaffCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicalStaffCode here] end
	{
		// % protected region % [Add any additional logic for findByMedicalStaffCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByMedicalStaffCode before the main body here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findByMedicalStaffCode(medicalStaffCode));

		// % protected region % [Add any additional logic for findByMedicalStaffCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMedicalStaffCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Price.
	 *
	 * @param price the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Price
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findByPrice(Double price)
	// % protected region % [Add any throwables, implementations, or extensions for findByPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPrice here] end
	{
		// % protected region % [Add any additional logic for findByPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByPrice before the main body here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findByPrice(price));

		// % protected region % [Add any additional logic for findByPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Price.
	 *
	 * @param hospitalPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Price
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findByHospitalPrice(Double hospitalPrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalPrice here] end
	{
		// % protected region % [Add any additional logic for findByHospitalPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByHospitalPrice before the main body here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findByHospitalPrice(hospitalPrice));

		// % protected region % [Add any additional logic for findByHospitalPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHospitalPrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Other Component Price.
	 *
	 * @param totalOtherComponentPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Other Component Price
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findByTotalOtherComponentPrice(Double totalOtherComponentPrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalOtherComponentPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalOtherComponentPrice here] end
	{
		// % protected region % [Add any additional logic for findByTotalOtherComponentPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalOtherComponentPrice before the main body here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findByTotalOtherComponentPrice(totalOtherComponentPrice));

		// % protected region % [Add any additional logic for findByTotalOtherComponentPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalOtherComponentPrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Quantity.
	 *
	 * @param quantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findByQuantity(Double quantity)
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantity here] end
	{
		// % protected region % [Add any additional logic for findByQuantity before the main body here] off begin
		// % protected region % [Add any additional logic for findByQuantity before the main body here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findByQuantity(quantity));

		// % protected region % [Add any additional logic for findByQuantity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQuantity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Unit.
	 *
	 * @param unit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unit
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findByUnit(String unit)
	// % protected region % [Add any throwables, implementations, or extensions for findByUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUnit here] end
	{
		// % protected region % [Add any additional logic for findByUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByUnit before the main body here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findByUnit(unit));

		// % protected region % [Add any additional logic for findByUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Discount.
	 *
	 * @param discount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Discount
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findByDiscount(Double discount)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiscount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiscount here] end
	{
		// % protected region % [Add any additional logic for findByDiscount before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiscount before the main body here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findByDiscount(discount));

		// % protected region % [Add any additional logic for findByDiscount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiscount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tax.
	 *
	 * @param tax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findByTax(Boolean tax)
	// % protected region % [Add any throwables, implementations, or extensions for findByTax here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTax here] end
	{
		// % protected region % [Add any additional logic for findByTax before the main body here] off begin
		// % protected region % [Add any additional logic for findByTax before the main body here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findByTax(tax));

		// % protected region % [Add any additional logic for findByTax before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTax before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Item Total.
	 *
	 * @param itemTotal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Total
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findByItemTotal(Double itemTotal)
	// % protected region % [Add any throwables, implementations, or extensions for findByItemTotal here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByItemTotal here] end
	{
		// % protected region % [Add any additional logic for findByItemTotal before the main body here] off begin
		// % protected region % [Add any additional logic for findByItemTotal before the main body here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findByItemTotal(itemTotal));

		// % protected region % [Add any additional logic for findByItemTotal before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByItemTotal before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findByTreatmentClass(String treatmentClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] end
	{
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findByTreatmentClass(treatmentClass));

		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<InvoiceItemEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<InvoiceItemEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<InvoiceItemEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<InvoiceItemEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'create')")
	public InvoiceItemEntity create(InvoiceItemEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		InvoiceItemEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'create')")
	public InvoiceItemEntity create(InvoiceItemEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		InvoiceItemEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		InvoiceItemEntity newEntity;

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
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'create')")
	public List<InvoiceItemEntity> createAll(Iterable<InvoiceItemEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<InvoiceItemEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<InvoiceItemEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'update')")
	public InvoiceItemEntity update(InvoiceItemEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		InvoiceItemEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'update')")
	public InvoiceItemEntity update(InvoiceItemEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		InvoiceItemEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		InvoiceItemEntity newEntity;

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
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'update')")
	public List<InvoiceItemEntity> updateAll(Iterable<InvoiceItemEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<InvoiceItemEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<InvoiceItemEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'create') or hasPermission('InvoiceItemEntity', 'update')")
	public InvoiceItemEntity save(InvoiceItemEntity entity) throws ConstraintViolationException
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

		InvoiceItemEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'create') or hasPermission('InvoiceItemEntity', 'update')")
	public List<InvoiceItemEntity> saveAll(Iterable<InvoiceItemEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<InvoiceItemEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'delete')")
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
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'delete')")
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
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	public List<InvoiceItemEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	public List<InvoiceItemEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(InvoiceItemEntity.class);

		// % protected region % [Add any additional processing before converting to a list of InvoiceItemEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of InvoiceItemEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<InvoiceItemEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of InvoiceItemEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of InvoiceItemEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(InvoiceItemEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of InvoiceItemEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of InvoiceItemEntityAudits
	 */
	private List<InvoiceItemEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<InvoiceItemEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param invoiceItem invoiceItem to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private InvoiceItemEntity updateAuditData(InvoiceItemEntity invoiceItem)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return invoiceItem;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private InvoiceItemEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		InvoiceItemEntity entityAtRevision = updateAuditData((InvoiceItemEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new InvoiceItemEntityAudit(
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

		QInvoiceItemEntity entity = QInvoiceItemEntity.invoiceItemEntity;

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
			case "invoiceId":
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Invoice Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Invoice Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoice.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Invoice Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Invoice Items here] end

				break;
			case "medicalFeeId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Fee to Invoice Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Fee to Invoice Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalFee.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Fee to Invoice Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Fee to Invoice Items here] end

				break;
			case "medicationHeaderId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medication Header to Invoice Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medication Header to Invoice Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicationHeader.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medication Header to Invoice Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medication Header to Invoice Items here] end

				break;
			case "prescriptionId":
				// % protected region % [Add any additional logic before the query parameters of relation from Prescription to Invoice Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Prescription to Invoice Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.prescription.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Prescription to Invoice Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Prescription to Invoice Items here] end

				break;
			case "retailPharmacyInvoiceId":
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy Invoice to Invoice Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy Invoice to Invoice Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.retailPharmacyInvoice.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy Invoice to Invoice Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy Invoice to Invoice Items here] end

				break;
			case "serviceNumberId":
				// % protected region % [Add any additional logic before the query parameters of relation from Service Number to Invoice Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Service Number to Invoice Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.serviceNumber.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Service Number to Invoice Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Service Number to Invoice Items here] end

				break;
			case "tariffSchemaId":
				// % protected region % [Add any additional logic before the query parameters of relation from Tariff Schema to Invoice Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Tariff Schema to Invoice Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tariffSchema.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Tariff Schema to Invoice Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Tariff Schema to Invoice Items here] end

				break;
			case "invoiceItemComponentsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice Item to Invoice Item Components here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice Item to Invoice Item Components here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceItemComponents.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Invoice Item to Invoice Item Components here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Invoice Item to Invoice Item Components here] end

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
	public InvoiceItemEntity updateOldData(InvoiceItemEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public InvoiceItemEntity updateOldData(InvoiceItemEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		InvoiceItemEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInInvoiceItemEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getTax() == null) {
			entityToUpdate.setTax(false);
		}

		// Incoming One to Many reference
		if (entity.getInvoice() == null && entity.getInvoiceId() == null) {
			entityToUpdate.unsetInvoice();
		} else if (entity.getInvoiceId() != null && entity.getInvoice() == null) {
			Optional<InvoiceEntity> invoiceEntity = this.invoiceRepository.findById(entity.getInvoiceId());
			entityToUpdate.setInvoice(invoiceEntity.orElseThrow());
		}
		if (persistRelations && entity.getInvoice() != null) {
			entityToUpdate.setInvoice(entity.getInvoice(), false);
			if (entityToUpdate.getInvoiceId() != null) {
				this.invoiceRepository.save(entityToUpdate.getInvoice());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getInvoice().unsetInvoiceItems();
			}
		}

		// Incoming One to Many reference
		if (entity.getMedicalFee() == null && entity.getMedicalFeeId() == null) {
			entityToUpdate.unsetMedicalFee();
		} else if (entity.getMedicalFeeId() != null && entity.getMedicalFee() == null) {
			Optional<MedicalFeeEntity> medicalFeeEntity = this.medicalFeeRepository.findById(entity.getMedicalFeeId());
			entityToUpdate.setMedicalFee(medicalFeeEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalFee() != null) {
			entityToUpdate.setMedicalFee(entity.getMedicalFee(), false);
			if (entityToUpdate.getMedicalFeeId() != null) {
				this.medicalFeeRepository.save(entityToUpdate.getMedicalFee());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalFee().unsetInvoiceItems();
			}
		}

		// Incoming One to Many reference
		if (entity.getMedicationHeader() == null && entity.getMedicationHeaderId() == null) {
			entityToUpdate.unsetMedicationHeader();
		} else if (entity.getMedicationHeaderId() != null && entity.getMedicationHeader() == null) {
			Optional<MedicationHeaderEntity> medicationHeaderEntity = this.medicationHeaderRepository.findById(entity.getMedicationHeaderId());
			entityToUpdate.setMedicationHeader(medicationHeaderEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicationHeader() != null) {
			entityToUpdate.setMedicationHeader(entity.getMedicationHeader(), false);
			if (entityToUpdate.getMedicationHeaderId() != null) {
				this.medicationHeaderRepository.save(entityToUpdate.getMedicationHeader());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicationHeader().unsetInvoiceItems();
			}
		}

		// Incoming One to Many reference
		if (entity.getPrescription() == null && entity.getPrescriptionId() == null) {
			entityToUpdate.unsetPrescription();
		} else if (entity.getPrescriptionId() != null && entity.getPrescription() == null) {
			Optional<PrescriptionHeaderEntity> prescriptionEntity = this.prescriptionHeaderRepository.findById(entity.getPrescriptionId());
			entityToUpdate.setPrescription(prescriptionEntity.orElseThrow());
		}
		if (persistRelations && entity.getPrescription() != null) {
			entityToUpdate.setPrescription(entity.getPrescription(), false);
			if (entityToUpdate.getPrescriptionId() != null) {
				this.prescriptionHeaderRepository.save(entityToUpdate.getPrescription());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPrescription().unsetInvoiceItems();
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
				entityToUpdate.getRetailPharmacyInvoice().unsetInvoiceItems();
			}
		}

		// Incoming One to Many reference
		if (entity.getServiceNumber() == null && entity.getServiceNumberId() == null) {
			entityToUpdate.unsetServiceNumber();
		} else if (entity.getServiceNumberId() != null && entity.getServiceNumber() == null) {
			Optional<RegistrationEntity> serviceNumberEntity = this.registrationRepository.findById(entity.getServiceNumberId());
			entityToUpdate.setServiceNumber(serviceNumberEntity.orElseThrow());
		}
		if (persistRelations && entity.getServiceNumber() != null) {
			entityToUpdate.setServiceNumber(entity.getServiceNumber(), false);
			if (entityToUpdate.getServiceNumberId() != null) {
				this.registrationRepository.save(entityToUpdate.getServiceNumber());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getServiceNumber().unsetInvoiceItems();
			}
		}

		// Incoming One to Many reference
		if (entity.getTariffSchema() == null && entity.getTariffSchemaId() == null) {
			entityToUpdate.unsetTariffSchema();
		} else if (entity.getTariffSchemaId() != null && entity.getTariffSchema() == null) {
			Optional<TariffSchemaEntity> tariffSchemaEntity = this.tariffSchemaRepository.findById(entity.getTariffSchemaId());
			entityToUpdate.setTariffSchema(tariffSchemaEntity.orElseThrow());
		}
		if (persistRelations && entity.getTariffSchema() != null) {
			entityToUpdate.setTariffSchema(entity.getTariffSchema(), false);
			if (entityToUpdate.getTariffSchemaId() != null) {
				this.tariffSchemaRepository.save(entityToUpdate.getTariffSchema());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getTariffSchema().unsetInvoiceItems();
			}
		}

		// Outgoing one to many reference
		if (entity.getInvoiceItemComponentsIds().isEmpty() && entity.getInvoiceItemComponents().isEmpty()) {
			entityToUpdate.setInvoiceItemComponents(new HashSet<>());
		} else if (!entity.getInvoiceItemComponentsIds().isEmpty() && entity.getInvoiceItemComponents().isEmpty()) {
			Iterable<InvoiceItemComponentEntity> invoiceItemComponentsEntities =
					this.invoiceItemComponentRepository.findAllById(entity.getInvoiceItemComponentsIds());
			entityToUpdate.setInvoiceItemComponents(Sets.newHashSet(invoiceItemComponentsEntities));
		}
		if (persistRelations && !entity.getInvoiceItemComponents().isEmpty()) {
			Set<InvoiceItemComponentEntity> updatedEntities = new HashSet<>();
			entity.getInvoiceItemComponents().forEach(model -> {
				if (model.getId() != null) {
					model = this.invoiceItemComponentRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInvoiceItemComponents(updatedEntities);
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
	public void validateEntity(InvoiceItemEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<InvoiceItemEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the InvoiceItemEntity.
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

	public Set<String> validateEntityRelations(InvoiceItemEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getInvoiceId() != null && this.invoiceRepository.findById(entity.getInvoiceId()).isEmpty()) {
			errors.add("The UUID " + entity.getInvoiceId() + " is not associated with a Invoice Entity");
		}

		if (entity.getMedicalFeeId() != null && this.medicalFeeRepository.findById(entity.getMedicalFeeId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalFeeId() + " is not associated with a Medical Fee Entity");
		}

		if (entity.getMedicationHeaderId() != null && this.medicationHeaderRepository.findById(entity.getMedicationHeaderId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicationHeaderId() + " is not associated with a Medication Header Entity");
		}

		if (entity.getPrescriptionId() != null && this.prescriptionHeaderRepository.findById(entity.getPrescriptionId()).isEmpty()) {
			errors.add("The UUID " + entity.getPrescriptionId() + " is not associated with a Prescription Header Entity");
		}

		if (entity.getRetailPharmacyInvoiceId() != null && this.retailPharmacyInvoiceRepository.findById(entity.getRetailPharmacyInvoiceId()).isEmpty()) {
			errors.add("The UUID " + entity.getRetailPharmacyInvoiceId() + " is not associated with a Retail Pharmacy Invoice Entity");
		}

		if (entity.getServiceNumberId() != null && this.registrationRepository.findById(entity.getServiceNumberId()).isEmpty()) {
			errors.add("The UUID " + entity.getServiceNumberId() + " is not associated with a Registration Entity");
		}

		if (entity.getTariffSchemaId() != null && this.tariffSchemaRepository.findById(entity.getTariffSchemaId()).isEmpty()) {
			errors.add("The UUID " + entity.getTariffSchemaId() + " is not associated with a Tariff Schema Entity");
		}

		for (UUID id : entity.getInvoiceItemComponentsIds()) {
			if (this.invoiceItemComponentRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Invoice Item Component Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
