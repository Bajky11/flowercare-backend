package app.flowercare_backend.controllers;

import app.flowercare_backend.entities.AppUser;
import app.flowercare_backend.entities.Plant;
import app.flowercare_backend.entities.UserPlant;
import app.flowercare_backend.requests.UserPlantRequest;
import app.flowercare_backend.services.PlantService;
import app.flowercare_backend.services.UserPlantService;
import app.flowercare_backend.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserPlantController {

    private final UserPlantService userPlantService;
    private final UserService userService;
    private final PlantService plantService;

    public static final String API_USERPLANT_PATH = "/flowercare/v1/userplants";

    @Autowired
    public UserPlantController(UserPlantService userPlantService,UserService userService,PlantService plantService) {
        this.userPlantService = userPlantService;
        this.userService = userService;
        this.plantService = plantService;
    }

    // Get all plants for a specific user
    @GetMapping(API_USERPLANT_PATH + "/{userId}")
    public ResponseEntity<List<UserPlant>> getAllPlantsForUser(@PathVariable Long userId) {
        List<UserPlant> userPlants = userPlantService.findAllByUserId(userId);
        return ResponseEntity.ok(userPlants);
    }

    @PostMapping(API_USERPLANT_PATH +"/add")
    public ResponseEntity<?> addPlantToUser(@RequestBody UserPlantRequest request) {
        Optional<AppUser> user = userService.getById(request.getUserId());
        if(!user.isPresent()){
            return ResponseEntity.badRequest().body("User with specified ID not found");
        }
        Optional<Plant> plant = plantService.getById(request.getPlantId());
        if(!plant.isPresent()){
            return ResponseEntity.badRequest().body("Plant with specified ID not found");
        }
        UserPlant newUserPlant = new UserPlant(user.get(), plant.get());
        userPlantService.save(newUserPlant);
        return ResponseEntity.ok(newUserPlant);
    }

    @Transactional
    @PostMapping(API_USERPLANT_PATH +"/water/{userPlantId}")
    public ResponseEntity<?> waterUserPlant(@PathVariable Long userPlantId) {
        Optional<UserPlant> userPlant = userPlantService.findById(userPlantId);

        if(!userPlant.isPresent()){
            return ResponseEntity.badRequest().body("UserPlant with specified Id not found");
        }
        userPlant.get().resetWateringDate();
        return ResponseEntity.ok().body("Watering successful");
    }

    @Transactional
    @PostMapping(API_USERPLANT_PATH + "/fertilize/{userPlantId}")
    public ResponseEntity<?> fertilizeUserPlant(@PathVariable Long userPlantId) {
        Optional<UserPlant> userPlant = userPlantService.findById(userPlantId);

        if(!userPlant.isPresent()){
            return ResponseEntity.badRequest().body("UserPlant with specified Id not found");
        }
        userPlant.get().resetFertilizingDate();
        return ResponseEntity.ok().body("Fertilizing successful");
    }
}
