package app.flowercare_backend;

import app.flowercare_backend.controllers.PlantController;
import app.flowercare_backend.entities.Plant;
import app.flowercare_backend.repository.PlantRepository;
import app.flowercare_backend.repository.UserRepository;
import app.flowercare_backend.services.PlantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@WebMvcTest(PlantController.class)
public class PlantControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlantService plantService;

    @InjectMocks
    private PlantController plantController;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        // Tímto obcházím uživatelskou autorizaci a zrychluji celkově testym jelikož se nemusí načítat celý kontext aplikace
        mockMvc = standaloneSetup(plantController).build();
    }

    @Test
    public void testGetByInvalidID() throws Exception {
        // Plant service  při jakémkoli parametru typu Long vrací Optional.empty
        when(plantService.getById(anyLong())).thenReturn(Optional.empty());

        // Test jak se zachová controller když service vrátí Optional.empty
        // je jedno jake id je v url, vždy se vrátí Optional.empty
        // controller je implementovaný tak, že vrací ResponseEntity.badRequest().body("Plant with specified ID not found");
        // otestujeme že se vrátilo právě to, co jsme očekávali
        mockMvc.perform(get(PlantController.API_PLANT_PATH + "/123"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Plant with specified ID not found"));
    }

    @Test
    public void testGetByValidID() throws Exception {
        Plant plant = new Plant();
        when(plantService.getById(anyLong())).thenReturn(Optional.of(plant));

        mockMvc.perform(get(PlantController.API_PLANT_PATH + "/123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }


}
