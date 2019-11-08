package com.base.app.application.web.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.base.app.application.web.constants.WebConstants;

public class AppUtils {

	public static LocalDateTime stringToLocalDateTime(String value, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime formatDate = LocalDateTime.parse(value, formatter);
		return formatDate;
	}
	
	public static Date stringToDate(String value, String format) throws ParseException {
		  	DateFormat inFormat = new SimpleDateFormat(format);
		    inFormat.setTimeZone(TimeZone.getTimeZone(WebConstants.TIME_ZONE));
		    return inFormat.parse(value);  
	}

	public static String DateToString(Date date) {
		SimpleDateFormat formatDate = new SimpleDateFormat(WebConstants.FORMAT_COMPLETE_DATE);
		return formatDate.format(date);
	}
		
	public static NumberFormat getCurrency() {
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("es","ES"));
		return currencyFormatter;
	}  
	
	public static String getPercent(BigDecimal value) {
		NumberFormat percentFormatter = NumberFormat.getPercentInstance();		
		return percentFormatter.format(value.divide(new BigDecimal("100")));
	}  
	
	public static boolean isWithinRangeDates(LocalDateTime startDateTime, LocalDateTime endDateTime) {
		LocalDateTime today = LocalDateTime.now();
		Boolean containsToday = (!today.isBefore(startDateTime)) && (today.isBefore(endDateTime));
		return containsToday;
	}
	
	public static String passwordEncoder(String password) {
		BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
		return pass.encode(password);
	}

}