package fr.esgi.front.mapper;
import fr.esgi.front.dto.request.RentalPropertyRequestDto;
import fr.esgi.front.dto.response.RentalPropertyResponseDto;
import fr.esgi.front.beans.RentalProperty;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;


@ApplicationScoped
public class RentalPropertyDtoMapper {


    public RentalPropertyDtoMapper() {

    }

    public List<RentalPropertyResponseDto> mapToDtoList(List<RentalProperty> rentalProperties) {
        return rentalProperties.stream()
                .map(this::mapToDto)
                .toList();
    }

    public RentalPropertyResponseDto mapToDto(RentalProperty rentalProperty) {
        return new RentalPropertyResponseDto(
                rentalProperty.description(),
                rentalProperty.address(),
                rentalProperty.town(),
                rentalProperty.propertyType(),
                rentalProperty.rentAmount(),
                rentalProperty.securityDepositAmount(),
                rentalProperty.area());
    }

    public RentalProperty mapToBean(RentalPropertyRequestDto rentalPropertyRequestDto) {
        return new RentalProperty(
                rentalPropertyRequestDto.id(),
                rentalPropertyRequestDto.description(),
                rentalPropertyRequestDto.town(),
                rentalPropertyRequestDto.address(),
                rentalPropertyRequestDto.propertyType(),
                rentalPropertyRequestDto.rentAmount(),
                rentalPropertyRequestDto.securityDepositAmount(),
                rentalPropertyRequestDto.area(),
                rentalPropertyRequestDto.bedroomsCount(),
                rentalPropertyRequestDto.floorNumber(),
                rentalPropertyRequestDto.numberOfFloors(),
                rentalPropertyRequestDto.constructionYear(),
                rentalPropertyRequestDto.energyClassification(),
                rentalPropertyRequestDto.hasElevator(),
                rentalPropertyRequestDto.hasIntercom(),
                rentalPropertyRequestDto.hasBalcony(),
                rentalPropertyRequestDto.hasParkingSpace());
    }


}
