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
@crud @select @compoundPrescriptionItem
Feature: Select CompoundPrescriptionItem in Crud tile as admin user
	Scenario: Select CompoundPrescriptionItem in Crud tile as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "CompoundPrescriptionItem" backend page
			And I create 2 "CompoundPrescriptionItem" entities
			And I am on the "CompoundPrescriptionItem" backend page
		When I "Select" an existing "CompoundPrescriptionItem"
		Then The "CompoundPrescriptionItem" collection options bar is present
			And The Select All Items button is present in the "CompoundPrescriptionItem" collection options bar
			And I expect that 1 "CompoundPrescriptionItem" entity is selected in the collection options bar

	Scenario: Selection in Admin CompoundPrescriptionItem Crud Tile persists through page changes
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "CompoundPrescriptionItem" backend page
			And I create 11 "CompoundPrescriptionItem" entities
			And I am on the "CompoundPrescriptionItem" backend page
		When I "Select" an existing "CompoundPrescriptionItem"
			And I click the next page button on the "CompoundPrescriptionItem" page
		Then I expect that 1 "CompoundPrescriptionItem" entity is selected in the collection options bar

	Scenario: Select all CompoundPrescriptionItem Entities as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "CompoundPrescriptionItem" backend page
			And I create 11 "CompoundPrescriptionItem" entities
			And I am on the "CompoundPrescriptionItem" backend page
		When I "Select" an existing "CompoundPrescriptionItem"
			And I select all "CompoundPrescriptionItem" entities
		Then I expect that every "CompoundPrescriptionItem" entity is selected

	Scenario: Deselect all CompoundPrescriptionItem Entities as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "CompoundPrescriptionItem" backend page
			And I create 11 "CompoundPrescriptionItem" entities
			And I am on the "CompoundPrescriptionItem" backend page
		When I "Select" an existing "CompoundPrescriptionItem"
			And I select all "CompoundPrescriptionItem" entities
			And I click the cancel button on the "CompoundPrescriptionItem" page
		Then I expect that every "CompoundPrescriptionItem" entity is deselected