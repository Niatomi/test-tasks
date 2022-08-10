package ru.niatomi.controller.Impl;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.niatomi.controller.CalcController;
import ru.niatomi.service.CalcService;
import ru.niatomi.calc.wsdl.GetEquationResponse;
import ru.niatomi.calc.wsdl.Solve;

/**
 * @author niatomi
 */
@RestController
@AllArgsConstructor
public class CalcControllerImpl implements CalcController {

    private final CalcService calcService;

    @Override
    public ResponseEntity<Solve> calcEquation(Double a, Double b, Double c) {
        return ResponseEntity.ok(calcService.solveEquation(a, b, c));
    }
}
