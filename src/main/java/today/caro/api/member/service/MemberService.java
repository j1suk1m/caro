package today.caro.api.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import today.caro.api.common.exception.BusinessException;
import today.caro.api.common.exception.ErrorCode;
import today.caro.api.member.dto.ProfileGetResponse;
import today.caro.api.member.entity.Member;
import today.caro.api.member.repository.MemberRepository;
import today.caro.api.membercar.entity.MemberCar;
import today.caro.api.membercar.repository.MemberCarRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberCarRepository memberCarRepository;

    @Transactional(readOnly = true)
    public ProfileGetResponse getProfile(Long memberId) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));

        MemberCar car = memberCarRepository.findFirstByMemberId(memberId).orElse(null);

        return ProfileGetResponse.of(member, car);
    }

}
