package guru.springframework.msscbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbrewery.web.model.BeerDTO;
import org.json.JSONString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeer() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void handlePost() throws Exception {

        BeerDTO beerDTO = BeerDTO.builder().id(UUID.randomUUID()).beerName("Tuborg").beerStyle("cold").upc(123L).build();
        String beerDTOJson = objectMapper.writeValueAsString(beerDTO);
        mockMvc.perform(post("/api/v1/beer/create" )
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDTOJson))
                .andExpect(status().isCreated());


    }

    @Test
    void handleUpdate() throws Exception {
        BeerDTO beerDTO = BeerDTO.builder().id(UUID.randomUUID()).beerName("Foster").beerStyle("Root").build();
        String beerDTOJson = objectMapper.writeValueAsString(beerDTO);
        mockMvc.perform(put("/api/v1/beer/update/" + UUID.randomUUID().toString())
        .contentType(MediaType.APPLICATION_JSON)
        .content(beerDTOJson))
        .andExpect(status().isNoContent());
    }
}