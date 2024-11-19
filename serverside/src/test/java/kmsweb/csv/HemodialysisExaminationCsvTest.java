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
import kmsweb.controllers.HemodialysisExaminationController;
import kmsweb.entities.HemodialysisExaminationEntity;
import kmsweb.entities.HemodialysisExaminationEntityAudit;
import kmsweb.repositories.HemodialysisExaminationRepository;
import kmsweb.services.HemodialysisExaminationService;
import kmsweb.services.utils.CsvUtils;
import kmsweb.utils.HemodialysisExaminationFactory;

import java.util.*;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import static org.mockito.Mockito.*;

@Tag("CSV")
public class HemodialysisExaminationCsvTest {

	@Mock
	private HemodialysisExaminationService service;

	@Mock
	private AuthenticationService authenticationService;

	@Mock
	private ConstraintViolation<?> violation;

	private HemodialysisExaminationController controller;

	private CsvUtils<HemodialysisExaminationEntity, HemodialysisExaminationRepository, HemodialysisExaminationEntityAudit, HemodialysisExaminationService> csvUtils;

	private final HemodialysisExaminationFactory factory = new HemodialysisExaminationFactory();

	private final String exportedCsvFileName = "test-export.csv";

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);

		this.controller = new HemodialysisExaminationController(authenticationService, service);
		this.csvUtils = new CsvUtils<>(service, HemodialysisExaminationEntity.class);
	}

	@Test
	void whenExportingHemodialysisExaminationEntities_thenHeadersAreValid() throws Exception {
		List<HemodialysisExaminationEntity> entitiesToExport = new ArrayList<>();
		MockHttpServletResponse response = new MockHttpServletResponse();

		entitiesToExport.add(factory.getObject());

		csvUtils.exportCsvFile(entitiesToExport, exportedCsvFileName, response);

		String responseContent = response.getContentAsString();
		String[] lines = responseContent.split("\n");
		String csvHeaders = lines[0];

		// Example CSV header does not contain the following attributes, so we need to add them back in for the assertion
		List<String> expectedHeaders = Arrays.asList(HemodialysisExaminationEntity.getExampleCsvHeader().concat(",CREATED,CREATED_BY,MODIFIED,MODIFIED_BY").split(","));

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
	void whenExportingHemodialysisExaminationEntities_thenEntitiesAreValid() throws Exception {
		List<HemodialysisExaminationEntity> entitiesToExport = new ArrayList<>();
		MockHttpServletResponse response = new MockHttpServletResponse();

		entitiesToExport.add(factory.getObject());

		csvUtils.exportCsvFile(entitiesToExport, exportedCsvFileName, response);

		String responseContent = response.getContentAsString();
		String[] lines = responseContent.split("\n");

		//First line is header.  For this test we only care about the entity itself
		String exportedEntityCsv = lines[1];

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getId()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getFirstDialysis()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDialysisFrequency())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDialysisNo())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getHemodialysisType())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getCondition())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getVascularAccess())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getHeparinization())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getHeparinizationInitialDose())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getHeparinizationFollowUpDose())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDialyzer())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDialyzerType())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDialysisFluid())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDryWeight()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDryWeightUnit())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getWeightUponArrival()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getWeightUponArrivalUnit())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getWeightDuringPreviousHemodialysis()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getWeightDuringPreviousHemodialysisUnit())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getAntiHIV()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getHbsag()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getAntiHCV()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getHemodialysisStartTime()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getHemodialysisEndTime()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getTarget())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getPrimingVolume())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getRemainingPriming())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getComplication())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getHemodialysisDetails())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getWeightUponDismissal()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getWeightUponDismissalUnit())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getPriming()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getBlood()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getIvLine()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOral()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getWashOut()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getTotalFluidIntake()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getUrine()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOthers()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getTotalFluidOutput()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getFluidBalance()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getPostHemodialysisEvaluation())));
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

		List<String> expectedHeaders = Arrays.asList(HemodialysisExaminationEntity.getExampleCsvHeader().split(","));

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
		HemodialysisExaminationEntity generatedEntity = factory.getObject();
		generatedEntity.setId(null);

		when(violation.getInvalidValue()).thenReturn("invalid value");
		when(violation.getMessage()).thenReturn("violation message");

		Set<ConstraintViolation<?>> constraintViolations = new HashSet<>();
		constraintViolations.add(violation);

		// the normal mocking notation does not work properly when mocking void methods
		doThrow(new ConstraintViolationException(constraintViolations)).when(service).validateEntity(any(HemodialysisExaminationEntity.class));


		Assertions.assertEquals(csvUtils.validateEntities(Collections.singletonList(generatedEntity)).getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	void whenEntityRelationValidationFailsInImport_thenImportIsInvalid() throws Exception {
		HemodialysisExaminationEntity generatedEntity = factory.getObject();
		generatedEntity.setId(null);

		Set<String> relationValidationErrors = new HashSet<>();
		relationValidationErrors.add("error message");

		when(service.validateEntityRelations(any(HemodialysisExaminationEntity.class))).thenReturn(relationValidationErrors);

		Assertions.assertEquals(csvUtils.validateEntities(Collections.singletonList(generatedEntity)).getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	void whenValidatingImportCreateEntity_thenImportIsValid() throws Exception {
		HemodialysisExaminationEntity generatedEntity = factory.getObject();
		generatedEntity.setId(null);

		//Mocking the following responses to validation imitates the scenario where no violations are found
		doNothing().when(service).validateEntity(any(HemodialysisExaminationEntity.class));
		when(service.validateEntityRelations(any(HemodialysisExaminationEntity.class))).thenReturn(new HashSet<>());

		Assertions.assertNull(csvUtils.validateEntities(Collections.singletonList(generatedEntity)));
	}

	@Test
	void whenValidatingImportUpdateEntity_thenImportIsValid() throws Exception {
		HemodialysisExaminationEntity generatedEntity = factory.getObject();

		//Mocking the following responses to validation imitates the scenario where no violations are found
		assert generatedEntity != null;
		when(service.findById(any(UUID.class))).thenReturn(Optional.of(generatedEntity));
		doNothing().when(service).validateEntity(any(HemodialysisExaminationEntity.class));
		when(service.validateEntityRelations(any(HemodialysisExaminationEntity.class))).thenReturn(new HashSet<>());

		Assertions.assertNull(csvUtils.validateEntities(Collections.singletonList(generatedEntity)));
	}
}