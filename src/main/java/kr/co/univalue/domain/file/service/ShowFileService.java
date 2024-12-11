package kr.co.univalue.domain.file.service;

import kr.co.univalue.domain.file.domain.type.FileType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class    ShowFileService {
    private static final Logger log = LogManager.getLogger(ShowFileService.class);
    @Value("${spring.save.dir}")
    private String originDir;

    public Resource execute(FileType fileType, String fileName) {
        String dirPath = originDir + "/" + fileType;
        Path filePath = Paths.get(dirPath).resolve(fileName);
        log.info(filePath.toString());
        Resource resource = null;
        try {
            resource = new UrlResource(filePath.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return resource;
    }
}
