package today.caro.api.vehicle.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car_model")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private CarBrand brand;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String variant;

    @Column(nullable = false)
    private Integer startYear;

    private Integer endYear;

    public CarModel(CarBrand brand, String name, String variant, Integer startYear, Integer endYear) {
        this.brand = brand;
        this.name = name;
        this.variant = variant;
        this.startYear = startYear;
        this.endYear = endYear;
    }

}
