package today.caro.api.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import today.caro.api.attendance.entity.MemberAttendance;
import today.caro.api.member.entity.Member;

import java.time.LocalDate;
import java.util.Optional;

public interface MemberAttendanceRepository extends JpaRepository<MemberAttendance, Long> {

    Optional<MemberAttendance> findTopByMemberOrderByAttendanceDateDesc(Member member);

    boolean existsByMemberIdAndAttendanceDate(Long memberId, LocalDate date);

}
