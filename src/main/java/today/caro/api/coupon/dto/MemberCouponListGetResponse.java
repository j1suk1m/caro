package today.caro.api.coupon.dto;

import java.util.List;

public record MemberCouponListGetResponse(
    long totalCount,
    List<MemberCouponGetResponse> coupons
) {
}
