package ru.niatomi.service.Impl;

import org.junit.jupiter.api.Test;
import ru.niatomi.exceptions.DiscriminantBelowZeroException;
import ru.niatomi.service.EquationService;
import ru.niatomi.equationserivce.Solve;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author niatomi
 */
class EquationServiceImplTest {

    private EquationService equationService = new EquationServiceImpl();

    @Test
    void solveEquationWithTwoSolvings() throws DiscriminantBelowZeroException {

        Solve expected = new Solve();
        expected.setD(4);
        expected.setX1(-3);
        expected.setX2(-9);

        Solve actual = equationService.solveEquation(3, 4, 1);
        assertEquals(expected.getD(), actual.getD());
        assertEquals(expected.getX1(), actual.getX1());
        assertEquals(expected.getX2(), actual.getX2());

    }

    @Test
    void solveEquationWithOneSolving() throws DiscriminantBelowZeroException {

        Solve expected = new Solve();
        expected.setD(0);
        expected.setX1(-8);

        assertThrows(DiscriminantBelowZeroException.class, () -> {
            Solve actual = equationService.solveEquation(3, 4, 9);
        });

    }

    @Test()
    void solveEquationWithException() throws DiscriminantBelowZeroException {

        Solve expected = new Solve();
        expected.setD(0);
        expected.setX1(-8);

        Solve actual = equationService.solveEquation(4, 4, 1);
        assertEquals(expected.getD(), actual.getD());
        assertEquals(expected.getX1(), actual.getX1());
        assertNull(actual.getX2());

    }

    @Test
    void equationConcaterOnlyPositives() {

        String expected = "1x^2+1x+1";
        String actual = equationService.equationConcater(1, 1, 1);
        assertEquals(expected, actual);

    }

    @Test
    void equationConcaterOnlyNegatives() {

        String expected = "-1x^2-1x-1";
        String actual = equationService.equationConcater(-1, -1, -1);
        assertEquals(expected, actual);

    }

}