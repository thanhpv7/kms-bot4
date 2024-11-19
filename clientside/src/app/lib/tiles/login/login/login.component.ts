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

import {Component, HostBinding, Input} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {AuthenticationService} from 'src/app/lib/services/authentication/authentication.service';
import {TextfieldType} from 'src/app/lib/components/textfield/textfield.component';
import {ButtonAccentColour, ButtonStyle} from 'src/app/lib/components/button/button.component';
import * as routerAction from 'src/app/lib/routing/routing.action';
import {getRouterState} from 'src/app/lib/../models/model.selector';
import {RouterState} from 'src/app/lib/../models/model.state';
import { LoginUtils } from 'src/app/lib/utils/login/login-utils';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Component({
	selector: 'cb-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.scss']
})
export class LoginComponent {
	ButtonAccentColour = ButtonAccentColour;
	ButtonStyle = ButtonStyle;

	/**
	 * All the user types that can be registered by an anonymous user.
	 */
	userTypes = LoginUtils.userTypes();

	/**
	 * The default path to redirect to after login
	 */
	@Input()
	defaultRedirectPath: string = '/';

	/**
	 * Types of the textfield
	 */
	TextfieldType = TextfieldType;

	/**
	 * Login form to control the actual HTML form used for logging into the backend.
	 */
	loginForm = new FormGroup({
		email: new FormControl('', [Validators.required, Validators.email]),
		password: new FormControl('', Validators.required),
	});

	/**
	 * Flag to indicate whether the login has failed or not.
	 */
	loginFailed = false;

	/**
	 * State of the Router
	 */
	routerState: RouterState;

	// % protected region % [Change default url to redirect to after login here] off begin
	/**
	 * The url to redirect to after login
	 */
	defaultUrlToRedirectTo = '/';
	// % protected region % [Change default url to redirect to after login here] end

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		// % protected region % [Add any additional constructor parameters here here] off begin
		// % protected region % [Add any additional constructor parameters here here] end
		private authenticationService: AuthenticationService,
		private routerStore: Store<{ router: RouterState }>
	) {
		// % protected region % [Add any additional construct logic before the main body here] off begin
		// % protected region % [Add any additional construct logic before the main body here] end

		this.routerStore.select(getRouterState).subscribe(
			routerState => this.routerState = routerState
		);

		// % protected region % [Add any additional construct logic after the main body here] off begin
		// % protected region % [Add any additional construct logic after the main body here] end
	}

	/**
	 * Triggered when the user clicks the `Login` button.
	 */
	onSubmit(): void {
		// % protected region % [Override the default login behaviour here] off begin
		const obs = this.authenticationService.login(this.loginForm.get('email').value, this.loginForm.get('password').value);

		obs.subscribe(
			response => {
				let redirectUrl = this.routerState.queryParams.redirectTo ?
					this.routerState.queryParams.redirectTo :
					this.defaultUrlToRedirectTo;

				this.routerStore.dispatch(new routerAction.NavigateRoutingAction([redirectUrl]));
			},
			error => {
				if (error.status === 401) {
					this.loginFailed = true;
				}
			},
			() => {
			}
		);
		// % protected region % [Override the default login behaviour here] end
	}

	/**
	 * If there is only one user type that can be registered, then don't show the registration page, as there is only one path through it
	 * Otherwise go to registration select page.  Don't need to account for 0 user types, as the button is not shown for this, so the user
	 * can't reach the page without manually entering the url
	 */
	registrationRouterLink() {
		if (this.userTypes.length === 1) {
			return '/register/' + this.userTypes[0].value;
		}

		return '/register';
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
