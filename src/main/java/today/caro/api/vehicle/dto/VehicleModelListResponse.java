package today.caro.api.vehicle.dto;

import today.caro.api.vehicle.entity.CarModel;

public record VehicleModelListResponse(
    Long id,
    String name,
    String variant,
    Integer startYear,
    Integer endYear
) {
    public static VehicleModelListResponse from(CarModel model) {
        return new VehicleModelListResponse(
            model.getId(),
            model.getName(),
            model.getVariant(),
            model.getStartYear(),
            model.getEndYear()
        );
    }
}
