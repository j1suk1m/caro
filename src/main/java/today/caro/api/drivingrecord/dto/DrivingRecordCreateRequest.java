package today.caro.api.drivingrecord.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DrivingRecordCreateRequest(

    @NotNull(message = "차량 ID는 필수입니다.")
    Long memberCarId,

    @NotNull(message = "운행 시작 일시는 필수입니다.")
    LocalDateTime startDateTime,

    @NotNull(message = "운행 종료 일시는 필수입니다.")
    LocalDateTime endDateTime,

    @NotNull(message = "주행 거리는 필수입니다.")
    @Positive(message = "주행 거리는 0보다 커야 합니다.")
    BigDecimal distanceKm,

    @NotBlank(message = "출발 위치는 필수입니다.")
    String startLocation,

    @NotBlank(message = "도착 위치는 필수입니다.")
    String endLocation

) {
}
