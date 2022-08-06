package ru.niatomi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/calc")
public interface CalcController {

    @GetMapping("/")
    ResponseEntity<String> calcEquation(
            @RequestParam Integer a,
            @RequestParam Integer b,
            @RequestParam Integer c
    );

}
