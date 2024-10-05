package ar.edu.utn.frc.tup.lc.iv.services;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.SeccionDTO;

import java.util.List;
import java.util.Optional;

public interface SeccionService {
    public List<SeccionDTO> getSeccionesByDistritoId(int distritoId, Optional<Integer> seccionIdOptional);
}
