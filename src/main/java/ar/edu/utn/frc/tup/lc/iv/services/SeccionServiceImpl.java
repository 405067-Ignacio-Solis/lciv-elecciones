package ar.edu.utn.frc.tup.lc.iv.services;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.SeccionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SeccionServiceImpl implements SeccionService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<SeccionDTO> getSeccionesByDistritoId(int distritoId, Optional<Integer> seccionIdOptional) {


        ResponseEntity<SeccionDTO[]> seccionResponse;

        String url;
        if (seccionIdOptional.isPresent()) {
            url = UriComponentsBuilder.fromUriString("http://localhost:8080/secciones")
                    .queryParam("distritoId", distritoId)
                    .queryParam("seccionId", seccionIdOptional.get())
                    .toUriString();
        }
        else {
            url = UriComponentsBuilder
                    .fromUriString("http://localhost:8080/secciones")
                    .queryParam("distritoId", distritoId).toUriString();
        }
        seccionResponse = restTemplate.getForEntity(url, SeccionDTO[].class);

        return Arrays.asList(seccionResponse.getBody());
    }
}
