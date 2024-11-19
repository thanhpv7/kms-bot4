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
@crud @select @patientPaymentBPJS
Feature: Select PatientPaymentBPJS in Crud tile as admin user
	Scenario: Select PatientPaymentBPJS in Crud tile as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "PatientPaymentBPJS" backend page
			And I create 2 "PatientPaymentBPJS" entities
			And I am on the "PatientPaymentBPJS" backend page
		When I "Select" an existing "PatientPaymentBPJS"
		Then The "PatientPaymentBPJS" collection options bar is present
			And The Select All Items button is present in the "PatientPaymentBPJS" collection options bar
			And I expect that 1 "PatientPaymentBPJS" entity is selected in the collection options bar

	Scenario: Selection in Admin PatientPaymentBPJS Crud Tile persists through page changes
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "PatientPaymentBPJS" backend page
			And I create 11 "PatientPaymentBPJS" entities
			And I am on the "PatientPaymentBPJS" backend page
		When I "Select" an existing "PatientPaymentBPJS"
			And I click the next page button on the "PatientPaymentBPJS" page
		Then I expect that 1 "PatientPaymentBPJS" entity is selected in the collection options bar

	Scenario: Select all PatientPaymentBPJS Entities as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "PatientPaymentBPJS" backend page
			And I create 11 "PatientPaymentBPJS" entities
			And I am on the "PatientPaymentBPJS" backend page
		When I "Select" an existing "PatientPaymentBPJS"
			And I select all "PatientPaymentBPJS" entities
		Then I expect that every "PatientPaymentBPJS" entity is selected

	Scenario: Deselect all PatientPaymentBPJS Entities as admin user
		Given I navigate to the login page
			And I login with username "administrator@example.com" with password "password"
			And I see the homepage
			And I navigate to the "PatientPaymentBPJS" backend page
			And I create 11 "PatientPaymentBPJS" entities
			And I am on the "PatientPaymentBPJS" backend page
		When I "Select" an existing "PatientPaymentBPJS"
			And I select all "PatientPaymentBPJS" entities
			And I click the cancel button on the "PatientPaymentBPJS" page
		Then I expect that every "PatientPaymentBPJS" entity is deselected