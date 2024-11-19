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
 * Guice module for Cash Refund used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class CashRefundModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring CashRefundModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured CashRefundModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public CashRefundEntityFactory cashRefundEntityFactory(
			// % protected region % [Apply any additional injected arguments for cashRefundEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for cashRefundEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating CashRefundEntityFactory");

		// % protected region % [Apply any additional logic for cashRefundEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for cashRefundEntityFactory before the main body here] end

		CashRefundEntityFactory entityFactory = new CashRefundEntityFactory(
				// % protected region % [Apply any additional constructor arguments for CashRefundEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for CashRefundEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for cashRefundEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for cashRefundEntityFactory after the main body here] end

		log.trace("Created CashRefundEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Cash Refund entity with no references set.
	 */
	@Provides
	@Named("cashRefundEntityWithNoRef")
	public CashRefundEntity cashRefundEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for cashRefundEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for cashRefundEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type CashRefundEntity with no reference");

		// % protected region % [Apply any additional logic for cashRefundWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for cashRefundWithNoRef before the main body here] end

		CashRefundEntity newEntity = new CashRefundEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Refund Number here] off begin
		String randomStringforRefundNumber = mock
				.strings()
				.get();
		newEntity.setRefundNumber(randomStringforRefundNumber);
		// % protected region % [Add customisation for Refund Number here] end
		// % protected region % [Add customisation for Refund Date here] off begin
		newEntity.setRefundDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Refund Date here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Cashier Location here] off begin
		String randomStringforCashierLocation = mock
				.strings()
				.get();
		newEntity.setCashierLocation(randomStringforCashierLocation);
		// % protected region % [Add customisation for Cashier Location here] end
		// % protected region % [Add customisation for IsVoid here] off begin
		newEntity.setIsvoid(mock.bools().get());
		// % protected region % [Add customisation for IsVoid here] end
		// % protected region % [Add customisation for Void Date Time here] off begin
		newEntity.setVoidDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Void Date Time here] end
		// % protected region % [Add customisation for Payment Type here] off begin
		String randomStringforPaymentType = mock
				.strings()
				.get();
		newEntity.setPaymentType(randomStringforPaymentType);
		// % protected region % [Add customisation for Payment Type here] end
		// % protected region % [Add customisation for Refund Amount here] off begin
		newEntity.setRefundAmount(mock.doubles().get());
		// % protected region % [Add customisation for Refund Amount here] end
		// % protected region % [Add customisation for Hospital Bank Account here] off begin
		String randomStringforHospitalBankAccount = mock
				.strings()
				.get();
		newEntity.setHospitalBankAccount(randomStringforHospitalBankAccount);
		// % protected region % [Add customisation for Hospital Bank Account here] end
		// % protected region % [Add customisation for Reference Number here] off begin
		String randomStringforReferenceNumber = mock
				.strings()
				.get();
		newEntity.setReferenceNumber(randomStringforReferenceNumber);
		// % protected region % [Add customisation for Reference Number here] end

		// % protected region % [Apply any additional logic for cashRefundWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for cashRefundWithNoRef after the main body here] end

		log.trace("Created entity of type CashRefundEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Cash Refund entities with no reference at all.
	 */
	@Provides
	@Named("cashRefundEntitiesWithNoRef")
	public Collection<CashRefundEntity> cashRefundEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for cashRefundEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for cashRefundEntitiesWithNoRef here] end
		CashRefundEntityFactory cashRefundEntityFactory
	) {
		log.trace("Creating entities of type CashRefundEntity with no reference");

		// % protected region % [Apply any additional logic for cashRefundEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for cashRefundEntitiesWithNoRef before the main body here] end

		Collection<CashRefundEntity> newEntities = cashRefundEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for cashRefundEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for cashRefundEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type CashRefundEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Cash Refund entity with all references set.
	 */
	@Provides
	@Named("cashRefundEntityWithRefs")
	public CashRefundEntity cashRefundEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for cashRefundEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for cashRefundEntityWithRefs here] end
			@Named("patientGeneralInfoEntityWithRefs") PatientGeneralInfoEntity patientGeneralInfo,
			Injector injector
	) {
		log.trace("Creating entity of type CashRefundEntity with references");

		// % protected region % [Apply any additional logic for cashRefundEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for cashRefundEntityWithRefs before the main body here] end

		CashRefundEntity cashRefundEntity = injector.getInstance(Key.get(CashRefundEntity.class, Names.named("cashRefundEntityWithNoRef")));
		cashRefundEntity.setPatientGeneralInfo(patientGeneralInfo, true);

		// % protected region % [Apply any additional logic for cashRefundEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for cashRefundEntityWithRefs after the main body here] end

		log.trace("Created entity of type CashRefundEntity with references");

		return cashRefundEntity;
	}

	/**
	 * Return a collection of Cash Refund entities with all references set.
	 */
	@Provides
	@Named("cashRefundEntitiesWithRefs")
	public Collection<CashRefundEntity> cashRefundEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for cashRefundEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for cashRefundEntitiesWithRefs here] end
		CashRefundEntityFactory cashRefundEntityFactory
	) {
		log.trace("Creating entities of type CashRefundEntity with references");

		// % protected region % [Apply any additional logic for cashRefundEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for cashRefundEntitiesWithRefs before the main body here] end

		Collection<CashRefundEntity> newEntities = cashRefundEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for cashRefundEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for cashRefundEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type CashRefundEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
