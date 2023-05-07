package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//extends o jpa e passando o model dele e o id
@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {


    boolean existsByLicensePlateCar(String licensePlateCar);
    boolean existsByParkingSpotNumber(String parkingNumber);
    boolean existsByApartmentAndBlock(String apartment, String block);
}
