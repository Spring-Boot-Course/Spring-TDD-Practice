package me.sml.demo.domain.board;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponse {

    private String title;

    private String content;

    private LocalDateTime createTime;

    @Builder
    public BoardResponse(String title, String content, LocalDateTime createTime) {
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }
}
