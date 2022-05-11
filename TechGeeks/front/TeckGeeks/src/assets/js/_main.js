    "use strict";
/* Template globals */
"use strict";
    if (typeof CLOE_BROOKS_STORAGE == 'undefined') var CLOE_BROOKS_STORAGE = {};
    CLOE_BROOKS_STORAGE['ajax_url'] = '#';
    CLOE_BROOKS_STORAGE['ajax_nonce'] = '011affe4dd';
    CLOE_BROOKS_STORAGE['site_url'] = 'http://cloe-brooks-html.themerex.net';
    CLOE_BROOKS_STORAGE['edit_mode'] = false;
    CLOE_BROOKS_STORAGE['theme_font'] = 'Aller';
    CLOE_BROOKS_STORAGE['theme_skin'] = 'less';
    CLOE_BROOKS_STORAGE['theme_skin_color'] = '#33302e';
    CLOE_BROOKS_STORAGE['theme_skin_bg_color'] = '#ffffff';
    CLOE_BROOKS_STORAGE['slider_height'] = 640;
    CLOE_BROOKS_STORAGE['system_message'] = {
        message: '',
        status: '',
        header: ''
    };
    CLOE_BROOKS_STORAGE['user_logged_in'] = false;
    CLOE_BROOKS_STORAGE['toc_menu'] = 'hide';
    CLOE_BROOKS_STORAGE['toc_menu_home'] = false;
    CLOE_BROOKS_STORAGE['toc_menu_top'] = false;
    CLOE_BROOKS_STORAGE['menu_fixed'] = true;
    CLOE_BROOKS_STORAGE['menu_mobile'] = 1024;
    CLOE_BROOKS_STORAGE['menu_slider'] = false;
    CLOE_BROOKS_STORAGE['menu_cache'] = false;
    CLOE_BROOKS_STORAGE['demo_time'] = 0;
    CLOE_BROOKS_STORAGE['media_elements_enabled'] = true;
    CLOE_BROOKS_STORAGE['ajax_search_enabled'] = true;
    CLOE_BROOKS_STORAGE['ajax_search_min_length'] = 3;
    CLOE_BROOKS_STORAGE['ajax_search_delay'] = 200;
    CLOE_BROOKS_STORAGE['css_animation'] = true;
    CLOE_BROOKS_STORAGE['menu_animation_in'] = 'fadeIn';
    CLOE_BROOKS_STORAGE['menu_animation_out'] = 'fadeOut';
    CLOE_BROOKS_STORAGE['popup_engine'] = 'magnific';
    CLOE_BROOKS_STORAGE['email_mask'] = '^([a-zA-Z0-9_\-]+\.)*[a-zA-Z0-9_\-]+@[a-z0-9_\-]+(\.[a-z0-9_\-]+)*\.[a-z]{2,6}$';
    CLOE_BROOKS_STORAGE['contacts_maxlength'] = 1000;
    CLOE_BROOKS_STORAGE['comments_maxlength'] = 1000;
    CLOE_BROOKS_STORAGE['remember_visitors_settings'] = false;
    CLOE_BROOKS_STORAGE['admin_mode'] = false;
    CLOE_BROOKS_STORAGE['isotope_resize_delta'] = 0.3;
    CLOE_BROOKS_STORAGE['error_message_box'] = null;
    CLOE_BROOKS_STORAGE['viewmore_busy'] = false;
    CLOE_BROOKS_STORAGE['video_resize_inited'] = false;
    CLOE_BROOKS_STORAGE['top_panel_height'] = 0;


// Javascript String constants for translation */
 if (typeof CLOE_BROOKS_STORAGE == 'undefined') var CLOE_BROOKS_STORAGE = {};
    CLOE_BROOKS_STORAGE["strings"] = {
        ajax_error: "Invalid server answer",
        bookmark_add: "Add the bookmark",
        bookmark_added: "Current page has been successfully added to the bookmarks. You can see it in the right panel on the tab &#039;Bookmarks&#039;",
        bookmark_del: "Delete this bookmark",
        bookmark_title: "Enter bookmark title",
        bookmark_exists: "Current page already exists in the bookmarks list",
        search_error: "Error occurs in AJAX search! Please, type your query and press search icon for the traditional search way.",
        email_confirm: "On the e-mail address &quot;%s&quot; we sent a confirmation email. Please, open it and click on the link.",
        reviews_vote: "Thanks for your vote! New average rating is:",
        reviews_error: "Error saving your vote! Please, try again later.",
        error_like: "Error saving your like! Please, try again later.",
        error_global: "Global error text",
        name_empty: "The name can&#039;t be empty",
        name_long: "Too long name",
        email_empty: "Too short (or empty) email address",
        email_long: "Too long email address",
        email_not_valid: "Invalid email address",
        subject_empty: "The subject can&#039;t be empty",
        subject_long: "Too long subject",
        text_empty: "The message text can&#039;t be empty",
        text_long: "Too long message text",
        send_complete: "Send message complete!",
        send_error: "Transmit failed!",
        login_empty: "The Login field can&#039;t be empty",
        login_long: "Too long login field",
        login_success: "Login success! The page will be reloaded in 3 sec.",
        login_failed: "Login failed!",
        password_empty: "The password can&#039;t be empty and shorter then 4 characters",
        password_long: "Too long password",
        password_not_equal: "The passwords in both fields are not equal",
        registration_success: "Registration success! Please log in!",
        registration_failed: "Registration failed!",
        geocode_error: "Geocode was not successful for the following reason:",
        googlemap_not_avail: "Google map API not available!",
        editor_save_success: "Post content saved!",
        editor_save_error: "Error saving post data!",
        editor_delete_post: "You really want to delete the current post?",
        editor_delete_post_header: "Delete post",
        editor_delete_success: "Post deleted!",
        editor_delete_error: "Error deleting post!",
        editor_caption_cancel: "Cancel",
        editor_caption_close: "Close"
    };

// template parameters
    if (typeof CLOE_BROOKS_STORAGE == 'undefined') var CLOE_BROOKS_STORAGE = {};
    if (CLOE_BROOKS_STORAGE['theme_font'] == '') CLOE_BROOKS_STORAGE['theme_font'] = 'Aller';
    CLOE_BROOKS_STORAGE['theme_skin_color'] = '#33302e';
    CLOE_BROOKS_STORAGE['theme_skin_bg_color'] = '#ffffff'; 

// phone_mask
    jQuery("document").ready(function() {
        "use strict";
        CLOE_BROOKS_STORAGE['phone_mask'] = '^[0-9\-\+]{9,15}$';
        CLOE_BROOKS_STORAGE["strings"]["phone_not_valid"] = "Invalid phone number";
        CLOE_BROOKS_STORAGE["strings"]["phone_empty"] = "The phone can not be empty";
        CLOE_BROOKS_STORAGE["strings"]["phone_wrong"] = "The phone is wrong";
    });

    window._wpemojiSettings = {
        "baseUrl": "https:\/\/s.w.org\/images\/core\/emoji\/72x72\/",
        "ext": ".png",
        "source": {
            "concatemoji": "http:\/\/cloe-brooks.themerex.net\/wp-includes\/js\/wp-emoji-release.min.js?ver=4.5.4"
        }
    };

    !function(a, b, c) {
        "use strict";
        function d(a) {
            var c, d, e, f = b.createElement("canvas"),
                g = f.getContext && f.getContext("2d"),
                h = String.fromCharCode;
            if (!g || !g.fillText) return !1;
            switch (g.textBaseline = "top", g.font = "600 32px Arial", a) {
                case "flag":
                    return g.fillText(h(55356, 56806, 55356, 56826), 0, 0), f.toDataURL().length > 3e3;
                case "diversity":
                    return g.fillText(h(55356, 57221), 0, 0), c = g.getImageData(16, 16, 1, 1).data, d = c[0] + "," + c[1] + "," + c[2] + "," + c[3], g.fillText(h(55356, 57221, 55356, 57343), 0, 0), c = g.getImageData(16, 16, 1, 1).data, e = c[0] + "," + c[1] + "," + c[2] + "," + c[3], d !== e;
                case "simple":
                    return g.fillText(h(55357, 56835), 0, 0), 0 !== g.getImageData(16, 16, 1, 1).data[0];
                case "unicode8":
                    return g.fillText(h(55356, 57135), 0, 0), 0 !== g.getImageData(16, 16, 1, 1).data[0]
            }
            return !1
        }
//DOMContentLoaded
        function e(a) {
            var c = b.createElement("script");
            c.src = a, c.type = "text/javascript", b.getElementsByTagName("head")[0].appendChild(c)
        }
        var f, g, h, i;
        for (i = Array("simple", "flag", "unicode8", "diversity"), c.supports = {
                everything: !0,
                everythingExceptFlag: !0
            }, h = 0; h < i.length; h++) c.supports[i[h]] = d(i[h]), c.supports.everything = c.supports.everything && c.supports[i[h]], "flag" !== i[h] && (c.supports.everythingExceptFlag = c.supports.everythingExceptFlag && c.supports[i[h]]);
        c.supports.everythingExceptFlag = c.supports.everythingExceptFlag && !c.supports.flag, c.DOMReady = !1, c.readyCallback = function() {
            c.DOMReady = !0
        }, c.supports.everything || (g = function() {
            c.readyCallback()
        }, b.addEventListener ? (b.addEventListener("DOMContentLoaded", g, !1), a.addEventListener("load", g, !1)) : (a.attachEvent("onload", g), b.attachEvent("onreadystatechange", function() {
            "complete" === b.readyState && c.readyCallback()
        })), f = c.source || {}, f.concatemoji ? e(f.concatemoji) : f.wpemoji && f.twemoji && (e(f.twemoji), e(f.wpemoji)))
    }(window, document, window._wpemojiSettings);


// tribe_events_linked_posts
    var tribe_events_linked_posts = {
        "post_types": {
            "tribe_venue": "venue",
            "tribe_organizer": "organizer"
        }
    };


// BP_DTheme
    var BP_DTheme = {
        "accepted": "Accepted",
        "close": "Close",
        "comments": "comments",
        "leave_group_confirm": "Are you sure you want to leave this group?",
        "mark_as_fav": "Favorite",
        "my_favs": "My Favorites",
        "rejected": "Rejected",
        "remove_fav": "Remove Favorite",
        "show_all": "Show all",
        "show_all_comments": "Show all comments for this thread",
        "show_x_comments": "Show all %d comments",
        "unsaved_changes": "Your profile has unsaved changes. If you leave the page, the changes will be lost.",
        "view": "View"
    };

/* <![CDATA[ */
    var mejsL10n = {
        "language": "en-US",
        "strings": {
            "Close": "Close",
            "Fullscreen": "Fullscreen",
            "Download File": "Download File",
            "Download Video": "Download Video",
            "Play\/Pause": "Play\/Pause",
            "Mute Toggle": "Mute Toggle",
            "None": "None",
            "Turn off Fullscreen": "Turn off Fullscreen",
            "Go Fullscreen": "Go Fullscreen",
            "Unmute": "Unmute",
            "Mute": "Mute",
            "Captions\/Subtitles": "Captions\/Subtitles"
        }
    };

// ajaxRevslider
    var ajaxRevslider;
    jQuery(document).ready(function() {
        // CUSTOM AJAX CONTENT LOADING FUNCTION
        ajaxRevslider = function(obj) {
            // obj.type : Post Type
            // obj.id : ID of Content to Load
            // obj.aspectratio : The Aspect Ratio of the Container / Media
            // obj.selector : The Container Selector where the Content of Ajax will be injected. It is done via the Essential Grid on Return of Content
            var content = "";
            var data = {};
            data.action = 'revslider_ajax_call_front';
            data.client_action = 'get_slider_html';
            data.token = '1b287f4497';
            data.type = obj.type;
            data.id = obj.id;
            data.aspectratio = obj.aspectratio;

            // SYNC AJAX REQUEST
            jQuery.ajax({
                type: "post",
                url: "#",
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
    });

// wc_single_product_params
    var wc_single_product_params = {"i18n_required_rating_text":"Please select a rating","review_rating_required":"yes"};

// wc_cart_fragments_params
    var wc_cart_fragments_params = {"ajax_url":"#","fragment_name":"wc_fragments"};

// woocommerce_params
    var woocommerce_params = {"ajax_url":"#"};

// Revslider
    function revslider_showDoubleJqueryError(sliderID) {
        var errorMessage = "Revolution Slider Error: You have some jquery.js library include that comes after the revolution files js include.";
        errorMessage += "<br> This includes make eliminates the revolution slider libraries, and make it not work.";
        errorMessage += "<br><br> To fix it you can:<br>&nbsp;&nbsp;&nbsp; 1. In the Slider Settings -> Troubleshooting set option:  <strong><b>Put JS Includes To Body</b></strong> option to true.";
        errorMessage += "<br>&nbsp;&nbsp;&nbsp; 2. Find the double jquery.js include and remove it.";
        errorMessage = "<span style='font-size:16px;color:#BC0C06;'>" + errorMessage + "</span>";
        jQuery(sliderID).show().html(errorMessage);
    }

    var htmlDivCss = unescape(".hesperiden.tparrows%20%7B%0A%09cursor%3Apointer%3B%0A%09background%3Argba%280%2C0%2C0%2C0.5%29%3B%0A%09width%3A40px%3B%0A%09height%3A40px%3B%0A%09position%3Aabsolute%3B%0A%09display%3Ablock%3B%0A%09z-index%3A100%3B%0A%20%20%20%20border-radius%3A%2050%25%3B%0A%7D%0A.hesperiden.tparrows%3Ahover%20%7B%0A%09background%3Argba%280%2C%200%2C%200%2C%201%29%3B%0A%7D%0A.hesperiden.tparrows%3Abefore%20%7B%0A%09font-family%3A%20%22revicons%22%3B%0A%09font-size%3A20px%3B%0A%09color%3Argb%28255%2C%20255%2C%20255%29%3B%0A%09display%3Ablock%3B%0A%09line-height%3A%2040px%3B%0A%09text-align%3A%20center%3B%0A%7D%0A.hesperiden.tparrows.tp-leftarrow%3Abefore%20%7B%0A%09content%3A%20%22%5Ce82c%22%3B%0A%20%20%20%20margin-left%3A-3px%3B%0A%7D%0A.hesperiden.tparrows.tp-rightarrow%3Abefore%20%7B%0A%09content%3A%20%22%5Ce82d%22%3B%0A%20%20%20%20margin-right%3A-3px%3B%0A%7D%0A");
    var htmlDiv = document.getElementById('rs-plugin-settings-inline-css');
    if (htmlDiv) {
        htmlDiv.innerHTML = htmlDiv.innerHTML + htmlDivCss;
    } else {
        var htmlDiv = document.createElement('div');
        htmlDiv.innerHTML = '<style>' + htmlDivCss + '</style>';
        document.getElementsByTagName('head')[0].appendChild(htmlDiv.childNodes[0]);
    }

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
        e.c = jQuery('#rev_slider_1_1');
        e.gridwidth = [1170];
        e.gridheight = [640];

        e.sliderLayout = "fullwidth";
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

var revapi1;
tpj(document).ready(function() {
if (tpj("#rev_slider_1_1").revolution == undefined) {
    revslider_showDoubleJqueryError("#rev_slider_1_1");
} else {
    revapi1 = tpj("#rev_slider_1_1").show().revolution({
        sliderType: "standard",
        sliderLayout: "fullwidth",
        dottedOverlay: "none",
        delay: 7000,
        navigation: {
            keyboardNavigation: "off",
            keyboard_direction: "horizontal",
            mouseScrollNavigation: "off",
            mouseScrollReverse: "default",
            onHoverStop: "off",
            arrows: {
                style: "hesperiden",
                enable: true,
                hide_onmobile: true,
                hide_under: 1365,
                hide_onleave: false,
                tmp: '',
                left: {
                    h_align: "left",
                    v_align: "center",
                    h_offset: 20,
                    v_offset: 0
                },
                right: {
                    h_align: "right",
                    v_align: "center",
                    h_offset: 20,
                    v_offset: 0
                }
            }
        },
        visibilityLevels: [1240, 1024, 778, 480],
        gridwidth: 1170,
        gridheight: 640,
        lazyType: "none",
        shadow: 0,
        spinner: "spinner0",
        stopLoop: "off",
        stopAfterLoops: -1,
        stopAtSlide: -1,
        shuffle: "off",
        autoHeight: "off",
        disableProgressBar: "on",
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

var htmlDiv = document.getElementById("rs-plugin-settings-inline-css");
var htmlDivCss = ".tp-caption.home_1_subtitle,.home_1_subtitle{color:rgba(255,255,255,1.00);font-size:15px;line-height:22px;font-weight:300;font-style:normal;font-family:Aller;padding:0 0 0 0px;text-decoration:none;text-align:left;background-color:transparent;border-color:transparent;border-style:none;border-width:0px;border-radius:0 0 0 0px}.tp-caption.home1_title,.home1_title{color:rgba(255,255,255,1.00);font-size:65px;line-height:80px;font-weight:300;font-style:normal;font-family:Aller;padding:0 0 0 0px;text-decoration:none;text-align:left;background-color:transparent;border-color:transparent;border-style:none;border-width:0px;border-radius:0 0 0 0px}.tp-caption.home1_text,.home1_text{color:rgba(255,255,255,1.00);font-size:22px;line-height:26px;font-weight:300;font-style:normal;font-family:Aller;padding:0 0 0 0px;text-decoration:none;text-align:left;background-color:transparent;border-color:transparent;border-style:none;border-width:0px;border-radius:0 0 0 0px}";
if (htmlDiv) {
htmlDiv.innerHTML = htmlDiv.innerHTML + htmlDivCss;
} else {
var htmlDiv = document.createElement("div");
htmlDiv.innerHTML = "<style>" + htmlDivCss + "</style>";
document.getElementsByTagName("head")[0].appendChild(htmlDiv.childNodes[0]);
}

var htmlDiv = document.getElementById("rs-plugin-settings-inline-css");
var htmlDivCss = "";
if (htmlDiv) {
    htmlDiv.innerHTML = htmlDiv.innerHTML + htmlDivCss;
} else {
    var htmlDiv = document.createElement("div");
    htmlDiv.innerHTML = "<style>" + htmlDivCss + "</style>";
    document.getElementsByTagName("head")[0].appendChild(htmlDiv.childNodes[0]);
}
