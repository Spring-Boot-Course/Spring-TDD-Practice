package me.sml.demo.domain.board;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardApi {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardResponse> saveBoard(@Valid BoardRequestDto dto, BindingResult bindingResult) {
        Board board = boardService.saveBoard(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        BoardResponse.builder()
                                .title(board.getTitle())
                                .content(board.getContent())
                                .createTime(board.getCreateTime())
                                .build()
                );
    }


}
