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
import kmsweb.entities.InsuranceBenefitPlanEntity;
import kmsweb.services.InsuranceBenefitPlanService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.InsuranceProviderService;
import kmsweb.entities.InsuranceProviderEntity;
import kmsweb.services.InvoicePaymentInsuranceService;
import kmsweb.entities.InvoicePaymentInsuranceEntity;
import kmsweb.services.PatientPaymentInsuranceService;
import kmsweb.entities.PatientPaymentInsuranceEntity;
import kmsweb.services.PatientVisitPatientPaymentInsuranceService;
import kmsweb.entities.PatientVisitPatientPaymentInsuranceEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class InsuranceBenefitPlanMutationResolver implements GraphQLMutationResolver {

	private final InsuranceBenefitPlanService insuranceBenefitPlanService;

	private final InsuranceProviderService insuranceProviderService;

	private final InvoicePaymentInsuranceService invoicePaymentInsuranceService;

	private final PatientPaymentInsuranceService patientPaymentInsuranceService;

	private final PatientVisitPatientPaymentInsuranceService patientVisitPatientPaymentInsuranceService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public InsuranceBenefitPlanMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			InsuranceProviderService insuranceProviderService,
			InvoicePaymentInsuranceService invoicePaymentInsuranceService,
			PatientPaymentInsuranceService patientPaymentInsuranceService,
			PatientVisitPatientPaymentInsuranceService patientVisitPatientPaymentInsuranceService,
			InsuranceBenefitPlanService insuranceBenefitPlanService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.insuranceBenefitPlanService = insuranceBenefitPlanService;

		this.insuranceProviderService = insuranceProviderService;

		this.invoicePaymentInsuranceService = invoicePaymentInsuranceService;

		this.patientPaymentInsuranceService = patientPaymentInsuranceService;

		this.patientVisitPatientPaymentInsuranceService = patientVisitPatientPaymentInsuranceService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'create')")
	public InsuranceBenefitPlanEntity createInsuranceBenefitPlan(@NonNull InsuranceBenefitPlanEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getInsuranceProvider() != null) {
			rawEntity.setInsuranceProvider(insuranceProviderService.updateOldData(rawEntity.getInsuranceProvider()));
		}

		Set<InvoicePaymentInsuranceEntity> invoicePaymentInsurances = new HashSet<>();
		rawEntity.getInvoicePaymentInsurances().forEach(entity -> {
			invoicePaymentInsurances.add(invoicePaymentInsuranceService.updateOldData(entity));
		});
		rawEntity.setInvoicePaymentInsurances(invoicePaymentInsurances);

		Set<PatientPaymentInsuranceEntity> patientPaymentInsurances = new HashSet<>();
		rawEntity.getPatientPaymentInsurances().forEach(entity -> {
			patientPaymentInsurances.add(patientPaymentInsuranceService.updateOldData(entity));
		});
		rawEntity.setPatientPaymentInsurances(patientPaymentInsurances);

		Set<PatientVisitPatientPaymentInsuranceEntity> patientVisitPatientPaymentInsurances = new HashSet<>();
		rawEntity.getPatientVisitPatientPaymentInsurances().forEach(entity -> {
			patientVisitPatientPaymentInsurances.add(patientVisitPatientPaymentInsuranceService.updateOldData(entity));
		});
		rawEntity.setPatientVisitPatientPaymentInsurances(patientVisitPatientPaymentInsurances);

		InsuranceBenefitPlanEntity newEntity = insuranceBenefitPlanService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link InsuranceBenefitPlanMutationResolver#createInsuranceBenefitPlan(InsuranceBenefitPlanEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'create')")
	public List<InsuranceBenefitPlanEntity> createAllInsuranceBenefitPlan(@NonNull List<InsuranceBenefitPlanEntity> rawEntities) {
		List<InsuranceBenefitPlanEntity> newEntities = Lists.newArrayList(insuranceBenefitPlanService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'update')")
	public InsuranceBenefitPlanEntity updateInsuranceBenefitPlan(@NonNull InsuranceBenefitPlanEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getInsuranceProvider() != null) {
			rawEntity.setInsuranceProvider(insuranceProviderService.updateOldData(rawEntity.getInsuranceProvider()));
		}

		Set<InvoicePaymentInsuranceEntity> invoicePaymentInsurances = new HashSet<>();
		rawEntity.getInvoicePaymentInsurances().forEach(entity -> {
			invoicePaymentInsurances.add(invoicePaymentInsuranceService.updateOldData(entity));
		});
		rawEntity.setInvoicePaymentInsurances(invoicePaymentInsurances);

		Set<PatientPaymentInsuranceEntity> patientPaymentInsurances = new HashSet<>();
		rawEntity.getPatientPaymentInsurances().forEach(entity -> {
			patientPaymentInsurances.add(patientPaymentInsuranceService.updateOldData(entity));
		});
		rawEntity.setPatientPaymentInsurances(patientPaymentInsurances);

		Set<PatientVisitPatientPaymentInsuranceEntity> patientVisitPatientPaymentInsurances = new HashSet<>();
		rawEntity.getPatientVisitPatientPaymentInsurances().forEach(entity -> {
			patientVisitPatientPaymentInsurances.add(patientVisitPatientPaymentInsuranceService.updateOldData(entity));
		});
		rawEntity.setPatientVisitPatientPaymentInsurances(patientVisitPatientPaymentInsurances);

		InsuranceBenefitPlanEntity entityFromDb = insuranceBenefitPlanService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		InsuranceBenefitPlanEntity newEntity = insuranceBenefitPlanService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link InsuranceBenefitPlanMutationResolver#updateInsuranceBenefitPlan(InsuranceBenefitPlanEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'update')")
	public List<InsuranceBenefitPlanEntity> updateAllInsuranceBenefitPlan(@NonNull List<InsuranceBenefitPlanEntity> rawEntities) {
		List<InsuranceBenefitPlanEntity> newEntities = Lists.newArrayList(insuranceBenefitPlanService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'delete')")
	public String deleteInsuranceBenefitPlanById(@NonNull String id) {
		insuranceBenefitPlanService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link InsuranceBenefitPlanMutationResolver#deleteInsuranceBenefitPlanById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'delete')")
	public List<String> deleteAllInsuranceBenefitPlanByIds(@NonNull List<String> ids) {
		insuranceBenefitPlanService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'delete')")
	public List<String> deleteInsuranceBenefitPlanExcludingIds(@NonNull List<String> ids) {
		insuranceBenefitPlanService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
