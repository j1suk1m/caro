package today.caro.api.vehicle.dto;

import today.caro.api.vehicle.entity.CarBrand;

public record VehicleBrandListResponse(
    Long id,
    String name
) {
    public static VehicleBrandListResponse from(CarBrand brand) {
        return new VehicleBrandListResponse(brand.getId(), brand.getName());
    }
}
