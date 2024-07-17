package com.series.fibonacci.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ResponseSerieDTO {

    private Long id;
    private String hora;
    private List<Integer> serie;

}
