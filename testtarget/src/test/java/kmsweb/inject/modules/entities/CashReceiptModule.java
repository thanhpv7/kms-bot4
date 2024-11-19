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
 * Guice module for Cash Receipt used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class CashReceiptModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring CashReceiptModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured CashReceiptModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public CashReceiptEntityFactory cashReceiptEntityFactory(
			// % protected region % [Apply any additional injected arguments for cashReceiptEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for cashReceiptEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating CashReceiptEntityFactory");

		// % protected region % [Apply any additional logic for cashReceiptEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for cashReceiptEntityFactory before the main body here] end

		CashReceiptEntityFactory entityFactory = new CashReceiptEntityFactory(
				// % protected region % [Apply any additional constructor arguments for CashReceiptEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for CashReceiptEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for cashReceiptEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for cashReceiptEntityFactory after the main body here] end

		log.trace("Created CashReceiptEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Cash Receipt entity with no references set.
	 */
	@Provides
	@Named("cashReceiptEntityWithNoRef")
	public CashReceiptEntity cashReceiptEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for cashReceiptEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for cashReceiptEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type CashReceiptEntity with no reference");

		// % protected region % [Apply any additional logic for cashReceiptWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for cashReceiptWithNoRef before the main body here] end

		CashReceiptEntity newEntity = new CashReceiptEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Receipt Type here] off begin
		newEntity.setReceiptType(ReceiptTypeEnum.PAYMENT);
		// % protected region % [Add customisation for Receipt Type here] end
		// % protected region % [Add customisation for Receipt Number here] off begin
		String randomStringforReceiptNumber = mock
				.strings()
				.get();
		newEntity.setReceiptNumber(randomStringforReceiptNumber);
		// % protected region % [Add customisation for Receipt Number here] end
		// % protected region % [Add customisation for Payment Date here] off begin
		newEntity.setPaymentDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Payment Date here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Payment Type here] off begin
		String randomStringforPaymentType = mock
				.strings()
				.get();
		newEntity.setPaymentType(randomStringforPaymentType);
		// % protected region % [Add customisation for Payment Type here] end
		// % protected region % [Add customisation for Receive Amount here] off begin
		newEntity.setReceiveAmount(mock.doubles().get());
		// % protected region % [Add customisation for Receive Amount here] end
		// % protected region % [Add customisation for IsVoid here] off begin
		newEntity.setIsvoid(mock.bools().get());
		// % protected region % [Add customisation for IsVoid here] end
		// % protected region % [Add customisation for Cashier Location here] off begin
		String randomStringforCashierLocation = mock
				.strings()
				.get();
		newEntity.setCashierLocation(randomStringforCashierLocation);
		// % protected region % [Add customisation for Cashier Location here] end
		// % protected region % [Add customisation for Void Date Time here] off begin
		newEntity.setVoidDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Void Date Time here] end
		// % protected region % [Add customisation for Cash Change Type here] off begin
		newEntity.setCashChangeType(CashChangeTypeEnum.NO_CHANGE);
		// % protected region % [Add customisation for Cash Change Type here] end
		// % protected region % [Add customisation for Change Amount here] off begin
		newEntity.setChangeAmount(mock.doubles().get());
		// % protected region % [Add customisation for Change Amount here] end
		// % protected region % [Add customisation for Allocated Amount here] off begin
		newEntity.setAllocatedAmount(mock.doubles().get());
		// % protected region % [Add customisation for Allocated Amount here] end
		// % protected region % [Add customisation for Rounding Amount here] off begin
		newEntity.setRoundingAmount(mock.doubles().get());
		// % protected region % [Add customisation for Rounding Amount here] end
		// % protected region % [Add customisation for Available Amount here] off begin
		newEntity.setAvailableAmount(mock.doubles().get());
		// % protected region % [Add customisation for Available Amount here] end
		// % protected region % [Add customisation for Bank Name here] off begin
		String randomStringforBankName = mock
				.strings()
				.get();
		newEntity.setBankName(randomStringforBankName);
		// % protected region % [Add customisation for Bank Name here] end
		// % protected region % [Add customisation for Card Type here] off begin
		String randomStringforCardType = mock
				.strings()
				.get();
		newEntity.setCardType(randomStringforCardType);
		// % protected region % [Add customisation for Card Type here] end
		// % protected region % [Add customisation for Card No here] off begin
		String randomStringforCardNo = mock
				.strings()
				.get();
		newEntity.setCardNo(randomStringforCardNo);
		// % protected region % [Add customisation for Card No here] end
		// % protected region % [Add customisation for Card Holder here] off begin
		String randomStringforCardHolder = mock
				.strings()
				.get();
		newEntity.setCardHolder(randomStringforCardHolder);
		// % protected region % [Add customisation for Card Holder here] end
		// % protected region % [Add customisation for Reference Number here] off begin
		String randomStringforReferenceNumber = mock
				.strings()
				.get();
		newEntity.setReferenceNumber(randomStringforReferenceNumber);
		// % protected region % [Add customisation for Reference Number here] end
		// % protected region % [Add customisation for Hospital Bank Account here] off begin
		String randomStringforHospitalBankAccount = mock
				.strings()
				.get();
		newEntity.setHospitalBankAccount(randomStringforHospitalBankAccount);
		// % protected region % [Add customisation for Hospital Bank Account here] end
		// % protected region % [Add customisation for Surcharge Amount here] off begin
		newEntity.setSurchargeAmount(mock.doubles().get());
		// % protected region % [Add customisation for Surcharge Amount here] end
		// % protected region % [Add customisation for Outstanding Amount here] off begin
		newEntity.setOutstandingAmount(mock.doubles().get());
		// % protected region % [Add customisation for Outstanding Amount here] end
		// % protected region % [Add customisation for Received From here] off begin
		String randomStringforReceivedFrom = mock
				.strings()
				.get();
		newEntity.setReceivedFrom(randomStringforReceivedFrom);
		// % protected region % [Add customisation for Received From here] end
		// % protected region % [Add customisation for Patient Or Customer Name here] off begin
		String randomStringforPatientOrCustomerName = mock
				.strings()
				.get();
		newEntity.setPatientOrCustomerName(randomStringforPatientOrCustomerName);
		// % protected region % [Add customisation for Patient Or Customer Name here] end

		// % protected region % [Apply any additional logic for cashReceiptWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for cashReceiptWithNoRef after the main body here] end

		log.trace("Created entity of type CashReceiptEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Cash Receipt entities with no reference at all.
	 */
	@Provides
	@Named("cashReceiptEntitiesWithNoRef")
	public Collection<CashReceiptEntity> cashReceiptEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for cashReceiptEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for cashReceiptEntitiesWithNoRef here] end
		CashReceiptEntityFactory cashReceiptEntityFactory
	) {
		log.trace("Creating entities of type CashReceiptEntity with no reference");

		// % protected region % [Apply any additional logic for cashReceiptEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for cashReceiptEntitiesWithNoRef before the main body here] end

		Collection<CashReceiptEntity> newEntities = cashReceiptEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for cashReceiptEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for cashReceiptEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type CashReceiptEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Cash Receipt entity with all references set.
	 */
	@Provides
	@Named("cashReceiptEntityWithRefs")
	public CashReceiptEntity cashReceiptEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for cashReceiptEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for cashReceiptEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type CashReceiptEntity with references");

		// % protected region % [Apply any additional logic for cashReceiptEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for cashReceiptEntityWithRefs before the main body here] end

		CashReceiptEntity cashReceiptEntity = injector.getInstance(Key.get(CashReceiptEntity.class, Names.named("cashReceiptEntityWithNoRef")));

		// % protected region % [Apply any additional logic for cashReceiptEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for cashReceiptEntityWithRefs after the main body here] end

		log.trace("Created entity of type CashReceiptEntity with references");

		return cashReceiptEntity;
	}

	/**
	 * Return a collection of Cash Receipt entities with all references set.
	 */
	@Provides
	@Named("cashReceiptEntitiesWithRefs")
	public Collection<CashReceiptEntity> cashReceiptEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for cashReceiptEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for cashReceiptEntitiesWithRefs here] end
		CashReceiptEntityFactory cashReceiptEntityFactory
	) {
		log.trace("Creating entities of type CashReceiptEntity with references");

		// % protected region % [Apply any additional logic for cashReceiptEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for cashReceiptEntitiesWithRefs before the main body here] end

		Collection<CashReceiptEntity> newEntities = cashReceiptEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for cashReceiptEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for cashReceiptEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type CashReceiptEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
