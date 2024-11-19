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
@crud @delete @nhisClaimGDRGDetail
Feature: Delete NHIS Claim GDRG Detail as admin user
	Scenario: Delete NHIS Claim GDRG Detail as admin user
		Given I navigate to the login page
		When I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "NhisClaimGDRGDetail" backend page
			And I create an "NhisClaimGDRGDetail" if not exists
			And I 'delete' an existing 'NhisClaimGDRGDetail'

	Scenario: Delete every NhisClaimGDRGDetail as Admin User
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "NhisClaimGDRGDetail" backend page
			And I create 11 "NhisClaimGDRGDetail" entities
			And I am on the "NhisClaimGDRGDetail" backend page
		When I "Select" an existing "NhisClaimGDRGDetail"
			And I select all "NhisClaimGDRGDetail" entities
			And I click the delete all button on the "NhisClaimGDRGDetail" page and confirm
		Then I expect that every "NhisClaimGDRGDetail" entity except 0 is deleted

	Scenario: Delete every NhisClaimGDRGDetail excluding one as Admin User
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "NhisClaimGDRGDetail" backend page
			And I create 11 "NhisClaimGDRGDetail" entities
			And I am on the "NhisClaimGDRGDetail" backend page
		When I "Select" an existing "NhisClaimGDRGDetail"
			And I select all "NhisClaimGDRGDetail" entities
			# This stepdef clicks the checkbox to toggle selection.  As all entities are selected at this point, this will deselect a single entity
			And I "Select" an existing "NhisClaimGDRGDetail"
			And I click the delete all button on the "NhisClaimGDRGDetail" page and confirm
		Then I expect that every "NhisClaimGDRGDetail" entity except 1 is deleted