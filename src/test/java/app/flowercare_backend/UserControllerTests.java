package app.flowercare_backend;


import app.flowercare_backend.controllers.UserController;
import app.flowercare_backend.entities.AppUser;
import app.flowercare_backend.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private AppUser validUser;
    private AppUser invalidUser;

    @BeforeEach
    public void setup(){
        validUser = new AppUser();
        validUser.setUsername("testUser");
        validUser.setPassword("password123");
        MockitoAnnotations.openMocks(this);
        mockMvc = standaloneSetup(userController).build();
    }

    @Test
    void whenRegisterWithInvalidUserData_thenBadRequest() {
        ResponseEntity<?> response = userController.register(invalidUser);
        assertEquals(BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid user data", response.getBody());
    }

    @Test
    void whenRegisterExistingUser_thenBadRequest() {
        when(userService.findByUsername("testUser")).thenReturn(Optional.of(validUser));

        ResponseEntity<?> response = userController.register(validUser);
        assertEquals(BAD_REQUEST, response.getStatusCode());
        assertEquals("User already exists", response.getBody());
    }

    @Test
    void whenRegisterValidUser_thenUserRegisteredSuccessfully() {
        when(userService.findByUsername("testUser")).thenReturn(Optional.empty());

        ResponseEntity<?> response = userController.register(validUser);
        assertEquals(OK, response.getStatusCode());
        assertEquals("User registered successfully", response.getBody());
    }

    @Test
    void whenLoginWithInvalidUserData_thenBadRequest() {
        ResponseEntity<?> response = userController.login(invalidUser);
        assertEquals(BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid user data", response.getBody());
    }

    @Test
    void whenLoginWithInvalidCredentials_thenUnauthorized() {
        when(userService.findByUsernameAndPassword("testUser", "password123")).thenReturn(Optional.empty());

        ResponseEntity<?> response = userController.login(validUser);
        assertEquals(UNAUTHORIZED, response.getStatusCode());
        assertEquals("Invalid credentials", response.getBody());
    }

    @Test
    void whenLoginWithValidCredentials_thenSuccess() {
        when(userService.findByUsernameAndPassword("testUser", "password123")).thenReturn(Optional.of(validUser));

        ResponseEntity<?> response = userController.login(validUser);
        assertEquals(OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof AppUser);
    }
}
