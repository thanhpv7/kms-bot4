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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import kmsweb.entities.AdministrationUserEntity;
import kmsweb.entities.AdministrationUserEntityAudit;
import kmsweb.repositories.AdministrationUserRepository;
import kmsweb.services.AdministrationUserService;
import kmsweb.services.utils.CsvUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Tests for methods in CSV Utils which do not require the use of inputs related to the entity
 *
 * The entity service has to be mocked as it is a required input, so a random entity was used.
 * However anything related to this entity is not used in this test class
 */
@Tag("CSV")
public class AbstractCsvUtilsTest {

	@Mock
	private AdministrationUserService service;

	private CsvUtils<AdministrationUserEntity, AdministrationUserRepository, AdministrationUserEntityAudit, AdministrationUserService> csvUtils;

	private final List<String> allowedHeaders = List.of("foo", "bar", "baz");

	@BeforeEach
	public void setup() {
		this.csvUtils = new CsvUtils<>(service, AdministrationUserEntity.class);
	}

	@Test
	void whenFileUploadedNull_thenCheckUploadInvalid() {
		ResponseEntity<String> response = csvUtils.uploadValid(null);

		Assertions.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	void whenFileUploadedEmpty_thenCheckUploadInvalid() {
		MockMultipartFile file = new MockMultipartFile(
				"empty.csv",
				"empty.csv",
				MediaType.TEXT_PLAIN_VALUE,
				"".getBytes() //If file is empty then there is no need to continue with import
		);

		ResponseEntity<String> response = csvUtils.uploadValid(file);

		Assertions.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	void whenFileUploadedWrongType_thenCheckUploadInvalid() {
		MockMultipartFile file = new MockMultipartFile(
				"invalid.notcsv",
				"invalid.notcsv", // upload should fail if file does not end in .csv
				MediaType.TEXT_PLAIN_VALUE,
				"".getBytes()
		);

		ResponseEntity<String> response = csvUtils.uploadValid(file);

		Assertions.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	void whenValidFileUploaded_thenCheckUploadValid() {
		MockMultipartFile file = new MockMultipartFile(
				"valid.csv",
				"valid.csv",
				MediaType.TEXT_PLAIN_VALUE,
				"test,csv".getBytes()
		);

		ResponseEntity<String> response = csvUtils.uploadValid(file);

		// null response indicates success, as non null response is the error to return to the client
		Assertions.assertNull(response);
	}

	@Test
	void whenAllAllowedHeadersPresent_thenCheckHeadersValid() {
		String[] presentHeaders = {"foo", "bar", "baz"};

		ResponseEntity<String> response = csvUtils.headersValid(allowedHeaders, presentHeaders);

		Assertions.assertNull(response);
	}

	@Test
	void whenAllAllowedHeadersPresentInWrongOrder_thenCheckHeadersValid() {
		String[] presentHeaders = {"bar", "foo", "baz"};

		ResponseEntity<String> response = csvUtils.headersValid(allowedHeaders, presentHeaders);

		Assertions.assertNull(response);
	}

	@Test
	void whenSomeAllowedHeadersPresent_thenCheckHeadersValid() {
		String[] presentHeaders = {"bar", "foo"};

		ResponseEntity<String> response = csvUtils.headersValid(allowedHeaders, presentHeaders);

		Assertions.assertNull(response);
	}

	@Test
	void whenAllowedHeadersDuplicated_thenCheckHeadersInvalid() {
		String[] presentHeaders = {"foo", "foo"};

		ResponseEntity<String> response = csvUtils.headersValid(allowedHeaders, presentHeaders);

		Assertions.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	void whenInvalidHeadersAdded_thenCheckHeadersInvalid() {
		String[] presentHeaders = {"foo", "Invalid"};

		ResponseEntity<String> response = csvUtils.headersValid(allowedHeaders, presentHeaders);

		Assertions.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}
}