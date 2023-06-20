package fr.esgi.front.dto.request;

import fr.esgi.front.beans.EnergyClassification;
import fr.esgi.front.beans.PropertyType;

public record RentalPropertyRequestDto(

        int id,
        String description,
        String town,
        String address,
        PropertyType propertyType,
        double rentAmount,
        double securityDepositAmount,
        double area,
        int bedroomsCount,
        int floorNumber,
        int numberOfFloors,
        int constructionYear,
        EnergyClassification energyClassification,
        boolean hasElevator,
        boolean hasIntercom,
        boolean hasBalcony,
        boolean hasParkingSpace) {

}
