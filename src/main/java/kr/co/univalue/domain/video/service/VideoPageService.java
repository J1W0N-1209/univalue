package kr.co.univalue.domain.video.service;

import kr.co.univalue.domain.video.domain.Video;
import kr.co.univalue.domain.video.domain.repository.VideoRepository;
import kr.co.univalue.domain.video.presentation.dto.req.VideoUploadRequest;
import kr.co.univalue.domain.video.presentation.dto.res.ReturnInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VideoPageService {
    private final VideoRepository videoRepository;
    public Page<Video> execute(Integer page) {
        Page<Video> videoPage = videoRepository.findPageBy(PageRequest.of(page - 1, 12));
        return videoPage;
    }
}
