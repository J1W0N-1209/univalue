package kr.co.univalue.domain.file.exception;

import kr.co.univalue.global.config.error.exception.BusinessException;
import kr.co.univalue.global.config.error.exception.ErrorCode;

public class ContentTypeNotFoundException extends BusinessException{
    public static final BusinessException EXCEPTION = new ContentTypeNotFoundException();
    private ContentTypeNotFoundException() {super(ErrorCode.CONTENT_TYPE_NOT_FOUND);}
}
