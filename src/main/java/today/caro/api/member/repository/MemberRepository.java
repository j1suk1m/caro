package today.caro.api.member.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import today.caro.api.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByEmail(String email);

    Optional<Member> findByEmail(String email);

}
