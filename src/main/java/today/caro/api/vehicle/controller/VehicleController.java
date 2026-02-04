package today.caro.api.vehicle.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import today.caro.api.common.dto.ApiResponse;
import today.caro.api.common.dto.SuccessCode;
import today.caro.api.vehicle.dto.VehicleBrandListResponse;
import today.caro.api.vehicle.dto.VehicleModelListResponse;
import today.caro.api.vehicle.service.VehicleService;

import java.util.List;

@Tag(name = "Vehicle", description = "차량 마스터 데이터 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Operation(summary = "차량 브랜드 전체 조회", description = "등록된 모든 차량 브랜드를 조회합니다.")
    @ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공")
    })
    @GetMapping("/brands")
    public ResponseEntity<ApiResponse<List<VehicleBrandListResponse>>> getAllBrands() {
        List<VehicleBrandListResponse> response = vehicleService.getAllBrands();

        return ResponseEntity
            .ok(ApiResponse.success(SuccessCode.OK, response));
    }

    @Operation(summary = "차량 모델 조회", description = "특정 브랜드의 차량 모델을 조회합니다.")
    @ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "차량 브랜드를 찾을 수 없음")
    })
    @GetMapping("/brands/{brand-id}/models")
    public ResponseEntity<ApiResponse<List<VehicleModelListResponse>>> getModelsByBrand(
        @PathVariable(name = "brand-id") Long brandId,
        @RequestParam(required = false) String keyword
    ) {
        List<VehicleModelListResponse> response = vehicleService.getModelsByBrand(brandId, keyword);

        return ResponseEntity
            .ok(ApiResponse.success(SuccessCode.OK, response));
    }

}
