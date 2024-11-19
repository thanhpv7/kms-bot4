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
@crud @pagination @goodsReceiveNote
Feature: Goods Receive Note Pagination Persistence
	Scenario: Pagination persists when returning to Goods Receive Note list view
	Given I navigate to the login page
		And I login with username "administrator@example.com" with password "password"
		And I see the homepage
		And I navigate to the "GoodsReceiveNote" backend page
		And I create 15 "GoodsReceiveNote" entities
		And I am on the "GoodsReceiveNote" backend page
		And I click the next page button on the "GoodsReceiveNote" page
		And I click to create a "GoodsReceiveNote"
	When I click the cancel button on the "GoodsReceiveNote" edit page
	Then I expect that the "listPage" query parameter is set to "2"
		And I expect that the current page number on the "GoodsReceiveNote" list page is 2
