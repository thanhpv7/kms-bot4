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
import kmsweb.entities.PatientVisitEntity;
import kmsweb.services.PatientVisitService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BpjsPcareRegistrationsService;
import kmsweb.entities.BpjsPcareRegistrationsEntity;
import kmsweb.services.BpjsVisitDataService;
import kmsweb.entities.BpjsVisitDataEntity;
import kmsweb.services.BpjsPcarePendaftaranService;
import kmsweb.entities.BpjsPcarePendaftaranEntity;
import kmsweb.services.InvoiceService;
import kmsweb.entities.InvoiceEntity;
import kmsweb.services.PatientGeneralInfoService;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.services.PatientVisitPatientPaymentInsuranceService;
import kmsweb.entities.PatientVisitPatientPaymentInsuranceEntity;
import kmsweb.services.PatientVisitPatientPaymentOthersService;
import kmsweb.entities.PatientVisitPatientPaymentOthersEntity;
import kmsweb.services.PatientVisitPaymentSelfPayingService;
import kmsweb.entities.PatientVisitPaymentSelfPayingEntity;
import kmsweb.services.RegistrationService;
import kmsweb.entities.RegistrationEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class PatientVisitMutationResolver implements GraphQLMutationResolver {

	private final PatientVisitService patientVisitService;

	private final BpjsPcareRegistrationsService bpjsPcareRegistrationsService;

	private final BpjsVisitDataService bpjsVisitDataService;

	private final BpjsPcarePendaftaranService bpjsPcarePendaftaranService;

	private final InvoiceService invoiceService;

	private final PatientGeneralInfoService patientGeneralInfoService;

	private final PatientVisitPatientPaymentInsuranceService patientVisitPatientPaymentInsuranceService;

	private final PatientVisitPatientPaymentOthersService patientVisitPatientPaymentOthersService;

	private final PatientVisitPaymentSelfPayingService patientVisitPaymentSelfPayingService;

	private final RegistrationService registrationService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PatientVisitMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BpjsPcareRegistrationsService bpjsPcareRegistrationsService,
			BpjsVisitDataService bpjsVisitDataService,
			BpjsPcarePendaftaranService bpjsPcarePendaftaranService,
			InvoiceService invoiceService,
			PatientGeneralInfoService patientGeneralInfoService,
			PatientVisitPatientPaymentInsuranceService patientVisitPatientPaymentInsuranceService,
			PatientVisitPatientPaymentOthersService patientVisitPatientPaymentOthersService,
			PatientVisitPaymentSelfPayingService patientVisitPaymentSelfPayingService,
			RegistrationService registrationService,
			PatientVisitService patientVisitService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.patientVisitService = patientVisitService;

		this.bpjsPcareRegistrationsService = bpjsPcareRegistrationsService;

		this.bpjsVisitDataService = bpjsVisitDataService;

		this.bpjsPcarePendaftaranService = bpjsPcarePendaftaranService;

		this.invoiceService = invoiceService;

		this.patientGeneralInfoService = patientGeneralInfoService;

		this.patientVisitPatientPaymentInsuranceService = patientVisitPatientPaymentInsuranceService;

		this.patientVisitPatientPaymentOthersService = patientVisitPatientPaymentOthersService;

		this.patientVisitPaymentSelfPayingService = patientVisitPaymentSelfPayingService;

		this.registrationService = registrationService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('PatientVisitEntity', 'create')")
	public PatientVisitEntity createPatientVisit(@NonNull PatientVisitEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getBpjsPcareRegistrations() != null) {
			rawEntity.setBpjsPcareRegistrations(bpjsPcareRegistrationsService.updateOldData(rawEntity.getBpjsPcareRegistrations()));
		}

		if (rawEntity.getPatientVisitPatientPaymentInsurance() != null) {
			rawEntity.setPatientVisitPatientPaymentInsurance(patientVisitPatientPaymentInsuranceService.updateOldData(rawEntity.getPatientVisitPatientPaymentInsurance()));
		}

		if (rawEntity.getPatientVisitPatientPaymentOthers() != null) {
			rawEntity.setPatientVisitPatientPaymentOthers(patientVisitPatientPaymentOthersService.updateOldData(rawEntity.getPatientVisitPatientPaymentOthers()));
		}

		if (rawEntity.getPatientVisitPaymentSelfPaying() != null) {
			rawEntity.setPatientVisitPaymentSelfPaying(patientVisitPaymentSelfPayingService.updateOldData(rawEntity.getPatientVisitPaymentSelfPaying()));
		}

		if (rawEntity.getPatient() != null) {
			rawEntity.setPatient(patientGeneralInfoService.updateOldData(rawEntity.getPatient()));
		}

		Set<BpjsVisitDataEntity> bpjsVisitDatas = new HashSet<>();
		rawEntity.getBpjsVisitDatas().forEach(entity -> {
			bpjsVisitDatas.add(bpjsVisitDataService.updateOldData(entity));
		});
		rawEntity.setBpjsVisitDatas(bpjsVisitDatas);

		Set<BpjsPcarePendaftaranEntity> bpjsPcarePendaftarans = new HashSet<>();
		rawEntity.getBpjsPcarePendaftarans().forEach(entity -> {
			bpjsPcarePendaftarans.add(bpjsPcarePendaftaranService.updateOldData(entity));
		});
		rawEntity.setBpjsPcarePendaftarans(bpjsPcarePendaftarans);

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

		PatientVisitEntity newEntity = patientVisitService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PatientVisitMutationResolver#createPatientVisit(PatientVisitEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PatientVisitEntity', 'create')")
	public List<PatientVisitEntity> createAllPatientVisit(@NonNull List<PatientVisitEntity> rawEntities) {
		List<PatientVisitEntity> newEntities = Lists.newArrayList(patientVisitService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('PatientVisitEntity', 'update')")
	public PatientVisitEntity updatePatientVisit(@NonNull PatientVisitEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getBpjsPcareRegistrations() != null) {
			rawEntity.setBpjsPcareRegistrations(bpjsPcareRegistrationsService.updateOldData(rawEntity.getBpjsPcareRegistrations()));
		}

		if (rawEntity.getPatientVisitPatientPaymentInsurance() != null) {
			rawEntity.setPatientVisitPatientPaymentInsurance(patientVisitPatientPaymentInsuranceService.updateOldData(rawEntity.getPatientVisitPatientPaymentInsurance()));
		}

		if (rawEntity.getPatientVisitPatientPaymentOthers() != null) {
			rawEntity.setPatientVisitPatientPaymentOthers(patientVisitPatientPaymentOthersService.updateOldData(rawEntity.getPatientVisitPatientPaymentOthers()));
		}

		if (rawEntity.getPatientVisitPaymentSelfPaying() != null) {
			rawEntity.setPatientVisitPaymentSelfPaying(patientVisitPaymentSelfPayingService.updateOldData(rawEntity.getPatientVisitPaymentSelfPaying()));
		}

		if (rawEntity.getPatient() != null) {
			rawEntity.setPatient(patientGeneralInfoService.updateOldData(rawEntity.getPatient()));
		}

		Set<BpjsVisitDataEntity> bpjsVisitDatas = new HashSet<>();
		rawEntity.getBpjsVisitDatas().forEach(entity -> {
			bpjsVisitDatas.add(bpjsVisitDataService.updateOldData(entity));
		});
		rawEntity.setBpjsVisitDatas(bpjsVisitDatas);

		Set<BpjsPcarePendaftaranEntity> bpjsPcarePendaftarans = new HashSet<>();
		rawEntity.getBpjsPcarePendaftarans().forEach(entity -> {
			bpjsPcarePendaftarans.add(bpjsPcarePendaftaranService.updateOldData(entity));
		});
		rawEntity.setBpjsPcarePendaftarans(bpjsPcarePendaftarans);

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

		PatientVisitEntity entityFromDb = patientVisitService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		PatientVisitEntity newEntity = patientVisitService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PatientVisitMutationResolver#updatePatientVisit(PatientVisitEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PatientVisitEntity', 'update')")
	public List<PatientVisitEntity> updateAllPatientVisit(@NonNull List<PatientVisitEntity> rawEntities) {
		List<PatientVisitEntity> newEntities = Lists.newArrayList(patientVisitService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('PatientVisitEntity', 'delete')")
	public String deletePatientVisitById(@NonNull String id) {
		patientVisitService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link PatientVisitMutationResolver#deletePatientVisitById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PatientVisitEntity', 'delete')")
	public List<String> deleteAllPatientVisitByIds(@NonNull List<String> ids) {
		patientVisitService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('PatientVisitEntity', 'delete')")
	public List<String> deletePatientVisitExcludingIds(@NonNull List<String> ids) {
		patientVisitService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
