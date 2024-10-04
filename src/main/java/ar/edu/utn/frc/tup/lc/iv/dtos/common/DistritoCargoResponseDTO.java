package ar.edu.utn.frc.tup.lc.iv.dtos.common;

import lombok.Data;

import java.util.List;
@Data
public class DistritoCargoResponseDTO {
    DistritoDTO distrito;
    List<CargoDTO> cargos;
}
