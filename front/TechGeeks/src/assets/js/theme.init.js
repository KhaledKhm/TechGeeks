/* global jQuery:false */
/* global CLOE_BROOKS_STORAGE:false */


// Template-specific first load actions
//==============================================
function cloe_brooks_theme_ready_actions() {
	"use strict";
	// Put here your init code with Template-specific actions
	// It will be called before core actions
}


// Template-specific scroll actions
//==============================================
function cloe_brooks_theme_scroll_actions() {
	"use strict";
	// Put here your Template-specific code with scroll actions
	// It will be called when page is scrolled (before core actions)
}


// Template-specific resize actions
//==============================================
function cloe_brooks_theme_resize_actions() {
	"use strict";
	// Put here your Template-specific code with resize actions
	// It will be called when window is resized (before core actions)
	setTimeout(ColumnsFitLargerHeight, 20);
}


// Template-specific shortcodes init
//=====================================================
function cloe_brooks_theme_sc_init(cont) {
	"use strict";
	// Put here your Template-specific code to init shortcodes
	// It will be called before core init shortcodes
	// @param cont - jQuery-container with shortcodes (init only inside this container)
}


// Template-specific post-formats init
//=====================================================
function cloe_brooks_theme_init_post_formats() {
	"use strict";
	// Put here your Template-specific code to init post-formats
	// It will be called before core init post_formats when page is loaded or after 'Load more' or 'Infinite scroll' actions
}

// Fit height to the larger value of child elements
function ColumnsFitLargerHeight() {
	if (jQuery('.autoheight.columns_wrap').length > 0) {
		jQuery('.autoheight.columns_wrap').each(function () {
			"use strict";
			var tallestcolumn = 0;
			var columns = jQuery(this).children("div");
			columns.css({"height":"auto"});
			columns.each(
				function () {
					var currentHeight = jQuery(this).height();
					if (currentHeight > tallestcolumn) {
						tallestcolumn = currentHeight;
					}
				}
			);
			if (jQuery(window).width() > 479) {
				columns.height(tallestcolumn);
			} else {
				columns.css({"height":"auto"});
			}
		});
	}
}

// Template -specific GoogleMap styles
//=====================================================
function cloe_brooks_theme_googlemap_styles($styles) {
	"use strict";
	// Put here your Template-specific code to add GoogleMap styles
	// It will be called before GoogleMap init when page is loaded
	$styles['greyscale'] = [
    	{ "stylers": [
        	{ "saturation": -100 }
            ]
        }
	];
	$styles['inverse'] = [
		{ "stylers": [
			{ "invert_lightness": true },
			{ "visibility": "on" }
			]
		}
	];
	$styles['standart'] = [{"featureType":"landscape.man_made","elementType":"geometry","stylers":[{"color":"#f7f1df"}]},{"featureType":"landscape.natural","elementType":"geometry","stylers":[{"color":"#d0e3b4"}]},{"featureType":"landscape.natural.terrain","elementType":"geometry","stylers":[{"visibility":"off"}]},{"featureType":"poi","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"poi.business","elementType":"all","stylers":[{"visibility":"off"}]},{"featureType":"poi.medical","elementType":"geometry","stylers":[{"color":"#fbd3da"}]},{"featureType":"poi.park","elementType":"geometry","stylers":[{"color":"#bde6ab"}]},{"featureType":"road","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"road.highway","elementType":"geometry.fill","stylers":[{"color":"#ffe15f"}]},{"featureType":"road.highway","elementType":"geometry.stroke","stylers":[{"color":"#efd151"}]},{"featureType":"road.arterial","elementType":"geometry.fill","stylers":[{"color":"#ffffff"}]},{"featureType":"road.local","elementType":"geometry.fill","stylers":[{"color":"black"}]},{"featureType":"transit.station.airport","elementType":"geometry.fill","stylers":[{"color":"#cfb2db"}]},{"featureType":"water","elementType":"geometry","stylers":[{"color":"#a2daf2"}]}];
	$styles['simple'] = [
    	{ stylers: [
        	{ hue: "#00ffe6" },
            { saturation: -20 }
			]
		},
		{ featureType: "road",
          elementType: "geometry",
          stylers: [
			{ lightness: 100 },
           	{ visibility: "simplified" }
            ]
		},
		{ featureType: "road",
          elementType: "labels",
          stylers: [
          	{ visibility: "off" }
            ]
		}
	];
	return $styles;
	
}