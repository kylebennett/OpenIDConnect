/**
 *
 */
package com.kb.openidconnect.authorize.validator;

import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.kb.openidconnect.authorize.request.AuthorizeRequest;

/**
 * @author Kyle
 * @param <T>
 *
 */
@Component
public class AuthorizeRequestValidator<T extends AuthorizeRequest> implements Validator<T> {

	private static final Logger LOG = Logger.getLogger(AuthorizeRequestValidator.class);

	private static final String OPENID_SCOPE = "openid";

	@Override
	public boolean isValid(final T subject) {

		if (StringUtils.isEmpty(subject.getResponseType())) {
			LOG.debug("Validation Failed: Response type is empty");

			return false;
		}

		if (StringUtils.isEmpty(subject.getScope())) {
			LOG.debug("Validation Failed: Scope is empty");

			return false;
		}

		if (!subject.getScope().equals(OPENID_SCOPE)) {
			LOG.debug("Validation Failed: Scope is not " + OPENID_SCOPE);

			return false;
		}

		if (StringUtils.isEmpty(subject.getClientId())) {
			LOG.debug("Validation Failed: Client ID is empty");

			return false;
		}

		if (StringUtils.isEmpty(subject.getRedirectURI())) {
			LOG.debug("Validation Failed: Redirect URI is empty");

			return false;
		}

		return true;
	}
}
