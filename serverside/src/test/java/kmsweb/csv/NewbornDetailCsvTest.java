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

package kmsweb.csv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import kmsweb.configs.security.services.AuthenticationService;
import kmsweb.controllers.NewbornDetailController;
import kmsweb.entities.NewbornDetailEntity;
import kmsweb.entities.NewbornDetailEntityAudit;
import kmsweb.repositories.NewbornDetailRepository;
import kmsweb.services.NewbornDetailService;
import kmsweb.services.utils.CsvUtils;
import kmsweb.utils.NewbornDetailFactory;

import java.util.*;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import static org.mockito.Mockito.*;

@Tag("CSV")
public class NewbornDetailCsvTest {

	@Mock
	private NewbornDetailService service;

	@Mock
	private AuthenticationService authenticationService;

	@Mock
	private ConstraintViolation<?> violation;

	private NewbornDetailController controller;

	private CsvUtils<NewbornDetailEntity, NewbornDetailRepository, NewbornDetailEntityAudit, NewbornDetailService> csvUtils;

	private final NewbornDetailFactory factory = new NewbornDetailFactory();

	private final String exportedCsvFileName = "test-export.csv";

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);

		this.controller = new NewbornDetailController(authenticationService, service);
		this.csvUtils = new CsvUtils<>(service, NewbornDetailEntity.class);
	}

	@Test
	void whenExportingNewbornDetailEntities_thenHeadersAreValid() throws Exception {
		List<NewbornDetailEntity> entitiesToExport = new ArrayList<>();
		MockHttpServletResponse response = new MockHttpServletResponse();

		entitiesToExport.add(factory.getObject());

		csvUtils.exportCsvFile(entitiesToExport, exportedCsvFileName, response);

		String responseContent = response.getContentAsString();
		String[] lines = responseContent.split("\n");
		String csvHeaders = lines[0];

		// Example CSV header does not contain the following attributes, so we need to add them back in for the assertion
		List<String> expectedHeaders = Arrays.asList(NewbornDetailEntity.getExampleCsvHeader().concat(",CREATED,CREATED_BY,MODIFIED,MODIFIED_BY").split(","));

		String[] actualHeaders = csvHeaders.split(",");
		boolean areHeadersValid = true;

		for (String header: actualHeaders) {
			if (!expectedHeaders.contains(header.replace("\"", ""))) {
				areHeadersValid = false;
				break;
			}
		}

		Assertions.assertTrue(areHeadersValid);
	}

	@Test
	void whenExportingNewbornDetailEntities_thenEntitiesAreValid() throws Exception {
		List<NewbornDetailEntity> entitiesToExport = new ArrayList<>();
		MockHttpServletResponse response = new MockHttpServletResponse();

		entitiesToExport.add(factory.getObject());

		csvUtils.exportCsvFile(entitiesToExport, exportedCsvFileName, response);

		String responseContent = response.getContentAsString();
		String[] lines = responseContent.split("\n");

		//First line is header.  For this test we only care about the entity itself
		String exportedEntityCsv = lines[1];

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getId()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getNewbornFirstName())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getNewbornLastName())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDateTimeOfBirth()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getGender())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDeliveryType())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDeliveryTypeIndication())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getWeight()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getLength()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getWeightOfGestationalAge())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getHeadCircumference()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getChestCircumference()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getBirthCondition())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getNeonatalCase())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getCongenitalCondition())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getPhysicalExamination())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar1MinuteAppearance())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar5MinuteAppearance())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar10MinuteAppearance())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar1MinutePulse())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar5MinutePulse())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar10MinutePulse())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar1MinuteGrimace())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar5MinuteGrimace())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar10MinuteGrimace())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar1MinuteActivity())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar5MinuteActivity())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar10MinuteActivity())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar1MinuteRespiration())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar5MinuteRespiration())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar10MinuteRespiration())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar1MinuteScore())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar5MinuteScore())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getApgar10MinuteScore())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getPediatricNurse())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getPatientId())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getRegistrationId())));
	}

	@Test
	void whenDownloadingImportExample_thenImportIsValid() throws Exception {
		MockHttpServletResponse response = new MockHttpServletResponse();

		controller.csvImportExample(response);

		String responseContent = response.getContentAsString();
		assert responseContent != null;
		String[] lines = responseContent.split("\n");
		String csvHeaders = lines[0];

		// Import Example should only contain 1 line (The Header) so we can make an assertion on the length of the lines array
		Assertions.assertEquals(1, lines.length);

		List<String> expectedHeaders = Arrays.asList(NewbornDetailEntity.getExampleCsvHeader().split(","));

		String[] actualHeaders = csvHeaders.split(",");

		for (String header: actualHeaders) {
			Assertions.assertTrue(expectedHeaders.contains(header.replace("\"", "")));
		}
	}

	@Test
	void whenEntityIdExistsAndValidationCantFindEntity_thenImportIsInvalid() throws Exception {
		when(service.findById(any(UUID.class))).thenReturn(Optional.empty());

		Assertions.assertEquals(csvUtils.validateEntities(Collections.singletonList(factory.getObject())).getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	void whenEntityValidationFailsInImport_thenImportIsInvalid() throws Exception {
		NewbornDetailEntity generatedEntity = factory.getObject();
		generatedEntity.setId(null);

		when(violation.getInvalidValue()).thenReturn("invalid value");
		when(violation.getMessage()).thenReturn("violation message");

		Set<ConstraintViolation<?>> constraintViolations = new HashSet<>();
		constraintViolations.add(violation);

		// the normal mocking notation does not work properly when mocking void methods
		doThrow(new ConstraintViolationException(constraintViolations)).when(service).validateEntity(any(NewbornDetailEntity.class));


		Assertions.assertEquals(csvUtils.validateEntities(Collections.singletonList(generatedEntity)).getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	void whenEntityRelationValidationFailsInImport_thenImportIsInvalid() throws Exception {
		NewbornDetailEntity generatedEntity = factory.getObject();
		generatedEntity.setId(null);

		Set<String> relationValidationErrors = new HashSet<>();
		relationValidationErrors.add("error message");

		when(service.validateEntityRelations(any(NewbornDetailEntity.class))).thenReturn(relationValidationErrors);

		Assertions.assertEquals(csvUtils.validateEntities(Collections.singletonList(generatedEntity)).getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	void whenValidatingImportCreateEntity_thenImportIsValid() throws Exception {
		NewbornDetailEntity generatedEntity = factory.getObject();
		generatedEntity.setId(null);

		//Mocking the following responses to validation imitates the scenario where no violations are found
		doNothing().when(service).validateEntity(any(NewbornDetailEntity.class));
		when(service.validateEntityRelations(any(NewbornDetailEntity.class))).thenReturn(new HashSet<>());

		Assertions.assertNull(csvUtils.validateEntities(Collections.singletonList(generatedEntity)));
	}

	@Test
	void whenValidatingImportUpdateEntity_thenImportIsValid() throws Exception {
		NewbornDetailEntity generatedEntity = factory.getObject();

		//Mocking the following responses to validation imitates the scenario where no violations are found
		assert generatedEntity != null;
		when(service.findById(any(UUID.class))).thenReturn(Optional.of(generatedEntity));
		doNothing().when(service).validateEntity(any(NewbornDetailEntity.class));
		when(service.validateEntityRelations(any(NewbornDetailEntity.class))).thenReturn(new HashSet<>());

		Assertions.assertNull(csvUtils.validateEntities(Collections.singletonList(generatedEntity)));
	}
}