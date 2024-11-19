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
@crud @select @bpjsPRB
Feature: Select BpjsPRB in Crud tile as admin user
	Scenario: Select BpjsPRB in Crud tile as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "BpjsPRB" backend page
			And I create 2 "BpjsPRB" entities
			And I am on the "BpjsPRB" backend page
		When I "Select" an existing "BpjsPRB"
		Then The "BpjsPRB" collection options bar is present
			And The Select All Items button is present in the "BpjsPRB" collection options bar
			And I expect that 1 "BpjsPRB" entity is selected in the collection options bar

	Scenario: Selection in Admin BpjsPRB Crud Tile persists through page changes
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "BpjsPRB" backend page
			And I create 11 "BpjsPRB" entities
			And I am on the "BpjsPRB" backend page
		When I "Select" an existing "BpjsPRB"
			And I click the next page button on the "BpjsPRB" page
		Then I expect that 1 "BpjsPRB" entity is selected in the collection options bar

	Scenario: Select all BpjsPRB Entities as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "BpjsPRB" backend page
			And I create 11 "BpjsPRB" entities
			And I am on the "BpjsPRB" backend page
		When I "Select" an existing "BpjsPRB"
			And I select all "BpjsPRB" entities
		Then I expect that every "BpjsPRB" entity is selected

	Scenario: Deselect all BpjsPRB Entities as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "BpjsPRB" backend page
			And I create 11 "BpjsPRB" entities
			And I am on the "BpjsPRB" backend page
		When I "Select" an existing "BpjsPRB"
			And I select all "BpjsPRB" entities
			And I click the cancel button on the "BpjsPRB" page
		Then I expect that every "BpjsPRB" entity is deselected