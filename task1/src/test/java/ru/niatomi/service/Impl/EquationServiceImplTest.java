package ru.niatomi.service.Impl;

import org.junit.jupiter.api.Test;
import ru.niatomi.exceptions.DiscriminantBelowZeroException;
import ru.niatomi.service.EquationService;
import ru.niatomi.equationserivce.Solve;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author niatomi
 */
class EquationServiceImplTest {

    private EquationService equationService = new EquationServiceImpl();

    @Test
    void solveEquationWithTwoSolvings() throws DiscriminantBelowZeroException {

        Solve expected = new Solve();
        expected.setD(4.0);
        expected.setX1(-3.0);
        expected.setX2(-9.0);

        Map<String, Solve> solveMap = equationService.solveEquation(3, 4, 1);
        Solve actual = solveMap.values().stream().findFirst().get();
        assertEquals(expected.getD(), actual.getD());
        assertEquals(expected.getX1(), actual.getX1());
        assertEquals(expected.getX2(), actual.getX2());

        assertEquals("3.0x^2+4.0x+1.0", solveMap.keySet().stream().findFirst().get());

    }

    @Test
    void solveEquationWithOneSolving() throws DiscriminantBelowZeroException {

        Solve expected = new Solve();
        expected.setD(0);
        expected.setX1(-0.5);

        Map<String, Solve> solveMap = equationService.solveEquation(4, 4, 1);
        Solve actual = solveMap.values().stream().findFirst().get();

        assertEquals(expected.getD(), actual.getD());
        assertEquals(expected.getX1(), actual.getX1());
        assertNull(actual.getX2());

        assertEquals("4.0x^2+4.0x+1.0",solveMap.keySet().stream().findFirst().get());

    }

    @Test()
    void solveEquationWithException() throws DiscriminantBelowZeroException {

    assertThrows(DiscriminantBelowZeroException.class, () -> {
        Map<String, Solve> solveMap = equationService.solveEquation(3, 4, 9);
    });



    }

}