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
package kmsweb.account;

import kmsweb.SpringTestConfiguration;
import kmsweb.configs.security.helpers.RoleAndPrivilegeHelper;
import kmsweb.entities.UserEntity;
import kmsweb.configs.security.helpers.AnonymousHelper;
import kmsweb.repositories.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Integrated test for the whole reset password functionality
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringTestConfiguration.class)
@ActiveProfiles("test")
public class TestingAccountsTest {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	Environment env;

	private static final String SUPER_ACCOUNT_EMAIL = "super@example.com";

	private static final String SUPER_ROLE_NAME = "SUPER ADMIN";

	private Boolean isTestOrDevelopmentEnvironment;

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end

	@BeforeEach
	public void setup() {
		// % protected region % [Add any additional logic for setup before the main body here] off begin
		// % protected region % [Add any additional logic for setup before the main body here] end

		// % protected region % [Add any additional logic for setup after the main body here] off begin
		// % protected region % [Add any additional logic for setup after the main body here] end
	}

	@Test
	public void testSuperAccount_ShouldHaveSuperAccountExistInTestOrDevEnv() throws Exception {
		AnonymousHelper.runAnonymously(() -> {
			var userEntityOpt = userRepository.findByEmail(SUPER_ACCOUNT_EMAIL);
			var roleEntityOpt = roleRepository.findByName(SUPER_ROLE_NAME);

			Assertions.assertTrue(userEntityOpt.isPresent(), "Super user should exist");
			Assertions.assertTrue(roleEntityOpt.isPresent(), "Super role should exist");

			var userEntity = (UserEntity) userEntityOpt.get();
			var roleEntity = roleEntityOpt.get();

			Assertions.assertTrue(userEntity.getRoles().contains(roleEntity), "Super user should have the super role");
		});
	}

	@Test
	public void testSuperAccount_SuperShouldHaveFullPrivileges() {
		AnonymousHelper.runAnonymously(() -> {
			var roleEntityOpt = roleRepository.findByName(SUPER_ROLE_NAME);
			Assertions.assertTrue(roleEntityOpt.isPresent(), "Super role should exist");

			var roleEntity = roleEntityOpt.get();

			roleEntity.getPrivileges().forEach(privilegeEntity -> {
				Assertions.assertTrue(privilegeEntity.getAllowRead(),
						"Super should have read access to " + privilegeEntity.getTargetEntity().getClass().getName()
				);
				Assertions.assertTrue(privilegeEntity.getAllowCreate(),
						"Super should have create access to " + privilegeEntity.getTargetEntity().getClass().getName()
				);
				Assertions.assertTrue(privilegeEntity.getAllowDelete(),
						"Super should have delete access to " + privilegeEntity.getTargetEntity().getClass().getName()
				);
				Assertions.assertTrue(privilegeEntity.getAllowUpdate(),
						"Super should have update access to " + privilegeEntity.getTargetEntity().getClass().getName()
				);
			});
			Assertions.assertEquals(
					roleEntity.getPrivileges().size(),
					Arrays.asList(RoleAndPrivilegeHelper.APPLICATION_ENTITY_NAMES).size()
			);
		});
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}
