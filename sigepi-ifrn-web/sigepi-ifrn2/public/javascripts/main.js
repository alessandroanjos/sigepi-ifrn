$('.alert .close').hover(
	function() { $(this).addClass('hover'); },
	function() { $(this).removeClass('hover'); }
);
	
setInterval(function() {
	$('.alert').fadeOut('fast', function() { $(this).remove(); });
}, 15000);
