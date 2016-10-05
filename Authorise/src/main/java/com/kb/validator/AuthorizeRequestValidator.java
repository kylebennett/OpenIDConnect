/**
 *
 */
package com.kb.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.kb.request.AuthorizeRequest;

/**
 * @author Kyle
 * @param <T>
 *
 */
@Component
public class AuthorizeRequestValidator<T extends AuthorizeRequest> implements Validator<T> {

	@Override
	public boolean isValid(final T subject) {

		if (StringUtils.isEmpty(subject.getResponseType())) {
			return false;
		}

		if (StringUtils.isEmpty(subject.getScope())) {
			return false;
		}

		if (StringUtils.isEmpty(subject.getClientId())) {
			return false;
		}

		if (StringUtils.isEmpty(subject.getRedirectURI())) {
			return false;
		}

		return true;
	}
}
