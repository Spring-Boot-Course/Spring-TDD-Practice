package me.sml.demo.domain.board.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sml.demo.domain.board.Board;

import javax.persistence.Entity;
import java.util.List;

@Getter
@NoArgsConstructor
public class FindBoardResponse {

    List<Board> boards;

    String message;

    @Builder
    public FindBoardResponse(List<Board> boards, String message) {
        this.boards = boards;
        this.message = message;
    }
}
