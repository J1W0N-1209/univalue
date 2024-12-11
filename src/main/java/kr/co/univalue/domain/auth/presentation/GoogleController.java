package kr.co.univalue.domain.auth.presentation;

import kr.co.univalue.domain.auth.presentation.dto.req.AccessTokenRequest;
import kr.co.univalue.domain.auth.presentation.dto.res.TokenResponse;
import kr.co.univalue.domain.auth.service.google.GoogleAuthLinkService;
import kr.co.univalue.domain.auth.service.google.GoogleAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/google")
@RestController
public class GoogleController {
    private final GoogleAuthLinkService googleLinkService;
    private final GoogleAuthService googleAuthService;

    @GetMapping
    public String getGoogleAuthLink() {
        return googleLinkService.execute();
    }

    @PostMapping
    public TokenResponse login(@RequestBody @Valid AccessTokenRequest accessTokenRequest) {
        return googleAuthService.execute(accessTokenRequest.getAccessToken());
    }
}
