/**
 *
 */
package com.kb.validators;

/**
 * @author Kyle
 *
 */
public interface Validator<T> {

    public boolean isValid(T subject);
}
