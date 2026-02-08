package today.caro.api.drivingrecord.dto;

import today.caro.api.drivingrecord.entity.DrivingRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DrivingRecordGetResponse(
    Long id,
    LocalDateTime startDateTime,
    LocalDateTime endDateTime,
    BigDecimal distanceKm,
    String startLocation,
    String endLocation,
    String vehicleBrandName,
    String vehicleModelName,
    String vehicleVariantName,
    int earnedPoints
) {
    public static DrivingRecordGetResponse from(DrivingRecord record) {
        return new DrivingRecordGetResponse(
            record.getId(),
            record.getStartDateTime(),
            record.getEndDateTime(),
            record.getDistanceKm(),
            record.getStartLocation(),
            record.getEndLocation(),
            record.getMemberCar().getModel().getBrand().getName(),
            record.getMemberCar().getModel().getName(),
            record.getMemberCar().getModel().getVariant(),
            record.getEarnedPoints()
        );
    }
}
