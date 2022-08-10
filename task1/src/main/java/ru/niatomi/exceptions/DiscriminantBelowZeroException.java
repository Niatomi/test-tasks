package ru.niatomi.exceptions;

import lombok.Getter;

/**
 * @author niatomi
 */
@Getter
public class DiscriminantBelowZeroException extends Exception{

    private Double D;
    private String formula;

    public DiscriminantBelowZeroException(Double d, String formula) {
        super("Discriminant must be equal or higher than zero, but " + d);
        this.D = d;
        this.formula = formula;
    }
}
