/**
 * 
 */
package com.kb.openidconnect.authorize.utils;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

/**
 * @author kylebennett
 *
 */
@Component
public class Clock {

	public DateTime getCurrentTime() {
		return new DateTime();
	}
}
