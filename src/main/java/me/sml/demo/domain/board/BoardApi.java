package me.sml.demo.domain.board;

import lombok.RequiredArgsConstructor;
import me.sml.demo.domain.board.dto.FindBoardResponse;
import me.sml.demo.domain.board.dto.SaveBoardRequest;
import me.sml.demo.domain.board.dto.SaveBoardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardApi {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<SaveBoardResponse> saveBoard(@RequestBody @Valid SaveBoardRequest dto) {
        Board board = boardService.saveBoard(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        SaveBoardResponse.builder()
                                .title(board.getTitle())
                                .content(board.getContent())
                                .createTime(board.getCreateTime())
                                .message("success")
                                .build()
                );
    }

    @GetMapping
    public ResponseEntity<FindBoardResponse> findAllBoards(){
        List<Board> boards = boardService.findAllBoards();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        FindBoardResponse.builder()
                                .boards(boards)
                                .message("success")
                                .build()
                );
    }

}
