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
import {Component, Input, OnDestroy} from '@angular/core';
import { Store } from '@ngrx/store';
import { Subscription } from 'rxjs';
import { getRouterState } from 'src/app/models/model.selector';
import { RouterState } from 'src/app/models/model.state';
// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Different mode of Crud Tile
 */
export enum CrudTileMode {
	View = 'view',
	Create = 'create',
	List = 'list',
	Edit = 'edit',
	// % protected region % [Add any additional crud tile mode here here] off begin
	// % protected region % [Add any additional crud tile mode here here] end
}

/**
 * Base tile to show all crud components.
 */
@Component({
	selector: 'cb-bpjs-general-admin-crud',
	templateUrl: './bpjs-general-admin-crud.component.html',
	styleUrls: [
		'./bpjs-general-admin-crud.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class AdminBpjsGeneralCrudComponent implements OnDestroy {
	readonly CrudTileMode = CrudTileMode;

	/**
	 * Whether the component should display other routes (such as the create/edit page) as their own individual routes
	 * or as part of the same parent page
	 */
	@Input()
	singlePageComponent = false;

	/**
	 * Whether to show collection or save/edit page
	 * Only used when singlePageComponent is turned on
	 */
	@Input()
	tileMode: CrudTileMode = CrudTileMode.List;

	/**
	 * Id of entity to show
	 * Only used when singlePageComponent is turned on
	 */
	@Input()
	targetModelId: string;

	/**
	 * Store page index here and pass it down to the list so that the current page is preserved when navigating to other tile modes
	 */
	@Input()
	pageIndex = 0;

	/**
	 * The current router state when this page is displayed.
	 */
	routerState: RouterState;

	/**
	 * Unsubscribe from this subscription when the crud component is destroyed
	 */
	routerStateSubscription$: Subscription;

	// % protected region % [Add additional class fields here] off begin
	// % protected region % [Add additional class fields here] end

	/**
	 * RouterState and routerStateSubscription are used when a clientside CRUD component is created with routing
	 */
	constructor(private readonly routerStore: Store<{ router: RouterState }>) {
		this.routerStateSubscription$ = this.routerStore.select(getRouterState).subscribe(routerState => {
			this.routerState = routerState;
		});
	}

	ngOnDestroy(): void {
		this.routerStateSubscription$.unsubscribe();
	}

	/**
	 * Triggered when tile mode is changed
	 * Only used when singlePageComponent is turned on
	 */
	onTileModeChange($event: { tileMode: CrudTileMode, payload?: any}) {
		if ($event.payload && $event.payload.id) {
			this.targetModelId = $event.payload.id;
		}

		if ($event.payload.pageIndex) {
			this.pageIndex = $event.payload.pageIndex;
		}

		this.tileMode = $event.tileMode;
	}

	/**
	 * When the frontend CRUD component has singlePageComponent off, the crud list will be shown on the page, and routing will be available to the
	 * variants of the edit page.  The CRUD List needs to be hidden when not in list mode, so we can use this function to check the URL to determine
	 * whether the CRUD List tile needs to be hidden
	 */
	private frontendRoutingListMode() {
		return !this.routerState.urls.includes('view') && !this.routerState.urls.includes('edit') && !this.routerState.urls.includes('create');
	}

	// % protected region % [Add additional methods here] off begin
	// % protected region % [Add additional methods here] end
}
