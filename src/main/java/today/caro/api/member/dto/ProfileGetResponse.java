package today.caro.api.member.dto;

import today.caro.api.car.dto.MemberCarGetResponse;
import today.caro.api.member.entity.Member;
import today.caro.api.car.entity.MemberCar;

public record ProfileGetResponse(
    String name,
    String email,
    MemberCarGetResponse primaryCar
) {
    public static ProfileGetResponse of(Member member, MemberCar car) {
        if (car == null) {
            return new ProfileGetResponse(
                member.getName(),
                member.getEmail(),
                null
            );
        }

        return new ProfileGetResponse(
            member.getName(),
            member.getEmail(),
            MemberCarGetResponse.from(car)
        );
    }
}
