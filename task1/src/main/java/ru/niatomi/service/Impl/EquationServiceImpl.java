package ru.niatomi.service.Impl;


import org.decimal4j.util.DoubleRounder;
import org.springframework.stereotype.Service;
import ru.niatomi.equationserivce.Solve;
import ru.niatomi.exceptions.DiscriminantBelowZeroException;
import ru.niatomi.service.EquationService;
import ru.niatomi.equationserivce.GetEquationResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author niatomi
 */
@Service
public class EquationServiceImpl implements EquationService {

    @Override
    public Map<String, Solve> solveEquation(double a, double b, double c) throws DiscriminantBelowZeroException {

        String equation = equationConcater(a, b, c);
        Double D = (Math.pow(b, 2) - 4*a*c);

        if (D < 0)
            throw new DiscriminantBelowZeroException(D, equation);

        Solve solve = new Solve();
        solve.setD(D);

        if (D == 0) {
            solve.setX1(DoubleRounder.round(-b/(2*a), 2));
        }

        if (D > 0) {
            solve.setX1(DoubleRounder.round(((-1)*b+Math.sqrt(D))/2*a,2));
            solve.setX2(DoubleRounder.round(((-1)*b-Math.sqrt(D))/2*a,2));
        }

        Map<String, Solve> solveMap = new HashMap<>();
        solveMap.put(equation, solve);

        return solveMap;
    }

    private static String equationConcater(double a, double b, double c) {
        String equation = a + "x^2";

        if (b > 0) {
            equation += "+" + b + "x";
        } else {
            equation += b + "x";
        }

        if (c > 0) {
            equation += "+" + c + "";
        } else {
            equation += c + "";
        }
        return equation;
    }
}
