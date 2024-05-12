package app.flowercare_backend.controllers;

import app.flowercare_backend.entities.AppUser;
import app.flowercare_backend.entities.Plant;
import app.flowercare_backend.services.PlantService;
import app.flowercare_backend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PlantController {
    private PlantService plantService;
    public static final String API_PLANT_PATH = "/flowercare/v1/plants";

    @GetMapping(value = API_PLANT_PATH + "/{id}")
    public ResponseEntity<?> getByID(@PathVariable Long id) {
        Optional<Plant> plant = plantService.getById(id);
        if(!plant.isPresent()){
            return ResponseEntity.badRequest().body("Plant with specified ID not found");
        }
        return ResponseEntity.ok(plant);
    }

    @GetMapping(value = API_PLANT_PATH)
    public List<Plant> getAll() {
        List<Plant> plants = plantService.getAll();
        return Optional.of(plants).orElseThrow(null);
    }

    @PostMapping(value = API_PLANT_PATH)
    public ResponseEntity<String> add(@RequestBody Plant plant) {
        if (plant == null) {
            return ResponseEntity.badRequest().body("Invalid plant object");
        }

        plantService.save(plant);
        return ResponseEntity.ok().body("Plant saved");
    }

    //localhost:9000/flowercare/v1/plants/pagable?page=0&size=7&sort=name,asc
    @GetMapping(value = API_PLANT_PATH + "/pagable")
    public ResponseEntity<?> getAll(Pageable pageable) {
        Page<Plant> plants = plantService.getAllPagable(pageable);
        return ResponseEntity.ok(plants);
    }

    //localhost:9000/flowercare/v1/plants/search?name=b
    @GetMapping(value = API_PLANT_PATH + "/search")
    public ResponseEntity<List<Plant>> getByNameContaining(@RequestParam String name) {
        List<Plant> plants = plantService.findByNameContaining(name);
        if(plants.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(plants);
    }
}
