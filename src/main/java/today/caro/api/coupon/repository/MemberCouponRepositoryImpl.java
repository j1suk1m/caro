package today.caro.api.coupon.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import today.caro.api.coupon.dto.MemberCouponGetResponse;
import today.caro.api.coupon.entity.QMemberCoupon;
import today.caro.api.reward.entity.QRewardBrand;
import today.caro.api.reward.entity.QRewardCoupon;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberCouponRepositoryImpl implements MemberCouponRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MemberCouponGetResponse> findActiveCouponsByMemberId(Long memberId) {
        QMemberCoupon memberCoupon = QMemberCoupon.memberCoupon;
        QRewardCoupon rewardCoupon = QRewardCoupon.rewardCoupon;
        QRewardBrand rewardBrand = QRewardBrand.rewardBrand;

        return queryFactory
            .select(Projections.constructor(MemberCouponGetResponse.class,
                memberCoupon.id,
                rewardBrand.name,
                rewardCoupon.itemName,
                memberCoupon.expiredAt,
                memberCoupon.usedPoints
            ))
            .from(memberCoupon)
            .join(memberCoupon.rewardCoupon, rewardCoupon)
            .join(rewardCoupon.brand, rewardBrand)
            .where(
                memberCoupon.member.id.eq(memberId),
                memberCoupon.usedAt.isNull(), // 사용하지 않은 쿠폰만
                memberCoupon.expiredAt.after(LocalDateTime.now()) // 만료되지 않은 쿠폰만
            )
            .orderBy(memberCoupon.expiredAt.asc()) // 유효 기간 만료 임박 순서대로 정렬
            .fetch();
    }

}
