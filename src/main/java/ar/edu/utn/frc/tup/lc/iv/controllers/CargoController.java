package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.CargoDTO;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.DistritoCargoResponseDTO;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.DistritoDTO;
import ar.edu.utn.frc.tup.lc.iv.services.CargoService;
import ar.edu.utn.frc.tup.lc.iv.services.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CargoController {

    @Autowired
    DistritoService distritoService;
    @Autowired
    CargoService cargoService;

    @GetMapping("cargos")
    public DistritoCargoResponseDTO getCargosDisponibles(@RequestParam(name="distrito_id") int distrito_id) {
        DistritoDTO distrito = distritoService.getById(distrito_id);
        List<CargoDTO> cargos = cargoService.getCargosByDistritoId(distrito_id);
        //build the object
        DistritoCargoResponseDTO dto = new DistritoCargoResponseDTO();
        dto.setCargos(cargos);
        dto.setDistrito(distrito);
        return dto;
    }
}
