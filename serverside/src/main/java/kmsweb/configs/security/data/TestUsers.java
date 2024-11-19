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
package kmsweb.configs.security.data;

import kmsweb.configs.security.helpers.AnonymousHelper;
import kmsweb.configs.security.helpers.RoleAndPrivilegeHelper;
import kmsweb.configs.security.repositories.UserRepository;
import kmsweb.entities.*;
import kmsweb.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

import static kmsweb.configs.security.helpers.RoleAndPrivilegeHelper.createOrUpdatePrivilege;

@Component
@Slf4j
@Order(1)
// % protected region % [Override your the selected profiles here] off begin
@Profile({"dev", "test"})
// % protected region % [Override your the selected profiles here] end
public class TestUsers implements ApplicationRunner {

	/*
	 * Base user repository
	 */
	private final UserRepository userRepository;
	private final AdministrationUserRepository administrationUserRepository;
	private final AdministratorRepository administratorRepository;
	private final CashierUserRepository cashierUserRepository;
	private final ClaimUserRepository claimUserRepository;
	private final DiagnosticSupportUserRepository diagnosticSupportUserRepository;
	private final DoctorUserRepository doctorUserRepository;
	private final FacilityUserRepository facilityUserRepository;
	private final ManagementUserRepository managementUserRepository;
	private final MedicalRecordUserRepository medicalRecordUserRepository;
	private final MedicalTranscriberUserRepository medicalTranscriberUserRepository;
	private final NurseUserRepository nurseUserRepository;
	private final PharmacyUserRepository pharmacyUserRepository;
	private final PurchasingUserRepository purchasingUserRepository;
	private final RegistrationUserRepository registrationUserRepository;
	private final SystemAdminUserRepository systemAdminUserRepository;
	private final WarehouseUserRepository warehouseUserRepository;
	private final RoleRepository roleRepository;

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public TestUsers(
			UserRepository userRepository,
			AdministrationUserRepository administrationUserRepository,
			AdministratorRepository administratorRepository,
			CashierUserRepository cashierUserRepository,
			ClaimUserRepository claimUserRepository,
			DiagnosticSupportUserRepository diagnosticSupportUserRepository,
			DoctorUserRepository doctorUserRepository,
			FacilityUserRepository facilityUserRepository,
			ManagementUserRepository managementUserRepository,
			MedicalRecordUserRepository medicalRecordUserRepository,
			MedicalTranscriberUserRepository medicalTranscriberUserRepository,
			NurseUserRepository nurseUserRepository,
			PharmacyUserRepository pharmacyUserRepository,
			PurchasingUserRepository purchasingUserRepository,
			RegistrationUserRepository registrationUserRepository,
			SystemAdminUserRepository systemAdminUserRepository,
			WarehouseUserRepository warehouseUserRepository,
			RoleRepository roleRepository,
			PasswordEncoder passwordEncoder
	) {
		this.userRepository = userRepository;
		this.administrationUserRepository = administrationUserRepository;
		this.administratorRepository = administratorRepository;
		this.cashierUserRepository = cashierUserRepository;
		this.claimUserRepository = claimUserRepository;
		this.diagnosticSupportUserRepository = diagnosticSupportUserRepository;
		this.doctorUserRepository = doctorUserRepository;
		this.facilityUserRepository = facilityUserRepository;
		this.managementUserRepository = managementUserRepository;
		this.medicalRecordUserRepository = medicalRecordUserRepository;
		this.medicalTranscriberUserRepository = medicalTranscriberUserRepository;
		this.nurseUserRepository = nurseUserRepository;
		this.pharmacyUserRepository = pharmacyUserRepository;
		this.purchasingUserRepository = purchasingUserRepository;
		this.registrationUserRepository = registrationUserRepository;
		this.systemAdminUserRepository = systemAdminUserRepository;
		this.warehouseUserRepository = warehouseUserRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		AnonymousHelper.runAnonymously(() -> {
			// % protected region % [Override the anonymous run logic here] off begin
			Map<String, RoleEntity> mappedRoles = new HashMap<>();
			Iterable<RoleEntity> roles = roleRepository.findAll();

			roles.forEach(roleEntity -> {
				mappedRoles.put(roleEntity.getName(), roleEntity);
			});

			setupSuperRoleAndAccount();
			setupTestAccounts(mappedRoles);
			// % protected region % [Override the anonymous run logic here] end
		});
	}

	private void setupSuperRoleAndAccount() {
		// Setup the super role and privilege, we add the ` ` to remove the chance of conflicts with other
		// user roles due to variation from the naming convention.
		final String superPrivilegeName = "ROLE_SUPER ADMIN";
		final String superRoleName = "SUPER ADMIN";

		Optional<RoleEntity> superRoleOpt = roleRepository.findByName(superRoleName);
		var superRoleEntity = superRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(superRoleName);
			return roleRepository.save(role);
		});

		Arrays.asList(RoleAndPrivilegeHelper.APPLICATION_ENTITY_NAMES).forEach((entityName) -> createOrUpdatePrivilege(
				superRoleEntity, entityName,
				// Do a text transform to be consistent with the security model defined ACLs
				superPrivilegeName + "_" + entityName.toUpperCase().replace("ENTITY", "_ENTITY"),
				true, true, true, true)
		);

		// We set the id to allow for accurate linking but separate it so that we can allow our lambda to consume final values
		var savedSuperRole = roleRepository.save(superRoleEntity);
		superRoleEntity.setId(savedSuperRole.getId());

		// Create a super user. A super user has full access to everything
		UserEntity superUser;
		if (userRepository.findByEmail("super@example.com").isEmpty()) {
			superUser = new UserEntity();
			superUser.setEmail("super@example.com");
			superUser.setUsername("super@example.com");
			superUser.setPassword(passwordEncoder.encode("password"));
			superUser.setIsArchived(false);
			superUser.setName("Super User");
		} else {
			superUser = userRepository.findByEmail("super@example.com").get();
		}

		superUser.setRoles(Collections.singletonList(superRoleEntity));

		userRepository.save(superUser);
	}

	/**
	 * Setup test accounts for ease of development.
	 */
	private void setupTestAccounts(Map<String, RoleEntity> roles) {

		if (administrationUserRepository.findByEmail("administrationUser@example.com").isEmpty()) {

			// % protected region % [Customise the user details of the seeded administrationUser test account here] off begin
			AdministrationUserEntity administrationUser = new AdministrationUserEntity();
			administrationUser.addRoles(roles.get("ADMINISTRATION_USER"));
			administrationUser.setEmail("administrationUser@example.com");
			administrationUser.setUsername("administrationUser@example.com");
			administrationUser.setPassword(passwordEncoder.encode("password"));
			administrationUser.setIsArchived(false);
			administrationUser.setName("Administration User");
			// % protected region % [Customise the user details of the seeded administrationUser test account here] end

			administrationUserRepository.save(administrationUser);

			// % protected region % [Customise the creation of the administrationUser test account here] off begin
			// % protected region % [Customise the creation of the administrationUser test account here] end
		}
		if (administratorRepository.findByEmail("administrator@example.com").isEmpty()) {

			// % protected region % [Customise the user details of the seeded administrator test account here] off begin
			AdministratorEntity administrator = new AdministratorEntity();
			administrator.addRoles(roles.get("ADMINISTRATOR"));
			administrator.setEmail("administrator@example.com");
			administrator.setUsername("administrator@example.com");
			administrator.setPassword(passwordEncoder.encode("password"));
			administrator.setIsArchived(false);
			administrator.setName("Administrator");
			// % protected region % [Customise the user details of the seeded administrator test account here] end

			administratorRepository.save(administrator);

			// % protected region % [Customise the creation of the administrator test account here] off begin
			// % protected region % [Customise the creation of the administrator test account here] end
		}
		if (cashierUserRepository.findByEmail("cashierUser@example.com").isEmpty()) {

			// % protected region % [Customise the user details of the seeded cashierUser test account here] off begin
			CashierUserEntity cashierUser = new CashierUserEntity();
			cashierUser.addRoles(roles.get("CASHIER_USER"));
			cashierUser.setEmail("cashierUser@example.com");
			cashierUser.setUsername("cashierUser@example.com");
			cashierUser.setPassword(passwordEncoder.encode("password"));
			cashierUser.setIsArchived(false);
			cashierUser.setName("Cashier User");
			// % protected region % [Customise the user details of the seeded cashierUser test account here] end

			cashierUserRepository.save(cashierUser);

			// % protected region % [Customise the creation of the cashierUser test account here] off begin
			// % protected region % [Customise the creation of the cashierUser test account here] end
		}
		if (claimUserRepository.findByEmail("claimUser@example.com").isEmpty()) {

			// % protected region % [Customise the user details of the seeded claimUser test account here] off begin
			ClaimUserEntity claimUser = new ClaimUserEntity();
			claimUser.addRoles(roles.get("CLAIM_USER"));
			claimUser.setEmail("claimUser@example.com");
			claimUser.setUsername("claimUser@example.com");
			claimUser.setPassword(passwordEncoder.encode("password"));
			claimUser.setIsArchived(false);
			claimUser.setName("Claim User");
			// % protected region % [Customise the user details of the seeded claimUser test account here] end

			claimUserRepository.save(claimUser);

			// % protected region % [Customise the creation of the claimUser test account here] off begin
			// % protected region % [Customise the creation of the claimUser test account here] end
		}
		if (diagnosticSupportUserRepository.findByEmail("diagnosticSupportUser@example.com").isEmpty()) {

			// % protected region % [Customise the user details of the seeded diagnosticSupportUser test account here] off begin
			DiagnosticSupportUserEntity diagnosticSupportUser = new DiagnosticSupportUserEntity();
			diagnosticSupportUser.addRoles(roles.get("DIAGNOSTIC_SUPPORT_USER"));
			diagnosticSupportUser.setEmail("diagnosticSupportUser@example.com");
			diagnosticSupportUser.setUsername("diagnosticSupportUser@example.com");
			diagnosticSupportUser.setPassword(passwordEncoder.encode("password"));
			diagnosticSupportUser.setIsArchived(false);
			diagnosticSupportUser.setName("Diagnostic Support User");
			// % protected region % [Customise the user details of the seeded diagnosticSupportUser test account here] end

			diagnosticSupportUserRepository.save(diagnosticSupportUser);

			// % protected region % [Customise the creation of the diagnosticSupportUser test account here] off begin
			// % protected region % [Customise the creation of the diagnosticSupportUser test account here] end
		}
		if (doctorUserRepository.findByEmail("doctorUser@example.com").isEmpty()) {

			// % protected region % [Customise the user details of the seeded doctorUser test account here] off begin
			DoctorUserEntity doctorUser = new DoctorUserEntity();
			doctorUser.addRoles(roles.get("DOCTOR_USER"));
			doctorUser.setEmail("doctorUser@example.com");
			doctorUser.setUsername("doctorUser@example.com");
			doctorUser.setPassword(passwordEncoder.encode("password"));
			doctorUser.setIsArchived(false);
			doctorUser.setName("Doctor User");
			// % protected region % [Customise the user details of the seeded doctorUser test account here] end

			doctorUserRepository.save(doctorUser);

			// % protected region % [Customise the creation of the doctorUser test account here] off begin
			// % protected region % [Customise the creation of the doctorUser test account here] end
		}
		if (facilityUserRepository.findByEmail("facilityUser@example.com").isEmpty()) {

			// % protected region % [Customise the user details of the seeded facilityUser test account here] off begin
			FacilityUserEntity facilityUser = new FacilityUserEntity();
			facilityUser.addRoles(roles.get("FACILITY_USER"));
			facilityUser.setEmail("facilityUser@example.com");
			facilityUser.setUsername("facilityUser@example.com");
			facilityUser.setPassword(passwordEncoder.encode("password"));
			facilityUser.setIsArchived(false);
			facilityUser.setName("Facility User");
			// % protected region % [Customise the user details of the seeded facilityUser test account here] end

			facilityUserRepository.save(facilityUser);

			// % protected region % [Customise the creation of the facilityUser test account here] off begin
			// % protected region % [Customise the creation of the facilityUser test account here] end
		}
		if (managementUserRepository.findByEmail("managementUser@example.com").isEmpty()) {

			// % protected region % [Customise the user details of the seeded managementUser test account here] off begin
			ManagementUserEntity managementUser = new ManagementUserEntity();
			managementUser.addRoles(roles.get("MANAGEMENT_USER"));
			managementUser.setEmail("managementUser@example.com");
			managementUser.setUsername("managementUser@example.com");
			managementUser.setPassword(passwordEncoder.encode("password"));
			managementUser.setIsArchived(false);
			managementUser.setName("Management User");
			// % protected region % [Customise the user details of the seeded managementUser test account here] end

			managementUserRepository.save(managementUser);

			// % protected region % [Customise the creation of the managementUser test account here] off begin
			// % protected region % [Customise the creation of the managementUser test account here] end
		}
		if (medicalRecordUserRepository.findByEmail("medicalRecordUser@example.com").isEmpty()) {

			// % protected region % [Customise the user details of the seeded medicalRecordUser test account here] off begin
			MedicalRecordUserEntity medicalRecordUser = new MedicalRecordUserEntity();
			medicalRecordUser.addRoles(roles.get("MEDICAL_RECORD_USER"));
			medicalRecordUser.setEmail("medicalRecordUser@example.com");
			medicalRecordUser.setUsername("medicalRecordUser@example.com");
			medicalRecordUser.setPassword(passwordEncoder.encode("password"));
			medicalRecordUser.setIsArchived(false);
			medicalRecordUser.setName("Medical Record user");
			// % protected region % [Customise the user details of the seeded medicalRecordUser test account here] end

			medicalRecordUserRepository.save(medicalRecordUser);

			// % protected region % [Customise the creation of the medicalRecordUser test account here] off begin
			// % protected region % [Customise the creation of the medicalRecordUser test account here] end
		}
		if (medicalTranscriberUserRepository.findByEmail("medicalTranscriberUser@example.com").isEmpty()) {

			// % protected region % [Customise the user details of the seeded medicalTranscriberUser test account here] off begin
			MedicalTranscriberUserEntity medicalTranscriberUser = new MedicalTranscriberUserEntity();
			medicalTranscriberUser.addRoles(roles.get("MEDICAL_TRANSCRIBER_USER"));
			medicalTranscriberUser.setEmail("medicalTranscriberUser@example.com");
			medicalTranscriberUser.setUsername("medicalTranscriberUser@example.com");
			medicalTranscriberUser.setPassword(passwordEncoder.encode("password"));
			medicalTranscriberUser.setIsArchived(false);
			medicalTranscriberUser.setName("Medical Transcriber User");
			// % protected region % [Customise the user details of the seeded medicalTranscriberUser test account here] end

			medicalTranscriberUserRepository.save(medicalTranscriberUser);

			// % protected region % [Customise the creation of the medicalTranscriberUser test account here] off begin
			// % protected region % [Customise the creation of the medicalTranscriberUser test account here] end
		}
		if (nurseUserRepository.findByEmail("nurseUser@example.com").isEmpty()) {

			// % protected region % [Customise the user details of the seeded nurseUser test account here] off begin
			NurseUserEntity nurseUser = new NurseUserEntity();
			nurseUser.addRoles(roles.get("NURSE_USER"));
			nurseUser.setEmail("nurseUser@example.com");
			nurseUser.setUsername("nurseUser@example.com");
			nurseUser.setPassword(passwordEncoder.encode("password"));
			nurseUser.setIsArchived(false);
			nurseUser.setName("Nurse User");
			// % protected region % [Customise the user details of the seeded nurseUser test account here] end

			nurseUserRepository.save(nurseUser);

			// % protected region % [Customise the creation of the nurseUser test account here] off begin
			// % protected region % [Customise the creation of the nurseUser test account here] end
		}
		if (pharmacyUserRepository.findByEmail("pharmacyUser@example.com").isEmpty()) {

			// % protected region % [Customise the user details of the seeded pharmacyUser test account here] off begin
			PharmacyUserEntity pharmacyUser = new PharmacyUserEntity();
			pharmacyUser.addRoles(roles.get("PHARMACY_USER"));
			pharmacyUser.setEmail("pharmacyUser@example.com");
			pharmacyUser.setUsername("pharmacyUser@example.com");
			pharmacyUser.setPassword(passwordEncoder.encode("password"));
			pharmacyUser.setIsArchived(false);
			pharmacyUser.setName("Pharmacy User");
			// % protected region % [Customise the user details of the seeded pharmacyUser test account here] end

			pharmacyUserRepository.save(pharmacyUser);

			// % protected region % [Customise the creation of the pharmacyUser test account here] off begin
			// % protected region % [Customise the creation of the pharmacyUser test account here] end
		}
		if (purchasingUserRepository.findByEmail("purchasingUser@example.com").isEmpty()) {

			// % protected region % [Customise the user details of the seeded purchasingUser test account here] off begin
			PurchasingUserEntity purchasingUser = new PurchasingUserEntity();
			purchasingUser.addRoles(roles.get("PURCHASING_USER"));
			purchasingUser.setEmail("purchasingUser@example.com");
			purchasingUser.setUsername("purchasingUser@example.com");
			purchasingUser.setPassword(passwordEncoder.encode("password"));
			purchasingUser.setIsArchived(false);
			purchasingUser.setName("Purchasing User");
			// % protected region % [Customise the user details of the seeded purchasingUser test account here] end

			purchasingUserRepository.save(purchasingUser);

			// % protected region % [Customise the creation of the purchasingUser test account here] off begin
			// % protected region % [Customise the creation of the purchasingUser test account here] end
		}
		if (registrationUserRepository.findByEmail("registrationUser@example.com").isEmpty()) {

			// % protected region % [Customise the user details of the seeded registrationUser test account here] off begin
			RegistrationUserEntity registrationUser = new RegistrationUserEntity();
			registrationUser.addRoles(roles.get("REGISTRATION_USER"));
			registrationUser.setEmail("registrationUser@example.com");
			registrationUser.setUsername("registrationUser@example.com");
			registrationUser.setPassword(passwordEncoder.encode("password"));
			registrationUser.setIsArchived(false);
			registrationUser.setName("Registration User");
			// % protected region % [Customise the user details of the seeded registrationUser test account here] end

			registrationUserRepository.save(registrationUser);

			// % protected region % [Customise the creation of the registrationUser test account here] off begin
			// % protected region % [Customise the creation of the registrationUser test account here] end
		}
		if (systemAdminUserRepository.findByEmail("systemAdminUser@example.com").isEmpty()) {

			// % protected region % [Customise the user details of the seeded systemAdminUser test account here] off begin
			SystemAdminUserEntity systemAdminUser = new SystemAdminUserEntity();
			systemAdminUser.addRoles(roles.get("SYSTEM_ADMIN_USER"));
			systemAdminUser.setEmail("systemAdminUser@example.com");
			systemAdminUser.setUsername("systemAdminUser@example.com");
			systemAdminUser.setPassword(passwordEncoder.encode("password"));
			systemAdminUser.setIsArchived(false);
			systemAdminUser.setName("System Admin User");
			// % protected region % [Customise the user details of the seeded systemAdminUser test account here] end

			systemAdminUserRepository.save(systemAdminUser);

			// % protected region % [Customise the creation of the systemAdminUser test account here] off begin
			// % protected region % [Customise the creation of the systemAdminUser test account here] end
		}
		if (warehouseUserRepository.findByEmail("warehouseUser@example.com").isEmpty()) {

			// % protected region % [Customise the user details of the seeded warehouseUser test account here] off begin
			WarehouseUserEntity warehouseUser = new WarehouseUserEntity();
			warehouseUser.addRoles(roles.get("WAREHOUSE_USER"));
			warehouseUser.setEmail("warehouseUser@example.com");
			warehouseUser.setUsername("warehouseUser@example.com");
			warehouseUser.setPassword(passwordEncoder.encode("password"));
			warehouseUser.setIsArchived(false);
			warehouseUser.setName("Warehouse User");
			// % protected region % [Customise the user details of the seeded warehouseUser test account here] end

			warehouseUserRepository.save(warehouseUser);

			// % protected region % [Customise the creation of the warehouseUser test account here] off begin
			// % protected region % [Customise the creation of the warehouseUser test account here] end
		}

		// % protected region % [Add additional test users here] off begin
		// % protected region % [Add additional test users here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}