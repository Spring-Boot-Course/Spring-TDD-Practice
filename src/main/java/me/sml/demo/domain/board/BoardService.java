package me.sml.demo.domain.board;

import lombok.RequiredArgsConstructor;
import me.sml.demo.domain.board.dto.SaveBoardRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board saveBoard(SaveBoardRequest saveBoardRequest){
        return boardRepository.save(saveBoardRequest.toEntity());
    }

    public List<Board> findAllBoards() {
        return boardRepository.findAll();
    }
}
