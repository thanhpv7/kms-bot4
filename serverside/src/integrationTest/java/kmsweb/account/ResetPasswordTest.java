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
import kmsweb.configs.properties.ApplicationProperties;
import kmsweb.configs.security.repositories.XsrfTokenRepository;
import kmsweb.utils.*;
import kmsweb.configs.security.helpers.AnonymousHelper;
import kmsweb.entities.*;
import kmsweb.lib.token.models.TokenEntity;
import kmsweb.lib.token.services.TokenService;
import kmsweb.services.*;
import kmsweb.configs.security.services.AuthenticationService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.*;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.icegreen.greenmail.util.GreenMailUtil;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import java.util.*;
import java.time.OffsetDateTime;
import java.util.stream.Collectors;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Integrated test for the whole reset password functionality
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringTestConfiguration.class)
@ActiveProfiles("test")
public class ResetPasswordTest {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private XsrfTokenRepository xsrfTokenRepository;

	@Autowired
	private AdministrationUserService administrationUserService;

	@Autowired
	private AdministratorService administratorService;

	@Autowired
	private CashierUserService cashierUserService;

	@Autowired
	private ClaimUserService claimUserService;

	@Autowired
	private DiagnosticSupportUserService diagnosticSupportUserService;

	@Autowired
	private DoctorUserService doctorUserService;

	@Autowired
	private FacilityUserService facilityUserService;

	@Autowired
	private ManagementUserService managementUserService;

	@Autowired
	private MedicalRecordUserService medicalRecordUserService;

	@Autowired
	private MedicalTranscriberUserService medicalTranscriberUserService;

	@Autowired
	private NurseUserService nurseUserService;

	@Autowired
	private PharmacyUserService pharmacyUserService;

	@Autowired
	private PurchasingUserService purchasingUserService;

	@Autowired
	private RegistrationUserService registrationUserService;

	@Autowired
	private SystemAdminUserService systemAdminUserService;

	@Autowired
	private WarehouseUserService warehouseUserService;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ApplicationProperties applicationProperties;

	public SmtpServerRule smtpServerRule = new SmtpServerRule();

	private final String resetPasswordEndpoint = "/api/authorization/reset-password";
	private final String requestResetPasswordEndpoint = "/api/authorization/request-reset-password";

	private MockMvc mvc;

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end

	@BeforeEach
	public void setup() {
		// % protected region % [Add any additional logic for setup before the main body here] off begin
		// % protected region % [Add any additional logic for setup before the main body here] end

		smtpServerRule.beforeEach();
		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();

		// % protected region % [Add any additional logic for setup after the main body here] off begin
		// % protected region % [Add any additional logic for setup after the main body here] end
	}

	@AfterEach
	public void teardown() {
		// % protected region % [Add any additional logic for teardown before the main body here] off begin
		// % protected region % [Add any additional logic for teardown before the main body here] end

		smtpServerRule.afterEach();

		// % protected region % [Add any additional logic for teardown after the main body here] off begin
		// % protected region % [Add any additional logic for teardown after the main body here] end
	}

	@Test
	@DirtiesContext
	public void requestToResetPasswordWithAdministrationUserEntity_shouldSucceedWith200() throws Exception {

		String email = "administrationUser@example.com";

		ResultActions result = sendToRequestResetPassword(email);

		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithAdministrationUser here] off begin
		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithAdministrationUser here] end

		// Check whether token is created and check the content of email
		AnonymousHelper.runAnonymously(() -> {
			UserEntity userEntity = administrationUserService.findByEmail(email).orElseThrow();
			try {

				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithAdministrationUser here] off begin
				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithAdministrationUser here] end

				// Check whether reset password token is created and link to the user
				Assertions.assertNotNull(userEntity.getResetPasswordToken());

				// Get the Reset password token
				TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithAdministrationUser here] off begin
				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithAdministrationUser here] end

				// Check email content
				this.checkResetPasswordEmail(userEntity.getName(), userEntity.getEmail(), tokenEntity);

				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithAdministrationUser here] off begin
				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithAdministrationUser here] end

			} catch (Exception except) {
				Assertions.fail("Could not find user entity");
			}
		});

		// % protected region % [Add any additional asserts in requestToResetPasswordWithAdministrationUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional asserts in requestToResetPasswordWithAdministrationUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	@DirtiesContext
	public void requestToResetPasswordWithAdministratorEntity_shouldSucceedWith200() throws Exception {

		String email = "administrator@example.com";

		ResultActions result = sendToRequestResetPassword(email);

		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithAdministrator here] off begin
		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithAdministrator here] end

		// Check whether token is created and check the content of email
		AnonymousHelper.runAnonymously(() -> {
			UserEntity userEntity = administratorService.findByEmail(email).orElseThrow();
			try {

				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithAdministrator here] off begin
				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithAdministrator here] end

				// Check whether reset password token is created and link to the user
				Assertions.assertNotNull(userEntity.getResetPasswordToken());

				// Get the Reset password token
				TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithAdministrator here] off begin
				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithAdministrator here] end

				// Check email content
				this.checkResetPasswordEmail(userEntity.getName(), userEntity.getEmail(), tokenEntity);

				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithAdministrator here] off begin
				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithAdministrator here] end

			} catch (Exception except) {
				Assertions.fail("Could not find user entity");
			}
		});

		// % protected region % [Add any additional asserts in requestToResetPasswordWithAdministratorEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional asserts in requestToResetPasswordWithAdministratorEntity_shouldSucceedWith200 here] end
	}

	@Test
	@DirtiesContext
	public void requestToResetPasswordWithCashierUserEntity_shouldSucceedWith200() throws Exception {

		String email = "cashierUser@example.com";

		ResultActions result = sendToRequestResetPassword(email);

		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithCashierUser here] off begin
		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithCashierUser here] end

		// Check whether token is created and check the content of email
		AnonymousHelper.runAnonymously(() -> {
			UserEntity userEntity = cashierUserService.findByEmail(email).orElseThrow();
			try {

				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithCashierUser here] off begin
				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithCashierUser here] end

				// Check whether reset password token is created and link to the user
				Assertions.assertNotNull(userEntity.getResetPasswordToken());

				// Get the Reset password token
				TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithCashierUser here] off begin
				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithCashierUser here] end

				// Check email content
				this.checkResetPasswordEmail(userEntity.getName(), userEntity.getEmail(), tokenEntity);

				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithCashierUser here] off begin
				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithCashierUser here] end

			} catch (Exception except) {
				Assertions.fail("Could not find user entity");
			}
		});

		// % protected region % [Add any additional asserts in requestToResetPasswordWithCashierUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional asserts in requestToResetPasswordWithCashierUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	@DirtiesContext
	public void requestToResetPasswordWithClaimUserEntity_shouldSucceedWith200() throws Exception {

		String email = "claimUser@example.com";

		ResultActions result = sendToRequestResetPassword(email);

		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithClaimUser here] off begin
		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithClaimUser here] end

		// Check whether token is created and check the content of email
		AnonymousHelper.runAnonymously(() -> {
			UserEntity userEntity = claimUserService.findByEmail(email).orElseThrow();
			try {

				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithClaimUser here] off begin
				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithClaimUser here] end

				// Check whether reset password token is created and link to the user
				Assertions.assertNotNull(userEntity.getResetPasswordToken());

				// Get the Reset password token
				TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithClaimUser here] off begin
				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithClaimUser here] end

				// Check email content
				this.checkResetPasswordEmail(userEntity.getName(), userEntity.getEmail(), tokenEntity);

				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithClaimUser here] off begin
				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithClaimUser here] end

			} catch (Exception except) {
				Assertions.fail("Could not find user entity");
			}
		});

		// % protected region % [Add any additional asserts in requestToResetPasswordWithClaimUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional asserts in requestToResetPasswordWithClaimUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	@DirtiesContext
	public void requestToResetPasswordWithDiagnosticSupportUserEntity_shouldSucceedWith200() throws Exception {

		String email = "diagnosticSupportUser@example.com";

		ResultActions result = sendToRequestResetPassword(email);

		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithDiagnosticSupportUser here] off begin
		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithDiagnosticSupportUser here] end

		// Check whether token is created and check the content of email
		AnonymousHelper.runAnonymously(() -> {
			UserEntity userEntity = diagnosticSupportUserService.findByEmail(email).orElseThrow();
			try {

				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithDiagnosticSupportUser here] off begin
				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithDiagnosticSupportUser here] end

				// Check whether reset password token is created and link to the user
				Assertions.assertNotNull(userEntity.getResetPasswordToken());

				// Get the Reset password token
				TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithDiagnosticSupportUser here] off begin
				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithDiagnosticSupportUser here] end

				// Check email content
				this.checkResetPasswordEmail(userEntity.getName(), userEntity.getEmail(), tokenEntity);

				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithDiagnosticSupportUser here] off begin
				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithDiagnosticSupportUser here] end

			} catch (Exception except) {
				Assertions.fail("Could not find user entity");
			}
		});

		// % protected region % [Add any additional asserts in requestToResetPasswordWithDiagnosticSupportUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional asserts in requestToResetPasswordWithDiagnosticSupportUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	@DirtiesContext
	public void requestToResetPasswordWithDoctorUserEntity_shouldSucceedWith200() throws Exception {

		String email = "doctorUser@example.com";

		ResultActions result = sendToRequestResetPassword(email);

		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithDoctorUser here] off begin
		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithDoctorUser here] end

		// Check whether token is created and check the content of email
		AnonymousHelper.runAnonymously(() -> {
			UserEntity userEntity = doctorUserService.findByEmail(email).orElseThrow();
			try {

				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithDoctorUser here] off begin
				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithDoctorUser here] end

				// Check whether reset password token is created and link to the user
				Assertions.assertNotNull(userEntity.getResetPasswordToken());

				// Get the Reset password token
				TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithDoctorUser here] off begin
				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithDoctorUser here] end

				// Check email content
				this.checkResetPasswordEmail(userEntity.getName(), userEntity.getEmail(), tokenEntity);

				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithDoctorUser here] off begin
				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithDoctorUser here] end

			} catch (Exception except) {
				Assertions.fail("Could not find user entity");
			}
		});

		// % protected region % [Add any additional asserts in requestToResetPasswordWithDoctorUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional asserts in requestToResetPasswordWithDoctorUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	@DirtiesContext
	public void requestToResetPasswordWithFacilityUserEntity_shouldSucceedWith200() throws Exception {

		String email = "facilityUser@example.com";

		ResultActions result = sendToRequestResetPassword(email);

		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithFacilityUser here] off begin
		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithFacilityUser here] end

		// Check whether token is created and check the content of email
		AnonymousHelper.runAnonymously(() -> {
			UserEntity userEntity = facilityUserService.findByEmail(email).orElseThrow();
			try {

				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithFacilityUser here] off begin
				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithFacilityUser here] end

				// Check whether reset password token is created and link to the user
				Assertions.assertNotNull(userEntity.getResetPasswordToken());

				// Get the Reset password token
				TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithFacilityUser here] off begin
				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithFacilityUser here] end

				// Check email content
				this.checkResetPasswordEmail(userEntity.getName(), userEntity.getEmail(), tokenEntity);

				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithFacilityUser here] off begin
				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithFacilityUser here] end

			} catch (Exception except) {
				Assertions.fail("Could not find user entity");
			}
		});

		// % protected region % [Add any additional asserts in requestToResetPasswordWithFacilityUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional asserts in requestToResetPasswordWithFacilityUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	@DirtiesContext
	public void requestToResetPasswordWithManagementUserEntity_shouldSucceedWith200() throws Exception {

		String email = "managementUser@example.com";

		ResultActions result = sendToRequestResetPassword(email);

		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithManagementUser here] off begin
		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithManagementUser here] end

		// Check whether token is created and check the content of email
		AnonymousHelper.runAnonymously(() -> {
			UserEntity userEntity = managementUserService.findByEmail(email).orElseThrow();
			try {

				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithManagementUser here] off begin
				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithManagementUser here] end

				// Check whether reset password token is created and link to the user
				Assertions.assertNotNull(userEntity.getResetPasswordToken());

				// Get the Reset password token
				TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithManagementUser here] off begin
				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithManagementUser here] end

				// Check email content
				this.checkResetPasswordEmail(userEntity.getName(), userEntity.getEmail(), tokenEntity);

				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithManagementUser here] off begin
				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithManagementUser here] end

			} catch (Exception except) {
				Assertions.fail("Could not find user entity");
			}
		});

		// % protected region % [Add any additional asserts in requestToResetPasswordWithManagementUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional asserts in requestToResetPasswordWithManagementUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	@DirtiesContext
	public void requestToResetPasswordWithMedicalRecordUserEntity_shouldSucceedWith200() throws Exception {

		String email = "medicalRecordUser@example.com";

		ResultActions result = sendToRequestResetPassword(email);

		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithMedicalRecordUser here] off begin
		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithMedicalRecordUser here] end

		// Check whether token is created and check the content of email
		AnonymousHelper.runAnonymously(() -> {
			UserEntity userEntity = medicalRecordUserService.findByEmail(email).orElseThrow();
			try {

				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithMedicalRecordUser here] off begin
				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithMedicalRecordUser here] end

				// Check whether reset password token is created and link to the user
				Assertions.assertNotNull(userEntity.getResetPasswordToken());

				// Get the Reset password token
				TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithMedicalRecordUser here] off begin
				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithMedicalRecordUser here] end

				// Check email content
				this.checkResetPasswordEmail(userEntity.getName(), userEntity.getEmail(), tokenEntity);

				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithMedicalRecordUser here] off begin
				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithMedicalRecordUser here] end

			} catch (Exception except) {
				Assertions.fail("Could not find user entity");
			}
		});

		// % protected region % [Add any additional asserts in requestToResetPasswordWithMedicalRecordUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional asserts in requestToResetPasswordWithMedicalRecordUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	@DirtiesContext
	public void requestToResetPasswordWithMedicalTranscriberUserEntity_shouldSucceedWith200() throws Exception {

		String email = "medicalTranscriberUser@example.com";

		ResultActions result = sendToRequestResetPassword(email);

		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithMedicalTranscriberUser here] off begin
		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithMedicalTranscriberUser here] end

		// Check whether token is created and check the content of email
		AnonymousHelper.runAnonymously(() -> {
			UserEntity userEntity = medicalTranscriberUserService.findByEmail(email).orElseThrow();
			try {

				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithMedicalTranscriberUser here] off begin
				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithMedicalTranscriberUser here] end

				// Check whether reset password token is created and link to the user
				Assertions.assertNotNull(userEntity.getResetPasswordToken());

				// Get the Reset password token
				TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithMedicalTranscriberUser here] off begin
				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithMedicalTranscriberUser here] end

				// Check email content
				this.checkResetPasswordEmail(userEntity.getName(), userEntity.getEmail(), tokenEntity);

				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithMedicalTranscriberUser here] off begin
				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithMedicalTranscriberUser here] end

			} catch (Exception except) {
				Assertions.fail("Could not find user entity");
			}
		});

		// % protected region % [Add any additional asserts in requestToResetPasswordWithMedicalTranscriberUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional asserts in requestToResetPasswordWithMedicalTranscriberUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	@DirtiesContext
	public void requestToResetPasswordWithNurseUserEntity_shouldSucceedWith200() throws Exception {

		String email = "nurseUser@example.com";

		ResultActions result = sendToRequestResetPassword(email);

		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithNurseUser here] off begin
		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithNurseUser here] end

		// Check whether token is created and check the content of email
		AnonymousHelper.runAnonymously(() -> {
			UserEntity userEntity = nurseUserService.findByEmail(email).orElseThrow();
			try {

				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithNurseUser here] off begin
				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithNurseUser here] end

				// Check whether reset password token is created and link to the user
				Assertions.assertNotNull(userEntity.getResetPasswordToken());

				// Get the Reset password token
				TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithNurseUser here] off begin
				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithNurseUser here] end

				// Check email content
				this.checkResetPasswordEmail(userEntity.getName(), userEntity.getEmail(), tokenEntity);

				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithNurseUser here] off begin
				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithNurseUser here] end

			} catch (Exception except) {
				Assertions.fail("Could not find user entity");
			}
		});

		// % protected region % [Add any additional asserts in requestToResetPasswordWithNurseUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional asserts in requestToResetPasswordWithNurseUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	@DirtiesContext
	public void requestToResetPasswordWithPharmacyUserEntity_shouldSucceedWith200() throws Exception {

		String email = "pharmacyUser@example.com";

		ResultActions result = sendToRequestResetPassword(email);

		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithPharmacyUser here] off begin
		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithPharmacyUser here] end

		// Check whether token is created and check the content of email
		AnonymousHelper.runAnonymously(() -> {
			UserEntity userEntity = pharmacyUserService.findByEmail(email).orElseThrow();
			try {

				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithPharmacyUser here] off begin
				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithPharmacyUser here] end

				// Check whether reset password token is created and link to the user
				Assertions.assertNotNull(userEntity.getResetPasswordToken());

				// Get the Reset password token
				TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithPharmacyUser here] off begin
				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithPharmacyUser here] end

				// Check email content
				this.checkResetPasswordEmail(userEntity.getName(), userEntity.getEmail(), tokenEntity);

				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithPharmacyUser here] off begin
				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithPharmacyUser here] end

			} catch (Exception except) {
				Assertions.fail("Could not find user entity");
			}
		});

		// % protected region % [Add any additional asserts in requestToResetPasswordWithPharmacyUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional asserts in requestToResetPasswordWithPharmacyUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	@DirtiesContext
	public void requestToResetPasswordWithPurchasingUserEntity_shouldSucceedWith200() throws Exception {

		String email = "purchasingUser@example.com";

		ResultActions result = sendToRequestResetPassword(email);

		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithPurchasingUser here] off begin
		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithPurchasingUser here] end

		// Check whether token is created and check the content of email
		AnonymousHelper.runAnonymously(() -> {
			UserEntity userEntity = purchasingUserService.findByEmail(email).orElseThrow();
			try {

				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithPurchasingUser here] off begin
				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithPurchasingUser here] end

				// Check whether reset password token is created and link to the user
				Assertions.assertNotNull(userEntity.getResetPasswordToken());

				// Get the Reset password token
				TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithPurchasingUser here] off begin
				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithPurchasingUser here] end

				// Check email content
				this.checkResetPasswordEmail(userEntity.getName(), userEntity.getEmail(), tokenEntity);

				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithPurchasingUser here] off begin
				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithPurchasingUser here] end

			} catch (Exception except) {
				Assertions.fail("Could not find user entity");
			}
		});

		// % protected region % [Add any additional asserts in requestToResetPasswordWithPurchasingUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional asserts in requestToResetPasswordWithPurchasingUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	@DirtiesContext
	public void requestToResetPasswordWithRegistrationUserEntity_shouldSucceedWith200() throws Exception {

		String email = "registrationUser@example.com";

		ResultActions result = sendToRequestResetPassword(email);

		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithRegistrationUser here] off begin
		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithRegistrationUser here] end

		// Check whether token is created and check the content of email
		AnonymousHelper.runAnonymously(() -> {
			UserEntity userEntity = registrationUserService.findByEmail(email).orElseThrow();
			try {

				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithRegistrationUser here] off begin
				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithRegistrationUser here] end

				// Check whether reset password token is created and link to the user
				Assertions.assertNotNull(userEntity.getResetPasswordToken());

				// Get the Reset password token
				TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithRegistrationUser here] off begin
				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithRegistrationUser here] end

				// Check email content
				this.checkResetPasswordEmail(userEntity.getName(), userEntity.getEmail(), tokenEntity);

				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithRegistrationUser here] off begin
				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithRegistrationUser here] end

			} catch (Exception except) {
				Assertions.fail("Could not find user entity");
			}
		});

		// % protected region % [Add any additional asserts in requestToResetPasswordWithRegistrationUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional asserts in requestToResetPasswordWithRegistrationUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	@DirtiesContext
	public void requestToResetPasswordWithSystemAdminUserEntity_shouldSucceedWith200() throws Exception {

		String email = "systemAdminUser@example.com";

		ResultActions result = sendToRequestResetPassword(email);

		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithSystemAdminUser here] off begin
		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithSystemAdminUser here] end

		// Check whether token is created and check the content of email
		AnonymousHelper.runAnonymously(() -> {
			UserEntity userEntity = systemAdminUserService.findByEmail(email).orElseThrow();
			try {

				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithSystemAdminUser here] off begin
				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithSystemAdminUser here] end

				// Check whether reset password token is created and link to the user
				Assertions.assertNotNull(userEntity.getResetPasswordToken());

				// Get the Reset password token
				TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithSystemAdminUser here] off begin
				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithSystemAdminUser here] end

				// Check email content
				this.checkResetPasswordEmail(userEntity.getName(), userEntity.getEmail(), tokenEntity);

				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithSystemAdminUser here] off begin
				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithSystemAdminUser here] end

			} catch (Exception except) {
				Assertions.fail("Could not find user entity");
			}
		});

		// % protected region % [Add any additional asserts in requestToResetPasswordWithSystemAdminUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional asserts in requestToResetPasswordWithSystemAdminUserEntity_shouldSucceedWith200 here] end
	}

	@Test
	@DirtiesContext
	public void requestToResetPasswordWithWarehouseUserEntity_shouldSucceedWith200() throws Exception {

		String email = "warehouseUser@example.com";

		ResultActions result = sendToRequestResetPassword(email);

		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithWarehouseUser here] off begin
		// % protected region % [Add any additional logic after sendRequestResetPasswordRequest in requestToResetPasswordWithWarehouseUser here] end

		// Check whether token is created and check the content of email
		AnonymousHelper.runAnonymously(() -> {
			UserEntity userEntity = warehouseUserService.findByEmail(email).orElseThrow();
			try {

				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithWarehouseUser here] off begin
				// % protected region % [Add any additional logic before check data in requestToResetPasswordWithWarehouseUser here] end

				// Check whether reset password token is created and link to the user
				Assertions.assertNotNull(userEntity.getResetPasswordToken());

				// Get the Reset password token
				TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithWarehouseUser here] off begin
				// % protected region % [Add any additional logic before check email content in requestToResetPasswordWithWarehouseUser here] end

				// Check email content
				this.checkResetPasswordEmail(userEntity.getName(), userEntity.getEmail(), tokenEntity);

				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithWarehouseUser here] off begin
				// % protected region % [Add any additional logic after check email content in requestToResetPasswordWithWarehouseUser here] end

			} catch (Exception except) {
				Assertions.fail("Could not find user entity");
			}
		});

		// % protected region % [Add any additional asserts in requestToResetPasswordWithWarehouseUserEntity_shouldSucceedWith200 here] off begin
		// % protected region % [Add any additional asserts in requestToResetPasswordWithWarehouseUserEntity_shouldSucceedWith200 here] end
	}


	@Test
	public void requestToResetPassword_withInValidUsername() throws Exception{

		Map<String, Object> body = new HashMap<>();

		body.put("username", "not_exist@example.com");
		// % protected region % [Add any additional request parameters in requestToResetPassword_withInValidUsername here] off begin
		// % protected region % [Add any additional request parameters in requestToResetPassword_withInValidUsername here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, requestResetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending request in requestToResetPassword_withInValidUsername here] off begin
		// % protected region % [Add any additional logic after sending request in requestToResetPassword_withInValidUsername here] end

		// Test response body
		String expectedError = "unknown_user";
		String expectedErrorDescription = "Could not find the user. Please check your username.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.NOT_FOUND);

		// % protected region % [Add any additional logic after sending asserts in requestToResetPassword_withInValidUsername here] off begin
		// % protected region % [Add any additional logic after sending asserts in requestToResetPassword_withInValidUsername here] end
	}

	@Test
	public void requestToResetPassword_missingUserName() throws Exception{

		Map<String, Object> body = new HashMap<>();

		// % protected region % [Add any additional request parameters in requestToResetPassword_missingUserName here] off begin
		// % protected region % [Add any additional request parameters in requestToResetPassword_missingUserName here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, requestResetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending request in requestToResetPassword_missingUserName here] off begin
		// % protected region % [Add any additional logic after sending request in requestToResetPassword_missingUserName here] end

		// Test the response.
		String errorType = "missing_arguments";
		String errorDescription = "Username is required";
		RequestUtil.checkErrorResponse(result, errorType, errorDescription, HttpStatus.BAD_REQUEST);

		// % protected region % [Add any additional asserts in requestToResetPassword_missingUserName here] off begin
		// % protected region % [Add any additional asserts in requestToResetPassword_missingUserName here] end
	}

	@Test
	public void resetPasswordWithAdministrationUserEntity_shouldSucceedWith200() throws Exception {



		String username =  "administrationUser@example.com";
		String newPassword = "new_password";

		// Sending request and create token first
		sendToRequestResetPassword(username);

		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {

			body.put("username", username);

			UserEntity userEntity = this.administrationUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithAdministrationUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithAdministrationUser here] end
		});

		ResultActions resultActions = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);


		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic after sending request in resetPasswordWithAdministrationUser here] off begin
			// % protected region % [Add any additional logic after sending request in resetPasswordWithAdministrationUser here] end

			UserEntity userEntity = this.administrationUserService.findByEmail(username).orElseThrow();

			List<String> expectedRoles = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
			try {
				RequestUtil.checkSuccessfulLoginResponse(resultActions, userEntity.getId().toString(), username, expectedRoles);

				// Check whether token is remove
				String tokenString = (String) body.get("token");
				Assertions.assertTrue(tokenService.findByToken(tokenString).isEmpty());
				Assertions.assertTrue(userEntity.getResetPasswordToken().stream().noneMatch(tokenEntity -> tokenEntity.getToken().equals(tokenString)));

				// Check password is reset
				Assertions.assertTrue(passwordEncoder.matches(newPassword, userEntity.getPassword()));

				checkUserLoggedIn(resultActions.andReturn().getResponse(), username);

				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithAdministrationUser here] off begin
				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithAdministrationUser here] end

			} catch (Exception except) {
				Assertions.fail("Failed to find data from database.");
			}
		});

		// % protected region % [Add any additional asserts in resetPasswordWithAdministrationUser here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithAdministrationUser here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithAdministrationUserEntity_tokenExpired() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithAdministrationUserEntity_shouldSucceedWith200();

		String username =  "administrationUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithAdministrationUser here] off begin
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithAdministrationUser here] end

			body.put("username", username);

			UserEntity userEntity = this.administrationUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			// Update date token to make it expired
			tokenEntity.setExpiryDateTime(OffsetDateTime.now().minusSeconds(1));
			tokenService.updateToken(tokenEntity);

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithAdministrationUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithAdministrationUser here] end
		});

		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithAdministrationUser here] off begin
		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithAdministrationUser here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithAdministrationUser here] off begin
		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithAdministrationUser here] end

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithAdministrationUser here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithAdministrationUser here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Token has expired. Please reset your password again.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithAdministrationUserEntity_tokenExpired here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithAdministrationUserEntity_tokenExpired here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithAdministrationUserEntity_tokenNotMatched() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithAdministrationUserEntity_shouldSucceedWith200();

		String username =  "administrationUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("token", UUID.randomUUID().toString());
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in resetPasswordWithAdministrationUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before sending response in resetPasswordWithAdministrationUserEntity_tokenNotMatched here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in resetPasswordWithAdministrationUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic after sending response in resetPasswordWithAdministrationUserEntity_tokenNotMatched here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Reset password tokens do not match";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithAdministrationUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithAdministrationUserEntity_tokenNotMatched here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithAdministrationUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithAdministrationUserEntity_tokenNotMatched here] end
	}

	@Test
	public void resetPasswordWithAdministratorEntity_shouldSucceedWith200() throws Exception {



		String username =  "administrator@example.com";
		String newPassword = "new_password";

		// Sending request and create token first
		sendToRequestResetPassword(username);

		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {

			body.put("username", username);

			UserEntity userEntity = this.administratorService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithAdministrator here] off begin
			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithAdministrator here] end
		});

		ResultActions resultActions = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);


		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic after sending request in resetPasswordWithAdministrator here] off begin
			// % protected region % [Add any additional logic after sending request in resetPasswordWithAdministrator here] end

			UserEntity userEntity = this.administratorService.findByEmail(username).orElseThrow();

			List<String> expectedRoles = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
			try {
				RequestUtil.checkSuccessfulLoginResponse(resultActions, userEntity.getId().toString(), username, expectedRoles);

				// Check whether token is remove
				String tokenString = (String) body.get("token");
				Assertions.assertTrue(tokenService.findByToken(tokenString).isEmpty());
				Assertions.assertTrue(userEntity.getResetPasswordToken().stream().noneMatch(tokenEntity -> tokenEntity.getToken().equals(tokenString)));

				// Check password is reset
				Assertions.assertTrue(passwordEncoder.matches(newPassword, userEntity.getPassword()));

				checkUserLoggedIn(resultActions.andReturn().getResponse(), username);

				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithAdministrator here] off begin
				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithAdministrator here] end

			} catch (Exception except) {
				Assertions.fail("Failed to find data from database.");
			}
		});

		// % protected region % [Add any additional asserts in resetPasswordWithAdministrator here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithAdministrator here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithAdministratorEntity_tokenExpired() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithAdministratorEntity_shouldSucceedWith200();

		String username =  "administrator@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithAdministrator here] off begin
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithAdministrator here] end

			body.put("username", username);

			UserEntity userEntity = this.administratorService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			// Update date token to make it expired
			tokenEntity.setExpiryDateTime(OffsetDateTime.now().minusSeconds(1));
			tokenService.updateToken(tokenEntity);

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithAdministrator here] off begin
			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithAdministrator here] end
		});

		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithAdministrator here] off begin
		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithAdministrator here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithAdministrator here] off begin
		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithAdministrator here] end

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithAdministrator here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithAdministrator here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Token has expired. Please reset your password again.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithAdministratorEntity_tokenExpired here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithAdministratorEntity_tokenExpired here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithAdministratorEntity_tokenNotMatched() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithAdministratorEntity_shouldSucceedWith200();

		String username =  "administrator@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("token", UUID.randomUUID().toString());
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in resetPasswordWithAdministratorEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before sending response in resetPasswordWithAdministratorEntity_tokenNotMatched here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in resetPasswordWithAdministratorEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic after sending response in resetPasswordWithAdministratorEntity_tokenNotMatched here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Reset password tokens do not match";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithAdministratorEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithAdministratorEntity_tokenNotMatched here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithAdministratorEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithAdministratorEntity_tokenNotMatched here] end
	}

	@Test
	public void resetPasswordWithCashierUserEntity_shouldSucceedWith200() throws Exception {



		String username =  "cashierUser@example.com";
		String newPassword = "new_password";

		// Sending request and create token first
		sendToRequestResetPassword(username);

		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {

			body.put("username", username);

			UserEntity userEntity = this.cashierUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithCashierUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithCashierUser here] end
		});

		ResultActions resultActions = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);


		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic after sending request in resetPasswordWithCashierUser here] off begin
			// % protected region % [Add any additional logic after sending request in resetPasswordWithCashierUser here] end

			UserEntity userEntity = this.cashierUserService.findByEmail(username).orElseThrow();

			List<String> expectedRoles = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
			try {
				RequestUtil.checkSuccessfulLoginResponse(resultActions, userEntity.getId().toString(), username, expectedRoles);

				// Check whether token is remove
				String tokenString = (String) body.get("token");
				Assertions.assertTrue(tokenService.findByToken(tokenString).isEmpty());
				Assertions.assertTrue(userEntity.getResetPasswordToken().stream().noneMatch(tokenEntity -> tokenEntity.getToken().equals(tokenString)));

				// Check password is reset
				Assertions.assertTrue(passwordEncoder.matches(newPassword, userEntity.getPassword()));

				checkUserLoggedIn(resultActions.andReturn().getResponse(), username);

				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithCashierUser here] off begin
				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithCashierUser here] end

			} catch (Exception except) {
				Assertions.fail("Failed to find data from database.");
			}
		});

		// % protected region % [Add any additional asserts in resetPasswordWithCashierUser here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithCashierUser here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithCashierUserEntity_tokenExpired() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithCashierUserEntity_shouldSucceedWith200();

		String username =  "cashierUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithCashierUser here] off begin
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithCashierUser here] end

			body.put("username", username);

			UserEntity userEntity = this.cashierUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			// Update date token to make it expired
			tokenEntity.setExpiryDateTime(OffsetDateTime.now().minusSeconds(1));
			tokenService.updateToken(tokenEntity);

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithCashierUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithCashierUser here] end
		});

		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithCashierUser here] off begin
		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithCashierUser here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithCashierUser here] off begin
		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithCashierUser here] end

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithCashierUser here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithCashierUser here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Token has expired. Please reset your password again.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithCashierUserEntity_tokenExpired here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithCashierUserEntity_tokenExpired here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithCashierUserEntity_tokenNotMatched() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithCashierUserEntity_shouldSucceedWith200();

		String username =  "cashierUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("token", UUID.randomUUID().toString());
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in resetPasswordWithCashierUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before sending response in resetPasswordWithCashierUserEntity_tokenNotMatched here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in resetPasswordWithCashierUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic after sending response in resetPasswordWithCashierUserEntity_tokenNotMatched here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Reset password tokens do not match";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithCashierUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithCashierUserEntity_tokenNotMatched here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithCashierUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithCashierUserEntity_tokenNotMatched here] end
	}

	@Test
	public void resetPasswordWithClaimUserEntity_shouldSucceedWith200() throws Exception {



		String username =  "claimUser@example.com";
		String newPassword = "new_password";

		// Sending request and create token first
		sendToRequestResetPassword(username);

		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {

			body.put("username", username);

			UserEntity userEntity = this.claimUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithClaimUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithClaimUser here] end
		});

		ResultActions resultActions = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);


		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic after sending request in resetPasswordWithClaimUser here] off begin
			// % protected region % [Add any additional logic after sending request in resetPasswordWithClaimUser here] end

			UserEntity userEntity = this.claimUserService.findByEmail(username).orElseThrow();

			List<String> expectedRoles = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
			try {
				RequestUtil.checkSuccessfulLoginResponse(resultActions, userEntity.getId().toString(), username, expectedRoles);

				// Check whether token is remove
				String tokenString = (String) body.get("token");
				Assertions.assertTrue(tokenService.findByToken(tokenString).isEmpty());
				Assertions.assertTrue(userEntity.getResetPasswordToken().stream().noneMatch(tokenEntity -> tokenEntity.getToken().equals(tokenString)));

				// Check password is reset
				Assertions.assertTrue(passwordEncoder.matches(newPassword, userEntity.getPassword()));

				checkUserLoggedIn(resultActions.andReturn().getResponse(), username);

				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithClaimUser here] off begin
				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithClaimUser here] end

			} catch (Exception except) {
				Assertions.fail("Failed to find data from database.");
			}
		});

		// % protected region % [Add any additional asserts in resetPasswordWithClaimUser here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithClaimUser here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithClaimUserEntity_tokenExpired() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithClaimUserEntity_shouldSucceedWith200();

		String username =  "claimUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithClaimUser here] off begin
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithClaimUser here] end

			body.put("username", username);

			UserEntity userEntity = this.claimUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			// Update date token to make it expired
			tokenEntity.setExpiryDateTime(OffsetDateTime.now().minusSeconds(1));
			tokenService.updateToken(tokenEntity);

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithClaimUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithClaimUser here] end
		});

		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithClaimUser here] off begin
		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithClaimUser here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithClaimUser here] off begin
		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithClaimUser here] end

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithClaimUser here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithClaimUser here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Token has expired. Please reset your password again.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithClaimUserEntity_tokenExpired here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithClaimUserEntity_tokenExpired here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithClaimUserEntity_tokenNotMatched() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithClaimUserEntity_shouldSucceedWith200();

		String username =  "claimUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("token", UUID.randomUUID().toString());
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in resetPasswordWithClaimUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before sending response in resetPasswordWithClaimUserEntity_tokenNotMatched here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in resetPasswordWithClaimUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic after sending response in resetPasswordWithClaimUserEntity_tokenNotMatched here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Reset password tokens do not match";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithClaimUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithClaimUserEntity_tokenNotMatched here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithClaimUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithClaimUserEntity_tokenNotMatched here] end
	}

	@Test
	public void resetPasswordWithDiagnosticSupportUserEntity_shouldSucceedWith200() throws Exception {



		String username =  "diagnosticSupportUser@example.com";
		String newPassword = "new_password";

		// Sending request and create token first
		sendToRequestResetPassword(username);

		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {

			body.put("username", username);

			UserEntity userEntity = this.diagnosticSupportUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithDiagnosticSupportUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithDiagnosticSupportUser here] end
		});

		ResultActions resultActions = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);


		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic after sending request in resetPasswordWithDiagnosticSupportUser here] off begin
			// % protected region % [Add any additional logic after sending request in resetPasswordWithDiagnosticSupportUser here] end

			UserEntity userEntity = this.diagnosticSupportUserService.findByEmail(username).orElseThrow();

			List<String> expectedRoles = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
			try {
				RequestUtil.checkSuccessfulLoginResponse(resultActions, userEntity.getId().toString(), username, expectedRoles);

				// Check whether token is remove
				String tokenString = (String) body.get("token");
				Assertions.assertTrue(tokenService.findByToken(tokenString).isEmpty());
				Assertions.assertTrue(userEntity.getResetPasswordToken().stream().noneMatch(tokenEntity -> tokenEntity.getToken().equals(tokenString)));

				// Check password is reset
				Assertions.assertTrue(passwordEncoder.matches(newPassword, userEntity.getPassword()));

				checkUserLoggedIn(resultActions.andReturn().getResponse(), username);

				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithDiagnosticSupportUser here] off begin
				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithDiagnosticSupportUser here] end

			} catch (Exception except) {
				Assertions.fail("Failed to find data from database.");
			}
		});

		// % protected region % [Add any additional asserts in resetPasswordWithDiagnosticSupportUser here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithDiagnosticSupportUser here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithDiagnosticSupportUserEntity_tokenExpired() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithDiagnosticSupportUserEntity_shouldSucceedWith200();

		String username =  "diagnosticSupportUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithDiagnosticSupportUser here] off begin
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithDiagnosticSupportUser here] end

			body.put("username", username);

			UserEntity userEntity = this.diagnosticSupportUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			// Update date token to make it expired
			tokenEntity.setExpiryDateTime(OffsetDateTime.now().minusSeconds(1));
			tokenService.updateToken(tokenEntity);

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithDiagnosticSupportUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithDiagnosticSupportUser here] end
		});

		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithDiagnosticSupportUser here] off begin
		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithDiagnosticSupportUser here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithDiagnosticSupportUser here] off begin
		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithDiagnosticSupportUser here] end

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithDiagnosticSupportUser here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithDiagnosticSupportUser here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Token has expired. Please reset your password again.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithDiagnosticSupportUserEntity_tokenExpired here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithDiagnosticSupportUserEntity_tokenExpired here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithDiagnosticSupportUserEntity_tokenNotMatched() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithDiagnosticSupportUserEntity_shouldSucceedWith200();

		String username =  "diagnosticSupportUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("token", UUID.randomUUID().toString());
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in resetPasswordWithDiagnosticSupportUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before sending response in resetPasswordWithDiagnosticSupportUserEntity_tokenNotMatched here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in resetPasswordWithDiagnosticSupportUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic after sending response in resetPasswordWithDiagnosticSupportUserEntity_tokenNotMatched here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Reset password tokens do not match";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithDiagnosticSupportUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithDiagnosticSupportUserEntity_tokenNotMatched here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithDiagnosticSupportUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithDiagnosticSupportUserEntity_tokenNotMatched here] end
	}

	@Test
	public void resetPasswordWithDoctorUserEntity_shouldSucceedWith200() throws Exception {



		String username =  "doctorUser@example.com";
		String newPassword = "new_password";

		// Sending request and create token first
		sendToRequestResetPassword(username);

		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {

			body.put("username", username);

			UserEntity userEntity = this.doctorUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithDoctorUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithDoctorUser here] end
		});

		ResultActions resultActions = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);


		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic after sending request in resetPasswordWithDoctorUser here] off begin
			// % protected region % [Add any additional logic after sending request in resetPasswordWithDoctorUser here] end

			UserEntity userEntity = this.doctorUserService.findByEmail(username).orElseThrow();

			List<String> expectedRoles = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
			try {
				RequestUtil.checkSuccessfulLoginResponse(resultActions, userEntity.getId().toString(), username, expectedRoles);

				// Check whether token is remove
				String tokenString = (String) body.get("token");
				Assertions.assertTrue(tokenService.findByToken(tokenString).isEmpty());
				Assertions.assertTrue(userEntity.getResetPasswordToken().stream().noneMatch(tokenEntity -> tokenEntity.getToken().equals(tokenString)));

				// Check password is reset
				Assertions.assertTrue(passwordEncoder.matches(newPassword, userEntity.getPassword()));

				checkUserLoggedIn(resultActions.andReturn().getResponse(), username);

				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithDoctorUser here] off begin
				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithDoctorUser here] end

			} catch (Exception except) {
				Assertions.fail("Failed to find data from database.");
			}
		});

		// % protected region % [Add any additional asserts in resetPasswordWithDoctorUser here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithDoctorUser here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithDoctorUserEntity_tokenExpired() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithDoctorUserEntity_shouldSucceedWith200();

		String username =  "doctorUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithDoctorUser here] off begin
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithDoctorUser here] end

			body.put("username", username);

			UserEntity userEntity = this.doctorUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			// Update date token to make it expired
			tokenEntity.setExpiryDateTime(OffsetDateTime.now().minusSeconds(1));
			tokenService.updateToken(tokenEntity);

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithDoctorUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithDoctorUser here] end
		});

		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithDoctorUser here] off begin
		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithDoctorUser here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithDoctorUser here] off begin
		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithDoctorUser here] end

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithDoctorUser here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithDoctorUser here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Token has expired. Please reset your password again.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithDoctorUserEntity_tokenExpired here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithDoctorUserEntity_tokenExpired here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithDoctorUserEntity_tokenNotMatched() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithDoctorUserEntity_shouldSucceedWith200();

		String username =  "doctorUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("token", UUID.randomUUID().toString());
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in resetPasswordWithDoctorUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before sending response in resetPasswordWithDoctorUserEntity_tokenNotMatched here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in resetPasswordWithDoctorUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic after sending response in resetPasswordWithDoctorUserEntity_tokenNotMatched here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Reset password tokens do not match";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithDoctorUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithDoctorUserEntity_tokenNotMatched here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithDoctorUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithDoctorUserEntity_tokenNotMatched here] end
	}

	@Test
	public void resetPasswordWithFacilityUserEntity_shouldSucceedWith200() throws Exception {



		String username =  "facilityUser@example.com";
		String newPassword = "new_password";

		// Sending request and create token first
		sendToRequestResetPassword(username);

		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {

			body.put("username", username);

			UserEntity userEntity = this.facilityUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithFacilityUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithFacilityUser here] end
		});

		ResultActions resultActions = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);


		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic after sending request in resetPasswordWithFacilityUser here] off begin
			// % protected region % [Add any additional logic after sending request in resetPasswordWithFacilityUser here] end

			UserEntity userEntity = this.facilityUserService.findByEmail(username).orElseThrow();

			List<String> expectedRoles = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
			try {
				RequestUtil.checkSuccessfulLoginResponse(resultActions, userEntity.getId().toString(), username, expectedRoles);

				// Check whether token is remove
				String tokenString = (String) body.get("token");
				Assertions.assertTrue(tokenService.findByToken(tokenString).isEmpty());
				Assertions.assertTrue(userEntity.getResetPasswordToken().stream().noneMatch(tokenEntity -> tokenEntity.getToken().equals(tokenString)));

				// Check password is reset
				Assertions.assertTrue(passwordEncoder.matches(newPassword, userEntity.getPassword()));

				checkUserLoggedIn(resultActions.andReturn().getResponse(), username);

				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithFacilityUser here] off begin
				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithFacilityUser here] end

			} catch (Exception except) {
				Assertions.fail("Failed to find data from database.");
			}
		});

		// % protected region % [Add any additional asserts in resetPasswordWithFacilityUser here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithFacilityUser here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithFacilityUserEntity_tokenExpired() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithFacilityUserEntity_shouldSucceedWith200();

		String username =  "facilityUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithFacilityUser here] off begin
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithFacilityUser here] end

			body.put("username", username);

			UserEntity userEntity = this.facilityUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			// Update date token to make it expired
			tokenEntity.setExpiryDateTime(OffsetDateTime.now().minusSeconds(1));
			tokenService.updateToken(tokenEntity);

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithFacilityUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithFacilityUser here] end
		});

		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithFacilityUser here] off begin
		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithFacilityUser here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithFacilityUser here] off begin
		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithFacilityUser here] end

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithFacilityUser here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithFacilityUser here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Token has expired. Please reset your password again.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithFacilityUserEntity_tokenExpired here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithFacilityUserEntity_tokenExpired here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithFacilityUserEntity_tokenNotMatched() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithFacilityUserEntity_shouldSucceedWith200();

		String username =  "facilityUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("token", UUID.randomUUID().toString());
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in resetPasswordWithFacilityUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before sending response in resetPasswordWithFacilityUserEntity_tokenNotMatched here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in resetPasswordWithFacilityUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic after sending response in resetPasswordWithFacilityUserEntity_tokenNotMatched here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Reset password tokens do not match";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithFacilityUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithFacilityUserEntity_tokenNotMatched here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithFacilityUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithFacilityUserEntity_tokenNotMatched here] end
	}

	@Test
	public void resetPasswordWithManagementUserEntity_shouldSucceedWith200() throws Exception {



		String username =  "managementUser@example.com";
		String newPassword = "new_password";

		// Sending request and create token first
		sendToRequestResetPassword(username);

		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {

			body.put("username", username);

			UserEntity userEntity = this.managementUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithManagementUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithManagementUser here] end
		});

		ResultActions resultActions = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);


		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic after sending request in resetPasswordWithManagementUser here] off begin
			// % protected region % [Add any additional logic after sending request in resetPasswordWithManagementUser here] end

			UserEntity userEntity = this.managementUserService.findByEmail(username).orElseThrow();

			List<String> expectedRoles = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
			try {
				RequestUtil.checkSuccessfulLoginResponse(resultActions, userEntity.getId().toString(), username, expectedRoles);

				// Check whether token is remove
				String tokenString = (String) body.get("token");
				Assertions.assertTrue(tokenService.findByToken(tokenString).isEmpty());
				Assertions.assertTrue(userEntity.getResetPasswordToken().stream().noneMatch(tokenEntity -> tokenEntity.getToken().equals(tokenString)));

				// Check password is reset
				Assertions.assertTrue(passwordEncoder.matches(newPassword, userEntity.getPassword()));

				checkUserLoggedIn(resultActions.andReturn().getResponse(), username);

				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithManagementUser here] off begin
				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithManagementUser here] end

			} catch (Exception except) {
				Assertions.fail("Failed to find data from database.");
			}
		});

		// % protected region % [Add any additional asserts in resetPasswordWithManagementUser here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithManagementUser here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithManagementUserEntity_tokenExpired() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithManagementUserEntity_shouldSucceedWith200();

		String username =  "managementUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithManagementUser here] off begin
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithManagementUser here] end

			body.put("username", username);

			UserEntity userEntity = this.managementUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			// Update date token to make it expired
			tokenEntity.setExpiryDateTime(OffsetDateTime.now().minusSeconds(1));
			tokenService.updateToken(tokenEntity);

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithManagementUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithManagementUser here] end
		});

		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithManagementUser here] off begin
		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithManagementUser here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithManagementUser here] off begin
		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithManagementUser here] end

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithManagementUser here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithManagementUser here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Token has expired. Please reset your password again.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithManagementUserEntity_tokenExpired here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithManagementUserEntity_tokenExpired here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithManagementUserEntity_tokenNotMatched() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithManagementUserEntity_shouldSucceedWith200();

		String username =  "managementUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("token", UUID.randomUUID().toString());
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in resetPasswordWithManagementUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before sending response in resetPasswordWithManagementUserEntity_tokenNotMatched here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in resetPasswordWithManagementUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic after sending response in resetPasswordWithManagementUserEntity_tokenNotMatched here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Reset password tokens do not match";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithManagementUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithManagementUserEntity_tokenNotMatched here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithManagementUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithManagementUserEntity_tokenNotMatched here] end
	}

	@Test
	public void resetPasswordWithMedicalRecordUserEntity_shouldSucceedWith200() throws Exception {



		String username =  "medicalRecordUser@example.com";
		String newPassword = "new_password";

		// Sending request and create token first
		sendToRequestResetPassword(username);

		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {

			body.put("username", username);

			UserEntity userEntity = this.medicalRecordUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithMedicalRecordUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithMedicalRecordUser here] end
		});

		ResultActions resultActions = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);


		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic after sending request in resetPasswordWithMedicalRecordUser here] off begin
			// % protected region % [Add any additional logic after sending request in resetPasswordWithMedicalRecordUser here] end

			UserEntity userEntity = this.medicalRecordUserService.findByEmail(username).orElseThrow();

			List<String> expectedRoles = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
			try {
				RequestUtil.checkSuccessfulLoginResponse(resultActions, userEntity.getId().toString(), username, expectedRoles);

				// Check whether token is remove
				String tokenString = (String) body.get("token");
				Assertions.assertTrue(tokenService.findByToken(tokenString).isEmpty());
				Assertions.assertTrue(userEntity.getResetPasswordToken().stream().noneMatch(tokenEntity -> tokenEntity.getToken().equals(tokenString)));

				// Check password is reset
				Assertions.assertTrue(passwordEncoder.matches(newPassword, userEntity.getPassword()));

				checkUserLoggedIn(resultActions.andReturn().getResponse(), username);

				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithMedicalRecordUser here] off begin
				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithMedicalRecordUser here] end

			} catch (Exception except) {
				Assertions.fail("Failed to find data from database.");
			}
		});

		// % protected region % [Add any additional asserts in resetPasswordWithMedicalRecordUser here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithMedicalRecordUser here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithMedicalRecordUserEntity_tokenExpired() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithMedicalRecordUserEntity_shouldSucceedWith200();

		String username =  "medicalRecordUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithMedicalRecordUser here] off begin
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithMedicalRecordUser here] end

			body.put("username", username);

			UserEntity userEntity = this.medicalRecordUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			// Update date token to make it expired
			tokenEntity.setExpiryDateTime(OffsetDateTime.now().minusSeconds(1));
			tokenService.updateToken(tokenEntity);

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithMedicalRecordUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithMedicalRecordUser here] end
		});

		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithMedicalRecordUser here] off begin
		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithMedicalRecordUser here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithMedicalRecordUser here] off begin
		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithMedicalRecordUser here] end

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithMedicalRecordUser here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithMedicalRecordUser here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Token has expired. Please reset your password again.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithMedicalRecordUserEntity_tokenExpired here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithMedicalRecordUserEntity_tokenExpired here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithMedicalRecordUserEntity_tokenNotMatched() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithMedicalRecordUserEntity_shouldSucceedWith200();

		String username =  "medicalRecordUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("token", UUID.randomUUID().toString());
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in resetPasswordWithMedicalRecordUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before sending response in resetPasswordWithMedicalRecordUserEntity_tokenNotMatched here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in resetPasswordWithMedicalRecordUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic after sending response in resetPasswordWithMedicalRecordUserEntity_tokenNotMatched here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Reset password tokens do not match";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithMedicalRecordUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithMedicalRecordUserEntity_tokenNotMatched here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithMedicalRecordUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithMedicalRecordUserEntity_tokenNotMatched here] end
	}

	@Test
	public void resetPasswordWithMedicalTranscriberUserEntity_shouldSucceedWith200() throws Exception {



		String username =  "medicalTranscriberUser@example.com";
		String newPassword = "new_password";

		// Sending request and create token first
		sendToRequestResetPassword(username);

		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {

			body.put("username", username);

			UserEntity userEntity = this.medicalTranscriberUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithMedicalTranscriberUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithMedicalTranscriberUser here] end
		});

		ResultActions resultActions = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);


		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic after sending request in resetPasswordWithMedicalTranscriberUser here] off begin
			// % protected region % [Add any additional logic after sending request in resetPasswordWithMedicalTranscriberUser here] end

			UserEntity userEntity = this.medicalTranscriberUserService.findByEmail(username).orElseThrow();

			List<String> expectedRoles = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
			try {
				RequestUtil.checkSuccessfulLoginResponse(resultActions, userEntity.getId().toString(), username, expectedRoles);

				// Check whether token is remove
				String tokenString = (String) body.get("token");
				Assertions.assertTrue(tokenService.findByToken(tokenString).isEmpty());
				Assertions.assertTrue(userEntity.getResetPasswordToken().stream().noneMatch(tokenEntity -> tokenEntity.getToken().equals(tokenString)));

				// Check password is reset
				Assertions.assertTrue(passwordEncoder.matches(newPassword, userEntity.getPassword()));

				checkUserLoggedIn(resultActions.andReturn().getResponse(), username);

				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithMedicalTranscriberUser here] off begin
				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithMedicalTranscriberUser here] end

			} catch (Exception except) {
				Assertions.fail("Failed to find data from database.");
			}
		});

		// % protected region % [Add any additional asserts in resetPasswordWithMedicalTranscriberUser here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithMedicalTranscriberUser here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithMedicalTranscriberUserEntity_tokenExpired() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithMedicalTranscriberUserEntity_shouldSucceedWith200();

		String username =  "medicalTranscriberUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithMedicalTranscriberUser here] off begin
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithMedicalTranscriberUser here] end

			body.put("username", username);

			UserEntity userEntity = this.medicalTranscriberUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			// Update date token to make it expired
			tokenEntity.setExpiryDateTime(OffsetDateTime.now().minusSeconds(1));
			tokenService.updateToken(tokenEntity);

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithMedicalTranscriberUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithMedicalTranscriberUser here] end
		});

		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithMedicalTranscriberUser here] off begin
		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithMedicalTranscriberUser here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithMedicalTranscriberUser here] off begin
		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithMedicalTranscriberUser here] end

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithMedicalTranscriberUser here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithMedicalTranscriberUser here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Token has expired. Please reset your password again.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithMedicalTranscriberUserEntity_tokenExpired here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithMedicalTranscriberUserEntity_tokenExpired here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithMedicalTranscriberUserEntity_tokenNotMatched() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithMedicalTranscriberUserEntity_shouldSucceedWith200();

		String username =  "medicalTranscriberUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("token", UUID.randomUUID().toString());
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in resetPasswordWithMedicalTranscriberUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before sending response in resetPasswordWithMedicalTranscriberUserEntity_tokenNotMatched here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in resetPasswordWithMedicalTranscriberUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic after sending response in resetPasswordWithMedicalTranscriberUserEntity_tokenNotMatched here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Reset password tokens do not match";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithMedicalTranscriberUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithMedicalTranscriberUserEntity_tokenNotMatched here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithMedicalTranscriberUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithMedicalTranscriberUserEntity_tokenNotMatched here] end
	}

	@Test
	public void resetPasswordWithNurseUserEntity_shouldSucceedWith200() throws Exception {



		String username =  "nurseUser@example.com";
		String newPassword = "new_password";

		// Sending request and create token first
		sendToRequestResetPassword(username);

		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {

			body.put("username", username);

			UserEntity userEntity = this.nurseUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithNurseUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithNurseUser here] end
		});

		ResultActions resultActions = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);


		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic after sending request in resetPasswordWithNurseUser here] off begin
			// % protected region % [Add any additional logic after sending request in resetPasswordWithNurseUser here] end

			UserEntity userEntity = this.nurseUserService.findByEmail(username).orElseThrow();

			List<String> expectedRoles = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
			try {
				RequestUtil.checkSuccessfulLoginResponse(resultActions, userEntity.getId().toString(), username, expectedRoles);

				// Check whether token is remove
				String tokenString = (String) body.get("token");
				Assertions.assertTrue(tokenService.findByToken(tokenString).isEmpty());
				Assertions.assertTrue(userEntity.getResetPasswordToken().stream().noneMatch(tokenEntity -> tokenEntity.getToken().equals(tokenString)));

				// Check password is reset
				Assertions.assertTrue(passwordEncoder.matches(newPassword, userEntity.getPassword()));

				checkUserLoggedIn(resultActions.andReturn().getResponse(), username);

				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithNurseUser here] off begin
				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithNurseUser here] end

			} catch (Exception except) {
				Assertions.fail("Failed to find data from database.");
			}
		});

		// % protected region % [Add any additional asserts in resetPasswordWithNurseUser here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithNurseUser here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithNurseUserEntity_tokenExpired() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithNurseUserEntity_shouldSucceedWith200();

		String username =  "nurseUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithNurseUser here] off begin
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithNurseUser here] end

			body.put("username", username);

			UserEntity userEntity = this.nurseUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			// Update date token to make it expired
			tokenEntity.setExpiryDateTime(OffsetDateTime.now().minusSeconds(1));
			tokenService.updateToken(tokenEntity);

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithNurseUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithNurseUser here] end
		});

		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithNurseUser here] off begin
		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithNurseUser here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithNurseUser here] off begin
		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithNurseUser here] end

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithNurseUser here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithNurseUser here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Token has expired. Please reset your password again.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithNurseUserEntity_tokenExpired here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithNurseUserEntity_tokenExpired here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithNurseUserEntity_tokenNotMatched() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithNurseUserEntity_shouldSucceedWith200();

		String username =  "nurseUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("token", UUID.randomUUID().toString());
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in resetPasswordWithNurseUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before sending response in resetPasswordWithNurseUserEntity_tokenNotMatched here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in resetPasswordWithNurseUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic after sending response in resetPasswordWithNurseUserEntity_tokenNotMatched here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Reset password tokens do not match";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithNurseUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithNurseUserEntity_tokenNotMatched here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithNurseUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithNurseUserEntity_tokenNotMatched here] end
	}

	@Test
	public void resetPasswordWithPharmacyUserEntity_shouldSucceedWith200() throws Exception {



		String username =  "pharmacyUser@example.com";
		String newPassword = "new_password";

		// Sending request and create token first
		sendToRequestResetPassword(username);

		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {

			body.put("username", username);

			UserEntity userEntity = this.pharmacyUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithPharmacyUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithPharmacyUser here] end
		});

		ResultActions resultActions = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);


		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic after sending request in resetPasswordWithPharmacyUser here] off begin
			// % protected region % [Add any additional logic after sending request in resetPasswordWithPharmacyUser here] end

			UserEntity userEntity = this.pharmacyUserService.findByEmail(username).orElseThrow();

			List<String> expectedRoles = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
			try {
				RequestUtil.checkSuccessfulLoginResponse(resultActions, userEntity.getId().toString(), username, expectedRoles);

				// Check whether token is remove
				String tokenString = (String) body.get("token");
				Assertions.assertTrue(tokenService.findByToken(tokenString).isEmpty());
				Assertions.assertTrue(userEntity.getResetPasswordToken().stream().noneMatch(tokenEntity -> tokenEntity.getToken().equals(tokenString)));

				// Check password is reset
				Assertions.assertTrue(passwordEncoder.matches(newPassword, userEntity.getPassword()));

				checkUserLoggedIn(resultActions.andReturn().getResponse(), username);

				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithPharmacyUser here] off begin
				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithPharmacyUser here] end

			} catch (Exception except) {
				Assertions.fail("Failed to find data from database.");
			}
		});

		// % protected region % [Add any additional asserts in resetPasswordWithPharmacyUser here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithPharmacyUser here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithPharmacyUserEntity_tokenExpired() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithPharmacyUserEntity_shouldSucceedWith200();

		String username =  "pharmacyUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithPharmacyUser here] off begin
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithPharmacyUser here] end

			body.put("username", username);

			UserEntity userEntity = this.pharmacyUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			// Update date token to make it expired
			tokenEntity.setExpiryDateTime(OffsetDateTime.now().minusSeconds(1));
			tokenService.updateToken(tokenEntity);

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithPharmacyUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithPharmacyUser here] end
		});

		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithPharmacyUser here] off begin
		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithPharmacyUser here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithPharmacyUser here] off begin
		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithPharmacyUser here] end

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithPharmacyUser here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithPharmacyUser here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Token has expired. Please reset your password again.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithPharmacyUserEntity_tokenExpired here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithPharmacyUserEntity_tokenExpired here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithPharmacyUserEntity_tokenNotMatched() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithPharmacyUserEntity_shouldSucceedWith200();

		String username =  "pharmacyUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("token", UUID.randomUUID().toString());
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in resetPasswordWithPharmacyUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before sending response in resetPasswordWithPharmacyUserEntity_tokenNotMatched here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in resetPasswordWithPharmacyUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic after sending response in resetPasswordWithPharmacyUserEntity_tokenNotMatched here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Reset password tokens do not match";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithPharmacyUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithPharmacyUserEntity_tokenNotMatched here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithPharmacyUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithPharmacyUserEntity_tokenNotMatched here] end
	}

	@Test
	public void resetPasswordWithPurchasingUserEntity_shouldSucceedWith200() throws Exception {



		String username =  "purchasingUser@example.com";
		String newPassword = "new_password";

		// Sending request and create token first
		sendToRequestResetPassword(username);

		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {

			body.put("username", username);

			UserEntity userEntity = this.purchasingUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithPurchasingUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithPurchasingUser here] end
		});

		ResultActions resultActions = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);


		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic after sending request in resetPasswordWithPurchasingUser here] off begin
			// % protected region % [Add any additional logic after sending request in resetPasswordWithPurchasingUser here] end

			UserEntity userEntity = this.purchasingUserService.findByEmail(username).orElseThrow();

			List<String> expectedRoles = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
			try {
				RequestUtil.checkSuccessfulLoginResponse(resultActions, userEntity.getId().toString(), username, expectedRoles);

				// Check whether token is remove
				String tokenString = (String) body.get("token");
				Assertions.assertTrue(tokenService.findByToken(tokenString).isEmpty());
				Assertions.assertTrue(userEntity.getResetPasswordToken().stream().noneMatch(tokenEntity -> tokenEntity.getToken().equals(tokenString)));

				// Check password is reset
				Assertions.assertTrue(passwordEncoder.matches(newPassword, userEntity.getPassword()));

				checkUserLoggedIn(resultActions.andReturn().getResponse(), username);

				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithPurchasingUser here] off begin
				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithPurchasingUser here] end

			} catch (Exception except) {
				Assertions.fail("Failed to find data from database.");
			}
		});

		// % protected region % [Add any additional asserts in resetPasswordWithPurchasingUser here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithPurchasingUser here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithPurchasingUserEntity_tokenExpired() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithPurchasingUserEntity_shouldSucceedWith200();

		String username =  "purchasingUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithPurchasingUser here] off begin
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithPurchasingUser here] end

			body.put("username", username);

			UserEntity userEntity = this.purchasingUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			// Update date token to make it expired
			tokenEntity.setExpiryDateTime(OffsetDateTime.now().minusSeconds(1));
			tokenService.updateToken(tokenEntity);

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithPurchasingUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithPurchasingUser here] end
		});

		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithPurchasingUser here] off begin
		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithPurchasingUser here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithPurchasingUser here] off begin
		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithPurchasingUser here] end

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithPurchasingUser here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithPurchasingUser here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Token has expired. Please reset your password again.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithPurchasingUserEntity_tokenExpired here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithPurchasingUserEntity_tokenExpired here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithPurchasingUserEntity_tokenNotMatched() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithPurchasingUserEntity_shouldSucceedWith200();

		String username =  "purchasingUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("token", UUID.randomUUID().toString());
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in resetPasswordWithPurchasingUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before sending response in resetPasswordWithPurchasingUserEntity_tokenNotMatched here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in resetPasswordWithPurchasingUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic after sending response in resetPasswordWithPurchasingUserEntity_tokenNotMatched here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Reset password tokens do not match";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithPurchasingUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithPurchasingUserEntity_tokenNotMatched here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithPurchasingUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithPurchasingUserEntity_tokenNotMatched here] end
	}

	@Test
	public void resetPasswordWithRegistrationUserEntity_shouldSucceedWith200() throws Exception {



		String username =  "registrationUser@example.com";
		String newPassword = "new_password";

		// Sending request and create token first
		sendToRequestResetPassword(username);

		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {

			body.put("username", username);

			UserEntity userEntity = this.registrationUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithRegistrationUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithRegistrationUser here] end
		});

		ResultActions resultActions = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);


		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic after sending request in resetPasswordWithRegistrationUser here] off begin
			// % protected region % [Add any additional logic after sending request in resetPasswordWithRegistrationUser here] end

			UserEntity userEntity = this.registrationUserService.findByEmail(username).orElseThrow();

			List<String> expectedRoles = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
			try {
				RequestUtil.checkSuccessfulLoginResponse(resultActions, userEntity.getId().toString(), username, expectedRoles);

				// Check whether token is remove
				String tokenString = (String) body.get("token");
				Assertions.assertTrue(tokenService.findByToken(tokenString).isEmpty());
				Assertions.assertTrue(userEntity.getResetPasswordToken().stream().noneMatch(tokenEntity -> tokenEntity.getToken().equals(tokenString)));

				// Check password is reset
				Assertions.assertTrue(passwordEncoder.matches(newPassword, userEntity.getPassword()));

				checkUserLoggedIn(resultActions.andReturn().getResponse(), username);

				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithRegistrationUser here] off begin
				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithRegistrationUser here] end

			} catch (Exception except) {
				Assertions.fail("Failed to find data from database.");
			}
		});

		// % protected region % [Add any additional asserts in resetPasswordWithRegistrationUser here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithRegistrationUser here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithRegistrationUserEntity_tokenExpired() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithRegistrationUserEntity_shouldSucceedWith200();

		String username =  "registrationUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithRegistrationUser here] off begin
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithRegistrationUser here] end

			body.put("username", username);

			UserEntity userEntity = this.registrationUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			// Update date token to make it expired
			tokenEntity.setExpiryDateTime(OffsetDateTime.now().minusSeconds(1));
			tokenService.updateToken(tokenEntity);

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithRegistrationUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithRegistrationUser here] end
		});

		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithRegistrationUser here] off begin
		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithRegistrationUser here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithRegistrationUser here] off begin
		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithRegistrationUser here] end

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithRegistrationUser here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithRegistrationUser here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Token has expired. Please reset your password again.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithRegistrationUserEntity_tokenExpired here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithRegistrationUserEntity_tokenExpired here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithRegistrationUserEntity_tokenNotMatched() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithRegistrationUserEntity_shouldSucceedWith200();

		String username =  "registrationUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("token", UUID.randomUUID().toString());
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in resetPasswordWithRegistrationUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before sending response in resetPasswordWithRegistrationUserEntity_tokenNotMatched here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in resetPasswordWithRegistrationUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic after sending response in resetPasswordWithRegistrationUserEntity_tokenNotMatched here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Reset password tokens do not match";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithRegistrationUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithRegistrationUserEntity_tokenNotMatched here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithRegistrationUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithRegistrationUserEntity_tokenNotMatched here] end
	}

	@Test
	public void resetPasswordWithSystemAdminUserEntity_shouldSucceedWith200() throws Exception {



		String username =  "systemAdminUser@example.com";
		String newPassword = "new_password";

		// Sending request and create token first
		sendToRequestResetPassword(username);

		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {

			body.put("username", username);

			UserEntity userEntity = this.systemAdminUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithSystemAdminUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithSystemAdminUser here] end
		});

		ResultActions resultActions = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);


		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic after sending request in resetPasswordWithSystemAdminUser here] off begin
			// % protected region % [Add any additional logic after sending request in resetPasswordWithSystemAdminUser here] end

			UserEntity userEntity = this.systemAdminUserService.findByEmail(username).orElseThrow();

			List<String> expectedRoles = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
			try {
				RequestUtil.checkSuccessfulLoginResponse(resultActions, userEntity.getId().toString(), username, expectedRoles);

				// Check whether token is remove
				String tokenString = (String) body.get("token");
				Assertions.assertTrue(tokenService.findByToken(tokenString).isEmpty());
				Assertions.assertTrue(userEntity.getResetPasswordToken().stream().noneMatch(tokenEntity -> tokenEntity.getToken().equals(tokenString)));

				// Check password is reset
				Assertions.assertTrue(passwordEncoder.matches(newPassword, userEntity.getPassword()));

				checkUserLoggedIn(resultActions.andReturn().getResponse(), username);

				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithSystemAdminUser here] off begin
				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithSystemAdminUser here] end

			} catch (Exception except) {
				Assertions.fail("Failed to find data from database.");
			}
		});

		// % protected region % [Add any additional asserts in resetPasswordWithSystemAdminUser here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithSystemAdminUser here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithSystemAdminUserEntity_tokenExpired() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithSystemAdminUserEntity_shouldSucceedWith200();

		String username =  "systemAdminUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithSystemAdminUser here] off begin
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithSystemAdminUser here] end

			body.put("username", username);

			UserEntity userEntity = this.systemAdminUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			// Update date token to make it expired
			tokenEntity.setExpiryDateTime(OffsetDateTime.now().minusSeconds(1));
			tokenService.updateToken(tokenEntity);

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithSystemAdminUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithSystemAdminUser here] end
		});

		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithSystemAdminUser here] off begin
		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithSystemAdminUser here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithSystemAdminUser here] off begin
		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithSystemAdminUser here] end

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithSystemAdminUser here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithSystemAdminUser here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Token has expired. Please reset your password again.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithSystemAdminUserEntity_tokenExpired here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithSystemAdminUserEntity_tokenExpired here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithSystemAdminUserEntity_tokenNotMatched() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithSystemAdminUserEntity_shouldSucceedWith200();

		String username =  "systemAdminUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("token", UUID.randomUUID().toString());
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in resetPasswordWithSystemAdminUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before sending response in resetPasswordWithSystemAdminUserEntity_tokenNotMatched here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in resetPasswordWithSystemAdminUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic after sending response in resetPasswordWithSystemAdminUserEntity_tokenNotMatched here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Reset password tokens do not match";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithSystemAdminUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithSystemAdminUserEntity_tokenNotMatched here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithSystemAdminUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithSystemAdminUserEntity_tokenNotMatched here] end
	}

	@Test
	public void resetPasswordWithWarehouseUserEntity_shouldSucceedWith200() throws Exception {



		String username =  "warehouseUser@example.com";
		String newPassword = "new_password";

		// Sending request and create token first
		sendToRequestResetPassword(username);

		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {

			body.put("username", username);

			UserEntity userEntity = this.warehouseUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithWarehouseUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in resetPasswordWithWarehouseUser here] end
		});

		ResultActions resultActions = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);


		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic after sending request in resetPasswordWithWarehouseUser here] off begin
			// % protected region % [Add any additional logic after sending request in resetPasswordWithWarehouseUser here] end

			UserEntity userEntity = this.warehouseUserService.findByEmail(username).orElseThrow();

			List<String> expectedRoles = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
			try {
				RequestUtil.checkSuccessfulLoginResponse(resultActions, userEntity.getId().toString(), username, expectedRoles);

				// Check whether token is remove
				String tokenString = (String) body.get("token");
				Assertions.assertTrue(tokenService.findByToken(tokenString).isEmpty());
				Assertions.assertTrue(userEntity.getResetPasswordToken().stream().noneMatch(tokenEntity -> tokenEntity.getToken().equals(tokenString)));

				// Check password is reset
				Assertions.assertTrue(passwordEncoder.matches(newPassword, userEntity.getPassword()));

				checkUserLoggedIn(resultActions.andReturn().getResponse(), username);

				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithWarehouseUser here] off begin
				// % protected region % [Add any additional logic in runAnonymously after sending request in resetPasswordWithWarehouseUser here] end

			} catch (Exception except) {
				Assertions.fail("Failed to find data from database.");
			}
		});

		// % protected region % [Add any additional asserts in resetPasswordWithWarehouseUser here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithWarehouseUser here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithWarehouseUserEntity_tokenExpired() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithWarehouseUserEntity_shouldSucceedWith200();

		String username =  "warehouseUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithWarehouseUser here] off begin
			// % protected region % [Add any additional logic before query from service in requestToResetPasswordWithWarehouseUser here] end

			body.put("username", username);

			UserEntity userEntity = this.warehouseUserService.findByEmail(username).orElseThrow();
			TokenEntity tokenEntity = userEntity.getResetPasswordToken().iterator().next();

			// Update date token to make it expired
			tokenEntity.setExpiryDateTime(OffsetDateTime.now().minusSeconds(1));
			tokenService.updateToken(tokenEntity);

			body.put("token", tokenEntity.getToken());
			body.put("password", newPassword);

			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithWarehouseUser here] off begin
			// % protected region % [Add any additional logic in runAnonymously in requestToResetPasswordWithWarehouseUser here] end
		});

		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithWarehouseUser here] off begin
		// % protected region % [Add any additional logic before sendRequestByEndpoint in requestToResetPasswordWithWarehouseUser here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithWarehouseUser here] off begin
		// % protected region % [Add any additional logic after sendRequestByEndpoint in requestToResetPasswordWithWarehouseUser here] end

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithWarehouseUser here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in requestToResetPasswordWithWarehouseUser here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Token has expired. Please reset your password again.";
		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithWarehouseUserEntity_tokenExpired here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithWarehouseUserEntity_tokenExpired here] end
	}

	@Test
	@DirtiesContext
	public void resetPasswordWithWarehouseUserEntity_tokenNotMatched() throws Exception {

		// Request a new token
		this.requestToResetPasswordWithWarehouseUserEntity_shouldSucceedWith200();

		String username =  "warehouseUser@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("token", UUID.randomUUID().toString());
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in resetPasswordWithWarehouseUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before sending response in resetPasswordWithWarehouseUserEntity_tokenNotMatched here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in resetPasswordWithWarehouseUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic after sending response in resetPasswordWithWarehouseUserEntity_tokenNotMatched here] end

		String expectedError = "token_invalid";
		String expectedErrorDescription = "Reset password tokens do not match";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithWarehouseUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in resetPasswordWithWarehouseUserEntity_tokenNotMatched here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.UNAUTHORIZED);

		// % protected region % [Add any additional asserts in resetPasswordWithWarehouseUserEntity_tokenNotMatched here] off begin
		// % protected region % [Add any additional asserts in resetPasswordWithWarehouseUserEntity_tokenNotMatched here] end
	}

	@Test
	public void testResetPassword_withMissingArguments() throws Exception {
		String username =  "admin@example.com";
		String newPassword = "new_password";
		Map<String, Object> body = new HashMap<>();

		body.put("username", username);
		body.put("password", newPassword);

		// % protected region % [Add any additional logic before sending response in testResetPassword_withMissingArguments here] off begin
		// % protected region % [Add any additional logic before sending response in testResetPassword_withMissingArguments here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, resetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending response in testResetPassword_withMissingArguments here] off begin
		// % protected region % [Add any additional logic after sending response in testResetPassword_withMissingArguments here] end

		String expectedError = "missing_arguments";
		String expectedErrorDescription = "Token is missing from the request.";

		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in testResetPassword_withMissingArguments here] off begin
		// % protected region % [Add any additional logic before RequestUtil.checkErrorResponse in testResetPassword_withMissingArguments here] end

		RequestUtil.checkErrorResponse(result, expectedError, expectedErrorDescription, HttpStatus.BAD_REQUEST);

		// % protected region % [Add any additional asserts in testResetPassword_withMissingArguments here] off begin
		// % protected region % [Add any additional asserts in testResetPassword_withMissingArguments here] end
	}

	/**
	 * Sending a mock request to reuqest to reeset password
	 * @param username Username to reset password
	 * @throws Exception Exception thrown when trying to send request
	 */
	private ResultActions sendToRequestResetPassword(String username) throws Exception {
		Map<String, Object> body = new HashMap<>();
		body.put("username", username);

		// % protected region % [Add any additional logic before sending request in sendToRequestResetPassword here] off begin
		// % protected region % [Add any additional logic before sending request in sendToRequestResetPassword here] end

		ResultActions result = RequestUtil.sendRequestByEndpointWithJsonBody(mvc, requestResetPasswordEndpoint, body);

		// % protected region % [Add any additional logic after sending request in sendToRequestResetPassword here] off begin
		// % protected region % [Add any additional logic after sending request in sendToRequestResetPassword here] end

		return result;
	}

	/**
	 * Check Whether email is sent, and content in email
	 * @throws MessagingException Error being thrown by SMTP server.
	 */
	private void checkResetPasswordEmail(String userName, String email, TokenEntity tokenEntity) throws MessagingException {
		// % protected region % [Add any additional logic before checkResetPasswordEmail here] off begin
		// % protected region % [Add any additional logic before checkResetPasswordEmail here] end

		// Check Smtp Server and get email
		MimeMessage[] receivedMessages = smtpServerRule.getMessages();
		Assertions.assertEquals(1, receivedMessages.length);
		MimeMessage resetPasswordEmail = receivedMessages[0];
		Assertions.assertEquals("Reset Password", resetPasswordEmail.getSubject());
		String emailContent = GreenMailUtil.getBody(resetPasswordEmail);

		String greetingMessage = String.format("Hi %s,", userName);
		Assertions.assertTrue(emailContent.contains(greetingMessage));

		String resetPasswordUrl = generateResetPasswordUrl(tokenEntity, email);
		Assertions.assertTrue(emailContent.contains(String.format("<a class=\"btn\" href=\"%s\">Reset Password</a>", resetPasswordUrl)));

		// % protected region % [Add any additional logic after checkResetPasswordEmail here] off begin
		// % protected region % [Add any additional logic after checkResetPasswordEmail here] end
	}

	/**
	 * Generate token for reset password token in client side
	 */
	private String generateResetPasswordUrl(TokenEntity tokenEntity, String username) {
		String url = String.format("%s/reset-password?token=%s&username=%s", applicationProperties.getClientSideHost(), tokenEntity.getToken(), username);

		// % protected region % [Add any additional logic in generateResetPasswordUrl here] off begin
		// % protected region % [Add any additional logic in generateResetPasswordUrl here] end

		return url;
	}

	/**
	 * Check whether whether could use cookie in response for authentication
	 * @param httpServletResponse Response after reset password
	 * @param username
	 */
	private void checkUserLoggedIn(MockHttpServletResponse httpServletResponse, String username) {

		MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();

		httpServletRequest.setCookies(httpServletResponse.getCookies());

		// Check whether user is authenticated in server with cookie in response
		Authentication authentication =  this.authenticationService.getAuthentication(httpServletRequest);
		Assertions.assertEquals(authentication.getName(), username);

		// Check whether csrf token i valid
		var csrfToken = this.xsrfTokenRepository.loadToken(httpServletRequest);
		Assertions.assertNotNull(csrfToken);
		Assertions.assertNotNull(csrfToken.getToken());

		// % protected region % [Add any additional logic in checkUserLoggedIn here] off begin
		// % protected region % [Add any additional logic in checkUserLoggedIn here] end
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}
