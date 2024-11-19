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
@crud @select @cashAllocation
Feature: Select CashAllocation in Crud tile as admin user
	Scenario: Select CashAllocation in Crud tile as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "CashAllocation" backend page
			And I create 2 "CashAllocation" entities
			And I am on the "CashAllocation" backend page
		When I "Select" an existing "CashAllocation"
		Then The "CashAllocation" collection options bar is present
			And The Select All Items button is present in the "CashAllocation" collection options bar
			And I expect that 1 "CashAllocation" entity is selected in the collection options bar

	Scenario: Selection in Admin CashAllocation Crud Tile persists through page changes
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "CashAllocation" backend page
			And I create 11 "CashAllocation" entities
			And I am on the "CashAllocation" backend page
		When I "Select" an existing "CashAllocation"
			And I click the next page button on the "CashAllocation" page
		Then I expect that 1 "CashAllocation" entity is selected in the collection options bar

	Scenario: Select all CashAllocation Entities as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "CashAllocation" backend page
			And I create 11 "CashAllocation" entities
			And I am on the "CashAllocation" backend page
		When I "Select" an existing "CashAllocation"
			And I select all "CashAllocation" entities
		Then I expect that every "CashAllocation" entity is selected

	Scenario: Deselect all CashAllocation Entities as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "CashAllocation" backend page
			And I create 11 "CashAllocation" entities
			And I am on the "CashAllocation" backend page
		When I "Select" an existing "CashAllocation"
			And I select all "CashAllocation" entities
			And I click the cancel button on the "CashAllocation" page
		Then I expect that every "CashAllocation" entity is deselected