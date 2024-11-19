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

package kmsweb.utils;

import org.springframework.beans.factory.FactoryBean;
import kmsweb.entities.BodyChartExaminationEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BodyChartExaminationFactory implements FactoryBean<BodyChartExaminationEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BodyChartExaminationEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BodyChartExaminationEntity getObjectWithReferences(boolean includeIds) throws Exception {
		return getObject(true, includeIds);
	}

	/**
	 * Create an example instance of the entity.
	 *
	 * @param includeReferences Populate at least a single instance of each reference as a materialised object.
	 * 	We don't set the ids fields as there is no guarantee that these values exist at this stage.
	 * @param includeId Should IDs be set for the base object and the references
	 * @return A sample object
	 * @throws Exception
	 */
	public BodyChartExaminationEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bodyChartExaminationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bodyChartExaminationWithNoRef before the main body here] end

		BodyChartExaminationEntity newEntity = new BodyChartExaminationEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for BC01 Subjective here] off begin
		String randomStringForBc01Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc01Subjective(randomStringForBc01Subjective);
		// % protected region % [Add customisation for BC01 Subjective here] end
		// % protected region % [Add customisation for BC01 Objective here] off begin
		String randomStringForBc01Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc01Objective(randomStringForBc01Objective);
		// % protected region % [Add customisation for BC01 Objective here] end
		// % protected region % [Add customisation for BC02 Subjective here] off begin
		String randomStringForBc02Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc02Subjective(randomStringForBc02Subjective);
		// % protected region % [Add customisation for BC02 Subjective here] end
		// % protected region % [Add customisation for BC02 Objective here] off begin
		String randomStringForBc02Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc02Objective(randomStringForBc02Objective);
		// % protected region % [Add customisation for BC02 Objective here] end
		// % protected region % [Add customisation for BC03 Subjective here] off begin
		String randomStringForBc03Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc03Subjective(randomStringForBc03Subjective);
		// % protected region % [Add customisation for BC03 Subjective here] end
		// % protected region % [Add customisation for BC03 Objective here] off begin
		String randomStringForBc03Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc03Objective(randomStringForBc03Objective);
		// % protected region % [Add customisation for BC03 Objective here] end
		// % protected region % [Add customisation for BC04 Subjective here] off begin
		String randomStringForBc04Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc04Subjective(randomStringForBc04Subjective);
		// % protected region % [Add customisation for BC04 Subjective here] end
		// % protected region % [Add customisation for BC04 Objective here] off begin
		String randomStringForBc04Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc04Objective(randomStringForBc04Objective);
		// % protected region % [Add customisation for BC04 Objective here] end
		// % protected region % [Add customisation for BC05 Subjective here] off begin
		String randomStringForBc05Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc05Subjective(randomStringForBc05Subjective);
		// % protected region % [Add customisation for BC05 Subjective here] end
		// % protected region % [Add customisation for BC05 Objective here] off begin
		String randomStringForBc05Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc05Objective(randomStringForBc05Objective);
		// % protected region % [Add customisation for BC05 Objective here] end
		// % protected region % [Add customisation for BC06 Subjective here] off begin
		String randomStringForBc06Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc06Subjective(randomStringForBc06Subjective);
		// % protected region % [Add customisation for BC06 Subjective here] end
		// % protected region % [Add customisation for BC06 Objective here] off begin
		String randomStringForBc06Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc06Objective(randomStringForBc06Objective);
		// % protected region % [Add customisation for BC06 Objective here] end
		// % protected region % [Add customisation for BC07 Subjective here] off begin
		String randomStringForBc07Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc07Subjective(randomStringForBc07Subjective);
		// % protected region % [Add customisation for BC07 Subjective here] end
		// % protected region % [Add customisation for BC07 Objective here] off begin
		String randomStringForBc07Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc07Objective(randomStringForBc07Objective);
		// % protected region % [Add customisation for BC07 Objective here] end
		// % protected region % [Add customisation for BC08 Subjective here] off begin
		String randomStringForBc08Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc08Subjective(randomStringForBc08Subjective);
		// % protected region % [Add customisation for BC08 Subjective here] end
		// % protected region % [Add customisation for BC08 Objective here] off begin
		String randomStringForBc08Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc08Objective(randomStringForBc08Objective);
		// % protected region % [Add customisation for BC08 Objective here] end
		// % protected region % [Add customisation for BC09 Subjective here] off begin
		String randomStringForBc09Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc09Subjective(randomStringForBc09Subjective);
		// % protected region % [Add customisation for BC09 Subjective here] end
		// % protected region % [Add customisation for BC09 Objective here] off begin
		String randomStringForBc09Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc09Objective(randomStringForBc09Objective);
		// % protected region % [Add customisation for BC09 Objective here] end
		// % protected region % [Add customisation for BC10 Subjective here] off begin
		String randomStringForBc10Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc10Subjective(randomStringForBc10Subjective);
		// % protected region % [Add customisation for BC10 Subjective here] end
		// % protected region % [Add customisation for BC10 Objective here] off begin
		String randomStringForBc10Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc10Objective(randomStringForBc10Objective);
		// % protected region % [Add customisation for BC10 Objective here] end
		// % protected region % [Add customisation for BC11 Subjective here] off begin
		String randomStringForBc11Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc11Subjective(randomStringForBc11Subjective);
		// % protected region % [Add customisation for BC11 Subjective here] end
		// % protected region % [Add customisation for BC11 Objective here] off begin
		String randomStringForBc11Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc11Objective(randomStringForBc11Objective);
		// % protected region % [Add customisation for BC11 Objective here] end
		// % protected region % [Add customisation for BC12 Subjective here] off begin
		String randomStringForBc12Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc12Subjective(randomStringForBc12Subjective);
		// % protected region % [Add customisation for BC12 Subjective here] end
		// % protected region % [Add customisation for BC12 Objective here] off begin
		String randomStringForBc12Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc12Objective(randomStringForBc12Objective);
		// % protected region % [Add customisation for BC12 Objective here] end
		// % protected region % [Add customisation for BC13 Subjective here] off begin
		String randomStringForBc13Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc13Subjective(randomStringForBc13Subjective);
		// % protected region % [Add customisation for BC13 Subjective here] end
		// % protected region % [Add customisation for BC13 Objective here] off begin
		String randomStringForBc13Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc13Objective(randomStringForBc13Objective);
		// % protected region % [Add customisation for BC13 Objective here] end
		// % protected region % [Add customisation for BC14 Subjective here] off begin
		String randomStringForBc14Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc14Subjective(randomStringForBc14Subjective);
		// % protected region % [Add customisation for BC14 Subjective here] end
		// % protected region % [Add customisation for BC14 Objective here] off begin
		String randomStringForBc14Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc14Objective(randomStringForBc14Objective);
		// % protected region % [Add customisation for BC14 Objective here] end
		// % protected region % [Add customisation for BC15 Subjective here] off begin
		String randomStringForBc15Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc15Subjective(randomStringForBc15Subjective);
		// % protected region % [Add customisation for BC15 Subjective here] end
		// % protected region % [Add customisation for BC15 Objective here] off begin
		String randomStringForBc15Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc15Objective(randomStringForBc15Objective);
		// % protected region % [Add customisation for BC15 Objective here] end
		// % protected region % [Add customisation for BC16 Subjective here] off begin
		String randomStringForBc16Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc16Subjective(randomStringForBc16Subjective);
		// % protected region % [Add customisation for BC16 Subjective here] end
		// % protected region % [Add customisation for BC16 Objective here] off begin
		String randomStringForBc16Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc16Objective(randomStringForBc16Objective);
		// % protected region % [Add customisation for BC16 Objective here] end
		// % protected region % [Add customisation for BC17 Subjective here] off begin
		String randomStringForBc17Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc17Subjective(randomStringForBc17Subjective);
		// % protected region % [Add customisation for BC17 Subjective here] end
		// % protected region % [Add customisation for BC17 Objective here] off begin
		String randomStringForBc17Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc17Objective(randomStringForBc17Objective);
		// % protected region % [Add customisation for BC17 Objective here] end
		// % protected region % [Add customisation for BC18 Subjective here] off begin
		String randomStringForBc18Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc18Subjective(randomStringForBc18Subjective);
		// % protected region % [Add customisation for BC18 Subjective here] end
		// % protected region % [Add customisation for BC18 Objective here] off begin
		String randomStringForBc18Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc18Objective(randomStringForBc18Objective);
		// % protected region % [Add customisation for BC18 Objective here] end
		// % protected region % [Add customisation for BC19 Subjective here] off begin
		String randomStringForBc19Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc19Subjective(randomStringForBc19Subjective);
		// % protected region % [Add customisation for BC19 Subjective here] end
		// % protected region % [Add customisation for BC19 Objective here] off begin
		String randomStringForBc19Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc19Objective(randomStringForBc19Objective);
		// % protected region % [Add customisation for BC19 Objective here] end
		// % protected region % [Add customisation for BC20 Subjective here] off begin
		String randomStringForBc20Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc20Subjective(randomStringForBc20Subjective);
		// % protected region % [Add customisation for BC20 Subjective here] end
		// % protected region % [Add customisation for BC20 Objective here] off begin
		String randomStringForBc20Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc20Objective(randomStringForBc20Objective);
		// % protected region % [Add customisation for BC20 Objective here] end
		// % protected region % [Add customisation for BC21 Subjective here] off begin
		String randomStringForBc21Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc21Subjective(randomStringForBc21Subjective);
		// % protected region % [Add customisation for BC21 Subjective here] end
		// % protected region % [Add customisation for BC21 Objective here] off begin
		String randomStringForBc21Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc21Objective(randomStringForBc21Objective);
		// % protected region % [Add customisation for BC21 Objective here] end
		// % protected region % [Add customisation for BC22 Subjective here] off begin
		String randomStringForBc22Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc22Subjective(randomStringForBc22Subjective);
		// % protected region % [Add customisation for BC22 Subjective here] end
		// % protected region % [Add customisation for BC22 Objective here] off begin
		String randomStringForBc22Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc22Objective(randomStringForBc22Objective);
		// % protected region % [Add customisation for BC22 Objective here] end
		// % protected region % [Add customisation for BC23 Subjective here] off begin
		String randomStringForBc23Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc23Subjective(randomStringForBc23Subjective);
		// % protected region % [Add customisation for BC23 Subjective here] end
		// % protected region % [Add customisation for BC23 Objective here] off begin
		String randomStringForBc23Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc23Objective(randomStringForBc23Objective);
		// % protected region % [Add customisation for BC23 Objective here] end
		// % protected region % [Add customisation for BC24 Subjective here] off begin
		String randomStringForBc24Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc24Subjective(randomStringForBc24Subjective);
		// % protected region % [Add customisation for BC24 Subjective here] end
		// % protected region % [Add customisation for BC24 Objective here] off begin
		String randomStringForBc24Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc24Objective(randomStringForBc24Objective);
		// % protected region % [Add customisation for BC24 Objective here] end
		// % protected region % [Add customisation for BC25 Subjective here] off begin
		String randomStringForBc25Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc25Subjective(randomStringForBc25Subjective);
		// % protected region % [Add customisation for BC25 Subjective here] end
		// % protected region % [Add customisation for BC25 Objective here] off begin
		String randomStringForBc25Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc25Objective(randomStringForBc25Objective);
		// % protected region % [Add customisation for BC25 Objective here] end
		// % protected region % [Add customisation for BC26 Subjective here] off begin
		String randomStringForBc26Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc26Subjective(randomStringForBc26Subjective);
		// % protected region % [Add customisation for BC26 Subjective here] end
		// % protected region % [Add customisation for BC26 Objective here] off begin
		String randomStringForBc26Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc26Objective(randomStringForBc26Objective);
		// % protected region % [Add customisation for BC26 Objective here] end
		// % protected region % [Add customisation for BC27 Subjective here] off begin
		String randomStringForBc27Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc27Subjective(randomStringForBc27Subjective);
		// % protected region % [Add customisation for BC27 Subjective here] end
		// % protected region % [Add customisation for BC27 Objective here] off begin
		String randomStringForBc27Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc27Objective(randomStringForBc27Objective);
		// % protected region % [Add customisation for BC27 Objective here] end
		// % protected region % [Add customisation for BC28 Subjective here] off begin
		String randomStringForBc28Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc28Subjective(randomStringForBc28Subjective);
		// % protected region % [Add customisation for BC28 Subjective here] end
		// % protected region % [Add customisation for BC28 Objective here] off begin
		String randomStringForBc28Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc28Objective(randomStringForBc28Objective);
		// % protected region % [Add customisation for BC28 Objective here] end
		// % protected region % [Add customisation for BC29 Subjective here] off begin
		String randomStringForBc29Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc29Subjective(randomStringForBc29Subjective);
		// % protected region % [Add customisation for BC29 Subjective here] end
		// % protected region % [Add customisation for BC29 Objective here] off begin
		String randomStringForBc29Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc29Objective(randomStringForBc29Objective);
		// % protected region % [Add customisation for BC29 Objective here] end
		// % protected region % [Add customisation for BC30 Subjective here] off begin
		String randomStringForBc30Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc30Subjective(randomStringForBc30Subjective);
		// % protected region % [Add customisation for BC30 Subjective here] end
		// % protected region % [Add customisation for BC30 Objective here] off begin
		String randomStringForBc30Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc30Objective(randomStringForBc30Objective);
		// % protected region % [Add customisation for BC30 Objective here] end
		// % protected region % [Add customisation for BC31 Subjective here] off begin
		String randomStringForBc31Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc31Subjective(randomStringForBc31Subjective);
		// % protected region % [Add customisation for BC31 Subjective here] end
		// % protected region % [Add customisation for BC31 Objective here] off begin
		String randomStringForBc31Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc31Objective(randomStringForBc31Objective);
		// % protected region % [Add customisation for BC31 Objective here] end
		// % protected region % [Add customisation for BC32 Subjective here] off begin
		String randomStringForBc32Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc32Subjective(randomStringForBc32Subjective);
		// % protected region % [Add customisation for BC32 Subjective here] end
		// % protected region % [Add customisation for BC32 Objective here] off begin
		String randomStringForBc32Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc32Objective(randomStringForBc32Objective);
		// % protected region % [Add customisation for BC32 Objective here] end
		// % protected region % [Add customisation for BC33 Subjective here] off begin
		String randomStringForBc33Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc33Subjective(randomStringForBc33Subjective);
		// % protected region % [Add customisation for BC33 Subjective here] end
		// % protected region % [Add customisation for BC33 Objective here] off begin
		String randomStringForBc33Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc33Objective(randomStringForBc33Objective);
		// % protected region % [Add customisation for BC33 Objective here] end
		// % protected region % [Add customisation for BC34 Subjective here] off begin
		String randomStringForBc34Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc34Subjective(randomStringForBc34Subjective);
		// % protected region % [Add customisation for BC34 Subjective here] end
		// % protected region % [Add customisation for BC34 Objective here] off begin
		String randomStringForBc34Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc34Objective(randomStringForBc34Objective);
		// % protected region % [Add customisation for BC34 Objective here] end
		// % protected region % [Add customisation for BC35 Subjective here] off begin
		String randomStringForBc35Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc35Subjective(randomStringForBc35Subjective);
		// % protected region % [Add customisation for BC35 Subjective here] end
		// % protected region % [Add customisation for BC35 Objective here] off begin
		String randomStringForBc35Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc35Objective(randomStringForBc35Objective);
		// % protected region % [Add customisation for BC35 Objective here] end
		// % protected region % [Add customisation for BC36 Subjective here] off begin
		String randomStringForBc36Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc36Subjective(randomStringForBc36Subjective);
		// % protected region % [Add customisation for BC36 Subjective here] end
		// % protected region % [Add customisation for BC36 Objective here] off begin
		String randomStringForBc36Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc36Objective(randomStringForBc36Objective);
		// % protected region % [Add customisation for BC36 Objective here] end
		// % protected region % [Add customisation for BC37 Subjective here] off begin
		String randomStringForBc37Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc37Subjective(randomStringForBc37Subjective);
		// % protected region % [Add customisation for BC37 Subjective here] end
		// % protected region % [Add customisation for BC37 Objective here] off begin
		String randomStringForBc37Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc37Objective(randomStringForBc37Objective);
		// % protected region % [Add customisation for BC37 Objective here] end
		// % protected region % [Add customisation for BC38 Subjective here] off begin
		String randomStringForBc38Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc38Subjective(randomStringForBc38Subjective);
		// % protected region % [Add customisation for BC38 Subjective here] end
		// % protected region % [Add customisation for BC38 Objective here] off begin
		String randomStringForBc38Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc38Objective(randomStringForBc38Objective);
		// % protected region % [Add customisation for BC38 Objective here] end
		// % protected region % [Add customisation for BC39 Subjective here] off begin
		String randomStringForBc39Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc39Subjective(randomStringForBc39Subjective);
		// % protected region % [Add customisation for BC39 Subjective here] end
		// % protected region % [Add customisation for BC39 Objective here] off begin
		String randomStringForBc39Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc39Objective(randomStringForBc39Objective);
		// % protected region % [Add customisation for BC39 Objective here] end
		// % protected region % [Add customisation for BC40 Subjective here] off begin
		String randomStringForBc40Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc40Subjective(randomStringForBc40Subjective);
		// % protected region % [Add customisation for BC40 Subjective here] end
		// % protected region % [Add customisation for BC40 Objective here] off begin
		String randomStringForBc40Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc40Objective(randomStringForBc40Objective);
		// % protected region % [Add customisation for BC40 Objective here] end
		// % protected region % [Add customisation for BC41 Subjective here] off begin
		String randomStringForBc41Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc41Subjective(randomStringForBc41Subjective);
		// % protected region % [Add customisation for BC41 Subjective here] end
		// % protected region % [Add customisation for BC41 Objective here] off begin
		String randomStringForBc41Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc41Objective(randomStringForBc41Objective);
		// % protected region % [Add customisation for BC41 Objective here] end
		// % protected region % [Add customisation for BC42 Subjective here] off begin
		String randomStringForBc42Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc42Subjective(randomStringForBc42Subjective);
		// % protected region % [Add customisation for BC42 Subjective here] end
		// % protected region % [Add customisation for BC42 Objective here] off begin
		String randomStringForBc42Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc42Objective(randomStringForBc42Objective);
		// % protected region % [Add customisation for BC42 Objective here] end
		// % protected region % [Add customisation for BC43 Subjective here] off begin
		String randomStringForBc43Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc43Subjective(randomStringForBc43Subjective);
		// % protected region % [Add customisation for BC43 Subjective here] end
		// % protected region % [Add customisation for BC43 Objective here] off begin
		String randomStringForBc43Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc43Objective(randomStringForBc43Objective);
		// % protected region % [Add customisation for BC43 Objective here] end
		// % protected region % [Add customisation for BC44 Subjective here] off begin
		String randomStringForBc44Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc44Subjective(randomStringForBc44Subjective);
		// % protected region % [Add customisation for BC44 Subjective here] end
		// % protected region % [Add customisation for BC44 Objective here] off begin
		String randomStringForBc44Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc44Objective(randomStringForBc44Objective);
		// % protected region % [Add customisation for BC44 Objective here] end
		// % protected region % [Add customisation for BC45 Subjective here] off begin
		String randomStringForBc45Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc45Subjective(randomStringForBc45Subjective);
		// % protected region % [Add customisation for BC45 Subjective here] end
		// % protected region % [Add customisation for BC45 Objective here] off begin
		String randomStringForBc45Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc45Objective(randomStringForBc45Objective);
		// % protected region % [Add customisation for BC45 Objective here] end
		// % protected region % [Add customisation for BC46 Subjective here] off begin
		String randomStringForBc46Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc46Subjective(randomStringForBc46Subjective);
		// % protected region % [Add customisation for BC46 Subjective here] end
		// % protected region % [Add customisation for BC46 Objective here] off begin
		String randomStringForBc46Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc46Objective(randomStringForBc46Objective);
		// % protected region % [Add customisation for BC46 Objective here] end
		// % protected region % [Add customisation for BC47 Subjective here] off begin
		String randomStringForBc47Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc47Subjective(randomStringForBc47Subjective);
		// % protected region % [Add customisation for BC47 Subjective here] end
		// % protected region % [Add customisation for BC47 Objective here] off begin
		String randomStringForBc47Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc47Objective(randomStringForBc47Objective);
		// % protected region % [Add customisation for BC47 Objective here] end
		// % protected region % [Add customisation for BC48 Subjective here] off begin
		String randomStringForBc48Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc48Subjective(randomStringForBc48Subjective);
		// % protected region % [Add customisation for BC48 Subjective here] end
		// % protected region % [Add customisation for BC48 Objective here] off begin
		String randomStringForBc48Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc48Objective(randomStringForBc48Objective);
		// % protected region % [Add customisation for BC48 Objective here] end
		// % protected region % [Add customisation for BC49 Subjective here] off begin
		String randomStringForBc49Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc49Subjective(randomStringForBc49Subjective);
		// % protected region % [Add customisation for BC49 Subjective here] end
		// % protected region % [Add customisation for BC49 Objective here] off begin
		String randomStringForBc49Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc49Objective(randomStringForBc49Objective);
		// % protected region % [Add customisation for BC49 Objective here] end
		// % protected region % [Add customisation for BC50 Subjective here] off begin
		String randomStringForBc50Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc50Subjective(randomStringForBc50Subjective);
		// % protected region % [Add customisation for BC50 Subjective here] end
		// % protected region % [Add customisation for BC50 Objective here] off begin
		String randomStringForBc50Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc50Objective(randomStringForBc50Objective);
		// % protected region % [Add customisation for BC50 Objective here] end
		// % protected region % [Add customisation for BC51 Subjective here] off begin
		String randomStringForBc51Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc51Subjective(randomStringForBc51Subjective);
		// % protected region % [Add customisation for BC51 Subjective here] end
		// % protected region % [Add customisation for BC51 Objective here] off begin
		String randomStringForBc51Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc51Objective(randomStringForBc51Objective);
		// % protected region % [Add customisation for BC51 Objective here] end
		// % protected region % [Add customisation for BC52 Subjective here] off begin
		String randomStringForBc52Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc52Subjective(randomStringForBc52Subjective);
		// % protected region % [Add customisation for BC52 Subjective here] end
		// % protected region % [Add customisation for BC52 Objective here] off begin
		String randomStringForBc52Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc52Objective(randomStringForBc52Objective);
		// % protected region % [Add customisation for BC52 Objective here] end
		// % protected region % [Add customisation for BC53 Subjective here] off begin
		String randomStringForBc53Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc53Subjective(randomStringForBc53Subjective);
		// % protected region % [Add customisation for BC53 Subjective here] end
		// % protected region % [Add customisation for BC53 Objective here] off begin
		String randomStringForBc53Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc53Objective(randomStringForBc53Objective);
		// % protected region % [Add customisation for BC53 Objective here] end
		// % protected region % [Add customisation for BC54 Subjective here] off begin
		String randomStringForBc54Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc54Subjective(randomStringForBc54Subjective);
		// % protected region % [Add customisation for BC54 Subjective here] end
		// % protected region % [Add customisation for BC54 Objective here] off begin
		String randomStringForBc54Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc54Objective(randomStringForBc54Objective);
		// % protected region % [Add customisation for BC54 Objective here] end
		// % protected region % [Add customisation for BC55 Subjective here] off begin
		String randomStringForBc55Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc55Subjective(randomStringForBc55Subjective);
		// % protected region % [Add customisation for BC55 Subjective here] end
		// % protected region % [Add customisation for BC55 Objective here] off begin
		String randomStringForBc55Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc55Objective(randomStringForBc55Objective);
		// % protected region % [Add customisation for BC55 Objective here] end
		// % protected region % [Add customisation for BC56 Subjective here] off begin
		String randomStringForBc56Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc56Subjective(randomStringForBc56Subjective);
		// % protected region % [Add customisation for BC56 Subjective here] end
		// % protected region % [Add customisation for BC56 Objective here] off begin
		String randomStringForBc56Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc56Objective(randomStringForBc56Objective);
		// % protected region % [Add customisation for BC56 Objective here] end
		// % protected region % [Add customisation for BC57 Subjective here] off begin
		String randomStringForBc57Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc57Subjective(randomStringForBc57Subjective);
		// % protected region % [Add customisation for BC57 Subjective here] end
		// % protected region % [Add customisation for BC57 Objective here] off begin
		String randomStringForBc57Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc57Objective(randomStringForBc57Objective);
		// % protected region % [Add customisation for BC57 Objective here] end
		// % protected region % [Add customisation for BC58 Subjective here] off begin
		String randomStringForBc58Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc58Subjective(randomStringForBc58Subjective);
		// % protected region % [Add customisation for BC58 Subjective here] end
		// % protected region % [Add customisation for BC58 Objective here] off begin
		String randomStringForBc58Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc58Objective(randomStringForBc58Objective);
		// % protected region % [Add customisation for BC58 Objective here] end
		// % protected region % [Add customisation for BC59 Subjective here] off begin
		String randomStringForBc59Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc59Subjective(randomStringForBc59Subjective);
		// % protected region % [Add customisation for BC59 Subjective here] end
		// % protected region % [Add customisation for BC59 Objective here] off begin
		String randomStringForBc59Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc59Objective(randomStringForBc59Objective);
		// % protected region % [Add customisation for BC59 Objective here] end
		// % protected region % [Add customisation for BC60 Subjective here] off begin
		String randomStringForBc60Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc60Subjective(randomStringForBc60Subjective);
		// % protected region % [Add customisation for BC60 Subjective here] end
		// % protected region % [Add customisation for BC60 Objective here] off begin
		String randomStringForBc60Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc60Objective(randomStringForBc60Objective);
		// % protected region % [Add customisation for BC60 Objective here] end
		// % protected region % [Add customisation for BC61 Subjective here] off begin
		String randomStringForBc61Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc61Subjective(randomStringForBc61Subjective);
		// % protected region % [Add customisation for BC61 Subjective here] end
		// % protected region % [Add customisation for BC61 Objective here] off begin
		String randomStringForBc61Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc61Objective(randomStringForBc61Objective);
		// % protected region % [Add customisation for BC61 Objective here] end
		// % protected region % [Add customisation for BC62 Subjective here] off begin
		String randomStringForBc62Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc62Subjective(randomStringForBc62Subjective);
		// % protected region % [Add customisation for BC62 Subjective here] end
		// % protected region % [Add customisation for BC62 Objective here] off begin
		String randomStringForBc62Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc62Objective(randomStringForBc62Objective);
		// % protected region % [Add customisation for BC62 Objective here] end
		// % protected region % [Add customisation for BC63 Subjective here] off begin
		String randomStringForBc63Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc63Subjective(randomStringForBc63Subjective);
		// % protected region % [Add customisation for BC63 Subjective here] end
		// % protected region % [Add customisation for BC63 Objective here] off begin
		String randomStringForBc63Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc63Objective(randomStringForBc63Objective);
		// % protected region % [Add customisation for BC63 Objective here] end
		// % protected region % [Add customisation for BC64 Subjective here] off begin
		String randomStringForBc64Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc64Subjective(randomStringForBc64Subjective);
		// % protected region % [Add customisation for BC64 Subjective here] end
		// % protected region % [Add customisation for BC64 Objective here] off begin
		String randomStringForBc64Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc64Objective(randomStringForBc64Objective);
		// % protected region % [Add customisation for BC64 Objective here] end
		// % protected region % [Add customisation for BC65 Subjective here] off begin
		String randomStringForBc65Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc65Subjective(randomStringForBc65Subjective);
		// % protected region % [Add customisation for BC65 Subjective here] end
		// % protected region % [Add customisation for BC65 Objective here] off begin
		String randomStringForBc65Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc65Objective(randomStringForBc65Objective);
		// % protected region % [Add customisation for BC65 Objective here] end
		// % protected region % [Add customisation for BC66 Subjective here] off begin
		String randomStringForBc66Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc66Subjective(randomStringForBc66Subjective);
		// % protected region % [Add customisation for BC66 Subjective here] end
		// % protected region % [Add customisation for BC66 Objective here] off begin
		String randomStringForBc66Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc66Objective(randomStringForBc66Objective);
		// % protected region % [Add customisation for BC66 Objective here] end
		// % protected region % [Add customisation for BC67 Subjective here] off begin
		String randomStringForBc67Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc67Subjective(randomStringForBc67Subjective);
		// % protected region % [Add customisation for BC67 Subjective here] end
		// % protected region % [Add customisation for BC67 Objective here] off begin
		String randomStringForBc67Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc67Objective(randomStringForBc67Objective);
		// % protected region % [Add customisation for BC67 Objective here] end
		// % protected region % [Add customisation for BC68 Subjective here] off begin
		String randomStringForBc68Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc68Subjective(randomStringForBc68Subjective);
		// % protected region % [Add customisation for BC68 Subjective here] end
		// % protected region % [Add customisation for BC68 Objective here] off begin
		String randomStringForBc68Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc68Objective(randomStringForBc68Objective);
		// % protected region % [Add customisation for BC68 Objective here] end
		// % protected region % [Add customisation for BC69 Subjective here] off begin
		String randomStringForBc69Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc69Subjective(randomStringForBc69Subjective);
		// % protected region % [Add customisation for BC69 Subjective here] end
		// % protected region % [Add customisation for BC69 Objective here] off begin
		String randomStringForBc69Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc69Objective(randomStringForBc69Objective);
		// % protected region % [Add customisation for BC69 Objective here] end
		// % protected region % [Add customisation for BC70 Subjective here] off begin
		String randomStringForBc70Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc70Subjective(randomStringForBc70Subjective);
		// % protected region % [Add customisation for BC70 Subjective here] end
		// % protected region % [Add customisation for BC70 Objective here] off begin
		String randomStringForBc70Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc70Objective(randomStringForBc70Objective);
		// % protected region % [Add customisation for BC70 Objective here] end
		// % protected region % [Add customisation for BC71 Subjective here] off begin
		String randomStringForBc71Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc71Subjective(randomStringForBc71Subjective);
		// % protected region % [Add customisation for BC71 Subjective here] end
		// % protected region % [Add customisation for BC71 Objective here] off begin
		String randomStringForBc71Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc71Objective(randomStringForBc71Objective);
		// % protected region % [Add customisation for BC71 Objective here] end
		// % protected region % [Add customisation for BC72 Subjective here] off begin
		String randomStringForBc72Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc72Subjective(randomStringForBc72Subjective);
		// % protected region % [Add customisation for BC72 Subjective here] end
		// % protected region % [Add customisation for BC72 Objective here] off begin
		String randomStringForBc72Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc72Objective(randomStringForBc72Objective);
		// % protected region % [Add customisation for BC72 Objective here] end
		// % protected region % [Add customisation for BC73 Subjective here] off begin
		String randomStringForBc73Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc73Subjective(randomStringForBc73Subjective);
		// % protected region % [Add customisation for BC73 Subjective here] end
		// % protected region % [Add customisation for BC73 Objective here] off begin
		String randomStringForBc73Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc73Objective(randomStringForBc73Objective);
		// % protected region % [Add customisation for BC73 Objective here] end
		// % protected region % [Add customisation for BC74 Subjective here] off begin
		String randomStringForBc74Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc74Subjective(randomStringForBc74Subjective);
		// % protected region % [Add customisation for BC74 Subjective here] end
		// % protected region % [Add customisation for BC74 Objective here] off begin
		String randomStringForBc74Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc74Objective(randomStringForBc74Objective);
		// % protected region % [Add customisation for BC74 Objective here] end
		// % protected region % [Add customisation for BC75 Subjective here] off begin
		String randomStringForBc75Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc75Subjective(randomStringForBc75Subjective);
		// % protected region % [Add customisation for BC75 Subjective here] end
		// % protected region % [Add customisation for BC75 Objective here] off begin
		String randomStringForBc75Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc75Objective(randomStringForBc75Objective);
		// % protected region % [Add customisation for BC75 Objective here] end
		// % protected region % [Add customisation for BC76 Subjective here] off begin
		String randomStringForBc76Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc76Subjective(randomStringForBc76Subjective);
		// % protected region % [Add customisation for BC76 Subjective here] end
		// % protected region % [Add customisation for BC76 Objective here] off begin
		String randomStringForBc76Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc76Objective(randomStringForBc76Objective);
		// % protected region % [Add customisation for BC76 Objective here] end
		// % protected region % [Add customisation for BC77 Subjective here] off begin
		String randomStringForBc77Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc77Subjective(randomStringForBc77Subjective);
		// % protected region % [Add customisation for BC77 Subjective here] end
		// % protected region % [Add customisation for BC77 Objective here] off begin
		String randomStringForBc77Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc77Objective(randomStringForBc77Objective);
		// % protected region % [Add customisation for BC77 Objective here] end
		// % protected region % [Add customisation for BC78 Subjective here] off begin
		String randomStringForBc78Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc78Subjective(randomStringForBc78Subjective);
		// % protected region % [Add customisation for BC78 Subjective here] end
		// % protected region % [Add customisation for BC78 Objective here] off begin
		String randomStringForBc78Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc78Objective(randomStringForBc78Objective);
		// % protected region % [Add customisation for BC78 Objective here] end
		// % protected region % [Add customisation for BC79 Subjective here] off begin
		String randomStringForBc79Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc79Subjective(randomStringForBc79Subjective);
		// % protected region % [Add customisation for BC79 Subjective here] end
		// % protected region % [Add customisation for BC79 Objective here] off begin
		String randomStringForBc79Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc79Objective(randomStringForBc79Objective);
		// % protected region % [Add customisation for BC79 Objective here] end
		// % protected region % [Add customisation for BC80 Subjective here] off begin
		String randomStringForBc80Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc80Subjective(randomStringForBc80Subjective);
		// % protected region % [Add customisation for BC80 Subjective here] end
		// % protected region % [Add customisation for BC80 Objective here] off begin
		String randomStringForBc80Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc80Objective(randomStringForBc80Objective);
		// % protected region % [Add customisation for BC80 Objective here] end
		// % protected region % [Add customisation for BC81 Subjective here] off begin
		String randomStringForBc81Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc81Subjective(randomStringForBc81Subjective);
		// % protected region % [Add customisation for BC81 Subjective here] end
		// % protected region % [Add customisation for BC81 Objective here] off begin
		String randomStringForBc81Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc81Objective(randomStringForBc81Objective);
		// % protected region % [Add customisation for BC81 Objective here] end
		// % protected region % [Add customisation for BC82 Subjective here] off begin
		String randomStringForBc82Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc82Subjective(randomStringForBc82Subjective);
		// % protected region % [Add customisation for BC82 Subjective here] end
		// % protected region % [Add customisation for BC82 Objective here] off begin
		String randomStringForBc82Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc82Objective(randomStringForBc82Objective);
		// % protected region % [Add customisation for BC82 Objective here] end
		// % protected region % [Add customisation for BC83 Subjective here] off begin
		String randomStringForBc83Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc83Subjective(randomStringForBc83Subjective);
		// % protected region % [Add customisation for BC83 Subjective here] end
		// % protected region % [Add customisation for BC83 Objective here] off begin
		String randomStringForBc83Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc83Objective(randomStringForBc83Objective);
		// % protected region % [Add customisation for BC83 Objective here] end
		// % protected region % [Add customisation for BC84 Subjective here] off begin
		String randomStringForBc84Subjective = mockNeat
				.strings()
				.get();
		newEntity.setBc84Subjective(randomStringForBc84Subjective);
		// % protected region % [Add customisation for BC84 Subjective here] end
		// % protected region % [Add customisation for BC84 Objective here] off begin
		String randomStringForBc84Objective = mockNeat
				.strings()
				.get();
		newEntity.setBc84Objective(randomStringForBc84Objective);
		// % protected region % [Add customisation for BC84 Objective here] end

		// % protected region % [Apply any additional logic for bodyChartExaminationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bodyChartExaminationWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] off begin
			// Incoming One to One reference
			var medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalExaminationRecord(medicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] end
		}

		// % protected region % [Apply any additional logic for bodyChartExamination with ref here] off begin
		// % protected region % [Apply any additional logic for bodyChartExamination with ref here] end

		return newEntity;
	}

	@Override
	public Class<BodyChartExaminationEntity> getObjectType() {
		return BodyChartExaminationEntity.class;
	}
}