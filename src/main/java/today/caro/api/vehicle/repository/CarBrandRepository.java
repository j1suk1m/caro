package today.caro.api.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import today.caro.api.vehicle.entity.CarBrand;

public interface CarBrandRepository extends JpaRepository<CarBrand, Long> {
}
