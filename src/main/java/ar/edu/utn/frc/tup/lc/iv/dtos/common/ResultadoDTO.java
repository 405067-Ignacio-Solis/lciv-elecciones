package ar.edu.utn.frc.tup.lc.iv.dtos.common;

import lombok.Data;

@Data
public class ResultadoDTO {
    private int orden;
    private String nombre;
    private int votos;
    private float porcentaje;

}
