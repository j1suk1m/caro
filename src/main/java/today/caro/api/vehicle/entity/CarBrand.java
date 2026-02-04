package today.caro.api.vehicle.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car_brand")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public CarBrand(String name) {
        this.name = name;
    }

}
