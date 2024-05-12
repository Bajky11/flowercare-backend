package app.flowercare_backend.repository;

import app.flowercare_backend.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser,Long> {

    @Query(value = "SELECT * FROM app_user au WHERE au.username = :username", nativeQuery = true)
    Optional<AppUser> findByUsername(String username);

    @Query(value = "SELECT * FROM app_user au WHERE au.username = :username AND au.password = :password", nativeQuery = true)
    Optional<AppUser> findByUsernameAndPassword(String username, String password);
}
