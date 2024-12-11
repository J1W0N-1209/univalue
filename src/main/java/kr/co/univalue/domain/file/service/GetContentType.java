package kr.co.univalue.domain.file.service;

import kr.co.univalue.domain.file.exception.ContentTypeNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class GetContentType {
    private static final Logger log = LogManager.getLogger(GetContentType.class);

    public String execute(String fileName) {
        switch (fileName.substring(fileName.indexOf(".")).toLowerCase()) {
            case ".jpg":
            case ".jpeg":
            case ".png":
                return MediaType.IMAGE_JPEG_VALUE;
            case ".mp4":
                return "video/mp4";
            default:
                log.info(fileName.substring(fileName.indexOf(".")).toLowerCase());
                throw ContentTypeNotFoundException.EXCEPTION;
        }
    }
}
