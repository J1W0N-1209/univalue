package kr.co.univalue.domain.auth.service;

import kr.co.univalue.domain.auth.domain.RefreshToken;
import kr.co.univalue.domain.auth.domain.repository.RefreshTokenRepository;
import kr.co.univalue.domain.auth.presentation.dto.res.AccessTokenResponse;
import kr.co.univalue.global.security.jwt.JwtTokenProvider;
import kr.co.univalue.global.security.jwt.exception.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateAccessTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(readOnly = true)
    public AccessTokenResponse execute(String token) {
        RefreshToken refreshToken = getRefreshToken(token);
        return new AccessTokenResponse(jwtTokenProvider
                .createAccessToken(refreshToken.getEmail()));
    }

    private RefreshToken getRefreshToken(String token) {
        return refreshTokenRepository.findById(token)
                .orElseThrow(() -> ExpiredJwtException.EXCEPTION);
    }
}
