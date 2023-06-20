package fr.esgi.front.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esgi.front.beans.RentalProperty;
import fr.esgi.front.dto.response.RentalPropertyResponseDto;
import fr.esgi.front.mapper.RentalPropertyDtoMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Path("/rental-properties")
public class RentalPropertyResource {
    private final RentalPropertyDtoMapper rentalPropertyDtoMapper;
    private final HttpClient httpClient;

    private final String url;
    private final ObjectMapper objectMapper = new ObjectMapper();




    @Inject
    public RentalPropertyResource(RentalPropertyDtoMapper rentalPropertyDtoMapper, HttpClient httpClient, String url) {
        this.rentalPropertyDtoMapper = rentalPropertyDtoMapper;
        this.httpClient = httpClient;
        this.url = url;
    }

    @GET
    @Path("/rental-properties")
    public List<RentalPropertyResponseDto> getRentalProperties() {
        List<RentalProperty> rentalProperties = null;
        String url = this.url + "/rental-properties";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String responseBody = response.body();
                rentalProperties = objectMapper.readValue(responseBody, new TypeReference<List<RentalProperty>>() {});
            }
        } catch (IOException | InterruptedException e) {
            // Handle the exception
        }

        return rentalPropertyDtoMapper.mapToDtoList(rentalProperties);
    }
}