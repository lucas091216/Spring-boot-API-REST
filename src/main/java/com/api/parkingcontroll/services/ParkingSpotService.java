package com.api.parkingcontroll.services;

import com.api.parkingcontroll.models.ParkingSpotModel;
import com.api.parkingcontroll.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

    final
    ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    public ParkingSpotModel save (ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }


    public boolean existsByLicensePlateCarro(String licensePlateCarro) {
        return parkingSpotRepository.existsByLicensePlateCarro(licensePlateCarro);
    }
    public boolean existsByParkingSpotNumero(String parkingSpotNumero) {
        return parkingSpotRepository.existsByParkingSpotNumero(parkingSpotNumero);
    }
    public boolean existsByApartamentoAndBloc(String apartamento, String block) {
        return parkingSpotRepository.existsByApartamentoAndBlock(apartamento, block);
    }

    public List<ParkingSpotModel> findAll() {
        return parkingSpotRepository.findAll();
    }

    public Optional<ParkingSpotModel> findById(UUID id) {
        return parkingSpotRepository.findById(id);
    }
}
