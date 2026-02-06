package today.caro.api.car.dto;

import today.caro.api.car.entity.MemberCar;

public record MemberCarGetResponse(
    Long id,
    String brandName,
    String modelName,
    String variant,
    String registrationNumber
) {
    public static MemberCarGetResponse from(MemberCar car) {
        return new MemberCarGetResponse(
            car.getId(),
            car.getModel().getBrand().getName(),
            car.getModel().getName(),
            car.getModel().getVariant(),
            car.getRegistrationNumber()
        );
    }
}
