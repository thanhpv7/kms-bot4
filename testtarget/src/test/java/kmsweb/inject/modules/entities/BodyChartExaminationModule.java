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
package kmsweb.inject.modules.entities;

import kmsweb.entities.*;
import kmsweb.entities.enums.*;
import kmsweb.inject.factories.*;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.UUID;

// % protected region % [Apply any additional imports here] off begin
// % protected region % [Apply any additional imports here] end

/**
 * Guice module for Body Chart Examination used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BodyChartExaminationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BodyChartExaminationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BodyChartExaminationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BodyChartExaminationEntityFactory bodyChartExaminationEntityFactory(
			// % protected region % [Apply any additional injected arguments for bodyChartExaminationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bodyChartExaminationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BodyChartExaminationEntityFactory");

		// % protected region % [Apply any additional logic for bodyChartExaminationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bodyChartExaminationEntityFactory before the main body here] end

		BodyChartExaminationEntityFactory entityFactory = new BodyChartExaminationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BodyChartExaminationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BodyChartExaminationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bodyChartExaminationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bodyChartExaminationEntityFactory after the main body here] end

		log.trace("Created BodyChartExaminationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Body Chart Examination entity with no references set.
	 */
	@Provides
	@Named("bodyChartExaminationEntityWithNoRef")
	public BodyChartExaminationEntity bodyChartExaminationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bodyChartExaminationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bodyChartExaminationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BodyChartExaminationEntity with no reference");

		// % protected region % [Apply any additional logic for bodyChartExaminationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bodyChartExaminationWithNoRef before the main body here] end

		BodyChartExaminationEntity newEntity = new BodyChartExaminationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for BC01 Subjective here] off begin
		String randomStringforBc01Subjective = mock
				.strings()
				.get();
		newEntity.setBc01Subjective(randomStringforBc01Subjective);
		// % protected region % [Add customisation for BC01 Subjective here] end
		// % protected region % [Add customisation for BC01 Objective here] off begin
		String randomStringforBc01Objective = mock
				.strings()
				.get();
		newEntity.setBc01Objective(randomStringforBc01Objective);
		// % protected region % [Add customisation for BC01 Objective here] end
		// % protected region % [Add customisation for BC02 Subjective here] off begin
		String randomStringforBc02Subjective = mock
				.strings()
				.get();
		newEntity.setBc02Subjective(randomStringforBc02Subjective);
		// % protected region % [Add customisation for BC02 Subjective here] end
		// % protected region % [Add customisation for BC02 Objective here] off begin
		String randomStringforBc02Objective = mock
				.strings()
				.get();
		newEntity.setBc02Objective(randomStringforBc02Objective);
		// % protected region % [Add customisation for BC02 Objective here] end
		// % protected region % [Add customisation for BC03 Subjective here] off begin
		String randomStringforBc03Subjective = mock
				.strings()
				.get();
		newEntity.setBc03Subjective(randomStringforBc03Subjective);
		// % protected region % [Add customisation for BC03 Subjective here] end
		// % protected region % [Add customisation for BC03 Objective here] off begin
		String randomStringforBc03Objective = mock
				.strings()
				.get();
		newEntity.setBc03Objective(randomStringforBc03Objective);
		// % protected region % [Add customisation for BC03 Objective here] end
		// % protected region % [Add customisation for BC04 Subjective here] off begin
		String randomStringforBc04Subjective = mock
				.strings()
				.get();
		newEntity.setBc04Subjective(randomStringforBc04Subjective);
		// % protected region % [Add customisation for BC04 Subjective here] end
		// % protected region % [Add customisation for BC04 Objective here] off begin
		String randomStringforBc04Objective = mock
				.strings()
				.get();
		newEntity.setBc04Objective(randomStringforBc04Objective);
		// % protected region % [Add customisation for BC04 Objective here] end
		// % protected region % [Add customisation for BC05 Subjective here] off begin
		String randomStringforBc05Subjective = mock
				.strings()
				.get();
		newEntity.setBc05Subjective(randomStringforBc05Subjective);
		// % protected region % [Add customisation for BC05 Subjective here] end
		// % protected region % [Add customisation for BC05 Objective here] off begin
		String randomStringforBc05Objective = mock
				.strings()
				.get();
		newEntity.setBc05Objective(randomStringforBc05Objective);
		// % protected region % [Add customisation for BC05 Objective here] end
		// % protected region % [Add customisation for BC06 Subjective here] off begin
		String randomStringforBc06Subjective = mock
				.strings()
				.get();
		newEntity.setBc06Subjective(randomStringforBc06Subjective);
		// % protected region % [Add customisation for BC06 Subjective here] end
		// % protected region % [Add customisation for BC06 Objective here] off begin
		String randomStringforBc06Objective = mock
				.strings()
				.get();
		newEntity.setBc06Objective(randomStringforBc06Objective);
		// % protected region % [Add customisation for BC06 Objective here] end
		// % protected region % [Add customisation for BC07 Subjective here] off begin
		String randomStringforBc07Subjective = mock
				.strings()
				.get();
		newEntity.setBc07Subjective(randomStringforBc07Subjective);
		// % protected region % [Add customisation for BC07 Subjective here] end
		// % protected region % [Add customisation for BC07 Objective here] off begin
		String randomStringforBc07Objective = mock
				.strings()
				.get();
		newEntity.setBc07Objective(randomStringforBc07Objective);
		// % protected region % [Add customisation for BC07 Objective here] end
		// % protected region % [Add customisation for BC08 Subjective here] off begin
		String randomStringforBc08Subjective = mock
				.strings()
				.get();
		newEntity.setBc08Subjective(randomStringforBc08Subjective);
		// % protected region % [Add customisation for BC08 Subjective here] end
		// % protected region % [Add customisation for BC08 Objective here] off begin
		String randomStringforBc08Objective = mock
				.strings()
				.get();
		newEntity.setBc08Objective(randomStringforBc08Objective);
		// % protected region % [Add customisation for BC08 Objective here] end
		// % protected region % [Add customisation for BC09 Subjective here] off begin
		String randomStringforBc09Subjective = mock
				.strings()
				.get();
		newEntity.setBc09Subjective(randomStringforBc09Subjective);
		// % protected region % [Add customisation for BC09 Subjective here] end
		// % protected region % [Add customisation for BC09 Objective here] off begin
		String randomStringforBc09Objective = mock
				.strings()
				.get();
		newEntity.setBc09Objective(randomStringforBc09Objective);
		// % protected region % [Add customisation for BC09 Objective here] end
		// % protected region % [Add customisation for BC10 Subjective here] off begin
		String randomStringforBc10Subjective = mock
				.strings()
				.get();
		newEntity.setBc10Subjective(randomStringforBc10Subjective);
		// % protected region % [Add customisation for BC10 Subjective here] end
		// % protected region % [Add customisation for BC10 Objective here] off begin
		String randomStringforBc10Objective = mock
				.strings()
				.get();
		newEntity.setBc10Objective(randomStringforBc10Objective);
		// % protected region % [Add customisation for BC10 Objective here] end
		// % protected region % [Add customisation for BC11 Subjective here] off begin
		String randomStringforBc11Subjective = mock
				.strings()
				.get();
		newEntity.setBc11Subjective(randomStringforBc11Subjective);
		// % protected region % [Add customisation for BC11 Subjective here] end
		// % protected region % [Add customisation for BC11 Objective here] off begin
		String randomStringforBc11Objective = mock
				.strings()
				.get();
		newEntity.setBc11Objective(randomStringforBc11Objective);
		// % protected region % [Add customisation for BC11 Objective here] end
		// % protected region % [Add customisation for BC12 Subjective here] off begin
		String randomStringforBc12Subjective = mock
				.strings()
				.get();
		newEntity.setBc12Subjective(randomStringforBc12Subjective);
		// % protected region % [Add customisation for BC12 Subjective here] end
		// % protected region % [Add customisation for BC12 Objective here] off begin
		String randomStringforBc12Objective = mock
				.strings()
				.get();
		newEntity.setBc12Objective(randomStringforBc12Objective);
		// % protected region % [Add customisation for BC12 Objective here] end
		// % protected region % [Add customisation for BC13 Subjective here] off begin
		String randomStringforBc13Subjective = mock
				.strings()
				.get();
		newEntity.setBc13Subjective(randomStringforBc13Subjective);
		// % protected region % [Add customisation for BC13 Subjective here] end
		// % protected region % [Add customisation for BC13 Objective here] off begin
		String randomStringforBc13Objective = mock
				.strings()
				.get();
		newEntity.setBc13Objective(randomStringforBc13Objective);
		// % protected region % [Add customisation for BC13 Objective here] end
		// % protected region % [Add customisation for BC14 Subjective here] off begin
		String randomStringforBc14Subjective = mock
				.strings()
				.get();
		newEntity.setBc14Subjective(randomStringforBc14Subjective);
		// % protected region % [Add customisation for BC14 Subjective here] end
		// % protected region % [Add customisation for BC14 Objective here] off begin
		String randomStringforBc14Objective = mock
				.strings()
				.get();
		newEntity.setBc14Objective(randomStringforBc14Objective);
		// % protected region % [Add customisation for BC14 Objective here] end
		// % protected region % [Add customisation for BC15 Subjective here] off begin
		String randomStringforBc15Subjective = mock
				.strings()
				.get();
		newEntity.setBc15Subjective(randomStringforBc15Subjective);
		// % protected region % [Add customisation for BC15 Subjective here] end
		// % protected region % [Add customisation for BC15 Objective here] off begin
		String randomStringforBc15Objective = mock
				.strings()
				.get();
		newEntity.setBc15Objective(randomStringforBc15Objective);
		// % protected region % [Add customisation for BC15 Objective here] end
		// % protected region % [Add customisation for BC16 Subjective here] off begin
		String randomStringforBc16Subjective = mock
				.strings()
				.get();
		newEntity.setBc16Subjective(randomStringforBc16Subjective);
		// % protected region % [Add customisation for BC16 Subjective here] end
		// % protected region % [Add customisation for BC16 Objective here] off begin
		String randomStringforBc16Objective = mock
				.strings()
				.get();
		newEntity.setBc16Objective(randomStringforBc16Objective);
		// % protected region % [Add customisation for BC16 Objective here] end
		// % protected region % [Add customisation for BC17 Subjective here] off begin
		String randomStringforBc17Subjective = mock
				.strings()
				.get();
		newEntity.setBc17Subjective(randomStringforBc17Subjective);
		// % protected region % [Add customisation for BC17 Subjective here] end
		// % protected region % [Add customisation for BC17 Objective here] off begin
		String randomStringforBc17Objective = mock
				.strings()
				.get();
		newEntity.setBc17Objective(randomStringforBc17Objective);
		// % protected region % [Add customisation for BC17 Objective here] end
		// % protected region % [Add customisation for BC18 Subjective here] off begin
		String randomStringforBc18Subjective = mock
				.strings()
				.get();
		newEntity.setBc18Subjective(randomStringforBc18Subjective);
		// % protected region % [Add customisation for BC18 Subjective here] end
		// % protected region % [Add customisation for BC18 Objective here] off begin
		String randomStringforBc18Objective = mock
				.strings()
				.get();
		newEntity.setBc18Objective(randomStringforBc18Objective);
		// % protected region % [Add customisation for BC18 Objective here] end
		// % protected region % [Add customisation for BC19 Subjective here] off begin
		String randomStringforBc19Subjective = mock
				.strings()
				.get();
		newEntity.setBc19Subjective(randomStringforBc19Subjective);
		// % protected region % [Add customisation for BC19 Subjective here] end
		// % protected region % [Add customisation for BC19 Objective here] off begin
		String randomStringforBc19Objective = mock
				.strings()
				.get();
		newEntity.setBc19Objective(randomStringforBc19Objective);
		// % protected region % [Add customisation for BC19 Objective here] end
		// % protected region % [Add customisation for BC20 Subjective here] off begin
		String randomStringforBc20Subjective = mock
				.strings()
				.get();
		newEntity.setBc20Subjective(randomStringforBc20Subjective);
		// % protected region % [Add customisation for BC20 Subjective here] end
		// % protected region % [Add customisation for BC20 Objective here] off begin
		String randomStringforBc20Objective = mock
				.strings()
				.get();
		newEntity.setBc20Objective(randomStringforBc20Objective);
		// % protected region % [Add customisation for BC20 Objective here] end
		// % protected region % [Add customisation for BC21 Subjective here] off begin
		String randomStringforBc21Subjective = mock
				.strings()
				.get();
		newEntity.setBc21Subjective(randomStringforBc21Subjective);
		// % protected region % [Add customisation for BC21 Subjective here] end
		// % protected region % [Add customisation for BC21 Objective here] off begin
		String randomStringforBc21Objective = mock
				.strings()
				.get();
		newEntity.setBc21Objective(randomStringforBc21Objective);
		// % protected region % [Add customisation for BC21 Objective here] end
		// % protected region % [Add customisation for BC22 Subjective here] off begin
		String randomStringforBc22Subjective = mock
				.strings()
				.get();
		newEntity.setBc22Subjective(randomStringforBc22Subjective);
		// % protected region % [Add customisation for BC22 Subjective here] end
		// % protected region % [Add customisation for BC22 Objective here] off begin
		String randomStringforBc22Objective = mock
				.strings()
				.get();
		newEntity.setBc22Objective(randomStringforBc22Objective);
		// % protected region % [Add customisation for BC22 Objective here] end
		// % protected region % [Add customisation for BC23 Subjective here] off begin
		String randomStringforBc23Subjective = mock
				.strings()
				.get();
		newEntity.setBc23Subjective(randomStringforBc23Subjective);
		// % protected region % [Add customisation for BC23 Subjective here] end
		// % protected region % [Add customisation for BC23 Objective here] off begin
		String randomStringforBc23Objective = mock
				.strings()
				.get();
		newEntity.setBc23Objective(randomStringforBc23Objective);
		// % protected region % [Add customisation for BC23 Objective here] end
		// % protected region % [Add customisation for BC24 Subjective here] off begin
		String randomStringforBc24Subjective = mock
				.strings()
				.get();
		newEntity.setBc24Subjective(randomStringforBc24Subjective);
		// % protected region % [Add customisation for BC24 Subjective here] end
		// % protected region % [Add customisation for BC24 Objective here] off begin
		String randomStringforBc24Objective = mock
				.strings()
				.get();
		newEntity.setBc24Objective(randomStringforBc24Objective);
		// % protected region % [Add customisation for BC24 Objective here] end
		// % protected region % [Add customisation for BC25 Subjective here] off begin
		String randomStringforBc25Subjective = mock
				.strings()
				.get();
		newEntity.setBc25Subjective(randomStringforBc25Subjective);
		// % protected region % [Add customisation for BC25 Subjective here] end
		// % protected region % [Add customisation for BC25 Objective here] off begin
		String randomStringforBc25Objective = mock
				.strings()
				.get();
		newEntity.setBc25Objective(randomStringforBc25Objective);
		// % protected region % [Add customisation for BC25 Objective here] end
		// % protected region % [Add customisation for BC26 Subjective here] off begin
		String randomStringforBc26Subjective = mock
				.strings()
				.get();
		newEntity.setBc26Subjective(randomStringforBc26Subjective);
		// % protected region % [Add customisation for BC26 Subjective here] end
		// % protected region % [Add customisation for BC26 Objective here] off begin
		String randomStringforBc26Objective = mock
				.strings()
				.get();
		newEntity.setBc26Objective(randomStringforBc26Objective);
		// % protected region % [Add customisation for BC26 Objective here] end
		// % protected region % [Add customisation for BC27 Subjective here] off begin
		String randomStringforBc27Subjective = mock
				.strings()
				.get();
		newEntity.setBc27Subjective(randomStringforBc27Subjective);
		// % protected region % [Add customisation for BC27 Subjective here] end
		// % protected region % [Add customisation for BC27 Objective here] off begin
		String randomStringforBc27Objective = mock
				.strings()
				.get();
		newEntity.setBc27Objective(randomStringforBc27Objective);
		// % protected region % [Add customisation for BC27 Objective here] end
		// % protected region % [Add customisation for BC28 Subjective here] off begin
		String randomStringforBc28Subjective = mock
				.strings()
				.get();
		newEntity.setBc28Subjective(randomStringforBc28Subjective);
		// % protected region % [Add customisation for BC28 Subjective here] end
		// % protected region % [Add customisation for BC28 Objective here] off begin
		String randomStringforBc28Objective = mock
				.strings()
				.get();
		newEntity.setBc28Objective(randomStringforBc28Objective);
		// % protected region % [Add customisation for BC28 Objective here] end
		// % protected region % [Add customisation for BC29 Subjective here] off begin
		String randomStringforBc29Subjective = mock
				.strings()
				.get();
		newEntity.setBc29Subjective(randomStringforBc29Subjective);
		// % protected region % [Add customisation for BC29 Subjective here] end
		// % protected region % [Add customisation for BC29 Objective here] off begin
		String randomStringforBc29Objective = mock
				.strings()
				.get();
		newEntity.setBc29Objective(randomStringforBc29Objective);
		// % protected region % [Add customisation for BC29 Objective here] end
		// % protected region % [Add customisation for BC30 Subjective here] off begin
		String randomStringforBc30Subjective = mock
				.strings()
				.get();
		newEntity.setBc30Subjective(randomStringforBc30Subjective);
		// % protected region % [Add customisation for BC30 Subjective here] end
		// % protected region % [Add customisation for BC30 Objective here] off begin
		String randomStringforBc30Objective = mock
				.strings()
				.get();
		newEntity.setBc30Objective(randomStringforBc30Objective);
		// % protected region % [Add customisation for BC30 Objective here] end
		// % protected region % [Add customisation for BC31 Subjective here] off begin
		String randomStringforBc31Subjective = mock
				.strings()
				.get();
		newEntity.setBc31Subjective(randomStringforBc31Subjective);
		// % protected region % [Add customisation for BC31 Subjective here] end
		// % protected region % [Add customisation for BC31 Objective here] off begin
		String randomStringforBc31Objective = mock
				.strings()
				.get();
		newEntity.setBc31Objective(randomStringforBc31Objective);
		// % protected region % [Add customisation for BC31 Objective here] end
		// % protected region % [Add customisation for BC32 Subjective here] off begin
		String randomStringforBc32Subjective = mock
				.strings()
				.get();
		newEntity.setBc32Subjective(randomStringforBc32Subjective);
		// % protected region % [Add customisation for BC32 Subjective here] end
		// % protected region % [Add customisation for BC32 Objective here] off begin
		String randomStringforBc32Objective = mock
				.strings()
				.get();
		newEntity.setBc32Objective(randomStringforBc32Objective);
		// % protected region % [Add customisation for BC32 Objective here] end
		// % protected region % [Add customisation for BC33 Subjective here] off begin
		String randomStringforBc33Subjective = mock
				.strings()
				.get();
		newEntity.setBc33Subjective(randomStringforBc33Subjective);
		// % protected region % [Add customisation for BC33 Subjective here] end
		// % protected region % [Add customisation for BC33 Objective here] off begin
		String randomStringforBc33Objective = mock
				.strings()
				.get();
		newEntity.setBc33Objective(randomStringforBc33Objective);
		// % protected region % [Add customisation for BC33 Objective here] end
		// % protected region % [Add customisation for BC34 Subjective here] off begin
		String randomStringforBc34Subjective = mock
				.strings()
				.get();
		newEntity.setBc34Subjective(randomStringforBc34Subjective);
		// % protected region % [Add customisation for BC34 Subjective here] end
		// % protected region % [Add customisation for BC34 Objective here] off begin
		String randomStringforBc34Objective = mock
				.strings()
				.get();
		newEntity.setBc34Objective(randomStringforBc34Objective);
		// % protected region % [Add customisation for BC34 Objective here] end
		// % protected region % [Add customisation for BC35 Subjective here] off begin
		String randomStringforBc35Subjective = mock
				.strings()
				.get();
		newEntity.setBc35Subjective(randomStringforBc35Subjective);
		// % protected region % [Add customisation for BC35 Subjective here] end
		// % protected region % [Add customisation for BC35 Objective here] off begin
		String randomStringforBc35Objective = mock
				.strings()
				.get();
		newEntity.setBc35Objective(randomStringforBc35Objective);
		// % protected region % [Add customisation for BC35 Objective here] end
		// % protected region % [Add customisation for BC36 Subjective here] off begin
		String randomStringforBc36Subjective = mock
				.strings()
				.get();
		newEntity.setBc36Subjective(randomStringforBc36Subjective);
		// % protected region % [Add customisation for BC36 Subjective here] end
		// % protected region % [Add customisation for BC36 Objective here] off begin
		String randomStringforBc36Objective = mock
				.strings()
				.get();
		newEntity.setBc36Objective(randomStringforBc36Objective);
		// % protected region % [Add customisation for BC36 Objective here] end
		// % protected region % [Add customisation for BC37 Subjective here] off begin
		String randomStringforBc37Subjective = mock
				.strings()
				.get();
		newEntity.setBc37Subjective(randomStringforBc37Subjective);
		// % protected region % [Add customisation for BC37 Subjective here] end
		// % protected region % [Add customisation for BC37 Objective here] off begin
		String randomStringforBc37Objective = mock
				.strings()
				.get();
		newEntity.setBc37Objective(randomStringforBc37Objective);
		// % protected region % [Add customisation for BC37 Objective here] end
		// % protected region % [Add customisation for BC38 Subjective here] off begin
		String randomStringforBc38Subjective = mock
				.strings()
				.get();
		newEntity.setBc38Subjective(randomStringforBc38Subjective);
		// % protected region % [Add customisation for BC38 Subjective here] end
		// % protected region % [Add customisation for BC38 Objective here] off begin
		String randomStringforBc38Objective = mock
				.strings()
				.get();
		newEntity.setBc38Objective(randomStringforBc38Objective);
		// % protected region % [Add customisation for BC38 Objective here] end
		// % protected region % [Add customisation for BC39 Subjective here] off begin
		String randomStringforBc39Subjective = mock
				.strings()
				.get();
		newEntity.setBc39Subjective(randomStringforBc39Subjective);
		// % protected region % [Add customisation for BC39 Subjective here] end
		// % protected region % [Add customisation for BC39 Objective here] off begin
		String randomStringforBc39Objective = mock
				.strings()
				.get();
		newEntity.setBc39Objective(randomStringforBc39Objective);
		// % protected region % [Add customisation for BC39 Objective here] end
		// % protected region % [Add customisation for BC40 Subjective here] off begin
		String randomStringforBc40Subjective = mock
				.strings()
				.get();
		newEntity.setBc40Subjective(randomStringforBc40Subjective);
		// % protected region % [Add customisation for BC40 Subjective here] end
		// % protected region % [Add customisation for BC40 Objective here] off begin
		String randomStringforBc40Objective = mock
				.strings()
				.get();
		newEntity.setBc40Objective(randomStringforBc40Objective);
		// % protected region % [Add customisation for BC40 Objective here] end
		// % protected region % [Add customisation for BC41 Subjective here] off begin
		String randomStringforBc41Subjective = mock
				.strings()
				.get();
		newEntity.setBc41Subjective(randomStringforBc41Subjective);
		// % protected region % [Add customisation for BC41 Subjective here] end
		// % protected region % [Add customisation for BC41 Objective here] off begin
		String randomStringforBc41Objective = mock
				.strings()
				.get();
		newEntity.setBc41Objective(randomStringforBc41Objective);
		// % protected region % [Add customisation for BC41 Objective here] end
		// % protected region % [Add customisation for BC42 Subjective here] off begin
		String randomStringforBc42Subjective = mock
				.strings()
				.get();
		newEntity.setBc42Subjective(randomStringforBc42Subjective);
		// % protected region % [Add customisation for BC42 Subjective here] end
		// % protected region % [Add customisation for BC42 Objective here] off begin
		String randomStringforBc42Objective = mock
				.strings()
				.get();
		newEntity.setBc42Objective(randomStringforBc42Objective);
		// % protected region % [Add customisation for BC42 Objective here] end
		// % protected region % [Add customisation for BC43 Subjective here] off begin
		String randomStringforBc43Subjective = mock
				.strings()
				.get();
		newEntity.setBc43Subjective(randomStringforBc43Subjective);
		// % protected region % [Add customisation for BC43 Subjective here] end
		// % protected region % [Add customisation for BC43 Objective here] off begin
		String randomStringforBc43Objective = mock
				.strings()
				.get();
		newEntity.setBc43Objective(randomStringforBc43Objective);
		// % protected region % [Add customisation for BC43 Objective here] end
		// % protected region % [Add customisation for BC44 Subjective here] off begin
		String randomStringforBc44Subjective = mock
				.strings()
				.get();
		newEntity.setBc44Subjective(randomStringforBc44Subjective);
		// % protected region % [Add customisation for BC44 Subjective here] end
		// % protected region % [Add customisation for BC44 Objective here] off begin
		String randomStringforBc44Objective = mock
				.strings()
				.get();
		newEntity.setBc44Objective(randomStringforBc44Objective);
		// % protected region % [Add customisation for BC44 Objective here] end
		// % protected region % [Add customisation for BC45 Subjective here] off begin
		String randomStringforBc45Subjective = mock
				.strings()
				.get();
		newEntity.setBc45Subjective(randomStringforBc45Subjective);
		// % protected region % [Add customisation for BC45 Subjective here] end
		// % protected region % [Add customisation for BC45 Objective here] off begin
		String randomStringforBc45Objective = mock
				.strings()
				.get();
		newEntity.setBc45Objective(randomStringforBc45Objective);
		// % protected region % [Add customisation for BC45 Objective here] end
		// % protected region % [Add customisation for BC46 Subjective here] off begin
		String randomStringforBc46Subjective = mock
				.strings()
				.get();
		newEntity.setBc46Subjective(randomStringforBc46Subjective);
		// % protected region % [Add customisation for BC46 Subjective here] end
		// % protected region % [Add customisation for BC46 Objective here] off begin
		String randomStringforBc46Objective = mock
				.strings()
				.get();
		newEntity.setBc46Objective(randomStringforBc46Objective);
		// % protected region % [Add customisation for BC46 Objective here] end
		// % protected region % [Add customisation for BC47 Subjective here] off begin
		String randomStringforBc47Subjective = mock
				.strings()
				.get();
		newEntity.setBc47Subjective(randomStringforBc47Subjective);
		// % protected region % [Add customisation for BC47 Subjective here] end
		// % protected region % [Add customisation for BC47 Objective here] off begin
		String randomStringforBc47Objective = mock
				.strings()
				.get();
		newEntity.setBc47Objective(randomStringforBc47Objective);
		// % protected region % [Add customisation for BC47 Objective here] end
		// % protected region % [Add customisation for BC48 Subjective here] off begin
		String randomStringforBc48Subjective = mock
				.strings()
				.get();
		newEntity.setBc48Subjective(randomStringforBc48Subjective);
		// % protected region % [Add customisation for BC48 Subjective here] end
		// % protected region % [Add customisation for BC48 Objective here] off begin
		String randomStringforBc48Objective = mock
				.strings()
				.get();
		newEntity.setBc48Objective(randomStringforBc48Objective);
		// % protected region % [Add customisation for BC48 Objective here] end
		// % protected region % [Add customisation for BC49 Subjective here] off begin
		String randomStringforBc49Subjective = mock
				.strings()
				.get();
		newEntity.setBc49Subjective(randomStringforBc49Subjective);
		// % protected region % [Add customisation for BC49 Subjective here] end
		// % protected region % [Add customisation for BC49 Objective here] off begin
		String randomStringforBc49Objective = mock
				.strings()
				.get();
		newEntity.setBc49Objective(randomStringforBc49Objective);
		// % protected region % [Add customisation for BC49 Objective here] end
		// % protected region % [Add customisation for BC50 Subjective here] off begin
		String randomStringforBc50Subjective = mock
				.strings()
				.get();
		newEntity.setBc50Subjective(randomStringforBc50Subjective);
		// % protected region % [Add customisation for BC50 Subjective here] end
		// % protected region % [Add customisation for BC50 Objective here] off begin
		String randomStringforBc50Objective = mock
				.strings()
				.get();
		newEntity.setBc50Objective(randomStringforBc50Objective);
		// % protected region % [Add customisation for BC50 Objective here] end
		// % protected region % [Add customisation for BC51 Subjective here] off begin
		String randomStringforBc51Subjective = mock
				.strings()
				.get();
		newEntity.setBc51Subjective(randomStringforBc51Subjective);
		// % protected region % [Add customisation for BC51 Subjective here] end
		// % protected region % [Add customisation for BC51 Objective here] off begin
		String randomStringforBc51Objective = mock
				.strings()
				.get();
		newEntity.setBc51Objective(randomStringforBc51Objective);
		// % protected region % [Add customisation for BC51 Objective here] end
		// % protected region % [Add customisation for BC52 Subjective here] off begin
		String randomStringforBc52Subjective = mock
				.strings()
				.get();
		newEntity.setBc52Subjective(randomStringforBc52Subjective);
		// % protected region % [Add customisation for BC52 Subjective here] end
		// % protected region % [Add customisation for BC52 Objective here] off begin
		String randomStringforBc52Objective = mock
				.strings()
				.get();
		newEntity.setBc52Objective(randomStringforBc52Objective);
		// % protected region % [Add customisation for BC52 Objective here] end
		// % protected region % [Add customisation for BC53 Subjective here] off begin
		String randomStringforBc53Subjective = mock
				.strings()
				.get();
		newEntity.setBc53Subjective(randomStringforBc53Subjective);
		// % protected region % [Add customisation for BC53 Subjective here] end
		// % protected region % [Add customisation for BC53 Objective here] off begin
		String randomStringforBc53Objective = mock
				.strings()
				.get();
		newEntity.setBc53Objective(randomStringforBc53Objective);
		// % protected region % [Add customisation for BC53 Objective here] end
		// % protected region % [Add customisation for BC54 Subjective here] off begin
		String randomStringforBc54Subjective = mock
				.strings()
				.get();
		newEntity.setBc54Subjective(randomStringforBc54Subjective);
		// % protected region % [Add customisation for BC54 Subjective here] end
		// % protected region % [Add customisation for BC54 Objective here] off begin
		String randomStringforBc54Objective = mock
				.strings()
				.get();
		newEntity.setBc54Objective(randomStringforBc54Objective);
		// % protected region % [Add customisation for BC54 Objective here] end
		// % protected region % [Add customisation for BC55 Subjective here] off begin
		String randomStringforBc55Subjective = mock
				.strings()
				.get();
		newEntity.setBc55Subjective(randomStringforBc55Subjective);
		// % protected region % [Add customisation for BC55 Subjective here] end
		// % protected region % [Add customisation for BC55 Objective here] off begin
		String randomStringforBc55Objective = mock
				.strings()
				.get();
		newEntity.setBc55Objective(randomStringforBc55Objective);
		// % protected region % [Add customisation for BC55 Objective here] end
		// % protected region % [Add customisation for BC56 Subjective here] off begin
		String randomStringforBc56Subjective = mock
				.strings()
				.get();
		newEntity.setBc56Subjective(randomStringforBc56Subjective);
		// % protected region % [Add customisation for BC56 Subjective here] end
		// % protected region % [Add customisation for BC56 Objective here] off begin
		String randomStringforBc56Objective = mock
				.strings()
				.get();
		newEntity.setBc56Objective(randomStringforBc56Objective);
		// % protected region % [Add customisation for BC56 Objective here] end
		// % protected region % [Add customisation for BC57 Subjective here] off begin
		String randomStringforBc57Subjective = mock
				.strings()
				.get();
		newEntity.setBc57Subjective(randomStringforBc57Subjective);
		// % protected region % [Add customisation for BC57 Subjective here] end
		// % protected region % [Add customisation for BC57 Objective here] off begin
		String randomStringforBc57Objective = mock
				.strings()
				.get();
		newEntity.setBc57Objective(randomStringforBc57Objective);
		// % protected region % [Add customisation for BC57 Objective here] end
		// % protected region % [Add customisation for BC58 Subjective here] off begin
		String randomStringforBc58Subjective = mock
				.strings()
				.get();
		newEntity.setBc58Subjective(randomStringforBc58Subjective);
		// % protected region % [Add customisation for BC58 Subjective here] end
		// % protected region % [Add customisation for BC58 Objective here] off begin
		String randomStringforBc58Objective = mock
				.strings()
				.get();
		newEntity.setBc58Objective(randomStringforBc58Objective);
		// % protected region % [Add customisation for BC58 Objective here] end
		// % protected region % [Add customisation for BC59 Subjective here] off begin
		String randomStringforBc59Subjective = mock
				.strings()
				.get();
		newEntity.setBc59Subjective(randomStringforBc59Subjective);
		// % protected region % [Add customisation for BC59 Subjective here] end
		// % protected region % [Add customisation for BC59 Objective here] off begin
		String randomStringforBc59Objective = mock
				.strings()
				.get();
		newEntity.setBc59Objective(randomStringforBc59Objective);
		// % protected region % [Add customisation for BC59 Objective here] end
		// % protected region % [Add customisation for BC60 Subjective here] off begin
		String randomStringforBc60Subjective = mock
				.strings()
				.get();
		newEntity.setBc60Subjective(randomStringforBc60Subjective);
		// % protected region % [Add customisation for BC60 Subjective here] end
		// % protected region % [Add customisation for BC60 Objective here] off begin
		String randomStringforBc60Objective = mock
				.strings()
				.get();
		newEntity.setBc60Objective(randomStringforBc60Objective);
		// % protected region % [Add customisation for BC60 Objective here] end
		// % protected region % [Add customisation for BC61 Subjective here] off begin
		String randomStringforBc61Subjective = mock
				.strings()
				.get();
		newEntity.setBc61Subjective(randomStringforBc61Subjective);
		// % protected region % [Add customisation for BC61 Subjective here] end
		// % protected region % [Add customisation for BC61 Objective here] off begin
		String randomStringforBc61Objective = mock
				.strings()
				.get();
		newEntity.setBc61Objective(randomStringforBc61Objective);
		// % protected region % [Add customisation for BC61 Objective here] end
		// % protected region % [Add customisation for BC62 Subjective here] off begin
		String randomStringforBc62Subjective = mock
				.strings()
				.get();
		newEntity.setBc62Subjective(randomStringforBc62Subjective);
		// % protected region % [Add customisation for BC62 Subjective here] end
		// % protected region % [Add customisation for BC62 Objective here] off begin
		String randomStringforBc62Objective = mock
				.strings()
				.get();
		newEntity.setBc62Objective(randomStringforBc62Objective);
		// % protected region % [Add customisation for BC62 Objective here] end
		// % protected region % [Add customisation for BC63 Subjective here] off begin
		String randomStringforBc63Subjective = mock
				.strings()
				.get();
		newEntity.setBc63Subjective(randomStringforBc63Subjective);
		// % protected region % [Add customisation for BC63 Subjective here] end
		// % protected region % [Add customisation for BC63 Objective here] off begin
		String randomStringforBc63Objective = mock
				.strings()
				.get();
		newEntity.setBc63Objective(randomStringforBc63Objective);
		// % protected region % [Add customisation for BC63 Objective here] end
		// % protected region % [Add customisation for BC64 Subjective here] off begin
		String randomStringforBc64Subjective = mock
				.strings()
				.get();
		newEntity.setBc64Subjective(randomStringforBc64Subjective);
		// % protected region % [Add customisation for BC64 Subjective here] end
		// % protected region % [Add customisation for BC64 Objective here] off begin
		String randomStringforBc64Objective = mock
				.strings()
				.get();
		newEntity.setBc64Objective(randomStringforBc64Objective);
		// % protected region % [Add customisation for BC64 Objective here] end
		// % protected region % [Add customisation for BC65 Subjective here] off begin
		String randomStringforBc65Subjective = mock
				.strings()
				.get();
		newEntity.setBc65Subjective(randomStringforBc65Subjective);
		// % protected region % [Add customisation for BC65 Subjective here] end
		// % protected region % [Add customisation for BC65 Objective here] off begin
		String randomStringforBc65Objective = mock
				.strings()
				.get();
		newEntity.setBc65Objective(randomStringforBc65Objective);
		// % protected region % [Add customisation for BC65 Objective here] end
		// % protected region % [Add customisation for BC66 Subjective here] off begin
		String randomStringforBc66Subjective = mock
				.strings()
				.get();
		newEntity.setBc66Subjective(randomStringforBc66Subjective);
		// % protected region % [Add customisation for BC66 Subjective here] end
		// % protected region % [Add customisation for BC66 Objective here] off begin
		String randomStringforBc66Objective = mock
				.strings()
				.get();
		newEntity.setBc66Objective(randomStringforBc66Objective);
		// % protected region % [Add customisation for BC66 Objective here] end
		// % protected region % [Add customisation for BC67 Subjective here] off begin
		String randomStringforBc67Subjective = mock
				.strings()
				.get();
		newEntity.setBc67Subjective(randomStringforBc67Subjective);
		// % protected region % [Add customisation for BC67 Subjective here] end
		// % protected region % [Add customisation for BC67 Objective here] off begin
		String randomStringforBc67Objective = mock
				.strings()
				.get();
		newEntity.setBc67Objective(randomStringforBc67Objective);
		// % protected region % [Add customisation for BC67 Objective here] end
		// % protected region % [Add customisation for BC68 Subjective here] off begin
		String randomStringforBc68Subjective = mock
				.strings()
				.get();
		newEntity.setBc68Subjective(randomStringforBc68Subjective);
		// % protected region % [Add customisation for BC68 Subjective here] end
		// % protected region % [Add customisation for BC68 Objective here] off begin
		String randomStringforBc68Objective = mock
				.strings()
				.get();
		newEntity.setBc68Objective(randomStringforBc68Objective);
		// % protected region % [Add customisation for BC68 Objective here] end
		// % protected region % [Add customisation for BC69 Subjective here] off begin
		String randomStringforBc69Subjective = mock
				.strings()
				.get();
		newEntity.setBc69Subjective(randomStringforBc69Subjective);
		// % protected region % [Add customisation for BC69 Subjective here] end
		// % protected region % [Add customisation for BC69 Objective here] off begin
		String randomStringforBc69Objective = mock
				.strings()
				.get();
		newEntity.setBc69Objective(randomStringforBc69Objective);
		// % protected region % [Add customisation for BC69 Objective here] end
		// % protected region % [Add customisation for BC70 Subjective here] off begin
		String randomStringforBc70Subjective = mock
				.strings()
				.get();
		newEntity.setBc70Subjective(randomStringforBc70Subjective);
		// % protected region % [Add customisation for BC70 Subjective here] end
		// % protected region % [Add customisation for BC70 Objective here] off begin
		String randomStringforBc70Objective = mock
				.strings()
				.get();
		newEntity.setBc70Objective(randomStringforBc70Objective);
		// % protected region % [Add customisation for BC70 Objective here] end
		// % protected region % [Add customisation for BC71 Subjective here] off begin
		String randomStringforBc71Subjective = mock
				.strings()
				.get();
		newEntity.setBc71Subjective(randomStringforBc71Subjective);
		// % protected region % [Add customisation for BC71 Subjective here] end
		// % protected region % [Add customisation for BC71 Objective here] off begin
		String randomStringforBc71Objective = mock
				.strings()
				.get();
		newEntity.setBc71Objective(randomStringforBc71Objective);
		// % protected region % [Add customisation for BC71 Objective here] end
		// % protected region % [Add customisation for BC72 Subjective here] off begin
		String randomStringforBc72Subjective = mock
				.strings()
				.get();
		newEntity.setBc72Subjective(randomStringforBc72Subjective);
		// % protected region % [Add customisation for BC72 Subjective here] end
		// % protected region % [Add customisation for BC72 Objective here] off begin
		String randomStringforBc72Objective = mock
				.strings()
				.get();
		newEntity.setBc72Objective(randomStringforBc72Objective);
		// % protected region % [Add customisation for BC72 Objective here] end
		// % protected region % [Add customisation for BC73 Subjective here] off begin
		String randomStringforBc73Subjective = mock
				.strings()
				.get();
		newEntity.setBc73Subjective(randomStringforBc73Subjective);
		// % protected region % [Add customisation for BC73 Subjective here] end
		// % protected region % [Add customisation for BC73 Objective here] off begin
		String randomStringforBc73Objective = mock
				.strings()
				.get();
		newEntity.setBc73Objective(randomStringforBc73Objective);
		// % protected region % [Add customisation for BC73 Objective here] end
		// % protected region % [Add customisation for BC74 Subjective here] off begin
		String randomStringforBc74Subjective = mock
				.strings()
				.get();
		newEntity.setBc74Subjective(randomStringforBc74Subjective);
		// % protected region % [Add customisation for BC74 Subjective here] end
		// % protected region % [Add customisation for BC74 Objective here] off begin
		String randomStringforBc74Objective = mock
				.strings()
				.get();
		newEntity.setBc74Objective(randomStringforBc74Objective);
		// % protected region % [Add customisation for BC74 Objective here] end
		// % protected region % [Add customisation for BC75 Subjective here] off begin
		String randomStringforBc75Subjective = mock
				.strings()
				.get();
		newEntity.setBc75Subjective(randomStringforBc75Subjective);
		// % protected region % [Add customisation for BC75 Subjective here] end
		// % protected region % [Add customisation for BC75 Objective here] off begin
		String randomStringforBc75Objective = mock
				.strings()
				.get();
		newEntity.setBc75Objective(randomStringforBc75Objective);
		// % protected region % [Add customisation for BC75 Objective here] end
		// % protected region % [Add customisation for BC76 Subjective here] off begin
		String randomStringforBc76Subjective = mock
				.strings()
				.get();
		newEntity.setBc76Subjective(randomStringforBc76Subjective);
		// % protected region % [Add customisation for BC76 Subjective here] end
		// % protected region % [Add customisation for BC76 Objective here] off begin
		String randomStringforBc76Objective = mock
				.strings()
				.get();
		newEntity.setBc76Objective(randomStringforBc76Objective);
		// % protected region % [Add customisation for BC76 Objective here] end
		// % protected region % [Add customisation for BC77 Subjective here] off begin
		String randomStringforBc77Subjective = mock
				.strings()
				.get();
		newEntity.setBc77Subjective(randomStringforBc77Subjective);
		// % protected region % [Add customisation for BC77 Subjective here] end
		// % protected region % [Add customisation for BC77 Objective here] off begin
		String randomStringforBc77Objective = mock
				.strings()
				.get();
		newEntity.setBc77Objective(randomStringforBc77Objective);
		// % protected region % [Add customisation for BC77 Objective here] end
		// % protected region % [Add customisation for BC78 Subjective here] off begin
		String randomStringforBc78Subjective = mock
				.strings()
				.get();
		newEntity.setBc78Subjective(randomStringforBc78Subjective);
		// % protected region % [Add customisation for BC78 Subjective here] end
		// % protected region % [Add customisation for BC78 Objective here] off begin
		String randomStringforBc78Objective = mock
				.strings()
				.get();
		newEntity.setBc78Objective(randomStringforBc78Objective);
		// % protected region % [Add customisation for BC78 Objective here] end
		// % protected region % [Add customisation for BC79 Subjective here] off begin
		String randomStringforBc79Subjective = mock
				.strings()
				.get();
		newEntity.setBc79Subjective(randomStringforBc79Subjective);
		// % protected region % [Add customisation for BC79 Subjective here] end
		// % protected region % [Add customisation for BC79 Objective here] off begin
		String randomStringforBc79Objective = mock
				.strings()
				.get();
		newEntity.setBc79Objective(randomStringforBc79Objective);
		// % protected region % [Add customisation for BC79 Objective here] end
		// % protected region % [Add customisation for BC80 Subjective here] off begin
		String randomStringforBc80Subjective = mock
				.strings()
				.get();
		newEntity.setBc80Subjective(randomStringforBc80Subjective);
		// % protected region % [Add customisation for BC80 Subjective here] end
		// % protected region % [Add customisation for BC80 Objective here] off begin
		String randomStringforBc80Objective = mock
				.strings()
				.get();
		newEntity.setBc80Objective(randomStringforBc80Objective);
		// % protected region % [Add customisation for BC80 Objective here] end
		// % protected region % [Add customisation for BC81 Subjective here] off begin
		String randomStringforBc81Subjective = mock
				.strings()
				.get();
		newEntity.setBc81Subjective(randomStringforBc81Subjective);
		// % protected region % [Add customisation for BC81 Subjective here] end
		// % protected region % [Add customisation for BC81 Objective here] off begin
		String randomStringforBc81Objective = mock
				.strings()
				.get();
		newEntity.setBc81Objective(randomStringforBc81Objective);
		// % protected region % [Add customisation for BC81 Objective here] end
		// % protected region % [Add customisation for BC82 Subjective here] off begin
		String randomStringforBc82Subjective = mock
				.strings()
				.get();
		newEntity.setBc82Subjective(randomStringforBc82Subjective);
		// % protected region % [Add customisation for BC82 Subjective here] end
		// % protected region % [Add customisation for BC82 Objective here] off begin
		String randomStringforBc82Objective = mock
				.strings()
				.get();
		newEntity.setBc82Objective(randomStringforBc82Objective);
		// % protected region % [Add customisation for BC82 Objective here] end
		// % protected region % [Add customisation for BC83 Subjective here] off begin
		String randomStringforBc83Subjective = mock
				.strings()
				.get();
		newEntity.setBc83Subjective(randomStringforBc83Subjective);
		// % protected region % [Add customisation for BC83 Subjective here] end
		// % protected region % [Add customisation for BC83 Objective here] off begin
		String randomStringforBc83Objective = mock
				.strings()
				.get();
		newEntity.setBc83Objective(randomStringforBc83Objective);
		// % protected region % [Add customisation for BC83 Objective here] end
		// % protected region % [Add customisation for BC84 Subjective here] off begin
		String randomStringforBc84Subjective = mock
				.strings()
				.get();
		newEntity.setBc84Subjective(randomStringforBc84Subjective);
		// % protected region % [Add customisation for BC84 Subjective here] end
		// % protected region % [Add customisation for BC84 Objective here] off begin
		String randomStringforBc84Objective = mock
				.strings()
				.get();
		newEntity.setBc84Objective(randomStringforBc84Objective);
		// % protected region % [Add customisation for BC84 Objective here] end

		// % protected region % [Apply any additional logic for bodyChartExaminationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bodyChartExaminationWithNoRef after the main body here] end

		log.trace("Created entity of type BodyChartExaminationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Body Chart Examination entities with no reference at all.
	 */
	@Provides
	@Named("bodyChartExaminationEntitiesWithNoRef")
	public Collection<BodyChartExaminationEntity> bodyChartExaminationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bodyChartExaminationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bodyChartExaminationEntitiesWithNoRef here] end
		BodyChartExaminationEntityFactory bodyChartExaminationEntityFactory
	) {
		log.trace("Creating entities of type BodyChartExaminationEntity with no reference");

		// % protected region % [Apply any additional logic for bodyChartExaminationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bodyChartExaminationEntitiesWithNoRef before the main body here] end

		Collection<BodyChartExaminationEntity> newEntities = bodyChartExaminationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bodyChartExaminationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bodyChartExaminationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BodyChartExaminationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Body Chart Examination entity with all references set.
	 */
	@Provides
	@Named("bodyChartExaminationEntityWithRefs")
	public BodyChartExaminationEntity bodyChartExaminationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bodyChartExaminationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bodyChartExaminationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BodyChartExaminationEntity with references");

		// % protected region % [Apply any additional logic for bodyChartExaminationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bodyChartExaminationEntityWithRefs before the main body here] end

		BodyChartExaminationEntity bodyChartExaminationEntity = injector.getInstance(Key.get(BodyChartExaminationEntity.class, Names.named("bodyChartExaminationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bodyChartExaminationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bodyChartExaminationEntityWithRefs after the main body here] end

		log.trace("Created entity of type BodyChartExaminationEntity with references");

		return bodyChartExaminationEntity;
	}

	/**
	 * Return a collection of Body Chart Examination entities with all references set.
	 */
	@Provides
	@Named("bodyChartExaminationEntitiesWithRefs")
	public Collection<BodyChartExaminationEntity> bodyChartExaminationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bodyChartExaminationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bodyChartExaminationEntitiesWithRefs here] end
		BodyChartExaminationEntityFactory bodyChartExaminationEntityFactory
	) {
		log.trace("Creating entities of type BodyChartExaminationEntity with references");

		// % protected region % [Apply any additional logic for bodyChartExaminationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bodyChartExaminationEntitiesWithRefs before the main body here] end

		Collection<BodyChartExaminationEntity> newEntities = bodyChartExaminationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bodyChartExaminationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bodyChartExaminationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BodyChartExaminationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
