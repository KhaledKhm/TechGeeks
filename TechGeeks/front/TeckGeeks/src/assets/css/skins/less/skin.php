<?php
/**
 * Skin file for the Template.
 */

// Disable direct call
if ( ! defined( 'ABSPATH' ) ) { exit; }

// Template init
if (!function_exists('cloe_brooks_action_skin_theme_setup')) {
	add_action( 'cloe_brooks_action_init_theme', 'cloe_brooks_action_skin_theme_setup', 1 );
	function cloe_brooks_action_skin_theme_setup() {

		// Add skin fonts in the used fonts list
		add_filter('cloe_brooks_filter_used_fonts',			'cloe_brooks_filter_skin_used_fonts');
		// Add skin fonts (from Google fonts) in the main fonts list (if not present).
		add_filter('cloe_brooks_filter_list_fonts',			'cloe_brooks_filter_skin_list_fonts');

		// Add skin stylesheets
		add_action('cloe_brooks_action_add_styles',			'cloe_brooks_action_skin_add_styles');
		// Add skin inline styles
		add_filter('cloe_brooks_filter_add_styles_inline',		'cloe_brooks_filter_skin_add_styles_inline');
		// Add skin responsive styles
		add_action('cloe_brooks_action_add_responsive',		'cloe_brooks_action_skin_add_responsive');
		// Add skin responsive inline styles
		add_filter('cloe_brooks_filter_add_responsive_inline',	'cloe_brooks_filter_skin_add_responsive_inline');

		// Add skin scripts
		add_action('cloe_brooks_action_add_scripts',			'cloe_brooks_action_skin_add_scripts');
		// Add skin scripts inline
		add_action('cloe_brooks_action_add_scripts_inline',	'cloe_brooks_action_skin_add_scripts_inline');

		// Add skin less files into list for compilation
		add_filter('cloe_brooks_filter_compile_less',			'cloe_brooks_filter_skin_compile_less');


		/* Color schemes
		
		// Accenterd colors
		accent1			- Template accented color 1
		accent1_hover	- Template accented color 1 (hover state)
		accent2			- Template accented color 2
		accent2_hover	- Template accented color 2 (hover state)		
		accent3			- Template accented color 3
		accent3_hover	- Template accented color 3 (hover state)		
		
		// Headers, text and links
		text			- main content
		text_light		- post info
		text_dark		- headers
		inverse_text	- text on accented background
		inverse_light	- post info on accented background
		inverse_dark	- headers on accented background
		inverse_link	- links on accented background
		inverse_hover	- hovered links on accented background
		
		// Block's border and background
		bd_color		- border for the entire block
		bg_color		- background color for the entire block
		bg_image, bg_image_position, bg_image_repeat, bg_image_attachment  - first background image for the entire block
		bg_image2,bg_image2_position,bg_image2_repeat,bg_image2_attachment - second background image for the entire block
		
		// Alternative colors - highlight blocks, form fields, etc.
		alter_text		- text on alternative background
		alter_light		- post info on alternative background
		alter_dark		- headers on alternative background
		alter_link		- links on alternative background
		alter_hover		- hovered links on alternative background
		alter_bd_color	- alternative border
		alter_bd_hover	- alternative border for hovered state or active field
		alter_bg_color	- alternative background
		alter_bg_hover	- alternative background for hovered state or active field 
		alter_bg_image, alter_bg_image_position, alter_bg_image_repeat, alter_bg_image_attachment - background image for the alternative block
		
		*/

		// Add color schemes
		cloe_brooks_add_color_scheme('original', array(

			'title'					=> esc_html__('Original', 'cloe-brooks'),

			// Accent colors
			'accent1'				=> '#EDB39B',
			'accent1_hover'			=> '#72b5ca',
//			'accent2'				=> '#ff0000',
//			'accent2_hover'			=> '#aa0000',
//			'accent3'				=> '',
//			'accent3_hover'			=> '',
			
			// Headers, text and links colors
			'text'					=> '#6f6f6f',
			'text_light'			=> '#afafaf',
			'text_dark'				=> '#33302e',
			'inverse_text'			=> '#ffffff',
			'inverse_light'			=> '#504b47',
			'inverse_dark'			=> '#ffffff',
			'inverse_link'			=> '#ffffff',
			'inverse_hover'			=> '#ffffff',
			
			// Whole block border and background
			'bd_color'				=> '#e4e7e8',
			'bg_color'				=> '#ffffff',
			'bg_image'				=> '',
			'bg_image_position'		=> 'left top',
			'bg_image_repeat'		=> 'repeat',
			'bg_image_attachment'	=> 'scroll',
			'bg_image2'				=> '',
			'bg_image2_position'	=> 'left top',
			'bg_image2_repeat'		=> 'repeat',
			'bg_image2_attachment'	=> 'scroll',
		
			// Alternative blocks (submenu items, form's fields, etc.)
			'alter_text'			=> '#6f6f6f',
			'alter_light'			=> '#afafaf',
			'alter_dark'			=> '#33302e',
			'alter_link'			=> '#edb39b',
			'alter_hover'			=> '#72b5ca',
			'alter_bd_color'		=> '#fcf7f1',
			'alter_bd_hover'		=> '#f0e8e3',
			'alter_bg_color'		=> '#fcf7f1',
			'alter_bg_hover'		=> '#fcf7f1',
			'alter_bg_image'			=> '',
			'alter_bg_image_position'	=> 'left top',
			'alter_bg_image_repeat'		=> 'repeat',
			'alter_bg_image_attachment'	=> 'scroll',
			)
		);

		// Add color schemes
		cloe_brooks_add_color_scheme('light', array(

			'title'					=> esc_html__('Light', 'cloe-brooks'),

			// Accent colors
			'accent1'				=> '#EDB39B',
			'accent1_hover'			=> '#72b5ca',
//			'accent2'				=> '#ff0000',
//			'accent2_hover'			=> '#aa0000',
//			'accent3'				=> '',
//			'accent3_hover'			=> '',

				// Headers, text and links colors
			'text'					=> '#6f6f6f',
			'text_light'			=> '#afafaf',
			'text_dark'				=> '#33302e',
			'inverse_text'			=> '#ffffff',
			'inverse_light'			=> '#504b47',
			'inverse_dark'			=> '#ffffff',
			'inverse_link'			=> '#ffffff',
			'inverse_hover'			=> '#ffffff',

				// Whole block border and background
			'bd_color'				=> '#e4e7e8',
			'bg_color'				=> '#fcf7f1',
			'bg_image'				=> '',
			'bg_image_position'		=> 'left top',
			'bg_image_repeat'		=> 'repeat',
			'bg_image_attachment'	=> 'scroll',
			'bg_image2'				=> '',
			'bg_image2_position'	=> 'left top',
			'bg_image2_repeat'		=> 'repeat',
			'bg_image2_attachment'	=> 'scroll',

				// Alternative blocks (submenu items, form's fields, etc.)
			'alter_text'			=> '#6f6f6f',
			'alter_light'			=> '#afafaf',
			'alter_dark'			=> '#33302e',
			'alter_link'			=> '#edb39b',
			'alter_hover'			=> '#72b5ca',
			'alter_bd_color'		=> '#ffffff',
			'alter_bd_hover'		=> '#f6f6f6',
			'alter_bg_color'		=> '#ffffff',
			'alter_bg_hover'		=> '#ffffff',
			'alter_bg_image'			=> '',
			'alter_bg_image_position'	=> 'left top',
			'alter_bg_image_repeat'		=> 'repeat',
			'alter_bg_image_attachment'	=> 'scroll',
			)
		);

		// Add color schemes
		cloe_brooks_add_color_scheme('dark', array(

			'title'					=> esc_html__('Dark', 'cloe-brooks'),

			// Accent colors
			'accent1'				=> '#ffffff',
			'accent1_hover'			=> '#EBC6B6',
//			'accent2'				=> '#ff0000',
//			'accent2_hover'			=> '#aa0000',
//			'accent3'				=> '',
//			'accent3_hover'			=> '',
			
			// Headers, text and links colors
			'text'					=> '#B1B0AF',
			'text_light'			=> '#ffffff',
			'text_dark'				=> '#6F6F6F',
			'inverse_text'			=> '#B1B0AF',
			'inverse_light'			=> '#6F6F6F',
			'inverse_dark'			=> '#ffffff',
			'inverse_link'			=> '#EBC6B6',
			'inverse_hover'			=> '#72B5CA',
			
			// Whole block border and background
			'bd_color'				=> '#696460',
			'bg_color'				=> '#504B47',
			'bg_image'				=> '',
			'bg_image_position'		=> 'left top',
			'bg_image_repeat'		=> 'repeat',
			'bg_image_attachment'	=> 'scroll',
			'bg_image2'				=> '',
			'bg_image2_position'	=> 'left top',
			'bg_image2_repeat'		=> 'repeat',
			'bg_image2_attachment'	=> 'scroll',
		
			// Alternative blocks (submenu items, form's fields, etc.)
			'alter_text'			=> '#B1B0AF',
			'alter_light'			=> '#ffffff',
			'alter_dark'			=> '#6f6f6f',
			'alter_link'			=> '#EDB39B',
			'alter_hover'			=> '#72B5CA',
			'alter_bd_color'		=> '#ffffff',
			'alter_bd_hover'		=> '#504B47',
			'alter_bg_color'		=> '#ffffff',
			'alter_bg_hover'		=> '#ffffff',
			'alter_bg_image'			=> '',
			'alter_bg_image_position'	=> 'left top',
			'alter_bg_image_repeat'		=> 'repeat',
			'alter_bg_image_attachment'	=> 'scroll',
			)
		);

		/* Font slugs:
		h1 ... h6	- headers
		p			- plain text
		link		- links
		info		- info blocks (Posted 15 May, 2015 by John Doe)
		menu		- main menu
		submenu		- dropdown menus
		logo		- logo text
		button		- button's caption
		input		- input fields
		*/

		// Add Custom fonts
		cloe_brooks_add_custom_font('h1', array(
			'title'			=> esc_html__('Heading 1', 'cloe-brooks'),
			'description'	=> '',
			'font-family'	=> 'texgyretermes',
			'font-size' 	=> '3.666em',
			'font-weight'	=> '400',
			'font-style'	=> '',
			'line-height'	=> '1.3em',
			'margin-top'	=> '1.222em',
			'margin-bottom'	=> '0.275em'
			)
		);
		cloe_brooks_add_custom_font('h2', array(
			'title'			=> esc_html__('Heading 2', 'cloe-brooks'),
			'description'	=> '',
			'font-family'	=> 'texgyretermes',
			'font-size' 	=> '3em',
			'font-weight'	=> '400',
			'font-style'	=> '',
			'line-height'	=> '1.3em',
			'margin-top'	=> '1.222em',
			'margin-bottom'	=> '0.333em'
			)
		);
		cloe_brooks_add_custom_font('h3', array(
			'title'			=> esc_html__('Heading 3', 'cloe-brooks'),
			'description'	=> '',
			'font-family'	=> 'texgyretermes',
			'font-size' 	=> '2.333em',
			'font-weight'	=> '400',
			'font-style'	=> '',
			'line-height'	=> '1.3em',
			'margin-top'	=> '1.714em',
			'margin-bottom'	=> '1.2em'
			)
		);
		cloe_brooks_add_custom_font('h4', array(
			'title'			=> esc_html__('Heading 4', 'cloe-brooks'),
			'description'	=> '',
			'font-family'	=> 'Aller',
			'font-size' 	=> '1.53em',
			'font-weight'	=> '300',
			'font-style'	=> '',
			'line-height'	=> '1.3em',
			'margin-top'	=> '2em',
			'margin-bottom'	=> '0.65em'
			)
		);
		cloe_brooks_add_custom_font('h5', array(
			'title'			=> esc_html__('Heading 5', 'cloe-brooks'),
			'description'	=> '',
			'font-family'	=> 'Aller',
			'font-size' 	=> '1.4em',
			'font-weight'	=> '400',
			'font-style'	=> '',
			'line-height'	=> '1.3em',
			'margin-top'	=> '2.14em',
			'margin-bottom'	=> '0.715em'
			)
		);
		cloe_brooks_add_custom_font('h6', array(
			'title'			=> esc_html__('Heading 6', 'cloe-brooks'),
			'description'	=> '',
			'font-family'	=> 'Aller',
			'font-size' 	=> '1.2em',
			'font-weight'	=> '400',
			'font-style'	=> '',
			'line-height'	=> '1.3em',
			'margin-top'	=> '2.666em',
			'margin-bottom'	=> '0.833em'
			)
		);
		cloe_brooks_add_custom_font('p', array(
			'title'			=> esc_html__('Text', 'cloe-brooks'),
			'description'	=> '',
			'font-family'	=> 'Aller',
			'font-size' 	=> '15px',
			'font-weight'	=> '300',
			'font-style'	=> '',
			'line-height'	=> '1.85em',
			'margin-top'	=> '',
			'margin-bottom'	=> '1em'
			)
		);
		cloe_brooks_add_custom_font('link', array(
			'title'			=> esc_html__('Links', 'cloe-brooks'),
			'description'	=> '',
			'font-family'	=> '',
			'font-size' 	=> '',
			'font-weight'	=> '',
			'font-style'	=> ''
			)
		);
		cloe_brooks_add_custom_font('info', array(
			'title'			=> esc_html__('Post info', 'cloe-brooks'),
			'description'	=> '',
			'font-family'	=> '',
			'font-size' 	=> '0.8em',
			'font-weight'	=> '',
			'font-style'	=> '',
			'line-height'	=> '1.2857em',
			'margin-top'	=> '',
			'margin-bottom'	=> '1.5em'
			)
		);
		cloe_brooks_add_custom_font('menu', array(
			'title'			=> esc_html__('Main menu items', 'cloe-brooks'),
			'description'	=> '',
			'font-family'	=> '',
			'font-size' 	=> '0.866em',
			'font-weight'	=> '400',
			'font-style'	=> '',
			'line-height'	=> '1.2857em',
			'margin-top'	=> '1.8em',
			'margin-bottom'	=> '1.8em'
			)
		);
		cloe_brooks_add_custom_font('submenu', array(
			'title'			=> esc_html__('Dropdown menu items', 'cloe-brooks'),
			'description'	=> '',
			'font-family'	=> '',
			'font-size' 	=> '',
			'font-weight'	=> '',
			'font-style'	=> '',
			'line-height'	=> '1.2857em',
			'margin-top'	=> '',
			'margin-bottom'	=> ''
			)
		);
		cloe_brooks_add_custom_font('logo', array(
			'title'			=> esc_html__('Logo', 'cloe-brooks'),
			'description'	=> '',
			'font-family'	=> '',
			'font-size' 	=> '2.8571em',
			'font-weight'	=> '700',
			'font-style'	=> '',
			'line-height'	=> '0.75em',
			'margin-top'	=> '3.333em',
			'margin-bottom'	=> '3.333em'
			)
		);
		cloe_brooks_add_custom_font('button', array(
			'title'			=> esc_html__('Buttons', 'cloe-brooks'),
			'description'	=> '',
			'font-family'	=> '',
			'font-size' 	=> '1em',
			'font-weight'	=> '300',
			'font-style'	=> '',
			'line-height'	=> '1.4em'
			)
		);
		cloe_brooks_add_custom_font('input', array(
			'title'			=> esc_html__('Input fields', 'cloe-brooks'),
			'description'	=> '',
			'font-family'	=> '',
			'font-size' 	=> '',
			'font-weight'	=> '300',
			'font-style'	=> '',
			'line-height'	=> '1.2857em'
			)
		);

	}
}





//------------------------------------------------------------------------------
// Skin's fonts
//------------------------------------------------------------------------------

// Add skin fonts in the used fonts list
if (!function_exists('cloe_brooks_filter_skin_used_fonts')) {
	//add_filter('cloe_brooks_filter_used_fonts', 'cloe_brooks_filter_skin_used_fonts');
	function cloe_brooks_filter_skin_used_fonts($Template_fonts) {
		//$Template_fonts['Roboto'] = 1;
		//$Template_fonts['Love Ya Like A Sister'] = 1;
		return $theme_fonts;
	}
}

// Add skin fonts (from Google fonts) in the main fonts list (if not present).
// To use custom font-face you not need add it into list in this function
// How to install custom @font-face fonts into the Template?
// All @font-face fonts are located in "Template_name/css/font-face/" folder in the separate subfolders for the each font. Subfolder name is a font-family name!
// Place full set of the font files (for each font style and weight) and css-file named stylesheet.css in the each subfolder.
// Create your @font-face kit by using Fontsquirrel @font-face Generator (http://www.fontsquirrel.com/fontface/generator)
// and then extract the font kit (with folder in the kit) into the "Template_name/css/font-face" folder to install
if (!function_exists('cloe_brooks_filter_skin_list_fonts')) {
	//add_filter('cloe_brooks_filter_list_fonts', 'cloe_brooks_filter_skin_list_fonts');
	function cloe_brooks_filter_skin_list_fonts($list) {
        if (!isset($list['Aller'])) {
            $list['Aller'] = array(
                'family' => 'sans-serif',
                'css'    => cloe_brooks_get_file_url('/css/font-face/aller/stylesheet.css ')
            );
        }
        if (!isset($list['texgyretermes'])) {
            $list['texgyretermes'] = array(
                'family' => 'serif',
                'css'    => cloe_brooks_get_file_url('/css/font-face/tex-gyre-termes/stylesheet.css ')
            );
        }
		return $list;
	}
}



//------------------------------------------------------------------------------
// Skin's stylesheets
//------------------------------------------------------------------------------
// Add skin stylesheets
if (!function_exists('cloe_brooks_action_skin_add_styles')) {
	//add_action('cloe_brooks_action_add_styles', 'cloe_brooks_action_skin_add_styles');
	function cloe_brooks_action_skin_add_styles() {
		// Add stylesheet files
		cloe_brooks_enqueue_style( 'cloe_brooks-skin-style', cloe_brooks_get_file_url('skin.css'), array(), null );
		if (file_exists(cloe_brooks_get_file_dir('skin.customizer.css')))
			cloe_brooks_enqueue_style( 'cloe_brooks-skin-customizer-style', cloe_brooks_get_file_url('skin.customizer.css'), array(), null );
	}
}

// Add skin inline styles
if (!function_exists('cloe_brooks_filter_skin_add_styles_inline')) {
	//add_filter('cloe_brooks_filter_add_styles_inline', 'cloe_brooks_filter_skin_add_styles_inline');
	function cloe_brooks_filter_skin_add_styles_inline($custom_style) {
		// Todo: add skin specific styles in the $custom_style to override
		//       rules from style.css and shortcodes.css
		// Example:
		//		$scheme = cloe_brooks_get_custom_option('body_scheme');
		//		if (empty($scheme)) $scheme = 'original';
		//		$clr = cloe_brooks_get_scheme_color('accent1');
		//		if (!empty($clr)) {
		// 			$custom_style .= '
		//				a,
		//				.bg_tint_light a,
		//				.top_panel .content .search_wrap.search_style_regular .search_form_wrap .search_submit,
		//				.top_panel .content .search_wrap.search_style_regular .search_icon,
		//				.search_results .post_more,
		//				.search_results .search_results_close {
		//					color:'.esc_attr($clr).';
		//				}
		//			';
		//		}
		return $custom_style;	
	}
}

// Add skin responsive styles
if (!function_exists('cloe_brooks_action_skin_add_responsive')) {
	//add_action('cloe_brooks_action_add_responsive', 'cloe_brooks_action_skin_add_responsive');
	function cloe_brooks_action_skin_add_responsive() {
		$suffix = cloe_brooks_param_is_off(cloe_brooks_get_custom_option('show_sidebar_outer')) ? '' : '-outer';
		if (file_exists(cloe_brooks_get_file_dir('skin.responsive'.($suffix).'.css'))) 
			cloe_brooks_enqueue_style( 'theme-skin-responsive-style', cloe_brooks_get_file_url('skin.responsive'.($suffix).'.css'), array(), null );
	}
}

// Add skin responsive inline styles
if (!function_exists('cloe_brooks_filter_skin_add_responsive_inline')) {
	//add_filter('cloe_brooks_filter_add_responsive_inline', 'cloe_brooks_filter_skin_add_responsive_inline');
	function cloe_brooks_filter_skin_add_responsive_inline($custom_style) {
		return $custom_style;	
	}
}

// Add skin.less into list files for compilation
if (!function_exists('cloe_brooks_filter_skin_compile_less')) {
	//add_filter('cloe_brooks_filter_compile_less', 'cloe_brooks_filter_skin_compile_less');
	function cloe_brooks_filter_skin_compile_less($files) {
		if (file_exists(cloe_brooks_get_file_dir('skin.less'))) {
		 	$files[] = cloe_brooks_get_file_dir('skin.less');
		}
		return $files;	
	}
}



//------------------------------------------------------------------------------
// Skin's scripts
//------------------------------------------------------------------------------

// Add skin scripts
if (!function_exists('cloe_brooks_action_skin_add_scripts')) {
	//add_action('cloe_brooks_action_add_scripts', 'cloe_brooks_action_skin_add_scripts');
	function cloe_brooks_action_skin_add_scripts() {
		if (file_exists(cloe_brooks_get_file_dir('skin.js')))
			cloe_brooks_enqueue_script( 'theme-skin-script', cloe_brooks_get_file_url('skin.js'), array(), null );
		if (cloe_brooks_get_theme_option('show_theme_customizer') == 'yes' && file_exists(cloe_brooks_get_file_dir('skin.customizer.js')))
			cloe_brooks_enqueue_script( 'theme-skin-customizer-script', cloe_brooks_get_file_url('skin.customizer.js'), array(), null );
	}
}

// Add skin scripts inline
if (!function_exists('cloe_brooks_action_skin_add_scripts_inline')) {
	//add_action('cloe_brooks_action_add_scripts_inline', 'cloe_brooks_action_skin_add_scripts_inline');
	function cloe_brooks_action_skin_add_scripts_inline() {
		// Todo: add skin specific scripts
		// Example:
		// echo '<script type="text/javascript">'
		//	. 'jQuery(document).ready(function() {'
		//	. "if (CLOE_BROOKS_STORAGE['theme_font']=='') CLOE_BROOKS_STORAGE['theme_font'] = '" . cloe_brooks_get_custom_font_settings('p', 'font-family') . "';"
		//	. "CLOE_BROOKS_STORAGE['theme_skin_color'] = '" . cloe_brooks_get_scheme_color('accent1') . "';"
		//	. "});"
		//	. "< /script>";
	}
}
?>