package app.flowercare_backend.services;

import app.flowercare_backend.entities.AppUser;
import app.flowercare_backend.entities.Plant;
import app.flowercare_backend.repository.PlantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PlantService {

    private final PlantRepository plantRepository;

    public Plant save(Plant plant) {
        return plantRepository.save(plant);
    }

    public Optional<Plant> getById(Long id) {
        return Optional.of(plantRepository.getReferenceById(id));
    }

    public List<Plant> getAll() {
        return plantRepository.findAll();
    }

    public Page<Plant> getAllPagable(Pageable pageable) {
        return plantRepository.findAll(pageable);
    }

    public Page<Plant> findByNameContainingPagable(String name, Pageable pageable) {
        return plantRepository.findByNameContaining(name, pageable);
    }
}
