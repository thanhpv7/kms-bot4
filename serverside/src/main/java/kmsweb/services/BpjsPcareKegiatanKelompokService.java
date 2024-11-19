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
import kmsweb.repositories.BpjsPcareKegiatanKelompokRepository;
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
public class BpjsPcareKegiatanKelompokService extends AbstractService<BpjsPcareKegiatanKelompokEntity, BpjsPcareKegiatanKelompokRepository, BpjsPcareKegiatanKelompokEntityAudit> {

	private final String[] referenceNamesInBpjsPcareKegiatanKelompokEntity = {
	};

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsPcareKegiatanKelompokService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		Validator validator,
		AuditingRepository auditingRepository,
		BpjsPcareKegiatanKelompokRepository repository
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
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
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
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute ketuaNama.
	 *
	 * @param ketuanama the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ketuaNama
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByKetuanama(String ketuanama)
	// % protected region % [Add any throwables, implementations, or extensions for findByKetuanama here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKetuanama here] end
	{
		// % protected region % [Add any additional logic for findByKetuanama before the main body here] off begin
		// % protected region % [Add any additional logic for findByKetuanama before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByKetuanama(ketuanama));

		// % protected region % [Add any additional logic for findByKetuanama before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKetuanama before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nama.
	 *
	 * @param nama the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nama
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByNama(String nama)
	// % protected region % [Add any throwables, implementations, or extensions for findByNama here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNama here] end
	{
		// % protected region % [Add any additional logic for findByNama before the main body here] off begin
		// % protected region % [Add any additional logic for findByNama before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByNama(nama));

		// % protected region % [Add any additional logic for findByNama before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNama before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute eduId.
	 *
	 * @param eduid the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute eduId
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByEduid(String eduid)
	// % protected region % [Add any throwables, implementations, or extensions for findByEduid here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEduid here] end
	{
		// % protected region % [Add any additional logic for findByEduid before the main body here] off begin
		// % protected region % [Add any additional logic for findByEduid before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByEduid(eduid));

		// % protected region % [Add any additional logic for findByEduid before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEduid before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute clubId.
	 *
	 * @param clubid the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute clubId
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByClubid(String clubid)
	// % protected region % [Add any throwables, implementations, or extensions for findByClubid here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByClubid here] end
	{
		// % protected region % [Add any additional logic for findByClubid before the main body here] off begin
		// % protected region % [Add any additional logic for findByClubid before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByClubid(clubid));

		// % protected region % [Add any additional logic for findByClubid before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByClubid before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdProgram.
	 *
	 * @param kdprogram the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdProgram
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByKdprogram(String kdprogram)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdprogram here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdprogram here] end
	{
		// % protected region % [Add any additional logic for findByKdprogram before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdprogram before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByKdprogram(kdprogram));

		// % protected region % [Add any additional logic for findByKdprogram before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdprogram before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmProgram.
	 *
	 * @param nmprogram the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmProgram
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByNmprogram(String nmprogram)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmprogram here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmprogram here] end
	{
		// % protected region % [Add any additional logic for findByNmprogram before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmprogram before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByNmprogram(nmprogram));

		// % protected region % [Add any additional logic for findByNmprogram before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmprogram before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tglMulai.
	 *
	 * @param tglmulai the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglMulai
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByTglmulai(String tglmulai)
	// % protected region % [Add any throwables, implementations, or extensions for findByTglmulai here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTglmulai here] end
	{
		// % protected region % [Add any additional logic for findByTglmulai before the main body here] off begin
		// % protected region % [Add any additional logic for findByTglmulai before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByTglmulai(tglmulai));

		// % protected region % [Add any additional logic for findByTglmulai before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTglmulai before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tglAkhir.
	 *
	 * @param tglakhir the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglAkhir
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByTglakhir(String tglakhir)
	// % protected region % [Add any throwables, implementations, or extensions for findByTglakhir here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTglakhir here] end
	{
		// % protected region % [Add any additional logic for findByTglakhir before the main body here] off begin
		// % protected region % [Add any additional logic for findByTglakhir before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByTglakhir(tglakhir));

		// % protected region % [Add any additional logic for findByTglakhir before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTglakhir before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute alamat.
	 *
	 * @param alamat the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute alamat
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByAlamat(String alamat)
	// % protected region % [Add any throwables, implementations, or extensions for findByAlamat here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAlamat here] end
	{
		// % protected region % [Add any additional logic for findByAlamat before the main body here] off begin
		// % protected region % [Add any additional logic for findByAlamat before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByAlamat(alamat));

		// % protected region % [Add any additional logic for findByAlamat before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAlamat before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute ketuaNoHp.
	 *
	 * @param ketuanohp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ketuaNoHp
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByKetuanohp(String ketuanohp)
	// % protected region % [Add any throwables, implementations, or extensions for findByKetuanohp here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKetuanohp here] end
	{
		// % protected region % [Add any additional logic for findByKetuanohp before the main body here] off begin
		// % protected region % [Add any additional logic for findByKetuanohp before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByKetuanohp(ketuanohp));

		// % protected region % [Add any additional logic for findByKetuanohp before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKetuanohp before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tglPelayanan.
	 *
	 * @param tglpelayanan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglPelayanan
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByTglpelayanan(String tglpelayanan)
	// % protected region % [Add any throwables, implementations, or extensions for findByTglpelayanan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTglpelayanan here] end
	{
		// % protected region % [Add any additional logic for findByTglpelayanan before the main body here] off begin
		// % protected region % [Add any additional logic for findByTglpelayanan before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByTglpelayanan(tglpelayanan));

		// % protected region % [Add any additional logic for findByTglpelayanan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTglpelayanan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kegiatanNama.
	 *
	 * @param kegiatannama the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kegiatanNama
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByKegiatannama(String kegiatannama)
	// % protected region % [Add any throwables, implementations, or extensions for findByKegiatannama here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKegiatannama here] end
	{
		// % protected region % [Add any additional logic for findByKegiatannama before the main body here] off begin
		// % protected region % [Add any additional logic for findByKegiatannama before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByKegiatannama(kegiatannama));

		// % protected region % [Add any additional logic for findByKegiatannama before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKegiatannama before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kegiatanKode.
	 *
	 * @param kegiatankode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kegiatanKode
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByKegiatankode(String kegiatankode)
	// % protected region % [Add any throwables, implementations, or extensions for findByKegiatankode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKegiatankode here] end
	{
		// % protected region % [Add any additional logic for findByKegiatankode before the main body here] off begin
		// % protected region % [Add any additional logic for findByKegiatankode before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByKegiatankode(kegiatankode));

		// % protected region % [Add any additional logic for findByKegiatankode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKegiatankode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kelompokNama.
	 *
	 * @param kelompoknama the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kelompokNama
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByKelompoknama(String kelompoknama)
	// % protected region % [Add any throwables, implementations, or extensions for findByKelompoknama here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKelompoknama here] end
	{
		// % protected region % [Add any additional logic for findByKelompoknama before the main body here] off begin
		// % protected region % [Add any additional logic for findByKelompoknama before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByKelompoknama(kelompoknama));

		// % protected region % [Add any additional logic for findByKelompoknama before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKelompoknama before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kelompokKode.
	 *
	 * @param kelompokkode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kelompokKode
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByKelompokkode(String kelompokkode)
	// % protected region % [Add any throwables, implementations, or extensions for findByKelompokkode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKelompokkode here] end
	{
		// % protected region % [Add any additional logic for findByKelompokkode before the main body here] off begin
		// % protected region % [Add any additional logic for findByKelompokkode before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByKelompokkode(kelompokkode));

		// % protected region % [Add any additional logic for findByKelompokkode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKelompokkode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute materi.
	 *
	 * @param materi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute materi
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByMateri(String materi)
	// % protected region % [Add any throwables, implementations, or extensions for findByMateri here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMateri here] end
	{
		// % protected region % [Add any additional logic for findByMateri before the main body here] off begin
		// % protected region % [Add any additional logic for findByMateri before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByMateri(materi));

		// % protected region % [Add any additional logic for findByMateri before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMateri before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute pembicara.
	 *
	 * @param pembicara the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute pembicara
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByPembicara(String pembicara)
	// % protected region % [Add any throwables, implementations, or extensions for findByPembicara here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPembicara here] end
	{
		// % protected region % [Add any additional logic for findByPembicara before the main body here] off begin
		// % protected region % [Add any additional logic for findByPembicara before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByPembicara(pembicara));

		// % protected region % [Add any additional logic for findByPembicara before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPembicara before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute lokasi.
	 *
	 * @param lokasi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute lokasi
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByLokasi(String lokasi)
	// % protected region % [Add any throwables, implementations, or extensions for findByLokasi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLokasi here] end
	{
		// % protected region % [Add any additional logic for findByLokasi before the main body here] off begin
		// % protected region % [Add any additional logic for findByLokasi before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByLokasi(lokasi));

		// % protected region % [Add any additional logic for findByLokasi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLokasi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute keterangan.
	 *
	 * @param keterangan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute keterangan
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByKeterangan(String keterangan)
	// % protected region % [Add any throwables, implementations, or extensions for findByKeterangan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKeterangan here] end
	{
		// % protected region % [Add any additional logic for findByKeterangan before the main body here] off begin
		// % protected region % [Add any additional logic for findByKeterangan before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByKeterangan(keterangan));

		// % protected region % [Add any additional logic for findByKeterangan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKeterangan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute biaya.
	 *
	 * @param biaya the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute biaya
	 */
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findByBiaya(String biaya)
	// % protected region % [Add any throwables, implementations, or extensions for findByBiaya here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBiaya here] end
	{
		// % protected region % [Add any additional logic for findByBiaya before the main body here] off begin
		// % protected region % [Add any additional logic for findByBiaya before the main body here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findByBiaya(biaya));

		// % protected region % [Add any additional logic for findByBiaya before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBiaya before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsPcareKegiatanKelompokEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BpjsPcareKegiatanKelompokEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BpjsPcareKegiatanKelompokEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'create')")
	public BpjsPcareKegiatanKelompokEntity create(BpjsPcareKegiatanKelompokEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BpjsPcareKegiatanKelompokEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'create')")
	public BpjsPcareKegiatanKelompokEntity create(BpjsPcareKegiatanKelompokEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BpjsPcareKegiatanKelompokEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BpjsPcareKegiatanKelompokEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'create')")
	public List<BpjsPcareKegiatanKelompokEntity> createAll(Iterable<BpjsPcareKegiatanKelompokEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BpjsPcareKegiatanKelompokEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BpjsPcareKegiatanKelompokEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'update')")
	public BpjsPcareKegiatanKelompokEntity update(BpjsPcareKegiatanKelompokEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BpjsPcareKegiatanKelompokEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'update')")
	public BpjsPcareKegiatanKelompokEntity update(BpjsPcareKegiatanKelompokEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BpjsPcareKegiatanKelompokEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BpjsPcareKegiatanKelompokEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'update')")
	public List<BpjsPcareKegiatanKelompokEntity> updateAll(Iterable<BpjsPcareKegiatanKelompokEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BpjsPcareKegiatanKelompokEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BpjsPcareKegiatanKelompokEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'create') or hasPermission('BpjsPcareKegiatanKelompokEntity', 'update')")
	public BpjsPcareKegiatanKelompokEntity save(BpjsPcareKegiatanKelompokEntity entity) throws ConstraintViolationException
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

		BpjsPcareKegiatanKelompokEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'create') or hasPermission('BpjsPcareKegiatanKelompokEntity', 'update')")
	public List<BpjsPcareKegiatanKelompokEntity> saveAll(Iterable<BpjsPcareKegiatanKelompokEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BpjsPcareKegiatanKelompokEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	public List<BpjsPcareKegiatanKelompokEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	public List<BpjsPcareKegiatanKelompokEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BpjsPcareKegiatanKelompokEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BpjsPcareKegiatanKelompokEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsPcareKegiatanKelompokEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKegiatanKelompokEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsPcareKegiatanKelompokEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BpjsPcareKegiatanKelompokEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsPcareKegiatanKelompokEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BpjsPcareKegiatanKelompokEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BpjsPcareKegiatanKelompokEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BpjsPcareKegiatanKelompokEntityAudits
	 */
	private List<BpjsPcareKegiatanKelompokEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BpjsPcareKegiatanKelompokEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bpjsPcareKegiatanKelompok bpjsPcareKegiatanKelompok to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BpjsPcareKegiatanKelompokEntity updateAuditData(BpjsPcareKegiatanKelompokEntity bpjsPcareKegiatanKelompok)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bpjsPcareKegiatanKelompok;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BpjsPcareKegiatanKelompokEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BpjsPcareKegiatanKelompokEntity entityAtRevision = updateAuditData((BpjsPcareKegiatanKelompokEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BpjsPcareKegiatanKelompokEntityAudit(
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

		QBpjsPcareKegiatanKelompokEntity entity = QBpjsPcareKegiatanKelompokEntity.bpjsPcareKegiatanKelompokEntity;

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
			case "ketuanama":
				// % protected region % [Add any additional logic before the query parameters of ketuanama here] off begin
				// % protected region % [Add any additional logic before the query parameters of ketuanama here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.ketuanama, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of ketuanama here] off begin
				// % protected region % [Add any additional logic after the query parameters of ketuanama here] end

				break;
			case "nama":
				// % protected region % [Add any additional logic before the query parameters of nama here] off begin
				// % protected region % [Add any additional logic before the query parameters of nama here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nama, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nama here] off begin
				// % protected region % [Add any additional logic after the query parameters of nama here] end

				break;
			case "eduid":
				// % protected region % [Add any additional logic before the query parameters of eduid here] off begin
				// % protected region % [Add any additional logic before the query parameters of eduid here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.eduid, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of eduid here] off begin
				// % protected region % [Add any additional logic after the query parameters of eduid here] end

				break;
			case "clubid":
				// % protected region % [Add any additional logic before the query parameters of clubid here] off begin
				// % protected region % [Add any additional logic before the query parameters of clubid here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.clubid, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of clubid here] off begin
				// % protected region % [Add any additional logic after the query parameters of clubid here] end

				break;
			case "kdprogram":
				// % protected region % [Add any additional logic before the query parameters of kdprogram here] off begin
				// % protected region % [Add any additional logic before the query parameters of kdprogram here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kdprogram, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kdprogram here] off begin
				// % protected region % [Add any additional logic after the query parameters of kdprogram here] end

				break;
			case "nmprogram":
				// % protected region % [Add any additional logic before the query parameters of nmprogram here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmprogram here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmprogram, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmprogram here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmprogram here] end

				break;
			case "tglmulai":
				// % protected region % [Add any additional logic before the query parameters of tglmulai here] off begin
				// % protected region % [Add any additional logic before the query parameters of tglmulai here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tglmulai, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tglmulai here] off begin
				// % protected region % [Add any additional logic after the query parameters of tglmulai here] end

				break;
			case "tglakhir":
				// % protected region % [Add any additional logic before the query parameters of tglakhir here] off begin
				// % protected region % [Add any additional logic before the query parameters of tglakhir here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tglakhir, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tglakhir here] off begin
				// % protected region % [Add any additional logic after the query parameters of tglakhir here] end

				break;
			case "alamat":
				// % protected region % [Add any additional logic before the query parameters of alamat here] off begin
				// % protected region % [Add any additional logic before the query parameters of alamat here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.alamat, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of alamat here] off begin
				// % protected region % [Add any additional logic after the query parameters of alamat here] end

				break;
			case "ketuanohp":
				// % protected region % [Add any additional logic before the query parameters of ketuanohp here] off begin
				// % protected region % [Add any additional logic before the query parameters of ketuanohp here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.ketuanohp, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of ketuanohp here] off begin
				// % protected region % [Add any additional logic after the query parameters of ketuanohp here] end

				break;
			case "tglpelayanan":
				// % protected region % [Add any additional logic before the query parameters of tglpelayanan here] off begin
				// % protected region % [Add any additional logic before the query parameters of tglpelayanan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tglpelayanan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tglpelayanan here] off begin
				// % protected region % [Add any additional logic after the query parameters of tglpelayanan here] end

				break;
			case "kegiatankode":
				// % protected region % [Add any additional logic before the query parameters of kegiatankode here] off begin
				// % protected region % [Add any additional logic before the query parameters of kegiatankode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kegiatankode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kegiatankode here] off begin
				// % protected region % [Add any additional logic after the query parameters of kegiatankode here] end

				break;
			case "pembicara":
				// % protected region % [Add any additional logic before the query parameters of pembicara here] off begin
				// % protected region % [Add any additional logic before the query parameters of pembicara here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pembicara, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of pembicara here] off begin
				// % protected region % [Add any additional logic after the query parameters of pembicara here] end

				break;
			case "lokasi":
				// % protected region % [Add any additional logic before the query parameters of lokasi here] off begin
				// % protected region % [Add any additional logic before the query parameters of lokasi here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.lokasi, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of lokasi here] off begin
				// % protected region % [Add any additional logic after the query parameters of lokasi here] end

				break;
			case "keterangan":
				// % protected region % [Add any additional logic before the query parameters of keterangan here] off begin
				// % protected region % [Add any additional logic before the query parameters of keterangan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.keterangan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of keterangan here] off begin
				// % protected region % [Add any additional logic after the query parameters of keterangan here] end

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
	public BpjsPcareKegiatanKelompokEntity updateOldData(BpjsPcareKegiatanKelompokEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BpjsPcareKegiatanKelompokEntity updateOldData(BpjsPcareKegiatanKelompokEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BpjsPcareKegiatanKelompokEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBpjsPcareKegiatanKelompokEntity);

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
	public void validateEntity(BpjsPcareKegiatanKelompokEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BpjsPcareKegiatanKelompokEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the BpjsPcareKegiatanKelompokEntity.
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

	public Set<String> validateEntityRelations(BpjsPcareKegiatanKelompokEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
