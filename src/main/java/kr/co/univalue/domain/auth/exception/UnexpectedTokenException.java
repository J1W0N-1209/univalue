package kr.co.univalue.domain.auth.exception;

import kr.co.univalue.global.config.error.exception.BusinessException;
import kr.co.univalue.global.config.error.exception.ErrorCode;

public class UnexpectedTokenException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new UnexpectedTokenException();

    private UnexpectedTokenException() {super(ErrorCode.INVALID_JWT);}
}
