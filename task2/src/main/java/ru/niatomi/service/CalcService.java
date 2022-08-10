package ru.niatomi.service;

import ru.niatomi.calc.wsdl.GetEquationResponse;
import ru.niatomi.calc.wsdl.Solve;

/**
 * @author niatomi
 */
public interface CalcService {

    Solve solveEquation(Double a, Double b, Double c);

}
