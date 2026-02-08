package today.caro.api.coupon.repository;

import today.caro.api.coupon.dto.MemberCouponGetResponse;

import java.util.List;

public interface MemberCouponRepositoryCustom {

    List<MemberCouponGetResponse> findActiveCouponsByMemberId(Long memberId);

}
