package kr.co.univalue.domain.video.service;
import jakarta.transaction.Transactional;
import kr.co.univalue.domain.file.domain.type.FileType;
import kr.co.univalue.domain.file.service.MakeDirectoryService;
import kr.co.univalue.domain.file.service.SaveFileService;
import kr.co.univalue.domain.video.domain.Video;
import kr.co.univalue.domain.video.domain.repository.VideoRepository;
import kr.co.univalue.domain.video.presentation.dto.req.VideoUploadRequest;
import kr.co.univalue.domain.video.presentation.dto.res.ReturnInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class VideoUploadService {
    private final VideoRepository videoRepository;
    private final MakeDirectoryService makeDirectoryService;
    private final SaveFileService saveFileService;

    @Transactional
    public ReturnInfoResponse execute(VideoUploadRequest videoUploadRequest) {
        MultipartFile file = videoUploadRequest.file();
        makeDirectoryService.execute(null);
        UUID uuid = UUID.randomUUID();
        String saveDir = makeDirectoryService.execute(FileType.video);
        String fileName = uuid + "_" + file.getOriginalFilename();
        String originName = file.getOriginalFilename();
        String videoName = originName.substring(0, originName.indexOf('.'));
        String title = videoUploadRequest.title();
        String role = videoUploadRequest.role();
        String name = videoUploadRequest.name();

        saveFileService.execute(file, saveDir, fileName);
        Video video = Video.builder()
                .videoName(videoName)
                .videoPath(saveDir + "/" + videoName)
                .uuid(uuid)
                .title(title)
                .role(role)
                .name(name)
                .build();

        videoRepository.save(video);

        return ReturnInfoResponse.builder()
                .fileName(fileName)
                .title(title)
                .name(name)
                .role(role)
                .build();
    }
}
