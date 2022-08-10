package ru.niatomi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.calc.wsdl.GetEquationResponse;
import ru.niatomi.calc.wsdl.Solve;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/calc")
public interface CalcController {

    @GetMapping("/")
    ResponseEntity<Solve> calcEquation(
            @RequestParam Double a,
            @RequestParam Double b,
            @RequestParam Double c
    );

}
