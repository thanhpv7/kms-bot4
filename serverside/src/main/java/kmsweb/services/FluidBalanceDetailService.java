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
import kmsweb.repositories.FluidBalanceDetailRepository;
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
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
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
public class FluidBalanceDetailService extends AbstractService<FluidBalanceDetailEntity, FluidBalanceDetailRepository, FluidBalanceDetailEntityAudit> {

	private final String[] referenceNamesInFluidBalanceDetailEntity = {
		"registration",
		"staff",
	};

	private final RegistrationRepository registrationRepository;

	private final StaffRepository staffRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public FluidBalanceDetailService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		RegistrationRepository registrationRepository,
		StaffRepository staffRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		FluidBalanceDetailRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.registrationRepository = registrationRepository;

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
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
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
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Record Date Time.
	 *
	 * @param recordDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Record Date Time
	 */
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findByRecordDateTime(OffsetDateTime recordDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByRecordDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRecordDateTime here] end
	{
		// % protected region % [Add any additional logic for findByRecordDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByRecordDateTime before the main body here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findByRecordDateTime(recordDateTime));

		// % protected region % [Add any additional logic for findByRecordDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRecordDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Intake Oral.
	 *
	 * @param intakeOral the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Intake Oral
	 */
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findByIntakeOral(Double intakeOral)
	// % protected region % [Add any throwables, implementations, or extensions for findByIntakeOral here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIntakeOral here] end
	{
		// % protected region % [Add any additional logic for findByIntakeOral before the main body here] off begin
		// % protected region % [Add any additional logic for findByIntakeOral before the main body here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findByIntakeOral(intakeOral));

		// % protected region % [Add any additional logic for findByIntakeOral before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIntakeOral before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Intake NGT.
	 *
	 * @param intakeNGT the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Intake NGT
	 */
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findByIntakeNGT(Double intakeNGT)
	// % protected region % [Add any throwables, implementations, or extensions for findByIntakeNGT here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIntakeNGT here] end
	{
		// % protected region % [Add any additional logic for findByIntakeNGT before the main body here] off begin
		// % protected region % [Add any additional logic for findByIntakeNGT before the main body here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findByIntakeNGT(intakeNGT));

		// % protected region % [Add any additional logic for findByIntakeNGT before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIntakeNGT before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Intake IV Line.
	 *
	 * @param intakeIVLine the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Intake IV Line
	 */
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findByIntakeIVLine(Double intakeIVLine)
	// % protected region % [Add any throwables, implementations, or extensions for findByIntakeIVLine here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIntakeIVLine here] end
	{
		// % protected region % [Add any additional logic for findByIntakeIVLine before the main body here] off begin
		// % protected region % [Add any additional logic for findByIntakeIVLine before the main body here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findByIntakeIVLine(intakeIVLine));

		// % protected region % [Add any additional logic for findByIntakeIVLine before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIntakeIVLine before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Intake Others.
	 *
	 * @param intakeOthers the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Intake Others
	 */
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findByIntakeOthers(Double intakeOthers)
	// % protected region % [Add any throwables, implementations, or extensions for findByIntakeOthers here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIntakeOthers here] end
	{
		// % protected region % [Add any additional logic for findByIntakeOthers before the main body here] off begin
		// % protected region % [Add any additional logic for findByIntakeOthers before the main body here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findByIntakeOthers(intakeOthers));

		// % protected region % [Add any additional logic for findByIntakeOthers before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIntakeOthers before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Output Urine.
	 *
	 * @param outputUrine the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Output Urine
	 */
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findByOutputUrine(Double outputUrine)
	// % protected region % [Add any throwables, implementations, or extensions for findByOutputUrine here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOutputUrine here] end
	{
		// % protected region % [Add any additional logic for findByOutputUrine before the main body here] off begin
		// % protected region % [Add any additional logic for findByOutputUrine before the main body here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findByOutputUrine(outputUrine));

		// % protected region % [Add any additional logic for findByOutputUrine before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOutputUrine before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Output NGT.
	 *
	 * @param outputNGT the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Output NGT
	 */
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findByOutputNGT(Double outputNGT)
	// % protected region % [Add any throwables, implementations, or extensions for findByOutputNGT here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOutputNGT here] end
	{
		// % protected region % [Add any additional logic for findByOutputNGT before the main body here] off begin
		// % protected region % [Add any additional logic for findByOutputNGT before the main body here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findByOutputNGT(outputNGT));

		// % protected region % [Add any additional logic for findByOutputNGT before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOutputNGT before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Output Drain.
	 *
	 * @param outputDrain the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Output Drain
	 */
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findByOutputDrain(Double outputDrain)
	// % protected region % [Add any throwables, implementations, or extensions for findByOutputDrain here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOutputDrain here] end
	{
		// % protected region % [Add any additional logic for findByOutputDrain before the main body here] off begin
		// % protected region % [Add any additional logic for findByOutputDrain before the main body here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findByOutputDrain(outputDrain));

		// % protected region % [Add any additional logic for findByOutputDrain before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOutputDrain before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Output Stool.
	 *
	 * @param outputStool the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Output Stool
	 */
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findByOutputStool(Double outputStool)
	// % protected region % [Add any throwables, implementations, or extensions for findByOutputStool here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOutputStool here] end
	{
		// % protected region % [Add any additional logic for findByOutputStool before the main body here] off begin
		// % protected region % [Add any additional logic for findByOutputStool before the main body here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findByOutputStool(outputStool));

		// % protected region % [Add any additional logic for findByOutputStool before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOutputStool before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Output Blood.
	 *
	 * @param outputBlood the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Output Blood
	 */
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findByOutputBlood(Double outputBlood)
	// % protected region % [Add any throwables, implementations, or extensions for findByOutputBlood here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOutputBlood here] end
	{
		// % protected region % [Add any additional logic for findByOutputBlood before the main body here] off begin
		// % protected region % [Add any additional logic for findByOutputBlood before the main body here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findByOutputBlood(outputBlood));

		// % protected region % [Add any additional logic for findByOutputBlood before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOutputBlood before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Output IWL.
	 *
	 * @param outputIWL the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Output IWL
	 */
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findByOutputIWL(Double outputIWL)
	// % protected region % [Add any throwables, implementations, or extensions for findByOutputIWL here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOutputIWL here] end
	{
		// % protected region % [Add any additional logic for findByOutputIWL before the main body here] off begin
		// % protected region % [Add any additional logic for findByOutputIWL before the main body here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findByOutputIWL(outputIWL));

		// % protected region % [Add any additional logic for findByOutputIWL before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOutputIWL before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Output Others.
	 *
	 * @param outputOthers the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Output Others
	 */
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findByOutputOthers(Double outputOthers)
	// % protected region % [Add any throwables, implementations, or extensions for findByOutputOthers here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOutputOthers here] end
	{
		// % protected region % [Add any additional logic for findByOutputOthers before the main body here] off begin
		// % protected region % [Add any additional logic for findByOutputOthers before the main body here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findByOutputOthers(outputOthers));

		// % protected region % [Add any additional logic for findByOutputOthers before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOutputOthers before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Input.
	 *
	 * @param totalInput the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Input
	 */
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findByTotalInput(Double totalInput)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalInput here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalInput here] end
	{
		// % protected region % [Add any additional logic for findByTotalInput before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalInput before the main body here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findByTotalInput(totalInput));

		// % protected region % [Add any additional logic for findByTotalInput before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalInput before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Output.
	 *
	 * @param totalOutput the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Output
	 */
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findByTotalOutput(Double totalOutput)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalOutput here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalOutput here] end
	{
		// % protected region % [Add any additional logic for findByTotalOutput before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalOutput before the main body here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findByTotalOutput(totalOutput));

		// % protected region % [Add any additional logic for findByTotalOutput before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalOutput before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Balance Fluid.
	 *
	 * @param totalBalanceFluid the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Balance Fluid
	 */
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findByTotalBalanceFluid(Double totalBalanceFluid)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalBalanceFluid here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalBalanceFluid here] end
	{
		// % protected region % [Add any additional logic for findByTotalBalanceFluid before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalBalanceFluid before the main body here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findByTotalBalanceFluid(totalBalanceFluid));

		// % protected region % [Add any additional logic for findByTotalBalanceFluid before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalBalanceFluid before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<FluidBalanceDetailEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<FluidBalanceDetailEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<FluidBalanceDetailEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'create')")
	public FluidBalanceDetailEntity create(FluidBalanceDetailEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		FluidBalanceDetailEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'create')")
	public FluidBalanceDetailEntity create(FluidBalanceDetailEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		FluidBalanceDetailEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		FluidBalanceDetailEntity newEntity;

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
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'create')")
	public List<FluidBalanceDetailEntity> createAll(Iterable<FluidBalanceDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<FluidBalanceDetailEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<FluidBalanceDetailEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'update')")
	public FluidBalanceDetailEntity update(FluidBalanceDetailEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		FluidBalanceDetailEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'update')")
	public FluidBalanceDetailEntity update(FluidBalanceDetailEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		FluidBalanceDetailEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		FluidBalanceDetailEntity newEntity;

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
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'update')")
	public List<FluidBalanceDetailEntity> updateAll(Iterable<FluidBalanceDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<FluidBalanceDetailEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<FluidBalanceDetailEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'create') or hasPermission('FluidBalanceDetailEntity', 'update')")
	public FluidBalanceDetailEntity save(FluidBalanceDetailEntity entity) throws ConstraintViolationException
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

		FluidBalanceDetailEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'create') or hasPermission('FluidBalanceDetailEntity', 'update')")
	public List<FluidBalanceDetailEntity> saveAll(Iterable<FluidBalanceDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<FluidBalanceDetailEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'delete')")
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
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'delete')")
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
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	public List<FluidBalanceDetailEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	public List<FluidBalanceDetailEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(FluidBalanceDetailEntity.class);

		// % protected region % [Add any additional processing before converting to a list of FluidBalanceDetailEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of FluidBalanceDetailEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<FluidBalanceDetailEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of FluidBalanceDetailEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of FluidBalanceDetailEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(FluidBalanceDetailEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of FluidBalanceDetailEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of FluidBalanceDetailEntityAudits
	 */
	private List<FluidBalanceDetailEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<FluidBalanceDetailEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param fluidBalanceDetail fluidBalanceDetail to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private FluidBalanceDetailEntity updateAuditData(FluidBalanceDetailEntity fluidBalanceDetail)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return fluidBalanceDetail;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private FluidBalanceDetailEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		FluidBalanceDetailEntity entityAtRevision = updateAuditData((FluidBalanceDetailEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new FluidBalanceDetailEntityAudit(
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

		QFluidBalanceDetailEntity entity = QFluidBalanceDetailEntity.fluidBalanceDetailEntity;

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
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Fluid Balance Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Fluid Balance Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registration.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Fluid Balance Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Fluid Balance Details here] end

				break;
			case "staffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Fluid Balance Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Fluid Balance Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.staff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Fluid Balance Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Fluid Balance Details here] end

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
	public FluidBalanceDetailEntity updateOldData(FluidBalanceDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public FluidBalanceDetailEntity updateOldData(FluidBalanceDetailEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		FluidBalanceDetailEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInFluidBalanceDetailEntity);

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
				entityToUpdate.getRegistration().unsetFluidBalanceDetails();
			}
		}

		// Incoming One to Many reference
		if (entity.getStaff() == null && entity.getStaffId() == null) {
			entityToUpdate.unsetStaff();
		} else if (entity.getStaffId() != null && entity.getStaff() == null) {
			Optional<StaffEntity> staffEntity = this.staffRepository.findById(entity.getStaffId());
			entityToUpdate.setStaff(staffEntity.orElseThrow());
		}
		if (persistRelations && entity.getStaff() != null) {
			entityToUpdate.setStaff(entity.getStaff(), false);
			if (entityToUpdate.getStaffId() != null) {
				this.staffRepository.save(entityToUpdate.getStaff());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getStaff().unsetFluidBalanceDetails();
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
	public void validateEntity(FluidBalanceDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<FluidBalanceDetailEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the FluidBalanceDetailEntity.
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

	public Set<String> validateEntityRelations(FluidBalanceDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getRegistrationId() != null && this.registrationRepository.findById(entity.getRegistrationId()).isEmpty()) {
			errors.add("The UUID " + entity.getRegistrationId() + " is not associated with a Registration Entity");
		}

		if (entity.getStaffId() != null && this.staffRepository.findById(entity.getStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getStaffId() + " is not associated with a Staff Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
