package today.caro.api.security.token;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import today.caro.api.config.JwtProperties;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private static final String KEY_PREFIX = "refresh:";

    private final RedisTemplate<String, String> redisTemplate;
    private final JwtProperties jwtProperties;

    public void save(Long memberId, String refreshToken) {
        String key = KEY_PREFIX + memberId;

        redisTemplate.opsForValue().set(
            key,
            refreshToken,
            jwtProperties.refreshTokenExpiration(),
            TimeUnit.MILLISECONDS
        );
    }

    public void delete(Long memberId) {
        String key = KEY_PREFIX + memberId;
        redisTemplate.delete(key);
    }

}
