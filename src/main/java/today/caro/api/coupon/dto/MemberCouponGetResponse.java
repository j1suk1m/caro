package today.caro.api.coupon.dto;

import java.time.LocalDateTime;

public record MemberCouponGetResponse(
    Long id,
    String brandName,
    String itemName,
    LocalDateTime expiredAt,
    int usedPoints
) {
}
