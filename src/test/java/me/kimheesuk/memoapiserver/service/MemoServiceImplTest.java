package me.kimheesuk.memoapiserver.service;

import lombok.extern.log4j.Log4j;
import me.kimheesuk.memoapiserver.dto.MemoDto;
import me.kimheesuk.memoapiserver.jpa.domain.Memo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ModelMap;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MemoServiceImplTest {
    @Autowired
    MemoService memoService;

    @Test
    public void addAndGetMemoList(){
        // add memo
        LocalDateTime currentTime = LocalDateTime.now();

        MemoDto memoDto1 = new MemoDto();
        memoDto1.setUserId("admin");
        memoDto1.setUserName("관리자");
        memoDto1.setTitle("테스트 제목1");
        memoDto1.setContents("테스트 컨텐츠");
        memoDto1.setCreateTime(currentTime);
        memoDto1.setUpdateTime(currentTime);

        MemoDto memoDto2 = new MemoDto();
        memoDto2.setUserId("admin");
        memoDto2.setUserName("관리자");
        memoDto2.setTitle("테스트 제목2");
        memoDto2.setContents("테스트 컨텐츠");
        memoDto2.setCreateTime(currentTime);
        memoDto2.setUpdateTime(currentTime);

        //assertEquals(memoDto.getUserId(), memo.getUserId());

        memoService.addMemo(memoDto1);
        memoService.addMemo(memoDto2);

        editMemo();

        System.out.println(memoService.getMemo(1L));

        memoService.deleteMemo(1L);
    }

    public void editMemo(){
        LocalDateTime currentTime = LocalDateTime.now();

        MemoDto memoDto3 = new MemoDto();

        memoDto3.setId(2L);
        memoDto3.setUserId("admin");
        memoDto3.setUserName("관리자");
        memoDto3.setTitle("테스트 제목 변경");
        memoDto3.setContents("테스트 컨텐츠 변경");
        memoDto3.setCreateTime(currentTime);
        memoDto3.setUpdateTime(currentTime);

        memoService.editMemo(memoDto3);

        System.out.println(memoService.getMemoList());
    }
}