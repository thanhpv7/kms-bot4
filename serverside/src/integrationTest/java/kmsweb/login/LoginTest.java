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
package kmsweb.login;

import kmsweb.SpringTestConfiguration;
import kmsweb.dtos.ErrorDto;
import kmsweb.dtos.ErrorResponseDto;
import kmsweb.utils.RequestUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

import static org.hamcrest.collection.IsIterableContainingInOrder.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static kmsweb.configs.security.repositories.XsrfTokenRepository.*;

// % protected region % [Add any additional imports for setup before the main body here] off begin
// % protected region % [Add any additional imports for setup before the main body here] end

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringTestConfiguration.class)
@ActiveProfiles("test")
public class LoginTest {
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private ObjectMapper mapper;

	private MockMvc mvc;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@BeforeEach
	public void setup() {
		// % protected region % [Add any additional logic for setup before the main body here] off begin
		// % protected region % [Add any additional logic for setup before the main body here] end

		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();

		// % protected region % [Add any additional logic for setup after the main body here] off begin
		// % protected region % [Add any additional logic for setup after the main body here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void loginWithAdministrationUserEntity_shouldSucceedWith200() throws Exception {
		// % protected region % [Add any additional logic for loginWithAdministrationUserEntity_shouldSucceedWith200 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithAdministrationUserEntity_shouldSucceedWith200 before the main body here] end

		LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", "administrationUser@example.com");
		body.add("password", "password");

		ResultActions result = mvc.perform(
				post("/auth/login")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.params(body)
		);

		// Test the outer response first.
		result.andExpect(status().isOk());
		result.andExpect(cookie().exists(XSRF_TOKEN_COOKIE_NAME));

		// Test the actual JSON content.
		result.andDo(rs -> {
			Map<String, Object> actual = mapper.readValue(rs.getResponse().getContentAsString(), new TypeReference<>() {});

			Assertions.assertNotNull(actual.get("id"));
			Assertions.assertEquals("administrationUser@example.com", actual.get("username"));

			List<String> groups = (List<String>) actual.get("groups");
			MatcherAssert.assertThat(groups, contains(
					"ADMINISTRATION_USER"
			));

			// % protected region % [Add any additional content assertions for loginWithAdministrationUserEntity_shouldSucceedWith200 here] off begin
			// % protected region % [Add any additional content assertions for loginWithAdministrationUserEntity_shouldSucceedWith200 here] end
		});

		// % protected region % [Add any additional assertions for loginWithAdministrationUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional assertions for loginWithAdministrationUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	public void loginWithAdministrationUserEntityButWrongEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithAdministrationUserEntityButWrongEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithAdministrationUserEntityButWrongEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "administrationUser-random@example.com");
		body.put("password", "password");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithAdministrationUserEntityButWrongEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithAdministrationUserEntityButWrongEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithAdministrationUserEntityButWrongEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithAdministrationUserEntityButWrongEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithAdministrationUserEntityButWrongPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithAdministrationUserEntityButWrongPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithAdministrationUserEntityButWrongPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "administrationUser@example.com");
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithAdministrationUserEntityButWrongPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithAdministrationUserEntityButWrongPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithAdministrationUserEntityButWrongPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithAdministrationUserEntityButWrongPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithAdministrationUserEntityWithNoEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithAdministrationUserEntityWithNoEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithAdministrationUserEntityWithNoEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithAdministrationUserEntityWithNoEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithAdministrationUserEntityWithNoEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithAdministrationUserEntityWithNoEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithAdministrationUserEntityWithNoEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithAdministrationUserEntityWithNoPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithAdministrationUserEntityWithNoPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithAdministrationUserEntityWithNoPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "administrationUser@example.com");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithAdministrationUserEntityWithNoPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithAdministrationUserEntityWithNoPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithAdministrationUserEntityWithNoPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithAdministrationUserEntityWithNoPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithAdministrationUserEntityWithNoEmailPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithAdministrationUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithAdministrationUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithAdministrationUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithAdministrationUserEntityWithNoEmailPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithAdministrationUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithAdministrationUserEntityWithNoEmailPassword_shouldFailWith401 here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void loginWithAdministratorEntity_shouldSucceedWith200() throws Exception {
		// % protected region % [Add any additional logic for loginWithAdministratorEntity_shouldSucceedWith200 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithAdministratorEntity_shouldSucceedWith200 before the main body here] end

		LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", "administrator@example.com");
		body.add("password", "password");

		ResultActions result = mvc.perform(
				post("/auth/login")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.params(body)
		);

		// Test the outer response first.
		result.andExpect(status().isOk());
		result.andExpect(cookie().exists(XSRF_TOKEN_COOKIE_NAME));

		// Test the actual JSON content.
		result.andDo(rs -> {
			Map<String, Object> actual = mapper.readValue(rs.getResponse().getContentAsString(), new TypeReference<>() {});

			Assertions.assertNotNull(actual.get("id"));
			Assertions.assertEquals("administrator@example.com", actual.get("username"));

			List<String> groups = (List<String>) actual.get("groups");
			MatcherAssert.assertThat(groups, contains(
					"ADMINISTRATOR"
			));

			// % protected region % [Add any additional content assertions for loginWithAdministratorEntity_shouldSucceedWith200 here] off begin
			// % protected region % [Add any additional content assertions for loginWithAdministratorEntity_shouldSucceedWith200 here] end
		});

		// % protected region % [Add any additional assertions for loginWithAdministratorEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional assertions for loginWithAdministratorEntity_shouldSucceedWith200 here] end
	}

	@Test
	public void loginWithAdministratorEntityButWrongEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithAdministratorEntityButWrongEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithAdministratorEntityButWrongEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "administrator-random@example.com");
		body.put("password", "password");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithAdministratorEntityButWrongEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithAdministratorEntityButWrongEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithAdministratorEntityButWrongEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithAdministratorEntityButWrongEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithAdministratorEntityButWrongPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithAdministratorEntityButWrongPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithAdministratorEntityButWrongPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "administrator@example.com");
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithAdministratorEntityButWrongPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithAdministratorEntityButWrongPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithAdministratorEntityButWrongPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithAdministratorEntityButWrongPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithAdministratorEntityWithNoEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithAdministratorEntityWithNoEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithAdministratorEntityWithNoEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithAdministratorEntityWithNoEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithAdministratorEntityWithNoEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithAdministratorEntityWithNoEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithAdministratorEntityWithNoEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithAdministratorEntityWithNoPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithAdministratorEntityWithNoPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithAdministratorEntityWithNoPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "administrator@example.com");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithAdministratorEntityWithNoPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithAdministratorEntityWithNoPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithAdministratorEntityWithNoPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithAdministratorEntityWithNoPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithAdministratorEntityWithNoEmailPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithAdministratorEntityWithNoEmailPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithAdministratorEntityWithNoEmailPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithAdministratorEntityWithNoEmailPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithAdministratorEntityWithNoEmailPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithAdministratorEntityWithNoEmailPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithAdministratorEntityWithNoEmailPassword_shouldFailWith401 here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void loginWithCashierUserEntity_shouldSucceedWith200() throws Exception {
		// % protected region % [Add any additional logic for loginWithCashierUserEntity_shouldSucceedWith200 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithCashierUserEntity_shouldSucceedWith200 before the main body here] end

		LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", "cashierUser@example.com");
		body.add("password", "password");

		ResultActions result = mvc.perform(
				post("/auth/login")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.params(body)
		);

		// Test the outer response first.
		result.andExpect(status().isOk());
		result.andExpect(cookie().exists(XSRF_TOKEN_COOKIE_NAME));

		// Test the actual JSON content.
		result.andDo(rs -> {
			Map<String, Object> actual = mapper.readValue(rs.getResponse().getContentAsString(), new TypeReference<>() {});

			Assertions.assertNotNull(actual.get("id"));
			Assertions.assertEquals("cashierUser@example.com", actual.get("username"));

			List<String> groups = (List<String>) actual.get("groups");
			MatcherAssert.assertThat(groups, contains(
					"CASHIER_USER"
			));

			// % protected region % [Add any additional content assertions for loginWithCashierUserEntity_shouldSucceedWith200 here] off begin
			// % protected region % [Add any additional content assertions for loginWithCashierUserEntity_shouldSucceedWith200 here] end
		});

		// % protected region % [Add any additional assertions for loginWithCashierUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional assertions for loginWithCashierUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	public void loginWithCashierUserEntityButWrongEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithCashierUserEntityButWrongEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithCashierUserEntityButWrongEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "cashierUser-random@example.com");
		body.put("password", "password");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithCashierUserEntityButWrongEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithCashierUserEntityButWrongEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithCashierUserEntityButWrongEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithCashierUserEntityButWrongEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithCashierUserEntityButWrongPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithCashierUserEntityButWrongPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithCashierUserEntityButWrongPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "cashierUser@example.com");
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithCashierUserEntityButWrongPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithCashierUserEntityButWrongPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithCashierUserEntityButWrongPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithCashierUserEntityButWrongPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithCashierUserEntityWithNoEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithCashierUserEntityWithNoEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithCashierUserEntityWithNoEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithCashierUserEntityWithNoEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithCashierUserEntityWithNoEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithCashierUserEntityWithNoEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithCashierUserEntityWithNoEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithCashierUserEntityWithNoPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithCashierUserEntityWithNoPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithCashierUserEntityWithNoPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "cashierUser@example.com");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithCashierUserEntityWithNoPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithCashierUserEntityWithNoPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithCashierUserEntityWithNoPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithCashierUserEntityWithNoPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithCashierUserEntityWithNoEmailPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithCashierUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithCashierUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithCashierUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithCashierUserEntityWithNoEmailPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithCashierUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithCashierUserEntityWithNoEmailPassword_shouldFailWith401 here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void loginWithClaimUserEntity_shouldSucceedWith200() throws Exception {
		// % protected region % [Add any additional logic for loginWithClaimUserEntity_shouldSucceedWith200 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithClaimUserEntity_shouldSucceedWith200 before the main body here] end

		LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", "claimUser@example.com");
		body.add("password", "password");

		ResultActions result = mvc.perform(
				post("/auth/login")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.params(body)
		);

		// Test the outer response first.
		result.andExpect(status().isOk());
		result.andExpect(cookie().exists(XSRF_TOKEN_COOKIE_NAME));

		// Test the actual JSON content.
		result.andDo(rs -> {
			Map<String, Object> actual = mapper.readValue(rs.getResponse().getContentAsString(), new TypeReference<>() {});

			Assertions.assertNotNull(actual.get("id"));
			Assertions.assertEquals("claimUser@example.com", actual.get("username"));

			List<String> groups = (List<String>) actual.get("groups");
			MatcherAssert.assertThat(groups, contains(
					"CLAIM_USER"
			));

			// % protected region % [Add any additional content assertions for loginWithClaimUserEntity_shouldSucceedWith200 here] off begin
			// % protected region % [Add any additional content assertions for loginWithClaimUserEntity_shouldSucceedWith200 here] end
		});

		// % protected region % [Add any additional assertions for loginWithClaimUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional assertions for loginWithClaimUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	public void loginWithClaimUserEntityButWrongEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithClaimUserEntityButWrongEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithClaimUserEntityButWrongEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "claimUser-random@example.com");
		body.put("password", "password");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithClaimUserEntityButWrongEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithClaimUserEntityButWrongEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithClaimUserEntityButWrongEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithClaimUserEntityButWrongEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithClaimUserEntityButWrongPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithClaimUserEntityButWrongPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithClaimUserEntityButWrongPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "claimUser@example.com");
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithClaimUserEntityButWrongPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithClaimUserEntityButWrongPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithClaimUserEntityButWrongPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithClaimUserEntityButWrongPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithClaimUserEntityWithNoEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithClaimUserEntityWithNoEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithClaimUserEntityWithNoEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithClaimUserEntityWithNoEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithClaimUserEntityWithNoEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithClaimUserEntityWithNoEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithClaimUserEntityWithNoEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithClaimUserEntityWithNoPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithClaimUserEntityWithNoPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithClaimUserEntityWithNoPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "claimUser@example.com");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithClaimUserEntityWithNoPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithClaimUserEntityWithNoPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithClaimUserEntityWithNoPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithClaimUserEntityWithNoPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithClaimUserEntityWithNoEmailPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithClaimUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithClaimUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithClaimUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithClaimUserEntityWithNoEmailPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithClaimUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithClaimUserEntityWithNoEmailPassword_shouldFailWith401 here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void loginWithDiagnosticSupportUserEntity_shouldSucceedWith200() throws Exception {
		// % protected region % [Add any additional logic for loginWithDiagnosticSupportUserEntity_shouldSucceedWith200 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithDiagnosticSupportUserEntity_shouldSucceedWith200 before the main body here] end

		LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", "diagnosticSupportUser@example.com");
		body.add("password", "password");

		ResultActions result = mvc.perform(
				post("/auth/login")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.params(body)
		);

		// Test the outer response first.
		result.andExpect(status().isOk());
		result.andExpect(cookie().exists(XSRF_TOKEN_COOKIE_NAME));

		// Test the actual JSON content.
		result.andDo(rs -> {
			Map<String, Object> actual = mapper.readValue(rs.getResponse().getContentAsString(), new TypeReference<>() {});

			Assertions.assertNotNull(actual.get("id"));
			Assertions.assertEquals("diagnosticSupportUser@example.com", actual.get("username"));

			List<String> groups = (List<String>) actual.get("groups");
			MatcherAssert.assertThat(groups, contains(
					"DIAGNOSTIC_SUPPORT_USER"
			));

			// % protected region % [Add any additional content assertions for loginWithDiagnosticSupportUserEntity_shouldSucceedWith200 here] off begin
			// % protected region % [Add any additional content assertions for loginWithDiagnosticSupportUserEntity_shouldSucceedWith200 here] end
		});

		// % protected region % [Add any additional assertions for loginWithDiagnosticSupportUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional assertions for loginWithDiagnosticSupportUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	public void loginWithDiagnosticSupportUserEntityButWrongEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithDiagnosticSupportUserEntityButWrongEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithDiagnosticSupportUserEntityButWrongEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "diagnosticSupportUser-random@example.com");
		body.put("password", "password");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithDiagnosticSupportUserEntityButWrongEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithDiagnosticSupportUserEntityButWrongEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithDiagnosticSupportUserEntityButWrongEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithDiagnosticSupportUserEntityButWrongEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithDiagnosticSupportUserEntityButWrongPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithDiagnosticSupportUserEntityButWrongPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithDiagnosticSupportUserEntityButWrongPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "diagnosticSupportUser@example.com");
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithDiagnosticSupportUserEntityButWrongPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithDiagnosticSupportUserEntityButWrongPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithDiagnosticSupportUserEntityButWrongPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithDiagnosticSupportUserEntityButWrongPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithDiagnosticSupportUserEntityWithNoEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithDiagnosticSupportUserEntityWithNoEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithDiagnosticSupportUserEntityWithNoEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithDiagnosticSupportUserEntityWithNoEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithDiagnosticSupportUserEntityWithNoEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithDiagnosticSupportUserEntityWithNoEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithDiagnosticSupportUserEntityWithNoEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithDiagnosticSupportUserEntityWithNoPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithDiagnosticSupportUserEntityWithNoPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithDiagnosticSupportUserEntityWithNoPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "diagnosticSupportUser@example.com");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithDiagnosticSupportUserEntityWithNoPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithDiagnosticSupportUserEntityWithNoPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithDiagnosticSupportUserEntityWithNoPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithDiagnosticSupportUserEntityWithNoPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithDiagnosticSupportUserEntityWithNoEmailPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithDiagnosticSupportUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithDiagnosticSupportUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithDiagnosticSupportUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithDiagnosticSupportUserEntityWithNoEmailPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithDiagnosticSupportUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithDiagnosticSupportUserEntityWithNoEmailPassword_shouldFailWith401 here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void loginWithDoctorUserEntity_shouldSucceedWith200() throws Exception {
		// % protected region % [Add any additional logic for loginWithDoctorUserEntity_shouldSucceedWith200 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithDoctorUserEntity_shouldSucceedWith200 before the main body here] end

		LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", "doctorUser@example.com");
		body.add("password", "password");

		ResultActions result = mvc.perform(
				post("/auth/login")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.params(body)
		);

		// Test the outer response first.
		result.andExpect(status().isOk());
		result.andExpect(cookie().exists(XSRF_TOKEN_COOKIE_NAME));

		// Test the actual JSON content.
		result.andDo(rs -> {
			Map<String, Object> actual = mapper.readValue(rs.getResponse().getContentAsString(), new TypeReference<>() {});

			Assertions.assertNotNull(actual.get("id"));
			Assertions.assertEquals("doctorUser@example.com", actual.get("username"));

			List<String> groups = (List<String>) actual.get("groups");
			MatcherAssert.assertThat(groups, contains(
					"DOCTOR_USER"
			));

			// % protected region % [Add any additional content assertions for loginWithDoctorUserEntity_shouldSucceedWith200 here] off begin
			// % protected region % [Add any additional content assertions for loginWithDoctorUserEntity_shouldSucceedWith200 here] end
		});

		// % protected region % [Add any additional assertions for loginWithDoctorUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional assertions for loginWithDoctorUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	public void loginWithDoctorUserEntityButWrongEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithDoctorUserEntityButWrongEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithDoctorUserEntityButWrongEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "doctorUser-random@example.com");
		body.put("password", "password");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithDoctorUserEntityButWrongEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithDoctorUserEntityButWrongEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithDoctorUserEntityButWrongEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithDoctorUserEntityButWrongEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithDoctorUserEntityButWrongPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithDoctorUserEntityButWrongPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithDoctorUserEntityButWrongPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "doctorUser@example.com");
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithDoctorUserEntityButWrongPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithDoctorUserEntityButWrongPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithDoctorUserEntityButWrongPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithDoctorUserEntityButWrongPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithDoctorUserEntityWithNoEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithDoctorUserEntityWithNoEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithDoctorUserEntityWithNoEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithDoctorUserEntityWithNoEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithDoctorUserEntityWithNoEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithDoctorUserEntityWithNoEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithDoctorUserEntityWithNoEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithDoctorUserEntityWithNoPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithDoctorUserEntityWithNoPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithDoctorUserEntityWithNoPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "doctorUser@example.com");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithDoctorUserEntityWithNoPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithDoctorUserEntityWithNoPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithDoctorUserEntityWithNoPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithDoctorUserEntityWithNoPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithDoctorUserEntityWithNoEmailPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithDoctorUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithDoctorUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithDoctorUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithDoctorUserEntityWithNoEmailPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithDoctorUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithDoctorUserEntityWithNoEmailPassword_shouldFailWith401 here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void loginWithFacilityUserEntity_shouldSucceedWith200() throws Exception {
		// % protected region % [Add any additional logic for loginWithFacilityUserEntity_shouldSucceedWith200 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithFacilityUserEntity_shouldSucceedWith200 before the main body here] end

		LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", "facilityUser@example.com");
		body.add("password", "password");

		ResultActions result = mvc.perform(
				post("/auth/login")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.params(body)
		);

		// Test the outer response first.
		result.andExpect(status().isOk());
		result.andExpect(cookie().exists(XSRF_TOKEN_COOKIE_NAME));

		// Test the actual JSON content.
		result.andDo(rs -> {
			Map<String, Object> actual = mapper.readValue(rs.getResponse().getContentAsString(), new TypeReference<>() {});

			Assertions.assertNotNull(actual.get("id"));
			Assertions.assertEquals("facilityUser@example.com", actual.get("username"));

			List<String> groups = (List<String>) actual.get("groups");
			MatcherAssert.assertThat(groups, contains(
					"FACILITY_USER"
			));

			// % protected region % [Add any additional content assertions for loginWithFacilityUserEntity_shouldSucceedWith200 here] off begin
			// % protected region % [Add any additional content assertions for loginWithFacilityUserEntity_shouldSucceedWith200 here] end
		});

		// % protected region % [Add any additional assertions for loginWithFacilityUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional assertions for loginWithFacilityUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	public void loginWithFacilityUserEntityButWrongEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithFacilityUserEntityButWrongEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithFacilityUserEntityButWrongEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "facilityUser-random@example.com");
		body.put("password", "password");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithFacilityUserEntityButWrongEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithFacilityUserEntityButWrongEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithFacilityUserEntityButWrongEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithFacilityUserEntityButWrongEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithFacilityUserEntityButWrongPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithFacilityUserEntityButWrongPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithFacilityUserEntityButWrongPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "facilityUser@example.com");
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithFacilityUserEntityButWrongPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithFacilityUserEntityButWrongPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithFacilityUserEntityButWrongPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithFacilityUserEntityButWrongPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithFacilityUserEntityWithNoEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithFacilityUserEntityWithNoEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithFacilityUserEntityWithNoEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithFacilityUserEntityWithNoEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithFacilityUserEntityWithNoEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithFacilityUserEntityWithNoEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithFacilityUserEntityWithNoEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithFacilityUserEntityWithNoPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithFacilityUserEntityWithNoPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithFacilityUserEntityWithNoPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "facilityUser@example.com");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithFacilityUserEntityWithNoPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithFacilityUserEntityWithNoPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithFacilityUserEntityWithNoPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithFacilityUserEntityWithNoPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithFacilityUserEntityWithNoEmailPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithFacilityUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithFacilityUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithFacilityUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithFacilityUserEntityWithNoEmailPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithFacilityUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithFacilityUserEntityWithNoEmailPassword_shouldFailWith401 here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void loginWithManagementUserEntity_shouldSucceedWith200() throws Exception {
		// % protected region % [Add any additional logic for loginWithManagementUserEntity_shouldSucceedWith200 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithManagementUserEntity_shouldSucceedWith200 before the main body here] end

		LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", "managementUser@example.com");
		body.add("password", "password");

		ResultActions result = mvc.perform(
				post("/auth/login")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.params(body)
		);

		// Test the outer response first.
		result.andExpect(status().isOk());
		result.andExpect(cookie().exists(XSRF_TOKEN_COOKIE_NAME));

		// Test the actual JSON content.
		result.andDo(rs -> {
			Map<String, Object> actual = mapper.readValue(rs.getResponse().getContentAsString(), new TypeReference<>() {});

			Assertions.assertNotNull(actual.get("id"));
			Assertions.assertEquals("managementUser@example.com", actual.get("username"));

			List<String> groups = (List<String>) actual.get("groups");
			MatcherAssert.assertThat(groups, contains(
					"MANAGEMENT_USER"
			));

			// % protected region % [Add any additional content assertions for loginWithManagementUserEntity_shouldSucceedWith200 here] off begin
			// % protected region % [Add any additional content assertions for loginWithManagementUserEntity_shouldSucceedWith200 here] end
		});

		// % protected region % [Add any additional assertions for loginWithManagementUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional assertions for loginWithManagementUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	public void loginWithManagementUserEntityButWrongEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithManagementUserEntityButWrongEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithManagementUserEntityButWrongEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "managementUser-random@example.com");
		body.put("password", "password");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithManagementUserEntityButWrongEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithManagementUserEntityButWrongEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithManagementUserEntityButWrongEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithManagementUserEntityButWrongEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithManagementUserEntityButWrongPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithManagementUserEntityButWrongPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithManagementUserEntityButWrongPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "managementUser@example.com");
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithManagementUserEntityButWrongPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithManagementUserEntityButWrongPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithManagementUserEntityButWrongPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithManagementUserEntityButWrongPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithManagementUserEntityWithNoEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithManagementUserEntityWithNoEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithManagementUserEntityWithNoEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithManagementUserEntityWithNoEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithManagementUserEntityWithNoEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithManagementUserEntityWithNoEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithManagementUserEntityWithNoEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithManagementUserEntityWithNoPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithManagementUserEntityWithNoPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithManagementUserEntityWithNoPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "managementUser@example.com");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithManagementUserEntityWithNoPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithManagementUserEntityWithNoPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithManagementUserEntityWithNoPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithManagementUserEntityWithNoPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithManagementUserEntityWithNoEmailPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithManagementUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithManagementUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithManagementUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithManagementUserEntityWithNoEmailPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithManagementUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithManagementUserEntityWithNoEmailPassword_shouldFailWith401 here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void loginWithMedicalRecordUserEntity_shouldSucceedWith200() throws Exception {
		// % protected region % [Add any additional logic for loginWithMedicalRecordUserEntity_shouldSucceedWith200 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithMedicalRecordUserEntity_shouldSucceedWith200 before the main body here] end

		LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", "medicalRecordUser@example.com");
		body.add("password", "password");

		ResultActions result = mvc.perform(
				post("/auth/login")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.params(body)
		);

		// Test the outer response first.
		result.andExpect(status().isOk());
		result.andExpect(cookie().exists(XSRF_TOKEN_COOKIE_NAME));

		// Test the actual JSON content.
		result.andDo(rs -> {
			Map<String, Object> actual = mapper.readValue(rs.getResponse().getContentAsString(), new TypeReference<>() {});

			Assertions.assertNotNull(actual.get("id"));
			Assertions.assertEquals("medicalRecordUser@example.com", actual.get("username"));

			List<String> groups = (List<String>) actual.get("groups");
			MatcherAssert.assertThat(groups, contains(
					"MEDICAL_RECORD_USER"
			));

			// % protected region % [Add any additional content assertions for loginWithMedicalRecordUserEntity_shouldSucceedWith200 here] off begin
			// % protected region % [Add any additional content assertions for loginWithMedicalRecordUserEntity_shouldSucceedWith200 here] end
		});

		// % protected region % [Add any additional assertions for loginWithMedicalRecordUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional assertions for loginWithMedicalRecordUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	public void loginWithMedicalRecordUserEntityButWrongEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithMedicalRecordUserEntityButWrongEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithMedicalRecordUserEntityButWrongEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "medicalRecordUser-random@example.com");
		body.put("password", "password");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithMedicalRecordUserEntityButWrongEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithMedicalRecordUserEntityButWrongEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithMedicalRecordUserEntityButWrongEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithMedicalRecordUserEntityButWrongEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithMedicalRecordUserEntityButWrongPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithMedicalRecordUserEntityButWrongPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithMedicalRecordUserEntityButWrongPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "medicalRecordUser@example.com");
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithMedicalRecordUserEntityButWrongPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithMedicalRecordUserEntityButWrongPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithMedicalRecordUserEntityButWrongPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithMedicalRecordUserEntityButWrongPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithMedicalRecordUserEntityWithNoEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithMedicalRecordUserEntityWithNoEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithMedicalRecordUserEntityWithNoEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithMedicalRecordUserEntityWithNoEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithMedicalRecordUserEntityWithNoEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithMedicalRecordUserEntityWithNoEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithMedicalRecordUserEntityWithNoEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithMedicalRecordUserEntityWithNoPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithMedicalRecordUserEntityWithNoPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithMedicalRecordUserEntityWithNoPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "medicalRecordUser@example.com");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithMedicalRecordUserEntityWithNoPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithMedicalRecordUserEntityWithNoPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithMedicalRecordUserEntityWithNoPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithMedicalRecordUserEntityWithNoPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithMedicalRecordUserEntityWithNoEmailPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithMedicalRecordUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithMedicalRecordUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithMedicalRecordUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithMedicalRecordUserEntityWithNoEmailPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithMedicalRecordUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithMedicalRecordUserEntityWithNoEmailPassword_shouldFailWith401 here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void loginWithMedicalTranscriberUserEntity_shouldSucceedWith200() throws Exception {
		// % protected region % [Add any additional logic for loginWithMedicalTranscriberUserEntity_shouldSucceedWith200 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithMedicalTranscriberUserEntity_shouldSucceedWith200 before the main body here] end

		LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", "medicalTranscriberUser@example.com");
		body.add("password", "password");

		ResultActions result = mvc.perform(
				post("/auth/login")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.params(body)
		);

		// Test the outer response first.
		result.andExpect(status().isOk());
		result.andExpect(cookie().exists(XSRF_TOKEN_COOKIE_NAME));

		// Test the actual JSON content.
		result.andDo(rs -> {
			Map<String, Object> actual = mapper.readValue(rs.getResponse().getContentAsString(), new TypeReference<>() {});

			Assertions.assertNotNull(actual.get("id"));
			Assertions.assertEquals("medicalTranscriberUser@example.com", actual.get("username"));

			List<String> groups = (List<String>) actual.get("groups");
			MatcherAssert.assertThat(groups, contains(
					"MEDICAL_TRANSCRIBER_USER"
			));

			// % protected region % [Add any additional content assertions for loginWithMedicalTranscriberUserEntity_shouldSucceedWith200 here] off begin
			// % protected region % [Add any additional content assertions for loginWithMedicalTranscriberUserEntity_shouldSucceedWith200 here] end
		});

		// % protected region % [Add any additional assertions for loginWithMedicalTranscriberUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional assertions for loginWithMedicalTranscriberUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	public void loginWithMedicalTranscriberUserEntityButWrongEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithMedicalTranscriberUserEntityButWrongEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithMedicalTranscriberUserEntityButWrongEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "medicalTranscriberUser-random@example.com");
		body.put("password", "password");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithMedicalTranscriberUserEntityButWrongEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithMedicalTranscriberUserEntityButWrongEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithMedicalTranscriberUserEntityButWrongEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithMedicalTranscriberUserEntityButWrongEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithMedicalTranscriberUserEntityButWrongPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithMedicalTranscriberUserEntityButWrongPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithMedicalTranscriberUserEntityButWrongPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "medicalTranscriberUser@example.com");
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithMedicalTranscriberUserEntityButWrongPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithMedicalTranscriberUserEntityButWrongPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithMedicalTranscriberUserEntityButWrongPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithMedicalTranscriberUserEntityButWrongPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithMedicalTranscriberUserEntityWithNoEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithMedicalTranscriberUserEntityWithNoEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithMedicalTranscriberUserEntityWithNoEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithMedicalTranscriberUserEntityWithNoEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithMedicalTranscriberUserEntityWithNoEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithMedicalTranscriberUserEntityWithNoEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithMedicalTranscriberUserEntityWithNoEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithMedicalTranscriberUserEntityWithNoPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithMedicalTranscriberUserEntityWithNoPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithMedicalTranscriberUserEntityWithNoPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "medicalTranscriberUser@example.com");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithMedicalTranscriberUserEntityWithNoPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithMedicalTranscriberUserEntityWithNoPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithMedicalTranscriberUserEntityWithNoPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithMedicalTranscriberUserEntityWithNoPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithMedicalTranscriberUserEntityWithNoEmailPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithMedicalTranscriberUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithMedicalTranscriberUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithMedicalTranscriberUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithMedicalTranscriberUserEntityWithNoEmailPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithMedicalTranscriberUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithMedicalTranscriberUserEntityWithNoEmailPassword_shouldFailWith401 here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void loginWithNurseUserEntity_shouldSucceedWith200() throws Exception {
		// % protected region % [Add any additional logic for loginWithNurseUserEntity_shouldSucceedWith200 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithNurseUserEntity_shouldSucceedWith200 before the main body here] end

		LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", "nurseUser@example.com");
		body.add("password", "password");

		ResultActions result = mvc.perform(
				post("/auth/login")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.params(body)
		);

		// Test the outer response first.
		result.andExpect(status().isOk());
		result.andExpect(cookie().exists(XSRF_TOKEN_COOKIE_NAME));

		// Test the actual JSON content.
		result.andDo(rs -> {
			Map<String, Object> actual = mapper.readValue(rs.getResponse().getContentAsString(), new TypeReference<>() {});

			Assertions.assertNotNull(actual.get("id"));
			Assertions.assertEquals("nurseUser@example.com", actual.get("username"));

			List<String> groups = (List<String>) actual.get("groups");
			MatcherAssert.assertThat(groups, contains(
					"NURSE_USER"
			));

			// % protected region % [Add any additional content assertions for loginWithNurseUserEntity_shouldSucceedWith200 here] off begin
			// % protected region % [Add any additional content assertions for loginWithNurseUserEntity_shouldSucceedWith200 here] end
		});

		// % protected region % [Add any additional assertions for loginWithNurseUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional assertions for loginWithNurseUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	public void loginWithNurseUserEntityButWrongEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithNurseUserEntityButWrongEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithNurseUserEntityButWrongEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "nurseUser-random@example.com");
		body.put("password", "password");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithNurseUserEntityButWrongEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithNurseUserEntityButWrongEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithNurseUserEntityButWrongEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithNurseUserEntityButWrongEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithNurseUserEntityButWrongPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithNurseUserEntityButWrongPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithNurseUserEntityButWrongPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "nurseUser@example.com");
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithNurseUserEntityButWrongPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithNurseUserEntityButWrongPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithNurseUserEntityButWrongPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithNurseUserEntityButWrongPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithNurseUserEntityWithNoEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithNurseUserEntityWithNoEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithNurseUserEntityWithNoEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithNurseUserEntityWithNoEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithNurseUserEntityWithNoEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithNurseUserEntityWithNoEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithNurseUserEntityWithNoEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithNurseUserEntityWithNoPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithNurseUserEntityWithNoPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithNurseUserEntityWithNoPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "nurseUser@example.com");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithNurseUserEntityWithNoPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithNurseUserEntityWithNoPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithNurseUserEntityWithNoPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithNurseUserEntityWithNoPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithNurseUserEntityWithNoEmailPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithNurseUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithNurseUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithNurseUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithNurseUserEntityWithNoEmailPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithNurseUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithNurseUserEntityWithNoEmailPassword_shouldFailWith401 here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void loginWithPharmacyUserEntity_shouldSucceedWith200() throws Exception {
		// % protected region % [Add any additional logic for loginWithPharmacyUserEntity_shouldSucceedWith200 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithPharmacyUserEntity_shouldSucceedWith200 before the main body here] end

		LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", "pharmacyUser@example.com");
		body.add("password", "password");

		ResultActions result = mvc.perform(
				post("/auth/login")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.params(body)
		);

		// Test the outer response first.
		result.andExpect(status().isOk());
		result.andExpect(cookie().exists(XSRF_TOKEN_COOKIE_NAME));

		// Test the actual JSON content.
		result.andDo(rs -> {
			Map<String, Object> actual = mapper.readValue(rs.getResponse().getContentAsString(), new TypeReference<>() {});

			Assertions.assertNotNull(actual.get("id"));
			Assertions.assertEquals("pharmacyUser@example.com", actual.get("username"));

			List<String> groups = (List<String>) actual.get("groups");
			MatcherAssert.assertThat(groups, contains(
					"PHARMACY_USER"
			));

			// % protected region % [Add any additional content assertions for loginWithPharmacyUserEntity_shouldSucceedWith200 here] off begin
			// % protected region % [Add any additional content assertions for loginWithPharmacyUserEntity_shouldSucceedWith200 here] end
		});

		// % protected region % [Add any additional assertions for loginWithPharmacyUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional assertions for loginWithPharmacyUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	public void loginWithPharmacyUserEntityButWrongEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithPharmacyUserEntityButWrongEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithPharmacyUserEntityButWrongEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "pharmacyUser-random@example.com");
		body.put("password", "password");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithPharmacyUserEntityButWrongEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithPharmacyUserEntityButWrongEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithPharmacyUserEntityButWrongEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithPharmacyUserEntityButWrongEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithPharmacyUserEntityButWrongPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithPharmacyUserEntityButWrongPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithPharmacyUserEntityButWrongPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "pharmacyUser@example.com");
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithPharmacyUserEntityButWrongPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithPharmacyUserEntityButWrongPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithPharmacyUserEntityButWrongPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithPharmacyUserEntityButWrongPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithPharmacyUserEntityWithNoEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithPharmacyUserEntityWithNoEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithPharmacyUserEntityWithNoEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithPharmacyUserEntityWithNoEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithPharmacyUserEntityWithNoEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithPharmacyUserEntityWithNoEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithPharmacyUserEntityWithNoEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithPharmacyUserEntityWithNoPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithPharmacyUserEntityWithNoPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithPharmacyUserEntityWithNoPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "pharmacyUser@example.com");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithPharmacyUserEntityWithNoPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithPharmacyUserEntityWithNoPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithPharmacyUserEntityWithNoPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithPharmacyUserEntityWithNoPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithPharmacyUserEntityWithNoEmailPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithPharmacyUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithPharmacyUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithPharmacyUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithPharmacyUserEntityWithNoEmailPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithPharmacyUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithPharmacyUserEntityWithNoEmailPassword_shouldFailWith401 here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void loginWithPurchasingUserEntity_shouldSucceedWith200() throws Exception {
		// % protected region % [Add any additional logic for loginWithPurchasingUserEntity_shouldSucceedWith200 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithPurchasingUserEntity_shouldSucceedWith200 before the main body here] end

		LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", "purchasingUser@example.com");
		body.add("password", "password");

		ResultActions result = mvc.perform(
				post("/auth/login")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.params(body)
		);

		// Test the outer response first.
		result.andExpect(status().isOk());
		result.andExpect(cookie().exists(XSRF_TOKEN_COOKIE_NAME));

		// Test the actual JSON content.
		result.andDo(rs -> {
			Map<String, Object> actual = mapper.readValue(rs.getResponse().getContentAsString(), new TypeReference<>() {});

			Assertions.assertNotNull(actual.get("id"));
			Assertions.assertEquals("purchasingUser@example.com", actual.get("username"));

			List<String> groups = (List<String>) actual.get("groups");
			MatcherAssert.assertThat(groups, contains(
					"PURCHASING_USER"
			));

			// % protected region % [Add any additional content assertions for loginWithPurchasingUserEntity_shouldSucceedWith200 here] off begin
			// % protected region % [Add any additional content assertions for loginWithPurchasingUserEntity_shouldSucceedWith200 here] end
		});

		// % protected region % [Add any additional assertions for loginWithPurchasingUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional assertions for loginWithPurchasingUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	public void loginWithPurchasingUserEntityButWrongEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithPurchasingUserEntityButWrongEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithPurchasingUserEntityButWrongEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "purchasingUser-random@example.com");
		body.put("password", "password");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithPurchasingUserEntityButWrongEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithPurchasingUserEntityButWrongEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithPurchasingUserEntityButWrongEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithPurchasingUserEntityButWrongEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithPurchasingUserEntityButWrongPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithPurchasingUserEntityButWrongPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithPurchasingUserEntityButWrongPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "purchasingUser@example.com");
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithPurchasingUserEntityButWrongPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithPurchasingUserEntityButWrongPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithPurchasingUserEntityButWrongPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithPurchasingUserEntityButWrongPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithPurchasingUserEntityWithNoEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithPurchasingUserEntityWithNoEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithPurchasingUserEntityWithNoEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithPurchasingUserEntityWithNoEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithPurchasingUserEntityWithNoEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithPurchasingUserEntityWithNoEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithPurchasingUserEntityWithNoEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithPurchasingUserEntityWithNoPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithPurchasingUserEntityWithNoPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithPurchasingUserEntityWithNoPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "purchasingUser@example.com");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithPurchasingUserEntityWithNoPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithPurchasingUserEntityWithNoPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithPurchasingUserEntityWithNoPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithPurchasingUserEntityWithNoPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithPurchasingUserEntityWithNoEmailPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithPurchasingUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithPurchasingUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithPurchasingUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithPurchasingUserEntityWithNoEmailPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithPurchasingUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithPurchasingUserEntityWithNoEmailPassword_shouldFailWith401 here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void loginWithRegistrationUserEntity_shouldSucceedWith200() throws Exception {
		// % protected region % [Add any additional logic for loginWithRegistrationUserEntity_shouldSucceedWith200 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithRegistrationUserEntity_shouldSucceedWith200 before the main body here] end

		LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", "registrationUser@example.com");
		body.add("password", "password");

		ResultActions result = mvc.perform(
				post("/auth/login")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.params(body)
		);

		// Test the outer response first.
		result.andExpect(status().isOk());
		result.andExpect(cookie().exists(XSRF_TOKEN_COOKIE_NAME));

		// Test the actual JSON content.
		result.andDo(rs -> {
			Map<String, Object> actual = mapper.readValue(rs.getResponse().getContentAsString(), new TypeReference<>() {});

			Assertions.assertNotNull(actual.get("id"));
			Assertions.assertEquals("registrationUser@example.com", actual.get("username"));

			List<String> groups = (List<String>) actual.get("groups");
			MatcherAssert.assertThat(groups, contains(
					"REGISTRATION_USER"
			));

			// % protected region % [Add any additional content assertions for loginWithRegistrationUserEntity_shouldSucceedWith200 here] off begin
			// % protected region % [Add any additional content assertions for loginWithRegistrationUserEntity_shouldSucceedWith200 here] end
		});

		// % protected region % [Add any additional assertions for loginWithRegistrationUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional assertions for loginWithRegistrationUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	public void loginWithRegistrationUserEntityButWrongEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithRegistrationUserEntityButWrongEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithRegistrationUserEntityButWrongEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "registrationUser-random@example.com");
		body.put("password", "password");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithRegistrationUserEntityButWrongEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithRegistrationUserEntityButWrongEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithRegistrationUserEntityButWrongEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithRegistrationUserEntityButWrongEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithRegistrationUserEntityButWrongPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithRegistrationUserEntityButWrongPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithRegistrationUserEntityButWrongPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "registrationUser@example.com");
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithRegistrationUserEntityButWrongPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithRegistrationUserEntityButWrongPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithRegistrationUserEntityButWrongPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithRegistrationUserEntityButWrongPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithRegistrationUserEntityWithNoEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithRegistrationUserEntityWithNoEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithRegistrationUserEntityWithNoEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithRegistrationUserEntityWithNoEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithRegistrationUserEntityWithNoEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithRegistrationUserEntityWithNoEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithRegistrationUserEntityWithNoEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithRegistrationUserEntityWithNoPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithRegistrationUserEntityWithNoPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithRegistrationUserEntityWithNoPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "registrationUser@example.com");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithRegistrationUserEntityWithNoPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithRegistrationUserEntityWithNoPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithRegistrationUserEntityWithNoPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithRegistrationUserEntityWithNoPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithRegistrationUserEntityWithNoEmailPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithRegistrationUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithRegistrationUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithRegistrationUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithRegistrationUserEntityWithNoEmailPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithRegistrationUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithRegistrationUserEntityWithNoEmailPassword_shouldFailWith401 here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void loginWithSystemAdminUserEntity_shouldSucceedWith200() throws Exception {
		// % protected region % [Add any additional logic for loginWithSystemAdminUserEntity_shouldSucceedWith200 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithSystemAdminUserEntity_shouldSucceedWith200 before the main body here] end

		LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", "systemAdminUser@example.com");
		body.add("password", "password");

		ResultActions result = mvc.perform(
				post("/auth/login")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.params(body)
		);

		// Test the outer response first.
		result.andExpect(status().isOk());
		result.andExpect(cookie().exists(XSRF_TOKEN_COOKIE_NAME));

		// Test the actual JSON content.
		result.andDo(rs -> {
			Map<String, Object> actual = mapper.readValue(rs.getResponse().getContentAsString(), new TypeReference<>() {});

			Assertions.assertNotNull(actual.get("id"));
			Assertions.assertEquals("systemAdminUser@example.com", actual.get("username"));

			List<String> groups = (List<String>) actual.get("groups");
			MatcherAssert.assertThat(groups, contains(
					"SYSTEM_ADMIN_USER"
			));

			// % protected region % [Add any additional content assertions for loginWithSystemAdminUserEntity_shouldSucceedWith200 here] off begin
			// % protected region % [Add any additional content assertions for loginWithSystemAdminUserEntity_shouldSucceedWith200 here] end
		});

		// % protected region % [Add any additional assertions for loginWithSystemAdminUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional assertions for loginWithSystemAdminUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	public void loginWithSystemAdminUserEntityButWrongEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithSystemAdminUserEntityButWrongEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithSystemAdminUserEntityButWrongEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "systemAdminUser-random@example.com");
		body.put("password", "password");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithSystemAdminUserEntityButWrongEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithSystemAdminUserEntityButWrongEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithSystemAdminUserEntityButWrongEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithSystemAdminUserEntityButWrongEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithSystemAdminUserEntityButWrongPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithSystemAdminUserEntityButWrongPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithSystemAdminUserEntityButWrongPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "systemAdminUser@example.com");
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithSystemAdminUserEntityButWrongPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithSystemAdminUserEntityButWrongPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithSystemAdminUserEntityButWrongPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithSystemAdminUserEntityButWrongPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithSystemAdminUserEntityWithNoEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithSystemAdminUserEntityWithNoEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithSystemAdminUserEntityWithNoEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithSystemAdminUserEntityWithNoEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithSystemAdminUserEntityWithNoEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithSystemAdminUserEntityWithNoEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithSystemAdminUserEntityWithNoEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithSystemAdminUserEntityWithNoPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithSystemAdminUserEntityWithNoPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithSystemAdminUserEntityWithNoPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "systemAdminUser@example.com");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithSystemAdminUserEntityWithNoPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithSystemAdminUserEntityWithNoPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithSystemAdminUserEntityWithNoPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithSystemAdminUserEntityWithNoPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithSystemAdminUserEntityWithNoEmailPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithSystemAdminUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithSystemAdminUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithSystemAdminUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithSystemAdminUserEntityWithNoEmailPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithSystemAdminUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithSystemAdminUserEntityWithNoEmailPassword_shouldFailWith401 here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void loginWithWarehouseUserEntity_shouldSucceedWith200() throws Exception {
		// % protected region % [Add any additional logic for loginWithWarehouseUserEntity_shouldSucceedWith200 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithWarehouseUserEntity_shouldSucceedWith200 before the main body here] end

		LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", "warehouseUser@example.com");
		body.add("password", "password");

		ResultActions result = mvc.perform(
				post("/auth/login")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.params(body)
		);

		// Test the outer response first.
		result.andExpect(status().isOk());
		result.andExpect(cookie().exists(XSRF_TOKEN_COOKIE_NAME));

		// Test the actual JSON content.
		result.andDo(rs -> {
			Map<String, Object> actual = mapper.readValue(rs.getResponse().getContentAsString(), new TypeReference<>() {});

			Assertions.assertNotNull(actual.get("id"));
			Assertions.assertEquals("warehouseUser@example.com", actual.get("username"));

			List<String> groups = (List<String>) actual.get("groups");
			MatcherAssert.assertThat(groups, contains(
					"WAREHOUSE_USER"
			));

			// % protected region % [Add any additional content assertions for loginWithWarehouseUserEntity_shouldSucceedWith200 here] off begin
			// % protected region % [Add any additional content assertions for loginWithWarehouseUserEntity_shouldSucceedWith200 here] end
		});

		// % protected region % [Add any additional assertions for loginWithWarehouseUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional assertions for loginWithWarehouseUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	public void loginWithWarehouseUserEntityButWrongEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithWarehouseUserEntityButWrongEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithWarehouseUserEntityButWrongEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "warehouseUser-random@example.com");
		body.put("password", "password");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithWarehouseUserEntityButWrongEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithWarehouseUserEntityButWrongEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithWarehouseUserEntityButWrongEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithWarehouseUserEntityButWrongEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithWarehouseUserEntityButWrongPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithWarehouseUserEntityButWrongPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithWarehouseUserEntityButWrongPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "warehouseUser@example.com");
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithWarehouseUserEntityButWrongPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithWarehouseUserEntityButWrongPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithWarehouseUserEntityButWrongPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithWarehouseUserEntityButWrongPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithWarehouseUserEntityWithNoEmail_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithWarehouseUserEntityWithNoEmail_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithWarehouseUserEntityWithNoEmail_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("password", "password-random");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithWarehouseUserEntityWithNoEmail_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithWarehouseUserEntityWithNoEmail_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithWarehouseUserEntityWithNoEmail_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithWarehouseUserEntityWithNoEmail_shouldFailWith401 here] end
	}

	@Test
	public void loginWithWarehouseUserEntityWithNoPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithWarehouseUserEntityWithNoPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithWarehouseUserEntityWithNoPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();
		body.put("username", "warehouseUser@example.com");

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithWarehouseUserEntityWithNoPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithWarehouseUserEntityWithNoPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithWarehouseUserEntityWithNoPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithWarehouseUserEntityWithNoPassword_shouldFailWith401 here] end
	}

	@Test
	public void loginWithWarehouseUserEntityWithNoEmailPassword_shouldFailWith401() throws Exception {
		// % protected region % [Add any additional logic for loginWithWarehouseUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] off begin
		// % protected region % [Add any additional logic for loginWithWarehouseUserEntityWithNoEmailPassword_shouldFailWith401 before the main body here] end

		Map<String, Object> body = new HashMap<>();

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, "/auth/login", body);

		// Test the outer response first.
		result.andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));

		// Test the actual JSON content.
		result.andDo(rs -> {
			RequestUtil.checkErrorResponse(result, "invalid_grant", "The username/password combination is invalid.", HttpStatus.UNAUTHORIZED);

			// % protected region % [Add any additional content assertions for loginWithWarehouseUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
			// % protected region % [Add any additional content assertions for loginWithWarehouseUserEntityWithNoEmailPassword_shouldFailWith401 here] end
		});

		// % protected region % [Add any additional assertions for loginWithWarehouseUserEntityWithNoEmailPassword_shouldFailWith401 here] off begin
		// % protected region % [Add any additional assertions for loginWithWarehouseUserEntityWithNoEmailPassword_shouldFailWith401 here] end
	}


	// % protected region % [Add any additional test cases here] off begin
	// % protected region % [Add any additional test cases here] end
}