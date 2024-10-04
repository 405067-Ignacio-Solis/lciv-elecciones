package ar.edu.utn.frc.tup.lc.iv.services;

import ar.edu.utn.frc.tup.lc.iv.configs.RestTemplateConfig;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.DistritoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


public interface DistritoService {

    List<DistritoDTO> getDistritos(Optional<String> nombre);

    DistritoDTO getById(int id);


}
