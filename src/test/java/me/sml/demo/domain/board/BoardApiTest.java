package me.sml.demo.domain.board;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.sml.demo.domain.board.dto.SaveBoardRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BoardApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void 게시글을_저장() throws Exception {
        //given
        SaveBoardRequest saveBoardRequest = SaveBoardRequest.builder()
                .title("게시글1")
                .content("게시글1")
                .build();

        //when
        ResultActions resultActions = mockMvc.perform(
                post("/board")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(objectMapper.writeValueAsString(saveBoardRequest))
        ).andDo(print());

        //then
        resultActions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("message").value("success"))
                .andExpect(jsonPath("title").value(saveBoardRequest.getTitle()))
                .andExpect(jsonPath("content").value(saveBoardRequest.getContent())
                );
    }

    @Test
    public void 모든_게시글을_읽어온다() throws Exception{
        //given
        Board board1 = Board.builder()
                .title("게시글 1")
                .content("게시글 1")
                .createTime(LocalDateTime.now())
                .build();

        Board board2 = Board.builder()
                .title("게시글 2")
                .content("게시글 2")
                .createTime(LocalDateTime.now())
                .build();

        List<Board> boards = new ArrayList<>();
        boards.add(board1);
        boards.add(board2);

        boardRepository.saveAll(boards);

        //when
        ResultActions resultActions = mockMvc.perform(get("/board"))
                .andDo(print());

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("message").value("success"))
                .andExpect(jsonPath("boards").isArray())
                .andExpect(jsonPath("boards", hasSize(2)));
    }


}