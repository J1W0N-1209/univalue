package kr.co.univalue.domain.video.presentation.dto.res;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class ReturnInfoResponse {
    private String fileName;
    private String title;
    private String name;
    private String role;

    @Builder
    public ReturnInfoResponse(String fileName, String title, String name, String role) {
        this.fileName = fileName;
        this.title = title;
        this.name = name;
        this.role = role;
    }
}
