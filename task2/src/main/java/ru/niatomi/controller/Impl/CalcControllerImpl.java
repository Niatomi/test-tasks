package ru.niatomi.controller.Impl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.niatomi.controller.CalcController;
import ru.niatomi.service.CalcService;

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
