package ru.niatomi.controller;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.calc.wsdl.GetEquationResponse;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/calc")
public interface CalcController {

    @GetMapping
    ResponseEntity<String> calcEquation(
            @RequestParam Integer a,
            @RequestParam Integer b,
            @RequestParam Integer c
    );

}
