package app.flowercare_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column(length = 2048)
    private String wateringRequirements;

    @Column(length = 2048)
    private String fertilizerRequirements;

    @Column(length = 2048)
    private String sunRequirements;

    @Column(length = 2048)
    private String fertilizerInstructions;


    @JsonIgnore
    @OneToMany(mappedBy = "plant", fetch = FetchType.LAZY)
    private List<UserPlant> userPlants;
}
