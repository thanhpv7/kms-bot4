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
package kmsweb.configs.security.filters;

import kmsweb.configs.security.helpers.AnonymousHelper;
import kmsweb.configs.security.services.UserService;
import kmsweb.entities.UserEntity;
import kmsweb.configs.security.exceptions.*;
import kmsweb.dtos.ErrorDto;
import kmsweb.dtos.ErrorResponseDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.*;
import org.springframework.security.web.authentication.*;
import org.springframework.security.web.server.authentication.ServerFormLoginAuthenticationConverter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Keymap;
import java.io.*;
import java.util.*;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Filter to reset password. The filter would update password then login user
 */
public class ResetPasswordFilter extends AbstractAuthenticationProcessingFilter {

	private final UserService userService;

	private final AuthenticationSuccessHandler authenticationSuccessHandler;

	private final PasswordEncoder passwordEncoder;

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end

	public ResetPasswordFilter(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			String resetPasswordEndpoint,
			UserService userService,
			AuthenticationSuccessHandler authenticationSuccessHandler,
			PasswordEncoder passwordEncoder,
			AuthenticationManager authenticationManager
	) {
		super(new AntPathRequestMatcher(resetPasswordEndpoint));
		this.userService = userService;
		this.authenticationSuccessHandler = authenticationSuccessHandler;
		this.passwordEncoder = passwordEncoder;
		this.setAuthenticationManager(authenticationManager);

		// % protected region % [Add any additional logic in constructor here] off begin
		// % protected region % [Add any additional logic in constructor here] end
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public Authentication attemptAuthentication(
			HttpServletRequest request,
			HttpServletResponse response
	) throws AuthenticationException, IOException {
		// % protected region % [Add any additional logic before main logic attemptAuthentication here] off begin
		// % protected region % [Add any additional logic before main logic attemptAuthentication here] end

		BufferedReader reader = request.getReader();
		ObjectMapper objectMapper = new ObjectMapper();

		Map resetPasswordRequest = objectMapper.readValue(reader, Map.class);

		String token = (String) resetPasswordRequest.get("token");
		String username = (String)resetPasswordRequest.get("username");
		String password = (String) resetPasswordRequest.get("password");

		if (token == null) {
			throw new MissingArgumentsException("Token is missing from the request.");
		} else if (username == null) {
			throw new MissingArgumentsException("Username is missing from the request.");
		} else if (password == null) {
			throw new MissingArgumentsException("Password is missing from the request.");
		}

		// % protected region % [Add any additional logic before runAnonymouslyAndReturnValue  here] off begin
		// % protected region % [Add any additional logic before runAnonymouslyAndReturnValue  here] end

		return AnonymousHelper.runAnonymouslyAndReturnValue(() -> {
			// % protected region % [Add any additional logic before update password here] off begin
			// % protected region % [Add any additional logic before update password here] end

			UserEntity userEntity = userService.resetPassword(token, username, passwordEncoder.encode(password));

			// % protected region % [Add any additional logic after update password here] off begin
			// % protected region % [Add any additional logic after update password here] end

			Authentication authentication = getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
					userEntity.getEmail(),
					password
			));

			// % protected region % [Add any additional logic before return authentication here] off begin
			// % protected region % [Add any additional logic before return authentication here] end

			return authentication;
		});
	}

	/**
	 * @inheritDoc
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
		// % protected region % [Add any additional logic before main logic successfulAuthentication here] off begin
		// % protected region % [Add any additional logic before main logic successfulAuthentication here] end

		this.authenticationSuccessHandler.onAuthenticationSuccess(request, response, authResult);

		// % protected region % [Add any additional for successfulAuthentication here] off begin
		// % protected region % [Add any additional for successfulAuthentication here] end
	}

	/**
	 * @inheritDoc
	 */
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
		// % protected region % [Add any additional logic before main logic unsuccessfulAuthentication here] off begin
		// % protected region % [Add any additional logic before main logic unsuccessfulAuthentication here] end

		ObjectMapper mapper = new ObjectMapper();
		var error = new ErrorDto();

		if (failed instanceof TokenExpiredException) {
			response.setStatus(401);
			error.setError("token_invalid");
			error.setMessage("Token has expired. Please reset your password again.");
		} else if (failed instanceof TokenNotMatchException) {
			response.setStatus(401);
			error.setError("token_invalid");
			error.setMessage("Reset password tokens do not match");
		} else if (failed instanceof MissingArgumentsException) {
			response.setStatus(400);
			error.setError("missing_arguments");
			error.setMessage(failed.getMessage());
		}

		var errorResponse = new ErrorResponseDto();
		errorResponse.setErrors(Collections.singletonList(error));
		errorResponse.setDescription("Reset Password Failed");
		response.setContentType("application/json");

		// % protected region % [Add any additional logic before writing to response body here] off begin
		// % protected region % [Add any additional logic before writing to response body here] end

		response.getWriter().write(mapper.writeValueAsString(errorResponse));

		// % protected region % [Add any additional logic for unsuccessfulAuthentication here] off begin
		// % protected region % [Add any additional logic for unsuccessfulAuthentication here] end
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}
