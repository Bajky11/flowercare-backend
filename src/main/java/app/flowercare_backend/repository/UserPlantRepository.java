package app.flowercare_backend.repository;

import app.flowercare_backend.entities.UserPlant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserPlantRepository extends JpaRepository<UserPlant, Long> {

    @Query(value = "SELECT * FROM UserPlant up WHERE up.user_id = :userId", nativeQuery = true)
    List<UserPlant> findAllByUserId(Long userId);


    @Query("DELETE FROM UserPlant up WHERE up.id = :id AND up.user.id = :userId")
    void deleteByUserIdAndId(Long userId, Long id);
}
