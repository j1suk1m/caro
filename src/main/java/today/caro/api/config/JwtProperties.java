package today.caro.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.StandardCharsets;

@ConfigurationProperties(prefix = "jwt")
public record JwtProperties(
    String secret,
    long accessTokenExpiration, // ms
    long refreshTokenExpiration // ms
) {

    private static final int MIN_SECRET_LENGTH = 32;

    public JwtProperties {
        if (secret == null || secret.getBytes(StandardCharsets.UTF_8).length < MIN_SECRET_LENGTH) {
            throw new IllegalArgumentException("JWT secret은 최소 " + MIN_SECRET_LENGTH + "바이트여야 합니다.");
        }
    }

    public long accessTokenExpirationSeconds() {
        return accessTokenExpiration / 1000; // ms -> s 변환
    }

    public long refreshTokenExpirationSeconds() {
        return refreshTokenExpiration / 1000; // ms -> s 변환
    }

}
