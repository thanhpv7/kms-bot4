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
import kmsweb.entities.PatientPaymentInsuranceEntity;
import kmsweb.services.PatientPaymentInsuranceService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.InsuranceBenefitPlanService;
import kmsweb.entities.InsuranceBenefitPlanEntity;
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
public class PatientPaymentInsuranceMutationResolver implements GraphQLMutationResolver {

	private final PatientPaymentInsuranceService patientPaymentInsuranceService;

	private final InsuranceBenefitPlanService insuranceBenefitPlanService;

	private final PatientGeneralInfoService patientGeneralInfoService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PatientPaymentInsuranceMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			InsuranceBenefitPlanService insuranceBenefitPlanService,
			PatientGeneralInfoService patientGeneralInfoService,
			PatientPaymentInsuranceService patientPaymentInsuranceService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.patientPaymentInsuranceService = patientPaymentInsuranceService;

		this.insuranceBenefitPlanService = insuranceBenefitPlanService;

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
	@PreAuthorize("hasPermission('PatientPaymentInsuranceEntity', 'create')")
	public PatientPaymentInsuranceEntity createPatientPaymentInsurance(@NonNull PatientPaymentInsuranceEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getPatientGeneralInformation() != null) {
			rawEntity.setPatientGeneralInformation(patientGeneralInfoService.updateOldData(rawEntity.getPatientGeneralInformation()));
		}

		if (rawEntity.getInsuranceBenefitPlan() != null) {
			rawEntity.setInsuranceBenefitPlan(insuranceBenefitPlanService.updateOldData(rawEntity.getInsuranceBenefitPlan()));
		}

		PatientPaymentInsuranceEntity newEntity = patientPaymentInsuranceService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PatientPaymentInsuranceMutationResolver#createPatientPaymentInsurance(PatientPaymentInsuranceEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PatientPaymentInsuranceEntity', 'create')")
	public List<PatientPaymentInsuranceEntity> createAllPatientPaymentInsurance(@NonNull List<PatientPaymentInsuranceEntity> rawEntities) {
		List<PatientPaymentInsuranceEntity> newEntities = Lists.newArrayList(patientPaymentInsuranceService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('PatientPaymentInsuranceEntity', 'update')")
	public PatientPaymentInsuranceEntity updatePatientPaymentInsurance(@NonNull PatientPaymentInsuranceEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getPatientGeneralInformation() != null) {
			rawEntity.setPatientGeneralInformation(patientGeneralInfoService.updateOldData(rawEntity.getPatientGeneralInformation()));
		}

		if (rawEntity.getInsuranceBenefitPlan() != null) {
			rawEntity.setInsuranceBenefitPlan(insuranceBenefitPlanService.updateOldData(rawEntity.getInsuranceBenefitPlan()));
		}

		PatientPaymentInsuranceEntity entityFromDb = patientPaymentInsuranceService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		PatientPaymentInsuranceEntity newEntity = patientPaymentInsuranceService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PatientPaymentInsuranceMutationResolver#updatePatientPaymentInsurance(PatientPaymentInsuranceEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PatientPaymentInsuranceEntity', 'update')")
	public List<PatientPaymentInsuranceEntity> updateAllPatientPaymentInsurance(@NonNull List<PatientPaymentInsuranceEntity> rawEntities) {
		List<PatientPaymentInsuranceEntity> newEntities = Lists.newArrayList(patientPaymentInsuranceService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('PatientPaymentInsuranceEntity', 'delete')")
	public String deletePatientPaymentInsuranceById(@NonNull String id) {
		patientPaymentInsuranceService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link PatientPaymentInsuranceMutationResolver#deletePatientPaymentInsuranceById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PatientPaymentInsuranceEntity', 'delete')")
	public List<String> deleteAllPatientPaymentInsuranceByIds(@NonNull List<String> ids) {
		patientPaymentInsuranceService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('PatientPaymentInsuranceEntity', 'delete')")
	public List<String> deletePatientPaymentInsuranceExcludingIds(@NonNull List<String> ids) {
		patientPaymentInsuranceService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
