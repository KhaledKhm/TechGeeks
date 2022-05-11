/*var ajaxRevslider;

    jQuery(document).ready(function() {
        // CUSTOM AJAX CONTENT LOADING FUNCTION
        ajaxRevslider = function(obj) {

            // obj.type : Post Type
            // obj.id : ID of Content to Load
            // obj.aspectratio : The Aspect Ratio of the Container / Media
            // obj.selector : The Container Selector where the Content of Ajax will be injected. It is done via the Essential Grid on Return of Content

            var content = "";

            data = {};

            data.action = 'revslider_ajax_call_front';
            data.client_action = 'get_slider_html';
            data.token = '4757b3374c';
            data.type = obj.type;
            data.id = obj.id;
            data.aspectratio = obj.aspectratio;

            // SYNC AJAX REQUEST
            jQuery.ajax({
                type: "post",
                url: "http://bestdeals.axiomthemes.com/wp-admin/admin-ajax.php",
                dataType: 'json',
                data: data,
                async: false,
                success: function(ret, textStatus, XMLHttpRequest) {
                    if (ret.success == true)
                        content = ret.data;
                },
                error: function(e) {
                    console.log(e);
                }
            });

            // FIRST RETURN THE CONTENT WHEN IT IS LOADED !!
            return content;
        };

        // CUSTOM AJAX FUNCTION TO REMOVE THE SLIDER
        var ajaxRemoveRevslider = function(obj) {
            return jQuery(obj.selector + " .rev_slider").revkill();
        };

        // EXTEND THE AJAX CONTENT LOADING TYPES WITH TYPE AND FUNCTION
        var extendessential = setInterval(function() {
            if (jQuery.fn.tpessential != undefined) {
                clearInterval(extendessential);
                if (typeof(jQuery.fn.tpessential.defaults) !== 'undefined') {
                    jQuery.fn.tpessential.defaults.ajaxTypes.push({
                        type: "revslider",
                        func: ajaxRevslider,
                        killfunc: ajaxRemoveRevslider,
                        openAnimationSpeed: 0.3
                    });
                    // type:  Name of the Post to load via Ajax into the Essential Grid Ajax Container
                    // func: the Function Name which is Called once the Item with the Post Type has been clicked
                    // killfunc: function to kill in case the Ajax Window going to be removed (before Remove function !
                    // openAnimationSpeed: how quick the Ajax Content window should be animated (default is 0.3)
                }
            }
        }, 30);
    });*/



 var htmlDiv = document.getElementById("rs-plugin-settings-inline-css");
    var htmlDivCss = "";
    if (htmlDiv) {
        htmlDiv.innerHTML = htmlDiv.innerHTML + htmlDivCss;
    } else {
        var htmlDiv = document.createElement("div");
        htmlDiv.innerHTML = "<style>" + htmlDivCss + "</style>";
        document.getElementsByTagName("head")[0].appendChild(htmlDiv.childNodes[0]);
    }


/*var htmlDiv = document.getElementById("rs-plugin-settings-inline-css");
    var htmlDivCss = ".tp-caption.WebProduct-Content,.WebProduct-Content{color:rgba(153,153,153,1.00);font-size:16px;line-height:24px;font-weight:600;font-style:normal;font-family:Raleway;padding:0px 0px 0px 0px;text-decoration:none;background-color:transparent;border-color:transparent;border-style:none;border-width:0px;border-radius:0px 0px 0px 0px}";
    if (htmlDiv) {
        htmlDiv.innerHTML = htmlDiv.innerHTML + htmlDivCss;
    } else {
        var htmlDiv = document.createElement("div");
        htmlDiv.innerHTML = "<style>" + htmlDivCss + "</style>";
        document.getElementsByTagName("head")[0].appendChild(htmlDiv.childNodes[0]);
}*/


/******************************************
                    -   PREPARE PLACEHOLDER FOR SLIDER  -
                ******************************************/

    var setREVStartSize = function() {
        try {
            var e = new Object,
                i = jQuery(window).width(),
                t = 9999,
                r = 0,
                n = 0,
                l = 0,
                f = 0,
                s = 0,
                h = 0;
            e.c = jQuery('#rev_slider_6_1');
            e.responsiveLevels = [1240, 1024, 778, 480];
            e.gridwidth = [1240, 1024, 778, 480];
            e.gridheight = [600, 600, 500, 400];

            e.sliderLayout = "auto";
            if (e.responsiveLevels && (jQuery.each(e.responsiveLevels, function(e, f) {
                    f > i && (t = r = f, l = e), i > f && f > r && (r = f, n = e)
                }), t > r && (l = n)), f = e.gridheight[l] || e.gridheight[0] || e.gridheight, s = e.gridwidth[l] || e.gridwidth[0] || e.gridwidth, h = i / s, h = h > 1 ? 1 : h, f = Math.round(h * f), "fullscreen" == e.sliderLayout) {
                var u = (e.c.width(), jQuery(window).height());
                if (void 0 != e.fullScreenOffsetContainer) {
                    var c = e.fullScreenOffsetContainer.split(",");
                    if (c) jQuery.each(c, function(e, i) {
                        u = jQuery(i).length > 0 ? u - jQuery(i).outerHeight(!0) : u
                    }), e.fullScreenOffset.split("%").length > 1 && void 0 != e.fullScreenOffset && e.fullScreenOffset.length > 0 ? u -= jQuery(window).height() * parseInt(e.fullScreenOffset, 0) / 100 : void 0 != e.fullScreenOffset && e.fullScreenOffset.length > 0 && (u -= parseInt(e.fullScreenOffset, 0))
                }
                f = u
            } else void 0 != e.minHeight && f < e.minHeight && (f = e.minHeight);
            e.c.closest(".rev_slider_wrapper").css({
                height: f
            })

        } catch (d) {
            console.log("Failure at Presize of Slider:" + d)
        }
    };

    setREVStartSize();

    var tpj = jQuery;

    var revapi6;
    tpj(document).ready(function() {
        if (tpj("#rev_slider_6_1").revolution == undefined) {
            revslider_showDoubleJqueryError("#rev_slider_6_1");
        } else {
            revapi6 = tpj("#rev_slider_6_1").show().revolution({
                sliderType: "standard",
                jsFileLocation: "//bestdeals.axiomthemes.com/wp-content/plugins/revslider/public/assets/js/",
                sliderLayout: "auto",
                dottedOverlay: "none",
                delay: 9000,
                navigation: {
                    keyboardNavigation: "off",
                    keyboard_direction: "horizontal",
                    mouseScrollNavigation: "off",
                    mouseScrollReverse: "default",
                    onHoverStop: "off",
                    touch: {
                        touchenabled: "on",
                        swipe_threshold: 75,
                        swipe_min_touches: 50,
                        swipe_direction: "horizontal",
                        drag_block_vertical: false
                    },
                    bullets: {
                        enable: true,
                        hide_onmobile: true,
                        hide_under: 600,
                        style: "zeus",
                        hide_onleave: false,
                        direction: "horizontal",
                        h_align: "left",
                        v_align: "bottom",
                        h_offset: 0,
                        v_offset: 55,
                        space: 11,
                        tmp: '<span class="tp-bullet-image"></span><span class="tp-bullet-imageoverlay"></span><span class="tp-bullet-title">{{title}}</span>'
                    }
                },
                responsiveLevels: [1240, 1024, 778, 480],
                visibilityLevels: [1240, 1024, 778, 480],
                gridwidth: [1240, 1024, 778, 480],
                gridheight: [600, 600, 500, 400],
                lazyType: "smart",
                parallax: {
                    type: "mouse",
                    origo: "slidercenter",
                    speed: 2000,
                    levels: [2, 3, 4, 5, 6, 7, 12, 16, 10, 50, 46, 47, 48, 49, 50, 55],
                    type: "mouse",
                },
                shadow: 0,
                spinner: "off",
                stopLoop: "off",
                stopAfterLoops: -1,
                stopAtSlide: -1,
                shuffle: "off",
                autoHeight: "off",
                hideThumbsOnMobile: "off",
                hideSliderAtLimit: 0,
                hideCaptionAtLimit: 0,
                hideAllCaptionAtLilmit: 0,
                debugMode: false,
                fallbacks: {
                    simplifyAll: "off",
                    nextSlideOnWindowFocus: "off",
                    disableFocusListener: false,
                }
            });
        }
    }); /*ready*/


