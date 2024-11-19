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

package kmsweb.services.utils;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import kmsweb.entities.AbstractEntity;
import kmsweb.entities.AbstractEntityAudit;
import kmsweb.repositories.AbstractRepository;
import kmsweb.services.AbstractService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.*;
import java.util.*;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

public class CsvUtils<E extends AbstractEntity, R extends AbstractRepository<E>, T extends AbstractEntityAudit<E>, S extends AbstractService<E, R, T>> {

	final S service;

	// Allows for querying the type of the class.  Can be used for implementing logic for specific import endpoints
	final Class<E> typeClass;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public CsvUtils(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			S service,
			Class<E> typeClass
		) {

		this.service = service;
		this.typeClass = typeClass;

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * Handles the logic for creating the CSV file and returning it to the clientside
	 *
	 * @param entitiesToExport The entities which have been selected to export
	 * @param fileName The chosen file name which will be sent to the clientside
	 * @param response the response entity which will contain the file
	 * @throws CsvDataTypeMismatchException
	 * @throws CsvRequiredFieldEmptyException
	 * @throws IOException
	 */
	public void exportCsvFile(List<E> entitiesToExport, String fileName, HttpServletResponse response) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		response.setContentType("text/csv");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
		CSVWriter writer = new CSVWriter(streamWriter);

		StatefulBeanToCsv<E> beanToCsv = new StatefulBeanToCsvBuilder<E>(writer).build();
		beanToCsv.write(entitiesToExport);
		streamWriter.flush();

		InputStream is = new ByteArrayInputStream(stream.toByteArray());

		IOUtils.copy(is, response.getOutputStream());

		response.flushBuffer();
		is.close();
	}

	/**
	 * Checks that the file uploaded to the CSV Import endpoint is a valid, non-empty CSV file
	 * @param file the file which was uploaded to the endpoint
	 * @return The response to be given to the clientside if the upload is invalid.  Return null on a valid upload
	 */
	public ResponseEntity<String> uploadValid(MultipartFile file) {
		if (file == null || file.isEmpty()) {
			// % protected region % [Modify the error response for a missing or empty file in import endpoint here] off begin
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CSV file to import is required and must not be empty");
			// % protected region % [Modify the error response for a missing or empty file in import endpoint here] end
		}

		// If CSV is invalid or not a csv, the endpoint would also return BAD_REQUEST later in the input checking stage (When checking headers or validating entities)
		// Simple check of the filename now can filter out most cases of an incorrect upload without having to read the file
		if (!Objects.requireNonNull(file.getOriginalFilename()).endsWith(".csv")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Imported file must be a CSV");
		}

		return null;
	}

	/**
	 * Checks whether the headers supplied in the CSV are all valid headers for the entity type being imported
	 * Doing this ensures that the CSV doesn't need every header from the entity, but also ensures that no invalid headers
	 * are added, as they will cause issues when mapping from CSV to entity
	 *
	 * @param allowedHeaders A list of the valid headers for the entity type being imported.
	 * @param columnHeaders The headers of the imported CSV
	 * @return A BAD_REQUEST response containing all of the invalid headers if there are any.  Return null if headers are valid
	 */
	public ResponseEntity<String> headersValid(List<String> allowedHeaders, String[] columnHeaders) {
		List<String> headerErrors = new ArrayList<>();

		// Sets don't allow duplicates, so we can attempt to add all headers to it to find duplicates efficiently
		Set<String> checkDuplicates = new HashSet<>();

		// % protected region % [Modify the parsing of headers here] off begin
		for (String header: columnHeaders) {
			if (!checkDuplicates.add(header)) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
						String.format("%s cannot appear as a header more than once in the CSV", header));
			}

			// Exporting a csv wraps each header in quotes.
			// In order to make it easy to reimport an exported csv after making some changes we need to account for quotes in the headers
			if (!allowedHeaders.contains(header.replace("\"", ""))) {
				headerErrors.add(header);
			}
		}
		// % protected region % [Modify the parsing of headers here] end

		if (headerErrors.size() > 0) {
			String errorMessage;
			if (headerErrors.size() == 1) {
				errorMessage = headerErrors.get(0) + " is not a valid CSV import header";
			} else {
				errorMessage = String.join(",", headerErrors) + " are not valid CSV import headers";
			}
			// % protected region % [Modify the error response for invalid headers in import endpoint here] off begin
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
			// % protected region % [Modify the error response for invalid headers in import endpoint here] end
		}

		return null;
	}

	/**
	 * Runs validation on the entities.  Validation is also run as part of entity creation, but doing it separately before
	 * creation allows for all validation errors to be caught prior to creation and updates.  This ensures that importing
	 * is transactional, so all entities will be imported, or all entities will be rejected
	 *
	 * @param entities the entities to validate
	 * @return a BAD_RESUEST response if there are any validation errors.  Return null if validation found no errors
	 */
	public ResponseEntity<String> validateEntities(List<E> entities) {
		List<String> validationErrors = new ArrayList<>();
		int currentLine = 2; //Header is line 1, so start at 2

		for (E entity: entities) {
			// % protected region % [Modify the validation of CSV entities here] off begin
			if (entity.getId() != null) {
				if (service.findById(entity.getId()).isEmpty()) {
					validationErrors.add("Line " + currentLine + ": " + entity.getId() + " is not associated with an entity of type " + this.typeClass.getSimpleName());
					continue;
				}
			}

			try {
				this.service.validateEntity(entity);
			} catch (ConstraintViolationException err) {
				for (ConstraintViolation<?> violation: err.getConstraintViolations()) {
					validationErrors.add("Line " + currentLine + ": '" + violation.getInvalidValue() + "' " + violation.getMessage());
				}
			}
			// % protected region % [Modify the validation of CSV entities here] end

			Set<String> errors = this.service.validateEntityRelations(entity);
			for (String err : errors) {
				// % protected region % [Modify the error messages for validation errors here] off begin
				validationErrors.add("Line " + currentLine + ": " + err);
				// % protected region % [Modify the error messages for validation errors here] end
			}
			currentLine++;
		}

		if (validationErrors.size() > 0) {
			// % protected region % [Modify the error response for validation errors here] off begin
			String errorMessage = String.join("\n", validationErrors);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
			// % protected region % [Modify the error response for validation errors here] end
		}

		return null;
	}

	/**
	 * Adds the list of entities to the database.  When importing, this method should ONLY be run after validateEntities.
	 * Failing to run that method first will remove the transactional nature of imports.
	 *
	 * All validation issues will have been found prior to running this method, so there should be no issues with importing at this stage
	 *
	 * @param entities the entities to create or update
	 * @return a list of the ids of the entities which were imported.  This is then returned to the clientside
	 */
	public List<String> addAllEntities(List<E> entities) throws DataIntegrityViolationException {
		List<E> entitiesToAdd = new ArrayList<>();
		List<String> entityIds = new ArrayList<>();

		for (E entity: entities) {
			// % protected region % [Modify the creation and update of CSV entities here] off begin
			if (entity.getId() != null) {
				// If Id is not present in database, then an error will be thrown earlier and it will never get here
				// Still have check just in case of custom code and to remove warning
				Optional<E> entityToUpdate= this.service.findById(entity.getId());

				if (entityToUpdate.isPresent()) {
					// These fields are already present in the entity and need to be persisted,
					// as they are not being passed by the CSV
					entity.setCreatedBy(entityToUpdate.get().getCreatedBy());
					entity.setCreated(entityToUpdate.get().getCreated());
					entity.setModifiedBy(entityToUpdate.get().getModifiedBy());
					entity.setModified(entityToUpdate.get().getModified());

					entitiesToAdd.add(entity);
				}
			} else {
				entitiesToAdd.add(entity);
			}
			// % protected region % [Modify the creation and update of CSV entities here] end
		}

		// Using Save instead of create and update individually ensures that all entites can be created at once,
		// which allows for gracefully handling unique constraint violations
		List<E> addedEntites;
		try {
			addedEntites = (ArrayList<E>) this.service.saveAll(entitiesToAdd);
		} catch (DataIntegrityViolationException e) {
			// We catch the exception so that we can update the error message to be something more helpful when
			// debugging CSV import issues

			/*
				The root error message will produce an error in the following format:

				ERROR: duplicate key value violates unique constraint "*Constraint attribute*"
				Detail: Key (*Constraint attribute*)=(*Bad Input*) already exists.

				Using this substringsBetween method from string utils with the delimiters below, we can easily find
				the attribute whose unique constraint has been violated, and the value which has caused the issue, allowing
				us to return a descriptive error message.
			 */
			String errorMessage = e.getMessage();
			if (e.getRootCause() != null) {
				String[] result = StringUtils.substringsBetween(e.getRootCause().getLocalizedMessage(), "(", ")");
				if (result.length == 2) {
					errorMessage = StringUtils.capitalize(result[0]) + " must be unique and the value '" + result[1] + "' already exists";
				}
			}
			assert errorMessage != null;
			throw new DataIntegrityViolationException(errorMessage);
		}

		for (E entity: addedEntites) {
			entityIds.add(entity.getId().toString());
		}

		return entityIds;
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}