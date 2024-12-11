package kr.co.univalue.domain.user.exception;

import kr.co.univalue.global.config.error.exception.BusinessException;
import kr.co.univalue.global.config.error.exception.ErrorCode;

public class UserNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {super(ErrorCode.USER_NOT_FOUND);}
}
