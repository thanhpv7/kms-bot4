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
import kmsweb.controllers.BpjsPcareRiwayatKunjunganController;
import kmsweb.entities.BpjsPcareRiwayatKunjunganEntity;
import kmsweb.entities.BpjsPcareRiwayatKunjunganEntityAudit;
import kmsweb.repositories.BpjsPcareRiwayatKunjunganRepository;
import kmsweb.services.BpjsPcareRiwayatKunjunganService;
import kmsweb.services.utils.CsvUtils;
import kmsweb.utils.BpjsPcareRiwayatKunjunganFactory;

import java.util.*;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import static org.mockito.Mockito.*;

@Tag("CSV")
public class BpjsPcareRiwayatKunjunganCsvTest {

	@Mock
	private BpjsPcareRiwayatKunjunganService service;

	@Mock
	private AuthenticationService authenticationService;

	@Mock
	private ConstraintViolation<?> violation;

	private BpjsPcareRiwayatKunjunganController controller;

	private CsvUtils<BpjsPcareRiwayatKunjunganEntity, BpjsPcareRiwayatKunjunganRepository, BpjsPcareRiwayatKunjunganEntityAudit, BpjsPcareRiwayatKunjunganService> csvUtils;

	private final BpjsPcareRiwayatKunjunganFactory factory = new BpjsPcareRiwayatKunjunganFactory();

	private final String exportedCsvFileName = "test-export.csv";

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);

		this.controller = new BpjsPcareRiwayatKunjunganController(authenticationService, service);
		this.csvUtils = new CsvUtils<>(service, BpjsPcareRiwayatKunjunganEntity.class);
	}

	@Test
	void whenExportingBpjsPcareRiwayatKunjunganEntities_thenHeadersAreValid() throws Exception {
		List<BpjsPcareRiwayatKunjunganEntity> entitiesToExport = new ArrayList<>();
		MockHttpServletResponse response = new MockHttpServletResponse();

		entitiesToExport.add(factory.getObject());

		csvUtils.exportCsvFile(entitiesToExport, exportedCsvFileName, response);

		String responseContent = response.getContentAsString();
		String[] lines = responseContent.split("\n");
		String csvHeaders = lines[0];

		// Example CSV header does not contain the following attributes, so we need to add them back in for the assertion
		List<String> expectedHeaders = Arrays.asList(BpjsPcareRiwayatKunjunganEntity.getExampleCsvHeader().concat(",CREATED,CREATED_BY,MODIFIED,MODIFIED_BY").split(","));

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
	void whenExportingBpjsPcareRiwayatKunjunganEntities_thenEntitiesAreValid() throws Exception {
		List<BpjsPcareRiwayatKunjunganEntity> entitiesToExport = new ArrayList<>();
		MockHttpServletResponse response = new MockHttpServletResponse();

		entitiesToExport.add(factory.getObject());

		csvUtils.exportCsvFile(entitiesToExport, exportedCsvFileName, response);

		String responseContent = response.getContentAsString();
		String[] lines = responseContent.split("\n");

		//First line is header.  For this test we only care about the entity itself
		String exportedEntityCsv = lines[1];

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getId()).toString()));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getNokunjungan())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getTglkunjungan())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getProviderpelayanan())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getNokartu())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getNama())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getHubungankeluarga())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getSex())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getTgllahir())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getTglmulaiaktif())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getTglakhirberlaku())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getKodeppkpeserta())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getKodeppkgigi())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getJeniskelas())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getJenispeserta())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getGoldarah())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getNohp())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getNoktp())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getAsuransi())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getPoli())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getJeniskunjungan())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getProgprolanis())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getKeluhan())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDiagnosa())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDiagnosa2())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDiagnosa3())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getKesadaran())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getSistole())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDiastole())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getBeratbadan())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getTinggibadan())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getRespiratoryrate())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getHeartrate())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getCatatan())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getPemeriksaanfisiklain())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getTglpulang())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getDokter())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getStatuspulang())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getTingkatpelayanan())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getRujukbalik())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getProviderasalrujuk())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getProviderrujuklanjut())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getPolirujukinternal())));

		Assertions.assertTrue(exportedEntityCsv.contains(Objects.requireNonNull(entitiesToExport.get(0).getPolirujuklanjut())));
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

		List<String> expectedHeaders = Arrays.asList(BpjsPcareRiwayatKunjunganEntity.getExampleCsvHeader().split(","));

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
		BpjsPcareRiwayatKunjunganEntity generatedEntity = factory.getObject();
		generatedEntity.setId(null);

		when(violation.getInvalidValue()).thenReturn("invalid value");
		when(violation.getMessage()).thenReturn("violation message");

		Set<ConstraintViolation<?>> constraintViolations = new HashSet<>();
		constraintViolations.add(violation);

		// the normal mocking notation does not work properly when mocking void methods
		doThrow(new ConstraintViolationException(constraintViolations)).when(service).validateEntity(any(BpjsPcareRiwayatKunjunganEntity.class));


		Assertions.assertEquals(csvUtils.validateEntities(Collections.singletonList(generatedEntity)).getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	void whenEntityRelationValidationFailsInImport_thenImportIsInvalid() throws Exception {
		BpjsPcareRiwayatKunjunganEntity generatedEntity = factory.getObject();
		generatedEntity.setId(null);

		Set<String> relationValidationErrors = new HashSet<>();
		relationValidationErrors.add("error message");

		when(service.validateEntityRelations(any(BpjsPcareRiwayatKunjunganEntity.class))).thenReturn(relationValidationErrors);

		Assertions.assertEquals(csvUtils.validateEntities(Collections.singletonList(generatedEntity)).getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	void whenValidatingImportCreateEntity_thenImportIsValid() throws Exception {
		BpjsPcareRiwayatKunjunganEntity generatedEntity = factory.getObject();
		generatedEntity.setId(null);

		//Mocking the following responses to validation imitates the scenario where no violations are found
		doNothing().when(service).validateEntity(any(BpjsPcareRiwayatKunjunganEntity.class));
		when(service.validateEntityRelations(any(BpjsPcareRiwayatKunjunganEntity.class))).thenReturn(new HashSet<>());

		Assertions.assertNull(csvUtils.validateEntities(Collections.singletonList(generatedEntity)));
	}

	@Test
	void whenValidatingImportUpdateEntity_thenImportIsValid() throws Exception {
		BpjsPcareRiwayatKunjunganEntity generatedEntity = factory.getObject();

		//Mocking the following responses to validation imitates the scenario where no violations are found
		assert generatedEntity != null;
		when(service.findById(any(UUID.class))).thenReturn(Optional.of(generatedEntity));
		doNothing().when(service).validateEntity(any(BpjsPcareRiwayatKunjunganEntity.class));
		when(service.validateEntityRelations(any(BpjsPcareRiwayatKunjunganEntity.class))).thenReturn(new HashSet<>());

		Assertions.assertNull(csvUtils.validateEntities(Collections.singletonList(generatedEntity)));
	}
}