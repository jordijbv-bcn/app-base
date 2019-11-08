package com.base.app.application.web.utils;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.text.StringEscapeUtils;

public class AppResources {

	private static String VALIDATIONS = "i18n/messages";

	/**
	 * Get the validation resources by locale.
	 * 
	 * @param locale
	 * @return the validation resources.
	 */
	
	public static ResourceBundle getApplicationResources(Locale locale) {
		ResourceBundle applicationResources;
		if (locale == null) {
			applicationResources = ResourceBundle.getBundle(VALIDATIONS);
		} else {
			applicationResources = ResourceBundle.getBundle(VALIDATIONS, locale);
		}
		return applicationResources;
	}

	/**
	 * Get a specific validation message.
	 * 
	 * @param key
	 * @param locale
	 * @return the validation message.
	 */
	
	public static String getResource(String key, Locale locale) {
		try {
			String text = getApplicationResources(locale).getString(key);
			return StringEscapeUtils.unescapeHtml4(text);
		} catch (java.util.MissingResourceException e) {
			return key;
		}
	}
 
}