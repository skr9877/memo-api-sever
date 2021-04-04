package me.kimheesuk.memoapiserver.service;

import me.kimheesuk.memoapiserver.dto.MemoDto;
import me.kimheesuk.memoapiserver.jpa.domain.Memo;
import me.kimheesuk.memoapiserver.jpa.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MemoServiceImpl implements MemoService{
    @Autowired
    MemoRepository memoRepository;

    @Override
    public List<MemoDto> getMemoList() {
        return MemoDto.convertMemoEntityToDto(memoRepository.findAll());
    }

    @Override
    public MemoDto getMemo(Long memoId) {
        return MemoDto.convertMemoEntityToDto(memoRepository.findMemoById(memoId));
    }

    @Override
    public void addMemo(MemoDto memoDto) {
        memoRepository.save(MemoDto.convertMemoDtoToEntity(memoDto));
    }

    @Override
    public void editMemo(MemoDto memoDto) {
        memoRepository.setMemoByMemoId(memoDto.getId(), memoDto.getTitle(), memoDto.getContents(), LocalDateTime.now());
    }

    @Override
    public void deleteMemo(Long memoId) {
        memoRepository.deleteById(memoId);
    }


}
