package kr.co.univalue.domain.video.presentation.dto;

import jakarta.validation.Valid;
import kr.co.univalue.domain.video.domain.Video;
import kr.co.univalue.domain.video.presentation.dto.req.VideoUploadRequest;
import kr.co.univalue.domain.video.presentation.dto.res.ReturnInfoResponse;
import kr.co.univalue.domain.video.service.VideoPageService;
import kr.co.univalue.domain.video.service.VideoUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/video")
public class VideoController {
    private final VideoUploadService videoUploadService;
    private final VideoPageService videoPageService;

    @PostMapping("/upload")
    public ReturnInfoResponse upload(@ModelAttribute @Valid VideoUploadRequest videoUploadRequest) {
        return videoUploadService.execute(videoUploadRequest);
    }

    @GetMapping("/page/{page}")
    public Page<Video> page(@PathVariable int page) {
        return videoPageService.execute(page);
    }
}
