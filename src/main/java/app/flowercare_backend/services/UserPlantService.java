package app.flowercare_backend.services;

import app.flowercare_backend.entities.UserPlant;
import app.flowercare_backend.repository.UserPlantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserPlantService {

    private final UserPlantRepository userPlantRepository;

    public List<UserPlant> findAllByUserId(Long userId) {
        return userPlantRepository.findAllByUserId(userId);
    }

    public UserPlant save(UserPlant userPlant) {
        return userPlantRepository.save(userPlant);
    }

   public Optional<UserPlant> findById(Long userPlantId){
        return userPlantRepository.findById(userPlantId);
   }
}
