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
import kmsweb.repositories.BpjsPcarePendaftaranRepository;
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
import kmsweb.entities.PatientVisitEntity;
import kmsweb.repositories.PatientVisitRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class BpjsPcarePendaftaranService extends AbstractService<BpjsPcarePendaftaranEntity, BpjsPcarePendaftaranRepository, BpjsPcarePendaftaranEntityAudit> {

	private final String[] referenceNamesInBpjsPcarePendaftaranEntity = {
		"patientVisit",
	};

	private final PatientVisitRepository patientVisitRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsPcarePendaftaranService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		PatientVisitRepository patientVisitRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		BpjsPcarePendaftaranRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.patientVisitRepository = patientVisitRepository;

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
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
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
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute noUrut.
	 *
	 * @param nourut the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noUrut
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByNourut(String nourut)
	// % protected region % [Add any throwables, implementations, or extensions for findByNourut here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNourut here] end
	{
		// % protected region % [Add any additional logic for findByNourut before the main body here] off begin
		// % protected region % [Add any additional logic for findByNourut before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByNourut(nourut));

		// % protected region % [Add any additional logic for findByNourut before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNourut before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tgldaftar.
	 *
	 * @param tgldaftar the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tgldaftar
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByTgldaftar(String tgldaftar)
	// % protected region % [Add any throwables, implementations, or extensions for findByTgldaftar here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTgldaftar here] end
	{
		// % protected region % [Add any additional logic for findByTgldaftar before the main body here] off begin
		// % protected region % [Add any additional logic for findByTgldaftar before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByTgldaftar(tgldaftar));

		// % protected region % [Add any additional logic for findByTgldaftar before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTgldaftar before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute providerPelayanan.
	 *
	 * @param providerpelayanan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute providerPelayanan
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByProviderpelayanan(String providerpelayanan)
	// % protected region % [Add any throwables, implementations, or extensions for findByProviderpelayanan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByProviderpelayanan here] end
	{
		// % protected region % [Add any additional logic for findByProviderpelayanan before the main body here] off begin
		// % protected region % [Add any additional logic for findByProviderpelayanan before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByProviderpelayanan(providerpelayanan));

		// % protected region % [Add any additional logic for findByProviderpelayanan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByProviderpelayanan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute noKartu.
	 *
	 * @param nokartu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noKartu
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByNokartu(String nokartu)
	// % protected region % [Add any throwables, implementations, or extensions for findByNokartu here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNokartu here] end
	{
		// % protected region % [Add any additional logic for findByNokartu before the main body here] off begin
		// % protected region % [Add any additional logic for findByNokartu before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByNokartu(nokartu));

		// % protected region % [Add any additional logic for findByNokartu before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNokartu before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nama.
	 *
	 * @param nama the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nama
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByNama(String nama)
	// % protected region % [Add any throwables, implementations, or extensions for findByNama here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNama here] end
	{
		// % protected region % [Add any additional logic for findByNama before the main body here] off begin
		// % protected region % [Add any additional logic for findByNama before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByNama(nama));

		// % protected region % [Add any additional logic for findByNama before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNama before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute hubunganKeluarga.
	 *
	 * @param hubungankeluarga the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute hubunganKeluarga
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByHubungankeluarga(String hubungankeluarga)
	// % protected region % [Add any throwables, implementations, or extensions for findByHubungankeluarga here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHubungankeluarga here] end
	{
		// % protected region % [Add any additional logic for findByHubungankeluarga before the main body here] off begin
		// % protected region % [Add any additional logic for findByHubungankeluarga before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByHubungankeluarga(hubungankeluarga));

		// % protected region % [Add any additional logic for findByHubungankeluarga before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHubungankeluarga before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute sex.
	 *
	 * @param sex the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute sex
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findBySex(String sex)
	// % protected region % [Add any throwables, implementations, or extensions for findBySex here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySex here] end
	{
		// % protected region % [Add any additional logic for findBySex before the main body here] off begin
		// % protected region % [Add any additional logic for findBySex before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findBySex(sex));

		// % protected region % [Add any additional logic for findBySex before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySex before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tglLahir.
	 *
	 * @param tgllahir the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglLahir
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByTgllahir(String tgllahir)
	// % protected region % [Add any throwables, implementations, or extensions for findByTgllahir here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTgllahir here] end
	{
		// % protected region % [Add any additional logic for findByTgllahir before the main body here] off begin
		// % protected region % [Add any additional logic for findByTgllahir before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByTgllahir(tgllahir));

		// % protected region % [Add any additional logic for findByTgllahir before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTgllahir before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tglMulaiAktif.
	 *
	 * @param tglmulaiaktif the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglMulaiAktif
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByTglmulaiaktif(String tglmulaiaktif)
	// % protected region % [Add any throwables, implementations, or extensions for findByTglmulaiaktif here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTglmulaiaktif here] end
	{
		// % protected region % [Add any additional logic for findByTglmulaiaktif before the main body here] off begin
		// % protected region % [Add any additional logic for findByTglmulaiaktif before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByTglmulaiaktif(tglmulaiaktif));

		// % protected region % [Add any additional logic for findByTglmulaiaktif before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTglmulaiaktif before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tglAkhirBerlaku.
	 *
	 * @param tglakhirberlaku the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglAkhirBerlaku
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByTglakhirberlaku(String tglakhirberlaku)
	// % protected region % [Add any throwables, implementations, or extensions for findByTglakhirberlaku here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTglakhirberlaku here] end
	{
		// % protected region % [Add any additional logic for findByTglakhirberlaku before the main body here] off begin
		// % protected region % [Add any additional logic for findByTglakhirberlaku before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByTglakhirberlaku(tglakhirberlaku));

		// % protected region % [Add any additional logic for findByTglakhirberlaku before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTglakhirberlaku before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdProviderPst.
	 *
	 * @param kdproviderpst the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdProviderPst
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByKdproviderpst(String kdproviderpst)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdproviderpst here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdproviderpst here] end
	{
		// % protected region % [Add any additional logic for findByKdproviderpst before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdproviderpst before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByKdproviderpst(kdproviderpst));

		// % protected region % [Add any additional logic for findByKdproviderpst before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdproviderpst before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdProviderGigi.
	 *
	 * @param kdprovidergigi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdProviderGigi
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByKdprovidergigi(String kdprovidergigi)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdprovidergigi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdprovidergigi here] end
	{
		// % protected region % [Add any additional logic for findByKdprovidergigi before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdprovidergigi before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByKdprovidergigi(kdprovidergigi));

		// % protected region % [Add any additional logic for findByKdprovidergigi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdprovidergigi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute jnsKelas.
	 *
	 * @param jnskelas the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute jnsKelas
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByJnskelas(String jnskelas)
	// % protected region % [Add any throwables, implementations, or extensions for findByJnskelas here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByJnskelas here] end
	{
		// % protected region % [Add any additional logic for findByJnskelas before the main body here] off begin
		// % protected region % [Add any additional logic for findByJnskelas before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByJnskelas(jnskelas));

		// % protected region % [Add any additional logic for findByJnskelas before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByJnskelas before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute jnsPeserta.
	 *
	 * @param jnspeserta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute jnsPeserta
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByJnspeserta(String jnspeserta)
	// % protected region % [Add any throwables, implementations, or extensions for findByJnspeserta here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByJnspeserta here] end
	{
		// % protected region % [Add any additional logic for findByJnspeserta before the main body here] off begin
		// % protected region % [Add any additional logic for findByJnspeserta before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByJnspeserta(jnspeserta));

		// % protected region % [Add any additional logic for findByJnspeserta before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByJnspeserta before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute golDarah.
	 *
	 * @param goldarah the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute golDarah
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByGoldarah(String goldarah)
	// % protected region % [Add any throwables, implementations, or extensions for findByGoldarah here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGoldarah here] end
	{
		// % protected region % [Add any additional logic for findByGoldarah before the main body here] off begin
		// % protected region % [Add any additional logic for findByGoldarah before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByGoldarah(goldarah));

		// % protected region % [Add any additional logic for findByGoldarah before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGoldarah before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute noHP.
	 *
	 * @param nohp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noHP
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByNohp(String nohp)
	// % protected region % [Add any throwables, implementations, or extensions for findByNohp here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNohp here] end
	{
		// % protected region % [Add any additional logic for findByNohp before the main body here] off begin
		// % protected region % [Add any additional logic for findByNohp before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByNohp(nohp));

		// % protected region % [Add any additional logic for findByNohp before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNohp before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute noKTP.
	 *
	 * @param noktp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noKTP
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByNoktp(String noktp)
	// % protected region % [Add any throwables, implementations, or extensions for findByNoktp here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNoktp here] end
	{
		// % protected region % [Add any additional logic for findByNoktp before the main body here] off begin
		// % protected region % [Add any additional logic for findByNoktp before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByNoktp(noktp));

		// % protected region % [Add any additional logic for findByNoktp before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNoktp before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute aktif.
	 *
	 * @param aktif the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute aktif
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByAktif(String aktif)
	// % protected region % [Add any throwables, implementations, or extensions for findByAktif here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAktif here] end
	{
		// % protected region % [Add any additional logic for findByAktif before the main body here] off begin
		// % protected region % [Add any additional logic for findByAktif before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByAktif(aktif));

		// % protected region % [Add any additional logic for findByAktif before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAktif before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute ketAktif.
	 *
	 * @param ketaktif the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ketAktif
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByKetaktif(String ketaktif)
	// % protected region % [Add any throwables, implementations, or extensions for findByKetaktif here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKetaktif here] end
	{
		// % protected region % [Add any additional logic for findByKetaktif before the main body here] off begin
		// % protected region % [Add any additional logic for findByKetaktif before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByKetaktif(ketaktif));

		// % protected region % [Add any additional logic for findByKetaktif before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKetaktif before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute asuransi.
	 *
	 * @param asuransi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute asuransi
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByAsuransi(String asuransi)
	// % protected region % [Add any throwables, implementations, or extensions for findByAsuransi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAsuransi here] end
	{
		// % protected region % [Add any additional logic for findByAsuransi before the main body here] off begin
		// % protected region % [Add any additional logic for findByAsuransi before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByAsuransi(asuransi));

		// % protected region % [Add any additional logic for findByAsuransi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAsuransi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdPoli.
	 *
	 * @param kdpoli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdPoli
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByKdpoli(String kdpoli)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdpoli here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdpoli here] end
	{
		// % protected region % [Add any additional logic for findByKdpoli before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdpoli before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByKdpoli(kdpoli));

		// % protected region % [Add any additional logic for findByKdpoli before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdpoli before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmPoli.
	 *
	 * @param nmpoli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmPoli
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByNmpoli(String nmpoli)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmpoli here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmpoli here] end
	{
		// % protected region % [Add any additional logic for findByNmpoli before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmpoli before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByNmpoli(nmpoli));

		// % protected region % [Add any additional logic for findByNmpoli before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmpoli before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute poliSakit.
	 *
	 * @param polisakit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute poliSakit
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByPolisakit(String polisakit)
	// % protected region % [Add any throwables, implementations, or extensions for findByPolisakit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPolisakit here] end
	{
		// % protected region % [Add any additional logic for findByPolisakit before the main body here] off begin
		// % protected region % [Add any additional logic for findByPolisakit before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByPolisakit(polisakit));

		// % protected region % [Add any additional logic for findByPolisakit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPolisakit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute keluhan.
	 *
	 * @param keluhan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute keluhan
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByKeluhan(String keluhan)
	// % protected region % [Add any throwables, implementations, or extensions for findByKeluhan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKeluhan here] end
	{
		// % protected region % [Add any additional logic for findByKeluhan before the main body here] off begin
		// % protected region % [Add any additional logic for findByKeluhan before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByKeluhan(keluhan));

		// % protected region % [Add any additional logic for findByKeluhan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKeluhan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kunjSakit.
	 *
	 * @param kunjsakit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kunjSakit
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByKunjsakit(String kunjsakit)
	// % protected region % [Add any throwables, implementations, or extensions for findByKunjsakit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKunjsakit here] end
	{
		// % protected region % [Add any additional logic for findByKunjsakit before the main body here] off begin
		// % protected region % [Add any additional logic for findByKunjsakit before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByKunjsakit(kunjsakit));

		// % protected region % [Add any additional logic for findByKunjsakit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKunjsakit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute status.
	 *
	 * @param status the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute status
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByStatus(String status)
	// % protected region % [Add any throwables, implementations, or extensions for findByStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStatus here] end
	{
		// % protected region % [Add any additional logic for findByStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByStatus before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByStatus(status));

		// % protected region % [Add any additional logic for findByStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute sistole.
	 *
	 * @param sistole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute sistole
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findBySistole(String sistole)
	// % protected region % [Add any throwables, implementations, or extensions for findBySistole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySistole here] end
	{
		// % protected region % [Add any additional logic for findBySistole before the main body here] off begin
		// % protected region % [Add any additional logic for findBySistole before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findBySistole(sistole));

		// % protected region % [Add any additional logic for findBySistole before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySistole before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute diastole.
	 *
	 * @param diastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute diastole
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByDiastole(String diastole)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastole here] end
	{
		// % protected region % [Add any additional logic for findByDiastole before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiastole before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByDiastole(diastole));

		// % protected region % [Add any additional logic for findByDiastole before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiastole before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute beratBadan.
	 *
	 * @param beratbadan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute beratBadan
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByBeratbadan(String beratbadan)
	// % protected region % [Add any throwables, implementations, or extensions for findByBeratbadan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBeratbadan here] end
	{
		// % protected region % [Add any additional logic for findByBeratbadan before the main body here] off begin
		// % protected region % [Add any additional logic for findByBeratbadan before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByBeratbadan(beratbadan));

		// % protected region % [Add any additional logic for findByBeratbadan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBeratbadan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tinggiBadan.
	 *
	 * @param tinggibadan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tinggiBadan
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByTinggibadan(String tinggibadan)
	// % protected region % [Add any throwables, implementations, or extensions for findByTinggibadan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTinggibadan here] end
	{
		// % protected region % [Add any additional logic for findByTinggibadan before the main body here] off begin
		// % protected region % [Add any additional logic for findByTinggibadan before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByTinggibadan(tinggibadan));

		// % protected region % [Add any additional logic for findByTinggibadan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTinggibadan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute respRate.
	 *
	 * @param resprate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute respRate
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByResprate(String resprate)
	// % protected region % [Add any throwables, implementations, or extensions for findByResprate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByResprate here] end
	{
		// % protected region % [Add any additional logic for findByResprate before the main body here] off begin
		// % protected region % [Add any additional logic for findByResprate before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByResprate(resprate));

		// % protected region % [Add any additional logic for findByResprate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByResprate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute heartRate.
	 *
	 * @param heartrate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute heartRate
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByHeartrate(String heartrate)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeartrate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeartrate here] end
	{
		// % protected region % [Add any additional logic for findByHeartrate before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeartrate before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByHeartrate(heartrate));

		// % protected region % [Add any additional logic for findByHeartrate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHeartrate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdTkp.
	 *
	 * @param kdtkp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdTkp
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByKdtkp(String kdtkp)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdtkp here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdtkp here] end
	{
		// % protected region % [Add any additional logic for findByKdtkp before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdtkp before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByKdtkp(kdtkp));

		// % protected region % [Add any additional logic for findByKdtkp before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdtkp before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmTkp.
	 *
	 * @param nmtkp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmTkp
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByNmtkp(String nmtkp)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmtkp here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmtkp here] end
	{
		// % protected region % [Add any additional logic for findByNmtkp before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmtkp before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByNmtkp(nmtkp));

		// % protected region % [Add any additional logic for findByNmtkp before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmtkp before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdProviderPelayanan.
	 *
	 * @param kdproviderpelayanan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdProviderPelayanan
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByKdproviderpelayanan(String kdproviderpelayanan)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdproviderpelayanan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdproviderpelayanan here] end
	{
		// % protected region % [Add any additional logic for findByKdproviderpelayanan before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdproviderpelayanan before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByKdproviderpelayanan(kdproviderpelayanan));

		// % protected region % [Add any additional logic for findByKdproviderpelayanan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdproviderpelayanan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmProviderPelayanan.
	 *
	 * @param nmproviderpelayanan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmProviderPelayanan
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByNmproviderpelayanan(String nmproviderpelayanan)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmproviderpelayanan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmproviderpelayanan here] end
	{
		// % protected region % [Add any additional logic for findByNmproviderpelayanan before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmproviderpelayanan before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByNmproviderpelayanan(nmproviderpelayanan));

		// % protected region % [Add any additional logic for findByNmproviderpelayanan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmproviderpelayanan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmProviderPst.
	 *
	 * @param nmproviderpst the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmProviderPst
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByNmproviderpst(String nmproviderpst)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmproviderpst here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmproviderpst here] end
	{
		// % protected region % [Add any additional logic for findByNmproviderpst before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmproviderpst before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByNmproviderpst(nmproviderpst));

		// % protected region % [Add any additional logic for findByNmproviderpst before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmproviderpst before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmProviderGigi.
	 *
	 * @param nmprovidergigi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmProviderGigi
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByNmprovidergigi(String nmprovidergigi)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmprovidergigi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmprovidergigi here] end
	{
		// % protected region % [Add any additional logic for findByNmprovidergigi before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmprovidergigi before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByNmprovidergigi(nmprovidergigi));

		// % protected region % [Add any additional logic for findByNmprovidergigi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmprovidergigi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kodeKls.
	 *
	 * @param kodekls the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodeKls
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByKodekls(String kodekls)
	// % protected region % [Add any throwables, implementations, or extensions for findByKodekls here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKodekls here] end
	{
		// % protected region % [Add any additional logic for findByKodekls before the main body here] off begin
		// % protected region % [Add any additional logic for findByKodekls before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByKodekls(kodekls));

		// % protected region % [Add any additional logic for findByKodekls before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKodekls before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute namaKls.
	 *
	 * @param namakls the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute namaKls
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByNamakls(String namakls)
	// % protected region % [Add any throwables, implementations, or extensions for findByNamakls here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNamakls here] end
	{
		// % protected region % [Add any additional logic for findByNamakls before the main body here] off begin
		// % protected region % [Add any additional logic for findByNamakls before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByNamakls(namakls));

		// % protected region % [Add any additional logic for findByNamakls before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNamakls before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kodePeserta.
	 *
	 * @param kodepeserta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodePeserta
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByKodepeserta(String kodepeserta)
	// % protected region % [Add any throwables, implementations, or extensions for findByKodepeserta here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKodepeserta here] end
	{
		// % protected region % [Add any additional logic for findByKodepeserta before the main body here] off begin
		// % protected region % [Add any additional logic for findByKodepeserta before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByKodepeserta(kodepeserta));

		// % protected region % [Add any additional logic for findByKodepeserta before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKodepeserta before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute namaPeserta.
	 *
	 * @param namapeserta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute namaPeserta
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByNamapeserta(String namapeserta)
	// % protected region % [Add any throwables, implementations, or extensions for findByNamapeserta here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNamapeserta here] end
	{
		// % protected region % [Add any additional logic for findByNamapeserta before the main body here] off begin
		// % protected region % [Add any additional logic for findByNamapeserta before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByNamapeserta(namapeserta));

		// % protected region % [Add any additional logic for findByNamapeserta before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNamapeserta before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdAsuransi.
	 *
	 * @param kdasuransi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdAsuransi
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByKdasuransi(String kdasuransi)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdasuransi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdasuransi here] end
	{
		// % protected region % [Add any additional logic for findByKdasuransi before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdasuransi before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByKdasuransi(kdasuransi));

		// % protected region % [Add any additional logic for findByKdasuransi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdasuransi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmAsuransi.
	 *
	 * @param nmasuransi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmAsuransi
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByNmasuransi(String nmasuransi)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmasuransi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmasuransi here] end
	{
		// % protected region % [Add any additional logic for findByNmasuransi before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmasuransi before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByNmasuransi(nmasuransi));

		// % protected region % [Add any additional logic for findByNmasuransi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmasuransi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute noAsuransi.
	 *
	 * @param noasuransi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noAsuransi
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByNoasuransi(String noasuransi)
	// % protected region % [Add any throwables, implementations, or extensions for findByNoasuransi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNoasuransi here] end
	{
		// % protected region % [Add any additional logic for findByNoasuransi before the main body here] off begin
		// % protected region % [Add any additional logic for findByNoasuransi before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByNoasuransi(noasuransi));

		// % protected region % [Add any additional logic for findByNoasuransi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNoasuransi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute lingkarPerut.
	 *
	 * @param lingkarperut the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute lingkarPerut
	 */
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findByLingkarperut(String lingkarperut)
	// % protected region % [Add any throwables, implementations, or extensions for findByLingkarperut here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLingkarperut here] end
	{
		// % protected region % [Add any additional logic for findByLingkarperut before the main body here] off begin
		// % protected region % [Add any additional logic for findByLingkarperut before the main body here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findByLingkarperut(lingkarperut));

		// % protected region % [Add any additional logic for findByLingkarperut before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLingkarperut before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsPcarePendaftaranEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BpjsPcarePendaftaranEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BpjsPcarePendaftaranEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'create')")
	public BpjsPcarePendaftaranEntity create(BpjsPcarePendaftaranEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BpjsPcarePendaftaranEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'create')")
	public BpjsPcarePendaftaranEntity create(BpjsPcarePendaftaranEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BpjsPcarePendaftaranEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BpjsPcarePendaftaranEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'create')")
	public List<BpjsPcarePendaftaranEntity> createAll(Iterable<BpjsPcarePendaftaranEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BpjsPcarePendaftaranEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BpjsPcarePendaftaranEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'update')")
	public BpjsPcarePendaftaranEntity update(BpjsPcarePendaftaranEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BpjsPcarePendaftaranEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'update')")
	public BpjsPcarePendaftaranEntity update(BpjsPcarePendaftaranEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BpjsPcarePendaftaranEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BpjsPcarePendaftaranEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'update')")
	public List<BpjsPcarePendaftaranEntity> updateAll(Iterable<BpjsPcarePendaftaranEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BpjsPcarePendaftaranEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BpjsPcarePendaftaranEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'create') or hasPermission('BpjsPcarePendaftaranEntity', 'update')")
	public BpjsPcarePendaftaranEntity save(BpjsPcarePendaftaranEntity entity) throws ConstraintViolationException
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

		BpjsPcarePendaftaranEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'create') or hasPermission('BpjsPcarePendaftaranEntity', 'update')")
	public List<BpjsPcarePendaftaranEntity> saveAll(Iterable<BpjsPcarePendaftaranEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BpjsPcarePendaftaranEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	public List<BpjsPcarePendaftaranEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	public List<BpjsPcarePendaftaranEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BpjsPcarePendaftaranEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BpjsPcarePendaftaranEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsPcarePendaftaranEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePendaftaranEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsPcarePendaftaranEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BpjsPcarePendaftaranEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsPcarePendaftaranEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BpjsPcarePendaftaranEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BpjsPcarePendaftaranEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BpjsPcarePendaftaranEntityAudits
	 */
	private List<BpjsPcarePendaftaranEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BpjsPcarePendaftaranEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bpjsPcarePendaftaran bpjsPcarePendaftaran to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BpjsPcarePendaftaranEntity updateAuditData(BpjsPcarePendaftaranEntity bpjsPcarePendaftaran)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bpjsPcarePendaftaran;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BpjsPcarePendaftaranEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BpjsPcarePendaftaranEntity entityAtRevision = updateAuditData((BpjsPcarePendaftaranEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BpjsPcarePendaftaranEntityAudit(
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

		QBpjsPcarePendaftaranEntity entity = QBpjsPcarePendaftaranEntity.bpjsPcarePendaftaranEntity;

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
			case "patientVisitId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Bpjs Pcare Pendaftarans here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Bpjs Pcare Pendaftarans here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientVisit.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Bpjs Pcare Pendaftarans here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Bpjs Pcare Pendaftarans here] end

				break;
			case "nourut":
				// % protected region % [Add any additional logic before the query parameters of nourut here] off begin
				// % protected region % [Add any additional logic before the query parameters of nourut here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nourut, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nourut here] off begin
				// % protected region % [Add any additional logic after the query parameters of nourut here] end

				break;
			case "tgldaftar":
				// % protected region % [Add any additional logic before the query parameters of tgldaftar here] off begin
				// % protected region % [Add any additional logic before the query parameters of tgldaftar here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tgldaftar, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tgldaftar here] off begin
				// % protected region % [Add any additional logic after the query parameters of tgldaftar here] end

				break;
			case "providerpelayanan":
				// % protected region % [Add any additional logic before the query parameters of providerpelayanan here] off begin
				// % protected region % [Add any additional logic before the query parameters of providerpelayanan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.providerpelayanan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of providerpelayanan here] off begin
				// % protected region % [Add any additional logic after the query parameters of providerpelayanan here] end

				break;
			case "nokartu":
				// % protected region % [Add any additional logic before the query parameters of nokartu here] off begin
				// % protected region % [Add any additional logic before the query parameters of nokartu here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nokartu, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nokartu here] off begin
				// % protected region % [Add any additional logic after the query parameters of nokartu here] end

				break;
			case "nama":
				// % protected region % [Add any additional logic before the query parameters of nama here] off begin
				// % protected region % [Add any additional logic before the query parameters of nama here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nama, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nama here] off begin
				// % protected region % [Add any additional logic after the query parameters of nama here] end

				break;
			case "hubungankeluarga":
				// % protected region % [Add any additional logic before the query parameters of hubungankeluarga here] off begin
				// % protected region % [Add any additional logic before the query parameters of hubungankeluarga here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.hubungankeluarga, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of hubungankeluarga here] off begin
				// % protected region % [Add any additional logic after the query parameters of hubungankeluarga here] end

				break;
			case "sex":
				// % protected region % [Add any additional logic before the query parameters of sex here] off begin
				// % protected region % [Add any additional logic before the query parameters of sex here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sex, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of sex here] off begin
				// % protected region % [Add any additional logic after the query parameters of sex here] end

				break;
			case "tgllahir":
				// % protected region % [Add any additional logic before the query parameters of tgllahir here] off begin
				// % protected region % [Add any additional logic before the query parameters of tgllahir here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tgllahir, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tgllahir here] off begin
				// % protected region % [Add any additional logic after the query parameters of tgllahir here] end

				break;
			case "tglakhirberlaku":
				// % protected region % [Add any additional logic before the query parameters of tglakhirberlaku here] off begin
				// % protected region % [Add any additional logic before the query parameters of tglakhirberlaku here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tglakhirberlaku, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tglakhirberlaku here] off begin
				// % protected region % [Add any additional logic after the query parameters of tglakhirberlaku here] end

				break;
			case "kdproviderpst":
				// % protected region % [Add any additional logic before the query parameters of kdproviderpst here] off begin
				// % protected region % [Add any additional logic before the query parameters of kdproviderpst here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kdproviderpst, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kdproviderpst here] off begin
				// % protected region % [Add any additional logic after the query parameters of kdproviderpst here] end

				break;
			case "kdprovidergigi":
				// % protected region % [Add any additional logic before the query parameters of kdprovidergigi here] off begin
				// % protected region % [Add any additional logic before the query parameters of kdprovidergigi here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kdprovidergigi, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kdprovidergigi here] off begin
				// % protected region % [Add any additional logic after the query parameters of kdprovidergigi here] end

				break;
			case "jnspeserta":
				// % protected region % [Add any additional logic before the query parameters of jnspeserta here] off begin
				// % protected region % [Add any additional logic before the query parameters of jnspeserta here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.jnspeserta, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of jnspeserta here] off begin
				// % protected region % [Add any additional logic after the query parameters of jnspeserta here] end

				break;
			case "goldarah":
				// % protected region % [Add any additional logic before the query parameters of goldarah here] off begin
				// % protected region % [Add any additional logic before the query parameters of goldarah here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.goldarah, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of goldarah here] off begin
				// % protected region % [Add any additional logic after the query parameters of goldarah here] end

				break;
			case "nohp":
				// % protected region % [Add any additional logic before the query parameters of nohp here] off begin
				// % protected region % [Add any additional logic before the query parameters of nohp here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nohp, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nohp here] off begin
				// % protected region % [Add any additional logic after the query parameters of nohp here] end

				break;
			case "noktp":
				// % protected region % [Add any additional logic before the query parameters of noktp here] off begin
				// % protected region % [Add any additional logic before the query parameters of noktp here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.noktp, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of noktp here] off begin
				// % protected region % [Add any additional logic after the query parameters of noktp here] end

				break;
			case "aktif":
				// % protected region % [Add any additional logic before the query parameters of aktif here] off begin
				// % protected region % [Add any additional logic before the query parameters of aktif here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.aktif, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of aktif here] off begin
				// % protected region % [Add any additional logic after the query parameters of aktif here] end

				break;
			case "ketaktif":
				// % protected region % [Add any additional logic before the query parameters of ketaktif here] off begin
				// % protected region % [Add any additional logic before the query parameters of ketaktif here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.ketaktif, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of ketaktif here] off begin
				// % protected region % [Add any additional logic after the query parameters of ketaktif here] end

				break;
			case "asuransi":
				// % protected region % [Add any additional logic before the query parameters of asuransi here] off begin
				// % protected region % [Add any additional logic before the query parameters of asuransi here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.asuransi, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of asuransi here] off begin
				// % protected region % [Add any additional logic after the query parameters of asuransi here] end

				break;
			case "kdpoli":
				// % protected region % [Add any additional logic before the query parameters of kdpoli here] off begin
				// % protected region % [Add any additional logic before the query parameters of kdpoli here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kdpoli, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kdpoli here] off begin
				// % protected region % [Add any additional logic after the query parameters of kdpoli here] end

				break;
			case "nmpoli":
				// % protected region % [Add any additional logic before the query parameters of nmpoli here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmpoli here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmpoli, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmpoli here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmpoli here] end

				break;
			case "polisakit":
				// % protected region % [Add any additional logic before the query parameters of polisakit here] off begin
				// % protected region % [Add any additional logic before the query parameters of polisakit here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.polisakit, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of polisakit here] off begin
				// % protected region % [Add any additional logic after the query parameters of polisakit here] end

				break;
			case "keluhan":
				// % protected region % [Add any additional logic before the query parameters of keluhan here] off begin
				// % protected region % [Add any additional logic before the query parameters of keluhan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.keluhan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of keluhan here] off begin
				// % protected region % [Add any additional logic after the query parameters of keluhan here] end

				break;
			case "status":
				// % protected region % [Add any additional logic before the query parameters of status here] off begin
				// % protected region % [Add any additional logic before the query parameters of status here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.status, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of status here] off begin
				// % protected region % [Add any additional logic after the query parameters of status here] end

				break;
			case "sistole":
				// % protected region % [Add any additional logic before the query parameters of sistole here] off begin
				// % protected region % [Add any additional logic before the query parameters of sistole here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sistole, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of sistole here] off begin
				// % protected region % [Add any additional logic after the query parameters of sistole here] end

				break;
			case "diastole":
				// % protected region % [Add any additional logic before the query parameters of diastole here] off begin
				// % protected region % [Add any additional logic before the query parameters of diastole here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.diastole, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of diastole here] off begin
				// % protected region % [Add any additional logic after the query parameters of diastole here] end

				break;
			case "beratbadan":
				// % protected region % [Add any additional logic before the query parameters of beratbadan here] off begin
				// % protected region % [Add any additional logic before the query parameters of beratbadan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.beratbadan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of beratbadan here] off begin
				// % protected region % [Add any additional logic after the query parameters of beratbadan here] end

				break;
			case "tinggibadan":
				// % protected region % [Add any additional logic before the query parameters of tinggibadan here] off begin
				// % protected region % [Add any additional logic before the query parameters of tinggibadan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tinggibadan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tinggibadan here] off begin
				// % protected region % [Add any additional logic after the query parameters of tinggibadan here] end

				break;
			case "resprate":
				// % protected region % [Add any additional logic before the query parameters of resprate here] off begin
				// % protected region % [Add any additional logic before the query parameters of resprate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.resprate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of resprate here] off begin
				// % protected region % [Add any additional logic after the query parameters of resprate here] end

				break;
			case "heartrate":
				// % protected region % [Add any additional logic before the query parameters of heartrate here] off begin
				// % protected region % [Add any additional logic before the query parameters of heartrate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.heartrate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of heartrate here] off begin
				// % protected region % [Add any additional logic after the query parameters of heartrate here] end

				break;
			case "kdtkp":
				// % protected region % [Add any additional logic before the query parameters of kdtkp here] off begin
				// % protected region % [Add any additional logic before the query parameters of kdtkp here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kdtkp, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kdtkp here] off begin
				// % protected region % [Add any additional logic after the query parameters of kdtkp here] end

				break;
			case "nmtkp":
				// % protected region % [Add any additional logic before the query parameters of nmtkp here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmtkp here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmtkp, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmtkp here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmtkp here] end

				break;
			case "kdproviderpelayanan":
				// % protected region % [Add any additional logic before the query parameters of kdproviderpelayanan here] off begin
				// % protected region % [Add any additional logic before the query parameters of kdproviderpelayanan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kdproviderpelayanan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kdproviderpelayanan here] off begin
				// % protected region % [Add any additional logic after the query parameters of kdproviderpelayanan here] end

				break;
			case "nmproviderpelayanan":
				// % protected region % [Add any additional logic before the query parameters of nmproviderpelayanan here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmproviderpelayanan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmproviderpelayanan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmproviderpelayanan here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmproviderpelayanan here] end

				break;
			case "nmproviderpst":
				// % protected region % [Add any additional logic before the query parameters of nmproviderpst here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmproviderpst here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmproviderpst, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmproviderpst here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmproviderpst here] end

				break;
			case "nmprovidergigi":
				// % protected region % [Add any additional logic before the query parameters of nmprovidergigi here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmprovidergigi here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmprovidergigi, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmprovidergigi here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmprovidergigi here] end

				break;
			case "kodekls":
				// % protected region % [Add any additional logic before the query parameters of kodekls here] off begin
				// % protected region % [Add any additional logic before the query parameters of kodekls here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kodekls, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kodekls here] off begin
				// % protected region % [Add any additional logic after the query parameters of kodekls here] end

				break;
			case "namakls":
				// % protected region % [Add any additional logic before the query parameters of namakls here] off begin
				// % protected region % [Add any additional logic before the query parameters of namakls here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.namakls, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of namakls here] off begin
				// % protected region % [Add any additional logic after the query parameters of namakls here] end

				break;
			case "kodepeserta":
				// % protected region % [Add any additional logic before the query parameters of kodepeserta here] off begin
				// % protected region % [Add any additional logic before the query parameters of kodepeserta here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kodepeserta, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kodepeserta here] off begin
				// % protected region % [Add any additional logic after the query parameters of kodepeserta here] end

				break;
			case "namapeserta":
				// % protected region % [Add any additional logic before the query parameters of namapeserta here] off begin
				// % protected region % [Add any additional logic before the query parameters of namapeserta here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.namapeserta, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of namapeserta here] off begin
				// % protected region % [Add any additional logic after the query parameters of namapeserta here] end

				break;
			case "kdasuransi":
				// % protected region % [Add any additional logic before the query parameters of kdasuransi here] off begin
				// % protected region % [Add any additional logic before the query parameters of kdasuransi here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kdasuransi, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kdasuransi here] off begin
				// % protected region % [Add any additional logic after the query parameters of kdasuransi here] end

				break;
			case "noasuransi":
				// % protected region % [Add any additional logic before the query parameters of noasuransi here] off begin
				// % protected region % [Add any additional logic before the query parameters of noasuransi here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.noasuransi, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of noasuransi here] off begin
				// % protected region % [Add any additional logic after the query parameters of noasuransi here] end

				break;
			case "lingkarperut":
				// % protected region % [Add any additional logic before the query parameters of lingkarperut here] off begin
				// % protected region % [Add any additional logic before the query parameters of lingkarperut here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.lingkarperut, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of lingkarperut here] off begin
				// % protected region % [Add any additional logic after the query parameters of lingkarperut here] end

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
	public BpjsPcarePendaftaranEntity updateOldData(BpjsPcarePendaftaranEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BpjsPcarePendaftaranEntity updateOldData(BpjsPcarePendaftaranEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BpjsPcarePendaftaranEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBpjsPcarePendaftaranEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getPatientVisit() == null && entity.getPatientVisitId() == null) {
			entityToUpdate.unsetPatientVisit();
		} else if (entity.getPatientVisitId() != null && entity.getPatientVisit() == null) {
			Optional<PatientVisitEntity> patientVisitEntity = this.patientVisitRepository.findById(entity.getPatientVisitId());
			entityToUpdate.setPatientVisit(patientVisitEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientVisit() != null) {
			entityToUpdate.setPatientVisit(entity.getPatientVisit(), false);
			if (entityToUpdate.getPatientVisitId() != null) {
				this.patientVisitRepository.save(entityToUpdate.getPatientVisit());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientVisit().unsetBpjsPcarePendaftarans();
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
	public void validateEntity(BpjsPcarePendaftaranEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BpjsPcarePendaftaranEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the BpjsPcarePendaftaranEntity.
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

	public Set<String> validateEntityRelations(BpjsPcarePendaftaranEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getPatientVisitId() != null && this.patientVisitRepository.findById(entity.getPatientVisitId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientVisitId() + " is not associated with a Patient Visit Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
