package kr.co.univalue.global.security.jwt.exception;

import kr.co.univalue.global.config.error.exception.BusinessException;
import kr.co.univalue.global.config.error.exception.ErrorCode;

public class InvalidJwtException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}