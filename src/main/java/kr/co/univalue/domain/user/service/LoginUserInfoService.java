package kr.co.univalue.domain.user.service;

import kr.co.univalue.domain.user.domain.User;
import kr.co.univalue.domain.user.facade.UserFacade;
import kr.co.univalue.domain.user.presentation.dto.res.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LoginUserInfoService {
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public UserInfoResponse execute() {
        User user = userFacade.getCurrentUser();
        return new UserInfoResponse(user);
    }
}
