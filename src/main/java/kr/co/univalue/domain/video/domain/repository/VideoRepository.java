package kr.co.univalue.domain.video.domain.repository;

import kr.co.univalue.domain.video.domain.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VideoRepository extends JpaRepository<Video, Long> {
    Video findByUuid(UUID uuid);
    Page<Video> findPageBy(Pageable pageable);
}
