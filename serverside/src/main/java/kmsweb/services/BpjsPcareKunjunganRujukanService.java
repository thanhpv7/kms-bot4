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
import kmsweb.repositories.BpjsPcareKunjunganRujukanRepository;
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
public class BpjsPcareKunjunganRujukanService extends AbstractService<BpjsPcareKunjunganRujukanEntity, BpjsPcareKunjunganRujukanRepository, BpjsPcareKunjunganRujukanEntityAudit> {

	private final String[] referenceNamesInBpjsPcareKunjunganRujukanEntity = {
	};

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsPcareKunjunganRujukanService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		Validator validator,
		AuditingRepository auditingRepository,
		BpjsPcareKunjunganRujukanRepository repository
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
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
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
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute noRujukan.
	 *
	 * @param norujukan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noRujukan
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByNorujukan(String norujukan)
	// % protected region % [Add any throwables, implementations, or extensions for findByNorujukan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNorujukan here] end
	{
		// % protected region % [Add any additional logic for findByNorujukan before the main body here] off begin
		// % protected region % [Add any additional logic for findByNorujukan before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByNorujukan(norujukan));

		// % protected region % [Add any additional logic for findByNorujukan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNorujukan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdPPK.
	 *
	 * @param kdppk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdPPK
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByKdppk(String kdppk)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdppk here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdppk here] end
	{
		// % protected region % [Add any additional logic for findByKdppk before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdppk before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByKdppk(kdppk));

		// % protected region % [Add any additional logic for findByKdppk before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdppk before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmPPK.
	 *
	 * @param nmppk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmPPK
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByNmppk(String nmppk)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmppk here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmppk here] end
	{
		// % protected region % [Add any additional logic for findByNmppk before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmppk before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByNmppk(nmppk));

		// % protected region % [Add any additional logic for findByNmppk before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmppk before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute alamat.
	 *
	 * @param alamat the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute alamat
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByAlamat(String alamat)
	// % protected region % [Add any throwables, implementations, or extensions for findByAlamat here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAlamat here] end
	{
		// % protected region % [Add any additional logic for findByAlamat before the main body here] off begin
		// % protected region % [Add any additional logic for findByAlamat before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByAlamat(alamat));

		// % protected region % [Add any additional logic for findByAlamat before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAlamat before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdKC.
	 *
	 * @param kdkc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdKC
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByKdkc(String kdkc)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdkc here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdkc here] end
	{
		// % protected region % [Add any additional logic for findByKdkc before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdkc before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByKdkc(kdkc));

		// % protected region % [Add any additional logic for findByKdkc before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdkc before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmKC.
	 *
	 * @param nmkc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmKC
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByNmkc(String nmkc)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmkc here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmkc here] end
	{
		// % protected region % [Add any additional logic for findByNmkc before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmkc before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByNmkc(nmkc));

		// % protected region % [Add any additional logic for findByNmkc before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmkc before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute alamatKC.
	 *
	 * @param alamatkc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute alamatKC
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByAlamatkc(String alamatkc)
	// % protected region % [Add any throwables, implementations, or extensions for findByAlamatkc here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAlamatkc here] end
	{
		// % protected region % [Add any additional logic for findByAlamatkc before the main body here] off begin
		// % protected region % [Add any additional logic for findByAlamatkc before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByAlamatkc(alamatkc));

		// % protected region % [Add any additional logic for findByAlamatkc before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAlamatkc before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute telpKC.
	 *
	 * @param telpkc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute telpKC
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByTelpkc(String telpkc)
	// % protected region % [Add any throwables, implementations, or extensions for findByTelpkc here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTelpkc here] end
	{
		// % protected region % [Add any additional logic for findByTelpkc before the main body here] off begin
		// % protected region % [Add any additional logic for findByTelpkc before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByTelpkc(telpkc));

		// % protected region % [Add any additional logic for findByTelpkc before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTelpkc before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute faxKC.
	 *
	 * @param faxkc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute faxKC
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByFaxkc(String faxkc)
	// % protected region % [Add any throwables, implementations, or extensions for findByFaxkc here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFaxkc here] end
	{
		// % protected region % [Add any additional logic for findByFaxkc before the main body here] off begin
		// % protected region % [Add any additional logic for findByFaxkc before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByFaxkc(faxkc));

		// % protected region % [Add any additional logic for findByFaxkc before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFaxkc before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdProp.
	 *
	 * @param kdprop the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdProp
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByKdprop(String kdprop)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdprop here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdprop here] end
	{
		// % protected region % [Add any additional logic for findByKdprop before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdprop before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByKdprop(kdprop));

		// % protected region % [Add any additional logic for findByKdprop before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdprop before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdDati.
	 *
	 * @param kddati the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdDati
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByKddati(String kddati)
	// % protected region % [Add any throwables, implementations, or extensions for findByKddati here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKddati here] end
	{
		// % protected region % [Add any additional logic for findByKddati before the main body here] off begin
		// % protected region % [Add any additional logic for findByKddati before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByKddati(kddati));

		// % protected region % [Add any additional logic for findByKddati before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKddati before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmDati.
	 *
	 * @param nmdati the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmDati
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByNmdati(String nmdati)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmdati here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmdati here] end
	{
		// % protected region % [Add any additional logic for findByNmdati before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmdati before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByNmdati(nmdati));

		// % protected region % [Add any additional logic for findByNmdati before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmdati before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdKR.
	 *
	 * @param kdkr the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdKR
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByKdkr(String kdkr)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdkr here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdkr here] end
	{
		// % protected region % [Add any additional logic for findByKdkr before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdkr before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByKdkr(kdkr));

		// % protected region % [Add any additional logic for findByKdkr before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdkr before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmKR.
	 *
	 * @param nmkr the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmKR
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByNmkr(String nmkr)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmkr here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmkr here] end
	{
		// % protected region % [Add any additional logic for findByNmkr before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmkr before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByNmkr(nmkr));

		// % protected region % [Add any additional logic for findByNmkr before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmkr before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute alamatKR.
	 *
	 * @param alamatkr the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute alamatKR
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByAlamatkr(String alamatkr)
	// % protected region % [Add any throwables, implementations, or extensions for findByAlamatkr here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAlamatkr here] end
	{
		// % protected region % [Add any additional logic for findByAlamatkr before the main body here] off begin
		// % protected region % [Add any additional logic for findByAlamatkr before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByAlamatkr(alamatkr));

		// % protected region % [Add any additional logic for findByAlamatkr before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAlamatkr before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute telpKR.
	 *
	 * @param telpkr the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute telpKR
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByTelpkr(String telpkr)
	// % protected region % [Add any throwables, implementations, or extensions for findByTelpkr here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTelpkr here] end
	{
		// % protected region % [Add any additional logic for findByTelpkr before the main body here] off begin
		// % protected region % [Add any additional logic for findByTelpkr before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByTelpkr(telpkr));

		// % protected region % [Add any additional logic for findByTelpkr before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTelpkr before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute faxKR.
	 *
	 * @param faxkr the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute faxKR
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByFaxkr(String faxkr)
	// % protected region % [Add any throwables, implementations, or extensions for findByFaxkr here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFaxkr here] end
	{
		// % protected region % [Add any additional logic for findByFaxkr before the main body here] off begin
		// % protected region % [Add any additional logic for findByFaxkr before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByFaxkr(faxkr));

		// % protected region % [Add any additional logic for findByFaxkr before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFaxkr before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tglKunjungan.
	 *
	 * @param tglkunjungan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglKunjungan
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByTglkunjungan(String tglkunjungan)
	// % protected region % [Add any throwables, implementations, or extensions for findByTglkunjungan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTglkunjungan here] end
	{
		// % protected region % [Add any additional logic for findByTglkunjungan before the main body here] off begin
		// % protected region % [Add any additional logic for findByTglkunjungan before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByTglkunjungan(tglkunjungan));

		// % protected region % [Add any additional logic for findByTglkunjungan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTglkunjungan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdPoli.
	 *
	 * @param kdpoli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdPoli
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByKdpoli(String kdpoli)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdpoli here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdpoli here] end
	{
		// % protected region % [Add any additional logic for findByKdpoli before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdpoli before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByKdpoli(kdpoli));

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
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByNmpoli(String nmpoli)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmpoli here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmpoli here] end
	{
		// % protected region % [Add any additional logic for findByNmpoli before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmpoli before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByNmpoli(nmpoli));

		// % protected region % [Add any additional logic for findByNmpoli before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmpoli before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nokaPst.
	 *
	 * @param nokapst the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nokaPst
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByNokapst(String nokapst)
	// % protected region % [Add any throwables, implementations, or extensions for findByNokapst here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNokapst here] end
	{
		// % protected region % [Add any additional logic for findByNokapst before the main body here] off begin
		// % protected region % [Add any additional logic for findByNokapst before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByNokapst(nokapst));

		// % protected region % [Add any additional logic for findByNokapst before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNokapst before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmPst.
	 *
	 * @param nmpst the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmPst
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByNmpst(String nmpst)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmpst here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmpst here] end
	{
		// % protected region % [Add any additional logic for findByNmpst before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmpst before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByNmpst(nmpst));

		// % protected region % [Add any additional logic for findByNmpst before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmpst before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tglLahir.
	 *
	 * @param tgllahir the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglLahir
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByTgllahir(String tgllahir)
	// % protected region % [Add any throwables, implementations, or extensions for findByTgllahir here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTgllahir here] end
	{
		// % protected region % [Add any additional logic for findByTgllahir before the main body here] off begin
		// % protected region % [Add any additional logic for findByTgllahir before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByTgllahir(tgllahir));

		// % protected region % [Add any additional logic for findByTgllahir before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTgllahir before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute pisa.
	 *
	 * @param pisa the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute pisa
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByPisa(String pisa)
	// % protected region % [Add any throwables, implementations, or extensions for findByPisa here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPisa here] end
	{
		// % protected region % [Add any additional logic for findByPisa before the main body here] off begin
		// % protected region % [Add any additional logic for findByPisa before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByPisa(pisa));

		// % protected region % [Add any additional logic for findByPisa before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPisa before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute ketPisa.
	 *
	 * @param ketpisa the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ketPisa
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByKetpisa(String ketpisa)
	// % protected region % [Add any throwables, implementations, or extensions for findByKetpisa here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKetpisa here] end
	{
		// % protected region % [Add any additional logic for findByKetpisa before the main body here] off begin
		// % protected region % [Add any additional logic for findByKetpisa before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByKetpisa(ketpisa));

		// % protected region % [Add any additional logic for findByKetpisa before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKetpisa before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute sex.
	 *
	 * @param sex the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute sex
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findBySex(String sex)
	// % protected region % [Add any throwables, implementations, or extensions for findBySex here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySex here] end
	{
		// % protected region % [Add any additional logic for findBySex before the main body here] off begin
		// % protected region % [Add any additional logic for findBySex before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findBySex(sex));

		// % protected region % [Add any additional logic for findBySex before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySex before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdDiag1.
	 *
	 * @param kddiag1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdDiag1
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByKddiag1(String kddiag1)
	// % protected region % [Add any throwables, implementations, or extensions for findByKddiag1 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKddiag1 here] end
	{
		// % protected region % [Add any additional logic for findByKddiag1 before the main body here] off begin
		// % protected region % [Add any additional logic for findByKddiag1 before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByKddiag1(kddiag1));

		// % protected region % [Add any additional logic for findByKddiag1 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKddiag1 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmDiag1.
	 *
	 * @param nmdiag1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmDiag1
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByNmdiag1(String nmdiag1)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmdiag1 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmdiag1 here] end
	{
		// % protected region % [Add any additional logic for findByNmdiag1 before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmdiag1 before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByNmdiag1(nmdiag1));

		// % protected region % [Add any additional logic for findByNmdiag1 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmdiag1 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdDiag2.
	 *
	 * @param kddiag2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdDiag2
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByKddiag2(String kddiag2)
	// % protected region % [Add any throwables, implementations, or extensions for findByKddiag2 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKddiag2 here] end
	{
		// % protected region % [Add any additional logic for findByKddiag2 before the main body here] off begin
		// % protected region % [Add any additional logic for findByKddiag2 before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByKddiag2(kddiag2));

		// % protected region % [Add any additional logic for findByKddiag2 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKddiag2 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmDiag2.
	 *
	 * @param nmdiag2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmDiag2
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByNmdiag2(String nmdiag2)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmdiag2 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmdiag2 here] end
	{
		// % protected region % [Add any additional logic for findByNmdiag2 before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmdiag2 before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByNmdiag2(nmdiag2));

		// % protected region % [Add any additional logic for findByNmdiag2 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmdiag2 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdDiag3.
	 *
	 * @param kddiag3 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdDiag3
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByKddiag3(String kddiag3)
	// % protected region % [Add any throwables, implementations, or extensions for findByKddiag3 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKddiag3 here] end
	{
		// % protected region % [Add any additional logic for findByKddiag3 before the main body here] off begin
		// % protected region % [Add any additional logic for findByKddiag3 before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByKddiag3(kddiag3));

		// % protected region % [Add any additional logic for findByKddiag3 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKddiag3 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmDiag3.
	 *
	 * @param nmdiag3 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmDiag3
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByNmdiag3(String nmdiag3)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmdiag3 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmdiag3 here] end
	{
		// % protected region % [Add any additional logic for findByNmdiag3 before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmdiag3 before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByNmdiag3(nmdiag3));

		// % protected region % [Add any additional logic for findByNmdiag3 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmdiag3 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute catatan.
	 *
	 * @param catatan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute catatan
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByCatatan(String catatan)
	// % protected region % [Add any throwables, implementations, or extensions for findByCatatan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCatatan here] end
	{
		// % protected region % [Add any additional logic for findByCatatan before the main body here] off begin
		// % protected region % [Add any additional logic for findByCatatan before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByCatatan(catatan));

		// % protected region % [Add any additional logic for findByCatatan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCatatan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdDokter.
	 *
	 * @param kddokter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdDokter
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByKddokter(String kddokter)
	// % protected region % [Add any throwables, implementations, or extensions for findByKddokter here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKddokter here] end
	{
		// % protected region % [Add any additional logic for findByKddokter before the main body here] off begin
		// % protected region % [Add any additional logic for findByKddokter before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByKddokter(kddokter));

		// % protected region % [Add any additional logic for findByKddokter before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKddokter before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmDokter.
	 *
	 * @param nmdokter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmDokter
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByNmdokter(String nmdokter)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmdokter here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmdokter here] end
	{
		// % protected region % [Add any additional logic for findByNmdokter before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmdokter before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByNmdokter(nmdokter));

		// % protected region % [Add any additional logic for findByNmdokter before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmdokter before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute nmTacc.
	 *
	 * @param nmtacc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmTacc
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByNmtacc(String nmtacc)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmtacc here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmtacc here] end
	{
		// % protected region % [Add any additional logic for findByNmtacc before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmtacc before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByNmtacc(nmtacc));

		// % protected region % [Add any additional logic for findByNmtacc before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmtacc before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute alasanTacc.
	 *
	 * @param alasantacc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute alasanTacc
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByAlasantacc(String alasantacc)
	// % protected region % [Add any throwables, implementations, or extensions for findByAlasantacc here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAlasantacc here] end
	{
		// % protected region % [Add any additional logic for findByAlasantacc before the main body here] off begin
		// % protected region % [Add any additional logic for findByAlasantacc before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByAlasantacc(alasantacc));

		// % protected region % [Add any additional logic for findByAlasantacc before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAlasantacc before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute infoDenda.
	 *
	 * @param infodenda the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute infoDenda
	 */
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findByInfodenda(String infodenda)
	// % protected region % [Add any throwables, implementations, or extensions for findByInfodenda here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInfodenda here] end
	{
		// % protected region % [Add any additional logic for findByInfodenda before the main body here] off begin
		// % protected region % [Add any additional logic for findByInfodenda before the main body here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findByInfodenda(infodenda));

		// % protected region % [Add any additional logic for findByInfodenda before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInfodenda before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsPcareKunjunganRujukanEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BpjsPcareKunjunganRujukanEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BpjsPcareKunjunganRujukanEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'create')")
	public BpjsPcareKunjunganRujukanEntity create(BpjsPcareKunjunganRujukanEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BpjsPcareKunjunganRujukanEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'create')")
	public BpjsPcareKunjunganRujukanEntity create(BpjsPcareKunjunganRujukanEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BpjsPcareKunjunganRujukanEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BpjsPcareKunjunganRujukanEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'create')")
	public List<BpjsPcareKunjunganRujukanEntity> createAll(Iterable<BpjsPcareKunjunganRujukanEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BpjsPcareKunjunganRujukanEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BpjsPcareKunjunganRujukanEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'update')")
	public BpjsPcareKunjunganRujukanEntity update(BpjsPcareKunjunganRujukanEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BpjsPcareKunjunganRujukanEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'update')")
	public BpjsPcareKunjunganRujukanEntity update(BpjsPcareKunjunganRujukanEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BpjsPcareKunjunganRujukanEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BpjsPcareKunjunganRujukanEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'update')")
	public List<BpjsPcareKunjunganRujukanEntity> updateAll(Iterable<BpjsPcareKunjunganRujukanEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BpjsPcareKunjunganRujukanEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BpjsPcareKunjunganRujukanEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'create') or hasPermission('BpjsPcareKunjunganRujukanEntity', 'update')")
	public BpjsPcareKunjunganRujukanEntity save(BpjsPcareKunjunganRujukanEntity entity) throws ConstraintViolationException
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

		BpjsPcareKunjunganRujukanEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'create') or hasPermission('BpjsPcareKunjunganRujukanEntity', 'update')")
	public List<BpjsPcareKunjunganRujukanEntity> saveAll(Iterable<BpjsPcareKunjunganRujukanEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BpjsPcareKunjunganRujukanEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	public List<BpjsPcareKunjunganRujukanEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	public List<BpjsPcareKunjunganRujukanEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BpjsPcareKunjunganRujukanEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BpjsPcareKunjunganRujukanEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsPcareKunjunganRujukanEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsPcareKunjunganRujukanEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsPcareKunjunganRujukanEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BpjsPcareKunjunganRujukanEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsPcareKunjunganRujukanEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BpjsPcareKunjunganRujukanEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BpjsPcareKunjunganRujukanEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BpjsPcareKunjunganRujukanEntityAudits
	 */
	private List<BpjsPcareKunjunganRujukanEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BpjsPcareKunjunganRujukanEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bpjsPcareKunjunganRujukan bpjsPcareKunjunganRujukan to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BpjsPcareKunjunganRujukanEntity updateAuditData(BpjsPcareKunjunganRujukanEntity bpjsPcareKunjunganRujukan)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bpjsPcareKunjunganRujukan;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BpjsPcareKunjunganRujukanEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BpjsPcareKunjunganRujukanEntity entityAtRevision = updateAuditData((BpjsPcareKunjunganRujukanEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BpjsPcareKunjunganRujukanEntityAudit(
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

		QBpjsPcareKunjunganRujukanEntity entity = QBpjsPcareKunjunganRujukanEntity.bpjsPcareKunjunganRujukanEntity;

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
			case "nmppk":
				// % protected region % [Add any additional logic before the query parameters of nmppk here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmppk here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmppk, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmppk here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmppk here] end

				break;
			case "alamat":
				// % protected region % [Add any additional logic before the query parameters of alamat here] off begin
				// % protected region % [Add any additional logic before the query parameters of alamat here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.alamat, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of alamat here] off begin
				// % protected region % [Add any additional logic after the query parameters of alamat here] end

				break;
			case "kdkc":
				// % protected region % [Add any additional logic before the query parameters of kdkc here] off begin
				// % protected region % [Add any additional logic before the query parameters of kdkc here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kdkc, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kdkc here] off begin
				// % protected region % [Add any additional logic after the query parameters of kdkc here] end

				break;
			case "alamatkc":
				// % protected region % [Add any additional logic before the query parameters of alamatkc here] off begin
				// % protected region % [Add any additional logic before the query parameters of alamatkc here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.alamatkc, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of alamatkc here] off begin
				// % protected region % [Add any additional logic after the query parameters of alamatkc here] end

				break;
			case "telpkc":
				// % protected region % [Add any additional logic before the query parameters of telpkc here] off begin
				// % protected region % [Add any additional logic before the query parameters of telpkc here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.telpkc, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of telpkc here] off begin
				// % protected region % [Add any additional logic after the query parameters of telpkc here] end

				break;
			case "faxkc":
				// % protected region % [Add any additional logic before the query parameters of faxkc here] off begin
				// % protected region % [Add any additional logic before the query parameters of faxkc here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.faxkc, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of faxkc here] off begin
				// % protected region % [Add any additional logic after the query parameters of faxkc here] end

				break;
			case "kdprop":
				// % protected region % [Add any additional logic before the query parameters of kdprop here] off begin
				// % protected region % [Add any additional logic before the query parameters of kdprop here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kdprop, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kdprop here] off begin
				// % protected region % [Add any additional logic after the query parameters of kdprop here] end

				break;
			case "kddati":
				// % protected region % [Add any additional logic before the query parameters of kddati here] off begin
				// % protected region % [Add any additional logic before the query parameters of kddati here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kddati, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kddati here] off begin
				// % protected region % [Add any additional logic after the query parameters of kddati here] end

				break;
			case "nmdati":
				// % protected region % [Add any additional logic before the query parameters of nmdati here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmdati here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmdati, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmdati here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmdati here] end

				break;
			case "alamatkr":
				// % protected region % [Add any additional logic before the query parameters of alamatkr here] off begin
				// % protected region % [Add any additional logic before the query parameters of alamatkr here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.alamatkr, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of alamatkr here] off begin
				// % protected region % [Add any additional logic after the query parameters of alamatkr here] end

				break;
			case "telpkr":
				// % protected region % [Add any additional logic before the query parameters of telpkr here] off begin
				// % protected region % [Add any additional logic before the query parameters of telpkr here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.telpkr, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of telpkr here] off begin
				// % protected region % [Add any additional logic after the query parameters of telpkr here] end

				break;
			case "faxkr":
				// % protected region % [Add any additional logic before the query parameters of faxkr here] off begin
				// % protected region % [Add any additional logic before the query parameters of faxkr here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.faxkr, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of faxkr here] off begin
				// % protected region % [Add any additional logic after the query parameters of faxkr here] end

				break;
			case "tglkunjungan":
				// % protected region % [Add any additional logic before the query parameters of tglkunjungan here] off begin
				// % protected region % [Add any additional logic before the query parameters of tglkunjungan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tglkunjungan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tglkunjungan here] off begin
				// % protected region % [Add any additional logic after the query parameters of tglkunjungan here] end

				break;
			case "kdpoli":
				// % protected region % [Add any additional logic before the query parameters of kdpoli here] off begin
				// % protected region % [Add any additional logic before the query parameters of kdpoli here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kdpoli, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kdpoli here] off begin
				// % protected region % [Add any additional logic after the query parameters of kdpoli here] end

				break;
			case "nokapst":
				// % protected region % [Add any additional logic before the query parameters of nokapst here] off begin
				// % protected region % [Add any additional logic before the query parameters of nokapst here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nokapst, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nokapst here] off begin
				// % protected region % [Add any additional logic after the query parameters of nokapst here] end

				break;
			case "nmpst":
				// % protected region % [Add any additional logic before the query parameters of nmpst here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmpst here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmpst, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmpst here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmpst here] end

				break;
			case "tgllahir":
				// % protected region % [Add any additional logic before the query parameters of tgllahir here] off begin
				// % protected region % [Add any additional logic before the query parameters of tgllahir here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tgllahir, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tgllahir here] off begin
				// % protected region % [Add any additional logic after the query parameters of tgllahir here] end

				break;
			case "pisa":
				// % protected region % [Add any additional logic before the query parameters of pisa here] off begin
				// % protected region % [Add any additional logic before the query parameters of pisa here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pisa, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of pisa here] off begin
				// % protected region % [Add any additional logic after the query parameters of pisa here] end

				break;
			case "ketpisa":
				// % protected region % [Add any additional logic before the query parameters of ketpisa here] off begin
				// % protected region % [Add any additional logic before the query parameters of ketpisa here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.ketpisa, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of ketpisa here] off begin
				// % protected region % [Add any additional logic after the query parameters of ketpisa here] end

				break;
			case "sex":
				// % protected region % [Add any additional logic before the query parameters of sex here] off begin
				// % protected region % [Add any additional logic before the query parameters of sex here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sex, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of sex here] off begin
				// % protected region % [Add any additional logic after the query parameters of sex here] end

				break;
			case "kddiag1":
				// % protected region % [Add any additional logic before the query parameters of kddiag1 here] off begin
				// % protected region % [Add any additional logic before the query parameters of kddiag1 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kddiag1, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kddiag1 here] off begin
				// % protected region % [Add any additional logic after the query parameters of kddiag1 here] end

				break;
			case "nmdiag1":
				// % protected region % [Add any additional logic before the query parameters of nmdiag1 here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmdiag1 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmdiag1, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmdiag1 here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmdiag1 here] end

				break;
			case "kddiag2":
				// % protected region % [Add any additional logic before the query parameters of kddiag2 here] off begin
				// % protected region % [Add any additional logic before the query parameters of kddiag2 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kddiag2, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kddiag2 here] off begin
				// % protected region % [Add any additional logic after the query parameters of kddiag2 here] end

				break;
			case "nmdiag2":
				// % protected region % [Add any additional logic before the query parameters of nmdiag2 here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmdiag2 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmdiag2, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmdiag2 here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmdiag2 here] end

				break;
			case "kddiag3":
				// % protected region % [Add any additional logic before the query parameters of kddiag3 here] off begin
				// % protected region % [Add any additional logic before the query parameters of kddiag3 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kddiag3, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kddiag3 here] off begin
				// % protected region % [Add any additional logic after the query parameters of kddiag3 here] end

				break;
			case "nmdiag3":
				// % protected region % [Add any additional logic before the query parameters of nmdiag3 here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmdiag3 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmdiag3, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmdiag3 here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmdiag3 here] end

				break;
			case "catatan":
				// % protected region % [Add any additional logic before the query parameters of catatan here] off begin
				// % protected region % [Add any additional logic before the query parameters of catatan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.catatan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of catatan here] off begin
				// % protected region % [Add any additional logic after the query parameters of catatan here] end

				break;
			case "kddokter":
				// % protected region % [Add any additional logic before the query parameters of kddokter here] off begin
				// % protected region % [Add any additional logic before the query parameters of kddokter here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kddokter, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kddokter here] off begin
				// % protected region % [Add any additional logic after the query parameters of kddokter here] end

				break;
			case "nmdokter":
				// % protected region % [Add any additional logic before the query parameters of nmdokter here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmdokter here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmdokter, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmdokter here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmdokter here] end

				break;
			case "nmtacc":
				// % protected region % [Add any additional logic before the query parameters of nmtacc here] off begin
				// % protected region % [Add any additional logic before the query parameters of nmtacc here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nmtacc, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nmtacc here] off begin
				// % protected region % [Add any additional logic after the query parameters of nmtacc here] end

				break;
			case "alasantacc":
				// % protected region % [Add any additional logic before the query parameters of alasantacc here] off begin
				// % protected region % [Add any additional logic before the query parameters of alasantacc here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.alasantacc, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of alasantacc here] off begin
				// % protected region % [Add any additional logic after the query parameters of alasantacc here] end

				break;
			case "infodenda":
				// % protected region % [Add any additional logic before the query parameters of infodenda here] off begin
				// % protected region % [Add any additional logic before the query parameters of infodenda here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.infodenda, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of infodenda here] off begin
				// % protected region % [Add any additional logic after the query parameters of infodenda here] end

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
	public BpjsPcareKunjunganRujukanEntity updateOldData(BpjsPcareKunjunganRujukanEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BpjsPcareKunjunganRujukanEntity updateOldData(BpjsPcareKunjunganRujukanEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BpjsPcareKunjunganRujukanEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBpjsPcareKunjunganRujukanEntity);

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
	public void validateEntity(BpjsPcareKunjunganRujukanEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BpjsPcareKunjunganRujukanEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the BpjsPcareKunjunganRujukanEntity.
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

	public Set<String> validateEntityRelations(BpjsPcareKunjunganRujukanEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
