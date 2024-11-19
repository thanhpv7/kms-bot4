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
package kmsweb.configs.documentation;

import kmsweb.dtos.UserInfoDto;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

// % protected region % [Add additional imports here] off begin
// % protected region % [Add additional imports here] end

/**
 * Expand the information provided as part of the actuator/info endpoint to include details about the currently
 * logged in user. This information will be available to be used by the client-side.
 */
@Component
public class ActuatorInfoUserDetailsContributor implements InfoContributor {

	// % protected region % [Add additional class fields here] off begin
	// % protected region % [Add additional class fields here] end

	@Override
	public void contribute(Info.Builder builder) {
		// % protected region % [Override or extend the information contributed to the info endpoint] off begin
		var authentication = SecurityContextHolder.getContext().getAuthentication();
		assert authentication != null;

		var principal = authentication.getPrincipal();
		var authenticated = authentication.getPrincipal() instanceof UserDetails;
		var userInfo = new UserInfoDto();
		userInfo.setAuthenticated(authenticated);

		if (userInfo.isAuthenticated()) {
			assert principal instanceof UserDetails;
			String username = ((UserDetails)principal).getUsername();
			userInfo.setUsername(username);
		}
		builder.withDetail("userInfo", userInfo);
		// % protected region % [Override or extend the information contributed to the info endpoint] end
	}

	// % protected region % [Add additional class methods here] off begin
	// % protected region % [Add additional class methods here] end
}