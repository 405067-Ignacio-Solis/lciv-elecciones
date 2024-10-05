package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.SeccionDTO;
import ar.edu.utn.frc.tup.lc.iv.services.SeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SeccionController {

    @Autowired
    SeccionService seccionService;

    @GetMapping("/secciones")
    public List<SeccionDTO> getSeccionesByDistritoId(@RequestParam int distritoId,
                                                     @RequestParam(required = false, name="seccionId") Integer seccionId) {
        if (seccionId != null) {
            return seccionService.getSeccionesByDistritoId(distritoId, Optional.of(seccionId));
        }
        else return seccionService.getSeccionesByDistritoId(distritoId, Optional.empty());
    }
}
