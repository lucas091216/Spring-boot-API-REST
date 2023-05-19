package com.api.parkingcontroll.repositories;

import com.api.parkingcontroll.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

    boolean existsByLicensePlateCarro(String licensePlateCarro);
    boolean existsByParkingSpotNumero(String parkingSpotNumero);
    boolean existsByApartamentoAndBlock(String apartamento, String block);


}
