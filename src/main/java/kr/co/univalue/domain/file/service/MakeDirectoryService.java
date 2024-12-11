package kr.co.univalue.domain.file.service;

import kr.co.univalue.domain.file.domain.type.FileType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@RequiredArgsConstructor
@Service
public class MakeDirectoryService {
    @Value("${spring.save.dir}")
    private String originDir;

    public String execute(FileType type) {
        String saveDir = originDir + "/";
        try {
            File file = new File(originDir);
            if(!file.exists())
                file.mkdir();
            file = new File(saveDir);
            if(type != null) {
                if(!file.exists())
                    file.mkdir();
                saveDir += type + "/";
                file = new File(saveDir);
                if(!file.exists())
                    file.mkdir();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return saveDir;
    }
}
