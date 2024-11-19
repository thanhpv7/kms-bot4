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
import kmsweb.entities.InformedConsentEntity;
import kmsweb.services.InformedConsentService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.PatientGeneralInfoService;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.services.RegistrationService;
import kmsweb.entities.RegistrationEntity;
import kmsweb.services.StaffService;
import kmsweb.entities.StaffEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class InformedConsentMutationResolver implements GraphQLMutationResolver {

	private final InformedConsentService informedConsentService;

	private final PatientGeneralInfoService patientGeneralInfoService;

	private final RegistrationService registrationService;

	private final StaffService staffService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public InformedConsentMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			PatientGeneralInfoService patientGeneralInfoService,
			RegistrationService registrationService,
			StaffService staffService,
			InformedConsentService informedConsentService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.informedConsentService = informedConsentService;

		this.patientGeneralInfoService = patientGeneralInfoService;

		this.registrationService = registrationService;

		this.staffService = staffService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('InformedConsentEntity', 'create')")
	public InformedConsentEntity createInformedConsent(@NonNull InformedConsentEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getAccompanyingStaff() != null) {
			rawEntity.setAccompanyingStaff(staffService.updateOldData(rawEntity.getAccompanyingStaff()));
		}

		if (rawEntity.getPatientGeneralInfo() != null) {
			rawEntity.setPatientGeneralInfo(patientGeneralInfoService.updateOldData(rawEntity.getPatientGeneralInfo()));
		}

		if (rawEntity.getRegistration() != null) {
			rawEntity.setRegistration(registrationService.updateOldData(rawEntity.getRegistration()));
		}

		if (rawEntity.getInformingStaff() != null) {
			rawEntity.setInformingStaff(staffService.updateOldData(rawEntity.getInformingStaff()));
		}

		InformedConsentEntity newEntity = informedConsentService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link InformedConsentMutationResolver#createInformedConsent(InformedConsentEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InformedConsentEntity', 'create')")
	public List<InformedConsentEntity> createAllInformedConsent(@NonNull List<InformedConsentEntity> rawEntities) {
		List<InformedConsentEntity> newEntities = Lists.newArrayList(informedConsentService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('InformedConsentEntity', 'update')")
	public InformedConsentEntity updateInformedConsent(@NonNull InformedConsentEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getAccompanyingStaff() != null) {
			rawEntity.setAccompanyingStaff(staffService.updateOldData(rawEntity.getAccompanyingStaff()));
		}

		if (rawEntity.getPatientGeneralInfo() != null) {
			rawEntity.setPatientGeneralInfo(patientGeneralInfoService.updateOldData(rawEntity.getPatientGeneralInfo()));
		}

		if (rawEntity.getRegistration() != null) {
			rawEntity.setRegistration(registrationService.updateOldData(rawEntity.getRegistration()));
		}

		if (rawEntity.getInformingStaff() != null) {
			rawEntity.setInformingStaff(staffService.updateOldData(rawEntity.getInformingStaff()));
		}

		InformedConsentEntity entityFromDb = informedConsentService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		InformedConsentEntity newEntity = informedConsentService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link InformedConsentMutationResolver#updateInformedConsent(InformedConsentEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InformedConsentEntity', 'update')")
	public List<InformedConsentEntity> updateAllInformedConsent(@NonNull List<InformedConsentEntity> rawEntities) {
		List<InformedConsentEntity> newEntities = Lists.newArrayList(informedConsentService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('InformedConsentEntity', 'delete')")
	public String deleteInformedConsentById(@NonNull String id) {
		informedConsentService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link InformedConsentMutationResolver#deleteInformedConsentById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InformedConsentEntity', 'delete')")
	public List<String> deleteAllInformedConsentByIds(@NonNull List<String> ids) {
		informedConsentService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('InformedConsentEntity', 'delete')")
	public List<String> deleteInformedConsentExcludingIds(@NonNull List<String> ids) {
		informedConsentService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
