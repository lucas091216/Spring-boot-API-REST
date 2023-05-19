package com.api.parkingcontroll.controlers;

import com.api.parkingcontroll.dtos.ParkingSpotDTO;
import com.api.parkingcontroll.models.ParkingSpotModel;
import com.api.parkingcontroll.services.ParkingSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotControler {

    final
    ParkingSpotService parkingSpotService;

    public ParkingSpotControler(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO){
        if(parkingSpotService.existsByLicensePlateCarro(parkingSpotDTO.getLicensePlateCarro())){
           return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Carro is already in use!");
        }
        if(parkingSpotService.existsByParkingSpotNumero(parkingSpotDTO.getParkingSpotNumero())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot Numero is already in use!");
        }
        if(parkingSpotService.existsByApartamentoAndBloc(parkingSpotDTO.getApartamento(), parkingSpotDTO.getBlock())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registred for this apartment/block!");
        }
    var parkingSpotModel = new ParkingSpotModel();

        BeanUtils.copyProperties(parkingSpotDTO, parkingSpotModel);

        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
    return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpots(){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
    }

    //Da o get pelo ID, como se fosse um select
    @GetMapping("/{id}")
    public  ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id")UUID id){
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if(parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found ");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
        }
    }



    }

