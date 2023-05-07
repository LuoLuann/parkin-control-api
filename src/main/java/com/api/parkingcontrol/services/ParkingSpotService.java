package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//essa eh a camada entre os controllers e os repositories
//aqui criamos uma camada de injeção de dados para o repository
//ou seja, o controller chama o service e o service chama o repository
@Service
public class ParkingSpotService {

    //criando o ponto de injeção
    @Autowired
    ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }
    //aqui eu falo pro spring que em determinados momentos ele
    //tera que injetar dados do repository aqui nessa class
}
