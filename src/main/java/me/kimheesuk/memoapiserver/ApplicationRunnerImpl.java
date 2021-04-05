package me.kimheesuk.memoapiserver;

import lombok.RequiredArgsConstructor;
import me.kimheesuk.memoapiserver.dto.MemoDto;
import me.kimheesuk.memoapiserver.service.MemoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ApplicationRunnerImpl implements ApplicationRunner {
    private final MemoService memoService;

    @Override
    public void run(ApplicationArguments args) {
        try {
            addAndMemoList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addAndMemoList(){
        LocalDateTime currentTime = LocalDateTime.now();
        
        for(int i = 0; i < 5; ++i){
            MemoDto memoDto = new MemoDto();
            memoDto.setUserId("admin");
            memoDto.setUserName("관리자");
            memoDto.setTitle("테스트 제목 " + (i + 1));
            memoDto.setContents("테스트 컨텐츠 " + (i + 1));

            memoService.addMemo(memoDto);
        }
    }
}
