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
import kmsweb.entities.PatientPaymentOthersEntity;
import kmsweb.services.PatientPaymentOthersService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
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
public class PatientPaymentOthersMutationResolver implements GraphQLMutationResolver {

	private final PatientPaymentOthersService patientPaymentOthersService;

	private final PatientGeneralInfoService patientGeneralInfoService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PatientPaymentOthersMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			PatientGeneralInfoService patientGeneralInfoService,
			PatientPaymentOthersService patientPaymentOthersService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.patientPaymentOthersService = patientPaymentOthersService;

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
	@PreAuthorize("hasPermission('PatientPaymentOthersEntity', 'create')")
	public PatientPaymentOthersEntity createPatientPaymentOthers(@NonNull PatientPaymentOthersEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getPatientGeneralInformation() != null) {
			rawEntity.setPatientGeneralInformation(patientGeneralInfoService.updateOldData(rawEntity.getPatientGeneralInformation()));
		}

		PatientPaymentOthersEntity newEntity = patientPaymentOthersService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PatientPaymentOthersMutationResolver#createPatientPaymentOthers(PatientPaymentOthersEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PatientPaymentOthersEntity', 'create')")
	public List<PatientPaymentOthersEntity> createAllPatientPaymentOthers(@NonNull List<PatientPaymentOthersEntity> rawEntities) {
		List<PatientPaymentOthersEntity> newEntities = Lists.newArrayList(patientPaymentOthersService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('PatientPaymentOthersEntity', 'update')")
	public PatientPaymentOthersEntity updatePatientPaymentOthers(@NonNull PatientPaymentOthersEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getPatientGeneralInformation() != null) {
			rawEntity.setPatientGeneralInformation(patientGeneralInfoService.updateOldData(rawEntity.getPatientGeneralInformation()));
		}

		PatientPaymentOthersEntity entityFromDb = patientPaymentOthersService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		PatientPaymentOthersEntity newEntity = patientPaymentOthersService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PatientPaymentOthersMutationResolver#updatePatientPaymentOthers(PatientPaymentOthersEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PatientPaymentOthersEntity', 'update')")
	public List<PatientPaymentOthersEntity> updateAllPatientPaymentOthers(@NonNull List<PatientPaymentOthersEntity> rawEntities) {
		List<PatientPaymentOthersEntity> newEntities = Lists.newArrayList(patientPaymentOthersService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('PatientPaymentOthersEntity', 'delete')")
	public String deletePatientPaymentOthersById(@NonNull String id) {
		patientPaymentOthersService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link PatientPaymentOthersMutationResolver#deletePatientPaymentOthersById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PatientPaymentOthersEntity', 'delete')")
	public List<String> deleteAllPatientPaymentOthersByIds(@NonNull List<String> ids) {
		patientPaymentOthersService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('PatientPaymentOthersEntity', 'delete')")
	public List<String> deletePatientPaymentOthersExcludingIds(@NonNull List<String> ids) {
		patientPaymentOthersService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
