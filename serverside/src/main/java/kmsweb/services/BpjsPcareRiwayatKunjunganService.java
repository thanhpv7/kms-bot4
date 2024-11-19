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
import kmsweb.repositories.BpjsPcareRiwayatKunjunganRepository;
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
public class BpjsPcareRiwayatKunjunganService extends AbstractService<BpjsPcareRiwayatKunjunganEntity, BpjsPcareRiwayatKunjunganRepository, BpjsPcareRiwayatKunjunganEntityAudit> {

	private final String[] referenceNamesInBpjsPcareRiwayatKunjunganEntity = {
	};

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsPcareRiwayatKunjunganService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		Validator validator,
		AuditingRepository auditingRepository,
		BpjsPcareRiwayatKunjunganRepository repository
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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute noKunjungan.
	 *
	 * @param nokunjungan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noKunjungan
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByNokunjungan(String nokunjungan)
	// % protected region % [Add any throwables, implementations, or extensions for findByNokunjungan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNokunjungan here] end
	{
		// % protected region % [Add any additional logic for findByNokunjungan before the main body here] off begin
		// % protected region % [Add any additional logic for findByNokunjungan before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByNokunjungan(nokunjungan));

		// % protected region % [Add any additional logic for findByNokunjungan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNokunjungan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tglkunjungan.
	 *
	 * @param tglkunjungan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglkunjungan
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByTglkunjungan(String tglkunjungan)
	// % protected region % [Add any throwables, implementations, or extensions for findByTglkunjungan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTglkunjungan here] end
	{
		// % protected region % [Add any additional logic for findByTglkunjungan before the main body here] off begin
		// % protected region % [Add any additional logic for findByTglkunjungan before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByTglkunjungan(tglkunjungan));

		// % protected region % [Add any additional logic for findByTglkunjungan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTglkunjungan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute providerPelayanan.
	 *
	 * @param providerpelayanan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute providerPelayanan
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByProviderpelayanan(String providerpelayanan)
	// % protected region % [Add any throwables, implementations, or extensions for findByProviderpelayanan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByProviderpelayanan here] end
	{
		// % protected region % [Add any additional logic for findByProviderpelayanan before the main body here] off begin
		// % protected region % [Add any additional logic for findByProviderpelayanan before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByProviderpelayanan(providerpelayanan));

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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByNokartu(String nokartu)
	// % protected region % [Add any throwables, implementations, or extensions for findByNokartu here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNokartu here] end
	{
		// % protected region % [Add any additional logic for findByNokartu before the main body here] off begin
		// % protected region % [Add any additional logic for findByNokartu before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByNokartu(nokartu));

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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByNama(String nama)
	// % protected region % [Add any throwables, implementations, or extensions for findByNama here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNama here] end
	{
		// % protected region % [Add any additional logic for findByNama before the main body here] off begin
		// % protected region % [Add any additional logic for findByNama before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByNama(nama));

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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByHubungankeluarga(String hubungankeluarga)
	// % protected region % [Add any throwables, implementations, or extensions for findByHubungankeluarga here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHubungankeluarga here] end
	{
		// % protected region % [Add any additional logic for findByHubungankeluarga before the main body here] off begin
		// % protected region % [Add any additional logic for findByHubungankeluarga before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByHubungankeluarga(hubungankeluarga));

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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findBySex(String sex)
	// % protected region % [Add any throwables, implementations, or extensions for findBySex here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySex here] end
	{
		// % protected region % [Add any additional logic for findBySex before the main body here] off begin
		// % protected region % [Add any additional logic for findBySex before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findBySex(sex));

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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByTgllahir(String tgllahir)
	// % protected region % [Add any throwables, implementations, or extensions for findByTgllahir here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTgllahir here] end
	{
		// % protected region % [Add any additional logic for findByTgllahir before the main body here] off begin
		// % protected region % [Add any additional logic for findByTgllahir before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByTgllahir(tgllahir));

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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByTglmulaiaktif(String tglmulaiaktif)
	// % protected region % [Add any throwables, implementations, or extensions for findByTglmulaiaktif here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTglmulaiaktif here] end
	{
		// % protected region % [Add any additional logic for findByTglmulaiaktif before the main body here] off begin
		// % protected region % [Add any additional logic for findByTglmulaiaktif before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByTglmulaiaktif(tglmulaiaktif));

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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByTglakhirberlaku(String tglakhirberlaku)
	// % protected region % [Add any throwables, implementations, or extensions for findByTglakhirberlaku here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTglakhirberlaku here] end
	{
		// % protected region % [Add any additional logic for findByTglakhirberlaku before the main body here] off begin
		// % protected region % [Add any additional logic for findByTglakhirberlaku before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByTglakhirberlaku(tglakhirberlaku));

		// % protected region % [Add any additional logic for findByTglakhirberlaku before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTglakhirberlaku before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kodePPKPeserta.
	 *
	 * @param kodeppkpeserta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodePPKPeserta
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByKodeppkpeserta(String kodeppkpeserta)
	// % protected region % [Add any throwables, implementations, or extensions for findByKodeppkpeserta here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKodeppkpeserta here] end
	{
		// % protected region % [Add any additional logic for findByKodeppkpeserta before the main body here] off begin
		// % protected region % [Add any additional logic for findByKodeppkpeserta before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByKodeppkpeserta(kodeppkpeserta));

		// % protected region % [Add any additional logic for findByKodeppkpeserta before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKodeppkpeserta before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kodePPKGigi.
	 *
	 * @param kodeppkgigi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodePPKGigi
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByKodeppkgigi(String kodeppkgigi)
	// % protected region % [Add any throwables, implementations, or extensions for findByKodeppkgigi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKodeppkgigi here] end
	{
		// % protected region % [Add any additional logic for findByKodeppkgigi before the main body here] off begin
		// % protected region % [Add any additional logic for findByKodeppkgigi before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByKodeppkgigi(kodeppkgigi));

		// % protected region % [Add any additional logic for findByKodeppkgigi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKodeppkgigi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute jenisKelas.
	 *
	 * @param jeniskelas the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute jenisKelas
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByJeniskelas(String jeniskelas)
	// % protected region % [Add any throwables, implementations, or extensions for findByJeniskelas here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByJeniskelas here] end
	{
		// % protected region % [Add any additional logic for findByJeniskelas before the main body here] off begin
		// % protected region % [Add any additional logic for findByJeniskelas before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByJeniskelas(jeniskelas));

		// % protected region % [Add any additional logic for findByJeniskelas before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByJeniskelas before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute jenisPeserta.
	 *
	 * @param jenispeserta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute jenisPeserta
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByJenispeserta(String jenispeserta)
	// % protected region % [Add any throwables, implementations, or extensions for findByJenispeserta here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByJenispeserta here] end
	{
		// % protected region % [Add any additional logic for findByJenispeserta before the main body here] off begin
		// % protected region % [Add any additional logic for findByJenispeserta before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByJenispeserta(jenispeserta));

		// % protected region % [Add any additional logic for findByJenispeserta before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByJenispeserta before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute golDarah.
	 *
	 * @param goldarah the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute golDarah
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByGoldarah(String goldarah)
	// % protected region % [Add any throwables, implementations, or extensions for findByGoldarah here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGoldarah here] end
	{
		// % protected region % [Add any additional logic for findByGoldarah before the main body here] off begin
		// % protected region % [Add any additional logic for findByGoldarah before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByGoldarah(goldarah));

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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByNohp(String nohp)
	// % protected region % [Add any throwables, implementations, or extensions for findByNohp here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNohp here] end
	{
		// % protected region % [Add any additional logic for findByNohp before the main body here] off begin
		// % protected region % [Add any additional logic for findByNohp before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByNohp(nohp));

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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByNoktp(String noktp)
	// % protected region % [Add any throwables, implementations, or extensions for findByNoktp here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNoktp here] end
	{
		// % protected region % [Add any additional logic for findByNoktp before the main body here] off begin
		// % protected region % [Add any additional logic for findByNoktp before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByNoktp(noktp));

		// % protected region % [Add any additional logic for findByNoktp before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNoktp before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute asuransi.
	 *
	 * @param asuransi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute asuransi
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByAsuransi(String asuransi)
	// % protected region % [Add any throwables, implementations, or extensions for findByAsuransi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAsuransi here] end
	{
		// % protected region % [Add any additional logic for findByAsuransi before the main body here] off begin
		// % protected region % [Add any additional logic for findByAsuransi before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByAsuransi(asuransi));

		// % protected region % [Add any additional logic for findByAsuransi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAsuransi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute poli.
	 *
	 * @param poli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute poli
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByPoli(String poli)
	// % protected region % [Add any throwables, implementations, or extensions for findByPoli here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPoli here] end
	{
		// % protected region % [Add any additional logic for findByPoli before the main body here] off begin
		// % protected region % [Add any additional logic for findByPoli before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByPoli(poli));

		// % protected region % [Add any additional logic for findByPoli before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPoli before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute jenisKunjungan.
	 *
	 * @param jeniskunjungan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute jenisKunjungan
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByJeniskunjungan(String jeniskunjungan)
	// % protected region % [Add any throwables, implementations, or extensions for findByJeniskunjungan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByJeniskunjungan here] end
	{
		// % protected region % [Add any additional logic for findByJeniskunjungan before the main body here] off begin
		// % protected region % [Add any additional logic for findByJeniskunjungan before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByJeniskunjungan(jeniskunjungan));

		// % protected region % [Add any additional logic for findByJeniskunjungan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByJeniskunjungan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute progProlanis.
	 *
	 * @param progprolanis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute progProlanis
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByProgprolanis(String progprolanis)
	// % protected region % [Add any throwables, implementations, or extensions for findByProgprolanis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByProgprolanis here] end
	{
		// % protected region % [Add any additional logic for findByProgprolanis before the main body here] off begin
		// % protected region % [Add any additional logic for findByProgprolanis before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByProgprolanis(progprolanis));

		// % protected region % [Add any additional logic for findByProgprolanis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByProgprolanis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute keluhan.
	 *
	 * @param keluhan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute keluhan
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByKeluhan(String keluhan)
	// % protected region % [Add any throwables, implementations, or extensions for findByKeluhan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKeluhan here] end
	{
		// % protected region % [Add any additional logic for findByKeluhan before the main body here] off begin
		// % protected region % [Add any additional logic for findByKeluhan before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByKeluhan(keluhan));

		// % protected region % [Add any additional logic for findByKeluhan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKeluhan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute diagnosa.
	 *
	 * @param diagnosa the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute diagnosa
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByDiagnosa(String diagnosa)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnosa here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnosa here] end
	{
		// % protected region % [Add any additional logic for findByDiagnosa before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiagnosa before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByDiagnosa(diagnosa));

		// % protected region % [Add any additional logic for findByDiagnosa before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiagnosa before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute diagnosa2.
	 *
	 * @param diagnosa2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute diagnosa2
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByDiagnosa2(String diagnosa2)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnosa2 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnosa2 here] end
	{
		// % protected region % [Add any additional logic for findByDiagnosa2 before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiagnosa2 before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByDiagnosa2(diagnosa2));

		// % protected region % [Add any additional logic for findByDiagnosa2 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiagnosa2 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute diagnosa3.
	 *
	 * @param diagnosa3 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute diagnosa3
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByDiagnosa3(String diagnosa3)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnosa3 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnosa3 here] end
	{
		// % protected region % [Add any additional logic for findByDiagnosa3 before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiagnosa3 before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByDiagnosa3(diagnosa3));

		// % protected region % [Add any additional logic for findByDiagnosa3 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiagnosa3 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kesadaran.
	 *
	 * @param kesadaran the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kesadaran
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByKesadaran(String kesadaran)
	// % protected region % [Add any throwables, implementations, or extensions for findByKesadaran here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKesadaran here] end
	{
		// % protected region % [Add any additional logic for findByKesadaran before the main body here] off begin
		// % protected region % [Add any additional logic for findByKesadaran before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByKesadaran(kesadaran));

		// % protected region % [Add any additional logic for findByKesadaran before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKesadaran before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute sistole.
	 *
	 * @param sistole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute sistole
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findBySistole(String sistole)
	// % protected region % [Add any throwables, implementations, or extensions for findBySistole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySistole here] end
	{
		// % protected region % [Add any additional logic for findBySistole before the main body here] off begin
		// % protected region % [Add any additional logic for findBySistole before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findBySistole(sistole));

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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByDiastole(String diastole)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastole here] end
	{
		// % protected region % [Add any additional logic for findByDiastole before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiastole before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByDiastole(diastole));

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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByBeratbadan(String beratbadan)
	// % protected region % [Add any throwables, implementations, or extensions for findByBeratbadan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBeratbadan here] end
	{
		// % protected region % [Add any additional logic for findByBeratbadan before the main body here] off begin
		// % protected region % [Add any additional logic for findByBeratbadan before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByBeratbadan(beratbadan));

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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByTinggibadan(String tinggibadan)
	// % protected region % [Add any throwables, implementations, or extensions for findByTinggibadan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTinggibadan here] end
	{
		// % protected region % [Add any additional logic for findByTinggibadan before the main body here] off begin
		// % protected region % [Add any additional logic for findByTinggibadan before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByTinggibadan(tinggibadan));

		// % protected region % [Add any additional logic for findByTinggibadan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTinggibadan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute respiratoryRate.
	 *
	 * @param respiratoryrate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute respiratoryRate
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByRespiratoryrate(String respiratoryrate)
	// % protected region % [Add any throwables, implementations, or extensions for findByRespiratoryrate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRespiratoryrate here] end
	{
		// % protected region % [Add any additional logic for findByRespiratoryrate before the main body here] off begin
		// % protected region % [Add any additional logic for findByRespiratoryrate before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByRespiratoryrate(respiratoryrate));

		// % protected region % [Add any additional logic for findByRespiratoryrate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRespiratoryrate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute heartRate.
	 *
	 * @param heartrate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute heartRate
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByHeartrate(String heartrate)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeartrate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeartrate here] end
	{
		// % protected region % [Add any additional logic for findByHeartrate before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeartrate before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByHeartrate(heartrate));

		// % protected region % [Add any additional logic for findByHeartrate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHeartrate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute catatan.
	 *
	 * @param catatan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute catatan
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByCatatan(String catatan)
	// % protected region % [Add any throwables, implementations, or extensions for findByCatatan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCatatan here] end
	{
		// % protected region % [Add any additional logic for findByCatatan before the main body here] off begin
		// % protected region % [Add any additional logic for findByCatatan before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByCatatan(catatan));

		// % protected region % [Add any additional logic for findByCatatan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCatatan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute pemeriksaanFisikLain.
	 *
	 * @param pemeriksaanfisiklain the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute pemeriksaanFisikLain
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByPemeriksaanfisiklain(String pemeriksaanfisiklain)
	// % protected region % [Add any throwables, implementations, or extensions for findByPemeriksaanfisiklain here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPemeriksaanfisiklain here] end
	{
		// % protected region % [Add any additional logic for findByPemeriksaanfisiklain before the main body here] off begin
		// % protected region % [Add any additional logic for findByPemeriksaanfisiklain before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByPemeriksaanfisiklain(pemeriksaanfisiklain));

		// % protected region % [Add any additional logic for findByPemeriksaanfisiklain before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPemeriksaanfisiklain before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tglPulang.
	 *
	 * @param tglpulang the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglPulang
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByTglpulang(String tglpulang)
	// % protected region % [Add any throwables, implementations, or extensions for findByTglpulang here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTglpulang here] end
	{
		// % protected region % [Add any additional logic for findByTglpulang before the main body here] off begin
		// % protected region % [Add any additional logic for findByTglpulang before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByTglpulang(tglpulang));

		// % protected region % [Add any additional logic for findByTglpulang before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTglpulang before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute dokter.
	 *
	 * @param dokter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute dokter
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByDokter(String dokter)
	// % protected region % [Add any throwables, implementations, or extensions for findByDokter here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDokter here] end
	{
		// % protected region % [Add any additional logic for findByDokter before the main body here] off begin
		// % protected region % [Add any additional logic for findByDokter before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByDokter(dokter));

		// % protected region % [Add any additional logic for findByDokter before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDokter before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute statusPulang.
	 *
	 * @param statuspulang the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute statusPulang
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByStatuspulang(String statuspulang)
	// % protected region % [Add any throwables, implementations, or extensions for findByStatuspulang here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStatuspulang here] end
	{
		// % protected region % [Add any additional logic for findByStatuspulang before the main body here] off begin
		// % protected region % [Add any additional logic for findByStatuspulang before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByStatuspulang(statuspulang));

		// % protected region % [Add any additional logic for findByStatuspulang before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStatuspulang before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tingkatPelayanan.
	 *
	 * @param tingkatpelayanan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tingkatPelayanan
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByTingkatpelayanan(String tingkatpelayanan)
	// % protected region % [Add any throwables, implementations, or extensions for findByTingkatpelayanan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTingkatpelayanan here] end
	{
		// % protected region % [Add any additional logic for findByTingkatpelayanan before the main body here] off begin
		// % protected region % [Add any additional logic for findByTingkatpelayanan before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByTingkatpelayanan(tingkatpelayanan));

		// % protected region % [Add any additional logic for findByTingkatpelayanan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTingkatpelayanan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute rujukBalik.
	 *
	 * @param rujukbalik the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute rujukBalik
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByRujukbalik(String rujukbalik)
	// % protected region % [Add any throwables, implementations, or extensions for findByRujukbalik here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRujukbalik here] end
	{
		// % protected region % [Add any additional logic for findByRujukbalik before the main body here] off begin
		// % protected region % [Add any additional logic for findByRujukbalik before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByRujukbalik(rujukbalik));

		// % protected region % [Add any additional logic for findByRujukbalik before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRujukbalik before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute providerAsalRujuk.
	 *
	 * @param providerasalrujuk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute providerAsalRujuk
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByProviderasalrujuk(String providerasalrujuk)
	// % protected region % [Add any throwables, implementations, or extensions for findByProviderasalrujuk here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByProviderasalrujuk here] end
	{
		// % protected region % [Add any additional logic for findByProviderasalrujuk before the main body here] off begin
		// % protected region % [Add any additional logic for findByProviderasalrujuk before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByProviderasalrujuk(providerasalrujuk));

		// % protected region % [Add any additional logic for findByProviderasalrujuk before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByProviderasalrujuk before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute providerRujukLanjut.
	 *
	 * @param providerrujuklanjut the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute providerRujukLanjut
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByProviderrujuklanjut(String providerrujuklanjut)
	// % protected region % [Add any throwables, implementations, or extensions for findByProviderrujuklanjut here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByProviderrujuklanjut here] end
	{
		// % protected region % [Add any additional logic for findByProviderrujuklanjut before the main body here] off begin
		// % protected region % [Add any additional logic for findByProviderrujuklanjut before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByProviderrujuklanjut(providerrujuklanjut));

		// % protected region % [Add any additional logic for findByProviderrujuklanjut before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByProviderrujuklanjut before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute poliRujukInternal.
	 *
	 * @param polirujukinternal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute poliRujukInternal
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByPolirujukinternal(String polirujukinternal)
	// % protected region % [Add any throwables, implementations, or extensions for findByPolirujukinternal here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPolirujukinternal here] end
	{
		// % protected region % [Add any additional logic for findByPolirujukinternal before the main body here] off begin
		// % protected region % [Add any additional logic for findByPolirujukinternal before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByPolirujukinternal(polirujukinternal));

		// % protected region % [Add any additional logic for findByPolirujukinternal before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPolirujukinternal before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute poliRujukLanjut.
	 *
	 * @param polirujuklanjut the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute poliRujukLanjut
	 */
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findByPolirujuklanjut(String polirujuklanjut)
	// % protected region % [Add any throwables, implementations, or extensions for findByPolirujuklanjut here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPolirujuklanjut here] end
	{
		// % protected region % [Add any additional logic for findByPolirujuklanjut before the main body here] off begin
		// % protected region % [Add any additional logic for findByPolirujuklanjut before the main body here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findByPolirujuklanjut(polirujuklanjut));

		// % protected region % [Add any additional logic for findByPolirujuklanjut before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPolirujuklanjut before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsPcareRiwayatKunjunganEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BpjsPcareRiwayatKunjunganEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BpjsPcareRiwayatKunjunganEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'create')")
	public BpjsPcareRiwayatKunjunganEntity create(BpjsPcareRiwayatKunjunganEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BpjsPcareRiwayatKunjunganEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'create')")
	public BpjsPcareRiwayatKunjunganEntity create(BpjsPcareRiwayatKunjunganEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BpjsPcareRiwayatKunjunganEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BpjsPcareRiwayatKunjunganEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'create')")
	public List<BpjsPcareRiwayatKunjunganEntity> createAll(Iterable<BpjsPcareRiwayatKunjunganEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BpjsPcareRiwayatKunjunganEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BpjsPcareRiwayatKunjunganEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'update')")
	public BpjsPcareRiwayatKunjunganEntity update(BpjsPcareRiwayatKunjunganEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BpjsPcareRiwayatKunjunganEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'update')")
	public BpjsPcareRiwayatKunjunganEntity update(BpjsPcareRiwayatKunjunganEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BpjsPcareRiwayatKunjunganEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BpjsPcareRiwayatKunjunganEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'update')")
	public List<BpjsPcareRiwayatKunjunganEntity> updateAll(Iterable<BpjsPcareRiwayatKunjunganEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BpjsPcareRiwayatKunjunganEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BpjsPcareRiwayatKunjunganEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'create') or hasPermission('BpjsPcareRiwayatKunjunganEntity', 'update')")
	public BpjsPcareRiwayatKunjunganEntity save(BpjsPcareRiwayatKunjunganEntity entity) throws ConstraintViolationException
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

		BpjsPcareRiwayatKunjunganEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'create') or hasPermission('BpjsPcareRiwayatKunjunganEntity', 'update')")
	public List<BpjsPcareRiwayatKunjunganEntity> saveAll(Iterable<BpjsPcareRiwayatKunjunganEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BpjsPcareRiwayatKunjunganEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	public List<BpjsPcareRiwayatKunjunganEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	public List<BpjsPcareRiwayatKunjunganEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BpjsPcareRiwayatKunjunganEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BpjsPcareRiwayatKunjunganEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsPcareRiwayatKunjunganEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareRiwayatKunjunganEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsPcareRiwayatKunjunganEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BpjsPcareRiwayatKunjunganEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsPcareRiwayatKunjunganEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BpjsPcareRiwayatKunjunganEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BpjsPcareRiwayatKunjunganEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BpjsPcareRiwayatKunjunganEntityAudits
	 */
	private List<BpjsPcareRiwayatKunjunganEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BpjsPcareRiwayatKunjunganEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bpjsPcareRiwayatKunjungan bpjsPcareRiwayatKunjungan to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BpjsPcareRiwayatKunjunganEntity updateAuditData(BpjsPcareRiwayatKunjunganEntity bpjsPcareRiwayatKunjungan)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bpjsPcareRiwayatKunjungan;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BpjsPcareRiwayatKunjunganEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BpjsPcareRiwayatKunjunganEntity entityAtRevision = updateAuditData((BpjsPcareRiwayatKunjunganEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BpjsPcareRiwayatKunjunganEntityAudit(
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

		QBpjsPcareRiwayatKunjunganEntity entity = QBpjsPcareRiwayatKunjunganEntity.bpjsPcareRiwayatKunjunganEntity;

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
			case "nokunjungan":
				// % protected region % [Add any additional logic before the query parameters of nokunjungan here] off begin
				// % protected region % [Add any additional logic before the query parameters of nokunjungan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nokunjungan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nokunjungan here] off begin
				// % protected region % [Add any additional logic after the query parameters of nokunjungan here] end

				break;
			case "tglkunjungan":
				// % protected region % [Add any additional logic before the query parameters of tglkunjungan here] off begin
				// % protected region % [Add any additional logic before the query parameters of tglkunjungan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tglkunjungan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tglkunjungan here] off begin
				// % protected region % [Add any additional logic after the query parameters of tglkunjungan here] end

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
	public BpjsPcareRiwayatKunjunganEntity updateOldData(BpjsPcareRiwayatKunjunganEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BpjsPcareRiwayatKunjunganEntity updateOldData(BpjsPcareRiwayatKunjunganEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BpjsPcareRiwayatKunjunganEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBpjsPcareRiwayatKunjunganEntity);

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
	public void validateEntity(BpjsPcareRiwayatKunjunganEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BpjsPcareRiwayatKunjunganEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the BpjsPcareRiwayatKunjunganEntity.
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

	public Set<String> validateEntityRelations(BpjsPcareRiwayatKunjunganEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
