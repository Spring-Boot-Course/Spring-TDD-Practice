package me.sml.demo.domain.board;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class BoardRequestDto {

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

}
