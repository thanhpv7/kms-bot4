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
import kmsweb.controllers.MedicalRecordInitialChecklistController;
import kmsweb.entities.MedicalRecordInitialChecklistEntity;
import kmsweb.entities.MedicalRecordInitialChecklistEntityAudit;
import kmsweb.repositories.MedicalRecordInitialChecklistRepository;
import kmsweb.services.MedicalRecordInitialChecklistService;
import kmsweb.services.utils.CsvUtils;
import kmsweb.utils.MedicalRecordInitialChecklistFactory;

import java.util.*;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import static org.mockito.Mockito.*;

@Tag("CSV")
public class MedicalRecordInitialChecklistCsvTest {

	@Mock
	private MedicalRecordInitialChecklistService service;

	@Mock
	private AuthenticationService authenticationService;

	@Mock
	private ConstraintViolation<?> violation;

	private MedicalRecordInitialChecklistController controller;

	private CsvUtils<MedicalRecordInitialChecklistEntity, MedicalRecordInitialChecklistRepository, MedicalRecordInitialChecklistEntityAudit, MedicalRecordInitialChecklistService> csvUtils;

	private final MedicalRecordInitialChecklistFactory factory = new MedicalRecordInitialChecklistFactory();

	private final String exportedCsvFileName = "test-export.csv";

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);

		this.controller = new MedicalRecordInitialChecklistController(authenticationService, service);
		this.csvUtils = new CsvUtils<>(service, MedicalRecordInitialChecklistEntity.class);
	}

	@Test
	void whenExportingMedicalRecordInitialChecklistEntities_thenHeadersAreValid() throws Exception {
		List<MedicalRecordInitialChecklistEntity> entitiesToExport = new ArrayList<>();
		MockHttpServletResponse response = new MockHttpServletResponse();

		entitiesToExport.add(factory.getObject());

		csvUtils.exportCsvFile(entitiesToExport, exportedCsvFileName, response);

		String responseContent = response.getContentAsString();
		String[] lines = responseContent.split("\n");
		String csvHeaders = lines[0];

		// Example CSV header does not contain the following attributes, so we need to add them back in for the assertion
		List<String> expectedHeaders = Arrays.asList(MedicalRecordInitialChecklistEntity.getExampleCsvHeader().concat(",CREATED,CREATED_BY,MODIFIED,MODIFIED_BY").split(","));

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
	void whenExportingMedicalRecordInitialChecklistEntities_thenEntitiesAreValid() throws Exception {
		List<MedicalRecordInitialChecklistEntity> entitiesToExport = new ArrayList<>();
		MockHttpServletResponse response = new MockHttpServletResponse();

		entitiesToExport.add(factory.getObject());

		csvUtils.exportCsvFile(entitiesToExport, exportedCsvFileName, response);

		String responseContent = response.getContentAsString();
		String[] lines = responseContent.split("\n");

		//First line is header.  For this test we only care about the entity itself
		String exportedEntityCsv = lines[1];

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getId()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOutVitalSign()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOutAnamnesis()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOutPhysicalExamination()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOutDiagnosis()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOutDismissalType()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOutDismissalDateAndTime()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getInpVitalSign()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getInpDailyCareDoctorNotes()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getInpDailyCareDoctorNotesNA()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getInpDailyCareNursingNotes()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getInpDailyCareNursingNotesNA()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getInpDailyCareProgressNotes()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getInpDailyCareProgressNotesNA()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getInpDismissalDiagnosis()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getInpDismissalType()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getInpDismissalDateAndTime()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getInpDismissalCondition()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDrAdmissionDiagnosis()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDrObservationDoctorNotes()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDrObservationDoctorNotesNA()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDrObservationNursingNotes()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDrObservationNursingNotesNA()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDrObservationProgressNotes()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDrObservationProgressNotesNA()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDrDismissalDiagnosis()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDrDismissalType()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDrDismissalDateAndTime()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOtPreOperativeDiagnosis()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOtPreOperativeNotesSurgery()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOtPreOperativeNotesAnaesthesiology()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOtIntraOperativeNotesSurgery()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOtIntraOperativeNotesAnaesthesiology()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOtPostOperativeNotesSurgery()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOtPostOperativeNotesAnaesthesiology()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOtPostOperativeDiagnosis()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOtDismissalType()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getOtDismissalDateAndTime()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDsResponsibleStaff()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDsInterpretation()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getNotes())));
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

		List<String> expectedHeaders = Arrays.asList(MedicalRecordInitialChecklistEntity.getExampleCsvHeader().split(","));

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
		MedicalRecordInitialChecklistEntity generatedEntity = factory.getObject();
		generatedEntity.setId(null);

		when(violation.getInvalidValue()).thenReturn("invalid value");
		when(violation.getMessage()).thenReturn("violation message");

		Set<ConstraintViolation<?>> constraintViolations = new HashSet<>();
		constraintViolations.add(violation);

		// the normal mocking notation does not work properly when mocking void methods
		doThrow(new ConstraintViolationException(constraintViolations)).when(service).validateEntity(any(MedicalRecordInitialChecklistEntity.class));


		Assertions.assertEquals(csvUtils.validateEntities(Collections.singletonList(generatedEntity)).getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	void whenEntityRelationValidationFailsInImport_thenImportIsInvalid() throws Exception {
		MedicalRecordInitialChecklistEntity generatedEntity = factory.getObject();
		generatedEntity.setId(null);

		Set<String> relationValidationErrors = new HashSet<>();
		relationValidationErrors.add("error message");

		when(service.validateEntityRelations(any(MedicalRecordInitialChecklistEntity.class))).thenReturn(relationValidationErrors);

		Assertions.assertEquals(csvUtils.validateEntities(Collections.singletonList(generatedEntity)).getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	void whenValidatingImportCreateEntity_thenImportIsValid() throws Exception {
		MedicalRecordInitialChecklistEntity generatedEntity = factory.getObject();
		generatedEntity.setId(null);

		//Mocking the following responses to validation imitates the scenario where no violations are found
		doNothing().when(service).validateEntity(any(MedicalRecordInitialChecklistEntity.class));
		when(service.validateEntityRelations(any(MedicalRecordInitialChecklistEntity.class))).thenReturn(new HashSet<>());

		Assertions.assertNull(csvUtils.validateEntities(Collections.singletonList(generatedEntity)));
	}

	@Test
	void whenValidatingImportUpdateEntity_thenImportIsValid() throws Exception {
		MedicalRecordInitialChecklistEntity generatedEntity = factory.getObject();

		//Mocking the following responses to validation imitates the scenario where no violations are found
		assert generatedEntity != null;
		when(service.findById(any(UUID.class))).thenReturn(Optional.of(generatedEntity));
		doNothing().when(service).validateEntity(any(MedicalRecordInitialChecklistEntity.class));
		when(service.validateEntityRelations(any(MedicalRecordInitialChecklistEntity.class))).thenReturn(new HashSet<>());

		Assertions.assertNull(csvUtils.validateEntities(Collections.singletonList(generatedEntity)));
	}
}