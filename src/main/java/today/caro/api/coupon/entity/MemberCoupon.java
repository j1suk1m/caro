package today.caro.api.coupon.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import today.caro.api.member.entity.Member;
import today.caro.api.reward.entity.RewardCoupon;

import java.time.LocalDateTime;

@Entity
@Table(name = "member_coupon")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class MemberCoupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reward_coupon_id", nullable = false)
    private RewardCoupon rewardCoupon;

    @Column(nullable = false)
    private int usedPoints;

    @Column(nullable = false, unique = true, length = 13)
    private String barcodeNumber;

    private LocalDateTime usedAt;

    @Column(nullable = false)
    private LocalDateTime expiredAt;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Builder
    public MemberCoupon(Member member, RewardCoupon rewardCoupon,
                        int usedPoints, String barcodeNumber, LocalDateTime expiredAt) {
        this.member = member;
        this.rewardCoupon = rewardCoupon;
        this.usedPoints = usedPoints;
        this.barcodeNumber = barcodeNumber;
        this.expiredAt = expiredAt;
    }

}
