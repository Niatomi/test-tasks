package ru.niatomi.exceptions;

/**
 * @author niatomi
 */
public class DiscriminantBelowZeroException extends Exception{
    public DiscriminantBelowZeroException(Integer value) {
        super("Discriminant must be equal or higher than zero, but " + value);
    }
}
