package ru.niatomi.controller.Impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import ru.niatomi.controller.CalcController;
import ru.niatomi.service.CalcService;
import ru.niatomi.calc.wsdl.GetEquationResponse;

/**
 * @author niatomi
 */
@RestController
@AllArgsConstructor
public class CalcControllerImpl implements CalcController {

    private final CalcService calcService;

    @Override
    public ResponseEntity<String> calcEquation(Integer a, Integer b, Integer c) {
        return ResponseEntity.ok(calcService.solveEquation(a, b, c).toString());
    }
}
