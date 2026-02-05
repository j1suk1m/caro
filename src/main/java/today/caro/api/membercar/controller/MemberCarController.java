package today.caro.api.membercar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import today.caro.api.common.dto.ApiResponse;
import today.caro.api.common.dto.SuccessCode;
import today.caro.api.config.SwaggerConstants;
import today.caro.api.membercar.dto.MemberCarRegisterRequest;
import today.caro.api.membercar.dto.MemberCarRegisterResponse;
import today.caro.api.membercar.service.MemberCarService;

@Tag(name = "My Car", description = "내 차량 관리 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/my/car")
public class MemberCarController {

    private final MemberCarService memberCarService;

    @Operation(
        summary = "차량 등록",
        description = "개인 차량을 등록합니다.",
        security = @SecurityRequirement(name = SwaggerConstants.BEARER_SCHEME)
    )
    @ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "등록 성공"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "입력값 검증 실패"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "인증 실패"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "차량 모델을 찾을 수 없음")
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

}
