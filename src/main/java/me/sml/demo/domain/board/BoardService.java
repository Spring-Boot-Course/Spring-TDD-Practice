package me.sml.demo.domain.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board saveBoard(BoardRequestDto boardRequestDto){
        return boardRepository.save(boardRequestDto.toEntity());
    }
}
