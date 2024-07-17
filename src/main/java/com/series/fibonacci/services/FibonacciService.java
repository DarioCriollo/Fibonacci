package com.series.fibonacci.services;

import com.series.fibonacci.dto.FibonacciDTO;
import com.series.fibonacci.dto.ResponseSerieDTO;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FibonacciService {

    public ResponseSerieDTO saveSerie(FibonacciDTO fibonacciDTO){

        LocalTime localTime = LocalTime.parse(fibonacciDTO.getTime());
        int minutes = localTime.getMinute();
        int seconds = localTime.getSecond();


        String numeroStr = String.valueOf(minutes);

        char digito1 = numeroStr.charAt(0);
        char digito2 = numeroStr.charAt(1);

        List<Integer> serie = generateFibonacciSeries(digito1,digito2,seconds);

        ResponseSerieDTO responseSerieDTO = ResponseSerieDTO.builder()
                .id(1L)
                .hora(fibonacciDTO.getTime())
                .serie(serie)
                .build();

        return responseSerieDTO;
    }

    private List<Integer> generateFibonacciSeries(char digito1, char digito2,int count) {
        List<Integer> fibonacciSeries = new ArrayList<>();

        int dato1 =Character.getNumericValue(digito1);
        int dato2 =Character.getNumericValue(digito2);

        fibonacciSeries.add(dato1);
        fibonacciSeries.add(dato2);
        for (int i = 1; i < count; i++) {
            int siguienteFibonacci = dato1 + dato2;
            fibonacciSeries.add(siguienteFibonacci);

            dato1 = dato2;
            dato2 = siguienteFibonacci;
        }

        return fibonacciSeries;
    }
}
