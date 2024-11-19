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
package kmsweb.configs.security.services;

import kmsweb.configs.properties.SecurityProperties;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.util.ReflectionTestUtils;
import kmsweb.configs.security.repositories.XsrfTokenRepository;
import javax.servlet.http.Cookie;

import java.util.Objects;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static kmsweb.configs.security.repositories.XsrfTokenRepository.XSRF_TOKEN_COOKIE_NAME;
import static kmsweb.configs.security.services.AuthenticationService.AUTH_TOKEN_COOKIE_NAME;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Tag("authentication")
@Tag("service")
@Tag("security")
public class AuthenticationServiceTest {
	private final String USER_USERNAME = "test@example.com";
	private final String USER_PASSWORD = "password";

	// Service under test
	private AuthenticationService authService;
	private MockEnvironment env;

	// Mock request and response to be used with the service.
	private MockHttpServletResponse response;
	private MockHttpServletRequest request;

	// Various properties
	private SecurityProperties securityProperties;

	private XsrfTokenRepository xsrfTokenRepository;

	@Mock
	private Authentication authentication;

	@Mock
	private UserDetails userDetails;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@BeforeEach
	void setup() {
		// % protected region % [Add any additional logic for setup before the main body here] off begin
		// % protected region % [Add any additional logic for setup before the main body here] end

		MockitoAnnotations.initMocks(this);

		when(userDetails.getUsername()).thenReturn(USER_USERNAME);
		when(userDetails.getPassword()).thenReturn(USER_PASSWORD);
		when(authentication.getPrincipal()).thenReturn(userDetails);

		// % protected region % [Config authentication service properties here] off begin
		securityProperties = new SecurityProperties();
		securityProperties.setJwtTokenExpirationTimeSeconds(400);
		securityProperties.setJwtSecret("ENsozfv7Xdo^TzG8WjhPSe!&r5kfCJB$haQ3raVicFSo94Cr*m&78NY3v5oyENy@bzpZSzNhpSC");
		securityProperties.setAuthTokenAgeSeconds(500);
		// % protected region % [Config authentication service properties here] end

		env = new MockEnvironment();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();

		// % protected region % [Add any additional modification to the environment here here] off begin
		// % protected region % [Add any additional modification to the environment here here] end

		authService = new AuthenticationService(
				// % protected region % [Add any additional authentication service arguments here] off begin
				// % protected region % [Add any additional authentication service arguments here] end
				securityProperties,
				env
		);

		// % protected region % [Add any additional logic for setup after the main body here] off begin
		// % protected region % [Add any additional logic for setup after the main body here] end
	}

	@AfterEach
	void tearDown() {
		// % protected region % [Add any additional logic for tearDown here] off begin
		// % protected region % [Add any additional logic for tearDown here] end
	}

	@Test
	void cookiesMustBeSet() {
		// % protected region % [Add any additional logic for cookiesMustBeSet before the main body here] off begin
		// % protected region % [Add any additional logic for cookiesMustBeSet before the main body here] end

		authService.addAuthentication(response, authentication);
		Cookie authCookie = response.getCookie(AUTH_TOKEN_COOKIE_NAME);

		// % protected region % [Add any additional logic for cookiesMustBeSet before the assertions here] off begin
		// % protected region % [Add any additional logic for cookiesMustBeSet before the assertions here] end

		// Check if auth cookie exists.
		assertNotNull(authCookie);
		assertEquals("/", authCookie.getPath());
		assertEquals(securityProperties.getAuthTokenAgeSeconds(), authCookie.getMaxAge());
		assertTrue(authCookie.isHttpOnly());
		assertTrue(authCookie.getSecure());

		// Check that JWT encoding is correct.
		assertEquals(USER_USERNAME, getUsernameFromJwtToken(authCookie.getValue()));

		// % protected region % [Add any additional logic for cookiesMustBeSet after the main body here] off begin
		// % protected region % [Add any additional logic for cookiesMustBeSet after the main body here] end
	}

	@Test
	void authCookieFromRequest() {
		// % protected region % [Add any additional logic for authCookieFromRequest before the main body here] off begin
		// % protected region % [Add any additional logic for authCookieFromRequest before the main body here] end

		// Ensure that the user has previously logged in and and now makes requests.
		authService.addAuthentication(response, authentication);
		Cookie authCookie = response.getCookie(AUTH_TOKEN_COOKIE_NAME);
		request.setCookies(authCookie);

		// % protected region % [Add any additional logic for authCookieFromRequest before the assertions here] off begin
		// % protected region % [Add any additional logic for authCookieFromRequest before the assertions here] end

		// Check that authentication details were added correctly.
		assertEquals(authentication, authService.getAuthentication(request));

		authService.removeAuthentication(request);

		// Check that authentication is removed properly.
		assertNull(authService.getAuthentication(request));

		// % protected region % [Add any additional logic for authCookieFromRequest after the main body here] off begin
		// % protected region % [Add any additional logic for authCookieFromRequest after the main body here] end
	}

	@Test
	void invalidAuthCookieFromRequest() {
		// % protected region % [Add any additional logic for invalidAuthCookieFromRequest before the main body here] off begin
		// % protected region % [Add any additional logic for invalidAuthCookieFromRequest before the main body here] end

		// Ensure that the user has previously logged in and and now makes requests.
		authService.addAuthentication(response, authentication);
		Cookie authCookie = new Cookie(AUTH_TOKEN_COOKIE_NAME, "random-string");
		request.setCookies(authCookie);

		// % protected region % [Add any additional logic for invalidAuthCookieFromRequest before the assertions here] off begin
		// % protected region % [Add any additional logic for invalidAuthCookieFromRequest before the assertions here] end

		// Check that authentication details were added correctly.
		assertNull(authService.getAuthentication(request));

		// % protected region % [Add any additional logic for invalidAuthCookieFromRequest after the main body here] off begin
		// % protected region % [Add any additional logic for invalidAuthCookieFromRequest after the main body here] end
	}

	@Test
	void tokenFromRequestExpired() {
		// % protected region % [Add any additional logic for tokenFromRequestExpired before main body here] off begin
		// % protected region % [Add any additional logic for tokenFromRequestExpired before main body here] end

		// Expire a token instantly
		securityProperties.setJwtTokenExpirationTimeSeconds(0);
		ReflectionTestUtils.setField(authService, "securityProperties", securityProperties);
		authService.addAuthentication(response, authentication);
		request.setCookies(response.getCookies());

		// % protected region % [Add any additional logic for tokenFromRequestExpired before assertions here] off begin
		// % protected region % [Add any additional logic for tokenFromRequestExpired before assertions here] end

		assertThrows(ExpiredJwtException.class, () -> {
			authService.getAuthentication(request);
		});

		// % protected region % [Add any additional logic for tokenFromRequestExpired after the main body here] off begin
		// % protected region % [Add any additional logic for tokenFromRequestExpired after the main body here] end
	}

	/**
	 * Given a JWT token, decode it and return back the username.
	 *
	 * @param token the JWT token to be decoded
	 * @return the username from the token
	 */
	private String getUsernameFromJwtToken(@NonNull String token) {
		return Jwts.parser()
				.setSigningKey(securityProperties.getJwtSecret())
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
}