package me.sml.demo.domain.board;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponse {

    private String title;

    private String content;

    private String message;

    private LocalDateTime createTime;


    @Builder
    public BoardResponse(String title, String content, String message, LocalDateTime createTime) {
        this.title = title;
        this.content = content;
        this.message = message;
        this.createTime = createTime;
    }
}
