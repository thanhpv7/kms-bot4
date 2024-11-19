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
import kmsweb.repositories.CatalogueMedicalRepository;
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
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.repositories.StockCatalogueRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class CatalogueMedicalService extends AbstractService<CatalogueMedicalEntity, CatalogueMedicalRepository, CatalogueMedicalEntityAudit> {

	private final String[] referenceNamesInCatalogueMedicalEntity = {
		"stockCatalogue",
	};

	private final StockCatalogueRepository stockCatalogueRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public CatalogueMedicalService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		StockCatalogueRepository stockCatalogueRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		CatalogueMedicalRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.stockCatalogueRepository = stockCatalogueRepository;

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
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
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
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Composition.
	 *
	 * @param composition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Composition
	 */
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findByComposition(String composition)
	// % protected region % [Add any throwables, implementations, or extensions for findByComposition here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByComposition here] end
	{
		// % protected region % [Add any additional logic for findByComposition before the main body here] off begin
		// % protected region % [Add any additional logic for findByComposition before the main body here] end

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(repository.findByComposition(composition));

		// % protected region % [Add any additional logic for findByComposition before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByComposition before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Can be prescribed.
	 *
	 * @param canBePrescribed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Can be prescribed
	 */
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findByCanBePrescribed(Boolean canBePrescribed)
	// % protected region % [Add any throwables, implementations, or extensions for findByCanBePrescribed here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCanBePrescribed here] end
	{
		// % protected region % [Add any additional logic for findByCanBePrescribed before the main body here] off begin
		// % protected region % [Add any additional logic for findByCanBePrescribed before the main body here] end

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(repository.findByCanBePrescribed(canBePrescribed));

		// % protected region % [Add any additional logic for findByCanBePrescribed before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCanBePrescribed before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Is Hospital Formulary.
	 *
	 * @param isHospitalFormulary the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Hospital Formulary
	 */
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findByIsHospitalFormulary(Boolean isHospitalFormulary)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsHospitalFormulary here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsHospitalFormulary here] end
	{
		// % protected region % [Add any additional logic for findByIsHospitalFormulary before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsHospitalFormulary before the main body here] end

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(repository.findByIsHospitalFormulary(isHospitalFormulary));

		// % protected region % [Add any additional logic for findByIsHospitalFormulary before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsHospitalFormulary before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Approval Notes.
	 *
	 * @param approvalNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Notes
	 */
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findByApprovalNotes(String approvalNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalNotes here] end
	{
		// % protected region % [Add any additional logic for findByApprovalNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByApprovalNotes before the main body here] end

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(repository.findByApprovalNotes(approvalNotes));

		// % protected region % [Add any additional logic for findByApprovalNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApprovalNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Is Generic.
	 *
	 * @param isGeneric the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Generic
	 */
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findByIsGeneric(Boolean isGeneric)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsGeneric here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsGeneric here] end
	{
		// % protected region % [Add any additional logic for findByIsGeneric before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsGeneric before the main body here] end

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(repository.findByIsGeneric(isGeneric));

		// % protected region % [Add any additional logic for findByIsGeneric before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsGeneric before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Is Restricted.
	 *
	 * @param isRestricted the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Restricted
	 */
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findByIsRestricted(Boolean isRestricted)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsRestricted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsRestricted here] end
	{
		// % protected region % [Add any additional logic for findByIsRestricted before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsRestricted before the main body here] end

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(repository.findByIsRestricted(isRestricted));

		// % protected region % [Add any additional logic for findByIsRestricted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsRestricted before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Is Vaccine.
	 *
	 * @param isVaccine the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Vaccine
	 */
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findByIsVaccine(Boolean isVaccine)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsVaccine here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsVaccine here] end
	{
		// % protected region % [Add any additional logic for findByIsVaccine before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsVaccine before the main body here] end

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(repository.findByIsVaccine(isVaccine));

		// % protected region % [Add any additional logic for findByIsVaccine before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsVaccine before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Vaccine Type.
	 *
	 * @param vaccineType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Vaccine Type
	 */
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findByVaccineType(String vaccineType)
	// % protected region % [Add any throwables, implementations, or extensions for findByVaccineType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVaccineType here] end
	{
		// % protected region % [Add any additional logic for findByVaccineType before the main body here] off begin
		// % protected region % [Add any additional logic for findByVaccineType before the main body here] end

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(repository.findByVaccineType(vaccineType));

		// % protected region % [Add any additional logic for findByVaccineType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVaccineType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Consumption Method.
	 *
	 * @param consumptionMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consumption Method
	 */
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findByConsumptionMethod(String consumptionMethod)
	// % protected region % [Add any throwables, implementations, or extensions for findByConsumptionMethod here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByConsumptionMethod here] end
	{
		// % protected region % [Add any additional logic for findByConsumptionMethod before the main body here] off begin
		// % protected region % [Add any additional logic for findByConsumptionMethod before the main body here] end

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(repository.findByConsumptionMethod(consumptionMethod));

		// % protected region % [Add any additional logic for findByConsumptionMethod before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByConsumptionMethod before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Consumption Unit.
	 *
	 * @param consumptionUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consumption Unit
	 */
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findByConsumptionUnit(String consumptionUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByConsumptionUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByConsumptionUnit here] end
	{
		// % protected region % [Add any additional logic for findByConsumptionUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByConsumptionUnit before the main body here] end

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(repository.findByConsumptionUnit(consumptionUnit));

		// % protected region % [Add any additional logic for findByConsumptionUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByConsumptionUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Compound Charging Rounding.
	 *
	 * @param compoundChargingRounding the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Compound Charging Rounding
	 */
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findByCompoundChargingRounding(Boolean compoundChargingRounding)
	// % protected region % [Add any throwables, implementations, or extensions for findByCompoundChargingRounding here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCompoundChargingRounding here] end
	{
		// % protected region % [Add any additional logic for findByCompoundChargingRounding before the main body here] off begin
		// % protected region % [Add any additional logic for findByCompoundChargingRounding before the main body here] end

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(repository.findByCompoundChargingRounding(compoundChargingRounding));

		// % protected region % [Add any additional logic for findByCompoundChargingRounding before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCompoundChargingRounding before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Compound Charging Rounding Amount.
	 *
	 * @param compoundChargingRoundingAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Compound Charging Rounding Amount
	 */
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findByCompoundChargingRoundingAmount(String compoundChargingRoundingAmount)
	// % protected region % [Add any throwables, implementations, or extensions for findByCompoundChargingRoundingAmount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCompoundChargingRoundingAmount here] end
	{
		// % protected region % [Add any additional logic for findByCompoundChargingRoundingAmount before the main body here] off begin
		// % protected region % [Add any additional logic for findByCompoundChargingRoundingAmount before the main body here] end

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(repository.findByCompoundChargingRoundingAmount(compoundChargingRoundingAmount));

		// % protected region % [Add any additional logic for findByCompoundChargingRoundingAmount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCompoundChargingRoundingAmount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Rounding.
	 *
	 * @param inventoryRounding the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Rounding
	 */
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findByInventoryRounding(Boolean inventoryRounding)
	// % protected region % [Add any throwables, implementations, or extensions for findByInventoryRounding here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInventoryRounding here] end
	{
		// % protected region % [Add any additional logic for findByInventoryRounding before the main body here] off begin
		// % protected region % [Add any additional logic for findByInventoryRounding before the main body here] end

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(repository.findByInventoryRounding(inventoryRounding));

		// % protected region % [Add any additional logic for findByInventoryRounding before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInventoryRounding before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Rounding Amount.
	 *
	 * @param inventoryRoundingAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Rounding Amount
	 */
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findByInventoryRoundingAmount(Double inventoryRoundingAmount)
	// % protected region % [Add any throwables, implementations, or extensions for findByInventoryRoundingAmount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInventoryRoundingAmount here] end
	{
		// % protected region % [Add any additional logic for findByInventoryRoundingAmount before the main body here] off begin
		// % protected region % [Add any additional logic for findByInventoryRoundingAmount before the main body here] end

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(repository.findByInventoryRoundingAmount(inventoryRoundingAmount));

		// % protected region % [Add any additional logic for findByInventoryRoundingAmount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInventoryRoundingAmount before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<CatalogueMedicalEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<CatalogueMedicalEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<CatalogueMedicalEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'create')")
	public CatalogueMedicalEntity create(CatalogueMedicalEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		CatalogueMedicalEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'create')")
	public CatalogueMedicalEntity create(CatalogueMedicalEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		CatalogueMedicalEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		CatalogueMedicalEntity newEntity;

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
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'create')")
	public List<CatalogueMedicalEntity> createAll(Iterable<CatalogueMedicalEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<CatalogueMedicalEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<CatalogueMedicalEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'update')")
	public CatalogueMedicalEntity update(CatalogueMedicalEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		CatalogueMedicalEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'update')")
	public CatalogueMedicalEntity update(CatalogueMedicalEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		CatalogueMedicalEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		CatalogueMedicalEntity newEntity;

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
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'update')")
	public List<CatalogueMedicalEntity> updateAll(Iterable<CatalogueMedicalEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<CatalogueMedicalEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<CatalogueMedicalEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'create') or hasPermission('CatalogueMedicalEntity', 'update')")
	public CatalogueMedicalEntity save(CatalogueMedicalEntity entity) throws ConstraintViolationException
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

		CatalogueMedicalEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'create') or hasPermission('CatalogueMedicalEntity', 'update')")
	public List<CatalogueMedicalEntity> saveAll(Iterable<CatalogueMedicalEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<CatalogueMedicalEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'delete')")
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
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'delete')")
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
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	public List<CatalogueMedicalEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	public List<CatalogueMedicalEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(CatalogueMedicalEntity.class);

		// % protected region % [Add any additional processing before converting to a list of CatalogueMedicalEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of CatalogueMedicalEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<CatalogueMedicalEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of CatalogueMedicalEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of CatalogueMedicalEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(CatalogueMedicalEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of CatalogueMedicalEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of CatalogueMedicalEntityAudits
	 */
	private List<CatalogueMedicalEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<CatalogueMedicalEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param catalogueMedical catalogueMedical to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private CatalogueMedicalEntity updateAuditData(CatalogueMedicalEntity catalogueMedical)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return catalogueMedical;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private CatalogueMedicalEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		CatalogueMedicalEntity entityAtRevision = updateAuditData((CatalogueMedicalEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new CatalogueMedicalEntityAudit(
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

		QCatalogueMedicalEntity entity = QCatalogueMedicalEntity.catalogueMedicalEntity;

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
			case "stockCatalogueId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Stock Catalogue Medical  here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Stock Catalogue Medical  here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockCatalogue.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Stock Catalogue Medical  here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Stock Catalogue Medical  here] end

				break;
			case "inventoryRoundingAmount":
				// % protected region % [Add any additional logic before the query parameters of inventoryRoundingAmount here] off begin
				// % protected region % [Add any additional logic before the query parameters of inventoryRoundingAmount here] end


				// % protected region % [Add any additional logic after the query parameters of inventoryRoundingAmount here] off begin
				// % protected region % [Add any additional logic after the query parameters of inventoryRoundingAmount here] end

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
	public CatalogueMedicalEntity updateOldData(CatalogueMedicalEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public CatalogueMedicalEntity updateOldData(CatalogueMedicalEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		CatalogueMedicalEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInCatalogueMedicalEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getCanBePrescribed() == null) {
			entityToUpdate.setCanBePrescribed(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getIsHospitalFormulary() == null) {
			entityToUpdate.setIsHospitalFormulary(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getIsGeneric() == null) {
			entityToUpdate.setIsGeneric(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getIsRestricted() == null) {
			entityToUpdate.setIsRestricted(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getIsVaccine() == null) {
			entityToUpdate.setIsVaccine(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getCompoundChargingRounding() == null) {
			entityToUpdate.setCompoundChargingRounding(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getInventoryRounding() == null) {
			entityToUpdate.setInventoryRounding(false);
		}

		// Incoming One to One reference
		if (entity.getStockCatalogue() == null && entity.getStockCatalogueId() == null) {
			entityToUpdate.unsetStockCatalogue();
		} else if (entity.getStockCatalogueId() != null && entity.getStockCatalogue() == null) {
			Optional<StockCatalogueEntity> stockCatalogueEntity = this.stockCatalogueRepository.findById(entity.getStockCatalogueId());
			entityToUpdate.setStockCatalogue(stockCatalogueEntity.orElseThrow());
		}
		if (persistRelations && entity.getStockCatalogue() != null) {
			entityToUpdate.setStockCatalogue(entity.getStockCatalogue(), false);
			if (entityToUpdate.getStockCatalogueId() != null) {
				this.stockCatalogueRepository.save(entityToUpdate.getStockCatalogue());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getStockCatalogue().unsetStockCatalogueMedical();
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
	public void validateEntity(CatalogueMedicalEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<CatalogueMedicalEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the CatalogueMedicalEntity.
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

	public Set<String> validateEntityRelations(CatalogueMedicalEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getStockCatalogueId() != null && this.stockCatalogueRepository.findById(entity.getStockCatalogueId()).isEmpty()) {
			errors.add("The UUID " + entity.getStockCatalogueId() + " is not associated with a Stock Catalogue Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
