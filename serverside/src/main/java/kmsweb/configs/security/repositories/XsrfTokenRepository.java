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

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.stereotype.Component;
import kmsweb.configs.properties.SecurityProperties;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end
@Slf4j
@Component
public class XsrfTokenRepository implements CsrfTokenRepository {

	private final SecurityProperties securityProperties;
	public static final String XSRF_TOKEN_HEADER_NAME = "X-XSRF-TOKEN";
	public static final String XSRF_TOKEN_COOKIE_NAME = "XSRF-TOKEN";
	public static final String CSRF_QUERY_PARAM_NAME = "_csrf";

	private final CookieCsrfTokenRepository delegate = new CookieCsrfTokenRepository();

	@Autowired
	public XsrfTokenRepository(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		SecurityProperties securityProperties
	) {
		this.securityProperties = securityProperties;
		delegate.setHeaderName(XSRF_TOKEN_HEADER_NAME);
		delegate.setCookieName(XSRF_TOKEN_COOKIE_NAME);
		delegate.setParameterName(CSRF_QUERY_PARAM_NAME);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public CsrfToken generateToken(HttpServletRequest request) {
		// % protected region % [Override how the CSRF token is created here] off begin
		return delegate.generateToken(request);
		// % protected region % [Override how the CSRF token is created here] end
	}

	/**
	 * Set the CSRF token in a cookie identified by {@link #XSRF_TOKEN_HEADER_NAME}
	 * The CSRF token is sourced from {@link #generateToken(HttpServletRequest)}
	 *
	 * We override the delegate method {@link CookieCsrfTokenRepository#saveToken(CsrfToken, HttpServletRequest, HttpServletResponse)}
	 * so that we can set our expiry time on the cookie itself. This is sourced from
	 * {@link SecurityProperties#getCsrfTokenAgeSeconds }
	 *
	 * @param token The token to store in the cookie
	 * @param request The request that requires the token
	 * @param response The response that we are adding the cookie to
	 */
	@Override
	public void saveToken(@Nullable CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
		// % protected region % [Customise how CSRF tokens are saved here] off begin
		String tokenValue = "";
		if (token != null) {
			tokenValue = (token.getToken() != null) ?  token.getToken() : "";
		}

		var csrfCookie = ResponseCookie.from(XSRF_TOKEN_COOKIE_NAME, tokenValue)
				// Set to false so that we can access the token from the client-side for double submit cookie checking
				// {@see https://docs.spring.io/spring-security/site/docs/5.0.0.RC1/reference/html/csrf.html#csrf-cookie}
				.httpOnly(false)
				.secure(request.isSecure())
				.path("/")
				.maxAge(securityProperties.getAuthTokenAgeSeconds())
				.sameSite("Strict")
				.build();

		response.addHeader(HttpHeaders.SET_COOKIE, csrfCookie.toString());
		// % protected region % [Customise how CSRF tokens are saved here] end
	}

	/**
	 * From the request we expect to have a CSRF token in the header and in the CSRF token cookie so that
	 * we can perform a double submit cookie check
	 * {@see https://cheatsheetseries.owasp.org/cheatsheets/Cross-Site_Request_Forgery_Prevention_Cheat_Sheet.html#double-submit-cookie}
	 * @param request Request that we loading the CSRF token from
	 * @return csrf token if found, null otherwise
	 */
	@Override
	public @Nullable CsrfToken loadToken(HttpServletRequest request) {
		// % protected region % [Customise the loadToken method here] off begin
		return delegate.loadToken(request);
		// % protected region % [Customise the loadToken method here] end
	}
}