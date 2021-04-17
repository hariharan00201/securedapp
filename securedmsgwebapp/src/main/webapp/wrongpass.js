if ($('#wrong').val() == "1")
	$('#res').html('Wrong Password').css('color', 'red');
$('#uname, #pass').on('keyup', function() {
	$('#res').html('');
});