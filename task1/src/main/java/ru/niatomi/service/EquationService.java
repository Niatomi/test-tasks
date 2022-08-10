package ru.niatomi.service;

import ru.niatomi.equationserivce.GetEquationResponse;
import ru.niatomi.equationserivce.Solve;
import ru.niatomi.exceptions.DiscriminantBelowZeroException;

import java.util.Map;

/**
 * @author niatomi
 */
public interface EquationService {

    Map<String, Solve> solveEquation(double a, double b, double c) throws DiscriminantBelowZeroException;

}
