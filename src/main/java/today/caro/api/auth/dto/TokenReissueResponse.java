package today.caro.api.auth.dto;

public record TokenReissueResponse(
    String accessToken,
    String refreshToken,
    long accessTokenExpiresIn,
    long refreshTokenExpiresIn
) {
}
