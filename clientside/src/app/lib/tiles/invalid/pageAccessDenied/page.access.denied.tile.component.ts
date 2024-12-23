/*
 * @bot-written
 *
 * WARNING AND NOTICE
 * Any access, download, storage, and/or use of this source code is subject to the terms and conditions of the
 * Full Software Licence as accepted by you before being granted access to this source code and other materials,
 * the terms of which can be accessed on the Codebots website at https://codebots.com/full-software-licence. Any
 * commercial use in contravention of the terms of the Full Software Licence may be pursued by Codebots through
 * licence termination and further legal action, and be required to indemnify Codebots for any loss or damage,
 * including interest and costs. You are deemed to have accepted the terms of the Full Software Licence on any
 * access, download, storage, and/or use of this source code.
 *
 * BOT WARNING
 * This file is bot-written.
 * Any changes out side of "protected regions" will be lost next time the bot makes any changes.
 */

import {Component} from '@angular/core';
import {Location} from '@angular/common';
import { AuthenticationService } from 'src/app/lib/services/authentication/authentication.service';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Component({
	selector: 'cb-page-access-denied',
	templateUrl: './page.access.denied.tile.component.html',
	styleUrls: ['./page.access.denied.tile.component.scss']
})
export class PageAccessDeniedTileComponent {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		private location: Location,
		private authService: AuthenticationService
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
	) {
		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * Triggered when the user clicks on the "Back to previous page" button.
	 */
	onReturnToPreviousPageButtonClicked(): void {
		// % protected region % [Add any additional logic before returning to the previous page here] off begin
		// % protected region % [Add any additional logic before returning to the previous page here] end
		this.location.back();
	}

	/**
	 * Triggered when the user clicks on the "Logout" button.
	 */
	onLogoutButtonClicked(): void {
		// % protected region % [Customise how the the logout buttons behaviour here] off begin
		this.authService.logout();
		// % protected region % [Customise how the the logout buttons behaviour here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
