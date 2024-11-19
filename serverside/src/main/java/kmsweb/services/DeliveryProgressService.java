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
import kmsweb.repositories.DeliveryProgressRepository;
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
import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;
import kmsweb.repositories.DeliveryMedicalExaminationRecordRepository;
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
public class DeliveryProgressService extends AbstractService<DeliveryProgressEntity, DeliveryProgressRepository, DeliveryProgressEntityAudit> {

	private final String[] referenceNamesInDeliveryProgressEntity = {
		"deliveryMedicalExaminationRecord",
		"staff",
	};

	private final DeliveryMedicalExaminationRecordRepository deliveryMedicalExaminationRecordRepository;

	private final StaffRepository staffRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public DeliveryProgressService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		DeliveryMedicalExaminationRecordRepository deliveryMedicalExaminationRecordRepository,
		StaffRepository staffRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		DeliveryProgressRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.deliveryMedicalExaminationRecordRepository = deliveryMedicalExaminationRecordRepository;

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
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
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
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Progress Date Time.
	 *
	 * @param progressDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Progress Date Time
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByProgressDateTime(OffsetDateTime progressDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByProgressDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByProgressDateTime here] end
	{
		// % protected region % [Add any additional logic for findByProgressDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByProgressDateTime before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByProgressDateTime(progressDateTime));

		// % protected region % [Add any additional logic for findByProgressDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByProgressDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute FHR Per Minute.
	 *
	 * @param fhrPerMinute the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute FHR Per Minute
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByFhrPerMinute(Integer fhrPerMinute)
	// % protected region % [Add any throwables, implementations, or extensions for findByFhrPerMinute here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFhrPerMinute here] end
	{
		// % protected region % [Add any additional logic for findByFhrPerMinute before the main body here] off begin
		// % protected region % [Add any additional logic for findByFhrPerMinute before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByFhrPerMinute(fhrPerMinute));

		// % protected region % [Add any additional logic for findByFhrPerMinute before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFhrPerMinute before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Amniotic Fluid.
	 *
	 * @param amnioticFluid the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Amniotic Fluid
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByAmnioticFluid(String amnioticFluid)
	// % protected region % [Add any throwables, implementations, or extensions for findByAmnioticFluid here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAmnioticFluid here] end
	{
		// % protected region % [Add any additional logic for findByAmnioticFluid before the main body here] off begin
		// % protected region % [Add any additional logic for findByAmnioticFluid before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByAmnioticFluid(amnioticFluid));

		// % protected region % [Add any additional logic for findByAmnioticFluid before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAmnioticFluid before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Moulding.
	 *
	 * @param moulding the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Moulding
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByMoulding(String moulding)
	// % protected region % [Add any throwables, implementations, or extensions for findByMoulding here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMoulding here] end
	{
		// % protected region % [Add any additional logic for findByMoulding before the main body here] off begin
		// % protected region % [Add any additional logic for findByMoulding before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByMoulding(moulding));

		// % protected region % [Add any additional logic for findByMoulding before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMoulding before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Cervical Dilatation.
	 *
	 * @param cervicalDilatation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cervical Dilatation
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByCervicalDilatation(Integer cervicalDilatation)
	// % protected region % [Add any throwables, implementations, or extensions for findByCervicalDilatation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCervicalDilatation here] end
	{
		// % protected region % [Add any additional logic for findByCervicalDilatation before the main body here] off begin
		// % protected region % [Add any additional logic for findByCervicalDilatation before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByCervicalDilatation(cervicalDilatation));

		// % protected region % [Add any additional logic for findByCervicalDilatation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCervicalDilatation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Fetal Head Descent.
	 *
	 * @param fetalHeadDescent the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Fetal Head Descent
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByFetalHeadDescent(String fetalHeadDescent)
	// % protected region % [Add any throwables, implementations, or extensions for findByFetalHeadDescent here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFetalHeadDescent here] end
	{
		// % protected region % [Add any additional logic for findByFetalHeadDescent before the main body here] off begin
		// % protected region % [Add any additional logic for findByFetalHeadDescent before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByFetalHeadDescent(fetalHeadDescent));

		// % protected region % [Add any additional logic for findByFetalHeadDescent before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFetalHeadDescent before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Contraction Qty.
	 *
	 * @param contractionQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contraction Qty
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByContractionQty(Integer contractionQty)
	// % protected region % [Add any throwables, implementations, or extensions for findByContractionQty here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByContractionQty here] end
	{
		// % protected region % [Add any additional logic for findByContractionQty before the main body here] off begin
		// % protected region % [Add any additional logic for findByContractionQty before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByContractionQty(contractionQty));

		// % protected region % [Add any additional logic for findByContractionQty before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByContractionQty before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Contraction Mins.
	 *
	 * @param contractionMins the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contraction Mins
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByContractionMins(String contractionMins)
	// % protected region % [Add any throwables, implementations, or extensions for findByContractionMins here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByContractionMins here] end
	{
		// % protected region % [Add any additional logic for findByContractionMins before the main body here] off begin
		// % protected region % [Add any additional logic for findByContractionMins before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByContractionMins(contractionMins));

		// % protected region % [Add any additional logic for findByContractionMins before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByContractionMins before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Drip Strength.
	 *
	 * @param dripStrength the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Drip Strength
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByDripStrength(Integer dripStrength)
	// % protected region % [Add any throwables, implementations, or extensions for findByDripStrength here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDripStrength here] end
	{
		// % protected region % [Add any additional logic for findByDripStrength before the main body here] off begin
		// % protected region % [Add any additional logic for findByDripStrength before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByDripStrength(dripStrength));

		// % protected region % [Add any additional logic for findByDripStrength before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDripStrength before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Drip Number.
	 *
	 * @param dripNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Drip Number
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByDripNumber(Integer dripNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByDripNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDripNumber here] end
	{
		// % protected region % [Add any additional logic for findByDripNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByDripNumber before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByDripNumber(dripNumber));

		// % protected region % [Add any additional logic for findByDripNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDripNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Drug IV.
	 *
	 * @param drugIV the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Drug IV
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByDrugIV(String drugIV)
	// % protected region % [Add any throwables, implementations, or extensions for findByDrugIV here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDrugIV here] end
	{
		// % protected region % [Add any additional logic for findByDrugIV before the main body here] off begin
		// % protected region % [Add any additional logic for findByDrugIV before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByDrugIV(drugIV));

		// % protected region % [Add any additional logic for findByDrugIV before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDrugIV before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Systole.
	 *
	 * @param systole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Systole
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findBySystole(Integer systole)
	// % protected region % [Add any throwables, implementations, or extensions for findBySystole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySystole here] end
	{
		// % protected region % [Add any additional logic for findBySystole before the main body here] off begin
		// % protected region % [Add any additional logic for findBySystole before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findBySystole(systole));

		// % protected region % [Add any additional logic for findBySystole before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySystole before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Diastole.
	 *
	 * @param diastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diastole
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByDiastole(Integer diastole)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastole here] end
	{
		// % protected region % [Add any additional logic for findByDiastole before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiastole before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByDiastole(diastole));

		// % protected region % [Add any additional logic for findByDiastole before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiastole before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pulse.
	 *
	 * @param pulse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByPulse(Integer pulse)
	// % protected region % [Add any throwables, implementations, or extensions for findByPulse here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPulse here] end
	{
		// % protected region % [Add any additional logic for findByPulse before the main body here] off begin
		// % protected region % [Add any additional logic for findByPulse before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByPulse(pulse));

		// % protected region % [Add any additional logic for findByPulse before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPulse before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Temperature.
	 *
	 * @param temperature the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByTemperature(Double temperature)
	// % protected region % [Add any throwables, implementations, or extensions for findByTemperature here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTemperature here] end
	{
		// % protected region % [Add any additional logic for findByTemperature before the main body here] off begin
		// % protected region % [Add any additional logic for findByTemperature before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByTemperature(temperature));

		// % protected region % [Add any additional logic for findByTemperature before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTemperature before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Temperature Unit.
	 *
	 * @param temperatureUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature Unit
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByTemperatureUnit(String temperatureUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByTemperatureUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTemperatureUnit here] end
	{
		// % protected region % [Add any additional logic for findByTemperatureUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByTemperatureUnit before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByTemperatureUnit(temperatureUnit));

		// % protected region % [Add any additional logic for findByTemperatureUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTemperatureUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Urine Protein.
	 *
	 * @param urineProtein the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Urine Protein
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByUrineProtein(String urineProtein)
	// % protected region % [Add any throwables, implementations, or extensions for findByUrineProtein here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUrineProtein here] end
	{
		// % protected region % [Add any additional logic for findByUrineProtein before the main body here] off begin
		// % protected region % [Add any additional logic for findByUrineProtein before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByUrineProtein(urineProtein));

		// % protected region % [Add any additional logic for findByUrineProtein before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUrineProtein before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Urine Acetone.
	 *
	 * @param urineAcetone the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Urine Acetone
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByUrineAcetone(String urineAcetone)
	// % protected region % [Add any throwables, implementations, or extensions for findByUrineAcetone here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUrineAcetone here] end
	{
		// % protected region % [Add any additional logic for findByUrineAcetone before the main body here] off begin
		// % protected region % [Add any additional logic for findByUrineAcetone before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByUrineAcetone(urineAcetone));

		// % protected region % [Add any additional logic for findByUrineAcetone before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUrineAcetone before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Urine Volume.
	 *
	 * @param urineVolume the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Urine Volume
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByUrineVolume(Double urineVolume)
	// % protected region % [Add any throwables, implementations, or extensions for findByUrineVolume here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUrineVolume here] end
	{
		// % protected region % [Add any additional logic for findByUrineVolume before the main body here] off begin
		// % protected region % [Add any additional logic for findByUrineVolume before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByUrineVolume(urineVolume));

		// % protected region % [Add any additional logic for findByUrineVolume before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUrineVolume before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Progress Notes.
	 *
	 * @param progressNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Progress Notes
	 */
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findByProgressNotes(String progressNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByProgressNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByProgressNotes here] end
	{
		// % protected region % [Add any additional logic for findByProgressNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByProgressNotes before the main body here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findByProgressNotes(progressNotes));

		// % protected region % [Add any additional logic for findByProgressNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByProgressNotes before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<DeliveryProgressEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<DeliveryProgressEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<DeliveryProgressEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<DeliveryProgressEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'create')")
	public DeliveryProgressEntity create(DeliveryProgressEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		DeliveryProgressEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'create')")
	public DeliveryProgressEntity create(DeliveryProgressEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		DeliveryProgressEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		DeliveryProgressEntity newEntity;

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
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'create')")
	public List<DeliveryProgressEntity> createAll(Iterable<DeliveryProgressEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<DeliveryProgressEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<DeliveryProgressEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'update')")
	public DeliveryProgressEntity update(DeliveryProgressEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		DeliveryProgressEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'update')")
	public DeliveryProgressEntity update(DeliveryProgressEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		DeliveryProgressEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		DeliveryProgressEntity newEntity;

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
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'update')")
	public List<DeliveryProgressEntity> updateAll(Iterable<DeliveryProgressEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<DeliveryProgressEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<DeliveryProgressEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'create') or hasPermission('DeliveryProgressEntity', 'update')")
	public DeliveryProgressEntity save(DeliveryProgressEntity entity) throws ConstraintViolationException
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

		DeliveryProgressEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'create') or hasPermission('DeliveryProgressEntity', 'update')")
	public List<DeliveryProgressEntity> saveAll(Iterable<DeliveryProgressEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<DeliveryProgressEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'delete')")
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
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'delete')")
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
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	public List<DeliveryProgressEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	public List<DeliveryProgressEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(DeliveryProgressEntity.class);

		// % protected region % [Add any additional processing before converting to a list of DeliveryProgressEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of DeliveryProgressEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<DeliveryProgressEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of DeliveryProgressEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of DeliveryProgressEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(DeliveryProgressEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of DeliveryProgressEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of DeliveryProgressEntityAudits
	 */
	private List<DeliveryProgressEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<DeliveryProgressEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param deliveryProgress deliveryProgress to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private DeliveryProgressEntity updateAuditData(DeliveryProgressEntity deliveryProgress)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return deliveryProgress;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private DeliveryProgressEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		DeliveryProgressEntity entityAtRevision = updateAuditData((DeliveryProgressEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new DeliveryProgressEntityAudit(
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

		QDeliveryProgressEntity entity = QDeliveryProgressEntity.deliveryProgressEntity;

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
			case "deliveryMedicalExaminationRecordId":
				// % protected region % [Add any additional logic before the query parameters of relation from Delivery Medical Examination Record to Delivery Progresses here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Delivery Medical Examination Record to Delivery Progresses here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.deliveryMedicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Delivery Medical Examination Record to Delivery Progresses here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Delivery Medical Examination Record to Delivery Progresses here] end

				break;
			case "staffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Delivery Progresses here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Delivery Progresses here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.staff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Delivery Progresses here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Delivery Progresses here] end

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
	public DeliveryProgressEntity updateOldData(DeliveryProgressEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public DeliveryProgressEntity updateOldData(DeliveryProgressEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		DeliveryProgressEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInDeliveryProgressEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getDeliveryMedicalExaminationRecord() == null && entity.getDeliveryMedicalExaminationRecordId() == null) {
			entityToUpdate.unsetDeliveryMedicalExaminationRecord();
		} else if (entity.getDeliveryMedicalExaminationRecordId() != null && entity.getDeliveryMedicalExaminationRecord() == null) {
			Optional<DeliveryMedicalExaminationRecordEntity> deliveryMedicalExaminationRecordEntity = this.deliveryMedicalExaminationRecordRepository.findById(entity.getDeliveryMedicalExaminationRecordId());
			entityToUpdate.setDeliveryMedicalExaminationRecord(deliveryMedicalExaminationRecordEntity.orElseThrow());
		}
		if (persistRelations && entity.getDeliveryMedicalExaminationRecord() != null) {
			entityToUpdate.setDeliveryMedicalExaminationRecord(entity.getDeliveryMedicalExaminationRecord(), false);
			if (entityToUpdate.getDeliveryMedicalExaminationRecordId() != null) {
				this.deliveryMedicalExaminationRecordRepository.save(entityToUpdate.getDeliveryMedicalExaminationRecord());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getDeliveryMedicalExaminationRecord().unsetDeliveryProgresses();
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
				entityToUpdate.getStaff().unsetDeliveryProgresses();
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
	public void validateEntity(DeliveryProgressEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<DeliveryProgressEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the DeliveryProgressEntity.
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

	public Set<String> validateEntityRelations(DeliveryProgressEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getDeliveryMedicalExaminationRecordId() != null && this.deliveryMedicalExaminationRecordRepository.findById(entity.getDeliveryMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getDeliveryMedicalExaminationRecordId() + " is not associated with a Delivery Medical Examination Record Entity");
		}

		if (entity.getStaffId() != null && this.staffRepository.findById(entity.getStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getStaffId() + " is not associated with a Staff Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
