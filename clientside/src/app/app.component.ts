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

import { Component, HostBinding, OnInit, OnDestroy } from '@angular/core';
import { Store } from '@ngrx/store';
import { Subscription } from 'rxjs';
import { RouterState } from './models/model.state';
import { AuthenticationService } from './lib/services/authentication/authentication.service';
import { getRouterState } from './models/model.selector';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Component({
	selector: 'body[app-root]',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})
export class AppComponent
		// % protected region % [Add any additional interfaces to implement here] off begin
		implements OnInit
		// % protected region % [Add any additional interfaces to implement here] end
{
	/**
	 * Whether the current application is on the admin view or not.
	 */
	adminView: boolean;

	@HostBinding('class.admin')
	get isAdmin() {
		return this.adminView;
	}

	@HostBinding('class.frontend')
	get isFrontend() {
		return !this.adminView;
	}

	routerStateSubscription$: Subscription;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		public readonly authenticationService: AuthenticationService,
		private readonly routerStore: Store<{ router: RouterState }>,
		private httpClient: HttpClient,
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
	) {
		this.routerStateSubscription$ = new Subscription();
		// % protected region % [Customise or remove defineViewportHeight here] off begin
		// For cross platform mobile responsiveness
		const defineViewportHeight = () => {
			let vh = window.innerHeight * 0.01;
			document.documentElement.style.setProperty('--vh', `${vh}px`);
		};
		defineViewportHeight();
		window.addEventListener('resize', () => defineViewportHeight());
		// % protected region % [Customise or remove defineViewportHeight here] end

		// % protected region % [Add any additional constructor logic here.] off begin
		// % protected region % [Add any additional constructor logic here.] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnInit() {
		// % protected region % [Add any initial constructor logic here] off begin
		// % protected region % [Add any initial constructor logic here] end

		// Checks if admin is in the current route
		this.routerStateSubscription$.add(
			this.routerStore.select(getRouterState).subscribe(routerState => {
				this.adminView = routerState.urls[0] === 'admin';
			})
		);

		// Check is not needed if the user isn't logged in
		// Role Guards will pick this up and redirect to login if not logged in
		// Hitting the actuator endpoint can also lead to redirecting to /403 if the user is not logged in
		if (this.authenticationService.isLoggedIn) {
			// Default error handler will intercept a failed request and return us to the login page
			// By default no action is needed on success
			this.routerStateSubscription$.add(
				this.httpClient.get(`${environment.API_URL}/actuator/info`, {
					observe: 'response',
					withCredentials: true,
				}).subscribe(response => {
					// % protected region % [Add any logic for interacting with the actuator response here] off begin
					// % protected region % [Add any logic for interacting with the actuator response here] end
				})
			);
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnDestroy(): void {
		this.routerStateSubscription$?.unsubscribe();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

