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
import kmsweb.entities.LibraryEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class LibraryFactory implements FactoryBean<LibraryEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public LibraryEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public LibraryEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public LibraryEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for libraryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for libraryWithNoRef before the main body here] end

		LibraryEntity newEntity = new LibraryEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Library Document here] off begin
		// % protected region % [Add customisation for Library Document here] end
		// % protected region % [Add customisation for Library Item Code here] off begin
		String randomStringForLibraryItemCode = mockNeat
				.strings()
				.get();
		newEntity.setLibraryItemCode(randomStringForLibraryItemCode);
		// % protected region % [Add customisation for Library Item Code here] end
		// % protected region % [Add customisation for Library Item Description here] off begin
		String randomStringForLibraryItemDescription = mockNeat
				.strings()
				.get();
		newEntity.setLibraryItemDescription(randomStringForLibraryItemDescription);
		// % protected region % [Add customisation for Library Item Description here] end
		// % protected region % [Add customisation for Classification here] off begin
		String randomStringForClassification = mockNeat
				.strings()
				.get();
		newEntity.setClassification(randomStringForClassification);
		// % protected region % [Add customisation for Classification here] end
		// % protected region % [Add customisation for Author here] off begin
		String randomStringForAuthor = mockNeat
				.strings()
				.get();
		newEntity.setAuthor(randomStringForAuthor);
		// % protected region % [Add customisation for Author here] end
		// % protected region % [Add customisation for Publisher here] off begin
		String randomStringForPublisher = mockNeat
				.strings()
				.get();
		newEntity.setPublisher(randomStringForPublisher);
		// % protected region % [Add customisation for Publisher here] end

		// % protected region % [Apply any additional logic for libraryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for libraryWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<LibraryEntity> getObjectType() {
		return LibraryEntity.class;
	}
}