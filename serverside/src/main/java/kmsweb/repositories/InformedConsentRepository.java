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
package kmsweb.repositories;

import kmsweb.entities.InformedConsentEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.time.*;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface InformedConsentRepository extends AbstractRepository<InformedConsentEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Patient Family Guardian Name.
	 *
	 * @param patientFamilyGuardianName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Family Guardian Name
	 */
	List<InformedConsentEntity> findByPatientFamilyGuardianName(@NotNull String patientFamilyGuardianName);
	/**
	 * Return an entity or a list of entities that have the given attribute Patient Family Guardian Relationship.
	 *
	 * @param patientFamilyGuardianRelationship the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Family Guardian Relationship
	 */
	List<InformedConsentEntity> findByPatientFamilyGuardianRelationship(@NotNull String patientFamilyGuardianRelationship);
	/**
	 * Return an entity or a list of entities that have the given attribute Procedure To Be Performed.
	 *
	 * @param procedureToBePerformed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Procedure To Be Performed
	 */
	List<InformedConsentEntity> findByProcedureToBePerformed(@NotNull String procedureToBePerformed);
	/**
	 * Return an entity or a list of entities that have the given attribute Consequence Of Procedure.
	 *
	 * @param consequenceOfProcedure the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consequence Of Procedure
	 */
	List<InformedConsentEntity> findByConsequenceOfProcedure(@NotNull String consequenceOfProcedure);
	/**
	 * Return an entity or a list of entities that have the given attribute Consent On Procedure.
	 *
	 * @param consentOnProcedure the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consent On Procedure
	 */
	List<InformedConsentEntity> findByConsentOnProcedure(@NotNull String consentOnProcedure);
	/**
	 * Return an entity or a list of entities that have the given attribute Consent Date Time.
	 *
	 * @param consentDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consent Date Time
	 */
	List<InformedConsentEntity> findByConsentDateTime(@NotNull OffsetDateTime consentDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Informing Staff Signature.
	 *
	 * @param informingStaffSignature the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Informing Staff Signature
	 */
	List<InformedConsentEntity> findByInformingStaffSignature(@NotNull String informingStaffSignature);
	/**
	 * Return an entity or a list of entities that have the given attribute Consenting Party Signature.
	 *
	 * @param consentingPartySignature the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consenting Party Signature
	 */
	List<InformedConsentEntity> findByConsentingPartySignature(@NotNull String consentingPartySignature);
	/**
	 * Return an entity or a list of entities that have the given attribute Consenting Party Type.
	 *
	 * @param consentingPartyType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consenting Party Type
	 */
	List<InformedConsentEntity> findByConsentingPartyType(@NotNull String consentingPartyType);
	/**
	 * Return an entity or a list of entities that have the given attribute Consenting Party Name.
	 *
	 * @param consentingPartyName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consenting Party Name
	 */
	List<InformedConsentEntity> findByConsentingPartyName(@NotNull String consentingPartyName);
	/**
	 * Return an entity or a list of entities that have the given attribute Witness Signature 1.
	 *
	 * @param witnessSignature1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Witness Signature 1
	 */
	List<InformedConsentEntity> findByWitnessSignature1(@NotNull String witnessSignature1);
	/**
	 * Return an entity or a list of entities that have the given attribute Witness Name 1.
	 *
	 * @param witnessName1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Witness Name 1
	 */
	List<InformedConsentEntity> findByWitnessName1(@NotNull String witnessName1);
	/**
	 * Return an entity or a list of entities that have the given attribute Witness Signature 2.
	 *
	 * @param witnessSignature2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Witness Signature 2
	 */
	List<InformedConsentEntity> findByWitnessSignature2(@NotNull String witnessSignature2);
	/**
	 * Return an entity or a list of entities that have the given attribute Witness Name 2.
	 *
	 * @param witnessName2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Witness Name 2
	 */
	List<InformedConsentEntity> findByWitnessName2(@NotNull String witnessName2);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<InformedConsentEntity> findByNotes(@NotNull String notes);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InformedConsentEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InformedConsentEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}