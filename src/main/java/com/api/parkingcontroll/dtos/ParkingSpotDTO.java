package com.api.parkingcontroll.dtos;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotDTO {
    @NotBlank
    private String parkingSpotNumero;

    @NotBlank
    @Size(max = 7)
    private String licensePlateCarro;

    @NotBlank
    private String brandCarro;

    @NotBlank
    private String modelCarro;

    @NotBlank
    private String colorCarro;

    @NotBlank
    private String responsibleNome;

    @NotBlank
    private String apartamento;

    @NotBlank
    private String block;

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
