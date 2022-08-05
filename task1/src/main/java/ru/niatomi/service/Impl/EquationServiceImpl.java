package ru.niatomi.service.Impl;


import org.springframework.stereotype.Service;
import ru.niatomi.equationserivce.Solve;
import ru.niatomi.exceptions.DiscriminantBelowZeroException;
import ru.niatomi.service.EquationService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author niatomi
 */
@Service
public class EquationServiceImpl implements EquationService {

    @Override
    public Solve solveEquation(int a, int b, int c) throws DiscriminantBelowZeroException {

        int D = (int) (Math.pow(b, 2) - 4*a*c);
        if (D < 0) throw new DiscriminantBelowZeroException();

        Solve solve = new Solve();
        solve.setD(D);
        solve.setX1((int) (((-1)*b+Math.sqrt(D))/2*a));
        if (D != 0)
            solve.setX2((int) (((-1)*b-Math.sqrt(D))/2*a));

        return solve;
    }

    @Override
    public String equationConcater(int a, int b, int c) {
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
