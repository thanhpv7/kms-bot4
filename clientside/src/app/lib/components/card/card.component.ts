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

import {Component, HostBinding, Input, OnChanges, OnInit, SimpleChanges, HostListener} from '@angular/core';
import {AbstractComponent} from '../abstract.component';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Default CSS classes to be applied to the card component.
 */
const defaultCardClasses = [
	'card',
	// % protected region % [Add any additional CSS classes here for card ] off begin
	// % protected region % [Add any additional CSS classes here for card ] end
];

/**
 * Card element
 */
@Component({
	// % protected region % [Modify the existing component configurations here] off begin
	selector: 'cb-card,*[cb-card]',
	templateUrl: './card.component.html',
	// % protected region % [Modify the existing component configurations here] end
	styleUrls: [
		// % protected region % [Add any additional SCSS imports here] off begin
		// % protected region % [Add any additional SCSS imports here] end
	],
	// % protected region % [Add any additional component configurations here] off begin
	// % protected region % [Add any additional component configurations here] end
})
export class CardComponent extends AbstractComponent implements OnChanges, OnInit {
	/**
	 * All of the CSS classes to be applied to the card.
	 */
	cardClasses: string[];

	/**
	 * String of the class bind to the class in root element
	 */
	@HostBinding('class')
	get cardClassesString() {
		return this.cardClasses.join(' ');
	}

	@Input()
	href: string | undefined = undefined;

	@Input()
	icon: string | undefined = undefined;

	get iconClassNames() {
		return this.icon ? this.icon + ' icon icon-only' : '';
	}

	@Input()
	rounded: boolean = true;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	ngOnChanges(changes: SimpleChanges) {
		// % protected region % [Add any additional ngOnChange logic before main body here] off begin
		// % protected region % [Add any additional ngOnChange logic before main body here] end

		this.reloadCardClasses();

		// % protected region % [Add any additional ngOnChange logic after main body here] off begin
		// % protected region % [Add any additional ngOnChange logic after main body here] end
	}

	ngOnInit() {
		// % protected region % [Add any additional ngOnInit logic before main body here] off begin
		// % protected region % [Add any additional ngOnInit logic before main body here] end

		// need to reload class again in case no input change
		this.reloadCardClasses();

		// % protected region % [Add any additional ngOnInit logic after main body here] off begin
		// % protected region % [Add any additional ngOnInit logic after main body here] end
	}

	/**
	 * If a href has been defined, open link in new tab when clicked
	 */
	onClick() {
		if (this.href) {
			window.open(this.href);
		}
	}

	/**
	 * Simple method used to read in properties and modify the card  classes accordingly.
	 */
	private reloadCardClasses() {

		this.cardClasses = [
			...defaultCardClasses,
			this.rounded ? 'card--rounded' : '',
		];

		if (this.className) {
			this.cardClasses.push(this.className);
		}
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
