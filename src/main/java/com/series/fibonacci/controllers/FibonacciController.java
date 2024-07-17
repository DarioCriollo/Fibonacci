package com.series.fibonacci.controllers;

import com.series.fibonacci.constants.ResourceEndpoint;
import com.series.fibonacci.dto.FibonacciDTO;
import com.series.fibonacci.dto.ResponseSerieDTO;
import com.series.fibonacci.services.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ResourceEndpoint.ENTERPRISE)
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;

    @CrossOrigin(origins = "*")
    @PostMapping(value=ResourceEndpoint.GET_SERIE)
    public ResponseEntity<ResponseSerieDTO> saveSerie(@RequestBody FibonacciDTO fibonacciDTO){
        ResponseSerieDTO response = fibonacciService.saveSerie(fibonacciDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
