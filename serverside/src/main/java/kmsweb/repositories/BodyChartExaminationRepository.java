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

import kmsweb.entities.BodyChartExaminationEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface BodyChartExaminationRepository extends AbstractRepository<BodyChartExaminationEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute BC01 Subjective.
	 *
	 * @param bc01Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC01 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc01Subjective(@NotNull String bc01Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC01 Objective.
	 *
	 * @param bc01Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC01 Objective
	 */
	List<BodyChartExaminationEntity> findByBc01Objective(@NotNull String bc01Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC02 Subjective.
	 *
	 * @param bc02Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC02 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc02Subjective(@NotNull String bc02Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC02 Objective.
	 *
	 * @param bc02Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC02 Objective
	 */
	List<BodyChartExaminationEntity> findByBc02Objective(@NotNull String bc02Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC03 Subjective.
	 *
	 * @param bc03Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC03 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc03Subjective(@NotNull String bc03Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC03 Objective.
	 *
	 * @param bc03Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC03 Objective
	 */
	List<BodyChartExaminationEntity> findByBc03Objective(@NotNull String bc03Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC04 Subjective.
	 *
	 * @param bc04Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC04 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc04Subjective(@NotNull String bc04Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC04 Objective.
	 *
	 * @param bc04Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC04 Objective
	 */
	List<BodyChartExaminationEntity> findByBc04Objective(@NotNull String bc04Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC05 Subjective.
	 *
	 * @param bc05Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC05 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc05Subjective(@NotNull String bc05Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC05 Objective.
	 *
	 * @param bc05Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC05 Objective
	 */
	List<BodyChartExaminationEntity> findByBc05Objective(@NotNull String bc05Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC06 Subjective.
	 *
	 * @param bc06Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC06 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc06Subjective(@NotNull String bc06Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC06 Objective.
	 *
	 * @param bc06Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC06 Objective
	 */
	List<BodyChartExaminationEntity> findByBc06Objective(@NotNull String bc06Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC07 Subjective.
	 *
	 * @param bc07Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC07 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc07Subjective(@NotNull String bc07Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC07 Objective.
	 *
	 * @param bc07Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC07 Objective
	 */
	List<BodyChartExaminationEntity> findByBc07Objective(@NotNull String bc07Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC08 Subjective.
	 *
	 * @param bc08Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC08 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc08Subjective(@NotNull String bc08Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC08 Objective.
	 *
	 * @param bc08Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC08 Objective
	 */
	List<BodyChartExaminationEntity> findByBc08Objective(@NotNull String bc08Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC09 Subjective.
	 *
	 * @param bc09Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC09 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc09Subjective(@NotNull String bc09Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC09 Objective.
	 *
	 * @param bc09Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC09 Objective
	 */
	List<BodyChartExaminationEntity> findByBc09Objective(@NotNull String bc09Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC10 Subjective.
	 *
	 * @param bc10Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC10 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc10Subjective(@NotNull String bc10Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC10 Objective.
	 *
	 * @param bc10Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC10 Objective
	 */
	List<BodyChartExaminationEntity> findByBc10Objective(@NotNull String bc10Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC11 Subjective.
	 *
	 * @param bc11Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC11 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc11Subjective(@NotNull String bc11Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC11 Objective.
	 *
	 * @param bc11Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC11 Objective
	 */
	List<BodyChartExaminationEntity> findByBc11Objective(@NotNull String bc11Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC12 Subjective.
	 *
	 * @param bc12Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC12 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc12Subjective(@NotNull String bc12Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC12 Objective.
	 *
	 * @param bc12Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC12 Objective
	 */
	List<BodyChartExaminationEntity> findByBc12Objective(@NotNull String bc12Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC13 Subjective.
	 *
	 * @param bc13Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC13 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc13Subjective(@NotNull String bc13Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC13 Objective.
	 *
	 * @param bc13Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC13 Objective
	 */
	List<BodyChartExaminationEntity> findByBc13Objective(@NotNull String bc13Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC14 Subjective.
	 *
	 * @param bc14Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC14 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc14Subjective(@NotNull String bc14Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC14 Objective.
	 *
	 * @param bc14Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC14 Objective
	 */
	List<BodyChartExaminationEntity> findByBc14Objective(@NotNull String bc14Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC15 Subjective.
	 *
	 * @param bc15Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC15 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc15Subjective(@NotNull String bc15Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC15 Objective.
	 *
	 * @param bc15Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC15 Objective
	 */
	List<BodyChartExaminationEntity> findByBc15Objective(@NotNull String bc15Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC16 Subjective.
	 *
	 * @param bc16Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC16 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc16Subjective(@NotNull String bc16Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC16 Objective.
	 *
	 * @param bc16Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC16 Objective
	 */
	List<BodyChartExaminationEntity> findByBc16Objective(@NotNull String bc16Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC17 Subjective.
	 *
	 * @param bc17Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC17 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc17Subjective(@NotNull String bc17Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC17 Objective.
	 *
	 * @param bc17Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC17 Objective
	 */
	List<BodyChartExaminationEntity> findByBc17Objective(@NotNull String bc17Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC18 Subjective.
	 *
	 * @param bc18Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC18 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc18Subjective(@NotNull String bc18Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC18 Objective.
	 *
	 * @param bc18Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC18 Objective
	 */
	List<BodyChartExaminationEntity> findByBc18Objective(@NotNull String bc18Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC19 Subjective.
	 *
	 * @param bc19Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC19 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc19Subjective(@NotNull String bc19Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC19 Objective.
	 *
	 * @param bc19Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC19 Objective
	 */
	List<BodyChartExaminationEntity> findByBc19Objective(@NotNull String bc19Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC20 Subjective.
	 *
	 * @param bc20Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC20 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc20Subjective(@NotNull String bc20Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC20 Objective.
	 *
	 * @param bc20Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC20 Objective
	 */
	List<BodyChartExaminationEntity> findByBc20Objective(@NotNull String bc20Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC21 Subjective.
	 *
	 * @param bc21Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC21 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc21Subjective(@NotNull String bc21Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC21 Objective.
	 *
	 * @param bc21Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC21 Objective
	 */
	List<BodyChartExaminationEntity> findByBc21Objective(@NotNull String bc21Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC22 Subjective.
	 *
	 * @param bc22Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC22 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc22Subjective(@NotNull String bc22Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC22 Objective.
	 *
	 * @param bc22Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC22 Objective
	 */
	List<BodyChartExaminationEntity> findByBc22Objective(@NotNull String bc22Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC23 Subjective.
	 *
	 * @param bc23Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC23 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc23Subjective(@NotNull String bc23Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC23 Objective.
	 *
	 * @param bc23Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC23 Objective
	 */
	List<BodyChartExaminationEntity> findByBc23Objective(@NotNull String bc23Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC24 Subjective.
	 *
	 * @param bc24Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC24 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc24Subjective(@NotNull String bc24Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC24 Objective.
	 *
	 * @param bc24Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC24 Objective
	 */
	List<BodyChartExaminationEntity> findByBc24Objective(@NotNull String bc24Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC25 Subjective.
	 *
	 * @param bc25Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC25 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc25Subjective(@NotNull String bc25Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC25 Objective.
	 *
	 * @param bc25Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC25 Objective
	 */
	List<BodyChartExaminationEntity> findByBc25Objective(@NotNull String bc25Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC26 Subjective.
	 *
	 * @param bc26Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC26 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc26Subjective(@NotNull String bc26Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC26 Objective.
	 *
	 * @param bc26Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC26 Objective
	 */
	List<BodyChartExaminationEntity> findByBc26Objective(@NotNull String bc26Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC27 Subjective.
	 *
	 * @param bc27Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC27 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc27Subjective(@NotNull String bc27Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC27 Objective.
	 *
	 * @param bc27Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC27 Objective
	 */
	List<BodyChartExaminationEntity> findByBc27Objective(@NotNull String bc27Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC28 Subjective.
	 *
	 * @param bc28Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC28 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc28Subjective(@NotNull String bc28Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC28 Objective.
	 *
	 * @param bc28Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC28 Objective
	 */
	List<BodyChartExaminationEntity> findByBc28Objective(@NotNull String bc28Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC29 Subjective.
	 *
	 * @param bc29Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC29 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc29Subjective(@NotNull String bc29Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC29 Objective.
	 *
	 * @param bc29Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC29 Objective
	 */
	List<BodyChartExaminationEntity> findByBc29Objective(@NotNull String bc29Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC30 Subjective.
	 *
	 * @param bc30Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC30 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc30Subjective(@NotNull String bc30Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC30 Objective.
	 *
	 * @param bc30Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC30 Objective
	 */
	List<BodyChartExaminationEntity> findByBc30Objective(@NotNull String bc30Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC31 Subjective.
	 *
	 * @param bc31Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC31 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc31Subjective(@NotNull String bc31Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC31 Objective.
	 *
	 * @param bc31Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC31 Objective
	 */
	List<BodyChartExaminationEntity> findByBc31Objective(@NotNull String bc31Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC32 Subjective.
	 *
	 * @param bc32Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC32 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc32Subjective(@NotNull String bc32Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC32 Objective.
	 *
	 * @param bc32Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC32 Objective
	 */
	List<BodyChartExaminationEntity> findByBc32Objective(@NotNull String bc32Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC33 Subjective.
	 *
	 * @param bc33Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC33 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc33Subjective(@NotNull String bc33Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC33 Objective.
	 *
	 * @param bc33Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC33 Objective
	 */
	List<BodyChartExaminationEntity> findByBc33Objective(@NotNull String bc33Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC34 Subjective.
	 *
	 * @param bc34Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC34 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc34Subjective(@NotNull String bc34Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC34 Objective.
	 *
	 * @param bc34Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC34 Objective
	 */
	List<BodyChartExaminationEntity> findByBc34Objective(@NotNull String bc34Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC35 Subjective.
	 *
	 * @param bc35Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC35 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc35Subjective(@NotNull String bc35Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC35 Objective.
	 *
	 * @param bc35Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC35 Objective
	 */
	List<BodyChartExaminationEntity> findByBc35Objective(@NotNull String bc35Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC36 Subjective.
	 *
	 * @param bc36Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC36 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc36Subjective(@NotNull String bc36Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC36 Objective.
	 *
	 * @param bc36Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC36 Objective
	 */
	List<BodyChartExaminationEntity> findByBc36Objective(@NotNull String bc36Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC37 Subjective.
	 *
	 * @param bc37Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC37 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc37Subjective(@NotNull String bc37Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC37 Objective.
	 *
	 * @param bc37Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC37 Objective
	 */
	List<BodyChartExaminationEntity> findByBc37Objective(@NotNull String bc37Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC38 Subjective.
	 *
	 * @param bc38Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC38 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc38Subjective(@NotNull String bc38Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC38 Objective.
	 *
	 * @param bc38Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC38 Objective
	 */
	List<BodyChartExaminationEntity> findByBc38Objective(@NotNull String bc38Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC39 Subjective.
	 *
	 * @param bc39Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC39 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc39Subjective(@NotNull String bc39Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC39 Objective.
	 *
	 * @param bc39Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC39 Objective
	 */
	List<BodyChartExaminationEntity> findByBc39Objective(@NotNull String bc39Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC40 Subjective.
	 *
	 * @param bc40Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC40 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc40Subjective(@NotNull String bc40Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC40 Objective.
	 *
	 * @param bc40Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC40 Objective
	 */
	List<BodyChartExaminationEntity> findByBc40Objective(@NotNull String bc40Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC41 Subjective.
	 *
	 * @param bc41Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC41 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc41Subjective(@NotNull String bc41Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC41 Objective.
	 *
	 * @param bc41Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC41 Objective
	 */
	List<BodyChartExaminationEntity> findByBc41Objective(@NotNull String bc41Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC42 Subjective.
	 *
	 * @param bc42Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC42 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc42Subjective(@NotNull String bc42Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC42 Objective.
	 *
	 * @param bc42Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC42 Objective
	 */
	List<BodyChartExaminationEntity> findByBc42Objective(@NotNull String bc42Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC43 Subjective.
	 *
	 * @param bc43Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC43 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc43Subjective(@NotNull String bc43Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC43 Objective.
	 *
	 * @param bc43Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC43 Objective
	 */
	List<BodyChartExaminationEntity> findByBc43Objective(@NotNull String bc43Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC44 Subjective.
	 *
	 * @param bc44Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC44 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc44Subjective(@NotNull String bc44Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC44 Objective.
	 *
	 * @param bc44Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC44 Objective
	 */
	List<BodyChartExaminationEntity> findByBc44Objective(@NotNull String bc44Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC45 Subjective.
	 *
	 * @param bc45Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC45 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc45Subjective(@NotNull String bc45Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC45 Objective.
	 *
	 * @param bc45Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC45 Objective
	 */
	List<BodyChartExaminationEntity> findByBc45Objective(@NotNull String bc45Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC46 Subjective.
	 *
	 * @param bc46Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC46 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc46Subjective(@NotNull String bc46Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC46 Objective.
	 *
	 * @param bc46Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC46 Objective
	 */
	List<BodyChartExaminationEntity> findByBc46Objective(@NotNull String bc46Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC47 Subjective.
	 *
	 * @param bc47Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC47 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc47Subjective(@NotNull String bc47Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC47 Objective.
	 *
	 * @param bc47Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC47 Objective
	 */
	List<BodyChartExaminationEntity> findByBc47Objective(@NotNull String bc47Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC48 Subjective.
	 *
	 * @param bc48Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC48 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc48Subjective(@NotNull String bc48Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC48 Objective.
	 *
	 * @param bc48Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC48 Objective
	 */
	List<BodyChartExaminationEntity> findByBc48Objective(@NotNull String bc48Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC49 Subjective.
	 *
	 * @param bc49Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC49 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc49Subjective(@NotNull String bc49Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC49 Objective.
	 *
	 * @param bc49Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC49 Objective
	 */
	List<BodyChartExaminationEntity> findByBc49Objective(@NotNull String bc49Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC50 Subjective.
	 *
	 * @param bc50Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC50 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc50Subjective(@NotNull String bc50Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC50 Objective.
	 *
	 * @param bc50Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC50 Objective
	 */
	List<BodyChartExaminationEntity> findByBc50Objective(@NotNull String bc50Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC51 Subjective.
	 *
	 * @param bc51Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC51 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc51Subjective(@NotNull String bc51Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC51 Objective.
	 *
	 * @param bc51Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC51 Objective
	 */
	List<BodyChartExaminationEntity> findByBc51Objective(@NotNull String bc51Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC52 Subjective.
	 *
	 * @param bc52Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC52 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc52Subjective(@NotNull String bc52Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC52 Objective.
	 *
	 * @param bc52Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC52 Objective
	 */
	List<BodyChartExaminationEntity> findByBc52Objective(@NotNull String bc52Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC53 Subjective.
	 *
	 * @param bc53Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC53 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc53Subjective(@NotNull String bc53Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC53 Objective.
	 *
	 * @param bc53Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC53 Objective
	 */
	List<BodyChartExaminationEntity> findByBc53Objective(@NotNull String bc53Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC54 Subjective.
	 *
	 * @param bc54Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC54 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc54Subjective(@NotNull String bc54Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC54 Objective.
	 *
	 * @param bc54Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC54 Objective
	 */
	List<BodyChartExaminationEntity> findByBc54Objective(@NotNull String bc54Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC55 Subjective.
	 *
	 * @param bc55Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC55 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc55Subjective(@NotNull String bc55Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC55 Objective.
	 *
	 * @param bc55Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC55 Objective
	 */
	List<BodyChartExaminationEntity> findByBc55Objective(@NotNull String bc55Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC56 Subjective.
	 *
	 * @param bc56Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC56 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc56Subjective(@NotNull String bc56Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC56 Objective.
	 *
	 * @param bc56Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC56 Objective
	 */
	List<BodyChartExaminationEntity> findByBc56Objective(@NotNull String bc56Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC57 Subjective.
	 *
	 * @param bc57Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC57 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc57Subjective(@NotNull String bc57Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC57 Objective.
	 *
	 * @param bc57Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC57 Objective
	 */
	List<BodyChartExaminationEntity> findByBc57Objective(@NotNull String bc57Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC58 Subjective.
	 *
	 * @param bc58Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC58 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc58Subjective(@NotNull String bc58Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC58 Objective.
	 *
	 * @param bc58Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC58 Objective
	 */
	List<BodyChartExaminationEntity> findByBc58Objective(@NotNull String bc58Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC59 Subjective.
	 *
	 * @param bc59Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC59 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc59Subjective(@NotNull String bc59Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC59 Objective.
	 *
	 * @param bc59Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC59 Objective
	 */
	List<BodyChartExaminationEntity> findByBc59Objective(@NotNull String bc59Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC60 Subjective.
	 *
	 * @param bc60Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC60 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc60Subjective(@NotNull String bc60Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC60 Objective.
	 *
	 * @param bc60Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC60 Objective
	 */
	List<BodyChartExaminationEntity> findByBc60Objective(@NotNull String bc60Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC61 Subjective.
	 *
	 * @param bc61Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC61 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc61Subjective(@NotNull String bc61Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC61 Objective.
	 *
	 * @param bc61Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC61 Objective
	 */
	List<BodyChartExaminationEntity> findByBc61Objective(@NotNull String bc61Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC62 Subjective.
	 *
	 * @param bc62Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC62 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc62Subjective(@NotNull String bc62Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC62 Objective.
	 *
	 * @param bc62Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC62 Objective
	 */
	List<BodyChartExaminationEntity> findByBc62Objective(@NotNull String bc62Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC63 Subjective.
	 *
	 * @param bc63Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC63 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc63Subjective(@NotNull String bc63Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC63 Objective.
	 *
	 * @param bc63Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC63 Objective
	 */
	List<BodyChartExaminationEntity> findByBc63Objective(@NotNull String bc63Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC64 Subjective.
	 *
	 * @param bc64Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC64 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc64Subjective(@NotNull String bc64Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC64 Objective.
	 *
	 * @param bc64Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC64 Objective
	 */
	List<BodyChartExaminationEntity> findByBc64Objective(@NotNull String bc64Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC65 Subjective.
	 *
	 * @param bc65Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC65 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc65Subjective(@NotNull String bc65Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC65 Objective.
	 *
	 * @param bc65Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC65 Objective
	 */
	List<BodyChartExaminationEntity> findByBc65Objective(@NotNull String bc65Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC66 Subjective.
	 *
	 * @param bc66Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC66 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc66Subjective(@NotNull String bc66Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC66 Objective.
	 *
	 * @param bc66Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC66 Objective
	 */
	List<BodyChartExaminationEntity> findByBc66Objective(@NotNull String bc66Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC67 Subjective.
	 *
	 * @param bc67Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC67 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc67Subjective(@NotNull String bc67Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC67 Objective.
	 *
	 * @param bc67Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC67 Objective
	 */
	List<BodyChartExaminationEntity> findByBc67Objective(@NotNull String bc67Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC68 Subjective.
	 *
	 * @param bc68Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC68 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc68Subjective(@NotNull String bc68Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC68 Objective.
	 *
	 * @param bc68Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC68 Objective
	 */
	List<BodyChartExaminationEntity> findByBc68Objective(@NotNull String bc68Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC69 Subjective.
	 *
	 * @param bc69Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC69 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc69Subjective(@NotNull String bc69Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC69 Objective.
	 *
	 * @param bc69Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC69 Objective
	 */
	List<BodyChartExaminationEntity> findByBc69Objective(@NotNull String bc69Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC70 Subjective.
	 *
	 * @param bc70Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC70 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc70Subjective(@NotNull String bc70Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC70 Objective.
	 *
	 * @param bc70Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC70 Objective
	 */
	List<BodyChartExaminationEntity> findByBc70Objective(@NotNull String bc70Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC71 Subjective.
	 *
	 * @param bc71Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC71 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc71Subjective(@NotNull String bc71Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC71 Objective.
	 *
	 * @param bc71Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC71 Objective
	 */
	List<BodyChartExaminationEntity> findByBc71Objective(@NotNull String bc71Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC72 Subjective.
	 *
	 * @param bc72Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC72 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc72Subjective(@NotNull String bc72Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC72 Objective.
	 *
	 * @param bc72Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC72 Objective
	 */
	List<BodyChartExaminationEntity> findByBc72Objective(@NotNull String bc72Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC73 Subjective.
	 *
	 * @param bc73Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC73 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc73Subjective(@NotNull String bc73Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC73 Objective.
	 *
	 * @param bc73Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC73 Objective
	 */
	List<BodyChartExaminationEntity> findByBc73Objective(@NotNull String bc73Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC74 Subjective.
	 *
	 * @param bc74Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC74 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc74Subjective(@NotNull String bc74Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC74 Objective.
	 *
	 * @param bc74Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC74 Objective
	 */
	List<BodyChartExaminationEntity> findByBc74Objective(@NotNull String bc74Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC75 Subjective.
	 *
	 * @param bc75Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC75 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc75Subjective(@NotNull String bc75Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC75 Objective.
	 *
	 * @param bc75Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC75 Objective
	 */
	List<BodyChartExaminationEntity> findByBc75Objective(@NotNull String bc75Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC76 Subjective.
	 *
	 * @param bc76Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC76 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc76Subjective(@NotNull String bc76Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC76 Objective.
	 *
	 * @param bc76Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC76 Objective
	 */
	List<BodyChartExaminationEntity> findByBc76Objective(@NotNull String bc76Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC77 Subjective.
	 *
	 * @param bc77Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC77 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc77Subjective(@NotNull String bc77Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC77 Objective.
	 *
	 * @param bc77Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC77 Objective
	 */
	List<BodyChartExaminationEntity> findByBc77Objective(@NotNull String bc77Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC78 Subjective.
	 *
	 * @param bc78Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC78 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc78Subjective(@NotNull String bc78Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC78 Objective.
	 *
	 * @param bc78Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC78 Objective
	 */
	List<BodyChartExaminationEntity> findByBc78Objective(@NotNull String bc78Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC79 Subjective.
	 *
	 * @param bc79Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC79 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc79Subjective(@NotNull String bc79Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC79 Objective.
	 *
	 * @param bc79Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC79 Objective
	 */
	List<BodyChartExaminationEntity> findByBc79Objective(@NotNull String bc79Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC80 Subjective.
	 *
	 * @param bc80Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC80 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc80Subjective(@NotNull String bc80Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC80 Objective.
	 *
	 * @param bc80Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC80 Objective
	 */
	List<BodyChartExaminationEntity> findByBc80Objective(@NotNull String bc80Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC81 Subjective.
	 *
	 * @param bc81Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC81 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc81Subjective(@NotNull String bc81Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC81 Objective.
	 *
	 * @param bc81Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC81 Objective
	 */
	List<BodyChartExaminationEntity> findByBc81Objective(@NotNull String bc81Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC82 Subjective.
	 *
	 * @param bc82Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC82 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc82Subjective(@NotNull String bc82Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC82 Objective.
	 *
	 * @param bc82Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC82 Objective
	 */
	List<BodyChartExaminationEntity> findByBc82Objective(@NotNull String bc82Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC83 Subjective.
	 *
	 * @param bc83Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC83 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc83Subjective(@NotNull String bc83Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC83 Objective.
	 *
	 * @param bc83Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC83 Objective
	 */
	List<BodyChartExaminationEntity> findByBc83Objective(@NotNull String bc83Objective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC84 Subjective.
	 *
	 * @param bc84Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC84 Subjective
	 */
	List<BodyChartExaminationEntity> findByBc84Subjective(@NotNull String bc84Subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute BC84 Objective.
	 *
	 * @param bc84Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC84 Objective
	 */
	List<BodyChartExaminationEntity> findByBc84Objective(@NotNull String bc84Objective);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BodyChartExaminationEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BodyChartExaminationEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}