package today.caro.api.car.dto;

import today.caro.api.car.entity.MemberCar;

public record MemberCarRegisterResponse(
    Long id,
    String brandName,
    String modelName,
    String variant,
    Integer startYear,
    Integer endYear,
    String registrationNumber,
    Integer mileage
) {
    public static MemberCarRegisterResponse from(MemberCar memberCar) {
        return new MemberCarRegisterResponse(
            memberCar.getId(),
            memberCar.getModel().getBrand().getName(),
            memberCar.getModel().getName(),
            memberCar.getModel().getVariant(),
            memberCar.getModel().getStartYear(),
            memberCar.getModel().getEndYear(),
            memberCar.getRegistrationNumber(),
            memberCar.getMileage()
        );
    }
}
