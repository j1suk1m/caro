package today.caro.api.auth.dto;

public record LoginResponse(
    Long memberId,
    String accessToken,
    String refreshToken,
    long accessTokenExpiresIn,
    long refreshTokenExpiresIn
) {
}
