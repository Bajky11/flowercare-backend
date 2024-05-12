package app.flowercare_backend.repository;

import app.flowercare_backend.entities.Plant;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {

    Page<Plant> findByNameContaining(String name, Pageable pageable);
}
