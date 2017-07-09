/*
source: https://developer.mozilla.org/en-US/docs/Rich-Text_Editing_in_Mozilla#Executing_Commands
*/

$('.wysiwyg-controls a').on('click', function(e) {

	e.preventDefault();
	switch($(this).data('role')) {
		case 'h1':
		case 'h2':
		case 'h3':
		case 'h4':
		case 'h5':
		case 'h6':
			document.execCommand('formatBlock', false, '<' + $(this).data('role') + '>');
			break;
		default:
			document.execCommand($(this).data('role'), false);
			break;
	}

});