package app.flowercare_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "userplant")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class UserPlant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private AppUser user;

    @ManyToOne
    private Plant plant;

    @Column
    private LocalDateTime wateringExpireDate;

    @Column
    private LocalDateTime fertilizerExpireDate;

    @Column
    private boolean wateringDateExpired;

    @Column
    private boolean fertilizerDateExpired;

    public void resetWateringDate(){
        this.wateringExpireDate = LocalDateTime.now().plusDays(1);
        this.wateringDateExpired = false;
    }

    public void resetFertilizingDate(){
        this.fertilizerExpireDate = LocalDateTime.now().plusDays(14);
        this.fertilizerDateExpired = false;
    }

    public UserPlant() {
        this.wateringExpireDate = LocalDateTime.now();
        this.fertilizerExpireDate = LocalDateTime.now();
        this.wateringDateExpired = true;
        this.fertilizerDateExpired = true;
    }

    public UserPlant(AppUser appUser, Plant plant) {
        this.user = appUser;
        this.plant = plant;
        this.wateringExpireDate = LocalDateTime.now();
        this.fertilizerExpireDate = LocalDateTime.now();
        this.wateringDateExpired = true;
        this.fertilizerDateExpired = true;
    }
}
