package kr.co.univalue.domain.video.presentation.dto.req;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record VideoUploadRequest(
    @NotNull
    String title,

    @NotNull
    String name,

    @NotNull
    String role,

    @NotNull
    MultipartFile file
) {}
