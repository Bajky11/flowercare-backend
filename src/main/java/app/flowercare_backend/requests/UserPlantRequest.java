package app.flowercare_backend.requests;

import lombok.Data;

@Data
public class UserPlantRequest {
    private Long userId;
    private Long plantId;
}
