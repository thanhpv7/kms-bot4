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

package kmsweb.utils.DatabasePopulators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import kmsweb.configs.security.helpers.AnonymousHelper;
import kmsweb.entities.PatientVisitPatientPaymentInsuranceEntity;
import kmsweb.repositories.PatientVisitPatientPaymentInsuranceRepository;
import kmsweb.services.PatientVisitPatientPaymentInsuranceService;
import kmsweb.utils.PatientVisitPatientPaymentInsuranceFactory;

import javax.validation.constraints.NotNull;
import java.util.*;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Component
public class PatientVisitPatientPaymentInsuranceDatabasePopulator implements DatabasePopulatorInterface<PatientVisitPatientPaymentInsuranceEntity> {

	@Autowired
	private PatientVisitPatientPaymentInsuranceRepository patientVisitPatientPaymentInsuranceRepository;

	private final PatientVisitPatientPaymentInsuranceFactory patientVisitPatientPaymentInsuranceFactory = new PatientVisitPatientPaymentInsuranceFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public PatientVisitPatientPaymentInsuranceDatabasePopulator() {}

	/**
	 * Adds the entities that are used for this entities relations to the database, and sets the relation
	 * in the supplied entity.  The related entities will only include the required related entities, as a
	 * validator exists which stops a loop of required related entities from existing in the application.
	 * Creating a loop causes a stack overflow error when trying to create the database populator classes,
	 * so it is not allowed.
	 *
	 * As the related entities can have their own required relations, this method may call the same method for
	 * different entities.
	 *
	 * @param entity The entity to populate the relations for.  This method doesn't return the entity but
	 *               the updated entity will propagate back to the method that called it
	 * @param generateEntities Whether the entities to save should be created using the factories in this class, or sourced
	 *                         from the entity param. Please note that setting this to false while not passing in relations
	 *                         as part of the entity param will cause an IllegalArgumentException to be thrown
	 * @throws Exception When generateEntities is set to false, meaning that the entities to save are sourced
	 * 						from the related entities in the entity param, but the relation entity has not been set.
	 * 						In this case, we throw an IllegalArgumentException.  The throws is just an Exception instead of
	 * 						IllegalArgumentException because the entity factory method throws an exception
	 */
	@Override
	public void populateRelatedEntitiesInDatabase(
		@NotNull PatientVisitPatientPaymentInsuranceEntity entity,
		boolean generateEntities,
		boolean addIdToParent,
		boolean addEntityToParent) throws Exception {

		// % protected region % [Add any additional logic before main execution of 'populateRelatedEntitiesInDatabase' here] off begin
		// % protected region % [Add any additional logic before main execution of 'populateRelatedEntitiesInDatabase' here] end


		// % protected region % [Add any additional logic after main execution of 'populateRelatedEntitiesInDatabase' here] off begin
		// % protected region % [Add any additional logic after main execution of 'populateRelatedEntitiesInDatabase' here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end

}