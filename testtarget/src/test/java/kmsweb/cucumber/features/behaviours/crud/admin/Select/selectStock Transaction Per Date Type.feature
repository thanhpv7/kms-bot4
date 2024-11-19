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
@crud @select @stockTransactionPerDateType
Feature: Select StockTransactionPerDateType in Crud tile as admin user
	Scenario: Select StockTransactionPerDateType in Crud tile as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "StockTransactionPerDateType" backend page
			And I create 2 "StockTransactionPerDateType" entities
			And I am on the "StockTransactionPerDateType" backend page
		When I "Select" an existing "StockTransactionPerDateType"
		Then The "StockTransactionPerDateType" collection options bar is present
			And The Select All Items button is present in the "StockTransactionPerDateType" collection options bar
			And I expect that 1 "StockTransactionPerDateType" entity is selected in the collection options bar

	Scenario: Selection in Admin StockTransactionPerDateType Crud Tile persists through page changes
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "StockTransactionPerDateType" backend page
			And I create 11 "StockTransactionPerDateType" entities
			And I am on the "StockTransactionPerDateType" backend page
		When I "Select" an existing "StockTransactionPerDateType"
			And I click the next page button on the "StockTransactionPerDateType" page
		Then I expect that 1 "StockTransactionPerDateType" entity is selected in the collection options bar

	Scenario: Select all StockTransactionPerDateType Entities as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "StockTransactionPerDateType" backend page
			And I create 11 "StockTransactionPerDateType" entities
			And I am on the "StockTransactionPerDateType" backend page
		When I "Select" an existing "StockTransactionPerDateType"
			And I select all "StockTransactionPerDateType" entities
		Then I expect that every "StockTransactionPerDateType" entity is selected

	Scenario: Deselect all StockTransactionPerDateType Entities as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "StockTransactionPerDateType" backend page
			And I create 11 "StockTransactionPerDateType" entities
			And I am on the "StockTransactionPerDateType" backend page
		When I "Select" an existing "StockTransactionPerDateType"
			And I select all "StockTransactionPerDateType" entities
			And I click the cancel button on the "StockTransactionPerDateType" page
		Then I expect that every "StockTransactionPerDateType" entity is deselected