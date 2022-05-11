function cloe_brooks_googlemap_init(dom_obj, coords) {
	"use strict";
	if (typeof CLOE_BROOKS_STORAGE['googlemap_init_obj'] == 'undefined') cloe_brooks_googlemap_init_styles();
	CLOE_BROOKS_STORAGE['googlemap_init_obj'].geocoder = '';
	try {
		var id = dom_obj.id;
		CLOE_BROOKS_STORAGE['googlemap_init_obj'][id] = {
			dom: dom_obj,
			markers: coords.markers,
			geocoder_request: false,
			opt: {
				zoom: coords.zoom,
				center: null,
				scrollwheel: false,
				scaleControl: false,
				disableDefaultUI: false,
				panControl: true,
				zoomControl: true, //zoom
				mapTypeControl: false,
				streetViewControl: false,
				overviewMapControl: false,
				styles: CLOE_BROOKS_STORAGE['googlemap_styles'][coords.style ? coords.style : 'default'],
				mapTypeId: google.maps.MapTypeId.ROADMAP
			}
		};
		
		cloe_brooks_googlemap_create(id);

	} catch (e) {
		
		dcl(CLOE_BROOKS_STORAGE['strings']['googlemap_not_avail']);

	};
}

function cloe_brooks_googlemap_create(id) {
	"use strict";

	// Create map
	CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].map = new google.maps.Map(CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].dom, CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].opt);

	// Add markers
	for (var i in CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers)
		CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].inited = false;
	cloe_brooks_googlemap_add_markers(id);
	
	// Add resize listener
	jQuery(window).resize(function() {
		if (CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].map)
			CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].map.setCenter(CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].opt.center);
	});
}

function cloe_brooks_googlemap_add_markers(id) {
	"use strict";
	for (var i in CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers) {
		
		if (CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].inited) continue;
		
		if (CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].latlng == '') {
			
			if (CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].geocoder_request!==false) continue;
			
			if (CLOE_BROOKS_STORAGE['googlemap_init_obj'].geocoder == '') CLOE_BROOKS_STORAGE['googlemap_init_obj'].geocoder = new google.maps.Geocoder();
			CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].geocoder_request = i;
			CLOE_BROOKS_STORAGE['googlemap_init_obj'].geocoder.geocode({address: CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].address}, function(results, status) {
				"use strict";
				if (status == google.maps.GeocoderStatus.OK) {
					var idx = CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].geocoder_request;
					if (results[0].geometry.location.lat && results[0].geometry.location.lng) {
						CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[idx].latlng = '' + results[0].geometry.location.lat() + ',' + results[0].geometry.location.lng();
					} else {
						CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[idx].latlng = results[0].geometry.location.toString().replace(/\(\)/g, '');
					}
					CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].geocoder_request = false;
					setTimeout(function() { 
						cloe_brooks_googlemap_add_markers(id); 
						}, 200);
				} else
					dcl(CLOE_BROOKS_STORAGE['strings']['geocode_error'] + ' ' + status);
			});
		
		} else {
			
			// Prepare marker object
			var latlngStr = CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].latlng.split(',');
			var markerInit = {
				map: CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].map,
				position: new google.maps.LatLng(latlngStr[0], latlngStr[1]),
				clickable: CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].description!=''
			};
			if (CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].point) markerInit.icon = CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].point;
			if (CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].title) markerInit.title = CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].title;
			CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].marker = new google.maps.Marker(markerInit);
			
			// Set Map center
			if (CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].opt.center == null) {
				CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].opt.center = markerInit.position;
				CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].map.setCenter(CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].opt.center);				
			}
			
			// Add description window
			if (CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].description!='') {
				CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].infowindow = new google.maps.InfoWindow({
					content: CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].description
				});
				google.maps.event.addListener(CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].marker, "click", function(e) {
					var latlng = e.latLng.toString().replace("(", '').replace(")", "").replace(" ", "");
					for (var i in CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers) {
						if (latlng == CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].latlng) {
							CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].infowindow.open(
								CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].map,
								CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].marker
							);
							break;
						}
					}
				});
			}
			
			CLOE_BROOKS_STORAGE['googlemap_init_obj'][id].markers[i].inited = true;
		}
	}
}

function cloe_brooks_googlemap_refresh() {
	"use strict";
	for (id in CLOE_BROOKS_STORAGE['googlemap_init_obj']) {
		cloe_brooks_googlemap_create(id);
	}
}

function cloe_brooks_googlemap_init_styles() {
	// Init Google map
	CLOE_BROOKS_STORAGE['googlemap_init_obj'] = {};
	CLOE_BROOKS_STORAGE['googlemap_styles'] = {
		'default': []
	};
	if (window.cloe_brooks_theme_googlemap_styles!==undefined)
		CLOE_BROOKS_STORAGE['googlemap_styles'] = cloe_brooks_theme_googlemap_styles(CLOE_BROOKS_STORAGE['googlemap_styles']);
}