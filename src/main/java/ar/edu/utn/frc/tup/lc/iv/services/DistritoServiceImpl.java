package ar.edu.utn.frc.tup.lc.iv.services;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.DistritoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class DistritoServiceImpl implements DistritoService{

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<DistritoDTO> getDistritos(Optional<String> nombre) {
        ResponseEntity<DistritoDTO[]> distritos;
        if (nombre.isPresent()) {
            String url = UriComponentsBuilder.fromUriString("http://localhost:8080/distritos").queryParam("distritoNombre", nombre.get()).toUriString();
            distritos = restTemplate.getForEntity(url,DistritoDTO[].class);
        }
        else {
            String url = UriComponentsBuilder.fromUriString("http://localhost:8080/distritos").toUriString();
            distritos = restTemplate.getForEntity(url,DistritoDTO[].class);
        }
        return Arrays.asList(distritos.getBody());
    }

    @Override
    public DistritoDTO getById(int id) {
        ResponseEntity<DistritoDTO[]> distritoResponse;
        String url = UriComponentsBuilder.fromUriString("http://localhost:8080/distritos").queryParam("distritoId",id).toUriString();
        distritoResponse = restTemplate.getForEntity(url,DistritoDTO[].class);

        DistritoDTO distrito = distritoResponse.getBody()[0];
        if (distrito != null) {
            return distrito;
        }
        else {
            throw new RuntimeException("Distrito no encontrado");
        }
    }
}
