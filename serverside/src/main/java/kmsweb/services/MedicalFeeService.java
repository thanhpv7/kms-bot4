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
import kmsweb.repositories.MedicalFeeRepository;
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
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.repositories.InvoiceItemRepository;
import kmsweb.entities.MedicalFeeItemComponentEntity;
import kmsweb.repositories.MedicalFeeItemComponentRepository;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
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
public class MedicalFeeService extends AbstractService<MedicalFeeEntity, MedicalFeeRepository, MedicalFeeEntityAudit> {

	private final String[] referenceNamesInMedicalFeeEntity = {
		"invoiceItems",
		"medicalFeeItemComponents",
		"registration",
		"warehouse",
	};

	private final InvoiceItemRepository invoiceItemRepository;

	private final MedicalFeeItemComponentRepository medicalFeeItemComponentRepository;

	private final RegistrationRepository registrationRepository;

	private final WarehouseRepository warehouseRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public MedicalFeeService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		InvoiceItemRepository invoiceItemRepository,
		MedicalFeeItemComponentRepository medicalFeeItemComponentRepository,
		RegistrationRepository registrationRepository,
		WarehouseRepository warehouseRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		MedicalFeeRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.invoiceItemRepository = invoiceItemRepository;

		this.medicalFeeItemComponentRepository = medicalFeeItemComponentRepository;

		this.registrationRepository = registrationRepository;

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
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
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
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Tariff Type.
	 *
	 * @param tariffType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Type
	 */
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByTariffType(TariffTypeEnum tariffType)
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffType here] end
	{
		// % protected region % [Add any additional logic for findByTariffType before the main body here] off begin
		// % protected region % [Add any additional logic for findByTariffType before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByTariffType(tariffType));

		// % protected region % [Add any additional logic for findByTariffType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTariffType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Code.
	 *
	 * @param tariffCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Code
	 */
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByTariffCode(String tariffCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffCode here] end
	{
		// % protected region % [Add any additional logic for findByTariffCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByTariffCode before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByTariffCode(tariffCode));

		// % protected region % [Add any additional logic for findByTariffCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTariffCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Name.
	 *
	 * @param name the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name
	 */
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByName(String name)
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] end
	{
		// % protected region % [Add any additional logic for findByName before the main body here] off begin
		// % protected region % [Add any additional logic for findByName before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByName(name));

		// % protected region % [Add any additional logic for findByName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pharmacy Transaction Type.
	 *
	 * @param pharmacyTransactionType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pharmacy Transaction Type
	 */
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByPharmacyTransactionType(PharmacyTypeEnum pharmacyTransactionType)
	// % protected region % [Add any throwables, implementations, or extensions for findByPharmacyTransactionType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPharmacyTransactionType here] end
	{
		// % protected region % [Add any additional logic for findByPharmacyTransactionType before the main body here] off begin
		// % protected region % [Add any additional logic for findByPharmacyTransactionType before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByPharmacyTransactionType(pharmacyTransactionType));

		// % protected region % [Add any additional logic for findByPharmacyTransactionType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPharmacyTransactionType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pharmacy Transaction Number.
	 *
	 * @param pharmacyTransactionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pharmacy Transaction Number
	 */
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByPharmacyTransactionNumber(String pharmacyTransactionNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByPharmacyTransactionNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPharmacyTransactionNumber here] end
	{
		// % protected region % [Add any additional logic for findByPharmacyTransactionNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByPharmacyTransactionNumber before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByPharmacyTransactionNumber(pharmacyTransactionNumber));

		// % protected region % [Add any additional logic for findByPharmacyTransactionNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPharmacyTransactionNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Medication Transaction Number.
	 *
	 * @param medicationTransactionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medication Transaction Number
	 */
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByMedicationTransactionNumber(String medicationTransactionNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicationTransactionNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicationTransactionNumber here] end
	{
		// % protected region % [Add any additional logic for findByMedicationTransactionNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByMedicationTransactionNumber before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByMedicationTransactionNumber(medicationTransactionNumber));

		// % protected region % [Add any additional logic for findByMedicationTransactionNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMedicationTransactionNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Date.
	 *
	 * @param transactionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Date
	 */
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByTransactionDate(OffsetDateTime transactionDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionDate here] end
	{
		// % protected region % [Add any additional logic for findByTransactionDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByTransactionDate before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByTransactionDate(transactionDate));

		// % protected region % [Add any additional logic for findByTransactionDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTransactionDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Quantity.
	 *
	 * @param quantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity
	 */
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByQuantity(Double quantity)
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantity here] end
	{
		// % protected region % [Add any additional logic for findByQuantity before the main body here] off begin
		// % protected region % [Add any additional logic for findByQuantity before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByQuantity(quantity));

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
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByUnit(String unit)
	// % protected region % [Add any throwables, implementations, or extensions for findByUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUnit here] end
	{
		// % protected region % [Add any additional logic for findByUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByUnit before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByUnit(unit));

		// % protected region % [Add any additional logic for findByUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Unit Price.
	 *
	 * @param unitPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unit Price
	 */
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByUnitPrice(Double unitPrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByUnitPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUnitPrice here] end
	{
		// % protected region % [Add any additional logic for findByUnitPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByUnitPrice before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByUnitPrice(unitPrice));

		// % protected region % [Add any additional logic for findByUnitPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUnitPrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Price.
	 *
	 * @param hospitalPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Price
	 */
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByHospitalPrice(Double hospitalPrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalPrice here] end
	{
		// % protected region % [Add any additional logic for findByHospitalPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByHospitalPrice before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByHospitalPrice(hospitalPrice));

		// % protected region % [Add any additional logic for findByHospitalPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHospitalPrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Other Component Price.
	 *
	 * @param otherComponentPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Component Price
	 */
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByOtherComponentPrice(Double otherComponentPrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherComponentPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherComponentPrice here] end
	{
		// % protected region % [Add any additional logic for findByOtherComponentPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtherComponentPrice before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByOtherComponentPrice(otherComponentPrice));

		// % protected region % [Add any additional logic for findByOtherComponentPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtherComponentPrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Medical Staff Code.
	 *
	 * @param medicalStaffCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medical Staff Code
	 */
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByMedicalStaffCode(String medicalStaffCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicalStaffCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicalStaffCode here] end
	{
		// % protected region % [Add any additional logic for findByMedicalStaffCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByMedicalStaffCode before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByMedicalStaffCode(medicalStaffCode));

		// % protected region % [Add any additional logic for findByMedicalStaffCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMedicalStaffCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByTreatmentClass(String treatmentClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] end
	{
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByTreatmentClass(treatmentClass));

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
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute medical fee status.
	 *
	 * @param medicalFeeStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute medical fee status
	 */
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByMedicalFeeStatus(MedicalFeeStatusEnum medicalFeeStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicalFeeStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicalFeeStatus here] end
	{
		// % protected region % [Add any additional logic for findByMedicalFeeStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByMedicalFeeStatus before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByMedicalFeeStatus(medicalFeeStatus));

		// % protected region % [Add any additional logic for findByMedicalFeeStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMedicalFeeStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Rounding Value.
	 *
	 * @param inventoryRoundingValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Rounding Value
	 */
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findByInventoryRoundingValue(Double inventoryRoundingValue)
	// % protected region % [Add any throwables, implementations, or extensions for findByInventoryRoundingValue here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInventoryRoundingValue here] end
	{
		// % protected region % [Add any additional logic for findByInventoryRoundingValue before the main body here] off begin
		// % protected region % [Add any additional logic for findByInventoryRoundingValue before the main body here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findByInventoryRoundingValue(inventoryRoundingValue));

		// % protected region % [Add any additional logic for findByInventoryRoundingValue before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInventoryRoundingValue before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<MedicalFeeEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<MedicalFeeEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<MedicalFeeEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<MedicalFeeEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'create')")
	public MedicalFeeEntity create(MedicalFeeEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		MedicalFeeEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'create')")
	public MedicalFeeEntity create(MedicalFeeEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		MedicalFeeEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		MedicalFeeEntity newEntity;

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
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'create')")
	public List<MedicalFeeEntity> createAll(Iterable<MedicalFeeEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<MedicalFeeEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<MedicalFeeEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'update')")
	public MedicalFeeEntity update(MedicalFeeEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		MedicalFeeEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'update')")
	public MedicalFeeEntity update(MedicalFeeEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		MedicalFeeEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		MedicalFeeEntity newEntity;

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
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'update')")
	public List<MedicalFeeEntity> updateAll(Iterable<MedicalFeeEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<MedicalFeeEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<MedicalFeeEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'create') or hasPermission('MedicalFeeEntity', 'update')")
	public MedicalFeeEntity save(MedicalFeeEntity entity) throws ConstraintViolationException
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

		MedicalFeeEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'create') or hasPermission('MedicalFeeEntity', 'update')")
	public List<MedicalFeeEntity> saveAll(Iterable<MedicalFeeEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<MedicalFeeEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'delete')")
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
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'delete')")
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
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	public List<MedicalFeeEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	public List<MedicalFeeEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(MedicalFeeEntity.class);

		// % protected region % [Add any additional processing before converting to a list of MedicalFeeEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of MedicalFeeEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<MedicalFeeEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of MedicalFeeEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of MedicalFeeEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(MedicalFeeEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of MedicalFeeEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of MedicalFeeEntityAudits
	 */
	private List<MedicalFeeEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<MedicalFeeEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param medicalFee medicalFee to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private MedicalFeeEntity updateAuditData(MedicalFeeEntity medicalFee)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return medicalFee;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private MedicalFeeEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		MedicalFeeEntity entityAtRevision = updateAuditData((MedicalFeeEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new MedicalFeeEntityAudit(
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

		QMedicalFeeEntity entity = QMedicalFeeEntity.medicalFeeEntity;

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
			case "registrationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Fees here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Fees here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registration.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Fees here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Fees here] end

				break;
			case "warehouseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Medical Fees here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Medical Fees here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.warehouse.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Medical Fees here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Medical Fees here] end

				break;
			case "invoiceItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Fee to Invoice Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Fee to Invoice Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Fee to Invoice Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Fee to Invoice Items here] end

				break;
			case "medicalFeeItemComponentsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Fee to Medical Fee Item Components here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Fee to Medical Fee Item Components here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalFeeItemComponents.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Fee to Medical Fee Item Components here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Fee to Medical Fee Item Components here] end

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
	public MedicalFeeEntity updateOldData(MedicalFeeEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public MedicalFeeEntity updateOldData(MedicalFeeEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		MedicalFeeEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInMedicalFeeEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getRegistration() == null && entity.getRegistrationId() == null) {
			entityToUpdate.unsetRegistration();
		} else if (entity.getRegistrationId() != null && entity.getRegistration() == null) {
			Optional<RegistrationEntity> registrationEntity = this.registrationRepository.findById(entity.getRegistrationId());
			entityToUpdate.setRegistration(registrationEntity.orElseThrow());
		}
		if (persistRelations && entity.getRegistration() != null) {
			entityToUpdate.setRegistration(entity.getRegistration(), false);
			if (entityToUpdate.getRegistrationId() != null) {
				this.registrationRepository.save(entityToUpdate.getRegistration());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getRegistration().unsetMedicalFees();
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
				entityToUpdate.getWarehouse().unsetMedicalFees();
			}
		}

		// Outgoing one to many reference
		if (entity.getInvoiceItemsIds().isEmpty() && entity.getInvoiceItems().isEmpty()) {
			entityToUpdate.setInvoiceItems(new HashSet<>());
		} else if (!entity.getInvoiceItemsIds().isEmpty() && entity.getInvoiceItems().isEmpty()) {
			Iterable<InvoiceItemEntity> invoiceItemsEntities =
					this.invoiceItemRepository.findAllById(entity.getInvoiceItemsIds());
			entityToUpdate.setInvoiceItems(Sets.newHashSet(invoiceItemsEntities));
		}
		if (persistRelations && !entity.getInvoiceItems().isEmpty()) {
			Set<InvoiceItemEntity> updatedEntities = new HashSet<>();
			entity.getInvoiceItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.invoiceItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInvoiceItems(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicalFeeItemComponentsIds().isEmpty() && entity.getMedicalFeeItemComponents().isEmpty()) {
			entityToUpdate.setMedicalFeeItemComponents(new HashSet<>());
		} else if (!entity.getMedicalFeeItemComponentsIds().isEmpty() && entity.getMedicalFeeItemComponents().isEmpty()) {
			Iterable<MedicalFeeItemComponentEntity> medicalFeeItemComponentsEntities =
					this.medicalFeeItemComponentRepository.findAllById(entity.getMedicalFeeItemComponentsIds());
			entityToUpdate.setMedicalFeeItemComponents(Sets.newHashSet(medicalFeeItemComponentsEntities));
		}
		if (persistRelations && !entity.getMedicalFeeItemComponents().isEmpty()) {
			Set<MedicalFeeItemComponentEntity> updatedEntities = new HashSet<>();
			entity.getMedicalFeeItemComponents().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicalFeeItemComponentRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicalFeeItemComponents(updatedEntities);
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
	public void validateEntity(MedicalFeeEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<MedicalFeeEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the MedicalFeeEntity.
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

	public Set<String> validateEntityRelations(MedicalFeeEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getRegistrationId() != null && this.registrationRepository.findById(entity.getRegistrationId()).isEmpty()) {
			errors.add("The UUID " + entity.getRegistrationId() + " is not associated with a Registration Entity");
		}

		if (entity.getWarehouseId() != null && this.warehouseRepository.findById(entity.getWarehouseId()).isEmpty()) {
			errors.add("The UUID " + entity.getWarehouseId() + " is not associated with a Warehouse Entity");
		}

		for (UUID id : entity.getInvoiceItemsIds()) {
			if (this.invoiceItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Invoice Item Entity");
			}
		}

		for (UUID id : entity.getMedicalFeeItemComponentsIds()) {
			if (this.medicalFeeItemComponentRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medical Fee Item Component Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
