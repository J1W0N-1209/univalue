package kr.co.univalue.domain.auth.service;

import kr.co.univalue.domain.auth.domain.repository.RefreshTokenRepository;
import kr.co.univalue.domain.auth.presentation.dto.req.RefreshTokenRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteRefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public void execute(RefreshTokenRequest request) {
        refreshTokenRepository.deleteById(request.getRefreshToken());
    }
}
