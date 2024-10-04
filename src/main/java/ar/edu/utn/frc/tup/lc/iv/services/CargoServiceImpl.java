package ar.edu.utn.frc.tup.lc.iv.services;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.CargoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<CargoDTO> getCargosByDistritoId(int distritoId) {

        ResponseEntity<CargoDTO[]> cargosResponse;
        String url = UriComponentsBuilder.fromUriString("http://localhost:8080/cargos").queryParam("distritoId", distritoId).toUriString();
        cargosResponse = restTemplate.getForEntity(url, CargoDTO[].class);
        return Arrays.asList(cargosResponse.getBody());
    }
}
