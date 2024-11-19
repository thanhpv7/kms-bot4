###
# @bot-written
#
# WARNING AND NOTICE
# Any access, download, storage, and/or use of this source code is subject to the terms and conditions of the
# Full Software Licence as accepted by you before being granted access to this source code and other materials,
# the terms of which can be accessed on the Codebots website at https://codebots.com/full-software-licence. Any
# commercial use in contravention of the terms of the Full Software Licence may be pursued by Codebots through
# licence termination and further legal action, and be required to indemnify Codebots for any loss or damage,
# including interest and costs. You are deemed to have accepted the terms of the Full Software Licence on any
# access, download, storage, and/or use of this source code.
#
# BOT WARNING
# This file is bot-written.
# Any changes out side of "protected regions" will be lost next time the bot makes any changes.
###
@botwritten
@login
Feature: Login

	# Test to ensure the login page exists and is providing feedback to users
	Scenario: Fail to login as an anonymous user
		Given I navigate to the login page
		When I login with username "anonymous-visitor@example.com" with password "password"
		Then I see the login page
		And I see a login error
		# % protected region % [Add additional steps for 'Login as anonymous user'] off begin
		# % protected region % [Add additional steps for 'Login as anonymous user'] end

	Scenario: Login as super user
		Given I navigate to the login page
		When I login with username "super@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as super user'] off begin
		# % protected region % [Add additional steps for 'Login as super user'] end

	Scenario: Login as normal Administration User user
		Given I navigate to the login page
		When I login with username "administrationUser@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as normal Administration User user'] off begin
		# % protected region % [Add additional steps for 'Login as normal Administration User user'] end

	Scenario: Login as normal Administrator user
		Given I navigate to the login page
		When I login with username "administrator@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as normal Administrator user'] off begin
		# % protected region % [Add additional steps for 'Login as normal Administrator user'] end

	Scenario: Login as normal Cashier User user
		Given I navigate to the login page
		When I login with username "cashierUser@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as normal Cashier User user'] off begin
		# % protected region % [Add additional steps for 'Login as normal Cashier User user'] end

	Scenario: Login as normal Claim User user
		Given I navigate to the login page
		When I login with username "claimUser@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as normal Claim User user'] off begin
		# % protected region % [Add additional steps for 'Login as normal Claim User user'] end

	Scenario: Login as normal Diagnostic Support User user
		Given I navigate to the login page
		When I login with username "diagnosticSupportUser@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as normal Diagnostic Support User user'] off begin
		# % protected region % [Add additional steps for 'Login as normal Diagnostic Support User user'] end

	Scenario: Login as normal Doctor User user
		Given I navigate to the login page
		When I login with username "doctorUser@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as normal Doctor User user'] off begin
		# % protected region % [Add additional steps for 'Login as normal Doctor User user'] end

	Scenario: Login as normal Facility User user
		Given I navigate to the login page
		When I login with username "facilityUser@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as normal Facility User user'] off begin
		# % protected region % [Add additional steps for 'Login as normal Facility User user'] end

	Scenario: Login as normal Management User user
		Given I navigate to the login page
		When I login with username "managementUser@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as normal Management User user'] off begin
		# % protected region % [Add additional steps for 'Login as normal Management User user'] end

	Scenario: Login as normal Medical Record user user
		Given I navigate to the login page
		When I login with username "medicalRecordUser@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as normal Medical Record user user'] off begin
		# % protected region % [Add additional steps for 'Login as normal Medical Record user user'] end

	Scenario: Login as normal Medical Transcriber User user
		Given I navigate to the login page
		When I login with username "medicalTranscriberUser@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as normal Medical Transcriber User user'] off begin
		# % protected region % [Add additional steps for 'Login as normal Medical Transcriber User user'] end

	Scenario: Login as normal Nurse User user
		Given I navigate to the login page
		When I login with username "nurseUser@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as normal Nurse User user'] off begin
		# % protected region % [Add additional steps for 'Login as normal Nurse User user'] end

	Scenario: Login as normal Pharmacy User user
		Given I navigate to the login page
		When I login with username "pharmacyUser@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as normal Pharmacy User user'] off begin
		# % protected region % [Add additional steps for 'Login as normal Pharmacy User user'] end

	Scenario: Login as normal Purchasing User user
		Given I navigate to the login page
		When I login with username "purchasingUser@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as normal Purchasing User user'] off begin
		# % protected region % [Add additional steps for 'Login as normal Purchasing User user'] end

	Scenario: Login as normal Registration User user
		Given I navigate to the login page
		When I login with username "registrationUser@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as normal Registration User user'] off begin
		# % protected region % [Add additional steps for 'Login as normal Registration User user'] end

	Scenario: Login as normal System Admin User user
		Given I navigate to the login page
		When I login with username "systemAdminUser@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as normal System Admin User user'] off begin
		# % protected region % [Add additional steps for 'Login as normal System Admin User user'] end

	Scenario: Login as normal Warehouse User user
		Given I navigate to the login page
		When I login with username "warehouseUser@example.com" with password "password"
		Then I see the homepage
		# % protected region % [Add additional steps for 'Login as normal Warehouse User user'] off begin
		# % protected region % [Add additional steps for 'Login as normal Warehouse User user'] end

# % protected region % [Add additional scenarios for login feature] off begin
# % protected region % [Add additional scenarios for login feature] end

