/**
 *
 */
package com.kb.openidconnect.authorize.validator;

/**
 * @author Kyle
 *
 */
public interface Validator<T> {

    public boolean isValid(T subject);
}
