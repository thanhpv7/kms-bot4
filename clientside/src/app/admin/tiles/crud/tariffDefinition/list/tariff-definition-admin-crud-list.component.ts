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

import {Component, EventEmitter, Input, Output, OnInit, OnDestroy, ViewContainerRef, ViewChild} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {Observable, Subscription} from 'rxjs';
import {Store} from '@ngrx/store';
import {ActivatedRoute} from '@angular/router';
import * as routingAction from 'src/app/lib/routing/routing.action';
import {ModelProperty, ModelRelation} from 'src/app/lib/models/abstract.model';
import {Action, HeaderOption, LoadingType, CollectionComponent} from 'src/app/lib/components/collection/collection.component';
import * as modelAction from 'src/app/models/tariffDefinition/tariff_definition.model.action';
import {TariffDefinitionModelState} from 'src/app/models/tariffDefinition/tariff_definition.model.state';
import {AuthenticationService} from 'src/app/lib/services/authentication/authentication.service';
import {TariffTypeEnum, tariffTypeEnumArray} from 'src/app/enums/tariff-type.enum';
import {TariffDefinitionModel} from 'src/app/models/tariffDefinition/tariff_definition.model';
import {
	getTariffDefinitionCollectionModels,
	getTariffDefinitionCollectionCount
} from 'src/app/models/tariffDefinition/tariff_definition.model.selector';
import {ButtonAccentColour, IconPosition, ButtonStyle} from 'src/app/lib/components/button/button.component';
import {OrderBy, PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {FilterQuestion, FilterQuestionType} from 'src/app/lib/components/collection/collection-filter.component';
import {CrudTileMode} from '../tariff-definition-admin-crud.component';
import {RouterState} from 'src/app/models/model.state';
import { ModalDialogService, SimpleModalComponent } from '@preeco-privacy/ngx-modal-dialog';
import { environment } from 'src/environments/environment';
import { getRouterState } from 'src/app/models/model.selector';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Enum used to declare every custom collection action that will be included into the underlying collection.
 *
 * Note that this is only for declaration. If the developer wants to use it, they must register it into the actions
 * property below.
 */
enum CollectionActionEnum {
	// % protected region % [Customise what collection actions show here] off begin
	Create = 'Create',
	Import = 'Import',
	Export = 'Export All',
	// % protected region % [Customise what collection actions show here] end
	// % protected region % [Add any additional collection actions here] off begin
	// % protected region % [Add any additional collection actions here] end
}

/**
 * Enum used to declare every custom item action that will be included into the underlying collection.
 *
 * Note that this is only for declaration. If the developer wants to use it, they must register it into the actions
 * property below.
 */
enum ItemActionEnum {
	// % protected region % [Customise what item actions show here] off begin
	View = 'View',
	Edit = 'Edit',
	Delete = 'Delete',
	// % protected region % [Customise what item actions show here] end
	// % protected region % [Add any additional item actions here] off begin
	// % protected region % [Add any additional item actions here] end
}

/**
 * Enum used to declare every custom action for a selection of items that will be included into the underlying
 * collection.
 *
 * Note that this is only for declaration. If the developer wants to use it, they must register it into the actions
 * property below.
 */
enum MultipleItemActionEnum {
	// % protected region % [Customise what multiple items actions show here] off begin
	Delete = 'Delete',
	Export = 'Export',
	// % protected region % [Customise what multiple items actions show here] end
	// % protected region % [Add any additional multiple items actions here] off begin
	// % protected region % [Add any additional multiple items actions here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-tariff-definition-admin-crud-list',
	templateUrl: './tariff-definition-admin-crud-list.component.html',
	styleUrls: [
		'./tariff-definition-admin-crud-list.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class AdminTariffDefinitionCrudListComponent
		// % protected region % [Add any additional interfaces to implement here] off begin
		implements OnInit, OnDestroy
		// % protected region % [Add any additional interfaces to implement here] end
{

	@ViewChild('childCollection', {static: false})
	childCollection: CollectionComponent<TariffDefinitionModel>;

	/**
	 * The name of the fields which are used in the search box
	 */
	searchFields: string[] = [
		...TariffDefinitionModel.searchFields,
		// % protected region % [Add any fields here used in the search] off begin
		// % protected region % [Add any fields here used in the search] end
	];

	/**
	 * Where statements used in search
	 * Connected with 'or' operation
	 */
	private searchConditions: Where[] = [];

	/**
	 * Where statements used in filtering
	 * Connected with 'and' operation
	 */
	private filterConditions: Where[][] = [];

	/**
	 * Whether disable routing
	 * This would change behaviours when clicking edit/view/create button
	 */
	@Input()
	singlePageComponent = false;

	/**
	 * Determines whether the expand accordion should be available in the DOM.  If false, the expand button and the accordions will not be rendered.
	 * This attribute is passed into the collection component.  The logic for hiding the expand accordion can be found there.
	 *
	 * This can be set to false in ngOnInit to disable the expand for this entity
	 */
	@Input()
	enableExpands: boolean = true;

	/**
	 * List of Tariff Definitions that will be managed by this CRUD tile. Note that this list is not complete, i.e. it
	 * does not represent all models in the database. Instead it represents a slice or page of the complete list.
	 */
	tariffDefinitions: Observable<TariffDefinitionModel[]>;

	/**
	 * The total number of entities in the database.
	 */
	tariffDefinitionsCount: number = 0;

	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = TariffDefinitionModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = TariffDefinitionModel.getRelations();
	// % protected region % [Change your model relations here] end]

	// % protected region % [Change your collection id if required here] off begin
	/**
	 * The collection id used in the store
	 * Default to be the uuid of the tile, you could change this to custom id you want to share in different component
	 * But this must to be unique to avoid mess up the data
	 */
	@Input()
	collectionId: string = 'bb493f41-5538-4e05-a741-5e9dec312112';
	// % protected region % [Change your collection id if required here] end

	/**
	 * Which type of pagination to be used in the collection.
	 */
	@Input()
	loadingType: LoadingType | string = LoadingType.PAGINATION;

	/**
	 * A page index indicates the start index of a "page", which default to 0.
	 */
	@Input()
	pageIndex: number = 0;

	/**
	 * The current page of the data table.  Will usually be the same as pageIndex, however this is used to
	 * ensure the initial page can be navigated back to after searching or filtering
	 */
	currentPage: number = 0;

	/**
	 * True if page is currently searching or has filters applied.  Allows for preservation of pagination as well as page changes while searching/filtering
	 */
	searchingOrFiltering: boolean = false;

	/**
	 * How many items are included in this page.
	 */
	@Input()
	pageSize: number = 10;

	/**
	 * Default ordering of the items.
	 */
	@Input()
	orderBy: OrderBy[] = [
		// % protected region % [Change your default ordering if required here] off begin
		{
			path: 'created',
			descending: true
		}
		// % protected region % [Change your default ordering if required here] end
	];

	/**
	 * Default conditions to be applied when the component first loaded.
	 */
	private readonly defaultWheres: Where[][] = [
		// % protected region % [Add any additional default where conditions here] off begin
		// % protected region % [Add any additional default where conditions here] end
	];

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		return [];
	}
	// % protected region % [Change your default expands if required here] end

	/**
	 * Where can be passed in as where statement in query
	 */
	@Input()
	where: Where[][] = [];

	/**
	 * The reference want to fetch from the server side
	 */
	@Input()
	expands: Expand[] = [];

	/**
	 * Event emitter when user clicking button to change mode of tile
	 */
	@Output()
	tileModeChange: EventEmitter<{tileMode: CrudTileMode, payload?: any}> = new EventEmitter();

	routerState: RouterState;

	/**
	 * Unsubscribe from this subscription when the crud component is destroyed
	 */
	routerStateSubscription$: Subscription;

	/**
	 * A subscription which contains all of the observables used for fetching entities from the database. This is unsubscribed when destroying
	 * the component to ensure no data leaks out.
	 */
	entitySubscription$: Subscription;

	/**
	 * The query parameters for the collection
	 */
	get queryParams(): QueryParams {
		return {
			pageIndex: this.pageIndex,
			pageSize: this.pageSize,
			orderBy: this.orderBy,
			where: [
				...this.where,
				...this.defaultWheres,
				...this.filterConditions,
				this.searchConditions,
				// % protected region % [Add any additional where conditions here] off begin
				// % protected region % [Add any additional where conditions here] end
			],
			expands: [
				...this.expands,
				...this.defaultExpands
			],
		};
	}

	@Input()
	set queryParams(queryParams: QueryParams) {
			this.pageIndex = queryParams.pageIndex;
			this.pageSize = queryParams.pageSize;
			this.orderBy = queryParams.orderBy;
			this.where = queryParams.where;
			this.expands = queryParams.expands;
	}

	/**
	 * Whether the current page is the last page or not
	 */
	get isLastPage(): boolean {
		return Math.max(Math.floor((this.tariffDefinitionsCount - 1) / this.pageSize), 0) === this.pageIndex;
	}

	/**
	 * List of all header options for the collection
	 */
	// % protected region % [Change your header options required here] off begin
	readonly headerOptions: HeaderOption[] = this.modelProperties.map(prop => {
		return {
			...prop,
			sortable: true,
			sourceDirectFromModel: true,
			valueSource: prop.name,
			doHide: prop.hideElement,
		} as HeaderOption;
	}).filter(opt => opt.name !== 'id').filter(opt => !opt.doHide);
	// % protected region % [Change your header options required here] end

	/**
	 * List of all attributes to be used in the expand accordion.
	 *
	 * By default this includes all the options from headerOptions, but also includes id.
	 */
	// % protected region % [Change your expand options required here] off begin
	readonly expandOptions: HeaderOption[] = this.modelProperties.map(prop => {
		return {
			...prop,
			sortable: true,
			sourceDirectFromModel: true,
			valueSource: prop.name,
			doHide: prop.hideElement,
		} as HeaderOption;
	}).filter(opt => opt.name !== 'id').filter(opt => !opt.doHide);
	// % protected region % [Change your expand options required here] end

	/**
	 * Additional actions to be added as buttons on the menu of the collection.
	 */
	collectionActions: Action[] = [
		// % protected region % [Customise create button here] off begin
		{
			label: CollectionActionEnum.Import,
			icon: 'import',
			iconPos: IconPosition.RIGHT,
			showIcon: true,
			buttonStyle: ButtonStyle.OUTLINE,
			buttonColour: ButtonAccentColour.PRIMARY,
			isAdditional: false,
			template: 'import',
			disableOption: () => !(this.canCreate() || this.canEdit())
		},
		{
			label: CollectionActionEnum.Export,
			icon: 'export',
			iconPos: IconPosition.RIGHT,
			showIcon: true,
			buttonStyle: ButtonStyle.OUTLINE,
			buttonColour: ButtonAccentColour.PRIMARY,
			isAdditional: false,
			disableOption: () => this.tariffDefinitionsCount === 0
		},
		{
			label: CollectionActionEnum.Create,
			icon: 'create',
			iconPos: IconPosition.RIGHT,
			showIcon: true,
			isAdditional: false,
			disableOption: () => !this.canCreate()
		},
		// % protected region % [Customise create button here] end

		// % protected region % [Add any additional actions for the collection here] off begin
		// % protected region % [Add any additional actions for the collection here] end
	];

	/**
	 * Additional actions to be added as buttons on each row of the collection.
	 */
	itemActions: Action[] = [
		// % protected region % [Update the default view item action here] off begin
		{
			label: ItemActionEnum.View,
			icon: 'look',
			iconPos: IconPosition.TOP,
			showIcon: true,
			isAdditional: false
		},
		// % protected region % [Update the default view item action here] end
		// % protected region % [Update the default edit item action here] off begin
		{
			label: ItemActionEnum.Edit,
			icon: 'edit',
			iconPos: IconPosition.TOP,
			showIcon: true,
			isAdditional: false,
			disableOption: () => !this.canEdit()
		},
		// % protected region % [Update the default edit item action here] end
		// % protected region % [Update the default delete item action here] off begin
		{
			label: ItemActionEnum.Delete,
			icon: 'bin-delete',
			iconPos: IconPosition.TOP,
			showIcon: true,
			isAdditional: false,
			disableOption: () => !this.canDelete()
		},
		// % protected region % [Update the default delete item action here] end
		// % protected region % [Add any additional actions for the items here] off begin
		// % protected region % [Add any additional actions for the items here] end
	];

	/**
	 * Additional actions to be added as buttons when any number of items are selected.
	 */
	multipleItemsActions: Action[] = [
		// % protected region % [Update the default deletion multiple item action action here] off begin
		{
			label: MultipleItemActionEnum.Delete,
			icon: 'bin-delete',
			iconPos: IconPosition.LEFT,
			showIcon: true,
			isAdditional: false
		},
		// % protected region % [Update the default deletion multiple item action action here] end
		// % protected region % [Update the default export multiple item action action here] off begin
		{
			label: MultipleItemActionEnum.Export,
			icon: 'export',
			iconPos: IconPosition.LEFT,
			showIcon: true,
			isAdditional: false
		},
		// % protected region % [Update the default export multiple item action action here] end
		// % protected region % [Add any additional multiple actions for the collection here] off begin
		// % protected region % [Add any additional multiple actions for the collection here] end
	];

	/**
	 * The questions to be used in the filter
	 */
	filterQuestions: FilterQuestion[] = [
		// % protected region % [Modify the existing config for the dropdown filter question for enum ref Tariff Type to Tariff Definition here] off begin
		{
			filterType: FilterQuestionType.dropdown,
			config: {
				options: tariffTypeEnumArray,
				labelField: 'value',
				valueField: 'key',
				id: 'TariffDefinitionTariffTypeFilter',
				label: 'Tariff Type',
			},
			name: 'tariffType',
		},
		// % protected region % [Modify the existing config for the dropdown filter question for enum ref Tariff Type to Tariff Definition here] end
		// % protected region % [Add any additional filter questions for the collection here] off begin
		// % protected region % [Add any additional filter questions for the collection here] end
	];

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		private readonly store: Store<{ model: TariffDefinitionModelState }>,
		private readonly routerStore: Store<{ router: RouterState }>,
		private readonly activatedRoute: ActivatedRoute,
		private authenticationService: AuthenticationService,
		private readonly modalService: ModalDialogService,
		private readonly viewRef: ViewContainerRef,
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.entitySubscription$ = new Subscription();

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	ngOnInit() {
		// % protected region % [Add any additional ngOnInit logic before the main body here] off begin
		// % protected region % [Add any additional ngOnInit logic before the main body here] end


		if (this.activatedRoute.snapshot && this.activatedRoute.snapshot.queryParams.listPage) {
			this.pageIndex = parseInt(this.activatedRoute.snapshot.queryParams.listPage, 10) - 1;
			this.currentPage = this.pageIndex;
		}

		this.routerStateSubscription$ = this.routerStore.select(getRouterState).subscribe(routerState => {
			this.routerState = routerState;
		});

		this.entitySubscription$.add(
			this.store.dispatch(new modelAction.TariffDefinitionAction(
				modelAction.TariffDefinitionModelActionTypes.INITIALISE_TARIFF_DEFINITION_COLLECTION_STATE,
				{
					queryParams: this.queryParams,
					collectionId: this.collectionId
				}
			))
		);

		this.entitySubscription$.add(
			this.store.dispatch(new modelAction.TariffDefinitionAction(
				modelAction.TariffDefinitionModelActionTypes.FETCH_TARIFF_DEFINITION_WITH_QUERY,
				{
					queryParams: this.queryParams,
					collectionId: this.collectionId
				},
				[
					new modelAction.TariffDefinitionAction(
						modelAction.TariffDefinitionModelActionTypes.COUNT_TARIFF_DEFINITIONS,
						null
					)
				]
			))
		);

		this.tariffDefinitions = this.store.select(getTariffDefinitionCollectionModels, this.collectionId);

		this.entitySubscription$.add(
			this.store.select(getTariffDefinitionCollectionCount, this.collectionId).subscribe(
				(count) => this.tariffDefinitionsCount = count
			)
		);

		// % protected region % [Add any additional ngOnInit logic after the main body here] off begin
		// % protected region % [Add any additional ngOnInit logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnDestroy() {
		// % protected region % [Add any additional ngOnDestroy logic before the main body here] off begin
		// % protected region % [Add any additional ngOnDestroy logic before the main body here] end

		this.routerStateSubscription$.unsubscribe();
		this.entitySubscription$?.unsubscribe();

		// % protected region % [Add any additional ngOnDestroy logic after the main body here] off begin
		// % protected region % [Add any additional ngOnDestroy logic after the main body here] end\
	}

	/**
	 * Change tile mode based on action and whether using routing
	 */
	private triggerTileModeChange(tileMode: CrudTileMode, id?: string, other?: object) {
		if (this.singlePageComponent) {
			this.tileModeChange.emit({
				tileMode: tileMode,
				payload: {
					id: id,
					pageIndex: this.currentPage, // Use currentPage because pageIndex could be different due to search or filter, which would not be preserved
				}
			});
		} else {
			const commands = [];

			// Angular 11 has caused some issues with the relativeTo paramater in navigation extras, so
			// until we can figure out what the issue is this is the best option available
			commands.push('admin');
			commands.push('entities');
			commands.push('tariff-definition');

			if (tileMode !== CrudTileMode.List) {
				commands.push(tileMode.toString());
			}

			if (id) {
				commands.push(id);
			}
			this.routerStore.dispatch(new routingAction.NavigateRoutingAction(commands, {
				queryParams: {listPage: this.pageIndex + 1},
			}));
		}
	}

	/**
	 * Triggered whenever a custom action against an item is clicked.
	 */
	onItemActionClicked(event: { actionName: string, payload?: any }) {
		// % protected region % [Add any additional onActionClicked logic before the main body here] off begin
		// % protected region % [Add any additional onActionClicked logic before the main body here] end

		if (event.actionName === ItemActionEnum.View) {
			// % protected region % [Add any additional logic for View action before the main body here] off begin
			// % protected region % [Add any additional logic for View action before the main body here] end

			// % protected region % [Modify the logic for View action here] off begin
			this.triggerTileModeChange(CrudTileMode.View, event.payload.model.id);
			// % protected region % [Modify the logic for View action here] end

			// % protected region % [Add any additional logic for View action after the main body here] off begin
			// % protected region % [Add any additional logic for View action after the main body here] end
			return;
		}

		if (event.actionName === ItemActionEnum.Edit) {
			// % protected region % [Add any additional logic for Edit action before the main body here] off begin
			// % protected region % [Add any additional logic for Edit action before the main body here] end

			// % protected region % [Modify the logic for Edit action here] off begin
			this.triggerTileModeChange(CrudTileMode.Edit, event.payload.model.id);
			// % protected region % [Modify the logic for Edit action here] end

			// % protected region % [Add any additional logic for Edit action after the main body here] off begin
			// % protected region % [Add any additional logic for Edit action after the main body here] end
			return;
		}

		if (event.actionName === ItemActionEnum.Delete) {
			// % protected region % [Add any additional logic for Delete action before the main body here] off begin
			// % protected region % [Add any additional logic for Delete action before the main body here] end

			// % protected region % [Modify the logic for Delete action here] off begin
			this.onDeleteClicked(true, [event.payload.model], 1);
			// % protected region % [Modify the logic for Delete action here] end

			// % protected region % [Add any additional logic for Delete action after the main body here] off begin
			// % protected region % [Add any additional logic for Delete action after the main body here] end
			return;
		}

		// % protected region % [Add any additional onActionClicked logic after the main body here] off begin
		// % protected region % [Add any additional onActionClicked logic after the main body here] end
	}

	/**
	 * Triggered whenever a custom action against a collection is clicked.
	 */
	onCollectionActionClicked(event: { actionName: string, payload?: any }) {
		// % protected region % [Add any additional onCollectionActionClicked logic before the main body here] off begin
		// % protected region % [Add any additional onCollectionActionClicked logic before the main body here] end

		// Overwriting any of the default logic for an action can be done by adding a check in the protected region at the start of this method
		// and implementing different logic there.

		if (event.actionName === CollectionActionEnum.Create) {
			this.onCreateClicked();
			return;
		}

		if (event.actionName === CollectionActionEnum.Export) {
			// passing these fields to the export function will cause it to use the export all excluding action,
			// and exclude no entities, as models is empty
			this.onExportClicked(false, []);
			return;
		}

		if (event.actionName === CollectionActionEnum.Import) {
			this.onImportClicked(event.payload?.file);
			return;
		}

		// % protected region % [Add any additional onCollectionActionClicked logic after the main body here] off begin
		// % protected region % [Add any additional onCollectionActionClicked logic after the main body here] end
	}

	/**
	 * Triggered whenever a custom action against a selection of items is clicked.
	 */
	onMultipleItemsActionClicked(event: { actionName: string, payload?: any }) {
		// % protected region % [Add any additional onMultipleItemsActionClicked logic before the main body here] off begin
		// % protected region % [Add any additional onMultipleItemsActionClicked logic before the main body here] end

		// Overwriting any of the default logic for an action can be done by adding a check in the protected region at the start of this method
		// and implementing different logic there.

		if (event.actionName === MultipleItemActionEnum.Delete) {
			let modelsToDelete;
			if (event.payload.usingSelected) {
				modelsToDelete = event.payload.models.length;
			} else {
				modelsToDelete = event.payload.modelCount - event.payload.models.length;
			}
			this.onDeleteClicked(event.payload.usingSelected, event.payload.models, modelsToDelete);
			return;
		}

		if (event.actionName === MultipleItemActionEnum.Export) {
			this.onExportClicked(event.payload.usingSelected, event.payload.models);
			this.childCollection.onSelectAllCancel();
			return;
		}

		// % protected region % [Add any additional onMultipleItemsActionClicked logic after the main body here] off begin
		// % protected region % [Add any additional onMultipleItemsActionClicked logic after the main body here] end
	}

	/**
	 * Triggered when the user clicks on the `Create new` button.
	 */
	onCreateClicked() {
		// % protected region % [Customise onCreateClicked logic here] off begin
		this.triggerTileModeChange(CrudTileMode.Create);
		// % protected region % [Customise onCreateClicked logic here] end
	}

	/**
	 * Triggered when the user clicks the `Export All` button or the `Export` button when entities are selected
	 *
	 * @param usingSelected whether to use the export all or export all excluding action when exporting entities
	 * @param models the models to either export or exclude from the export, depending on usingSelected
	 */
	onExportClicked(usingSelected: boolean, models: TariffDefinitionModel[]) {
		// % protected region % [Customise onExportClicked logic here] off begin
		let actionType: modelAction.TariffDefinitionModelActionTypes;
		if (usingSelected) {
			actionType = modelAction.TariffDefinitionModelActionTypes.EXPORT_ALL_TARIFF_DEFINITION;
		} else {
			actionType = modelAction.TariffDefinitionModelActionTypes.EXPORT_TARIFF_DEFINITION_EXCLUDING_IDS;
		}

		this.store.dispatch(new modelAction.TariffDefinitionAction(
			actionType,
			{
				targetModelIds: models.map(model => model.id),
				queryParams: this.queryParams,
				collectionId: this.collectionId
			},
			[]
		));
		// % protected region % [Customise onExportClicked logic here] end
	}

	/**
	 * Import a CSV or download a CSV from the server with example headers
	 *
	 * @param file the CSV file to be imported.  This method also handles the example CSV so if file is not supplied this method will download an example CSV
	 */
	onImportClicked(file?: any) {
		// % protected region % [Customise onImportClicked logic here] off begin
		if (file) {
			this.store.dispatch(new modelAction.TariffDefinitionAction(
				modelAction.TariffDefinitionModelActionTypes.IMPORT_TARIFF_DEFINITIONS,
				{
					file: file,
				},
				[new modelAction.TariffDefinitionAction(
					modelAction.TariffDefinitionModelActionTypes.FETCH_TARIFF_DEFINITION_WITH_QUERY,
					{
						queryParams: this.queryParams,
						collectionId: this.collectionId
					},
					[
						new modelAction.TariffDefinitionAction(
							modelAction.TariffDefinitionModelActionTypes.COUNT_TARIFF_DEFINITIONS,
							null
						)
					]
				)]
			));
		} else {
			// This is the API Route for the import example CSV, so opening it in a new tab will trigger a download
			window.open(environment.API_URL + '/api/tariffdefinition/example-import');
		}
		// % protected region % [Customise onImportClicked logic here] end
	}

	/**
	 * Handle deletion of entities from the crud list.
	 * Deletion can come from multiple sources so this method will handle single deletion, as well as deletion through multiple selection
	 * @param usingSelected false if user has selected entities using the select all button, true otherwise.  Determines whether to use delete or delete excluding
	 * @param models the models to delete or exclude from deletion, depending on usingSelected
	 * @param modelsToDelete the number of models to delete, used to alter the error message to handle plurality.
	 * 							Also changes the action used if only 1 model is to be deleted.
	 * 							Required because models is not exclusively the models to delete, so models.length is not a valid substitute
	 */
	onDeleteClicked(usingSelected: boolean, models: TariffDefinitionModel[], modelsToDelete: number) {
		// % protected region % [Modify the modal variables here] off begin
		let modalTitle = 'Confirm';
		let modalConfirmButtonText = 'Confirm';
		let modalConfirmButtonClass = 'btn btn--outline';
		let modalCancelButtonText = 'Cancel';
		let modalCancelButtonClass = 'btn btn--outline';
		let modalPlaceOnTop = false;
		// % protected region % [Modify the modal variables here] end

		let modalText;

		if (modelsToDelete > 1) {
			// % protected region % [Customise the multiple item deletion message here] off begin
			modalText = 'Are you sure you want to delete the selected Tariff Definition entities?\n' +
					'This action cannot be reversed';
			// % protected region % [Customise the multiple item deletion message here] end
		} else {
			// % protected region % [Customise the deletion message here] off begin
			modalText = 'Are you sure you want to delete the selected Tariff Definition entity?\n' +
				'This action cannot be reversed';
			// % protected region % [Customise the deletion message here] end
		}

		this.modalService.openDialog(this.viewRef, {
			data: {
				text: modalText
			},
			settings: {
				// % protected region % [Modify the modal dialog settings here] off begin
				closeButtonClass: 'close theme-icon-close',
				modalDialogClass: 'modal-container',
				bodyClass: 'modal__message',
				footerClass: 'modal__actions'
				// % protected region % [Modify the modal dialog settings here] end
			},
			childComponent: SimpleModalComponent,
			placeOnTop: modalPlaceOnTop,
			title: modalTitle,
			actionButtons: [
				// % protected region % [Add any additional buttons before the default modal buttons here] off begin
				// % protected region % [Add any additional buttons before the default modal buttons here] end
				{
					text: modalConfirmButtonText,
					onAction: () => {
						// % protected region % [Add any additional logic before deleting the selected entities here] off begin
						// % protected region % [Add any additional logic before deleting the selected entities here] end

						let actionType: modelAction.TariffDefinitionModelActionTypes;
						if (modelsToDelete === 1) {
							actionType = modelAction.TariffDefinitionModelActionTypes.DELETE_TARIFF_DEFINITION;
						} else if (usingSelected) {
							actionType = modelAction.TariffDefinitionModelActionTypes.DELETE_ALL_TARIFF_DEFINITION;
						} else {
							actionType = modelAction.TariffDefinitionModelActionTypes.DELETE_TARIFF_DEFINITION_EXCLUDING_IDS;
						}

						this.store.dispatch(new modelAction.TariffDefinitionAction(
							actionType,
							// targetModelId and targetModelIds will not be used in the same request
							// unused fields in an action are ignored so adding both when only one is used cuts down on repetition
							{
								targetModelId: modelsToDelete === 1 ? models[0].id : null, // used in DELETE_TARIFF_DEFINITION when only one entity is present
								targetModelIds: modelsToDelete > 1 ? models.map(model => model.id) : null, // used in DELETE_ALL_TARIFF_DEFINITION and DELETE_TARIFF_DEFINITION_EXCLUDING_IDS
								queryParams: this.queryParams,
								collectionId: this.collectionId
							},
							[
								new modelAction.TariffDefinitionAction(
									modelAction.TariffDefinitionModelActionTypes.FETCH_TARIFF_DEFINITION_WITH_QUERY,
									{
										queryParams: this.queryParams,
										collectionId: this.collectionId
									},
									[
										new modelAction.TariffDefinitionAction(
											modelAction.TariffDefinitionModelActionTypes.COUNT_TARIFF_DEFINITIONS,
											null
										)
									]
								)
							]
						));

						// % protected region % [Add any additional logic after deleted the selected entities here] off begin
						// % protected region % [Add any additional logic after deleted the selected entities here] end

						this.childCollection.onSelectAllCancel();
						return true;
					},
					buttonClass: modalConfirmButtonClass
				},
				{
					text: modalCancelButtonText,
					onAction: () => {
						return true;
					},
					buttonClass: modalCancelButtonClass
				}
				// % protected region % [Add any additional buttons after the default modal buttons here] off begin
				// % protected region % [Add any additional buttons after the default modal buttons here] end
			]
		});
	}

	/**
	 * Triggered when a header in the collection is clicked
	 */
	onCollectionSort($event: OrderBy[]) {
		// % protected region % [Add any additional onCollectionSort logic before the main body here] off begin
		// % protected region % [Add any additional onCollectionSort logic before the main body here] end

		this.orderBy = $event;

		// % protected region % [Add any additional onCollectionSort logic before constructing a state config here] off begin
		// % protected region % [Add any additional onCollectionSort logic before constructing a state config here] end

		let stateConfig: PassableStateConfig<TariffDefinitionModel> = {
			queryParams: this.queryParams,
			collectionId: this.collectionId
		};

		// % protected region % [Add any additional onCollectionSort logic before dispatching event here] off begin
		// % protected region % [Add any additional onCollectionSort logic before dispatching event here] end

		this.store.dispatch(new modelAction.TariffDefinitionAction(
			modelAction.TariffDefinitionModelActionTypes.FETCH_TARIFF_DEFINITION_WITH_QUERY,
			stateConfig
		));

		// % protected region % [Add any additional onCollectionSort logic after the main body here] off begin
		// % protected region % [Add any additional onCollectionSort logic after the main body here] end
	}

	/**
	 * Triggered when a filter is applied
	 */
	onCollectionFilter($event: { isClean?: boolean, filterFormGroup: FormGroup }) {
		// % protected region % [Add any additional onCollectionFilter logic before the main body here] off begin
		// % protected region % [Add any additional onCollectionFilter logic before the main body here] end

		this.filterConditions = TariffDefinitionModel.convertFilterToCondition($event.filterFormGroup);

		// % protected region % [Add any additional onCollectionFilter logic before constructing a state config here] off begin
		// % protected region % [Add any additional onCollectionFilter logic before constructing a state config here] end

		// This block of code preserves the current page when using the filters
		this.pageIndex = this.currentPage;
		this.searchingOrFiltering = false;

		// When filters are cleared all of the conditions have a null value, so in this case we want the page number to be the page number prior to filtering
		// We start with keeping the page the same, and set the page value to 0 if there is any non null conditions
		// Implementing it this way as opposed to searching for null values allows us to break as soon as we find a non null value
		// searching for nulls would necessitate checking all conditions every time
		for (let condition of this.filterConditions) {
			if (condition[0].value) {
				this.pageIndex = 0;
				this.searchingOrFiltering = true;
				break;
			}
		}

		let stateConfig: PassableStateConfig<TariffDefinitionModel> = {
			queryParams: this.queryParams,
			collectionId: this.collectionId
		};

		// % protected region % [Add any additional onCollectionFilter logic before dispatching event here] off begin
		// % protected region % [Add any additional onCollectionFilter logic before dispatching event here] end

		this.store.dispatch(new modelAction.TariffDefinitionAction(
			modelAction.TariffDefinitionModelActionTypes.FETCH_TARIFF_DEFINITION_WITH_QUERY,
			stateConfig
		));

		// % protected region % [Add any additional onCollectionFilter logic after the main body here] off begin
		// % protected region % [Add any additional onCollectionFilter logic after the main body here] end
	}

	/**
	 * Triggered when type or hit the enter in the search box
	 * Do http request to fetch the search results
	 */
	onCollectionSearch(searchText: string) {
		// % protected region % [Add any additional logic here before change the search conditions] off begin
		// % protected region % [Add any additional logic here before change the search conditions] end

		if (searchText === '') {
			this.pageIndex = this.currentPage;
			this.searchingOrFiltering = false;
		} else {
			this.pageIndex = 0;
			this.searchingOrFiltering = true;
		}

		this.searchConditions = this.searchFields.map((field) => ({
			path: field,
			operation: QueryOperation.CONTAINS,
			value: searchText
		}));

		// % protected region % [Add any additional onCollectionSearch logic before constructing a state config here] off begin
		// % protected region % [Add any additional onCollectionSearch logic before constructing a state config here] end

		let stateConfig: PassableStateConfig<TariffDefinitionModel> = {
			queryParams: this.queryParams,
			collectionId: this.collectionId
		};

		// % protected region % [Add any additional onCollectionSearch logic after constructing a state config here] off begin
		// % protected region % [Add any additional onCollectionSearch logic after constructing a state config here] end

		this.store.dispatch(new modelAction.TariffDefinitionAction(
			modelAction.TariffDefinitionModelActionTypes.FETCH_TARIFF_DEFINITION_WITH_QUERY,
			stateConfig
		));

		// % protected region % [Add any additional logic here before the main logic of collection filtered] off begin
		// % protected region % [Add any additional logic here before the main logic of collection filtered] end
	}

	/**
	 * Triggered when there is a new request for first page.
	 */
	onFirstPageRequested() {
		// % protected region % [Add any additional onFirstPageRequested logic before the main body here] off begin
		// % protected region % [Add any additional onFirstPageRequested logic before the main body here] end

		this.pageIndex = 0;
		if (!this.searchingOrFiltering) {
			this.currentPage = this.pageIndex;
		}

		// % protected region % [Add any additional onFirstPageRequested logic before constructing a state config here] off begin
		// % protected region % [Add any additional onFirstPageRequested logic before constructing a state config here] end

		let stateConfig: PassableStateConfig<TariffDefinitionModel> = {
			queryParams: this.queryParams,
			collectionId: this.collectionId
		};

		// % protected region % [Add any additional onFirstPageRequested logic before dispatching event here] off begin
		// % protected region % [Add any additional onFirstPageRequested logic before dispatching event here] end

		this.store.dispatch(new modelAction.TariffDefinitionAction(
			modelAction.TariffDefinitionModelActionTypes.FETCH_TARIFF_DEFINITION_WITH_QUERY,
			stateConfig
		));

		// % protected region % [Add any additional onFirstPageRequested logic after the main body here] off begin
		// % protected region % [Add any additional onFirstPageRequested logic after the main body here] end
	}

	/**
	 * Triggered when there is a new request for previous page.
	 */
	onPrevPageRequested() {
		// % protected region % [Add any additional onPrevPageRequested logic before the main body here] off begin
		// % protected region % [Add any additional onPrevPageRequested logic before the main body here] end

		this.pageIndex -= 1;
		if (!this.searchingOrFiltering) {
			this.currentPage = this.pageIndex;
		}

		// % protected region % [Add any additional onPrevPageRequested logic before constructing a state config here] off begin
		// % protected region % [Add any additional onPrevPageRequested logic before constructing a state config here] end

		let stateConfig: PassableStateConfig<TariffDefinitionModel> = {
			queryParams: this.queryParams,
			collectionId: this.collectionId
		};

		// % protected region % [Add any additional onPrevPageRequested logic before dispatching event here] off begin
		// % protected region % [Add any additional onPrevPageRequested logic before dispatching event here] end

		this.store.dispatch(new modelAction.TariffDefinitionAction(
			modelAction.TariffDefinitionModelActionTypes.FETCH_TARIFF_DEFINITION_WITH_QUERY,
			stateConfig
		));

		// % protected region % [Add any additional onPrevPageRequested logic after the main body here] off begin
		// % protected region % [Add any additional onPrevPageRequested logic after the main body here] end
	}

	/**
	 * Triggered when there is a new request for next page.
	 */
	onNextPageRequested() {
		// % protected region % [Add any additional onNextPageRequested logic before the main body here] off begin
		// % protected region % [Add any additional onNextPageRequested logic before the main body here] end

		this.pageIndex += 1;
		if (!this.searchingOrFiltering) {
			this.currentPage = this.pageIndex;
		}

		// % protected region % [Add any additional onNextPageRequested logic before constructing a state config here] off begin
		// % protected region % [Add any additional onNextPageRequested logic before constructing a state config here] end

		let stateConfig: PassableStateConfig<TariffDefinitionModel> = {
			queryParams: this.queryParams,
			collectionId: this.collectionId
		};

		// % protected region % [Add any additional onNextPageRequested logic before dispatching event here] off begin
		// % protected region % [Add any additional onNextPageRequested logic before dispatching event here] end

		this.store.dispatch(new modelAction.TariffDefinitionAction(
			modelAction.TariffDefinitionModelActionTypes.FETCH_TARIFF_DEFINITION_WITH_QUERY,
			stateConfig
		));

		// % protected region % [Add any additional onNextPageRequested logic after the main body here] off begin
		// % protected region % [Add any additional onNextPageRequested logic after the main body here] end
	}

	/**
	 * Triggered when there is a new request for last page.
	 */
	onLastPageRequested() {
		// % protected region % [Add any additional onLastPageRequested logic before the main body here] off begin
		// % protected region % [Add any additional onLastPageRequested logic before the main body here] end

		this.pageIndex = Math.floor((this.tariffDefinitionsCount - 1) / this.pageSize);
		if (!this.searchingOrFiltering) {
			this.currentPage = this.pageIndex;
		}

		// % protected region % [Add any additional onLastPageRequested logic before constructing a state config here] off begin
		// % protected region % [Add any additional onLastPageRequested logic before constructing a state config here] end

		let stateConfig: PassableStateConfig<TariffDefinitionModel> = {
			queryParams: this.queryParams,
			collectionId: this.collectionId
		};

		// % protected region % [Add any additional onLastPageRequested logic before dispatching event here] off begin
		// % protected region % [Add any additional onLastPageRequested logic before dispatching event here] end

		this.store.dispatch(new modelAction.TariffDefinitionAction(
			modelAction.TariffDefinitionModelActionTypes.FETCH_TARIFF_DEFINITION_WITH_QUERY,
			stateConfig
		));

		// % protected region % [Add any additional onLastPageRequested logic after the main body here] off begin
		// % protected region % [Add any additional onLastPageRequested logic after the main body here] end
	}


	/**
	 * Check if current user can create this entity
	 *
	 * @returns True if create is allowed for current user
	 */
	private canCreate(): boolean {

		const allowedGroups = [
			'MANAGEMENT_USER',
			'REGISTRATION_USER',
			'SYSTEM_ADMIN_USER',
			'ADMINISTRATION_USER',
			'WAREHOUSE_USER',
			'FACILITY_USER',
			'CASHIER_USER',
			'NURSE_USER',
			'ADMINISTRATOR',
			'MEDICAL_RECORD_USER',
			'PHARMACY_USER',
			'PURCHASING_USER',
		];

		return this.authenticationService.isPermitted(allowedGroups);
	}

	/**
	 * Check if current user can edit this entity
	 *
	 * @returns True if create is allowed for current user
	 */
	private canEdit(): boolean {

		const allowedGroups = [
			'MANAGEMENT_USER',
			'REGISTRATION_USER',
			'SYSTEM_ADMIN_USER',
			'ADMINISTRATION_USER',
			'WAREHOUSE_USER',
			'FACILITY_USER',
			'CASHIER_USER',
			'NURSE_USER',
			'ADMINISTRATOR',
			'MEDICAL_RECORD_USER',
			'PHARMACY_USER',
			'PURCHASING_USER',
		];

		return this.authenticationService.isPermitted(allowedGroups);
	}

	/**
	 * Check if current user can delete this entity
	 *
	 * @returns True if create is allowed for current user
	 */
	private canDelete(): boolean {

		const allowedGroups = [
			'MANAGEMENT_USER',
			'REGISTRATION_USER',
			'WAREHOUSE_USER',
			'FACILITY_USER',
			'NURSE_USER',
			'ADMINISTRATOR',
			'MEDICAL_RECORD_USER',
			'PHARMACY_USER',
			'PURCHASING_USER',
		];

		return this.authenticationService.isPermitted(allowedGroups);
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
