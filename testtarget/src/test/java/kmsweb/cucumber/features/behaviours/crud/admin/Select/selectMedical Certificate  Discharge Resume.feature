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
@crud @select @medicalCertificateDischargeResume
Feature: Select MedicalCertificateDischargeResume in Crud tile as admin user
	Scenario: Select MedicalCertificateDischargeResume in Crud tile as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "MedicalCertificateDischargeResume" backend page
			And I create 2 "MedicalCertificateDischargeResume" entities
			And I am on the "MedicalCertificateDischargeResume" backend page
		When I "Select" an existing "MedicalCertificateDischargeResume"
		Then The "MedicalCertificateDischargeResume" collection options bar is present
			And The Select All Items button is present in the "MedicalCertificateDischargeResume" collection options bar
			And I expect that 1 "MedicalCertificateDischargeResume" entity is selected in the collection options bar

	Scenario: Selection in Admin MedicalCertificateDischargeResume Crud Tile persists through page changes
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "MedicalCertificateDischargeResume" backend page
			And I create 11 "MedicalCertificateDischargeResume" entities
			And I am on the "MedicalCertificateDischargeResume" backend page
		When I "Select" an existing "MedicalCertificateDischargeResume"
			And I click the next page button on the "MedicalCertificateDischargeResume" page
		Then I expect that 1 "MedicalCertificateDischargeResume" entity is selected in the collection options bar

	Scenario: Select all MedicalCertificateDischargeResume Entities as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "MedicalCertificateDischargeResume" backend page
			And I create 11 "MedicalCertificateDischargeResume" entities
			And I am on the "MedicalCertificateDischargeResume" backend page
		When I "Select" an existing "MedicalCertificateDischargeResume"
			And I select all "MedicalCertificateDischargeResume" entities
		Then I expect that every "MedicalCertificateDischargeResume" entity is selected

	Scenario: Deselect all MedicalCertificateDischargeResume Entities as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "MedicalCertificateDischargeResume" backend page
			And I create 11 "MedicalCertificateDischargeResume" entities
			And I am on the "MedicalCertificateDischargeResume" backend page
		When I "Select" an existing "MedicalCertificateDischargeResume"
			And I select all "MedicalCertificateDischargeResume" entities
			And I click the cancel button on the "MedicalCertificateDischargeResume" page
		Then I expect that every "MedicalCertificateDischargeResume" entity is deselected