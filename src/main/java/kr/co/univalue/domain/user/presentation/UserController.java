package kr.co.univalue.domain.user.presentation;

import kr.co.univalue.domain.user.domain.User;
import kr.co.univalue.domain.user.presentation.dto.res.UserInfoResponse;
import kr.co.univalue.domain.user.service.LoginUserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final LoginUserInfoService loginUserInfoService;

    @GetMapping
    public UserInfoResponse profile() {
        return loginUserInfoService.execute();
    }
}
