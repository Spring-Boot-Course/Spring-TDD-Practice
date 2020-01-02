package me.sml.demo.domain.board.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sml.demo.domain.board.Board;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SaveBoardRequest {

    @NotNull
    private String title;

    @NotNull
    private String content;

    public Board toEntity(){
        return Board.builder()
                .title(this.title)
                .content(this.content)
                .createTime(LocalDateTime.now())
                .build();
    }

    @Builder
    public SaveBoardRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
