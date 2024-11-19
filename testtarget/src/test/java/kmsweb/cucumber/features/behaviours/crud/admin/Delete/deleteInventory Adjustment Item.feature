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
@crud @delete @inventoryAdjustmentItem
Feature: Delete Inventory Adjustment Item as admin user
	Scenario: Delete Inventory Adjustment Item as admin user
		Given I navigate to the login page
		When I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "InventoryAdjustmentItem" backend page
			And I create an "InventoryAdjustmentItem" if not exists
			And I 'delete' an existing 'InventoryAdjustmentItem'

	Scenario: Delete every InventoryAdjustmentItem as Admin User
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "InventoryAdjustmentItem" backend page
			And I create 11 "InventoryAdjustmentItem" entities
			And I am on the "InventoryAdjustmentItem" backend page
		When I "Select" an existing "InventoryAdjustmentItem"
			And I select all "InventoryAdjustmentItem" entities
			And I click the delete all button on the "InventoryAdjustmentItem" page and confirm
		Then I expect that every "InventoryAdjustmentItem" entity except 0 is deleted

	Scenario: Delete every InventoryAdjustmentItem excluding one as Admin User
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "InventoryAdjustmentItem" backend page
			And I create 11 "InventoryAdjustmentItem" entities
			And I am on the "InventoryAdjustmentItem" backend page
		When I "Select" an existing "InventoryAdjustmentItem"
			And I select all "InventoryAdjustmentItem" entities
			# This stepdef clicks the checkbox to toggle selection.  As all entities are selected at this point, this will deselect a single entity
			And I "Select" an existing "InventoryAdjustmentItem"
			And I click the delete all button on the "InventoryAdjustmentItem" page and confirm
		Then I expect that every "InventoryAdjustmentItem" entity except 1 is deleted