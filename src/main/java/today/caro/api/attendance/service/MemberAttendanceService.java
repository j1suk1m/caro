package today.caro.api.attendance.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import today.caro.api.attendance.dto.MemberAttendResponse;
import today.caro.api.attendance.entity.MemberAttendance;
import today.caro.api.attendance.repository.MemberAttendanceRepository;
import today.caro.api.common.exception.BusinessException;
import today.caro.api.common.exception.ErrorCode;
import today.caro.api.member.entity.Member;
import today.caro.api.member.repository.MemberRepository;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class MemberAttendanceService {

    private final MemberRepository memberRepository;
    private final MemberAttendanceRepository memberAttendanceRepository;

    @Transactional
    public MemberAttendResponse attend(Long memberId) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));

        LocalDate today = LocalDate.now();

        // 오늘 출석했는지 확인
        if (memberAttendanceRepository.existsByMemberIdAndAttendanceDate(memberId, today)) {
            throw new BusinessException(ErrorCode.MEMBER_ALREADY_ATTENDED);
        }

        // 마지막 출석 기록 조회
        MemberAttendance lastAttendance = memberAttendanceRepository
            .findTopByMemberOrderByAttendanceDateDesc(member)
            .orElse(null);

        int streak = 1;

        // 스트릭 갱신
        if (lastAttendance != null) {
            LocalDate yesterday = today.minusDays(1);

            if (lastAttendance.getAttendanceDate().isEqual(yesterday)) {
                streak = lastAttendance.getStreak() + 1;
            }
        }

        int MIN_POINT = 1;
        int MAX_POINT = 50;
        boolean isBonusDay = false;
        int points = ThreadLocalRandom.current().nextInt(MIN_POINT, MAX_POINT + 1);

        // 보너스 점수 부여
        if (streak == 7) {
            points *= 2;
            isBonusDay = true;
        }

        MemberAttendance attendance = MemberAttendance.builder()
            .member(member)
            .attendanceDate(today)
            .streak(streak > 7 ? 1 : streak)
            .points(points)
            .isBonusDay(isBonusDay)
            .build();

        MemberAttendance createdAttendance = memberAttendanceRepository.save(attendance);

        return MemberAttendResponse.from(createdAttendance);
    }

}
