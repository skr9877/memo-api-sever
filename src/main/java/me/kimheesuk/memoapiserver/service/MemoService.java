package me.kimheesuk.memoapiserver.service;

import me.kimheesuk.memoapiserver.dto.MemoDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemoService {
    List<MemoDto> getMemoList();

    MemoDto getMemo(Long memoId);

    void addMemo(MemoDto memoDto);

    void editMemo(MemoDto memoDto);

    void deleteMemo(Long memoId);
}
