package ru.niatomi.service;

import ru.niatomi.equationserivce.GetEquationRequest;
import ru.niatomi.equationserivce.Solve;
import ru.niatomi.exceptions.DiscriminantBelowZeroException;

import java.util.Map;

/**
 * @author niatomi
 */
public interface EquationService {

    Solve solveEquation(int a, int b, int c) throws DiscriminantBelowZeroException;

    String equationConcater(int a, int b, int c);
}
