package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

//esse crossorigin faz com que seja permitido ser acessado de qualquer fonte
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
//esse request mapping ta fazendo esse controller ser acessado a nvl de class
//poderia ser feito a nivel de método tmb
@RequestMapping("/parking-spot")
public class ParkingSpotController {
    //criando ponto de injecao do service aqui dentro do controller
    final ParkingSpotService parkingSpotService;

    //gerando contrustor:
    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    //criando o metodo post
    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto) {
        var parkingSpotModel = new ParkingSpotModel();

        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }

}
