/**
 *
 */
package com.kb.validator;

/**
 * @author Kyle
 *
 */
public interface Validator<T> {

    public boolean isValid(T subject);
}
