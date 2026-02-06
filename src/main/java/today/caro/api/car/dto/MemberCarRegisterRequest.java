package today.caro.api.car.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MemberCarRegisterRequest(

    @NotNull(message = "차량 모델 아이디는 필수입니다.")
    Long modelId,

    @NotBlank(message = "차량 번호는 필수입니다.")
    String registrationNumber,

    @Min(value = 0, message = "주행 거리는 0 이상이어야 합니다.")
    Integer mileage

) {
    public MemberCarRegisterRequest {
        if (mileage == null) {
            mileage = 10000;
        }
    }
}
