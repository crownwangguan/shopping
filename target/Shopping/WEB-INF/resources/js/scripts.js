/**
 * Created by guan on 31/05/17.
 */
jQuery(document).ready(function($){
	//smart links
	jQuery('a[href="#"]').on('click', function(e){
		e.preventDefault();
		$(this).toggleClass("btn-success");
	});

});