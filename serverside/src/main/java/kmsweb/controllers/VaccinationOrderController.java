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
package kmsweb.controllers;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import kmsweb.configs.security.authorities.CustomGrantedAuthority;
import kmsweb.entities.VaccinationOrderEntity;
import kmsweb.dtos.VaccinationOrderEntityDto;
import kmsweb.entities.VaccinationOrderEntityAudit;
import kmsweb.repositories.VaccinationOrderRepository;
import kmsweb.services.VaccinationOrderService;
import kmsweb.configs.security.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import kmsweb.services.utils.ControllerUtils;
import kmsweb.services.utils.CsvUtils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Controller used to handle all REST operations regarding Vaccination Order
 */
// % protected region % [Update the API route or description for the Vaccination OrderController here] off begin
// The text associated with this tag can be found and edited in SwaggerConfig
@Tags(value = @Tag(name = "VaccinationOrderController"))
@RestController
@Slf4j
@RequestMapping("/api/vaccinationorder")
// % protected region % [Update the API route or description for the Vaccination OrderController here] end
public class VaccinationOrderController {

	private final VaccinationOrderService vaccinationOrderService;
	private final CsvUtils<VaccinationOrderEntity, VaccinationOrderRepository, VaccinationOrderEntityAudit,  VaccinationOrderService> csvUtils;
	private final AuthenticationService authService;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public VaccinationOrderController(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			AuthenticationService authService,
			VaccinationOrderService vaccinationOrderService
	) {
		this.authService = authService;
		this.vaccinationOrderService = vaccinationOrderService;
		this.csvUtils = new CsvUtils<>(vaccinationOrderService, VaccinationOrderEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * Return all the Vaccination Orders.
	 *
	 * @return all the Vaccination Orders
	 */
	// % protected region % [Update the route mapping or description for the 'getAllWithPage' endpoint here] off begin
	@Operation(
			description = "Returns a single page of VaccinationOrders",
		security = {
					@SecurityRequirement(name = "Authentication-Token"),
					@SecurityRequirement(name = "CSRF-Token"),
					@SecurityRequirement(name = "CSRF-Cookie")
			}
	)
	@PreAuthorize("hasPermission('VaccinationOrderEntity', 'read')")
	@GetMapping(produces = "application/json")
	// % protected region % [Update the route mapping or description for the 'getAllWithPage' endpoint here] end
	public ResponseEntity<List<VaccinationOrderEntity>> getAllWithPage(
			@Parameter(description = "The page to return.")
			@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@Parameter(description = "The size of the page to return.")
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
	) {
		List<VaccinationOrderEntity> vaccinationOrders = vaccinationOrderService.findAllWithPage((page > 0) ? page - 1 : page, pageSize);

		// % protected region % [Add any custom logic before returning the entities here] off begin
		// % protected region % [Add any custom logic before returning the entities here] end

		return new ResponseEntity<>(vaccinationOrders, HttpStatus.OK);
	}

	/**
	 * Return the Vaccination Order that has the same id as the given id.
	 *
	 * @param id      The id of the VaccinationOrderEntity to be returned
	 * @return the Vaccination Order that has the same id as the given id
	 */
	// % protected region % [Customise the security configuration here for the getWithId endpoint] off begin
	// % protected region % [Customise the security configuration here for the getWithId endpoint] end
	// % protected region % [Update the route mapping or description for the 'getById' endpoint here] off begin
	@Operation(
			description = "Return a single VaccinationOrder as defined by the id provided.",
			security = {
					@SecurityRequirement(name = "Authentication-Token"),
					@SecurityRequirement(name = "CSRF-Token"),
					@SecurityRequirement(name = "CSRF-Cookie")
			}
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "VaccinationOrder entity not found"),
	})
	@PreAuthorize("hasPermission('VaccinationOrderEntity', 'read')")
	@GetMapping(value = "/{id}", produces = "application/json")
	// % protected region % [Update the route mapping or description for the 'getById' endpoint here] end
	public ResponseEntity<VaccinationOrderEntity> getById(
			@Parameter(description = "The UUID of the VaccinationOrder to return.")
			@PathVariable("id") UUID id
	) {
		Optional<VaccinationOrderEntity> vaccinationOrderEntity = vaccinationOrderService.findById(id);

		// % protected region % [Add any final logic before returning the entity here] off begin
		// % protected region % [Add any final logic before returning the entity here] end

		return vaccinationOrderEntity
				.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * Create/Update the given Vaccination Order. If the entity has an id it will be updated, if not it will be created.
	 * The appropriate status codes will be set.
	 *
	 * @param vaccinationOrderEntityDto The Dto of the entity to save or update
	 */
	// % protected region % [Update the route mapping or description for the 'saveVaccinationOrder' endpoint here] off begin
	@Operation(
			description = "Create a VaccinationOrder if id not exists. Return 409 otherwise",
			security = {
					@SecurityRequirement(name = "Authentication-Token"),
					@SecurityRequirement(name = "CSRF-Token"),
					@SecurityRequirement(name = "CSRF-Cookie")
			}
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully created the new VaccinationOrder."),
			@ApiResponse(responseCode = "409", description = "Failed to create the new VaccinationOrder, duplicate record found")
	})
	@PreAuthorize("hasPermission('VaccinationOrderEntity', 'create')")
	@PostMapping
	// % protected region % [Update the route mapping or description for the 'saveVaccinationOrder' endpoint here] end
	public ResponseEntity<?> saveVaccinationOrder(
			@Parameter(description = "The VaccinationOrderEntity to create or update.")
			@RequestBody VaccinationOrderEntityDto vaccinationOrderEntityDto
	) {
		// % protected region % [Add any logic before save here] off begin
		// % protected region % [Add any logic before save here] end

		try {
			VaccinationOrderEntity vaccinationOrderEntity = vaccinationOrderService.create(new VaccinationOrderEntity(vaccinationOrderEntityDto));
			return new ResponseEntity<>(vaccinationOrderEntity, HttpStatus.OK);
		} catch (ConstraintViolationException err) {
			return ControllerUtils.failedValidationApiResponse(err);
		}
	}

	/**
	 * Update the given Vaccination Order. If the entity has an id which is associated with an existing entity it will be updated, if not then the request will fail
	 * The appropriate status codes will be set.
	 *
	 * @param vaccinationOrderEntityDto The Dto of the entity to save or update
	 */
	// % protected region % [Update the route mapping or description for the 'updateVaccinationOrder' endpoint here] off begin
	@Operation(
			description = "Update a VaccinationOrder entity if id exists and is associated with an existing entity.  Return BAD_REQUEST otherwise",
			security = {
					@SecurityRequirement(name = "Authentication-Token"),
					@SecurityRequirement(name = "CSRF-Token"),
					@SecurityRequirement(name = "CSRF-Cookie")
			}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Successfully updated the VaccinationOrder."),
		@ApiResponse(responseCode = "400", description = "Failed to update the VaccinationOrder, entity id either does not exist" +
				"or is not associated with an existing entity")
	})
	@PreAuthorize("hasPermission('VaccinationOrderEntity', 'update')")
	@PutMapping
	// % protected region % [Update the route mapping or description for the 'updateVaccinationOrder' endpoint here] end
	public ResponseEntity<?> updateVaccinationOrder(
			@Parameter(description = "The VaccinationOrderEntity to create or update.")
			@RequestBody VaccinationOrderEntityDto vaccinationOrderEntityDto
	) {
		// % protected region % [Add any logic before update here] off begin
		// % protected region % [Add any logic before update here] end
		Optional<VaccinationOrderEntity> checkVaccinationOrderExists = vaccinationOrderService.findById(vaccinationOrderEntityDto.getId());
		VaccinationOrderEntity vaccinationOrderEntity = new VaccinationOrderEntity(vaccinationOrderEntityDto);

		if (checkVaccinationOrderExists.isPresent()) {
			try {
				vaccinationOrderEntity = vaccinationOrderService.update(vaccinationOrderEntity);
				return new ResponseEntity<>(vaccinationOrderEntity, HttpStatus.OK);
			} catch (ConstraintViolationException err) {
				return ControllerUtils.failedValidationApiResponse(err);
			}
		}

		return new ResponseEntity<>(vaccinationOrderEntity, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Delete the Vaccination Order that has the same id as the given id.
	 *
	 * @param id The id of the VaccinationOrderEntity to be deleted
	 * @return void HTTP status code will be set on success
	 */
	// % protected region % [Customise the security config here for the delete endpoint] off begin
	// % protected region % [Customise the security config here for the delete endpoint] end
	// % protected region % [Update the route mapping or description for the 'deleteById' endpoint here] off begin
	@Operation(
			description = "Delete a single VaccinationOrder as defined by the id provided.",
			security = {
					@SecurityRequirement(name = "Authentication-Token"),
					@SecurityRequirement(name = "CSRF-Token"),
					@SecurityRequirement(name = "CSRF-Cookie")
			}
	)
	@PreAuthorize("hasPermission('VaccinationOrderEntity', 'delete')")
	@DeleteMapping(value = "/{id}")
	// % protected region % [Update the route mapping or description for the 'deleteById' endpoint here] end
	public ResponseEntity<Void> deleteById(
			@Parameter(description = "The UUID of the VaccinationOrder to delete.")
			@PathVariable(value="id") UUID id
	) {
		// % protected region % [Add any additional logic before deleting the given entity] off begin
		// % protected region % [Add any additional logic before deleting the given entity] end

		vaccinationOrderService.deleteById(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Download a CSV file containing all of the entities from the ID List.  Endpoint needs to be opened in a new tab
	 * on the clientside because this will allow the file download to start.

	 * @param ids The ids of the entities to export
	 * @param response The response object
	 */
	// % protected region % [Update the route mapping or description for the 'exportVaccinationOrder' endpoint here] off begin
	@Operation(
			description = "Download a csv file including all Vaccination Order entities included in the ids provided",
			security = {
					@SecurityRequirement(name = "Authentication-Token"),
					@SecurityRequirement(name = "CSRF-Token"),
					@SecurityRequirement(name = "CSRF-Cookie")
			}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Successfully exported the selected entities"),
		@ApiResponse(responseCode = "400", description = "Failed to export the entities due to no ids being provided"),
		@ApiResponse(responseCode = "500", description = "Error occurred while creating the CSV file to export or while downloading the file")
	})
	@PreAuthorize("hasPermission('VaccinationOrderEntity', 'read')")
	@GetMapping(value = "/export", produces = "text/csv")
	// % protected region % [Update the route mapping or description for the 'exportVaccinationOrder' endpoint here] end
	public void exportVaccinationOrder(
			@Parameter(description = "The ids of the VaccinationOrderEntities to export")
			@RequestParam @NotNull List<UUID> ids, HttpServletResponse response
	) {
		if (ids == null || ids.size() == 0) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			List<VaccinationOrderEntity> entitiesToExport = vaccinationOrderService.findAllByIds(ids);
			// % protected region % [Modify the default file name for the Export endpoint here] off begin
			String datetime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			String fileName = "VaccinationOrder_Export_" + datetime + ".csv";
			// % protected region % [Modify the default file name for the Export endpoint here] end

		for (VaccinationOrderEntity entity: entitiesToExport) {
			entity.addRelationEntitiesToIdSet();
		}

			// % protected region % [Add any additional logic before executing the Export endpoint here] off begin
			// % protected region % [Add any additional logic before executing the Export endpoint here] end

			try {
				csvUtils.exportCsvFile(entitiesToExport, fileName, response);
			} catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
				// % protected region % [Modify the error response for the Export endpoint here] off begin
				log.error(Arrays.toString(e.getStackTrace()));
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				// % protected region % [Modify the error response for the Export endpoint here] end
			}
		}
	}

	/**
	 * Download a CSV file containing all of the entities with ids NOT contained in the id list.  Endpoint needs to be opened in a new tab
	 * on the clientside bcause this will allow the file download to start.

	 * @param ids The ids of the entities to exclude from the export
	 * @param response The response object
	 */
	// % protected region % [Update the route mapping or description for the 'exportVaccinationOrderExcludingIds' endpoint here] off begin
	@Operation(
			description = "Download a csv file with all of the entities not included in the id's list",
			security = {
					@SecurityRequirement(name = "Authentication-Token"),
					@SecurityRequirement(name = "CSRF-Token"),
					@SecurityRequirement(name = "CSRF-Cookie")
			}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Successfully exported the excluded entities"),
		@ApiResponse(responseCode = "500", description = "Error occurred while creating the CSV file to export or while downloading the file")
	})
	@PreAuthorize("hasPermission('VaccinationOrderEntity', 'read')")
	@GetMapping(value = "/export-excluding", produces = "text/csv")
	// % protected region % [Update the route mapping or description for the 'exportVaccinationOrderExcludingIds' endpoint here] end
	public void exportVaccinationOrderExcludingIds(
			@Parameter(description = "The ids of the VaccinationOrderEntities to exclude from the export")
			@RequestParam @NotNull List<UUID> ids, HttpServletResponse response
	) {
		List<VaccinationOrderEntity> entitiesToExport;
		// % protected region % [Modify the default file name for the Export Excluding endpoint here] off begin
		String datetime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String fileName = "VaccinationOrder_Export_" + datetime + ".csv";
		// % protected region % [Modify the default file name for the Export Excluding endpoint here] end

		if (ids == null || ids.size() == 0) {
			entitiesToExport = vaccinationOrderService.findAllExcludingIds(new ArrayList<>());
		} else {
			entitiesToExport = vaccinationOrderService.findAllExcludingIds(ids);
		}

		for (VaccinationOrderEntity entity: entitiesToExport) {
			entity.addRelationEntitiesToIdSet();
		}

		// % protected region % [Add any additional logic before executing the Export Excluding endpoint here] off begin
		// % protected region % [Add any additional logic before executing the Export Excluding endpoint here] end

		try {
			if (entitiesToExport.isEmpty()) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "You must export at least one entity");
			} else {
				csvUtils.exportCsvFile(entitiesToExport, fileName, response);
			}
		} catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
			// % protected region % [Modify the error response for the Export Excluding endpoint here] off begin
			log.error(Arrays.toString(e.getStackTrace()));
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			// % protected region % [Modify the error response for the Export Excluding endpoint here] end
		}
	}

	/**
	 * Download a CSV file containing all of the headers of the VaccinationOrder entity.
	 * This file can then be used to in the import endpoint
	 *
	 * @param response The response object
	 */
	// % protected region % [Update the route mapping or description for the 'csvImportExample' endpoint here] off begin
	@Operation(
			description = "Download an empty csv file with the example headers for a CSV Import",
			security = {
					@SecurityRequirement(name = "Authentication-Token"),
					@SecurityRequirement(name = "CSRF-Token"),
					@SecurityRequirement(name = "CSRF-Cookie")
			}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Successfully downloaded the example CSV"),
		@ApiResponse(responseCode = "500", description = "Error occurred while creating the CSV file to export or while downloading the file")
	})
	@PreAuthorize("hasPermission('VaccinationOrderEntity', 'create')")
	@GetMapping(value = "/example-import", produces = "text/csv")
	// % protected region % [Update the route mapping or description for the 'csvImportExample' endpoint here] end
	public void csvImportExample(
		HttpServletResponse response
	) {
		// % protected region % [Modify the default file name for the Example Import endpoint here] off begin
		String datetime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String fileName = "VaccinationOrder_Import_Example_" + datetime + ".csv";
		// % protected region % [Modify the default file name for the Example Import endpoint here] end
		try {
			InputStream is = new ByteArrayInputStream(VaccinationOrderEntity.getExampleCsvHeader().getBytes());

			IOUtils.copy(is, response.getOutputStream());
			response.setContentType("text/csv");
			response.setHeader("Content-disposition", "attachment; filename=" + fileName);

			response.flushBuffer();
			is.close();
		} catch (IOException e) {
			// % protected region % [Modify the error response for the Example Import endpoint here] off begin
			log.error(Arrays.toString(e.getStackTrace()));
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			// % protected region % [Modify the error response for the Example Import endpoint here] end
		}
	}

	/**
	 * Upload a CSV file containing attributes for Vaccination Order entities, and import them into the database.  This method
	 * contains a lot of error checking to ensure that any entity uploaded will not cause an exception when it is saved
	 * to the database
	 *
	 * @param file The CSV file which contains the entities
	 * @return A Response entity with a 200 Status code if successful, and 400 if there are issues with the CSV
	 * @throws IOException On failure to access the file
	 */
	// % protected region % [Update the route mapping or description for the 'csvUpload' endpoint here] off begin
	@Operation(
			description = "Upload a csv file containing entities to add to the database",
			security = {
					@SecurityRequirement(name = "Authentication-Token"),
					@SecurityRequirement(name = "CSRF-Token"),
					@SecurityRequirement(name = "CSRF-Cookie")
			}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Successfully imported the entities provided in the CSV."),
		@ApiResponse(responseCode = "400", description = "Failed to import the entities due to parsing or validation errors in thr CSV file"),
		@ApiResponse(responseCode = "403", description = "Failed to import the entities due to insufficient permissions")
	})
	@PreAuthorize("hasPermission('VaccinationOrderEntity', 'create')  || hasPermission('VaccinationOrderEntity', 'update')")
	@PostMapping(value = "/import-csv")
	// % protected region % [Update the route mapping or description for the 'csvUpload' endpoint here] end
	public ResponseEntity<String> csvUpload(HttpServletRequest request,
			@Parameter(description = "The CSV file with VaccinationOrderEntity entities to import")
			@RequestParam("file") MultipartFile file) throws IOException {
		Authentication authentication = this.authService.getAuthentication(request);

		// Situation where the csv is too large throws an error before the endpoint code is executed
		// We catch that error and add the error to the request params, so if the file is too large we can set the response and return an appropriate error message here
		Map<String, String[]> requestParams = ((DefaultMultipartHttpServletRequest) request).getParameterMap();
		if (requestParams.containsKey("fileSizeExceededError")) {
			return ResponseEntity.badRequest().body(requestParams.get("fileSizeExceededError")[0]);
		}

		Collection<CustomGrantedAuthority> authorities = new ArrayList<>();
		//Cast each GrantedAuthority individually as casting the collection as a whole introduces an UncheckedCast warning
		authentication.getAuthorities().forEach(authority -> {
			authorities.add((CustomGrantedAuthority) authority);
		});

		// If a authority for the target entity does not exist, we assume that the user is not authenticated to perform the action
		// Therefore we create a new authority with disallowed permissions and use that for the authorization checks
		CustomGrantedAuthority entityAuthority = authorities.stream().filter(x -> x.getTargetEntity().matches("VaccinationOrderEntity"))
				.findFirst().orElse(new CustomGrantedAuthority("", "", false, false, false, false));
		boolean allowCreate = entityAuthority.isAllowCreate();
		boolean allowUpdate = entityAuthority.isAllowUpdate();

		// All error checking returns a response, so we can create a response here
		// As long as this response remains null the import is still valid
		ResponseEntity<String> response = csvUtils.uploadValid(file);

		if (response != null) {
			return response;
		}

		//Create two readers.  First is used for the CSV reader, second is used to verify that the headers are valid
		BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
		BufferedReader readerForHeaderCheck = new BufferedReader(new InputStreamReader(file.getInputStream()));

		String[] columnHeaders = readerForHeaderCheck.readLine().split(",");
		List<String> allowedHeaders = Arrays.asList(VaccinationOrderEntity.getExampleCsvHeader().split(","));
		response = csvUtils.headersValid(allowedHeaders, columnHeaders);
		readerForHeaderCheck.close();

		if (response != null) {
			reader.close();
			return response;
		}

		// The CSV to Bean Builder will parse the csv file one line at a time, and create an entity of the given type
		// This entity can then be added to the database
		CsvToBean<VaccinationOrderEntity> csvToBean = new CsvToBeanBuilder<VaccinationOrderEntity>(reader)
				.withType(VaccinationOrderEntity.class)
				.withIgnoreLeadingWhiteSpace(true)
				.withThrowExceptions(true)
				.build();

		List<VaccinationOrderEntity> entities = new ArrayList<>();
		List<String> importErrors = new ArrayList<>();
		int currentLine = 2; //Header is line 1, so start at 2

		// If the first entry in the CSV has a parsing error, it will throw an exception
		// Therefore need to wrap in try catch
		try {
			Iterator<VaccinationOrderEntity> iterator = csvToBean.iterator();

			while (iterator.hasNext()) {
				//Putting additional try catch in loop allows for multiple entries to be iterated through
				// even if a parsing error is encountered
				// All parsing errors are stored and returned to the client
				try {
					// % protected region % [Modify the parsing of CSV files here] off begin
					var next = iterator.next();
					// This is the earliest we know whether an entity is being created or updated.  Therefore we should
					if (next.getId() != null && !allowUpdate) {
						return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Line " + currentLine
								+ ": You attempted to update a Vaccination Order entity and you do not have permission");
					}

					if (next.getId() == null && !allowCreate) {
						return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Line " + currentLine
								+ ": You attempted to create a Vaccination Order entity and you do not have permission");
					}

					entities.add(next);
					// % protected region % [Modify the parsing of CSV files here] end
				} catch (RuntimeException e) {
					// % protected region % [Modify the import parsing error messages within the loop here] off begin
					importErrors.add("Line " + currentLine + ": " + e.getCause().getMessage());
					// % protected region % [Modify the import parsing error messages within the loop here] end
				}
				currentLine++;
			}
		} catch (RuntimeException e) {
			// % protected region % [Modify the import parsing error messages here] off begin
			importErrors.add("Line " + currentLine + ": " + e.getCause().getMessage());
			// % protected region % [Modify the import parsing error messages here] end
		}

		/*
		 * Need to check this before we check that that there are no entities
		 * If an entity throws an error, it will not be added to the list
		 * If all have errors, then checking that entities exist first would
		 * cause it to return an error saying that there were no entities present, which is not the case
		 */
		if (importErrors.size() > 0) {
			reader.close();
			// % protected region % [Modify the error response for parsing errors here] off begin
			String errorMessage = String.join("\n", importErrors);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
			// % protected region % [Modify the error response for parsing errors here] end
		}

		// Don't want to progress any further if there is no entities
		// Can't do this any earlier as we don't know how many entities there are until we have finished parsing the file
		if (entities.isEmpty()) {
			// % protected region % [Modify error message for a CSV with no entities here] off begin
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CSV file must contain at least one entity");
			// % protected region % [Modify error message for a CSV with no entities here] end
		}

		/*
		 * Want to validate all entities before attempting to create any
		 * Entities are validated as part of creation, but doing this keeps it transactional
		 * and ensures that either all entities are added or none are
		 */
		response = csvUtils.validateEntities(entities);

		if (response != null) {
			reader.close();
			return response;
		}

		// % protected region % [Add any additional logic before completing the CSV Import here] off begin
		// % protected region % [Add any additional logic before completing the CSV Import here] end

		// Now that most known errors have been checked and cleared, we can create the entities
		// It is not feasible to check for unique constraint violations prior to upload, so we
		// catch the exception thrown when the constraint is violated and handle it here
		List<String> entityIds;
		try {
			entityIds = csvUtils.addAllEntities(entities);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}


		// % protected region % [Add any additional logic after completing the CSV Import here] off begin
		// % protected region % [Add any additional logic after completing the CSV Import here] end

		reader.close();
		// % protected region % [Modify the response for a successful import here] off begin
		String idReturn = String.join(",", entityIds);
		return ResponseEntity.status(HttpStatus.OK).body(idReturn);
		// % protected region % [Modify the response for a successful import here] end
	}

	// % protected region % [Add any additional endpoints here] off begin
	// % protected region % [Add any additional endpoints here] end
}
