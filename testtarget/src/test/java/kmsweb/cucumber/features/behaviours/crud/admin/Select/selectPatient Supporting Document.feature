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
@crud @select @patientSupportingDocument
Feature: Select PatientSupportingDocument in Crud tile as admin user
	Scenario: Select PatientSupportingDocument in Crud tile as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "PatientSupportingDocument" backend page
			And I create 2 "PatientSupportingDocument" entities
			And I am on the "PatientSupportingDocument" backend page
		When I "Select" an existing "PatientSupportingDocument"
		Then The "PatientSupportingDocument" collection options bar is present
			And The Select All Items button is present in the "PatientSupportingDocument" collection options bar
			And I expect that 1 "PatientSupportingDocument" entity is selected in the collection options bar

	Scenario: Selection in Admin PatientSupportingDocument Crud Tile persists through page changes
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "PatientSupportingDocument" backend page
			And I create 11 "PatientSupportingDocument" entities
			And I am on the "PatientSupportingDocument" backend page
		When I "Select" an existing "PatientSupportingDocument"
			And I click the next page button on the "PatientSupportingDocument" page
		Then I expect that 1 "PatientSupportingDocument" entity is selected in the collection options bar

	Scenario: Select all PatientSupportingDocument Entities as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "PatientSupportingDocument" backend page
			And I create 11 "PatientSupportingDocument" entities
			And I am on the "PatientSupportingDocument" backend page
		When I "Select" an existing "PatientSupportingDocument"
			And I select all "PatientSupportingDocument" entities
		Then I expect that every "PatientSupportingDocument" entity is selected

	Scenario: Deselect all PatientSupportingDocument Entities as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "PatientSupportingDocument" backend page
			And I create 11 "PatientSupportingDocument" entities
			And I am on the "PatientSupportingDocument" backend page
		When I "Select" an existing "PatientSupportingDocument"
			And I select all "PatientSupportingDocument" entities
			And I click the cancel button on the "PatientSupportingDocument" page
		Then I expect that every "PatientSupportingDocument" entity is deselected