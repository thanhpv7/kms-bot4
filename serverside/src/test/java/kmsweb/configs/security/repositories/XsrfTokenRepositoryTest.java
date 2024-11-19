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

package kmsweb.configs.security.repositories;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockCookie;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.util.Assert;
import kmsweb.configs.properties.SecurityProperties;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static kmsweb.configs.security.repositories.XsrfTokenRepository.*;

// % protected region % [Add additional imports here] off begin
// % protected region % [Add additional imports here] end

@Tag("csrf")
@Tag("repository")
@Tag("security")
public class XsrfTokenRepositoryTest {
	public static final int XSRF_TOKEN_EXPIRY = 600;

	// Repository under test
	private XsrfTokenRepository xsrfTokenRepository;

	// Mock request and response to be used with the service.
	private MockHttpServletResponse response;
	private MockHttpServletRequest request;

	// % protected region % [Add additional class attributes here] off begin
	// % protected region % [Add additional class attributes here] end

	@BeforeEach
	void setup() {
		// % protected region % [Override the startup here] off begin
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();

		var securityProperties = new SecurityProperties();
		securityProperties.setCsrfTokenAgeSeconds(XSRF_TOKEN_EXPIRY);

		xsrfTokenRepository = new XsrfTokenRepository(securityProperties);
		// % protected region % [Override the startup here] end
	}

	@Test
	void csrfTokenGenerationHasCorrectHeader() {
		// % protected region % [Override csrfTokenGenerationHasCorrectHeader here] off begin
		var resultCsrf = xsrfTokenRepository.generateToken(request);

		// Now given that the UUID is expected to be random we don't want to try and predict its value
		assertEquals(XSRF_TOKEN_HEADER_NAME, resultCsrf.getHeaderName(), "CSRF header is " + XSRF_TOKEN_HEADER_NAME);
		assertEquals(CSRF_QUERY_PARAM_NAME, resultCsrf.getParameterName(), "CSRF parameter is " + CSRF_QUERY_PARAM_NAME);
		assertDoesNotThrow(() -> UUID.fromString(resultCsrf.getToken()), "CSRF token is valid UUID");
		// % protected region % [Override csrfTokenGenerationHasCorrectHeader here] end
	}

	@Test
	void csrfTokenGenerationShouldBeRandom() {
		// % protected region % [Override csrfTokenGenerationShouldBeRandom here] off begin
		var firstCsrfToken = xsrfTokenRepository.generateToken(request);
		var secondCsrfToken = xsrfTokenRepository.generateToken(request);

		// Now given that the UUID is expected to be random we don't want to try and predict its value
		assertNotEquals(firstCsrfToken.getToken(), secondCsrfToken.getToken(), "Tokens are different");
		// % protected region % [Override csrfTokenGenerationShouldBeRandom here] end
	}

	@Test
	void nullCsrfTokenFailsCookie() {
		// % protected region % [Override nullCsrfTokenFailsCookie here] off begin
		xsrfTokenRepository.saveToken(null, request, response);
		var cookie = response.getCookie(XSRF_TOKEN_COOKIE_NAME);
		assertNotNull(cookie);
		assertEquals("", cookie.getValue(), "Null token results in empty value in cookie");
		// % protected region % [Override nullCsrfTokenFailsCookie here] end
	}

	@Test
	void csrfTokenSetCorrectlyInCookie() {
		// % protected region % [Override csrfTokenSetCorrectlyInCookie here] off begin
		final String tokenValue = "token-value";
		var cookie = getCsrfTokenCookie(tokenValue);
		assertEquals(tokenValue, cookie.getValue(), "Cookie has the token as the value");
		// % protected region % [Override csrfTokenSetCorrectlyInCookie here] end
	}

	@Test
	void csrfTokenCookieIsSecure() {
		// % protected region % [Override csrfTokenCookieIsSecure here] off begin
		// Test framework runs in insecure mode, we want to ensure that cookies are secure when required
		request.setSecure(true);

		var cookie = getCsrfTokenCookie();
		assertTrue(cookie.getSecure(), "Cookie is secure");
		// % protected region % [Override csrfTokenCookieIsSecure here] end
	}

	@Test
	void csrfTokenCookieIsNotHttpOnly() {
		// % protected region % [Override csrfTokenCookieIsNotHttpOnly here] off begin
		var cookie = getCsrfTokenCookie();
		assertFalse(cookie.isHttpOnly());
		// % protected region % [Override csrfTokenCookieIsNotHttpOnly here] end
	}

	@Test
	void csrfTokenCookieHasSameSiteStrict() {
		// % protected region % [Override csrfTokenCookieHasSameSiteStrict here] off begin
		// Given that we user overloading to set the same site attribute, we need to check that the last cookie with the
		// correct name as the attribute set
		getCsrfTokenCookie();
		var cookies = response.getCookies();
		var csrfCookies = new ArrayList<Cookie>();

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(XSRF_TOKEN_COOKIE_NAME)) {
				csrfCookies.add(cookie);
			}
		}

		assertEquals(1, csrfCookies.size(), "Expect that here is exactly one CSRF cookie");
		assertEquals("Strict", ((MockCookie) csrfCookies.get(0)).getSameSite(), "Second cookie has same site set to true");
		// % protected region % [Override csrfTokenCookieHasSameSiteStrict here] end
	}


	@Test
	void loadCsrfTokenFromRequest() {
		// % protected region % [Override loadCsrfTokenFromRequest here] off begin
		final String tokenValue = "token-value";
		var token = setAndLoadToken(tokenValue);
		assertNotNull(token);
		assertEquals(tokenValue, token.getToken(), "The correct token value is extracted from the CSRf token");
		assertEquals(XSRF_TOKEN_HEADER_NAME, token.getHeaderName(), "The token has the correct header");
		assertEquals(CSRF_QUERY_PARAM_NAME, token.getParameterName(), "The token has the correct parameter name");
		// % protected region % [Override loadCsrfTokenFromRequest here] end
	}

	@Test
	void loadNoCookiesFromRequest() {
		// % protected region % [Overide loadNoCookiesFromRequest here] off begin
		var csrfToken = xsrfTokenRepository.loadToken(request);
		assertNull(csrfToken, "The token is null");
		// % protected region % [Overide loadNoCookiesFromRequest here] end
	}

	@Test
	void loadEmptyCookieValueFromRequest() {
		// % protected region % [Override loadEmptyCookieValueFromRequest here] off begin
		var csrfToken = setAndLoadToken("");
		assertNull(csrfToken, "Empty cookie results in null token");
		// % protected region % [Override loadEmptyCookieValueFromRequest here] end
	}

	// % protected region % [Add additional test cases here] off begin
	// % protected region % [Add additional test cases here] end

	/**
	 * Overloaded method, sets a static token value
	 *
	 * @see #setAndLoadToken(String)
	 */
	private CsrfToken setAndLoadToken() {
		return this.setAndLoadToken("token-value");
	}

	/**
	 * Mock the cookie in the request with the value provided
	 *
	 * @param tokenValue The token value to be placed in the cookie
	 * @return The extracted token
	 */
	private CsrfToken setAndLoadToken(String tokenValue) {
		assert tokenValue != null;
		Cookie csrfCookie = new Cookie(XSRF_TOKEN_COOKIE_NAME, tokenValue);
		request.setCookies(csrfCookie);
		return xsrfTokenRepository.loadToken(request);
	}

	/**
	 * Overloaded method, sets a static token value
	 *
	 * @see #getCsrfTokenCookie(String)
	 */
	private Cookie getCsrfTokenCookie() {
		return this.getCsrfTokenCookie("token-value");
	}

	/**
	 * Create and save a token given the token value provided
	 *
	 * @param tokenValue The token value to be set in the CsrfToken saved
	 * @return CSRF cookie with with the token set
	 */
	private Cookie getCsrfTokenCookie(String tokenValue) {
		assert tokenValue != null;
		Assert.hasLength(tokenValue, "tokenValue cannot be null or empty");
		var token = new DefaultCsrfToken(XSRF_TOKEN_COOKIE_NAME, CSRF_QUERY_PARAM_NAME, tokenValue);
		xsrfTokenRepository.saveToken(token, request, response);

		var cookie = response.getCookie(XSRF_TOKEN_COOKIE_NAME);
		assertNotNull(cookie);

		return cookie;
	}

	// % protected region % [Add additional test methods here] off begin
	// % protected region % [Add additional test methods here] end
}
