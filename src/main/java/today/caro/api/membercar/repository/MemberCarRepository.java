package today.caro.api.membercar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import today.caro.api.membercar.entity.MemberCar;

public interface MemberCarRepository extends JpaRepository<MemberCar, Long> {
}
