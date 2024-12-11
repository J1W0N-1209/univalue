package kr.co.univalue.domain.video.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    private Long id;

    @Column
    private String videoName;

    @Column
    private String videoPath;

    @Column
    private UUID uuid;

    @Column
    private String title;

    @Column
    private String name;

    @Column
    private String role;

    @Builder
    public Video(String videoName, String videoPath, UUID uuid, String title, String name, String role) {
        this.videoName = videoName;
        this.videoPath = videoPath;
        this.uuid = uuid;
        this.title = title;
        this.name = name;
        this.role = role;
    }
}
