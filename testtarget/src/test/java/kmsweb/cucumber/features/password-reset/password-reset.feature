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
@password-reset
Feature: Password Reset

	Scenario: I can view the password reset page
		Given I navigate to the login page
			And I see the login page
			And I click the forgotten password button
		When I wait for the site url to be "forgotten-password"
			Then I expect the element with id of username to be visible

# % protected region % [Add additional scenarios for password reset feature] off begin
# % protected region % [Add additional scenarios for password reset feature] end

