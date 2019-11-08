$(document).ready(function() {
	
	$('#datetimepicker').datetimepicker({
		format: 'DD/MM/YYYY',
		locale: locale,		
		tooltips: {
            today: datetimepicker.today,
            clear: datetimepicker.clear,
            close: datetimepicker.close,
            selectMonth:  datetimepicker.selectMonth,
            prevMonth: datetimepicker.prevMonth,
            nextMonth: datetimepicker.nextMonth,
            selectYear: datetimepicker.selectYear,
            prevYear: datetimepicker.prevYear,
            nextYear: datetimepicker.nextYear,
            selectDecade: datetimepicker.selectDecade,
            prevDecade: datetimepicker.prevDecade,
            nextDecade: datetimepicker.nextDecade,
            prevCentury: datetimepicker.prevCentury,
            nextCentury: datetimepicker.nextCentury,
            pickHour: datetimepicker.pickHour,
            incrementHour: datetimepicker.incrementHour,
            decrementHour: datetimepicker.decrementHour,
            pickMinute: datetimepicker.pickMinute,
            incrementMinute: datetimepicker.incrementMinute,
            decrementMinute: datetimepicker.decrementMinute,
            pickSecond: datetimepicker.pickSecond,
            incrementSecond: datetimepicker.incrementSecond,
            decrementSecond: datetimepicker.decrementSecond,
            togglePeriod: datetimepicker.togglePeriod,
            selectTime: datetimepicker.selectTime
        }
	});
	
	$('#datetimepicker').datetimepicker().on('dp.show', function(e) {
		var elementDate = $(this);
	});
	
	$('#example').DataTable({
        "language": {
            "url": "locales/dataTables/" + locale + ".lang"
        }
    });
	
});