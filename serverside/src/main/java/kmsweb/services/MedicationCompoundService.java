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
import kmsweb.repositories.MedicationCompoundRepository;
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
import kmsweb.entities.MedicationAdministeredHistoryEntity;
import kmsweb.repositories.MedicationAdministeredHistoryRepository;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.repositories.MedicationHeaderRepository;
import kmsweb.entities.MedicationItemEntity;
import kmsweb.repositories.MedicationItemRepository;
import kmsweb.entities.UnitOfMeasurementEntity;
import kmsweb.repositories.UnitOfMeasurementRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class MedicationCompoundService extends AbstractService<MedicationCompoundEntity, MedicationCompoundRepository, MedicationCompoundEntityAudit> {

	private final String[] referenceNamesInMedicationCompoundEntity = {
		"medicationAdministeredHistories",
		"medicationItems",
		"medicationHeader",
		"unitOfMeasurement",
	};

	private final MedicationAdministeredHistoryRepository medicationAdministeredHistoryRepository;

	private final MedicationHeaderRepository medicationHeaderRepository;

	private final MedicationItemRepository medicationItemRepository;

	private final UnitOfMeasurementRepository unitOfMeasurementRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public MedicationCompoundService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		MedicationAdministeredHistoryRepository medicationAdministeredHistoryRepository,
		MedicationHeaderRepository medicationHeaderRepository,
		MedicationItemRepository medicationItemRepository,
		UnitOfMeasurementRepository unitOfMeasurementRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		MedicationCompoundRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.medicationAdministeredHistoryRepository = medicationAdministeredHistoryRepository;

		this.medicationHeaderRepository = medicationHeaderRepository;

		this.medicationItemRepository = medicationItemRepository;

		this.unitOfMeasurementRepository = unitOfMeasurementRepository;

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
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
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
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Compound Code.
	 *
	 * @param compoundCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Compound Code
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByCompoundCode(String compoundCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByCompoundCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCompoundCode here] end
	{
		// % protected region % [Add any additional logic for findByCompoundCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByCompoundCode before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByCompoundCode(compoundCode));

		// % protected region % [Add any additional logic for findByCompoundCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCompoundCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Compound Name.
	 *
	 * @param compoundName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Compound Name
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByCompoundName(String compoundName)
	// % protected region % [Add any throwables, implementations, or extensions for findByCompoundName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCompoundName here] end
	{
		// % protected region % [Add any additional logic for findByCompoundName before the main body here] off begin
		// % protected region % [Add any additional logic for findByCompoundName before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByCompoundName(compoundName));

		// % protected region % [Add any additional logic for findByCompoundName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCompoundName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Requested Qty.
	 *
	 * @param requestedQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Requested Qty
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByRequestedQty(Double requestedQty)
	// % protected region % [Add any throwables, implementations, or extensions for findByRequestedQty here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRequestedQty here] end
	{
		// % protected region % [Add any additional logic for findByRequestedQty before the main body here] off begin
		// % protected region % [Add any additional logic for findByRequestedQty before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByRequestedQty(requestedQty));

		// % protected region % [Add any additional logic for findByRequestedQty before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRequestedQty before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Outstanding Qty.
	 *
	 * @param outstandingQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Outstanding Qty
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByOutstandingQty(Double outstandingQty)
	// % protected region % [Add any throwables, implementations, or extensions for findByOutstandingQty here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOutstandingQty here] end
	{
		// % protected region % [Add any additional logic for findByOutstandingQty before the main body here] off begin
		// % protected region % [Add any additional logic for findByOutstandingQty before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByOutstandingQty(outstandingQty));

		// % protected region % [Add any additional logic for findByOutstandingQty before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOutstandingQty before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Returned Qty.
	 *
	 * @param returnedQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Returned Qty
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByReturnedQty(Double returnedQty)
	// % protected region % [Add any throwables, implementations, or extensions for findByReturnedQty here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReturnedQty here] end
	{
		// % protected region % [Add any additional logic for findByReturnedQty before the main body here] off begin
		// % protected region % [Add any additional logic for findByReturnedQty before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByReturnedQty(returnedQty));

		// % protected region % [Add any additional logic for findByReturnedQty before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReturnedQty before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Issued Qty.
	 *
	 * @param issuedQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Issued Qty
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByIssuedQty(Double issuedQty)
	// % protected region % [Add any throwables, implementations, or extensions for findByIssuedQty here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIssuedQty here] end
	{
		// % protected region % [Add any additional logic for findByIssuedQty before the main body here] off begin
		// % protected region % [Add any additional logic for findByIssuedQty before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByIssuedQty(issuedQty));

		// % protected region % [Add any additional logic for findByIssuedQty before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIssuedQty before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Administered Qty.
	 *
	 * @param administeredQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Administered Qty
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByAdministeredQty(Double administeredQty)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdministeredQty here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdministeredQty here] end
	{
		// % protected region % [Add any additional logic for findByAdministeredQty before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdministeredQty before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByAdministeredQty(administeredQty));

		// % protected region % [Add any additional logic for findByAdministeredQty before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdministeredQty before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Taken Home Qty.
	 *
	 * @param takenHomeQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Taken Home Qty
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByTakenHomeQty(Double takenHomeQty)
	// % protected region % [Add any throwables, implementations, or extensions for findByTakenHomeQty here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTakenHomeQty here] end
	{
		// % protected region % [Add any additional logic for findByTakenHomeQty before the main body here] off begin
		// % protected region % [Add any additional logic for findByTakenHomeQty before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByTakenHomeQty(takenHomeQty));

		// % protected region % [Add any additional logic for findByTakenHomeQty before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTakenHomeQty before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dosage Frequency.
	 *
	 * @param dosageFrequency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dosage Frequency
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByDosageFrequency(Double dosageFrequency)
	// % protected region % [Add any throwables, implementations, or extensions for findByDosageFrequency here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDosageFrequency here] end
	{
		// % protected region % [Add any additional logic for findByDosageFrequency before the main body here] off begin
		// % protected region % [Add any additional logic for findByDosageFrequency before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByDosageFrequency(dosageFrequency));

		// % protected region % [Add any additional logic for findByDosageFrequency before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDosageFrequency before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dosage Qty.
	 *
	 * @param dosageQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dosage Qty
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByDosageQty(Double dosageQty)
	// % protected region % [Add any throwables, implementations, or extensions for findByDosageQty here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDosageQty here] end
	{
		// % protected region % [Add any additional logic for findByDosageQty before the main body here] off begin
		// % protected region % [Add any additional logic for findByDosageQty before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByDosageQty(dosageQty));

		// % protected region % [Add any additional logic for findByDosageQty before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDosageQty before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dose.
	 *
	 * @param dose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dose
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByDose(Double dose)
	// % protected region % [Add any throwables, implementations, or extensions for findByDose here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDose here] end
	{
		// % protected region % [Add any additional logic for findByDose before the main body here] off begin
		// % protected region % [Add any additional logic for findByDose before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByDose(dose));

		// % protected region % [Add any additional logic for findByDose before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDose before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Frequency.
	 *
	 * @param frequency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Frequency
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByFrequency(String frequency)
	// % protected region % [Add any throwables, implementations, or extensions for findByFrequency here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFrequency here] end
	{
		// % protected region % [Add any additional logic for findByFrequency before the main body here] off begin
		// % protected region % [Add any additional logic for findByFrequency before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByFrequency(frequency));

		// % protected region % [Add any additional logic for findByFrequency before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFrequency before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Consumption Method.
	 *
	 * @param consumptionMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consumption Method
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByConsumptionMethod(String consumptionMethod)
	// % protected region % [Add any throwables, implementations, or extensions for findByConsumptionMethod here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByConsumptionMethod here] end
	{
		// % protected region % [Add any additional logic for findByConsumptionMethod before the main body here] off begin
		// % protected region % [Add any additional logic for findByConsumptionMethod before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByConsumptionMethod(consumptionMethod));

		// % protected region % [Add any additional logic for findByConsumptionMethod before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByConsumptionMethod before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Instruction.
	 *
	 * @param instruction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Instruction
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByInstruction(String instruction)
	// % protected region % [Add any throwables, implementations, or extensions for findByInstruction here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInstruction here] end
	{
		// % protected region % [Add any additional logic for findByInstruction before the main body here] off begin
		// % protected region % [Add any additional logic for findByInstruction before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByInstruction(instruction));

		// % protected region % [Add any additional logic for findByInstruction before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInstruction before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Price.
	 *
	 * @param totalPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Price
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByTotalPrice(Double totalPrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalPrice here] end
	{
		// % protected region % [Add any additional logic for findByTotalPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalPrice before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByTotalPrice(totalPrice));

		// % protected region % [Add any additional logic for findByTotalPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalPrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Is dtd.
	 *
	 * @param isDtd the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is dtd
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByIsDtd(Boolean isDtd)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsDtd here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsDtd here] end
	{
		// % protected region % [Add any additional logic for findByIsDtd before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsDtd before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByIsDtd(isDtd));

		// % protected region % [Add any additional logic for findByIsDtd before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsDtd before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Administered Quantity.
	 *
	 * @param totalAdministeredQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Administered Quantity
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByTotalAdministeredQuantity(Integer totalAdministeredQuantity)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalAdministeredQuantity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalAdministeredQuantity here] end
	{
		// % protected region % [Add any additional logic for findByTotalAdministeredQuantity before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalAdministeredQuantity before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByTotalAdministeredQuantity(totalAdministeredQuantity));

		// % protected region % [Add any additional logic for findByTotalAdministeredQuantity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalAdministeredQuantity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Issued Quantity.
	 *
	 * @param totalIssuedQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Issued Quantity
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByTotalIssuedQuantity(Double totalIssuedQuantity)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalIssuedQuantity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalIssuedQuantity here] end
	{
		// % protected region % [Add any additional logic for findByTotalIssuedQuantity before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalIssuedQuantity before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByTotalIssuedQuantity(totalIssuedQuantity));

		// % protected region % [Add any additional logic for findByTotalIssuedQuantity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalIssuedQuantity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Taken Home Quantity.
	 *
	 * @param totalTakenHomeQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Taken Home Quantity
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByTotalTakenHomeQuantity(Integer totalTakenHomeQuantity)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalTakenHomeQuantity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalTakenHomeQuantity here] end
	{
		// % protected region % [Add any additional logic for findByTotalTakenHomeQuantity before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalTakenHomeQuantity before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByTotalTakenHomeQuantity(totalTakenHomeQuantity));

		// % protected region % [Add any additional logic for findByTotalTakenHomeQuantity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalTakenHomeQuantity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Returned Quantity.
	 *
	 * @param totalReturnedQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Returned Quantity
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByTotalReturnedQuantity(Integer totalReturnedQuantity)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalReturnedQuantity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalReturnedQuantity here] end
	{
		// % protected region % [Add any additional logic for findByTotalReturnedQuantity before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalReturnedQuantity before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByTotalReturnedQuantity(totalReturnedQuantity));

		// % protected region % [Add any additional logic for findByTotalReturnedQuantity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalReturnedQuantity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute External Compound Name.
	 *
	 * @param externalCompoundName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute External Compound Name
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByExternalCompoundName(String externalCompoundName)
	// % protected region % [Add any throwables, implementations, or extensions for findByExternalCompoundName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExternalCompoundName here] end
	{
		// % protected region % [Add any additional logic for findByExternalCompoundName before the main body here] off begin
		// % protected region % [Add any additional logic for findByExternalCompoundName before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByExternalCompoundName(externalCompoundName));

		// % protected region % [Add any additional logic for findByExternalCompoundName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExternalCompoundName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Approval Status.
	 *
	 * @param approvalStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Status
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByApprovalStatus(String approvalStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalStatus here] end
	{
		// % protected region % [Add any additional logic for findByApprovalStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByApprovalStatus before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByApprovalStatus(approvalStatus));

		// % protected region % [Add any additional logic for findByApprovalStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApprovalStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Rounding Value.
	 *
	 * @param inventoryRoundingValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Rounding Value
	 */
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findByInventoryRoundingValue(Double inventoryRoundingValue)
	// % protected region % [Add any throwables, implementations, or extensions for findByInventoryRoundingValue here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInventoryRoundingValue here] end
	{
		// % protected region % [Add any additional logic for findByInventoryRoundingValue before the main body here] off begin
		// % protected region % [Add any additional logic for findByInventoryRoundingValue before the main body here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findByInventoryRoundingValue(inventoryRoundingValue));

		// % protected region % [Add any additional logic for findByInventoryRoundingValue before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInventoryRoundingValue before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<MedicationCompoundEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<MedicationCompoundEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<MedicationCompoundEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<MedicationCompoundEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'create')")
	public MedicationCompoundEntity create(MedicationCompoundEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		MedicationCompoundEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'create')")
	public MedicationCompoundEntity create(MedicationCompoundEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		MedicationCompoundEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		MedicationCompoundEntity newEntity;

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
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'create')")
	public List<MedicationCompoundEntity> createAll(Iterable<MedicationCompoundEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<MedicationCompoundEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<MedicationCompoundEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'update')")
	public MedicationCompoundEntity update(MedicationCompoundEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		MedicationCompoundEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'update')")
	public MedicationCompoundEntity update(MedicationCompoundEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		MedicationCompoundEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		MedicationCompoundEntity newEntity;

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
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'update')")
	public List<MedicationCompoundEntity> updateAll(Iterable<MedicationCompoundEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<MedicationCompoundEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<MedicationCompoundEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'create') or hasPermission('MedicationCompoundEntity', 'update')")
	public MedicationCompoundEntity save(MedicationCompoundEntity entity) throws ConstraintViolationException
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

		MedicationCompoundEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'create') or hasPermission('MedicationCompoundEntity', 'update')")
	public List<MedicationCompoundEntity> saveAll(Iterable<MedicationCompoundEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<MedicationCompoundEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'delete')")
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
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'delete')")
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
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	public List<MedicationCompoundEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	public List<MedicationCompoundEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(MedicationCompoundEntity.class);

		// % protected region % [Add any additional processing before converting to a list of MedicationCompoundEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of MedicationCompoundEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<MedicationCompoundEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of MedicationCompoundEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of MedicationCompoundEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(MedicationCompoundEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of MedicationCompoundEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of MedicationCompoundEntityAudits
	 */
	private List<MedicationCompoundEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<MedicationCompoundEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param medicationCompound medicationCompound to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private MedicationCompoundEntity updateAuditData(MedicationCompoundEntity medicationCompound)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return medicationCompound;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private MedicationCompoundEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		MedicationCompoundEntity entityAtRevision = updateAuditData((MedicationCompoundEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new MedicationCompoundEntityAudit(
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

		QMedicationCompoundEntity entity = QMedicationCompoundEntity.medicationCompoundEntity;

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
			case "medicationHeaderId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medication Header to Medication Compounds here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medication Header to Medication Compounds here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicationHeader.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medication Header to Medication Compounds here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medication Header to Medication Compounds here] end

				break;
			case "unitOfMeasurementId":
				// % protected region % [Add any additional logic before the query parameters of relation from Unit Of Measurement to Medication Compounds here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Unit Of Measurement to Medication Compounds here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.unitOfMeasurement.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Unit Of Measurement to Medication Compounds here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Unit Of Measurement to Medication Compounds here] end

				break;
			case "medicationAdministeredHistoriesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medication Compound to Medication Administered Histories here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medication Compound to Medication Administered Histories here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicationAdministeredHistories.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medication Compound to Medication Administered Histories here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medication Compound to Medication Administered Histories here] end

				break;
			case "medicationItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medication Compound to Medication Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medication Compound to Medication Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicationItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medication Compound to Medication Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medication Compound to Medication Items here] end

				break;
			case "compoundCode":
				// % protected region % [Add any additional logic before the query parameters of compoundCode here] off begin
				// % protected region % [Add any additional logic before the query parameters of compoundCode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.compoundCode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of compoundCode here] off begin
				// % protected region % [Add any additional logic after the query parameters of compoundCode here] end

				break;
			case "compoundName":
				// % protected region % [Add any additional logic before the query parameters of compoundName here] off begin
				// % protected region % [Add any additional logic before the query parameters of compoundName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.compoundName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of compoundName here] off begin
				// % protected region % [Add any additional logic after the query parameters of compoundName here] end

				break;
			case "instruction":
				// % protected region % [Add any additional logic before the query parameters of instruction here] off begin
				// % protected region % [Add any additional logic before the query parameters of instruction here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.instruction, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of instruction here] off begin
				// % protected region % [Add any additional logic after the query parameters of instruction here] end

				break;
			case "totalAdministeredQuantity":
				// % protected region % [Add any additional logic before the query parameters of totalAdministeredQuantity here] off begin
				// % protected region % [Add any additional logic before the query parameters of totalAdministeredQuantity here] end


				// % protected region % [Add any additional logic after the query parameters of totalAdministeredQuantity here] off begin
				// % protected region % [Add any additional logic after the query parameters of totalAdministeredQuantity here] end

				break;
			case "totalIssuedQuantity":
				// % protected region % [Add any additional logic before the query parameters of totalIssuedQuantity here] off begin
				// % protected region % [Add any additional logic before the query parameters of totalIssuedQuantity here] end


				// % protected region % [Add any additional logic after the query parameters of totalIssuedQuantity here] off begin
				// % protected region % [Add any additional logic after the query parameters of totalIssuedQuantity here] end

				break;
			case "totalTakenHomeQuantity":
				// % protected region % [Add any additional logic before the query parameters of totalTakenHomeQuantity here] off begin
				// % protected region % [Add any additional logic before the query parameters of totalTakenHomeQuantity here] end


				// % protected region % [Add any additional logic after the query parameters of totalTakenHomeQuantity here] off begin
				// % protected region % [Add any additional logic after the query parameters of totalTakenHomeQuantity here] end

				break;
			case "totalReturnedQuantity":
				// % protected region % [Add any additional logic before the query parameters of totalReturnedQuantity here] off begin
				// % protected region % [Add any additional logic before the query parameters of totalReturnedQuantity here] end


				// % protected region % [Add any additional logic after the query parameters of totalReturnedQuantity here] off begin
				// % protected region % [Add any additional logic after the query parameters of totalReturnedQuantity here] end

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
	public MedicationCompoundEntity updateOldData(MedicationCompoundEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public MedicationCompoundEntity updateOldData(MedicationCompoundEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		MedicationCompoundEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInMedicationCompoundEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getIsDtd() == null) {
			entityToUpdate.setIsDtd(false);
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
				entityToUpdate.getMedicationHeader().unsetMedicationCompounds();
			}
		}

		// Incoming One to Many reference
		if (entity.getUnitOfMeasurement() == null && entity.getUnitOfMeasurementId() == null) {
			entityToUpdate.unsetUnitOfMeasurement();
		} else if (entity.getUnitOfMeasurementId() != null && entity.getUnitOfMeasurement() == null) {
			Optional<UnitOfMeasurementEntity> unitOfMeasurementEntity = this.unitOfMeasurementRepository.findById(entity.getUnitOfMeasurementId());
			entityToUpdate.setUnitOfMeasurement(unitOfMeasurementEntity.orElseThrow());
		}
		if (persistRelations && entity.getUnitOfMeasurement() != null) {
			entityToUpdate.setUnitOfMeasurement(entity.getUnitOfMeasurement(), false);
			if (entityToUpdate.getUnitOfMeasurementId() != null) {
				this.unitOfMeasurementRepository.save(entityToUpdate.getUnitOfMeasurement());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getUnitOfMeasurement().unsetMedicationCompounds();
			}
		}

		// Outgoing one to many reference
		if (entity.getMedicationAdministeredHistoriesIds().isEmpty() && entity.getMedicationAdministeredHistories().isEmpty()) {
			entityToUpdate.setMedicationAdministeredHistories(new HashSet<>());
		} else if (!entity.getMedicationAdministeredHistoriesIds().isEmpty() && entity.getMedicationAdministeredHistories().isEmpty()) {
			Iterable<MedicationAdministeredHistoryEntity> medicationAdministeredHistoriesEntities =
					this.medicationAdministeredHistoryRepository.findAllById(entity.getMedicationAdministeredHistoriesIds());
			entityToUpdate.setMedicationAdministeredHistories(Sets.newHashSet(medicationAdministeredHistoriesEntities));
		}
		if (persistRelations && !entity.getMedicationAdministeredHistories().isEmpty()) {
			Set<MedicationAdministeredHistoryEntity> updatedEntities = new HashSet<>();
			entity.getMedicationAdministeredHistories().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicationAdministeredHistoryRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicationAdministeredHistories(updatedEntities);
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
	public void validateEntity(MedicationCompoundEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<MedicationCompoundEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the MedicationCompoundEntity.
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

	public Set<String> validateEntityRelations(MedicationCompoundEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getMedicationHeaderId() != null && this.medicationHeaderRepository.findById(entity.getMedicationHeaderId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicationHeaderId() + " is not associated with a Medication Header Entity");
		}

		if (entity.getUnitOfMeasurementId() != null && this.unitOfMeasurementRepository.findById(entity.getUnitOfMeasurementId()).isEmpty()) {
			errors.add("The UUID " + entity.getUnitOfMeasurementId() + " is not associated with a Unit Of Measurement Entity");
		}

		for (UUID id : entity.getMedicationAdministeredHistoriesIds()) {
			if (this.medicationAdministeredHistoryRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medication Administered History Entity");
			}
		}

		for (UUID id : entity.getMedicationItemsIds()) {
			if (this.medicationItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medication Item Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}