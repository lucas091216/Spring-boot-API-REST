package com.api.parkingcontroll.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumero;

    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCarro;

    @Column(nullable = false, length = 70)
    private String brandCarro;

    @Column(nullable = false, length = 70)
    private String modelCarro;

    @Column(nullable = false, length = 70)
    private String colorCarro;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false, length = 130)
    private String responsibleNome;

    @Column(nullable = false, length = 30)
    private String apartamento;

    @Column(nullable = false, length =30 )
    private String block;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getParkingSpotNumero() {
        return parkingSpotNumero;
    }

    public void setParkingSpotNumero(String parkingSpotNumero) {
        this.parkingSpotNumero = parkingSpotNumero;
    }

    public String getLicensePlateCarro() {
        return licensePlateCarro;
    }

    public void setLicensePlateCarro(String licensePlateCarro) {
        this.licensePlateCarro = licensePlateCarro;
    }

    public String getBrandCarro() {
        return brandCarro;
    }

    public void setBrandCarro(String brandCarro) {
        this.brandCarro = brandCarro;
    }

    public String getModelCarro() {
        return modelCarro;
    }

    public void setModelCarro(String modelCarro) {
        this.modelCarro = modelCarro;
    }

    public String getColorCarro() {
        return colorCarro;
    }

    public void setColorCarro(String colorCarro) {
        this.colorCarro = colorCarro;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getResponsibleNome() {
        return responsibleNome;
    }

    public void setResponsibleNome(String responsibleNome) {
        this.responsibleNome = responsibleNome;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
