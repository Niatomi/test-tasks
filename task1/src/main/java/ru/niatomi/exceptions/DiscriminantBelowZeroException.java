package ru.niatomi.exceptions;

/**
 * @author niatomi
 */
public class DiscriminantBelowZeroException extends Exception{

    public DiscriminantBelowZeroException() {
        super("Discriminant below zero");
    }
}
