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
import kmsweb.entities.PurchaseOrderStockDetailEntity;
import kmsweb.dtos.PurchaseOrderStockDetailEntityDto;
import kmsweb.entities.PurchaseOrderStockDetailEntityAudit;
import kmsweb.repositories.PurchaseOrderStockDetailRepository;
import kmsweb.services.PurchaseOrderStockDetailService;
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
 * Controller used to handle all REST operations regarding Purchase Order Stock Detail
 */
// % protected region % [Update the API route or description for the Purchase Order Stock DetailController here] off begin
// The text associated with this tag can be found and edited in SwaggerConfig
@Tags(value = @Tag(name = "PurchaseOrderStockDetailController"))
@RestController
@Slf4j
@RequestMapping("/api/purchaseorderstockdetail")
// % protected region % [Update the API route or description for the Purchase Order Stock DetailController here] end
public class PurchaseOrderStockDetailController {

	private final PurchaseOrderStockDetailService purchaseOrderStockDetailService;
	private final CsvUtils<PurchaseOrderStockDetailEntity, PurchaseOrderStockDetailRepository, PurchaseOrderStockDetailEntityAudit,  PurchaseOrderStockDetailService> csvUtils;
	private final AuthenticationService authService;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PurchaseOrderStockDetailController(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			AuthenticationService authService,
			PurchaseOrderStockDetailService purchaseOrderStockDetailService
	) {
		this.authService = authService;
		this.purchaseOrderStockDetailService = purchaseOrderStockDetailService;
		this.csvUtils = new CsvUtils<>(purchaseOrderStockDetailService, PurchaseOrderStockDetailEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * Return all the Purchase Order Stock Details.
	 *
	 * @return all the Purchase Order Stock Details
	 */
	// % protected region % [Update the route mapping or description for the 'getAllWithPage' endpoint here] off begin
	@Operation(
			description = "Returns a single page of PurchaseOrderStockDetails",
		security = {
					@SecurityRequirement(name = "Authentication-Token"),
					@SecurityRequirement(name = "CSRF-Token"),
					@SecurityRequirement(name = "CSRF-Cookie")
			}
	)
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@GetMapping(produces = "application/json")
	// % protected region % [Update the route mapping or description for the 'getAllWithPage' endpoint here] end
	public ResponseEntity<List<PurchaseOrderStockDetailEntity>> getAllWithPage(
			@Parameter(description = "The page to return.")
			@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@Parameter(description = "The size of the page to return.")
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
	) {
		List<PurchaseOrderStockDetailEntity> purchaseOrderStockDetails = purchaseOrderStockDetailService.findAllWithPage((page > 0) ? page - 1 : page, pageSize);

		// % protected region % [Add any custom logic before returning the entities here] off begin
		// % protected region % [Add any custom logic before returning the entities here] end

		return new ResponseEntity<>(purchaseOrderStockDetails, HttpStatus.OK);
	}

	/**
	 * Return the Purchase Order Stock Detail that has the same id as the given id.
	 *
	 * @param id      The id of the PurchaseOrderStockDetailEntity to be returned
	 * @return the Purchase Order Stock Detail that has the same id as the given id
	 */
	// % protected region % [Customise the security configuration here for the getWithId endpoint] off begin
	// % protected region % [Customise the security configuration here for the getWithId endpoint] end
	// % protected region % [Update the route mapping or description for the 'getById' endpoint here] off begin
	@Operation(
			description = "Return a single PurchaseOrderStockDetail as defined by the id provided.",
			security = {
					@SecurityRequirement(name = "Authentication-Token"),
					@SecurityRequirement(name = "CSRF-Token"),
					@SecurityRequirement(name = "CSRF-Cookie")
			}
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "PurchaseOrderStockDetail entity not found"),
	})
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@GetMapping(value = "/{id}", produces = "application/json")
	// % protected region % [Update the route mapping or description for the 'getById' endpoint here] end
	public ResponseEntity<PurchaseOrderStockDetailEntity> getById(
			@Parameter(description = "The UUID of the PurchaseOrderStockDetail to return.")
			@PathVariable("id") UUID id
	) {
		Optional<PurchaseOrderStockDetailEntity> purchaseOrderStockDetailEntity = purchaseOrderStockDetailService.findById(id);

		// % protected region % [Add any final logic before returning the entity here] off begin
		// % protected region % [Add any final logic before returning the entity here] end

		return purchaseOrderStockDetailEntity
				.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * Create/Update the given Purchase Order Stock Detail. If the entity has an id it will be updated, if not it will be created.
	 * The appropriate status codes will be set.
	 *
	 * @param purchaseOrderStockDetailEntityDto The Dto of the entity to save or update
	 */
	// % protected region % [Update the route mapping or description for the 'savePurchaseOrderStockDetail' endpoint here] off begin
	@Operation(
			description = "Create a PurchaseOrderStockDetail if id not exists. Return 409 otherwise",
			security = {
					@SecurityRequirement(name = "Authentication-Token"),
					@SecurityRequirement(name = "CSRF-Token"),
					@SecurityRequirement(name = "CSRF-Cookie")
			}
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully created the new PurchaseOrderStockDetail."),
			@ApiResponse(responseCode = "409", description = "Failed to create the new PurchaseOrderStockDetail, duplicate record found")
	})
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'create')")
	@PostMapping
	// % protected region % [Update the route mapping or description for the 'savePurchaseOrderStockDetail' endpoint here] end
	public ResponseEntity<?> savePurchaseOrderStockDetail(
			@Parameter(description = "The PurchaseOrderStockDetailEntity to create or update.")
			@RequestBody PurchaseOrderStockDetailEntityDto purchaseOrderStockDetailEntityDto
	) {
		// % protected region % [Add any logic before save here] off begin
		// % protected region % [Add any logic before save here] end

		try {
			PurchaseOrderStockDetailEntity purchaseOrderStockDetailEntity = purchaseOrderStockDetailService.create(new PurchaseOrderStockDetailEntity(purchaseOrderStockDetailEntityDto));
			return new ResponseEntity<>(purchaseOrderStockDetailEntity, HttpStatus.OK);
		} catch (ConstraintViolationException err) {
			return ControllerUtils.failedValidationApiResponse(err);
		}
	}

	/**
	 * Update the given Purchase Order Stock Detail. If the entity has an id which is associated with an existing entity it will be updated, if not then the request will fail
	 * The appropriate status codes will be set.
	 *
	 * @param purchaseOrderStockDetailEntityDto The Dto of the entity to save or update
	 */
	// % protected region % [Update the route mapping or description for the 'updatePurchaseOrderStockDetail' endpoint here] off begin
	@Operation(
			description = "Update a PurchaseOrderStockDetail entity if id exists and is associated with an existing entity.  Return BAD_REQUEST otherwise",
			security = {
					@SecurityRequirement(name = "Authentication-Token"),
					@SecurityRequirement(name = "CSRF-Token"),
					@SecurityRequirement(name = "CSRF-Cookie")
			}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Successfully updated the PurchaseOrderStockDetail."),
		@ApiResponse(responseCode = "400", description = "Failed to update the PurchaseOrderStockDetail, entity id either does not exist" +
				"or is not associated with an existing entity")
	})
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'update')")
	@PutMapping
	// % protected region % [Update the route mapping or description for the 'updatePurchaseOrderStockDetail' endpoint here] end
	public ResponseEntity<?> updatePurchaseOrderStockDetail(
			@Parameter(description = "The PurchaseOrderStockDetailEntity to create or update.")
			@RequestBody PurchaseOrderStockDetailEntityDto purchaseOrderStockDetailEntityDto
	) {
		// % protected region % [Add any logic before update here] off begin
		// % protected region % [Add any logic before update here] end
		Optional<PurchaseOrderStockDetailEntity> checkPurchaseOrderStockDetailExists = purchaseOrderStockDetailService.findById(purchaseOrderStockDetailEntityDto.getId());
		PurchaseOrderStockDetailEntity purchaseOrderStockDetailEntity = new PurchaseOrderStockDetailEntity(purchaseOrderStockDetailEntityDto);

		if (checkPurchaseOrderStockDetailExists.isPresent()) {
			try {
				purchaseOrderStockDetailEntity = purchaseOrderStockDetailService.update(purchaseOrderStockDetailEntity);
				return new ResponseEntity<>(purchaseOrderStockDetailEntity, HttpStatus.OK);
			} catch (ConstraintViolationException err) {
				return ControllerUtils.failedValidationApiResponse(err);
			}
		}

		return new ResponseEntity<>(purchaseOrderStockDetailEntity, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Delete the Purchase Order Stock Detail that has the same id as the given id.
	 *
	 * @param id The id of the PurchaseOrderStockDetailEntity to be deleted
	 * @return void HTTP status code will be set on success
	 */
	// % protected region % [Customise the security config here for the delete endpoint] off begin
	// % protected region % [Customise the security config here for the delete endpoint] end
	// % protected region % [Update the route mapping or description for the 'deleteById' endpoint here] off begin
	@Operation(
			description = "Delete a single PurchaseOrderStockDetail as defined by the id provided.",
			security = {
					@SecurityRequirement(name = "Authentication-Token"),
					@SecurityRequirement(name = "CSRF-Token"),
					@SecurityRequirement(name = "CSRF-Cookie")
			}
	)
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'delete')")
	@DeleteMapping(value = "/{id}")
	// % protected region % [Update the route mapping or description for the 'deleteById' endpoint here] end
	public ResponseEntity<Void> deleteById(
			@Parameter(description = "The UUID of the PurchaseOrderStockDetail to delete.")
			@PathVariable(value="id") UUID id
	) {
		// % protected region % [Add any additional logic before deleting the given entity] off begin
		// % protected region % [Add any additional logic before deleting the given entity] end

		purchaseOrderStockDetailService.deleteById(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Download a CSV file containing all of the entities from the ID List.  Endpoint needs to be opened in a new tab
	 * on the clientside because this will allow the file download to start.

	 * @param ids The ids of the entities to export
	 * @param response The response object
	 */
	// % protected region % [Update the route mapping or description for the 'exportPurchaseOrderStockDetail' endpoint here] off begin
	@Operation(
			description = "Download a csv file including all Purchase Order Stock Detail entities included in the ids provided",
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
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@GetMapping(value = "/export", produces = "text/csv")
	// % protected region % [Update the route mapping or description for the 'exportPurchaseOrderStockDetail' endpoint here] end
	public void exportPurchaseOrderStockDetail(
			@Parameter(description = "The ids of the PurchaseOrderStockDetailEntities to export")
			@RequestParam @NotNull List<UUID> ids, HttpServletResponse response
	) {
		if (ids == null || ids.size() == 0) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			List<PurchaseOrderStockDetailEntity> entitiesToExport = purchaseOrderStockDetailService.findAllByIds(ids);
			// % protected region % [Modify the default file name for the Export endpoint here] off begin
			String datetime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			String fileName = "PurchaseOrderStockDetail_Export_" + datetime + ".csv";
			// % protected region % [Modify the default file name for the Export endpoint here] end

		for (PurchaseOrderStockDetailEntity entity: entitiesToExport) {
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
	// % protected region % [Update the route mapping or description for the 'exportPurchaseOrderStockDetailExcludingIds' endpoint here] off begin
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
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@GetMapping(value = "/export-excluding", produces = "text/csv")
	// % protected region % [Update the route mapping or description for the 'exportPurchaseOrderStockDetailExcludingIds' endpoint here] end
	public void exportPurchaseOrderStockDetailExcludingIds(
			@Parameter(description = "The ids of the PurchaseOrderStockDetailEntities to exclude from the export")
			@RequestParam @NotNull List<UUID> ids, HttpServletResponse response
	) {
		List<PurchaseOrderStockDetailEntity> entitiesToExport;
		// % protected region % [Modify the default file name for the Export Excluding endpoint here] off begin
		String datetime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String fileName = "PurchaseOrderStockDetail_Export_" + datetime + ".csv";
		// % protected region % [Modify the default file name for the Export Excluding endpoint here] end

		if (ids == null || ids.size() == 0) {
			entitiesToExport = purchaseOrderStockDetailService.findAllExcludingIds(new ArrayList<>());
		} else {
			entitiesToExport = purchaseOrderStockDetailService.findAllExcludingIds(ids);
		}

		for (PurchaseOrderStockDetailEntity entity: entitiesToExport) {
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
	 * Download a CSV file containing all of the headers of the PurchaseOrderStockDetail entity.
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
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'create')")
	@GetMapping(value = "/example-import", produces = "text/csv")
	// % protected region % [Update the route mapping or description for the 'csvImportExample' endpoint here] end
	public void csvImportExample(
		HttpServletResponse response
	) {
		// % protected region % [Modify the default file name for the Example Import endpoint here] off begin
		String datetime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String fileName = "PurchaseOrderStockDetail_Import_Example_" + datetime + ".csv";
		// % protected region % [Modify the default file name for the Example Import endpoint here] end
		try {
			InputStream is = new ByteArrayInputStream(PurchaseOrderStockDetailEntity.getExampleCsvHeader().getBytes());

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
	 * Upload a CSV file containing attributes for Purchase Order Stock Detail entities, and import them into the database.  This method
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
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'create')  || hasPermission('PurchaseOrderStockDetailEntity', 'update')")
	@PostMapping(value = "/import-csv")
	// % protected region % [Update the route mapping or description for the 'csvUpload' endpoint here] end
	public ResponseEntity<String> csvUpload(HttpServletRequest request,
			@Parameter(description = "The CSV file with PurchaseOrderStockDetailEntity entities to import")
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
		CustomGrantedAuthority entityAuthority = authorities.stream().filter(x -> x.getTargetEntity().matches("PurchaseOrderStockDetailEntity"))
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
		List<String> allowedHeaders = Arrays.asList(PurchaseOrderStockDetailEntity.getExampleCsvHeader().split(","));
		response = csvUtils.headersValid(allowedHeaders, columnHeaders);
		readerForHeaderCheck.close();

		if (response != null) {
			reader.close();
			return response;
		}

		// The CSV to Bean Builder will parse the csv file one line at a time, and create an entity of the given type
		// This entity can then be added to the database
		CsvToBean<PurchaseOrderStockDetailEntity> csvToBean = new CsvToBeanBuilder<PurchaseOrderStockDetailEntity>(reader)
				.withType(PurchaseOrderStockDetailEntity.class)
				.withIgnoreLeadingWhiteSpace(true)
				.withThrowExceptions(true)
				.build();

		List<PurchaseOrderStockDetailEntity> entities = new ArrayList<>();
		List<String> importErrors = new ArrayList<>();
		int currentLine = 2; //Header is line 1, so start at 2

		// If the first entry in the CSV has a parsing error, it will throw an exception
		// Therefore need to wrap in try catch
		try {
			Iterator<PurchaseOrderStockDetailEntity> iterator = csvToBean.iterator();

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
								+ ": You attempted to update a Purchase Order Stock Detail entity and you do not have permission");
					}

					if (next.getId() == null && !allowCreate) {
						return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Line " + currentLine
								+ ": You attempted to create a Purchase Order Stock Detail entity and you do not have permission");
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
