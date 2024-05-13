package app.flowercare_backend;

import app.flowercare_backend.controllers.PlantController;
import app.flowercare_backend.controllers.UserPlantController;
import app.flowercare_backend.entities.AppUser;
import app.flowercare_backend.entities.UserPlant;
import app.flowercare_backend.services.PlantService;
import app.flowercare_backend.services.UserPlantService;
import app.flowercare_backend.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@WebMvcTest(UserPlantController.class)
public class UserPlantControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserPlantService userPlantService;

    @MockBean
    private UserService userService;

    @MockBean
    private PlantService plantService;

    @Test
    public void testWateringWithInvalidUser() throws Exception {
        when(userPlantService.findById(anyLong())).thenReturn(Optional.empty());

        mockMvc.perform(post(UserPlantController.API_USERPLANT_PATH + "/water/123")
                        .with(user("admin").password("admin").roles("ADMIN")))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("UserPlant with specified Id not found"));
    }

    @Test
    public void testWateringWithValidUser() throws Exception {
        UserPlant userPlant = new UserPlant();
        when(userPlantService.findById(anyLong())).thenReturn(Optional.of(userPlant));

        mockMvc.perform(post(UserPlantController.API_USERPLANT_PATH + "/water/123")
                        .with(user("user").password("password").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(content().string("Watering successful"));
    }

}
