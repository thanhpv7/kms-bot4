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
import kmsweb.entities.MedicalCertificateBirthEntity;
import kmsweb.services.MedicalCertificateBirthService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
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
public class MedicalCertificateBirthMutationResolver implements GraphQLMutationResolver {

	private final MedicalCertificateBirthService medicalCertificateBirthService;

	private final RegistrationService registrationService;

	private final StaffService staffService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public MedicalCertificateBirthMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			RegistrationService registrationService,
			StaffService staffService,
			MedicalCertificateBirthService medicalCertificateBirthService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.medicalCertificateBirthService = medicalCertificateBirthService;

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
	@PreAuthorize("hasPermission('MedicalCertificateBirthEntity', 'create')")
	public MedicalCertificateBirthEntity createMedicalCertificateBirth(@NonNull MedicalCertificateBirthEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getRegistration() != null) {
			rawEntity.setRegistration(registrationService.updateOldData(rawEntity.getRegistration()));
		}

		if (rawEntity.getMedicalStaff() != null) {
			rawEntity.setMedicalStaff(staffService.updateOldData(rawEntity.getMedicalStaff()));
		}

		MedicalCertificateBirthEntity newEntity = medicalCertificateBirthService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link MedicalCertificateBirthMutationResolver#createMedicalCertificateBirth(MedicalCertificateBirthEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('MedicalCertificateBirthEntity', 'create')")
	public List<MedicalCertificateBirthEntity> createAllMedicalCertificateBirth(@NonNull List<MedicalCertificateBirthEntity> rawEntities) {
		List<MedicalCertificateBirthEntity> newEntities = Lists.newArrayList(medicalCertificateBirthService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('MedicalCertificateBirthEntity', 'update')")
	public MedicalCertificateBirthEntity updateMedicalCertificateBirth(@NonNull MedicalCertificateBirthEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getRegistration() != null) {
			rawEntity.setRegistration(registrationService.updateOldData(rawEntity.getRegistration()));
		}

		if (rawEntity.getMedicalStaff() != null) {
			rawEntity.setMedicalStaff(staffService.updateOldData(rawEntity.getMedicalStaff()));
		}

		MedicalCertificateBirthEntity entityFromDb = medicalCertificateBirthService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		MedicalCertificateBirthEntity newEntity = medicalCertificateBirthService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link MedicalCertificateBirthMutationResolver#updateMedicalCertificateBirth(MedicalCertificateBirthEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('MedicalCertificateBirthEntity', 'update')")
	public List<MedicalCertificateBirthEntity> updateAllMedicalCertificateBirth(@NonNull List<MedicalCertificateBirthEntity> rawEntities) {
		List<MedicalCertificateBirthEntity> newEntities = Lists.newArrayList(medicalCertificateBirthService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('MedicalCertificateBirthEntity', 'delete')")
	public String deleteMedicalCertificateBirthById(@NonNull String id) {
		medicalCertificateBirthService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link MedicalCertificateBirthMutationResolver#deleteMedicalCertificateBirthById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('MedicalCertificateBirthEntity', 'delete')")
	public List<String> deleteAllMedicalCertificateBirthByIds(@NonNull List<String> ids) {
		medicalCertificateBirthService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('MedicalCertificateBirthEntity', 'delete')")
	public List<String> deleteMedicalCertificateBirthExcludingIds(@NonNull List<String> ids) {
		medicalCertificateBirthService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
