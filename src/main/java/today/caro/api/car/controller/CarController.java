package today.caro.api.car.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import today.caro.api.car.dto.MemberCarGetResponse;
import today.caro.api.common.dto.ApiResponse;
import today.caro.api.common.dto.EmptyData;
import today.caro.api.common.dto.SuccessCode;
import today.caro.api.config.SwaggerConstants;
import today.caro.api.car.dto.MemberCarRegisterRequest;
import today.caro.api.car.dto.MemberCarRegisterResponse;
import today.caro.api.car.service.MemberCarService;

import java.util.List;

@Tag(name = "Car", description = "회원 차량 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cars")
public class CarController {

    private final MemberCarService memberCarService;

    @Operation(
        summary = "내 차량 등록",
        description = "현재 사용자의 개인 차량을 등록합니다.",
        security = @SecurityRequirement(name = SwaggerConstants.BEARER_SCHEME)
    )
    @ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "성공"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "인증 필요"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "리소스를 찾을 수 없음")
    })
    @PostMapping
    public ResponseEntity<ApiResponse<MemberCarRegisterResponse>> register(
        Authentication authentication,
        @Valid @RequestBody MemberCarRegisterRequest request
    ) {
        Long memberId = Long.parseLong(authentication.getName());
        MemberCarRegisterResponse response = memberCarService.register(memberId, request);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(ApiResponse.success(SuccessCode.CREATED, response));
    }

    @Operation(
        summary = "내 차량 목록 조회",
        description = "현재 사용자의 개인 차량 목록을 조회합니다.",
        security = @SecurityRequirement(name = SwaggerConstants.BEARER_SCHEME)
    )
    @ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "성공"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "인증 필요"),
    })
    @GetMapping
    public ResponseEntity<ApiResponse<List<MemberCarGetResponse>>> getAllCars(Authentication authentication) {
        Long memberId = Long.parseLong(authentication.getName());
        List<MemberCarGetResponse> response = memberCarService.findAllCars(memberId);

        return ResponseEntity
            .ok(ApiResponse.success(SuccessCode.OK, response));
    }

    @Operation(
        summary = "내 차량 삭제",
        description = "현재 사용자의 개인 차량을 회원 차량 아이디로 삭제합니다.",
        security = @SecurityRequirement(name = SwaggerConstants.BEARER_SCHEME)
    )
    @ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "인증 필요"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "접근 권한 없음")
    })
    @DeleteMapping("/{member-car-id}")
    public ResponseEntity<ApiResponse<EmptyData>> delete(
        Authentication authentication,
        @PathVariable(name = "member-car-id") Long memberCarId
    ) {
        Long memberId = Long.parseLong(authentication.getName());
        memberCarService.delete(memberId, memberCarId);

        return ResponseEntity
            .ok(ApiResponse.success(SuccessCode.OK));
    }

}
