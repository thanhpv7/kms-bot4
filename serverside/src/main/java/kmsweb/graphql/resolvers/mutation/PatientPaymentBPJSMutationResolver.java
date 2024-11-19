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
import kmsweb.entities.PatientPaymentBPJSEntity;
import kmsweb.services.PatientPaymentBPJSService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BpjsAccidentMasterService;
import kmsweb.entities.BpjsAccidentMasterEntity;
import kmsweb.services.BpjsClaimSubmissionService;
import kmsweb.entities.BpjsClaimSubmissionEntity;
import kmsweb.services.BpjsHospitalizationPlanService;
import kmsweb.entities.BpjsHospitalizationPlanEntity;
import kmsweb.services.BpjsJasaRaharjaService;
import kmsweb.entities.BpjsJasaRaharjaEntity;
import kmsweb.services.BpjsPatientReferralService;
import kmsweb.entities.BpjsPatientReferralEntity;
import kmsweb.services.BpjsSEPService;
import kmsweb.entities.BpjsSEPEntity;
import kmsweb.services.BpjsSEPSubmissionService;
import kmsweb.entities.BpjsSEPSubmissionEntity;
import kmsweb.services.PatientGeneralInfoService;
import kmsweb.entities.PatientGeneralInfoEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class PatientPaymentBPJSMutationResolver implements GraphQLMutationResolver {

	private final PatientPaymentBPJSService patientPaymentBPJSService;

	private final BpjsAccidentMasterService bpjsAccidentMasterService;

	private final BpjsClaimSubmissionService bpjsClaimSubmissionService;

	private final BpjsHospitalizationPlanService bpjsHospitalizationPlanService;

	private final BpjsJasaRaharjaService bpjsJasaRaharjaService;

	private final BpjsPatientReferralService bpjsPatientReferralService;

	private final BpjsSEPService bpjsSEPService;

	private final BpjsSEPSubmissionService bpjsSEPSubmissionService;

	private final PatientGeneralInfoService patientGeneralInfoService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PatientPaymentBPJSMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BpjsAccidentMasterService bpjsAccidentMasterService,
			BpjsClaimSubmissionService bpjsClaimSubmissionService,
			BpjsHospitalizationPlanService bpjsHospitalizationPlanService,
			BpjsJasaRaharjaService bpjsJasaRaharjaService,
			BpjsPatientReferralService bpjsPatientReferralService,
			BpjsSEPService bpjsSEPService,
			BpjsSEPSubmissionService bpjsSEPSubmissionService,
			PatientGeneralInfoService patientGeneralInfoService,
			PatientPaymentBPJSService patientPaymentBPJSService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.patientPaymentBPJSService = patientPaymentBPJSService;

		this.bpjsAccidentMasterService = bpjsAccidentMasterService;

		this.bpjsClaimSubmissionService = bpjsClaimSubmissionService;

		this.bpjsHospitalizationPlanService = bpjsHospitalizationPlanService;

		this.bpjsJasaRaharjaService = bpjsJasaRaharjaService;

		this.bpjsPatientReferralService = bpjsPatientReferralService;

		this.bpjsSEPService = bpjsSEPService;

		this.bpjsSEPSubmissionService = bpjsSEPSubmissionService;

		this.patientGeneralInfoService = patientGeneralInfoService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'create')")
	public PatientPaymentBPJSEntity createPatientPaymentBPJS(@NonNull PatientPaymentBPJSEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getPatientGeneralInfo() != null) {
			rawEntity.setPatientGeneralInfo(patientGeneralInfoService.updateOldData(rawEntity.getPatientGeneralInfo()));
		}

		Set<BpjsAccidentMasterEntity> bpjsAccidentMasters = new HashSet<>();
		rawEntity.getBpjsAccidentMasters().forEach(entity -> {
			bpjsAccidentMasters.add(bpjsAccidentMasterService.updateOldData(entity));
		});
		rawEntity.setBpjsAccidentMasters(bpjsAccidentMasters);

		Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();
		rawEntity.getBpjsClaimSubmissions().forEach(entity -> {
			bpjsClaimSubmissions.add(bpjsClaimSubmissionService.updateOldData(entity));
		});
		rawEntity.setBpjsClaimSubmissions(bpjsClaimSubmissions);

		Set<BpjsHospitalizationPlanEntity> bpjsHospitalizationPlans = new HashSet<>();
		rawEntity.getBpjsHospitalizationPlans().forEach(entity -> {
			bpjsHospitalizationPlans.add(bpjsHospitalizationPlanService.updateOldData(entity));
		});
		rawEntity.setBpjsHospitalizationPlans(bpjsHospitalizationPlans);

		Set<BpjsJasaRaharjaEntity> bpjsJasaRaharjas = new HashSet<>();
		rawEntity.getBpjsJasaRaharjas().forEach(entity -> {
			bpjsJasaRaharjas.add(bpjsJasaRaharjaService.updateOldData(entity));
		});
		rawEntity.setBpjsJasaRaharjas(bpjsJasaRaharjas);

		Set<BpjsPatientReferralEntity> bpjsPatientReferrals = new HashSet<>();
		rawEntity.getBpjsPatientReferrals().forEach(entity -> {
			bpjsPatientReferrals.add(bpjsPatientReferralService.updateOldData(entity));
		});
		rawEntity.setBpjsPatientReferrals(bpjsPatientReferrals);

		Set<BpjsSEPSubmissionEntity> bpjsSEPSubmissions = new HashSet<>();
		rawEntity.getBpjsSEPSubmissions().forEach(entity -> {
			bpjsSEPSubmissions.add(bpjsSEPSubmissionService.updateOldData(entity));
		});
		rawEntity.setBpjsSEPSubmissions(bpjsSEPSubmissions);

		Set<BpjsSEPEntity> bpjsSEPs = new HashSet<>();
		rawEntity.getBpjsSEPs().forEach(entity -> {
			bpjsSEPs.add(bpjsSEPService.updateOldData(entity));
		});
		rawEntity.setBpjsSEPs(bpjsSEPs);

		PatientPaymentBPJSEntity newEntity = patientPaymentBPJSService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PatientPaymentBPJSMutationResolver#createPatientPaymentBPJS(PatientPaymentBPJSEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'create')")
	public List<PatientPaymentBPJSEntity> createAllPatientPaymentBPJS(@NonNull List<PatientPaymentBPJSEntity> rawEntities) {
		List<PatientPaymentBPJSEntity> newEntities = Lists.newArrayList(patientPaymentBPJSService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'update')")
	public PatientPaymentBPJSEntity updatePatientPaymentBPJS(@NonNull PatientPaymentBPJSEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getPatientGeneralInfo() != null) {
			rawEntity.setPatientGeneralInfo(patientGeneralInfoService.updateOldData(rawEntity.getPatientGeneralInfo()));
		}

		Set<BpjsAccidentMasterEntity> bpjsAccidentMasters = new HashSet<>();
		rawEntity.getBpjsAccidentMasters().forEach(entity -> {
			bpjsAccidentMasters.add(bpjsAccidentMasterService.updateOldData(entity));
		});
		rawEntity.setBpjsAccidentMasters(bpjsAccidentMasters);

		Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();
		rawEntity.getBpjsClaimSubmissions().forEach(entity -> {
			bpjsClaimSubmissions.add(bpjsClaimSubmissionService.updateOldData(entity));
		});
		rawEntity.setBpjsClaimSubmissions(bpjsClaimSubmissions);

		Set<BpjsHospitalizationPlanEntity> bpjsHospitalizationPlans = new HashSet<>();
		rawEntity.getBpjsHospitalizationPlans().forEach(entity -> {
			bpjsHospitalizationPlans.add(bpjsHospitalizationPlanService.updateOldData(entity));
		});
		rawEntity.setBpjsHospitalizationPlans(bpjsHospitalizationPlans);

		Set<BpjsJasaRaharjaEntity> bpjsJasaRaharjas = new HashSet<>();
		rawEntity.getBpjsJasaRaharjas().forEach(entity -> {
			bpjsJasaRaharjas.add(bpjsJasaRaharjaService.updateOldData(entity));
		});
		rawEntity.setBpjsJasaRaharjas(bpjsJasaRaharjas);

		Set<BpjsPatientReferralEntity> bpjsPatientReferrals = new HashSet<>();
		rawEntity.getBpjsPatientReferrals().forEach(entity -> {
			bpjsPatientReferrals.add(bpjsPatientReferralService.updateOldData(entity));
		});
		rawEntity.setBpjsPatientReferrals(bpjsPatientReferrals);

		Set<BpjsSEPSubmissionEntity> bpjsSEPSubmissions = new HashSet<>();
		rawEntity.getBpjsSEPSubmissions().forEach(entity -> {
			bpjsSEPSubmissions.add(bpjsSEPSubmissionService.updateOldData(entity));
		});
		rawEntity.setBpjsSEPSubmissions(bpjsSEPSubmissions);

		Set<BpjsSEPEntity> bpjsSEPs = new HashSet<>();
		rawEntity.getBpjsSEPs().forEach(entity -> {
			bpjsSEPs.add(bpjsSEPService.updateOldData(entity));
		});
		rawEntity.setBpjsSEPs(bpjsSEPs);

		PatientPaymentBPJSEntity entityFromDb = patientPaymentBPJSService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		PatientPaymentBPJSEntity newEntity = patientPaymentBPJSService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PatientPaymentBPJSMutationResolver#updatePatientPaymentBPJS(PatientPaymentBPJSEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'update')")
	public List<PatientPaymentBPJSEntity> updateAllPatientPaymentBPJS(@NonNull List<PatientPaymentBPJSEntity> rawEntities) {
		List<PatientPaymentBPJSEntity> newEntities = Lists.newArrayList(patientPaymentBPJSService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'delete')")
	public String deletePatientPaymentBPJSById(@NonNull String id) {
		patientPaymentBPJSService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link PatientPaymentBPJSMutationResolver#deletePatientPaymentBPJSById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'delete')")
	public List<String> deleteAllPatientPaymentBPJSByIds(@NonNull List<String> ids) {
		patientPaymentBPJSService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'delete')")
	public List<String> deletePatientPaymentBPJSExcludingIds(@NonNull List<String> ids) {
		patientPaymentBPJSService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
