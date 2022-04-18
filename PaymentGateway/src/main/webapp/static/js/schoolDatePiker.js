$(function() {
//alert('aaaaaaaaaaa txtId omkar :');
var d = new Date();
	$('input').filter('.datepicker').datepicker({
		   //showOn: both - datepicker will appear clicking the input box as well as the calendar icon
		   //showOn: button - datepicker will appear only on clicking the calendar icon
		   showOn: 'button',
		   //you can use your local path also eg. buttonImage: 'images/x_office_calendar.png'
		   buttonImage: '',		   
		   onclick: true,
		   defaultDate: d,
		   changeMonth: true,
		   changeYear: true,
		   showAnim: 'slideDown',
		   duration: 'fast',
		  // yearRange: '1800:2200', 
		  yearRange: (new Date().getFullYear()-200).toString()+':' + (new Date().getFullYear()+200).toString(),
		   dateFormat: 'dd/mm/yy'
	   });
	   //$('input').filter('.datepicker').datepicker('setDate', d);
});

