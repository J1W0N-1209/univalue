package kr.co.univalue.domain.auth.service.google;

import kr.co.univalue.domain.auth.presentation.dto.res.TokenResponse;
import kr.co.univalue.domain.user.domain.User;
import kr.co.univalue.domain.user.domain.repository.UserRepository;
import kr.co.univalue.domain.user.domain.type.Provider;
import kr.co.univalue.domain.user.facade.UserFacade;
import kr.co.univalue.global.feign.auth.google.GoogleInformationClient;
import kr.co.univalue.global.feign.auth.google.dto.res.GoogleInformationResponse;
import kr.co.univalue.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoogleAuthService {
    private final GoogleInformationClient googleInformationClient;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public TokenResponse execute(String accessToken) {
        GoogleInformationResponse response = googleInformationClient
                .getUserInformation(accessToken);
        String email = response.getEmail();

        Optional<User> user = userFacade.findEmail(email);

        if (user.isEmpty()) {
            userRepository.save(User.builder()
                    .email(email)
                    .nickname(response.getName())
                    .profileImg(response.getPicture())
                    .provider(Provider.GOOGLE)
                    .build());
        }

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(email))
                .refreshToken(jwtTokenProvider.createRefreshToken(email))
                .build();
    }
}
