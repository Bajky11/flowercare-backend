package app.flowercare_backend.repository;

import app.flowercare_backend.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {

    //@Query(value = "SELECT * FROM plant WHERE name LIKE %name%", nativeQuery = true)
    List<Plant> findByNameContaining(String name);
}
