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
@crud @delete @vitalSigns
Feature: Delete Vital Signs as admin user
	Scenario: Delete Vital Signs as admin user
		Given I navigate to the login page
		When I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "VitalSigns" backend page
			And I create an "VitalSigns" if not exists
			And I 'delete' an existing 'VitalSigns'

	Scenario: Delete every VitalSigns as Admin User
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "VitalSigns" backend page
			And I create 11 "VitalSigns" entities
			And I am on the "VitalSigns" backend page
		When I "Select" an existing "VitalSigns"
			And I select all "VitalSigns" entities
			And I click the delete all button on the "VitalSigns" page and confirm
		Then I expect that every "VitalSigns" entity except 0 is deleted

	Scenario: Delete every VitalSigns excluding one as Admin User
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "VitalSigns" backend page
			And I create 11 "VitalSigns" entities
			And I am on the "VitalSigns" backend page
		When I "Select" an existing "VitalSigns"
			And I select all "VitalSigns" entities
			# This stepdef clicks the checkbox to toggle selection.  As all entities are selected at this point, this will deselect a single entity
			And I "Select" an existing "VitalSigns"
			And I click the delete all button on the "VitalSigns" page and confirm
		Then I expect that every "VitalSigns" entity except 1 is deleted