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
import kmsweb.repositories.PcareMCURepository;
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

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class PcareMCUService extends AbstractService<PcareMCUEntity, PcareMCURepository, PcareMCUEntityAudit> {

	private final String[] referenceNamesInPcareMCUEntity = {
	};

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PcareMCUService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		Validator validator,
		AuditingRepository auditingRepository,
		PcareMCURepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

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
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
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
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Kode MCU.
	 *
	 * @param kodeMCU the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Kode MCU
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByKodeMCU(String kodeMCU)
	// % protected region % [Add any throwables, implementations, or extensions for findByKodeMCU here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKodeMCU here] end
	{
		// % protected region % [Add any additional logic for findByKodeMCU before the main body here] off begin
		// % protected region % [Add any additional logic for findByKodeMCU before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByKodeMCU(kodeMCU));

		// % protected region % [Add any additional logic for findByKodeMCU before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKodeMCU before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute No Kunjungan.
	 *
	 * @param noKunjungan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute No Kunjungan
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByNoKunjungan(String noKunjungan)
	// % protected region % [Add any throwables, implementations, or extensions for findByNoKunjungan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNoKunjungan here] end
	{
		// % protected region % [Add any additional logic for findByNoKunjungan before the main body here] off begin
		// % protected region % [Add any additional logic for findByNoKunjungan before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByNoKunjungan(noKunjungan));

		// % protected region % [Add any additional logic for findByNoKunjungan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNoKunjungan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Kode Provider.
	 *
	 * @param kodeProvider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Kode Provider
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByKodeProvider(String kodeProvider)
	// % protected region % [Add any throwables, implementations, or extensions for findByKodeProvider here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKodeProvider here] end
	{
		// % protected region % [Add any additional logic for findByKodeProvider before the main body here] off begin
		// % protected region % [Add any additional logic for findByKodeProvider before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByKodeProvider(kodeProvider));

		// % protected region % [Add any additional logic for findByKodeProvider before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKodeProvider before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Nama Provider.
	 *
	 * @param namaProvider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nama Provider
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByNamaProvider(String namaProvider)
	// % protected region % [Add any throwables, implementations, or extensions for findByNamaProvider here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNamaProvider here] end
	{
		// % protected region % [Add any additional logic for findByNamaProvider before the main body here] off begin
		// % protected region % [Add any additional logic for findByNamaProvider before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByNamaProvider(namaProvider));

		// % protected region % [Add any additional logic for findByNamaProvider before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNamaProvider before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tanggal Pelayanan.
	 *
	 * @param tanggalPelayanan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tanggal Pelayanan
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByTanggalPelayanan(String tanggalPelayanan)
	// % protected region % [Add any throwables, implementations, or extensions for findByTanggalPelayanan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTanggalPelayanan here] end
	{
		// % protected region % [Add any additional logic for findByTanggalPelayanan before the main body here] off begin
		// % protected region % [Add any additional logic for findByTanggalPelayanan before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByTanggalPelayanan(tanggalPelayanan));

		// % protected region % [Add any additional logic for findByTanggalPelayanan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTanggalPelayanan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sistole.
	 *
	 * @param sistole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sistole
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findBySistole(String sistole)
	// % protected region % [Add any throwables, implementations, or extensions for findBySistole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySistole here] end
	{
		// % protected region % [Add any additional logic for findBySistole before the main body here] off begin
		// % protected region % [Add any additional logic for findBySistole before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findBySistole(sistole));

		// % protected region % [Add any additional logic for findBySistole before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySistole before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Diastole.
	 *
	 * @param diastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diastole
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByDiastole(String diastole)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastole here] end
	{
		// % protected region % [Add any additional logic for findByDiastole before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiastole before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByDiastole(diastole));

		// % protected region % [Add any additional logic for findByDiastole before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiastole before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Radiologi Foto.
	 *
	 * @param radiologiFoto the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Radiologi Foto
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByRadiologiFoto(String radiologiFoto)
	// % protected region % [Add any throwables, implementations, or extensions for findByRadiologiFoto here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRadiologiFoto here] end
	{
		// % protected region % [Add any additional logic for findByRadiologiFoto before the main body here] off begin
		// % protected region % [Add any additional logic for findByRadiologiFoto before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByRadiologiFoto(radiologiFoto));

		// % protected region % [Add any additional logic for findByRadiologiFoto before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRadiologiFoto before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hemoglobin.
	 *
	 * @param hemoglobin the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hemoglobin
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByHemoglobin(String hemoglobin)
	// % protected region % [Add any throwables, implementations, or extensions for findByHemoglobin here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHemoglobin here] end
	{
		// % protected region % [Add any additional logic for findByHemoglobin before the main body here] off begin
		// % protected region % [Add any additional logic for findByHemoglobin before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByHemoglobin(hemoglobin));

		// % protected region % [Add any additional logic for findByHemoglobin before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHemoglobin before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Leukosit.
	 *
	 * @param leukosit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Leukosit
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByLeukosit(String leukosit)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeukosit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeukosit here] end
	{
		// % protected region % [Add any additional logic for findByLeukosit before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeukosit before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByLeukosit(leukosit));

		// % protected region % [Add any additional logic for findByLeukosit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeukosit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Eritrosit.
	 *
	 * @param eritrosit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Eritrosit
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByEritrosit(String eritrosit)
	// % protected region % [Add any throwables, implementations, or extensions for findByEritrosit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEritrosit here] end
	{
		// % protected region % [Add any additional logic for findByEritrosit before the main body here] off begin
		// % protected region % [Add any additional logic for findByEritrosit before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByEritrosit(eritrosit));

		// % protected region % [Add any additional logic for findByEritrosit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEritrosit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Laju Endap Darah.
	 *
	 * @param lajuEndapDarah the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Laju Endap Darah
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByLajuEndapDarah(String lajuEndapDarah)
	// % protected region % [Add any throwables, implementations, or extensions for findByLajuEndapDarah here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLajuEndapDarah here] end
	{
		// % protected region % [Add any additional logic for findByLajuEndapDarah before the main body here] off begin
		// % protected region % [Add any additional logic for findByLajuEndapDarah before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByLajuEndapDarah(lajuEndapDarah));

		// % protected region % [Add any additional logic for findByLajuEndapDarah before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLajuEndapDarah before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hematokrit.
	 *
	 * @param hematokrit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hematokrit
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByHematokrit(String hematokrit)
	// % protected region % [Add any throwables, implementations, or extensions for findByHematokrit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHematokrit here] end
	{
		// % protected region % [Add any additional logic for findByHematokrit before the main body here] off begin
		// % protected region % [Add any additional logic for findByHematokrit before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByHematokrit(hematokrit));

		// % protected region % [Add any additional logic for findByHematokrit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHematokrit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Trombosit.
	 *
	 * @param trombosit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Trombosit
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByTrombosit(String trombosit)
	// % protected region % [Add any throwables, implementations, or extensions for findByTrombosit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTrombosit here] end
	{
		// % protected region % [Add any additional logic for findByTrombosit before the main body here] off begin
		// % protected region % [Add any additional logic for findByTrombosit before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByTrombosit(trombosit));

		// % protected region % [Add any additional logic for findByTrombosit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTrombosit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute HDL.
	 *
	 * @param hdl the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute HDL
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByHdl(String hdl)
	// % protected region % [Add any throwables, implementations, or extensions for findByHdl here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHdl here] end
	{
		// % protected region % [Add any additional logic for findByHdl before the main body here] off begin
		// % protected region % [Add any additional logic for findByHdl before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByHdl(hdl));

		// % protected region % [Add any additional logic for findByHdl before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHdl before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute LDL.
	 *
	 * @param ldl the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute LDL
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByLdl(String ldl)
	// % protected region % [Add any throwables, implementations, or extensions for findByLdl here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLdl here] end
	{
		// % protected region % [Add any additional logic for findByLdl before the main body here] off begin
		// % protected region % [Add any additional logic for findByLdl before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByLdl(ldl));

		// % protected region % [Add any additional logic for findByLdl before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLdl before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Cholesterol.
	 *
	 * @param cholesterol the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cholesterol
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByCholesterol(String cholesterol)
	// % protected region % [Add any throwables, implementations, or extensions for findByCholesterol here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCholesterol here] end
	{
		// % protected region % [Add any additional logic for findByCholesterol before the main body here] off begin
		// % protected region % [Add any additional logic for findByCholesterol before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByCholesterol(cholesterol));

		// % protected region % [Add any additional logic for findByCholesterol before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCholesterol before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Trigliserida.
	 *
	 * @param trigliserida the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Trigliserida
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByTrigliserida(String trigliserida)
	// % protected region % [Add any throwables, implementations, or extensions for findByTrigliserida here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTrigliserida here] end
	{
		// % protected region % [Add any additional logic for findByTrigliserida before the main body here] off begin
		// % protected region % [Add any additional logic for findByTrigliserida before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByTrigliserida(trigliserida));

		// % protected region % [Add any additional logic for findByTrigliserida before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTrigliserida before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sewaktu.
	 *
	 * @param sewaktu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sewaktu
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findBySewaktu(String sewaktu)
	// % protected region % [Add any throwables, implementations, or extensions for findBySewaktu here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySewaktu here] end
	{
		// % protected region % [Add any additional logic for findBySewaktu before the main body here] off begin
		// % protected region % [Add any additional logic for findBySewaktu before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findBySewaktu(sewaktu));

		// % protected region % [Add any additional logic for findBySewaktu before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySewaktu before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Puasa.
	 *
	 * @param puasa the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Puasa
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByPuasa(String puasa)
	// % protected region % [Add any throwables, implementations, or extensions for findByPuasa here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPuasa here] end
	{
		// % protected region % [Add any additional logic for findByPuasa before the main body here] off begin
		// % protected region % [Add any additional logic for findByPuasa before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByPuasa(puasa));

		// % protected region % [Add any additional logic for findByPuasa before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPuasa before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Post Prandial.
	 *
	 * @param postPrandial the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Post Prandial
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByPostPrandial(String postPrandial)
	// % protected region % [Add any throwables, implementations, or extensions for findByPostPrandial here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPostPrandial here] end
	{
		// % protected region % [Add any additional logic for findByPostPrandial before the main body here] off begin
		// % protected region % [Add any additional logic for findByPostPrandial before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByPostPrandial(postPrandial));

		// % protected region % [Add any additional logic for findByPostPrandial before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPostPrandial before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute HbA1c.
	 *
	 * @param hba1c the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute HbA1c
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByHba1c(String hba1c)
	// % protected region % [Add any throwables, implementations, or extensions for findByHba1c here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHba1c here] end
	{
		// % protected region % [Add any additional logic for findByHba1c before the main body here] off begin
		// % protected region % [Add any additional logic for findByHba1c before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByHba1c(hba1c));

		// % protected region % [Add any additional logic for findByHba1c before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHba1c before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute SGOT.
	 *
	 * @param sgot the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SGOT
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findBySgot(String sgot)
	// % protected region % [Add any throwables, implementations, or extensions for findBySgot here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySgot here] end
	{
		// % protected region % [Add any additional logic for findBySgot before the main body here] off begin
		// % protected region % [Add any additional logic for findBySgot before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findBySgot(sgot));

		// % protected region % [Add any additional logic for findBySgot before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySgot before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute SGPT.
	 *
	 * @param sgpt the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SGPT
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findBySgpt(String sgpt)
	// % protected region % [Add any throwables, implementations, or extensions for findBySgpt here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySgpt here] end
	{
		// % protected region % [Add any additional logic for findBySgpt before the main body here] off begin
		// % protected region % [Add any additional logic for findBySgpt before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findBySgpt(sgpt));

		// % protected region % [Add any additional logic for findBySgpt before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySgpt before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gamma.
	 *
	 * @param gamma the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gamma
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByGamma(String gamma)
	// % protected region % [Add any throwables, implementations, or extensions for findByGamma here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGamma here] end
	{
		// % protected region % [Add any additional logic for findByGamma before the main body here] off begin
		// % protected region % [Add any additional logic for findByGamma before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByGamma(gamma));

		// % protected region % [Add any additional logic for findByGamma before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGamma before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Protein Kualitatif.
	 *
	 * @param proteinKualitatif the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Protein Kualitatif
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByProteinKualitatif(String proteinKualitatif)
	// % protected region % [Add any throwables, implementations, or extensions for findByProteinKualitatif here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByProteinKualitatif here] end
	{
		// % protected region % [Add any additional logic for findByProteinKualitatif before the main body here] off begin
		// % protected region % [Add any additional logic for findByProteinKualitatif before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByProteinKualitatif(proteinKualitatif));

		// % protected region % [Add any additional logic for findByProteinKualitatif before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByProteinKualitatif before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Albumin.
	 *
	 * @param albumin the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Albumin
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByAlbumin(String albumin)
	// % protected region % [Add any throwables, implementations, or extensions for findByAlbumin here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAlbumin here] end
	{
		// % protected region % [Add any additional logic for findByAlbumin before the main body here] off begin
		// % protected region % [Add any additional logic for findByAlbumin before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByAlbumin(albumin));

		// % protected region % [Add any additional logic for findByAlbumin before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAlbumin before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Creatinine.
	 *
	 * @param creatinine the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Creatinine
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByCreatinine(String creatinine)
	// % protected region % [Add any throwables, implementations, or extensions for findByCreatinine here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCreatinine here] end
	{
		// % protected region % [Add any additional logic for findByCreatinine before the main body here] off begin
		// % protected region % [Add any additional logic for findByCreatinine before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByCreatinine(creatinine));

		// % protected region % [Add any additional logic for findByCreatinine before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCreatinine before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Ureum.
	 *
	 * @param ureum the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Ureum
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByUreum(String ureum)
	// % protected region % [Add any throwables, implementations, or extensions for findByUreum here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUreum here] end
	{
		// % protected region % [Add any additional logic for findByUreum before the main body here] off begin
		// % protected region % [Add any additional logic for findByUreum before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByUreum(ureum));

		// % protected region % [Add any additional logic for findByUreum before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUreum before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Asam.
	 *
	 * @param asam the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Asam
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByAsam(String asam)
	// % protected region % [Add any throwables, implementations, or extensions for findByAsam here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAsam here] end
	{
		// % protected region % [Add any additional logic for findByAsam before the main body here] off begin
		// % protected region % [Add any additional logic for findByAsam before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByAsam(asam));

		// % protected region % [Add any additional logic for findByAsam before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAsam before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute ABI.
	 *
	 * @param abi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ABI
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByAbi(String abi)
	// % protected region % [Add any throwables, implementations, or extensions for findByAbi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAbi here] end
	{
		// % protected region % [Add any additional logic for findByAbi before the main body here] off begin
		// % protected region % [Add any additional logic for findByAbi before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByAbi(abi));

		// % protected region % [Add any additional logic for findByAbi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAbi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute EKG.
	 *
	 * @param ekg the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute EKG
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByEkg(String ekg)
	// % protected region % [Add any throwables, implementations, or extensions for findByEkg here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEkg here] end
	{
		// % protected region % [Add any additional logic for findByEkg before the main body here] off begin
		// % protected region % [Add any additional logic for findByEkg before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByEkg(ekg));

		// % protected region % [Add any additional logic for findByEkg before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEkg before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Echo.
	 *
	 * @param echo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Echo
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByEcho(String echo)
	// % protected region % [Add any throwables, implementations, or extensions for findByEcho here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEcho here] end
	{
		// % protected region % [Add any additional logic for findByEcho before the main body here] off begin
		// % protected region % [Add any additional logic for findByEcho before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByEcho(echo));

		// % protected region % [Add any additional logic for findByEcho before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEcho before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Funduskopi.
	 *
	 * @param funduskopi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Funduskopi
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByFunduskopi(String funduskopi)
	// % protected region % [Add any throwables, implementations, or extensions for findByFunduskopi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFunduskopi here] end
	{
		// % protected region % [Add any additional logic for findByFunduskopi before the main body here] off begin
		// % protected region % [Add any additional logic for findByFunduskopi before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByFunduskopi(funduskopi));

		// % protected region % [Add any additional logic for findByFunduskopi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFunduskopi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pemeriksaan Lain.
	 *
	 * @param pemeriksaanLain the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pemeriksaan Lain
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByPemeriksaanLain(String pemeriksaanLain)
	// % protected region % [Add any throwables, implementations, or extensions for findByPemeriksaanLain here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPemeriksaanLain here] end
	{
		// % protected region % [Add any additional logic for findByPemeriksaanLain before the main body here] off begin
		// % protected region % [Add any additional logic for findByPemeriksaanLain before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByPemeriksaanLain(pemeriksaanLain));

		// % protected region % [Add any additional logic for findByPemeriksaanLain before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPemeriksaanLain before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Keterangan.
	 *
	 * @param keterangan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Keterangan
	 */
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findByKeterangan(String keterangan)
	// % protected region % [Add any throwables, implementations, or extensions for findByKeterangan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKeterangan here] end
	{
		// % protected region % [Add any additional logic for findByKeterangan before the main body here] off begin
		// % protected region % [Add any additional logic for findByKeterangan before the main body here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findByKeterangan(keterangan));

		// % protected region % [Add any additional logic for findByKeterangan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKeterangan before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PcareMCUEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<PcareMCUEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<PcareMCUEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareMCUEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<PcareMCUEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PcareMCUEntity', 'create')")
	public PcareMCUEntity create(PcareMCUEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		PcareMCUEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PcareMCUEntity', 'create')")
	public PcareMCUEntity create(PcareMCUEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		PcareMCUEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		PcareMCUEntity newEntity;

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
	@PreAuthorize("hasPermission('PcareMCUEntity', 'create')")
	public List<PcareMCUEntity> createAll(Iterable<PcareMCUEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<PcareMCUEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<PcareMCUEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PcareMCUEntity', 'update')")
	public PcareMCUEntity update(PcareMCUEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		PcareMCUEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PcareMCUEntity', 'update')")
	public PcareMCUEntity update(PcareMCUEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		PcareMCUEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		PcareMCUEntity newEntity;

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
	@PreAuthorize("hasPermission('PcareMCUEntity', 'update')")
	public List<PcareMCUEntity> updateAll(Iterable<PcareMCUEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<PcareMCUEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<PcareMCUEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PcareMCUEntity', 'create') or hasPermission('PcareMCUEntity', 'update')")
	public PcareMCUEntity save(PcareMCUEntity entity) throws ConstraintViolationException
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

		PcareMCUEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('PcareMCUEntity', 'create') or hasPermission('PcareMCUEntity', 'update')")
	public List<PcareMCUEntity> saveAll(Iterable<PcareMCUEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<PcareMCUEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PcareMCUEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('PcareMCUEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PcareMCUEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	public List<PcareMCUEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	public List<PcareMCUEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PcareMCUEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(PcareMCUEntity.class);

		// % protected region % [Add any additional processing before converting to a list of PcareMCUEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of PcareMCUEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('PcareMCUEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PcareMCUEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of PcareMCUEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of PcareMCUEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(PcareMCUEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of PcareMCUEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of PcareMCUEntityAudits
	 */
	private List<PcareMCUEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<PcareMCUEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param pcareMCU pcareMCU to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private PcareMCUEntity updateAuditData(PcareMCUEntity pcareMCU)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return pcareMCU;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private PcareMCUEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		PcareMCUEntity entityAtRevision = updateAuditData((PcareMCUEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new PcareMCUEntityAudit(
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

		QPcareMCUEntity entity = QPcareMCUEntity.pcareMCUEntity;

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
			case "kodeMCU":
				// % protected region % [Add any additional logic before the query parameters of kodeMCU here] off begin
				// % protected region % [Add any additional logic before the query parameters of kodeMCU here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kodeMCU, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kodeMCU here] off begin
				// % protected region % [Add any additional logic after the query parameters of kodeMCU here] end

				break;
			case "noKunjungan":
				// % protected region % [Add any additional logic before the query parameters of noKunjungan here] off begin
				// % protected region % [Add any additional logic before the query parameters of noKunjungan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.noKunjungan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of noKunjungan here] off begin
				// % protected region % [Add any additional logic after the query parameters of noKunjungan here] end

				break;
			case "kodeProvider":
				// % protected region % [Add any additional logic before the query parameters of kodeProvider here] off begin
				// % protected region % [Add any additional logic before the query parameters of kodeProvider here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kodeProvider, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kodeProvider here] off begin
				// % protected region % [Add any additional logic after the query parameters of kodeProvider here] end

				break;
			case "namaProvider":
				// % protected region % [Add any additional logic before the query parameters of namaProvider here] off begin
				// % protected region % [Add any additional logic before the query parameters of namaProvider here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.namaProvider, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of namaProvider here] off begin
				// % protected region % [Add any additional logic after the query parameters of namaProvider here] end

				break;
			case "tanggalPelayanan":
				// % protected region % [Add any additional logic before the query parameters of tanggalPelayanan here] off begin
				// % protected region % [Add any additional logic before the query parameters of tanggalPelayanan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tanggalPelayanan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tanggalPelayanan here] off begin
				// % protected region % [Add any additional logic after the query parameters of tanggalPelayanan here] end

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
	public PcareMCUEntity updateOldData(PcareMCUEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public PcareMCUEntity updateOldData(PcareMCUEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		PcareMCUEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInPcareMCUEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
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
	public void validateEntity(PcareMCUEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<PcareMCUEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the PcareMCUEntity.
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

	public Set<String> validateEntityRelations(PcareMCUEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
