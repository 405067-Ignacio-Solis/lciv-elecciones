package ar.edu.utn.frc.tup.lc.iv.services;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.CargoDTO;

import java.util.List;

public interface CargoService {
    public List<CargoDTO> getCargosByDistritoId(int distritoId);
}
