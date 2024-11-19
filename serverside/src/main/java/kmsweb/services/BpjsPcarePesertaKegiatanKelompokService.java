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
import kmsweb.repositories.BpjsPcarePesertaKegiatanKelompokRepository;
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
public class BpjsPcarePesertaKegiatanKelompokService extends AbstractService<BpjsPcarePesertaKegiatanKelompokEntity, BpjsPcarePesertaKegiatanKelompokRepository, BpjsPcarePesertaKegiatanKelompokEntityAudit> {

	private final String[] referenceNamesInBpjsPcarePesertaKegiatanKelompokEntity = {
	};

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsPcarePesertaKegiatanKelompokService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		Validator validator,
		AuditingRepository auditingRepository,
		BpjsPcarePesertaKegiatanKelompokRepository repository
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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute eduId.
	 *
	 * @param eduid the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute eduId
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByEduid(String eduid)
	// % protected region % [Add any throwables, implementations, or extensions for findByEduid here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEduid here] end
	{
		// % protected region % [Add any additional logic for findByEduid before the main body here] off begin
		// % protected region % [Add any additional logic for findByEduid before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByEduid(eduid));

		// % protected region % [Add any additional logic for findByEduid before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEduid before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute noKartu.
	 *
	 * @param nokartu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noKartu
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByNokartu(String nokartu)
	// % protected region % [Add any throwables, implementations, or extensions for findByNokartu here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNokartu here] end
	{
		// % protected region % [Add any additional logic for findByNokartu before the main body here] off begin
		// % protected region % [Add any additional logic for findByNokartu before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByNokartu(nokartu));

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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByNama(String nama)
	// % protected region % [Add any throwables, implementations, or extensions for findByNama here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNama here] end
	{
		// % protected region % [Add any additional logic for findByNama before the main body here] off begin
		// % protected region % [Add any additional logic for findByNama before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByNama(nama));

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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByHubungankeluarga(String hubungankeluarga)
	// % protected region % [Add any throwables, implementations, or extensions for findByHubungankeluarga here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHubungankeluarga here] end
	{
		// % protected region % [Add any additional logic for findByHubungankeluarga before the main body here] off begin
		// % protected region % [Add any additional logic for findByHubungankeluarga before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByHubungankeluarga(hubungankeluarga));

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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findBySex(String sex)
	// % protected region % [Add any throwables, implementations, or extensions for findBySex here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySex here] end
	{
		// % protected region % [Add any additional logic for findBySex before the main body here] off begin
		// % protected region % [Add any additional logic for findBySex before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findBySex(sex));

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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByTgllahir(String tgllahir)
	// % protected region % [Add any throwables, implementations, or extensions for findByTgllahir here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTgllahir here] end
	{
		// % protected region % [Add any additional logic for findByTgllahir before the main body here] off begin
		// % protected region % [Add any additional logic for findByTgllahir before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByTgllahir(tgllahir));

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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByTglmulaiaktif(String tglmulaiaktif)
	// % protected region % [Add any throwables, implementations, or extensions for findByTglmulaiaktif here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTglmulaiaktif here] end
	{
		// % protected region % [Add any additional logic for findByTglmulaiaktif before the main body here] off begin
		// % protected region % [Add any additional logic for findByTglmulaiaktif before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByTglmulaiaktif(tglmulaiaktif));

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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByTglakhirberlaku(String tglakhirberlaku)
	// % protected region % [Add any throwables, implementations, or extensions for findByTglakhirberlaku here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTglakhirberlaku here] end
	{
		// % protected region % [Add any additional logic for findByTglakhirberlaku before the main body here] off begin
		// % protected region % [Add any additional logic for findByTglakhirberlaku before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByTglakhirberlaku(tglakhirberlaku));

		// % protected region % [Add any additional logic for findByTglakhirberlaku before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTglakhirberlaku before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdProvider.
	 *
	 * @param kdprovider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdProvider
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByKdprovider(String kdprovider)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdprovider here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdprovider here] end
	{
		// % protected region % [Add any additional logic for findByKdprovider before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdprovider before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByKdprovider(kdprovider));

		// % protected region % [Add any additional logic for findByKdprovider before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdprovider before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmProvider.
	 *
	 * @param nmprovider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmProvider
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByNmprovider(String nmprovider)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmprovider here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmprovider here] end
	{
		// % protected region % [Add any additional logic for findByNmprovider before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmprovider before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByNmprovider(nmprovider));

		// % protected region % [Add any additional logic for findByNmprovider before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmprovider before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdProviderGigi.
	 *
	 * @param kdprovidergigi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdProviderGigi
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByKdprovidergigi(String kdprovidergigi)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdprovidergigi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdprovidergigi here] end
	{
		// % protected region % [Add any additional logic for findByKdprovidergigi before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdprovidergigi before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByKdprovidergigi(kdprovidergigi));

		// % protected region % [Add any additional logic for findByKdprovidergigi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdprovidergigi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmProviderGigi.
	 *
	 * @param nmprovidergigi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmProviderGigi
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByNmprovidergigi(String nmprovidergigi)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmprovidergigi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmprovidergigi here] end
	{
		// % protected region % [Add any additional logic for findByNmprovidergigi before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmprovidergigi before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByNmprovidergigi(nmprovidergigi));

		// % protected region % [Add any additional logic for findByNmprovidergigi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmprovidergigi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute namaKelas.
	 *
	 * @param namakelas the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute namaKelas
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByNamakelas(String namakelas)
	// % protected region % [Add any throwables, implementations, or extensions for findByNamakelas here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNamakelas here] end
	{
		// % protected region % [Add any additional logic for findByNamakelas before the main body here] off begin
		// % protected region % [Add any additional logic for findByNamakelas before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByNamakelas(namakelas));

		// % protected region % [Add any additional logic for findByNamakelas before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNamakelas before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kodeKelas.
	 *
	 * @param kodekelas the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodeKelas
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByKodekelas(String kodekelas)
	// % protected region % [Add any throwables, implementations, or extensions for findByKodekelas here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKodekelas here] end
	{
		// % protected region % [Add any additional logic for findByKodekelas before the main body here] off begin
		// % protected region % [Add any additional logic for findByKodekelas before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByKodekelas(kodekelas));

		// % protected region % [Add any additional logic for findByKodekelas before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKodekelas before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute namaPeserta.
	 *
	 * @param namapeserta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute namaPeserta
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByNamapeserta(String namapeserta)
	// % protected region % [Add any throwables, implementations, or extensions for findByNamapeserta here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNamapeserta here] end
	{
		// % protected region % [Add any additional logic for findByNamapeserta before the main body here] off begin
		// % protected region % [Add any additional logic for findByNamapeserta before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByNamapeserta(namapeserta));

		// % protected region % [Add any additional logic for findByNamapeserta before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNamapeserta before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kodePeserta.
	 *
	 * @param kodepeserta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodePeserta
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByKodepeserta(String kodepeserta)
	// % protected region % [Add any throwables, implementations, or extensions for findByKodepeserta here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKodepeserta here] end
	{
		// % protected region % [Add any additional logic for findByKodepeserta before the main body here] off begin
		// % protected region % [Add any additional logic for findByKodepeserta before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByKodepeserta(kodepeserta));

		// % protected region % [Add any additional logic for findByKodepeserta before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKodepeserta before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute golDarah.
	 *
	 * @param goldarah the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute golDarah
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByGoldarah(String goldarah)
	// % protected region % [Add any throwables, implementations, or extensions for findByGoldarah here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGoldarah here] end
	{
		// % protected region % [Add any additional logic for findByGoldarah before the main body here] off begin
		// % protected region % [Add any additional logic for findByGoldarah before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByGoldarah(goldarah));

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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByNohp(String nohp)
	// % protected region % [Add any throwables, implementations, or extensions for findByNohp here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNohp here] end
	{
		// % protected region % [Add any additional logic for findByNohp before the main body here] off begin
		// % protected region % [Add any additional logic for findByNohp before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByNohp(nohp));

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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByNoktp(String noktp)
	// % protected region % [Add any throwables, implementations, or extensions for findByNoktp here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNoktp here] end
	{
		// % protected region % [Add any additional logic for findByNoktp before the main body here] off begin
		// % protected region % [Add any additional logic for findByNoktp before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByNoktp(noktp));

		// % protected region % [Add any additional logic for findByNoktp before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNoktp before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute pstProl.
	 *
	 * @param pstprol the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute pstProl
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByPstprol(String pstprol)
	// % protected region % [Add any throwables, implementations, or extensions for findByPstprol here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPstprol here] end
	{
		// % protected region % [Add any additional logic for findByPstprol before the main body here] off begin
		// % protected region % [Add any additional logic for findByPstprol before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByPstprol(pstprol));

		// % protected region % [Add any additional logic for findByPstprol before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPstprol before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute pstPrb.
	 *
	 * @param pstprb the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute pstPrb
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByPstprb(String pstprb)
	// % protected region % [Add any throwables, implementations, or extensions for findByPstprb here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPstprb here] end
	{
		// % protected region % [Add any additional logic for findByPstprb before the main body here] off begin
		// % protected region % [Add any additional logic for findByPstprb before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByPstprb(pstprb));

		// % protected region % [Add any additional logic for findByPstprb before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPstprb before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute ketAktif.
	 *
	 * @param ketaktif the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ketAktif
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByKetaktif(String ketaktif)
	// % protected region % [Add any throwables, implementations, or extensions for findByKetaktif here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKetaktif here] end
	{
		// % protected region % [Add any additional logic for findByKetaktif before the main body here] off begin
		// % protected region % [Add any additional logic for findByKetaktif before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByKetaktif(ketaktif));

		// % protected region % [Add any additional logic for findByKetaktif before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKetaktif before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdAsuransi.
	 *
	 * @param kdasuransi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdAsuransi
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByKdasuransi(String kdasuransi)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdasuransi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdasuransi here] end
	{
		// % protected region % [Add any additional logic for findByKdasuransi before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdasuransi before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByKdasuransi(kdasuransi));

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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByNmasuransi(String nmasuransi)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmasuransi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmasuransi here] end
	{
		// % protected region % [Add any additional logic for findByNmasuransi before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmasuransi before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByNmasuransi(nmasuransi));

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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByNoasuransi(String noasuransi)
	// % protected region % [Add any throwables, implementations, or extensions for findByNoasuransi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNoasuransi here] end
	{
		// % protected region % [Add any additional logic for findByNoasuransi before the main body here] off begin
		// % protected region % [Add any additional logic for findByNoasuransi before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByNoasuransi(noasuransi));

		// % protected region % [Add any additional logic for findByNoasuransi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNoasuransi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute cob.
	 *
	 * @param cob the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute cob
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByCob(String cob)
	// % protected region % [Add any throwables, implementations, or extensions for findByCob here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCob here] end
	{
		// % protected region % [Add any additional logic for findByCob before the main body here] off begin
		// % protected region % [Add any additional logic for findByCob before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByCob(cob));

		// % protected region % [Add any additional logic for findByCob before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCob before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tunggakan.
	 *
	 * @param tunggakan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tunggakan
	 */
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findByTunggakan(String tunggakan)
	// % protected region % [Add any throwables, implementations, or extensions for findByTunggakan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTunggakan here] end
	{
		// % protected region % [Add any additional logic for findByTunggakan before the main body here] off begin
		// % protected region % [Add any additional logic for findByTunggakan before the main body here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByTunggakan(tunggakan));

		// % protected region % [Add any additional logic for findByTunggakan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTunggakan before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsPcarePesertaKegiatanKelompokEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BpjsPcarePesertaKegiatanKelompokEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BpjsPcarePesertaKegiatanKelompokEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'create')")
	public BpjsPcarePesertaKegiatanKelompokEntity create(BpjsPcarePesertaKegiatanKelompokEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BpjsPcarePesertaKegiatanKelompokEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'create')")
	public BpjsPcarePesertaKegiatanKelompokEntity create(BpjsPcarePesertaKegiatanKelompokEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BpjsPcarePesertaKegiatanKelompokEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BpjsPcarePesertaKegiatanKelompokEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'create')")
	public List<BpjsPcarePesertaKegiatanKelompokEntity> createAll(Iterable<BpjsPcarePesertaKegiatanKelompokEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BpjsPcarePesertaKegiatanKelompokEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'update')")
	public BpjsPcarePesertaKegiatanKelompokEntity update(BpjsPcarePesertaKegiatanKelompokEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BpjsPcarePesertaKegiatanKelompokEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'update')")
	public BpjsPcarePesertaKegiatanKelompokEntity update(BpjsPcarePesertaKegiatanKelompokEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BpjsPcarePesertaKegiatanKelompokEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BpjsPcarePesertaKegiatanKelompokEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'update')")
	public List<BpjsPcarePesertaKegiatanKelompokEntity> updateAll(Iterable<BpjsPcarePesertaKegiatanKelompokEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BpjsPcarePesertaKegiatanKelompokEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'create') or hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'update')")
	public BpjsPcarePesertaKegiatanKelompokEntity save(BpjsPcarePesertaKegiatanKelompokEntity entity) throws ConstraintViolationException
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

		BpjsPcarePesertaKegiatanKelompokEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'create') or hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'update')")
	public List<BpjsPcarePesertaKegiatanKelompokEntity> saveAll(Iterable<BpjsPcarePesertaKegiatanKelompokEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BpjsPcarePesertaKegiatanKelompokEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	public List<BpjsPcarePesertaKegiatanKelompokEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BpjsPcarePesertaKegiatanKelompokEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BpjsPcarePesertaKegiatanKelompokEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsPcarePesertaKegiatanKelompokEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcarePesertaKegiatanKelompokEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsPcarePesertaKegiatanKelompokEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BpjsPcarePesertaKegiatanKelompokEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsPcarePesertaKegiatanKelompokEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BpjsPcarePesertaKegiatanKelompokEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BpjsPcarePesertaKegiatanKelompokEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BpjsPcarePesertaKegiatanKelompokEntityAudits
	 */
	private List<BpjsPcarePesertaKegiatanKelompokEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BpjsPcarePesertaKegiatanKelompokEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bpjsPcarePesertaKegiatanKelompok bpjsPcarePesertaKegiatanKelompok to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BpjsPcarePesertaKegiatanKelompokEntity updateAuditData(BpjsPcarePesertaKegiatanKelompokEntity bpjsPcarePesertaKegiatanKelompok)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bpjsPcarePesertaKegiatanKelompok;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BpjsPcarePesertaKegiatanKelompokEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BpjsPcarePesertaKegiatanKelompokEntity entityAtRevision = updateAuditData((BpjsPcarePesertaKegiatanKelompokEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BpjsPcarePesertaKegiatanKelompokEntityAudit(
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

		QBpjsPcarePesertaKegiatanKelompokEntity entity = QBpjsPcarePesertaKegiatanKelompokEntity.bpjsPcarePesertaKegiatanKelompokEntity;

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
			case "eduid":
				// % protected region % [Add any additional logic before the query parameters of eduid here] off begin
				// % protected region % [Add any additional logic before the query parameters of eduid here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.eduid, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of eduid here] off begin
				// % protected region % [Add any additional logic after the query parameters of eduid here] end

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
			case "tglmulaiaktif":
				// % protected region % [Add any additional logic before the query parameters of tglmulaiaktif here] off begin
				// % protected region % [Add any additional logic before the query parameters of tglmulaiaktif here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tglmulaiaktif, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tglmulaiaktif here] off begin
				// % protected region % [Add any additional logic after the query parameters of tglmulaiaktif here] end

				break;
			case "tglakhirberlaku":
				// % protected region % [Add any additional logic before the query parameters of tglakhirberlaku here] off begin
				// % protected region % [Add any additional logic before the query parameters of tglakhirberlaku here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tglakhirberlaku, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tglakhirberlaku here] off begin
				// % protected region % [Add any additional logic after the query parameters of tglakhirberlaku here] end

				break;
			case "kdprovider":
				// % protected region % [Add any additional logic before the query parameters of kdprovider here] off begin
				// % protected region % [Add any additional logic before the query parameters of kdprovider here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kdprovider, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kdprovider here] off begin
				// % protected region % [Add any additional logic after the query parameters of kdprovider here] end

				break;
			case "nmprovider":
				// % protected region % [Add any additional logic before the query parameters of nmprovider here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmprovider here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmprovider, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmprovider here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmprovider here] end

				break;
			case "kdprovidergigi":
				// % protected region % [Add any additional logic before the query parameters of kdprovidergigi here] off begin
				// % protected region % [Add any additional logic before the query parameters of kdprovidergigi here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kdprovidergigi, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kdprovidergigi here] off begin
				// % protected region % [Add any additional logic after the query parameters of kdprovidergigi here] end

				break;
			case "nmprovidergigi":
				// % protected region % [Add any additional logic before the query parameters of nmprovidergigi here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmprovidergigi here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmprovidergigi, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmprovidergigi here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmprovidergigi here] end

				break;
			case "namakelas":
				// % protected region % [Add any additional logic before the query parameters of namakelas here] off begin
				// % protected region % [Add any additional logic before the query parameters of namakelas here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.namakelas, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of namakelas here] off begin
				// % protected region % [Add any additional logic after the query parameters of namakelas here] end

				break;
			case "namapeserta":
				// % protected region % [Add any additional logic before the query parameters of namapeserta here] off begin
				// % protected region % [Add any additional logic before the query parameters of namapeserta here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.namapeserta, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of namapeserta here] off begin
				// % protected region % [Add any additional logic after the query parameters of namapeserta here] end

				break;
			case "kodepeserta":
				// % protected region % [Add any additional logic before the query parameters of kodepeserta here] off begin
				// % protected region % [Add any additional logic before the query parameters of kodepeserta here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kodepeserta, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kodepeserta here] off begin
				// % protected region % [Add any additional logic after the query parameters of kodepeserta here] end

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
			case "pstprol":
				// % protected region % [Add any additional logic before the query parameters of pstprol here] off begin
				// % protected region % [Add any additional logic before the query parameters of pstprol here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pstprol, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of pstprol here] off begin
				// % protected region % [Add any additional logic after the query parameters of pstprol here] end

				break;
			case "pstprb":
				// % protected region % [Add any additional logic before the query parameters of pstprb here] off begin
				// % protected region % [Add any additional logic before the query parameters of pstprb here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pstprb, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of pstprb here] off begin
				// % protected region % [Add any additional logic after the query parameters of pstprb here] end

				break;
			case "ketaktif":
				// % protected region % [Add any additional logic before the query parameters of ketaktif here] off begin
				// % protected region % [Add any additional logic before the query parameters of ketaktif here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.ketaktif, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of ketaktif here] off begin
				// % protected region % [Add any additional logic after the query parameters of ketaktif here] end

				break;
			case "kdasuransi":
				// % protected region % [Add any additional logic before the query parameters of kdasuransi here] off begin
				// % protected region % [Add any additional logic before the query parameters of kdasuransi here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kdasuransi, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kdasuransi here] off begin
				// % protected region % [Add any additional logic after the query parameters of kdasuransi here] end

				break;
			case "nmasuransi":
				// % protected region % [Add any additional logic before the query parameters of nmasuransi here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmasuransi here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmasuransi, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmasuransi here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmasuransi here] end

				break;
			case "noasuransi":
				// % protected region % [Add any additional logic before the query parameters of noasuransi here] off begin
				// % protected region % [Add any additional logic before the query parameters of noasuransi here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.noasuransi, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of noasuransi here] off begin
				// % protected region % [Add any additional logic after the query parameters of noasuransi here] end

				break;
			case "cob":
				// % protected region % [Add any additional logic before the query parameters of cob here] off begin
				// % protected region % [Add any additional logic before the query parameters of cob here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.cob, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of cob here] off begin
				// % protected region % [Add any additional logic after the query parameters of cob here] end

				break;
			case "tunggakan":
				// % protected region % [Add any additional logic before the query parameters of tunggakan here] off begin
				// % protected region % [Add any additional logic before the query parameters of tunggakan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tunggakan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tunggakan here] off begin
				// % protected region % [Add any additional logic after the query parameters of tunggakan here] end

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
	public BpjsPcarePesertaKegiatanKelompokEntity updateOldData(BpjsPcarePesertaKegiatanKelompokEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BpjsPcarePesertaKegiatanKelompokEntity updateOldData(BpjsPcarePesertaKegiatanKelompokEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BpjsPcarePesertaKegiatanKelompokEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBpjsPcarePesertaKegiatanKelompokEntity);

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
	public void validateEntity(BpjsPcarePesertaKegiatanKelompokEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BpjsPcarePesertaKegiatanKelompokEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the BpjsPcarePesertaKegiatanKelompokEntity.
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

	public Set<String> validateEntityRelations(BpjsPcarePesertaKegiatanKelompokEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
