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
import kmsweb.entities.ExaminationItemEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class ExaminationItemFactory implements FactoryBean<ExaminationItemEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public ExaminationItemEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public ExaminationItemEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public ExaminationItemEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for examinationItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemWithNoRef before the main body here] end

		ExaminationItemEntity newEntity = new ExaminationItemEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Item Code here] off begin
		String randomStringForItemCode = mockNeat
				.strings()
				.get();
		newEntity.setItemCode(randomStringForItemCode);
		// % protected region % [Add customisation for Item Code here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringForDescription = mockNeat
				.strings()
				.get();
		newEntity.setDescription(randomStringForDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Sample here] off begin
		String randomStringForSample = mockNeat
				.strings()
				.get();
		newEntity.setSample(randomStringForSample);
		// % protected region % [Add customisation for Sample here] end
		// % protected region % [Add customisation for Examination Level here] off begin
		String randomStringForExaminationLevel = mockNeat
				.strings()
				.get();
		newEntity.setExaminationLevel(randomStringForExaminationLevel);
		// % protected region % [Add customisation for Examination Level here] end
		// % protected region % [Add customisation for Examination Type here] off begin
		String randomStringForExaminationType = mockNeat
				.strings()
				.get();
		newEntity.setExaminationType(randomStringForExaminationType);
		// % protected region % [Add customisation for Examination Type here] end

		// % protected region % [Apply any additional logic for examinationItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyExamination Group here] off begin
			var examinationGroupFactory = new ExaminationGroupFactory();
			newEntity.setExaminationGroup(examinationGroupFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyExamination Group here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyService Item here] off begin
			var serviceItemFactory = new ServiceItemFactory();
			newEntity.setServiceItem(serviceItemFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyService Item here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Diagnostic Examination Results here] off begin
			// Outgoing one to many reference
			var diagnosticExaminationResultsFactory = new DiagnosticExaminationResultsFactory();
			newEntity.setDiagnosticExaminationResults(Collections.singletonList(diagnosticExaminationResultsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Diagnostic Examination Results here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Examination Item Details here] off begin
			// Outgoing one to many reference
			var examinationItemDetailsFactory = new ExaminationItemDetailFactory();
			newEntity.setExaminationItemDetails(Collections.singletonList(examinationItemDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Examination Item Details here] end

			// % protected region % [Override the reference inclusion for outgoingManyToMany Examination Item of MCU Item here] off begin
			// Outgoing many to many reference
			var examinationItemOfMCUItemFactory = new McuPackageItemFactory();
			newEntity.setExaminationItemOfMCUItem(Collections.singletonList(examinationItemOfMCUItemFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingManyToMany Examination Item of MCU Item here] end

			// % protected region % [Override the reference inclusion for outgoingManyToMany Registrations here] off begin
			// Outgoing many to many reference
			var registrationsFactory = new RegistrationFactory();
			newEntity.setRegistrations(Collections.singletonList(registrationsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingManyToMany Registrations here] end

		}

		// % protected region % [Apply any additional logic for examinationItem with ref here] off begin
		// % protected region % [Apply any additional logic for examinationItem with ref here] end

		return newEntity;
	}

	@Override
	public Class<ExaminationItemEntity> getObjectType() {
		return ExaminationItemEntity.class;
	}
}