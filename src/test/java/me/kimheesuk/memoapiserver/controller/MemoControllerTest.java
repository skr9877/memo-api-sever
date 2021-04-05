package me.kimheesuk.memoapiserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import me.kimheesuk.memoapiserver.dto.MemoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class MemoControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext ctx;

    ObjectMapper mapper;

    @BeforeEach
    public void setMockMvc(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();

        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Test
    public void getMemoListTest() throws Exception{
        this.mockMvc.perform(get("/memo"))
                .andExpect(status().isOk());

    }

    //@Test
    public void getMemoTest() throws Exception{
        this.mockMvc.perform(get("/memo/{memoId}", 1L))
                .andExpect(status().isOk());
    }

    //@Test
    public void addMemoTest() throws Exception{
        String requestBody = mapper.writeValueAsString(newMemo());

        this.mockMvc.perform(post("/memo")
                    .content(requestBody)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    //@Test
    public void editMemoTest() throws Exception{
        String requestBody = mapper.writeValueAsString(updateMemo());

        this.mockMvc.perform(put("/memo/{memoId}", 1L)
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    //@Test
    public void deleteMemoTest() throws Exception{
        this.mockMvc.perform(delete("/memo/{memoId}", 1L))
                .andExpect(status().isOk());
    }

    public MemoDto newMemo(){
        // add memo
        LocalDateTime currentTime = LocalDateTime.now();

        MemoDto memoDto = new MemoDto();
        memoDto.setUserId("admin");
        memoDto.setUserName("관리자");
        memoDto.setTitle("추가 테스트 제목");
        memoDto.setContents("추가 테스트 컨텐츠");
        memoDto.setCreateTime(currentTime);
        memoDto.setUpdateTime(currentTime);

        return memoDto;
    }

    public MemoDto updateMemo(){
        // add memo
        LocalDateTime currentTime = LocalDateTime.now();

        MemoDto memoDto = new MemoDto();
        memoDto.setId(1L);
        memoDto.setTitle("업데이트 된 제목");
        memoDto.setContents("업데이트 된 컨텐츠");

        return memoDto;
    }
}