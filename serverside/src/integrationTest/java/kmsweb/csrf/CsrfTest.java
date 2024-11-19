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

package kmsweb.csrf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import kmsweb.SpringTestConfiguration;

import java.util.UUID;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static kmsweb.configs.security.repositories.XsrfTokenRepository.XSRF_TOKEN_COOKIE_NAME;
import static kmsweb.configs.security.repositories.XsrfTokenRepository.XSRF_TOKEN_HEADER_NAME;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringTestConfiguration.class)
@ActiveProfiles("test")
public class CsrfTest {

	private static final String AUTH_TOKEN_COOKIE_NAME = "AUTH-TOKEN";

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	// % protected region % [Add any additional class attributes here] off begin
	// % protected region % [Add any additional class attributes here] end

	@BeforeEach
	public void setup() {
		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}

	@Test
	@SuppressWarnings("unchecked")
	public void checkValidDoubleSubmitCookie() throws Exception {
		// % protected region % [Override checkValidDoubleSubmitCookie here] off begin
		var loginResult = login();
		loginResult.andDo(rs -> {
			var csrfCookie = rs.getResponse().getCookie(XSRF_TOKEN_COOKIE_NAME);
			Assertions.assertNotNull(csrfCookie, "CSRF cookie is not null");

			ResultActions logoutResult = mvc.perform(
					post("/auth/logout")
							.cookie(rs.getResponse().getCookies())
							.header(XSRF_TOKEN_HEADER_NAME, csrfCookie.getValue())
			);
			logoutResult.andExpect(status().isOk());
		});
		// % protected region % [Override checkValidDoubleSubmitCookie here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void checkInvalidDoubleSubmitCookie() throws Exception {
		// % protected region % [Override checkInvalidDoubleSubmitCookie here] off begin
		var loginResult = login();
		loginResult.andDo(rs -> {
			var csrfCookie = rs.getResponse().getCookie(XSRF_TOKEN_COOKIE_NAME);
			Assertions.assertNotNull(csrfCookie, "CSRF cookie is not null");

			ResultActions logoutResult = mvc.perform(
					post("/auth/logout")
							.cookie(rs.getResponse().getCookies())
							.header(XSRF_TOKEN_HEADER_NAME, UUID.randomUUID())
			);
			logoutResult.andExpect(status().isForbidden());
		});
		// % protected region % [Override checkInvalidDoubleSubmitCookie here] end
	}

	@Test
	@SuppressWarnings("unchecked")
	public void missingCsrfHeader() throws Exception {
		// % protected region % [Override missingCsrfHeader here] off begin
		var loginResult = login();
		loginResult.andDo(rs -> {
			ResultActions logoutResult = mvc.perform(
					post("/auth/logout").cookie(rs.getResponse().getCookies()));
			logoutResult.andExpect(status().isForbidden());
		});
		// % protected region % [Override missingCsrfHeader here] end
	}

	// % protected region % [Add any additional test cases here] off begin
	// % protected region % [Add any additional test cases here] end

	/**
	 * Login to the site with valid credentials
	 *
	 * @return result of login as a ResultAction
	 * @throws Exception
	 */
	private ResultActions login() throws Exception {
		// % protected region % [Override login here] off begin
		var body = new LinkedMultiValueMap<String, String>();
		body.add("username", "super@example.com");
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
		result.andExpect(cookie().exists(AUTH_TOKEN_COOKIE_NAME));

		return result;
		// % protected region % [Override login here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end

}
