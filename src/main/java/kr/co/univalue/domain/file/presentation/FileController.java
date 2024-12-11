package kr.co.univalue.domain.file.presentation;

import kr.co.univalue.domain.file.domain.type.FileType;
import kr.co.univalue.domain.file.service.GetContentType;
import kr.co.univalue.domain.file.service.ShowFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/files")
public class FileController {
    private final ShowFileService showFileService;
    private final GetContentType getContentType;

    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> showFile(@RequestParam(value = "type") FileType fileType,
                                             @PathVariable String fileName) {
        Resource resource = showFileService.execute(fileType, fileName);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + fileName);
        String contentType = getContentType.execute(fileName);

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }
}
