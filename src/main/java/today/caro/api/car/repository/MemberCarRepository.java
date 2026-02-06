package today.caro.api.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import today.caro.api.car.entity.MemberCar;

import java.util.Optional;

public interface MemberCarRepository extends JpaRepository<MemberCar, Long> {

    @Query("""
        SELECT mc
        FROM MemberCar mc
        WHERE mc.member.id = :memberId
        ORDER BY mc.createdAt ASC
        LIMIT 1
    """)
    Optional<MemberCar> findFirstByMemberId(@Param("memberId") Long memberId);

}
