if ($('#already').val() == "1")
		$('#alr').html('The User Name Is Already Taken').css('color', 'red');
if ($('#already').val() == "2")
		$('#alr').html('You Dont Have a Account, SIGNIN To Continue').css('color', 'red');

$('form').validate();


$('#pass, #cpass, #uname').on('keyup', function() {
	$('#alr').html('');
	if ($('#pass').val() == $('#cpass').val()) {
		$('#res').html('Matching').css('color', 'green');
		$('#confirm').prop('disabled', false);
	} else {
		$('#res').html('Not Matching').css('color', 'red');
		$('#confirm').prop('disabled', true);
	}
});

