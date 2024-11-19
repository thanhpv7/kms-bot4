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
 * Enumeration depicting the various predefined group alignment options for the card component.
 */
export enum CardGroupAlignment {
	HORIZONTAL = 'horizontal',
	VERTICAL = 'vertical',
}

/**
 * Default CSS classes to be applied to the card group component.
 */
const defaultCardGroupClasses = [
	'cards-wrapper',
	// % protected region % [Add any additional CSS classes here for card group] off begin
	// % protected region % [Add any additional CSS classes here for card group] end
];

/**
 * Card group element
 */
@Component({
	// % protected region % [Modify the existing component configurations here] off begin
	selector: 'cb-card-group,*[cb-card-group]',
	templateUrl: './card.group.component.html',
	// % protected region % [Modify the existing component configurations here] end
	styleUrls: [
		// % protected region % [Add any additional SCSS imports here] off begin
		// % protected region % [Add any additional SCSS imports here] end
	],
	// % protected region % [Add any additional component configurations here] off begin
	// % protected region % [Add any additional component configurations here] end
})
export class CardGroupComponent extends AbstractComponent implements OnChanges, OnInit {
	/**
	 * All of the CSS classes to be applied to the card.
	 */
	cardGroupClasses: string[];

	/**
	 * String of the class bind to the class in root element
	 */
	@HostBinding('class')
	get cardGroupClassesString() {
		return this.cardGroupClasses.join(' ');
	}

	/**
	 * Alignment of the card group
	 * In the CardGroupAlignment
	 * Default to be horizontal
	 */
	@Input()
	cardGroupAlignment = CardGroupAlignment.HORIZONTAL;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	ngOnChanges(changes: SimpleChanges) {
		// % protected region % [Add any additional ngOnChange logic before main body here] off begin
		// % protected region % [Add any additional ngOnChange logic before main body here] end

		this.reloadCardGroupClasses();

		// % protected region % [Add any additional ngOnChange logic after main body here] off begin
		// % protected region % [Add any additional ngOnChange logic after main body here] end
	}

	ngOnInit() {
		// % protected region % [Add any additional ngOnInit logic before main body here] off begin
		// % protected region % [Add any additional ngOnInit logic before main body here] end

		// need to reload class again in case no input change
		this.reloadCardGroupClasses();

		// % protected region % [Add any additional ngOnInit logic after main body here] off begin
		// % protected region % [Add any additional ngOnInit logic after main body here] end
	}

	/**
	 * Simple method used to read in properties and modify the card group classes accordingly.
	 */
	private reloadCardGroupClasses() {

		this.cardGroupClasses = [
			...defaultCardGroupClasses,
			this.cardGroupAlignment,
		];

		if (this.className) {
			this.cardGroupClasses.push(this.className);
		}
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
