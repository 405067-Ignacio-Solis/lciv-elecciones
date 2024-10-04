package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.DistritoDTO;
import ar.edu.utn.frc.tup.lc.iv.services.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/distritos")
    public List<DistritoDTO> getDistritos(@RequestParam(name="nombre", required=false) String nombre) {
        if (nombre != null) {
            return distritoService.getDistritos(Optional.of(nombre));
        }
        else {
            return distritoService.getDistritos(Optional.empty());
        }

    }

}
