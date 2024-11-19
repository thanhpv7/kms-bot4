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

package kmsweb.graphql.resolvers.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import kmsweb.entities.BedFacilityEntity;
import kmsweb.services.BedFacilityService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BedReserveService;
import kmsweb.entities.BedReserveEntity;
import kmsweb.services.InpatientMedicalExaminationRecordService;
import kmsweb.entities.InpatientMedicalExaminationRecordEntity;
import kmsweb.services.IntraoperativeRecordsService;
import kmsweb.entities.IntraoperativeRecordsEntity;
import kmsweb.services.InvoiceService;
import kmsweb.entities.InvoiceEntity;
import kmsweb.services.PostOperativeDetailsService;
import kmsweb.entities.PostOperativeDetailsEntity;
import kmsweb.services.PreoperativeRecordsService;
import kmsweb.entities.PreoperativeRecordsEntity;
import kmsweb.services.RegistrationService;
import kmsweb.entities.RegistrationEntity;
import kmsweb.services.RoomFacilityService;
import kmsweb.entities.RoomFacilityEntity;
import kmsweb.services.RoomTransferService;
import kmsweb.entities.RoomTransferEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class BedFacilityMutationResolver implements GraphQLMutationResolver {

	private final BedFacilityService bedFacilityService;

	private final BedReserveService bedReserveService;

	private final InpatientMedicalExaminationRecordService inpatientMedicalExaminationRecordService;

	private final IntraoperativeRecordsService intraoperativeRecordsService;

	private final InvoiceService invoiceService;

	private final PostOperativeDetailsService postOperativeDetailsService;

	private final PreoperativeRecordsService preoperativeRecordsService;

	private final RegistrationService registrationService;

	private final RoomFacilityService roomFacilityService;

	private final RoomTransferService roomTransferService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BedFacilityMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BedReserveService bedReserveService,
			InpatientMedicalExaminationRecordService inpatientMedicalExaminationRecordService,
			IntraoperativeRecordsService intraoperativeRecordsService,
			InvoiceService invoiceService,
			PostOperativeDetailsService postOperativeDetailsService,
			PreoperativeRecordsService preoperativeRecordsService,
			RegistrationService registrationService,
			RoomFacilityService roomFacilityService,
			RoomTransferService roomTransferService,
			BedFacilityService bedFacilityService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.bedFacilityService = bedFacilityService;

		this.bedReserveService = bedReserveService;

		this.inpatientMedicalExaminationRecordService = inpatientMedicalExaminationRecordService;

		this.intraoperativeRecordsService = intraoperativeRecordsService;

		this.invoiceService = invoiceService;

		this.postOperativeDetailsService = postOperativeDetailsService;

		this.preoperativeRecordsService = preoperativeRecordsService;

		this.registrationService = registrationService;

		this.roomFacilityService = roomFacilityService;

		this.roomTransferService = roomTransferService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('BedFacilityEntity', 'create')")
	public BedFacilityEntity createBedFacility(@NonNull BedFacilityEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getIntraoperativeRecords() != null) {
			rawEntity.setIntraoperativeRecords(intraoperativeRecordsService.updateOldData(rawEntity.getIntraoperativeRecords()));
		}

		if (rawEntity.getPostOperativeDetails() != null) {
			rawEntity.setPostOperativeDetails(postOperativeDetailsService.updateOldData(rawEntity.getPostOperativeDetails()));
		}

		if (rawEntity.getPreoperativeRecords() != null) {
			rawEntity.setPreoperativeRecords(preoperativeRecordsService.updateOldData(rawEntity.getPreoperativeRecords()));
		}

		if (rawEntity.getRoomFacility() != null) {
			rawEntity.setRoomFacility(roomFacilityService.updateOldData(rawEntity.getRoomFacility()));
		}

		Set<BedReserveEntity> bedReserves = new HashSet<>();
		rawEntity.getBedReserves().forEach(entity -> {
			bedReserves.add(bedReserveService.updateOldData(entity));
		});
		rawEntity.setBedReserves(bedReserves);

		Set<InpatientMedicalExaminationRecordEntity> inpatientMedicalExaminationRecords = new HashSet<>();
		rawEntity.getInpatientMedicalExaminationRecords().forEach(entity -> {
			inpatientMedicalExaminationRecords.add(inpatientMedicalExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setInpatientMedicalExaminationRecords(inpatientMedicalExaminationRecords);

		Set<InvoiceEntity> invoices = new HashSet<>();
		rawEntity.getInvoices().forEach(entity -> {
			invoices.add(invoiceService.updateOldData(entity));
		});
		rawEntity.setInvoices(invoices);

		Set<RegistrationEntity> registrations = new HashSet<>();
		rawEntity.getRegistrations().forEach(entity -> {
			registrations.add(registrationService.updateOldData(entity));
		});
		rawEntity.setRegistrations(registrations);

		Set<RoomTransferEntity> roomTransfers = new HashSet<>();
		rawEntity.getRoomTransfers().forEach(entity -> {
			roomTransfers.add(roomTransferService.updateOldData(entity));
		});
		rawEntity.setRoomTransfers(roomTransfers);

		BedFacilityEntity newEntity = bedFacilityService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link BedFacilityMutationResolver#createBedFacility(BedFacilityEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BedFacilityEntity', 'create')")
	public List<BedFacilityEntity> createAllBedFacility(@NonNull List<BedFacilityEntity> rawEntities) {
		List<BedFacilityEntity> newEntities = Lists.newArrayList(bedFacilityService.createAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the created entities here] off begin
		// % protected region % [Add any additional logic for update before returning the created entities here] end

		return newEntities;
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('BedFacilityEntity', 'update')")
	public BedFacilityEntity updateBedFacility(@NonNull BedFacilityEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getIntraoperativeRecords() != null) {
			rawEntity.setIntraoperativeRecords(intraoperativeRecordsService.updateOldData(rawEntity.getIntraoperativeRecords()));
		}

		if (rawEntity.getPostOperativeDetails() != null) {
			rawEntity.setPostOperativeDetails(postOperativeDetailsService.updateOldData(rawEntity.getPostOperativeDetails()));
		}

		if (rawEntity.getPreoperativeRecords() != null) {
			rawEntity.setPreoperativeRecords(preoperativeRecordsService.updateOldData(rawEntity.getPreoperativeRecords()));
		}

		if (rawEntity.getRoomFacility() != null) {
			rawEntity.setRoomFacility(roomFacilityService.updateOldData(rawEntity.getRoomFacility()));
		}

		Set<BedReserveEntity> bedReserves = new HashSet<>();
		rawEntity.getBedReserves().forEach(entity -> {
			bedReserves.add(bedReserveService.updateOldData(entity));
		});
		rawEntity.setBedReserves(bedReserves);

		Set<InpatientMedicalExaminationRecordEntity> inpatientMedicalExaminationRecords = new HashSet<>();
		rawEntity.getInpatientMedicalExaminationRecords().forEach(entity -> {
			inpatientMedicalExaminationRecords.add(inpatientMedicalExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setInpatientMedicalExaminationRecords(inpatientMedicalExaminationRecords);

		Set<InvoiceEntity> invoices = new HashSet<>();
		rawEntity.getInvoices().forEach(entity -> {
			invoices.add(invoiceService.updateOldData(entity));
		});
		rawEntity.setInvoices(invoices);

		Set<RegistrationEntity> registrations = new HashSet<>();
		rawEntity.getRegistrations().forEach(entity -> {
			registrations.add(registrationService.updateOldData(entity));
		});
		rawEntity.setRegistrations(registrations);

		Set<RoomTransferEntity> roomTransfers = new HashSet<>();
		rawEntity.getRoomTransfers().forEach(entity -> {
			roomTransfers.add(roomTransferService.updateOldData(entity));
		});
		rawEntity.setRoomTransfers(roomTransfers);

		BedFacilityEntity entityFromDb = bedFacilityService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		BedFacilityEntity newEntity = bedFacilityService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link BedFacilityMutationResolver#updateBedFacility(BedFacilityEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BedFacilityEntity', 'update')")
	public List<BedFacilityEntity> updateAllBedFacility(@NonNull List<BedFacilityEntity> rawEntities) {
		List<BedFacilityEntity> newEntities = Lists.newArrayList(bedFacilityService.updateAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the updated entities here] off begin
		// % protected region % [Add any additional logic for update before returning the updated entities here] end

		return newEntities;
	}

	/**
	 * Delete the entity with the ID from the database.
	 *
	 * @param id the ID of the entity to be deleted
	 * @return the ID of the deleted entity
	 */
	@PreAuthorize("hasPermission('BedFacilityEntity', 'delete')")
	public String deleteBedFacilityById(@NonNull String id) {
		bedFacilityService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link BedFacilityMutationResolver#deleteBedFacilityById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BedFacilityEntity', 'delete')")
	public List<String> deleteAllBedFacilityByIds(@NonNull List<String> ids) {
		bedFacilityService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('BedFacilityEntity', 'delete')")
	public List<String> deleteBedFacilityExcludingIds(@NonNull List<String> ids) {
		bedFacilityService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
