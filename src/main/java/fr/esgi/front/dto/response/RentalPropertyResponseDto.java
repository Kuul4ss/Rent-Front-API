package fr.esgi.front.dto.response;

import fr.esgi.front.beans.PropertyType;

public record RentalPropertyResponseDto(String description,
                                        String address,
                                        String town,
                                        PropertyType propertyType,
                                        double rentAmount,
                                        double securityDepositAmount,
                                        double area) {
}
