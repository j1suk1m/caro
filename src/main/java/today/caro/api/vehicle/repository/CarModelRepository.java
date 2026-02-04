package today.caro.api.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import today.caro.api.vehicle.entity.CarModel;

import java.util.List;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {

    @Query("""
           select cm
           from CarModel cm
           where cm.brand.id = :brandId
           order by cm.name asc, cm.variant asc
           """)
    List<CarModel> findByBrandId(@Param("brandId") Long brandId);

    @Query("""
           select cm
           from CarModel cm
           where cm.brand.id = :brandId and cm.name like concat('%', :keyword, '%')
           order by cm.name asc, cm.variant asc
           """)
    List<CarModel> findByBrandIdAndKeyword(@Param("brandId") Long brandId, @Param("keyword") String keyword);

}
